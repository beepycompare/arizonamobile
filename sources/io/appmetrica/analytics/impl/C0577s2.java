package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0577s2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0398km fromModel(C0552r2 c0552r2) {
        C0348im c0348im;
        C0398km c0398km = new C0398km();
        c0398km.f911a = new C0373jm[c0552r2.f1016a.size()];
        for (int i = 0; i < c0552r2.f1016a.size(); i++) {
            C0373jm c0373jm = new C0373jm();
            Pair pair = (Pair) c0552r2.f1016a.get(i);
            c0373jm.f896a = (String) pair.first;
            if (pair.second != null) {
                c0373jm.b = new C0348im();
                C0528q2 c0528q2 = (C0528q2) pair.second;
                if (c0528q2 == null) {
                    c0348im = null;
                } else {
                    C0348im c0348im2 = new C0348im();
                    c0348im2.f880a = c0528q2.f999a;
                    c0348im = c0348im2;
                }
                c0373jm.b = c0348im;
            }
            c0398km.f911a[i] = c0373jm;
        }
        return c0398km;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0552r2 toModel(C0398km c0398km) {
        C0373jm[] c0373jmArr;
        ArrayList arrayList = new ArrayList();
        for (C0373jm c0373jm : c0398km.f911a) {
            String str = c0373jm.f896a;
            C0348im c0348im = c0373jm.b;
            arrayList.add(new Pair(str, c0348im == null ? null : new C0528q2(c0348im.f880a)));
        }
        return new C0552r2(arrayList);
    }
}
