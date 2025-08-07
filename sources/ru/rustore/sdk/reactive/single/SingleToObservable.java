package ru.rustore.sdk.reactive.single;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.observable.Observable;
import ru.rustore.sdk.reactive.observable.ObservableObserver;
/* compiled from: SingleToObservable.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/rustore/sdk/reactive/single/SingleToObservable;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/observable/Observable;", "upstream", "Lru/rustore/sdk/reactive/single/Single;", "(Lru/rustore/sdk/reactive/single/Single;)V", "subscribe", "", "downstream", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SingleToObservable<T> extends Observable<T> {
    private final Single<T> upstream;

    public SingleToObservable(Single<T> upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.upstream = upstream;
    }

    @Override // ru.rustore.sdk.reactive.observable.Observable
    public void subscribe(ObservableObserver<T> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        this.upstream.subscribe(new SingleToObservable$subscribe$wrappedDownstream$1(downstream));
    }
}
