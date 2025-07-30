package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class V8 implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final C0125a9 f683a;

    public V8() {
        this(new C0125a9());
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0280g9 c0280g9, C0711xh c0711xh) {
        byte[] bArr;
        String str = c0280g9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        C0125a9 c0125a9 = this.f683a;
        return ((Z8) c0125a9.f766a.a(c0280g9.o)).a(bArr);
    }

    public V8(C0125a9 c0125a9) {
        this.f683a = c0125a9;
    }
}
