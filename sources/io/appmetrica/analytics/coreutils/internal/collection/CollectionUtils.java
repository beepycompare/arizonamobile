package io.appmetrica.analytics.coreutils.internal.collection;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001J(\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0007JC\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00018\u00002\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u000b\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u00102\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00028\u00000\u0011H\u0007J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J?\u0010\u001c\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ8\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tH\u0007J\"\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 \"\u0004\b\u0000\u0010\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007J4\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0007J4\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0007J/\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\"\u0004\b\u0000\u0010\u00102\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000$\"\u00028\u0000H\u0007¢\u0006\u0004\b&\u0010'J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190 2\u0006\u0010(\u001a\u00020\u0016H\u0007J)\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00120 2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120$\"\u00020\u0012H\u0007¢\u0006\u0004\b+\u0010,J>\u0010.\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-\u0018\u00010 \"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011H\u0007J<\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u001a\u0010/\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-\u0018\u00010 H\u0007J>\u00101\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u001a\u0010/\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-\u0018\u00010 H\u0007J&\u00102\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 \"\u0004\b\u0000\u0010\u00102\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002H\u0007J8\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0011H\u0007J)\u00104\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010 H\u0007¢\u0006\u0004\b4\u00105J\u001c\u00108\u001a\u0002072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002060\u0011H\u0007J\u001e\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u0002060\u00112\b\u0010\u0017\u001a\u0004\u0018\u000107H\u0007J&\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 \"\u0004\b\u0000\u0010\u00102\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H\u0007J\u0016\u0010<\u001a\u00020\u00052\f\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0007¨\u0006="}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/collection/CollectionUtils;", "", "", TtmlNode.LEFT, TtmlNode.RIGHT, "", "areCollectionsEqual", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "key", "value", "", "putOpt", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", ExifInterface.GPS_DIRECTION_TRUE, "", "", "getFromMapIgnoreCase", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "convertMapKeysToLowerCase", "", "input", "", "", "hashSetFromIntArray", "defValue", "getOrDefault", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "copyOf", "original", "", "unmodifiableListCopy", "unmodifiableMapCopy", "unmodifiableSameOrderMapCopy", "", "values", "unmodifiableSetOf", "([Ljava/lang/Object;)Ljava/util/Set;", "array", "toIntList", "elements", "createSortedListWithoutRepetitions", "([Ljava/lang/String;)Ljava/util/List;", "", "getListFromMap", "list", "getMapFromList", "getMapFromListOrNull", "arrayListCopyOfNullableCollection", "mapCopyOfNullableMap", "getFirstOrNull", "(Ljava/util/List;)Ljava/lang/Object;", "", "Landroid/os/Bundle;", "mapToBundle", "bundleToMap", "nullIfEmptyList", "collection", "isNullOrEmpty", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class CollectionUtils {
    public static final CollectionUtils INSTANCE = new CollectionUtils();

    private CollectionUtils() {
    }

    @JvmStatic
    public static final boolean areCollectionsEqual(Collection<? extends Object> collection, Collection<? extends Object> collection2) {
        HashSet hashSet;
        if (collection == null && collection2 == null) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        if (collection instanceof HashSet) {
            hashSet = (HashSet) collection;
            collection = collection2;
        } else if (collection2 instanceof HashSet) {
            hashSet = (HashSet) collection2;
        } else {
            HashSet hashSet2 = new HashSet(collection);
            collection = collection2;
            hashSet = hashSet2;
        }
        for (Object obj : collection) {
            if (!hashSet.contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final <T> List<T> arrayListCopyOfNullableCollection(Collection<? extends T> collection) {
        if (collection != null) {
            return CollectionsKt.toList(collection);
        }
        return null;
    }

    @JvmStatic
    public static final Map<String, byte[]> bundleToMap(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                byte[] byteArray = bundle.getByteArray(str);
                if (byteArray != null) {
                    hashMap.put(str, byteArray);
                }
            }
        }
        return hashMap;
    }

    @JvmStatic
    public static final <T> Map<String, T> convertMapKeysToLowerCase(Map<String, ? extends T> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            linkedHashMap.put(str != null ? str.toLowerCase(Locale.getDefault()) : null, entry.getValue());
        }
        return linkedHashMap;
    }

    @JvmStatic
    public static final <K, V> Map<K, V> copyOf(Map<K, V> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new HashMap(map);
    }

    @JvmStatic
    public static final List<String> createSortedListWithoutRepetitions(String... strArr) {
        return unmodifiableListCopy(ArraysKt.toSortedSet(strArr));
    }

    @JvmStatic
    public static final <T> T getFirstOrNull(List<? extends T> list) {
        if (list != null) {
            return (T) CollectionsKt.firstOrNull((List<? extends Object>) list);
        }
        return null;
    }

    @JvmStatic
    public static final <T> T getFromMapIgnoreCase(Map<String, ? extends T> map, String str) {
        T t;
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Map.Entry entry = (Map.Entry) t;
            CharSequence charSequence = (CharSequence) entry.getKey();
            if (charSequence != null && charSequence.length() != 0 && StringsKt.equals((String) entry.getKey(), str, true)) {
                break;
            }
        }
        Map.Entry entry2 = (Map.Entry) t;
        if (entry2 != null) {
            return (T) entry2.getValue();
        }
        return null;
    }

    @JvmStatic
    public static final <K, V> List<Map.Entry<K, V>> getListFromMap(Map<K, ? extends V> map) {
        if (map != null) {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
                arrayList.add(new AbstractMap.SimpleEntry(entry));
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <K, V> Map<K, V> getMapFromList(List<? extends Map.Entry<? extends K, ? extends V>> list) {
        if (list != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            return linkedHashMap;
        }
        return new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <K, V> Map<K, V> getMapFromListOrNull(List<? extends Map.Entry<? extends K, ? extends V>> list) {
        if (list != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            return linkedHashMap;
        }
        return null;
    }

    @JvmStatic
    public static final <K, V> V getOrDefault(Map<K, ? extends V> map, K k, V v) {
        V v2 = map.get(k);
        return v2 == null ? v : v2;
    }

    @JvmStatic
    public static final Set<Integer> hashSetFromIntArray(int[] iArr) {
        return ArraysKt.toHashSet(iArr);
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @JvmStatic
    public static final <K, V> Map<K, V> mapCopyOfNullableMap(Map<K, ? extends V> map) {
        if (map != null) {
            return MapsKt.toMap(map);
        }
        return null;
    }

    @JvmStatic
    public static final Bundle mapToBundle(Map<String, byte[]> map) {
        Bundle bundle = new Bundle(map.size());
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            bundle.putByteArray(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T> List<T> nullIfEmptyList(List<? extends T> list) {
        if (list == 0 || list.isEmpty()) {
            return null;
        }
        return list;
    }

    @JvmStatic
    public static final <K, V> void putOpt(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    @JvmStatic
    public static final List<Integer> toIntList(int[] iArr) {
        return ArraysKt.toList(iArr);
    }

    @JvmStatic
    public static final <T> List<T> unmodifiableListCopy(Collection<? extends T> collection) {
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    @JvmStatic
    public static final <K, V> Map<K, V> unmodifiableMapCopy(Map<K, ? extends V> map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }

    @JvmStatic
    public static final <K, V> Map<K, V> unmodifiableSameOrderMapCopy(Map<K, ? extends V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    @JvmStatic
    public static final <T> Set<T> unmodifiableSetOf(T... tArr) {
        return Collections.unmodifiableSet(ArraysKt.toHashSet(tArr));
    }
}
