package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0627u2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0423lm fromModel(BillingConfig billingConfig) {
        C0423lm c0423lm = new C0423lm();
        c0423lm.f927a = billingConfig.sendFrequencySeconds;
        c0423lm.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return c0423lm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0423lm c0423lm = (C0423lm) obj;
        return new BillingConfig(c0423lm.f927a, c0423lm.b);
    }

    public final BillingConfig a(C0423lm c0423lm) {
        return new BillingConfig(c0423lm.f927a, c0423lm.b);
    }
}
