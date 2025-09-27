package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* renamed from: io.appmetrica.analytics.impl.p5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0502p5 {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList f1032a = new CopyOnWriteArrayList();

    public final void a(D4 d4) {
        this.f1032a.add(d4);
    }

    public final void b(D4 d4) {
        this.f1032a.remove(d4);
    }

    public final List<D4> a() {
        return this.f1032a;
    }
}
