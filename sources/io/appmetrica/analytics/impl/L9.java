package io.appmetrica.analytics.impl;

import android.util.Base64;
/* loaded from: classes5.dex */
public final class L9 implements G8 {
    @Override // io.appmetrica.analytics.impl.G8
    public final C0746z8 a(P5 p5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.G8
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final I8 a() {
        return I8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
