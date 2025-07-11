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
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzno<T> implements zznw<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzoo.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznl zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoh zzl;
    private final zzlr zzm;

    private zzno(int[] iArr, Object[] objArr, int i, int i2, zznl zznlVar, boolean z, int[] iArr2, int i3, int i4, zznq zznqVar, zzmx zzmxVar, zzoh zzohVar, zzlr zzlrVar, zzng zzngVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzlrVar != null && (zznlVar instanceof zzmb)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzohVar;
        this.zzm = zzlrVar;
        this.zzg = zznlVar;
    }

    private static boolean zzA(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzme) {
            return ((zzme) obj).zzcf();
        }
        return true;
    }

    private static void zzB(Object obj) {
        if (zzA(obj)) {
            return;
        }
        String valueOf = String.valueOf(obj);
        String.valueOf(valueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(valueOf)));
    }

    private static double zzC(Object obj, long j) {
        return ((Double) zzoo.zzn(obj, j)).doubleValue();
    }

    private static float zzD(Object obj, long j) {
        return ((Float) zzoo.zzn(obj, j)).floatValue();
    }

    private static int zzE(Object obj, long j) {
        return ((Integer) zzoo.zzn(obj, j)).intValue();
    }

    private static long zzF(Object obj, long j) {
        return ((Long) zzoo.zzn(obj, j)).longValue();
    }

    private static boolean zzG(Object obj, long j) {
        return ((Boolean) zzoo.zzn(obj, j)).booleanValue();
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzJ(obj, i) == zzJ(obj2, i);
    }

    private final boolean zzI(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzJ(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzJ(Object obj, int i) {
        int zzy = zzy(i);
        long j = zzy & 1048575;
        if (j != 1048575) {
            return (zzoo.zzd(obj, j) & (1 << (zzy >>> 20))) != 0;
        }
        int zzx = zzx(i);
        long j2 = zzx & 1048575;
        switch (zzz(zzx)) {
            case 0:
                return Double.doubleToRawLongBits(zzoo.zzl(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzoo.zzj(obj, j2)) != 0;
            case 2:
                return zzoo.zzf(obj, j2) != 0;
            case 3:
                return zzoo.zzf(obj, j2) != 0;
            case 4:
                return zzoo.zzd(obj, j2) != 0;
            case 5:
                return zzoo.zzf(obj, j2) != 0;
            case 6:
                return zzoo.zzd(obj, j2) != 0;
            case 7:
                return zzoo.zzh(obj, j2);
            case 8:
                Object zzn = zzoo.zzn(obj, j2);
                if (zzn instanceof String) {
                    return !((String) zzn).isEmpty();
                } else if (zzn instanceof zzlg) {
                    return !zzlg.zzb.equals(zzn);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzoo.zzn(obj, j2) != null;
            case 10:
                return !zzlg.zzb.equals(zzoo.zzn(obj, j2));
            case 11:
                return zzoo.zzd(obj, j2) != 0;
            case 12:
                return zzoo.zzd(obj, j2) != 0;
            case 13:
                return zzoo.zzd(obj, j2) != 0;
            case 14:
                return zzoo.zzf(obj, j2) != 0;
            case 15:
                return zzoo.zzd(obj, j2) != 0;
            case 16:
                return zzoo.zzf(obj, j2) != 0;
            case 17:
                return zzoo.zzn(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzK(Object obj, int i) {
        int zzy = zzy(i);
        long j = 1048575 & zzy;
        if (j == 1048575) {
            return;
        }
        zzoo.zze(obj, j, (1 << (zzy >>> 20)) | zzoo.zzd(obj, j));
    }

    private final boolean zzL(Object obj, int i, int i2) {
        return zzoo.zzd(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private final void zzM(Object obj, int i, int i2) {
        zzoo.zze(obj, zzy(i2) & 1048575, i);
    }

    private final int zzN(int i, int i2) {
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

    private static final int zzO(byte[] bArr, int i, int i2, zzos zzosVar, Class cls, zzkv zzkvVar) throws IOException {
        zzos zzosVar2 = zzos.DOUBLE;
        switch (zzosVar.ordinal()) {
            case 0:
                int i3 = i + 8;
                zzkvVar.zzc = Double.valueOf(Double.longBitsToDouble(zzkw.zze(bArr, i)));
                return i3;
            case 1:
                int i4 = i + 4;
                zzkvVar.zzc = Float.valueOf(Float.intBitsToFloat(zzkw.zzd(bArr, i)));
                return i4;
            case 2:
            case 3:
                int zzc = zzkw.zzc(bArr, i, zzkvVar);
                zzkvVar.zzc = Long.valueOf(zzkvVar.zzb);
                return zzc;
            case 4:
            case 12:
            case 13:
                int zza2 = zzkw.zza(bArr, i, zzkvVar);
                zzkvVar.zzc = Integer.valueOf(zzkvVar.zza);
                return zza2;
            case 5:
            case 15:
                int i5 = i + 8;
                zzkvVar.zzc = Long.valueOf(zzkw.zze(bArr, i));
                return i5;
            case 6:
            case 14:
                int i6 = i + 4;
                zzkvVar.zzc = Integer.valueOf(zzkw.zzd(bArr, i));
                return i6;
            case 7:
                int zzc2 = zzkw.zzc(bArr, i, zzkvVar);
                zzkvVar.zzc = Boolean.valueOf(zzkvVar.zzb != 0);
                return zzc2;
            case 8:
                return zzkw.zzf(bArr, i, zzkvVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return zzkw.zzh(zznt.zza().zzb(cls), bArr, i, i2, zzkvVar);
            case 11:
                return zzkw.zzg(bArr, i, zzkvVar);
            case 16:
                int zza3 = zzkw.zza(bArr, i, zzkvVar);
                zzkvVar.zzc = Integer.valueOf(zzli.zzb(zzkvVar.zza));
                return zza3;
            case 17:
                int zzc3 = zzkw.zzc(bArr, i, zzkvVar);
                zzkvVar.zzc = Long.valueOf(zzli.zzc(zzkvVar.zzb));
                return zzc3;
        }
    }

    private static final void zzP(int i, Object obj, zzou zzouVar) throws IOException {
        if (obj instanceof String) {
            zzouVar.zzm(i, (String) obj);
        } else {
            zzouVar.zzn(i, (zzlg) obj);
        }
    }

    static zzoi zzg(Object obj) {
        zzme zzmeVar = (zzme) obj;
        zzoi zzoiVar = zzmeVar.zzc;
        if (zzoiVar == zzoi.zza()) {
            zzoi zzb2 = zzoi.zzb();
            zzmeVar.zzc = zzb2;
            return zzb2;
        }
        return zzoiVar;
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
    public static zzno zzl(Class cls, zzni zzniVar, zznq zznqVar, zzmx zzmxVar, zzoh zzohVar, zzlr zzlrVar, zzng zzngVar) {
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
        Field zzm;
        char charAt10;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Object obj;
        Field zzm2;
        Object obj2;
        Field zzm3;
        int i30;
        char charAt11;
        int i31;
        char charAt12;
        int i32;
        char charAt13;
        int i33;
        char charAt14;
        if (zzniVar instanceof zznv) {
            zznv zznvVar = (zznv) zzniVar;
            String zzd = zznvVar.zzd();
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
            Object[] zze = zznvVar.zze();
            Class<?> cls2 = zznvVar.zzb().getClass();
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
                zznv zznvVar2 = zznvVar;
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
                            if (zznvVar2.zzc() == 1 || i79 != 0) {
                                i28 = i6 + 1;
                                int i87 = i69 / 3;
                                objArr[i87 + i87 + 1] = zze[i6];
                            } else {
                                i29 = 0;
                                int i88 = charAt25 + charAt25;
                                obj = zze[i88];
                                int i89 = i29;
                                if (obj instanceof Field) {
                                    zzm2 = (Field) obj;
                                } else {
                                    zzm2 = zzm(cls2, (String) obj);
                                    zze[i88] = zzm2;
                                }
                                int i90 = i7;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzm2);
                                int i91 = i88 + 1;
                                obj2 = zze[i91];
                                i19 = i90;
                                if (obj2 instanceof Field) {
                                    zzm3 = (Field) obj2;
                                } else {
                                    zzm3 = zzm(cls2, (String) obj2);
                                    zze[i91] = zzm3;
                                }
                                i21 = (int) unsafe.objectFieldOffset(zzm3);
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
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zzm2);
                        int i912 = i882 + 1;
                        obj2 = zze[i912];
                        i19 = i902;
                        if (obj2 instanceof Field) {
                        }
                        i21 = (int) unsafe.objectFieldOffset(zzm3);
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
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzm2);
                    int i9122 = i8822 + 1;
                    obj2 = zze[i9122];
                    i19 = i9022;
                    if (obj2 instanceof Field) {
                    }
                    i21 = (int) unsafe.objectFieldOffset(zzm3);
                    str = zzd;
                    i23 = i8922;
                    i17 = i84;
                    i22 = 0;
                    c = 55296;
                } else {
                    i18 = length;
                    i19 = i7;
                    int i92 = i6 + 1;
                    Field zzm4 = zzm(cls2, (String) zze[i6]);
                    if (i78 == 9 || i78 == 17) {
                        i20 = i92;
                        int i93 = i69 / 3;
                        objArr[i93 + i93 + 1] = zzm4.getType();
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
                            if (zznvVar2.zzc() == 1 || i79 != 0) {
                                i6 += 2;
                                int i94 = i69 / 3;
                                objArr[i94 + i94 + 1] = zze[i92];
                                str = zzd;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
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
                                        zzm = (Field) obj3;
                                    } else {
                                        zzm = zzm(cls2, (String) obj3);
                                        zze[i98] = zzm;
                                    }
                                    i22 = charAt26 % 32;
                                    i17 = i24;
                                    c = 55296;
                                    i21 = (int) unsafe.objectFieldOffset(zzm);
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
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
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
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
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
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
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
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
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
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzm4);
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
                zznvVar = zznvVar2;
                length = i18;
                i7 = i19;
            }
            return new zzno(iArr3, objArr, i2, i4, zznvVar.zzb(), false, iArr, i5, i64, zznqVar, zzmxVar, zzohVar, zzlrVar, zzngVar);
        }
        zzoe zzoeVar = (zzoe) zzniVar;
        throw null;
    }

    private static Field zzm(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(name).length() + 29 + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private final void zzn(Object obj, Object obj2, int i) {
        if (zzJ(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzx = zzx(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzx);
            if (object == null) {
                int i2 = this.zzc[i];
                String obj3 = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 38 + obj3.length());
                sb.append("Source subfield ");
                sb.append(i2);
                sb.append(" is present but null: ");
                sb.append(obj3);
                throw new IllegalStateException(sb.toString());
            }
            zznw zzp = zzp(i);
            if (!zzJ(obj, i)) {
                if (!zzA(object)) {
                    unsafe.putObject(obj, zzx, object);
                } else {
                    Object zza2 = zzp.zza();
                    zzp.zzd(zza2, object);
                    unsafe.putObject(obj, zzx, zza2);
                }
                zzK(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzx);
            if (!zzA(object2)) {
                Object zza3 = zzp.zza();
                zzp.zzd(zza3, object2);
                unsafe.putObject(obj, zzx, zza3);
                object2 = zza3;
            }
            zzp.zzd(object2, object);
        }
    }

    private final void zzo(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzL(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzx = zzx(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzx);
            if (object == null) {
                int i3 = iArr[i];
                String obj3 = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 38 + obj3.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(obj3);
                throw new IllegalStateException(sb.toString());
            }
            zznw zzp = zzp(i);
            if (!zzL(obj, i2, i)) {
                if (!zzA(object)) {
                    unsafe.putObject(obj, zzx, object);
                } else {
                    Object zza2 = zzp.zza();
                    zzp.zzd(zza2, object);
                    unsafe.putObject(obj, zzx, zza2);
                }
                zzM(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzx);
            if (!zzA(object2)) {
                Object zza3 = zzp.zza();
                zzp.zzd(zza3, object2);
                unsafe.putObject(obj, zzx, zza3);
                object2 = zza3;
            }
            zzp.zzd(object2, object);
        }
    }

    private final zznw zzp(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zznw zznwVar = (zznw) objArr[i3];
        if (zznwVar != null) {
            return zznwVar;
        }
        zznw zzb2 = zznt.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzq(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzmj zzr(int i) {
        int i2 = i / 3;
        return (zzmj) this.zzd[i2 + i2 + 1];
    }

    private final Object zzs(Object obj, int i) {
        zznw zzp = zzp(i);
        int zzx = zzx(i) & 1048575;
        if (!zzJ(obj, i)) {
            return zzp.zza();
        }
        Object object = zzb.getObject(obj, zzx);
        if (zzA(object)) {
            return object;
        }
        Object zza2 = zzp.zza();
        if (object != null) {
            zzp.zzd(zza2, object);
        }
        return zza2;
    }

    private final void zzt(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzx(i) & 1048575, obj2);
        zzK(obj, i);
    }

    private final Object zzu(Object obj, int i, int i2) {
        zznw zzp = zzp(i2);
        if (!zzL(obj, i, i2)) {
            return zzp.zza();
        }
        Object object = zzb.getObject(obj, zzx(i2) & 1048575);
        if (zzA(object)) {
            return object;
        }
        Object zza2 = zzp.zza();
        if (object != null) {
            zzp.zzd(zza2, object);
        }
        return zza2;
    }

    private final void zzv(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzx(i2) & 1048575, obj2);
        zzM(obj, i, i2);
    }

    private static boolean zzw(Object obj, int i, zznw zznwVar) {
        return zznwVar.zzk(zzoo.zzn(obj, i & 1048575));
    }

    private final int zzx(int i) {
        return this.zzc[i + 1];
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private static int zzz(int i) {
        return (i >>> 20) & 255;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final Object zza() {
        return ((zzme) this.zzg).zzch();
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final boolean zzb(Object obj, Object obj2) {
        boolean zzB;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzx = zzx(i);
            long j = zzx & 1048575;
            switch (zzz(zzx)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzoo.zzl(obj, j)) == Double.doubleToLongBits(zzoo.zzl(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzoo.zzj(obj, j)) == Float.floatToIntBits(zzoo.zzj(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzoo.zzf(obj, j) == zzoo.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzoo.zzf(obj, j) == zzoo.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzoo.zzd(obj, j) == zzoo.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzoo.zzf(obj, j) == zzoo.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzoo.zzd(obj, j) == zzoo.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzoo.zzh(obj, j) == zzoo.zzh(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zzny.zzB(zzoo.zzn(obj, j), zzoo.zzn(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zzny.zzB(zzoo.zzn(obj, j), zzoo.zzn(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zzny.zzB(zzoo.zzn(obj, j), zzoo.zzn(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzoo.zzd(obj, j) == zzoo.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzoo.zzd(obj, j) == zzoo.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzoo.zzd(obj, j) == zzoo.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzoo.zzf(obj, j) == zzoo.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzoo.zzd(obj, j) == zzoo.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzoo.zzf(obj, j) == zzoo.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zzny.zzB(zzoo.zzn(obj, j), zzoo.zzn(obj2, j))) {
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
                    zzB = zzny.zzB(zzoo.zzn(obj, j), zzoo.zzn(obj2, j));
                    break;
                case 50:
                    zzB = zzny.zzB(zzoo.zzn(obj, j), zzoo.zzn(obj2, j));
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
                    long zzy = zzy(i) & 1048575;
                    if (zzoo.zzd(obj, zzy) == zzoo.zzd(obj2, zzy) && zzny.zzB(zzoo.zzn(obj, j), zzoo.zzn(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzB) {
                return false;
            }
        }
        if (((zzme) obj).zzc.equals(((zzme) obj2).zzc)) {
            if (this.zzh) {
                return ((zzmb) obj).zzb.equals(((zzmb) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final int zzc(Object obj) {
        int i;
        long doubleToLongBits;
        int floatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 < iArr.length) {
                int zzx = zzx(i3);
                int i5 = 1048575 & zzx;
                int zzz = zzz(zzx);
                int i6 = iArr[i3];
                long j = i5;
                int i7 = 37;
                switch (zzz) {
                    case 0:
                        i = i4 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzoo.zzl(obj, j));
                        byte[] bArr = zzmo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 1:
                        i = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzoo.zzj(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 2:
                        i = i4 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j);
                        byte[] bArr2 = zzmo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 3:
                        i = i4 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j);
                        byte[] bArr3 = zzmo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 4:
                        i = i4 * 53;
                        floatToIntBits = zzoo.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 5:
                        i = i4 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j);
                        byte[] bArr4 = zzmo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 6:
                        i = i4 * 53;
                        floatToIntBits = zzoo.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 7:
                        i = i4 * 53;
                        floatToIntBits = zzmo.zzb(zzoo.zzh(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 8:
                        i = i4 * 53;
                        floatToIntBits = ((String) zzoo.zzn(obj, j)).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 9:
                        i2 = i4 * 53;
                        Object zzn = zzoo.zzn(obj, j);
                        if (zzn != null) {
                            i7 = zzn.hashCode();
                        }
                        i4 = i2 + i7;
                        break;
                    case 10:
                        i = i4 * 53;
                        floatToIntBits = zzoo.zzn(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 11:
                        i = i4 * 53;
                        floatToIntBits = zzoo.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 12:
                        i = i4 * 53;
                        floatToIntBits = zzoo.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 13:
                        i = i4 * 53;
                        floatToIntBits = zzoo.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 14:
                        i = i4 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j);
                        byte[] bArr5 = zzmo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 15:
                        i = i4 * 53;
                        floatToIntBits = zzoo.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 16:
                        i = i4 * 53;
                        doubleToLongBits = zzoo.zzf(obj, j);
                        byte[] bArr6 = zzmo.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 17:
                        i2 = i4 * 53;
                        Object zzn2 = zzoo.zzn(obj, j);
                        if (zzn2 != null) {
                            i7 = zzn2.hashCode();
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
                        floatToIntBits = zzoo.zzn(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 50:
                        i = i4 * 53;
                        floatToIntBits = zzoo.zzn(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = Double.doubleToLongBits(zzC(obj, j));
                            byte[] bArr7 = zzmo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = Float.floatToIntBits(zzD(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzF(obj, j);
                            byte[] bArr8 = zzmo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzF(obj, j);
                            byte[] bArr9 = zzmo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzE(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 56:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzF(obj, j);
                            byte[] bArr10 = zzmo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 57:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzE(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 58:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzmo.zzb(zzG(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 59:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = ((String) zzoo.zzn(obj, j)).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 60:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzoo.zzn(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzoo.zzn(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 62:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzE(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 63:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzE(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 64:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzE(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzF(obj, j);
                            byte[] bArr11 = zzmo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzE(obj, j);
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 67:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = zzF(obj, j);
                            byte[] bArr12 = zzmo.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 68:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzoo.zzn(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                }
                i3 += 3;
            } else {
                int hashCode = (i4 * 53) + ((zzme) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzmb) obj).zzb.zza.hashCode() : hashCode;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzd(Object obj, Object obj2) {
        zzB(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i < iArr.length) {
                int zzx = zzx(i);
                int i2 = 1048575 & zzx;
                int zzz = zzz(zzx);
                int i3 = iArr[i];
                long j = i2;
                switch (zzz) {
                    case 0:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzm(obj, j, zzoo.zzl(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzk(obj, j, zzoo.zzj(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j, zzoo.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j, zzoo.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zze(obj, j, zzoo.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j, zzoo.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zze(obj, j, zzoo.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzi(obj, j, zzoo.zzh(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzo(obj, j, zzoo.zzn(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 9:
                        zzn(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzo(obj, j, zzoo.zzn(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zze(obj, j, zzoo.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zze(obj, j, zzoo.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zze(obj, j, zzoo.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j, zzoo.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zze(obj, j, zzoo.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzoo.zzg(obj, j, zzoo.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 17:
                        zzn(obj, obj2, i);
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
                        zzmn zzmnVar = (zzmn) zzoo.zzn(obj, j);
                        zzmn zzmnVar2 = (zzmn) zzoo.zzn(obj2, j);
                        int size = zzmnVar.size();
                        int size2 = zzmnVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzmnVar.zza()) {
                                zzmnVar = zzmnVar.zzg(size2 + size);
                            }
                            zzmnVar.addAll(zzmnVar2);
                        }
                        if (size > 0) {
                            zzmnVar2 = zzmnVar;
                        }
                        zzoo.zzo(obj, j, zzmnVar2);
                        break;
                    case 50:
                        int i4 = zzny.zza;
                        zzoo.zzo(obj, j, zzng.zza(zzoo.zzn(obj, j), zzoo.zzn(obj2, j)));
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
                        if (!zzL(obj2, i3, i)) {
                            break;
                        } else {
                            zzoo.zzo(obj, j, zzoo.zzn(obj2, j));
                            zzM(obj, i3, i);
                            break;
                        }
                    case 60:
                        zzo(obj, obj2, i);
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    case 62:
                    case 63:
                    case 64:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    case 67:
                        if (!zzL(obj2, i3, i)) {
                            break;
                        } else {
                            zzoo.zzo(obj, j, zzoo.zzn(obj2, j));
                            zzM(obj, i3, i);
                            break;
                        }
                    case 68:
                        zzo(obj, obj2, i);
                        break;
                }
                i += 3;
            } else {
                zzny.zzD(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzny.zzC(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final int zze(Object obj) {
        int i;
        int zzz;
        int zzz2;
        int zzA;
        int zzz3;
        int zzz4;
        int zzz5;
        int zzc;
        int zzz6;
        int zzz7;
        int zzo;
        int size;
        int zzp;
        int zzz8;
        int zzz9;
        int zzz10;
        int i2;
        int zzx;
        int zzz11;
        int zzz12;
        int i3;
        int zzz13;
        int zzz14;
        int zzz15;
        int zzc2;
        int zzz16;
        zzno<T> zznoVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (true) {
            int[] iArr = zznoVar.zzc;
            if (i4 < iArr.length) {
                int zzx2 = zznoVar.zzx(i4);
                int zzz17 = zzz(zzx2);
                int i8 = iArr[i4];
                int i9 = iArr[i4 + 2];
                int i10 = i9 & 1048575;
                if (zzz17 <= 17) {
                    if (i10 != i7) {
                        i5 = i10 == 1048575 ? 0 : unsafe.getInt(obj2, i10);
                        i7 = i10;
                    }
                    i = 1 << (i9 >>> 20);
                } else {
                    i = 0;
                }
                int i11 = zzx2 & 1048575;
                if (zzz17 >= zzlw.DOUBLE_LIST_PACKED.zza()) {
                    zzlw.SINT64_LIST_PACKED.zza();
                }
                long j = i11;
                switch (zzz17) {
                    case 0:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            i6 += zzll.zzz(i8 << 3) + 8;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz = zzll.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 2:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            long j2 = unsafe.getLong(obj2, j);
                            zzz2 = zzll.zzz(i8 << 3);
                            zzA = zzll.zzA(j2);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 3:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            long j3 = unsafe.getLong(obj2, j);
                            zzz2 = zzll.zzz(i8 << 3);
                            zzA = zzll.zzA(j3);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 4:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz2 = zzll.zzz(i8 << 3);
                            zzA = zzll.zzA(unsafe.getInt(obj2, j));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 5:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz3 = zzll.zzz(i8 << 3);
                            zzz4 = zzz3 + 8;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 6:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz = zzll.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 7:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz4 = zzll.zzz(i8 << 3) + 1;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 8:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            int i12 = i8 << 3;
                            Object object = unsafe.getObject(obj2, j);
                            if (object instanceof zzlg) {
                                zzz5 = zzll.zzz(i12);
                                zzc = ((zzlg) object).zzc();
                                zzz6 = zzll.zzz(zzc);
                                zzz4 = zzz5 + zzz6 + zzc;
                                i6 += zzz4;
                            } else {
                                zzz2 = zzll.zzz(i12);
                                zzA = zzll.zzB((String) object);
                                zzz4 = zzz2 + zzA;
                                i6 += zzz4;
                            }
                        }
                        zznoVar = this;
                        break;
                    case 9:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz7 = zzny.zzz(i8, unsafe.getObject(obj2, j), zznoVar.zzp(i4));
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz5 = zzll.zzz(i8 << 3);
                            zzc = ((zzlg) unsafe.getObject(obj2, j)).zzc();
                            zzz6 = zzll.zzz(zzc);
                            zzz4 = zzz5 + zzz6 + zzc;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 11:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            int i13 = unsafe.getInt(obj2, j);
                            zzz2 = zzll.zzz(i8 << 3);
                            zzA = zzll.zzz(i13);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 12:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz2 = zzll.zzz(i8 << 3);
                            zzA = zzll.zzA(unsafe.getInt(obj2, j));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 13:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz = zzll.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 14:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz3 = zzll.zzz(i8 << 3);
                            zzz4 = zzz3 + 8;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 15:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            int i14 = unsafe.getInt(obj2, j);
                            zzz2 = zzll.zzz(i8 << 3);
                            zzA = zzll.zzz((i14 >> 31) ^ (i14 + i14));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 16:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            long j4 = unsafe.getLong(obj2, j);
                            zzz2 = zzll.zzz(i8 << 3);
                            zzA = zzll.zzA((j4 >> 63) ^ (j4 + j4));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznoVar = this;
                        break;
                    case 17:
                        if (zznoVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz7 = zzll.zzG(i8, (zznl) unsafe.getObject(obj2, j), zznoVar.zzp(i4));
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzz7 = zzny.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 19:
                        zzz7 = zzny.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(obj2, j);
                        int i15 = zzny.zza;
                        if (list.size() != 0) {
                            zzo = zzny.zzo(list) + (list.size() * zzll.zzz(i8 << 3));
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj2, j);
                        int i16 = zzny.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzp = zzny.zzp(list2);
                            zzz8 = zzll.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj2, j);
                        int i17 = zzny.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzp = zzny.zzs(list3);
                            zzz8 = zzll.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 23:
                        zzz7 = zzny.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 24:
                        zzz7 = zzny.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 25:
                        int i18 = zzny.zza;
                        int size2 = ((List) unsafe.getObject(obj2, j)).size();
                        if (size2 != 0) {
                            zzz7 = size2 * (zzll.zzz(i8 << 3) + 1);
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 26:
                        List list4 = (List) unsafe.getObject(obj2, j);
                        int i19 = zzny.zza;
                        int size3 = list4.size();
                        if (size3 != 0) {
                            zzo = zzll.zzz(i8 << 3) * size3;
                            if (list4 instanceof zzmw) {
                                zzmw zzmwVar = (zzmw) list4;
                                for (int i20 = 0; i20 < size3; i20++) {
                                    Object zzc3 = zzmwVar.zzc();
                                    if (zzc3 instanceof zzlg) {
                                        int zzc4 = ((zzlg) zzc3).zzc();
                                        zzo += zzll.zzz(zzc4) + zzc4;
                                    } else {
                                        zzo += zzll.zzB((String) zzc3);
                                    }
                                }
                            } else {
                                for (int i21 = 0; i21 < size3; i21++) {
                                    Object obj3 = list4.get(i21);
                                    if (obj3 instanceof zzlg) {
                                        int zzc5 = ((zzlg) obj3).zzc();
                                        zzo += zzll.zzz(zzc5) + zzc5;
                                    } else {
                                        zzo += zzll.zzB((String) obj3);
                                    }
                                }
                            }
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case 27:
                        List list5 = (List) unsafe.getObject(obj2, j);
                        zznw zzp2 = zznoVar.zzp(i4);
                        int i22 = zzny.zza;
                        int size4 = list5.size();
                        if (size4 == 0) {
                            zzz9 = 0;
                        } else {
                            zzz9 = zzll.zzz(i8 << 3) * size4;
                            for (int i23 = 0; i23 < size4; i23++) {
                                Object obj4 = list5.get(i23);
                                if (obj4 instanceof zzmv) {
                                    int zzb2 = ((zzmv) obj4).zzb();
                                    zzz9 += zzll.zzz(zzb2) + zzb2;
                                } else {
                                    zzz9 += zzll.zzD((zznl) obj4, zzp2);
                                }
                            }
                        }
                        i6 += zzz9;
                        break;
                    case 28:
                        List list6 = (List) unsafe.getObject(obj2, j);
                        int i24 = zzny.zza;
                        int size5 = list6.size();
                        if (size5 == 0) {
                            zzz10 = 0;
                        } else {
                            zzz10 = size5 * zzll.zzz(i8 << 3);
                            for (int i25 = 0; i25 < list6.size(); i25++) {
                                int zzc6 = ((zzlg) list6.get(i25)).zzc();
                                zzz10 += zzll.zzz(zzc6) + zzc6;
                            }
                        }
                        i6 += zzz10;
                        break;
                    case 29:
                        List list7 = (List) unsafe.getObject(obj2, j);
                        int i26 = zzny.zza;
                        size = list7.size();
                        if (size != 0) {
                            zzp = zzny.zzt(list7);
                            zzz8 = zzll.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 30:
                        List list8 = (List) unsafe.getObject(obj2, j);
                        int i27 = zzny.zza;
                        size = list8.size();
                        if (size != 0) {
                            zzp = zzny.zzr(list8);
                            zzz8 = zzll.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 31:
                        zzz7 = zzny.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 32:
                        zzz7 = zzny.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 33:
                        List list9 = (List) unsafe.getObject(obj2, j);
                        int i28 = zzny.zza;
                        size = list9.size();
                        if (size != 0) {
                            zzp = zzny.zzu(list9);
                            zzz8 = zzll.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 34:
                        List list10 = (List) unsafe.getObject(obj2, j);
                        int i29 = zzny.zza;
                        size = list10.size();
                        if (size != 0) {
                            zzp = zzny.zzq(list10);
                            zzz8 = zzll.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 35:
                        zzx = zzny.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzx = zzny.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzx = zzny.zzo((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzx = zzny.zzp((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzx = zzny.zzs((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzx = zzny.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzx = zzny.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i30 = zzny.zza;
                        zzx = ((List) unsafe.getObject(obj2, j)).size();
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzx = zzny.zzt((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzx = zzny.zzr((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzx = zzny.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzx = zzny.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzx = zzny.zzu((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzx = zzny.zzq((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzll.zzz(i8 << 3);
                            zzz12 = zzll.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        List list11 = (List) unsafe.getObject(obj2, j);
                        zznw zzp3 = zznoVar.zzp(i4);
                        int i31 = zzny.zza;
                        int size6 = list11.size();
                        if (size6 == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            for (int i32 = 0; i32 < size6; i32++) {
                                i3 += zzll.zzG(i8, (zznl) list11.get(i32), zzp3);
                            }
                        }
                        i6 += i3;
                        break;
                    case 50:
                        zznf zznfVar = (zznf) unsafe.getObject(obj2, j);
                        zzne zzneVar = (zzne) zznoVar.zzq(i4);
                        if (!zznfVar.isEmpty()) {
                            zzo = 0;
                            for (Map.Entry entry : zznfVar.entrySet()) {
                                zzo += zzneVar.zzd(i8, entry.getKey(), entry.getValue());
                            }
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz13 = zzll.zzz(i8 << 3);
                            zzz7 = zzz13 + 8;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz14 = zzll.zzz(i8 << 3);
                            zzz7 = zzz14 + 4;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            long zzF = zzF(obj2, j);
                            zzp = zzll.zzz(i8 << 3);
                            i2 = zzll.zzA(zzF);
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            long zzF2 = zzF(obj2, j);
                            zzp = zzll.zzz(i8 << 3);
                            i2 = zzll.zzA(zzF2);
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzp = zzll.zzz(i8 << 3);
                            i2 = zzll.zzA(zzE(obj2, j));
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz13 = zzll.zzz(i8 << 3);
                            zzz7 = zzz13 + 8;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz14 = zzll.zzz(i8 << 3);
                            zzz7 = zzz14 + 4;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz7 = zzll.zzz(i8 << 3) + 1;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!zznoVar.zzL(obj2, i8, i4)) {
                            break;
                        } else {
                            int i33 = i8 << 3;
                            Object object2 = unsafe.getObject(obj2, j);
                            if (object2 instanceof zzlg) {
                                zzz15 = zzll.zzz(i33);
                                zzc2 = ((zzlg) object2).zzc();
                                zzz16 = zzll.zzz(zzc2);
                                zzz7 = zzz15 + zzz16 + zzc2;
                                i6 += zzz7;
                                break;
                            } else {
                                zzp = zzll.zzz(i33);
                                i2 = zzll.zzB((String) object2);
                                zzz7 = zzp + i2;
                                i6 += zzz7;
                            }
                        }
                    case 60:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz7 = zzny.zzz(i8, unsafe.getObject(obj2, j), zznoVar.zzp(i4));
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz15 = zzll.zzz(i8 << 3);
                            zzc2 = ((zzlg) unsafe.getObject(obj2, j)).zzc();
                            zzz16 = zzll.zzz(zzc2);
                            zzz7 = zzz15 + zzz16 + zzc2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            int zzE = zzE(obj2, j);
                            zzp = zzll.zzz(i8 << 3);
                            i2 = zzll.zzz(zzE);
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzp = zzll.zzz(i8 << 3);
                            i2 = zzll.zzA(zzE(obj2, j));
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz14 = zzll.zzz(i8 << 3);
                            zzz7 = zzz14 + 4;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz13 = zzll.zzz(i8 << 3);
                            zzz7 = zzz13 + 8;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            int zzE2 = zzE(obj2, j);
                            zzp = zzll.zzz(i8 << 3);
                            i2 = zzll.zzz((zzE2 >> 31) ^ (zzE2 + zzE2));
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            long zzF3 = zzF(obj2, j);
                            zzp = zzll.zzz(i8 << 3);
                            i2 = zzll.zzA((zzF3 >> 63) ^ (zzF3 + zzF3));
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zznoVar.zzL(obj2, i8, i4)) {
                            zzz7 = zzll.zzG(i8, (zznl) unsafe.getObject(obj2, j), zznoVar.zzp(i4));
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                obj2 = obj;
            } else {
                int zzi = i6 + ((zzme) obj).zzc.zzi();
                if (zznoVar.zzh) {
                    zzod zzodVar = ((zzmb) obj).zzb.zza;
                    int zzc7 = zzodVar.zzc();
                    int i34 = 0;
                    for (int i35 = 0; i35 < zzc7; i35++) {
                        Map.Entry zzd = zzodVar.zzd(i35);
                        i34 += zzlv.zzj((zzlu) ((zzoa) zzd).zza(), zzd.getValue());
                    }
                    for (Map.Entry entry2 : zzodVar.zze()) {
                        i34 += zzlv.zzj((zzlu) entry2.getKey(), entry2.getValue());
                    }
                    return zzi + i34;
                }
                return zzi;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04cf  */
    @Override // com.google.android.gms.internal.measurement.zznw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzf(Object obj, zzou zzouVar) throws IOException {
        Map.Entry entry;
        int[] iArr;
        int i;
        int i2;
        int i3;
        zzno<T> zznoVar = this;
        if (zznoVar.zzh) {
            zzlv zzlvVar = ((zzmb) obj).zzb;
            if (!zzlvVar.zza.isEmpty()) {
                entry = (Map.Entry) zzlvVar.zzc().next();
                iArr = zznoVar.zzc;
                Unsafe unsafe = zzb;
                int i4 = 1048575;
                int i5 = 1048575;
                i = 0;
                int i6 = 0;
                while (i < iArr.length) {
                    int zzx = zznoVar.zzx(i);
                    int zzz = zzz(zzx);
                    int i7 = iArr[i];
                    if (zzz <= 17) {
                        int i8 = iArr[i + 2];
                        int i9 = i8 & i4;
                        if (i9 != i5) {
                            i6 = i9 == i4 ? 0 : unsafe.getInt(obj, i9);
                            i5 = i9;
                        }
                        i2 = zzx;
                        i3 = 1 << (i8 >>> 20);
                    } else {
                        i2 = zzx;
                        i3 = 0;
                    }
                    if (entry == null) {
                        long j = i2 & i4;
                        switch (zzz) {
                            case 0:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzf(i7, zzoo.zzl(obj, j));
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 1:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zze(i7, zzoo.zzj(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 2:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzc(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 3:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzh(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 4:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzi(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 5:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzj(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 6:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzk(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 7:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzl(i7, zzoo.zzh(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 8:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzP(i7, unsafe.getObject(obj, j), zzouVar);
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 9:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzr(i7, unsafe.getObject(obj, j), zznoVar.zzp(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 10:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzn(i7, (zzlg) unsafe.getObject(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 11:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzo(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 12:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzg(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 13:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzb(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 14:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzd(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 15:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzp(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 16:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzq(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 17:
                                if (zznoVar.zzI(obj, i, i5, i6, i3)) {
                                    zzouVar.zzs(i7, unsafe.getObject(obj, j), zznoVar.zzp(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 18:
                                zzny.zza(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 19:
                                zzny.zzb(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 20:
                                zzny.zzc(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 21:
                                zzny.zzd(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 22:
                                zzny.zzh(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 23:
                                zzny.zzf(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 24:
                                zzny.zzk(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 25:
                                zzny.zzn(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 26:
                                int i10 = iArr[i];
                                List list = (List) unsafe.getObject(obj, j);
                                int i11 = zzny.zza;
                                if (list != null && !list.isEmpty()) {
                                    zzouVar.zzF(i10, list);
                                    break;
                                }
                                break;
                            case 27:
                                int i12 = iArr[i];
                                List list2 = (List) unsafe.getObject(obj, j);
                                zznw zzp = zznoVar.zzp(i);
                                int i13 = zzny.zza;
                                if (list2 != null && !list2.isEmpty()) {
                                    for (int i14 = 0; i14 < list2.size(); i14++) {
                                        ((zzlm) zzouVar).zzr(i12, list2.get(i14), zzp);
                                    }
                                    break;
                                }
                                break;
                            case 28:
                                int i15 = iArr[i];
                                List list3 = (List) unsafe.getObject(obj, j);
                                int i16 = zzny.zza;
                                if (list3 != null && !list3.isEmpty()) {
                                    zzouVar.zzG(i15, list3);
                                    break;
                                }
                                break;
                            case 29:
                                zzny.zzi(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 30:
                                zzny.zzm(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 31:
                                zzny.zzl(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 32:
                                zzny.zzg(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 33:
                                zzny.zzj(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 34:
                                zzny.zze(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznoVar = this;
                            case 35:
                                zzny.zza(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 36:
                                zzny.zzb(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 37:
                                zzny.zzc(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 38:
                                zzny.zzd(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 39:
                                zzny.zzh(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 40:
                                zzny.zzf(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 41:
                                zzny.zzk(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 42:
                                zzny.zzn(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 43:
                                zzny.zzi(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 44:
                                zzny.zzm(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 45:
                                zzny.zzl(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 46:
                                zzny.zzg(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 47:
                                zzny.zzj(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case 48:
                                zzny.zze(iArr[i], (List) unsafe.getObject(obj, j), zzouVar, true);
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                int i17 = iArr[i];
                                List list4 = (List) unsafe.getObject(obj, j);
                                zznw zzp2 = zznoVar.zzp(i);
                                int i18 = zzny.zza;
                                if (list4 != null && !list4.isEmpty()) {
                                    for (int i19 = 0; i19 < list4.size(); i19++) {
                                        ((zzlm) zzouVar).zzs(i17, list4.get(i19), zzp2);
                                    }
                                    break;
                                }
                                break;
                            case 50:
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    zzouVar.zzM(i7, ((zzne) zznoVar.zzq(i)).zze(), (zznf) object);
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzf(i7, zzC(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zze(i7, zzD(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzc(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzh(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzi(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 56:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzj(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case 57:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzk(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 58:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzl(i7, zzG(obj, j));
                                    break;
                                }
                                break;
                            case 59:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzP(i7, unsafe.getObject(obj, j), zzouVar);
                                    break;
                                }
                                break;
                            case 60:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzr(i7, unsafe.getObject(obj, j), zznoVar.zzp(i));
                                    break;
                                }
                                break;
                            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzn(i7, (zzlg) unsafe.getObject(obj, j));
                                    break;
                                }
                                break;
                            case 62:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzo(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 63:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzg(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 64:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzb(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzd(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzp(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 67:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzq(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case 68:
                                if (zznoVar.zzL(obj, i7, i)) {
                                    zzouVar.zzs(i7, unsafe.getObject(obj, j), zznoVar.zzp(i));
                                    break;
                                }
                                break;
                        }
                        i += 3;
                        i4 = 1048575;
                        zznoVar = this;
                    } else {
                        zzmc zzmcVar = (zzmc) entry.getKey();
                        throw null;
                    }
                }
                if (entry != null) {
                    ((zzme) obj).zzc.zzg(zzouVar);
                    return;
                } else {
                    zzmc zzmcVar2 = (zzmc) entry.getKey();
                    throw null;
                }
            }
        }
        entry = null;
        iArr = zznoVar.zzc;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02bf, code lost:
        r6 = r11;
        r5 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0338, code lost:
        r2 = r10;
        r10 = r0;
        r0 = r2;
        r8 = r41;
        r4 = r5;
        r2 = r9;
        r6 = r11;
        r5 = r12;
        r3 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0342, code lost:
        r14 = r20;
        r7 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x0ad6, code lost:
        throw new com.google.android.gms.internal.measurement.zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x0dde, code lost:
        if (r14 == 1048575) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x0de0, code lost:
        r0.putInt(r13, r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:583:0x0de4, code lost:
        r0 = r1.zzj;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:585:0x0dea, code lost:
        if (r0 >= r1.zzk) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:586:0x0dec, code lost:
        r3 = r1.zzi;
        r6 = r1.zzl;
        r8 = r1.zzc;
        r3 = r3[r0];
        r8 = r8[r3];
        r10 = com.google.android.gms.internal.measurement.zzoo.zzn(r13, r1.zzx(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:587:0x0e04, code lost:
        if (r10 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:588:0x0e06, code lost:
        r11 = r1.zzr(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:589:0x0e0a, code lost:
        if (r11 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:590:0x0e0c, code lost:
        r3 = ((com.google.android.gms.internal.measurement.zzne) r1.zzq(r3)).zze();
        r10 = ((com.google.android.gms.internal.measurement.zznf) r10).entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:592:0x0e24, code lost:
        if (r10.hasNext() == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:593:0x0e26, code lost:
        r12 = (java.util.Map.Entry) r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:594:0x0e3a, code lost:
        if (r11.zza(((java.lang.Integer) r12.getValue()).intValue()) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x0e3c, code lost:
        if (r2 != 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:596:0x0e3e, code lost:
        r2 = r6.zza(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:597:0x0e42, code lost:
        r14 = com.google.android.gms.internal.measurement.zzne.zzc(r3, r12.getKey(), r12.getValue());
        r15 = com.google.android.gms.internal.measurement.zzlg.zzb;
        r15 = new byte[r14];
        r17 = com.google.android.gms.internal.measurement.zzll.zzb;
        r17 = r0;
        r0 = new com.google.android.gms.internal.measurement.zzlj(r15, 0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:0x0e5c, code lost:
        com.google.android.gms.internal.measurement.zzne.zzb(r0, r3, r12.getKey(), r12.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:599:0x0e67, code lost:
        r2.zzk((r8 << 3) | 2, com.google.android.gms.internal.measurement.zzld.zza(r0, r15));
        r10.remove();
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:600:0x0e80, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x0e86, code lost:
        throw new java.lang.RuntimeException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:604:0x0e8c, code lost:
        r2 = r2;
        r0 = r0 + 1;
        r1 = r37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:605:0x0e9a, code lost:
        if (r2 == null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0e9c, code lost:
        ((com.google.android.gms.internal.measurement.zzme) r13).zzc = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x0ea4, code lost:
        if (r9 != 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:608:0x0ea6, code lost:
        if (r4 != r5) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:611:0x0eb0, code lost:
        throw new com.google.android.gms.internal.measurement.zzmq(r30);
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x0eb1, code lost:
        r12 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:613:0x0eb3, code lost:
        if (r4 > r5) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:614:0x0eb5, code lost:
        if (r7 != r9) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:615:0x0eb7, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:617:0x0ebd, code lost:
        throw new com.google.android.gms.internal.measurement.zzmq(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x018c, code lost:
        r8 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01c5, code lost:
        r3 = r9;
        r6 = r11;
        r5 = r12;
        r7 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0242, code lost:
        r3 = r2;
        r2 = r0;
        r0 = r10;
        r10 = r3;
        r8 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x026d, code lost:
        r3 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:218:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x0d7d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:570:0x0d8b  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:216:0x05b6 -> B:217:0x05b7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:251:0x065d -> B:252:0x065e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:271:0x06b1 -> B:272:0x06b3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzh(Object obj, byte[] bArr, int i, int i2, int i3, zzkv zzkvVar) throws IOException {
        int i4;
        Unsafe unsafe;
        int i5;
        String str;
        Object obj2;
        int zzN;
        byte[] bArr2;
        int i6;
        int i7;
        int i8;
        zzkv zzkvVar2;
        int i9;
        int i10;
        byte[] bArr3;
        zzkv zzkvVar3;
        Unsafe unsafe2;
        int i11;
        int i12;
        Unsafe unsafe3;
        Object obj3;
        byte[] bArr4;
        zzkv zzkvVar4;
        Object obj4;
        int i13;
        byte[] bArr5;
        zzkv zzkvVar5;
        int zzc;
        zzkv zzkvVar6;
        Unsafe unsafe4;
        int i14;
        int i15;
        int i16;
        byte[] bArr6;
        String str2;
        int i17;
        int i18;
        int i19;
        int i20;
        byte[] bArr7;
        zzkv zzkvVar7;
        int zzg;
        int i21;
        int zza2;
        Unsafe unsafe5;
        Object obj5;
        zzkv zzkvVar8;
        long j;
        int i22;
        int i23;
        Unsafe unsafe6;
        byte[] bArr8;
        zzkv zzkvVar9;
        int i24;
        int zzl;
        int i25;
        int i26;
        int zza3;
        int i27;
        Object obj6;
        int i28;
        byte[] bArr9;
        int i29;
        int zzl2;
        zzmn zzmnVar;
        int i30;
        int i31;
        int i32;
        int i33;
        zzno<T> zznoVar = this;
        Object obj7 = obj;
        byte[] bArr10 = bArr;
        int i34 = i2;
        zzkv zzkvVar10 = zzkvVar;
        zzB(obj7);
        Unsafe unsafe7 = zzb;
        int i35 = 0;
        int i36 = i;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = -1;
        int i41 = 1048575;
        while (true) {
            int i42 = 1048575;
            while (true) {
                if (i36 < i34) {
                    int i43 = i36 + 1;
                    int i44 = bArr10[i36];
                    if (i44 < 0) {
                        i43 = zzkw.zzb(i44, bArr10, i43, zzkvVar10);
                        i44 = zzkvVar10.zza;
                    }
                    int i45 = i43;
                    int i46 = i44;
                    i36 = i45;
                    int i47 = i46 >>> 3;
                    if (i47 <= i40) {
                        if (i47 >= zznoVar.zze && i47 <= zznoVar.zzf) {
                            zzN = zznoVar.zzN(i47, i35);
                            if (zzN != -1) {
                            }
                            i9 = i47;
                            if (i6 == i4) {
                            }
                            if (zznoVar.zzh) {
                            }
                            i10 = i2;
                            i36 = zzkw.zzo(i6, bArr, i36, i10, zzg(obj2), zzkvVar);
                            zzkvVar10 = zzkvVar;
                            i38 = i6;
                            i34 = i10;
                            i37 = i35;
                            obj7 = obj2;
                            i40 = i9;
                            i41 = i7;
                            i39 = i8;
                            i35 = 0;
                            i42 = 1048575;
                            unsafe7 = unsafe;
                            bArr10 = bArr;
                        }
                        zzN = -1;
                        if (zzN != -1) {
                        }
                        i9 = i47;
                        if (i6 == i4) {
                        }
                        if (zznoVar.zzh) {
                        }
                        i10 = i2;
                        i36 = zzkw.zzo(i6, bArr, i36, i10, zzg(obj2), zzkvVar);
                        zzkvVar10 = zzkvVar;
                        i38 = i6;
                        i34 = i10;
                        i37 = i35;
                        obj7 = obj2;
                        i40 = i9;
                        i41 = i7;
                        i39 = i8;
                        i35 = 0;
                        i42 = 1048575;
                        unsafe7 = unsafe;
                        bArr10 = bArr;
                    } else {
                        int i48 = i37 / 3;
                        if (i47 >= zznoVar.zze && i47 <= zznoVar.zzf) {
                            zzN = zznoVar.zzN(i47, i48);
                            if (zzN != -1) {
                                bArr2 = bArr10;
                                unsafe = unsafe7;
                                i6 = i46;
                                i4 = i3;
                                str = "Failed to parse the message.";
                                i7 = i41;
                                i8 = i39;
                                obj2 = obj7;
                                zzkvVar2 = zzkvVar10;
                            } else {
                                int i49 = i46 & 7;
                                int[] iArr = zznoVar.zzc;
                                int i50 = zzN;
                                int i51 = iArr[zzN + 1];
                                int zzz = zzz(i51);
                                long j2 = i51 & i42;
                                if (zzz <= 17) {
                                    int i52 = iArr[i50 + 2];
                                    int i53 = 1 << (i52 >>> 20);
                                    int i54 = i52 & i42;
                                    str = "Failed to parse the message.";
                                    if (i54 != i41) {
                                        int i55 = i42;
                                        if (i41 != i55) {
                                            unsafe7.putInt(obj7, i41, i39);
                                            i55 = 1048575;
                                        }
                                        i39 = i54 == i55 ? 0 : unsafe7.getInt(obj7, i54);
                                        i41 = i54;
                                    }
                                    switch (zzz) {
                                        case 0:
                                            zzkv zzkvVar11 = zzkvVar10;
                                            bArr3 = bArr10;
                                            zzkvVar3 = zzkvVar11;
                                            unsafe2 = unsafe7;
                                            obj2 = obj7;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 == 1) {
                                                i12 = i36 + 8;
                                                i39 |= i53;
                                                zzoo.zzm(obj2, j2, Double.longBitsToDouble(zzkw.zze(bArr3, i36)));
                                                break;
                                            }
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 1:
                                            zzkv zzkvVar12 = zzkvVar10;
                                            bArr3 = bArr10;
                                            zzkvVar3 = zzkvVar12;
                                            unsafe2 = unsafe7;
                                            obj2 = obj7;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 == 5) {
                                                i12 = i36 + 4;
                                                i39 |= i53;
                                                zzoo.zzk(obj2, j2, Float.intBitsToFloat(zzkw.zzd(bArr3, i36)));
                                                break;
                                            }
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 2:
                                        case 3:
                                            zzkv zzkvVar13 = zzkvVar10;
                                            bArr5 = bArr10;
                                            zzkvVar5 = zzkvVar13;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 != 0) {
                                                unsafe2 = unsafe7;
                                                obj2 = obj7;
                                                bArr2 = bArr;
                                                zzkvVar2 = zzkvVar;
                                                unsafe = unsafe2;
                                                i6 = i11;
                                                i4 = i3;
                                                i8 = i39;
                                                break;
                                            } else {
                                                i39 |= i53;
                                                zzc = zzkw.zzc(bArr5, i36, zzkvVar5);
                                                unsafe7.putLong(obj7, j2, zzkvVar5.zzb);
                                                byte[] bArr11 = bArr5;
                                                zzkvVar10 = zzkvVar5;
                                                bArr10 = bArr11;
                                                i36 = zzc;
                                                i37 = i35;
                                                i40 = i47;
                                                i41 = i7;
                                                i38 = i11;
                                                i35 = 0;
                                                i42 = 1048575;
                                                i34 = i2;
                                            }
                                        case 4:
                                        case 11:
                                            zzkv zzkvVar14 = zzkvVar10;
                                            byte[] bArr12 = bArr10;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 == 0) {
                                                i39 |= i53;
                                                i36 = zzkw.zza(bArr12, i36, zzkvVar14);
                                                unsafe7.putInt(obj7, j2, zzkvVar14.zza);
                                                zzkvVar10 = zzkvVar14;
                                                bArr10 = bArr12;
                                                i34 = i2;
                                                break;
                                            }
                                            unsafe2 = unsafe7;
                                            obj2 = obj7;
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 5:
                                        case 14:
                                            zzkv zzkvVar15 = zzkvVar10;
                                            bArr5 = bArr10;
                                            Unsafe unsafe8 = unsafe7;
                                            obj3 = obj7;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 != 1) {
                                                unsafe2 = unsafe8;
                                                obj2 = obj3;
                                                bArr2 = bArr;
                                                zzkvVar2 = zzkvVar;
                                                unsafe = unsafe2;
                                                i6 = i11;
                                                i4 = i3;
                                                i8 = i39;
                                                break;
                                            } else {
                                                zzc = i36 + 8;
                                                i39 |= i53;
                                                unsafe7 = unsafe8;
                                                zzkvVar5 = zzkvVar15;
                                                obj7 = obj;
                                                unsafe7.putLong(obj7, j2, zzkw.zze(bArr5, i36));
                                                byte[] bArr112 = bArr5;
                                                zzkvVar10 = zzkvVar5;
                                                bArr10 = bArr112;
                                                i36 = zzc;
                                                i37 = i35;
                                                i40 = i47;
                                                i41 = i7;
                                                i38 = i11;
                                                i35 = 0;
                                                i42 = 1048575;
                                                i34 = i2;
                                            }
                                        case 6:
                                        case 13:
                                            zzkv zzkvVar16 = zzkvVar10;
                                            byte[] bArr13 = bArr10;
                                            unsafe3 = unsafe7;
                                            obj3 = obj7;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 == 5) {
                                                i39 |= i53;
                                                unsafe3.putInt(obj3, j2, zzkw.zzd(bArr13, i36));
                                                unsafe7 = unsafe3;
                                                bArr10 = bArr13;
                                                zzkvVar10 = zzkvVar16;
                                                i34 = i2;
                                                i36 += 4;
                                                break;
                                            }
                                            unsafe2 = unsafe3;
                                            obj2 = obj3;
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 7:
                                            zzkv zzkvVar17 = zzkvVar10;
                                            bArr4 = bArr10;
                                            unsafe3 = unsafe7;
                                            zzkvVar4 = zzkvVar17;
                                            obj3 = obj7;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 == 0) {
                                                i39 |= i53;
                                                i36 = zzkw.zzc(bArr4, i36, zzkvVar4);
                                                zzoo.zzi(obj3, j2, zzkvVar4.zzb != 0);
                                                break;
                                            }
                                            unsafe2 = unsafe3;
                                            obj2 = obj3;
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 8:
                                            zzkv zzkvVar18 = zzkvVar10;
                                            bArr4 = bArr10;
                                            unsafe3 = unsafe7;
                                            zzkvVar4 = zzkvVar18;
                                            obj3 = obj7;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 == 2) {
                                                if ((i51 & C.BUFFER_FLAG_LAST_SAMPLE) == 0) {
                                                    int zza4 = zzkw.zza(bArr4, i36, zzkvVar4);
                                                    int i56 = zzkvVar4.zza;
                                                    if (i56 < 0) {
                                                        throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    int i57 = i39 | i53;
                                                    if (i56 != 0) {
                                                        zzkvVar4.zzc = new String(bArr4, zza4, i56, zzmo.zza);
                                                        zza4 += i56;
                                                    } else {
                                                        zzkvVar4.zzc = "";
                                                    }
                                                    i36 = zza4;
                                                    i39 = i57;
                                                } else {
                                                    i36 = zzkw.zzf(bArr4, i36, zzkvVar4);
                                                    i39 |= i53;
                                                }
                                                unsafe3.putObject(obj3, j2, zzkvVar4.zzc);
                                                break;
                                            }
                                            unsafe2 = unsafe3;
                                            obj2 = obj3;
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 9:
                                            obj4 = obj7;
                                            i13 = i46;
                                            i35 = i50;
                                            if (i49 != 2) {
                                                i11 = i13;
                                                i7 = i41;
                                                obj2 = obj4;
                                                unsafe2 = unsafe7;
                                                bArr2 = bArr;
                                                zzkvVar2 = zzkvVar;
                                                unsafe = unsafe2;
                                                i6 = i11;
                                                i4 = i3;
                                                i8 = i39;
                                                break;
                                            } else {
                                                i39 |= i53;
                                                Unsafe unsafe9 = unsafe7;
                                                Object zzs = zznoVar.zzs(obj4, i35);
                                                byte[] bArr14 = bArr10;
                                                zzkv zzkvVar19 = zzkvVar10;
                                                int zzj = zzkw.zzj(zzs, zznoVar.zzp(i35), bArr14, i36, i2, zzkvVar19);
                                                zznoVar.zzt(obj4, i35, zzs);
                                                unsafe7 = unsafe9;
                                                bArr10 = bArr14;
                                                zzkvVar10 = zzkvVar19;
                                                i34 = i2;
                                                i36 = zzj;
                                                break;
                                            }
                                        case 10:
                                            obj4 = obj7;
                                            i13 = i46;
                                            i35 = i50;
                                            if (i49 == 2) {
                                                i39 |= i53;
                                                i36 = zzkw.zzg(bArr10, i36, zzkvVar10);
                                                unsafe7.putObject(obj4, j2, zzkvVar10.zzc);
                                                break;
                                            }
                                            i11 = i13;
                                            i7 = i41;
                                            obj2 = obj4;
                                            unsafe2 = unsafe7;
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 12:
                                            obj4 = obj7;
                                            i13 = i46;
                                            i35 = i50;
                                            if (i49 == 0) {
                                                i36 = zzkw.zza(bArr10, i36, zzkvVar10);
                                                int i58 = zzkvVar10.zza;
                                                zzmj zzr = zznoVar.zzr(i35);
                                                if ((i51 & Integer.MIN_VALUE) == 0 || zzr == null || zzr.zza(i58)) {
                                                    i39 |= i53;
                                                    unsafe7.putInt(obj4, j2, i58);
                                                    break;
                                                } else {
                                                    zzg(obj4).zzk(i13, Long.valueOf(i58));
                                                    break;
                                                }
                                            }
                                            i11 = i13;
                                            i7 = i41;
                                            obj2 = obj4;
                                            unsafe2 = unsafe7;
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 15:
                                            obj4 = obj7;
                                            i13 = i46;
                                            i35 = i50;
                                            if (i49 == 0) {
                                                i39 |= i53;
                                                i36 = zzkw.zza(bArr10, i36, zzkvVar10);
                                                unsafe7.putInt(obj4, j2, zzli.zzb(zzkvVar10.zza));
                                                break;
                                            }
                                            i11 = i13;
                                            i7 = i41;
                                            obj2 = obj4;
                                            unsafe2 = unsafe7;
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                        case 16:
                                            if (i49 != 0) {
                                                i35 = i50;
                                                unsafe2 = unsafe7;
                                                obj2 = obj7;
                                                i11 = i46;
                                                i7 = i41;
                                                bArr2 = bArr;
                                                zzkvVar2 = zzkvVar;
                                                unsafe = unsafe2;
                                                i6 = i11;
                                                i4 = i3;
                                                i8 = i39;
                                                break;
                                            } else {
                                                i39 |= i53;
                                                int zzc2 = zzkw.zzc(bArr10, i36, zzkvVar10);
                                                unsafe7.putLong(obj7, j2, zzli.zzc(zzkvVar10.zzb));
                                                i36 = zzc2;
                                                i37 = i50;
                                                i40 = i47;
                                                i38 = i46;
                                                i35 = 0;
                                                i42 = 1048575;
                                                i34 = i2;
                                            }
                                        default:
                                            zzkv zzkvVar20 = zzkvVar10;
                                            byte[] bArr15 = bArr10;
                                            unsafe2 = unsafe7;
                                            obj2 = obj7;
                                            i35 = i50;
                                            i11 = i46;
                                            i7 = i41;
                                            if (i49 == 3) {
                                                i39 |= i53;
                                                Object zzs2 = zznoVar.zzs(obj2, i35);
                                                int zzk = zzkw.zzk(zzs2, zznoVar.zzp(i35), bArr15, i36, i2, (i47 << 3) | 4, zzkvVar20);
                                                zznoVar.zzt(obj2, i35, zzs2);
                                                i34 = i2;
                                                zzkvVar10 = zzkvVar;
                                                i36 = zzk;
                                                unsafe7 = unsafe2;
                                                i37 = i35;
                                                i40 = i47;
                                                obj7 = obj2;
                                                i41 = i7;
                                                i38 = i11;
                                                i35 = 0;
                                                i42 = 1048575;
                                                bArr10 = bArr;
                                            }
                                            bArr2 = bArr;
                                            zzkvVar2 = zzkvVar;
                                            unsafe = unsafe2;
                                            i6 = i11;
                                            i4 = i3;
                                            i8 = i39;
                                            break;
                                    }
                                } else {
                                    Unsafe unsafe10 = unsafe7;
                                    str = "Failed to parse the message.";
                                    i35 = i50;
                                    obj2 = obj7;
                                    if (zzz != 27) {
                                        i7 = i41;
                                        int i59 = i36;
                                        int i60 = i46;
                                        i8 = i39;
                                        i14 = i47;
                                        if (zzz <= 49) {
                                            long j3 = i51;
                                            zzmn zzmnVar2 = (zzmn) unsafe10.getObject(obj2, j2);
                                            if (zzmnVar2.zza()) {
                                                j = j3;
                                            } else {
                                                int size = zzmnVar2.size();
                                                j = j3;
                                                zzmnVar2 = zzmnVar2.zzg(size + size);
                                                unsafe10.putObject(obj2, j2, zzmnVar2);
                                            }
                                            zzmn zzmnVar3 = zzmnVar2;
                                            switch (zzz) {
                                                case 18:
                                                case 35:
                                                    i22 = i60;
                                                    i23 = i59;
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 != 2) {
                                                        if (i49 == 1) {
                                                            i24 = i23 + 8;
                                                            int i61 = zzkw.zza;
                                                            zzln zzlnVar = (zzln) zzmnVar3;
                                                            zzlnVar.zzf(Double.longBitsToDouble(zzkw.zze(bArr8, i23)));
                                                            while (i24 < i2) {
                                                                int zza5 = zzkw.zza(bArr8, i24, zzkvVar9);
                                                                if (i22 == zzkvVar9.zza) {
                                                                    zzlnVar.zzf(Double.longBitsToDouble(zzkw.zze(bArr8, zza5)));
                                                                    i24 = zza5 + 8;
                                                                }
                                                            }
                                                        }
                                                        i25 = i23;
                                                        bArr9 = bArr8;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        int i62 = zzkw.zza;
                                                        zzln zzlnVar2 = (zzln) zzmnVar3;
                                                        i24 = zzkw.zza(bArr8, i23, zzkvVar9);
                                                        int i63 = zzkvVar9.zza;
                                                        int i64 = i24 + i63;
                                                        if (i64 <= bArr8.length) {
                                                            zzlnVar2.zzh(zzlnVar2.size() + (i63 / 8));
                                                            while (i24 < i64) {
                                                                zzlnVar2.zzf(Double.longBitsToDouble(zzkw.zze(bArr8, i24)));
                                                                i24 += 8;
                                                            }
                                                            if (i24 != i64) {
                                                                throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                        } else {
                                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    i25 = i23;
                                                    bArr9 = bArr8;
                                                    break;
                                                case 19:
                                                case 36:
                                                    i22 = i60;
                                                    i23 = i59;
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 != 2) {
                                                        if (i49 == 5) {
                                                            i24 = i23 + 4;
                                                            int i65 = zzkw.zza;
                                                            zzlx zzlxVar = (zzlx) zzmnVar3;
                                                            zzlxVar.zzf(Float.intBitsToFloat(zzkw.zzd(bArr8, i23)));
                                                            while (i24 < i2) {
                                                                int zza6 = zzkw.zza(bArr8, i24, zzkvVar9);
                                                                if (i22 == zzkvVar9.zza) {
                                                                    zzlxVar.zzf(Float.intBitsToFloat(zzkw.zzd(bArr8, zza6)));
                                                                    i24 = zza6 + 4;
                                                                }
                                                            }
                                                        }
                                                        i25 = i23;
                                                        bArr9 = bArr8;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        int i66 = zzkw.zza;
                                                        zzlx zzlxVar2 = (zzlx) zzmnVar3;
                                                        i24 = zzkw.zza(bArr8, i23, zzkvVar9);
                                                        int i67 = zzkvVar9.zza;
                                                        int i68 = i24 + i67;
                                                        if (i68 <= bArr8.length) {
                                                            zzlxVar2.zzh(zzlxVar2.size() + (i67 / 4));
                                                            while (i24 < i68) {
                                                                zzlxVar2.zzf(Float.intBitsToFloat(zzkw.zzd(bArr8, i24)));
                                                                i24 += 4;
                                                            }
                                                            if (i24 != i68) {
                                                                throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                        } else {
                                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    i25 = i23;
                                                    bArr9 = bArr8;
                                                    break;
                                                case 20:
                                                case 21:
                                                case 37:
                                                case 38:
                                                    i22 = i60;
                                                    i23 = i59;
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 != 2) {
                                                        if (i49 == 0) {
                                                            int i69 = zzkw.zza;
                                                            zzmz zzmzVar = (zzmz) zzmnVar3;
                                                            i24 = zzkw.zzc(bArr8, i23, zzkvVar9);
                                                            zzmzVar.zzf(zzkvVar9.zzb);
                                                            while (i24 < i2) {
                                                                int zza7 = zzkw.zza(bArr8, i24, zzkvVar9);
                                                                if (i22 == zzkvVar9.zza) {
                                                                    i24 = zzkw.zzc(bArr8, zza7, zzkvVar9);
                                                                    zzmzVar.zzf(zzkvVar9.zzb);
                                                                }
                                                            }
                                                        }
                                                        i25 = i23;
                                                        bArr9 = bArr8;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        int i70 = zzkw.zza;
                                                        zzmz zzmzVar2 = (zzmz) zzmnVar3;
                                                        i24 = zzkw.zza(bArr8, i23, zzkvVar9);
                                                        int i71 = zzkvVar9.zza + i24;
                                                        while (i24 < i71) {
                                                            i24 = zzkw.zzc(bArr8, i24, zzkvVar9);
                                                            zzmzVar2.zzf(zzkvVar9.zzb);
                                                        }
                                                        if (i24 != i71) {
                                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    i25 = i23;
                                                    bArr9 = bArr8;
                                                    break;
                                                case 22:
                                                case 29:
                                                case 39:
                                                case 43:
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 != 2) {
                                                        if (i49 != 0) {
                                                            i22 = i60;
                                                            i23 = i59;
                                                            i25 = i23;
                                                            bArr9 = bArr8;
                                                            i24 = i25;
                                                            break;
                                                        } else {
                                                            i23 = i59;
                                                            zzl = zzkw.zzl(i60, bArr8, i23, i2, zzmnVar3, zzkvVar9);
                                                            i22 = i60;
                                                            i24 = zzl;
                                                            i25 = i23;
                                                            bArr9 = bArr8;
                                                        }
                                                    } else {
                                                        i24 = zzkw.zzm(bArr8, i59, zzmnVar3, zzkvVar9);
                                                        i25 = i59;
                                                        i22 = i60;
                                                        bArr9 = bArr8;
                                                        break;
                                                    }
                                                case 23:
                                                case 32:
                                                case 40:
                                                case 46:
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 != 2) {
                                                        if (i49 == 1) {
                                                            i24 = i59 + 8;
                                                            int i72 = zzkw.zza;
                                                            zzmz zzmzVar3 = (zzmz) zzmnVar3;
                                                            zzmzVar3.zzf(zzkw.zze(bArr8, i59));
                                                            while (i24 < i2) {
                                                                int zza8 = zzkw.zza(bArr8, i24, zzkvVar9);
                                                                if (i60 == zzkvVar9.zza) {
                                                                    zzmzVar3.zzf(zzkw.zze(bArr8, zza8));
                                                                    i24 = zza8 + 8;
                                                                }
                                                            }
                                                        }
                                                        i25 = i59;
                                                        i22 = i60;
                                                        bArr9 = bArr8;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        int i73 = zzkw.zza;
                                                        zzmz zzmzVar4 = (zzmz) zzmnVar3;
                                                        i24 = zzkw.zza(bArr8, i59, zzkvVar9);
                                                        int i74 = zzkvVar9.zza;
                                                        int i75 = i24 + i74;
                                                        if (i75 <= bArr8.length) {
                                                            zzmzVar4.zzh(zzmzVar4.size() + (i74 / 8));
                                                            while (i24 < i75) {
                                                                zzmzVar4.zzf(zzkw.zze(bArr8, i24));
                                                                i24 += 8;
                                                            }
                                                            if (i24 != i75) {
                                                                throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                        } else {
                                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    i25 = i59;
                                                    i22 = i60;
                                                    bArr9 = bArr8;
                                                    break;
                                                case 24:
                                                case 31:
                                                case 41:
                                                case 45:
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 != 2) {
                                                        if (i49 == 5) {
                                                            i24 = i59 + 4;
                                                            int i76 = zzkw.zza;
                                                            zzmf zzmfVar = (zzmf) zzmnVar3;
                                                            zzmfVar.zzh(zzkw.zzd(bArr8, i59));
                                                            while (i24 < i2) {
                                                                int zza9 = zzkw.zza(bArr8, i24, zzkvVar9);
                                                                if (i60 == zzkvVar9.zza) {
                                                                    zzmfVar.zzh(zzkw.zzd(bArr8, zza9));
                                                                    i24 = zza9 + 4;
                                                                }
                                                            }
                                                        }
                                                        i25 = i59;
                                                        i22 = i60;
                                                        bArr9 = bArr8;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        int i77 = zzkw.zza;
                                                        zzmf zzmfVar2 = (zzmf) zzmnVar3;
                                                        i24 = zzkw.zza(bArr8, i59, zzkvVar9);
                                                        int i78 = zzkvVar9.zza;
                                                        int i79 = i24 + i78;
                                                        if (i79 <= bArr8.length) {
                                                            zzmfVar2.zzi(zzmfVar2.size() + (i78 / 4));
                                                            while (i24 < i79) {
                                                                zzmfVar2.zzh(zzkw.zzd(bArr8, i24));
                                                                i24 += 4;
                                                            }
                                                            if (i24 != i79) {
                                                                throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                        } else {
                                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    i25 = i59;
                                                    i22 = i60;
                                                    bArr9 = bArr8;
                                                    break;
                                                case 25:
                                                case 42:
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    zzkvVar9 = zzkvVar;
                                                    int i80 = i14;
                                                    if (i49 != 2) {
                                                        i14 = i80;
                                                        if (i49 == 0) {
                                                            int i81 = zzkw.zza;
                                                            zzkx zzkxVar = (zzkx) zzmnVar3;
                                                            i24 = zzkw.zzc(bArr8, i59, zzkvVar9);
                                                            zzkxVar.zzf(zzkvVar9.zzb != 0);
                                                            while (i24 < i2) {
                                                                int zza10 = zzkw.zza(bArr8, i24, zzkvVar9);
                                                                if (i60 == zzkvVar9.zza) {
                                                                    i24 = zzkw.zzc(bArr8, zza10, zzkvVar9);
                                                                    zzkxVar.zzf(zzkvVar9.zzb != 0);
                                                                }
                                                            }
                                                        }
                                                        i25 = i59;
                                                        i22 = i60;
                                                        bArr9 = bArr8;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        int i82 = zzkw.zza;
                                                        zzkx zzkxVar2 = (zzkx) zzmnVar3;
                                                        i24 = zzkw.zza(bArr8, i59, zzkvVar9);
                                                        int i83 = zzkvVar9.zza + i24;
                                                        while (i24 < i83) {
                                                            i24 = zzkw.zzc(bArr8, i24, zzkvVar9);
                                                            int i84 = i80;
                                                            zzkxVar2.zzf(zzkvVar9.zzb != 0);
                                                            i80 = i84;
                                                        }
                                                        i14 = i80;
                                                        if (i24 != i83) {
                                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    i25 = i59;
                                                    i22 = i60;
                                                    bArr9 = bArr8;
                                                    break;
                                                case 26:
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    zzkvVar9 = zzkvVar;
                                                    i26 = i14;
                                                    if (i49 != 2) {
                                                        i14 = i26;
                                                        i25 = i59;
                                                        i22 = i60;
                                                        bArr9 = bArr8;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        if ((j & 536870912) == 0) {
                                                            zza3 = zzkw.zza(bArr8, i59, zzkvVar9);
                                                            int i85 = zzkvVar9.zza;
                                                            if (i85 < 0) {
                                                                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i85 == 0) {
                                                                obj6 = "";
                                                                zzmnVar3.add(obj6);
                                                                while (zza3 < i2) {
                                                                    int zza11 = zzkw.zza(bArr8, zza3, zzkvVar9);
                                                                    if (i60 == zzkvVar9.zza) {
                                                                        zza3 = zzkw.zza(bArr8, zza11, zzkvVar9);
                                                                        i85 = zzkvVar9.zza;
                                                                        if (i85 < 0) {
                                                                            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                        if (i85 == 0) {
                                                                            zzmnVar3.add(obj6);
                                                                        } else {
                                                                            zzmnVar3.add(new String(bArr8, zza3, i85, zzmo.zza));
                                                                            zza3 += i85;
                                                                            while (zza3 < i2) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                obj6 = "";
                                                                zzmnVar3.add(new String(bArr8, zza3, i85, zzmo.zza));
                                                                zza3 += i85;
                                                                while (zza3 < i2) {
                                                                }
                                                            }
                                                        } else {
                                                            zza3 = zzkw.zza(bArr8, i59, zzkvVar9);
                                                            int i86 = zzkvVar9.zza;
                                                            if (i86 < 0) {
                                                                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i86 == 0) {
                                                                zzmnVar3.add("");
                                                                while (zza3 < i2) {
                                                                    int zza12 = zzkw.zza(bArr8, zza3, zzkvVar9);
                                                                    if (i60 == zzkvVar9.zza) {
                                                                        zza3 = zzkw.zza(bArr8, zza12, zzkvVar9);
                                                                        int i87 = zzkvVar9.zza;
                                                                        if (i87 < 0) {
                                                                            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                        if (i87 == 0) {
                                                                            zzmnVar3.add("");
                                                                        } else {
                                                                            int i88 = zza3 + i87;
                                                                            if (zzor.zza(bArr8, zza3, i88)) {
                                                                                i27 = i88;
                                                                                zzmnVar3.add(new String(bArr8, zza3, i87, zzmo.zza));
                                                                                zza3 = i27;
                                                                                while (zza3 < i2) {
                                                                                }
                                                                            } else {
                                                                                throw new zzmq("Protocol message had invalid UTF-8.");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                int i89 = zza3 + i86;
                                                                if (zzor.zza(bArr8, zza3, i89)) {
                                                                    i27 = i89;
                                                                    zzmnVar3.add(new String(bArr8, zza3, i86, zzmo.zza));
                                                                    zza3 = i27;
                                                                    while (zza3 < i2) {
                                                                    }
                                                                } else {
                                                                    throw new zzmq("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                        }
                                                        i24 = zza3;
                                                        i14 = i26;
                                                        i25 = i59;
                                                        i22 = i60;
                                                        bArr9 = bArr8;
                                                        break;
                                                    }
                                                case 27:
                                                    unsafe6 = unsafe10;
                                                    i28 = i60;
                                                    i23 = i59;
                                                    bArr8 = bArr;
                                                    i26 = i14;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 == 2) {
                                                        int zzn = zzkw.zzn(zznoVar.zzp(i35), i28, bArr, i23, i2, zzmnVar3, zzkvVar9);
                                                        i60 = i28;
                                                        bArr8 = bArr;
                                                        i59 = i23;
                                                        i24 = zzn;
                                                        zzkvVar9 = zzkvVar9;
                                                        i14 = i26;
                                                        i25 = i59;
                                                        i22 = i60;
                                                        bArr9 = bArr8;
                                                        break;
                                                    }
                                                    i22 = i28;
                                                    i14 = i26;
                                                    i25 = i23;
                                                    bArr9 = bArr8;
                                                    i24 = i25;
                                                    break;
                                                case 28:
                                                    unsafe6 = unsafe10;
                                                    i28 = i60;
                                                    i23 = i59;
                                                    bArr8 = bArr;
                                                    i26 = i14;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 == 2) {
                                                        zzl = zzkw.zza(bArr8, i23, zzkvVar9);
                                                        int i90 = zzkvVar9.zza;
                                                        if (i90 >= 0) {
                                                            if (i90 > bArr8.length - zzl) {
                                                                throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            if (i90 == 0) {
                                                                zzmnVar3.add(zzlg.zzb);
                                                                while (zzl < i2) {
                                                                    int zza13 = zzkw.zza(bArr8, zzl, zzkvVar9);
                                                                    if (i28 != zzkvVar9.zza) {
                                                                        i22 = i28;
                                                                        i14 = i26;
                                                                        i24 = zzl;
                                                                        i25 = i23;
                                                                        bArr9 = bArr8;
                                                                        break;
                                                                    } else {
                                                                        zzl = zzkw.zza(bArr8, zza13, zzkvVar9);
                                                                        i90 = zzkvVar9.zza;
                                                                        if (i90 >= 0) {
                                                                            if (i90 > bArr8.length - zzl) {
                                                                                throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                            }
                                                                            if (i90 == 0) {
                                                                                zzmnVar3.add(zzlg.zzb);
                                                                            } else {
                                                                                zzmnVar3.add(zzlg.zzh(bArr8, zzl, i90));
                                                                                zzl += i90;
                                                                                while (zzl < i2) {
                                                                                }
                                                                            }
                                                                        } else {
                                                                            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                    }
                                                                }
                                                                i22 = i28;
                                                                i14 = i26;
                                                                i24 = zzl;
                                                                i25 = i23;
                                                                bArr9 = bArr8;
                                                            } else {
                                                                zzmnVar3.add(zzlg.zzh(bArr8, zzl, i90));
                                                                zzl += i90;
                                                                while (zzl < i2) {
                                                                }
                                                                i22 = i28;
                                                                i14 = i26;
                                                                i24 = zzl;
                                                                i25 = i23;
                                                                bArr9 = bArr8;
                                                            }
                                                        } else {
                                                            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                    }
                                                    i22 = i28;
                                                    i14 = i26;
                                                    i25 = i23;
                                                    bArr9 = bArr8;
                                                    i24 = i25;
                                                    break;
                                                case 30:
                                                case 44:
                                                    if (i49 != 2) {
                                                        if (i49 != 0) {
                                                            unsafe6 = unsafe10;
                                                            i25 = i59;
                                                            bArr9 = bArr;
                                                            zzkvVar9 = zzkvVar;
                                                            i22 = i60;
                                                            i24 = i25;
                                                            break;
                                                        } else {
                                                            i29 = i60;
                                                            i23 = i59;
                                                            bArr8 = bArr;
                                                            zzkvVar9 = zzkvVar;
                                                            zzl2 = zzkw.zzl(i29, bArr8, i23, i2, zzmnVar3, zzkvVar9);
                                                            zzmnVar = zzmnVar3;
                                                        }
                                                    } else {
                                                        zzl2 = zzkw.zzm(bArr, i59, zzmnVar3, zzkvVar);
                                                        i29 = i60;
                                                        i23 = i59;
                                                        bArr8 = bArr;
                                                        zzmnVar = zzmnVar3;
                                                        zzkvVar9 = zzkvVar;
                                                    }
                                                    zzmj zzr2 = zznoVar.zzr(i35);
                                                    zzoh zzohVar = zznoVar.zzl;
                                                    int i91 = zzny.zza;
                                                    if (zzr2 == null) {
                                                        unsafe6 = unsafe10;
                                                        i30 = zzl2;
                                                        i31 = i14;
                                                    } else if (zzmnVar instanceof RandomAccess) {
                                                        int size2 = zzmnVar.size();
                                                        i30 = zzl2;
                                                        Object obj8 = null;
                                                        int i92 = 0;
                                                        int i93 = 0;
                                                        while (i92 < size2) {
                                                            Unsafe unsafe11 = unsafe10;
                                                            int intValue = ((Integer) zzmnVar.get(i92)).intValue();
                                                            if (zzr2.zza(intValue)) {
                                                                if (i92 != i93) {
                                                                    zzmnVar.set(i93, Integer.valueOf(intValue));
                                                                }
                                                                i93++;
                                                                i32 = i92;
                                                                i33 = i14;
                                                            } else {
                                                                i32 = i92;
                                                                i33 = i14;
                                                                obj8 = zzny.zzE(obj2, i33, intValue, obj8, zzohVar);
                                                            }
                                                            i14 = i33;
                                                            i92 = i32 + 1;
                                                            unsafe10 = unsafe11;
                                                        }
                                                        unsafe6 = unsafe10;
                                                        i31 = i14;
                                                        if (i93 != size2) {
                                                            zzmnVar.subList(i93, size2).clear();
                                                        }
                                                    } else {
                                                        unsafe6 = unsafe10;
                                                        i30 = zzl2;
                                                        i31 = i14;
                                                        Iterator it = zzmnVar.iterator();
                                                        Object obj9 = null;
                                                        while (it.hasNext()) {
                                                            int intValue2 = ((Integer) it.next()).intValue();
                                                            if (!zzr2.zza(intValue2)) {
                                                                obj9 = zzny.zzE(obj2, i31, intValue2, obj9, zzohVar);
                                                                it.remove();
                                                            }
                                                        }
                                                    }
                                                    i22 = i29;
                                                    i14 = i31;
                                                    i24 = i30;
                                                    i25 = i23;
                                                    bArr9 = bArr8;
                                                    break;
                                                case 33:
                                                case 47:
                                                    if (i49 != 2) {
                                                        if (i49 == 0) {
                                                            int i94 = zzkw.zza;
                                                            zzmf zzmfVar3 = (zzmf) zzmnVar3;
                                                            i24 = zzkw.zza(bArr, i59, zzkvVar);
                                                            zzmfVar3.zzh(zzli.zzb(zzkvVar.zza));
                                                            while (i24 < i2) {
                                                                int zza14 = zzkw.zza(bArr, i24, zzkvVar);
                                                                if (i60 == zzkvVar.zza) {
                                                                    i24 = zzkw.zza(bArr, zza14, zzkvVar);
                                                                    zzmfVar3.zzh(zzli.zzb(zzkvVar.zza));
                                                                }
                                                            }
                                                        }
                                                        unsafe6 = unsafe10;
                                                        i25 = i59;
                                                        zzkvVar9 = zzkvVar;
                                                        i22 = i60;
                                                        bArr9 = bArr;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        int i95 = zzkw.zza;
                                                        zzmf zzmfVar4 = (zzmf) zzmnVar3;
                                                        i24 = zzkw.zza(bArr, i59, zzkvVar);
                                                        int i96 = zzkvVar.zza + i24;
                                                        while (i24 < i96) {
                                                            i24 = zzkw.zza(bArr, i24, zzkvVar);
                                                            zzmfVar4.zzh(zzli.zzb(zzkvVar.zza));
                                                        }
                                                        if (i24 != i96) {
                                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    unsafe6 = unsafe10;
                                                    i25 = i59;
                                                    zzkvVar9 = zzkvVar;
                                                    i22 = i60;
                                                    bArr9 = bArr;
                                                    break;
                                                case 34:
                                                case 48:
                                                    if (i49 != 2) {
                                                        if (i49 == 0) {
                                                            int i97 = zzkw.zza;
                                                            zzmz zzmzVar5 = (zzmz) zzmnVar3;
                                                            i24 = zzkw.zzc(bArr, i59, zzkvVar);
                                                            zzmzVar5.zzf(zzli.zzc(zzkvVar.zzb));
                                                            while (i24 < i2) {
                                                                int zza15 = zzkw.zza(bArr, i24, zzkvVar);
                                                                if (i60 == zzkvVar.zza) {
                                                                    i24 = zzkw.zzc(bArr, zza15, zzkvVar);
                                                                    zzmzVar5.zzf(zzli.zzc(zzkvVar.zzb));
                                                                }
                                                            }
                                                        }
                                                        unsafe6 = unsafe10;
                                                        i25 = i59;
                                                        zzkvVar9 = zzkvVar;
                                                        i22 = i60;
                                                        bArr9 = bArr;
                                                        i24 = i25;
                                                        break;
                                                    } else {
                                                        int i98 = zzkw.zza;
                                                        zzmz zzmzVar6 = (zzmz) zzmnVar3;
                                                        i24 = zzkw.zza(bArr, i59, zzkvVar);
                                                        int i99 = zzkvVar.zza + i24;
                                                        while (i24 < i99) {
                                                            i24 = zzkw.zzc(bArr, i24, zzkvVar);
                                                            zzmzVar6.zzf(zzli.zzc(zzkvVar.zzb));
                                                        }
                                                        if (i24 != i99) {
                                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    unsafe6 = unsafe10;
                                                    i25 = i59;
                                                    zzkvVar9 = zzkvVar;
                                                    i22 = i60;
                                                    bArr9 = bArr;
                                                    break;
                                                default:
                                                    i22 = i60;
                                                    i23 = i59;
                                                    unsafe6 = unsafe10;
                                                    bArr8 = bArr;
                                                    int i100 = i2;
                                                    zzkvVar9 = zzkvVar;
                                                    if (i49 == 3) {
                                                        int i101 = (i22 & (-8)) | 4;
                                                        zznw zzp = zznoVar.zzp(i35);
                                                        int zzi = zzkw.zzi(zzp, bArr8, i23, i100, i101, zzkvVar9);
                                                        i25 = i23;
                                                        zzmnVar3.add(zzkvVar9.zzc);
                                                        while (zzi < i100) {
                                                            int zza16 = zzkw.zza(bArr8, zzi, zzkvVar9);
                                                            if (i22 != zzkvVar9.zza) {
                                                                bArr9 = bArr8;
                                                                i24 = zzi;
                                                                break;
                                                            } else {
                                                                zzi = zzkw.zzi(zzp, bArr8, zza16, i100, i101, zzkvVar9);
                                                                zzmnVar3.add(zzkvVar9.zzc);
                                                                i100 = i2;
                                                                bArr8 = bArr8;
                                                            }
                                                        }
                                                        bArr9 = bArr8;
                                                        i24 = zzi;
                                                    }
                                                    i25 = i23;
                                                    bArr9 = bArr8;
                                                    i24 = i25;
                                                    break;
                                            }
                                            if (i24 != i25) {
                                                i34 = i2;
                                                bArr10 = bArr9;
                                                zzkvVar10 = zzkvVar9;
                                                i38 = i22;
                                                i37 = i35;
                                                obj7 = obj2;
                                                i41 = i7;
                                                i39 = i8;
                                                i40 = i14;
                                                i35 = 0;
                                                i42 = 1048575;
                                                i36 = i24;
                                                unsafe7 = unsafe6;
                                            } else {
                                                zzkvVar2 = zzkvVar9;
                                                i9 = i14;
                                                unsafe = unsafe6;
                                                bArr2 = bArr9;
                                                i36 = i24;
                                                i6 = i22;
                                            }
                                        } else {
                                            unsafe4 = unsafe10;
                                            i16 = i59;
                                            zzkv zzkvVar21 = zzkvVar;
                                            i15 = i60;
                                            bArr6 = bArr;
                                            if (zzz != 50) {
                                                unsafe = unsafe4;
                                                long j4 = iArr[i35 + 2] & 1048575;
                                                switch (zzz) {
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                        bArr2 = bArr;
                                                        i17 = i15;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        if (i49 == 1) {
                                                            i20 = i19 + 8;
                                                            unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzkw.zze(bArr2, i19))));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = i20;
                                                            break;
                                                        }
                                                        i36 = i19;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                                        bArr2 = bArr;
                                                        i17 = i15;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        if (i49 == 5) {
                                                            i20 = i19 + 4;
                                                            unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzkw.zzd(bArr2, i19))));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = i20;
                                                            break;
                                                        }
                                                        i36 = i19;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                                        bArr2 = bArr;
                                                        i17 = i15;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        if (i49 == 0) {
                                                            i20 = zzkw.zzc(bArr2, i19, zzkvVar2);
                                                            unsafe.putObject(obj2, j2, Long.valueOf(zzkvVar2.zzb));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = i20;
                                                            break;
                                                        }
                                                        i36 = i19;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                                    case 62:
                                                        bArr2 = bArr;
                                                        i17 = i15;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        if (i49 == 0) {
                                                            i20 = zzkw.zza(bArr2, i19, zzkvVar2);
                                                            unsafe.putObject(obj2, j2, Integer.valueOf(zzkvVar2.zza));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = i20;
                                                            break;
                                                        }
                                                        i36 = i19;
                                                        break;
                                                    case 56:
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                                        bArr2 = bArr;
                                                        i17 = i15;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        if (i49 == 1) {
                                                            i20 = i19 + 8;
                                                            unsafe.putObject(obj2, j2, Long.valueOf(zzkw.zze(bArr2, i19)));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = i20;
                                                            break;
                                                        }
                                                        i36 = i19;
                                                        break;
                                                    case 57:
                                                    case 64:
                                                        bArr2 = bArr;
                                                        i17 = i15;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        if (i49 == 5) {
                                                            i20 = i19 + 4;
                                                            unsafe.putObject(obj2, j2, Integer.valueOf(zzkw.zzd(bArr2, i19)));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = i20;
                                                            break;
                                                        }
                                                        i36 = i19;
                                                        break;
                                                    case 58:
                                                        bArr2 = bArr;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        if (i49 == 0) {
                                                            i20 = zzkw.zzc(bArr2, i19, zzkvVar2);
                                                            i17 = i15;
                                                            unsafe.putObject(obj2, j2, Boolean.valueOf(zzkvVar2.zzb != 0));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = i20;
                                                            break;
                                                        }
                                                        i17 = i15;
                                                        i36 = i19;
                                                        break;
                                                    case 59:
                                                        bArr2 = bArr;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        if (i49 == 2) {
                                                            int zza17 = zzkw.zza(bArr2, i19, zzkvVar2);
                                                            int i102 = zzkvVar2.zza;
                                                            if (i102 == 0) {
                                                                unsafe.putObject(obj2, j2, "");
                                                            } else {
                                                                int i103 = zza17 + i102;
                                                                if ((i51 & C.BUFFER_FLAG_LAST_SAMPLE) == 0 || zzor.zza(bArr2, zza17, i103)) {
                                                                    unsafe.putObject(obj2, j2, new String(bArr2, zza17, i102, zzmo.zza));
                                                                    zza17 = i103;
                                                                } else {
                                                                    throw new zzmq("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = zza17;
                                                            i17 = i15;
                                                            break;
                                                        }
                                                        i17 = i15;
                                                        i36 = i19;
                                                        break;
                                                    case 60:
                                                        i9 = i14;
                                                        if (i49 != 2) {
                                                            zzkvVar2 = zzkvVar;
                                                            bArr2 = bArr;
                                                            i17 = i15;
                                                            i18 = i35;
                                                            str = str;
                                                            i19 = i16;
                                                            i36 = i19;
                                                            break;
                                                        } else {
                                                            Object zzu = zznoVar.zzu(obj2, i9, i35);
                                                            int zzj2 = zzkw.zzj(zzu, zznoVar.zzp(i35), bArr, i16, i2, zzkvVar);
                                                            zzkvVar2 = zzkvVar;
                                                            bArr2 = bArr;
                                                            zznoVar.zzv(obj2, i9, i35, zzu);
                                                            i17 = i15;
                                                            i18 = i35;
                                                            str = str;
                                                            i19 = i16;
                                                            i36 = zzj2;
                                                            break;
                                                        }
                                                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                        bArr7 = bArr;
                                                        zzkvVar7 = zzkvVar;
                                                        i9 = i14;
                                                        if (i49 == 2) {
                                                            zzg = zzkw.zzg(bArr7, i16, zzkvVar7);
                                                            unsafe.putObject(obj2, j2, zzkvVar7.zzc);
                                                            unsafe.putInt(obj2, j4, i9);
                                                            i36 = zzg;
                                                            i18 = i35;
                                                            str = str;
                                                            i19 = i16;
                                                            zzkvVar2 = zzkvVar7;
                                                            bArr2 = bArr7;
                                                            i17 = i15;
                                                            break;
                                                        }
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        zzkvVar2 = zzkvVar7;
                                                        bArr2 = bArr7;
                                                        i17 = i15;
                                                        i36 = i19;
                                                        break;
                                                    case 63:
                                                        bArr7 = bArr;
                                                        zzkvVar7 = zzkvVar;
                                                        i21 = i15;
                                                        i9 = i14;
                                                        if (i49 == 0) {
                                                            zzg = zzkw.zza(bArr7, i16, zzkvVar7);
                                                            int i104 = zzkvVar7.zza;
                                                            zzmj zzr3 = zznoVar.zzr(i35);
                                                            if (zzr3 == null || zzr3.zza(i104)) {
                                                                i15 = i21;
                                                                unsafe.putObject(obj2, j2, Integer.valueOf(i104));
                                                                unsafe.putInt(obj2, j4, i9);
                                                            } else {
                                                                i15 = i21;
                                                                zzg(obj2).zzk(i15, Long.valueOf(i104));
                                                            }
                                                            i36 = zzg;
                                                            i18 = i35;
                                                            str = str;
                                                            i19 = i16;
                                                            zzkvVar2 = zzkvVar7;
                                                            bArr2 = bArr7;
                                                            i17 = i15;
                                                            break;
                                                        }
                                                        zzkvVar2 = zzkvVar7;
                                                        bArr2 = bArr7;
                                                        i17 = i21;
                                                        i18 = i35;
                                                        i19 = i16;
                                                        str = str;
                                                        i36 = i19;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                        bArr7 = bArr;
                                                        zzkvVar7 = zzkvVar;
                                                        i21 = i15;
                                                        i9 = i14;
                                                        if (i49 == 0) {
                                                            zza2 = zzkw.zza(bArr7, i16, zzkvVar7);
                                                            unsafe.putObject(obj2, j2, Integer.valueOf(zzli.zzb(zzkvVar7.zza)));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            zzkvVar2 = zzkvVar7;
                                                            bArr2 = bArr7;
                                                            i17 = i21;
                                                            i18 = i35;
                                                            i19 = i16;
                                                            i36 = zza2;
                                                            str = str;
                                                            break;
                                                        }
                                                        zzkvVar2 = zzkvVar7;
                                                        bArr2 = bArr7;
                                                        i17 = i21;
                                                        i18 = i35;
                                                        i19 = i16;
                                                        str = str;
                                                        i36 = i19;
                                                        break;
                                                    case 67:
                                                        bArr7 = bArr;
                                                        zzkvVar7 = zzkvVar;
                                                        i9 = i14;
                                                        if (i49 == 0) {
                                                            zza2 = zzkw.zzc(bArr7, i16, zzkvVar7);
                                                            i21 = i15;
                                                            unsafe.putObject(obj2, j2, Long.valueOf(zzli.zzc(zzkvVar7.zzb)));
                                                            unsafe.putInt(obj2, j4, i9);
                                                            zzkvVar2 = zzkvVar7;
                                                            bArr2 = bArr7;
                                                            i17 = i21;
                                                            i18 = i35;
                                                            i19 = i16;
                                                            i36 = zza2;
                                                            str = str;
                                                            break;
                                                        }
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        zzkvVar2 = zzkvVar7;
                                                        bArr2 = bArr7;
                                                        i17 = i15;
                                                        i36 = i19;
                                                        break;
                                                    case 68:
                                                        if (i49 != 3) {
                                                            i9 = i14;
                                                            bArr2 = bArr;
                                                            i17 = i15;
                                                            i18 = i35;
                                                            str = str;
                                                            i19 = i16;
                                                            zzkvVar2 = zzkvVar;
                                                            i36 = i19;
                                                            break;
                                                        } else {
                                                            i9 = i14;
                                                            Object zzu2 = zznoVar.zzu(obj2, i9, i35);
                                                            int zzk2 = zzkw.zzk(zzu2, zznoVar.zzp(i35), bArr, i16, i2, (i15 & (-8)) | 4, zzkvVar);
                                                            bArr7 = bArr;
                                                            zzkvVar7 = zzkvVar;
                                                            zznoVar.zzv(obj2, i9, i35, zzu2);
                                                            i36 = zzk2;
                                                            i18 = i35;
                                                            str = str;
                                                            i19 = i16;
                                                            zzkvVar2 = zzkvVar7;
                                                            bArr2 = bArr7;
                                                            i17 = i15;
                                                            break;
                                                        }
                                                    default:
                                                        bArr2 = bArr;
                                                        i17 = i15;
                                                        i18 = i35;
                                                        str = str;
                                                        i19 = i16;
                                                        i9 = i14;
                                                        zzkvVar2 = zzkvVar;
                                                        i36 = i19;
                                                        break;
                                                }
                                                if (i36 != i19) {
                                                    i34 = i2;
                                                    unsafe7 = unsafe;
                                                    bArr10 = bArr2;
                                                    i38 = i17;
                                                    obj7 = obj2;
                                                    zzkvVar10 = zzkvVar2;
                                                    i40 = i9;
                                                    i41 = i7;
                                                    i39 = i8;
                                                    i37 = i18;
                                                } else {
                                                    i4 = i3;
                                                    i6 = i17;
                                                    i35 = i18;
                                                }
                                            } else if (i49 == 2) {
                                                Object zzq = zznoVar.zzq(i35);
                                                Unsafe unsafe12 = unsafe4;
                                                Object object = unsafe12.getObject(obj2, j2);
                                                if (!((zznf) object).zze()) {
                                                    zznf zzc3 = zznf.zza().zzc();
                                                    zzng.zza(zzc3, object);
                                                    unsafe12.putObject(obj2, j2, zzc3);
                                                    object = zzc3;
                                                }
                                                zznd zze = ((zzne) zzq).zze();
                                                zznf zznfVar = (zznf) object;
                                                int zza18 = zzkw.zza(bArr6, i16, zzkvVar21);
                                                int i105 = zzkvVar21.zza;
                                                if (i105 >= 0 && i105 <= i2 - zza18) {
                                                    int i106 = zza18 + i105;
                                                    Object obj10 = zze.zzb;
                                                    Object obj11 = zze.zzd;
                                                    Object obj12 = obj11;
                                                    while (zza18 < i106) {
                                                        int i107 = zza18 + 1;
                                                        int i108 = bArr6[zza18];
                                                        if (i108 < 0) {
                                                            i107 = zzkw.zzb(i108, bArr6, i107, zzkvVar21);
                                                            i108 = zzkvVar21.zza;
                                                        }
                                                        Object obj13 = obj10;
                                                        int i109 = i108 >>> 3;
                                                        int i110 = i108 & 7;
                                                        Object obj14 = obj12;
                                                        if (i109 == 1) {
                                                            int i111 = i107;
                                                            unsafe5 = unsafe12;
                                                            obj5 = obj13;
                                                            zzos zzosVar = zze.zza;
                                                            if (i110 == zzosVar.zzb()) {
                                                                int zzO = zzO(bArr, i111, i2, zzosVar, null, zzkvVar21);
                                                                zzkv zzkvVar22 = zzkvVar21;
                                                                bArr6 = bArr;
                                                                obj10 = zzkvVar22.zzc;
                                                                zza18 = zzO;
                                                                zzkvVar21 = zzkvVar22;
                                                                obj12 = obj14;
                                                                unsafe12 = unsafe5;
                                                            } else {
                                                                bArr6 = bArr;
                                                                i107 = i111;
                                                            }
                                                        } else if (i109 != 2) {
                                                            bArr6 = bArr;
                                                            zzkvVar8 = zzkvVar21;
                                                            unsafe5 = unsafe12;
                                                            obj5 = obj13;
                                                            zza18 = zzkw.zzp(i108, bArr6, i107, i2, zzkvVar8);
                                                            zzkvVar21 = zzkvVar8;
                                                            obj12 = obj14;
                                                            obj10 = obj5;
                                                            unsafe12 = unsafe5;
                                                        } else {
                                                            zzos zzosVar2 = zze.zzc;
                                                            if (i110 == zzosVar2.zzb()) {
                                                                unsafe5 = unsafe12;
                                                                obj5 = obj13;
                                                                int zzO2 = zzO(bArr, i107, i2, zzosVar2, obj11.getClass(), zzkvVar21);
                                                                obj12 = zzkvVar21.zzc;
                                                                bArr6 = bArr;
                                                                zza18 = zzO2;
                                                                obj10 = obj5;
                                                                unsafe12 = unsafe5;
                                                            } else {
                                                                unsafe5 = unsafe12;
                                                                obj5 = obj13;
                                                                bArr6 = bArr;
                                                            }
                                                        }
                                                        zzkvVar8 = zzkvVar21;
                                                        zza18 = zzkw.zzp(i108, bArr6, i107, i2, zzkvVar8);
                                                        zzkvVar21 = zzkvVar8;
                                                        obj12 = obj14;
                                                        obj10 = obj5;
                                                        unsafe12 = unsafe5;
                                                    }
                                                    Unsafe unsafe13 = unsafe12;
                                                    Object obj15 = obj10;
                                                    Object obj16 = obj12;
                                                    zzkv zzkvVar23 = zzkvVar21;
                                                    if (zza18 == i106) {
                                                        zznfVar.put(obj15, obj16);
                                                        if (i106 != i16) {
                                                            bArr10 = bArr6;
                                                            zzkvVar10 = zzkvVar23;
                                                            i34 = i2;
                                                            i38 = i15;
                                                            i37 = i35;
                                                            i36 = i106;
                                                            obj7 = obj2;
                                                            i41 = i7;
                                                            i39 = i8;
                                                            i40 = i14;
                                                            unsafe7 = unsafe13;
                                                        } else {
                                                            bArr2 = bArr6;
                                                            zzkvVar2 = zzkvVar23;
                                                            i6 = i15;
                                                            i36 = i106;
                                                            i9 = i14;
                                                            unsafe = unsafe13;
                                                        }
                                                    } else {
                                                        throw new zzmq(str);
                                                    }
                                                }
                                            } else {
                                                zzkvVar6 = zzkvVar21;
                                                str2 = str;
                                                bArr2 = bArr6;
                                                i6 = i15;
                                                str = str2;
                                                i36 = i16;
                                                i9 = i14;
                                                unsafe = unsafe4;
                                                i4 = i3;
                                                zzkvVar2 = zzkvVar6;
                                            }
                                        }
                                        i4 = i3;
                                    } else if (i49 == 2) {
                                        zzmn zzmnVar4 = (zzmn) unsafe10.getObject(obj2, j2);
                                        if (!zzmnVar4.zza()) {
                                            int size3 = zzmnVar4.size();
                                            zzmnVar4 = zzmnVar4.zzg(size3 == 0 ? 10 : size3 + size3);
                                            unsafe10.putObject(obj2, j2, zzmnVar4);
                                        }
                                        int zzn2 = zzkw.zzn(zznoVar.zzp(i35), i46, bArr, i36, i2, zzmnVar4, zzkvVar);
                                        i34 = i2;
                                        i38 = i46;
                                        i37 = i35;
                                        i40 = i47;
                                        obj7 = obj2;
                                        i35 = 0;
                                        i42 = 1048575;
                                        i36 = zzn2;
                                        unsafe7 = unsafe10;
                                        bArr10 = bArr;
                                        zzkvVar10 = zzkvVar;
                                    } else {
                                        zzkvVar6 = zzkvVar;
                                        unsafe4 = unsafe10;
                                        i14 = i47;
                                        i7 = i41;
                                        i15 = i46;
                                        i16 = i36;
                                        i8 = i39;
                                        bArr6 = bArr;
                                        str2 = str;
                                        bArr2 = bArr6;
                                        i6 = i15;
                                        str = str2;
                                        i36 = i16;
                                        i9 = i14;
                                        unsafe = unsafe4;
                                        i4 = i3;
                                        zzkvVar2 = zzkvVar6;
                                    }
                                    if (i6 == i4 || i4 == 0) {
                                        if (zznoVar.zzh) {
                                            zzlq zzlqVar = zzkvVar2.zzd;
                                            int i112 = zzlq.zzb;
                                            int i113 = zznt.zza;
                                            if (zzlqVar != zzlq.zza) {
                                                zznl zznlVar = zznoVar.zzg;
                                                int i114 = zzkw.zza;
                                                if (zzlqVar.zzb(zznlVar, i9) == null) {
                                                    i10 = i2;
                                                    i36 = zzkw.zzo(i6, bArr2, i36, i10, zzg(obj2), zzkvVar2);
                                                    zzkvVar10 = zzkvVar;
                                                    i38 = i6;
                                                    i34 = i10;
                                                    i37 = i35;
                                                    obj7 = obj2;
                                                    i40 = i9;
                                                    i41 = i7;
                                                    i39 = i8;
                                                    i35 = 0;
                                                    i42 = 1048575;
                                                    unsafe7 = unsafe;
                                                    bArr10 = bArr;
                                                } else {
                                                    zzmb zzmbVar = (zzmb) obj2;
                                                    throw null;
                                                }
                                            }
                                        }
                                        i10 = i2;
                                        i36 = zzkw.zzo(i6, bArr, i36, i10, zzg(obj2), zzkvVar);
                                        zzkvVar10 = zzkvVar;
                                        i38 = i6;
                                        i34 = i10;
                                        i37 = i35;
                                        obj7 = obj2;
                                        i40 = i9;
                                        i41 = i7;
                                        i39 = i8;
                                        i35 = 0;
                                        i42 = 1048575;
                                        unsafe7 = unsafe;
                                        bArr10 = bArr;
                                    } else {
                                        i5 = i2;
                                        i38 = i6;
                                        i41 = i7;
                                        i39 = i8;
                                    }
                                }
                            }
                            i9 = i47;
                            if (i6 == i4) {
                            }
                            if (zznoVar.zzh) {
                            }
                            i10 = i2;
                            i36 = zzkw.zzo(i6, bArr, i36, i10, zzg(obj2), zzkvVar);
                            zzkvVar10 = zzkvVar;
                            i38 = i6;
                            i34 = i10;
                            i37 = i35;
                            obj7 = obj2;
                            i40 = i9;
                            i41 = i7;
                            i39 = i8;
                            i35 = 0;
                            i42 = 1048575;
                            unsafe7 = unsafe;
                            bArr10 = bArr;
                        }
                        zzN = -1;
                        if (zzN != -1) {
                        }
                        i9 = i47;
                        if (i6 == i4) {
                        }
                        if (zznoVar.zzh) {
                        }
                        i10 = i2;
                        i36 = zzkw.zzo(i6, bArr, i36, i10, zzg(obj2), zzkvVar);
                        zzkvVar10 = zzkvVar;
                        i38 = i6;
                        i34 = i10;
                        i37 = i35;
                        obj7 = obj2;
                        i40 = i9;
                        i41 = i7;
                        i39 = i8;
                        i35 = 0;
                        i42 = 1048575;
                        unsafe7 = unsafe;
                        bArr10 = bArr;
                    }
                } else {
                    i4 = i3;
                    unsafe = unsafe7;
                    i5 = i34;
                    str = "Failed to parse the message.";
                    obj2 = obj7;
                }
            }
            i35 = 0;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkv zzkvVar) throws IOException {
        zzh(obj, bArr, i, i2, 0, zzkvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznw
    public final void zzj(Object obj) {
        if (zzA(obj)) {
            if (obj instanceof zzme) {
                zzme zzmeVar = (zzme) obj;
                zzmeVar.zzcm(Integer.MAX_VALUE);
                zzmeVar.zza = 0;
                zzmeVar.zzcg();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzx = zzx(i);
                int i2 = 1048575 & zzx;
                int zzz = zzz(zzx);
                long j = i2;
                if (zzz != 9) {
                    if (zzz != 60 && zzz != 68) {
                        switch (zzz) {
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
                                ((zzmn) zzoo.zzn(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zznf) object).zzd();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzL(obj, iArr[i], i)) {
                        zzp(i).zzj(zzb.getObject(obj, j));
                    }
                }
                if (zzJ(obj, i)) {
                    zzp(i).zzj(zzb.getObject(obj, j));
                }
            }
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznw
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
            int zzx = zzx(i7);
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
            if ((268435456 & zzx) != 0 && !zzI(obj, i2, i, i3, i11)) {
                return false;
            }
            int zzz = zzz(zzx);
            if (zzz != 9 && zzz != 17) {
                if (zzz != 27) {
                    if (zzz == 60 || zzz == 68) {
                        if (zzL(obj, i8, i2) && !zzw(obj, zzx, zzp(i2))) {
                            return false;
                        }
                    } else if (zzz != 49) {
                        if (zzz != 50) {
                            continue;
                        } else {
                            zznf zznfVar = (zznf) zzoo.zzn(obj, zzx & 1048575);
                            if (!zznfVar.isEmpty() && ((zzne) zzq(i2)).zze().zzc.zza() == zzot.MESSAGE) {
                                zznw zznwVar = null;
                                for (Object obj2 : zznfVar.values()) {
                                    if (zznwVar == null) {
                                        zznwVar = zznt.zza().zzb(obj2.getClass());
                                    }
                                    if (!zznwVar.zzk(obj2)) {
                                        return false;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                }
                List list = (List) zzoo.zzn(obj, zzx & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zznw zzp = zzp(i2);
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        if (!zzp.zzk(list.get(i13))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzI(obj, i2, i, i3, i11) && !zzw(obj, zzx, zzp(i2))) {
                return false;
            }
            i5++;
            i6 = i;
            i4 = i3;
        }
        return !this.zzh || ((zzmb) obj).zzb.zze();
    }
}
