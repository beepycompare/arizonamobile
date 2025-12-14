package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class O4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0714y5 f713a;
    public final Fc b;
    public final Fc c;

    public O4(M6 m6, Rg rg) {
        C0623ue c0623ue = new C0623ue(m6);
        this.f713a = new C0714y5(m6);
        this.b = new Fc(c0623ue, new N4(rg));
        this.c = new Fc(c0623ue, M4.f679a);
    }

    public final List<G8> a() {
        return CollectionsKt.listOf((Object[]) new G8[]{this.f713a, this.b});
    }

    public final List<G8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
