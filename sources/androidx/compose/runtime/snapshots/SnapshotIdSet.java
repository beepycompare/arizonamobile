package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: SnapshotIdSet.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 &2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001&B3\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000J\u0012\u0010\u000e\u001a\u00020\u00002\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003J>\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002+\u0010\u0012\u001a'\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00000\u0013H\u0082\bJ!\u0010\u0017\u001a\u00020\u00182\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bJ\u0012\u0010\u001b\u001a\u00020\u001c2\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003J\u0013\u0010\u001d\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001eH\u0096\u0002J\u0016\u0010\u001f\u001a\u00060\u0002j\u0002`\u00032\n\u0010 \u001a\u00060\u0002j\u0002`\u0003J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0000J\u0012\u0010#\u001a\u00020\u00002\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003J\b\u0010$\u001a\u00020%H\u0016R\u0016\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "upperSet", "lowerSet", "lowerBound", "belowBound", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "(JJJ[J)V", "and", "ids", "andNot", "clear", "id", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "bits", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable<Long>, KMappedMarker {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, null);
    private final long[] belowBound;
    private final long lowerBound;
    private final long lowerSet;
    private final long upperSet;

    private SnapshotIdSet(long j, long j2, long j3, long[] jArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = j3;
        this.belowBound = jArr;
    }

    public final boolean get(long j) {
        long[] jArr;
        long j2 = j - this.lowerBound;
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        return (i < 0 || j2 >= 64) ? (j2 < 64 || j2 >= 128) ? i <= 0 && (jArr = this.belowBound) != null && SnapshotId_jvmKt.binarySearch(jArr, j) >= 0 : ((1 << (((int) j2) + (-64))) & this.upperSet) != 0 : ((1 << ((int) j2)) & this.lowerSet) != 0;
    }

    public final SnapshotIdSet set(long j) {
        long j2;
        long j3;
        long[] jArr;
        long j4 = this.lowerBound;
        long j5 = j - j4;
        long j6 = 0;
        if (j5 >= 0 && j5 < 64) {
            long j7 = 1 << ((int) j5);
            long j8 = this.lowerSet;
            if ((j8 & j7) == 0) {
                return new SnapshotIdSet(this.upperSet, j8 | j7, j4, this.belowBound);
            }
        } else if (j5 >= 64 && j5 < 128) {
            long j9 = 1 << (((int) j5) - 64);
            long j10 = this.upperSet;
            if ((j10 & j9) == 0) {
                return new SnapshotIdSet(j10 | j9, this.lowerSet, j4, this.belowBound);
            }
        } else if (j5 >= 128) {
            if (!get(j)) {
                long j11 = this.upperSet;
                long j12 = this.lowerSet;
                long j13 = this.lowerBound;
                long j14 = 64;
                long j15 = ((j + 1) / j14) * j14;
                if (j15 < 0) {
                    j15 = 9223372036854775680L;
                }
                SnapshotIdArrayBuilder snapshotIdArrayBuilder = null;
                long j16 = j11;
                while (true) {
                    if (j13 >= j15) {
                        j2 = j12;
                        j3 = j13;
                        break;
                    }
                    if (j12 != j6) {
                        if (snapshotIdArrayBuilder == null) {
                            snapshotIdArrayBuilder = new SnapshotIdArrayBuilder(this.belowBound);
                        }
                        int i = 0;
                        while (i < 64) {
                            long j17 = j6;
                            if ((j12 & (1 << i)) != j6) {
                                snapshotIdArrayBuilder.add(j13 + i);
                            }
                            i++;
                            j6 = j17;
                        }
                    }
                    j2 = j6;
                    if (j16 == j2) {
                        j3 = j15;
                        break;
                    }
                    j13 += j14;
                    j12 = j16;
                    j6 = j2;
                    j16 = j6;
                }
                if (snapshotIdArrayBuilder == null || (jArr = snapshotIdArrayBuilder.toArray()) == null) {
                    jArr = this.belowBound;
                }
                return new SnapshotIdSet(j16, j2, j3, jArr).set(j);
            }
        } else {
            long[] jArr2 = this.belowBound;
            if (jArr2 == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, j4, new long[]{j});
            }
            int binarySearch = SnapshotId_jvmKt.binarySearch(jArr2, j);
            if (binarySearch < 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdInsertedAt(jArr2, -(binarySearch + 1), j));
            }
        }
        return this;
    }

    public final SnapshotIdSet clear(long j) {
        long[] jArr;
        int binarySearch;
        long j2 = this.lowerBound;
        long j3 = j - j2;
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        if (i >= 0 && j3 < 64) {
            long j4 = 1 << ((int) j3);
            long j5 = this.lowerSet;
            if ((j5 & j4) != 0) {
                return new SnapshotIdSet(this.upperSet, j5 & (~j4), j2, this.belowBound);
            }
        } else if (j3 >= 64 && j3 < 128) {
            long j6 = 1 << (((int) j3) - 64);
            long j7 = this.upperSet;
            if ((j7 & j6) != 0) {
                return new SnapshotIdSet(j7 & (~j6), this.lowerSet, j2, this.belowBound);
            }
        } else if (i < 0 && (jArr = this.belowBound) != null && (binarySearch = SnapshotId_jvmKt.binarySearch(jArr, j)) >= 0) {
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdRemovedAt(jArr, binarySearch));
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        SnapshotIdSet snapshotIdSet3 = EMPTY;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet3;
        }
        long j = snapshotIdSet.lowerBound;
        long j2 = this.lowerBound;
        if (j == j2) {
            long[] jArr = snapshotIdSet.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                return new SnapshotIdSet((~snapshotIdSet.upperSet) & this.upperSet, (~snapshotIdSet.lowerSet) & this.lowerSet, j2, jArr2);
            }
        }
        long[] jArr3 = snapshotIdSet.belowBound;
        if (jArr3 != null) {
            snapshotIdSet2 = this;
            for (long j3 : jArr3) {
                snapshotIdSet2 = snapshotIdSet2.clear(j3);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((snapshotIdSet.lowerSet & (1 << i)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.clear(snapshotIdSet.lowerBound + i);
                }
            }
        }
        if (snapshotIdSet.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((snapshotIdSet.upperSet & (1 << i2)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.clear(snapshotIdSet.lowerBound + i2 + 64);
                }
            }
        }
        return snapshotIdSet2;
    }

    public final SnapshotIdSet and(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (Intrinsics.areEqual(snapshotIdSet, snapshotIdSet2) || Intrinsics.areEqual(this, snapshotIdSet2)) {
            return snapshotIdSet2;
        }
        long j = snapshotIdSet.lowerBound;
        long j2 = this.lowerBound;
        if (j == j2) {
            long[] jArr = snapshotIdSet.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                long j3 = this.upperSet;
                long j4 = snapshotIdSet.upperSet;
                long j5 = this.lowerSet;
                long j6 = snapshotIdSet.lowerSet;
                return ((j3 & j4) == 0 && (j5 & j6) == 0 && jArr2 == null) ? snapshotIdSet2 : new SnapshotIdSet(j3 & j4, j5 & j6, j2, jArr2);
            }
        }
        SnapshotIdSet snapshotIdSet3 = snapshotIdSet2;
        int i = 0;
        if (this.belowBound == null) {
            long[] jArr3 = this.belowBound;
            if (jArr3 != null) {
                for (long j7 : jArr3) {
                    if (snapshotIdSet.get(j7)) {
                        snapshotIdSet3 = snapshotIdSet3.set(j7);
                    }
                }
            }
            SnapshotIdSet snapshotIdSet4 = snapshotIdSet3;
            if (this.lowerSet != 0) {
                for (int i2 = 0; i2 < 64; i2++) {
                    if ((this.lowerSet & (1 << i2)) != 0) {
                        long j8 = this.lowerBound + i2;
                        if (snapshotIdSet.get(j8)) {
                            snapshotIdSet4 = snapshotIdSet4.set(j8);
                        }
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i < 64) {
                    if ((this.upperSet & (1 << i)) != 0) {
                        long j9 = this.lowerBound + i + 64;
                        if (snapshotIdSet.get(j9)) {
                            snapshotIdSet4 = snapshotIdSet4.set(j9);
                        }
                    }
                    i++;
                }
            }
            return snapshotIdSet4;
        }
        long[] jArr4 = snapshotIdSet.belowBound;
        if (jArr4 != null) {
            for (long j10 : jArr4) {
                if (get(j10)) {
                    snapshotIdSet3 = snapshotIdSet3.set(j10);
                }
            }
        }
        SnapshotIdSet snapshotIdSet5 = snapshotIdSet3;
        if (snapshotIdSet.lowerSet != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if ((snapshotIdSet.lowerSet & (1 << i3)) != 0) {
                    long j11 = snapshotIdSet.lowerBound + i3;
                    if (get(j11)) {
                        snapshotIdSet5 = snapshotIdSet5.set(j11);
                    }
                }
            }
        }
        if (snapshotIdSet.upperSet != 0) {
            while (i < 64) {
                if ((snapshotIdSet.upperSet & (1 << i)) != 0) {
                    long j12 = snapshotIdSet.lowerBound + i + 64;
                    if (get(j12)) {
                        snapshotIdSet5 = snapshotIdSet5.set(j12);
                    }
                }
                i++;
            }
        }
        return snapshotIdSet5;
    }

    public final SnapshotIdSet or(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        SnapshotIdSet snapshotIdSet3 = EMPTY;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet;
        }
        long j = snapshotIdSet.lowerBound;
        long j2 = this.lowerBound;
        if (j == j2) {
            long[] jArr = snapshotIdSet.belowBound;
            long[] jArr2 = this.belowBound;
            if (jArr == jArr2) {
                return new SnapshotIdSet(snapshotIdSet.upperSet | this.upperSet, snapshotIdSet.lowerSet | this.lowerSet, j2, jArr2);
            }
        }
        int i = 0;
        if (this.belowBound == null) {
            long[] jArr3 = this.belowBound;
            if (jArr3 != null) {
                for (long j3 : jArr3) {
                    snapshotIdSet = snapshotIdSet.set(j3);
                }
            }
            if (this.lowerSet != 0) {
                for (int i2 = 0; i2 < 64; i2++) {
                    if ((this.lowerSet & (1 << i2)) != 0) {
                        snapshotIdSet = snapshotIdSet.set(this.lowerBound + i2);
                    }
                }
            }
            if (this.upperSet != 0) {
                while (i < 64) {
                    if ((this.upperSet & (1 << i)) != 0) {
                        snapshotIdSet = snapshotIdSet.set(this.lowerBound + i + 64);
                    }
                    i++;
                }
            }
            return snapshotIdSet;
        }
        long[] jArr4 = snapshotIdSet.belowBound;
        if (jArr4 != null) {
            snapshotIdSet2 = this;
            for (long j4 : jArr4) {
                snapshotIdSet2 = snapshotIdSet2.set(j4);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.lowerSet != 0) {
            for (int i3 = 0; i3 < 64; i3++) {
                if ((snapshotIdSet.lowerSet & (1 << i3)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.set(snapshotIdSet.lowerBound + i3);
                }
            }
        }
        if (snapshotIdSet.upperSet != 0) {
            while (i < 64) {
                if ((snapshotIdSet.upperSet & (1 << i)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.set(snapshotIdSet.lowerBound + i + 64);
                }
                i++;
            }
        }
        return snapshotIdSet2;
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, null)).iterator();
    }

    public final void fastForEach(Function1<? super Long, Unit> function1) {
        long[] jArr = this.belowBound;
        if (jArr != null) {
            for (long j : jArr) {
                function1.invoke(Long.valueOf(j));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    function1.invoke(Long.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.upperSet & (1 << i2)) != 0) {
                    function1.invoke(Long.valueOf(this.lowerBound + i2 + 64));
                }
            }
        }
    }

    public final long lowest(long j) {
        long[] jArr = this.belowBound;
        if (jArr == null) {
            long j2 = this.lowerSet;
            if (j2 != 0) {
                return this.lowerBound + Long.numberOfTrailingZeros(j2);
            }
            long j3 = this.upperSet;
            return j3 != 0 ? this.lowerBound + 64 + Long.numberOfTrailingZeros(j3) : j;
        }
        return jArr[0];
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(super.toString()).append(" [");
        SnapshotIdSet<Long> snapshotIdSet = this;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(snapshotIdSet, 10));
        for (Long l : snapshotIdSet) {
            arrayList.add(String.valueOf(l.longValue()));
        }
        return append.append(ListUtilsKt.fastJoinToString$default(arrayList, null, null, null, 0, null, null, 63, null)).append(AbstractJsonLexerKt.END_LIST).toString();
    }

    /* compiled from: SnapshotIdSet.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }

    private final SnapshotIdSet fastFold(SnapshotIdSet snapshotIdSet, Function2<? super SnapshotIdSet, ? super Long, SnapshotIdSet> function2) {
        long[] jArr = this.belowBound;
        if (jArr != null) {
            for (long j : jArr) {
                snapshotIdSet = function2.invoke(snapshotIdSet, Long.valueOf(j));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    snapshotIdSet = function2.invoke(snapshotIdSet, Long.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.upperSet & (1 << i2)) != 0) {
                    snapshotIdSet = function2.invoke(snapshotIdSet, Long.valueOf(this.lowerBound + i2 + 64));
                }
            }
        }
        return snapshotIdSet;
    }
}
