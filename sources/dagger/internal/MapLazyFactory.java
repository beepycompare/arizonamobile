package dagger.internal;

import dagger.Lazy;
import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class MapLazyFactory<K, V> extends AbstractMapFactory<K, V, Lazy<V>> {
    private static final Provider<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.emptyMap());

    public static <K, V> Builder<K, V> builder(int size) {
        return new Builder<>(size);
    }

    public static <K, V> Provider<Map<K, Lazy<V>>> emptyMapProvider() {
        return (Provider<Map<K, Lazy<V>>>) EMPTY;
    }

    private MapLazyFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Map<K, Lazy<V>> get() {
        LinkedHashMap newLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        for (Map.Entry<K, Provider<V>> entry : contributingMap().entrySet()) {
            newLinkedHashMapWithExpectedSize.put(entry.getKey(), DoubleCheck.lazy((Provider) entry.getValue()));
        }
        return Collections.unmodifiableMap(newLinkedHashMapWithExpectedSize);
    }

    /* loaded from: classes5.dex */
    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Lazy<V>> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public /* bridge */ /* synthetic */ AbstractMapFactory.Builder put(Object key, Provider providerOfValue) {
            return put((Builder<K, V>) key, providerOfValue);
        }

        private Builder(int size) {
            super(size);
        }

        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K key, Provider<V> providerOfValue) {
            super.put((Builder<K, V>) key, (Provider) providerOfValue);
            return this;
        }

        @Deprecated
        public Builder<K, V> put(K key, javax.inject.Provider<V> providerOfValue) {
            return put((Builder<K, V>) key, (Provider) Providers.asDaggerProvider(providerOfValue));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, Lazy<V>>> mapFactory) {
            super.putAll((Provider) mapFactory);
            return this;
        }

        @Deprecated
        public Builder<K, V> putAll(javax.inject.Provider<Map<K, Lazy<V>>> mapFactory) {
            return putAll((Provider) Providers.asDaggerProvider(mapFactory));
        }

        public MapLazyFactory<K, V> build() {
            return new MapLazyFactory<>(this.map);
        }
    }
}
