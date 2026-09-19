package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.h2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0288h2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final I2 f1008a;

    public C0288h2() {
        this(new I2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0365k2 fromModel(C0262g2 c0262g2) {
        C0365k2 c0365k2 = new C0365k2();
        c0365k2.f1063a = new C0339j2[c0262g2.f992a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : c0262g2.f992a) {
            C0339j2[] c0339j2Arr = c0365k2.f1063a;
            C0339j2 c0339j2 = new C0339j2();
            c0339j2.f1046a = permissionState.name;
            c0339j2.b = permissionState.granted;
            c0339j2Arr[i2] = c0339j2;
            i2++;
        }
        K2 k2 = c0262g2.b;
        if (k2 != null) {
            c0365k2.b = this.f1008a.fromModel(k2);
        }
        c0365k2.c = new String[c0262g2.c.size()];
        for (String str : c0262g2.c) {
            c0365k2.c[i] = str;
            i++;
        }
        return c0365k2;
    }

    public C0288h2(I2 i2) {
        this.f1008a = i2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0262g2 toModel(C0365k2 c0365k2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0339j2[] c0339j2Arr = c0365k2.f1063a;
            if (i2 >= c0339j2Arr.length) {
                break;
            }
            C0339j2 c0339j2 = c0339j2Arr[i2];
            arrayList.add(new PermissionState(c0339j2.f1046a, c0339j2.b));
            i2++;
        }
        C0314i2 c0314i2 = c0365k2.b;
        K2 model = c0314i2 != null ? this.f1008a.toModel(c0314i2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0365k2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new C0262g2(arrayList, model, arrayList2);
            }
        }
    }
}
