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
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a@\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"hasFlag", "", "bits", "", "flag", "update", "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: update-pLxbY9I$default  reason: not valid java name */
    public static /* synthetic */ void m1248updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        m1247updatepLxbY9I(editorInfo, charSequence, j, imeOptions, strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b5  */
    /* renamed from: update-pLxbY9I  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1247updatepLxbY9I(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr) {
        String privateImeOptions;
        int m6343getImeActioneUduSuo = imeOptions.m6343getImeActioneUduSuo();
        int i = 3;
        int i2 = 6;
        if (ImeAction.m6314equalsimpl0(m6343getImeActioneUduSuo, ImeAction.Companion.m6327getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i2 = 0;
            }
        } else if (ImeAction.m6314equalsimpl0(m6343getImeActioneUduSuo, ImeAction.Companion.m6331getNoneeUduSuo())) {
            i2 = 1;
        } else if (ImeAction.m6314equalsimpl0(m6343getImeActioneUduSuo, ImeAction.Companion.m6329getGoeUduSuo())) {
            i2 = 2;
        } else if (ImeAction.m6314equalsimpl0(m6343getImeActioneUduSuo, ImeAction.Companion.m6330getNexteUduSuo())) {
            i2 = 5;
        } else if (ImeAction.m6314equalsimpl0(m6343getImeActioneUduSuo, ImeAction.Companion.m6332getPreviouseUduSuo())) {
            i2 = 7;
        } else if (ImeAction.m6314equalsimpl0(m6343getImeActioneUduSuo, ImeAction.Companion.m6333getSearcheUduSuo())) {
            i2 = 3;
        } else if (ImeAction.m6314equalsimpl0(m6343getImeActioneUduSuo, ImeAction.Companion.m6334getSendeUduSuo())) {
            i2 = 4;
        } else if (!ImeAction.m6314equalsimpl0(m6343getImeActioneUduSuo, ImeAction.Companion.m6328getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        editorInfo.imeOptions = i2;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        LocaleListHelper.INSTANCE.setHintLocales(editorInfo, imeOptions.getHintLocales());
        int m6344getKeyboardTypePjHm6EE = imeOptions.m6344getKeyboardTypePjHm6EE();
        if (!KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6388getTextPjHm6EE())) {
            if (KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6381getAsciiPjHm6EE())) {
                editorInfo.imeOptions |= Integer.MIN_VALUE;
            } else {
                if (KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6384getNumberPjHm6EE())) {
                    i = 2;
                } else if (!KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6387getPhonePjHm6EE())) {
                    if (KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6390getUriPjHm6EE())) {
                        i = 17;
                    } else if (KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6383getEmailPjHm6EE())) {
                        i = 33;
                    } else if (KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6386getPasswordPjHm6EE())) {
                        i = TsExtractor.TS_STREAM_TYPE_AC3;
                    } else if (KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6385getNumberPasswordPjHm6EE())) {
                        i = 18;
                    } else if (!KeyboardType.m6367equalsimpl0(m6344getKeyboardTypePjHm6EE, KeyboardType.Companion.m6382getDecimalPjHm6EE())) {
                        throw new IllegalStateException("Invalid Keyboard Type".toString());
                    } else {
                        i = 8194;
                    }
                }
                editorInfo.inputType = i;
                if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
                    editorInfo.inputType |= 131072;
                    if (ImeAction.m6314equalsimpl0(imeOptions.m6343getImeActioneUduSuo(), ImeAction.Companion.m6327getDefaulteUduSuo())) {
                        editorInfo.imeOptions |= 1073741824;
                    }
                }
                if (hasFlag(editorInfo.inputType, 1)) {
                    int m6342getCapitalizationIUNYP9k = imeOptions.m6342getCapitalizationIUNYP9k();
                    if (KeyboardCapitalization.m6350equalsimpl0(m6342getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6359getCharactersIUNYP9k())) {
                        editorInfo.inputType |= 4096;
                    } else if (KeyboardCapitalization.m6350equalsimpl0(m6342getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6363getWordsIUNYP9k())) {
                        editorInfo.inputType |= 8192;
                    } else if (KeyboardCapitalization.m6350equalsimpl0(m6342getCapitalizationIUNYP9k, KeyboardCapitalization.Companion.m6361getSentencesIUNYP9k())) {
                        editorInfo.inputType |= 16384;
                    }
                    if (imeOptions.getAutoCorrect()) {
                        editorInfo.inputType |= 32768;
                    }
                }
                editorInfo.initialSelStart = TextRange.m6147getStartimpl(j);
                editorInfo.initialSelEnd = TextRange.m6142getEndimpl(j);
                EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
                if (strArr != null) {
                    EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
                }
                editorInfo.imeOptions |= 33554432;
                if (!StylusHandwriting_androidKt.isStylusHandwritingSupported() && !KeyboardType.m6367equalsimpl0(imeOptions.m6344getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6386getPasswordPjHm6EE()) && !KeyboardType.m6367equalsimpl0(imeOptions.m6344getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6385getNumberPasswordPjHm6EE())) {
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
            if (ImeAction.m6314equalsimpl0(imeOptions.m6343getImeActioneUduSuo(), ImeAction.Companion.m6327getDefaulteUduSuo())) {
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
        }
        editorInfo.initialSelStart = TextRange.m6147getStartimpl(j);
        editorInfo.initialSelEnd = TextRange.m6142getEndimpl(j);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
        if (strArr != null) {
        }
        editorInfo.imeOptions |= 33554432;
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
        }
        EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
    }
}
