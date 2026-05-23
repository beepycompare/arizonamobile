package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzabc extends AbstractMap {
    private static final Comparator zza = new zzaaz();
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd;
    private Integer zze;
    private String zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0145, code lost:
        if (r8 < 0) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractMap, com.google.android.gms.internal.measurement.zzabc] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzabc(zzabc zzabcVar, zzabc zzabcVar2) {
        int i;
        Object obj;
        Comparator comparator;
        Object[] objArr;
        zzabc abstractMap = new AbstractMap();
        abstractMap.zzd = new zzabb(abstractMap, -1);
        abstractMap.zze = null;
        abstractMap.zzf = null;
        int size = zzabcVar.size() + zzabcVar2.size();
        int i2 = zzabcVar.zzc[zzabcVar.size()] + zzabcVar2.zzc[zzabcVar2.size()];
        int i3 = size + 1;
        Object[] objArr2 = new Object[i2];
        int[] iArr = new int[i3];
        int i4 = 0;
        iArr[0] = size;
        Map.Entry zzg = zzabcVar.zzg(0);
        Map.Entry zzg2 = zzabcVar2.zzg(0);
        int i5 = 0;
        int i6 = 0;
        int i7 = size;
        Map.Entry entry = zzg;
        int i8 = 0;
        while (true) {
            int i9 = 1;
            if (entry == null && zzg2 == null) {
                break;
            }
            int i10 = i8 + 1;
            if (entry != null) {
                if (zzg2 != null) {
                    int compareTo = ((String) entry.getKey()).compareTo((String) zzg2.getKey());
                    if (compareTo == 0) {
                        int i11 = i5 + 1;
                        int i12 = i6 + 1;
                        objArr2[i8] = abstractMap.zzf((String) entry.getKey(), i8);
                        zzabb zzabbVar = (zzabb) entry.getValue();
                        zzabb zzabbVar2 = (zzabb) zzg2.getValue();
                        int i13 = 0;
                        int i14 = 0;
                        abstractMap = abstractMap;
                        while (true) {
                            if (i13 >= zzabbVar.zzc() - zzabbVar.zzb() && i14 >= zzabbVar2.zzc() - zzabbVar2.zzb()) {
                                break;
                            }
                            int i15 = i13 == zzabbVar.zzc() - zzabbVar.zzb() ? i9 : i14 == zzabbVar2.zzc() - zzabbVar2.zzb() ? -1 : 0;
                            if (i15 == 0) {
                                int i16 = zzabe.zza;
                                Object zza2 = zzabbVar.zza(i13);
                                Object zza3 = zzabbVar2.zza(i14);
                                comparator = zzabe.zzb;
                                i15 = comparator.compare(zza2, zza3);
                            }
                            if (i15 < 0) {
                                i = i13 + 1;
                                obj = zzabbVar.zza(i13);
                            } else {
                                int i17 = i14 + 1;
                                Object zza4 = zzabbVar2.zza(i14);
                                i14 = i17;
                                i = i15 == 0 ? i13 + 1 : i13;
                                obj = zza4;
                            }
                            objArr2[i7] = obj;
                            i13 = i;
                            i7++;
                            i9 = 1;
                            abstractMap = this;
                        }
                        iArr[i10] = i7;
                        entry = zzabcVar.zzg(i12);
                        zzg2 = zzabcVar2.zzg(i11);
                        i6 = i12;
                        i5 = i11;
                        i8 = i10;
                        i4 = 0;
                    }
                }
                i6++;
                i7 = zzd(entry, i8, i7, objArr2, iArr);
                entry = zzabcVar.zzg(i6);
                i8 = i10;
                i4 = 0;
                abstractMap = this;
            }
            Map.Entry entry2 = entry;
            i5++;
            int zzd = zzd(zzg2, i8, i7, objArr2, iArr);
            zzg2 = zzabcVar2.zzg(i5);
            i7 = zzd;
            entry = entry2;
            i8 = i10;
            i4 = 0;
            abstractMap = this;
        }
        int i18 = iArr[i4];
        int i19 = i18 - i8;
        if (i19 != 0) {
            for (int i20 = i4; i20 <= i8; i20++) {
                iArr[i20] = iArr[i20] - i19;
            }
            int i21 = iArr[i8];
            int i22 = i21 - i8;
            if (zze(i2, i21)) {
                objArr = new Object[i21];
                System.arraycopy(objArr2, i4, objArr, i4, i8);
            } else {
                objArr = objArr2;
            }
            System.arraycopy(objArr2, i18, objArr, i8, i22);
            objArr2 = objArr;
        }
        abstractMap.zzb = objArr2;
        int i23 = iArr[i4] + 1;
        abstractMap.zzc = zze(i3, i23) ? Arrays.copyOf(iArr, i23) : iArr;
    }

    private final int zzd(Map.Entry entry, int i, int i2, Object[] objArr, int[] iArr) {
        zzabb zzabbVar = (zzabb) entry.getValue();
        int zzc = zzabbVar.zzc() - zzabbVar.zzb();
        System.arraycopy(zzabbVar.zzb.zzb, zzabbVar.zzb(), objArr, i2, zzc);
        objArr[i] = zzf((String) entry.getKey(), i);
        int i3 = i2 + zzc;
        iArr[i + 1] = i3;
        return i3;
    }

    private static boolean zze(int i, int i2) {
        return i > 16 && i * 9 > i2 * 10;
    }

    private final Map.Entry zzf(String str, int i) {
        return new AbstractMap.SimpleImmutableEntry(str, new zzabb(this, i));
    }

    private final Map.Entry zzg(int i) {
        if (i < this.zzc[0]) {
            return (Map.Entry) this.zzb[i];
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object[] zzb() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ int[] zzc() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabc(List list) {
        this.zzd = new zzabb(this, -1);
        this.zze = null;
        this.zzf = null;
        Iterator it = list.iterator();
        if (it.hasNext()) {
            zzaay zzaayVar = (zzaay) it.next();
            throw null;
        }
        int size = list.size();
        Object[] objArr = new Object[size];
        Iterator it2 = list.iterator();
        if (it2.hasNext()) {
            zzaay zzaayVar2 = (zzaay) it2.next();
            throw null;
        }
        int[] iArr = {0};
        this.zzb = zze(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
        this.zzc = iArr;
    }
}
