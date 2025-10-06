package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Hg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f480a = new HashSet();
    public Jg b;
    public boolean c;
    public final Co d;
    public final Context e;

    public Hg(Context context, Co co) {
        this.e = context;
        this.d = co;
        this.b = co.b();
        this.c = co.c();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        InterfaceC0483ob a2 = Rg.a(context, Na.F.d.a());
        Og og = (Og) new Ag(this, new Rg(a2), new Za(context), new Sg(context)).f.getValue();
        try {
            a2.a(og);
        } catch (Throwable th) {
            og.a(th);
        }
    }

    public final synchronized void a(Lg lg) {
        this.f480a.add(lg);
        if (this.c) {
            lg.a(this.b);
        }
    }

    public final synchronized void a(Jg jg) {
        Iterator it = this.f480a.iterator();
        while (it.hasNext()) {
            ((Lg) it.next()).a(jg);
        }
    }
}
