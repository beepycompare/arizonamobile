package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzoc {
    private final Map zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoc(Map map) {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        hashMap.putAll(map);
    }

    private final Bundle zzf() {
        int zzg;
        Map map = this.zza;
        if ("1".equals(map.get("GoogleConsent")) && (zzg = zzg()) >= 0) {
            String str = (String) map.get("PurposeConsents");
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                String str2 = "granted";
                if (str.length() > 0) {
                    bundle.putString(zzjj.AD_STORAGE.zze, str.charAt(0) == '1' ? "granted" : "denied");
                }
                if (str.length() > 3) {
                    bundle.putString(zzjj.AD_PERSONALIZATION.zze, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
                }
                if (str.length() > 6 && zzg >= 4) {
                    bundle.putString(zzjj.AD_USER_DATA.zze, (str.charAt(0) == '1' && str.charAt(6) == '1') ? "denied" : "denied");
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    private final int zzg() {
        try {
            String str = (String) this.zza.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzoc) {
            return zza().equalsIgnoreCase(((zzoc) obj).zza());
        }
        return false;
    }

    public final int hashCode() {
        return zza().hashCode();
    }

    public final String toString() {
        return zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza() {
        StringBuilder sb = new StringBuilder();
        ImmutableList immutableList = zzoe.zza;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            Map map = this.zza;
            if (map.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) map.get(str));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        if ("1".equals(r2.get("EnableAdvertiserConsentMode")) != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
        if (((java.lang.Boolean) r0.zzb(null)).booleanValue() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
        r0 = r9.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
        if (r0.get("Version") != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0068, code lost:
        return zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        if (zzg() >= 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
        r1 = new android.os.Bundle();
        r2 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE.zze;
        r6 = "denied";
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
        if (true == java.util.Objects.equals(r0.get("AuthorizePurpose1"), "1")) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
        r4 = "denied";
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
        r4 = "granted";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008e, code lost:
        r1.putString(r2, r4);
        r2 = com.google.android.gms.measurement.internal.zzjj.AD_PERSONALIZATION.zze;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
        if (java.util.Objects.equals(r0.get("AuthorizePurpose3"), "1") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
        if (java.util.Objects.equals(r0.get("AuthorizePurpose4"), "1") == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
        r4 = "granted";
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00af, code lost:
        r4 = "denied";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
        r1.putString(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
        if (zzg() < 4) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ba, code lost:
        r2 = com.google.android.gms.measurement.internal.zzjj.AD_USER_DATA.zze;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c6, code lost:
        if (java.util.Objects.equals(r0.get("AuthorizePurpose1"), "1") == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d2, code lost:
        if (java.util.Objects.equals(r0.get("AuthorizePurpose7"), "1") == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
        r6 = "granted";
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d5, code lost:
        r1.putString(r2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d8, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dd, code lost:
        return zzf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
        if ("1".equals(r2.get("EnableAdvertiserConsentMode")) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zzb() {
        zzfw zzfwVar = zzfx.zzaZ;
        if (((Boolean) zzfwVar.zzb(null)).booleanValue()) {
            Map map = this.zza;
            if ("1".equals(map.get("gdprApplies"))) {
            }
            return Bundle.EMPTY;
        }
        Map map2 = this.zza;
        if ("1".equals(map2.get("GoogleConsent"))) {
            if ("1".equals(map2.get("gdprApplies"))) {
            }
        }
        return Bundle.EMPTY;
    }

    public final String zzc() {
        String str = (String) this.zza.get("PurposeDiagnostics");
        return TextUtils.isEmpty(str) ? "200000" : str;
    }

    public final String zzd(zzoc zzocVar) {
        Map map = zzocVar.zza;
        String str = "1";
        String str2 = (map.isEmpty() || ((String) map.get("Version")) != null) ? "0" : "1";
        Bundle zzb = zzb();
        Bundle zzb2 = zzocVar.zzb();
        if (zzb.size() == zzb2.size() && Objects.equals(zzb.getString("ad_storage"), zzb2.getString("ad_storage")) && Objects.equals(zzb.getString("ad_personalization"), zzb2.getString("ad_personalization")) && Objects.equals(zzb.getString("ad_user_data"), zzb2.getString("ad_user_data"))) {
            str = "0";
        }
        return str2.concat(str);
    }

    public final String zze() {
        StringBuilder sb = new StringBuilder("1");
        int i = -1;
        try {
            String str = (String) this.zza.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i < 0 || i > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i & 63));
        }
        int zzg = zzg();
        if (zzg < 0 || zzg > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(zzg));
        }
        Preconditions.checkArgument(true);
        Map map = this.zza;
        int i2 = true != "1".equals(map.get("gdprApplies")) ? 0 : 2;
        boolean equals = "1".equals(map.get("EnableAdvertiserConsentMode"));
        int i3 = i2 | 4;
        if (equals) {
            i3 = i2 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3));
        return sb.toString();
    }
}
