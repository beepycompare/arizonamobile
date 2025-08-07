package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Dispatcher;
import ru.rustore.sdk.reactive.core.Dispatchers;
/* compiled from: SingleDelay.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"delay", "Lru/rustore/sdk/reactive/single/Single;", ExifInterface.GPS_DIRECTION_TRUE, "", "dispatcher", "Lru/rustore/sdk/reactive/core/Dispatcher;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleDelayKt {
    public static /* synthetic */ Single delay$default(Single single, long j, Dispatcher dispatcher, int i, Object obj) {
        if ((i & 2) != 0) {
            dispatcher = Dispatchers.INSTANCE.getIo();
        }
        return delay(single, j, dispatcher);
    }

    public static final <T> Single<T> delay(Single<T> single, final long j, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return SingleDoOnSuccessKt.doOnSuccess(SingleObserveOnKt.observeOn(single, dispatcher), new Function1<T, Unit>() { // from class: ru.rustore.sdk.reactive.single.SingleDelayKt$delay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2((SingleDelayKt$delay$1<T>) obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(T t) {
                Thread.sleep(j);
            }
        });
    }
}
