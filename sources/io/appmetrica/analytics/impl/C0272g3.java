package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0272g3 implements ProtobufConverter {
    public static C0719y2 a(BillingInfo billingInfo) {
        C0719y2 c0719y2 = new C0719y2();
        int i = AbstractC0247f3.f831a[billingInfo.type.ordinal()];
        c0719y2.f1137a = i != 1 ? i != 2 ? 1 : 3 : 2;
        c0719y2.b = billingInfo.productId;
        c0719y2.c = billingInfo.purchaseToken;
        c0719y2.d = billingInfo.purchaseTime;
        c0719y2.e = billingInfo.sendTime;
        return c0719y2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((BillingInfo) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        ProductType productType;
        C0719y2 c0719y2 = (C0719y2) obj;
        int i = c0719y2.f1137a;
        if (i == 2) {
            productType = ProductType.INAPP;
        } else if (i != 3) {
            productType = ProductType.UNKNOWN;
        } else {
            productType = ProductType.SUBS;
        }
        return new BillingInfo(productType, c0719y2.b, c0719y2.c, c0719y2.d, c0719y2.e);
    }
}
