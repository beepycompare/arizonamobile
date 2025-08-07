package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SingleOnErrorReturn.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0006"}, d2 = {"onErrorReturn", "Lru/rustore/sdk/reactive/single/Single;", ExifInterface.GPS_DIRECTION_TRUE, "mapper", "Lkotlin/Function1;", "", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleOnErrorReturnKt {
    public static final <T> Single<T> onErrorReturn(Single<T> single, Function1<? super Throwable, ? extends T> mapper) {
        Intrinsics.checkNotNullParameter(single, "<this>");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new SingleOnErrorReturn(single, mapper);
    }
}
