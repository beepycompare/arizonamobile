package io.appmetrica.analytics.impl;

import android.util.Base64;
/* renamed from: io.appmetrica.analytics.impl.ia  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0326ia implements InterfaceC0144b9 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0144b9
    public final U8 a(C0399l6 c0399l6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0144b9
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final EnumC0196d9 a() {
        return EnumC0196d9.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
