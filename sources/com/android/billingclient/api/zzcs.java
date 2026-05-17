package com.android.billingclient.api;

import androidx.core.util.Consumer;
import com.google.android.gms.internal.play_billing.zzjd;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class zzcs implements com.google.android.gms.internal.play_billing.zzcv {
    final /* synthetic */ Consumer zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzcw zzc;
    final /* synthetic */ int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcs(zzcw zzcwVar, int i, Consumer consumer, Runnable runnable) {
        this.zzd = i;
        this.zza = consumer;
        this.zzb = runnable;
        Objects.requireNonNull(zzcwVar);
        this.zzc = zzcwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcv
    public final void zza(Throwable th) {
        boolean z = th instanceof TimeoutException;
        zzcw zzcwVar = this.zzc;
        if (z) {
            zzcwVar.zzaN(zzjd.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT, 28, zzdc.zzE);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            zzcwVar.zzaN(zzjd.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION, 28, zzdc.zzE);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        this.zzb.run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        boolean zzaK;
        BillingResult zzaL;
        Integer num = (Integer) obj;
        int intValue = num.intValue();
        zzcw zzcwVar = this.zzc;
        zzaK = zzcw.zzaK(intValue);
        if (zzaK) {
            zzaL = zzcwVar.zzaL(this.zzd, num.intValue());
            this.zza.accept(zzaL);
            return;
        }
        this.zzb.run();
    }
}
