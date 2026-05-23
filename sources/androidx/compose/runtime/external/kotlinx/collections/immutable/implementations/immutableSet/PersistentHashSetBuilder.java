package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PersistentHashSetBuilder.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001f\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010\"\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010#\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0016\u0010$\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0016J\u0015\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\b\u0010&\u001a\u00020'H\u0016J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0011@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0011@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;)V", "value", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "node", "getNode$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "modCount", "getModCount$runtime", "()I", "size", "getSize", "setSize", "(I)V", "build", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "addAll", "elements", "", "retainAll", "removeAll", "containsAll", "remove", "clear", "", "iterator", "", "runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PersistentHashSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {
    public static final int $stable = 8;
    private int modCount;
    private TrieNode<E> node;
    private MutabilityOwnership ownership = new MutabilityOwnership();
    private PersistentHashSet<E> set;
    private int size;

    public PersistentHashSetBuilder(PersistentHashSet<E> persistentHashSet) {
        this.set = persistentHashSet;
        this.node = this.set.getNode$runtime();
        this.size = this.set.size();
    }

    public final MutabilityOwnership getOwnership$runtime() {
        return this.ownership;
    }

    public final TrieNode<E> getNode$runtime() {
        return this.node;
    }

    public final int getModCount$runtime() {
        return this.modCount;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.size;
    }

    public void setSize(int i) {
        this.size = i;
        this.modCount++;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet.Builder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentHashSet<E> build() {
        PersistentHashSet<E> persistentHashSet;
        if (this.node == this.set.getNode$runtime()) {
            persistentHashSet = this.set;
        } else {
            this.ownership = new MutabilityOwnership();
            persistentHashSet = new PersistentHashSet<>(this.node, size());
        }
        this.set = persistentHashSet;
        return persistentHashSet;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.node.contains(obj != null ? obj.hashCode() : 0, obj, 0);
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        int size = size();
        this.node = this.node.mutableAdd(e != null ? e.hashCode() : 0, e, 0, this);
        return size != size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        PersistentHashSet<E> persistentHashSet = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSet == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSet = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSet != null) {
            DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
            int size = size();
            TrieNode<E> mutableAddAll = this.node.mutableAddAll(persistentHashSet.getNode$runtime(), 0, deltaCounter, this);
            int size2 = (collection.size() + size) - deltaCounter.getCount();
            if (size != size2) {
                this.node = mutableAddAll;
                setSize(size2);
            }
            return size != size();
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        PersistentHashSet<E> persistentHashSet = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSet == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSet = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSet != null) {
            DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
            int size = size();
            Object mutableRetainAll = this.node.mutableRetainAll(persistentHashSet.getNode$runtime(), 0, deltaCounter, this);
            int count = deltaCounter.getCount();
            if (count == 0) {
                clear();
            } else if (count != size) {
                Intrinsics.checkNotNull(mutableRetainAll, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
                this.node = (TrieNode) mutableRetainAll;
                setSize(count);
            }
            return size != size();
        }
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        PersistentHashSet<E> persistentHashSet = collection instanceof PersistentHashSet ? (PersistentHashSet) collection : null;
        if (persistentHashSet == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = collection instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) collection : null;
            persistentHashSet = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (persistentHashSet != null) {
            DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
            int size = size();
            Object mutableRemoveAll = this.node.mutableRemoveAll(persistentHashSet.getNode$runtime(), 0, deltaCounter, this);
            int count = size - deltaCounter.getCount();
            if (count == 0) {
                clear();
            } else if (count != size) {
                Intrinsics.checkNotNull(mutableRemoveAll, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
                this.node = (TrieNode) mutableRemoveAll;
                setSize(count);
            }
            return size != size();
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof PersistentHashSet) {
            return this.node.containsAll(((PersistentHashSet) collection).getNode$runtime(), 0);
        }
        if (collection instanceof PersistentHashSetBuilder) {
            return this.node.containsAll(((PersistentHashSetBuilder) collection).node, 0);
        }
        return super.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int size = size();
        this.node = this.node.mutableRemove(obj != null ? obj.hashCode() : 0, obj, 0, this);
        return size != size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        TrieNode<E> eMPTY$runtime = TrieNode.Companion.getEMPTY$runtime();
        Intrinsics.checkNotNull(eMPTY$runtime, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = eMPTY$runtime;
        setSize(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new PersistentHashSetMutableIterator(this);
    }
}
