package io.appmetrica.analytics.impl;

import android.content.pm.FeatureInfo;
/* renamed from: io.appmetrica.analytics.impl.ma  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0428ma extends AbstractC0453na {
    @Override // io.appmetrica.analytics.impl.AbstractC0453na
    public final C0478oa b(FeatureInfo featureInfo) {
        return new C0478oa(featureInfo.name, -1, (featureInfo.flags & 1) != 0);
    }
}
