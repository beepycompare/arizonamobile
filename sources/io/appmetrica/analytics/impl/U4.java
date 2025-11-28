package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class U4 {

    /* renamed from: a  reason: collision with root package name */
    public final E5 f716a;
    public final Lc b;
    public final Lc c;

    public U4(S6 s6, Vg vg) {
        C0749ze c0749ze = new C0749ze(s6);
        this.f716a = new E5(s6);
        this.b = new Lc(c0749ze, new T4(vg));
        this.c = new Lc(c0749ze, S4.f676a);
    }

    public final List<K8> a() {
        return CollectionsKt.listOf((Object[]) new K8[]{this.f716a, this.b});
    }

    public final List<K8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
