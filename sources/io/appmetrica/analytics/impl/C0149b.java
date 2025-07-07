package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0149b implements W8 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f760a;

    public C0149b() {
        this(new C0123a(Ga.j().f()));
    }

    @Override // io.appmetrica.analytics.impl.W8
    public final P8 a(C0333i6 c0333i6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0333i6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f760a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0333i6.setValue(encodeToString);
                return new P8(c0333i6, Y8.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0333i6.setValue(encodeToString);
        return new P8(c0333i6, Y8.AES_VALUE_ENCRYPTION);
    }

    public C0149b(C0123a c0123a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0123a.b(), c0123a.a()));
    }

    public C0149b(AESEncrypter aESEncrypter) {
        this.f760a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.W8
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f760a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final Y8 a() {
        return Y8.AES_VALUE_ENCRYPTION;
    }
}
