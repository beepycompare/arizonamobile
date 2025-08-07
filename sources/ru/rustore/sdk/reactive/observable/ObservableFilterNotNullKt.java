package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ObservableFilterNotNull.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001¨\u0006\u0003"}, d2 = {"filterNotNull", "Lru/rustore/sdk/reactive/observable/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ObservableFilterNotNullKt {
    public static final <T> Observable<T> filterNotNull(Observable<T> observable) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        return new ObservableFilterNotNull(observable);
    }
}
