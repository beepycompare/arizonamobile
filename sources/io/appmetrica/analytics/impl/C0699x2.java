package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0699x2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0719xm fromModel(BillingConfig billingConfig) {
        C0719xm c0719xm = new C0719xm();
        c0719xm.f1161a = billingConfig.sendFrequencySeconds;
        c0719xm.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return c0719xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0719xm c0719xm = (C0719xm) obj;
        return new BillingConfig(c0719xm.f1161a, c0719xm.b);
    }

    public final BillingConfig a(C0719xm c0719xm) {
        return new BillingConfig(c0719xm.f1161a, c0719xm.b);
    }
}
