package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X8 {

    /* renamed from: a  reason: collision with root package name */
    public final Wc f702a;
    public final Wc b;

    public X8() {
        this(new C0434m8(), new C0237ea(), new C0149b());
    }

    public X8(C0434m8 c0434m8, C0237ea c0237ea, C0149b c0149b) {
        Wc wc = new Wc(c0434m8);
        this.f702a = wc;
        wc.a(Y8.NONE, c0434m8);
        wc.a(Y8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0237ea);
        wc.a(Y8.AES_VALUE_ENCRYPTION, c0149b);
        this.b = new Wc(c0434m8);
    }
}
