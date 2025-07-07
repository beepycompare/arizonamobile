package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0539qd extends P2 {
    public final String b;

    public C0539qd(String str, InterfaceC0571rl interfaceC0571rl) {
        super(interfaceC0571rl);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.P2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
