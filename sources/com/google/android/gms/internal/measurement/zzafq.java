package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzafq {
    public static final /* synthetic */ int zza = 0;
    private static final zzafz zzb;

    static {
        int i = zzacf.zza;
        zzb = new zzagb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzA(int i, zzafc zzafcVar, zzafp zzafpVar) {
        int zzE = zzada.zzE(i << 3);
        return zzE + zzE + ((zzacb) zzafcVar).zzcf(zzafpVar);
    }

    public static zzafz zzB() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzC(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzD(zzadg zzadgVar, Object obj, Object obj2) {
        if (((zzadr) obj2).zzb.zza.isEmpty()) {
            return;
        }
        zzadr zzadrVar = (zzadr) obj;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzE(zzafz zzafzVar, Object obj, Object obj2) {
        zzadu zzaduVar = (zzadu) obj;
        zzaga zzagaVar = zzaduVar.zzc;
        zzaga zzagaVar2 = ((zzadu) obj2).zzc;
        if (!zzaga.zza().equals(zzagaVar2)) {
            if (zzaga.zza().equals(zzagaVar)) {
                zzagaVar = zzaga.zzc(zzagaVar, zzagaVar2);
            } else {
                zzagaVar.zzl(zzagaVar2);
            }
        }
        zzaduVar.zzc = zzagaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzF(Object obj, int i, List list, zzadz zzadzVar, Object obj2, zzafz zzafzVar) {
        if (zzadzVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzadzVar.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzG(obj, i, intValue, obj2, zzafzVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return obj2;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Integer) it.next()).intValue();
            if (!zzadzVar.zza(intValue2)) {
                obj2 = zzG(obj, i, intValue2, obj2, zzafzVar);
                it.remove();
            }
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzG(Object obj, int i, int i2, Object obj2, zzafz zzafzVar) {
        if (obj2 == null) {
            obj2 = zzafzVar.zzh(obj);
        }
        zzafzVar.zza(obj2, i, i2);
        return obj2;
    }

    public static void zza(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzago zzagoVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzagoVar.zzE(i, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzaeq)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzada.zzF(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzada.zzF(zzaeqVar.zzc(i));
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
        if (!(list instanceof zzaeq)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzada.zzF(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzada.zzF(zzaeqVar.zzc(i));
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
        if (!(list instanceof zzaeq)) {
            int i2 = 0;
            while (i < size) {
                long longValue = ((Long) list.get(i)).longValue();
                i2 += zzada.zzF((longValue >> 63) ^ (longValue + longValue));
                i++;
            }
            return i2;
        }
        zzaeq zzaeqVar = (zzaeq) list;
        int i3 = 0;
        while (i < size) {
            long zzc = zzaeqVar.zzc(i);
            i3 += zzada.zzF((zzc >> 63) ^ (zzc + zzc));
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
        if (!(list instanceof zzadv)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzada.zzF(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzadv zzadvVar = (zzadv) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzada.zzF(zzadvVar.zzf(i));
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
        if (!(list instanceof zzadv)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzada.zzF(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzadv zzadvVar = (zzadv) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzada.zzF(zzadvVar.zzf(i));
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
        if (!(list instanceof zzadv)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzada.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzadv zzadvVar = (zzadv) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzada.zzE(zzadvVar.zzf(i));
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
        if (!(list instanceof zzadv)) {
            int i2 = 0;
            while (i < size) {
                int intValue = ((Integer) list.get(i)).intValue();
                i2 += zzada.zzE((intValue >> 31) ^ (intValue + intValue));
                i++;
            }
            return i2;
        }
        zzadv zzadvVar = (zzadv) list;
        int i3 = 0;
        while (i < size) {
            int zzf = zzadvVar.zzf(i);
            i3 += zzada.zzE((zzf >> 31) ^ (zzf + zzf));
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
        return size * (zzada.zzE(i << 3) + 4);
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
        return size * (zzada.zzE(i << 3) + 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzz(int i, Object obj, zzafp zzafpVar) {
        int zzE;
        int zzcf;
        int zzE2;
        int i2 = i << 3;
        if (obj instanceof zzaem) {
            zzE = zzada.zzE(i2);
            zzcf = ((zzaem) obj).zzb();
            zzE2 = zzada.zzE(zzcf);
        } else {
            zzE = zzada.zzE(i2);
            zzcf = ((zzacb) obj).zzcf(zzafpVar);
            zzE2 = zzada.zzE(zzcf);
        }
        return zzE + zzE2 + zzcf;
    }
}
