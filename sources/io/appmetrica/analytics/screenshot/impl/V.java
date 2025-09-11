package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class V implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0776g f1307a;
    public final Z b;
    public final C0786q c;

    public V() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(T t) {
        N n = new N();
        C0774e c0774e = t.f1305a;
        n.f1302a = c0774e != null ? this.f1307a.fromModel(c0774e) : null;
        X x = t.b;
        n.b = x != null ? this.b.fromModel(x) : null;
        C0784o c0784o = t.c;
        n.c = c0784o != null ? this.c.fromModel(c0784o) : null;
        return n;
    }

    public V(C0776g c0776g, Z z, C0786q c0786q) {
        this.f1307a = c0776g;
        this.b = z;
        this.c = c0786q;
    }

    public /* synthetic */ V(C0776g c0776g, Z z, C0786q c0786q, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0776g() : c0776g, (i & 2) != 0 ? new Z() : z, (i & 4) != 0 ? new C0786q() : c0786q);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T toModel(N n) {
        C0774e c0774e;
        X x;
        K k = n.f1302a;
        if (k != null) {
            this.f1307a.getClass();
            c0774e = new C0774e(k.f1299a);
        } else {
            c0774e = null;
        }
        M m = n.b;
        if (m != null) {
            this.b.getClass();
            x = new X(m.f1301a, m.b);
        } else {
            x = null;
        }
        L l = n.c;
        return new T(c0774e, x, l != null ? this.c.toModel(l) : null);
    }
}
