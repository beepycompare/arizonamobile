package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0569s2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0589sm fromModel(C0544r2 c0544r2) {
        C0540qm c0540qm;
        C0589sm c0589sm = new C0589sm();
        c0589sm.f1066a = new C0564rm[c0544r2.f1036a.size()];
        for (int i = 0; i < c0544r2.f1036a.size(); i++) {
            C0564rm c0564rm = new C0564rm();
            Pair pair = (Pair) c0544r2.f1036a.get(i);
            c0564rm.f1050a = (String) pair.first;
            if (pair.second != null) {
                c0564rm.b = new C0540qm();
                C0520q2 c0520q2 = (C0520q2) pair.second;
                if (c0520q2 == null) {
                    c0540qm = null;
                } else {
                    C0540qm c0540qm2 = new C0540qm();
                    c0540qm2.f1031a = c0520q2.f1020a;
                    c0540qm = c0540qm2;
                }
                c0564rm.b = c0540qm;
            }
            c0589sm.f1066a[i] = c0564rm;
        }
        return c0589sm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0544r2 toModel(C0589sm c0589sm) {
        C0564rm[] c0564rmArr;
        ArrayList arrayList = new ArrayList();
        for (C0564rm c0564rm : c0589sm.f1066a) {
            String str = c0564rm.f1050a;
            C0540qm c0540qm = c0564rm.b;
            arrayList.add(new Pair(str, c0540qm == null ? null : new C0520q2(c0540qm.f1031a)));
        }
        return new C0544r2(arrayList);
    }
}
