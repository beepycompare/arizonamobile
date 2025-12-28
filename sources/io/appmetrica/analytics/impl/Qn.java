package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* loaded from: classes5.dex */
public final class Qn implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final I8 f754a;

    public Qn() {
        this(new I8());
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final byte[] a(O8 o8, C0402lh c0402lh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(o8.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((H8) this.f754a.f620a.a(o8.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public Qn(I8 i8) {
        this.f754a = i8;
    }

    public final I8 a() {
        return this.f754a;
    }
}
