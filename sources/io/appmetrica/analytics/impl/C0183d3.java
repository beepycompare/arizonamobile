package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.d3  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0183d3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0157c3 f839a;
    public final GZIPCompressor b;

    public C0183d3() {
        this(new C0157c3(), new GZIPCompressor());
    }

    public final byte[] a(byte[] bArr) {
        try {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            C0157c3 c0157c3 = this.f839a;
            byte[] bytes = "hBnBQbZrmjPXEWVJ".getBytes();
            c0157c3.getClass();
            AESEncrypter aESEncrypter = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bytes, copyOfRange);
            if (bArr != null && bArr.length != 0) {
                return this.b.uncompress(aESEncrypter.decrypt(bArr, 16, bArr.length - 16));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public C0183d3(C0157c3 c0157c3, GZIPCompressor gZIPCompressor) {
        this.f839a = c0157c3;
        this.b = gZIPCompressor;
    }
}
