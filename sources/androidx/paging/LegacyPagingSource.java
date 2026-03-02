package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
/* compiled from: LegacyPagingSource.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000  *\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u00020\u0005:\u0001 B#\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u0016\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00162\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096@¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/paging/LegacyPagingSource;", "Key", "", "Value", "Landroidx/paging/PagingSource;", "Landroidx/paging/CompatLegacyPagingSource;", "fetchContext", "Lkotlin/coroutines/CoroutineContext;", "dataSource", "Landroidx/paging/DataSource;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Landroidx/paging/DataSource;)V", "getDataSource$paging_common", "()Landroidx/paging/DataSource;", "pageSize", "", "setPageSize", "", "guessPageSize", "params", "Landroidx/paging/PagingSource$LoadParams;", "load", "Landroidx/paging/PagingSource$LoadResult;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRefreshKey", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "jumpingSupported", "", "getJumpingSupported", "()Z", "Companion", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LegacyPagingSource<Key, Value> extends PagingSource<Key, Value> implements CompatLegacyPagingSource {
    private static final Companion Companion = new Companion(null);
    private static final int PAGE_SIZE_NOT_SET = Integer.MIN_VALUE;
    private final DataSource<Key, Value> dataSource;
    private final CoroutineContext fetchContext;
    private int pageSize;

    /* compiled from: LegacyPagingSource.jvmAndAndroid.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataSource.KeyType.values().length];
            try {
                iArr[DataSource.KeyType.POSITIONAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.KeyType.PAGE_KEYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.KeyType.ITEM_KEYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LegacyPagingSource(CoroutineContext fetchContext, DataSource<Key, Value> dataSource) {
        Intrinsics.checkNotNullParameter(fetchContext, "fetchContext");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.fetchContext = fetchContext;
        this.dataSource = dataSource;
        this.pageSize = Integer.MIN_VALUE;
        dataSource.addInvalidatedCallback(new AnonymousClass1(this));
        registerInvalidatedCallback(new Function0() { // from class: androidx.paging.LegacyPagingSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LegacyPagingSource._init_$lambda$0(LegacyPagingSource.this);
            }
        });
    }

    public final DataSource<Key, Value> getDataSource$paging_common() {
        return this.dataSource;
    }

    /* compiled from: LegacyPagingSource.jvmAndAndroid.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.paging.LegacyPagingSource$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final /* synthetic */ class AnonymousClass1 implements DataSource.InvalidatedCallback, FunctionAdapter {
        final /* synthetic */ LegacyPagingSource<Key, Value> $tmp0;

        AnonymousClass1(LegacyPagingSource<Key, Value> legacyPagingSource) {
            this.$tmp0 = legacyPagingSource;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof DataSource.InvalidatedCallback) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(0, this.$tmp0, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.paging.DataSource.InvalidatedCallback
        public final void onInvalidated() {
            this.$tmp0.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0(LegacyPagingSource legacyPagingSource) {
        legacyPagingSource.dataSource.removeInvalidatedCallback(new LegacyPagingSource$2$1(legacyPagingSource));
        legacyPagingSource.dataSource.invalidate();
        return Unit.INSTANCE;
    }

    @Override // androidx.paging.CompatLegacyPagingSource
    public void setPageSize(int i) {
        int i2 = this.pageSize;
        if (i2 != Integer.MIN_VALUE && i != i2) {
            throw new IllegalStateException(("Page size is already set to " + this.pageSize + '.').toString());
        }
        this.pageSize = i;
    }

    private final int guessPageSize(PagingSource.LoadParams<Key> loadParams) {
        if (loadParams instanceof PagingSource.LoadParams.Refresh) {
            PagingSource.LoadParams.Refresh refresh = (PagingSource.LoadParams.Refresh) loadParams;
            if (refresh.getLoadSize() % 3 == 0) {
                return refresh.getLoadSize() / 3;
            }
        }
        return loadParams.getLoadSize();
    }

    @Override // androidx.paging.PagingSource
    public Object load(PagingSource.LoadParams<Key> loadParams, Continuation<? super PagingSource.LoadResult<Key, Value>> continuation) {
        LoadType loadType;
        if (loadParams instanceof PagingSource.LoadParams.Refresh) {
            loadType = LoadType.REFRESH;
        } else if (loadParams instanceof PagingSource.LoadParams.Append) {
            loadType = LoadType.APPEND;
        } else if (!(loadParams instanceof PagingSource.LoadParams.Prepend)) {
            throw new NoWhenBranchMatchedException();
        } else {
            loadType = LoadType.PREPEND;
        }
        LoadType loadType2 = loadType;
        if (this.pageSize == Integer.MIN_VALUE) {
            System.out.println((Object) "WARNING: pageSize on the LegacyPagingSource is not set.\nWhen using legacy DataSource / DataSourceFactory with Paging3, page size\nshould've been set by the paging library but it is not set yet.\n\nIf you are seeing this message in tests where you are testing DataSource\nin isolation (without a Pager), it is expected and page size will be estimated\nbased on parameters.\n\nIf you are seeing this message despite using a Pager, please file a bug:\nhttps://issuetracker.google.com/issues/new?component=413106");
            this.pageSize = guessPageSize(loadParams);
        }
        return BuildersKt.withContext(this.fetchContext, new LegacyPagingSource$load$2(this, new DataSource.Params(loadType2, loadParams.getKey(), loadParams.getLoadSize(), loadParams.getPlaceholdersEnabled(), this.pageSize), loadParams, null), continuation);
    }

    @Override // androidx.paging.PagingSource
    public Key getRefreshKey(PagingState<Key, Value> state) {
        Value closestItemToPosition;
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[this.dataSource.getType$paging_common().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                Integer anchorPosition = state.getAnchorPosition();
                if (anchorPosition == null || (closestItemToPosition = state.closestItemToPosition(anchorPosition.intValue())) == null) {
                    return null;
                }
                return this.dataSource.getKeyInternal$paging_common(closestItemToPosition);
            }
            return null;
        }
        Integer anchorPosition2 = state.getAnchorPosition();
        if (anchorPosition2 != null) {
            int intValue = anchorPosition2.intValue();
            int i2 = intValue - ((PagingState) state).leadingPlaceholderCount;
            for (int i3 = 0; i3 < CollectionsKt.getLastIndex(state.getPages()) && i2 > CollectionsKt.getLastIndex(state.getPages().get(i3).getData()); i3++) {
                i2 -= state.getPages().get(i3).getData().size();
            }
            PagingSource.LoadResult.Page<Key, Value> closestPageToPosition = state.closestPageToPosition(intValue);
            int i4 = (closestPageToPosition == null || (i4 = closestPageToPosition.getPrevKey()) == null) ? 0 : 0;
            Intrinsics.checkNotNull(i4, "null cannot be cast to non-null type kotlin.Int");
            return (Key) Integer.valueOf(((Integer) i4).intValue() + i2);
        }
        return null;
    }

    @Override // androidx.paging.PagingSource
    public boolean getJumpingSupported() {
        return this.dataSource.getType$paging_common() == DataSource.KeyType.POSITIONAL;
    }

    /* compiled from: LegacyPagingSource.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/paging/LegacyPagingSource$Companion;", "", "<init>", "()V", "PAGE_SIZE_NOT_SET", "", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
