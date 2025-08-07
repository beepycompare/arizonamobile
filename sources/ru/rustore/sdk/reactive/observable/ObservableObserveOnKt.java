package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
import ru.rustore.sdk.reactive.core.Dispatcher;
/* compiled from: ObservableObserveOn.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"observeOn", "Lru/rustore/sdk/reactive/observable/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "dispatcher", "Lru/rustore/sdk/reactive/core/Dispatcher;", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ObservableObserveOnKt {
    public static /* synthetic */ Observable observeOn$default(Observable observable, Dispatcher dispatcher, BackpressureStrategy backpressureStrategy, int i, Object obj) {
        if ((i & 2) != 0) {
            backpressureStrategy = new BackpressureStrategy.BufferDropLast(128);
        }
        return observeOn(observable, dispatcher, backpressureStrategy);
    }

    public static final <T> Observable<T> observeOn(Observable<T> observable, Dispatcher dispatcher, BackpressureStrategy backpressureStrategy) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        return new ObservableObserveOn(observable, dispatcher, backpressureStrategy);
    }
}
