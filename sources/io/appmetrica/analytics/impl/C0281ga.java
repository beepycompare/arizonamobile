package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0281ga implements Z8 {
    @Override // io.appmetrica.analytics.impl.Z8
    public final S8 a(C0401l6 c0401l6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.Z8
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final EnumC0151b9 a() {
        return EnumC0151b9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
