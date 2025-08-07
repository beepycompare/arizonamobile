package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class V implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0775g f1288a;
    public final Z b;
    public final C0785q c;

    public V() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(T t) {
        N n = new N();
        C0773e c0773e = t.f1286a;
        n.f1283a = c0773e != null ? this.f1288a.fromModel(c0773e) : null;
        X x = t.b;
        n.b = x != null ? this.b.fromModel(x) : null;
        C0783o c0783o = t.c;
        n.c = c0783o != null ? this.c.fromModel(c0783o) : null;
        return n;
    }

    public V(C0775g c0775g, Z z, C0785q c0785q) {
        this.f1288a = c0775g;
        this.b = z;
        this.c = c0785q;
    }

    public /* synthetic */ V(C0775g c0775g, Z z, C0785q c0785q, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0775g() : c0775g, (i & 2) != 0 ? new Z() : z, (i & 4) != 0 ? new C0785q() : c0785q);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T toModel(N n) {
        C0773e c0773e;
        X x;
        K k = n.f1283a;
        if (k != null) {
            this.f1288a.getClass();
            c0773e = new C0773e(k.f1280a);
        } else {
            c0773e = null;
        }
        M m = n.b;
        if (m != null) {
            this.b.getClass();
            x = new X(m.f1282a, m.b);
        } else {
            x = null;
        }
        L l = n.c;
        return new T(c0773e, x, l != null ? this.c.toModel(l) : null);
    }
}
