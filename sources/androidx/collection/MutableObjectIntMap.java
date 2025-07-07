package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
/* compiled from: ObjectIntMap.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0006\u0010\n\u001a\u00020\bJ\r\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0002\b\fJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0011J'\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001a\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\nJ\u001e\u0010\u001a\u001a\u00020\b2\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001eH\u0086\n¢\u0006\u0002\u0010\u001fJ\u0017\u0010\u001a\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0086\nJ\u0017\u0010\u001a\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0086\nJ\u0017\u0010\"\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\nJ\u001b\u0010$\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0002\u0010&J#\u0010$\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0013\u0010*\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0002\u0010,J&\u0010-\u001a\u00020\b2\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+0/H\u0086\bø\u0001\u0000J\u0010\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u0004H\u0001J\u0015\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0004H\u0000¢\u0006\u0002\b4J\u001e\u00105\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0002\u0010&J\u0006\u00106\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {"Landroidx/collection/MutableObjectIntMap;", "K", "Landroidx/collection/ObjectIntMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "adjustStorage$collection", "clear", "dropDeletes", "dropDeletes$collection", "findFirstAvailableSlot", "hash1", "findIndex", "key", "(Ljava/lang/Object;)I", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)I", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", UserMetadata.KEYDATA_FILENAME, "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "plusAssign", "from", "put", "value", "(Ljava/lang/Object;I)V", "default", "(Ljava/lang/Object;II)I", "putAll", "remove", "", "(Ljava/lang/Object;I)Z", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", FirebaseAnalytics.Param.INDEX, "resizeStorage", "newCapacity", "resizeStorage$collection", "set", "trim", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableObjectIntMap<K> extends ObjectIntMap<K> {
    private int growthLimit;

    public MutableObjectIntMap() {
        this(0, 1, null);
    }

    public /* synthetic */ MutableObjectIntMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public MutableObjectIntMap(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    private final void initializeStorage(int i) {
        int max = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.keys = new Object[max];
        this.values = new int[max];
    }

    private final void initializeMetadata(int i) {
        long[] jArr;
        if (i == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            long[] jArr2 = new long[((i + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr2, -9187201950435737472L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.metadata = jArr;
        long[] jArr3 = this.metadata;
        int i2 = i >> 3;
        long j = 255 << ((i & 7) << 3);
        jArr3[i2] = (jArr3[i2] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    public final int getOrPut(K k, Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(k);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        int intValue = defaultValue.invoke().intValue();
        set(k, intValue);
        return intValue;
    }

    public final void set(K k, int i) {
        int findIndex = findIndex(k);
        if (findIndex < 0) {
            findIndex = ~findIndex;
        }
        this.keys[findIndex] = k;
        this.values[findIndex] = i;
    }

    public final void put(K k, int i) {
        set(k, i);
    }

    public final int put(K k, int i, int i2) {
        int findIndex = findIndex(k);
        if (findIndex < 0) {
            findIndex = ~findIndex;
        } else {
            i2 = this.values[findIndex];
        }
        this.keys[findIndex] = k;
        this.values[findIndex] = i;
        return i2;
    }

    public final void plusAssign(ObjectIntMap<K> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final void remove(K k) {
        int findKeyIndex = findKeyIndex(k);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public final boolean remove(K k, int i) {
        int findKeyIndex = findKeyIndex(k);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != i) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void removeIf(Function2<? super K, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        if (predicate.invoke(this.keys[i4], Integer.valueOf(this.values[i4])).booleanValue()) {
                            removeValueAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    public final void minusAssign(K k) {
        remove(k);
    }

    public final void minusAssign(K[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final void minusAssign(Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final void minusAssign(Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final void removeValueAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
        this.keys[i] = null;
    }

    public final void clear() {
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr[i2] = (jArr[i2] & (~j)) | j;
        }
        ArraysKt.fill(this.keys, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    private final int findFirstAvailableSlot(int i) {
        int i2 = this._capacity;
        int i3 = i & i2;
        int i4 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i5 = i3 >> 3;
            int i6 = (i3 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-i6) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i3 + (Long.numberOfTrailingZeros(j2) >> 3)) & i2;
            }
            i4 += 8;
            i3 = (i3 + i4) & i2;
        }
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity < i) {
            resizeStorage$collection(normalizeCapacity);
            return i - this._capacity;
        }
        return 0;
    }

    public final void adjustStorage$collection() {
        int compare;
        if (this._capacity > 8) {
            compare = Long.compare(ULong.m8619constructorimpl(ULong.m8619constructorimpl(this._size) * 32) ^ Long.MIN_VALUE, ULong.m8619constructorimpl(ULong.m8619constructorimpl(this._capacity) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                dropDeletes$collection();
                return;
            }
        }
        resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
    }

    public final void dropDeletes$collection() {
        int i;
        long j;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int i3 = (i2 + 7) >> 3;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            long j2 = jArr[i5] & (-9187201950435737472L);
            jArr[i5] = (-72340172838076674L) & ((~j2) + (j2 >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i6 = lastIndex - 1;
        long j3 = 72057594037927935L;
        jArr[i6] = (jArr[i6] & 72057594037927935L) | (-72057594037927936L);
        jArr[lastIndex] = jArr[0];
        int i7 = 0;
        while (i7 != i2) {
            int i8 = i7 >> 3;
            int i9 = (i7 & 7) << 3;
            long j4 = (jArr[i8] >> i9) & 255;
            if (j4 != 128 && j4 == 254) {
                Object obj = objArr[i7];
                int hashCode = (obj != null ? obj.hashCode() : i4) * ScatterMapKt.MurmurHashC1;
                int i10 = (hashCode ^ (hashCode << 16)) >>> 7;
                int findFirstAvailableSlot = findFirstAvailableSlot(i10);
                int i11 = i10 & i2;
                int i12 = i4;
                if (((findFirstAvailableSlot - i11) & i2) / 8 == ((i7 - i11) & i2) / 8) {
                    jArr[i8] = ((i & 127) << i9) | ((~(255 << i9)) & jArr[i8]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i12] & j3) | Long.MIN_VALUE;
                    i7++;
                    i4 = i12;
                } else {
                    int i13 = findFirstAvailableSlot >> 3;
                    long j5 = jArr[i13];
                    int i14 = (findFirstAvailableSlot & 7) << 3;
                    if (((j5 >> i14) & 255) == 128) {
                        j = j3;
                        jArr[i13] = ((i & 127) << i14) | (j5 & (~(255 << i14)));
                        jArr[i8] = (jArr[i8] & (~(255 << i9))) | (128 << i9);
                        objArr[findFirstAvailableSlot] = objArr[i7];
                        objArr[i7] = null;
                        iArr[findFirstAvailableSlot] = iArr[i7];
                        iArr[i7] = i12;
                    } else {
                        j = j3;
                        jArr[i13] = ((i & 127) << i14) | (j5 & (~(255 << i14)));
                        Object obj2 = objArr[findFirstAvailableSlot];
                        objArr[findFirstAvailableSlot] = objArr[i7];
                        objArr[i7] = obj2;
                        int i15 = iArr[findFirstAvailableSlot];
                        iArr[findFirstAvailableSlot] = iArr[i7];
                        iArr[i7] = i15;
                        i7--;
                    }
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[i12] & j) | Long.MIN_VALUE;
                    i7++;
                    i4 = i12;
                    j3 = j;
                }
            } else {
                i7++;
            }
        }
        initializeGrowth();
    }

    public final void resizeStorage$collection(int i) {
        int i2;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int i3 = this._capacity;
        initializeStorage(i);
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.keys;
        int[] iArr2 = this.values;
        int i4 = this._capacity;
        int i5 = 0;
        while (i5 < i3) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                int hashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i6 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i6 >>> 7);
                i2 = i5;
                long j = i6 & 127;
                int i7 = findFirstAvailableSlot >> 3;
                int i8 = (findFirstAvailableSlot & 7) << 3;
                long j2 = (j << i8) | (jArr2[i7] & (~(255 << i8)));
                jArr2[i7] = j2;
                jArr2[(((findFirstAvailableSlot - 7) & i4) + (i4 & 7)) >> 3] = j2;
                objArr2[findFirstAvailableSlot] = obj;
                iArr2[findFirstAvailableSlot] = iArr[i2];
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(ObjectIntMap<K> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Object[] objArr = from.keys;
        int[] iArr = from.values;
        long[] jArr = from.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        set(objArr[i4], iArr[i4]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Object[] objArr = keys.elements;
        long[] jArr = keys.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        remove(objArr[(i << 3) + i3]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            }
            i++;
        }
    }

    private final int findIndex(K k) {
        int hashCode = (k != null ? k.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i = hashCode ^ (hashCode << 16);
        int i2 = i >>> 7;
        int i3 = i & 127;
        int i4 = this._capacity;
        int i5 = i2 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = i3;
            int i9 = i3;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int numberOfTrailingZeros = (i5 + (Long.numberOfTrailingZeros(j4) >> 3)) & i4;
                if (Intrinsics.areEqual(this.keys[numberOfTrailingZeros], k)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i2);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage$collection();
                    findFirstAvailableSlot = findFirstAvailableSlot(i2);
                }
                this._size++;
                int i10 = findFirstAvailableSlot >> 3;
                int i11 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit -= ((this.metadata[i10] >> i11) & 255) == 128 ? 1 : 0;
                long[] jArr2 = this.metadata;
                int i12 = this._capacity;
                long j5 = ((~(255 << i11)) & jArr2[i10]) | (j2 << i11);
                jArr2[i10] = j5;
                jArr2[(((findFirstAvailableSlot - 7) & i12) + (i12 & 7)) >> 3] = j5;
                return ~findFirstAvailableSlot;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
            i3 = i9;
        }
    }
}
