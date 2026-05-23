package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzyi;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public class zzxi<API extends zzyi<API>> {
    private final zzzf zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzxi(zzzf zzzfVar) {
        this.zza = zzzfVar;
    }

    private static void zzd(String str, zzzd zzzdVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat(AppUpdateInfo.Factory.UPDATED_FORMAT).format(new Date(TimeUnit.NANOSECONDS.toMillis(zzzdVar.zzf()))));
        sb.append(": logging error [");
        zzze.zza(1, zzzdVar.zzg(), sb);
        sb.append("]: ");
        sb.append(str);
        System.err.println(sb);
        System.err.flush();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zza() {
        return this.zza.zza();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzb(Level level) {
        return this.zza.zzb(level);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zzzd zzzdVar) {
        try {
            zzabt zzc = zzabt.zzc();
            if (zzc.zzb() <= 100) {
                this.zza.zzc(zzzdVar);
            } else {
                zzd("unbounded recursion in log statement", zzzdVar);
            }
            if (zzc != null) {
                zzc.close();
            }
        } catch (RuntimeException e) {
            try {
                this.zza.zzd(e, zzzdVar);
            } catch (zzzg e2) {
                throw e2;
            } catch (RuntimeException e3) {
                String name = e3.getClass().getName();
                String message = e3.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 2 + String.valueOf(message).length());
                sb.append(name);
                sb.append(": ");
                sb.append(message);
                zzd(sb.toString(), zzzdVar);
                try {
                    e3.printStackTrace(System.err);
                } catch (RuntimeException unused) {
                }
            }
        }
    }
}
