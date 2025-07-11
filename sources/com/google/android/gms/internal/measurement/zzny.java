package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzny {
    public static final /* synthetic */ int zza = 0;
    private static final zzoh zzb;

    static {
        int i = zznt.zza;
        zzb = new zzoj();
    }

    public static zzoh zzA() {
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
    public static void zzC(zzlr zzlrVar, Object obj, Object obj2) {
        if (((zzmb) obj2).zzb.zza.isEmpty()) {
            return;
        }
        zzmb zzmbVar = (zzmb) obj;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzD(zzoh zzohVar, Object obj, Object obj2) {
        zzme zzmeVar = (zzme) obj;
        zzoi zzoiVar = zzmeVar.zzc;
        zzoi zzoiVar2 = ((zzme) obj2).zzc;
        if (!zzoi.zza().equals(zzoiVar2)) {
            if (zzoi.zza().equals(zzoiVar)) {
                zzoiVar = zzoi.zzc(zzoiVar, zzoiVar2);
            } else {
                zzoiVar.zzl(zzoiVar2);
            }
        }
        zzmeVar.zzc = zzoiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzE(Object obj, int i, int i2, Object obj2, zzoh zzohVar) {
        if (obj2 == null) {
            obj2 = zzohVar.zza(obj);
        }
        ((zzoi) obj2).zzk(i << 3, Long.valueOf(i2));
        return obj2;
    }

    public static void zza(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzou zzouVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzouVar.zzE(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzmz)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzll.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzmz zzmzVar = (zzmz) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzll.zzA(zzmzVar.zzc(i));
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
        if (!(list instanceof zzmz)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzll.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzmz zzmzVar = (zzmz) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzll.zzA(zzmzVar.zzc(i));
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
        if (!(list instanceof zzmz)) {
            int i2 = 0;
            while (i < size) {
                long longValue = ((Long) list.get(i)).longValue();
                i2 += zzll.zzA((longValue >> 63) ^ (longValue + longValue));
                i++;
            }
            return i2;
        }
        zzmz zzmzVar = (zzmz) list;
        int i3 = 0;
        while (i < size) {
            long zzc = zzmzVar.zzc(i);
            i3 += zzll.zzA((zzc >> 63) ^ (zzc + zzc));
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
        if (!(list instanceof zzmf)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzll.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzmf zzmfVar = (zzmf) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzll.zzA(zzmfVar.zzf(i));
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
        if (!(list instanceof zzmf)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzll.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzmf zzmfVar = (zzmf) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzll.zzA(zzmfVar.zzf(i));
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
        if (!(list instanceof zzmf)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzll.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzmf zzmfVar = (zzmf) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzll.zzz(zzmfVar.zzf(i));
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
        if (!(list instanceof zzmf)) {
            int i2 = 0;
            while (i < size) {
                int intValue = ((Integer) list.get(i)).intValue();
                i2 += zzll.zzz((intValue >> 31) ^ (intValue + intValue));
                i++;
            }
            return i2;
        }
        zzmf zzmfVar = (zzmf) list;
        int i3 = 0;
        while (i < size) {
            int zzf = zzmfVar.zzf(i);
            i3 += zzll.zzz((zzf >> 31) ^ (zzf + zzf));
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
        return size * (zzll.zzz(i << 3) + 4);
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
        return size * (zzll.zzz(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(int i, Object obj, zznw zznwVar) {
        int i2 = i << 3;
        if (obj instanceof zzmv) {
            int zzz = zzll.zzz(i2);
            int zzb2 = ((zzmv) obj).zzb();
            return zzz + zzll.zzz(zzb2) + zzb2;
        }
        return zzll.zzz(i2) + zzll.zzD((zznl) obj, zznwVar);
    }
}
