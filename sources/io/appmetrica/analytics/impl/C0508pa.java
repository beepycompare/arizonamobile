package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.pa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0508pa extends AbstractC0533qa {
    @Override // io.appmetrica.analytics.impl.AbstractC0533qa
    public final C0557ra b(FeatureInfo featureInfo) {
        return new C0557ra(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
