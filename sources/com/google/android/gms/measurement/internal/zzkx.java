package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.adjust.sdk.Constants;
import com.google.firebase.messaging.Constants;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7 A[Catch: RuntimeException -> 0x0152, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0152, blocks: (B:3:0x000d, B:31:0x0099, B:33:0x00a3, B:36:0x00b0, B:38:0x00b6, B:39:0x00c9, B:40:0x00d1, B:42:0x00d7, B:46:0x00f8, B:49:0x0110, B:48:0x0102, B:51:0x0114, B:53:0x011a, B:55:0x0120, B:57:0x0126, B:59:0x012c, B:61:0x0134, B:63:0x013c, B:65:0x0142, B:67:0x0146, B:7:0x0029, B:9:0x002f, B:11:0x0037, B:13:0x003d, B:15:0x0043, B:17:0x0049, B:19:0x0051, B:21:0x0059, B:23:0x0061, B:25:0x0069, B:26:0x0077, B:28:0x008c), top: B:72:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
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
                if (!str2.contains("gclid") && !str2.contains("gbraid") && !str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_id") && !str2.contains("dclid") && !str2.contains("srsltid") && !str2.contains("sfmc_id")) {
                    zzk.zzu.zzaW().zzj().zza("Activity created with data 'referrer' without required params");
                } else {
                    String.valueOf(str2);
                    zzi = zzk.zzi(Uri.parse("https://google.com/search?".concat(String.valueOf(str2))));
                    if (zzi != null) {
                        zzi.putString("_cis", Constants.REFERRER);
                    }
                    str = this.zzc;
                    if (this.zza && (zzi2 = zzicVar.zzk().zzi(uri)) != null) {
                        zzi2.putString("_cis", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT);
                        if (!zzi2.containsKey("gclid") && zzi != null && zzi.containsKey("gclid")) {
                            zzi2.putString("_cer", String.format("gclid=%s", zzi.getString("gclid")));
                        }
                        zzljVar.zzE(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi2);
                        zzljVar.zzb.zzb(str, zzi2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        zzicVar.zzaW().zzj().zzb("Activity created with referrer", str2);
                        if (zzicVar.zzc().zzp(null, zzfy.zzaG)) {
                            if (zzi != null) {
                                zzljVar.zzE(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi);
                                zzljVar.zzb.zzb(str, zzi);
                            } else {
                                zzicVar.zzaW().zzj().zzb("Referrer does not contain valid parameters", str2);
                            }
                            zzljVar.zzJ("auto", "_ldl", null, true);
                            return;
                        } else if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                            zzicVar.zzaW().zzj().zza("Activity created with data 'referrer' without required params");
                            return;
                        } else if (TextUtils.isEmpty(str2)) {
                            return;
                        } else {
                            zzljVar.zzJ("auto", "_ldl", str2, true);
                            return;
                        }
                    }
                    return;
                }
            }
            zzi = null;
            str = this.zzc;
            if (this.zza) {
                zzi2.putString("_cis", AccessibilityNodeInfoCompat.MathInfoCompat.MATH_ATTRIBUTE_INTENT);
                if (!zzi2.containsKey("gclid")) {
                    zzi2.putString("_cer", String.format("gclid=%s", zzi.getString("gclid")));
                }
                zzljVar.zzE(str, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzi2);
                zzljVar.zzb.zzb(str, zzi2);
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (RuntimeException e) {
            zzkyVar.zza.zzu.zzaW().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
