package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.Density;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
/* compiled from: TextAutoSizeLayoutScope.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0001\u0002\f\rø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAutoSizeLayoutScope;", "Landroidx/compose/ui/unit/Density;", "performLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "text", "Landroidx/compose/ui/text/AnnotatedString;", TtmlNode.ATTR_TTS_FONT_SIZE, "Landroidx/compose/ui/unit/TextUnit;", "performLayout-5ZSfY2I", "(JLandroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache$TextAutoSizeLayoutScopeImpl;", "Landroidx/compose/foundation/text/modifiers/SimpleTextAutoSizeLayoutScope;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface TextAutoSizeLayoutScope extends Density {
    /* renamed from: performLayout-5ZSfY2I */
    TextLayoutResult mo1430performLayout5ZSfY2I(long j, AnnotatedString annotatedString, long j2);
}
