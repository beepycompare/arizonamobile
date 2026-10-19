package io.appmetrica.analytics.impl;

import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.h  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0280h extends Ra {
    public final C0260g5 b;

    public C0280h(Li li, C0260g5 c0260g5) {
        super(li);
        this.b = c0260g5;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(List<AbstractC0298hh> list) {
        list.add(this.f748a.p);
        list.add(this.f748a.o);
        list.add(this.f748a.r);
        list.add(this.f748a.g);
        if (this.b.d()) {
            list.add(this.f748a.q);
        }
    }
}
