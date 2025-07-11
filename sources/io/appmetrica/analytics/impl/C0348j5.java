package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.j5  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0348j5 implements J9 {

    /* renamed from: a  reason: collision with root package name */
    public final D5 f889a;

    public C0348j5(N9 n9, C0201d7 c0201d7, C0159bh c0159bh, C0398l5 c0398l5) {
        C0324i5 c0324i5 = new C0324i5(c0201d7, c0159bh);
        this.f889a = new D5(n9, c0324i5.a(), c0324i5.b(), c0398l5);
    }

    @Override // io.appmetrica.analytics.impl.J9
    public final I9 a() {
        return this.f889a;
    }

    public final D5 b() {
        return this.f889a;
    }
}
