package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ru.rustore.sdk.reactive.core.Disposable;
/* compiled from: ObservableBlockingFirst.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"blockingFirst", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/observable/Observable;", "(Lru/rustore/sdk/reactive/observable/Observable;)Ljava/lang/Object;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObservableBlockingFirstKt {
    public static final <T> Object blockingFirst(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Disposable subscribe = ObservableSubscribeKt.subscribe(observable, new Function1<Throwable, Unit>() { // from class: ru.rustore.sdk.reactive.observable.ObservableBlockingFirstKt$blockingFirst$disposable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r4v3, types: [kotlin.Result, T] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (atomicBoolean.compareAndSet(false, true)) {
                    Ref.ObjectRef<Result<T>> objectRef2 = objectRef;
                    Result.Companion companion = Result.Companion;
                    objectRef2.element = Result.m9105boximpl(Result.m9106constructorimpl(ResultKt.createFailure(error)));
                    countDownLatch.countDown();
                }
            }
        }, new Function0<Unit>() { // from class: ru.rustore.sdk.reactive.observable.ObservableBlockingFirstKt$blockingFirst$disposable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v6, types: [kotlin.Result, T] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    Ref.ObjectRef<Result<T>> objectRef2 = objectRef;
                    Result.Companion companion = Result.Companion;
                    objectRef2.element = Result.m9105boximpl(Result.m9106constructorimpl(ResultKt.createFailure(new IllegalStateException("onComplete() called before value was received in blockingFirst()"))));
                    countDownLatch.countDown();
                }
            }
        }, new Function1<T, Unit>() { // from class: ru.rustore.sdk.reactive.observable.ObservableBlockingFirstKt$blockingFirst$disposable$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((ObservableBlockingFirstKt$blockingFirst$disposable$3<T>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                if (atomicBoolean.compareAndSet(false, true)) {
                    Ref.ObjectRef<Result<T>> objectRef2 = objectRef;
                    Result.Companion companion = Result.Companion;
                    objectRef2.element = (T) Result.m9105boximpl(Result.m9106constructorimpl(t));
                    countDownLatch.countDown();
                }
            }
        });
        try {
            countDownLatch.await();
            subscribe.dispose();
            T t = objectRef.element;
            if (t != null) {
                return ((Result) t).m9115unboximpl();
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Throwable th) {
            subscribe.dispose();
            throw th;
        }
    }
}
