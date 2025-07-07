package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class V implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0780g f1284a;
    public final Z b;
    public final C0790q c;

    public V() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(T t) {
        N n = new N();
        C0778e c0778e = t.f1282a;
        n.f1279a = c0778e != null ? this.f1284a.fromModel(c0778e) : null;
        X x = t.b;
        n.b = x != null ? this.b.fromModel(x) : null;
        C0788o c0788o = t.c;
        n.c = c0788o != null ? this.c.fromModel(c0788o) : null;
        return n;
    }

    public V(C0780g c0780g, Z z, C0790q c0790q) {
        this.f1284a = c0780g;
        this.b = z;
        this.c = c0790q;
    }

    public /* synthetic */ V(C0780g c0780g, Z z, C0790q c0790q, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0780g() : c0780g, (i & 2) != 0 ? new Z() : z, (i & 4) != 0 ? new C0790q() : c0790q);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T toModel(N n) {
        C0778e c0778e;
        X x;
        K k = n.f1279a;
        if (k != null) {
            this.f1284a.getClass();
            c0778e = new C0778e(k.f1276a);
        } else {
            c0778e = null;
        }
        M m = n.b;
        if (m != null) {
            this.b.getClass();
            x = new X(m.f1278a, m.b);
        } else {
            x = null;
        }
        L l = n.c;
        return new T(c0778e, x, l != null ? this.c.toModel(l) : null);
    }
}
