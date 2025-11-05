package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoundedPolygon.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B5\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0002Jf\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u00060\u0003j\u0002`\u00042\n\u0010.\u001a\u00060\u0003j\u0002`\u00042\n\u0010/\u001a\u00060\u0003j\u0002`\u00042\n\u00100\u001a\u00060\u0003j\u0002`\u00042\n\u00101\u001a\u00060\u0003j\u0002`\u00042\u0006\u00102\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104J \u00105\u001a\b\u0012\u0004\u0012\u00020*062\u0006\u00107\u001a\u00020\u00112\b\b\u0002\u00108\u001a\u00020\u0011H\u0007JJ\u00109\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\n\u0010:\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0016\u001a\u00060\u0003j\u0002`\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<R&\u0010\n\u001a\u00060\u0003j\u0002`\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001d\u0010\u0016\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u0018\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0019\u0010\fR\u0011\u0010\u001a\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001d\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001e\u0010\fR\u001d\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001f\u0010\fR\u001d\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b \u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u0011\u0010%\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/graphics/shapes/RoundedCorner;", "", "p0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "p1", "p2", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "(JJJLandroidx/graphics/shapes/CornerRounding;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", TtmlNode.CENTER, "getCenter-1ufDz9w", "()J", "setCenter-DnnuFBc", "(J)V", "J", "cornerRadius", "", "getCornerRadius", "()F", "cosAngle", "getCosAngle", "d1", "getD1-1ufDz9w", "d2", "getD2-1ufDz9w", "expectedCut", "getExpectedCut", "expectedRoundCut", "getExpectedRoundCut", "getP0-1ufDz9w", "getP1-1ufDz9w", "getP2-1ufDz9w", "getRounding", "()Landroidx/graphics/shapes/CornerRounding;", "sinAngle", "getSinAngle", "smoothing", "getSmoothing", "calculateActualSmoothingValue", "allowedCut", "computeFlankingCurve", "Landroidx/graphics/shapes/Cubic;", "actualRoundCut", "actualSmoothingValues", "corner", "sideStart", "circleSegmentIntersection", "otherCircleSegmentIntersection", "circleCenter", "actualR", "computeFlankingCurve-oAJzIJU", "(FFJJJJJF)Landroidx/graphics/shapes/Cubic;", "getCubics", "", "allowedCut0", "allowedCut1", "lineIntersection", "d0", "lineIntersection-CBFvKDc", "(JJJJ)Landroidx/collection/FloatFloatPair;", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        long m8553getDirectionDnnuFBc = PointKt.m8553getDirectionDnnuFBc(PointKt.m8559minusybeJwSQ(j, j2));
        this.d1 = m8553getDirectionDnnuFBc;
        long m8553getDirectionDnnuFBc2 = PointKt.m8553getDirectionDnnuFBc(PointKt.m8559minusybeJwSQ(j3, j2));
        this.d2 = m8553getDirectionDnnuFBc2;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float m8552dotProductybeJwSQ = PointKt.m8552dotProductybeJwSQ(m8553getDirectionDnnuFBc, m8553getDirectionDnnuFBc2);
        this.cosAngle = m8552dotProductybeJwSQ;
        float f = 1;
        float sqrt = (float) Math.sqrt(f - Utils.square(m8552dotProductybeJwSQ));
        this.sinAngle = sqrt;
        this.expectedRoundCut = ((double) sqrt) > 0.001d ? (radius * (m8552dotProductybeJwSQ + f)) / sqrt : 0.0f;
        this.center = FloatFloatPair.m24constructorimpl(0.0f, 0.0f);
    }

    public /* synthetic */ RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, (i & 8) != 0 ? null : cornerRounding, null);
    }

    /* renamed from: getP0-1ufDz9w  reason: not valid java name */
    public final long m8571getP01ufDz9w() {
        return this.p0;
    }

    /* renamed from: getP1-1ufDz9w  reason: not valid java name */
    public final long m8572getP11ufDz9w() {
        return this.p1;
    }

    /* renamed from: getP2-1ufDz9w  reason: not valid java name */
    public final long m8573getP21ufDz9w() {
        return this.p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    /* renamed from: getD1-1ufDz9w  reason: not valid java name */
    public final long m8569getD11ufDz9w() {
        return this.d1;
    }

    /* renamed from: getD2-1ufDz9w  reason: not valid java name */
    public final long m8570getD21ufDz9w() {
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
        return (1 + this.smoothing) * this.expectedRoundCut;
    }

    /* renamed from: getCenter-1ufDz9w  reason: not valid java name */
    public final long m8568getCenter1ufDz9w() {
        return this.center;
    }

    /* renamed from: setCenter-DnnuFBc  reason: not valid java name */
    public final void m8574setCenterDnnuFBc(long j) {
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
            return CollectionsKt.listOf(Cubic.Companion.straightLine(PointKt.m8556getXDnnuFBc(this.p1), PointKt.m8557getYDnnuFBc(this.p1), PointKt.m8556getXDnnuFBc(this.p1), PointKt.m8557getYDnnuFBc(this.p1)));
        }
        float min2 = Math.min(min, f3);
        float calculateActualSmoothingValue = calculateActualSmoothingValue(f);
        float calculateActualSmoothingValue2 = calculateActualSmoothingValue(f2);
        float f4 = (this.cornerRadius * min2) / this.expectedRoundCut;
        this.center = PointKt.m8560plusybeJwSQ(this.p1, PointKt.m8562timesso9K2fw(PointKt.m8553getDirectionDnnuFBc(PointKt.m8550divso9K2fw(PointKt.m8560plusybeJwSQ(this.d1, this.d2), 2.0f)), (float) Math.sqrt(Utils.square(f4) + Utils.square(min2))));
        long m8560plusybeJwSQ = PointKt.m8560plusybeJwSQ(this.p1, PointKt.m8562timesso9K2fw(this.d1, min2));
        long m8560plusybeJwSQ2 = PointKt.m8560plusybeJwSQ(this.p1, PointKt.m8562timesso9K2fw(this.d2, min2));
        Cubic m8566computeFlankingCurveoAJzIJU = m8566computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue, this.p1, this.p0, m8560plusybeJwSQ, m8560plusybeJwSQ2, this.center, f4);
        Cubic reverse = m8566computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue2, this.p1, this.p2, m8560plusybeJwSQ2, m8560plusybeJwSQ, this.center, f4).reverse();
        return CollectionsKt.listOf((Object[]) new Cubic[]{m8566computeFlankingCurveoAJzIJU, Cubic.Companion.circularArc(PointKt.m8556getXDnnuFBc(this.center), PointKt.m8557getYDnnuFBc(this.center), m8566computeFlankingCurveoAJzIJU.getAnchor1X(), m8566computeFlankingCurveoAJzIJU.getAnchor1Y(), reverse.getAnchor0X(), reverse.getAnchor0Y()), reverse});
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
    private final Cubic m8566computeFlankingCurveoAJzIJU(float f, float f2, long j, long j2, long j3, long j4, long j5, float f3) {
        long m8553getDirectionDnnuFBc = PointKt.m8553getDirectionDnnuFBc(PointKt.m8559minusybeJwSQ(j2, j));
        long m8560plusybeJwSQ = PointKt.m8560plusybeJwSQ(j, PointKt.m8562timesso9K2fw(PointKt.m8562timesso9K2fw(m8553getDirectionDnnuFBc, f), 1 + f2));
        long j6 = j3;
        long m8558interpolatedLqxh1s = PointKt.m8558interpolatedLqxh1s(j6, PointKt.m8550divso9K2fw(PointKt.m8560plusybeJwSQ(j3, j4), 2.0f), f2);
        long m8560plusybeJwSQ2 = PointKt.m8560plusybeJwSQ(j5, PointKt.m8562timesso9K2fw(Utils.directionVector(PointKt.m8556getXDnnuFBc(m8558interpolatedLqxh1s) - PointKt.m8556getXDnnuFBc(j5), PointKt.m8557getYDnnuFBc(m8558interpolatedLqxh1s) - PointKt.m8557getYDnnuFBc(j5)), f3));
        FloatFloatPair m8567lineIntersectionCBFvKDc = m8567lineIntersectionCBFvKDc(j2, m8553getDirectionDnnuFBc, m8560plusybeJwSQ2, Utils.m8577rotate90DnnuFBc(PointKt.m8559minusybeJwSQ(m8560plusybeJwSQ2, j5)));
        if (m8567lineIntersectionCBFvKDc != null) {
            j6 = m8567lineIntersectionCBFvKDc.m32unboximpl();
        }
        return new Cubic(m8560plusybeJwSQ, PointKt.m8550divso9K2fw(PointKt.m8560plusybeJwSQ(m8560plusybeJwSQ, PointKt.m8562timesso9K2fw(j6, 2.0f)), 3.0f), j6, m8560plusybeJwSQ2, null);
    }

    /* renamed from: lineIntersection-CBFvKDc  reason: not valid java name */
    private final FloatFloatPair m8567lineIntersectionCBFvKDc(long j, long j2, long j3, long j4) {
        long m8577rotate90DnnuFBc = Utils.m8577rotate90DnnuFBc(j4);
        float m8552dotProductybeJwSQ = PointKt.m8552dotProductybeJwSQ(j2, m8577rotate90DnnuFBc);
        if (Math.abs(m8552dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float m8552dotProductybeJwSQ2 = PointKt.m8552dotProductybeJwSQ(PointKt.m8559minusybeJwSQ(j3, j), m8577rotate90DnnuFBc);
        if (Math.abs(m8552dotProductybeJwSQ) < Math.abs(m8552dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m21boximpl(PointKt.m8560plusybeJwSQ(j, PointKt.m8562timesso9K2fw(j2, m8552dotProductybeJwSQ2 / m8552dotProductybeJwSQ)));
    }
}
