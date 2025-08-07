package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.core.Dispatcher;
/* compiled from: SingleObserveOn.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/rustore/sdk/reactive/single/SingleObserveOn;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/single/Single;", "upstream", "dispatcher", "Lru/rustore/sdk/reactive/core/Dispatcher;", "(Lru/rustore/sdk/reactive/single/Single;Lru/rustore/sdk/reactive/core/Dispatcher;)V", "subscribe", "", "downstream", "Lru/rustore/sdk/reactive/single/SingleObserver;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SingleObserveOn<T> extends Single<T> {
    private final Dispatcher dispatcher;
    private final Single<T> upstream;

    public SingleObserveOn(Single<T> upstream, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.upstream = upstream;
        this.dispatcher = dispatcher;
    }

    @Override // ru.rustore.sdk.reactive.single.Single
    public void subscribe(SingleObserver<T> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        this.upstream.subscribe(new SingleObserveOn$subscribe$wrappedObserver$1(this, downstream));
    }
}
