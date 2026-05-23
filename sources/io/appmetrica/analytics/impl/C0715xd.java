package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.xd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0715xd extends Q2 {
    public final String b;

    public C0715xd(String str, Zl zl) {
        super(zl);
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.Q2
    public final String a(String str) {
        return str + '-' + this.b;
    }
}
