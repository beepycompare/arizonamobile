package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.f9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0248f9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0201dd f876a;
    public final C0201dd b;

    public C0248f9() {
        this(new C0630u8(), new C0404la(), new C0135b());
    }

    public C0248f9(C0630u8 c0630u8, C0404la c0404la, C0135b c0135b) {
        C0201dd c0201dd = new C0201dd(c0630u8);
        this.f876a = c0201dd;
        c0201dd.a(EnumC0274g9.NONE, c0630u8);
        c0201dd.a(EnumC0274g9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0404la);
        c0201dd.a(EnumC0274g9.AES_VALUE_ENCRYPTION, c0135b);
        this.b = new C0201dd(c0630u8);
    }
}
