package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Point.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\b\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\n\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a&\u0010\u000e\u001a\u00020\u000f*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a2\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0016\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u001a\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a*\u0010\u001a\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001e\u0010!\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001a\u0010$\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0005\u001a\u001a\u0010&\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010\u0005\u001a+\u0010(\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a+\u0010+\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010*\u001a'\u0010-\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0019\u001a'\u0010/\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0017\u001a\u00020\u0001H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b0\u0010\u0019\u001a&\u00101\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u00102\u001a\u000203H\u0000ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u001f\u00106\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0080\u0002ø\u0001\u0000¢\u0006\u0004\b7\u0010#\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005*\f\b\u0000\u00108\"\u00020\u00022\u00020\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, d2 = {"x", "", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "getX-DnnuFBc", "(J)F", "y", "getY-DnnuFBc", "interpolate", TtmlNode.START, "stop", "fraction", "interpolate-dLqxh1s", "(JJF)J", "clockwise", "", "other", "clockwise-ybeJwSQ", "(JJ)Z", "copy", "copy-5P9i7ZU", "(JFF)J", TtmlNode.TAG_DIV, "operand", "div-so9K2fw", "(JF)J", "dotProduct", "dotProduct-ybeJwSQ", "(JJ)F", "otherX", "otherY", "dotProduct-5P9i7ZU", "(JFF)F", "getDirection", "getDirection-DnnuFBc", "(J)J", "getDistance", "getDistance-DnnuFBc", "getDistanceSquared", "getDistanceSquared-DnnuFBc", "minus", "minus-ybeJwSQ", "(JJ)J", "plus", "plus-ybeJwSQ", "rem", "rem-so9K2fw", "times", "times-so9K2fw", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformed-so9K2fw", "(JLandroidx/graphics/shapes/PointTransformer;)J", "unaryMinus", "unaryMinus-DnnuFBc", "Point", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PointKt {
    /* renamed from: copy-5P9i7ZU  reason: not valid java name */
    public static final long m8814copy5P9i7ZU(long j, float f, float f2) {
        return FloatFloatPair.m25constructorimpl(f, f2);
    }

    /* renamed from: getDistance-DnnuFBc  reason: not valid java name */
    public static final float m8820getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m8822getXDnnuFBc(j) * m8822getXDnnuFBc(j)) + (m8823getYDnnuFBc(j) * m8823getYDnnuFBc(j)));
    }

    /* renamed from: getDistanceSquared-DnnuFBc  reason: not valid java name */
    public static final float m8821getDistanceSquaredDnnuFBc(long j) {
        return (m8822getXDnnuFBc(j) * m8822getXDnnuFBc(j)) + (m8823getYDnnuFBc(j) * m8823getYDnnuFBc(j));
    }

    /* renamed from: dotProduct-ybeJwSQ  reason: not valid java name */
    public static final float m8818dotProductybeJwSQ(long j, long j2) {
        return (m8822getXDnnuFBc(j) * m8822getXDnnuFBc(j2)) + (m8823getYDnnuFBc(j) * m8823getYDnnuFBc(j2));
    }

    /* renamed from: dotProduct-5P9i7ZU  reason: not valid java name */
    public static final float m8817dotProduct5P9i7ZU(long j, float f, float f2) {
        return (m8822getXDnnuFBc(j) * f) + (m8823getYDnnuFBc(j) * f2);
    }

    /* renamed from: clockwise-ybeJwSQ  reason: not valid java name */
    public static final boolean m8813clockwiseybeJwSQ(long j, long j2) {
        return (m8822getXDnnuFBc(j) * m8823getYDnnuFBc(j2)) - (m8823getYDnnuFBc(j) * m8822getXDnnuFBc(j2)) > 0.0f;
    }

    /* renamed from: getDirection-DnnuFBc  reason: not valid java name */
    public static final long m8819getDirectionDnnuFBc(long j) {
        float m8820getDistanceDnnuFBc = m8820getDistanceDnnuFBc(j);
        if (m8820getDistanceDnnuFBc <= 0.0f) {
            throw new IllegalArgumentException("Can't get the direction of a 0-length vector".toString());
        }
        return m8816divso9K2fw(j, m8820getDistanceDnnuFBc);
    }

    /* renamed from: unaryMinus-DnnuFBc  reason: not valid java name */
    public static final long m8830unaryMinusDnnuFBc(long j) {
        return FloatFloatPair.m25constructorimpl(-m8822getXDnnuFBc(j), -m8823getYDnnuFBc(j));
    }

    /* renamed from: minus-ybeJwSQ  reason: not valid java name */
    public static final long m8825minusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m25constructorimpl(m8822getXDnnuFBc(j) - m8822getXDnnuFBc(j2), m8823getYDnnuFBc(j) - m8823getYDnnuFBc(j2));
    }

    /* renamed from: plus-ybeJwSQ  reason: not valid java name */
    public static final long m8826plusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m25constructorimpl(m8822getXDnnuFBc(j) + m8822getXDnnuFBc(j2), m8823getYDnnuFBc(j) + m8823getYDnnuFBc(j2));
    }

    /* renamed from: times-so9K2fw  reason: not valid java name */
    public static final long m8828timesso9K2fw(long j, float f) {
        return FloatFloatPair.m25constructorimpl(m8822getXDnnuFBc(j) * f, m8823getYDnnuFBc(j) * f);
    }

    /* renamed from: div-so9K2fw  reason: not valid java name */
    public static final long m8816divso9K2fw(long j, float f) {
        return FloatFloatPair.m25constructorimpl(m8822getXDnnuFBc(j) / f, m8823getYDnnuFBc(j) / f);
    }

    /* renamed from: rem-so9K2fw  reason: not valid java name */
    public static final long m8827remso9K2fw(long j, float f) {
        return FloatFloatPair.m25constructorimpl(m8822getXDnnuFBc(j) % f, m8823getYDnnuFBc(j) % f);
    }

    /* renamed from: interpolate-dLqxh1s  reason: not valid java name */
    public static final long m8824interpolatedLqxh1s(long j, long j2, float f) {
        return FloatFloatPair.m25constructorimpl(Utils.interpolate(m8822getXDnnuFBc(j), m8822getXDnnuFBc(j2), f), Utils.interpolate(m8823getYDnnuFBc(j), m8823getYDnnuFBc(j2), f));
    }

    /* renamed from: transformed-so9K2fw  reason: not valid java name */
    public static final long m8829transformedso9K2fw(long j, PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        long mo8831transformXgqJiTY = f.mo8831transformXgqJiTY(m8822getXDnnuFBc(j), m8823getYDnnuFBc(j));
        return FloatFloatPair.m25constructorimpl(Float.intBitsToFloat((int) (mo8831transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (mo8831transformXgqJiTY & 4294967295L)));
    }

    /* renamed from: getX-DnnuFBc  reason: not valid java name */
    public static final float m8822getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-DnnuFBc  reason: not valid java name */
    public static final float m8823getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: copy-5P9i7ZU$default  reason: not valid java name */
    public static /* synthetic */ long m8815copy5P9i7ZU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m8814copy5P9i7ZU(j, f, f2);
    }
}
