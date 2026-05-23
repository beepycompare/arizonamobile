package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzrq extends zzso {
    private final List zza;

    private zzrq(OutputStream outputStream, List list) {
        super(outputStream);
        this.zza = list;
    }

    @Nullable
    public static zzrq zza(List list, Uri uri, OutputStream outputStream) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzta zzb = ((zztb) it.next()).zzb();
            if (zzb != null) {
                arrayList.add(zzb);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzrq(outputStream, arrayList);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        for (zzta zztaVar : this.zza) {
            try {
                zztaVar.close();
            } catch (Throwable unused) {
            }
        }
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        this.out.write(i);
        for (zzta zztaVar : this.zza) {
            zztaVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzso, java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
        for (zzta zztaVar : this.zza) {
            int length = bArr.length;
            zztaVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzso, java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        for (zzta zztaVar : this.zza) {
            zztaVar.zza();
        }
    }
}
