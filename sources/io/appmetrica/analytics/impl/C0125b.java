package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0125b implements InterfaceC0109a9 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f900a;

    public C0125b() {
        this(new C0099a(Na.k().g()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0109a9
    public final S8 a(C0235f6 c0235f6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0235f6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f900a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0235f6.setValue(encodeToString);
                return new S8(c0235f6, EnumC0161c9.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0235f6.setValue(encodeToString);
        return new S8(c0235f6, EnumC0161c9.AES_VALUE_ENCRYPTION);
    }

    public C0125b(C0099a c0099a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0099a.b(), c0099a.a()));
    }

    public C0125b(AESEncrypter aESEncrypter) {
        this.f900a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0109a9
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f900a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final EnumC0161c9 a() {
        return EnumC0161c9.AES_VALUE_ENCRYPTION;
    }
}
