package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0183d3 implements uo {

    /* renamed from: a  reason: collision with root package name */
    public final I8 f841a;

    public C0183d3() {
        this(new I8());
    }

    @Override // io.appmetrica.analytics.impl.uo
    public final byte[] a(O8 o8, C0403lh c0403lh) {
        byte[] bArr = new byte[0];
        String str = o8.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        I8 i8 = this.f841a;
        return ((H8) i8.f522a.a(o8.o)).a(bArr);
    }

    public C0183d3(I8 i8) {
        this.f841a = i8;
    }
}
