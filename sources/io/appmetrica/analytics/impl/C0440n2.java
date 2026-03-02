package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.n2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0440n2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0460nm fromModel(C0415m2 c0415m2) {
        C0410lm c0410lm;
        C0460nm c0460nm = new C0460nm();
        c0460nm.f1142a = new C0435mm[c0415m2.f1107a.size()];
        for (int i = 0; i < c0415m2.f1107a.size(); i++) {
            C0435mm c0435mm = new C0435mm();
            Pair pair = (Pair) c0415m2.f1107a.get(i);
            c0435mm.f1123a = (String) pair.first;
            if (pair.second != null) {
                c0435mm.b = new C0410lm();
                C0390l2 c0390l2 = (C0390l2) pair.second;
                if (c0390l2 == null) {
                    c0410lm = null;
                } else {
                    C0410lm c0410lm2 = new C0410lm();
                    c0410lm2.f1102a = c0390l2.f1088a;
                    c0410lm = c0410lm2;
                }
                c0435mm.b = c0410lm;
            }
            c0460nm.f1142a[i] = c0435mm;
        }
        return c0460nm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0415m2 toModel(C0460nm c0460nm) {
        C0435mm[] c0435mmArr;
        ArrayList arrayList = new ArrayList();
        for (C0435mm c0435mm : c0460nm.f1142a) {
            String str = c0435mm.f1123a;
            C0410lm c0410lm = c0435mm.b;
            arrayList.add(new Pair(str, c0410lm == null ? null : new C0390l2(c0410lm.f1102a)));
        }
        return new C0415m2(arrayList);
    }
}
