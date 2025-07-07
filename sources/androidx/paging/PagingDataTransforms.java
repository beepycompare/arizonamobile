package androidx.paging;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
@Metadata(d1 = {"androidx/paging/PagingDataTransforms__PagingDataTransformsKt", "androidx/paging/PagingDataTransforms__PagingDataTransforms_jvmKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PagingDataTransforms {
    public static final <T> PagingData<T> filter(PagingData<T> pagingData, Executor executor, Function1<? super T, Boolean> function1) {
        return PagingDataTransforms__PagingDataTransforms_jvmKt.filter(pagingData, executor, function1);
    }

    public static final <T, R> PagingData<R> flatMap(PagingData<T> pagingData, Executor executor, Function1<? super T, ? extends Iterable<? extends R>> function1) {
        return PagingDataTransforms__PagingDataTransforms_jvmKt.flatMap(pagingData, executor, function1);
    }

    public static final <T> PagingData<T> insertFooterItem(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, T t) {
        return PagingDataTransforms__PagingDataTransformsKt.insertFooterItem(pagingData, terminalSeparatorType, t);
    }

    public static final <T> PagingData<T> insertFooterItem(PagingData<T> pagingData, T t) {
        return PagingDataTransforms__PagingDataTransformsKt.insertFooterItem(pagingData, t);
    }

    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, T t) {
        return PagingDataTransforms__PagingDataTransformsKt.insertHeaderItem(pagingData, terminalSeparatorType, t);
    }

    public static final <T> PagingData<T> insertHeaderItem(PagingData<T> pagingData, T t) {
        return PagingDataTransforms__PagingDataTransformsKt.insertHeaderItem(pagingData, t);
    }

    public static final <R, T extends R> PagingData<R> insertSeparators(PagingData<T> pagingData, TerminalSeparatorType terminalSeparatorType, Executor executor, Function2<? super T, ? super T, ? extends R> function2) {
        return PagingDataTransforms__PagingDataTransforms_jvmKt.insertSeparators(pagingData, terminalSeparatorType, executor, function2);
    }

    public static final <R, T extends R> PagingData<R> insertSeparators(PagingData<T> pagingData, Executor executor, Function2<? super T, ? super T, ? extends R> function2) {
        return PagingDataTransforms__PagingDataTransforms_jvmKt.insertSeparators(pagingData, executor, function2);
    }

    public static final <T, R> PagingData<R> map(PagingData<T> pagingData, Executor executor, Function1<? super T, ? extends R> function1) {
        return PagingDataTransforms__PagingDataTransforms_jvmKt.map(pagingData, executor, function1);
    }

    public static final <T, R> PagingData<R> transform(PagingData<T> pagingData, Function2<? super PageEvent<T>, ? super Continuation<? super PageEvent<R>>, ? extends Object> function2) {
        return PagingDataTransforms__PagingDataTransformsKt.transform(pagingData, function2);
    }
}
