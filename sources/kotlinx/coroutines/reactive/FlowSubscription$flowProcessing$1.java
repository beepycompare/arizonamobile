package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReactiveFlow.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.FlowSubscription", f = "ReactiveFlow.kt", i = {}, l = {198}, m = "flowProcessing", n = {}, s = {}, v = 1)
/* loaded from: classes5.dex */
public final class FlowSubscription$flowProcessing$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowSubscription<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowSubscription$flowProcessing$1(FlowSubscription<T> flowSubscription, Continuation<? super FlowSubscription$flowProcessing$1> continuation) {
        super(continuation);
        this.this$0 = flowSubscription;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object flowProcessing;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        flowProcessing = this.this$0.flowProcessing(this);
        return flowProcessing;
    }
}
