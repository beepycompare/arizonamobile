package com.google.common.collect;

import com.google.common.collect.RegularImmutableMap;
import java.util.Map;
import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();
    final transient Object[] alternatingKeysAndValues;
    private final transient RegularImmutableBiMap<V, K> inverse;
    @CheckForNull
    private final transient Object keyHashTable;
    private final transient int keyOffset;
    private final transient int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RegularImmutableBiMap() {
        this.keyHashTable = null;
        this.alternatingKeysAndValues = new Object[0];
        this.keyOffset = 0;
        this.size = 0;
        this.inverse = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableBiMap(Object[] alternatingKeysAndValues, int size) {
        this.alternatingKeysAndValues = alternatingKeysAndValues;
        this.size = size;
        this.keyOffset = 0;
        int chooseTableSize = size >= 2 ? ImmutableSet.chooseTableSize(size) : 0;
        this.keyHashTable = RegularImmutableMap.createHashTableOrThrow(alternatingKeysAndValues, size, chooseTableSize, 0);
        this.inverse = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTableOrThrow(alternatingKeysAndValues, size, chooseTableSize, 1), alternatingKeysAndValues, size, this);
    }

    private RegularImmutableBiMap(@CheckForNull Object valueHashTable, Object[] alternatingKeysAndValues, int size, RegularImmutableBiMap<V, K> inverse) {
        this.keyHashTable = valueHashTable;
        this.alternatingKeysAndValues = alternatingKeysAndValues;
        this.keyOffset = 1;
        this.size = size;
        this.inverse = inverse;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object key) {
        V v = (V) RegularImmutableMap.get(this.keyHashTable, this.alternatingKeysAndValues, this.size, this.keyOffset, key);
        if (v == null) {
            return null;
        }
        return v;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.keyOffset, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.keyOffset, this.size));
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return super.writeReplace();
    }
}
