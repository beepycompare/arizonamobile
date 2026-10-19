package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.h2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0283h2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final I2 f1011a;

    public C0283h2() {
        this(new I2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0360k2 fromModel(C0257g2 c0257g2) {
        C0360k2 c0360k2 = new C0360k2();
        c0360k2.f1066a = new C0334j2[c0257g2.f995a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : c0257g2.f995a) {
            C0334j2[] c0334j2Arr = c0360k2.f1066a;
            C0334j2 c0334j2 = new C0334j2();
            c0334j2.f1049a = permissionState.name;
            c0334j2.b = permissionState.granted;
            c0334j2Arr[i2] = c0334j2;
            i2++;
        }
        K2 k2 = c0257g2.b;
        if (k2 != null) {
            c0360k2.b = this.f1011a.fromModel(k2);
        }
        c0360k2.c = new String[c0257g2.c.size()];
        for (String str : c0257g2.c) {
            c0360k2.c[i] = str;
            i++;
        }
        return c0360k2;
    }

    public C0283h2(I2 i2) {
        this.f1011a = i2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0257g2 toModel(C0360k2 c0360k2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0334j2[] c0334j2Arr = c0360k2.f1066a;
            if (i2 >= c0334j2Arr.length) {
                break;
            }
            C0334j2 c0334j2 = c0334j2Arr[i2];
            arrayList.add(new PermissionState(c0334j2.f1049a, c0334j2.b));
            i2++;
        }
        C0309i2 c0309i2 = c0360k2.b;
        K2 model = c0309i2 != null ? this.f1011a.toModel(c0309i2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0360k2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new C0257g2(arrayList, model, arrayList2);
            }
        }
    }
}
