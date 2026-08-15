package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.s3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0574s3 implements Wo {

    /* renamed from: a  reason: collision with root package name */
    public final C0141b9 f1193a;

    public C0574s3() {
        this(new C0141b9());
    }

    @Override // io.appmetrica.analytics.impl.Wo
    public final byte[] a(C0296h9 c0296h9, Eh eh) {
        byte[] bArr = new byte[0];
        String str = c0296h9.b;
        if (str != null) {
            try {
                bArr = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        C0141b9 c0141b9 = this.f1193a;
        return ((InterfaceC0115a9) c0141b9.f907a.a(c0296h9.o)).a(bArr);
    }

    public C0574s3(C0141b9 c0141b9) {
        this.f1193a = c0141b9;
    }
}
