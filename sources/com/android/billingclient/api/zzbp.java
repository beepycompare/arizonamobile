package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import java.util.Objects;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
final class zzbp extends ResultReceiver {
    final /* synthetic */ ExternalOfferInformationDialogListener zza;
    final /* synthetic */ BillingClientImpl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbp(BillingClientImpl billingClientImpl, Handler handler, ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        super(handler);
        this.zza = externalOfferInformationDialogListener;
        Objects.requireNonNull(billingClientImpl);
        this.zzb = billingClientImpl;
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i, Bundle bundle) {
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(i);
        if (i != 0) {
            if (bundle == null) {
                this.zzb.zzaX(this.zza, zzdc.zzh, zzjd.NULL_BUNDLE_IN_EXTERNAL_PAYMENT_INFORMATION_DIALOG_RECEIVER, null);
                return;
            }
            newBuilder.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzk(bundle, "BillingClient"));
            int i2 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            BillingClientImpl billingClientImpl = this.zzb;
            zzjd zzb = i2 != 0 ? zzjd.zzb(i2) : zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            BillingResult build = newBuilder.build();
            String string = bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS");
            int i3 = zzcy.zza;
            billingClientImpl.zzbc(zzcy.zzb(zzb, 25, build, string, zzjk.BROADCAST_ACTION_UNSPECIFIED));
        }
        this.zza.onExternalOfferInformationDialogResponse(newBuilder.build());
    }
}
