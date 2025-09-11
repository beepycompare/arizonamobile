package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0698x2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0718xm fromModel(BillingConfig billingConfig) {
        C0718xm c0718xm = new C0718xm();
        c0718xm.f1160a = billingConfig.sendFrequencySeconds;
        c0718xm.b = billingConfig.firstCollectingInappMaxAgeSeconds;
        return c0718xm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        C0718xm c0718xm = (C0718xm) obj;
        return new BillingConfig(c0718xm.f1160a, c0718xm.b);
    }

    public final BillingConfig a(C0718xm c0718xm) {
        return new BillingConfig(c0718xm.f1160a, c0718xm.b);
    }
}
