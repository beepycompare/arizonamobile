package io.appmetrica.analytics.impl;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.zc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0754zc {

    /* renamed from: a  reason: collision with root package name */
    public final C0332ih f1179a;
    public final O9 b;
    public final J4 c;
    public final C0433mf d;
    public final C0321i5 e;
    public final Sc f = new Sc();
    public final Lazy g = LazyKt.lazy(new C0729yc(this));

    public C0754zc(C0297h7 c0297h7, C0332ih c0332ih, O9 o9, J4 j4, C0433mf c0433mf) {
        this.f1179a = c0332ih;
        this.b = o9;
        this.c = j4;
        this.d = c0433mf;
        this.e = new C0321i5(c0297h7, c0332ih);
    }

    public final List<InterfaceC0118a9> a() {
        return this.e.a();
    }

    public final List<InterfaceC0118a9> b() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.e.c), (Iterable) CollectionsKt.listOf((InterfaceC0118a9) this.g.getValue()));
    }
}
