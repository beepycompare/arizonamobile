package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.s2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0571s2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0467nm fromModel(C0546r2 c0546r2) {
        C0417lm c0417lm;
        C0467nm c0467nm = new C0467nm();
        c0467nm.f974a = new C0442mm[c0546r2.f1028a.size()];
        for (int i = 0; i < c0546r2.f1028a.size(); i++) {
            C0442mm c0442mm = new C0442mm();
            Pair pair = (Pair) c0546r2.f1028a.get(i);
            c0442mm.f959a = (String) pair.first;
            if (pair.second != null) {
                c0442mm.b = new C0417lm();
                C0522q2 c0522q2 = (C0522q2) pair.second;
                if (c0522q2 == null) {
                    c0417lm = null;
                } else {
                    C0417lm c0417lm2 = new C0417lm();
                    c0417lm2.f942a = c0522q2.f1012a;
                    c0417lm = c0417lm2;
                }
                c0442mm.b = c0417lm;
            }
            c0467nm.f974a[i] = c0442mm;
        }
        return c0467nm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0546r2 toModel(C0467nm c0467nm) {
        C0442mm[] c0442mmArr;
        ArrayList arrayList = new ArrayList();
        for (C0442mm c0442mm : c0467nm.f974a) {
            String str = c0442mm.f959a;
            C0417lm c0417lm = c0442mm.b;
            arrayList.add(new Pair(str, c0417lm == null ? null : new C0522q2(c0417lm.f942a)));
        }
        return new C0546r2(arrayList);
    }
}
