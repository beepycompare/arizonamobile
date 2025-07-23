package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0141b implements Z8 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f774a;

    public C0141b() {
        this(new C0115a(Ia.j().f()));
    }

    @Override // io.appmetrica.analytics.impl.Z8
    public final S8 a(C0401l6 c0401l6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0401l6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f774a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0401l6.setValue(encodeToString);
                return new S8(c0401l6, EnumC0151b9.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0401l6.setValue(encodeToString);
        return new S8(c0401l6, EnumC0151b9.AES_VALUE_ENCRYPTION);
    }

    public C0141b(C0115a c0115a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0115a.b(), c0115a.a()));
    }

    public C0141b(AESEncrypter aESEncrypter) {
        this.f774a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.Z8
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f774a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final EnumC0151b9 a() {
        return EnumC0151b9.AES_VALUE_ENCRYPTION;
    }
}
