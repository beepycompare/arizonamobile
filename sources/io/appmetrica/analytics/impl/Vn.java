package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* loaded from: classes4.dex */
public final class Vn implements zo {

    /* renamed from: a  reason: collision with root package name */
    public final C0247f9 f719a;

    public Vn() {
        this(new C0247f9());
    }

    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0402l9 c0402l9, Gh gh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(c0402l9.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((InterfaceC0221e9) this.f719a.f876a.a(c0402l9.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public Vn(C0247f9 c0247f9) {
        this.f719a = c0247f9;
    }

    public final C0247f9 a() {
        return this.f719a;
    }
}
