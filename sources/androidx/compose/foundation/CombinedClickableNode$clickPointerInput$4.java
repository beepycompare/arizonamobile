package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.CombinedClickableNode$clickPointerInput$4", f = "Clickable.kt", i = {}, l = {770}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class CombinedClickableNode$clickPointerInput$4 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CombinedClickableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombinedClickableNode$clickPointerInput$4(CombinedClickableNode combinedClickableNode, Continuation<? super CombinedClickableNode$clickPointerInput$4> continuation) {
        super(3, continuation);
        this.this$0 = combinedClickableNode;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
        return m299invoked4ec7I(pressGestureScope, offset.m3847unboximpl(), continuation);
    }

    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
    public final Object m299invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
        CombinedClickableNode$clickPointerInput$4 combinedClickableNode$clickPointerInput$4 = new CombinedClickableNode$clickPointerInput$4(this.this$0, continuation);
        combinedClickableNode$clickPointerInput$4.L$0 = pressGestureScope;
        combinedClickableNode$clickPointerInput$4.J$0 = j;
        return combinedClickableNode$clickPointerInput$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
            long j = this.J$0;
            if (this.this$0.getEnabled()) {
                this.label = 1;
                if (this.this$0.m213handlePressInteractiond4ec7I(pressGestureScope, j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
