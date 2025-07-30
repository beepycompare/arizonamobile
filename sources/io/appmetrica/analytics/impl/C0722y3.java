package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.y3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0722y3 implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final C0125a9 f1147a;

    public C0722y3() {
        this(new C0125a9());
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0280g9 c0280g9, C0711xh c0711xh) {
        byte[] bArr = new byte[0];
        String str = c0280g9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        C0125a9 c0125a9 = this.f1147a;
        return ((Z8) c0125a9.f766a.a(c0280g9.o)).a(bArr);
    }

    public C0722y3(C0125a9 c0125a9) {
        this.f1147a = c0125a9;
    }
}
