package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* loaded from: classes3.dex */
public final class Rn implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final M8 f672a;

    public Rn() {
        this(new M8());
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(S8 s8, C0503ph c0503ph) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(s8.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((L8) this.f672a.f588a.a(s8.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public Rn(M8 m8) {
        this.f672a = m8;
    }

    public final M8 a() {
        return this.f672a;
    }
}
