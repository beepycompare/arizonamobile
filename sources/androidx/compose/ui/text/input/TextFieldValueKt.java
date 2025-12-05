package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
/* compiled from: TextFieldValue.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"getTextBeforeSelection", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "maxChars", "", "getTextAfterSelection", "getSelectedText", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextFieldValueKt {
    public static final AnnotatedString getTextBeforeSelection(TextFieldValue textFieldValue, int i) {
        AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
        int m7699getMinimpl = TextRange.m7699getMinimpl(textFieldValue.m7955getSelectiond9O1mEE());
        int i2 = m7699getMinimpl - i;
        if (((i ^ m7699getMinimpl) & (m7699getMinimpl ^ i2)) < 0) {
            i2 = 0;
        }
        return annotatedString.subSequence(Math.max(0, i2), TextRange.m7699getMinimpl(textFieldValue.m7955getSelectiond9O1mEE()));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue textFieldValue, int i) {
        AnnotatedString annotatedString = textFieldValue.getAnnotatedString();
        int m7698getMaximpl = TextRange.m7698getMaximpl(textFieldValue.m7955getSelectiond9O1mEE());
        int m7698getMaximpl2 = TextRange.m7698getMaximpl(textFieldValue.m7955getSelectiond9O1mEE());
        int i2 = m7698getMaximpl2 + i;
        if (((i ^ i2) & (m7698getMaximpl2 ^ i2)) < 0) {
            i2 = textFieldValue.getText().length();
        }
        return annotatedString.subSequence(m7698getMaximpl, Math.min(i2, textFieldValue.getText().length()));
    }

    public static final AnnotatedString getSelectedText(TextFieldValue textFieldValue) {
        return textFieldValue.getAnnotatedString().m7506subSequence5zctL8(textFieldValue.m7955getSelectiond9O1mEE());
    }
}
