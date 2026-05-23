package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
/* compiled from: KeyMapping.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"commonKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "systemShortcutModifiers", "Landroidx/compose/foundation/text/KeyModifiers;", "commonKeyMapping-VSD1kLU", "(I)Landroidx/compose/foundation/text/KeyMapping;", "defaultKeyMapping", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    /* renamed from: commonKeyMapping-VSD1kLU  reason: not valid java name */
    public static final KeyMapping m1542commonKeyMappingVSD1kLU(final int i) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1541mapZmokQxo(KeyEvent keyEvent) {
                int m1586getModifiersZmokQxo = KeyModifiersKt.m1586getModifiersZmokQxo(keyEvent);
                if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.m1561plus1uj4btU(i, KeyModifiers.Companion.m1584getShiftAuQ4EfA()))) {
                    if (Key.m6197equalsimpl0(KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent), Key.Companion.m6495getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                } else if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, i)) {
                    long m6517getKeyZmokQxo = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6252getCEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6316getInsertEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6383getNumPadInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6484getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6492getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6202getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6493getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6495getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                } else if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1584getShiftAuQ4EfA())) {
                    long m6517getKeyZmokQxo2 = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6274getDirectionLeftEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6376getNumPadDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6275getDirectionRightEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6377getNumPadDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6276getDirectionUpEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6378getNumPadDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6271getDirectionDownEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6375getNumPadDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6397getPageUpEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6389getNumPadPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6396getPageDownEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6388getNumPadPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6350getMoveHomeEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6386getNumPadMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6349getMoveEndEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6385getNumPadMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6316getInsertEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6383getNumPadInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                } else if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1583getNoneAuQ4EfA())) {
                    long m6517getKeyZmokQxo3 = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6274getDirectionLeftEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6376getNumPadDirectionLeftEK5gGoQ())) {
                        return KeyCommand.LEFT_CHAR;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6275getDirectionRightEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6377getNumPadDirectionRightEK5gGoQ())) {
                        return KeyCommand.RIGHT_CHAR;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6276getDirectionUpEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6378getNumPadDirectionUpEK5gGoQ())) {
                        return KeyCommand.UP;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6271getDirectionDownEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6375getNumPadDirectionDownEK5gGoQ())) {
                        return KeyCommand.DOWN;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6270getDirectionCenterEK5gGoQ())) {
                        return KeyCommand.CENTER;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6397getPageUpEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6389getNumPadPageUpEK5gGoQ())) {
                        return KeyCommand.PAGE_UP;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6396getPageDownEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6388getNumPadPageDownEK5gGoQ())) {
                        return KeyCommand.PAGE_DOWN;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6350getMoveHomeEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6386getNumPadMoveHomeEK5gGoQ())) {
                        return KeyCommand.LINE_START;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6349getMoveEndEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6385getNumPadMoveEndEK5gGoQ())) {
                        return KeyCommand.LINE_END;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6284getEnterEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6381getNumPadEnterEK5gGoQ())) {
                        return KeyCommand.NEW_LINE;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6215getBackspaceEK5gGoQ())) {
                        return KeyCommand.DELETE_PREV_CHAR;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6269getDeleteEK5gGoQ())) {
                        return KeyCommand.DELETE_NEXT_CHAR;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6399getPasteEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6267getCutEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6264getCopyEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6445getTabEK5gGoQ())) {
                        return KeyCommand.TAB;
                    }
                    return null;
                } else {
                    return null;
                }
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping m1542commonKeyMappingVSD1kLU = m1542commonKeyMappingVSD1kLU(KeyModifiers.Companion.m1578getCtrlAuQ4EfA());
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1541mapZmokQxo(KeyEvent keyEvent) {
                KeyCommand keyCommand;
                int m1586getModifiersZmokQxo = KeyModifiersKt.m1586getModifiersZmokQxo(keyEvent);
                long m6517getKeyZmokQxo = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                KeyCommand keyCommand2 = null;
                if (Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6215getBackspaceEK5gGoQ())) {
                    if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1583getNoneAuQ4EfA()) || KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1584getShiftAuQ4EfA()) || KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1585getShiftMetaAuQ4EfA())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else {
                        if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1578getCtrlAuQ4EfA()) || KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1581getCtrlShiftAuQ4EfA())) {
                            keyCommand = KeyCommand.DELETE_PREV_WORD;
                        }
                        keyCommand = null;
                    }
                } else {
                    if ((Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6284getEnterEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo, Key.Companion.m6381getNumPadEnterEK5gGoQ())) && (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1583getNoneAuQ4EfA()) || KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1584getShiftAuQ4EfA()) || KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1578getCtrlAuQ4EfA()) || KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo, KeyModifiers.Companion.m1581getCtrlShiftAuQ4EfA()))) {
                        keyCommand = KeyCommand.NEW_LINE;
                    }
                    keyCommand = null;
                }
                if (keyCommand != null) {
                    return keyCommand;
                }
                int m1586getModifiersZmokQxo2 = KeyModifiersKt.m1586getModifiersZmokQxo(keyEvent);
                if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo2, KeyModifiers.Companion.m1581getCtrlShiftAuQ4EfA())) {
                    long m6517getKeyZmokQxo2 = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6274getDirectionLeftEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6376getNumPadDirectionLeftEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6275getDirectionRightEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6377getNumPadDirectionRightEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6276getDirectionUpEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6378getNumPadDirectionUpEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6271getDirectionDownEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo2, Key.Companion.m6375getNumPadDirectionDownEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo2, KeyModifiers.Companion.m1578getCtrlAuQ4EfA())) {
                    long m6517getKeyZmokQxo3 = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6274getDirectionLeftEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6376getNumPadDirectionLeftEK5gGoQ())) {
                        keyCommand2 = KeyCommand.LEFT_WORD;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6275getDirectionRightEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6377getNumPadDirectionRightEK5gGoQ())) {
                        keyCommand2 = KeyCommand.RIGHT_WORD;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6276getDirectionUpEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6378getNumPadDirectionUpEK5gGoQ())) {
                        keyCommand2 = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6271getDirectionDownEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6375getNumPadDirectionDownEK5gGoQ())) {
                        keyCommand2 = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6309getHEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6269getDeleteEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo3, Key.Companion.m6214getBackslashEK5gGoQ())) {
                        keyCommand2 = KeyCommand.DESELECT;
                    }
                } else if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo2, KeyModifiers.Companion.m1584getShiftAuQ4EfA())) {
                    long m6517getKeyZmokQxo4 = KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent);
                    if (Key.m6197equalsimpl0(m6517getKeyZmokQxo4, Key.Companion.m6350getMoveHomeEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo4, Key.Companion.m6386getNumPadMoveHomeEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LINE_START;
                    } else if (Key.m6197equalsimpl0(m6517getKeyZmokQxo4, Key.Companion.m6349getMoveEndEK5gGoQ()) || Key.m6197equalsimpl0(m6517getKeyZmokQxo4, Key.Companion.m6385getNumPadMoveEndEK5gGoQ())) {
                        keyCommand2 = KeyCommand.SELECT_LINE_END;
                    }
                } else if (KeyModifiers.m1548equalsimpl0(m1586getModifiersZmokQxo2, KeyModifiers.Companion.m1575getAltAuQ4EfA()) && Key.m6197equalsimpl0(KeyEvent_androidKt.m6517getKeyZmokQxo(keyEvent), Key.Companion.m6269getDeleteEK5gGoQ())) {
                    keyCommand2 = KeyCommand.DELETE_TO_LINE_END;
                }
                return keyCommand2 == null ? KeyMapping.this.mo1541mapZmokQxo(keyEvent) : keyCommand2;
            }
        };
    }
}
