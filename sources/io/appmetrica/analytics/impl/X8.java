package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class X8 implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final C0170c9 f723a;

    public X8() {
        this(new C0170c9());
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(C0325i9 c0325i9, Ch ch) {
        byte[] bArr;
        String str = c0325i9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        C0170c9 c0170c9 = this.f723a;
        return ((InterfaceC0144b9) c0170c9.f808a.a(c0325i9.o)).a(bArr);
    }

    public X8(C0170c9 c0170c9) {
        this.f723a = c0170c9;
    }
}
