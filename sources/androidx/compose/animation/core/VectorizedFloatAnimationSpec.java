package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VectorizedAnimationSpec.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ-\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J%\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anims", "Landroidx/compose/animation/core/Animations;", "<init>", "(Landroidx/compose/animation/core/Animations;)V", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "endVelocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getDurationNanos", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final Animations anims;
    private V endVelocityVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatAnimationSpec(Animations animations) {
        this.anims = animations;
    }

    public VectorizedFloatAnimationSpec(final FloatAnimationSpec floatAnimationSpec) {
        this(new Animations() { // from class: androidx.compose.animation.core.VectorizedFloatAnimationSpec.1
            @Override // androidx.compose.animation.core.Animations
            public FloatAnimationSpec get(int i) {
                return FloatAnimationSpec.this;
            }
        });
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getValueFromNanos(long j, V v, V v2, V v3) {
        V v4;
        if (this.valueVector == null) {
            this.valueVector = (V) AnimationVectorsKt.newInstance(v);
        }
        V v5 = this.valueVector;
        if (v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v5 = null;
        }
        int size$animation_core = v5.getSize$animation_core();
        int i = 0;
        while (true) {
            v4 = this.valueVector;
            if (i >= size$animation_core) {
                break;
            }
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v4 = null;
            }
            v4.set$animation_core(i, this.anims.get(i).getValueFromNanos(j, v.get$animation_core(i), v2.get$animation_core(i), v3.get$animation_core(i)));
            i++;
        }
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
        return v4;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        V v4;
        if (this.velocityVector == null) {
            this.velocityVector = (V) AnimationVectorsKt.newInstance(v3);
        }
        V v5 = this.velocityVector;
        if (v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v5 = null;
        }
        int size$animation_core = v5.getSize$animation_core();
        int i = 0;
        while (true) {
            v4 = this.velocityVector;
            if (i >= size$animation_core) {
                break;
            }
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v4 = null;
            }
            v4.set$animation_core(i, this.anims.get(i).getVelocityFromNanos(j, v.get$animation_core(i), v2.get$animation_core(i), v3.get$animation_core(i)));
            i++;
        }
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            return null;
        }
        return v4;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public V getEndVelocity(V v, V v2, V v3) {
        V v4;
        if (this.endVelocityVector == null) {
            this.endVelocityVector = (V) AnimationVectorsKt.newInstance(v3);
        }
        V v5 = this.endVelocityVector;
        if (v5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            v5 = null;
        }
        int size$animation_core = v5.getSize$animation_core();
        int i = 0;
        while (true) {
            v4 = this.endVelocityVector;
            if (i >= size$animation_core) {
                break;
            }
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                v4 = null;
            }
            v4.set$animation_core(i, this.anims.get(i).getEndVelocity(v.get$animation_core(i), v2.get$animation_core(i), v3.get$animation_core(i)));
            i++;
        }
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            return null;
        }
        return v4;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(V v, V v2, V v3) {
        int size$animation_core = v.getSize$animation_core();
        long j = 0;
        for (int i = 0; i < size$animation_core; i++) {
            j = Math.max(j, this.anims.get(i).getDurationNanos(v.get$animation_core(i), v2.get$animation_core(i), v3.get$animation_core(i)));
        }
        return j;
    }
}
