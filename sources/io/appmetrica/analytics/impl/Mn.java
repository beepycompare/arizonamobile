package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* loaded from: classes4.dex */
public final class Mn implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final C0126a9 f553a;

    public Mn() {
        this(new C0126a9());
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0281g9 c0281g9, C0712xh c0712xh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(c0281g9.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((Z8) this.f553a.f765a.a(c0281g9.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public Mn(C0126a9 c0126a9) {
        this.f553a = c0126a9;
    }

    public final C0126a9 a() {
        return this.f553a;
    }
}
