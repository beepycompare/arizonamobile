package io.appmetrica.analytics.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.i5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0324i5 {

    /* renamed from: a  reason: collision with root package name */
    public final Q5 f874a;
    public final Xc b;
    public final Xc c;

    public C0324i5(C0201d7 c0201d7, C0159bh c0159bh) {
        Fe fe = new Fe(c0201d7);
        this.f874a = new Q5(c0201d7);
        this.b = new Xc(fe, new C0299h5(c0159bh));
        this.c = new Xc(fe, C0274g5.f851a);
    }

    public final List<V8> a() {
        return CollectionsKt.listOf((Object[]) new V8[]{this.f874a, this.b});
    }

    public final List<V8> b() {
        return CollectionsKt.listOf(this.c);
    }
}
