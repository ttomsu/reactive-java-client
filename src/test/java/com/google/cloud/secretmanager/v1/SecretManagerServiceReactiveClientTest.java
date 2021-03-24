package com.google.cloud.secretmanager.v1;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;

public class SecretManagerServiceReactiveClientTest {

  SecretManagerServiceReactiveClient reactiveClient;

  @Before
  public void setup() throws IOException {
    this.reactiveClient = SecretManagerServiceReactiveClient.create();
  }

  @Test
  public void testLifecycle() {
    String projectId = "ttomsu-dev-spinnaker";
    String projectName = ProjectName.of(projectId).toString();
    String secretID = "my-secret-id-" + UUID.randomUUID();
    String secretValue = "p@$$w0rd";

    String result = this.reactiveClient
        .createSecret(projectName, secretID, Secret.newBuilder()
            .setReplication(
              Replication.newBuilder()
                .setAutomatic(Replication.Automatic.newBuilder().build())
              .build())
            .build())
        .flatMap(secret -> this.reactiveClient.addSecretVersion(secret.getName(),
            SecretPayload.newBuilder().setData(ByteString.copyFromUtf8(secretValue)).build()))
        .flatMap(secretVersion -> this.reactiveClient.accessSecretVersionPayload(secretVersion.getName()))
        .block();
    assertThat(result).isEqualTo(secretValue);

    SecretName sn = SecretName.of(projectId, secretID);
    this.reactiveClient.deleteSecret(sn.toString())
        .flatMap(unused -> this.reactiveClient.getSecret(sn.toString()))
        .onErrorContinue((throwable, o) -> assertThat(o).isNull())
        .block();
  }
}