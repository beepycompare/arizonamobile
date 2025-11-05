package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzhj implements ServiceConnection {
    final /* synthetic */ zzhk zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhj(zzhk zzhkVar, String str) {
        Objects.requireNonNull(zzhkVar);
        this.zza = zzhkVar;
        this.zzb = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                com.google.android.gms.internal.measurement.zzbq zzb = com.google.android.gms.internal.measurement.zzbp.zzb(iBinder);
                if (zzb == null) {
                    this.zza.zza.zzaV().zze().zza("Install Referrer Service implementation was not found");
                    return;
                }
                zzic zzicVar = this.zza.zza;
                zzicVar.zzaV().zzk().zza("Install Referrer Service connected");
                zzicVar.zzaW().zzj(new zzhi(this, zzb, this));
                return;
            } catch (RuntimeException e) {
                this.zza.zza.zzaV().zze().zzb("Exception occurred while calling Install Referrer API", e);
                return;
            }
        }
        this.zza.zza.zzaV().zze().zza("Install Referrer connection returned with null binder");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zza.zza.zzaV().zzk().zza("Install Referrer Service disconnected");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zza() {
        return this.zzb;
    }
}
