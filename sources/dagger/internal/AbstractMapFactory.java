package dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, Provider<V>> contributingMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMapFactory(Map<K, Provider<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Provider<V>> contributingMap() {
        return this.contributingMap;
    }

    /* loaded from: classes4.dex */
    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> map;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(int size) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(size);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V, V2> put(K key, Provider<V> providerOfValue) {
            this.map.put(Preconditions.checkNotNull(key, "key"), (Provider) Preconditions.checkNotNull(providerOfValue, "provider"));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder<K, V, V2> putAll(Provider<Map<K, V2>> mapOfProviders) {
            if (!(mapOfProviders instanceof DelegateFactory)) {
                this.map.putAll(((AbstractMapFactory) mapOfProviders).contributingMap);
                return this;
            }
            return putAll(((DelegateFactory) mapOfProviders).getDelegate());
        }
    }
}
