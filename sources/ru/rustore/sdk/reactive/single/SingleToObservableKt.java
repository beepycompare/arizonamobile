package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.observable.Observable;
/* compiled from: SingleToObservable.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, d2 = {"toObservable", "Lru/rustore/sdk/reactive/observable/Observable;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/single/Single;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleToObservableKt {
    public static final <T> Observable<T> toObservable(Single<T> single) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        return new SingleToObservable(single);
    }
}
