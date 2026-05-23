package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzsv implements zzrt {
    private final zzafc zza;
    private zzro[] zzb;

    private zzsv(zzafc zzafcVar) {
        this.zza = zzafcVar;
    }

    public static zzsv zzb(zzafc zzafcVar) {
        return new zzsv(zzafcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) throws IOException {
        Uri zza = zzsu.zza(zzrsVar.zzb());
        List zzd = zzrsVar.zzd(zzrsVar.zza().zzj(zza));
        zzro[] zzroVarArr = this.zzb;
        if (zzroVarArr != null) {
            zzroVarArr[0].zza(zzd);
        }
        try {
            OutputStream outputStream = (OutputStream) zzd.get(0);
            this.zza.zzce(outputStream);
            zzro[] zzroVarArr2 = this.zzb;
            if (zzroVarArr2 != null) {
                zzroVarArr2[0].zzb();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            zzrsVar.zza().zzl(zza, zzrsVar.zzb());
            return null;
        } catch (Exception e) {
            try {
                zzrsVar.zza().zzk(zza);
            } catch (FileNotFoundException unused) {
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            throw new IOException(e);
        }
    }

    public final zzsv zzc(zzro... zzroVarArr) {
        this.zzb = zzroVarArr;
        return this;
    }
}
