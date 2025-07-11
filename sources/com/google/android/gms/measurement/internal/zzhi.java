package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhi implements ServiceConnection {
    final /* synthetic */ zzhj zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhi(zzhj zzhjVar, String str) {
        Objects.requireNonNull(zzhjVar);
        this.zza = zzhjVar;
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
                zzib zzibVar = this.zza.zza;
                zzibVar.zzaV().zzk().zza("Install Referrer Service connected");
                zzibVar.zzaW().zzj(new zzhh(this, zzb, this));
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
