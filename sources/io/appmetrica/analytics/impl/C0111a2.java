package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.a2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0111a2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final H2 f768a;

    public C0111a2() {
        this(new H2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0189d2 fromModel(Z1 z1) {
        C0189d2 c0189d2 = new C0189d2();
        c0189d2.f821a = new C0163c2[z1.f751a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : z1.f751a) {
            C0163c2[] c0163c2Arr = c0189d2.f821a;
            C0163c2 c0163c2 = new C0163c2();
            c0163c2.f803a = permissionState.name;
            c0163c2.b = permissionState.granted;
            c0163c2Arr[i2] = c0163c2;
            i2++;
        }
        J2 j2 = z1.b;
        if (j2 != null) {
            c0189d2.b = this.f768a.fromModel(j2);
        }
        c0189d2.c = new String[z1.c.size()];
        for (String str : z1.c) {
            c0189d2.c[i] = str;
            i++;
        }
        return c0189d2;
    }

    public C0111a2(H2 h2) {
        this.f768a = h2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Z1 toModel(C0189d2 c0189d2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0163c2[] c0163c2Arr = c0189d2.f821a;
            if (i2 >= c0163c2Arr.length) {
                break;
            }
            C0163c2 c0163c2 = c0163c2Arr[i2];
            arrayList.add(new PermissionState(c0163c2.f803a, c0163c2.b));
            i2++;
        }
        C0137b2 c0137b2 = c0189d2.b;
        J2 model = c0137b2 != null ? this.f768a.toModel(c0137b2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0189d2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new Z1(arrayList, model, arrayList2);
            }
        }
    }
}
