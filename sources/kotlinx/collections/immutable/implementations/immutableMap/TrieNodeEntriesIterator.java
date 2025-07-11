package kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
/* compiled from: PersistentHashMapContentIterators.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002¨\u0006\b"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeEntriesIterator;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "", "<init>", "()V", "next", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrieNodeEntriesIterator<K, V> extends TrieNodeBaseIterator<K, V, Map.Entry<? extends K, ? extends V>> {
    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        CommonFunctionsKt.m9966assert(hasNextKey());
        setIndex(getIndex() + 2);
        return new MapEntry(getBuffer()[getIndex() - 2], getBuffer()[getIndex() - 1]);
    }
}
