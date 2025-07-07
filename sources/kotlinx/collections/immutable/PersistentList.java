package kotlinx.collections.immutable;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMutableList;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentCollection;
/* compiled from: ImmutableList.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0019J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\rH&J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\tH&J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0015J#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0011\u001a\u00020\u0012H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H&¨\u0006\u001a"}, d2 = {"Lkotlinx/collections/immutable/PersistentList;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/collections/immutable/ImmutableList;", "Lkotlinx/collections/immutable/PersistentCollection;", "add", "element", "(Ljava/lang/Object;)Lkotlinx/collections/immutable/PersistentList;", "addAll", "elements", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "", "retainAll", "clear", FirebaseAnalytics.Param.INDEX, "", "c", "set", "(ILjava/lang/Object;)Lkotlinx/collections/immutable/PersistentList;", "removeAt", "builder", "Lkotlinx/collections/immutable/PersistentList$Builder;", "Builder", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PersistentList<E> extends ImmutableList<E>, PersistentCollection<E> {

    /* compiled from: ImmutableList.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lkotlinx/collections/immutable/PersistentList$Builder;", ExifInterface.LONGITUDE_EAST, "", "Lkotlinx/collections/immutable/PersistentCollection$Builder;", "build", "Lkotlinx/collections/immutable/PersistentList;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Builder<E> extends List<E>, PersistentCollection.Builder<E>, KMutableList {
        @Override // kotlinx.collections.immutable.PersistentCollection.Builder
        PersistentList<E> build();
    }

    @Override // java.util.List
    PersistentList<E> add(int i, E e);

    @Override // java.util.List, java.util.Collection, kotlinx.collections.immutable.PersistentCollection
    PersistentList<E> add(E e);

    @Override // java.util.List
    PersistentList<E> addAll(int i, Collection<? extends E> collection);

    @Override // java.util.List, java.util.Collection, kotlinx.collections.immutable.PersistentCollection
    PersistentList<E> addAll(Collection<? extends E> collection);

    @Override // kotlinx.collections.immutable.PersistentCollection
    Builder<E> builder();

    @Override // java.util.List, java.util.Collection, kotlinx.collections.immutable.PersistentCollection
    PersistentList<E> clear();

    @Override // java.util.List, java.util.Collection, kotlinx.collections.immutable.PersistentCollection
    PersistentList<E> remove(E e);

    @Override // java.util.List, java.util.Collection, kotlinx.collections.immutable.PersistentCollection
    PersistentList<E> removeAll(Collection<? extends E> collection);

    @Override // kotlinx.collections.immutable.PersistentCollection
    PersistentList<E> removeAll(Function1<? super E, Boolean> function1);

    PersistentList<E> removeAt(int i);

    @Override // java.util.List, java.util.Collection, kotlinx.collections.immutable.PersistentCollection
    PersistentList<E> retainAll(Collection<? extends E> collection);

    @Override // java.util.List
    PersistentList<E> set(int i, E e);

    /* compiled from: ImmutableList.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <E> ImmutableList<E> subList(PersistentList<? extends E> persistentList, int i, int i2) {
            return ImmutableList.DefaultImpls.subList(persistentList, i, i2);
        }
    }
}
