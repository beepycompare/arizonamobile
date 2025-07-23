package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.sd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0582sd extends P2 {
    public final String b;

    public C0582sd(String str, InterfaceC0640ul interfaceC0640ul) {
        super(interfaceC0640ul);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.P2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
