package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Point.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\t\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\r\u0010\u0006\u001a\u0017\u0010\u000e\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a#\u0010\u0010\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0010\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00042\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0018\u001a\u00020\u0019*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b \u0010\u001e\u001a(\u0010!\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b\"\u0010#\u001a(\u0010$\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b%\u0010#\u001a$\u0010&\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b(\u0010)\u001a$\u0010*\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b+\u0010)\u001a$\u0010,\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b-\u0010)\u001a3\u0010.\u001a\u00060\u0001j\u0002`\u00042\n\u0010/\u001a\u00060\u0001j\u0002`\u00042\n\u00100\u001a\u00060\u0001j\u0002`\u00042\u0006\u00101\u001a\u00020\u0003H\u0000¢\u0006\u0004\b2\u00103\u001a#\u00104\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0004\b7\u00108\"\u001c\u0010\u0002\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0007\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u00069"}, d2 = {"Point", "Landroidx/collection/FloatFloatPair;", "x", "", "Landroidx/graphics/shapes/Point;", "getX-DnnuFBc", "(J)F", "y", "getY-DnnuFBc", "copy", "copy-5P9i7ZU", "(JFF)J", "getDistance", "getDistance-DnnuFBc", "getDistanceSquared", "getDistanceSquared-DnnuFBc", "dotProduct", "other", "dotProduct-ybeJwSQ", "(JJ)F", "otherX", "otherY", "dotProduct-5P9i7ZU", "(JFF)F", "clockwise", "", "clockwise-ybeJwSQ", "(JJ)Z", "getDirection", "getDirection-DnnuFBc", "(J)J", "unaryMinus", "unaryMinus-DnnuFBc", "minus", "minus-ybeJwSQ", "(JJ)J", "plus", "plus-ybeJwSQ", "times", "operand", "times-so9K2fw", "(JF)J", TtmlNode.TAG_DIV, "div-so9K2fw", "rem", "rem-so9K2fw", "interpolate", TtmlNode.START, "stop", "fraction", "interpolate-dLqxh1s", "(JJF)J", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformed-so9K2fw", "(JLandroidx/graphics/shapes/PointTransformer;)J", "graphics-shapes"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PointKt {
    /* renamed from: copy-5P9i7ZU  reason: not valid java name */
    public static final long m8813copy5P9i7ZU(long j, float f, float f2) {
        return FloatFloatPair.m25constructorimpl(f, f2);
    }

    /* renamed from: getDistance-DnnuFBc  reason: not valid java name */
    public static final float m8819getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m8821getXDnnuFBc(j) * m8821getXDnnuFBc(j)) + (m8822getYDnnuFBc(j) * m8822getYDnnuFBc(j)));
    }

    /* renamed from: getDistanceSquared-DnnuFBc  reason: not valid java name */
    public static final float m8820getDistanceSquaredDnnuFBc(long j) {
        return (m8821getXDnnuFBc(j) * m8821getXDnnuFBc(j)) + (m8822getYDnnuFBc(j) * m8822getYDnnuFBc(j));
    }

    /* renamed from: dotProduct-ybeJwSQ  reason: not valid java name */
    public static final float m8817dotProductybeJwSQ(long j, long j2) {
        return (m8821getXDnnuFBc(j) * m8821getXDnnuFBc(j2)) + (m8822getYDnnuFBc(j) * m8822getYDnnuFBc(j2));
    }

    /* renamed from: dotProduct-5P9i7ZU  reason: not valid java name */
    public static final float m8816dotProduct5P9i7ZU(long j, float f, float f2) {
        return (m8821getXDnnuFBc(j) * f) + (m8822getYDnnuFBc(j) * f2);
    }

    /* renamed from: clockwise-ybeJwSQ  reason: not valid java name */
    public static final boolean m8812clockwiseybeJwSQ(long j, long j2) {
        return (m8821getXDnnuFBc(j) * m8822getYDnnuFBc(j2)) - (m8822getYDnnuFBc(j) * m8821getXDnnuFBc(j2)) > 0.0f;
    }

    /* renamed from: getDirection-DnnuFBc  reason: not valid java name */
    public static final long m8818getDirectionDnnuFBc(long j) {
        float m8819getDistanceDnnuFBc = m8819getDistanceDnnuFBc(j);
        if (m8819getDistanceDnnuFBc <= 0.0f) {
            throw new IllegalArgumentException("Can't get the direction of a 0-length vector".toString());
        }
        return m8815divso9K2fw(j, m8819getDistanceDnnuFBc);
    }

    /* renamed from: unaryMinus-DnnuFBc  reason: not valid java name */
    public static final long m8829unaryMinusDnnuFBc(long j) {
        return FloatFloatPair.m25constructorimpl(-m8821getXDnnuFBc(j), -m8822getYDnnuFBc(j));
    }

    /* renamed from: minus-ybeJwSQ  reason: not valid java name */
    public static final long m8824minusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m25constructorimpl(m8821getXDnnuFBc(j) - m8821getXDnnuFBc(j2), m8822getYDnnuFBc(j) - m8822getYDnnuFBc(j2));
    }

    /* renamed from: plus-ybeJwSQ  reason: not valid java name */
    public static final long m8825plusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m25constructorimpl(m8821getXDnnuFBc(j) + m8821getXDnnuFBc(j2), m8822getYDnnuFBc(j) + m8822getYDnnuFBc(j2));
    }

    /* renamed from: times-so9K2fw  reason: not valid java name */
    public static final long m8827timesso9K2fw(long j, float f) {
        return FloatFloatPair.m25constructorimpl(m8821getXDnnuFBc(j) * f, m8822getYDnnuFBc(j) * f);
    }

    /* renamed from: div-so9K2fw  reason: not valid java name */
    public static final long m8815divso9K2fw(long j, float f) {
        return FloatFloatPair.m25constructorimpl(m8821getXDnnuFBc(j) / f, m8822getYDnnuFBc(j) / f);
    }

    /* renamed from: rem-so9K2fw  reason: not valid java name */
    public static final long m8826remso9K2fw(long j, float f) {
        return FloatFloatPair.m25constructorimpl(m8821getXDnnuFBc(j) % f, m8822getYDnnuFBc(j) % f);
    }

    /* renamed from: interpolate-dLqxh1s  reason: not valid java name */
    public static final long m8823interpolatedLqxh1s(long j, long j2, float f) {
        return FloatFloatPair.m25constructorimpl(Utils.interpolate(m8821getXDnnuFBc(j), m8821getXDnnuFBc(j2), f), Utils.interpolate(m8822getYDnnuFBc(j), m8822getYDnnuFBc(j2), f));
    }

    /* renamed from: transformed-so9K2fw  reason: not valid java name */
    public static final long m8828transformedso9K2fw(long j, PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        long mo8830transformXgqJiTY = f.mo8830transformXgqJiTY(m8821getXDnnuFBc(j), m8822getYDnnuFBc(j));
        return FloatFloatPair.m25constructorimpl(Float.intBitsToFloat((int) (mo8830transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (mo8830transformXgqJiTY & 4294967295L)));
    }

    /* renamed from: getX-DnnuFBc  reason: not valid java name */
    public static final float m8821getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-DnnuFBc  reason: not valid java name */
    public static final float m8822getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: copy-5P9i7ZU$default  reason: not valid java name */
    public static /* synthetic */ long m8814copy5P9i7ZU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m8813copy5P9i7ZU(j, f, f2);
    }
}
