package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzqp;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzw extends BroadcastReceiver {
    private final zzic zza;

    public zzw(zzic zzicVar) {
        this.zza = zzicVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.zza.zzaV().zze().zza("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.zza.zzaV().zze().zza("App receiver called with null action");
            return;
        }
        int hashCode = action.hashCode();
        if (hashCode != -1928239649) {
            if (hashCode == 1279883384 && action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
                zzic zzicVar = this.zza;
                zzicVar.zzaV().zzk().zza("[sgtm] App Receiver notified batches are available");
                zzicVar.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzw.this.zza();
                    }
                });
                return;
            }
        } else if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final zzic zzicVar2 = this.zza;
            zzqp.zza();
            if (zzicVar2.zzc().zzp(null, zzfy.zzaQ)) {
                zzicVar2.zzaV().zzk().zza("App receiver notified triggers are available");
                zzicVar2.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzu
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzic zzicVar3 = zzic.this;
                        if (!zzicVar3.zzk().zzS()) {
                            zzicVar3.zzaV().zze().zza("registerTrigger called but app not eligible");
                            return;
                        }
                        zzicVar3.zzj().zzv();
                        final zzlj zzj = zzicVar3.zzj();
                        Objects.requireNonNull(zzj);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzv
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzlj.this.zzw();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        this.zza.zzaV().zze().zza("App receiver called with unknown action");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza() {
        this.zza.zzx().zzh(((Long) zzfy.zzC.zzb(null)).longValue());
    }
}
