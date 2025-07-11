package ru.mrlargha.commonui.elements.craft.presentation;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
/* compiled from: CraftScreen.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"craftTimeConvert", "", "time", "", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CraftScreenKt {
    public static final String craftTimeConvert(long j) {
        long j2;
        long abs = Math.abs((j * 1000) - System.currentTimeMillis());
        TimeUnit.MILLISECONDS.toDays(abs);
        return (TimeUnit.MILLISECONDS.toHours(abs) % 24) + " ч. " + (TimeUnit.MILLISECONDS.toMinutes(abs) % 60) + " м. " + (TimeUnit.MILLISECONDS.toSeconds(abs) % j2) + " c.";
    }
}
