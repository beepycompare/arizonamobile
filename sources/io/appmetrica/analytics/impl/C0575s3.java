package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.s3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0575s3 implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0142b9 f1190a;

    public C0575s3() {
        this(new C0142b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0297h9 c0297h9, Eh eh) {
        byte[] bArr = new byte[0];
        String str = c0297h9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        C0142b9 c0142b9 = this.f1190a;
        return ((InterfaceC0116a9) c0142b9.f904a.a(c0297h9.o)).a(bArr);
    }

    public C0575s3(C0142b9 c0142b9) {
        this.f1190a = c0142b9;
    }
}
