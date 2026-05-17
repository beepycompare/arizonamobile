package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.paging.LegacyPageFetcher;
import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.paging.PagedStorage;
import androidx.paging.PagingSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: ContiguousPagedList.jvmAndAndroid.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0017\u0018\u0000 Y*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00030\u00042\u00020\u00052\b\u0012\u0004\u0012\u0002H\u00030\u0006:\u0001YBi\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\"\u00100\u001a\u00020 2\u0006\u00101\u001a\u0002022\u0010\u00103\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0018\u00104\u001a\u0002052\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u000207H\u0016J\u001e\u00108\u001a\u0002052\u0006\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000109H\u0002J%\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020 H\u0001¢\u0006\u0002\b>J\u0010\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020 H\u0002J\u0018\u0010A\u001a\u0002052\u0006\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020 H\u0002J\b\u0010D\u001a\u000205H\u0016J\"\u0010E\u001a\u0002052\u0018\u0010F\u001a\u0014\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002050GH\u0016J\u0018\u0010H\u001a\u0002052\u0006\u0010I\u001a\u0002022\u0006\u0010J\u001a\u000207H\u0016J\u0010\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020\u001dH\u0017J\b\u0010M\u001a\u000205H\u0016J\u0010\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u001dH\u0017J \u0010P\u001a\u0002052\u0006\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\u001dH\u0017J \u0010T\u001a\u0002052\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\u001dH\u0017J\u0018\u0010V\u001a\u0002052\u0006\u0010W\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001dH\u0016J\u0018\u0010X\u001a\u0002052\u0006\u0010W\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020\u001dH\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u0014\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00018\u00008VX\u0096\u0004¢\u0006\f\u0012\u0004\b+\u0010)\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u0006Z"}, d2 = {"Landroidx/paging/ContiguousPagedList;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/paging/PagedList;", "Landroidx/paging/PagedStorage$Callback;", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "pagingSource", "Landroidx/paging/PagingSource;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "backgroundDispatcher", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "config", "Landroidx/paging/PagedList$Config;", "initialPage", "Landroidx/paging/PagingSource$LoadResult$Page;", "initialLastKey", "<init>", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource$LoadResult$Page;Ljava/lang/Object;)V", "getPagingSource", "()Landroidx/paging/PagingSource;", "getBoundaryCallback$paging_common", "()Landroidx/paging/PagedList$BoundaryCallback;", "Ljava/lang/Object;", "prependItemsRequested", "", "appendItemsRequested", "boundaryCallbackBeginDeferred", "", "boundaryCallbackEndDeferred", "lowestIndexAccessed", "highestIndexAccessed", "replacePagesWithNulls", "shouldTrim", "pager", "Landroidx/paging/LegacyPageFetcher;", "getPager$annotations", "()V", "lastKey", "getLastKey$annotations", "getLastKey", "()Ljava/lang/Object;", "isDetached", "()Z", "onPageResult", "type", "Landroidx/paging/LoadType;", "page", "onStateChanged", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/paging/LoadState;", "triggerBoundaryCallback", "", "deferBoundaryCallbacks", "deferEmpty", "deferBegin", "deferEnd", "deferBoundaryCallbacks$paging_common", "tryDispatchBoundaryCallbacks", "post", "dispatchBoundaryCallbacks", "begin", TtmlNode.END, "retry", "dispatchCurrentLoadState", "callback", "Lkotlin/Function2;", "setInitialLoadState", "loadType", "loadState", "loadAroundInternal", FirebaseAnalytics.Param.INDEX, "detach", "onInitialized", "count", "onPagePrepended", "leadingNulls", "changed", "added", "onPageAppended", "endPosition", "onPagesRemoved", "startOfDrops", "onPagesSwappedToPlaceholder", "Companion", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ContiguousPagedList<K, V> extends PagedList<V> implements PagedStorage.Callback, LegacyPageFetcher.PageConsumer<V> {
    public static final Companion Companion = new Companion(null);
    private int appendItemsRequested;
    private final PagedList.BoundaryCallback<V> boundaryCallback;
    private boolean boundaryCallbackBeginDeferred;
    private boolean boundaryCallbackEndDeferred;
    private int highestIndexAccessed;
    private final K initialLastKey;
    private int lowestIndexAccessed;
    private final LegacyPageFetcher<K, V> pager;
    private final PagingSource<K, V> pagingSource;
    private int prependItemsRequested;
    private boolean replacePagesWithNulls;
    private final boolean shouldTrim;

    public static /* synthetic */ void getLastKey$annotations() {
    }

    private static /* synthetic */ void getPager$annotations() {
    }

    @Override // androidx.paging.PagedList
    public final PagingSource<K, V> getPagingSource() {
        return this.pagingSource;
    }

    public final PagedList.BoundaryCallback<V> getBoundaryCallback$paging_common() {
        return this.boundaryCallback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContiguousPagedList(PagingSource<K, V> pagingSource, CoroutineScope coroutineScope, CoroutineDispatcher notifyDispatcher, CoroutineDispatcher backgroundDispatcher, PagedList.BoundaryCallback<V> boundaryCallback, PagedList.Config config, PagingSource.LoadResult.Page<K, V> initialPage, K k) {
        super(pagingSource, coroutineScope, notifyDispatcher, new PagedStorage(), config);
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(notifyDispatcher, "notifyDispatcher");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(initialPage, "initialPage");
        this.pagingSource = pagingSource;
        this.boundaryCallback = boundaryCallback;
        this.initialLastKey = k;
        this.lowestIndexAccessed = Integer.MAX_VALUE;
        this.highestIndexAccessed = Integer.MIN_VALUE;
        this.shouldTrim = config.maxSize != Integer.MAX_VALUE;
        PagedStorage<V> storage$paging_common = getStorage$paging_common();
        Intrinsics.checkNotNull(storage$paging_common, "null cannot be cast to non-null type androidx.paging.LegacyPageFetcher.KeyProvider<K of androidx.paging.ContiguousPagedList>");
        this.pager = new LegacyPageFetcher<>(coroutineScope, config, pagingSource, notifyDispatcher, backgroundDispatcher, this, storage$paging_common);
        if (config.enablePlaceholders) {
            getStorage$paging_common().init(initialPage.getItemsBefore() != Integer.MIN_VALUE ? initialPage.getItemsBefore() : 0, initialPage, initialPage.getItemsAfter() != Integer.MIN_VALUE ? initialPage.getItemsAfter() : 0, 0, this, (initialPage.getItemsBefore() == Integer.MIN_VALUE || initialPage.getItemsAfter() == Integer.MIN_VALUE) ? false : true);
        } else {
            getStorage$paging_common().init(0, initialPage, 0, initialPage.getItemsBefore() != Integer.MIN_VALUE ? initialPage.getItemsBefore() : 0, this, false);
        }
        triggerBoundaryCallback(LoadType.REFRESH, initialPage.getData());
    }

    /* compiled from: ContiguousPagedList.jvmAndAndroid.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\tJ%\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Landroidx/paging/ContiguousPagedList$Companion;", "", "<init>", "()V", "getPrependItemsRequested", "", "prefetchDistance", FirebaseAnalytics.Param.INDEX, "leadingNulls", "getPrependItemsRequested$paging_common", "getAppendItemsRequested", "itemsBeforeTrailingNulls", "getAppendItemsRequested$paging_common", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getAppendItemsRequested$paging_common(int i, int i2, int i3) {
            return ((i2 + i) + 1) - i3;
        }

        public final int getPrependItemsRequested$paging_common(int i, int i2, int i3) {
            return i - (i2 - i3);
        }

        private Companion() {
        }
    }

    @Override // androidx.paging.PagedList
    public K getLastKey() {
        K refreshKey;
        PagingState<?, V> refreshKeyInfo = getStorage$paging_common().getRefreshKeyInfo(getConfig());
        return (refreshKeyInfo == null || (refreshKey = this.pagingSource.getRefreshKey(refreshKeyInfo)) == null) ? this.initialLastKey : refreshKey;
    }

    @Override // androidx.paging.PagedList
    public boolean isDetached() {
        return this.pager.isDetached();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r0.isEmpty() == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
        if (r0.isEmpty() == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onPageResult(LoadType type, PagingSource.LoadResult.Page<?, V> page) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(page, "page");
        List<? extends V> data = page.getData();
        boolean z = true;
        boolean z2 = lastLoad() > getStorage$paging_common().getMiddleOfLoadedRange();
        boolean z3 = this.shouldTrim && getStorage$paging_common().shouldPreTrimNewPage(getConfig().maxSize, getRequiredRemainder$paging_common(), data.size());
        if (type != LoadType.APPEND) {
            if (type != LoadType.PREPEND) {
                throw new IllegalArgumentException("unexpected result type " + type);
            }
            if (z3 && z2) {
                this.prependItemsRequested = 0;
            } else {
                getStorage$paging_common().prependPage$paging_common(page, this);
                int size = this.prependItemsRequested - data.size();
                this.prependItemsRequested = size;
                if (size > 0) {
                }
            }
            z = false;
            if (this.shouldTrim) {
            }
            triggerBoundaryCallback(type, data);
            return z;
        }
        if (z3 && !z2) {
            this.appendItemsRequested = 0;
        } else {
            getStorage$paging_common().appendPage$paging_common(page, this);
            int size2 = this.appendItemsRequested - data.size();
            this.appendItemsRequested = size2;
            if (size2 > 0) {
            }
        }
        z = false;
        if (this.shouldTrim) {
            LegacyPageFetcher<K, V> legacyPageFetcher = this.pager;
            if (z2) {
                if (!(legacyPageFetcher.getLoadStateManager().getStartState() instanceof LoadState.Loading) && getStorage$paging_common().trimFromFront$paging_common(this.replacePagesWithNulls, getConfig().maxSize, getRequiredRemainder$paging_common(), this)) {
                    this.pager.getLoadStateManager().setState(LoadType.PREPEND, LoadState.NotLoading.Companion.getIncomplete$paging_common());
                }
            } else if (!(legacyPageFetcher.getLoadStateManager().getEndState() instanceof LoadState.Loading) && getStorage$paging_common().trimFromEnd$paging_common(this.replacePagesWithNulls, getConfig().maxSize, getRequiredRemainder$paging_common(), this)) {
                this.pager.getLoadStateManager().setState(LoadType.APPEND, LoadState.NotLoading.Companion.getIncomplete$paging_common());
            }
        }
        triggerBoundaryCallback(type, data);
        return z;
    }

    @Override // androidx.paging.LegacyPageFetcher.PageConsumer
    public void onStateChanged(LoadType type, LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        dispatchStateChangeAsync$paging_common(type, state);
    }

    private final void triggerBoundaryCallback(LoadType loadType, List<? extends V> list) {
        if (this.boundaryCallback != null) {
            boolean z = true;
            boolean z2 = getStorage$paging_common().size() == 0;
            boolean z3 = !z2 && loadType == LoadType.PREPEND && list.isEmpty();
            if (z2 || loadType != LoadType.APPEND || !list.isEmpty()) {
                z = false;
            }
            deferBoundaryCallbacks$paging_common(z2, z3, z);
        }
    }

    public final void deferBoundaryCallbacks$paging_common(boolean z, boolean z2, boolean z3) {
        if (this.boundaryCallback == null) {
            throw new IllegalStateException("Can't defer BoundaryCallback, no instance");
        }
        if (this.lowestIndexAccessed == Integer.MAX_VALUE) {
            this.lowestIndexAccessed = getStorage$paging_common().size();
        }
        if (this.highestIndexAccessed == Integer.MIN_VALUE) {
            this.highestIndexAccessed = 0;
        }
        if (z || z2 || z3) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope$paging_common(), getNotifyDispatcher$paging_common(), null, new ContiguousPagedList$deferBoundaryCallbacks$1(z, this, z2, z3, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryDispatchBoundaryCallbacks(boolean z) {
        boolean z2 = true;
        boolean z3 = this.boundaryCallbackBeginDeferred && this.lowestIndexAccessed <= getConfig().prefetchDistance;
        if (!this.boundaryCallbackEndDeferred || this.highestIndexAccessed < (size() - 1) - getConfig().prefetchDistance) {
            z2 = false;
        }
        if (z3 || z2) {
            if (z3) {
                this.boundaryCallbackBeginDeferred = false;
            }
            if (z2) {
                this.boundaryCallbackEndDeferred = false;
            }
            if (z) {
                BuildersKt__Builders_commonKt.launch$default(getCoroutineScope$paging_common(), getNotifyDispatcher$paging_common(), null, new ContiguousPagedList$tryDispatchBoundaryCallbacks$1(this, z3, z2, null), 2, null);
            } else {
                dispatchBoundaryCallbacks(z3, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchBoundaryCallbacks(boolean z, boolean z2) {
        if (z) {
            PagedList.BoundaryCallback<V> boundaryCallback = this.boundaryCallback;
            Intrinsics.checkNotNull(boundaryCallback);
            boundaryCallback.onItemAtFrontLoaded(getStorage$paging_common().getFirstLoadedItem$paging_common());
        }
        if (z2) {
            PagedList.BoundaryCallback<V> boundaryCallback2 = this.boundaryCallback;
            Intrinsics.checkNotNull(boundaryCallback2);
            boundaryCallback2.onItemAtEndLoaded(getStorage$paging_common().getLastLoadedItem$paging_common());
        }
    }

    @Override // androidx.paging.PagedList
    public void retry() {
        Runnable refreshRetryCallback$paging_common;
        super.retry();
        this.pager.retry();
        if (!(this.pager.getLoadStateManager().getRefreshState() instanceof LoadState.Error) || (refreshRetryCallback$paging_common = getRefreshRetryCallback$paging_common()) == null) {
            return;
        }
        refreshRetryCallback$paging_common.run();
    }

    @Override // androidx.paging.PagedList
    public void dispatchCurrentLoadState(Function2<? super LoadType, ? super LoadState, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.pager.getLoadStateManager().dispatchCurrentLoadState(callback);
    }

    @Override // androidx.paging.PagedList
    public void setInitialLoadState(LoadType loadType, LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        this.pager.getLoadStateManager().setState(loadType, loadState);
    }

    @Override // androidx.paging.PagedList
    public void loadAroundInternal(int i) {
        Companion companion = Companion;
        int prependItemsRequested$paging_common = companion.getPrependItemsRequested$paging_common(getConfig().prefetchDistance, i, getStorage$paging_common().getPlaceholdersBefore());
        int appendItemsRequested$paging_common = companion.getAppendItemsRequested$paging_common(getConfig().prefetchDistance, i, getStorage$paging_common().getPlaceholdersBefore() + getStorage$paging_common().getDataCount());
        int max = Math.max(prependItemsRequested$paging_common, this.prependItemsRequested);
        this.prependItemsRequested = max;
        if (max > 0) {
            this.pager.trySchedulePrepend();
        }
        int max2 = Math.max(appendItemsRequested$paging_common, this.appendItemsRequested);
        this.appendItemsRequested = max2;
        if (max2 > 0) {
            this.pager.tryScheduleAppend();
        }
        this.lowestIndexAccessed = Math.min(this.lowestIndexAccessed, i);
        this.highestIndexAccessed = Math.max(this.highestIndexAccessed, i);
        tryDispatchBoundaryCallbacks(true);
    }

    @Override // androidx.paging.PagedList
    public void detach() {
        this.pager.detach();
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onInitialized(int i) {
        boolean z = false;
        notifyInserted$paging_common(0, i);
        this.replacePagesWithNulls = (getStorage$paging_common().getPlaceholdersBefore() > 0 || getStorage$paging_common().getPlaceholdersAfter() > 0) ? true : true;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagePrepended(int i, int i2, int i3) {
        notifyChanged(i, i2);
        notifyInserted$paging_common(0, i3);
        this.lowestIndexAccessed += i3;
        this.highestIndexAccessed += i3;
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPageAppended(int i, int i2, int i3) {
        notifyChanged(i, i2);
        notifyInserted$paging_common(i + i2, i3);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesRemoved(int i, int i2) {
        notifyRemoved(i, i2);
    }

    @Override // androidx.paging.PagedStorage.Callback
    public void onPagesSwappedToPlaceholder(int i, int i2) {
        notifyChanged(i, i2);
    }
}
