package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
/* compiled from: Pager.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002BM\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b\u0012\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0\n¢\u0006\u0004\b\f\u0010\rB7\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b0\n¢\u0006\u0004\b\f\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0013\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00028\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u001aR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0012R#\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00150\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Landroidx/paging/Pager;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "initialKey", "remoteMediator", "Landroidx/paging/RemoteMediator;", "pagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "<init>", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Landroidx/paging/RemoteMediator;Lkotlin/jvm/functions/Function0;)V", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "pageFetcher", "Landroidx/paging/PageFetcher;", "getPageFetcher$annotations", "()V", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getFlow$annotations", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "append", "", "prepend", "refresh", "item", "(Ljava/lang/Object;)V", "retry", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Pager<Key, Value> {
    private final Flow<PagingData<Value>> flow;
    private final PageFetcher<Key, Value> pageFetcher;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pager(PagingConfig config, Function0<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        this(config, null, pagingSourceFactory, 2, null);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
    }

    public static /* synthetic */ void getFlow$annotations() {
    }

    private static /* synthetic */ void getPageFetcher$annotations() {
    }

    public Pager(PagingConfig config, Key key, RemoteMediator<Key, Value> remoteMediator, Function0<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        Pager$pageFetcher$2 pager$pageFetcher$2;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
        if (pagingSourceFactory instanceof SuspendingPagingSourceFactory) {
            pager$pageFetcher$2 = new Pager$pageFetcher$1((SuspendingPagingSourceFactory) pagingSourceFactory);
        } else {
            pager$pageFetcher$2 = new Pager$pageFetcher$2(pagingSourceFactory, null);
        }
        PageFetcher<Key, Value> pageFetcher = new PageFetcher<>(pager$pageFetcher$2, key, config, remoteMediator);
        this.pageFetcher = pageFetcher;
        this.flow = pageFetcher.getFlow();
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, RemoteMediator remoteMediator, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig, (i & 2) != 0 ? null : obj, remoteMediator, function0);
    }

    public /* synthetic */ Pager(PagingConfig pagingConfig, Object obj, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig, (i & 2) != 0 ? null : obj, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Pager(PagingConfig config, Key key, Function0<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        this(config, key, null, pagingSourceFactory);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
    }

    public final Flow<PagingData<Value>> getFlow() {
        return this.flow;
    }

    public final void append() {
        this.pageFetcher.load(LoadType.APPEND);
    }

    public final void prepend() {
        this.pageFetcher.load(LoadType.PREPEND);
    }

    public final void refresh() {
        this.pageFetcher.refreshAll();
    }

    public final void refresh(Value item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.pageFetcher.refresh(item);
    }

    public final void retry() {
        this.pageFetcher.retry();
    }
}
