package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.data.ProtobufStateStorage;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0274gh extends Wg {
    public final Ce b;
    public final ProtobufStateStorage c;
    public final G2 d;
    public final C0388l2 e;
    public final C0737z2 f;

    public C0274gh(C0210e5 c0210e5, Ce ce) {
        this(c0210e5, ce, ((Vm) Tm.a(C0156c2.class)).create(c0210e5.getContext()), new G2(c0210e5.getContext()), new C0388l2(), new C0737z2(c0210e5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        C0210e5 c0210e5 = this.f744a;
        c0210e5.b.toString();
        if (c0210e5.t.c() && c0210e5.x()) {
            C0156c2 c0156c2 = (C0156c2) this.c.read();
            List list = c0156c2.f823a;
            F2 f2 = c0156c2.b;
            G2 g2 = this.d;
            g2.getClass();
            C0156c2 c0156c22 = null;
            F2 a2 = AndroidUtils.isApiAchieved(28) ? C2.a(g2.f484a, g2.b) : null;
            List list2 = c0156c2.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f1223a, "getting available providers", "location manager", Collections.emptyList(), new C0712y2());
            Ce ce = this.b;
            Context context = this.f744a.f857a;
            ce.getClass();
            ArrayList a3 = new Ui(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !no.a(f2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                c0156c22 = new C0156c2(list, a2, list3);
            }
            if (c0156c22 == null) {
                if (c0210e5.A()) {
                    C0544r9 c0544r9 = c0210e5.n;
                    W5 a4 = W5.a(w5, c0156c2.f823a, c0156c2.b, this.e, c0156c2.c);
                    c0544r9.a(a4, Wk.a(c0544r9.c.b(a4), a4.i));
                    long currentTimeSeconds = c0544r9.j.currentTimeSeconds();
                    c0544r9.l = currentTimeSeconds;
                    c0544r9.f1091a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            C0544r9 c0544r92 = c0210e5.n;
            W5 a5 = W5.a(w5, c0156c22.f823a, c0156c22.b, this.e, c0156c22.c);
            c0544r92.a(a5, Wk.a(c0544r92.c.b(a5), a5.i));
            long currentTimeSeconds2 = c0544r92.j.currentTimeSeconds();
            c0544r92.l = currentTimeSeconds2;
            c0544r92.f1091a.a(currentTimeSeconds2).b();
            this.c.save(c0156c22);
            return false;
        }
        return false;
    }

    public C0274gh(C0210e5 c0210e5, Ce ce, ProtobufStateStorage protobufStateStorage, G2 g2, C0388l2 c0388l2, C0737z2 c0737z2) {
        super(c0210e5);
        this.b = ce;
        this.c = protobufStateStorage;
        this.d = g2;
        this.e = c0388l2;
        this.f = c0737z2;
    }
}
