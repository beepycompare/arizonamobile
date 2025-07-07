package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0280g3 implements ProtobufConverter {
    public static C0727y2 a(BillingInfo billingInfo) {
        C0727y2 c0727y2 = new C0727y2();
        int i = AbstractC0255f3.f830a[billingInfo.type.ordinal()];
        c0727y2.f1136a = i != 1 ? i != 2 ? 1 : 3 : 2;
        c0727y2.b = billingInfo.productId;
        c0727y2.c = billingInfo.purchaseToken;
        c0727y2.d = billingInfo.purchaseTime;
        c0727y2.e = billingInfo.sendTime;
        return c0727y2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((BillingInfo) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        ProductType productType;
        C0727y2 c0727y2 = (C0727y2) obj;
        int i = c0727y2.f1136a;
        if (i == 2) {
            productType = ProductType.INAPP;
        } else if (i != 3) {
            productType = ProductType.UNKNOWN;
        } else {
            productType = ProductType.SUBS;
        }
        return new BillingInfo(productType, c0727y2.b, c0727y2.c, c0727y2.d, c0727y2.e);
    }
}
