package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlinx.collections.immutable.implementations.immutableMap.MapEntry;
/* compiled from: PersistentOrderedMapBuilderContentIterators.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B7\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lkotlinx/collections/immutable/implementations/persistentOrderedMap/MutableMapEntry;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "", "mutableMap", "", "Lkotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "key", "links", "<init>", "(Ljava/util/Map;Ljava/lang/Object;Lkotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;)V", "value", "getValue", "()Ljava/lang/Object;", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
final class MutableMapEntry<K, V> extends MapEntry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
    private LinkedValue<V> links;
    private final Map<K, LinkedValue<V>> mutableMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableMapEntry(Map<K, LinkedValue<V>> mutableMap, K k, LinkedValue<V> links) {
        super(k, links.getValue());
        Intrinsics.checkNotNullParameter(mutableMap, "mutableMap");
        Intrinsics.checkNotNullParameter(links, "links");
        this.mutableMap = mutableMap;
        this.links = links;
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public V getValue() {
        return this.links.getValue();
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.MapEntry, java.util.Map.Entry
    public V setValue(V v) {
        V value = this.links.getValue();
        this.links = this.links.withValue(v);
        this.mutableMap.put(getKey(), this.links);
        return value;
    }
}
