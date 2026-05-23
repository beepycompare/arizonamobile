package androidx.paging;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.paging.PageFetcher;
import androidx.paging.PagingSource;
import androidx.paging.RemoteMediator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Value] */
/* compiled from: PageFetcher.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "Value", "", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PagingData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1", f = "PageFetcher.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes3.dex */
public final class PageFetcher$flow$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PagingData<Value>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RemoteMediator<Key, Value> $remoteMediator;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PageFetcher<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcher$flow$1(RemoteMediator<Key, Value> remoteMediator, PageFetcher<Key, Value> pageFetcher, Continuation<? super PageFetcher$flow$1> continuation) {
        super(2, continuation);
        this.$remoteMediator = remoteMediator;
        this.this$0 = pageFetcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PageFetcher$flow$1 pageFetcher$flow$1 = new PageFetcher$flow$1(this.$remoteMediator, this.this$0, continuation);
        pageFetcher$flow$1.L$0 = obj;
        return pageFetcher$flow$1;
    }

    public final Object invoke(SimpleProducerScope<PagingData<Value>> simpleProducerScope, Continuation<? super Unit> continuation) {
        return ((PageFetcher$flow$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SimpleProducerScope) ((SimpleProducerScope) obj), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConflatedEventBus conflatedEventBus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            RemoteMediator<Key, Value> remoteMediator = this.$remoteMediator;
            RemoteMediatorAccessor RemoteMediatorAccessor = remoteMediator != 0 ? RemoteMediatorAccessorKt.RemoteMediatorAccessor(simpleProducerScope, remoteMediator) : null;
            conflatedEventBus = ((PageFetcher) this.this$0).loadRequests;
            this.label = 1;
            if (FlowExtKt.simpleTransformLatest(FlowKt.distinctUntilChanged(FlowKt.filterNotNull(FlowExtKt.simpleScan(FlowKt.onStart(conflatedEventBus.getFlow(), new AnonymousClass1(RemoteMediatorAccessor, null)), null, new AnonymousClass2(RemoteMediatorAccessor, this.this$0, null)))), new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(null, this.this$0, RemoteMediatorAccessor)).collect(new AnonymousClass4(simpleProducerScope), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/paging/PageFetcher$LoadRequest;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$1", f = "PageFetcher.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, 63}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: androidx.paging.PageFetcher$flow$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super PageFetcher.LoadRequest>, Continuation<? super Unit>, Object> {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$remoteMediatorAccessor = remoteMediatorAccessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$remoteMediatorAccessor, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super PageFetcher.LoadRequest> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
            if (r7 == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
            if (r1.emit(new androidx.paging.PageFetcher.LoadRequest.Refresh(r4, androidx.paging.PageFetcher.RefreshType.Initial.INSTANCE), r6) != r0) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
            return r0;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            RemoteMediator.InitializeAction initializeAction;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor = this.$remoteMediatorAccessor;
                if (remoteMediatorAccessor != 0) {
                    this.L$0 = flowCollector;
                    this.label = 1;
                    obj = remoteMediatorAccessor.initialize(this);
                } else {
                    initializeAction = null;
                    boolean z = initializeAction == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH;
                    this.L$0 = null;
                    this.label = 2;
                }
            } else if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            initializeAction = (RemoteMediator.InitializeAction) obj;
            if (initializeAction == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) {
            }
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [Key] */
    /* compiled from: PageFetcher.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "Value", "", "currentGeneration", "loadRequest", "Landroidx/paging/PageFetcher$LoadRequest;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$2", f = "PageFetcher.kt", i = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5}, l = {90, 108, 112, 162, 168, 211}, m = "invokeSuspend", n = {"currentGeneration", "loadRequest", "currentGeneration", "loadRequest", "newPagingSource", "currentPagingState", "currentGeneration", "newPagingSource", "currentPagingState", "item", "currentGeneration", "newPagingSource", "currentPagingState", "currentGeneration"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0"}, v = 1)
    /* renamed from: androidx.paging.PageFetcher$flow$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2<Key> extends SuspendLambda implements Function3<PageFetcher.GenerationInfo<Key, Value>, PageFetcher.LoadRequest, Continuation<? super PageFetcher.GenerationInfo<Key, Value>>, Object> {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, PageFetcher<Key, Value> pageFetcher, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$remoteMediatorAccessor = remoteMediatorAccessor;
            this.this$0 = pageFetcher;
        }

        public final Object invoke(PageFetcher.GenerationInfo<Key, Value> generationInfo, PageFetcher.LoadRequest loadRequest, Continuation<? super PageFetcher.GenerationInfo<Key, Value>> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$remoteMediatorAccessor, this.this$0, continuation);
            anonymousClass2.L$0 = generationInfo;
            anonymousClass2.L$1 = loadRequest;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, PageFetcher.LoadRequest loadRequest, Object obj2) {
            return invoke((PageFetcher.GenerationInfo) ((PageFetcher.GenerationInfo) obj), loadRequest, (Continuation) ((Continuation) obj2));
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x010e, code lost:
            if (r9 == r1) goto L70;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:104:0x033d  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x025a  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x02c7  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x0307 A[LOOP:0: B:96:0x0301->B:98:0x0307, LOOP_END] */
        /* JADX WARN: Type inference failed for: r8v41, types: [T, androidx.paging.PagingState] */
        /* JADX WARN: Type inference failed for: r8v48, types: [T, androidx.paging.PagingState] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            PageFetcher.GenerationInfo generationInfo;
            PageFetcher.LoadRequest loadRequest;
            Object generateNewPagingSource;
            Object obj2;
            Object generateNewPagingSource2;
            Object obj3;
            RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor;
            PagingConfig pagingConfig;
            ConflatedEventBus conflatedEventBus;
            CompletableJob Job$default;
            PagingSource pagingSource;
            Ref.ObjectRef objectRef;
            PageFetcher.LoadRequest loadRequest2;
            PageFetcher.GenerationInfo generationInfo2;
            Ref.ObjectRef objectRef2;
            T t;
            PageFetcher.LoadRequest.Refresh refresh;
            PagingLogger pagingLogger;
            PagingConfig pagingConfig2;
            Pair pair;
            PageFetcher.GenerationInfo generationInfo3;
            Object loadKey$paging_common;
            Ref.ObjectRef objectRef3;
            PagingSource pagingSource2;
            Object obj4;
            Object loadKey$paging_common2;
            Object obj5;
            PagingState<Key, Value> cachedInitialState;
            List<PagingSource.LoadResult.Page<Key, Value>> pages;
            PagingSource pagingSource3;
            PagingLogger pagingLogger2;
            PagingConfig pagingConfig3;
            PagingConfig pagingConfig4;
            ConflatedEventBus conflatedEventBus2;
            CompletableJob Job$default2;
            PagingLogger pagingLogger3;
            Iterator<T> it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = 0;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    generationInfo = (PageFetcher.GenerationInfo) this.L$0;
                    loadRequest = (PageFetcher.LoadRequest) this.L$1;
                    if (loadRequest instanceof PageFetcher.LoadRequest.Refresh) {
                        if (((PageFetcher.LoadRequest.Refresh) loadRequest).getTriggerRemoteRefresh() && (remoteMediatorAccessor = this.$remoteMediatorAccessor) != null) {
                            remoteMediatorAccessor.allowRefresh();
                        }
                        PageFetcher<Key, Value> pageFetcher = this.this$0;
                        if (generationInfo != null) {
                            this.L$0 = generationInfo;
                            this.L$1 = loadRequest;
                            this.label = 2;
                            generateNewPagingSource = pageFetcher.generateNewPagingSource(generationInfo.getSnapshot().getPagingSource$paging_common(), this);
                            break;
                        } else {
                            obj2 = ((PageFetcher) pageFetcher).initialKey;
                            this.L$0 = obj2;
                            this.label = 1;
                            generateNewPagingSource2 = this.this$0.generateNewPagingSource(null, this);
                            if (generateNewPagingSource2 != coroutine_suspended) {
                                obj3 = obj2;
                                pagingConfig = ((PageFetcher) this.this$0).config;
                                conflatedEventBus = ((PageFetcher) this.this$0).retryEvents;
                                PageFetcherSnapshot pageFetcherSnapshot = new PageFetcherSnapshot(obj3, (PagingSource) generateNewPagingSource2, pagingConfig, conflatedEventBus.getFlow(), 0, this.$remoteMediatorAccessor, null, new AnonymousClass1(this.this$0), 16, null);
                                Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                                return new PageFetcher.GenerationInfo(pageFetcherSnapshot, null, Job$default);
                            }
                        }
                    } else if (generationInfo == null) {
                        throw new IllegalArgumentException("Append or Prepend request should be sent after a Refresh. This error indicates a bug in the Paging library. Please file a bug report in Buganizer.".toString());
                    } else {
                        this.L$0 = generationInfo;
                        this.label = 6;
                        if (generationInfo.getSnapshot().forceSetHint(loadRequest.getLoadType(), this) != coroutine_suspended) {
                            return generationInfo;
                        }
                    }
                    return coroutine_suspended;
                case 1:
                    Object obj6 = this.L$0;
                    ResultKt.throwOnFailure(obj);
                    generateNewPagingSource2 = obj;
                    obj3 = obj6;
                    pagingConfig = ((PageFetcher) this.this$0).config;
                    conflatedEventBus = ((PageFetcher) this.this$0).retryEvents;
                    PageFetcherSnapshot pageFetcherSnapshot2 = new PageFetcherSnapshot(obj3, (PagingSource) generateNewPagingSource2, pagingConfig, conflatedEventBus.getFlow(), 0, this.$remoteMediatorAccessor, null, new AnonymousClass1(this.this$0), 16, null);
                    Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                    return new PageFetcher.GenerationInfo(pageFetcherSnapshot2, null, Job$default);
                case 2:
                    loadRequest = (PageFetcher.LoadRequest) this.L$1;
                    generationInfo = (PageFetcher.GenerationInfo) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    generateNewPagingSource = obj;
                    PageFetcher.LoadRequest loadRequest3 = loadRequest;
                    pagingSource = (PagingSource) generateNewPagingSource;
                    objectRef = new Ref.ObjectRef();
                    this.L$0 = generationInfo;
                    this.L$1 = loadRequest3;
                    this.L$2 = pagingSource;
                    this.L$3 = objectRef;
                    this.L$4 = objectRef;
                    this.label = 3;
                    Object currentPagingState = generationInfo.getSnapshot().currentPagingState(this);
                    if (currentPagingState != coroutine_suspended) {
                        loadRequest2 = loadRequest3;
                        generationInfo2 = generationInfo;
                        objectRef2 = objectRef;
                        t = currentPagingState;
                        objectRef2.element = t;
                        if (((PagingState) objectRef.element).getPages().isEmpty() && (cachedInitialState = generationInfo2.getCachedInitialState()) != null && (pages = cachedInitialState.getPages()) != null && (!pages.isEmpty())) {
                            objectRef.element = generationInfo2.getCachedInitialState();
                        }
                        if (((PagingState) objectRef.element).getAnchorPosition() == null) {
                            PagingState<Key, Value> cachedInitialState2 = generationInfo2.getCachedInitialState();
                            if ((cachedInitialState2 != null ? cachedInitialState2.getAnchorPosition() : null) != null) {
                                objectRef.element = generationInfo2.getCachedInitialState();
                            }
                        }
                        refresh = (PageFetcher.LoadRequest.Refresh) loadRequest2;
                        if (!Intrinsics.areEqual(refresh.getType(), PageFetcher.RefreshType.Anchor.INSTANCE) || (((PagingState) objectRef.element).getPages().isEmpty() && ((PagingState) objectRef.element).getAnchorPosition() == null)) {
                            Object refreshKey = pagingSource.getRefreshKey((PagingState) objectRef.element);
                            pagingLogger = PagingLogger.INSTANCE;
                            if (pagingLogger.isLoggable(3)) {
                                pagingLogger.log(3, "Refresh key " + refreshKey + " returned from PagingSource " + pagingSource, null);
                            }
                            pagingConfig2 = ((PageFetcher) this.this$0).config;
                            pair = TuplesKt.to(refreshKey, Boxing.boxInt(pagingConfig2.initialLoadSize));
                            generationInfo3 = generationInfo2;
                            pagingSource3 = pagingSource;
                            Object component1 = pair.component1();
                            int intValue = ((Number) pair.component2()).intValue();
                            generationInfo3.getSnapshot().close();
                            Job.cancel$default(generationInfo3.getJob(), (CancellationException) null, 1, (Object) null);
                            pagingConfig4 = ((PageFetcher) this.this$0).config;
                            conflatedEventBus2 = ((PageFetcher) this.this$0).retryEvents;
                            Flow flow = conflatedEventBus2.getFlow();
                            AnonymousClass7 anonymousClass7 = new AnonymousClass7(this.this$0);
                            RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor2 = this.$remoteMediatorAccessor;
                            Job$default2 = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                            return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(component1, pagingSource3, pagingConfig4, flow, intValue, remoteMediatorAccessor2, (PagingState) objectRef.element, anonymousClass7), (PagingState) objectRef.element, Job$default2);
                        } else if (refresh.getType() instanceof PageFetcher.RefreshType.Item) {
                            Object item = ((PageFetcher.RefreshType.Item) refresh.getType()).getItem();
                            Iterator<T> it2 = ((PagingState) objectRef.element).getPages().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    obj4 = it2.next();
                                    if (CollectionsKt.contains(((PagingSource.LoadResult.Page) obj4).getData(), item)) {
                                    }
                                } else {
                                    obj4 = null;
                                }
                            }
                            PagingSource.LoadResult.Page<Key, Value> page = (PagingSource.LoadResult.Page) obj4;
                            if (page == null) {
                                StringBuilder append = new StringBuilder("Invalid Refresh item. Item ").append(item).append(" not found in ");
                                Iterator<T> it3 = ((PagingState) objectRef.element).getPages().iterator();
                                while (it3.hasNext()) {
                                    i += ((PagingSource.LoadResult.Page) it3.next()).getData().size();
                                }
                                throw new IllegalArgumentException(append.append(i).append(" loaded items.").toString().toString());
                            }
                            this.L$0 = generationInfo2;
                            this.L$1 = pagingSource;
                            this.L$2 = objectRef;
                            this.L$3 = item;
                            this.L$4 = null;
                            this.label = 4;
                            loadKey$paging_common2 = generationInfo2.getSnapshot().getLoadKey$paging_common(page, this);
                            if (loadKey$paging_common2 != coroutine_suspended) {
                                obj5 = item;
                                generationInfo3 = generationInfo2;
                                pagingLogger2 = PagingLogger.INSTANCE;
                                if (pagingLogger2.isLoggable(3)) {
                                    pagingLogger2.log(3, "Refresh key " + loadKey$paging_common2 + " based around item " + obj5, null);
                                }
                                pagingConfig3 = ((PageFetcher) this.this$0).config;
                                pair = TuplesKt.to(loadKey$paging_common2, Boxing.boxInt(pagingConfig3.initialLoadSize));
                                pagingSource3 = pagingSource;
                                Object component12 = pair.component1();
                                int intValue2 = ((Number) pair.component2()).intValue();
                                generationInfo3.getSnapshot().close();
                                Job.cancel$default(generationInfo3.getJob(), (CancellationException) null, 1, (Object) null);
                                pagingConfig4 = ((PageFetcher) this.this$0).config;
                                conflatedEventBus2 = ((PageFetcher) this.this$0).retryEvents;
                                Flow flow2 = conflatedEventBus2.getFlow();
                                AnonymousClass7 anonymousClass72 = new AnonymousClass7(this.this$0);
                                RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor22 = this.$remoteMediatorAccessor;
                                Job$default2 = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                                return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(component12, pagingSource3, pagingConfig4, flow2, intValue2, remoteMediatorAccessor22, (PagingState) objectRef.element, anonymousClass72), (PagingState) objectRef.element, Job$default2);
                            }
                        } else if (!Intrinsics.areEqual(refresh.getType(), PageFetcher.RefreshType.All.INSTANCE)) {
                            throw new IllegalStateException("should not get here");
                        } else {
                            this.L$0 = generationInfo2;
                            this.L$1 = pagingSource;
                            this.L$2 = objectRef;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 5;
                            loadKey$paging_common = generationInfo2.getSnapshot().getLoadKey$paging_common((PagingSource.LoadResult.Page) CollectionsKt.first((List<? extends Object>) ((PagingState) objectRef.element).getPages()), this);
                            if (loadKey$paging_common != coroutine_suspended) {
                                objectRef3 = objectRef;
                                pagingSource2 = pagingSource;
                                pagingLogger3 = PagingLogger.INSTANCE;
                                if (pagingLogger3.isLoggable(3)) {
                                    pagingLogger3.log(3, "Refresh key " + loadKey$paging_common + " from first item " + CollectionsKt.first((Iterable) CollectionsKt.first((List<? extends Object>) ((PagingState) objectRef3.element).getPages())), null);
                                }
                                it = ((PagingState) objectRef3.element).getPages().iterator();
                                while (it.hasNext()) {
                                    i += ((PagingSource.LoadResult.Page) it.next()).getData().size();
                                }
                                Pair pair2 = TuplesKt.to(loadKey$paging_common, Boxing.boxInt(i));
                                generationInfo3 = generationInfo2;
                                pagingSource3 = pagingSource2;
                                objectRef = objectRef3;
                                pair = pair2;
                                Object component122 = pair.component1();
                                int intValue22 = ((Number) pair.component2()).intValue();
                                generationInfo3.getSnapshot().close();
                                Job.cancel$default(generationInfo3.getJob(), (CancellationException) null, 1, (Object) null);
                                pagingConfig4 = ((PageFetcher) this.this$0).config;
                                conflatedEventBus2 = ((PageFetcher) this.this$0).retryEvents;
                                Flow flow22 = conflatedEventBus2.getFlow();
                                AnonymousClass7 anonymousClass722 = new AnonymousClass7(this.this$0);
                                RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor222 = this.$remoteMediatorAccessor;
                                Job$default2 = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                                return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(component122, pagingSource3, pagingConfig4, flow22, intValue22, remoteMediatorAccessor222, (PagingState) objectRef.element, anonymousClass722), (PagingState) objectRef.element, Job$default2);
                            }
                        }
                    }
                    return coroutine_suspended;
                case 3:
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) this.L$3;
                    pagingSource = (PagingSource) this.L$2;
                    ResultKt.throwOnFailure(obj);
                    objectRef2 = (Ref.ObjectRef) this.L$4;
                    objectRef = objectRef4;
                    loadRequest2 = (PageFetcher.LoadRequest) this.L$1;
                    generationInfo2 = (PageFetcher.GenerationInfo) this.L$0;
                    t = obj;
                    objectRef2.element = t;
                    if (((PagingState) objectRef.element).getPages().isEmpty()) {
                        objectRef.element = generationInfo2.getCachedInitialState();
                        break;
                    }
                    if (((PagingState) objectRef.element).getAnchorPosition() == null) {
                    }
                    refresh = (PageFetcher.LoadRequest.Refresh) loadRequest2;
                    if (Intrinsics.areEqual(refresh.getType(), PageFetcher.RefreshType.Anchor.INSTANCE)) {
                        break;
                    }
                    Object refreshKey2 = pagingSource.getRefreshKey((PagingState) objectRef.element);
                    pagingLogger = PagingLogger.INSTANCE;
                    if (pagingLogger.isLoggable(3)) {
                    }
                    pagingConfig2 = ((PageFetcher) this.this$0).config;
                    pair = TuplesKt.to(refreshKey2, Boxing.boxInt(pagingConfig2.initialLoadSize));
                    generationInfo3 = generationInfo2;
                    pagingSource3 = pagingSource;
                    Object component1222 = pair.component1();
                    int intValue222 = ((Number) pair.component2()).intValue();
                    generationInfo3.getSnapshot().close();
                    Job.cancel$default(generationInfo3.getJob(), (CancellationException) null, 1, (Object) null);
                    pagingConfig4 = ((PageFetcher) this.this$0).config;
                    conflatedEventBus2 = ((PageFetcher) this.this$0).retryEvents;
                    Flow flow222 = conflatedEventBus2.getFlow();
                    AnonymousClass7 anonymousClass7222 = new AnonymousClass7(this.this$0);
                    RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor2222 = this.$remoteMediatorAccessor;
                    Job$default2 = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                    return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(component1222, pagingSource3, pagingConfig4, flow222, intValue222, remoteMediatorAccessor2222, (PagingState) objectRef.element, anonymousClass7222), (PagingState) objectRef.element, Job$default2);
                case 4:
                    obj5 = this.L$3;
                    objectRef = (Ref.ObjectRef) this.L$2;
                    generationInfo3 = (PageFetcher.GenerationInfo) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pagingSource = (PagingSource) this.L$1;
                    loadKey$paging_common2 = obj;
                    pagingLogger2 = PagingLogger.INSTANCE;
                    if (pagingLogger2.isLoggable(3)) {
                    }
                    pagingConfig3 = ((PageFetcher) this.this$0).config;
                    pair = TuplesKt.to(loadKey$paging_common2, Boxing.boxInt(pagingConfig3.initialLoadSize));
                    pagingSource3 = pagingSource;
                    Object component12222 = pair.component1();
                    int intValue2222 = ((Number) pair.component2()).intValue();
                    generationInfo3.getSnapshot().close();
                    Job.cancel$default(generationInfo3.getJob(), (CancellationException) null, 1, (Object) null);
                    pagingConfig4 = ((PageFetcher) this.this$0).config;
                    conflatedEventBus2 = ((PageFetcher) this.this$0).retryEvents;
                    Flow flow2222 = conflatedEventBus2.getFlow();
                    AnonymousClass7 anonymousClass72222 = new AnonymousClass7(this.this$0);
                    RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor22222 = this.$remoteMediatorAccessor;
                    Job$default2 = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                    return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(component12222, pagingSource3, pagingConfig4, flow2222, intValue2222, remoteMediatorAccessor22222, (PagingState) objectRef.element, anonymousClass72222), (PagingState) objectRef.element, Job$default2);
                case 5:
                    objectRef3 = (Ref.ObjectRef) this.L$2;
                    pagingSource2 = (PagingSource) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    generationInfo2 = (PageFetcher.GenerationInfo) this.L$0;
                    loadKey$paging_common = obj;
                    pagingLogger3 = PagingLogger.INSTANCE;
                    if (pagingLogger3.isLoggable(3)) {
                    }
                    it = ((PagingState) objectRef3.element).getPages().iterator();
                    while (it.hasNext()) {
                    }
                    Pair pair22 = TuplesKt.to(loadKey$paging_common, Boxing.boxInt(i));
                    generationInfo3 = generationInfo2;
                    pagingSource3 = pagingSource2;
                    objectRef = objectRef3;
                    pair = pair22;
                    Object component122222 = pair.component1();
                    int intValue22222 = ((Number) pair.component2()).intValue();
                    generationInfo3.getSnapshot().close();
                    Job.cancel$default(generationInfo3.getJob(), (CancellationException) null, 1, (Object) null);
                    pagingConfig4 = ((PageFetcher) this.this$0).config;
                    conflatedEventBus2 = ((PageFetcher) this.this$0).retryEvents;
                    Flow flow22222 = conflatedEventBus2.getFlow();
                    AnonymousClass7 anonymousClass722222 = new AnonymousClass7(this.this$0);
                    RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor222222 = this.$remoteMediatorAccessor;
                    Job$default2 = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                    return new PageFetcher.GenerationInfo(new PageFetcherSnapshot(component122222, pagingSource3, pagingConfig4, flow22222, intValue22222, remoteMediatorAccessor222222, (PagingState) objectRef.element, anonymousClass722222), (PagingState) objectRef.element, Job$default2);
                case 6:
                    PageFetcher.GenerationInfo generationInfo4 = (PageFetcher.GenerationInfo) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return generationInfo4;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PageFetcher.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcher$flow$1$2$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function0<Unit> {
            AnonymousClass1(Object obj) {
                super(0, obj, PageFetcher.class, "refresh", "refresh(Ljava/lang/Object;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PageFetcher.refresh$default((PageFetcher) this.receiver, null, 1, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PageFetcher.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcher$flow$1$2$7  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class AnonymousClass7 extends AdaptedFunctionReference implements Function0<Unit> {
            AnonymousClass7(Object obj) {
                super(0, obj, PageFetcher.class, "refresh", "refresh(Ljava/lang/Object;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PageFetcher.refresh$default((PageFetcher) this.receiver, null, 1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageFetcher.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.paging.PageFetcher$flow$1$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class AnonymousClass4 implements FlowCollector, FunctionAdapter {
        final /* synthetic */ SimpleProducerScope<PagingData<Value>> $tmp0;

        AnonymousClass4(SimpleProducerScope<PagingData<Value>> simpleProducerScope) {
            this.$tmp0 = simpleProducerScope;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof FlowCollector) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(2, this.$tmp0, SimpleProducerScope.class, "send", "send(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(PagingData<Value> pagingData, Continuation<? super Unit> continuation) {
            Object send = this.$tmp0.send(pagingData, continuation);
            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((PagingData) ((PagingData) obj), (Continuation<? super Unit>) continuation);
        }
    }
}
