package com.google.common.cache;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface Weigher<K, V> {
    int weigh(K key, V value);
}
