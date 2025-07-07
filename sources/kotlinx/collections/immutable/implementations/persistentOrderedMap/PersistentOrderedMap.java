package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableCollection;
import kotlinx.collections.immutable.ImmutableSet;
import kotlinx.collections.immutable.PersistentMap;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import kotlinx.collections.immutable.internal.EndOfChain;
/* compiled from: PersistentOrderedMap.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 7*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004:\u00017B5\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\u0017H\u0002J\u001a\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\"H\u0001J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u0004\u0018\u00018\u00012\u0006\u0010%\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010(J)\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010+J!\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010-J)\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010%\u001a\u00028\u00002\u0006\u0010*\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010+J*\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0010/\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0016J\u0014\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103H\u0016J\u0013\u00104\u001a\u00020$2\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u00106\u001a\u00020\u0013H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0019¨\u00068"}, d2 = {"Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/AbstractMap;", "Lkotlinx/collections/immutable/PersistentMap;", "firstKey", "", "lastKey", "hashMap", "Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Lkotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "getFirstKey$kotlinx_collections_immutable", "()Ljava/lang/Object;", "getLastKey$kotlinx_collections_immutable", "getHashMap$kotlinx_collections_immutable", "()Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "size", "", "getSize", "()I", UserMetadata.KEYDATA_FILENAME, "Lkotlinx/collections/immutable/ImmutableSet;", "getKeys", "()Lkotlinx/collections/immutable/ImmutableSet;", "values", "Lkotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Lkotlinx/collections/immutable/ImmutableCollection;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "getEntries", "createEntries", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "remove", "(Ljava/lang/Object;)Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "putAll", CmcdData.OBJECT_TYPE_MANIFEST, "", "clear", "builder", "Lkotlinx/collections/immutable/PersistentMap$Builder;", "equals", "other", "hashCode", "Companion", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersistentOrderedMap<K, V> extends AbstractMap<K, V> implements PersistentMap<K, V> {
    public static final Companion Companion = new Companion(null);
    private static final PersistentOrderedMap EMPTY = new PersistentOrderedMap(EndOfChain.INSTANCE, EndOfChain.INSTANCE, PersistentHashMap.Companion.emptyOf$kotlinx_collections_immutable());
    private final Object firstKey;
    private final PersistentHashMap<K, LinkedValue<V>> hashMap;
    private final Object lastKey;

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ ImmutableSet<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ ImmutableSet<K> keySet() {
        return getKeys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMap, java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public /* bridge */ /* synthetic */ PersistentMap put(Object obj, Object obj2) {
        return put((PersistentOrderedMap<K, V>) obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMap, java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public /* bridge */ /* synthetic */ PersistentMap remove(Object obj) {
        return remove((PersistentOrderedMap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map, kotlinx.collections.immutable.PersistentMap
    public /* bridge */ /* synthetic */ PersistentMap remove(Object obj, Object obj2) {
        return remove((PersistentOrderedMap<K, V>) obj, obj2);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ ImmutableCollection<V> values() {
        return getValues();
    }

    public final Object getFirstKey$kotlinx_collections_immutable() {
        return this.firstKey;
    }

    public final Object getLastKey$kotlinx_collections_immutable() {
        return this.lastKey;
    }

    public final PersistentHashMap<K, LinkedValue<V>> getHashMap$kotlinx_collections_immutable() {
        return this.hashMap;
    }

    public PersistentOrderedMap(Object obj, Object obj2, PersistentHashMap<K, LinkedValue<V>> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "hashMap");
        this.firstKey = obj;
        this.lastKey = obj2;
        this.hashMap = hashMap;
    }

    @Override // kotlin.collections.AbstractMap
    public int getSize() {
        return this.hashMap.size();
    }

    @Override // kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public ImmutableSet<K> getKeys() {
        return new PersistentOrderedMapKeys(this);
    }

    @Override // kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public ImmutableCollection<V> getValues() {
        return new PersistentOrderedMapValues(this);
    }

    @Override // kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    private final ImmutableSet<Map.Entry<K, V>> createEntries() {
        return new PersistentOrderedMapEntries(this);
    }

    @Override // kotlin.collections.AbstractMap, androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableMap
    public final Set<Map.Entry<K, V>> getEntries() {
        return createEntries();
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.hashMap.containsKey(obj);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public V get(Object obj) {
        LinkedValue<V> linkedValue = this.hashMap.get(obj);
        if (linkedValue != null) {
            return linkedValue.getValue();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractMap, java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public PersistentOrderedMap<K, V> put(K k, V v) {
        if (isEmpty()) {
            return new PersistentOrderedMap<>(k, k, this.hashMap.put((PersistentHashMap<K, LinkedValue<V>>) k, (K) new LinkedValue<>(v)));
        }
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        if (linkedValue != null) {
            if (linkedValue.getValue() == v) {
                return this;
            }
            return new PersistentOrderedMap<>(this.firstKey, this.lastKey, this.hashMap.put((PersistentHashMap<K, LinkedValue<V>>) k, (K) linkedValue.withValue(v)));
        }
        Object obj = this.lastKey;
        LinkedValue<V> linkedValue2 = this.hashMap.get(obj);
        Intrinsics.checkNotNull(linkedValue2);
        return new PersistentOrderedMap<>(this.firstKey, k, this.hashMap.put((PersistentHashMap<K, LinkedValue<V>>) obj, (Object) linkedValue2.withNext(k)).put((PersistentHashMap) k, (K) new LinkedValue(v, obj)));
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    public PersistentOrderedMap<K, V> remove(K k) {
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        if (linkedValue == null) {
            return this;
        }
        PersistentHashMap<K, LinkedValue<V>> remove = this.hashMap.remove((PersistentHashMap<K, LinkedValue<V>>) k);
        if (linkedValue.getHasPrevious()) {
            LinkedValue<V> linkedValue2 = remove.get(linkedValue.getPrevious());
            Intrinsics.checkNotNull(linkedValue2);
            remove = remove.put((PersistentHashMap<K, LinkedValue<V>>) ((K) linkedValue.getPrevious()), (K) linkedValue2.withNext(linkedValue.getNext()));
        }
        if (linkedValue.getHasNext()) {
            LinkedValue<V> linkedValue3 = remove.get(linkedValue.getNext());
            Intrinsics.checkNotNull(linkedValue3);
            remove = remove.put((PersistentHashMap<K, LinkedValue<V>>) ((K) linkedValue.getNext()), (K) linkedValue3.withPrevious(linkedValue.getPrevious()));
        }
        return new PersistentOrderedMap<>(!linkedValue.getHasPrevious() ? linkedValue.getNext() : this.firstKey, !linkedValue.getHasNext() ? linkedValue.getPrevious() : this.lastKey, remove);
    }

    @Override // java.util.Map, kotlinx.collections.immutable.PersistentMap
    public PersistentOrderedMap<K, V> remove(K k, V v) {
        LinkedValue<V> linkedValue = this.hashMap.get(k);
        return (linkedValue != null && Intrinsics.areEqual(linkedValue.getValue(), v)) ? remove((PersistentOrderedMap<K, V>) k) : this;
    }

    @Override // java.util.Map, kotlinx.collections.immutable.PersistentMap
    public PersistentMap<K, V> putAll(Map<? extends K, ? extends V> m) {
        Intrinsics.checkNotNullParameter(m, "m");
        if (m.isEmpty()) {
            return this;
        }
        PersistentOrderedMap<K, V> persistentOrderedMap = this;
        Intrinsics.checkNotNull(persistentOrderedMap, "null cannot be cast to non-null type kotlinx.collections.immutable.PersistentMap<K of kotlinx.collections.immutable.ExtensionsKt.mutate, V of kotlinx.collections.immutable.ExtensionsKt.mutate>");
        PersistentMap.Builder<K, V> builder = persistentOrderedMap.builder();
        builder.putAll(m);
        return builder.build();
    }

    @Override // java.util.Map, kotlinx.collections.immutable.PersistentMap
    public PersistentMap<K, V> clear() {
        return Companion.emptyOf$kotlinx_collections_immutable();
    }

    @Override // kotlinx.collections.immutable.PersistentMap
    public PersistentMap.Builder<K, V> builder() {
        return new PersistentOrderedMapBuilder(this);
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            if (map instanceof PersistentOrderedMap) {
                return this.hashMap.getNode$kotlinx_collections_immutable().equalsWith$kotlinx_collections_immutable((TrieNode<K, LinkedValue<V>>) ((PersistentOrderedMap) obj).hashMap.getNode$kotlinx_collections_immutable(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap$equals$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj2, Object obj3) {
                        return invoke((LinkedValue) ((LinkedValue) obj2), (LinkedValue) obj3);
                    }

                    public final Boolean invoke(LinkedValue<V> a2, LinkedValue<? extends Object> b) {
                        Intrinsics.checkNotNullParameter(a2, "a");
                        Intrinsics.checkNotNullParameter(b, "b");
                        return Boolean.valueOf(Intrinsics.areEqual(a2.getValue(), b.getValue()));
                    }
                });
            }
            if (map instanceof PersistentOrderedMapBuilder) {
                return this.hashMap.getNode$kotlinx_collections_immutable().equalsWith$kotlinx_collections_immutable((TrieNode<K, LinkedValue<V>>) ((PersistentOrderedMapBuilder) obj).getHashMapBuilder$kotlinx_collections_immutable().getNode$kotlinx_collections_immutable(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap$equals$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj2, Object obj3) {
                        return invoke((LinkedValue) ((LinkedValue) obj2), (LinkedValue) obj3);
                    }

                    public final Boolean invoke(LinkedValue<V> a2, LinkedValue<? extends Object> b) {
                        Intrinsics.checkNotNullParameter(a2, "a");
                        Intrinsics.checkNotNullParameter(b, "b");
                        return Boolean.valueOf(Intrinsics.areEqual(a2.getValue(), b.getValue()));
                    }
                });
            }
            if (map instanceof PersistentHashMap) {
                return this.hashMap.getNode$kotlinx_collections_immutable().equalsWith$kotlinx_collections_immutable(((PersistentHashMap) obj).getNode$kotlinx_collections_immutable(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap$equals$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj2, Object obj3) {
                        return invoke((LinkedValue) ((LinkedValue) obj2), (Object) obj3);
                    }

                    public final Boolean invoke(LinkedValue<V> a2, Object obj2) {
                        Intrinsics.checkNotNullParameter(a2, "a");
                        return Boolean.valueOf(Intrinsics.areEqual(a2.getValue(), obj2));
                    }
                });
            }
            if (map instanceof PersistentHashMapBuilder) {
                return this.hashMap.getNode$kotlinx_collections_immutable().equalsWith$kotlinx_collections_immutable(((PersistentHashMapBuilder) obj).getNode$kotlinx_collections_immutable(), new Function2<LinkedValue<V>, ?, Boolean>() { // from class: kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap$equals$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Boolean invoke(Object obj2, Object obj3) {
                        return invoke((LinkedValue) ((LinkedValue) obj2), (Object) obj3);
                    }

                    public final Boolean invoke(LinkedValue<V> a2, Object obj2) {
                        Intrinsics.checkNotNullParameter(a2, "a");
                        return Boolean.valueOf(Intrinsics.areEqual(a2.getValue(), obj2));
                    }
                });
            }
            return super.equals(obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public int hashCode() {
        return super.hashCode();
    }

    /* compiled from: PersistentOrderedMap.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t0\u0005\"\u0004\b\u0002\u0010\b\"\u0004\b\u0003\u0010\tH\u0000¢\u0006\u0002\b\nR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "", "emptyOf", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "emptyOf$kotlinx_collections_immutable", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <K, V> PersistentOrderedMap<K, V> emptyOf$kotlinx_collections_immutable() {
            PersistentOrderedMap<K, V> persistentOrderedMap = PersistentOrderedMap.EMPTY;
            Intrinsics.checkNotNull(persistentOrderedMap, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap<K of kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf, V of kotlinx.collections.immutable.implementations.persistentOrderedMap.PersistentOrderedMap.Companion.emptyOf>");
            return persistentOrderedMap;
        }
    }
}
