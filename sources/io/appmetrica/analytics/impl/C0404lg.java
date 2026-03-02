package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0404lg {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1099a = new HashSet();
    public C0454ng b;
    public boolean c;
    public final wo d;
    public final Context e;

    public C0404lg(Context context, wo woVar) {
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
        Oa a2 = C0653vg.a(context, C0448na.I.d.a());
        InterfaceC0578sg interfaceC0578sg = (InterfaceC0578sg) new C0224eg(this, new C0653vg(a2), new C0747za(context), new C0678wg(context)).f.getValue();
        try {
            a2.a(interfaceC0578sg);
        } catch (Throwable th) {
            interfaceC0578sg.a(th);
        }
    }

    public final synchronized void a(C0504pg c0504pg) {
        this.f1099a.add(c0504pg);
        if (this.c) {
            c0504pg.a(this.b);
        }
    }

    public final synchronized void a(C0454ng c0454ng) {
        Iterator it = this.f1099a.iterator();
        while (it.hasNext()) {
            ((C0504pg) it.next()).a(c0454ng);
        }
    }
}
