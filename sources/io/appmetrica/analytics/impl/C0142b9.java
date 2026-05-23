package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0142b9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0223ed f904a;
    public final C0223ed b;

    public C0142b9() {
        this(new C0477o8(), new C0272ga(), new C0132b());
    }

    public C0142b9(C0477o8 c0477o8, C0272ga c0272ga, C0132b c0132b) {
        C0223ed c0223ed = new C0223ed(c0477o8);
        this.f904a = c0223ed;
        c0223ed.a(EnumC0168c9.NONE, c0477o8);
        c0223ed.a(EnumC0168c9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0272ga);
        c0223ed.a(EnumC0168c9.AES_VALUE_ENCRYPTION, c0132b);
        this.b = new C0223ed(c0477o8);
    }
}
