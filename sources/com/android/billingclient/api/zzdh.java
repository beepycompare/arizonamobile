package com.android.billingclient.api;

import android.os.Bundle;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzjd;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
final class zzdh {
    public static BillingResult zza(Bundle bundle, String str, int i, zzcz zzczVar, int i2) {
        if (bundle.containsKey("BILLING_RESULT")) {
            try {
                byte[] byteArray = bundle.getByteArray("BILLING_RESULT");
                if (byteArray == null) {
                    throw new Exception("Billing result is null");
                }
                com.google.android.gms.internal.play_billing.zzdw zzc = com.google.android.gms.internal.play_billing.zzdw.zzc(byteArray);
                BillingResult.Builder newBuilder = BillingResult.newBuilder();
                newBuilder.setResponseCode(zzc.zza());
                newBuilder.setDebugMessage(zzc.zze());
                BillingResult build = newBuilder.build();
                if (build.getResponseCode() != 0) {
                    zzde.zza(zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, build, zzczVar, i, i2);
                    return build;
                } else if (bundle.containsKey("RESPONSE_DATA")) {
                    return build;
                } else {
                    com.google.android.gms.internal.play_billing.zzc.zzo(str, "delegateToBackendAsync returned a bundle with neither an error nor response data");
                    zzjd zzjdVar = zzjd.MISSING_RESPONSE_DATA_IN_DELEGATE_TO_BACKEND_RESPONSE;
                    BillingResult billingResult = zzdc.zzh;
                    zzde.zza(zzjdVar, billingResult, zzczVar, i, i2);
                    return billingResult;
                }
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzc.zzp(str, "Failed parsing BillingResult.", e);
                zzjd zzjdVar2 = zzjd.ERROR_DECODING_DELEGATE_TO_BACKEND_BILLING_RESULT;
                BillingResult billingResult2 = zzdc.zzh;
                zzde.zzb(zzjdVar2, billingResult2, zzczVar, i, i2, zzcy.zza(e));
                return billingResult2;
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzo(str, "delegateToBackendAsync does not contain a billing result in the response");
        zzjd zzjdVar3 = zzjd.MISSING_BILLING_RESULT_IN_DELEGATE_TO_BACKEND_RESPONSE;
        BillingResult billingResult3 = zzdc.zzh;
        zzde.zza(zzjdVar3, billingResult3, zzczVar, i, i2);
        return billingResult3;
    }
}
