package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzci extends zzbz {
    static final zzbz zza = new zzci(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzci(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01de  */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzci zzg(int i, Object[] objArr, zzby zzbyVar) {
        int i2;
        char c;
        int i3;
        char c2;
        byte[] bArr;
        char c3;
        short[] sArr;
        char c4;
        int i4;
        boolean z;
        int i5 = i;
        Object[] objArr2 = objArr;
        if (i5 == 0) {
            return (zzci) zza;
        }
        ?? r3 = null;
        char c5 = 0;
        int i6 = 1;
        if (i5 == 1) {
            zzbr.zza(Objects.requireNonNull(objArr2[0]), Objects.requireNonNull(objArr2[1]));
            return new zzci(null, objArr2, 1);
        }
        zzbj.zzb(i5, objArr2.length >> 1, FirebaseAnalytics.Param.INDEX);
        char c6 = 2;
        int max = Math.max(i5, 2);
        if (max < 751619276) {
            i2 = Integer.highestOneBit(max - 1);
            do {
                i2 += i2;
            } while (i2 * 0.7d < max);
        } else {
            i2 = 1073741824;
            if (max >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i5 == 1) {
            zzbr.zza(Objects.requireNonNull(objArr2[0]), Objects.requireNonNull(objArr2[1]));
            c = 0;
            i5 = 1;
            i3 = 1;
        } else {
            int i7 = i2 - 1;
            if (i2 <= 128) {
                byte[] bArr2 = new byte[i2];
                Arrays.fill(bArr2, (byte) -1);
                int i8 = 0;
                int i9 = 0;
                while (i8 < i5) {
                    int i10 = i9 + i9;
                    int i11 = i8 + i8;
                    Object requireNonNull = Objects.requireNonNull(objArr2[i11]);
                    Object requireNonNull2 = Objects.requireNonNull(objArr2[i11 ^ i6]);
                    zzbr.zza(requireNonNull, requireNonNull2);
                    int zza2 = zzbs.zza(requireNonNull.hashCode());
                    while (true) {
                        int i12 = zza2 & i7;
                        c4 = c5;
                        i4 = i6;
                        int i13 = bArr2[i12] & 255;
                        if (i13 != 255) {
                            if (requireNonNull.equals(objArr2[i13])) {
                                int i14 = i13 ^ 1;
                                zzbx zzbxVar = new zzbx(requireNonNull, requireNonNull2, Objects.requireNonNull(objArr2[i14]));
                                objArr2[i14] = requireNonNull2;
                                r3 = zzbxVar;
                                break;
                            }
                            zza2 = i12 + 1;
                            c5 = c4;
                            i6 = i4;
                        } else {
                            bArr2[i12] = (byte) i10;
                            if (i9 < i8) {
                                objArr2[i10] = requireNonNull;
                                objArr2[i10 ^ 1] = requireNonNull2;
                            }
                            i9++;
                        }
                    }
                    i8++;
                    c5 = c4;
                    i6 = i4;
                }
                c = c5;
                i3 = i6;
                if (i9 != i5) {
                    sArr = new Object[3];
                    sArr[c] = bArr2;
                    sArr[i3] = Integer.valueOf(i9);
                    sArr[2] = r3;
                    r3 = sArr;
                } else {
                    c2 = 2;
                    bArr = bArr2;
                    z = bArr instanceof Object[];
                    byte[] bArr3 = bArr;
                    if (z) {
                        ?? r32 = (Object[]) bArr;
                        zzbx zzbxVar2 = (zzbx) r32[c2];
                        if (zzbyVar != null) {
                            zzbyVar.zzc = zzbxVar2;
                            ?? r0 = r32[c];
                            int intValue = ((Integer) r32[i3]).intValue();
                            objArr2 = Arrays.copyOf(objArr2, intValue + intValue);
                            bArr3 = r0;
                            i5 = intValue;
                        } else {
                            throw zzbxVar2.zza();
                        }
                    }
                    return new zzci(bArr3, objArr2, i5);
                }
            } else {
                c = 0;
                i3 = 1;
                if (i2 <= 32768) {
                    sArr = new short[i2];
                    Arrays.fill(sArr, (short) -1);
                    int i15 = 0;
                    for (int i16 = 0; i16 < i5; i16++) {
                        int i17 = i15 + i15;
                        int i18 = i16 + i16;
                        Object requireNonNull3 = Objects.requireNonNull(objArr2[i18]);
                        Object requireNonNull4 = Objects.requireNonNull(objArr2[i18 ^ 1]);
                        zzbr.zza(requireNonNull3, requireNonNull4);
                        int zza3 = zzbs.zza(requireNonNull3.hashCode());
                        while (true) {
                            int i19 = zza3 & i7;
                            char c7 = (char) sArr[i19];
                            if (c7 != 65535) {
                                if (requireNonNull3.equals(objArr2[c7])) {
                                    int i20 = c7 ^ 1;
                                    zzbx zzbxVar3 = new zzbx(requireNonNull3, requireNonNull4, Objects.requireNonNull(objArr2[i20]));
                                    objArr2[i20] = requireNonNull4;
                                    r3 = zzbxVar3;
                                    break;
                                }
                                zza3 = i19 + 1;
                            } else {
                                sArr[i19] = (short) i17;
                                if (i15 < i16) {
                                    objArr2[i17] = requireNonNull3;
                                    objArr2[i17 ^ 1] = requireNonNull4;
                                }
                                i15++;
                            }
                        }
                    }
                    if (i15 != i5) {
                        r3 = new Object[]{sArr, Integer.valueOf(i15), r3};
                    }
                    r3 = sArr;
                } else {
                    int[] iArr = new int[i2];
                    Arrays.fill(iArr, -1);
                    int i21 = 0;
                    int i22 = 0;
                    while (i21 < i5) {
                        int i23 = i22 + i22;
                        int i24 = i21 + i21;
                        Object requireNonNull5 = Objects.requireNonNull(objArr2[i24]);
                        Object requireNonNull6 = Objects.requireNonNull(objArr2[i24 ^ 1]);
                        zzbr.zza(requireNonNull5, requireNonNull6);
                        int zza4 = zzbs.zza(requireNonNull5.hashCode());
                        while (true) {
                            int i25 = zza4 & i7;
                            ?? r15 = iArr[i25];
                            if (r15 != -1) {
                                c3 = c6;
                                if (requireNonNull5.equals(objArr2[r15])) {
                                    int i26 = r15 ^ 1;
                                    zzbx zzbxVar4 = new zzbx(requireNonNull5, requireNonNull6, Objects.requireNonNull(objArr2[i26]));
                                    objArr2[i26] = requireNonNull6;
                                    r3 = zzbxVar4;
                                    break;
                                }
                                zza4 = i25 + 1;
                                c6 = c3;
                            } else {
                                iArr[i25] = i23;
                                if (i22 < i21) {
                                    objArr2[i23] = requireNonNull5;
                                    objArr2[i23 ^ 1] = requireNonNull6;
                                }
                                i22++;
                                c3 = c6;
                            }
                        }
                        i21++;
                        c6 = c3;
                    }
                    c2 = c6;
                    if (i22 == i5) {
                        bArr = iArr;
                    } else {
                        ?? r5 = new Object[3];
                        r5[0] = iArr;
                        r5[1] = Integer.valueOf(i22);
                        r5[c2] = r3;
                        bArr = r5;
                    }
                    z = bArr instanceof Object[];
                    byte[] bArr32 = bArr;
                    if (z) {
                    }
                    return new zzci(bArr32, objArr2, i5);
                }
            }
        }
        c2 = 2;
        bArr = r3;
        z = bArr instanceof Object[];
        byte[] bArr322 = bArr;
        if (z) {
        }
        return new zzci(bArr322, objArr2, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a1 A[RETURN] */
    @Override // com.google.android.gms.internal.play_billing.zzbz, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        Object obj2;
        if (obj != null) {
            int i = this.zzd;
            Object[] objArr = this.zzb;
            if (i != 1) {
                Object obj3 = this.zzc;
                if (obj3 != null) {
                    if (obj3 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj3;
                        int length = bArr.length - 1;
                        int zza2 = zzbs.zza(obj.hashCode());
                        while (true) {
                            int i2 = zza2 & length;
                            int i3 = bArr[i2] & 255;
                            if (i3 == 255) {
                                break;
                            } else if (obj.equals(objArr[i3])) {
                                obj2 = objArr[i3 ^ 1];
                                break;
                            } else {
                                zza2 = i2 + 1;
                            }
                        }
                    } else if (obj3 instanceof short[]) {
                        short[] sArr = (short[]) obj3;
                        int length2 = sArr.length - 1;
                        int zza3 = zzbs.zza(obj.hashCode());
                        while (true) {
                            int i4 = zza3 & length2;
                            char c = (char) sArr[i4];
                            if (c == 65535) {
                                break;
                            } else if (obj.equals(objArr[c])) {
                                obj2 = objArr[c ^ 1];
                                break;
                            } else {
                                zza3 = i4 + 1;
                            }
                        }
                    } else {
                        int[] iArr = (int[]) obj3;
                        int length3 = iArr.length - 1;
                        int zza4 = zzbs.zza(obj.hashCode());
                        while (true) {
                            int i5 = zza4 & length3;
                            int i6 = iArr[i5];
                            if (i6 == -1) {
                                break;
                            } else if (obj.equals(objArr[i6])) {
                                obj2 = objArr[i6 ^ 1];
                                break;
                            } else {
                                zza4 = i5 + 1;
                            }
                        }
                    }
                }
            } else if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                obj2 = Objects.requireNonNull(objArr[1]);
            }
            if (obj2 != null) {
                return null;
            }
            return obj2;
        }
        obj2 = null;
        if (obj2 != null) {
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbz
    final zzbt zza() {
        return new zzch(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbz
    final zzca zzd() {
        return new zzcf(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbz
    final zzca zze() {
        return new zzcg(this, new zzch(this.zzb, 0, this.zzd));
    }
}
