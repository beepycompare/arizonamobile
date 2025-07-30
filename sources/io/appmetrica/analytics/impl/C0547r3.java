package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.r3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0547r3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0523q3 f1030a;
    public final GZIPCompressor b;

    public C0547r3() {
        this(new C0523q3(), new GZIPCompressor());
    }

    public final byte[] a(byte[] bArr) {
        try {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            C0523q3 c0523q3 = this.f1030a;
            byte[] bytes = "hBnBQbZrmjPXEWVJ".getBytes();
            c0523q3.getClass();
            AESEncrypter aESEncrypter = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bytes, copyOfRange);
            if (bArr != null && bArr.length != 0) {
                return this.b.uncompress(aESEncrypter.decrypt(bArr, 16, bArr.length - 16));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public C0547r3(C0523q3 c0523q3, GZIPCompressor gZIPCompressor) {
        this.f1030a = c0523q3;
        this.b = gZIPCompressor;
    }
}
