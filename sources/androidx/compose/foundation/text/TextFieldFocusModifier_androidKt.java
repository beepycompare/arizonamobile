package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.core.view.InputDeviceCompat;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
/* compiled from: TextFieldFocusModifier.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"interceptDPadAndMoveFocus", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "isKeyCode", "", "Landroidx/compose/ui/input/key/KeyEvent;", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldFocusModifier_androidKt {
    public static final Modifier interceptDPadAndMoveFocus(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final FocusManager focusManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1161invokeZmokQxo(keyEvent.m5158unboximpl());
            }

            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m1161invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean m1160isKeyCodeYhN2O0w;
                boolean m1160isKeyCodeYhN2O0w2;
                boolean m1160isKeyCodeYhN2O0w3;
                boolean m1160isKeyCodeYhN2O0w4;
                boolean m1160isKeyCodeYhN2O0w5;
                InputDevice device = keyEvent.getDevice();
                boolean z = false;
                if (device != null && device.supportsSource(InputDeviceCompat.SOURCE_DPAD) && !device.isVirtual() && KeyEventType.m5162equalsimpl0(KeyEvent_androidKt.m5170getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5166getKeyDownCS__XNY()) && keyEvent.getSource() != 257) {
                    m1160isKeyCodeYhN2O0w = TextFieldFocusModifier_androidKt.m1160isKeyCodeYhN2O0w(keyEvent, 19);
                    if (m1160isKeyCodeYhN2O0w) {
                        z = FocusManager.this.mo3734moveFocus3ESFkO8(FocusDirection.Companion.m3732getUpdhqQ8s());
                    } else {
                        m1160isKeyCodeYhN2O0w2 = TextFieldFocusModifier_androidKt.m1160isKeyCodeYhN2O0w(keyEvent, 20);
                        if (m1160isKeyCodeYhN2O0w2) {
                            z = FocusManager.this.mo3734moveFocus3ESFkO8(FocusDirection.Companion.m3725getDowndhqQ8s());
                        } else {
                            m1160isKeyCodeYhN2O0w3 = TextFieldFocusModifier_androidKt.m1160isKeyCodeYhN2O0w(keyEvent, 21);
                            if (m1160isKeyCodeYhN2O0w3) {
                                z = FocusManager.this.mo3734moveFocus3ESFkO8(FocusDirection.Companion.m3728getLeftdhqQ8s());
                            } else {
                                m1160isKeyCodeYhN2O0w4 = TextFieldFocusModifier_androidKt.m1160isKeyCodeYhN2O0w(keyEvent, 22);
                                if (m1160isKeyCodeYhN2O0w4) {
                                    z = FocusManager.this.mo3734moveFocus3ESFkO8(FocusDirection.Companion.m3731getRightdhqQ8s());
                                } else {
                                    m1160isKeyCodeYhN2O0w5 = TextFieldFocusModifier_androidKt.m1160isKeyCodeYhN2O0w(keyEvent, 23);
                                    if (m1160isKeyCodeYhN2O0w5) {
                                        SoftwareKeyboardController keyboardController = legacyTextFieldState.getKeyboardController();
                                        if (keyboardController != null) {
                                            keyboardController.show();
                                        }
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isKeyCode-YhN2O0w  reason: not valid java name */
    public static final boolean m1160isKeyCodeYhN2O0w(android.view.KeyEvent keyEvent, int i) {
        return Key_androidKt.m5176getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m5169getKeyZmokQxo(keyEvent)) == i;
    }
}
