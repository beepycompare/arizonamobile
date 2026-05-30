package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0132b implements InterfaceC0116a9 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f895a;

    public C0132b() {
        this(new C0106a(Na.k().g()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0116a9
    public final S8 a(C0242f6 c0242f6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0242f6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f895a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0242f6.setValue(encodeToString);
                return new S8(c0242f6, EnumC0168c9.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0242f6.setValue(encodeToString);
        return new S8(c0242f6, EnumC0168c9.AES_VALUE_ENCRYPTION);
    }

    public C0132b(C0106a c0106a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0106a.b(), c0106a.a()));
    }

    public C0132b(AESEncrypter aESEncrypter) {
        this.f895a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0116a9
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f895a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final EnumC0168c9 a() {
        return EnumC0168c9.AES_VALUE_ENCRYPTION;
    }
}
