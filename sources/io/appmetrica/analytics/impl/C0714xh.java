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
public final class C0714xh extends AbstractC0463nh {
    public final Qe b;
    public final ProtobufStateStorage c;
    public final N2 d;
    public final C0370k2 e;
    public final G2 f;

    public C0714xh(C0652v5 c0652v5, Qe qe) {
        this(c0652v5, qe, Zm.a(C0138b2.class).a(c0652v5.getContext()), new N2(c0652v5.getContext()), new C0370k2(), new G2(c0652v5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        C0652v5 c0652v5 = this.f1006a;
        c0652v5.b.toString();
        if (c0652v5.t.c() && c0652v5.x()) {
            C0138b2 c0138b2 = (C0138b2) this.c.read();
            List list = c0138b2.f803a;
            M2 m2 = c0138b2.b;
            N2 n2 = this.d;
            n2.getClass();
            C0138b2 c0138b22 = null;
            M2 a2 = AndroidUtils.isApiAchieved(28) ? J2.a(n2.f588a, n2.b) : null;
            List list2 = c0138b2.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f454a, "getting available providers", "location manager", Collections.emptyList(), new F2());
            Qe qe = this.b;
            Context context = this.f1006a.f1120a;
            qe.getClass();
            ArrayList a3 = new C0413lj(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !ro.a(m2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                c0138b22 = new C0138b2(list, a2, list3);
            }
            if (c0138b22 == null) {
                if (c0652v5.A()) {
                    K9 k9 = c0652v5.n;
                    C0478o6 a4 = C0478o6.a(c0478o6, c0138b2.f803a, c0138b2.b, this.e, c0138b2.c);
                    k9.a(a4, C0157bl.a(k9.c.b(a4), a4.i));
                    long currentTimeSeconds = k9.j.currentTimeSeconds();
                    k9.l = currentTimeSeconds;
                    k9.f537a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            K9 k92 = c0652v5.n;
            C0478o6 a5 = C0478o6.a(c0478o6, c0138b22.f803a, c0138b22.b, this.e, c0138b22.c);
            k92.a(a5, C0157bl.a(k92.c.b(a5), a5.i));
            long currentTimeSeconds2 = k92.j.currentTimeSeconds();
            k92.l = currentTimeSeconds2;
            k92.f537a.a(currentTimeSeconds2).b();
            this.c.save(c0138b22);
            return false;
        }
        return false;
    }

    public C0714xh(C0652v5 c0652v5, Qe qe, ProtobufStateStorage protobufStateStorage, N2 n2, C0370k2 c0370k2, G2 g2) {
        super(c0652v5);
        this.b = qe;
        this.c = protobufStateStorage;
        this.d = n2;
        this.e = c0370k2;
        this.f = g2;
    }
}
