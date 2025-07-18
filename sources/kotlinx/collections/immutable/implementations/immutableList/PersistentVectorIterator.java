package kotlinx.collections.immutable.implementations.immutableList;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: PersistentVectorIterator.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B=\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableList/PersistentVectorIterator;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "root", "", "", "tail", FirebaseAnalytics.Param.INDEX, "", "size", "trieHeight", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;III)V", "[Ljava/lang/Object;", "trieIterator", "Lkotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "next", "()Ljava/lang/Object;", "previous", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersistentVectorIterator<T> extends AbstractListIterator<T> {
    private final T[] tail;
    private final TrieIterator<T> trieIterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersistentVectorIterator(Object[] root, T[] tail, int i, int i2, int i3) {
        super(i, i2);
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.tail = tail;
        int rootSize = UtilsKt.rootSize(i2);
        this.trieIterator = new TrieIterator<>(root, RangesKt.coerceAtMost(i, rootSize), rootSize, i3);
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public T next() {
        checkHasNext$kotlinx_collections_immutable();
        if (this.trieIterator.hasNext()) {
            setIndex(getIndex() + 1);
            return this.trieIterator.next();
        }
        T[] tArr = this.tail;
        int index = getIndex();
        setIndex(index + 1);
        return tArr[index - this.trieIterator.getSize()];
    }

    @Override // java.util.ListIterator
    public T previous() {
        checkHasPrevious$kotlinx_collections_immutable();
        if (getIndex() > this.trieIterator.getSize()) {
            T[] tArr = this.tail;
            setIndex(getIndex() - 1);
            return tArr[getIndex() - this.trieIterator.getSize()];
        }
        setIndex(getIndex() - 1);
        return this.trieIterator.previous();
    }
}
