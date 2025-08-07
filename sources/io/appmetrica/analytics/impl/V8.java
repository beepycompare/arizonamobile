package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes4.dex */
public final class V8 implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final C0126a9 f682a;

    public V8() {
        this(new C0126a9());
    }

    @Override // io.appmetrica.analytics.impl.qo
    public final byte[] a(C0281g9 c0281g9, C0712xh c0712xh) {
        byte[] bArr;
        String str = c0281g9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        C0126a9 c0126a9 = this.f682a;
        return ((Z8) c0126a9.f765a.a(c0281g9.o)).a(bArr);
    }

    public V8(C0126a9 c0126a9) {
        this.f682a = c0126a9;
    }
}
