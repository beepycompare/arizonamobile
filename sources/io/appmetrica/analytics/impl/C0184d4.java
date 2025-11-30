package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0184d4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0135b7 f842a;
    public C0596tb b;
    public C0621ub c;
    public C0114ac d;

    public C0184d4(File file) {
        this.f842a = new C0135b7(file);
    }

    public final synchronized Ia a(Context context) {
        C0621ub c0621ub;
        c0621ub = this.c;
        if (c0621ub == null) {
            c0621ub = new C0621ub(c(context));
            this.c = c0621ub;
        }
        return c0621ub;
    }

    public final synchronized Ia b(Context context) {
        return c(context);
    }

    public final Ia c(Context context) {
        C0114ac c0114ac;
        C0596tb c0596tb = this.b;
        if (c0596tb == null) {
            synchronized (this) {
                c0114ac = this.d;
                if (c0114ac == null) {
                    C0135b7 c0135b7 = this.f842a;
                    String a2 = new C0109a7(c0135b7.f813a, c0135b7.b, true).a(context, new O3());
                    N6 n6 = AbstractC0690x5.c;
                    n6.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", InterfaceC0615u5.f1143a);
                    C0331in c0331in = n6.c;
                    X6 x6 = n6.f599a;
                    T6 t6 = x6.c;
                    U6 u6 = x6.d;
                    C0521qa c0521qa = new C0521qa(false);
                    c0521qa.a(112, new P3());
                    C0409ln c0409ln = new C0409ln("service database", hashMap);
                    c0331in.getClass();
                    c0114ac = new C0114ac(context, a2, new Z9(a2), new C0357jn(t6, u6, c0521qa, c0409ln));
                    this.d = c0114ac;
                }
            }
            C0596tb c0596tb2 = new C0596tb(c0114ac);
            this.b = c0596tb2;
            return c0596tb2;
        }
        return c0596tb;
    }
}
