package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Animation.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004BE\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\fBE\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u000eJ\u0015\u0010.\u001a\u00028\u00002\u0006\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0002\u00100J\u0015\u00101\u001a\u00028\u00012\u0006\u0010/\u001a\u00020\u0010H\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u000204H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00018\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00028\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u000b\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0014\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010 R&\u0010\"\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0000@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R&\u0010'\u001a\u00028\u00002\u0006\u0010!\u001a\u00028\u0000@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010%R\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u0010\u0010+\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00065"}, d2 = {"Landroidx/compose/animation/core/TargetBasedAnimation;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocityVector", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "_durationNanos", "", "_endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getAnimationSpec$animation_core_release", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "durationNanos", "getDurationNanos", "()J", "endVelocity", "getEndVelocity", "()Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "initialValueVector", "isInfinite", "", "()Z", "value", "mutableInitialValue", "getMutableInitialValue$animation_core_release", "setMutableInitialValue$animation_core_release", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "mutableTargetValue", "getMutableTargetValue$animation_core_release", "setMutableTargetValue$animation_core_release", "getTargetValue", "targetValueVector", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 8;
    private long _durationNanos;
    private V _endVelocity;
    private final VectorizedAnimationSpec<V> animationSpec;
    private V initialValueVector;
    private final V initialVelocityVector;
    private T mutableInitialValue;
    private T mutableTargetValue;
    private V targetValueVector;
    private final TwoWayConverter<T, V> typeConverter;

    public TargetBasedAnimation(VectorizedAnimationSpec<V> vectorizedAnimationSpec, TwoWayConverter<T, V> twoWayConverter, T t, T t2, V v) {
        V v2;
        this.animationSpec = vectorizedAnimationSpec;
        this.typeConverter = twoWayConverter;
        this.mutableTargetValue = t2;
        this.mutableInitialValue = t;
        this.initialValueVector = getTypeConverter().getConvertToVector().invoke(t);
        this.targetValueVector = getTypeConverter().getConvertToVector().invoke(t2);
        this.initialVelocityVector = (v == null || (v2 = (V) AnimationVectorsKt.copy(v)) == null) ? (V) AnimationVectorsKt.newInstance(getTypeConverter().getConvertToVector().invoke(t)) : v2;
        this._durationNanos = -1L;
    }

    public /* synthetic */ TargetBasedAnimation(VectorizedAnimationSpec vectorizedAnimationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vectorizedAnimationSpec, twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    public final VectorizedAnimationSpec<V> getAnimationSpec$animation_core_release() {
        return this.animationSpec;
    }

    @Override // androidx.compose.animation.core.Animation
    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getMutableTargetValue$animation_core_release() {
        return this.mutableTargetValue;
    }

    public final void setMutableTargetValue$animation_core_release(T t) {
        if (Intrinsics.areEqual(this.mutableTargetValue, t)) {
            return;
        }
        this.mutableTargetValue = t;
        this.targetValueVector = getTypeConverter().getConvertToVector().invoke(t);
        this._endVelocity = null;
        this._durationNanos = -1L;
    }

    public final T getMutableInitialValue$animation_core_release() {
        return this.mutableInitialValue;
    }

    public final void setMutableInitialValue$animation_core_release(T t) {
        if (Intrinsics.areEqual(t, this.mutableInitialValue)) {
            return;
        }
        this.mutableInitialValue = t;
        this.initialValueVector = getTypeConverter().getConvertToVector().invoke(t);
        this._endVelocity = null;
        this._durationNanos = -1L;
    }

    public final T getInitialValue() {
        return this.mutableInitialValue;
    }

    @Override // androidx.compose.animation.core.Animation
    public T getTargetValue() {
        return this.mutableTargetValue;
    }

    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationSpec, twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    public TargetBasedAnimation(AnimationSpec<T> animationSpec, TwoWayConverter<T, V> twoWayConverter, T t, T t2, V v) {
        this(animationSpec.vectorize(twoWayConverter), twoWayConverter, t, t2, v);
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    @Override // androidx.compose.animation.core.Animation
    public T getValueFromNanos(long j) {
        if (!isFinishedFromNanos(j)) {
            V valueFromNanos = this.animationSpec.getValueFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
            int size$animation_core_release = valueFromNanos.getSize$animation_core_release();
            for (int i = 0; i < size$animation_core_release; i++) {
                if (Float.isNaN(valueFromNanos.get$animation_core_release(i))) {
                    PreconditionsKt.throwIllegalStateException("AnimationVector cannot contain a NaN. " + valueFromNanos + ". Animation: " + this + ", playTimeNanos: " + j);
                }
            }
            return getTypeConverter().getConvertFromVector().invoke(valueFromNanos);
        }
        return getTargetValue();
    }

    @Override // androidx.compose.animation.core.Animation
    public long getDurationNanos() {
        if (this._durationNanos < 0) {
            this._durationNanos = this.animationSpec.getDurationNanos(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        return this._durationNanos;
    }

    private final V getEndVelocity() {
        V v = this._endVelocity;
        if (v == null) {
            V endVelocity = this.animationSpec.getEndVelocity(this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
            this._endVelocity = endVelocity;
            return endVelocity;
        }
        return v;
    }

    @Override // androidx.compose.animation.core.Animation
    public V getVelocityVectorFromNanos(long j) {
        if (!isFinishedFromNanos(j)) {
            return this.animationSpec.getVelocityFromNanos(j, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        }
        return getEndVelocity();
    }

    public String toString() {
        return "TargetBasedAnimation: " + getInitialValue() + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms,animationSpec: " + this.animationSpec;
    }
}
