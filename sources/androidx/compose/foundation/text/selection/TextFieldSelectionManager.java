package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
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
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u009c\u0001\u001a\u00020\u00112\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010hH\u0002¢\u0006\u0003\b\u009e\u0001J\u0019\u0010\u009f\u0001\u001a\u00030\u0095\u00012\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¡\u0001J\u0010\u0010¢\u0001\u001a\u00030\u0095\u0001H\u0000¢\u0006\u0003\b£\u0001J\u001a\u0010¤\u0001\u001a\u00020\u00112\t\b\u0002\u0010¥\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¦\u0001J\u000f\u0010§\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b¨\u0001J\u001c\u0010©\u0001\u001a\u00020\u00112\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010eH\u0000¢\u0006\u0003\b«\u0001J\u001b\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020hH\u0000¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u001b\u0010°\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020hH\u0000¢\u0006\u0006\b±\u0001\u0010¯\u0001J\u000f\u0010²\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b³\u0001J\u000f\u0010½\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¾\u0001J\u0013\u0010¿\u0001\u001a\u00020\u0011H\u0080@¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0010\u0010Â\u0001\u001a\u00020\u0011H\u0082@¢\u0006\u0003\u0010Á\u0001J\u000f\u0010Ã\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÄ\u0001J\u000f\u0010Å\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÆ\u0001J\u000f\u0010Ç\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÈ\u0001J\u000f\u0010É\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÊ\u0001J\u001d\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u00012\t\b\u0002\u0010Í\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÎ\u0001J\u0012\u0010Ï\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0000¢\u0006\u0003\bÐ\u0001J\u0012\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0000¢\u0006\u0003\bÒ\u0001J\u000f\u0010Ó\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bÔ\u0001J\u000f\u0010Õ\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bÖ\u0001J\u001b\u0010×\u0001\u001a\u00020e2\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J\u0019\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÜ\u0001J\u001c\u0010Ý\u0001\u001a\u00020e2\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0000¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0012\u0010â\u0001\u001a\u00020\u00112\u0007\u0010ã\u0001\u001a\u00020XH\u0002J\u000f\u0010ä\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bå\u0001J\f\u0010æ\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0002J\u000f\u0010ç\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bè\u0001J\u0019\u0010é\u0001\u001a\u00020\u00112\u0007\u0010ª\u0001\u001a\u00020e¢\u0006\u0006\bê\u0001\u0010¯\u0001J\u000f\u0010ë\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bì\u0001J\n\u0010í\u0001\u001a\u00030î\u0001H\u0002JH\u0010ï\u0001\u001a\u00020h2\u0006\u0010\u001e\u001a\u00020\u00102\u0007\u0010ð\u0001\u001a\u00020e2\u0007\u0010ñ\u0001\u001a\u00020X2\u0007\u0010 \u0001\u001a\u00020X2\b\u0010ò\u0001\u001a\u00030ó\u00012\u0007\u0010ô\u0001\u001a\u00020XH\u0002¢\u0006\u0006\bõ\u0001\u0010ö\u0001J\u0013\u0010÷\u0001\u001a\u00020\u00112\b\u0010ø\u0001\u001a\u00030ù\u0001H\u0002J$\u0010ú\u0001\u001a\u00020\u00102\u0007\u0010û\u0001\u001a\u00020$2\u0007\u0010\u009d\u0001\u001a\u00020hH\u0002¢\u0006\u0006\bü\u0001\u0010ý\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00108@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR+\u0010Y\u001a\u00020X2\u0006\u0010W\u001a\u00020X8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R+\u0010`\u001a\u00020X2\u0006\u0010W\u001a\u00020X8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010_\u001a\u0004\ba\u0010[\"\u0004\bb\u0010]R\u0010\u0010d\u001a\u00020eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u00020eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR/\u0010k\u001a\u0004\u0018\u00010j2\b\u0010W\u001a\u0004\u0018\u00010j8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bp\u0010_\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR/\u0010q\u001a\u0004\u0018\u00010e2\b\u0010W\u001a\u0004\u0018\u00010e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bv\u0010_\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u000e\u0010w\u001a\u00020xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010|\u001a\u0004\u0018\u00010hX\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R7\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\t\u0010W\u001a\u0005\u0018\u00010\u0081\u00018B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0005\b\u0087\u0001\u0010_\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R,\u0010\u0088\u0001\u001a\u00030\u0089\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u001a\n\u0000\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0015\u0010\u0090\u0001\u001a\u00030\u0091\u00018F¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0099\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001d\u0010´\u0001\u001a\u00020XX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010[\"\u0005\b¶\u0001\u0010]R\u001e\u0010·\u0001\u001a\u00020X8@X\u0080\u0004¢\u0006\u000f\u0012\u0006\b¸\u0001\u0010\u008b\u0001\u001a\u0005\b¹\u0001\u0010[R\u0016\u0010º\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bº\u0001\u0010[R\u0016\u0010»\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010[¨\u0006þ\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/UndoManager;)V", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "onValueChange", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "requestAutofillAction", "Lkotlin/Function0;", "getRequestAutofillAction$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "getClipboard$foundation_release", "()Landroidx/compose/ui/platform/Clipboard;", "setClipboard$foundation_release", "(Landroidx/compose/ui/platform/Clipboard;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation_release", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviors$foundation_release", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "setPlatformSelectionBehaviors$foundation_release", "(Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "Landroidx/compose/runtime/MutableState;", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragBeginSelection", "Landroidx/compose/ui/text/TextRange;", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "previousRawDragOffset", "", "oldValue", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "latestSelection", "getLatestSelection-MzsxiRA$foundation_release", "()Landroidx/compose/ui/text/TextRange;", "setLatestSelection-OEnZFl4$foundation_release", "(Landroidx/compose/ui/text/TextRange;)V", "Landroidx/compose/ui/platform/ClipEntry;", "clipEntry", "getClipEntry", "()Landroidx/compose/ui/platform/ClipEntry;", "setClipEntry", "(Landroidx/compose/ui/platform/ClipEntry;)V", "clipEntry$delegate", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "getToolbarRequester$foundation_release$annotations", "()V", "getToolbarRequester$foundation_release", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setToolbarRequester$foundation_release", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "contextMenuAreaModifier", "Landroidx/compose/ui/Modifier;", "getContextMenuAreaModifier", "()Landroidx/compose/ui/Modifier;", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "maybeSuggestSelection", "selection", "maybeSuggestSelection-OEnZFl4", "handleDragObserver", "isStartHandle", "handleDragObserver$foundation_release", "cursorDragObserver", "cursorDragObserver$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "deselect", "position", "deselect-_kEHs6E$foundation_release", "setSelectionPreviewHighlight", "range", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "(J)V", "setDeletionPreviewHighlight", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "clearPreviewHighlight", "clearPreviewHighlight$foundation_release", "textToolbarShownViaProvider", "getTextToolbarShownViaProvider$foundation_release", "setTextToolbarShownViaProvider$foundation_release", "textToolbarShown", "getTextToolbarShown$foundation_release$annotations", "getTextToolbarShown$foundation_release", "isPassword", "hasSelection", "getHasSelection", "canCopy", "canCopy$foundation_release", "updateClipboardEntry", "updateClipboardEntry$foundation_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyPlatformSelectionBehaviorsOnShowContextMenu", "canPaste", "canPaste$foundation_release", "canCut", "canCut$foundation_release", "canSelectAll", "canSelectAll$foundation_release", "canAutofill", "canAutofill$foundation_release", "copy", "Lkotlinx/coroutines/Job;", "cancelSelection", "copy$foundation_release", "paste", "paste$foundation_release", "cut", "cut$foundation_release", "selectAll", "selectAll$foundation_release", "autofill", "autofill$foundation_release", "getHandlePosition", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "getHandleLineHeight", "", "getHandleLineHeight$foundation_release", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "updateFloatingToolbar", "show", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "showSelectionToolbarViaTextToolbar", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "isTextChanged", "isTextChanged$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "createTextFieldValue", "annotatedString", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private final MutableState clipEntry$delegate;
    private Clipboard clipboard;
    private CoroutineScope coroutineScope;
    private final MutableState currentDragPosition$delegate;
    private long dragBeginPosition;
    private TextRange dragBeginSelection;
    private long dragTotalDistance;
    private final MutableState draggingHandle$delegate;
    private final MutableState editable$delegate;
    private final MutableState enabled$delegate;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private TextRange latestSelection;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private Function0<Unit> requestAutofillAction;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private boolean textToolbarShownViaProvider;
    private ToolbarRequester toolbarRequester;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState<TextFieldValue> valueState;
    private VisualTransformation visualTransformation;

    public TextFieldSelectionManager() {
        this(null, 1, null);
    }

    public static /* synthetic */ void getTextToolbarShown$foundation_release$annotations() {
    }

    public static /* synthetic */ void getToolbarRequester$foundation_release$annotations() {
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        MutableState<TextFieldValue> mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit onValueChange$lambda$0;
                onValueChange$lambda$0 = TextFieldSelectionManager.onValueChange$lambda$0((TextFieldValue) obj);
                return onValueChange$lambda$0;
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.valueState = mutableStateOf$default;
        this.visualTransformation = VisualTransformation.Companion.getNone();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.editable$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.enabled$delegate = mutableStateOf$default3;
        this.dragBeginPosition = Offset.Companion.m5051getZeroF1C5BW0();
        this.dragTotalDistance = Offset.Companion.m5051getZeroF1C5BW0();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition$delegate = mutableStateOf$default5;
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.clipEntry$delegate = mutableStateOf$default6;
        this.toolbarRequester = new ToolbarRequesterImpl();
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            private boolean isLongPressSelectionOnly = true;

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1347onDownk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1349onStartk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                TextFieldValue m1825createTextFieldValueFDrldGo;
                long j3;
                TextLayoutResultProxy layoutResult2;
                long m1829updateSelection8UEBfa8;
                if (TextFieldSelectionManager.this.getEnabled() && TextFieldSelectionManager.this.getDraggingHandle() == null) {
                    TextFieldSelectionManager.this.setDraggingHandle(Handle.SelectionEnd);
                    TextFieldSelectionManager.this.previousRawDragOffset = -1;
                    this.isLongPressSelectionOnly = true;
                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                    if (state$foundation_release == null || (layoutResult2 = state$foundation_release.getLayoutResult()) == null || !layoutResult2.m1388isPositionOnTextk4lQ0M(j)) {
                        j2 = j;
                        LegacyTextFieldState state$foundation_release2 = TextFieldSelectionManager.this.getState$foundation_release();
                        if (state$foundation_release2 != null && (layoutResult = state$foundation_release2.getLayoutResult()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                            int transformedToOriginal = textFieldSelectionManager.getOffsetMapping$foundation_release().transformedToOriginal(TextLayoutResultProxy.m1386getOffsetForPosition3MmeM6k$default(layoutResult, j2, false, 2, null));
                            m1825createTextFieldValueFDrldGo = textFieldSelectionManager.m1825createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                            HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                            if (hapticFeedBack != null) {
                                hapticFeedBack.mo6053performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m6070getTextHandleMove5zf0vsI());
                            }
                            textFieldSelectionManager.getOnValueChange$foundation_release().invoke(m1825createTextFieldValueFDrldGo);
                            textFieldSelectionManager.m1837setLatestSelectionOEnZFl4$foundation_release(TextRange.m7445boximpl(m1825createTextFieldValueFDrldGo.m7708getSelectiond9O1mEE()));
                        }
                        this.isLongPressSelectionOnly = false;
                    } else if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                        return;
                    } else {
                        TextFieldSelectionManager.this.enterSelectionMode$foundation_release(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                        m1829updateSelection8UEBfa8 = textFieldSelectionManager2.m1829updateSelection8UEBfa8(TextFieldValue.m7703copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.Companion.m7462getZerod9O1mEE(), (TextRange) null, 5, (Object) null), j, true, false, SelectionAdjustment.Companion.getWord(), true);
                        j2 = j;
                        TextFieldSelectionManager.this.dragBeginSelection = TextRange.m7445boximpl(m1829updateSelection8UEBfa8);
                    }
                    TextFieldSelectionManager.this.setHandleState(HandleState.None);
                    TextFieldSelectionManager.this.dragBeginPosition = j2;
                    TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                    j3 = textFieldSelectionManager3.dragBeginPosition;
                    textFieldSelectionManager3.m1828setCurrentDragPosition_kEHs6E(Offset.m5024boximpl(j3));
                    TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m5051getZeroF1C5BW0();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x010b  */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void mo1348onDragk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                long j3;
                long j4;
                TextRange textRange;
                TextFieldSelectionManager textFieldSelectionManager;
                TextRange textRange2;
                long j5;
                int m1387getOffsetForPosition3MmeM6k;
                TextRange textRange3;
                long m1829updateSelection8UEBfa8;
                TextRange textRange4;
                long j6;
                SelectionAdjustment word;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragTotalDistance;
                textFieldSelectionManager2.dragTotalDistance = Offset.m5040plusMKHz9U(j2, j);
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null) {
                    TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                    j3 = textFieldSelectionManager3.dragBeginPosition;
                    j4 = textFieldSelectionManager3.dragTotalDistance;
                    textFieldSelectionManager3.m1828setCurrentDragPosition_kEHs6E(Offset.m5024boximpl(Offset.m5040plusMKHz9U(j3, j4)));
                    textRange = textFieldSelectionManager3.dragBeginSelection;
                    if (textRange == null) {
                        Offset m1831getCurrentDragPosition_m7T9E = textFieldSelectionManager3.m1831getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m1831getCurrentDragPosition_m7T9E);
                        if (!layoutResult.m1388isPositionOnTextk4lQ0M(m1831getCurrentDragPosition_m7T9E.m5045unboximpl())) {
                            OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager3.getOffsetMapping$foundation_release();
                            j6 = textFieldSelectionManager3.dragBeginPosition;
                            int transformedToOriginal = offsetMapping$foundation_release.transformedToOriginal(TextLayoutResultProxy.m1386getOffsetForPosition3MmeM6k$default(layoutResult, j6, false, 2, null));
                            OffsetMapping offsetMapping$foundation_release2 = textFieldSelectionManager3.getOffsetMapping$foundation_release();
                            Offset m1831getCurrentDragPosition_m7T9E2 = textFieldSelectionManager3.m1831getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m1831getCurrentDragPosition_m7T9E2);
                            if (transformedToOriginal == offsetMapping$foundation_release2.transformedToOriginal(TextLayoutResultProxy.m1386getOffsetForPosition3MmeM6k$default(layoutResult, m1831getCurrentDragPosition_m7T9E2.m5045unboximpl(), false, 2, null))) {
                                word = SelectionAdjustment.Companion.getNone();
                            } else {
                                word = SelectionAdjustment.Companion.getWord();
                            }
                            SelectionAdjustment selectionAdjustment = word;
                            TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                            Offset m1831getCurrentDragPosition_m7T9E3 = textFieldSelectionManager3.m1831getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m1831getCurrentDragPosition_m7T9E3);
                            textFieldSelectionManager = textFieldSelectionManager3;
                            m1829updateSelection8UEBfa8 = textFieldSelectionManager.m1829updateSelection8UEBfa8(value$foundation_release, m1831getCurrentDragPosition_m7T9E3.m5045unboximpl(), false, false, selectionAdjustment, true);
                            textRange4 = textFieldSelectionManager.dragBeginSelection;
                            if (!TextRange.m7449equalsimpl(m1829updateSelection8UEBfa8, textRange4)) {
                                this.isLongPressSelectionOnly = false;
                            }
                        }
                    }
                    textFieldSelectionManager = textFieldSelectionManager3;
                    textRange2 = textFieldSelectionManager.dragBeginSelection;
                    if (textRange2 != null) {
                        m1387getOffsetForPosition3MmeM6k = TextRange.m7457getStartimpl(textRange2.m7461unboximpl());
                    } else {
                        j5 = textFieldSelectionManager.dragBeginPosition;
                        m1387getOffsetForPosition3MmeM6k = layoutResult.m1387getOffsetForPosition3MmeM6k(j5, false);
                    }
                    Offset m1831getCurrentDragPosition_m7T9E4 = textFieldSelectionManager.m1831getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m1831getCurrentDragPosition_m7T9E4);
                    int m1387getOffsetForPosition3MmeM6k2 = layoutResult.m1387getOffsetForPosition3MmeM6k(m1831getCurrentDragPosition_m7T9E4.m5045unboximpl(), false);
                    textRange3 = textFieldSelectionManager.dragBeginSelection;
                    if (textRange3 == null && m1387getOffsetForPosition3MmeM6k == m1387getOffsetForPosition3MmeM6k2) {
                        return;
                    }
                    TextFieldValue value$foundation_release2 = textFieldSelectionManager.getValue$foundation_release();
                    Offset m1831getCurrentDragPosition_m7T9E5 = textFieldSelectionManager.m1831getCurrentDragPosition_m7T9E();
                    Intrinsics.checkNotNull(m1831getCurrentDragPosition_m7T9E5);
                    m1829updateSelection8UEBfa8 = textFieldSelectionManager.m1829updateSelection8UEBfa8(value$foundation_release2, m1831getCurrentDragPosition_m7T9E5.m5045unboximpl(), false, false, SelectionAdjustment.Companion.getWord(), true);
                    textRange4 = textFieldSelectionManager.dragBeginSelection;
                    if (!TextRange.m7449equalsimpl(m1829updateSelection8UEBfa8, textRange4)) {
                    }
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
                TextRange textRange;
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1828setCurrentDragPosition_kEHs6E(null);
                boolean z = true;
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
                boolean m7451getCollapsedimpl = TextRange.m7451getCollapsedimpl(TextFieldSelectionManager.this.getValue$foundation_release().m7708getSelectiond9O1mEE());
                TextFieldSelectionManager.this.setHandleState(m7451getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release != null) {
                    state$foundation_release.setShowSelectionHandleStart(!m7451getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true));
                }
                LegacyTextFieldState state$foundation_release2 = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release2 != null) {
                    state$foundation_release2.setShowSelectionHandleEnd(!m7451getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, false));
                }
                LegacyTextFieldState state$foundation_release3 = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release3 != null) {
                    if (!m7451getCollapsedimpl || !TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true)) {
                        z = false;
                    }
                    state$foundation_release3.setShowCursorHandle(z);
                }
                if (this.isLongPressSelectionOnly) {
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    textRange = textFieldSelectionManager.dragBeginSelection;
                    textFieldSelectionManager.m1827maybeSuggestSelectionOEnZFl4(textRange);
                }
                TextFieldSelectionManager.this.dragBeginSelection = null;
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            private TextRange initialSelection;
            private boolean isDoubleOrTripleClickSelectionOnly = true;

            public final boolean isDoubleOrTripleClickSelectionOnly() {
                return this.isDoubleOrTripleClickSelectionOnly;
            }

            public final void setDoubleOrTripleClickSelectionOnly(boolean z) {
                this.isDoubleOrTripleClickSelectionOnly = z;
            }

            public final TextRange getInitialSelection() {
                return this.initialSelection;
            }

            public final void setInitialSelection(TextRange textRange) {
                this.initialSelection = textRange;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo1659onExtendk4lQ0M(long j) {
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
            public boolean mo1660onExtendDragk4lQ0M(long j) {
                LegacyTextFieldState state$foundation_release;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), j, false, SelectionAdjustment.Companion.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-9KIMszo */
            public boolean mo1661onStart9KIMszo(long j, SelectionAdjustment selectionAdjustment, int i) {
                long j2;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                    return false;
                }
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                FocusRequester focusRequester = TextFieldSelectionManager.this.getFocusRequester();
                if (focusRequester != null) {
                    FocusRequester.m4942requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                }
                TextFieldSelectionManager.this.dragBeginPosition = j;
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                TextFieldValue value$foundation_release = TextFieldSelectionManager.this.getValue$foundation_release();
                j2 = TextFieldSelectionManager.this.dragBeginPosition;
                long updateMouseSelection = updateMouseSelection(value$foundation_release, j2, true, selectionAdjustment);
                if (i >= 2) {
                    this.isDoubleOrTripleClickSelectionOnly = true;
                    this.initialSelection = TextRange.m7445boximpl(updateMouseSelection);
                }
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo1658onDrag3MmeM6k(long j, SelectionAdjustment selectionAdjustment) {
                LegacyTextFieldState state$foundation_release;
                if (!TextFieldSelectionManager.this.getEnabled() || TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0 || (state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release()) == null || state$foundation_release.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), j, false, selectionAdjustment);
                return true;
            }

            public final long updateMouseSelection(TextFieldValue textFieldValue, long j, boolean z, SelectionAdjustment selectionAdjustment) {
                long m1829updateSelection8UEBfa8;
                m1829updateSelection8UEBfa8 = TextFieldSelectionManager.this.m1829updateSelection8UEBfa8(textFieldValue, j, z, false, selectionAdjustment, false);
                if (!TextRange.m7449equalsimpl(m1829updateSelection8UEBfa8, this.initialSelection)) {
                    this.isDoubleOrTripleClickSelectionOnly = false;
                }
                TextFieldSelectionManager.this.setHandleState(TextRange.m7451getCollapsedimpl(m1829updateSelection8UEBfa8) ? HandleState.Cursor : HandleState.Selection);
                return m1829updateSelection8UEBfa8;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
                if (this.isDoubleOrTripleClickSelectionOnly) {
                    TextFieldSelectionManager.this.m1827maybeSuggestSelectionOEnZFl4(this.initialSelection);
                }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onValueChange$lambda$0(TextFieldValue textFieldValue) {
        return Unit.INSTANCE;
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
        return this.valueState.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.valueState.setValue(textFieldValue);
        this.latestSelection = TextRange.m7445boximpl(textFieldValue.m7708getSelectiond9O1mEE());
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

    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors$foundation_release() {
        return this.platformSelectionBehaviors;
    }

    public final void setPlatformSelectionBehaviors$foundation_release(PlatformSelectionBehaviors platformSelectionBehaviors) {
        this.platformSelectionBehaviors = platformSelectionBehaviors;
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
    public final void m1828setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition$delegate.setValue(offset);
    }

    /* renamed from: getCurrentDragPosition-_m7T9-E  reason: not valid java name */
    public final Offset m1831getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition$delegate.getValue();
    }

    /* renamed from: getLatestSelection-MzsxiRA$foundation_release  reason: not valid java name */
    public final TextRange m1834getLatestSelectionMzsxiRA$foundation_release() {
        return this.latestSelection;
    }

    /* renamed from: setLatestSelection-OEnZFl4$foundation_release  reason: not valid java name */
    public final void m1837setLatestSelectionOEnZFl4$foundation_release(TextRange textRange) {
        this.latestSelection = textRange;
    }

    private final ClipEntry getClipEntry() {
        return (ClipEntry) this.clipEntry$delegate.getValue();
    }

    private final void setClipEntry(ClipEntry clipEntry) {
        this.clipEntry$delegate.setValue(clipEntry);
    }

    public final ToolbarRequester getToolbarRequester$foundation_release() {
        return this.toolbarRequester;
    }

    public final void setToolbarRequester$foundation_release(ToolbarRequester toolbarRequester) {
        this.toolbarRequester = toolbarRequester;
    }

    public final Modifier getContextMenuAreaModifier() {
        return !getEnabled() ? Modifier.Companion : TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler(TextContextMenuGesturesModifierKt.textContextMenuGestures(Modifier.Companion, new TextFieldSelectionManager$contextMenuAreaModifier$1(this, null)), this.toolbarRequester, new TextFieldSelectionManager$contextMenuAreaModifier$2(this, null), new TextFieldSelectionManager$contextMenuAreaModifier$3(this, null), new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Rect _get_contextMenuAreaModifier_$lambda$1;
                _get_contextMenuAreaModifier_$lambda$1 = TextFieldSelectionManager._get_contextMenuAreaModifier_$lambda$1(TextFieldSelectionManager.this, (LayoutCoordinates) obj);
                return _get_contextMenuAreaModifier_$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect _get_contextMenuAreaModifier_$lambda$1(TextFieldSelectionManager textFieldSelectionManager, LayoutCoordinates layoutCoordinates) {
        Rect contentRect = textFieldSelectionManager.getContentRect();
        LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
        LayoutCoordinates layoutCoordinates2 = legacyTextFieldState != null ? legacyTextFieldState.getLayoutCoordinates() : null;
        if (layoutCoordinates2 != null) {
            return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(contentRect, layoutCoordinates2, layoutCoordinates);
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    public final TextDragObserver getTouchSelectionObserver$foundation_release() {
        return this.touchSelectionObserver;
    }

    public final MouseSelectionObserver getMouseSelectionObserver$foundation_release() {
        return this.mouseSelectionObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: maybeSuggestSelection-OEnZFl4  reason: not valid java name */
    public final void m1827maybeSuggestSelectionOEnZFl4(TextRange textRange) {
        PlatformSelectionBehaviors platformSelectionBehaviors;
        AnnotatedString transformedText$foundation_release;
        String text;
        CoroutineScope coroutineScope;
        if (textRange == null || (platformSelectionBehaviors = this.platformSelectionBehaviors) == null || (transformedText$foundation_release = getTransformedText$foundation_release()) == null || (text = transformedText$foundation_release.getText()) == null) {
            return;
        }
        OffsetMapping offsetMapping = this.offsetMapping;
        long TextRange = TextRangeKt.TextRange(offsetMapping.originalToTransformed(TextRange.m7457getStartimpl(textRange.m7461unboximpl())), offsetMapping.originalToTransformed(TextRange.m7452getEndimpl(textRange.m7461unboximpl())));
        if (text.length() <= 0 || TextRange.m7451getCollapsedimpl(TextRange) || (coroutineScope = this.coroutineScope) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new TextFieldSelectionManager$maybeSuggestSelection$1(platformSelectionBehaviors, text, TextRange, textRange, this, offsetMapping, null), 3, null);
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean z) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1349onStartk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1347onDownk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                TextFieldSelectionManager.this.setDraggingHandle(z ? Handle.SelectionStart : Handle.SelectionEnd);
                long m1767getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1767getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m1833getHandlePositiontuRUvjQ$foundation_release(z));
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                long m1390translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1390translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m1767getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m1390translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m1828setCurrentDragPosition_kEHs6E(Offset.m5024boximpl(m1390translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m5051getZeroF1C5BW0();
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
                TextFieldSelectionManager.this.m1828setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1348onDragk4lQ0M(long j) {
                long j2;
                long j3;
                long j4;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m5040plusMKHz9U(j2, j);
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j3 = textFieldSelectionManager2.dragBeginPosition;
                j4 = TextFieldSelectionManager.this.dragTotalDistance;
                textFieldSelectionManager2.m1828setCurrentDragPosition_kEHs6E(Offset.m5024boximpl(Offset.m5040plusMKHz9U(j3, j4)));
                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                Offset m1831getCurrentDragPosition_m7T9E = TextFieldSelectionManager.this.m1831getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m1831getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m1829updateSelection8UEBfa8(value$foundation_release, m1831getCurrentDragPosition_m7T9E.m5045unboximpl(), false, z, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), true);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1828setCurrentDragPosition_kEHs6E(null);
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
            public void mo1347onDownk4lQ0M(long j) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1828setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1349onStartk4lQ0M(long j) {
                TextLayoutResultProxy layoutResult;
                long m1767getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1767getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m1833getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                long m1390translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1390translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m1767getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m1390translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m1828setCurrentDragPosition_kEHs6E(Offset.m5024boximpl(m1390translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.Companion.m5051getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1348onDragk4lQ0M(long j) {
                long j2;
                TextLayoutResultProxy layoutResult;
                long j3;
                long j4;
                HapticFeedback hapticFeedBack;
                TextFieldValue m1825createTextFieldValueFDrldGo;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m5040plusMKHz9U(j2, j);
                LegacyTextFieldState state$foundation_release = TextFieldSelectionManager.this.getState$foundation_release();
                if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j3 = textFieldSelectionManager2.dragBeginPosition;
                j4 = textFieldSelectionManager2.dragTotalDistance;
                textFieldSelectionManager2.m1828setCurrentDragPosition_kEHs6E(Offset.m5024boximpl(Offset.m5040plusMKHz9U(j3, j4)));
                OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
                Offset m1831getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1831getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m1831getCurrentDragPosition_m7T9E);
                int transformedToOriginal = offsetMapping$foundation_release.transformedToOriginal(TextLayoutResultProxy.m1386getOffsetForPosition3MmeM6k$default(layoutResult, m1831getCurrentDragPosition_m7T9E.m5045unboximpl(), false, 2, null));
                long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
                if (TextRange.m7450equalsimpl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().m7708getSelectiond9O1mEE())) {
                    return;
                }
                LegacyTextFieldState state$foundation_release2 = textFieldSelectionManager2.getState$foundation_release();
                if ((state$foundation_release2 == null || state$foundation_release2.isInTouchMode()) && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo6053performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m6070getTextHandleMove5zf0vsI());
                }
                Function1<TextFieldValue, Unit> onValueChange$foundation_release = textFieldSelectionManager2.getOnValueChange$foundation_release();
                m1825createTextFieldValueFDrldGo = textFieldSelectionManager2.m1825createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRange);
                onValueChange$foundation_release.invoke(m1825createTextFieldValueFDrldGo);
                textFieldSelectionManager2.m1837setLatestSelectionOEnZFl4$foundation_release(TextRange.m7445boximpl(TextRange));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m1828setCurrentDragPosition_kEHs6E(null);
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
            FocusRequester.m4942requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
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
    public static /* synthetic */ void m1826deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1830deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release  reason: not valid java name */
    public final void m1830deselect_kEHs6E$foundation_release(Offset offset) {
        int m7454getMaximpl;
        if (!TextRange.m7451getCollapsedimpl(getValue$foundation_release().m7708getSelectiond9O1mEE())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            if (offset != null && layoutResult != null) {
                m7454getMaximpl = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1386getOffsetForPosition3MmeM6k$default(layoutResult, offset.m5045unboximpl(), false, 2, null));
            } else {
                m7454getMaximpl = TextRange.m7454getMaximpl(getValue$foundation_release().m7708getSelectiond9O1mEE());
            }
            TextFieldValue m7703copy3r_uNRQ$default = TextFieldValue.m7703copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(m7454getMaximpl), (TextRange) null, 5, (Object) null);
            this.onValueChange.invoke(m7703copy3r_uNRQ$default);
            this.latestSelection = TextRange.m7445boximpl(m7703copy3r_uNRQ$default.m7708getSelectiond9O1mEE());
        }
        setHandleState((offset == null || getValue$foundation_release().getText().length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    /* renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release  reason: not valid java name */
    public final void m1838setSelectionPreviewHighlight5zctL8$foundation_release(long j) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1293setSelectionPreviewHighlightRange5zctL8(j);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1290setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.m7462getZerod9O1mEE());
        }
        if (TextRange.m7451getCollapsedimpl(j)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    /* renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release  reason: not valid java name */
    public final void m1836setDeletionPreviewHighlight5zctL8$foundation_release(long j) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1290setDeletionPreviewHighlightRange5zctL8(j);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1293setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.m7462getZerod9O1mEE());
        }
        if (TextRange.m7451getCollapsedimpl(j)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1290setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.m7462getZerod9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1293setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.m7462getZerod9O1mEE());
        }
    }

    public final boolean getTextToolbarShownViaProvider$foundation_release() {
        return this.textToolbarShownViaProvider;
    }

    public final void setTextToolbarShownViaProvider$foundation_release(boolean z) {
        this.textToolbarShownViaProvider = z;
    }

    public final boolean getTextToolbarShown$foundation_release() {
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            return this.textToolbarShownViaProvider;
        }
        TextToolbar textToolbar = this.textToolbar;
        return (textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Shown;
    }

    private final boolean isPassword() {
        return this.visualTransformation instanceof PasswordVisualTransformation;
    }

    private final boolean getHasSelection() {
        return !TextRange.m7451getCollapsedimpl(getValue$foundation_release().m7708getSelectiond9O1mEE());
    }

    public final boolean canCopy$foundation_release() {
        return getHasSelection() && !isPassword();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateClipboardEntry$foundation_release(Continuation<? super Unit> continuation) {
        TextFieldSelectionManager$updateClipboardEntry$1 textFieldSelectionManager$updateClipboardEntry$1;
        int i;
        ClipEntry clipEntry;
        TextFieldSelectionManager textFieldSelectionManager;
        if (continuation instanceof TextFieldSelectionManager$updateClipboardEntry$1) {
            textFieldSelectionManager$updateClipboardEntry$1 = (TextFieldSelectionManager$updateClipboardEntry$1) continuation;
            if ((textFieldSelectionManager$updateClipboardEntry$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionManager$updateClipboardEntry$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionManager$updateClipboardEntry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionManager$updateClipboardEntry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Clipboard clipboard = this.clipboard;
                    if (clipboard == null) {
                        clipEntry = null;
                        textFieldSelectionManager = this;
                        textFieldSelectionManager.setClipEntry(clipEntry);
                        return Unit.INSTANCE;
                    }
                    textFieldSelectionManager$updateClipboardEntry$1.L$0 = this;
                    textFieldSelectionManager$updateClipboardEntry$1.label = 1;
                    obj = clipboard.getClipEntry(textFieldSelectionManager$updateClipboardEntry$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    textFieldSelectionManager = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    textFieldSelectionManager = (TextFieldSelectionManager) textFieldSelectionManager$updateClipboardEntry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                clipEntry = (ClipEntry) obj;
                textFieldSelectionManager.setClipEntry(clipEntry);
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionManager$updateClipboardEntry$1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, continuation);
        Object obj2 = textFieldSelectionManager$updateClipboardEntry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionManager$updateClipboardEntry$1.label;
        if (i != 0) {
        }
        clipEntry = (ClipEntry) obj2;
        textFieldSelectionManager.setClipEntry(clipEntry);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object notifyPlatformSelectionBehaviorsOnShowContextMenu(Continuation<? super Unit> continuation) {
        TextFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1 textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1;
        int i;
        String text;
        TextRange textRange;
        if (continuation instanceof TextFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1) {
            textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1 = (TextFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1) continuation;
            if ((textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
                    if (transformedText$foundation_release != null && (text = transformedText$foundation_release.getText()) != null && (textRange = this.latestSelection) != null) {
                        long m7461unboximpl = textRange.m7461unboximpl();
                        PlatformSelectionBehaviors platformSelectionBehaviors = this.platformSelectionBehaviors;
                        if (platformSelectionBehaviors != null) {
                            long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m7457getStartimpl(m7461unboximpl)), this.offsetMapping.originalToTransformed(TextRange.m7452getEndimpl(m7461unboximpl)));
                            textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1.label = 1;
                            if (platformSelectionBehaviors.mo1745onShowContextMenuSbBc2M(text, TextRange, textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1 = new TextFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1(this, continuation);
        Object obj2 = textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    public final boolean canPaste$foundation_release() {
        ClipEntry clipEntry;
        return getEditable() && (clipEntry = getClipEntry()) != null && ClipboardUtils_androidKt.hasText(clipEntry);
    }

    public final boolean canCut$foundation_release() {
        return getHasSelection() && getEditable() && !isPassword();
    }

    public final boolean canSelectAll$foundation_release() {
        return TextRange.m7453getLengthimpl(getValue$foundation_release().m7708getSelectiond9O1mEE()) != getValue$foundation_release().getText().length();
    }

    public final boolean canAutofill$foundation_release() {
        return getEditable() && TextRange.m7451getCollapsedimpl(getValue$foundation_release().m7708getSelectiond9O1mEE());
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
        TextFieldValue m1825createTextFieldValueFDrldGo = m1825createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(m1825createTextFieldValueFDrldGo);
        this.latestSelection = TextRange.m7445boximpl(m1825createTextFieldValueFDrldGo.m7708getSelectiond9O1mEE());
        this.oldValue = TextFieldValue.m7703copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, m1825createTextFieldValueFDrldGo.m7708getSelectiond9O1mEE(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    public final void autofill$foundation_release() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1833getHandlePositiontuRUvjQ$foundation_release(boolean z) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.Companion.m5050getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.Companion.m5050getUnspecifiedF1C5BW0();
        }
        if (Intrinsics.areEqual(transformedText$foundation_release.getText(), value.getLayoutInput().getText().getText())) {
            long m7708getSelectiond9O1mEE = getValue$foundation_release().m7708getSelectiond9O1mEE();
            return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(z ? TextRange.m7457getStartimpl(m7708getSelectiond9O1mEE) : TextRange.m7452getEndimpl(m7708getSelectiond9O1mEE)), z, TextRange.m7456getReversedimpl(getValue$foundation_release().m7708getSelectiond9O1mEE()));
        }
        return Offset.Companion.m5050getUnspecifiedF1C5BW0();
    }

    public final float getHandleLineHeight$foundation_release(boolean z) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        int m7457getStartimpl = z ? TextRange.m7457getStartimpl(getValue$foundation_release().m7708getSelectiond9O1mEE()) : TextRange.m7452getEndimpl(getValue$foundation_release().m7708getSelectiond9O1mEE());
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return 0.0f;
        }
        return TextLayoutHelperKt.getLineHeight(value, m7457getStartimpl);
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release  reason: not valid java name */
    public final long m1832getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m7457getStartimpl(getValue$foundation_release().m7708getSelectiond9O1mEE()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length()));
        return Offset.m5027constructorimpl((Float.floatToRawIntBits(cursorRect.getLeft() + (density.mo429toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness()) / 2)) << 32) | (Float.floatToRawIntBits(cursorRect.getBottom()) & 4294967295L));
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

    public final void showSelectionToolbar$foundation_release() {
        LegacyTextFieldState legacyTextFieldState;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (getEnabled() && ((legacyTextFieldState = this.state) == null || legacyTextFieldState.isInTouchMode())) {
                Unit unit = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                    this.toolbarRequester.show();
                } else {
                    showSelectionToolbarViaTextToolbar();
                }
            }
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    private final Job showSelectionToolbarViaTextToolbar() {
        Job launch$default;
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1(this, null), 1, null);
            return launch$default;
        }
        return null;
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.hide();
            return;
        }
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M  reason: not valid java name */
    public final void m1835selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long j) {
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || TextLayoutHelperKt.m1384isPositionInsideSelectionuaM50fQ(layoutResult.getValue(), layoutResult.m1389translateDecorationToInnerCoordinatesMKHz9U$foundation_release(j), TextRange.m7445boximpl(getValue$foundation_release().m7708getSelectiond9O1mEE()))) {
            return;
        }
        m1829updateSelection8UEBfa8(getValue$foundation_release(), j, true, false, SelectionAdjustment.Companion.getWord(), false);
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
                int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m7457getStartimpl(getValue$foundation_release().m7708getSelectiond9O1mEE()));
                int originalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m7452getEndimpl(getValue$foundation_release().m7708getSelectiond9O1mEE()));
                LegacyTextFieldState legacyTextFieldState2 = this.state;
                long m5051getZeroF1C5BW0 = (legacyTextFieldState2 == null || (layoutCoordinates4 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? Offset.Companion.m5051getZeroF1C5BW0() : layoutCoordinates4.mo6708localToRootMKHz9U(m1833getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState legacyTextFieldState3 = this.state;
                long m5051getZeroF1C5BW02 = (legacyTextFieldState3 == null || (layoutCoordinates3 = legacyTextFieldState3.getLayoutCoordinates()) == null) ? Offset.Companion.m5051getZeroF1C5BW0() : layoutCoordinates3.mo6708localToRootMKHz9U(m1833getHandlePositiontuRUvjQ$foundation_release(false));
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
                    f = Float.intBitsToFloat((int) (layoutCoordinates2.mo6708localToRootMKHz9U(Offset.m5027constructorimpl((Float.floatToRawIntBits((layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(originalToTransformed)) == null) ? 0.0f : cursorRect2.getTop()) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32))) & 4294967295L));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.state;
                if (legacyTextFieldState5 != null && (layoutCoordinates = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    f2 = Float.intBitsToFloat((int) (layoutCoordinates.mo6708localToRootMKHz9U(Offset.m5027constructorimpl((Float.floatToRawIntBits(0.0f) << c) | (Float.floatToRawIntBits((layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(originalToTransformed2)) == null) ? 0.0f : cursorRect.getTop()) & j))) & j));
                }
                int i = (int) (m5051getZeroF1C5BW0 >> c);
                int i2 = (int) (m5051getZeroF1C5BW02 >> c);
                return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(f, f2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (m5051getZeroF1C5BW0 & j)), Float.intBitsToFloat((int) (m5051getZeroF1C5BW02 & j))) + (Dp.m7995constructorimpl(25) * legacyTextFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.Companion.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8  reason: not valid java name */
    public final long m1829updateSelection8UEBfa8(TextFieldValue textFieldValue, long j, boolean z, boolean z2, SelectionAdjustment selectionAdjustment, boolean z3) {
        TextLayoutResultProxy layoutResult;
        int i;
        HapticFeedback hapticFeedback;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.Companion.m7462getZerod9O1mEE();
        }
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m7457getStartimpl(textFieldValue.m7708getSelectiond9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.m7452getEndimpl(textFieldValue.m7708getSelectiond9O1mEE())));
        boolean z4 = false;
        int m1387getOffsetForPosition3MmeM6k = layoutResult.m1387getOffsetForPosition3MmeM6k(j, false);
        int m7457getStartimpl = (z2 || z) ? m1387getOffsetForPosition3MmeM6k : TextRange.m7457getStartimpl(TextRange);
        int m7452getEndimpl = (!z2 || z) ? m1387getOffsetForPosition3MmeM6k : TextRange.m7452getEndimpl(TextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        if (z || selectionLayout == null || (i = this.previousRawDragOffset) == -1) {
            i = -1;
        }
        SelectionLayout m1771getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1771getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), m7457getStartimpl, m7452getEndimpl, i, TextRange, z, z2);
        if (!m1771getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return textFieldValue.m7708getSelectiond9O1mEE();
        }
        this.previousSelectionLayout = m1771getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = m1387getOffsetForPosition3MmeM6k;
        Selection adjust = selectionAdjustment.adjust(m1771getTextFieldSelectionLayoutRcvTLA);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(adjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(adjust.getEnd().getOffset()));
        if (TextRange.m7450equalsimpl0(TextRange2, textFieldValue.m7708getSelectiond9O1mEE())) {
            return textFieldValue.m7708getSelectiond9O1mEE();
        }
        boolean z5 = TextRange.m7456getReversedimpl(TextRange2) != TextRange.m7456getReversedimpl(textFieldValue.m7708getSelectiond9O1mEE()) && TextRange.m7450equalsimpl0(TextRangeKt.TextRange(TextRange.m7452getEndimpl(TextRange2), TextRange.m7457getStartimpl(TextRange2)), textFieldValue.m7708getSelectiond9O1mEE());
        boolean z6 = TextRange.m7451getCollapsedimpl(TextRange2) && TextRange.m7451getCollapsedimpl(textFieldValue.m7708getSelectiond9O1mEE());
        if (z3 && textFieldValue.getText().length() > 0 && !z5 && !z6 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo6053performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m6070getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m1825createTextFieldValueFDrldGo(textFieldValue.getAnnotatedString(), TextRange2));
        this.latestSelection = TextRange.m7445boximpl(TextRange2);
        if (!z3) {
            updateFloatingToolbar(!TextRange.m7451getCollapsedimpl(TextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(z3);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.m7451getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.m7451getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 != null) {
            if (TextRange.m7451getCollapsedimpl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true)) {
                z4 = true;
            }
            legacyTextFieldState5.setShowCursorHandle(z4);
        }
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
    public final TextFieldValue m1825createTextFieldValueFDrldGo(AnnotatedString annotatedString, long j) {
        return new TextFieldValue(annotatedString, j, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
