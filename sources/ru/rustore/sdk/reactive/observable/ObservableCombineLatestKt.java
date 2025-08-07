package ru.rustore.sdk.reactive.observable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.reactive.backpressure.BackpressureStrategy;
/* compiled from: ObservableCombineLatest.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aZ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\t\u001at\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u00020\f\u001a\u008e\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072$\u0010\b\u001a \u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020\u000f\u001a¨\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r\"\u0004\b\u0004\u0010\u0010\"\u0004\b\u0005\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072*\u0010\b\u001a&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00020\u0012¨\u0006\u0013"}, d2 = {"combineLatest", "Lru/rustore/sdk/reactive/observable/Observable;", "R", "T1", "T2", "source2", "backpressureStrategy", "Lru/rustore/sdk/reactive/backpressure/BackpressureStrategy;", "mapper", "Lkotlin/Function2;", "T3", "source3", "Lkotlin/Function3;", "T4", "source4", "Lkotlin/Function4;", "T5", "source5", "Lkotlin/Function5;", "sdk-public-reactive_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ObservableCombineLatestKt {
    public static /* synthetic */ Observable combineLatest$default(Observable observable, Observable observable2, BackpressureStrategy backpressureStrategy, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            backpressureStrategy = new BackpressureStrategy.BufferDropLast(128);
        }
        return combineLatest(observable, observable2, backpressureStrategy, function2);
    }

    public static final <T1, T2, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> source2, BackpressureStrategy backpressureStrategy, final Function2<? super T1, ? super T2, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(source2, "source2");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return ObservableMapKt.map(new ObservableCombineLatest(new Observable[]{observable, source2}, backpressureStrategy), new Function1<Object[], R>() { // from class: ru.rustore.sdk.reactive.observable.ObservableCombineLatestKt$combineLatest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return mapper.invoke(it[0], it[1]);
            }
        });
    }

    public static /* synthetic */ Observable combineLatest$default(Observable observable, Observable observable2, Observable observable3, BackpressureStrategy backpressureStrategy, Function3 function3, int i, Object obj) {
        if ((i & 4) != 0) {
            backpressureStrategy = new BackpressureStrategy.BufferDropLast(128);
        }
        return combineLatest(observable, observable2, observable3, backpressureStrategy, function3);
    }

    public static final <T1, T2, T3, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> source2, Observable<T3> source3, BackpressureStrategy backpressureStrategy, final Function3<? super T1, ? super T2, ? super T3, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(source2, "source2");
        Intrinsics.checkNotNullParameter(source3, "source3");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return ObservableMapKt.map(new ObservableCombineLatest(new Observable[]{observable, source2, source3}, backpressureStrategy), new Function1<Object[], R>() { // from class: ru.rustore.sdk.reactive.observable.ObservableCombineLatestKt$combineLatest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return mapper.invoke(it[0], it[1], it[2]);
            }
        });
    }

    public static /* synthetic */ Observable combineLatest$default(Observable observable, Observable observable2, Observable observable3, Observable observable4, BackpressureStrategy backpressureStrategy, Function4 function4, int i, Object obj) {
        if ((i & 8) != 0) {
            backpressureStrategy = new BackpressureStrategy.BufferDropLast(128);
        }
        return combineLatest(observable, observable2, observable3, observable4, backpressureStrategy, function4);
    }

    public static final <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, BackpressureStrategy backpressureStrategy, final Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(source2, "source2");
        Intrinsics.checkNotNullParameter(source3, "source3");
        Intrinsics.checkNotNullParameter(source4, "source4");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return ObservableMapKt.map(new ObservableCombineLatest(new Observable[]{observable, source2, source3, source4}, backpressureStrategy), new Function1<Object[], R>() { // from class: ru.rustore.sdk.reactive.observable.ObservableCombineLatestKt$combineLatest$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return mapper.invoke(it[0], it[1], it[2], it[3]);
            }
        });
    }

    public static /* synthetic */ Observable combineLatest$default(Observable observable, Observable observable2, Observable observable3, Observable observable4, Observable observable5, BackpressureStrategy backpressureStrategy, Function5 function5, int i, Object obj) {
        if ((i & 16) != 0) {
            backpressureStrategy = new BackpressureStrategy.BufferDropLast(128);
        }
        return combineLatest(observable, observable2, observable3, observable4, observable5, backpressureStrategy, function5);
    }

    public static final <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> source2, Observable<T3> source3, Observable<T4> source4, Observable<T5> source5, BackpressureStrategy backpressureStrategy, final Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> mapper) {
        Intrinsics.checkNotNullParameter(observable, "<this>");
        Intrinsics.checkNotNullParameter(source2, "source2");
        Intrinsics.checkNotNullParameter(source3, "source3");
        Intrinsics.checkNotNullParameter(source4, "source4");
        Intrinsics.checkNotNullParameter(source5, "source5");
        Intrinsics.checkNotNullParameter(backpressureStrategy, "backpressureStrategy");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return ObservableMapKt.map(new ObservableCombineLatest(new Observable[]{observable, source2, source3, source4, source5}, backpressureStrategy), new Function1<Object[], R>() { // from class: ru.rustore.sdk.reactive.observable.ObservableCombineLatestKt$combineLatest$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return mapper.invoke(it[0], it[1], it[2], it[3], it[4]);
            }
        });
    }
}
