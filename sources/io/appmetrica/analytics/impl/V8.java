package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class V8 implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0142b9 f808a;

    public V8() {
        this(new C0142b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0297h9 c0297h9, Eh eh) {
        byte[] bArr;
        String str = c0297h9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        C0142b9 c0142b9 = this.f808a;
        return ((InterfaceC0116a9) c0142b9.f907a.a(c0297h9.o)).a(bArr);
    }

    public V8(C0142b9 c0142b9) {
        this.f808a = c0142b9;
    }
}
