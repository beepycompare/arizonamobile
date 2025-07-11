package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzoj extends zzor {
    private final AlarmManager zza;
    private zzay zzb;
    private Integer zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzoj(zzpf zzpfVar) {
        super(zzpfVar);
        this.zza = (AlarmManager) this.zzu.zzaY().getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    private final zzay zzf() {
        if (this.zzb == null) {
            this.zzb = new zzoi(this, this.zzg.zzaf());
        }
        return this.zzb;
    }

    private final void zzh() {
        JobScheduler jobScheduler = (JobScheduler) this.zzu.zzaY().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzi());
        }
    }

    private final int zzi() {
        if (this.zzc == null) {
            String packageName = this.zzu.zzaY().getPackageName();
            String.valueOf(packageName);
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(packageName)).hashCode());
        }
        return this.zzc.intValue();
    }

    private final PendingIntent zzj() {
        Context zzaY = this.zzu.zzaY();
        return PendingIntent.getBroadcast(zzaY, 0, new Intent().setClassName(zzaY, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzcg.zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        zzh();
        return false;
    }

    public final void zzc(long j) {
        zzay();
        zzib zzibVar = this.zzu;
        zzibVar.zzaU();
        Context zzaY = zzibVar.zzaY();
        if (!zzpo.zzau(zzaY)) {
            zzibVar.zzaV().zzj().zza("Receiver not registered/enabled");
        }
        if (!zzpo.zzQ(zzaY, false)) {
            zzibVar.zzaV().zzj().zza("Service not registered/enabled");
        }
        zzd();
        zzibVar.zzaV().zzk().zzb("Scheduling upload, millis", Long.valueOf(j));
        zzibVar.zzaZ().elapsedRealtime();
        zzibVar.zzc();
        if (j < Math.max(0L, ((Long) zzfx.zzL.zzb(null)).longValue()) && !zzf().zzc()) {
            zzf().zzb(j);
        }
        zzibVar.zzaU();
        Context zzaY2 = zzibVar.zzaY();
        ComponentName componentName = new ComponentName(zzaY2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int zzi = zzi();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.zzch.zza(zzaY2, new JobInfo.Builder(zzi, componentName).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void zzd() {
        zzay();
        this.zzu.zzaV().zzk().zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzj());
        }
        zzf().zzd();
        zzh();
    }
}
