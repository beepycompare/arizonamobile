package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* JADX INFO: Add missing generic type declarations: [Value] */
/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Landroidx/paging/SimpleProducerScope;", "androidx/paging/FlowExtKt$combineWithoutBatching$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1", f = "PageFetcher.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $otherFlow;
    final /* synthetic */ MutableLoadStateCollection $sourceStates$inlined;
    final /* synthetic */ Flow $this_combineWithoutBatching;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(Flow flow, Flow flow2, Continuation continuation, MutableLoadStateCollection mutableLoadStateCollection) {
        super(2, continuation);
        this.$this_combineWithoutBatching = flow;
        this.$otherFlow = flow2;
        this.$sourceStates$inlined = mutableLoadStateCollection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1 = new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(this.$this_combineWithoutBatching, this.$otherFlow, continuation, this.$sourceStates$inlined);
        pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.L$0 = obj;
        return pageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1;
    }

    public final Object invoke(SimpleProducerScope<PageEvent<Value>> simpleProducerScope, Continuation<? super Unit> continuation) {
        return ((PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((SimpleProducerScope) ((SimpleProducerScope) obj), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final CompletableJob Job$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.L$0;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new AnonymousClass1(simpleProducerScope, null, this.$sourceStates$inlined));
            Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            Flow[] flowArr = {this.$this_combineWithoutBatching, this.$otherFlow};
            int i2 = 0;
            int i3 = 0;
            while (i3 < 2) {
                BuildersKt__Builders_commonKt.launch$default(simpleProducerScope, Job$default, null, new AnonymousClass2(flowArr[i3], atomicInteger, simpleProducerScope, unbatchedFlowCombiner, i2, null), 2, null);
                i3++;
                i2++;
            }
            this.label = 1;
            if (simpleProducerScope.awaitClose(new Function0<Unit>() { // from class: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1.3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Job.DefaultImpls.cancel$default((Job) CompletableJob.this, (CancellationException) null, 1, (Object) null);
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

    /* compiled from: FlowExt.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u00020\bH\u008a@¨\u0006\t"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "t1", "t2", "updateFrom", "Landroidx/paging/CombineSource;", "androidx/paging/FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1", f = "PageFetcher.kt", i = {}, l = {ModuleDescriptor.MODULE_VERSION}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function4<LoadStates, PageEvent<Value>, CombineSource, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$simpleChannelFlow;
        final /* synthetic */ MutableLoadStateCollection $sourceStates$inlined;
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SimpleProducerScope simpleProducerScope, Continuation continuation, MutableLoadStateCollection mutableLoadStateCollection) {
            super(4, continuation);
            this.$sourceStates$inlined = mutableLoadStateCollection;
            this.$$this$simpleChannelFlow = simpleProducerScope;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(LoadStates loadStates, PageEvent<Value> pageEvent, CombineSource combineSource, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$simpleChannelFlow, continuation, this.$sourceStates$inlined);
            anonymousClass1.L$0 = loadStates;
            anonymousClass1.L$1 = pageEvent;
            anonymousClass1.L$2 = combineSource;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.L$0;
                Object obj3 = this.L$1;
                CombineSource combineSource = (CombineSource) this.L$2;
                SimpleProducerScope<PageEvent<Value>> simpleProducerScope = this.$$this$simpleChannelFlow;
                AnonymousClass1 anonymousClass1 = this;
                PageEvent.LoadStateUpdate loadStateUpdate = (PageEvent) obj3;
                LoadStates loadStates = (LoadStates) obj2;
                if (combineSource != CombineSource.RECEIVER) {
                    if (loadStateUpdate instanceof PageEvent.Insert) {
                        PageEvent.Insert insert = (PageEvent.Insert) loadStateUpdate;
                        this.$sourceStates$inlined.set(insert.getSourceLoadStates());
                        loadStateUpdate = PageEvent.Insert.copy$default(insert, null, null, 0, 0, insert.getSourceLoadStates(), loadStates, 15, null);
                    } else if (loadStateUpdate instanceof PageEvent.Drop) {
                        this.$sourceStates$inlined.set(((PageEvent.Drop) loadStateUpdate).getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common_release());
                    } else if (loadStateUpdate instanceof PageEvent.LoadStateUpdate) {
                        PageEvent.LoadStateUpdate loadStateUpdate2 = (PageEvent.LoadStateUpdate) loadStateUpdate;
                        this.$sourceStates$inlined.set(loadStateUpdate2.getSource());
                        loadStateUpdate = new PageEvent.LoadStateUpdate(loadStateUpdate2.getSource(), loadStates);
                    } else if (loadStateUpdate instanceof PageEvent.StaticList) {
                        throw new IllegalStateException("Paging generated an event to display a static list that\n originated from a paginated source. If you see this\n exception, it is most likely a bug in the library.\n Please file a bug so we can fix it at:\n https://issuetracker.google.com/issues/new?component=413106");
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    loadStateUpdate = new PageEvent.LoadStateUpdate(this.$sourceStates$inlined.snapshot(), loadStates);
                }
                this.label = 1;
                if (simpleProducerScope.send(loadStateUpdate, anonymousClass1) == coroutine_suspended) {
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

    /* compiled from: FlowExt.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "androidx/paging/FlowExtKt$combineWithoutBatching$2$1$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleProducerScope<PageEvent<Value>> $$this$simpleChannelFlow;
        final /* synthetic */ Flow $flow;
        final /* synthetic */ AtomicInteger $incompleteFlows;
        final /* synthetic */ int $index;
        final /* synthetic */ UnbatchedFlowCombiner $unbatchedFlowCombiner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Flow flow, AtomicInteger atomicInteger, SimpleProducerScope simpleProducerScope, UnbatchedFlowCombiner unbatchedFlowCombiner, int i, Continuation continuation) {
            super(2, continuation);
            this.$flow = flow;
            this.$incompleteFlows = atomicInteger;
            this.$unbatchedFlowCombiner = unbatchedFlowCombiner;
            this.$index = i;
            this.$$this$simpleChannelFlow = simpleProducerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$flow, this.$incompleteFlows, this.$$this$simpleChannelFlow, this.$unbatchedFlowCombiner, this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AtomicInteger atomicInteger;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (this.$flow.collect(new AnonymousClass1(this.$unbatchedFlowCombiner, this.$index), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.close$default(this.$$this$simpleChannelFlow, null, 1, null);
                }
                return Unit.INSTANCE;
            } finally {
                if (this.$incompleteFlows.decrementAndGet() == 0) {
                    SendChannel.DefaultImpls.close$default(this.$$this$simpleChannelFlow, null, 1, null);
                }
            }
        }

        /* compiled from: FlowExt.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "androidx/paging/FlowExtKt$combineWithoutBatching$2$1$1$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ int $index;
            final /* synthetic */ UnbatchedFlowCombiner $unbatchedFlowCombiner;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: FlowExt.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.paging.PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1$2$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C00561 extends ContinuationImpl {
                int label;
                /* synthetic */ Object result;

                C00561(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return AnonymousClass1.this.emit(null, this);
                }
            }

            public AnonymousClass1(UnbatchedFlowCombiner unbatchedFlowCombiner, int i) {
                this.$unbatchedFlowCombiner = unbatchedFlowCombiner;
                this.$index = i;
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
                if (r7.onNext(r2, r6, r0) == r1) goto L19;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
                if (kotlinx.coroutines.YieldKt.yield(r0) != r1) goto L11;
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
                return r1;
             */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, Continuation<? super Unit> continuation) {
                C00561 c00561;
                int i;
                if (continuation instanceof C00561) {
                    c00561 = (C00561) continuation;
                    if ((c00561.label & Integer.MIN_VALUE) != 0) {
                        c00561.label -= Integer.MIN_VALUE;
                        Object obj2 = c00561.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = c00561.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj2);
                            UnbatchedFlowCombiner unbatchedFlowCombiner = this.$unbatchedFlowCombiner;
                            int i2 = this.$index;
                            c00561.label = 1;
                        } else if (i != 1) {
                            if (i == 2) {
                                ResultKt.throwOnFailure(obj2);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            ResultKt.throwOnFailure(obj2);
                        }
                        c00561.label = 2;
                    }
                }
                c00561 = new C00561(continuation);
                Object obj22 = c00561.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c00561.label;
                if (i != 0) {
                }
                c00561.label = 2;
            }
        }
    }
}
