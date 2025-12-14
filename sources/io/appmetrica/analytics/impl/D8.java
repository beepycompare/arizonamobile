package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class D8 implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final I8 f539a;

    public D8() {
        this(new I8());
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final byte[] a(O8 o8, C0402lh c0402lh) {
        byte[] bArr;
        String str = o8.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        I8 i8 = this.f539a;
        return ((H8) i8.f619a.a(o8.o)).a(bArr);
    }

    public D8(I8 i8) {
        this.f539a = i8;
    }
}
