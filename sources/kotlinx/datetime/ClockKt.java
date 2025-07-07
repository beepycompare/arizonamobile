package kotlinx.datetime;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeMark;
import kotlin.time.TimeSource;
/* compiled from: Clock.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0001H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"asClock", "Lkotlinx/datetime/Clock;", "Lkotlin/time/TimeSource;", "origin", "Lkotlinx/datetime/Instant;", "asTimeSource", "Lkotlin/time/TimeSource$WithComparableMarks;", "todayAt", "Lkotlinx/datetime/LocalDate;", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "Lkotlinx/datetime/TimeZone;", "todayIn", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClockKt {
    public static final LocalDate todayIn(Clock clock, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(clock, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return TimeZoneKt.toLocalDateTime(clock.now(), timeZone).getDate();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This function is deprecated because Clock.System.asTimeSource can be confused with TimeSource.Monotonic, which are very different. See https://github.com/Kotlin/kotlinx-datetime/issues/372")
    public static final TimeSource.WithComparableMarks asTimeSource(final Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "<this>");
        return new TimeSource.WithComparableMarks() { // from class: kotlinx.datetime.ClockKt$asTimeSource$1
            @Override // kotlin.time.TimeSource
            public ComparableTimeMark markNow() {
                return new InstantTimeMark(Clock.this.now(), Clock.this);
            }
        };
    }

    public static final Clock asClock(final TimeSource timeSource, final Instant origin) {
        Intrinsics.checkNotNullParameter(timeSource, "<this>");
        Intrinsics.checkNotNullParameter(origin, "origin");
        return new Clock(timeSource, origin) { // from class: kotlinx.datetime.ClockKt$asClock$1
            final /* synthetic */ Instant $origin;
            private final TimeMark startMark;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$origin = origin;
                this.startMark = timeSource.markNow();
            }

            @Override // kotlinx.datetime.Clock
            public Instant now() {
                return this.$origin.m10052plusLRDsOJo(this.startMark.mo9780elapsedNowUwyO8pc());
            }
        };
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use Clock.todayIn instead", replaceWith = @ReplaceWith(expression = "this.todayIn(timeZone)", imports = {}))
    public static final LocalDate todayAt(Clock clock, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(clock, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return todayIn(clock, timeZone);
    }
}
