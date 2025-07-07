package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
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
/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ButtonElevation$animateElevation$2$1", f = "Button.kt", i = {}, l = {989, DescriptorProtos.Edition.EDITION_PROTO2_VALUE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
public final class ButtonElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ ButtonElevation this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonElevation$animateElevation$2$1(Animatable<Dp, AnimationVector1D> animatable, float f, boolean z, ButtonElevation buttonElevation, Interaction interaction, Continuation<? super ButtonElevation$animateElevation$2$1> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z;
        this.this$0 = buttonElevation;
        this.$interaction = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ButtonElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.this$0, this.$interaction, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ButtonElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        if (r6.$animatable.snapTo(androidx.compose.ui.unit.Dp.m6682boximpl(r6.$target), r6) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ab, code lost:
        if (androidx.compose.material3.internal.ElevationKt.m2705animateElevationrAjV9yQ(r6.$animatable, r6.$target, r3, r6.$interaction, r6) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ad, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        float f;
        float f2;
        float f3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Dp.m6689equalsimpl0(this.$animatable.getTargetValue().m6698unboximpl(), this.$target)) {
                if (this.$enabled) {
                    float m6698unboximpl = this.$animatable.getTargetValue().m6698unboximpl();
                    f = this.this$0.pressedElevation;
                    FocusInteraction.Focus focus = null;
                    if (Dp.m6689equalsimpl0(m6698unboximpl, f)) {
                        focus = new PressInteraction.Press(Offset.Companion.m3853getZeroF1C5BW0(), null);
                    } else {
                        f2 = this.this$0.hoveredElevation;
                        if (Dp.m6689equalsimpl0(m6698unboximpl, f2)) {
                            focus = new HoverInteraction.Enter();
                        } else {
                            f3 = this.this$0.focusedElevation;
                            if (Dp.m6689equalsimpl0(m6698unboximpl, f3)) {
                                focus = new FocusInteraction.Focus();
                            }
                        }
                    }
                    this.label = 2;
                } else {
                    this.label = 1;
                }
            }
        } else if (i != 1 && i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
