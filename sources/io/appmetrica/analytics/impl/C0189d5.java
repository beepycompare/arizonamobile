package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.d5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0189d5 {

    /* renamed from: a  reason: collision with root package name */
    public final N5 f940a;
    public final C0248fd b;
    public final C0248fd c;

    public C0189d5(C0165c7 c0165c7, C0278gh c0278gh) {
        Ue ue = new Ue(c0165c7);
        this.f940a = new N5(c0165c7);
        this.b = new C0248fd(ue, new C0163c5(c0278gh));
        this.c = new C0248fd(ue, C0137b5.f903a);
    }

    public final List<Z8> a() {
        return CollectionsKt.listOf((Object[]) new Z8[]{this.f940a, this.b});
    }

    public final List<Z8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
