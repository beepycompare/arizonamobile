package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzab {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    private static Boolean zzd(String str, int i, boolean z, String str2, List list, String str3, zzgt zzgtVar) {
        if (i == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzgtVar != null) {
                        zzgtVar.zze().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zze(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzf(String str, com.google.android.gms.internal.measurement.zzfr zzfrVar, zzgt zzgtVar) {
        String zzc;
        List list;
        Preconditions.checkNotNull(zzfrVar);
        if (str != null && zzfrVar.zza() && zzfrVar.zzj() != 1 && (zzfrVar.zzj() != 7 ? zzfrVar.zzb() : zzfrVar.zzg() != 0)) {
            int zzj = zzfrVar.zzj();
            boolean zze = zzfrVar.zze();
            if (zze || zzj == 2 || zzj == 7) {
                zzc = zzfrVar.zzc();
            } else {
                zzc = zzfrVar.zzc().toUpperCase(Locale.ENGLISH);
            }
            String str2 = zzc;
            if (zzfrVar.zzg() == 0) {
                list = null;
            } else {
                List<String> zzf = zzfrVar.zzf();
                if (!zze) {
                    ArrayList arrayList = new ArrayList(zzf.size());
                    for (String str3 : zzf) {
                        arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                    }
                    zzf = Collections.unmodifiableList(arrayList);
                }
                list = zzf;
            }
            return zzd(str, zzj, zze, str2, list, zzj == 2 ? str2 : null, zzgtVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzg(long j, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        try {
            return zzj(new BigDecimal(j), zzflVar, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzh(double d, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        try {
            return zzj(new BigDecimal(d), zzflVar, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean zzi(String str, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        if (zzpj.zzm(str)) {
            try {
                return zzj(new BigDecimal(str), zzflVar, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    static Boolean zzj(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzfl zzflVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzflVar);
        if (zzflVar.zza()) {
            if (zzflVar.zzm() != 1) {
                if (zzflVar.zzm() == 5) {
                    if (!zzflVar.zzf() || !zzflVar.zzh()) {
                        return null;
                    }
                } else if (!zzflVar.zzd()) {
                    return null;
                }
                int zzm = zzflVar.zzm();
                if (zzflVar.zzm() == 5) {
                    if (zzpj.zzm(zzflVar.zzg()) && zzpj.zzm(zzflVar.zzi())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzflVar.zzg());
                            bigDecimal4 = new BigDecimal(zzflVar.zzi());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!zzpj.zzm(zzflVar.zze())) {
                    return null;
                } else {
                    try {
                        bigDecimal2 = new BigDecimal(zzflVar.zze());
                        bigDecimal3 = null;
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int i = zzm - 1;
                if (i == 1) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                } else if (i == 2) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                } else if (i != 3) {
                    if (i == 4 && bigDecimal3 != null) {
                        if (bigDecimal.compareTo(bigDecimal3) < 0 || bigDecimal.compareTo(bigDecimal4) > 0) {
                            r2 = false;
                        }
                        return Boolean.valueOf(r2);
                    }
                    return null;
                } else if (bigDecimal2 == null) {
                    return null;
                } else {
                    if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                    }
                    if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) >= 0) {
                        r2 = false;
                    }
                    return Boolean.valueOf(r2);
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean zzc();
}
