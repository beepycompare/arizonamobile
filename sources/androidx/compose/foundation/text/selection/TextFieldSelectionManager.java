package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\r\u0010|\u001a\u00020LH\u0000¢\u0006\u0002\b}J\r\u0010~\u001a\u00020LH\u0000¢\u0006\u0002\b\u007fJ\u001d\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\t\b\u0002\u0010\u0082\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b\u0083\u0001J(\u0010\u0084\u0001\u001a\u00020I2\u0007\u0010\u0085\u0001\u001a\u00020k2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u000f\u0010\u008a\u0001\u001a\u00020gH\u0000¢\u0006\u0003\b\u008b\u0001J\u0012\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0000¢\u0006\u0003\b\u008d\u0001J\u001f\u0010\u008e\u0001\u001a\u00020L2\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0012H\u0000ø\u0001\u0000¢\u0006\u0003\b\u0090\u0001J\u001a\u0010\u0091\u0001\u001a\u00020L2\t\b\u0002\u0010\u0092\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b\u0093\u0001J\u000f\u0010\u0094\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b\u0095\u0001J\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\"\u0010\u0098\u0001\u001a\u00020\u00122\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0019\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b \u0001J!\u0010¡\u0001\u001a\u00020\u00122\u0007\u0010\u009f\u0001\u001a\u00020'H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0018\u0010¤\u0001\u001a\u00020g2\u0007\u0010\u009f\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b¥\u0001J\u000f\u0010¦\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b§\u0001J\u000f\u0010¨\u0001\u001a\u00020'H\u0000¢\u0006\u0003\b©\u0001J\u0012\u0010ª\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0000¢\u0006\u0003\b«\u0001J\u000f\u0010¬\u0001\u001a\u00020LH\u0000¢\u0006\u0003\b\u00ad\u0001J\u001c\u0010®\u0001\u001a\u00020L2\u0007\u0010\u008f\u0001\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001f\u0010±\u0001\u001a\u00020L2\b\u0010²\u0001\u001a\u00030\u0087\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b³\u0001\u0010°\u0001J\u0013\u0010´\u0001\u001a\u00020L2\b\u0010µ\u0001\u001a\u00030¶\u0001H\u0002J\u001f\u0010·\u0001\u001a\u00020L2\b\u0010²\u0001\u001a\u00030\u0087\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b¸\u0001\u0010°\u0001J\u0012\u0010¹\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0000¢\u0006\u0003\bº\u0001J\u0012\u0010»\u0001\u001a\u00020L2\u0007\u0010¼\u0001\u001a\u00020'H\u0002JL\u0010½\u0001\u001a\u00030\u0087\u00012\u0006\u0010p\u001a\u00020I2\u0007\u0010¾\u0001\u001a\u00020\u00122\u0007\u0010¿\u0001\u001a\u00020'2\u0007\u0010\u009f\u0001\u001a\u00020'2\b\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R5\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u00128F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u0012X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u0012X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001eR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u0011\u001a\u0004\u0018\u00010 8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R+\u0010(\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010.\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0019\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020?X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020CX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020L0KX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010T\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010UX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0004\u0018\u00010[X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001c\u0010`\u001a\u0004\u0018\u00010aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0016\u0010j\u001a\u0004\u0018\u00010k8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR+\u0010p\u001a\u00020I2\u0006\u0010\u0011\u001a\u00020I8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bu\u0010\u0019\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010v\u001a\u00020wX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Å\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "(Landroidx/compose/foundation/text/UndoManager;)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "getClipboard$foundation_release", "()Landroidx/compose/ui/platform/Clipboard;", "setClipboard$foundation_release", "(Landroidx/compose/ui/platform/Clipboard;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation_release", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "Landroidx/compose/runtime/MutableState;", "dragBeginOffsetInText", "", "Ljava/lang/Integer;", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "previousRawDragOffset", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "requestAutofillAction", "Lkotlin/Function0;", "getRequestAutofillAction$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "value$delegate", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "autofill", "autofill$foundation_release", "clearPreviewHighlight", "clearPreviewHighlight$foundation_release", "copy", "Lkotlinx/coroutines/Job;", "cancelSelection", "copy$foundation_release", "createTextFieldValue", "annotatedString", "selection", "Landroidx/compose/ui/text/TextRange;", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "cursorDragObserver", "cursorDragObserver$foundation_release", "cut", "cut$foundation_release", "deselect", "position", "deselect-_kEHs6E$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getHandleLineHeight", "", "isStartHandle", "getHandleLineHeight$foundation_release", "getHandlePosition", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "handleDragObserver", "handleDragObserver$foundation_release", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "isTextChanged", "isTextChanged$foundation_release", "paste", "paste$foundation_release", "selectAll", "selectAll$foundation_release", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "(J)V", "setDeletionPreviewHighlight", "range", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "setSelectionPreviewHighlight", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "updateFloatingToolbar", "show", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private CoroutineScope coroutineScope;
    private final MutableState currentDragPosition$delegate;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private final MutableState enabled$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private Function0<Unit> requestAutofillAction;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState value$delegate;
    private VisualTransformation visualTransformation;

    public TextFieldSelectionManager() {
        this(null, 1, null);
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue textFieldValue) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.value$delegate = mutableStateOf$default;
        this.visualTransformation = VisualTransformation.Companion.getNone();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.editable$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.enabled$delegate = mutableStateOf$default3;
        this.dragBeginPosition = Offset.Companion.m3853getZeroF1C5BW0();
        this.dragTotalDistance = Offset.Companion.m3853getZeroF1C5BW0();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = mutableStateOf$default5;
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1146onDownk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1148onStartk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                TextFieldValue m1518createTextFieldValueFDrldGo;
                long j3;
                TextLayoutResultProxy layoutResult2;
                long m1521updateSelection8UEBfa8;
                if (TextFieldSelectionManager.this.getEnabled() && TextFieldSelectionManager.this.getDraggingHandle() == null) {
                    TextFieldSelectionManager.this.setDraggingHandle(Handle.SelectionEnd);
                    TextFieldSelectionManager.this.previousRawDragOffset = -1;
                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                    if (state$foundation_release == null || (layoutResult2 = state$foundation_release.getLayoutResult()) == null || !layoutResult2.m1181isPositionOnTextk4lQ0M(j)) {
                        j2 = j;
                        LegacyTextFieldState state$foundation_release2 = TextFieldSelectionManager.this.getState$foundation_release();
                        if (state$foundation_release2 != null && (layoutResult = state$foundation_release2.getLayoutResult()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                            int transformedToOriginal = textFieldSelectionManager.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.m1179getOffsetForPosition3MmeM6k$default(layoutResult, j2, false, 2, null));
                            m1518createTextFieldValueFDrldGo = textFieldSelectionManager.m1518createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                            HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                            if (hapticFeedBack != null) {
                                hapticFeedBack.mo4812performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4828getTextHandleMove5zf0vsI());
                            }
                            textFieldSelectionManager.getOnValueChange$foundation_release().invoke(m1518createTextFieldValueFDrldGo);
                        }
                    } else if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                        return;
                    } else {
                        TextFieldSelectionManager.this.enterSelectionMode$foundation_release(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                        m1521updateSelection8UEBfa8 = textFieldSelectionManager2.m1521updateSelection8UEBfa8(TextFieldValue.m6391copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.Companion.m6152getZerod9O1mEE(), (TextRange) null, 5, (Object) null), j, true, false, SelectionAdjustment.Companion.getWord(), true);
                        j2 = j;
                        TextFieldSelectionManager.this.dragBeginOffsetInText = Integer.valueOf(TextRange.m6147getStartimpl(m1521updateSelection8UEBfa8));
                    }
                    TextFieldSelectionManager.this.setHandleState(HandleState.None);
                    TextFieldSelectionManager.this.dragBeginPosition = j2;
                    TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                    j3 = textFieldSelectionManager3.dragBeginPosition;
                    textFieldSelectionManager3.m1520setCurrentDragPosition_kEHs6E(Offset.m3826boximpl(j3));
                    TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m3853getZeroF1C5BW0();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1147onDragk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                long j3;
                long j4;
                Integer num;
                Integer num2;
                long j5;
                int m1180getOffsetForPosition3MmeM6k;
                Integer num3;
                long m1521updateSelection8UEBfa8;
                long j6;
                SelectionAdjustment word;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m3842plusMKHz9U(j2, j);
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                    j3 = textFieldSelectionManager2.dragBeginPosition;
                    j4 = textFieldSelectionManager2.dragTotalDistance;
                    textFieldSelectionManager2.m1520setCurrentDragPosition_kEHs6E(Offset.m3826boximpl(Offset.m3842plusMKHz9U(j3, j4)));
                    num = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num == null) {
                        Offset m1523getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1523getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m1523getCurrentDragPosition_m7T9E);
                        if (!layoutResult.m1181isPositionOnTextk4lQ0M(m1523getCurrentDragPosition_m7T9E.m3847unboximpl())) {
                            OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                            j6 = textFieldSelectionManager2.dragBeginPosition;
                            int transformedToOriginal = offsetMapping$foundation_release.transformedToOriginal(TextLayoutResultProxy.m1179getOffsetForPosition3MmeM6k$default(layoutResult, j6, false, 2, null));
                            OffsetMapping offsetMapping$foundation_release2 = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                            Offset m1523getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m1523getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m1523getCurrentDragPosition_m7T9E2);
                            if (transformedToOriginal == offsetMapping$foundation_release2.transformedToOriginal(TextLayoutResultProxy.m1179getOffsetForPosition3MmeM6k$default(layoutResult, m1523getCurrentDragPosition_m7T9E2.m3847unboximpl(), false, 2, null))) {
                                word = SelectionAdjustment.Companion.getNone();
                            } else {
                                word = SelectionAdjustment.Companion.getWord();
                            }
                            SelectionAdjustment selectionAdjustment = word;
                            TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                            Offset m1523getCurrentDragPosition_m7T9E3 = textFieldSelectionManager2.m1523getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m1523getCurrentDragPosition_m7T9E3);
                            m1521updateSelection8UEBfa8 = textFieldSelectionManager2.m1521updateSelection8UEBfa8(value$foundation_release, m1523getCurrentDragPosition_m7T9E3.m3847unboximpl(), false, false, selectionAdjustment, true);
                            TextRange.m6135boximpl(m1521updateSelection8UEBfa8);
                        }
                    }
                    num2 = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num2 != null) {
                        m1180getOffsetForPosition3MmeM6k = num2.intValue();
                    } else {
                        j5 = textFieldSelectionManager2.dragBeginPosition;
                        m1180getOffsetForPosition3MmeM6k = layoutResult.m1180getOffsetForPosition3MmeM6k(j5, false);
                    }
                    Offset m1523getCurrentDragPosition_m7T9E4 = textFieldSelectionManager2.m1523getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m1523getCurrentDragPosition_m7T9E4);
                    int m1180getOffsetForPosition3MmeM6k2 = layoutResult.m1180getOffsetForPosition3MmeM6k(m1523getCurrentDragPosition_m7T9E4.m3847unboximpl(), false);
                    num3 = textFieldSelectionManager2.dragBeginOffsetInText;
                    if (num3 == null && m1180getOffsetForPosition3MmeM6k == m1180getOffsetForPosition3MmeM6k2) {
                        return;
                    }
                    TextFieldValue value$foundation_release2 = textFieldSelectionManager2.getValue$foundation_release();
                    Offset m1523getCurrentDragPosition_m7T9E5 = textFieldSelectionManager2.m1523getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m1523getCurrentDragPosition_m7T9E5);
                    m1521updateSelection8UEBfa8 = textFieldSelectionManager2.m1521updateSelection8UEBfa8(value$foundation_release2, m1523getCurrentDragPosition_m7T9E5.m3847unboximpl(), false, false, SelectionAdjustment.Companion.getWord(), true);
                    TextRange.m6135boximpl(m1521updateSelection8UEBfa8);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                onEnd();
            }

            private final void onEnd() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1520setCurrentDragPosition_kEHs6E(null);
                boolean z = true;
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
                TextFieldSelectionManager.this.dragBeginOffsetInText = null;
                boolean m6141getCollapsedimpl = TextRange.m6141getCollapsedimpl(TextFieldSelectionManager.this.getValue$foundation_release().m6396getSelectiond9O1mEE());
                TextFieldSelectionManager.this.setHandleState(m6141getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release != null) {
                    state$foundation_release.setShowSelectionHandleStart(!m6141getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true));
                }
                LegacyTextFieldState state$foundation_release2 = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release2 != null) {
                    state$foundation_release2.setShowSelectionHandleEnd(!m6141getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, false));
                }
                LegacyTextFieldState state$foundation_release3 = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release3 == null) {
                    return;
                }
                if (!m6141getCollapsedimpl || !TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true)) {
                    z = false;
                }
                state$foundation_release3.setShowCursorHandle(z);
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo1389onExtendk4lQ0M(long j) {
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || state$foundation_release.getLayoutResult() == null || !TextFieldSelectionManager.this.getEnabled()) {
                    return false;
                }
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), j, false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo1390onExtendDragk4lQ0M(long j) {
                LegacyTextFieldState state$foundation_release;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), j, false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k */
            public boolean mo1391onStart3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
                LegacyTextFieldState state$foundation_release;
                long j2;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                FocusRequester focusRequester = TextFieldSelectionManager.this.getFocusRequester();
                if (focusRequester != null) {
                    FocusRequester.m3748requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                }
                TextFieldSelectionManager.this.dragBeginPosition = j;
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                TextFieldValue value$foundation_release = TextFieldSelectionManager.this.getValue$foundation_release();
                j2 = TextFieldSelectionManager.this.dragBeginPosition;
                updateMouseSelection(value$foundation_release, j2, true, selectionAdjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo1388onDrag3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
                LegacyTextFieldState state$foundation_release;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), j, false, selectionAdjustment);
                return true;
            }

            public final void updateMouseSelection(TextFieldValue textFieldValue, long j, boolean z, SelectionAdjustment selectionAdjustment) {
                long m1521updateSelection8UEBfa8;
                m1521updateSelection8UEBfa8 = TextFieldSelectionManager.this.m1521updateSelection8UEBfa8(textFieldValue, j, z, false, selectionAdjustment, false);
                TextFieldSelectionManager.this.setHandleState(TextRange.m6141getCollapsedimpl(m1521updateSelection8UEBfa8) ? HandleState.Cursor : HandleState.Selection);
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    public final OffsetMapping getOffsetMapping$foundation_release() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChange = function1;
    }

    public final LegacyTextFieldState getState$foundation_release() {
        return this.state;
    }

    public final void setState$foundation_release(LegacyTextFieldState legacyTextFieldState) {
        this.state = legacyTextFieldState;
    }

    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value$delegate.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.value$delegate.setValue(textFieldValue);
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    public final VisualTransformation getVisualTransformation$foundation_release() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    public final Function0<Unit> getRequestAutofillAction$foundation_release() {
        return this.requestAutofillAction;
    }

    public final void setRequestAutofillAction$foundation_release(Function0<Unit> function0) {
        this.requestAutofillAction = function0;
    }

    public final Clipboard getClipboard$foundation_release() {
        return this.clipboard;
    }

    public final void setClipboard$foundation_release(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    public final CoroutineScope getCoroutineScope$foundation_release() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope$foundation_release(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final boolean getEditable() {
        return ((Boolean) this.editable$delegate.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        this.editable$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean getEnabled() {
        return ((Boolean) this.enabled$delegate.getValue()).booleanValue();
    }

    public final void setEnabled(boolean z) {
        this.enabled$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle$delegate.setValue(handle);
    }

    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E  reason: not valid java name */
    public final void m1520setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1523getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean z) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1148onStartk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1146onDownk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                TextFieldSelectionManager.this.setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
                long m1468getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1468getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m1525getHandlePositiontuRUvjQ$foundation_release(z));
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                long m1183translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1183translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m1468getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m1183translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m1520setCurrentDragPosition_kEHs6E(Offset.m3826boximpl(m1183translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m3853getZeroF1C5BW0();
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                LegacyTextFieldState state$foundation_release2 = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release2 != null) {
                    state$foundation_release2.setInTouchMode(true);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1520setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1147onDragk4lQ0M(long j) {
                long j2;
                long j3;
                long j4;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m3842plusMKHz9U(j2, j);
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j3 = textFieldSelectionManager2.dragBeginPosition;
                j4 = TextFieldSelectionManager.this.dragTotalDistance;
                textFieldSelectionManager2.m1520setCurrentDragPosition_kEHs6E(Offset.m3826boximpl(Offset.m3842plusMKHz9U(j3, j4)));
                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                Offset m1523getCurrentDragPosition_m7T9E = TextFieldSelectionManager.this.m1523getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m1523getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m1521updateSelection8UEBfa8(value$foundation_release, m1523getCurrentDragPosition_m7T9E.m3847unboximpl(), false, z, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), true);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1520setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }
        };
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1146onDownk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1520setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1148onStartk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                long m1468getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1468getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m1525getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                long m1183translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1183translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m1468getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m1183translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m1520setCurrentDragPosition_kEHs6E(Offset.m3826boximpl(m1183translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m3853getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1147onDragk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                long j3;
                long j4;
                HapticFeedback hapticFeedBack;
                TextFieldValue m1518createTextFieldValueFDrldGo;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m3842plusMKHz9U(j2, j);
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j3 = textFieldSelectionManager2.dragBeginPosition;
                j4 = textFieldSelectionManager2.dragTotalDistance;
                textFieldSelectionManager2.m1520setCurrentDragPosition_kEHs6E(Offset.m3826boximpl(Offset.m3842plusMKHz9U(j3, j4)));
                OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                Offset m1523getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1523getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m1523getCurrentDragPosition_m7T9E);
                int transformedToOriginal = offsetMapping$foundation_release.transformedToOriginal(TextLayoutResultProxy.m1179getOffsetForPosition3MmeM6k$default(layoutResult, m1523getCurrentDragPosition_m7T9E.m3847unboximpl(), false, 2, null));
                long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
                if (TextRange.m6140equalsimpl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().m6396getSelectiond9O1mEE())) {
                    return;
                }
                LegacyTextFieldState state$foundation_release2 = textFieldSelectionManager2.getState$foundation_release();
                if ((state$foundation_release2 == null || state$foundation_release2.isInTouchMode()) && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo4812performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4828getTextHandleMove5zf0vsI());
                }
                Function1<TextFieldValue, Unit> onValueChange$foundation_release = textFieldSelectionManager2.getOnValueChange$foundation_release();
                m1518createTextFieldValueFDrldGo = textFieldSelectionManager2.m1518createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRange);
                onValueChange$foundation_release.invoke(m1518createTextFieldValueFDrldGo);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1520setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z);
    }

    public final void enterSelectionMode$foundation_release(boolean z) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && !legacyTextFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            FocusRequester.m3748requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(z);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ void m1519deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1522deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release  reason: not valid java name */
    public final void m1522deselect_kEHs6E$foundation_release(Offset offset) {
        int m6144getMaximpl;
        if (!TextRange.m6141getCollapsedimpl(getValue$foundation_release().m6396getSelectiond9O1mEE())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            if (offset != null && layoutResult != null) {
                m6144getMaximpl = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1179getOffsetForPosition3MmeM6k$default(layoutResult, offset.m3847unboximpl(), false, 2, null));
            } else {
                m6144getMaximpl = TextRange.m6144getMaximpl(getValue$foundation_release().m6396getSelectiond9O1mEE());
            }
            this.onValueChange.invoke(TextFieldValue.m6391copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(m6144getMaximpl), (TextRange) null, 5, (Object) null));
        }
        setHandleState((offset == null || getValue$foundation_release().getText().length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    /* renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release  reason: not valid java name */
    public final void m1528setSelectionPreviewHighlight5zctL8$foundation_release(long j) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1090setSelectionPreviewHighlightRange5zctL8(j);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1087setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.m6152getZerod9O1mEE());
        }
        if (TextRange.m6141getCollapsedimpl(j)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    /* renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release  reason: not valid java name */
    public final void m1527setDeletionPreviewHighlight5zctL8$foundation_release(long j) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1087setDeletionPreviewHighlightRange5zctL8(j);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1090setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.m6152getZerod9O1mEE());
        }
        if (TextRange.m6141getCollapsedimpl(j)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1087setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.m6152getZerod9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 == null) {
            return;
        }
        legacyTextFieldState2.m1090setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.m6152getZerod9O1mEE());
    }

    public static /* synthetic */ Job copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionManager.copy$foundation_release(z);
    }

    public final Job copy$foundation_release(boolean z) {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$copy$1(this, z, null), 1, null);
            return launch$default;
        }
        return null;
    }

    public final Job paste$foundation_release() {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$paste$1(this, null), 1, null);
            return launch$default;
        }
        return null;
    }

    public final Job cut$foundation_release() {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$cut$1(this, null), 1, null);
            return launch$default;
        }
        return null;
    }

    public final void selectAll$foundation_release() {
        TextFieldValue m1518createTextFieldValueFDrldGo = m1518createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(m1518createTextFieldValueFDrldGo);
        this.oldValue = TextFieldValue.m6391copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, m1518createTextFieldValueFDrldGo.m6396getSelectiond9O1mEE(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    public final void autofill$foundation_release() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1525getHandlePositiontuRUvjQ$foundation_release(boolean z) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.Companion.m3852getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.Companion.m3852getUnspecifiedF1C5BW0();
        }
        if (Intrinsics.areEqual(transformedText$foundation_release.getText(), value.getLayoutInput().getText().getText())) {
            long m6396getSelectiond9O1mEE = getValue$foundation_release().m6396getSelectiond9O1mEE();
            return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(z ? TextRange.m6147getStartimpl(m6396getSelectiond9O1mEE) : TextRange.m6142getEndimpl(m6396getSelectiond9O1mEE)), z, TextRange.m6146getReversedimpl(getValue$foundation_release().m6396getSelectiond9O1mEE()));
        }
        return Offset.Companion.m3852getUnspecifiedF1C5BW0();
    }

    public final float getHandleLineHeight$foundation_release(boolean z) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        int m6147getStartimpl = z ? TextRange.m6147getStartimpl(getValue$foundation_release().m6396getSelectiond9O1mEE()) : TextRange.m6142getEndimpl(getValue$foundation_release().m6396getSelectiond9O1mEE());
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return 0.0f;
        }
        return TextLayoutHelperKt.getLineHeight(value, m6147getStartimpl);
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1524getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m6147getStartimpl(getValue$foundation_release().m6396getSelectiond9O1mEE()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length()));
        return Offset.m3829constructorimpl((Float.floatToRawIntBits(cursorRect.getLeft() + (density.mo389toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness()) / 2)) << 32) | (Float.floatToRawIntBits(cursorRect.getBottom()) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean z) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.setShowFloatingToolbar(z);
        }
        if (z) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    public final Job showSelectionToolbar$foundation_release() {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbar$1(this, null), 1, null);
            return launch$default;
        }
        return null;
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M  reason: not valid java name */
    public final void m1526selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || TextLayoutHelperKt.m1177isPositionInsideSelectionuaM50fQ(layoutResult.getValue(), layoutResult.m1182translateDecorationToInnerCoordinatesMKHz9U$foundation_release(j), TextRange.m6135boximpl(getValue$foundation_release().m6396getSelectiond9O1mEE()))) {
            return;
        }
        m1521updateSelection8UEBfa8(getValue$foundation_release(), j, true, false, SelectionAdjustment.Companion.getWord(), false);
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        char c;
        long j;
        float f;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.isLayoutResultStale()) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m6147getStartimpl(getValue$foundation_release().m6396getSelectiond9O1mEE()));
                int originalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m6142getEndimpl(getValue$foundation_release().m6396getSelectiond9O1mEE()));
                LegacyTextFieldState legacyTextFieldState2 = this.state;
                long m3853getZeroF1C5BW0 = (legacyTextFieldState2 == null || (layoutCoordinates4 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? Offset.Companion.m3853getZeroF1C5BW0() : layoutCoordinates4.mo5449localToRootMKHz9U(m1525getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState legacyTextFieldState3 = this.state;
                long m3853getZeroF1C5BW02 = (legacyTextFieldState3 == null || (layoutCoordinates3 = legacyTextFieldState3.getLayoutCoordinates()) == null) ? Offset.Companion.m3853getZeroF1C5BW0() : layoutCoordinates3.mo5449localToRootMKHz9U(m1525getHandlePositiontuRUvjQ$foundation_release(false));
                LegacyTextFieldState legacyTextFieldState4 = this.state;
                float f2 = 0.0f;
                if (legacyTextFieldState4 == null || (layoutCoordinates2 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                    c = ' ';
                    j = 4294967295L;
                    f = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    c = ' ';
                    j = 4294967295L;
                    f = Float.intBitsToFloat((int) (layoutCoordinates2.mo5449localToRootMKHz9U(Offset.m3829constructorimpl((Float.floatToRawIntBits((layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(originalToTransformed)) == null) ? 0.0f : cursorRect2.getTop()) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32))) & 4294967295L));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.state;
                if (legacyTextFieldState5 != null && (layoutCoordinates = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    f2 = Float.intBitsToFloat((int) (layoutCoordinates.mo5449localToRootMKHz9U(Offset.m3829constructorimpl((Float.floatToRawIntBits(0.0f) << c) | (Float.floatToRawIntBits((layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(originalToTransformed2)) == null) ? 0.0f : cursorRect.getTop()) & j))) & j));
                }
                int i = (int) (m3853getZeroF1C5BW0 >> c);
                int i2 = (int) (m3853getZeroF1C5BW02 >> c);
                return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(f, f2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (m3853getZeroF1C5BW0 & j)), Float.intBitsToFloat((int) (m3853getZeroF1C5BW02 & j))) + (Dp.m6684constructorimpl(25) * legacyTextFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.Companion.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8  reason: not valid java name */
    public final long m1521updateSelection8UEBfa8(TextFieldValue textFieldValue, long j, boolean z, boolean z2, SelectionAdjustment selectionAdjustment, boolean z3) {
        TextLayoutResultProxy layoutResult;
        int i;
        HapticFeedback hapticFeedback;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.Companion.m6152getZerod9O1mEE();
        }
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m6147getStartimpl(textFieldValue.m6396getSelectiond9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.m6142getEndimpl(textFieldValue.m6396getSelectiond9O1mEE())));
        boolean z4 = false;
        int m1180getOffsetForPosition3MmeM6k = layoutResult.m1180getOffsetForPosition3MmeM6k(j, false);
        int m6147getStartimpl = (z2 || z) ? m1180getOffsetForPosition3MmeM6k : TextRange.m6147getStartimpl(TextRange);
        int m6142getEndimpl = (!z2 || z) ? m1180getOffsetForPosition3MmeM6k : TextRange.m6142getEndimpl(TextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        if (z || selectionLayout == null || (i = this.previousRawDragOffset) == -1) {
            i = -1;
        }
        SelectionLayout m1471getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1471getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), m6147getStartimpl, m6142getEndimpl, i, TextRange, z, z2);
        if (!m1471getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return textFieldValue.m6396getSelectiond9O1mEE();
        }
        this.previousSelectionLayout = m1471getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = m1180getOffsetForPosition3MmeM6k;
        Selection adjust = selectionAdjustment.adjust(m1471getTextFieldSelectionLayoutRcvTLA);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(adjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(adjust.getEnd().getOffset()));
        if (TextRange.m6140equalsimpl0(TextRange2, textFieldValue.m6396getSelectiond9O1mEE())) {
            return textFieldValue.m6396getSelectiond9O1mEE();
        }
        boolean z5 = TextRange.m6146getReversedimpl(TextRange2) != TextRange.m6146getReversedimpl(textFieldValue.m6396getSelectiond9O1mEE()) && TextRange.m6140equalsimpl0(TextRangeKt.TextRange(TextRange.m6142getEndimpl(TextRange2), TextRange.m6147getStartimpl(TextRange2)), textFieldValue.m6396getSelectiond9O1mEE());
        boolean z6 = TextRange.m6141getCollapsedimpl(TextRange2) && TextRange.m6141getCollapsedimpl(textFieldValue.m6396getSelectiond9O1mEE());
        if (z3 && textFieldValue.getText().length() > 0 && !z5 && !z6 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo4812performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m4828getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m1518createTextFieldValueFDrldGo(textFieldValue.getAnnotatedString(), TextRange2));
        if (!z3) {
            updateFloatingToolbar(!TextRange.m6141getCollapsedimpl(TextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(z3);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.m6141getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.m6141getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 == null) {
            return TextRange2;
        }
        if (TextRange.m6141getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true)) {
            z4 = true;
        }
        legacyTextFieldState5.setShowCursorHandle(z4);
        return TextRange2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo  reason: not valid java name */
    public final TextFieldValue m1518createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
