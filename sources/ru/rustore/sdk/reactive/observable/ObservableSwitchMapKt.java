package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
/* compiled from: ObservableSwitchMap.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007¨\u0006\b"}, d2 = {"switchMap", "Lru/rustore/sdk/reactive/observable/Observable;", "R", ExifInterface.GPS_DIRECTION_TRUE, "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "mapper", "Lkotlin/Function1;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ObservableSwitchMapKt {
    public static /* synthetic */ Observable switchMap$default(Observable observable, BackpressureStrategy backpressureStrategy, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            backpressureStrategy = new BackpressureStrategy.BufferDropLast(128);
        }
        return switchMap(observable, backpressureStrategy, function1);
    }

    public static final <T, R> Observable<R> switchMap(Observable<T> observable, BackpressureStrategy backpressureStrategy, Function1<? super T, ? extends Observable<R>> mapper) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new ObservableSwitchMap(observable, mapper, backpressureStrategy);
    }
}
