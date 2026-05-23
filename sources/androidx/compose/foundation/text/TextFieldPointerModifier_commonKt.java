package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.input.OffsetMapping;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
/* compiled from: TextFieldPointerModifier.common.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0000¨\u0006\u000f"}, d2 = {"defaultTextFieldPointer", "Landroidx/compose/ui/Modifier;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "readOnly", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldPointerModifier_commonKt {
    public static final Modifier defaultTextFieldPointer(Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, MutableInteractionSource mutableInteractionSource, final LegacyTextFieldState legacyTextFieldState, final FocusRequester focusRequester, final boolean z2, final OffsetMapping offsetMapping) {
        return PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(SelectionGesturesKt.updateSelectionTouchMode(modifier, new Function1() { // from class: androidx.compose.foundation.text.TextFieldPointerModifier_commonKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldPointerModifier_commonKt.defaultTextFieldPointer$lambda$0(LegacyTextFieldState.this, ((Boolean) obj).booleanValue());
            }
        }), mutableInteractionSource, z, new Function1() { // from class: androidx.compose.foundation.text.TextFieldPointerModifier_commonKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldPointerModifier_commonKt.defaultTextFieldPointer$lambda$1(LegacyTextFieldState.this, focusRequester, z2, z, textFieldSelectionManager, offsetMapping, (Offset) obj);
            }
        }), textFieldSelectionManager.getMouseSelectionObserver$foundation(), textFieldSelectionManager.getTouchSelectionObserver$foundation(), new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.TextFieldPointerModifier_commonKt$defaultTextFieldPointer$3
            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, TextFieldSelectionManager.this.getMouseSelectionObserver$foundation(), TextFieldSelectionManager.this.getTouchSelectionObserver$foundation(), continuation);
                return awaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitSelectionGestures : Unit.INSTANCE;
            }
        }), PointerIcon.Companion.getText(), false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit defaultTextFieldPointer$lambda$0(LegacyTextFieldState legacyTextFieldState, boolean z) {
        legacyTextFieldState.setInTouchMode(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit defaultTextFieldPointer$lambda$1(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z, boolean z2, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping, Offset offset) {
        CoreTextFieldKt.requestFocusAndShowKeyboardIfNeeded(legacyTextFieldState, focusRequester, !z);
        if (legacyTextFieldState.getHasFocus() && z2) {
            if (legacyTextFieldState.getHandleState() != HandleState.Selection) {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null) {
                    TextFieldDelegate.Companion.m1652setCursorOffsetULxng0E$foundation(offset.m5113unboximpl(), layoutResult, legacyTextFieldState.getProcessor(), offsetMapping, legacyTextFieldState.getOnValueChange());
                    if (legacyTextFieldState.getTextDelegate().getText().length() > 0) {
                        legacyTextFieldState.setHandleState(HandleState.Cursor);
                    }
                }
            } else {
                textFieldSelectionManager.m2104deselect_kEHs6E$foundation(offset);
            }
        }
        return Unit.INSTANCE;
    }
}
