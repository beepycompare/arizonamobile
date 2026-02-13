package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0131b implements G8 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f908a;

    public C0131b() {
        this(new C0105a(C0449na.k().g()));
    }

    @Override // io.appmetrica.analytics.impl.G8
    public final C0746z8 a(P5 p5) {
        byte[] encrypt;
        String encodeToString;
        String value = p5.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f908a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                p5.setValue(encodeToString);
                return new C0746z8(p5, I8.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        p5.setValue(encodeToString);
        return new C0746z8(p5, I8.AES_VALUE_ENCRYPTION);
    }

    public C0131b(C0105a c0105a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0105a.b(), c0105a.a()));
    }

    public C0131b(AESEncrypter aESEncrypter) {
        this.f908a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.G8
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f908a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final I8 a() {
        return I8.AES_VALUE_ENCRYPTION;
    }
}
