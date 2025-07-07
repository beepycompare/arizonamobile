package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.KeyEvent;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* compiled from: AndroidTextInputSession.android.kt */
@Metadata(d1 = {"\u0000k\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\"\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\bH\u0096\u0001J\u001b\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020 H\u0016J\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"androidx/compose/foundation/text/input/internal/AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "Landroidx/compose/foundation/text/input/internal/ImeEditCommandScope;", "text", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "beginBatchEdit", "", "edit", "", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Lkotlin/ExtensionFunctionType;", "endBatchEdit", "mapFromTransformed", "Landroidx/compose/ui/text/TextRange;", "range", "mapFromTransformed-GEjPoXI", "(J)J", "mapToTransformed", "mapToTransformed-GEjPoXI", "onCommitContent", "transferableContent", "Landroidx/compose/foundation/content/TransferableContent;", "onImeAction", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction-KlQnJC8", "(I)V", "performHandwritingGesture", "", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "keyEvent", "Landroid/view/KeyEvent;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1 implements TextInputSession, ImeEditCommandScope {
    private final /* synthetic */ DefaultImeEditCommandScope $$delegate_0;
    final /* synthetic */ ComposeInputMethodManager $composeImm;
    final /* synthetic */ CursorAnchorInfoController $cursorUpdatesController;
    final /* synthetic */ TextLayoutState $layoutState;
    final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
    final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
    final /* synthetic */ TransformedTextFieldState $state;
    final /* synthetic */ Function0<Unit> $updateSelectionState;
    final /* synthetic */ ViewConfiguration $viewConfiguration;

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean beginBatchEdit() {
        return this.$$delegate_0.beginBatchEdit();
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public void edit(Function1<? super TextFieldBuffer, Unit> function1) {
        this.$$delegate_0.edit(function1);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean endBatchEdit() {
        return this.$$delegate_0.endBatchEdit();
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    /* renamed from: mapFromTransformed-GEjPoXI  reason: not valid java name */
    public long mo1233mapFromTransformedGEjPoXI(long j) {
        return this.$$delegate_0.mo1233mapFromTransformedGEjPoXI(j);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    /* renamed from: mapToTransformed-GEjPoXI  reason: not valid java name */
    public long mo1234mapToTransformedGEjPoXI(long j) {
        return this.$$delegate_0.mo1234mapToTransformedGEjPoXI(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AndroidTextInputSession_androidKt$platformSpecificTextInputSession$3$3$textInputSession$1(DefaultImeEditCommandScope defaultImeEditCommandScope, TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, Function1<? super ImeAction, Unit> function1, ReceiveContentConfiguration receiveContentConfiguration, CursorAnchorInfoController cursorAnchorInfoController, TextLayoutState textLayoutState, Function0<Unit> function0, ViewConfiguration viewConfiguration) {
        this.$state = transformedTextFieldState;
        this.$composeImm = composeInputMethodManager;
        this.$onImeAction = function1;
        this.$receiveContentConfiguration = receiveContentConfiguration;
        this.$cursorUpdatesController = cursorAnchorInfoController;
        this.$layoutState = textLayoutState;
        this.$updateSelectionState = function0;
        this.$viewConfiguration = viewConfiguration;
        this.$$delegate_0 = defaultImeEditCommandScope;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public TextFieldCharSequence getText() {
        return this.$state.getVisualText();
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public void sendKeyEvent(KeyEvent keyEvent) {
        this.$composeImm.sendKeyEvent(keyEvent);
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    /* renamed from: onImeAction-KlQnJC8  reason: not valid java name */
    public void mo1235onImeActionKlQnJC8(int i) {
        Function1<ImeAction, Unit> function1 = this.$onImeAction;
        if (function1 != null) {
            function1.invoke(ImeAction.m6311boximpl(i));
        }
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public boolean onCommitContent(TransferableContent transferableContent) {
        ReceiveContentConfiguration receiveContentConfiguration = this.$receiveContentConfiguration;
        if (receiveContentConfiguration != null) {
            return receiveContentConfiguration.onCommitContent(transferableContent);
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public void requestCursorUpdates(int i) {
        this.$cursorUpdatesController.requestUpdates(i);
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public int performHandwritingGesture(HandwritingGesture handwritingGesture) {
        if (Build.VERSION.SDK_INT >= 34) {
            return HandwritingGestureApi34.INSTANCE.performHandwritingGesture$foundation_release(this.$state, handwritingGesture, this.$layoutState, this.$updateSelectionState, this.$viewConfiguration);
        }
        return 2;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextInputSession
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture previewableHandwritingGesture, CancellationSignal cancellationSignal) {
        if (Build.VERSION.SDK_INT >= 34) {
            return HandwritingGestureApi34.INSTANCE.previewHandwritingGesture$foundation_release(this.$state, previewableHandwritingGesture, this.$layoutState, cancellationSignal);
        }
        return false;
    }
}
