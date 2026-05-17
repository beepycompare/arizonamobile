package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
final class zzcu implements ServiceConnection {
    final /* synthetic */ zzcw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcu(zzcw zzcwVar, zzcv zzcvVar) {
        Objects.requireNonNull(zzcwVar);
        this.zza = zzcwVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Billing Override Service connected.");
        zzcw zzcwVar = this.zza;
        zzcw.zzay(zzcwVar, com.google.android.gms.internal.play_billing.zzax.zzb(iBinder));
        zzcw.zzaz(zzcwVar, 2);
        zzcw.zzaF(zzcwVar, 26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "Billing Override Service disconnected.");
        zzcw zzcwVar = this.zza;
        zzcw.zzay(zzcwVar, null);
        zzcw.zzaz(zzcwVar, 0);
    }
}
