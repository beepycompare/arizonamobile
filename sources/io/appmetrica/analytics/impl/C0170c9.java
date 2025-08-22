package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.c9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0170c9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0122ad f808a;
    public final C0122ad b;

    public C0170c9() {
        this(new C0550r8(), new C0326ia(), new C0134b());
    }

    public C0170c9(C0550r8 c0550r8, C0326ia c0326ia, C0134b c0134b) {
        C0122ad c0122ad = new C0122ad(c0550r8);
        this.f808a = c0122ad;
        c0122ad.a(EnumC0196d9.NONE, c0550r8);
        c0122ad.a(EnumC0196d9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0326ia);
        c0122ad.a(EnumC0196d9.AES_VALUE_ENCRYPTION, c0134b);
        this.b = new C0122ad(c0550r8);
    }
}
