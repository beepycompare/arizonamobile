package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0619u2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0415lm fromModel(BillingConfig billingConfig) {
        C0415lm c0415lm = new C0415lm();
        c0415lm.f928a = billingConfig.sendFrequencySeconds;
        c0415lm.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return c0415lm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0415lm c0415lm = (C0415lm) obj;
        return new BillingConfig(c0415lm.f928a, c0415lm.b);
    }

    public final BillingConfig a(C0415lm c0415lm) {
        return new BillingConfig(c0415lm.f928a, c0415lm.b);
    }
}
