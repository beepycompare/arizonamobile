package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Ec {

    /* renamed from: a  reason: collision with root package name */
    public final C0277gh f529a;
    public final L9 b;
    public final F4 c;
    public final C0689wf d;
    public final C0188d5 e;
    public final Wc f = new Wc();
    public final Lazy g = LazyKt.lazy(new Dc(this));

    public Ec(C0164c7 c0164c7, C0277gh c0277gh, L9 l9, F4 f4, C0689wf c0689wf) {
        this.f529a = c0277gh;
        this.b = l9;
        this.c = f4;
        this.d = c0689wf;
        this.e = new C0188d5(c0164c7, c0277gh);
    }

    public final List<Z8> a() {
        return this.e.a();
    }

    public final List<Z8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((Z8) this.g.getValue()));
    }
}
