package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;
/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReverseOrdering(Ordering<? super T> forwardOrder) {
        this.forwardOrder = (Ordering) Preconditions.checkNotNull(forwardOrder);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@ParametricNullness T a2, @ParametricNullness T b) {
        return this.forwardOrder.compare(b, a2);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return (Ordering<? super T>) this.forwardOrder;
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(@ParametricNullness E a2, @ParametricNullness E b) {
        return (E) this.forwardOrder.max(a2, b);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(@ParametricNullness E a2, @ParametricNullness E b, @ParametricNullness E c, E... rest) {
        return (E) this.forwardOrder.max(a2, b, c, rest);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> iterator) {
        return (E) this.forwardOrder.max(iterator);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(@ParametricNullness E a2, @ParametricNullness E b) {
        return (E) this.forwardOrder.min(a2, b);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(@ParametricNullness E a2, @ParametricNullness E b, @ParametricNullness E c, E... rest) {
        return (E) this.forwardOrder.min(a2, b, c, rest);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> iterator) {
        return (E) this.forwardOrder.min(iterator);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) object).forwardOrder);
        }
        return false;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }
}
