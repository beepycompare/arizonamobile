package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.internal.play_billing.zzjd;
import java.util.concurrent.ExecutorService;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
final class IsBillingProgramAvailableDelegateToBackendCallback extends com.google.android.gms.internal.play_billing.zzab {
    private static final String TAG = "IsBillingProgramAvailableDelegateToBackendCallback";
    final int billingApiVersion;
    final zzcz billingLogger;
    final int billingProgram;
    final ExecutorService executorService;
    final Handler handler;
    final BillingProgramAvailabilityListener listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IsBillingProgramAvailableDelegateToBackendCallback(BillingProgramAvailabilityListener billingProgramAvailabilityListener, int i, zzcz zzczVar, int i2, Handler handler, ExecutorService executorService) {
        billingProgramAvailabilityListener.getClass();
        this.listener = billingProgramAvailabilityListener;
        this.billingProgram = i;
        this.billingLogger = zzczVar;
        this.billingApiVersion = i2;
        this.handler = handler;
        this.executorService = executorService;
    }

    @Override // com.google.android.gms.internal.play_billing.zzac
    public void onDelegateToBackendResponse(Bundle bundle) {
        BillingProgramAvailabilityDetails billingProgramAvailabilityDetails = new BillingProgramAvailabilityDetails(this.billingProgram);
        if (bundle == null) {
            zzcz zzczVar = this.billingLogger;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_FROM_DELEGATE_TO_BACKEND_SERVICE_CALL;
            BillingResult billingResult = zzdc.zzh;
            zzde.zza(zzjdVar, billingResult, zzczVar, zzdf.IS_BILLING_PROGRAM_AVAILABLE_ASYNC.zzb(), this.billingApiVersion);
            this.listener.onBillingProgramAvailabilityResponse(billingResult, billingProgramAvailabilityDetails);
            return;
        }
        zzdf zzdfVar = zzdf.IS_BILLING_PROGRAM_AVAILABLE_ASYNC;
        BillingResult zza = zzdh.zza(bundle, TAG, zzdfVar.zzb(), this.billingLogger, this.billingApiVersion);
        BillingProgramAvailabilityListener billingProgramAvailabilityListener = this.listener;
        if (billingProgramAvailabilityListener == null) {
            zzde.zza(zzjd.NULL_LISTENER_IN_DELEGATE_TO_BACKEND_CALLBACK, zza, this.billingLogger, zzdfVar.zzb(), this.billingApiVersion);
            return;
        }
        billingProgramAvailabilityListener.onBillingProgramAvailabilityResponse(zza, billingProgramAvailabilityDetails);
    }
}
