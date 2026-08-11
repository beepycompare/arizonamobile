package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
/* compiled from: PositionalDataSource.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000 ,*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003:\u0005()*+,B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0080@¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00020\u000eH\u0081@¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\t\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J\u001e\u0010\r\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H'J\u001e\u0010\u0011\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H'J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001f\u0010 J6\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0\u0000\"\b\b\u0001\u0010\"*\u00020\u00022\u001e\u0010#\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000%\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0%0$J6\u0010!\u001a\b\u0012\u0004\u0012\u0002H\"0\u0000\"\b\b\u0001\u0010\"*\u00020\u00022\u001e\u0010#\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000%\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\"0%0&J*\u0010'\u001a\b\u0012\u0004\u0012\u0002H\"0\u0000\"\b\b\u0001\u0010\"*\u00020\u00022\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\"0$J*\u0010'\u001a\b\u0012\u0004\u0012\u0002H\"0\u0000\"\b\b\u0001\u0010\"*\u00020\u00022\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\"0&R\u001a\u0010\u0018\u001a\u00020\u0019X\u0090D¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Landroidx/paging/PositionalDataSource;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/DataSource;", "", "<init>", "()V", "load", "Landroidx/paging/DataSource$BaseResult;", "params", "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadInitial", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "loadInitial$paging_common", "(Landroidx/paging/PositionalDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadRange", "Landroidx/paging/PositionalDataSource$LoadRangeParams;", "(Landroidx/paging/PositionalDataSource$LoadRangeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Landroidx/paging/PositionalDataSource$LoadInitialCallback;", "Landroidx/paging/PositionalDataSource$LoadRangeCallback;", "isContiguous", "", "isContiguous$paging_common$annotations", "isContiguous$paging_common", "()Z", "getKeyInternal", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Integer;", "mapByPage", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "function", "Landroidx/arch/core/util/Function;", "", "Lkotlin/Function1;", "map", "LoadInitialParams", "LoadRangeParams", "LoadInitialCallback", "LoadRangeCallback", "Companion", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(message = "PositionalDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Int, T>", imports = {"androidx.paging.PagingSource"}))
/* loaded from: classes3.dex */
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {
    public static final Companion Companion = new Companion(null);
    private final boolean isContiguous;

    /* compiled from: PositionalDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u001e\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "onResult", "", "data", "", "position", "", "totalCount", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadInitialCallback<T> {
        public abstract void onResult(List<? extends T> list, int i);

        public abstract void onResult(List<? extends T> list, int i, int i2);
    }

    /* compiled from: PositionalDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\bH&¨\u0006\t"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "onResult", "", "data", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadRangeCallback<T> {
        public abstract void onResult(List<? extends T> list);
    }

    @JvmStatic
    public static final int computeInitialLoadPosition(LoadInitialParams loadInitialParams, int i) {
        return Companion.computeInitialLoadPosition(loadInitialParams, i);
    }

    @JvmStatic
    public static final int computeInitialLoadSize(LoadInitialParams loadInitialParams, int i, int i2) {
        return Companion.computeInitialLoadSize(loadInitialParams, i, i2);
    }

    public static /* synthetic */ void isContiguous$paging_common$annotations() {
    }

    public abstract void loadInitial(LoadInitialParams loadInitialParams, LoadInitialCallback<T> loadInitialCallback);

    public abstract void loadRange(LoadRangeParams loadRangeParams, LoadRangeCallback<T> loadRangeCallback);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.paging.DataSource
    public /* bridge */ /* synthetic */ Integer getKeyInternal$paging_common(Object obj) {
        return getKeyInternal$paging_common((PositionalDataSource<T>) obj);
    }

    public PositionalDataSource() {
        super(DataSource.KeyType.POSITIONAL);
    }

    /* compiled from: PositionalDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadInitialParams;", "", "requestedStartPosition", "", "requestedLoadSize", "pageSize", "placeholdersEnabled", "", "<init>", "(IIIZ)V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class LoadInitialParams {
        public final int pageSize;
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;
        public final int requestedStartPosition;

        public LoadInitialParams(int i, int i2, int i3, boolean z) {
            this.requestedStartPosition = i;
            this.requestedLoadSize = i2;
            this.pageSize = i3;
            this.placeholdersEnabled = z;
            if (i < 0) {
                throw new IllegalStateException(("invalid start position: " + i).toString());
            }
            if (i2 < 0) {
                throw new IllegalStateException(("invalid load size: " + i2).toString());
            }
            if (i3 < 0) {
                throw new IllegalStateException(("invalid page size: " + i3).toString());
            }
        }
    }

    /* compiled from: PositionalDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/paging/PositionalDataSource$LoadRangeParams;", "", "startPosition", "", "loadSize", "<init>", "(II)V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class LoadRangeParams {
        public final int loadSize;
        public final int startPosition;

        public LoadRangeParams(int i, int i2) {
            this.startPosition = i;
            this.loadSize = i2;
        }
    }

    /* compiled from: PositionalDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0007J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/paging/PositionalDataSource$Companion;", "", "<init>", "()V", "computeInitialLoadPosition", "", "params", "Landroidx/paging/PositionalDataSource$LoadInitialParams;", "totalCount", "computeInitialLoadSize", "initialLoadPosition", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int computeInitialLoadPosition(LoadInitialParams params, int i) {
            Intrinsics.checkNotNullParameter(params, "params");
            int i2 = params.requestedStartPosition;
            int i3 = params.requestedLoadSize;
            int i4 = params.pageSize;
            return Math.max(0, Math.min(((((i - i3) + i4) - 1) / i4) * i4, (i2 / i4) * i4));
        }

        @JvmStatic
        public final int computeInitialLoadSize(LoadInitialParams params, int i, int i2) {
            Intrinsics.checkNotNullParameter(params, "params");
            return Math.min(i2 - i, params.requestedLoadSize);
        }
    }

    @Override // androidx.paging.DataSource
    public final Object load$paging_common(DataSource.Params<Integer> params, Continuation<? super DataSource.BaseResult<T>> continuation) {
        if (params.getType$paging_common() == LoadType.REFRESH) {
            int initialLoadSize = params.getInitialLoadSize();
            int i = 0;
            if (params.getKey() != null) {
                int intValue = params.getKey().intValue();
                if (params.getPlaceholdersEnabled()) {
                    initialLoadSize = Math.max(initialLoadSize / params.getPageSize(), 2) * params.getPageSize();
                    i = Math.max(0, ((intValue - (initialLoadSize / 2)) / params.getPageSize()) * params.getPageSize());
                } else {
                    i = Math.max(0, intValue - (initialLoadSize / 2));
                }
            }
            return loadInitial$paging_common(new LoadInitialParams(i, initialLoadSize, params.getPageSize(), params.getPlaceholdersEnabled()), continuation);
        }
        Integer key = params.getKey();
        Intrinsics.checkNotNull(key);
        int intValue2 = key.intValue();
        int pageSize = params.getPageSize();
        if (params.getType$paging_common() == LoadType.PREPEND) {
            pageSize = Math.min(pageSize, intValue2);
            intValue2 -= pageSize;
        }
        return loadRange(new LoadRangeParams(intValue2, pageSize), continuation);
    }

    @Override // androidx.paging.DataSource
    public boolean isContiguous$paging_common() {
        return this.isContiguous;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.DataSource
    public final Integer getKeyInternal$paging_common(T item) {
        Intrinsics.checkNotNullParameter(item, "item");
        throw new IllegalStateException("Cannot get key by item in positionalDataSource");
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> mapByPage(Function<List<T>, List<V>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperPositionalDataSource(this, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List mapByPage$lambda$0(Function1 function1, List list) {
        Intrinsics.checkNotNull(list);
        return (List) function1.invoke(list);
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> mapByPage(final Function1<? super List<? extends T>, ? extends List<? extends V>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.PositionalDataSource$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PositionalDataSource.mapByPage$lambda$0(Function1.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List map$lambda$0(Function function, List list) {
        Intrinsics.checkNotNull(list);
        List<T> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            arrayList.add(function.apply(t));
        }
        return arrayList;
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(final Function<T, V> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.PositionalDataSource$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PositionalDataSource.map$lambda$0(Function.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List map$lambda$1(Function1 function1, List list) {
        Intrinsics.checkNotNull(list);
        List<T> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (T t : list2) {
            arrayList.add(function1.invoke(t));
        }
        return arrayList;
    }

    @Override // androidx.paging.DataSource
    public final <V> PositionalDataSource<V> map(final Function1<? super T, ? extends V> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.PositionalDataSource$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PositionalDataSource.map$lambda$1(Function1.this, (List) obj);
            }
        });
    }

    public final Object loadInitial$paging_common(final LoadInitialParams loadInitialParams, Continuation<? super DataSource.BaseResult<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        loadInitial(loadInitialParams, new LoadInitialCallback<T>(this) { // from class: androidx.paging.PositionalDataSource$loadInitial$2$1
            final /* synthetic */ PositionalDataSource<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.this$0 = this;
            }

            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void onResult(List<? extends T> data, int i, int i2) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (this.this$0.isInvalid()) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m9915constructorimpl(DataSource.BaseResult.Companion.empty$paging_common()));
                    return;
                }
                int size = data.size() + i;
                resume(loadInitialParams, new DataSource.BaseResult<>(data, i == 0 ? null : Integer.valueOf(i), size != i2 ? Integer.valueOf(size) : null, i, (i2 - data.size()) - i));
            }

            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void onResult(List<? extends T> data, int i) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (this.this$0.isInvalid()) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m9915constructorimpl(DataSource.BaseResult.Companion.empty$paging_common()));
                    return;
                }
                resume(loadInitialParams, new DataSource.BaseResult<>(data, i == 0 ? null : Integer.valueOf(i), Integer.valueOf(data.size() + i), i, Integer.MIN_VALUE));
            }

            private final void resume(PositionalDataSource.LoadInitialParams loadInitialParams2, DataSource.BaseResult<T> baseResult) {
                if (loadInitialParams2.placeholdersEnabled) {
                    baseResult.validateForInitialTiling$paging_common(loadInitialParams2.pageSize);
                }
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m9915constructorimpl(baseResult));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadRange(final LoadRangeParams loadRangeParams, Continuation<? super DataSource.BaseResult<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        loadRange(loadRangeParams, new LoadRangeCallback<T>() { // from class: androidx.paging.PositionalDataSource$loadRange$2$1
            @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
            public void onResult(List<? extends T> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Integer valueOf = PositionalDataSource.LoadRangeParams.this.startPosition == 0 ? null : Integer.valueOf(PositionalDataSource.LoadRangeParams.this.startPosition);
                boolean isInvalid = this.isInvalid();
                CancellableContinuation<DataSource.BaseResult<T>> cancellableContinuation = cancellableContinuationImpl2;
                if (isInvalid) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m9915constructorimpl(DataSource.BaseResult.Companion.empty$paging_common()));
                    return;
                }
                CancellableContinuation<DataSource.BaseResult<T>> cancellableContinuation2 = cancellableContinuation;
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m9915constructorimpl(new DataSource.BaseResult(data, valueOf, Integer.valueOf(PositionalDataSource.LoadRangeParams.this.startPosition + data.size()), 0, 0, 24, null)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
