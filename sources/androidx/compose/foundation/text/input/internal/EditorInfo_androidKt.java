package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
/* compiled from: EditorInfo.android.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¨\u0006\u0013"}, d2 = {"update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "hasFlag", "", "bits", "", "flag", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: update-pLxbY9I$default  reason: not valid java name */
    public static /* synthetic */ void m1500updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        m1499updatepLxbY9I(editorInfo, charSequence, j, imeOptions, strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b5  */
    /* renamed from: update-pLxbY9I  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1499updatepLxbY9I(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr) {
        String privateImeOptions;
        int m6924getImeActioneUduSuo = imeOptions.m6924getImeActioneUduSuo();
        int i = 3;
        int i2 = 6;
        if (ImeAction.m6895equalsimpl0(m6924getImeActioneUduSuo, ImeAction.Companion.m6908getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i2 = 0;
            }
        } else if (ImeAction.m6895equalsimpl0(m6924getImeActioneUduSuo, ImeAction.Companion.m6912getNoneeUduSuo())) {
            i2 = 1;
        } else if (ImeAction.m6895equalsimpl0(m6924getImeActioneUduSuo, ImeAction.Companion.m6910getGoeUduSuo())) {
            i2 = 2;
        } else if (ImeAction.m6895equalsimpl0(m6924getImeActioneUduSuo, ImeAction.Companion.m6911getNexteUduSuo())) {
            i2 = 5;
        } else if (ImeAction.m6895equalsimpl0(m6924getImeActioneUduSuo, ImeAction.Companion.m6913getPreviouseUduSuo())) {
            i2 = 7;
        } else if (ImeAction.m6895equalsimpl0(m6924getImeActioneUduSuo, ImeAction.Companion.m6914getSearcheUduSuo())) {
            i2 = 3;
        } else if (ImeAction.m6895equalsimpl0(m6924getImeActioneUduSuo, ImeAction.Companion.m6915getSendeUduSuo())) {
            i2 = 4;
        } else if (!ImeAction.m6895equalsimpl0(m6924getImeActioneUduSuo, ImeAction.Companion.m6909getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i2;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        LocaleListHelper.INSTANCE.setHintLocales(editorInfo, imeOptions.getHintLocales());
        int m6925getKeyboardTypePjHm6EE = imeOptions.m6925getKeyboardTypePjHm6EE();
        if (!KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6969getTextPjHm6EE())) {
            if (KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6962getAsciiPjHm6EE())) {
                editorInfo.imeOptions |= Integer.MIN_VALUE;
            } else {
                if (KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6965getNumberPjHm6EE())) {
                    i = 2;
                } else if (!KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6968getPhonePjHm6EE())) {
                    if (KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6971getUriPjHm6EE())) {
                        i = 17;
                    } else if (KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6964getEmailPjHm6EE())) {
                        i = 33;
                    } else if (KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6967getPasswordPjHm6EE())) {
                        i = TsExtractor.TS_STREAM_TYPE_AC3;
                    } else if (KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6966getNumberPasswordPjHm6EE())) {
                        i = 18;
                    } else if (!KeyboardType.m6948equalsimpl0(m6925getKeyboardTypePjHm6EE, KeyboardType.Companion.m6963getDecimalPjHm6EE())) {
                        throw new IllegalStateException("Invalid Keyboard Type".toString());
                    } else {
                        i = 8194;
                    }
                }
                editorInfo.inputType = i;
                if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
                    editorInfo.inputType |= 131072;
                    if (ImeAction.m6895equalsimpl0(imeOptions.m6924getImeActioneUduSuo(), ImeAction.Companion.m6908getDefaulteUduSuo())) {
                        editorInfo.imeOptions |= 1073741824;
                    }
                }
                if (hasFlag(editorInfo.inputType, 1)) {
                    int m6923getCapitalizationIUNYP9k = imeOptions.m6923getCapitalizationIUNYP9k();
                    if (KeyboardCapitalization.m6931equalsimpl0(m6923getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6940getCharactersIUNYP9k())) {
                        editorInfo.inputType |= 4096;
                    } else if (KeyboardCapitalization.m6931equalsimpl0(m6923getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6944getWordsIUNYP9k())) {
                        editorInfo.inputType |= 8192;
                    } else if (KeyboardCapitalization.m6931equalsimpl0(m6923getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6942getSentencesIUNYP9k())) {
                        editorInfo.inputType |= 16384;
                    }
                    if (imeOptions.getAutoCorrect()) {
                        editorInfo.inputType |= 32768;
                    }
                }
                editorInfo.initialSelStart = TextRange.m6726getStartimpl(j);
                editorInfo.initialSelEnd = TextRange.m6721getEndimpl(j);
                EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
                if (strArr != null) {
                    EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
                }
                editorInfo.imeOptions |= 33554432;
                if (!StylusHandwriting_androidKt.isStylusHandwritingSupported() && !KeyboardType.m6948equalsimpl0(imeOptions.m6925getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6967getPasswordPjHm6EE()) && !KeyboardType.m6948equalsimpl0(imeOptions.m6925getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6966getNumberPasswordPjHm6EE())) {
                    EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
                    EditorInfoApi34.INSTANCE.setHandwritingGestures(editorInfo);
                    return;
                }
                EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
            }
        }
        i = 1;
        editorInfo.inputType = i;
        if (!imeOptions.getSingleLine()) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m6895equalsimpl0(imeOptions.m6924getImeActioneUduSuo(), ImeAction.Companion.m6908getDefaulteUduSuo())) {
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
        }
        editorInfo.initialSelStart = TextRange.m6726getStartimpl(j);
        editorInfo.initialSelEnd = TextRange.m6721getEndimpl(j);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
        if (strArr != null) {
        }
        editorInfo.imeOptions |= 33554432;
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
        }
        EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
    }
}
