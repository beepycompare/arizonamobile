package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ja  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0342ja extends AbstractC0394la {
    @Override // io.appmetrica.analytics.impl.AbstractC0394la
    public final C0420ma b(FeatureInfo featureInfo) {
        return new C0420ma(featureInfo.name, featureInfo.version, (featureInfo.flags & 1) != 0);
    }
}
