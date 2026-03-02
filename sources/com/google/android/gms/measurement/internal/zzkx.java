package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.firebase.messaging.Constants;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzkx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzky zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkx(zzky zzkyVar, boolean z, Uri uri, String str, String str2) {
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        Objects.requireNonNull(zzkyVar);
        this.zze = zzkyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00de A[Catch: RuntimeException -> 0x015b, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x015b, blocks: (B:3:0x000d, B:31:0x009f, B:33:0x00a9, B:36:0x00b6, B:38:0x00bc, B:39:0x00cf, B:40:0x00d7, B:43:0x00de, B:47:0x00ff, B:50:0x0117, B:49:0x0109, B:52:0x011b, B:54:0x0121, B:56:0x0127, B:58:0x012d, B:60:0x0133, B:62:0x013c, B:64:0x0145, B:66:0x014b, B:68:0x014f, B:7:0x002c, B:9:0x0032, B:11:0x003a, B:13:0x0040, B:15:0x0046, B:17:0x004c, B:19:0x0055, B:21:0x005d, B:23:0x0066, B:25:0x006f, B:26:0x007d, B:28:0x0092), top: B:73:0x000d }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Bundle zzi;
        String str;
        Bundle zzi2;
        zzky zzkyVar = this.zze;
        zzlj zzljVar = zzkyVar.zza;
        zzljVar.zzg();
        String str2 = this.zzd;
        Uri uri = this.zzb;
        try {
            zzic zzicVar = zzljVar.zzu;
            zzpp zzk = zzicVar.zzk();
            if (!TextUtils.isEmpty(str2)) {
                if (str2.contains("gclid") || str2.contains("gbraid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id")) {
                    String.valueOf(str2);
                    zzi = zzk.zzi(Uri.parse("https://google.com/search?".concat(String.valueOf(str2))));
                    if (zzi != null) {
                        zzi.putString("_cis", Constants.REFERRER);
                    }
                    str = this.zzc;
                    if (this.zza && (zzi2 = zzicVar.zzk().zzi(uri)) != null) {
                        zzi2.putString("_cis", "intent");
                        if (!zzi2.containsKey("gclid") && zzi != null && zzi.containsKey("gclid")) {
                            zzi2.putString("_cer", String.format("gclid=%s", zzi.getString("gclid")));
                        }
                        zzljVar.zzF(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi2);
                        zzljVar.zzb.zzb(str, zzi2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        zzicVar.zzaV().zzj().zzb("Activity created with referrer", str2);
                        if (zzicVar.zzc().zzp(null, zzfy.zzaG)) {
                            if (zzi != null) {
                                zzljVar.zzF(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi);
                                zzljVar.zzb.zzb(str, zzi);
                            } else {
                                zzicVar.zzaV().zzj().zzb("Referrer does not contain valid parameters", str2);
                            }
                            zzljVar.zzK("auto", "_ldl", null, true);
                            return;
                        } else if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                            zzicVar.zzaV().zzj().zza("Activity created with data 'referrer' without required params");
                            return;
                        } else if (TextUtils.isEmpty(str2)) {
                            return;
                        } else {
                            zzljVar.zzK("auto", "_ldl", str2, true);
                            return;
                        }
                    }
                    return;
                }
                zzk.zzu.zzaV().zzj().zza("Activity created with data 'referrer' without required params");
            }
            zzi = null;
            str = this.zzc;
            if (this.zza) {
                zzi2.putString("_cis", "intent");
                if (!zzi2.containsKey("gclid")) {
                    zzi2.putString("_cer", String.format("gclid=%s", zzi.getString("gclid")));
                }
                zzljVar.zzF(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi2);
                zzljVar.zzb.zzb(str, zzi2);
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (RuntimeException e) {
            zzkyVar.zza.zzu.zzaV().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
