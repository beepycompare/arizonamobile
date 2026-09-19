package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ka  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0373ka extends AbstractC0399la {
    @Override // io.appmetrica.analytics.impl.AbstractC0399la
    public final C0425ma b(FeatureInfo featureInfo) {
        return new C0425ma(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
