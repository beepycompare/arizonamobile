package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1", f = "TimePicker.kt", i = {}, l = {1539}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class ClockDialNode$pointerInputDragNode$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Offset $dragAmount;
    int label;
    final /* synthetic */ ClockDialNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClockDialNode$pointerInputDragNode$1$2$1(ClockDialNode clockDialNode, Offset offset, Continuation<? super ClockDialNode$pointerInputDragNode$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = clockDialNode;
        this.$dragAmount = offset;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClockDialNode$pointerInputDragNode$1$2$1(this.this$0, this.$dragAmount, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClockDialNode$pointerInputDragNode$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float f;
        float f2;
        AnalogTimePickerState analogTimePickerState;
        float f3;
        long m1841getCenternOccac;
        float f4;
        long m1841getCenternOccac2;
        float atan;
        AnimationSpec animationSpec;
        AnalogTimePickerState analogTimePickerState2;
        float f5;
        float f6;
        float maxDist;
        long m1841getCenternOccac3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ClockDialNode clockDialNode = this.this$0;
            f = clockDialNode.offsetX;
            clockDialNode.offsetX = f + Float.intBitsToFloat((int) (this.$dragAmount.m4537unboximpl() >> 32));
            ClockDialNode clockDialNode2 = this.this$0;
            f2 = clockDialNode2.offsetY;
            clockDialNode2.offsetY = f2 + Float.intBitsToFloat((int) (this.$dragAmount.m4537unboximpl() & 4294967295L));
            analogTimePickerState = this.this$0.state;
            f3 = this.this$0.offsetY;
            m1841getCenternOccac = this.this$0.m1841getCenternOccac();
            float m7684getYimpl = f3 - IntOffset.m7684getYimpl(m1841getCenternOccac);
            f4 = this.this$0.offsetX;
            m1841getCenternOccac2 = this.this$0.m1841getCenternOccac();
            atan = TimePickerKt.atan(m7684getYimpl, f4 - IntOffset.m7683getXimpl(m1841getCenternOccac2));
            animationSpec = this.this$0.animationSpec;
            this.label = 1;
            if (AnalogTimePickerState.rotateTo$default(analogTimePickerState, atan, animationSpec, false, this, 4, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        analogTimePickerState2 = this.this$0.state;
        f5 = this.this$0.offsetX;
        f6 = this.this$0.offsetY;
        maxDist = this.this$0.getMaxDist();
        m1841getCenternOccac3 = this.this$0.m1841getCenternOccac();
        TimePickerKt.m2760moveSelectord3b8Pxo(analogTimePickerState2, f5, f6, maxDist, m1841getCenternOccac3);
        return Unit.INSTANCE;
    }
}
