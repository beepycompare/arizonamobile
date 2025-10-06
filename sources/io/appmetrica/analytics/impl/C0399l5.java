package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.l5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0399l5 {

    /* renamed from: a  reason: collision with root package name */
    public final W5 f965a;
    public final C0226ed b;
    public final C0226ed c;

    public C0399l5(C0375k7 c0375k7, C0437mh c0437mh) {
        Ne ne = new Ne(c0375k7);
        this.f965a = new W5(c0375k7);
        this.b = new C0226ed(ne, new C0373k5(c0437mh));
        this.c = new C0226ed(ne, C0347j5.f934a);
    }

    public final List<InterfaceC0197d9> a() {
        return CollectionsKt.listOf((Object[]) new InterfaceC0197d9[]{this.f965a, this.b});
    }

    public final List<InterfaceC0197d9> b() {
        return CollectionsKt.listOf(this.c);
    }
}
