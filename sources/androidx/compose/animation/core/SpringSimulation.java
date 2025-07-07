package androidx.compose.animation.core;

import kotlin.Metadata;
/* compiled from: SpringSimulation.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003J-\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\u0004R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\u0004\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "(F)V", "value", "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "getFinalPosition", "setFinalPosition", "naturalFreq", "", "stiffness", "getStiffness", "setStiffness", "getAcceleration", "lastDisplacement", "lastVelocity", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core_release", "(FFJ)J", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SpringSimulation {
    public static final int $stable = 8;
    private float finalPosition;
    private double naturalFreq = Math.sqrt(50.0d);
    private float dampingRatio = 1.0f;

    public SpringSimulation(float f) {
        this.finalPosition = f;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final void setFinalPosition(float f) {
        this.finalPosition = f;
    }

    public final void setStiffness(float f) {
        if (getStiffness() <= 0.0f) {
            PreconditionsKt.throwIllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.naturalFreq = Math.sqrt(f);
    }

    public final float getStiffness() {
        double d = this.naturalFreq;
        return (float) (d * d);
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final void setDampingRatio(float f) {
        if (f < 0.0f) {
            PreconditionsKt.throwIllegalArgumentException("Damping ratio must be non-negative");
        }
        this.dampingRatio = f;
    }

    public final float getAcceleration(float f, float f2) {
        float f3 = f - this.finalPosition;
        double d = this.naturalFreq;
        return (float) (((-(d * d)) * f3) - (((d * 2.0d) * this.dampingRatio) * f2));
    }

    /* renamed from: updateValues-IJZedt4$animation_core_release  reason: not valid java name */
    public final long m176updateValuesIJZedt4$animation_core_release(float f, float f2, long j) {
        double exp;
        double d;
        float f3 = f - this.finalPosition;
        double d2 = j / 1000.0d;
        float f4 = this.dampingRatio;
        double d3 = f4 * f4;
        double d4 = this.naturalFreq;
        double d5 = (-f4) * d4;
        if (f4 > 1.0f) {
            double sqrt = d4 * Math.sqrt(d3 - 1);
            double d6 = d5 + sqrt;
            double d7 = d5 - sqrt;
            double d8 = f3;
            double d9 = ((d7 * d8) - f2) / (d7 - d6);
            double d10 = d8 - d9;
            double d11 = d7 * d2;
            double d12 = d2 * d6;
            d = (Math.exp(d11) * d10) + (Math.exp(d12) * d9);
            exp = (d10 * d7 * Math.exp(d11)) + (d9 * d6 * Math.exp(d12));
        } else if (f4 == 1.0f) {
            double d13 = f3;
            double d14 = f2 + (d4 * d13);
            double d15 = (-d4) * d2;
            double d16 = d13 + (d2 * d14);
            d = d16 * Math.exp(d15);
            exp = (d16 * Math.exp(d15) * (-this.naturalFreq)) + (d14 * Math.exp(d15));
        } else {
            double d17 = 1;
            double sqrt2 = d4 * Math.sqrt(d17 - d3);
            double d18 = f3;
            double d19 = (d17 / sqrt2) * (((-d5) * d18) + f2);
            double d20 = sqrt2 * d2;
            double d21 = d2 * d5;
            double exp2 = Math.exp(d21) * ((Math.cos(d20) * d18) + (Math.sin(d20) * d19));
            exp = (d5 * exp2) + (Math.exp(d21) * (((-sqrt2) * d18 * Math.sin(d20)) + (sqrt2 * d19 * Math.cos(d20))));
            d = exp2;
        }
        return Motion.m167constructorimpl((Float.floatToRawIntBits((float) exp) & 4294967295L) | (Float.floatToRawIntBits((float) (d + this.finalPosition)) << 32));
    }
}
