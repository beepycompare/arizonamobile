package ru.mrlargha.arizonaui.ghetto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
/* compiled from: WarsAdapter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u001c\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"formatUnixTime", "Lkotlin/Pair;", "", "unixSeconds", "", "ArizonaUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WarsAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<String, String> formatUnixTime(long j) {
        Date date = new Date(j * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        String format = simpleDateFormat.format(date);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        return new Pair<>(format, simpleDateFormat2.format(date));
    }
}
