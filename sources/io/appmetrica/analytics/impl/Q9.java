package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* loaded from: classes5.dex */
public abstract class Q9 {
    public final R9 a(FeatureInfo featureInfo) {
        if (featureInfo.name == null) {
            int i = featureInfo.reqGlEsVersion;
            if (i == 0) {
                return b(featureInfo);
            }
            return new R9("openGlFeature", i, (featureInfo.flags & 1) != 0);
        }
        return b(featureInfo);
    }

    public abstract R9 b(FeatureInfo featureInfo);
}
