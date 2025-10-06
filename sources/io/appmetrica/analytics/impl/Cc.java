package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Cc {

    /* renamed from: a  reason: collision with root package name */
    public final C0437mh f390a;
    public final R9 b;
    public final M4 c;
    public final C0538qf d;
    public final C0399l5 e;
    public final Vc f = new Vc();
    public final Lazy g = LazyKt.lazy(new Bc(this));

    public Cc(C0375k7 c0375k7, C0437mh c0437mh, R9 r9, M4 m4, C0538qf c0538qf) {
        this.f390a = c0437mh;
        this.b = r9;
        this.c = m4;
        this.d = c0538qf;
        this.e = new C0399l5(c0375k7, c0437mh);
    }

    public final List<InterfaceC0197d9> a() {
        return this.e.a();
    }

    public final List<InterfaceC0197d9> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((InterfaceC0197d9) this.g.getValue()));
    }
}
