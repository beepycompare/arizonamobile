package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ja  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0349ja extends AbstractC0401la {
    @Override // io.appmetrica.analytics.impl.AbstractC0401la
    public final C0427ma b(FeatureInfo featureInfo) {
        return new C0427ma(featureInfo.name, featureInfo.version, (featureInfo.flags & 1) != 0);
    }
}
