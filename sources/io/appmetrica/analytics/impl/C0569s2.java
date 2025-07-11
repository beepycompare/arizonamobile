package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0569s2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0390km fromModel(C0544r2 c0544r2) {
        C0340im c0340im;
        C0390km c0390km = new C0390km();
        c0390km.f912a = new C0365jm[c0544r2.f1017a.size()];
        for (int i = 0; i < c0544r2.f1017a.size(); i++) {
            C0365jm c0365jm = new C0365jm();
            Pair pair = (Pair) c0544r2.f1017a.get(i);
            c0365jm.f897a = (String) pair.first;
            if (pair.second != null) {
                c0365jm.b = new C0340im();
                C0520q2 c0520q2 = (C0520q2) pair.second;
                if (c0520q2 == null) {
                    c0340im = null;
                } else {
                    C0340im c0340im2 = new C0340im();
                    c0340im2.f881a = c0520q2.f1000a;
                    c0340im = c0340im2;
                }
                c0365jm.b = c0340im;
            }
            c0390km.f912a[i] = c0365jm;
        }
        return c0390km;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0544r2 toModel(C0390km c0390km) {
        C0365jm[] c0365jmArr;
        ArrayList arrayList = new ArrayList();
        for (C0365jm c0365jm : c0390km.f912a) {
            String str = c0365jm.f897a;
            C0340im c0340im = c0365jm.b;
            arrayList.add(new Pair(str, c0340im == null ? null : new C0520q2(c0340im.f881a)));
        }
        return new C0544r2(arrayList);
    }
}
