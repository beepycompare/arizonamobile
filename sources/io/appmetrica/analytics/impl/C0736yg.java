package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.yg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0736yg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1155a = new HashSet();
    public Ag b;
    public boolean c;
    public final to d;
    public final Context e;

    public C0736yg(Context context, to toVar) {
        this.e = context;
        this.d = toVar;
        this.b = toVar.b();
        this.c = toVar.c();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        InterfaceC0357jb a2 = Ig.a(context, Ia.F.d.a());
        Fg fg = (Fg) new C0561rg(this, new Ig(a2), new Ua(context), new Jg(context)).f.getValue();
        try {
            a2.a(fg);
        } catch (Throwable th) {
            fg.a(th);
        }
    }

    public final synchronized void a(Cg cg) {
        this.f1155a.add(cg);
        if (this.c) {
            cg.a(this.b);
        }
    }

    public final synchronized void a(Ag ag) {
        Iterator it = this.f1155a.iterator();
        while (it.hasNext()) {
            ((Cg) it.next()).a(ag);
        }
    }
}
