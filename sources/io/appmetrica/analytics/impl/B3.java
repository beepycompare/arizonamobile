package io.appmetrica.analytics.impl;

import android.util.Base64;
/* loaded from: classes4.dex */
public final class B3 implements zo {

    /* renamed from: a  reason: collision with root package name */
    public final C0248f9 f362a;

    public B3() {
        this(new C0248f9());
    }

    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0403l9 c0403l9, Gh gh) {
        byte[] bArr = new byte[0];
        String str = c0403l9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        C0248f9 c0248f9 = this.f362a;
        return ((InterfaceC0222e9) c0248f9.f876a.a(c0403l9.o)).a(bArr);
    }

    public B3(C0248f9 c0248f9) {
        this.f362a = c0248f9;
    }
}
