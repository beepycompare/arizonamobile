package kotlinx.collections.immutable.implementations.persistentOrderedSet;

import kotlin.Metadata;
import kotlinx.collections.immutable.internal.EndOfChain;
/* compiled from: PersistentOrderedSet.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lkotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "", "previous", "next", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "()V", "(Ljava/lang/Object;)V", "getPrevious", "()Ljava/lang/Object;", "getNext", "withNext", "newNext", "withPrevious", "newPrevious", "hasNext", "", "getHasNext", "()Z", "hasPrevious", "getHasPrevious", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Links {
    private final Object next;
    private final Object previous;

    public Links(Object obj, Object obj2) {
        this.previous = obj;
        this.next = obj2;
    }

    public final Object getNext() {
        return this.next;
    }

    public final Object getPrevious() {
        return this.previous;
    }

    public Links() {
        this(EndOfChain.INSTANCE, EndOfChain.INSTANCE);
    }

    public Links(Object obj) {
        this(obj, EndOfChain.INSTANCE);
    }

    public final Links withNext(Object obj) {
        return new Links(this.previous, obj);
    }

    public final Links withPrevious(Object obj) {
        return new Links(obj, this.next);
    }

    public final boolean getHasNext() {
        return this.next != EndOfChain.INSTANCE;
    }

    public final boolean getHasPrevious() {
        return this.previous != EndOfChain.INSTANCE;
    }
}
