package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0126b implements H8 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f888a;

    public C0126b() {
        this(new C0100a(C0470oa.k().g()));
    }

    @Override // io.appmetrica.analytics.impl.H8
    public final A8 a(Q5 q5) {
        byte[] encrypt;
        String encodeToString;
        String value = q5.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f888a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                q5.setValue(encodeToString);
                return new A8(q5, J8.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        q5.setValue(encodeToString);
        return new A8(q5, J8.AES_VALUE_ENCRYPTION);
    }

    public C0126b(C0100a c0100a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0100a.b(), c0100a.a()));
    }

    public C0126b(AESEncrypter aESEncrypter) {
        this.f888a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.H8
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f888a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final J8 a() {
        return J8.AES_VALUE_ENCRYPTION;
    }
}
