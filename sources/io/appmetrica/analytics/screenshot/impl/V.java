package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes4.dex */
public final class V implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0774g f1289a;
    public final Z b;
    public final C0784q c;

    public V() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final N fromModel(T t) {
        N n = new N();
        C0772e c0772e = t.f1287a;
        n.f1284a = c0772e != null ? this.f1289a.fromModel(c0772e) : null;
        X x = t.b;
        n.b = x != null ? this.b.fromModel(x) : null;
        C0782o c0782o = t.c;
        n.c = c0782o != null ? this.c.fromModel(c0782o) : null;
        return n;
    }

    public V(C0774g c0774g, Z z, C0784q c0784q) {
        this.f1289a = c0774g;
        this.b = z;
        this.c = c0784q;
    }

    public /* synthetic */ V(C0774g c0774g, Z z, C0784q c0784q, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new C0774g() : c0774g, (i & 2) != 0 ? new Z() : z, (i & 4) != 0 ? new C0784q() : c0784q);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final T toModel(N n) {
        C0772e c0772e;
        X x;
        K k = n.f1284a;
        if (k != null) {
            this.f1289a.getClass();
            c0772e = new C0772e(k.f1281a);
        } else {
            c0772e = null;
        }
        M m = n.b;
        if (m != null) {
            this.b.getClass();
            x = new X(m.f1283a, m.b);
        } else {
            x = null;
        }
        L l = n.c;
        return new T(c0772e, x, l != null ? this.c.toModel(l) : null);
    }
}
