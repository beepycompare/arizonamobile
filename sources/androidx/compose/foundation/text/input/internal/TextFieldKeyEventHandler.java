package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.DeadKeyCombiner;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyEventHelpers_androidKt;
import androidx.compose.foundation.text.KeyMapping;
import androidx.compose.foundation.text.KeyMapping_androidKt;
import androidx.compose.foundation.text.StringHelpers_jvmKt;
import androidx.compose.foundation.text.TextFieldKeyInput_androidKt;
import androidx.compose.foundation.text.input.internal.selection.SelectionMovementDeletionContext;
import androidx.compose.foundation.text.input.internal.selection.TextFieldPreparedSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.TextRange;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* compiled from: TextFieldKeyEventHandler.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J]\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0016¢\u0006\u0004\b#\u0010$JU\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\"H\u0002¢\u0006\u0004\b&\u0010'J\f\u0010(\u001a\u00020)*\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "", "<init>", "()V", "preparedSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "deadKeyCombiner", "Landroidx/compose/foundation/text/DeadKeyCombiner;", "keyMapping", "Landroidx/compose/foundation/text/KeyMapping;", "currentlyConsumedDownKeys", "Landroidx/collection/MutableLongSet;", "onPreKeyEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "onPreKeyEvent-MyFupTE", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/focus/FocusManager;Landroidx/compose/ui/platform/SoftwareKeyboardController;)Z", "onKeyEvent", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "editable", "singleLine", "onSubmit", "Lkotlin/Function0;", "onKeyEvent-8zsqlwg", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "processKeyDownEvent", "processKeyDownEvent-q0GpTC0", "(Landroid/view/KeyEvent;Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/platform/SoftwareKeyboardController;ZZLkotlin/jvm/functions/Function0;)Z", "getVisibleTextLayoutHeight", "", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldKeyEventHandler {
    public static final int $stable = 8;
    private MutableLongSet currentlyConsumedDownKeys;
    private final TextFieldPreparedSelectionState preparedSelectionState = new TextFieldPreparedSelectionState();
    private final DeadKeyCombiner deadKeyCombiner = new DeadKeyCombiner();
    private final KeyMapping keyMapping = KeyMapping_androidKt.getPlatformDefaultKeyMapping();

    /* compiled from: TextFieldKeyEventHandler.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KeyCommand.values().length];
            try {
                iArr[KeyCommand.COPY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KeyCommand.PASTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KeyCommand.CUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[KeyCommand.LEFT_CHAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[KeyCommand.RIGHT_CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[KeyCommand.LEFT_WORD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[KeyCommand.RIGHT_WORD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[KeyCommand.PREV_PARAGRAPH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[KeyCommand.NEXT_PARAGRAPH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[KeyCommand.UP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[KeyCommand.DOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[KeyCommand.PAGE_UP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[KeyCommand.PAGE_DOWN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[KeyCommand.LINE_START.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[KeyCommand.LINE_END.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[KeyCommand.LINE_LEFT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[KeyCommand.LINE_RIGHT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[KeyCommand.HOME.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[KeyCommand.END.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_CHAR.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_CHAR.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[KeyCommand.DELETE_PREV_WORD.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[KeyCommand.DELETE_NEXT_WORD.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[KeyCommand.DELETE_FROM_LINE_START.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[KeyCommand.DELETE_TO_LINE_END.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[KeyCommand.NEW_LINE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[KeyCommand.TAB.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[KeyCommand.SELECT_ALL.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_CHAR.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_CHAR.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[KeyCommand.SELECT_LEFT_WORD.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[KeyCommand.SELECT_RIGHT_WORD.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[KeyCommand.SELECT_PREV_PARAGRAPH.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[KeyCommand.SELECT_NEXT_PARAGRAPH.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_START.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_END.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_LEFT.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[KeyCommand.SELECT_LINE_RIGHT.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[KeyCommand.SELECT_UP.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[KeyCommand.SELECT_DOWN.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_UP.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[KeyCommand.SELECT_PAGE_DOWN.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[KeyCommand.SELECT_HOME.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[KeyCommand.SELECT_END.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[KeyCommand.DESELECT.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[KeyCommand.UNDO.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[KeyCommand.REDO.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[KeyCommand.CHARACTER_PALETTE.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[KeyCommand.CENTER.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: onPreKeyEvent-MyFupTE */
    public boolean mo1363onPreKeyEventMyFupTE(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, FocusManager focusManager, SoftwareKeyboardController softwareKeyboardController) {
        if (TextRange.m6997getCollapsedimpl(transformedTextFieldState.getVisualText().m1336getSelectiond9O1mEE()) || !KeyEventHelpers_androidKt.m1199cancelsTextSelectionZmokQxo(keyEvent)) {
            return false;
        }
        textFieldSelectionState.deselect();
        return true;
    }

    /* renamed from: onKeyEvent-8zsqlwg */
    public boolean mo1362onKeyEvent8zsqlwg(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, Function1<? super KeyCommand, ? extends Unit> function1, SoftwareKeyboardController softwareKeyboardController, boolean z, boolean z2, Function0<Boolean> function0) {
        long m5928getKeyZmokQxo = KeyEvent_androidKt.m5928getKeyZmokQxo(keyEvent);
        if (KeyEventType.m5921equalsimpl0(KeyEvent_androidKt.m5929getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5926getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet = this.currentlyConsumedDownKeys;
            if (mutableLongSet == null || !mutableLongSet.contains(m5928getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.currentlyConsumedDownKeys;
            if (mutableLongSet2 != null) {
                mutableLongSet2.remove(m5928getKeyZmokQxo);
            }
            return true;
        } else if (!KeyEventType.m5921equalsimpl0(KeyEvent_androidKt.m5929getTypeZmokQxo(keyEvent), KeyEventType.Companion.m5927getUnknownCS__XNY()) || TextFieldKeyInput_androidKt.m1279isTypedEventZmokQxo(keyEvent)) {
            boolean m1436processKeyDownEventq0GpTC0 = m1436processKeyDownEventq0GpTC0(keyEvent, transformedTextFieldState, textLayoutState, function1, softwareKeyboardController, z, z2, function0);
            if (m1436processKeyDownEventq0GpTC0) {
                MutableLongSet mutableLongSet3 = this.currentlyConsumedDownKeys;
                if (mutableLongSet3 == null) {
                    mutableLongSet3 = new MutableLongSet(3);
                    this.currentlyConsumedDownKeys = mutableLongSet3;
                }
                mutableLongSet3.plusAssign(m5928getKeyZmokQxo);
            }
            return m1436processKeyDownEventq0GpTC0;
        } else {
            return false;
        }
    }

    /* renamed from: processKeyDownEvent-q0GpTC0  reason: not valid java name */
    private final boolean m1436processKeyDownEventq0GpTC0(KeyEvent keyEvent, TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Function1<? super KeyCommand, ? extends Unit> function1, SoftwareKeyboardController softwareKeyboardController, boolean z, boolean z2, Function0<Boolean> function0) {
        WedgeAffinity wedgeAffinity;
        Integer m1197consumeZmokQxo;
        boolean z3 = false;
        if (TextFieldKeyInput_androidKt.m1279isTypedEventZmokQxo(keyEvent) && (m1197consumeZmokQxo = this.deadKeyCombiner.m1197consumeZmokQxo(keyEvent)) != null) {
            String sb = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(2), m1197consumeZmokQxo.intValue()).toString();
            if (z) {
                TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, sb, true, null, !TextFieldKeyEventHandler_androidKt.m1438isFromSoftKeyboardZmokQxo(keyEvent), 4, null);
                this.preparedSelectionState.resetCachedX();
                return true;
            }
            return false;
        }
        KeyCommand mo1200mapZmokQxo = this.keyMapping.mo1200mapZmokQxo(keyEvent);
        if (mo1200mapZmokQxo != null && (!mo1200mapZmokQxo.getEditsText() || z)) {
            SelectionMovementDeletionContext selectionMovementDeletionContext = new SelectionMovementDeletionContext(transformedTextFieldState, textLayoutState.getLayoutResult(), TextFieldKeyEventHandler_androidKt.m1438isFromSoftKeyboardZmokQxo(keyEvent), getVisibleTextLayoutHeight(textLayoutState), this.preparedSelectionState);
            switch (WhenMappings.$EnumSwitchMapping$0[mo1200mapZmokQxo.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    function1.invoke(mo1200mapZmokQxo);
                    Unit unit = Unit.INSTANCE;
                    z3 = true;
                    break;
                case 4:
                    selectionMovementDeletionContext.collapseLeftOr(new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit processKeyDownEvent_q0GpTC0$lambda$0$0;
                            processKeyDownEvent_q0GpTC0$lambda$0$0 = TextFieldKeyEventHandler.processKeyDownEvent_q0GpTC0$lambda$0$0((SelectionMovementDeletionContext) obj);
                            return processKeyDownEvent_q0GpTC0$lambda$0$0;
                        }
                    });
                    z3 = true;
                    break;
                case 5:
                    selectionMovementDeletionContext.collapseRightOr(new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldKeyEventHandler$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit processKeyDownEvent_q0GpTC0$lambda$0$1;
                            processKeyDownEvent_q0GpTC0$lambda$0$1 = TextFieldKeyEventHandler.processKeyDownEvent_q0GpTC0$lambda$0$1((SelectionMovementDeletionContext) obj);
                            return processKeyDownEvent_q0GpTC0$lambda$0$1;
                        }
                    });
                    z3 = true;
                    break;
                case 6:
                    selectionMovementDeletionContext.moveCursorLeftByWord();
                    z3 = true;
                    break;
                case 7:
                    selectionMovementDeletionContext.moveCursorRightByWord();
                    z3 = true;
                    break;
                case 8:
                    selectionMovementDeletionContext.moveCursorPrevByParagraph();
                    z3 = true;
                    break;
                case 9:
                    selectionMovementDeletionContext.moveCursorNextByParagraph();
                    z3 = true;
                    break;
                case 10:
                    selectionMovementDeletionContext.moveCursorUpByLine();
                    z3 = true;
                    break;
                case 11:
                    selectionMovementDeletionContext.moveCursorDownByLine();
                    z3 = true;
                    break;
                case 12:
                    selectionMovementDeletionContext.moveCursorUpByPage();
                    z3 = true;
                    break;
                case 13:
                    selectionMovementDeletionContext.moveCursorDownByPage();
                    z3 = true;
                    break;
                case 14:
                    selectionMovementDeletionContext.moveCursorToLineStart();
                    z3 = true;
                    break;
                case 15:
                    selectionMovementDeletionContext.moveCursorToLineEnd();
                    z3 = true;
                    break;
                case 16:
                    selectionMovementDeletionContext.moveCursorToLineLeftSide();
                    z3 = true;
                    break;
                case 17:
                    selectionMovementDeletionContext.moveCursorToLineRightSide();
                    z3 = true;
                    break;
                case 18:
                    selectionMovementDeletionContext.moveCursorToHome();
                    z3 = true;
                    break;
                case 19:
                    selectionMovementDeletionContext.moveCursorToEnd();
                    z3 = true;
                    break;
                case 20:
                    selectionMovementDeletionContext.moveCursorPrevByCodePointOrEmoji().deleteMovement();
                    z3 = true;
                    break;
                case 21:
                    selectionMovementDeletionContext.moveCursorNextByChar().deleteMovement();
                    z3 = true;
                    break;
                case 22:
                    selectionMovementDeletionContext.moveCursorPrevByWord().deleteMovement();
                    z3 = true;
                    break;
                case 23:
                    selectionMovementDeletionContext.moveCursorNextByWord().deleteMovement();
                    z3 = true;
                    break;
                case 24:
                    selectionMovementDeletionContext.moveCursorToLineStart().deleteMovement();
                    z3 = true;
                    break;
                case 25:
                    selectionMovementDeletionContext.moveCursorToLineEnd().deleteMovement();
                    z3 = true;
                    break;
                case 26:
                    if (!z2) {
                        TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, "\n", true, null, !TextFieldKeyEventHandler_androidKt.m1438isFromSoftKeyboardZmokQxo(keyEvent), 4, null);
                        z3 = true;
                    } else {
                        z3 = function0.invoke().booleanValue();
                    }
                    Unit unit2 = Unit.INSTANCE;
                    break;
                case 27:
                    if (!z2) {
                        TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, "\t", true, null, !TextFieldKeyEventHandler_androidKt.m1438isFromSoftKeyboardZmokQxo(keyEvent), 4, null);
                        z3 = true;
                    }
                    Unit unit3 = Unit.INSTANCE;
                    break;
                case 28:
                    selectionMovementDeletionContext.selectAll();
                    z3 = true;
                    break;
                case 29:
                    selectionMovementDeletionContext.moveCursorLeftByChar().selectMovement();
                    z3 = true;
                    break;
                case 30:
                    selectionMovementDeletionContext.moveCursorRightByChar().selectMovement();
                    z3 = true;
                    break;
                case 31:
                    selectionMovementDeletionContext.moveCursorLeftByWord().selectMovement();
                    z3 = true;
                    break;
                case 32:
                    selectionMovementDeletionContext.moveCursorRightByWord().selectMovement();
                    z3 = true;
                    break;
                case 33:
                    selectionMovementDeletionContext.moveCursorPrevByParagraph().selectMovement();
                    z3 = true;
                    break;
                case 34:
                    selectionMovementDeletionContext.moveCursorNextByParagraph().selectMovement();
                    z3 = true;
                    break;
                case 35:
                    selectionMovementDeletionContext.moveCursorToLineStart().selectMovement();
                    z3 = true;
                    break;
                case 36:
                    selectionMovementDeletionContext.moveCursorToLineEnd().selectMovement();
                    z3 = true;
                    break;
                case 37:
                    selectionMovementDeletionContext.moveCursorToLineLeftSide().selectMovement();
                    z3 = true;
                    break;
                case 38:
                    selectionMovementDeletionContext.moveCursorToLineRightSide().selectMovement();
                    z3 = true;
                    break;
                case 39:
                    selectionMovementDeletionContext.moveCursorUpByLine().selectMovement();
                    z3 = true;
                    break;
                case 40:
                    selectionMovementDeletionContext.moveCursorDownByLine().selectMovement();
                    z3 = true;
                    break;
                case 41:
                    selectionMovementDeletionContext.moveCursorUpByPage().selectMovement();
                    z3 = true;
                    break;
                case 42:
                    selectionMovementDeletionContext.moveCursorDownByPage().selectMovement();
                    z3 = true;
                    break;
                case 43:
                    selectionMovementDeletionContext.moveCursorToHome().selectMovement();
                    z3 = true;
                    break;
                case 44:
                    selectionMovementDeletionContext.moveCursorToEnd().selectMovement();
                    z3 = true;
                    break;
                case 45:
                    selectionMovementDeletionContext.deselect();
                    z3 = true;
                    break;
                case 46:
                    transformedTextFieldState.undo();
                    Unit unit4 = Unit.INSTANCE;
                    z3 = true;
                    break;
                case 47:
                    transformedTextFieldState.redo();
                    Unit unit5 = Unit.INSTANCE;
                    z3 = true;
                    break;
                case 48:
                    KeyEventHelpers_androidKt.showCharacterPalette();
                    Unit unit6 = Unit.INSTANCE;
                    z3 = true;
                    break;
                case 49:
                    if (ComposeFoundationFlags.isTextFieldDpadNavigationEnabled) {
                        softwareKeyboardController.show();
                        z3 = true;
                    }
                    Unit unit7 = Unit.INSTANCE;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposeFoundationFlags.isTextFieldDpadNavigationEnabled && (mo1200mapZmokQxo == KeyCommand.UP || mo1200mapZmokQxo == KeyCommand.DOWN || mo1200mapZmokQxo == KeyCommand.LEFT_CHAR || mo1200mapZmokQxo == KeyCommand.RIGHT_CHAR)) {
                z3 = !TextRange.m6996equalsimpl0(selectionMovementDeletionContext.getInitialValue().m1336getSelectiond9O1mEE(), selectionMovementDeletionContext.m1486getSelectiond9O1mEE());
            }
            if (!TextRange.m6996equalsimpl0(selectionMovementDeletionContext.m1486getSelectiond9O1mEE(), selectionMovementDeletionContext.getInitialValue().m1336getSelectiond9O1mEE())) {
                transformedTextFieldState.m1466selectCharsIn5zctL8(selectionMovementDeletionContext.m1486getSelectiond9O1mEE());
            }
            if (selectionMovementDeletionContext.getWedgeAffinity() != null && (wedgeAffinity = selectionMovementDeletionContext.getWedgeAffinity()) != null) {
                if (TextRange.m6997getCollapsedimpl(transformedTextFieldState.getUntransformedText().m1336getSelectiond9O1mEE())) {
                    transformedTextFieldState.setSelectionWedgeAffinity(new SelectionWedgeAffinity(wedgeAffinity));
                    return z3;
                }
                transformedTextFieldState.setSelectionWedgeAffinity(SelectionWedgeAffinity.copy$default(selectionMovementDeletionContext.getInitialWedgeAffinity(), null, wedgeAffinity, 1, null));
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processKeyDownEvent_q0GpTC0$lambda$0$0(SelectionMovementDeletionContext selectionMovementDeletionContext) {
        selectionMovementDeletionContext.moveCursorLeftByChar();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processKeyDownEvent_q0GpTC0$lambda$0$1(SelectionMovementDeletionContext selectionMovementDeletionContext) {
        selectionMovementDeletionContext.moveCursorRightByChar();
        return Unit.INSTANCE;
    }

    private final float getVisibleTextLayoutHeight(TextLayoutState textLayoutState) {
        LayoutCoordinates textLayoutNodeCoordinates = textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            Rect rect = null;
            if (!textLayoutNodeCoordinates.isAttached()) {
                textLayoutNodeCoordinates = null;
            }
            if (textLayoutNodeCoordinates != null) {
                LayoutCoordinates decoratorNodeCoordinates = textLayoutState.getDecoratorNodeCoordinates();
                if (decoratorNodeCoordinates != null) {
                    if (!decoratorNodeCoordinates.isAttached()) {
                        decoratorNodeCoordinates = null;
                    }
                    if (decoratorNodeCoordinates != null) {
                        rect = LayoutCoordinates.localBoundingBoxOf$default(decoratorNodeCoordinates, textLayoutNodeCoordinates, false, 2, null);
                    }
                }
                if (rect != null) {
                    return Float.intBitsToFloat((int) (rect.m4560getSizeNHjbRc() & 4294967295L));
                }
                return Float.NaN;
            }
            return Float.NaN;
        }
        return Float.NaN;
    }
}
