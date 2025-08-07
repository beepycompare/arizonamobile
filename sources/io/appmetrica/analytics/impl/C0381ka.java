package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0381ka extends AbstractC0406la {
    @Override // io.appmetrica.analytics.impl.AbstractC0406la
    public final C0431ma b(FeatureInfo featureInfo) {
        return new C0431ma(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
