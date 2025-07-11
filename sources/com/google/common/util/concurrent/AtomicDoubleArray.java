package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.url._UrlKt;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int length) {
        this.longs = new AtomicLongArray(length);
    }

    public AtomicDoubleArray(double[] array) {
        int length = array.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = Double.doubleToRawLongBits(array[i]);
        }
        this.longs = new AtomicLongArray(jArr);
    }

    public final int length() {
        return this.longs.length();
    }

    public final double get(int i) {
        return Double.longBitsToDouble(this.longs.get(i));
    }

    public final void set(int i, double newValue) {
        this.longs.set(i, Double.doubleToRawLongBits(newValue));
    }

    public final void lazySet(int i, double newValue) {
        this.longs.lazySet(i, Double.doubleToRawLongBits(newValue));
    }

    public final double getAndSet(int i, double newValue) {
        return Double.longBitsToDouble(this.longs.getAndSet(i, Double.doubleToRawLongBits(newValue)));
    }

    public final boolean compareAndSet(int i, double expect, double update) {
        return this.longs.compareAndSet(i, Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    public final boolean weakCompareAndSet(int i, double expect, double update) {
        return this.longs.weakCompareAndSet(i, Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    public final double getAndAdd(int i, double delta) {
        while (true) {
            long j = this.longs.get(i);
            double longBitsToDouble = Double.longBitsToDouble(j);
            int i2 = i;
            if (this.longs.compareAndSet(i2, j, Double.doubleToRawLongBits(longBitsToDouble + delta))) {
                return longBitsToDouble;
            }
            i = i2;
        }
    }

    public double addAndGet(int i, double delta) {
        while (true) {
            long j = this.longs.get(i);
            double longBitsToDouble = Double.longBitsToDouble(j) + delta;
            int i2 = i;
            if (this.longs.compareAndSet(i2, j, Double.doubleToRawLongBits(longBitsToDouble))) {
                return longBitsToDouble;
            }
            i = i2;
        }
    }

    public String toString() {
        int length = length();
        int i = length - 1;
        if (i == -1) {
            return _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length * 19);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        int i2 = 0;
        while (true) {
            sb.append(Double.longBitsToDouble(this.longs.get(i2)));
            if (i2 == i) {
                return sb.append(AbstractJsonLexerKt.END_LIST).toString();
            }
            sb.append(", ");
            i2++;
        }
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        int length = length();
        s.writeInt(length);
        for (int i = 0; i < length; i++) {
            s.writeDouble(get(i));
        }
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int readInt = s.readInt();
        ImmutableLongArray.Builder builder = ImmutableLongArray.builder();
        for (int i = 0; i < readInt; i++) {
            builder.add(Double.doubleToRawLongBits(s.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.build().toArray());
    }
}
