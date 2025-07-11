package kotlinx.datetime;

import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.LocalTimeFormat;
import kotlinx.datetime.format.LocalTimeFormatKt;
import kotlinx.datetime.serializers.LocalTimeSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: LocalTimeJvm.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002%&B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B-\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\fJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0011\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010¨\u0006'"}, d2 = {"Lkotlinx/datetime/LocalTime;", "", "Ljava/io/Serializable;", "value", "Ljava/time/LocalTime;", "<init>", "(Ljava/time/LocalTime;)V", "hour", "", "minute", "second", "nanosecond", "(IIII)V", "getValue$kotlinx_datetime", "()Ljava/time/LocalTime;", "getHour", "()I", "getMinute", "getSecond", "getNanosecond", "toSecondOfDay", "toMillisecondOfDay", "toNanosecondOfDay", "", "equals", "", "other", "", "hashCode", "toString", "", "compareTo", "readObject", "", "ois", "Ljava/io/ObjectInputStream;", "writeReplace", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = LocalTimeSerializer.class)
/* loaded from: classes5.dex */
public final class LocalTime implements Comparable<LocalTime>, java.io.Serializable {
    public static final Companion Companion = new Companion(null);
    private static final LocalTime MAX;
    private static final LocalTime MIN;
    private static final long serialVersionUID = 0;
    private final java.time.LocalTime value;

    public LocalTime(java.time.LocalTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final java.time.LocalTime getValue$kotlinx_datetime() {
        return this.value;
    }

    public /* synthetic */ LocalTime(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LocalTime(int i, int i2, int i3, int i4) {
        this(r1);
        try {
            java.time.LocalTime of = java.time.LocalTime.of(i, i2, i3, i4);
            Intrinsics.checkNotNull(of);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final int getHour() {
        return this.value.getHour();
    }

    public final int getMinute() {
        return this.value.getMinute();
    }

    public final int getSecond() {
        return this.value.getSecond();
    }

    public final int getNanosecond() {
        return this.value.getNano();
    }

    public final int toSecondOfDay() {
        return this.value.toSecondOfDay();
    }

    public final int toMillisecondOfDay() {
        return (int) (this.value.toNanoOfDay() / 1000000);
    }

    public final long toNanosecondOfDay() {
        return this.value.toNanoOfDay();
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof LocalTime) && Intrinsics.areEqual(this.value, ((LocalTime) obj).value);
        }
        return true;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        String localTime = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localTime, "toString(...)");
        return localTime;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalTime other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }

    /* compiled from: LocalTimeJvm.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050!R\u0014\u0010\u0014\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u000e\u0010\u001f\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlinx/datetime/LocalTime$Companion;", "", "<init>", "()V", "parse", "Lkotlinx/datetime/LocalTime;", "input", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "isoString", "", "fromSecondOfDay", "secondOfDay", "", "fromMillisecondOfDay", "millisecondOfDay", "fromNanosecondOfDay", "nanosecondOfDay", "", "MIN", "getMIN$kotlinx_datetime", "()Lkotlinx/datetime/LocalTime;", "MAX", "getMAX$kotlinx_datetime", "Format", "builder", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "", "Lkotlin/ExtensionFunctionType;", "serialVersionUID", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LocalTime> serializer() {
            return LocalTimeSerializer.INSTANCE;
        }

        public final LocalTime parse(CharSequence input, DateTimeFormat<LocalTime> format) {
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                try {
                    return new LocalTime(java.time.LocalTime.parse(input));
                } catch (DateTimeParseException e) {
                    throw new DateTimeFormatException(e);
                }
            }
            return format.parse(input);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ LocalTime parse(String isoString) {
            Intrinsics.checkNotNullParameter(isoString, "isoString");
            return parse$default(this, isoString, null, 2, null);
        }

        public final LocalTime fromSecondOfDay(int i) {
            try {
                return new LocalTime(java.time.LocalTime.ofSecondOfDay(i));
            } catch (DateTimeException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public final LocalTime fromMillisecondOfDay(int i) {
            try {
                return new LocalTime(java.time.LocalTime.ofNanoOfDay(i * 1000000));
            } catch (Throwable th) {
                throw new IllegalArgumentException(th);
            }
        }

        public final LocalTime fromNanosecondOfDay(long j) {
            try {
                return new LocalTime(java.time.LocalTime.ofNanoOfDay(j));
            } catch (DateTimeException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public final LocalTime getMIN$kotlinx_datetime() {
            return LocalTime.MIN;
        }

        public final LocalTime getMAX$kotlinx_datetime() {
            return LocalTime.MAX;
        }

        public final DateTimeFormat<LocalTime> Format(Function1<? super DateTimeFormatBuilder.WithTime, Unit> builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            return LocalTimeFormat.Companion.build(builder);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LocalTime parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = LocalTimeKt.getIsoTimeFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }
    }

    static {
        java.time.LocalTime MIN2 = java.time.LocalTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new LocalTime(MIN2);
        java.time.LocalTime MAX2 = java.time.LocalTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new LocalTime(MAX2);
    }

    /* compiled from: LocalTimeJvm.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/datetime/LocalTime$Formats;", "", "<init>", "()V", ExifInterface.TAG_RW2_ISO, "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();

        private Formats() {
        }

        public final DateTimeFormat<LocalTime> getISO() {
            return LocalTimeFormatKt.getISO_TIME();
        }
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("kotlinx.datetime.LocalTime must be deserialized via kotlinx.datetime.Ser");
    }

    private final Object writeReplace() {
        return new Ser(3, this);
    }
}
