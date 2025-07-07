package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SheetDefaults.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\"\u0010#\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u001cH\u0080@¢\u0006\u0004\b&\u0010'J\u000e\u0010(\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u000e\u0010+\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u0006\u0010,\u001a\u00020\u001cJ\u0018\u0010-\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0080@¢\u0006\u0004\b.\u0010/J\u000e\u00100\u001a\u00020$H\u0086@¢\u0006\u0002\u0010)J\u0018\u00101\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b2\u00103R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\n\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010!\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014¨\u00065"}, d2 = {"Landroidx/compose/material3/SheetState;", "", "skipPartiallyExpanded", "", "density", "Landroidx/compose/ui/unit/Density;", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "(ZLandroidx/compose/ui/unit/Density;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setAnchoredDraggableState$material3_release", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "hasExpandedState", "getHasExpandedState", "()Z", "hasPartiallyExpandedState", "getHasPartiallyExpandedState", "isVisible", TypedValues.CycleType.S_WAVE_OFFSET, "", "getOffset$material3_release", "()Ljava/lang/Float;", "getSkipHiddenState$material3_release", "getSkipPartiallyExpanded$material3_release", "targetValue", "getTargetValue", "animateTo", "", "velocity", "animateTo$material3_release", "(Landroidx/compose/material3/SheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hide", "partialExpand", "requireOffset", "settle", "settle$material3_release", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "snapTo", "snapTo$material3_release", "(Landroidx/compose/material3/SheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SheetState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private AnchoredDraggableState<SheetValue> anchoredDraggableState;
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;

    public SheetState(boolean z, final Density density, SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z2) {
        AnimationSpec animationSpec;
        this.skipPartiallyExpanded = z;
        this.skipHiddenState = z2;
        if (z && sheetValue == SheetValue.PartiallyExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
        }
        if (z2 && sheetValue == SheetValue.Hidden) {
            throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
        }
        animationSpec = SheetDefaultsKt.BottomSheetAnimationSpec;
        this.anchoredDraggableState = new AnchoredDraggableState<>(sheetValue, new Function1<Float, Float>() { // from class: androidx.compose.material3.SheetState$anchoredDraggableState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Float invoke(float f) {
                return Float.valueOf(Density.this.mo389toPx0680j_4(Dp.m6684constructorimpl(56)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Float invoke(Float f) {
                return invoke(f.floatValue());
            }
        }, new Function0<Float>() { // from class: androidx.compose.material3.SheetState$anchoredDraggableState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(Density.this.mo389toPx0680j_4(Dp.m6684constructorimpl(125)));
            }
        }, animationSpec, function1);
    }

    public final boolean getSkipPartiallyExpanded$material3_release() {
        return this.skipPartiallyExpanded;
    }

    public /* synthetic */ SheetState(boolean z, Density density, SheetValue sheetValue, AnonymousClass1 anonymousClass1, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, density, (i & 4) != 0 ? SheetValue.Hidden : sheetValue, (i & 8) != 0 ? new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.SheetState.1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(SheetValue sheetValue2) {
                return true;
            }
        } : anonymousClass1, (i & 16) != 0 ? false : z2);
    }

    public final boolean getSkipHiddenState$material3_release() {
        return this.skipHiddenState;
    }

    public final SheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final SheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isVisible() {
        return this.anchoredDraggableState.getCurrentValue() != SheetValue.Hidden;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final boolean getHasExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.PartiallyExpanded);
    }

    public final Object expand(Continuation<? super Unit> continuation) {
        Object animateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SheetValue.Expanded, 0.0f, continuation, 2, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object partialExpand(Continuation<? super Unit> continuation) {
        if (this.skipPartiallyExpanded) {
            throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
        }
        Object animateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.PartiallyExpanded, 0.0f, continuation, 2, null);
        return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
    }

    public final Object show(Continuation<? super Unit> continuation) {
        Object animateTo$material3_release$default = animateTo$material3_release$default(this, getHasPartiallyExpandedState() ? SheetValue.PartiallyExpanded : SheetValue.Expanded, 0.0f, continuation, 2, null);
        return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> continuation) {
        if (this.skipHiddenState) {
            throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
        }
        Object animateTo$material3_release$default = animateTo$material3_release$default(this, SheetValue.Hidden, 0.0f, continuation, 2, null);
        return animateTo$material3_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material3_release$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$material3_release$default(SheetState sheetState, SheetValue sheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = sheetState.anchoredDraggableState.getLastVelocity();
        }
        return sheetState.animateTo$material3_release(sheetValue, f, continuation);
    }

    public final Object animateTo$material3_release(SheetValue sheetValue, float f, Continuation<? super Unit> continuation) {
        Object animateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, sheetValue, f, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material3_release(SheetValue sheetValue, Continuation<? super Unit> continuation) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, sheetValue, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final Object settle$material3_release(float f, Continuation<? super Unit> continuation) {
        Object obj = this.anchoredDraggableState.settle(f, continuation);
        return obj == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }

    public final AnchoredDraggableState<SheetValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final void setAnchoredDraggableState$material3_release(AnchoredDraggableState<SheetValue> anchoredDraggableState) {
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public final Float getOffset$material3_release() {
        return Float.valueOf(this.anchoredDraggableState.getOffset());
    }

    /* compiled from: SheetDefaults.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/SheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Landroidx/compose/material3/SheetValue;", "skipPartiallyExpanded", "", "confirmValueChange", "Lkotlin/Function1;", "density", "Landroidx/compose/ui/unit/Density;", "skipHiddenState", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SheetState, SheetValue> Saver(final boolean z, final Function1<? super SheetValue, Boolean> function1, final Density density, final boolean z2) {
            return SaverKt.Saver(new Function2<SaverScope, SheetState, SheetValue>() { // from class: androidx.compose.material3.SheetState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final SheetValue invoke(SaverScope saverScope, SheetState sheetState) {
                    return sheetState.getCurrentValue();
                }
            }, new Function1<SheetValue, SheetState>() { // from class: androidx.compose.material3.SheetState$Companion$Saver$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final SheetState invoke(SheetValue sheetValue) {
                    return new SheetState(z, density, sheetValue, function1, z2);
                }
            });
        }
    }
}
