package ru.mrlargha.pirates;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlinx.datetime.internal.DateCalculationsKt;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u001a(\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0002¨\u0006\f"}, d2 = {"formatDurationRu", "", "totalSeconds", "", "showSeconds", "", "ruPlural", "n", "", "one", "few", "many", NotificationCompat.CATEGORY_EVENT}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilKt {
    public static /* synthetic */ String formatDurationRu$default(int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return formatDurationRu(i, z);
    }

    public static final String formatDurationRu(int i, boolean z) {
        long coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        long j = 86400;
        long j2 = coerceAtLeast / j;
        long j3 = coerceAtLeast % j;
        long j4 = (long) DateCalculationsKt.SECONDS_PER_HOUR;
        long j5 = j3 / j4;
        long j6 = j3 % j4;
        long j7 = 60;
        long j8 = j6 / j7;
        long j9 = j6 % j7;
        ArrayList arrayList = new ArrayList(4);
        if (j2 > 0) {
            arrayList.add(j2 + " " + ruPlural(j2, "день", "дня", "дней"));
        }
        if (j5 > 0) {
            arrayList.add(j5 + " " + ruPlural(j5, "час", "часа", "часов"));
        }
        if (j8 > 0) {
            arrayList.add(j8 + " " + ruPlural(j8, "минута", "минуты", "минут"));
        }
        if (z && j9 > 0) {
            arrayList.add(j9 + " " + ruPlural(j9, "секунда", "секунды", "секунд"));
        }
        if (arrayList.isEmpty()) {
            return z ? "0 секунд" : "0 минут";
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }

    private static final String ruPlural(long j, String str, String str2, String str3) {
        int abs = (int) Math.abs(j);
        int i = abs % 100;
        int i2 = abs % 10;
        return (11 > i || i >= 15) ? i2 == 1 ? str : (2 > i2 || i2 >= 5) ? str3 : str2 : str3;
    }
}
