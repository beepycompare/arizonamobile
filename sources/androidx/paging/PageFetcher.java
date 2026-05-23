package androidx.paging;

import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
/* compiled from: PageFetcher.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0005./012B[\u0012(\u0010\u0004\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0015J\u0017\u0010\u001f\u001a\u00020\u00152\n\b\u0002\u0010 \u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0015J\b\u0010#\u001a\u00020\u0015H\u0002JB\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010%0\u0017*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&2\u0006\u0010'\u001a\u00020(2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010*H\u0002J0\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007H\u0082@¢\u0006\u0002\u0010-R2\u0010\u0004\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u00063"}, d2 = {"Landroidx/paging/PageFetcher;", "Key", "", "Value", "pagingSourceFactory", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/PagingSource;", "initialKey", "config", "Landroidx/paging/PagingConfig;", "remoteMediator", "Landroidx/paging/RemoteMediator;", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/paging/PagingConfig;Landroidx/paging/RemoteMediator;)V", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/Object;", "loadRequests", "Landroidx/paging/ConflatedEventBus;", "Landroidx/paging/PageFetcher$LoadRequest;", "retryEvents", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "load", "loadType", "Landroidx/paging/LoadType;", "refreshAll", "refresh", "item", "(Ljava/lang/Object;)V", "retry", "invalidate", "injectRemoteEvents", "Landroidx/paging/PageEvent;", "Landroidx/paging/PageFetcherSnapshot;", "job", "Lkotlinx/coroutines/Job;", "accessor", "Landroidx/paging/RemoteMediatorAccessor;", "generateNewPagingSource", "currentPagingSource", "(Landroidx/paging/PagingSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PagerUiReceiver", "PagerHintReceiver", "GenerationInfo", "LoadRequest", "RefreshType", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcher<Key, Value> {
    private final PagingConfig config;
    private final Flow<PagingData<Value>> flow;
    private final Key initialKey;
    private final ConflatedEventBus<LoadRequest> loadRequests;
    private final Function1<Continuation<? super PagingSource<Key, Value>>, Object> pagingSourceFactory;
    private final ConflatedEventBus<Unit> retryEvents;

    /* compiled from: PageFetcher.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.APPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageFetcher(Function1<? super Continuation<? super PagingSource<Key, Value>>, ? extends Object> pagingSourceFactory, Key key, PagingConfig config, RemoteMediator<Key, Value> remoteMediator) {
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        this.pagingSourceFactory = pagingSourceFactory;
        this.initialKey = key;
        this.config = config;
        this.loadRequests = new ConflatedEventBus<>(null, 1, null);
        this.retryEvents = new ConflatedEventBus<>(null, 1, null);
        this.flow = SimpleChannelFlowKt.simpleChannelFlow(new PageFetcher$flow$1(remoteMediator, this, null));
    }

    public /* synthetic */ PageFetcher(Function1 function1, Object obj, PagingConfig pagingConfig, RemoteMediator remoteMediator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, obj, pagingConfig, (i & 8) != 0 ? null : remoteMediator);
    }

    public final Flow<PagingData<Value>> getFlow() {
        return this.flow;
    }

    public final void load(LoadType loadType) {
        LoadRequest.Append append;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i == 1) {
            append = LoadRequest.Append.INSTANCE;
        } else if (i != 2) {
            if (i == 3) {
                throw new IllegalArgumentException("Load only applies to APPEND or PREPEND");
            }
            throw new NoWhenBranchMatchedException();
        } else {
            append = LoadRequest.Prepend.INSTANCE;
        }
        this.loadRequests.send(append);
    }

    public final void refreshAll() {
        this.loadRequests.send(new LoadRequest.Refresh(true, RefreshType.All.INSTANCE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refresh$default(PageFetcher pageFetcher, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        pageFetcher.refresh(obj);
    }

    public final void refresh(Value value) {
        this.loadRequests.send(new LoadRequest.Refresh(true, value == null ? RefreshType.Anchor.INSTANCE : new RefreshType.Item(value)));
    }

    public final void retry() {
        this.retryEvents.send(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidate() {
        this.loadRequests.send(new LoadRequest.Refresh(false, RefreshType.Anchor.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<PageEvent<Value>> injectRemoteEvents(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Job job, RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor) {
        if (remoteMediatorAccessor == null) {
            return pageFetcherSnapshot.getPageEventFlow();
        }
        return CancelableChannelFlowKt.cancelableChannelFlow(job, new PageFetcher$injectRemoteEvents$1(remoteMediatorAccessor, pageFetcherSnapshot, new MutableLoadStateCollection(), null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object generateNewPagingSource(PagingSource<Key, Value> pagingSource, Continuation<? super PagingSource<Key, Value>> continuation) {
        PageFetcher$generateNewPagingSource$1 pageFetcher$generateNewPagingSource$1;
        int i;
        PagingSource<Key, Value> pagingSource2;
        if (continuation instanceof PageFetcher$generateNewPagingSource$1) {
            pageFetcher$generateNewPagingSource$1 = (PageFetcher$generateNewPagingSource$1) continuation;
            if ((pageFetcher$generateNewPagingSource$1.label & Integer.MIN_VALUE) != 0) {
                pageFetcher$generateNewPagingSource$1.label -= Integer.MIN_VALUE;
                Object obj = pageFetcher$generateNewPagingSource$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pageFetcher$generateNewPagingSource$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1<Continuation<? super PagingSource<Key, Value>>, Object> function1 = this.pagingSourceFactory;
                    pageFetcher$generateNewPagingSource$1.L$0 = pagingSource;
                    pageFetcher$generateNewPagingSource$1.label = 1;
                    obj = function1.invoke(pageFetcher$generateNewPagingSource$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    pagingSource = (PagingSource) pageFetcher$generateNewPagingSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pagingSource2 = (PagingSource) obj;
                if (pagingSource2 instanceof CompatLegacyPagingSource) {
                    ((CompatLegacyPagingSource) pagingSource2).setPageSize(this.config.pageSize);
                }
                if (pagingSource2 != pagingSource) {
                    throw new IllegalStateException("An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource.".toString());
                }
                pagingSource2.registerInvalidatedCallback(new PageFetcher$generateNewPagingSource$3(this));
                if (pagingSource != null) {
                    pagingSource.unregisterInvalidatedCallback(new PageFetcher$generateNewPagingSource$4(this));
                }
                if (pagingSource != null) {
                    pagingSource.invalidate();
                }
                PagingLogger pagingLogger = PagingLogger.INSTANCE;
                if (pagingLogger.isLoggable(3)) {
                    pagingLogger.log(3, "Generated new PagingSource " + pagingSource2, null);
                }
                return pagingSource2;
            }
        }
        pageFetcher$generateNewPagingSource$1 = new PageFetcher$generateNewPagingSource$1(this, continuation);
        Object obj2 = pageFetcher$generateNewPagingSource$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pageFetcher$generateNewPagingSource$1.label;
        if (i != 0) {
        }
        pagingSource2 = (PagingSource) obj2;
        if (pagingSource2 instanceof CompatLegacyPagingSource) {
        }
        if (pagingSource2 != pagingSource) {
        }
    }

    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/paging/PageFetcher$PagerUiReceiver;", "Landroidx/paging/UiReceiver;", "retryEventBus", "Landroidx/paging/ConflatedEventBus;", "", "<init>", "(Landroidx/paging/PageFetcher;Landroidx/paging/ConflatedEventBus;)V", "retry", "refresh", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class PagerUiReceiver implements UiReceiver {
        private final ConflatedEventBus<Unit> retryEventBus;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        public PagerUiReceiver(PageFetcher pageFetcher, ConflatedEventBus<Unit> retryEventBus) {
            Intrinsics.checkNotNullParameter(retryEventBus, "retryEventBus");
            this.this$0 = pageFetcher;
            this.retryEventBus = retryEventBus;
        }

        @Override // androidx.paging.UiReceiver
        public void retry() {
            this.retryEventBus.send(Unit.INSTANCE);
        }

        @Override // androidx.paging.UiReceiver
        public void refresh() {
            PageFetcher.refresh$default(this.this$0, null, 1, null);
        }
    }

    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00068\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Landroidx/paging/PageFetcher$PagerHintReceiver;", "Key", "", "Value", "Landroidx/paging/HintReceiver;", "pageFetcherSnapshot", "Landroidx/paging/PageFetcherSnapshot;", "<init>", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;)V", "getPageFetcherSnapshot$paging_common", "()Landroidx/paging/PageFetcherSnapshot;", "processHint", "", "viewportHint", "Landroidx/paging/ViewportHint;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class PagerHintReceiver<Key, Value> implements HintReceiver {
        private final PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        public PagerHintReceiver(PageFetcher pageFetcher, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot) {
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot, "pageFetcherSnapshot");
            this.this$0 = pageFetcher;
            this.pageFetcherSnapshot = pageFetcherSnapshot;
        }

        public final PageFetcherSnapshot<Key, Value> getPageFetcherSnapshot$paging_common() {
            return this.pageFetcherSnapshot;
        }

        @Override // androidx.paging.HintReceiver
        public void processHint(ViewportHint viewportHint) {
            Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
            this.pageFetcherSnapshot.processHint(viewportHint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B9\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "", "Value", "snapshot", "Landroidx/paging/PageFetcherSnapshot;", "cachedInitialState", "Landroidx/paging/PagingState;", "job", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/PagingState;Lkotlinx/coroutines/Job;)V", "getSnapshot", "()Landroidx/paging/PageFetcherSnapshot;", "getCachedInitialState", "()Landroidx/paging/PagingState;", "getJob", "()Lkotlinx/coroutines/Job;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class GenerationInfo<Key, Value> {
        private final PagingState<Key, Value> cachedInitialState;
        private final Job job;
        private final PageFetcherSnapshot<Key, Value> snapshot;

        public GenerationInfo(PageFetcherSnapshot<Key, Value> snapshot, PagingState<Key, Value> pagingState, Job job) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            Intrinsics.checkNotNullParameter(job, "job");
            this.snapshot = snapshot;
            this.cachedInitialState = pagingState;
            this.job = job;
        }

        public final PageFetcherSnapshot<Key, Value> getSnapshot() {
            return this.snapshot;
        }

        public final PagingState<Key, Value> getCachedInitialState() {
            return this.cachedInitialState;
        }

        public final Job getJob() {
            return this.job;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Landroidx/paging/PageFetcher$LoadRequest;", "", "loadType", "Landroidx/paging/LoadType;", "<init>", "(Landroidx/paging/LoadType;)V", "getLoadType", "()Landroidx/paging/LoadType;", HttpHeaders.REFRESH, "Append", "Prepend", "Landroidx/paging/PageFetcher$LoadRequest$Append;", "Landroidx/paging/PageFetcher$LoadRequest$Prepend;", "Landroidx/paging/PageFetcher$LoadRequest$Refresh;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadRequest {
        private final LoadType loadType;

        public /* synthetic */ LoadRequest(LoadType loadType, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadType);
        }

        private LoadRequest(LoadType loadType) {
            this.loadType = loadType;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        /* compiled from: PageFetcher.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/PageFetcher$LoadRequest$Refresh;", "Landroidx/paging/PageFetcher$LoadRequest;", "triggerRemoteRefresh", "", "type", "Landroidx/paging/PageFetcher$RefreshType;", "<init>", "(ZLandroidx/paging/PageFetcher$RefreshType;)V", "getTriggerRemoteRefresh", "()Z", "getType", "()Landroidx/paging/PageFetcher$RefreshType;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Refresh extends LoadRequest {
            private final boolean triggerRemoteRefresh;
            private final RefreshType type;

            public final boolean getTriggerRemoteRefresh() {
                return this.triggerRemoteRefresh;
            }

            public final RefreshType getType() {
                return this.type;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Refresh(boolean z, RefreshType type) {
                super(LoadType.REFRESH, null);
                Intrinsics.checkNotNullParameter(type, "type");
                this.triggerRemoteRefresh = z;
                this.type = type;
            }
        }

        /* compiled from: PageFetcher.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/PageFetcher$LoadRequest$Append;", "Landroidx/paging/PageFetcher$LoadRequest;", "<init>", "()V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Append extends LoadRequest {
            public static final Append INSTANCE = new Append();

            private Append() {
                super(LoadType.APPEND, null);
            }
        }

        /* compiled from: PageFetcher.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/PageFetcher$LoadRequest$Prepend;", "Landroidx/paging/PageFetcher$LoadRequest;", "<init>", "()V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Prepend extends LoadRequest {
            public static final Prepend INSTANCE = new Prepend();

            private Prepend() {
                super(LoadType.PREPEND, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Landroidx/paging/PageFetcher$RefreshType;", "", "<init>", "()V", "Initial", "All", "Anchor", "Item", "Landroidx/paging/PageFetcher$RefreshType$All;", "Landroidx/paging/PageFetcher$RefreshType$Anchor;", "Landroidx/paging/PageFetcher$RefreshType$Initial;", "Landroidx/paging/PageFetcher$RefreshType$Item;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class RefreshType {
        public /* synthetic */ RefreshType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PageFetcher.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/PageFetcher$RefreshType$Initial;", "Landroidx/paging/PageFetcher$RefreshType;", "<init>", "()V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Initial extends RefreshType {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }
        }

        private RefreshType() {
        }

        /* compiled from: PageFetcher.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/PageFetcher$RefreshType$All;", "Landroidx/paging/PageFetcher$RefreshType;", "<init>", "()V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class All extends RefreshType {
            public static final All INSTANCE = new All();

            private All() {
                super(null);
            }
        }

        /* compiled from: PageFetcher.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/paging/PageFetcher$RefreshType$Anchor;", "Landroidx/paging/PageFetcher$RefreshType;", "<init>", "()V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Anchor extends RefreshType {
            public static final Anchor INSTANCE = new Anchor();

            private Anchor() {
                super(null);
            }
        }

        /* compiled from: PageFetcher.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/paging/PageFetcher$RefreshType$Item;", "Landroidx/paging/PageFetcher$RefreshType;", "item", "", "<init>", "(Ljava/lang/Object;)V", "getItem", "()Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Item extends RefreshType {
            private final Object item;

            public static /* synthetic */ Item copy$default(Item item, Object obj, int i, Object obj2) {
                if ((i & 1) != 0) {
                    obj = item.item;
                }
                return item.copy(obj);
            }

            public final Object component1() {
                return this.item;
            }

            public final Item copy(Object item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new Item(item);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Item) && Intrinsics.areEqual(this.item, ((Item) obj).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "Item(item=" + this.item + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(Object item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final Object getItem() {
                return this.item;
            }
        }
    }
}
