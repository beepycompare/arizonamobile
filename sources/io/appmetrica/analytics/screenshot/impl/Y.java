package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes3.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0765g f1351a;
    public final c0 b;
    public final r c;

    public Y() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Q fromModel(W w) {
        Q q = new Q();
        C0763e c0763e = w.f1349a;
        q.f1346a = c0763e != null ? this.f1351a.fromModel(c0763e) : null;
        a0 a0Var = w.b;
        q.b = a0Var != null ? this.b.fromModel(a0Var) : null;
        C0774p c0774p = w.c;
        q.c = c0774p != null ? this.c.fromModel(c0774p) : null;
        return q;
    }

    public Y(C0765g c0765g, c0 c0Var, r rVar) {
        this.f1351a = c0765g;
        this.b = c0Var;
        this.c = rVar;
    }

    public /* synthetic */ Y(C0765g c0765g, c0 c0Var, r rVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0765g() : c0765g, (i & 2) != 0 ? new c0() : c0Var, (i & 4) != 0 ? new r() : rVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final W toModel(Q q) {
        C0763e c0763e;
        a0 a0Var;
        N n = q.f1346a;
        if (n != null) {
            this.f1351a.getClass();
            c0763e = new C0763e(n.f1343a);
        } else {
            c0763e = null;
        }
        P p = q.b;
        if (p != null) {
            this.b.getClass();
            a0Var = new a0(p.f1345a, p.b);
        } else {
            a0Var = null;
        }
        O o = q.c;
        return new W(c0763e, a0Var, o != null ? this.c.toModel(o) : null);
    }
}
