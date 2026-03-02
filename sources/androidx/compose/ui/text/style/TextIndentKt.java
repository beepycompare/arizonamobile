package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: TextIndent.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextIndent;", TtmlNode.START, "stop", "fraction", "", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextIndentKt {
    public static final TextIndent lerp(TextIndent textIndent, TextIndent textIndent2, float f) {
        return new TextIndent(SpanStyleKt.m6950lerpTextUnitInheritableC3pnCVY(textIndent.m7463getFirstLineXSAIIZE(), textIndent2.m7463getFirstLineXSAIIZE(), f), SpanStyleKt.m6950lerpTextUnitInheritableC3pnCVY(textIndent.m7464getRestLineXSAIIZE(), textIndent2.m7464getRestLineXSAIIZE(), f), null);
    }
}
