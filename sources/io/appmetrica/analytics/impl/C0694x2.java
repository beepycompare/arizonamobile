package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0694x2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0272g3 f1116a;

    public C0694x2() {
        this(new C0272g3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0744z2 fromModel(C0669w2 c0669w2) {
        C0744z2 c0744z2 = new C0744z2();
        c0744z2.f1156a = new C0719y2[c0669w2.f1097a.size()];
        int i = 0;
        for (BillingInfo billingInfo : c0669w2.f1097a) {
            C0719y2[] c0719y2Arr = c0744z2.f1156a;
            this.f1116a.getClass();
            c0719y2Arr[i] = C0272g3.a(billingInfo);
            i++;
        }
        c0744z2.b = c0669w2.b;
        return c0744z2;
    }

    public C0694x2(C0272g3 c0272g3) {
        this.f1116a = c0272g3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0669w2 toModel(C0744z2 c0744z2) {
        C0719y2[] c0719y2Arr;
        ProductType productType;
        ArrayList arrayList = new ArrayList(c0744z2.f1156a.length);
        for (C0719y2 c0719y2 : c0744z2.f1156a) {
            this.f1116a.getClass();
            int i = c0719y2.f1137a;
            if (i == 2) {
                productType = ProductType.INAPP;
            } else if (i != 3) {
                productType = ProductType.UNKNOWN;
            } else {
                productType = ProductType.SUBS;
            }
            arrayList.add(new BillingInfo(productType, c0719y2.b, c0719y2.c, c0719y2.d, c0719y2.e));
        }
        return new C0669w2(arrayList, c0744z2.b);
    }
}
