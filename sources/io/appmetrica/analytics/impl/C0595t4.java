package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.t4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0595t4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0546r7 f1214a;
    public Ub b;
    public Vb c;
    public Bc d;

    public C0595t4(File file) {
        this.f1214a = new C0546r7(file);
    }

    public final synchronized InterfaceC0343jb a(Context context) {
        Vb vb;
        vb = this.c;
        if (vb == null) {
            vb = new Vb(c(context));
            this.c = vb;
        }
        return vb;
    }

    public final synchronized InterfaceC0343jb b(Context context) {
        return c(context);
    }

    public final InterfaceC0343jb c(Context context) {
        Bc bc;
        Ub ub = this.b;
        if (ub == null) {
            synchronized (this) {
                bc = this.d;
                if (bc == null) {
                    C0546r7 c0546r7 = this.f1214a;
                    String a2 = new C0521q7(c0546r7.f1184a, c0546r7.b, true).a(context, new C0207e4());
                    C0185d7 c0185d7 = M5.c;
                    c0185d7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", J5.f611a);
                    In in = c0185d7.c;
                    C0443n7 c0443n7 = c0185d7.f945a;
                    C0339j7 c0339j7 = c0443n7.c;
                    C0365k7 c0365k7 = c0443n7.d;
                    Sa sa = new Sa(false);
                    sa.a(112, new C0233f4());
                    Ln ln = new Ln("service database", hashMap);
                    in.getClass();
                    bc = new Bc(context, a2, new C0627ua(a2), new Jn(c0339j7, c0365k7, sa, ln));
                    this.d = bc;
                }
            }
            Ub ub2 = new Ub("preferences", bc, C0569s4.l().c.b());
            this.b = ub2;
            return ub2;
        }
        return ub;
    }
}
