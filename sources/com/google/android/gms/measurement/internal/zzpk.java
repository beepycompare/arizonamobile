package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.arizona.launcher.UpdateActivity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzadf;
import com.google.android.gms.internal.measurement.zzaeh;
import com.google.android.gms.internal.measurement.zzafb;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.internal.measurement.zzair;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpk extends zzos {
    private long zza;
    private long zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpk(zzpg zzpgVar) {
        super(zzpgVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzF(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, Object obj) {
        List zza = zzhrVar.zza();
        int i = 0;
        while (true) {
            if (i >= zza.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i)).zzb())) {
                break;
            } else {
                i++;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzn.zzb(str);
        zzn.zzf(((Long) obj).longValue());
        if (i >= 0) {
            zzhrVar.zze(i, zzn);
        } else {
            zzhrVar.zzg(zzn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean zzG(zzbh zzbhVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzbhVar);
        Preconditions.checkNotNull(zzrVar);
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Bundle zzH(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            String zzb = zzhwVar.zzb();
            if (zzhwVar.zzj()) {
                bundle.putDouble(zzb, zzhwVar.zzk());
            } else if (zzhwVar.zzh()) {
                bundle.putFloat(zzb, zzhwVar.zzi());
            } else if (zzhwVar.zzc()) {
                bundle.putString(zzb, zzhwVar.zzd());
            } else if (zzhwVar.zze()) {
                bundle.putLong(zzb, zzhwVar.zzf());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final com.google.android.gms.internal.measurement.zzhw zzI(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().equals(str)) {
                return zzhwVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String zzJ(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (entry.getValue() == null || ((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Map zzK(com.google.android.gms.internal.measurement.zzhs zzhsVar, String... strArr) {
        Object zzT;
        HashMap hashMap = new HashMap();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (Arrays.asList(strArr).contains(zzhwVar.zzb()) && (zzT = zzT(zzhwVar)) != null) {
                hashMap.put(zzhwVar.zzb(), zzT);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Map zzL(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        Object zzT;
        HashMap hashMap = new HashMap();
        for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
            if (zzhwVar.zzb().startsWith("gad_") && (zzT = zzT(zzhwVar)) != null) {
                hashMap.put(zzhwVar.zzb(), zzT);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object zzM(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str) {
        com.google.android.gms.internal.measurement.zzhw zzI = zzI(zzhsVar, str);
        if (zzI == null) {
            return null;
        }
        return zzT(zzI);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Object zzN(com.google.android.gms.internal.measurement.zzhs zzhsVar, String str, Object obj) {
        Object zzM = zzM(zzhsVar, str);
        return zzM == null ? obj : zzM;
    }

    private final void zzO(StringBuilder sb, int i, List list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                zzQ(sb, i2);
                sb.append("param {\n");
                zzW(sb, i2, "name", zzhwVar.zza() ? this.zzu.zzl().zzb(zzhwVar.zzb()) : null);
                zzW(sb, i2, "string_value", zzhwVar.zzc() ? zzhwVar.zzd() : null);
                zzW(sb, i2, "int_value", zzhwVar.zze() ? Long.valueOf(zzhwVar.zzf()) : null);
                zzW(sb, i2, "double_value", zzhwVar.zzj() ? Double.valueOf(zzhwVar.zzk()) : null);
                if (zzhwVar.zzm() > 0) {
                    zzO(sb, i2, zzhwVar.zzl());
                }
                zzQ(sb, i2);
                sb.append("}\n");
            }
        }
    }

    private final void zzP(StringBuilder sb, int i, com.google.android.gms.internal.measurement.zzfh zzfhVar) {
        String str;
        if (zzfhVar == null) {
            return;
        }
        zzQ(sb, i);
        sb.append("filter {\n");
        if (zzfhVar.zze()) {
            zzW(sb, i, "complement", Boolean.valueOf(zzfhVar.zzf()));
        }
        if (zzfhVar.zzh()) {
            zzW(sb, i, "param_name", this.zzu.zzl().zzb(zzfhVar.zzi()));
        }
        if (zzfhVar.zza()) {
            int i2 = i + 1;
            com.google.android.gms.internal.measurement.zzfr zzb = zzfhVar.zzb();
            if (zzb != null) {
                zzQ(sb, i2);
                sb.append("string_filter {\n");
                if (zzb.zza()) {
                    switch (zzb.zzk()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    zzW(sb, i2, "match_type", str);
                }
                if (zzb.zzb()) {
                    zzW(sb, i2, "expression", zzb.zzc());
                }
                if (zzb.zzd()) {
                    zzW(sb, i2, "case_sensitive", Boolean.valueOf(zzb.zze()));
                }
                if (zzb.zzh() > 0) {
                    zzQ(sb, i + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : zzb.zzf()) {
                        zzQ(sb, i + 3);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zzQ(sb, i2);
                sb.append("}\n");
            }
        }
        if (zzfhVar.zzc()) {
            zzX(sb, i + 1, "number_filter", zzfhVar.zzd());
        }
        zzQ(sb, i);
        sb.append("}\n");
    }

    private static final void zzQ(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final void zzR(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private static final String zzS(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final Object zzT(com.google.android.gms.internal.measurement.zzhw zzhwVar) {
        if (zzhwVar.zzc()) {
            return zzhwVar.zzd();
        }
        if (zzhwVar.zze()) {
            return Long.valueOf(zzhwVar.zzf());
        }
        if (zzhwVar.zzj()) {
            return Double.valueOf(zzhwVar.zzk());
        }
        if (zzhwVar.zzm() > 0) {
            return zzy(zzhwVar.zzl());
        }
        return null;
    }

    private static final void zzU(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] split = str.split(StringUtils.COMMA);
            String str2 = split[0];
            String str3 = split[split.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                zzR(builder, str3, string, set);
            }
        }
    }

    private static final void zzV(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzii zziiVar) {
        if (zziiVar == null) {
            return;
        }
        zzQ(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zziiVar.zzd() != 0) {
            zzQ(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : zziiVar.zzc()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (zziiVar.zzb() != 0) {
            zzQ(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : zziiVar.zza()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (zziiVar.zzf() != 0) {
            zzQ(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zziiVar.zze()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(zzhqVar.zza() ? Integer.valueOf(zzhqVar.zzb()) : null);
                sb.append(StringUtils.PROCESS_POSTFIX_DELIMITER);
                sb.append(zzhqVar.zzc() ? Long.valueOf(zzhqVar.zzd()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (zziiVar.zzi() != 0) {
            zzQ(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.zzh()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(zzikVar.zza() ? Integer.valueOf(zzikVar.zzb()) : null);
                sb.append(": [");
                int i10 = 0;
                for (Long l3 : zzikVar.zzc()) {
                    long longValue = l3.longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        zzQ(sb, 3);
        sb.append("}\n");
    }

    private static final void zzW(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzQ(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    private static final void zzX(StringBuilder sb, int i, String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        String str2;
        if (zzflVar == null) {
            return;
        }
        zzQ(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzflVar.zza()) {
            int zzm = zzflVar.zzm();
            if (zzm == 1) {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            } else if (zzm == 2) {
                str2 = "LESS_THAN";
            } else if (zzm != 3) {
                str2 = zzm != 4 ? "BETWEEN" : "EQUAL";
            } else {
                str2 = "GREATER_THAN";
            }
            zzW(sb, i, "comparison_type", str2);
        }
        if (zzflVar.zzb()) {
            zzW(sb, i, "match_as_float", Boolean.valueOf(zzflVar.zzc()));
        }
        if (zzflVar.zzd()) {
            zzW(sb, i, "comparison_value", zzflVar.zze());
        }
        if (zzflVar.zzf()) {
            zzW(sb, i, "min_comparison_value", zzflVar.zzh());
        }
        if (zzflVar.zzi()) {
            zzW(sb, i, "max_comparison_value", zzflVar.zzj());
        }
        zzQ(sb, i);
        sb.append("}\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzm(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzn(List list, int i) {
        if (i < list.size() * 64) {
            return ((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zzp(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzafb zzw(zzafb zzafbVar, byte[] bArr) throws zzaeh {
        zzadf zzb = zzadf.zzb();
        if (zzb != null) {
            return zzafbVar.zzaW(bArr, zzb);
        }
        return zzafbVar.zzaX(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(com.google.android.gms.internal.measurement.zzic zzicVar, String str) {
        for (int i = 0; i < zzicVar.zzl(); i++) {
            if (str.equals(zzicVar.zzm(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] zzy(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it.next();
            if (zzhwVar != null) {
                Bundle bundle = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar2 : zzhwVar.zzl()) {
                    if (zzhwVar2.zzc()) {
                        bundle.putString(zzhwVar2.zzb(), zzhwVar2.zzd());
                    } else if (zzhwVar2.zze()) {
                        bundle.putLong(zzhwVar2.zzb(), zzhwVar2.zzf());
                    } else if (zzhwVar2.zzj()) {
                        bundle.putDouble(zzhwVar2.zzb(), zzhwVar2.zzk());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbh zzA(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        String str;
        Object obj;
        Bundle zzB = zzB(zzaaVar.zzf(), true);
        if (zzB.containsKey("_o") && (obj = zzB.get("_o")) != null) {
            str = obj.toString();
        } else {
            str = "app";
        }
        String str2 = str;
        String zzb = zzjm.zzb(zzaaVar.zzb());
        if (zzb == null) {
            zzb = zzaaVar.zzb();
        }
        return new zzbh(zzb, new zzbf(zzB), str2, zzaaVar.zza(), 0L);
    }

    final Bundle zzB(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(zzB((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    final long zzC(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return ZonedDateTime.parse(str, DateTimeFormatter.RFC_1123_DATE_TIME).toInstant().toEpochMilli();
            } catch (DateTimeParseException unused) {
                this.zzu.zzaW().zze().zzb("Unable to parse header time, time", str);
            }
        }
        return 0L;
    }

    public final void zzD(Map map) {
        if (Build.VERSION.SDK_INT >= 26) {
            String zzJ = zzJ(map, HttpHeaders.DATE);
            if (TextUtils.isEmpty(zzJ)) {
                return;
            }
            long zzC = zzC(zzJ);
            if (zzC > 0) {
                long elapsedRealtime = this.zzu.zzba().elapsedRealtime();
                zzg();
                if (this.zzb == 0) {
                    this.zza = elapsedRealtime;
                    this.zzb = zzC;
                }
            }
        }
    }

    public final long zzE(long j) {
        zzg();
        long j2 = this.zzb;
        if (j2 == 0 || j == 0) {
            return 0L;
        }
        return (j2 - this.zza) + j;
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbc() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(com.google.android.gms.internal.measurement.zzit zzitVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzitVar.zzd();
        zzitVar.zzf();
        zzitVar.zzh();
        if (obj instanceof String) {
            zzitVar.zzc((String) obj);
        } else if (obj instanceof Long) {
            zzitVar.zze(((Long) obj).longValue());
        } else if (!(obj instanceof Double)) {
            this.zzu.zzaW().zzb().zzb("Ignoring invalid (type) user attribute value", obj);
        } else {
            zzitVar.zzg(((Double) obj).doubleValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(com.google.android.gms.internal.measurement.zzhv zzhvVar, Object obj) {
        Bundle[] bundleArr;
        Preconditions.checkNotNull(obj);
        zzhvVar.zze();
        zzhvVar.zzg();
        zzhvVar.zzi();
        zzhvVar.zzm();
        if (obj instanceof String) {
            zzhvVar.zzd((String) obj);
        } else if (obj instanceof Long) {
            zzhvVar.zzf(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzhvVar.zzh(((Double) obj).doubleValue());
        } else if (!(obj instanceof Bundle[])) {
            this.zzu.zzaW().zzb().zzb("Ignoring invalid (type) event param value", obj);
        } else {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                    for (String str : bundle.keySet()) {
                        com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzn2.zzb(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zzn2.zzf(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zzn2.zzd((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zzn2.zzh(((Double) obj2).doubleValue());
                        }
                        zzn.zzk(zzn2);
                    }
                    if (zzn.zzj() > 0) {
                        arrayList.add((com.google.android.gms.internal.measurement.zzhw) zzn.zzbd());
                    }
                }
            }
            zzhvVar.zzl(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzoh zzf(String str, com.google.android.gms.internal.measurement.zzic zzicVar, com.google.android.gms.internal.measurement.zzhr zzhrVar, String str2) {
        int indexOf;
        zzaif.zza();
        zzic zzicVar2 = this.zzu;
        if (zzicVar2.zzc().zzp(str, zzfy.zzaO)) {
            long currentTimeMillis = zzicVar2.zzba().currentTimeMillis();
            HashSet hashSet = new HashSet(Arrays.asList(zzicVar2.zzc().zzk(str, zzfy.zzat).split(StringUtils.COMMA)));
            zzpg zzpgVar = this.zzg;
            zzou zzf = zzpgVar.zzf();
            String zzc = zzf.zzg.zzh().zzc(str);
            Uri.Builder builder = new Uri.Builder();
            zzic zzicVar3 = zzf.zzu;
            builder.scheme(zzicVar3.zzc().zzk(str, zzfy.zzam));
            if (TextUtils.isEmpty(zzc)) {
                builder.authority(zzicVar3.zzc().zzk(str, zzfy.zzan));
            } else {
                String zzk = zzicVar3.zzc().zzk(str, zzfy.zzan);
                StringBuilder sb = new StringBuilder(String.valueOf(zzc).length() + 1 + String.valueOf(zzk).length());
                sb.append(zzc);
                sb.append(".");
                sb.append(zzk);
                builder.authority(sb.toString());
            }
            builder.path(zzicVar3.zzc().zzk(str, zzfy.zzao));
            zzR(builder, "gmp_app_id", zzicVar.zzac(), hashSet);
            zzicVar2.zzc().zzi();
            zzR(builder, "gmp_version", String.valueOf(161000L), hashSet);
            String zzV = zzicVar.zzV();
            zzal zzc2 = zzicVar2.zzc();
            zzfx zzfxVar = zzfy.zzaR;
            if (zzc2.zzp(str, zzfxVar) && zzpgVar.zzh().zzu(str)) {
                zzV = "";
            }
            zzR(builder, "app_instance_id", zzV, hashSet);
            zzR(builder, "rdid", zzicVar.zzP(), hashSet);
            zzR(builder, "bundle_id", zzicVar.zzK(), hashSet);
            String zzk2 = zzhrVar.zzk();
            String zza = zzjm.zza(zzk2);
            if (true != TextUtils.isEmpty(zza)) {
                zzk2 = zza;
            }
            zzR(builder, "app_event_name", zzk2, hashSet);
            zzR(builder, "app_version", String.valueOf(zzicVar.zzai()), hashSet);
            String zzD = zzicVar.zzD();
            if (zzicVar2.zzc().zzp(str, zzfxVar) && zzpgVar.zzh().zzr(str) && !TextUtils.isEmpty(zzD) && (indexOf = zzD.indexOf(".")) != -1) {
                zzD = zzD.substring(0, indexOf);
            }
            zzR(builder, CommonUrlParts.OS_VERSION, zzD, hashSet);
            zzR(builder, "timestamp", String.valueOf(zzhrVar.zzn()), hashSet);
            if (zzicVar.zzS()) {
                zzR(builder, "lat", "1", hashSet);
            }
            zzR(builder, "privacy_sandbox_version", String.valueOf(zzicVar.zzaG()), hashSet);
            zzR(builder, "trigger_uri_source", "1", hashSet);
            zzR(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), hashSet);
            zzR(builder, "request_uuid", str2, hashSet);
            List<com.google.android.gms.internal.measurement.zzhw> zza2 = zzhrVar.zza();
            Bundle bundle = new Bundle();
            for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zza2) {
                String zzb = zzhwVar.zzb();
                if (zzhwVar.zzj()) {
                    bundle.putString(zzb, String.valueOf(zzhwVar.zzk()));
                } else if (zzhwVar.zzh()) {
                    bundle.putString(zzb, String.valueOf(zzhwVar.zzi()));
                } else if (zzhwVar.zzc()) {
                    bundle.putString(zzb, zzhwVar.zzd());
                } else if (zzhwVar.zze()) {
                    bundle.putString(zzb, String.valueOf(zzhwVar.zzf()));
                }
            }
            zzU(builder, zzicVar2.zzc().zzk(str, zzfy.zzas).split("\\|"), bundle, hashSet);
            List<com.google.android.gms.internal.measurement.zziu> zzk3 = zzicVar.zzk();
            Bundle bundle2 = new Bundle();
            for (com.google.android.gms.internal.measurement.zziu zziuVar : zzk3) {
                String zzc3 = zziuVar.zzc();
                if (zziuVar.zzk()) {
                    bundle2.putString(zzc3, String.valueOf(zziuVar.zzl()));
                } else if (zziuVar.zzi()) {
                    bundle2.putString(zzc3, String.valueOf(zziuVar.zzj()));
                } else if (zziuVar.zzd()) {
                    bundle2.putString(zzc3, zziuVar.zze());
                } else if (zziuVar.zzf()) {
                    bundle2.putString(zzc3, String.valueOf(zziuVar.zzh()));
                }
            }
            zzU(builder, zzicVar2.zzc().zzk(str, zzfy.zzar).split("\\|"), bundle2, hashSet);
            zzR(builder, "dma", true != zzicVar.zzaC() ? "0" : "1", hashSet);
            if (!zzicVar.zzaE().isEmpty()) {
                zzR(builder, "dma_cps", zzicVar.zzaE(), hashSet);
            }
            if (zzicVar.zzaK()) {
                com.google.android.gms.internal.measurement.zzha zzaL = zzicVar.zzaL();
                if (!zzaL.zzb().isEmpty()) {
                    zzR(builder, "dl_gclid", zzaL.zzb(), hashSet);
                }
                if (!zzaL.zzd().isEmpty()) {
                    zzR(builder, "dl_gbraid", zzaL.zzd(), hashSet);
                }
                if (!zzaL.zzf().isEmpty()) {
                    zzR(builder, "dl_gs", zzaL.zzf(), hashSet);
                }
                if (zzaL.zzi() > 0) {
                    zzR(builder, "dl_ss_ts", String.valueOf(zzaL.zzi()), hashSet);
                }
                if (!zzaL.zzk().isEmpty()) {
                    zzR(builder, "mr_gclid", zzaL.zzk(), hashSet);
                }
                if (!zzaL.zzm().isEmpty()) {
                    zzR(builder, "mr_gbraid", zzaL.zzm(), hashSet);
                }
                if (!zzaL.zzo().isEmpty()) {
                    zzR(builder, "mr_gs", zzaL.zzo(), hashSet);
                }
                if (zzaL.zzq() > 0) {
                    zzR(builder, "mr_click_ts", String.valueOf(zzaL.zzq()), hashSet);
                }
            }
            return new zzoh(builder.build().toString(), currentTimeMillis, 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzhs zzh(zzbc zzbcVar) {
        com.google.android.gms.internal.measurement.zzhr zzp = com.google.android.gms.internal.measurement.zzhs.zzp();
        zzp.zzq(zzbcVar.zzf);
        zzp.zzw(zzbcVar.zze);
        zzbf zzbfVar = zzbcVar.zzg;
        zzbe zzbeVar = new zzbe(zzbfVar);
        while (zzbeVar.hasNext()) {
            String next = zzbeVar.next();
            com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzn.zzb(next);
            Object zza = zzbfVar.zza(next);
            Preconditions.checkNotNull(zza);
            zzd(zzn, zza);
            zzp.zzg(zzn);
        }
        String str = zzbcVar.zzc;
        if (!TextUtils.isEmpty(str) && zzbfVar.zza("_o") == null) {
            com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
            zzn2.zzb("_o");
            zzn2.zzd(str);
            zzp.zzf((com.google.android.gms.internal.measurement.zzhw) zzn2.zzbd());
        }
        return (com.google.android.gms.internal.measurement.zzhs) zzp.zzbd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzi(com.google.android.gms.internal.measurement.zzib zzibVar) {
        com.google.android.gms.internal.measurement.zzhe zzat;
        if (zzibVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzibVar.zzf()) {
            zzW(sb, 0, "upload_subdomain", zzibVar.zzh());
        }
        if (zzibVar.zzd()) {
            zzW(sb, 0, "sgtm_join_id", zzibVar.zze());
        }
        for (com.google.android.gms.internal.measurement.zzid zzidVar : zzibVar.zza()) {
            if (zzidVar != null) {
                zzQ(sb, 1);
                sb.append("bundle {\n");
                if (zzidVar.zza()) {
                    zzW(sb, 1, CommonUrlParts.PROTOCOL_VERSION, Integer.valueOf(zzidVar.zzb()));
                }
                zzair.zza();
                zzic zzicVar = this.zzu;
                if (zzicVar.zzc().zzp(zzidVar.zzA(), zzfy.zzaM) && zzidVar.zzag()) {
                    zzW(sb, 1, "session_stitching_token", zzidVar.zzah());
                }
                zzW(sb, 1, "platform", zzidVar.zzt());
                if (zzidVar.zzC()) {
                    zzW(sb, 1, "gmp_version", Long.valueOf(zzidVar.zzD()));
                }
                if (zzidVar.zzE()) {
                    zzW(sb, 1, "uploading_gmp_version", Long.valueOf(zzidVar.zzF()));
                }
                if (zzidVar.zzac()) {
                    zzW(sb, 1, "dynamite_version", Long.valueOf(zzidVar.zzad()));
                }
                if (zzidVar.zzW()) {
                    zzW(sb, 1, "config_version", Long.valueOf(zzidVar.zzX()));
                }
                zzW(sb, 1, "gmp_app_id", zzidVar.zzP());
                zzW(sb, 1, "app_id", zzidVar.zzA());
                zzW(sb, 1, "app_version", zzidVar.zzB());
                if (zzidVar.zzU()) {
                    zzW(sb, 1, "app_version_major", Integer.valueOf(zzidVar.zzV()));
                }
                zzW(sb, 1, "firebase_instance_id", zzidVar.zzT());
                if (zzidVar.zzK()) {
                    zzW(sb, 1, "dev_cert_hash", Long.valueOf(zzidVar.zzL()));
                }
                zzW(sb, 1, "app_store", zzidVar.zzz());
                if (zzidVar.zzj()) {
                    zzW(sb, 1, "upload_timestamp_millis", Long.valueOf(zzidVar.zzk()));
                }
                if (zzidVar.zzl()) {
                    zzW(sb, 1, "start_timestamp_millis", Long.valueOf(zzidVar.zzm()));
                }
                if (zzidVar.zzn()) {
                    zzW(sb, 1, "end_timestamp_millis", Long.valueOf(zzidVar.zzo()));
                }
                if (zzidVar.zzp()) {
                    zzW(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzidVar.zzq()));
                }
                if (zzidVar.zzr()) {
                    zzW(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzidVar.zzs()));
                }
                zzW(sb, 1, "app_instance_id", zzidVar.zzJ());
                zzW(sb, 1, "resettable_device_id", zzidVar.zzG());
                zzW(sb, 1, "ds_id", zzidVar.zzZ());
                if (zzidVar.zzH()) {
                    zzW(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzidVar.zzI()));
                }
                zzW(sb, 1, CommonUrlParts.OS_VERSION, zzidVar.zzu());
                zzW(sb, 1, "device_model", zzidVar.zzv());
                zzW(sb, 1, "user_default_language", zzidVar.zzw());
                if (zzidVar.zzx()) {
                    zzW(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzidVar.zzy()));
                }
                if (zzidVar.zzM()) {
                    zzW(sb, 1, "bundle_sequential_index", Integer.valueOf(zzidVar.zzN()));
                }
                if (zzidVar.zzau()) {
                    zzW(sb, 1, "delivery_index", Integer.valueOf(zzidVar.zzav()));
                }
                if (zzidVar.zzQ()) {
                    zzW(sb, 1, "service_upload", Boolean.valueOf(zzidVar.zzR()));
                }
                zzW(sb, 1, "health_monitor", zzidVar.zzO());
                if (zzidVar.zzaa()) {
                    zzW(sb, 1, "retry_counter", Integer.valueOf(zzidVar.zzab()));
                }
                if (zzidVar.zzae()) {
                    zzW(sb, 1, "consent_signals", zzidVar.zzaf());
                }
                if (zzidVar.zzan()) {
                    zzW(sb, 1, "is_dma_region", Boolean.valueOf(zzidVar.zzao()));
                }
                if (zzidVar.zzap()) {
                    zzW(sb, 1, "core_platform_services", zzidVar.zzaq());
                }
                if (zzidVar.zzal()) {
                    zzW(sb, 1, "consent_diagnostics", zzidVar.zzam());
                }
                if (zzidVar.zzai()) {
                    zzW(sb, 1, "target_os_version", Long.valueOf(zzidVar.zzaj()));
                }
                zzaif.zza();
                if (zzicVar.zzc().zzp(zzidVar.zzA(), zzfy.zzaO)) {
                    zzW(sb, 1, "ad_services_version", Integer.valueOf(zzidVar.zzar()));
                    if (zzidVar.zzas() && (zzat = zzidVar.zzat()) != null) {
                        zzQ(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        zzW(sb, 2, "eligible", Boolean.valueOf(zzat.zza()));
                        zzW(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzat.zzb()));
                        zzW(sb, 2, "pre_r", Boolean.valueOf(zzat.zzc()));
                        zzW(sb, 2, "r_extensions_too_old", Boolean.valueOf(zzat.zzd()));
                        zzW(sb, 2, "adservices_extension_too_old", Boolean.valueOf(zzat.zze()));
                        zzW(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(zzat.zzf()));
                        zzW(sb, 2, "measurement_manager_disabled", Boolean.valueOf(zzat.zzh()));
                        zzQ(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (zzidVar.zzaw()) {
                    com.google.android.gms.internal.measurement.zzha zzax = zzidVar.zzax();
                    zzQ(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (zzax.zza()) {
                        zzW(sb, 2, "deep_link_gclid", zzax.zzb());
                    }
                    if (zzax.zzc()) {
                        zzW(sb, 2, "deep_link_gbraid", zzax.zzd());
                    }
                    if (zzax.zze()) {
                        zzW(sb, 2, "deep_link_gad_source", zzax.zzf());
                    }
                    if (zzax.zzr()) {
                        zzW(sb, 2, "deep_link_url", zzax.zzs());
                    }
                    if (zzax.zzh()) {
                        zzW(sb, 2, "deep_link_session_millis", Long.valueOf(zzax.zzi()));
                    }
                    if (zzax.zzj()) {
                        zzW(sb, 2, "market_referrer_gclid", zzax.zzk());
                    }
                    if (zzax.zzl()) {
                        zzW(sb, 2, "market_referrer_gbraid", zzax.zzm());
                    }
                    if (zzax.zzn()) {
                        zzW(sb, 2, "market_referrer_gad_source", zzax.zzo());
                    }
                    if (zzax.zzp()) {
                        zzW(sb, 2, "market_referrer_click_millis", Long.valueOf(zzax.zzq()));
                    }
                    zzQ(sb, 2);
                    sb.append("}\n");
                }
                if (zzidVar.zzaA()) {
                    zzW(sb, 1, "batching_timestamp_millis", Long.valueOf(zzidVar.zzaB()));
                }
                if (zzidVar.zzay()) {
                    com.google.android.gms.internal.measurement.zzis zzaz = zzidVar.zzaz();
                    zzQ(sb, 2);
                    sb.append("sgtm_diagnostics {\n");
                    int zzf = zzaz.zzf();
                    zzW(sb, 2, "upload_type", zzf != 1 ? zzf != 2 ? zzf != 3 ? zzf != 4 ? "SDK_SERVICE_UPLOAD" : "PACKAGE_SERVICE_UPLOAD" : "SDK_CLIENT_UPLOAD" : "GA_UPLOAD" : "UPLOAD_TYPE_UNKNOWN");
                    zzW(sb, 2, "client_upload_eligibility", zzaz.zza().name());
                    int zzh = zzaz.zzh();
                    zzW(sb, 2, "service_upload_eligibility", zzh != 1 ? zzh != 2 ? zzh != 3 ? zzh != 4 ? zzh != 5 ? "NON_PLAY_MISSING_SGTM_SERVER_URL" : "MISSING_SGTM_PROXY_INFO" : "MISSING_SGTM_SETTINGS" : "NOT_IN_ROLLOUT" : "SERVICE_UPLOAD_ELIGIBLE" : "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN");
                    zzQ(sb, 2);
                    sb.append("}\n");
                }
                if (zzidVar.zzaC()) {
                    com.google.android.gms.internal.measurement.zzho zzaD = zzidVar.zzaD();
                    zzQ(sb, 2);
                    sb.append("consent_info_extra {\n");
                    for (com.google.android.gms.internal.measurement.zzhl zzhlVar : zzaD.zza()) {
                        zzQ(sb, 3);
                        sb.append("limited_data_modes {\n");
                        int zzc = zzhlVar.zzc();
                        zzW(sb, 3, "type", zzc != 1 ? zzc != 2 ? zzc != 3 ? zzc != 4 ? "AD_PERSONALIZATION" : "AD_USER_DATA" : "ANALYTICS_STORAGE" : "AD_STORAGE" : "CONSENT_TYPE_UNSPECIFIED");
                        int zzd = zzhlVar.zzd();
                        zzW(sb, 3, UpdateActivity.UPDATE_MODE, zzd != 1 ? zzd != 2 ? "NO_DATA_MODE" : "LIMITED_MODE" : "NOT_LIMITED");
                        zzQ(sb, 3);
                        sb.append("}\n");
                    }
                    zzQ(sb, 2);
                    sb.append("}\n");
                }
                List<com.google.android.gms.internal.measurement.zziu> zzf2 = zzidVar.zzf();
                if (zzf2 != null) {
                    for (com.google.android.gms.internal.measurement.zziu zziuVar : zzf2) {
                        if (zziuVar != null) {
                            zzQ(sb, 2);
                            sb.append("user_property {\n");
                            zzW(sb, 2, "set_timestamp_millis", zziuVar.zza() ? Long.valueOf(zziuVar.zzb()) : null);
                            zzW(sb, 2, "name", zzicVar.zzl().zzc(zziuVar.zzc()));
                            zzW(sb, 2, "string_value", zziuVar.zze());
                            zzW(sb, 2, "int_value", zziuVar.zzf() ? Long.valueOf(zziuVar.zzh()) : null);
                            zzW(sb, 2, "double_value", zziuVar.zzk() ? Double.valueOf(zziuVar.zzl()) : null);
                            zzQ(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhg> zzS = zzidVar.zzS();
                if (zzS != null) {
                    for (com.google.android.gms.internal.measurement.zzhg zzhgVar : zzS) {
                        if (zzhgVar != null) {
                            zzQ(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzhgVar.zza()) {
                                zzW(sb, 2, "audience_id", Integer.valueOf(zzhgVar.zzb()));
                            }
                            if (zzhgVar.zzf()) {
                                zzW(sb, 2, "new_audience", Boolean.valueOf(zzhgVar.zzh()));
                            }
                            zzV(sb, 2, "current_data", zzhgVar.zzc());
                            if (zzhgVar.zzd()) {
                                zzV(sb, 2, "previous_data", zzhgVar.zze());
                            }
                            zzQ(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<com.google.android.gms.internal.measurement.zzhs> zzc2 = zzidVar.zzc();
                if (zzc2 != null) {
                    for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzc2) {
                        if (zzhsVar != null) {
                            zzQ(sb, 2);
                            sb.append("event {\n");
                            zzW(sb, 2, "name", zzicVar.zzl().zza(zzhsVar.zzd()));
                            if (zzhsVar.zze()) {
                                zzW(sb, 2, "timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                            }
                            if (zzicVar.zzc().zzp(null, zzfy.zzbe) && zzhsVar.zzl()) {
                                zzW(sb, 2, "corrected_timestamp_millis", Long.valueOf(zzhsVar.zzm()));
                            }
                            if (zzhsVar.zzh()) {
                                zzW(sb, 2, "previous_timestamp_millis", Long.valueOf(zzhsVar.zzi()));
                            }
                            if (zzhsVar.zzj()) {
                                zzW(sb, 2, "count", Integer.valueOf(zzhsVar.zzk()));
                            }
                            if (zzhsVar.zzb() != 0) {
                                zzO(sb, 2, zzhsVar.zza());
                            }
                            zzQ(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zzQ(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzj(com.google.android.gms.internal.measurement.zzff zzffVar) {
        if (zzffVar == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzffVar.zza()) {
            zzW(sb, 0, "filter_id", Integer.valueOf(zzffVar.zzb()));
        }
        zzW(sb, 0, "event_name", this.zzu.zzl().zza(zzffVar.zzc()));
        String zzS = zzS(zzffVar.zzj(), zzffVar.zzk(), zzffVar.zzm());
        if (!zzS.isEmpty()) {
            zzW(sb, 0, "filter_type", zzS);
        }
        if (zzffVar.zzh()) {
            zzX(sb, 1, "event_count_filter", zzffVar.zzi());
        }
        if (zzffVar.zze() > 0) {
            sb.append("  filters {\n");
            for (com.google.android.gms.internal.measurement.zzfh zzfhVar : zzffVar.zzd()) {
                zzP(sb, 2, zzfhVar);
            }
        }
        zzQ(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzk(com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        if (zzfnVar == null) {
            return AbstractJsonLexerKt.NULL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzfnVar.zza()) {
            zzW(sb, 0, "filter_id", Integer.valueOf(zzfnVar.zzb()));
        }
        zzW(sb, 0, "property_name", this.zzu.zzl().zzc(zzfnVar.zzc()));
        String zzS = zzS(zzfnVar.zze(), zzfnVar.zzf(), zzfnVar.zzi());
        if (!zzS.isEmpty()) {
            zzW(sb, 0, "filter_type", zzS);
        }
        zzP(sb, 1, zzfnVar.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Parcelable zzl(byte[] bArr, Parcelable.Creator creator) {
        Parcelable parcelable = null;
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            try {
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                parcelable = (Parcelable) creator.createFromParcel(obtain);
            } catch (SafeParcelReader.ParseException unused) {
                this.zzu.zzaW().zzb().zza("Failed to load parcelable from buffer");
            }
            return parcelable;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzq(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzu.zzaW().zze().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzu.zzaW().zze().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzs(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(this.zzu.zzba().currentTimeMillis() - j) > j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzt(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzic zzicVar = this.zzu;
        zzicVar.zzk().zzg();
        MessageDigest zzQ = zzpp.zzQ();
        if (zzQ == null) {
            zzicVar.zzaW().zzb().zza("Failed to get MD5");
            return 0L;
        }
        return zzpp.zzR(zzQ.digest(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzu(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return zzt(str.getBytes(StandardCharsets.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzv(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.zzu.zzaW().zzb().zzb("Failed to gzip content", e);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        r5 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r4 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
        r3 = (android.os.Parcelable[]) r3;
        r4 = r3.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r7 >= r4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
        r8 = r3[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        if ((r8 instanceof android.os.Bundle) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        r5.add(zzz((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if ((r3 instanceof java.util.ArrayList) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        r3 = (java.util.ArrayList) r3;
        r4 = r3.size();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
        if (r7 >= r4) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
        r8 = r3.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        if ((r8 instanceof android.os.Bundle) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0067, code lost:
        r5.add(zzz((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        if ((r3 instanceof android.os.Bundle) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        r5.add(zzz((android.os.Bundle) r3, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
        r0.put(r2, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map zzz(Bundle bundle, boolean z) {
        HashMap hashMap = new HashMap();
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Object obj = bundle.get(next);
            boolean z2 = obj instanceof Parcelable[];
            if (!z2 && !(obj instanceof ArrayList) && !(obj instanceof Bundle)) {
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
        }
        return hashMap;
    }
}
