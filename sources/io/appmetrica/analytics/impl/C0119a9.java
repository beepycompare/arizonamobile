package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* renamed from: io.appmetrica.analytics.impl.a9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0119a9 implements zo {

    /* renamed from: a  reason: collision with root package name */
    public final C0248f9 f790a;

    public C0119a9() {
        this(new C0248f9());
    }

    @Override // io.appmetrica.analytics.impl.zo
    public final byte[] a(C0403l9 c0403l9, Gh gh) {
        byte[] bArr;
        String str = c0403l9.b;
        if (str != null) {
            bArr = StringUtils.getUTF8Bytes(str);
        } else {
            bArr = new byte[0];
        }
        C0248f9 c0248f9 = this.f790a;
        return ((InterfaceC0222e9) c0248f9.f876a.a(c0403l9.o)).a(bArr);
    }

    public C0119a9(C0248f9 c0248f9) {
        this.f790a = c0248f9;
    }
}
