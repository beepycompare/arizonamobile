package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Ec {

    /* renamed from: a  reason: collision with root package name */
    public final C0272gh f532a;
    public final L9 b;
    public final F4 c;
    public final C0684wf d;
    public final C0183d5 e;
    public final Wc f = new Wc();
    public final Lazy g = LazyKt.lazy(new Dc(this));

    public Ec(C0159c7 c0159c7, C0272gh c0272gh, L9 l9, F4 f4, C0684wf c0684wf) {
        this.f532a = c0272gh;
        this.b = l9;
        this.c = f4;
        this.d = c0684wf;
        this.e = new C0183d5(c0159c7, c0272gh);
    }

    public final List<Z8> a() {
        return this.e.a();
    }

    public final List<Z8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((Z8) this.g.getValue()));
    }
}
