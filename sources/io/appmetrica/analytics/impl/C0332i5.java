package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.i5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0332i5 {

    /* renamed from: a  reason: collision with root package name */
    public final Q5 f873a;
    public final Xc b;
    public final Xc c;

    public C0332i5(C0209d7 c0209d7, C0167bh c0167bh) {
        Fe fe = new Fe(c0209d7);
        this.f873a = new Q5(c0209d7);
        this.b = new Xc(fe, new C0307h5(c0167bh));
        this.c = new Xc(fe, C0282g5.f850a);
    }

    public final List<V8> a() {
        return CollectionsKt.listOf((Object[]) new V8[]{this.f873a, this.b});
    }

    public final List<V8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
