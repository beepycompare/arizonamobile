package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* loaded from: classes5.dex */
public final class O9 extends Q9 {
    @Override // io.appmetrica.analytics.impl.Q9
    public final R9 b(FeatureInfo featureInfo) {
        return new R9(featureInfo.name, featureInfo.version, (featureInfo.flags & 1) != 0);
    }
}
