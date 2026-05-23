package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Ec {

    /* renamed from: a  reason: collision with root package name */
    public final C0279gh f526a;
    public final L9 b;
    public final F4 c;
    public final C0691wf d;
    public final C0190d5 e;
    public final Wc f = new Wc();
    public final Lazy g = LazyKt.lazy(new Dc(this));

    public Ec(C0166c7 c0166c7, C0279gh c0279gh, L9 l9, F4 f4, C0691wf c0691wf) {
        this.f526a = c0279gh;
        this.b = l9;
        this.c = f4;
        this.d = c0691wf;
        this.e = new C0190d5(c0166c7, c0279gh);
    }

    public final List<Z8> a() {
        return this.e.a();
    }

    public final List<Z8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((Z8) this.g.getValue()));
    }
}
