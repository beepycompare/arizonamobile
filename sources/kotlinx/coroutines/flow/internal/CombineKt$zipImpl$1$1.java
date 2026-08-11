package kotlinx.coroutines.flow.internal;

import androidx.media3.extractor.ts.TsExtractor;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import okhttp3.internal.ws.WebSocketProtocol;
/*  JADX ERROR: JadxRuntimeException in pass: ClassModifier
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T1
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:53)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticFields(ClassModifier.java:83)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:61)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:55)
    */
/* compiled from: Combine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0, 0, 0, 0, 0}, l = {123}, m = "invokeSuspend", n = {"$this$coroutineScope", "second", "collectJob", "scopeContext", "cnt"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
/* loaded from: classes5.dex */
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T1> $flow;
    final /* synthetic */ Flow<T2> $flow2;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(Flow<? extends T2> flow, Flow<? extends T1> flow2, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.$flow2 = flow;
        this.$flow = flow2;
        this.$this_unsafeFlow = flowCollector;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.$flow2, this.$flow, this.$this_unsafeFlow, this.$transform, continuation);
        combineKt$zipImpl$1$1.L$0 = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return invoke2(coroutineScope, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.CoroutineScope] */
    /* JADX WARN: Type inference failed for: r2v11, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final CompletableJob Job$default;
        CompletableJob completableJob;
        ReceiveChannel receiveChannel;
        CoroutineContext coroutineContext;
        Object threadContextElements;
        CoroutineContext plus;
        Unit unit;
        ReceiveChannel receiveChannel2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    CoroutineContext coroutineContext2 = (CoroutineContext) this.L$3;
                    completableJob = (CompletableJob) this.L$2;
                    receiveChannel = (ReceiveChannel) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        receiveChannel2 = receiveChannel;
                    } catch (AbortFlowException e) {
                        e = e;
                    }
                    ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel2, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ReceiveChannel produce$default = ProduceKt.produce$default(receiveChannel2, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
            Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            Intrinsics.checkNotNull(produce$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            ((SendChannel) produce$default).mo11523invokeOnClose(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    if (CompletableJob.this.isActive()) {
                        CompletableJob.this.cancel((CancellationException) new AbortFlowException(CompletableJob.this));
                    }
                }
            });
            try {
                try {
                    coroutineContext = receiveChannel2.getCoroutineContext();
                    threadContextElements = ThreadContextKt.threadContextElements(coroutineContext);
                    plus = receiveChannel2.getCoroutineContext().plus(Job$default);
                    unit = Unit.INSTANCE;
                } catch (AbortFlowException e2) {
                    e = e2;
                }
                try {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(receiveChannel2);
                    this.L$1 = produce$default;
                    this.L$2 = Job$default;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineContext);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(threadContextElements);
                    this.label = 1;
                } catch (AbortFlowException e3) {
                    e = e3;
                    Job$default = Job$default;
                    completableJob = Job$default;
                    receiveChannel = produce$default;
                    FlowExceptions_commonKt.checkOwnership(e, completableJob);
                    receiveChannel2 = receiveChannel;
                    ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel2, (CancellationException) null, 1, (Object) null);
                    return Unit.INSTANCE;
                }
                if (ChannelFlowKt.withContextUndispatched$default(plus, unit, null, new AnonymousClass2(this.$flow, coroutineContext, threadContextElements, produce$default, this.$this_unsafeFlow, this.$transform, Job$default, null), this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                receiveChannel2 = produce$default;
                ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel2, (CancellationException) null, 1, (Object) null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                receiveChannel2 = produce$default;
                ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel2, (CancellationException) null, 1, (Object) null);
                throw th;
            }
            FlowExceptions_commonKt.checkOwnership(e, completableJob);
            receiveChannel2 = receiveChannel;
            ReceiveChannel.cancel$default((ReceiveChannel) receiveChannel2, (CancellationException) null, 1, (Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ CompletableJob $collectJob;
        final /* synthetic */ Flow<T1> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
        final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Flow<? extends T1> flow, CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, CompletableJob completableJob, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$flow = flow;
            this.$scopeContext = coroutineContext;
            this.$cnt = obj;
            this.$second = receiveChannel;
            this.$this_unsafeFlow = flowCollector;
            this.$transform = function3;
            this.$collectJob = completableJob;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return invoke2(unit, continuation);
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Combine.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ Object $cnt;
            final /* synthetic */ CompletableJob $collectJob;
            final /* synthetic */ CoroutineContext $scopeContext;
            final /* synthetic */ ReceiveChannel<Object> $second;
            final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
            final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineContext coroutineContext, Object obj, ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, CompletableJob completableJob) {
                this.$scopeContext = coroutineContext;
                this.$cnt = obj;
                this.$second = receiveChannel;
                this.$this_unsafeFlow = flowCollector;
                this.$transform = function3;
                this.$collectJob = completableJob;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Combine.kt */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {1, 2}, l = {WebSocketProtocol.PAYLOAD_SHORT, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend", n = {"otherValue", "otherValue"}, s = {"L$0", "L$0"}, v = 1)
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes5.dex */
            public static final class C00801 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                final /* synthetic */ CompletableJob $collectJob;
                final /* synthetic */ ReceiveChannel<Object> $second;
                final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                final /* synthetic */ T1 $value;
                Object L$0;
                Object L$1;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00801(ReceiveChannel<? extends Object> receiveChannel, FlowCollector<? super R> flowCollector, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, T1 t1, CompletableJob completableJob, Continuation<? super C00801> continuation) {
                    super(2, continuation);
                    this.$second = receiveChannel;
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform = function3;
                    this.$value = t1;
                    this.$collectJob = completableJob;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00801(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, this.$collectJob, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                    return invoke2(unit, continuation);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final Object invoke2(Unit unit, Continuation<? super Unit> continuation) {
                    return ((C00801) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
                    if (r11 == r0) goto L15;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
                    if (r1.emit(r11, r10) != r0) goto L7;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    Object mo11456receiveCatchingJP2dKIU;
                    Object obj2;
                    FlowCollector flowCollector;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        mo11456receiveCatchingJP2dKIU = this.$second.mo11456receiveCatchingJP2dKIU(this);
                    } else if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        mo11456receiveCatchingJP2dKIU = ((ChannelResult) obj).m11475unboximpl();
                    } else if (i != 2) {
                        if (i == 3) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        obj2 = this.L$0;
                        ResultKt.throwOnFailure(obj);
                        flowCollector = (FlowCollector) this.L$1;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$1 = null;
                        this.label = 3;
                    }
                    CompletableJob completableJob = this.$collectJob;
                    if (mo11456receiveCatchingJP2dKIU instanceof ChannelResult.Failed) {
                        Throwable m11467exceptionOrNullimpl = ChannelResult.m11467exceptionOrNullimpl(mo11456receiveCatchingJP2dKIU);
                        if (m11467exceptionOrNullimpl == null) {
                            throw new AbortFlowException(completableJob);
                        }
                        throw m11467exceptionOrNullimpl;
                    }
                    FlowCollector flowCollector2 = this.$this_unsafeFlow;
                    Function3<T1, T2, Continuation<? super R>, Object> function3 = this.$transform;
                    T1 t1 = this.$value;
                    Object obj3 = mo11456receiveCatchingJP2dKIU == NullSurrogateKt.NULL ? null : mo11456receiveCatchingJP2dKIU;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(mo11456receiveCatchingJP2dKIU);
                    this.L$1 = flowCollector2;
                    this.label = 2;
                    Object invoke = function3.invoke(t1, obj3, this);
                    if (invoke != coroutine_suspended) {
                        obj2 = mo11456receiveCatchingJP2dKIU;
                        obj = invoke;
                        flowCollector = flowCollector2;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$1 = null;
                        this.label = 3;
                    }
                    return coroutine_suspended;
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(T1 t1, Continuation<? super Unit> continuation) {
                CombineKt$zipImpl$1$1$2$1$emit$1 combineKt$zipImpl$1$1$2$1$emit$1;
                int i;
                if (continuation instanceof CombineKt$zipImpl$1$1$2$1$emit$1) {
                    combineKt$zipImpl$1$1$2$1$emit$1 = (CombineKt$zipImpl$1$1$2$1$emit$1) continuation;
                    if ((combineKt$zipImpl$1$1$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                        combineKt$zipImpl$1$1$2$1$emit$1.label -= Integer.MIN_VALUE;
                        Object obj = combineKt$zipImpl$1$1$2$1$emit$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = combineKt$zipImpl$1$1$2$1$emit$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            combineKt$zipImpl$1$1$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(t1);
                            combineKt$zipImpl$1$1$2$1$emit$1.label = 1;
                            if (ChannelFlowKt.withContextUndispatched(this.$scopeContext, Unit.INSTANCE, this.$cnt, new C00801(this.$second, this.$this_unsafeFlow, this.$transform, t1, this.$collectJob, null), combineKt$zipImpl$1$1$2$1$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            Object obj2 = combineKt$zipImpl$1$1$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }
                combineKt$zipImpl$1$1$2$1$emit$1 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, continuation);
                Object obj3 = combineKt$zipImpl$1$1$2$1$emit$1.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = combineKt$zipImpl$1$1$2$1$emit$1.label;
                if (i != 0) {
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$flow.collect(new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, this.$collectJob), this) == coroutine_suspended) {
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
