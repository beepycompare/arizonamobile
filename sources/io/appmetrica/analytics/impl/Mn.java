package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* loaded from: classes4.dex */
public final class Mn implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final C0125a9 f554a;

    public Mn() {
        this(new C0125a9());
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0280g9 c0280g9, C0711xh c0711xh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(c0280g9.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((Z8) this.f554a.f766a.a(c0280g9.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public Mn(C0125a9 c0125a9) {
        this.f554a = c0125a9;
    }

    public final C0125a9 a() {
        return this.f554a;
    }
}
