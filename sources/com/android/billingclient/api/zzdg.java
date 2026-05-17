package com.android.billingclient.api;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzhx;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzdg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle zza(com.google.android.gms.internal.play_billing.zzdy zzdyVar, zzhx zzhxVar) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("REQUEST_METADATA", zzdyVar.zzQ());
        bundle.putByteArray("REQUEST_PARAMS", zzhxVar.zzQ());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.internal.play_billing.zzdy zzb(String str, int i, Context context, String str2) {
        String str3;
        com.google.android.gms.internal.play_billing.zzdx zza = com.google.android.gms.internal.play_billing.zzdy.zza();
        zza.zzd(str);
        zza.zze(24);
        zza.zzb(context.getPackageName());
        zza.zzc(str2);
        try {
            str3 = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            com.google.android.gms.internal.play_billing.zzc.zzo("DelegationApiParamsBuilder", "No version code is found!");
            str3 = null;
        }
        if (str3 != null) {
            zza.zza(str3);
        }
        return (com.google.android.gms.internal.play_billing.zzdy) zza.zzi();
    }
}
