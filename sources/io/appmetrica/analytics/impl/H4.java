package io.appmetrica.analytics.impl;

import java.util.List;
/* loaded from: classes5.dex */
public final class H4 extends I4 {
    public H4(Li li) {
        super(li);
    }

    public final void a(Db db, List<AbstractC0305hh> list) {
        if (!Q9.h.contains(db)) {
            list.add(this.f590a.s);
        }
        if (Q9.b.contains(db)) {
            return;
        }
        list.add(this.f590a.c);
    }
}
