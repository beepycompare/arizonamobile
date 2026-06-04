package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TimeElement.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"timestampToParts", "Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/time/DateParts;", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TimeElementKt {
    public static final DateParts timestampToParts(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        calendar.setTimeInMillis(j * 1000);
        int i = calendar.get(5);
        int i2 = calendar.get(1);
        int i3 = calendar.get(11);
        int i4 = calendar.get(12);
        int i5 = calendar.get(13);
        String format = new SimpleDateFormat("MMMM", new Locale("ru")).format(calendar.getTime());
        Intrinsics.checkNotNull(format);
        return new DateParts(i, format, i2, i3, i4, i5);
    }
}
