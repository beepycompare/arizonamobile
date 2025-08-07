package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.i5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0327i5 {

    /* renamed from: a  reason: collision with root package name */
    public final T5 f895a;
    public final Zc b;
    public final Zc c;

    public C0327i5(C0279g7 c0279g7, C0212dh c0212dh) {
        He he = new He(c0279g7);
        this.f895a = new T5(c0279g7);
        this.b = new Zc(he, new C0302h5(c0212dh));
        this.c = new Zc(he, C0277g5.f859a);
    }

    public final List<Y8> a() {
        return CollectionsKt.listOf((Object[]) new Y8[]{this.f895a, this.b});
    }

    public final List<Y8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
