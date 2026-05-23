package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;
/* renamed from: io.appmetrica.analytics.impl.so  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0596so implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0142b9 f1202a;

    public C0596so() {
        this(new C0142b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0297h9 c0297h9, Eh eh) {
        byte[] bArr = new byte[0];
        try {
            bArr = Base64Utils.decompressBase64GzipAsBytes(c0297h9.b);
        } catch (Throwable unused) {
        }
        byte[] a2 = ((InterfaceC0116a9) this.f1202a.f904a.a(c0297h9.o)).a(bArr);
        return a2 == null ? new byte[0] : a2;
    }

    public C0596so(C0142b9 c0142b9) {
        this.f1202a = c0142b9;
    }

    public final C0142b9 a() {
        return this.f1202a;
    }
}
