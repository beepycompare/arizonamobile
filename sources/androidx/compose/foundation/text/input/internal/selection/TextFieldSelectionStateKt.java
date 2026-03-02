package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuStateKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.PlatformUtils_androidKt;
import androidx.compose.foundation.text.CommonContextMenuAreaKt$TextItem$1;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a@\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0080@¢\u0006\u0002\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0080@¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u00020\u0012*\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a5\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\b\u0004\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0080\b\u001a\u0016\u0010\u001e\u001a\u00020\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\bH\u0002\u001aR\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b#*\u00020\u00022\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u001d\u0010)\u001a\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010*¢\u0006\u0002\b#H\u0000\"\u000e\u0010\u001b\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"defaultDetectTextFieldTapGestures", "", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "pointerInputScope", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "Lkotlin/Function0;", "showKeyboard", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultTextFieldSelectionGestures", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reverse", "Landroidx/compose/ui/text/TextRange;", "reverse-5zc-tL8", "(J)J", "menuItem", "enabled", "", "desiredState", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "operation", "DEBUG", "DEBUG_TAG", "", "logDebug", "text", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "Lkotlin/ExtensionFunctionType;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "onMenuItemClicked", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/TextContextMenuItems;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionStateKt {
    private static final boolean DEBUG = false;
    private static final String DEBUG_TAG = "TextFieldSelectionState";

    public static final void logDebug(Function0<String> function0) {
    }

    public static final Object defaultDetectTextFieldTapGestures(final TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0, final Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new TextFieldSelectionStateKt$defaultDetectTextFieldTapGestures$2(mutableInteractionSource, textFieldSelectionState, null), new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldSelectionStateKt.defaultDetectTextFieldTapGestures$lambda$0(Function0.this, textFieldSelectionState, function02, (Offset) obj);
            }
        }, continuation);
        return detectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndPress : Unit.INSTANCE;
    }

    public static final Unit defaultDetectTextFieldTapGestures$lambda$0(Function0 function0, TextFieldSelectionState textFieldSelectionState, Function0 function02, Offset offset) {
        logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String defaultDetectTextFieldTapGestures$lambda$0$0;
                defaultDetectTextFieldTapGestures$lambda$0$0 = TextFieldSelectionStateKt.defaultDetectTextFieldTapGestures$lambda$0$0();
                return defaultDetectTextFieldTapGestures$lambda$0$0;
            }
        });
        function0.invoke();
        if (textFieldSelectionState.getEnabled() && textFieldSelectionState.isFocused()) {
            if (!textFieldSelectionState.getReadOnly()) {
                function02.invoke();
                if (textFieldSelectionState.getTextFieldState$foundation().getVisualText().length() > 0) {
                    textFieldSelectionState.setShowCursorHandle(true);
                }
            }
            textFieldSelectionState.updateTextToolbarState(TextToolbarState.None);
            textFieldSelectionState.m1509placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m1454fromDecorationToTextLayoutUv8p0NA(textFieldSelectionState.getTextLayoutState$foundation(), textFieldSelectionState.getTextLayoutState$foundation().m1447coercedInVisibleBoundsOfInputTextMKHz9U$foundation(offset.m4537unboximpl())));
        }
        return Unit.INSTANCE;
    }

    public static final String defaultDetectTextFieldTapGestures$lambda$0$0() {
        return "onTapTextField";
    }

    public static final Object defaultTextFieldSelectionGestures(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object awaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, mouseSelectionObserver, textDragObserver, continuation);
        return awaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitSelectionGestures : Unit.INSTANCE;
    }

    /* renamed from: reverse-5zc-tL8 */
    public static final long m1518reverse5zctL8(long j) {
        return TextRangeKt.TextRange(TextRange.m6998getEndimpl(j), TextRange.m7003getStartimpl(j));
    }

    public static final Function0<Unit> menuItem(final TextFieldSelectionState textFieldSelectionState, boolean z, final TextToolbarState textToolbarState, final Function0<Unit> function0) {
        if (z) {
            return new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$menuItem$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function0.invoke();
                    textFieldSelectionState.updateTextToolbarState(textToolbarState);
                }
            };
        }
        return null;
    }

    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionState textFieldSelectionState, final ContextMenuState contextMenuState, final State<MenuItemsAvailability> state, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> function2) {
        return new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TextFieldSelectionStateKt.contextMenuBuilder$lambda$0(State.this, contextMenuState, function2, textFieldSelectionState, (ContextMenuScope) obj);
            }
        };
    }

    public static final Unit contextMenuBuilder$lambda$0(State state, ContextMenuState contextMenuState, Function2 function2, TextFieldSelectionState textFieldSelectionState, ContextMenuScope contextMenuScope) {
        int m1239unboximpl = ((MenuItemsAvailability) state.getValue()).m1239unboximpl();
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Cut, MenuItemsAvailability.m1234getCanCutimpl(m1239unboximpl));
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Copy, MenuItemsAvailability.m1233getCanCopyimpl(m1239unboximpl));
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Paste, MenuItemsAvailability.m1235getCanPasteimpl(m1239unboximpl));
        contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.SelectAll, MenuItemsAvailability.m1236getCanSelectAllimpl(m1239unboximpl));
        if (PlatformUtils_androidKt.isAutofillAvailable()) {
            contextMenuBuilder$lambda$0$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Autofill, MenuItemsAvailability.m1232getCanAutofillimpl(m1239unboximpl));
        }
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$0$textFieldItem(ContextMenuScope contextMenuScope, final ContextMenuState contextMenuState, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> function2, final TextFieldSelectionState textFieldSelectionState, final TextContextMenuItems textContextMenuItems, boolean z) {
        if (z) {
            ContextMenuScope.item$default(contextMenuScope, new CommonContextMenuAreaKt$TextItem$1(textContextMenuItems), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionStateKt$contextMenuBuilder$lambda$0$textFieldItem$$inlined$TextItem$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function2.invoke(textFieldSelectionState, textContextMenuItems);
                    ContextMenuStateKt.close(ContextMenuState.this);
                }
            }, 14, null);
        }
    }
}
