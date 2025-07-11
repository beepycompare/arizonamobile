package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ia  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0329ia extends AbstractC0353ja {
    @Override // io.appmetrica.analytics.impl.AbstractC0353ja
    public final C0378ka b(FeatureInfo featureInfo) {
        return new C0378ka(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
