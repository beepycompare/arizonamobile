package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoundedPolygon.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0002\u0018\u00002\u00020\u0001B7\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ \u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020\u00172\b\b\u0002\u0010,\u001a\u00020\u0017H\u0007J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0017H\u0002Jc\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00172\n\u00102\u001a\u00060\u0003j\u0002`\u00042\n\u00103\u001a\u00060\u0003j\u0002`\u00042\n\u00104\u001a\u00060\u0003j\u0002`\u00042\n\u00105\u001a\u00060\u0003j\u0002`\u00042\n\u00106\u001a\u00060\u0003j\u0002`\u00042\u0006\u00107\u001a\u00020\u0017H\u0002¢\u0006\u0004\b8\u00109JG\u0010:\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\n\u0010;\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0012\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0004\b<\u0010=R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\fR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u001e\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010 \u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\"\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R \u0010$\u001a\u00060\u0003j\u0002`\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010'¨\u0006>"}, d2 = {"Landroidx/graphics/shapes/RoundedCorner;", "", "p0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "p1", "p2", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "<init>", "(JJJLandroidx/graphics/shapes/CornerRounding;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getP0-1ufDz9w", "()J", "J", "getP1-1ufDz9w", "getP2-1ufDz9w", "getRounding", "()Landroidx/graphics/shapes/CornerRounding;", "d1", "getD1-1ufDz9w", "d2", "getD2-1ufDz9w", "cornerRadius", "", "getCornerRadius", "()F", "smoothing", "getSmoothing", "cosAngle", "getCosAngle", "sinAngle", "getSinAngle", "expectedRoundCut", "getExpectedRoundCut", "expectedCut", "getExpectedCut", TtmlNode.CENTER, "getCenter-1ufDz9w", "setCenter-DnnuFBc", "(J)V", "getCubics", "", "Landroidx/graphics/shapes/Cubic;", "allowedCut0", "allowedCut1", "calculateActualSmoothingValue", "allowedCut", "computeFlankingCurve", "actualRoundCut", "actualSmoothingValues", "corner", "sideStart", "circleSegmentIntersection", "otherCircleSegmentIntersection", "circleCenter", "actualR", "computeFlankingCurve-oAJzIJU", "(FFJJJJJF)Landroidx/graphics/shapes/Cubic;", "lineIntersection", "d0", "lineIntersection-CBFvKDc", "(JJJJ)Landroidx/collection/FloatFloatPair;", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;
    private final long d1;
    private final long d2;
    private final float expectedRoundCut;
    private final long p0;
    private final long p1;
    private final long p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    public /* synthetic */ RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, cornerRounding);
    }

    public final List<Cubic> getCubics(float f) {
        return getCubics$default(this, f, 0.0f, 2, null);
    }

    private RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding) {
        this.p0 = j;
        this.p1 = j2;
        this.p2 = j3;
        this.rounding = cornerRounding;
        long m8109minusybeJwSQ = PointKt.m8109minusybeJwSQ(j, j2);
        long m8109minusybeJwSQ2 = PointKt.m8109minusybeJwSQ(j3, j2);
        float m8104getDistanceDnnuFBc = PointKt.m8104getDistanceDnnuFBc(m8109minusybeJwSQ);
        float m8104getDistanceDnnuFBc2 = PointKt.m8104getDistanceDnnuFBc(m8109minusybeJwSQ2);
        if (m8104getDistanceDnnuFBc > 0.0f && m8104getDistanceDnnuFBc2 > 0.0f) {
            long m8100divso9K2fw = PointKt.m8100divso9K2fw(m8109minusybeJwSQ, m8104getDistanceDnnuFBc);
            this.d1 = m8100divso9K2fw;
            long m8100divso9K2fw2 = PointKt.m8100divso9K2fw(m8109minusybeJwSQ2, m8104getDistanceDnnuFBc2);
            this.d2 = m8100divso9K2fw2;
            float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
            this.cornerRadius = radius;
            this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
            float m8102dotProductybeJwSQ = PointKt.m8102dotProductybeJwSQ(m8100divso9K2fw, m8100divso9K2fw2);
            this.cosAngle = m8102dotProductybeJwSQ;
            float sqrt = (float) Math.sqrt(1.0f - Utils.square(m8102dotProductybeJwSQ));
            this.sinAngle = sqrt;
            this.expectedRoundCut = ((double) sqrt) > 0.001d ? (radius * (m8102dotProductybeJwSQ + 1.0f)) / sqrt : 0.0f;
        } else {
            this.d1 = FloatFloatPair.m12constructorimpl(0.0f, 0.0f);
            this.d2 = FloatFloatPair.m12constructorimpl(0.0f, 0.0f);
            this.cornerRadius = 0.0f;
            this.smoothing = 0.0f;
            this.cosAngle = 0.0f;
            this.sinAngle = 0.0f;
            this.expectedRoundCut = 0.0f;
        }
        this.center = FloatFloatPair.m12constructorimpl(0.0f, 0.0f);
    }

    public /* synthetic */ RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, (i & 8) != 0 ? null : cornerRounding, null);
    }

    /* renamed from: getP0-1ufDz9w  reason: not valid java name */
    public final long m8121getP01ufDz9w() {
        return this.p0;
    }

    /* renamed from: getP1-1ufDz9w  reason: not valid java name */
    public final long m8122getP11ufDz9w() {
        return this.p1;
    }

    /* renamed from: getP2-1ufDz9w  reason: not valid java name */
    public final long m8123getP21ufDz9w() {
        return this.p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    /* renamed from: getD1-1ufDz9w  reason: not valid java name */
    public final long m8119getD11ufDz9w() {
        return this.d1;
    }

    /* renamed from: getD2-1ufDz9w  reason: not valid java name */
    public final long m8120getD21ufDz9w() {
        return this.d2;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    public final float getExpectedCut() {
        return (1.0f + this.smoothing) * this.expectedRoundCut;
    }

    /* renamed from: getCenter-1ufDz9w  reason: not valid java name */
    public final long m8118getCenter1ufDz9w() {
        return this.center;
    }

    /* renamed from: setCenter-DnnuFBc  reason: not valid java name */
    public final void m8124setCenterDnnuFBc(long j) {
        this.center = j;
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return roundedCorner.getCubics(f, f2);
    }

    public final List<Cubic> getCubics(float f, float f2) {
        float min = Math.min(f, f2);
        float f3 = this.expectedRoundCut;
        if (f3 < 1.0E-4f || min < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            this.center = this.p1;
            return CollectionsKt.listOf(Cubic.Companion.straightLine(PointKt.m8106getXDnnuFBc(this.p1), PointKt.m8107getYDnnuFBc(this.p1), PointKt.m8106getXDnnuFBc(this.p1), PointKt.m8107getYDnnuFBc(this.p1)));
        }
        float min2 = Math.min(min, f3);
        float calculateActualSmoothingValue = calculateActualSmoothingValue(f);
        float calculateActualSmoothingValue2 = calculateActualSmoothingValue(f2);
        float f4 = (this.cornerRadius * min2) / this.expectedRoundCut;
        this.center = PointKt.m8110plusybeJwSQ(this.p1, PointKt.m8112timesso9K2fw(PointKt.m8103getDirectionDnnuFBc(PointKt.m8100divso9K2fw(PointKt.m8110plusybeJwSQ(this.d1, this.d2), 2.0f)), (float) Math.sqrt(Utils.square(f4) + Utils.square(min2))));
        long m8110plusybeJwSQ = PointKt.m8110plusybeJwSQ(this.p1, PointKt.m8112timesso9K2fw(this.d1, min2));
        long m8110plusybeJwSQ2 = PointKt.m8110plusybeJwSQ(this.p1, PointKt.m8112timesso9K2fw(this.d2, min2));
        Cubic m8116computeFlankingCurveoAJzIJU = m8116computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue, this.p1, this.p0, m8110plusybeJwSQ, m8110plusybeJwSQ2, this.center, f4);
        Cubic reverse = m8116computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue2, this.p1, this.p2, m8110plusybeJwSQ2, m8110plusybeJwSQ, this.center, f4).reverse();
        return CollectionsKt.listOf((Object[]) new Cubic[]{m8116computeFlankingCurveoAJzIJU, Cubic.Companion.circularArc(PointKt.m8106getXDnnuFBc(this.center), PointKt.m8107getYDnnuFBc(this.center), m8116computeFlankingCurveoAJzIJU.getAnchor1X(), m8116computeFlankingCurveoAJzIJU.getAnchor1Y(), reverse.getAnchor0X(), reverse.getAnchor0Y()), reverse});
    }

    private final float calculateActualSmoothingValue(float f) {
        if (f > getExpectedCut()) {
            return this.smoothing;
        }
        float f2 = this.expectedRoundCut;
        if (f > f2) {
            return (this.smoothing * (f - f2)) / (getExpectedCut() - this.expectedRoundCut);
        }
        return 0.0f;
    }

    /* renamed from: computeFlankingCurve-oAJzIJU  reason: not valid java name */
    private final Cubic m8116computeFlankingCurveoAJzIJU(float f, float f2, long j, long j2, long j3, long j4, long j5, float f3) {
        long m8103getDirectionDnnuFBc = PointKt.m8103getDirectionDnnuFBc(PointKt.m8109minusybeJwSQ(j2, j));
        long m8110plusybeJwSQ = PointKt.m8110plusybeJwSQ(j, PointKt.m8112timesso9K2fw(PointKt.m8112timesso9K2fw(m8103getDirectionDnnuFBc, f), 1.0f + f2));
        long j6 = j3;
        long m8108interpolatedLqxh1s = PointKt.m8108interpolatedLqxh1s(j6, PointKt.m8100divso9K2fw(PointKt.m8110plusybeJwSQ(j3, j4), 2.0f), f2);
        long m8110plusybeJwSQ2 = PointKt.m8110plusybeJwSQ(j5, PointKt.m8112timesso9K2fw(Utils.directionVector(PointKt.m8106getXDnnuFBc(m8108interpolatedLqxh1s) - PointKt.m8106getXDnnuFBc(j5), PointKt.m8107getYDnnuFBc(m8108interpolatedLqxh1s) - PointKt.m8107getYDnnuFBc(j5)), f3));
        FloatFloatPair m8117lineIntersectionCBFvKDc = m8117lineIntersectionCBFvKDc(j2, m8103getDirectionDnnuFBc, m8110plusybeJwSQ2, Utils.m8142rotate90DnnuFBc(PointKt.m8109minusybeJwSQ(m8110plusybeJwSQ2, j5)));
        if (m8117lineIntersectionCBFvKDc != null) {
            j6 = m8117lineIntersectionCBFvKDc.m20unboximpl();
        }
        return new Cubic(m8110plusybeJwSQ, PointKt.m8100divso9K2fw(PointKt.m8110plusybeJwSQ(m8110plusybeJwSQ, PointKt.m8112timesso9K2fw(j6, 2.0f)), 3.0f), j6, m8110plusybeJwSQ2, null);
    }

    /* renamed from: lineIntersection-CBFvKDc  reason: not valid java name */
    private final FloatFloatPair m8117lineIntersectionCBFvKDc(long j, long j2, long j3, long j4) {
        long m8142rotate90DnnuFBc = Utils.m8142rotate90DnnuFBc(j4);
        float m8102dotProductybeJwSQ = PointKt.m8102dotProductybeJwSQ(j2, m8142rotate90DnnuFBc);
        if (Math.abs(m8102dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float m8102dotProductybeJwSQ2 = PointKt.m8102dotProductybeJwSQ(PointKt.m8109minusybeJwSQ(j3, j), m8142rotate90DnnuFBc);
        if (Math.abs(m8102dotProductybeJwSQ) < Math.abs(m8102dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m9boximpl(PointKt.m8110plusybeJwSQ(j, PointKt.m8112timesso9K2fw(j2, m8102dotProductybeJwSQ2 / m8102dotProductybeJwSQ)));
    }
}
