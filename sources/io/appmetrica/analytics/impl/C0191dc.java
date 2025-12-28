package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.dc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0191dc {

    /* renamed from: a  reason: collision with root package name */
    public final Rg f947a;
    public final InterfaceC0568s9 b;
    public final C0489p4 c;
    public final Xe d;
    public final O4 e;
    public final C0671wc f = new C0671wc();
    public final Lazy g = LazyKt.lazy(new C0165cc(this));

    public C0191dc(M6 m6, Rg rg, InterfaceC0568s9 interfaceC0568s9, C0489p4 c0489p4, Xe xe) {
        this.f947a = rg;
        this.b = interfaceC0568s9;
        this.c = c0489p4;
        this.d = xe;
        this.e = new O4(m6, rg);
    }

    public final List<G8> a() {
        return this.e.a();
    }

    public final List<G8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((G8) this.g.getValue()));
    }
}
