package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzaz {
    public static final zzaz zza = new zzaz((Boolean) null, 100, (Boolean) null, (String) null);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaz(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        this.zzf = enumMap;
        enumMap.put((EnumMap) zzjj.AD_USER_DATA, (zzjj) zzjk.zzh(bool));
        this.zzb = i;
        this.zzc = zzl();
        this.zzd = bool2;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaz zza(zzjh zzjhVar, int i) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        enumMap.put((EnumMap) zzjj.AD_USER_DATA, (zzjj) zzjhVar);
        return new zzaz(enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzaz zzg(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] split = str.split(StringUtils.PROCESS_POSTFIX_DELIMITER);
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(zzjj.class);
        zzjj[] zza2 = zzji.DMA.zza();
        int length = zza2.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            enumMap.put((EnumMap) zza2[i2], (zzjj) zzjk.zzj(split[i].charAt(0)));
            i2++;
            i++;
        }
        return new zzaz(enumMap, parseInt, (Boolean) null, (String) null);
    }

    public static zzaz zzh(Bundle bundle, int i) {
        zzjj[] zza2;
        if (bundle == null) {
            return new zzaz((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.DMA.zza()) {
            enumMap.put((EnumMap) zzjjVar, (zzjj) zzjk.zzg(bundle.getString(zzjjVar.zze)));
        }
        return new zzaz(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static Boolean zzi(Bundle bundle) {
        zzjh zzg;
        if (bundle == null || (zzg = zzjk.zzg(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int ordinal = zzg.ordinal();
        if (ordinal != 2) {
            return ordinal != 3 ? null : true;
        }
        return false;
    }

    private final String zzl() {
        zzjj[] zza2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjj zzjjVar : zzji.DMA.zza()) {
            sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
            sb.append(zzjk.zzm((zzjh) this.zzf.get(zzjjVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzaz) {
            zzaz zzazVar = (zzaz) obj;
            if (this.zzc.equalsIgnoreCase(zzazVar.zzc) && Objects.equals(this.zzd, zzazVar.zzd)) {
                return Objects.equals(this.zze, zzazVar.zze);
            }
            return false;
        }
        return false;
    }

    public final String toString() {
        zzjj[] zza2;
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjk.zzd(this.zzb));
        for (zzjj zzjjVar : zzji.DMA.zza()) {
            sb.append(StringUtils.COMMA);
            sb.append(zzjjVar.zze);
            sb.append("=");
            zzjh zzjhVar = (zzjh) this.zzf.get(zzjjVar);
            if (zzjhVar == null) {
                sb.append("uninitialized");
            } else {
                int ordinal = zzjhVar.ordinal();
                if (ordinal == 0) {
                    sb.append("uninitialized");
                } else if (ordinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (ordinal == 2) {
                    sb.append("denied");
                } else if (ordinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.zze;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzjh zzc() {
        zzjh zzjhVar = (zzjh) this.zzf.get(zzjj.AD_USER_DATA);
        return zzjhVar == null ? zzjh.UNINITIALIZED : zzjhVar;
    }

    public final boolean zzd() {
        for (zzjh zzjhVar : this.zzf.values()) {
            if (zzjhVar != zzjh.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String zze() {
        return this.zzc;
    }

    public final Bundle zzf() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzf.entrySet()) {
            String zzi = zzjk.zzi((zzjh) entry.getValue());
            if (zzi != null) {
                bundle.putString(((zzjj) entry.getKey()).zze, zzi);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final Boolean zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zze;
    }

    public final int hashCode() {
        int i;
        Boolean bool = this.zzd;
        if (bool == null) {
            i = 3;
        } else {
            i = true != bool.booleanValue() ? 13 : 7;
        }
        String str = this.zze;
        return this.zzc.hashCode() + (i * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    private zzaz(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzc = zzl();
        this.zzd = bool;
        this.zze = str;
    }
}
