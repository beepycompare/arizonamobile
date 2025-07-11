package kotlinx.datetime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: toKotlinCode.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toKotlinCode", "", "", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ToKotlinCodeKt {
    public static final String toKotlinCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt == '\\') {
                sb.append("\\\\");
            } else {
                switch (charAt) {
                    case '\b':
                        sb.append("\\b");
                        continue;
                    case '\t':
                        sb.append("\\t");
                        continue;
                    case '\n':
                        sb.append("\\n");
                        continue;
                    default:
                        sb.append(charAt);
                        continue;
                }
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    public static final String toKotlinCode(char c) {
        if (c == '\'') {
            return "'\\''";
        }
        return "'" + c + '\'';
    }
}
