package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ja  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0348ja extends AbstractC0400la {
    @Override // io.appmetrica.analytics.impl.AbstractC0400la
    public final C0426ma b(FeatureInfo featureInfo) {
        return new C0426ma(featureInfo.name, featureInfo.version, (featureInfo.flags & 1) != 0);
    }
}
