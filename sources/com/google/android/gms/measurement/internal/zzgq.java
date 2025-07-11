package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzgq implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzgt zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgq(zzgt zzgtVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
        Objects.requireNonNull(zzgtVar);
        this.zzf = zzgtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgt zzgtVar = this.zzf;
        zzhg zzd = zzgtVar.zzu.zzd();
        if (zzd.zzv()) {
            if (zzgtVar.zzr() == 0) {
                zzib zzibVar = zzgtVar.zzu;
                if (zzibVar.zzc().zzj()) {
                    zzibVar.zzaU();
                    zzgtVar.zzs('C');
                } else {
                    zzibVar.zzaU();
                    zzgtVar.zzs('c');
                }
            }
            if (zzgtVar.zzt() < 0) {
                zzgtVar.zzu.zzc().zzi();
                zzgtVar.zzu(130000L);
            }
            int i = this.zza;
            char zzr = zzgtVar.zzr();
            long zzt = zzgtVar.zzt();
            String str = this.zzb;
            Object obj = this.zzc;
            Object obj2 = this.zzd;
            Object obj3 = this.zze;
            char charAt = "01VDIWEA?".charAt(i);
            String zzo = zzgt.zzo(true, str, obj, obj2, obj3);
            int length = String.valueOf(charAt).length();
            StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(zzr).length() + String.valueOf(zzt).length() + 1 + zzo.length());
            sb.append(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(zzr);
            sb.append(zzt);
            sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
            sb.append(zzo);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = str.substring(0, 1024);
            }
            zzhe zzheVar = zzd.zzb;
            if (zzheVar != null) {
                zzheVar.zza(sb2, 1L);
                return;
            }
            return;
        }
        Log.println(6, zzgtVar.zzn(), "Persisted config not initialized. Not logging error/warn");
    }
}
