package ru.mrlargha.commonui.elements.battlepassWinter2025.utils;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
/* compiled from: TimeConverter.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\b"}, d2 = {"mainPageTimeConvert", "", "time", "", "taskPageTimeConvert", "unixTime", "oldPriseTimeConvert", "welcomeTimeConvert", "CommonUI_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
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
}
