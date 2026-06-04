package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: String.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, d2 = {"htmlEncode", "", "core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StringKt {
    public static final String htmlEncode(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String htmlEncode = TextUtils.htmlEncode(str);
        Intrinsics.checkNotNullExpressionValue(htmlEncode, "htmlEncode(...)");
        return htmlEncode;
    }
}
