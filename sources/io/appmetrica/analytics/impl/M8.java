package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class M8 {

    /* renamed from: a  reason: collision with root package name */
    public final Kc f588a;
    public final Kc b;

    public M8() {
        this(new C0136b8(), new S9(), new C0127b());
    }

    public M8(C0136b8 c0136b8, S9 s9, C0127b c0127b) {
        Kc kc = new Kc(c0136b8);
        this.f588a = kc;
        kc.a(N8.NONE, c0136b8);
        kc.a(N8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, s9);
        kc.a(N8.AES_VALUE_ENCRYPTION, c0127b);
        this.b = new Kc(c0136b8);
    }
}
