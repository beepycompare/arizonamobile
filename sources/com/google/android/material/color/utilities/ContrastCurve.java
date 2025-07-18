package com.google.android.material.color.utilities;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes4.dex */
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double d, double d2, double d3, double d4) {
        this.low = d;
        this.normal = d2;
        this.medium = d3;
        this.high = d4;
    }

    public double getContrast(double d) {
        if (d <= -1.0d) {
            return this.low;
        }
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return MathUtils.lerp(this.low, this.normal, (d - (-1.0d)) / 1.0d);
        }
        if (d < 0.5d) {
            return MathUtils.lerp(this.normal, this.medium, (d - FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) / 0.5d);
        }
        if (d < 1.0d) {
            return MathUtils.lerp(this.medium, this.high, (d - 0.5d) / 0.5d);
        }
        return this.high;
    }
}
