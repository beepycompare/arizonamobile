package io.appmetrica.analytics.impl;

import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.h  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0287h extends Ra {
    public final C0267g5 b;

    public C0287h(Li li, C0267g5 c0267g5) {
        super(li);
        this.b = c0267g5;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(List<AbstractC0305hh> list) {
        list.add(this.f743a.p);
        list.add(this.f743a.o);
        list.add(this.f743a.r);
        list.add(this.f743a.g);
        if (this.b.d()) {
            list.add(this.f743a.q);
        }
    }
}
