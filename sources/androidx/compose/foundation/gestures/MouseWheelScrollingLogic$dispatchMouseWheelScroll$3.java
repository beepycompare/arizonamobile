package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MouseWheelScrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3", f = "MouseWheelScrollable.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {297, 310, 334}, m = "invokeSuspend", n = {"$this$userScroll", "requiredAnimation", "$this$userScroll", "requiredAnimation", "durationMillis", "$this$userScroll", "requiredAnimation"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1"}, v = 1)
/* loaded from: classes.dex */
public final class MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> $animationState;
    final /* synthetic */ float $speed;
    final /* synthetic */ Ref.ObjectRef<MouseWheelScrollingLogic.MouseWheelScrollDelta> $targetScrollDelta;
    final /* synthetic */ Ref.FloatRef $targetValue;
    final /* synthetic */ ScrollingLogic $this_dispatchMouseWheelScroll;
    final /* synthetic */ float $threshold;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MouseWheelScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(Ref.FloatRef floatRef, Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef, Ref.ObjectRef<MouseWheelScrollingLogic.MouseWheelScrollDelta> objectRef2, float f, MouseWheelScrollingLogic mouseWheelScrollingLogic, float f2, ScrollingLogic scrollingLogic, Continuation<? super MouseWheelScrollingLogic$dispatchMouseWheelScroll$3> continuation) {
        super(2, continuation);
        this.$targetValue = floatRef;
        this.$animationState = objectRef;
        this.$targetScrollDelta = objectRef2;
        this.$threshold = f;
        this.this$0 = mouseWheelScrollingLogic;
        this.$speed = f2;
        this.$this_dispatchMouseWheelScroll = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 mouseWheelScrollingLogic$dispatchMouseWheelScroll$3 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(this.$targetValue, this.$animationState, this.$targetScrollDelta, this.$threshold, this.this$0, this.$speed, this.$this_dispatchMouseWheelScroll, continuation);
        mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.L$0 = obj;
        return mouseWheelScrollingLogic$dispatchMouseWheelScroll$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation<? super Unit> continuation) {
        return ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$3) create(nestedScrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019a  */
    /* JADX WARN: Type inference failed for: r2v17, types: [androidx.compose.animation.core.AnimationState, T] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x012c -> B:14:0x0066). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0158 -> B:31:0x0159). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0190 -> B:13:0x0065). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        NestedScrollScope nestedScrollScope;
        final Ref.BooleanRef booleanRef2;
        Object obj2;
        int i;
        Object animateMouseWheelScroll;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            booleanRef = new Ref.BooleanRef();
            booleanRef.element = true;
            nestedScrollScope = (NestedScrollScope) this.L$0;
            booleanRef2 = booleanRef;
            if (!booleanRef2.element) {
            }
        } else if (i2 == 1) {
            booleanRef = (Ref.BooleanRef) this.L$1;
            ResultKt.throwOnFailure(obj);
            booleanRef2 = (Ref.BooleanRef) this.L$2;
            nestedScrollScope = (NestedScrollScope) this.L$0;
            obj2 = obj;
            booleanRef2.element = ((Boolean) obj2).booleanValue();
            booleanRef2 = booleanRef;
            if (!booleanRef2.element) {
            }
        } else if (i2 == 2) {
            i = this.I$0;
            ResultKt.throwOnFailure(obj);
            booleanRef2 = (Ref.BooleanRef) this.L$1;
            nestedScrollScope = (NestedScrollScope) this.L$0;
            if (!booleanRef2.element) {
            }
            if (!booleanRef2.element) {
            }
        } else if (i2 != 3) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            booleanRef = (Ref.BooleanRef) this.L$1;
            ResultKt.throwOnFailure(obj);
            booleanRef2 = (Ref.BooleanRef) this.L$2;
            nestedScrollScope = (NestedScrollScope) this.L$0;
            Object dispatchMouseWheelScroll$waitNextScrollDelta = obj;
            booleanRef2.element = ((Boolean) dispatchMouseWheelScroll$waitNextScrollDelta).booleanValue();
            booleanRef2 = booleanRef;
            if (!booleanRef2.element) {
                booleanRef2.element = false;
                float floatValue = this.$targetValue.element - this.$animationState.element.getValue().floatValue();
                if (this.$targetScrollDelta.element.getShouldApplyImmediately() || Math.abs(floatValue) < this.$threshold) {
                    this.this$0.dispatchMouseWheelScroll(nestedScrollScope, floatValue);
                    this.L$0 = nestedScrollScope;
                    this.L$1 = booleanRef2;
                    this.L$2 = booleanRef2;
                    this.label = 1;
                    obj2 = MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(this.this$0, this.$targetScrollDelta, this.$targetValue, this.$this_dispatchMouseWheelScroll, this.$animationState, 50L, this);
                    if (obj2 != coroutine_suspended) {
                        booleanRef = booleanRef2;
                        booleanRef2.element = ((Boolean) obj2).booleanValue();
                        booleanRef2 = booleanRef;
                        if (!booleanRef2.element) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    float signum = Math.signum(floatValue) * this.$threshold;
                    this.this$0.dispatchMouseWheelScroll(nestedScrollScope, signum);
                    Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef = this.$animationState;
                    objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, this.$animationState.element.getValue().floatValue() + signum, 0.0f, 0L, 0L, false, 30, (Object) null);
                    int coerceAtMost = RangesKt.coerceAtMost(MathKt.roundToInt(Math.abs(this.$targetValue.element - this.$animationState.element.getValue().floatValue()) / this.$speed), 100);
                    float f = this.$targetValue.element;
                    final MouseWheelScrollingLogic mouseWheelScrollingLogic = this.this$0;
                    final Ref.ObjectRef<MouseWheelScrollingLogic.MouseWheelScrollDelta> objectRef2 = this.$targetScrollDelta;
                    final Ref.FloatRef floatRef = this.$targetValue;
                    final ScrollingLogic scrollingLogic = this.$this_dispatchMouseWheelScroll;
                    this.L$0 = nestedScrollScope;
                    this.L$1 = booleanRef2;
                    this.L$2 = null;
                    this.I$0 = coerceAtMost;
                    this.label = 2;
                    animateMouseWheelScroll = this.this$0.animateMouseWheelScroll(nestedScrollScope, this.$animationState.element, f, coerceAtMost, new Function1() { // from class: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            return Boolean.valueOf(MouseWheelScrollingLogic$dispatchMouseWheelScroll$3.invokeSuspend$lambda$0(MouseWheelScrollingLogic.this, objectRef2, floatRef, scrollingLogic, booleanRef2, ((Float) obj3).floatValue()));
                        }
                    }, this);
                    if (animateMouseWheelScroll != coroutine_suspended) {
                        i = coerceAtMost;
                        if (!booleanRef2.element) {
                            this.L$0 = nestedScrollScope;
                            this.L$1 = booleanRef2;
                            this.L$2 = booleanRef2;
                            this.label = 3;
                            dispatchMouseWheelScroll$waitNextScrollDelta = MouseWheelScrollingLogic.dispatchMouseWheelScroll$waitNextScrollDelta(this.this$0, this.$targetScrollDelta, this.$targetValue, this.$this_dispatchMouseWheelScroll, this.$animationState, 50 - i, this);
                            if (dispatchMouseWheelScroll$waitNextScrollDelta != coroutine_suspended) {
                                booleanRef = booleanRef2;
                                booleanRef2.element = ((Boolean) dispatchMouseWheelScroll$waitNextScrollDelta).booleanValue();
                                booleanRef2 = booleanRef;
                            }
                        }
                        if (!booleanRef2.element) {
                        }
                    }
                }
                return coroutine_suspended;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r2v4, types: [T, androidx.compose.foundation.gestures.MouseWheelScrollingLogic$MouseWheelScrollDelta] */
    public static final boolean invokeSuspend$lambda$0(MouseWheelScrollingLogic mouseWheelScrollingLogic, Ref.ObjectRef objectRef, Ref.FloatRef floatRef, ScrollingLogic scrollingLogic, Ref.BooleanRef booleanRef, float f) {
        Channel channel;
        MouseWheelScrollingLogic.MouseWheelScrollDelta sumOrNull;
        float m589toFloatk4lQ0M;
        boolean isLowScrollingDelta;
        channel = mouseWheelScrollingLogic.channel;
        sumOrNull = mouseWheelScrollingLogic.sumOrNull(channel);
        if (sumOrNull != null) {
            mouseWheelScrollingLogic.trackVelocity(sumOrNull);
            objectRef.element = ((MouseWheelScrollingLogic.MouseWheelScrollDelta) objectRef.element).plus(sumOrNull);
            if (ComposeFoundationFlags.isMouseWheel1DAxisLockingEnabled) {
                m589toFloatk4lQ0M = scrollingLogic.m591toSingleAxisDeltaFromAnglek4lQ0M(scrollingLogic.m587reverseIfNeededMKHz9U(((MouseWheelScrollingLogic.MouseWheelScrollDelta) objectRef.element).m527getValueF1C5BW0()));
            } else {
                m589toFloatk4lQ0M = scrollingLogic.m589toFloatk4lQ0M(scrollingLogic.m587reverseIfNeededMKHz9U(((MouseWheelScrollingLogic.MouseWheelScrollDelta) objectRef.element).m527getValueF1C5BW0()));
            }
            floatRef.element = m589toFloatk4lQ0M;
            isLowScrollingDelta = MouseWheelScrollableKt.isLowScrollingDelta(floatRef.element - f);
            booleanRef.element = !isLowScrollingDelta;
        }
        return sumOrNull != null;
    }
}
