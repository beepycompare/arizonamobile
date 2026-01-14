package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class C8 implements to {

    /* renamed from: a  reason: collision with root package name */
    public final H8 f532a;

    public C8() {
        this(new H8());
    }

    @Override // io.appmetrica.analytics.impl.to
    public final byte[] a(N8 n8, C0381kh c0381kh) {
        byte[] bArr;
        String str = n8.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        H8 h8 = this.f532a;
        return ((G8) h8.f612a.a(n8.o)).a(bArr);
    }

    public C8(H8 h8) {
        this.f532a = h8;
    }
}
