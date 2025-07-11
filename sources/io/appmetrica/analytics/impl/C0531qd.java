package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0531qd extends P2 {
    public final String b;

    public C0531qd(String str, InterfaceC0563rl interfaceC0563rl) {
        super(interfaceC0563rl);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.P2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
