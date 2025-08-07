package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import java.util.Arrays;
/* renamed from: io.appmetrica.analytics.impl.r3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0548r3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0524q3 f1029a;
    public final GZIPCompressor b;

    public C0548r3() {
        this(new C0524q3(), new GZIPCompressor());
    }

    public final byte[] a(byte[] bArr) {
        try {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            C0524q3 c0524q3 = this.f1029a;
            byte[] bytes = "hBnBQbZrmjPXEWVJ".getBytes();
            c0524q3.getClass();
            AESEncrypter aESEncrypter = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bytes, copyOfRange);
            if (bArr != null && bArr.length != 0) {
                return this.b.uncompress(aESEncrypter.decrypt(bArr, 16, bArr.length - 16));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public C0548r3(C0524q3 c0524q3, GZIPCompressor gZIPCompressor) {
        this.f1029a = c0524q3;
        this.b = gZIPCompressor;
    }
}
