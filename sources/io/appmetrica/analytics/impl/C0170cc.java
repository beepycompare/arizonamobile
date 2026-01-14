package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.cc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0170cc {

    /* renamed from: a  reason: collision with root package name */
    public final Qg f937a;
    public final InterfaceC0547r9 b;
    public final C0468o4 c;
    public final We d;
    public final N4 e;
    public final C0650vc f = new C0650vc();
    public final Lazy g = LazyKt.lazy(new C0144bc(this));

    public C0170cc(L6 l6, Qg qg, InterfaceC0547r9 interfaceC0547r9, C0468o4 c0468o4, We we) {
        this.f937a = qg;
        this.b = interfaceC0547r9;
        this.c = c0468o4;
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
