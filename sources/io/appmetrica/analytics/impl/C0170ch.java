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
/* renamed from: io.appmetrica.analytics.impl.ch  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0170ch extends Sg {
    public final C0698xe b;
    public final ProtobufStateStorage c;
    public final C0736z2 d;
    public final C0181d2 e;
    public final C0561s2 f;

    public C0170ch(Y4 y4, C0698xe c0698xe) {
        this(y4, c0698xe, ((Sm) Qm.a(U1.class)).create(y4.getContext()), new C0736z2(y4.getContext()), new C0181d2(), new C0561s2(y4.getContext()));
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        Y4 y4 = this.f762a;
        y4.b.toString();
        if (y4.t.c() && y4.x()) {
            U1 u1 = (U1) this.c.read();
            List list = u1.f785a;
            C0711y2 c0711y2 = u1.b;
            C0736z2 c0736z2 = this.d;
            c0736z2.getClass();
            U1 u12 = null;
            C0711y2 a2 = AndroidUtils.isApiAchieved(28) ? C0636v2.a(c0736z2.f1311a, c0736z2.b) : null;
            List list2 = u1.c;
            List list3 = (List) SystemServiceUtils.accessSystemServiceSafelyOrDefault(this.f.f1193a, "getting available providers", "location manager", Collections.emptyList(), new C0536r2());
            C0698xe c0698xe = this.b;
            Context context = this.f762a.f843a;
            c0698xe.getClass();
            ArrayList a3 = new Qi(context, new SafePackageManager()).a();
            if (CollectionUtils.areCollectionsEqual(a3, list)) {
                a3 = null;
            }
            if (a3 != null || !mo.a(c0711y2, a2) || !CollectionUtils.areCollectionsEqual(list2, list3)) {
                if (a3 != null) {
                    list = a3;
                }
                u12 = new U1(list, a2, list3);
            }
            if (u12 == null) {
                if (y4.A()) {
                    C0394l9 c0394l9 = y4.n;
                    Q5 a4 = Q5.a(q5, u1.f785a, u1.b, this.e, u1.c);
                    c0394l9.a(a4, Sk.a(c0394l9.c.b(a4), a4.i));
                    long currentTimeSeconds = c0394l9.i.currentTimeSeconds();
                    c0394l9.k = currentTimeSeconds;
                    c0394l9.f1074a.a(currentTimeSeconds).b();
                    return false;
                }
                return false;
            }
            C0394l9 c0394l92 = y4.n;
            Q5 a5 = Q5.a(q5, u12.f785a, u12.b, this.e, u12.c);
            c0394l92.a(a5, Sk.a(c0394l92.c.b(a5), a5.i));
            long currentTimeSeconds2 = c0394l92.i.currentTimeSeconds();
            c0394l92.k = currentTimeSeconds2;
            c0394l92.f1074a.a(currentTimeSeconds2).b();
            this.c.save(u12);
            return false;
        }
        return false;
    }

    public C0170ch(Y4 y4, C0698xe c0698xe, ProtobufStateStorage protobufStateStorage, C0736z2 c0736z2, C0181d2 c0181d2, C0561s2 c0561s2) {
        super(y4);
        this.b = c0698xe;
        this.c = protobufStateStorage;
        this.d = c0736z2;
        this.e = c0181d2;
        this.f = c0561s2;
    }
}
