package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import kotlin.Metadata;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: Measurer.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"DEBUG", "", "anyOrNullId", "", "Landroidx/compose/ui/layout/Measurable;", "getAnyOrNullId", "(Landroidx/compose/ui/layout/Measurable;)Ljava/lang/String;", "constraintlayout-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MeasurerKt {
    private static final boolean DEBUG = false;

    public static final String getAnyOrNullId(Measurable measurable) {
        String obj;
        Object layoutId = LayoutIdKt.getLayoutId(measurable);
        if (layoutId == null) {
            layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable);
        }
        return (layoutId == null || (obj = layoutId.toString()) == null) ? AbstractJsonLexerKt.NULL : obj;
    }
}
