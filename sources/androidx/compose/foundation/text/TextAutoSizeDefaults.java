package androidx.compose.foundation.text;

import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
/* compiled from: TextAutoSize.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/TextAutoSizeDefaults;", "", "()V", "MaxFontSize", "Landroidx/compose/ui/unit/TextUnit;", "getMaxFontSize-XSAIIZE", "()J", "J", "MinFontSize", "getMinFontSize-XSAIIZE", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextAutoSizeDefaults {
    public static final int $stable = 0;
    public static final TextAutoSizeDefaults INSTANCE = new TextAutoSizeDefaults();
    private static final long MinFontSize = TextUnitKt.getSp(12);
    private static final long MaxFontSize = TextUnitKt.getSp(112);

    private TextAutoSizeDefaults() {
    }

    /* renamed from: getMinFontSize-XSAIIZE  reason: not valid java name */
    public final long m1139getMinFontSizeXSAIIZE() {
        return MinFontSize;
    }

    /* renamed from: getMaxFontSize-XSAIIZE  reason: not valid java name */
    public final long m1138getMaxFontSizeXSAIIZE() {
        return MaxFontSize;
    }
}
