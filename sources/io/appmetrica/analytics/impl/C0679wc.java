package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.wc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0679wc implements J9 {

    /* renamed from: a  reason: collision with root package name */
    public final D5 f1105a;

    public C0679wc(N9 n9, C0201d7 c0201d7, C0159bh c0159bh, J4 j4, C0398l5 c0398l5, Cif cif) {
        C0654vc c0654vc = new C0654vc(c0201d7, c0159bh, this, j4, cif);
        this.f1105a = new D5(n9, c0654vc.a(), c0654vc.b(), c0398l5);
    }

    @Override // io.appmetrica.analytics.impl.J9
    public final I9 a() {
        return this.f1105a;
    }

    public final D5 b() {
        return this.f1105a;
    }
}
