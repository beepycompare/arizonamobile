package ru.rustore.sdk.reactive.observable;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
/* compiled from: ObservableCombineLatest.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B#\u0012\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0002X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, d2 = {"Lru/rustore/sdk/reactive/observable/ObservableCombineLatest;", "Lru/rustore/sdk/reactive/observable/Observable;", "", "", "sources", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "([Lru/rustore/sdk/reactive/observable/Observable;Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;)V", "[Lru/rustore/sdk/reactive/observable/Observable;", "subscribe", "", "downstream", "Lru/rustore/sdk/reactive/observable/ObservableObserver;", "sdk-public-reactive_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
final class ObservableCombineLatest extends Observable<Object[]> {
    private final BackpressureStrategy backpressureStrategy;
    private final Observable<Object>[] sources;

    public ObservableCombineLatest(Observable<Object>[] sources, BackpressureStrategy backpressureStrategy) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        this.sources = sources;
        this.backpressureStrategy = backpressureStrategy;
    }

    @Override // ru.rustore.sdk.reactive.observable.Observable
    public void subscribe(ObservableObserver<Object[]> downstream) {
        Intrinsics.checkNotNullParameter(downstream, "downstream");
        CombineCollector combineCollector = new CombineCollector(this.sources.length, downstream, this.backpressureStrategy);
        Observable<Object>[] observableArr = this.sources;
        int length = observableArr.length;
        int i = 0;
        final int i2 = 0;
        while (i < length) {
            ObservableMapKt.map(observableArr[i], new Function1<Object, Pair<? extends Integer, ? extends Object>>() { // from class: ru.rustore.sdk.reactive.observable.ObservableCombineLatest$subscribe$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Pair<? extends Integer, ? extends Object> invoke(Object obj) {
                    return TuplesKt.to(Integer.valueOf(i2), obj);
                }
            }).subscribe(combineCollector);
            i++;
            i2++;
        }
    }
}
