package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.coreutils.internal.encryption.AESRSAEncrypter;
/* loaded from: classes4.dex */
public class AESRSARequestBodyEncrypter implements RequestBodyEncrypter {

    /* renamed from: a  reason: collision with root package name */
    private final AESRSAEncrypter f1230a;

    public AESRSARequestBodyEncrypter() {
        this(new AESRSAEncrypter());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.RequestBodyEncrypter
    public byte[] encrypt(byte[] bArr) {
        return this.f1230a.encrypt(bArr);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.RequestBodyEncrypter
    public RequestBodyEncryptionMode getEncryptionMode() {
        return RequestBodyEncryptionMode.AES_RSA;
    }

    AESRSARequestBodyEncrypter(AESRSAEncrypter aESRSAEncrypter) {
        this.f1230a = aESRSAEncrypter;
    }
}
