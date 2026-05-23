package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.t4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0602t4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0553r7 f1208a;
    public Ub b;
    public Vb c;
    public Bc d;

    public C0602t4(File file) {
        this.f1208a = new C0553r7(file);
    }

    public final synchronized InterfaceC0350jb a(Context context) {
        Vb vb;
        vb = this.c;
        if (vb == null) {
            vb = new Vb(c(context));
            this.c = vb;
        }
        return vb;
    }

    public final synchronized InterfaceC0350jb b(Context context) {
        return c(context);
    }

    public final InterfaceC0350jb c(Context context) {
        Bc bc;
        Ub ub = this.b;
        if (ub == null) {
            synchronized (this) {
                bc = this.d;
                if (bc == null) {
                    C0553r7 c0553r7 = this.f1208a;
                    String a2 = new C0528q7(c0553r7.f1178a, c0553r7.b, true).a(context, new C0214e4());
                    C0192d7 c0192d7 = M5.c;
                    c0192d7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", J5.f605a);
                    In in = c0192d7.c;
                    C0450n7 c0450n7 = c0192d7.f939a;
                    C0346j7 c0346j7 = c0450n7.c;
                    C0372k7 c0372k7 = c0450n7.d;
                    Sa sa = new Sa(false);
                    sa.a(112, new C0240f4());
                    Ln ln = new Ln("service database", hashMap);
                    in.getClass();
                    bc = new Bc(context, a2, new C0634ua(a2), new Jn(c0346j7, c0372k7, sa, ln));
                    this.d = bc;
                }
            }
            Ub ub2 = new Ub("preferences", bc, C0576s4.l().c.b());
            this.b = ub2;
            return ub2;
        }
        return ub;
    }
}
