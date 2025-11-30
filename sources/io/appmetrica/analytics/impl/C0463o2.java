package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.o2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0463o2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0483om fromModel(C0438n2 c0438n2) {
        C0433mm c0433mm;
        C0483om c0483om = new C0483om();
        c0483om.f1055a = new C0458nm[c0438n2.f1020a.size()];
        for (int i = 0; i < c0438n2.f1020a.size(); i++) {
            C0458nm c0458nm = new C0458nm();
            Pair pair = (Pair) c0438n2.f1020a.get(i);
            c0458nm.f1036a = (String) pair.first;
            if (pair.second != null) {
                c0458nm.b = new C0433mm();
                C0413m2 c0413m2 = (C0413m2) pair.second;
                if (c0413m2 == null) {
                    c0433mm = null;
                } else {
                    C0433mm c0433mm2 = new C0433mm();
                    c0433mm2.f1015a = c0413m2.f1001a;
                    c0433mm = c0433mm2;
                }
                c0458nm.b = c0433mm;
            }
            c0483om.f1055a[i] = c0458nm;
        }
        return c0483om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0438n2 toModel(C0483om c0483om) {
        C0458nm[] c0458nmArr;
        ArrayList arrayList = new ArrayList();
        for (C0458nm c0458nm : c0483om.f1055a) {
            String str = c0458nm.f1036a;
            C0433mm c0433mm = c0458nm.b;
            arrayList.add(new Pair(str, c0433mm == null ? null : new C0413m2(c0433mm.f1015a)));
        }
        return new C0438n2(arrayList);
    }
}
