package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.crypto.CryptoProvider;
import io.appmetrica.analytics.coreapi.internal.crypto.Encrypter;
import io.appmetrica.analytics.coreutils.internal.encryption.AESRSAEncrypter;
/* renamed from: io.appmetrica.analytics.impl.q6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0516q6 implements CryptoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final AESRSAEncrypter f1165a = new AESRSAEncrypter();

    @Override // io.appmetrica.analytics.coreapi.internal.crypto.CryptoProvider
    public final Encrypter getAesRsaEncrypter() {
        return this.f1165a;
    }
}
