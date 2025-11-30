package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class O4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0715y5 f616a;
    public final Fc b;
    public final Fc c;

    public O4(M6 m6, Rg rg) {
        C0624ue c0624ue = new C0624ue(m6);
        this.f616a = new C0715y5(m6);
        this.b = new Fc(c0624ue, new N4(rg));
        this.c = new Fc(c0624ue, M4.f582a);
    }

    public final List<G8> a() {
        return CollectionsKt.listOf((Object[]) new G8[]{this.f616a, this.b});
    }

    public final List<G8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
