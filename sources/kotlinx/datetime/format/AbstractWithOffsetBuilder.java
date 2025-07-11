package kotlinx.datetime.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.SignedFormatStructure;
/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkotlinx/datetime/format/AbstractWithOffsetBuilder;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "addFormatStructureForOffset", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "offsetHours", "padding", "Lkotlinx/datetime/format/Padding;", "offsetMinutesOfHour", "offsetSecondsOfMinute", TypedValues.CycleType.S_WAVE_OFFSET, "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/UtcOffset;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AbstractWithOffsetBuilder extends DateTimeFormatBuilder.WithUtcOffset {
    void addFormatStructureForOffset(FormatStructure<? super UtcOffsetFieldContainer> formatStructure);

    /* compiled from: UtcOffsetFormat.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void offsetHours(AbstractWithOffsetBuilder abstractWithOffsetBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithOffsetBuilder.super.offsetHours(padding);
        }

        @Deprecated
        public static void offsetMinutesOfHour(AbstractWithOffsetBuilder abstractWithOffsetBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithOffsetBuilder.super.offsetMinutesOfHour(padding);
        }

        @Deprecated
        public static void offsetSecondsOfMinute(AbstractWithOffsetBuilder abstractWithOffsetBuilder, Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            AbstractWithOffsetBuilder.super.offsetSecondsOfMinute(padding);
        }

        @Deprecated
        public static void offset(AbstractWithOffsetBuilder abstractWithOffsetBuilder, DateTimeFormat<UtcOffset> format) {
            Intrinsics.checkNotNullParameter(format, "format");
            AbstractWithOffsetBuilder.super.offset(format);
        }
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    default void offsetHours(Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        addFormatStructureForOffset(new SignedFormatStructure(new BasicFormatStructure(new UtcOffsetWholeHoursDirective(padding)), true));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    default void offsetMinutesOfHour(Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        addFormatStructureForOffset(new BasicFormatStructure(new UtcOffsetMinuteOfHourDirective(padding)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    default void offsetSecondsOfMinute(Padding padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        addFormatStructureForOffset(new BasicFormatStructure(new UtcOffsetSecondOfMinuteDirective(padding)));
    }

    @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
    default void offset(DateTimeFormat<UtcOffset> format) {
        Intrinsics.checkNotNullParameter(format, "format");
        if (format instanceof UtcOffsetFormat) {
            addFormatStructureForOffset(((UtcOffsetFormat) format).getActualFormat());
        }
    }
}
