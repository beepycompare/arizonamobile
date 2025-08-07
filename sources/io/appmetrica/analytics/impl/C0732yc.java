package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0732yc implements M9 {

    /* renamed from: a  reason: collision with root package name */
    public final F5 f1153a;

    public C0732yc(Q9 q9, C0279g7 c0279g7, C0212dh c0212dh, J4 j4, C0401l5 c0401l5, C0386kf c0386kf) {
        C0707xc c0707xc = new C0707xc(c0279g7, c0212dh, this, j4, c0386kf);
        this.f1153a = new F5(q9, c0707xc.a(), c0707xc.b(), c0401l5);
    }

    @Override // io.appmetrica.analytics.impl.M9
    public final L9 a() {
        return this.f1153a;
    }

    public final F5 b() {
        return this.f1153a;
    }
}
