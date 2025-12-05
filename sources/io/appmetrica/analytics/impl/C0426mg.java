package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.mg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0426mg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1095a = new HashSet();
    public C0476og b;
    public boolean c;
    public final xo d;
    public final Context e;

    public C0426mg(Context context, xo xoVar) {
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
        Pa a2 = C0675wg.a(context, C0470oa.I.d.a());
        InterfaceC0600tg interfaceC0600tg = (InterfaceC0600tg) new C0246fg(this, new C0675wg(a2), new Aa(context), new C0700xg(context)).f.getValue();
        try {
            a2.a(interfaceC0600tg);
        } catch (Throwable th) {
            interfaceC0600tg.a(th);
        }
    }

    public final synchronized void a(C0526qg c0526qg) {
        this.f1095a.add(c0526qg);
        if (this.c) {
            c0526qg.a(this.b);
        }
    }

    public final synchronized void a(C0476og c0476og) {
        Iterator it = this.f1095a.iterator();
        while (it.hasNext()) {
            ((C0526qg) it.next()).a(c0476og);
        }
    }
}
