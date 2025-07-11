package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class V implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0772g f1285a;
    public final Z b;
    public final C0782q c;

    public V() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(T t) {
        N n = new N();
        C0770e c0770e = t.f1283a;
        n.f1280a = c0770e != null ? this.f1285a.fromModel(c0770e) : null;
        X x = t.b;
        n.b = x != null ? this.b.fromModel(x) : null;
        C0780o c0780o = t.c;
        n.c = c0780o != null ? this.c.fromModel(c0780o) : null;
        return n;
    }

    public V(C0772g c0772g, Z z, C0782q c0782q) {
        this.f1285a = c0772g;
        this.b = z;
        this.c = c0782q;
    }

    public /* synthetic */ V(C0772g c0772g, Z z, C0782q c0782q, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0772g() : c0772g, (i & 2) != 0 ? new Z() : z, (i & 4) != 0 ? new C0782q() : c0782q);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T toModel(N n) {
        C0770e c0770e;
        X x;
        K k = n.f1280a;
        if (k != null) {
            this.f1285a.getClass();
            c0770e = new C0770e(k.f1277a);
        } else {
            c0770e = null;
        }
        M m = n.b;
        if (m != null) {
            this.b.getClass();
            x = new X(m.f1279a, m.b);
        } else {
            x = null;
        }
        L l = n.c;
        return new T(c0770e, x, l != null ? this.c.toModel(l) : null);
    }
}
