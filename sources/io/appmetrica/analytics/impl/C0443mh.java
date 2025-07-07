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
/* renamed from: io.appmetrica.analytics.impl.mh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0443mh extends AbstractC0193ch {
    public final Ie b;
    public final ProtobufStateStorage c;
    public final K2 d;
    public final C0329i2 e;
    public final D2 f;

    public C0443mh(C0580s5 c0580s5, Ie ie) {
        this(c0580s5, ie, Nm.a(Z1.class).a(c0580s5.getContext()), new K2(c0580s5.getContext()), new C0329i2(), new D2(c0580s5.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        C0580s5 c0580s5 = this.f785a;
        c0580s5.b.toString();
        if (c0580s5.t.c() && c0580s5.w()) {
            Z1 z1 = (Z1) this.c.read();
            List list = z1.f729a;
            J2 j2 = z1.b;
            K2 k2 = this.d;
            k2.getClass();
            Z1 z12 = null;
            J2 a2 = AndroidUtils.isApiAchieved(28) ? G2.a(k2.f499a, k2.b) : null;
            List list2 = z1.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f381a, "getting available providers", "location manager", Collections.emptyList(), new C2());
            Ie ie = this.b;
            Context context = this.f785a.f1037a;
            ie.getClass();
            ArrayList a3 = new Zi(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !fo.a(j2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                z12 = new Z1(list, a2, list3);
            }
            if (z12 == null) {
                if (c0580s5.z()) {
                    C9 c9 = c0580s5.n;
                    C0333i6 a4 = C0333i6.a(c0333i6, z1.f729a, z1.b, this.e, z1.c);
                    c9.a(a4, Pk.a(c9.c.b(a4), a4.i));
                    long currentTimeSeconds = c9.j.currentTimeSeconds();
                    c9.l = currentTimeSeconds;
                    c9.f370a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            C9 c92 = c0580s5.n;
            C0333i6 a5 = C0333i6.a(c0333i6, z12.f729a, z12.b, this.e, z12.c);
            c92.a(a5, Pk.a(c92.c.b(a5), a5.i));
            long currentTimeSeconds2 = c92.j.currentTimeSeconds();
            c92.l = currentTimeSeconds2;
            c92.f370a.a(currentTimeSeconds2).b();
            this.c.save(z12);
            return false;
        }
        return false;
    }

    public C0443mh(C0580s5 c0580s5, Ie ie, ProtobufStateStorage protobufStateStorage, K2 k2, C0329i2 c0329i2, D2 d2) {
        super(c0580s5);
        this.b = ie;
        this.c = protobufStateStorage;
        this.d = k2;
        this.e = c0329i2;
        this.f = d2;
    }
}
