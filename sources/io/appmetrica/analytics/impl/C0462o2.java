package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.o2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0462o2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0482om fromModel(C0437n2 c0437n2) {
        C0432mm c0432mm;
        C0482om c0482om = new C0482om();
        c0482om.f1138a = new C0457nm[c0437n2.f1103a.size()];
        for (int i = 0; i < c0437n2.f1103a.size(); i++) {
            C0457nm c0457nm = new C0457nm();
            Pair pair = (Pair) c0437n2.f1103a.get(i);
            c0457nm.f1119a = (String) pair.first;
            if (pair.second != null) {
                c0457nm.b = new C0432mm();
                C0412m2 c0412m2 = (C0412m2) pair.second;
                if (c0412m2 == null) {
                    c0432mm = null;
                } else {
                    C0432mm c0432mm2 = new C0432mm();
                    c0432mm2.f1098a = c0412m2.f1084a;
                    c0432mm = c0432mm2;
                }
                c0457nm.b = c0432mm;
            }
            c0482om.f1138a[i] = c0457nm;
        }
        return c0482om;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0437n2 toModel(C0482om c0482om) {
        C0457nm[] c0457nmArr;
        ArrayList arrayList = new ArrayList();
        for (C0457nm c0457nm : c0482om.f1138a) {
            String str = c0457nm.f1119a;
            C0432mm c0432mm = c0457nm.b;
            arrayList.add(new Pair(str, c0432mm == null ? null : new C0412m2(c0432mm.f1098a)));
        }
        return new C0437n2(arrayList);
    }
}
