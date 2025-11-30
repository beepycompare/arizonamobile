package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import java.util.Arrays;
/* loaded from: classes5.dex */
public final class W2 {

    /* renamed from: a  reason: collision with root package name */
    public final V2 f732a;
    public final GZIPCompressor b;

    public W2() {
        this(new V2(), new GZIPCompressor());
    }

    public final byte[] a(byte[] bArr) {
        try {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            V2 v2 = this.f732a;
            byte[] bytes = "hBnBQbZrmjPXEWVJ".getBytes();
            v2.getClass();
            AESEncrypter aESEncrypter = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bytes, copyOfRange);
            if (bArr != null && bArr.length != 0) {
                return this.b.uncompress(aESEncrypter.decrypt(bArr, 16, bArr.length - 16));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public W2(V2 v2, GZIPCompressor gZIPCompressor) {
        this.f732a = v2;
        this.b = gZIPCompressor;
    }
}
