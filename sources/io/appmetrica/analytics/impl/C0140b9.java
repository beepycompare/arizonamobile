package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.b9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0140b9 {

    /* renamed from: a  reason: collision with root package name */
    public final C0221ed f907a;
    public final C0221ed b;

    public C0140b9() {
        this(new C0475o8(), new C0270ga(), new C0130b());
    }

    public C0140b9(C0475o8 c0475o8, C0270ga c0270ga, C0130b c0130b) {
        C0221ed c0221ed = new C0221ed(c0475o8);
        this.f907a = c0221ed;
        c0221ed.a(EnumC0166c9.NONE, c0475o8);
        c0221ed.a(EnumC0166c9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER, c0270ga);
        c0221ed.a(EnumC0166c9.AES_VALUE_ENCRYPTION, c0130b);
        this.b = new C0221ed(c0475o8);
    }
}
