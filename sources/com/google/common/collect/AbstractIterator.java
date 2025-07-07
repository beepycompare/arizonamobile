package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull
    private T next;
    private State state = State.NOT_READY;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    @CheckForNull
    protected abstract T computeNext();

    /* JADX INFO: Access modifiers changed from: protected */
    @CheckForNull
    public final T endOfData() {
        this.state = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Preconditions.checkState(this.state != State.FAILED);
        int ordinal = this.state.ordinal();
        if (ordinal != 0) {
            if (ordinal != 2) {
                return tryToComputeNext();
            }
            return false;
        }
        return true;
    }

    private boolean tryToComputeNext() {
        this.state = State.FAILED;
        this.next = computeNext();
        if (this.state != State.DONE) {
            this.state = State.READY;
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.state = State.NOT_READY;
        T t = (T) NullnessCasts.uncheckedCastNullableTToT(this.next);
        this.next = null;
        return t;
    }

    @ParametricNullness
    public final T peek() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return (T) NullnessCasts.uncheckedCastNullableTToT(this.next);
    }
}
