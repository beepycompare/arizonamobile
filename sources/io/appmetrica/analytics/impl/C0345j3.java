package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.j3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0345j3 implements ProtobufConverter {
    public static B2 a(BillingInfo billingInfo) {
        B2 b2 = new B2();
        int i = AbstractC0320i3.f918a[billingInfo.type.ordinal()];
        b2.f361a = i != 1 ? i != 2 ? 1 : 3 : 2;
        b2.b = billingInfo.productId;
        b2.c = billingInfo.purchaseToken;
        b2.d = billingInfo.purchaseTime;
        b2.e = billingInfo.sendTime;
        return b2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((BillingInfo) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        ProductType productType;
        B2 b2 = (B2) obj;
        int i = b2.f361a;
        if (i == 2) {
            productType = ProductType.INAPP;
        } else if (i != 3) {
            productType = ProductType.UNKNOWN;
        } else {
            productType = ProductType.SUBS;
        }
        return new BillingInfo(productType, b2.b, b2.c, b2.d, b2.e);
    }
}
