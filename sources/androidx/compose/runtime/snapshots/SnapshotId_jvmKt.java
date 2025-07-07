package androidx.compose.runtime.snapshots;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SnapshotId.jvm.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\u0019\u0010\f\u001a\u00060\bj\u0002`\t2\n\u0010\r\u001a\u00060\u0001j\u0002`\u0002H\u0080\b\u001a\u0014\u0010\u000e\u001a\u00060\bj\u0002`\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0005*\u00060\bj\u0002`\t2\n\u0010\r\u001a\u00060\u0001j\u0002`\u0002H\u0000\u001a\u001d\u0010\u0011\u001a\u00020\u0005*\u00060\u0001j\u0002`\u00022\n\u0010\u0012\u001a\u00060\u0001j\u0002`\u0002H\u0080\n\u001a\u0019\u0010\u0011\u001a\u00020\u0005*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0080\n\u001a\u001d\u0010\u0013\u001a\u00020\u0014*\u00060\bj\u0002`\t2\n\u0010\u0012\u001a\u00060\bj\u0002`\tH\u0080\b\u001a\u001d\u0010\u0015\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0080\n\u001a\u0015\u0010\u0016\u001a\u00060\u0001j\u0002`\u0002*\u00060\bj\u0002`\tH\u0080\b\u001a)\u0010\u0017\u001a\u00020\u0014*\u00060\bj\u0002`\t2\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00140\u0019H\u0080\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\bj\u0002`\t2\u0006\u0010\u001b\u001a\u00020\u0005H\u0080\n\u001a!\u0010\u001c\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\n\u0010\u0012\u001a\u00060\u0001j\u0002`\u0002H\u0080\n\u001a\u001d\u0010\u001c\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0080\n\u001a\u001d\u0010\u001d\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0080\n\u001a%\u0010\u001e\u001a\u00020\u0014*\u00060\bj\u0002`\t2\u0006\u0010\u001b\u001a\u00020\u00052\n\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002H\u0080\n\u001a\u001d\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0012\u001a\u00020\u0005H\u0080\n\u001a\u0011\u0010!\u001a\u00020\u0005*\u00060\u0001j\u0002`\u0002H\u0086\b\u001a\u0011\u0010\"\u001a\u00020\u0001*\u00060\u0001j\u0002`\u0002H\u0086\b\u001a\u0010\u0010#\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0005H\u0000\u001a(\u0010$\u001a\u00060\bj\u0002`\t*\u00060\bj\u0002`\t2\u0006\u0010\u001b\u001a\u00020\u00052\n\u0010\r\u001a\u00060\u0001j\u0002`\u0002H\u0000\u001a \u0010%\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t*\u00060\bj\u0002`\t2\u0006\u0010\u001b\u001a\u00020\u0005H\u0000\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002X\u0080T¢\u0006\u0002\n\u0000\"\u001d\u0010\u0007\u001a\u00020\u0005*\u00060\bj\u0002`\t8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b*\n\u0010&\"\u00020\u00012\u00020\u0001*\n\u0010'\"\u00020\b2\u00020\b¨\u0006("}, d2 = {"SnapshotIdInvalidValue", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "SnapshotIdMax", "SnapshotIdSize", "", "SnapshotIdZero", "size", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "getSize", "([J)I", "snapshotIdArrayOf", "id", "snapshotIdArrayWithCapacity", "capacity", "binarySearch", "compareTo", "other", "copyInto", "", TtmlNode.TAG_DIV, "first", "forEach", "block", "Lkotlin/Function1;", "get", FirebaseAnalytics.Param.INDEX, "minus", "plus", "set", "value", "times", "toInt", "toLong", "toSnapshotId", "withIdInsertedAt", "withIdRemovedAt", "SnapshotId", "SnapshotIdArray", "runtime_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotId_jvmKt {
    public static final long SnapshotIdInvalidValue = -1;
    public static final long SnapshotIdMax = Long.MAX_VALUE;
    public static final int SnapshotIdSize = 64;
    public static final long SnapshotIdZero = 0;

    public static final long minus(long j, int i) {
        return j - i;
    }

    public static final long minus(long j, long j2) {
        return j - j2;
    }

    public static final long plus(long j, int i) {
        return j + i;
    }

    public static final long times(long j, int i) {
        return j * i;
    }

    public static final int toInt(long j) {
        return (int) j;
    }

    public static final long toLong(long j) {
        return j;
    }

    public static final long toSnapshotId(int i) {
        return i;
    }

    public static final int compareTo(long j, long j2) {
        return Intrinsics.compare(j, j2);
    }

    public static final int compareTo(long j, int i) {
        return Intrinsics.compare(j, i);
    }

    public static final long div(long j, int i) {
        return j / i;
    }

    public static final long[] snapshotIdArrayWithCapacity(int i) {
        return new long[i];
    }

    public static final long get(long[] jArr, int i) {
        return jArr[i];
    }

    public static final void set(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    public static final int getSize(long[] jArr) {
        return jArr.length;
    }

    public static final void copyInto(long[] jArr, long[] jArr2) {
        ArraysKt.copyInto$default(jArr, jArr2, 0, 0, 0, 12, (Object) null);
    }

    public static final long first(long[] jArr) {
        return jArr[0];
    }

    public static final int binarySearch(long[] jArr, long j) {
        int length = jArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int i3 = (j > jArr[i2] ? 1 : (j == jArr[i2] ? 0 : -1));
            if (i3 > 0) {
                i = i2 + 1;
            } else if (i3 >= 0) {
                return i2;
            } else {
                length = i2 - 1;
            }
        }
        return -(i + 1);
    }

    public static final void forEach(long[] jArr, Function1<? super Long, Unit> function1) {
        for (long j : jArr) {
            function1.invoke(Long.valueOf(j));
        }
    }

    public static final long[] withIdInsertedAt(long[] jArr, int i, long j) {
        int length = jArr.length;
        long[] jArr2 = new long[length + 1];
        ArraysKt.copyInto(jArr, jArr2, 0, 0, i);
        ArraysKt.copyInto(jArr, jArr2, i + 1, i, length);
        jArr2[i] = j;
        return jArr2;
    }

    public static final long[] withIdRemovedAt(long[] jArr, int i) {
        int length = jArr.length;
        int i2 = length - 1;
        if (i2 == 0) {
            return null;
        }
        long[] jArr2 = new long[i2];
        if (i > 0) {
            ArraysKt.copyInto(jArr, jArr2, 0, 0, i);
        }
        if (i < i2) {
            ArraysKt.copyInto(jArr, jArr2, i, i + 1, length);
        }
        return jArr2;
    }

    public static final long[] snapshotIdArrayOf(long j) {
        return new long[]{j};
    }
}
