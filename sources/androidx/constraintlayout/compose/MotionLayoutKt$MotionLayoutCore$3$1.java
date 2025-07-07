package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MotionLayout.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$3$1", f = "MotionLayout.kt", i = {}, l = {475, 485}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class MotionLayoutKt$MotionLayoutCore$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $animateToEnd$delegate;
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ MutableState<ConstraintSet> $end$delegate;
    final /* synthetic */ Function0<Unit> $finishedAnimationListener;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progress;
    final /* synthetic */ MutableState<ConstraintSet> $start$delegate;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionLayoutKt$MotionLayoutCore$3$1(Channel<ConstraintSet> channel, Animatable<Float, AnimationVector1D> animatable, AnimationSpec<Float> animationSpec, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<ConstraintSet> mutableState2, MutableState<ConstraintSet> mutableState3, Continuation<? super MotionLayoutKt$MotionLayoutCore$3$1> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$progress = animatable;
        this.$animationSpec = animationSpec;
        this.$finishedAnimationListener = function0;
        this.$animateToEnd$delegate = mutableState;
        this.$start$delegate = mutableState2;
        this.$end$delegate = mutableState3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MotionLayoutKt$MotionLayoutCore$3$1(this.$channel, this.$progress, this.$animationSpec, this.$finishedAnimationListener, this.$animateToEnd$delegate, this.$start$delegate, this.$end$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MotionLayoutKt$MotionLayoutCore$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (r5 == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b3, code lost:
        if (androidx.compose.animation.core.Animatable.animateTo$default(r16.$progress, kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6), r16.$animationSpec, null, null, r16, 12, null) == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
        return r1;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0086 -> B:11:0x0034). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b3 -> B:37:0x00b6). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ChannelIterator<ConstraintSet> it;
        Object obj2;
        boolean MotionLayoutCore_TEds9UA$lambda$23;
        boolean MotionLayoutCore_TEds9UA$lambda$232;
        boolean MotionLayoutCore_TEds9UA$lambda$233;
        boolean MotionLayoutCore_TEds9UA$lambda$234;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            it = this.$channel.iterator();
            this.L$0 = it;
            this.label = 1;
            obj2 = it.hasNext(this);
        } else if (i == 1) {
            it = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            if (((Boolean) obj2).booleanValue()) {
                ConstraintSet next = it.next();
                ConstraintSet constraintSet = (ConstraintSet) ChannelResult.m9971getOrNullimpl(this.$channel.mo9959tryReceivePtdJZtk());
                if (constraintSet != null) {
                    next = constraintSet;
                }
                MotionLayoutCore_TEds9UA$lambda$23 = MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$23(this.$animateToEnd$delegate);
                float f = MotionLayoutCore_TEds9UA$lambda$23 ? 1.0f : 0.0f;
                MotionLayoutCore_TEds9UA$lambda$232 = MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$23(this.$animateToEnd$delegate);
                if (!Intrinsics.areEqual(next, MotionLayoutCore_TEds9UA$lambda$232 ? MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$14(this.$start$delegate) : MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$17(this.$end$delegate))) {
                    MotionLayoutCore_TEds9UA$lambda$233 = MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$23(this.$animateToEnd$delegate);
                    if (!MotionLayoutCore_TEds9UA$lambda$233) {
                        this.$start$delegate.setValue(next);
                    } else {
                        this.$end$delegate.setValue(next);
                    }
                    this.L$0 = it;
                    this.label = 2;
                }
                this.L$0 = it;
                this.label = 1;
                obj2 = it.hasNext(this);
            } else {
                return Unit.INSTANCE;
            }
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            MutableState<Boolean> mutableState = this.$animateToEnd$delegate;
            MotionLayoutCore_TEds9UA$lambda$234 = MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$23(mutableState);
            MotionLayoutKt.MotionLayoutCore_TEds9UA$lambda$24(mutableState, !MotionLayoutCore_TEds9UA$lambda$234);
            Function0<Unit> function0 = this.$finishedAnimationListener;
            if (function0 != null) {
                function0.invoke();
            }
            this.L$0 = it;
            this.label = 1;
            obj2 = it.hasNext(this);
        }
    }
}
