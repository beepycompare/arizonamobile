package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Ec {

    /* renamed from: a  reason: collision with root package name */
    public final C0278gh f529a;
    public final L9 b;
    public final F4 c;
    public final C0690wf d;
    public final C0189d5 e;
    public final Wc f = new Wc();
    public final Lazy g = LazyKt.lazy(new Dc(this));

    public Ec(C0165c7 c0165c7, C0278gh c0278gh, L9 l9, F4 f4, C0690wf c0690wf) {
        this.f529a = c0278gh;
        this.b = l9;
        this.c = f4;
        this.d = c0690wf;
        this.e = new C0189d5(c0165c7, c0278gh);
    }

    public final List<Z8> a() {
        return this.e.a();
    }

    public final List<Z8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((Z8) this.g.getValue()));
    }
}
