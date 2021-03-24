package com.google.cloud.asset.v1p5beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p5beta1.stub.AssetServiceStub;
import com.google.cloud.asset.v1p5beta1.stub.AssetServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AssetServiceReactiveClient implements BackgroundResource {

  private final AssetServiceSettings settings;
  private final AssetServiceStub stub;

  public static final AssetServiceReactiveClient create() throws IOException {
    return create(AssetServiceSettings.newBuilder().build());
  }

  public static final AssetServiceReactiveClient create(AssetServiceSettings settings) throws IOException {
    return new AssetServiceReactiveClient(settings);
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AssetServiceReactiveClient create(AssetServiceStub stub) {
    return new AssetServiceReactiveClient(stub);
  }

  protected AssetServiceReactiveClient(AssetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AssetServiceStubSettings)settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AssetServiceReactiveClient(AssetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AssetServiceSettings getSettings() {
    return this.settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AssetServiceStub getStub() {
    return this.stub;
  }

  public final AssetServiceClient.ListAssetsPagedResponse listAssets(ListAssetsRequest request) {
    return (AssetServiceClient.ListAssetsPagedResponse)this.listAssetsPagedCallable().call(request);
  }

  public final UnaryCallable<ListAssetsRequest, AssetServiceClient.ListAssetsPagedResponse> listAssetsPagedCallable() {
    return this.stub.listAssetsPagedCallable();
  }

  public final UnaryCallable<ListAssetsRequest, ListAssetsResponse> listAssetsCallable() {
    return this.stub.listAssetsCallable();
  }

  public final void close() {
    this.stub.close();
  }

  public void shutdown() {
    this.stub.shutdown();
  }

  public boolean isShutdown() {
    return this.stub.isShutdown();
  }

  public boolean isTerminated() {
    return this.stub.isTerminated();
  }

  public void shutdownNow() {
    this.stub.shutdownNow();
  }

  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return this.stub.awaitTermination(duration, unit);
  }
}
