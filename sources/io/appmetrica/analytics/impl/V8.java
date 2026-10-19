package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class V8 implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0135b9 f811a;

    public V8() {
        this(new C0135b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0290h9 c0290h9, Eh eh) {
        byte[] bArr;
        String str = c0290h9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        C0135b9 c0135b9 = this.f811a;
        return ((InterfaceC0109a9) c0135b9.f910a.a(c0290h9.o)).a(bArr);
    }

    public V8(C0135b9 c0135b9) {
        this.f811a = c0135b9;
    }
}
