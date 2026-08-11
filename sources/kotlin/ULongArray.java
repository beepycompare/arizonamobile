package kotlin;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: ULongArray.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001.B\u0015\bA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0002\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\bV\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0082\u0004¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0002H\u0086\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0096\u0082\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u00020\u001d2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0096\u0080\u0004¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u00020\u001dH\u0096\u0080\u0004¢\u0006\u0004\b&\u0010'J\u0014\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0083\u0004J\n\u0010+\u001a\u00020\tHÖ\u0081\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004R\u001b\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u00020\t8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0088\u0001\u0003\u0092\u0001\u00020\u0004Ê\u0001\f\b0\u0012\b\b1\u0012\u0004\b\b(2Ê\u0001\u0002\b3Ê\u0001\u0002\b4¨\u0006/"}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "storage", "", "constructor-impl", "([J)[J", "Lkotlin/PublishedApi;", "size", "", "(I)[J", "getStorage$annotations", "()V", "get", FirebaseAnalytics.Param.INDEX, "get-s-VKNKU", "([JI)J", "set", "", "value", "set-k8EXiF4", "([JIJ)V", "getSize-impl", "([J)I", "iterator", "", "iterator-impl", "([J)Ljava/util/Iterator;", "contains", "", "element", "contains-VKZWuLQ", "([JJ)Z", "containsAll", "elements", "containsAll-impl", "([JLjava/util/Collection;)Z", "isEmpty", "isEmpty-impl", "([J)Z", "equals", "other", "", "hashCode", "toString", "", "Iterator", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "Lkotlin/ExperimentalUnsignedTypes;", "Lkotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    private final long[] storage;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULongArray m10148boximpl(long[] jArr) {
        return new ULongArray(jArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m10150constructorimpl(long[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10153equalsimpl(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual(jArr, ((ULongArray) obj).m10164unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10154equalsimpl0(long[] jArr, long[] jArr2) {
        return Intrinsics.areEqual(jArr, jArr2);
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10157hashCodeimpl(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10161toStringimpl(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-VKZWuLQ  reason: not valid java name */
    public boolean m10162addVKZWuLQ(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m10153equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m10157hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public String toString() {
        return m10161toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long[] m10164unboximpl() {
        return this.storage;
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m10163containsVKZWuLQ(((ULong) obj).m10147unboximpl());
        }
        return false;
    }

    private /* synthetic */ ULongArray(long[] jArr) {
        this.storage = jArr;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m10149constructorimpl(int i) {
        return m10150constructorimpl(new long[i]);
    }

    /* renamed from: get-s-VKNKU  reason: not valid java name */
    public static final long m10155getsVKNKU(long[] jArr, int i) {
        return ULong.m10095constructorimpl(jArr[i]);
    }

    /* renamed from: set-k8EXiF4  reason: not valid java name */
    public static final void m10160setk8EXiF4(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m10156getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    @Override // java.util.Collection
    /* renamed from: getSize */
    public int size() {
        return m10156getSizeimpl(this.storage);
    }

    /* renamed from: iterator-impl  reason: not valid java name */
    public static java.util.Iterator<ULong> m10159iteratorimpl(long[] jArr) {
        return new Iterator(jArr);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<ULong> iterator() {
        return m10159iteratorimpl(this.storage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ULongArray.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u00020\nH\u0096\u0082\u0004J\u0011\u0010\u000b\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rR\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/ULongArray$Iterator;", "", "Lkotlin/ULong;", "array", "", "<init>", "([J)V", FirebaseAnalytics.Param.INDEX, "", "hasNext", "", "next", "next-s-VKNKU", "()J", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Iterator implements java.util.Iterator<ULong>, KMappedMarker {
        private final long[] array;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public Iterator(long[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ ULong next() {
            return ULong.m10089boximpl(m10165nextsVKNKU());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        /* renamed from: next-s-VKNKU  reason: not valid java name */
        public long m10165nextsVKNKU() {
            int i = this.index;
            long[] jArr = this.array;
            if (i < jArr.length) {
                this.index = i + 1;
                return ULong.m10095constructorimpl(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.index));
        }
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m10163containsVKZWuLQ(long j) {
        return m10151containsVKZWuLQ(this.storage, j);
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public static boolean m10151containsVKZWuLQ(long[] jArr, long j) {
        return ArraysKt.contains(jArr, j);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m10152containsAllimpl(this.storage, elements);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /* renamed from: containsAll-impl  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m10152containsAllimpl(long[] jArr, Collection<ULong> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<ULong> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof ULong) || !ArraysKt.contains(jArr, ((ULong) obj).m10147unboximpl())) {
                return false;
            }
            while (r5.hasNext()) {
            }
        }
        return true;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m10158isEmptyimpl(long[] jArr) {
        return jArr.length == 0;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m10158isEmptyimpl(this.storage);
    }
}
