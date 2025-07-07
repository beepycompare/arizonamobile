package kotlinx.collections.immutable.implementations.immutableList;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: AbstractListIterator.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\f"}, d2 = {"Lkotlinx/collections/immutable/implementations/immutableList/SingleElementListIterator;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "element", FirebaseAnalytics.Param.INDEX, "", "<init>", "(Ljava/lang/Object;I)V", "Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "previous", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SingleElementListIterator<E> extends AbstractListIterator<E> {
    private final E element;

    public SingleElementListIterator(E e, int i) {
        super(i, 1);
        this.element = e;
    }

    @Override // kotlinx.collections.immutable.implementations.immutableList.AbstractListIterator, java.util.ListIterator, java.util.Iterator
    public E next() {
        checkHasNext$kotlinx_collections_immutable();
        setIndex(getIndex() + 1);
        return this.element;
    }

    @Override // java.util.ListIterator
    public E previous() {
        checkHasPrevious$kotlinx_collections_immutable();
        setIndex(getIndex() - 1);
        return this.element;
    }
}
