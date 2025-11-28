package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ed  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0218ed extends L2 {
    public final String b;

    public C0218ed(String str, InterfaceC0731yl interfaceC0731yl) {
        super(interfaceC0731yl);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.L2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
