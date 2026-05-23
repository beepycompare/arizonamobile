package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.la  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0401la {
    public final C0427ma a(FeatureInfo featureInfo) {
        if (featureInfo.name == null) {
            int i = featureInfo.reqGlEsVersion;
            if (i == 0) {
                return b(featureInfo);
            }
            return new C0427ma("openGlFeature", i, (featureInfo.flags & 1) != 0);
        }
        return b(featureInfo);
    }

    public abstract C0427ma b(FeatureInfo featureInfo);
}
