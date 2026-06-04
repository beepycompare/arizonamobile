package ru.mrlargha.commonui.elements.craft.presentation;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: CraftScreen.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"craftTimeConvert", "", "context", "Landroid/content/Context;", "time", "", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CraftScreenKt {
    public static final String craftTimeConvert(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        long abs = Math.abs((j * 1000) - System.currentTimeMillis());
        TimeUnit.MILLISECONDS.toDays(abs);
        String string = context.getString(R.string.craft_time_format, Long.valueOf(TimeUnit.MILLISECONDS.toHours(abs) % 24), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(abs) % 60), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(abs) % 60));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
