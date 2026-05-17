package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbw extends zzbt implements List, RandomAccess {
    private static final zzcl zza = new zzbu(zzcd.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbw zzi(Object[] objArr, int i) {
        if (i == 0) {
            return zzcd.zza;
        }
        return new zzcd(objArr, i);
    }

    public static zzbw zzj(Collection collection) {
        if (collection instanceof zzbt) {
            zzbw zzd2 = ((zzbt) collection).zzd();
            if (zzd2.zzf()) {
                Object[] array = zzd2.toArray();
                return zzi(array, array.length);
            }
            return zzd2;
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzcc.zza(array2, length);
        return zzi(array2, length);
    }

    public static zzbw zzk() {
        return zzcd.zza;
    }

    public static zzbw zzl(Object obj) {
        Object[] objArr = {"inapp"};
        zzcc.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    public static zzbw zzm(Object obj, Object obj2) {
        Object[] objArr = {"subs", "inapp"};
        zzcc.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    @Override // java.util.Collection, java.util.List
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size != list.size()) {
                return false;
            }
            if (list instanceof RandomAccess) {
                for (int i = 0; i < size; i++) {
                    if (!Objects.equals(get(i), list.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            Iterator it = list.iterator();
            for (Object obj2 : this) {
                if (!it.hasNext() || !Objects.equals(obj2, it.next())) {
                    return false;
                }
                while (r6.hasNext()) {
                }
            }
            return !it.hasNext();
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzbt
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    @Deprecated
    public final zzbw zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbt
    public final zzck zze() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzh */
    public zzbw subList(int i, int i2) {
        zzbj.zzd(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 != 0) {
            return new zzbv(this, i, i3);
        }
        return zzcd.zza;
    }

    @Override // java.util.List
    /* renamed from: zzn */
    public final zzcl listIterator(int i) {
        zzbj.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? zza : new zzbu(this, i);
    }
}
