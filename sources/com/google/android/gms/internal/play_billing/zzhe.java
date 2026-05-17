package com.google.android.gms.internal.play_billing;

import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzhe<T> implements zzhl<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzii.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhb zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzib zzl;
    private final zzfi zzm;

    private zzhe(int[] iArr, Object[] objArr, int i, int i2, zzhb zzhbVar, boolean z, int[] iArr2, int i3, int i4, zzhg zzhgVar, zzgk zzgkVar, zzib zzibVar, zzfi zzfiVar, zzgw zzgwVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzfiVar != null && (zzhbVar instanceof zzfr)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzibVar;
        this.zzm = zzfiVar;
        this.zzg = zzhbVar;
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
            zzhl zzv = zzv(i);
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
            zzhl zzv = zzv(i);
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
        zzii.zzq(obj, j, (1 << (zzp >>> 20)) | zzii.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzii.zzq(obj, zzp(i2) & 1048575, i);
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
            return ((1 << (zzp >>> 20)) & zzii.zzc(obj, j)) != 0;
        }
        int zzs = zzs(i);
        long j2 = zzs & 1048575;
        switch (zzr(zzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzii.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzii.zzb(obj, j2)) != 0;
            case 2:
                return zzii.zzd(obj, j2) != 0;
            case 3:
                return zzii.zzd(obj, j2) != 0;
            case 4:
                return zzii.zzc(obj, j2) != 0;
            case 5:
                return zzii.zzd(obj, j2) != 0;
            case 6:
                return zzii.zzc(obj, j2) != 0;
            case 7:
                return zzii.zzw(obj, j2);
            case 8:
                Object zzf = zzii.zzf(obj, j2);
                if (zzf instanceof String) {
                    return !((String) zzf).isEmpty();
                } else if (zzf instanceof zzev) {
                    return !zzev.zza.equals(zzf);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzii.zzf(obj, j2) != null;
            case 10:
                return !zzev.zza.equals(zzii.zzf(obj, j2));
            case 11:
                return zzii.zzc(obj, j2) != 0;
            case 12:
                return zzii.zzc(obj, j2) != 0;
            case 13:
                return zzii.zzc(obj, j2) != 0;
            case 14:
                return zzii.zzd(obj, j2) != 0;
            case 15:
                return zzii.zzc(obj, j2) != 0;
            case 16:
                return zzii.zzd(obj, j2) != 0;
            case 17:
                return zzii.zzf(obj, j2) != null;
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

    private static boolean zzK(Object obj, int i, zzhl zzhlVar) {
        return zzhlVar.zzk(zzii.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfu) {
            return ((zzfu) obj).zzF();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzii.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzii.zzf(obj, j)).booleanValue();
    }

    private static final int zzO(byte[] bArr, int i, int i2, zzir zzirVar, Class cls, zzej zzejVar) throws IOException {
        zzir zzirVar2 = zzir.DOUBLE;
        switch (zzirVar.ordinal()) {
            case 0:
                int i3 = i + 8;
                zzejVar.zzc = Double.valueOf(Double.longBitsToDouble(zzek.zzp(bArr, i)));
                return i3;
            case 1:
                int i4 = i + 4;
                zzejVar.zzc = Float.valueOf(Float.intBitsToFloat(zzek.zzb(bArr, i)));
                return i4;
            case 2:
            case 3:
                int zzl = zzek.zzl(bArr, i, zzejVar);
                zzejVar.zzc = Long.valueOf(zzejVar.zzb);
                return zzl;
            case 4:
            case 12:
            case 13:
                int zzi = zzek.zzi(bArr, i, zzejVar);
                zzejVar.zzc = Integer.valueOf(zzejVar.zza);
                return zzi;
            case 5:
            case 15:
                int i5 = i + 8;
                zzejVar.zzc = Long.valueOf(zzek.zzp(bArr, i));
                return i5;
            case 6:
            case 14:
                int i6 = i + 4;
                zzejVar.zzc = Integer.valueOf(zzek.zzb(bArr, i));
                return i6;
            case 7:
                int zzl2 = zzek.zzl(bArr, i, zzejVar);
                zzejVar.zzc = Boolean.valueOf(zzejVar.zzb != 0);
                return zzl2;
            case 8:
                return zzek.zzg(bArr, i, zzejVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return zzek.zzd(zzhi.zza().zzb(cls), bArr, i, i2, zzejVar);
            case 11:
                return zzek.zza(bArr, i, zzejVar);
            case 16:
                int zzi2 = zzek.zzi(bArr, i, zzejVar);
                zzejVar.zzc = Integer.valueOf(zzey.zzb(zzejVar.zza));
                return zzi2;
            case 17:
                int zzl3 = zzek.zzl(bArr, i, zzejVar);
                zzejVar.zzc = Long.valueOf(zzey.zzc(zzejVar.zzb));
                return zzl3;
        }
    }

    private static final void zzP(int i, Object obj, zzit zzitVar) throws IOException {
        if (obj instanceof String) {
            zzitVar.zzH(i, (String) obj);
        } else {
            zzitVar.zzd(i, (zzev) obj);
        }
    }

    static zzic zzd(Object obj) {
        zzfu zzfuVar = (zzfu) obj;
        zzic zzicVar = zzfuVar.zzc;
        if (zzicVar == zzic.zzc()) {
            zzic zzf = zzic.zzf();
            zzfuVar.zzc = zzf;
            return zzf;
        }
        return zzicVar;
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
    public static zzhe zzl(Class cls, zzgy zzgyVar, zzhg zzhgVar, zzgk zzgkVar, zzib zzibVar, zzfi zzfiVar, zzgw zzgwVar) {
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
        if (zzgyVar instanceof zzhk) {
            zzhk zzhkVar = (zzhk) zzgyVar;
            String zzd = zzhkVar.zzd();
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
            Object[] zze = zzhkVar.zze();
            Class<?> cls2 = zzhkVar.zza().getClass();
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
                zzhk zzhkVar2 = zzhkVar;
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
                            if (zzhkVar2.zzc() == 1 || i79 != 0) {
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
                            if (zzhkVar2.zzc() == 1 || i79 != 0) {
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
                zzhkVar = zzhkVar2;
                length = i18;
                i7 = i19;
            }
            return new zzhe(iArr3, objArr, i2, i4, zzhkVar.zza(), false, iArr, i5, i64, zzhgVar, zzgkVar, zzibVar, zzfiVar, zzgwVar);
        }
        zzhy zzhyVar = (zzhy) zzgyVar;
        throw null;
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzii.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzii.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzii.zzf(obj, j)).intValue();
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
        return ((Long) zzii.zzf(obj, j)).longValue();
    }

    private final zzfx zzu(int i) {
        int i2 = i / 3;
        return (zzfx) this.zzd[i2 + i2 + 1];
    }

    private final zzhl zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhl zzhlVar = (zzhl) objArr[i3];
        if (zzhlVar != null) {
            return zzhlVar;
        }
        zzhl zzb2 = zzhi.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzhl zzv = zzv(i);
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
        zzhl zzv = zzv(i2);
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
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zza(Object obj) {
        int i;
        int zzy;
        int zzy2;
        int zzz;
        int zzy3;
        int zzy4;
        int zzy5;
        int zzb2;
        int zzy6;
        int zzi;
        int zzh;
        int size;
        int zzm;
        int zzy7;
        int zzb3;
        int zzy8;
        int zzb4;
        int zzy9;
        int zzy10;
        int zzi2;
        int zzy11;
        int zzy12;
        int i2;
        int zzf;
        int zzy13;
        int zzy14;
        int i3;
        int zzy15;
        int zzy16;
        int zzy17;
        int zzb5;
        int zzy18;
        zzhe<T> zzheVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (true) {
            int[] iArr = zzheVar.zzc;
            if (i4 < iArr.length) {
                int zzs = zzheVar.zzs(i4);
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
                if (zzr >= zzfn.DOUBLE_LIST_PACKED.zza()) {
                    zzfn.SINT64_LIST_PACKED.zza();
                }
                long j = i11;
                switch (zzr) {
                    case 0:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            i6 += zzfc.zzy(i8 << 3) + 8;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy = zzfc.zzy(i8 << 3);
                            zzy4 = zzy + 4;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 2:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j2 = unsafe.getLong(obj2, j);
                            zzy2 = zzfc.zzy(i8 << 3);
                            zzz = zzfc.zzz(j2);
                            zzy4 = zzy2 + zzz;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 3:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j3 = unsafe.getLong(obj2, j);
                            zzy2 = zzfc.zzy(i8 << 3);
                            zzz = zzfc.zzz(j3);
                            zzy4 = zzy2 + zzz;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 4:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy2 = zzfc.zzy(i8 << 3);
                            zzz = zzfc.zzz(unsafe.getInt(obj2, j));
                            zzy4 = zzy2 + zzz;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 5:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy3 = zzfc.zzy(i8 << 3);
                            zzy4 = zzy3 + 8;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 6:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy = zzfc.zzy(i8 << 3);
                            zzy4 = zzy + 4;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 7:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy4 = zzfc.zzy(i8 << 3) + 1;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 8:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i12 = i8 << 3;
                            Object object = unsafe.getObject(obj2, j);
                            if (object instanceof zzev) {
                                zzy5 = zzfc.zzy(i12);
                                zzb2 = ((zzev) object).zze();
                                zzy6 = zzfc.zzy(zzb2);
                            } else {
                                zzy5 = zzfc.zzy(i12);
                                zzb2 = zzin.zzb((String) object);
                                zzy6 = zzfc.zzy(zzb2);
                            }
                            zzy4 = zzy5 + zzy6 + zzb2;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 9:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzi = zzhn.zzi(i8, unsafe.getObject(obj2, j), zzheVar.zzv(i4));
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy5 = zzfc.zzy(i8 << 3);
                            zzb2 = ((zzev) unsafe.getObject(obj2, j)).zze();
                            zzy6 = zzfc.zzy(zzb2);
                            zzy4 = zzy5 + zzy6 + zzb2;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 11:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i13 = unsafe.getInt(obj2, j);
                            zzy2 = zzfc.zzy(i8 << 3);
                            zzz = zzfc.zzy(i13);
                            zzy4 = zzy2 + zzz;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 12:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy2 = zzfc.zzy(i8 << 3);
                            zzz = zzfc.zzz(unsafe.getInt(obj2, j));
                            zzy4 = zzy2 + zzz;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 13:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy = zzfc.zzy(i8 << 3);
                            zzy4 = zzy + 4;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 14:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzy3 = zzfc.zzy(i8 << 3);
                            zzy4 = zzy3 + 8;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 15:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i14 = unsafe.getInt(obj2, j);
                            zzy2 = zzfc.zzy(i8 << 3);
                            zzz = zzfc.zzy((i14 >> 31) ^ (i14 + i14));
                            zzy4 = zzy2 + zzz;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 16:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j4 = unsafe.getLong(obj2, j);
                            zzy2 = zzfc.zzy(i8 << 3);
                            zzz = zzfc.zzz((j4 >> 63) ^ (j4 + j4));
                            zzy4 = zzy2 + zzz;
                            i6 += zzy4;
                        }
                        zzheVar = this;
                        break;
                    case 17:
                        if (zzheVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzi = zzhn.zza(i8, (zzhb) unsafe.getObject(obj2, j), zzheVar.zzv(i4));
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzi = zzhn.zze(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzi;
                        break;
                    case 19:
                        zzi = zzhn.zzc(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzi;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(obj2, j);
                        int i15 = zzhn.zza;
                        if (list.size() != 0) {
                            zzh = zzhn.zzh(list) + (list.size() * zzfc.zzy(i8 << 3));
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj2, j);
                        int i16 = zzhn.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzm = zzhn.zzm(list2);
                            zzy7 = zzfc.zzy(i8 << 3);
                            i2 = size * zzy7;
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        }
                        zzi = 0;
                        i6 += zzi;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj2, j);
                        int i17 = zzhn.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzm = zzhn.zzg(list3);
                            zzy7 = zzfc.zzy(i8 << 3);
                            i2 = size * zzy7;
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        }
                        zzi = 0;
                        i6 += zzi;
                    case 23:
                        zzi = zzhn.zze(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzi;
                        break;
                    case 24:
                        zzi = zzhn.zzc(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzi;
                        break;
                    case 25:
                        int i18 = zzhn.zza;
                        int size2 = ((List) unsafe.getObject(obj2, j)).size();
                        if (size2 != 0) {
                            zzi = size2 * (zzfc.zzy(i8 << 3) + 1);
                            i6 += zzi;
                            break;
                        }
                        zzi = 0;
                        i6 += zzi;
                    case 26:
                        List list4 = (List) unsafe.getObject(obj2, j);
                        int i19 = zzhn.zza;
                        int size3 = list4.size();
                        if (size3 != 0) {
                            zzh = zzfc.zzy(i8 << 3) * size3;
                            if (list4 instanceof zzgj) {
                                zzgj zzgjVar = (zzgj) list4;
                                for (int i20 = 0; i20 < size3; i20++) {
                                    Object zza2 = zzgjVar.zza();
                                    if (zza2 instanceof zzev) {
                                        zzb4 = ((zzev) zza2).zze();
                                        zzy9 = zzfc.zzy(zzb4);
                                    } else {
                                        zzb4 = zzin.zzb((String) zza2);
                                        zzy9 = zzfc.zzy(zzb4);
                                    }
                                    zzh += zzy9 + zzb4;
                                }
                            } else {
                                for (int i21 = 0; i21 < size3; i21++) {
                                    Object obj3 = list4.get(i21);
                                    if (obj3 instanceof zzev) {
                                        zzb3 = ((zzev) obj3).zze();
                                        zzy8 = zzfc.zzy(zzb3);
                                    } else {
                                        zzb3 = zzin.zzb((String) obj3);
                                        zzy8 = zzfc.zzy(zzb3);
                                    }
                                    zzh += zzy8 + zzb3;
                                }
                            }
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case 27:
                        List list5 = (List) unsafe.getObject(obj2, j);
                        zzhl zzv = zzheVar.zzv(i4);
                        int i22 = zzhn.zza;
                        int size4 = list5.size();
                        if (size4 == 0) {
                            zzy10 = 0;
                        } else {
                            zzy10 = zzfc.zzy(i8 << 3) * size4;
                            for (int i23 = 0; i23 < size4; i23++) {
                                Object obj4 = list5.get(i23);
                                if (obj4 instanceof zzgi) {
                                    zzi2 = ((zzgi) obj4).zza();
                                    zzy11 = zzfc.zzy(zzi2);
                                } else {
                                    zzi2 = ((zzeg) obj4).zzi(zzv);
                                    zzy11 = zzfc.zzy(zzi2);
                                }
                                zzy10 += zzy11 + zzi2;
                            }
                        }
                        i6 += zzy10;
                        break;
                    case 28:
                        List list6 = (List) unsafe.getObject(obj2, j);
                        int i24 = zzhn.zza;
                        int size5 = list6.size();
                        if (size5 == 0) {
                            zzy12 = 0;
                        } else {
                            zzy12 = size5 * zzfc.zzy(i8 << 3);
                            for (int i25 = 0; i25 < list6.size(); i25++) {
                                int zze = ((zzev) list6.get(i25)).zze();
                                zzy12 += zzfc.zzy(zze) + zze;
                            }
                        }
                        i6 += zzy12;
                        break;
                    case 29:
                        List list7 = (List) unsafe.getObject(obj2, j);
                        int i26 = zzhn.zza;
                        size = list7.size();
                        if (size != 0) {
                            zzm = zzhn.zzl(list7);
                            zzy7 = zzfc.zzy(i8 << 3);
                            i2 = size * zzy7;
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        }
                        zzi = 0;
                        i6 += zzi;
                    case 30:
                        List list8 = (List) unsafe.getObject(obj2, j);
                        int i27 = zzhn.zza;
                        size = list8.size();
                        if (size != 0) {
                            zzm = zzhn.zzb(list8);
                            zzy7 = zzfc.zzy(i8 << 3);
                            i2 = size * zzy7;
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        }
                        zzi = 0;
                        i6 += zzi;
                    case 31:
                        zzi = zzhn.zzc(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzi;
                        break;
                    case 32:
                        zzi = zzhn.zze(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzi;
                        break;
                    case 33:
                        List list9 = (List) unsafe.getObject(obj2, j);
                        int i28 = zzhn.zza;
                        size = list9.size();
                        if (size != 0) {
                            zzm = zzhn.zzj(list9);
                            zzy7 = zzfc.zzy(i8 << 3);
                            i2 = size * zzy7;
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        }
                        zzi = 0;
                        i6 += zzi;
                    case 34:
                        List list10 = (List) unsafe.getObject(obj2, j);
                        int i29 = zzhn.zza;
                        size = list10.size();
                        if (size != 0) {
                            zzm = zzhn.zzk(list10);
                            zzy7 = zzfc.zzy(i8 << 3);
                            i2 = size * zzy7;
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        }
                        zzi = 0;
                        i6 += zzi;
                    case 35:
                        zzf = zzhn.zzf((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzf = zzhn.zzd((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzf = zzhn.zzh((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzf = zzhn.zzm((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzf = zzhn.zzg((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzf = zzhn.zzf((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzf = zzhn.zzd((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i30 = zzhn.zza;
                        zzf = ((List) unsafe.getObject(obj2, j)).size();
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzf = zzhn.zzl((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzf = zzhn.zzb((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzf = zzhn.zzd((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzf = zzhn.zzf((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzf = zzhn.zzj((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzf = zzhn.zzk((List) unsafe.getObject(obj2, j));
                        if (zzf > 0) {
                            zzy13 = zzfc.zzy(i8 << 3);
                            zzy14 = zzfc.zzy(zzf);
                            zzy12 = zzy13 + zzy14 + zzf;
                            i6 += zzy12;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list11 = (List) unsafe.getObject(obj2, j);
                        zzhl zzv2 = zzheVar.zzv(i4);
                        int i31 = zzhn.zza;
                        int size6 = list11.size();
                        if (size6 == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            for (int i32 = 0; i32 < size6; i32++) {
                                i3 += zzhn.zza(i8, (zzhb) list11.get(i32), zzv2);
                            }
                        }
                        i6 += i3;
                        break;
                    case 50:
                        zzgv zzgvVar = (zzgv) unsafe.getObject(obj2, j);
                        zzgu zzguVar = (zzgu) zzheVar.zzw(i4);
                        if (!zzgvVar.isEmpty()) {
                            zzh = 0;
                            for (Map.Entry entry : zzgvVar.entrySet()) {
                                zzh += zzguVar.zza(i8, entry.getKey(), entry.getValue());
                            }
                            i6 += zzh;
                            break;
                        }
                        zzh = 0;
                        i6 += zzh;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzy15 = zzfc.zzy(i8 << 3);
                            zzi = zzy15 + 8;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzy16 = zzfc.zzy(i8 << 3);
                            zzi = zzy16 + 4;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            long zzt = zzt(obj2, j);
                            zzm = zzfc.zzy(i8 << 3);
                            i2 = zzfc.zzz(zzt);
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            long zzt2 = zzt(obj2, j);
                            zzm = zzfc.zzy(i8 << 3);
                            i2 = zzfc.zzz(zzt2);
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzm = zzfc.zzy(i8 << 3);
                            i2 = zzfc.zzz(zzo(obj2, j));
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzy15 = zzfc.zzy(i8 << 3);
                            zzi = zzy15 + 8;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzy16 = zzfc.zzy(i8 << 3);
                            zzi = zzy16 + 4;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzi = zzfc.zzy(i8 << 3) + 1;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            int i33 = i8 << 3;
                            Object object2 = unsafe.getObject(obj2, j);
                            if (object2 instanceof zzev) {
                                zzy17 = zzfc.zzy(i33);
                                zzb5 = ((zzev) object2).zze();
                                zzy18 = zzfc.zzy(zzb5);
                            } else {
                                zzy17 = zzfc.zzy(i33);
                                zzb5 = zzin.zzb((String) object2);
                                zzy18 = zzfc.zzy(zzb5);
                            }
                            zzi = zzy17 + zzy18 + zzb5;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzi = zzhn.zzi(i8, unsafe.getObject(obj2, j), zzheVar.zzv(i4));
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzy17 = zzfc.zzy(i8 << 3);
                            zzb5 = ((zzev) unsafe.getObject(obj2, j)).zze();
                            zzy18 = zzfc.zzy(zzb5);
                            zzi = zzy17 + zzy18 + zzb5;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case RectListKt.BitOffsetForGesturable /* 62 */:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            int zzo = zzo(obj2, j);
                            zzm = zzfc.zzy(i8 << 3);
                            i2 = zzfc.zzy(zzo);
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzm = zzfc.zzy(i8 << 3);
                            i2 = zzfc.zzz(zzo(obj2, j));
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzy16 = zzfc.zzy(i8 << 3);
                            zzi = zzy16 + 4;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzy15 = zzfc.zzy(i8 << 3);
                            zzi = zzy15 + 8;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            int zzo2 = zzo(obj2, j);
                            zzm = zzfc.zzy(i8 << 3);
                            i2 = zzfc.zzy((zzo2 >> 31) ^ (zzo2 + zzo2));
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            long zzt3 = zzt(obj2, j);
                            zzm = zzfc.zzy(i8 << 3);
                            i2 = zzfc.zzz((zzt3 >> 63) ^ (zzt3 + zzt3));
                            zzi = zzm + i2;
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzheVar.zzM(obj2, i8, i4)) {
                            zzi = zzhn.zza(i8, (zzhb) unsafe.getObject(obj2, j), zzheVar.zzv(i4));
                            i6 += zzi;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                obj2 = obj;
            } else {
                int zza3 = i6 + ((zzfu) obj).zzc.zza();
                if (zzheVar.zzh) {
                    zzht zzhtVar = ((zzfr) obj).zzb.zza;
                    int zzc = zzhtVar.zzc();
                    int i34 = 0;
                    for (int i35 = 0; i35 < zzc; i35++) {
                        Map.Entry zzg = zzhtVar.zzg(i35);
                        i34 += zzfm.zzc((zzfl) ((zzhp) zzg).zza(), zzg.getValue());
                    }
                    for (Map.Entry entry2 : zzhtVar.zzd()) {
                        i34 += zzfm.zzc((zzfl) entry2.getKey(), entry2.getValue());
                    }
                    return zza3 + i34;
                }
                return zza3;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
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
                        doubleToLongBits = Double.doubleToLongBits(zzii.zza(obj, j));
                        byte[] bArr = zzga.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 1:
                        i = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzii.zzb(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 2:
                        i = i4 * 53;
                        doubleToLongBits = zzii.zzd(obj, j);
                        byte[] bArr2 = zzga.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 3:
                        i = i4 * 53;
                        doubleToLongBits = zzii.zzd(obj, j);
                        byte[] bArr3 = zzga.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 4:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 5:
                        i = i4 * 53;
                        doubleToLongBits = zzii.zzd(obj, j);
                        byte[] bArr4 = zzga.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 6:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 7:
                        i = i4 * 53;
                        floatToIntBits = zzga.zza(zzii.zzw(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 8:
                        i = i4 * 53;
                        floatToIntBits = ((String) zzii.zzf(obj, j)).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 9:
                        i2 = i4 * 53;
                        Object zzf = zzii.zzf(obj, j);
                        if (zzf != null) {
                            i7 = zzf.hashCode();
                        }
                        i4 = i2 + i7;
                        break;
                    case 10:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 11:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 12:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 13:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 14:
                        i = i4 * 53;
                        doubleToLongBits = zzii.zzd(obj, j);
                        byte[] bArr5 = zzga.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 15:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzc(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 16:
                        i = i4 * 53;
                        doubleToLongBits = zzii.zzd(obj, j);
                        byte[] bArr6 = zzga.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 17:
                        i2 = i4 * 53;
                        Object zzf2 = zzii.zzf(obj, j);
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
                    case 49:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 50:
                        i = i4 * 53;
                        floatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                            byte[] bArr7 = zzga.zzb;
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
                            byte[] bArr8 = zzga.zzb;
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
                            byte[] bArr9 = zzga.zzb;
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
                            byte[] bArr10 = zzga.zzb;
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
                            floatToIntBits = zzga.zza(zzN(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 59:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = ((String) zzii.zzf(obj, j)).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 60:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzii.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 61:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzii.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case RectListKt.BitOffsetForGesturable /* 62 */:
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
                            byte[] bArr11 = zzga.zzb;
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
                            byte[] bArr12 = zzga.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 68:
                        if (!zzM(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzii.zzf(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                }
                i3 += 3;
            } else {
                int hashCode = (i4 * 53) + ((zzfu) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzfr) obj).zzb.zza.hashCode() : hashCode;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02ca, code lost:
        r7 = r5;
        r8 = r40;
        r15 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x02ce, code lost:
        r5 = r11;
        r4 = r12;
        r6 = r13;
        r14 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x0aff, code lost:
        throw new com.google.android.gms.internal.play_billing.zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x0e03, code lost:
        if (r14 == 1048575) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:574:0x0e05, code lost:
        r8.putInt(r10, r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:575:0x0e09, code lost:
        r1 = r0.zzj;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:577:0x0e0f, code lost:
        if (r1 >= r0.zzk) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:578:0x0e11, code lost:
        r5 = r0.zzi;
        r7 = r0.zzl;
        r8 = r0.zzc;
        r5 = r5[r1];
        r8 = r8[r5];
        r11 = com.google.android.gms.internal.play_billing.zzii.zzf(r10, r0.zzs(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:579:0x0e29, code lost:
        if (r11 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x0e2b, code lost:
        r12 = r0.zzu(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x0e2f, code lost:
        if (r12 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x0e31, code lost:
        r5 = ((com.google.android.gms.internal.play_billing.zzgu) r0.zzw(r5)).zzc();
        r11 = ((com.google.android.gms.internal.play_billing.zzgv) r11).entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x0e49, code lost:
        if (r11.hasNext() == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:0x0e4b, code lost:
        r13 = (java.util.Map.Entry) r11.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:586:0x0e5f, code lost:
        if (r12.zza(((java.lang.Integer) r13.getValue()).intValue()) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:587:0x0e61, code lost:
        if (r2 != 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:588:0x0e63, code lost:
        r2 = r7.zza(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:589:0x0e67, code lost:
        r14 = com.google.android.gms.internal.play_billing.zzgu.zzb(r5, r13.getKey(), r13.getValue());
        r15 = com.google.android.gms.internal.play_billing.zzev.zza;
        r15 = new byte[r14];
        r17 = com.google.android.gms.internal.play_billing.zzfc.zzb;
        r17 = r1;
        r0 = new com.google.android.gms.internal.play_billing.zzez(r15, 0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:590:0x0e81, code lost:
        com.google.android.gms.internal.play_billing.zzgu.zze(r0, r5, r13.getKey(), r13.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:591:0x0e8c, code lost:
        r2.zzj((r8 << 3) | 2, com.google.android.gms.internal.play_billing.zzer.zza(r0, r15));
        r11.remove();
        r1 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:592:0x0ea5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:594:0x0eab, code lost:
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:596:0x0eb1, code lost:
        r2 = r2;
        r1 = r1 + 1;
        r0 = r36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:597:0x0ec0, code lost:
        if (r2 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:0x0ec2, code lost:
        ((com.google.android.gms.internal.play_billing.zzfu) r10).zzc = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:599:0x0eca, code lost:
        if (r9 != 0) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0192, code lost:
        r8 = r40;
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:600:0x0ecc, code lost:
        if (r3 != r4) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:603:0x0ed6, code lost:
        throw new com.google.android.gms.internal.play_billing.zzgc(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x0ed7, code lost:
        r12 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:605:0x0ed9, code lost:
        if (r3 > r4) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0edb, code lost:
        if (r6 != r9) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x0edd, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:609:0x0ee3, code lost:
        throw new com.google.android.gms.internal.play_billing.zzgc(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01cb, code lost:
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0274, code lost:
        r15 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:215:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0674  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x0d9d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:562:0x0dac  */
    /* JADX WARN: Removed duplicated region for block: B:662:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:213:0x05ce -> B:214:0x05cf). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:248:0x0671 -> B:249:0x0672). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:268:0x06c5 -> B:269:0x06c7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzej zzejVar) throws IOException {
        int i4;
        Object obj2;
        int i5;
        String str;
        Unsafe unsafe;
        int zzq;
        int i6;
        int i7;
        int i8;
        byte[] bArr2;
        zzej zzejVar2;
        int i9;
        int i10;
        Unsafe unsafe2;
        Object obj3;
        byte[] bArr3;
        zzej zzejVar3;
        int i11;
        int i12;
        int i13;
        byte[] bArr4;
        Unsafe unsafe3;
        int i14;
        Object obj4;
        int i15;
        int i16;
        byte[] bArr5;
        Unsafe unsafe4;
        zzej zzejVar4;
        int i17;
        int i18;
        int zzi;
        int i19;
        zzej zzejVar5;
        int i20;
        int i21;
        int i22;
        Object obj5;
        int i23;
        byte[] bArr6;
        int i24;
        zzej zzejVar6;
        int zzk;
        zzfz zzfzVar;
        int i25;
        int i26;
        int i27;
        int i28;
        int zzi2;
        int i29;
        byte[] bArr7;
        int i30;
        int i31;
        int i32;
        int i33;
        byte[] bArr8;
        zzej zzejVar7;
        int i34;
        int zza2;
        int i35;
        int zzi3;
        zzej zzejVar8;
        Object obj6;
        int i36;
        Object obj7;
        zzej zzejVar9;
        zzhe<T> zzheVar = this;
        Object obj8 = obj;
        byte[] bArr9 = bArr;
        int i37 = i2;
        zzej zzejVar10 = zzejVar;
        zzA(obj8);
        Unsafe unsafe5 = zzb;
        int i38 = 0;
        int i39 = i;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = -1;
        int i44 = 1048575;
        while (true) {
            int i45 = 1048575;
            while (true) {
                if (i39 < i37) {
                    int i46 = i39 + 1;
                    int i47 = bArr9[i39];
                    if (i47 < 0) {
                        i46 = zzek.zzj(i47, bArr9, i46, zzejVar10);
                        i47 = zzejVar10.zza;
                    }
                    int i48 = i46;
                    int i49 = i47;
                    i39 = i48;
                    int i50 = i49 >>> 3;
                    if (i50 <= i43) {
                        if (i50 >= zzheVar.zze && i50 <= zzheVar.zzf) {
                            zzq = zzheVar.zzq(i50, i38);
                            if (zzq != -1) {
                            }
                            if (i8 == i4) {
                            }
                            if (zzheVar.zzh) {
                            }
                            i10 = i2;
                            i39 = zzek.zzh(i8, bArr, i39, i10, zzd(obj2), zzejVar);
                            bArr9 = bArr;
                            unsafe5 = unsafe;
                            obj8 = obj2;
                            i40 = i38;
                            i41 = i8;
                            i44 = i6;
                            i38 = 0;
                            i45 = 1048575;
                            zzejVar10 = zzejVar;
                            i37 = i10;
                            i43 = i9;
                            i42 = i7;
                        }
                        zzq = -1;
                        if (zzq != -1) {
                        }
                        if (i8 == i4) {
                        }
                        if (zzheVar.zzh) {
                        }
                        i10 = i2;
                        i39 = zzek.zzh(i8, bArr, i39, i10, zzd(obj2), zzejVar);
                        bArr9 = bArr;
                        unsafe5 = unsafe;
                        obj8 = obj2;
                        i40 = i38;
                        i41 = i8;
                        i44 = i6;
                        i38 = 0;
                        i45 = 1048575;
                        zzejVar10 = zzejVar;
                        i37 = i10;
                        i43 = i9;
                        i42 = i7;
                    } else {
                        int i51 = i40 / 3;
                        if (i50 >= zzheVar.zze && i50 <= zzheVar.zzf) {
                            zzq = zzheVar.zzq(i50, i51);
                            if (zzq != -1) {
                                i4 = i3;
                                unsafe = unsafe5;
                                str = "Failed to parse the message.";
                                i6 = i44;
                                i7 = i42;
                                i8 = i49;
                                bArr2 = bArr9;
                                zzejVar2 = zzejVar10;
                                i9 = i50;
                                obj2 = obj8;
                            } else {
                                int i52 = i49 & 7;
                                int[] iArr = zzheVar.zzc;
                                int i53 = zzq;
                                int i54 = iArr[zzq + 1];
                                int zzr = zzr(i54);
                                long j = i54 & i45;
                                if (zzr <= 17) {
                                    int i55 = iArr[i53 + 2];
                                    int i56 = 1 << (i55 >>> 20);
                                    int i57 = i55 & i45;
                                    str = "Failed to parse the message.";
                                    if (i57 != i44) {
                                        int i58 = i45;
                                        if (i44 != i58) {
                                            unsafe5.putInt(obj8, i44, i42);
                                            i58 = 1048575;
                                        }
                                        i42 = i57 == i58 ? 0 : unsafe5.getInt(obj8, i57);
                                        i44 = i57;
                                    }
                                    switch (zzr) {
                                        case 0:
                                            zzej zzejVar11 = zzejVar10;
                                            bArr3 = bArr9;
                                            zzejVar3 = zzejVar11;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            unsafe2 = unsafe5;
                                            obj3 = obj8;
                                            if (i52 != 1) {
                                                bArr2 = bArr;
                                                i4 = i3;
                                                obj2 = obj3;
                                                unsafe = unsafe2;
                                                zzejVar2 = zzejVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                i11 = i39 + 8;
                                                i12 = i7 | i56;
                                                zzii.zzo(obj3, j, Double.longBitsToDouble(zzek.zzp(bArr3, i39)));
                                                byte[] bArr10 = bArr3;
                                                zzejVar10 = zzejVar3;
                                                bArr9 = bArr10;
                                                i37 = i2;
                                                i39 = i11;
                                                i43 = i50;
                                                i41 = i8;
                                                obj8 = obj3;
                                                unsafe5 = unsafe2;
                                                i44 = i6;
                                                i45 = 1048575;
                                                i42 = i12;
                                                i40 = i38;
                                                i38 = 0;
                                                break;
                                            }
                                        case 1:
                                            zzej zzejVar12 = zzejVar10;
                                            bArr3 = bArr9;
                                            zzejVar3 = zzejVar12;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            unsafe2 = unsafe5;
                                            obj3 = obj8;
                                            if (i52 != 5) {
                                                bArr2 = bArr;
                                                i4 = i3;
                                                obj2 = obj3;
                                                unsafe = unsafe2;
                                                zzejVar2 = zzejVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                i11 = i39 + 4;
                                                i12 = i7 | i56;
                                                zzii.zzp(obj3, j, Float.intBitsToFloat(zzek.zzb(bArr3, i39)));
                                                byte[] bArr102 = bArr3;
                                                zzejVar10 = zzejVar3;
                                                bArr9 = bArr102;
                                                i37 = i2;
                                                i39 = i11;
                                                i43 = i50;
                                                i41 = i8;
                                                obj8 = obj3;
                                                unsafe5 = unsafe2;
                                                i44 = i6;
                                                i45 = 1048575;
                                                i42 = i12;
                                                i40 = i38;
                                                i38 = 0;
                                                break;
                                            }
                                        case 2:
                                        case 3:
                                            zzej zzejVar13 = zzejVar10;
                                            byte[] bArr11 = bArr9;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 != 0) {
                                                unsafe2 = unsafe5;
                                                obj3 = obj8;
                                                bArr2 = bArr;
                                                i4 = i3;
                                                obj2 = obj3;
                                                unsafe = unsafe2;
                                                zzejVar2 = zzejVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                int zzl = zzek.zzl(bArr11, i39, zzejVar13);
                                                unsafe5.putLong(obj8, j, zzejVar13.zzb);
                                                zzejVar10 = zzejVar13;
                                                bArr9 = bArr11;
                                                i42 = i7 | i56;
                                                i39 = zzl;
                                                i40 = i38;
                                                i43 = i50;
                                                i41 = i8;
                                                i44 = i6;
                                                i38 = 0;
                                                i45 = 1048575;
                                                i37 = i2;
                                                break;
                                            }
                                        case 4:
                                        case 11:
                                            zzej zzejVar14 = zzejVar10;
                                            byte[] bArr12 = bArr9;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 == 0) {
                                                i13 = i7 | i56;
                                                i39 = zzek.zzi(bArr12, i39, zzejVar14);
                                                unsafe5.putInt(obj8, j, zzejVar14.zza);
                                                bArr4 = bArr12;
                                                zzejVar10 = zzejVar14;
                                                break;
                                            }
                                            unsafe2 = unsafe5;
                                            obj3 = obj8;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzejVar2 = zzejVar;
                                            i9 = i50;
                                            break;
                                        case 5:
                                        case 14:
                                            byte[] bArr13 = bArr9;
                                            Unsafe unsafe6 = unsafe5;
                                            zzej zzejVar15 = zzejVar10;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 != 1) {
                                                unsafe5 = unsafe6;
                                                unsafe2 = unsafe5;
                                                obj3 = obj8;
                                                bArr2 = bArr;
                                                i4 = i3;
                                                obj2 = obj3;
                                                unsafe = unsafe2;
                                                zzejVar2 = zzejVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                unsafe5 = unsafe6;
                                                unsafe5.putLong(obj8, j, zzek.zzp(bArr13, i39));
                                                zzejVar10 = zzejVar15;
                                                bArr9 = bArr13;
                                                i39 += 8;
                                                i42 = i7 | i56;
                                                i40 = i38;
                                                i43 = i50;
                                                i41 = i8;
                                                i44 = i6;
                                                i38 = 0;
                                                i45 = 1048575;
                                                i37 = i2;
                                                break;
                                            }
                                        case 6:
                                        case 13:
                                            byte[] bArr14 = bArr9;
                                            unsafe3 = unsafe5;
                                            zzej zzejVar16 = zzejVar10;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 == 5) {
                                                i14 = i7 | i56;
                                                unsafe3.putInt(obj8, j, zzek.zzb(bArr14, i39));
                                                zzejVar10 = zzejVar16;
                                                unsafe5 = unsafe3;
                                                bArr9 = bArr14;
                                                i37 = i2;
                                                i39 += 4;
                                                break;
                                            }
                                            obj3 = obj8;
                                            unsafe2 = unsafe3;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzejVar2 = zzejVar;
                                            i9 = i50;
                                            break;
                                        case 7:
                                            byte[] bArr15 = bArr9;
                                            unsafe3 = unsafe5;
                                            zzej zzejVar17 = zzejVar10;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 == 0) {
                                                i13 = i7 | i56;
                                                i39 = zzek.zzl(bArr15, i39, zzejVar17);
                                                zzii.zzm(obj8, j, zzejVar17.zzb != 0);
                                                bArr4 = bArr15;
                                                zzejVar10 = zzejVar17;
                                                unsafe5 = unsafe3;
                                                break;
                                            }
                                            obj3 = obj8;
                                            unsafe2 = unsafe3;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzejVar2 = zzejVar;
                                            i9 = i50;
                                            break;
                                        case 8:
                                            byte[] bArr16 = bArr9;
                                            unsafe3 = unsafe5;
                                            zzej zzejVar18 = zzejVar10;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 == 2) {
                                                if ((i54 & C.BUFFER_FLAG_LAST_SAMPLE) == 0) {
                                                    i39 = zzek.zzi(bArr16, i39, zzejVar18);
                                                    int i59 = zzejVar18.zza;
                                                    if (i59 < 0) {
                                                        throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    i14 = i7 | i56;
                                                    if (i59 != 0) {
                                                        zzejVar18.zzc = new String(bArr16, i39, i59, zzga.zza);
                                                        i39 += i59;
                                                    } else {
                                                        zzejVar18.zzc = "";
                                                    }
                                                } else {
                                                    i39 = zzek.zzg(bArr16, i39, zzejVar18);
                                                    i14 = i7 | i56;
                                                }
                                                unsafe3.putObject(obj8, j, zzejVar18.zzc);
                                                zzejVar10 = zzejVar18;
                                                unsafe5 = unsafe3;
                                                bArr9 = bArr16;
                                                i37 = i2;
                                                break;
                                            }
                                            obj3 = obj8;
                                            unsafe2 = unsafe3;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzejVar2 = zzejVar;
                                            i9 = i50;
                                            break;
                                        case 9:
                                            obj4 = obj8;
                                            int i60 = i42;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            if (i52 != 2) {
                                                i7 = i60;
                                                unsafe2 = unsafe5;
                                                obj3 = obj4;
                                                bArr2 = bArr;
                                                i4 = i3;
                                                obj2 = obj3;
                                                unsafe = unsafe2;
                                                zzejVar2 = zzejVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                i42 = i60 | i56;
                                                Unsafe unsafe7 = unsafe5;
                                                Object zzx = zzheVar.zzx(obj4, i38);
                                                byte[] bArr17 = bArr9;
                                                zzej zzejVar19 = zzejVar10;
                                                int zzn = zzek.zzn(zzx, zzheVar.zzv(i38), bArr17, i39, i2, zzejVar19);
                                                zzheVar.zzF(obj4, i38, zzx);
                                                zzejVar10 = zzejVar19;
                                                unsafe5 = unsafe7;
                                                bArr9 = bArr17;
                                                i37 = i2;
                                                i39 = zzn;
                                                break;
                                            }
                                        case 10:
                                            obj4 = obj8;
                                            i15 = i42;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            if (i52 == 2) {
                                                i15 |= i56;
                                                i39 = zzek.zza(bArr9, i39, zzejVar10);
                                                unsafe5.putObject(obj4, j, zzejVar10.zzc);
                                                break;
                                            }
                                            unsafe2 = unsafe5;
                                            i7 = i15;
                                            obj3 = obj4;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzejVar2 = zzejVar;
                                            i9 = i50;
                                            break;
                                        case 12:
                                            obj4 = obj8;
                                            i15 = i42;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            if (i52 == 0) {
                                                i39 = zzek.zzi(bArr9, i39, zzejVar10);
                                                int i61 = zzejVar10.zza;
                                                zzfx zzu = zzheVar.zzu(i38);
                                                if ((i54 & Integer.MIN_VALUE) == 0 || zzu == null || zzu.zza(i61)) {
                                                    i15 |= i56;
                                                    unsafe5.putInt(obj4, j, i61);
                                                    break;
                                                } else {
                                                    zzd(obj4).zzj(i8, Long.valueOf(i61));
                                                    break;
                                                }
                                            }
                                            unsafe2 = unsafe5;
                                            i7 = i15;
                                            obj3 = obj4;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzejVar2 = zzejVar;
                                            i9 = i50;
                                            break;
                                        case 15:
                                            obj4 = obj8;
                                            i15 = i42;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            if (i52 == 0) {
                                                i15 |= i56;
                                                i39 = zzek.zzi(bArr9, i39, zzejVar10);
                                                unsafe5.putInt(obj4, j, zzey.zzb(zzejVar10.zza));
                                                break;
                                            }
                                            unsafe2 = unsafe5;
                                            i7 = i15;
                                            obj3 = obj4;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzejVar2 = zzejVar;
                                            i9 = i50;
                                            break;
                                        case 16:
                                            if (i52 != 0) {
                                                i8 = i49;
                                                i38 = i53;
                                                i6 = i44;
                                                i7 = i42;
                                                unsafe2 = unsafe5;
                                                obj3 = obj8;
                                                bArr2 = bArr;
                                                i4 = i3;
                                                obj2 = obj3;
                                                unsafe = unsafe2;
                                                zzejVar2 = zzejVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                i42 |= i56;
                                                int zzl2 = zzek.zzl(bArr9, i39, zzejVar10);
                                                unsafe5.putLong(obj8, j, zzey.zzc(zzejVar10.zzb));
                                                i39 = zzl2;
                                                i40 = i53;
                                                i43 = i50;
                                                i41 = i49;
                                                i38 = 0;
                                                i45 = 1048575;
                                                i37 = i2;
                                                break;
                                            }
                                        default:
                                            zzej zzejVar20 = zzejVar10;
                                            byte[] bArr18 = bArr9;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            unsafe2 = unsafe5;
                                            obj3 = obj8;
                                            if (i52 != 3) {
                                                bArr2 = bArr;
                                                i4 = i3;
                                                obj2 = obj3;
                                                unsafe = unsafe2;
                                                zzejVar2 = zzejVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                Object zzx2 = zzheVar.zzx(obj3, i38);
                                                int zzm = zzek.zzm(zzx2, zzheVar.zzv(i38), bArr18, i39, i2, (i50 << 3) | 4, zzejVar20);
                                                zzheVar.zzF(obj3, i38, zzx2);
                                                bArr9 = bArr;
                                                zzejVar10 = zzejVar;
                                                i39 = zzm;
                                                i40 = i38;
                                                i43 = i50;
                                                i41 = i8;
                                                obj8 = obj3;
                                                unsafe5 = unsafe2;
                                                i44 = i6;
                                                i38 = 0;
                                                i45 = 1048575;
                                                i42 = i7 | i56;
                                                i37 = i2;
                                                break;
                                            }
                                    }
                                } else {
                                    Unsafe unsafe8 = unsafe5;
                                    obj2 = obj8;
                                    str = "Failed to parse the message.";
                                    i38 = i53;
                                    if (zzr != 27) {
                                        i7 = i42;
                                        zzej zzejVar21 = zzejVar;
                                        Unsafe unsafe9 = unsafe8;
                                        i6 = i44;
                                        i16 = i50;
                                        if (zzr <= 49) {
                                            long j2 = i54;
                                            zzfz zzfzVar2 = (zzfz) unsafe9.getObject(obj2, j);
                                            if (!zzfzVar2.zzc()) {
                                                int size = zzfzVar2.size();
                                                zzfzVar2 = zzfzVar2.zzd(size + size);
                                                unsafe9.putObject(obj2, j, zzfzVar2);
                                            }
                                            switch (zzr) {
                                                case 18:
                                                case 35:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzejVar4 = zzejVar21;
                                                    i8 = i49;
                                                    zzfz zzfzVar3 = zzfzVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 1) {
                                                            i18 = i17 + 8;
                                                            int i62 = zzek.zza;
                                                            zzfe zzfeVar = (zzfe) zzfzVar3;
                                                            zzfeVar.zzf(Double.longBitsToDouble(zzek.zzp(bArr5, i17)));
                                                            while (i18 < i2) {
                                                                int zzi4 = zzek.zzi(bArr5, i18, zzejVar4);
                                                                if (i8 == zzejVar4.zza) {
                                                                    zzfeVar.zzf(Double.longBitsToDouble(zzek.zzp(bArr5, zzi4)));
                                                                    i18 = zzi4 + 8;
                                                                } else {
                                                                    zzi = i18;
                                                                    i19 = i17;
                                                                    zzejVar21 = zzejVar4;
                                                                    bArr6 = bArr5;
                                                                }
                                                            }
                                                            zzi = i18;
                                                            i19 = i17;
                                                            zzejVar21 = zzejVar4;
                                                            bArr6 = bArr5;
                                                        }
                                                        i19 = i17;
                                                        zzejVar21 = zzejVar4;
                                                        bArr6 = bArr5;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        int i63 = zzek.zza;
                                                        zzfe zzfeVar2 = (zzfe) zzfzVar3;
                                                        zzi = zzek.zzi(bArr5, i17, zzejVar4);
                                                        int i64 = zzejVar4.zza;
                                                        int i65 = zzi + i64;
                                                        if (i65 <= bArr5.length) {
                                                            zzfeVar2.zzg(zzfeVar2.size() + (i64 / 8));
                                                            while (zzi < i65) {
                                                                zzfeVar2.zzf(Double.longBitsToDouble(zzek.zzp(bArr5, zzi)));
                                                                zzi += 8;
                                                            }
                                                            if (zzi != i65) {
                                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            i19 = i17;
                                                            zzejVar21 = zzejVar4;
                                                            bArr6 = bArr5;
                                                            break;
                                                        } else {
                                                            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                case 19:
                                                case 36:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzejVar4 = zzejVar21;
                                                    i8 = i49;
                                                    zzfz zzfzVar4 = zzfzVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 5) {
                                                            i18 = i17 + 4;
                                                            int i66 = zzek.zza;
                                                            zzfo zzfoVar = (zzfo) zzfzVar4;
                                                            zzfoVar.zzf(Float.intBitsToFloat(zzek.zzb(bArr5, i17)));
                                                            while (i18 < i2) {
                                                                int zzi5 = zzek.zzi(bArr5, i18, zzejVar4);
                                                                if (i8 == zzejVar4.zza) {
                                                                    zzfoVar.zzf(Float.intBitsToFloat(zzek.zzb(bArr5, zzi5)));
                                                                    i18 = zzi5 + 4;
                                                                } else {
                                                                    zzi = i18;
                                                                    i19 = i17;
                                                                    zzejVar21 = zzejVar4;
                                                                    bArr6 = bArr5;
                                                                }
                                                            }
                                                            zzi = i18;
                                                            i19 = i17;
                                                            zzejVar21 = zzejVar4;
                                                            bArr6 = bArr5;
                                                        }
                                                        i19 = i17;
                                                        zzejVar21 = zzejVar4;
                                                        bArr6 = bArr5;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        int i67 = zzek.zza;
                                                        zzfo zzfoVar2 = (zzfo) zzfzVar4;
                                                        zzi = zzek.zzi(bArr5, i17, zzejVar4);
                                                        int i68 = zzejVar4.zza;
                                                        int i69 = zzi + i68;
                                                        if (i69 <= bArr5.length) {
                                                            zzfoVar2.zzg(zzfoVar2.size() + (i68 / 4));
                                                            while (zzi < i69) {
                                                                zzfoVar2.zzf(Float.intBitsToFloat(zzek.zzb(bArr5, zzi)));
                                                                zzi += 4;
                                                            }
                                                            if (zzi != i69) {
                                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            i19 = i17;
                                                            zzejVar21 = zzejVar4;
                                                            bArr6 = bArr5;
                                                            break;
                                                        } else {
                                                            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                case 20:
                                                case 21:
                                                case 37:
                                                case 38:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzejVar4 = zzejVar21;
                                                    i8 = i49;
                                                    zzfz zzfzVar5 = zzfzVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            int i70 = zzek.zza;
                                                            zzgp zzgpVar = (zzgp) zzfzVar5;
                                                            zzi = zzek.zzl(bArr5, i17, zzejVar4);
                                                            zzgpVar.zzf(zzejVar4.zzb);
                                                            while (zzi < i2) {
                                                                int zzi6 = zzek.zzi(bArr5, zzi, zzejVar4);
                                                                if (i8 == zzejVar4.zza) {
                                                                    zzi = zzek.zzl(bArr5, zzi6, zzejVar4);
                                                                    zzgpVar.zzf(zzejVar4.zzb);
                                                                }
                                                            }
                                                        }
                                                        i19 = i17;
                                                        zzejVar21 = zzejVar4;
                                                        bArr6 = bArr5;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        int i71 = zzek.zza;
                                                        zzgp zzgpVar2 = (zzgp) zzfzVar5;
                                                        zzi = zzek.zzi(bArr5, i17, zzejVar4);
                                                        int i72 = zzejVar4.zza + zzi;
                                                        while (zzi < i72) {
                                                            zzi = zzek.zzl(bArr5, zzi, zzejVar4);
                                                            zzgpVar2.zzf(zzejVar4.zzb);
                                                        }
                                                        if (zzi != i72) {
                                                            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    i19 = i17;
                                                    zzejVar21 = zzejVar4;
                                                    bArr6 = bArr5;
                                                    break;
                                                case 22:
                                                case 29:
                                                case 39:
                                                case 43:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzejVar4 = zzejVar21;
                                                    i8 = i49;
                                                    zzfz zzfzVar6 = zzfzVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            zzi = zzek.zzk(i8, bArr5, i17, i2, zzfzVar6, zzejVar4);
                                                            i19 = i17;
                                                            zzejVar21 = zzejVar4;
                                                            bArr6 = bArr5;
                                                        }
                                                        i19 = i17;
                                                        zzejVar21 = zzejVar4;
                                                        bArr6 = bArr5;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        i18 = zzek.zzf(bArr5, i17, zzfzVar6, zzejVar4);
                                                        zzi = i18;
                                                        i19 = i17;
                                                        zzejVar21 = zzejVar4;
                                                        bArr6 = bArr5;
                                                        break;
                                                    }
                                                case 23:
                                                case 32:
                                                case 40:
                                                case 46:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzejVar4 = zzejVar21;
                                                    int i73 = i16;
                                                    i8 = i49;
                                                    zzfz zzfzVar7 = zzfzVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        i16 = i73;
                                                        if (i52 == 1) {
                                                            i18 = i17 + 8;
                                                            int i74 = zzek.zza;
                                                            zzgp zzgpVar3 = (zzgp) zzfzVar7;
                                                            zzgpVar3.zzf(zzek.zzp(bArr5, i17));
                                                            while (i18 < i2) {
                                                                int zzi7 = zzek.zzi(bArr5, i18, zzejVar4);
                                                                if (i8 == zzejVar4.zza) {
                                                                    zzgpVar3.zzf(zzek.zzp(bArr5, zzi7));
                                                                    i18 = zzi7 + 8;
                                                                } else {
                                                                    zzi = i18;
                                                                    i19 = i17;
                                                                    zzejVar21 = zzejVar4;
                                                                    bArr6 = bArr5;
                                                                }
                                                            }
                                                            zzi = i18;
                                                            i19 = i17;
                                                            zzejVar21 = zzejVar4;
                                                            bArr6 = bArr5;
                                                        }
                                                        i19 = i17;
                                                        zzejVar21 = zzejVar4;
                                                        bArr6 = bArr5;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        int i75 = zzek.zza;
                                                        zzgp zzgpVar4 = (zzgp) zzfzVar7;
                                                        zzi = zzek.zzi(bArr5, i17, zzejVar4);
                                                        int i76 = zzejVar4.zza;
                                                        int i77 = zzi + i76;
                                                        if (i77 <= bArr5.length) {
                                                            zzgpVar4.zzg(zzgpVar4.size() + (i76 / 8));
                                                            while (zzi < i77) {
                                                                zzgpVar4.zzf(zzek.zzp(bArr5, zzi));
                                                                zzi += 8;
                                                                i73 = i73;
                                                            }
                                                            i16 = i73;
                                                            if (zzi != i77) {
                                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            i19 = i17;
                                                            zzejVar21 = zzejVar4;
                                                            bArr6 = bArr5;
                                                            break;
                                                        } else {
                                                            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                case 24:
                                                case 31:
                                                case 41:
                                                case 45:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzejVar5 = zzejVar21;
                                                    i20 = i16;
                                                    i8 = i49;
                                                    zzfz zzfzVar8 = zzfzVar2;
                                                    i21 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 5) {
                                                            int i78 = i21 + 4;
                                                            int i79 = zzek.zza;
                                                            zzfv zzfvVar = (zzfv) zzfzVar8;
                                                            zzfvVar.zzg(zzek.zzb(bArr5, i21));
                                                            while (i78 < i2) {
                                                                int zzi8 = zzek.zzi(bArr5, i78, zzejVar5);
                                                                if (i8 == zzejVar5.zza) {
                                                                    zzfvVar.zzg(zzek.zzb(bArr5, zzi8));
                                                                    i78 = zzi8 + 4;
                                                                } else {
                                                                    zzi = i78;
                                                                }
                                                            }
                                                            zzi = i78;
                                                        }
                                                        zzejVar21 = zzejVar5;
                                                        i16 = i20;
                                                        i19 = i21;
                                                        bArr6 = bArr5;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        int i80 = zzek.zza;
                                                        zzfv zzfvVar2 = (zzfv) zzfzVar8;
                                                        zzi = zzek.zzi(bArr5, i21, zzejVar5);
                                                        int i81 = zzejVar5.zza;
                                                        int i82 = zzi + i81;
                                                        if (i82 <= bArr5.length) {
                                                            zzfvVar2.zzh(zzfvVar2.size() + (i81 / 4));
                                                            while (zzi < i82) {
                                                                zzfvVar2.zzg(zzek.zzb(bArr5, zzi));
                                                                zzi += 4;
                                                            }
                                                            if (zzi != i82) {
                                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                        } else {
                                                            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    zzejVar21 = zzejVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    break;
                                                case 25:
                                                case 42:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzejVar5 = zzejVar21;
                                                    i20 = i16;
                                                    i8 = i49;
                                                    zzfz zzfzVar9 = zzfzVar2;
                                                    i21 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            int i83 = zzek.zza;
                                                            zzel zzelVar = (zzel) zzfzVar9;
                                                            zzi = zzek.zzl(bArr5, i21, zzejVar5);
                                                            zzelVar.zze(zzejVar5.zzb != 0);
                                                            while (zzi < i2) {
                                                                int zzi9 = zzek.zzi(bArr5, zzi, zzejVar5);
                                                                if (i8 == zzejVar5.zza) {
                                                                    zzi = zzek.zzl(bArr5, zzi9, zzejVar5);
                                                                    zzelVar.zze(zzejVar5.zzb != 0);
                                                                }
                                                            }
                                                        }
                                                        zzejVar21 = zzejVar5;
                                                        i16 = i20;
                                                        i19 = i21;
                                                        bArr6 = bArr5;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        int i84 = zzek.zza;
                                                        zzel zzelVar2 = (zzel) zzfzVar9;
                                                        zzi = zzek.zzi(bArr5, i21, zzejVar5);
                                                        int i85 = zzejVar5.zza + zzi;
                                                        while (zzi < i85) {
                                                            zzi = zzek.zzl(bArr5, zzi, zzejVar5);
                                                            zzelVar2.zze(zzejVar5.zzb != 0);
                                                        }
                                                        if (zzi != i85) {
                                                            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    zzejVar21 = zzejVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    break;
                                                case 26:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzejVar5 = zzejVar21;
                                                    i20 = i16;
                                                    i8 = i49;
                                                    zzfz zzfzVar10 = zzfzVar2;
                                                    i21 = i39;
                                                    if (i52 == 2) {
                                                        if ((j2 & 536870912) == 0) {
                                                            zzi = zzek.zzi(bArr5, i21, zzejVar5);
                                                            int i86 = zzejVar5.zza;
                                                            if (i86 < 0) {
                                                                throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i86 == 0) {
                                                                obj5 = "";
                                                                zzfzVar10.add(obj5);
                                                                while (zzi < i2) {
                                                                    int zzi10 = zzek.zzi(bArr5, zzi, zzejVar5);
                                                                    if (i8 == zzejVar5.zza) {
                                                                        zzi = zzek.zzi(bArr5, zzi10, zzejVar5);
                                                                        i86 = zzejVar5.zza;
                                                                        if (i86 < 0) {
                                                                            throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                        if (i86 == 0) {
                                                                            zzfzVar10.add(obj5);
                                                                        } else {
                                                                            zzfzVar10.add(new String(bArr5, zzi, i86, zzga.zza));
                                                                            zzi += i86;
                                                                            while (zzi < i2) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                obj5 = "";
                                                                zzfzVar10.add(new String(bArr5, zzi, i86, zzga.zza));
                                                                zzi += i86;
                                                                while (zzi < i2) {
                                                                }
                                                            }
                                                        } else {
                                                            zzi = zzek.zzi(bArr5, i21, zzejVar5);
                                                            int i87 = zzejVar5.zza;
                                                            if (i87 < 0) {
                                                                throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i87 == 0) {
                                                                zzfzVar10.add("");
                                                                while (zzi < i2) {
                                                                    int zzi11 = zzek.zzi(bArr5, zzi, zzejVar5);
                                                                    if (i8 == zzejVar5.zza) {
                                                                        zzi = zzek.zzi(bArr5, zzi11, zzejVar5);
                                                                        int i88 = zzejVar5.zza;
                                                                        if (i88 < 0) {
                                                                            throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                        if (i88 == 0) {
                                                                            zzfzVar10.add("");
                                                                        } else {
                                                                            int i89 = zzi + i88;
                                                                            if (zzin.zzc(bArr5, zzi, i89)) {
                                                                                i22 = i89;
                                                                                zzfzVar10.add(new String(bArr5, zzi, i88, zzga.zza));
                                                                                zzi = i22;
                                                                                while (zzi < i2) {
                                                                                }
                                                                            } else {
                                                                                throw new zzgc("Protocol message had invalid UTF-8.");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                int i90 = zzi + i87;
                                                                if (zzin.zzc(bArr5, zzi, i90)) {
                                                                    i22 = i90;
                                                                    zzfzVar10.add(new String(bArr5, zzi, i87, zzga.zza));
                                                                    zzi = i22;
                                                                    while (zzi < i2) {
                                                                    }
                                                                } else {
                                                                    throw new zzgc("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                        }
                                                        zzejVar21 = zzejVar5;
                                                        i16 = i20;
                                                        i19 = i21;
                                                        bArr6 = bArr5;
                                                        break;
                                                    }
                                                    zzejVar21 = zzejVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    zzi = i19;
                                                    break;
                                                case 27:
                                                    bArr5 = bArr;
                                                    i23 = i49;
                                                    unsafe4 = unsafe9;
                                                    zzejVar5 = zzejVar21;
                                                    i20 = i16;
                                                    zzfz zzfzVar11 = zzfzVar2;
                                                    i21 = i39;
                                                    if (i52 == 2) {
                                                        i8 = i23;
                                                        int zze = zzek.zze(zzheVar.zzv(i38), i8, bArr5, i21, i2, zzfzVar11, zzejVar5);
                                                        bArr5 = bArr5;
                                                        i21 = i21;
                                                        zzi = zze;
                                                        zzejVar21 = zzejVar5;
                                                        i16 = i20;
                                                        i19 = i21;
                                                        bArr6 = bArr5;
                                                        break;
                                                    }
                                                    i8 = i23;
                                                    zzejVar21 = zzejVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    zzi = i19;
                                                    break;
                                                case 28:
                                                    bArr5 = bArr;
                                                    i23 = i49;
                                                    unsafe4 = unsafe9;
                                                    zzejVar5 = zzejVar21;
                                                    i20 = i16;
                                                    zzfz zzfzVar12 = zzfzVar2;
                                                    i21 = i39;
                                                    if (i52 == 2) {
                                                        zzi = zzek.zzi(bArr5, i21, zzejVar5);
                                                        int i91 = zzejVar5.zza;
                                                        if (i91 >= 0) {
                                                            if (i91 > bArr5.length - zzi) {
                                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            if (i91 == 0) {
                                                                zzfzVar12.add(zzev.zza);
                                                                while (zzi < i2) {
                                                                    int zzi12 = zzek.zzi(bArr5, zzi, zzejVar5);
                                                                    if (i23 != zzejVar5.zza) {
                                                                        i8 = i23;
                                                                        zzejVar21 = zzejVar5;
                                                                        i16 = i20;
                                                                        i19 = i21;
                                                                        bArr6 = bArr5;
                                                                        break;
                                                                    } else {
                                                                        zzi = zzek.zzi(bArr5, zzi12, zzejVar5);
                                                                        i91 = zzejVar5.zza;
                                                                        if (i91 >= 0) {
                                                                            if (i91 > bArr5.length - zzi) {
                                                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                            }
                                                                            if (i91 == 0) {
                                                                                zzfzVar12.add(zzev.zza);
                                                                            } else {
                                                                                zzfzVar12.add(zzev.zzk(bArr5, zzi, i91));
                                                                                zzi += i91;
                                                                                while (zzi < i2) {
                                                                                }
                                                                            }
                                                                        } else {
                                                                            throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                    }
                                                                }
                                                                i8 = i23;
                                                                zzejVar21 = zzejVar5;
                                                                i16 = i20;
                                                                i19 = i21;
                                                                bArr6 = bArr5;
                                                            } else {
                                                                zzfzVar12.add(zzev.zzk(bArr5, zzi, i91));
                                                                zzi += i91;
                                                                while (zzi < i2) {
                                                                }
                                                                i8 = i23;
                                                                zzejVar21 = zzejVar5;
                                                                i16 = i20;
                                                                i19 = i21;
                                                                bArr6 = bArr5;
                                                            }
                                                        } else {
                                                            throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                    }
                                                    i8 = i23;
                                                    zzejVar21 = zzejVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    zzi = i19;
                                                    break;
                                                case 30:
                                                case 44:
                                                    if (i52 != 2) {
                                                        if (i52 != 0) {
                                                            unsafe4 = unsafe9;
                                                            bArr6 = bArr;
                                                            i8 = i49;
                                                            i19 = i39;
                                                            zzi = i19;
                                                            break;
                                                        } else {
                                                            zzfz zzfzVar13 = zzfzVar2;
                                                            bArr5 = bArr;
                                                            i24 = i49;
                                                            i21 = i39;
                                                            zzejVar6 = zzejVar21;
                                                            zzk = zzek.zzk(i24, bArr5, i21, i2, zzfzVar13, zzejVar6);
                                                            zzfzVar = zzfzVar13;
                                                        }
                                                    } else {
                                                        bArr5 = bArr;
                                                        zzejVar6 = zzejVar21;
                                                        zzk = zzek.zzf(bArr, i39, zzfzVar2, zzejVar21);
                                                        i24 = i49;
                                                        zzfzVar = zzfzVar2;
                                                        i21 = i39;
                                                    }
                                                    zzfx zzu2 = zzheVar.zzu(i38);
                                                    zzib zzibVar = zzheVar.zzl;
                                                    int i92 = zzhn.zza;
                                                    if (zzu2 == null) {
                                                        i25 = zzk;
                                                        unsafe4 = unsafe9;
                                                        i26 = i16;
                                                    } else if (zzfzVar instanceof RandomAccess) {
                                                        int size2 = zzfzVar.size();
                                                        i25 = zzk;
                                                        Object obj9 = null;
                                                        int i93 = 0;
                                                        int i94 = 0;
                                                        while (i93 < size2) {
                                                            Unsafe unsafe10 = unsafe9;
                                                            int intValue = ((Integer) zzfzVar.get(i93)).intValue();
                                                            if (zzu2.zza(intValue)) {
                                                                if (i93 != i94) {
                                                                    zzfzVar.set(i94, Integer.valueOf(intValue));
                                                                }
                                                                i94++;
                                                                i27 = i93;
                                                                i28 = i16;
                                                            } else {
                                                                i27 = i93;
                                                                i28 = i16;
                                                                obj9 = zzhn.zzo(obj2, i28, intValue, obj9, zzibVar);
                                                            }
                                                            i16 = i28;
                                                            i93 = i27 + 1;
                                                            unsafe9 = unsafe10;
                                                        }
                                                        unsafe4 = unsafe9;
                                                        i26 = i16;
                                                        if (i94 != size2) {
                                                            zzfzVar.subList(i94, size2).clear();
                                                        }
                                                    } else {
                                                        i25 = zzk;
                                                        unsafe4 = unsafe9;
                                                        i26 = i16;
                                                        Iterator it = zzfzVar.iterator();
                                                        Object obj10 = null;
                                                        while (it.hasNext()) {
                                                            int intValue2 = ((Integer) it.next()).intValue();
                                                            if (!zzu2.zza(intValue2)) {
                                                                obj10 = zzhn.zzo(obj2, i26, intValue2, obj10, zzibVar);
                                                                it.remove();
                                                            }
                                                        }
                                                    }
                                                    i8 = i24;
                                                    zzejVar21 = zzejVar6;
                                                    i16 = i26;
                                                    zzi = i25;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    break;
                                                case 33:
                                                case 47:
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            int i95 = zzek.zza;
                                                            zzfv zzfvVar3 = (zzfv) zzfzVar2;
                                                            zzi2 = zzek.zzi(bArr, i39, zzejVar21);
                                                            zzfvVar3.zzg(zzey.zzb(zzejVar21.zza));
                                                            while (zzi2 < i2) {
                                                                int zzi13 = zzek.zzi(bArr, zzi2, zzejVar21);
                                                                if (i49 == zzejVar21.zza) {
                                                                    zzi2 = zzek.zzi(bArr, zzi13, zzejVar21);
                                                                    zzfvVar3.zzg(zzey.zzb(zzejVar21.zza));
                                                                }
                                                            }
                                                        }
                                                        bArr6 = bArr;
                                                        i19 = i39;
                                                        unsafe4 = unsafe9;
                                                        i8 = i49;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        int i96 = zzek.zza;
                                                        zzfv zzfvVar4 = (zzfv) zzfzVar2;
                                                        zzi2 = zzek.zzi(bArr, i39, zzejVar21);
                                                        int i97 = zzejVar21.zza + zzi2;
                                                        while (zzi2 < i97) {
                                                            zzi2 = zzek.zzi(bArr, zzi2, zzejVar21);
                                                            zzfvVar4.zzg(zzey.zzb(zzejVar21.zza));
                                                        }
                                                        if (zzi2 != i97) {
                                                            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    zzi = zzi2;
                                                    bArr6 = bArr;
                                                    i19 = i39;
                                                    unsafe4 = unsafe9;
                                                    i8 = i49;
                                                    break;
                                                case 34:
                                                case 48:
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            int i98 = zzek.zza;
                                                            zzgp zzgpVar5 = (zzgp) zzfzVar2;
                                                            zzi2 = zzek.zzl(bArr, i39, zzejVar21);
                                                            zzgpVar5.zzf(zzey.zzc(zzejVar21.zzb));
                                                            while (zzi2 < i2) {
                                                                int zzi14 = zzek.zzi(bArr, zzi2, zzejVar21);
                                                                if (i49 == zzejVar21.zza) {
                                                                    zzi2 = zzek.zzl(bArr, zzi14, zzejVar21);
                                                                    zzgpVar5.zzf(zzey.zzc(zzejVar21.zzb));
                                                                }
                                                            }
                                                        }
                                                        bArr6 = bArr;
                                                        i19 = i39;
                                                        unsafe4 = unsafe9;
                                                        i8 = i49;
                                                        zzi = i19;
                                                        break;
                                                    } else {
                                                        int i99 = zzek.zza;
                                                        zzgp zzgpVar6 = (zzgp) zzfzVar2;
                                                        zzi2 = zzek.zzi(bArr, i39, zzejVar21);
                                                        int i100 = zzejVar21.zza + zzi2;
                                                        while (zzi2 < i100) {
                                                            zzi2 = zzek.zzl(bArr, zzi2, zzejVar21);
                                                            zzgpVar6.zzf(zzey.zzc(zzejVar21.zzb));
                                                        }
                                                        if (zzi2 != i100) {
                                                            throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    zzi = zzi2;
                                                    bArr6 = bArr;
                                                    i19 = i39;
                                                    unsafe4 = unsafe9;
                                                    i8 = i49;
                                                    break;
                                                default:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    int i101 = i2;
                                                    zzejVar4 = zzejVar21;
                                                    i8 = i49;
                                                    zzfz zzfzVar14 = zzfzVar2;
                                                    i17 = i39;
                                                    if (i52 == 3) {
                                                        int i102 = (i8 & (-8)) | 4;
                                                        zzhl zzv = zzheVar.zzv(i38);
                                                        int zzc = zzek.zzc(zzv, bArr5, i17, i101, i102, zzejVar4);
                                                        i19 = i17;
                                                        zzfzVar14.add(zzejVar4.zzc);
                                                        while (zzc < i101) {
                                                            int zzi15 = zzek.zzi(bArr5, zzc, zzejVar4);
                                                            if (i8 != zzejVar4.zza) {
                                                                bArr6 = bArr5;
                                                                zzejVar21 = zzejVar4;
                                                                zzi = zzc;
                                                                break;
                                                            } else {
                                                                zzc = zzek.zzc(zzv, bArr5, zzi15, i101, i102, zzejVar4);
                                                                zzfzVar14.add(zzejVar4.zzc);
                                                                i101 = i2;
                                                                bArr5 = bArr5;
                                                            }
                                                        }
                                                        bArr6 = bArr5;
                                                        zzejVar21 = zzejVar4;
                                                        zzi = zzc;
                                                    }
                                                    i19 = i17;
                                                    zzejVar21 = zzejVar4;
                                                    bArr6 = bArr5;
                                                    zzi = i19;
                                                    break;
                                            }
                                            if (zzi != i19) {
                                                i37 = i2;
                                                bArr9 = bArr6;
                                                i39 = zzi;
                                                obj8 = obj2;
                                                i40 = i38;
                                                i41 = i8;
                                                zzejVar10 = zzejVar21;
                                                i44 = i6;
                                                i42 = i7;
                                                i43 = i16;
                                                unsafe5 = unsafe4;
                                            } else {
                                                i4 = i3;
                                                bArr2 = bArr6;
                                                i39 = zzi;
                                                zzejVar2 = zzejVar21;
                                                i9 = i16;
                                                unsafe = unsafe4;
                                            }
                                        } else {
                                            i29 = i39;
                                            i8 = i49;
                                            bArr7 = bArr;
                                            if (zzr != 50) {
                                                unsafe = unsafe9;
                                                long j3 = iArr[i38 + 2] & 1048575;
                                                switch (zzr) {
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i31 = i8;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        if (i52 == 1) {
                                                            i33 = i32 + 8;
                                                            unsafe.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzek.zzp(bArr2, i32))));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = i33;
                                                            break;
                                                        }
                                                        i39 = i32;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i31 = i8;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        if (i52 == 5) {
                                                            i33 = i32 + 4;
                                                            unsafe.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzek.zzb(bArr2, i32))));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = i33;
                                                            break;
                                                        }
                                                        i39 = i32;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i31 = i8;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        if (i52 == 0) {
                                                            i33 = zzek.zzl(bArr2, i32, zzejVar2);
                                                            unsafe.putObject(obj2, j, Long.valueOf(zzejVar2.zzb));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = i33;
                                                            break;
                                                        }
                                                        i39 = i32;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                                    case RectListKt.BitOffsetForGesturable /* 62 */:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i31 = i8;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        if (i52 == 0) {
                                                            i33 = zzek.zzi(bArr2, i32, zzejVar2);
                                                            unsafe.putObject(obj2, j, Integer.valueOf(zzejVar2.zza));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = i33;
                                                            break;
                                                        }
                                                        i39 = i32;
                                                        break;
                                                    case 56:
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i31 = i8;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        if (i52 == 1) {
                                                            i33 = i32 + 8;
                                                            unsafe.putObject(obj2, j, Long.valueOf(zzek.zzp(bArr2, i32)));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = i33;
                                                            break;
                                                        }
                                                        i39 = i32;
                                                        break;
                                                    case 57:
                                                    case 64:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i31 = i8;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        if (i52 == 5) {
                                                            i33 = i32 + 4;
                                                            unsafe.putObject(obj2, j, Integer.valueOf(zzek.zzb(bArr2, i32)));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = i33;
                                                            break;
                                                        }
                                                        i39 = i32;
                                                        break;
                                                    case 58:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        if (i52 == 0) {
                                                            i33 = zzek.zzl(bArr2, i32, zzejVar2);
                                                            i31 = i8;
                                                            unsafe.putObject(obj2, j, Boolean.valueOf(zzejVar2.zzb != 0));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = i33;
                                                            break;
                                                        }
                                                        i31 = i8;
                                                        i39 = i32;
                                                        break;
                                                    case 59:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        if (i52 == 2) {
                                                            int zzi16 = zzek.zzi(bArr2, i32, zzejVar2);
                                                            int i103 = zzejVar2.zza;
                                                            if (i103 == 0) {
                                                                unsafe.putObject(obj2, j, "");
                                                            } else {
                                                                int i104 = zzi16 + i103;
                                                                if ((i54 & C.BUFFER_FLAG_LAST_SAMPLE) == 0 || zzin.zzc(bArr2, zzi16, i104)) {
                                                                    unsafe.putObject(obj2, j, new String(bArr2, zzi16, i103, zzga.zza));
                                                                    zzi16 = i104;
                                                                } else {
                                                                    throw new zzgc("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = zzi16;
                                                            i31 = i8;
                                                            break;
                                                        }
                                                        i31 = i8;
                                                        i39 = i32;
                                                        break;
                                                    case 60:
                                                        bArr8 = bArr;
                                                        zzejVar7 = zzejVar;
                                                        str = str;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        if (i52 == 2) {
                                                            Object zzy = zzheVar.zzy(obj2, i9, i38);
                                                            int zzn2 = zzek.zzn(zzy, zzheVar.zzv(i38), bArr8, i34, i2, zzejVar7);
                                                            zzejVar2 = zzejVar7;
                                                            bArr2 = bArr8;
                                                            zzheVar.zzG(obj2, i9, i38, zzy);
                                                            i30 = i38;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            i39 = zzn2;
                                                            break;
                                                        }
                                                        zzejVar2 = zzejVar7;
                                                        bArr2 = bArr8;
                                                        i30 = i38;
                                                        i31 = i8;
                                                        i32 = i34;
                                                        i39 = i32;
                                                        break;
                                                    case 61:
                                                        bArr8 = bArr;
                                                        zzejVar7 = zzejVar;
                                                        str = str;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        if (i52 == 2) {
                                                            zza2 = zzek.zza(bArr8, i34, zzejVar7);
                                                            unsafe.putObject(obj2, j, zzejVar7.zzc);
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = zza2;
                                                            zzejVar2 = zzejVar7;
                                                            bArr2 = bArr8;
                                                            i30 = i38;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            break;
                                                        }
                                                        zzejVar2 = zzejVar7;
                                                        bArr2 = bArr8;
                                                        i30 = i38;
                                                        i31 = i8;
                                                        i32 = i34;
                                                        i39 = i32;
                                                        break;
                                                    case 63:
                                                        bArr8 = bArr;
                                                        zzejVar7 = zzejVar;
                                                        str = str;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        i35 = i8;
                                                        if (i52 == 0) {
                                                            zza2 = zzek.zzi(bArr8, i34, zzejVar7);
                                                            int i105 = zzejVar7.zza;
                                                            zzfx zzu3 = zzheVar.zzu(i38);
                                                            if (zzu3 == null || zzu3.zza(i105)) {
                                                                i8 = i35;
                                                                unsafe.putObject(obj2, j, Integer.valueOf(i105));
                                                                unsafe.putInt(obj2, j3, i9);
                                                            } else {
                                                                i8 = i35;
                                                                zzd(obj2).zzj(i8, Long.valueOf(i105));
                                                            }
                                                            i39 = zza2;
                                                            zzejVar2 = zzejVar7;
                                                            bArr2 = bArr8;
                                                            i30 = i38;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            break;
                                                        }
                                                        int i106 = i35;
                                                        zzejVar2 = zzejVar7;
                                                        bArr2 = bArr8;
                                                        i31 = i106;
                                                        i30 = i38;
                                                        i32 = i34;
                                                        i39 = i32;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                        bArr8 = bArr;
                                                        zzejVar7 = zzejVar;
                                                        str = str;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        i35 = i8;
                                                        if (i52 == 0) {
                                                            zzi3 = zzek.zzi(bArr8, i34, zzejVar7);
                                                            unsafe.putObject(obj2, j, Integer.valueOf(zzey.zzb(zzejVar7.zza)));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            int i107 = i35;
                                                            zzejVar2 = zzejVar7;
                                                            bArr2 = bArr8;
                                                            i31 = i107;
                                                            i39 = zzi3;
                                                            i30 = i38;
                                                            i32 = i34;
                                                            break;
                                                        }
                                                        int i1062 = i35;
                                                        zzejVar2 = zzejVar7;
                                                        bArr2 = bArr8;
                                                        i31 = i1062;
                                                        i30 = i38;
                                                        i32 = i34;
                                                        i39 = i32;
                                                        break;
                                                    case 67:
                                                        bArr8 = bArr;
                                                        zzejVar7 = zzejVar;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        if (i52 != 0) {
                                                            str = str;
                                                            zzejVar2 = zzejVar7;
                                                            bArr2 = bArr8;
                                                            i30 = i38;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            i39 = i32;
                                                            break;
                                                        } else {
                                                            zzi3 = zzek.zzl(bArr8, i34, zzejVar7);
                                                            str = str;
                                                            i35 = i8;
                                                            unsafe.putObject(obj2, j, Long.valueOf(zzey.zzc(zzejVar7.zzb)));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            int i1072 = i35;
                                                            zzejVar2 = zzejVar7;
                                                            bArr2 = bArr8;
                                                            i31 = i1072;
                                                            i39 = zzi3;
                                                            i30 = i38;
                                                            i32 = i34;
                                                            break;
                                                        }
                                                    case 68:
                                                        if (i52 != 3) {
                                                            i9 = i16;
                                                            bArr2 = bArr;
                                                            i30 = i38;
                                                            str = str;
                                                            i31 = i8;
                                                            i32 = i29;
                                                            zzejVar2 = zzejVar;
                                                            i39 = i32;
                                                            break;
                                                        } else {
                                                            i9 = i16;
                                                            Object zzy2 = zzheVar.zzy(obj2, i9, i38);
                                                            int zzm2 = zzek.zzm(zzy2, zzheVar.zzv(i38), bArr, i29, i2, (i8 & (-8)) | 4, zzejVar);
                                                            i34 = i29;
                                                            zzheVar.zzG(obj2, i9, i38, zzy2);
                                                            i39 = zzm2;
                                                            zzejVar2 = zzejVar;
                                                            bArr2 = bArr;
                                                            i30 = i38;
                                                            str = str;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            break;
                                                        }
                                                    default:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i31 = i8;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzejVar2 = zzejVar;
                                                        i39 = i32;
                                                        break;
                                                }
                                                if (i39 != i32) {
                                                    int i108 = i31;
                                                    bArr9 = bArr2;
                                                    i41 = i108;
                                                    unsafe5 = unsafe;
                                                    obj8 = obj2;
                                                    zzejVar10 = zzejVar2;
                                                    i43 = i9;
                                                    i44 = i6;
                                                    i42 = i7;
                                                    i40 = i30;
                                                    i38 = 0;
                                                    i45 = 1048575;
                                                    i37 = i2;
                                                } else {
                                                    i4 = i3;
                                                    i8 = i31;
                                                    i38 = i30;
                                                }
                                            } else if (i52 == 2) {
                                                Object zzw = zzheVar.zzw(i38);
                                                unsafe = unsafe9;
                                                Object object = unsafe.getObject(obj2, j);
                                                if (!((zzgv) object).zze()) {
                                                    zzgv zzb2 = zzgv.zza().zzb();
                                                    zzgw.zza(zzb2, object);
                                                    unsafe.putObject(obj2, j, zzb2);
                                                    object = zzb2;
                                                }
                                                zzgt zzc2 = ((zzgu) zzw).zzc();
                                                zzgv zzgvVar = (zzgv) object;
                                                int zzi17 = zzek.zzi(bArr7, i29, zzejVar21);
                                                int i109 = zzejVar21.zza;
                                                if (i109 >= 0 && i109 <= i2 - zzi17) {
                                                    int i110 = zzi17 + i109;
                                                    Object obj11 = zzc2.zzb;
                                                    Object obj12 = zzc2.zzd;
                                                    Object obj13 = obj12;
                                                    while (zzi17 < i110) {
                                                        int i111 = zzi17 + 1;
                                                        int i112 = bArr7[zzi17];
                                                        if (i112 < 0) {
                                                            i111 = zzek.zzj(i112, bArr7, i111, zzejVar21);
                                                            i112 = zzejVar21.zza;
                                                        }
                                                        Object obj14 = obj11;
                                                        int i113 = i112 >>> 3;
                                                        int i114 = i112 & 7;
                                                        Object obj15 = obj12;
                                                        if (i113 == 1) {
                                                            int i115 = i111;
                                                            zzej zzejVar22 = zzejVar21;
                                                            obj6 = obj14;
                                                            zzir zzirVar = zzc2.zza;
                                                            if (i114 == zzirVar.zza()) {
                                                                int zzO = zzO(bArr, i115, i2, zzirVar, null, zzejVar22);
                                                                bArr7 = bArr;
                                                                obj11 = zzejVar22.zzc;
                                                                zzi17 = zzO;
                                                                zzejVar21 = zzejVar22;
                                                                obj13 = obj13;
                                                                obj12 = obj15;
                                                            } else {
                                                                bArr7 = bArr;
                                                                i36 = i2;
                                                                obj7 = obj13;
                                                                zzejVar9 = zzejVar22;
                                                                i111 = i115;
                                                            }
                                                        } else if (i113 != 2) {
                                                            bArr7 = bArr;
                                                            i36 = i2;
                                                            obj7 = obj13;
                                                            zzejVar9 = zzejVar21;
                                                            obj6 = obj14;
                                                        } else {
                                                            zzir zzirVar2 = zzc2.zzc;
                                                            if (i114 == zzirVar2.zza()) {
                                                                int i116 = i111;
                                                                zzej zzejVar23 = zzejVar21;
                                                                int zzO2 = zzO(bArr, i116, i2, zzirVar2, obj15.getClass(), zzejVar23);
                                                                obj13 = zzejVar23.zzc;
                                                                bArr7 = bArr;
                                                                zzi17 = zzO2;
                                                                obj11 = obj14;
                                                                obj12 = obj15;
                                                                zzejVar21 = zzejVar23;
                                                            } else {
                                                                int i117 = i111;
                                                                zzej zzejVar24 = zzejVar21;
                                                                obj6 = obj14;
                                                                i111 = i117;
                                                                obj7 = obj13;
                                                                zzejVar9 = zzejVar24;
                                                                bArr7 = bArr;
                                                                i36 = i2;
                                                            }
                                                        }
                                                        zzi17 = zzek.zzo(i112, bArr7, i111, i36, zzejVar9);
                                                        zzej zzejVar25 = zzejVar9;
                                                        obj13 = obj7;
                                                        obj11 = obj6;
                                                        zzejVar21 = zzejVar25;
                                                        obj12 = obj15;
                                                    }
                                                    zzej zzejVar26 = zzejVar21;
                                                    Object obj16 = obj11;
                                                    Object obj17 = obj13;
                                                    if (zzi17 == i110) {
                                                        zzgvVar.put(obj16, obj17);
                                                        if (i110 != i29) {
                                                            bArr9 = bArr7;
                                                            unsafe5 = unsafe;
                                                            obj8 = obj2;
                                                            i39 = i110;
                                                            i41 = i8;
                                                            i44 = i6;
                                                            i42 = i7;
                                                            i45 = 1048575;
                                                            i37 = i2;
                                                            zzejVar10 = zzejVar26;
                                                            i40 = i38;
                                                            i43 = i16;
                                                            i38 = 0;
                                                        } else {
                                                            i4 = i3;
                                                            bArr2 = bArr7;
                                                            zzejVar2 = zzejVar26;
                                                            i39 = i110;
                                                            i9 = i16;
                                                        }
                                                    } else {
                                                        throw new zzgc(str);
                                                    }
                                                }
                                            } else {
                                                zzejVar8 = zzejVar21;
                                                unsafe = unsafe9;
                                            }
                                        }
                                    } else if (i52 == 2) {
                                        zzfz zzfzVar15 = (zzfz) unsafe8.getObject(obj2, j);
                                        if (!zzfzVar15.zzc()) {
                                            int size3 = zzfzVar15.size();
                                            zzfzVar15 = zzfzVar15.zzd(size3 == 0 ? 10 : size3 + size3);
                                            unsafe8.putObject(obj2, j, zzfzVar15);
                                        }
                                        int zze2 = zzek.zze(zzheVar.zzv(i38), i49, bArr, i39, i2, zzfzVar15, zzejVar);
                                        bArr9 = bArr;
                                        i37 = i2;
                                        i41 = i49;
                                        obj8 = obj2;
                                        i40 = i38;
                                        i43 = i50;
                                        i38 = 0;
                                        i45 = 1048575;
                                        zzejVar10 = zzejVar;
                                        i39 = zze2;
                                        unsafe5 = unsafe8;
                                    } else {
                                        i6 = i44;
                                        i29 = i39;
                                        zzejVar8 = zzejVar;
                                        i16 = i50;
                                        unsafe = unsafe8;
                                        i7 = i42;
                                        i8 = i49;
                                        bArr7 = bArr;
                                    }
                                    i4 = i3;
                                    bArr2 = bArr7;
                                    str = str;
                                    i39 = i29;
                                    i9 = i16;
                                    zzejVar2 = zzejVar8;
                                }
                            }
                            if (i8 == i4 || i4 == 0) {
                                if (zzheVar.zzh) {
                                    zzfh zzfhVar = zzejVar2.zzd;
                                    int i118 = zzfh.zzb;
                                    int i119 = zzei.zza;
                                    if (zzfhVar != zzfh.zza) {
                                        zzhb zzhbVar = zzheVar.zzg;
                                        int i120 = zzek.zza;
                                        if (zzfhVar.zza(zzhbVar, i9) == null) {
                                            i10 = i2;
                                            i39 = zzek.zzh(i8, bArr2, i39, i10, zzd(obj2), zzejVar2);
                                            bArr9 = bArr;
                                            unsafe5 = unsafe;
                                            obj8 = obj2;
                                            i40 = i38;
                                            i41 = i8;
                                            i44 = i6;
                                            i38 = 0;
                                            i45 = 1048575;
                                            zzejVar10 = zzejVar;
                                            i37 = i10;
                                            i43 = i9;
                                            i42 = i7;
                                        } else {
                                            zzfr zzfrVar = (zzfr) obj2;
                                            throw null;
                                        }
                                    }
                                }
                                i10 = i2;
                                i39 = zzek.zzh(i8, bArr, i39, i10, zzd(obj2), zzejVar);
                                bArr9 = bArr;
                                unsafe5 = unsafe;
                                obj8 = obj2;
                                i40 = i38;
                                i41 = i8;
                                i44 = i6;
                                i38 = 0;
                                i45 = 1048575;
                                zzejVar10 = zzejVar;
                                i37 = i10;
                                i43 = i9;
                                i42 = i7;
                            } else {
                                i5 = i2;
                                i41 = i8;
                                i44 = i6;
                                i42 = i7;
                            }
                        }
                        zzq = -1;
                        if (zzq != -1) {
                        }
                        if (i8 == i4) {
                        }
                        if (zzheVar.zzh) {
                        }
                        i10 = i2;
                        i39 = zzek.zzh(i8, bArr, i39, i10, zzd(obj2), zzejVar);
                        bArr9 = bArr;
                        unsafe5 = unsafe;
                        obj8 = obj2;
                        i40 = i38;
                        i41 = i8;
                        i44 = i6;
                        i38 = 0;
                        i45 = 1048575;
                        zzejVar10 = zzejVar;
                        i37 = i10;
                        i43 = i9;
                        i42 = i7;
                    }
                } else {
                    i4 = i3;
                    obj2 = obj8;
                    i5 = i37;
                    str = "Failed to parse the message.";
                    unsafe = unsafe5;
                }
            }
            i38 = 0;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final Object zze() {
        return ((zzfu) this.zzg).zzs();
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzfu) {
                zzfu zzfuVar = (zzfu) obj;
                zzfuVar.zzC(Integer.MAX_VALUE);
                zzfuVar.zza = 0;
                zzfuVar.zzA();
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
                            case 49:
                                ((zzfz) zzii.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgv) object).zzc();
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
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
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
                            zzii.zzo(obj, j, zzii.zza(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzp(obj, j, zzii.zzb(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzr(obj, j, zzii.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzr(obj, j, zzii.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzq(obj, j, zzii.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzr(obj, j, zzii.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzq(obj, j, zzii.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzm(obj, j, zzii.zzw(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzs(obj, j, zzii.zzf(obj2, j));
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
                            zzii.zzs(obj, j, zzii.zzf(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzq(obj, j, zzii.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzq(obj, j, zzii.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzq(obj, j, zzii.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzr(obj, j, zzii.zzd(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzq(obj, j, zzii.zzc(obj2, j));
                            zzD(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzI(obj2, i)) {
                            break;
                        } else {
                            zzii.zzr(obj, j, zzii.zzd(obj2, j));
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
                    case 49:
                        zzfz zzfzVar = (zzfz) zzii.zzf(obj, j);
                        zzfz zzfzVar2 = (zzfz) zzii.zzf(obj2, j);
                        int size = zzfzVar.size();
                        int size2 = zzfzVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzfzVar.zzc()) {
                                zzfzVar = zzfzVar.zzd(size2 + size);
                            }
                            zzfzVar.addAll(zzfzVar2);
                        }
                        if (size > 0) {
                            zzfzVar2 = zzfzVar;
                        }
                        zzii.zzs(obj, j, zzfzVar2);
                        break;
                    case 50:
                        int i4 = zzhn.zza;
                        zzii.zzs(obj, j, zzgw.zza(zzii.zzf(obj, j), zzii.zzf(obj2, j)));
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
                            zzii.zzs(obj, j, zzii.zzf(obj2, j));
                            zzE(obj, i3, i);
                            break;
                        }
                    case 60:
                        zzC(obj, obj2, i);
                        break;
                    case 61:
                    case RectListKt.BitOffsetForGesturable /* 62 */:
                    case 63:
                    case 64:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    case 67:
                        if (!zzM(obj2, i3, i)) {
                            break;
                        } else {
                            zzii.zzs(obj, j, zzii.zzf(obj2, j));
                            zzE(obj, i3, i);
                            break;
                        }
                    case 68:
                        zzC(obj, obj2, i);
                        break;
                }
                i += 3;
            } else {
                zzhn.zzq(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzhn.zzp(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzej zzejVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzejVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04cf  */
    @Override // com.google.android.gms.internal.play_billing.zzhl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(Object obj, zzit zzitVar) throws IOException {
        Map.Entry entry;
        int[] iArr;
        int i;
        int i2;
        int i3;
        zzhe<T> zzheVar = this;
        if (zzheVar.zzh) {
            zzfm zzfmVar = ((zzfr) obj).zzb;
            if (!zzfmVar.zza.isEmpty()) {
                entry = (Map.Entry) zzfmVar.zzf().next();
                iArr = zzheVar.zzc;
                Unsafe unsafe = zzb;
                int i4 = 1048575;
                int i5 = 1048575;
                i = 0;
                int i6 = 0;
                while (i < iArr.length) {
                    int zzs = zzheVar.zzs(i);
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
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzf(i7, zzii.zza(obj, j));
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 1:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzo(i7, zzii.zzb(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 2:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzt(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 3:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzL(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 4:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzr(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 5:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzm(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 6:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzk(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 7:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzb(i7, zzii.zzw(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 8:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzP(i7, unsafe.getObject(obj, j), zzitVar);
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 9:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzw(i7, unsafe.getObject(obj, j), zzheVar.zzv(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 10:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzd(i7, (zzev) unsafe.getObject(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 11:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzJ(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 12:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzi(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 13:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzy(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 14:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzA(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 15:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzC(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 16:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzE(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 17:
                                if (zzheVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzitVar.zzq(i7, unsafe.getObject(obj, j), zzheVar.zzv(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 18:
                                zzhn.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 19:
                                zzhn.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 20:
                                zzhn.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 21:
                                zzhn.zzE(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 22:
                                zzhn.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 23:
                                zzhn.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 24:
                                zzhn.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 25:
                                zzhn.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 26:
                                int i10 = iArr[i];
                                List list = (List) unsafe.getObject(obj, j);
                                int i11 = zzhn.zza;
                                if (list != null && !list.isEmpty()) {
                                    zzitVar.zzI(i10, list);
                                    break;
                                }
                                break;
                            case 27:
                                int i12 = iArr[i];
                                List list2 = (List) unsafe.getObject(obj, j);
                                zzhl zzv = zzheVar.zzv(i);
                                int i13 = zzhn.zza;
                                if (list2 != null && !list2.isEmpty()) {
                                    for (int i14 = 0; i14 < list2.size(); i14++) {
                                        ((zzfd) zzitVar).zzw(i12, list2.get(i14), zzv);
                                    }
                                    break;
                                }
                                break;
                            case 28:
                                int i15 = iArr[i];
                                List list3 = (List) unsafe.getObject(obj, j);
                                int i16 = zzhn.zza;
                                if (list3 != null && !list3.isEmpty()) {
                                    zzitVar.zze(i15, list3);
                                    break;
                                }
                                break;
                            case 29:
                                zzhn.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 30:
                                zzhn.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 31:
                                zzhn.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 32:
                                zzhn.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 33:
                                zzhn.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 34:
                                zzhn.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzheVar = this;
                            case 35:
                                zzhn.zzs(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 36:
                                zzhn.zzw(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 37:
                                zzhn.zzy(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 38:
                                zzhn.zzE(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 39:
                                zzhn.zzx(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 40:
                                zzhn.zzv(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 41:
                                zzhn.zzu(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 42:
                                zzhn.zzr(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 43:
                                zzhn.zzD(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 44:
                                zzhn.zzt(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 45:
                                zzhn.zzz(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 46:
                                zzhn.zzA(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 47:
                                zzhn.zzB(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 48:
                                zzhn.zzC(iArr[i], (List) unsafe.getObject(obj, j), zzitVar, true);
                                break;
                            case 49:
                                int i17 = iArr[i];
                                List list4 = (List) unsafe.getObject(obj, j);
                                zzhl zzv2 = zzheVar.zzv(i);
                                int i18 = zzhn.zza;
                                if (list4 != null && !list4.isEmpty()) {
                                    for (int i19 = 0; i19 < list4.size(); i19++) {
                                        ((zzfd) zzitVar).zzq(i17, list4.get(i19), zzv2);
                                    }
                                    break;
                                }
                                break;
                            case 50:
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    zzitVar.zzv(i7, ((zzgu) zzheVar.zzw(i)).zzc(), (zzgv) object);
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzf(i7, zzm(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzo(i7, zzn(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzt(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzL(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzr(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 56:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzm(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case 57:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzk(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 58:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzb(i7, zzN(obj, j));
                                    break;
                                }
                                break;
                            case 59:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzP(i7, unsafe.getObject(obj, j), zzitVar);
                                    break;
                                }
                                break;
                            case 60:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzw(i7, unsafe.getObject(obj, j), zzheVar.zzv(i));
                                    break;
                                }
                                break;
                            case 61:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzd(i7, (zzev) unsafe.getObject(obj, j));
                                    break;
                                }
                                break;
                            case RectListKt.BitOffsetForGesturable /* 62 */:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzJ(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 63:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzi(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 64:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzy(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzA(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzC(i7, zzo(obj, j));
                                    break;
                                }
                                break;
                            case 67:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzE(i7, zzt(obj, j));
                                    break;
                                }
                                break;
                            case 68:
                                if (zzheVar.zzM(obj, i7, i)) {
                                    zzitVar.zzq(i7, unsafe.getObject(obj, j), zzheVar.zzv(i));
                                    break;
                                }
                                break;
                        }
                        i += 3;
                        i4 = 1048575;
                        zzheVar = this;
                    } else {
                        zzfs zzfsVar = (zzfs) entry.getKey();
                        throw null;
                    }
                }
                if (entry != null) {
                    ((zzfu) obj).zzc.zzl(zzitVar);
                    return;
                } else {
                    zzfs zzfsVar2 = (zzfs) entry.getKey();
                    throw null;
                }
            }
        }
        entry = null;
        iArr = zzheVar.zzc;
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

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzF;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzs = zzs(i);
            long j = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzii.zza(obj, j)) == Double.doubleToLongBits(zzii.zza(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzii.zzb(obj, j)) == Float.floatToIntBits(zzii.zzb(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzii.zzd(obj, j) == zzii.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzii.zzd(obj, j) == zzii.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzii.zzc(obj, j) == zzii.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzii.zzd(obj, j) == zzii.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzii.zzc(obj, j) == zzii.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzii.zzw(obj, j) == zzii.zzw(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzii.zzc(obj, j) == zzii.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzii.zzc(obj, j) == zzii.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzii.zzc(obj, j) == zzii.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzii.zzd(obj, j) == zzii.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzii.zzc(obj, j) == zzii.zzc(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzii.zzd(obj, j) == zzii.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
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
                case 49:
                    zzF = zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j));
                    break;
                case 50:
                    zzF = zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j));
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
                case 61:
                case RectListKt.BitOffsetForGesturable /* 62 */:
                case 63:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                case 68:
                    long zzp = zzp(i) & 1048575;
                    if (zzii.zzc(obj, zzp) == zzii.zzc(obj2, zzp) && zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzF) {
                return false;
            }
        }
        if (((zzfu) obj).zzc.equals(((zzfu) obj2).zzc)) {
            if (this.zzh) {
                return ((zzfr) obj).zzb.equals(((zzfr) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
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
                        if (zzr != 50) {
                            continue;
                        } else {
                            zzgv zzgvVar = (zzgv) zzii.zzf(obj, zzs & 1048575);
                            if (!zzgvVar.isEmpty() && ((zzgu) zzw(i2)).zzc().zzc.zzb() == zzis.MESSAGE) {
                                zzhl zzhlVar = null;
                                for (Object obj2 : zzgvVar.values()) {
                                    if (zzhlVar == null) {
                                        zzhlVar = zzhi.zza().zzb(obj2.getClass());
                                    }
                                    if (!zzhlVar.zzk(obj2)) {
                                        return false;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                }
                List list = (List) zzii.zzf(obj, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhl zzv = zzv(i2);
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
        return !this.zzh || ((zzfr) obj).zzb.zzj();
    }
}
