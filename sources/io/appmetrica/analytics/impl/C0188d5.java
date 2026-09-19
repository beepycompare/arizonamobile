package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.d5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0188d5 {

    /* renamed from: a  reason: collision with root package name */
    public final N5 f940a;
    public final C0247fd b;
    public final C0247fd c;

    public C0188d5(C0164c7 c0164c7, C0277gh c0277gh) {
        Ue ue = new Ue(c0164c7);
        this.f940a = new N5(c0164c7);
        this.b = new C0247fd(ue, new C0162c5(c0277gh));
        this.c = new C0247fd(ue, C0136b5.f903a);
    }

    public final List<Z8> a() {
        return CollectionsKt.listOf((Object[]) new Z8[]{this.f940a, this.b});
    }

    public final List<Z8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
