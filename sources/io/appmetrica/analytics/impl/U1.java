package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class U1 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final C0639v2 f806a;

    public U1() {
        this(new C0639v2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final X1 fromModel(T1 t1) {
        X1 x1 = new X1();
        x1.f847a = new W1[t1.f790a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : t1.f790a) {
            W1[] w1Arr = x1.f847a;
            W1 w1 = new W1();
            w1.f833a = permissionState.name;
            w1.b = permissionState.granted;
            w1Arr[i2] = w1;
            i2++;
        }
        C0689x2 c0689x2 = t1.b;
        if (c0689x2 != null) {
            x1.b = this.f806a.fromModel(c0689x2);
        }
        x1.c = new String[t1.c.size()];
        for (String str : t1.c) {
            x1.c[i] = str;
            i++;
        }
        return x1;
    }

    public U1(C0639v2 c0639v2) {
        this.f806a = c0639v2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T1 toModel(X1 x1) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            W1[] w1Arr = x1.f847a;
            if (i2 >= w1Arr.length) {
                break;
            }
            W1 w1 = w1Arr[i2];
            arrayList.add(new PermissionState(w1.f833a, w1.b));
            i2++;
        }
        V1 v1 = x1.b;
        C0689x2 model = v1 != null ? this.f806a.toModel(v1) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = x1.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new T1(arrayList, model, arrayList2);
            }
        }
    }
}
