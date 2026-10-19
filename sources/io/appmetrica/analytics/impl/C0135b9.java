package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0135b9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0216ed f910a;
    public final C0216ed b;

    public C0135b9() {
        this(new C0470o8(), new C0265ga(), new C0125b());
    }

    public C0135b9(C0470o8 c0470o8, C0265ga c0265ga, C0125b c0125b) {
        C0216ed c0216ed = new C0216ed(c0470o8);
        this.f910a = c0216ed;
        c0216ed.a(EnumC0161c9.NONE, c0470o8);
        c0216ed.a(EnumC0161c9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0265ga);
        c0216ed.a(EnumC0161c9.AES_VALUE_ENCRYPTION, c0125b);
        this.b = new C0216ed(c0470o8);
    }
}
