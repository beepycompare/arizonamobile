package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.i5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0321i5 {

    /* renamed from: a  reason: collision with root package name */
    public final T5 f900a;
    public final C0148bd b;
    public final C0148bd c;

    public C0321i5(C0297h7 c0297h7, C0332ih c0332ih) {
        Je je = new Je(c0297h7);
        this.f900a = new T5(c0297h7);
        this.b = new C0148bd(je, new C0295h5(c0332ih));
        this.c = new C0148bd(je, C0269g5.f866a);
    }

    public final List<InterfaceC0118a9> a() {
        return CollectionsKt.listOf((Object[]) new InterfaceC0118a9[]{this.f900a, this.b});
    }

    public final List<InterfaceC0118a9> b() {
        return CollectionsKt.listOf(this.c);
    }
}
