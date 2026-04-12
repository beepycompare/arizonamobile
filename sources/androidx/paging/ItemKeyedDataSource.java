package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* compiled from: ItemKeyedDataSource.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0018\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u00040123B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0080@¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u0004\u0018\u00018\u0000*\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u0004\u0018\u00018\u0000*\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0000¢\u0006\u0004\b\u0012\u0010\u0010J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0081@¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u0018*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0019H\u0002¢\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0081@¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0081@¢\u0006\u0004\b \u0010\u001eJ$\u0010\u0013\u001a\u00020!2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#H&J$\u0010\u001f\u001a\u00020!2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010$H&J$\u0010\u001b\u001a\u00020!2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010$H&J\u0015\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00028\u0001H&¢\u0006\u0002\u0010'J\u0017\u0010(\u001a\u00028\u00002\u0006\u0010&\u001a\u00028\u0001H\u0010¢\u0006\u0004\b)\u0010'J<\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H+0\u0000\"\b\b\u0002\u0010+*\u00020\u00022\u001e\u0010,\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H+0\u000e0-J<\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H+0\u0000\"\b\b\u0002\u0010+*\u00020\u00022\u001e\u0010,\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H+0\u000e0.J0\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H+0\u0000\"\b\b\u0002\u0010+*\u00020\u00022\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H+0-J0\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H+0\u0000\"\b\b\u0002\u0010+*\u00020\u00022\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H+0.¨\u00064"}, d2 = {"Landroidx/paging/ItemKeyedDataSource;", "Key", "", "Value", "Landroidx/paging/DataSource;", "<init>", "()V", "load", "Landroidx/paging/DataSource$BaseResult;", "params", "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrevKey", "", "getPrevKey$paging_common", "(Ljava/util/List;)Ljava/lang/Object;", "getNextKey", "getNextKey$paging_common", "loadInitial", "Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "loadInitial$paging_common", "(Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asCallback", "androidx/paging/ItemKeyedDataSource$asCallback$1", "Lkotlinx/coroutines/CancellableContinuation;", "(Lkotlinx/coroutines/CancellableContinuation;)Landroidx/paging/ItemKeyedDataSource$asCallback$1;", "loadBefore", "Landroidx/paging/ItemKeyedDataSource$LoadParams;", "loadBefore$paging_common", "(Landroidx/paging/ItemKeyedDataSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAfter", "loadAfter$paging_common", "", "callback", "Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "getKey", "item", "(Ljava/lang/Object;)Ljava/lang/Object;", "getKeyInternal", "getKeyInternal$paging_common", "mapByPage", "ToValue", "function", "Landroidx/arch/core/util/Function;", "Lkotlin/Function1;", "map", "LoadInitialParams", "LoadParams", "LoadInitialCallback", "LoadCallback", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(message = "ItemKeyedDataSource is deprecated and has been replaced by PagingSource", replaceWith = @ReplaceWith(expression = "PagingSource<Key, Value>", imports = {"androidx.paging.PagingSource"}))
/* loaded from: classes3.dex */
public abstract class ItemKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    /* compiled from: ItemKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\bH&¨\u0006\t"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "Value", "", "<init>", "()V", "onResult", "", "data", "", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadCallback<Value> {
        public abstract void onResult(List<? extends Value> list);
    }

    /* compiled from: ItemKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadInitialCallback;", "Value", "Landroidx/paging/ItemKeyedDataSource$LoadCallback;", "<init>", "()V", "onResult", "", "data", "", "position", "", "totalCount", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
        public abstract void onResult(List<? extends Value> list, int i, int i2);
    }

    /* compiled from: ItemKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract Key getKey(Value value);

    public abstract void loadAfter(LoadParams<Key> loadParams, LoadCallback<Value> loadCallback);

    public abstract void loadBefore(LoadParams<Key> loadParams, LoadCallback<Value> loadCallback);

    public abstract void loadInitial(LoadInitialParams<Key> loadInitialParams, LoadInitialCallback<Value> loadInitialCallback);

    public ItemKeyedDataSource() {
        super(DataSource.KeyType.ITEM_KEYED);
    }

    /* compiled from: ItemKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u0004\u0018\u00018\u00028\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadInitialParams;", "Key", "", "requestedInitialKey", "requestedLoadSize", "", "placeholdersEnabled", "", "<init>", "(Ljava/lang/Object;IZ)V", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static class LoadInitialParams<Key> {
        public final boolean placeholdersEnabled;
        public final Key requestedInitialKey;
        public final int requestedLoadSize;

        public LoadInitialParams(Key key, int i, boolean z) {
            this.requestedInitialKey = key;
            this.requestedLoadSize = i;
            this.placeholdersEnabled = z;
        }
    }

    /* compiled from: ItemKeyedDataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0012\u0010\u0003\u001a\u00028\u00028\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/paging/ItemKeyedDataSource$LoadParams;", "Key", "", "key", "requestedLoadSize", "", "<init>", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
        int i = WhenMappings.$EnumSwitchMapping$0[params.getType$paging_common().ordinal()];
        if (i != 1) {
            if (i == 2) {
                Key key = params.getKey();
                Intrinsics.checkNotNull(key);
                return loadBefore$paging_common(new LoadParams<>(key, params.getPageSize()), continuation);
            } else if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                Key key2 = params.getKey();
                Intrinsics.checkNotNull(key2);
                return loadAfter$paging_common(new LoadParams<>(key2, params.getPageSize()), continuation);
            }
        }
        return loadInitial$paging_common(new LoadInitialParams<>(params.getKey(), params.getInitialLoadSize(), params.getPlaceholdersEnabled()), continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Key getPrevKey$paging_common(List<? extends Value> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Object firstOrNull = CollectionsKt.firstOrNull((List<? extends Object>) list);
        if (firstOrNull != null) {
            return (Key) getKey(firstOrNull);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Key getNextKey$paging_common(List<? extends Value> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Object lastOrNull = CollectionsKt.lastOrNull((List<? extends Object>) list);
        if (lastOrNull != null) {
            return (Key) getKey(lastOrNull);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.paging.ItemKeyedDataSource$asCallback$1] */
    public final ItemKeyedDataSource$asCallback$1 asCallback(final CancellableContinuation<? super DataSource.BaseResult<Value>> cancellableContinuation) {
        return new LoadCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$asCallback$1
            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m9183constructorimpl(new DataSource.BaseResult(data, this.getPrevKey$paging_common(data), this.getNextKey$paging_common(data), 0, 0, 24, null)));
            }
        };
    }

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(Value item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return getKey(item);
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperItemKeyedDataSource(this, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List mapByPage$lambda$0(Function1 function1, List list) {
        Intrinsics.checkNotNull(list);
        return (List) function1.invoke(list);
    }

    @Override // androidx.paging.DataSource
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> mapByPage(final Function1<? super List<? extends Value>, ? extends List<? extends ToValue>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.ItemKeyedDataSource$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ItemKeyedDataSource.mapByPage$lambda$0(Function1.this, (List) obj);
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
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(final Function<Value, ToValue> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.ItemKeyedDataSource$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ItemKeyedDataSource.map$lambda$0(Function.this, (List) obj);
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
    public final <ToValue> ItemKeyedDataSource<Key, ToValue> map(final Function1<? super Value, ? extends ToValue> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage((Function) new Function() { // from class: androidx.paging.ItemKeyedDataSource$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ItemKeyedDataSource.map$lambda$1(Function1.this, (List) obj);
            }
        });
    }

    public final Object loadInitial$paging_common(LoadInitialParams<Key> loadInitialParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        loadInitial(loadInitialParams, new LoadInitialCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$loadInitial$2$1
            @Override // androidx.paging.ItemKeyedDataSource.LoadInitialCallback
            public void onResult(List<? extends Value> data, int i, int i2) {
                Intrinsics.checkNotNullParameter(data, "data");
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m9183constructorimpl(new DataSource.BaseResult(data, this.getPrevKey$paging_common(data), this.getNextKey$paging_common(data), i, (i2 - data.size()) - i)));
            }

            @Override // androidx.paging.ItemKeyedDataSource.LoadCallback
            public void onResult(List<? extends Value> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m9183constructorimpl(new DataSource.BaseResult(data, this.getPrevKey$paging_common(data), this.getNextKey$paging_common(data), 0, 0, 24, null)));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object loadBefore$paging_common(LoadParams<Key> loadParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadBefore(loadParams, asCallback(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object loadAfter$paging_common(LoadParams<Key> loadParams, Continuation<? super DataSource.BaseResult<Value>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        loadAfter(loadParams, asCallback(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
