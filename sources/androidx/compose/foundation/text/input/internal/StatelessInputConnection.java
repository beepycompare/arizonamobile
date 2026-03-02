package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.core.app.NotificationCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StatelessInputConnection.android.kt */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0015\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\u001a\u0010 \u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\tH\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0016J\u001a\u0010&\u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\tH\u0016J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0016J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\tH\u0016J\u0018\u0010+\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0016J\u0018\u00103\u001a\u00020!2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0016J\u0012\u00104\u001a\u0004\u0018\u00010!2\u0006\u00102\u001a\u00020\tH\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\tH\u0016J$\u00107\u001a\u00020\u00122\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010>\u001a\u00020\u001b2\u0006\u00108\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u00102\u001a\u00020\tH\u0016J\u0010\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0010\u0010H\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020\tH\u0016J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\tH\u0002J\u0010\u0010L\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020\tH\u0016J\u0012\u0010N\u001a\u00020\u001b2\b\u0010\n\u001a\u0004\u0018\u00010OH\u0016J\u0012\u0010P\u001a\u00020\u001b2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\n\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0010\u0010U\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020\tH\u0016J\u0010\u0010W\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\u001bH\u0016J\u001c\u0010Y\u001a\u00020\u001b2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\"\u0010^\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020`2\u0006\u00102\u001a\u00020\t2\b\u0010a\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010b\u001a\u00020\u00122\u0006\u0010c\u001a\u00020[H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR%\u0010\u000e\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0002\b\u00130\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019¨\u0006d"}, d2 = {"Landroidx/compose/foundation/text/input/internal/StatelessInputConnection;", "Landroid/view/inputmethod/InputConnection;", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TextInputSession;Landroid/view/inputmethod/EditorInfo;)V", "batchDepth", "", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "editCommands", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "", "Lkotlin/ExtensionFunctionType;", "terminalInputConnection", "androidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1", "Landroidx/compose/foundation/text/input/internal/StatelessInputConnection$terminalInputConnection$1;", "commitContentDelegateInputConnection", "getCommitContentDelegateInputConnection$annotations", "()V", "beginBatchEdit", "", "beginBatchEditInternal", "endBatchEdit", "endBatchEditInternal", "closeConnection", "commitText", "", "newCursorPosition", "setComposingRegion", TtmlNode.START, TtmlNode.END, "setComposingText", "deleteSurroundingTextInCodePoints", "beforeLength", "afterLength", "deleteSurroundingText", "setSelection", "finishComposingText", "sendKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "getTextBeforeCursor", "maxChars", DownloaderServiceMarshaller.PARAMS_FLAGS, "getTextAfterCursor", "getSelectedText", "requestCursorUpdates", "cursorUpdateMode", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getCursorCapsMode", "reqModes", "performContextMenuAction", "id", "sendSynthesizedKeyEvent", "code", "performEditorAction", "editorAction", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "getHandler", "Landroid/os/Handler;", "clearMetaKeyStates", "states", "reportFullscreenMode", "enabled", "performPrivateCommand", "action", "", "data", "Landroid/os/Bundle;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "opts", "logDebug", "message", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StatelessInputConnection implements InputConnection {
    public static final int $stable = 8;
    private int batchDepth;
    private final InputConnection commitContentDelegateInputConnection;
    private final MutableVector<Function1<ImeEditCommandScope, Unit>> editCommands = new MutableVector<>(new Function1[16], 0);
    private final TextInputSession session;
    private final StatelessInputConnection$terminalInputConnection$1 terminalInputConnection;

    private static /* synthetic */ void getCommitContentDelegateInputConnection$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logDebug(String str) {
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1] */
    public StatelessInputConnection(TextInputSession textInputSession, EditorInfo editorInfo) {
        this.session = textInputSession;
        ?? r3 = new InputConnectionWrapper(this) { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection$terminalInputConnection$1
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
                return false;
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean performPrivateCommand(String str, Bundle bundle) {
                return true;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(this, false);
            }
        };
        this.terminalInputConnection = r3;
        this.commitContentDelegateInputConnection = InputConnectionCompat.createWrapper((InputConnection) r3, editorInfo, new InputConnectionCompat.OnCommitContentListener() { // from class: androidx.compose.foundation.text.input.internal.StatelessInputConnection$commitContentDelegateInputConnection$1
            @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
            public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
                TextInputSession textInputSession2;
                if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                    try {
                        inputContentInfoCompat.requestPermission();
                        Object unwrap = inputContentInfoCompat.unwrap();
                        Intrinsics.checkNotNull(unwrap, "null cannot be cast to non-null type android.os.Parcelable");
                        Parcelable parcelable = (Parcelable) unwrap;
                        bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                        bundle.putParcelable("EXTRA_INPUT_CONTENT_INFO", parcelable);
                    } catch (Exception e) {
                        StatelessInputConnection.this.logDebug("Can't insert content from IME; requestPermission() failed, " + e);
                        return false;
                    }
                }
                textInputSession2 = StatelessInputConnection.this.session;
                return textInputSession2.onCommitContent(StatelessInputConnection_androidKt.toTransferableContent(inputContentInfoCompat, bundle));
            }
        });
    }

    private final TextFieldCharSequence getText() {
        return this.session.getText();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        logDebug("beginBatchEdit()");
        return beginBatchEditInternal();
    }

    private final boolean beginBatchEditInternal() {
        return this.session.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        logDebug("endBatchEdit()");
        return endBatchEditInternal();
    }

    private final boolean endBatchEditInternal() {
        return this.session.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        logDebug("closeConnection()");
        this.editCommands.clear();
        this.batchDepth = 0;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        logDebug("commitText(\"" + ((Object) charSequence) + "\", " + i + ')');
        if (charSequence == null) {
            return true;
        }
        ImeEditCommand_androidKt.commitText(this.session, charSequence.toString(), i);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        logDebug("setComposingRegion(" + i + ", " + i2 + ')');
        ImeEditCommand_androidKt.setComposingRegion(this.session, i, i2);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        logDebug("setComposingText(\"" + ((Object) charSequence) + "\", " + i + ')');
        if (charSequence == null) {
            return true;
        }
        TextInputSession textInputSession = this.session;
        String obj = charSequence.toString();
        Spanned spanned = charSequence instanceof Spanned ? (Spanned) charSequence : null;
        ImeEditCommand_androidKt.setComposingText(textInputSession, obj, i, spanned != null ? StatelessInputConnection_androidKt.toAnnotationList(spanned) : null);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        logDebug("deleteSurroundingTextInCodePoints(" + i + ", " + i2 + ')');
        ImeEditCommand_androidKt.deleteSurroundingTextInCodePoints(this.session, i, i2);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        logDebug("deleteSurroundingText(" + i + ", " + i2 + ')');
        ImeEditCommand_androidKt.deleteSurroundingText(this.session, i, i2);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        logDebug("setSelection(" + i + ", " + i2 + ')');
        ImeEditCommand_androidKt.setSelection(this.session, i, i2);
        this.session.updateTouchMode(false);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        logDebug("finishComposingText()");
        ImeEditCommand_androidKt.finishComposingText(this.session);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        logDebug("sendKeyEvent(" + keyEvent + ')');
        this.session.sendKeyEvent(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i, int i2) {
        String obj = TextFieldCharSequenceKt.getTextBeforeSelection(getText(), i).toString();
        logDebug("getTextBeforeCursor(" + i + ", " + i2 + "): " + obj);
        return obj;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i, int i2) {
        String obj = TextFieldCharSequenceKt.getTextAfterSelection(getText(), i).toString();
        logDebug("getTextAfterCursor(" + i + ", " + i2 + "): " + obj);
        return obj;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i) {
        String obj = TextRange.m6997getCollapsedimpl(getText().m1336getSelectiond9O1mEE()) ? null : TextFieldCharSequenceKt.getSelectedText(getText()).toString();
        logDebug("getSelectedText(" + i + "): " + ((Object) obj));
        return obj;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        logDebug("requestCursorUpdates(" + i + ')');
        this.session.requestCursorUpdates(i);
        return true;
    }

    public void performHandwritingGesture(HandwritingGesture handwritingGesture, Executor executor, IntConsumer intConsumer) {
        logDebug("performHandwritingGesture(" + handwritingGesture + ", " + executor + ", " + intConsumer + ')');
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        Api34PerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.session, handwritingGesture, executor, intConsumer);
    }

    public boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        logDebug("previewHandwritingGesture(" + previewableHandwritingGesture + ", " + cancellationSignal + ')');
        if (Build.VERSION.SDK_INT < 34) {
            return false;
        }
        return Api34PerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.session, previewableHandwritingGesture, cancellationSignal);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        ExtractedText extractedText;
        logDebug("getExtractedText(" + extractedTextRequest + ", " + i + ')');
        extractedText = StatelessInputConnection_androidKt.toExtractedText(getText());
        return extractedText;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i) {
        logDebug("getCursorCapsMode(" + i + ')');
        return TextUtils.getCapsMode(getText(), TextRange.m7001getMinimpl(getText().m1336getSelectiond9O1mEE()), i);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        logDebug("performContextMenuAction(" + i + ')');
        switch (i) {
            case 16908319:
                ImeEditCommand_androidKt.setSelection(this.session, 0, getText().length());
                break;
            case 16908320:
                sendSynthesizedKeyEvent(277);
                break;
            case 16908321:
                sendSynthesizedKeyEvent(278);
                break;
            case 16908322:
                sendSynthesizedKeyEvent(279);
                break;
        }
        return false;
    }

    private final void sendSynthesizedKeyEvent(int i) {
        sendKeyEvent(new KeyEvent(0, i));
        sendKeyEvent(new KeyEvent(1, i));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        int m7184getDefaulteUduSuo;
        logDebug("performEditorAction(" + i + ')');
        if (i == 0) {
            m7184getDefaulteUduSuo = ImeAction.Companion.m7184getDefaulteUduSuo();
        } else {
            switch (i) {
                case 2:
                    m7184getDefaulteUduSuo = ImeAction.Companion.m7186getGoeUduSuo();
                    break;
                case 3:
                    m7184getDefaulteUduSuo = ImeAction.Companion.m7190getSearcheUduSuo();
                    break;
                case 4:
                    m7184getDefaulteUduSuo = ImeAction.Companion.m7191getSendeUduSuo();
                    break;
                case 5:
                    m7184getDefaulteUduSuo = ImeAction.Companion.m7187getNexteUduSuo();
                    break;
                case 6:
                    m7184getDefaulteUduSuo = ImeAction.Companion.m7185getDoneeUduSuo();
                    break;
                case 7:
                    m7184getDefaulteUduSuo = ImeAction.Companion.m7189getPreviouseUduSuo();
                    break;
                default:
                    logDebug("IME sent an unrecognized editor action: " + i);
                    m7184getDefaulteUduSuo = ImeAction.Companion.m7184getDefaulteUduSuo();
                    break;
            }
        }
        this.session.mo1367onImeActionKlQnJC8(m7184getDefaulteUduSuo);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        logDebug("commitCompletion(" + ((Object) (completionInfo != null ? completionInfo.getText() : null)) + ')');
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        logDebug("getHandler()");
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        logDebug("clearMetaKeyStates(" + i + ')');
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z) {
        logDebug("reportFullscreenMode(" + z + ')');
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        logDebug("performPrivateCommand(" + str + ", " + bundle + ')');
        return this.commitContentDelegateInputConnection.performPrivateCommand(str, bundle);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        logDebug("commitContent(" + inputContentInfo + ", " + i + ", " + bundle + ')');
        if (Build.VERSION.SDK_INT >= 25) {
            return Api25CommitContentImpl.INSTANCE.commitContent(this.commitContentDelegateInputConnection, inputContentInfo, i, bundle);
        }
        return false;
    }
}
