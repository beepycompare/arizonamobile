package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import androidx.paging.DataSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
/* compiled from: DataSource.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 3*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0006./0123B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J>\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0000\"\b\b\u0002\u0010\u0015*\u00020\u00022\u001e\u0010\u0016\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00180\u0017H\u0016J>\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0000\"\b\b\u0002\u0010\u0015*\u00020\u00022\u001e\u0010\u0016\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00180\u0019H\u0016J2\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0000\"\b\b\u0002\u0010\u0015*\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00150\u0017H\u0016J2\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00150\u0000\"\b\b\u0002\u0010\u0015*\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H\u00150\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0017J\u0010\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\fH\u0017J\b\u0010#\u001a\u00020 H\u0017J$\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'H @¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00028\u00002\u0006\u0010+\u001a\u00028\u0001H ¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u0012X\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0014\u0010\u001d\u001a\u00020\u0012X\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u00064"}, d2 = {"Landroidx/paging/DataSource;", "Key", "", "Value", "type", "Landroidx/paging/DataSource$KeyType;", "<init>", "(Landroidx/paging/DataSource$KeyType;)V", "getType$paging_common", "()Landroidx/paging/DataSource$KeyType;", "invalidateCallbackTracker", "Landroidx/paging/InvalidateCallbackTracker;", "Landroidx/paging/DataSource$InvalidatedCallback;", "invalidateCallbackCount", "", "getInvalidateCallbackCount$paging_common", "()I", "isInvalid", "", "()Z", "mapByPage", "ToValue", "function", "Landroidx/arch/core/util/Function;", "", "Lkotlin/Function1;", "map", "isContiguous", "isContiguous$paging_common", "supportsPageDropping", "getSupportsPageDropping$paging_common", "addInvalidatedCallback", "", "onInvalidatedCallback", "removeInvalidatedCallback", "invalidate", "load", "Landroidx/paging/DataSource$BaseResult;", "params", "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKeyInternal", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "Factory", "InvalidatedCallback", "Params", "BaseResult", "KeyType", "Companion", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DataSource<Key, Value> {
    public static final Companion Companion = new Companion(null);
    private final InvalidateCallbackTracker<InvalidatedCallback> invalidateCallbackTracker;
    private final boolean isContiguous;
    private final boolean supportsPageDropping;
    private final KeyType type;

    /* compiled from: DataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/paging/DataSource$InvalidatedCallback;", "", "onInvalidated", "", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface InvalidatedCallback {
        void onInvalidated();
    }

    public abstract Key getKeyInternal$paging_common(Value value);

    public abstract Object load$paging_common(Params<Key> params, Continuation<? super BaseResult<Value>> continuation);

    public DataSource(KeyType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.invalidateCallbackTracker = new InvalidateCallbackTracker<>(new Function1() { // from class: androidx.paging.DataSource$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DataSource.invalidateCallbackTracker$lambda$0((DataSource.InvalidatedCallback) obj);
            }
        }, new Function0() { // from class: androidx.paging.DataSource$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isInvalid;
                isInvalid = DataSource.this.isInvalid();
                return Boolean.valueOf(isInvalid);
            }
        });
        this.isContiguous = true;
        this.supportsPageDropping = true;
    }

    public final KeyType getType$paging_common() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit invalidateCallbackTracker$lambda$0(InvalidatedCallback it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onInvalidated();
        return Unit.INSTANCE;
    }

    public final int getInvalidateCallbackCount$paging_common() {
        return this.invalidateCallbackTracker.callbackCount$paging_common();
    }

    public boolean isInvalid() {
        return this.invalidateCallbackTracker.getInvalid$paging_common();
    }

    /* compiled from: DataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007H&J2\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\t0\u0000\"\b\b\u0004\u0010\t*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u0002H\t0\u000bH\u0016J2\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\t0\u0000\"\b\b\u0004\u0010\t*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u0002H\t0\fH\u0016J>\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\t0\u0000\"\b\b\u0004\u0010\t*\u00020\u00022\u001e\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e0\u000bH\u0016J>\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\t0\u0000\"\b\b\u0004\u0010\t*\u00020\u00022\u001e\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e0\fH\u0016J$\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006\u0014"}, d2 = {"Landroidx/paging/DataSource$Factory;", "Key", "", "Value", "<init>", "()V", "create", "Landroidx/paging/DataSource;", "map", "ToValue", "function", "Landroidx/arch/core/util/Function;", "Lkotlin/Function1;", "mapByPage", "", "asPagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class Factory<Key, Value> {
        public final Function0<PagingSource<Key, Value>> asPagingSourceFactory() {
            return asPagingSourceFactory$default(this, null, 1, null);
        }

        public abstract DataSource<Key, Value> create();

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

        public <ToValue> Factory<Key, ToValue> map(final Function<Value, ToValue> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            return mapByPage(new Function() { // from class: androidx.paging.DataSource$Factory$$ExternalSyntheticLambda0
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return DataSource.Factory.map$lambda$0(Function.this, (List) obj);
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

        public /* synthetic */ Factory map(final Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            return mapByPage(new Function() { // from class: androidx.paging.DataSource$Factory$$ExternalSyntheticLambda2
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return DataSource.Factory.map$lambda$1(Function1.this, (List) obj);
                }
            });
        }

        public <ToValue> Factory<Key, ToValue> mapByPage(final Function<List<Value>, List<ToValue>> function) {
            Intrinsics.checkNotNullParameter(function, "function");
            return new Factory<Key, ToValue>(this) { // from class: androidx.paging.DataSource$Factory$mapByPage$1
                final /* synthetic */ DataSource.Factory<Key, Value> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.this$0 = this;
                }

                @Override // androidx.paging.DataSource.Factory
                public DataSource<Key, ToValue> create() {
                    return this.this$0.create().mapByPage((Function) function);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final List mapByPage$lambda$0(Function1 function1, List list) {
            Intrinsics.checkNotNull(list);
            return (List) function1.invoke(list);
        }

        public /* synthetic */ Factory mapByPage(final Function1 function) {
            Intrinsics.checkNotNullParameter(function, "function");
            return mapByPage(new Function() { // from class: androidx.paging.DataSource$Factory$$ExternalSyntheticLambda3
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return DataSource.Factory.mapByPage$lambda$0(Function1.this, (List) obj);
                }
            });
        }

        public static /* synthetic */ Function0 asPagingSourceFactory$default(Factory factory, CoroutineDispatcher coroutineDispatcher, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    coroutineDispatcher = Dispatchers.getIO();
                }
                return factory.asPagingSourceFactory(coroutineDispatcher);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asPagingSourceFactory");
        }

        public final Function0<PagingSource<Key, Value>> asPagingSourceFactory(final CoroutineDispatcher fetchDispatcher) {
            Intrinsics.checkNotNullParameter(fetchDispatcher, "fetchDispatcher");
            return new SuspendingPagingSourceFactory(fetchDispatcher, new Function0() { // from class: androidx.paging.DataSource$Factory$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DataSource.Factory.asPagingSourceFactory$lambda$0(CoroutineDispatcher.this, this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final PagingSource asPagingSourceFactory$lambda$0(CoroutineDispatcher coroutineDispatcher, Factory factory) {
            return new LegacyPagingSource(coroutineDispatcher, factory.create());
        }
    }

    public <ToValue> DataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperDataSource(this, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List mapByPage$lambda$0(Function1 function1, List list) {
        Intrinsics.checkNotNull(list);
        return (List) function1.invoke(list);
    }

    public /* synthetic */ DataSource mapByPage(final Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage(new Function() { // from class: androidx.paging.DataSource$$ExternalSyntheticLambda2
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return DataSource.mapByPage$lambda$0(Function1.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List map$lambda$0(Function function, List list) {
        Intrinsics.checkNotNullParameter(list, "list");
        List<Object> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Object obj : list2) {
            arrayList.add(function.apply(obj));
        }
        return arrayList;
    }

    public <ToValue> DataSource<Key, ToValue> map(final Function<Value, ToValue> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return mapByPage(new Function1() { // from class: androidx.paging.DataSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DataSource.map$lambda$0(Function.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object map$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNull(obj);
        return function1.invoke(obj);
    }

    public /* synthetic */ DataSource map(final Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return map(new Function() { // from class: androidx.paging.DataSource$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return DataSource.map$lambda$1(Function1.this, obj);
            }
        });
    }

    public boolean isContiguous$paging_common() {
        return this.isContiguous;
    }

    public boolean getSupportsPageDropping$paging_common() {
        return this.supportsPageDropping;
    }

    public void addInvalidatedCallback(InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.invalidateCallbackTracker.registerInvalidatedCallback$paging_common(onInvalidatedCallback);
    }

    public void removeInvalidatedCallback(InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.invalidateCallbackTracker.unregisterInvalidatedCallback$paging_common(onInvalidatedCallback);
    }

    public void invalidate() {
        this.invalidateCallbackTracker.invalidate$paging_common();
    }

    /* compiled from: DataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/paging/DataSource$Params;", "K", "", "type", "Landroidx/paging/LoadType;", "key", "initialLoadSize", "", "placeholdersEnabled", "", "pageSize", "<init>", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZI)V", "getType$paging_common", "()Landroidx/paging/LoadType;", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getInitialLoadSize", "()I", "getPlaceholdersEnabled", "()Z", "getPageSize", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Params<K> {
        private final int initialLoadSize;
        private final K key;
        private final int pageSize;
        private final boolean placeholdersEnabled;
        private final LoadType type;

        public Params(LoadType type, K k, int i, boolean z, int i2) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.key = k;
            this.initialLoadSize = i;
            this.placeholdersEnabled = z;
            this.pageSize = i2;
            if (type != LoadType.REFRESH && k == null) {
                throw new IllegalArgumentException("Key must be non-null for prepend/append");
            }
        }

        public final LoadType getType$paging_common() {
            return this.type;
        }

        public final K getKey() {
            return this.key;
        }

        public final int getInitialLoadSize() {
            return this.initialLoadSize;
        }

        public final boolean getPlaceholdersEnabled() {
            return this.placeholdersEnabled;
        }

        public final int getPageSize() {
            return this.pageSize;
        }
    }

    /* compiled from: DataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u0019*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0019B?\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroidx/paging/DataSource$BaseResult;", "Value", "", "data", "", "prevKey", "nextKey", "itemsBefore", "", "itemsAfter", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "getPrevKey", "()Ljava/lang/Object;", "getNextKey", "getItemsBefore", "()I", "getItemsAfter", "validateForInitialTiling", "", "pageSize", "validateForInitialTiling$paging_common", "equals", "", "other", "Companion", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BaseResult<Value> {
        public static final Companion Companion = new Companion(null);
        public final List<Value> data;
        private final int itemsAfter;
        private final int itemsBefore;
        private final Object nextKey;
        private final Object prevKey;

        /* JADX WARN: Multi-variable type inference failed */
        public BaseResult(List<? extends Value> data, Object obj, Object obj2, int i, int i2) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.prevKey = obj;
            this.nextKey = obj2;
            this.itemsBefore = i;
            this.itemsAfter = i2;
            if (i < 0 && i != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Position must be non-negative");
            }
            if (data.isEmpty() && (i > 0 || i2 > 0)) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
            if (i2 < 0 && i2 != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            }
        }

        public /* synthetic */ BaseResult(List list, Object obj, Object obj2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, obj, obj2, (i3 & 8) != 0 ? Integer.MIN_VALUE : i, (i3 & 16) != 0 ? Integer.MIN_VALUE : i2);
        }

        public final Object getPrevKey() {
            return this.prevKey;
        }

        public final Object getNextKey() {
            return this.nextKey;
        }

        public final int getItemsBefore() {
            return this.itemsBefore;
        }

        public final int getItemsAfter() {
            return this.itemsAfter;
        }

        public final void validateForInitialTiling$paging_common(int i) {
            int i2;
            if (this.itemsBefore == Integer.MIN_VALUE || (i2 = this.itemsAfter) == Integer.MIN_VALUE) {
                throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
            }
            if (i2 > 0 && this.data.size() % i != 0) {
                throw new IllegalArgumentException("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize " + this.data.size() + ", position " + this.itemsBefore + ", totalCount " + (this.itemsBefore + this.data.size() + this.itemsAfter) + ", pageSize " + i);
            }
            if (this.itemsBefore % i != 0) {
                throw new IllegalArgumentException("Initial load must be pageSize aligned.Position = " + this.itemsBefore + ", pageSize = " + i);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof BaseResult) {
                BaseResult baseResult = (BaseResult) obj;
                if (Intrinsics.areEqual(this.data, baseResult.data) && Intrinsics.areEqual(this.prevKey, baseResult.prevKey) && Intrinsics.areEqual(this.nextKey, baseResult.nextKey) && this.itemsBefore == baseResult.itemsBefore && this.itemsAfter == baseResult.itemsAfter) {
                    return true;
                }
            }
            return false;
        }

        /* compiled from: DataSource.jvmAndAndroid.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0003\u0010\u0006*\u00020\u0001H\u0000¢\u0006\u0002\b\u0007JU\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0005\"\b\b\u0003\u0010\n*\u00020\u0001\"\b\b\u0004\u0010\t*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00052\u001e\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000e0\rH\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/DataSource$BaseResult$Companion;", "", "<init>", "()V", "empty", "Landroidx/paging/DataSource$BaseResult;", ExifInterface.GPS_DIRECTION_TRUE, "empty$paging_common", "convert", "Value", "ToValue", "result", "function", "Landroidx/arch/core/util/Function;", "", "convert$paging_common", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final <T> BaseResult<T> empty$paging_common() {
                return new BaseResult<>(CollectionsKt.emptyList(), null, null, 0, 0);
            }

            public final <ToValue, Value> BaseResult<Value> convert$paging_common(BaseResult<ToValue> result, Function<List<ToValue>, List<Value>> function) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(function, "function");
                return new BaseResult<>(DataSource.Companion.convert$paging_common(function, result.data), result.getPrevKey(), result.getNextKey(), result.getItemsBefore(), result.getItemsAfter());
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/DataSource$KeyType;", "", "<init>", "(Ljava/lang/String;I)V", "POSITIONAL", "PAGE_KEYED", "ITEM_KEYED", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class KeyType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KeyType[] $VALUES;
        public static final KeyType POSITIONAL = new KeyType("POSITIONAL", 0);
        public static final KeyType PAGE_KEYED = new KeyType("PAGE_KEYED", 1);
        public static final KeyType ITEM_KEYED = new KeyType("ITEM_KEYED", 2);

        private static final /* synthetic */ KeyType[] $values() {
            return new KeyType[]{POSITIONAL, PAGE_KEYED, ITEM_KEYED};
        }

        public static EnumEntries<KeyType> getEntries() {
            return $ENTRIES;
        }

        public static KeyType valueOf(String str) {
            return (KeyType) Enum.valueOf(KeyType.class, str);
        }

        public static KeyType[] values() {
            return (KeyType[]) $VALUES.clone();
        }

        private KeyType(String str, int i) {
        }

        static {
            KeyType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: DataSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0002\u0010\u0007\"\u0004\b\u0003\u0010\u00062\u001e\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005H\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/DataSource$Companion;", "", "<init>", "()V", "convert", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "function", "Landroidx/arch/core/util/Function;", "source", "convert$paging_common", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <A, B> List<B> convert$paging_common(Function<List<A>, List<B>> function, List<? extends A> source) {
            Intrinsics.checkNotNullParameter(function, "function");
            Intrinsics.checkNotNullParameter(source, "source");
            List<B> apply = function.apply(source);
            if (apply.size() != source.size()) {
                throw new IllegalStateException("Invalid Function " + function + " changed return size. This is not supported.");
            }
            Intrinsics.checkNotNull(apply);
            return apply;
        }
    }
}
