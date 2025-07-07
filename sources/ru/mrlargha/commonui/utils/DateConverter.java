package ru.mrlargha.commonui.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DateConverter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lru/mrlargha/commonui/utils/DateConverter;", "", "<init>", "()V", "fromTimestamp", "Ljava/util/Date;", "value", "", "(Ljava/lang/Long;)Ljava/util/Date;", "dateToTimestamp", "date", "(Ljava/util/Date;)Ljava/lang/Long;", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DateConverter {
    public static final Companion Companion = new Companion(null);

    /* compiled from: DateConverter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/utils/DateConverter$Companion;", "", "<init>", "()V", "fromTimestampToTimeStr", "", "timestamp", "", "formattedTimeToday", "formatTimestamp", "dateWithTime", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String fromTimestampToTimeStr(long j) {
            Date date = new Date(j);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(date);
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }

        public final String formattedTimeToday() {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(Calendar.getInstance(TimeZone.getDefault()).getTime());
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }

        public static /* synthetic */ String formatTimestamp$default(Companion companion, long j, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.formatTimestamp(j, z);
        }

        public final String formatTimestamp(long j, boolean z) {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            Calendar calendar2 = Calendar.getInstance(TimeZone.getDefault());
            calendar2.setTimeInMillis(j * 1000);
            if (calendar2.get(6) == calendar.get(6)) {
                String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(calendar2.getTime());
                Intrinsics.checkNotNull(format);
                return format;
            }
            String format2 = new SimpleDateFormat("dd MMM ".concat(z ? ", HH:mm" : ""), Locale.getDefault()).format(calendar2.getTime());
            Intrinsics.checkNotNull(format2);
            return format2;
        }
    }

    public final Date fromTimestamp(Long l) {
        if (l != null) {
            return new Date(l.longValue());
        }
        return null;
    }

    public final Long dateToTimestamp(Date date) {
        if (date != null) {
            return Long.valueOf(date.getTime());
        }
        return null;
    }
}
