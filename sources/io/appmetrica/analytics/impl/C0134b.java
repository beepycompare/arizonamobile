package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0134b implements InterfaceC0221e9 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f799a;

    public C0134b() {
        this(new C0108a(Na.j().f()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221e9
    public final X8 a(C0477o6 c0477o6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0477o6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f799a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0477o6.setValue(encodeToString);
                return new X8(c0477o6, EnumC0273g9.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0477o6.setValue(encodeToString);
        return new X8(c0477o6, EnumC0273g9.AES_VALUE_ENCRYPTION);
    }

    public C0134b(C0108a c0108a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0108a.b(), c0108a.a()));
    }

    public C0134b(AESEncrypter aESEncrypter) {
        this.f799a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0221e9
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f799a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final EnumC0273g9 a() {
        return EnumC0273g9.AES_VALUE_ENCRYPTION;
    }
}
