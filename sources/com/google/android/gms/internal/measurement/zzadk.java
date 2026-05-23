package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
final class zzadk {
    private static final zzadk zzd = new zzadk(true);
    final zzafv zza = new zzafr();
    boolean zzb;
    boolean zzc;

    private zzadk() {
    }

    public static zzadk zza() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzf(zzada zzadaVar, zzagm zzagmVar, int i, Object obj) throws IOException {
        if (zzagmVar != zzagm.GROUP) {
            zzadaVar.zzb(i, zzagmVar.zzb());
            zzagn zzagnVar = zzagn.INT;
            switch (zzagmVar.ordinal()) {
                case 0:
                    zzadaVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case 1:
                    zzadaVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case 2:
                    zzadaVar.zzt(((Long) obj).longValue());
                    return;
                case 3:
                    zzadaVar.zzt(((Long) obj).longValue());
                    return;
                case 4:
                    zzadaVar.zzq(((Integer) obj).intValue());
                    return;
                case 5:
                    zzadaVar.zzu(((Long) obj).longValue());
                    return;
                case 6:
                    zzadaVar.zzs(((Integer) obj).intValue());
                    return;
                case 7:
                    zzadaVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                    return;
                case 8:
                    if (obj instanceof zzacr) {
                        zzadaVar.zzk((zzacr) obj);
                        return;
                    } else {
                        zzadaVar.zzw((String) obj);
                        return;
                    }
                case 9:
                    ((zzafc) obj).zzcH(zzadaVar);
                    return;
                case 10:
                    zzadaVar.zzo((zzafc) obj);
                    return;
                case 11:
                    if (obj instanceof zzacr) {
                        zzadaVar.zzk((zzacr) obj);
                        return;
                    }
                    byte[] bArr = (byte[]) obj;
                    zzadaVar.zzl(bArr, 0, bArr.length);
                    return;
                case 12:
                    zzadaVar.zzr(((Integer) obj).intValue());
                    return;
                case 13:
                    if (obj instanceof zzady) {
                        zzadaVar.zzq(((zzady) obj).zza());
                        return;
                    } else {
                        zzadaVar.zzq(((Integer) obj).intValue());
                        return;
                    }
                case 14:
                    zzadaVar.zzs(((Integer) obj).intValue());
                    return;
                case 15:
                    zzadaVar.zzu(((Long) obj).longValue());
                    return;
                case 16:
                    int intValue = ((Integer) obj).intValue();
                    zzadaVar.zzr((intValue >> 31) ^ (intValue + intValue));
                    return;
                case 17:
                    long longValue = ((Long) obj).longValue();
                    zzadaVar.zzt((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        }
        zzadaVar.zzb(i, 3);
        ((zzafc) obj).zzcH(zzadaVar);
        zzadaVar.zzb(i, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(zzagm zzagmVar, int i, Object obj) {
        int zzE = zzada.zzE(i << 3);
        if (zzagmVar == zzagm.GROUP) {
            zzE += zzE;
        }
        return zzE + zzi(zzagmVar, obj);
    }

    static int zzi(zzagm zzagmVar, Object obj) {
        int zzb;
        int zzE;
        zzagm zzagmVar2 = zzagm.DOUBLE;
        zzagn zzagnVar = zzagn.INT;
        switch (zzagmVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzada.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzada.zzb;
                return 4;
            case 2:
                return zzada.zzF(((Long) obj).longValue());
            case 3:
                return zzada.zzF(((Long) obj).longValue());
            case 4:
                return zzada.zzF(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzada.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzada.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzada.zzb;
                return 1;
            case 8:
                if (obj instanceof zzacr) {
                    int i6 = zzada.zzb;
                    zzb = ((zzacr) obj).zzb();
                    zzE = zzada.zzE(zzb);
                    break;
                } else {
                    int i7 = zzada.zzb;
                    zzb = zzagl.zzb((String) obj);
                    zzE = zzada.zzE(zzb);
                    break;
                }
            case 9:
                return ((zzafc) obj).zzcq();
            case 10:
                if (obj instanceof zzael) {
                    zzb = ((zzael) obj).zzb();
                    zzE = zzada.zzE(zzb);
                    break;
                } else {
                    return zzada.zzG((zzafc) obj);
                }
            case 11:
                if (obj instanceof zzacr) {
                    int i8 = zzada.zzb;
                    zzb = ((zzacr) obj).zzb();
                    zzE = zzada.zzE(zzb);
                    break;
                } else {
                    int i9 = zzada.zzb;
                    zzb = ((byte[]) obj).length;
                    zzE = zzada.zzE(zzb);
                    break;
                }
            case 12:
                return zzada.zzE(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzady) {
                    return zzada.zzF(((zzady) obj).zza());
                }
                return zzada.zzF(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i10 = zzada.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i11 = zzada.zzb;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzada.zzE((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzada.zzF((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzE + zzb;
    }

    public static int zzj(zzadj zzadjVar, Object obj) {
        zzagm zzb = zzadjVar.zzb();
        int zza = zzadjVar.zza();
        if (zzadjVar.zzd()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzadjVar.zze()) {
                int i2 = 0;
                while (i < size) {
                    i2 += zzh(zzb, zza, list.get(i));
                    i++;
                }
                return i2;
            } else if (list.isEmpty()) {
                return 0;
            } else {
                int i3 = 0;
                while (i < size) {
                    i3 += zzi(zzb, list.get(i));
                    i++;
                }
                return zzada.zzE(zza << 3) + i3 + zzada.zzE(i3);
            }
        }
        return zzh(zzb, zza, obj);
    }

    private static boolean zzk(Map.Entry entry) {
        zzadj zzadjVar = (zzadj) entry.getKey();
        if (zzadjVar.zzc() == zzagn.MESSAGE) {
            if (zzadjVar.zzd()) {
                List list = (List) entry.getValue();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (!zzl(list.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return zzl(entry.getValue());
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zzafd) {
            return ((zzafd) obj).zzcJ();
        }
        if (obj instanceof zzael) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int zzE;
        int zzE2;
        zzadj zzadjVar = (zzadj) entry.getKey();
        Object value = entry.getValue();
        if (zzadjVar.zzc() != zzagn.MESSAGE || zzadjVar.zzd() || zzadjVar.zze()) {
            return zzj(zzadjVar, value);
        }
        if (value instanceof zzael) {
            int zza = ((zzadj) entry.getKey()).zza();
            int zzE3 = zzada.zzE(8);
            i = zzE3 + zzE3;
            zzE = zzada.zzE(16) + zzada.zzE(zza);
            int zzE4 = zzada.zzE(24);
            int zzb = ((zzael) value).zzb();
            zzE2 = zzE4 + zzada.zzE(zzb) + zzb;
        } else {
            int zza2 = ((zzadj) entry.getKey()).zza();
            int zzE5 = zzada.zzE(8);
            i = zzE5 + zzE5;
            zzE = zzada.zzE(16) + zzada.zzE(zza2);
            zzE2 = zzada.zzE(24) + zzada.zzG((zzafc) value);
        }
        return i + zzE + zzE2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzn(zzadj zzadjVar, Object obj) {
        boolean z;
        zzagm zzb = zzadjVar.zzb();
        obj.getClass();
        zzagm zzagmVar = zzagm.DOUBLE;
        zzagn zzagnVar = zzagn.INT;
        switch (zzb.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            case 1:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            case 5:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            case 6:
                if ((obj instanceof zzacr) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzady)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof zzafc) || (obj instanceof zzael)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzadjVar.zza()), zzadjVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzadk zzadkVar = new zzadk();
        zzafv zzafvVar = this.zza;
        int zzc = zzafvVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzd2 = zzafvVar.zzd(i);
            zzadkVar.zzd((zzadj) ((zzafs) zzd2).zza(), zzd2.getValue());
        }
        for (Map.Entry entry : zzafvVar.zze()) {
            zzadkVar.zzd((zzadj) entry.getKey(), entry.getValue());
        }
        zzadkVar.zzc = this.zzc;
        return zzadkVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzadk) {
            return this.zza.equals(((zzadk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzafv zzafvVar = this.zza;
        int zzc = zzafvVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzafvVar.zzd(i).getValue();
            if (value instanceof zzadu) {
                ((zzadu) value).zzcm();
            }
        }
        for (Map.Entry entry : zzafvVar.zze()) {
            Object value2 = entry.getValue();
            if (value2 instanceof zzadu) {
                ((zzadu) value2).zzcm();
            }
        }
        zzafvVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzafv zzafvVar = this.zza;
        if (zzafvVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzc) {
            return new zzaek(zzafvVar.entrySet().iterator());
        }
        return zzafvVar.entrySet().iterator();
    }

    public final void zzd(zzadj zzadjVar, Object obj) {
        if (zzadjVar.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzadjVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzn(zzadjVar, obj);
        }
        if (obj instanceof zzael) {
            this.zzc = true;
        }
        this.zza.put(zzadjVar, obj);
    }

    public final boolean zze() {
        zzafv zzafvVar = this.zza;
        int zzc = zzafvVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzk(zzafvVar.zzd(i))) {
                return false;
            }
        }
        for (Map.Entry entry : zzafvVar.zze()) {
            if (!zzk(entry)) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzafv zzafvVar = this.zza;
        int zzc = zzafvVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzm(zzafvVar.zzd(i2));
        }
        for (Map.Entry entry : zzafvVar.zze()) {
            i += zzm(entry);
        }
        return i;
    }

    private zzadk(boolean z) {
        zzb();
        zzb();
    }
}
