package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TimeElement.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/DateParts;", "", "day", "", "month", "", "year", "hour", "minute", "second", "<init>", "(ILjava/lang/String;IIII)V", "getDay", "()I", "getMonth", "()Ljava/lang/String;", "getYear", "getHour", "getMinute", "getSecond", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DateParts {
    private final int day;
    private final int hour;
    private final int minute;
    private final String month;
    private final int second;
    private final int year;

    public static /* synthetic */ DateParts copy$default(DateParts dateParts, int i, String str, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = dateParts.day;
        }
        if ((i6 & 2) != 0) {
            str = dateParts.month;
        }
        if ((i6 & 4) != 0) {
            i2 = dateParts.year;
        }
        if ((i6 & 8) != 0) {
            i3 = dateParts.hour;
        }
        if ((i6 & 16) != 0) {
            i4 = dateParts.minute;
        }
        if ((i6 & 32) != 0) {
            i5 = dateParts.second;
        }
        int i7 = i4;
        int i8 = i5;
        return dateParts.copy(i, str, i2, i3, i7, i8);
    }

    public final int component1() {
        return this.day;
    }

    public final String component2() {
        return this.month;
    }

    public final int component3() {
        return this.year;
    }

    public final int component4() {
        return this.hour;
    }

    public final int component5() {
        return this.minute;
    }

    public final int component6() {
        return this.second;
    }

    public final DateParts copy(int i, String month, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(month, "month");
        return new DateParts(i, month, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateParts) {
            DateParts dateParts = (DateParts) obj;
            return this.day == dateParts.day && Intrinsics.areEqual(this.month, dateParts.month) && this.year == dateParts.year && this.hour == dateParts.hour && this.minute == dateParts.minute && this.second == dateParts.second;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.day) * 31) + this.month.hashCode()) * 31) + Integer.hashCode(this.year)) * 31) + Integer.hashCode(this.hour)) * 31) + Integer.hashCode(this.minute)) * 31) + Integer.hashCode(this.second);
    }

    public String toString() {
        int i = this.day;
        String str = this.month;
        int i2 = this.year;
        int i3 = this.hour;
        int i4 = this.minute;
        return "DateParts(day=" + i + ", month=" + str + ", year=" + i2 + ", hour=" + i3 + ", minute=" + i4 + ", second=" + this.second + ")";
    }

    public DateParts(int i, String month, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(month, "month");
        this.day = i;
        this.month = month;
        this.year = i2;
        this.hour = i3;
        this.minute = i4;
        this.second = i5;
    }

    public final int getDay() {
        return this.day;
    }

    public final String getMonth() {
        return this.month;
    }

    public final int getYear() {
        return this.year;
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
}
