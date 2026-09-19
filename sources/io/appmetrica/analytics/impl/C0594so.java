package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* renamed from: io.appmetrica.analytics.impl.so  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0594so implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0140b9 f1205a;

    public C0594so() {
        this(new C0140b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0295h9 c0295h9, Eh eh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(c0295h9.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((InterfaceC0114a9) this.f1205a.f907a.a(c0295h9.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public C0594so(C0140b9 c0140b9) {
        this.f1205a = c0140b9;
    }

    public final C0140b9 a() {
        return this.f1205a;
    }
}
