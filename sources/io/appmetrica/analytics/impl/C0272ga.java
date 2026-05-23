package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.ga  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0272ga implements InterfaceC0116a9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0116a9
    public final S8 a(C0242f6 c0242f6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0116a9
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final EnumC0168c9 a() {
        return EnumC0168c9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
