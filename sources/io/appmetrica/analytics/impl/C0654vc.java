package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.vc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0654vc {

    /* renamed from: a  reason: collision with root package name */
    public final C0159bh f1092a;
    public final J9 b;
    public final J4 c;
    public final Cif d;
    public final C0324i5 e;
    public final Oc f = new Oc();
    public final Lazy g = LazyKt.lazy(new C0629uc(this));

    public C0654vc(C0201d7 c0201d7, C0159bh c0159bh, J9 j9, J4 j4, Cif cif) {
        this.f1092a = c0159bh;
        this.b = j9;
        this.c = j4;
        this.d = cif;
        this.e = new C0324i5(c0201d7, c0159bh);
    }

    public final List<V8> a() {
        return this.e.a();
    }

    public final List<V8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((V8) this.g.getValue()));
    }
}
