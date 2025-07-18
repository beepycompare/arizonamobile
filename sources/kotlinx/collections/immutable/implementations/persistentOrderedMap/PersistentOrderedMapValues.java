package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableCollection;
/* compiled from: PersistentOrderedMapContentViews.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0010J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012H\u0096\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapValues;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/collections/immutable/ImmutableCollection;", "Lkotlin/collections/AbstractCollection;", "map", "Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "<init>", "(Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersistentOrderedMapValues<K, V> extends AbstractCollection<V> implements ImmutableCollection<V> {
    private final PersistentOrderedMap<K, V> map;

    public PersistentOrderedMapValues(PersistentOrderedMap<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.map.size();
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<V> iterator() {
        return new PersistentOrderedMapValuesIterator(this.map);
    }
}
