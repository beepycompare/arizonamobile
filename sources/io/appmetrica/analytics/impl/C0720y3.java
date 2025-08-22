package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.y3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0720y3 implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final C0170c9 f1150a;

    public C0720y3() {
        this(new C0170c9());
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(C0325i9 c0325i9, Ch ch) {
        byte[] bArr = new byte[0];
        String str = c0325i9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        C0170c9 c0170c9 = this.f1150a;
        return ((InterfaceC0144b9) c0170c9.f808a.a(c0325i9.o)).a(bArr);
    }

    public C0720y3(C0170c9 c0170c9) {
        this.f1150a = c0170c9;
    }
}
