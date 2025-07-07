package androidx.paging;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1", f = "FlowExt.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class FlowExtKt$combineWithoutBatching$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SimpleProducerScope<R> $$this$simpleChannelFlow;
    final /* synthetic */ Flow<Object> $flow;
    final /* synthetic */ AtomicInteger $incompleteFlows;
    final /* synthetic */ int $index;
    final /* synthetic */ UnbatchedFlowCombiner<T1, T2> $unbatchedFlowCombiner;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowExtKt$combineWithoutBatching$2$1$1(Flow<? extends Object> flow, AtomicInteger atomicInteger, SimpleProducerScope<R> simpleProducerScope, UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner, int i, Continuation<? super FlowExtKt$combineWithoutBatching$2$1$1> continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.$incompleteFlows = atomicInteger;
        this.$$this$simpleChannelFlow = simpleProducerScope;
        this.$unbatchedFlowCombiner = unbatchedFlowCombiner;
        this.$index = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowExtKt$combineWithoutBatching$2$1$1(this.$flow, this.$incompleteFlows, this.$$this$simpleChannelFlow, this.$unbatchedFlowCombiner, this.$index, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FlowExtKt$combineWithoutBatching$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
    /* renamed from: androidx.paging.FlowExtKt$combineWithoutBatching$2$1$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ int $index;
        final /* synthetic */ UnbatchedFlowCombiner<T1, T2> $unbatchedFlowCombiner;

        public AnonymousClass1(UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner, int i) {
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
            FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1 flowExtKt$combineWithoutBatching$2$1$1$1$emit$1;
            int i;
            if (continuation instanceof FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1) {
                flowExtKt$combineWithoutBatching$2$1$1$1$emit$1 = (FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1) continuation;
                if ((flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object obj2 = flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner = this.$unbatchedFlowCombiner;
                        int i2 = this.$index;
                        flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label = 1;
                    } else if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj2);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj2);
                    }
                    flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label = 2;
                }
            }
            flowExtKt$combineWithoutBatching$2$1$1$1$emit$1 = new FlowExtKt$combineWithoutBatching$2$1$1$1$emit$1(this, continuation);
            Object obj22 = flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label;
            if (i != 0) {
            }
            flowExtKt$combineWithoutBatching$2$1$1$1$emit$1.label = 2;
        }
    }
}
