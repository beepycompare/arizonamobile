package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes4.dex */
final class zzlw {
    private static final zzlw zzd = new zzlw(true);
    final zzoe zza = new zzoa();
    private boolean zzb;
    private boolean zzc;

    private zzlw() {
    }

    public static zzlw zza() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzf(zzlm zzlmVar, zzot zzotVar, int i, Object obj) throws IOException {
        if (zzotVar != zzot.GROUP) {
            zzlmVar.zza(i, zzotVar.zzb());
            zzou zzouVar = zzou.INT;
            switch (zzotVar.ordinal()) {
                case 0:
                    zzlmVar.zzu(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case 1:
                    zzlmVar.zzs(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case 2:
                    zzlmVar.zzt(((Long) obj).longValue());
                    return;
                case 3:
                    zzlmVar.zzt(((Long) obj).longValue());
                    return;
                case 4:
                    zzlmVar.zzq(((Integer) obj).intValue());
                    return;
                case 5:
                    zzlmVar.zzu(((Long) obj).longValue());
                    return;
                case 6:
                    zzlmVar.zzs(((Integer) obj).intValue());
                    return;
                case 7:
                    zzlmVar.zzp(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                    return;
                case 8:
                    if (obj instanceof zzlh) {
                        zzlmVar.zzj((zzlh) obj);
                        return;
                    } else {
                        zzlmVar.zzx((String) obj);
                        return;
                    }
                case 9:
                    ((zznm) obj).zzcB(zzlmVar);
                    return;
                case 10:
                    zzlmVar.zzo((zznm) obj);
                    return;
                case 11:
                    if (obj instanceof zzlh) {
                        zzlmVar.zzj((zzlh) obj);
                        return;
                    }
                    byte[] bArr = (byte[]) obj;
                    zzlmVar.zzk(bArr, 0, bArr.length);
                    return;
                case 12:
                    zzlmVar.zzr(((Integer) obj).intValue());
                    return;
                case 13:
                    if (obj instanceof zzmj) {
                        zzlmVar.zzq(((zzmj) obj).zza());
                        return;
                    } else {
                        zzlmVar.zzq(((Integer) obj).intValue());
                        return;
                    }
                case 14:
                    zzlmVar.zzs(((Integer) obj).intValue());
                    return;
                case 15:
                    zzlmVar.zzu(((Long) obj).longValue());
                    return;
                case 16:
                    int intValue = ((Integer) obj).intValue();
                    zzlmVar.zzr((intValue >> 31) ^ (intValue + intValue));
                    return;
                case 17:
                    long longValue = ((Long) obj).longValue();
                    zzlmVar.zzt((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        }
        zznm zznmVar = (zznm) obj;
        zzmp.zzd(zznmVar);
        zzlmVar.zza(i, 3);
        zznmVar.zzcB(zzlmVar);
        zzlmVar.zza(i, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(zzot zzotVar, int i, Object obj) {
        int zzz = zzlm.zzz(i << 3);
        if (zzotVar == zzot.GROUP) {
            zzmp.zzd((zznm) obj);
            zzz += zzz;
        }
        return zzz + zzi(zzotVar, obj);
    }

    static int zzi(zzot zzotVar, Object obj) {
        int zzc;
        int zzz;
        zzot zzotVar2 = zzot.DOUBLE;
        zzou zzouVar = zzou.INT;
        switch (zzotVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzlm.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzlm.zzb;
                return 4;
            case 2:
                return zzlm.zzA(((Long) obj).longValue());
            case 3:
                return zzlm.zzA(((Long) obj).longValue());
            case 4:
                return zzlm.zzA(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzlm.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzlm.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzlm.zzb;
                return 1;
            case 8:
                if (obj instanceof zzlh) {
                    int i6 = zzlm.zzb;
                    zzc = ((zzlh) obj).zzc();
                    zzz = zzlm.zzz(zzc);
                    break;
                } else {
                    return zzlm.zzB((String) obj);
                }
            case 9:
                return ((zznm) obj).zzcn();
            case 10:
                if (obj instanceof zzmv) {
                    int i7 = zzlm.zzb;
                    zzc = ((zzmv) obj).zzb();
                    zzz = zzlm.zzz(zzc);
                    break;
                } else {
                    return zzlm.zzC((zznm) obj);
                }
            case 11:
                if (obj instanceof zzlh) {
                    int i8 = zzlm.zzb;
                    zzc = ((zzlh) obj).zzc();
                    zzz = zzlm.zzz(zzc);
                    break;
                } else {
                    int i9 = zzlm.zzb;
                    zzc = ((byte[]) obj).length;
                    zzz = zzlm.zzz(zzc);
                    break;
                }
            case 12:
                return zzlm.zzz(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzmj) {
                    return zzlm.zzA(((zzmj) obj).zza());
                }
                return zzlm.zzA(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i10 = zzlm.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i11 = zzlm.zzb;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzlm.zzz((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzlm.zzA((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzz + zzc;
    }

    public static int zzj(zzlv zzlvVar, Object obj) {
        zzot zzb = zzlvVar.zzb();
        int zza = zzlvVar.zza();
        if (zzlvVar.zzd()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzlvVar.zze()) {
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
                return zzlm.zzz(zza << 3) + i3 + zzlm.zzz(i3);
            }
        }
        return zzh(zzb, zza, obj);
    }

    private static boolean zzk(Map.Entry entry) {
        zzlv zzlvVar = (zzlv) entry.getKey();
        if (zzlvVar.zzc() == zzou.MESSAGE) {
            if (zzlvVar.zzd()) {
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
        if (obj instanceof zznn) {
            return ((zznn) obj).zzcD();
        }
        if (obj instanceof zzmv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int zzz;
        int zzz2;
        zzlv zzlvVar = (zzlv) entry.getKey();
        Object value = entry.getValue();
        if (zzlvVar.zzc() != zzou.MESSAGE || zzlvVar.zzd() || zzlvVar.zze()) {
            return zzj(zzlvVar, value);
        }
        if (value instanceof zzmv) {
            int zza = ((zzlv) entry.getKey()).zza();
            int zzz3 = zzlm.zzz(8);
            i = zzz3 + zzz3;
            zzz = zzlm.zzz(16) + zzlm.zzz(zza);
            int zzz4 = zzlm.zzz(24);
            int zzb = ((zzmv) value).zzb();
            zzz2 = zzz4 + zzlm.zzz(zzb) + zzb;
        } else {
            int zza2 = ((zzlv) entry.getKey()).zza();
            int zzz5 = zzlm.zzz(8);
            i = zzz5 + zzz5;
            zzz = zzlm.zzz(16) + zzlm.zzz(zza2);
            zzz2 = zzlm.zzz(24) + zzlm.zzC((zznm) value);
        }
        return i + zzz + zzz2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzn(zzlv zzlvVar, Object obj) {
        boolean z;
        zzot zzb = zzlvVar.zzb();
        byte[] bArr = zzmp.zzb;
        obj.getClass();
        zzot zzotVar = zzot.DOUBLE;
        zzou zzouVar = zzou.INT;
        switch (zzb.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            case 1:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            case 5:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            case 6:
                if ((obj instanceof zzlh) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzmj)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof zznm) || (obj instanceof zzmv)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzlvVar.zza()), zzlvVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzlw zzlwVar = new zzlw();
        zzoe zzoeVar = this.zza;
        int zzc = zzoeVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzd2 = zzoeVar.zzd(i);
            zzlwVar.zzd((zzlv) ((zzob) zzd2).zza(), zzd2.getValue());
        }
        for (Map.Entry entry : zzoeVar.zze()) {
            zzlwVar.zzd((zzlv) entry.getKey(), entry.getValue());
        }
        zzlwVar.zzc = this.zzc;
        return zzlwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlw) {
            return this.zza.equals(((zzlw) obj).zza);
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
        zzoe zzoeVar = this.zza;
        int zzc = zzoeVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzoeVar.zzd(i).getValue();
            if (value instanceof zzmf) {
                ((zzmf) value).zzcj();
            }
        }
        for (Map.Entry entry : zzoeVar.zze()) {
            Object value2 = entry.getValue();
            if (value2 instanceof zzmf) {
                ((zzmf) value2).zzcj();
            }
        }
        zzoeVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzoe zzoeVar = this.zza;
        if (zzoeVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzc) {
            return new zzmu(zzoeVar.entrySet().iterator());
        }
        return zzoeVar.entrySet().iterator();
    }

    public final void zzd(zzlv zzlvVar, Object obj) {
        if (zzlvVar.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzlvVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzn(zzlvVar, obj);
        }
        if (obj instanceof zzmv) {
            this.zzc = true;
        }
        this.zza.put(zzlvVar, obj);
    }

    public final boolean zze() {
        zzoe zzoeVar = this.zza;
        int zzc = zzoeVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzk(zzoeVar.zzd(i))) {
                return false;
            }
        }
        for (Map.Entry entry : zzoeVar.zze()) {
            if (!zzk(entry)) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzoe zzoeVar = this.zza;
        int zzc = zzoeVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzm(zzoeVar.zzd(i2));
        }
        for (Map.Entry entry : zzoeVar.zze()) {
            i += zzm(entry);
        }
        return i;
    }

    private zzlw(boolean z) {
        zzb();
        zzb();
    }
}
