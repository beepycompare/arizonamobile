package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class A2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Pm fromModel(C0756z2 c0756z2) {
        Nm nm;
        Pm pm = new Pm();
        pm.f721a = new Om[c0756z2.f1305a.size()];
        for (int i = 0; i < c0756z2.f1305a.size(); i++) {
            Om om = new Om();
            Pair pair = (Pair) c0756z2.f1305a.get(i);
            om.f708a = (String) pair.first;
            if (pair.second != null) {
                om.b = new Nm();
                C0730y2 c0730y2 = (C0730y2) pair.second;
                if (c0730y2 == null) {
                    nm = null;
                } else {
                    Nm nm2 = new Nm();
                    nm2.f690a = c0730y2.f1285a;
                    nm = nm2;
                }
                om.b = nm;
            }
            pm.f721a[i] = om;
        }
        return pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0756z2 toModel(Pm pm) {
        Om[] omArr;
        ArrayList arrayList = new ArrayList();
        for (Om om : pm.f721a) {
            String str = om.f708a;
            Nm nm = om.b;
            arrayList.add(new Pair(str, nm == null ? null : new C0730y2(nm.f690a)));
        }
        return new C0756z2(arrayList);
    }
}
