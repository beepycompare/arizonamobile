package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final class zzbx extends com.google.android.gms.internal.play_billing.zzw {
    final AlternativeBillingOnlyReportingDetailsListener zza;
    final zzcz zzb;
    final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbx(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, zzcz zzczVar, int i, zzch zzchVar) {
        this.zza = alternativeBillingOnlyReportingDetailsListener;
        this.zzb = zzczVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzx
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            zzcz zzczVar = this.zzb;
            zzjd zzjdVar = zzjd.NULL_BUNDLE_FROM_CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL;
            BillingResult billingResult = zzdc.zzh;
            int i = zzcy.zza;
            zzczVar.zzb(zzcy.zzb(zzjdVar, 15, billingResult, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(billingResult, null);
            return;
        }
        int zzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        BillingResult zza = zzdc.zza(zzb, com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient"));
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: " + zzb);
            zzcz zzczVar2 = this.zzb;
            zzjd zzjdVar2 = zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i2 = zzcy.zza;
            zzczVar2.zzb(zzcy.zzb(zzjdVar2, 15, zza, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zza, null);
            return;
        }
        try {
            this.zza.onAlternativeBillingOnlyTokenResponse(zza, new AlternativeBillingOnlyReportingDetails(bundle.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS")));
        } catch (JSONException e) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", e);
            zzcz zzczVar3 = this.zzb;
            zzjd zzjdVar3 = zzjd.ERROR_DECODING_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS;
            BillingResult billingResult2 = zzdc.zzh;
            int i3 = zzcy.zza;
            zzczVar3.zzb(zzcy.zzb(zzjdVar3, 15, billingResult2, null, zzjk.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(billingResult2, null);
        }
    }
}
