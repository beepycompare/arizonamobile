package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.a2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0118a2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final H2 f760a;

    public C0118a2() {
        this(new H2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0196d2 fromModel(Z1 z1) {
        C0196d2 c0196d2 = new C0196d2();
        c0196d2.f810a = new C0170c2[z1.f742a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : z1.f742a) {
            C0170c2[] c0170c2Arr = c0196d2.f810a;
            C0170c2 c0170c2 = new C0170c2();
            c0170c2.f792a = permissionState.name;
            c0170c2.b = permissionState.granted;
            c0170c2Arr[i2] = c0170c2;
            i2++;
        }
        J2 j2 = z1.b;
        if (j2 != null) {
            c0196d2.b = this.f760a.fromModel(j2);
        }
        c0196d2.c = new String[z1.c.size()];
        for (String str : z1.c) {
            c0196d2.c[i] = str;
            i++;
        }
        return c0196d2;
    }

    public C0118a2(H2 h2) {
        this.f760a = h2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Z1 toModel(C0196d2 c0196d2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0170c2[] c0170c2Arr = c0196d2.f810a;
            if (i2 >= c0170c2Arr.length) {
                break;
            }
            C0170c2 c0170c2 = c0170c2Arr[i2];
            arrayList.add(new PermissionState(c0170c2.f792a, c0170c2.b));
            i2++;
        }
        C0144b2 c0144b2 = c0196d2.b;
        J2 model = c0144b2 != null ? this.f760a.toModel(c0144b2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0196d2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new Z1(arrayList, model, arrayList2);
            }
        }
    }
}
