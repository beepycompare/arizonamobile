package com.google.android.play.core.splitinstall.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* loaded from: classes4.dex */
public final class zzae implements ServiceConnection {
    final /* synthetic */ zzaf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzae(zzaf zzafVar, zzad zzadVar) {
        this.zza = zzafVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzaf.zzf(this.zza).zzd("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        zzaf zzafVar = this.zza;
        zzafVar.zzc().post(new zzab(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzaf.zzf(this.zza).zzd("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        zzaf zzafVar = this.zza;
        zzafVar.zzc().post(new zzac(this));
    }
}
