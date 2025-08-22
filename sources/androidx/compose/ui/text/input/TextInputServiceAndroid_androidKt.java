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
        int m6911getImeActioneUduSuo = imeOptions.m6911getImeActioneUduSuo();
        int i = 6;
        if (ImeAction.m6882equalsimpl0(m6911getImeActioneUduSuo, ImeAction.Companion.m6895getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m6882equalsimpl0(m6911getImeActioneUduSuo, ImeAction.Companion.m6899getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m6882equalsimpl0(m6911getImeActioneUduSuo, ImeAction.Companion.m6897getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m6882equalsimpl0(m6911getImeActioneUduSuo, ImeAction.Companion.m6898getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m6882equalsimpl0(m6911getImeActioneUduSuo, ImeAction.Companion.m6900getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m6882equalsimpl0(m6911getImeActioneUduSuo, ImeAction.Companion.m6901getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m6882equalsimpl0(m6911getImeActioneUduSuo, ImeAction.Companion.m6902getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m6882equalsimpl0(m6911getImeActioneUduSuo, ImeAction.Companion.m6896getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int m6912getKeyboardTypePjHm6EE = imeOptions.m6912getKeyboardTypePjHm6EE();
        if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6956getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6949getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6952getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6955getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6958getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6951getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6954getPasswordPjHm6EE())) {
            editorInfo.inputType = TsExtractor.TS_STREAM_TYPE_AC3;
        } else if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6953getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m6935equalsimpl0(m6912getKeyboardTypePjHm6EE, KeyboardType.Companion.m6950getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m6882equalsimpl0(imeOptions.m6911getImeActioneUduSuo(), ImeAction.Companion.m6895getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int m6910getCapitalizationIUNYP9k = imeOptions.m6910getCapitalizationIUNYP9k();
            if (KeyboardCapitalization.m6918equalsimpl0(m6910getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6927getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m6918equalsimpl0(m6910getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6931getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m6918equalsimpl0(m6910getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6929getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m6713getStartimpl(textFieldValue.m6964getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m6708getEndimpl(textFieldValue.m6964getSelectiond9O1mEE());
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
