package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0270ga implements InterfaceC0114a9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0114a9
    public final S8 a(C0240f6 c0240f6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0114a9
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final EnumC0166c9 a() {
        return EnumC0166c9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
