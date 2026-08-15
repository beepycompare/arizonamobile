package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0271ga implements InterfaceC0115a9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0115a9
    public final S8 a(C0241f6 c0241f6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0115a9
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final EnumC0167c9 a() {
        return EnumC0167c9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
