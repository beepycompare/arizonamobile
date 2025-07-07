package androidx.compose.material3.carousel;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
/* compiled from: KeylineList.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010*\n\u0002\b\u0005\b\u0000\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0096\u0003J\u0017\u0010!\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0096\u0001J\u0013\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\u000e\u0010'\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020(J\u0011\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\tH\u0096\u0003J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020(J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020(J\b\u0010.\u001a\u00020\tH\u0016J\u0011\u0010/\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H\u0096\u0001J\t\u00100\u001a\u00020\u001fH\u0096\u0001J\u0006\u00101\u001a\u00020\u001fJ\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020(J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000205H\u0096\u0003J\u000e\u00106\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020(J\u0011\u00107\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H\u0096\u0001J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000209H\u0096\u0001J\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u0002092\u0006\u0010*\u001a\u00020\tH\u0096\u0001J\u001f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0096\u0001R\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000bR\u0012\u0010\u001c\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000b¨\u0006>"}, d2 = {"Landroidx/compose/material3/carousel/KeylineList;", "", "Landroidx/compose/material3/carousel/Keyline;", "keylines", "(Ljava/util/List;)V", "firstFocal", "getFirstFocal", "()Landroidx/compose/material3/carousel/Keyline;", "firstFocalIndex", "", "getFirstFocalIndex", "()I", "firstNonAnchor", "getFirstNonAnchor", "firstNonAnchorIndex", "getFirstNonAnchorIndex", "lastFocal", "getLastFocal", "lastFocalIndex", "getLastFocalIndex", "lastNonAnchor", "getLastNonAnchor", "lastNonAnchorIndex", "getLastNonAnchorIndex", "pivot", "getPivot", "pivotIndex", "getPivotIndex", "size", "getSize", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "firstIndexAfterFocalRangeWithSize", "", "get", FirebaseAnalytics.Param.INDEX, "getKeylineAfter", "unadjustedOffset", "getKeylineBefore", "hashCode", "indexOf", "isEmpty", "isFirstFocalItemAtStartOfContainer", "isLastFocalItemAtEndOfContainer", "carouselMainAxisSize", "iterator", "", "lastIndexBeforeFocalRangeWithSize", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeylineList implements List<Keyline>, KMappedMarker {
    private final /* synthetic */ List<Keyline> $$delegate_0;
    private final int firstFocalIndex;
    private final int firstNonAnchorIndex;
    private final int lastFocalIndex;
    private final int lastNonAnchorIndex;
    private final int pivotIndex;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final KeylineList Empty = new KeylineList(CollectionsKt.emptyList());

    /* renamed from: add  reason: avoid collision after fix types in other method */
    public void add2(int i, Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i, Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends Keyline> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Keyline> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Keyline keyline) {
        return this.$$delegate_0.contains(keyline);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        return this.$$delegate_0.containsAll(collection);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Keyline get(int i) {
        return this.$$delegate_0.get(i);
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    public int indexOf(Keyline keyline) {
        return this.$$delegate_0.indexOf(keyline);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Keyline> iterator() {
        return this.$$delegate_0.iterator();
    }

    public int lastIndexOf(Keyline keyline) {
        return this.$$delegate_0.lastIndexOf(keyline);
    }

    @Override // java.util.List
    public ListIterator<Keyline> listIterator() {
        return this.$$delegate_0.listIterator();
    }

    @Override // java.util.List
    public ListIterator<Keyline> listIterator(int i) {
        return this.$$delegate_0.listIterator(i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Keyline remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Keyline remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<Keyline> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: set  reason: avoid collision after fix types in other method */
    public Keyline set2(int i, Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Keyline set(int i, Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super Keyline> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Keyline> subList(int i, int i2) {
        return this.$$delegate_0.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public KeylineList(List<Keyline> list) {
        int i;
        int i2;
        this.$$delegate_0 = list;
        KeylineList keylineList = this;
        Iterator<Keyline> it = keylineList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i4 = -1;
                break;
            } else if (it.next().isPivot()) {
                break;
            } else {
                i4++;
            }
        }
        this.pivotIndex = i4;
        Iterator<Keyline> it2 = keylineList.iterator();
        int i5 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i5 = -1;
                break;
            } else if (!it2.next().isAnchor()) {
                break;
            } else {
                i5++;
            }
        }
        this.firstNonAnchorIndex = i5;
        ListIterator<Keyline> listIterator = keylineList.listIterator(keylineList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i2 = -1;
                break;
            } else if (!listIterator.previous().isAnchor()) {
                i2 = listIterator.nextIndex();
                break;
            }
        }
        this.lastNonAnchorIndex = i2;
        Iterator<Keyline> it3 = keylineList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                i3 = -1;
                break;
            } else if (it3.next().isFocal()) {
                break;
            } else {
                i3++;
            }
        }
        this.firstFocalIndex = i3;
        ListIterator<Keyline> listIterator2 = keylineList.listIterator(keylineList.size());
        while (true) {
            if (!listIterator2.hasPrevious()) {
                break;
            } else if (listIterator2.previous().isFocal()) {
                i = listIterator2.nextIndex();
                break;
            }
        }
        this.lastFocalIndex = i;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Keyline) {
            return contains((Keyline) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Keyline) {
            return indexOf((Keyline) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Keyline) {
            return lastIndexOf((Keyline) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public final int getPivotIndex() {
        return this.pivotIndex;
    }

    public final Keyline getPivot() {
        return get(this.pivotIndex);
    }

    public final int getFirstNonAnchorIndex() {
        return this.firstNonAnchorIndex;
    }

    public final Keyline getFirstNonAnchor() {
        return get(this.firstNonAnchorIndex);
    }

    public final int getLastNonAnchorIndex() {
        return this.lastNonAnchorIndex;
    }

    public final Keyline getLastNonAnchor() {
        return get(this.lastNonAnchorIndex);
    }

    public final int getFirstFocalIndex() {
        return this.firstFocalIndex;
    }

    public final Keyline getFirstFocal() {
        Keyline keyline = (Keyline) CollectionsKt.getOrNull(this, this.firstFocalIndex);
        if (keyline != null) {
            return keyline;
        }
        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final int getLastFocalIndex() {
        return this.lastFocalIndex;
    }

    public final Keyline getLastFocal() {
        Keyline keyline = (Keyline) CollectionsKt.getOrNull(this, this.lastFocalIndex);
        if (keyline != null) {
            return keyline;
        }
        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final boolean isFirstFocalItemAtStartOfContainer() {
        return getFirstFocal().getOffset() - (getFirstFocal().getSize() / ((float) 2)) >= 0.0f && Intrinsics.areEqual(getFirstFocal(), getFirstNonAnchor());
    }

    public final boolean isLastFocalItemAtEndOfContainer(float f) {
        return getLastFocal().getOffset() + (getLastFocal().getSize() / ((float) 2)) <= f && Intrinsics.areEqual(getLastFocal(), getLastNonAnchor());
    }

    public final int firstIndexAfterFocalRangeWithSize(float f) {
        Integer num;
        KeylineList keylineList = this;
        Iterator<Integer> it = new IntRange(this.lastFocalIndex, CollectionsKt.getLastIndex(keylineList)).iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (get(num.intValue()).getSize() == f) {
                break;
            }
        }
        Integer num2 = num;
        return num2 != null ? num2.intValue() : CollectionsKt.getLastIndex(keylineList);
    }

    public final int lastIndexBeforeFocalRangeWithSize(float f) {
        Integer num;
        Iterator<Integer> it = RangesKt.downTo(this.firstFocalIndex - 1, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (get(num.intValue()).getSize() == f) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 != null) {
            return num2.intValue();
        }
        return 0;
    }

    public final Keyline getKeylineBefore(float f) {
        int size = size() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                Keyline keyline = get(size);
                if (keyline.getUnadjustedOffset() < f) {
                    return keyline;
                }
                if (i < 0) {
                    break;
                }
                size = i;
            }
        }
        return (Keyline) CollectionsKt.first((List<? extends Object>) this);
    }

    public final Keyline getKeylineAfter(float f) {
        Keyline keyline;
        KeylineList keylineList = this;
        int size = keylineList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                keyline = null;
                break;
            }
            keyline = keylineList.get(i);
            if (keyline.getUnadjustedOffset() >= f) {
                break;
            }
            i++;
        }
        Keyline keyline2 = keyline;
        return keyline2 == null ? (Keyline) CollectionsKt.last((List<? extends Object>) keylineList) : keyline2;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KeylineList) {
            KeylineList keylineList = (KeylineList) obj;
            if (size() != keylineList.size()) {
                return false;
            }
            KeylineList keylineList2 = this;
            int size = keylineList2.size();
            for (int i = 0; i < size; i++) {
                if (!Intrinsics.areEqual(keylineList2.get(i), keylineList.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        KeylineList keylineList = this;
        int size = keylineList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += keylineList.get(i2).hashCode() * 31;
        }
        return i;
    }

    /* compiled from: KeylineList.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/carousel/KeylineList$Companion;", "", "()V", "Empty", "Landroidx/compose/material3/carousel/KeylineList;", "getEmpty", "()Landroidx/compose/material3/carousel/KeylineList;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KeylineList getEmpty() {
            return KeylineList.Empty;
        }
    }
}
