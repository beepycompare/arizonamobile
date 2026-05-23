package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
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
/* compiled from: LookaheadAnimationVisualDebugHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.LookaheadAnimationVisualDebugHelper$onAttach$2", f = "LookaheadAnimationVisualDebugHelper.kt", i = {}, l = {114, 115}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes.dex */
public final class LookaheadAnimationVisualDebugHelper$onAttach$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LookaheadAnimationVisualDebugHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookaheadAnimationVisualDebugHelper$onAttach$2(LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper, Continuation<? super LookaheadAnimationVisualDebugHelper$onAttach$2> continuation) {
        super(2, continuation);
        this.this$0 = lookaheadAnimationVisualDebugHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LookaheadAnimationVisualDebugHelper$onAttach$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LookaheadAnimationVisualDebugHelper$onAttach$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r13.snapTo(kotlin.coroutines.jvm.internal.Boxing.boxFloat(0.0f), r12) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r4, kotlin.coroutines.jvm.internal.Boxing.boxFloat(1.0f), androidx.compose.animation.core.AnimationSpecKt.m196infiniteRepeatable9IiC70o$default(androidx.compose.animation.core.AnimationSpecKt.tween$default(1000, 0, androidx.compose.animation.core.EasingKt.getLinearEasing(), 2, null), androidx.compose.animation.core.RepeatMode.Restart, 0, 4, null), null, null, r12, 12, null) == r0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Animatable animatable;
        Animatable animatable2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            animatable = this.this$0.restartProgress;
            this.label = 1;
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        animatable2 = this.this$0.restartProgress;
        this.label = 2;
    }
}
