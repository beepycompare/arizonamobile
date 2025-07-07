package kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
/* compiled from: PersistentHashMapContentIterators.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\b\u0012\u0004\u0012\u0002H\u00030\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\u0015\u001a\u00020\u00162\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0017J#\u0010\u0015\u001a\u00020\u00162\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000b\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0016\u0010\u001f\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010 J\u0006\u0010!\u001a\u00020\u0016J\t\u0010\"\u001a\u00020\u001aH\u0096\u0002R0\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "value", "", "", "buffer", "getBuffer", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "dataSize", "", FirebaseAnalytics.Param.INDEX, "getIndex", "()I", "setIndex", "(I)V", "reset", "", "([Ljava/lang/Object;II)V", "([Ljava/lang/Object;I)V", "hasNextKey", "", "currentKey", "()Ljava/lang/Object;", "moveToNextKey", "hasNextNode", "currentNode", "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveToNextNode", "hasNext", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class TrieNodeBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {
    private Object[] buffer = TrieNode.Companion.getEMPTY$kotlinx_collections_immutable().getBuffer$kotlinx_collections_immutable();
    private int dataSize;
    private int index;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object[] getBuffer() {
        return this.buffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setIndex(int i) {
        this.index = i;
    }

    public final void reset(Object[] buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        this.dataSize = i;
        this.index = i2;
    }

    public final void reset(Object[] buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        reset(buffer, i, 0);
    }

    public final boolean hasNextKey() {
        return this.index < this.dataSize;
    }

    public final K currentKey() {
        CommonFunctionsKt.m9935assert(hasNextKey());
        return (K) this.buffer[this.index];
    }

    public final void moveToNextKey() {
        CommonFunctionsKt.m9935assert(hasNextKey());
        this.index += 2;
    }

    public final boolean hasNextNode() {
        CommonFunctionsKt.m9935assert(this.index >= this.dataSize);
        return this.index < this.buffer.length;
    }

    public final TrieNode<? extends K, ? extends V> currentNode() {
        CommonFunctionsKt.m9935assert(hasNextNode());
        Object obj = this.buffer[this.index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (TrieNode) obj;
    }

    public final void moveToNextNode() {
        CommonFunctionsKt.m9935assert(hasNextNode());
        this.index++;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return hasNextKey();
    }
}
