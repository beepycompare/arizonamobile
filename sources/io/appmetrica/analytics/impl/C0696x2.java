package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0696x2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0274g3 f1128a;

    public C0696x2() {
        this(new C0274g3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0746z2 fromModel(C0671w2 c0671w2) {
        C0746z2 c0746z2 = new C0746z2();
        c0746z2.f1161a = new C0721y2[c0671w2.f1110a.size()];
        int i = 0;
        for (BillingInfo billingInfo : c0671w2.f1110a) {
            C0721y2[] c0721y2Arr = c0746z2.f1161a;
            this.f1128a.getClass();
            c0721y2Arr[i] = C0274g3.a(billingInfo);
            i++;
        }
        c0746z2.b = c0671w2.b;
        return c0746z2;
    }

    public C0696x2(C0274g3 c0274g3) {
        this.f1128a = c0274g3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0671w2 toModel(C0746z2 c0746z2) {
        C0721y2[] c0721y2Arr;
        ProductType productType;
        ArrayList arrayList = new ArrayList(c0746z2.f1161a.length);
        for (C0721y2 c0721y2 : c0746z2.f1161a) {
            this.f1128a.getClass();
            int i = c0721y2.f1145a;
            if (i == 2) {
                productType = ProductType.INAPP;
            } else if (i != 3) {
                productType = ProductType.UNKNOWN;
            } else {
                productType = ProductType.SUBS;
            }
            arrayList.add(new BillingInfo(productType, c0721y2.b, c0721y2.c, c0721y2.d, c0721y2.e));
        }
        return new C0671w2(arrayList, c0746z2.b);
    }
}
