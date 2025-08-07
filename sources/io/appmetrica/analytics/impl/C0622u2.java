package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0622u2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0493om fromModel(BillingConfig billingConfig) {
        C0493om c0493om = new C0493om();
        c0493om.f992a = billingConfig.sendFrequencySeconds;
        c0493om.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return c0493om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0493om c0493om = (C0493om) obj;
        return new BillingConfig(c0493om.f992a, c0493om.b);
    }

    public final BillingConfig a(C0493om c0493om) {
        return new BillingConfig(c0493om.f992a, c0493om.b);
    }
}
