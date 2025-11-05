package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* loaded from: classes3.dex */
public abstract class X9 {
    public final Y9 a(FeatureInfo featureInfo) {
        if (featureInfo.name == null) {
            int i = featureInfo.reqGlEsVersion;
            if (i == 0) {
                return b(featureInfo);
            }
            return new Y9("openGlFeature", i, (featureInfo.flags & 1) != 0);
        }
        return b(featureInfo);
    }

    public abstract Y9 b(FeatureInfo featureInfo);
}
