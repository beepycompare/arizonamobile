package com.android.billingclient.api;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class zzbs implements BillingClientStateListener {
    final /* synthetic */ com.google.android.gms.internal.play_billing.zzp zza;
    final /* synthetic */ BillingClientImpl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbs(BillingClientImpl billingClientImpl, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        this.zza = zzpVar;
        Objects.requireNonNull(billingClientImpl);
        this.zzb = billingClientImpl;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        BillingClientStateListener billingClientStateListener;
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection attempt failed.");
        try {
            this.zza.zzb(zzdc.zzj);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        billingClientStateListener = billingClientImpl.zzH;
        if (billingClientStateListener != null) {
            billingClientImpl.zzao(new Runnable() { // from class: com.android.billingclient.api.zzbq
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientStateListener billingClientStateListener2;
                    try {
                        billingClientStateListener2 = zzbs.this.zzb.zzH;
                        billingClientStateListener2.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception calling onBillingServiceDisconnected.", th2);
                    }
                }
            });
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(final BillingResult billingResult) {
        BillingClientStateListener billingClientStateListener;
        int responseCode = billingResult.getResponseCode();
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection finished with result: " + responseCode);
        try {
            this.zza.zzb(billingResult);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        billingClientStateListener = billingClientImpl.zzH;
        if (billingClientStateListener != null) {
            billingClientImpl.zzao(new Runnable() { // from class: com.android.billingclient.api.zzbr
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientStateListener billingClientStateListener2;
                    zzbs zzbsVar = zzbs.this;
                    BillingResult billingResult2 = billingResult;
                    try {
                        billingClientStateListener2 = zzbsVar.zzb.zzH;
                        billingClientStateListener2.onBillingSetupFinished(billingResult2);
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception calling onBillingSetupFinished.", th2);
                    }
                }
            });
        }
    }
}
