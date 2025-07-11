package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DateCalculationsKt;
import kotlinx.metadata.internal.metadata.builtins.BuiltInsProtoBuf;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Instant.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJW\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u000326\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002H\u00150\u0018H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"Lkotlin/time/UnboundLocalDateTime;", "", "year", "", "month", "day", "hour", "minute", "second", "nanosecond", "<init>", "(IIIIIII)V", "getYear", "()I", "getMonth", "getDay", "getHour", "getMinute", "getSecond", "getNanosecond", "toInstant", ExifInterface.GPS_DIRECTION_TRUE, "offsetSeconds", "buildInstant", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "epochSeconds", "nanosecondOfSecond", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnboundLocalDateTime {
    public static final Companion Companion = new Companion(null);
    private final int day;
    private final int hour;
    private final int minute;
    private final int month;
    private final int nanosecond;
    private final int second;
    private final int year;

    public UnboundLocalDateTime(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.hour = i4;
        this.minute = i5;
        this.second = i6;
        this.nanosecond = i7;
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int getNanosecond() {
        return this.nanosecond;
    }

    public final <T> T toInstant(int i, Function2<? super Long, ? super Integer, ? extends T> buildInstant) {
        long j;
        Intrinsics.checkNotNullParameter(buildInstant, "buildInstant");
        long year = getYear();
        long j2 = 365 * year;
        if (year >= 0) {
            j = j2 + (((3 + year) / 4) - ((99 + year) / 100)) + ((year + 399) / 400);
        } else {
            j = j2 - (((year / (-4)) - (year / (-100))) + (year / (-400)));
        }
        long month = j + (((getMonth() * 367) - 362) / 12) + (getDay() - 1);
        if (getMonth() > 2) {
            month = !InstantKt.isLeapYear(getYear()) ? month - 2 : (-1) + month;
        }
        return buildInstant.invoke(Long.valueOf((((month - 719528) * 86400) + (((getHour() * DateCalculationsKt.SECONDS_PER_HOUR) + (getMinute() * 60)) + getSecond())) - i), Integer.valueOf(getNanosecond()));
    }

    public String toString() {
        return "UnboundLocalDateTime(" + this.year + '-' + this.month + '-' + this.day + ' ' + this.hour + AbstractJsonLexerKt.COLON + this.minute + AbstractJsonLexerKt.COLON + this.second + '.' + this.nanosecond + ')';
    }

    /* compiled from: Instant.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkotlin/time/UnboundLocalDateTime$Companion;", "", "<init>", "()V", "fromInstant", "Lkotlin/time/UnboundLocalDateTime;", "instant", "Lkotlin/time/Instant;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UnboundLocalDateTime fromInstant(Instant instant) {
            long j;
            long j2;
            Intrinsics.checkNotNullParameter(instant, "instant");
            long epochSeconds = instant.getEpochSeconds();
            long j3 = epochSeconds / 86400;
            if ((epochSeconds ^ 86400) < 0 && j3 * 86400 != epochSeconds) {
                j3--;
            }
            long j4 = epochSeconds % 86400;
            int i = (int) (j4 + (86400 & (((j4 ^ 86400) & ((-j4) | j4)) >> 63)));
            long j5 = (j3 + 719528) - 60;
            if (j5 < 0) {
                j = -1;
                long j6 = 146097;
                long j7 = ((j5 + 1) / j6) - 1;
                j2 = 400 * j7;
                j5 += (-j7) * j6;
            } else {
                j = -1;
                j2 = 0;
            }
            long j8 = 400;
            long j9 = ((j8 * j5) + 591) / 146097;
            long j10 = 365;
            long j11 = 4;
            long j12 = 100;
            long j13 = j5 - ((((j10 * j9) + (j9 / j11)) - (j9 / j12)) + (j9 / j8));
            if (j13 < 0) {
                j9 += j;
                j13 = j5 - ((((j10 * j9) + (j9 / j11)) - (j9 / j12)) + (j9 / j8));
            }
            long j14 = j9 + j2;
            int i2 = (int) j13;
            int i3 = ((i2 * 5) + 2) / BuiltInsProtoBuf.PROPERTY_SETTER_ANNOTATION_FIELD_NUMBER;
            int i4 = ((i3 + 2) % 12) + 1;
            int i5 = (i2 - (((i3 * 306) + 5) / 10)) + 1;
            int i6 = i / DateCalculationsKt.SECONDS_PER_HOUR;
            int i7 = i - (i6 * DateCalculationsKt.SECONDS_PER_HOUR);
            int i8 = i7 / 60;
            return new UnboundLocalDateTime((int) (j14 + (i3 / 10)), i4, i5, i6, i8, i7 - (i8 * 60), instant.getNanosecondsOfSecond());
        }
    }
}
