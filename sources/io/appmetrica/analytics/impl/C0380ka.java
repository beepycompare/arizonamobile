package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0380ka extends AbstractC0405la {
    @Override // io.appmetrica.analytics.impl.AbstractC0405la
    public final C0430ma b(FeatureInfo featureInfo) {
        return new C0430ma(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
