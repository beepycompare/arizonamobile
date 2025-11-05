package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.jc  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0346jc {

    /* renamed from: a  reason: collision with root package name */
    public final Vg f952a;
    public final InterfaceC0719y9 b;
    public final C0639v4 c;
    public final C0143bf d;
    public final U4 e;
    public final Cc f = new Cc();
    public final Lazy g = LazyKt.lazy(new C0321ic(this));

    public C0346jc(S6 s6, Vg vg, InterfaceC0719y9 interfaceC0719y9, C0639v4 c0639v4, C0143bf c0143bf) {
        this.f952a = vg;
        this.b = interfaceC0719y9;
        this.c = c0639v4;
        this.d = c0143bf;
        this.e = new U4(s6, vg);
    }

    public final List<K8> a() {
        return this.e.a();
    }

    public final List<K8> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((K8) this.g.getValue()));
    }
}
