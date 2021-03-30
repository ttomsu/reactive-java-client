package com.google.cloud.logging.v2;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.api.MonitoredResource;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LogName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.WriteLogEntriesRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Flux;

public class LoggingReactiveClientTest {

  LoggingReactiveClient reactiveClient;

  @Before
  public void setup() throws IOException {
    this.reactiveClient = LoggingReactiveClient.create();
  }

  @Test
  public void testTail() {
    String projectId = "ttomsu-dev-spinnaker";
    LogName logName = LogName.of(projectId, "tail-test");
    Flux.interval(Duration.ofSeconds(1))
        .flatMap(i ->
          this.reactiveClient.writeLogEntries(WriteLogEntriesRequest.newBuilder()
              .setLogName(logName.toString())
              .setResource(MonitoredResource.newBuilder().setType("global").build())
              .putLabels("testing", i >= 20 ? "true" : "false")
              .addEntries(LogEntry.newBuilder()
                  .setTextPayload("Tick " + i).build())
              .build()))
        .take(40)
        .subscribe();

    Flux<List<String>> resourceFlux = Flux.just(
        Collections.singletonList(ProjectName.of(projectId).toString()));
    LogEntry lastEntry = this.reactiveClient
        .tailLogEntries(resourceFlux)
        .log()
        .take(15)
        .blockLast();

    assertThat(lastEntry).isNotNull();
  }
}
