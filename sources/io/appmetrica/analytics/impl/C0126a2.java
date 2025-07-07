package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.a2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0126a2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final H2 f748a;

    public C0126a2() {
        this(new H2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0204d2 fromModel(Z1 z1) {
        C0204d2 c0204d2 = new C0204d2();
        c0204d2.f794a = new C0178c2[z1.f729a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : z1.f729a) {
            C0178c2[] c0178c2Arr = c0204d2.f794a;
            C0178c2 c0178c2 = new C0178c2();
            c0178c2.f777a = permissionState.name;
            c0178c2.b = permissionState.granted;
            c0178c2Arr[i2] = c0178c2;
            i2++;
        }
        J2 j2 = z1.b;
        if (j2 != null) {
            c0204d2.b = this.f748a.fromModel(j2);
        }
        c0204d2.c = new String[z1.c.size()];
        for (String str : z1.c) {
            c0204d2.c[i] = str;
            i++;
        }
        return c0204d2;
    }

    public C0126a2(H2 h2) {
        this.f748a = h2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Z1 toModel(C0204d2 c0204d2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0178c2[] c0178c2Arr = c0204d2.f794a;
            if (i2 >= c0178c2Arr.length) {
                break;
            }
            C0178c2 c0178c2 = c0178c2Arr[i2];
            arrayList.add(new PermissionState(c0178c2.f777a, c0178c2.b));
            i2++;
        }
        C0152b2 c0152b2 = c0204d2.b;
        J2 model = c0152b2 != null ? this.f748a.toModel(c0152b2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0204d2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new Z1(arrayList, model, arrayList2);
            }
        }
    }
}
