package com.google.cloud.asset.v1p5beta1;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class AssetServiceReactiveClientTest {

  AssetServiceReactiveClient client;

  @Before
  public void setup() throws IOException {
    this.client = AssetServiceReactiveClient.create();
  }

  @Test
  public void testlistAssets() {
    // this.client.listAssets().log().count().log().subscribe();
  }
}