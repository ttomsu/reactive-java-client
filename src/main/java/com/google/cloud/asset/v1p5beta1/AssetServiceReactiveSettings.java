package com.google.cloud.asset.v1p5beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.asset.v1p5beta1.AssetServiceClient.ListAssetsPagedResponse;
import com.google.cloud.asset.v1p5beta1.stub.AssetServiceStubSettings;
import java.io.IOException;
import java.util.List;

public class AssetServiceReactiveSettings extends ClientSettings<AssetServiceReactiveSettings> {

  public PagedCallSettings<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse> listAssetsSettings() {
    return ((AssetServiceStubSettings)this.getStubSettings()).listAssetsSettings();
  }

  public static final AssetServiceReactiveSettings create(AssetServiceStubSettings stub) throws IOException {
    return (new AssetServiceReactiveSettings.Builder(stub.toBuilder())).build();
  }

  public static com.google.api.gax.core.InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AssetServiceStubSettings.defaultExecutorProviderBuilder();
  }

  public static String getDefaultEndpoint() {
    return AssetServiceStubSettings.getDefaultEndpoint();
  }

  public static List<String> getDefaultServiceScopes() {
    return AssetServiceStubSettings.getDefaultServiceScopes();
  }

  public static com.google.api.gax.core.GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AssetServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  public static com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AssetServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AssetServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static com.google.api.gax.rpc.ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AssetServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  public static AssetServiceReactiveSettings.Builder newBuilder() {
    return AssetServiceReactiveSettings.Builder.createDefault();
  }

  public static AssetServiceReactiveSettings.Builder newBuilder(ClientContext clientContext) {
    return new AssetServiceReactiveSettings.Builder(clientContext);
  }

  public AssetServiceReactiveSettings.Builder toBuilder() {
    return new AssetServiceReactiveSettings.Builder(this);
  }

  protected AssetServiceReactiveSettings(AssetServiceReactiveSettings.Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  public static class Builder extends com.google.api.gax.rpc.ClientSettings.Builder<AssetServiceReactiveSettings, AssetServiceReactiveSettings.Builder> {
    protected Builder() throws IOException {
      this((ClientContext)null);
    }

    protected Builder(ClientContext clientContext) {
      super(AssetServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AssetServiceReactiveSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(com.google.cloud.asset.v1p5beta1.stub.AssetServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static AssetServiceReactiveSettings.Builder createDefault() {
      return new AssetServiceReactiveSettings.Builder(AssetServiceStubSettings.newBuilder());
    }

    public com.google.cloud.asset.v1p5beta1.stub.AssetServiceStubSettings.Builder getStubSettingsBuilder() {
      return (com.google.cloud.asset.v1p5beta1.stub.AssetServiceStubSettings.Builder)this.getStubSettings();
    }

    public AssetServiceReactiveSettings.Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      com.google.api.gax.rpc.ClientSettings.Builder.applyToAllUnaryMethods(this.getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    public com.google.api.gax.rpc.PagedCallSettings.Builder<ListAssetsRequest, ListAssetsResponse, ListAssetsPagedResponse> listAssetsSettings() {
      return this.getStubSettingsBuilder().listAssetsSettings();
    }

    public AssetServiceReactiveSettings build() throws IOException {
      return new AssetServiceReactiveSettings(this);
    }
  }
}
