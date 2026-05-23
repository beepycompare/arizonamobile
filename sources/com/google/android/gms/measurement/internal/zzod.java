package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzod {
    private final Map zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzod(Map map) {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        hashMap.putAll(map);
    }

    private final int zzf() {
        try {
            String str = (String) this.zza.get("PolicyVersion");
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzod) {
            return zza().equalsIgnoreCase(((zzod) obj).zza());
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
        ImmutableList immutableList = zzof.zza;
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

    public final Bundle zzb() {
        int zzf;
        Map map = this.zza;
        if ("1".equals(map.get("gdprApplies")) && "1".equals(map.get("EnableAdvertiserConsentMode"))) {
            String str = "denied";
            if (map.get("Version") == null) {
                if ("1".equals(map.get("GoogleConsent")) && (zzf = zzf()) >= 0) {
                    String str2 = (String) map.get("PurposeConsents");
                    if (TextUtils.isEmpty(str2)) {
                        return Bundle.EMPTY;
                    }
                    Bundle bundle = new Bundle();
                    if (str2.length() > 0) {
                        bundle.putString(zzjk.AD_STORAGE.zze, str2.charAt(0) == '1' ? "granted" : "denied");
                    }
                    if (str2.length() > 3) {
                        bundle.putString(zzjk.AD_PERSONALIZATION.zze, (str2.charAt(2) == '1' && str2.charAt(3) == '1') ? "granted" : "denied");
                    }
                    if (str2.length() > 6 && zzf >= 4) {
                        String str3 = zzjk.AD_USER_DATA.zze;
                        if (str2.charAt(0) == '1' && str2.charAt(6) == '1') {
                            str = "granted";
                        }
                        bundle.putString(str3, str);
                    }
                    return bundle;
                }
                return Bundle.EMPTY;
            } else if (zzf() >= 0) {
                Bundle bundle2 = new Bundle();
                bundle2.putString(zzjk.AD_STORAGE.zze, true != Objects.equals(map.get("AuthorizePurpose1"), "1") ? "denied" : "granted");
                bundle2.putString(zzjk.AD_PERSONALIZATION.zze, (Objects.equals(map.get("AuthorizePurpose3"), "1") && Objects.equals(map.get("AuthorizePurpose4"), "1")) ? "granted" : "denied");
                if (zzf() >= 4) {
                    String str4 = zzjk.AD_USER_DATA.zze;
                    if (Objects.equals(map.get("AuthorizePurpose1"), "1") && Objects.equals(map.get("AuthorizePurpose7"), "1")) {
                        str = "granted";
                    }
                    bundle2.putString(str4, str);
                }
                return bundle2;
            }
        }
        return Bundle.EMPTY;
    }

    public final String zzc() {
        String str = (String) this.zza.get("PurposeDiagnostics");
        return TextUtils.isEmpty(str) ? "200000" : str;
    }

    public final String zzd(zzod zzodVar) {
        Map map = zzodVar.zza;
        String str = "1";
        String str2 = (map.isEmpty() || ((String) map.get("Version")) != null) ? "0" : "1";
        Bundle zzb = zzb();
        Bundle zzb2 = zzodVar.zzb();
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
        int zzf = zzf();
        if (zzf < 0 || zzf > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(zzf));
        }
        Preconditions.checkArgument(true);
        Map map = this.zza;
        int i2 = true != "1".equals(map.get("gdprApplies")) ? 0 : 2;
        int i3 = i2 | 4;
        if ("1".equals(map.get("EnableAdvertiserConsentMode"))) {
            i3 = i2 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i3));
        return sb.toString();
    }
}
