package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.y3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0720y3 implements no {

    /* renamed from: a  reason: collision with root package name */
    public final X8 f1138a;

    public C0720y3() {
        this(new X8());
    }

    @Override // io.appmetrica.analytics.impl.no
    public final byte[] a(C0203d9 c0203d9, C0659vh c0659vh) {
        byte[] bArr = new byte[0];
        String str = c0203d9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        X8 x8 = this.f1138a;
        return ((W8) x8.f703a.a(c0203d9.o)).a(bArr);
    }

    public C0720y3(X8 x8) {
        this.f1138a = x8;
    }
}
