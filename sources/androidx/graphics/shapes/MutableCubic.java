package androidx.graphics.shapes;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Cubic.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Landroidx/graphics/shapes/MutableCubic;", "Landroidx/graphics/shapes/Cubic;", "()V", "interpolate", "", "c1", "c2", "progress", "", "transform", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformOnePoint", "ix", "", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    private final void transformOnePoint(PointTransformer pointTransformer, int i) {
        int i2 = i + 1;
        long mo7253transformXgqJiTY = pointTransformer.mo7253transformXgqJiTY(getPoints$graphics_shapes_release()[i], getPoints$graphics_shapes_release()[i2]);
        getPoints$graphics_shapes_release()[i] = Float.intBitsToFloat((int) (mo7253transformXgqJiTY >> 32));
        getPoints$graphics_shapes_release()[i2] = Float.intBitsToFloat((int) (mo7253transformXgqJiTY & 4294967295L));
    }

    public final void transform(PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        transformOnePoint(f, 0);
        transformOnePoint(f, 2);
        transformOnePoint(f, 4);
        transformOnePoint(f, 6);
    }

    public final void interpolate(Cubic c1, Cubic c2, float f) {
        Intrinsics.checkNotNullParameter(c1, "c1");
        Intrinsics.checkNotNullParameter(c2, "c2");
        for (int i = 0; i < 8; i++) {
            getPoints$graphics_shapes_release()[i] = Utils.interpolate(c1.getPoints$graphics_shapes_release()[i], c2.getPoints$graphics_shapes_release()[i], f);
        }
    }
}
