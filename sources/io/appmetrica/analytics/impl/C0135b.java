package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0135b implements InterfaceC0222e9 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f800a;

    public C0135b() {
        this(new C0109a(Na.j().f()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0222e9
    public final X8 a(C0478o6 c0478o6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0478o6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f800a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0478o6.setValue(encodeToString);
                return new X8(c0478o6, EnumC0274g9.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0478o6.setValue(encodeToString);
        return new X8(c0478o6, EnumC0274g9.AES_VALUE_ENCRYPTION);
    }

    public C0135b(C0109a c0109a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0109a.b(), c0109a.a()));
    }

    public C0135b(AESEncrypter aESEncrypter) {
        this.f800a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0222e9
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f800a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final EnumC0274g9 a() {
        return EnumC0274g9.AES_VALUE_ENCRYPTION;
    }
}
