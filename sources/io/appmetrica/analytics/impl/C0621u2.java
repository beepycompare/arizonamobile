package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0621u2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0492om fromModel(BillingConfig billingConfig) {
        C0492om c0492om = new C0492om();
        c0492om.f993a = billingConfig.sendFrequencySeconds;
        c0492om.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return c0492om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0492om c0492om = (C0492om) obj;
        return new BillingConfig(c0492om.f993a, c0492om.b);
    }

    public final BillingConfig a(C0492om c0492om) {
        return new BillingConfig(c0492om.f993a, c0492om.b);
    }
}
