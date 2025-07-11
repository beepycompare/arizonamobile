package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ja  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0353ja {
    public final C0378ka a(FeatureInfo featureInfo) {
        if (featureInfo.name == null) {
            int i = featureInfo.reqGlEsVersion;
            if (i == 0) {
                return b(featureInfo);
            }
            return new C0378ka("openGlFeature", i, (featureInfo.flags & 1) != 0);
        }
        return b(featureInfo);
    }

    public abstract C0378ka b(FeatureInfo featureInfo);
}
