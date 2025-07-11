package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
/* compiled from: ThreadSafeHeap.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\u0017\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\u0010\u001cJ\r\u0010\u001d\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001eJ$\u0010 \u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\b¢\u0006\u0002\u0010\u001cJ\u0013\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0002\u0010$J,\u0010%\u001a\u00020\u00152\u0006\u0010#\u001a\u00028\u00002\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00150\u0019H\u0086\b¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00152\u0006\u0010#\u001a\u00028\u0000¢\u0006\u0002\u0010)J\u000f\u0010*\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010\u001eJ\u0015\u0010+\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010-J\u0015\u0010.\u001a\u00020\"2\u0006\u0010#\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010$J\u0011\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0082\u0010J\u0011\u00101\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000eH\u0082\u0010J\u0015\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tH\u0002¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\"2\u0006\u00100\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000eH\u0002R\u001a\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u00066"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "_size", "Lkotlinx/atomicfu/AtomicInt;", "value", "", "size", "getSize", "()I", "setSize", "(I)V", "isEmpty", "", "()Z", "find", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "removeFirstIf", "addLast", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLastIf", "cond", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "removeAtImpl", FirebaseAnalytics.Param.INDEX, "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "siftUpFrom", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "siftDownFrom", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "swap", "j", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _size$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* renamed from: a  reason: collision with root package name */
    private T[] f1324a;

    private final /* synthetic */ int get_size$volatile() {
        return this._size$volatile;
    }

    private final /* synthetic */ void set_size$volatile(int i) {
        this._size$volatile = i;
    }

    public final int getSize() {
        return _size$volatile$FU.get(this);
    }

    private final void setSize(int i) {
        _size$volatile$FU.set(this, i);
    }

    public final boolean isEmpty() {
        return getSize() == 0;
    }

    public final T firstImpl() {
        T[] tArr = this.f1324a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final T removeAtImpl(int i) {
        if (!DebugKt.getASSERTIONS_ENABLED() || getSize() > 0) {
            T[] tArr = this.f1324a;
            Intrinsics.checkNotNull(tArr);
            setSize(getSize() - 1);
            if (i < getSize()) {
                swap(i, getSize());
                int i2 = (i - 1) / 2;
                if (i > 0) {
                    T t = tArr[i];
                    Intrinsics.checkNotNull(t);
                    T t2 = tArr[i2];
                    Intrinsics.checkNotNull(t2);
                    if (((Comparable) t).compareTo(t2) < 0) {
                        swap(i, i2);
                        siftUpFrom(i2);
                    }
                }
                siftDownFrom(i);
            }
            T t3 = tArr[getSize()];
            Intrinsics.checkNotNull(t3);
            if (!DebugKt.getASSERTIONS_ENABLED() || t3.getHeap() == this) {
                t3.setHeap(null);
                t3.setIndex(-1);
                tArr[getSize()] = null;
                return t3;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public final void addImpl(T t) {
        if (DebugKt.getASSERTIONS_ENABLED() && t.getHeap() != null) {
            throw new AssertionError();
        }
        t.setHeap(this);
        T[] realloc = realloc();
        int size = getSize();
        setSize(size + 1);
        realloc[size] = t;
        t.setIndex(size);
        siftUpFrom(size);
    }

    private final void siftUpFrom(int i) {
        while (i > 0) {
            T[] tArr = this.f1324a;
            Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            Intrinsics.checkNotNull(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            swap(i, i2);
            i = i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void siftDownFrom(int i) {
        while (true) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (i3 >= getSize()) {
                return;
            }
            T[] tArr = this.f1324a;
            Intrinsics.checkNotNull(tArr);
            int i4 = i2 + 2;
            if (i4 < getSize()) {
                T t = tArr[i4];
                Intrinsics.checkNotNull(t);
                T t2 = tArr[i3];
                Intrinsics.checkNotNull(t2);
            }
            i4 = i3;
            T t3 = tArr[i];
            Intrinsics.checkNotNull(t3);
            T t4 = tArr[i4];
            Intrinsics.checkNotNull(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            swap(i, i4);
            i = i4;
        }
    }

    private final T[] realloc() {
        T[] tArr = this.f1324a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.f1324a = tArr2;
            return tArr2;
        } else if (getSize() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, getSize() * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.f1324a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void swap(int i, int i2) {
        T[] tArr = this.f1324a;
        Intrinsics.checkNotNull(tArr);
        T t = tArr[i2];
        Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }

    public final T find(Function1<? super T, Boolean> function1) {
        T t;
        synchronized (this) {
            int size = getSize();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                T[] tArr = this.f1324a;
                t = tArr != null ? tArr[i] : null;
                Intrinsics.checkNotNull(t);
                if (function1.invoke(t).booleanValue()) {
                    break;
                }
                i++;
            }
        }
        return t;
    }

    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final T removeFirstOrNull() {
        T removeAtImpl;
        synchronized (this) {
            removeAtImpl = getSize() > 0 ? removeAtImpl(0) : null;
        }
        return removeAtImpl;
    }

    public final T removeFirstIf(Function1<? super T, Boolean> function1) {
        synchronized (this) {
            T firstImpl = firstImpl();
            if (firstImpl == null) {
                return null;
            }
            return function1.invoke(firstImpl).booleanValue() ? removeAtImpl(0) : null;
        }
    }

    public final void addLast(T t) {
        synchronized (this) {
            addImpl(t);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(T t, Function1<? super T, Boolean> function1) {
        boolean z;
        synchronized (this) {
            if (function1.invoke(firstImpl()).booleanValue()) {
                addImpl(t);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean remove(T t) {
        boolean z;
        synchronized (this) {
            if (t.getHeap() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (DebugKt.getASSERTIONS_ENABLED() && index < 0) {
                    throw new AssertionError();
                }
                removeAtImpl(index);
                z = true;
            }
        }
        return z;
    }
}
