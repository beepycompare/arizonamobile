package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0764g f1450a;
    public final c0 b;
    public final r c;

    public Y() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Q fromModel(W w) {
        Q q = new Q();
        C0762e c0762e = w.f1448a;
        q.f1445a = c0762e != null ? this.f1450a.fromModel(c0762e) : null;
        a0 a0Var = w.b;
        q.b = a0Var != null ? this.b.fromModel(a0Var) : null;
        C0773p c0773p = w.c;
        q.c = c0773p != null ? this.c.fromModel(c0773p) : null;
        return q;
    }

    public Y(C0764g c0764g, c0 c0Var, r rVar) {
        this.f1450a = c0764g;
        this.b = c0Var;
        this.c = rVar;
    }

    public /* synthetic */ Y(C0764g c0764g, c0 c0Var, r rVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0764g() : c0764g, (i & 2) != 0 ? new c0() : c0Var, (i & 4) != 0 ? new r() : rVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final W toModel(Q q) {
        C0762e c0762e;
        a0 a0Var;
        N n = q.f1445a;
        if (n != null) {
            this.f1450a.getClass();
            c0762e = new C0762e(n.f1442a);
        } else {
            c0762e = null;
        }
        P p = q.b;
        if (p != null) {
            this.b.getClass();
            a0Var = new a0(p.f1444a, p.b);
        } else {
            a0Var = null;
        }
        O o = q.c;
        return new W(c0762e, a0Var, o != null ? this.c.toModel(o) : null);
    }
}
