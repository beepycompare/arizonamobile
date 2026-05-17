package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziy;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjb;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjk;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzcy {
    public static final /* synthetic */ int zza = 0;

    static {
        int i = zzcz.zza;
    }

    public static String zza(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String str = exc.getClass().getSimpleName() + StringUtils.PROCESS_POSTFIX_DELIMITER + com.google.android.gms.internal.play_billing.zzbm.zzc(exc.getMessage());
            int i = com.google.android.gms.internal.play_billing.zzc.zza;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static zziw zzb(zzjd zzjdVar, int i, BillingResult billingResult, String str, zzjk zzjkVar) {
        try {
            zzjb zza2 = zzjf.zza();
            zza2.zzp(billingResult.getResponseCode());
            zza2.zzb(billingResult.getDebugMessage());
            if (billingResult.getOnPurchasesUpdatedSubResponseCode() != 0) {
                zza2.zzd(billingResult.getOnPurchasesUpdatedSubResponseCode());
            }
            if (zzjdVar != null) {
                zza2.zze(zzjdVar);
            }
            if (str != null) {
                zza2.zza(str);
            }
            zziu zza3 = zziw.zza();
            zza3.zzb(zza2);
            zza3.zzp(i);
            if (!zzjkVar.equals(zzjk.BROADCAST_ACTION_UNSPECIFIED)) {
                zza3.zza(zzjkVar);
            }
            return (zziw) zza3.zzi();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static zzja zzc(int i, zzjk zzjkVar) {
        try {
            zziy zza2 = zzja.zza();
            zza2.zze(i);
            if (!zzjkVar.equals(zzjk.BROADCAST_ACTION_UNSPECIFIED)) {
                zza2.zza(zzjkVar);
            }
            return (zzja) zza2.zzi();
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
