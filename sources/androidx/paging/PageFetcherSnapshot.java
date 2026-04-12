package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PageFetcherSnapshotState;
import androidx.paging.PagingSource;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
/* compiled from: PageFetcherSnapshot.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B{\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J \u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0082@¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/J\u0006\u00102\u001a\u00020\u000bJ\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0086@¢\u0006\u0002\u00104J\f\u00105\u001a\u00020\u000b*\u000206H\u0002J \u00107\u001a\u00020\u000b*\b\u0012\u0004\u0012\u0002080\n2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u00109J%\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;2\u0006\u0010,\u001a\u00020-2\b\u0010<\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u00104J\u001e\u0010?\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-2\u0006\u0010@\u001a\u00020AH\u0082@¢\u0006\u0002\u0010BJ5\u0010C\u001a\u00020D2\u0006\u0010,\u001a\u00020-2\b\u0010E\u001a\u0004\u0018\u00018\u00002\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010GH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010J2\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u0010KJ.\u0010L\u001a\u00020\u000b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010J2\u0006\u0010,\u001a\u00020-2\u0006\u0010M\u001a\u00020NH\u0082@¢\u0006\u0002\u0010OJ7\u0010P\u001a\u0004\u0018\u00018\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010J2\u0006\u0010,\u001a\u00020-2\u0006\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u000208H\u0002¢\u0006\u0002\u0010SJ\b\u0010T\u001a\u00020\u000bH\u0002R\u0018\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#0\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006U"}, d2 = {"Landroidx/paging/PageFetcherSnapshot;", "Key", "", "Value", "initialKey", "pagingSource", "Landroidx/paging/PagingSource;", "config", "Landroidx/paging/PagingConfig;", "retryFlow", "Lkotlinx/coroutines/flow/Flow;", "", "remoteMediatorConnection", "Landroidx/paging/RemoteMediatorConnection;", "previousPagingState", "Landroidx/paging/PagingState;", "jumpCallback", "Lkotlin/Function0;", "<init>", "(Ljava/lang/Object;Landroidx/paging/PagingSource;Landroidx/paging/PagingConfig;Lkotlinx/coroutines/flow/Flow;Landroidx/paging/RemoteMediatorConnection;Landroidx/paging/PagingState;Lkotlin/jvm/functions/Function0;)V", "getInitialKey$paging_common", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPagingSource$paging_common", "()Landroidx/paging/PagingSource;", "getRemoteMediatorConnection", "()Landroidx/paging/RemoteMediatorConnection;", "hintHandler", "Landroidx/paging/HintHandler;", "pageEventChCollected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Landroidx/paging/internal/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pageEventCh", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/paging/PageEvent;", "stateHolder", "Landroidx/paging/PageFetcherSnapshotState$Holder;", "pageEventChannelFlowJob", "Lkotlinx/coroutines/CompletableJob;", "pageEventFlow", "getPageEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "retryLoadError", "loadType", "Landroidx/paging/LoadType;", "viewportHint", "Landroidx/paging/ViewportHint;", "(Landroidx/paging/LoadType;Landroidx/paging/ViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accessHint", "close", "currentPagingState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startConsumingHints", "Lkotlinx/coroutines/CoroutineScope;", "collectAsGenerationalViewportHints", "", "(Lkotlinx/coroutines/flow/Flow;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadParams", "Landroidx/paging/PagingSource$LoadParams;", "key", "(Landroidx/paging/LoadType;Ljava/lang/Object;)Landroidx/paging/PagingSource$LoadParams;", "doInitialLoad", "doLoad", "generationalHint", "Landroidx/paging/GenerationalViewportHint;", "(Landroidx/paging/LoadType;Landroidx/paging/GenerationalViewportHint;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadResultLog", "", "loadKey", "result", "Landroidx/paging/PagingSource$LoadResult;", "(Landroidx/paging/LoadType;Ljava/lang/Object;Landroidx/paging/PagingSource$LoadResult;)Ljava/lang/String;", "setLoading", "Landroidx/paging/PageFetcherSnapshotState;", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setError", "error", "Landroidx/paging/LoadState$Error;", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;Landroidx/paging/LoadState$Error;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextLoadKeyOrNull", "generationId", "presentedItemsBeyondAnchor", "(Landroidx/paging/PageFetcherSnapshotState;Landroidx/paging/LoadType;II)Ljava/lang/Object;", "onInvalidLoad", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot<Key, Value> {
    private final PagingConfig config;
    private final HintHandler hintHandler;
    private final Key initialKey;
    private final Function0<Unit> jumpCallback;
    private final Channel<PageEvent<Value>> pageEventCh;
    private final AtomicBoolean pageEventChCollected;
    private final CompletableJob pageEventChannelFlowJob;
    private final Flow<PageEvent<Value>> pageEventFlow;
    private final PagingSource<Key, Value> pagingSource;
    private final PagingState<Key, Value> previousPagingState;
    private final RemoteMediatorConnection<Key, Value> remoteMediatorConnection;
    private final Flow<Unit> retryFlow;
    private final PageFetcherSnapshotState.Holder<Key, Value> stateHolder;

    /* compiled from: PageFetcherSnapshot.kt */
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

    public PageFetcherSnapshot(Key key, PagingSource<Key, Value> pagingSource, PagingConfig config, Flow<Unit> retryFlow, RemoteMediatorConnection<Key, Value> remoteMediatorConnection, PagingState<Key, Value> pagingState, Function0<Unit> jumpCallback) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(pagingSource, "pagingSource");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(retryFlow, "retryFlow");
        Intrinsics.checkNotNullParameter(jumpCallback, "jumpCallback");
        this.initialKey = key;
        this.pagingSource = pagingSource;
        this.config = config;
        this.retryFlow = retryFlow;
        this.remoteMediatorConnection = remoteMediatorConnection;
        this.previousPagingState = pagingState;
        this.jumpCallback = jumpCallback;
        if (config.jumpThreshold != Integer.MIN_VALUE && !pagingSource.getJumpingSupported()) {
            throw new IllegalArgumentException("PagingConfig.jumpThreshold was set, but the associated PagingSource has not marked support for jumps by overriding PagingSource.jumpingSupported to true.".toString());
        }
        this.hintHandler = new HintHandler();
        this.pageEventChCollected = new AtomicBoolean(false);
        this.pageEventCh = ChannelKt.Channel$default(-2, null, null, 6, null);
        this.stateHolder = new PageFetcherSnapshotState.Holder<>(config);
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.pageEventChannelFlowJob = Job$default;
        this.pageEventFlow = FlowKt.onStart(CancelableChannelFlowKt.cancelableChannelFlow(Job$default, new PageFetcherSnapshot$pageEventFlow$1(this, null)), new PageFetcherSnapshot$pageEventFlow$2(this, null));
    }

    public final Key getInitialKey$paging_common() {
        return this.initialKey;
    }

    public final PagingSource<Key, Value> getPagingSource$paging_common() {
        return this.pagingSource;
    }

    public final RemoteMediatorConnection<Key, Value> getRemoteMediatorConnection() {
        return this.remoteMediatorConnection;
    }

    public /* synthetic */ PageFetcherSnapshot(Object obj, PagingSource pagingSource, PagingConfig pagingConfig, Flow flow, RemoteMediatorConnection remoteMediatorConnection, PagingState pagingState, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, pagingSource, pagingConfig, flow, (i & 16) != 0 ? null : remoteMediatorConnection, (i & 32) != 0 ? null : pagingState, (i & 64) != 0 ? new Function0() { // from class: androidx.paging.PageFetcherSnapshot$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function0);
    }

    public final Flow<PageEvent<Value>> getPageEventFlow() {
        return this.pageEventFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object retryLoadError(LoadType loadType, ViewportHint viewportHint, Continuation<? super Unit> continuation) {
        if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1) {
            Object doInitialLoad = doInitialLoad(continuation);
            return doInitialLoad == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? doInitialLoad : Unit.INSTANCE;
        } else if (viewportHint == null) {
            throw new IllegalStateException("Cannot retry APPEND / PREPEND load on PagingSource without ViewportHint".toString());
        } else {
            this.hintHandler.forceSetHint(loadType, viewportHint);
            return Unit.INSTANCE;
        }
    }

    public final void accessHint(ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        this.hintHandler.processHint(viewportHint);
    }

    public final void close() {
        Job.DefaultImpls.cancel$default((Job) this.pageEventChannelFlowJob, (CancellationException) null, 1, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object currentPagingState(Continuation<? super PagingState<Key, Value>> continuation) {
        PageFetcherSnapshot$currentPagingState$1 pageFetcherSnapshot$currentPagingState$1;
        int i;
        PageFetcherSnapshotState.Holder<Key, Value> holder;
        Mutex mutex;
        try {
            if (continuation instanceof PageFetcherSnapshot$currentPagingState$1) {
                pageFetcherSnapshot$currentPagingState$1 = (PageFetcherSnapshot$currentPagingState$1) continuation;
                if ((pageFetcherSnapshot$currentPagingState$1.label & Integer.MIN_VALUE) != 0) {
                    pageFetcherSnapshot$currentPagingState$1.label -= Integer.MIN_VALUE;
                    Object obj = pageFetcherSnapshot$currentPagingState$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = pageFetcherSnapshot$currentPagingState$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        PageFetcherSnapshotState.Holder<Key, Value> holder2 = this.stateHolder;
                        Mutex mutex2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                        pageFetcherSnapshot$currentPagingState$1.L$0 = holder2;
                        pageFetcherSnapshot$currentPagingState$1.L$1 = mutex2;
                        pageFetcherSnapshot$currentPagingState$1.label = 1;
                        if (mutex2.lock(null, pageFetcherSnapshot$currentPagingState$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        holder = holder2;
                        mutex = mutex2;
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        mutex = (Mutex) pageFetcherSnapshot$currentPagingState$1.L$1;
                        holder = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$currentPagingState$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    return ((PageFetcherSnapshotState.Holder) holder).state.currentPagingState$paging_common(this.hintHandler.getLastAccessHint());
                }
            }
            return ((PageFetcherSnapshotState.Holder) holder).state.currentPagingState$paging_common(this.hintHandler.getLastAccessHint());
        } finally {
            mutex.unlock(null);
        }
        pageFetcherSnapshot$currentPagingState$1 = new PageFetcherSnapshot$currentPagingState$1(this, continuation);
        Object obj2 = pageFetcherSnapshot$currentPagingState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pageFetcherSnapshot$currentPagingState$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startConsumingHints(CoroutineScope coroutineScope) {
        if (this.config.jumpThreshold != Integer.MIN_VALUE) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$1(this, null), 3, null);
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PageFetcherSnapshot$startConsumingHints$3(this, null), 3, null);
    }

    private final PagingSource.LoadParams<Key> loadParams(LoadType loadType, Key key) {
        PagingSource.LoadParams.Companion companion = PagingSource.LoadParams.Companion;
        LoadType loadType2 = LoadType.REFRESH;
        PagingConfig pagingConfig = this.config;
        return companion.create(loadType, key, loadType == loadType2 ? pagingConfig.initialLoadSize : pagingConfig.pageSize, this.config.enablePlaceholders);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0117, code lost:
        if (r12 == r1) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0161 A[Catch: all -> 0x025c, TryCatch #5 {all -> 0x025c, blocks: (B:53:0x0139, B:55:0x0161, B:56:0x0172, B:58:0x017b), top: B:144:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017b A[Catch: all -> 0x025c, TRY_LEAVE, TryCatch #5 {all -> 0x025c, blocks: (B:53:0x0139, B:55:0x0161, B:56:0x0172, B:58:0x017b), top: B:144:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024e  */
    /* JADX WARN: Type inference failed for: r11v0, types: [androidx.paging.PageFetcherSnapshot, androidx.paging.PageFetcherSnapshot<Key, Value>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v38, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v9, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doInitialLoad(Continuation<? super Unit> continuation) {
        PageFetcherSnapshot$doInitialLoad$1 pageFetcherSnapshot$doInitialLoad$1;
        ?? r2;
        PageFetcherSnapshotState.Holder<Key, Value> holder;
        Mutex mutex;
        PageFetcherSnapshotState pageFetcherSnapshotState;
        LoadType loadType;
        PagingLogger pagingLogger;
        PageFetcherSnapshotState.Holder<Key, Value> holder2;
        Mutex mutex2;
        PagingSource.LoadResult loadResult;
        PageFetcherSnapshotState.Holder<Key, Value> holder3;
        Mutex mutex3;
        PagingSource.LoadResult loadResult2;
        boolean insert;
        PagingSource.LoadResult loadResult3;
        PageFetcherSnapshotState.Holder<Key, Value> holder4;
        Mutex mutex4;
        PagingSource.LoadResult loadResult4;
        Channel<PageEvent<Value>> channel;
        PageEvent<Value> pageEvent$paging_common;
        PageFetcherSnapshotState.Holder<Key, Value> holder5;
        Mutex mutex5;
        PagingSource.LoadResult loadResult5;
        PagingSource.LoadResult.Page page;
        Mutex mutex6;
        PageFetcherSnapshotState pageFetcherSnapshotState2;
        LoadState.Error error;
        LoadType loadType2;
        try {
            try {
                if (continuation instanceof PageFetcherSnapshot$doInitialLoad$1) {
                    pageFetcherSnapshot$doInitialLoad$1 = (PageFetcherSnapshot$doInitialLoad$1) continuation;
                    if ((pageFetcherSnapshot$doInitialLoad$1.label & Integer.MIN_VALUE) != 0) {
                        pageFetcherSnapshot$doInitialLoad$1.label -= Integer.MIN_VALUE;
                        Object obj = pageFetcherSnapshot$doInitialLoad$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        r2 = pageFetcherSnapshot$doInitialLoad$1.label;
                        switch (r2) {
                            case 0:
                                ResultKt.throwOnFailure(obj);
                                holder = this.stateHolder;
                                Mutex mutex7 = ((PageFetcherSnapshotState.Holder) holder).lock;
                                pageFetcherSnapshot$doInitialLoad$1.L$0 = holder;
                                pageFetcherSnapshot$doInitialLoad$1.L$1 = mutex7;
                                pageFetcherSnapshot$doInitialLoad$1.label = 1;
                                if (mutex7.lock(null, pageFetcherSnapshot$doInitialLoad$1) != coroutine_suspended) {
                                    mutex = mutex7;
                                    pageFetcherSnapshotState = ((PageFetcherSnapshotState.Holder) holder).state;
                                    loadType = LoadType.REFRESH;
                                    pageFetcherSnapshot$doInitialLoad$1.L$0 = mutex;
                                    pageFetcherSnapshot$doInitialLoad$1.L$1 = null;
                                    pageFetcherSnapshot$doInitialLoad$1.label = 2;
                                    r2 = mutex;
                                    if (setLoading(pageFetcherSnapshotState, loadType, pageFetcherSnapshot$doInitialLoad$1) == coroutine_suspended) {
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    r2.unlock(null);
                                    PagingSource.LoadParams<Key> loadParams = loadParams(LoadType.REFRESH, this.initialKey);
                                    pagingLogger = PagingLogger.INSTANCE;
                                    if (pagingLogger.isLoggable(3)) {
                                        pagingLogger.log(3, "Start REFRESH with loadKey " + this.initialKey + " on " + this.pagingSource, null);
                                    }
                                    PagingSource<Key, Value> pagingSource = this.pagingSource;
                                    pageFetcherSnapshot$doInitialLoad$1.L$0 = null;
                                    pageFetcherSnapshot$doInitialLoad$1.label = 3;
                                    obj = pagingSource.load(loadParams, pageFetcherSnapshot$doInitialLoad$1);
                                    break;
                                }
                                return coroutine_suspended;
                            case 1:
                                mutex = (Mutex) pageFetcherSnapshot$doInitialLoad$1.L$1;
                                holder = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                pageFetcherSnapshotState = ((PageFetcherSnapshotState.Holder) holder).state;
                                loadType = LoadType.REFRESH;
                                pageFetcherSnapshot$doInitialLoad$1.L$0 = mutex;
                                pageFetcherSnapshot$doInitialLoad$1.L$1 = null;
                                pageFetcherSnapshot$doInitialLoad$1.label = 2;
                                r2 = mutex;
                                if (setLoading(pageFetcherSnapshotState, loadType, pageFetcherSnapshot$doInitialLoad$1) == coroutine_suspended) {
                                }
                                Unit unit2 = Unit.INSTANCE;
                                r2.unlock(null);
                                PagingSource.LoadParams<Key> loadParams2 = loadParams(LoadType.REFRESH, this.initialKey);
                                pagingLogger = PagingLogger.INSTANCE;
                                if (pagingLogger.isLoggable(3)) {
                                }
                                PagingSource<Key, Value> pagingSource2 = this.pagingSource;
                                pageFetcherSnapshot$doInitialLoad$1.L$0 = null;
                                pageFetcherSnapshot$doInitialLoad$1.label = 3;
                                obj = pagingSource2.load(loadParams2, pageFetcherSnapshot$doInitialLoad$1);
                                break;
                            case 2:
                                Mutex mutex8 = (Mutex) pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                r2 = mutex8;
                                Unit unit22 = Unit.INSTANCE;
                                r2.unlock(null);
                                PagingSource.LoadParams<Key> loadParams22 = loadParams(LoadType.REFRESH, this.initialKey);
                                pagingLogger = PagingLogger.INSTANCE;
                                if (pagingLogger.isLoggable(3)) {
                                }
                                PagingSource<Key, Value> pagingSource22 = this.pagingSource;
                                pageFetcherSnapshot$doInitialLoad$1.L$0 = null;
                                pageFetcherSnapshot$doInitialLoad$1.label = 3;
                                obj = pagingSource22.load(loadParams22, pageFetcherSnapshot$doInitialLoad$1);
                                break;
                            case 3:
                                ResultKt.throwOnFailure(obj);
                                PagingSource.LoadResult loadResult6 = (PagingSource.LoadResult) obj;
                                if (loadResult6 instanceof PagingSource.LoadResult.Page) {
                                    holder3 = this.stateHolder;
                                    mutex3 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                                    pageFetcherSnapshot$doInitialLoad$1.L$0 = loadResult6;
                                    pageFetcherSnapshot$doInitialLoad$1.L$1 = holder3;
                                    pageFetcherSnapshot$doInitialLoad$1.L$2 = mutex3;
                                    pageFetcherSnapshot$doInitialLoad$1.label = 4;
                                    if (mutex3.lock(null, pageFetcherSnapshot$doInitialLoad$1) != coroutine_suspended) {
                                        loadResult2 = loadResult6;
                                        try {
                                            PageFetcherSnapshotState pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder3).state;
                                            insert = pageFetcherSnapshotState3.insert(0, LoadType.REFRESH, (PagingSource.LoadResult.Page) loadResult2);
                                            pageFetcherSnapshotState3.getSourceLoadStates$paging_common().set(LoadType.REFRESH, LoadState.NotLoading.Companion.getIncomplete$paging_common());
                                            if (((PagingSource.LoadResult.Page) loadResult2).getPrevKey() == null) {
                                                pageFetcherSnapshotState3.getSourceLoadStates$paging_common().set(LoadType.PREPEND, LoadState.NotLoading.Companion.getComplete$paging_common());
                                            }
                                            if (((PagingSource.LoadResult.Page) loadResult2).getNextKey() == null) {
                                                pageFetcherSnapshotState3.getSourceLoadStates$paging_common().set(LoadType.APPEND, LoadState.NotLoading.Companion.getComplete$paging_common());
                                            }
                                            if (!insert) {
                                                PagingLogger pagingLogger2 = PagingLogger.INSTANCE;
                                                if (pagingLogger2.isLoggable(3)) {
                                                    pagingLogger2.log(3, loadResultLog(LoadType.REFRESH, this.initialKey, loadResult2), null);
                                                }
                                                holder4 = this.stateHolder;
                                                Mutex mutex9 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                                pageFetcherSnapshot$doInitialLoad$1.L$0 = loadResult2;
                                                pageFetcherSnapshot$doInitialLoad$1.L$1 = holder4;
                                                pageFetcherSnapshot$doInitialLoad$1.L$2 = mutex9;
                                                pageFetcherSnapshot$doInitialLoad$1.label = 5;
                                                if (mutex9.lock(null, pageFetcherSnapshot$doInitialLoad$1) != coroutine_suspended) {
                                                    mutex4 = mutex9;
                                                    loadResult4 = loadResult2;
                                                    PageFetcherSnapshotState pageFetcherSnapshotState4 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                                    channel = this.pageEventCh;
                                                    pageEvent$paging_common = pageFetcherSnapshotState4.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult4, LoadType.REFRESH);
                                                    pageFetcherSnapshot$doInitialLoad$1.L$0 = loadResult4;
                                                    pageFetcherSnapshot$doInitialLoad$1.L$1 = mutex4;
                                                    pageFetcherSnapshot$doInitialLoad$1.L$2 = null;
                                                    pageFetcherSnapshot$doInitialLoad$1.label = 6;
                                                    if (channel.send(pageEvent$paging_common, pageFetcherSnapshot$doInitialLoad$1) == coroutine_suspended) {
                                                        loadResult3 = loadResult4;
                                                        r2 = mutex4;
                                                        Unit unit3 = Unit.INSTANCE;
                                                        if (this.remoteMediatorConnection != null) {
                                                            PagingSource.LoadResult.Page page2 = (PagingSource.LoadResult.Page) loadResult3;
                                                            if (page2.getPrevKey() == null || page2.getNextKey() == null) {
                                                                holder5 = this.stateHolder;
                                                                Mutex mutex10 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                                                pageFetcherSnapshot$doInitialLoad$1.L$0 = loadResult3;
                                                                pageFetcherSnapshot$doInitialLoad$1.L$1 = holder5;
                                                                pageFetcherSnapshot$doInitialLoad$1.L$2 = mutex10;
                                                                pageFetcherSnapshot$doInitialLoad$1.label = 7;
                                                                if (mutex10.lock(null, pageFetcherSnapshot$doInitialLoad$1) != coroutine_suspended) {
                                                                    mutex5 = mutex10;
                                                                    loadResult5 = loadResult3;
                                                                    try {
                                                                        PagingState<Key, Value> currentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(this.hintHandler.getLastAccessHint());
                                                                        mutex5.unlock(null);
                                                                        page = (PagingSource.LoadResult.Page) loadResult5;
                                                                        if (page.getPrevKey() == null) {
                                                                            this.remoteMediatorConnection.requestLoad(LoadType.PREPEND, currentPagingState$paging_common);
                                                                        }
                                                                        if (page.getNextKey() == null) {
                                                                            this.remoteMediatorConnection.requestLoad(LoadType.APPEND, currentPagingState$paging_common);
                                                                        }
                                                                    } finally {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                            } else {
                                                PagingLogger pagingLogger3 = PagingLogger.INSTANCE;
                                                if (pagingLogger3.isLoggable(2)) {
                                                    pagingLogger3.log(2, loadResultLog(LoadType.REFRESH, this.initialKey, null), null);
                                                }
                                                loadResult3 = loadResult2;
                                                if (this.remoteMediatorConnection != null) {
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        } finally {
                                        }
                                    }
                                } else if (!(loadResult6 instanceof PagingSource.LoadResult.Error)) {
                                    if (!(loadResult6 instanceof PagingSource.LoadResult.Invalid)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    PagingLogger pagingLogger4 = PagingLogger.INSTANCE;
                                    if (pagingLogger4.isLoggable(2)) {
                                        pagingLogger4.log(2, loadResultLog(LoadType.REFRESH, this.initialKey, loadResult6), null);
                                    }
                                    onInvalidLoad();
                                    return Unit.INSTANCE;
                                } else {
                                    PagingLogger pagingLogger5 = PagingLogger.INSTANCE;
                                    if (pagingLogger5.isLoggable(2)) {
                                        pagingLogger5.log(2, loadResultLog(LoadType.REFRESH, this.initialKey, loadResult6), null);
                                    }
                                    holder2 = this.stateHolder;
                                    mutex2 = ((PageFetcherSnapshotState.Holder) holder2).lock;
                                    pageFetcherSnapshot$doInitialLoad$1.L$0 = loadResult6;
                                    pageFetcherSnapshot$doInitialLoad$1.L$1 = holder2;
                                    pageFetcherSnapshot$doInitialLoad$1.L$2 = mutex2;
                                    pageFetcherSnapshot$doInitialLoad$1.label = 8;
                                    if (mutex2.lock(null, pageFetcherSnapshot$doInitialLoad$1) != coroutine_suspended) {
                                        loadResult = loadResult6;
                                        try {
                                            pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                            error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable());
                                            loadType2 = LoadType.REFRESH;
                                            pageFetcherSnapshot$doInitialLoad$1.L$0 = mutex2;
                                            pageFetcherSnapshot$doInitialLoad$1.L$1 = null;
                                            pageFetcherSnapshot$doInitialLoad$1.L$2 = null;
                                            pageFetcherSnapshot$doInitialLoad$1.label = 9;
                                            if (setError(pageFetcherSnapshotState2, loadType2, error, pageFetcherSnapshot$doInitialLoad$1) != coroutine_suspended) {
                                                mutex6 = mutex2;
                                                Unit unit4 = Unit.INSTANCE;
                                                mutex6.unlock(null);
                                                return Unit.INSTANCE;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            mutex6 = mutex2;
                                            throw th;
                                        }
                                    }
                                }
                                return coroutine_suspended;
                            case 4:
                                mutex3 = (Mutex) pageFetcherSnapshot$doInitialLoad$1.L$2;
                                holder3 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doInitialLoad$1.L$1;
                                loadResult2 = (PagingSource.LoadResult) pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                PageFetcherSnapshotState pageFetcherSnapshotState32 = ((PageFetcherSnapshotState.Holder) holder3).state;
                                insert = pageFetcherSnapshotState32.insert(0, LoadType.REFRESH, (PagingSource.LoadResult.Page) loadResult2);
                                pageFetcherSnapshotState32.getSourceLoadStates$paging_common().set(LoadType.REFRESH, LoadState.NotLoading.Companion.getIncomplete$paging_common());
                                if (((PagingSource.LoadResult.Page) loadResult2).getPrevKey() == null) {
                                }
                                if (((PagingSource.LoadResult.Page) loadResult2).getNextKey() == null) {
                                }
                                if (!insert) {
                                }
                                break;
                            case 5:
                                mutex4 = (Mutex) pageFetcherSnapshot$doInitialLoad$1.L$2;
                                holder4 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doInitialLoad$1.L$1;
                                loadResult4 = (PagingSource.LoadResult) pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                PageFetcherSnapshotState pageFetcherSnapshotState42 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                channel = this.pageEventCh;
                                pageEvent$paging_common = pageFetcherSnapshotState42.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult4, LoadType.REFRESH);
                                pageFetcherSnapshot$doInitialLoad$1.L$0 = loadResult4;
                                pageFetcherSnapshot$doInitialLoad$1.L$1 = mutex4;
                                pageFetcherSnapshot$doInitialLoad$1.L$2 = null;
                                pageFetcherSnapshot$doInitialLoad$1.label = 6;
                                if (channel.send(pageEvent$paging_common, pageFetcherSnapshot$doInitialLoad$1) == coroutine_suspended) {
                                }
                                break;
                            case 6:
                                Mutex mutex11 = (Mutex) pageFetcherSnapshot$doInitialLoad$1.L$1;
                                loadResult3 = (PagingSource.LoadResult) pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                r2 = mutex11;
                                Unit unit32 = Unit.INSTANCE;
                                if (this.remoteMediatorConnection != null) {
                                }
                                return Unit.INSTANCE;
                            case 7:
                                mutex5 = (Mutex) pageFetcherSnapshot$doInitialLoad$1.L$2;
                                holder5 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doInitialLoad$1.L$1;
                                loadResult5 = (PagingSource.LoadResult) pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                PagingState<Key, Value> currentPagingState$paging_common2 = ((PageFetcherSnapshotState.Holder) holder5).state.currentPagingState$paging_common(this.hintHandler.getLastAccessHint());
                                mutex5.unlock(null);
                                page = (PagingSource.LoadResult.Page) loadResult5;
                                if (page.getPrevKey() == null) {
                                }
                                if (page.getNextKey() == null) {
                                }
                                return Unit.INSTANCE;
                            case 8:
                                mutex2 = (Mutex) pageFetcherSnapshot$doInitialLoad$1.L$2;
                                holder2 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doInitialLoad$1.L$1;
                                loadResult = (PagingSource.LoadResult) pageFetcherSnapshot$doInitialLoad$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                pageFetcherSnapshotState2 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult).getThrowable());
                                loadType2 = LoadType.REFRESH;
                                pageFetcherSnapshot$doInitialLoad$1.L$0 = mutex2;
                                pageFetcherSnapshot$doInitialLoad$1.L$1 = null;
                                pageFetcherSnapshot$doInitialLoad$1.L$2 = null;
                                pageFetcherSnapshot$doInitialLoad$1.label = 9;
                                if (setError(pageFetcherSnapshotState2, loadType2, error, pageFetcherSnapshot$doInitialLoad$1) != coroutine_suspended) {
                                }
                                return coroutine_suspended;
                            case 9:
                                mutex6 = (Mutex) pageFetcherSnapshot$doInitialLoad$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    Unit unit42 = Unit.INSTANCE;
                                    mutex6.unlock(null);
                                    return Unit.INSTANCE;
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                switch (r2) {
                }
            } finally {
            }
        } finally {
        }
        pageFetcherSnapshot$doInitialLoad$1 = new PageFetcherSnapshot$doInitialLoad$1(this, continuation);
        Object obj2 = pageFetcherSnapshot$doInitialLoad$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = pageFetcherSnapshot$doInitialLoad$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x05c6, code lost:
        if (r2.lock(null, r3) != r4) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01f0, code lost:
        if (r2.lock(null, r3) == r4) goto L161;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04cc A[Catch: all -> 0x05f9, TRY_LEAVE, TryCatch #6 {all -> 0x05f9, blocks: (B:142:0x04be, B:144:0x04cc), top: B:253:0x04be }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0520 A[Catch: all -> 0x00b4, TryCatch #3 {all -> 0x00b4, blocks: (B:148:0x04fb, B:150:0x0507, B:152:0x0520, B:154:0x052c, B:156:0x0534, B:158:0x0541, B:157:0x053b, B:159:0x0546, B:163:0x0576, B:14:0x0081, B:17:0x00af), top: B:247:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0534 A[Catch: all -> 0x00b4, TryCatch #3 {all -> 0x00b4, blocks: (B:148:0x04fb, B:150:0x0507, B:152:0x0520, B:154:0x052c, B:156:0x0534, B:158:0x0541, B:157:0x053b, B:159:0x0546, B:163:0x0576, B:14:0x0081, B:17:0x00af), top: B:247:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x053b A[Catch: all -> 0x00b4, TryCatch #3 {all -> 0x00b4, blocks: (B:148:0x04fb, B:150:0x0507, B:152:0x0520, B:154:0x052c, B:156:0x0534, B:158:0x0541, B:157:0x053b, B:159:0x0546, B:163:0x0576, B:14:0x0081, B:17:0x00af), top: B:247:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02ee A[Catch: all -> 0x06a5, TRY_LEAVE, TryCatch #4 {all -> 0x06a5, blocks: (B:71:0x02d5, B:73:0x02ee), top: B:249:0x02d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0388  */
    /* JADX WARN: Type inference failed for: r17v0, types: [androidx.paging.PageFetcherSnapshot, androidx.paging.PageFetcherSnapshot<Key, Value>] */
    /* JADX WARN: Type inference failed for: r2v11, types: [T] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v41, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v75 */
    /* JADX WARN: Type inference failed for: r9v44, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:177:0x059d -> B:189:0x05ee). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x05a1 -> B:189:0x05ee). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:181:0x05c6 -> B:245:0x05ca). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doLoad(LoadType loadType, GenerationalViewportHint generationalViewportHint, Continuation<? super Unit> continuation) {
        PageFetcherSnapshot$doLoad$1 pageFetcherSnapshot$doLoad$1;
        Mutex mutex;
        Ref.IntRef intRef;
        PageFetcherSnapshotState.Holder<Key, Value> holder;
        Mutex mutex2;
        GenerationalViewportHint generationalViewportHint2;
        PageFetcherSnapshotState.Holder<Key, Value> holder2;
        Mutex mutex3;
        Ref.IntRef intRef2;
        LoadType loadType2;
        Ref.ObjectRef objectRef;
        GenerationalViewportHint generationalViewportHint3;
        Ref.ObjectRef objectRef2;
        Mutex mutex4;
        Object nextLoadKeyOrNull;
        ?? r2;
        Object obj;
        Ref.BooleanRef booleanRef;
        Ref.IntRef intRef3;
        GenerationalViewportHint generationalViewportHint4;
        LoadType loadType3;
        PagingSource.LoadParams<Key> loadParams;
        Ref.BooleanRef booleanRef2;
        Ref.ObjectRef objectRef3;
        PageFetcherSnapshotState.Holder<Key, Value> holder3;
        PagingSource.LoadResult loadResult;
        Mutex mutex5;
        PageFetcherSnapshotState.Holder<Key, Value> holder4;
        PagingSource.LoadResult loadResult2;
        Mutex mutex6;
        PageFetcherSnapshot$doLoad$1 pageFetcherSnapshot$doLoad$12;
        LoadType loadType4;
        PageFetcherSnapshotState pageFetcherSnapshotState;
        Mutex mutex7;
        GenerationalViewportHint generationalViewportHint5;
        PageFetcherSnapshotState.Holder<Key, Value> holder5;
        LoadType loadType5;
        PagingSource.LoadResult loadResult3;
        PagingSource.LoadParams<Key> loadParams2;
        Ref.BooleanRef booleanRef3;
        Ref.ObjectRef objectRef4;
        Ref.IntRef intRef4;
        LoadType loadType6;
        Mutex mutex8;
        GenerationalViewportHint generationalViewportHint6;
        PageFetcherSnapshotState pageFetcherSnapshotState2;
        PagingSource.LoadResult loadResult4;
        PagingSource.LoadParams<Key> loadParams3;
        Ref.BooleanRef booleanRef4;
        Ref.ObjectRef objectRef5;
        Ref.IntRef intRef5;
        GenerationalViewportHint generationalViewportHint7;
        LoadType loadType7;
        PagingSource.LoadResult loadResult5;
        PagingSource.LoadParams<Key> loadParams4;
        LoadType loadType8;
        Throwable th;
        PageFetcherSnapshotState pageFetcherSnapshotState3;
        LoadState.Error error;
        Mutex mutex9;
        int i;
        int i2;
        PageFetcherSnapshotState.Holder<Key, Value> holder6;
        Mutex mutex10;
        PageFetcherSnapshotState pageFetcherSnapshotState4;
        PageEvent<Value> pageEvent$paging_common;
        Channel<PageEvent<Value>> channel;
        Mutex mutex11;
        PageEvent.Drop<Value> dropEventOrNull;
        Throwable th2;
        LoadType loadType9;
        PagingSource.LoadResult loadResult6;
        Object prevKey;
        Object obj2;
        LoadType loadType10 = loadType;
        try {
            if (continuation instanceof PageFetcherSnapshot$doLoad$1) {
                pageFetcherSnapshot$doLoad$1 = (PageFetcherSnapshot$doLoad$1) continuation;
                if ((pageFetcherSnapshot$doLoad$1.label & Integer.MIN_VALUE) != 0) {
                    pageFetcherSnapshot$doLoad$1.label -= Integer.MIN_VALUE;
                    Object obj3 = pageFetcherSnapshot$doLoad$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    mutex = pageFetcherSnapshot$doLoad$1.label;
                    boolean z = true;
                    z = true;
                    z = true;
                    switch (mutex) {
                        case 0:
                            ResultKt.throwOnFailure(obj3);
                            if (loadType10 == LoadType.REFRESH) {
                                throw new IllegalArgumentException("Use doInitialLoad for LoadType == REFRESH".toString());
                            }
                            intRef = new Ref.IntRef();
                            holder = this.stateHolder;
                            mutex2 = ((PageFetcherSnapshotState.Holder) holder).lock;
                            pageFetcherSnapshot$doLoad$1.L$0 = loadType10;
                            generationalViewportHint2 = generationalViewportHint;
                            pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint2;
                            pageFetcherSnapshot$doLoad$1.L$2 = intRef;
                            pageFetcherSnapshot$doLoad$1.L$3 = holder;
                            pageFetcherSnapshot$doLoad$1.L$4 = mutex2;
                            pageFetcherSnapshot$doLoad$1.label = 1;
                            break;
                        case 1:
                            holder = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doLoad$1.L$3;
                            intRef = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            generationalViewportHint2 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            ResultKt.throwOnFailure(obj3);
                            mutex2 = (Mutex) pageFetcherSnapshot$doLoad$1.L$4;
                            loadType10 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            try {
                                PageFetcherSnapshotState pageFetcherSnapshotState5 = ((PageFetcherSnapshotState.Holder) holder).state;
                                int i3 = WhenMappings.$EnumSwitchMapping$0[loadType10.ordinal()];
                                if (i3 == 1) {
                                    throw new IllegalStateException("Use doInitialLoad for LoadType == REFRESH");
                                }
                                if (i3 == 2) {
                                    int initialPageIndex$paging_common = (pageFetcherSnapshotState5.getInitialPageIndex$paging_common() + generationalViewportHint2.getHint().getOriginalPageOffsetFirst()) - 1;
                                    if (initialPageIndex$paging_common > CollectionsKt.getLastIndex(pageFetcherSnapshotState5.getPages$paging_common())) {
                                        intRef.element += this.config.pageSize * (initialPageIndex$paging_common - CollectionsKt.getLastIndex(pageFetcherSnapshotState5.getPages$paging_common()));
                                        initialPageIndex$paging_common = CollectionsKt.getLastIndex(pageFetcherSnapshotState5.getPages$paging_common());
                                    }
                                    if (initialPageIndex$paging_common >= 0) {
                                        int i4 = 0;
                                        while (true) {
                                            intRef.element += pageFetcherSnapshotState5.getPages$paging_common().get(i4).getData().size();
                                            if (i4 != initialPageIndex$paging_common) {
                                                i4++;
                                            }
                                        }
                                    }
                                } else if (i3 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    int initialPageIndex$paging_common2 = pageFetcherSnapshotState5.getInitialPageIndex$paging_common() + generationalViewportHint2.getHint().getOriginalPageOffsetLast() + 1;
                                    if (initialPageIndex$paging_common2 < 0) {
                                        intRef.element += this.config.pageSize * (-initialPageIndex$paging_common2);
                                        initialPageIndex$paging_common2 = 0;
                                    }
                                    int lastIndex = CollectionsKt.getLastIndex(pageFetcherSnapshotState5.getPages$paging_common());
                                    if (initialPageIndex$paging_common2 <= lastIndex) {
                                        while (true) {
                                            intRef.element += pageFetcherSnapshotState5.getPages$paging_common().get(initialPageIndex$paging_common2).getData().size();
                                            if (initialPageIndex$paging_common2 != lastIndex) {
                                                initialPageIndex$paging_common2++;
                                            }
                                        }
                                    }
                                }
                                Unit unit = Unit.INSTANCE;
                                mutex2.unlock(null);
                                Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
                                PageFetcherSnapshotState.Holder<Key, Value> holder7 = this.stateHolder;
                                Mutex mutex12 = ((PageFetcherSnapshotState.Holder) holder7).lock;
                                pageFetcherSnapshot$doLoad$1.L$0 = loadType10;
                                pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint2;
                                pageFetcherSnapshot$doLoad$1.L$2 = intRef;
                                pageFetcherSnapshot$doLoad$1.L$3 = objectRef6;
                                pageFetcherSnapshot$doLoad$1.L$4 = holder7;
                                pageFetcherSnapshot$doLoad$1.L$5 = mutex12;
                                pageFetcherSnapshot$doLoad$1.L$6 = objectRef6;
                                pageFetcherSnapshot$doLoad$1.label = 2;
                                if (mutex12.lock(null, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                                    Ref.IntRef intRef6 = intRef;
                                    holder2 = holder7;
                                    mutex3 = mutex12;
                                    intRef2 = intRef6;
                                    loadType2 = loadType10;
                                    objectRef = objectRef6;
                                    generationalViewportHint3 = generationalViewportHint2;
                                    objectRef2 = objectRef;
                                    try {
                                        PageFetcherSnapshotState pageFetcherSnapshotState6 = ((PageFetcherSnapshotState.Holder) holder2).state;
                                        nextLoadKeyOrNull = nextLoadKeyOrNull(pageFetcherSnapshotState6, loadType2, generationalViewportHint3.getGenerationId(), generationalViewportHint3.getHint().presentedItemsBeyondAnchor$paging_common(loadType2) + intRef2.element);
                                        if (nextLoadKeyOrNull == null) {
                                            pageFetcherSnapshot$doLoad$1.L$0 = loadType2;
                                            pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint3;
                                            pageFetcherSnapshot$doLoad$1.L$2 = intRef2;
                                            pageFetcherSnapshot$doLoad$1.L$3 = objectRef2;
                                            pageFetcherSnapshot$doLoad$1.L$4 = mutex3;
                                            pageFetcherSnapshot$doLoad$1.L$5 = nextLoadKeyOrNull;
                                            pageFetcherSnapshot$doLoad$1.L$6 = objectRef;
                                            pageFetcherSnapshot$doLoad$1.label = 3;
                                            if (setLoading(pageFetcherSnapshotState6, loadType2, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                                                mutex4 = mutex3;
                                                obj = nextLoadKeyOrNull;
                                                r2 = obj;
                                                mutex3 = mutex4;
                                                mutex3.unlock(null);
                                                objectRef.element = r2;
                                                booleanRef = new Ref.BooleanRef();
                                                if (objectRef2.element != null) {
                                                    PagingSource.LoadParams<Key> loadParams5 = loadParams(loadType2, objectRef2.element);
                                                    PagingLogger pagingLogger = PagingLogger.INSTANCE;
                                                    if (pagingLogger.isLoggable(3)) {
                                                        obj2 = null;
                                                        pagingLogger.log(3, "Start " + loadType2 + " with loadKey " + objectRef2.element + " on " + this.pagingSource, null);
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    PagingSource<Key, Value> pagingSource = this.pagingSource;
                                                    pageFetcherSnapshot$doLoad$1.L$0 = loadType2;
                                                    pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint3;
                                                    pageFetcherSnapshot$doLoad$1.L$2 = intRef2;
                                                    pageFetcherSnapshot$doLoad$1.L$3 = objectRef2;
                                                    pageFetcherSnapshot$doLoad$1.L$4 = booleanRef;
                                                    pageFetcherSnapshot$doLoad$1.L$5 = loadParams5;
                                                    pageFetcherSnapshot$doLoad$1.L$6 = obj2;
                                                    pageFetcherSnapshot$doLoad$1.L$7 = obj2;
                                                    pageFetcherSnapshot$doLoad$1.label = 4;
                                                    Object load = pagingSource.load(loadParams5, pageFetcherSnapshot$doLoad$1);
                                                    if (load != coroutine_suspended) {
                                                        generationalViewportHint4 = generationalViewportHint3;
                                                        loadType3 = loadType2;
                                                        objectRef3 = objectRef2;
                                                        intRef3 = intRef2;
                                                        booleanRef2 = booleanRef;
                                                        loadParams = loadParams5;
                                                        obj3 = load;
                                                        loadResult6 = (PagingSource.LoadResult) obj3;
                                                        if (loadResult6 instanceof PagingSource.LoadResult.Page) {
                                                            int i5 = WhenMappings.$EnumSwitchMapping$0[loadType3.ordinal()];
                                                            if (i5 == 2) {
                                                                prevKey = ((PagingSource.LoadResult.Page) loadResult6).getPrevKey();
                                                            } else if (i5 == 3) {
                                                                prevKey = ((PagingSource.LoadResult.Page) loadResult6).getNextKey();
                                                            } else {
                                                                throw new IllegalArgumentException("Use doInitialLoad for LoadType == REFRESH");
                                                            }
                                                            if (!this.pagingSource.getKeyReuseSupported() && Intrinsics.areEqual(prevKey, objectRef3.element)) {
                                                                throw new IllegalStateException(StringsKt.trimMargin$default("The same value, " + objectRef3.element + ", was passed as the " + (loadType3 == LoadType.PREPEND ? "prevKey" : "nextKey") + " in two\n                            | sequential Pages loaded from a PagingSource. Re-using load keys in\n                            | PagingSource is often an error, and must be explicitly enabled by\n                            | overriding PagingSource.keyReuseSupported.\n                            ", null, z ? 1 : 0, null).toString());
                                                            }
                                                            holder3 = this.stateHolder;
                                                            mutex5 = ((PageFetcherSnapshotState.Holder) holder3).lock;
                                                            pageFetcherSnapshot$doLoad$1.L$0 = loadType3;
                                                            pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint4;
                                                            pageFetcherSnapshot$doLoad$1.L$2 = intRef3;
                                                            pageFetcherSnapshot$doLoad$1.L$3 = objectRef3;
                                                            pageFetcherSnapshot$doLoad$1.L$4 = booleanRef2;
                                                            pageFetcherSnapshot$doLoad$1.L$5 = loadParams;
                                                            pageFetcherSnapshot$doLoad$1.L$6 = loadResult6;
                                                            pageFetcherSnapshot$doLoad$1.L$7 = holder3;
                                                            pageFetcherSnapshot$doLoad$1.L$8 = mutex5;
                                                            pageFetcherSnapshot$doLoad$1.label = 5;
                                                            if (mutex5.lock(null, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                                                                loadResult = loadResult6;
                                                                try {
                                                                    if (((PageFetcherSnapshotState.Holder) holder3).state.insert(generationalViewportHint4.getGenerationId(), loadType3, (PagingSource.LoadResult.Page) loadResult)) {
                                                                        PagingLogger pagingLogger2 = PagingLogger.INSTANCE;
                                                                        if (pagingLogger2.isLoggable(2)) {
                                                                            pagingLogger2.log(2, loadResultLog(loadType3, objectRef3.element, th2), th2);
                                                                        }
                                                                    } else {
                                                                        PagingLogger pagingLogger3 = PagingLogger.INSTANCE;
                                                                        if (pagingLogger3.isLoggable(3)) {
                                                                            pagingLogger3.log(3, loadResultLog(loadType3, objectRef3.element, loadResult), th2);
                                                                        }
                                                                        PagingSource.LoadResult.Page page = (PagingSource.LoadResult.Page) loadResult;
                                                                        intRef3.element += page.getData().size();
                                                                        if ((loadType3 == LoadType.PREPEND && page.getPrevKey() == null) || (loadType3 == LoadType.APPEND && page.getNextKey() == null)) {
                                                                            booleanRef2.element = z;
                                                                        }
                                                                        if (WhenMappings.$EnumSwitchMapping$0[loadType3.ordinal()] == 2) {
                                                                            loadType9 = LoadType.APPEND;
                                                                        } else {
                                                                            loadType9 = LoadType.PREPEND;
                                                                        }
                                                                        holder5 = this.stateHolder;
                                                                        mutex8 = ((PageFetcherSnapshotState.Holder) holder5).lock;
                                                                        pageFetcherSnapshot$doLoad$1.L$0 = loadType3;
                                                                        pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint4;
                                                                        pageFetcherSnapshot$doLoad$1.L$2 = intRef3;
                                                                        pageFetcherSnapshot$doLoad$1.L$3 = objectRef3;
                                                                        pageFetcherSnapshot$doLoad$1.L$4 = booleanRef2;
                                                                        pageFetcherSnapshot$doLoad$1.L$5 = loadParams;
                                                                        pageFetcherSnapshot$doLoad$1.L$6 = loadResult;
                                                                        pageFetcherSnapshot$doLoad$1.L$7 = loadType9;
                                                                        pageFetcherSnapshot$doLoad$1.L$8 = holder5;
                                                                        pageFetcherSnapshot$doLoad$1.L$9 = mutex8;
                                                                        pageFetcherSnapshot$doLoad$1.label = 8;
                                                                        if (mutex8.lock(null, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                                                                            PagingSource.LoadResult loadResult7 = loadResult;
                                                                            loadType5 = loadType9;
                                                                            generationalViewportHint6 = generationalViewportHint4;
                                                                            objectRef4 = objectRef3;
                                                                            loadType6 = loadType3;
                                                                            intRef4 = intRef3;
                                                                            booleanRef3 = booleanRef2;
                                                                            loadParams2 = loadParams;
                                                                            loadResult3 = loadResult7;
                                                                            try {
                                                                                pageFetcherSnapshotState4 = ((PageFetcherSnapshotState.Holder) holder5).state;
                                                                                dropEventOrNull = pageFetcherSnapshotState4.dropEventOrNull(loadType5, generationalViewportHint6.getHint());
                                                                                if (dropEventOrNull == null) {
                                                                                    pageFetcherSnapshotState4.drop(dropEventOrNull);
                                                                                    Channel<PageEvent<Value>> channel2 = this.pageEventCh;
                                                                                    pageFetcherSnapshot$doLoad$1.L$0 = loadType6;
                                                                                    pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint6;
                                                                                    pageFetcherSnapshot$doLoad$1.L$2 = intRef4;
                                                                                    pageFetcherSnapshot$doLoad$1.L$3 = objectRef4;
                                                                                    pageFetcherSnapshot$doLoad$1.L$4 = booleanRef3;
                                                                                    pageFetcherSnapshot$doLoad$1.L$5 = loadParams2;
                                                                                    pageFetcherSnapshot$doLoad$1.L$6 = loadResult3;
                                                                                    pageFetcherSnapshot$doLoad$1.L$7 = mutex8;
                                                                                    pageFetcherSnapshot$doLoad$1.L$8 = pageFetcherSnapshotState4;
                                                                                    pageFetcherSnapshot$doLoad$1.L$9 = null;
                                                                                    pageFetcherSnapshot$doLoad$1.label = 9;
                                                                                    if (channel2.send(dropEventOrNull, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                                                                                        loadResult4 = loadResult3;
                                                                                        loadParams3 = loadParams2;
                                                                                        booleanRef4 = booleanRef3;
                                                                                        objectRef5 = objectRef4;
                                                                                        intRef5 = intRef4;
                                                                                        mutex11 = mutex8;
                                                                                        generationalViewportHint7 = generationalViewportHint6;
                                                                                        pageFetcherSnapshotState2 = pageFetcherSnapshotState4;
                                                                                        loadType7 = loadType6;
                                                                                        Unit unit2 = Unit.INSTANCE;
                                                                                        pageFetcherSnapshotState4 = pageFetcherSnapshotState2;
                                                                                        generationalViewportHint6 = generationalViewportHint7;
                                                                                        loadType6 = loadType7;
                                                                                        intRef4 = intRef5;
                                                                                        objectRef4 = objectRef5;
                                                                                        booleanRef3 = booleanRef4;
                                                                                        mutex = mutex11;
                                                                                        objectRef4.element = nextLoadKeyOrNull(pageFetcherSnapshotState4, loadType6, generationalViewportHint6.getGenerationId(), generationalViewportHint6.getHint().presentedItemsBeyondAnchor$paging_common(loadType6) + intRef4.element);
                                                                                        if (objectRef4.element == null && !(pageFetcherSnapshotState4.getSourceLoadStates$paging_common().get(loadType6) instanceof LoadState.Error)) {
                                                                                            pageFetcherSnapshotState4.getSourceLoadStates$paging_common().set(loadType6, !booleanRef3.element ? LoadState.NotLoading.Companion.getComplete$paging_common() : LoadState.NotLoading.Companion.getIncomplete$paging_common());
                                                                                        }
                                                                                        pageEvent$paging_common = pageFetcherSnapshotState4.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult4, loadType6);
                                                                                        channel = this.pageEventCh;
                                                                                        pageFetcherSnapshot$doLoad$1.L$0 = loadType6;
                                                                                        pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint6;
                                                                                        pageFetcherSnapshot$doLoad$1.L$2 = intRef4;
                                                                                        pageFetcherSnapshot$doLoad$1.L$3 = objectRef4;
                                                                                        pageFetcherSnapshot$doLoad$1.L$4 = booleanRef3;
                                                                                        pageFetcherSnapshot$doLoad$1.L$5 = loadParams3;
                                                                                        pageFetcherSnapshot$doLoad$1.L$6 = loadResult4;
                                                                                        pageFetcherSnapshot$doLoad$1.L$7 = mutex;
                                                                                        pageFetcherSnapshot$doLoad$1.L$8 = null;
                                                                                        pageFetcherSnapshot$doLoad$1.L$9 = null;
                                                                                        pageFetcherSnapshot$doLoad$1.label = 10;
                                                                                        if (channel.send(pageEvent$paging_common, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                                                                                            intRef2 = intRef4;
                                                                                            loadType8 = loadType6;
                                                                                            generationalViewportHint3 = generationalViewportHint6;
                                                                                            loadResult5 = loadResult4;
                                                                                            loadParams4 = loadParams3;
                                                                                            objectRef2 = objectRef4;
                                                                                            mutex9 = mutex;
                                                                                            Unit unit3 = Unit.INSTANCE;
                                                                                            mutex9.unlock(null);
                                                                                            i = ((loadParams4 instanceof PagingSource.LoadParams.Prepend) || ((PagingSource.LoadResult.Page) loadResult5).getPrevKey() != null) ? 0 : 1;
                                                                                            i2 = ((loadParams4 instanceof PagingSource.LoadParams.Append) || ((PagingSource.LoadResult.Page) loadResult5).getNextKey() != null) ? 0 : 1;
                                                                                            if (this.remoteMediatorConnection != null && (i != 0 || i2 != 0)) {
                                                                                                holder6 = this.stateHolder;
                                                                                                mutex10 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                                                                                pageFetcherSnapshot$doLoad$1.L$0 = loadType8;
                                                                                                pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint3;
                                                                                                pageFetcherSnapshot$doLoad$1.L$2 = intRef2;
                                                                                                pageFetcherSnapshot$doLoad$1.L$3 = objectRef2;
                                                                                                pageFetcherSnapshot$doLoad$1.L$4 = booleanRef3;
                                                                                                pageFetcherSnapshot$doLoad$1.L$5 = holder6;
                                                                                                pageFetcherSnapshot$doLoad$1.L$6 = mutex10;
                                                                                                pageFetcherSnapshot$doLoad$1.L$7 = null;
                                                                                                pageFetcherSnapshot$doLoad$1.I$0 = i;
                                                                                                pageFetcherSnapshot$doLoad$1.I$1 = i2;
                                                                                                pageFetcherSnapshot$doLoad$1.label = 11;
                                                                                                break;
                                                                                            }
                                                                                            booleanRef = booleanRef3;
                                                                                            loadType2 = loadType8;
                                                                                            z = true;
                                                                                            if (objectRef2.element != null) {
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    loadResult4 = loadResult3;
                                                                                    loadParams3 = loadParams2;
                                                                                    mutex = mutex8;
                                                                                    objectRef4.element = nextLoadKeyOrNull(pageFetcherSnapshotState4, loadType6, generationalViewportHint6.getGenerationId(), generationalViewportHint6.getHint().presentedItemsBeyondAnchor$paging_common(loadType6) + intRef4.element);
                                                                                    if (objectRef4.element == null) {
                                                                                        pageFetcherSnapshotState4.getSourceLoadStates$paging_common().set(loadType6, !booleanRef3.element ? LoadState.NotLoading.Companion.getComplete$paging_common() : LoadState.NotLoading.Companion.getIncomplete$paging_common());
                                                                                    }
                                                                                    pageEvent$paging_common = pageFetcherSnapshotState4.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult4, loadType6);
                                                                                    channel = this.pageEventCh;
                                                                                    pageFetcherSnapshot$doLoad$1.L$0 = loadType6;
                                                                                    pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint6;
                                                                                    pageFetcherSnapshot$doLoad$1.L$2 = intRef4;
                                                                                    pageFetcherSnapshot$doLoad$1.L$3 = objectRef4;
                                                                                    pageFetcherSnapshot$doLoad$1.L$4 = booleanRef3;
                                                                                    pageFetcherSnapshot$doLoad$1.L$5 = loadParams3;
                                                                                    pageFetcherSnapshot$doLoad$1.L$6 = loadResult4;
                                                                                    pageFetcherSnapshot$doLoad$1.L$7 = mutex;
                                                                                    pageFetcherSnapshot$doLoad$1.L$8 = null;
                                                                                    pageFetcherSnapshot$doLoad$1.L$9 = null;
                                                                                    pageFetcherSnapshot$doLoad$1.label = 10;
                                                                                    if (channel.send(pageEvent$paging_common, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                mutex = mutex8;
                                                                                mutex.unlock(null);
                                                                                throw th;
                                                                            }
                                                                        }
                                                                    }
                                                                } finally {
                                                                }
                                                            }
                                                        } else if (!(loadResult6 instanceof PagingSource.LoadResult.Error)) {
                                                            if (!(loadResult6 instanceof PagingSource.LoadResult.Invalid)) {
                                                                throw new NoWhenBranchMatchedException();
                                                            }
                                                            PagingLogger pagingLogger4 = PagingLogger.INSTANCE;
                                                            if (pagingLogger4.isLoggable(2)) {
                                                                pagingLogger4.log(2, loadResultLog(loadType3, objectRef3.element, loadResult6), null);
                                                            }
                                                            onInvalidLoad();
                                                            return Unit.INSTANCE;
                                                        } else {
                                                            PagingLogger pagingLogger5 = PagingLogger.INSTANCE;
                                                            if (pagingLogger5.isLoggable(2)) {
                                                                pagingLogger5.log(2, loadResultLog(loadType3, objectRef3.element, loadResult6), null);
                                                            }
                                                            holder4 = this.stateHolder;
                                                            mutex6 = ((PageFetcherSnapshotState.Holder) holder4).lock;
                                                            pageFetcherSnapshot$doLoad$1.L$0 = loadType3;
                                                            pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint4;
                                                            pageFetcherSnapshot$doLoad$1.L$2 = loadResult6;
                                                            pageFetcherSnapshot$doLoad$1.L$3 = holder4;
                                                            pageFetcherSnapshot$doLoad$1.L$4 = mutex6;
                                                            pageFetcherSnapshot$doLoad$1.L$5 = null;
                                                            pageFetcherSnapshot$doLoad$1.label = 6;
                                                            if (mutex6.lock(null, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                                                                loadResult2 = loadResult6;
                                                                pageFetcherSnapshot$doLoad$12 = pageFetcherSnapshot$doLoad$1;
                                                                loadType4 = loadType3;
                                                                try {
                                                                    pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder4).state;
                                                                    error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult2).getThrowable());
                                                                    pageFetcherSnapshot$doLoad$12.L$0 = loadType4;
                                                                    pageFetcherSnapshot$doLoad$12.L$1 = generationalViewportHint4;
                                                                    pageFetcherSnapshot$doLoad$12.L$2 = mutex6;
                                                                    pageFetcherSnapshot$doLoad$12.L$3 = pageFetcherSnapshotState3;
                                                                    pageFetcherSnapshot$doLoad$12.L$4 = null;
                                                                    pageFetcherSnapshot$doLoad$12.label = 7;
                                                                    if (setError(pageFetcherSnapshotState3, loadType4, error, pageFetcherSnapshot$doLoad$12) != coroutine_suspended) {
                                                                        mutex7 = mutex6;
                                                                        pageFetcherSnapshotState = pageFetcherSnapshotState3;
                                                                        generationalViewportHint5 = generationalViewportHint4;
                                                                        pageFetcherSnapshotState.getFailedHintsByLoadType$paging_common().put(loadType4, generationalViewportHint5.getHint());
                                                                        Unit unit4 = Unit.INSTANCE;
                                                                        mutex7.unlock(null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                } catch (Throwable th4) {
                                                                    th = th4;
                                                                    mutex7 = mutex6;
                                                                    mutex7.unlock(null);
                                                                    throw th;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        } else {
                                            r2 = 0;
                                            mutex3.unlock(null);
                                            objectRef.element = r2;
                                            booleanRef = new Ref.BooleanRef();
                                            if (objectRef2.element != null) {
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        mutex4 = mutex3;
                                        mutex4.unlock(null);
                                        throw th;
                                    }
                                }
                                return coroutine_suspended;
                            } finally {
                            }
                        case 2:
                            objectRef = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$6;
                            mutex3 = (Mutex) pageFetcherSnapshot$doLoad$1.L$5;
                            holder2 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doLoad$1.L$4;
                            objectRef2 = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$3;
                            intRef2 = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            generationalViewportHint3 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType2 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            PageFetcherSnapshotState pageFetcherSnapshotState62 = ((PageFetcherSnapshotState.Holder) holder2).state;
                            nextLoadKeyOrNull = nextLoadKeyOrNull(pageFetcherSnapshotState62, loadType2, generationalViewportHint3.getGenerationId(), generationalViewportHint3.getHint().presentedItemsBeyondAnchor$paging_common(loadType2) + intRef2.element);
                            if (nextLoadKeyOrNull == null) {
                            }
                            break;
                        case 3:
                            objectRef = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$6;
                            obj = pageFetcherSnapshot$doLoad$1.L$5;
                            mutex4 = (Mutex) pageFetcherSnapshot$doLoad$1.L$4;
                            objectRef2 = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$3;
                            intRef2 = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            generationalViewportHint3 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType2 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj3);
                                r2 = obj;
                                mutex3 = mutex4;
                                mutex3.unlock(null);
                                objectRef.element = r2;
                                booleanRef = new Ref.BooleanRef();
                                if (objectRef2.element != null) {
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th6) {
                                th = th6;
                                mutex4.unlock(null);
                                throw th;
                            }
                        case 4:
                            ResultKt.throwOnFailure(obj3);
                            intRef3 = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            generationalViewportHint4 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType3 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            loadParams = (PagingSource.LoadParams) pageFetcherSnapshot$doLoad$1.L$5;
                            booleanRef2 = (Ref.BooleanRef) pageFetcherSnapshot$doLoad$1.L$4;
                            objectRef3 = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$3;
                            loadResult6 = (PagingSource.LoadResult) obj3;
                            if (loadResult6 instanceof PagingSource.LoadResult.Page) {
                            }
                            return coroutine_suspended;
                        case 5:
                            holder3 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doLoad$1.L$7;
                            loadResult = (PagingSource.LoadResult) pageFetcherSnapshot$doLoad$1.L$6;
                            loadParams = (PagingSource.LoadParams) pageFetcherSnapshot$doLoad$1.L$5;
                            booleanRef2 = (Ref.BooleanRef) pageFetcherSnapshot$doLoad$1.L$4;
                            objectRef3 = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$3;
                            intRef3 = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            generationalViewportHint4 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType3 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            mutex5 = (Mutex) pageFetcherSnapshot$doLoad$1.L$8;
                            if (((PageFetcherSnapshotState.Holder) holder3).state.insert(generationalViewportHint4.getGenerationId(), loadType3, (PagingSource.LoadResult.Page) loadResult)) {
                            }
                            break;
                        case 6:
                            holder4 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doLoad$1.L$3;
                            loadResult2 = (PagingSource.LoadResult) pageFetcherSnapshot$doLoad$1.L$2;
                            ResultKt.throwOnFailure(obj3);
                            mutex6 = (Mutex) pageFetcherSnapshot$doLoad$1.L$4;
                            pageFetcherSnapshot$doLoad$12 = pageFetcherSnapshot$doLoad$1;
                            generationalViewportHint4 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType4 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            pageFetcherSnapshotState3 = ((PageFetcherSnapshotState.Holder) holder4).state;
                            error = new LoadState.Error(((PagingSource.LoadResult.Error) loadResult2).getThrowable());
                            pageFetcherSnapshot$doLoad$12.L$0 = loadType4;
                            pageFetcherSnapshot$doLoad$12.L$1 = generationalViewportHint4;
                            pageFetcherSnapshot$doLoad$12.L$2 = mutex6;
                            pageFetcherSnapshot$doLoad$12.L$3 = pageFetcherSnapshotState3;
                            pageFetcherSnapshot$doLoad$12.L$4 = null;
                            pageFetcherSnapshot$doLoad$12.label = 7;
                            if (setError(pageFetcherSnapshotState3, loadType4, error, pageFetcherSnapshot$doLoad$12) != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        case 7:
                            pageFetcherSnapshotState = (PageFetcherSnapshotState) pageFetcherSnapshot$doLoad$1.L$3;
                            mutex7 = (Mutex) pageFetcherSnapshot$doLoad$1.L$2;
                            generationalViewportHint5 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType4 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj3);
                                pageFetcherSnapshotState.getFailedHintsByLoadType$paging_common().put(loadType4, generationalViewportHint5.getHint());
                                Unit unit42 = Unit.INSTANCE;
                                mutex7.unlock(null);
                                return Unit.INSTANCE;
                            } catch (Throwable th7) {
                                th = th7;
                                mutex7.unlock(null);
                                throw th;
                            }
                        case 8:
                            holder5 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doLoad$1.L$8;
                            loadType5 = (LoadType) pageFetcherSnapshot$doLoad$1.L$7;
                            loadResult3 = (PagingSource.LoadResult) pageFetcherSnapshot$doLoad$1.L$6;
                            loadParams2 = (PagingSource.LoadParams) pageFetcherSnapshot$doLoad$1.L$5;
                            booleanRef3 = (Ref.BooleanRef) pageFetcherSnapshot$doLoad$1.L$4;
                            objectRef4 = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$3;
                            intRef4 = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            GenerationalViewportHint generationalViewportHint8 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType6 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            mutex8 = (Mutex) pageFetcherSnapshot$doLoad$1.L$9;
                            generationalViewportHint6 = generationalViewportHint8;
                            pageFetcherSnapshotState4 = ((PageFetcherSnapshotState.Holder) holder5).state;
                            dropEventOrNull = pageFetcherSnapshotState4.dropEventOrNull(loadType5, generationalViewportHint6.getHint());
                            if (dropEventOrNull == null) {
                            }
                            break;
                        case 9:
                            pageFetcherSnapshotState2 = (PageFetcherSnapshotState) pageFetcherSnapshot$doLoad$1.L$8;
                            Mutex mutex13 = (Mutex) pageFetcherSnapshot$doLoad$1.L$7;
                            loadResult4 = (PagingSource.LoadResult) pageFetcherSnapshot$doLoad$1.L$6;
                            loadParams3 = (PagingSource.LoadParams) pageFetcherSnapshot$doLoad$1.L$5;
                            booleanRef4 = (Ref.BooleanRef) pageFetcherSnapshot$doLoad$1.L$4;
                            objectRef5 = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$3;
                            intRef5 = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            generationalViewportHint7 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType7 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            mutex11 = mutex13;
                            Unit unit22 = Unit.INSTANCE;
                            pageFetcherSnapshotState4 = pageFetcherSnapshotState2;
                            generationalViewportHint6 = generationalViewportHint7;
                            loadType6 = loadType7;
                            intRef4 = intRef5;
                            objectRef4 = objectRef5;
                            booleanRef3 = booleanRef4;
                            mutex = mutex11;
                            objectRef4.element = nextLoadKeyOrNull(pageFetcherSnapshotState4, loadType6, generationalViewportHint6.getGenerationId(), generationalViewportHint6.getHint().presentedItemsBeyondAnchor$paging_common(loadType6) + intRef4.element);
                            if (objectRef4.element == null) {
                            }
                            pageEvent$paging_common = pageFetcherSnapshotState4.toPageEvent$paging_common((PagingSource.LoadResult.Page) loadResult4, loadType6);
                            channel = this.pageEventCh;
                            pageFetcherSnapshot$doLoad$1.L$0 = loadType6;
                            pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint6;
                            pageFetcherSnapshot$doLoad$1.L$2 = intRef4;
                            pageFetcherSnapshot$doLoad$1.L$3 = objectRef4;
                            pageFetcherSnapshot$doLoad$1.L$4 = booleanRef3;
                            pageFetcherSnapshot$doLoad$1.L$5 = loadParams3;
                            pageFetcherSnapshot$doLoad$1.L$6 = loadResult4;
                            pageFetcherSnapshot$doLoad$1.L$7 = mutex;
                            pageFetcherSnapshot$doLoad$1.L$8 = null;
                            pageFetcherSnapshot$doLoad$1.L$9 = null;
                            pageFetcherSnapshot$doLoad$1.label = 10;
                            if (channel.send(pageEvent$paging_common, pageFetcherSnapshot$doLoad$1) != coroutine_suspended) {
                            }
                            break;
                        case 10:
                            Mutex mutex14 = (Mutex) pageFetcherSnapshot$doLoad$1.L$7;
                            loadResult5 = (PagingSource.LoadResult) pageFetcherSnapshot$doLoad$1.L$6;
                            loadParams4 = (PagingSource.LoadParams) pageFetcherSnapshot$doLoad$1.L$5;
                            Ref.BooleanRef booleanRef5 = (Ref.BooleanRef) pageFetcherSnapshot$doLoad$1.L$4;
                            Ref.ObjectRef objectRef7 = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$3;
                            Ref.IntRef intRef7 = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            GenerationalViewportHint generationalViewportHint9 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            loadType8 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            ResultKt.throwOnFailure(obj3);
                            booleanRef3 = booleanRef5;
                            objectRef2 = objectRef7;
                            intRef2 = intRef7;
                            generationalViewportHint3 = generationalViewportHint9;
                            mutex9 = mutex14;
                            Unit unit32 = Unit.INSTANCE;
                            mutex9.unlock(null);
                            if (loadParams4 instanceof PagingSource.LoadParams.Prepend) {
                                break;
                            }
                            if (loadParams4 instanceof PagingSource.LoadParams.Append) {
                                break;
                            }
                            if (this.remoteMediatorConnection != null) {
                                holder6 = this.stateHolder;
                                mutex10 = ((PageFetcherSnapshotState.Holder) holder6).lock;
                                pageFetcherSnapshot$doLoad$1.L$0 = loadType8;
                                pageFetcherSnapshot$doLoad$1.L$1 = generationalViewportHint3;
                                pageFetcherSnapshot$doLoad$1.L$2 = intRef2;
                                pageFetcherSnapshot$doLoad$1.L$3 = objectRef2;
                                pageFetcherSnapshot$doLoad$1.L$4 = booleanRef3;
                                pageFetcherSnapshot$doLoad$1.L$5 = holder6;
                                pageFetcherSnapshot$doLoad$1.L$6 = mutex10;
                                pageFetcherSnapshot$doLoad$1.L$7 = null;
                                pageFetcherSnapshot$doLoad$1.I$0 = i;
                                pageFetcherSnapshot$doLoad$1.I$1 = i2;
                                pageFetcherSnapshot$doLoad$1.label = 11;
                                break;
                            }
                            booleanRef = booleanRef3;
                            loadType2 = loadType8;
                            z = true;
                            if (objectRef2.element != null) {
                            }
                            return Unit.INSTANCE;
                        case 11:
                            i2 = pageFetcherSnapshot$doLoad$1.I$1;
                            i = pageFetcherSnapshot$doLoad$1.I$0;
                            holder6 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$doLoad$1.L$5;
                            ResultKt.throwOnFailure(obj3);
                            generationalViewportHint3 = (GenerationalViewportHint) pageFetcherSnapshot$doLoad$1.L$1;
                            mutex10 = (Mutex) pageFetcherSnapshot$doLoad$1.L$6;
                            booleanRef3 = (Ref.BooleanRef) pageFetcherSnapshot$doLoad$1.L$4;
                            objectRef2 = (Ref.ObjectRef) pageFetcherSnapshot$doLoad$1.L$3;
                            loadType8 = (LoadType) pageFetcherSnapshot$doLoad$1.L$0;
                            intRef2 = (Ref.IntRef) pageFetcherSnapshot$doLoad$1.L$2;
                            try {
                                PagingState<Key, Value> currentPagingState$paging_common = ((PageFetcherSnapshotState.Holder) holder6).state.currentPagingState$paging_common(this.hintHandler.getLastAccessHint());
                                if (i != 0) {
                                    this.remoteMediatorConnection.requestLoad(LoadType.PREPEND, currentPagingState$paging_common);
                                }
                                if (i2 != 0) {
                                    this.remoteMediatorConnection.requestLoad(LoadType.APPEND, currentPagingState$paging_common);
                                }
                                booleanRef = booleanRef3;
                                loadType2 = loadType8;
                                z = true;
                                if (objectRef2.element != null) {
                                }
                                return Unit.INSTANCE;
                            } finally {
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (mutex) {
            }
        } catch (Throwable th8) {
            th = th8;
        }
        pageFetcherSnapshot$doLoad$1 = new PageFetcherSnapshot$doLoad$1(this, continuation);
        Object obj32 = pageFetcherSnapshot$doLoad$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        mutex = pageFetcherSnapshot$doLoad$1.label;
        boolean z2 = true;
        z2 = true;
        z2 = true;
    }

    private final String loadResultLog(LoadType loadType, Key key, PagingSource.LoadResult<Key, Value> loadResult) {
        if (loadResult == null) {
            return "End " + loadType + " with loadkey " + key + ". Load CANCELLED.";
        }
        return "End " + loadType + " with loadKey " + key + ". Returned " + loadResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setLoading(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, Continuation<? super Unit> continuation) {
        if (!Intrinsics.areEqual(pageFetcherSnapshotState.getSourceLoadStates$paging_common().get(loadType), LoadState.Loading.INSTANCE)) {
            pageFetcherSnapshotState.getSourceLoadStates$paging_common().set(loadType, LoadState.Loading.INSTANCE);
            Object send = this.pageEventCh.send(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.getSourceLoadStates$paging_common().snapshot(), null), continuation);
            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object setError(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, LoadState.Error error, Continuation<? super Unit> continuation) {
        if (!Intrinsics.areEqual(pageFetcherSnapshotState.getSourceLoadStates$paging_common().get(loadType), error)) {
            pageFetcherSnapshotState.getSourceLoadStates$paging_common().set(loadType, error);
            Object send = this.pageEventCh.send(new PageEvent.LoadStateUpdate(pageFetcherSnapshotState.getSourceLoadStates$paging_common().snapshot(), null), continuation);
            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final Key nextLoadKeyOrNull(PageFetcherSnapshotState<Key, Value> pageFetcherSnapshotState, LoadType loadType, int i, int i2) {
        if (i == pageFetcherSnapshotState.generationId$paging_common(loadType) && !(pageFetcherSnapshotState.getSourceLoadStates$paging_common().get(loadType) instanceof LoadState.Error) && i2 < this.config.prefetchDistance) {
            if (loadType == LoadType.PREPEND) {
                return (Key) ((PagingSource.LoadResult.Page) CollectionsKt.first((List<? extends Object>) pageFetcherSnapshotState.getPages$paging_common())).getPrevKey();
            }
            return (Key) ((PagingSource.LoadResult.Page) CollectionsKt.last((List<? extends Object>) pageFetcherSnapshotState.getPages$paging_common())).getNextKey();
        }
        return null;
    }

    private final void onInvalidLoad() {
        close();
        this.pagingSource.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectAsGenerationalViewportHints(Flow<Integer> flow, final LoadType loadType, Continuation<? super Unit> continuation) {
        Object collect = FlowKt.conflate(FlowExtKt.simpleRunningReduce(FlowExtKt.simpleTransformLatest(flow, new PageFetcherSnapshot$collectAsGenerationalViewportHints$$inlined$simpleFlatMapLatest$1(null, this, loadType)), new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(loadType, null))).collect(new FlowCollector(this) { // from class: androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$4
            final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            public final Object emit(GenerationalViewportHint generationalViewportHint, Continuation<? super Unit> continuation2) {
                Object doLoad;
                doLoad = this.this$0.doLoad(loadType, generationalViewportHint, continuation2);
                return doLoad == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? doLoad : Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((GenerationalViewportHint) obj, (Continuation<? super Unit>) continuation2);
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }
}
