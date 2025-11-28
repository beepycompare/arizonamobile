package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.d2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0182d2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final D2 f838a;

    public C0182d2() {
        this(new D2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0259g2 fromModel(C0156c2 c0156c2) {
        C0259g2 c0259g2 = new C0259g2();
        c0259g2.f885a = new C0233f2[c0156c2.f823a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : c0156c2.f823a) {
            C0233f2[] c0233f2Arr = c0259g2.f885a;
            C0233f2 c0233f2 = new C0233f2();
            c0233f2.f870a = permissionState.name;
            c0233f2.b = permissionState.granted;
            c0233f2Arr[i2] = c0233f2;
            i2++;
        }
        F2 f2 = c0156c2.b;
        if (f2 != null) {
            c0259g2.b = this.f838a.fromModel(f2);
        }
        c0259g2.c = new String[c0156c2.c.size()];
        for (String str : c0156c2.c) {
            c0259g2.c[i] = str;
            i++;
        }
        return c0259g2;
    }

    public C0182d2(D2 d2) {
        this.f838a = d2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0156c2 toModel(C0259g2 c0259g2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0233f2[] c0233f2Arr = c0259g2.f885a;
            if (i2 >= c0233f2Arr.length) {
                break;
            }
            C0233f2 c0233f2 = c0233f2Arr[i2];
            arrayList.add(new PermissionState(c0233f2.f870a, c0233f2.b));
            i2++;
        }
        C0207e2 c0207e2 = c0259g2.b;
        F2 model = c0207e2 != null ? this.f838a.toModel(c0207e2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0259g2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new C0156c2(arrayList, model, arrayList2);
            }
        }
    }
}
