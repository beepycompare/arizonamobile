package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzrp extends zzsn {
    private final List zza;

    private zzrp(InputStream inputStream, List list) {
        super(inputStream);
        this.zza = list;
    }

    @Nullable
    public static zzrp zza(List list, Uri uri, InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzsz zza = ((zztb) it.next()).zza();
            if (zza != null) {
                arrayList.add(zza);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzrp(inputStream, arrayList);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        for (zzsz zzszVar : this.zza) {
            try {
                zzszVar.close();
            } catch (Throwable unused) {
            }
        }
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = this.in.read();
        if (read != -1) {
            for (zzsz zzszVar : this.zza) {
                zzszVar.zza();
            }
        }
        return read;
    }

    @Override // com.google.android.gms.internal.measurement.zzsn, java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int read = this.in.read(bArr);
        if (read != -1) {
            for (zzsz zzszVar : this.zza) {
                zzszVar.zza();
            }
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read != -1) {
            for (zzsz zzszVar : this.zza) {
                zzszVar.zza();
            }
        }
        return read;
    }
}
