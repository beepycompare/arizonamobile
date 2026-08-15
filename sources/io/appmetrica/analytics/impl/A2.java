package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class A2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Pm fromModel(C0755z2 c0755z2) {
        Nm nm;
        Pm pm = new Pm();
        pm.f723a = new Om[c0755z2.f1307a.size()];
        for (int i = 0; i < c0755z2.f1307a.size(); i++) {
            Om om = new Om();
            Pair pair = (Pair) c0755z2.f1307a.get(i);
            om.f710a = (String) pair.first;
            if (pair.second != null) {
                om.b = new Nm();
                C0729y2 c0729y2 = (C0729y2) pair.second;
                if (c0729y2 == null) {
                    nm = null;
                } else {
                    Nm nm2 = new Nm();
                    nm2.f692a = c0729y2.f1287a;
                    nm = nm2;
                }
                om.b = nm;
            }
            pm.f723a[i] = om;
        }
        return pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0755z2 toModel(Pm pm) {
        Om[] omArr;
        ArrayList arrayList = new ArrayList();
        for (Om om : pm.f723a) {
            String str = om.f710a;
            Nm nm = om.b;
            arrayList.add(new Pair(str, nm == null ? null : new C0729y2(nm.f692a)));
        }
        return new C0755z2(arrayList);
    }
}
