package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.l5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0398l5 {

    /* renamed from: a  reason: collision with root package name */
    public final W5 f960a;
    public final C0225ed b;
    public final C0225ed c;

    public C0398l5(C0374k7 c0374k7, C0436mh c0436mh) {
        Ne ne = new Ne(c0374k7);
        this.f960a = new W5(c0374k7);
        this.b = new C0225ed(ne, new C0372k5(c0436mh));
        this.c = new C0225ed(ne, C0346j5.f929a);
    }

    public final List<InterfaceC0196d9> a() {
        return CollectionsKt.listOf((Object[]) new InterfaceC0196d9[]{this.f960a, this.b});
    }

    public final List<InterfaceC0196d9> b() {
        return CollectionsKt.listOf(this.c);
    }
}
