package com.google.android.gms.internal.measurement;

import androidx.collection.SieveCacheKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzas implements Iterable, zzao {
    private final String zza;

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.zza.equals(((zzas) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzar(this);
    }

    public final String toString() {
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return this.zza;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x02e0, code lost:
        if (r0[r3].isEmpty() == false) goto L112;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        int i;
        zzas zzasVar;
        Matcher matcher;
        double doubleValue;
        int i2;
        int i3;
        zzg zzgVar2;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || FirebaseAnalytics.Event.SEARCH.equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str) || "toLocaleUpperCase".equals(str)) {
            str2 = "hasOwnProperty";
            str3 = "trim";
        } else {
            str2 = "hasOwnProperty";
            str3 = "trim";
            if (!str3.equals(str)) {
                throw new IllegalArgumentException(String.format("%s is not a String function", str));
            }
        }
        int hashCode = str.hashCode();
        String str4 = StringUtils.UNDEFINED;
        r5 = 0;
        int i4 = 0;
        switch (hashCode) {
            case -1789698943:
                String str5 = str2;
                if (str.equals(str5)) {
                    zzh.zza(str5, 1, list);
                    String str6 = this.zza;
                    zzao zza = zzgVar.zza((zzao) list.get(0));
                    if ("length".equals(zza.zzc())) {
                        return zzaf.zzk;
                    }
                    double doubleValue2 = zza.zzd().doubleValue();
                    return (doubleValue2 != Math.floor(doubleValue2) || (i = (int) doubleValue2) < 0 || i >= str6.length()) ? zzaf.zzl : zzaf.zzk;
                }
                throw new IllegalArgumentException("Command not supported");
            case -1776922004:
                if (str.equals("toString")) {
                    zzh.zza("toString", 0, list);
                    return this;
                }
                throw new IllegalArgumentException("Command not supported");
            case -1464939364:
                if (str.equals("toLocaleLowerCase")) {
                    zzh.zza("toLocaleLowerCase", 0, list);
                    return new zzas(this.zza.toLowerCase());
                }
                throw new IllegalArgumentException("Command not supported");
            case -1361633751:
                if (str.equals("charAt")) {
                    zzh.zzc("charAt", 1, list);
                    int zzi = list.isEmpty() ? 0 : (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
                    String str7 = this.zza;
                    return (zzi < 0 || zzi >= str7.length()) ? zzao.zzm : new zzas(String.valueOf(str7.charAt(zzi)));
                }
                throw new IllegalArgumentException("Command not supported");
            case -1354795244:
                zzasVar = this;
                if (str.equals("concat")) {
                    if (!list.isEmpty()) {
                        StringBuilder sb = new StringBuilder(zzasVar.zza);
                        for (int i5 = 0; i5 < list.size(); i5++) {
                            sb.append(zzgVar.zza((zzao) list.get(i5)).zzc());
                        }
                        return new zzas(sb.toString());
                    }
                    return zzasVar;
                }
                throw new IllegalArgumentException("Command not supported");
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    zzh.zza("toLowerCase", 0, list);
                    return new zzas(this.zza.toLowerCase(Locale.ENGLISH));
                }
                throw new IllegalArgumentException("Command not supported");
            case -906336856:
                if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                    zzh.zzc(FirebaseAnalytics.Event.SEARCH, 1, list);
                    if (!list.isEmpty()) {
                        str4 = zzgVar.zza((zzao) list.get(0)).zzc();
                    }
                    return Pattern.compile(str4).matcher(this.zza).find() ? new zzah(Double.valueOf(matcher.start())) : new zzah(Double.valueOf(-1.0d));
                }
                throw new IllegalArgumentException("Command not supported");
            case -726908483:
                if (str.equals("toLocaleUpperCase")) {
                    zzh.zza("toLocaleUpperCase", 0, list);
                    return new zzas(this.zza.toUpperCase());
                }
                throw new IllegalArgumentException("Command not supported");
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    zzh.zzc("lastIndexOf", 2, list);
                    String str8 = this.zza;
                    if (list.size() > 0) {
                        str4 = zzgVar.zza((zzao) list.get(0)).zzc();
                    }
                    String str9 = str4;
                    return new zzah(Double.valueOf(str8.lastIndexOf(str9, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) ? Double.POSITIVE_INFINITY : zzh.zzi(doubleValue)))));
                }
                throw new IllegalArgumentException("Command not supported");
            case -399551817:
                if (str.equals("toUpperCase")) {
                    zzh.zza("toUpperCase", 0, list);
                    return new zzas(this.zza.toUpperCase(Locale.ENGLISH));
                }
                throw new IllegalArgumentException("Command not supported");
            case 3568674:
                if (str.equals(str3)) {
                    zzh.zza("toUpperCase", 0, list);
                    return new zzas(this.zza.trim());
                }
                throw new IllegalArgumentException("Command not supported");
            case 103668165:
                if (str.equals("match")) {
                    zzh.zzc("match", 1, list);
                    Matcher matcher2 = Pattern.compile(list.size() <= 0 ? "" : zzgVar.zza((zzao) list.get(0)).zzc()).matcher(this.zza);
                    return matcher2.find() ? new zzae(Arrays.asList(new zzas(matcher2.group()))) : zzao.zzg;
                }
                throw new IllegalArgumentException("Command not supported");
            case 109526418:
                if (str.equals("slice")) {
                    zzh.zzc("slice", 2, list);
                    String str10 = this.zza;
                    double zzi2 = zzh.zzi(!list.isEmpty() ? zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() : 0.0d);
                    double max = zzi2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? Math.max(str10.length() + zzi2, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : Math.min(zzi2, str10.length());
                    double zzi3 = zzh.zzi(list.size() > 1 ? zzgVar.zza((zzao) list.get(1)).zzd().doubleValue() : str10.length());
                    int i6 = (int) max;
                    return new zzas(str10.substring(i6, Math.max(0, ((int) (zzi3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? Math.max(str10.length() + zzi3, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : Math.min(zzi3, str10.length()))) - i6) + i6));
                }
                throw new IllegalArgumentException("Command not supported");
            case 109648666:
                if (str.equals("split")) {
                    zzh.zzc("split", 2, list);
                    String str11 = this.zza;
                    if (str11.length() == 0) {
                        return new zzae(Arrays.asList(this));
                    }
                    ArrayList arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(this);
                    } else {
                        String zzc = zzgVar.zza((zzao) list.get(0)).zzc();
                        long zzh = list.size() > 1 ? zzh.zzh(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) : SieveCacheKt.NodeLinkMask;
                        if (zzh == 0) {
                            return new zzae();
                        }
                        String[] split = str11.split(Pattern.quote(zzc), ((int) zzh) + 1);
                        int length = split.length;
                        if (zzc.isEmpty() && length > 0) {
                            boolean isEmpty = split[0].isEmpty();
                            i2 = length - 1;
                            i3 = isEmpty;
                            i4 = isEmpty;
                            break;
                        }
                        i2 = length;
                        i3 = i4;
                        if (length > zzh) {
                            i2--;
                        }
                        while (i3 < i2) {
                            arrayList.add(new zzas(split[i3]));
                            i3++;
                        }
                    }
                    return new zzae(arrayList);
                }
                throw new IllegalArgumentException("Command not supported");
            case 530542161:
                if (str.equals("substring")) {
                    zzh.zzc("substring", 2, list);
                    String str12 = this.zza;
                    int zzi4 = !list.isEmpty() ? (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue()) : 0;
                    int zzi5 = list.size() > 1 ? (int) zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) : str12.length();
                    int min = Math.min(Math.max(zzi4, 0), str12.length());
                    int min2 = Math.min(Math.max(zzi5, 0), str12.length());
                    return new zzas(str12.substring(Math.min(min, min2), Math.max(min, min2)));
                }
                throw new IllegalArgumentException("Command not supported");
            case 1094496948:
                zzasVar = this;
                if (str.equals("replace")) {
                    zzh.zzc("replace", 2, list);
                    zzao zzaoVar = zzao.zzf;
                    if (!list.isEmpty()) {
                        str4 = zzgVar.zza((zzao) list.get(0)).zzc();
                        if (list.size() > 1) {
                            zzaoVar = zzgVar.zza((zzao) list.get(1));
                        }
                    }
                    String str13 = str4;
                    String str14 = zzasVar.zza;
                    int indexOf = str14.indexOf(str13);
                    if (indexOf >= 0) {
                        if (zzaoVar instanceof zzai) {
                            zzaoVar = ((zzai) zzaoVar).zza(zzgVar, Arrays.asList(new zzas(str13), new zzah(Double.valueOf(indexOf)), zzasVar));
                        }
                        String substring = str14.substring(0, indexOf);
                        String zzc2 = zzaoVar.zzc();
                        String substring2 = str14.substring(indexOf + str13.length());
                        StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + String.valueOf(zzc2).length() + String.valueOf(substring2).length());
                        sb2.append(substring);
                        sb2.append(zzc2);
                        sb2.append(substring2);
                        return new zzas(sb2.toString());
                    }
                    return zzasVar;
                }
                throw new IllegalArgumentException("Command not supported");
            case 1943291465:
                if (str.equals("indexOf")) {
                    zzh.zzc("indexOf", 2, list);
                    String str15 = this.zza;
                    if (list.size() <= 0) {
                        zzgVar2 = zzgVar;
                    } else {
                        zzgVar2 = zzgVar;
                        str4 = zzgVar2.zza((zzao) list.get(0)).zzc();
                    }
                    return new zzah(Double.valueOf(str15.indexOf(str4, (int) zzh.zzi(list.size() < 2 ? 0.0d : zzgVar2.zza((zzao) list.get(1)).zzd().doubleValue()))));
                }
                throw new IllegalArgumentException("Command not supported");
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        String str = this.zza;
        if (!str.isEmpty()) {
            try {
                return Double.valueOf(str);
            } catch (NumberFormatException unused) {
                return Double.valueOf(Double.NaN);
            }
        }
        return Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzaq(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzas(this.zza);
    }
}
