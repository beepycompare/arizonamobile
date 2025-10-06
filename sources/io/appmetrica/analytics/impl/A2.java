package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class A2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0345j3 f343a;

    public A2() {
        this(new C0345j3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C2 fromModel(C0749z2 c0749z2) {
        C2 c2 = new C2();
        c2.f381a = new B2[c0749z2.f1181a.size()];
        int i = 0;
        for (BillingInfo billingInfo : c0749z2.f1181a) {
            B2[] b2Arr = c2.f381a;
            this.f343a.getClass();
            b2Arr[i] = C0345j3.a(billingInfo);
            i++;
        }
        c2.b = c0749z2.b;
        return c2;
    }

    public A2(C0345j3 c0345j3) {
        this.f343a = c0345j3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0749z2 toModel(C2 c2) {
        B2[] b2Arr;
        ProductType productType;
        ArrayList arrayList = new ArrayList(c2.f381a.length);
        for (B2 b2 : c2.f381a) {
            this.f343a.getClass();
            int i = b2.f361a;
            if (i == 2) {
                productType = ProductType.INAPP;
            } else if (i != 3) {
                productType = ProductType.UNKNOWN;
            } else {
                productType = ProductType.SUBS;
            }
            arrayList.add(new BillingInfo(productType, b2.b, b2.c, b2.d, b2.e));
        }
        return new C0749z2(arrayList, c2.b);
    }
}
