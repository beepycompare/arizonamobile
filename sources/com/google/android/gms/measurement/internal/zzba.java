package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzba {
    public static final zzba zza = new zzba((Boolean) null, 100, (Boolean) null, (String) null);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        this.zzf = enumMap;
        enumMap.put((EnumMap) zzjk.AD_USER_DATA, (zzjk) zzjl.zzh(bool));
        this.zzb = i;
        this.zzc = zzl();
        this.zzd = bool2;
        this.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzba zza(zzji zzjiVar, int i) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        enumMap.put((EnumMap) zzjk.AD_USER_DATA, (zzjk) zzjiVar);
        return new zzba(enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzba zzg(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] split = str.split(StringUtils.PROCESS_POSTFIX_DELIMITER);
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(zzjk.class);
        zzjk[] zza2 = zzjj.DMA.zza();
        int length = zza2.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            enumMap.put((EnumMap) zza2[i2], (zzjk) zzjl.zzj(split[i].charAt(0)));
            i2++;
            i++;
        }
        return new zzba(enumMap, parseInt, (Boolean) null, (String) null);
    }

    public static zzba zzh(Bundle bundle, int i) {
        zzjk[] zza2;
        if (bundle == null) {
            return new zzba((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zzjk.class);
        for (zzjk zzjkVar : zzjj.DMA.zza()) {
            enumMap.put((EnumMap) zzjkVar, (zzjk) zzjl.zzg(bundle.getString(zzjkVar.zze)));
        }
        return new zzba(enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static Boolean zzi(Bundle bundle) {
        zzji zzg;
        if (bundle == null || (zzg = zzjl.zzg(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int ordinal = zzg.ordinal();
        if (ordinal != 2) {
            return ordinal != 3 ? null : true;
        }
        return false;
    }

    private final String zzl() {
        zzjk[] zza2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjk zzjkVar : zzjj.DMA.zza()) {
            sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
            sb.append(zzjl.zzm((zzji) this.zzf.get(zzjkVar)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            if (this.zzc.equalsIgnoreCase(zzbaVar.zzc) && Objects.equals(this.zzd, zzbaVar.zzd)) {
                return Objects.equals(this.zze, zzbaVar.zze);
            }
            return false;
        }
        return false;
    }

    public final String toString() {
        zzjk[] zza2;
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjl.zzd(this.zzb));
        for (zzjk zzjkVar : zzjj.DMA.zza()) {
            sb.append(StringUtils.COMMA);
            sb.append(zzjkVar.zze);
            sb.append("=");
            zzji zzjiVar = (zzji) this.zzf.get(zzjkVar);
            if (zzjiVar == null) {
                sb.append("uninitialized");
            } else {
                int ordinal = zzjiVar.ordinal();
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

    public final zzji zzc() {
        zzji zzjiVar = (zzji) this.zzf.get(zzjk.AD_USER_DATA);
        return zzjiVar == null ? zzji.UNINITIALIZED : zzjiVar;
    }

    public final boolean zzd() {
        for (zzji zzjiVar : this.zzf.values()) {
            if (zzjiVar != zzji.UNINITIALIZED) {
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
            String zzi = zzjl.zzi((zzji) entry.getValue());
            if (zzi != null) {
                bundle.putString(((zzjk) entry.getKey()).zze, zzi);
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

    private zzba(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjk.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzc = zzl();
        this.zzd = bool;
        this.zze = str;
    }
}
