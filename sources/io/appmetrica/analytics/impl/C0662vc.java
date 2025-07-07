package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.vc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0662vc {

    /* renamed from: a  reason: collision with root package name */
    public final C0167bh f1091a;
    public final J9 b;
    public final J4 c;
    public final Cif d;
    public final C0332i5 e;
    public final Oc f = new Oc();
    public final Lazy g = LazyKt.lazy(new C0637uc(this));

    public C0662vc(C0209d7 c0209d7, C0167bh c0167bh, J9 j9, J4 j4, Cif cif) {
        this.f1091a = c0167bh;
        this.b = j9;
        this.c = j4;
        this.d = cif;
        this.e = new C0332i5(c0209d7, c0167bh);
    }

    public final List<V8> a() {
        return this.e.a();
    }

    public final List<V8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((V8) this.g.getValue()));
    }
}
