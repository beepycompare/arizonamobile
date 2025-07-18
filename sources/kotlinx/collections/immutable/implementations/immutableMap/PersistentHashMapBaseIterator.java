package kotlinx.collections.immutable.implementations.immutableMap;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* compiled from: PersistentHashMapContentIterators.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B;\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\r\u0010\u001d\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001eJ\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\u000e\u0010\u001f\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010 \u001a\u00020\u001cH\u0002R.\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\bX\u0084\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "node", "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "path", "", "Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "<init>", "(Lkotlinx/collections/immutable/implementations/immutableMap/TrieNode;[Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", "getPath", "()[Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "[Lkotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "pathLastIndex", "", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "hasNext", "", "getHasNext$annotations", "()V", "moveToNextNodeWithData", "pathIndex", "ensureNextEntryIsReady", "", "currentKey", "()Ljava/lang/Object;", "next", "checkHasNext", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {
    private boolean hasNext;
    private final TrieNodeBaseIterator<K, V, T>[] path;
    private int pathLastIndex;

    private static /* synthetic */ void getHasNext$annotations() {
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public PersistentHashMapBaseIterator(TrieNode<K, V> node, TrieNodeBaseIterator<K, V, T>[] path) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
        this.hasNext = true;
        path[0].reset(node.getBuffer$kotlinx_collections_immutable(), node.entryCount$kotlinx_collections_immutable() * 2);
        this.pathLastIndex = 0;
        ensureNextEntryIsReady();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TrieNodeBaseIterator<K, V, T>[] getPath() {
        return this.path;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getPathLastIndex() {
        return this.pathLastIndex;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setPathLastIndex(int i) {
        this.pathLastIndex = i;
    }

    private final int moveToNextNodeWithData(int i) {
        if (this.path[i].hasNextKey()) {
            return i;
        }
        if (this.path[i].hasNextNode()) {
            TrieNode<? extends K, ? extends V> currentNode = this.path[i].currentNode();
            if (i == 6) {
                this.path[i + 1].reset(currentNode.getBuffer$kotlinx_collections_immutable(), currentNode.getBuffer$kotlinx_collections_immutable().length);
            } else {
                this.path[i + 1].reset(currentNode.getBuffer$kotlinx_collections_immutable(), currentNode.entryCount$kotlinx_collections_immutable() * 2);
            }
            return moveToNextNodeWithData(i + 1);
        }
        return -1;
    }

    private final void ensureNextEntryIsReady() {
        if (this.path[this.pathLastIndex].hasNextKey()) {
            return;
        }
        for (int i = this.pathLastIndex; -1 < i; i--) {
            int moveToNextNodeWithData = moveToNextNodeWithData(i);
            if (moveToNextNodeWithData == -1 && this.path[i].hasNextNode()) {
                this.path[i].moveToNextNode();
                moveToNextNodeWithData = moveToNextNodeWithData(i);
            }
            if (moveToNextNodeWithData != -1) {
                this.pathLastIndex = moveToNextNodeWithData;
                return;
            }
            if (i > 0) {
                this.path[i - 1].moveToNextNode();
            }
            this.path[i].reset(TrieNode.Companion.getEMPTY$kotlinx_collections_immutable().getBuffer$kotlinx_collections_immutable(), 0);
        }
        this.hasNext = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final K currentKey() {
        checkHasNext();
        return this.path[this.pathLastIndex].currentKey();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public T next() {
        checkHasNext();
        T next = this.path[this.pathLastIndex].next();
        ensureNextEntryIsReady();
        return next;
    }

    private final void checkHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }
}
