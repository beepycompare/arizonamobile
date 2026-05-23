package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChannelFlow.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowKt", f = "ChannelFlow.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {221}, m = "withContextUndispatched", n = {"newContext", "value", "countOrElement", "block", "context$iv", "countOrElement$iv", "oldValue$iv", "$i$f$withCoroutineContext", "$i$a$-withCoroutineContext-ChannelFlowKt$withContextUndispatched$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
/* loaded from: classes5.dex */
public final class ChannelFlowKt$withContextUndispatched$1<T, V> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelFlowKt$withContextUndispatched$1(Continuation<? super ChannelFlowKt$withContextUndispatched$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelFlowKt.withContextUndispatched(null, null, null, null, this);
    }
}
