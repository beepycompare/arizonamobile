package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.billinginterface.internal.BillingInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.x2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0702x2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0280g3 f1115a;

    public C0702x2() {
        this(new C0280g3());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0752z2 fromModel(C0677w2 c0677w2) {
        C0752z2 c0752z2 = new C0752z2();
        c0752z2.f1155a = new C0727y2[c0677w2.f1096a.size()];
        int i = 0;
        for (BillingInfo billingInfo : c0677w2.f1096a) {
            C0727y2[] c0727y2Arr = c0752z2.f1155a;
            this.f1115a.getClass();
            c0727y2Arr[i] = C0280g3.a(billingInfo);
            i++;
        }
        c0752z2.b = c0677w2.b;
        return c0752z2;
    }

    public C0702x2(C0280g3 c0280g3) {
        this.f1115a = c0280g3;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0677w2 toModel(C0752z2 c0752z2) {
        C0727y2[] c0727y2Arr;
        ProductType productType;
        ArrayList arrayList = new ArrayList(c0752z2.f1155a.length);
        for (C0727y2 c0727y2 : c0752z2.f1155a) {
            this.f1115a.getClass();
            int i = c0727y2.f1136a;
            if (i == 2) {
                productType = ProductType.INAPP;
            } else if (i != 3) {
                productType = ProductType.UNKNOWN;
            } else {
                productType = ProductType.SUBS;
            }
            arrayList.add(new BillingInfo(productType, c0727y2.b, c0727y2.c, c0727y2.d, c0727y2.e));
        }
        return new C0677w2(arrayList, c0752z2.b);
    }
}
