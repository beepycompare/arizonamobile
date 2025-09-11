package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Yg implements InterfaceC0427m8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0676w5 f757a;

    public Yg(InterfaceC0676w5 interfaceC0676w5) {
        this.f757a = interfaceC0676w5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0427m8
    /* renamed from: b */
    public final Xg a(Context context, C0476o5 c0476o5, N4 n4) {
        return new Xg(context, c0476o5, n4, this.f757a, new C0502p5(), Ql.a());
    }

    public final InterfaceC0676w5 a() {
        return this.f757a;
    }
}
