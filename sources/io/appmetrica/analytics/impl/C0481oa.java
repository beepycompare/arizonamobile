package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.oa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0481oa extends AbstractC0532qa {
    @Override // io.appmetrica.analytics.impl.AbstractC0532qa
    public final C0556ra b(FeatureInfo featureInfo) {
        return new C0556ra(featureInfo.name, featureInfo.version, (featureInfo.flags & 1) != 0);
    }
}
