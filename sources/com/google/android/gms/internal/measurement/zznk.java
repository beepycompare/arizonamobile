package com.google.android.gms.internal.measurement;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes3.dex */
public final class zznk<T> implements zzns<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzol.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznh zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoe zzl;
    private final zzlq zzm;

    private zznk(int[] iArr, Object[] objArr, int i, int i2, zznh zznhVar, boolean z, int[] iArr2, int i3, int i4, zznm zznmVar, zzmu zzmuVar, zzoe zzoeVar, zzlq zzlqVar, zznc zzncVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzlqVar != null && (zznhVar instanceof zzma)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzoeVar;
        this.zzm = zzlqVar;
        this.zzg = zznhVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzs = zzs(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzs);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzns zzv = zzv(i);
            if (!zzI(obj, i)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, zzs, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, zzs, zze);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzs);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, zzs, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzs = zzs(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzs);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzns zzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, zzs, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, zzs, zze);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzs);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, zzs, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int zzp = zzp(i);
        long j = 1048575 & zzp;
        if (j == 1048575) {
            return;
        }
        zzol.zzq(obj, j, (1 << (zzp >>> 20)) | zzol.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzol.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int zzp = zzp(i);
        long j = zzp & 1048575;
        if (j != 1048575) {
            return (zzol.zzc(obj, j) & (1 << (zzp >>> 20))) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzol.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzol.zzb(obj, j2)) != 0;
            case 2:
                return zzol.zzd(obj, j2) != 0;
            case 3:
                return zzol.zzd(obj, j2) != 0;
            case 4:
                return zzol.zzc(obj, j2) != 0;
            case 5:
                return zzol.zzd(obj, j2) != 0;
            case 6:
                return zzol.zzc(obj, j2) != 0;
            case 7:
                return zzol.zzw(obj, j2);
            case 8:
                Object zzf = zzol.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                } else if (zzf instanceof zzld) {
                    return !zzld.zzb.equals(zzf);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzol.zzf(obj, j2) != null;
            case 10:
                return !zzld.zzb.equals(zzol.zzf(obj, j2));
            case 11:
                return zzol.zzc(obj, j2) != 0;
            case 12:
                return zzol.zzc(obj, j2) != 0;
            case 13:
                return zzol.zzc(obj, j2) != 0;
            case 14:
                return zzol.zzd(obj, j2) != 0;
            case 15:
                return zzol.zzc(obj, j2) != 0;
            case 16:
                return zzol.zzd(obj, j2) != 0;
            case 17:
                return zzol.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzns zznsVar) {
        return zznsVar.zzk(zzol.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzmd) {
            return ((zzmd) obj).zzcw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzol.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzol.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzor zzorVar) throws IOException {
        if (obj instanceof String) {
            zzorVar.zzG(i, (String) obj);
        } else {
            zzorVar.zzd(i, (zzld) obj);
        }
    }

    static zzof zzd(Object obj) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVar = zzmdVar.zzc;
        if (zzofVar == zzof.zzc()) {
            zzof zzf = zzof.zzf();
            zzmdVar.zzc = zzf;
            return zzf;
        }
        return zzofVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zznk zzl(Class cls, zzne zzneVar, zznm zznmVar, zzmu zzmuVar, zzoe zzoeVar, zzlq zzlqVar, zznc zzncVar) {
        int i;
        int charAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char charAt2;
        int i9;
        char charAt3;
        int i10;
        char charAt4;
        int i11;
        char charAt5;
        int i12;
        char charAt6;
        int i13;
        char charAt7;
        int i14;
        char charAt8;
        int i15;
        char charAt9;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        String str;
        int objectFieldOffset;
        char c;
        int i21;
        int i22;
        int i23;
        int i24;
        Field zzz;
        char charAt10;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Object obj;
        Field zzz2;
        Object obj2;
        Field zzz3;
        int i30;
        char charAt11;
        int i31;
        char charAt12;
        int i32;
        char charAt13;
        int i33;
        char charAt14;
        if (zzneVar instanceof zznr) {
            zznr zznrVar = (zznr) zzneVar;
            String zzd = zznrVar.zzd();
            int length = zzd.length();
            char c2 = 55296;
            if (zzd.charAt(0) >= 55296) {
                int i34 = 1;
                while (true) {
                    i = i34 + 1;
                    if (zzd.charAt(i34) < 55296) {
                        break;
                    }
                    i34 = i;
                }
            } else {
                i = 1;
            }
            int i35 = i + 1;
            int charAt15 = zzd.charAt(i);
            if (charAt15 >= 55296) {
                int i36 = charAt15 & 8191;
                int i37 = 13;
                while (true) {
                    i33 = i35 + 1;
                    charAt14 = zzd.charAt(i35);
                    if (charAt14 < 55296) {
                        break;
                    }
                    i36 |= (charAt14 & 8191) << i37;
                    i37 += 13;
                    i35 = i33;
                }
                charAt15 = i36 | (charAt14 << i37);
                i35 = i33;
            }
            if (charAt15 == 0) {
                i3 = 0;
                i6 = 0;
                charAt = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                iArr = zza;
                i7 = 0;
            } else {
                int i38 = i35 + 1;
                int charAt16 = zzd.charAt(i35);
                if (charAt16 >= 55296) {
                    int i39 = charAt16 & 8191;
                    int i40 = 13;
                    while (true) {
                        i15 = i38 + 1;
                        charAt9 = zzd.charAt(i38);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i39 |= (charAt9 & 8191) << i40;
                        i40 += 13;
                        i38 = i15;
                    }
                    charAt16 = i39 | (charAt9 << i40);
                    i38 = i15;
                }
                int i41 = i38 + 1;
                int charAt17 = zzd.charAt(i38);
                if (charAt17 >= 55296) {
                    int i42 = charAt17 & 8191;
                    int i43 = 13;
                    while (true) {
                        i14 = i41 + 1;
                        charAt8 = zzd.charAt(i41);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i42 |= (charAt8 & 8191) << i43;
                        i43 += 13;
                        i41 = i14;
                    }
                    charAt17 = i42 | (charAt8 << i43);
                    i41 = i14;
                }
                int i44 = i41 + 1;
                int charAt18 = zzd.charAt(i41);
                if (charAt18 >= 55296) {
                    int i45 = charAt18 & 8191;
                    int i46 = 13;
                    while (true) {
                        i13 = i44 + 1;
                        charAt7 = zzd.charAt(i44);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i45 |= (charAt7 & 8191) << i46;
                        i46 += 13;
                        i44 = i13;
                    }
                    charAt18 = i45 | (charAt7 << i46);
                    i44 = i13;
                }
                int i47 = i44 + 1;
                int charAt19 = zzd.charAt(i44);
                if (charAt19 >= 55296) {
                    int i48 = charAt19 & 8191;
                    int i49 = 13;
                    while (true) {
                        i12 = i47 + 1;
                        charAt6 = zzd.charAt(i47);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i48 |= (charAt6 & 8191) << i49;
                        i49 += 13;
                        i47 = i12;
                    }
                    charAt19 = i48 | (charAt6 << i49);
                    i47 = i12;
                }
                int i50 = i47 + 1;
                charAt = zzd.charAt(i47);
                if (charAt >= 55296) {
                    int i51 = charAt & 8191;
                    int i52 = 13;
                    while (true) {
                        i11 = i50 + 1;
                        charAt5 = zzd.charAt(i50);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i51 |= (charAt5 & 8191) << i52;
                        i52 += 13;
                        i50 = i11;
                    }
                    charAt = i51 | (charAt5 << i52);
                    i50 = i11;
                }
                int i53 = i50 + 1;
                int charAt20 = zzd.charAt(i50);
                if (charAt20 >= 55296) {
                    int i54 = charAt20 & 8191;
                    int i55 = 13;
                    while (true) {
                        i10 = i53 + 1;
                        charAt4 = zzd.charAt(i53);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i54 |= (charAt4 & 8191) << i55;
                        i55 += 13;
                        i53 = i10;
                    }
                    charAt20 = i54 | (charAt4 << i55);
                    i53 = i10;
                }
                int i56 = i53 + 1;
                int charAt21 = zzd.charAt(i53);
                if (charAt21 >= 55296) {
                    int i57 = charAt21 & 8191;
                    int i58 = 13;
                    while (true) {
                        i9 = i56 + 1;
                        charAt3 = zzd.charAt(i56);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i57 |= (charAt3 & 8191) << i58;
                        i58 += 13;
                        i56 = i9;
                    }
                    charAt21 = i57 | (charAt3 << i58);
                    i56 = i9;
                }
                int i59 = i56 + 1;
                int charAt22 = zzd.charAt(i56);
                if (charAt22 >= 55296) {
                    int i60 = charAt22 & 8191;
                    int i61 = 13;
                    while (true) {
                        i8 = i59 + 1;
                        charAt2 = zzd.charAt(i59);
                        if (charAt2 < 55296) {
                            break;
                        }
                        i60 |= (charAt2 & 8191) << i61;
                        i61 += 13;
                        i59 = i8;
                    }
                    charAt22 = i60 | (charAt2 << i61);
                    i59 = i8;
                }
                int i62 = charAt16 + charAt16 + charAt17;
                int[] iArr2 = new int[charAt22 + charAt20 + charAt21];
                int i63 = charAt20;
                i2 = charAt18;
                i3 = i63;
                i4 = charAt19;
                i5 = charAt22;
                i6 = i62;
                iArr = iArr2;
                i7 = charAt16;
                i35 = i59;
            }
            Unsafe unsafe = zzb;
            Object[] zze = zznrVar.zze();
            Class<?> cls2 = zznrVar.zza().getClass();
            int i64 = i5 + i3;
            int i65 = charAt + charAt;
            int[] iArr3 = new int[charAt * 3];
            Object[] objArr = new Object[i65];
            int i66 = i5;
            int i67 = i64;
            int i68 = 0;
            int i69 = 0;
            while (i35 < length) {
                int i70 = i35 + 1;
                int charAt23 = zzd.charAt(i35);
                if (charAt23 >= c2) {
                    int i71 = charAt23 & 8191;
                    int i72 = i70;
                    int i73 = 13;
                    while (true) {
                        i32 = i72 + 1;
                        charAt13 = zzd.charAt(i72);
                        if (charAt13 < c2) {
                            break;
                        }
                        i71 |= (charAt13 & 8191) << i73;
                        i73 += 13;
                        i72 = i32;
                    }
                    charAt23 = i71 | (charAt13 << i73);
                    i16 = i32;
                } else {
                    i16 = i70;
                }
                int i74 = i16 + 1;
                int charAt24 = zzd.charAt(i16);
                if (charAt24 >= c2) {
                    int i75 = charAt24 & 8191;
                    int i76 = i74;
                    int i77 = 13;
                    while (true) {
                        i31 = i76 + 1;
                        charAt12 = zzd.charAt(i76);
                        if (charAt12 < c2) {
                            break;
                        }
                        i75 |= (charAt12 & 8191) << i77;
                        i77 += 13;
                        i76 = i31;
                    }
                    charAt24 = i75 | (charAt12 << i77);
                    i17 = i31;
                } else {
                    i17 = i74;
                }
                if ((charAt24 & 1024) != 0) {
                    iArr[i68] = i69;
                    i68++;
                }
                int i78 = charAt24 & 255;
                zznr zznrVar2 = zznrVar;
                int i79 = charAt24 & 2048;
                if (i78 >= 51) {
                    int i80 = i17 + 1;
                    int charAt25 = zzd.charAt(i17);
                    char c3 = 55296;
                    if (charAt25 >= 55296) {
                        int i81 = charAt25 & 8191;
                        int i82 = i80;
                        int i83 = 13;
                        while (true) {
                            i30 = i82 + 1;
                            charAt11 = zzd.charAt(i82);
                            if (charAt11 < c3) {
                                break;
                            }
                            i81 |= (charAt11 & 8191) << i83;
                            i83 += 13;
                            i82 = i30;
                            c3 = 55296;
                        }
                        charAt25 = i81 | (charAt11 << i83);
                        i27 = i30;
                    } else {
                        i27 = i80;
                    }
                    int i84 = i27;
                    int i85 = i78 - 51;
                    i18 = length;
                    if (i85 == 9 || i85 == 17) {
                        i28 = i6 + 1;
                        int i86 = i69 / 3;
                        objArr[i86 + i86 + 1] = zze[i6];
                    } else {
                        if (i85 == 12) {
                            if (zznrVar2.zzc() == 1 || i79 != 0) {
                                i28 = i6 + 1;
                                int i87 = i69 / 3;
                                objArr[i87 + i87 + 1] = zze[i6];
                            } else {
                                i29 = 0;
                                int i88 = charAt25 + charAt25;
                                obj = zze[i88];
                                int i89 = i29;
                                if (obj instanceof Field) {
                                    zzz2 = (Field) obj;
                                } else {
                                    zzz2 = zzz(cls2, (String) obj);
                                    zze[i88] = zzz2;
                                }
                                int i90 = i7;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzz2);
                                int i91 = i88 + 1;
                                obj2 = zze[i91];
                                i19 = i90;
                                if (obj2 instanceof Field) {
                                    zzz3 = (Field) obj2;
                                } else {
                                    zzz3 = zzz(cls2, (String) obj2);
                                    zze[i91] = zzz3;
                                }
                                i21 = (int) unsafe.objectFieldOffset(zzz3);
                                str = zzd;
                                i23 = i89;
                                i17 = i84;
                                i22 = 0;
                                c = 55296;
                            }
                        }
                        i29 = i79;
                        int i882 = charAt25 + charAt25;
                        obj = zze[i882];
                        int i892 = i29;
                        if (obj instanceof Field) {
                        }
                        int i902 = i7;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zzz2);
                        int i912 = i882 + 1;
                        obj2 = zze[i912];
                        i19 = i902;
                        if (obj2 instanceof Field) {
                        }
                        i21 = (int) unsafe.objectFieldOffset(zzz3);
                        str = zzd;
                        i23 = i892;
                        i17 = i84;
                        i22 = 0;
                        c = 55296;
                    }
                    i6 = i28;
                    i29 = i79;
                    int i8822 = charAt25 + charAt25;
                    obj = zze[i8822];
                    int i8922 = i29;
                    if (obj instanceof Field) {
                    }
                    int i9022 = i7;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzz2);
                    int i9122 = i8822 + 1;
                    obj2 = zze[i9122];
                    i19 = i9022;
                    if (obj2 instanceof Field) {
                    }
                    i21 = (int) unsafe.objectFieldOffset(zzz3);
                    str = zzd;
                    i23 = i8922;
                    i17 = i84;
                    i22 = 0;
                    c = 55296;
                } else {
                    i18 = length;
                    i19 = i7;
                    int i92 = i6 + 1;
                    Field zzz4 = zzz(cls2, (String) zze[i6]);
                    if (i78 == 9 || i78 == 17) {
                        i20 = i92;
                        int i93 = i69 / 3;
                        objArr[i93 + i93 + 1] = zzz4.getType();
                    } else {
                        if (i78 == 27) {
                            i25 = i92;
                            i26 = 1;
                            i6 += 2;
                        } else if (i78 == 49) {
                            i6 += 2;
                            i25 = i92;
                            i26 = 1;
                        } else if (i78 == 12 || i78 == 30 || i78 == 44) {
                            if (zznrVar2.zzc() == 1 || i79 != 0) {
                                i6 += 2;
                                int i94 = i69 / 3;
                                objArr[i94 + i94 + 1] = zze[i92];
                                str = zzd;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                                if ((charAt24 & 4096) != 0 || i78 > 17) {
                                    c = 55296;
                                    i21 = 1048575;
                                    i22 = 0;
                                } else {
                                    int i95 = i17 + 1;
                                    int charAt26 = str.charAt(i17);
                                    if (charAt26 >= 55296) {
                                        int i96 = charAt26 & 8191;
                                        int i97 = 13;
                                        while (true) {
                                            i24 = i95 + 1;
                                            charAt10 = str.charAt(i95);
                                            if (charAt10 < 55296) {
                                                break;
                                            }
                                            i96 |= (charAt10 & 8191) << i97;
                                            i97 += 13;
                                            i95 = i24;
                                        }
                                        charAt26 = i96 | (charAt10 << i97);
                                    } else {
                                        i24 = i95;
                                    }
                                    int i98 = i19 + i19 + (charAt26 / 32);
                                    Object obj3 = zze[i98];
                                    if (obj3 instanceof Field) {
                                        zzz = (Field) obj3;
                                    } else {
                                        zzz = zzz(cls2, (String) obj3);
                                        zze[i98] = zzz;
                                    }
                                    i22 = charAt26 % 32;
                                    i17 = i24;
                                    c = 55296;
                                    i21 = (int) unsafe.objectFieldOffset(zzz);
                                }
                                if (i78 >= 18 && i78 <= 49) {
                                    iArr[i67] = objectFieldOffset;
                                    i67++;
                                }
                                i23 = i79;
                            } else {
                                str = zzd;
                                i6 = i92;
                                i79 = 0;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                                if ((charAt24 & 4096) != 0) {
                                }
                                c = 55296;
                                i21 = 1048575;
                                i22 = 0;
                                if (i78 >= 18) {
                                    iArr[i67] = objectFieldOffset;
                                    i67++;
                                }
                                i23 = i79;
                            }
                        } else if (i78 == 50) {
                            int i99 = i6 + 2;
                            int i100 = i66 + 1;
                            iArr[i66] = i69;
                            int i101 = i69 / 3;
                            int i102 = i101 + i101;
                            objArr[i102] = zze[i92];
                            if (i79 != 0) {
                                objArr[i102 + 1] = zze[i99];
                                i6 += 3;
                                str = zzd;
                                i66 = i100;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                                if ((charAt24 & 4096) != 0) {
                                }
                                c = 55296;
                                i21 = 1048575;
                                i22 = 0;
                                if (i78 >= 18) {
                                }
                                i23 = i79;
                            } else {
                                i6 = i99;
                                i66 = i100;
                                i79 = 0;
                                str = zzd;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                                if ((charAt24 & 4096) != 0) {
                                }
                                c = 55296;
                                i21 = 1048575;
                                i22 = 0;
                                if (i78 >= 18) {
                                }
                                i23 = i79;
                            }
                        } else {
                            i20 = i92;
                        }
                        int i103 = i69 / 3;
                        objArr[i103 + i103 + i26] = zze[i25];
                        str = zzd;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                        if ((charAt24 & 4096) != 0) {
                        }
                        c = 55296;
                        i21 = 1048575;
                        i22 = 0;
                        if (i78 >= 18) {
                        }
                        i23 = i79;
                    }
                    str = zzd;
                    i6 = i20;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzz4);
                    if ((charAt24 & 4096) != 0) {
                    }
                    c = 55296;
                    i21 = 1048575;
                    i22 = 0;
                    if (i78 >= 18) {
                    }
                    i23 = i79;
                }
                int i104 = i69 + 1;
                iArr3[i69] = charAt23;
                int i105 = i69 + 2;
                iArr3[i104] = ((charAt24 & 512) != 0 ? C.BUFFER_FLAG_LAST_SAMPLE : 0) | ((charAt24 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | objectFieldOffset;
                i69 += 3;
                iArr3[i105] = (i22 << 20) | i21;
                i35 = i17;
                zzd = str;
                c2 = c;
                zznrVar = zznrVar2;
                length = i18;
                i7 = i19;
            }
            return new zznk(iArr3, objArr, i2, i4, zznrVar.zza(), false, iArr, i5, i64, zznmVar, zzmuVar, zzoeVar, zzlqVar, zzncVar);
        }
        zzob zzobVar = (zzob) zzneVar;
        throw null;
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzol.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzol.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzol.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzol.zzf(obj, j)).longValue();
    }

    private final zzmg zzu(int i) {
        int i2 = i / 3;
        return (zzmg) this.zzd[i2 + i2 + 1];
    }

    private final zzns zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzns zznsVar = (zzns) objArr[i3];
        if (zznsVar != null) {
            return zznsVar;
        }
        zzns zzb2 = zznp.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzns zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzns zzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final int zza(Object obj) {
        int i;
        int zzz;
        int zzz2;
        int zzA;
        int zzz3;
        int zzz4;
        int zzz5;
        int zzd;
        int zzz6;
        int zzh;
        int zzg;
        int size;
        int zzl;
        int zzz7;
        int zzz8;
        int zzz9;
        int i2;
        int zze;
        int zzz10;
        int zzz11;
        int i3;
        int zzz12;
        int zzz13;
        int zzz14;
        int zzd2;
        int zzz15;
        zznk<T> zznkVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (true) {
            int[] iArr = zznkVar.zzc;
            if (i4 < iArr.length) {
                int zzs = zznkVar.zzs(i4);
                int zzr = zzr(zzs);
                int i8 = iArr[i4];
                int i9 = iArr[i4 + 2];
                int i10 = i9 & 1048575;
                if (zzr <= 17) {
                    if (i10 != i7) {
                        i5 = i10 == 1048575 ? 0 : unsafe.getInt(obj2, i10);
                        i7 = i10;
                    }
                    i = 1 << (i9 >>> 20);
                } else {
                    i = 0;
                }
                int i11 = zzs & 1048575;
                if (zzr >= zzlv.DOUBLE_LIST_PACKED.zza()) {
                    zzlv.SINT64_LIST_PACKED.zza();
                }
                long j = i11;
                switch (zzr) {
                    case 0:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            i6 += zzlk.zzz(i8 << 3) + 8;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz = zzlk.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 2:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j2 = unsafe.getLong(obj2, j);
                            zzz2 = zzlk.zzz(i8 << 3);
                            zzA = zzlk.zzA(j2);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 3:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j3 = unsafe.getLong(obj2, j);
                            zzz2 = zzlk.zzz(i8 << 3);
                            zzA = zzlk.zzA(j3);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 4:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz2 = zzlk.zzz(i8 << 3);
                            zzA = zzlk.zzA(unsafe.getInt(obj2, j));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 5:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz3 = zzlk.zzz(i8 << 3);
                            zzz4 = zzz3 + 8;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 6:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz = zzlk.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 7:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz4 = zzlk.zzz(i8 << 3) + 1;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 8:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i12 = i8 << 3;
                            Object object = unsafe.getObject(obj2, j);
                            if (object instanceof zzld) {
                                zzz5 = zzlk.zzz(i12);
                                zzd = ((zzld) object).zzd();
                                zzz6 = zzlk.zzz(zzd);
                                zzz4 = zzz5 + zzz6 + zzd;
                                i6 += zzz4;
                            } else {
                                zzz2 = zzlk.zzz(i12);
                                zzA = zzlk.zzy((String) object);
                                zzz4 = zzz2 + zzA;
                                i6 += zzz4;
                            }
                        }
                        zznkVar = this;
                        break;
                    case 9:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzh = zznu.zzh(i8, unsafe.getObject(obj2, j), zznkVar.zzv(i4));
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz5 = zzlk.zzz(i8 << 3);
                            zzd = ((zzld) unsafe.getObject(obj2, j)).zzd();
                            zzz6 = zzlk.zzz(zzd);
                            zzz4 = zzz5 + zzz6 + zzd;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 11:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i13 = unsafe.getInt(obj2, j);
                            zzz2 = zzlk.zzz(i8 << 3);
                            zzA = zzlk.zzz(i13);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 12:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz2 = zzlk.zzz(i8 << 3);
                            zzA = zzlk.zzA(unsafe.getInt(obj2, j));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 13:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz = zzlk.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 14:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz3 = zzlk.zzz(i8 << 3);
                            zzz4 = zzz3 + 8;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 15:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i14 = unsafe.getInt(obj2, j);
                            zzz2 = zzlk.zzz(i8 << 3);
                            zzA = zzlk.zzz((i14 >> 31) ^ (i14 + i14));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 16:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j4 = unsafe.getLong(obj2, j);
                            zzz2 = zzlk.zzz(i8 << 3);
                            zzA = zzlk.zzA((j4 >> 63) ^ (j4 + j4));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznkVar = this;
                        break;
                    case 17:
                        if (zznkVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzh = zzlk.zzw(i8, (zznh) unsafe.getObject(obj2, j), zznkVar.zzv(i4));
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzh = zznu.zzd(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzh;
                        break;
                    case 19:
                        zzh = zznu.zzb(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzh;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(obj2, j);
                        int i15 = zznu.zza;
                        if (list.size() != 0) {
                            zzg = zznu.zzg(list) + (list.size() * zzlk.zzz(i8 << 3));
                            i6 += zzg;
                            break;
                        }
                        zzg = 0;
                        i6 += zzg;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj2, j);
                        int i16 = zznu.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzl = zznu.zzl(list2);
                            zzz7 = zzlk.zzz(i8 << 3);
                            i2 = size * zzz7;
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj2, j);
                        int i17 = zznu.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzl = zznu.zzf(list3);
                            zzz7 = zzlk.zzz(i8 << 3);
                            i2 = size * zzz7;
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 23:
                        zzh = zznu.zzd(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzh;
                        break;
                    case 24:
                        zzh = zznu.zzb(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzh;
                        break;
                    case 25:
                        int i18 = zznu.zza;
                        int size2 = ((List) unsafe.getObject(obj2, j)).size();
                        if (size2 != 0) {
                            zzh = size2 * (zzlk.zzz(i8 << 3) + 1);
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 26:
                        List list4 = (List) unsafe.getObject(obj2, j);
                        int i19 = zznu.zza;
                        int size3 = list4.size();
                        if (size3 != 0) {
                            zzg = zzlk.zzz(i8 << 3) * size3;
                            if (list4 instanceof zzmt) {
                                zzmt zzmtVar = (zzmt) list4;
                                for (int i20 = 0; i20 < size3; i20++) {
                                    Object zzc = zzmtVar.zzc();
                                    if (zzc instanceof zzld) {
                                        int zzd3 = ((zzld) zzc).zzd();
                                        zzg += zzlk.zzz(zzd3) + zzd3;
                                    } else {
                                        zzg += zzlk.zzy((String) zzc);
                                    }
                                }
                            } else {
                                for (int i21 = 0; i21 < size3; i21++) {
                                    Object obj3 = list4.get(i21);
                                    if (obj3 instanceof zzld) {
                                        int zzd4 = ((zzld) obj3).zzd();
                                        zzg += zzlk.zzz(zzd4) + zzd4;
                                    } else {
                                        zzg += zzlk.zzy((String) obj3);
                                    }
                                }
                            }
                            i6 += zzg;
                            break;
                        }
                        zzg = 0;
                        i6 += zzg;
                    case 27:
                        List list5 = (List) unsafe.getObject(obj2, j);
                        zzns zzv = zznkVar.zzv(i4);
                        int i22 = zznu.zza;
                        int size4 = list5.size();
                        if (size4 == 0) {
                            zzz8 = 0;
                        } else {
                            zzz8 = zzlk.zzz(i8 << 3) * size4;
                            for (int i23 = 0; i23 < size4; i23++) {
                                Object obj4 = list5.get(i23);
                                if (obj4 instanceof zzms) {
                                    int zza2 = ((zzms) obj4).zza();
                                    zzz8 += zzlk.zzz(zza2) + zza2;
                                } else {
                                    zzz8 += zzlk.zzx((zznh) obj4, zzv);
                                }
                            }
                        }
                        i6 += zzz8;
                        break;
                    case 28:
                        List list6 = (List) unsafe.getObject(obj2, j);
                        int i24 = zznu.zza;
                        int size5 = list6.size();
                        if (size5 == 0) {
                            zzz9 = 0;
                        } else {
                            zzz9 = size5 * zzlk.zzz(i8 << 3);
                            for (int i25 = 0; i25 < list6.size(); i25++) {
                                int zzd5 = ((zzld) list6.get(i25)).zzd();
                                zzz9 += zzlk.zzz(zzd5) + zzd5;
                            }
                        }
                        i6 += zzz9;
                        break;
                    case 29:
                        List list7 = (List) unsafe.getObject(obj2, j);
                        int i26 = zznu.zza;
                        size = list7.size();
                        if (size != 0) {
                            zzl = zznu.zzk(list7);
                            zzz7 = zzlk.zzz(i8 << 3);
                            i2 = size * zzz7;
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 30:
                        List list8 = (List) unsafe.getObject(obj2, j);
                        int i27 = zznu.zza;
                        size = list8.size();
                        if (size != 0) {
                            zzl = zznu.zza(list8);
                            zzz7 = zzlk.zzz(i8 << 3);
                            i2 = size * zzz7;
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 31:
                        zzh = zznu.zzb(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzh;
                        break;
                    case 32:
                        zzh = zznu.zzd(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzh;
                        break;
                    case 33:
                        List list9 = (List) unsafe.getObject(obj2, j);
                        int i28 = zznu.zza;
                        size = list9.size();
                        if (size != 0) {
                            zzl = zznu.zzi(list9);
                            zzz7 = zzlk.zzz(i8 << 3);
                            i2 = size * zzz7;
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 34:
                        List list10 = (List) unsafe.getObject(obj2, j);
                        int i29 = zznu.zza;
                        size = list10.size();
                        if (size != 0) {
                            zzl = zznu.zzj(list10);
                            zzz7 = zzlk.zzz(i8 << 3);
                            i2 = size * zzz7;
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 35:
                        zze = zznu.zze((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zze = zznu.zzc((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zze = zznu.zzg((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zze = zznu.zzl((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zze = zznu.zzf((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zze = zznu.zze((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zze = zznu.zzc((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i30 = zznu.zza;
                        zze = ((List) unsafe.getObject(obj2, j)).size();
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zze = zznu.zzk((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zze = zznu.zza((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zze = zznu.zzc((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zze = zznu.zze((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zze = zznu.zzi((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zze = zznu.zzj((List) unsafe.getObject(obj2, j));
                        if (zze > 0) {
                            zzz10 = zzlk.zzz(i8 << 3);
                            zzz11 = zzlk.zzz(zze);
                            zzz9 = zzz10 + zzz11 + zze;
                            i6 += zzz9;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        List list11 = (List) unsafe.getObject(obj2, j);
                        zzns zzv2 = zznkVar.zzv(i4);
                        int i31 = zznu.zza;
                        int size6 = list11.size();
                        if (size6 == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            for (int i32 = 0; i32 < size6; i32++) {
                                i3 += zzlk.zzw(i8, (zznh) list11.get(i32), zzv2);
                            }
                        }
                        i6 += i3;
                        break;
                    case 50:
                        zznb zznbVar = (zznb) unsafe.getObject(obj2, j);
                        zzna zznaVar = (zzna) zznkVar.zzw(i4);
                        if (zznbVar.isEmpty()) {
                            continue;
                        } else {
                            Iterator it = zznbVar.entrySet().iterator();
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                entry.getKey();
                                entry.getValue();
                                throw null;
                            }
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzz12 = zzlk.zzz(i8 << 3);
                            zzh = zzz12 + 8;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzz13 = zzlk.zzz(i8 << 3);
                            zzh = zzz13 + 4;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            long zzt = zzt(obj2, j);
                            zzl = zzlk.zzz(i8 << 3);
                            i2 = zzlk.zzA(zzt);
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            long zzt2 = zzt(obj2, j);
                            zzl = zzlk.zzz(i8 << 3);
                            i2 = zzlk.zzA(zzt2);
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzl = zzlk.zzz(i8 << 3);
                            i2 = zzlk.zzA(zzo(obj2, j));
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzz12 = zzlk.zzz(i8 << 3);
                            zzh = zzz12 + 8;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzz13 = zzlk.zzz(i8 << 3);
                            zzh = zzz13 + 4;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzh = zzlk.zzz(i8 << 3) + 1;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!zznkVar.zzM(obj2, i8, i4)) {
                            break;
                        } else {
                            int i33 = i8 << 3;
                            Object object2 = unsafe.getObject(obj2, j);
                            if (object2 instanceof zzld) {
                                zzz14 = zzlk.zzz(i33);
                                zzd2 = ((zzld) object2).zzd();
                                zzz15 = zzlk.zzz(zzd2);
                                zzh = zzz14 + zzz15 + zzd2;
                                i6 += zzh;
                                break;
                            } else {
                                zzl = zzlk.zzz(i33);
                                i2 = zzlk.zzy((String) object2);
                                zzh = zzl + i2;
                                i6 += zzh;
                            }
                        }
                    case 60:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzh = zznu.zzh(i8, unsafe.getObject(obj2, j), zznkVar.zzv(i4));
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzz14 = zzlk.zzz(i8 << 3);
                            zzd2 = ((zzld) unsafe.getObject(obj2, j)).zzd();
                            zzz15 = zzlk.zzz(zzd2);
                            zzh = zzz14 + zzz15 + zzd2;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            int zzo = zzo(obj2, j);
                            zzl = zzlk.zzz(i8 << 3);
                            i2 = zzlk.zzz(zzo);
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzl = zzlk.zzz(i8 << 3);
                            i2 = zzlk.zzA(zzo(obj2, j));
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzz13 = zzlk.zzz(i8 << 3);
                            zzh = zzz13 + 4;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzz12 = zzlk.zzz(i8 << 3);
                            zzh = zzz12 + 8;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            int zzo2 = zzo(obj2, j);
                            zzl = zzlk.zzz(i8 << 3);
                            i2 = zzlk.zzz((zzo2 >> 31) ^ (zzo2 + zzo2));
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            long zzt3 = zzt(obj2, j);
                            zzl = zzlk.zzz(i8 << 3);
                            i2 = zzlk.zzA((zzt3 >> 63) ^ (zzt3 + zzt3));
                            zzh = zzl + i2;
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zznkVar.zzM(obj2, i8, i4)) {
                            zzh = zzlk.zzw(i8, (zznh) unsafe.getObject(obj2, j), zznkVar.zzv(i4));
                            i6 += zzh;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                obj2 = obj;
            } else {
                int zza3 = i6 + ((zzmd) obj).zzc.zza();
                if (zznkVar.zzh) {
                    zzoa zzoaVar = ((zzma) obj).zzb.zza;
                    int zzc2 = zzoaVar.zzc();
                    int i34 = 0;
                    for (int i35 = 0; i35 < zzc2; i35++) {
                        Map.Entry zzg2 = zzoaVar.zzg(i35);
                        i34 += zzlu.zzb((zzlt) ((zznw) zzg2).zza(), zzg2.getValue());
                    }
                    for (Map.Entry entry2 : zzoaVar.zzd()) {
                        i34 += zzlu.zzb((zzlt) entry2.getKey(), entry2.getValue());
                    }
                    return zza3 + i34;
                }
                return zza3;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final int zzb(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 < iArr.length) {
                int zzs = zzs(i3);
                int i5 = 1048575 & zzs;
                int zzr = zzr(zzs);
                int i6 = iArr[i3];
                long j = i5;
                int i7 = 37;
                switch (zzr) {
                    case 0:
                        i = i4 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzol.zza(obj, j));
                        byte[] bArr = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 1:
                        i = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzol.zzb(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 2:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr2 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 3:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr3 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 4:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 5:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr4 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 6:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 7:
                        i = i4 * 53;
                        floatToIntBits = zzmk.zza(zzol.zzw(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 8:
                        i = i4 * 53;
                        floatToIntBits = ((String) zzol.zzf(obj, j)).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 9:
                        i2 = i4 * 53;
                        Object zzf = zzol.zzf(obj, j);
                        if (zzf != null) {
                            i7 = zzf.hashCode();
                        }
                        i4 = i2 + i7;
                        break;
                    case 10:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 11:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 12:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 13:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 14:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr5 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 15:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 16:
                        i = i4 * 53;
                        doubleToLongBits = zzol.zzd(obj, j);
                        byte[] bArr6 = zzmk.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 17:
                        i2 = i4 * 53;
                        Object zzf2 = zzol.zzf(obj, j);
                        if (zzf2 != null) {
                            i7 = zzf2.hashCode();
                        }
                        i4 = i2 + i7;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 50:
                        i = i4 * 53;
                        floatToIntBits = zzol.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                            byte[] bArr7 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = Float.floatToIntBits(zzn(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr8 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr9 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 56:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr10 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 57:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 58:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzmk.zza(zzN(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 59:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = ((String) zzol.zzf(obj, j)).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 60:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzol.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzol.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 62:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 63:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 64:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr11 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzo(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 67:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzt(obj, j);
                            byte[] bArr12 = zzmk.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 68:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzol.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                }
                i3 += 3;
            } else {
                int hashCode = (i4 * 53) + ((zzmd) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzma) obj).zzb.zza.hashCode() : hashCode;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x0da2, code lost:
        if (r14 == 1048575) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:0x0da4, code lost:
        r9.putInt(r10, r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:586:0x0da8, code lost:
        r1 = r35.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:588:0x0dac, code lost:
        if (r1 >= r35.zzk) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:589:0x0dae, code lost:
        r2 = r35.zzi;
        r5 = r35.zzc;
        r2 = r2[r1];
        r5 = r5[r2];
        r5 = com.google.android.gms.internal.measurement.zzol.zzf(r10, zzs(r2) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:590:0x0dc4, code lost:
        if (r5 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:593:0x0dcb, code lost:
        if (zzu(r2) != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:594:0x0dcd, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x0dd4, code lost:
        r5 = (com.google.android.gms.internal.measurement.zznb) r5;
        r1 = (com.google.android.gms.internal.measurement.zzna) zzw(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:596:0x0ddc, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:0x0ddf, code lost:
        if (r7 != 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:599:0x0de1, code lost:
        if (r3 != r4) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x0de9, code lost:
        throw new com.google.android.gms.internal.measurement.zzmm("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:603:0x0dea, code lost:
        if (r3 > r4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x0dec, code lost:
        if (r6 != r7) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:605:0x0dee, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x0df4, code lost:
        throw new com.google.android.gms.internal.measurement.zzmm("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0775  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x07ca  */
    /* JADX WARN: Removed duplicated region for block: B:569:0x0d40 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0d4f  */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0055 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0238  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:258:0x06d4 -> B:259:0x06d5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:293:0x0772 -> B:294:0x0773). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:313:0x07c6 -> B:314:0x07c8). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzks zzksVar) throws IOException {
        int i4;
        Unsafe unsafe;
        Object obj2;
        int i5;
        int zzq;
        int i6;
        int i7;
        int i8;
        int i9;
        zzks zzksVar2;
        int i10;
        int i11;
        byte[] bArr2;
        int i12;
        int i13;
        int i14;
        int i15;
        Object obj3;
        Unsafe unsafe2;
        byte[] bArr3;
        zzks zzksVar3;
        int i16;
        int i17;
        int i18;
        byte[] bArr4;
        Unsafe unsafe3;
        int i19;
        int i20;
        Object obj4;
        int i21;
        zzks zzksVar4;
        int i22;
        long j;
        Unsafe unsafe4;
        int i23;
        int i24;
        int zzh;
        int zzh2;
        int i25;
        int i26;
        int zzh3;
        int i27;
        Object obj5;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        byte[] bArr5;
        int zza2;
        int zzh4;
        Object obj6 = obj;
        byte[] bArr6 = bArr;
        int i36 = i2;
        zzks zzksVar5 = zzksVar;
        zzA(obj6);
        Unsafe unsafe5 = zzb;
        int i37 = 0;
        int i38 = i;
        int i39 = 0;
        int i40 = 0;
        int i41 = 0;
        int i42 = -1;
        int i43 = 1048575;
        while (true) {
            if (i38 < i36) {
                int i44 = i38 + 1;
                int i45 = bArr6[i38];
                if (i45 < 0) {
                    i44 = zzkt.zzi(i45, bArr6, i44, zzksVar5);
                    i45 = zzksVar5.zza;
                }
                int i46 = i44;
                int i47 = i45;
                i38 = i46;
                int i48 = i47 >>> 3;
                if (i48 <= i42) {
                    if (i48 >= this.zze && i48 <= this.zzf) {
                        zzq = zzq(i48, i37);
                        if (zzq != -1) {
                        }
                        if (i11 == i4) {
                        }
                        if (this.zzh) {
                        }
                        i12 = i11;
                        i13 = i2;
                        i38 = zzkt.zzg(i12, bArr, i38, i13, zzd(obj2), zzksVar);
                        bArr6 = bArr;
                        i40 = i12;
                        i36 = i13;
                        unsafe5 = unsafe;
                        obj6 = obj2;
                        i39 = i6;
                        i42 = i10;
                        i43 = i8;
                        i37 = i7;
                        i41 = i9;
                        zzksVar5 = zzksVar;
                    }
                    zzq = -1;
                    if (zzq != -1) {
                    }
                    if (i11 == i4) {
                    }
                    if (this.zzh) {
                    }
                    i12 = i11;
                    i13 = i2;
                    i38 = zzkt.zzg(i12, bArr, i38, i13, zzd(obj2), zzksVar);
                    bArr6 = bArr;
                    i40 = i12;
                    i36 = i13;
                    unsafe5 = unsafe;
                    obj6 = obj2;
                    i39 = i6;
                    i42 = i10;
                    i43 = i8;
                    i37 = i7;
                    i41 = i9;
                    zzksVar5 = zzksVar;
                } else {
                    int i49 = i39 / 3;
                    if (i48 >= this.zze && i48 <= this.zzf) {
                        zzq = zzq(i48, i49);
                        if (zzq != -1) {
                            unsafe = unsafe5;
                            i6 = i37;
                            i7 = i6;
                            i8 = i43;
                            i9 = i41;
                            zzksVar2 = zzksVar5;
                            i10 = i48;
                            obj2 = obj6;
                            i11 = i47;
                            bArr2 = bArr6;
                            i4 = i3;
                        } else {
                            int i50 = i47 & 7;
                            int[] iArr = this.zzc;
                            int i51 = iArr[zzq + 1];
                            int i52 = zzq;
                            int zzr = zzr(i51);
                            long j2 = i51 & 1048575;
                            if (zzr <= 17) {
                                int i53 = iArr[i52 + 2];
                                int i54 = 1 << (i53 >>> 20);
                                int i55 = i53 & 1048575;
                                if (i55 != i43) {
                                    int i56 = 1048575;
                                    if (i43 != 1048575) {
                                        unsafe5.putInt(obj6, i43, i41);
                                        i56 = 1048575;
                                    }
                                    i41 = i55 == i56 ? 0 : unsafe5.getInt(obj6, i55);
                                    i43 = i55;
                                }
                                switch (zzr) {
                                    case 0:
                                        zzks zzksVar6 = zzksVar5;
                                        bArr3 = bArr6;
                                        zzksVar3 = zzksVar6;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i37 = 0;
                                        obj3 = obj6;
                                        i15 = i41;
                                        unsafe2 = unsafe5;
                                        if (i50 != 1) {
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i16 = i38 + 8;
                                            i17 = i15 | i54;
                                            zzol.zzo(obj3, j2, Double.longBitsToDouble(zzkt.zzn(bArr3, i38)));
                                            byte[] bArr7 = bArr3;
                                            zzksVar5 = zzksVar3;
                                            bArr6 = bArr7;
                                            i36 = i2;
                                            i38 = i16;
                                            i40 = i11;
                                            obj6 = obj3;
                                            unsafe5 = unsafe2;
                                            i42 = i48;
                                            i43 = i14;
                                            i41 = i17;
                                            i39 = i6;
                                            break;
                                        }
                                    case 1:
                                        zzks zzksVar7 = zzksVar5;
                                        bArr3 = bArr6;
                                        zzksVar3 = zzksVar7;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i37 = 0;
                                        obj3 = obj6;
                                        i15 = i41;
                                        unsafe2 = unsafe5;
                                        if (i50 != 5) {
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i16 = i38 + 4;
                                            i17 = i15 | i54;
                                            zzol.zzp(obj3, j2, Float.intBitsToFloat(zzkt.zzb(bArr3, i38)));
                                            byte[] bArr72 = bArr3;
                                            zzksVar5 = zzksVar3;
                                            bArr6 = bArr72;
                                            i36 = i2;
                                            i38 = i16;
                                            i40 = i11;
                                            obj6 = obj3;
                                            unsafe5 = unsafe2;
                                            i42 = i48;
                                            i43 = i14;
                                            i41 = i17;
                                            i39 = i6;
                                            break;
                                        }
                                    case 2:
                                    case 3:
                                        zzks zzksVar8 = zzksVar5;
                                        byte[] bArr8 = bArr6;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i37 = 0;
                                        i15 = i41;
                                        if (i50 != 0) {
                                            unsafe2 = unsafe5;
                                            obj3 = obj6;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            int zzk = zzkt.zzk(bArr8, i38, zzksVar8);
                                            unsafe5.putLong(obj6, j2, zzksVar8.zzb);
                                            zzksVar5 = zzksVar8;
                                            bArr6 = bArr8;
                                            i43 = i14;
                                            i41 = i15 | i54;
                                            i38 = zzk;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            i36 = i2;
                                            break;
                                        }
                                    case 4:
                                    case 11:
                                        zzks zzksVar9 = zzksVar5;
                                        byte[] bArr9 = bArr6;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i37 = 0;
                                        i15 = i41;
                                        if (i50 != 0) {
                                            unsafe2 = unsafe5;
                                            obj3 = obj6;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i18 = i15 | i54;
                                            i38 = zzkt.zzh(bArr9, i38, zzksVar9);
                                            unsafe5.putInt(obj6, j2, zzksVar9.zza);
                                            bArr4 = bArr9;
                                            zzksVar5 = zzksVar9;
                                            bArr6 = bArr4;
                                            i43 = i14;
                                            i36 = i2;
                                            i41 = i18;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            break;
                                        }
                                    case 5:
                                    case 14:
                                        byte[] bArr10 = bArr6;
                                        Unsafe unsafe6 = unsafe5;
                                        zzks zzksVar10 = zzksVar5;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i37 = 0;
                                        i15 = i41;
                                        if (i50 != 1) {
                                            unsafe5 = unsafe6;
                                            unsafe2 = unsafe5;
                                            obj3 = obj6;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            unsafe5 = unsafe6;
                                            unsafe5.putLong(obj6, j2, zzkt.zzn(bArr10, i38));
                                            zzksVar5 = zzksVar10;
                                            bArr6 = bArr10;
                                            i43 = i14;
                                            i38 += 8;
                                            i41 = i15 | i54;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            i36 = i2;
                                            break;
                                        }
                                    case 6:
                                    case 13:
                                        byte[] bArr11 = bArr6;
                                        unsafe3 = unsafe5;
                                        zzks zzksVar11 = zzksVar5;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i37 = 0;
                                        i15 = i41;
                                        if (i50 != 5) {
                                            obj3 = obj6;
                                            unsafe2 = unsafe3;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i19 = i15 | i54;
                                            unsafe3.putInt(obj6, j2, zzkt.zzb(bArr11, i38));
                                            zzksVar5 = zzksVar11;
                                            unsafe5 = unsafe3;
                                            bArr6 = bArr11;
                                            i43 = i14;
                                            i36 = i2;
                                            i38 += 4;
                                            i41 = i19;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            break;
                                        }
                                    case 7:
                                        byte[] bArr12 = bArr6;
                                        unsafe3 = unsafe5;
                                        zzks zzksVar12 = zzksVar5;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i37 = 0;
                                        i15 = i41;
                                        if (i50 != 0) {
                                            obj3 = obj6;
                                            unsafe2 = unsafe3;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i18 = i15 | i54;
                                            i38 = zzkt.zzk(bArr12, i38, zzksVar12);
                                            zzol.zzm(obj6, j2, zzksVar12.zzb != 0);
                                            bArr4 = bArr12;
                                            zzksVar5 = zzksVar12;
                                            unsafe5 = unsafe3;
                                            bArr6 = bArr4;
                                            i43 = i14;
                                            i36 = i2;
                                            i41 = i18;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            break;
                                        }
                                    case 8:
                                        byte[] bArr13 = bArr6;
                                        unsafe3 = unsafe5;
                                        zzks zzksVar13 = zzksVar5;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i15 = i41;
                                        if (i50 != 2) {
                                            i37 = 0;
                                            obj3 = obj6;
                                            unsafe2 = unsafe3;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            if ((i51 & C.BUFFER_FLAG_LAST_SAMPLE) == 0) {
                                                i37 = 0;
                                                i38 = zzkt.zzh(bArr13, i38, zzksVar13);
                                                int i57 = zzksVar13.zza;
                                                if (i57 < 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                i19 = i15 | i54;
                                                if (i57 != 0) {
                                                    zzksVar13.zzc = new String(bArr13, i38, i57, zzmk.zza);
                                                    i38 += i57;
                                                } else {
                                                    zzksVar13.zzc = "";
                                                }
                                            } else {
                                                i38 = zzkt.zzh(bArr13, i38, zzksVar13);
                                                int i58 = zzksVar13.zza;
                                                if (i58 < 0) {
                                                    throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                int i59 = i15 | i54;
                                                if (i58 != 0) {
                                                    int i60 = zzoo.zza;
                                                    int length = bArr13.length;
                                                    if ((((length - i38) - i58) | i38 | i58) < 0) {
                                                        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i38), Integer.valueOf(i58)));
                                                    }
                                                    int i61 = i38 + i58;
                                                    char[] cArr = new char[i58];
                                                    int i62 = 0;
                                                    while (i38 < i61) {
                                                        byte b = bArr13[i38];
                                                        if (zzom.zzd(b)) {
                                                            i38++;
                                                            cArr[i62] = (char) b;
                                                            i62++;
                                                        } else {
                                                            while (i38 < i61) {
                                                                int i63 = i38 + 1;
                                                                int i64 = i38;
                                                                byte b2 = bArr13[i64];
                                                                if (zzom.zzd(b2)) {
                                                                    int i65 = i62 + 1;
                                                                    cArr[i62] = (char) b2;
                                                                    i38 = i63;
                                                                    while (true) {
                                                                        i62 = i65;
                                                                        if (i38 < i61) {
                                                                            byte b3 = bArr13[i38];
                                                                            if (zzom.zzd(b3)) {
                                                                                i38++;
                                                                                i65 = i62 + 1;
                                                                                cArr[i62] = (char) b3;
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    int i66 = i59;
                                                                    if (b2 < -32) {
                                                                        if (i63 < i61) {
                                                                            zzom.zzc(b2, bArr13[i63], cArr, i62);
                                                                            i62++;
                                                                            i38 = i64 + 2;
                                                                        } else {
                                                                            throw new zzmm("Protocol message had invalid UTF-8.");
                                                                        }
                                                                    } else if (b2 < -16) {
                                                                        if (i63 < i61 - 1) {
                                                                            zzom.zzb(b2, bArr13[i63], bArr13[i64 + 2], cArr, i62);
                                                                            i38 = i64 + 3;
                                                                            i59 = i66;
                                                                            i62++;
                                                                        } else {
                                                                            throw new zzmm("Protocol message had invalid UTF-8.");
                                                                        }
                                                                    } else if (i63 < i61 - 2) {
                                                                        char[] cArr2 = cArr;
                                                                        zzom.zza(b2, bArr13[i63], bArr13[i64 + 2], bArr13[i64 + 3], cArr2, i62);
                                                                        i62 += 2;
                                                                        cArr = cArr2;
                                                                        i38 = i64 + 4;
                                                                    } else {
                                                                        throw new zzmm("Protocol message had invalid UTF-8.");
                                                                    }
                                                                    i59 = i66;
                                                                }
                                                            }
                                                            i20 = i59;
                                                            i37 = 0;
                                                            zzksVar13.zzc = new String(cArr, 0, i62);
                                                            i38 = i61;
                                                        }
                                                    }
                                                    while (i38 < i61) {
                                                    }
                                                    i20 = i59;
                                                    i37 = 0;
                                                    zzksVar13.zzc = new String(cArr, 0, i62);
                                                    i38 = i61;
                                                } else {
                                                    zzksVar13.zzc = "";
                                                    i20 = i59;
                                                    i37 = 0;
                                                }
                                                i19 = i20;
                                            }
                                            unsafe3.putObject(obj6, j2, zzksVar13.zzc);
                                            zzksVar5 = zzksVar13;
                                            unsafe5 = unsafe3;
                                            bArr6 = bArr13;
                                            i43 = i14;
                                            i36 = i2;
                                            i41 = i19;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            break;
                                        }
                                        break;
                                    case 9:
                                        obj4 = obj6;
                                        i14 = i43;
                                        int i67 = i41;
                                        i6 = i52;
                                        i11 = i47;
                                        if (i50 != 2) {
                                            i15 = i67;
                                            unsafe2 = unsafe5;
                                            obj3 = obj4;
                                            i37 = 0;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i41 = i67 | i54;
                                            Unsafe unsafe7 = unsafe5;
                                            Object zzx = zzx(obj4, i6);
                                            byte[] bArr14 = bArr6;
                                            zzks zzksVar14 = zzksVar5;
                                            int zzm = zzkt.zzm(zzx, zzv(i6), bArr14, i38, i2, zzksVar14);
                                            zzF(obj4, i6, zzx);
                                            zzksVar5 = zzksVar14;
                                            unsafe5 = unsafe7;
                                            bArr6 = bArr14;
                                            i43 = i14;
                                            i36 = i2;
                                            i38 = zzm;
                                            obj6 = obj4;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            i37 = 0;
                                            break;
                                        }
                                    case 10:
                                        obj4 = obj6;
                                        i14 = i43;
                                        i21 = i41;
                                        i6 = i52;
                                        i11 = i47;
                                        if (i50 != 2) {
                                            unsafe2 = unsafe5;
                                            i15 = i21;
                                            obj3 = obj4;
                                            i37 = 0;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i21 |= i54;
                                            i38 = zzkt.zza(bArr6, i38, zzksVar5);
                                            unsafe5.putObject(obj4, j2, zzksVar5.zzc);
                                            i43 = i14;
                                            i36 = i2;
                                            i41 = i21;
                                            obj6 = obj4;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            i37 = 0;
                                            break;
                                        }
                                    case 12:
                                        obj4 = obj6;
                                        i14 = i43;
                                        i21 = i41;
                                        i6 = i52;
                                        i11 = i47;
                                        if (i50 != 0) {
                                            unsafe2 = unsafe5;
                                            i15 = i21;
                                            obj3 = obj4;
                                            i37 = 0;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i38 = zzkt.zzh(bArr6, i38, zzksVar5);
                                            int i68 = zzksVar5.zza;
                                            zzmg zzu = zzu(i6);
                                            if ((Integer.MIN_VALUE & i51) == 0 || zzu == null || zzu.zza(i68)) {
                                                i21 |= i54;
                                                unsafe5.putInt(obj4, j2, i68);
                                            } else {
                                                zzd(obj4).zzj(i11, Long.valueOf(i68));
                                            }
                                            i43 = i14;
                                            i36 = i2;
                                            i41 = i21;
                                            obj6 = obj4;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            i37 = 0;
                                            break;
                                        }
                                    case 15:
                                        obj4 = obj6;
                                        i14 = i43;
                                        i21 = i41;
                                        i6 = i52;
                                        i11 = i47;
                                        if (i50 != 0) {
                                            unsafe2 = unsafe5;
                                            i15 = i21;
                                            obj3 = obj4;
                                            i37 = 0;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i21 |= i54;
                                            i38 = zzkt.zzh(bArr6, i38, zzksVar5);
                                            unsafe5.putInt(obj4, j2, zzlg.zzb(zzksVar5.zza));
                                            i43 = i14;
                                            i36 = i2;
                                            i41 = i21;
                                            obj6 = obj4;
                                            i39 = i6;
                                            i40 = i11;
                                            i42 = i48;
                                            i37 = 0;
                                            break;
                                        }
                                    case 16:
                                        if (i50 != 0) {
                                            i6 = i52;
                                            i11 = i47;
                                            i14 = i43;
                                            i15 = i41;
                                            i37 = 0;
                                            unsafe2 = unsafe5;
                                            obj3 = obj6;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            i41 |= i54;
                                            int zzk2 = zzkt.zzk(bArr6, i38, zzksVar5);
                                            unsafe5.putLong(obj6, j2, zzlg.zzc(zzksVar5.zzb));
                                            i38 = zzk2;
                                            i39 = i52;
                                            i40 = i47;
                                            i42 = i48;
                                            i37 = 0;
                                            i36 = i2;
                                            break;
                                        }
                                    default:
                                        zzks zzksVar15 = zzksVar5;
                                        byte[] bArr15 = bArr6;
                                        i14 = i43;
                                        i6 = i52;
                                        i11 = i47;
                                        i37 = 0;
                                        obj3 = obj6;
                                        i15 = i41;
                                        unsafe2 = unsafe5;
                                        if (i50 != 3) {
                                            bArr2 = bArr;
                                            i4 = i3;
                                            i7 = i37;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            i9 = i15;
                                            i10 = i48;
                                            i8 = i14;
                                            zzksVar2 = zzksVar;
                                            break;
                                        } else {
                                            Object zzx2 = zzx(obj3, i6);
                                            int zzl = zzkt.zzl(zzx2, zzv(i6), bArr15, i38, i2, (i48 << 3) | 4, zzksVar15);
                                            zzF(obj3, i6, zzx2);
                                            bArr6 = bArr;
                                            zzksVar5 = zzksVar;
                                            i38 = zzl;
                                            i39 = i6;
                                            i40 = i11;
                                            obj6 = obj3;
                                            unsafe5 = unsafe2;
                                            i42 = i48;
                                            i43 = i14;
                                            i41 = i15 | i54;
                                            i36 = i2;
                                            break;
                                        }
                                }
                            } else {
                                Unsafe unsafe8 = unsafe5;
                                obj2 = obj6;
                                int i69 = i48;
                                i6 = i52;
                                i7 = 0;
                                if (zzr != 27) {
                                    int i70 = i47;
                                    i9 = i41;
                                    i22 = i38;
                                    zzksVar4 = zzksVar;
                                    Unsafe unsafe9 = unsafe8;
                                    i8 = i43;
                                    if (zzr <= 49) {
                                        long j3 = i51;
                                        zzmj zzmjVar = (zzmj) unsafe9.getObject(obj2, j2);
                                        if (zzmjVar.zzc()) {
                                            j = j3;
                                        } else {
                                            int size = zzmjVar.size();
                                            j = j3;
                                            zzmjVar = zzmjVar.zzd(size + size);
                                            unsafe9.putObject(obj2, j2, zzmjVar);
                                        }
                                        switch (zzr) {
                                            case 18:
                                            case 35:
                                                unsafe4 = unsafe9;
                                                i11 = i70;
                                                i23 = i22;
                                                if (i50 != 2) {
                                                    if (i50 == 1) {
                                                        i24 = i23 + 8;
                                                        int i71 = zzkt.zza;
                                                        zzlm zzlmVar = (zzlm) zzmjVar;
                                                        zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, i23)));
                                                        while (i24 < i2) {
                                                            int zzh5 = zzkt.zzh(bArr, i24, zzksVar4);
                                                            if (i11 != zzksVar4.zza) {
                                                                i22 = i23;
                                                                i38 = i24;
                                                                break;
                                                            } else {
                                                                zzlmVar.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, zzh5)));
                                                                i24 = zzh5 + 8;
                                                            }
                                                        }
                                                        i22 = i23;
                                                        i38 = i24;
                                                    }
                                                    i22 = i23;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int i72 = zzkt.zza;
                                                    zzlm zzlmVar2 = (zzlm) zzmjVar;
                                                    zzh = zzkt.zzh(bArr, i23, zzksVar4);
                                                    int i73 = zzksVar4.zza;
                                                    int i74 = zzh + i73;
                                                    if (i74 <= bArr.length) {
                                                        zzlmVar2.zzg(zzlmVar2.size() + (i73 / 8));
                                                        while (zzh < i74) {
                                                            zzlmVar2.zzf(Double.longBitsToDouble(zzkt.zzn(bArr, zzh)));
                                                            zzh += 8;
                                                        }
                                                        if (zzh != i74) {
                                                            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        i22 = i23;
                                                        i38 = zzh;
                                                        break;
                                                    } else {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                }
                                            case 19:
                                            case 36:
                                                unsafe4 = unsafe9;
                                                i11 = i70;
                                                i23 = i22;
                                                if (i50 != 2) {
                                                    if (i50 == 5) {
                                                        i24 = i23 + 4;
                                                        int i75 = zzkt.zza;
                                                        zzlw zzlwVar = (zzlw) zzmjVar;
                                                        zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, i23)));
                                                        while (i24 < i2) {
                                                            int zzh6 = zzkt.zzh(bArr, i24, zzksVar4);
                                                            if (i11 != zzksVar4.zza) {
                                                                i22 = i23;
                                                                i38 = i24;
                                                                break;
                                                            } else {
                                                                zzlwVar.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, zzh6)));
                                                                i24 = zzh6 + 4;
                                                            }
                                                        }
                                                        i22 = i23;
                                                        i38 = i24;
                                                    }
                                                    i22 = i23;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int i76 = zzkt.zza;
                                                    zzlw zzlwVar2 = (zzlw) zzmjVar;
                                                    zzh = zzkt.zzh(bArr, i23, zzksVar4);
                                                    int i77 = zzksVar4.zza;
                                                    int i78 = zzh + i77;
                                                    if (i78 <= bArr.length) {
                                                        zzlwVar2.zzg(zzlwVar2.size() + (i77 / 4));
                                                        while (zzh < i78) {
                                                            zzlwVar2.zzf(Float.intBitsToFloat(zzkt.zzb(bArr, zzh)));
                                                            zzh += 4;
                                                        }
                                                        if (zzh != i78) {
                                                            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        i22 = i23;
                                                        i38 = zzh;
                                                        break;
                                                    } else {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                }
                                            case 20:
                                            case 21:
                                            case 37:
                                            case 38:
                                                unsafe4 = unsafe9;
                                                i11 = i70;
                                                i23 = i22;
                                                if (i50 != 2) {
                                                    if (i50 == 0) {
                                                        int i79 = zzkt.zza;
                                                        zzmw zzmwVar = (zzmw) zzmjVar;
                                                        i24 = zzkt.zzk(bArr, i23, zzksVar4);
                                                        zzmwVar.zzg(zzksVar4.zzb);
                                                        while (i24 < i2) {
                                                            int zzh7 = zzkt.zzh(bArr, i24, zzksVar4);
                                                            if (i11 != zzksVar4.zza) {
                                                                i22 = i23;
                                                                i38 = i24;
                                                                break;
                                                            } else {
                                                                i24 = zzkt.zzk(bArr, zzh7, zzksVar4);
                                                                zzmwVar.zzg(zzksVar4.zzb);
                                                            }
                                                        }
                                                        i22 = i23;
                                                        i38 = i24;
                                                    }
                                                    i22 = i23;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int i80 = zzkt.zza;
                                                    zzmw zzmwVar2 = (zzmw) zzmjVar;
                                                    zzh = zzkt.zzh(bArr, i23, zzksVar4);
                                                    int i81 = zzksVar4.zza + zzh;
                                                    while (zzh < i81) {
                                                        zzh = zzkt.zzk(bArr, zzh, zzksVar4);
                                                        zzmwVar2.zzg(zzksVar4.zzb);
                                                    }
                                                    if (zzh != i81) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    i22 = i23;
                                                    i38 = zzh;
                                                    break;
                                                }
                                            case 22:
                                            case 29:
                                            case 39:
                                            case 43:
                                                unsafe4 = unsafe9;
                                                i11 = i70;
                                                if (i50 != 2) {
                                                    if (i50 != 0) {
                                                        i38 = i22;
                                                        break;
                                                    } else {
                                                        zzh = zzkt.zzj(i11, bArr, i22, i2, zzmjVar, zzksVar4);
                                                        i38 = zzh;
                                                        break;
                                                    }
                                                } else {
                                                    i24 = zzkt.zzf(bArr, i22, zzmjVar, zzksVar4);
                                                    i38 = i24;
                                                    break;
                                                }
                                            case 23:
                                            case 32:
                                            case 40:
                                            case 46:
                                                unsafe4 = unsafe9;
                                                int i82 = i69;
                                                i11 = i70;
                                                if (i50 != 2) {
                                                    i69 = i82;
                                                    if (i50 == 1) {
                                                        i24 = i22 + 8;
                                                        int i83 = zzkt.zza;
                                                        zzmw zzmwVar3 = (zzmw) zzmjVar;
                                                        zzmwVar3.zzg(zzkt.zzn(bArr, i22));
                                                        while (i24 < i2) {
                                                            int zzh8 = zzkt.zzh(bArr, i24, zzksVar4);
                                                            if (i11 != zzksVar4.zza) {
                                                                i38 = i24;
                                                                break;
                                                            } else {
                                                                zzmwVar3.zzg(zzkt.zzn(bArr, zzh8));
                                                                i24 = zzh8 + 8;
                                                            }
                                                        }
                                                        i38 = i24;
                                                    }
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int i84 = zzkt.zza;
                                                    zzmw zzmwVar4 = (zzmw) zzmjVar;
                                                    zzh2 = zzkt.zzh(bArr, i22, zzksVar4);
                                                    int i85 = zzksVar4.zza;
                                                    int i86 = zzh2 + i85;
                                                    if (i86 <= bArr.length) {
                                                        zzmwVar4.zzh(zzmwVar4.size() + (i85 / 8));
                                                        while (zzh2 < i86) {
                                                            zzmwVar4.zzg(zzkt.zzn(bArr, zzh2));
                                                            zzh2 += 8;
                                                            i82 = i82;
                                                        }
                                                        i69 = i82;
                                                        if (zzh2 != i86) {
                                                            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        i38 = zzh2;
                                                        break;
                                                    } else {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                }
                                            case 24:
                                            case 31:
                                            case 41:
                                            case 45:
                                                unsafe4 = unsafe9;
                                                i25 = i69;
                                                i11 = i70;
                                                if (i50 != 2) {
                                                    if (i50 == 5) {
                                                        i26 = i22 + 4;
                                                        int i87 = zzkt.zza;
                                                        zzme zzmeVar = (zzme) zzmjVar;
                                                        zzmeVar.zzh(zzkt.zzb(bArr, i22));
                                                        while (i26 < i2) {
                                                            int zzh9 = zzkt.zzh(bArr, i26, zzksVar4);
                                                            if (i11 == zzksVar4.zza) {
                                                                zzmeVar.zzh(zzkt.zzb(bArr, zzh9));
                                                                i26 = zzh9 + 4;
                                                            } else {
                                                                i38 = i26;
                                                                i69 = i25;
                                                            }
                                                        }
                                                        i38 = i26;
                                                        i69 = i25;
                                                    }
                                                    i69 = i25;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int i88 = zzkt.zza;
                                                    zzme zzmeVar2 = (zzme) zzmjVar;
                                                    zzh3 = zzkt.zzh(bArr, i22, zzksVar4);
                                                    int i89 = zzksVar4.zza;
                                                    int i90 = zzh3 + i89;
                                                    if (i90 <= bArr.length) {
                                                        zzmeVar2.zzi(zzmeVar2.size() + (i89 / 4));
                                                        while (zzh3 < i90) {
                                                            zzmeVar2.zzh(zzkt.zzb(bArr, zzh3));
                                                            zzh3 += 4;
                                                        }
                                                        if (zzh3 != i90) {
                                                            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        i38 = zzh3;
                                                        i69 = i25;
                                                        break;
                                                    } else {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                }
                                            case 25:
                                            case 42:
                                                unsafe4 = unsafe9;
                                                i25 = i69;
                                                i11 = i70;
                                                if (i50 != 2) {
                                                    if (i50 == 0) {
                                                        int i91 = zzkt.zza;
                                                        zzku zzkuVar = (zzku) zzmjVar;
                                                        i26 = zzkt.zzk(bArr, i22, zzksVar4);
                                                        zzkuVar.zze(zzksVar4.zzb != 0);
                                                        while (i26 < i2) {
                                                            int zzh10 = zzkt.zzh(bArr, i26, zzksVar4);
                                                            if (i11 == zzksVar4.zza) {
                                                                i26 = zzkt.zzk(bArr, zzh10, zzksVar4);
                                                                zzkuVar.zze(zzksVar4.zzb != 0);
                                                            } else {
                                                                i38 = i26;
                                                                i69 = i25;
                                                            }
                                                        }
                                                        i38 = i26;
                                                        i69 = i25;
                                                    }
                                                    i69 = i25;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int i92 = zzkt.zza;
                                                    zzku zzkuVar2 = (zzku) zzmjVar;
                                                    zzh3 = zzkt.zzh(bArr, i22, zzksVar4);
                                                    int i93 = zzksVar4.zza + zzh3;
                                                    while (zzh3 < i93) {
                                                        zzh3 = zzkt.zzk(bArr, zzh3, zzksVar4);
                                                        zzkuVar2.zze(zzksVar4.zzb != 0);
                                                    }
                                                    if (zzh3 != i93) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    i38 = zzh3;
                                                    i69 = i25;
                                                    break;
                                                }
                                            case 26:
                                                unsafe4 = unsafe9;
                                                i25 = i69;
                                                i11 = i70;
                                                if (i50 == 2) {
                                                    if ((j & 536870912) == 0) {
                                                        i26 = zzkt.zzh(bArr, i22, zzksVar4);
                                                        int i94 = zzksVar4.zza;
                                                        if (i94 < 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i94 == 0) {
                                                            obj5 = "";
                                                            zzmjVar.add(obj5);
                                                            while (i26 < i2) {
                                                                int zzh11 = zzkt.zzh(bArr, i26, zzksVar4);
                                                                if (i11 == zzksVar4.zza) {
                                                                    i26 = zzkt.zzh(bArr, zzh11, zzksVar4);
                                                                    i94 = zzksVar4.zza;
                                                                    if (i94 < 0) {
                                                                        throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                    }
                                                                    if (i94 == 0) {
                                                                        zzmjVar.add(obj5);
                                                                    } else {
                                                                        zzmjVar.add(new String(bArr, i26, i94, zzmk.zza));
                                                                        i26 += i94;
                                                                        while (i26 < i2) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            obj5 = "";
                                                            zzmjVar.add(new String(bArr, i26, i94, zzmk.zza));
                                                            i26 += i94;
                                                            while (i26 < i2) {
                                                            }
                                                        }
                                                    } else {
                                                        i26 = zzkt.zzh(bArr, i22, zzksVar4);
                                                        int i95 = zzksVar4.zza;
                                                        if (i95 < 0) {
                                                            throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i95 == 0) {
                                                            zzmjVar.add("");
                                                            while (i26 < i2) {
                                                                int zzh12 = zzkt.zzh(bArr, i26, zzksVar4);
                                                                if (i11 == zzksVar4.zza) {
                                                                    i26 = zzkt.zzh(bArr, zzh12, zzksVar4);
                                                                    int i96 = zzksVar4.zza;
                                                                    if (i96 < 0) {
                                                                        throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                    }
                                                                    if (i96 == 0) {
                                                                        zzmjVar.add("");
                                                                    } else {
                                                                        int i97 = i26 + i96;
                                                                        if (zzoo.zzd(bArr, i26, i97)) {
                                                                            i27 = i97;
                                                                            zzmjVar.add(new String(bArr, i26, i96, zzmk.zza));
                                                                            i26 = i27;
                                                                            while (i26 < i2) {
                                                                            }
                                                                        } else {
                                                                            throw new zzmm("Protocol message had invalid UTF-8.");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            int i98 = i26 + i95;
                                                            if (zzoo.zzd(bArr, i26, i98)) {
                                                                i27 = i98;
                                                                zzmjVar.add(new String(bArr, i26, i95, zzmk.zza));
                                                                i26 = i27;
                                                                while (i26 < i2) {
                                                                }
                                                            } else {
                                                                throw new zzmm("Protocol message had invalid UTF-8.");
                                                            }
                                                        }
                                                    }
                                                    i38 = i26;
                                                    i69 = i25;
                                                    break;
                                                }
                                                i69 = i25;
                                                i38 = i22;
                                                break;
                                            case 27:
                                                unsafe4 = unsafe9;
                                                i25 = i69;
                                                if (i50 != 2) {
                                                    i11 = i70;
                                                    i69 = i25;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    i38 = zzkt.zze(zzv(i6), i70, bArr, i22, i2, zzmjVar, zzksVar4);
                                                    i11 = i70;
                                                    zzksVar4 = zzksVar4;
                                                    i69 = i25;
                                                    break;
                                                }
                                            case 28:
                                                unsafe4 = unsafe9;
                                                i25 = i69;
                                                if (i50 != 2) {
                                                    i11 = i70;
                                                    i69 = i25;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int zzh13 = zzkt.zzh(bArr, i22, zzksVar4);
                                                    int i99 = zzksVar4.zza;
                                                    if (i99 >= 0) {
                                                        if (i99 > bArr.length - zzh13) {
                                                            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        if (i99 == 0) {
                                                            zzmjVar.add(zzld.zzb);
                                                            while (zzh13 < i2) {
                                                                int zzh14 = zzkt.zzh(bArr, zzh13, zzksVar4);
                                                                if (i70 != zzksVar4.zza) {
                                                                    i11 = i70;
                                                                    i38 = zzh13;
                                                                    i69 = i25;
                                                                    break;
                                                                } else {
                                                                    zzh13 = zzkt.zzh(bArr, zzh14, zzksVar4);
                                                                    i99 = zzksVar4.zza;
                                                                    if (i99 >= 0) {
                                                                        if (i99 > bArr.length - zzh13) {
                                                                            throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                        }
                                                                        if (i99 == 0) {
                                                                            zzmjVar.add(zzld.zzb);
                                                                        } else {
                                                                            zzmjVar.add(zzld.zzj(bArr, zzh13, i99));
                                                                            zzh13 += i99;
                                                                            while (zzh13 < i2) {
                                                                            }
                                                                        }
                                                                    } else {
                                                                        throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                    }
                                                                }
                                                            }
                                                            i11 = i70;
                                                            i38 = zzh13;
                                                            i69 = i25;
                                                        } else {
                                                            zzmjVar.add(zzld.zzj(bArr, zzh13, i99));
                                                            zzh13 += i99;
                                                            while (zzh13 < i2) {
                                                            }
                                                            i11 = i70;
                                                            i38 = zzh13;
                                                            i69 = i25;
                                                        }
                                                    } else {
                                                        throw new zzmm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                }
                                            case 30:
                                            case 44:
                                                if (i50 != 2) {
                                                    if (i50 != 0) {
                                                        unsafe4 = unsafe9;
                                                        i11 = i70;
                                                        i38 = i22;
                                                        break;
                                                    } else {
                                                        int zzj = zzkt.zzj(i70, bArr, i22, i2, zzmjVar, zzksVar4);
                                                        i70 = i70;
                                                        i28 = zzj;
                                                    }
                                                } else {
                                                    i28 = zzkt.zzf(bArr, i22, zzmjVar, zzksVar4);
                                                }
                                                zzmg zzu2 = zzu(i6);
                                                zzoe zzoeVar = this.zzl;
                                                int i100 = zznu.zza;
                                                if (zzu2 == null) {
                                                    i29 = i28;
                                                    unsafe4 = unsafe9;
                                                    i30 = i69;
                                                } else if (zzmjVar instanceof RandomAccess) {
                                                    int size2 = zzmjVar.size();
                                                    i29 = i28;
                                                    Object obj7 = null;
                                                    int i101 = 0;
                                                    int i102 = 0;
                                                    while (i101 < size2) {
                                                        Unsafe unsafe10 = unsafe9;
                                                        int intValue = ((Integer) zzmjVar.get(i101)).intValue();
                                                        if (zzu2.zza(intValue)) {
                                                            if (i101 != i102) {
                                                                zzmjVar.set(i102, Integer.valueOf(intValue));
                                                            }
                                                            i102++;
                                                            i31 = i101;
                                                            i32 = i69;
                                                        } else {
                                                            i31 = i101;
                                                            i32 = i69;
                                                            obj7 = zznu.zzn(obj2, i32, intValue, obj7, zzoeVar);
                                                        }
                                                        i69 = i32;
                                                        i101 = i31 + 1;
                                                        unsafe9 = unsafe10;
                                                    }
                                                    unsafe4 = unsafe9;
                                                    i30 = i69;
                                                    if (i102 != size2) {
                                                        zzmjVar.subList(i102, size2).clear();
                                                    }
                                                } else {
                                                    i29 = i28;
                                                    unsafe4 = unsafe9;
                                                    i30 = i69;
                                                    Iterator it = zzmjVar.iterator();
                                                    Object obj8 = null;
                                                    while (it.hasNext()) {
                                                        int intValue2 = ((Integer) it.next()).intValue();
                                                        if (!zzu2.zza(intValue2)) {
                                                            obj8 = zznu.zzn(obj2, i30, intValue2, obj8, zzoeVar);
                                                            it.remove();
                                                        }
                                                    }
                                                }
                                                i11 = i70;
                                                i69 = i30;
                                                i38 = i29;
                                                break;
                                            case 33:
                                            case 47:
                                                if (i50 != 2) {
                                                    if (i50 == 0) {
                                                        int i103 = zzkt.zza;
                                                        zzme zzmeVar3 = (zzme) zzmjVar;
                                                        i24 = zzkt.zzh(bArr, i22, zzksVar4);
                                                        zzmeVar3.zzh(zzlg.zzb(zzksVar4.zza));
                                                        while (i24 < i2) {
                                                            int zzh15 = zzkt.zzh(bArr, i24, zzksVar4);
                                                            if (i70 != zzksVar4.zza) {
                                                                unsafe4 = unsafe9;
                                                                i11 = i70;
                                                                i38 = i24;
                                                                break;
                                                            } else {
                                                                i24 = zzkt.zzh(bArr, zzh15, zzksVar4);
                                                                zzmeVar3.zzh(zzlg.zzb(zzksVar4.zza));
                                                            }
                                                        }
                                                        unsafe4 = unsafe9;
                                                        i11 = i70;
                                                        i38 = i24;
                                                    }
                                                    unsafe4 = unsafe9;
                                                    i11 = i70;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int i104 = zzkt.zza;
                                                    zzme zzmeVar4 = (zzme) zzmjVar;
                                                    zzh2 = zzkt.zzh(bArr, i22, zzksVar4);
                                                    int i105 = zzksVar4.zza + zzh2;
                                                    while (zzh2 < i105) {
                                                        zzh2 = zzkt.zzh(bArr, zzh2, zzksVar4);
                                                        zzmeVar4.zzh(zzlg.zzb(zzksVar4.zza));
                                                    }
                                                    if (zzh2 != i105) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    unsafe4 = unsafe9;
                                                    i11 = i70;
                                                    i38 = zzh2;
                                                    break;
                                                }
                                            case 34:
                                            case 48:
                                                if (i50 != 2) {
                                                    if (i50 == 0) {
                                                        int i106 = zzkt.zza;
                                                        zzmw zzmwVar5 = (zzmw) zzmjVar;
                                                        i24 = zzkt.zzk(bArr, i22, zzksVar4);
                                                        zzmwVar5.zzg(zzlg.zzc(zzksVar4.zzb));
                                                        while (i24 < i2) {
                                                            int zzh16 = zzkt.zzh(bArr, i24, zzksVar4);
                                                            if (i70 != zzksVar4.zza) {
                                                                unsafe4 = unsafe9;
                                                                i11 = i70;
                                                                i38 = i24;
                                                                break;
                                                            } else {
                                                                i24 = zzkt.zzk(bArr, zzh16, zzksVar4);
                                                                zzmwVar5.zzg(zzlg.zzc(zzksVar4.zzb));
                                                            }
                                                        }
                                                        unsafe4 = unsafe9;
                                                        i11 = i70;
                                                        i38 = i24;
                                                    }
                                                    unsafe4 = unsafe9;
                                                    i11 = i70;
                                                    i38 = i22;
                                                    break;
                                                } else {
                                                    int i107 = zzkt.zza;
                                                    zzmw zzmwVar6 = (zzmw) zzmjVar;
                                                    zzh2 = zzkt.zzh(bArr, i22, zzksVar4);
                                                    int i108 = zzksVar4.zza + zzh2;
                                                    while (zzh2 < i108) {
                                                        zzh2 = zzkt.zzk(bArr, zzh2, zzksVar4);
                                                        zzmwVar6.zzg(zzlg.zzc(zzksVar4.zzb));
                                                    }
                                                    if (zzh2 != i108) {
                                                        throw new zzmm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                    }
                                                    unsafe4 = unsafe9;
                                                    i11 = i70;
                                                    i38 = zzh2;
                                                    break;
                                                }
                                            default:
                                                byte[] bArr16 = bArr;
                                                unsafe4 = unsafe9;
                                                int i109 = i2;
                                                i11 = i70;
                                                i23 = i22;
                                                if (i50 == 3) {
                                                    int i110 = (i11 & (-8)) | 4;
                                                    zzns zzv = zzv(i6);
                                                    int zzc = zzkt.zzc(zzv, bArr16, i23, i109, i110, zzksVar4);
                                                    i22 = i23;
                                                    zzmjVar.add(zzksVar4.zzc);
                                                    while (zzc < i109) {
                                                        int zzh17 = zzkt.zzh(bArr16, zzc, zzksVar4);
                                                        if (i11 != zzksVar4.zza) {
                                                            i38 = zzc;
                                                            break;
                                                        } else {
                                                            zzc = zzkt.zzc(zzv, bArr16, zzh17, i109, i110, zzksVar4);
                                                            zzmjVar.add(zzksVar4.zzc);
                                                            bArr16 = bArr;
                                                            i109 = i2;
                                                        }
                                                    }
                                                    i38 = zzc;
                                                }
                                                i22 = i23;
                                                i38 = i22;
                                                break;
                                        }
                                        if (i38 != i22) {
                                            bArr6 = bArr;
                                            i36 = i2;
                                            obj6 = obj2;
                                            i39 = i6;
                                            i43 = i8;
                                            i37 = 0;
                                            i41 = i9;
                                            unsafe5 = unsafe4;
                                            i42 = i69;
                                            zzksVar5 = zzksVar4;
                                            i40 = i11;
                                        } else {
                                            i4 = i3;
                                            zzksVar2 = zzksVar4;
                                            unsafe = unsafe4;
                                            i10 = i69;
                                        }
                                    } else {
                                        i11 = i70;
                                        if (zzr != 50) {
                                            unsafe = unsafe9;
                                            long j4 = iArr[i6 + 2] & 1048575;
                                            switch (zzr) {
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    if (i50 == 1) {
                                                        i35 = i34 + 8;
                                                        unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzkt.zzn(bArr2, i34))));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = i35;
                                                        break;
                                                    }
                                                    i38 = i34;
                                                    break;
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    if (i50 == 5) {
                                                        i35 = i34 + 4;
                                                        unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzkt.zzb(bArr2, i34))));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = i35;
                                                        break;
                                                    }
                                                    i38 = i34;
                                                    break;
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    if (i50 == 0) {
                                                        i35 = zzkt.zzk(bArr2, i34, zzksVar2);
                                                        unsafe.putObject(obj2, j2, Long.valueOf(zzksVar2.zzb));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = i35;
                                                        break;
                                                    }
                                                    i38 = i34;
                                                    break;
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                                case 62:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    if (i50 == 0) {
                                                        i35 = zzkt.zzh(bArr2, i34, zzksVar2);
                                                        unsafe.putObject(obj2, j2, Integer.valueOf(zzksVar2.zza));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = i35;
                                                        break;
                                                    }
                                                    i38 = i34;
                                                    break;
                                                case 56:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    if (i50 == 1) {
                                                        i35 = i34 + 8;
                                                        unsafe.putObject(obj2, j2, Long.valueOf(zzkt.zzn(bArr2, i34)));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = i35;
                                                        break;
                                                    }
                                                    i38 = i34;
                                                    break;
                                                case 57:
                                                case 64:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    if (i50 == 5) {
                                                        i35 = i34 + 4;
                                                        unsafe.putObject(obj2, j2, Integer.valueOf(zzkt.zzb(bArr2, i34)));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = i35;
                                                        break;
                                                    }
                                                    i38 = i34;
                                                    break;
                                                case 58:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    if (i50 == 0) {
                                                        i35 = zzkt.zzk(bArr2, i34, zzksVar2);
                                                        unsafe.putObject(obj2, j2, Boolean.valueOf(zzksVar2.zzb != 0));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = i35;
                                                        break;
                                                    }
                                                    i38 = i34;
                                                    break;
                                                case 59:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    if (i50 == 2) {
                                                        i35 = zzkt.zzh(bArr2, i34, zzksVar2);
                                                        int i111 = zzksVar2.zza;
                                                        if (i111 == 0) {
                                                            unsafe.putObject(obj2, j2, "");
                                                        } else {
                                                            int i112 = i35 + i111;
                                                            if ((i51 & C.BUFFER_FLAG_LAST_SAMPLE) == 0 || zzoo.zzd(bArr2, i35, i112)) {
                                                                unsafe.putObject(obj2, j2, new String(bArr2, i35, i111, zzmk.zza));
                                                                i35 = i112;
                                                            } else {
                                                                throw new zzmm("Protocol message had invalid UTF-8.");
                                                            }
                                                        }
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = i35;
                                                        break;
                                                    }
                                                    i38 = i34;
                                                    break;
                                                case 60:
                                                    i10 = i69;
                                                    if (i50 != 2) {
                                                        zzksVar2 = zzksVar4;
                                                        bArr2 = bArr;
                                                        i34 = i22;
                                                        i33 = i6;
                                                        i38 = i34;
                                                        break;
                                                    } else {
                                                        Object zzy = zzy(obj2, i10, i6);
                                                        int zzm2 = zzkt.zzm(zzy, zzv(i6), bArr, i22, i2, zzksVar4);
                                                        zzksVar2 = zzksVar4;
                                                        bArr2 = bArr;
                                                        zzG(obj2, i10, i6, zzy);
                                                        i38 = zzm2;
                                                        i34 = i22;
                                                        i33 = i6;
                                                        break;
                                                    }
                                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                    bArr5 = bArr;
                                                    i10 = i69;
                                                    if (i50 == 2) {
                                                        zza2 = zzkt.zza(bArr5, i22, zzksVar4);
                                                        unsafe.putObject(obj2, j2, zzksVar4.zzc);
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = zza2;
                                                        i33 = i6;
                                                        i34 = i22;
                                                        zzksVar2 = zzksVar4;
                                                        bArr2 = bArr5;
                                                        break;
                                                    }
                                                    i33 = i6;
                                                    i34 = i22;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr5;
                                                    i38 = i34;
                                                    break;
                                                case 63:
                                                    bArr5 = bArr;
                                                    i33 = i6;
                                                    i10 = i69;
                                                    if (i50 == 0) {
                                                        zza2 = zzkt.zzh(bArr5, i22, zzksVar4);
                                                        int i113 = zzksVar4.zza;
                                                        i6 = i33;
                                                        zzmg zzu3 = zzu(i6);
                                                        if (zzu3 == null || zzu3.zza(i113)) {
                                                            unsafe.putObject(obj2, j2, Integer.valueOf(i113));
                                                            unsafe.putInt(obj2, j4, i10);
                                                        } else {
                                                            zzd(obj2).zzj(i11, Long.valueOf(i113));
                                                        }
                                                        i38 = zza2;
                                                        i33 = i6;
                                                        i34 = i22;
                                                        zzksVar2 = zzksVar4;
                                                        bArr2 = bArr5;
                                                        break;
                                                    }
                                                    i34 = i22;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr5;
                                                    i38 = i34;
                                                    break;
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                    bArr5 = bArr;
                                                    i33 = i6;
                                                    i10 = i69;
                                                    if (i50 == 0) {
                                                        zzh4 = zzkt.zzh(bArr5, i22, zzksVar4);
                                                        unsafe.putObject(obj2, j2, Integer.valueOf(zzlg.zzb(zzksVar4.zza)));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = zzh4;
                                                        i34 = i22;
                                                        zzksVar2 = zzksVar4;
                                                        bArr2 = bArr5;
                                                        break;
                                                    }
                                                    i34 = i22;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr5;
                                                    i38 = i34;
                                                    break;
                                                case 67:
                                                    bArr5 = bArr;
                                                    i10 = i69;
                                                    if (i50 == 0) {
                                                        zzh4 = zzkt.zzk(bArr5, i22, zzksVar4);
                                                        i33 = i6;
                                                        unsafe.putObject(obj2, j2, Long.valueOf(zzlg.zzc(zzksVar4.zzb)));
                                                        unsafe.putInt(obj2, j4, i10);
                                                        i38 = zzh4;
                                                        i34 = i22;
                                                        zzksVar2 = zzksVar4;
                                                        bArr2 = bArr5;
                                                        break;
                                                    }
                                                    i33 = i6;
                                                    i34 = i22;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr5;
                                                    i38 = i34;
                                                    break;
                                                case 68:
                                                    if (i50 != 3) {
                                                        i10 = i69;
                                                        i33 = i6;
                                                        i34 = i22;
                                                        zzksVar2 = zzksVar4;
                                                        bArr2 = bArr;
                                                        i38 = i34;
                                                        break;
                                                    } else {
                                                        i10 = i69;
                                                        Object zzy2 = zzy(obj2, i10, i6);
                                                        int zzl2 = zzkt.zzl(zzy2, zzv(i6), bArr, i22, i2, (i11 & (-8)) | 4, zzksVar);
                                                        zzksVar4 = zzksVar;
                                                        bArr5 = bArr;
                                                        zzG(obj2, i10, i6, zzy2);
                                                        i38 = zzl2;
                                                        i33 = i6;
                                                        i34 = i22;
                                                        zzksVar2 = zzksVar4;
                                                        bArr2 = bArr5;
                                                        break;
                                                    }
                                                default:
                                                    i33 = i6;
                                                    i34 = i22;
                                                    i10 = i69;
                                                    zzksVar2 = zzksVar4;
                                                    bArr2 = bArr;
                                                    i38 = i34;
                                                    break;
                                            }
                                            if (i38 != i34) {
                                                i36 = i2;
                                                bArr6 = bArr2;
                                                unsafe5 = unsafe;
                                                obj6 = obj2;
                                                i40 = i11;
                                                i42 = i10;
                                                zzksVar5 = zzksVar2;
                                                i43 = i8;
                                                i37 = 0;
                                                i41 = i9;
                                                i39 = i33;
                                            } else {
                                                i4 = i3;
                                                i6 = i33;
                                            }
                                        } else if (i50 == 2) {
                                            Object zzw = zzw(i6);
                                            Object object = unsafe9.getObject(obj2, j2);
                                            if (!((zznb) object).zze()) {
                                                zznb zzb2 = zznb.zza().zzb();
                                                zznc.zza(zzb2, object);
                                                unsafe9.putObject(obj2, j2, zzb2);
                                            }
                                            zzna zznaVar = (zzna) zzw;
                                            throw null;
                                        } else {
                                            unsafe = unsafe9;
                                            i4 = i3;
                                            i38 = i22;
                                            i10 = i69;
                                            zzksVar2 = zzksVar4;
                                        }
                                    }
                                } else if (i50 == 2) {
                                    zzmj zzmjVar2 = (zzmj) unsafe8.getObject(obj2, j2);
                                    if (!zzmjVar2.zzc()) {
                                        int size3 = zzmjVar2.size();
                                        zzmjVar2 = zzmjVar2.zzd(size3 == 0 ? 10 : size3 + size3);
                                        unsafe8.putObject(obj2, j2, zzmjVar2);
                                    }
                                    int zze = zzkt.zze(zzv(i6), i47, bArr, i38, i2, zzmjVar2, zzksVar);
                                    bArr6 = bArr;
                                    i36 = i2;
                                    i40 = i47;
                                    obj6 = obj2;
                                    i39 = i6;
                                    i37 = 0;
                                    i42 = i69;
                                    zzksVar5 = zzksVar;
                                    i38 = zze;
                                    unsafe5 = unsafe8;
                                } else {
                                    zzksVar4 = zzksVar;
                                    unsafe = unsafe8;
                                    i9 = i41;
                                    i22 = i38;
                                    i11 = i47;
                                    i8 = i43;
                                    i4 = i3;
                                    i38 = i22;
                                    i10 = i69;
                                    zzksVar2 = zzksVar4;
                                }
                                bArr2 = bArr;
                            }
                        }
                        if (i11 == i4 || i4 == 0) {
                            if (this.zzh) {
                                zzlp zzlpVar = zzksVar2.zzd;
                                int i114 = zzlp.zzb;
                                int i115 = zznp.zza;
                                if (zzlpVar != zzlp.zza) {
                                    zznh zznhVar = this.zzg;
                                    int i116 = zzkt.zza;
                                    if (zzlpVar.zzb(zznhVar, i10) == null) {
                                        i13 = i2;
                                        i12 = i11;
                                        i38 = zzkt.zzg(i12, bArr2, i38, i13, zzd(obj2), zzksVar2);
                                        bArr6 = bArr;
                                        i40 = i12;
                                        i36 = i13;
                                        unsafe5 = unsafe;
                                        obj6 = obj2;
                                        i39 = i6;
                                        i42 = i10;
                                        i43 = i8;
                                        i37 = i7;
                                        i41 = i9;
                                        zzksVar5 = zzksVar;
                                    } else {
                                        zzma zzmaVar = (zzma) obj2;
                                        throw null;
                                    }
                                }
                            }
                            i12 = i11;
                            i13 = i2;
                            i38 = zzkt.zzg(i12, bArr, i38, i13, zzd(obj2), zzksVar);
                            bArr6 = bArr;
                            i40 = i12;
                            i36 = i13;
                            unsafe5 = unsafe;
                            obj6 = obj2;
                            i39 = i6;
                            i42 = i10;
                            i43 = i8;
                            i37 = i7;
                            i41 = i9;
                            zzksVar5 = zzksVar;
                        } else {
                            i5 = i2;
                            i40 = i11;
                            i43 = i8;
                            i41 = i9;
                        }
                    }
                    zzq = -1;
                    if (zzq != -1) {
                    }
                    if (i11 == i4) {
                    }
                    if (this.zzh) {
                    }
                    i12 = i11;
                    i13 = i2;
                    i38 = zzkt.zzg(i12, bArr, i38, i13, zzd(obj2), zzksVar);
                    bArr6 = bArr;
                    i40 = i12;
                    i36 = i13;
                    unsafe5 = unsafe;
                    obj6 = obj2;
                    i39 = i6;
                    i42 = i10;
                    i43 = i8;
                    i37 = i7;
                    i41 = i9;
                    zzksVar5 = zzksVar;
                }
            } else {
                i4 = i3;
                unsafe = unsafe5;
                obj2 = obj6;
                i5 = i36;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final Object zze() {
        return ((zzmd) this.zzg).zzcj();
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzmd) {
                zzmd zzmdVar = (zzmd) obj;
                zzmdVar.zzcu(Integer.MAX_VALUE);
                zzmdVar.zza = 0;
                zzmdVar.zzcs();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j = i2;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                ((zzmj) zzol.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zznb) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                }
                if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i < iArr.length) {
                int zzs = zzs(i);
                int i2 = 1048575 & zzs;
                int zzr = zzr(zzs);
                int i3 = iArr[i];
                long j = i2;
                switch (zzr) {
                    case 0:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzo(obj, j, zzol.zza(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzp(obj, j, zzol.zzb(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzm(obj, j, zzol.zzw(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzs(obj, j, zzol.zzf(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 9:
                        zzB(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzs(obj, j, zzol.zzf(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzq(obj, j, zzol.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzol.zzr(obj, j, zzol.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 17:
                        zzB(obj, obj2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        zzmj zzmjVar = (zzmj) zzol.zzf(obj, j);
                        zzmj zzmjVar2 = (zzmj) zzol.zzf(obj2, j);
                        int size = zzmjVar.size();
                        int size2 = zzmjVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzmjVar.zzc()) {
                                zzmjVar = zzmjVar.zzd(size2 + size);
                            }
                            zzmjVar.addAll(zzmjVar2);
                        }
                        if (size > 0) {
                            zzmjVar2 = zzmjVar;
                        }
                        zzol.zzs(obj, j, zzmjVar2);
                        break;
                    case 50:
                        int i4 = zznu.zza;
                        zzol.zzs(obj, j, zznc.zza(zzol.zzf(obj, j), zzol.zzf(obj2, j)));
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzol.zzs(obj, j, zzol.zzf(obj2, j));
                            zzE(obj, i3, i);
                            break;
                        }
                    case 60:
                        zzC(obj, obj2, i);
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    case 62:
                    case 63:
                    case 64:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    case 67:
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzol.zzs(obj, j, zzol.zzf(obj2, j));
                            zzE(obj, i3, i);
                            break;
                        }
                    case 68:
                        zzC(obj, obj2, i);
                        break;
                }
                i += 3;
            } else {
                zznu.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zznu.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzks zzksVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzksVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04c7  */
    @Override // com.google.android.gms.internal.measurement.zzns
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(Object obj, zzor zzorVar) throws IOException {
        Map.Entry entry;
        int[] iArr;
        int i;
        int i2;
        int i3;
        zznk<T> zznkVar = this;
        if (zznkVar.zzh) {
            zzlu zzluVar = ((zzma) obj).zzb;
            if (!zzluVar.zza.isEmpty()) {
                entry = (Map.Entry) zzluVar.zze().next();
                iArr = zznkVar.zzc;
                Unsafe unsafe = zzb;
                int i4 = 1048575;
                int i5 = 1048575;
                i = 0;
                int i6 = 0;
                while (i < iArr.length) {
                    int zzs = zznkVar.zzs(i);
                    int zzr = zzr(zzs);
                    int i7 = iArr[i];
                    if (zzr <= 17) {
                        int i8 = iArr[i + 2];
                        int i9 = i8 & i4;
                        if (i9 != i5) {
                            i6 = i9 == i4 ? 0 : unsafe.getInt(obj, i9);
                            i5 = i9;
                        }
                        i2 = zzs;
                        i3 = 1 << (i8 >>> 20);
                    } else {
                        i2 = zzs;
                        i3 = 0;
                    }
                    if (entry == null) {
                        long j = i2 & i4;
                        switch (zzr) {
                            case 0:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzf(i7, zzol.zza(obj, j));
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 1:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzo(i7, zzol.zzb(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 2:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzt(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 3:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzK(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 4:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzr(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 5:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzm(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 6:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzk(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 7:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzb(i7, zzol.zzw(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 8:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzO(i7, unsafe.getObject(obj, j), zzorVar);
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 9:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzv(i7, unsafe.getObject(obj, j), zznkVar.zzv(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 10:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzd(i7, (zzld) unsafe.getObject(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 11:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzI(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 12:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzi(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 13:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzx(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 14:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzz(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 15:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzB(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 16:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzD(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 17:
                                if (zznkVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzorVar.zzq(i7, unsafe.getObject(obj, j), zznkVar.zzv(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 18:
                                zznu.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 19:
                                zznu.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 20:
                                zznu.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 21:
                                zznu.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 22:
                                zznu.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 23:
                                zznu.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 24:
                                zznu.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 25:
                                zznu.zzq(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 26:
                                int i10 = iArr[i];
                                List list = (List) unsafe.getObject(obj, j);
                                int i11 = zznu.zza;
                                if (list != null && !list.isEmpty()) {
                                    zzorVar.zzH(i10, list);
                                    break;
                                }
                                break;
                            case 27:
                                int i12 = iArr[i];
                                List list2 = (List) unsafe.getObject(obj, j);
                                zzns zzv = zznkVar.zzv(i);
                                int i13 = zznu.zza;
                                if (list2 != null && !list2.isEmpty()) {
                                    for (int i14 = 0; i14 < list2.size(); i14++) {
                                        ((zzll) zzorVar).zzv(i12, list2.get(i14), zzv);
                                    }
                                    break;
                                }
                                break;
                            case 28:
                                int i15 = iArr[i];
                                List list3 = (List) unsafe.getObject(obj, j);
                                int i16 = zznu.zza;
                                if (list3 != null && !list3.isEmpty()) {
                                    zzorVar.zze(i15, list3);
                                    break;
                                }
                                break;
                            case 29:
                                zznu.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 30:
                                zznu.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 31:
                                zznu.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 32:
                                zznu.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 33:
                                zznu.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 34:
                                zznu.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznkVar = this;
                            case 35:
                                zznu.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 36:
                                zznu.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 37:
                                zznu.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 38:
                                zznu.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 39:
                                zznu.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 40:
                                zznu.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 41:
                                zznu.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 42:
                                zznu.zzq(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 43:
                                zznu.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 44:
                                zznu.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 45:
                                zznu.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 46:
                                zznu.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 47:
                                zznu.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case 48:
                                zznu.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzorVar, true);
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                int i17 = iArr[i];
                                List list4 = (List) unsafe.getObject(obj, j);
                                zzns zzv2 = zznkVar.zzv(i);
                                int i18 = zznu.zza;
                                if (list4 != null && !list4.isEmpty()) {
                                    for (int i19 = 0; i19 < list4.size(); i19++) {
                                        ((zzll) zzorVar).zzq(i17, list4.get(i19), zzv2);
                                    }
                                    break;
                                }
                                break;
                            case 50:
                                if (unsafe.getObject(obj, j) != null) {
                                    zzna zznaVar = (zzna) zznkVar.zzw(i);
                                    throw null;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzf(i7, zzm(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzo(i7, zzn(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzt(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzK(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzr(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 56:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzm(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case 57:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzk(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 58:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzb(i7, zzN(obj, j));
                                    break;
                                }
                                break;
                            case 59:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzO(i7, unsafe.getObject(obj, j), zzorVar);
                                    break;
                                }
                                break;
                            case 60:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzv(i7, unsafe.getObject(obj, j), zznkVar.zzv(i));
                                    break;
                                }
                                break;
                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzd(i7, (zzld) unsafe.getObject(obj, j));
                                    break;
                                }
                                break;
                            case 62:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzI(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 63:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzi(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 64:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzx(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzz(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzB(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 67:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzD(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case 68:
                                if (zznkVar.zzM(obj, i7, i)) {
                                    zzorVar.zzq(i7, unsafe.getObject(obj, j), zznkVar.zzv(i));
                                    break;
                                }
                                break;
                        }
                        i += 3;
                        i4 = 1048575;
                        zznkVar = this;
                    } else {
                        zzmb zzmbVar = (zzmb) entry.getKey();
                        throw null;
                    }
                }
                if (entry != null) {
                    ((zzmd) obj).zzc.zzl(zzorVar);
                    return;
                } else {
                    zzmb zzmbVar2 = (zzmb) entry.getKey();
                    throw null;
                }
            }
        }
        entry = null;
        iArr = zznkVar.zzc;
        Unsafe unsafe2 = zzb;
        int i42 = 1048575;
        int i52 = 1048575;
        i = 0;
        int i62 = 0;
        while (i < iArr.length) {
        }
        if (entry != null) {
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzol.zza(obj, j)) == Double.doubleToLongBits(zzol.zza(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzol.zzb(obj, j)) == Float.floatToIntBits(zzol.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzol.zzw(obj, j) == zzol.zzw(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzol.zzc(obj, j) == zzol.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzol.zzd(obj, j) == zzol.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    zzE = zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j));
                    break;
                case 50:
                    zzE = zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case 63:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                case 68:
                    long zzp = zzp(i) & 1048575;
                    if (zzol.zzc(obj, zzp) == zzol.zzc(obj2, zzp) && zznu.zzE(zzol.zzf(obj, j), zzol.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzE) {
                return false;
            }
        }
        if (((zzmd) obj).zzc.equals(((zzmd) obj2).zzc)) {
            if (this.zzh) {
                return ((zzma) obj).zzb.equals(((zzma) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzns
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int zzs = zzs(i7);
            int i9 = iArr2[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i7;
                i3 = i4;
                i = i10;
            } else {
                int i12 = i4;
                i = i6;
                i2 = i7;
                i3 = i12;
            }
            if ((268435456 & zzs) != 0 && !zzJ(obj, i2, i, i3, i11)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj, i8, i2) && !zzK(obj, zzs, zzv(i2))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zznb) zzol.zzf(obj, zzs & 1048575)).isEmpty()) {
                            zzna zznaVar = (zzna) zzw(i2);
                            throw null;
                        }
                    }
                }
                List list = (List) zzol.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzns zzv = zzv(i2);
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        if (!zzv.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzJ(obj, i2, i, i3, i11) && !zzK(obj, zzs, zzv(i2))) {
                return false;
            }
            i5++;
            i6 = i;
            i4 = i3;
        }
        return !this.zzh || ((zzma) obj).zzb.zzh();
    }
}
