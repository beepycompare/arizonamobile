package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FloatSet.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\u000eJ\r\u0010\u0011\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u0011\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0002J\u0011\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0086\u0002J\u0011\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0086\u0002J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0001J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0015\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020\u0003H\u0007R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/collection/MutableFloatSet;", "Landroidx/collection/FloatSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "", "addAll", "elements", "", "adjustStorage", "", "adjustStorage$collection", "clear", "dropDeletes", "dropDeletes$collection", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeElementAt", FirebaseAnalytics.Param.INDEX, "resizeStorage", "newCapacity", "resizeStorage$collection", "trim", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableFloatSet extends FloatSet {
    private int growthLimit;

    public MutableFloatSet() {
        this(0, 1, null);
    }

    public MutableFloatSet(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    public /* synthetic */ MutableFloatSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    private final void initializeStorage(int i) {
        int max = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.elements = new float[max];
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

    public final boolean add(float f) {
        int i = this._size;
        this.elements[findAbsoluteInsertIndex(f)] = f;
        return this._size != i;
    }

    public final void plusAssign(float f) {
        this.elements[findAbsoluteInsertIndex(f)] = f;
    }

    public final boolean addAll(float[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign(elements);
        return i != this._size;
    }

    public final boolean addAll(FloatSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign(elements);
        return i != this._size;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0069, code lost:
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006b, code lost:
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(float f) {
        int i;
        MutableFloatSet mutableFloatSet = this;
        int hashCode = Float.hashCode(f) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        int i4 = mutableFloatSet._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = mutableFloatSet.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (mutableFloatSet.elements[i] == f) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        boolean z = i >= 0;
        if (z) {
            removeElementAt(i);
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0066, code lost:
        if (((r5 & ((~r5) << 6)) & (-9187201950435737472L)) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void minusAssign(float f) {
        int i;
        MutableFloatSet mutableFloatSet = this;
        int hashCode = Float.hashCode(f) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        int i4 = mutableFloatSet._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = mutableFloatSet.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (mutableFloatSet.elements[i] == f) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        if (i >= 0) {
            removeElementAt(i);
        }
    }

    public final boolean removeAll(float[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign(elements);
        return i != this._size;
    }

    public final boolean removeAll(FloatSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign(elements);
        return i != this._size;
    }

    private final void removeElementAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
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
        float[] fArr = this.elements;
        int i3 = (i2 + 7) >> 3;
        char c = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            long j2 = jArr[i4] & (-9187201950435737472L);
            jArr[i4] = (-72340172838076674L) & ((~j2) + (j2 >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i5 = lastIndex - 1;
        long j3 = 72057594037927935L;
        jArr[i5] = (jArr[i5] & 72057594037927935L) | (-72057594037927936L);
        jArr[lastIndex] = jArr[0];
        int i6 = 0;
        while (i6 != i2) {
            int i7 = i6 >> 3;
            int i8 = (i6 & 7) << 3;
            long j4 = (jArr[i7] >> i8) & 255;
            if (j4 != 128 && j4 == 254) {
                int hashCode = Float.hashCode(fArr[i6]) * ScatterMapKt.MurmurHashC1;
                int i9 = (hashCode ^ (hashCode << 16)) >>> 7;
                int findFirstAvailableSlot = findFirstAvailableSlot(i9);
                int i10 = i9 & i2;
                char c2 = c;
                if (((findFirstAvailableSlot - i10) & i2) / 8 == ((i6 - i10) & i2) / 8) {
                    jArr[i7] = ((i & 127) << i8) | ((~(255 << i8)) & jArr[i7]);
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[c2] & j3) | Long.MIN_VALUE;
                    i6++;
                    c = c2;
                } else {
                    int i11 = findFirstAvailableSlot >> 3;
                    long j5 = jArr[i11];
                    int i12 = (findFirstAvailableSlot & 7) << 3;
                    if (((j5 >> i12) & 255) == 128) {
                        j = j3;
                        jArr[i11] = ((i & 127) << i12) | (j5 & (~(255 << i12)));
                        jArr[i7] = (jArr[i7] & (~(255 << i8))) | (128 << i8);
                        fArr[findFirstAvailableSlot] = fArr[i6];
                        fArr[i6] = 0.0f;
                    } else {
                        j = j3;
                        jArr[i11] = ((i & 127) << i12) | (j5 & (~(255 << i12)));
                        float f = fArr[findFirstAvailableSlot];
                        fArr[findFirstAvailableSlot] = fArr[i6];
                        fArr[i6] = f;
                        i6--;
                    }
                    jArr[ArraysKt.getLastIndex(jArr)] = (jArr[c2] & j) | Long.MIN_VALUE;
                    i6++;
                    c = c2;
                    j3 = j;
                }
            } else {
                i6++;
            }
        }
        initializeGrowth();
    }

    public final void resizeStorage$collection(int i) {
        long[] jArr = this.metadata;
        float[] fArr = this.elements;
        int i2 = this._capacity;
        initializeStorage(i);
        long[] jArr2 = this.metadata;
        float[] fArr2 = this.elements;
        int i3 = this._capacity;
        for (int i4 = 0; i4 < i2; i4++) {
            if (((jArr[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                float f = fArr[i4];
                int hashCode = Float.hashCode(f) * ScatterMapKt.MurmurHashC1;
                int i5 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i5 >>> 7);
                long j = i5 & 127;
                int i6 = findFirstAvailableSlot >> 3;
                int i7 = (findFirstAvailableSlot & 7) << 3;
                long j2 = (jArr2[i6] & (~(255 << i7))) | (j << i7);
                jArr2[i6] = j2;
                jArr2[(((findFirstAvailableSlot - 7) & i3) + (i3 & 7)) >> 3] = j2;
                fArr2[findFirstAvailableSlot] = f;
            }
        }
    }

    public final void plusAssign(float[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (float f : elements) {
            plusAssign(f);
        }
    }

    public final void plusAssign(FloatSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        float[] fArr = elements.elements;
        long[] jArr = elements.metadata;
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
                        plusAssign(fArr[(i << 3) + i3]);
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

    public final void minusAssign(float[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (float f : elements) {
            minusAssign(f);
        }
    }

    public final void minusAssign(FloatSet elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        float[] fArr = elements.elements;
        long[] jArr = elements.metadata;
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
                        minusAssign(fArr[(i << 3) + i3]);
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

    private final int findAbsoluteInsertIndex(float f) {
        int hashCode = Float.hashCode(f) * ScatterMapKt.MurmurHashC1;
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
            int i9 = i6;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i5) & i4;
                if (this.elements[numberOfTrailingZeros] == f) {
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
                return findFirstAvailableSlot;
            }
            i6 = i9 + 8;
            i5 = (i5 + i6) & i4;
        }
    }
}
