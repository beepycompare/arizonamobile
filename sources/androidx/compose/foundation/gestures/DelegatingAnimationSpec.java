package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
/* compiled from: TransformableState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0000\u0010\u000b*\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/DelegatingAnimationSpec;", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/foundation/gestures/AnimationData;", "zoomAnimationSpec", "", "offsetAnimationSpec", "Landroidx/compose/ui/geometry/Offset;", "rotationAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class DelegatingAnimationSpec implements AnimationSpec<AnimationData> {
    private final AnimationSpec<Offset> offsetAnimationSpec;
    private final AnimationSpec<Float> rotationAnimationSpec;
    private final AnimationSpec<Float> zoomAnimationSpec;

    public DelegatingAnimationSpec(AnimationSpec<Float> animationSpec, AnimationSpec<Offset> animationSpec2, AnimationSpec<Float> animationSpec3) {
        this.zoomAnimationSpec = animationSpec;
        this.offsetAnimationSpec = animationSpec2;
        this.rotationAnimationSpec = animationSpec3;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public <V extends AnimationVector> VectorizedAnimationSpec<V> vectorize(final TwoWayConverter<AnimationData, V> twoWayConverter) {
        final VectorizedAnimationSpec<V> vectorize = this.zoomAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
        final VectorizedAnimationSpec<V> vectorize2 = this.offsetAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(Offset.Companion));
        final VectorizedAnimationSpec<V> vectorize3 = this.rotationAnimationSpec.vectorize(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
        return new VectorizedFiniteAnimationSpec<V>() { // from class: androidx.compose.foundation.gestures.DelegatingAnimationSpec$vectorize$1
            /* JADX WARN: Incorrect types in method signature: (TV;TV;TV;)J */
            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
                AnimationData invoke = twoWayConverter.getConvertFromVector().invoke(animationVector);
                AnimationData invoke2 = twoWayConverter.getConvertFromVector().invoke(animationVector2);
                AnimationData invoke3 = twoWayConverter.getConvertFromVector().invoke(animationVector3);
                return Math.max(vectorize.getDurationNanos(zoomVector(invoke), zoomVector(invoke2), zoomVector(invoke3)), Math.max(vectorize2.getDurationNanos(offsetVector(invoke), offsetVector(invoke2), offsetVector(invoke3)), vectorize3.getDurationNanos(degreesVector(invoke), degreesVector(invoke2), degreesVector(invoke3))));
            }

            /* JADX WARN: Incorrect return type in method signature: (JTV;TV;TV;)TV; */
            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
                AnimationData invoke = twoWayConverter.getConvertFromVector().invoke(animationVector);
                AnimationData invoke2 = twoWayConverter.getConvertFromVector().invoke(animationVector2);
                AnimationData invoke3 = twoWayConverter.getConvertFromVector().invoke(animationVector3);
                return packToAnimationVector(vectorize.getVelocityFromNanos(j, zoomVector(invoke), zoomVector(invoke2), zoomVector(invoke3)), vectorize2.getVelocityFromNanos(j, offsetVector(invoke), offsetVector(invoke2), offsetVector(invoke3)), vectorize3.getVelocityFromNanos(j, degreesVector(invoke), degreesVector(invoke2), degreesVector(invoke3)));
            }

            /* JADX WARN: Incorrect return type in method signature: (JTV;TV;TV;)TV; */
            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
                AnimationData invoke = twoWayConverter.getConvertFromVector().invoke(animationVector);
                AnimationData invoke2 = twoWayConverter.getConvertFromVector().invoke(animationVector2);
                AnimationData invoke3 = twoWayConverter.getConvertFromVector().invoke(animationVector3);
                return packToAnimationVector(vectorize.getValueFromNanos(j, zoomVector(invoke), zoomVector(invoke2), zoomVector(invoke3)), vectorize2.getValueFromNanos(j, offsetVector(invoke), offsetVector(invoke2), offsetVector(invoke3)), vectorize3.getValueFromNanos(j, degreesVector(invoke), degreesVector(invoke2), degreesVector(invoke3)));
            }

            private final AnimationVector1D zoomVector(AnimationData animationData) {
                return VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE).getConvertToVector().invoke(Float.valueOf(animationData.getZoom()));
            }

            private final AnimationVector2D offsetVector(AnimationData animationData) {
                return VectorConvertersKt.getVectorConverter(Offset.Companion).getConvertToVector().invoke(Offset.m3826boximpl(Offset.m3829constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (animationData.m415getOffsetF1C5BW0() >> 32))) << 32) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (animationData.m415getOffsetF1C5BW0() & 4294967295L))) & 4294967295L))));
            }

            private final AnimationVector1D degreesVector(AnimationData animationData) {
                return VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE).getConvertToVector().invoke(Float.valueOf(animationData.getDegrees()));
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/animation/core/AnimationVector1D;Landroidx/compose/animation/core/AnimationVector2D;Landroidx/compose/animation/core/AnimationVector1D;)TV; */
            private final AnimationVector packToAnimationVector(AnimationVector1D animationVector1D, AnimationVector2D animationVector2D, AnimationVector1D animationVector1D2) {
                Function1<AnimationData, V> convertToVector = twoWayConverter.getConvertToVector();
                float value = animationVector1D.getValue();
                float v1 = animationVector2D.getV1();
                float v2 = animationVector2D.getV2();
                return (AnimationVector) convertToVector.invoke(new AnimationData(value, Offset.m3829constructorimpl((Float.floatToRawIntBits(v2) & 4294967295L) | (Float.floatToRawIntBits(v1) << 32)), animationVector1D2.getValue(), null));
            }
        };
    }
}
