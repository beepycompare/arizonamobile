package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Xc extends D2 {
    public final String b;

    public Xc(String str, InterfaceC0633ul interfaceC0633ul) {
        super(interfaceC0633ul);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.D2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
