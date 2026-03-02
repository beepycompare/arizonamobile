package androidx.paging;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FlowExt.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.paging.UnbatchedFlowCombiner", f = "FlowExt.kt", i = {0, 0, 1, 1, 1, 2}, l = {174, 214, 191}, m = "onNext", n = {"value", FirebaseAnalytics.Param.INDEX, "value", "$this$withLock_u24default$iv", FirebaseAnalytics.Param.INDEX, "$this$withLock_u24default$iv"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0"}, v = 1)
/* loaded from: classes3.dex */
public final class UnbatchedFlowCombiner$onNext$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnbatchedFlowCombiner<T1, T2> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnbatchedFlowCombiner$onNext$1(UnbatchedFlowCombiner<T1, T2> unbatchedFlowCombiner, Continuation<? super UnbatchedFlowCombiner$onNext$1> continuation) {
        super(continuation);
        this.this$0 = unbatchedFlowCombiner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onNext(0, null, this);
    }
}
