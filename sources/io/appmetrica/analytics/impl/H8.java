package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes3.dex */
public final class H8 implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final M8 f503a;

    public H8() {
        this(new M8());
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(S8 s8, C0503ph c0503ph) {
        byte[] bArr;
        String str = s8.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        M8 m8 = this.f503a;
        return ((L8) m8.f588a.a(s8.o)).a(bArr);
    }

    public H8(M8 m8) {
        this.f503a = m8;
    }
}
