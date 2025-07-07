package kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.collections.immutable.internal.EndOfChain;
/* compiled from: PersistentOrderedMap.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "value", "previous", "next", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPrevious", "getNext", "withValue", "newValue", "(Ljava/lang/Object;)Lkotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "withPrevious", "newPrevious", "withNext", "newNext", "hasNext", "", "getHasNext", "()Z", "hasPrevious", "getHasPrevious", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LinkedValue<V> {
    private final Object next;
    private final Object previous;
    private final V value;

    public LinkedValue(V v, Object obj, Object obj2) {
        this.value = v;
        this.previous = obj;
        this.next = obj2;
    }

    public final Object getNext() {
        return this.next;
    }

    public final Object getPrevious() {
        return this.previous;
    }

    public final V getValue() {
        return this.value;
    }

    public LinkedValue(V v) {
        this(v, EndOfChain.INSTANCE, EndOfChain.INSTANCE);
    }

    public LinkedValue(V v, Object obj) {
        this(v, obj, EndOfChain.INSTANCE);
    }

    public final LinkedValue<V> withValue(V v) {
        return new LinkedValue<>(v, this.previous, this.next);
    }

    public final LinkedValue<V> withPrevious(Object obj) {
        return new LinkedValue<>(this.value, obj, this.next);
    }

    public final LinkedValue<V> withNext(Object obj) {
        return new LinkedValue<>(this.value, this.previous, obj);
    }

    public final boolean getHasNext() {
        return this.next != EndOfChain.INSTANCE;
    }

    public final boolean getHasPrevious() {
        return this.previous != EndOfChain.INSTANCE;
    }
}
