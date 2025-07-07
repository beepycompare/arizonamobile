package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0312ha extends AbstractC0361ja {
    @Override // io.appmetrica.analytics.impl.AbstractC0361ja
    public final C0386ka b(FeatureInfo featureInfo) {
        return new C0386ka(featureInfo.name, featureInfo.version, (featureInfo.flags & 1) != 0);
    }
}
