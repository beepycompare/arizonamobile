package androidx.compose.animation.core;

import androidx.compose.ui.graphics.BezierKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
/* compiled from: Easing.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/CubicBezierEasing;", "Landroidx/compose/animation/core/Easing;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "b", "c", "d", "(FFFF)V", "max", "min", "equals", "", "other", "", "hashCode", "", "throwNoSolution", "", "fraction", "toString", "", "transform", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CubicBezierEasing implements Easing {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final float f94a;
    private final float b;
    private final float c;
    private final float d;
    private final float max;
    private final float min;

    public CubicBezierEasing(float f, float f2, float f3, float f4) {
        this.f94a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        if (!((Float.isNaN(f) || Float.isNaN(f2) || Float.isNaN(f3) || Float.isNaN(f4)) ? false : true)) {
            PreconditionsKt.throwIllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f + ", " + f2 + ", " + f3 + ", " + f4 + '.');
        }
        long computeCubicVerticalBounds = BezierKt.computeCubicVerticalBounds(0.0f, f2, f4, 1.0f, new float[5], 0);
        this.min = Float.intBitsToFloat((int) (computeCubicVerticalBounds >> 32));
        this.max = Float.intBitsToFloat((int) (computeCubicVerticalBounds & 4294967295L));
    }

    @Override // androidx.compose.animation.core.Easing
    public float transform(float f) {
        if (f > 0.0f && f < 1.0f) {
            float max = Math.max(f, 1.1920929E-7f);
            float findFirstCubicRoot = BezierKt.findFirstCubicRoot(0.0f - max, this.f94a - max, this.c - max, 1.0f - max);
            if (Float.isNaN(findFirstCubicRoot)) {
                throwNoSolution(f);
            }
            f = BezierKt.evaluateCubic(this.b, this.d, findFirstCubicRoot);
            float f2 = this.min;
            float f3 = this.max;
            if (f < f2) {
                f = f2;
            }
            if (f > f3) {
                return f3;
            }
        }
        return f;
    }

    private final void throwNoSolution(float f) {
        throw new IllegalArgumentException("The cubic curve with parameters (" + this.f94a + ", " + this.b + ", " + this.c + ", " + this.d + ") has no solution at " + f);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CubicBezierEasing) {
            CubicBezierEasing cubicBezierEasing = (CubicBezierEasing) obj;
            return this.f94a == cubicBezierEasing.f94a && this.b == cubicBezierEasing.b && this.c == cubicBezierEasing.c && this.d == cubicBezierEasing.d;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f94a) * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d);
    }

    public String toString() {
        return "CubicBezierEasing(a=" + this.f94a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ')';
    }
}
