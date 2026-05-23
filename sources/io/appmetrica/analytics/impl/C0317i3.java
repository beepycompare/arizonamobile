package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.i3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0317i3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0291h3 f1026a;
    public final GZIPCompressor b;

    public C0317i3() {
        this(new C0291h3(), new GZIPCompressor());
    }

    public final byte[] a(byte[] bArr) {
        try {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            C0291h3 c0291h3 = this.f1026a;
            byte[] bytes = "hBnBQbZrmjPXEWVJ".getBytes();
            c0291h3.getClass();
            AESEncrypter aESEncrypter = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bytes, copyOfRange);
            if (bArr != null && bArr.length != 0) {
                return this.b.uncompress(aESEncrypter.decrypt(bArr, 16, bArr.length - 16));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public C0317i3(C0291h3 c0291h3, GZIPCompressor gZIPCompressor) {
        this.f1026a = c0291h3;
        this.b = gZIPCompressor;
    }
}
