package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0527qg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1075a = new HashSet();
    public C0576sg b;
    public boolean c;
    public final yo d;
    public final Context e;

    public C0527qg(Context context, yo yoVar) {
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
        Va a2 = Ag.a(context, C0620ua.H.d.a());
        InterfaceC0701xg interfaceC0701xg = (InterfaceC0701xg) new C0350jg(this, new Ag(a2), new Ga(context), new Bg(context)).f.getValue();
        try {
            a2.a(interfaceC0701xg);
        } catch (Throwable th) {
            interfaceC0701xg.a(th);
        }
    }

    public final synchronized void a(C0626ug c0626ug) {
        this.f1075a.add(c0626ug);
        if (this.c) {
            c0626ug.a(this.b);
        }
    }

    public final synchronized void a(C0576sg c0576sg) {
        Iterator it = this.f1075a.iterator();
        while (it.hasNext()) {
            ((C0626ug) it.next()).a(c0576sg);
        }
    }
}
