package ru.mrlargha.feature.documents;

import kotlin.Metadata;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.utils.ui.money.MoneyFormatter;
/* compiled from: TransportAdapter.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"toFormattedTransportCost", "", "documents"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TransportAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String toFormattedTransportCost(String str) {
        String obj = StringsKt.trim((CharSequence) str).toString();
        String str2 = "";
        String replace = StringsKt.replace(obj, ":cash:", "", true);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < replace.length(); i++) {
            char charAt = replace.charAt(i);
            if (!CharsKt.isWhitespace(charAt) && charAt != ',' && charAt != '.' && charAt != '$') {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Long longOrNull = StringsKt.toLongOrNull(sb2);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (StringsKt.startsWith$default(sb2, "+", false, 2, (Object) null) && longValue >= 0) {
                str2 = "+";
            }
            return str2 + MoneyFormatter.INSTANCE.formatPlain(longValue);
        }
        return obj;
    }
}
