package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PolygonMeasure.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/graphics/shapes/LengthMeasurer;", "Landroidx/graphics/shapes/Measurer;", "<init>", "()V", "segments", "", "measureCubic", "", "c", "Landroidx/graphics/shapes/Cubic;", "findCubicCutPoint", CmcdData.OBJECT_TYPE_MANIFEST, "closestProgressTo", "Landroidx/collection/FloatFloatPair;", "cubic", "threshold", "closestProgressTo-XgqJiTY", "(Landroidx/graphics/shapes/Cubic;F)J", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LengthMeasurer implements Measurer {
    private final int segments = 3;

    @Override // androidx.graphics.shapes.Measurer
    public float measureCubic(Cubic c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return Float.intBitsToFloat((int) (m8753closestProgressToXgqJiTY(c, Float.POSITIVE_INFINITY) & 4294967295L));
    }

    @Override // androidx.graphics.shapes.Measurer
    public float findCubicCutPoint(Cubic c, float f) {
        Intrinsics.checkNotNullParameter(c, "c");
        return Float.intBitsToFloat((int) (m8753closestProgressToXgqJiTY(c, f) >> 32));
    }

    /* renamed from: closestProgressTo-XgqJiTY  reason: not valid java name */
    private final long m8753closestProgressToXgqJiTY(Cubic cubic, float f) {
        long m12constructorimpl = FloatFloatPair.m12constructorimpl(cubic.getAnchor0X(), cubic.getAnchor0Y());
        int i = this.segments;
        float f2 = 0.0f;
        int i2 = 1;
        if (1 <= i) {
            float f3 = f;
            while (true) {
                float f4 = i2 / this.segments;
                long m8752pointOnCurveOOQOV4g$graphics_shapes = cubic.m8752pointOnCurveOOQOV4g$graphics_shapes(f4);
                float m8761getDistanceDnnuFBc = PointKt.m8761getDistanceDnnuFBc(PointKt.m8766minusybeJwSQ(m8752pointOnCurveOOQOV4g$graphics_shapes, m12constructorimpl));
                if (m8761getDistanceDnnuFBc < f3) {
                    f3 -= m8761getDistanceDnnuFBc;
                    f2 += m8761getDistanceDnnuFBc;
                    if (i2 == i) {
                        break;
                    }
                    i2++;
                    m12constructorimpl = m8752pointOnCurveOOQOV4g$graphics_shapes;
                } else {
                    return FloatFloatPair.m12constructorimpl(f4 - ((1.0f - (f3 / m8761getDistanceDnnuFBc)) / this.segments), f);
                }
            }
        }
        return FloatFloatPair.m12constructorimpl(1.0f, f2);
    }
}
