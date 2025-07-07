package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001:\u0006\u00ad\u0001®\u0001¯\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0002\u0010\rJ\u0006\u0010[\u001a\u00020CJ\u0006\u0010\\\u001a\u00020\tJ\u0006\u0010]\u001a\u00020\tJ\u0006\u0010^\u001a\u00020\tJ\u000e\u0010_\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010`J\u0006\u0010a\u001a\u00020\tJ\u0006\u0010b\u001a\u00020CJ\u0018\u0010c\u001a\u00020C2\b\b\u0002\u0010d\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010eJ\u000e\u0010f\u001a\u00020CH\u0086@¢\u0006\u0002\u0010`J\u0006\u0010g\u001a\u00020CJ\u0006\u0010h\u001a\u00020CJ\b\u0010i\u001a\u00020jH\u0002J\u0015\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\tH\u0000¢\u0006\u0002\bnJ\u0006\u0010o\u001a\u00020jJ\u001d\u0010p\u001a\u00020\u00112\u0006\u0010q\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\br\u0010sJ\u001d\u0010t\u001a\u00020l2\u0006\u0010q\u001a\u00020\t2\u0006\u0010m\u001a\u00020\tH\u0000¢\u0006\u0002\buJ<\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u0002032\u0006\u0010y\u001a\u0002032\b\u0010z\u001a\u0004\u0018\u00010w2\u0006\u0010q\u001a\u00020\t2\u0006\u0010{\u001a\u00020|H\u0002ø\u0001\u0000¢\u0006\u0004\b}\u0010~J\b\u0010\u007f\u001a\u00020CH\u0002J\t\u0010\u0080\u0001\u001a\u00020\tH\u0002J\t\u0010\u0081\u0001\u001a\u00020CH\u0002J\u000f\u0010\u0082\u0001\u001a\u00020CH\u0082@¢\u0006\u0002\u0010`J\u000f\u0010\u0083\u0001\u001a\u00020CH\u0082@¢\u0006\u0002\u0010`J\u000f\u0010\u0084\u0001\u001a\u00020CH\u0086@¢\u0006\u0002\u0010`J\u000f\u0010\u0085\u0001\u001a\u00020CH\u0082@¢\u0006\u0002\u0010`J\u001e\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u0007\u0010\u008a\u0001\u001a\u00020CJ\u000f\u0010\u008b\u0001\u001a\u00020CH\u0086@¢\u0006\u0002\u0010`J@\u0010\u008c\u0001\u001a\u00020C2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000e\u001a\u00020\u000f2\u0007\u0010\u008d\u0001\u001a\u00020S2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ%\u0010\u008e\u0001\u001a\u00020C2\u0007\u0010\u008f\u0001\u001a\u00020\u001d2\u0007\u0010\u0090\u0001\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001JZ\u0010\u0093\u0001\u001a\u00020w2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u0002032\u0007\u0010\u0097\u0001\u001a\u0002032\u0006\u0010q\u001a\u00020\t2\u0006\u0010{\u001a\u00020|2\t\b\u0002\u0010\u0098\u0001\u001a\u00020\t2\t\b\u0002\u0010\u0099\u0001\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u000f\u0010\u009c\u0001\u001a\u00020C2\u0006\u0010U\u001a\u00020TJ\u0015\u0010\u009d\u0001\u001a\u00020C*\u00030\u009e\u0001H\u0086@¢\u0006\u0003\u0010\u009f\u0001J\u0015\u0010 \u0001\u001a\u00020C*\u00030\u009e\u0001H\u0082@¢\u0006\u0003\u0010\u009f\u0001J\u001d\u0010¡\u0001\u001a\u00020C*\u00030\u009e\u00012\u0006\u0010q\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010¢\u0001J?\u0010£\u0001\u001a\u00020C*\u00030\u009e\u00012\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020C0<2\r\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020C0<H\u0086@¢\u0006\u0003\u0010¨\u0001J\u0015\u0010©\u0001\u001a\u00020C*\u00030\u009e\u0001H\u0086@¢\u0006\u0003\u0010\u009f\u0001J\u001d\u0010ª\u0001\u001a\u00020C*\u00030\u009e\u00012\u0006\u0010q\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010¢\u0001J$\u0010«\u0001\u001a\u00020C*\u00030\u009e\u00012\r\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020C0<H\u0086@¢\u0006\u0003\u0010¬\u0001R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR/\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\u00020\u00118Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b(\u0010\u0013R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010&\"\u0004\b+\u0010,R+\u0010-\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u001c\u001a\u0004\b-\u0010&\"\u0004\b.\u0010,R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R1\u00106\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b:\u0010\u001c\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u00109R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010=\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR+\u0010F\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010\u001c\u001a\u0004\bG\u0010&\"\u0004\bH\u0010,R1\u0010J\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00118B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bM\u0010\u001c\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u00109R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010U\u001a\u00020T2\u0006\u0010\u0014\u001a\u00020T8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010\u001c\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006°\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZ)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "currentTextLayoutPositionInWindow", "Landroidx/compose/ui/geometry/Offset;", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "()J", "<set-?>", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "editable", "getEditable", "()Z", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setFocused", "(Z)V", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "previousRawDragOffset", "", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "(J)V", "rawHandleDragPosition$delegate", "receiveContentConfiguration", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "()Lkotlin/jvm/functions/Function0;", "setReceiveContentConfiguration", "(Lkotlin/jvm/functions/Function0;)V", "requestAutofillAction", "", "getRequestAutofillAction", "setRequestAutofillAction", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "setStartTextLayoutPositionInWindow-k-4lQ0M", "startTextLayoutPositionInWindow$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textToolbarHandler", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "autofill", "canAutofill", "canCopy", "canCut", "canPaste", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canSelectAll", "clearHandleDragging", "copy", "cancelSelection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cut", "deselect", "dispose", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation_release", "getCursorRect", "getHandlePosition", "isStartHandle", "getHandlePosition-tuRUvjQ", "(Z)J", "getSelectionHandleState", "getSelectionHandleState$foundation_release", "getTextFieldSelection", "Landroidx/compose/ui/text/TextRange;", "rawStartOffset", "rawEndOffset", "previousSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "hideTextToolbar", "isCursorHandleInVisibleBounds", "markStartContentVisibleOffset", "observeTextChanges", "observeTextToolbarVisibility", "paste", "pasteAsPlainText", "placeCursorAtNearestOffset", TypedValues.CycleType.S_WAVE_OFFSET, "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "selectAll", "startToolbarAndHandlesVisibilityObserver", "update", "showTextToolbar", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateSelection", "textFieldCharSequence", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "startOffset", "endOffset", "allowPreviousSelectionCollapsed", "isStartOfSelection", "updateSelection-SsL-Rf8", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "updateTextToolbarState", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectTouchMode", "selectionHandleGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private Density density;
    private final MutableState directDragGestureInitiator$delegate;
    private final MutableState draggingHandle$delegate;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private final MutableState isInTouchMode$delegate;
    private boolean isPassword;
    private PressInteraction.Press pressInteraction;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private final MutableState rawHandleDragPosition$delegate;
    private boolean readOnly;
    private Function0<? extends ReceiveContentConfiguration> receiveContentConfiguration;
    private Function0<Unit> requestAutofillAction;
    private final MutableState showCursorHandle$delegate;
    private final MutableState startTextLayoutPositionInWindow$delegate;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbarHandler textToolbarHandler;
    private final MutableState textToolbarState$delegate;

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Density density, boolean z, boolean z2, boolean z3, boolean z4) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = z;
        this.readOnly = z2;
        this.isFocused = z3;
        this.isPassword = z4;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.isInTouchMode$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3826boximpl(Offset.Companion.m3852getUnspecifiedF1C5BW0()), null, 2, null);
        this.startTextLayoutPositionInWindow$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3826boximpl(Offset.Companion.m3852getUnspecifiedF1C5BW0()), null, 2, null);
        this.rawHandleDragPosition$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputType.None, null, 2, null);
        this.directDragGestureInitiator$delegate = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.showCursorHandle$delegate = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
        this.textToolbarState$delegate = mutableStateOf$default7;
        this.previousRawDragOffset = -1;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode$delegate.getValue()).booleanValue();
    }

    public final void setInTouchMode(boolean z) {
        this.isInTouchMode$delegate.setValue(Boolean.valueOf(z));
    }

    public final Function0<Unit> getRequestAutofillAction() {
        return this.requestAutofillAction;
    }

    public final void setRequestAutofillAction(Function0<Unit> function0) {
        this.requestAutofillAction = function0;
    }

    public final Function0<ReceiveContentConfiguration> getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    public final void setReceiveContentConfiguration(Function0<? extends ReceiveContentConfiguration> function0) {
        this.receiveContentConfiguration = function0;
    }

    /* renamed from: getStartTextLayoutPositionInWindow-F1C5BW0  reason: not valid java name */
    private final long m1378getStartTextLayoutPositionInWindowF1C5BW0() {
        return ((Offset) this.startTextLayoutPositionInWindow$delegate.getValue()).m3847unboximpl();
    }

    /* renamed from: setStartTextLayoutPositionInWindow-k-4lQ0M  reason: not valid java name */
    private final void m1382setStartTextLayoutPositionInWindowk4lQ0M(long j) {
        this.startTextLayoutPositionInWindow$delegate.setValue(Offset.m3826boximpl(j));
    }

    /* renamed from: getCurrentTextLayoutPositionInWindow-F1C5BW0  reason: not valid java name */
    private final long m1375getCurrentTextLayoutPositionInWindowF1C5BW0() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return textLayoutCoordinates != null ? LayoutCoordinatesKt.positionInWindow(textLayoutCoordinates) : Offset.Companion.m3852getUnspecifiedF1C5BW0();
    }

    /* renamed from: getRawHandleDragPosition-F1C5BW0  reason: not valid java name */
    private final long m1377getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition$delegate.getValue()).m3847unboximpl();
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M  reason: not valid java name */
    private final void m1381setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition$delegate.setValue(Offset.m3826boximpl(j));
    }

    /* renamed from: getHandleDragPosition-F1C5BW0  reason: not valid java name */
    public final long m1385getHandleDragPositionF1C5BW0() {
        if ((m1377getRawHandleDragPositionF1C5BW0() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return Offset.Companion.m3852getUnspecifiedF1C5BW0();
        }
        if ((m1378getStartTextLayoutPositionInWindowF1C5BW0() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return TextLayoutStateKt.m1324fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1377getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m3842plusMKHz9U(m1377getRawHandleDragPositionF1C5BW0(), Offset.m3841minusMKHz9U(m1378getStartTextLayoutPositionInWindowF1C5BW0(), m1375getCurrentTextLayoutPositionInWindowF1C5BW0()));
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class InputType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ InputType[] $VALUES;
        public static final InputType None = new InputType("None", 0);
        public static final InputType Touch = new InputType("Touch", 1);
        public static final InputType Mouse = new InputType("Mouse", 2);

        private static final /* synthetic */ InputType[] $values() {
            return new InputType[]{None, Touch, Mouse};
        }

        public static EnumEntries<InputType> getEntries() {
            return $ENTRIES;
        }

        public static InputType valueOf(String str) {
            return (InputType) Enum.valueOf(InputType.class, str);
        }

        public static InputType[] values() {
            return (InputType[]) $VALUES.clone();
        }

        private InputType(String str, int i) {
        }

        static {
            InputType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    public final InputType getDirectDragGestureInitiator() {
        return (InputType) this.directDragGestureInitiator$delegate.getValue();
    }

    public final void setDirectDragGestureInitiator(InputType inputType) {
        this.directDragGestureInitiator$delegate.setValue(inputType);
    }

    private final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z) {
        this.showCursorHandle$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState$delegate.setValue(textToolbarState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    private final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    public final TextFieldHandleState getCursorHandleState$foundation_release(boolean z) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        boolean showCursorHandle = getShowCursorHandle();
        boolean z2 = getDirectDragGestureInitiator() == InputType.None;
        Handle draggingHandle = getDraggingHandle();
        if (!showCursorHandle || !z2 || !TextRange.m6141getCollapsedimpl(visualText.m1203getSelectiond9O1mEE()) || !visualText.shouldShowSelection() || visualText.length() <= 0 || (draggingHandle != Handle.Cursor && !isCursorHandleInVisibleBounds())) {
            return TextFieldHandleState.Companion.getHidden();
        }
        return new TextFieldHandleState(true, z ? getCursorRect().m3864getBottomCenterF1C5BW0() : Offset.Companion.m3852getUnspecifiedF1C5BW0(), 0.0f, ResolvedTextDirection.Ltr, false, null);
    }

    private final boolean isCursorHandleInVisibleBounds() {
        Rect visibleBounds;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            long m3864getBottomCenterF1C5BW0 = getCursorRect().m3864getBottomCenterF1C5BW0();
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) {
                return false;
            }
            return SelectionManagerKt.m1504containsInclusiveUv8p0NA(visibleBounds, m3864getBottomCenterF1C5BW0);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final Rect getCursorRect() {
        float right;
        float rint;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.Companion.getZero();
        }
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m6141getCollapsedimpl(visualText.m1203getSelectiond9O1mEE())) {
            Rect cursorRect = layoutResult.getCursorRect(TextRange.m6147getStartimpl(visualText.m1203getSelectiond9O1mEE()));
            float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.floor(this.density.mo389toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
            if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
                right = cursorRect.getLeft() + (coerceAtLeast / 2);
            } else {
                right = cursorRect.getRight() - (coerceAtLeast / 2);
            }
            float f = coerceAtLeast / 2;
            float coerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(right, ((int) (layoutResult.m6118getSizeYbymL2g() >> 32)) - f), f);
            if (((int) coerceAtLeast) % 2 == 1) {
                rint = ((float) Math.floor(coerceAtLeast2)) + 0.5f;
            } else {
                rint = (float) Math.rint(coerceAtLeast2);
            }
            return new Rect(rint - f, cursorRect.getTop(), rint + f, cursorRect.getBottom());
        }
        return Rect.Companion.getZero();
    }

    public final void update(HapticFeedback hapticFeedback, Clipboard clipboard, TextToolbarHandler textToolbarHandler, Density density, boolean z, boolean z2, boolean z3) {
        if (!z) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedback;
        this.clipboard = clipboard;
        this.textToolbarHandler = textToolbarHandler;
        this.density = density;
        this.enabled = z;
        this.readOnly = z2;
        this.isPassword = z3;
    }

    public final Object cursorHandleGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$cursorHandleGestures$2(this, pointerInputScope, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    public final Object selectionHandleGestures(PointerInputScope pointerInputScope, boolean z, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$selectionHandleGestures$2(this, pointerInputScope, z, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startToolbarAndHandlesVisibilityObserver(Continuation<? super Unit> continuation) {
        TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1;
        int i;
        TextFieldSelectionState textFieldSelectionState;
        if (continuation instanceof TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1) {
            textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 = (TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1) continuation;
            if ((textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.L$0 = this;
                        textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label = 1;
                        if (CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2(this, null), textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        textFieldSelectionState = this;
                    } catch (Throwable th) {
                        th = th;
                        textFieldSelectionState = this;
                        textFieldSelectionState.setShowCursorHandle(false);
                        if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                            textFieldSelectionState.hideTextToolbar();
                        }
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        textFieldSelectionState.setShowCursorHandle(false);
                        if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                        }
                        throw th;
                    }
                }
                textFieldSelectionState.setShowCursorHandle(false);
                if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
                    textFieldSelectionState.hideTextToolbar();
                }
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 = new TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1(this, continuation);
        Object obj2 = textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label;
        if (i != 0) {
        }
        textFieldSelectionState.setShowCursorHandle(false);
        if (textFieldSelectionState.getTextToolbarState() != TextToolbarState.None) {
        }
        return Unit.INSTANCE;
    }

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.clipboard = null;
        this.hapticFeedBack = null;
    }

    public final Object detectTouchMode(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TextFieldSelectionState$detectTouchMode$2(this, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, final Function0<Unit> function0, final Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new TextFieldSelectionState$detectTextFieldTapGestures$2(mutableInteractionSource, this, null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m1398invokek4lQ0M(offset.m3847unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
            public final void m1398invokek4lQ0M(long j) {
                boolean z;
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$3.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                function0.invoke();
                if (this.enabled && this.isFocused()) {
                    z = this.readOnly;
                    if (!z) {
                        function02.invoke();
                        if (this.textFieldState.getVisualText().length() > 0) {
                            this.setShowCursorHandle(true);
                        }
                    }
                    this.updateTextToolbarState(TextToolbarState.None);
                    long m1317coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release = this.textLayoutState.m1317coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(j);
                    TextFieldSelectionState textFieldSelectionState = this;
                    textFieldSelectionState.m1380placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m1324fromDecorationToTextLayoutUv8p0NA(textFieldSelectionState.textLayoutState, m1317coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release));
                }
            }
        }, continuation);
        return detectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeCursorAtNearestOffset-k-4lQ0M  reason: not valid java name */
    public final boolean m1380placeCursorAtNearestOffsetk4lQ0M(long j) {
        int m6117getOffsetForPositionk4lQ0M;
        IndexTransformationType indexTransformationType;
        int m6147getStartimpl;
        SelectionWedgeAffinity selectionWedgeAffinity;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null || (m6117getOffsetForPositionk4lQ0M = layoutResult.m6117getOffsetForPositionk4lQ0M(j)) == -1) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        long m1331mapFromTransformedjx7JFs = transformedTextFieldState.m1331mapFromTransformedjx7JFs(m6117getOffsetForPositionk4lQ0M);
        long m1334mapToTransformedGEjPoXI = transformedTextFieldState.m1334mapToTransformedGEjPoXI(m1331mapFromTransformedjx7JFs);
        if (TextRange.m6141getCollapsedimpl(m1331mapFromTransformedjx7JFs) && TextRange.m6141getCollapsedimpl(m1334mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m6141getCollapsedimpl(m1331mapFromTransformedjx7JFs) && !TextRange.m6141getCollapsedimpl(m1334mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (TextRange.m6141getCollapsedimpl(m1331mapFromTransformedjx7JFs) && !TextRange.m6141getCollapsedimpl(m1334mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Insertion;
        } else {
            indexTransformationType = IndexTransformationType.Deletion;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        SelectionWedgeAffinity selectionWedgeAffinity2 = null;
        if (i == 1) {
            m6147getStartimpl = TextRange.m6147getStartimpl(m1331mapFromTransformedjx7JFs);
        } else if (i == 2) {
            m6147getStartimpl = TextRange.m6147getStartimpl(m1331mapFromTransformedjx7JFs);
        } else if (i == 3) {
            if (MathUtilsKt.m1278findClosestRect9KIMszo(j, layoutResult.getCursorRect(TextRange.m6147getStartimpl(m1334mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m6142getEndimpl(m1334mapToTransformedGEjPoXI))) < 0) {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.Start);
            } else {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.End);
            }
            selectionWedgeAffinity2 = selectionWedgeAffinity;
            m6147getStartimpl = TextRange.m6147getStartimpl(m1331mapFromTransformedjx7JFs);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (MathUtilsKt.m1278findClosestRect9KIMszo(j, layoutResult.getCursorRect(TextRange.m6147getStartimpl(m1334mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m6142getEndimpl(m1334mapToTransformedGEjPoXI))) < 0) {
                m6147getStartimpl = TextRange.m6147getStartimpl(m1331mapFromTransformedjx7JFs);
            } else {
                m6147getStartimpl = TextRange.m6142getEndimpl(m1331mapFromTransformedjx7JFs);
            }
        }
        long TextRange = TextRangeKt.TextRange(m6147getStartimpl);
        if (TextRange.m6140equalsimpl0(TextRange, this.textFieldState.getUntransformedText().m1203getSelectiond9O1mEE()) && (selectionWedgeAffinity2 == null || Intrinsics.areEqual(selectionWedgeAffinity2, this.textFieldState.getSelectionWedgeAffinity()))) {
            return false;
        }
        this.textFieldState.m1337selectUntransformedCharsIn5zctL8(TextRange);
        if (selectionWedgeAffinity2 != null) {
            this.textFieldState.setSelectionWedgeAffinity(selectionWedgeAffinity2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectCursorHandleDragGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        TextFieldSelectionState$detectCursorHandleDragGestures$1 textFieldSelectionState$detectCursorHandleDragGestures$1;
        int i;
        TextFieldSelectionState textFieldSelectionState;
        Ref.LongRef longRef;
        Throwable th;
        Ref.LongRef longRef2;
        if (continuation instanceof TextFieldSelectionState$detectCursorHandleDragGestures$1) {
            textFieldSelectionState$detectCursorHandleDragGestures$1 = (TextFieldSelectionState$detectCursorHandleDragGestures$1) continuation;
            if ((textFieldSelectionState$detectCursorHandleDragGestures$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$detectCursorHandleDragGestures$1.label -= Integer.MIN_VALUE;
                TextFieldSelectionState$detectCursorHandleDragGestures$1 textFieldSelectionState$detectCursorHandleDragGestures$12 = textFieldSelectionState$detectCursorHandleDragGestures$1;
                Object obj = textFieldSelectionState$detectCursorHandleDragGestures$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$detectCursorHandleDragGestures$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = Offset.Companion.m3852getUnspecifiedF1C5BW0();
                    final Ref.LongRef longRef4 = new Ref.LongRef();
                    longRef4.element = Offset.Companion.m3852getUnspecifiedF1C5BW0();
                    try {
                        textFieldSelectionState$detectCursorHandleDragGestures$12.L$0 = this;
                        textFieldSelectionState$detectCursorHandleDragGestures$12.L$1 = longRef3;
                        textFieldSelectionState$detectCursorHandleDragGestures$12.L$2 = longRef4;
                        textFieldSelectionState$detectCursorHandleDragGestures$12.label = 1;
                        if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m1393invokek4lQ0M(offset.m3847unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                            public final void m1393invokek4lQ0M(long j) {
                                Ref.LongRef.this.element = SelectionHandlesKt.m1468getAdjustedCoordinatesk4lQ0M(this.getCursorRect().m3864getBottomCenterF1C5BW0());
                                longRef4.element = Offset.Companion.m3853getZeroF1C5BW0();
                                this.setInTouchMode(true);
                                this.markStartContentVisibleOffset();
                                this.m1386updateHandleDraggingUv8p0NA(Handle.Cursor, Ref.LongRef.this.element);
                            }
                        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(Ref.LongRef.this, longRef4, this);
                            }
                        }, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                TextFieldSelectionState.detectCursorHandleDragGestures$onDragStop(Ref.LongRef.this, longRef4, this);
                            }
                        }, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                                m1394invokeUv8p0NA(pointerInputChange, offset.m3847unboximpl());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
                            public final void m1394invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                                boolean m1380placeCursorAtNearestOffsetk4lQ0M;
                                Ref.LongRef longRef5 = Ref.LongRef.this;
                                longRef5.element = Offset.m3842plusMKHz9U(longRef5.element, j);
                                this.m1386updateHandleDraggingUv8p0NA(Handle.Cursor, Offset.m3842plusMKHz9U(longRef3.element, Ref.LongRef.this.element));
                                TextFieldSelectionState textFieldSelectionState2 = this;
                                m1380placeCursorAtNearestOffsetk4lQ0M = textFieldSelectionState2.m1380placeCursorAtNearestOffsetk4lQ0M(textFieldSelectionState2.m1385getHandleDragPositionF1C5BW0());
                                if (m1380placeCursorAtNearestOffsetk4lQ0M) {
                                    pointerInputChange.consume();
                                    HapticFeedback hapticFeedback = this.hapticFeedBack;
                                    if (hapticFeedback != null) {
                                        hapticFeedback.mo4812performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4828getTextHandleMove5zf0vsI());
                                    }
                                }
                            }
                        }, textFieldSelectionState$detectCursorHandleDragGestures$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        textFieldSelectionState = this;
                        longRef = longRef3;
                        longRef2 = longRef4;
                    } catch (Throwable th2) {
                        textFieldSelectionState = this;
                        longRef = longRef3;
                        th = th2;
                        longRef2 = longRef4;
                        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    longRef2 = (Ref.LongRef) textFieldSelectionState$detectCursorHandleDragGestures$12.L$2;
                    longRef = (Ref.LongRef) textFieldSelectionState$detectCursorHandleDragGestures$12.L$1;
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$detectCursorHandleDragGestures$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
                        throw th;
                    }
                }
                detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$detectCursorHandleDragGestures$1 = new TextFieldSelectionState$detectCursorHandleDragGestures$1(this, continuation);
        TextFieldSelectionState$detectCursorHandleDragGestures$1 textFieldSelectionState$detectCursorHandleDragGestures$122 = textFieldSelectionState$detectCursorHandleDragGestures$1;
        Object obj2 = textFieldSelectionState$detectCursorHandleDragGestures$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$detectCursorHandleDragGestures$122.label;
        if (i != 0) {
        }
        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if ((longRef.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            longRef.element = Offset.Companion.m3852getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m3852getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    public final Object textFieldSelectionGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object selectionGesturePointerInputBtf2 = SelectionGesturesKt.selectionGesturePointerInputBtf2(pointerInputScope, new TextFieldMouseSelectionObserver(function0), new TextFieldTextDragObserver(function0), continuation);
        return selectionGesturePointerInputBtf2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? selectionGesturePointerInputBtf2 : Unit.INSTANCE;
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016J\"\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0011J*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "onDrag", "", "dragPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onDragDone", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "isStartOfSelection", "updateSelection-r1Wruf4", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.Companion.m3852getUnspecifiedF1C5BW0();
        private final Function0<Unit> requestFocus;

        public TextFieldMouseSelectionObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onStart-3MmeM6k  reason: not valid java name */
        public boolean mo1391onStart3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onStart$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onStart";
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Mouse);
            this.requestFocus.invoke();
            TextFieldSelectionState.this.previousRawDragOffset = -1;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = j;
            this.dragBeginOffsetInText = TextRange.m6147getStartimpl(m1387updateSelectionr1Wruf4(j, selectionAdjustment, true));
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onDrag-3MmeM6k  reason: not valid java name */
        public boolean mo1388onDrag3MmeM6k(final long j, SelectionAdjustment selectionAdjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDrag$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onDrag " + ((Object) Offset.m3845toStringimpl(j));
                }
            });
            m1387updateSelectionr1Wruf4(j, selectionAdjustment, false);
            return true;
        }

        /* renamed from: updateSelection-r1Wruf4  reason: not valid java name */
        private final long m1387updateSelectionr1Wruf4(long j, SelectionAdjustment selectionAdjustment, boolean z) {
            Integer valueOf = Integer.valueOf(this.dragBeginOffsetInText);
            if (valueOf.intValue() < 0) {
                valueOf = null;
            }
            int intValue = valueOf != null ? valueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m1319getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            int m1319getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m1319getOffsetForPosition3MmeM6k(j, false);
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long m1383updateSelectionSsLRf8 = textFieldSelectionState.m1383updateSelectionSsLRf8(textFieldSelectionState.textFieldState.getVisualText(), intValue, m1319getOffsetForPosition3MmeM6k, false, selectionAdjustment, false, z);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6141getCollapsedimpl(m1383updateSelectionSsLRf8)) {
                this.dragBeginOffsetInText = TextRange.m6147getStartimpl(m1383updateSelectionSsLRf8);
            }
            if (TextRange.m6146getReversedimpl(m1383updateSelectionSsLRf8)) {
                m1383updateSelectionSsLRf8 = TextFieldSelectionStateKt.m1400reverse5zctL8(m1383updateSelectionSsLRf8);
            }
            TextFieldSelectionState.this.textFieldState.m1336selectCharsIn5zctL8(m1383updateSelectionSsLRf8);
            TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            return m1383updateSelectionSsLRf8;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void onDragDone() {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDragDone$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onDragDone";
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onExtend-k-4lQ0M  reason: not valid java name */
        public boolean mo1389onExtendk4lQ0M(long j) {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtend$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onExtend";
                }
            });
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onExtendDrag-k-4lQ0M  reason: not valid java name */
        public boolean mo1390onExtendDragk4lQ0M(long j) {
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtendDrag$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Mouse.onExtendDrag";
                }
            });
            return true;
        }
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0012J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0012J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\u00020\u000bX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "onCancel", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onDragStop", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class TextFieldTextDragObserver implements TextDragObserver {
        private final Function0<Unit> requestFocus;
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.Companion.m3852getUnspecifiedF1C5BW0();
        private long dragTotalDistance = Offset.Companion.m3853getZeroF1C5BW0();
        private Handle actingHandle = Handle.SelectionEnd;

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onDown-k-4lQ0M */
        public void mo1146onDownk4lQ0M(long j) {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onUp() {
        }

        public TextFieldTextDragObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        private final void onDragStop() {
            if ((this.dragBeginPosition & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDragStop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Touch.onDragStop";
                    }
                });
                TextFieldSelectionState.this.clearHandleDragging();
                this.dragBeginOffsetInText = -1;
                this.dragBeginPosition = Offset.Companion.m3852getUnspecifiedF1C5BW0();
                this.dragTotalDistance = Offset.Companion.m3853getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
                this.requestFocus.invoke();
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStop() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onCancel() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onStart-k-4lQ0M */
        public void mo1148onStartk4lQ0M(final long j) {
            if (TextFieldSelectionState.this.enabled) {
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onStart$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Touch.onDragStart after longPress at " + ((Object) Offset.m3845toStringimpl(j));
                    }
                });
                TextFieldSelectionState.this.m1386updateHandleDraggingUv8p0NA(this.actingHandle, j);
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Touch);
                this.dragBeginPosition = j;
                this.dragTotalDistance = Offset.Companion.m3853getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                if (TextFieldSelectionState.this.textLayoutState.getLayoutResult() == null) {
                    return;
                }
                if (!TextFieldSelectionState.this.textLayoutState.m1320isPositionOnTextk4lQ0M(j)) {
                    int m1316getOffsetForPosition3MmeM6k$default = TextLayoutState.m1316getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, j, false, 2, null);
                    HapticFeedback hapticFeedback = TextFieldSelectionState.this.hapticFeedBack;
                    if (hapticFeedback != null) {
                        hapticFeedback.mo4812performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4828getTextHandleMove5zf0vsI());
                    }
                    TextFieldSelectionState.this.textFieldState.placeCursorBeforeCharAt(m1316getOffsetForPosition3MmeM6k$default);
                    TextFieldSelectionState.this.setShowCursorHandle(true);
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Cursor);
                } else if (TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                } else {
                    int m1316getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m1316getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, j, false, 2, null);
                    long m1384updateSelectionSsLRf8$default = TextFieldSelectionState.m1384updateSelectionSsLRf8$default(TextFieldSelectionState.this, new TextFieldCharSequence(TextFieldSelectionState.this.textFieldState.getVisualText(), TextRange.Companion.m6152getZerod9O1mEE(), null, null, null, 28, null), m1316getOffsetForPosition3MmeM6k$default2, m1316getOffsetForPosition3MmeM6k$default2, false, SelectionAdjustment.Companion.getWord(), false, false, 96, null);
                    TextFieldSelectionState.this.textFieldState.m1336selectCharsIn5zctL8(m1384updateSelectionSsLRf8$default);
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                    this.dragBeginOffsetInText = TextRange.m6147getStartimpl(m1384updateSelectionSsLRf8$default);
                }
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onDrag-k-4lQ0M */
        public void mo1147onDragk4lQ0M(long j) {
            int intValue;
            int m1319getOffsetForPosition3MmeM6k;
            SelectionAdjustment word;
            Handle handle;
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textLayoutState.getLayoutResult() == null || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return;
            }
            long m3842plusMKHz9U = Offset.m3842plusMKHz9U(this.dragTotalDistance, j);
            this.dragTotalDistance = m3842plusMKHz9U;
            final long m3842plusMKHz9U2 = Offset.m3842plusMKHz9U(this.dragBeginPosition, m3842plusMKHz9U);
            TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDrag$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Touch.onDrag at " + ((Object) Offset.m3845toStringimpl(m3842plusMKHz9U2));
                }
            });
            if (this.dragBeginOffsetInText < 0 && !TextFieldSelectionState.this.textLayoutState.m1320isPositionOnTextk4lQ0M(m3842plusMKHz9U2)) {
                intValue = TextLayoutState.m1316getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, this.dragBeginPosition, false, 2, null);
                m1319getOffsetForPosition3MmeM6k = TextLayoutState.m1316getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, m3842plusMKHz9U2, false, 2, null);
                if (intValue == m1319getOffsetForPosition3MmeM6k) {
                    word = SelectionAdjustment.Companion.getNone();
                } else {
                    word = SelectionAdjustment.Companion.getWord();
                }
            } else {
                Integer valueOf = Integer.valueOf(this.dragBeginOffsetInText);
                if (valueOf.intValue() < 0) {
                    valueOf = null;
                }
                intValue = valueOf != null ? valueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m1319getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
                m1319getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m1319getOffsetForPosition3MmeM6k(m3842plusMKHz9U2, false);
                if (this.dragBeginOffsetInText < 0 && intValue == m1319getOffsetForPosition3MmeM6k) {
                    return;
                }
                word = SelectionAdjustment.Companion.getWord();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            }
            int i = intValue;
            int i2 = m1319getOffsetForPosition3MmeM6k;
            SelectionAdjustment selectionAdjustment = word;
            long m1203getSelectiond9O1mEE = TextFieldSelectionState.this.textFieldState.getVisualText().m1203getSelectiond9O1mEE();
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long m1384updateSelectionSsLRf8$default = TextFieldSelectionState.m1384updateSelectionSsLRf8$default(textFieldSelectionState, textFieldSelectionState.textFieldState.getVisualText(), i, i2, false, selectionAdjustment, false, false, 64, null);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6141getCollapsedimpl(m1384updateSelectionSsLRf8$default)) {
                this.dragBeginOffsetInText = TextRange.m6147getStartimpl(m1384updateSelectionSsLRf8$default);
            }
            if (TextRange.m6146getReversedimpl(m1384updateSelectionSsLRf8$default)) {
                m1384updateSelectionSsLRf8$default = TextFieldSelectionStateKt.m1400reverse5zctL8(m1384updateSelectionSsLRf8$default);
            }
            if (!TextRange.m6140equalsimpl0(m1384updateSelectionSsLRf8$default, m1203getSelectiond9O1mEE)) {
                if (TextRange.m6147getStartimpl(m1384updateSelectionSsLRf8$default) != TextRange.m6147getStartimpl(m1203getSelectiond9O1mEE) && TextRange.m6142getEndimpl(m1384updateSelectionSsLRf8$default) == TextRange.m6142getEndimpl(m1203getSelectiond9O1mEE)) {
                    handle = Handle.SelectionStart;
                } else if (TextRange.m6147getStartimpl(m1384updateSelectionSsLRf8$default) == TextRange.m6147getStartimpl(m1203getSelectiond9O1mEE) && TextRange.m6142getEndimpl(m1384updateSelectionSsLRf8$default) != TextRange.m6142getEndimpl(m1203getSelectiond9O1mEE)) {
                    handle = Handle.SelectionEnd;
                } else if ((TextRange.m6147getStartimpl(m1384updateSelectionSsLRf8$default) + TextRange.m6142getEndimpl(m1384updateSelectionSsLRf8$default)) / 2.0f > (TextRange.m6147getStartimpl(m1203getSelectiond9O1mEE) + TextRange.m6142getEndimpl(m1203getSelectiond9O1mEE)) / 2.0f) {
                    handle = Handle.SelectionEnd;
                } else {
                    handle = Handle.SelectionStart;
                }
                this.actingHandle = handle;
            }
            if (TextRange.m6141getCollapsedimpl(m1203getSelectiond9O1mEE) || !TextRange.m6141getCollapsedimpl(m1384updateSelectionSsLRf8$default)) {
                TextFieldSelectionState.this.textFieldState.m1336selectCharsIn5zctL8(m1384updateSelectionSsLRf8$default);
            }
            TextFieldSelectionState.this.m1386updateHandleDraggingUv8p0NA(this.actingHandle, m3842plusMKHz9U2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectSelectionHandleDragGestures(PointerInputScope pointerInputScope, final boolean z, Continuation<? super Unit> continuation) {
        TextFieldSelectionState$detectSelectionHandleDragGestures$1 textFieldSelectionState$detectSelectionHandleDragGestures$1;
        int i;
        final TextFieldSelectionState textFieldSelectionState;
        final Handle handle;
        Ref.LongRef longRef;
        Ref.LongRef longRef2;
        if (continuation instanceof TextFieldSelectionState$detectSelectionHandleDragGestures$1) {
            textFieldSelectionState$detectSelectionHandleDragGestures$1 = (TextFieldSelectionState$detectSelectionHandleDragGestures$1) continuation;
            if ((textFieldSelectionState$detectSelectionHandleDragGestures$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$detectSelectionHandleDragGestures$1.label -= Integer.MIN_VALUE;
                TextFieldSelectionState$detectSelectionHandleDragGestures$1 textFieldSelectionState$detectSelectionHandleDragGestures$12 = textFieldSelectionState$detectSelectionHandleDragGestures$1;
                Object obj = textFieldSelectionState$detectSelectionHandleDragGestures$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$detectSelectionHandleDragGestures$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.LongRef longRef3 = new Ref.LongRef();
                    longRef3.element = Offset.Companion.m3852getUnspecifiedF1C5BW0();
                    final Ref.LongRef longRef4 = new Ref.LongRef();
                    longRef4.element = Offset.Companion.m3853getZeroF1C5BW0();
                    final Handle handle2 = z ? Handle.SelectionStart : Handle.SelectionEnd;
                    try {
                        try {
                            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m1395invokek4lQ0M(offset.m3847unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                                public final void m1395invokek4lQ0M(long j) {
                                    long m1376getHandlePositiontuRUvjQ;
                                    Ref.LongRef longRef5 = Ref.LongRef.this;
                                    m1376getHandlePositiontuRUvjQ = this.m1376getHandlePositiontuRUvjQ(z);
                                    longRef5.element = SelectionHandlesKt.m1468getAdjustedCoordinatesk4lQ0M(m1376getHandlePositiontuRUvjQ);
                                    this.m1386updateHandleDraggingUv8p0NA(handle2, Ref.LongRef.this.element);
                                    longRef4.element = Offset.Companion.m3853getZeroF1C5BW0();
                                    this.previousRawDragOffset = -1;
                                }
                            };
                            handle2 = handle2;
                            longRef3 = longRef3;
                            Function1<Offset, Unit> function12 = function1;
                            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$3
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$6(Ref.LongRef.this, this, longRef4);
                                }
                            };
                            Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    TextFieldSelectionState.detectSelectionHandleDragGestures$onDragStop$6(Ref.LongRef.this, this, longRef4);
                                }
                            };
                            try {
                                Function2<PointerInputChange, Offset, Unit> function2 = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$5
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                                        m1396invokeUv8p0NA(pointerInputChange, offset.m3847unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
                                    public final void m1396invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                                        int m6147getStartimpl;
                                        int m6117getOffsetForPositionk4lQ0M;
                                        Ref.LongRef longRef5 = Ref.LongRef.this;
                                        longRef5.element = Offset.m3842plusMKHz9U(longRef5.element, j);
                                        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
                                        if (layoutResult == null) {
                                            return;
                                        }
                                        this.m1386updateHandleDraggingUv8p0NA(handle2, Offset.m3842plusMKHz9U(longRef3.element, Ref.LongRef.this.element));
                                        if (!z) {
                                            m6147getStartimpl = TextRange.m6147getStartimpl(this.textFieldState.getVisualText().m1203getSelectiond9O1mEE());
                                        } else {
                                            m6147getStartimpl = layoutResult.m6117getOffsetForPositionk4lQ0M(this.m1385getHandleDragPositionF1C5BW0());
                                        }
                                        int i2 = m6147getStartimpl;
                                        if (z) {
                                            m6117getOffsetForPositionk4lQ0M = TextRange.m6142getEndimpl(this.textFieldState.getVisualText().m1203getSelectiond9O1mEE());
                                        } else {
                                            m6117getOffsetForPositionk4lQ0M = layoutResult.m6117getOffsetForPositionk4lQ0M(this.m1385getHandleDragPositionF1C5BW0());
                                        }
                                        int i3 = m6117getOffsetForPositionk4lQ0M;
                                        long m1203getSelectiond9O1mEE = this.textFieldState.getVisualText().m1203getSelectiond9O1mEE();
                                        TextFieldSelectionState textFieldSelectionState2 = this;
                                        long m1384updateSelectionSsLRf8$default = TextFieldSelectionState.m1384updateSelectionSsLRf8$default(textFieldSelectionState2, textFieldSelectionState2.textFieldState.getVisualText(), i2, i3, z, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), false, false, 96, null);
                                        if (TextRange.m6141getCollapsedimpl(m1203getSelectiond9O1mEE) || !TextRange.m6141getCollapsedimpl(m1384updateSelectionSsLRf8$default)) {
                                            this.textFieldState.m1336selectCharsIn5zctL8(m1384updateSelectionSsLRf8$default);
                                        }
                                    }
                                };
                                longRef4 = longRef4;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$0 = this;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$1 = longRef3;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$2 = longRef4;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$3 = handle2;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.label = 1;
                                if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function12, function0, function02, function2, textFieldSelectionState$detectSelectionHandleDragGestures$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                textFieldSelectionState = this;
                                handle = handle2;
                                longRef = longRef3;
                                longRef2 = longRef4;
                            } catch (Throwable th) {
                                th = th;
                                longRef4 = longRef4;
                                textFieldSelectionState = this;
                                handle = handle2;
                                longRef = longRef3;
                                longRef2 = longRef4;
                                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                                    }
                                });
                                if (textFieldSelectionState.getDraggingHandle() == handle) {
                                    detectSelectionHandleDragGestures$onDragStop$6(longRef, textFieldSelectionState, longRef2);
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            handle2 = handle2;
                            longRef3 = longRef3;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    handle = (Handle) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$3;
                    longRef2 = (Ref.LongRef) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$2;
                    longRef = (Ref.LongRef) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$1;
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                            }
                        });
                        if (textFieldSelectionState.getDraggingHandle() == handle) {
                        }
                        throw th;
                    }
                }
                TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
                    }
                });
                if (textFieldSelectionState.getDraggingHandle() == handle) {
                    detectSelectionHandleDragGestures$onDragStop$6(longRef, textFieldSelectionState, longRef2);
                }
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$detectSelectionHandleDragGestures$1 = new TextFieldSelectionState$detectSelectionHandleDragGestures$1(this, continuation);
        TextFieldSelectionState$detectSelectionHandleDragGestures$1 textFieldSelectionState$detectSelectionHandleDragGestures$122 = textFieldSelectionState$detectSelectionHandleDragGestures$1;
        Object obj2 = textFieldSelectionState$detectSelectionHandleDragGestures$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$detectSelectionHandleDragGestures$122.label;
        if (i != 0) {
        }
        TextFieldSelectionStateKt.logDebug(new Function0<String>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$6
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Selection Handle drag cancelled for draggingHandle: " + TextFieldSelectionState.this.getDraggingHandle() + " definedOn: " + handle;
            }
        });
        if (textFieldSelectionState.getDraggingHandle() == handle) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$6(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if ((longRef.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            textFieldSelectionState.clearHandleDragging();
            longRef.element = Offset.Companion.m3852getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m3853getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0<TextFieldCharSequence>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldCharSequence invoke() {
                return TextFieldSelectionState.this.textFieldState.getVisualText();
            }
        }), TextFieldSelectionState$observeTextChanges$3.INSTANCE), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((TextFieldCharSequence) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(TextFieldCharSequence textFieldCharSequence, Continuation<? super Unit> continuation2) {
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.None);
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new Function0<Rect>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
                if (r6.this$0.getDraggingHandle() != null) goto L30;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
                if (r6.this$0.isInTouchMode() == false) goto L30;
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
                r0 = r6.this$0.getTextLayoutCoordinates();
                r1 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
                if (r0 == null) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
                r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
                r0 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
                if (r0 == null) goto L27;
             */
            /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
                r2 = r6.this$0.getTextLayoutCoordinates();
             */
            /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
                if (r2 == null) goto L26;
             */
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
                r2 = androidx.compose.ui.geometry.Offset.m3826boximpl(r2.mo5449localToRootMKHz9U(r0.m3872getTopLeftF1C5BW0()));
             */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
                r2 = null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
                r0 = androidx.compose.ui.geometry.RectKt.m3877Recttz77jQw(r2.m3847unboximpl(), r0.m3870getSizeNHjbRc());
                r2 = r6.this$0.getContentRect();
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
                if (r0.overlaps(r2) == false) goto L19;
             */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
                r1 = r2;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x007d, code lost:
                if (r1 == null) goto L24;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
                r0 = r1.intersect(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0083, code lost:
                if (r0 == null) goto L24;
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
                return r0;
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
                return androidx.compose.ui.geometry.Rect.Companion.getZero();
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
                return androidx.compose.ui.geometry.Rect.Companion.getZero();
             */
            /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
                if (r1 != androidx.compose.foundation.text.input.internal.selection.TextToolbarState.Cursor) goto L32;
             */
            /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
                if (r0 == androidx.compose.foundation.text.input.internal.selection.TextToolbarState.Selection) goto L5;
             */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Rect invoke() {
                TextToolbarState textToolbarState;
                TextToolbarState textToolbarState2;
                boolean m6141getCollapsedimpl = TextRange.m6141getCollapsedimpl(TextFieldSelectionState.this.textFieldState.getVisualText().m1203getSelectiond9O1mEE());
                if (m6141getCollapsedimpl) {
                    textToolbarState2 = TextFieldSelectionState.this.getTextToolbarState();
                }
                if (!m6141getCollapsedimpl) {
                    textToolbarState = TextFieldSelectionState.this.getTextToolbarState();
                }
                return Rect.Companion.getZero();
            }
        }).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Rect) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation2) {
                TextToolbarHandler textToolbarHandler;
                if (Intrinsics.areEqual(rect, Rect.Companion.getZero())) {
                    TextFieldSelectionState.this.hideTextToolbar();
                } else {
                    textToolbarHandler = TextFieldSelectionState.this.textToolbarHandler;
                    if (textToolbarHandler != null) {
                        Object showTextToolbar = textToolbarHandler.showTextToolbar(TextFieldSelectionState.this, rect, continuation2);
                        return showTextToolbar == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showTextToolbar : Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        float f;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m6141getCollapsedimpl(visualText.m1203getSelectiond9O1mEE())) {
            Rect cursorRect3 = getCursorRect();
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            return RectKt.m3877Recttz77jQw(textLayoutCoordinates != null ? textLayoutCoordinates.mo5449localToRootMKHz9U(cursorRect3.m3872getTopLeftF1C5BW0()) : Offset.Companion.m3853getZeroF1C5BW0(), cursorRect3.m3870getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long mo5449localToRootMKHz9U = textLayoutCoordinates2 != null ? textLayoutCoordinates2.mo5449localToRootMKHz9U(m1376getHandlePositiontuRUvjQ(true)) : Offset.Companion.m3853getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long mo5449localToRootMKHz9U2 = textLayoutCoordinates3 != null ? textLayoutCoordinates3.mo5449localToRootMKHz9U(m1376getHandlePositiontuRUvjQ(false)) : Offset.Companion.m3853getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float f2 = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            f = Float.intBitsToFloat((int) (textLayoutCoordinates4.mo5449localToRootMKHz9U(Offset.m3829constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits((layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m6147getStartimpl(visualText.m1203getSelectiond9O1mEE()))) == null) ? 0.0f : cursorRect2.getTop()) & 4294967295L))) & 4294967295L));
        } else {
            f = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            f2 = Float.intBitsToFloat((int) (textLayoutCoordinates5.mo5449localToRootMKHz9U(Offset.m3829constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits((layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m6142getEndimpl(visualText.m1203getSelectiond9O1mEE()))) == null) ? 0.0f : cursorRect.getTop()) & 4294967295L))) & 4294967295L));
        }
        int i = (int) (mo5449localToRootMKHz9U >> 32);
        int i2 = (int) (mo5449localToRootMKHz9U2 >> 32);
        return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(f, f2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (mo5449localToRootMKHz9U & 4294967295L)), Float.intBitsToFloat((int) (mo5449localToRootMKHz9U2 & 4294967295L))));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (((r0 == null || (r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)) == null) ? false : androidx.compose.foundation.text.selection.SelectionManagerKt.m1504containsInclusiveUv8p0NA(r0, r4)) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TextFieldHandleState getSelectionHandleState$foundation_release(boolean z, boolean z2) {
        Rect visibleBounds;
        Handle handle = z ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.Companion.getHidden();
        }
        long m1203getSelectiond9O1mEE = this.textFieldState.getVisualText().m1203getSelectiond9O1mEE();
        if (TextRange.m6141getCollapsedimpl(m1203getSelectiond9O1mEE)) {
            return TextFieldHandleState.Companion.getHidden();
        }
        long m1376getHandlePositiontuRUvjQ = m1376getHandlePositiontuRUvjQ(z);
        if (getDirectDragGestureInitiator() == InputType.None) {
            if (getDraggingHandle() != handle) {
                LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            }
            if (this.textFieldState.getVisualText().shouldShowSelection()) {
                ResolvedTextDirection bidiRunDirection = layoutResult.getBidiRunDirection(z ? TextRange.m6147getStartimpl(m1203getSelectiond9O1mEE) : Math.max(TextRange.m6142getEndimpl(m1203getSelectiond9O1mEE) - 1, 0));
                boolean m6146getReversedimpl = TextRange.m6146getReversedimpl(m1203getSelectiond9O1mEE);
                if (z2) {
                    LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
                    if (textLayoutCoordinates2 != null && (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates2)) != null) {
                        m1376getHandlePositiontuRUvjQ = TextLayoutStateKt.m1323coerceIn3MmeM6k(m1376getHandlePositiontuRUvjQ, visibleBounds);
                    }
                } else {
                    m1376getHandlePositiontuRUvjQ = Offset.Companion.m3852getUnspecifiedF1C5BW0();
                }
                return new TextFieldHandleState(true, m1376getHandlePositiontuRUvjQ, TextLayoutHelperKt.getLineHeight(layoutResult, z ? TextRange.m6147getStartimpl(m1203getSelectiond9O1mEE) : TextRange.m6142getEndimpl(m1203getSelectiond9O1mEE)), bidiRunDirection, m6146getReversedimpl, null);
            }
            return TextFieldHandleState.Companion.getHidden();
        }
        return TextFieldHandleState.Companion.getHidden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ  reason: not valid java name */
    public final long m1376getHandlePositiontuRUvjQ(boolean z) {
        int m6142getEndimpl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.Companion.m3853getZeroF1C5BW0();
        }
        long m1203getSelectiond9O1mEE = this.textFieldState.getVisualText().m1203getSelectiond9O1mEE();
        if (z) {
            m6142getEndimpl = TextRange.m6147getStartimpl(m1203getSelectiond9O1mEE);
        } else {
            m6142getEndimpl = TextRange.m6142getEndimpl(m1203getSelectiond9O1mEE);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, m6142getEndimpl, z, TextRange.m6146getReversedimpl(m1203getSelectiond9O1mEE));
    }

    /* renamed from: updateHandleDragging-Uv8p0NA  reason: not valid java name */
    public final void m1386updateHandleDraggingUv8p0NA(Handle handle, long j) {
        setDraggingHandle(handle);
        m1381setRawHandleDragPositionk4lQ0M(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        m1382setStartTextLayoutPositionInWindowk4lQ0M(m1375getCurrentTextLayoutPositionInWindowF1C5BW0());
    }

    public final void clearHandleDragging() {
        setDraggingHandle(null);
        m1381setRawHandleDragPositionk4lQ0M(Offset.Companion.m3852getUnspecifiedF1C5BW0());
        m1382setStartTextLayoutPositionInWindowk4lQ0M(Offset.Companion.m3852getUnspecifiedF1C5BW0());
    }

    public final boolean canCut() {
        return (TextRange.m6141getCollapsedimpl(this.textFieldState.getVisualText().m1203getSelectiond9O1mEE()) || !getEditable() || this.isPassword) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object cut(Continuation<? super Unit> continuation) {
        TextFieldSelectionState$cut$1 textFieldSelectionState$cut$1;
        int i;
        TextFieldSelectionState textFieldSelectionState;
        if (continuation instanceof TextFieldSelectionState$cut$1) {
            textFieldSelectionState$cut$1 = (TextFieldSelectionState$cut$1) continuation;
            if ((textFieldSelectionState$cut$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$cut$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionState$cut$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$cut$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TextFieldCharSequence visualText = this.textFieldState.getVisualText();
                    if (TextRange.m6141getCollapsedimpl(visualText.m1203getSelectiond9O1mEE())) {
                        return Unit.INSTANCE;
                    }
                    AnnotatedString annotatedString = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), null, 2, null);
                    Clipboard clipboard = this.clipboard;
                    if (clipboard != null) {
                        ClipEntry clipEntry = ClipboardUtils_androidKt.toClipEntry(annotatedString);
                        textFieldSelectionState$cut$1.L$0 = this;
                        textFieldSelectionState$cut$1.label = 1;
                        if (clipboard.setClipEntry(clipEntry, textFieldSelectionState$cut$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    textFieldSelectionState = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$cut$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                textFieldSelectionState.textFieldState.deleteSelectedText();
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$cut$1 = new TextFieldSelectionState$cut$1(this, continuation);
        Object obj2 = textFieldSelectionState$cut$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$cut$1.label;
        if (i != 0) {
        }
        textFieldSelectionState.textFieldState.deleteSelectedText();
        return Unit.INSTANCE;
    }

    public final boolean canCopy() {
        return (TextRange.m6141getCollapsedimpl(this.textFieldState.getVisualText().m1203getSelectiond9O1mEE()) || this.isPassword) ? false : true;
    }

    public static /* synthetic */ Object copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionState.copy(z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object copy(boolean z, Continuation<? super Unit> continuation) {
        TextFieldSelectionState$copy$1 textFieldSelectionState$copy$1;
        int i;
        TextFieldSelectionState textFieldSelectionState;
        if (continuation instanceof TextFieldSelectionState$copy$1) {
            textFieldSelectionState$copy$1 = (TextFieldSelectionState$copy$1) continuation;
            if ((textFieldSelectionState$copy$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$copy$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionState$copy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$copy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TextFieldCharSequence visualText = this.textFieldState.getVisualText();
                    if (TextRange.m6141getCollapsedimpl(visualText.m1203getSelectiond9O1mEE())) {
                        return Unit.INSTANCE;
                    }
                    AnnotatedString annotatedString = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), null, 2, null);
                    Clipboard clipboard = this.clipboard;
                    if (clipboard != null) {
                        ClipEntry clipEntry = ClipboardUtils_androidKt.toClipEntry(annotatedString);
                        textFieldSelectionState$copy$1.L$0 = this;
                        textFieldSelectionState$copy$1.Z$0 = z;
                        textFieldSelectionState$copy$1.label = 1;
                        if (clipboard.setClipEntry(clipEntry, textFieldSelectionState$copy$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    textFieldSelectionState = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    z = textFieldSelectionState$copy$1.Z$0;
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$copy$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (z) {
                    return Unit.INSTANCE;
                }
                textFieldSelectionState.textFieldState.collapseSelectionToMax();
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$copy$1 = new TextFieldSelectionState$copy$1(this, continuation);
        Object obj2 = textFieldSelectionState$copy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$copy$1.label;
        if (i != 0) {
        }
        if (z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:
        if (r8 == r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object canPaste(Continuation<? super Boolean> continuation) {
        TextFieldSelectionState$canPaste$1 textFieldSelectionState$canPaste$1;
        int i;
        TextFieldSelectionState textFieldSelectionState;
        boolean z;
        ClipEntry clipEntry;
        ClipEntry clipEntry2;
        if (continuation instanceof TextFieldSelectionState$canPaste$1) {
            textFieldSelectionState$canPaste$1 = (TextFieldSelectionState$canPaste$1) continuation;
            if ((textFieldSelectionState$canPaste$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$canPaste$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionState$canPaste$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$canPaste$1.label;
                boolean z2 = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (getEditable()) {
                        Clipboard clipboard = this.clipboard;
                        if (clipboard != null) {
                            textFieldSelectionState$canPaste$1.L$0 = this;
                            textFieldSelectionState$canPaste$1.label = 1;
                            obj = clipboard.getClipEntry(textFieldSelectionState$canPaste$1);
                            if (obj != coroutine_suspended) {
                                textFieldSelectionState = this;
                            }
                            return coroutine_suspended;
                        }
                        textFieldSelectionState = this;
                        z = false;
                        if (z) {
                            return Boxing.boxBoolean(true);
                        }
                        Function0<? extends ReceiveContentConfiguration> function0 = textFieldSelectionState.receiveContentConfiguration;
                        clipEntry = null;
                        if ((function0 != null ? function0.invoke() : null) != null) {
                            Clipboard clipboard2 = textFieldSelectionState.clipboard;
                            if (clipboard2 != null) {
                                textFieldSelectionState$canPaste$1.L$0 = null;
                                textFieldSelectionState$canPaste$1.label = 2;
                                obj = clipboard2.getClipEntry(textFieldSelectionState$canPaste$1);
                            }
                            if (clipEntry != null) {
                            }
                        }
                        return Boxing.boxBoolean(z2);
                    }
                    return Boxing.boxBoolean(false);
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        clipEntry = (ClipEntry) obj;
                        if (clipEntry != null) {
                            z2 = true;
                        }
                        return Boxing.boxBoolean(z2);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$canPaste$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                clipEntry2 = (ClipEntry) obj;
                if (clipEntry2 != null && ClipboardUtils_androidKt.hasText(clipEntry2)) {
                    z = true;
                    if (z) {
                    }
                }
                z = false;
                if (z) {
                }
            }
        }
        textFieldSelectionState$canPaste$1 = new TextFieldSelectionState$canPaste$1(this, continuation);
        Object obj2 = textFieldSelectionState$canPaste$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$canPaste$1.label;
        boolean z22 = false;
        if (i != 0) {
        }
        clipEntry2 = (ClipEntry) obj2;
        if (clipEntry2 != null) {
            z = true;
            if (z) {
            }
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (r4.pasteAsPlainText(r0) != r1) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c6, code lost:
        if (pasteAsPlainText(r0) == r1) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object paste(Continuation<? super Unit> continuation) {
        TextFieldSelectionState$paste$1 textFieldSelectionState$paste$1;
        int i;
        ReceiveContentConfiguration invoke;
        TextFieldSelectionState textFieldSelectionState;
        ClipEntry clipEntry;
        ClipEntry clipEntry2;
        String readPlainText;
        if (continuation instanceof TextFieldSelectionState$paste$1) {
            textFieldSelectionState$paste$1 = (TextFieldSelectionState$paste$1) continuation;
            if ((textFieldSelectionState$paste$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$paste$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionState$paste$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$paste$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
                    if (function0 == null || (invoke = function0.invoke()) == null) {
                        textFieldSelectionState$paste$1.label = 1;
                    } else {
                        Clipboard clipboard = this.clipboard;
                        if (clipboard != null) {
                            textFieldSelectionState$paste$1.L$0 = this;
                            textFieldSelectionState$paste$1.L$1 = invoke;
                            textFieldSelectionState$paste$1.label = 2;
                            obj = clipboard.getClipEntry(textFieldSelectionState$paste$1);
                            if (obj != coroutine_suspended) {
                                textFieldSelectionState = this;
                                clipEntry = (ClipEntry) obj;
                                if (clipEntry != null) {
                                }
                            }
                        } else {
                            textFieldSelectionState = this;
                        }
                    }
                    return coroutine_suspended;
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                } else if (i != 2) {
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    invoke = (ReceiveContentConfiguration) textFieldSelectionState$paste$1.L$1;
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$paste$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    clipEntry = (ClipEntry) obj;
                    if (clipEntry != null) {
                        TransferableContent onReceive = invoke.getReceiveContentListener().onReceive(new TransferableContent(clipEntry, clipEntry.getClipMetadata(), TransferableContent.Source.Companion.m348getClipboardkB6V9T0(), null, 8, null));
                        if (onReceive != null && (clipEntry2 = onReceive.getClipEntry()) != null && (readPlainText = TransferableContent_androidKt.readPlainText(clipEntry2)) != null) {
                            TransformedTextFieldState.replaceSelectedText$default(textFieldSelectionState.textFieldState, readPlainText, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
                        }
                        return Unit.INSTANCE;
                    }
                }
                textFieldSelectionState$paste$1.L$0 = null;
                textFieldSelectionState$paste$1.L$1 = null;
                textFieldSelectionState$paste$1.label = 3;
            }
        }
        textFieldSelectionState$paste$1 = new TextFieldSelectionState$paste$1(this, continuation);
        Object obj2 = textFieldSelectionState$paste$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$paste$1.label;
        if (i != 0) {
        }
        textFieldSelectionState$paste$1.L$0 = null;
        textFieldSelectionState$paste$1.L$1 = null;
        textFieldSelectionState$paste$1.label = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pasteAsPlainText(Continuation<? super Unit> continuation) {
        TextFieldSelectionState$pasteAsPlainText$1 textFieldSelectionState$pasteAsPlainText$1;
        int i;
        TextFieldSelectionState textFieldSelectionState;
        ClipEntry clipEntry;
        String readText;
        if (continuation instanceof TextFieldSelectionState$pasteAsPlainText$1) {
            textFieldSelectionState$pasteAsPlainText$1 = (TextFieldSelectionState$pasteAsPlainText$1) continuation;
            if ((textFieldSelectionState$pasteAsPlainText$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionState$pasteAsPlainText$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionState$pasteAsPlainText$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionState$pasteAsPlainText$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Clipboard clipboard = this.clipboard;
                    if (clipboard != null) {
                        textFieldSelectionState$pasteAsPlainText$1.L$0 = this;
                        textFieldSelectionState$pasteAsPlainText$1.label = 1;
                        obj = clipboard.getClipEntry(textFieldSelectionState$pasteAsPlainText$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        textFieldSelectionState = this;
                    }
                    return Unit.INSTANCE;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    textFieldSelectionState = (TextFieldSelectionState) textFieldSelectionState$pasteAsPlainText$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                clipEntry = (ClipEntry) obj;
                if (clipEntry != null && (readText = ClipboardUtils_androidKt.readText(clipEntry)) != null) {
                    TransformedTextFieldState.replaceSelectedText$default(textFieldSelectionState.textFieldState, readText, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionState$pasteAsPlainText$1 = new TextFieldSelectionState$pasteAsPlainText$1(this, continuation);
        Object obj2 = textFieldSelectionState$pasteAsPlainText$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$pasteAsPlainText$1.label;
        if (i != 0) {
        }
        clipEntry = (ClipEntry) obj2;
        if (clipEntry != null) {
            TransformedTextFieldState.replaceSelectedText$default(textFieldSelectionState.textFieldState, readText, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final boolean canSelectAll() {
        return TextRange.m6143getLengthimpl(this.textFieldState.getVisualText().m1203getSelectiond9O1mEE()) != this.textFieldState.getVisualText().length();
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    public final boolean canAutofill() {
        return getEditable() && TextRange.m6141getCollapsedimpl(this.textFieldState.getVisualText().m1203getSelectiond9O1mEE());
    }

    public final void autofill() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void deselect() {
        if (!TextRange.m6141getCollapsedimpl(this.textFieldState.getVisualText().m1203getSelectiond9O1mEE())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbarHandler textToolbarHandler = this.textToolbarHandler;
        if (textToolbarHandler != null) {
            textToolbarHandler.hideTextToolbar();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: updateSelection-SsL-Rf8$default  reason: not valid java name */
    public static /* synthetic */ long m1384updateSelectionSsLRf8$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        if ((i3 & 64) != 0) {
            z3 = false;
        }
        return textFieldSelectionState.m1383updateSelectionSsLRf8(textFieldCharSequence, i, i2, z, selectionAdjustment, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-SsL-Rf8  reason: not valid java name */
    public final long m1383updateSelectionSsLRf8(TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3) {
        HapticFeedback hapticFeedback;
        TextRange m6135boximpl = TextRange.m6135boximpl(textFieldCharSequence.m1203getSelectiond9O1mEE());
        long m6151unboximpl = m6135boximpl.m6151unboximpl();
        if (z3 || (!z2 && TextRange.m6141getCollapsedimpl(m6151unboximpl))) {
            m6135boximpl = null;
        }
        long m1379getTextFieldSelectionqeG_v_k = m1379getTextFieldSelectionqeG_v_k(i, i2, m6135boximpl, z, selectionAdjustment);
        if (!TextRange.m6140equalsimpl0(m1379getTextFieldSelectionqeG_v_k, textFieldCharSequence.m1203getSelectiond9O1mEE())) {
            boolean z4 = TextRange.m6146getReversedimpl(m1379getTextFieldSelectionqeG_v_k) != TextRange.m6146getReversedimpl(textFieldCharSequence.m1203getSelectiond9O1mEE()) && TextRange.m6140equalsimpl0(TextRangeKt.TextRange(TextRange.m6142getEndimpl(m1379getTextFieldSelectionqeG_v_k), TextRange.m6147getStartimpl(m1379getTextFieldSelectionqeG_v_k)), textFieldCharSequence.m1203getSelectiond9O1mEE());
            if (isInTouchMode() && !z4 && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo4812performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4828getTextHandleMove5zf0vsI());
            }
        }
        return m1379getTextFieldSelectionqeG_v_k;
    }

    /* renamed from: getTextFieldSelection-qeG_v_k  reason: not valid java name */
    private final long m1379getTextFieldSelectionqeG_v_k(int i, int i2, TextRange textRange, boolean z, SelectionAdjustment selectionAdjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.Companion.m6152getZerod9O1mEE();
        }
        if (textRange == null && Intrinsics.areEqual(selectionAdjustment, SelectionAdjustment.Companion.getCharacter())) {
            return TextRangeKt.TextRange(i, i2);
        }
        SelectionLayout m1471getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1471getTextFieldSelectionLayoutRcvTLA(layoutResult, i, i2, this.previousRawDragOffset, textRange != null ? textRange.m6151unboximpl() : TextRange.Companion.m6152getZerod9O1mEE(), textRange == null, z);
        if (textRange != null && !m1471getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return textRange.m6151unboximpl();
        }
        long m1459toTextRanged9O1mEE = selectionAdjustment.adjust(m1471getTextFieldSelectionLayoutRcvTLA).m1459toTextRanged9O1mEE();
        this.previousSelectionLayout = m1471getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = z ? i : i2;
        return m1459toTextRanged9O1mEE;
    }
}
