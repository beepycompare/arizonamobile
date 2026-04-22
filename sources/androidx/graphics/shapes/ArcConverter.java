package androidx.graphics.shapes;

import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SvgPathParser.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/graphics/shapes/ArcConverter;", "", "<init>", "()V", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class ArcConverter {
    public static final Companion Companion = new Companion(null);

    /* compiled from: SvgPathParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010JV\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"Landroidx/graphics/shapes/ArcConverter$Companion;", "", "<init>", "()V", "arcToCubics", "", "Landroidx/graphics/shapes/Cubic;", "x0", "", "y0", "x1", "y1", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcToBezier", "cx", "cy", "rx", "ry", "e1x", "e1y", TtmlNode.START, "sweep", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Cubic> arcToCubics(float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double d3 = (f7 / 180.0d) * 3.141592653589793d;
            double cos = Math.cos(d3);
            double sin = Math.sin(d3);
            double d4 = f2;
            double d5 = f5;
            double d6 = ((f * cos) + (d4 * sin)) / d5;
            double d7 = ((-f) * sin) + (d4 * cos);
            double d8 = f6;
            double d9 = d7 / d8;
            double d10 = f4;
            double d11 = ((f3 * cos) + (d10 * sin)) / d5;
            double d12 = (((-f3) * sin) + (d10 * cos)) / d8;
            double d13 = d6 - d11;
            double d14 = d9 - d12;
            double d15 = (d6 + d11) / 2.0d;
            double d16 = (d9 + d12) / 2.0d;
            double d17 = (d13 * d13) + (d14 * d14);
            if (d17 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return CollectionsKt.emptyList();
            }
            double d18 = (1.0d / d17) - 0.25d;
            if (d18 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                float sqrt = (float) (Math.sqrt(d17) / 1.99999d);
                return arcToCubics(f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
            }
            double sqrt2 = Math.sqrt(d18);
            double d19 = d13 * sqrt2;
            double d20 = sqrt2 * d14;
            if (z == z2) {
                d = d15 - d20;
                d2 = d16 + d19;
            } else {
                d = d15 + d20;
                d2 = d16 - d19;
            }
            double atan2 = Math.atan2(d9 - d2, d6 - d);
            double atan22 = Math.atan2(d12 - d2, d11 - d) - atan2;
            int i = (atan22 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (atan22 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
            if (z2 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d21 = d * d5;
            double d22 = d2 * d8;
            return arcToBezier((float) ((d21 * cos) - (d22 * sin)), (float) ((d21 * sin) + (d22 * cos)), f5, f6, f, f2, (float) d3, (float) atan2, (float) atan22);
        }

        private final List<Cubic> arcToBezier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            float f10;
            ArrayList arrayList = new ArrayList();
            float f11 = 4.0f;
            int ceil = (int) Math.ceil(Math.abs((f9 * 4.0f) / 3.141592653589793d));
            double d = f7;
            float cos = (float) Math.cos(d);
            float sin = (float) Math.sin(d);
            float f12 = f8;
            double d2 = f12;
            float cos2 = (float) Math.cos(d2);
            float sin2 = (float) Math.sin(d2);
            float f13 = -f3;
            float f14 = f13 * cos;
            float f15 = f4 * sin;
            float f16 = (f14 * sin2) - (f15 * cos2);
            float f17 = f13 * sin;
            float f18 = f4 * cos;
            float f19 = (sin2 * f17) + (cos2 * f18);
            float f20 = f9 / ceil;
            int i = 0;
            float f21 = f5;
            float f22 = f6;
            while (i < ceil) {
                float f23 = f11;
                float f24 = f12 + f20;
                int i2 = ceil;
                float f25 = sin;
                double d3 = f24;
                float sin3 = (float) Math.sin(d3);
                float cos3 = (float) Math.cos(d3);
                float f26 = (f + ((f3 * cos) * cos3)) - (f15 * sin3);
                float f27 = f2 + (f3 * f25 * cos3) + (f18 * sin3);
                float f28 = (f14 * sin3) - (f15 * cos3);
                float f29 = (sin3 * f17) + (cos3 * f18);
                float tan = (float) Math.tan(f10 / 2.0f);
                float sin4 = (((float) Math.sin(f24 - f12)) * (((float) Math.sqrt(f23 + ((3.0f * tan) * tan))) - 1.0f)) / 3.0f;
                arrayList.add(CubicKt.Cubic(f21, f22, f21 + (f16 * sin4), f22 + (f19 * sin4), f26 - (sin4 * f28), f27 - (sin4 * f29), f26, f27));
                i++;
                f11 = f23;
                f12 = f24;
                f16 = f28;
                f19 = f29;
                sin = f25;
                f21 = f26;
                f22 = f27;
                ceil = i2;
            }
            return arrayList;
        }
    }
}
