package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
/* compiled from: KeyMapping.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0000\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"commonKeyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "shortcutModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "defaultKeyMapping", "getDefaultKeyMapping", "()Landroidx/compose/foundation/text/KeyMapping;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyMappingKt {
    private static final KeyMapping defaultKeyMapping;

    public static final KeyMapping commonKeyMapping(final Function1<? super KeyEvent, Boolean> function1) {
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1373mapZmokQxo(android.view.KeyEvent keyEvent) {
                if (function1.invoke(KeyEvent.m6570boximpl(keyEvent)).booleanValue() && KeyEvent_androidKt.m6593isShiftPressedZmokQxo(keyEvent)) {
                    if (Key.m6279equalsimpl0(KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent), Key.Companion.m6565getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                } else if (function1.invoke(KeyEvent.m6570boximpl(keyEvent)).booleanValue()) {
                    long m6587getKeyZmokQxo = KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent);
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6333getCEK5gGoQ()) || Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6397getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6554getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6562getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6283getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6563getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6565getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                } else if (KeyEvent_androidKt.m6591isCtrlPressedZmokQxo(keyEvent)) {
                    return null;
                } else {
                    if (KeyEvent_androidKt.m6593isShiftPressedZmokQxo(keyEvent)) {
                        long m6587getKeyZmokQxo2 = KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent);
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6355getDirectionLeftEK5gGoQ())) {
                            return KeyCommand.SELECT_LEFT_CHAR;
                        }
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6356getDirectionRightEK5gGoQ())) {
                            return KeyCommand.SELECT_RIGHT_CHAR;
                        }
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6357getDirectionUpEK5gGoQ())) {
                            return KeyCommand.SELECT_UP;
                        }
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6352getDirectionDownEK5gGoQ())) {
                            return KeyCommand.SELECT_DOWN;
                        }
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6468getPageUpEK5gGoQ())) {
                            return KeyCommand.SELECT_PAGE_UP;
                        }
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6467getPageDownEK5gGoQ())) {
                            return KeyCommand.SELECT_PAGE_DOWN;
                        }
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6431getMoveHomeEK5gGoQ())) {
                            return KeyCommand.SELECT_LINE_START;
                        }
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6430getMoveEndEK5gGoQ())) {
                            return KeyCommand.SELECT_LINE_END;
                        }
                        if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6397getInsertEK5gGoQ())) {
                            return KeyCommand.PASTE;
                        }
                        return null;
                    }
                    long m6587getKeyZmokQxo3 = KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent);
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6355getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.LEFT_CHAR;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6356getDirectionRightEK5gGoQ())) {
                        return KeyCommand.RIGHT_CHAR;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6357getDirectionUpEK5gGoQ())) {
                        return KeyCommand.UP;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6352getDirectionDownEK5gGoQ())) {
                        return KeyCommand.DOWN;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6351getDirectionCenterEK5gGoQ())) {
                        return KeyCommand.CENTER;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6468getPageUpEK5gGoQ())) {
                        return KeyCommand.PAGE_UP;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6467getPageDownEK5gGoQ())) {
                        return KeyCommand.PAGE_DOWN;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6431getMoveHomeEK5gGoQ())) {
                        return KeyCommand.LINE_START;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6430getMoveEndEK5gGoQ())) {
                        return KeyCommand.LINE_END;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6365getEnterEK5gGoQ()) || Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6457getNumPadEnterEK5gGoQ())) {
                        return KeyCommand.NEW_LINE;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6296getBackspaceEK5gGoQ())) {
                        return KeyCommand.DELETE_PREV_CHAR;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6350getDeleteEK5gGoQ())) {
                        return KeyCommand.DELETE_NEXT_CHAR;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6470getPasteEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6348getCutEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6345getCopyEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6515getTabEK5gGoQ())) {
                        return KeyCommand.TAB;
                    }
                    return null;
                }
            }
        };
    }

    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }

    static {
        final KeyMapping commonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m6591isCtrlPressedZmokQxo(((KeyEvent) obj).m6576unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1373mapZmokQxo(android.view.KeyEvent keyEvent) {
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m6593isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m6591isCtrlPressedZmokQxo(keyEvent)) {
                    long m6587getKeyZmokQxo = KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent);
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6355getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6356getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6357getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo, Key.Companion.m6352getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m6591isCtrlPressedZmokQxo(keyEvent)) {
                    long m6587getKeyZmokQxo2 = KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent);
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6355getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6356getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6357getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6352getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6390getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6350getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6296getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo2, Key.Companion.m6295getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m6593isShiftPressedZmokQxo(keyEvent)) {
                    long m6587getKeyZmokQxo3 = KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent);
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6431getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_START;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo3, Key.Companion.m6430getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LINE_END;
                    }
                } else if (KeyEvent_androidKt.m6590isAltPressedZmokQxo(keyEvent)) {
                    long m6587getKeyZmokQxo4 = KeyEvent_androidKt.m6587getKeyZmokQxo(keyEvent);
                    if (Key.m6279equalsimpl0(m6587getKeyZmokQxo4, Key.Companion.m6296getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m6279equalsimpl0(m6587getKeyZmokQxo4, Key.Companion.m6350getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? KeyMapping.this.mo1373mapZmokQxo(keyEvent) : keyCommand;
            }
        };
    }
}
