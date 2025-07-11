package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class S8 implements no {

    /* renamed from: a  reason: collision with root package name */
    public final X8 f622a;

    public S8() {
        this(new X8());
    }

    @Override // io.appmetrica.analytics.impl.no
    public final byte[] a(C0203d9 c0203d9, C0659vh c0659vh) {
        byte[] bArr;
        String str = c0203d9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        X8 x8 = this.f622a;
        return ((W8) x8.f703a.a(c0203d9.o)).a(bArr);
    }

    public S8(X8 x8) {
        this.f622a = x8;
    }
}
