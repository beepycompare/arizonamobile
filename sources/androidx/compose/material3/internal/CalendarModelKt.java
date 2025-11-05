package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: CalendarModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"datePatternAsInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "localeFormat", "", "DaysInWeek", "", "MillisecondsIn24Hours", "", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CalendarModelKt {
    public static final int DaysInWeek = 7;
    public static final long MillisecondsIn24Hours = 86400000;

    public static final DateInputFormat datePatternAsInputFormat(String str) {
        Regex regex = new Regex("[^dMy/\\-.]");
        Regex regex2 = new Regex("d{1,2}");
        Regex regex3 = new Regex("M{1,2}");
        String removeSuffix = StringsKt.removeSuffix(StringsKt.replace$default(new Regex("y{1,4}").replace(regex3.replace(regex2.replace(regex.replace(str, ""), "dd"), "MM"), "yyyy"), "My", "M/y", false, 4, (Object) null), (CharSequence) ".");
        MatchResult find$default = Regex.find$default(new Regex("[/\\-.]"), removeSuffix, 0, 2, null);
        Intrinsics.checkNotNull(find$default);
        MatchGroup matchGroup = find$default.getGroups().get(0);
        Intrinsics.checkNotNull(matchGroup);
        return new DateInputFormat(removeSuffix, matchGroup.getValue().charAt(0));
    }
}
