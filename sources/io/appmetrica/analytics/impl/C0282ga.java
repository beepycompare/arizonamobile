package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0282ga implements Z8 {
    @Override // io.appmetrica.analytics.impl.Z8
    public final S8 a(C0402l6 c0402l6) {
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

    public final EnumC0152b9 a() {
        return EnumC0152b9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
