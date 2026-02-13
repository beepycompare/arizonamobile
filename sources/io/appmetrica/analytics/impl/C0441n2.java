package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.n2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0441n2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0461nm fromModel(C0416m2 c0416m2) {
        C0411lm c0411lm;
        C0461nm c0461nm = new C0461nm();
        c0461nm.f1142a = new C0436mm[c0416m2.f1107a.size()];
        for (int i = 0; i < c0416m2.f1107a.size(); i++) {
            C0436mm c0436mm = new C0436mm();
            Pair pair = (Pair) c0416m2.f1107a.get(i);
            c0436mm.f1123a = (String) pair.first;
            if (pair.second != null) {
                c0436mm.b = new C0411lm();
                C0391l2 c0391l2 = (C0391l2) pair.second;
                if (c0391l2 == null) {
                    c0411lm = null;
                } else {
                    C0411lm c0411lm2 = new C0411lm();
                    c0411lm2.f1102a = c0391l2.f1088a;
                    c0411lm = c0411lm2;
                }
                c0436mm.b = c0411lm;
            }
            c0461nm.f1142a[i] = c0436mm;
        }
        return c0461nm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0416m2 toModel(C0461nm c0461nm) {
        C0436mm[] c0436mmArr;
        ArrayList arrayList = new ArrayList();
        for (C0436mm c0436mm : c0461nm.f1142a) {
            String str = c0436mm.f1123a;
            C0411lm c0411lm = c0436mm.b;
            arrayList.add(new Pair(str, c0411lm == null ? null : new C0391l2(c0411lm.f1102a)));
        }
        return new C0416m2(arrayList);
    }
}
