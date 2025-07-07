package com.google.android.material.color.utilities;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes4.dex */
public final class ViewingConditions {
    public static final ViewingConditions DEFAULT = defaultWithBackgroundLstar(50.0d);
    private final double aw;
    private final double c;
    private final double fl;
    private final double flRoot;
    private final double n;
    private final double nbb;
    private final double nc;
    private final double ncb;
    private final double[] rgbD;
    private final double z;

    public double getAw() {
        return this.aw;
    }

    public double getN() {
        return this.n;
    }

    public double getNbb() {
        return this.nbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getNcb() {
        return this.ncb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getC() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getNc() {
        return this.nc;
    }

    public double[] getRgbD() {
        return this.rgbD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getFl() {
        return this.fl;
    }

    public double getFlRoot() {
        return this.flRoot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getZ() {
        return this.z;
    }

    public static ViewingConditions make(double[] dArr, double d, double d2, double d3, boolean z) {
        double lerp;
        double d4;
        double exp;
        double max = Math.max(0.1d, d2);
        double[][] dArr2 = Cam16.XYZ_TO_CAM16RGB;
        double d5 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = (dArr3[0] * d5) + (dArr3[1] * d6) + (dArr3[2] * d7);
        double[] dArr4 = dArr2[1];
        double d9 = (dArr4[0] * d5) + (dArr4[1] * d6) + (dArr4[2] * d7);
        double[] dArr5 = dArr2[2];
        double d10 = (d5 * dArr5[0]) + (d6 * dArr5[1]) + (d7 * dArr5[2]);
        double d11 = (d3 / 10.0d) + 0.8d;
        if (d11 >= 0.9d) {
            lerp = MathUtils.lerp(0.59d, 0.69d, (d11 - 0.9d) * 10.0d);
        } else {
            lerp = MathUtils.lerp(0.525d, 0.59d, (d11 - 0.8d) * 10.0d);
        }
        double d12 = lerp;
        if (z) {
            d4 = 0.1d;
            exp = 1.0d;
        } else {
            d4 = 0.1d;
            exp = (1.0d - (Math.exp(((-d) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d11;
        }
        double clampDouble = MathUtils.clampDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, exp);
        double[] dArr6 = {(((100.0d / d8) * clampDouble) + 1.0d) - clampDouble, (((100.0d / d9) * clampDouble) + 1.0d) - clampDouble, (((100.0d / d10) * clampDouble) + 1.0d) - clampDouble};
        double d13 = 5.0d * d;
        double d14 = 1.0d / (d13 + 1.0d);
        double d15 = d14 * d14 * d14 * d14;
        double d16 = 1.0d - d15;
        double cbrt = (d15 * d) + (d16 * d4 * d16 * Math.cbrt(d13));
        double yFromLstar = ColorUtils.yFromLstar(max) / dArr[1];
        double sqrt = Math.sqrt(yFromLstar) + 1.48d;
        double pow = 0.725d / Math.pow(yFromLstar, 0.2d);
        double[] dArr7 = {Math.pow(((dArr6[0] * cbrt) * d8) / 100.0d, 0.42d), Math.pow(((dArr6[1] * cbrt) * d9) / 100.0d, 0.42d), Math.pow(((dArr6[2] * cbrt) * d10) / 100.0d, 0.42d)};
        double d17 = dArr7[0];
        double d18 = (d17 * 400.0d) / (d17 + 27.13d);
        double d19 = dArr7[1];
        double d20 = (d19 * 400.0d) / (d19 + 27.13d);
        double d21 = dArr7[2];
        double[] dArr8 = {d18, d20, (400.0d * d21) / (d21 + 27.13d)};
        return new ViewingConditions(yFromLstar, ((dArr8[0] * 2.0d) + dArr8[1] + (dArr8[2] * 0.05d)) * pow, pow, pow, d12, d11, dArr6, cbrt, Math.pow(cbrt, 0.25d), sqrt);
    }

    public static ViewingConditions defaultWithBackgroundLstar(double d) {
        return make(ColorUtils.whitePointD65(), (ColorUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d, d, 2.0d, false);
    }

    private ViewingConditions(double d, double d2, double d3, double d4, double d5, double d6, double[] dArr, double d7, double d8, double d9) {
        this.n = d;
        this.aw = d2;
        this.nbb = d3;
        this.ncb = d4;
        this.c = d5;
        this.nc = d6;
        this.rgbD = dArr;
        this.fl = d7;
        this.flRoot = d8;
        this.z = d9;
    }
}
