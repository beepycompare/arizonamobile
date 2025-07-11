package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.DatePeriodSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: DateTimePeriod.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B'\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\f¨\u0006\u001a"}, d2 = {"Lkotlinx/datetime/DatePeriod;", "Lkotlinx/datetime/DateTimePeriod;", "totalMonths", "", "days", "", "<init>", "(JI)V", "years", "months", "(III)V", "getTotalMonths$kotlinx_datetime", "()J", "getDays", "()I", "hours", "getHours", "minutes", "getMinutes", "seconds", "getSeconds", "nanoseconds", "getNanoseconds", "totalNanoseconds", "getTotalNanoseconds$kotlinx_datetime", "Companion", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = DatePeriodSerializer.class)
/* loaded from: classes5.dex */
public final class DatePeriod extends DateTimePeriod {
    public static final Companion Companion = new Companion(null);
    private final int days;
    private final long totalMonths;

    @Override // kotlinx.datetime.DateTimePeriod
    public int getHours() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getMinutes() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getNanoseconds() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getSeconds() {
        return 0;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public long getTotalNanoseconds$kotlinx_datetime() {
        return 0L;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public long getTotalMonths$kotlinx_datetime() {
        return this.totalMonths;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public int getDays() {
        return this.days;
    }

    public DatePeriod(long j, int i) {
        super(null);
        this.totalMonths = j;
        this.days = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DatePeriod(int i, int i2, int i3) {
        this(r1, i3);
        long j;
        j = DateTimePeriodKt.totalMonths(i, i2);
    }

    public /* synthetic */ DatePeriod(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    /* compiled from: DateTimePeriod.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Lkotlinx/datetime/DatePeriod$Companion;", "", "<init>", "()V", "parse", "Lkotlinx/datetime/DatePeriod;", "text", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DatePeriod> serializer() {
            return DatePeriodSerializer.INSTANCE;
        }

        public final DatePeriod parse(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            DateTimePeriod parse = DateTimePeriod.Companion.parse(text);
            if (parse instanceof DatePeriod) {
                return (DatePeriod) parse;
            }
            throw new DateTimeFormatException("Period " + parse + " (parsed from string " + text + ") is not date-based");
        }
    }
}
