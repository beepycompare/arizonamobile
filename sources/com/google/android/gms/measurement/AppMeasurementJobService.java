package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzno;
import com.google.android.gms.measurement.internal.zzns;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class AppMeasurementJobService extends JobService implements zzno {
    private zzns zza;

    private final zzns zzd() {
        if (this.zza == null) {
            this.zza = new zzns(this);
        }
        return this.zza;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        zzd().zza();
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzd().zzb();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        zzd();
        zzns.zzi(intent);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        zzd().zze(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        zzd();
        zzns.zzj(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzno
    public final boolean zza(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzno
    public final void zzb(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzno
    public final void zzc(Intent intent) {
    }
}
