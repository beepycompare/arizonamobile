package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DecayAnimationSpec.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J%\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001d\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatDecaySpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "<init>", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "getFloatDecaySpec", "()Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "targetVector", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "getValueFromNanos", "playTimeNanos", "", "initialValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getVelocityFromNanos", "getTargetValue", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class VectorizedFloatDecaySpec<V extends AnimationVector> implements VectorizedDecayAnimationSpec<V> {
    private final float absVelocityThreshold;
    private final FloatDecayAnimationSpec floatDecaySpec;
    private V targetVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        this.floatDecaySpec = floatDecayAnimationSpec;
        this.absVelocityThreshold = floatDecayAnimationSpec.getAbsVelocityThreshold();
    }

    public final FloatDecayAnimationSpec getFloatDecaySpec() {
        return this.floatDecaySpec;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getValueFromNanos(long j, V v, V v2) {
        V v3;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v4 = this.valueVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v4 = null;
        }
        int size$animation_core = v4.getSize$animation_core();
        int i = 0;
        while (true) {
            v3 = this.valueVector;
            if (i >= size$animation_core) {
                break;
            }
            if (v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v3 = null;
            }
            v3.set$animation_core(i, this.floatDecaySpec.getValueFromNanos(j, v.get$animation_core(i), v2.get$animation_core(i)));
            i++;
        }
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        return v3;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public long getDurationNanos(V v, V v2) {
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.velocityVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v3 = null;
        }
        int size$animation_core = v3.getSize$animation_core();
        long j = 0;
        for (int i = 0; i < size$animation_core; i++) {
            j = Math.max(j, this.floatDecaySpec.getDurationNanos(v.get$animation_core(i), v2.get$animation_core(i)));
        }
        return j;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getVelocityFromNanos(long j, V v, V v2) {
        V v3;
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v4 = this.velocityVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v4 = null;
        }
        int size$animation_core = v4.getSize$animation_core();
        int i = 0;
        while (true) {
            v3 = this.velocityVector;
            if (i >= size$animation_core) {
                break;
            }
            if (v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v3 = null;
            }
            v3.set$animation_core(i, this.floatDecaySpec.getVelocityFromNanos(j, v.get$animation_core(i), v2.get$animation_core(i)));
            i++;
        }
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        return v3;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public V getTargetValue(V v, V v2) {
        V v3;
        if (this.targetVector == null) {
            this.targetVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v4 = this.targetVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            v4 = null;
        }
        int size$animation_core = v4.getSize$animation_core();
        int i = 0;
        while (true) {
            v3 = this.targetVector;
            if (i >= size$animation_core) {
                break;
            }
            if (v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                v3 = null;
            }
            v3.set$animation_core(i, this.floatDecaySpec.getTargetValue(v.get$animation_core(i), v2.get$animation_core(i)));
            i++;
        }
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            return null;
        }
        return v3;
    }
}
