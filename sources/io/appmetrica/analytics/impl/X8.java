package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X8 {

    /* renamed from: a  reason: collision with root package name */
    public final Wc f703a;
    public final Wc b;

    public X8() {
        this(new C0426m8(), new C0229ea(), new C0141b());
    }

    public X8(C0426m8 c0426m8, C0229ea c0229ea, C0141b c0141b) {
        Wc wc = new Wc(c0426m8);
        this.f703a = wc;
        wc.a(Y8.NONE, c0426m8);
        wc.a(Y8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0229ea);
        wc.a(Y8.AES_VALUE_ENCRYPTION, c0141b);
        this.b = new Wc(c0426m8);
    }
}
