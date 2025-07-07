package androidx.paging;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0003&'(BY\u0012(\u0010\u0004\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\f¢\u0006\u0002\u0010\rJ0\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0007H\u0082@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001e\u001a\u00020\u0019JB\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010 0\u000f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\"\u001a\u00020#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010%H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R2\u0010\u0004\u001a$\b\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/paging/PageFetcher;", "Key", "", "Value", "pagingSourceFactory", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/PagingSource;", "initialKey", "config", "Landroidx/paging/PagingConfig;", "remoteMediator", "Landroidx/paging/RemoteMediator;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/paging/PagingConfig;Landroidx/paging/RemoteMediator;)V", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "refreshEvents", "Landroidx/paging/ConflatedEventBus;", "", "retryEvents", "", "generateNewPagingSource", "previousPagingSource", "(Landroidx/paging/PagingSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidate", "refresh", "injectRemoteEvents", "Landroidx/paging/PageEvent;", "Landroidx/paging/PageFetcherSnapshot;", "job", "Lkotlinx/coroutines/Job;", "accessor", "Landroidx/paging/RemoteMediatorAccessor;", "GenerationInfo", "PagerHintReceiver", "PagerUiReceiver", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcher<Key, Value> {
    private final PagingConfig config;
    private final Flow<PagingData<Value>> flow;
    private final Key initialKey;
    private final Function1<Continuation<? super PagingSource<Key, Value>>, Object> pagingSourceFactory;
    private final ConflatedEventBus<Boolean> refreshEvents;
    private final ConflatedEventBus<Unit> retryEvents;

    /* JADX WARN: Multi-variable type inference failed */
    public PageFetcher(Function1<? super Continuation<? super PagingSource<Key, Value>>, ? extends Object> pagingSourceFactory, Key key, PagingConfig config, RemoteMediator<Key, Value> remoteMediator) {
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        this.pagingSourceFactory = pagingSourceFactory;
        this.initialKey = key;
        this.config = config;
        this.refreshEvents = new ConflatedEventBus<>(null, 1, null);
        this.retryEvents = new ConflatedEventBus<>(null, 1, null);
        this.flow = SimpleChannelFlowKt.simpleChannelFlow(new PageFetcher$flow$1(remoteMediator, this, null));
    }

    public /* synthetic */ PageFetcher(Function1 function1, Object obj, PagingConfig pagingConfig, RemoteMediator remoteMediator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, obj, pagingConfig, (i & 8) != 0 ? null : remoteMediator);
    }

    public final Flow<PagingData<Value>> getFlow() {
        return this.flow;
    }

    public final void refresh() {
        this.refreshEvents.send(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidate() {
        this.refreshEvents.send(false);
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
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object generateNewPagingSource(PagingSource<Key, Value> pagingSource, Continuation<? super PagingSource<Key, Value>> continuation) {
        PageFetcher$generateNewPagingSource$1 pageFetcher$generateNewPagingSource$1;
        int i;
        PageFetcher<Key, Value> pageFetcher;
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
                    pageFetcher$generateNewPagingSource$1.L$0 = this;
                    pageFetcher$generateNewPagingSource$1.L$1 = pagingSource;
                    pageFetcher$generateNewPagingSource$1.label = 1;
                    obj = function1.invoke(pageFetcher$generateNewPagingSource$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pageFetcher = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    pagingSource = (PagingSource) pageFetcher$generateNewPagingSource$1.L$1;
                    pageFetcher = (PageFetcher) pageFetcher$generateNewPagingSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pagingSource2 = (PagingSource) obj;
                if (pagingSource2 instanceof CompatLegacyPagingSource) {
                    ((CompatLegacyPagingSource) pagingSource2).setPageSize(pageFetcher.config.pageSize);
                }
                if (pagingSource2 != pagingSource) {
                    throw new IllegalStateException("An instance of PagingSource was re-used when Pager expected to create a new\ninstance. Ensure that the pagingSourceFactory passed to Pager always returns a\nnew instance of PagingSource.".toString());
                }
                pagingSource2.registerInvalidatedCallback(new PageFetcher$generateNewPagingSource$3(pageFetcher));
                if (pagingSource != null) {
                    pagingSource.unregisterInvalidatedCallback(new PageFetcher$generateNewPagingSource$4(pageFetcher));
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
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/PageFetcher$PagerUiReceiver;", "Landroidx/paging/UiReceiver;", "retryEventBus", "Landroidx/paging/ConflatedEventBus;", "", "(Landroidx/paging/PageFetcher;Landroidx/paging/ConflatedEventBus;)V", "refresh", "retry", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
            this.this$0.refresh();
        }
    }

    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00068\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Landroidx/paging/PageFetcher$PagerHintReceiver;", "Key", "", "Value", "Landroidx/paging/HintReceiver;", "pageFetcherSnapshot", "Landroidx/paging/PageFetcherSnapshot;", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;)V", "getPageFetcherSnapshot$paging_common_release", "()Landroidx/paging/PageFetcherSnapshot;", "accessHint", "", "viewportHint", "Landroidx/paging/ViewportHint;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class PagerHintReceiver<Key, Value> implements HintReceiver {
        private final PageFetcherSnapshot<Key, Value> pageFetcherSnapshot;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        public PagerHintReceiver(PageFetcher pageFetcher, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot) {
            Intrinsics.checkNotNullParameter(pageFetcherSnapshot, "pageFetcherSnapshot");
            this.this$0 = pageFetcher;
            this.pageFetcherSnapshot = pageFetcherSnapshot;
        }

        public final PageFetcherSnapshot<Key, Value> getPageFetcherSnapshot$paging_common_release() {
            return this.pageFetcherSnapshot;
        }

        @Override // androidx.paging.HintReceiver
        public void accessHint(ViewportHint viewportHint) {
            Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
            this.pageFetcherSnapshot.accessHint(viewportHint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B7\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "", "Value", "snapshot", "Landroidx/paging/PageFetcherSnapshot;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/paging/PagingState;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/PagingState;Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getSnapshot", "()Landroidx/paging/PageFetcherSnapshot;", "getState", "()Landroidx/paging/PagingState;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class GenerationInfo<Key, Value> {
        private final Job job;
        private final PageFetcherSnapshot<Key, Value> snapshot;
        private final PagingState<Key, Value> state;

        public GenerationInfo(PageFetcherSnapshot<Key, Value> snapshot, PagingState<Key, Value> pagingState, Job job) {
            Intrinsics.checkNotNullParameter(snapshot, "snapshot");
            Intrinsics.checkNotNullParameter(job, "job");
            this.snapshot = snapshot;
            this.state = pagingState;
            this.job = job;
        }

        public final PageFetcherSnapshot<Key, Value> getSnapshot() {
            return this.snapshot;
        }

        public final PagingState<Key, Value> getState() {
            return this.state;
        }

        public final Job getJob() {
            return this.job;
        }
    }
}
