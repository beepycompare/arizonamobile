package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* loaded from: classes4.dex */
public final class Jn implements no {

    /* renamed from: a  reason: collision with root package name */
    public final X8 f497a;

    public Jn() {
        this(new X8());
    }

    @Override // io.appmetrica.analytics.impl.no
    public final byte[] a(C0203d9 c0203d9, C0659vh c0659vh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(c0203d9.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((W8) this.f497a.f703a.a(c0203d9.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public Jn(X8 x8) {
        this.f497a = x8;
    }

    public final X8 a() {
        return this.f497a;
    }
}
