package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0183d4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0134b7 f939a;
    public C0595tb b;
    public C0620ub c;
    public C0113ac d;

    public C0183d4(File file) {
        this.f939a = new C0134b7(file);
    }

    public final synchronized Ia a(Context context) {
        C0620ub c0620ub;
        c0620ub = this.c;
        if (c0620ub == null) {
            c0620ub = new C0620ub(c(context));
            this.c = c0620ub;
        }
        return c0620ub;
    }

    public final synchronized Ia b(Context context) {
        return c(context);
    }

    public final Ia c(Context context) {
        C0113ac c0113ac;
        C0595tb c0595tb = this.b;
        if (c0595tb == null) {
            synchronized (this) {
                c0113ac = this.d;
                if (c0113ac == null) {
                    C0134b7 c0134b7 = this.f939a;
                    String a2 = new C0108a7(c0134b7.f910a, c0134b7.b, true).a(context, new O3());
                    N6 n6 = AbstractC0689x5.c;
                    n6.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", InterfaceC0614u5.f1240a);
                    C0330in c0330in = n6.c;
                    X6 x6 = n6.f696a;
                    T6 t6 = x6.c;
                    U6 u6 = x6.d;
                    C0520qa c0520qa = new C0520qa(false);
                    c0520qa.a(112, new P3());
                    C0408ln c0408ln = new C0408ln("service database", hashMap);
                    c0330in.getClass();
                    c0113ac = new C0113ac(context, a2, new Z9(a2), new C0356jn(t6, u6, c0520qa, c0408ln));
                    this.d = c0113ac;
                }
            }
            C0595tb c0595tb2 = new C0595tb(c0113ac);
            this.b = c0595tb2;
            return c0595tb2;
        }
        return c0595tb;
    }
}
