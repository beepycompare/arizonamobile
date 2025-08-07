package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SingleDoOnDispose.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/rustore/sdk/reactive/single/SingleDoOnDispose;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/single/Single;", "upstream", "onDispose", "Lkotlin/Function0;", "", "(Lru/rustore/sdk/reactive/single/Single;Lkotlin/jvm/functions/Function0;)V", "subscribe", "downstream", "Lru/rustore/sdk/reactive/single/SingleObserver;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SingleDoOnDispose<T> extends Single<T> {
    private final Function0<Unit> onDispose;
    private final Single<T> upstream;

    public SingleDoOnDispose(Single<T> upstream, Function0<Unit> onDispose) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        Intrinsics.checkNotNullParameter(onDispose, "onDispose");
        this.upstream = upstream;
        this.onDispose = onDispose;
    }

    @Override // ru.rustore.sdk.reactive.single.Single
    public void subscribe(SingleObserver<T> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        this.upstream.subscribe(new SingleDoOnDispose$subscribe$wrappedObserver$1(downstream, this));
    }
}
