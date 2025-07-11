package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.wg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0683wg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1107a = new HashSet();
    public C0733yg b;
    public boolean c;
    public final qo d;
    public final Context e;

    public C0683wg(Context context, qo qoVar) {
        this.e = context;
        this.d = qoVar;
        this.b = qoVar.b();
        this.c = qoVar.c();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        InterfaceC0305hb a2 = Gg.a(context, Ga.F.d.a());
        Dg dg = (Dg) new C0509pg(this, new Gg(a2), new Sa(context), new Hg(context)).f.getValue();
        try {
            a2.a(dg);
        } catch (Throwable th) {
            dg.a(th);
        }
    }

    public final synchronized void a(Ag ag) {
        this.f1107a.add(ag);
        if (this.c) {
            ag.a(this.b);
        }
    }

    public final synchronized void a(C0733yg c0733yg) {
        Iterator it = this.f1107a.iterator();
        while (it.hasNext()) {
            ((Ag) it.next()).a(c0733yg);
        }
    }
}
