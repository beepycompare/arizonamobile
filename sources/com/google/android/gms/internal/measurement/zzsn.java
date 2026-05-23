package com.google.android.gms.internal.measurement;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public class zzsn extends FilterInputStream {
    public zzsn(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.in.read(bArr);
    }
}
