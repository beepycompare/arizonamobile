package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.c2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0164c2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final K2 f819a;

    public C0164c2() {
        this(new K2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0241f2 fromModel(C0138b2 c0138b2) {
        C0241f2 c0241f2 = new C0241f2();
        c0241f2.f871a = new C0215e2[c0138b2.f803a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : c0138b2.f803a) {
            C0215e2[] c0215e2Arr = c0241f2.f871a;
            C0215e2 c0215e2 = new C0215e2();
            c0215e2.f855a = permissionState.name;
            c0215e2.b = permissionState.granted;
            c0215e2Arr[i2] = c0215e2;
            i2++;
        }
        M2 m2 = c0138b2.b;
        if (m2 != null) {
            c0241f2.b = this.f819a.fromModel(m2);
        }
        c0241f2.c = new String[c0138b2.c.size()];
        for (String str : c0138b2.c) {
            c0241f2.c[i] = str;
            i++;
        }
        return c0241f2;
    }

    public C0164c2(K2 k2) {
        this.f819a = k2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0138b2 toModel(C0241f2 c0241f2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0215e2[] c0215e2Arr = c0241f2.f871a;
            if (i2 >= c0215e2Arr.length) {
                break;
            }
            C0215e2 c0215e2 = c0215e2Arr[i2];
            arrayList.add(new PermissionState(c0215e2.f855a, c0215e2.b));
            i2++;
        }
        C0190d2 c0190d2 = c0241f2.b;
        M2 model = c0190d2 != null ? this.f819a.toModel(c0190d2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0241f2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new C0138b2(arrayList, model, arrayList2);
            }
        }
    }
}
