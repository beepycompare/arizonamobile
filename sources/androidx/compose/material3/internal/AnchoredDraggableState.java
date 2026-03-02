package androidx.compose.material3.internal;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 i*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001iBy\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\u000b\u0012#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0004\b\u0011\u0010\u0012B\u0089\u0001\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\u000b\u0012#\b\u0002\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0004\b\u0011\u0010\u0015J\u0006\u00108\u001a\u00020\u0006J#\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\b\b\u0002\u0010N\u001a\u00028\u0000¢\u0006\u0002\u0010OJ\u0016\u0010P\u001a\u00020L2\u0006\u0010Q\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010RJ%\u0010S\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u00062\u0006\u0010#\u001a\u00028\u00002\u0006\u0010Q\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010TJ\u001d\u0010U\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u00062\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010VJ\\\u0010Y\u001a\u00020L2\b\b\u0002\u0010Z\u001a\u00020[2B\u0010\\\u001a>\b\u0001\u0012\u0004\u0012\u00020X\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0^\u0012\u0006\u0012\u0004\u0018\u00010\u00020]¢\u0006\u0002\b_H\u0086@¢\u0006\u0002\u0010`Jy\u0010Y\u001a\u00020L2\u0006\u0010*\u001a\u00028\u00002\b\b\u0002\u0010Z\u001a\u00020[2W\u0010\\\u001aS\b\u0001\u0012\u0004\u0012\u00020X\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(*\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0^\u0012\u0006\u0012\u0004\u0018\u00010\u00020a¢\u0006\u0002\b_H\u0086@¢\u0006\u0002\u0010bJ\u0015\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u0006H\u0000¢\u0006\u0002\beJ\u000e\u0010f\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u0006J\u0015\u0010g\u001a\u00020\u00102\u0006\u0010*\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010hR/\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R/\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R+\u0010#\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010*\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b+\u0010%R\u001b\u0010.\u001a\u00028\u00008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b/\u0010%R+\u00101\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0011\u00109\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020\u00068GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010-\u001a\u0004\b<\u00103R+\u0010>\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u00107\u001a\u0004\b?\u00103\"\u0004\b@\u00105R/\u0010B\u001a\u0004\u0018\u00018\u00002\b\u0010\"\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010)\u001a\u0004\bC\u0010%\"\u0004\bD\u0010'R7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bJ\u0010)\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u000e\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Landroidx/compose/material3/internal/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "anchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/material3/internal/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getPositionalThreshold$material3", "()Lkotlin/jvm/functions/Function1;", "getVelocityThreshold$material3", "()Lkotlin/jvm/functions/Function0;", "getAnimationSpec", "getConfirmValueChange$material3", "dragMutex", "Landroidx/compose/material3/internal/InternalMutatorMutex;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material3", "()Landroidx/compose/foundation/gestures/DraggableState;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "targetValue", "getTargetValue", "targetValue$delegate", "Landroidx/compose/runtime/State;", "closestValue", "getClosestValue$material3", "closestValue$delegate", TypedValues.CycleType.S_WAVE_OFFSET, "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "requireOffset", "isAnimationRunning", "()Z", "progress", "getProgress", "progress$delegate", "lastVelocity", "getLastVelocity", "setLastVelocity", "lastVelocity$delegate", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "getAnchors", "()Landroidx/compose/material3/internal/DraggableAnchors;", "setAnchors", "(Landroidx/compose/material3/internal/DraggableAnchors;)V", "anchors$delegate", "updateAnchors", "", "newAnchors", "newTarget", "(Landroidx/compose/material3/internal/DraggableAnchors;Ljava/lang/Object;)V", "settle", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "computeTargetWithoutThresholds", "(FLjava/lang/Object;)Ljava/lang/Object;", "anchoredDragScope", "Landroidx/compose/material3/internal/AnchoredDragScope;", "anchoredDrag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newOffsetForDelta", "delta", "newOffsetForDelta$material3", "dispatchRawDelta", "trySnapTo", "(Ljava/lang/Object;)Z", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final AnchoredDragScope anchoredDragScope;
    private final MutableState anchors$delegate;
    private final Function0<AnimationSpec<Float>> animationSpec;
    private final State closestValue$delegate;
    private final Function1<T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    private final InternalMutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final DraggableState draggableState;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    private final Function1<Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final State targetValue$delegate;
    private final Function0<Float> velocityThreshold;

    public static final boolean _init_$lambda$0(Object obj) {
        return true;
    }

    public static final boolean _init_$lambda$1(Object obj) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchoredDraggableState(T t, Function1<? super Float, Float> function1, Function0<Float> function0, Function0<? extends AnimationSpec<Float>> function02, Function1<? super T, Boolean> function12) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MapDraggableAnchors emptyDraggableAnchors;
        MutableState mutableStateOf$default3;
        this.positionalThreshold = function1;
        this.velocityThreshold = function0;
        this.animationSpec = function02;
        this.confirmValueChange = function12;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.currentValue$delegate = mutableStateOf$default;
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AnchoredDraggableState.targetValue_delegate$lambda$3(AnchoredDraggableState.this);
            }
        });
        this.closestValue$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AnchoredDraggableState.closestValue_delegate$lambda$5(AnchoredDraggableState.this);
            }
        });
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(AnchoredDraggableState.progress_delegate$lambda$7(AnchoredDraggableState.this));
            }
        });
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.dragTarget$delegate = mutableStateOf$default2;
        emptyDraggableAnchors = AnchoredDraggableKt.emptyDraggableAnchors();
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(emptyDraggableAnchors, null, 2, null);
        this.anchors$delegate = mutableStateOf$default3;
        this.anchoredDragScope = new AnchoredDragScope(this) { // from class: androidx.compose.material3.internal.AnchoredDraggableState$anchoredDragScope$1
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            @Override // androidx.compose.material3.internal.AnchoredDragScope
            public void dragTo(float f, float f2) {
                this.this$0.setOffset(f);
                this.this$0.setLastVelocity(f2);
            }
        };
    }

    public final Function1<Float, Float> getPositionalThreshold$material3() {
        return this.positionalThreshold;
    }

    public final Function0<Float> getVelocityThreshold$material3() {
        return this.velocityThreshold;
    }

    public final Function0<AnimationSpec<Float>> getAnimationSpec() {
        return this.animationSpec;
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, Function1 function1, Function0 function0, Function0 function02, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, function1, function0, function02, (i & 16) != 0 ? new Function1() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(AnchoredDraggableState._init_$lambda$0(obj2));
            }
        } : function12);
    }

    public final Function1<T, Boolean> getConfirmValueChange$material3() {
        return this.confirmValueChange;
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, Function1 function1, Function0 function0, Function0 function02, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, draggableAnchors, function1, function0, function02, (i & 32) != 0 ? new Function1() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(AnchoredDraggableState._init_$lambda$1(obj2));
            }
        } : function12);
    }

    public AnchoredDraggableState(T t, DraggableAnchors<T> draggableAnchors, Function1<? super Float, Float> function1, Function0<Float> function0, Function0<? extends AnimationSpec<Float>> function02, Function1<? super T, Boolean> function12) {
        this(t, function1, function0, function02, function12);
        setAnchors(draggableAnchors);
        trySnapTo(t);
    }

    public final DraggableState getDraggableState$material3() {
        return this.draggableState;
    }

    private final void setCurrentValue(T t) {
        this.currentValue$delegate.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object targetValue_delegate$lambda$3(AnchoredDraggableState anchoredDraggableState) {
        Object dragTarget = anchoredDraggableState.getDragTarget();
        if (dragTarget == null) {
            float offset = anchoredDraggableState.getOffset();
            if (!Float.isNaN(offset)) {
                return anchoredDraggableState.computeTarget(offset, anchoredDraggableState.getCurrentValue(), 0.0f);
            }
            return anchoredDraggableState.getCurrentValue();
        }
        return dragTarget;
    }

    public final T getClosestValue$material3() {
        return (T) this.closestValue$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object closestValue_delegate$lambda$5(AnchoredDraggableState anchoredDraggableState) {
        Object dragTarget = anchoredDraggableState.getDragTarget();
        if (dragTarget == null) {
            float offset = anchoredDraggableState.getOffset();
            if (!Float.isNaN(offset)) {
                return anchoredDraggableState.computeTargetWithoutThresholds(offset, anchoredDraggableState.getCurrentValue());
            }
            return anchoredDraggableState.getCurrentValue();
        }
        return dragTarget;
    }

    public final void setOffset(float f) {
        this.offset$delegate.setFloatValue(f);
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?".toString());
        }
        return getOffset();
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public static final float progress_delegate$lambda$7(AnchoredDraggableState anchoredDraggableState) {
        float positionOf = anchoredDraggableState.getAnchors().positionOf((T) anchoredDraggableState.getCurrentValue());
        float positionOf2 = anchoredDraggableState.getAnchors().positionOf((T) anchoredDraggableState.getClosestValue$material3()) - positionOf;
        float abs = Math.abs(positionOf2);
        if (Float.isNaN(abs) || abs <= 1.0E-6f) {
            return 1.0f;
        }
        float requireOffset = (anchoredDraggableState.requireOffset() - positionOf) / positionOf2;
        if (requireOffset < 1.0E-6f) {
            return 0.0f;
        }
        if (requireOffset > 0.999999f) {
            return 1.0f;
        }
        return requireOffset;
    }

    public final void setLastVelocity(float f) {
        this.lastVelocity$delegate.setFloatValue(f);
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    private final T getDragTarget() {
        return this.dragTarget$delegate.getValue();
    }

    public final void setDragTarget(T t) {
        this.dragTarget$delegate.setValue(t);
    }

    private final void setAnchors(DraggableAnchors<T> draggableAnchors) {
        this.anchors$delegate.setValue(draggableAnchors);
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            if (!Float.isNaN(anchoredDraggableState.getOffset())) {
                obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset());
                if (obj == null) {
                    obj = anchoredDraggableState.getTargetValue();
                }
            } else {
                obj = anchoredDraggableState.getTargetValue();
            }
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    public final void updateAnchors(DraggableAnchors<T> draggableAnchors, T t) {
        if (Intrinsics.areEqual(getAnchors(), draggableAnchors)) {
            return;
        }
        setAnchors(draggableAnchors);
        if (trySnapTo(t)) {
            return;
        }
        setDragTarget(t);
    }

    public final Object settle(float f, Continuation<? super Unit> continuation) {
        T currentValue = getCurrentValue();
        T computeTarget = computeTarget(requireOffset(), currentValue, f);
        if (this.confirmValueChange.invoke(computeTarget).booleanValue()) {
            Object animateTo = AnchoredDraggableKt.animateTo(this, computeTarget, f, continuation);
            return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
        }
        Object animateTo2 = AnchoredDraggableKt.animateTo(this, currentValue, f, continuation);
        return animateTo2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo2 : Unit.INSTANCE;
    }

    private final T computeTarget(float f, T t, float f2) {
        DraggableAnchors<T> anchors = getAnchors();
        float positionOf = anchors.positionOf(t);
        float floatValue = this.velocityThreshold.invoke().floatValue();
        int i = (positionOf > f ? 1 : (positionOf == f ? 0 : -1));
        if (i != 0 && !Float.isNaN(positionOf)) {
            if (i < 0) {
                if (f2 >= floatValue) {
                    T closestAnchor = anchors.closestAnchor(f, true);
                    Intrinsics.checkNotNull(closestAnchor);
                    return closestAnchor;
                }
                T closestAnchor2 = anchors.closestAnchor(f, true);
                Intrinsics.checkNotNull(closestAnchor2);
                if (f >= Math.abs(positionOf + Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(anchors.positionOf(closestAnchor2) - positionOf))).floatValue()))) {
                    return closestAnchor2;
                }
            } else if (f2 <= (-floatValue)) {
                T closestAnchor3 = anchors.closestAnchor(f, false);
                Intrinsics.checkNotNull(closestAnchor3);
                return closestAnchor3;
            } else {
                T closestAnchor4 = anchors.closestAnchor(f, false);
                Intrinsics.checkNotNull(closestAnchor4);
                float abs = Math.abs(positionOf - Math.abs(this.positionalThreshold.invoke(Float.valueOf(Math.abs(positionOf - anchors.positionOf(closestAnchor4)))).floatValue()));
                if (f >= 0.0f ? f <= abs : Math.abs(f) >= abs) {
                    return closestAnchor4;
                }
            }
        }
        return t;
    }

    private final T computeTargetWithoutThresholds(float f, T t) {
        DraggableAnchors<T> anchors = getAnchors();
        float positionOf = anchors.positionOf(t);
        int i = (positionOf > f ? 1 : (positionOf == f ? 0 : -1));
        if (i != 0 && !Float.isNaN(positionOf)) {
            if (i < 0) {
                T closestAnchor = anchors.closestAnchor(f, true);
                if (closestAnchor != null) {
                    return closestAnchor;
                }
            } else {
                T closestAnchor2 = anchors.closestAnchor(f, false);
                if (closestAnchor2 != null) {
                    return closestAnchor2;
                }
            }
        }
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object anchoredDrag(MutatePriority mutatePriority, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        AnchoredDraggableState$anchoredDrag$1 anchoredDraggableState$anchoredDrag$1;
        int i;
        T closestAnchor;
        try {
            if (continuation instanceof AnchoredDraggableState$anchoredDrag$1) {
                anchoredDraggableState$anchoredDrag$1 = (AnchoredDraggableState$anchoredDrag$1) continuation;
                if ((anchoredDraggableState$anchoredDrag$1.label & Integer.MIN_VALUE) != 0) {
                    anchoredDraggableState$anchoredDrag$1.label -= Integer.MIN_VALUE;
                    Object obj = anchoredDraggableState$anchoredDrag$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anchoredDraggableState$anchoredDrag$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        anchoredDraggableState$anchoredDrag$1.label = 1;
                        if (this.dragMutex.mutate(mutatePriority, new AnchoredDraggableState$anchoredDrag$2(this, function3, null), anchoredDraggableState$anchoredDrag$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (closestAnchor != null && Math.abs(getOffset() - getAnchors().positionOf(closestAnchor)) <= 0.5f && this.confirmValueChange.invoke(closestAnchor).booleanValue()) {
                        setCurrentValue(closestAnchor);
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            if (closestAnchor != null) {
                setCurrentValue(closestAnchor);
            }
            return Unit.INSTANCE;
        } finally {
            closestAnchor = getAnchors().closestAnchor(getOffset());
            if (closestAnchor != null && Math.abs(getOffset() - getAnchors().positionOf(closestAnchor)) <= 0.5f && this.confirmValueChange.invoke(closestAnchor).booleanValue()) {
                setCurrentValue(closestAnchor);
            }
        }
        anchoredDraggableState$anchoredDrag$1 = new AnchoredDraggableState$anchoredDrag$1(this, continuation);
        Object obj2 = anchoredDraggableState$anchoredDrag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anchoredDraggableState$anchoredDrag$1.label;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, Function3 function3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, function3, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object anchoredDrag(T t, MutatePriority mutatePriority, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function4, Continuation<? super Unit> continuation) {
        AnchoredDraggableState$anchoredDrag$3 anchoredDraggableState$anchoredDrag$3;
        int i;
        T closestAnchor;
        try {
            if (continuation instanceof AnchoredDraggableState$anchoredDrag$3) {
                anchoredDraggableState$anchoredDrag$3 = (AnchoredDraggableState$anchoredDrag$3) continuation;
                if ((anchoredDraggableState$anchoredDrag$3.label & Integer.MIN_VALUE) != 0) {
                    anchoredDraggableState$anchoredDrag$3.label -= Integer.MIN_VALUE;
                    Object obj = anchoredDraggableState$anchoredDrag$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anchoredDraggableState$anchoredDrag$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (getAnchors().hasAnchorFor(t)) {
                            anchoredDraggableState$anchoredDrag$3.label = 1;
                            if (this.dragMutex.mutate(mutatePriority, new AnchoredDraggableState$anchoredDrag$4(this, t, function4, null), anchoredDraggableState$anchoredDrag$3) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            setCurrentValue(t);
                            return Unit.INSTANCE;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    if (closestAnchor != null && Math.abs(getOffset() - getAnchors().positionOf(closestAnchor)) <= 0.5f && this.confirmValueChange.invoke(closestAnchor).booleanValue()) {
                        setCurrentValue(closestAnchor);
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            if (closestAnchor != null) {
                setCurrentValue(closestAnchor);
            }
            return Unit.INSTANCE;
        } finally {
            setDragTarget(null);
            closestAnchor = getAnchors().closestAnchor(getOffset());
            if (closestAnchor != null && Math.abs(getOffset() - getAnchors().positionOf(closestAnchor)) <= 0.5f && this.confirmValueChange.invoke(closestAnchor).booleanValue()) {
                setCurrentValue(closestAnchor);
            }
        }
        anchoredDraggableState$anchoredDrag$3 = new AnchoredDraggableState$anchoredDrag$3(this, continuation);
        Object obj2 = anchoredDraggableState$anchoredDrag$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anchoredDraggableState$anchoredDrag$3.label;
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, Function4 function4, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, function4, continuation);
    }

    public final float newOffsetForDelta$material3(float f) {
        return RangesKt.coerceIn((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + f, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    public final float dispatchRawDelta(float f) {
        float newOffsetForDelta$material3 = newOffsetForDelta$material3(f);
        float offset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(newOffsetForDelta$material3);
        return newOffsetForDelta$material3 - offset;
    }

    private final boolean trySnapTo(final T t) {
        return this.dragMutex.tryMutate(new Function0() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AnchoredDraggableState.trySnapTo$lambda$9(AnchoredDraggableState.this, t);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit trySnapTo$lambda$9(AnchoredDraggableState anchoredDraggableState, Object obj) {
        AnchoredDragScope anchoredDragScope = anchoredDraggableState.anchoredDragScope;
        float positionOf = anchoredDraggableState.getAnchors().positionOf(obj);
        if (!Float.isNaN(positionOf)) {
            AnchoredDragScope.dragTo$default(anchoredDragScope, positionOf, 0.0f, 2, null);
            anchoredDraggableState.setDragTarget(null);
        }
        anchoredDraggableState.setCurrentValue(obj);
        return Unit.INSTANCE;
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J{\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u000e0\r2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\t¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/internal/AnchoredDraggableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/internal/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "animationSpec", "Lkotlin/Function0;", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final Function0<? extends AnimationSpec<Float>> function0, final Function1<? super T, Boolean> function1, final Function1<? super Float, Float> function12, final Function0<Float> function02) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Object currentValue;
                    SaverScope saverScope = (SaverScope) obj;
                    currentValue = ((AnchoredDraggableState) obj2).getCurrentValue();
                    return currentValue;
                }
            }, new Function1() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AnchoredDraggableState.Companion.Saver$lambda$1(Function1.this, function02, function0, function1, obj);
                }
            });
        }

        public static final AnchoredDraggableState Saver$lambda$1(Function1 function1, Function0 function0, Function0 function02, Function1 function12, Object obj) {
            return new AnchoredDraggableState(obj, function1, function0, function02, function12);
        }
    }
}
