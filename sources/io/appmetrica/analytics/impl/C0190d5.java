package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.d5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0190d5 {

    /* renamed from: a  reason: collision with root package name */
    public final N5 f937a;
    public final C0249fd b;
    public final C0249fd c;

    public C0190d5(C0166c7 c0166c7, C0279gh c0279gh) {
        Ue ue = new Ue(c0166c7);
        this.f937a = new N5(c0166c7);
        this.b = new C0249fd(ue, new C0164c5(c0279gh));
        this.c = new C0249fd(ue, C0138b5.f900a);
    }

    public final List<Z8> a() {
        return CollectionsKt.listOf((Object[]) new Z8[]{this.f937a, this.b});
    }

    public final List<Z8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
