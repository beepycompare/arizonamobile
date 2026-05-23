package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.DataFormatException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzmr extends InputStream {
    final /* synthetic */ zzmu zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmr(zzmu zzmuVar) {
        Objects.requireNonNull(zzmuVar);
        this.zza = zzmuVar;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == -1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            zzmu zzmuVar = this.zza;
            int inflate = zzmuVar.zzd().inflate(bArr, i, i2);
            if (inflate > 0) {
                return inflate;
            }
            if (i2 != 0) {
                if (zzmuVar.zzd().getRemaining() == 0) {
                    return -1;
                }
                int remaining = this.zza.zzd().getRemaining();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 70 + String.valueOf(remaining).length());
                sb.append("Read no bytes (requested up to ");
                sb.append(i2);
                sb.append(") but did not reach end of stream, had ");
                sb.append(remaining);
                throw new IOException(sb.toString());
            }
            return 0;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }
}
