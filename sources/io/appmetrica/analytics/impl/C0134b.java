package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0134b implements InterfaceC0144b9 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f785a;

    public C0134b() {
        this(new C0108a(Ka.j().f()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0144b9
    public final U8 a(C0399l6 c0399l6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0399l6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f785a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0399l6.setValue(encodeToString);
                return new U8(c0399l6, EnumC0196d9.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0399l6.setValue(encodeToString);
        return new U8(c0399l6, EnumC0196d9.AES_VALUE_ENCRYPTION);
    }

    public C0134b(C0108a c0108a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0108a.b(), c0108a.a()));
    }

    public C0134b(AESEncrypter aESEncrypter) {
        this.f785a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0144b9
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f785a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final EnumC0196d9 a() {
        return EnumC0196d9.AES_VALUE_ENCRYPTION;
    }
}
