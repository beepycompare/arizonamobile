package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.y3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0723y3 implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final C0126a9 f1146a;

    public C0723y3() {
        this(new C0126a9());
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0281g9 c0281g9, C0712xh c0712xh) {
        byte[] bArr = new byte[0];
        String str = c0281g9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        C0126a9 c0126a9 = this.f1146a;
        return ((Z8) c0126a9.f765a.a(c0281g9.o)).a(bArr);
    }

    public C0723y3(C0126a9 c0126a9) {
        this.f1146a = c0126a9;
    }
}
