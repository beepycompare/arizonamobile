package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.pa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0507pa extends AbstractC0532qa {
    @Override // io.appmetrica.analytics.impl.AbstractC0532qa
    public final C0556ra b(FeatureInfo featureInfo) {
        return new C0556ra(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
