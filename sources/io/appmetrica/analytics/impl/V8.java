package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class V8 implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0141b9 f808a;

    public V8() {
        this(new C0141b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0296h9 c0296h9, Eh eh) {
        byte[] bArr;
        String str = c0296h9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        C0141b9 c0141b9 = this.f808a;
        return ((InterfaceC0115a9) c0141b9.f907a.a(c0296h9.o)).a(bArr);
    }

    public V8(C0141b9 c0141b9) {
        this.f808a = c0141b9;
    }
}
