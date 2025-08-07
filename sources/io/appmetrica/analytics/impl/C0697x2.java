package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0697x2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0275g3 f1128a;

    public C0697x2() {
        this(new C0275g3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0747z2 fromModel(C0672w2 c0672w2) {
        C0747z2 c0747z2 = new C0747z2();
        c0747z2.f1161a = new C0722y2[c0672w2.f1110a.size()];
        int i = 0;
        for (BillingInfo billingInfo : c0672w2.f1110a) {
            C0722y2[] c0722y2Arr = c0747z2.f1161a;
            this.f1128a.getClass();
            c0722y2Arr[i] = C0275g3.a(billingInfo);
            i++;
        }
        c0747z2.b = c0672w2.b;
        return c0747z2;
    }

    public C0697x2(C0275g3 c0275g3) {
        this.f1128a = c0275g3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0672w2 toModel(C0747z2 c0747z2) {
        C0722y2[] c0722y2Arr;
        ProductType productType;
        ArrayList arrayList = new ArrayList(c0747z2.f1161a.length);
        for (C0722y2 c0722y2 : c0747z2.f1161a) {
            this.f1128a.getClass();
            int i = c0722y2.f1145a;
            if (i == 2) {
                productType = ProductType.INAPP;
            } else if (i != 3) {
                productType = ProductType.UNKNOWN;
            } else {
                productType = ProductType.SUBS;
            }
            arrayList.add(new BillingInfo(productType, c0722y2.b, c0722y2.c, c0722y2.d, c0722y2.e));
        }
        return new C0672w2(arrayList, c0747z2.b);
    }
}
