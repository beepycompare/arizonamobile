package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
/* compiled from: TimeSource.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "WithComparableMarks", "Monotonic", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface TimeSource {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: TimeSource.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WithComparableMarks extends TimeSource {
        @Override // kotlin.time.TimeSource
        ComparableTimeMark markNow();
    }

    TimeMark markNow();

    /* compiled from: TimeSource.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = new Monotonic();

        private Monotonic() {
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
            return ValueTimeMark.m9937boximpl(m9936markNowz9LOYto());
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m9937boximpl(m9936markNowz9LOYto());
        }

        /* renamed from: markNow-z9LOYto  reason: not valid java name */
        public long m9936markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m9931markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        /* compiled from: TimeSource.kt */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0004\n\u0002\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006$"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "J", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "plus", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(JJ)J", "minus", "minus-LRDsOJo", "hasPassedNow", "", "hasPassedNow-impl", "(J)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "other", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "minus-6eNON_k", "compareTo", "", "compareTo-6eNON_k", "(JJ)I", "equals", "", "hashCode", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @JvmInline
        /* loaded from: classes5.dex */
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            /* renamed from: box-impl  reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m9937boximpl(long j) {
                return new ValueTimeMark(j);
            }

            /* renamed from: constructor-impl  reason: not valid java name */
            public static long m9940constructorimpl(long j) {
                return j;
            }

            /* renamed from: equals-impl  reason: not valid java name */
            public static boolean m9942equalsimpl(long j, Object obj) {
                return (obj instanceof ValueTimeMark) && j == ((ValueTimeMark) obj).m9954unboximpl();
            }

            /* renamed from: equals-impl0  reason: not valid java name */
            public static final boolean m9943equalsimpl0(long j, long j2) {
                return j == j2;
            }

            /* renamed from: hashCode-impl  reason: not valid java name */
            public static int m9946hashCodeimpl(long j) {
                return Long.hashCode(j);
            }

            /* renamed from: toString-impl  reason: not valid java name */
            public static String m9951toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + ')';
            }

            @Override // kotlin.time.ComparableTimeMark
            public boolean equals(Object obj) {
                return m9942equalsimpl(this.reading, obj);
            }

            @Override // kotlin.time.ComparableTimeMark
            public int hashCode() {
                return m9946hashCodeimpl(this.reading);
            }

            public String toString() {
                return m9951toStringimpl(this.reading);
            }

            /* renamed from: unbox-impl  reason: not valid java name */
            public final /* synthetic */ long m9954unboximpl() {
                return this.reading;
            }

            /* renamed from: compareTo-impl  reason: not valid java name */
            public static int m9939compareToimpl(long j, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m9937boximpl(j).compareTo(other);
            }

            @Override // java.lang.Comparable
            public int compareTo(ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo9814minusLRDsOJo(long j) {
                return m9937boximpl(m9952minusLRDsOJo(j));
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo9814minusLRDsOJo(long j) {
                return m9937boximpl(m9952minusLRDsOJo(j));
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo9816plusLRDsOJo(long j) {
                return m9937boximpl(m9953plusLRDsOJo(j));
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo9816plusLRDsOJo(long j) {
                return m9937boximpl(m9953plusLRDsOJo(j));
            }

            private /* synthetic */ ValueTimeMark(long j) {
                this.reading = j;
            }

            /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
            public static long m9941elapsedNowUwyO8pc(long j) {
                return MonotonicTimeSource.INSTANCE.m9930elapsedFrom6eNON_k(j);
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: elapsedNow-UwyO8pc */
            public long mo9813elapsedNowUwyO8pc() {
                return m9941elapsedNowUwyO8pc(this.reading);
            }

            /* renamed from: plus-LRDsOJo  reason: not valid java name */
            public static long m9950plusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m9928adjustReading6QKq23U(j, j2);
            }

            /* renamed from: plus-LRDsOJo  reason: not valid java name */
            public long m9953plusLRDsOJo(long j) {
                return m9950plusLRDsOJo(this.reading, j);
            }

            /* renamed from: minus-LRDsOJo  reason: not valid java name */
            public static long m9948minusLRDsOJo(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m9928adjustReading6QKq23U(j, Duration.m9867unaryMinusUwyO8pc(j2));
            }

            /* renamed from: minus-LRDsOJo  reason: not valid java name */
            public long m9952minusLRDsOJo(long j) {
                return m9948minusLRDsOJo(this.reading, j);
            }

            /* renamed from: hasPassedNow-impl  reason: not valid java name */
            public static boolean m9945hasPassedNowimpl(long j) {
                return !Duration.m9849isNegativeimpl(m9941elapsedNowUwyO8pc(j));
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m9945hasPassedNowimpl(this.reading);
            }

            /* renamed from: hasNotPassedNow-impl  reason: not valid java name */
            public static boolean m9944hasNotPassedNowimpl(long j) {
                return Duration.m9849isNegativeimpl(m9941elapsedNowUwyO8pc(j));
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m9944hasNotPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.ComparableTimeMark
            /* renamed from: minus-UwyO8pc */
            public long mo9815minusUwyO8pc(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m9949minusUwyO8pc(this.reading, other);
            }

            /* renamed from: minus-UwyO8pc  reason: not valid java name */
            public static long m9949minusUwyO8pc(long j, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (!(other instanceof ValueTimeMark)) {
                    throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m9951toStringimpl(j)) + " and " + other);
                }
                return m9947minus6eNON_k(j, ((ValueTimeMark) other).m9954unboximpl());
            }

            /* renamed from: minus-6eNON_k  reason: not valid java name */
            public static final long m9947minus6eNON_k(long j, long j2) {
                return MonotonicTimeSource.INSTANCE.m9929differenceBetweenfRLX17w(j, j2);
            }

            /* renamed from: compareTo-6eNON_k  reason: not valid java name */
            public static final int m9938compareTo6eNON_k(long j, long j2) {
                return Duration.m9822compareToLRDsOJo(m9947minus6eNON_k(j, j2), Duration.Companion.m9914getZEROUwyO8pc());
            }
        }
    }

    /* compiled from: TimeSource.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
