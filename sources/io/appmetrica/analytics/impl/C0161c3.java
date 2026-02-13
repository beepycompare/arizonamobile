package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.c3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0161c3 implements to {

    /* renamed from: a  reason: collision with root package name */
    public final H8 f928a;

    public C0161c3() {
        this(new H8());
    }

    @Override // io.appmetrica.analytics.impl.to
    public final byte[] a(N8 n8, C0381kh c0381kh) {
        byte[] bArr = new byte[0];
        String str = n8.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        H8 h8 = this.f928a;
        return ((G8) h8.f611a.a(n8.o)).a(bArr);
    }

    public C0161c3(H8 h8) {
        this.f928a = h8;
    }
}
