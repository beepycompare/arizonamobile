package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.la  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0404la implements InterfaceC0222e9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0222e9
    public final X8 a(C0478o6 c0478o6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0222e9
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final EnumC0274g9 a() {
        return EnumC0274g9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
