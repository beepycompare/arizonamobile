package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: ChannelFlow.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000\u001a&\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001aX\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u0002H\t2\b\b\u0002\u0010\f\u001a\u00020\r2\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000fH\u0080@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"asChannelFlow", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "withUndispatchedContextCollector", "Lkotlinx/coroutines/flow/FlowCollector;", "emitContext", "Lkotlin/coroutines/CoroutineContext;", "withContextUndispatched", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "newContext", "value", "countOrElement", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChannelFlowKt {
    public static final /* synthetic */ FlowCollector access$withUndispatchedContextCollector(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        return withUndispatchedContextCollector(flowCollector, coroutineContext);
    }

    public static final <T> ChannelFlow<T> asChannelFlow(Flow<? extends T> flow) {
        ChannelFlow<T> channelFlow = flow instanceof ChannelFlow ? (ChannelFlow) flow : null;
        return channelFlow == null ? new ChannelFlowOperatorImpl(flow, null, 0, null, 14, null) : channelFlow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> FlowCollector<T> withUndispatchedContextCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        return ((flowCollector instanceof SendingCollector) || (flowCollector instanceof NopCollector)) ? flowCollector : new UndispatchedContextCollector(flowCollector, coroutineContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, V> Object withContextUndispatched(CoroutineContext coroutineContext, V v, Object obj, Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        ChannelFlowKt$withContextUndispatched$1 channelFlowKt$withContextUndispatched$1;
        int i;
        Object updateThreadContext;
        Object wrapWithContinuationImpl;
        if (continuation instanceof ChannelFlowKt$withContextUndispatched$1) {
            channelFlowKt$withContextUndispatched$1 = (ChannelFlowKt$withContextUndispatched$1) continuation;
            if ((channelFlowKt$withContextUndispatched$1.label & Integer.MIN_VALUE) != 0) {
                channelFlowKt$withContextUndispatched$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelFlowKt$withContextUndispatched$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelFlowKt$withContextUndispatched$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, obj);
                    try {
                        channelFlowKt$withContextUndispatched$1.L$0 = coroutineContext;
                        channelFlowKt$withContextUndispatched$1.L$1 = v;
                        channelFlowKt$withContextUndispatched$1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        channelFlowKt$withContextUndispatched$1.L$3 = function2;
                        channelFlowKt$withContextUndispatched$1.L$4 = coroutineContext;
                        channelFlowKt$withContextUndispatched$1.L$5 = SpillingKt.nullOutSpilledVariable(obj);
                        channelFlowKt$withContextUndispatched$1.L$6 = updateThreadContext;
                        channelFlowKt$withContextUndispatched$1.L$7 = channelFlowKt$withContextUndispatched$1;
                        channelFlowKt$withContextUndispatched$1.I$0 = 0;
                        channelFlowKt$withContextUndispatched$1.I$1 = 0;
                        channelFlowKt$withContextUndispatched$1.label = 1;
                        StackFrameContinuation stackFrameContinuation = new StackFrameContinuation(channelFlowKt$withContextUndispatched$1, coroutineContext);
                        wrapWithContinuationImpl = !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, v, stackFrameContinuation) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(v, stackFrameContinuation);
                        if (wrapWithContinuationImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(channelFlowKt$withContextUndispatched$1);
                        }
                        if (wrapWithContinuationImpl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th) {
                        th = th;
                        ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i2 = channelFlowKt$withContextUndispatched$1.I$1;
                    int i3 = channelFlowKt$withContextUndispatched$1.I$0;
                    ChannelFlowKt$withContextUndispatched$1 channelFlowKt$withContextUndispatched$12 = (ChannelFlowKt$withContextUndispatched$1) channelFlowKt$withContextUndispatched$1.L$7;
                    Object obj3 = channelFlowKt$withContextUndispatched$1.L$6;
                    Object obj4 = channelFlowKt$withContextUndispatched$1.L$5;
                    CoroutineContext coroutineContext2 = (CoroutineContext) channelFlowKt$withContextUndispatched$1.L$4;
                    Function2 function22 = (Function2) channelFlowKt$withContextUndispatched$1.L$3;
                    Object obj5 = channelFlowKt$withContextUndispatched$1.L$2;
                    Object obj6 = channelFlowKt$withContextUndispatched$1.L$1;
                    CoroutineContext coroutineContext3 = (CoroutineContext) channelFlowKt$withContextUndispatched$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        updateThreadContext = obj3;
                        coroutineContext = coroutineContext2;
                        wrapWithContinuationImpl = obj2;
                    } catch (Throwable th2) {
                        th = th2;
                        updateThreadContext = obj3;
                        coroutineContext = coroutineContext2;
                        ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                        throw th;
                    }
                }
                ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
                return wrapWithContinuationImpl;
            }
        }
        channelFlowKt$withContextUndispatched$1 = new ChannelFlowKt$withContextUndispatched$1(continuation);
        Object obj22 = channelFlowKt$withContextUndispatched$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelFlowKt$withContextUndispatched$1.label;
        if (i != 0) {
        }
        ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
        return wrapWithContinuationImpl;
    }

    public static /* synthetic */ Object withContextUndispatched$default(CoroutineContext coroutineContext, Object obj, Object obj2, Function2 function2, Continuation continuation, int i, Object obj3) {
        if ((i & 4) != 0) {
            obj2 = ThreadContextKt.threadContextElements(coroutineContext);
        }
        return withContextUndispatched(coroutineContext, obj, obj2, function2, continuation);
    }
}
