package androidx.compose.material3;

import androidx.compose.material3.internal.AnchoredDraggableDefaults;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SwipeToDismissBox.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000eJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010$R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0015¨\u0006*"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState;", "", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SwipeToDismissBoxValue;", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "dismissDirection", "getDismissDirection", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset$material3_release", "()F", "progress", "getProgress", "targetValue", "getTargetValue", "dismiss", "", "direction", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireOffset", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeToDismissBoxState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final AnchoredDraggableState<SwipeToDismissBoxValue> anchoredDraggableState;
    private final Density density;

    public SwipeToDismissBoxState(SwipeToDismissBoxValue swipeToDismissBoxValue, Density density, Function1<? super SwipeToDismissBoxValue, Boolean> function1, Function1<? super Float, Float> function12) {
        this.density = density;
        this.anchoredDraggableState = new AnchoredDraggableState<>(swipeToDismissBoxValue, function12, new Function0<Float>() { // from class: androidx.compose.material3.SwipeToDismissBoxState$anchoredDraggableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(SwipeToDismissBoxState.this.getDensity$material3_release().mo389toPx0680j_4(SwipeToDismissBoxKt.access$getDismissVelocityThreshold$p()));
            }
        }, AnchoredDraggableDefaults.INSTANCE.getAnimationSpec(), function1);
    }

    public final Density getDensity$material3_release() {
        return this.density;
    }

    public /* synthetic */ SwipeToDismissBoxState(SwipeToDismissBoxValue swipeToDismissBoxValue, Density density, AnonymousClass1 anonymousClass1, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(swipeToDismissBoxValue, density, (i & 4) != 0 ? new Function1<SwipeToDismissBoxValue, Boolean>() { // from class: androidx.compose.material3.SwipeToDismissBoxState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SwipeToDismissBoxValue swipeToDismissBoxValue2) {
                return true;
            }
        } : anonymousClass1, function1);
    }

    public final AnchoredDraggableState<SwipeToDismissBoxValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final float getOffset$material3_release() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final SwipeToDismissBoxValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final SwipeToDismissBoxValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final SwipeToDismissBoxValue getDismissDirection() {
        return (getOffset$material3_release() == 0.0f || Float.isNaN(getOffset$material3_release())) ? SwipeToDismissBoxValue.Settled : getOffset$material3_release() > 0.0f ? SwipeToDismissBoxValue.StartToEnd : SwipeToDismissBoxValue.EndToStart;
    }

    public final Object snapTo(SwipeToDismissBoxValue swipeToDismissBoxValue, Continuation<? super Unit> continuation) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, swipeToDismissBoxValue, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final Object reset(Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SwipeToDismissBoxValue.Settled, 0.0f, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object dismiss(SwipeToDismissBoxValue swipeToDismissBoxValue, Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, swipeToDismissBoxValue, 0.0f, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    /* compiled from: SwipeToDismissBox.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeToDismissBoxState;", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "density", "Landroidx/compose/ui/unit/Density;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SwipeToDismissBoxState, SwipeToDismissBoxValue> Saver(final Function1<? super SwipeToDismissBoxValue, Boolean> function1, final Function1<? super Float, Float> function12, final Density density) {
            return SaverKt.Saver(new Function2<SaverScope, SwipeToDismissBoxState, SwipeToDismissBoxValue>() { // from class: androidx.compose.material3.SwipeToDismissBoxState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final SwipeToDismissBoxValue invoke(SaverScope saverScope, SwipeToDismissBoxState swipeToDismissBoxState) {
                    return swipeToDismissBoxState.getCurrentValue();
                }
            }, new Function1<SwipeToDismissBoxValue, SwipeToDismissBoxState>() { // from class: androidx.compose.material3.SwipeToDismissBoxState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final SwipeToDismissBoxState invoke(SwipeToDismissBoxValue swipeToDismissBoxValue) {
                    return new SwipeToDismissBoxState(swipeToDismissBoxValue, Density.this, function1, function12);
                }
            });
        }
    }
}
