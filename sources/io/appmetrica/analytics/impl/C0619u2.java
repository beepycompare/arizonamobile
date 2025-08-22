package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0619u2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0614tm fromModel(BillingConfig billingConfig) {
        C0614tm c0614tm = new C0614tm();
        c0614tm.f1078a = billingConfig.sendFrequencySeconds;
        c0614tm.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return c0614tm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0614tm c0614tm = (C0614tm) obj;
        return new BillingConfig(c0614tm.f1078a, c0614tm.b);
    }

    public final BillingConfig a(C0614tm c0614tm) {
        return new BillingConfig(c0614tm.f1078a, c0614tm.b);
    }
}
