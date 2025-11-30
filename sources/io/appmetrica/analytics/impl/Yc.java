package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Yc extends E2 {
    public final String b;

    public Yc(String str, InterfaceC0656vl interfaceC0656vl) {
        super(interfaceC0656vl);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.E2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
