package ru.mrlargha.pirates;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.mrlargha.feature.event.R;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"formatDurationLocalized", "", "context", "Landroid/content/Context;", "totalSeconds", "", "showSeconds", "", NotificationCompat.CATEGORY_EVENT}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UtilKt {
    public static /* synthetic */ String formatDurationLocalized$default(Context context, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return formatDurationLocalized(context, i, z);
    }

    public static final String formatDurationLocalized(Context context, int i, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        long coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        long j = coerceAtLeast / 86400;
        long j2 = coerceAtLeast % 86400;
        long j3 = j2 / 3600;
        long j4 = j2 % 3600;
        long j5 = j4 / 60;
        long j6 = j4 % 60;
        ArrayList arrayList = new ArrayList(4);
        if (j > 0) {
            arrayList.add(context.getString(R.string.event_time_day_short, Long.valueOf(j)));
        }
        if (j3 > 0) {
            arrayList.add(context.getString(R.string.event_time_hour_short, Long.valueOf(j3)));
        }
        if (j5 > 0) {
            arrayList.add(context.getString(R.string.event_time_minute_short, Long.valueOf(j5)));
        }
        if (z && j6 > 0) {
            arrayList.add(context.getString(R.string.event_time_second_short, Long.valueOf(j6)));
        }
        if (arrayList.isEmpty()) {
            String string = context.getString(R.string.event_time_zero);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        return CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null);
    }
}
