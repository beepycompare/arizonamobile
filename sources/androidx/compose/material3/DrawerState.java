package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: NavigationDrawer.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J$\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u00032\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0+H\u0087@¢\u0006\u0002\u0010,J0\u0010(\u001a\u00020)2\u0006\u0010&\u001a\u00020\u00032\u000e\b\u0002\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0+2\b\b\u0002\u0010.\u001a\u00020\rH\u0082@¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020)H\u0086@¢\u0006\u0002\u00101J\u000e\u00102\u001a\u00020)H\u0086@¢\u0006\u0002\u00101J\b\u00103\u001a\u00020\u0014H\u0002J\r\u00104\u001a\u00020\rH\u0000¢\u0006\u0002\b5J\u0016\u00106\u001a\u00020)2\u0006\u0010&\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u00107R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0!8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010\u0012¨\u00069"}, d2 = {"Landroidx/compose/material3/DrawerState;", "", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "currentOffset", "", "getCurrentOffset", "()F", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/DrawerValue;", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$material3_release", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "isAnimationRunning", "()Z", "isClosed", "isOpen", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/runtime/State;", "getOffset$annotations", "()V", "getOffset", "()Landroidx/compose/runtime/State;", "targetValue", "getTargetValue", "animateTo", "", "anim", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "velocity", "(Landroidx/compose/material3/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "requireDensity", "requireOffset", "requireOffset$material3_release", "snapTo", "(Landroidx/compose/material3/DrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawerState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final AnchoredDraggableState<DrawerValue> anchoredDraggableState;
    private final MutableState density$delegate;
    private final State<Float> offset;

    @Deprecated(message = "Please access the offset through currentOffset, which returns the value directly instead of wrapping it in a state object.", replaceWith = @ReplaceWith(expression = "currentOffset", imports = {}))
    public static /* synthetic */ void getOffset$annotations() {
    }

    public DrawerState(DrawerValue drawerValue, Function1<? super DrawerValue, Boolean> function1) {
        TweenSpec tweenSpec;
        MutableState mutableStateOf$default;
        tweenSpec = NavigationDrawerKt.AnimationSpec;
        this.anchoredDraggableState = new AnchoredDraggableState<>(drawerValue, new Function1<Float, Float>() { // from class: androidx.compose.material3.DrawerState$anchoredDraggableState$1
            public final Float invoke(float f) {
                float f2;
                f2 = NavigationDrawerKt.DrawerPositionalThreshold;
                return Float.valueOf(f * f2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material3.DrawerState$anchoredDraggableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Density requireDensity;
                float f;
                requireDensity = DrawerState.this.requireDensity();
                f = NavigationDrawerKt.DrawerVelocityThreshold;
                return Float.valueOf(requireDensity.mo389toPx0680j_4(f));
            }
        }, tweenSpec, function1);
        this.offset = new State<Float>() { // from class: androidx.compose.material3.DrawerState$offset$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.compose.runtime.State
            public Float getValue() {
                return Float.valueOf(DrawerState.this.getAnchoredDraggableState$material3_release().getOffset());
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.density$delegate = mutableStateOf$default;
    }

    public /* synthetic */ DrawerState(DrawerValue drawerValue, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawerValue, (i & 2) != 0 ? new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material3.DrawerState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(DrawerValue drawerValue2) {
                return true;
            }
        } : anonymousClass1);
    }

    public final AnchoredDraggableState<DrawerValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final boolean isOpen() {
        return getCurrentValue() == DrawerValue.Open;
    }

    public final boolean isClosed() {
        return getCurrentValue() == DrawerValue.Closed;
    }

    public final DrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final Object open(Continuation<? super Unit> continuation) {
        Object animateTo$default = animateTo$default(this, DrawerValue.Open, null, 0.0f, continuation, 6, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> continuation) {
        Object animateTo$default = animateTo$default(this, DrawerValue.Closed, null, 0.0f, continuation, 6, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    @Deprecated(message = "This method has been replaced by the open and close methods. The animation spec is now an implementation detail of ModalDrawer.")
    public final Object animateTo(DrawerValue drawerValue, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object animateTo$default = animateTo$default(this, drawerValue, animationSpec, 0.0f, continuation, 4, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object snapTo(DrawerValue drawerValue, Continuation<? super Unit> continuation) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, drawerValue, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final DrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final State<Float> getOffset() {
        return this.offset;
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final Density getDensity$material3_release() {
        return (Density) this.density$delegate.getValue();
    }

    public final void setDensity$material3_release(Density density) {
        this.density$delegate.setValue(density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density requireDensity() {
        Density density$material3_release = getDensity$material3_release();
        if (density$material3_release != null) {
            return density$material3_release;
        }
        throw new IllegalArgumentException(("The density on DrawerState (" + this + ") was not set. Did you use DrawerState with the ModalNavigationDrawer or DismissibleNavigationDrawer composables?").toString());
    }

    public final float requireOffset$material3_release() {
        return this.anchoredDraggableState.requireOffset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object animateTo$default(DrawerState drawerState, DrawerValue drawerValue, AnimationSpec animationSpec, float f, Continuation continuation, int i, Object obj) {
        TweenSpec tweenSpec;
        if ((i & 2) != 0) {
            tweenSpec = NavigationDrawerKt.AnimationSpec;
            animationSpec = tweenSpec;
        }
        if ((i & 4) != 0) {
            f = drawerState.anchoredDraggableState.getLastVelocity();
        }
        return drawerState.animateTo(drawerValue, animationSpec, f, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateTo(DrawerValue drawerValue, AnimationSpec<Float> animationSpec, float f, Continuation<? super Unit> continuation) {
        Object anchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, drawerValue, null, new DrawerState$animateTo$3(this, f, animationSpec, null), continuation, 2, null);
        return anchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? anchoredDrag$default : Unit.INSTANCE;
    }

    /* compiled from: NavigationDrawer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, d2 = {"Landroidx/compose/material3/DrawerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DrawerState;", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<DrawerState, DrawerValue> Saver(final Function1<? super DrawerValue, Boolean> function1) {
            return SaverKt.Saver(new Function2<SaverScope, DrawerState, DrawerValue>() { // from class: androidx.compose.material3.DrawerState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final DrawerValue invoke(SaverScope saverScope, DrawerState drawerState) {
                    return drawerState.getCurrentValue();
                }
            }, new Function1<DrawerValue, DrawerState>() { // from class: androidx.compose.material3.DrawerState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DrawerState invoke(DrawerValue drawerValue) {
                    return new DrawerState(drawerValue, function1);
                }
            });
        }
    }
}
