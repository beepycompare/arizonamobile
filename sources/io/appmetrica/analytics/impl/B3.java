package io.appmetrica.analytics.impl;

import android.util.Base64;
/* loaded from: classes4.dex */
public final class B3 implements zo {

    /* renamed from: a  reason: collision with root package name */
    public final C0247f9 f357a;

    public B3() {
        this(new C0247f9());
    }

    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0402l9 c0402l9, Gh gh) {
        byte[] bArr = new byte[0];
        String str = c0402l9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        C0247f9 c0247f9 = this.f357a;
        return ((InterfaceC0221e9) c0247f9.f871a.a(c0402l9.o)).a(bArr);
    }

    public B3(C0247f9 c0247f9) {
        this.f357a = c0247f9;
    }
}
