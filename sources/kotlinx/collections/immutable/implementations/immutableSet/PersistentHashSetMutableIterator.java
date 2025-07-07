package kotlinx.collections.immutable.implementations.immutableSet;

import androidx.exifinterface.media.ExifInterface;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
/* compiled from: PersistentHashSetMutableIterator.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J1\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\r2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u000b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetMutableIterator;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "", "builder", "Lkotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "<init>", "(Lkotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)V", "lastIteratedElement", "Ljava/lang/Object;", "nextWasInvoked", "", "expectedModCount", "", "next", "()Ljava/lang/Object;", "remove", "", "resetPath", "hashCode", "node", "Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "element", "pathIndex", "(ILkotlinx/collections/immutable/implementations/immutableSet/TrieNode;Ljava/lang/Object;I)V", "isCollision", "checkNextWasInvoked", "checkForComodification", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersistentHashSetMutableIterator<E> extends PersistentHashSetIterator<E> implements Iterator<E>, KMutableIterator {
    private final PersistentHashSetBuilder<E> builder;
    private int expectedModCount;
    private E lastIteratedElement;
    private boolean nextWasInvoked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentHashSetMutableIterator(PersistentHashSetBuilder<E> builder) {
        super(builder.getNode$kotlinx_collections_immutable());
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.expectedModCount = builder.getModCount$kotlinx_collections_immutable();
    }

    @Override // kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public E next() {
        checkForComodification();
        E e = (E) super.next();
        this.lastIteratedElement = e;
        this.nextWasInvoked = true;
        return e;
    }

    @Override // kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetIterator, java.util.Iterator
    public void remove() {
        checkNextWasInvoked();
        if (hasNext()) {
            E currentElement = currentElement();
            TypeIntrinsics.asMutableCollection(this.builder).remove(this.lastIteratedElement);
            resetPath(currentElement != null ? currentElement.hashCode() : 0, this.builder.getNode$kotlinx_collections_immutable(), currentElement, 0);
        } else {
            TypeIntrinsics.asMutableCollection(this.builder).remove(this.lastIteratedElement);
        }
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$kotlinx_collections_immutable();
    }

    private final void resetPath(int i, TrieNode<?> trieNode, E e, int i2) {
        if (isCollision(trieNode)) {
            int indexOf = ArraysKt.indexOf((E[]) trieNode.getBuffer(), e);
            CommonFunctionsKt.m9935assert(indexOf != -1);
            getPath().get(i2).reset(trieNode.getBuffer(), indexOf);
            setPathLastIndex(i2);
            return;
        }
        int indexOfCellAt$kotlinx_collections_immutable = trieNode.indexOfCellAt$kotlinx_collections_immutable(1 << TrieNodeKt.indexSegment(i, i2 * 5));
        getPath().get(i2).reset(trieNode.getBuffer(), indexOfCellAt$kotlinx_collections_immutable);
        Object obj = trieNode.getBuffer()[indexOfCellAt$kotlinx_collections_immutable];
        if (obj instanceof TrieNode) {
            resetPath(i, (TrieNode) obj, e, i2 + 1);
        } else {
            setPathLastIndex(i2);
        }
    }

    private final boolean isCollision(TrieNode<?> trieNode) {
        return trieNode.getBitmap() == 0;
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
