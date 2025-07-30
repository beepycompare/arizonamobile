package coil3.compose;

import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: DrawScopeSizeResolver.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/compose/ui/geometry/Size;", "it", "Lkotlinx/coroutines/flow/Flow;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "coil3.compose.RealDrawScopeSizeResolver$size$2", f = "DrawScopeSizeResolver.kt", i = {0, 0}, l = {58}, m = "invokeSuspend", n = {"$this$transformLatest", "it"}, s = {"L$0", "L$1"})
/* loaded from: classes3.dex */
final class RealDrawScopeSizeResolver$size$2 extends SuspendLambda implements Function3<FlowCollector<? super Size>, Flow<? extends Size>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealDrawScopeSizeResolver$size$2(Continuation<? super RealDrawScopeSizeResolver$size$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Size> flowCollector, Flow<? extends Size> flow, Continuation<? super Unit> continuation) {
        return invoke2(flowCollector, (Flow<Size>) flow, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Size> flowCollector, Flow<Size> flow, Continuation<? super Unit> continuation) {
        RealDrawScopeSizeResolver$size$2 realDrawScopeSizeResolver$size$2 = new RealDrawScopeSizeResolver$size$2(continuation);
        realDrawScopeSizeResolver$size$2.L$0 = flowCollector;
        realDrawScopeSizeResolver$size$2.L$1 = flow;
        return realDrawScopeSizeResolver$size$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Flow flow = (Flow) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(flow);
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, flow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
