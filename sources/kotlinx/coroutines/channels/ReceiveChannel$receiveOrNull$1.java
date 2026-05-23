package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Channel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ReceiveChannel", f = "Channel.kt", i = {0}, l = {770}, m = "receiveOrNull$suspendImpl", n = {"$this"}, s = {"L$0"}, v = 1)
/* loaded from: classes5.dex */
public final class ReceiveChannel$receiveOrNull$1<E> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReceiveChannel<E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReceiveChannel$receiveOrNull$1(ReceiveChannel<? extends E> receiveChannel, Continuation<? super ReceiveChannel$receiveOrNull$1> continuation) {
        super(continuation);
        this.this$0 = receiveChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReceiveChannel.receiveOrNull$suspendImpl(this.this$0, this);
    }
}
