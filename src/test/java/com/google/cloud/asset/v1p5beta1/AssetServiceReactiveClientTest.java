package com.google.cloud.asset.v1p5beta1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class AssetServiceReactiveClientTest {

  AssetServiceClient blockingClient;
  AssetServiceReactiveClient reactiveClient;

  @Before
  public void setup() throws IOException {
    this.blockingClient = AssetServiceClient.create();
    this.reactiveClient = AssetServiceReactiveClient.create();
  }

  @Test
  public void testlistAssets() {
    Long count = this.reactiveClient
        .listAssets(ListAssetsRequest.newBuilder().setParent("projects/ttomsu-dev-spinnaker").build())
        .log()
        .count()
        .log()
        .block();
    assertThat(count).isCloseTo(1000, within(100L));
  }

  @Test
  public void testListAssetsBlocking() {
    // Single page call - should be of default page size (100).
    ListAssetsResponse resp = this.blockingClient.listAssetsCallable()
        .call(ListAssetsRequest.newBuilder().setParent("projects/ttomsu-dev-spinnaker").build());

    assertThat(resp).isNotNull();
    assertThat(resp.getAssetsList()).isNotEmpty().hasSize(100);
  }
}
