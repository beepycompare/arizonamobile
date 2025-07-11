package kotlinx.datetime;

import androidx.exifinterface.media.ExifInterface;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.UtcOffsetFormat;
import kotlinx.datetime.format.UtcOffsetFormatKt;
import kotlinx.datetime.serializers.UtcOffsetSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: UtcOffsetJvm.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\tH\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lkotlinx/datetime/UtcOffset;", "Ljava/io/Serializable;", "zoneOffset", "Ljava/time/ZoneOffset;", "<init>", "(Ljava/time/ZoneOffset;)V", "getZoneOffset$kotlinx_datetime", "()Ljava/time/ZoneOffset;", "totalSeconds", "", "getTotalSeconds", "()I", "hashCode", "equals", "", "other", "", "toString", "", "readObject", "", "ois", "Ljava/io/ObjectInputStream;", "writeReplace", "Companion", "Formats", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = UtcOffsetSerializer.class)
/* loaded from: classes5.dex */
public final class UtcOffset implements java.io.Serializable {
    public static final Companion Companion = new Companion(null);
    private static final UtcOffset ZERO;
    private static final long serialVersionUID = 0;
    private final ZoneOffset zoneOffset;

    public UtcOffset(ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(zoneOffset, "zoneOffset");
        this.zoneOffset = zoneOffset;
    }

    public final ZoneOffset getZoneOffset$kotlinx_datetime() {
        return this.zoneOffset;
    }

    public final int getTotalSeconds() {
        return this.zoneOffset.getTotalSeconds();
    }

    public int hashCode() {
        return this.zoneOffset.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof UtcOffset) && Intrinsics.areEqual(this.zoneOffset, ((UtcOffset) obj).zoneOffset);
    }

    public String toString() {
        String zoneOffset = this.zoneOffset.toString();
        Intrinsics.checkNotNullExpressionValue(zoneOffset, "toString(...)");
        return zoneOffset;
    }

    /* compiled from: UtcOffsetJvm.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0007J%\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkotlinx/datetime/UtcOffset$Companion;", "", "<init>", "()V", "ZERO", "Lkotlinx/datetime/UtcOffset;", "getZERO", "()Lkotlinx/datetime/UtcOffset;", "parse", "input", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "offsetString", "", "Format", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "", "Lkotlin/ExtensionFunctionType;", "serialVersionUID", "", "serializer", "Lkotlinx/serialization/KSerializer;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UtcOffset> serializer() {
            return UtcOffsetSerializer.INSTANCE;
        }

        public final UtcOffset getZERO() {
            return UtcOffset.ZERO;
        }

        public final UtcOffset parse(CharSequence input, DateTimeFormat<UtcOffset> format) {
            DateTimeFormatter fourDigitsFormat;
            UtcOffset parseWithFormat;
            DateTimeFormatter isoBasicFormat;
            UtcOffset parseWithFormat2;
            DateTimeFormatter isoFormat;
            UtcOffset parseWithFormat3;
            Intrinsics.checkNotNullParameter(input, "input");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format == Formats.INSTANCE.getISO()) {
                isoFormat = UtcOffsetJvmKt.getIsoFormat();
                Intrinsics.checkNotNullExpressionValue(isoFormat, "access$getIsoFormat(...)");
                parseWithFormat3 = UtcOffsetJvmKt.parseWithFormat(input, isoFormat);
                return parseWithFormat3;
            } else if (format == Formats.INSTANCE.getISO_BASIC()) {
                isoBasicFormat = UtcOffsetJvmKt.getIsoBasicFormat();
                Intrinsics.checkNotNullExpressionValue(isoBasicFormat, "access$getIsoBasicFormat(...)");
                parseWithFormat2 = UtcOffsetJvmKt.parseWithFormat(input, isoBasicFormat);
                return parseWithFormat2;
            } else if (format == Formats.INSTANCE.getFOUR_DIGITS()) {
                fourDigitsFormat = UtcOffsetJvmKt.getFourDigitsFormat();
                Intrinsics.checkNotNullExpressionValue(fourDigitsFormat, "access$getFourDigitsFormat(...)");
                parseWithFormat = UtcOffsetJvmKt.parseWithFormat(input, fourDigitsFormat);
                return parseWithFormat;
            } else {
                return format.parse(input);
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
        public final /* synthetic */ UtcOffset parse(String offsetString) {
            Intrinsics.checkNotNullParameter(offsetString, "offsetString");
            return parse$default(this, offsetString, null, 2, null);
        }

        public final DateTimeFormat<UtcOffset> Format(Function1<? super DateTimeFormatBuilder.WithUtcOffset, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return UtcOffsetFormat.Companion.build(block);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UtcOffset parse$default(Companion companion, CharSequence charSequence, DateTimeFormat dateTimeFormat, int i, Object obj) {
            if ((i & 2) != 0) {
                dateTimeFormat = UtcOffsetKt.getIsoUtcOffsetFormat();
            }
            return companion.parse(charSequence, dateTimeFormat);
        }
    }

    static {
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        ZERO = new UtcOffset(UTC);
    }

    /* compiled from: UtcOffsetJvm.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lkotlinx/datetime/UtcOffset$Formats;", "", "<init>", "()V", ExifInterface.TAG_RW2_ISO, "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/UtcOffset;", "getISO", "()Lkotlinx/datetime/format/DateTimeFormat;", "ISO_BASIC", "getISO_BASIC", "FOUR_DIGITS", "getFOUR_DIGITS", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Formats {
        public static final Formats INSTANCE = new Formats();

        private Formats() {
        }

        public final DateTimeFormat<UtcOffset> getISO() {
            return UtcOffsetFormatKt.getISO_OFFSET();
        }

        public final DateTimeFormat<UtcOffset> getISO_BASIC() {
            return UtcOffsetFormatKt.getISO_OFFSET_BASIC();
        }

        public final DateTimeFormat<UtcOffset> getFOUR_DIGITS() {
            return UtcOffsetFormatKt.getFOUR_DIGIT_OFFSET();
        }
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("kotlinx.datetime.UtcOffset must be deserialized via kotlinx.datetime.Ser");
    }

    private final Object writeReplace() {
        return new Ser(10, this);
    }
}
