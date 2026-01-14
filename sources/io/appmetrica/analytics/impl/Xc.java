package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Xc extends D2 {
    public final String b;

    public Xc(String str, InterfaceC0634ul interfaceC0634ul) {
        super(interfaceC0634ul);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.D2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
