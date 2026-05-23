package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channels.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a6\u0010\u0007\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a$\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"emitAll", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveAsFlow", "Lkotlinx/coroutines/flow/Flow;", "consumeAsFlow", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086 A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #0 {all -> 0x00ac, blocks: (B:13:0x003a, B:23:0x0067, B:27:0x007e, B:29:0x0086, B:18:0x0056, B:21:0x0062), top: B:43:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00a1 -> B:23:0x0067). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean z, Continuation<? super Unit> continuation) {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        Object coroutine_suspended;
        int i;
        ChannelIterator<? extends T> it;
        Throwable th;
        ChannelIterator<? extends T> channelIterator;
        Object hasNext;
        try {
            if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
                flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
                if ((flowKt__ChannelsKt$emitAllImpl$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__ChannelsKt$emitAllImpl$1.label -= Integer.MIN_VALUE;
                    Object obj = flowKt__ChannelsKt$emitAllImpl$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = flowKt__ChannelsKt$emitAllImpl$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowKt.ensureActive(flowCollector);
                        it = receiveChannel.iterator();
                    } else if (i == 1) {
                        z = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                        ChannelIterator<? extends T> channelIterator2 = (ChannelIterator) flowKt__ChannelsKt$emitAllImpl$1.L$2;
                        receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                        FlowCollector flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        FlowCollector flowCollector3 = flowCollector2;
                        th = null;
                        if (!((Boolean) obj).booleanValue()) {
                            Object obj2 = (T) channelIterator2.next();
                            flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector3;
                            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                            flowKt__ChannelsKt$emitAllImpl$1.L$2 = channelIterator2;
                            flowKt__ChannelsKt$emitAllImpl$1.L$3 = SpillingKt.nullOutSpilledVariable(obj2);
                            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                            flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                            if (flowCollector3.emit(obj2, flowKt__ChannelsKt$emitAllImpl$1) != coroutine_suspended) {
                                channelIterator = channelIterator2;
                                flowCollector = flowCollector3;
                                flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                                flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                                flowKt__ChannelsKt$emitAllImpl$1.L$2 = channelIterator;
                                flowKt__ChannelsKt$emitAllImpl$1.L$3 = null;
                                flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                                flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                                hasNext = channelIterator.hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                                if (hasNext != coroutine_suspended) {
                                    flowCollector3 = flowCollector;
                                    channelIterator2 = channelIterator;
                                    obj = hasNext;
                                    if (!((Boolean) obj).booleanValue()) {
                                        if (z) {
                                            ChannelsKt.cancelConsumed(receiveChannel, th);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                            return coroutine_suspended;
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        z = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                        Object obj3 = flowKt__ChannelsKt$emitAllImpl$1.L$3;
                        ChannelIterator<? extends T> channelIterator3 = (ChannelIterator) flowKt__ChannelsKt$emitAllImpl$1.L$2;
                        receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                        FlowCollector<? super T> flowCollector4 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        it = channelIterator3;
                        flowCollector = flowCollector4;
                    }
                    th = null;
                    channelIterator = it;
                    flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                    flowKt__ChannelsKt$emitAllImpl$1.L$2 = channelIterator;
                    flowKt__ChannelsKt$emitAllImpl$1.L$3 = null;
                    flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
                    flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                    hasNext = channelIterator.hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                    if (hasNext != coroutine_suspended) {
                    }
                }
            }
            if (i != 0) {
            }
            th = null;
            channelIterator = it;
            flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
            flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
            flowKt__ChannelsKt$emitAllImpl$1.L$2 = channelIterator;
            flowKt__ChannelsKt$emitAllImpl$1.L$3 = null;
            flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z;
            flowKt__ChannelsKt$emitAllImpl$1.label = 1;
            hasNext = channelIterator.hasNext(flowKt__ChannelsKt$emitAllImpl$1);
            if (hasNext != coroutine_suspended) {
            }
        } finally {
        }
        flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        Object obj4 = flowKt__ChannelsKt$emitAllImpl$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__ChannelsKt$emitAllImpl$1.label;
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow, CoroutineScope coroutineScope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }
}
