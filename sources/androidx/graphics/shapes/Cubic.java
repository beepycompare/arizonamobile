package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Cubic.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B7\b\u0010\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\bB\u0011\b\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ!\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0086\u0002J\u0013\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020(H\u0016J\u0011\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0086\u0002J!\u0010.\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010/\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u0006\u00102\u001a\u00020\u0000J\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000042\u0006\u0010/\u001a\u00020\rJ\u0011\u00105\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002J\u0011\u00105\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0086\u0002J\b\u00106\u001a\u000207H\u0016J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\rH\u0002J\r\u0010=\u001a\u00020$H\u0000¢\u0006\u0002\b>R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u001c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/graphics/shapes/Cubic;", "", "anchor0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "control0", "control1", "anchor1", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "points", "", "([F)V", "anchor0X", "", "getAnchor0X", "()F", "anchor0Y", "getAnchor0Y", "anchor1X", "getAnchor1X", "anchor1Y", "getAnchor1Y", "control0X", "getControl0X", "control0Y", "getControl0Y", "control1X", "getControl1X", "control1Y", "getControl1Y", "getPoints$graphics_shapes_release", "()[F", "calculateBounds", "", "bounds", "approximate", "", "calculateBounds$graphics_shapes_release", TtmlNode.TAG_DIV, "x", "", "equals", "other", "hashCode", "plus", "o", "pointOnCurve", "t", "pointOnCurve-OOQOV4g$graphics_shapes_release", "(F)J", "reverse", "split", "Lkotlin/Pair;", "times", "toString", "", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "zeroIsh", "value", "zeroLength", "zeroLength$graphics_shapes_release", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class Cubic {
    public static final Companion Companion = new Companion(null);
    private final float[] points;

    public Cubic() {
        this(null, 1, null);
    }

    public /* synthetic */ Cubic(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    @JvmStatic
    public static final Cubic circularArc(float f, float f2, float f3, float f4, float f5, float f6) {
        return Companion.circularArc(f, f2, f3, f4, f5, f6);
    }

    @JvmStatic
    public static final Cubic straightLine(float f, float f2, float f3, float f4) {
        return Companion.straightLine(f, f2, f3, f4);
    }

    public Cubic(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8".toString());
        }
    }

    public /* synthetic */ Cubic(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new float[8] : fArr);
    }

    public final float[] getPoints$graphics_shapes_release() {
        return this.points;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    private Cubic(long j, long j2, long j3, long j4) {
        this(new float[]{PointKt.m7244getXDnnuFBc(j), PointKt.m7245getYDnnuFBc(j), PointKt.m7244getXDnnuFBc(j2), PointKt.m7245getYDnnuFBc(j2), PointKt.m7244getXDnnuFBc(j3), PointKt.m7245getYDnnuFBc(j3), PointKt.m7244getXDnnuFBc(j4), PointKt.m7245getYDnnuFBc(j4)});
    }

    /* renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release  reason: not valid java name */
    public final long m7232pointOnCurveOOQOV4g$graphics_shapes_release(float f) {
        float f2 = 1 - f;
        float f3 = f2 * f2 * f2;
        float f4 = 3 * f;
        float f5 = f4 * f2 * f2;
        float f6 = f4 * f * f2;
        float f7 = f * f * f;
        return FloatFloatPair.m14constructorimpl((getAnchor0X() * f3) + (getControl0X() * f5) + (getControl1X() * f6) + (getAnchor1X() * f7), (getAnchor0Y() * f3) + (getControl0Y() * f5) + (getControl1Y() * f6) + (getAnchor1Y() * f7));
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }

    private final boolean zeroIsh(float f) {
        return Math.abs(f) < 1.0E-4f;
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
        }
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01c7, code lost:
        if (r3 > r9) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01c9, code lost:
        r9 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0218, code lost:
        if (r3 > r9) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void calculateBounds$graphics_shapes_release(float[] bounds, boolean z) {
        char c;
        char c2;
        char c3;
        float f;
        float control0Y;
        float m7245getYDnnuFBc;
        float f2;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (zeroLength$graphics_shapes_release()) {
            bounds[0] = getAnchor0X();
            bounds[1] = getAnchor0Y();
            bounds[2] = getAnchor0X();
            bounds[3] = getAnchor0Y();
            return;
        }
        float min = Math.min(getAnchor0X(), getAnchor1X());
        float min2 = Math.min(getAnchor0Y(), getAnchor1Y());
        float max = Math.max(getAnchor0X(), getAnchor1X());
        float max2 = Math.max(getAnchor0Y(), getAnchor1Y());
        if (z) {
            bounds[0] = Math.min(min, Math.min(getControl0X(), getControl1X()));
            bounds[1] = Math.min(min2, Math.min(getControl0Y(), getControl1Y()));
            bounds[2] = Math.max(max, Math.max(getControl0X(), getControl1X()));
            bounds[3] = Math.max(max2, Math.max(getControl0Y(), getControl1Y()));
            return;
        }
        float f3 = 3;
        float control0X = (((-getAnchor0X()) + (getControl0X() * f3)) - (getControl1X() * f3)) + getAnchor1X();
        float f4 = 2;
        float f5 = 4;
        float anchor0X = ((getAnchor0X() * f4) - (getControl0X() * f5)) + (getControl1X() * f4);
        float control0X2 = (-getAnchor0X()) + getControl0X();
        if (!zeroIsh(control0X)) {
            float f6 = (anchor0X * anchor0X) - ((f5 * control0X) * control0X2);
            if (f6 >= 0.0f) {
                float f7 = -anchor0X;
                c = 0;
                c2 = 3;
                double d = f6;
                c3 = 2;
                f = min2;
                float f8 = control0X * f4;
                float sqrt = (((float) Math.sqrt(d)) + f7) / f8;
                if (0.0f <= sqrt && sqrt <= 1.0f) {
                    float m7244getXDnnuFBc = PointKt.m7244getXDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release(sqrt));
                    if (m7244getXDnnuFBc < min) {
                        min = m7244getXDnnuFBc;
                    }
                    if (m7244getXDnnuFBc > max) {
                        max = m7244getXDnnuFBc;
                    }
                }
                float sqrt2 = (f7 - ((float) Math.sqrt(d))) / f8;
                if (0.0f <= sqrt2 && sqrt2 <= 1.0f) {
                    float m7244getXDnnuFBc2 = PointKt.m7244getXDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release(sqrt2));
                    if (m7244getXDnnuFBc2 < min) {
                        min = m7244getXDnnuFBc2;
                    }
                    if (m7244getXDnnuFBc2 > max) {
                        max = m7244getXDnnuFBc2;
                    }
                }
                control0Y = (((-getAnchor0Y()) + (getControl0Y() * f3)) - (f3 * getControl1Y())) + getAnchor1Y();
                float anchor0Y = ((getAnchor0Y() * f4) - (getControl0Y() * f5)) + (getControl1Y() * f4);
                float control0Y2 = (-getAnchor0Y()) + getControl0Y();
                if (zeroIsh(control0Y)) {
                    float f9 = (anchor0Y * anchor0Y) - ((f5 * control0Y) * control0Y2);
                    if (f9 >= 0.0f) {
                        float f10 = -anchor0Y;
                        double d2 = f9;
                        float f11 = f4 * control0Y;
                        float sqrt3 = (((float) Math.sqrt(d2)) + f10) / f11;
                        if (0.0f <= sqrt3 && sqrt3 <= 1.0f) {
                            float m7245getYDnnuFBc2 = PointKt.m7245getYDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release(sqrt3));
                            if (m7245getYDnnuFBc2 < f) {
                                f = m7245getYDnnuFBc2;
                            }
                            if (m7245getYDnnuFBc2 > max2) {
                                max2 = m7245getYDnnuFBc2;
                            }
                        }
                        float sqrt4 = (f10 - ((float) Math.sqrt(d2))) / f11;
                        if (0.0f <= sqrt4 && sqrt4 <= 1.0f) {
                            m7245getYDnnuFBc = PointKt.m7245getYDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release(sqrt4));
                            f2 = m7245getYDnnuFBc < f ? m7245getYDnnuFBc : f;
                        }
                    }
                    f2 = f;
                } else {
                    if (anchor0Y != 0.0f) {
                        float f12 = (f4 * control0Y2) / ((-2) * anchor0Y);
                        if (0.0f <= f12 && f12 <= 1.0f) {
                            m7245getYDnnuFBc = PointKt.m7245getYDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release(f12));
                            f2 = m7245getYDnnuFBc < f ? m7245getYDnnuFBc : f;
                        }
                    }
                    f2 = f;
                }
                bounds[c] = min;
                bounds[1] = f2;
                bounds[c3] = max;
                bounds[c2] = max2;
            }
        } else if (anchor0X != 0.0f) {
            float f13 = (control0X2 * f4) / ((-2) * anchor0X);
            if (0.0f <= f13 && f13 <= 1.0f) {
                float m7244getXDnnuFBc3 = PointKt.m7244getXDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release(f13));
                if (m7244getXDnnuFBc3 < min) {
                    min = m7244getXDnnuFBc3;
                }
                if (m7244getXDnnuFBc3 > max) {
                    max = m7244getXDnnuFBc3;
                }
            }
        }
        c = 0;
        c2 = 3;
        c3 = 2;
        f = min2;
        control0Y = (((-getAnchor0Y()) + (getControl0Y() * f3)) - (f3 * getControl1Y())) + getAnchor1Y();
        float anchor0Y2 = ((getAnchor0Y() * f4) - (getControl0Y() * f5)) + (getControl1Y() * f4);
        float control0Y22 = (-getAnchor0Y()) + getControl0Y();
        if (zeroIsh(control0Y)) {
        }
        bounds[c] = min;
        bounds[1] = f2;
        bounds[c3] = max;
        bounds[c2] = max2;
    }

    public final Pair<Cubic, Cubic> split(float f) {
        float f2 = 1 - f;
        long m7232pointOnCurveOOQOV4g$graphics_shapes_release = m7232pointOnCurveOOQOV4g$graphics_shapes_release(f);
        float f3 = f2 * f2;
        float f4 = 2 * f2 * f;
        float f5 = f * f;
        return TuplesKt.to(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f2) + (getControl0X() * f), (getAnchor0Y() * f2) + (getControl0Y() * f), (getAnchor0X() * f3) + (getControl0X() * f4) + (getControl1X() * f5), (getAnchor0Y() * f3) + (getControl0Y() * f4) + (getControl1Y() * f5), PointKt.m7244getXDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m7245getYDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m7244getXDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m7245getYDnnuFBc(m7232pointOnCurveOOQOV4g$graphics_shapes_release), (getControl0X() * f3) + (getControl1X() * f4) + (getAnchor1X() * f5), (getControl0Y() * f3) + (getControl1Y() * f4) + (getAnchor1Y() * f5), (getControl1X() * f2) + (getAnchor1X() * f), (getControl1Y() * f2) + (getAnchor1Y() * f), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final Cubic plus(Cubic o) {
        Intrinsics.checkNotNullParameter(o, "o");
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] + o.points[i];
        }
        return new Cubic(fArr);
    }

    public final Cubic times(float f) {
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] * f;
        }
        return new Cubic(fArr);
    }

    public final Cubic times(int i) {
        return times(i);
    }

    public final Cubic div(float f) {
        return times(1.0f / f);
    }

    public final Cubic div(int i) {
        return div(i);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) obj).points);
        }
        return false;
    }

    public final Cubic transformed(PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        MutableCubic mutableCubic = new MutableCubic();
        ArraysKt.copyInto$default(this.points, mutableCubic.getPoints$graphics_shapes_release(), 0, 0, 0, 14, (Object) null);
        mutableCubic.transform(f);
        return mutableCubic;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    /* compiled from: Cubic.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J(\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/Cubic$Companion;", "", "()V", "circularArc", "Landroidx/graphics/shapes/Cubic;", "centerX", "", "centerY", "x0", "y0", "x1", "y1", "straightLine", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Cubic straightLine(float f, float f2, float f3, float f4) {
            return CubicKt.Cubic(f, f2, Utils.interpolate(f, f3, 0.33333334f), Utils.interpolate(f2, f4, 0.33333334f), Utils.interpolate(f, f3, 0.6666667f), Utils.interpolate(f2, f4, 0.6666667f), f3, f4);
        }

        @JvmStatic
        public final Cubic circularArc(float f, float f2, float f3, float f4, float f5, float f6) {
            float f7;
            float f8;
            float f9 = f3 - f;
            float f10 = f4 - f2;
            long directionVector = Utils.directionVector(f9, f10);
            float f11 = f5 - f;
            float f12 = f6 - f2;
            long directionVector2 = Utils.directionVector(f11, f12);
            long m7265rotate90DnnuFBc = Utils.m7265rotate90DnnuFBc(directionVector);
            long m7265rotate90DnnuFBc2 = Utils.m7265rotate90DnnuFBc(directionVector2);
            boolean z = PointKt.m7239dotProduct5P9i7ZU(m7265rotate90DnnuFBc, f11, f12) >= 0.0f;
            float m7240dotProductybeJwSQ = PointKt.m7240dotProductybeJwSQ(directionVector, directionVector2);
            if (m7240dotProductybeJwSQ > 0.999f) {
                return straightLine(f3, f4, f5, f6);
            }
            float distance = ((((Utils.distance(f9, f10) * 4.0f) / 3.0f) * (((float) Math.sqrt(2 * f8)) - ((float) Math.sqrt(f7 - (m7240dotProductybeJwSQ * m7240dotProductybeJwSQ))))) / (1 - m7240dotProductybeJwSQ)) * (z ? 1.0f : -1.0f);
            return CubicKt.Cubic(f3, f4, f3 + (PointKt.m7244getXDnnuFBc(m7265rotate90DnnuFBc) * distance), f4 + (PointKt.m7245getYDnnuFBc(m7265rotate90DnnuFBc) * distance), f5 - (PointKt.m7244getXDnnuFBc(m7265rotate90DnnuFBc2) * distance), f6 - (PointKt.m7245getYDnnuFBc(m7265rotate90DnnuFBc2) * distance), f5, f6);
        }
    }
}
