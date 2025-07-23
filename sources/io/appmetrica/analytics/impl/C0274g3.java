package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
/* renamed from: io.appmetrica.analytics.impl.g3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0274g3 implements ProtobufConverter {
    public static C0721y2 a(BillingInfo billingInfo) {
        C0721y2 c0721y2 = new C0721y2();
        int i = AbstractC0248f3.f840a[billingInfo.type.ordinal()];
        c0721y2.f1145a = i != 1 ? i != 2 ? 1 : 3 : 2;
        c0721y2.b = billingInfo.productId;
        c0721y2.c = billingInfo.purchaseToken;
        c0721y2.d = billingInfo.purchaseTime;
        c0721y2.e = billingInfo.sendTime;
        return c0721y2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final /* bridge */ /* synthetic */ Object fromModel(Object obj) {
        return a((BillingInfo) obj);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        ProductType productType;
        C0721y2 c0721y2 = (C0721y2) obj;
        int i = c0721y2.f1145a;
        if (i == 2) {
            productType = ProductType.INAPP;
        } else if (i != 3) {
            productType = ProductType.UNKNOWN;
        } else {
            productType = ProductType.SUBS;
        }
        return new BillingInfo(productType, c0721y2.b, c0721y2.c, c0721y2.d, c0721y2.e);
    }
}
