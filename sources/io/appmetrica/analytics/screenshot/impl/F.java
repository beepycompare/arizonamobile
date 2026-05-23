package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes5.dex */
public final class F implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0784f f1432a;
    public final I b;
    public final C0793o c;

    public F() {
        this(null, null, null, 7, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final A fromModel(P p) {
        A a2 = new A();
        a2.f1429a = p.f1440a;
        z zVar = new z();
        N n = p.b;
        zVar.f1463a = n != null ? this.f1432a.fromModel(n) : null;
        U u = p.c;
        zVar.b = u != null ? this.b.fromModel(u) : null;
        O o = p.d;
        zVar.c = o != null ? this.c.fromModel(o) : null;
        a2.b = zVar;
        return a2;
    }

    public F(C0784f c0784f, I i, C0793o c0793o) {
        this.f1432a = c0784f;
        this.b = i;
        this.c = c0793o;
    }

    public /* synthetic */ F(C0784f c0784f, I i, C0793o c0793o, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new C0784f() : c0784f, (i2 & 2) != 0 ? new I() : i, (i2 & 4) != 0 ? new C0793o() : c0793o);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final P toModel(A a2) {
        N n;
        U u;
        x xVar;
        y yVar;
        w wVar;
        boolean z = a2.f1429a;
        z zVar = a2.b;
        O o = null;
        if (zVar == null || (wVar = zVar.f1463a) == null) {
            n = null;
        } else {
            this.f1432a.getClass();
            n = new N(wVar.f1460a);
        }
        z zVar2 = a2.b;
        if (zVar2 == null || (yVar = zVar2.b) == null) {
            u = null;
        } else {
            this.b.getClass();
            u = new U(yVar.f1462a, yVar.b);
        }
        z zVar3 = a2.b;
        if (zVar3 != null && (xVar = zVar3.c) != null) {
            o = this.c.toModel(xVar);
        }
        return new P(z, n, u, o);
    }
}
