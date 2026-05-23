package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
/* compiled from: KeyMapping.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"platformDefaultKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "getPlatformDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyMapping_androidKt {
    private static final KeyMapping platformDefaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMapping_androidKt$platformDefaultKeyMapping$1
        @Override // androidx.compose.foundation.text.KeyMapping
        /* renamed from: map-ZmokQxo */
        public KeyCommand mo1541mapZmokQxo(KeyEvent keyEvent) {
            int m1586getModifiersZmokQxo = KeyModifiersKt.m1586getModifiersZmokQxo(keyEvent);
            KeyCommand keyCommand = null;
            if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1577getAltShiftAuQ4EfA())) {
                long m6517getKeyZmokQxo = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6274getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_LEFT;
                } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6275getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_LINE_RIGHT;
                } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6276getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_HOME;
                } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6271getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.SELECT_END;
                }
            } else if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1575getAltAuQ4EfA())) {
                long m6517getKeyZmokQxo2 = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6274getDirectionLeftEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_LEFT;
                } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6275getDirectionRightEK5gGoQ())) {
                    keyCommand = KeyCommand.LINE_RIGHT;
                } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6276getDirectionUpEK5gGoQ())) {
                    keyCommand = KeyCommand.HOME;
                } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6271getDirectionDownEK5gGoQ())) {
                    keyCommand = KeyCommand.END;
                } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6215getBackspaceEK5gGoQ())) {
                    keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                }
            }
            return keyCommand == null ? KeyMappingKt.getDefaultKeyMapping().mo1541mapZmokQxo(keyEvent) : keyCommand;
        }
    };

    public static final KeyMapping getPlatformDefaultKeyMapping() {
        return platformDefaultKeyMapping;
    }
}
