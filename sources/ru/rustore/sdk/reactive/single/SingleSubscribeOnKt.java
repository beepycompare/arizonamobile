package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Dispatcher;
/* compiled from: SingleSubscribeOn.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"subscribeOn", "Lru/rustore/sdk/reactive/single/Single;", ExifInterface.GPS_DIRECTION_TRUE, "dispatcher", "Lru/rustore/sdk/reactive/core/Dispatcher;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleSubscribeOnKt {
    public static final <T> Single<T> subscribeOn(Single<T> single, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return new SingleSubscribeOn(single, dispatcher);
    }
}
