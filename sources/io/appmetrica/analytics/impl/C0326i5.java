package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.i5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0326i5 {

    /* renamed from: a  reason: collision with root package name */
    public final T5 f895a;
    public final Zc b;
    public final Zc c;

    public C0326i5(C0278g7 c0278g7, C0211dh c0211dh) {
        He he = new He(c0278g7);
        this.f895a = new T5(c0278g7);
        this.b = new Zc(he, new C0301h5(c0211dh));
        this.c = new Zc(he, C0276g5.f859a);
    }

    public final List<Y8> a() {
        return CollectionsKt.listOf((Object[]) new Y8[]{this.f895a, this.b});
    }

    public final List<Y8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
