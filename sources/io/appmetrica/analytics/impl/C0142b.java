package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0142b implements Z8 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f774a;

    public C0142b() {
        this(new C0116a(Ia.j().f()));
    }

    @Override // io.appmetrica.analytics.impl.Z8
    public final S8 a(C0402l6 c0402l6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0402l6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f774a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0402l6.setValue(encodeToString);
                return new S8(c0402l6, EnumC0152b9.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0402l6.setValue(encodeToString);
        return new S8(c0402l6, EnumC0152b9.AES_VALUE_ENCRYPTION);
    }

    public C0142b(C0116a c0116a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0116a.b(), c0116a.a()));
    }

    public C0142b(AESEncrypter aESEncrypter) {
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

    public final EnumC0152b9 a() {
        return EnumC0152b9.AES_VALUE_ENCRYPTION;
    }
}
