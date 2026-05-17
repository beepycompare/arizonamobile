package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* loaded from: classes5.dex */
public final class Pn implements to {

    /* renamed from: a  reason: collision with root package name */
    public final H8 f749a;

    public Pn() {
        this(new H8());
    }

    @Override // io.appmetrica.analytics.impl.to
    public final byte[] a(N8 n8, C0380kh c0380kh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(n8.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((G8) this.f749a.f616a.a(n8.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public Pn(H8 h8) {
        this.f749a = h8;
    }

    public final H8 a() {
        return this.f749a;
    }
}
