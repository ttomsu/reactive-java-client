package com.google.cloud.asset.v1p5beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p5beta1.stub.AssetServiceStub;
import com.google.cloud.asset.v1p5beta1.stub.AssetServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AssetServiceReactiveClient implements BackgroundResource {

  private final AssetServiceReactiveSettings settings;
  private final AssetServiceStub stub;

  public static final AssetServiceReactiveClient create() throws IOException {
    return create(AssetServiceReactiveSettings.newBuilder().build());
  }

  public static final AssetServiceReactiveClient create(AssetServiceReactiveSettings settings) throws IOException {
    return new AssetServiceReactiveClient(settings);
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AssetServiceReactiveClient create(AssetServiceStub stub) {
    return new AssetServiceReactiveClient(stub);
  }

  protected AssetServiceReactiveClient(AssetServiceReactiveSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AssetServiceStubSettings)settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AssetServiceReactiveClient(AssetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AssetServiceReactiveSettings getSettings() {
    return this.settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AssetServiceStub getStub() {
    return this.stub;
  }

  public final AssetServiceReactiveClient.ListAssetsPagedResponse listAssets(ListAssetsRequest request) {
    return (AssetServiceReactiveClient.ListAssetsPagedResponse)this.listAssetsPagedCallable().call(request);
  }

  public final UnaryCallable<ListAssetsRequest, AssetServiceReactiveClient.ListAssetsPagedResponse> listAssetsPagedCallable() {
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

  public static class ListAssetsFixedSizeCollection extends
      AbstractFixedSizeCollection<ListAssetsRequest, ListAssetsResponse, Asset, AssetServiceReactiveClient.ListAssetsPage, AssetServiceReactiveClient.ListAssetsFixedSizeCollection> {
    private ListAssetsFixedSizeCollection(List<AssetServiceReactiveClient.ListAssetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AssetServiceReactiveClient.ListAssetsFixedSizeCollection createEmptyCollection() {
      return new AssetServiceReactiveClient.ListAssetsFixedSizeCollection((List)null, 0);
    }

    protected AssetServiceReactiveClient.ListAssetsFixedSizeCollection createCollection(List<AssetServiceReactiveClient.ListAssetsPage> pages, int collectionSize) {
      return new AssetServiceReactiveClient.ListAssetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAssetsPage extends
      AbstractPage<ListAssetsRequest, ListAssetsResponse, Asset, AssetServiceReactiveClient.ListAssetsPage> {
    private ListAssetsPage(PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context, ListAssetsResponse response) {
      super(context, response);
    }

    private static AssetServiceReactiveClient.ListAssetsPage createEmptyPage() {
      return new AssetServiceReactiveClient.ListAssetsPage((PageContext)null, (ListAssetsResponse)null);
    }

    protected AssetServiceReactiveClient.ListAssetsPage createPage(PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context, ListAssetsResponse response) {
      return new AssetServiceReactiveClient.ListAssetsPage(context, response);
    }

    public ApiFuture<AssetServiceReactiveClient.ListAssetsPage> createPageAsync(PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context, ApiFuture<ListAssetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAssetsPagedResponse extends
      AbstractPagedListResponse<ListAssetsRequest, ListAssetsResponse, Asset, AssetServiceReactiveClient.ListAssetsPage, AssetServiceReactiveClient.ListAssetsFixedSizeCollection> {
    public static ApiFuture<AssetServiceReactiveClient.ListAssetsPagedResponse> createAsync(PageContext<ListAssetsRequest, ListAssetsResponse, Asset> context, ApiFuture<ListAssetsResponse> futureResponse) {
      ApiFuture<AssetServiceReactiveClient.ListAssetsPage> futurePage = AssetServiceReactiveClient.ListAssetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(futurePage, new ApiFunction<AssetServiceReactiveClient.ListAssetsPage, AssetServiceReactiveClient.ListAssetsPagedResponse>() {
        public AssetServiceReactiveClient.ListAssetsPagedResponse apply(AssetServiceReactiveClient.ListAssetsPage input) {
          return new AssetServiceReactiveClient.ListAssetsPagedResponse(input);
        }
      }, MoreExecutors.directExecutor());
    }

    private ListAssetsPagedResponse(AssetServiceReactiveClient.ListAssetsPage page) {
      super(page, AssetServiceReactiveClient.ListAssetsFixedSizeCollection.createEmptyCollection());
    }
  }
}
