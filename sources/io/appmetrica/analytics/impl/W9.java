package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* loaded from: classes3.dex */
public final class W9 extends X9 {
    @Override // io.appmetrica.analytics.impl.X9
    public final Y9 b(FeatureInfo featureInfo) {
        return new Y9(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
