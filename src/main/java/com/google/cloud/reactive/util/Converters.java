package com.google.cloud.reactive.util;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.gax.paging.Page;
import com.google.api.gax.paging.PagedListResponse;
import com.google.api.gax.rpc.ClientSettings;
import com.google.protobuf.Empty;
import java.util.function.Supplier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Converters {
  public static <T> Mono<T> toMono(Supplier<ApiFuture<T>> supplier, ClientSettings<?> settings) {
    return Mono.create(sink -> {
      ApiFuture<T> f = supplier.get();
      sink.onCancel(() -> f.cancel(true));
      ApiFutures.addCallback(f, new ApiFutureCallback<T>() {
        @Override
        public void onFailure(Throwable t) {
          sink.error(t);
        }

        @Override
        public void onSuccess(T result) {
          sink.success(result);
        }
      }, settings.getExecutorProvider().getExecutor());
    });
  }

  // public static Mono<Empty> toMonoEmpty(Supplier<ApiFuture<Empty>> supplier, ClientSettings<?> settings) {
  //   return toMono(supplier, settings).map(empty -> Mono.empty());
  // }

  public static <T, R extends PagedListResponse<T>> Flux<Page<T>> toPagesFlux(Supplier<ApiFuture<R>> supplier, ClientSettings<?> settings) {
    return Flux.create(sink -> {
      ApiFuture<R> f = supplier.get();
      sink.onCancel(() -> f.cancel(true));
      ApiFutures.addCallback(f, new ApiFutureCallback<R>() {
        @Override
        public void onFailure(Throwable t) {
          sink.error(t);
        }

        @Override
        public void onSuccess(R result) {
          for (Page<T> p : result.iteratePages()) {
            sink.next(p);
          }
          sink.complete();
        }
      }, settings.getExecutorProvider().getExecutor());
    });
  }

  public static <T, R extends PagedListResponse<T>> Flux<T> toItemsFlux(Supplier<ApiFuture<R>> supplier, ClientSettings<?> settings) {
    return Flux.create(sink -> {
      ApiFuture<R> f = supplier.get();
      sink.onCancel(() -> f.cancel(true));
      ApiFutures.addCallback(f, new ApiFutureCallback<R>() {
        @Override
        public void onFailure(Throwable t) {
          sink.error(t);
        }

        @Override
        public void onSuccess(R result) {
          for (T t : result.iterateAll()) {
            sink.next(t);
          }
          sink.complete();
        }
      }, settings.getExecutorProvider().getExecutor());
    });
  }
}
