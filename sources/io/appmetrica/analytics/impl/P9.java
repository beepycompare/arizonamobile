package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* loaded from: classes5.dex */
public final class P9 extends R9 {
    @Override // io.appmetrica.analytics.impl.R9
    public final S9 b(FeatureInfo featureInfo) {
        return new S9(featureInfo.name, featureInfo.version, (featureInfo.flags & 1) != 0);
    }
}
