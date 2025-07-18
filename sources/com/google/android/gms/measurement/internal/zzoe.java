package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzoe {
    static final ImmutableList zza = ImmutableList.of("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static final boolean zzc(com.google.android.gms.internal.measurement.zzko zzkoVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        int i6;
        int i7;
        com.google.android.gms.internal.measurement.zzko zzkoVar2;
        ImmutableMap immutableMap3;
        char[] cArr2;
        int i8;
        int i9;
        int i10;
        String str4;
        String str5;
        String str6;
        boolean z4;
        boolean z5;
        boolean z6;
        int i11;
        int i12;
        int i13;
        ImmutableMap immutableMap4;
        ImmutableSet immutableSet2;
        ImmutableSet immutableSet3;
        String str7;
        zzod zzodVar;
        char c;
        int zze = zze(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3);
        if (zze > 0) {
            i7 = i3;
            i6 = i2;
            if (i7 == 1) {
                if (i6 == 1) {
                    zzkoVar2 = zzkoVar;
                    immutableMap4 = immutableMap2;
                    immutableSet2 = immutableSet;
                    cArr2 = cArr;
                    i8 = i;
                    i9 = i4;
                    i10 = i5;
                    str4 = str;
                    str5 = str2;
                    str6 = str3;
                    z4 = z;
                    z5 = z2;
                    z6 = z3;
                    i11 = zze;
                    i13 = 1;
                    i12 = 1;
                    immutableMap3 = immutableMap;
                    if (zzi(zzkoVar2, immutableMap3, immutableMap4, immutableSet2, cArr2, i8, i13, i12, i9, i10, str4, str5, str6, z4, z5, z6) != com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED) {
                        c = '3';
                    } else {
                        int i14 = i5;
                        if (zzkoVar2 == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                            immutableSet3 = immutableSet;
                            str7 = str;
                            if (i14 == 1) {
                                if (immutableSet3.contains(str7)) {
                                    if (i11 > 0 && cArr[i11] != '2') {
                                        cArr[i11] = '1';
                                    }
                                    return true;
                                }
                                i14 = 1;
                            }
                        } else {
                            immutableSet3 = immutableSet;
                            str7 = str;
                        }
                        if (immutableMap3.containsKey(zzkoVar2) && (zzodVar = (zzod) immutableMap3.get(zzkoVar2)) != null) {
                            int ordinal = zzodVar.ordinal();
                            if (ordinal != 0) {
                                if (ordinal != 1) {
                                    if (ordinal == 2) {
                                        if (zzi(zzkoVar2, immutableMap3, immutableMap2, immutableSet3, cArr, i, i13, i12, i4, i14, str7, str2, str3, z, z2, z3) == com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                            return zzh(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i13, i12, i4, i14, str, str2, str3, z, z2, z3);
                                        }
                                        return zzg(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i13, i12, i4, i14, str, str2, str3, z, z2, z3);
                                    } else if (ordinal == 3) {
                                        if (zzi(zzkoVar2, immutableMap3, immutableMap2, immutableSet3, cArr, i, i13, i12, i4, i14, str7, str2, str3, z, z2, z3) == com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                            return zzg(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i13, i12, i4, i14, str, str2, str3, z, z2, z3);
                                        }
                                        return zzh(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i13, i12, i4, i14, str, str2, str3, z, z2, z3);
                                    }
                                } else if (zzi(zzkoVar2, immutableMap3, immutableMap2, immutableSet3, cArr, i, i13, i12, i4, i14, str7, str2, str3, z, z2, z3) != com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                    return zzh(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i13, i12, i4, i14, str, str2, str3, z, z2, z3);
                                }
                            } else if (zzi(zzkoVar2, immutableMap3, immutableMap2, immutableSet3, cArr, i, i13, i12, i4, i14, str7, str2, str3, z, z2, z3) != com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                return zzg(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i13, i12, i4, i14, str, str2, str3, z, z2, z3);
                            }
                            c = '8';
                        }
                        c = '0';
                    }
                    if (i11 <= 0 && cArr[i11] != '2') {
                        cArr[i11] = c;
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
        zzkoVar2 = zzkoVar;
        immutableMap3 = immutableMap;
        cArr2 = cArr;
        i8 = i;
        i9 = i4;
        i10 = i5;
        str4 = str;
        str5 = str2;
        str6 = str3;
        z4 = z;
        z5 = z2;
        z6 = z3;
        i11 = zze;
        i12 = i7;
        i13 = i6;
        immutableMap4 = immutableMap2;
        immutableSet2 = immutableSet;
        if (zzi(zzkoVar2, immutableMap3, immutableMap4, immutableSet2, cArr2, i8, i13, i12, i9, i10, str4, str5, str6, z4, z5, z6) != com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_NOT_ALLOWED) {
        }
        return i11 <= 0 ? false : false;
    }

    public static final Map zzd(ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        int zza2;
        int zza3;
        int zza4;
        int zza5;
        com.google.android.gms.internal.measurement.zzko zzkoVar;
        Object obj;
        if (!((Boolean) zzfx.zzba.zzb(null)).booleanValue() || z3) {
            com.google.android.gms.internal.measurement.zzko zzkoVar2 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
            com.google.android.gms.internal.measurement.zzkp zzkpVar = (com.google.android.gms.internal.measurement.zzkp) immutableMap2.get(zzkoVar2);
            com.google.android.gms.internal.measurement.zzko zzkoVar3 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
            com.google.android.gms.internal.measurement.zzkp zzkpVar2 = (com.google.android.gms.internal.measurement.zzkp) immutableMap2.get(zzkoVar3);
            com.google.android.gms.internal.measurement.zzko zzkoVar4 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
            com.google.android.gms.internal.measurement.zzkp zzkpVar3 = (com.google.android.gms.internal.measurement.zzkp) immutableMap2.get(zzkoVar4);
            com.google.android.gms.internal.measurement.zzko zzkoVar5 = com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
            com.google.android.gms.internal.measurement.zzkp zzkpVar4 = (com.google.android.gms.internal.measurement.zzkp) immutableMap2.get(zzkoVar5);
            ImmutableMap.Builder put = ImmutableMap.builder().put("Version", ExifInterface.GPS_MEASUREMENT_2D).put("VendorConsent", true != z ? "0" : "1").put("VendorLegitimateInterest", true != z2 ? "0" : "1").put("gdprApplies", i3 != 1 ? "0" : "1").put("EnableAdvertiserConsentMode", i2 != 1 ? "0" : "1").put("PolicyVersion", String.valueOf(i4)).put("CmpSdkID", String.valueOf(i)).put("PurposeOneTreatment", i5 != 1 ? "0" : "1").put("PublisherCC", str);
            if (zzkpVar != null) {
                zza2 = zzkpVar.zza();
            } else {
                zza2 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
            }
            ImmutableMap.Builder put2 = put.put("PublisherRestrictions1", String.valueOf(zza2));
            if (zzkpVar2 != null) {
                zza3 = zzkpVar2.zza();
            } else {
                zza3 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
            }
            ImmutableMap.Builder put3 = put2.put("PublisherRestrictions3", String.valueOf(zza3));
            if (zzkpVar3 != null) {
                zza4 = zzkpVar3.zza();
            } else {
                zza4 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
            }
            ImmutableMap.Builder put4 = put3.put("PublisherRestrictions4", String.valueOf(zza4));
            if (zzkpVar4 != null) {
                zza5 = zzkpVar4.zza();
            } else {
                zza5 = com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED.zza();
            }
            ImmutableMap.Builder putAll = put4.put("PublisherRestrictions7", String.valueOf(zza5)).putAll(ImmutableMap.of("Purpose1", zzf(zzkoVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3), "Purpose3", zzf(zzkoVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3), "Purpose4", zzf(zzkoVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3), "Purpose7", zzf(zzkoVar5, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3)));
            String str4 = true != zzc(zzkoVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3) ? "0" : "1";
            if (true != zzc(zzkoVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3)) {
                zzkoVar = zzkoVar4;
                obj = "0";
            } else {
                zzkoVar = zzkoVar4;
                obj = "1";
            }
            return putAll.putAll(ImmutableMap.of("AuthorizePurpose1", (String) str4, "AuthorizePurpose3", (String) obj, "AuthorizePurpose4", (String) (true != zzc(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3) ? "0" : "1"), "AuthorizePurpose7", true == zzc(zzkoVar5, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3) ? "1" : "0", "PurposeDiagnostics", new String(cArr))).buildOrThrow();
        }
        return ImmutableMap.of();
    }

    private static final int zze(com.google.android.gms.internal.measurement.zzko zzkoVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkoVar == com.google.android.gms.internal.measurement.zzko.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final String zzf(com.google.android.gms.internal.measurement.zzko zzkoVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        String str4 = "0";
        String valueOf = (TextUtils.isEmpty(str2) || str2.length() < zzkoVar.zza()) ? "0" : String.valueOf(str2.charAt(zzkoVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzkoVar.zza()) {
            str4 = String.valueOf(str3.charAt(zzkoVar.zza() - 1));
        }
        String.valueOf(valueOf);
        String.valueOf(str4);
        return String.valueOf(valueOf).concat(String.valueOf(str4));
    }

    private static final boolean zzg(com.google.android.gms.internal.measurement.zzko zzkoVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        char c;
        int zze = zze(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3);
        if (!z) {
            c = '4';
        } else if (str2.length() >= zzkoVar.zza()) {
            char charAt = str2.charAt(zzkoVar.zza() - 1);
            boolean z4 = charAt == '1';
            if (zze > 0 && cArr[zze] != '2') {
                cArr[zze] = charAt != '1' ? '6' : '1';
            }
            return z4;
        } else {
            c = '0';
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c;
        }
        return false;
    }

    private static final boolean zzh(com.google.android.gms.internal.measurement.zzko zzkoVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        char c;
        int zze = zze(zzkoVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, z3);
        if (!z2) {
            c = '5';
        } else if (str3.length() >= zzkoVar.zza()) {
            char charAt = str3.charAt(zzkoVar.zza() - 1);
            boolean z4 = charAt == '1';
            if (zze > 0 && cArr[zze] != '2') {
                cArr[zze] = charAt != '1' ? '7' : '1';
            }
            return z4;
        } else {
            c = '0';
        }
        if (zze > 0 && cArr[zze] != '2') {
            cArr[zze] = c;
        }
        return false;
    }

    private static final com.google.android.gms.internal.measurement.zzkp zzi(com.google.android.gms.internal.measurement.zzko zzkoVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        return (com.google.android.gms.internal.measurement.zzkp) immutableMap2.getOrDefault(zzkoVar, com.google.android.gms.internal.measurement.zzkp.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
