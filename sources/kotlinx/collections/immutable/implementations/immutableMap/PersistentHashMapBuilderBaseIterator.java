package kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
/* compiled from: PersistentHashMapBuilderContentIterators.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005B;\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0013\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001b\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0002\u0010\u001aJI\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "builder", "Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "path", "", "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "<init>", "(Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;[Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "lastIteratedKey", "Ljava/lang/Object;", "nextWasInvoked", "", "expectedModCount", "", "next", "()Ljava/lang/Object;", "remove", "", "setValue", "key", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "resetPath", "keyHash", "node", "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "pathIndex", "removedKeyHash", "afterRemove", "(ILkotlinx/collections/immutable/implementations/immutableMap/TrieNode;Ljava/lang/Object;IIZ)V", "checkNextWasInvoked", "checkForComodification", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class PersistentHashMapBuilderBaseIterator<K, V, T> extends PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMutableIterator {
    private final PersistentHashMapBuilder<K, V> builder;
    private int expectedModCount;
    private K lastIteratedKey;
    private boolean nextWasInvoked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentHashMapBuilderBaseIterator(PersistentHashMapBuilder<K, V> builder, TrieNodeBaseIterator<K, V, T>[] path) {
        super(builder.getNode$kotlinx_collections_immutable(), path);
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(path, "path");
        this.builder = builder;
        this.expectedModCount = builder.getModCount$kotlinx_collections_immutable();
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public T next() {
        checkForComodification();
        this.lastIteratedKey = currentKey();
        this.nextWasInvoked = true;
        return (T) super.next();
    }

    @Override // kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBaseIterator, java.util.Iterator
    public void remove() {
        PersistentHashMapBuilderBaseIterator<K, V, T> persistentHashMapBuilderBaseIterator;
        checkNextWasInvoked();
        if (hasNext()) {
            K currentKey = currentKey();
            TypeIntrinsics.asMutableMap(this.builder).remove(this.lastIteratedKey);
            int hashCode = currentKey != null ? currentKey.hashCode() : 0;
            TrieNode<K, V> node$kotlinx_collections_immutable = this.builder.getNode$kotlinx_collections_immutable();
            K k = this.lastIteratedKey;
            persistentHashMapBuilderBaseIterator = this;
            persistentHashMapBuilderBaseIterator.resetPath(hashCode, node$kotlinx_collections_immutable, currentKey, 0, k != null ? k.hashCode() : 0, true);
        } else {
            persistentHashMapBuilderBaseIterator = this;
            TypeIntrinsics.asMutableMap(persistentHashMapBuilderBaseIterator.builder).remove(persistentHashMapBuilderBaseIterator.lastIteratedKey);
        }
        persistentHashMapBuilderBaseIterator.lastIteratedKey = null;
        persistentHashMapBuilderBaseIterator.nextWasInvoked = false;
        persistentHashMapBuilderBaseIterator.expectedModCount = persistentHashMapBuilderBaseIterator.builder.getModCount$kotlinx_collections_immutable();
    }

    public final void setValue(K k, V v) {
        PersistentHashMapBuilderBaseIterator<K, V, T> persistentHashMapBuilderBaseIterator;
        if (this.builder.containsKey(k)) {
            if (hasNext()) {
                K currentKey = currentKey();
                this.builder.put(k, v);
                persistentHashMapBuilderBaseIterator = this;
                resetPath$default(persistentHashMapBuilderBaseIterator, currentKey != null ? currentKey.hashCode() : 0, this.builder.getNode$kotlinx_collections_immutable(), currentKey, 0, 0, false, 48, null);
            } else {
                persistentHashMapBuilderBaseIterator = this;
                persistentHashMapBuilderBaseIterator.builder.put(k, v);
            }
            persistentHashMapBuilderBaseIterator.expectedModCount = persistentHashMapBuilderBaseIterator.builder.getModCount$kotlinx_collections_immutable();
        }
    }

    static /* synthetic */ void resetPath$default(PersistentHashMapBuilderBaseIterator persistentHashMapBuilderBaseIterator, int i, TrieNode trieNode, Object obj, int i2, int i3, boolean z, int i4, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPath");
        }
        if ((i4 & 16) != 0) {
            i3 = 0;
        }
        if ((i4 & 32) != 0) {
            z = false;
        }
        persistentHashMapBuilderBaseIterator.resetPath(i, trieNode, obj, i2, i3, z);
    }

    private final void resetPath(int i, TrieNode<?, ?> trieNode, K k, int i2, int i3, boolean z) {
        int i4 = i2 * 5;
        if (i4 > 30) {
            getPath()[i2].reset(trieNode.getBuffer$kotlinx_collections_immutable(), trieNode.getBuffer$kotlinx_collections_immutable().length, 0);
            while (!Intrinsics.areEqual(getPath()[i2].currentKey(), k)) {
                getPath()[i2].moveToNextKey();
            }
            setPathLastIndex(i2);
            return;
        }
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i4);
        if (trieNode.hasEntryAt$kotlinx_collections_immutable(indexSegment)) {
            int entryKeyIndex$kotlinx_collections_immutable = trieNode.entryKeyIndex$kotlinx_collections_immutable(indexSegment);
            if (indexSegment == (z ? 1 << TrieNodeKt.indexSegment(i3, i4) : 0) && i2 < getPathLastIndex()) {
                getPath()[getPathLastIndex()].reset(new Object[]{trieNode.getBuffer$kotlinx_collections_immutable()[entryKeyIndex$kotlinx_collections_immutable], trieNode.getBuffer$kotlinx_collections_immutable()[entryKeyIndex$kotlinx_collections_immutable + 1]}, 2);
                return;
            }
            getPath()[i2].reset(trieNode.getBuffer$kotlinx_collections_immutable(), trieNode.entryCount$kotlinx_collections_immutable() * 2, entryKeyIndex$kotlinx_collections_immutable);
            setPathLastIndex(i2);
            return;
        }
        int nodeIndex$kotlinx_collections_immutable = trieNode.nodeIndex$kotlinx_collections_immutable(indexSegment);
        TrieNode<?, ?> nodeAtIndex$kotlinx_collections_immutable = trieNode.nodeAtIndex$kotlinx_collections_immutable(nodeIndex$kotlinx_collections_immutable);
        getPath()[i2].reset(trieNode.getBuffer$kotlinx_collections_immutable(), trieNode.entryCount$kotlinx_collections_immutable() * 2, nodeIndex$kotlinx_collections_immutable);
        resetPath(i, nodeAtIndex$kotlinx_collections_immutable, k, i2 + 1, i3, z);
    }

    private final void checkNextWasInvoked() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    private final void checkForComodification() {
        if (this.builder.getModCount$kotlinx_collections_immutable() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}
