package com.google.android.gms.measurement.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzlp extends zzg {
    private JobScheduler zza;

    public zzlp(zzib zzibVar) {
        super(zzibVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final void zzf() {
        this.zza = (JobScheduler) this.zzu.zzaY().getSystemService("jobscheduler");
    }

    public final void zzh(long j) {
        zzb();
        zzg();
        JobScheduler jobScheduler = this.zza;
        if (jobScheduler == null || jobScheduler.getPendingJob(zzi()) == null) {
            com.google.android.gms.internal.measurement.zzin zzj = zzj();
            if (zzj == com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE) {
                zzib zzibVar = this.zzu;
                zzibVar.zzaV().zzk().zzb("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j));
                PersistableBundle persistableBundle = new PersistableBundle();
                persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
                zzibVar.zzaV().zzk().zzb("[sgtm] Scion upload job scheduled with result", ((JobScheduler) Preconditions.checkNotNull(this.zza)).schedule(new JobInfo.Builder(zzi(), new ComponentName(zzibVar.zzaY(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j).setOverrideDeadline(j + j).setExtras(persistableBundle).build()) == 1 ? "SUCCESS" : "FAILURE");
                return;
            }
            this.zzu.zzaV().zzk().zzb("[sgtm] Not eligible for Scion upload", zzj.name());
            return;
        }
        this.zzu.zzaV().zzk().zza("[sgtm] There's an existing pending job, skip this schedule.");
    }

    final int zzi() {
        String packageName = this.zzu.zzaY().getPackageName();
        String.valueOf(packageName);
        return "measurement-client".concat(String.valueOf(packageName)).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzin zzj() {
        zzb();
        zzg();
        if (this.zza != null) {
            zzib zzibVar = this.zzu;
            if (zzibVar.zzc().zzx()) {
                zzib zzibVar2 = this.zzu;
                return zzibVar2.zzv().zzn() >= 119000 ? !zzpo.zzR(zzibVar.zzaY(), "com.google.android.gms.measurement.AppMeasurementJobService") ? com.google.android.gms.internal.measurement.zzin.MEASUREMENT_SERVICE_NOT_ENABLED : !zzibVar2.zzt().zzK() ? com.google.android.gms.internal.measurement.zzin.NON_PLAY_MODE : com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE : com.google.android.gms.internal.measurement.zzin.SDK_TOO_OLD;
            }
            return com.google.android.gms.internal.measurement.zzin.NOT_ENABLED_IN_MANIFEST;
        }
        return com.google.android.gms.internal.measurement.zzin.MISSING_JOB_SCHEDULER;
    }
}
