package androidx.compose.foundation.text.input.internal;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text.KeyCommand;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JX\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J:\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/input/internal/AndroidTextFieldKeyEventHandler;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "()V", "onKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "", "onKeyEvent-CJ9ybgU", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;ZZLkotlin/jvm/functions/Function0;)Z", "onPreKeyEvent", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidTextFieldKeyEventHandler extends TextFieldKeyEventHandler {
    public static final int $stable = 0;

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* renamed from: onPreKeyEvent-MyFupTE  reason: not valid java name */
    public boolean mo1230onPreKeyEventMyFupTE(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        boolean m1309isKeyCodeYhN2O0w;
        boolean m1309isKeyCodeYhN2O0w2;
        boolean m1309isKeyCodeYhN2O0w3;
        boolean m1309isKeyCodeYhN2O0w4;
        boolean m1309isKeyCodeYhN2O0w5;
        if (super.mo1230onPreKeyEventMyFupTE(keyEvent, transformedTextFieldState, textFieldSelectionState, focusManager, softwareKeyboardController)) {
            return true;
        }
        InputDevice device = keyEvent.getDevice();
        if (device == null || !device.supportsSource(InputDeviceCompat.SOURCE_DPAD) || device.isVirtual() || !KeyEventType.m5162equalsimpl0(KeyEvent_androidKt.m5170getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5166getKeyDownCS__XNY()) || keyEvent.getSource() == 257) {
            return false;
        }
        m1309isKeyCodeYhN2O0w = TextFieldKeyEventHandler_androidKt.m1309isKeyCodeYhN2O0w(keyEvent, 19);
        if (m1309isKeyCodeYhN2O0w) {
            return focusManager.mo3734moveFocus3ESFkO8(FocusDirection.Companion.m3732getUpdhqQ8s());
        }
        m1309isKeyCodeYhN2O0w2 = TextFieldKeyEventHandler_androidKt.m1309isKeyCodeYhN2O0w(keyEvent, 20);
        if (m1309isKeyCodeYhN2O0w2) {
            return focusManager.mo3734moveFocus3ESFkO8(FocusDirection.Companion.m3725getDowndhqQ8s());
        }
        m1309isKeyCodeYhN2O0w3 = TextFieldKeyEventHandler_androidKt.m1309isKeyCodeYhN2O0w(keyEvent, 21);
        if (m1309isKeyCodeYhN2O0w3) {
            return focusManager.mo3734moveFocus3ESFkO8(FocusDirection.Companion.m3728getLeftdhqQ8s());
        }
        m1309isKeyCodeYhN2O0w4 = TextFieldKeyEventHandler_androidKt.m1309isKeyCodeYhN2O0w(keyEvent, 22);
        if (m1309isKeyCodeYhN2O0w4) {
            return focusManager.mo3734moveFocus3ESFkO8(FocusDirection.Companion.m3731getRightdhqQ8s());
        }
        m1309isKeyCodeYhN2O0w5 = TextFieldKeyEventHandler_androidKt.m1309isKeyCodeYhN2O0w(keyEvent, 23);
        if (m1309isKeyCodeYhN2O0w5) {
            softwareKeyboardController.show();
            return true;
        }
        return false;
    }

    @Override // androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler
    /* renamed from: onKeyEvent-CJ9ybgU  reason: not valid java name */
    public boolean mo1229onKeyEventCJ9ybgU(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, Function1<? super KeyCommand, ? extends Unit> function1, boolean z, boolean z2, Function0<Unit> function0) {
        if (KeyEventType.m5162equalsimpl0(KeyEvent_androidKt.m5170getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5166getKeyDownCS__XNY()) && keyEvent.isFromSource(257) && !TextFieldKeyEventHandler_androidKt.m1308isFromSoftKeyboardZmokQxo(keyEvent)) {
            textFieldSelectionState.setInTouchMode(false);
        }
        return super.mo1229onKeyEventCJ9ybgU(keyEvent, transformedTextFieldState, textLayoutState, textFieldSelectionState, function1, z, z2, function0);
    }
}
