package io.appmetrica.analytics.billing.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* loaded from: classes3.dex */
public final class i implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final c fromModel(BillingInfo billingInfo) {
        c cVar = new c();
        int i = h.f311a[billingInfo.type.ordinal()];
        cVar.f309a = i != 1 ? i != 2 ? 1 : 3 : 2;
        cVar.b = billingInfo.productId;
        cVar.c = billingInfo.purchaseToken;
        cVar.d = billingInfo.purchaseTime;
        cVar.e = billingInfo.sendTime;
        return cVar;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final BillingInfo toModel(c cVar) {
        ProductType productType;
        int i = cVar.f309a;
        if (i == 2) {
            productType = ProductType.INAPP;
        } else if (i != 3) {
            productType = ProductType.UNKNOWN;
        } else {
            productType = ProductType.SUBS;
        }
        return new BillingInfo(productType, cVar.b, cVar.c, cVar.d, cVar.e);
    }
}
