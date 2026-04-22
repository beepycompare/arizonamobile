package com.google.android.gms.internal.measurement;

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
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* loaded from: classes4.dex */
public final class zznp<T> implements zznx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzop.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznm zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoi zzl;
    private final zzls zzm;

    private zznp(int[] iArr, Object[] objArr, int i, int i2, zznm zznmVar, boolean z, int[] iArr2, int i3, int i4, zznr zznrVar, zzmy zzmyVar, zzoi zzoiVar, zzls zzlsVar, zznh zznhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzlsVar != null && (zznmVar instanceof zzmc)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzoiVar;
        this.zzm = zzlsVar;
        this.zzg = zznmVar;
    }

    private static boolean zzA(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzmf) {
            return ((zzmf) obj).zzcf();
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
        return ((Double) zzop.zzn(obj, j)).doubleValue();
    }

    private static float zzD(Object obj, long j) {
        return ((Float) zzop.zzn(obj, j)).floatValue();
    }

    private static int zzE(Object obj, long j) {
        return ((Integer) zzop.zzn(obj, j)).intValue();
    }

    private static long zzF(Object obj, long j) {
        return ((Long) zzop.zzn(obj, j)).longValue();
    }

    private static boolean zzG(Object obj, long j) {
        return ((Boolean) zzop.zzn(obj, j)).booleanValue();
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
            return ((1 << (zzy >>> 20)) & zzop.zzd(obj, j)) != 0;
        }
        int zzx = zzx(i);
        long j2 = zzx & 1048575;
        switch (zzz(zzx)) {
            case 0:
                return Double.doubleToRawLongBits(zzop.zzl(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzop.zzj(obj, j2)) != 0;
            case 2:
                return zzop.zzf(obj, j2) != 0;
            case 3:
                return zzop.zzf(obj, j2) != 0;
            case 4:
                return zzop.zzd(obj, j2) != 0;
            case 5:
                return zzop.zzf(obj, j2) != 0;
            case 6:
                return zzop.zzd(obj, j2) != 0;
            case 7:
                return zzop.zzh(obj, j2);
            case 8:
                Object zzn = zzop.zzn(obj, j2);
                if (zzn instanceof String) {
                    return !((String) zzn).isEmpty();
                } else if (zzn instanceof zzlh) {
                    return !zzlh.zzb.equals(zzn);
                } else {
                    throw new IllegalArgumentException();
                }
            case 9:
                return zzop.zzn(obj, j2) != null;
            case 10:
                return !zzlh.zzb.equals(zzop.zzn(obj, j2));
            case 11:
                return zzop.zzd(obj, j2) != 0;
            case 12:
                return zzop.zzd(obj, j2) != 0;
            case 13:
                return zzop.zzd(obj, j2) != 0;
            case 14:
                return zzop.zzf(obj, j2) != 0;
            case 15:
                return zzop.zzd(obj, j2) != 0;
            case 16:
                return zzop.zzf(obj, j2) != 0;
            case 17:
                return zzop.zzn(obj, j2) != null;
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
        zzop.zze(obj, j, (1 << (zzy >>> 20)) | zzop.zzd(obj, j));
    }

    private final boolean zzL(Object obj, int i, int i2) {
        return zzop.zzd(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private final void zzM(Object obj, int i, int i2) {
        zzop.zze(obj, zzy(i2) & 1048575, i);
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

    private static final int zzO(byte[] bArr, int i, int i2, zzot zzotVar, Class cls, zzkw zzkwVar) throws IOException {
        zzot zzotVar2 = zzot.DOUBLE;
        switch (zzotVar.ordinal()) {
            case 0:
                int i3 = i + 8;
                zzkwVar.zzc = Double.valueOf(Double.longBitsToDouble(zzkx.zze(bArr, i)));
                return i3;
            case 1:
                int i4 = i + 4;
                zzkwVar.zzc = Float.valueOf(Float.intBitsToFloat(zzkx.zzd(bArr, i)));
                return i4;
            case 2:
            case 3:
                int zzc = zzkx.zzc(bArr, i, zzkwVar);
                zzkwVar.zzc = Long.valueOf(zzkwVar.zzb);
                return zzc;
            case 4:
            case 12:
            case 13:
                int zza2 = zzkx.zza(bArr, i, zzkwVar);
                zzkwVar.zzc = Integer.valueOf(zzkwVar.zza);
                return zza2;
            case 5:
            case 15:
                int i5 = i + 8;
                zzkwVar.zzc = Long.valueOf(zzkx.zze(bArr, i));
                return i5;
            case 6:
            case 14:
                int i6 = i + 4;
                zzkwVar.zzc = Integer.valueOf(zzkx.zzd(bArr, i));
                return i6;
            case 7:
                int zzc2 = zzkx.zzc(bArr, i, zzkwVar);
                zzkwVar.zzc = Boolean.valueOf(zzkwVar.zzb != 0);
                return zzc2;
            case 8:
                return zzkx.zzf(bArr, i, zzkwVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return zzkx.zzh(zznu.zza().zzb(cls), bArr, i, i2, zzkwVar);
            case 11:
                return zzkx.zzg(bArr, i, zzkwVar);
            case 16:
                int zza3 = zzkx.zza(bArr, i, zzkwVar);
                zzkwVar.zzc = Integer.valueOf(zzlj.zzb(zzkwVar.zza));
                return zza3;
            case 17:
                int zzc3 = zzkx.zzc(bArr, i, zzkwVar);
                zzkwVar.zzc = Long.valueOf(zzlj.zzc(zzkwVar.zzb));
                return zzc3;
        }
    }

    private static final void zzP(int i, Object obj, zzov zzovVar) throws IOException {
        if (obj instanceof String) {
            zzovVar.zzm(i, (String) obj);
        } else {
            zzovVar.zzn(i, (zzlh) obj);
        }
    }

    static zzoj zzg(Object obj) {
        zzmf zzmfVar = (zzmf) obj;
        zzoj zzojVar = zzmfVar.zzc;
        if (zzojVar == zzoj.zza()) {
            zzoj zzb2 = zzoj.zzb();
            zzmfVar.zzc = zzb2;
            return zzb2;
        }
        return zzojVar;
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
    public static zznp zzl(Class cls, zznj zznjVar, zznr zznrVar, zzmy zzmyVar, zzoi zzoiVar, zzls zzlsVar, zznh zznhVar) {
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
        if (zznjVar instanceof zznw) {
            zznw zznwVar = (zznw) zznjVar;
            String zzd = zznwVar.zzd();
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
            Object[] zze = zznwVar.zze();
            Class<?> cls2 = zznwVar.zzb().getClass();
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
                zznw zznwVar2 = zznwVar;
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
                            if (zznwVar2.zzc() == 1 || i79 != 0) {
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
                            if (zznwVar2.zzc() == 1 || i79 != 0) {
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
                zznwVar = zznwVar2;
                length = i18;
                i7 = i19;
            }
            return new zznp(iArr3, objArr, i2, i4, zznwVar.zzb(), false, iArr, i5, i64, zznrVar, zzmyVar, zzoiVar, zzlsVar, zznhVar);
        }
        zzof zzofVar = (zzof) zznjVar;
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
            zznx zzp = zzp(i);
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
            zznx zzp = zzp(i);
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

    private final zznx zzp(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zznx zznxVar = (zznx) objArr[i3];
        if (zznxVar != null) {
            return zznxVar;
        }
        zznx zzb2 = zznu.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzq(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzmk zzr(int i) {
        int i2 = i / 3;
        return (zzmk) this.zzd[i2 + i2 + 1];
    }

    private final Object zzs(Object obj, int i) {
        zznx zzp = zzp(i);
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
        zznx zzp = zzp(i2);
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

    private static boolean zzw(Object obj, int i, zznx zznxVar) {
        return zznxVar.zzk(zzop.zzn(obj, i & 1048575));
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

    @Override // com.google.android.gms.internal.measurement.zznx
    public final Object zza() {
        return ((zzmf) this.zzg).zzch();
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final boolean zzb(Object obj, Object obj2) {
        boolean zzB;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzx = zzx(i);
            long j = zzx & 1048575;
            switch (zzz(zzx)) {
                case 0:
                    if (zzH(obj, obj2, i) && Double.doubleToLongBits(zzop.zzl(obj, j)) == Double.doubleToLongBits(zzop.zzl(obj2, j))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i) && Float.floatToIntBits(zzop.zzj(obj, j)) == Float.floatToIntBits(zzop.zzj(obj2, j))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i) && zzop.zzf(obj, j) == zzop.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i) && zzop.zzf(obj, j) == zzop.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i) && zzop.zzd(obj, j) == zzop.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i) && zzop.zzf(obj, j) == zzop.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i) && zzop.zzd(obj, j) == zzop.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i) && zzop.zzh(obj, j) == zzop.zzh(obj2, j)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i) && zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i) && zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i) && zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i) && zzop.zzd(obj, j) == zzop.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i) && zzop.zzd(obj, j) == zzop.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i) && zzop.zzd(obj, j) == zzop.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i) && zzop.zzf(obj, j) == zzop.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i) && zzop.zzd(obj, j) == zzop.zzd(obj2, j)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i) && zzop.zzf(obj, j) == zzop.zzf(obj2, j)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i) && zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
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
                    zzB = zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j));
                    break;
                case 50:
                    zzB = zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j));
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
                    long zzy = zzy(i) & 1048575;
                    if (zzop.zzd(obj, zzy) == zzop.zzd(obj2, zzy) && zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzB) {
                return false;
            }
        }
        if (((zzmf) obj).zzc.equals(((zzmf) obj2).zzc)) {
            if (this.zzh) {
                return ((zzmc) obj).zzb.equals(((zzmc) obj2).zzb);
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznx
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
                        doubleToLongBits = Double.doubleToLongBits(zzop.zzl(obj, j));
                        byte[] bArr = zzmp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 1:
                        i = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzop.zzj(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 2:
                        i = i4 * 53;
                        doubleToLongBits = zzop.zzf(obj, j);
                        byte[] bArr2 = zzmp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 3:
                        i = i4 * 53;
                        doubleToLongBits = zzop.zzf(obj, j);
                        byte[] bArr3 = zzmp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 4:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 5:
                        i = i4 * 53;
                        doubleToLongBits = zzop.zzf(obj, j);
                        byte[] bArr4 = zzmp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 6:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 7:
                        i = i4 * 53;
                        floatToIntBits = zzmp.zzb(zzop.zzh(obj, j));
                        i4 = i + floatToIntBits;
                        break;
                    case 8:
                        i = i4 * 53;
                        floatToIntBits = ((String) zzop.zzn(obj, j)).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 9:
                        i2 = i4 * 53;
                        Object zzn = zzop.zzn(obj, j);
                        if (zzn != null) {
                            i7 = zzn.hashCode();
                        }
                        i4 = i2 + i7;
                        break;
                    case 10:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzn(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 11:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 12:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 13:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 14:
                        i = i4 * 53;
                        doubleToLongBits = zzop.zzf(obj, j);
                        byte[] bArr5 = zzmp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 15:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzd(obj, j);
                        i4 = i + floatToIntBits;
                        break;
                    case 16:
                        i = i4 * 53;
                        doubleToLongBits = zzop.zzf(obj, j);
                        byte[] bArr6 = zzmp.zzb;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i + floatToIntBits;
                        break;
                    case 17:
                        i2 = i4 * 53;
                        Object zzn2 = zzop.zzn(obj, j);
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
                    case 49:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzn(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case 50:
                        i = i4 * 53;
                        floatToIntBits = zzop.zzn(obj, j).hashCode();
                        i4 = i + floatToIntBits;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            doubleToLongBits = Double.doubleToLongBits(zzC(obj, j));
                            byte[] bArr7 = zzmp.zzb;
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
                            byte[] bArr8 = zzmp.zzb;
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
                            byte[] bArr9 = zzmp.zzb;
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
                            byte[] bArr10 = zzmp.zzb;
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
                            floatToIntBits = zzmp.zzb(zzG(obj, j));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 59:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = ((String) zzop.zzn(obj, j)).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 60:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzop.zzn(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 61:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzop.zzn(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case RectListKt.BitOffsetForGesturable /* 62 */:
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
                            byte[] bArr11 = zzmp.zzb;
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
                            byte[] bArr12 = zzmp.zzb;
                            floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                            i4 = i + floatToIntBits;
                            break;
                        }
                    case 68:
                        if (!zzL(obj, i6, i3)) {
                            break;
                        } else {
                            i = i4 * 53;
                            floatToIntBits = zzop.zzn(obj, j).hashCode();
                            i4 = i + floatToIntBits;
                            break;
                        }
                }
                i3 += 3;
            } else {
                int hashCode = (i4 * 53) + ((zzmf) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzmc) obj).zzb.zza.hashCode() : hashCode;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznx
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
                            zzop.zzm(obj, j, zzop.zzl(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zzk(obj, j, zzop.zzj(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zzg(obj, j, zzop.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zzg(obj, j, zzop.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zze(obj, j, zzop.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zzg(obj, j, zzop.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zze(obj, j, zzop.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zzi(obj, j, zzop.zzh(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zzo(obj, j, zzop.zzn(obj2, j));
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
                            zzop.zzo(obj, j, zzop.zzn(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zze(obj, j, zzop.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zze(obj, j, zzop.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zze(obj, j, zzop.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zzg(obj, j, zzop.zzf(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zze(obj, j, zzop.zzd(obj2, j));
                            zzK(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzJ(obj2, i)) {
                            break;
                        } else {
                            zzop.zzg(obj, j, zzop.zzf(obj2, j));
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
                    case 49:
                        zzmo zzmoVar = (zzmo) zzop.zzn(obj, j);
                        zzmo zzmoVar2 = (zzmo) zzop.zzn(obj2, j);
                        int size = zzmoVar.size();
                        int size2 = zzmoVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzmoVar.zza()) {
                                zzmoVar = zzmoVar.zzg(size2 + size);
                            }
                            zzmoVar.addAll(zzmoVar2);
                        }
                        if (size > 0) {
                            zzmoVar2 = zzmoVar;
                        }
                        zzop.zzo(obj, j, zzmoVar2);
                        break;
                    case 50:
                        int i4 = zznz.zza;
                        zzop.zzo(obj, j, zznh.zza(zzop.zzn(obj, j), zzop.zzn(obj2, j)));
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
                            zzop.zzo(obj, j, zzop.zzn(obj2, j));
                            zzM(obj, i3, i);
                            break;
                        }
                    case 60:
                        zzo(obj, obj2, i);
                        break;
                    case 61:
                    case RectListKt.BitOffsetForGesturable /* 62 */:
                    case 63:
                    case 64:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    case 67:
                        if (!zzL(obj2, i3, i)) {
                            break;
                        } else {
                            zzop.zzo(obj, j, zzop.zzn(obj2, j));
                            zzM(obj, i3, i);
                            break;
                        }
                    case 68:
                        zzo(obj, obj2, i);
                        break;
                }
                i += 3;
            } else {
                zznz.zzD(this.zzl, obj, obj2);
                if (this.zzh) {
                    zznz.zzC(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznx
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
        zznp<T> zznpVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (true) {
            int[] iArr = zznpVar.zzc;
            if (i4 < iArr.length) {
                int zzx2 = zznpVar.zzx(i4);
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
                if (zzz17 >= zzlx.DOUBLE_LIST_PACKED.zza()) {
                    zzlx.SINT64_LIST_PACKED.zza();
                }
                long j = i11;
                switch (zzz17) {
                    case 0:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            i6 += zzlm.zzz(i8 << 3) + 8;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz = zzlm.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 2:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            long j2 = unsafe.getLong(obj2, j);
                            zzz2 = zzlm.zzz(i8 << 3);
                            zzA = zzlm.zzA(j2);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 3:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            long j3 = unsafe.getLong(obj2, j);
                            zzz2 = zzlm.zzz(i8 << 3);
                            zzA = zzlm.zzA(j3);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 4:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz2 = zzlm.zzz(i8 << 3);
                            zzA = zzlm.zzA(unsafe.getInt(obj2, j));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 5:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz3 = zzlm.zzz(i8 << 3);
                            zzz4 = zzz3 + 8;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 6:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz = zzlm.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 7:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz4 = zzlm.zzz(i8 << 3) + 1;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 8:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            int i12 = i8 << 3;
                            Object object = unsafe.getObject(obj2, j);
                            if (object instanceof zzlh) {
                                zzz5 = zzlm.zzz(i12);
                                zzc = ((zzlh) object).zzc();
                                zzz6 = zzlm.zzz(zzc);
                                zzz4 = zzz5 + zzz6 + zzc;
                                i6 += zzz4;
                            } else {
                                zzz2 = zzlm.zzz(i12);
                                zzA = zzlm.zzB((String) object);
                                zzz4 = zzz2 + zzA;
                                i6 += zzz4;
                            }
                        }
                        zznpVar = this;
                        break;
                    case 9:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz7 = zznz.zzz(i8, unsafe.getObject(obj2, j), zznpVar.zzp(i4));
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz5 = zzlm.zzz(i8 << 3);
                            zzc = ((zzlh) unsafe.getObject(obj2, j)).zzc();
                            zzz6 = zzlm.zzz(zzc);
                            zzz4 = zzz5 + zzz6 + zzc;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 11:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            int i13 = unsafe.getInt(obj2, j);
                            zzz2 = zzlm.zzz(i8 << 3);
                            zzA = zzlm.zzz(i13);
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 12:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz2 = zzlm.zzz(i8 << 3);
                            zzA = zzlm.zzA(unsafe.getInt(obj2, j));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 13:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz = zzlm.zzz(i8 << 3);
                            zzz4 = zzz + 4;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 14:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz3 = zzlm.zzz(i8 << 3);
                            zzz4 = zzz3 + 8;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 15:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            int i14 = unsafe.getInt(obj2, j);
                            zzz2 = zzlm.zzz(i8 << 3);
                            zzA = zzlm.zzz((i14 >> 31) ^ (i14 + i14));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 16:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            long j4 = unsafe.getLong(obj2, j);
                            zzz2 = zzlm.zzz(i8 << 3);
                            zzA = zzlm.zzA((j4 >> 63) ^ (j4 + j4));
                            zzz4 = zzz2 + zzA;
                            i6 += zzz4;
                        }
                        zznpVar = this;
                        break;
                    case 17:
                        if (zznpVar.zzI(obj2, i4, i7, i5, i)) {
                            zzz7 = zzlm.zzG(i8, (zznm) unsafe.getObject(obj2, j), zznpVar.zzp(i4));
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzz7 = zznz.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 19:
                        zzz7 = zznz.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(obj2, j);
                        int i15 = zznz.zza;
                        if (list.size() != 0) {
                            zzo = zznz.zzo(list) + (list.size() * zzlm.zzz(i8 << 3));
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj2, j);
                        int i16 = zznz.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzp = zznz.zzp(list2);
                            zzz8 = zzlm.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj2, j);
                        int i17 = zznz.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzp = zznz.zzs(list3);
                            zzz8 = zzlm.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 23:
                        zzz7 = zznz.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 24:
                        zzz7 = zznz.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 25:
                        int i18 = zznz.zza;
                        int size2 = ((List) unsafe.getObject(obj2, j)).size();
                        if (size2 != 0) {
                            zzz7 = size2 * (zzlm.zzz(i8 << 3) + 1);
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 26:
                        List list4 = (List) unsafe.getObject(obj2, j);
                        int i19 = zznz.zza;
                        int size3 = list4.size();
                        if (size3 != 0) {
                            zzo = zzlm.zzz(i8 << 3) * size3;
                            if (list4 instanceof zzmx) {
                                zzmx zzmxVar = (zzmx) list4;
                                for (int i20 = 0; i20 < size3; i20++) {
                                    Object zzc3 = zzmxVar.zzc();
                                    if (zzc3 instanceof zzlh) {
                                        int zzc4 = ((zzlh) zzc3).zzc();
                                        zzo += zzlm.zzz(zzc4) + zzc4;
                                    } else {
                                        zzo += zzlm.zzB((String) zzc3);
                                    }
                                }
                            } else {
                                for (int i21 = 0; i21 < size3; i21++) {
                                    Object obj3 = list4.get(i21);
                                    if (obj3 instanceof zzlh) {
                                        int zzc5 = ((zzlh) obj3).zzc();
                                        zzo += zzlm.zzz(zzc5) + zzc5;
                                    } else {
                                        zzo += zzlm.zzB((String) obj3);
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
                        zznx zzp2 = zznpVar.zzp(i4);
                        int i22 = zznz.zza;
                        int size4 = list5.size();
                        if (size4 == 0) {
                            zzz9 = 0;
                        } else {
                            zzz9 = zzlm.zzz(i8 << 3) * size4;
                            for (int i23 = 0; i23 < size4; i23++) {
                                Object obj4 = list5.get(i23);
                                if (obj4 instanceof zzmw) {
                                    int zzb2 = ((zzmw) obj4).zzb();
                                    zzz9 += zzlm.zzz(zzb2) + zzb2;
                                } else {
                                    zzz9 += zzlm.zzD((zznm) obj4, zzp2);
                                }
                            }
                        }
                        i6 += zzz9;
                        break;
                    case 28:
                        List list6 = (List) unsafe.getObject(obj2, j);
                        int i24 = zznz.zza;
                        int size5 = list6.size();
                        if (size5 == 0) {
                            zzz10 = 0;
                        } else {
                            zzz10 = size5 * zzlm.zzz(i8 << 3);
                            for (int i25 = 0; i25 < list6.size(); i25++) {
                                int zzc6 = ((zzlh) list6.get(i25)).zzc();
                                zzz10 += zzlm.zzz(zzc6) + zzc6;
                            }
                        }
                        i6 += zzz10;
                        break;
                    case 29:
                        List list7 = (List) unsafe.getObject(obj2, j);
                        int i26 = zznz.zza;
                        size = list7.size();
                        if (size != 0) {
                            zzp = zznz.zzt(list7);
                            zzz8 = zzlm.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 30:
                        List list8 = (List) unsafe.getObject(obj2, j);
                        int i27 = zznz.zza;
                        size = list8.size();
                        if (size != 0) {
                            zzp = zznz.zzr(list8);
                            zzz8 = zzlm.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 31:
                        zzz7 = zznz.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 32:
                        zzz7 = zznz.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz7;
                        break;
                    case 33:
                        List list9 = (List) unsafe.getObject(obj2, j);
                        int i28 = zznz.zza;
                        size = list9.size();
                        if (size != 0) {
                            zzp = zznz.zzu(list9);
                            zzz8 = zzlm.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 34:
                        List list10 = (List) unsafe.getObject(obj2, j);
                        int i29 = zznz.zza;
                        size = list10.size();
                        if (size != 0) {
                            zzp = zznz.zzq(list10);
                            zzz8 = zzlm.zzz(i8 << 3);
                            i2 = size * zzz8;
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        }
                        zzz7 = 0;
                        i6 += zzz7;
                    case 35:
                        zzx = zznz.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzx = zznz.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzx = zznz.zzo((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzx = zznz.zzp((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzx = zznz.zzs((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzx = zznz.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzx = zznz.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i30 = zznz.zza;
                        zzx = ((List) unsafe.getObject(obj2, j)).size();
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzx = zznz.zzt((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzx = zznz.zzr((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzx = zznz.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzx = zznz.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzx = zznz.zzu((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzx = zznz.zzq((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzz11 = zzlm.zzz(i8 << 3);
                            zzz12 = zzlm.zzz(zzx);
                            zzz10 = zzz11 + zzz12 + zzx;
                            i6 += zzz10;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list11 = (List) unsafe.getObject(obj2, j);
                        zznx zzp3 = zznpVar.zzp(i4);
                        int i31 = zznz.zza;
                        int size6 = list11.size();
                        if (size6 == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            for (int i32 = 0; i32 < size6; i32++) {
                                i3 += zzlm.zzG(i8, (zznm) list11.get(i32), zzp3);
                            }
                        }
                        i6 += i3;
                        break;
                    case 50:
                        zzng zzngVar = (zzng) unsafe.getObject(obj2, j);
                        zznf zznfVar = (zznf) zznpVar.zzq(i4);
                        if (!zzngVar.isEmpty()) {
                            zzo = 0;
                            for (Map.Entry entry : zzngVar.entrySet()) {
                                zzo += zznfVar.zzd(i8, entry.getKey(), entry.getValue());
                            }
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz13 = zzlm.zzz(i8 << 3);
                            zzz7 = zzz13 + 8;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz14 = zzlm.zzz(i8 << 3);
                            zzz7 = zzz14 + 4;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            long zzF = zzF(obj2, j);
                            zzp = zzlm.zzz(i8 << 3);
                            i2 = zzlm.zzA(zzF);
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            long zzF2 = zzF(obj2, j);
                            zzp = zzlm.zzz(i8 << 3);
                            i2 = zzlm.zzA(zzF2);
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzp = zzlm.zzz(i8 << 3);
                            i2 = zzlm.zzA(zzE(obj2, j));
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz13 = zzlm.zzz(i8 << 3);
                            zzz7 = zzz13 + 8;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz14 = zzlm.zzz(i8 << 3);
                            zzz7 = zzz14 + 4;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz7 = zzlm.zzz(i8 << 3) + 1;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (!zznpVar.zzL(obj2, i8, i4)) {
                            break;
                        } else {
                            int i33 = i8 << 3;
                            Object object2 = unsafe.getObject(obj2, j);
                            if (object2 instanceof zzlh) {
                                zzz15 = zzlm.zzz(i33);
                                zzc2 = ((zzlh) object2).zzc();
                                zzz16 = zzlm.zzz(zzc2);
                                zzz7 = zzz15 + zzz16 + zzc2;
                                i6 += zzz7;
                                break;
                            } else {
                                zzp = zzlm.zzz(i33);
                                i2 = zzlm.zzB((String) object2);
                                zzz7 = zzp + i2;
                                i6 += zzz7;
                            }
                        }
                    case 60:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz7 = zznz.zzz(i8, unsafe.getObject(obj2, j), zznpVar.zzp(i4));
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz15 = zzlm.zzz(i8 << 3);
                            zzc2 = ((zzlh) unsafe.getObject(obj2, j)).zzc();
                            zzz16 = zzlm.zzz(zzc2);
                            zzz7 = zzz15 + zzz16 + zzc2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case RectListKt.BitOffsetForGesturable /* 62 */:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            int zzE = zzE(obj2, j);
                            zzp = zzlm.zzz(i8 << 3);
                            i2 = zzlm.zzz(zzE);
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzp = zzlm.zzz(i8 << 3);
                            i2 = zzlm.zzA(zzE(obj2, j));
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz14 = zzlm.zzz(i8 << 3);
                            zzz7 = zzz14 + 4;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz13 = zzlm.zzz(i8 << 3);
                            zzz7 = zzz13 + 8;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            int zzE2 = zzE(obj2, j);
                            zzp = zzlm.zzz(i8 << 3);
                            i2 = zzlm.zzz((zzE2 >> 31) ^ (zzE2 + zzE2));
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            long zzF3 = zzF(obj2, j);
                            zzp = zzlm.zzz(i8 << 3);
                            i2 = zzlm.zzA((zzF3 >> 63) ^ (zzF3 + zzF3));
                            zzz7 = zzp + i2;
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zznpVar.zzL(obj2, i8, i4)) {
                            zzz7 = zzlm.zzG(i8, (zznm) unsafe.getObject(obj2, j), zznpVar.zzp(i4));
                            i6 += zzz7;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                obj2 = obj;
            } else {
                int zzi = i6 + ((zzmf) obj).zzc.zzi();
                if (zznpVar.zzh) {
                    zzoe zzoeVar = ((zzmc) obj).zzb.zza;
                    int zzc7 = zzoeVar.zzc();
                    int i34 = 0;
                    for (int i35 = 0; i35 < zzc7; i35++) {
                        Map.Entry zzd = zzoeVar.zzd(i35);
                        i34 += zzlw.zzj((zzlv) ((zzob) zzd).zza(), zzd.getValue());
                    }
                    for (Map.Entry entry2 : zzoeVar.zze()) {
                        i34 += zzlw.zzj((zzlv) entry2.getKey(), entry2.getValue());
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
    @Override // com.google.android.gms.internal.measurement.zznx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzf(Object obj, zzov zzovVar) throws IOException {
        Map.Entry entry;
        int[] iArr;
        int i;
        int i2;
        int i3;
        zznp<T> zznpVar = this;
        if (zznpVar.zzh) {
            zzlw zzlwVar = ((zzmc) obj).zzb;
            if (!zzlwVar.zza.isEmpty()) {
                entry = (Map.Entry) zzlwVar.zzc().next();
                iArr = zznpVar.zzc;
                Unsafe unsafe = zzb;
                int i4 = 1048575;
                int i5 = 1048575;
                i = 0;
                int i6 = 0;
                while (i < iArr.length) {
                    int zzx = zznpVar.zzx(i);
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
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzf(i7, zzop.zzl(obj, j));
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 1:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zze(i7, zzop.zzj(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 2:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzc(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 3:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzh(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 4:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzi(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 5:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzj(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 6:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzk(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 7:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzl(i7, zzop.zzh(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 8:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzP(i7, unsafe.getObject(obj, j), zzovVar);
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 9:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzr(i7, unsafe.getObject(obj, j), zznpVar.zzp(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 10:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzn(i7, (zzlh) unsafe.getObject(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 11:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzo(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 12:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzg(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 13:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzb(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 14:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzd(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 15:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzp(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 16:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzq(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 17:
                                if (zznpVar.zzI(obj, i, i5, i6, i3)) {
                                    zzovVar.zzs(i7, unsafe.getObject(obj, j), zznpVar.zzp(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 18:
                                zznz.zza(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 19:
                                zznz.zzb(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 20:
                                zznz.zzc(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 21:
                                zznz.zzd(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 22:
                                zznz.zzh(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 23:
                                zznz.zzf(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 24:
                                zznz.zzk(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 25:
                                zznz.zzn(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 26:
                                int i10 = iArr[i];
                                List list = (List) unsafe.getObject(obj, j);
                                int i11 = zznz.zza;
                                if (list != null && !list.isEmpty()) {
                                    zzovVar.zzF(i10, list);
                                    break;
                                }
                                break;
                            case 27:
                                int i12 = iArr[i];
                                List list2 = (List) unsafe.getObject(obj, j);
                                zznx zzp = zznpVar.zzp(i);
                                int i13 = zznz.zza;
                                if (list2 != null && !list2.isEmpty()) {
                                    for (int i14 = 0; i14 < list2.size(); i14++) {
                                        ((zzln) zzovVar).zzr(i12, list2.get(i14), zzp);
                                    }
                                    break;
                                }
                                break;
                            case 28:
                                int i15 = iArr[i];
                                List list3 = (List) unsafe.getObject(obj, j);
                                int i16 = zznz.zza;
                                if (list3 != null && !list3.isEmpty()) {
                                    zzovVar.zzG(i15, list3);
                                    break;
                                }
                                break;
                            case 29:
                                zznz.zzi(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 30:
                                zznz.zzm(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 31:
                                zznz.zzl(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 32:
                                zznz.zzg(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 33:
                                zznz.zzj(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 34:
                                zznz.zze(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zznpVar = this;
                            case 35:
                                zznz.zza(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 36:
                                zznz.zzb(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 37:
                                zznz.zzc(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 38:
                                zznz.zzd(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 39:
                                zznz.zzh(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 40:
                                zznz.zzf(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 41:
                                zznz.zzk(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 42:
                                zznz.zzn(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 43:
                                zznz.zzi(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 44:
                                zznz.zzm(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 45:
                                zznz.zzl(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 46:
                                zznz.zzg(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 47:
                                zznz.zzj(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 48:
                                zznz.zze(iArr[i], (List) unsafe.getObject(obj, j), zzovVar, true);
                                break;
                            case 49:
                                int i17 = iArr[i];
                                List list4 = (List) unsafe.getObject(obj, j);
                                zznx zzp2 = zznpVar.zzp(i);
                                int i18 = zznz.zza;
                                if (list4 != null && !list4.isEmpty()) {
                                    for (int i19 = 0; i19 < list4.size(); i19++) {
                                        ((zzln) zzovVar).zzs(i17, list4.get(i19), zzp2);
                                    }
                                    break;
                                }
                                break;
                            case 50:
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    zzovVar.zzM(i7, ((zznf) zznpVar.zzq(i)).zze(), (zzng) object);
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzf(i7, zzC(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zze(i7, zzD(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzc(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzh(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzi(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 56:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzj(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case 57:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzk(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 58:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzl(i7, zzG(obj, j));
                                    break;
                                }
                                break;
                            case 59:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzP(i7, unsafe.getObject(obj, j), zzovVar);
                                    break;
                                }
                                break;
                            case 60:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzr(i7, unsafe.getObject(obj, j), zznpVar.zzp(i));
                                    break;
                                }
                                break;
                            case 61:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzn(i7, (zzlh) unsafe.getObject(obj, j));
                                    break;
                                }
                                break;
                            case RectListKt.BitOffsetForGesturable /* 62 */:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzo(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 63:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzg(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 64:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzb(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzd(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzp(i7, zzE(obj, j));
                                    break;
                                }
                                break;
                            case 67:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzq(i7, zzF(obj, j));
                                    break;
                                }
                                break;
                            case 68:
                                if (zznpVar.zzL(obj, i7, i)) {
                                    zzovVar.zzs(i7, unsafe.getObject(obj, j), zznpVar.zzp(i));
                                    break;
                                }
                                break;
                        }
                        i += 3;
                        i4 = 1048575;
                        zznpVar = this;
                    } else {
                        zzmd zzmdVar = (zzmd) entry.getKey();
                        throw null;
                    }
                }
                if (entry != null) {
                    ((zzmf) obj).zzc.zzg(zzovVar);
                    return;
                } else {
                    zzmd zzmdVar2 = (zzmd) entry.getKey();
                    throw null;
                }
            }
        }
        entry = null;
        iArr = zznpVar.zzc;
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
        throw new com.google.android.gms.internal.measurement.zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
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
        r11 = com.google.android.gms.internal.measurement.zzop.zzn(r10, r0.zzx(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:579:0x0e29, code lost:
        if (r11 == null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x0e2b, code lost:
        r12 = r0.zzr(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x0e2f, code lost:
        if (r12 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x0e31, code lost:
        r5 = ((com.google.android.gms.internal.measurement.zznf) r0.zzq(r5)).zze();
        r11 = ((com.google.android.gms.internal.measurement.zzng) r11).entrySet().iterator();
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
        r14 = com.google.android.gms.internal.measurement.zznf.zzc(r5, r13.getKey(), r13.getValue());
        r15 = com.google.android.gms.internal.measurement.zzlh.zzb;
        r15 = new byte[r14];
        r17 = com.google.android.gms.internal.measurement.zzlm.zzb;
        r17 = r1;
        r0 = new com.google.android.gms.internal.measurement.zzlk(r15, 0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:590:0x0e81, code lost:
        com.google.android.gms.internal.measurement.zznf.zzb(r0, r5, r13.getKey(), r13.getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:591:0x0e8c, code lost:
        r2.zzk((r8 << 3) | 2, com.google.android.gms.internal.measurement.zzle.zza(r0, r15));
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
        ((com.google.android.gms.internal.measurement.zzmf) r10).zzc = r2;
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
        throw new com.google.android.gms.internal.measurement.zzmr(r30);
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
        throw new com.google.android.gms.internal.measurement.zzmr(r12);
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
    public final int zzh(Object obj, byte[] bArr, int i, int i2, int i3, zzkw zzkwVar) throws IOException {
        int i4;
        Object obj2;
        int i5;
        String str;
        Unsafe unsafe;
        int zzN;
        int i6;
        int i7;
        int i8;
        byte[] bArr2;
        zzkw zzkwVar2;
        int i9;
        int i10;
        Unsafe unsafe2;
        Object obj3;
        byte[] bArr3;
        zzkw zzkwVar3;
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
        zzkw zzkwVar4;
        int i17;
        int i18;
        int zza2;
        int i19;
        zzkw zzkwVar5;
        int i20;
        int i21;
        int i22;
        Object obj5;
        int i23;
        byte[] bArr6;
        int i24;
        zzkw zzkwVar6;
        int zzl;
        zzmo zzmoVar;
        int i25;
        int i26;
        int i27;
        int i28;
        int zza3;
        int i29;
        byte[] bArr7;
        int i30;
        int i31;
        int i32;
        int i33;
        byte[] bArr8;
        zzkw zzkwVar7;
        int i34;
        int zzg;
        int i35;
        int zza4;
        zzkw zzkwVar8;
        Object obj6;
        int i36;
        Object obj7;
        zzkw zzkwVar9;
        zznp<T> zznpVar = this;
        Object obj8 = obj;
        byte[] bArr9 = bArr;
        int i37 = i2;
        zzkw zzkwVar10 = zzkwVar;
        zzB(obj8);
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
                        i46 = zzkx.zzb(i47, bArr9, i46, zzkwVar10);
                        i47 = zzkwVar10.zza;
                    }
                    int i48 = i46;
                    int i49 = i47;
                    i39 = i48;
                    int i50 = i49 >>> 3;
                    if (i50 <= i43) {
                        if (i50 >= zznpVar.zze && i50 <= zznpVar.zzf) {
                            zzN = zznpVar.zzN(i50, i38);
                            if (zzN != -1) {
                            }
                            if (i8 == i4) {
                            }
                            if (zznpVar.zzh) {
                            }
                            i10 = i2;
                            i39 = zzkx.zzo(i8, bArr, i39, i10, zzg(obj2), zzkwVar);
                            bArr9 = bArr;
                            unsafe5 = unsafe;
                            obj8 = obj2;
                            i40 = i38;
                            i41 = i8;
                            i44 = i6;
                            i38 = 0;
                            i45 = 1048575;
                            zzkwVar10 = zzkwVar;
                            i37 = i10;
                            i43 = i9;
                            i42 = i7;
                        }
                        zzN = -1;
                        if (zzN != -1) {
                        }
                        if (i8 == i4) {
                        }
                        if (zznpVar.zzh) {
                        }
                        i10 = i2;
                        i39 = zzkx.zzo(i8, bArr, i39, i10, zzg(obj2), zzkwVar);
                        bArr9 = bArr;
                        unsafe5 = unsafe;
                        obj8 = obj2;
                        i40 = i38;
                        i41 = i8;
                        i44 = i6;
                        i38 = 0;
                        i45 = 1048575;
                        zzkwVar10 = zzkwVar;
                        i37 = i10;
                        i43 = i9;
                        i42 = i7;
                    } else {
                        int i51 = i40 / 3;
                        if (i50 >= zznpVar.zze && i50 <= zznpVar.zzf) {
                            zzN = zznpVar.zzN(i50, i51);
                            if (zzN != -1) {
                                i4 = i3;
                                unsafe = unsafe5;
                                str = "Failed to parse the message.";
                                i6 = i44;
                                i7 = i42;
                                i8 = i49;
                                bArr2 = bArr9;
                                zzkwVar2 = zzkwVar10;
                                i9 = i50;
                                obj2 = obj8;
                            } else {
                                int i52 = i49 & 7;
                                int[] iArr = zznpVar.zzc;
                                int i53 = zzN;
                                int i54 = iArr[zzN + 1];
                                int zzz = zzz(i54);
                                long j = i54 & i45;
                                if (zzz <= 17) {
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
                                    switch (zzz) {
                                        case 0:
                                            zzkw zzkwVar11 = zzkwVar10;
                                            bArr3 = bArr9;
                                            zzkwVar3 = zzkwVar11;
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
                                                zzkwVar2 = zzkwVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                i11 = i39 + 8;
                                                i12 = i7 | i56;
                                                zzop.zzm(obj3, j, Double.longBitsToDouble(zzkx.zze(bArr3, i39)));
                                                byte[] bArr10 = bArr3;
                                                zzkwVar10 = zzkwVar3;
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
                                            zzkw zzkwVar12 = zzkwVar10;
                                            bArr3 = bArr9;
                                            zzkwVar3 = zzkwVar12;
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
                                                zzkwVar2 = zzkwVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                i11 = i39 + 4;
                                                i12 = i7 | i56;
                                                zzop.zzk(obj3, j, Float.intBitsToFloat(zzkx.zzd(bArr3, i39)));
                                                byte[] bArr102 = bArr3;
                                                zzkwVar10 = zzkwVar3;
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
                                            zzkw zzkwVar13 = zzkwVar10;
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
                                                zzkwVar2 = zzkwVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                int zzc = zzkx.zzc(bArr11, i39, zzkwVar13);
                                                unsafe5.putLong(obj8, j, zzkwVar13.zzb);
                                                zzkwVar10 = zzkwVar13;
                                                bArr9 = bArr11;
                                                i42 = i7 | i56;
                                                i39 = zzc;
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
                                            zzkw zzkwVar14 = zzkwVar10;
                                            byte[] bArr12 = bArr9;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 == 0) {
                                                i13 = i7 | i56;
                                                i39 = zzkx.zza(bArr12, i39, zzkwVar14);
                                                unsafe5.putInt(obj8, j, zzkwVar14.zza);
                                                bArr4 = bArr12;
                                                zzkwVar10 = zzkwVar14;
                                                break;
                                            }
                                            unsafe2 = unsafe5;
                                            obj3 = obj8;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzkwVar2 = zzkwVar;
                                            i9 = i50;
                                            break;
                                        case 5:
                                        case 14:
                                            byte[] bArr13 = bArr9;
                                            Unsafe unsafe6 = unsafe5;
                                            zzkw zzkwVar15 = zzkwVar10;
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
                                                zzkwVar2 = zzkwVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                unsafe5 = unsafe6;
                                                unsafe5.putLong(obj8, j, zzkx.zze(bArr13, i39));
                                                zzkwVar10 = zzkwVar15;
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
                                            zzkw zzkwVar16 = zzkwVar10;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 == 5) {
                                                i14 = i7 | i56;
                                                unsafe3.putInt(obj8, j, zzkx.zzd(bArr14, i39));
                                                zzkwVar10 = zzkwVar16;
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
                                            zzkwVar2 = zzkwVar;
                                            i9 = i50;
                                            break;
                                        case 7:
                                            byte[] bArr15 = bArr9;
                                            unsafe3 = unsafe5;
                                            zzkw zzkwVar17 = zzkwVar10;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 == 0) {
                                                i13 = i7 | i56;
                                                i39 = zzkx.zzc(bArr15, i39, zzkwVar17);
                                                zzop.zzi(obj8, j, zzkwVar17.zzb != 0);
                                                bArr4 = bArr15;
                                                zzkwVar10 = zzkwVar17;
                                                unsafe5 = unsafe3;
                                                break;
                                            }
                                            obj3 = obj8;
                                            unsafe2 = unsafe3;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzkwVar2 = zzkwVar;
                                            i9 = i50;
                                            break;
                                        case 8:
                                            byte[] bArr16 = bArr9;
                                            unsafe3 = unsafe5;
                                            zzkw zzkwVar18 = zzkwVar10;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            i7 = i42;
                                            if (i52 == 2) {
                                                if ((i54 & C.BUFFER_FLAG_LAST_SAMPLE) == 0) {
                                                    i39 = zzkx.zza(bArr16, i39, zzkwVar18);
                                                    int i59 = zzkwVar18.zza;
                                                    if (i59 < 0) {
                                                        throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                    }
                                                    i14 = i7 | i56;
                                                    if (i59 != 0) {
                                                        zzkwVar18.zzc = new String(bArr16, i39, i59, zzmp.zza);
                                                        i39 += i59;
                                                    } else {
                                                        zzkwVar18.zzc = "";
                                                    }
                                                } else {
                                                    i39 = zzkx.zzf(bArr16, i39, zzkwVar18);
                                                    i14 = i7 | i56;
                                                }
                                                unsafe3.putObject(obj8, j, zzkwVar18.zzc);
                                                zzkwVar10 = zzkwVar18;
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
                                            zzkwVar2 = zzkwVar;
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
                                                zzkwVar2 = zzkwVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                i42 = i60 | i56;
                                                Unsafe unsafe7 = unsafe5;
                                                Object zzs = zznpVar.zzs(obj4, i38);
                                                byte[] bArr17 = bArr9;
                                                zzkw zzkwVar19 = zzkwVar10;
                                                int zzj = zzkx.zzj(zzs, zznpVar.zzp(i38), bArr17, i39, i2, zzkwVar19);
                                                zznpVar.zzt(obj4, i38, zzs);
                                                zzkwVar10 = zzkwVar19;
                                                unsafe5 = unsafe7;
                                                bArr9 = bArr17;
                                                i37 = i2;
                                                i39 = zzj;
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
                                                i39 = zzkx.zzg(bArr9, i39, zzkwVar10);
                                                unsafe5.putObject(obj4, j, zzkwVar10.zzc);
                                                break;
                                            }
                                            unsafe2 = unsafe5;
                                            i7 = i15;
                                            obj3 = obj4;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzkwVar2 = zzkwVar;
                                            i9 = i50;
                                            break;
                                        case 12:
                                            obj4 = obj8;
                                            i15 = i42;
                                            i8 = i49;
                                            i38 = i53;
                                            i6 = i44;
                                            if (i52 == 0) {
                                                i39 = zzkx.zza(bArr9, i39, zzkwVar10);
                                                int i61 = zzkwVar10.zza;
                                                zzmk zzr = zznpVar.zzr(i38);
                                                if ((i54 & Integer.MIN_VALUE) == 0 || zzr == null || zzr.zza(i61)) {
                                                    i15 |= i56;
                                                    unsafe5.putInt(obj4, j, i61);
                                                    break;
                                                } else {
                                                    zzg(obj4).zzk(i8, Long.valueOf(i61));
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
                                            zzkwVar2 = zzkwVar;
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
                                                i39 = zzkx.zza(bArr9, i39, zzkwVar10);
                                                unsafe5.putInt(obj4, j, zzlj.zzb(zzkwVar10.zza));
                                                break;
                                            }
                                            unsafe2 = unsafe5;
                                            i7 = i15;
                                            obj3 = obj4;
                                            bArr2 = bArr;
                                            i4 = i3;
                                            obj2 = obj3;
                                            unsafe = unsafe2;
                                            zzkwVar2 = zzkwVar;
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
                                                zzkwVar2 = zzkwVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                i42 |= i56;
                                                int zzc2 = zzkx.zzc(bArr9, i39, zzkwVar10);
                                                unsafe5.putLong(obj8, j, zzlj.zzc(zzkwVar10.zzb));
                                                i39 = zzc2;
                                                i40 = i53;
                                                i43 = i50;
                                                i41 = i49;
                                                i38 = 0;
                                                i45 = 1048575;
                                                i37 = i2;
                                                break;
                                            }
                                        default:
                                            zzkw zzkwVar20 = zzkwVar10;
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
                                                zzkwVar2 = zzkwVar;
                                                i9 = i50;
                                                break;
                                            } else {
                                                Object zzs2 = zznpVar.zzs(obj3, i38);
                                                int zzk = zzkx.zzk(zzs2, zznpVar.zzp(i38), bArr18, i39, i2, (i50 << 3) | 4, zzkwVar20);
                                                zznpVar.zzt(obj3, i38, zzs2);
                                                bArr9 = bArr;
                                                zzkwVar10 = zzkwVar;
                                                i39 = zzk;
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
                                    if (zzz != 27) {
                                        i7 = i42;
                                        zzkw zzkwVar21 = zzkwVar;
                                        Unsafe unsafe9 = unsafe8;
                                        i6 = i44;
                                        i16 = i50;
                                        if (zzz <= 49) {
                                            long j2 = i54;
                                            zzmo zzmoVar2 = (zzmo) unsafe9.getObject(obj2, j);
                                            if (!zzmoVar2.zza()) {
                                                int size = zzmoVar2.size();
                                                zzmoVar2 = zzmoVar2.zzg(size + size);
                                                unsafe9.putObject(obj2, j, zzmoVar2);
                                            }
                                            switch (zzz) {
                                                case 18:
                                                case 35:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar4 = zzkwVar21;
                                                    i8 = i49;
                                                    zzmo zzmoVar3 = zzmoVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 1) {
                                                            i18 = i17 + 8;
                                                            int i62 = zzkx.zza;
                                                            zzlo zzloVar = (zzlo) zzmoVar3;
                                                            zzloVar.zzf(Double.longBitsToDouble(zzkx.zze(bArr5, i17)));
                                                            while (i18 < i2) {
                                                                int zza5 = zzkx.zza(bArr5, i18, zzkwVar4);
                                                                if (i8 == zzkwVar4.zza) {
                                                                    zzloVar.zzf(Double.longBitsToDouble(zzkx.zze(bArr5, zza5)));
                                                                    i18 = zza5 + 8;
                                                                } else {
                                                                    zza2 = i18;
                                                                    i19 = i17;
                                                                    zzkwVar21 = zzkwVar4;
                                                                    bArr6 = bArr5;
                                                                }
                                                            }
                                                            zza2 = i18;
                                                            i19 = i17;
                                                            zzkwVar21 = zzkwVar4;
                                                            bArr6 = bArr5;
                                                        }
                                                        i19 = i17;
                                                        zzkwVar21 = zzkwVar4;
                                                        bArr6 = bArr5;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        int i63 = zzkx.zza;
                                                        zzlo zzloVar2 = (zzlo) zzmoVar3;
                                                        zza2 = zzkx.zza(bArr5, i17, zzkwVar4);
                                                        int i64 = zzkwVar4.zza;
                                                        int i65 = zza2 + i64;
                                                        if (i65 <= bArr5.length) {
                                                            zzloVar2.zzh(zzloVar2.size() + (i64 / 8));
                                                            while (zza2 < i65) {
                                                                zzloVar2.zzf(Double.longBitsToDouble(zzkx.zze(bArr5, zza2)));
                                                                zza2 += 8;
                                                            }
                                                            if (zza2 != i65) {
                                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            i19 = i17;
                                                            zzkwVar21 = zzkwVar4;
                                                            bArr6 = bArr5;
                                                            break;
                                                        } else {
                                                            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                case 19:
                                                case 36:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar4 = zzkwVar21;
                                                    i8 = i49;
                                                    zzmo zzmoVar4 = zzmoVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 5) {
                                                            i18 = i17 + 4;
                                                            int i66 = zzkx.zza;
                                                            zzly zzlyVar = (zzly) zzmoVar4;
                                                            zzlyVar.zzf(Float.intBitsToFloat(zzkx.zzd(bArr5, i17)));
                                                            while (i18 < i2) {
                                                                int zza6 = zzkx.zza(bArr5, i18, zzkwVar4);
                                                                if (i8 == zzkwVar4.zza) {
                                                                    zzlyVar.zzf(Float.intBitsToFloat(zzkx.zzd(bArr5, zza6)));
                                                                    i18 = zza6 + 4;
                                                                } else {
                                                                    zza2 = i18;
                                                                    i19 = i17;
                                                                    zzkwVar21 = zzkwVar4;
                                                                    bArr6 = bArr5;
                                                                }
                                                            }
                                                            zza2 = i18;
                                                            i19 = i17;
                                                            zzkwVar21 = zzkwVar4;
                                                            bArr6 = bArr5;
                                                        }
                                                        i19 = i17;
                                                        zzkwVar21 = zzkwVar4;
                                                        bArr6 = bArr5;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        int i67 = zzkx.zza;
                                                        zzly zzlyVar2 = (zzly) zzmoVar4;
                                                        zza2 = zzkx.zza(bArr5, i17, zzkwVar4);
                                                        int i68 = zzkwVar4.zza;
                                                        int i69 = zza2 + i68;
                                                        if (i69 <= bArr5.length) {
                                                            zzlyVar2.zzh(zzlyVar2.size() + (i68 / 4));
                                                            while (zza2 < i69) {
                                                                zzlyVar2.zzf(Float.intBitsToFloat(zzkx.zzd(bArr5, zza2)));
                                                                zza2 += 4;
                                                            }
                                                            if (zza2 != i69) {
                                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            i19 = i17;
                                                            zzkwVar21 = zzkwVar4;
                                                            bArr6 = bArr5;
                                                            break;
                                                        } else {
                                                            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                case 20:
                                                case 21:
                                                case 37:
                                                case 38:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar4 = zzkwVar21;
                                                    i8 = i49;
                                                    zzmo zzmoVar5 = zzmoVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            int i70 = zzkx.zza;
                                                            zzna zznaVar = (zzna) zzmoVar5;
                                                            zza2 = zzkx.zzc(bArr5, i17, zzkwVar4);
                                                            zznaVar.zzf(zzkwVar4.zzb);
                                                            while (zza2 < i2) {
                                                                int zza7 = zzkx.zza(bArr5, zza2, zzkwVar4);
                                                                if (i8 == zzkwVar4.zza) {
                                                                    zza2 = zzkx.zzc(bArr5, zza7, zzkwVar4);
                                                                    zznaVar.zzf(zzkwVar4.zzb);
                                                                }
                                                            }
                                                        }
                                                        i19 = i17;
                                                        zzkwVar21 = zzkwVar4;
                                                        bArr6 = bArr5;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        int i71 = zzkx.zza;
                                                        zzna zznaVar2 = (zzna) zzmoVar5;
                                                        zza2 = zzkx.zza(bArr5, i17, zzkwVar4);
                                                        int i72 = zzkwVar4.zza + zza2;
                                                        while (zza2 < i72) {
                                                            zza2 = zzkx.zzc(bArr5, zza2, zzkwVar4);
                                                            zznaVar2.zzf(zzkwVar4.zzb);
                                                        }
                                                        if (zza2 != i72) {
                                                            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    i19 = i17;
                                                    zzkwVar21 = zzkwVar4;
                                                    bArr6 = bArr5;
                                                    break;
                                                case 22:
                                                case 29:
                                                case 39:
                                                case 43:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar4 = zzkwVar21;
                                                    i8 = i49;
                                                    zzmo zzmoVar6 = zzmoVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            zza2 = zzkx.zzl(i8, bArr5, i17, i2, zzmoVar6, zzkwVar4);
                                                            i19 = i17;
                                                            zzkwVar21 = zzkwVar4;
                                                            bArr6 = bArr5;
                                                        }
                                                        i19 = i17;
                                                        zzkwVar21 = zzkwVar4;
                                                        bArr6 = bArr5;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        i18 = zzkx.zzm(bArr5, i17, zzmoVar6, zzkwVar4);
                                                        zza2 = i18;
                                                        i19 = i17;
                                                        zzkwVar21 = zzkwVar4;
                                                        bArr6 = bArr5;
                                                        break;
                                                    }
                                                case 23:
                                                case 32:
                                                case 40:
                                                case 46:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar4 = zzkwVar21;
                                                    int i73 = i16;
                                                    i8 = i49;
                                                    zzmo zzmoVar7 = zzmoVar2;
                                                    i17 = i39;
                                                    if (i52 != 2) {
                                                        i16 = i73;
                                                        if (i52 == 1) {
                                                            i18 = i17 + 8;
                                                            int i74 = zzkx.zza;
                                                            zzna zznaVar3 = (zzna) zzmoVar7;
                                                            zznaVar3.zzf(zzkx.zze(bArr5, i17));
                                                            while (i18 < i2) {
                                                                int zza8 = zzkx.zza(bArr5, i18, zzkwVar4);
                                                                if (i8 == zzkwVar4.zza) {
                                                                    zznaVar3.zzf(zzkx.zze(bArr5, zza8));
                                                                    i18 = zza8 + 8;
                                                                } else {
                                                                    zza2 = i18;
                                                                    i19 = i17;
                                                                    zzkwVar21 = zzkwVar4;
                                                                    bArr6 = bArr5;
                                                                }
                                                            }
                                                            zza2 = i18;
                                                            i19 = i17;
                                                            zzkwVar21 = zzkwVar4;
                                                            bArr6 = bArr5;
                                                        }
                                                        i19 = i17;
                                                        zzkwVar21 = zzkwVar4;
                                                        bArr6 = bArr5;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        int i75 = zzkx.zza;
                                                        zzna zznaVar4 = (zzna) zzmoVar7;
                                                        zza2 = zzkx.zza(bArr5, i17, zzkwVar4);
                                                        int i76 = zzkwVar4.zza;
                                                        int i77 = zza2 + i76;
                                                        if (i77 <= bArr5.length) {
                                                            zznaVar4.zzh(zznaVar4.size() + (i76 / 8));
                                                            while (zza2 < i77) {
                                                                zznaVar4.zzf(zzkx.zze(bArr5, zza2));
                                                                zza2 += 8;
                                                                i73 = i73;
                                                            }
                                                            i16 = i73;
                                                            if (zza2 != i77) {
                                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            i19 = i17;
                                                            zzkwVar21 = zzkwVar4;
                                                            bArr6 = bArr5;
                                                            break;
                                                        } else {
                                                            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                case 24:
                                                case 31:
                                                case 41:
                                                case 45:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar5 = zzkwVar21;
                                                    i20 = i16;
                                                    i8 = i49;
                                                    zzmo zzmoVar8 = zzmoVar2;
                                                    i21 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 5) {
                                                            int i78 = i21 + 4;
                                                            int i79 = zzkx.zza;
                                                            zzmg zzmgVar = (zzmg) zzmoVar8;
                                                            zzmgVar.zzh(zzkx.zzd(bArr5, i21));
                                                            while (i78 < i2) {
                                                                int zza9 = zzkx.zza(bArr5, i78, zzkwVar5);
                                                                if (i8 == zzkwVar5.zza) {
                                                                    zzmgVar.zzh(zzkx.zzd(bArr5, zza9));
                                                                    i78 = zza9 + 4;
                                                                } else {
                                                                    zza2 = i78;
                                                                }
                                                            }
                                                            zza2 = i78;
                                                        }
                                                        zzkwVar21 = zzkwVar5;
                                                        i16 = i20;
                                                        i19 = i21;
                                                        bArr6 = bArr5;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        int i80 = zzkx.zza;
                                                        zzmg zzmgVar2 = (zzmg) zzmoVar8;
                                                        zza2 = zzkx.zza(bArr5, i21, zzkwVar5);
                                                        int i81 = zzkwVar5.zza;
                                                        int i82 = zza2 + i81;
                                                        if (i82 <= bArr5.length) {
                                                            zzmgVar2.zzi(zzmgVar2.size() + (i81 / 4));
                                                            while (zza2 < i82) {
                                                                zzmgVar2.zzh(zzkx.zzd(bArr5, zza2));
                                                                zza2 += 4;
                                                            }
                                                            if (zza2 != i82) {
                                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                        } else {
                                                            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    zzkwVar21 = zzkwVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    break;
                                                case 25:
                                                case 42:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar5 = zzkwVar21;
                                                    i20 = i16;
                                                    i8 = i49;
                                                    zzmo zzmoVar9 = zzmoVar2;
                                                    i21 = i39;
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            int i83 = zzkx.zza;
                                                            zzky zzkyVar = (zzky) zzmoVar9;
                                                            zza2 = zzkx.zzc(bArr5, i21, zzkwVar5);
                                                            zzkyVar.zzf(zzkwVar5.zzb != 0);
                                                            while (zza2 < i2) {
                                                                int zza10 = zzkx.zza(bArr5, zza2, zzkwVar5);
                                                                if (i8 == zzkwVar5.zza) {
                                                                    zza2 = zzkx.zzc(bArr5, zza10, zzkwVar5);
                                                                    zzkyVar.zzf(zzkwVar5.zzb != 0);
                                                                }
                                                            }
                                                        }
                                                        zzkwVar21 = zzkwVar5;
                                                        i16 = i20;
                                                        i19 = i21;
                                                        bArr6 = bArr5;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        int i84 = zzkx.zza;
                                                        zzky zzkyVar2 = (zzky) zzmoVar9;
                                                        zza2 = zzkx.zza(bArr5, i21, zzkwVar5);
                                                        int i85 = zzkwVar5.zza + zza2;
                                                        while (zza2 < i85) {
                                                            zza2 = zzkx.zzc(bArr5, zza2, zzkwVar5);
                                                            zzkyVar2.zzf(zzkwVar5.zzb != 0);
                                                        }
                                                        if (zza2 != i85) {
                                                            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    zzkwVar21 = zzkwVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    break;
                                                case 26:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar5 = zzkwVar21;
                                                    i20 = i16;
                                                    i8 = i49;
                                                    zzmo zzmoVar10 = zzmoVar2;
                                                    i21 = i39;
                                                    if (i52 == 2) {
                                                        if ((j2 & 536870912) == 0) {
                                                            zza2 = zzkx.zza(bArr5, i21, zzkwVar5);
                                                            int i86 = zzkwVar5.zza;
                                                            if (i86 < 0) {
                                                                throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i86 == 0) {
                                                                obj5 = "";
                                                                zzmoVar10.add(obj5);
                                                                while (zza2 < i2) {
                                                                    int zza11 = zzkx.zza(bArr5, zza2, zzkwVar5);
                                                                    if (i8 == zzkwVar5.zza) {
                                                                        zza2 = zzkx.zza(bArr5, zza11, zzkwVar5);
                                                                        i86 = zzkwVar5.zza;
                                                                        if (i86 < 0) {
                                                                            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                        if (i86 == 0) {
                                                                            zzmoVar10.add(obj5);
                                                                        } else {
                                                                            zzmoVar10.add(new String(bArr5, zza2, i86, zzmp.zza));
                                                                            zza2 += i86;
                                                                            while (zza2 < i2) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                obj5 = "";
                                                                zzmoVar10.add(new String(bArr5, zza2, i86, zzmp.zza));
                                                                zza2 += i86;
                                                                while (zza2 < i2) {
                                                                }
                                                            }
                                                        } else {
                                                            zza2 = zzkx.zza(bArr5, i21, zzkwVar5);
                                                            int i87 = zzkwVar5.zza;
                                                            if (i87 < 0) {
                                                                throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i87 == 0) {
                                                                zzmoVar10.add("");
                                                                while (zza2 < i2) {
                                                                    int zza12 = zzkx.zza(bArr5, zza2, zzkwVar5);
                                                                    if (i8 == zzkwVar5.zza) {
                                                                        zza2 = zzkx.zza(bArr5, zza12, zzkwVar5);
                                                                        int i88 = zzkwVar5.zza;
                                                                        if (i88 < 0) {
                                                                            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                        if (i88 == 0) {
                                                                            zzmoVar10.add("");
                                                                        } else {
                                                                            int i89 = zza2 + i88;
                                                                            if (zzos.zza(bArr5, zza2, i89)) {
                                                                                i22 = i89;
                                                                                zzmoVar10.add(new String(bArr5, zza2, i88, zzmp.zza));
                                                                                zza2 = i22;
                                                                                while (zza2 < i2) {
                                                                                }
                                                                            } else {
                                                                                throw new zzmr("Protocol message had invalid UTF-8.");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            } else {
                                                                int i90 = zza2 + i87;
                                                                if (zzos.zza(bArr5, zza2, i90)) {
                                                                    i22 = i90;
                                                                    zzmoVar10.add(new String(bArr5, zza2, i87, zzmp.zza));
                                                                    zza2 = i22;
                                                                    while (zza2 < i2) {
                                                                    }
                                                                } else {
                                                                    throw new zzmr("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                        }
                                                        zzkwVar21 = zzkwVar5;
                                                        i16 = i20;
                                                        i19 = i21;
                                                        bArr6 = bArr5;
                                                        break;
                                                    }
                                                    zzkwVar21 = zzkwVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    zza2 = i19;
                                                    break;
                                                case 27:
                                                    bArr5 = bArr;
                                                    i23 = i49;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar5 = zzkwVar21;
                                                    i20 = i16;
                                                    zzmo zzmoVar11 = zzmoVar2;
                                                    i21 = i39;
                                                    if (i52 == 2) {
                                                        i8 = i23;
                                                        int zzn = zzkx.zzn(zznpVar.zzp(i38), i8, bArr5, i21, i2, zzmoVar11, zzkwVar5);
                                                        bArr5 = bArr5;
                                                        i21 = i21;
                                                        zza2 = zzn;
                                                        zzkwVar21 = zzkwVar5;
                                                        i16 = i20;
                                                        i19 = i21;
                                                        bArr6 = bArr5;
                                                        break;
                                                    }
                                                    i8 = i23;
                                                    zzkwVar21 = zzkwVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    zza2 = i19;
                                                    break;
                                                case 28:
                                                    bArr5 = bArr;
                                                    i23 = i49;
                                                    unsafe4 = unsafe9;
                                                    zzkwVar5 = zzkwVar21;
                                                    i20 = i16;
                                                    zzmo zzmoVar12 = zzmoVar2;
                                                    i21 = i39;
                                                    if (i52 == 2) {
                                                        zza2 = zzkx.zza(bArr5, i21, zzkwVar5);
                                                        int i91 = zzkwVar5.zza;
                                                        if (i91 >= 0) {
                                                            if (i91 > bArr5.length - zza2) {
                                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            if (i91 == 0) {
                                                                zzmoVar12.add(zzlh.zzb);
                                                                while (zza2 < i2) {
                                                                    int zza13 = zzkx.zza(bArr5, zza2, zzkwVar5);
                                                                    if (i23 != zzkwVar5.zza) {
                                                                        i8 = i23;
                                                                        zzkwVar21 = zzkwVar5;
                                                                        i16 = i20;
                                                                        i19 = i21;
                                                                        bArr6 = bArr5;
                                                                        break;
                                                                    } else {
                                                                        zza2 = zzkx.zza(bArr5, zza13, zzkwVar5);
                                                                        i91 = zzkwVar5.zza;
                                                                        if (i91 >= 0) {
                                                                            if (i91 > bArr5.length - zza2) {
                                                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                            }
                                                                            if (i91 == 0) {
                                                                                zzmoVar12.add(zzlh.zzb);
                                                                            } else {
                                                                                zzmoVar12.add(zzlh.zzh(bArr5, zza2, i91));
                                                                                zza2 += i91;
                                                                                while (zza2 < i2) {
                                                                                }
                                                                            }
                                                                        } else {
                                                                            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        }
                                                                    }
                                                                }
                                                                i8 = i23;
                                                                zzkwVar21 = zzkwVar5;
                                                                i16 = i20;
                                                                i19 = i21;
                                                                bArr6 = bArr5;
                                                            } else {
                                                                zzmoVar12.add(zzlh.zzh(bArr5, zza2, i91));
                                                                zza2 += i91;
                                                                while (zza2 < i2) {
                                                                }
                                                                i8 = i23;
                                                                zzkwVar21 = zzkwVar5;
                                                                i16 = i20;
                                                                i19 = i21;
                                                                bArr6 = bArr5;
                                                            }
                                                        } else {
                                                            throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                    }
                                                    i8 = i23;
                                                    zzkwVar21 = zzkwVar5;
                                                    i16 = i20;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    zza2 = i19;
                                                    break;
                                                case 30:
                                                case 44:
                                                    if (i52 != 2) {
                                                        if (i52 != 0) {
                                                            unsafe4 = unsafe9;
                                                            bArr6 = bArr;
                                                            i8 = i49;
                                                            i19 = i39;
                                                            zza2 = i19;
                                                            break;
                                                        } else {
                                                            zzmo zzmoVar13 = zzmoVar2;
                                                            bArr5 = bArr;
                                                            i24 = i49;
                                                            i21 = i39;
                                                            zzkwVar6 = zzkwVar21;
                                                            zzl = zzkx.zzl(i24, bArr5, i21, i2, zzmoVar13, zzkwVar6);
                                                            zzmoVar = zzmoVar13;
                                                        }
                                                    } else {
                                                        bArr5 = bArr;
                                                        zzkwVar6 = zzkwVar21;
                                                        zzl = zzkx.zzm(bArr, i39, zzmoVar2, zzkwVar21);
                                                        i24 = i49;
                                                        zzmoVar = zzmoVar2;
                                                        i21 = i39;
                                                    }
                                                    zzmk zzr2 = zznpVar.zzr(i38);
                                                    zzoi zzoiVar = zznpVar.zzl;
                                                    int i92 = zznz.zza;
                                                    if (zzr2 == null) {
                                                        i25 = zzl;
                                                        unsafe4 = unsafe9;
                                                        i26 = i16;
                                                    } else if (zzmoVar instanceof RandomAccess) {
                                                        int size2 = zzmoVar.size();
                                                        i25 = zzl;
                                                        Object obj9 = null;
                                                        int i93 = 0;
                                                        int i94 = 0;
                                                        while (i93 < size2) {
                                                            Unsafe unsafe10 = unsafe9;
                                                            int intValue = ((Integer) zzmoVar.get(i93)).intValue();
                                                            if (zzr2.zza(intValue)) {
                                                                if (i93 != i94) {
                                                                    zzmoVar.set(i94, Integer.valueOf(intValue));
                                                                }
                                                                i94++;
                                                                i27 = i93;
                                                                i28 = i16;
                                                            } else {
                                                                i27 = i93;
                                                                i28 = i16;
                                                                obj9 = zznz.zzE(obj2, i28, intValue, obj9, zzoiVar);
                                                            }
                                                            i16 = i28;
                                                            i93 = i27 + 1;
                                                            unsafe9 = unsafe10;
                                                        }
                                                        unsafe4 = unsafe9;
                                                        i26 = i16;
                                                        if (i94 != size2) {
                                                            zzmoVar.subList(i94, size2).clear();
                                                        }
                                                    } else {
                                                        i25 = zzl;
                                                        unsafe4 = unsafe9;
                                                        i26 = i16;
                                                        Iterator it = zzmoVar.iterator();
                                                        Object obj10 = null;
                                                        while (it.hasNext()) {
                                                            int intValue2 = ((Integer) it.next()).intValue();
                                                            if (!zzr2.zza(intValue2)) {
                                                                obj10 = zznz.zzE(obj2, i26, intValue2, obj10, zzoiVar);
                                                                it.remove();
                                                            }
                                                        }
                                                    }
                                                    i8 = i24;
                                                    zzkwVar21 = zzkwVar6;
                                                    i16 = i26;
                                                    zza2 = i25;
                                                    i19 = i21;
                                                    bArr6 = bArr5;
                                                    break;
                                                case 33:
                                                case 47:
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            int i95 = zzkx.zza;
                                                            zzmg zzmgVar3 = (zzmg) zzmoVar2;
                                                            zza3 = zzkx.zza(bArr, i39, zzkwVar21);
                                                            zzmgVar3.zzh(zzlj.zzb(zzkwVar21.zza));
                                                            while (zza3 < i2) {
                                                                int zza14 = zzkx.zza(bArr, zza3, zzkwVar21);
                                                                if (i49 == zzkwVar21.zza) {
                                                                    zza3 = zzkx.zza(bArr, zza14, zzkwVar21);
                                                                    zzmgVar3.zzh(zzlj.zzb(zzkwVar21.zza));
                                                                }
                                                            }
                                                        }
                                                        bArr6 = bArr;
                                                        i19 = i39;
                                                        unsafe4 = unsafe9;
                                                        i8 = i49;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        int i96 = zzkx.zza;
                                                        zzmg zzmgVar4 = (zzmg) zzmoVar2;
                                                        zza3 = zzkx.zza(bArr, i39, zzkwVar21);
                                                        int i97 = zzkwVar21.zza + zza3;
                                                        while (zza3 < i97) {
                                                            zza3 = zzkx.zza(bArr, zza3, zzkwVar21);
                                                            zzmgVar4.zzh(zzlj.zzb(zzkwVar21.zza));
                                                        }
                                                        if (zza3 != i97) {
                                                            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    zza2 = zza3;
                                                    bArr6 = bArr;
                                                    i19 = i39;
                                                    unsafe4 = unsafe9;
                                                    i8 = i49;
                                                    break;
                                                case 34:
                                                case 48:
                                                    if (i52 != 2) {
                                                        if (i52 == 0) {
                                                            int i98 = zzkx.zza;
                                                            zzna zznaVar5 = (zzna) zzmoVar2;
                                                            zza3 = zzkx.zzc(bArr, i39, zzkwVar21);
                                                            zznaVar5.zzf(zzlj.zzc(zzkwVar21.zzb));
                                                            while (zza3 < i2) {
                                                                int zza15 = zzkx.zza(bArr, zza3, zzkwVar21);
                                                                if (i49 == zzkwVar21.zza) {
                                                                    zza3 = zzkx.zzc(bArr, zza15, zzkwVar21);
                                                                    zznaVar5.zzf(zzlj.zzc(zzkwVar21.zzb));
                                                                }
                                                            }
                                                        }
                                                        bArr6 = bArr;
                                                        i19 = i39;
                                                        unsafe4 = unsafe9;
                                                        i8 = i49;
                                                        zza2 = i19;
                                                        break;
                                                    } else {
                                                        int i99 = zzkx.zza;
                                                        zzna zznaVar6 = (zzna) zzmoVar2;
                                                        zza3 = zzkx.zza(bArr, i39, zzkwVar21);
                                                        int i100 = zzkwVar21.zza + zza3;
                                                        while (zza3 < i100) {
                                                            zza3 = zzkx.zzc(bArr, zza3, zzkwVar21);
                                                            zznaVar6.zzf(zzlj.zzc(zzkwVar21.zzb));
                                                        }
                                                        if (zza3 != i100) {
                                                            throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                    }
                                                    zza2 = zza3;
                                                    bArr6 = bArr;
                                                    i19 = i39;
                                                    unsafe4 = unsafe9;
                                                    i8 = i49;
                                                    break;
                                                default:
                                                    bArr5 = bArr;
                                                    unsafe4 = unsafe9;
                                                    int i101 = i2;
                                                    zzkwVar4 = zzkwVar21;
                                                    i8 = i49;
                                                    zzmo zzmoVar14 = zzmoVar2;
                                                    i17 = i39;
                                                    if (i52 == 3) {
                                                        int i102 = (i8 & (-8)) | 4;
                                                        zznx zzp = zznpVar.zzp(i38);
                                                        int zzi = zzkx.zzi(zzp, bArr5, i17, i101, i102, zzkwVar4);
                                                        i19 = i17;
                                                        zzmoVar14.add(zzkwVar4.zzc);
                                                        while (zzi < i101) {
                                                            int zza16 = zzkx.zza(bArr5, zzi, zzkwVar4);
                                                            if (i8 != zzkwVar4.zza) {
                                                                bArr6 = bArr5;
                                                                zzkwVar21 = zzkwVar4;
                                                                zza2 = zzi;
                                                                break;
                                                            } else {
                                                                zzi = zzkx.zzi(zzp, bArr5, zza16, i101, i102, zzkwVar4);
                                                                zzmoVar14.add(zzkwVar4.zzc);
                                                                i101 = i2;
                                                                bArr5 = bArr5;
                                                            }
                                                        }
                                                        bArr6 = bArr5;
                                                        zzkwVar21 = zzkwVar4;
                                                        zza2 = zzi;
                                                    }
                                                    i19 = i17;
                                                    zzkwVar21 = zzkwVar4;
                                                    bArr6 = bArr5;
                                                    zza2 = i19;
                                                    break;
                                            }
                                            if (zza2 != i19) {
                                                i37 = i2;
                                                bArr9 = bArr6;
                                                i39 = zza2;
                                                obj8 = obj2;
                                                i40 = i38;
                                                i41 = i8;
                                                zzkwVar10 = zzkwVar21;
                                                i44 = i6;
                                                i42 = i7;
                                                i43 = i16;
                                                unsafe5 = unsafe4;
                                            } else {
                                                i4 = i3;
                                                bArr2 = bArr6;
                                                i39 = zza2;
                                                zzkwVar2 = zzkwVar21;
                                                i9 = i16;
                                                unsafe = unsafe4;
                                            }
                                        } else {
                                            i29 = i39;
                                            i8 = i49;
                                            bArr7 = bArr;
                                            if (zzz != 50) {
                                                unsafe = unsafe9;
                                                long j3 = iArr[i38 + 2] & 1048575;
                                                switch (zzz) {
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                        bArr2 = bArr;
                                                        i30 = i38;
                                                        str = str;
                                                        i31 = i8;
                                                        i32 = i29;
                                                        i9 = i16;
                                                        zzkwVar2 = zzkwVar;
                                                        if (i52 == 1) {
                                                            i33 = i32 + 8;
                                                            unsafe.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(zzkx.zze(bArr2, i32))));
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
                                                        zzkwVar2 = zzkwVar;
                                                        if (i52 == 5) {
                                                            i33 = i32 + 4;
                                                            unsafe.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(zzkx.zzd(bArr2, i32))));
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
                                                        zzkwVar2 = zzkwVar;
                                                        if (i52 == 0) {
                                                            i33 = zzkx.zzc(bArr2, i32, zzkwVar2);
                                                            unsafe.putObject(obj2, j, Long.valueOf(zzkwVar2.zzb));
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
                                                        zzkwVar2 = zzkwVar;
                                                        if (i52 == 0) {
                                                            i33 = zzkx.zza(bArr2, i32, zzkwVar2);
                                                            unsafe.putObject(obj2, j, Integer.valueOf(zzkwVar2.zza));
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
                                                        zzkwVar2 = zzkwVar;
                                                        if (i52 == 1) {
                                                            i33 = i32 + 8;
                                                            unsafe.putObject(obj2, j, Long.valueOf(zzkx.zze(bArr2, i32)));
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
                                                        zzkwVar2 = zzkwVar;
                                                        if (i52 == 5) {
                                                            i33 = i32 + 4;
                                                            unsafe.putObject(obj2, j, Integer.valueOf(zzkx.zzd(bArr2, i32)));
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
                                                        zzkwVar2 = zzkwVar;
                                                        if (i52 == 0) {
                                                            i33 = zzkx.zzc(bArr2, i32, zzkwVar2);
                                                            i31 = i8;
                                                            unsafe.putObject(obj2, j, Boolean.valueOf(zzkwVar2.zzb != 0));
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
                                                        zzkwVar2 = zzkwVar;
                                                        if (i52 == 2) {
                                                            int zza17 = zzkx.zza(bArr2, i32, zzkwVar2);
                                                            int i103 = zzkwVar2.zza;
                                                            if (i103 == 0) {
                                                                unsafe.putObject(obj2, j, "");
                                                            } else {
                                                                int i104 = zza17 + i103;
                                                                if ((i54 & C.BUFFER_FLAG_LAST_SAMPLE) == 0 || zzos.zza(bArr2, zza17, i104)) {
                                                                    unsafe.putObject(obj2, j, new String(bArr2, zza17, i103, zzmp.zza));
                                                                    zza17 = i104;
                                                                } else {
                                                                    throw new zzmr("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = zza17;
                                                            i31 = i8;
                                                            break;
                                                        }
                                                        i31 = i8;
                                                        i39 = i32;
                                                        break;
                                                    case 60:
                                                        bArr8 = bArr;
                                                        zzkwVar7 = zzkwVar;
                                                        str = str;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        if (i52 == 2) {
                                                            Object zzu = zznpVar.zzu(obj2, i9, i38);
                                                            int zzj2 = zzkx.zzj(zzu, zznpVar.zzp(i38), bArr8, i34, i2, zzkwVar7);
                                                            zzkwVar2 = zzkwVar7;
                                                            bArr2 = bArr8;
                                                            zznpVar.zzv(obj2, i9, i38, zzu);
                                                            i30 = i38;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            i39 = zzj2;
                                                            break;
                                                        }
                                                        zzkwVar2 = zzkwVar7;
                                                        bArr2 = bArr8;
                                                        i30 = i38;
                                                        i31 = i8;
                                                        i32 = i34;
                                                        i39 = i32;
                                                        break;
                                                    case 61:
                                                        bArr8 = bArr;
                                                        zzkwVar7 = zzkwVar;
                                                        str = str;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        if (i52 == 2) {
                                                            zzg = zzkx.zzg(bArr8, i34, zzkwVar7);
                                                            unsafe.putObject(obj2, j, zzkwVar7.zzc);
                                                            unsafe.putInt(obj2, j3, i9);
                                                            i39 = zzg;
                                                            zzkwVar2 = zzkwVar7;
                                                            bArr2 = bArr8;
                                                            i30 = i38;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            break;
                                                        }
                                                        zzkwVar2 = zzkwVar7;
                                                        bArr2 = bArr8;
                                                        i30 = i38;
                                                        i31 = i8;
                                                        i32 = i34;
                                                        i39 = i32;
                                                        break;
                                                    case 63:
                                                        bArr8 = bArr;
                                                        zzkwVar7 = zzkwVar;
                                                        str = str;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        i35 = i8;
                                                        if (i52 == 0) {
                                                            zzg = zzkx.zza(bArr8, i34, zzkwVar7);
                                                            int i105 = zzkwVar7.zza;
                                                            zzmk zzr3 = zznpVar.zzr(i38);
                                                            if (zzr3 == null || zzr3.zza(i105)) {
                                                                i8 = i35;
                                                                unsafe.putObject(obj2, j, Integer.valueOf(i105));
                                                                unsafe.putInt(obj2, j3, i9);
                                                            } else {
                                                                i8 = i35;
                                                                zzg(obj2).zzk(i8, Long.valueOf(i105));
                                                            }
                                                            i39 = zzg;
                                                            zzkwVar2 = zzkwVar7;
                                                            bArr2 = bArr8;
                                                            i30 = i38;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            break;
                                                        }
                                                        int i106 = i35;
                                                        zzkwVar2 = zzkwVar7;
                                                        bArr2 = bArr8;
                                                        i31 = i106;
                                                        i30 = i38;
                                                        i32 = i34;
                                                        i39 = i32;
                                                        break;
                                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                        bArr8 = bArr;
                                                        zzkwVar7 = zzkwVar;
                                                        str = str;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        i35 = i8;
                                                        if (i52 == 0) {
                                                            zza4 = zzkx.zza(bArr8, i34, zzkwVar7);
                                                            unsafe.putObject(obj2, j, Integer.valueOf(zzlj.zzb(zzkwVar7.zza)));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            int i107 = i35;
                                                            zzkwVar2 = zzkwVar7;
                                                            bArr2 = bArr8;
                                                            i31 = i107;
                                                            i39 = zza4;
                                                            i30 = i38;
                                                            i32 = i34;
                                                            break;
                                                        }
                                                        int i1062 = i35;
                                                        zzkwVar2 = zzkwVar7;
                                                        bArr2 = bArr8;
                                                        i31 = i1062;
                                                        i30 = i38;
                                                        i32 = i34;
                                                        i39 = i32;
                                                        break;
                                                    case 67:
                                                        bArr8 = bArr;
                                                        zzkwVar7 = zzkwVar;
                                                        i34 = i29;
                                                        i9 = i16;
                                                        if (i52 != 0) {
                                                            str = str;
                                                            zzkwVar2 = zzkwVar7;
                                                            bArr2 = bArr8;
                                                            i30 = i38;
                                                            i31 = i8;
                                                            i32 = i34;
                                                            i39 = i32;
                                                            break;
                                                        } else {
                                                            zza4 = zzkx.zzc(bArr8, i34, zzkwVar7);
                                                            str = str;
                                                            i35 = i8;
                                                            unsafe.putObject(obj2, j, Long.valueOf(zzlj.zzc(zzkwVar7.zzb)));
                                                            unsafe.putInt(obj2, j3, i9);
                                                            int i1072 = i35;
                                                            zzkwVar2 = zzkwVar7;
                                                            bArr2 = bArr8;
                                                            i31 = i1072;
                                                            i39 = zza4;
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
                                                            zzkwVar2 = zzkwVar;
                                                            i39 = i32;
                                                            break;
                                                        } else {
                                                            i9 = i16;
                                                            Object zzu2 = zznpVar.zzu(obj2, i9, i38);
                                                            int zzk2 = zzkx.zzk(zzu2, zznpVar.zzp(i38), bArr, i29, i2, (i8 & (-8)) | 4, zzkwVar);
                                                            i34 = i29;
                                                            zznpVar.zzv(obj2, i9, i38, zzu2);
                                                            i39 = zzk2;
                                                            zzkwVar2 = zzkwVar;
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
                                                        zzkwVar2 = zzkwVar;
                                                        i39 = i32;
                                                        break;
                                                }
                                                if (i39 != i32) {
                                                    int i108 = i31;
                                                    bArr9 = bArr2;
                                                    i41 = i108;
                                                    unsafe5 = unsafe;
                                                    obj8 = obj2;
                                                    zzkwVar10 = zzkwVar2;
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
                                                Object zzq = zznpVar.zzq(i38);
                                                unsafe = unsafe9;
                                                Object object = unsafe.getObject(obj2, j);
                                                if (!((zzng) object).zze()) {
                                                    zzng zzc3 = zzng.zza().zzc();
                                                    zznh.zza(zzc3, object);
                                                    unsafe.putObject(obj2, j, zzc3);
                                                    object = zzc3;
                                                }
                                                zzne zze = ((zznf) zzq).zze();
                                                zzng zzngVar = (zzng) object;
                                                int zza18 = zzkx.zza(bArr7, i29, zzkwVar21);
                                                int i109 = zzkwVar21.zza;
                                                if (i109 >= 0 && i109 <= i2 - zza18) {
                                                    int i110 = zza18 + i109;
                                                    Object obj11 = zze.zzb;
                                                    Object obj12 = zze.zzd;
                                                    Object obj13 = obj12;
                                                    while (zza18 < i110) {
                                                        int i111 = zza18 + 1;
                                                        int i112 = bArr7[zza18];
                                                        if (i112 < 0) {
                                                            i111 = zzkx.zzb(i112, bArr7, i111, zzkwVar21);
                                                            i112 = zzkwVar21.zza;
                                                        }
                                                        Object obj14 = obj11;
                                                        int i113 = i112 >>> 3;
                                                        int i114 = i112 & 7;
                                                        Object obj15 = obj12;
                                                        if (i113 == 1) {
                                                            int i115 = i111;
                                                            zzkw zzkwVar22 = zzkwVar21;
                                                            obj6 = obj14;
                                                            zzot zzotVar = zze.zza;
                                                            if (i114 == zzotVar.zzb()) {
                                                                int zzO = zzO(bArr, i115, i2, zzotVar, null, zzkwVar22);
                                                                bArr7 = bArr;
                                                                obj11 = zzkwVar22.zzc;
                                                                zza18 = zzO;
                                                                zzkwVar21 = zzkwVar22;
                                                                obj13 = obj13;
                                                                obj12 = obj15;
                                                            } else {
                                                                bArr7 = bArr;
                                                                i36 = i2;
                                                                obj7 = obj13;
                                                                zzkwVar9 = zzkwVar22;
                                                                i111 = i115;
                                                            }
                                                        } else if (i113 != 2) {
                                                            bArr7 = bArr;
                                                            i36 = i2;
                                                            obj7 = obj13;
                                                            zzkwVar9 = zzkwVar21;
                                                            obj6 = obj14;
                                                        } else {
                                                            zzot zzotVar2 = zze.zzc;
                                                            if (i114 == zzotVar2.zzb()) {
                                                                int i116 = i111;
                                                                zzkw zzkwVar23 = zzkwVar21;
                                                                int zzO2 = zzO(bArr, i116, i2, zzotVar2, obj15.getClass(), zzkwVar23);
                                                                obj13 = zzkwVar23.zzc;
                                                                bArr7 = bArr;
                                                                zza18 = zzO2;
                                                                obj11 = obj14;
                                                                obj12 = obj15;
                                                                zzkwVar21 = zzkwVar23;
                                                            } else {
                                                                int i117 = i111;
                                                                zzkw zzkwVar24 = zzkwVar21;
                                                                obj6 = obj14;
                                                                i111 = i117;
                                                                obj7 = obj13;
                                                                zzkwVar9 = zzkwVar24;
                                                                bArr7 = bArr;
                                                                i36 = i2;
                                                            }
                                                        }
                                                        zza18 = zzkx.zzp(i112, bArr7, i111, i36, zzkwVar9);
                                                        zzkw zzkwVar25 = zzkwVar9;
                                                        obj13 = obj7;
                                                        obj11 = obj6;
                                                        zzkwVar21 = zzkwVar25;
                                                        obj12 = obj15;
                                                    }
                                                    zzkw zzkwVar26 = zzkwVar21;
                                                    Object obj16 = obj11;
                                                    Object obj17 = obj13;
                                                    if (zza18 == i110) {
                                                        zzngVar.put(obj16, obj17);
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
                                                            zzkwVar10 = zzkwVar26;
                                                            i40 = i38;
                                                            i43 = i16;
                                                            i38 = 0;
                                                        } else {
                                                            i4 = i3;
                                                            bArr2 = bArr7;
                                                            zzkwVar2 = zzkwVar26;
                                                            i39 = i110;
                                                            i9 = i16;
                                                        }
                                                    } else {
                                                        throw new zzmr(str);
                                                    }
                                                }
                                            } else {
                                                zzkwVar8 = zzkwVar21;
                                                unsafe = unsafe9;
                                            }
                                        }
                                    } else if (i52 == 2) {
                                        zzmo zzmoVar15 = (zzmo) unsafe8.getObject(obj2, j);
                                        if (!zzmoVar15.zza()) {
                                            int size3 = zzmoVar15.size();
                                            zzmoVar15 = zzmoVar15.zzg(size3 == 0 ? 10 : size3 + size3);
                                            unsafe8.putObject(obj2, j, zzmoVar15);
                                        }
                                        int zzn2 = zzkx.zzn(zznpVar.zzp(i38), i49, bArr, i39, i2, zzmoVar15, zzkwVar);
                                        bArr9 = bArr;
                                        i37 = i2;
                                        i41 = i49;
                                        obj8 = obj2;
                                        i40 = i38;
                                        i43 = i50;
                                        i38 = 0;
                                        i45 = 1048575;
                                        zzkwVar10 = zzkwVar;
                                        i39 = zzn2;
                                        unsafe5 = unsafe8;
                                    } else {
                                        i6 = i44;
                                        i29 = i39;
                                        zzkwVar8 = zzkwVar;
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
                                    zzkwVar2 = zzkwVar8;
                                }
                            }
                            if (i8 == i4 || i4 == 0) {
                                if (zznpVar.zzh) {
                                    zzlr zzlrVar = zzkwVar2.zzd;
                                    int i118 = zzlr.zzb;
                                    int i119 = zznu.zza;
                                    if (zzlrVar != zzlr.zza) {
                                        zznm zznmVar = zznpVar.zzg;
                                        int i120 = zzkx.zza;
                                        if (zzlrVar.zzb(zznmVar, i9) == null) {
                                            i10 = i2;
                                            i39 = zzkx.zzo(i8, bArr2, i39, i10, zzg(obj2), zzkwVar2);
                                            bArr9 = bArr;
                                            unsafe5 = unsafe;
                                            obj8 = obj2;
                                            i40 = i38;
                                            i41 = i8;
                                            i44 = i6;
                                            i38 = 0;
                                            i45 = 1048575;
                                            zzkwVar10 = zzkwVar;
                                            i37 = i10;
                                            i43 = i9;
                                            i42 = i7;
                                        } else {
                                            zzmc zzmcVar = (zzmc) obj2;
                                            throw null;
                                        }
                                    }
                                }
                                i10 = i2;
                                i39 = zzkx.zzo(i8, bArr, i39, i10, zzg(obj2), zzkwVar);
                                bArr9 = bArr;
                                unsafe5 = unsafe;
                                obj8 = obj2;
                                i40 = i38;
                                i41 = i8;
                                i44 = i6;
                                i38 = 0;
                                i45 = 1048575;
                                zzkwVar10 = zzkwVar;
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
                        zzN = -1;
                        if (zzN != -1) {
                        }
                        if (i8 == i4) {
                        }
                        if (zznpVar.zzh) {
                        }
                        i10 = i2;
                        i39 = zzkx.zzo(i8, bArr, i39, i10, zzg(obj2), zzkwVar);
                        bArr9 = bArr;
                        unsafe5 = unsafe;
                        obj8 = obj2;
                        i40 = i38;
                        i41 = i8;
                        i44 = i6;
                        i38 = 0;
                        i45 = 1048575;
                        zzkwVar10 = zzkwVar;
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

    @Override // com.google.android.gms.internal.measurement.zznx
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkw zzkwVar) throws IOException {
        zzh(obj, bArr, i, i2, 0, zzkwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final void zzj(Object obj) {
        if (zzA(obj)) {
            if (obj instanceof zzmf) {
                zzmf zzmfVar = (zzmf) obj;
                zzmfVar.zzcm(Integer.MAX_VALUE);
                zzmfVar.zza = 0;
                zzmfVar.zzcg();
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
                            case 49:
                                ((zzmo) zzop.zzn(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzng) object).zzd();
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

    @Override // com.google.android.gms.internal.measurement.zznx
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
                            zzng zzngVar = (zzng) zzop.zzn(obj, zzx & 1048575);
                            if (!zzngVar.isEmpty() && ((zznf) zzq(i2)).zze().zzc.zza() == zzou.MESSAGE) {
                                zznx zznxVar = null;
                                for (Object obj2 : zzngVar.values()) {
                                    if (zznxVar == null) {
                                        zznxVar = zznu.zza().zzb(obj2.getClass());
                                    }
                                    if (!zznxVar.zzk(obj2)) {
                                        return false;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                }
                List list = (List) zzop.zzn(obj, zzx & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zznx zzp = zzp(i2);
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
        return !this.zzh || ((zzmc) obj).zzb.zze();
    }
}
