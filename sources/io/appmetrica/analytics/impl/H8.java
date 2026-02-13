package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class H8 {

    /* renamed from: a  reason: collision with root package name */
    public final Dc f611a;
    public final Dc b;

    public H8() {
        this(new V7(), new L9(), new C0131b());
    }

    public H8(V7 v7, L9 l9, C0131b c0131b) {
        Dc dc = new Dc(v7);
        this.f611a = dc;
        dc.a(I8.NONE, v7);
        dc.a(I8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, l9);
        dc.a(I8.AES_VALUE_ENCRYPTION, c0131b);
        this.b = new Dc(v7);
    }
}
