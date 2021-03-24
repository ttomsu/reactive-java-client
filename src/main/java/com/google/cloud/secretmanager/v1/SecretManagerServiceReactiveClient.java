package com.google.cloud.secretmanager.v1;

import static com.google.cloud.reactive.util.Converters.toMono;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.secretmanager.v1.stub.SecretManagerServiceStub;
import com.google.cloud.secretmanager.v1.stub.SecretManagerServiceStubSettings;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import reactor.core.publisher.Mono;

public class SecretManagerServiceReactiveClient implements BackgroundResource {

  private final SecretManagerServiceSettings settings;
  private final SecretManagerServiceStub stub;

  public static final SecretManagerServiceReactiveClient create() throws IOException {
    return create(SecretManagerServiceSettings.newBuilder().build());
  }

  public static final SecretManagerServiceReactiveClient create(SecretManagerServiceSettings settings) throws IOException {
    return new SecretManagerServiceReactiveClient(settings);
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final SecretManagerServiceReactiveClient create(SecretManagerServiceStub stub) {
    return new SecretManagerServiceReactiveClient(stub);
  }

  protected SecretManagerServiceReactiveClient(SecretManagerServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((SecretManagerServiceStubSettings)settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected SecretManagerServiceReactiveClient(SecretManagerServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final SecretManagerServiceSettings getSettings() {
    return this.settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public SecretManagerServiceStub getStub() {
    return this.stub;
  }

  // -----------------------

  public final Mono<Secret> createSecret(String parent, String secretId, Secret secret) {
    CreateSecretRequest request =
        CreateSecretRequest.newBuilder()
            .setParent(parent)
            .setSecretId(secretId)
            .setSecret(secret)
            .build();
    return createSecret(request);
  }
  public final Mono<Secret> createSecret(CreateSecretRequest request) {
    return toMono(() -> createSecretCallable().futureCall(request), this.settings);
  }

  public final UnaryCallable<CreateSecretRequest, Secret> createSecretCallable() {
    return stub.createSecretCallable();
  }

  public final Mono<Secret> getSecret(String name) {
    GetSecretRequest request = GetSecretRequest.newBuilder().setName(name).build();
    return getSecret(request);
  }

  public final Mono<Secret> getSecret(GetSecretRequest request) {
    return toMono(() -> this.getSecretCallable().futureCall(request), this.settings);
  }

  public final UnaryCallable<GetSecretRequest, Secret> getSecretCallable() {
    return stub.getSecretCallable();
  }

  public final Mono<Secret> updateSecret(Secret secret, FieldMask updateMask) {
    UpdateSecretRequest request =
        UpdateSecretRequest.newBuilder().setSecret(secret).setUpdateMask(updateMask).build();
    return updateSecret(request);
  }

  public final Mono<Secret> updateSecret(UpdateSecretRequest request) {
    return toMono(() -> this.updateSecretCallable().futureCall(request), this.settings);
  }

  public final UnaryCallable<UpdateSecretRequest, Secret> updateSecretCallable() {
    return stub.updateSecretCallable();
  }

  public final Mono<Empty> deleteSecret(String name) {
    DeleteSecretRequest request = DeleteSecretRequest.newBuilder().setName(name).build();
    return deleteSecret(request);
  }

  public final Mono<Empty> deleteSecret(DeleteSecretRequest request) {
    return toMono(() -> deleteSecretCallable().futureCall(request), this.settings);
  }

  public final UnaryCallable<DeleteSecretRequest, Empty> deleteSecretCallable() {
    return stub.deleteSecretCallable();
  }

  // -----------------------

  public final Mono<AccessSecretVersionResponse> accessSecretVersion(String name) {
    AccessSecretVersionRequest request =
        AccessSecretVersionRequest.newBuilder().setName(name).build();
    return accessSecretVersion(request);
  }

  public final Mono<String> accessSecretVersionPayload(String name) {
    AccessSecretVersionRequest request =
        AccessSecretVersionRequest.newBuilder().setName(name).build();
    return accessSecretVersion(request).map(resp -> resp.getPayload().getData().toStringUtf8());
  }

  public final Mono<AccessSecretVersionResponse> accessSecretVersion(AccessSecretVersionRequest request) {
    return toMono(() -> accessSecretVersionCallable().futureCall(request), this.settings);
  }

  public final UnaryCallable<AccessSecretVersionRequest, AccessSecretVersionResponse>
    accessSecretVersionCallable() {
    return stub.accessSecretVersionCallable();
  }

  public final Mono<SecretVersion> addSecretVersion(SecretName parent, SecretPayload payload) {
    AddSecretVersionRequest request =
        AddSecretVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPayload(payload)
            .build();
    return addSecretVersion(request);
  }

  public final Mono<SecretVersion> addSecretVersion(String parent, SecretPayload payload) {
    AddSecretVersionRequest request =
        AddSecretVersionRequest.newBuilder().setParent(parent).setPayload(payload).build();
    return addSecretVersion(request);
  }

  public final Mono<SecretVersion> addSecretVersion(AddSecretVersionRequest request) {
    return toMono(() -> addSecretVersionCallable().futureCall(request), this.settings);
  }

  public final UnaryCallable<AddSecretVersionRequest, SecretVersion> addSecretVersionCallable() {
    return stub.addSecretVersionCallable();
  }

  // -----------------------

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
