package io.appmetrica.analytics.networktasks.internal;
/* loaded from: classes3.dex */
public interface RequestBodyEncrypter {
    byte[] encrypt(byte[] bArr);

    RequestBodyEncryptionMode getEncryptionMode();
}
