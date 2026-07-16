package ru.mrlargha.commonui.utils.ui.money;

import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.UtilsKt;
/* compiled from: MoneyElement.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0012J\f\u0010\u0013\u001a\u00020\u0007*\u00020\u0007H\u0002¨\u0006\u0014"}, d2 = {"Lru/mrlargha/commonui/utils/ui/money/MoneyFormatter;", "", "<init>", "()V", "format", "", "value", "", "isInvert", "", "prefix", "postfix", "formatMoneyShort", "rawValue", "formatPlain", "splitValue", "Lru/mrlargha/commonui/utils/ui/money/MoneyParts;", "formatK", "", "absSafe", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MoneyFormatter {
    public static final MoneyFormatter INSTANCE = new MoneyFormatter();

    private MoneyFormatter() {
    }

    public static /* synthetic */ String format$default(MoneyFormatter moneyFormatter, long j, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return moneyFormatter.format(j, z, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2);
    }

    public final String format(long j, boolean z, String prefix, String postfix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        if (UtilsKt.isArizonaType()) {
            String str = "+";
            String str2 = (Intrinsics.areEqual(prefix, "+") || Intrinsics.areEqual(prefix, Constants.FILENAME_SEQUENCE_SEPARATOR)) ? "" : prefix;
            if (j >= 0) {
                if (!Intrinsics.areEqual(prefix, "+")) {
                    if (!Intrinsics.areEqual(prefix, Constants.FILENAME_SEQUENCE_SEPARATOR)) {
                        str = "";
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(":cash: ");
                sb.append(str);
                MoneyFormatter moneyFormatter = INSTANCE;
                sb.append(moneyFormatter.formatPlain(moneyFormatter.absSafe(j)));
                sb.append(postfix);
                return sb.toString();
            }
            str = Constants.FILENAME_SEQUENCE_SEPARATOR;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(":cash: ");
            sb2.append(str);
            MoneyFormatter moneyFormatter2 = INSTANCE;
            sb2.append(moneyFormatter2.formatPlain(moneyFormatter2.absSafe(j)));
            sb2.append(postfix);
            return sb2.toString();
        }
        return String.valueOf(j);
    }

    public static /* synthetic */ String formatMoneyShort$default(MoneyFormatter moneyFormatter, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return moneyFormatter.formatMoneyShort(j, str);
    }

    public final String formatMoneyShort(long j, String prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return format$default(this, j, false, prefix, null, 10, null);
    }

    public final String formatPlain(long j) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%,d", Arrays.copyOf(new Object[]{Long.valueOf(j)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return StringsKt.replace$default(format, StringUtils.COMMA, " ", false, 4, (Object) null);
    }

    public final MoneyParts splitValue(long j) {
        return LegacyMoneyFormatter.INSTANCE.splitValue(j);
    }

    public final String formatK(int i) {
        return LegacyMoneyFormatter.formatK$default(LegacyMoneyFormatter.INSTANCE, i, false, 2, null);
    }

    private final long absSafe(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return Math.abs(j);
    }
}
