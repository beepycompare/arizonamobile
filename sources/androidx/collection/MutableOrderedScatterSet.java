package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
/* compiled from: OrderedScatterSet.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u001b\u0010\u000b\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0010J\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J\u0006\u0010\u0018\u001a\u00020\u0014J\r\u0010\u0019\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0016\u0010'\u001a\u00020\u00142\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010(J\u0017\u0010'\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086\u0002J\u0017\u0010'\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010'\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\u0002J\u001e\u0010'\u001a\u00020\u00142\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000fH\u0086\u0002¢\u0006\u0002\u0010)J\u0017\u0010'\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0002J\u0017\u0010'\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\u0002J\u0011\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0004H\u0082\bJ\u0016\u0010,\u001a\u00020\u00142\u0006\u0010\t\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010(J\u0017\u0010,\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0086\u0002J\u0017\u0010,\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002J\u0017\u0010,\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\u0002J\u001e\u0010,\u001a\u00020\u00142\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000fH\u0086\u0002¢\u0006\u0002\u0010)J\u0017\u0010,\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\u0002J\u0017\u0010,\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\u0002J\u0013\u0010-\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nJ\u0014\u0010.\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rJ\u0014\u0010.\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010.\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u001b\u0010.\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0010J\u0014\u0010.\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0014\u0010.\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0004H\u0001J \u00100\u001a\u00020\u00142\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b02H\u0086\bø\u0001\u0000J\u0011\u00103\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0004H\u0082\bJ\u0015\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0004H\u0000¢\u0006\u0002\b6J \u00107\u001a\u00020\b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b02H\u0086\bø\u0001\u0000J\u0014\u00107\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u00107\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eJ\u0014\u00107\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u000008J\b\u00109\u001a\u00020\u0004H\u0007J\u000e\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006<"}, d2 = {"Landroidx/collection/MutableOrderedScatterSet;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/OrderedScatterSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "Landroidx/collection/ObjectList;", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "adjustStorage", "", "adjustStorage$collection", "asMutableSet", "", "clear", "dropDeletes", "dropDeletes$collection", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "findFirstAvailableSlot", "hash1", "fixupNodes", "mapping", "", "", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "moveNodeToHead", FirebaseAnalytics.Param.INDEX, "plusAssign", "remove", "removeAll", "removeElementAt", "removeIf", "predicate", "Lkotlin/Function1;", "removeNode", "resizeStorage", "newCapacity", "resizeStorage$collection", "retainAll", "", "trim", "trimToSize", "maxSize", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableOrderedScatterSet<E> extends OrderedScatterSet<E> {
    private int growthLimit;

    public MutableOrderedScatterSet() {
        this(0, 1, null);
    }

    public /* synthetic */ MutableOrderedScatterSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public MutableOrderedScatterSet(int i) {
        super(null);
        if (!(i >= 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    private final void initializeStorage(int i) {
        long[] jArr;
        int max = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.elements = max == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[max];
        if (max == 0) {
            jArr = SieveCacheKt.getEmptyNodes();
        } else {
            long[] jArr2 = new long[max];
            ArraysKt.fill$default(jArr2, 4611686018427387903L, 0, 0, 6, (Object) null);
            jArr = jArr2;
        }
        this.nodes = jArr;
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

    public final boolean add(E e) {
        int size = getSize();
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(e);
        this.elements[findAbsoluteInsertIndex] = e;
        this.nodes[findAbsoluteInsertIndex] = (this.head & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (this.head != Integer.MAX_VALUE) {
            this.nodes[this.head] = ((SieveCacheKt.NodeLinkMask & findAbsoluteInsertIndex) << 31) | (this.nodes[this.head] & SieveCacheKt.NodeMetaAndNextMask);
        }
        this.head = findAbsoluteInsertIndex;
        if (this.tail == Integer.MAX_VALUE) {
            this.tail = findAbsoluteInsertIndex;
        }
        return getSize() != size;
    }

    public final void plusAssign(E e) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(e);
        this.elements[findAbsoluteInsertIndex] = e;
        this.nodes[findAbsoluteInsertIndex] = (this.head & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (this.head != Integer.MAX_VALUE) {
            this.nodes[this.head] = ((SieveCacheKt.NodeLinkMask & findAbsoluteInsertIndex) << 31) | (this.nodes[this.head] & SieveCacheKt.NodeMetaAndNextMask);
        }
        this.head = findAbsoluteInsertIndex;
        if (this.tail == Integer.MAX_VALUE) {
            this.tail = findAbsoluteInsertIndex;
        }
    }

    public final boolean addAll(E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        plusAssign((Object[]) elements);
        return size != getSize();
    }

    public final boolean addAll(Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        plusAssign((Iterable) elements);
        return size != getSize();
    }

    public final boolean addAll(Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        plusAssign((Sequence) elements);
        return size != getSize();
    }

    public final boolean addAll(OrderedScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        plusAssign((OrderedScatterSet) elements);
        return size != getSize();
    }

    public final boolean addAll(ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        plusAssign((ScatterSet) elements);
        return size != getSize();
    }

    public final boolean addAll(ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        plusAssign((ObjectList) elements);
        return size != getSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0071, code lost:
        if (((r8 & ((~r8) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0073, code lost:
        r12 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(E e) {
        int i;
        MutableOrderedScatterSet<E> mutableOrderedScatterSet = this;
        int hashCode = (e != null ? e.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        int i4 = mutableOrderedScatterSet._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = mutableOrderedScatterSet.metadata;
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
                if (Intrinsics.areEqual(mutableOrderedScatterSet.elements[i], e)) {
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

    /* JADX WARN: Code restructure failed: missing block: B:15:0x006c, code lost:
        if (((r5 & ((~r5) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006e, code lost:
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void minusAssign(E e) {
        int i;
        MutableOrderedScatterSet<E> mutableOrderedScatterSet = this;
        int i2 = 0;
        int hashCode = (e != null ? e.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i3 = hashCode ^ (hashCode << 16);
        int i4 = i3 & 127;
        int i5 = mutableOrderedScatterSet._capacity;
        int i6 = i3 >>> 7;
        loop0: while (true) {
            int i7 = i6 & i5;
            long[] jArr = mutableOrderedScatterSet.metadata;
            int i8 = i7 >> 3;
            int i9 = (i7 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (i4 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i7) & i5;
                if (Intrinsics.areEqual(mutableOrderedScatterSet.elements[i], e)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i2 += 8;
            i6 = i7 + i2;
        }
        if (i >= 0) {
            removeElementAt(i);
        }
    }

    public final boolean removeAll(E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        minusAssign((Object[]) elements);
        return size != getSize();
    }

    public final boolean removeAll(Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        minusAssign((Sequence) elements);
        return size != getSize();
    }

    public final boolean removeAll(Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        minusAssign((Iterable) elements);
        return size != getSize();
    }

    public final boolean removeAll(OrderedScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        minusAssign((OrderedScatterSet) elements);
        return size != getSize();
    }

    public final boolean removeAll(ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        minusAssign((ScatterSet) elements);
        return size != getSize();
    }

    public final boolean removeAll(ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = getSize();
        minusAssign((ObjectList) elements);
        return size != getSize();
    }

    public final void removeIf(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
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
                        if (predicate.invoke(objArr[i4]).booleanValue()) {
                            removeElementAt(i4);
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

    public final boolean retainAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = this.elements;
        int i = this._size;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            if (!CollectionsKt.contains(elements, objArr[i5])) {
                                removeElementAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(OrderedScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = this.elements;
        int i = this._size;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            if (!elements.contains(objArr[i5])) {
                                removeElementAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = this.elements;
        int i = this._size;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            if (!elements.contains(objArr[i5])) {
                                removeElementAt(i5);
                            }
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return i != this._size;
    }

    public final boolean retainAll(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        int size = getSize();
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (!predicate.invoke(objArr[i4]).booleanValue()) {
                                removeElementAt(i4);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return size != getSize();
    }

    public final void removeElementAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i3 = i >> 3;
        int i4 = (i & 7) << 3;
        long j = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        jArr[i3] = j;
        jArr[(((i - 7) & i2) + (i2 & 7)) >> 3] = j;
        this.elements[i] = null;
        long[] jArr2 = this.nodes;
        long j2 = jArr2[i];
        int i5 = (int) ((j2 >> 31) & SieveCacheKt.NodeLinkMask);
        int i6 = (int) (j2 & SieveCacheKt.NodeLinkMask);
        if (i5 != Integer.MAX_VALUE) {
            jArr2[i5] = (jArr2[i5] & SieveCacheKt.NodeMetaAndPreviousMask) | (i6 & SieveCacheKt.NodeLinkMask);
        } else {
            this.head = i6;
        }
        if (i6 != Integer.MAX_VALUE) {
            jArr2[i6] = ((i5 & SieveCacheKt.NodeLinkMask) << 31) | (jArr2[i6] & SieveCacheKt.NodeMetaAndNextMask);
        } else {
            this.tail = i5;
        }
        jArr2[i] = 4611686018427387903L;
    }

    private final void moveNodeToHead(int i) {
        this.nodes[i] = (this.head & SieveCacheKt.NodeLinkMask) | 4611686016279904256L;
        if (this.head != Integer.MAX_VALUE) {
            this.nodes[this.head] = ((SieveCacheKt.NodeLinkMask & i) << 31) | (this.nodes[this.head] & SieveCacheKt.NodeMetaAndNextMask);
        }
        this.head = i;
        if (this.tail == Integer.MAX_VALUE) {
            this.tail = i;
        }
    }

    private final void removeNode(int i) {
        long[] jArr = this.nodes;
        long j = jArr[i];
        int i2 = (int) ((j >> 31) & SieveCacheKt.NodeLinkMask);
        int i3 = (int) (j & SieveCacheKt.NodeLinkMask);
        if (i2 == Integer.MAX_VALUE) {
            this.head = i3;
        } else {
            jArr[i2] = (jArr[i2] & SieveCacheKt.NodeMetaAndPreviousMask) | (i3 & SieveCacheKt.NodeLinkMask);
        }
        if (i3 != Integer.MAX_VALUE) {
            jArr[i3] = ((i2 & SieveCacheKt.NodeLinkMask) << 31) | (jArr[i3] & SieveCacheKt.NodeMetaAndNextMask);
        } else {
            this.tail = i2;
        }
        jArr[i] = 4611686018427387903L;
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
        ArraysKt.fill(this.elements, (Object) null, 0, this._capacity);
        ArraysKt.fill$default(this.nodes, 4611686018427387903L, 0, 0, 6, (Object) null);
        this.head = Integer.MAX_VALUE;
        this.tail = Integer.MAX_VALUE;
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

    public final void trimToSize(int i) {
        long[] jArr = this.nodes;
        for (int i2 = this.head; i2 != Integer.MAX_VALUE && this._size > i && this._size != 0; i2 = (int) (jArr[i2] & SieveCacheKt.NodeLinkMask)) {
            removeElementAt(i2);
        }
    }

    public final void adjustStorage$collection() {
        int compare;
        if (this._capacity > 8) {
            compare = Long.compare(ULong.m8650constructorimpl(ULong.m8650constructorimpl(this._size) * 32) ^ Long.MIN_VALUE, ULong.m8650constructorimpl(ULong.m8650constructorimpl(this._capacity) * 25) ^ Long.MIN_VALUE);
            if (compare <= 0) {
                dropDeletes$collection();
                return;
            }
        }
        resizeStorage$collection(ScatterMapKt.nextCapacity(this._capacity));
    }

    public final void dropDeletes$collection() {
        int i;
        int i2;
        long[] jArr = this.metadata;
        if (jArr == null) {
            return;
        }
        int i3 = this._capacity;
        Object[] objArr = this.elements;
        long[] jArr2 = this.nodes;
        long[] jArr3 = new long[i3];
        long j = 9223372034707292159L;
        int i4 = 0;
        ArraysKt.fill(jArr3, 9223372034707292159L, 0, i3);
        int i5 = (i3 + 7) >> 3;
        for (int i6 = 0; i6 < i5; i6++) {
            long j2 = jArr[i6] & (-9187201950435737472L);
            jArr[i6] = (-72340172838076674L) & ((~j2) + (j2 >>> 7));
        }
        int lastIndex = ArraysKt.getLastIndex(jArr);
        int i7 = lastIndex - 1;
        jArr[i7] = (jArr[i7] & 72057594037927935L) | (-72057594037927936L);
        jArr[lastIndex] = jArr[0];
        int i8 = 0;
        while (i8 != i3) {
            int i9 = i8 >> 3;
            int i10 = (i8 & 7) << 3;
            long j3 = (jArr[i9] >> i10) & 255;
            if (j3 != 128 && j3 == 254) {
                Object obj = objArr[i8];
                int hashCode = (obj != null ? obj.hashCode() : i4) * ScatterMapKt.MurmurHashC1;
                int i11 = (hashCode ^ (hashCode << 16)) >>> 7;
                long j4 = j;
                int findFirstAvailableSlot = findFirstAvailableSlot(i11);
                int i12 = i11 & i3;
                if (((findFirstAvailableSlot - i12) & i3) / 8 == ((i8 - i12) & i3) / 8) {
                    jArr[i9] = ((i & 127) << i10) | (jArr[i9] & (~(255 << i10)));
                    if (jArr3[i8] == j4) {
                        long j5 = i8;
                        jArr3[i8] = j5 | (j5 << 32);
                    }
                    jArr[jArr.length - 1] = jArr[i4];
                    i8++;
                    j = j4;
                } else {
                    int i13 = findFirstAvailableSlot >> 3;
                    long j6 = jArr[i13];
                    int i14 = (findFirstAvailableSlot & 7) << 3;
                    int i15 = i4;
                    if (((j6 >> i14) & 255) == 128) {
                        int i16 = i8;
                        jArr[i13] = (j6 & (~(255 << i14))) | ((i & 127) << i14);
                        jArr[i9] = (jArr[i9] & (~(255 << i10))) | (128 << i10);
                        objArr[findFirstAvailableSlot] = objArr[i16];
                        objArr[i16] = null;
                        jArr2[findFirstAvailableSlot] = jArr2[i16];
                        jArr2[i16] = 4611686018427387903L;
                        int i17 = (int) ((jArr3[i16] >> 32) & 4294967295L);
                        if (i17 != Integer.MAX_VALUE) {
                            jArr3[i17] = (jArr3[i17] & (-4294967296L)) | findFirstAvailableSlot;
                            jArr3[i16] = (jArr3[i16] & 4294967295L) | (-4294967296L);
                        } else {
                            jArr3[i16] = (Integer.MAX_VALUE << 32) | findFirstAvailableSlot;
                        }
                        i2 = i16;
                        jArr3[findFirstAvailableSlot] = Integer.MAX_VALUE | (i2 << 32);
                    } else {
                        jArr[i13] = ((i & 127) << i14) | (j6 & (~(255 << i14)));
                        Object obj2 = objArr[findFirstAvailableSlot];
                        objArr[findFirstAvailableSlot] = objArr[i8];
                        objArr[i8] = obj2;
                        long j7 = jArr2[findFirstAvailableSlot];
                        jArr2[findFirstAvailableSlot] = jArr2[i8];
                        jArr2[i8] = j7;
                        int i18 = (int) ((jArr3[i8] >> 32) & 4294967295L);
                        if (i18 != Integer.MAX_VALUE) {
                            long j8 = findFirstAvailableSlot;
                            jArr3[i18] = (jArr3[i18] & (-4294967296L)) | j8;
                            jArr3[i8] = (jArr3[i8] & 4294967295L) | (j8 << 32);
                        } else {
                            long j9 = findFirstAvailableSlot;
                            jArr3[i8] = j9 | (j9 << 32);
                            i18 = i8;
                        }
                        jArr3[findFirstAvailableSlot] = (i18 << 32) | i8;
                        i2 = i8 - 1;
                    }
                    jArr[jArr.length - 1] = jArr[i15];
                    i8 = i2 + 1;
                    j = j4;
                    i4 = i15;
                }
            } else {
                i8++;
            }
        }
        initializeGrowth();
        fixupNodes(jArr3);
    }

    public final void resizeStorage$collection(int i) {
        long[] jArr;
        Object[] objArr;
        long[] jArr2 = this.metadata;
        Object[] objArr2 = this.elements;
        long[] jArr3 = this.nodes;
        int i2 = this._capacity;
        int[] iArr = new int[i2];
        initializeStorage(i);
        long[] jArr4 = this.metadata;
        Object[] objArr3 = this.elements;
        long[] jArr5 = this.nodes;
        int i3 = this._capacity;
        int i4 = 0;
        while (i4 < i2) {
            if (((jArr2[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                Object obj = objArr2[i4];
                int hashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i5 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i5 >>> 7);
                long j = i5 & 127;
                int i6 = findFirstAvailableSlot >> 3;
                int i7 = (findFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                objArr = objArr2;
                long j2 = (jArr4[i6] & (~(255 << i7))) | (j << i7);
                jArr4[i6] = j2;
                jArr4[(((findFirstAvailableSlot - 7) & i3) + (i3 & 7)) >> 3] = j2;
                objArr3[findFirstAvailableSlot] = obj;
                jArr5[findFirstAvailableSlot] = jArr3[i4];
                iArr[i4] = findFirstAvailableSlot;
            } else {
                jArr = jArr2;
                objArr = objArr2;
            }
            i4++;
            jArr2 = jArr;
            objArr2 = objArr;
        }
        fixupNodes(iArr);
    }

    private final void fixupNodes(long[] jArr) {
        long[] jArr2 = this.nodes;
        int length = jArr2.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            if (i >= length) {
                break;
            }
            long j = jArr2[i];
            int i3 = (int) ((j >> 31) & SieveCacheKt.NodeLinkMask);
            int i4 = (int) (j & SieveCacheKt.NodeLinkMask);
            long j2 = ((j & SieveCacheKt.NodeMetaMask) | (i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) (jArr[i3] & 4294967295L))) << 31;
            if (i4 != Integer.MAX_VALUE) {
                i2 = (int) (4294967295L & jArr[i4]);
            }
            jArr2[i] = i2 | j2;
            i++;
        }
        if (this.head != Integer.MAX_VALUE) {
            this.head = (int) (jArr[this.head] & 4294967295L);
        }
        if (this.tail != Integer.MAX_VALUE) {
            this.tail = (int) (jArr[this.tail] & 4294967295L);
        }
    }

    private final void fixupNodes(int[] iArr) {
        long[] jArr = this.nodes;
        int length = jArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            if (i >= length) {
                break;
            }
            long j = jArr[i];
            int i3 = (int) ((j >> 31) & SieveCacheKt.NodeLinkMask);
            int i4 = (int) (j & SieveCacheKt.NodeLinkMask);
            long j2 = ((j & SieveCacheKt.NodeMetaMask) | (i3 == Integer.MAX_VALUE ? Integer.MAX_VALUE : iArr[i3])) << 31;
            if (i4 != Integer.MAX_VALUE) {
                i2 = iArr[i4];
            }
            jArr[i] = j2 | i2;
            i++;
        }
        if (this.head != Integer.MAX_VALUE) {
            this.head = iArr[this.head];
        }
        if (this.tail != Integer.MAX_VALUE) {
            this.tail = iArr[this.tail];
        }
    }

    public final Set<E> asMutableSet() {
        return new MutableOrderedSetWrapper(this);
    }

    public final void plusAssign(E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            plusAssign((MutableOrderedScatterSet<E>) e);
        }
    }

    public final void plusAssign(Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            plusAssign((MutableOrderedScatterSet<E>) e);
        }
    }

    public final void plusAssign(Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            plusAssign((MutableOrderedScatterSet<E>) e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(OrderedScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.nodes;
        for (int i = elements.tail; i != Integer.MAX_VALUE; i = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask)) {
            plusAssign((MutableOrderedScatterSet<E>) objArr[i]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.elements;
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
                        plusAssign((MutableOrderedScatterSet<E>) objArr[(i << 3) + i3]);
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
    public final void plusAssign(ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i2 = 0; i2 < i; i2++) {
            plusAssign((MutableOrderedScatterSet<E>) objArr[i2]);
        }
    }

    public final void minusAssign(E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            minusAssign((MutableOrderedScatterSet<E>) e);
        }
    }

    public final void minusAssign(Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            minusAssign((MutableOrderedScatterSet<E>) e);
        }
    }

    public final void minusAssign(Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            minusAssign((MutableOrderedScatterSet<E>) e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(OrderedScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.nodes;
        for (int i = elements.tail; i != Integer.MAX_VALUE; i = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask)) {
            minusAssign((MutableOrderedScatterSet<E>) objArr[i]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.elements;
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
                        minusAssign((MutableOrderedScatterSet<E>) objArr[(i << 3) + i3]);
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
    public final void minusAssign(ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i2 = 0; i2 < i; i2++) {
            minusAssign((MutableOrderedScatterSet<E>) objArr[i2]);
        }
    }

    private final int findAbsoluteInsertIndex(E e) {
        int hashCode = (e != null ? e.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
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
                if (Intrinsics.areEqual(this.elements[numberOfTrailingZeros], e)) {
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
            i6 += 8;
            i5 = (i5 + i6) & i4;
            i3 = i9;
        }
    }
}
