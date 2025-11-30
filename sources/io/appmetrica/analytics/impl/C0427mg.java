package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.mg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0427mg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1012a = new HashSet();
    public C0477og b;
    public boolean c;
    public final xo d;
    public final Context e;

    public C0427mg(Context context, xo xoVar) {
        this.e = context;
        this.d = xoVar;
        this.b = xoVar.b();
        this.c = xoVar.c();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        Pa a2 = C0676wg.a(context, C0471oa.I.d.a());
        InterfaceC0601tg interfaceC0601tg = (InterfaceC0601tg) new C0247fg(this, new C0676wg(a2), new Aa(context), new C0701xg(context)).f.getValue();
        try {
            a2.a(interfaceC0601tg);
        } catch (Throwable th) {
            interfaceC0601tg.a(th);
        }
    }

    public final synchronized void a(C0527qg c0527qg) {
        this.f1012a.add(c0527qg);
        if (this.c) {
            c0527qg.a(this.b);
        }
    }

    public final synchronized void a(C0477og c0477og) {
        Iterator it = this.f1012a.iterator();
        while (it.hasNext()) {
            ((C0527qg) it.next()).a(c0477og);
        }
    }
}
