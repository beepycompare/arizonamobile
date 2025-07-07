package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.y3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0728y3 implements no {

    /* renamed from: a  reason: collision with root package name */
    public final X8 f1137a;

    public C0728y3() {
        this(new X8());
    }

    @Override // io.appmetrica.analytics.impl.no
    public final byte[] a(C0211d9 c0211d9, C0667vh c0667vh) {
        byte[] bArr = new byte[0];
        String str = c0211d9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        X8 x8 = this.f1137a;
        return ((W8) x8.f702a.a(c0211d9.o)).a(bArr);
    }

    public C0728y3(X8 x8) {
        this.f1137a = x8;
    }
}
