package kotlinx.collections.immutable.implementations.immutableList;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentCollection;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.collections.immutable.internal.ListImplementation;
/* compiled from: AbstractPersistentList.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00172\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0096\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016¨\u0006\u001e"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/collections/immutable/PersistentList;", "Lkotlin/collections/AbstractList;", "<init>", "()V", "subList", "Lkotlinx/collections/immutable/ImmutableList;", "fromIndex", "", "toIndex", "addAll", "elements", "", FirebaseAnalytics.Param.INDEX, "c", "remove", "element", "(Ljava/lang/Object;)Lkotlinx/collections/immutable/PersistentList;", "removeAll", "retainAll", "clear", "contains", "", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "", "listIterator", "", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbstractPersistentList<E> extends AbstractList<E> implements PersistentList<E> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.List, kotlinx.collections.immutable.PersistentCollection
    public /* bridge */ /* synthetic */ PersistentCollection remove(Object obj) {
        return remove((AbstractPersistentList<E>) obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public ImmutableList<E> subList(int i, int i2) {
        return PersistentList.DefaultImpls.subList(this, i, i2);
    }

    @Override // java.util.Collection, java.util.List, kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return this;
        }
        PersistentList.Builder<E> builder = builder();
        builder.addAll(elements);
        return builder.build();
    }

    @Override // java.util.List, kotlinx.collections.immutable.PersistentList
    public PersistentList<E> addAll(int i, Collection<? extends E> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        ListImplementation.checkPositionIndex$kotlinx_collections_immutable(i, size());
        if (c.isEmpty()) {
            return this;
        }
        PersistentList.Builder<E> builder = builder();
        builder.addAll(i, c);
        return builder.build();
    }

    @Override // java.util.Collection, java.util.List, kotlinx.collections.immutable.PersistentList, kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> remove(E e) {
        int indexOf = indexOf(e);
        if (indexOf != -1) {
            return removeAt(indexOf);
        }
        return this;
    }

    @Override // java.util.Collection, java.util.List, kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> removeAll(final Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.isEmpty() ? this : removeAll((Function1) new Function1() { // from class: kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean contains;
                contains = elements.contains(obj);
                return Boolean.valueOf(contains);
            }
        });
    }

    @Override // java.util.Collection, java.util.List, kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> retainAll(final Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.isEmpty() ? UtilsKt.persistentVectorOf() : removeAll((Function1) new Function1() { // from class: kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                boolean retainAll$lambda$3;
                retainAll$lambda$3 = AbstractPersistentList.retainAll$lambda$3(elements, obj);
                return Boolean.valueOf(retainAll$lambda$3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean retainAll$lambda$3(Collection collection, Object obj) {
        return !collection.contains(obj);
    }

    @Override // java.util.Collection, java.util.List, kotlinx.collections.immutable.PersistentCollection
    public PersistentList<E> clear() {
        return UtilsKt.persistentVectorOf();
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<?> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
}
