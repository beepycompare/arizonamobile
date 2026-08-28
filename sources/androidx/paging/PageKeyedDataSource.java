package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
/* compiled from: PageKeyedDataSource.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0004,-./B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0080@¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0082@¢\u0006\u0002\u0010\u0012J0\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00152\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J*\u0010\r\u001a\u00020\u001a2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH&J*\u0010\u0010\u001a\u00020\u001a2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015H&J*\u0010\u0013\u001a\u00020\u001a2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015H&J\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\u001f\u0010 J<\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H&0\u0000\"\b\b\u0002\u0010&*\u00020\u00022\u001e\u0010'\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0)0(J<\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H&0\u0000\"\b\b\u0002\u0010&*\u00020\u00022\u001e\u0010'\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0)0*J0\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H&0\u0000\"\b\b\u0002\u0010&*\u00020\u00022\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H&0(J0\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H&0\u0000\"\b\b\u0002\u0010&*\u00020\u00022\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H&0*R\u001a\u0010!\u001a\u00020\u0019X\u0090D¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010$¨\u00060"}, d2 = {"Landroidx/paging/PageKeyedDataSource;", "Key", "", "Value", "Landroidx/paging/DataSource;", "<init>", "()V", "load", "Landroidx/paging/DataSource$BaseResult;", "params", "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadInitial", "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "(Landroidx/paging/PageKeyedDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadBefore", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "(Landroidx/paging/PageKeyedDataSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAfter", "continuationAsCallback", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "isAppend", "", "", "callback", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "getKeyInternal", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "supportsPageDropping", "getSupportsPageDropping$paging_common$annotations", "getSupportsPageDropping$paging_common", "()Z", "mapByPage", "ToValue", "function", "Landroidx/arch/core/util/Function;", "", "Lkotlin/Function1;", "map", "LoadInitialParams", "LoadParams", "LoadInitialCallback", "LoadCallback", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated(message = "PageKeyedDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Key, Value>", imports = {"androidx.paging.PagingSource"}))
/* loaded from: classes3.dex */
public abstract class PageKeyedDataSource<Key, Value> extends DataSource<Key, Value> {
    private final boolean supportsPageDropping;

    /* compiled from: PageKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00030\t2\b\u0010\n\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadCallback;", "Key", "Value", "", "<init>", "()V", "onResult", "", "data", "", "adjacentPageKey", "(Ljava/util/List;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadCallback<Key, Value> {
        public abstract void onResult(List<? extends Value> list, Key key);
    }

    /* compiled from: PageKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J?\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00030\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00018\u00022\b\u0010\u000e\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\u000fJ/\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00030\t2\b\u0010\r\u001a\u0004\u0018\u00018\u00022\b\u0010\u000e\u001a\u0004\u0018\u00018\u0002H&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "Key", "Value", "", "<init>", "()V", "onResult", "", "data", "", "position", "", "totalCount", "previousPageKey", "nextPageKey", "(Ljava/util/List;IILjava/lang/Object;Ljava/lang/Object;)V", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void onResult(List<? extends Value> list, int i, int i2, Key key, Key key2);

        public abstract void onResult(List<? extends Value> list, Key key, Key key2);
    }

    public static /* synthetic */ void getSupportsPageDropping$paging_common$annotations() {
    }

    public abstract void loadAfter(LoadParams<Key> loadParams, LoadCallback<Key, Value> loadCallback);

    public abstract void loadBefore(LoadParams<Key> loadParams, LoadCallback<Key, Value> loadCallback);

    public abstract void loadInitial(LoadInitialParams<Key> loadInitialParams, LoadInitialCallback<Key, Value> loadInitialCallback);

    public PageKeyedDataSource() {
        super(DataSource.KeyType.PAGE_KEYED);
    }

    /* compiled from: PageKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "Key", "", "requestedLoadSize", "", "placeholdersEnabled", "", "<init>", "(IZ)V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final int requestedLoadSize;

        public LoadInitialParams(int i, boolean z) {
            this.requestedLoadSize = i;
            this.placeholdersEnabled = z;
        }
    }

    /* compiled from: PageKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\u0003\u001a\u00028\u00028\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/paging/PageKeyedDataSource$LoadParams;", "Key", "", "key", "requestedLoadSize", "", "<init>", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class LoadParams<Key> {
        public final Key key;
        public final int requestedLoadSize;

        public LoadParams(Key key, int i) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.key = key;
            this.requestedLoadSize = i;
        }
    }

    @Override // androidx.paging.DataSource
    public final Object load$paging_common(DataSource.Params<Key> params, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        if (params.getType$paging_common() == LoadType.REFRESH) {
            return loadInitial(new LoadInitialParams<>(params.getInitialLoadSize(), params.getPlaceholdersEnabled()), continuation);
        }
        if (params.getKey() == null) {
            return DataSource.BaseResult.Companion.empty$paging_common();
        }
        if (params.getType$paging_common() == LoadType.PREPEND) {
            return loadBefore(new LoadParams<>(params.getKey(), params.getPageSize()), continuation);
        }
        if (params.getType$paging_common() == LoadType.APPEND) {
            return loadAfter(new LoadParams<>(params.getKey(), params.getPageSize()), continuation);
        }
        throw new IllegalArgumentException("Unsupported type " + params.getType$paging_common());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadCallback<Key, Value> continuationAsCallback(final CancellableContinuation<? super DataSource.BaseResult<Value>> cancellableContinuation, final boolean z) {
        return new LoadCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$continuationAsCallback$1
            @Override // androidx.paging.PageKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> data, Key key) {
                Intrinsics.checkNotNullParameter(data, "data");
                CancellableContinuation<DataSource.BaseResult<Value>> cancellableContinuation2 = cancellableContinuation;
                Result.Companion companion = Result.Companion;
                boolean z2 = z;
                cancellableContinuation2.resumeWith(Result.m9920constructorimpl(new DataSource.BaseResult(data, z2 ? null : key, z2 ? key : null, 0, 0, 24, null)));
            }
        };
    }

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(Value item) {
        Intrinsics.checkNotNullParameter(item, "item");
        throw new IllegalStateException("Cannot get key by item in pageKeyedDataSource");
    }

    @Override // androidx.paging.DataSource
    public boolean getSupportsPageDropping$paging_common() {
        return this.supportsPageDropping;
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperPageKeyedDataSource(this, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List mapByPage$lambda$0(Function1 function1, List list) {
        Intrinsics.checkNotNull(list);
        return (List) function1.invoke(list);
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> mapByPage(final Function1<? super List<? extends Value>, ? extends List<? extends ToValue>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.PageKeyedDataSource$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PageKeyedDataSource.mapByPage$lambda$0(Function1.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List map$lambda$0(Function function, List list) {
        Intrinsics.checkNotNull(list);
        List<Object> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Object obj : list2) {
            arrayList.add(function.apply(obj));
        }
        return arrayList;
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(final Function<Value, ToValue> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.PageKeyedDataSource$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PageKeyedDataSource.map$lambda$0(Function.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List map$lambda$1(Function1 function1, List list) {
        Intrinsics.checkNotNull(list);
        List<Object> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Object obj : list2) {
            arrayList.add(function1.invoke(obj));
        }
        return arrayList;
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> PageKeyedDataSource<Key, ToValue> map(final Function1<? super Value, ? extends ToValue> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.PageKeyedDataSource$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return PageKeyedDataSource.map$lambda$1(Function1.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadInitial(LoadInitialParams<Key> loadInitialParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        loadInitial(loadInitialParams, new LoadInitialCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$loadInitial$2$1
            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> data, int i, int i2, Key key, Key key2) {
                Intrinsics.checkNotNullParameter(data, "data");
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m9920constructorimpl(new DataSource.BaseResult(data, key, key2, i, (i2 - data.size()) - i)));
            }

            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> data, Key key, Key key2) {
                Intrinsics.checkNotNullParameter(data, "data");
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m9920constructorimpl(new DataSource.BaseResult(data, key, key2, 0, 0, 24, null)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadBefore(LoadParams<Key> loadParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadBefore(loadParams, continuationAsCallback(cancellableContinuationImpl, false));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadAfter(LoadParams<Key> loadParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadAfter(loadParams, continuationAsCallback(cancellableContinuationImpl, true));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
