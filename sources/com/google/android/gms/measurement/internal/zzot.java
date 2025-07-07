package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzot {
    static final ImmutableList zza = ImmutableList.of("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static final Map zzc(ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        int zza2;
        int zza3;
        int zza4;
        int zza5;
        com.google.android.gms.internal.measurement.zzkl zzklVar;
        Object obj;
        com.google.android.gms.internal.measurement.zzkl zzklVar2;
        Object obj2;
        com.google.android.gms.internal.measurement.zzkl zzklVar3 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar3);
        com.google.android.gms.internal.measurement.zzkl zzklVar4 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar2 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar4);
        com.google.android.gms.internal.measurement.zzkl zzklVar5 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.zzkm zzkmVar3 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar5);
        com.google.android.gms.internal.measurement.zzkl zzklVar6 = com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.zzkm zzkmVar4 = (com.google.android.gms.internal.measurement.zzkm) immutableMap2.get(zzklVar6);
        ImmutableMap.Builder put = ImmutableMap.builder().put("Version", ExifInterface.GPS_MEASUREMENT_2D).put("VendorConsent", true != z ? "0" : "1").put("VendorLegitimateInterest", true != z2 ? "0" : "1").put("gdprApplies", i3 != 1 ? "0" : "1").put("EnableAdvertiserConsentMode", i2 != 1 ? "0" : "1").put("PolicyVersion", String.valueOf(i4)).put("CmpSdkID", String.valueOf(i)).put("PurposeOneTreatment", i5 != 1 ? "0" : "1").put("PublisherCC", str);
        if (zzkmVar != null) {
            zza2 = zzkmVar.zza();
        } else {
            zza2 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put2 = put.put("PublisherRestrictions1", String.valueOf(zza2));
        if (zzkmVar2 != null) {
            zza3 = zzkmVar2.zza();
        } else {
            zza3 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put3 = put2.put("PublisherRestrictions3", String.valueOf(zza3));
        if (zzkmVar3 != null) {
            zza4 = zzkmVar3.zza();
        } else {
            zza4 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder put4 = put3.put("PublisherRestrictions4", String.valueOf(zza4));
        if (zzkmVar4 != null) {
            zza5 = zzkmVar4.zza();
        } else {
            zza5 = com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED.zza();
        }
        ImmutableMap.Builder putAll = put4.put("PublisherRestrictions7", String.valueOf(zza5)).putAll(ImmutableMap.of("Purpose1", zzg(zzklVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2), "Purpose3", zzg(zzklVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2), "Purpose4", zzg(zzklVar5, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2), "Purpose7", zzg(zzklVar6, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2)));
        if (true != zzd(zzklVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2)) {
            zzklVar = zzklVar4;
            obj = "0";
        } else {
            zzklVar = zzklVar4;
            obj = "1";
        }
        if (true != zzd(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2)) {
            zzklVar2 = zzklVar5;
            obj2 = "0";
        } else {
            zzklVar2 = zzklVar5;
            obj2 = "1";
        }
        return putAll.putAll(ImmutableMap.of("AuthorizePurpose1", (String) obj, "AuthorizePurpose3", (String) obj2, "AuthorizePurpose4", (String) (true != zzd(zzklVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2) ? "0" : "1"), "AuthorizePurpose7", true == zzd(zzklVar6, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2) ? "1" : "0", "PurposeDiagnostics", new String(cArr))).buildOrThrow();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final boolean zzd(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        int i6;
        int i7;
        com.google.android.gms.internal.measurement.zzkl zzklVar2;
        ImmutableMap immutableMap3;
        char[] cArr2;
        int i8;
        int i9;
        int i10;
        String str4;
        String str5;
        String str6;
        boolean z3;
        boolean z4;
        int i11;
        int i12;
        int i13;
        ImmutableMap immutableMap4;
        ImmutableSet immutableSet2;
        ImmutableSet immutableSet3;
        String str7;
        zzos zzosVar;
        char c;
        int zze = zze(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2);
        if (zze > 0) {
            i7 = i3;
            i6 = i2;
            if (i7 == 1) {
                if (i6 == 1) {
                    zzklVar2 = zzklVar;
                    immutableMap4 = immutableMap2;
                    immutableSet2 = immutableSet;
                    cArr2 = cArr;
                    i8 = i;
                    i9 = i4;
                    i10 = i5;
                    str4 = str;
                    str5 = str2;
                    str6 = str3;
                    z3 = z;
                    z4 = z2;
                    i12 = 1;
                    i11 = 1;
                    i13 = zze;
                    immutableMap3 = immutableMap;
                    if (zzf(zzklVar2, immutableMap3, immutableMap4, immutableSet2, cArr2, i8, i12, i11, i9, i10, str4, str5, str6, z3, z4) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_NOT_ALLOWED) {
                        c = '3';
                    } else {
                        int i14 = i5;
                        if (zzklVar2 == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                            immutableSet3 = immutableSet;
                            str7 = str;
                            if (i14 == 1) {
                                if (immutableSet3.contains(str7)) {
                                    if (i13 > 0 && cArr[i13] != '2') {
                                        cArr[i13] = '1';
                                    }
                                    return true;
                                }
                                i14 = 1;
                            }
                        } else {
                            immutableSet3 = immutableSet;
                            str7 = str;
                        }
                        if (immutableMap3.containsKey(zzklVar2) && (zzosVar = (zzos) immutableMap3.get(zzklVar2)) != null) {
                            int ordinal = zzosVar.ordinal();
                            if (ordinal != 0) {
                                if (ordinal != 1) {
                                    if (ordinal == 2) {
                                        if (zzf(zzklVar2, immutableMap3, immutableMap2, immutableSet3, cArr, i, i12, i11, i4, i14, str7, str2, str3, z, z2) == com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                            return zzi(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i12, i11, i4, i14, str, str2, str3, z, z2);
                                        }
                                        return zzh(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i12, i11, i4, i14, str, str2, str3, z, z2);
                                    } else if (ordinal == 3) {
                                        if (zzf(zzklVar2, immutableMap3, immutableMap2, immutableSet3, cArr, i, i12, i11, i4, i14, str7, str2, str3, z, z2) == com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                            return zzh(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i12, i11, i4, i14, str, str2, str3, z, z2);
                                        }
                                        return zzi(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i12, i11, i4, i14, str, str2, str3, z, z2);
                                    }
                                } else if (zzf(zzklVar2, immutableMap3, immutableMap2, immutableSet3, cArr, i, i12, i11, i4, i14, str7, str2, str3, z, z2) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                    return zzi(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i12, i11, i4, i14, str, str2, str3, z, z2);
                                }
                            } else if (zzf(zzklVar2, immutableMap3, immutableMap2, immutableSet3, cArr, i, i12, i11, i4, i14, str7, str2, str3, z, z2) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                return zzh(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i12, i11, i4, i14, str, str2, str3, z, z2);
                            }
                            c = '8';
                        }
                        c = '0';
                    }
                    if (i13 <= 0 && cArr[i13] != '2') {
                        cArr[i13] = c;
                        return false;
                    }
                }
                i7 = 1;
            }
            cArr[zze] = '2';
        } else {
            i6 = i2;
            i7 = i3;
        }
        zzklVar2 = zzklVar;
        immutableMap3 = immutableMap;
        cArr2 = cArr;
        i8 = i;
        i9 = i4;
        i10 = i5;
        str4 = str;
        str5 = str2;
        str6 = str3;
        z3 = z;
        z4 = z2;
        i11 = i7;
        i12 = i6;
        i13 = zze;
        immutableMap4 = immutableMap2;
        immutableSet2 = immutableSet;
        if (zzf(zzklVar2, immutableMap3, immutableMap4, immutableSet2, cArr2, i8, i12, i11, i9, i10, str4, str5, str6, z3, z4) != com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_NOT_ALLOWED) {
        }
        return i13 <= 0 ? false : false;
    }

    private static final int zze(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzklVar == com.google.android.gms.internal.measurement.zzkl.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final com.google.android.gms.internal.measurement.zzkm zzf(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        return (com.google.android.gms.internal.measurement.zzkm) immutableMap2.getOrDefault(zzklVar, com.google.android.gms.internal.measurement.zzkm.PURPOSE_RESTRICTION_UNDEFINED);
    }

    private static final String zzg(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        String str4 = "0";
        String valueOf = (TextUtils.isEmpty(str2) || str2.length() < zzklVar.zza()) ? "0" : String.valueOf(str2.charAt(zzklVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzklVar.zza()) {
            str4 = String.valueOf(str3.charAt(zzklVar.zza() - 1));
        }
        return String.valueOf(valueOf).concat(String.valueOf(str4));
    }

    private static final boolean zzh(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        char c;
        int zze = zze(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2);
        if (!z) {
            c = '4';
        } else if (str2.length() >= zzklVar.zza()) {
            char charAt = str2.charAt(zzklVar.zza() - 1);
            boolean z3 = charAt == '1';
            if (zze > 0 && cArr[zze] != '2') {
                cArr[zze] = charAt != '1' ? '6' : '1';
            }
            return z3;
        } else {
            c = '0';
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c;
        }
        return false;
    }

    private static final boolean zzi(com.google.android.gms.internal.measurement.zzkl zzklVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2) {
        char c;
        int zze = zze(zzklVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2);
        if (!z2) {
            c = '5';
        } else if (str3.length() >= zzklVar.zza()) {
            char charAt = str3.charAt(zzklVar.zza() - 1);
            boolean z3 = charAt == '1';
            if (zze > 0 && cArr[zze] != '2') {
                cArr[zze] = charAt != '1' ? '7' : '1';
            }
            return z3;
        } else {
            c = '0';
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c;
        }
        return false;
    }
}
