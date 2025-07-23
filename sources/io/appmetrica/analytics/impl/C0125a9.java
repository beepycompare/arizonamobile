package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.a9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0125a9 {

    /* renamed from: a  reason: collision with root package name */
    public final Yc f765a;
    public final Yc b;

    public C0125a9() {
        this(new C0503p8(), new C0281ga(), new C0141b());
    }

    public C0125a9(C0503p8 c0503p8, C0281ga c0281ga, C0141b c0141b) {
        Yc yc = new Yc(c0503p8);
        this.f765a = yc;
        yc.a(EnumC0151b9.NONE, c0503p8);
        yc.a(EnumC0151b9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0281ga);
        yc.a(EnumC0151b9.AES_VALUE_ENCRYPTION, c0141b);
        this.b = new Yc(c0503p8);
    }
}
