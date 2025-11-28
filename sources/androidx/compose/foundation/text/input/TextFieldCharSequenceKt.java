package androidx.compose.foundation.text.input;

import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
/* compiled from: TextFieldCharSequence.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0004*\u00020\u0005H\u0000*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\n"}, d2 = {"PlacedAnnotation", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "getTextBeforeSelection", "", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "maxChars", "", "getTextAfterSelection", "getSelectedText", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldCharSequenceKt {
    public static final CharSequence getTextBeforeSelection(TextFieldCharSequence textFieldCharSequence, int i) {
        return textFieldCharSequence.subSequence(Math.max(0, TextRange.m7456getMinimpl(textFieldCharSequence.m1447getSelectiond9O1mEE()) - i), TextRange.m7456getMinimpl(textFieldCharSequence.m1447getSelectiond9O1mEE()));
    }

    public static final CharSequence getTextAfterSelection(TextFieldCharSequence textFieldCharSequence, int i) {
        return textFieldCharSequence.subSequence(TextRange.m7455getMaximpl(textFieldCharSequence.m1447getSelectiond9O1mEE()), Math.min(TextRange.m7455getMaximpl(textFieldCharSequence.m1447getSelectiond9O1mEE()) + i, textFieldCharSequence.length()));
    }

    public static final CharSequence getSelectedText(TextFieldCharSequence textFieldCharSequence) {
        return textFieldCharSequence.subSequence(TextRange.m7456getMinimpl(textFieldCharSequence.m1447getSelectiond9O1mEE()), TextRange.m7455getMaximpl(textFieldCharSequence.m1447getSelectiond9O1mEE()));
    }
}
