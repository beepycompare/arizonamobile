package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class V2 {

    /* renamed from: a  reason: collision with root package name */
    public final U2 f825a;
    public final GZIPCompressor b;

    public V2() {
        this(new U2(), new GZIPCompressor());
    }

    public final byte[] a(byte[] bArr) {
        try {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            U2 u2 = this.f825a;
            byte[] bytes = "hBnBQbZrmjPXEWVJ".getBytes();
            u2.getClass();
            AESEncrypter aESEncrypter = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bytes, copyOfRange);
            if (bArr != null && bArr.length != 0) {
                return this.b.uncompress(aESEncrypter.decrypt(bArr, 16, bArr.length - 16));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public V2(U2 u2, GZIPCompressor gZIPCompressor) {
        this.f825a = u2;
        this.b = gZIPCompressor;
    }
}
