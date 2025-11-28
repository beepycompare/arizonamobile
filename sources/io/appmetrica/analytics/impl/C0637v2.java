package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.v2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0637v2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0557rm fromModel(C0612u2 c0612u2) {
        C0508pm c0508pm;
        C0557rm c0557rm = new C0557rm();
        c0557rm.f1101a = new C0533qm[c0612u2.f1142a.size()];
        for (int i = 0; i < c0612u2.f1142a.size(); i++) {
            C0533qm c0533qm = new C0533qm();
            Pair pair = (Pair) c0612u2.f1142a.get(i);
            c0533qm.f1080a = (String) pair.first;
            if (pair.second != null) {
                c0533qm.b = new C0508pm();
                C0587t2 c0587t2 = (C0587t2) pair.second;
                if (c0587t2 == null) {
                    c0508pm = null;
                } else {
                    C0508pm c0508pm2 = new C0508pm();
                    c0508pm2.f1059a = c0587t2.f1123a;
                    c0508pm = c0508pm2;
                }
                c0533qm.b = c0508pm;
            }
            c0557rm.f1101a[i] = c0533qm;
        }
        return c0557rm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0612u2 toModel(C0557rm c0557rm) {
        C0533qm[] c0533qmArr;
        ArrayList arrayList = new ArrayList();
        for (C0533qm c0533qm : c0557rm.f1101a) {
            String str = c0533qm.f1080a;
            C0508pm c0508pm = c0533qm.b;
            arrayList.add(new Pair(str, c0508pm == null ? null : new C0587t2(c0508pm.f1059a)));
        }
        return new C0612u2(arrayList);
    }
}
