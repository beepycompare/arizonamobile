package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.c2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0163c2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final K2 f814a;

    public C0163c2() {
        this(new K2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0240f2 fromModel(C0137b2 c0137b2) {
        C0240f2 c0240f2 = new C0240f2();
        c0240f2.f866a = new C0214e2[c0137b2.f798a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : c0137b2.f798a) {
            C0214e2[] c0214e2Arr = c0240f2.f866a;
            C0214e2 c0214e2 = new C0214e2();
            c0214e2.f850a = permissionState.name;
            c0214e2.b = permissionState.granted;
            c0214e2Arr[i2] = c0214e2;
            i2++;
        }
        M2 m2 = c0137b2.b;
        if (m2 != null) {
            c0240f2.b = this.f814a.fromModel(m2);
        }
        c0240f2.c = new String[c0137b2.c.size()];
        for (String str : c0137b2.c) {
            c0240f2.c[i] = str;
            i++;
        }
        return c0240f2;
    }

    public C0163c2(K2 k2) {
        this.f814a = k2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0137b2 toModel(C0240f2 c0240f2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0214e2[] c0214e2Arr = c0240f2.f866a;
            if (i2 >= c0214e2Arr.length) {
                break;
            }
            C0214e2 c0214e2 = c0214e2Arr[i2];
            arrayList.add(new PermissionState(c0214e2.f850a, c0214e2.b));
            i2++;
        }
        C0189d2 c0189d2 = c0240f2.b;
        M2 model = c0189d2 != null ? this.f814a.toModel(c0189d2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0240f2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new C0137b2(arrayList, model, arrayList2);
            }
        }
    }
}
