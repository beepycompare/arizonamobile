package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.concurrent.Executor;
import kotlin.Metadata;
/* compiled from: TextInputServiceAndroid.android.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0000\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", "", "updateWithEmojiCompat", "", "Landroid/view/inputmethod/EditorInfo;", "update", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "hasFlag", "", "bits", "", "flag", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        String privateImeOptions;
        int m7656getImeActioneUduSuo = imeOptions.m7656getImeActioneUduSuo();
        int i = 6;
        if (ImeAction.m7627equalsimpl0(m7656getImeActioneUduSuo, ImeAction.Companion.m7640getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m7627equalsimpl0(m7656getImeActioneUduSuo, ImeAction.Companion.m7644getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m7627equalsimpl0(m7656getImeActioneUduSuo, ImeAction.Companion.m7642getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m7627equalsimpl0(m7656getImeActioneUduSuo, ImeAction.Companion.m7643getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m7627equalsimpl0(m7656getImeActioneUduSuo, ImeAction.Companion.m7645getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m7627equalsimpl0(m7656getImeActioneUduSuo, ImeAction.Companion.m7646getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m7627equalsimpl0(m7656getImeActioneUduSuo, ImeAction.Companion.m7647getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m7627equalsimpl0(m7656getImeActioneUduSuo, ImeAction.Companion.m7641getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int m7657getKeyboardTypePjHm6EE = imeOptions.m7657getKeyboardTypePjHm6EE();
        if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7701getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7694getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7697getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7700getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7703getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7696getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7699getPasswordPjHm6EE())) {
            editorInfo.inputType = TsExtractor.TS_STREAM_TYPE_AC3;
        } else if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7698getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m7680equalsimpl0(m7657getKeyboardTypePjHm6EE, KeyboardType.Companion.m7695getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m7627equalsimpl0(imeOptions.m7656getImeActioneUduSuo(), ImeAction.Companion.m7640getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int m7655getCapitalizationIUNYP9k = imeOptions.m7655getCapitalizationIUNYP9k();
            if (KeyboardCapitalization.m7663equalsimpl0(m7655getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m7672getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m7663equalsimpl0(m7655getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m7676getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m7663equalsimpl0(m7655getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m7674getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m7458getStartimpl(textFieldValue.m7709getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m7453getEndimpl(textFieldValue.m7709getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$2(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$2(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
