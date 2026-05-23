package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Share.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", i = {0}, l = {442}, m = "collect", n = {"collector"}, s = {"L$0"}, v = 1)
/* loaded from: classes5.dex */
public final class SubscribedSharedFlow$collect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubscribedSharedFlow<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscribedSharedFlow$collect$1(SubscribedSharedFlow<T> subscribedSharedFlow, Continuation<? super SubscribedSharedFlow$collect$1> continuation) {
        super(continuation);
        this.this$0 = subscribedSharedFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
