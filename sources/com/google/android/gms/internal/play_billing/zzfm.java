package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
final class zzfm {
    private static final zzfm zzd = new zzfm(true);
    final zzht zza = new zzho();
    boolean zzb;
    boolean zzc;

    private zzfm() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzir zzirVar, int i, Object obj) {
        int zzy = zzfc.zzy(i << 3);
        if (zzirVar == zzir.GROUP) {
            zzy += zzy;
        }
        return zzy + zzb(zzirVar, obj);
    }

    static int zzb(zzir zzirVar, Object obj) {
        int zzb;
        int zzy;
        zzir zzirVar2 = zzir.DOUBLE;
        zzis zzisVar = zzis.INT;
        switch (zzirVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzfc.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzfc.zzb;
                return 4;
            case 2:
                return zzfc.zzz(((Long) obj).longValue());
            case 3:
                return zzfc.zzz(((Long) obj).longValue());
            case 4:
                return zzfc.zzz(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzfc.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzfc.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzfc.zzb;
                return 1;
            case 8:
                if (obj instanceof zzev) {
                    int i6 = zzfc.zzb;
                    zzb = ((zzev) obj).zze();
                    zzy = zzfc.zzy(zzb);
                    break;
                } else {
                    int i7 = zzfc.zzb;
                    zzb = zzin.zzb((String) obj);
                    zzy = zzfc.zzy(zzb);
                    break;
                }
            case 9:
                return ((zzhb) obj).zzn();
            case 10:
                if (obj instanceof zzgh) {
                    zzb = ((zzgh) obj).zza();
                    zzy = zzfc.zzy(zzb);
                    break;
                } else {
                    return zzfc.zzx((zzhb) obj);
                }
            case 11:
                if (obj instanceof zzev) {
                    int i8 = zzfc.zzb;
                    zzb = ((zzev) obj).zze();
                    zzy = zzfc.zzy(zzb);
                    break;
                } else {
                    int i9 = zzfc.zzb;
                    zzb = ((byte[]) obj).length;
                    zzy = zzfc.zzy(zzb);
                    break;
                }
            case 12:
                return zzfc.zzy(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzfw) {
                    return zzfc.zzz(((zzfw) obj).zza());
                }
                return zzfc.zzz(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i10 = zzfc.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i11 = zzfc.zzb;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzfc.zzy((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzfc.zzz((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzy + zzb;
    }

    public static int zzc(zzfl zzflVar, Object obj) {
        zzir zzb = zzflVar.zzb();
        int zza = zzflVar.zza();
        if (zzflVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i = 0;
            if (!zzflVar.zzd()) {
                int i2 = 0;
                while (i < size) {
                    i2 += zza(zzb, zza, list.get(i));
                    i++;
                }
                return i2;
            } else if (list.isEmpty()) {
                return 0;
            } else {
                int i3 = 0;
                while (i < size) {
                    i3 += zzb(zzb, list.get(i));
                    i++;
                }
                return zzfc.zzy(zza << 3) + i3 + zzfc.zzy(i3);
            }
        }
        return zza(zzb, zza, obj);
    }

    public static zzfm zze() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzi(zzfc zzfcVar, zzir zzirVar, int i, Object obj) throws IOException {
        if (zzirVar != zzir.GROUP) {
            zzfcVar.zzs(i, zzirVar.zza());
            zzis zzisVar = zzis.INT;
            switch (zzirVar.ordinal()) {
                case 0:
                    zzfcVar.zzk(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                    return;
                case 1:
                    zzfcVar.zzi(Float.floatToRawIntBits(((Float) obj).floatValue()));
                    return;
                case 2:
                    zzfcVar.zzw(((Long) obj).longValue());
                    return;
                case 3:
                    zzfcVar.zzw(((Long) obj).longValue());
                    return;
                case 4:
                    zzfcVar.zzm(((Integer) obj).intValue());
                    return;
                case 5:
                    zzfcVar.zzk(((Long) obj).longValue());
                    return;
                case 6:
                    zzfcVar.zzi(((Integer) obj).intValue());
                    return;
                case 7:
                    zzfcVar.zzb(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                    return;
                case 8:
                    if (obj instanceof zzev) {
                        zzfcVar.zzg((zzev) obj);
                        return;
                    } else {
                        zzfcVar.zzr((String) obj);
                        return;
                    }
                case 9:
                    ((zzhb) obj).zzD(zzfcVar);
                    return;
                case 10:
                    zzfcVar.zzn((zzhb) obj);
                    return;
                case 11:
                    if (obj instanceof zzev) {
                        zzfcVar.zzg((zzev) obj);
                        return;
                    }
                    byte[] bArr = (byte[]) obj;
                    zzfcVar.zze(bArr, 0, bArr.length);
                    return;
                case 12:
                    zzfcVar.zzu(((Integer) obj).intValue());
                    return;
                case 13:
                    if (obj instanceof zzfw) {
                        zzfcVar.zzm(((zzfw) obj).zza());
                        return;
                    } else {
                        zzfcVar.zzm(((Integer) obj).intValue());
                        return;
                    }
                case 14:
                    zzfcVar.zzi(((Integer) obj).intValue());
                    return;
                case 15:
                    zzfcVar.zzk(((Long) obj).longValue());
                    return;
                case 16:
                    int intValue = ((Integer) obj).intValue();
                    zzfcVar.zzu((intValue >> 31) ^ (intValue + intValue));
                    return;
                case 17:
                    long longValue = ((Long) obj).longValue();
                    zzfcVar.zzw((longValue >> 63) ^ (longValue + longValue));
                    return;
                default:
                    return;
            }
        }
        zzfcVar.zzs(i, 3);
        ((zzhb) obj).zzD(zzfcVar);
        zzfcVar.zzs(i, 4);
    }

    private static boolean zzk(Map.Entry entry) {
        zzfl zzflVar = (zzfl) entry.getKey();
        if (zzflVar.zzc() == zzis.MESSAGE) {
            if (zzflVar.zze()) {
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
        if (obj instanceof zzhc) {
            return ((zzhc) obj).zzo();
        }
        if (obj instanceof zzgh) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int zzy;
        int zzy2;
        zzfl zzflVar = (zzfl) entry.getKey();
        Object value = entry.getValue();
        if (zzflVar.zzc() != zzis.MESSAGE || zzflVar.zze() || zzflVar.zzd()) {
            return zzc(zzflVar, value);
        }
        if (value instanceof zzgh) {
            int zza = ((zzfl) entry.getKey()).zza();
            int zzy3 = zzfc.zzy(8);
            i = zzy3 + zzy3;
            zzy = zzfc.zzy(16) + zzfc.zzy(zza);
            int zzy4 = zzfc.zzy(24);
            int zza2 = ((zzgh) value).zza();
            zzy2 = zzy4 + zzfc.zzy(zza2) + zza2;
        } else {
            int zza3 = ((zzfl) entry.getKey()).zza();
            int zzy5 = zzfc.zzy(8);
            i = zzy5 + zzy5;
            zzy = zzfc.zzy(16) + zzfc.zzy(zza3);
            zzy2 = zzfc.zzy(24) + zzfc.zzx((zzhb) value);
        }
        return i + zzy + zzy2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void zzn(zzfl zzflVar, Object obj) {
        boolean z;
        zzir zzb = zzflVar.zzb();
        byte[] bArr = zzga.zzb;
        obj.getClass();
        zzir zzirVar = zzir.DOUBLE;
        zzis zzisVar = zzis.INT;
        switch (zzb.zzb().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            case 1:
                z = obj instanceof Long;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Float;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Double;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Boolean;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            case 5:
                z = obj instanceof String;
                if (z) {
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            case 6:
                if ((obj instanceof zzev) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzfw)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof zzhb) || (obj instanceof zzgh)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzflVar.zza()), zzflVar.zzb().zzb(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfm zzfmVar = new zzfm();
        zzht zzhtVar = this.zza;
        int zzc = zzhtVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Map.Entry zzg = zzhtVar.zzg(i);
            zzfmVar.zzh((zzfl) ((zzhp) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : zzhtVar.zzd()) {
            zzfmVar.zzh((zzfl) entry.getKey(), entry.getValue());
        }
        zzfmVar.zzc = this.zzc;
        return zzfmVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfm) {
            return this.zza.equals(((zzfm) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzht zzhtVar = this.zza;
        int zzc = zzhtVar.zzc();
        int i = 0;
        for (int i2 = 0; i2 < zzc; i2++) {
            i += zzm(zzhtVar.zzg(i2));
        }
        for (Map.Entry entry : zzhtVar.zzd()) {
            i += zzm(entry);
        }
        return i;
    }

    public final Iterator zzf() {
        zzht zzhtVar = this.zza;
        if (zzhtVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzc) {
            return new zzgf(zzhtVar.entrySet().iterator());
        }
        return zzhtVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzb) {
            return;
        }
        zzht zzhtVar = this.zza;
        int zzc = zzhtVar.zzc();
        for (int i = 0; i < zzc; i++) {
            Object value = zzhtVar.zzg(i).getValue();
            if (value instanceof zzfu) {
                ((zzfu) value).zzz();
            }
        }
        for (Map.Entry entry : zzhtVar.zzd()) {
            Object value2 = entry.getValue();
            if (value2 instanceof zzfu) {
                ((zzfu) value2).zzz();
            }
        }
        zzhtVar.zza();
        this.zzb = true;
    }

    public final void zzh(zzfl zzflVar, Object obj) {
        if (zzflVar.zze()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzflVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        } else {
            zzn(zzflVar, obj);
        }
        if (obj instanceof zzgh) {
            this.zzc = true;
        }
        this.zza.put(zzflVar, obj);
    }

    public final boolean zzj() {
        zzht zzhtVar = this.zza;
        int zzc = zzhtVar.zzc();
        for (int i = 0; i < zzc; i++) {
            if (!zzk(zzhtVar.zzg(i))) {
                return false;
            }
        }
        for (Map.Entry entry : zzhtVar.zzd()) {
            if (!zzk(entry)) {
                return false;
            }
        }
        return true;
    }

    private zzfm(boolean z) {
        zzg();
        zzg();
    }
}
