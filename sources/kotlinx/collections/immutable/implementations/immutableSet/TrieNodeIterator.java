package kotlinx.collections.immutable.implementations.immutableSet;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
/* compiled from: PersistentHashSetIterator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J%\u0010\n\u001a\u00020\u000b2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0016R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", ExifInterface.LONGITUDE_EAST, "", "<init>", "()V", "buffer", "", "[Ljava/lang/Object;", FirebaseAnalytics.Param.INDEX, "", "reset", "", "([Ljava/lang/Object;I)V", "hasNextCell", "", "moveToNextCell", "hasNextElement", "currentElement", "()Ljava/lang/Object;", "nextElement", "hasNextNode", "currentNode", "Lkotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrieNodeIterator<E> {
    private Object[] buffer = TrieNode.Companion.getEMPTY$kotlinx_collections_immutable().getBuffer();
    private int index;

    public static /* synthetic */ void reset$default(TrieNodeIterator trieNodeIterator, Object[] objArr, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        trieNodeIterator.reset(objArr, i);
    }

    public final void reset(Object[] buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        this.index = i;
    }

    public final boolean hasNextCell() {
        return this.index < this.buffer.length;
    }

    public final void moveToNextCell() {
        CommonFunctionsKt.m9966assert(hasNextCell());
        this.index++;
    }

    public final boolean hasNextElement() {
        return hasNextCell() && !(this.buffer[this.index] instanceof TrieNode);
    }

    public final E currentElement() {
        CommonFunctionsKt.m9966assert(hasNextElement());
        return (E) this.buffer[this.index];
    }

    public final E nextElement() {
        CommonFunctionsKt.m9966assert(hasNextElement());
        Object[] objArr = this.buffer;
        int i = this.index;
        this.index = i + 1;
        return (E) objArr[i];
    }

    public final boolean hasNextNode() {
        return hasNextCell() && (this.buffer[this.index] instanceof TrieNode);
    }

    public final TrieNode<? extends E> currentNode() {
        CommonFunctionsKt.m9966assert(hasNextNode());
        Object obj = this.buffer[this.index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNodeIterator>");
        return (TrieNode) obj;
    }
}
