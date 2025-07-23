package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ja  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0355ja extends AbstractC0405la {
    @Override // io.appmetrica.analytics.impl.AbstractC0405la
    public final C0430ma b(FeatureInfo featureInfo) {
        return new C0430ma(featureInfo.name, featureInfo.version, (featureInfo.flags & 1) != 0);
    }
}
