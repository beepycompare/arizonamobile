package kotlinx.collections.immutable.implementations.immutableSet;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.DeltaCounter;
import kotlinx.collections.immutable.internal.MutabilityOwnership;
/* compiled from: TrieNode.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u0000 _*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001_B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010%J5\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010'\u001a\u00020\u00042\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010)J.\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010+\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J*\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J=\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00105J=\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00105JE\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010<J(\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J \u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010?\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\bH\u0002J\u0015\u0010@\u001a\u00020\u001a2\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010AJ\u001b\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010CJ'\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00028\u00002\n\u0010E\u001a\u0006\u0012\u0002\b\u00030FH\u0002¢\u0006\u0002\u0010GJ\u001b\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010CJ'\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010#\u001a\u00028\u00002\n\u0010E\u001a\u0006\u0012\u0002\b\u00030FH\u0002¢\u0006\u0002\u0010GJ,\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010$\u001a\u00020\bH\u0002J(\u0010N\u001a\u0004\u0018\u00010\u00022\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010$\u001a\u00020\bH\u0002J(\u0010O\u001a\u0004\u0018\u00010\u00022\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010L\u001a\u00020M2\u0006\u0010$\u001a\u00020\bH\u0002J\b\u0010P\u001a\u00020\u0004H\u0002J\u0016\u0010Q\u001a\u00020\u001a2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J#\u0010R\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u0004¢\u0006\u0002\u0010TJ6\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u00042\u0006\u0010L\u001a\u00020M2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030FJ2\u0010V\u001a\u0004\u0018\u00010\u00022\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u00042\u0006\u0010L\u001a\u00020M2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030FJ2\u0010W\u001a\u0004\u0018\u00010\u00022\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u00042\u0006\u0010L\u001a\u00020M2\n\u0010E\u001a\u0006\u0012\u0002\b\u00030FJ\u001c\u0010X\u001a\u00020\u001a2\f\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u00020\u0004J)\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010S\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u0004¢\u0006\u0002\u0010ZJ5\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010S\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u00042\n\u0010E\u001a\u0006\u0012\u0002\b\u00030F¢\u0006\u0002\u0010\\J)\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010S\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u0004¢\u0006\u0002\u0010ZJ5\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010S\u001a\u00020\u00042\u0006\u0010#\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u00042\n\u0010E\u001a\u0006\u0012\u0002\b\u00030F¢\u0006\u0002\u0010\\R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006`"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", ExifInterface.LONGITUDE_EAST, "", "bitmap", "", "buffer", "", "ownedBy", "Lkotlinx/collections/immutable/internal/MutabilityOwnership;", "<init>", "(I[Ljava/lang/Object;Lkotlinx/collections/immutable/internal/MutabilityOwnership;)V", "(I[Ljava/lang/Object;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Lkotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Lkotlinx/collections/immutable/internal/MutabilityOwnership;)V", "hasNoCellAt", "", "positionMask", "indexOfCellAt", "indexOfCellAt$kotlinx_collections_immutable", "elementAtIndex", FirebaseAnalytics.Param.INDEX, "(I)Ljava/lang/Object;", "nodeAtIndex", "addElementAt", "element", "owner", "(ILjava/lang/Object;Lkotlinx/collections/immutable/internal/MutabilityOwnership;)Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "setProperties", "newBitmap", "newBuffer", "(I[Ljava/lang/Object;Lkotlinx/collections/immutable/internal/MutabilityOwnership;)Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "canonicalizeNodeAtIndex", "nodeIndex", "newNode", "setCellAtIndex", "cellIndex", "newCell", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "shift", "(IILjava/lang/Object;ILkotlinx/collections/immutable/internal/MutabilityOwnership;)Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "(ILjava/lang/Object;ILjava/lang/Object;ILkotlinx/collections/immutable/internal/MutabilityOwnership;)Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "removeCellAtIndex", "collisionRemoveElementAtIndex", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "collisionContainsElement", "(Ljava/lang/Object;)Z", "collisionAdd", "(Ljava/lang/Object;)Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "mutator", "Lkotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(Ljava/lang/Object;Lkotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionRemove", "mutableCollisionRemove", "mutableCollisionAddAll", "otherNode", "intersectionSizeRef", "Lkotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRetainAll", "mutableCollisionRemoveAll", "calculateSize", "elementsIdentityEquals", "contains", "elementHash", "(ILjava/lang/Object;I)Z", "mutableAddAll", "mutableRetainAll", "mutableRemoveAll", "containsAll", "add", "(ILjava/lang/Object;I)Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "(ILjava/lang/Object;ILkotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "remove", "mutableRemove", "Companion", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrieNode<E> {
    public static final Companion Companion = new Companion(null);
    private static final TrieNode EMPTY = new TrieNode(0, new Object[0]);
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    public TrieNode(int i, Object[] buffer, MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.bitmap = i;
        this.buffer = buffer;
        this.ownedBy = mutabilityOwnership;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(int i) {
        this.bitmap = i;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final void setBuffer(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.buffer = objArr;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final void setOwnedBy(MutabilityOwnership mutabilityOwnership) {
        this.ownedBy = mutabilityOwnership;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i, Object[] buffer) {
        this(i, buffer, null);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    private final boolean hasNoCellAt(int i) {
        return (i & this.bitmap) == 0;
    }

    public final int indexOfCellAt$kotlinx_collections_immutable(int i) {
        return Integer.bitCount((i - 1) & this.bitmap);
    }

    private final E elementAtIndex(int i) {
        return (E) this.buffer[i];
    }

    private final TrieNode<E> nodeAtIndex(int i) {
        Object obj = this.buffer[i];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode<E> addElementAt(int i, E e, MutabilityOwnership mutabilityOwnership) {
        Object[] addElementAtIndex;
        int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(i);
        int i2 = i | this.bitmap;
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$kotlinx_collections_immutable, e);
        return setProperties(i2, addElementAtIndex, mutabilityOwnership);
    }

    private final TrieNode<E> setProperties(int i, Object[] objArr, MutabilityOwnership mutabilityOwnership) {
        MutabilityOwnership mutabilityOwnership2 = this.ownedBy;
        if (mutabilityOwnership2 != null && mutabilityOwnership2 == mutabilityOwnership) {
            this.bitmap = i;
            this.buffer = objArr;
            return this;
        }
        return new TrieNode<>(i, objArr, mutabilityOwnership);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v1 */
    private final TrieNode<E> canonicalizeNodeAtIndex(int i, TrieNode<E> trieNode, MutabilityOwnership mutabilityOwnership) {
        ?? r0 = trieNode.buffer;
        if (r0.length == 1) {
            ?? r02 = r0[0];
            if (!(r02 instanceof TrieNode)) {
                if (this.buffer.length == 1) {
                    trieNode.bitmap = this.bitmap;
                    return trieNode;
                }
                trieNode = r02;
            }
        }
        return setCellAtIndex(i, trieNode, mutabilityOwnership);
    }

    private final TrieNode<E> setCellAtIndex(int i, Object obj, MutabilityOwnership mutabilityOwnership) {
        MutabilityOwnership mutabilityOwnership2 = this.ownedBy;
        if (mutabilityOwnership2 != null && mutabilityOwnership2 == mutabilityOwnership) {
            this.buffer[i] = obj;
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        copyOf[i] = obj;
        return new TrieNode<>(this.bitmap, copyOf, mutabilityOwnership);
    }

    private final TrieNode<E> makeNodeAtIndex(int i, int i2, E e, int i3, MutabilityOwnership mutabilityOwnership) {
        E elementAtIndex = elementAtIndex(i);
        return makeNode(elementAtIndex != null ? elementAtIndex.hashCode() : 0, elementAtIndex, i2, e, i3 + 5, mutabilityOwnership);
    }

    private final TrieNode<E> moveElementToNode(int i, int i2, E e, int i3, MutabilityOwnership mutabilityOwnership) {
        return setCellAtIndex(i, makeNodeAtIndex(i, i2, e, i3, mutabilityOwnership), mutabilityOwnership);
    }

    private final TrieNode<E> makeNode(int i, E e, int i2, E e2, int i3, MutabilityOwnership mutabilityOwnership) {
        if (i3 > 30) {
            return new TrieNode<>(0, new Object[]{e, e2}, mutabilityOwnership);
        }
        int indexSegment = TrieNodeKt.indexSegment(i, i3);
        int indexSegment2 = TrieNodeKt.indexSegment(i2, i3);
        if (indexSegment != indexSegment2) {
            return new TrieNode<>((1 << indexSegment) | (1 << indexSegment2), indexSegment < indexSegment2 ? new Object[]{e, e2} : new Object[]{e2, e}, mutabilityOwnership);
        }
        return new TrieNode<>(1 << indexSegment, new Object[]{makeNode(i, e, i2, e2, i3 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode<E> removeCellAtIndex(int i, int i2, MutabilityOwnership mutabilityOwnership) {
        Object[] removeCellAtIndex;
        int i3 = i2 ^ this.bitmap;
        removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        return setProperties(i3, removeCellAtIndex, mutabilityOwnership);
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int i, MutabilityOwnership mutabilityOwnership) {
        Object[] removeCellAtIndex;
        removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        return setProperties(0, removeCellAtIndex, mutabilityOwnership);
    }

    private final boolean collisionContainsElement(E e) {
        return ArraysKt.contains((E[]) this.buffer, e);
    }

    private final TrieNode<E> collisionAdd(E e) {
        Object[] addElementAtIndex;
        if (collisionContainsElement(e)) {
            return this;
        }
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, 0, e);
        return setProperties(0, addElementAtIndex, null);
    }

    private final TrieNode<E> mutableCollisionAdd(E e, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        Object[] addElementAtIndex;
        if (collisionContainsElement(e)) {
            return this;
        }
        persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() + 1);
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, 0, e);
        return setProperties(0, addElementAtIndex, persistentHashSetBuilder.getOwnership$kotlinx_collections_immutable());
    }

    private final TrieNode<E> collisionRemove(E e) {
        int indexOf = ArraysKt.indexOf((E[]) this.buffer, e);
        return indexOf != -1 ? collisionRemoveElementAtIndex(indexOf, null) : this;
    }

    private final TrieNode<E> mutableCollisionRemove(E e, PersistentHashSetBuilder<?> persistentHashSetBuilder) {
        int indexOf = ArraysKt.indexOf((E[]) this.buffer, e);
        if (indexOf != -1) {
            persistentHashSetBuilder.setSize(persistentHashSetBuilder.size() - 1);
            return collisionRemoveElementAtIndex(indexOf, persistentHashSetBuilder.getOwnership$kotlinx_collections_immutable());
        }
        return this;
    }

    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        Object[] objArr2 = trieNode.buffer;
        int length = this.buffer.length;
        int i = 0;
        int i2 = 0;
        while (i < objArr2.length) {
            CommonFunctionsKt.m9966assert(i2 <= i);
            if (!collisionContainsElement((E) objArr2[i])) {
                copyOf[length + i2] = objArr2[i];
                i2++;
                CommonFunctionsKt.m9966assert(length + i2 <= copyOf.length);
            }
            i++;
        }
        int length2 = i2 + this.buffer.length;
        deltaCounter.plusAssign(copyOf.length - length2);
        if (length2 == this.buffer.length) {
            return this;
        }
        if (length2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (length2 != copyOf.length) {
            copyOf = Arrays.copyOf(copyOf, length2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        }
        return setProperties(0, copyOf, mutabilityOwnership);
    }

    private final Object mutableCollisionRetainAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = mutabilityOwnership == this.ownedBy ? this.buffer : new Object[Math.min(this.buffer.length, trieNode.buffer.length)];
        Object[] objArr2 = this.buffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m9966assert(i2 <= i);
            if (trieNode.collisionContainsElement((E) objArr2[i])) {
                objArr[i2] = objArr2[i];
                i2++;
                CommonFunctionsKt.m9966assert(i2 <= objArr.length);
            }
            i++;
        }
        deltaCounter.plusAssign(i2);
        if (i2 == 0) {
            return EMPTY;
        }
        if (i2 == 1) {
            return objArr[0];
        }
        if (i2 == this.buffer.length) {
            return this;
        }
        if (i2 == trieNode.buffer.length) {
            return trieNode;
        }
        if (i2 == objArr.length) {
            return setProperties(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return setProperties(0, copyOf, mutabilityOwnership);
    }

    private final Object mutableCollisionRemoveAll(TrieNode<E> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return EMPTY;
        }
        Object[] objArr = mutabilityOwnership == this.ownedBy ? this.buffer : new Object[this.buffer.length];
        Object[] objArr2 = this.buffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m9966assert(i2 <= i);
            if (!trieNode.collisionContainsElement((E) objArr2[i])) {
                objArr[i2] = objArr2[i];
                i2++;
                CommonFunctionsKt.m9966assert(i2 <= objArr.length);
            }
            i++;
        }
        deltaCounter.plusAssign(this.buffer.length - i2);
        if (i2 == 0) {
            return EMPTY;
        }
        if (i2 == 1) {
            return objArr[0];
        }
        if (i2 == this.buffer.length) {
            return this;
        }
        if (i2 == objArr.length) {
            return setProperties(0, objArr, mutabilityOwnership);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i2);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return setProperties(0, copyOf, mutabilityOwnership);
    }

    private final int calculateSize() {
        Object[] objArr;
        if (this.bitmap == 0) {
            return this.buffer.length;
        }
        int i = 0;
        for (Object obj : this.buffer) {
            i += obj instanceof TrieNode ? ((TrieNode) obj).calculateSize() : 1;
        }
        return i;
    }

    private final boolean elementsIdentityEquals(TrieNode<E> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.bitmap != trieNode.bitmap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != trieNode.buffer[i]) {
                return false;
            }
        }
        return true;
    }

    public final boolean contains(int i, E e, int i2) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return false;
        }
        int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(indexSegment);
        Object obj = this.buffer[indexOfCellAt$kotlinx_collections_immutable];
        if (obj instanceof TrieNode) {
            TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$kotlinx_collections_immutable);
            if (i2 == 30) {
                return nodeAtIndex.collisionContainsElement(e);
            }
            return nodeAtIndex.contains(i, e, i2 + 5);
        }
        return Intrinsics.areEqual(e, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TrieNode<E> mutableAddAll(TrieNode<E> otherNode, int i, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder<?> mutator) {
        Object[] objArr;
        TrieNode<E> makeNode;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.setCount(intersectionSizeRef.getCount() + calculateSize());
            return this;
        } else if (i > 30) {
            return mutableCollisionAddAll(otherNode, intersectionSizeRef, mutator.getOwnership$kotlinx_collections_immutable());
        } else {
            int i2 = this.bitmap;
            int i3 = otherNode.bitmap | i2;
            TrieNode<E> trieNode = (i3 == i2 && Intrinsics.areEqual(this.ownedBy, mutator.getOwnership$kotlinx_collections_immutable())) ? this : new TrieNode<>(i3, new Object[Integer.bitCount(i3)], mutator.getOwnership$kotlinx_collections_immutable());
            int i4 = i3;
            int i5 = 0;
            while (i4 != 0) {
                int lowestOneBit = Integer.lowestOneBit(i4);
                int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(lowestOneBit);
                int indexOfCellAt$kotlinx_collections_immutable2 = otherNode.indexOfCellAt$kotlinx_collections_immutable(lowestOneBit);
                Object[] objArr2 = trieNode.buffer;
                if (hasNoCellAt(lowestOneBit)) {
                    makeNode = (TrieNode<E>) otherNode.buffer[indexOfCellAt$kotlinx_collections_immutable2];
                } else if (otherNode.hasNoCellAt(lowestOneBit)) {
                    makeNode = (E) this.buffer[indexOfCellAt$kotlinx_collections_immutable];
                } else {
                    E e = (E) this.buffer[indexOfCellAt$kotlinx_collections_immutable];
                    E e2 = (E) otherNode.buffer[indexOfCellAt$kotlinx_collections_immutable2];
                    boolean z = e instanceof TrieNode;
                    boolean z2 = e2 instanceof TrieNode;
                    if (z && z2) {
                        Intrinsics.checkNotNull(e, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                        Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                        makeNode = (E) ((TrieNode) e).mutableAddAll((TrieNode) e2, i + 5, intersectionSizeRef, mutator);
                    } else if (z) {
                        Intrinsics.checkNotNull(e, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                        TrieNode trieNode2 = (TrieNode) e;
                        int size = mutator.size();
                        E e3 = (E) trieNode2.mutableAdd(e2 != null ? e2.hashCode() : 0, e2, i + 5, mutator);
                        if (mutator.size() == size) {
                            intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                        }
                        Unit unit = Unit.INSTANCE;
                        makeNode = e3;
                    } else if (z2) {
                        Intrinsics.checkNotNull(e2, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                        TrieNode trieNode3 = (TrieNode) e2;
                        int size2 = mutator.size();
                        E e4 = (E) trieNode3.mutableAdd(e != null ? e.hashCode() : 0, e, i + 5, mutator);
                        if (mutator.size() == size2) {
                            intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                        }
                        Unit unit2 = Unit.INSTANCE;
                        makeNode = e4;
                    } else if (Intrinsics.areEqual(e, e2)) {
                        intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                        Unit unit3 = Unit.INSTANCE;
                        makeNode = e;
                    } else {
                        objArr = objArr2;
                        makeNode = makeNode(e != null ? e.hashCode() : 0, e, e2 != null ? e2.hashCode() : 0, e2, i + 5, mutator.getOwnership$kotlinx_collections_immutable());
                        objArr[i5] = makeNode;
                        i5++;
                        i4 ^= lowestOneBit;
                    }
                }
                objArr = objArr2;
                objArr[i5] = makeNode;
                i5++;
                i4 ^= lowestOneBit;
            }
            return elementsIdentityEquals(trieNode) ? this : otherNode.elementsIdentityEquals(trieNode) ? otherNode : trieNode;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object mutableRetainAll(TrieNode<E> otherNode, int i, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder<?> mutator) {
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(calculateSize());
            return this;
        } else if (i > 30) {
            return mutableCollisionRetainAll(otherNode, intersectionSizeRef, mutator.getOwnership$kotlinx_collections_immutable());
        } else {
            int i2 = this.bitmap & otherNode.bitmap;
            if (i2 == 0) {
                return EMPTY;
            }
            TrieNode<E> trieNode = (Intrinsics.areEqual(this.ownedBy, mutator.getOwnership$kotlinx_collections_immutable()) && i2 == this.bitmap) ? this : new TrieNode<>(i2, new Object[Integer.bitCount(i2)], mutator.getOwnership$kotlinx_collections_immutable());
            int i3 = i2;
            int i4 = 0;
            int i5 = 0;
            while (i3 != 0) {
                int lowestOneBit = Integer.lowestOneBit(i3);
                int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(lowestOneBit);
                int indexOfCellAt$kotlinx_collections_immutable2 = otherNode.indexOfCellAt$kotlinx_collections_immutable(lowestOneBit);
                Object obj = this.buffer[indexOfCellAt$kotlinx_collections_immutable];
                Object obj2 = otherNode.buffer[indexOfCellAt$kotlinx_collections_immutable2];
                boolean z = obj instanceof TrieNode;
                boolean z2 = obj2 instanceof TrieNode;
                if (z && z2) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                    obj = ((TrieNode) obj).mutableRetainAll((TrieNode) obj2, i + 5, intersectionSizeRef, mutator);
                } else if (z) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                    if (((TrieNode) obj).contains(obj2 != null ? obj2.hashCode() : 0, obj2, i + 5)) {
                        intersectionSizeRef.plusAssign(1);
                        obj = obj2;
                    } else {
                        obj = EMPTY;
                    }
                } else if (z2) {
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                    if (((TrieNode) obj2).contains(obj != null ? obj.hashCode() : 0, obj, i + 5)) {
                        intersectionSizeRef.plusAssign(1);
                    } else {
                        obj = EMPTY;
                    }
                } else if (Intrinsics.areEqual(obj, obj2)) {
                    intersectionSizeRef.plusAssign(1);
                } else {
                    obj = EMPTY;
                }
                if (obj != EMPTY) {
                    i4 |= lowestOneBit;
                }
                trieNode.buffer[i5] = obj;
                i5++;
                i3 ^= lowestOneBit;
            }
            int bitCount = Integer.bitCount(i4);
            if (i4 == 0) {
                return EMPTY;
            }
            if (i4 == i2) {
                return trieNode.elementsIdentityEquals(this) ? this : trieNode.elementsIdentityEquals(otherNode) ? otherNode : trieNode;
            } else if (bitCount == 1 && i != 0) {
                Object obj3 = trieNode.buffer[trieNode.indexOfCellAt$kotlinx_collections_immutable(i4)];
                return obj3 instanceof TrieNode ? new TrieNode(i4, new Object[]{obj3}, mutator.getOwnership$kotlinx_collections_immutable()) : obj3;
            } else {
                Object[] objArr = new Object[bitCount];
                Object[] objArr2 = trieNode.buffer;
                int i6 = 0;
                int i7 = 0;
                while (i6 < objArr2.length) {
                    CommonFunctionsKt.m9966assert(i7 <= i6);
                    if (objArr2[i6] != Companion.getEMPTY$kotlinx_collections_immutable()) {
                        objArr[i7] = objArr2[i6];
                        i7++;
                        CommonFunctionsKt.m9966assert(i7 <= bitCount);
                    }
                    i6++;
                }
                return new TrieNode(i4, objArr, mutator.getOwnership$kotlinx_collections_immutable());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c6, code lost:
        if ((r13 instanceof kotlinx.collections.immutable.implementations.immutableSet.TrieNode) == false) goto L21;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mutableRemoveAll(TrieNode<E> otherNode, int i, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder<?> mutator) {
        TrieNode<E> trieNode;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(calculateSize());
            return EMPTY;
        } else if (i > 30) {
            return mutableCollisionRemoveAll(otherNode, intersectionSizeRef, mutator.getOwnership$kotlinx_collections_immutable());
        } else {
            int i2 = this.bitmap & otherNode.bitmap;
            if (i2 != 0) {
                if (Intrinsics.areEqual(this.ownedBy, mutator.getOwnership$kotlinx_collections_immutable())) {
                    trieNode = this;
                } else {
                    int i3 = this.bitmap;
                    Object[] objArr = this.buffer;
                    Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                    trieNode = new TrieNode<>(i3, copyOf, mutator.getOwnership$kotlinx_collections_immutable());
                }
                int i4 = this.bitmap;
                while (i2 != 0) {
                    int lowestOneBit = Integer.lowestOneBit(i2);
                    int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(lowestOneBit);
                    int indexOfCellAt$kotlinx_collections_immutable2 = otherNode.indexOfCellAt$kotlinx_collections_immutable(lowestOneBit);
                    Object obj = this.buffer[indexOfCellAt$kotlinx_collections_immutable];
                    Object obj2 = otherNode.buffer[indexOfCellAt$kotlinx_collections_immutable2];
                    boolean z = obj instanceof TrieNode;
                    boolean z2 = obj2 instanceof TrieNode;
                    if (z && z2) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                        obj = ((TrieNode) obj).mutableRemoveAll((TrieNode) obj2, i + 5, intersectionSizeRef, mutator);
                    } else if (z) {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                        TrieNode trieNode2 = (TrieNode) obj;
                        int size = mutator.size();
                        TrieNode mutableRemove = trieNode2.mutableRemove(obj2 != null ? obj2.hashCode() : 0, obj2, i + 5, mutator);
                        if (size != mutator.size()) {
                            intersectionSizeRef.plusAssign(1);
                            Object[] objArr2 = mutableRemove.buffer;
                            if (objArr2.length == 1) {
                                obj = objArr2[0];
                            }
                            obj = mutableRemove;
                        }
                    } else if (z2) {
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                        if (((TrieNode) obj2).contains(obj != null ? obj.hashCode() : 0, obj, i + 5)) {
                            intersectionSizeRef.plusAssign(1);
                            obj = EMPTY;
                        }
                    } else if (Intrinsics.areEqual(obj, obj2)) {
                        intersectionSizeRef.plusAssign(1);
                        obj = EMPTY;
                    }
                    if (obj == EMPTY) {
                        i4 ^= lowestOneBit;
                    }
                    trieNode.buffer[indexOfCellAt$kotlinx_collections_immutable] = obj;
                    i2 ^= lowestOneBit;
                }
                int bitCount = Integer.bitCount(i4);
                if (i4 == 0) {
                    return EMPTY;
                }
                if (bitCount == 1 && i != 0) {
                    Object obj3 = trieNode.buffer[trieNode.indexOfCellAt$kotlinx_collections_immutable(i4)];
                    return obj3 instanceof TrieNode ? new TrieNode(i4, new Object[]{obj3}, mutator.getOwnership$kotlinx_collections_immutable()) : obj3;
                } else if (i4 == this.bitmap) {
                    if (!trieNode.elementsIdentityEquals(this)) {
                        return trieNode;
                    }
                } else {
                    Object[] objArr3 = new Object[bitCount];
                    Object[] objArr4 = trieNode.buffer;
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < objArr4.length) {
                        CommonFunctionsKt.m9966assert(i6 <= i5);
                        if (objArr4[i5] != Companion.getEMPTY$kotlinx_collections_immutable()) {
                            objArr3[i6] = objArr4[i5];
                            i6++;
                            CommonFunctionsKt.m9966assert(i6 <= bitCount);
                        }
                        i5++;
                    }
                    return new TrieNode(i4, objArr3, mutator.getOwnership$kotlinx_collections_immutable());
                }
            }
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(TrieNode<E> otherNode, int i) {
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        if (this == otherNode) {
            return true;
        }
        if (i > 30) {
            for (Object obj : otherNode.buffer) {
                if (!ArraysKt.contains(this.buffer, obj)) {
                    return false;
                }
            }
            return true;
        }
        int i2 = this.bitmap;
        int i3 = otherNode.bitmap;
        int i4 = i2 & i3;
        if (i4 != i3) {
            return false;
        }
        while (i4 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i4);
            int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(lowestOneBit);
            int indexOfCellAt$kotlinx_collections_immutable2 = otherNode.indexOfCellAt$kotlinx_collections_immutable(lowestOneBit);
            Object obj2 = this.buffer[indexOfCellAt$kotlinx_collections_immutable];
            Object obj3 = otherNode.buffer[indexOfCellAt$kotlinx_collections_immutable2];
            boolean z = obj2 instanceof TrieNode;
            boolean z2 = obj3 instanceof TrieNode;
            if (z && z2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                if (!((TrieNode) obj2).containsAll((TrieNode) obj3, i + 5)) {
                    return false;
                }
            } else if (z) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                if (!((TrieNode) obj2).contains(obj3 != null ? obj3.hashCode() : 0, obj3, i + 5)) {
                    return false;
                }
            } else if (z2 || !Intrinsics.areEqual(obj2, obj3)) {
                return false;
            }
            i4 ^= lowestOneBit;
        }
        return true;
    }

    public final TrieNode<E> add(int i, E e, int i2) {
        TrieNode<E> add;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            return addElementAt(indexSegment, e, null);
        }
        int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(indexSegment);
        Object obj = this.buffer[indexOfCellAt$kotlinx_collections_immutable];
        if (obj instanceof TrieNode) {
            TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$kotlinx_collections_immutable);
            if (i2 == 30) {
                add = nodeAtIndex.collisionAdd(e);
            } else {
                add = nodeAtIndex.add(i, e, i2 + 5);
            }
            if (nodeAtIndex != add) {
                return setCellAtIndex(indexOfCellAt$kotlinx_collections_immutable, add, null);
            }
        } else if (!Intrinsics.areEqual(e, obj)) {
            return moveElementToNode(indexOfCellAt$kotlinx_collections_immutable, i, e, i2, null);
        }
        return this;
    }

    public final TrieNode<E> mutableAdd(int i, E e, int i2, PersistentHashSetBuilder<?> mutator) {
        TrieNode<E> mutableAdd;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (hasNoCellAt(indexSegment)) {
            mutator.setSize(mutator.size() + 1);
            return addElementAt(indexSegment, e, mutator.getOwnership$kotlinx_collections_immutable());
        }
        int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(indexSegment);
        Object obj = this.buffer[indexOfCellAt$kotlinx_collections_immutable];
        if (obj instanceof TrieNode) {
            TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$kotlinx_collections_immutable);
            if (i2 == 30) {
                mutableAdd = nodeAtIndex.mutableCollisionAdd(e, mutator);
            } else {
                mutableAdd = nodeAtIndex.mutableAdd(i, e, i2 + 5, mutator);
            }
            if (nodeAtIndex != mutableAdd) {
                return setCellAtIndex(indexOfCellAt$kotlinx_collections_immutable, mutableAdd, mutator.getOwnership$kotlinx_collections_immutable());
            }
        } else if (!Intrinsics.areEqual(e, obj)) {
            mutator.setSize(mutator.size() + 1);
            return moveElementToNode(indexOfCellAt$kotlinx_collections_immutable, i, e, i2, mutator.getOwnership$kotlinx_collections_immutable());
        }
        return this;
    }

    public final TrieNode<E> remove(int i, E e, int i2) {
        TrieNode<E> remove;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (!hasNoCellAt(indexSegment)) {
            int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(indexSegment);
            Object obj = this.buffer[indexOfCellAt$kotlinx_collections_immutable];
            if (obj instanceof TrieNode) {
                TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$kotlinx_collections_immutable);
                if (i2 == 30) {
                    remove = nodeAtIndex.collisionRemove(e);
                } else {
                    remove = nodeAtIndex.remove(i, e, i2 + 5);
                }
                if (nodeAtIndex != remove) {
                    return canonicalizeNodeAtIndex(indexOfCellAt$kotlinx_collections_immutable, remove, null);
                }
            } else if (Intrinsics.areEqual(e, obj)) {
                return removeCellAtIndex(indexOfCellAt$kotlinx_collections_immutable, indexSegment, null);
            }
        }
        return this;
    }

    public final TrieNode<E> mutableRemove(int i, E e, int i2, PersistentHashSetBuilder<?> mutator) {
        TrieNode<E> mutableRemove;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i, i2);
        if (!hasNoCellAt(indexSegment)) {
            int indexOfCellAt$kotlinx_collections_immutable = indexOfCellAt$kotlinx_collections_immutable(indexSegment);
            Object obj = this.buffer[indexOfCellAt$kotlinx_collections_immutable];
            if (obj instanceof TrieNode) {
                TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$kotlinx_collections_immutable);
                if (i2 == 30) {
                    mutableRemove = nodeAtIndex.mutableCollisionRemove(e, mutator);
                } else {
                    mutableRemove = nodeAtIndex.mutableRemove(i, e, i2 + 5, mutator);
                }
                if (nodeAtIndex.ownedBy == mutator.getOwnership$kotlinx_collections_immutable() || nodeAtIndex != mutableRemove) {
                    return canonicalizeNodeAtIndex(indexOfCellAt$kotlinx_collections_immutable, mutableRemove, mutator.getOwnership$kotlinx_collections_immutable());
                }
            } else if (Intrinsics.areEqual(e, obj)) {
                mutator.setSize(mutator.size() - 1);
                return removeCellAtIndex(indexOfCellAt$kotlinx_collections_immutable, indexSegment, mutator.getOwnership$kotlinx_collections_immutable());
            }
        }
        return this;
    }

    /* compiled from: TrieNode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "<init>", "()V", "EMPTY", "Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$kotlinx_collections_immutable", "()Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrieNode getEMPTY$kotlinx_collections_immutable() {
            return TrieNode.EMPTY;
        }
    }
}
