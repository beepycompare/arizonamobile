package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Dg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f398a = new HashSet();
    public Fg b;
    public boolean c;
    public final yo d;
    public final Context e;

    public Dg(Context context, yo yoVar) {
        this.e = context;
        this.d = yoVar;
        this.b = yoVar.b();
        this.c = yoVar.c();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        InterfaceC0404lb a2 = Ng.a(context, Ka.F.d.a());
        Kg kg = (Kg) new C0683wg(this, new Ng(a2), new Wa(context), new Og(context)).f.getValue();
        try {
            a2.a(kg);
        } catch (Throwable th) {
            kg.a(th);
        }
    }

    public final synchronized void a(Hg hg) {
        this.f398a.add(hg);
        if (this.c) {
            hg.a(this.b);
        }
    }

    public final synchronized void a(Fg fg) {
        Iterator it = this.f398a.iterator();
        while (it.hasNext()) {
            ((Hg) it.next()).a(fg);
        }
    }
}
