package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
final class zzlv {
    private static final zzlv zzd = new zzlv(true);
    final zzod zza = new zznz();
    private boolean zzb;
    private boolean zzc;

    private zzlv() {
    }

    public static zzlv zza() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzf(zzll zzllVar, zzos zzosVar, int i, Object obj) throws IOException {
        if (zzosVar != zzos.GROUP) {
            zzllVar.zza(i, zzosVar.zzb());
            zzot zzotVar = zzot.INT;
            switch (zzosVar.ordinal()) {
                case 0:
                    zzllVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case 1:
                    zzllVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case 2:
                    zzllVar.zzt(((Long) obj).longValue());
                    return;
                case 3:
                    zzllVar.zzt(((Long) obj).longValue());
                    return;
                case 4:
                    zzllVar.zzq(((Integer) obj).intValue());
                    return;
                case 5:
                    zzllVar.zzu(((Long) obj).longValue());
                    return;
                case 6:
                    zzllVar.zzs(((Integer) obj).intValue());
                    return;
                case 7:
                    zzllVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                    return;
                case 8:
                    if (obj instanceof zzlg) {
                        zzllVar.zzj((zzlg) obj);
                        return;
                    } else {
                        zzllVar.zzx((String) obj);
                        return;
                    }
                case 9:
                    ((zznl) obj).zzcB(zzllVar);
                    return;
                case 10:
                    zzllVar.zzo((zznl) obj);
                    return;
                case 11:
                    if (obj instanceof zzlg) {
                        zzllVar.zzj((zzlg) obj);
                        return;
                    }
                    byte[] bArr = (byte[]) obj;
                    zzllVar.zzk(bArr, 0, bArr.length);
                    return;
                case 12:
                    zzllVar.zzr(((Integer) obj).intValue());
                    return;
                case 13:
                    if (obj instanceof zzmi) {
                        zzllVar.zzq(((zzmi) obj).zza());
                        return;
                    } else {
                        zzllVar.zzq(((Integer) obj).intValue());
                        return;
                    }
                case 14:
                    zzllVar.zzs(((Integer) obj).intValue());
                    return;
                case 15:
                    zzllVar.zzu(((Long) obj).longValue());
                    return;
                case 16:
                    int intValue = ((Integer) obj).intValue();
                    zzllVar.zzr((intValue >> 31) ^ (intValue + intValue));
                    return;
                case 17:
                    long longValue = ((Long) obj).longValue();
                    zzllVar.zzt((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        }
        zznl zznlVar = (zznl) obj;
        zzmo.zzd(zznlVar);
        zzllVar.zza(i, 3);
        zznlVar.zzcB(zzllVar);
        zzllVar.zza(i, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(zzos zzosVar, int i, Object obj) {
        int zzz = zzll.zzz(i << 3);
        if (zzosVar == zzos.GROUP) {
            zzmo.zzd((zznl) obj);
            zzz += zzz;
        }
        return zzz + zzi(zzosVar, obj);
    }

    static int zzi(zzos zzosVar, Object obj) {
        int zzc;
        int zzz;
        zzos zzosVar2 = zzos.DOUBLE;
        zzot zzotVar = zzot.INT;
        switch (zzosVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzll.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzll.zzb;
                return 4;
            case 2:
                return zzll.zzA(((Long) obj).longValue());
            case 3:
                return zzll.zzA(((Long) obj).longValue());
            case 4:
                return zzll.zzA(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzll.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzll.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzll.zzb;
                return 1;
            case 8:
                if (obj instanceof zzlg) {
                    int i6 = zzll.zzb;
                    zzc = ((zzlg) obj).zzc();
                    zzz = zzll.zzz(zzc);
                    break;
                } else {
                    return zzll.zzB((String) obj);
                }
            case 9:
                return ((zznl) obj).zzcn();
            case 10:
                if (obj instanceof zzmu) {
                    int i7 = zzll.zzb;
                    zzc = ((zzmu) obj).zzb();
                    zzz = zzll.zzz(zzc);
                    break;
                } else {
                    return zzll.zzC((zznl) obj);
                }
            case 11:
                if (obj instanceof zzlg) {
                    int i8 = zzll.zzb;
                    zzc = ((zzlg) obj).zzc();
                    zzz = zzll.zzz(zzc);
                    break;
                } else {
                    int i9 = zzll.zzb;
                    zzc = ((byte[]) obj).length;
                    zzz = zzll.zzz(zzc);
                    break;
                }
            case 12:
                return zzll.zzz(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzmi) {
                    return zzll.zzA(((zzmi) obj).zza());
                }
                return zzll.zzA(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i10 = zzll.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i11 = zzll.zzb;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzll.zzz((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzll.zzA((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzz + zzc;
    }

    public static int zzj(zzlu zzluVar, Object obj) {
        zzos zzb = zzluVar.zzb();
        int zza = zzluVar.zza();
        if (zzluVar.zzd()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzluVar.zze()) {
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
                return zzll.zzz(zza << 3) + i3 + zzll.zzz(i3);
            }
        }
        return zzh(zzb, zza, obj);
    }

    private static boolean zzk(Map.Entry entry) {
        zzlu zzluVar = (zzlu) entry.getKey();
        if (zzluVar.zzc() == zzot.MESSAGE) {
            if (zzluVar.zzd()) {
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
        if (obj instanceof zznm) {
            return ((zznm) obj).zzcD();
        }
        if (obj instanceof zzmu) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int zzz;
        int zzz2;
        zzlu zzluVar = (zzlu) entry.getKey();
        Object value = entry.getValue();
        if (zzluVar.zzc() != zzot.MESSAGE || zzluVar.zzd() || zzluVar.zze()) {
            return zzj(zzluVar, value);
        }
        if (value instanceof zzmu) {
            int zza = ((zzlu) entry.getKey()).zza();
            int zzz3 = zzll.zzz(8);
            i = zzz3 + zzz3;
            zzz = zzll.zzz(16) + zzll.zzz(zza);
            int zzz4 = zzll.zzz(24);
            int zzb = ((zzmu) value).zzb();
            zzz2 = zzz4 + zzll.zzz(zzb) + zzb;
        } else {
            int zza2 = ((zzlu) entry.getKey()).zza();
            int zzz5 = zzll.zzz(8);
            i = zzz5 + zzz5;
            zzz = zzll.zzz(16) + zzll.zzz(zza2);
            zzz2 = zzll.zzz(24) + zzll.zzC((zznl) value);
        }
        return i + zzz + zzz2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzn(zzlu zzluVar, Object obj) {
        boolean z;
        zzos zzb = zzluVar.zzb();
        byte[] bArr = zzmo.zzb;
        obj.getClass();
        zzos zzosVar = zzos.DOUBLE;
        zzot zzotVar = zzot.INT;
        switch (zzb.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case 1:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case 5:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case 6:
                if ((obj instanceof zzlg) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzmi)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof zznl) || (obj instanceof zzmu)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzluVar.zza()), zzluVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzlv zzlvVar = new zzlv();
        zzod zzodVar = this.zza;
        int zzc = zzodVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzd2 = zzodVar.zzd(i);
            zzlvVar.zzd((zzlu) ((zzoa) zzd2).zza(), zzd2.getValue());
        }
        for (Map.Entry entry : zzodVar.zze()) {
            zzlvVar.zzd((zzlu) entry.getKey(), entry.getValue());
        }
        zzlvVar.zzc = this.zzc;
        return zzlvVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlv) {
            return this.zza.equals(((zzlv) obj).zza);
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
        zzod zzodVar = this.zza;
        int zzc = zzodVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzodVar.zzd(i).getValue();
            if (value instanceof zzme) {
                ((zzme) value).zzcj();
            }
        }
        for (Map.Entry entry : zzodVar.zze()) {
            Object value2 = entry.getValue();
            if (value2 instanceof zzme) {
                ((zzme) value2).zzcj();
            }
        }
        zzodVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzod zzodVar = this.zza;
        if (zzodVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzc) {
            return new zzmt(zzodVar.entrySet().iterator());
        }
        return zzodVar.entrySet().iterator();
    }

    public final void zzd(zzlu zzluVar, Object obj) {
        if (zzluVar.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzluVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzn(zzluVar, obj);
        }
        if (obj instanceof zzmu) {
            this.zzc = true;
        }
        this.zza.put(zzluVar, obj);
    }

    public final boolean zze() {
        zzod zzodVar = this.zza;
        int zzc = zzodVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzk(zzodVar.zzd(i))) {
                return false;
            }
        }
        for (Map.Entry entry : zzodVar.zze()) {
            if (!zzk(entry)) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzod zzodVar = this.zza;
        int zzc = zzodVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzm(zzodVar.zzd(i2));
        }
        for (Map.Entry entry : zzodVar.zze()) {
            i += zzm(entry);
        }
        return i;
    }

    private zzlv(boolean z) {
        zzb();
        zzb();
    }
}
