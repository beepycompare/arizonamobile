package io.appmetrica.analytics.impl;

import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufConverter;
import java.util.ArrayList;
/* renamed from: io.appmetrica.analytics.impl.u2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0624u2 implements ProtobufConverter {
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0694wm fromModel(C0599t2 c0599t2) {
        C0644um c0644um;
        C0694wm c0694wm = new C0694wm();
        c0694wm.f1145a = new C0669vm[c0599t2.f1090a.size()];
        for (int i = 0; i < c0599t2.f1090a.size(); i++) {
            C0669vm c0669vm = new C0669vm();
            Pair pair = (Pair) c0599t2.f1090a.get(i);
            c0669vm.f1132a = (String) pair.first;
            if (pair.second != null) {
                c0669vm.b = new C0644um();
                C0574s2 c0574s2 = (C0574s2) pair.second;
                if (c0574s2 == null) {
                    c0644um = null;
                } else {
                    C0644um c0644um2 = new C0644um();
                    c0644um2.f1116a = c0574s2.f1076a;
                    c0644um = c0644um2;
                }
                c0669vm.b = c0644um;
            }
            c0694wm.f1145a[i] = c0669vm;
        }
        return c0694wm;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final C0599t2 toModel(C0694wm c0694wm) {
        C0669vm[] c0669vmArr;
        ArrayList arrayList = new ArrayList();
        for (C0669vm c0669vm : c0694wm.f1145a) {
            String str = c0669vm.f1132a;
            C0644um c0644um = c0669vm.b;
            arrayList.add(new Pair(str, c0644um == null ? null : new C0574s2(c0644um.f1116a)));
        }
        return new C0599t2(arrayList);
    }
}
