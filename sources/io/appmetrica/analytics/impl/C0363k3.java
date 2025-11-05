package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.k3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0363k3 implements vo {

    /* renamed from: a  reason: collision with root package name */
    public final M8 f965a;

    public C0363k3() {
        this(new M8());
    }

    @Override // io.appmetrica.analytics.impl.vo
    public final byte[] a(S8 s8, C0503ph c0503ph) {
        byte[] bArr = new byte[0];
        String str = s8.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        M8 m8 = this.f965a;
        return ((L8) m8.f588a.a(s8.o)).a(bArr);
    }

    public C0363k3(M8 m8) {
        this.f965a = m8;
    }
}
