package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.cc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0169cc {

    /* renamed from: a  reason: collision with root package name */
    public final Qg f941a;
    public final InterfaceC0546r9 b;
    public final C0467o4 c;
    public final We d;
    public final N4 e;
    public final C0649vc f = new C0649vc();
    public final Lazy g = LazyKt.lazy(new C0143bc(this));

    public C0169cc(L6 l6, Qg qg, InterfaceC0546r9 interfaceC0546r9, C0467o4 c0467o4, We we) {
        this.f941a = qg;
        this.b = interfaceC0546r9;
        this.c = c0467o4;
        this.d = we;
        this.e = new N4(l6, qg);
    }

    public final List<F8> a() {
        return this.e.a();
    }

    public final List<F8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((F8) this.g.getValue()));
    }
}
