package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransitionHandler.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.TransitionHandler", f = "TransitionHandler.kt", i = {0}, l = {74}, m = "updateProgressWhileTouchUp", n = {"this"}, s = {"L$0"})
/* loaded from: classes2.dex */
public final class TransitionHandler$updateProgressWhileTouchUp$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TransitionHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransitionHandler$updateProgressWhileTouchUp$1(TransitionHandler transitionHandler, Continuation<? super TransitionHandler$updateProgressWhileTouchUp$1> continuation) {
        super(continuation);
        this.this$0 = transitionHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateProgressWhileTouchUp(this);
    }
}
