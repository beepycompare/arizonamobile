package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ArrayDeque.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 ^*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001^B\u0011\bV\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\bV¢\u0006\u0004\b\u0005\u0010\u0007B\u0017\bV\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u0005\u0010\nJ\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0004H\u0082\u0080\u0004J\u001b\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0004H\u0083\u0088\u0004b\u0002\b\u001c¢\u0006\u0002\u0010\u001bJ\u0012\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082\u0080\u0004J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0083\u0088\u0004b\u0002\b\u001cJ\u0012\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082\u0080\u0004J\u0012\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082\u0080\u0004J\n\u0010\"\u001a\u00020#H\u0096\u0080\u0004J\u000f\u0010$\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u0004\u0018\u00018\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010%J\u000f\u0010'\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010%J\u0011\u0010(\u001a\u0004\u0018\u00018\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010%J\u0017\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010+J\u0017\u0010,\u001a\u00020\u00152\u0006\u0010*\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010+J\u0013\u0010-\u001a\u00028\u0000H\u0087\u0080\bb\u0002\b.¢\u0006\u0002\u0010%J\u0015\u0010/\u001a\u0004\u0018\u00018\u0000H\u0087\u0080\bb\u0002\b.¢\u0006\u0002\u0010%J\u0013\u00100\u001a\u00028\u0000H\u0087\u0080\bb\u0002\b.¢\u0006\u0002\u0010%J\u0015\u00101\u001a\u0004\u0018\u00018\u0000H\u0087\u0080\bb\u0002\b.¢\u0006\u0002\u0010%J\u001b\u00102\u001a\u00020#2\u0006\u0010*\u001a\u00028\u0000H\u0097\u0080\bb\u0002\b.¢\u0006\u0002\u00103J\u001f\u00102\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010*\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u00104J \u00105\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0082\u0080\u0004J\u001c\u00106\u001a\u00020#2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bb\u0002\b.J$\u00106\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bb\u0002\b.J\u0017\u00107\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u0004H\u0096\u0082\u0004¢\u0006\u0002\u0010\u001bJ#\u00108\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010*\u001a\u00028\u0000H\u0097\u0082\bb\u0002\b.¢\u0006\u0002\u00109J\u0017\u0010:\u001a\u00020#2\u0006\u0010*\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u00103J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010*\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010<J\u0017\u0010=\u001a\u00020\u00042\u0006\u0010*\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010<J\u001b\u0010>\u001a\u00020#2\u0006\u0010*\u001a\u00028\u0000H\u0097\u0080\bb\u0002\b.¢\u0006\u0002\u00103J\u001b\u0010?\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u0004H\u0097\u0080\bb\u0002\b.¢\u0006\u0002\u0010\u001bJ\u001c\u0010@\u001a\u00020#2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bb\u0002\b.J\u001c\u0010A\u001a\u00020#2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0097\u0080\bb\u0002\b.J\u001e\u0010B\u001a\u00020#2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0DH\u0082\u0088\u0004J\n\u0010E\u001a\u00020\u0015H\u0096\u0080\u0004J)\u0010F\u001a\b\u0012\u0004\u0012\u0002HG0\r\"\u0004\b\u0001\u0010G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HG0\rH\u0096\u0080\u0004¢\u0006\u0002\u0010IJ\u0017\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0096\u0080\u0004¢\u0006\u0002\u0010JJ\u001a\u0010K\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0094\u0080\u0004J\u001a\u0010N\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0082\u0080\u0004J\u001a\u0010O\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0082\u0080\u0004J\u001a\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u0004H\u0082\u0080\u0004J\n\u0010S\u001a\u00020\u0015H\u0082\u0080\u0004J+\u0010T\u001a\b\u0012\u0004\u0012\u0002HG0\r\"\u0004\b\u0001\u0010G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HG0\rH\u0080\u0080\u0004¢\u0006\u0004\bU\u0010IJ\u0019\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0080\u0080\u0004¢\u0006\u0004\bU\u0010JJ\u001f\u0010V\u001a\u00020\u00152\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\bWJO\u0010X\u001a\u00020\u00152>\u0010Y\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(\u000b\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00150ZH\u0080\u0080\u0004¢\u0006\u0002\b]R\u000f\u0010\u000b\u001a\u00020\u0004X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\u000fR\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004@RX\u0096\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013Ê\u0001\f\b`\u0012\b\ba\u0012\u0004\b\b(b¨\u0006_"}, d2 = {"Lkotlin/collections/ArrayDeque;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "<init>", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", TtmlNode.TAG_HEAD, "elementData", "", "", "[Ljava/lang/Object;", "value", "size", "getSize", "()I", "ensureCapacity", "", "minCapacity", "copyElements", "newCapacity", "internalGet", "internalIndex", "(I)Ljava/lang/Object;", "Lkotlin/internal/InlineOnly;", "positiveMod", FirebaseAnalytics.Param.INDEX, "negativeMod", "incremented", "decremented", "isEmpty", "", "first", "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "addFirst", "element", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "Lkotlin/IgnorableReturnValue;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "add", "(Ljava/lang/Object;)Z", "(ILjava/lang/Object;)V", "copyCollectionElements", "addAll", "get", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "filterInPlace", "predicate", "Lkotlin/Function1;", "clear", "toArray", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "removeRange", "fromIndex", "toIndex", "removeRangeShiftPreceding", "removeRangeShiftSucceeding", "nullifyNonEmpty", "internalFromIndex", "internalToIndex", "registerModification", "testToArray", "testToArray$kotlin_stdlib", "testRemoveRange", "testRemoveRange$kotlin_stdlib", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.4"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    private static final int defaultMinCapacity = 10;
    private Object[] elementData;
    private int head;
    private int size;
    public static final Companion Companion = new Companion(null);
    private static final Object[] emptyElementData = new Object[0];

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = emptyElementData;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + i);
        }
        this.elementData = objArr;
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        this.elementData = array;
        this.size = array.length;
        if (array.length == 0) {
            this.elementData = emptyElementData;
        }
    }

    private final void ensureCapacity(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            this.elementData = new Object[RangesKt.coerceAtLeast(i, 10)];
        } else {
            copyElements(AbstractList.Companion.newCapacity$kotlin_stdlib(this.elementData.length, i));
        }
    }

    private final void copyElements(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.elementData;
        ArraysKt.copyInto(objArr2, objArr, 0, this.head, objArr2.length);
        Object[] objArr3 = this.elementData;
        int length = objArr3.length;
        int i2 = this.head;
        ArraysKt.copyInto(objArr3, objArr, length - i2, 0, i2);
        this.head = 0;
        this.elementData = objArr;
    }

    private final E internalGet(int i) {
        return (E) this.elementData[i];
    }

    private final int positiveMod(int i) {
        Object[] objArr = this.elementData;
        return i >= objArr.length ? i - objArr.length : i;
    }

    private final int negativeMod(int i) {
        return i < 0 ? i + this.elementData.length : i;
    }

    private final int internalIndex(int i) {
        return positiveMod(this.head + i);
    }

    private final int incremented(int i) {
        if (i == ArraysKt.getLastIndex(this.elementData)) {
            return 0;
        }
        return i + 1;
    }

    private final int decremented(int i) {
        return i == 0 ? ArraysKt.getLastIndex(this.elementData) : i - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[this.head];
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[this.head];
    }

    public final E last() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final void addFirst(E e) {
        registerModification();
        ensureCapacity(size() + 1);
        int decremented = decremented(this.head);
        this.head = decremented;
        this.elementData[decremented] = e;
        this.size = size() + 1;
    }

    public final void addLast(E e) {
        registerModification();
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = e;
        this.size = size() + 1;
    }

    @IgnorableReturnValue
    public final E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        Object[] objArr = this.elementData;
        int i = this.head;
        E e = (E) objArr[i];
        objArr[i] = null;
        this.head = incremented(i);
        this.size = size() - 1;
        return e;
    }

    @IgnorableReturnValue
    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @IgnorableReturnValue
    public final E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        registerModification();
        int positiveMod = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        Object[] objArr = this.elementData;
        E e = (E) objArr[positiveMod];
        objArr[positiveMod] = null;
        this.size = size() - 1;
        return e;
    }

    @IgnorableReturnValue
    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    @IgnorableReturnValue
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, size());
        if (i == size()) {
            addLast(e);
        } else if (i == 0) {
            addFirst(e);
        } else {
            registerModification();
            ensureCapacity(size() + 1);
            int positiveMod = positiveMod(this.head + i);
            if (i < ((size() + 1) >> 1)) {
                int decremented = decremented(positiveMod);
                int decremented2 = decremented(this.head);
                int i2 = this.head;
                Object[] objArr = this.elementData;
                if (decremented >= i2) {
                    objArr[decremented2] = objArr[i2];
                    ArraysKt.copyInto(objArr, objArr, i2, i2 + 1, decremented + 1);
                } else {
                    ArraysKt.copyInto(objArr, objArr, i2 - 1, i2, objArr.length);
                    Object[] objArr2 = this.elementData;
                    objArr2[objArr2.length - 1] = objArr2[0];
                    ArraysKt.copyInto(objArr2, objArr2, 0, 1, decremented + 1);
                }
                this.elementData[decremented] = e;
                this.head = decremented2;
            } else {
                int positiveMod2 = positiveMod(this.head + size());
                Object[] objArr3 = this.elementData;
                if (positiveMod < positiveMod2) {
                    ArraysKt.copyInto(objArr3, objArr3, positiveMod + 1, positiveMod, positiveMod2);
                } else {
                    ArraysKt.copyInto(objArr3, objArr3, 1, 0, positiveMod2);
                    Object[] objArr4 = this.elementData;
                    objArr4[0] = objArr4[objArr4.length - 1];
                    ArraysKt.copyInto(objArr4, objArr4, positiveMod + 1, positiveMod, objArr4.length - 1);
                }
                this.elementData[positiveMod] = e;
            }
            this.size = size() + 1;
        }
    }

    private final void copyCollectionElements(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.elementData.length;
        while (i < length && it.hasNext()) {
            this.elementData[i] = it.next();
            i++;
        }
        int i2 = this.head;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.elementData[i3] = it.next();
        }
        this.size = size() + collection.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @IgnorableReturnValue
    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        registerModification();
        ensureCapacity(size() + elements.size());
        copyCollectionElements(positiveMod(this.head + size()), elements);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    @IgnorableReturnValue
    public boolean addAll(int i, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(i, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(elements);
        }
        registerModification();
        ensureCapacity(size() + elements.size());
        int positiveMod = positiveMod(this.head + size());
        int positiveMod2 = positiveMod(this.head + i);
        int size = elements.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.head;
            int i3 = i2 - size;
            if (positiveMod2 >= i2) {
                Object[] objArr = this.elementData;
                if (i3 >= 0) {
                    ArraysKt.copyInto(objArr, objArr, i3, i2, positiveMod2);
                } else {
                    i3 += objArr.length;
                    int i4 = positiveMod2 - i2;
                    int length = objArr.length - i3;
                    if (length >= i4) {
                        ArraysKt.copyInto(objArr, objArr, i3, i2, positiveMod2);
                    } else {
                        ArraysKt.copyInto(objArr, objArr, i3, i2, i2 + length);
                        Object[] objArr2 = this.elementData;
                        ArraysKt.copyInto(objArr2, objArr2, 0, this.head + length, positiveMod2);
                    }
                }
            } else {
                Object[] objArr3 = this.elementData;
                ArraysKt.copyInto(objArr3, objArr3, i3, i2, objArr3.length);
                Object[] objArr4 = this.elementData;
                if (size >= positiveMod2) {
                    ArraysKt.copyInto(objArr4, objArr4, objArr4.length - size, 0, positiveMod2);
                } else {
                    ArraysKt.copyInto(objArr4, objArr4, objArr4.length - size, 0, size);
                    Object[] objArr5 = this.elementData;
                    ArraysKt.copyInto(objArr5, objArr5, 0, size, positiveMod2);
                }
            }
            this.head = i3;
            copyCollectionElements(negativeMod(positiveMod2 - size), elements);
        } else {
            int i5 = positiveMod2 + size;
            Object[] objArr6 = this.elementData;
            if (positiveMod2 < positiveMod) {
                int i6 = size + positiveMod;
                if (i6 <= objArr6.length) {
                    ArraysKt.copyInto(objArr6, objArr6, i5, positiveMod2, positiveMod);
                } else if (i5 >= objArr6.length) {
                    ArraysKt.copyInto(objArr6, objArr6, i5 - objArr6.length, positiveMod2, positiveMod);
                } else {
                    int length2 = positiveMod - (i6 - objArr6.length);
                    ArraysKt.copyInto(objArr6, objArr6, 0, length2, positiveMod);
                    Object[] objArr7 = this.elementData;
                    ArraysKt.copyInto(objArr7, objArr7, i5, positiveMod2, length2);
                }
            } else {
                ArraysKt.copyInto(objArr6, objArr6, size, 0, positiveMod);
                Object[] objArr8 = this.elementData;
                if (i5 >= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i5 - objArr8.length, positiveMod2, objArr8.length);
                } else {
                    ArraysKt.copyInto(objArr8, objArr8, 0, objArr8.length - size, objArr8.length);
                    Object[] objArr9 = this.elementData;
                    ArraysKt.copyInto(objArr9, objArr9, i5, positiveMod2, objArr9.length - size);
                }
            }
            copyCollectionElements(positiveMod2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        return (E) this.elementData[positiveMod(this.head + i)];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    @IgnorableReturnValue
    public E set(int i, E e) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        int positiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        E e2 = (E) objArr[positiveMod];
        objArr[positiveMod] = e;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int positiveMod = positiveMod(this.head + size());
        int i2 = this.head;
        if (i2 < positiveMod) {
            while (i2 < positiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[i2])) {
                    i = this.head;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (isEmpty() || (i2 = this.head) < positiveMod) {
            return -1;
        } else {
            int length = this.elementData.length;
            while (true) {
                if (i2 >= length) {
                    for (int i3 = 0; i3 < positiveMod; i3++) {
                        if (Intrinsics.areEqual(obj, this.elementData[i3])) {
                            i2 = i3 + this.elementData.length;
                            i = this.head;
                        }
                    }
                    return -1;
                } else if (Intrinsics.areEqual(obj, this.elementData[i2])) {
                    i = this.head;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndex;
        int i;
        int positiveMod = positiveMod(this.head + size());
        int i2 = this.head;
        if (i2 < positiveMod) {
            lastIndex = positiveMod - 1;
            if (i2 <= lastIndex) {
                while (!Intrinsics.areEqual(obj, this.elementData[lastIndex])) {
                    if (lastIndex != i2) {
                        lastIndex--;
                    }
                }
                i = this.head;
                return lastIndex - i;
            }
            return -1;
        }
        if (!isEmpty() && this.head >= positiveMod) {
            while (true) {
                positiveMod--;
                Object[] objArr = this.elementData;
                if (-1 < positiveMod) {
                    if (Intrinsics.areEqual(obj, objArr[positiveMod])) {
                        lastIndex = positiveMod + this.elementData.length;
                        i = this.head;
                        break;
                    }
                } else {
                    lastIndex = ArraysKt.getLastIndex(objArr);
                    int i3 = this.head;
                    if (i3 <= lastIndex) {
                        while (!Intrinsics.areEqual(obj, this.elementData[lastIndex])) {
                            if (lastIndex != i3) {
                                lastIndex--;
                            }
                        }
                        i = this.head;
                    }
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @IgnorableReturnValue
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList
    @IgnorableReturnValue
    public E removeAt(int i) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i, size());
        ArrayDeque<E> arrayDeque = this;
        if (i == CollectionsKt.getLastIndex(arrayDeque)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        registerModification();
        int positiveMod = positiveMod(this.head + i);
        E e = (E) this.elementData[positiveMod];
        int size = size() >> 1;
        int i2 = this.head;
        if (i < size) {
            Object[] objArr = this.elementData;
            if (positiveMod >= i2) {
                ArraysKt.copyInto(objArr, objArr, i2 + 1, i2, positiveMod);
            } else {
                ArraysKt.copyInto(objArr, objArr, 1, 0, positiveMod);
                Object[] objArr2 = this.elementData;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i3 = this.head;
                ArraysKt.copyInto(objArr2, objArr2, i3 + 1, i3, objArr2.length - 1);
            }
            Object[] objArr3 = this.elementData;
            int i4 = this.head;
            objArr3[i4] = null;
            this.head = incremented(i4);
        } else {
            int positiveMod2 = positiveMod(i2 + CollectionsKt.getLastIndex(arrayDeque));
            Object[] objArr4 = this.elementData;
            if (positiveMod <= positiveMod2) {
                ArraysKt.copyInto(objArr4, objArr4, positiveMod, positiveMod + 1, positiveMod2 + 1);
            } else {
                ArraysKt.copyInto(objArr4, objArr4, positiveMod, positiveMod + 1, objArr4.length);
                Object[] objArr5 = this.elementData;
                objArr5[objArr5.length - 1] = objArr5[0];
                ArraysKt.copyInto(objArr5, objArr5, 0, 1, positiveMod2 + 1);
            }
            this.elementData[positiveMod2] = null;
        }
        this.size = size() - 1;
        return e;
    }

    private final boolean filterInPlace(Function1<? super E, Boolean> function1) {
        int positiveMod;
        Object[] objArr;
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod2 = positiveMod(this.head + size());
            int i = this.head;
            if (i < positiveMod2) {
                positiveMod = i;
                while (true) {
                    objArr = this.elementData;
                    if (i >= positiveMod2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (function1.invoke(obj).booleanValue()) {
                        this.elementData[positiveMod] = obj;
                        positiveMod++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ArraysKt.fill(objArr, (Object) null, positiveMod, positiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.elementData;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (function1.invoke(obj2).booleanValue()) {
                        this.elementData[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                positiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < positiveMod2; i3++) {
                    Object[] objArr3 = this.elementData;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (function1.invoke(obj3).booleanValue()) {
                        this.elementData[positiveMod] = obj3;
                        positiveMod = incremented(positiveMod);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(positiveMod - this.head);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            registerModification();
            nullifyNonEmpty(this.head, positiveMod(this.head + size()));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) ArraysKt.arrayOfNulls(array, size());
        }
        T[] tArr = array;
        int positiveMod = positiveMod(this.head + size());
        int i = this.head;
        if (i < positiveMod) {
            ArraysKt.copyInto$default(this.elementData, tArr, 0, i, positiveMod, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.copyInto(objArr, tArr, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(objArr2, tArr, objArr2.length - this.head, 0, positiveMod);
        }
        return (T[]) CollectionsKt.terminateCollectionToArray(size(), tArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i, int i2) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, size());
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == size()) {
            clear();
        } else if (i3 == 1) {
            removeAt(i);
        } else {
            registerModification();
            if (i < size() - i2) {
                removeRangeShiftPreceding(i, i2);
                int positiveMod = positiveMod(this.head + i3);
                nullifyNonEmpty(this.head, positiveMod);
                this.head = positiveMod;
            } else {
                removeRangeShiftSucceeding(i, i2);
                int positiveMod2 = positiveMod(this.head + size());
                nullifyNonEmpty(negativeMod(positiveMod2 - i3), positiveMod2);
            }
            this.size = size() - i3;
        }
    }

    private final void removeRangeShiftPreceding(int i, int i2) {
        int positiveMod = positiveMod(this.head + (i - 1));
        int positiveMod2 = positiveMod(this.head + (i2 - 1));
        while (i > 0) {
            int i3 = positiveMod + 1;
            int min = Math.min(i, Math.min(i3, positiveMod2 + 1));
            Object[] objArr = this.elementData;
            int i4 = positiveMod2 - min;
            int i5 = positiveMod - min;
            ArraysKt.copyInto(objArr, objArr, i4 + 1, i5 + 1, i3);
            positiveMod = negativeMod(i5);
            positiveMod2 = negativeMod(i4);
            i -= min;
        }
    }

    private final void removeRangeShiftSucceeding(int i, int i2) {
        int positiveMod = positiveMod(this.head + i2);
        int positiveMod2 = positiveMod(this.head + i);
        int size = size();
        while (true) {
            size -= i2;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.elementData;
            i2 = Math.min(size, Math.min(objArr.length - positiveMod, objArr.length - positiveMod2));
            Object[] objArr2 = this.elementData;
            int i3 = positiveMod + i2;
            ArraysKt.copyInto(objArr2, objArr2, positiveMod2, positiveMod, i3);
            positiveMod = positiveMod(i3);
            positiveMod2 = positiveMod(positiveMod2 + i2);
        }
    }

    private final void nullifyNonEmpty(int i, int i2) {
        Object[] objArr = this.elementData;
        if (i < i2) {
            ArraysKt.fill(objArr, (Object) null, i, i2);
            return;
        }
        ArraysKt.fill(objArr, (Object) null, i, objArr.length);
        ArraysKt.fill(this.elementData, (Object) null, 0, i2);
    }

    private final void registerModification() {
        this.modCount++;
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) toArray(array);
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    public final void testRemoveRange$kotlin_stdlib(int i, int i2) {
        removeRange(i, i2);
    }

    /* compiled from: ArrayDeque.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\u0007\u001a\u00020\bX\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "<init>", "()V", "emptyElementData", "", "[Ljava/lang/Object;", "defaultMinCapacity", "", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> structure) {
        int i;
        Intrinsics.checkNotNullParameter(structure, "structure");
        structure.invoke(Integer.valueOf((isEmpty() || (i = this.head) < positiveMod(this.head + size())) ? this.head : i - this.elementData.length), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @IgnorableReturnValue
    public boolean removeAll(Collection<?> elements) {
        int positiveMod;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod2 = positiveMod(this.head + size());
            int i = this.head;
            if (i < positiveMod2) {
                positiveMod = i;
                while (true) {
                    objArr = this.elementData;
                    if (i >= positiveMod2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (elements.contains(obj)) {
                        z = true;
                    } else {
                        this.elementData[positiveMod] = obj;
                        positiveMod++;
                    }
                    i++;
                }
                ArraysKt.fill(objArr, (Object) null, positiveMod, positiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.elementData;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (elements.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.elementData[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                positiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < positiveMod2; i3++) {
                    Object[] objArr3 = this.elementData;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (elements.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.elementData[positiveMod] = obj3;
                        positiveMod = incremented(positiveMod);
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(positiveMod - this.head);
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @IgnorableReturnValue
    public boolean retainAll(Collection<?> elements) {
        int positiveMod;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod2 = positiveMod(this.head + size());
            int i = this.head;
            if (i < positiveMod2) {
                positiveMod = i;
                while (true) {
                    objArr = this.elementData;
                    if (i >= positiveMod2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (elements.contains(obj)) {
                        this.elementData[positiveMod] = obj;
                        positiveMod++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ArraysKt.fill(objArr, (Object) null, positiveMod, positiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.elementData;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                positiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < positiveMod2; i3++) {
                    Object[] objArr3 = this.elementData;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[positiveMod] = obj3;
                        positiveMod = incremented(positiveMod);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(positiveMod - this.head);
            }
        }
        return z;
    }
}
