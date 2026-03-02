package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0767g f1459a;
    public final c0 b;
    public final r c;

    public Y() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Q fromModel(W w) {
        Q q = new Q();
        C0765e c0765e = w.f1457a;
        q.f1454a = c0765e != null ? this.f1459a.fromModel(c0765e) : null;
        a0 a0Var = w.b;
        q.b = a0Var != null ? this.b.fromModel(a0Var) : null;
        C0776p c0776p = w.c;
        q.c = c0776p != null ? this.c.fromModel(c0776p) : null;
        return q;
    }

    public Y(C0767g c0767g, c0 c0Var, r rVar) {
        this.f1459a = c0767g;
        this.b = c0Var;
        this.c = rVar;
    }

    public /* synthetic */ Y(C0767g c0767g, c0 c0Var, r rVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0767g() : c0767g, (i & 2) != 0 ? new c0() : c0Var, (i & 4) != 0 ? new r() : rVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final W toModel(Q q) {
        C0765e c0765e;
        a0 a0Var;
        N n = q.f1454a;
        if (n != null) {
            this.f1459a.getClass();
            c0765e = new C0765e(n.f1451a);
        } else {
            c0765e = null;
        }
        P p = q.b;
        if (p != null) {
            this.b.getClass();
            a0Var = new a0(p.f1453a, p.b);
        } else {
            a0Var = null;
        }
        O o = q.c;
        return new W(c0765e, a0Var, o != null ? this.c.toModel(o) : null);
    }
}
