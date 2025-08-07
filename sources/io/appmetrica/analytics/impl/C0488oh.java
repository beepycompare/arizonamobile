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
/* renamed from: io.appmetrica.analytics.impl.oh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0488oh extends AbstractC0237eh {
    public final Ke b;
    public final ProtobufStateStorage c;
    public final K2 d;
    public final C0324i2 e;
    public final D2 f;

    public C0488oh(C0575s5 c0575s5, Ke ke) {
        this(c0575s5, ke, Qm.a(Z1.class).a(c0575s5.getContext()), new K2(c0575s5.getContext()), new C0324i2(), new D2(c0575s5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        C0575s5 c0575s5 = this.f831a;
        c0575s5.b.toString();
        if (c0575s5.t.c() && c0575s5.w()) {
            Z1 z1 = (Z1) this.c.read();
            List list = z1.f741a;
            J2 j2 = z1.b;
            K2 k2 = this.d;
            k2.getClass();
            Z1 z12 = null;
            J2 a2 = AndroidUtils.isApiAchieved(28) ? G2.a(k2.f514a, k2.b) : null;
            List list2 = z1.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f388a, "getting available providers", "location manager", Collections.emptyList(), new C2());
            Ke ke = this.b;
            Context context = this.f831a.f1048a;
            ke.getClass();
            ArrayList a3 = new C0188cj(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !io.a(j2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                z12 = new Z1(list, a2, list3);
            }
            if (z12 == null) {
                if (c0575s5.z()) {
                    F9 f9 = c0575s5.n;
                    C0402l6 a4 = C0402l6.a(c0402l6, z1.f741a, z1.b, this.e, z1.c);
                    f9.a(a4, Sk.a(f9.c.b(a4), a4.i));
                    long currentTimeSeconds = f9.j.currentTimeSeconds();
                    f9.l = currentTimeSeconds;
                    f9.f434a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            F9 f92 = c0575s5.n;
            C0402l6 a5 = C0402l6.a(c0402l6, z12.f741a, z12.b, this.e, z12.c);
            f92.a(a5, Sk.a(f92.c.b(a5), a5.i));
            long currentTimeSeconds2 = f92.j.currentTimeSeconds();
            f92.l = currentTimeSeconds2;
            f92.f434a.a(currentTimeSeconds2).b();
            this.c.save(z12);
            return false;
        }
        return false;
    }

    public C0488oh(C0575s5 c0575s5, Ke ke, ProtobufStateStorage protobufStateStorage, K2 k2, C0324i2 c0324i2, D2 d2) {
        super(c0575s5);
        this.b = ke;
        this.c = protobufStateStorage;
        this.d = k2;
        this.e = c0324i2;
        this.f = d2;
    }
}
