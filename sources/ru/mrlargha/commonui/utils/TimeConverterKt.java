package ru.mrlargha.commonui.utils;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.datetime.internal.DateCalculationsKt;
/* compiled from: TimeConverter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0003\u001a\u000e\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0003¨\u0006\u000e"}, d2 = {"mainPageTimeConvert", "", "time", "", "taskPageTimeConvert", "unixTime", "oldPriseTimeConvert", "welcomeTimeConvert", "toTimeString", "", "toDataString", "", "formatMillisToTime", "millis", "CommonUI"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TimeConverterKt {
    public static final String mainPageTimeConvert(long j) {
        long abs = Math.abs((j * 1000) - System.currentTimeMillis());
        long days = TimeUnit.MILLISECONDS.toDays(abs);
        long hours = TimeUnit.MILLISECONDS.toHours(abs) % 24;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(abs) % 60;
        if (days > 0) {
            return days + " дней";
        }
        return hours + " ч. " + minutes + " м.";
    }

    public static final String taskPageTimeConvert(long j) {
        long abs = Math.abs((j * 1000) - System.currentTimeMillis());
        long days = TimeUnit.MILLISECONDS.toDays(abs);
        long hours = TimeUnit.MILLISECONDS.toHours(abs) % 24;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(abs) % 60;
        return days == 0 ? days + " д. " + hours + " ч. " + minutes + " м." : hours + " ч. " + minutes + " м.";
    }

    public static final String oldPriseTimeConvert(long j) {
        long abs = Math.abs((j * 1000) - System.currentTimeMillis());
        long hours = TimeUnit.MILLISECONDS.toHours(abs);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(abs) % 60;
        if (hours > 2) {
            return "1 час+";
        }
        if (hours >= 1) {
            return "1 час";
        }
        if (minutes > 30) {
            return "59 мин";
        }
        if (minutes > 2) {
            return "2 мин";
        }
        return "1 сек";
    }

    public static final String welcomeTimeConvert(long j) {
        long abs = Math.abs((j * 1000) - System.currentTimeMillis());
        long days = TimeUnit.MILLISECONDS.toDays(abs);
        long hours = TimeUnit.MILLISECONDS.toHours(abs) % 24;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(abs) % 60;
        return String.valueOf(days);
    }

    public static final String toTimeString(int i) {
        int i2 = i / DateCalculationsKt.SECONDS_PER_HOUR;
        int i3 = (i % DateCalculationsKt.SECONDS_PER_HOUR) / 60;
        int i4 = i % 60;
        if (i2 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        } else if (i3 > 0) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("0:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            return format3;
        }
    }

    public static final void toDataString(long j) {
        long abs = Math.abs((j * 1000) - System.currentTimeMillis());
        TimeUnit.MILLISECONDS.toDays(abs);
        long hours = TimeUnit.MILLISECONDS.toHours(abs) % 24;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(abs) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(abs) % 60;
    }

    public static final String formatMillisToTime(long j) {
        long j2 = j / 1000;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j2 / 3600), Long.valueOf((j2 % 3600) / 60), Long.valueOf(j2 % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
