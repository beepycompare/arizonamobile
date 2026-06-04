package ru.mrlargha.commonui.utils.ui.money;

import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: MoneyElement.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/utils/ui/money/LegacyMoneyFormatter;", "", "<init>", "()V", "format", "", "value", "", "isInvert", "", "prefix", "postfix", "formatMoneyShort", "rawValue", "splitValue", "Lru/mrlargha/commonui/utils/ui/money/MoneyParts;", "formatK", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LegacyMoneyFormatter {
    public static final LegacyMoneyFormatter INSTANCE = new LegacyMoneyFormatter();

    private LegacyMoneyFormatter() {
    }

    public static /* synthetic */ String format$default(LegacyMoneyFormatter legacyMoneyFormatter, long j, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return legacyMoneyFormatter.format(j, z, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2);
    }

    public final String format(long j, boolean z, String prefix, String postfix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        if (UtilsKt.isArizonaType()) {
            MoneyParts splitValue = splitValue(j);
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            if (z) {
                if (splitValue.getM() > 0) {
                    sb.append(splitValue.getM());
                    sb.append(":m: ");
                }
                if (splitValue.getM() > 0 || splitValue.getKk() > 0) {
                    sb.append(splitValue.getKk());
                    sb.append(":kk: ");
                }
                sb.append(INSTANCE.formatK(splitValue.getK()));
                sb.append(":k:");
            } else {
                if (splitValue.getM() > 0) {
                    sb.append(":m:");
                    sb.append(splitValue.getM());
                    sb.append(" ");
                }
                if (splitValue.getM() > 0 || splitValue.getKk() > 0) {
                    sb.append(":kk:");
                    sb.append(splitValue.getKk());
                    sb.append(" ");
                }
                sb.append(":k:");
                sb.append(INSTANCE.formatK(splitValue.getK()));
            }
            sb.append(postfix);
            return sb.toString();
        }
        return String.valueOf(j);
    }

    public static /* synthetic */ String formatMoneyShort$default(LegacyMoneyFormatter legacyMoneyFormatter, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return legacyMoneyFormatter.formatMoneyShort(j, str);
    }

    public final String formatMoneyShort(long j, String prefix) {
        String str;
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (UtilsKt.isArizonaType()) {
            String padStart = StringsKt.padStart(String.valueOf(Math.abs(j)), 13, '0');
            String trimStart = StringsKt.trimStart(StringsKt.dropLast(padStart, 9), '0');
            if (trimStart.length() == 0) {
                trimStart = "0";
            }
            Integer intOrNull = StringsKt.toIntOrNull(trimStart);
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            String trimStart2 = StringsKt.trimStart(StringsKt.dropLast(StringsKt.takeLast(padStart, 9), 6), '0');
            Integer intOrNull2 = StringsKt.toIntOrNull(trimStart2.length() != 0 ? trimStart2 : "0");
            int intValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
            Integer intOrNull3 = StringsKt.toIntOrNull(StringsKt.takeLast(padStart, 6));
            int intValue3 = intOrNull3 != null ? intOrNull3.intValue() : 0;
            int i = intValue3 / 1000;
            int i2 = intValue3 % 1000;
            String str2 = i + "." + StringsKt.padStart(String.valueOf(i2), 3, '0');
            String str3 = j < 0 ? Constants.FILENAME_SEQUENCE_SEPARATOR : "";
            if (intValue >= 1) {
                if (i <= 0 && i2 <= 0) {
                    r3 = false;
                }
                str = ":m:" + intValue + StringUtils.COMMA + StringsKt.padStart(String.valueOf(intValue2), 3, '0') + (r3 ? "..." : "");
            } else if (intValue2 >= 1) {
                str = ":kk:" + intValue2 + StringUtils.COMMA + StringsKt.padStart(String.valueOf(i), 3, '0') + (i2 > 0 ? "..." : "");
            } else {
                str = ":k:" + str2;
            }
            return prefix + str3 + str;
        }
        return String.valueOf(j);
    }

    public final MoneyParts splitValue(long j) {
        String padStart = StringsKt.padStart(String.valueOf(RangesKt.coerceAtLeast(j, 0L)), 13, '0');
        String dropLast = StringsKt.dropLast(padStart, 9);
        String dropLast2 = StringsKt.dropLast(StringsKt.takeLast(padStart, 9), 6);
        String takeLast = StringsKt.takeLast(padStart, 6);
        String trimStart = StringsKt.trimStart(dropLast, '0');
        if (trimStart.length() == 0) {
            trimStart = "0";
        }
        Integer intOrNull = StringsKt.toIntOrNull(trimStart);
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        String trimStart2 = StringsKt.trimStart(dropLast2, '0');
        if (trimStart2.length() == 0) {
            trimStart2 = "0";
        }
        Integer intOrNull2 = StringsKt.toIntOrNull(trimStart2);
        int intValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
        String trimStart3 = StringsKt.trimStart(takeLast, '0');
        Integer intOrNull3 = StringsKt.toIntOrNull(trimStart3.length() != 0 ? trimStart3 : "0");
        return new MoneyParts(intValue, intValue2, intOrNull3 != null ? intOrNull3.intValue() : 0);
    }

    public final String formatK(int i) {
        int coerceIn = RangesKt.coerceIn(i, 0, 999999);
        int i2 = coerceIn / 1000;
        return i2 + "." + StringsKt.padStart(String.valueOf(coerceIn % 1000), 3, '0');
    }
}
