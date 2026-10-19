package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class A2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Pm fromModel(C0749z2 c0749z2) {
        Nm nm;
        Pm pm = new Pm();
        pm.f726a = new Om[c0749z2.f1310a.size()];
        for (int i = 0; i < c0749z2.f1310a.size(); i++) {
            Om om = new Om();
            Pair pair = (Pair) c0749z2.f1310a.get(i);
            om.f713a = (String) pair.first;
            if (pair.second != null) {
                om.b = new Nm();
                C0723y2 c0723y2 = (C0723y2) pair.second;
                if (c0723y2 == null) {
                    nm = null;
                } else {
                    Nm nm2 = new Nm();
                    nm2.f695a = c0723y2.f1290a;
                    nm = nm2;
                }
                om.b = nm;
            }
            pm.f726a[i] = om;
        }
        return pm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0749z2 toModel(Pm pm) {
        Om[] omArr;
        ArrayList arrayList = new ArrayList();
        for (Om om : pm.f726a) {
            String str = om.f713a;
            Nm nm = om.b;
            arrayList.add(new Pair(str, nm == null ? null : new C0723y2(nm.f695a)));
        }
        return new C0749z2(arrayList);
    }
}
