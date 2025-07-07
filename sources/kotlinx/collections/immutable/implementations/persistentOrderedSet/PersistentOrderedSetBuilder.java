package kotlinx.collections.immutable.implementations.persistentOrderedSet;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.PersistentSet;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.EndOfChain;
/* compiled from: PersistentOrderedSetBuilder.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0015\u0010 \u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\b\u0010!\u001a\u00020\"H\u0016J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002J\u0013\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010'\u001a\u00020\u0016H\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lkotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetBuilder;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableSet;", "Lkotlinx/collections/immutable/PersistentSet$Builder;", "set", "Lkotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "<init>", "(Lkotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;)V", "builtSet", "firstElement", "", "getFirstElement$kotlinx_collections_immutable", "()Ljava/lang/Object;", "setFirstElement$kotlinx_collections_immutable", "(Ljava/lang/Object;)V", "lastElement", "hashMapBuilder", "Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Lkotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "getHashMapBuilder$kotlinx_collections_immutable", "()Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "size", "", "getSize", "()I", "build", "Lkotlinx/collections/immutable/PersistentSet;", "contains", "", "element", "(Ljava/lang/Object;)Z", "add", "remove", "clear", "", "iterator", "", "equals", "other", "hashCode", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersistentOrderedSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {
    private PersistentOrderedSet<E> builtSet;
    private Object firstElement;
    private final PersistentHashMapBuilder<E, Links> hashMapBuilder;
    private Object lastElement;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean equals$lambda$2(Links links, Links links2) {
        Intrinsics.checkNotNullParameter(links, "<unused var>");
        Intrinsics.checkNotNullParameter(links2, "<unused var>");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean equals$lambda$3(Links links, Links links2) {
        Intrinsics.checkNotNullParameter(links, "<unused var>");
        Intrinsics.checkNotNullParameter(links2, "<unused var>");
        return true;
    }

    public PersistentOrderedSetBuilder(PersistentOrderedSet<E> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        this.builtSet = set;
        this.firstElement = set.getFirstElement$kotlinx_collections_immutable();
        this.lastElement = set.getLastElement$kotlinx_collections_immutable();
        this.hashMapBuilder = set.getHashMap$kotlinx_collections_immutable().builder();
    }

    public final Object getFirstElement$kotlinx_collections_immutable() {
        return this.firstElement;
    }

    public final void setFirstElement$kotlinx_collections_immutable(Object obj) {
        this.firstElement = obj;
    }

    public final PersistentHashMapBuilder<E, Links> getHashMapBuilder$kotlinx_collections_immutable() {
        return this.hashMapBuilder;
    }

    @Override // kotlin.collections.AbstractMutableSet
    public int getSize() {
        return this.hashMapBuilder.size();
    }

    @Override // kotlinx.collections.immutable.PersistentCollection.Builder
    public PersistentSet<E> build() {
        PersistentOrderedSet<E> persistentOrderedSet = this.builtSet;
        if (persistentOrderedSet != null) {
            CommonFunctionsKt.m9935assert(this.hashMapBuilder.getBuiltMap$kotlinx_collections_immutable() != null);
            CommonFunctionsKt.m9935assert(this.firstElement == persistentOrderedSet.getFirstElement$kotlinx_collections_immutable());
            CommonFunctionsKt.m9935assert(this.lastElement == persistentOrderedSet.getLastElement$kotlinx_collections_immutable());
            return persistentOrderedSet;
        }
        CommonFunctionsKt.m9935assert(this.hashMapBuilder.getBuiltMap$kotlinx_collections_immutable() == null);
        PersistentOrderedSet<E> persistentOrderedSet2 = new PersistentOrderedSet<>(this.firstElement, this.lastElement, this.hashMapBuilder.build());
        this.builtSet = persistentOrderedSet2;
        return persistentOrderedSet2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.hashMapBuilder.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        if (this.hashMapBuilder.containsKey(e)) {
            return false;
        }
        this.builtSet = null;
        if (isEmpty()) {
            this.firstElement = e;
            this.lastElement = e;
            this.hashMapBuilder.put(e, new Links());
            return true;
        }
        Links links = this.hashMapBuilder.get(this.lastElement);
        Intrinsics.checkNotNull(links);
        ((PersistentHashMapBuilder<E, Links>) this.hashMapBuilder).put(this.lastElement, links.withNext(e));
        this.hashMapBuilder.put(e, new Links(this.lastElement));
        this.lastElement = e;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Links remove = this.hashMapBuilder.remove(obj);
        if (remove == null) {
            return false;
        }
        this.builtSet = null;
        if (remove.getHasPrevious()) {
            Links links = this.hashMapBuilder.get(remove.getPrevious());
            Intrinsics.checkNotNull(links);
            ((PersistentHashMapBuilder<E, Links>) this.hashMapBuilder).put(remove.getPrevious(), links.withNext(remove.getNext()));
        } else {
            this.firstElement = remove.getNext();
        }
        if (remove.getHasNext()) {
            Links links2 = this.hashMapBuilder.get(remove.getNext());
            Intrinsics.checkNotNull(links2);
            ((PersistentHashMapBuilder<E, Links>) this.hashMapBuilder).put(remove.getNext(), links2.withPrevious(remove.getPrevious()));
            return true;
        }
        this.lastElement = remove.getPrevious();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (!this.hashMapBuilder.isEmpty()) {
            this.builtSet = null;
        }
        this.hashMapBuilder.clear();
        this.firstElement = EndOfChain.INSTANCE;
        this.lastElement = EndOfChain.INSTANCE;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new PersistentOrderedSetMutableIterator(this);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            if (set instanceof PersistentOrderedSet) {
                return this.hashMapBuilder.getNode$kotlinx_collections_immutable().equalsWith$kotlinx_collections_immutable((TrieNode<E, Links>) ((PersistentOrderedSet) obj).getHashMap$kotlinx_collections_immutable().getNode$kotlinx_collections_immutable(), new Function2() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        boolean equals$lambda$2;
                        equals$lambda$2 = PersistentOrderedSetBuilder.equals$lambda$2((Links) obj2, (Links) obj3);
                        return Boolean.valueOf(equals$lambda$2);
                    }
                });
            }
            if (set instanceof PersistentOrderedSetBuilder) {
                return this.hashMapBuilder.getNode$kotlinx_collections_immutable().equalsWith$kotlinx_collections_immutable((TrieNode<E, Links>) ((PersistentOrderedSetBuilder) obj).hashMapBuilder.getNode$kotlinx_collections_immutable(), new Function2() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedSet.PersistentOrderedSetBuilder$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        boolean equals$lambda$3;
                        equals$lambda$3 = PersistentOrderedSetBuilder.equals$lambda$3((Links) obj2, (Links) obj3);
                        return Boolean.valueOf(equals$lambda$3);
                    }
                });
            }
            return super.equals(obj);
        }
        return false;
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return super.hashCode();
    }
}
