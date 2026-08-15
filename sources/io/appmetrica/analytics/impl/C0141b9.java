package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0141b9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0222ed f907a;
    public final C0222ed b;

    public C0141b9() {
        this(new C0476o8(), new C0271ga(), new C0131b());
    }

    public C0141b9(C0476o8 c0476o8, C0271ga c0271ga, C0131b c0131b) {
        C0222ed c0222ed = new C0222ed(c0476o8);
        this.f907a = c0222ed;
        c0222ed.a(EnumC0167c9.NONE, c0476o8);
        c0222ed.a(EnumC0167c9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0271ga);
        c0222ed.a(EnumC0167c9.AES_VALUE_ENCRYPTION, c0131b);
        this.b = new C0222ed(c0476o8);
    }
}
