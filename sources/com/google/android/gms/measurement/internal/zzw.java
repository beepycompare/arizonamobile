package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzql;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzw extends BroadcastReceiver {
    private final zzib zza;

    public zzw(zzib zzibVar) {
        this.zza = zzibVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        char c;
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
                c = 1;
            }
            c = 65535;
        } else {
            if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
                c = 0;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c == 1) {
                zzib zzibVar = this.zza;
                zzibVar.zzaV().zzk().zza("[sgtm] App Receiver notified batches are available");
                zzibVar.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzw.this.zza();
                    }
                });
                return;
            }
            this.zza.zzaV().zze().zza("App receiver called with unknown action");
            return;
        }
        final zzib zzibVar2 = this.zza;
        zzql.zza();
        if (zzibVar2.zzc().zzp(null, zzfx.zzaQ)) {
            zzibVar2.zzaV().zzk().zza("App receiver notified triggers are available");
            zzibVar2.zzaW().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzu
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzib zzibVar3 = zzib.this;
                    if (!zzibVar3.zzk().zzS()) {
                        zzibVar3.zzaV().zze().zza("registerTrigger called but app not eligible");
                        return;
                    }
                    zzibVar3.zzj().zzv();
                    final zzli zzj = zzibVar3.zzj();
                    Objects.requireNonNull(zzj);
                    new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzv
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzli.this.zzw();
                        }
                    }).start();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza() {
        this.zza.zzx().zzh(((Long) zzfx.zzC.zzb(null)).longValue());
    }
}
