package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;
/* loaded from: classes3.dex */
public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail;

    /* loaded from: classes3.dex */
    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        this.capacity = i;
        Object[] objArr = new Object[i + 1];
        this.head = objArr;
        this.tail = objArr;
    }

    public void add(T t) {
        int i = this.capacity;
        int i2 = this.offset;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.tail[i] = objArr;
            this.tail = objArr;
            i2 = 0;
        }
        this.tail[i2] = t;
        this.offset = i2 + 1;
    }

    public void setFirst(T t) {
        this.head[0] = t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i = this.capacity;
        for (Object[] objArr = this.head; objArr != null; objArr = objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj == null) {
                    break;
                } else if (nonThrowingPredicate.test(obj)) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(Subscriber<? super U> subscriber) {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr2, subscriber)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                } else if (NotificationLite.acceptFull(objArr2, observer)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    public <S> void forEachWhile(S s, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Object[] objArr = this.head;
        int i = this.capacity;
        while (true) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj == null || biPredicate.test(s, obj)) {
                    return;
                }
            }
            objArr = objArr[i];
        }
    }
}
