package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Yg implements InterfaceC0428m8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0677w5 f758a;

    public Yg(InterfaceC0677w5 interfaceC0677w5) {
        this.f758a = interfaceC0677w5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0428m8
    /* renamed from: b */
    public final Xg a(Context context, C0477o5 c0477o5, N4 n4) {
        return new Xg(context, c0477o5, n4, this.f758a, new C0503p5(), Ql.a());
    }

    public final InterfaceC0677w5 a() {
        return this.f758a;
    }
}
