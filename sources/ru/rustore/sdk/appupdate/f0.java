package ru.rustore.sdk.appupdate;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f0 {
    public static final Locale b = new Locale("ru", "RU");
    public static final TimeZone c;

    /* renamed from: a  reason: collision with root package name */
    public final Calendar f1348a = Calendar.getInstance();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Intrinsics.checkNotNullExpressionValue(timeZone, "getTimeZone(\"UTC\")");
        c = timeZone;
    }
}
