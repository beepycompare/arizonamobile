package kotlinx.datetime;

import androidx.collection.SieveCacheKt;
import androidx.media3.common.C;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;
/* compiled from: DateTimePeriod.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n\u001a$\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a(\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u0015\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0087\u0002\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\u0002\u001a\f\u0010\u0011\u001a\u00020\u000f*\u00020\u0012H\u0007\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\u0012H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"DateTimePeriod", "Lkotlinx/datetime/DateTimePeriod;", "years", "", "months", "days", "hours", "minutes", "seconds", "nanoseconds", "", "buildDateTimePeriod", "totalMonths", "totalNanoseconds", "plus", "Lkotlinx/datetime/DatePeriod;", "other", "toDatePeriod", "", "toDateTimePeriod", "Lkotlin/time/Duration;", "toDateTimePeriod-LRDsOJo", "(J)Lkotlinx/datetime/DateTimePeriod;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateTimePeriodKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "DateTimePeriod.parse(this)", imports = {}))
    public static final DateTimePeriod toDateTimePeriod(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return DateTimePeriod.Companion.parse(str);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "DatePeriod.parse(this)", imports = {}))
    public static final DatePeriod toDatePeriod(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return DatePeriod.Companion.parse(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int totalMonths(int i, int i2) {
        long j = (i * 12) + i2;
        if (SieveCacheKt.NodeMetaAndPreviousMask > j || j > SieveCacheKt.NodeLinkMask) {
            throw new IllegalArgumentException("The total number of months in " + i + " years and " + i2 + " months overflows an Int");
        }
        return (int) j;
    }

    private static final long totalNanoseconds(int i, int i2, int i3, long j) {
        long j2 = 60;
        long j3 = ((i * j2) + i2) * j2;
        long j4 = 1000000000;
        try {
            return MathKt.multiplyAndAdd(j3 + (j / j4) + i3, C.NANOS_PER_SECOND, j % j4);
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("The total number of nanoseconds in " + i + " hours, " + i2 + " minutes, " + i3 + " seconds, and " + j + " nanoseconds overflows a Long");
        }
    }

    public static /* synthetic */ DateTimePeriod buildDateTimePeriod$default(int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return buildDateTimePeriod(i, i2, j);
    }

    public static final DateTimePeriod buildDateTimePeriod(int i, int i2, long j) {
        if (j != 0) {
            return new DateTimePeriodImpl(i, i2, j);
        }
        return new DatePeriod(i, i2);
    }

    public static /* synthetic */ DateTimePeriod DateTimePeriod$default(int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = 0;
        }
        if ((i7 & 2) != 0) {
            i2 = 0;
        }
        if ((i7 & 4) != 0) {
            i3 = 0;
        }
        if ((i7 & 8) != 0) {
            i4 = 0;
        }
        if ((i7 & 16) != 0) {
            i5 = 0;
        }
        if ((i7 & 32) != 0) {
            i6 = 0;
        }
        if ((i7 & 64) != 0) {
            j = 0;
        }
        return DateTimePeriod(i, i2, i3, i4, i5, i6, j);
    }

    public static final DateTimePeriod DateTimePeriod(int i, int i2, int i3, int i4, int i5, int i6, long j) {
        return buildDateTimePeriod(totalMonths(i, i2), i3, totalNanoseconds(i4, i5, i6, j));
    }

    /* renamed from: toDateTimePeriod-LRDsOJo  reason: not valid java name */
    public static final DateTimePeriod m10048toDateTimePeriodLRDsOJo(long j) {
        return buildDateTimePeriod$default(0, 0, Duration.m9803getInWholeNanosecondsimpl(j), 3, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Adding periods is not a well-defined operation. See https://github.com/Kotlin/kotlinx-datetime/issues/381")
    public static final DateTimePeriod plus(DateTimePeriod dateTimePeriod, DateTimePeriod other) {
        Intrinsics.checkNotNullParameter(dateTimePeriod, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return buildDateTimePeriod(MathJvmKt.safeAdd(dateTimePeriod.getTotalMonths$kotlinx_datetime(), other.getTotalMonths$kotlinx_datetime()), MathJvmKt.safeAdd(dateTimePeriod.getDays(), other.getDays()), MathJvmKt.safeAdd(dateTimePeriod.getTotalNanoseconds$kotlinx_datetime(), other.getTotalNanoseconds$kotlinx_datetime()));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Adding periods is not a well-defined operation. See https://github.com/Kotlin/kotlinx-datetime/issues/381")
    public static final DatePeriod plus(DatePeriod datePeriod, DatePeriod other) {
        Intrinsics.checkNotNullParameter(datePeriod, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new DatePeriod(MathJvmKt.safeAdd(datePeriod.getTotalMonths$kotlinx_datetime(), other.getTotalMonths$kotlinx_datetime()), MathJvmKt.safeAdd(datePeriod.getDays(), other.getDays()));
    }
}
