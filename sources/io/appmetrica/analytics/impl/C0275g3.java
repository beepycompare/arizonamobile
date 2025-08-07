package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0275g3 implements ProtobufConverter {
    public static C0722y2 a(BillingInfo billingInfo) {
        C0722y2 c0722y2 = new C0722y2();
        int i = AbstractC0249f3.f840a[billingInfo.type.ordinal()];
        c0722y2.f1145a = i != 1 ? i != 2 ? 1 : 3 : 2;
        c0722y2.b = billingInfo.productId;
        c0722y2.c = billingInfo.purchaseToken;
        c0722y2.d = billingInfo.purchaseTime;
        c0722y2.e = billingInfo.sendTime;
        return c0722y2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((BillingInfo) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        ProductType productType;
        C0722y2 c0722y2 = (C0722y2) obj;
        int i = c0722y2.f1145a;
        if (i == 2) {
            productType = ProductType.INAPP;
        } else if (i != 3) {
            productType = ProductType.UNKNOWN;
        } else {
            productType = ProductType.SUBS;
        }
        return new BillingInfo(productType, c0722y2.b, c0722y2.c, c0722y2.d, c0722y2.e);
    }
}
