package androidx.compose.material3.tokens;

import androidx.compose.material3.internal.DefaultPlatformTextStyle_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.LineHeightStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TypographyTokens.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"DefaultLineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefaultLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultTextStyle", "Landroidx/compose/ui/text/TextStyle;", "getDefaultTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypographyTokensKt {
    private static final LineHeightStyle DefaultLineHeightStyle;
    private static final TextStyle DefaultTextStyle;

    public static final LineHeightStyle getDefaultLineHeightStyle() {
        return DefaultLineHeightStyle;
    }

    static {
        LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.Companion.m6536getCenterPIaL0Z0(), LineHeightStyle.Trim.Companion.m6560getNoneEVpEnUU(), (DefaultConstructorMarker) null);
        DefaultLineHeightStyle = lineHeightStyle;
        DefaultTextStyle = TextStyle.m6160copyp1EtxEg$default(TextStyle.Companion.getDefault(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), lineHeightStyle, 0, 0, null, 15204351, null);
    }

    public static final TextStyle getDefaultTextStyle() {
        return DefaultTextStyle;
    }
}
