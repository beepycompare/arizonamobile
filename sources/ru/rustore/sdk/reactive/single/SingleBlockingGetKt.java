package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import ru.rustore.sdk.reactive.core.Disposable;
/* compiled from: SingleBlockingGet.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"blockingGet", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/single/Single;", "(Lru/rustore/sdk/reactive/single/Single;)Ljava/lang/Object;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SingleBlockingGetKt {
    public static final <T> Object blockingGet(Single<T> single) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Disposable subscribe = SingleSubscribeKt.subscribe(single, new Function1<Throwable, Unit>() { // from class: ru.rustore.sdk.reactive.single.SingleBlockingGetKt$blockingGet$disposable$1
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

            /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.Result, T] */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Ref.ObjectRef<Result<T>> objectRef2 = objectRef;
                Result.Companion companion = Result.Companion;
                objectRef2.element = Result.m9182boximpl(Result.m9183constructorimpl(ResultKt.createFailure(error)));
                countDownLatch.countDown();
            }
        }, new Function1<T, Unit>() { // from class: ru.rustore.sdk.reactive.single.SingleBlockingGetKt$blockingGet$disposable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((SingleBlockingGetKt$blockingGet$disposable$2<T>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                Ref.ObjectRef<Result<T>> objectRef2 = objectRef;
                Result.Companion companion = Result.Companion;
                objectRef2.element = (T) Result.m9182boximpl(Result.m9183constructorimpl(t));
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            subscribe.dispose();
            T t = objectRef.element;
            if (t != null) {
                return ((Result) t).m9192unboximpl();
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        } catch (Throwable th) {
            subscribe.dispose();
            throw th;
        }
    }
}
