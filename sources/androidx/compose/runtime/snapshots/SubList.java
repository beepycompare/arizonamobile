package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.ranges.RangesKt;
/* compiled from: SnapshotStateList.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010+\n\u0002\b\t\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0096\u0002J\u0015\u0010!\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u001d\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0016\u0010%\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\b\u0010&\u001a\u00020#H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0015\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0016\u0010*\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u0015\u0010+\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001bJ\u0016\u0010,\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016J\u001e\u0010-\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020#H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u00061"}, d2 = {"Landroidx/compose/runtime/snapshots/SubList;", ExifInterface.GPS_DIRECTION_TRUE, "", "parentList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "fromIndex", "", "toIndex", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", TypedValues.CycleType.S_WAVE_OFFSET, "structure", "value", "size", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "get", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "add", "", "(ILjava/lang/Object;)V", "addAll", "clear", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "validateModification", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SubList<T> implements List<T>, KMutableList {
    public static final int $stable = 8;
    private final int offset;
    private final SnapshotStateList<T> parentList;
    private int size;
    private int structure;

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    public SubList(SnapshotStateList<T> snapshotStateList, int i, int i2) {
        this.parentList = snapshotStateList;
        this.offset = i;
        this.structure = SnapshotStateListKt.getStructure(snapshotStateList);
        this.size = i2 - i;
    }

    public final SnapshotStateList<T> getParentList() {
        return this.parentList;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Collection<?> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public T get(int i) {
        validateModification();
        SnapshotStateListKt.validateRange(i, size());
        return this.parentList.get(this.offset + i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        validateModification();
        int i = this.offset;
        Iterator<Integer> it = RangesKt.until(i, size() + i).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (Intrinsics.areEqual(obj, this.parentList.get(nextInt))) {
                return nextInt - this.offset;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        validateModification();
        int size = this.offset + size();
        while (true) {
            size--;
            if (size < this.offset) {
                return -1;
            }
            if (Intrinsics.areEqual(obj, this.parentList.get(size))) {
                return size - this.offset;
            }
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        validateModification();
        this.parentList.add(this.offset + size(), t);
        this.size = size() + 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return true;
    }

    @Override // java.util.List
    public void add(int i, T t) {
        validateModification();
        this.parentList.add(this.offset + i, t);
        this.size = size() + 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        validateModification();
        boolean addAll = this.parentList.addAll(i + this.offset, collection);
        if (addAll) {
            this.size = size() + collection.size();
            this.structure = SnapshotStateListKt.getStructure(this.parentList);
        }
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            validateModification();
            SnapshotStateList<T> snapshotStateList = this.parentList;
            int i = this.offset;
            snapshotStateList.removeRange(i, size() + i);
            this.size = 0;
            this.structure = SnapshotStateListKt.getStructure(this.parentList);
        }
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        validateModification();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i - 1;
        return new SubList$listIterator$1(intRef, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    public T removeAt(int i) {
        validateModification();
        T remove = this.parentList.remove(this.offset + i);
        this.size = size() - 1;
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        validateModification();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i = this.offset;
        int retainAllInRange$runtime = snapshotStateList.retainAllInRange$runtime(collection, i, size() + i);
        if (retainAllInRange$runtime > 0) {
            this.structure = SnapshotStateListKt.getStructure(this.parentList);
            this.size = size() - retainAllInRange$runtime;
        }
        return retainAllInRange$runtime > 0;
    }

    @Override // java.util.List
    public T set(int i, T t) {
        SnapshotStateListKt.validateRange(i, size());
        validateModification();
        T t2 = this.parentList.set(i + this.offset, t);
        this.structure = SnapshotStateListKt.getStructure(this.parentList);
        return t2;
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= size())) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        validateModification();
        SnapshotStateList<T> snapshotStateList = this.parentList;
        int i3 = this.offset;
        return new SubList(snapshotStateList, i + i3, i2 + i3);
    }

    private final void validateModification() {
        if (SnapshotStateListKt.getStructure(this.parentList) != this.structure) {
            throw new ConcurrentModificationException();
        }
    }
}
