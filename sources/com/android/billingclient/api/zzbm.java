package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzjd;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
final class zzbm implements Callable {
    final /* synthetic */ PurchasesResponseListener zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ BillingClientImpl zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbm(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener, String str, boolean z) {
        this.zza = purchasesResponseListener;
        this.zzb = str;
        this.zzc = z;
        Objects.requireNonNull(billingClientImpl);
        this.zzd = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        boolean zzbl;
        zzdz zzbq;
        BillingClientImpl billingClientImpl = this.zzd;
        zzbl = billingClientImpl.zzbl(30000L);
        if (!zzbl) {
            zzjd zzjdVar = zzjd.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzdc.zzj;
            billingClientImpl.zzbs(zzjdVar, 9, billingResult);
            this.zza.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzbw.zzk());
            return null;
        }
        String str = this.zzb;
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Please provide a valid product type.");
            zzjd zzjdVar2 = zzjd.EMPTY_PRODUCT_TYPE;
            BillingResult billingResult2 = zzdc.zze;
            billingClientImpl.zzbs(zzjdVar2, 9, billingResult2);
            this.zza.onQueryPurchasesResponse(billingResult2, com.google.android.gms.internal.play_billing.zzbw.zzk());
            return null;
        }
        zzbq = billingClientImpl.zzbq(str, this.zzc, 9);
        List zzb = zzbq.zzb();
        PurchasesResponseListener purchasesResponseListener = this.zza;
        if (zzb != null) {
            purchasesResponseListener.onQueryPurchasesResponse(zzbq.zza(), zzbq.zzb());
            return null;
        }
        purchasesResponseListener.onQueryPurchasesResponse(zzbq.zza(), com.google.android.gms.internal.play_billing.zzbw.zzk());
        return null;
    }
}
