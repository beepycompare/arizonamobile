package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class N4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0692x5 f704a;
    public final Ec b;
    public final Ec c;

    public N4(L6 l6, Qg qg) {
        C0601te c0601te = new C0601te(l6);
        this.f704a = new C0692x5(l6);
        this.b = new Ec(c0601te, new M4(qg));
        this.c = new Ec(c0601te, L4.f670a);
    }

    public final List<F8> a() {
        return CollectionsKt.listOf((Object[]) new F8[]{this.f704a, this.b});
    }

    public final List<F8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
