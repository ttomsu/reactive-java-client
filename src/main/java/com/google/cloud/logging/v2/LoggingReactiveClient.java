package com.google.cloud.logging.v2;

import static com.google.cloud.reactive.util.Converters.toMono;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.logging.v2.stub.LoggingServiceV2Stub;
import com.google.cloud.logging.v2.stub.LoggingServiceV2StubSettings;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class LoggingReactiveClient implements BackgroundResource {
  private final LoggingSettings settings;
  private final LoggingServiceV2Stub stub;
  private final ScheduledExecutorService executorService;


  public static final LoggingReactiveClient create() throws IOException {
    return create(LoggingSettings.newBuilder().build());
  }


  public static final LoggingReactiveClient create(LoggingSettings settings) throws IOException {
    return new LoggingReactiveClient(settings);
  }


  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final LoggingReactiveClient create(LoggingServiceV2Stub stub) {
    return new LoggingReactiveClient(stub);
  }

  protected LoggingReactiveClient(LoggingSettings settings) throws IOException {
    this.settings = settings;
    this.executorService = settings.getExecutorProvider().getExecutor();
    this.stub = ((LoggingServiceV2StubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected LoggingReactiveClient(LoggingServiceV2Stub stub) {
    this.settings = null;
    this.executorService = null;
    this.stub = stub;
  }

  public final LoggingSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public LoggingServiceV2Stub getStub() {
    return stub;
  }

  // --------------------------------

  public final Mono<WriteLogEntriesResponse> writeLogEntries(WriteLogEntriesRequest request) {
    return toMono(() -> writeLogEntriesCallable().futureCall(request), this.executorService);
  }

  public final UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse> writeLogEntriesCallable() {
    return stub.writeLogEntriesCallable();
  }


  public final Flux<LogEntry> tailLogEntries(Flux<List<String>> resourceFlux) {
    return Flux.create(sink -> {
      ClientStream<TailLogEntriesRequest> clientStream = tailLogEntriesCallable()
          .splitCall(new ResponseObserver<TailLogEntriesResponse>() {
            @Override
            public void onStart(StreamController controller) {
            }

            @Override
            public void onResponse(TailLogEntriesResponse response) {
              for (LogEntry le : response.getEntriesList()) {
                sink.next(le);
              }
            }

            @Override
            public void onError(Throwable t) {
              sink.error(t);
            }

            @Override
            public void onComplete() {
              sink.complete();
            }
          });
      sink.onCancel(clientStream::closeSend);

      resourceFlux
          .log()
          .subscribe(resourceNames -> clientStream.send(TailLogEntriesRequest.newBuilder()
              .addAllResourceNames(resourceNames)
              .build()));
    });
  }


  public final BidiStreamingCallable<TailLogEntriesRequest, TailLogEntriesResponse>
  tailLogEntriesCallable() {
    return stub.tailLogEntriesCallable();
  }

  // --------------------------------


  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
