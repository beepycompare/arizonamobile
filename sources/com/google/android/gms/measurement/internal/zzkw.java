package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.firebase.messaging.Constants;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzkw implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzkx zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkw(zzkx zzkxVar, boolean z, Uri uri, String str, String str2) {
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
        Objects.requireNonNull(zzkxVar);
        this.zze = zzkxVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8 A[Catch: RuntimeException -> 0x0153, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0153, blocks: (B:3:0x000d, B:31:0x0099, B:33:0x00a3, B:36:0x00b0, B:38:0x00b6, B:39:0x00c9, B:40:0x00d1, B:43:0x00d8, B:47:0x00f9, B:50:0x0111, B:49:0x0103, B:52:0x0115, B:54:0x011b, B:56:0x0121, B:58:0x0127, B:60:0x012d, B:62:0x0135, B:64:0x013d, B:66:0x0143, B:68:0x0147, B:7:0x0029, B:9:0x002f, B:11:0x0037, B:13:0x003d, B:15:0x0043, B:17:0x0049, B:19:0x0051, B:21:0x0059, B:23:0x0061, B:25:0x0069, B:26:0x0077, B:28:0x008c), top: B:73:0x000d }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Bundle zzi;
        String str;
        Bundle zzi2;
        zzkx zzkxVar = this.zze;
        zzli zzliVar = zzkxVar.zza;
        zzliVar.zzg();
        String str2 = this.zzd;
        Uri uri = this.zzb;
        try {
            zzib zzibVar = zzliVar.zzu;
            zzpo zzk = zzibVar.zzk();
            if (!TextUtils.isEmpty(str2)) {
                if (str2.contains("gclid") || str2.contains("gbraid") || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id")) {
                    String.valueOf(str2);
                    zzi = zzk.zzi(Uri.parse("https://google.com/search?".concat(String.valueOf(str2))));
                    if (zzi != null) {
                        zzi.putString("_cis", Constants.REFERRER);
                    }
                    str = this.zzc;
                    if (this.zza && (zzi2 = zzibVar.zzk().zzi(uri)) != null) {
                        zzi2.putString("_cis", "intent");
                        if (!zzi2.containsKey("gclid") && zzi != null && zzi.containsKey("gclid")) {
                            zzi2.putString("_cer", String.format("gclid=%s", zzi.getString("gclid")));
                        }
                        zzliVar.zzF(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi2);
                        zzliVar.zzb.zzb(str, zzi2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        zzibVar.zzaV().zzj().zzb("Activity created with referrer", str2);
                        if (zzibVar.zzc().zzp(null, zzfx.zzaG)) {
                            if (zzi != null) {
                                zzliVar.zzF(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi);
                                zzliVar.zzb.zzb(str, zzi);
                            } else {
                                zzibVar.zzaV().zzj().zzb("Referrer does not contain valid parameters", str2);
                            }
                            zzliVar.zzK("auto", "_ldl", null, true);
                            return;
                        } else if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                            zzibVar.zzaV().zzj().zza("Activity created with data 'referrer' without required params");
                            return;
                        } else if (TextUtils.isEmpty(str2)) {
                            return;
                        } else {
                            zzliVar.zzK("auto", "_ldl", str2, true);
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
                zzliVar.zzF(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi2);
                zzliVar.zzb.zzb(str, zzi2);
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (RuntimeException e) {
            zzkxVar.zza.zzu.zzaV().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
