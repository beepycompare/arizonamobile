package ru.rustore.sdk.reactive.single;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Disposable;
import ru.rustore.sdk.reactive.single.SingleFlatMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleFlatMap.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001\fB-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/rustore/sdk/reactive/single/SingleFlatMap;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lru/rustore/sdk/reactive/single/Single;", "upstream", "mapper", "Lkotlin/Function1;", "(Lru/rustore/sdk/reactive/single/Single;Lkotlin/jvm/functions/Function1;)V", "subscribe", "", "downstream", "Lru/rustore/sdk/reactive/single/SingleObserver;", "SingleFlatMapSubscriber", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SingleFlatMap<T, R> extends Single<R> {
    private final Function1<T, Single<R>> mapper;
    private final Single<T> upstream;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleFlatMap(Single<T> upstream, Function1<? super T, ? extends Single<R>> mapper) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.upstream = upstream;
        this.mapper = mapper;
    }

    @Override // ru.rustore.sdk.reactive.single.Single
    public void subscribe(SingleObserver<R> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        this.upstream.subscribe(new SingleFlatMap$subscribe$wrappedObserver$1(downstream, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SingleFlatMap.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J!\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/rustore/sdk/reactive/single/SingleFlatMap$SingleFlatMapSubscriber;", "Lru/rustore/sdk/reactive/core/Disposable;", "(Lru/rustore/sdk/reactive/single/SingleFlatMap;)V", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "upstreamDisposable", "Ljava/util/concurrent/atomic/AtomicReference;", "dispose", "", "isDisposed", "", "subscribe", "downstream", "Lru/rustore/sdk/reactive/single/SingleObserver;", "item", "(Lru/rustore/sdk/reactive/single/SingleObserver;Ljava/lang/Object;)V", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class SingleFlatMapSubscriber implements Disposable {
        private final AtomicBoolean disposed = new AtomicBoolean();
        private final AtomicReference<Disposable> upstreamDisposable = new AtomicReference<>(null);

        public SingleFlatMapSubscriber() {
        }

        public final void subscribe(final SingleObserver<R> downstream, T t) {
            Object m9902constructorimpl;
            Intrinsics.checkNotNullParameter(downstream, "downstream");
            SingleObserver<R> singleObserver = new SingleObserver<R>(this) { // from class: ru.rustore.sdk.reactive.single.SingleFlatMap$SingleFlatMapSubscriber$subscribe$singleFlatMapObserver$1
                final /* synthetic */ SingleFlatMap<T, R>.SingleFlatMapSubscriber this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                }

                @Override // ru.rustore.sdk.reactive.single.SingleObserver
                public void onSubscribe(Disposable d) {
                    AtomicReference atomicReference;
                    AtomicReference atomicReference2;
                    Intrinsics.checkNotNullParameter(d, "d");
                    atomicReference = ((SingleFlatMap.SingleFlatMapSubscriber) this.this$0).upstreamDisposable;
                    MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, d);
                    if (this.this$0.isDisposed()) {
                        atomicReference2 = ((SingleFlatMap.SingleFlatMapSubscriber) this.this$0).upstreamDisposable;
                        Disposable disposable = (Disposable) atomicReference2.getAndSet(null);
                        if (disposable != null) {
                            disposable.dispose();
                        }
                    }
                }

                @Override // ru.rustore.sdk.reactive.single.SingleObserver
                public void onError(Throwable e) {
                    AtomicBoolean atomicBoolean;
                    Intrinsics.checkNotNullParameter(e, "e");
                    atomicBoolean = ((SingleFlatMap.SingleFlatMapSubscriber) this.this$0).disposed;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        downstream.onError(e);
                    }
                }

                @Override // ru.rustore.sdk.reactive.single.SingleObserver
                public void onSuccess(R r) {
                    AtomicBoolean atomicBoolean;
                    atomicBoolean = ((SingleFlatMap.SingleFlatMapSubscriber) this.this$0).disposed;
                    if (atomicBoolean.compareAndSet(false, true)) {
                        downstream.onSuccess(r);
                    }
                }
            };
            if (isDisposed()) {
                return;
            }
            SingleFlatMap<T, R> singleFlatMap = SingleFlatMap.this;
            try {
                Result.Companion companion = Result.Companion;
                SingleFlatMapSubscriber singleFlatMapSubscriber = this;
                m9902constructorimpl = Result.m9902constructorimpl((Single) ((SingleFlatMap) singleFlatMap).mapper.invoke(t));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9902constructorimpl = Result.m9902constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m9909isSuccessimpl(m9902constructorimpl)) {
                Single single = (Single) m9902constructorimpl;
                if (!isDisposed()) {
                    single.subscribe(singleObserver);
                }
            }
            Throwable m9905exceptionOrNullimpl = Result.m9905exceptionOrNullimpl(m9902constructorimpl);
            if (m9905exceptionOrNullimpl == null || isDisposed()) {
                return;
            }
            singleObserver.onError(m9905exceptionOrNullimpl);
        }

        @Override // ru.rustore.sdk.reactive.core.Disposable
        public boolean isDisposed() {
            return this.disposed.get();
        }

        @Override // ru.rustore.sdk.reactive.core.Disposable
        public void dispose() {
            Disposable andSet;
            if (!this.disposed.compareAndSet(false, true) || (andSet = this.upstreamDisposable.getAndSet(null)) == null) {
                return;
            }
            andSet.dispose();
        }
    }
}
