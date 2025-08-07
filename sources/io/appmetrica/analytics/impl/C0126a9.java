package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.a9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0126a9 {

    /* renamed from: a  reason: collision with root package name */
    public final Yc f765a;
    public final Yc b;

    public C0126a9() {
        this(new C0504p8(), new C0282ga(), new C0142b());
    }

    public C0126a9(C0504p8 c0504p8, C0282ga c0282ga, C0142b c0142b) {
        Yc yc = new Yc(c0504p8);
        this.f765a = yc;
        yc.a(EnumC0152b9.NONE, c0504p8);
        yc.a(EnumC0152b9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0282ga);
        yc.a(EnumC0152b9.AES_VALUE_ENCRYPTION, c0142b);
        this.b = new Yc(c0504p8);
    }
}
