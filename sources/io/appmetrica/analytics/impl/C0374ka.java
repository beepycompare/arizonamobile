package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0374ka extends AbstractC0400la {
    @Override // io.appmetrica.analytics.impl.AbstractC0400la
    public final C0426ma b(FeatureInfo featureInfo) {
        return new C0426ma(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
