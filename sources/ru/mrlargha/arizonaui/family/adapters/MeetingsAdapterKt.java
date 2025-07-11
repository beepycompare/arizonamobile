package ru.mrlargha.arizonaui.family.adapters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
/* compiled from: MeetingsAdapter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"formatUnixTime", "Lkotlin/Pair;", "", "unixSeconds", "", "timeZoneId", "ArizonaUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MeetingsAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<String, String> formatUnixTime(long j, String str) {
        Date date = new Date(j * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str));
        String format = simpleDateFormat.format(date);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(str));
        return new Pair<>(format, simpleDateFormat2.format(date));
    }
}
