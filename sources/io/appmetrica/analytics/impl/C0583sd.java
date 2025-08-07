package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.sd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0583sd extends P2 {
    public final String b;

    public C0583sd(String str, InterfaceC0641ul interfaceC0641ul) {
        super(interfaceC0641ul);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.P2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
