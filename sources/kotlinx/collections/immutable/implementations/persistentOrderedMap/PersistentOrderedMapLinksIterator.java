package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: PersistentOrderedMapContentIterators.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B+\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapLinksIterator;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "nextKey", "", "hashMap", "", "<init>", "(Ljava/lang/Object;Ljava/util/Map;)V", "getNextKey$kotlinx_collections_immutable", "()Ljava/lang/Object;", "setNextKey$kotlinx_collections_immutable", "(Ljava/lang/Object;)V", FirebaseAnalytics.Param.INDEX, "", "getIndex$kotlinx_collections_immutable", "()I", "setIndex$kotlinx_collections_immutable", "(I)V", "hasNext", "", "next", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class PersistentOrderedMapLinksIterator<K, V> implements Iterator<LinkedValue<V>>, KMappedMarker {
    private final Map<K, LinkedValue<V>> hashMap;
    private int index;
    private Object nextKey;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public PersistentOrderedMapLinksIterator(Object obj, Map<K, LinkedValue<V>> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "hashMap");
        this.nextKey = obj;
        this.hashMap = hashMap;
    }

    public final Object getNextKey$kotlinx_collections_immutable() {
        return this.nextKey;
    }

    public final void setNextKey$kotlinx_collections_immutable(Object obj) {
        this.nextKey = obj;
    }

    public final int getIndex$kotlinx_collections_immutable() {
        return this.index;
    }

    public final void setIndex$kotlinx_collections_immutable(int i) {
        this.index = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.hashMap.size();
    }

    @Override // java.util.Iterator
    public LinkedValue<V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        LinkedValue<V> linkedValue = this.hashMap.get(this.nextKey);
        if (linkedValue == null) {
            throw new ConcurrentModificationException("Hash code of a key (" + this.nextKey + ") has changed after it was added to the persistent map.");
        }
        LinkedValue<V> linkedValue2 = linkedValue;
        this.index++;
        this.nextKey = linkedValue2.getNext();
        return linkedValue2;
    }
}
