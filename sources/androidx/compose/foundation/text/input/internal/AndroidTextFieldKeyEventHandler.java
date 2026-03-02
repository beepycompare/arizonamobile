package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* compiled from: TextFieldKeyEventHandler.android.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J]\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "<init>", "()V", "onPreKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onKeyEvent", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "onKeyEvent-8zsqlwg", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 8;

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* renamed from: onPreKeyEvent-MyFupTE  reason: not valid java name */
    public boolean mo1363onPreKeyEventMyFupTE(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        boolean m1439isKeyCodeYhN2O0w;
        boolean m1439isKeyCodeYhN2O0w2;
        boolean m1439isKeyCodeYhN2O0w3;
        boolean m1439isKeyCodeYhN2O0w4;
        boolean m1439isKeyCodeYhN2O0w5;
        boolean mo1363onPreKeyEventMyFupTE = super.mo1363onPreKeyEventMyFupTE(keyEvent, transformedTextFieldState, textFieldSelectionState, focusManager, softwareKeyboardController);
        if (ComposeFoundationFlags.isTextFieldDpadNavigationEnabled) {
            return mo1363onPreKeyEventMyFupTE;
        }
        if (mo1363onPreKeyEventMyFupTE) {
            return true;
        }
        InputDevice device = keyEvent.getDevice();
        if (device == null || !device.supportsSource(InputDeviceCompat.SOURCE_DPAD) || device.isVirtual() || !KeyEventType.m5921equalsimpl0(KeyEvent_androidKt.m5929getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5925getKeyDownCS__XNY()) || keyEvent.getSource() == 257) {
            return false;
        }
        m1439isKeyCodeYhN2O0w = TextFieldKeyEventHandler_androidKt.m1439isKeyCodeYhN2O0w(keyEvent, 19);
        if (m1439isKeyCodeYhN2O0w) {
            return focusManager.mo4416moveFocus3ESFkO8(FocusDirection.Companion.m4413getUpdhqQ8s());
        }
        m1439isKeyCodeYhN2O0w2 = TextFieldKeyEventHandler_androidKt.m1439isKeyCodeYhN2O0w(keyEvent, 20);
        if (m1439isKeyCodeYhN2O0w2) {
            return focusManager.mo4416moveFocus3ESFkO8(FocusDirection.Companion.m4406getDowndhqQ8s());
        }
        m1439isKeyCodeYhN2O0w3 = TextFieldKeyEventHandler_androidKt.m1439isKeyCodeYhN2O0w(keyEvent, 21);
        if (m1439isKeyCodeYhN2O0w3) {
            return focusManager.mo4416moveFocus3ESFkO8(FocusDirection.Companion.m4409getLeftdhqQ8s());
        }
        m1439isKeyCodeYhN2O0w4 = TextFieldKeyEventHandler_androidKt.m1439isKeyCodeYhN2O0w(keyEvent, 22);
        if (m1439isKeyCodeYhN2O0w4) {
            return focusManager.mo4416moveFocus3ESFkO8(FocusDirection.Companion.m4412getRightdhqQ8s());
        }
        m1439isKeyCodeYhN2O0w5 = TextFieldKeyEventHandler_androidKt.m1439isKeyCodeYhN2O0w(keyEvent, 23);
        if (m1439isKeyCodeYhN2O0w5) {
            softwareKeyboardController.show();
            return true;
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* renamed from: onKeyEvent-8zsqlwg  reason: not valid java name */
    public boolean mo1362onKeyEvent8zsqlwg(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, Function1<? super KeyCommand, ? extends Unit> function1, SoftwareKeyboardController softwareKeyboardController, boolean z, boolean z2, Function0<Boolean> function0) {
        if (KeyEventType.m5921equalsimpl0(KeyEvent_androidKt.m5929getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5925getKeyDownCS__XNY()) && keyEvent.isFromSource(257) && (!TextFieldKeyEventHandler_androidKt.m1438isFromSoftKeyboardZmokQxo(keyEvent) || !TextFieldKeyInput_androidKt.m1279isTypedEventZmokQxo(keyEvent))) {
            textFieldSelectionState.setInTouchMode(false);
        }
        return super.mo1362onKeyEvent8zsqlwg(keyEvent, transformedTextFieldState, textLayoutState, textFieldSelectionState, function1, softwareKeyboardController, z, z2, function0);
    }
}
