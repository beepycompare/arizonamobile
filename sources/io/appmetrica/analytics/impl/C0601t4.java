package io.appmetrica.analytics.impl;

import android.content.Context;
import java.io.File;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.t4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0601t4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0552r7 f1211a;
    public Ub b;
    public Vb c;
    public Bc d;

    public C0601t4(File file) {
        this.f1211a = new C0552r7(file);
    }

    public final synchronized InterfaceC0349jb a(Context context) {
        Vb vb;
        vb = this.c;
        if (vb == null) {
            vb = new Vb(c(context));
            this.c = vb;
        }
        return vb;
    }

    public final synchronized InterfaceC0349jb b(Context context) {
        return c(context);
    }

    public final InterfaceC0349jb c(Context context) {
        Bc bc;
        Ub ub = this.b;
        if (ub == null) {
            synchronized (this) {
                bc = this.d;
                if (bc == null) {
                    C0552r7 c0552r7 = this.f1211a;
                    String a2 = new C0527q7(c0552r7.f1181a, c0552r7.b, true).a(context, new C0213e4());
                    C0191d7 c0191d7 = M5.c;
                    c0191d7.getClass();
                    HashMap hashMap = new HashMap();
                    hashMap.put("preferences", J5.f608a);
                    In in = c0191d7.c;
                    C0449n7 c0449n7 = c0191d7.f942a;
                    C0345j7 c0345j7 = c0449n7.c;
                    C0371k7 c0371k7 = c0449n7.d;
                    Sa sa = new Sa(false);
                    sa.a(112, new C0239f4());
                    Ln ln = new Ln("service database", hashMap);
                    in.getClass();
                    bc = new Bc(context, a2, new C0633ua(a2), new Jn(c0345j7, c0371k7, sa, ln));
                    this.d = bc;
                }
            }
            Ub ub2 = new Ub("preferences", bc, C0575s4.l().c.b());
            this.b = ub2;
            return ub2;
        }
        return ub;
    }
}
