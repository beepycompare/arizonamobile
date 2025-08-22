package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* loaded from: classes4.dex */
public final class Rn implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final C0170c9 f641a;

    public Rn() {
        this(new C0170c9());
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(C0325i9 c0325i9, Ch ch) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(c0325i9.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((InterfaceC0144b9) this.f641a.f808a.a(c0325i9.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public Rn(C0170c9 c0170c9) {
        this.f641a = c0170c9;
    }

    public final C0170c9 a() {
        return this.f641a;
    }
}
