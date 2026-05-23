package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BD\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\n¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00028\u0000X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedStateFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/StateFlow;", "stateFlow", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "collect", "", "collector", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "value", "getValue", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscribedStateFlow<T> implements StateFlow<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> action;
    private final StateFlow<T> stateFlow;

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return this.stateFlow.getReplayCache();
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return this.stateFlow.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedStateFlow(StateFlow<? extends T> stateFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.stateFlow = stateFlow;
        this.action = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        SubscribedStateFlow$collect$1 subscribedStateFlow$collect$1;
        int i;
        if (continuation instanceof SubscribedStateFlow$collect$1) {
            subscribedStateFlow$collect$1 = (SubscribedStateFlow$collect$1) continuation;
            if ((subscribedStateFlow$collect$1.label & Integer.MIN_VALUE) != 0) {
                subscribedStateFlow$collect$1.label -= Integer.MIN_VALUE;
                Object obj = subscribedStateFlow$collect$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = subscribedStateFlow$collect$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    subscribedStateFlow$collect$1.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    subscribedStateFlow$collect$1.label = 1;
                    if (this.stateFlow.collect(new SubscribedFlowCollector(flowCollector, this.action), subscribedStateFlow$collect$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    FlowCollector flowCollector2 = (FlowCollector) subscribedStateFlow$collect$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        subscribedStateFlow$collect$1 = new SubscribedStateFlow$collect$1(this, continuation);
        Object obj2 = subscribedStateFlow$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = subscribedStateFlow$collect$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }
}
