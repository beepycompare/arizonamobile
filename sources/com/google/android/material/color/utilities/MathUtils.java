package com.google.android.material.color.utilities;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteView;
/* loaded from: classes4.dex */
public class MathUtils {
    public static double clampDouble(double d, double d2, double d3) {
        return d3 < d ? d : d3 > d2 ? d2 : d3;
    }

    public static int clampInt(int i, int i2, int i3) {
        return i3 < i ? i : i3 > i2 ? i2 : i3;
    }

    public static double lerp(double d, double d2, double d3) {
        return ((1.0d - d3) * d) + (d3 * d2);
    }

    public static double sanitizeDegreesDouble(double d) {
        double d2 = d % 360.0d;
        return d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? d2 + 360.0d : d2;
    }

    public static int signum(double d) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return -1;
        }
        return d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : 1;
    }

    private MathUtils() {
    }

    public static int sanitizeDegreesInt(int i) {
        int i2 = i % RouletteView.PREMIUM_ROULETTE_WIDTH;
        return i2 < 0 ? i2 + RouletteView.PREMIUM_ROULETTE_WIDTH : i2;
    }

    public static double rotationDirection(double d, double d2) {
        return sanitizeDegreesDouble(d2 - d) <= 180.0d ? 1.0d : -1.0d;
    }

    public static double differenceDegrees(double d, double d2) {
        return 180.0d - Math.abs(Math.abs(d - d2) - 180.0d);
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        double d = dArr[0];
        double[] dArr3 = dArr2[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = (dArr3[0] * d) + (dArr3[1] * d2) + (dArr3[2] * d3);
        double[] dArr4 = dArr2[1];
        double d5 = (dArr4[0] * d) + (dArr4[1] * d2) + (dArr4[2] * d3);
        double[] dArr5 = dArr2[2];
        return new double[]{d4, d5, (d * dArr5[0]) + (d2 * dArr5[1]) + (d3 * dArr5[2])};
    }
}
