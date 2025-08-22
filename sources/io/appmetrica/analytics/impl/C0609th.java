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
/* renamed from: io.appmetrica.analytics.impl.th  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0609th extends AbstractC0358jh {
    public final Me b;
    public final ProtobufStateStorage c;
    public final K2 d;
    public final C0318i2 e;
    public final D2 f;

    public C0609th(C0572s5 c0572s5, Me me2) {
        this(c0572s5, me2, Vm.a(Z1.class).a(c0572s5.getContext()), new K2(c0572s5.getContext()), new C0318i2(), new D2(c0572s5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        C0572s5 c0572s5 = this.f925a;
        c0572s5.b.toString();
        if (c0572s5.t.c() && c0572s5.w()) {
            Z1 z1 = (Z1) this.c.read();
            List list = z1.f751a;
            J2 j2 = z1.b;
            K2 k2 = this.d;
            k2.getClass();
            Z1 z12 = null;
            J2 a2 = AndroidUtils.isApiAchieved(28) ? G2.a(k2.f523a, k2.b) : null;
            List list2 = z1.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f388a, "getting available providers", "location manager", Collections.emptyList(), new C2());
            Me me2 = this.b;
            Context context = this.f925a.f1054a;
            me2.getClass();
            ArrayList a3 = new C0309hj(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !no.a(j2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                z12 = new Z1(list, a2, list3);
            }
            if (z12 == null) {
                if (c0572s5.z()) {
                    H9 h9 = c0572s5.n;
                    C0399l6 a4 = C0399l6.a(c0399l6, z1.f751a, z1.b, this.e, z1.c);
                    h9.a(a4, Xk.a(h9.c.b(a4), a4.i));
                    long currentTimeSeconds = h9.j.currentTimeSeconds();
                    h9.l = currentTimeSeconds;
                    h9.f474a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            H9 h92 = c0572s5.n;
            C0399l6 a5 = C0399l6.a(c0399l6, z12.f751a, z12.b, this.e, z12.c);
            h92.a(a5, Xk.a(h92.c.b(a5), a5.i));
            long currentTimeSeconds2 = h92.j.currentTimeSeconds();
            h92.l = currentTimeSeconds2;
            h92.f474a.a(currentTimeSeconds2).b();
            this.c.save(z12);
            return false;
        }
        return false;
    }

    public C0609th(C0572s5 c0572s5, Me me2, ProtobufStateStorage protobufStateStorage, K2 k2, C0318i2 c0318i2, D2 d2) {
        super(c0572s5);
        this.b = me2;
        this.c = protobufStateStorage;
        this.d = k2;
        this.e = c0318i2;
        this.f = d2;
    }
}
