package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzhn {
    public static final /* synthetic */ int zza = 0;
    private static final zzib zzb;

    static {
        int i = zzei.zza;
        zzb = new zzid();
    }

    public static void zzA(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzB(i, list, z);
    }

    public static void zzB(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzD(i, list, z);
    }

    public static void zzC(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzF(i, list, z);
    }

    public static void zzD(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzK(i, list, z);
    }

    public static void zzE(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzM(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzF(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zza(int i, zzhb zzhbVar, zzhl zzhlVar) {
        int zzy = zzfc.zzy(i << 3);
        return zzy + zzy + ((zzeg) zzhbVar).zzi(zzhlVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzfc.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzfv zzfvVar = (zzfv) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzfc.zzz(zzfvVar.zze(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfc.zzy(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzfc.zzy(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzfc.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzfv zzfvVar = (zzfv) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzfc.zzz(zzfvVar.zze(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgp)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzfc.zzz(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzgp zzgpVar = (zzgp) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzfc.zzz(zzgpVar.zze(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i, Object obj, zzhl zzhlVar) {
        int zzy;
        int zzi;
        int zzy2;
        int i2 = i << 3;
        if (obj instanceof zzgi) {
            zzy = zzfc.zzy(i2);
            zzi = ((zzgi) obj).zza();
            zzy2 = zzfc.zzy(zzi);
        } else {
            zzy = zzfc.zzy(i2);
            zzi = ((zzeg) obj).zzi(zzhlVar);
            zzy2 = zzfc.zzy(zzi);
        }
        return zzy + zzy2 + zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int i2 = 0;
            while (i < size) {
                int intValue = ((Integer) list.get(i)).intValue();
                i2 += zzfc.zzy((intValue >> 31) ^ (intValue + intValue));
                i++;
            }
            return i2;
        }
        zzfv zzfvVar = (zzfv) list;
        int i3 = 0;
        while (i < size) {
            int zze = zzfvVar.zze(i);
            i3 += zzfc.zzy((zze >> 31) ^ (zze + zze));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgp)) {
            int i2 = 0;
            while (i < size) {
                long longValue = ((Long) list.get(i)).longValue();
                i2 += zzfc.zzz((longValue >> 63) ^ (longValue + longValue));
                i++;
            }
            return i2;
        }
        zzgp zzgpVar = (zzgp) list;
        int i3 = 0;
        while (i < size) {
            long zze = zzgpVar.zze(i);
            i3 += zzfc.zzz((zze >> 63) ^ (zze + zze));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfv)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzfc.zzy(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzfv zzfvVar = (zzfv) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzfc.zzy(zzfvVar.zze(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgp)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzfc.zzz(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzgp zzgpVar = (zzgp) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzfc.zzz(zzgpVar.zze(i));
            i++;
        }
        return i3;
    }

    public static zzib zzn() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzo(Object obj, int i, int i2, Object obj2, zzib zzibVar) {
        if (obj2 == null) {
            obj2 = zzibVar.zza(obj);
        }
        ((zzic) obj2).zzj(i << 3, Long.valueOf(i2));
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzp(zzfi zzfiVar, Object obj, Object obj2) {
        if (((zzfr) obj2).zzb.zza.isEmpty()) {
            return;
        }
        zzfr zzfrVar = (zzfr) obj;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(zzib zzibVar, Object obj, Object obj2) {
        zzfu zzfuVar = (zzfu) obj;
        zzic zzicVar = zzfuVar.zzc;
        zzic zzicVar2 = ((zzfu) obj2).zzc;
        if (!zzic.zzc().equals(zzicVar2)) {
            if (zzic.zzc().equals(zzicVar)) {
                zzicVar = zzic.zze(zzicVar, zzicVar2);
            } else {
                zzicVar.zzd(zzicVar2);
            }
        }
        zzfuVar.zzc = zzicVar;
    }

    public static void zzr(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzg(i, list, z);
    }

    public static void zzt(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzj(i, list, z);
    }

    public static void zzu(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzl(i, list, z);
    }

    public static void zzv(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzn(i, list, z);
    }

    public static void zzw(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzp(i, list, z);
    }

    public static void zzx(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzs(i, list, z);
    }

    public static void zzy(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzu(i, list, z);
    }

    public static void zzz(int i, List list, zzit zzitVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzitVar.zzz(i, list, z);
    }
}
