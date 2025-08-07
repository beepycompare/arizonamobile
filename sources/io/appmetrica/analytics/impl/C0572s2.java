package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0572s2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0468nm fromModel(C0547r2 c0547r2) {
        C0418lm c0418lm;
        C0468nm c0468nm = new C0468nm();
        c0468nm.f974a = new C0443mm[c0547r2.f1028a.size()];
        for (int i = 0; i < c0547r2.f1028a.size(); i++) {
            C0443mm c0443mm = new C0443mm();
            Pair pair = (Pair) c0547r2.f1028a.get(i);
            c0443mm.f959a = (String) pair.first;
            if (pair.second != null) {
                c0443mm.b = new C0418lm();
                C0523q2 c0523q2 = (C0523q2) pair.second;
                if (c0523q2 == null) {
                    c0418lm = null;
                } else {
                    C0418lm c0418lm2 = new C0418lm();
                    c0418lm2.f942a = c0523q2.f1012a;
                    c0418lm = c0418lm2;
                }
                c0443mm.b = c0418lm;
            }
            c0468nm.f974a[i] = c0443mm;
        }
        return c0468nm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0547r2 toModel(C0468nm c0468nm) {
        C0443mm[] c0443mmArr;
        ArrayList arrayList = new ArrayList();
        for (C0443mm c0443mm : c0468nm.f974a) {
            String str = c0443mm.f959a;
            C0418lm c0418lm = c0443mm.b;
            arrayList.add(new Pair(str, c0418lm == null ? null : new C0523q2(c0418lm.f942a)));
        }
        return new C0547r2(arrayList);
    }
}
