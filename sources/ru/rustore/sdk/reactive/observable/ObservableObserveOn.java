package ru.rustore.sdk.reactive.observable;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
import ru.rustore.sdk.reactive.backpressure.processor.BufferEmitProcessorFactoryKt;
import ru.rustore.sdk.reactive.core.Dispatcher;
/* compiled from: ObservableObserveOn.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/rustore/sdk/reactive/observable/ObservableObserveOn;", ExifInterface.GPS_DIRECTION_TRUE, "Lru/rustore/sdk/reactive/observable/Observable;", "upstream", "dispatcher", "Lru/rustore/sdk/reactive/core/Dispatcher;", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "(Lru/rustore/sdk/reactive/observable/Observable;Lru/rustore/sdk/reactive/core/Dispatcher;Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;)V", "subscribe", "", "downstream", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
final class ObservableObserveOn<T> extends Observable<T> {
    private final BackpressureStrategy backpressureStrategy;
    private final Dispatcher dispatcher;
    private final Observable<T> upstream;

    public ObservableObserveOn(Observable<T> upstream, Dispatcher dispatcher, BackpressureStrategy backpressureStrategy) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        this.upstream = upstream;
        this.dispatcher = dispatcher;
        this.backpressureStrategy = backpressureStrategy;
    }

    @Override // ru.rustore.sdk.reactive.observable.Observable
    public void subscribe(ObservableObserver<T> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        this.upstream.subscribe(new ObservableObserveOn$subscribe$wrappedDownstream$1(downstream, BufferEmitProcessorFactoryKt.createBufferEmitProcessor(this.backpressureStrategy, downstream, this.dispatcher)));
    }
}
