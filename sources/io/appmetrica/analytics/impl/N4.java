package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class N4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0693x5 f705a;
    public final Ec b;
    public final Ec c;

    public N4(L6 l6, Qg qg) {
        C0602te c0602te = new C0602te(l6);
        this.f705a = new C0693x5(l6);
        this.b = new Ec(c0602te, new M4(qg));
        this.c = new Ec(c0602te, L4.f671a);
    }

    public final List<F8> a() {
        return CollectionsKt.listOf((Object[]) new F8[]{this.f705a, this.b});
    }

    public final List<F8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
