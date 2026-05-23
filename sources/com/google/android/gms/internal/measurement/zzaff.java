package com.google.android.gms.internal.measurement;

import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaff<T> implements zzafp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzagg.zzp();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzafc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzafz zzm;
    private final zzadg zzn;

    private zzaff(int[] iArr, Object[] objArr, int i, int i2, zzafc zzafcVar, boolean z, int[] iArr2, int i3, int i4, zzafh zzafhVar, zzaeo zzaeoVar, zzafz zzafzVar, zzadg zzadgVar, zzaex zzaexVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzafcVar instanceof zzadu;
        boolean z2 = false;
        if (zzadgVar != null && (zzafcVar instanceof zzadr)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzafzVar;
        this.zzn = zzadgVar;
        this.zzg = zzafcVar;
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static int zzC(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzD(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean zzE(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzadu) {
            return ((zzadu) obj).zzch();
        }
        return true;
    }

    private static void zzF(Object obj) {
        if (zzE(obj)) {
            return;
        }
        String valueOf = String.valueOf(obj);
        String.valueOf(valueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(valueOf)));
    }

    private static int zzG(Object obj, long j) {
        return ((Integer) zzagg.zzm(obj, j)).intValue();
    }

    private static long zzH(Object obj, long j) {
        return ((Long) zzagg.zzm(obj, j)).longValue();
    }

    private final boolean zzI(Object obj, Object obj2, int i) {
        return zzK(obj, i) == zzK(obj2, i);
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzK(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzK(Object obj, int i) {
        int zzB = zzB(i);
        long j = zzB & 1048575;
        if (j != 1048575) {
            return ((1 << (zzB >>> 20)) & zzagg.zzc(obj, j)) != 0;
        }
        int zzA = zzA(i);
        long j2 = zzA & 1048575;
        switch (zzC(zzA)) {
            case 0:
                return Double.doubleToRawLongBits(zzagg.zzk(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzagg.zzi(obj, j2)) != 0;
            case 2:
                return zzagg.zze(obj, j2) != 0;
            case 3:
                return zzagg.zze(obj, j2) != 0;
            case 4:
                return zzagg.zzc(obj, j2) != 0;
            case 5:
                return zzagg.zze(obj, j2) != 0;
            case 6:
                return zzagg.zzc(obj, j2) != 0;
            case 7:
                return zzagg.zzg(obj, j2);
            case 8:
                Object zzm = zzagg.zzm(obj, j2);
                if (zzm instanceof String) {
                    return !((String) zzm).isEmpty();
                } else if (zzm instanceof zzacr) {
                    return !zzacr.zza.equals(zzm);
                } else {
                    return zzR();
                }
            case 9:
                return zzagg.zzm(obj, j2) != null;
            case 10:
                return !zzacr.zza.equals(zzagg.zzm(obj, j2));
            case 11:
                return zzagg.zzc(obj, j2) != 0;
            case 12:
                return zzagg.zzc(obj, j2) != 0;
            case 13:
                return zzagg.zzc(obj, j2) != 0;
            case 14:
                return zzagg.zze(obj, j2) != 0;
            case 15:
                return zzagg.zzc(obj, j2) != 0;
            case 16:
                return zzagg.zze(obj, j2) != 0;
            case 17:
                return zzagg.zzm(obj, j2) != null;
            default:
                return zzR();
        }
    }

    private final void zzL(Object obj, int i) {
        int zzB = zzB(i);
        long j = 1048575 & zzB;
        if (j == 1048575) {
            return;
        }
        zzagg.zzd(obj, j, (1 << (zzB >>> 20)) | zzagg.zzc(obj, j));
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzagg.zzc(obj, (long) (zzB(i2) & 1048575)) == i;
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        long zzB = zzB(i) & 1048575;
        return zzagg.zzc(obj, zzB) == zzagg.zzc(obj2, zzB);
    }

    private final void zzO(Object obj, int i, int i2) {
        zzagg.zzd(obj, zzB(i2) & 1048575, i);
    }

    private final int zzP(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzQ(i, 0);
    }

    private final int zzQ(int i, int i2) {
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

    private boolean zzR() {
        throw new IllegalArgumentException();
    }

    private static final int zzS(byte[] bArr, int i, int i2, zzagm zzagmVar, Class cls, zzacg zzacgVar) throws IOException {
        zzagm zzagmVar2 = zzagm.DOUBLE;
        switch (zzagmVar.ordinal()) {
            case 0:
                int i3 = i + 8;
                zzacgVar.zzc = Double.valueOf(Double.longBitsToDouble(zzach.zze(bArr, i)));
                return i3;
            case 1:
                int i4 = i + 4;
                zzacgVar.zzc = Float.valueOf(Float.intBitsToFloat(zzach.zzd(bArr, i)));
                return i4;
            case 2:
            case 3:
                int zzc = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Long.valueOf(zzacgVar.zzb);
                return zzc;
            case 4:
            case 12:
            case 13:
                int zza2 = zzach.zza(bArr, i, zzacgVar);
                zzacgVar.zzc = Integer.valueOf(zzacgVar.zza);
                return zza2;
            case 5:
            case 15:
                int i5 = i + 8;
                zzacgVar.zzc = Long.valueOf(zzach.zze(bArr, i));
                return i5;
            case 6:
            case 14:
                int i6 = i + 4;
                zzacgVar.zzc = Integer.valueOf(zzach.zzd(bArr, i));
                return i6;
            case 7:
                int zzc2 = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Boolean.valueOf(zzacgVar.zzb != 0);
                return zzc2;
            case 8:
                return zzach.zzf(bArr, i, zzacgVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return zzach.zzh(zzafl.zza().zzb(cls), bArr, i, i2, zzacgVar);
            case 11:
                return zzach.zzg(bArr, i, zzacgVar);
            case 16:
                int zza3 = zzach.zza(bArr, i, zzacgVar);
                zzacgVar.zzc = Integer.valueOf(zzacv.zzR(zzacgVar.zza));
                return zza3;
            case 17:
                int zzc3 = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Long.valueOf(zzacv.zzS(zzacgVar.zzb));
                return zzc3;
        }
    }

    private static final void zzT(int i, Object obj, zzago zzagoVar) throws IOException {
        if (obj instanceof String) {
            zzagoVar.zzm(i, (String) obj);
        } else {
            zzagoVar.zzn(i, (zzacr) obj);
        }
    }

    static zzaga zzh(Object obj) {
        zzadu zzaduVar = (zzadu) obj;
        zzaga zzagaVar = zzaduVar.zzc;
        if (zzagaVar == zzaga.zza()) {
            zzaga zzb2 = zzaga.zzb();
            zzaduVar.zzc = zzb2;
            return zzb2;
        }
        return zzagaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzaff zzm(Class cls, zzaez zzaezVar, zzafh zzafhVar, zzaeo zzaeoVar, zzafz zzafzVar, zzadg zzadgVar, zzaex zzaexVar) {
        int i;
        int charAt;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        char charAt2;
        int i9;
        int i10;
        char charAt3;
        int i11;
        char charAt4;
        int i12;
        char charAt5;
        int i13;
        char charAt6;
        int i14;
        char charAt7;
        int i15;
        char charAt8;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        String str;
        int objectFieldOffset;
        int i21;
        char c;
        int i22;
        int i23;
        int i24;
        int i25;
        Field zzn;
        int objectFieldOffset2;
        int i26;
        char charAt9;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Object obj;
        Field zzn2;
        Object obj2;
        Field zzn3;
        int i32;
        char charAt10;
        int i33;
        char charAt11;
        int i34;
        char charAt12;
        int i35;
        char charAt13;
        if (zzaezVar instanceof zzafn) {
            zzafn zzafnVar = (zzafn) zzaezVar;
            String zzd = zzafnVar.zzd();
            int length = zzd.length();
            char c2 = 55296;
            if (zzd.charAt(0) >= 55296) {
                int i36 = 1;
                while (true) {
                    i = i36 + 1;
                    if (zzd.charAt(i36) < 55296) {
                        break;
                    }
                    i36 = i;
                }
            } else {
                i = 1;
            }
            int i37 = i + 1;
            int charAt14 = zzd.charAt(i);
            if (charAt14 >= 55296) {
                int i38 = charAt14 & 8191;
                int i39 = 13;
                while (true) {
                    i35 = i37 + 1;
                    charAt13 = zzd.charAt(i37);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i38 |= (charAt13 & 8191) << i39;
                    i39 += 13;
                    i37 = i35;
                }
                charAt14 = i38 | (charAt13 << i39);
                i37 = i35;
            }
            if (charAt14 == 0) {
                i6 = 0;
                i4 = 0;
                charAt = 0;
                i5 = 0;
                i3 = 0;
                i7 = 0;
                iArr = zza;
                i2 = 0;
            } else {
                int i40 = i37 + 1;
                int charAt15 = zzd.charAt(i37);
                if (charAt15 >= 55296) {
                    int i41 = charAt15 & 8191;
                    int i42 = 13;
                    while (true) {
                        i15 = i40 + 1;
                        charAt8 = zzd.charAt(i40);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i41 |= (charAt8 & 8191) << i42;
                        i42 += 13;
                        i40 = i15;
                    }
                    charAt15 = i41 | (charAt8 << i42);
                    i40 = i15;
                }
                int i43 = i40 + 1;
                int charAt16 = zzd.charAt(i40);
                if (charAt16 >= 55296) {
                    int i44 = charAt16 & 8191;
                    int i45 = 13;
                    while (true) {
                        i14 = i43 + 1;
                        charAt7 = zzd.charAt(i43);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i44 |= (charAt7 & 8191) << i45;
                        i45 += 13;
                        i43 = i14;
                    }
                    charAt16 = i44 | (charAt7 << i45);
                    i43 = i14;
                }
                int i46 = i43 + 1;
                int charAt17 = zzd.charAt(i43);
                if (charAt17 >= 55296) {
                    int i47 = charAt17 & 8191;
                    int i48 = 13;
                    while (true) {
                        i13 = i46 + 1;
                        charAt6 = zzd.charAt(i46);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i47 |= (charAt6 & 8191) << i48;
                        i48 += 13;
                        i46 = i13;
                    }
                    charAt17 = i47 | (charAt6 << i48);
                    i46 = i13;
                }
                int i49 = i46 + 1;
                int charAt18 = zzd.charAt(i46);
                if (charAt18 >= 55296) {
                    int i50 = charAt18 & 8191;
                    int i51 = 13;
                    while (true) {
                        i12 = i49 + 1;
                        charAt5 = zzd.charAt(i49);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i50 |= (charAt5 & 8191) << i51;
                        i51 += 13;
                        i49 = i12;
                    }
                    charAt18 = i50 | (charAt5 << i51);
                    i49 = i12;
                }
                int i52 = i49 + 1;
                charAt = zzd.charAt(i49);
                if (charAt >= 55296) {
                    int i53 = charAt & 8191;
                    int i54 = 13;
                    while (true) {
                        i11 = i52 + 1;
                        charAt4 = zzd.charAt(i52);
                        if (charAt4 < 55296) {
                            break;
                        }
                        i53 |= (charAt4 & 8191) << i54;
                        i54 += 13;
                        i52 = i11;
                    }
                    charAt = i53 | (charAt4 << i54);
                    i52 = i11;
                }
                int i55 = i52 + 1;
                int charAt19 = zzd.charAt(i52);
                if (charAt19 >= 55296) {
                    int i56 = charAt19 & 8191;
                    int i57 = 13;
                    while (true) {
                        i10 = i55 + 1;
                        charAt3 = zzd.charAt(i55);
                        if (charAt3 < 55296) {
                            break;
                        }
                        i56 |= (charAt3 & 8191) << i57;
                        i57 += 13;
                        i55 = i10;
                    }
                    charAt19 = i56 | (charAt3 << i57);
                    i55 = i10;
                }
                int i58 = i55 + 1;
                if (zzd.charAt(i55) >= 55296) {
                    while (true) {
                        i9 = i58 + 1;
                        if (zzd.charAt(i58) < 55296) {
                            break;
                        }
                        i58 = i9;
                    }
                    i58 = i9;
                }
                int i59 = i58 + 1;
                int charAt20 = zzd.charAt(i58);
                if (charAt20 >= 55296) {
                    int i60 = charAt20 & 8191;
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
                    charAt20 = i60 | (charAt2 << i61);
                    i59 = i8;
                }
                int i62 = charAt15 + charAt15 + charAt16;
                i2 = charAt15;
                i37 = i59;
                i3 = charAt18;
                i4 = i62;
                iArr = new int[charAt20 + charAt19 + charAt15];
                int i63 = charAt19;
                i5 = charAt17;
                i6 = i63;
                i7 = charAt20;
            }
            Unsafe unsafe = zzb;
            Object[] zze = zzafnVar.zze();
            Class<?> cls2 = zzafnVar.zzb().getClass();
            int i64 = i7 + i6;
            int i65 = charAt + charAt;
            int[] iArr2 = new int[charAt * 3];
            Object[] objArr = new Object[i65];
            int i66 = i7;
            int i67 = i64;
            int i68 = 0;
            int i69 = 0;
            while (i37 < length) {
                int i70 = i37 + 1;
                int charAt21 = zzd.charAt(i37);
                if (charAt21 >= c2) {
                    int i71 = charAt21 & 8191;
                    int i72 = i70;
                    int i73 = 13;
                    while (true) {
                        i34 = i72 + 1;
                        charAt12 = zzd.charAt(i72);
                        if (charAt12 < c2) {
                            break;
                        }
                        i71 |= (charAt12 & 8191) << i73;
                        i73 += 13;
                        i72 = i34;
                    }
                    charAt21 = i71 | (charAt12 << i73);
                    i16 = i34;
                } else {
                    i16 = i70;
                }
                int i74 = i16 + 1;
                int charAt22 = zzd.charAt(i16);
                if (charAt22 >= c2) {
                    int i75 = charAt22 & 8191;
                    int i76 = i74;
                    int i77 = 13;
                    while (true) {
                        i33 = i76 + 1;
                        charAt11 = zzd.charAt(i76);
                        if (charAt11 < c2) {
                            break;
                        }
                        i75 |= (charAt11 & 8191) << i77;
                        i77 += 13;
                        i76 = i33;
                    }
                    charAt22 = i75 | (charAt11 << i77);
                    i17 = i33;
                } else {
                    i17 = i74;
                }
                if ((charAt22 & 1024) != 0) {
                    iArr[i68] = i69;
                    i68++;
                }
                int i78 = charAt22 & 255;
                zzafn zzafnVar2 = zzafnVar;
                int i79 = charAt22 & 2048;
                if (i78 >= 51) {
                    int i80 = i17 + 1;
                    int charAt23 = zzd.charAt(i17);
                    char c3 = 55296;
                    if (charAt23 >= 55296) {
                        int i81 = charAt23 & 8191;
                        int i82 = i80;
                        int i83 = 13;
                        while (true) {
                            i32 = i82 + 1;
                            charAt10 = zzd.charAt(i82);
                            if (charAt10 < c3) {
                                break;
                            }
                            i81 |= (charAt10 & 8191) << i83;
                            i83 += 13;
                            i82 = i32;
                            c3 = 55296;
                        }
                        charAt23 = i81 | (charAt10 << i83);
                        i29 = i32;
                    } else {
                        i29 = i80;
                    }
                    i22 = i29;
                    int i84 = i78 - 51;
                    i18 = length;
                    if (i84 == 9 || i84 == 17) {
                        i30 = i4 + 1;
                        int i85 = i69 / 3;
                        objArr[i85 + i85 + 1] = zze[i4];
                    } else {
                        if (i84 == 12) {
                            if (zzafnVar2.zzc() == 1 || i79 != 0) {
                                i30 = i4 + 1;
                                int i86 = i69 / 3;
                                objArr[i86 + i86 + 1] = zze[i4];
                            } else {
                                i31 = 0;
                                int i87 = charAt23 + charAt23;
                                obj = zze[i87];
                                i79 = i31;
                                if (obj instanceof Field) {
                                    zzn2 = (Field) obj;
                                } else {
                                    zzn2 = zzn(cls2, (String) obj);
                                    zze[i87] = zzn2;
                                    iArr[i67] = i69;
                                    i67++;
                                }
                                int i88 = i2;
                                int objectFieldOffset3 = (int) unsafe.objectFieldOffset(zzn2);
                                int i89 = i87 + 1;
                                obj2 = zze[i89];
                                i19 = i88;
                                if (obj2 instanceof Field) {
                                    zzn3 = (Field) obj2;
                                } else {
                                    zzn3 = zzn(cls2, (String) obj2);
                                    zze[i89] = zzn3;
                                }
                                objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzn3);
                                str = zzd;
                                i24 = objectFieldOffset3;
                                i25 = 0;
                                c = 55296;
                            }
                        }
                        i31 = i79;
                        int i872 = charAt23 + charAt23;
                        obj = zze[i872];
                        i79 = i31;
                        if (obj instanceof Field) {
                        }
                        int i882 = i2;
                        int objectFieldOffset32 = (int) unsafe.objectFieldOffset(zzn2);
                        int i892 = i872 + 1;
                        obj2 = zze[i892];
                        i19 = i882;
                        if (obj2 instanceof Field) {
                        }
                        objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzn3);
                        str = zzd;
                        i24 = objectFieldOffset32;
                        i25 = 0;
                        c = 55296;
                    }
                    i4 = i30;
                    i31 = i79;
                    int i8722 = charAt23 + charAt23;
                    obj = zze[i8722];
                    i79 = i31;
                    if (obj instanceof Field) {
                    }
                    int i8822 = i2;
                    int objectFieldOffset322 = (int) unsafe.objectFieldOffset(zzn2);
                    int i8922 = i8722 + 1;
                    obj2 = zze[i8922];
                    i19 = i8822;
                    if (obj2 instanceof Field) {
                    }
                    objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzn3);
                    str = zzd;
                    i24 = objectFieldOffset322;
                    i25 = 0;
                    c = 55296;
                } else {
                    i18 = length;
                    i19 = i2;
                    int i90 = i4 + 1;
                    Field zzn4 = zzn(cls2, (String) zze[i4]);
                    if (i78 == 9 || i78 == 17) {
                        i20 = i90;
                        int i91 = i69 / 3;
                        objArr[i91 + i91 + 1] = zzn4.getType();
                    } else {
                        if (i78 == 27) {
                            i27 = i90;
                            i28 = 1;
                            i4 += 2;
                        } else if (i78 == 49) {
                            i4 += 2;
                            i27 = i90;
                            i28 = 1;
                        } else if (i78 == 12 || i78 == 30 || i78 == 44) {
                            if (zzafnVar2.zzc() == 1 || i79 != 0) {
                                i4 += 2;
                                int i92 = i69 / 3;
                                objArr[i92 + i92 + 1] = zze[i90];
                                str = zzd;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzn4);
                                i21 = 1048575;
                                if ((charAt22 & 4096) == 0 && i78 <= 17) {
                                    int i93 = i17 + 1;
                                    int charAt24 = str.charAt(i17);
                                    if (charAt24 >= 55296) {
                                        int i94 = charAt24 & 8191;
                                        int i95 = 13;
                                        while (true) {
                                            i26 = i93 + 1;
                                            charAt9 = str.charAt(i93);
                                            if (charAt9 < 55296) {
                                                break;
                                            }
                                            i94 |= (charAt9 & 8191) << i95;
                                            i95 += 13;
                                            i93 = i26;
                                        }
                                        charAt24 = i94 | (charAt9 << i95);
                                        i93 = i26;
                                    }
                                    int i96 = i19 + i19 + (charAt24 / 32);
                                    Object obj3 = zze[i96];
                                    int i97 = i93;
                                    if (obj3 instanceof Field) {
                                        zzn = (Field) obj3;
                                    } else {
                                        zzn = zzn(cls2, (String) obj3);
                                        zze[i96] = zzn;
                                    }
                                    objectFieldOffset2 = (int) unsafe.objectFieldOffset(zzn);
                                    i24 = objectFieldOffset;
                                    i22 = i97;
                                    c = 55296;
                                    i25 = charAt24 % 32;
                                } else {
                                    c = 55296;
                                    i22 = i17;
                                    i23 = i79;
                                    i24 = objectFieldOffset;
                                    i25 = 0;
                                    int i98 = i69 + 1;
                                    iArr2[i69] = charAt21;
                                    int i99 = i69 + 2;
                                    iArr2[i98] = ((charAt22 & 512) != 0 ? 536870912 : 0) | ((charAt22 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | i24;
                                    i69 += 3;
                                    iArr2[i99] = (i25 << 20) | i21;
                                    zzd = str;
                                    c2 = c;
                                    zzafnVar = zzafnVar2;
                                    i37 = i22;
                                    length = i18;
                                    i2 = i19;
                                }
                            } else {
                                str = zzd;
                                i4 = i90;
                                i79 = 0;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzn4);
                                i21 = 1048575;
                                if ((charAt22 & 4096) == 0) {
                                }
                                c = 55296;
                                i22 = i17;
                                i23 = i79;
                                i24 = objectFieldOffset;
                                i25 = 0;
                                int i982 = i69 + 1;
                                iArr2[i69] = charAt21;
                                int i992 = i69 + 2;
                                if ((charAt22 & 512) != 0) {
                                }
                                if ((charAt22 & 256) != 0) {
                                }
                                iArr2[i982] = ((charAt22 & 512) != 0 ? 536870912 : 0) | ((charAt22 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | i24;
                                i69 += 3;
                                iArr2[i992] = (i25 << 20) | i21;
                                zzd = str;
                                c2 = c;
                                zzafnVar = zzafnVar2;
                                i37 = i22;
                                length = i18;
                                i2 = i19;
                            }
                        } else if (i78 == 50) {
                            int i100 = i4 + 2;
                            int i101 = i66 + 1;
                            iArr[i66] = i69;
                            int i102 = i69 / 3;
                            int i103 = i102 + i102;
                            objArr[i103] = zze[i90];
                            if (i79 != 0) {
                                objArr[i103 + 1] = zze[i100];
                                i4 += 3;
                                str = zzd;
                                i66 = i101;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzn4);
                                i21 = 1048575;
                                if ((charAt22 & 4096) == 0) {
                                }
                                c = 55296;
                                i22 = i17;
                                i23 = i79;
                                i24 = objectFieldOffset;
                                i25 = 0;
                                int i9822 = i69 + 1;
                                iArr2[i69] = charAt21;
                                int i9922 = i69 + 2;
                                if ((charAt22 & 512) != 0) {
                                }
                                if ((charAt22 & 256) != 0) {
                                }
                                iArr2[i9822] = ((charAt22 & 512) != 0 ? 536870912 : 0) | ((charAt22 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | i24;
                                i69 += 3;
                                iArr2[i9922] = (i25 << 20) | i21;
                                zzd = str;
                                c2 = c;
                                zzafnVar = zzafnVar2;
                                i37 = i22;
                                length = i18;
                                i2 = i19;
                            } else {
                                i4 = i100;
                                i66 = i101;
                                i79 = 0;
                                str = zzd;
                                objectFieldOffset = (int) unsafe.objectFieldOffset(zzn4);
                                i21 = 1048575;
                                if ((charAt22 & 4096) == 0) {
                                }
                                c = 55296;
                                i22 = i17;
                                i23 = i79;
                                i24 = objectFieldOffset;
                                i25 = 0;
                                int i98222 = i69 + 1;
                                iArr2[i69] = charAt21;
                                int i99222 = i69 + 2;
                                if ((charAt22 & 512) != 0) {
                                }
                                if ((charAt22 & 256) != 0) {
                                }
                                iArr2[i98222] = ((charAt22 & 512) != 0 ? 536870912 : 0) | ((charAt22 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | i24;
                                i69 += 3;
                                iArr2[i99222] = (i25 << 20) | i21;
                                zzd = str;
                                c2 = c;
                                zzafnVar = zzafnVar2;
                                i37 = i22;
                                length = i18;
                                i2 = i19;
                            }
                        } else {
                            i20 = i90;
                        }
                        int i104 = i69 / 3;
                        objArr[i104 + i104 + i28] = zze[i27];
                        str = zzd;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zzn4);
                        i21 = 1048575;
                        if ((charAt22 & 4096) == 0) {
                        }
                        c = 55296;
                        i22 = i17;
                        i23 = i79;
                        i24 = objectFieldOffset;
                        i25 = 0;
                        int i982222 = i69 + 1;
                        iArr2[i69] = charAt21;
                        int i992222 = i69 + 2;
                        if ((charAt22 & 512) != 0) {
                        }
                        if ((charAt22 & 256) != 0) {
                        }
                        iArr2[i982222] = ((charAt22 & 512) != 0 ? 536870912 : 0) | ((charAt22 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | i24;
                        i69 += 3;
                        iArr2[i992222] = (i25 << 20) | i21;
                        zzd = str;
                        c2 = c;
                        zzafnVar = zzafnVar2;
                        i37 = i22;
                        length = i18;
                        i2 = i19;
                    }
                    str = zzd;
                    i4 = i20;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzn4);
                    i21 = 1048575;
                    if ((charAt22 & 4096) == 0) {
                    }
                    c = 55296;
                    i22 = i17;
                    i23 = i79;
                    i24 = objectFieldOffset;
                    i25 = 0;
                    int i9822222 = i69 + 1;
                    iArr2[i69] = charAt21;
                    int i9922222 = i69 + 2;
                    if ((charAt22 & 512) != 0) {
                    }
                    if ((charAt22 & 256) != 0) {
                    }
                    iArr2[i9822222] = ((charAt22 & 512) != 0 ? 536870912 : 0) | ((charAt22 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | i24;
                    i69 += 3;
                    iArr2[i9922222] = (i25 << 20) | i21;
                    zzd = str;
                    c2 = c;
                    zzafnVar = zzafnVar2;
                    i37 = i22;
                    length = i18;
                    i2 = i19;
                }
                i21 = objectFieldOffset2;
                i23 = i79;
                int i98222222 = i69 + 1;
                iArr2[i69] = charAt21;
                int i99222222 = i69 + 2;
                if ((charAt22 & 512) != 0) {
                }
                if ((charAt22 & 256) != 0) {
                }
                iArr2[i98222222] = ((charAt22 & 512) != 0 ? 536870912 : 0) | ((charAt22 & 256) != 0 ? 268435456 : 0) | (i23 != 0 ? Integer.MIN_VALUE : 0) | (i78 << 20) | i24;
                i69 += 3;
                iArr2[i99222222] = (i25 << 20) | i21;
                zzd = str;
                c2 = c;
                zzafnVar = zzafnVar2;
                i37 = i22;
                length = i18;
                i2 = i19;
            }
            return new zzaff(iArr2, objArr, i5, i3, zzafnVar.zzb(), false, iArr, i7, i64, zzafhVar, zzaeoVar, zzafzVar, zzadgVar, zzaexVar);
        }
        zzafw zzafwVar = (zzafw) zzaezVar;
        throw null;
    }

    private static Field zzn(Class cls, String str) {
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

    private final void zzo(Object obj, Object obj2, int i) {
        if (zzK(obj2, i)) {
            Unsafe unsafe = zzb;
            long zzA = zzA(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzA);
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
            zzafp zzq = zzq(i);
            if (!zzK(obj, i)) {
                if (!zzE(object)) {
                    unsafe.putObject(obj, zzA, object);
                } else {
                    Object zza2 = zzq.zza();
                    zzq.zzd(zza2, object);
                    unsafe.putObject(obj, zzA, zza2);
                }
                zzL(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzA);
            if (!zzE(object2)) {
                Object zza3 = zzq.zza();
                zzq.zzd(zza3, object2);
                unsafe.putObject(obj, zzA, zza3);
                object2 = zza3;
            }
            zzq.zzd(object2, object);
        }
    }

    private final void zzp(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            Unsafe unsafe = zzb;
            long zzA = zzA(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzA);
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
            zzafp zzq = zzq(i);
            if (!zzM(obj, i2, i)) {
                if (!zzE(object)) {
                    unsafe.putObject(obj, zzA, object);
                } else {
                    Object zza2 = zzq.zza();
                    zzq.zzd(zza2, object);
                    unsafe.putObject(obj, zzA, zza2);
                }
                zzO(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, zzA);
            if (!zzE(object2)) {
                Object zza3 = zzq.zza();
                zzq.zzd(zza3, object2);
                unsafe.putObject(obj, zzA, zza3);
                object2 = zza3;
            }
            zzq.zzd(object2, object);
        }
    }

    private final zzafp zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzafp zzafpVar = (zzafp) objArr[i3];
        if (zzafpVar != null) {
            return zzafpVar;
        }
        zzafp zzb2 = zzafl.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzadz zzs(int i) {
        int i2 = i / 3;
        return (zzadz) this.zzd[i2 + i2 + 1];
    }

    private final Object zzt(Object obj, int i) {
        zzafp zzq = zzq(i);
        int zzA = zzA(i) & 1048575;
        if (!zzK(obj, i)) {
            return zzq.zza();
        }
        Object object = zzb.getObject(obj, zzA);
        if (zzE(object)) {
            return object;
        }
        Object zza2 = zzq.zza();
        if (object != null) {
            zzq.zzd(zza2, object);
        }
        return zza2;
    }

    private final void zzu(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzA(i) & 1048575, obj2);
        zzL(obj, i);
    }

    private final Object zzv(Object obj, int i, int i2) {
        zzafp zzq = zzq(i2);
        if (!zzM(obj, i, i2)) {
            return zzq.zza();
        }
        Object object = zzb.getObject(obj, zzA(i2) & 1048575);
        if (zzE(object)) {
            return object;
        }
        Object zza2 = zzq.zza();
        if (object != null) {
            zzq.zzd(zza2, object);
        }
        return zza2;
    }

    private final void zzw(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzA(i2) & 1048575, obj2);
        zzO(obj, i, i2);
    }

    private final Object zzx(Object obj, int i, Object obj2, zzafz zzafzVar, Object obj3) {
        zzadz zzs;
        int i2 = this.zzc[i];
        Object zzm = zzagg.zzm(obj, zzA(i) & 1048575);
        if (zzm == null || (zzs = zzs(i)) == null) {
            return obj2;
        }
        zzaeu zze = ((zzaev) zzr(i)).zze();
        Iterator it = ((zzaew) zzm).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzafzVar.zzh(obj3);
                }
                int zzc = zzaev.zzc(zze, entry.getKey(), entry.getValue());
                zzacr zzacrVar = zzacr.zza;
                byte[] bArr = new byte[zzc];
                int i3 = zzada.zzb;
                zzacx zzacxVar = new zzacx(bArr, 0, zzc);
                try {
                    zzaev.zzb(zzacxVar, zze, entry.getKey(), entry.getValue());
                    zzafzVar.zzd(obj2, i2, zzaco.zza(zzacxVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private static boolean zzy(Object obj, int i, zzafp zzafpVar) {
        return zzafpVar.zzl(zzagg.zzm(obj, i & 1048575));
    }

    private final void zzz(Object obj, int i, zzafo zzafoVar) throws IOException {
        long j = i & 1048575;
        if (zzD(i)) {
            zzagg.zzn(obj, j, zzafoVar.zzn());
        } else if (!this.zzi) {
            zzagg.zzn(obj, j, zzafoVar.zzq());
        } else {
            zzagg.zzn(obj, j, zzafoVar.zzm());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final Object zza() {
        return ((zzadu) this.zzg).zzck();
    }

    /* JADX WARN: Code restructure failed: missing block: B:178:0x01c2, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01c2 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzb(Object obj, Object obj2) {
        boolean zzC;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzA = zzA(i);
            int zzC2 = zzC(zzA);
            if (zzC2 <= 50 || zzC2 >= 69) {
                long j = zzA & 1048575;
                switch (zzC2) {
                    case 0:
                        if (zzI(obj, obj2, i) && Double.doubleToLongBits(zzagg.zzk(obj, j)) == Double.doubleToLongBits(zzagg.zzk(obj2, j))) {
                            break;
                        }
                        return false;
                    case 1:
                        if (zzI(obj, obj2, i) && Float.floatToIntBits(zzagg.zzi(obj, j)) == Float.floatToIntBits(zzagg.zzi(obj2, j))) {
                            break;
                        }
                        return false;
                    case 2:
                        if (zzI(obj, obj2, i) && zzagg.zze(obj, j) == zzagg.zze(obj2, j)) {
                            break;
                        }
                        return false;
                    case 3:
                        if (zzI(obj, obj2, i) && zzagg.zze(obj, j) == zzagg.zze(obj2, j)) {
                            break;
                        }
                        return false;
                    case 4:
                        if (zzI(obj, obj2, i) && zzagg.zzc(obj, j) == zzagg.zzc(obj2, j)) {
                            break;
                        }
                        return false;
                    case 5:
                        if (zzI(obj, obj2, i) && zzagg.zze(obj, j) == zzagg.zze(obj2, j)) {
                            break;
                        }
                        return false;
                    case 6:
                        if (zzI(obj, obj2, i) && zzagg.zzc(obj, j) == zzagg.zzc(obj2, j)) {
                            break;
                        }
                        return false;
                    case 7:
                        if (zzI(obj, obj2, i) && zzagg.zzg(obj, j) == zzagg.zzg(obj2, j)) {
                            break;
                        }
                        return false;
                    case 8:
                        if (zzI(obj, obj2, i) && zzafq.zzC(zzagg.zzm(obj, j), zzagg.zzm(obj2, j))) {
                            break;
                        }
                        return false;
                    case 9:
                        if (zzI(obj, obj2, i) && zzafq.zzC(zzagg.zzm(obj, j), zzagg.zzm(obj2, j))) {
                            break;
                        }
                        return false;
                    case 10:
                        if (zzI(obj, obj2, i) && zzafq.zzC(zzagg.zzm(obj, j), zzagg.zzm(obj2, j))) {
                            break;
                        }
                        return false;
                    case 11:
                        if (zzI(obj, obj2, i) && zzagg.zzc(obj, j) == zzagg.zzc(obj2, j)) {
                            break;
                        }
                        return false;
                    case 12:
                        if (zzI(obj, obj2, i) && zzagg.zzc(obj, j) == zzagg.zzc(obj2, j)) {
                            break;
                        }
                        return false;
                    case 13:
                        if (zzI(obj, obj2, i) && zzagg.zzc(obj, j) == zzagg.zzc(obj2, j)) {
                            break;
                        }
                        return false;
                    case 14:
                        if (zzI(obj, obj2, i) && zzagg.zze(obj, j) == zzagg.zze(obj2, j)) {
                            break;
                        }
                        return false;
                    case 15:
                        if (zzI(obj, obj2, i) && zzagg.zzc(obj, j) == zzagg.zzc(obj2, j)) {
                            break;
                        }
                        return false;
                    case 16:
                        if (zzI(obj, obj2, i) && zzagg.zze(obj, j) == zzagg.zze(obj2, j)) {
                            break;
                        }
                        return false;
                    case 17:
                        if (zzI(obj, obj2, i) && zzafq.zzC(zzagg.zzm(obj, j), zzagg.zzm(obj2, j))) {
                            break;
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
                        zzC = zzafq.zzC(zzagg.zzm(obj, j), zzagg.zzm(obj2, j));
                        if (!zzC) {
                            break;
                        } else {
                            return false;
                        }
                    case 50:
                        zzC = zzafq.zzC(zzagg.zzm(obj, j), zzagg.zzm(obj2, j));
                        if (!zzC) {
                        }
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
                        if (zzN(obj, obj2, i) && zzafq.zzC(zzagg.zzm(obj, j), zzagg.zzm(obj2, j))) {
                            break;
                        }
                        return false;
                }
            }
        }
        int i2 = this.zzl;
        while (true) {
            int[] iArr = this.zzj;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (!zzN(obj, obj2, i3)) {
                    return false;
                }
                if (!zzM(obj, 0, i3)) {
                    long zzA2 = zzA(i3) & 1048575;
                    if (!zzafq.zzC(zzagg.zzm(obj, zzA2), zzagg.zzm(obj2, zzA2))) {
                        return false;
                    }
                }
                i2++;
            } else if (((zzadu) obj).zzc.equals(((zzadu) obj2).zzc)) {
                if (this.zzh) {
                    return ((zzadr) obj).zzb.equals(((zzadr) obj2).zzb);
                }
                return true;
            } else {
                return false;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zzc(Object obj) {
        int i;
        int i2;
        long doubleToLongBits;
        int floatToIntBits;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzc.length; i5 += 3) {
            int zzA = zzA(i5);
            int zzC = zzC(zzA);
            if (zzC <= 50 || zzC >= 69) {
                long j = zzA & 1048575;
                int i6 = 37;
                switch (zzC) {
                    case 0:
                        i2 = i4 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzagg.zzk(obj, j));
                        byte[] bArr = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i2 + floatToIntBits;
                        break;
                    case 1:
                        i2 = i4 * 53;
                        floatToIntBits = Float.floatToIntBits(zzagg.zzi(obj, j));
                        i4 = i2 + floatToIntBits;
                        break;
                    case 2:
                        i2 = i4 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr2 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i2 + floatToIntBits;
                        break;
                    case 3:
                        i2 = i4 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr3 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i2 + floatToIntBits;
                        break;
                    case 4:
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i4 = i2 + floatToIntBits;
                        break;
                    case 5:
                        i2 = i4 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr4 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i2 + floatToIntBits;
                        break;
                    case 6:
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i4 = i2 + floatToIntBits;
                        break;
                    case 7:
                        i2 = i4 * 53;
                        floatToIntBits = zzaed.zza(zzagg.zzg(obj, j));
                        i4 = i2 + floatToIntBits;
                        break;
                    case 8:
                        i2 = i4 * 53;
                        floatToIntBits = ((String) zzagg.zzm(obj, j)).hashCode();
                        i4 = i2 + floatToIntBits;
                        break;
                    case 9:
                        i3 = i4 * 53;
                        Object zzm = zzagg.zzm(obj, j);
                        if (zzm != null) {
                            i6 = zzm.hashCode();
                        }
                        i4 = i3 + i6;
                        break;
                    case 10:
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzm(obj, j).hashCode();
                        i4 = i2 + floatToIntBits;
                        break;
                    case 11:
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i4 = i2 + floatToIntBits;
                        break;
                    case 12:
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i4 = i2 + floatToIntBits;
                        break;
                    case 13:
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i4 = i2 + floatToIntBits;
                        break;
                    case 14:
                        i2 = i4 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr5 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i2 + floatToIntBits;
                        break;
                    case 15:
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzc(obj, j);
                        i4 = i2 + floatToIntBits;
                        break;
                    case 16:
                        i2 = i4 * 53;
                        doubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr6 = zzaed.zza;
                        floatToIntBits = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
                        i4 = i2 + floatToIntBits;
                        break;
                    case 17:
                        i3 = i4 * 53;
                        Object zzm2 = zzagg.zzm(obj, j);
                        if (zzm2 != null) {
                            i6 = zzm2.hashCode();
                        }
                        i4 = i3 + i6;
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
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzm(obj, j).hashCode();
                        i4 = i2 + floatToIntBits;
                        break;
                    case 50:
                        i2 = i4 * 53;
                        floatToIntBits = zzagg.zzm(obj, j).hashCode();
                        i4 = i2 + floatToIntBits;
                        break;
                }
            }
        }
        int i7 = this.zzl;
        while (true) {
            int[] iArr = this.zzj;
            if (i7 < iArr.length) {
                if (!zzM(obj, 0, iArr[i7])) {
                    i4 = (i4 * 53) + zzagg.zzm(obj, zzA(i) & 1048575).hashCode();
                }
                i7++;
            } else {
                int hashCode = (i4 * 53) + ((zzadu) obj).zzc.hashCode();
                return this.zzh ? (hashCode * 53) + ((zzadr) obj).zzb.zza.hashCode() : hashCode;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzd(Object obj, Object obj2) {
        zzF(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i < iArr.length) {
                int zzA = zzA(i);
                int i2 = 1048575 & zzA;
                int zzC = zzC(zzA);
                int i3 = iArr[i];
                long j = i2;
                switch (zzC) {
                    case 0:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzl(obj, j, zzagg.zzk(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 1:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzj(obj, j, zzagg.zzi(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 2:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 3:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 4:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 5:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 6:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 7:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzh(obj, j, zzagg.zzg(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 8:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 9:
                        zzo(obj, obj2, i);
                        break;
                    case 10:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 11:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 12:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 13:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 14:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 15:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 16:
                        if (!zzK(obj2, i)) {
                            break;
                        } else {
                            zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                            zzL(obj, i);
                            break;
                        }
                    case 17:
                        zzo(obj, obj2, i);
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
                        zzaef zzaefVar = (zzaef) zzagg.zzm(obj, j);
                        zzaef zzaefVar2 = (zzaef) zzagg.zzm(obj2, j);
                        int size = zzaefVar.size();
                        int size2 = zzaefVar2.size();
                        if (size > 0 && size2 > 0) {
                            if (!zzaefVar.zza()) {
                                zzaefVar = zzaefVar.zzg(size2 + size);
                            }
                            zzaefVar.addAll(zzaefVar2);
                        }
                        if (size > 0) {
                            zzaefVar2 = zzaefVar;
                        }
                        zzagg.zzn(obj, j, zzaefVar2);
                        break;
                    case 50:
                        int i4 = zzafq.zza;
                        zzagg.zzn(obj, j, zzaex.zzb(zzagg.zzm(obj, j), zzagg.zzm(obj2, j)));
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
                            zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                            zzO(obj, i3, i);
                            break;
                        }
                    case 60:
                        zzp(obj, obj2, i);
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
                            zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                            zzO(obj, i3, i);
                            break;
                        }
                    case 68:
                        zzp(obj, obj2, i);
                        break;
                }
                i += 3;
            } else {
                zzafq.zzE(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzafq.zzD(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zze(Object obj) {
        int i;
        int zzE;
        int zzE2;
        int zzF;
        int zzE3;
        int zzE4;
        int zzE5;
        int zzb2;
        int zzE6;
        int zzz;
        int zzo;
        int size;
        int zzp;
        int zzE7;
        int zzb3;
        int zzE8;
        int zzb4;
        int zzE9;
        int zzE10;
        int zzcf;
        int zzE11;
        int zzE12;
        int i2;
        int zzx;
        int zzE13;
        int zzE14;
        int i3;
        int zzE15;
        int zzE16;
        int zzE17;
        int zzb5;
        int zzE18;
        zzaff<T> zzaffVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (true) {
            int[] iArr = zzaffVar.zzc;
            if (i4 < iArr.length) {
                int zzA = zzaffVar.zzA(i4);
                int zzC = zzC(zzA);
                int i8 = iArr[i4];
                int i9 = iArr[i4 + 2];
                int i10 = i9 & 1048575;
                if (zzC <= 17) {
                    if (i10 != i7) {
                        i5 = i10 == 1048575 ? 0 : unsafe.getInt(obj2, i10);
                        i7 = i10;
                    }
                    i = 1 << (i9 >>> 20);
                } else {
                    i = 0;
                }
                int i11 = zzA & 1048575;
                if (zzC >= zzadl.DOUBLE_LIST_PACKED.zza()) {
                    zzadl.SINT64_LIST_PACKED.zza();
                }
                long j = i11;
                switch (zzC) {
                    case 0:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            i6 += zzada.zzE(i8 << 3) + 8;
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE = zzada.zzE(i8 << 3);
                            zzE4 = zzE + 4;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 2:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j2 = unsafe.getLong(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF(j2);
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 3:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j3 = unsafe.getLong(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF(j3);
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 4:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF(unsafe.getInt(obj2, j));
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 5:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE3 = zzada.zzE(i8 << 3);
                            zzE4 = zzE3 + 8;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 6:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE = zzada.zzE(i8 << 3);
                            zzE4 = zzE + 4;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 7:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE4 = zzada.zzE(i8 << 3) + 1;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 8:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i12 = i8 << 3;
                            Object object = unsafe.getObject(obj2, j);
                            if (object instanceof zzacr) {
                                zzE5 = zzada.zzE(i12);
                                zzb2 = ((zzacr) object).zzb();
                                zzE6 = zzada.zzE(zzb2);
                            } else {
                                zzE5 = zzada.zzE(i12);
                                zzb2 = zzagl.zzb((String) object);
                                zzE6 = zzada.zzE(zzb2);
                            }
                            zzE4 = zzE5 + zzE6 + zzb2;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 9:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz = zzafq.zzz(i8, unsafe.getObject(obj2, j), zzaffVar.zzq(i4));
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE5 = zzada.zzE(i8 << 3);
                            zzb2 = ((zzacr) unsafe.getObject(obj2, j)).zzb();
                            zzE6 = zzada.zzE(zzb2);
                            zzE4 = zzE5 + zzE6 + zzb2;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 11:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i13 = unsafe.getInt(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzE(i13);
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 12:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF(unsafe.getInt(obj2, j));
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 13:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE = zzada.zzE(i8 << 3);
                            zzE4 = zzE + 4;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 14:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzE3 = zzada.zzE(i8 << 3);
                            zzE4 = zzE3 + 8;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 15:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            int i14 = unsafe.getInt(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzE((i14 >> 31) ^ (i14 + i14));
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 16:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            long j4 = unsafe.getLong(obj2, j);
                            zzE2 = zzada.zzE(i8 << 3);
                            zzF = zzada.zzF((j4 >> 63) ^ (j4 + j4));
                            zzE4 = zzE2 + zzF;
                            i6 += zzE4;
                        }
                        zzaffVar = this;
                        break;
                    case 17:
                        if (zzaffVar.zzJ(obj2, i4, i7, i5, i)) {
                            zzz = zzafq.zzA(i8, (zzafc) unsafe.getObject(obj2, j), zzaffVar.zzq(i4));
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzz = zzafq.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 19:
                        zzz = zzafq.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 20:
                        List list = (List) unsafe.getObject(obj2, j);
                        int i15 = zzafq.zza;
                        if (list.size() != 0) {
                            zzo = zzafq.zzo(list) + (list.size() * zzada.zzE(i8 << 3));
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case 21:
                        List list2 = (List) unsafe.getObject(obj2, j);
                        int i16 = zzafq.zza;
                        size = list2.size();
                        if (size != 0) {
                            zzp = zzafq.zzp(list2);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 22:
                        List list3 = (List) unsafe.getObject(obj2, j);
                        int i17 = zzafq.zza;
                        size = list3.size();
                        if (size != 0) {
                            zzp = zzafq.zzs(list3);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 23:
                        zzz = zzafq.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 24:
                        zzz = zzafq.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 25:
                        int i18 = zzafq.zza;
                        int size2 = ((List) unsafe.getObject(obj2, j)).size();
                        if (size2 != 0) {
                            zzz = size2 * (zzada.zzE(i8 << 3) + 1);
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 26:
                        List list4 = (List) unsafe.getObject(obj2, j);
                        int i19 = zzafq.zza;
                        int size3 = list4.size();
                        if (size3 != 0) {
                            zzo = zzada.zzE(i8 << 3) * size3;
                            if (list4 instanceof zzaen) {
                                zzaen zzaenVar = (zzaen) list4;
                                for (int i20 = 0; i20 < size3; i20++) {
                                    Object zzc = zzaenVar.zzc();
                                    if (zzc instanceof zzacr) {
                                        zzb4 = ((zzacr) zzc).zzb();
                                        zzE9 = zzada.zzE(zzb4);
                                    } else {
                                        zzb4 = zzagl.zzb((String) zzc);
                                        zzE9 = zzada.zzE(zzb4);
                                    }
                                    zzo += zzE9 + zzb4;
                                }
                            } else {
                                for (int i21 = 0; i21 < size3; i21++) {
                                    Object obj3 = list4.get(i21);
                                    if (obj3 instanceof zzacr) {
                                        zzb3 = ((zzacr) obj3).zzb();
                                        zzE8 = zzada.zzE(zzb3);
                                    } else {
                                        zzb3 = zzagl.zzb((String) obj3);
                                        zzE8 = zzada.zzE(zzb3);
                                    }
                                    zzo += zzE8 + zzb3;
                                }
                            }
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case 27:
                        List list5 = (List) unsafe.getObject(obj2, j);
                        zzafp zzq = zzaffVar.zzq(i4);
                        int i22 = zzafq.zza;
                        int size4 = list5.size();
                        if (size4 == 0) {
                            zzE10 = 0;
                        } else {
                            zzE10 = zzada.zzE(i8 << 3) * size4;
                            for (int i23 = 0; i23 < size4; i23++) {
                                Object obj4 = list5.get(i23);
                                if (obj4 instanceof zzaem) {
                                    zzcf = ((zzaem) obj4).zzb();
                                    zzE11 = zzada.zzE(zzcf);
                                } else {
                                    zzcf = ((zzacb) obj4).zzcf(zzq);
                                    zzE11 = zzada.zzE(zzcf);
                                }
                                zzE10 += zzE11 + zzcf;
                            }
                        }
                        i6 += zzE10;
                        break;
                    case 28:
                        List list6 = (List) unsafe.getObject(obj2, j);
                        int i24 = zzafq.zza;
                        int size5 = list6.size();
                        if (size5 == 0) {
                            zzE12 = 0;
                        } else {
                            zzE12 = size5 * zzada.zzE(i8 << 3);
                            for (int i25 = 0; i25 < list6.size(); i25++) {
                                int zzb6 = ((zzacr) list6.get(i25)).zzb();
                                zzE12 += zzada.zzE(zzb6) + zzb6;
                            }
                        }
                        i6 += zzE12;
                        break;
                    case 29:
                        List list7 = (List) unsafe.getObject(obj2, j);
                        int i26 = zzafq.zza;
                        size = list7.size();
                        if (size != 0) {
                            zzp = zzafq.zzt(list7);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 30:
                        List list8 = (List) unsafe.getObject(obj2, j);
                        int i27 = zzafq.zza;
                        size = list8.size();
                        if (size != 0) {
                            zzp = zzafq.zzr(list8);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 31:
                        zzz = zzafq.zzw(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 32:
                        zzz = zzafq.zzy(i8, (List) unsafe.getObject(obj2, j), false);
                        i6 += zzz;
                        break;
                    case 33:
                        List list9 = (List) unsafe.getObject(obj2, j);
                        int i28 = zzafq.zza;
                        size = list9.size();
                        if (size != 0) {
                            zzp = zzafq.zzu(list9);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 34:
                        List list10 = (List) unsafe.getObject(obj2, j);
                        int i29 = zzafq.zza;
                        size = list10.size();
                        if (size != 0) {
                            zzp = zzafq.zzq(list10);
                            zzE7 = zzada.zzE(i8 << 3);
                            i2 = size * zzE7;
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        }
                        zzz = 0;
                        i6 += zzz;
                    case 35:
                        zzx = zzafq.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        zzx = zzafq.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        zzx = zzafq.zzo((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        zzx = zzafq.zzp((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        zzx = zzafq.zzs((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        zzx = zzafq.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        zzx = zzafq.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        int i30 = zzafq.zza;
                        zzx = ((List) unsafe.getObject(obj2, j)).size();
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        zzx = zzafq.zzt((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        zzx = zzafq.zzr((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        zzx = zzafq.zzv((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        zzx = zzafq.zzx((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        zzx = zzafq.zzu((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        zzx = zzafq.zzq((List) unsafe.getObject(obj2, j));
                        if (zzx > 0) {
                            zzE13 = zzada.zzE(i8 << 3);
                            zzE14 = zzada.zzE(zzx);
                            zzE12 = zzE13 + zzE14 + zzx;
                            i6 += zzE12;
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        List list11 = (List) unsafe.getObject(obj2, j);
                        zzafp zzq2 = zzaffVar.zzq(i4);
                        int i31 = zzafq.zza;
                        int size6 = list11.size();
                        if (size6 == 0) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            for (int i32 = 0; i32 < size6; i32++) {
                                i3 += zzafq.zzA(i8, (zzafc) list11.get(i32), zzq2);
                            }
                        }
                        i6 += i3;
                        break;
                    case 50:
                        zzaew zzaewVar = (zzaew) unsafe.getObject(obj2, j);
                        zzaev zzaevVar = (zzaev) zzaffVar.zzr(i4);
                        if (!zzaewVar.isEmpty()) {
                            zzo = 0;
                            for (Map.Entry entry : zzaewVar.entrySet()) {
                                zzo += zzaevVar.zzd(i8, entry.getKey(), entry.getValue());
                            }
                            i6 += zzo;
                            break;
                        }
                        zzo = 0;
                        i6 += zzo;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE15 = zzada.zzE(i8 << 3);
                            zzz = zzE15 + 8;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE16 = zzada.zzE(i8 << 3);
                            zzz = zzE16 + 4;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            long zzH = zzH(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF(zzH);
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            long zzH2 = zzH(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF(zzH2);
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF(zzG(obj2, j));
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE15 = zzada.zzE(i8 << 3);
                            zzz = zzE15 + 8;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE16 = zzada.zzE(i8 << 3);
                            zzz = zzE16 + 4;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzz = zzada.zzE(i8 << 3) + 1;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 59:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            int i33 = i8 << 3;
                            Object object2 = unsafe.getObject(obj2, j);
                            if (object2 instanceof zzacr) {
                                zzE17 = zzada.zzE(i33);
                                zzb5 = ((zzacr) object2).zzb();
                                zzE18 = zzada.zzE(zzb5);
                            } else {
                                zzE17 = zzada.zzE(i33);
                                zzb5 = zzagl.zzb((String) object2);
                                zzE18 = zzada.zzE(zzb5);
                            }
                            zzz = zzE17 + zzE18 + zzb5;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzz = zzafq.zzz(i8, unsafe.getObject(obj2, j), zzaffVar.zzq(i4));
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE17 = zzada.zzE(i8 << 3);
                            zzb5 = ((zzacr) unsafe.getObject(obj2, j)).zzb();
                            zzE18 = zzada.zzE(zzb5);
                            zzz = zzE17 + zzE18 + zzb5;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case RectListKt.BitOffsetForGesturable /* 62 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            int zzG = zzG(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzE(zzG);
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF(zzG(obj2, j));
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE16 = zzada.zzE(i8 << 3);
                            zzz = zzE16 + 4;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzE15 = zzada.zzE(i8 << 3);
                            zzz = zzE15 + 8;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            int zzG2 = zzG(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzE((zzG2 >> 31) ^ (zzG2 + zzG2));
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            long zzH3 = zzH(obj2, j);
                            zzp = zzada.zzE(i8 << 3);
                            i2 = zzada.zzF((zzH3 >> 63) ^ (zzH3 + zzH3));
                            zzz = zzp + i2;
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzaffVar.zzM(obj2, i8, i4)) {
                            zzz = zzafq.zzA(i8, (zzafc) unsafe.getObject(obj2, j), zzaffVar.zzq(i4));
                            i6 += zzz;
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                obj2 = obj;
            } else {
                int zzi = i6 + ((zzadu) obj).zzc.zzi();
                if (zzaffVar.zzh) {
                    zzafv zzafvVar = ((zzadr) obj).zzb.zza;
                    int zzc2 = zzafvVar.zzc();
                    int i34 = 0;
                    for (int i35 = 0; i35 < zzc2; i35++) {
                        Map.Entry zzd = zzafvVar.zzd(i35);
                        i34 += zzadk.zzj((zzadj) ((zzafs) zzd).zza(), zzd.getValue());
                    }
                    for (Map.Entry entry2 : zzafvVar.zze()) {
                        i34 += zzadk.zzj((zzadj) entry2.getKey(), entry2.getValue());
                    }
                    return zzi + i34;
                }
                return zzi;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04e1  */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzf(Object obj, zzago zzagoVar) throws IOException {
        Map.Entry entry;
        int[] iArr;
        int i;
        int i2;
        int i3;
        zzaff<T> zzaffVar = this;
        if (zzaffVar.zzh) {
            zzadk zzadkVar = ((zzadr) obj).zzb;
            if (!zzadkVar.zza.isEmpty()) {
                entry = (Map.Entry) zzadkVar.zzc().next();
                iArr = zzaffVar.zzc;
                Unsafe unsafe = zzb;
                int i4 = 1048575;
                int i5 = 1048575;
                i = 0;
                int i6 = 0;
                while (i < iArr.length) {
                    int zzA = zzaffVar.zzA(i);
                    int zzC = zzC(zzA);
                    int i7 = iArr[i];
                    if (zzC <= 17) {
                        int i8 = iArr[i + 2];
                        int i9 = i8 & i4;
                        if (i9 != i5) {
                            i6 = i9 == i4 ? 0 : unsafe.getInt(obj, i9);
                            i5 = i9;
                        }
                        i2 = zzA;
                        i3 = 1 << (i8 >>> 20);
                    } else {
                        i2 = zzA;
                        i3 = 0;
                    }
                    if (entry == null) {
                        long j = i2 & i4;
                        switch (zzC) {
                            case 0:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzf(i7, zzagg.zzk(obj, j));
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 1:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zze(i7, zzagg.zzi(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 2:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzc(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 3:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzh(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 4:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzi(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 5:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzj(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 6:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzk(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 7:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzl(i7, zzagg.zzg(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 8:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzT(i7, unsafe.getObject(obj, j), zzagoVar);
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 9:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzr(i7, unsafe.getObject(obj, j), zzaffVar.zzq(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 10:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzn(i7, (zzacr) unsafe.getObject(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 11:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzo(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 12:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzg(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 13:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzb(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 14:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzd(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 15:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzp(i7, unsafe.getInt(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 16:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzq(i7, unsafe.getLong(obj, j));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 17:
                                if (zzaffVar.zzJ(obj, i, i5, i6, i3)) {
                                    zzagoVar.zzs(i7, unsafe.getObject(obj, j), zzaffVar.zzq(i));
                                } else {
                                    continue;
                                }
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 18:
                                zzafq.zza(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 19:
                                zzafq.zzb(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 20:
                                zzafq.zzc(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 21:
                                zzafq.zzd(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 22:
                                zzafq.zzh(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 23:
                                zzafq.zzf(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 24:
                                zzafq.zzk(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 25:
                                zzafq.zzn(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 26:
                                int i10 = iArr[i];
                                List list = (List) unsafe.getObject(obj, j);
                                int i11 = zzafq.zza;
                                if (list != null && !list.isEmpty()) {
                                    zzagoVar.zzF(i10, list);
                                    break;
                                }
                                break;
                            case 27:
                                int i12 = iArr[i];
                                List list2 = (List) unsafe.getObject(obj, j);
                                zzafp zzq = zzaffVar.zzq(i);
                                int i13 = zzafq.zza;
                                if (list2 != null && !list2.isEmpty()) {
                                    for (int i14 = 0; i14 < list2.size(); i14++) {
                                        ((zzadb) zzagoVar).zzr(i12, list2.get(i14), zzq);
                                    }
                                    break;
                                }
                                break;
                            case 28:
                                int i15 = iArr[i];
                                List list3 = (List) unsafe.getObject(obj, j);
                                int i16 = zzafq.zza;
                                if (list3 != null && !list3.isEmpty()) {
                                    zzagoVar.zzG(i15, list3);
                                    break;
                                }
                                break;
                            case 29:
                                zzafq.zzi(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 30:
                                zzafq.zzm(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 31:
                                zzafq.zzl(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 32:
                                zzafq.zzg(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 33:
                                zzafq.zzj(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 34:
                                zzafq.zze(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, false);
                                continue;
                                i += 3;
                                i4 = 1048575;
                                zzaffVar = this;
                            case 35:
                                zzafq.zza(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 36:
                                zzafq.zzb(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 37:
                                zzafq.zzc(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 38:
                                zzafq.zzd(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 39:
                                zzafq.zzh(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 40:
                                zzafq.zzf(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 41:
                                zzafq.zzk(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 42:
                                zzafq.zzn(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 43:
                                zzafq.zzi(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 44:
                                zzafq.zzm(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 45:
                                zzafq.zzl(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 46:
                                zzafq.zzg(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 47:
                                zzafq.zzj(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 48:
                                zzafq.zze(iArr[i], (List) unsafe.getObject(obj, j), zzagoVar, true);
                                break;
                            case 49:
                                int i17 = iArr[i];
                                List list4 = (List) unsafe.getObject(obj, j);
                                zzafp zzq2 = zzaffVar.zzq(i);
                                int i18 = zzafq.zza;
                                if (list4 != null && !list4.isEmpty()) {
                                    for (int i19 = 0; i19 < list4.size(); i19++) {
                                        ((zzadb) zzagoVar).zzs(i17, list4.get(i19), zzq2);
                                    }
                                    break;
                                }
                                break;
                            case 50:
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    zzagoVar.zzM(i7, ((zzaev) zzaffVar.zzr(i)).zze(), (zzaew) object);
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzf(i7, ((Double) zzagg.zzm(obj, j)).doubleValue());
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zze(i7, ((Float) zzagg.zzm(obj, j)).floatValue());
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzc(i7, zzH(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzh(i7, zzH(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzi(i7, zzG(obj, j));
                                    break;
                                }
                                break;
                            case 56:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzj(i7, zzH(obj, j));
                                    break;
                                }
                                break;
                            case 57:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzk(i7, zzG(obj, j));
                                    break;
                                }
                                break;
                            case 58:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzl(i7, ((Boolean) zzagg.zzm(obj, j)).booleanValue());
                                    break;
                                }
                                break;
                            case 59:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzT(i7, unsafe.getObject(obj, j), zzagoVar);
                                    break;
                                }
                                break;
                            case 60:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzr(i7, unsafe.getObject(obj, j), zzaffVar.zzq(i));
                                    break;
                                }
                                break;
                            case 61:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzn(i7, (zzacr) unsafe.getObject(obj, j));
                                    break;
                                }
                                break;
                            case RectListKt.BitOffsetForGesturable /* 62 */:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzo(i7, zzG(obj, j));
                                    break;
                                }
                                break;
                            case 63:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzg(i7, zzG(obj, j));
                                    break;
                                }
                                break;
                            case 64:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzb(i7, zzG(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzd(i7, zzH(obj, j));
                                    break;
                                }
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzp(i7, zzG(obj, j));
                                    break;
                                }
                                break;
                            case 67:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzq(i7, zzH(obj, j));
                                    break;
                                }
                                break;
                            case 68:
                                if (zzaffVar.zzM(obj, i7, i)) {
                                    zzagoVar.zzs(i7, unsafe.getObject(obj, j), zzaffVar.zzq(i));
                                    break;
                                }
                                break;
                        }
                        i += 3;
                        i4 = 1048575;
                        zzaffVar = this;
                    } else {
                        zzads zzadsVar = (zzads) entry.getKey();
                        throw null;
                    }
                }
                if (entry != null) {
                    ((zzadu) obj).zzc.zzg(zzagoVar);
                    return;
                } else {
                    zzads zzadsVar2 = (zzads) entry.getKey();
                    throw null;
                }
            }
        }
        entry = null;
        iArr = zzaffVar.zzc;
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

    /* JADX WARN: Removed duplicated region for block: B:181:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x055c A[LOOP:1: B:191:0x0558->B:193:0x055c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0523 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x052e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzg(Object obj, zzafo zzafoVar, zzadf zzadfVar) throws IOException {
        zzaff<T> zzaffVar;
        Object obj2;
        Throwable th;
        int i;
        Object obj3;
        Object obj4;
        Object obj5;
        List zza2;
        zzadfVar.getClass();
        zzF(obj);
        zzafz zzafzVar = this.zzm;
        Object obj6 = null;
        while (true) {
            try {
                int zzb2 = zzafoVar.zzb();
                int zzP = this.zzP(zzb2);
                if (zzP >= 0) {
                    obj5 = obj;
                    try {
                        int zzA = this.zzA(zzP);
                        try {
                        } catch (zzaeg unused) {
                            zzaffVar = this;
                            obj2 = obj5;
                        }
                        switch (zzC(zzA)) {
                            case 0:
                                obj2 = obj5;
                                zzagg.zzl(obj2, zzA & 1048575, zzafoVar.zze());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 1:
                                obj2 = obj5;
                                zzagg.zzj(obj2, zzA & 1048575, zzafoVar.zzf());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 2:
                                obj2 = obj5;
                                zzagg.zzf(obj2, zzA & 1048575, zzafoVar.zzh());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 3:
                                obj2 = obj5;
                                zzagg.zzf(obj2, zzA & 1048575, zzafoVar.zzg());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 4:
                                obj2 = obj5;
                                zzagg.zzd(obj2, zzA & 1048575, zzafoVar.zzi());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 5:
                                obj2 = obj5;
                                zzagg.zzf(obj2, zzA & 1048575, zzafoVar.zzj());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 6:
                                obj2 = obj5;
                                zzagg.zzd(obj2, zzA & 1048575, zzafoVar.zzk());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 7:
                                obj2 = obj5;
                                zzagg.zzh(obj2, zzA & 1048575, zzafoVar.zzl());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 8:
                                obj2 = obj5;
                                this.zzz(obj2, zzA, zzafoVar);
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 9:
                                obj2 = obj5;
                                zzafc zzafcVar = (zzafc) this.zzt(obj2, zzP);
                                zzafoVar.zzo(zzafcVar, this.zzq(zzP), zzadfVar);
                                this.zzu(obj2, zzP, zzafcVar);
                                obj = obj2;
                                break;
                            case 10:
                                obj2 = obj5;
                                zzagg.zzn(obj2, zzA & 1048575, zzafoVar.zzq());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 11:
                                obj2 = obj5;
                                zzagg.zzd(obj2, zzA & 1048575, zzafoVar.zzr());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 12:
                                obj2 = obj5;
                                int zzs = zzafoVar.zzs();
                                zzadz zzs2 = this.zzs(zzP);
                                if (zzs2 != null && !zzs2.zza(zzs)) {
                                    obj6 = zzafq.zzG(obj2, zzb2, zzs, obj6, zzafzVar);
                                    obj = obj2;
                                    break;
                                }
                                zzagg.zzd(obj2, zzA & 1048575, zzs);
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 13:
                                obj2 = obj5;
                                zzagg.zzd(obj2, zzA & 1048575, zzafoVar.zzt());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 14:
                                obj2 = obj5;
                                zzagg.zzf(obj2, zzA & 1048575, zzafoVar.zzu());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 15:
                                obj2 = obj5;
                                zzagg.zzd(obj2, zzA & 1048575, zzafoVar.zzv());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 16:
                                obj2 = obj5;
                                zzagg.zzf(obj2, zzA & 1048575, zzafoVar.zzw());
                                this.zzL(obj2, zzP);
                                obj = obj2;
                                break;
                            case 17:
                                obj2 = obj5;
                                zzafc zzafcVar2 = (zzafc) this.zzt(obj2, zzP);
                                zzafoVar.zzp(zzafcVar2, this.zzq(zzP), zzadfVar);
                                this.zzu(obj2, zzP, zzafcVar2);
                                obj = obj2;
                                break;
                            case 18:
                                obj2 = obj5;
                                zzafoVar.zzx(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 19:
                                obj2 = obj5;
                                zzafoVar.zzy(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 20:
                                obj2 = obj5;
                                zzafoVar.zzA(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 21:
                                obj2 = obj5;
                                zzafoVar.zzz(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 22:
                                obj2 = obj5;
                                zzafoVar.zzB(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 23:
                                obj2 = obj5;
                                zzafoVar.zzC(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 24:
                                obj2 = obj5;
                                zzafoVar.zzD(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 25:
                                obj2 = obj5;
                                zzafoVar.zzE(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 26:
                                obj2 = obj5;
                                if (zzD(zzA)) {
                                    ((zzacw) zzafoVar).zzF(zzaeo.zza(obj2, zzA & 1048575), true);
                                } else {
                                    ((zzacw) zzafoVar).zzF(zzaeo.zza(obj2, zzA & 1048575), false);
                                }
                                obj = obj2;
                                break;
                            case 27:
                                obj2 = obj5;
                                zzafoVar.zzG(zzaeo.zza(obj2, zzA & 1048575), this.zzq(zzP), zzadfVar);
                                obj = obj2;
                                break;
                            case 28:
                                obj2 = obj5;
                                zzafoVar.zzI(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 29:
                                obj2 = obj5;
                                zzafoVar.zzJ(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 30:
                                List zza3 = zzaeo.zza(obj5, zzA & 1048575);
                                zzafoVar.zzK(zza3);
                                obj6 = zzafq.zzF(obj5, zzb2, zza3, this.zzs(zzP), obj6, zzafzVar);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 31:
                                obj2 = obj5;
                                zzafoVar.zzL(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 32:
                                obj2 = obj5;
                                zzafoVar.zzM(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 33:
                                obj2 = obj5;
                                zzafoVar.zzN(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 34:
                                obj2 = obj5;
                                zzafoVar.zzO(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 35:
                                obj2 = obj5;
                                zzafoVar.zzx(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 36:
                                obj2 = obj5;
                                zzafoVar.zzy(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 37:
                                obj2 = obj5;
                                zzafoVar.zzA(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 38:
                                obj2 = obj5;
                                zzafoVar.zzz(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 39:
                                obj2 = obj5;
                                zzafoVar.zzB(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 40:
                                obj2 = obj5;
                                zzafoVar.zzC(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 41:
                                obj2 = obj5;
                                zzafoVar.zzD(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 42:
                                obj2 = obj5;
                                zzafoVar.zzE(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 43:
                                obj2 = obj5;
                                zzafoVar.zzJ(zzaeo.zza(obj2, zzA & 1048575));
                                obj = obj2;
                                break;
                            case 44:
                                try {
                                    zza2 = zzaeo.zza(obj5, zzA & 1048575);
                                    zzafoVar.zzK(zza2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj2 = obj5;
                                }
                                try {
                                    obj6 = zzafq.zzF(obj5, zzb2, zza2, this.zzs(zzP), obj6, zzafzVar);
                                    obj2 = obj5;
                                } catch (zzaeg unused2) {
                                    obj2 = obj5;
                                    zzaffVar = this;
                                    if (obj6 == null) {
                                    }
                                    if (zzafzVar.zzk(obj6, zzafoVar, 0)) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj2 = obj5;
                                    th = th;
                                    zzaffVar = this;
                                    i = zzaffVar.zzk;
                                    obj3 = obj6;
                                    while (i < zzaffVar.zzl) {
                                    }
                                    zzafz zzafzVar2 = zzafzVar;
                                    if (obj3 != null) {
                                    }
                                    throw th;
                                }
                                obj = obj2;
                                break;
                            case 45:
                                zzafoVar.zzL(zzaeo.zza(obj5, zzA & 1048575));
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 46:
                                zzafoVar.zzM(zzaeo.zza(obj5, zzA & 1048575));
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 47:
                                zzafoVar.zzN(zzaeo.zza(obj5, zzA & 1048575));
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 48:
                                zzafoVar.zzO(zzaeo.zza(obj5, zzA & 1048575));
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 49:
                                zzafoVar.zzH(zzaeo.zza(obj5, zzA & 1048575), this.zzq(zzP), zzadfVar);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 50:
                                Object zzr = this.zzr(zzP);
                                long zzA2 = this.zzA(zzP) & 1048575;
                                Object zzm = zzagg.zzm(obj5, zzA2);
                                if (zzm == null) {
                                    zzm = zzaew.zza().zzc();
                                    zzagg.zzn(obj5, zzA2, zzm);
                                } else if (zzaex.zza(zzm)) {
                                    Object zzc = zzaew.zza().zzc();
                                    zzaex.zzb(zzc, zzm);
                                    zzagg.zzn(obj5, zzA2, zzc);
                                    zzm = zzc;
                                }
                                zzafoVar.zzP((zzaew) zzm, ((zzaev) zzr).zze(), zzadfVar);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                zzagg.zzn(obj5, zzA & 1048575, Double.valueOf(zzafoVar.zze()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                zzagg.zzn(obj5, zzA & 1048575, Float.valueOf(zzafoVar.zzf()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                zzagg.zzn(obj5, zzA & 1048575, Long.valueOf(zzafoVar.zzh()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                zzagg.zzn(obj5, zzA & 1048575, Long.valueOf(zzafoVar.zzg()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                zzagg.zzn(obj5, zzA & 1048575, Integer.valueOf(zzafoVar.zzi()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 56:
                                zzagg.zzn(obj5, zzA & 1048575, Long.valueOf(zzafoVar.zzj()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 57:
                                zzagg.zzn(obj5, zzA & 1048575, Integer.valueOf(zzafoVar.zzk()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 58:
                                zzagg.zzn(obj5, zzA & 1048575, Boolean.valueOf(zzafoVar.zzl()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 59:
                                this.zzz(obj5, zzA, zzafoVar);
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 60:
                                zzafc zzafcVar3 = (zzafc) this.zzv(obj5, zzb2, zzP);
                                zzafoVar.zzo(zzafcVar3, this.zzq(zzP), zzadfVar);
                                this.zzw(obj5, zzb2, zzP, zzafcVar3);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 61:
                                zzagg.zzn(obj5, zzA & 1048575, zzafoVar.zzq());
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case RectListKt.BitOffsetForGesturable /* 62 */:
                                zzagg.zzn(obj5, zzA & 1048575, Integer.valueOf(zzafoVar.zzr()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 63:
                                int zzs3 = zzafoVar.zzs();
                                zzadz zzs4 = this.zzs(zzP);
                                if (zzs4 != null && !zzs4.zza(zzs3)) {
                                    obj6 = zzafq.zzG(obj5, zzb2, zzs3, obj6, zzafzVar);
                                    obj = obj5;
                                    break;
                                }
                                zzagg.zzn(obj5, zzA & 1048575, Integer.valueOf(zzs3));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 64:
                                zzagg.zzn(obj5, zzA & 1048575, Integer.valueOf(zzafoVar.zzt()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                zzagg.zzn(obj5, zzA & 1048575, Long.valueOf(zzafoVar.zzu()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                zzagg.zzn(obj5, zzA & 1048575, Integer.valueOf(zzafoVar.zzv()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 67:
                                zzagg.zzn(obj5, zzA & 1048575, Long.valueOf(zzafoVar.zzw()));
                                this.zzO(obj5, zzb2, zzP);
                                obj2 = obj5;
                                obj = obj2;
                                break;
                            case 68:
                                try {
                                    zzafc zzafcVar4 = (zzafc) this.zzv(obj5, zzb2, zzP);
                                    zzafoVar.zzp(zzafcVar4, this.zzq(zzP), zzadfVar);
                                    this.zzw(obj5, zzb2, zzP, zzafcVar4);
                                    obj2 = obj5;
                                    obj = obj2;
                                    break;
                                } catch (Throwable th4) {
                                    th = th4;
                                    zzaffVar = this;
                                    obj2 = obj5;
                                    i = zzaffVar.zzk;
                                    obj3 = obj6;
                                    while (i < zzaffVar.zzl) {
                                    }
                                    zzafz zzafzVar22 = zzafzVar;
                                    if (obj3 != null) {
                                    }
                                    throw th;
                                }
                            default:
                                obj2 = obj5;
                                if (obj6 == null) {
                                    try {
                                        try {
                                            obj6 = zzafzVar.zzh(obj2);
                                        } catch (zzaeg unused3) {
                                            zzaffVar = this;
                                            if (obj6 == null) {
                                                try {
                                                    obj6 = zzafzVar.zzh(obj2);
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    th = th;
                                                    i = zzaffVar.zzk;
                                                    obj3 = obj6;
                                                    while (i < zzaffVar.zzl) {
                                                    }
                                                    zzafz zzafzVar222 = zzafzVar;
                                                    if (obj3 != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                            if (zzafzVar.zzk(obj6, zzafoVar, 0)) {
                                                obj4 = obj6;
                                                for (int i2 = zzaffVar.zzk; i2 < zzaffVar.zzl; i2++) {
                                                    zzafz zzafzVar3 = zzafzVar;
                                                    obj4 = zzaffVar.zzx(obj2, zzaffVar.zzj[i2], obj4, zzafzVar3, obj2);
                                                    zzafzVar = zzafzVar3;
                                                }
                                                if (obj4 == null) {
                                                }
                                            } else {
                                                this = zzaffVar;
                                                obj = obj2;
                                            }
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        th = th;
                                        zzaffVar = this;
                                        i = zzaffVar.zzk;
                                        obj3 = obj6;
                                        while (i < zzaffVar.zzl) {
                                            zzafz zzafzVar4 = zzafzVar;
                                            obj3 = zzaffVar.zzx(obj2, zzaffVar.zzj[i], obj3, zzafzVar4, obj2);
                                            i++;
                                            zzafzVar = zzafzVar4;
                                        }
                                        zzafz zzafzVar2222 = zzafzVar;
                                        if (obj3 != null) {
                                            zzafzVar2222.zzi(obj2, obj3);
                                        }
                                        throw th;
                                    }
                                }
                                try {
                                    if (!zzafzVar.zzk(obj6, zzafoVar, 0)) {
                                        obj4 = obj6;
                                        for (int i3 = this.zzk; i3 < this.zzl; i3++) {
                                            zzafz zzafzVar5 = zzafzVar;
                                            obj4 = this.zzx(obj2, this.zzj[i3], obj4, zzafzVar5, obj2);
                                            zzafzVar = zzafzVar5;
                                        }
                                    }
                                    obj = obj2;
                                } catch (Throwable th7) {
                                    th = th7;
                                    zzaffVar = this;
                                    th = th;
                                    i = zzaffVar.zzk;
                                    obj3 = obj6;
                                    while (i < zzaffVar.zzl) {
                                    }
                                    zzafz zzafzVar22222 = zzafzVar;
                                    if (obj3 != null) {
                                    }
                                    throw th;
                                }
                                break;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        zzaffVar = this;
                        obj2 = obj5;
                    }
                } else if (zzb2 == Integer.MAX_VALUE) {
                    int i4 = this.zzk;
                    obj4 = obj6;
                    while (i4 < this.zzl) {
                        zzafz zzafzVar6 = zzafzVar;
                        zzaff<T> zzaffVar2 = this;
                        Object obj7 = obj;
                        obj4 = zzaffVar2.zzx(obj7, this.zzj[i4], obj4, zzafzVar6, obj);
                        zzafzVar = zzafzVar6;
                        i4++;
                        obj = obj7;
                        this = zzaffVar2;
                    }
                    obj2 = obj;
                } else {
                    zzaffVar = this;
                    Object obj8 = obj;
                    try {
                        if ((!zzaffVar.zzh ? null : zzadfVar.zzc(zzaffVar.zzg, zzb2)) != null) {
                            obj5 = obj8;
                            this = zzaffVar;
                            zzadr zzadrVar = (zzadr) obj5;
                            throw null;
                        }
                        if (obj6 == null) {
                            try {
                                obj6 = zzafzVar.zzh(obj8);
                            } catch (Throwable th9) {
                                th = th9;
                                obj2 = obj8;
                                i = zzaffVar.zzk;
                                obj3 = obj6;
                                while (i < zzaffVar.zzl) {
                                }
                                zzafz zzafzVar222222 = zzafzVar;
                                if (obj3 != null) {
                                }
                                throw th;
                            }
                        }
                        if (zzafzVar.zzk(obj6, zzafoVar, 0)) {
                            obj5 = obj8;
                            this = zzaffVar;
                            obj = obj5;
                        } else {
                            int i5 = zzaffVar.zzk;
                            obj4 = obj6;
                            while (i5 < zzaffVar.zzl) {
                                zzafz zzafzVar7 = zzafzVar;
                                Object obj9 = obj8;
                                obj4 = zzaffVar.zzx(obj9, zzaffVar.zzj[i5], obj4, zzafzVar7, obj8);
                                zzafzVar = zzafzVar7;
                                i5++;
                                obj8 = obj9;
                            }
                            obj2 = obj8;
                        }
                    } catch (Throwable th10) {
                        obj5 = obj8;
                        th = th10;
                        obj2 = obj5;
                        i = zzaffVar.zzk;
                        obj3 = obj6;
                        while (i < zzaffVar.zzl) {
                        }
                        zzafz zzafzVar2222222 = zzafzVar;
                        if (obj3 != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                zzaffVar = this;
                obj2 = obj;
            }
        }
        if (obj4 == null) {
            zzafzVar.zzi(obj2, obj4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:449:0x0aa6, code lost:
        throw new com.google.android.gms.internal.measurement.zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x0d77, code lost:
        if (r14 == r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0d79, code lost:
        r12.putInt(r8, r14, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0d7d, code lost:
        r11 = r34.zzk;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0d84, code lost:
        if (r11 >= r34.zzl) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:551:0x0d86, code lost:
        r1 = r34.zzj;
        r4 = r34.zzm;
        r2 = r1[r11];
        r1 = r8;
        r3 = (com.google.android.gms.internal.measurement.zzaga) zzx(r1, r2, r3, r4, r35);
        r11 = r11 + 1;
        r8 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:552:0x0d9b, code lost:
        r13 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x0d9c, code lost:
        if (r3 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x0d9e, code lost:
        r34.zzm.zzi(r13, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x0da3, code lost:
        if (r10 != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x0da5, code lost:
        if (r6 != r7) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:559:0x0daf, code lost:
        throw new com.google.android.gms.internal.measurement.zzaeh(r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x0db0, code lost:
        r13 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:561:0x0db2, code lost:
        if (r6 > r7) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0db4, code lost:
        if (r9 != r10) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0db6, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:565:0x0dbc, code lost:
        throw new com.google.android.gms.internal.measurement.zzaeh(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0671  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:188:0x0552 -> B:189:0x0553). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:222:0x0617 -> B:223:0x0618). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:242:0x066d -> B:243:0x066f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzi(Object obj, byte[] bArr, int i, int i2, int i3, zzacg zzacgVar) throws IOException {
        int i4;
        Unsafe unsafe;
        int i5;
        String str;
        Object obj2;
        int i6;
        int i7;
        int i8;
        int zzP;
        int i9;
        zzacg zzacgVar2;
        int i10;
        int i11;
        int i12;
        Object obj3;
        byte[] bArr2;
        int i13;
        int i14;
        int i15;
        zzacg zzacgVar3;
        Unsafe unsafe2;
        int i16;
        int i17;
        int i18;
        byte[] bArr3;
        Unsafe unsafe3;
        int i19;
        int i20;
        int i21;
        int i22;
        long j;
        int i23;
        int i24;
        byte[] bArr4;
        zzacg zzacgVar4;
        int i25;
        int i26;
        int zza2;
        int i27;
        zzacg zzacgVar5;
        int zzm;
        int i28;
        Object obj4;
        byte[] bArr5;
        zzaef zzaefVar;
        int zzl;
        int i29;
        byte[] bArr6;
        int zza3;
        int i30;
        int i31;
        byte[] bArr7;
        int i32;
        int i33;
        int i34;
        int zzg;
        zzacg zzacgVar6;
        String str2;
        Object obj5;
        int i35;
        Object obj6;
        zzacg zzacgVar7;
        Object obj7 = obj;
        byte[] bArr8 = bArr;
        int i36 = i2;
        zzacg zzacgVar8 = zzacgVar;
        zzF(obj7);
        Unsafe unsafe4 = zzb;
        int i37 = i;
        int i38 = -1;
        int i39 = 0;
        int i40 = 0;
        int i41 = 1048575;
        int i42 = 0;
        while (true) {
            if (i37 < i36) {
                int i43 = i37 + 1;
                int i44 = bArr8[i37];
                if (i44 < 0) {
                    i43 = zzach.zzb(i44, bArr8, i43, zzacgVar8);
                    i44 = zzacgVar8.zza;
                }
                int i45 = i43;
                int i46 = i44;
                i37 = i45;
                int i47 = i46 >>> 3;
                if (i47 > i38) {
                    zzP = (i47 < this.zze || i47 > this.zzf) ? -1 : zzQ(i47, i39 / 3);
                } else {
                    zzP = zzP(i47);
                }
                if (zzP == -1) {
                    unsafe = unsafe4;
                    obj2 = obj7;
                    i9 = i46;
                    zzacgVar2 = zzacgVar8;
                    str = "Failed to parse the message.";
                    i10 = i47;
                    i11 = 0;
                    i4 = i3;
                } else {
                    int i48 = i46 & 7;
                    int[] iArr = this.zzc;
                    int i49 = zzP;
                    int i50 = iArr[zzP + 1];
                    int zzC = zzC(i50);
                    int i51 = i47;
                    long j2 = i50 & 1048575;
                    if (zzC <= 17) {
                        int i52 = iArr[i49 + 2];
                        int i53 = 1 << (i52 >>> 20);
                        int i54 = i52 & 1048575;
                        if (i54 != i41) {
                            int i55 = 1048575;
                            if (i41 != 1048575) {
                                unsafe4.putInt(obj7, i41, i42);
                                i55 = 1048575;
                            }
                            i42 = i54 == i55 ? 0 : unsafe4.getInt(obj7, i54);
                            i41 = i54;
                        }
                        switch (zzC) {
                            case 0:
                                obj3 = obj7;
                                bArr2 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                zzacgVar3 = zzacgVar;
                                unsafe2 = unsafe4;
                                i16 = i42;
                                if (i48 != 1) {
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i17 = i37 + 8;
                                    i42 = i16 | i53;
                                    zzagg.zzl(obj3, j2, Double.longBitsToDouble(zzach.zze(bArr2, i37)));
                                    byte[] bArr9 = bArr2;
                                    zzacgVar8 = zzacgVar3;
                                    bArr8 = bArr9;
                                    i36 = i2;
                                    i37 = i17;
                                    i39 = i15;
                                    i40 = i14;
                                    obj7 = obj3;
                                    unsafe4 = unsafe2;
                                    i38 = i51;
                                    i41 = i13;
                                    break;
                                }
                            case 1:
                                obj3 = obj7;
                                bArr2 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                zzacgVar3 = zzacgVar;
                                unsafe2 = unsafe4;
                                i16 = i42;
                                if (i48 != 5) {
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i17 = i37 + 4;
                                    i42 = i16 | i53;
                                    zzagg.zzj(obj3, j2, Float.intBitsToFloat(zzach.zzd(bArr2, i37)));
                                    byte[] bArr92 = bArr2;
                                    zzacgVar8 = zzacgVar3;
                                    bArr8 = bArr92;
                                    i36 = i2;
                                    i37 = i17;
                                    i39 = i15;
                                    i40 = i14;
                                    obj7 = obj3;
                                    unsafe4 = unsafe2;
                                    i38 = i51;
                                    i41 = i13;
                                    break;
                                }
                            case 2:
                            case 3:
                                byte[] bArr10 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                i16 = i42;
                                if (i48 != 0) {
                                    unsafe2 = unsafe4;
                                    obj3 = obj7;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    int zzc = zzach.zzc(bArr10, i37, zzacgVar);
                                    unsafe4.putLong(obj7, j2, zzacgVar.zzb);
                                    zzacgVar8 = zzacgVar;
                                    bArr8 = bArr10;
                                    i41 = i13;
                                    i42 = i16 | i53;
                                    i39 = i15;
                                    i37 = zzc;
                                    i40 = i14;
                                    i38 = i51;
                                    i36 = i2;
                                    break;
                                }
                            case 4:
                            case 11:
                                byte[] bArr11 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                i16 = i42;
                                if (i48 != 0) {
                                    unsafe2 = unsafe4;
                                    obj3 = obj7;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i18 = i16 | i53;
                                    i37 = zzach.zza(bArr11, i37, zzacgVar);
                                    unsafe4.putInt(obj7, j2, zzacgVar.zza);
                                    bArr3 = bArr11;
                                    zzacgVar8 = zzacgVar;
                                    bArr8 = bArr3;
                                    i41 = i13;
                                    i36 = i2;
                                    i42 = i18;
                                    i39 = i15;
                                    i40 = i14;
                                    i38 = i51;
                                    break;
                                }
                            case 5:
                            case 14:
                                byte[] bArr12 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                Unsafe unsafe5 = unsafe4;
                                i16 = i42;
                                if (i48 != 1) {
                                    unsafe4 = unsafe5;
                                    unsafe2 = unsafe4;
                                    obj3 = obj7;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    unsafe4 = unsafe5;
                                    unsafe4.putLong(obj7, j2, zzach.zze(bArr12, i37));
                                    zzacgVar8 = zzacgVar;
                                    bArr8 = bArr12;
                                    i41 = i13;
                                    i37 += 8;
                                    i39 = i15;
                                    i42 = i16 | i53;
                                    i40 = i14;
                                    i38 = i51;
                                    i36 = i2;
                                    break;
                                }
                            case 6:
                            case 13:
                                byte[] bArr13 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                unsafe3 = unsafe4;
                                i16 = i42;
                                if (i48 != 5) {
                                    obj3 = obj7;
                                    unsafe2 = unsafe3;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i19 = i16 | i53;
                                    unsafe3.putInt(obj7, j2, zzach.zzd(bArr13, i37));
                                    zzacgVar8 = zzacgVar;
                                    unsafe4 = unsafe3;
                                    bArr8 = bArr13;
                                    i41 = i13;
                                    i36 = i2;
                                    i37 += 4;
                                    i42 = i19;
                                    i39 = i15;
                                    i40 = i14;
                                    i38 = i51;
                                    break;
                                }
                            case 7:
                                byte[] bArr14 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                unsafe3 = unsafe4;
                                i16 = i42;
                                if (i48 != 0) {
                                    obj3 = obj7;
                                    unsafe2 = unsafe3;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i18 = i16 | i53;
                                    i37 = zzach.zzc(bArr14, i37, zzacgVar);
                                    zzagg.zzh(obj7, j2, zzacgVar.zzb != 0);
                                    bArr3 = bArr14;
                                    zzacgVar8 = zzacgVar;
                                    unsafe4 = unsafe3;
                                    bArr8 = bArr3;
                                    i41 = i13;
                                    i36 = i2;
                                    i42 = i18;
                                    i39 = i15;
                                    i40 = i14;
                                    i38 = i51;
                                    break;
                                }
                            case 8:
                                byte[] bArr15 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                unsafe3 = unsafe4;
                                i16 = i42;
                                if (i48 != 2) {
                                    obj3 = obj7;
                                    unsafe2 = unsafe3;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    if (zzD(i50)) {
                                        i37 = zzach.zzf(bArr15, i37, zzacgVar);
                                        i19 = i16 | i53;
                                    } else {
                                        i37 = zzach.zza(bArr15, i37, zzacgVar);
                                        int i56 = zzacgVar.zza;
                                        if (i56 < 0) {
                                            throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        i19 = i16 | i53;
                                        if (i56 != 0) {
                                            zzacgVar.zzc = new String(bArr15, i37, i56, StandardCharsets.UTF_8);
                                            i37 += i56;
                                        } else {
                                            zzacgVar.zzc = "";
                                        }
                                    }
                                    unsafe3.putObject(obj7, j2, zzacgVar.zzc);
                                    zzacgVar8 = zzacgVar;
                                    unsafe4 = unsafe3;
                                    bArr8 = bArr15;
                                    i41 = i13;
                                    i36 = i2;
                                    i42 = i19;
                                    i39 = i15;
                                    i40 = i14;
                                    i38 = i51;
                                    break;
                                }
                            case 9:
                                obj3 = obj7;
                                i13 = i41;
                                int i57 = i42;
                                i14 = i46;
                                i15 = i49;
                                if (i48 != 2) {
                                    unsafe3 = unsafe4;
                                    i16 = i57;
                                    unsafe2 = unsafe3;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i42 = i57 | i53;
                                    Unsafe unsafe6 = unsafe4;
                                    Object zzt = zzt(obj3, i15);
                                    byte[] bArr16 = bArr8;
                                    int zzj = zzach.zzj(zzt, zzq(i15), bArr16, i37, i2, zzacgVar);
                                    zzu(obj3, i15, zzt);
                                    zzacgVar8 = zzacgVar;
                                    unsafe4 = unsafe6;
                                    bArr8 = bArr16;
                                    i41 = i13;
                                    i36 = i2;
                                    i37 = zzj;
                                    i39 = i15;
                                    i40 = i14;
                                    obj7 = obj3;
                                    i38 = i51;
                                    break;
                                }
                            case 10:
                                zzacgVar8 = zzacgVar;
                                obj3 = obj7;
                                i13 = i41;
                                i20 = i42;
                                i14 = i46;
                                i15 = i49;
                                if (i48 != 2) {
                                    unsafe2 = unsafe4;
                                    i16 = i20;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i20 |= i53;
                                    i37 = zzach.zzg(bArr8, i37, zzacgVar8);
                                    unsafe4.putObject(obj3, j2, zzacgVar8.zzc);
                                    i41 = i13;
                                    i36 = i2;
                                    i42 = i20;
                                    i39 = i15;
                                    i40 = i14;
                                    obj7 = obj3;
                                    i38 = i51;
                                    break;
                                }
                            case 12:
                                zzacgVar8 = zzacgVar;
                                obj3 = obj7;
                                i13 = i41;
                                i20 = i42;
                                i14 = i46;
                                i15 = i49;
                                if (i48 != 0) {
                                    unsafe2 = unsafe4;
                                    i16 = i20;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i37 = zzach.zza(bArr8, i37, zzacgVar8);
                                    int i58 = zzacgVar8.zza;
                                    zzadz zzs = zzs(i15);
                                    if ((i50 & Integer.MIN_VALUE) == 0 || zzs == null || zzs.zza(i58)) {
                                        i20 |= i53;
                                        unsafe4.putInt(obj3, j2, i58);
                                    } else {
                                        zzh(obj3).zzk(i14, Long.valueOf(i58));
                                    }
                                    i41 = i13;
                                    i36 = i2;
                                    i42 = i20;
                                    i39 = i15;
                                    i40 = i14;
                                    obj7 = obj3;
                                    i38 = i51;
                                    break;
                                }
                            case 15:
                                zzacgVar8 = zzacgVar;
                                obj3 = obj7;
                                i13 = i41;
                                i20 = i42;
                                i14 = i46;
                                i15 = i49;
                                if (i48 != 0) {
                                    unsafe2 = unsafe4;
                                    i16 = i20;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i20 |= i53;
                                    i37 = zzach.zza(bArr8, i37, zzacgVar8);
                                    unsafe4.putInt(obj3, j2, zzacv.zzR(zzacgVar8.zza));
                                    i41 = i13;
                                    i36 = i2;
                                    i42 = i20;
                                    i39 = i15;
                                    i40 = i14;
                                    obj7 = obj3;
                                    i38 = i51;
                                    break;
                                }
                            case 16:
                                if (i48 != 0) {
                                    i14 = i46;
                                    i15 = i49;
                                    obj3 = obj7;
                                    i13 = i41;
                                    i16 = i42;
                                    unsafe2 = unsafe4;
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i42 |= i53;
                                    zzacgVar8 = zzacgVar;
                                    int zzc2 = zzach.zzc(bArr8, i37, zzacgVar8);
                                    i14 = i46;
                                    unsafe4.putLong(obj7, j2, zzacv.zzS(zzacgVar8.zzb));
                                    i37 = zzc2;
                                    i39 = i49;
                                    i40 = i14;
                                    i38 = i51;
                                    i36 = i2;
                                    break;
                                }
                            default:
                                obj3 = obj7;
                                byte[] bArr17 = bArr8;
                                i13 = i41;
                                i14 = i46;
                                i15 = i49;
                                unsafe2 = unsafe4;
                                i16 = i42;
                                if (i48 != 3) {
                                    bArr8 = bArr;
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar;
                                    i11 = i15;
                                    str = "Failed to parse the message.";
                                    i9 = i14;
                                    obj2 = obj3;
                                    unsafe = unsafe2;
                                    i42 = i16;
                                    i10 = i51;
                                    i41 = i13;
                                    break;
                                } else {
                                    i42 = i16 | i53;
                                    Object zzt2 = zzt(obj3, i15);
                                    int zzk = zzach.zzk(zzt2, zzq(i15), bArr17, i37, i2, (i51 << 3) | 4, zzacgVar);
                                    zzu(obj3, i15, zzt2);
                                    bArr8 = bArr;
                                    i36 = i2;
                                    zzacgVar8 = zzacgVar;
                                    i37 = zzk;
                                    i39 = i15;
                                    i40 = i14;
                                    obj7 = obj3;
                                    unsafe4 = unsafe2;
                                    i38 = i51;
                                    i41 = i13;
                                    break;
                                }
                        }
                    } else {
                        Unsafe unsafe7 = unsafe4;
                        Object obj8 = obj7;
                        if (zzC != 27) {
                            str = "Failed to parse the message.";
                            int i59 = i46;
                            i21 = i42;
                            int i60 = i37;
                            unsafe = unsafe7;
                            i22 = i41;
                            if (zzC <= 49) {
                                long j3 = i50;
                                zzaef zzaefVar2 = (zzaef) unsafe.getObject(obj8, j2);
                                if (zzaefVar2.zza()) {
                                    j = j3;
                                } else {
                                    int size = zzaefVar2.size();
                                    j = j3;
                                    zzaefVar2 = zzaefVar2.zzg(size + size);
                                    unsafe.putObject(obj8, j2, zzaefVar2);
                                }
                                switch (zzC) {
                                    case 18:
                                    case 35:
                                        i23 = i59;
                                        i24 = i60;
                                        zzaef zzaefVar3 = zzaefVar2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 != 2) {
                                            if (i48 == 1) {
                                                i26 = i24 + 8;
                                                int i61 = zzach.zza;
                                                zzadc zzadcVar = (zzadc) zzaefVar3;
                                                zzadcVar.zzf(Double.longBitsToDouble(zzach.zze(bArr4, i24)));
                                                while (i26 < i2) {
                                                    int zza4 = zzach.zza(bArr4, i26, zzacgVar4);
                                                    if (i23 == zzacgVar4.zza) {
                                                        zzadcVar.zzf(Double.longBitsToDouble(zzach.zze(bArr4, zza4)));
                                                        i26 = zza4 + 8;
                                                    } else {
                                                        zza2 = i26;
                                                        i27 = i24;
                                                        zzacgVar5 = zzacgVar4;
                                                        bArr5 = bArr4;
                                                    }
                                                }
                                                zza2 = i26;
                                                i27 = i24;
                                                zzacgVar5 = zzacgVar4;
                                                bArr5 = bArr4;
                                            }
                                            i27 = i24;
                                            zzacgVar5 = zzacgVar4;
                                            bArr5 = bArr4;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int i62 = zzach.zza;
                                            zzadc zzadcVar2 = (zzadc) zzaefVar3;
                                            zza2 = zzach.zza(bArr4, i24, zzacgVar4);
                                            int i63 = zzacgVar4.zza;
                                            int i64 = zza2 + i63;
                                            if (i64 <= bArr4.length) {
                                                zzadcVar2.zzh(zzadcVar2.size() + (i63 / 8));
                                                while (zza2 < i64) {
                                                    zzadcVar2.zzf(Double.longBitsToDouble(zzach.zze(bArr4, zza2)));
                                                    zza2 += 8;
                                                }
                                                if (zza2 != i64) {
                                                    throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i27 = i24;
                                                zzacgVar5 = zzacgVar4;
                                                bArr5 = bArr4;
                                                break;
                                            } else {
                                                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                    case 19:
                                    case 36:
                                        i23 = i59;
                                        i24 = i60;
                                        zzaef zzaefVar4 = zzaefVar2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 != 2) {
                                            if (i48 == 5) {
                                                i26 = i24 + 4;
                                                int i65 = zzach.zza;
                                                zzadm zzadmVar = (zzadm) zzaefVar4;
                                                zzadmVar.zzf(Float.intBitsToFloat(zzach.zzd(bArr4, i24)));
                                                while (i26 < i2) {
                                                    int zza5 = zzach.zza(bArr4, i26, zzacgVar4);
                                                    if (i23 == zzacgVar4.zza) {
                                                        zzadmVar.zzf(Float.intBitsToFloat(zzach.zzd(bArr4, zza5)));
                                                        i26 = zza5 + 4;
                                                    } else {
                                                        zza2 = i26;
                                                        i27 = i24;
                                                        zzacgVar5 = zzacgVar4;
                                                        bArr5 = bArr4;
                                                    }
                                                }
                                                zza2 = i26;
                                                i27 = i24;
                                                zzacgVar5 = zzacgVar4;
                                                bArr5 = bArr4;
                                            }
                                            i27 = i24;
                                            zzacgVar5 = zzacgVar4;
                                            bArr5 = bArr4;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int i66 = zzach.zza;
                                            zzadm zzadmVar2 = (zzadm) zzaefVar4;
                                            zza2 = zzach.zza(bArr4, i24, zzacgVar4);
                                            int i67 = zzacgVar4.zza;
                                            int i68 = zza2 + i67;
                                            if (i68 <= bArr4.length) {
                                                zzadmVar2.zzh(zzadmVar2.size() + (i67 / 4));
                                                while (zza2 < i68) {
                                                    zzadmVar2.zzf(Float.intBitsToFloat(zzach.zzd(bArr4, zza2)));
                                                    zza2 += 4;
                                                }
                                                if (zza2 != i68) {
                                                    throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i27 = i24;
                                                zzacgVar5 = zzacgVar4;
                                                bArr5 = bArr4;
                                                break;
                                            } else {
                                                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i23 = i59;
                                        i24 = i60;
                                        zzaef zzaefVar5 = zzaefVar2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 != 2) {
                                            if (i48 == 0) {
                                                int i69 = zzach.zza;
                                                zzaeq zzaeqVar = (zzaeq) zzaefVar5;
                                                zza2 = zzach.zzc(bArr4, i24, zzacgVar4);
                                                zzaeqVar.zzf(zzacgVar4.zzb);
                                                while (zza2 < i2) {
                                                    int zza6 = zzach.zza(bArr4, zza2, zzacgVar4);
                                                    if (i23 == zzacgVar4.zza) {
                                                        zza2 = zzach.zzc(bArr4, zza6, zzacgVar4);
                                                        zzaeqVar.zzf(zzacgVar4.zzb);
                                                    }
                                                }
                                            }
                                            i27 = i24;
                                            zzacgVar5 = zzacgVar4;
                                            bArr5 = bArr4;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int i70 = zzach.zza;
                                            zzaeq zzaeqVar2 = (zzaeq) zzaefVar5;
                                            zza2 = zzach.zza(bArr4, i24, zzacgVar4);
                                            int i71 = zzacgVar4.zza + zza2;
                                            while (zza2 < i71) {
                                                zza2 = zzach.zzc(bArr4, zza2, zzacgVar4);
                                                zzaeqVar2.zzf(zzacgVar4.zzb);
                                            }
                                            if (zza2 != i71) {
                                                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i27 = i24;
                                        zzacgVar5 = zzacgVar4;
                                        bArr5 = bArr4;
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        zzaef zzaefVar6 = zzaefVar2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 != 2) {
                                            if (i48 != 0) {
                                                i23 = i59;
                                                i24 = i60;
                                                i27 = i24;
                                                zzacgVar5 = zzacgVar4;
                                                bArr5 = bArr4;
                                                zza2 = i27;
                                                break;
                                            } else {
                                                zza2 = zzach.zzl(i59, bArr4, i60, i2, zzaefVar6, zzacgVar4);
                                                i23 = i59;
                                                i27 = i60;
                                                zzacgVar5 = zzacgVar4;
                                                bArr5 = bArr4;
                                            }
                                        } else {
                                            zzm = zzach.zzm(bArr4, i60, zzaefVar6, zzacgVar4);
                                            zza2 = zzm;
                                            zzacgVar5 = zzacgVar4;
                                            i27 = i60;
                                            i23 = i59;
                                            bArr5 = bArr4;
                                            break;
                                        }
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        zzaef zzaefVar7 = zzaefVar2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 != 2) {
                                            if (i48 == 1) {
                                                zzm = i60 + 8;
                                                int i72 = zzach.zza;
                                                zzaeq zzaeqVar3 = (zzaeq) zzaefVar7;
                                                zzaeqVar3.zzf(zzach.zze(bArr4, i60));
                                                while (zzm < i2) {
                                                    int zza7 = zzach.zza(bArr4, zzm, zzacgVar4);
                                                    if (i59 == zzacgVar4.zza) {
                                                        zzaeqVar3.zzf(zzach.zze(bArr4, zza7));
                                                        zzm = zza7 + 8;
                                                    } else {
                                                        zza2 = zzm;
                                                        zzacgVar5 = zzacgVar4;
                                                        i27 = i60;
                                                        i23 = i59;
                                                        bArr5 = bArr4;
                                                    }
                                                }
                                                zza2 = zzm;
                                                zzacgVar5 = zzacgVar4;
                                                i27 = i60;
                                                i23 = i59;
                                                bArr5 = bArr4;
                                            }
                                            zzacgVar5 = zzacgVar4;
                                            i27 = i60;
                                            i23 = i59;
                                            bArr5 = bArr4;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int i73 = zzach.zza;
                                            zzaeq zzaeqVar4 = (zzaeq) zzaefVar7;
                                            zza2 = zzach.zza(bArr4, i60, zzacgVar4);
                                            int i74 = zzacgVar4.zza;
                                            int i75 = zza2 + i74;
                                            if (i75 <= bArr4.length) {
                                                zzaeqVar4.zzh(zzaeqVar4.size() + (i74 / 8));
                                                while (zza2 < i75) {
                                                    zzaeqVar4.zzf(zzach.zze(bArr4, zza2));
                                                    zza2 += 8;
                                                }
                                                if (zza2 != i75) {
                                                    throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzacgVar5 = zzacgVar4;
                                                i27 = i60;
                                                i23 = i59;
                                                bArr5 = bArr4;
                                                break;
                                            } else {
                                                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        zzaef zzaefVar8 = zzaefVar2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 != 2) {
                                            if (i48 == 5) {
                                                zzm = i60 + 4;
                                                int i76 = zzach.zza;
                                                zzadv zzadvVar = (zzadv) zzaefVar8;
                                                zzadvVar.zzh(zzach.zzd(bArr4, i60));
                                                while (zzm < i2) {
                                                    int zza8 = zzach.zza(bArr4, zzm, zzacgVar4);
                                                    if (i59 == zzacgVar4.zza) {
                                                        zzadvVar.zzh(zzach.zzd(bArr4, zza8));
                                                        zzm = zza8 + 4;
                                                    } else {
                                                        zza2 = zzm;
                                                        zzacgVar5 = zzacgVar4;
                                                        i27 = i60;
                                                        i23 = i59;
                                                        bArr5 = bArr4;
                                                    }
                                                }
                                                zza2 = zzm;
                                                zzacgVar5 = zzacgVar4;
                                                i27 = i60;
                                                i23 = i59;
                                                bArr5 = bArr4;
                                            }
                                            zzacgVar5 = zzacgVar4;
                                            i27 = i60;
                                            i23 = i59;
                                            bArr5 = bArr4;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int i77 = zzach.zza;
                                            zzadv zzadvVar2 = (zzadv) zzaefVar8;
                                            zza2 = zzach.zza(bArr4, i60, zzacgVar4);
                                            int i78 = zzacgVar4.zza;
                                            int i79 = zza2 + i78;
                                            if (i79 <= bArr4.length) {
                                                zzadvVar2.zzi(zzadvVar2.size() + (i78 / 4));
                                                while (zza2 < i79) {
                                                    zzadvVar2.zzh(zzach.zzd(bArr4, zza2));
                                                    zza2 += 4;
                                                }
                                                if (zza2 != i79) {
                                                    throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                zzacgVar5 = zzacgVar4;
                                                i27 = i60;
                                                i23 = i59;
                                                bArr5 = bArr4;
                                                break;
                                            } else {
                                                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                    case 25:
                                    case 42:
                                        zzaef zzaefVar9 = zzaefVar2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 != 2) {
                                            if (i48 == 0) {
                                                int i80 = zzach.zza;
                                                zzaci zzaciVar = (zzaci) zzaefVar9;
                                                zza2 = zzach.zzc(bArr4, i60, zzacgVar4);
                                                zzaciVar.zzf(zzacgVar4.zzb != 0);
                                                while (zza2 < i2) {
                                                    int zza9 = zzach.zza(bArr4, zza2, zzacgVar4);
                                                    if (i59 == zzacgVar4.zza) {
                                                        zza2 = zzach.zzc(bArr4, zza9, zzacgVar4);
                                                        zzaciVar.zzf(zzacgVar4.zzb != 0);
                                                    }
                                                }
                                            }
                                            zzacgVar5 = zzacgVar4;
                                            i27 = i60;
                                            i23 = i59;
                                            bArr5 = bArr4;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int i81 = zzach.zza;
                                            zzaci zzaciVar2 = (zzaci) zzaefVar9;
                                            zza2 = zzach.zza(bArr4, i60, zzacgVar4);
                                            int i82 = zzacgVar4.zza + zza2;
                                            while (zza2 < i82) {
                                                zza2 = zzach.zzc(bArr4, zza2, zzacgVar4);
                                                zzaciVar2.zzf(zzacgVar4.zzb != 0);
                                            }
                                            if (zza2 != i82) {
                                                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        zzacgVar5 = zzacgVar4;
                                        i27 = i60;
                                        i23 = i59;
                                        bArr5 = bArr4;
                                        break;
                                    case 26:
                                        zzaef zzaefVar10 = zzaefVar2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 != 2) {
                                            i51 = i51;
                                            zzacgVar5 = zzacgVar4;
                                            i27 = i60;
                                            i23 = i59;
                                            bArr5 = bArr4;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            if ((j & 536870912) == 0) {
                                                zza2 = zzach.zza(bArr4, i60, zzacgVar4);
                                                int i83 = zzacgVar4.zza;
                                                if (i83 < 0) {
                                                    throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i83 == 0) {
                                                    obj4 = "";
                                                    zzaefVar10.add(obj4);
                                                    i51 = i51;
                                                    while (zza2 < i2) {
                                                        int zza10 = zzach.zza(bArr4, zza2, zzacgVar4);
                                                        if (i59 == zzacgVar4.zza) {
                                                            zza2 = zzach.zza(bArr4, zza10, zzacgVar4);
                                                            i83 = zzacgVar4.zza;
                                                            if (i83 < 0) {
                                                                throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i83 == 0) {
                                                                zzaefVar10.add(obj4);
                                                            } else {
                                                                zzaefVar10.add(new String(bArr4, zza2, i83, StandardCharsets.UTF_8));
                                                                zza2 += i83;
                                                                while (zza2 < i2) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    obj4 = "";
                                                    i51 = i51;
                                                    zzaefVar10.add(new String(bArr4, zza2, i83, StandardCharsets.UTF_8));
                                                    zza2 += i83;
                                                    while (zza2 < i2) {
                                                    }
                                                }
                                            } else {
                                                i51 = i51;
                                                zza2 = zzach.zza(bArr4, i60, zzacgVar4);
                                                int i84 = zzacgVar4.zza;
                                                if (i84 < 0) {
                                                    throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i84 == 0) {
                                                    zzaefVar10.add("");
                                                    while (zza2 < i2) {
                                                        int zza11 = zzach.zza(bArr4, zza2, zzacgVar4);
                                                        if (i59 == zzacgVar4.zza) {
                                                            zza2 = zzach.zza(bArr4, zza11, zzacgVar4);
                                                            int i85 = zzacgVar4.zza;
                                                            if (i85 < 0) {
                                                                throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i85 == 0) {
                                                                zzaefVar10.add("");
                                                            } else {
                                                                int i86 = zza2 + i85;
                                                                if (zzagl.zza(bArr4, zza2, i86)) {
                                                                    i28 = i86;
                                                                    zzaefVar10.add(new String(bArr4, zza2, i85, StandardCharsets.UTF_8));
                                                                    zza2 = i28;
                                                                    while (zza2 < i2) {
                                                                    }
                                                                } else {
                                                                    throw new zzaeh("Protocol message had invalid UTF-8.");
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    int i87 = zza2 + i84;
                                                    if (zzagl.zza(bArr4, zza2, i87)) {
                                                        i28 = i87;
                                                        zzaefVar10.add(new String(bArr4, zza2, i84, StandardCharsets.UTF_8));
                                                        zza2 = i28;
                                                        while (zza2 < i2) {
                                                        }
                                                    } else {
                                                        throw new zzaeh("Protocol message had invalid UTF-8.");
                                                    }
                                                }
                                            }
                                            zzacgVar5 = zzacgVar4;
                                            i27 = i60;
                                            i23 = i59;
                                            bArr5 = bArr4;
                                            break;
                                        }
                                    case 27:
                                        zzaef zzaefVar11 = zzaefVar2;
                                        if (i48 != 2) {
                                            bArr4 = bArr;
                                            i59 = i59;
                                            obj2 = obj;
                                            i25 = i49;
                                            i51 = i51;
                                            i27 = i60;
                                            zzacgVar5 = zzacgVar;
                                            i23 = i59;
                                            bArr5 = bArr4;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            i25 = i49;
                                            obj2 = obj;
                                            int zzn = zzach.zzn(zzq(i49), i59, bArr, i60, i2, zzaefVar11, zzacgVar);
                                            i59 = i59;
                                            bArr4 = bArr;
                                            i60 = i60;
                                            zza2 = zzn;
                                            zzacgVar5 = zzacgVar;
                                            i51 = i51;
                                            i27 = i60;
                                            i23 = i59;
                                            bArr5 = bArr4;
                                            break;
                                        }
                                    case 28:
                                        zzaef zzaefVar12 = zzaefVar2;
                                        if (i48 != 2) {
                                            bArr5 = bArr;
                                            i51 = i51;
                                            i27 = i60;
                                            obj2 = obj;
                                            i23 = i59;
                                            i25 = i49;
                                            zzacgVar5 = zzacgVar;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int zza12 = zzach.zza(bArr, i60, zzacgVar);
                                            int i88 = zzacgVar.zza;
                                            if (i88 >= 0) {
                                                if (i88 > bArr.length - zza12) {
                                                    throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (i88 == 0) {
                                                    zzaefVar12.add(zzacr.zza);
                                                    while (zza12 < i2) {
                                                        int zza13 = zzach.zza(bArr, zza12, zzacgVar);
                                                        if (i59 != zzacgVar.zza) {
                                                            zza2 = zza12;
                                                            bArr5 = bArr;
                                                            i51 = i51;
                                                            i27 = i60;
                                                            obj2 = obj;
                                                            i23 = i59;
                                                            i25 = i49;
                                                            zzacgVar5 = zzacgVar;
                                                            break;
                                                        } else {
                                                            zza12 = zzach.zza(bArr, zza13, zzacgVar);
                                                            i88 = zzacgVar.zza;
                                                            if (i88 >= 0) {
                                                                if (i88 > bArr.length - zza12) {
                                                                    throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                                if (i88 == 0) {
                                                                    zzaefVar12.add(zzacr.zza);
                                                                } else {
                                                                    zzaefVar12.add(zzacr.zzj(bArr, zza12, i88));
                                                                    zza12 += i88;
                                                                    while (zza12 < i2) {
                                                                    }
                                                                }
                                                            } else {
                                                                throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                        }
                                                    }
                                                    zza2 = zza12;
                                                    bArr5 = bArr;
                                                    i51 = i51;
                                                    i27 = i60;
                                                    obj2 = obj;
                                                    i23 = i59;
                                                    i25 = i49;
                                                    zzacgVar5 = zzacgVar;
                                                } else {
                                                    zzaefVar12.add(zzacr.zzj(bArr, zza12, i88));
                                                    zza12 += i88;
                                                    while (zza12 < i2) {
                                                    }
                                                    zza2 = zza12;
                                                    bArr5 = bArr;
                                                    i51 = i51;
                                                    i27 = i60;
                                                    obj2 = obj;
                                                    i23 = i59;
                                                    i25 = i49;
                                                    zzacgVar5 = zzacgVar;
                                                }
                                            } else {
                                                throw new zzaeh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                        }
                                    case 30:
                                    case 44:
                                        if (i48 != 2) {
                                            if (i48 != 0) {
                                                obj2 = obj;
                                                i27 = i60;
                                                zzacgVar5 = zzacgVar;
                                                i25 = i49;
                                                i23 = i59;
                                                bArr5 = bArr;
                                                zza2 = i27;
                                                break;
                                            } else {
                                                zzaefVar = zzaefVar2;
                                                zzl = zzach.zzl(i59, bArr, i60, i2, zzaefVar, zzacgVar);
                                                i29 = i59;
                                                bArr6 = bArr;
                                            }
                                        } else {
                                            i29 = i59;
                                            zzaefVar = zzaefVar2;
                                            bArr6 = bArr;
                                            zzl = zzach.zzm(bArr, i60, zzaefVar2, zzacgVar);
                                        }
                                        zzafq.zzF(obj8, i51, zzaefVar, zzs(i49), null, this.zzm);
                                        zza2 = zzl;
                                        bArr5 = bArr6;
                                        i27 = i60;
                                        zzacgVar5 = zzacgVar;
                                        obj2 = obj;
                                        i23 = i29;
                                        i25 = i49;
                                        break;
                                    case 33:
                                    case 47:
                                        if (i48 != 2) {
                                            if (i48 == 0) {
                                                int i89 = zzach.zza;
                                                zzadv zzadvVar3 = (zzadv) zzaefVar2;
                                                zza3 = zzach.zza(bArr, i60, zzacgVar);
                                                zzadvVar3.zzh(zzacv.zzR(zzacgVar.zza));
                                                while (zza3 < i2) {
                                                    int zza14 = zzach.zza(bArr, zza3, zzacgVar);
                                                    if (i59 == zzacgVar.zza) {
                                                        zza3 = zzach.zza(bArr, zza14, zzacgVar);
                                                        zzadvVar3.zzh(zzacv.zzR(zzacgVar.zza));
                                                    }
                                                }
                                            }
                                            obj2 = obj8;
                                            i27 = i60;
                                            zzacgVar5 = zzacgVar;
                                            i25 = i49;
                                            i23 = i59;
                                            bArr5 = bArr;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int i90 = zzach.zza;
                                            zzadv zzadvVar4 = (zzadv) zzaefVar2;
                                            zza3 = zzach.zza(bArr, i60, zzacgVar);
                                            int i91 = zzacgVar.zza + zza3;
                                            while (zza3 < i91) {
                                                zza3 = zzach.zza(bArr, zza3, zzacgVar);
                                                zzadvVar4.zzh(zzacv.zzR(zzacgVar.zza));
                                            }
                                            if (zza3 != i91) {
                                                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        zza2 = zza3;
                                        obj2 = obj8;
                                        i27 = i60;
                                        zzacgVar5 = zzacgVar;
                                        i25 = i49;
                                        i23 = i59;
                                        bArr5 = bArr;
                                        break;
                                    case 34:
                                    case 48:
                                        if (i48 != 2) {
                                            if (i48 == 0) {
                                                int i92 = zzach.zza;
                                                zzaeq zzaeqVar5 = (zzaeq) zzaefVar2;
                                                zza3 = zzach.zzc(bArr, i60, zzacgVar);
                                                zzaeqVar5.zzf(zzacv.zzS(zzacgVar.zzb));
                                                while (zza3 < i2) {
                                                    int zza15 = zzach.zza(bArr, zza3, zzacgVar);
                                                    if (i59 == zzacgVar.zza) {
                                                        zza3 = zzach.zzc(bArr, zza15, zzacgVar);
                                                        zzaeqVar5.zzf(zzacv.zzS(zzacgVar.zzb));
                                                    }
                                                }
                                            }
                                            obj2 = obj8;
                                            i27 = i60;
                                            zzacgVar5 = zzacgVar;
                                            i25 = i49;
                                            i23 = i59;
                                            bArr5 = bArr;
                                            zza2 = i27;
                                            break;
                                        } else {
                                            int i93 = zzach.zza;
                                            zzaeq zzaeqVar6 = (zzaeq) zzaefVar2;
                                            zza3 = zzach.zza(bArr, i60, zzacgVar);
                                            int i94 = zzacgVar.zza + zza3;
                                            while (zza3 < i94) {
                                                zza3 = zzach.zzc(bArr, zza3, zzacgVar);
                                                zzaeqVar6.zzf(zzacv.zzS(zzacgVar.zzb));
                                            }
                                            if (zza3 != i94) {
                                                throw new zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        zza2 = zza3;
                                        obj2 = obj8;
                                        i27 = i60;
                                        zzacgVar5 = zzacgVar;
                                        i25 = i49;
                                        i23 = i59;
                                        bArr5 = bArr;
                                        break;
                                    default:
                                        i23 = i59;
                                        i24 = i60;
                                        zzaef zzaefVar13 = zzaefVar2;
                                        int i95 = i2;
                                        bArr4 = bArr;
                                        obj2 = obj8;
                                        zzacgVar4 = zzacgVar;
                                        i25 = i49;
                                        if (i48 == 3) {
                                            int i96 = (i23 & (-8)) | 4;
                                            zzafp zzq = zzq(i25);
                                            int zzi = zzach.zzi(zzq, bArr4, i24, i95, i96, zzacgVar4);
                                            i27 = i24;
                                            zzaefVar13.add(zzacgVar4.zzc);
                                            while (zzi < i95) {
                                                int zza16 = zzach.zza(bArr4, zzi, zzacgVar4);
                                                if (i23 != zzacgVar4.zza) {
                                                    bArr5 = bArr4;
                                                    zzacgVar5 = zzacgVar4;
                                                    zza2 = zzi;
                                                    break;
                                                } else {
                                                    zzi = zzach.zzi(zzq, bArr4, zza16, i95, i96, zzacgVar4);
                                                    zzaefVar13.add(zzacgVar4.zzc);
                                                    i95 = i2;
                                                    zzq = zzq;
                                                    bArr4 = bArr4;
                                                }
                                            }
                                            bArr5 = bArr4;
                                            zzacgVar5 = zzacgVar4;
                                            zza2 = zzi;
                                        }
                                        i27 = i24;
                                        zzacgVar5 = zzacgVar4;
                                        bArr5 = bArr4;
                                        zza2 = i27;
                                        break;
                                }
                                if (zza2 != i27) {
                                    zzacgVar8 = zzacgVar5;
                                    bArr8 = bArr5;
                                    i37 = zza2;
                                    obj7 = obj2;
                                    i39 = i25;
                                    i40 = i23;
                                    unsafe4 = unsafe;
                                    i41 = i22;
                                    i42 = i21;
                                    i38 = i51;
                                    i36 = i2;
                                } else {
                                    i4 = i3;
                                    zzacgVar2 = zzacgVar5;
                                    bArr8 = bArr5;
                                    i37 = zza2;
                                    i11 = i25;
                                    i9 = i23;
                                }
                            } else {
                                obj2 = obj8;
                                i30 = i60;
                                i31 = i59;
                                bArr7 = bArr;
                                zzacg zzacgVar9 = zzacgVar;
                                if (zzC != 50) {
                                    long j4 = iArr[i49 + 2] & 1048575;
                                    switch (zzC) {
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            i32 = i31;
                                            if (i48 == 1) {
                                                i33 = i30 + 8;
                                                unsafe.putObject(obj2, j2, Double.valueOf(Double.longBitsToDouble(zzach.zze(bArr8, i30))));
                                                unsafe.putInt(obj2, j4, i10);
                                                i37 = i33;
                                                break;
                                            }
                                            i37 = i30;
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            i32 = i31;
                                            if (i48 == 5) {
                                                i33 = i30 + 4;
                                                unsafe.putObject(obj2, j2, Float.valueOf(Float.intBitsToFloat(zzach.zzd(bArr8, i30))));
                                                unsafe.putInt(obj2, j4, i10);
                                                i37 = i33;
                                                break;
                                            }
                                            i37 = i30;
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            i32 = i31;
                                            if (i48 == 0) {
                                                i33 = zzach.zzc(bArr8, i30, zzacgVar2);
                                                unsafe.putObject(obj2, j2, Long.valueOf(zzacgVar2.zzb));
                                                unsafe.putInt(obj2, j4, i10);
                                                i37 = i33;
                                                break;
                                            }
                                            i37 = i30;
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                        case RectListKt.BitOffsetForGesturable /* 62 */:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            i32 = i31;
                                            if (i48 == 0) {
                                                i33 = zzach.zza(bArr8, i30, zzacgVar2);
                                                unsafe.putObject(obj2, j2, Integer.valueOf(zzacgVar2.zza));
                                                unsafe.putInt(obj2, j4, i10);
                                                i37 = i33;
                                                break;
                                            }
                                            i37 = i30;
                                            break;
                                        case 56:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            i32 = i31;
                                            if (i48 == 1) {
                                                i33 = i30 + 8;
                                                unsafe.putObject(obj2, j2, Long.valueOf(zzach.zze(bArr8, i30)));
                                                unsafe.putInt(obj2, j4, i10);
                                                i37 = i33;
                                                break;
                                            }
                                            i37 = i30;
                                            break;
                                        case 57:
                                        case 64:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            i32 = i31;
                                            if (i48 == 5) {
                                                i33 = i30 + 4;
                                                unsafe.putObject(obj2, j2, Integer.valueOf(zzach.zzd(bArr8, i30)));
                                                unsafe.putInt(obj2, j4, i10);
                                                i37 = i33;
                                                break;
                                            }
                                            i37 = i30;
                                            break;
                                        case 58:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            if (i48 == 0) {
                                                i33 = zzach.zzc(bArr8, i30, zzacgVar2);
                                                i32 = i31;
                                                unsafe.putObject(obj2, j2, Boolean.valueOf(zzacgVar2.zzb != 0));
                                                unsafe.putInt(obj2, j4, i10);
                                                i37 = i33;
                                                break;
                                            }
                                            i32 = i31;
                                            i37 = i30;
                                            break;
                                        case 59:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            if (i48 == 2) {
                                                int zza17 = zzach.zza(bArr8, i30, zzacgVar2);
                                                int i97 = zzacgVar2.zza;
                                                if (i97 == 0) {
                                                    unsafe.putObject(obj2, j2, "");
                                                } else {
                                                    int i98 = zza17 + i97;
                                                    if ((i50 & 536870912) == 0 || zzagl.zza(bArr8, zza17, i98)) {
                                                        unsafe.putObject(obj2, j2, new String(bArr8, zza17, i97, StandardCharsets.UTF_8));
                                                        zza17 = i98;
                                                    } else {
                                                        throw new zzaeh("Protocol message had invalid UTF-8.");
                                                    }
                                                }
                                                unsafe.putInt(obj2, j4, i10);
                                                i37 = zza17;
                                                i32 = i31;
                                                break;
                                            }
                                            i32 = i31;
                                            i37 = i30;
                                            break;
                                        case 60:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            str = str;
                                            i34 = i51;
                                            if (i48 == 2) {
                                                Object zzv = zzv(obj2, i34, i49);
                                                int zzj2 = zzach.zzj(zzv, zzq(i49), bArr8, i30, i2, zzacgVar2);
                                                zzw(obj2, i34, i49, zzv);
                                                i37 = zzj2;
                                                i11 = i49;
                                                i10 = i34;
                                                i32 = i31;
                                                break;
                                            }
                                            i11 = i49;
                                            i10 = i34;
                                            i32 = i31;
                                            i37 = i30;
                                            break;
                                        case 61:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            str = str;
                                            i34 = i51;
                                            if (i48 == 2) {
                                                zzg = zzach.zzg(bArr8, i30, zzacgVar2);
                                                unsafe.putObject(obj2, j2, zzacgVar2.zzc);
                                                unsafe.putInt(obj2, j4, i34);
                                                i37 = zzg;
                                                i11 = i49;
                                                i10 = i34;
                                                i32 = i31;
                                                break;
                                            }
                                            i11 = i49;
                                            i10 = i34;
                                            i32 = i31;
                                            i37 = i30;
                                            break;
                                        case 63:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            str = str;
                                            i34 = i51;
                                            if (i48 == 0) {
                                                zzg = zzach.zza(bArr8, i30, zzacgVar2);
                                                int i99 = zzacgVar2.zza;
                                                zzadz zzs2 = zzs(i49);
                                                if (zzs2 == null || zzs2.zza(i99)) {
                                                    unsafe.putObject(obj2, j2, Integer.valueOf(i99));
                                                    unsafe.putInt(obj2, j4, i34);
                                                } else {
                                                    zzh(obj2).zzk(i31, Long.valueOf(i99));
                                                }
                                                i37 = zzg;
                                                i11 = i49;
                                                i10 = i34;
                                                i32 = i31;
                                                break;
                                            }
                                            i11 = i49;
                                            i10 = i34;
                                            i32 = i31;
                                            i37 = i30;
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            str = str;
                                            i34 = i51;
                                            if (i48 != 0) {
                                                i11 = i49;
                                                i10 = i34;
                                                i32 = i31;
                                                i30 = i30;
                                                i37 = i30;
                                                break;
                                            } else {
                                                i30 = i30;
                                                zzg = zzach.zza(bArr8, i30, zzacgVar2);
                                                unsafe.putObject(obj2, j2, Integer.valueOf(zzacv.zzR(zzacgVar2.zza)));
                                                unsafe.putInt(obj2, j4, i34);
                                                i37 = zzg;
                                                i11 = i49;
                                                i10 = i34;
                                                i32 = i31;
                                                break;
                                            }
                                        case 67:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i34 = i51;
                                            if (i48 != 0) {
                                                str = str;
                                                i11 = i49;
                                                i10 = i34;
                                                i32 = i31;
                                                i37 = i30;
                                                break;
                                            } else {
                                                int zzc3 = zzach.zzc(bArr8, i30, zzacgVar2);
                                                str = str;
                                                unsafe.putObject(obj2, j2, Long.valueOf(zzacv.zzS(zzacgVar2.zzb)));
                                                unsafe.putInt(obj2, j4, i34);
                                                i37 = zzc3;
                                                i11 = i49;
                                                i10 = i34;
                                                i32 = i31;
                                                i30 = i30;
                                                break;
                                            }
                                        case 68:
                                            if (i48 == 3) {
                                                Object zzv2 = zzv(obj2, i51, i49);
                                                int zzk2 = zzach.zzk(zzv2, zzq(i49), bArr, i30, i2, (i31 & (-8)) | 4, zzacgVar);
                                                zzacgVar2 = zzacgVar;
                                                bArr8 = bArr;
                                                zzw(obj2, i51, i49, zzv2);
                                                i37 = zzk2;
                                                i11 = i49;
                                                i10 = i51;
                                                str = str;
                                                i32 = i31;
                                                break;
                                            }
                                        default:
                                            bArr8 = bArr;
                                            zzacgVar2 = zzacgVar;
                                            i11 = i49;
                                            str = str;
                                            i10 = i51;
                                            i32 = i31;
                                            i37 = i30;
                                            break;
                                    }
                                    if (i37 != i30) {
                                        zzacgVar8 = zzacgVar2;
                                        obj7 = obj2;
                                        i38 = i10;
                                        unsafe4 = unsafe;
                                        i40 = i32;
                                        i41 = i22;
                                        i42 = i21;
                                        i39 = i11;
                                        i36 = i2;
                                    } else {
                                        i4 = i3;
                                        i9 = i32;
                                        i41 = i22;
                                        i42 = i21;
                                    }
                                } else if (i48 == 2) {
                                    Object zzr = zzr(i49);
                                    Object object = unsafe.getObject(obj2, j2);
                                    if (zzaex.zza(object)) {
                                        zzaew zzc4 = zzaew.zza().zzc();
                                        zzaex.zzb(zzc4, object);
                                        unsafe.putObject(obj2, j2, zzc4);
                                        object = zzc4;
                                    }
                                    zzaeu zze = ((zzaev) zzr).zze();
                                    zzaew zzaewVar = (zzaew) object;
                                    int zza18 = zzach.zza(bArr7, i30, zzacgVar9);
                                    int i100 = zzacgVar9.zza;
                                    if (i100 >= 0 && i100 <= i2 - zza18) {
                                        int i101 = zza18 + i100;
                                        Object obj9 = zze.zzb;
                                        Object obj10 = zze.zzd;
                                        Object obj11 = obj10;
                                        while (zza18 < i101) {
                                            int i102 = zza18 + 1;
                                            int i103 = bArr7[zza18];
                                            if (i103 < 0) {
                                                i102 = zzach.zzb(i103, bArr7, i102, zzacgVar9);
                                                i103 = zzacgVar9.zza;
                                            }
                                            Object obj12 = obj9;
                                            int i104 = i103 >>> 3;
                                            int i105 = i103 & 7;
                                            Object obj13 = obj10;
                                            if (i104 == 1) {
                                                int i106 = i102;
                                                zzacg zzacgVar10 = zzacgVar9;
                                                obj5 = obj12;
                                                zzagm zzagmVar = zze.zza;
                                                if (i105 == zzagmVar.zzb()) {
                                                    int zzS = zzS(bArr, i106, i2, zzagmVar, null, zzacgVar10);
                                                    bArr7 = bArr;
                                                    obj9 = zzacgVar10.zzc;
                                                    zza18 = zzS;
                                                    zzacgVar9 = zzacgVar10;
                                                    obj11 = obj11;
                                                    obj10 = obj13;
                                                } else {
                                                    bArr7 = bArr;
                                                    i35 = i2;
                                                    obj6 = obj11;
                                                    zzacgVar7 = zzacgVar10;
                                                    i102 = i106;
                                                }
                                            } else if (i104 != 2) {
                                                bArr7 = bArr;
                                                i35 = i2;
                                                obj6 = obj11;
                                                zzacgVar7 = zzacgVar9;
                                                obj5 = obj12;
                                            } else {
                                                zzagm zzagmVar2 = zze.zzc;
                                                if (i105 == zzagmVar2.zzb()) {
                                                    int i107 = i102;
                                                    zzacg zzacgVar11 = zzacgVar9;
                                                    int zzS2 = zzS(bArr, i107, i2, zzagmVar2, obj13.getClass(), zzacgVar11);
                                                    obj11 = zzacgVar11.zzc;
                                                    bArr7 = bArr;
                                                    zza18 = zzS2;
                                                    obj9 = obj12;
                                                    obj10 = obj13;
                                                    zzacgVar9 = zzacgVar11;
                                                } else {
                                                    int i108 = i102;
                                                    zzacg zzacgVar12 = zzacgVar9;
                                                    obj5 = obj12;
                                                    i102 = i108;
                                                    obj6 = obj11;
                                                    zzacgVar7 = zzacgVar12;
                                                    bArr7 = bArr;
                                                    i35 = i2;
                                                }
                                            }
                                            zza18 = zzach.zzp(i103, bArr7, i102, i35, zzacgVar7);
                                            zzacg zzacgVar13 = zzacgVar7;
                                            obj11 = obj6;
                                            obj9 = obj5;
                                            zzacgVar9 = zzacgVar13;
                                            obj10 = obj13;
                                        }
                                        zzacg zzacgVar14 = zzacgVar9;
                                        Object obj14 = obj9;
                                        Object obj15 = obj11;
                                        if (zza18 == i101) {
                                            zzaewVar.put(obj14, obj15);
                                            if (i101 != i30) {
                                                bArr8 = bArr7;
                                                zzacgVar8 = zzacgVar14;
                                                obj7 = obj2;
                                                i39 = i49;
                                                i40 = i31;
                                                unsafe4 = unsafe;
                                                i37 = i101;
                                                i41 = i22;
                                                i42 = i21;
                                                i36 = i2;
                                                i38 = i51;
                                            } else {
                                                i4 = i3;
                                                bArr8 = bArr7;
                                                zzacgVar2 = zzacgVar14;
                                                i11 = i49;
                                                i9 = i31;
                                                i37 = i101;
                                            }
                                        } else {
                                            throw new zzaeh(str);
                                        }
                                    }
                                } else {
                                    zzacgVar6 = zzacgVar9;
                                    str2 = str;
                                }
                            }
                            i41 = i22;
                            i42 = i21;
                            i10 = i51;
                        } else if (i48 == 2) {
                            zzaef zzaefVar14 = (zzaef) unsafe7.getObject(obj8, j2);
                            if (!zzaefVar14.zza()) {
                                int size2 = zzaefVar14.size();
                                zzaefVar14 = zzaefVar14.zzg(size2 == 0 ? 10 : size2 + size2);
                                unsafe7.putObject(obj8, j2, zzaefVar14);
                            }
                            int zzn2 = zzach.zzn(zzq(i49), i46, bArr, i37, i2, zzaefVar14, zzacgVar);
                            bArr8 = bArr;
                            i36 = i2;
                            i40 = i46;
                            i39 = i49;
                            obj7 = obj8;
                            i38 = i51;
                            zzacgVar8 = zzacgVar;
                            i37 = zzn2;
                            unsafe4 = unsafe7;
                        } else {
                            unsafe = unsafe7;
                            i22 = i41;
                            i30 = i37;
                            zzacgVar6 = zzacgVar;
                            obj2 = obj8;
                            str2 = "Failed to parse the message.";
                            i21 = i42;
                            i31 = i46;
                            bArr7 = bArr;
                        }
                        i4 = i3;
                        bArr8 = bArr7;
                        zzacgVar2 = zzacgVar6;
                        i11 = i49;
                        i9 = i31;
                        str = str2;
                        i37 = i30;
                        i41 = i22;
                        i42 = i21;
                        i10 = i51;
                    }
                }
                if (i9 != i4 || i4 == 0) {
                    if (this.zzh) {
                        zzadf zzadfVar = zzacgVar2.zzd;
                        int i109 = zzadf.zzb;
                        int i110 = zzacf.zza;
                        if (zzadfVar != zzadf.zza) {
                            zzafc zzafcVar = this.zzg;
                            int i111 = zzach.zza;
                            if (zzadfVar.zzc(zzafcVar, i10) == null) {
                                i37 = zzach.zzo(i9, bArr8, i37, i2, zzh(obj2), zzacgVar2);
                                i12 = i2;
                                zzacgVar8 = zzacgVar;
                                i40 = i9;
                                obj7 = obj2;
                                i38 = i10;
                                unsafe4 = unsafe;
                                i39 = i11;
                                i36 = i12;
                                bArr8 = bArr;
                            } else {
                                zzadr zzadrVar = (zzadr) obj2;
                                throw null;
                            }
                        }
                    }
                    i37 = zzach.zzo(i9, bArr, i37, i2, zzh(obj2), zzacgVar);
                    i12 = i2;
                    zzacgVar8 = zzacgVar;
                    i40 = i9;
                    obj7 = obj2;
                    i38 = i10;
                    unsafe4 = unsafe;
                    i39 = i11;
                    i36 = i12;
                    bArr8 = bArr;
                } else {
                    i5 = i2;
                    i6 = i9;
                    i8 = i37;
                    i7 = 1048575;
                }
            } else {
                i4 = i3;
                unsafe = unsafe4;
                i5 = i36;
                str = "Failed to parse the message.";
                obj2 = obj7;
                i6 = i40;
                i7 = 1048575;
                i8 = i37;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzacg zzacgVar) throws IOException {
        zzi(obj, bArr, i, i2, 0, zzacgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzk(Object obj) {
        if (zzE(obj)) {
            if (obj instanceof zzadu) {
                zzadu zzaduVar = (zzadu) obj;
                zzaduVar.zzcp(Integer.MAX_VALUE);
                zzaduVar.zza = 0;
                zzaduVar.zzci();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int zzA = zzA(i);
                int i2 = 1048575 & zzA;
                int zzC = zzC(zzA);
                long j = i2;
                if (zzC != 9) {
                    if (zzC != 60 && zzC != 68) {
                        switch (zzC) {
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
                                ((zzaef) zzagg.zzm(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzaew) object).zzd();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzq(i).zzk(zzb.getObject(obj, j));
                    }
                }
                if (zzK(obj, i)) {
                    zzq(i).zzk(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzj(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < this.zzk) {
            int i6 = this.zzj[i3];
            int zzA = this.zzA(i6);
            int[] iArr = this.zzc;
            int i7 = iArr[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i5) {
                if (i8 != 1048575) {
                    i4 = zzb.getInt(obj, i8);
                }
                i2 = i4;
                i = i8;
            } else {
                i = i5;
                i2 = i4;
            }
            zzaff<T> zzaffVar = this;
            Object obj2 = obj;
            if ((268435456 & zzA) != 0 && !zzaffVar.zzJ(obj2, i6, i, i2, i9)) {
                return false;
            }
            int zzC = zzC(zzA);
            if (zzC != 9 && zzC != 17) {
                if (zzC != 27) {
                    if (zzC == 60 || zzC == 68) {
                        if (zzaffVar.zzM(obj2, iArr[i6], i6) && !zzy(obj2, zzA, zzaffVar.zzq(i6))) {
                            return false;
                        }
                    } else if (zzC != 49) {
                        if (zzC != 50) {
                            continue;
                        } else {
                            zzaew zzaewVar = (zzaew) zzagg.zzm(obj2, zzA & 1048575);
                            if (!zzaewVar.isEmpty() && ((zzaev) zzaffVar.zzr(i6)).zze().zzc.zza() == zzagn.MESSAGE) {
                                zzafp zzafpVar = null;
                                for (Object obj3 : zzaewVar.values()) {
                                    if (zzafpVar == null) {
                                        zzafpVar = zzafl.zza().zzb(obj3.getClass());
                                    }
                                    if (!zzafpVar.zzl(obj3)) {
                                        return false;
                                    }
                                }
                                continue;
                            }
                        }
                    }
                }
                List list = (List) zzagg.zzm(obj2, zzA & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzafp zzq = zzaffVar.zzq(i6);
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!zzq.zzl(list.get(i10))) {
                            return false;
                        }
                    }
                    continue;
                }
            } else if (zzaffVar.zzJ(obj2, i6, i, i2, i9) && !zzy(obj2, zzA, zzaffVar.zzq(i6))) {
                return false;
            }
            i3++;
            this = zzaffVar;
            obj = obj2;
            i5 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzadr) obj).zzb.zze();
    }
}
