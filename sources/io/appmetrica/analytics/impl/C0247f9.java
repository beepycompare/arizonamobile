package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.f9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0247f9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0200dd f875a;
    public final C0200dd b;

    public C0247f9() {
        this(new C0629u8(), new C0403la(), new C0134b());
    }

    public C0247f9(C0629u8 c0629u8, C0403la c0403la, C0134b c0134b) {
        C0200dd c0200dd = new C0200dd(c0629u8);
        this.f875a = c0200dd;
        c0200dd.a(EnumC0273g9.NONE, c0629u8);
        c0200dd.a(EnumC0273g9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0403la);
        c0200dd.a(EnumC0273g9.AES_VALUE_ENCRYPTION, c0134b);
        this.b = new C0200dd(c0629u8);
    }
}
