package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageFetcherSnapshotState;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [Value] */
/* compiled from: PageFetcherSnapshot.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "Value", "", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 0, 1, 2, 2, 2}, l = {647, 177, 659}, m = "invokeSuspend", n = {"$this$cancelableChannelFlow", "it", "this_$iv", "$this$withLock_u24default$iv$iv", "$this$cancelableChannelFlow", "$this$cancelableChannelFlow", "this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2"}, v = 1)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$pageEventFlow$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$pageEventFlow$1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super PageFetcherSnapshot$pageEventFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = pageFetcherSnapshot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PageFetcherSnapshot$pageEventFlow$1 pageFetcherSnapshot$pageEventFlow$1 = new PageFetcherSnapshot$pageEventFlow$1(this.this$0, continuation);
        pageFetcherSnapshot$pageEventFlow$1.L$0 = obj;
        return pageFetcherSnapshot$pageEventFlow$1;
    }

    public final Object invoke(SimpleProducerScope<PageEvent<Value>> simpleProducerScope, Continuation<? super Unit> continuation) {
        return ((PageFetcherSnapshot$pageEventFlow$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SimpleProducerScope) ((SimpleProducerScope) obj), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SimpleProducerScope simpleProducerScope;
        AtomicBoolean atomicBoolean;
        RemoteMediatorConnection remoteMediatorConnection;
        PagingState pagingState;
        PageFetcherSnapshotState.Holder holder;
        Mutex mutex;
        PageFetcherSnapshotState.Holder holder2;
        Object doInitialLoad;
        SimpleProducerScope simpleProducerScope2;
        Mutex mutex2;
        PageFetcherSnapshotState.Holder holder3;
        SimpleProducerScope simpleProducerScope3;
        PageFetcherSnapshotState.Holder holder4;
        LoadState loadState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                simpleProducerScope = (SimpleProducerScope) this.L$0;
                atomicBoolean = ((PageFetcherSnapshot) this.this$0).pageEventChCollected;
                if (!atomicBoolean.compareAndSet(false, true)) {
                    throw new IllegalStateException("Attempt to collect twice from pageEventFlow, which is an illegal operation. Did you forget to call Flow<PagingData<*>>.cachedIn(coroutineScope)?".toString());
                }
                SimpleProducerScope simpleProducerScope4 = simpleProducerScope;
                BuildersKt__Builders_commonKt.launch$default(simpleProducerScope4, null, null, new AnonymousClass2(this.this$0, simpleProducerScope, null), 3, null);
                Channel Channel$default = ChannelKt.Channel$default(0, null, null, 6, null);
                BuildersKt__Builders_commonKt.launch$default(simpleProducerScope4, null, null, new AnonymousClass3(this.this$0, Channel$default, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(simpleProducerScope4, null, null, new AnonymousClass4(Channel$default, this.this$0, null), 3, null);
                remoteMediatorConnection = this.this$0.getRemoteMediatorConnection();
                if (remoteMediatorConnection != null) {
                    PageFetcherSnapshot<Key, Value> pageFetcherSnapshot = this.this$0;
                    pagingState = ((PageFetcherSnapshot) pageFetcherSnapshot).previousPagingState;
                    if (pagingState == null) {
                        holder = ((PageFetcherSnapshot) pageFetcherSnapshot).stateHolder;
                        mutex = holder.lock;
                        this.L$0 = simpleProducerScope;
                        this.L$1 = remoteMediatorConnection;
                        this.L$2 = holder;
                        this.L$3 = mutex;
                        this.label = 1;
                        if (mutex.lock(null, this) != coroutine_suspended) {
                            holder2 = holder;
                        }
                        return coroutine_suspended;
                    }
                    remoteMediatorConnection.requestRefreshIfAllowed(pagingState);
                }
                this.L$0 = simpleProducerScope;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                doInitialLoad = this.this$0.doInitialLoad(this);
                if (doInitialLoad != coroutine_suspended) {
                    simpleProducerScope2 = simpleProducerScope;
                    holder3 = ((PageFetcherSnapshot) this.this$0).stateHolder;
                    mutex2 = holder3.lock;
                    this.L$0 = simpleProducerScope2;
                    this.L$1 = holder3;
                    this.L$2 = mutex2;
                    this.label = 3;
                    if (mutex2.lock(null, this) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            } else if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        holder4 = (PageFetcherSnapshotState.Holder) this.L$1;
                        simpleProducerScope3 = (SimpleProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        mutex2 = (Mutex) this.L$2;
                        try {
                            loadState = holder4.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                            mutex2.unlock(null);
                            if (!(loadState instanceof LoadState.Error)) {
                                this.this$0.startConsumingHints(simpleProducerScope3);
                            }
                            return Unit.INSTANCE;
                        } finally {
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                simpleProducerScope2 = (SimpleProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                holder3 = ((PageFetcherSnapshot) this.this$0).stateHolder;
                mutex2 = holder3.lock;
                this.L$0 = simpleProducerScope2;
                this.L$1 = holder3;
                this.L$2 = mutex2;
                this.label = 3;
                if (mutex2.lock(null, this) != coroutine_suspended) {
                    simpleProducerScope3 = simpleProducerScope2;
                    holder4 = holder3;
                    loadState = holder4.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                    mutex2.unlock(null);
                    if (!(loadState instanceof LoadState.Error)) {
                    }
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } else {
                mutex = (Mutex) this.L$3;
                holder2 = (PageFetcherSnapshotState.Holder) this.L$2;
                remoteMediatorConnection = (RemoteMediatorConnection) this.L$1;
                simpleProducerScope = (SimpleProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            PagingState currentPagingState$paging_common = holder2.state.currentPagingState$paging_common(null);
            mutex2.unlock(null);
            pagingState = currentPagingState$paging_common;
            remoteMediatorConnection.requestRefreshIfAllowed(pagingState);
            this.L$0 = simpleProducerScope;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            doInitialLoad = this.this$0.doInitialLoad(this);
            if (doInitialLoad != coroutine_suspended) {
            }
            return coroutine_suspended;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2", f = "PageFetcherSnapshot.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$cancelableChannelFlow;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, SimpleProducerScope<PageEvent<Value>> simpleProducerScope, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshot;
            this.$$this$cancelableChannelFlow = simpleProducerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$$this$cancelableChannelFlow, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PageFetcherSnapshot.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$2$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$cancelableChannelFlow;

            AnonymousClass1(SimpleProducerScope<PageEvent<Value>> simpleProducerScope) {
                this.$$this$cancelableChannelFlow = simpleProducerScope;
            }

            /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|23|6|7|(0)(0)|11|12|13) */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(PageEvent<Value> pageEvent, Continuation<? super Unit> continuation) {
                PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1;
                int i;
                if (continuation instanceof PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) {
                    pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 = (PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) continuation;
                    if ((pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label -= Integer.MIN_VALUE;
                        Object obj = pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            SimpleProducerScope<PageEvent<Value>> simpleProducerScope = this.$$this$cancelableChannelFlow;
                            pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label = 1;
                            if (simpleProducerScope.send(pageEvent, pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }
                pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1 = new PageFetcherSnapshot$pageEventFlow$1$2$1$emit$1(this, continuation);
                Object obj2 = pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pageFetcherSnapshot$pageEventFlow$1$2$1$emit$1.label;
                if (i != 0) {
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((PageEvent) ((PageEvent) obj), (Continuation<? super Unit>) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Channel channel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                channel = ((PageFetcherSnapshot) this.this$0).pageEventCh;
                this.label = 1;
                if (FlowKt.consumeAsFlow(channel).collect(new AnonymousClass1(this.$$this$cancelableChannelFlow), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3", f = "PageFetcherSnapshot.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Unit> $retryChannel;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Channel<Unit> channel, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = pageFetcherSnapshot;
            this.$retryChannel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$retryChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flow = ((PageFetcherSnapshot) this.this$0).retryFlow;
                final Channel<Unit> channel = this.$retryChannel;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: androidx.paging.PageFetcherSnapshot.pageEventFlow.1.3.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                        channel.mo8396trySendJP2dKIU(unit);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PageFetcherSnapshot.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4", f = "PageFetcherSnapshot.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Unit> $retryChannel;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Channel<Unit> channel, PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$retryChannel = channel;
            this.this$0 = pageFetcherSnapshot;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$retryChannel, this.this$0, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PageFetcherSnapshot.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$launch;
            final /* synthetic */ PageFetcherSnapshot<Key, Value> this$0;

            /* compiled from: PageFetcherSnapshot.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1$WhenMappings */
            /* loaded from: classes3.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LoadType.values().length];
                    try {
                        iArr[LoadType.REFRESH.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            AnonymousClass1(PageFetcherSnapshot<Key, Value> pageFetcherSnapshot, CoroutineScope coroutineScope) {
                this.this$0 = pageFetcherSnapshot;
                this.$$this$launch = coroutineScope;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Unit) obj, (Continuation<? super Unit>) continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:126:0x042f, code lost:
                if (r11.lock(null, r12) == r0) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x01f4, code lost:
                if (r1.lock(null, r12) == r0) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:80:0x031a, code lost:
                if (r11.lock(null, r12) == r0) goto L29;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:103:0x0391  */
            /* JADX WARN: Removed duplicated region for block: B:104:0x0393  */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
            /* JADX WARN: Removed duplicated region for block: B:112:0x03b1  */
            /* JADX WARN: Removed duplicated region for block: B:113:0x03b5  */
            /* JADX WARN: Removed duplicated region for block: B:122:0x040d  */
            /* JADX WARN: Removed duplicated region for block: B:125:0x0415  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
            /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
            /* JADX WARN: Removed duplicated region for block: B:141:0x0464  */
            /* JADX WARN: Removed duplicated region for block: B:149:0x04a1  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
            /* JADX WARN: Removed duplicated region for block: B:150:0x04a3  */
            /* JADX WARN: Removed duplicated region for block: B:158:0x04bf  */
            /* JADX WARN: Removed duplicated region for block: B:159:0x04c3  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
            /* JADX WARN: Removed duplicated region for block: B:168:0x0515  */
            /* JADX WARN: Removed duplicated region for block: B:171:0x051c  */
            /* JADX WARN: Removed duplicated region for block: B:178:0x054f  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x008d  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00a7  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x00c0  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00d8  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x00fd  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0119  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0138  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0151  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0169  */
            /* JADX WARN: Removed duplicated region for block: B:33:0x018e  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x01aa  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x01c9  */
            /* JADX WARN: Removed duplicated region for block: B:40:0x01d9  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x027f  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x0281  */
            /* JADX WARN: Removed duplicated region for block: B:66:0x029f  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x02a3  */
            /* JADX WARN: Removed duplicated region for block: B:76:0x02f9  */
            /* JADX WARN: Removed duplicated region for block: B:79:0x0301  */
            /* JADX WARN: Removed duplicated region for block: B:95:0x034f  */
            /* JADX WARN: Type inference failed for: r11v0, types: [androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1, androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$1<T>] */
            /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r11v100 */
            /* JADX WARN: Type inference failed for: r11v101 */
            /* JADX WARN: Type inference failed for: r11v12, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r11v2, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r11v3, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r11v39, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r11v66, types: [kotlinx.coroutines.sync.Mutex] */
            /* JADX WARN: Type inference failed for: r11v94 */
            /* JADX WARN: Type inference failed for: r11v95 */
            /* JADX WARN: Type inference failed for: r11v97 */
            /* JADX WARN: Type inference failed for: r11v98 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1;
                PageFetcherSnapshotState.Holder holder;
                PageFetcherSnapshot pageFetcherSnapshot;
                Mutex mutex;
                HintHandler hintHandler;
                LoadStates loadStates;
                PageFetcherSnapshot pageFetcherSnapshot2;
                CoroutineScope coroutineScope;
                LoadType loadType;
                CoroutineScope coroutineScope2;
                PageFetcherSnapshot pageFetcherSnapshot3;
                LoadStates loadStates2;
                LoadType loadType2;
                PageFetcherSnapshotState.Holder holder2;
                CoroutineScope coroutineScope3;
                Mutex mutex2;
                LoadStates loadStates3;
                PageFetcherSnapshotState.Holder holder3;
                Object loading;
                CoroutineScope coroutineScope4;
                PageFetcherSnapshot pageFetcherSnapshot4;
                PageFetcherSnapshotState.Holder holder4;
                Mutex mutex3;
                PageFetcherSnapshot pageFetcherSnapshot5;
                LoadType loadType3;
                PageFetcherSnapshot pageFetcherSnapshot6;
                LoadType loadType4;
                ViewportHint viewportHint;
                Object retryLoadError;
                PageFetcherSnapshot pageFetcherSnapshot7;
                LoadType loadType5;
                CoroutineScope coroutineScope5;
                LoadStates loadStates4;
                PageFetcherSnapshotState.Holder holder5;
                Mutex mutex4;
                LoadType loadType6;
                CoroutineScope coroutineScope6;
                PageFetcherSnapshot pageFetcherSnapshot8;
                LoadStates loadStates5;
                LoadType loadType7;
                PageFetcherSnapshotState.Holder holder6;
                CoroutineScope coroutineScope7;
                Mutex mutex5;
                LoadStates loadStates6;
                PageFetcherSnapshotState.Holder holder7;
                Object loading2;
                CoroutineScope coroutineScope8;
                PageFetcherSnapshot pageFetcherSnapshot9;
                PageFetcherSnapshotState.Holder holder8;
                Mutex mutex6;
                PageFetcherSnapshot pageFetcherSnapshot10;
                LoadType loadType8;
                PageFetcherSnapshot pageFetcherSnapshot11;
                LoadType loadType9;
                ViewportHint viewportHint2;
                Object retryLoadError2;
                PageFetcherSnapshot pageFetcherSnapshot12;
                LoadType loadType10;
                CoroutineScope coroutineScope9;
                LoadStates loadStates7;
                PageFetcherSnapshotState.Holder holder9;
                Mutex mutex7;
                LoadType loadType11;
                CoroutineScope coroutineScope10;
                PageFetcherSnapshot pageFetcherSnapshot13;
                LoadType loadType12;
                PageFetcherSnapshotState.Holder holder10;
                CoroutineScope coroutineScope11;
                Mutex mutex8;
                Object loading3;
                CoroutineScope coroutineScope12;
                PageFetcherSnapshot pageFetcherSnapshot14;
                PageFetcherSnapshotState.Holder holder11;
                Mutex mutex9;
                PageFetcherSnapshot pageFetcherSnapshot15;
                LoadType loadType13;
                PageFetcherSnapshot pageFetcherSnapshot16;
                LoadType loadType14;
                ViewportHint viewportHint3;
                Object retryLoadError3;
                PageFetcherSnapshot pageFetcherSnapshot17;
                LoadType loadType15;
                CoroutineScope coroutineScope13;
                PageFetcherSnapshotState.Holder holder12;
                PageFetcherSnapshotState.Holder holder13;
                Mutex mutex10;
                PageFetcherSnapshot pageFetcherSnapshot18;
                LoadState loadState;
                try {
                    try {
                        try {
                            if (continuation instanceof PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) {
                                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 = (PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) continuation;
                                if ((pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label -= Integer.MIN_VALUE;
                                    Object obj = pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label) {
                                        case 0:
                                            ResultKt.throwOnFailure(obj);
                                            holder = this.this$0.stateHolder;
                                            pageFetcherSnapshot = this.this$0;
                                            mutex = holder.lock;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = holder;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = mutex;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 1;
                                            break;
                                        case 1:
                                            mutex = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            pageFetcherSnapshot = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            holder = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            try {
                                                PageFetcherSnapshotState pageFetcherSnapshotState = holder.state;
                                                LoadStates snapshot = pageFetcherSnapshotState.getSourceLoadStates$paging_common().snapshot();
                                                hintHandler = pageFetcherSnapshot.hintHandler;
                                                Pair pair = TuplesKt.to(snapshot, pageFetcherSnapshotState.currentPagingState$paging_common(hintHandler.getLastAccessHint()));
                                                mutex.unlock(null);
                                                loadStates = (LoadStates) pair.component1();
                                                PagingState pagingState = (PagingState) pair.component2();
                                                RemoteMediatorConnection remoteMediatorConnection = this.this$0.getRemoteMediatorConnection();
                                                if (remoteMediatorConnection != null) {
                                                    remoteMediatorConnection.retryFailed(pagingState);
                                                    Unit unit2 = Unit.INSTANCE;
                                                }
                                                pageFetcherSnapshot2 = this.this$0;
                                                coroutineScope = this.$$this$launch;
                                                loadType = LoadType.REFRESH;
                                                if (loadStates.getRefresh() instanceof LoadState.Error) {
                                                    if (loadType != LoadType.REFRESH) {
                                                        holder2 = pageFetcherSnapshot2.stateHolder;
                                                        Mutex mutex11 = holder2.lock;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder2;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = mutex11;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 2;
                                                        if (mutex11.lock(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) != coroutine_suspended) {
                                                            coroutineScope3 = coroutineScope;
                                                            mutex2 = mutex11;
                                                            loadStates3 = loadStates;
                                                            holder3 = holder2;
                                                            PageFetcherSnapshotState pageFetcherSnapshotState2 = holder3.state;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates3;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope3;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = mutex2;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 3;
                                                            loading = pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState2, loadType, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                            if (loading == coroutine_suspended) {
                                                                loadType2 = loadType;
                                                                coroutineScope4 = coroutineScope3;
                                                                pageFetcherSnapshot4 = pageFetcherSnapshot2;
                                                                this = mutex2;
                                                                Unit unit3 = Unit.INSTANCE;
                                                                ((Mutex) this).unlock(null);
                                                                coroutineScope2 = coroutineScope4;
                                                                pageFetcherSnapshot3 = pageFetcherSnapshot4;
                                                                loadStates2 = loadStates3;
                                                                if (WhenMappings.$EnumSwitchMapping$0[loadType2.ordinal()] == 1) {
                                                                    pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                                                    loadType4 = loadType2;
                                                                    viewportHint = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope2;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 5;
                                                                    retryLoadError = pageFetcherSnapshot6.retryLoadError(loadType4, viewportHint, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                                    if (retryLoadError != coroutine_suspended) {
                                                                        pageFetcherSnapshot7 = pageFetcherSnapshot3;
                                                                        loadType5 = loadType2;
                                                                        coroutineScope5 = coroutineScope2;
                                                                        loadStates4 = loadStates2;
                                                                        if (loadType5 == LoadType.REFRESH) {
                                                                            holder5 = pageFetcherSnapshot7.stateHolder;
                                                                            mutex4 = holder5.lock;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates4;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot7;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope5;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder5;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = mutex4;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 6;
                                                                            break;
                                                                        }
                                                                        coroutineScope = coroutineScope5;
                                                                        pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                                                        loadStates = loadStates4;
                                                                    }
                                                                } else {
                                                                    holder4 = pageFetcherSnapshot3.stateHolder;
                                                                    mutex3 = holder4.lock;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope2;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder4;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = mutex3;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType2;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot3;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 4;
                                                                    if (mutex3.lock(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) != coroutine_suspended) {
                                                                        pageFetcherSnapshot5 = pageFetcherSnapshot3;
                                                                        loadType3 = loadType2;
                                                                        try {
                                                                            ViewportHint viewportHint4 = holder4.state.getFailedHintsByLoadType$paging_common().get(loadType3);
                                                                            mutex3.unlock(null);
                                                                            viewportHint = viewportHint4;
                                                                            loadType4 = loadType2;
                                                                            loadType2 = loadType3;
                                                                            pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                                                            pageFetcherSnapshot3 = pageFetcherSnapshot5;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope2;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 5;
                                                                            retryLoadError = pageFetcherSnapshot6.retryLoadError(loadType4, viewportHint, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                                            if (retryLoadError != coroutine_suspended) {
                                                                            }
                                                                        } finally {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    coroutineScope2 = coroutineScope;
                                                    pageFetcherSnapshot3 = pageFetcherSnapshot2;
                                                    loadStates2 = loadStates;
                                                    loadType2 = loadType;
                                                    if (WhenMappings.$EnumSwitchMapping$0[loadType2.ordinal()] == 1) {
                                                    }
                                                }
                                                loadType6 = LoadType.PREPEND;
                                                if (loadStates.getPrepend() instanceof LoadState.Error) {
                                                    if (loadType6 != LoadType.REFRESH) {
                                                        holder6 = pageFetcherSnapshot2.stateHolder;
                                                        Mutex mutex12 = holder6.lock;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder6;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = mutex12;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 7;
                                                        if (mutex12.lock(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) != coroutine_suspended) {
                                                            coroutineScope7 = coroutineScope;
                                                            mutex5 = mutex12;
                                                            loadStates6 = loadStates;
                                                            holder7 = holder6;
                                                            PageFetcherSnapshotState pageFetcherSnapshotState3 = holder7.state;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope7;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = mutex5;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                                            loading2 = pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState3, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                            if (loading2 == coroutine_suspended) {
                                                                loadType7 = loadType6;
                                                                coroutineScope8 = coroutineScope7;
                                                                pageFetcherSnapshot9 = pageFetcherSnapshot2;
                                                                this = mutex5;
                                                                Unit unit4 = Unit.INSTANCE;
                                                                ((Mutex) this).unlock(null);
                                                                coroutineScope6 = coroutineScope8;
                                                                pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                                                loadStates5 = loadStates6;
                                                                if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                                                    pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                                                    loadType9 = loadType7;
                                                                    viewportHint2 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope6;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                                                    retryLoadError2 = pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                                    if (retryLoadError2 != coroutine_suspended) {
                                                                        pageFetcherSnapshot12 = pageFetcherSnapshot8;
                                                                        loadType10 = loadType7;
                                                                        coroutineScope9 = coroutineScope6;
                                                                        loadStates7 = loadStates5;
                                                                        if (loadType10 == LoadType.REFRESH) {
                                                                            holder9 = pageFetcherSnapshot12.stateHolder;
                                                                            mutex7 = holder9.lock;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates7;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot12;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope9;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder9;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = mutex7;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 11;
                                                                            break;
                                                                        }
                                                                        coroutineScope = coroutineScope9;
                                                                        pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                                                        loadStates = loadStates7;
                                                                    }
                                                                } else {
                                                                    holder8 = pageFetcherSnapshot8.stateHolder;
                                                                    mutex6 = holder8.lock;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope6;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = holder8;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = mutex6;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = loadType7;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = pageFetcherSnapshot8;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 9;
                                                                    if (mutex6.lock(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) != coroutine_suspended) {
                                                                        pageFetcherSnapshot10 = pageFetcherSnapshot8;
                                                                        loadType8 = loadType7;
                                                                        try {
                                                                            ViewportHint viewportHint5 = holder8.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                                                            mutex6.unlock(null);
                                                                            viewportHint2 = viewportHint5;
                                                                            loadType9 = loadType7;
                                                                            loadType7 = loadType8;
                                                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                                                            pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope6;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                                                            retryLoadError2 = pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                                            if (retryLoadError2 != coroutine_suspended) {
                                                                            }
                                                                        } finally {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    coroutineScope6 = coroutineScope;
                                                    pageFetcherSnapshot8 = pageFetcherSnapshot2;
                                                    loadStates5 = loadStates;
                                                    loadType7 = loadType6;
                                                    if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                                    }
                                                }
                                                loadType11 = LoadType.APPEND;
                                                if (loadStates.getAppend() instanceof LoadState.Error) {
                                                    if (loadType11 != LoadType.REFRESH) {
                                                        holder10 = pageFetcherSnapshot2.stateHolder;
                                                        Mutex mutex13 = holder10.lock;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = coroutineScope;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder10;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = mutex13;
                                                        pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 12;
                                                        if (mutex13.lock(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) != coroutine_suspended) {
                                                            coroutineScope11 = coroutineScope;
                                                            mutex8 = mutex13;
                                                            PageFetcherSnapshotState pageFetcherSnapshotState4 = holder10.state;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = coroutineScope11;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = mutex8;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                                            loading3 = pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState4, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                            if (loading3 == coroutine_suspended) {
                                                                loadType12 = loadType11;
                                                                coroutineScope12 = coroutineScope11;
                                                                pageFetcherSnapshot14 = pageFetcherSnapshot2;
                                                                this = mutex8;
                                                                Unit unit5 = Unit.INSTANCE;
                                                                ((Mutex) this).unlock(null);
                                                                coroutineScope10 = coroutineScope12;
                                                                pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                                                if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                                    pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                                    loadType14 = loadType12;
                                                                    viewportHint3 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = coroutineScope10;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                                                    retryLoadError3 = pageFetcherSnapshot16.retryLoadError(loadType14, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                                    if (retryLoadError3 != coroutine_suspended) {
                                                                        pageFetcherSnapshot17 = pageFetcherSnapshot13;
                                                                        loadType15 = loadType12;
                                                                        coroutineScope13 = coroutineScope10;
                                                                        if (loadType15 == LoadType.REFRESH) {
                                                                            holder12 = pageFetcherSnapshot17.stateHolder;
                                                                            Mutex mutex14 = holder12.lock;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot17;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = coroutineScope13;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = holder12;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = mutex14;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 16;
                                                                            if (mutex14.lock(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) != coroutine_suspended) {
                                                                                holder13 = holder12;
                                                                                mutex10 = mutex14;
                                                                                pageFetcherSnapshot18 = pageFetcherSnapshot17;
                                                                                try {
                                                                                    loadState = holder13.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                                                    mutex10.unlock(null);
                                                                                    if (!(loadState instanceof LoadState.Error)) {
                                                                                        pageFetcherSnapshot18.startConsumingHints(coroutineScope13);
                                                                                    }
                                                                                } finally {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    holder11 = pageFetcherSnapshot13.stateHolder;
                                                                    mutex9 = holder11.lock;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = coroutineScope10;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = holder11;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = mutex9;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = loadType12;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = pageFetcherSnapshot13;
                                                                    pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 14;
                                                                    if (mutex9.lock(null, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1) != coroutine_suspended) {
                                                                        pageFetcherSnapshot15 = pageFetcherSnapshot13;
                                                                        loadType13 = loadType12;
                                                                        try {
                                                                            ViewportHint viewportHint6 = holder11.state.getFailedHintsByLoadType$paging_common().get(loadType13);
                                                                            mutex9.unlock(null);
                                                                            viewportHint3 = viewportHint6;
                                                                            loadType14 = loadType12;
                                                                            loadType12 = loadType13;
                                                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                                                            pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = coroutineScope10;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                                                            retryLoadError3 = pageFetcherSnapshot16.retryLoadError(loadType14, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                                                            if (retryLoadError3 != coroutine_suspended) {
                                                                            }
                                                                        } finally {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        return coroutine_suspended;
                                                    }
                                                    coroutineScope10 = coroutineScope;
                                                    pageFetcherSnapshot13 = pageFetcherSnapshot2;
                                                    loadType12 = loadType11;
                                                    if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            } finally {
                                            }
                                        case 2:
                                            holder3 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                            loadType = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            coroutineScope3 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            ResultKt.throwOnFailure(obj);
                                            pageFetcherSnapshot2 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            loadStates3 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            mutex2 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                            PageFetcherSnapshotState pageFetcherSnapshotState22 = holder3.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates3;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope3;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = mutex2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 3;
                                            loading = pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState22, loadType, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                            if (loading == coroutine_suspended) {
                                            }
                                            break;
                                        case 3:
                                            AnonymousClass1<T> anonymousClass1 = (AnonymousClass1<T>) ((Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4);
                                            loadType2 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            coroutineScope4 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            pageFetcherSnapshot4 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            loadStates3 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            this = anonymousClass1;
                                            Unit unit32 = Unit.INSTANCE;
                                            ((Mutex) this).unlock(null);
                                            coroutineScope2 = coroutineScope4;
                                            pageFetcherSnapshot3 = pageFetcherSnapshot4;
                                            loadStates2 = loadStates3;
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType2.ordinal()] == 1) {
                                            }
                                            break;
                                        case 4:
                                            pageFetcherSnapshot3 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7;
                                            loadType2 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6;
                                            mutex3 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                            holder4 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                            loadType3 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            coroutineScope2 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            pageFetcherSnapshot5 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            loadStates2 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            ViewportHint viewportHint42 = holder4.state.getFailedHintsByLoadType$paging_common().get(loadType3);
                                            mutex3.unlock(null);
                                            viewportHint = viewportHint42;
                                            loadType4 = loadType2;
                                            loadType2 = loadType3;
                                            pageFetcherSnapshot6 = pageFetcherSnapshot3;
                                            pageFetcherSnapshot3 = pageFetcherSnapshot5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot3;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 5;
                                            retryLoadError = pageFetcherSnapshot6.retryLoadError(loadType4, viewportHint, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                            if (retryLoadError != coroutine_suspended) {
                                            }
                                            return coroutine_suspended;
                                        case 5:
                                            loadType5 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            ResultKt.throwOnFailure(obj);
                                            loadStates4 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            pageFetcherSnapshot7 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            coroutineScope5 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            if (loadType5 == LoadType.REFRESH) {
                                            }
                                            coroutineScope = coroutineScope5;
                                            pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                            loadStates = loadStates4;
                                            loadType6 = LoadType.PREPEND;
                                            if (loadStates.getPrepend() instanceof LoadState.Error) {
                                            }
                                            loadType11 = LoadType.APPEND;
                                            if (loadStates.getAppend() instanceof LoadState.Error) {
                                            }
                                            return Unit.INSTANCE;
                                        case 6:
                                            mutex4 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                            holder5 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            coroutineScope5 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            pageFetcherSnapshot7 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            loadStates4 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            try {
                                                LoadState loadState2 = holder5.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                mutex4.unlock(null);
                                                if (!(loadState2 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot7.startConsumingHints(coroutineScope5);
                                                }
                                                coroutineScope = coroutineScope5;
                                                pageFetcherSnapshot2 = pageFetcherSnapshot7;
                                                loadStates = loadStates4;
                                                loadType6 = LoadType.PREPEND;
                                                if (loadStates.getPrepend() instanceof LoadState.Error) {
                                                }
                                                loadType11 = LoadType.APPEND;
                                                if (loadStates.getAppend() instanceof LoadState.Error) {
                                                }
                                                return Unit.INSTANCE;
                                            } finally {
                                            }
                                        case 7:
                                            holder7 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                            loadType6 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            coroutineScope7 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            ResultKt.throwOnFailure(obj);
                                            pageFetcherSnapshot2 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            loadStates6 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            mutex5 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                            PageFetcherSnapshotState pageFetcherSnapshotState32 = holder7.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = mutex5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 8;
                                            loading2 = pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState32, loadType6, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                            if (loading2 == coroutine_suspended) {
                                            }
                                            break;
                                        case 8:
                                            AnonymousClass1<T> anonymousClass12 = (AnonymousClass1<T>) ((Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4);
                                            loadType7 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            coroutineScope8 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            pageFetcherSnapshot9 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            loadStates6 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            this = anonymousClass12;
                                            Unit unit42 = Unit.INSTANCE;
                                            ((Mutex) this).unlock(null);
                                            coroutineScope6 = coroutineScope8;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot9;
                                            loadStates5 = loadStates6;
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType7.ordinal()] == 1) {
                                            }
                                            break;
                                        case 9:
                                            pageFetcherSnapshot8 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7;
                                            loadType7 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6;
                                            mutex6 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                            holder8 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                            loadType8 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            coroutineScope6 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            pageFetcherSnapshot10 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            loadStates5 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            ViewportHint viewportHint52 = holder8.state.getFailedHintsByLoadType$paging_common().get(loadType8);
                                            mutex6.unlock(null);
                                            viewportHint2 = viewportHint52;
                                            loadType9 = loadType7;
                                            loadType7 = loadType8;
                                            pageFetcherSnapshot11 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot8 = pageFetcherSnapshot10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = loadStates5;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = pageFetcherSnapshot8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = coroutineScope6;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = loadType7;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$7 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 10;
                                            retryLoadError2 = pageFetcherSnapshot11.retryLoadError(loadType9, viewportHint2, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                            if (retryLoadError2 != coroutine_suspended) {
                                            }
                                            return coroutine_suspended;
                                        case 10:
                                            loadType10 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            ResultKt.throwOnFailure(obj);
                                            loadStates7 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            pageFetcherSnapshot12 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            coroutineScope9 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            if (loadType10 == LoadType.REFRESH) {
                                            }
                                            coroutineScope = coroutineScope9;
                                            pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                            loadStates = loadStates7;
                                            loadType11 = LoadType.APPEND;
                                            if (loadStates.getAppend() instanceof LoadState.Error) {
                                            }
                                            return Unit.INSTANCE;
                                        case 11:
                                            mutex7 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                            holder9 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            coroutineScope9 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            pageFetcherSnapshot12 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            loadStates7 = (LoadStates) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            try {
                                                LoadState loadState3 = holder9.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                                mutex7.unlock(null);
                                                if (!(loadState3 instanceof LoadState.Error)) {
                                                    pageFetcherSnapshot12.startConsumingHints(coroutineScope9);
                                                }
                                                coroutineScope = coroutineScope9;
                                                pageFetcherSnapshot2 = pageFetcherSnapshot12;
                                                loadStates = loadStates7;
                                                loadType11 = LoadType.APPEND;
                                                if (loadStates.getAppend() instanceof LoadState.Error) {
                                                }
                                                return Unit.INSTANCE;
                                            } finally {
                                            }
                                        case 12:
                                            holder10 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            loadType11 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            coroutineScope11 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            ResultKt.throwOnFailure(obj);
                                            pageFetcherSnapshot2 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            mutex8 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                            PageFetcherSnapshotState pageFetcherSnapshotState42 = holder10.state;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot2;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = coroutineScope11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType11;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = mutex8;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 13;
                                            loading3 = pageFetcherSnapshot2.setLoading(pageFetcherSnapshotState42, loadType11, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                            if (loading3 == coroutine_suspended) {
                                            }
                                            break;
                                        case 13:
                                            AnonymousClass1<T> anonymousClass13 = (AnonymousClass1<T>) ((Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3);
                                            loadType12 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            coroutineScope12 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            pageFetcherSnapshot14 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            this = anonymousClass13;
                                            Unit unit52 = Unit.INSTANCE;
                                            ((Mutex) this).unlock(null);
                                            coroutineScope10 = coroutineScope12;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot14;
                                            if (WhenMappings.$EnumSwitchMapping$0[loadType12.ordinal()] == 1) {
                                            }
                                            break;
                                        case 14:
                                            pageFetcherSnapshot13 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6;
                                            loadType12 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5;
                                            mutex9 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4;
                                            holder11 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            loadType13 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            coroutineScope10 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            pageFetcherSnapshot15 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            ViewportHint viewportHint62 = holder11.state.getFailedHintsByLoadType$paging_common().get(loadType13);
                                            mutex9.unlock(null);
                                            viewportHint3 = viewportHint62;
                                            loadType14 = loadType12;
                                            loadType12 = loadType13;
                                            pageFetcherSnapshot16 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot13 = pageFetcherSnapshot15;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0 = pageFetcherSnapshot13;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1 = coroutineScope10;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2 = loadType12;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$4 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$5 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$6 = null;
                                            pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label = 15;
                                            retryLoadError3 = pageFetcherSnapshot16.retryLoadError(loadType14, viewportHint3, pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1);
                                            if (retryLoadError3 != coroutine_suspended) {
                                            }
                                            return coroutine_suspended;
                                        case 15:
                                            loadType15 = (LoadType) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            coroutineScope13 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            pageFetcherSnapshot17 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            if (loadType15 == LoadType.REFRESH) {
                                            }
                                            return Unit.INSTANCE;
                                        case 16:
                                            mutex10 = (Mutex) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$3;
                                            holder13 = (PageFetcherSnapshotState.Holder) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$2;
                                            coroutineScope13 = (CoroutineScope) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$1;
                                            pageFetcherSnapshot18 = (PageFetcherSnapshot) pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.L$0;
                                            ResultKt.throwOnFailure(obj);
                                            loadState = holder13.state.getSourceLoadStates$paging_common().get(LoadType.REFRESH);
                                            mutex10.unlock(null);
                                            if (!(loadState instanceof LoadState.Error)) {
                                            }
                                            return Unit.INSTANCE;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                }
                            }
                            switch (pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.label) {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
                pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1 = new PageFetcherSnapshot$pageEventFlow$1$4$1$emit$1(this, continuation);
                Object obj2 = pageFetcherSnapshot$pageEventFlow$1$4$1$emit$1.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow consumeAsFlow = FlowKt.consumeAsFlow(this.$retryChannel);
                PageFetcherSnapshot<Key, Value> pageFetcherSnapshot = this.this$0;
                this.label = 1;
                if (consumeAsFlow.collect(new AnonymousClass1(pageFetcherSnapshot, (CoroutineScope) this.L$0), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
