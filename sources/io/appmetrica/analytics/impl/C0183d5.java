package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.d5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0183d5 {

    /* renamed from: a  reason: collision with root package name */
    public final N5 f943a;
    public final C0242fd b;
    public final C0242fd c;

    public C0183d5(C0159c7 c0159c7, C0272gh c0272gh) {
        Ue ue = new Ue(c0159c7);
        this.f943a = new N5(c0159c7);
        this.b = new C0242fd(ue, new C0157c5(c0272gh));
        this.c = new C0242fd(ue, C0131b5.f906a);
    }

    public final List<Z8> a() {
        return CollectionsKt.listOf((Object[]) new Z8[]{this.f943a, this.b});
    }

    public final List<Z8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
