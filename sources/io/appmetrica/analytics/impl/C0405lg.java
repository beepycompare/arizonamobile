package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0405lg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1100a = new HashSet();
    public C0455ng b;
    public boolean c;
    public final wo d;
    public final Context e;

    public C0405lg(Context context, wo woVar) {
        this.e = context;
        this.d = woVar;
        this.b = woVar.b();
        this.c = woVar.c();
    }

    public final void a() {
        if (this.c) {
            return;
        }
        Context context = this.e;
        Oa a2 = C0654vg.a(context, C0449na.I.d.a());
        InterfaceC0579sg interfaceC0579sg = (InterfaceC0579sg) new C0225eg(this, new C0654vg(a2), new C0748za(context), new C0679wg(context)).f.getValue();
        try {
            a2.a(interfaceC0579sg);
        } catch (Throwable th) {
            interfaceC0579sg.a(th);
        }
    }

    public final synchronized void a(C0505pg c0505pg) {
        this.f1100a.add(c0505pg);
        if (this.c) {
            c0505pg.a(this.b);
        }
    }

    public final synchronized void a(C0455ng c0455ng) {
        Iterator it = this.f1100a.iterator();
        while (it.hasNext()) {
            ((C0505pg) it.next()).a(c0455ng);
        }
    }
}
