package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes4.dex */
public final class zznz {
    public static final /* synthetic */ int zza = 0;
    private static final zzoi zzb;

    static {
        int i = zznu.zza;
        zzb = new zzok();
    }

    public static zzoi zzA() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzB(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzC(zzls zzlsVar, Object obj, Object obj2) {
        if (((zzmc) obj2).zzb.zza.isEmpty()) {
            return;
        }
        zzmc zzmcVar = (zzmc) obj;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzD(zzoi zzoiVar, Object obj, Object obj2) {
        zzmf zzmfVar = (zzmf) obj;
        zzoj zzojVar = zzmfVar.zzc;
        zzoj zzojVar2 = ((zzmf) obj2).zzc;
        if (!zzoj.zza().equals(zzojVar2)) {
            if (zzoj.zza().equals(zzojVar)) {
                zzojVar = zzoj.zzc(zzojVar, zzojVar2);
            } else {
                zzojVar.zzl(zzojVar2);
            }
        }
        zzmfVar.zzc = zzojVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzE(Object obj, int i, int i2, Object obj2, zzoi zzoiVar) {
        if (obj2 == null) {
            obj2 = zzoiVar.zza(obj);
        }
        ((zzoj) obj2).zzk(i << 3, Long.valueOf(i2));
        return obj2;
    }

    public static void zza(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzov zzovVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzovVar.zzE(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlm.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzna zznaVar = (zzna) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlm.zzA(zznaVar.zzc(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlm.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzna zznaVar = (zzna) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlm.zzA(zznaVar.zzc(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzq(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzna)) {
            int i2 = 0;
            while (i < size) {
                long longValue = ((Long) list.get(i)).longValue();
                i2 += zzlm.zzA((longValue >> 63) ^ (longValue + longValue));
                i++;
            }
            return i2;
        }
        zzna zznaVar = (zzna) list;
        int i3 = 0;
        while (i < size) {
            long zzc = zznaVar.zzc(i);
            i3 += zzlm.zzA((zzc >> 63) ^ (zzc + zzc));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzr(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlm.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzmg zzmgVar = (zzmg) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlm.zzA(zzmgVar.zzf(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzs(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlm.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzmg zzmgVar = (zzmg) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlm.zzA(zzmgVar.zzf(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzt(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlm.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzmg zzmgVar = (zzmg) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlm.zzz(zzmgVar.zzf(i));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzu(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmg)) {
            int i2 = 0;
            while (i < size) {
                int intValue = ((Integer) list.get(i)).intValue();
                i2 += zzlm.zzz((intValue >> 31) ^ (intValue + intValue));
                i++;
            }
            return i2;
        }
        zzmg zzmgVar = (zzmg) list;
        int i3 = 0;
        while (i < size) {
            int zzf = zzmgVar.zzf(i);
            i3 += zzlm.zzz((zzf >> 31) ^ (zzf + zzf));
            i++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzv(List list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzw(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlm.zzz(i << 3) + 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzx(List list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzy(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlm.zzz(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(int i, Object obj, zznx zznxVar) {
        int i2 = i << 3;
        if (obj instanceof zzmw) {
            int zzz = zzlm.zzz(i2);
            int zzb2 = ((zzmw) obj).zzb();
            return zzz + zzlm.zzz(zzb2) + zzb2;
        }
        return zzlm.zzz(i2) + zzlm.zzD((zznm) obj, zznxVar);
    }
}
