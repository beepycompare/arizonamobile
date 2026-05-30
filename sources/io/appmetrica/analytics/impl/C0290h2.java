package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.h2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0290h2 implements ProtobufConverter {

    /* renamed from: a  reason: collision with root package name */
    public final I2 f1006a;

    public C0290h2() {
        this(new I2());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0367k2 fromModel(C0264g2 c0264g2) {
        C0367k2 c0367k2 = new C0367k2();
        c0367k2.f1061a = new C0341j2[c0264g2.f990a.size()];
        int i = 0;
        int i2 = 0;
        for (PermissionState permissionState : c0264g2.f990a) {
            C0341j2[] c0341j2Arr = c0367k2.f1061a;
            C0341j2 c0341j2 = new C0341j2();
            c0341j2.f1044a = permissionState.name;
            c0341j2.b = permissionState.granted;
            c0341j2Arr[i2] = c0341j2;
            i2++;
        }
        K2 k2 = c0264g2.b;
        if (k2 != null) {
            c0367k2.b = this.f1006a.fromModel(k2);
        }
        c0367k2.c = new String[c0264g2.c.size()];
        for (String str : c0264g2.c) {
            c0367k2.c[i] = str;
            i++;
        }
        return c0367k2;
    }

    public C0290h2(I2 i2) {
        this.f1006a = i2;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0264g2 toModel(C0367k2 c0367k2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C0341j2[] c0341j2Arr = c0367k2.f1061a;
            if (i2 >= c0341j2Arr.length) {
                break;
            }
            C0341j2 c0341j2 = c0341j2Arr[i2];
            arrayList.add(new PermissionState(c0341j2.f1044a, c0341j2.b));
            i2++;
        }
        C0316i2 c0316i2 = c0367k2.b;
        K2 model = c0316i2 != null ? this.f1006a.toModel(c0316i2) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c0367k2.c;
            if (i < strArr.length) {
                arrayList2.add(strArr[i]);
                i++;
            } else {
                return new C0264g2(arrayList, model, arrayList2);
            }
        }
    }
}
