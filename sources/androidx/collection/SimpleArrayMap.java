package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: SimpleArrayMap.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B!\b\u0016\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u001f\u0010\u001d\u001a\u00028\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ,\u0010 \u001a\u0002H!\"\n\b\u0002\u0010!*\u0004\u0018\u00018\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001e\u001a\u0002H!H\u0082\b¢\u0006\u0002\u0010\u001fJ\b\u0010\"\u001a\u00020\u0007H\u0016J\u001d\u0010#\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0007H\u0002J\u0017\u0010)\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0001¢\u0006\u0004\b*\u0010'J\b\u0010+\u001a\u00020\u0012H\u0016J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ \u00100\u001a\u00020\u00102\u0016\u0010\u0004\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000H\u0016J\u001f\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ\u0017\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u001d\u00102\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00103J\u0015\u00104\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.J\u001f\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001fJ%\u00105\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u00106\u001a\u00028\u00012\u0006\u00107\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00108J\u001d\u00109\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010:J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010;\u001a\u00020<H\u0016J\u0015\u0010=\u001a\u00028\u00012\u0006\u0010-\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010.R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Landroidx/collection/SimpleArrayMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "(Landroidx/collection/SimpleArrayMap;)V", "capacity", "", "(I)V", "array", "", "[Ljava/lang/Object;", "hashes", "", "size", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "ensureCapacity", "minimumCapacity", "equals", "other", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefaultInternal", ExifInterface.GPS_DIRECTION_TRUE, "hashCode", "indexOf", "hash", "(Ljava/lang/Object;I)I", "indexOfKey", "(Ljava/lang/Object;)I", "indexOfNull", "indexOfValue", "__restricted$indexOfValue", "isEmpty", "keyAt", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "put", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "toString", "", "valueAt", "collection"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    public SimpleArrayMap(int i) {
        int[] iArr;
        Object[] objArr;
        if (i == 0) {
            iArr = ContainerHelpersKt.EMPTY_INTS;
        } else {
            iArr = new int[i];
        }
        this.hashes = iArr;
        if (i == 0) {
            objArr = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            objArr = new Object[i << 1];
        }
        this.array = objArr;
    }

    public /* synthetic */ SimpleArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }

    private final int indexOf(K k, int i) {
        int i2 = this.size;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i2, i);
        if (binarySearch >= 0 && !Intrinsics.areEqual(k, this.array[binarySearch << 1])) {
            int i3 = binarySearch + 1;
            while (i3 < i2 && this.hashes[i3] == i) {
                if (Intrinsics.areEqual(k, this.array[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = binarySearch - 1; i4 >= 0 && this.hashes[i4] == i; i4--) {
                if (Intrinsics.areEqual(k, this.array[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return binarySearch;
    }

    private final int indexOfNull() {
        int i = this.size;
        if (i == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i, 0);
        if (binarySearch >= 0 && this.array[binarySearch << 1] != null) {
            int i2 = binarySearch + 1;
            while (i2 < i && this.hashes[i2] == 0) {
                if (this.array[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = binarySearch - 1; i3 >= 0 && this.hashes[i3] == 0; i3--) {
                if (this.array[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return binarySearch;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public void ensureCapacity(int i) {
        int i2 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, i);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
            this.array = copyOf2;
        }
        if (this.size != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k) {
        return indexOfKey(k) >= 0;
    }

    public int indexOfKey(K k) {
        if (k == null) {
            return indexOfNull();
        }
        return indexOf(k, k.hashCode());
    }

    public final int __restricted$indexOfValue(V v) {
        int i = this.size * 2;
        Object[] objArr = this.array;
        if (v == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (Intrinsics.areEqual(v, objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(V v) {
        return __restricted$indexOfValue(v) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object obj, T t) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? (T) this.array[(indexOfKey << 1) + 1] : t;
    }

    public K keyAt(int i) {
        boolean z = false;
        if (i >= 0 && i < this.size) {
            z = true;
        }
        if (!z) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + i);
        }
        return (K) this.array[i << 1];
    }

    public V valueAt(int i) {
        boolean z = false;
        if (i >= 0 && i < this.size) {
            z = true;
        }
        if (!z) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + i);
        }
        return (V) this.array[(i << 1) + 1];
    }

    public V setValueAt(int i, V v) {
        boolean z = false;
        if (i >= 0 && i < this.size) {
            z = true;
        }
        if (!z) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + i);
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.array;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public V put(K k, V v) {
        int i = this.size;
        int hashCode = k != null ? k.hashCode() : 0;
        int indexOf = k != null ? indexOf(k, hashCode) : indexOfNull();
        if (indexOf >= 0) {
            int i2 = (indexOf << 1) + 1;
            Object[] objArr = this.array;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
        int i3 = ~indexOf;
        int[] iArr = this.hashes;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i4);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i4 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
            this.array = copyOf2;
            if (i != this.size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.hashes;
            int i5 = i3 + 1;
            ArraysKt.copyInto(iArr2, iArr2, i5, i3, i);
            Object[] objArr2 = this.array;
            ArraysKt.copyInto(objArr2, objArr2, i5 << 1, i3 << 1, this.size << 1);
        }
        int i6 = this.size;
        if (i == i6) {
            int[] iArr3 = this.hashes;
            if (i3 < iArr3.length) {
                iArr3[i3] = hashCode;
                Object[] objArr3 = this.array;
                int i7 = i3 << 1;
                objArr3[i7] = k;
                objArr3[i7 + 1] = v;
                this.size = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        int i = map.size;
        ensureCapacity(this.size + i);
        if (this.size != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(map.keyAt(i2), map.valueAt(i2));
            }
        } else if (i > 0) {
            ArraysKt.copyInto(map.hashes, this.hashes, 0, 0, i);
            ArraysKt.copyInto(map.array, this.array, 0, 0, i << 1);
            this.size = i;
        }
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(K k) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public boolean remove(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0 || !Intrinsics.areEqual(v, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public V removeAt(int i) {
        if (!(i >= 0 && i < this.size)) {
            RuntimeHelpersKt.throwIllegalArgumentException("Expected index to be within 0..size()-1, but was " + i);
        }
        Object[] objArr = this.array;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.size;
        if (i3 <= 1) {
            clear();
            return v;
        }
        int i4 = i3 - 1;
        int[] iArr = this.hashes;
        if (iArr.length > 8 && i3 < iArr.length / 3) {
            int i5 = i3 > 8 ? i3 + (i3 >> 1) : 8;
            int[] copyOf = Arrays.copyOf(iArr, i5);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.array, i5 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
            this.array = copyOf2;
            if (i3 != this.size) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                ArraysKt.copyInto(iArr, this.hashes, 0, 0, i);
                ArraysKt.copyInto(objArr, this.array, 0, 0, i2);
            }
            if (i < i4) {
                int i6 = i + 1;
                ArraysKt.copyInto(iArr, this.hashes, i, i6, i3);
                ArraysKt.copyInto(objArr, this.array, i2, i6 << 1, i3 << 1);
            }
        } else {
            if (i < i4) {
                int i7 = i + 1;
                ArraysKt.copyInto(iArr, iArr, i, i7, i3);
                Object[] objArr2 = this.array;
                ArraysKt.copyInto(objArr2, objArr2, i2, i7 << 1, i3 << 1);
            }
            Object[] objArr3 = this.array;
            int i8 = i4 << 1;
            objArr3[i8] = null;
            objArr3[i8 + 1] = null;
        }
        if (i3 != this.size) {
            throw new ConcurrentModificationException();
        }
        this.size = i4;
        return v;
    }

    public V replace(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0 || !Intrinsics.areEqual(v, valueAt(indexOfKey))) {
            return false;
        }
        setValueAt(indexOfKey, v2);
        return true;
    }

    public int size() {
        return this.size;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i = this.size;
                for (int i2 = 0; i2 < i; i2++) {
                    K keyAt = keyAt(i2);
                    V valueAt = valueAt(i2);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(valueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            } else if ((obj instanceof Map) && size() == ((Map) obj).size()) {
                int i3 = this.size;
                for (int i4 = 0; i4 < i3; i4++) {
                    K keyAt2 = keyAt(i4);
                    V valueAt2 = valueAt(i4);
                    Object obj3 = ((Map) obj).get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !((Map) obj).containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(valueAt2, obj3)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i = this.size;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i2);
            if (keyAt != sb) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i2);
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public V get(K k) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return (V) this.array[(indexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object obj, V v) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? (V) this.array[(indexOfKey << 1) + 1] : v;
    }
}
