package io.appmetrica.analytics.impl;

import android.util.Base64;
/* loaded from: classes3.dex */
public final class S9 implements L8 {
    @Override // io.appmetrica.analytics.impl.L8
    public final E8 a(W5 w5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.L8
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final N8 a() {
        return N8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
