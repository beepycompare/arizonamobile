package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.a9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0118a9 implements zo {

    /* renamed from: a  reason: collision with root package name */
    public final C0247f9 f789a;

    public C0118a9() {
        this(new C0247f9());
    }

    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0402l9 c0402l9, Gh gh) {
        byte[] bArr;
        String str = c0402l9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        C0247f9 c0247f9 = this.f789a;
        return ((InterfaceC0221e9) c0247f9.f875a.a(c0402l9.o)).a(bArr);
    }

    public C0118a9(C0247f9 c0247f9) {
        this.f789a = c0247f9;
    }
}
