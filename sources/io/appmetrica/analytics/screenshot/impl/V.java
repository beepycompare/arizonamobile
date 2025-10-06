package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class V implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0777g f1308a;
    public final Z b;
    public final C0787q c;

    public V() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(T t) {
        N n = new N();
        C0775e c0775e = t.f1306a;
        n.f1303a = c0775e != null ? this.f1308a.fromModel(c0775e) : null;
        X x = t.b;
        n.b = x != null ? this.b.fromModel(x) : null;
        C0785o c0785o = t.c;
        n.c = c0785o != null ? this.c.fromModel(c0785o) : null;
        return n;
    }

    public V(C0777g c0777g, Z z, C0787q c0787q) {
        this.f1308a = c0777g;
        this.b = z;
        this.c = c0787q;
    }

    public /* synthetic */ V(C0777g c0777g, Z z, C0787q c0787q, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0777g() : c0777g, (i & 2) != 0 ? new Z() : z, (i & 4) != 0 ? new C0787q() : c0787q);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T toModel(N n) {
        C0775e c0775e;
        X x;
        K k = n.f1303a;
        if (k != null) {
            this.f1308a.getClass();
            c0775e = new C0775e(k.f1300a);
        } else {
            c0775e = null;
        }
        M m = n.b;
        if (m != null) {
            this.b.getClass();
            x = new X(m.f1302a, m.b);
        } else {
            x = null;
        }
        L l = n.c;
        return new T(c0775e, x, l != null ? this.c.toModel(l) : null);
    }
}
