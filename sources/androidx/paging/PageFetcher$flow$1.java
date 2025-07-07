package androidx.paging;

import androidx.media3.extractor.ts.TsExtractor;
import androidx.paging.PageFetcher;
import androidx.paging.PagingSource;
import androidx.paging.RemoteMediator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Value] */
/* compiled from: PageFetcher.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PagingData;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1", f = "PageFetcher.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m = "invokeSuspend", n = {}, s = {})
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
            conflatedEventBus = ((PageFetcher) this.this$0).refreshEvents;
            this.label = 1;
            if (FlowExtKt.simpleTransformLatest(FlowKt.filterNotNull(FlowExtKt.simpleScan(FlowKt.onStart(conflatedEventBus.getFlow(), new AnonymousClass1(RemoteMediatorAccessor, null)), null, new AnonymousClass2(RemoteMediatorAccessor, this.this$0, null))), new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(null, this.this$0, RemoteMediatorAccessor)).collect(new AnonymousClass4(simpleProducerScope), this) == coroutine_suspended) {
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
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$1", f = "PageFetcher.kt", i = {}, l = {63, 63}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PageFetcher$flow$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
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
        public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
            if (r7 == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
            if (r1.emit(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4), r6) != r0) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
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
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "Value", "", "previousGeneration", "triggerRemoteRefresh", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$2", f = "PageFetcher.kt", i = {0, 1, 1}, l = {73, 77}, m = "invokeSuspend", n = {"previousGeneration", "previousGeneration", "pagingSource"}, s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.paging.PageFetcher$flow$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2<Key> extends SuspendLambda implements Function3<PageFetcher.GenerationInfo<Key, Value>, Boolean, Continuation<? super PageFetcher.GenerationInfo<Key, Value>>, Object> {
        final /* synthetic */ RemoteMediatorAccessor<Key, Value> $remoteMediatorAccessor;
        /* synthetic */ Object L$0;
        Object L$1;
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ PageFetcher<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor, PageFetcher<Key, Value> pageFetcher, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$remoteMediatorAccessor = remoteMediatorAccessor;
            this.this$0 = pageFetcher;
        }

        public final Object invoke(PageFetcher.GenerationInfo<Key, Value> generationInfo, boolean z, Continuation<? super PageFetcher.GenerationInfo<Key, Value>> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$remoteMediatorAccessor, this.this$0, continuation);
            anonymousClass2.L$0 = generationInfo;
            anonymousClass2.Z$0 = z;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2) {
            return invoke((PageFetcher.GenerationInfo) obj, bool.booleanValue(), (Continuation) obj2);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00d6  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x010d  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object generateNewPagingSource;
            PageFetcher.GenerationInfo generationInfo;
            PageFetcherSnapshot<Key, Value> snapshot;
            RemoteMediatorAccessor<Key, Value> remoteMediatorAccessor;
            PagingSource pagingSource;
            PagingState<Key, Value> pagingState;
            PageFetcherSnapshot<Key, Value> snapshot2;
            PagingSource pagingSource2;
            List<PagingSource.LoadResult.Page<Key, Value>> pages;
            PagingState<Key, Value> state;
            List<PagingSource.LoadResult.Page<Key, Value>> pages2;
            PagingState<Key, Value> pagingState2;
            Object refreshKey;
            PagingConfig pagingConfig;
            ConflatedEventBus conflatedEventBus;
            CompletableJob Job$default;
            Job job;
            PageFetcherSnapshot<Key, Value> snapshot3;
            PagingState<Key, Value> state2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PageFetcher.GenerationInfo generationInfo2 = (PageFetcher.GenerationInfo) this.L$0;
                if (this.Z$0 && (remoteMediatorAccessor = this.$remoteMediatorAccessor) != null) {
                    remoteMediatorAccessor.allowRefresh();
                }
                PageFetcher<Key, Value> pageFetcher = this.this$0;
                PagingSource<Key, Value> pagingSource$paging_common_release = (generationInfo2 == null || (snapshot = generationInfo2.getSnapshot()) == null) ? null : snapshot.getPagingSource$paging_common_release();
                this.L$0 = generationInfo2;
                this.label = 1;
                generateNewPagingSource = pageFetcher.generateNewPagingSource(pagingSource$paging_common_release, this);
                if (generateNewPagingSource != coroutine_suspended) {
                    generationInfo = generationInfo2;
                    obj = generateNewPagingSource;
                }
                return coroutine_suspended;
            } else if (i != 1) {
                if (i == 2) {
                    pagingSource2 = (PagingSource) this.L$1;
                    generationInfo = (PageFetcher.GenerationInfo) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pagingState = (PagingState) obj;
                    pagingSource = pagingSource2;
                    pages = pagingState != null ? pagingState.getPages() : null;
                    if ((pages != null || pages.isEmpty()) && generationInfo != null && (state = generationInfo.getState()) != null && (pages2 = state.getPages()) != null && (!pages2.isEmpty())) {
                        pagingState = generationInfo.getState();
                    }
                    if ((pagingState != null ? pagingState.getAnchorPosition() : null) == null) {
                        if (((generationInfo == null || (state2 = generationInfo.getState()) == null) ? null : state2.getAnchorPosition()) != null) {
                            pagingState = generationInfo.getState();
                        }
                    }
                    pagingState2 = pagingState;
                    if (pagingState2 == null) {
                        refreshKey = ((PageFetcher) this.this$0).initialKey;
                    } else {
                        refreshKey = pagingSource.getRefreshKey(pagingState2);
                        PagingLogger pagingLogger = PagingLogger.INSTANCE;
                        if (pagingLogger.isLoggable(3)) {
                            pagingLogger.log(3, "Refresh key " + refreshKey + " returned from PagingSource " + pagingSource, null);
                        }
                    }
                    Object obj2 = refreshKey;
                    if (generationInfo != null && (snapshot3 = generationInfo.getSnapshot()) != null) {
                        snapshot3.close();
                    }
                    if (generationInfo != null && (job = generationInfo.getJob()) != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    pagingConfig = ((PageFetcher) this.this$0).config;
                    conflatedEventBus = ((PageFetcher) this.this$0).retryEvents;
                    PageFetcherSnapshot pageFetcherSnapshot = new PageFetcherSnapshot(obj2, pagingSource, pagingConfig, conflatedEventBus.getFlow(), this.$remoteMediatorAccessor, pagingState2, new AnonymousClass1(this.this$0));
                    Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                    return new PageFetcher.GenerationInfo(pageFetcherSnapshot, pagingState2, Job$default);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                generationInfo = (PageFetcher.GenerationInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            PagingSource pagingSource3 = (PagingSource) obj;
            if (generationInfo == null || (snapshot2 = generationInfo.getSnapshot()) == null) {
                pagingSource = pagingSource3;
                pagingState = null;
                pages = pagingState != null ? pagingState.getPages() : null;
                if (pages != null) {
                }
                pagingState = generationInfo.getState();
                if ((pagingState != null ? pagingState.getAnchorPosition() : null) == null) {
                }
                pagingState2 = pagingState;
                if (pagingState2 == null) {
                }
                Object obj22 = refreshKey;
                if (generationInfo != null) {
                    snapshot3.close();
                }
                if (generationInfo != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                pagingConfig = ((PageFetcher) this.this$0).config;
                conflatedEventBus = ((PageFetcher) this.this$0).retryEvents;
                PageFetcherSnapshot pageFetcherSnapshot2 = new PageFetcherSnapshot(obj22, pagingSource, pagingConfig, conflatedEventBus.getFlow(), this.$remoteMediatorAccessor, pagingState2, new AnonymousClass1(this.this$0));
                Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                return new PageFetcher.GenerationInfo(pageFetcherSnapshot2, pagingState2, Job$default);
            }
            this.L$0 = generationInfo;
            this.L$1 = pagingSource3;
            this.label = 2;
            Object currentPagingState = snapshot2.currentPagingState(this);
            if (currentPagingState != coroutine_suspended) {
                pagingSource2 = pagingSource3;
                obj = currentPagingState;
                pagingState = (PagingState) obj;
                pagingSource = pagingSource2;
                pages = pagingState != null ? pagingState.getPages() : null;
                if (pages != null) {
                }
                pagingState = generationInfo.getState();
                if ((pagingState != null ? pagingState.getAnchorPosition() : null) == null) {
                }
                pagingState2 = pagingState;
                if (pagingState2 == null) {
                }
                Object obj222 = refreshKey;
                if (generationInfo != null) {
                }
                if (generationInfo != null) {
                }
                pagingConfig = ((PageFetcher) this.this$0).config;
                conflatedEventBus = ((PageFetcher) this.this$0).retryEvents;
                PageFetcherSnapshot pageFetcherSnapshot22 = new PageFetcherSnapshot(obj222, pagingSource, pagingConfig, conflatedEventBus.getFlow(), this.$remoteMediatorAccessor, pagingState2, new AnonymousClass1(this.this$0));
                Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
                return new PageFetcher.GenerationInfo(pageFetcherSnapshot22, pagingState2, Job$default);
            }
            return coroutine_suspended;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PageFetcher.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcher$flow$1$2$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
            AnonymousClass1(Object obj) {
                super(0, obj, PageFetcher.class, "refresh", "refresh()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((PageFetcher) this.receiver).refresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.paging.PageFetcher$flow$1$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass4 implements FlowCollector, FunctionAdapter {
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
