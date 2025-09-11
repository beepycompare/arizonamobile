package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0623u2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0693wm fromModel(C0598t2 c0598t2) {
        C0643um c0643um;
        C0693wm c0693wm = new C0693wm();
        c0693wm.f1144a = new C0668vm[c0598t2.f1089a.size()];
        for (int i = 0; i < c0598t2.f1089a.size(); i++) {
            C0668vm c0668vm = new C0668vm();
            Pair pair = (Pair) c0598t2.f1089a.get(i);
            c0668vm.f1131a = (String) pair.first;
            if (pair.second != null) {
                c0668vm.b = new C0643um();
                C0573s2 c0573s2 = (C0573s2) pair.second;
                if (c0573s2 == null) {
                    c0643um = null;
                } else {
                    C0643um c0643um2 = new C0643um();
                    c0643um2.f1115a = c0573s2.f1075a;
                    c0643um = c0643um2;
                }
                c0668vm.b = c0643um;
            }
            c0693wm.f1144a[i] = c0668vm;
        }
        return c0693wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0598t2 toModel(C0693wm c0693wm) {
        C0668vm[] c0668vmArr;
        ArrayList arrayList = new ArrayList();
        for (C0668vm c0668vm : c0693wm.f1144a) {
            String str = c0668vm.f1131a;
            C0643um c0643um = c0668vm.b;
            arrayList.add(new Pair(str, c0643um == null ? null : new C0573s2(c0643um.f1115a)));
        }
        return new C0598t2(arrayList);
    }
}
