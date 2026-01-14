package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class Y implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0768g f1460a;
    public final c0 b;
    public final r c;

    public Y() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Q fromModel(W w) {
        Q q = new Q();
        C0766e c0766e = w.f1458a;
        q.f1455a = c0766e != null ? this.f1460a.fromModel(c0766e) : null;
        a0 a0Var = w.b;
        q.b = a0Var != null ? this.b.fromModel(a0Var) : null;
        C0777p c0777p = w.c;
        q.c = c0777p != null ? this.c.fromModel(c0777p) : null;
        return q;
    }

    public Y(C0768g c0768g, c0 c0Var, r rVar) {
        this.f1460a = c0768g;
        this.b = c0Var;
        this.c = rVar;
    }

    public /* synthetic */ Y(C0768g c0768g, c0 c0Var, r rVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0768g() : c0768g, (i & 2) != 0 ? new c0() : c0Var, (i & 4) != 0 ? new r() : rVar);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final W toModel(Q q) {
        C0766e c0766e;
        a0 a0Var;
        N n = q.f1455a;
        if (n != null) {
            this.f1460a.getClass();
            c0766e = new C0766e(n.f1452a);
        } else {
            c0766e = null;
        }
        P p = q.b;
        if (p != null) {
            this.b.getClass();
            a0Var = new a0(p.f1454a, p.b);
        } else {
            a0Var = null;
        }
        O o = q.c;
        return new W(c0766e, a0Var, o != null ? this.c.toModel(o) : null);
    }
}
