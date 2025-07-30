package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.crypto.CryptoProvider;
import io.appmetrica.analytics.coreapi.internal.crypto.Encrypter;
import io.appmetrica.analytics.coreutils.internal.encryption.AESRSAEncrypter;
/* loaded from: classes4.dex */
public final class L6 implements CryptoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final AESRSAEncrypter f529a = new AESRSAEncrypter();

    @Override // io.appmetrica.analytics.coreapi.internal.crypto.CryptoProvider
    public final Encrypter getAesRsaEncrypter() {
        return this.f529a;
    }
}
