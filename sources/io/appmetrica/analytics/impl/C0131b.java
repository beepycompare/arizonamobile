package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
/* renamed from: io.appmetrica.analytics.impl.b  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0131b implements InterfaceC0115a9 {

    /* renamed from: a  reason: collision with root package name */
    public final AESEncrypter f897a;

    public C0131b() {
        this(new C0105a(Na.k().g()));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0115a9
    public final S8 a(C0241f6 c0241f6) {
        byte[] encrypt;
        String encodeToString;
        String value = c0241f6.getValue();
        if (!TextUtils.isEmpty(value)) {
            try {
                encrypt = this.f897a.encrypt(value.getBytes("UTF-8"));
            } catch (Throwable unused) {
            }
            if (encrypt != null) {
                encodeToString = Base64.encodeToString(encrypt, 0);
                c0241f6.setValue(encodeToString);
                return new S8(c0241f6, EnumC0167c9.AES_VALUE_ENCRYPTION);
            }
        }
        encodeToString = null;
        c0241f6.setValue(encodeToString);
        return new S8(c0241f6, EnumC0167c9.AES_VALUE_ENCRYPTION);
    }

    public C0131b(C0105a c0105a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0105a.b(), c0105a.a()));
    }

    public C0131b(AESEncrypter aESEncrypter) {
        this.f897a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0115a9
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr != null && bArr.length > 0) {
            try {
                return this.f897a.decrypt(Base64.decode(bArr, 0));
            } catch (Throwable unused) {
            }
        }
        return bArr2;
    }

    public final EnumC0167c9 a() {
        return EnumC0167c9.AES_VALUE_ENCRYPTION;
    }
}
