package io.appmetrica.analytics.impl;

import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.h  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0286h extends Ra {
    public final C0266g5 b;

    public C0286h(Li li, C0266g5 c0266g5) {
        super(li);
        this.b = c0266g5;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(List<AbstractC0304hh> list) {
        list.add(this.f745a.p);
        list.add(this.f745a.o);
        list.add(this.f745a.r);
        list.add(this.f745a.g);
        if (this.b.d()) {
            list.add(this.f745a.q);
        }
    }
}
