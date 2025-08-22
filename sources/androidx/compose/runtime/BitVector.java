package androidx.compose.runtime;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: SlotTable.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086\u0002J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000eH\u0086\u0002J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ%\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0017H\u0082\bJ\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/BitVector;", "", "<init>", "()V", "first", "", "second", "others", "", "size", "", "getSize", "()I", "get", "", FirebaseAnalytics.Param.INDEX, "set", "", "value", "nextSet", "nextClear", "nextBit", "valueSelector", "Lkotlin/Function1;", "setRange", TtmlNode.START, TtmlNode.END, "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BitVector {
    public static final int $stable = 8;
    private long first;
    private long[] others;
    private long second;

    public BitVector() {
        long[] jArr;
        jArr = SlotTableKt.EmptyLongArray;
        this.others = jArr;
    }

    public final int getSize() {
        return (this.others.length + 2) * 64;
    }

    public final boolean get(int i) {
        int i2;
        if (i < 64) {
            return ((1 << i) & this.first) != 0;
        } else if (i < 128) {
            return ((1 << (i - 64)) & this.second) != 0;
        } else {
            long[] jArr = this.others;
            int length = jArr.length;
            if (length != 0 && (i / 64) - 2 < length) {
                return ((1 << (i % 64)) & jArr[i2]) != 0;
            }
            return false;
        }
    }

    public final void set(int i, boolean z) {
        if (i < 64) {
            this.first = ((z ? 1L : 0L) << i) | ((~(1 << i)) & this.first);
        } else if (i < 128) {
            this.second = ((z ? 1L : 0L) << i) | ((~(1 << (i - 64))) & this.second);
        } else {
            int i2 = i / 64;
            int i3 = i2 - 2;
            int i4 = i % 64;
            long j = 1 << i4;
            long[] jArr = this.others;
            if (i3 >= jArr.length) {
                jArr = Arrays.copyOf(jArr, i2 - 1);
                Intrinsics.checkNotNullExpressionValue(jArr, "copyOf(...)");
                this.others = jArr;
            }
            jArr[i3] = ((z ? 1L : 0L) << i4) | ((~j) & jArr[i3]);
        }
    }

    private final int nextBit(int i, Function1<? super Long, Long> function1) {
        int numberOfTrailingZeros;
        if (i >= 64 || (numberOfTrailingZeros = Long.numberOfTrailingZeros((function1.invoke(Long.valueOf(this.first)).longValue() >>> i) << i)) >= 64) {
            if (i < 128) {
                int i2 = i - 64;
                int numberOfTrailingZeros2 = Long.numberOfTrailingZeros((function1.invoke(Long.valueOf(this.second)).longValue() >>> i2) << i2);
                if (numberOfTrailingZeros2 < 64) {
                    return numberOfTrailingZeros2 + 64;
                }
            }
            int max = Math.max(i, 128);
            int i3 = (max / 64) - 2;
            long[] jArr = this.others;
            int length = jArr.length;
            for (int i4 = i3; i4 < length; i4++) {
                long longValue = function1.invoke(Long.valueOf(jArr[i4])).longValue();
                if (i4 == i3) {
                    int i5 = max % 64;
                    longValue = (longValue >>> i5) << i5;
                }
                int numberOfTrailingZeros3 = Long.numberOfTrailingZeros(longValue);
                if (numberOfTrailingZeros3 < 64) {
                    return (i4 * 64) + 128 + numberOfTrailingZeros3;
                }
            }
            return Integer.MAX_VALUE;
        }
        return numberOfTrailingZeros;
    }

    public final void setRange(int i, int i2) {
        long j = i < i2 ? -1L : 0L;
        this.first = ((((i < 64 ? 1 : 0) * j) >>> (64 - (Math.min(64, i2) - i))) << i) | this.first;
        if (i2 > 64) {
            int max = Math.max(i, 64);
            this.second = (((j * (max < 128 ? 1 : 0)) >>> (128 - (Math.min(128, i2) - max))) << max) | this.second;
            if (i2 > 128) {
                for (int max2 = Math.max(max, 128); max2 < i2; max2++) {
                    set(max2, true);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BitVector [");
        int size = getSize();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            if (get(i)) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i);
                z = false;
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final int nextSet(int i) {
        int numberOfTrailingZeros;
        if (i >= 64 || (numberOfTrailingZeros = Long.numberOfTrailingZeros((this.first >>> i) << i)) >= 64) {
            if (i < 128) {
                int i2 = i - 64;
                int numberOfTrailingZeros2 = Long.numberOfTrailingZeros((this.second >>> i2) << i2);
                if (numberOfTrailingZeros2 < 64) {
                    return numberOfTrailingZeros2 + 64;
                }
            }
            int max = Math.max(i, 128);
            int i3 = (max / 64) - 2;
            long[] jArr = this.others;
            int length = jArr.length;
            for (int i4 = i3; i4 < length; i4++) {
                long j = jArr[i4];
                if (i4 == i3) {
                    int i5 = max % 64;
                    j = (j >>> i5) << i5;
                }
                int numberOfTrailingZeros3 = Long.numberOfTrailingZeros(j);
                if (numberOfTrailingZeros3 < 64) {
                    return (i4 * 64) + 128 + numberOfTrailingZeros3;
                }
            }
            return Integer.MAX_VALUE;
        }
        return numberOfTrailingZeros;
    }

    public final int nextClear(int i) {
        int numberOfTrailingZeros;
        if (i >= 64 || (numberOfTrailingZeros = Long.numberOfTrailingZeros(((~this.first) >>> i) << i)) >= 64) {
            if (i < 128) {
                int i2 = i - 64;
                int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(((~this.second) >>> i2) << i2);
                if (numberOfTrailingZeros2 < 64) {
                    return numberOfTrailingZeros2 + 64;
                }
            }
            int max = Math.max(i, 128);
            int i3 = (max / 64) - 2;
            long[] jArr = this.others;
            int length = jArr.length;
            for (int i4 = i3; i4 < length; i4++) {
                long j = ~jArr[i4];
                if (i4 == i3) {
                    int i5 = max % 64;
                    j = (j >>> i5) << i5;
                }
                int numberOfTrailingZeros3 = Long.numberOfTrailingZeros(j);
                if (numberOfTrailingZeros3 < 64) {
                    return (i4 * 64) + 128 + numberOfTrailingZeros3;
                }
            }
            return Integer.MAX_VALUE;
        }
        return numberOfTrailingZeros;
    }
}
