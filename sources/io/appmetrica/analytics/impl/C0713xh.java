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
/* renamed from: io.appmetrica.analytics.impl.xh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0713xh extends AbstractC0462nh {
    public final Qe b;
    public final ProtobufStateStorage c;
    public final N2 d;
    public final C0369k2 e;
    public final G2 f;

    public C0713xh(C0651v5 c0651v5, Qe qe) {
        this(c0651v5, qe, Zm.a(C0137b2.class).a(c0651v5.getContext()), new N2(c0651v5.getContext()), new C0369k2(), new G2(c0651v5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        C0651v5 c0651v5 = this.f1001a;
        c0651v5.b.toString();
        if (c0651v5.t.c() && c0651v5.x()) {
            C0137b2 c0137b2 = (C0137b2) this.c.read();
            List list = c0137b2.f798a;
            M2 m2 = c0137b2.b;
            N2 n2 = this.d;
            n2.getClass();
            C0137b2 c0137b22 = null;
            M2 a2 = AndroidUtils.isApiAchieved(28) ? J2.a(n2.f583a, n2.b) : null;
            List list2 = c0137b2.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f449a, "getting available providers", "location manager", Collections.emptyList(), new F2());
            Qe qe = this.b;
            Context context = this.f1001a.f1115a;
            qe.getClass();
            ArrayList a3 = new C0412lj(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !ro.a(m2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                c0137b22 = new C0137b2(list, a2, list3);
            }
            if (c0137b22 == null) {
                if (c0651v5.A()) {
                    K9 k9 = c0651v5.n;
                    C0477o6 a4 = C0477o6.a(c0477o6, c0137b2.f798a, c0137b2.b, this.e, c0137b2.c);
                    k9.a(a4, C0156bl.a(k9.c.b(a4), a4.i));
                    long currentTimeSeconds = k9.j.currentTimeSeconds();
                    k9.l = currentTimeSeconds;
                    k9.f532a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            K9 k92 = c0651v5.n;
            C0477o6 a5 = C0477o6.a(c0477o6, c0137b22.f798a, c0137b22.b, this.e, c0137b22.c);
            k92.a(a5, C0156bl.a(k92.c.b(a5), a5.i));
            long currentTimeSeconds2 = k92.j.currentTimeSeconds();
            k92.l = currentTimeSeconds2;
            k92.f532a.a(currentTimeSeconds2).b();
            this.c.save(c0137b22);
            return false;
        }
        return false;
    }

    public C0713xh(C0651v5 c0651v5, Qe qe, ProtobufStateStorage protobufStateStorage, N2 n2, C0369k2 c0369k2, G2 g2) {
        super(c0651v5);
        this.b = qe;
        this.c = protobufStateStorage;
        this.d = n2;
        this.e = c0369k2;
        this.f = g2;
    }
}
