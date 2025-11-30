package io.appmetrica.analytics.impl;

import android.util.Base64;
/* loaded from: classes5.dex */
public final class M9 implements H8 {
    @Override // io.appmetrica.analytics.impl.H8
    public final A8 a(Q5 q5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.H8
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final J8 a() {
        return J8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
