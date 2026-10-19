package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* renamed from: io.appmetrica.analytics.impl.so  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0589so implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0135b9 f1208a;

    public C0589so() {
        this(new C0135b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0290h9 c0290h9, Eh eh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(c0290h9.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((InterfaceC0109a9) this.f1208a.f910a.a(c0290h9.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public C0589so(C0135b9 c0135b9) {
        this.f1208a = c0135b9;
    }

    public final C0135b9 a() {
        return this.f1208a;
    }
}
