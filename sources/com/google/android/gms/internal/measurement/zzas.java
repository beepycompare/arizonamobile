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
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        Object obj;
        char c;
        zzas zzasVar;
        int i;
        double doubleValue;
        Matcher matcher;
        double min;
        double min2;
        int i2;
        int i3;
        zzg zzgVar2;
        int i4;
        int length;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || FirebaseAnalytics.Event.SEARCH.equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str) || "toLocaleUpperCase".equals(str)) {
            str2 = "hasOwnProperty";
        } else {
            str2 = "hasOwnProperty";
            if (!"trim".equals(str)) {
                throw new IllegalArgumentException(String.format("%s is not a String function", str));
            }
        }
        switch (str.hashCode()) {
            case -1789698943:
                str3 = str2;
                obj = "charAt";
                if (str.equals(str3)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1776922004:
                obj = "charAt";
                if (str.equals("toString")) {
                    c = 14;
                    str3 = str2;
                    break;
                }
                str3 = str2;
                c = 65535;
                break;
            case -1464939364:
                obj = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    c = '\f';
                    str3 = str2;
                    break;
                }
                str3 = str2;
                c = 65535;
                break;
            case -1361633751:
                obj = "charAt";
                if (str.equals(obj)) {
                    str3 = str2;
                    c = 0;
                    break;
                }
                str3 = str2;
                c = 65535;
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str3 = str2;
                    obj = "charAt";
                    c = 1;
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    c = '\r';
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case -906336856:
                if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                    c = 7;
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case -726908483:
                if (str.equals("toLocaleUpperCase")) {
                    c = 11;
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 4;
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case -399551817:
                if (str.equals("toUpperCase")) {
                    c = 15;
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case 3568674:
                if (str.equals("trim")) {
                    c = 16;
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case 103668165:
                if (str.equals("match")) {
                    c = 5;
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = '\b';
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case 109648666:
                if (str.equals("split")) {
                    c = '\t';
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case 530542161:
                if (str.equals("substring")) {
                    c = '\n';
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case 1094496948:
                if (str.equals("replace")) {
                    c = 6;
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 3;
                    str3 = str2;
                    obj = "charAt";
                    break;
                }
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
            default:
                str3 = str2;
                obj = "charAt";
                c = 65535;
                break;
        }
        String str4 = StringUtils.UNDEFINED;
        String str5 = obj;
        switch (c) {
            case 0:
                zzh.zzc(str5, 1, list);
                int zzi = !list.isEmpty() ? (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue()) : 0;
                String str6 = this.zza;
                if (zzi < 0 || zzi >= str6.length()) {
                    return zzao.zzm;
                }
                return new zzas(String.valueOf(str6.charAt(zzi)));
            case 1:
                zzasVar = this;
                if (!list.isEmpty()) {
                    StringBuilder sb = new StringBuilder(zzasVar.zza);
                    for (int i5 = 0; i5 < list.size(); i5++) {
                        sb.append(zzgVar.zza((zzao) list.get(i5)).zzc());
                    }
                    return new zzas(sb.toString());
                }
                break;
            case 2:
                zzh.zza(str3, 1, list);
                String str7 = this.zza;
                zzao zza = zzgVar.zza((zzao) list.get(0));
                if ("length".equals(zza.zzc())) {
                    return zzaf.zzk;
                }
                double doubleValue2 = zza.zzd().doubleValue();
                return (doubleValue2 != Math.floor(doubleValue2) || (i = (int) doubleValue2) < 0 || i >= str7.length()) ? zzaf.zzl : zzaf.zzk;
            case 3:
                zzh.zzc("indexOf", 2, list);
                String str8 = this.zza;
                if (list.size() > 0) {
                    str4 = zzgVar.zza((zzao) list.get(0)).zzc();
                }
                return new zzah(Double.valueOf(str8.indexOf(str4, (int) zzh.zzi(list.size() < 2 ? 0.0d : zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()))));
            case 4:
                zzh.zzc("lastIndexOf", 2, list);
                String str9 = this.zza;
                if (list.size() > 0) {
                    str4 = zzgVar.zza((zzao) list.get(0)).zzc();
                }
                String str10 = str4;
                return new zzah(Double.valueOf(str9.lastIndexOf(str10, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) ? Double.POSITIVE_INFINITY : zzh.zzi(doubleValue)))));
            case 5:
                zzh.zzc("match", 1, list);
                Matcher matcher2 = Pattern.compile(list.size() <= 0 ? "" : zzgVar.zza((zzao) list.get(0)).zzc()).matcher(this.zza);
                return matcher2.find() ? new zzae(Arrays.asList(new zzas(matcher2.group()))) : zzao.zzg;
            case 6:
                zzasVar = this;
                zzh.zzc("replace", 2, list);
                zzao zzaoVar = zzao.zzf;
                if (!list.isEmpty()) {
                    str4 = zzgVar.zza((zzao) list.get(0)).zzc();
                    if (list.size() > 1) {
                        zzaoVar = zzgVar.zza((zzao) list.get(1));
                    }
                }
                String str11 = str4;
                String str12 = zzasVar.zza;
                int indexOf = str12.indexOf(str11);
                if (indexOf >= 0) {
                    if (zzaoVar instanceof zzai) {
                        zzaoVar = ((zzai) zzaoVar).zza(zzgVar, Arrays.asList(new zzas(str11), new zzah(Double.valueOf(indexOf)), zzasVar));
                    }
                    String substring = str12.substring(0, indexOf);
                    String zzc = zzaoVar.zzc();
                    String substring2 = str12.substring(indexOf + str11.length());
                    StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + String.valueOf(zzc).length() + String.valueOf(substring2).length());
                    sb2.append(substring);
                    sb2.append(zzc);
                    sb2.append(substring2);
                    return new zzas(sb2.toString());
                }
                break;
            case 7:
                zzh.zzc(FirebaseAnalytics.Event.SEARCH, 1, list);
                if (!list.isEmpty()) {
                    str4 = zzgVar.zza((zzao) list.get(0)).zzc();
                }
                if (Pattern.compile(str4).matcher(this.zza).find()) {
                    return new zzah(Double.valueOf(matcher.start()));
                }
                return new zzah(Double.valueOf(-1.0d));
            case '\b':
                zzh.zzc("slice", 2, list);
                String str13 = this.zza;
                double zzi2 = zzh.zzi(!list.isEmpty() ? zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() : 0.0d);
                if (zzi2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    min = Math.max(str13.length() + zzi2, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                } else {
                    min = Math.min(zzi2, str13.length());
                }
                double zzi3 = zzh.zzi(list.size() > 1 ? zzgVar.zza((zzao) list.get(1)).zzd().doubleValue() : str13.length());
                if (zzi3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    min2 = Math.max(str13.length() + zzi3, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                } else {
                    min2 = Math.min(zzi3, str13.length());
                }
                int i6 = (int) min;
                return new zzas(str13.substring(i6, Math.max(0, ((int) min2) - i6) + i6));
            case '\t':
                zzh.zzc("split", 2, list);
                String str14 = this.zza;
                if (str14.length() == 0) {
                    return new zzae(Arrays.asList(this));
                }
                ArrayList arrayList = new ArrayList();
                if (list.isEmpty()) {
                    arrayList.add(this);
                } else {
                    String zzc2 = zzgVar.zza((zzao) list.get(0)).zzc();
                    long zzh = list.size() > 1 ? zzh.zzh(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) : SieveCacheKt.NodeLinkMask;
                    if (zzh == 0) {
                        return new zzae();
                    }
                    String[] split = str14.split(Pattern.quote(zzc2), ((int) zzh) + 1);
                    int length2 = split.length;
                    if (!zzc2.isEmpty() || length2 <= 0) {
                        i2 = length2;
                        i3 = 0;
                    } else {
                        boolean isEmpty = split[0].isEmpty();
                        i2 = length2 - 1;
                        i3 = isEmpty;
                        if (!split[i2].isEmpty()) {
                            i2 = length2;
                            i3 = isEmpty;
                        }
                    }
                    if (length2 > zzh) {
                        i2--;
                    }
                    while (i3 < i2) {
                        arrayList.add(new zzas(split[i3]));
                        i3++;
                    }
                }
                return new zzae(arrayList);
            case '\n':
                zzh.zzc("substring", 2, list);
                String str15 = this.zza;
                if (list.isEmpty()) {
                    zzgVar2 = zzgVar;
                    i4 = 0;
                } else {
                    zzgVar2 = zzgVar;
                    i4 = (int) zzh.zzi(zzgVar2.zza((zzao) list.get(0)).zzd().doubleValue());
                }
                if (list.size() > 1) {
                    length = (int) zzh.zzi(zzgVar2.zza((zzao) list.get(1)).zzd().doubleValue());
                } else {
                    length = str15.length();
                }
                int min3 = Math.min(Math.max(i4, 0), str15.length());
                int min4 = Math.min(Math.max(length, 0), str15.length());
                return new zzas(str15.substring(Math.min(min3, min4), Math.max(min3, min4)));
            case 11:
                zzh.zza("toLocaleUpperCase", 0, list);
                return new zzas(this.zza.toUpperCase());
            case '\f':
                zzh.zza("toLocaleLowerCase", 0, list);
                return new zzas(this.zza.toLowerCase());
            case '\r':
                zzh.zza("toLowerCase", 0, list);
                return new zzas(this.zza.toLowerCase(Locale.ENGLISH));
            case 14:
                zzh.zza("toString", 0, list);
                return this;
            case 15:
                zzh.zza("toUpperCase", 0, list);
                return new zzas(this.zza.toUpperCase(Locale.ENGLISH));
            case 16:
                zzh.zza("toUpperCase", 0, list);
                return new zzas(this.zza.trim());
            default:
                throw new IllegalArgumentException("Command not supported");
        }
        return zzasVar;
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
