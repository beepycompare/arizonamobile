package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.s3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0568s3 implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0135b9 f1196a;

    public C0568s3() {
        this(new C0135b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0290h9 c0290h9, Eh eh) {
        byte[] bArr = new byte[0];
        String str = c0290h9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        C0135b9 c0135b9 = this.f1196a;
        return ((InterfaceC0109a9) c0135b9.f910a.a(c0290h9.o)).a(bArr);
    }

    public C0568s3(C0135b9 c0135b9) {
        this.f1196a = c0135b9;
    }
}
