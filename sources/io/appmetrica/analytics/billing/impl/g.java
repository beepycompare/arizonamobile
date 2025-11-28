package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billing.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
/* loaded from: classes3.dex */
public final class g implements Converter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final s fromModel(BillingConfig billingConfig) {
        s sVar = new s();
        sVar.f220a = billingConfig.getSendFrequencySeconds();
        sVar.b = billingConfig.getFirstCollectingInappMaxAgeSeconds();
        return sVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        s sVar = (s) obj;
        return new BillingConfig(sVar.f220a, sVar.b);
    }

    public final BillingConfig a(s sVar) {
        return new BillingConfig(sVar.f220a, sVar.b);
    }
}
