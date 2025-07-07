package coil3.util;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
/* compiled from: LruCache.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\r\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u001d\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0017J\b\u0010\"\u001a\u00020\u0005H\u0002J\u001d\u0010#\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\tR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcoil3/util/LruCache;", "K", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "maxSize", "", "<init>", "(J)V", "getMaxSize", "()J", "map", "", "value", "size", "getSize", UserMetadata.KEYDATA_FILENAME, "", "getKeys", "()Ljava/util/Set;", "sizeOf", "key", "(Ljava/lang/Object;Ljava/lang/Object;)J", "entryRemoved", "", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "remove", "trimToSize", "clear", "recomputeSize", "safeSizeOf", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public class LruCache<K, V> {
    private final Map<K, V> map = Collections_jvmCommonKt.LruMutableMap$default(0, 0.0f, 3, null);
    private final long maxSize;
    private long size;

    public void entryRemoved(K k, V v, V v2) {
    }

    public long sizeOf(K k, V v) {
        return 1L;
    }

    public LruCache(long j) {
        this.maxSize = j;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
    }

    public final long getMaxSize() {
        return this.maxSize;
    }

    public final long getSize() {
        if (this.size == -1) {
            this.size = recomputeSize();
        }
        return this.size;
    }

    public final Set<K> getKeys() {
        return kotlin.collections.CollectionsKt.toSet(this.map.keySet());
    }

    public final V put(K k, V v) {
        V put = this.map.put(k, v);
        this.size = getSize() + safeSizeOf(k, v);
        if (put != null) {
            this.size = getSize() - safeSizeOf(k, put);
            entryRemoved(k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final V get(K k) {
        return this.map.get(k);
    }

    public final V remove(K k) {
        V remove = this.map.remove(k);
        if (remove != null) {
            this.size = getSize() - safeSizeOf(k, remove);
            entryRemoved(k, remove, null);
        }
        return remove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void trimToSize(long j) {
        while (getSize() > j) {
            if (this.map.isEmpty()) {
                if (getSize() != 0) {
                    throw new IllegalStateException("sizeOf() is returning inconsistent values".toString());
                }
                return;
            }
            Map.Entry entry = (Map.Entry) kotlin.collections.CollectionsKt.first(this.map.entrySet());
            Object key = entry.getKey();
            Object value = entry.getValue();
            this.map.remove(key);
            this.size = getSize() - safeSizeOf(key, value);
            entryRemoved(key, value, null);
        }
    }

    public final void clear() {
        trimToSize(-1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long recomputeSize() {
        Iterator<T> it = this.map.entrySet().iterator();
        long j = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j += safeSizeOf(entry.getKey(), entry.getValue());
        }
        return j;
    }

    private final long safeSizeOf(K k, V v) {
        try {
            long sizeOf = sizeOf(k, v);
            if (sizeOf >= 0) {
                return sizeOf;
            }
            throw new IllegalStateException(("sizeOf(" + k + ", " + v + ") returned a negative value: " + sizeOf).toString());
        } catch (Exception e) {
            this.size = -1L;
            throw e;
        }
    }
}
