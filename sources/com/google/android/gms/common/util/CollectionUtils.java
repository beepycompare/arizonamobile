package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-basement@@18.5.0 */
/* loaded from: classes3.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3) {
        Map zza = zza(3, false);
        zza.put(k, v);
        zza.put(k2, v2);
        zza.put(k3, v3);
        return Collections.unmodifiableMap(zza);
    }

    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        } else if (length == 0) {
            return Collections.emptyMap();
        } else {
            if (length == 1) {
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            Map zza = zza(length, false);
            for (int i = 0; i < kArr.length; i++) {
                zza.put(kArr[i], vArr[i]);
            }
            return Collections.unmodifiableMap(zza);
        }
    }

    public static <T> Set<T> mutableSetOfWithSize(int i) {
        if (i == 0) {
            return new ArraySet();
        }
        return zzb(i, true);
    }

    @Deprecated
    public static <T> Set<T> setOf(T t, T t2, T t3) {
        Set zzb = zzb(3, false);
        zzb.add(t);
        zzb.add(t2);
        zzb.add(t3);
        return Collections.unmodifiableSet(zzb);
    }

    private static Map zza(int i, boolean z) {
        if (i <= 256) {
            return new ArrayMap(i);
        }
        return new HashMap(i, 1.0f);
    }

    @Deprecated
    public static <T> List<T> listOf(T t) {
        return Collections.singletonList(t);
    }

    private static Set zzb(int i, boolean z) {
        if (i > (true != z ? 256 : 128)) {
            return new HashSet(i, true != z ? 1.0f : 0.75f);
        }
        return new ArraySet(i);
    }

    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length == 1) {
                return Collections.singletonList(tArr[0]);
            }
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.emptyList();
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map zza = zza(6, false);
        zza.put(k, v);
        zza.put(k2, v2);
        zza.put(k3, v3);
        zza.put(k4, v4);
        zza.put(k5, v5);
        zza.put(k6, v6);
        return Collections.unmodifiableMap(zza);
    }

    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2) {
                    T t = tArr[0];
                    T t2 = tArr[1];
                    Set zzb = zzb(2, false);
                    zzb.add(t);
                    zzb.add(t2);
                    return Collections.unmodifiableSet(zzb);
                } else if (length != 3) {
                    if (length == 4) {
                        T t3 = tArr[0];
                        T t4 = tArr[1];
                        T t5 = tArr[2];
                        T t6 = tArr[3];
                        Set zzb2 = zzb(4, false);
                        zzb2.add(t3);
                        zzb2.add(t4);
                        zzb2.add(t5);
                        zzb2.add(t6);
                        return Collections.unmodifiableSet(zzb2);
                    }
                    Set zzb3 = zzb(length, false);
                    Collections.addAll(zzb3, tArr);
                    return Collections.unmodifiableSet(zzb3);
                } else {
                    return setOf(tArr[0], tArr[1], tArr[2]);
                }
            }
            return Collections.singleton(tArr[0]);
        }
        return Collections.emptySet();
    }
}
