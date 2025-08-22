package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ud  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0630ud extends P2 {
    public final String b;

    public C0630ud(String str, InterfaceC0763zl interfaceC0763zl) {
        super(interfaceC0763zl);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.P2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
