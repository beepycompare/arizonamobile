package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a!\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\b\u001a\u0019\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\n\u001a1\u0010\u000b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\f\b\u0002\u0010\r\u001a\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0013\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a \u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0000\u001a\u0018\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0001H\u0000\u001aB\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u00012\b\b\u0002\u0010/\u001a\u00020\u0001H\u0000\u001a3\u00100\u001a\u00020(2\n\u00101\u001a\u00060\u0006j\u0002`\u00072\n\u00102\u001a\u00060\u0006j\u0002`\u00072\n\u00103\u001a\u00060\u0006j\u0002`\u0007H\u0000¢\u0006\u0004\b4\u00105\u001a*\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u00012\b\b\u0002\u0010/\u001a\u00020\u00012\u0006\u00109\u001a\u00020:H\u0000\u001a\"\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0AH\u0080\bø\u0001\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0016\u001a\u00060\u0006j\u0002`\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u001a\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c\"\u000e\u0010;\u001a\u00020(X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006B"}, d2 = {"distance", "", "x", "y", "distanceSquared", "directionVector", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "(FF)J", "angleRadians", "(F)J", "radialToCartesian", "radius", TtmlNode.CENTER, "radialToCartesian-L6JJ3z0", "(FFJ)J", "DistanceEpsilon", "AngleEpsilon", "RelaxedDistanceEpsilon", "rotate90", "rotate90-DnnuFBc", "(J)J", "Zero", "getZero", "()J", "J", "FloatPi", "getFloatPi", "()F", "TwoPi", "getTwoPi", "square", "interpolate", TtmlNode.START, "stop", "fraction", "positiveModulo", "num", "mod", "collinearIsh", "", "aX", "aY", "bX", "bY", "cX", "cY", "tolerance", "convex", "previous", "current", "next", "convex-b22R3LQ", "(JJJ)Z", "findMinimum", "v0", "v1", "f", "Landroidx/graphics/shapes/FindMinimumFunction;", "DEBUG", "debugLog", "", "tag", "", "messageFactory", "Lkotlin/Function0;", "graphics-shapes"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Utils {
    public static final float AngleEpsilon = 1.0E-6f;
    public static final boolean DEBUG = false;
    public static final float DistanceEpsilon = 1.0E-4f;
    public static final float RelaxedDistanceEpsilon = 0.005f;
    private static final long Zero = FloatFloatPair.m25constructorimpl(0.0f, 0.0f);
    private static final float FloatPi = 3.1415927f;
    private static final float TwoPi = 6.2831855f;

    public static final void debugLog(String tag, Function0<String> messageFactory) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(messageFactory, "messageFactory");
    }

    public static final float distanceSquared(float f, float f2) {
        return (f * f) + (f2 * f2);
    }

    public static final float interpolate(float f, float f2, float f3) {
        return ((1 - f3) * f) + (f3 * f2);
    }

    public static final float positiveModulo(float f, float f2) {
        return ((f % f2) + f2) % f2;
    }

    public static final float square(float f) {
        return f * f;
    }

    public static final float distance(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public static final long directionVector(float f, float f2) {
        float distance = distance(f, f2);
        if (distance <= 0.0f) {
            throw new IllegalArgumentException("Required distance greater than zero".toString());
        }
        return FloatFloatPair.m25constructorimpl(f / distance, f2 / distance);
    }

    public static final long directionVector(float f) {
        double d = f;
        return FloatFloatPair.m25constructorimpl((float) Math.cos(d), (float) Math.sin(d));
    }

    /* renamed from: radialToCartesian-L6JJ3z0$default  reason: not valid java name */
    public static /* synthetic */ long m8858radialToCartesianL6JJ3z0$default(float f, float f2, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Zero;
        }
        return m8857radialToCartesianL6JJ3z0(f, f2, j);
    }

    /* renamed from: radialToCartesian-L6JJ3z0  reason: not valid java name */
    public static final long m8857radialToCartesianL6JJ3z0(float f, float f2, long j) {
        return PointKt.m8825plusybeJwSQ(PointKt.m8827timesso9K2fw(directionVector(f2), f), j);
    }

    /* renamed from: rotate90-DnnuFBc  reason: not valid java name */
    public static final long m8859rotate90DnnuFBc(long j) {
        return FloatFloatPair.m25constructorimpl(-PointKt.m8822getYDnnuFBc(j), PointKt.m8821getXDnnuFBc(j));
    }

    public static final long getZero() {
        return Zero;
    }

    public static final float getFloatPi() {
        return FloatPi;
    }

    public static final float getTwoPi() {
        return TwoPi;
    }

    public static /* synthetic */ boolean collinearIsh$default(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i, Object obj) {
        if ((i & 64) != 0) {
            f7 = 1.0E-4f;
        }
        return collinearIsh(f, f2, f3, f4, f5, f6, f7);
    }

    public static final boolean collinearIsh(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        long m8859rotate90DnnuFBc = m8859rotate90DnnuFBc(FloatFloatPair.m25constructorimpl(f3 - f, f4 - f2));
        long m25constructorimpl = FloatFloatPair.m25constructorimpl(f5 - f, f6 - f2);
        float abs = Math.abs(PointKt.m8817dotProductybeJwSQ(m8859rotate90DnnuFBc, m25constructorimpl));
        return abs < f7 || abs < (PointKt.m8819getDistanceDnnuFBc(m8859rotate90DnnuFBc) * f7) * PointKt.m8819getDistanceDnnuFBc(m25constructorimpl);
    }

    /* renamed from: convex-b22R3LQ  reason: not valid java name */
    public static final boolean m8856convexb22R3LQ(long j, long j2, long j3) {
        return PointKt.m8812clockwiseybeJwSQ(PointKt.m8824minusybeJwSQ(j2, j), PointKt.m8824minusybeJwSQ(j3, j2));
    }

    public static /* synthetic */ float findMinimum$default(float f, float f2, float f3, FindMinimumFunction findMinimumFunction, int i, Object obj) {
        if ((i & 4) != 0) {
            f3 = 0.001f;
        }
        return findMinimum(f, f2, f3, findMinimumFunction);
    }

    public static final float findMinimum(float f, float f2, float f3, FindMinimumFunction f4) {
        Intrinsics.checkNotNullParameter(f4, "f");
        while (f2 - f > f3) {
            float f5 = 2;
            float f6 = 3;
            float f7 = ((f5 * f) + f2) / f6;
            float f8 = ((f5 * f2) + f) / f6;
            if (f4.invoke(f7) < f4.invoke(f8)) {
                f2 = f8;
            } else {
                f = f7;
            }
        }
        return (f + f2) / 2;
    }
}
