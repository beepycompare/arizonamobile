package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.focus.FocusProperties;
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
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001:\u0006ã\u0001ä\u0001å\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\tH\u0000¢\u0006\u0002\bzJ\b\u0010{\u001a\u00020\tH\u0002J\u0006\u0010|\u001a\u00020}J\u0006\u0010~\u001a\u00020}J\u001c\u0010\u007f\u001a\u00020}2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u001d\u0010\u0084\u0001\u001a\u00020}2\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J@\u0010\u0085\u0001\u001a\u0002022\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u00142\u0007\u0010\u0086\u0001\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u0015\u0010\u0087\u0001\u001a\u000202*\u00030\u0088\u0001H\u0086@¢\u0006\u0003\u0010\u0089\u0001J\u001e\u0010\u008a\u0001\u001a\u000202*\u00030\u0088\u00012\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010\u008c\u0001J\u0010\u0010\u008d\u0001\u001a\u000202H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\u000f\u0010\u008f\u0001\u001a\u0002022\u0006\u0010]\u001a\u00020\\J\u0007\u0010\u0090\u0001\u001a\u000202J\u0015\u0010\u0091\u0001\u001a\u000202*\u00030\u0088\u0001H\u0086@¢\u0006\u0003\u0010\u0089\u0001J?\u0010\u0092\u0001\u001a\u000202*\u00030\u0088\u00012\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u00012\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u000202012\r\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020201H\u0086@¢\u0006\u0003\u0010\u0097\u0001J\u0019\u0010\u0098\u0001\u001a\u00020\t2\u0007\u0010\u0099\u0001\u001a\u00020;¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0015\u0010\u009c\u0001\u001a\u000202*\u00030\u0088\u0001H\u0082@¢\u0006\u0003\u0010\u0089\u0001J$\u0010\u009d\u0001\u001a\u000202*\u00030\u0088\u00012\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020201H\u0086@¢\u0006\u0003\u0010\u009e\u0001J\u0007\u0010\u009f\u0001\u001a\u000202J\u001e\u0010 \u0001\u001a\u000202*\u00030\u0088\u00012\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0082@¢\u0006\u0003\u0010\u008c\u0001J\u0010\u0010¡\u0001\u001a\u000202H\u0082@¢\u0006\u0003\u0010\u008e\u0001J\u0010\u0010¢\u0001\u001a\u000202H\u0082@¢\u0006\u0003\u0010\u008e\u0001J\t\u0010¨\u0001\u001a\u00020}H\u0002J \u0010©\u0001\u001a\u00020x2\u0007\u0010\u008b\u0001\u001a\u00020\t2\u0006\u0010y\u001a\u00020\tH\u0000¢\u0006\u0003\bª\u0001J\u001b\u0010«\u0001\u001a\u00020;2\u0007\u0010\u008b\u0001\u001a\u00020\tH\u0002¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\"\u0010®\u0001\u001a\u0002022\u0007\u0010¯\u0001\u001a\u00020J2\u0007\u0010°\u0001\u001a\u00020;¢\u0006\u0006\b±\u0001\u0010²\u0001J\t\u0010³\u0001\u001a\u000202H\u0002J\u0007\u0010´\u0001\u001a\u000202J\u0007\u0010µ\u0001\u001a\u00020\tJ\n\u0010¶\u0001\u001a\u00020\tH\u0086\bJ\u0010\u0010·\u0001\u001a\u000202H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001J\u0007\u0010º\u0001\u001a\u00020\tJ\n\u0010»\u0001\u001a\u00020\tH\u0086\bJ\u001b\u0010¼\u0001\u001a\u0002022\t\b\u0002\u0010½\u0001\u001a\u00020\tH\u0086@¢\u0006\u0003\u0010¾\u0001J\u001d\u0010¿\u0001\u001a\u0005\u0018\u00010¹\u00012\t\b\u0002\u0010½\u0001\u001a\u00020\tH\u0000¢\u0006\u0003\bÀ\u0001J\u0010\u0010Ã\u0001\u001a\u000202H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\u0007\u0010Ä\u0001\u001a\u00020\tJ\n\u0010Å\u0001\u001a\u00020\tH\u0086\bJ\u0010\u0010Æ\u0001\u001a\u000202H\u0086@¢\u0006\u0003\u0010\u008e\u0001J\u0010\u0010Ç\u0001\u001a\u000202H\u0082@¢\u0006\u0003\u0010\u008e\u0001J\u0018\u0010È\u0001\u001a\u0002022\u0007\u0010 \u001a\u00030¹\u0001H\u0000¢\u0006\u0003\bÉ\u0001J\u0007\u0010Ê\u0001\u001a\u00020\tJ\u0007\u0010Ë\u0001\u001a\u000202J\u0007\u0010Ì\u0001\u001a\u00020\tJ\u0007\u0010Í\u0001\u001a\u000202J\u0019\u0010\u0086\u0001\u001a\u0002022\u0007\u0010Î\u0001\u001a\u00020}H\u0082@¢\u0006\u0003\u0010Ï\u0001J\u0007\u0010Ð\u0001\u001a\u000202J\t\u0010Ñ\u0001\u001a\u000202H\u0002JX\u0010Ò\u0001\u001a\u00030Ó\u00012\b\u0010Ô\u0001\u001a\u00030\u0083\u00012\u0007\u0010Õ\u0001\u001a\u00020p2\u0007\u0010Ö\u0001\u001a\u00020p2\u0007\u0010\u008b\u0001\u001a\u00020\t2\b\u0010×\u0001\u001a\u00030Ø\u00012\t\b\u0002\u0010Ù\u0001\u001a\u00020\t2\t\b\u0002\u0010Ú\u0001\u001a\u00020\tH\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001JD\u0010Ý\u0001\u001a\u00030Ó\u00012\u0007\u0010Þ\u0001\u001a\u00020p2\u0007\u0010ß\u0001\u001a\u00020p2\n\u0010à\u0001\u001a\u0005\u0018\u00010Ó\u00012\u0007\u0010\u008b\u0001\u001a\u00020\t2\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0002¢\u0006\u0006\bá\u0001\u0010â\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u001e\u0010\n\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\"\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R+\u0010<\u001a\u00020;2\u0006\u0010+\u001a\u00020;8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010/\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010>R+\u0010D\u001a\u00020;2\u0006\u0010+\u001a\u00020;8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010/\u001a\u0004\bE\u0010>\"\u0004\bF\u0010@R\u0011\u0010H\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\bI\u0010>R/\u0010K\u001a\u0004\u0018\u00010J2\b\u0010+\u001a\u0004\u0018\u00010J8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010/\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR+\u0010R\u001a\u00020Q2\u0006\u0010+\u001a\u00020Q8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010/\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR+\u0010X\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010/\u001a\u0004\bY\u0010\u001b\"\u0004\bZ\u0010\u001dR+\u0010]\u001a\u00020\\2\u0006\u0010+\u001a\u00020\\8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bb\u0010/\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR+\u0010c\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010/\u001a\u0004\bd\u0010\u001b\"\u0004\be\u0010\u001dR\u0016\u0010g\u001a\u0004\u0018\u00010h8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u001bR\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020pX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010£\u0001\u001a\u0004\u0018\u00010}8@X\u0080\u0084\u0002¢\u0006\u0010\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0010\u0010Á\u0001\u001a\u00030Â\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006æ\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "density", "Landroidx/compose/ui/unit/Density;", "enabled", "", "readOnly", "isFocused", "isPassword", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZLandroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;Landroidx/compose/ui/platform/Clipboard;)V", "getTextFieldState$foundation", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "getTextLayoutState$foundation", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "()Z", "setFocused", "(Z)V", "getPlatformSelectionBehaviors$foundation", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "value", "getEnabled", "getReadOnly", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "textToolbarHandler", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "<set-?>", "isInTouchMode", "setInTouchMode", "isInTouchMode$delegate", "Landroidx/compose/runtime/MutableState;", "requestAutofillAction", "Lkotlin/Function0;", "", "getRequestAutofillAction", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction", "(Lkotlin/jvm/functions/Function0;)V", "receiveContentConfiguration", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "getReceiveContentConfiguration", "setReceiveContentConfiguration", "Landroidx/compose/ui/geometry/Offset;", "startTextLayoutPositionInWindow", "getStartTextLayoutPositionInWindow-F1C5BW0", "()J", "setStartTextLayoutPositionInWindow-k-4lQ0M", "(J)V", "startTextLayoutPositionInWindow$delegate", "currentTextLayoutPositionInWindow", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "rawHandleDragPosition", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "rawHandleDragPosition$delegate", "handleDragPosition", "getHandleDragPosition-F1C5BW0", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator$delegate", "showCursorHandle", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle$delegate", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "textToolbarState$delegate", "textToolbarShown", "getTextToolbarShown", "setTextToolbarShown$foundation", "textToolbarShown$delegate", "textLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "editable", "getEditable$foundation", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "previousRawDragOffset", "", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "getPressInteraction", "()Landroidx/compose/foundation/interaction/PressInteraction$Press;", "setPressInteraction", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)V", "getCursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "includePosition", "getCursorHandleState$foundation", "isCursorHandleInVisibleBounds", "getCursorRect", "Landroidx/compose/ui/geometry/Rect;", "getFocusRect", "calculateCursorRect", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "visualText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "calculateSelectionRect", "update", "showTextToolbar", "cursorHandleGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionHandleGestures", "isStartHandle", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startToolbarAndHandlesVisibilityObserver", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTextToolbarState", "dispose", "detectTouchMode", "detectTextFieldTapGestures", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "requestFocus", "showKeyboard", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeCursorAtNearestOffset", TypedValues.CycleType.S_WAVE_OFFSET, "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "detectCursorHandleDragGestures", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "maybeSuggestSelectionRange", "detectSelectionHandleDragGestures", "observeTextChanges", "observeTextToolbarVisibility", "derivedVisibleContentBounds", "getDerivedVisibleContentBounds$foundation", "()Landroidx/compose/ui/geometry/Rect;", "derivedVisibleContentBounds$delegate", "Landroidx/compose/runtime/State;", "getContentRect", "getSelectionHandleState", "getSelectionHandleState$foundation", "getHandlePosition", "getHandlePosition-tuRUvjQ", "(Z)J", "updateHandleDragging", "handle", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "markStartContentVisibleOffset", "clearHandleDragging", "canShowCutMenuItem", "isCutAllowed", "cut", "cutWithResult", "Landroidx/compose/ui/text/AnnotatedString;", "canShowCopyMenuItem", "isCopyAllowed", "copy", "cancelSelection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyWithResult", "copyWithResult$foundation", "clipboardPasteState", "Landroidx/compose/foundation/text/input/internal/selection/ClipboardPasteState;", "updateClipboardEntry", "canShowPasteMenuItem", "isPasteAllowed", "paste", "pasteAsPlainText", "onPasteEvent", "onPasteEvent$foundation", "canShowSelectAllMenuItem", "selectAll", "canShowAutofillMenuItem", "autofill", "contentRect", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deselect", "hideTextToolbar", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "textFieldCharSequence", "startOffset", "endOffset", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "allowPreviousSelectionCollapsed", "isStartOfSelection", "updateSelection-SsL-Rf8$foundation", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "getTextFieldSelection", "rawStartOffset", "rawEndOffset", "previousSelection", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private Clipboard clipboard;
    private ClipboardPasteState clipboardPasteState;
    private final CoroutineScope coroutineScope;
    private Density density;
    private final State derivedVisibleContentBounds$delegate;
    private final MutableState directDragGestureInitiator$delegate;
    private final MutableState draggingHandle$delegate;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;
    private final MutableState isInTouchMode$delegate;
    private boolean isPassword;
    private final PlatformSelectionBehaviors platformSelectionBehaviors;
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
    private final MutableState textToolbarShown$delegate;
    private final MutableState textToolbarState$delegate;
    private final ToolbarRequester toolbarRequester;

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* synthetic */ class WhenMappings {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean observeTextToolbarVisibility$lambda$1$0(Rect rect) {
        return rect == null;
    }

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Density density, boolean z, boolean z2, boolean z3, boolean z4, ToolbarRequester toolbarRequester, CoroutineScope coroutineScope, PlatformSelectionBehaviors platformSelectionBehaviors, Clipboard clipboard) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.isFocused = z3;
        this.isPassword = z4;
        this.toolbarRequester = toolbarRequester;
        this.coroutineScope = coroutineScope;
        this.platformSelectionBehaviors = platformSelectionBehaviors;
        this.clipboard = clipboard;
        this.enabled = z;
        this.readOnly = z2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.isInTouchMode$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4516boximpl(Offset.Companion.m4542getUnspecifiedF1C5BW0()), null, 2, null);
        this.startTextLayoutPositionInWindow$delegate = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m4516boximpl(Offset.Companion.m4542getUnspecifiedF1C5BW0()), null, 2, null);
        this.rawHandleDragPosition$delegate = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle$delegate = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputType.None, null, 2, null);
        this.directDragGestureInitiator$delegate = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.showCursorHandle$delegate = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
        this.textToolbarState$delegate = mutableStateOf$default7;
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.textToolbarShown$delegate = mutableStateOf$default8;
        this.previousRawDragOffset = -1;
        this.derivedVisibleContentBounds$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldSelectionState.derivedVisibleContentBounds_delegate$lambda$0(TextFieldSelectionState.this);
            }
        });
        this.clipboardPasteState = new ClipboardPasteState(this.clipboard);
    }

    public final TransformedTextFieldState getTextFieldState$foundation() {
        return this.textFieldState;
    }

    public final TextLayoutState getTextLayoutState$foundation() {
        return this.textLayoutState;
    }

    public final boolean isFocused() {
        return this.isFocused;
    }

    public final void setFocused(boolean z) {
        this.isFocused = z;
    }

    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors$foundation() {
        return this.platformSelectionBehaviors;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
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
    private final long m1503getStartTextLayoutPositionInWindowF1C5BW0() {
        return ((Offset) this.startTextLayoutPositionInWindow$delegate.getValue()).m4537unboximpl();
    }

    /* renamed from: setStartTextLayoutPositionInWindow-k-4lQ0M  reason: not valid java name */
    private final void m1506setStartTextLayoutPositionInWindowk4lQ0M(long j) {
        this.startTextLayoutPositionInWindow$delegate.setValue(Offset.m4516boximpl(j));
    }

    /* renamed from: getCurrentTextLayoutPositionInWindow-F1C5BW0  reason: not valid java name */
    private final long m1500getCurrentTextLayoutPositionInWindowF1C5BW0() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return textLayoutCoordinates != null ? LayoutCoordinatesKt.positionInWindow(textLayoutCoordinates) : Offset.Companion.m4542getUnspecifiedF1C5BW0();
    }

    /* renamed from: getRawHandleDragPosition-F1C5BW0  reason: not valid java name */
    private final long m1502getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition$delegate.getValue()).m4537unboximpl();
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M  reason: not valid java name */
    private final void m1505setRawHandleDragPositionk4lQ0M(long j) {
        this.rawHandleDragPosition$delegate.setValue(Offset.m4516boximpl(j));
    }

    /* renamed from: getHandleDragPosition-F1C5BW0  reason: not valid java name */
    public final long m1508getHandleDragPositionF1C5BW0() {
        if ((m1502getRawHandleDragPositionF1C5BW0() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return Offset.Companion.m4542getUnspecifiedF1C5BW0();
        }
        if ((m1503getStartTextLayoutPositionInWindowF1C5BW0() & 9223372034707292159L) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return TextLayoutStateKt.m1454fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1502getRawHandleDragPositionF1C5BW0());
        }
        return Offset.m4532plusMKHz9U(m1502getRawHandleDragPositionF1C5BW0(), Offset.m4531minusMKHz9U(m1503getStartTextLayoutPositionInWindowF1C5BW0(), m1500getCurrentTextLayoutPositionInWindowF1C5BW0()));
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle$delegate.getValue()).booleanValue();
    }

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

    public final boolean getTextToolbarShown() {
        return ((Boolean) this.textToolbarShown$delegate.getValue()).booleanValue();
    }

    public final void setTextToolbarShown$foundation(boolean z) {
        this.textToolbarShown$delegate.setValue(Boolean.valueOf(z));
    }

    private final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    public final boolean getEditable$foundation() {
        return this.enabled && !this.readOnly;
    }

    public final PressInteraction.Press getPressInteraction() {
        return this.pressInteraction;
    }

    public final void setPressInteraction(PressInteraction.Press press) {
        this.pressInteraction = press;
    }

    public final TextFieldHandleState getCursorHandleState$foundation(boolean z) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        boolean showCursorHandle = getShowCursorHandle();
        boolean z2 = getDirectDragGestureInitiator() == InputType.None;
        Handle draggingHandle = getDraggingHandle();
        if (!showCursorHandle || !z2 || !TextRange.m6997getCollapsedimpl(visualText.m1336getSelectiond9O1mEE()) || !visualText.shouldShowSelection() || visualText.length() <= 0 || (draggingHandle != Handle.Cursor && !isCursorHandleInVisibleBounds())) {
            return TextFieldHandleState.Companion.getHidden();
        }
        return new TextFieldHandleState(true, z ? getCursorRect().m4554getBottomCenterF1C5BW0() : Offset.Companion.m4542getUnspecifiedF1C5BW0(), 0.0f, ResolvedTextDirection.Ltr, false, null);
    }

    private final boolean isCursorHandleInVisibleBounds() {
        Rect visibleBounds;
        Snapshot.Companion companion = Snapshot.Companion;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            long m4554getBottomCenterF1C5BW0 = getCursorRect().m4554getBottomCenterF1C5BW0();
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (textLayoutCoordinates == null || (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) {
                return false;
            }
            return SelectionManagerKt.m1635containsInclusiveUv8p0NA(visibleBounds, m4554getBottomCenterF1C5BW0);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    public final Rect getCursorRect() {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        return layoutResult == null ? Rect.Companion.getZero() : calculateCursorRect(layoutResult, this.textFieldState.getVisualText());
    }

    public final Rect getFocusRect() {
        Rect calculateSelectionRect;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.Companion.getZero();
        }
        if (this.isFocused) {
            TextFieldCharSequence visualText = this.textFieldState.getVisualText();
            if (TextRange.m6997getCollapsedimpl(visualText.m1336getSelectiond9O1mEE())) {
                calculateSelectionRect = calculateCursorRect(layoutResult, visualText);
            } else {
                calculateSelectionRect = calculateSelectionRect(layoutResult, visualText);
            }
            return TextLayoutStateKt.fromTextLayoutToDecoration(this.textLayoutState, calculateSelectionRect);
        }
        return FocusProperties.Companion.getUnsetFocusRect();
    }

    private final Rect calculateCursorRect(TextLayoutResult textLayoutResult, TextFieldCharSequence textFieldCharSequence) {
        float right;
        float rint;
        if (TextRange.m6997getCollapsedimpl(textFieldCharSequence.m1336getSelectiond9O1mEE())) {
            Rect cursorRect = textLayoutResult.getCursorRect(TextRange.m7003getStartimpl(textFieldCharSequence.m1336getSelectiond9O1mEE()));
            float coerceAtLeast = RangesKt.coerceAtLeast((float) Math.floor(this.density.mo405toPx0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness())), 1.0f);
            if (textLayoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
                right = cursorRect.getLeft() + (coerceAtLeast / 2.0f);
            } else {
                right = cursorRect.getRight() - (coerceAtLeast / 2.0f);
            }
            float f = coerceAtLeast / 2.0f;
            float coerceAtLeast2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(right, ((int) (textLayoutResult.m6974getSizeYbymL2g() >> 32)) - f), f);
            if (((int) coerceAtLeast) % 2 == 1) {
                rint = ((float) Math.floor(coerceAtLeast2)) + 0.5f;
            } else {
                rint = (float) Math.rint(coerceAtLeast2);
            }
            return new Rect(rint - f, cursorRect.getTop(), rint + f, cursorRect.getBottom());
        }
        return Rect.Companion.getZero();
    }

    private final Rect calculateSelectionRect(TextLayoutResult textLayoutResult, TextFieldCharSequence textFieldCharSequence) {
        if (TextRange.m6997getCollapsedimpl(textFieldCharSequence.m1336getSelectiond9O1mEE())) {
            return Rect.Companion.getZero();
        }
        int lineForOffset = textLayoutResult.getLineForOffset(TextRange.m7003getStartimpl(textFieldCharSequence.m1336getSelectiond9O1mEE()));
        int lineForOffset2 = textLayoutResult.getLineForOffset(TextRange.m6998getEndimpl(textFieldCharSequence.m1336getSelectiond9O1mEE()));
        if (lineForOffset == lineForOffset2) {
            float horizontalPosition = textLayoutResult.getHorizontalPosition(TextRange.m7003getStartimpl(textFieldCharSequence.m1336getSelectiond9O1mEE()), true);
            float horizontalPosition2 = textLayoutResult.getHorizontalPosition(TextRange.m6998getEndimpl(textFieldCharSequence.m1336getSelectiond9O1mEE()), true);
            return new Rect(Math.min(horizontalPosition, horizontalPosition2), textLayoutResult.getLineTop(lineForOffset), Math.max(horizontalPosition, horizontalPosition2), textLayoutResult.getLineBottom(lineForOffset2));
        }
        return textLayoutResult.getPathForRange(TextRange.m7001getMinimpl(textFieldCharSequence.m1336getSelectiond9O1mEE()), TextRange.m7000getMaximpl(textFieldCharSequence.m1336getSelectiond9O1mEE())).getBounds();
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
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0056 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startToolbarAndHandlesVisibilityObserver(Continuation<? super Unit> continuation) {
        TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1;
        int i;
        try {
            if (continuation instanceof TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1) {
                textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 = (TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1) continuation;
                if ((textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label & Integer.MIN_VALUE) != 0) {
                    textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label -= Integer.MIN_VALUE;
                    Object obj = textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label = 1;
                        obj = CoroutineScopeKt.coroutineScope(new TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$2(this, null), textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    Job job = (Job) obj;
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            Job job2 = (Job) obj;
            return Unit.INSTANCE;
        } finally {
            setShowCursorHandle(false);
            if (getTextToolbarState() != TextToolbarState.None) {
                hideTextToolbar();
            }
        }
        textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 = new TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1(this, continuation);
        Object obj2 = textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1.label;
    }

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }

    public final void dispose() {
        hideTextToolbar();
        this.hapticFeedBack = null;
    }

    public final Object detectTouchMode(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TextFieldSelectionState$detectTouchMode$2(this, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }

    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super Unit> continuation) {
        Object detectTextFieldTapGestures = TextFieldSelectionState_androidKt.detectTextFieldTapGestures(this, pointerInputScope, mutableInteractionSource, function0, function02, continuation);
        return detectTextFieldTapGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTextFieldTapGestures : Unit.INSTANCE;
    }

    /* renamed from: placeCursorAtNearestOffset-k-4lQ0M  reason: not valid java name */
    public final boolean m1509placeCursorAtNearestOffsetk4lQ0M(long j) {
        int m6973getOffsetForPositionk4lQ0M;
        IndexTransformationType indexTransformationType;
        int m7003getStartimpl;
        SelectionWedgeAffinity selectionWedgeAffinity;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null || (m6973getOffsetForPositionk4lQ0M = layoutResult.m6973getOffsetForPositionk4lQ0M(j)) == -1) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        long m1461mapFromTransformedjx7JFs = transformedTextFieldState.m1461mapFromTransformedjx7JFs(m6973getOffsetForPositionk4lQ0M);
        long m1464mapToTransformedGEjPoXI = transformedTextFieldState.m1464mapToTransformedGEjPoXI(m1461mapFromTransformedjx7JFs);
        if (TextRange.m6997getCollapsedimpl(m1461mapFromTransformedjx7JFs) && TextRange.m6997getCollapsedimpl(m1464mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Untransformed;
        } else if (!TextRange.m6997getCollapsedimpl(m1461mapFromTransformedjx7JFs) && !TextRange.m6997getCollapsedimpl(m1464mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Replacement;
        } else if (TextRange.m6997getCollapsedimpl(m1461mapFromTransformedjx7JFs) && !TextRange.m6997getCollapsedimpl(m1464mapToTransformedGEjPoXI)) {
            indexTransformationType = IndexTransformationType.Insertion;
        } else {
            indexTransformationType = IndexTransformationType.Deletion;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[indexTransformationType.ordinal()];
        SelectionWedgeAffinity selectionWedgeAffinity2 = null;
        if (i == 1) {
            m7003getStartimpl = TextRange.m7003getStartimpl(m1461mapFromTransformedjx7JFs);
        } else if (i == 2) {
            m7003getStartimpl = TextRange.m7003getStartimpl(m1461mapFromTransformedjx7JFs);
        } else if (i == 3) {
            if (MathUtilsKt.m1406findClosestRect9KIMszo(j, layoutResult.getCursorRect(TextRange.m7003getStartimpl(m1464mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m6998getEndimpl(m1464mapToTransformedGEjPoXI))) < 0) {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.Start);
            } else {
                selectionWedgeAffinity = new SelectionWedgeAffinity(WedgeAffinity.End);
            }
            selectionWedgeAffinity2 = selectionWedgeAffinity;
            m7003getStartimpl = TextRange.m7003getStartimpl(m1461mapFromTransformedjx7JFs);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (MathUtilsKt.m1406findClosestRect9KIMszo(j, layoutResult.getCursorRect(TextRange.m7003getStartimpl(m1464mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m6998getEndimpl(m1464mapToTransformedGEjPoXI))) < 0) {
                m7003getStartimpl = TextRange.m7003getStartimpl(m1461mapFromTransformedjx7JFs);
            } else {
                m7003getStartimpl = TextRange.m6998getEndimpl(m1461mapFromTransformedjx7JFs);
            }
        }
        long TextRange = TextRangeKt.TextRange(m7003getStartimpl);
        if (TextRange.m6996equalsimpl0(TextRange, this.textFieldState.getUntransformedText().m1336getSelectiond9O1mEE()) && (selectionWedgeAffinity2 == null || Intrinsics.areEqual(selectionWedgeAffinity2, this.textFieldState.getSelectionWedgeAffinity()))) {
            return false;
        }
        this.textFieldState.m1467selectUntransformedCharsIn5zctL8(TextRange);
        if (selectionWedgeAffinity2 != null) {
            this.textFieldState.setSelectionWedgeAffinity(selectionWedgeAffinity2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectCursorHandleDragGestures(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        TextFieldSelectionState$detectCursorHandleDragGestures$1 textFieldSelectionState$detectCursorHandleDragGestures$1;
        int i;
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
                    longRef3.element = Offset.Companion.m4542getUnspecifiedF1C5BW0();
                    final Ref.LongRef longRef4 = new Ref.LongRef();
                    longRef4.element = Offset.Companion.m4542getUnspecifiedF1C5BW0();
                    try {
                        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$0(Ref.LongRef.this, this, longRef4, (Offset) obj2);
                            }
                        };
                        Function0 function0 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$1(Ref.LongRef.this, longRef4, this);
                            }
                        };
                        Function0 function02 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$2(Ref.LongRef.this, longRef4, this);
                            }
                        };
                        Function2 function2 = new Function2() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return TextFieldSelectionState.detectCursorHandleDragGestures$lambda$3(Ref.LongRef.this, this, longRef3, (PointerInputChange) obj2, (Offset) obj3);
                            }
                        };
                        textFieldSelectionState$detectCursorHandleDragGestures$12.L$0 = longRef3;
                        textFieldSelectionState$detectCursorHandleDragGestures$12.L$1 = longRef4;
                        textFieldSelectionState$detectCursorHandleDragGestures$12.label = 1;
                        if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function02, function2, textFieldSelectionState$detectCursorHandleDragGestures$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        longRef = longRef3;
                        longRef2 = longRef4;
                    } catch (Throwable th2) {
                        longRef = longRef3;
                        th = th2;
                        longRef2 = longRef4;
                        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, this);
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    longRef2 = (Ref.LongRef) textFieldSelectionState$detectCursorHandleDragGestures$12.L$1;
                    longRef = (Ref.LongRef) textFieldSelectionState$detectCursorHandleDragGestures$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, this);
                        throw th;
                    }
                }
                detectCursorHandleDragGestures$onDragStop(longRef, longRef2, this);
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
        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, this);
        return Unit.INSTANCE;
    }

    private static final void detectCursorHandleDragGestures$onDragStop(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        if ((longRef.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            longRef.element = Offset.Companion.m4542getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m4542getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectCursorHandleDragGestures$lambda$0(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2, Offset offset) {
        longRef.element = SelectionHandlesKt.m1608getAdjustedCoordinatesk4lQ0M(textFieldSelectionState.getCursorRect().m4554getBottomCenterF1C5BW0());
        longRef2.element = Offset.Companion.m4543getZeroF1C5BW0();
        textFieldSelectionState.setInTouchMode(true);
        textFieldSelectionState.markStartContentVisibleOffset();
        textFieldSelectionState.m1510updateHandleDraggingUv8p0NA(Handle.Cursor, longRef.element);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectCursorHandleDragGestures$lambda$1(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectCursorHandleDragGestures$lambda$2(Ref.LongRef longRef, Ref.LongRef longRef2, TextFieldSelectionState textFieldSelectionState) {
        detectCursorHandleDragGestures$onDragStop(longRef, longRef2, textFieldSelectionState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectCursorHandleDragGestures$lambda$3(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2, PointerInputChange pointerInputChange, Offset offset) {
        longRef.element = Offset.m4532plusMKHz9U(longRef.element, offset.m4537unboximpl());
        textFieldSelectionState.m1510updateHandleDraggingUv8p0NA(Handle.Cursor, Offset.m4532plusMKHz9U(longRef2.element, longRef.element));
        if (textFieldSelectionState.m1509placeCursorAtNearestOffsetk4lQ0M(textFieldSelectionState.m1508getHandleDragPositionF1C5BW0())) {
            pointerInputChange.consume();
            HapticFeedback hapticFeedback = textFieldSelectionState.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.mo5541performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m5558getTextHandleMove5zf0vsI());
            }
        }
        return Unit.INSTANCE;
    }

    public final Object textFieldSelectionGestures(PointerInputScope pointerInputScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object textFieldSelectionGestures = TextFieldSelectionState_androidKt.textFieldSelectionGestures(this, pointerInputScope, new TextFieldMouseSelectionObserver(function0), new TextFieldTextDragObserver(function0), continuation);
        return textFieldSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? textFieldSelectionGestures : Unit.INSTANCE;
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0016J\u0017\u0010!\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010#R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "requestFocus", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "isDoubleOrTripleClickOnly", "", "onStart", "downPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "clickCount", "onStart-9KIMszo", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;I)Z", "onDrag", "dragPosition", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "updateSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "isStartOfSelection", "updateSelection-12glfjA", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/ui/text/TextLayoutResult;Z)J", "onDragDone", "onExtend", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.Companion.m4542getUnspecifiedF1C5BW0();
        private boolean isDoubleOrTripleClickOnly = true;
        private final Function0<Unit> requestFocus;

        public TextFieldMouseSelectionObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onStart-9KIMszo  reason: not valid java name */
        public boolean mo1516onStart9KIMszo(long j, SelectionAdjustment selectionAdjustment, int i) {
            TextLayoutResult layoutResult = TextFieldSelectionState.this.getTextLayoutState$foundation().getLayoutResult();
            if (!TextFieldSelectionState.this.getEnabled() || layoutResult == null || TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().length() == 0) {
                return false;
            }
            this.isDoubleOrTripleClickOnly = i >= 2;
            TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionState.TextFieldMouseSelectionObserver.onStart_9KIMszo$lambda$0();
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Mouse);
            this.requestFocus.invoke();
            TextFieldSelectionState.this.previousRawDragOffset = -1;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = j;
            this.dragBeginOffsetInText = TextRange.m7003getStartimpl(m1512updateSelection12glfjA(j, selectionAdjustment, layoutResult, true));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String onStart_9KIMszo$lambda$0() {
            return "Mouse.onStart";
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onDrag-3MmeM6k  reason: not valid java name */
        public boolean mo1513onDrag3MmeM6k(final long j, SelectionAdjustment selectionAdjustment) {
            TextLayoutResult layoutResult = TextFieldSelectionState.this.getTextLayoutState$foundation().getLayoutResult();
            if (!TextFieldSelectionState.this.getEnabled() || layoutResult == null || TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionState.TextFieldMouseSelectionObserver.onDrag_3MmeM6k$lambda$0(j);
                }
            });
            if (TextRange.m6996equalsimpl0(TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE(), m1512updateSelection12glfjA(j, selectionAdjustment, layoutResult, false))) {
                return true;
            }
            this.isDoubleOrTripleClickOnly = false;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String onDrag_3MmeM6k$lambda$0(long j) {
            return "Mouse.onDrag " + ((Object) Offset.m4535toStringimpl(j));
        }

        /* renamed from: updateSelection-12glfjA  reason: not valid java name */
        private final long m1512updateSelection12glfjA(long j, SelectionAdjustment selectionAdjustment, TextLayoutResult textLayoutResult, boolean z) {
            int length = textLayoutResult.getLayoutInput().getText().length();
            int i = this.dragBeginOffsetInText;
            if (i < 0 || i > length) {
                i = TextFieldSelectionState.this.getTextLayoutState$foundation().m1449getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            }
            int m1449getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.getTextLayoutState$foundation().m1449getOffsetForPosition3MmeM6k(j, false);
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long m1511updateSelectionSsLRf8$foundation = textFieldSelectionState.m1511updateSelectionSsLRf8$foundation(textFieldSelectionState.getTextFieldState$foundation().getVisualText(), i, m1449getOffsetForPosition3MmeM6k, false, selectionAdjustment, false, z);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6997getCollapsedimpl(m1511updateSelectionSsLRf8$foundation)) {
                this.dragBeginOffsetInText = TextRange.m7003getStartimpl(m1511updateSelectionSsLRf8$foundation);
            }
            if (TextRange.m7002getReversedimpl(m1511updateSelectionSsLRf8$foundation)) {
                m1511updateSelectionSsLRf8$foundation = TextFieldSelectionStateKt.m1517access$reverse5zctL8(m1511updateSelectionSsLRf8$foundation);
            }
            TextFieldSelectionState.this.getTextFieldState$foundation().m1466selectCharsIn5zctL8(m1511updateSelectionSsLRf8$foundation);
            TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            return m1511updateSelectionSsLRf8$foundation;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String onDragDone$lambda$0() {
            return "Mouse.onDragDone";
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void onDragDone() {
            TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionState.TextFieldMouseSelectionObserver.onDragDone$lambda$0();
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
            if (this.isDoubleOrTripleClickOnly) {
                TextFieldSelectionState.this.maybeSuggestSelectionRange();
            }
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onExtend-k-4lQ0M  reason: not valid java name */
        public boolean mo1514onExtendk4lQ0M(long j) {
            TextLayoutResult layoutResult = TextFieldSelectionState.this.getTextLayoutState$foundation().getLayoutResult();
            if (!TextFieldSelectionState.this.getEnabled() || layoutResult == null || TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionState.TextFieldMouseSelectionObserver.onExtend_k_4lQ0M$lambda$0();
                }
            });
            this.isDoubleOrTripleClickOnly = false;
            this.requestFocus.invoke();
            m1512updateSelection12glfjA(j, SelectionAdjustment.Companion.getNone(), layoutResult, false);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String onExtend_k_4lQ0M$lambda$0() {
            return "Mouse.onExtend";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String onExtendDrag_k_4lQ0M$lambda$0() {
            return "Mouse.onExtendDrag";
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onExtendDrag-k-4lQ0M  reason: not valid java name */
        public boolean mo1515onExtendDragk4lQ0M(long j) {
            TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionState.TextFieldMouseSelectionObserver.onExtendDrag_k_4lQ0M$lambda$0();
                }
            });
            return true;
        }
    }

    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\u001f\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u0017R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "requestFocus", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Lkotlin/jvm/functions/Function0;)V", "dragBeginOffsetInText", "", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "isLongPressSelectionOnly", "", "selectionAdjustmentMode", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDragStop", "onDown", "point", "onDown-k-4lQ0M", "(J)V", "onUp", "onStop", "onCancel", "onStart", "startPoint", "selectionAdjustment", "onStart-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "onDrag", "delta", "onDrag-k-4lQ0M", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class TextFieldTextDragObserver implements TextDragObserver {
        private final Function0<Unit> requestFocus;
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.Companion.m4542getUnspecifiedF1C5BW0();
        private long dragTotalDistance = Offset.Companion.m4543getZeroF1C5BW0();
        private Handle actingHandle = Handle.SelectionEnd;
        private boolean isLongPressSelectionOnly = true;
        private SelectionAdjustment selectionAdjustmentMode = SelectionAdjustment.Companion.getNone();

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onDown-k-4lQ0M */
        public void mo1253onDownk4lQ0M(long j) {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onUp() {
        }

        public TextFieldTextDragObserver(Function0<Unit> function0) {
            this.requestFocus = function0;
        }

        private final void onDragStop() {
            if ((this.dragBeginPosition & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionState.TextFieldTextDragObserver.onDragStop$lambda$0();
                    }
                });
                TextFieldSelectionState.this.clearHandleDragging();
                this.dragBeginOffsetInText = -1;
                this.dragBeginPosition = Offset.Companion.m4542getUnspecifiedF1C5BW0();
                this.dragTotalDistance = Offset.Companion.m4543getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                this.selectionAdjustmentMode = SelectionAdjustment.Companion.getNone();
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
                this.requestFocus.invoke();
                if (this.isLongPressSelectionOnly) {
                    TextFieldSelectionState.this.maybeSuggestSelectionRange();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String onDragStop$lambda$0() {
            return "Touch.onDragStop";
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
        /* renamed from: onStart-3MmeM6k */
        public void mo1255onStart3MmeM6k(final long j, SelectionAdjustment selectionAdjustment) {
            if (TextFieldSelectionState.this.getEnabled()) {
                TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionState.TextFieldTextDragObserver.onStart_3MmeM6k$lambda$0(j);
                    }
                });
                TextFieldSelectionState.this.m1510updateHandleDraggingUv8p0NA(this.actingHandle, j);
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Touch);
                this.dragBeginPosition = j;
                this.dragTotalDistance = Offset.Companion.m4543getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                this.isLongPressSelectionOnly = true;
                this.selectionAdjustmentMode = selectionAdjustment;
                if (TextFieldSelectionState.this.getTextLayoutState$foundation().getLayoutResult() == null) {
                    return;
                }
                boolean m1450isPositionOnTextk4lQ0M = TextFieldSelectionState.this.getTextLayoutState$foundation().m1450isPositionOnTextk4lQ0M(j);
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                if (!m1450isPositionOnTextk4lQ0M) {
                    int m1446getOffsetForPosition3MmeM6k$default = TextLayoutState.m1446getOffsetForPosition3MmeM6k$default(textFieldSelectionState.getTextLayoutState$foundation(), j, false, 2, null);
                    HapticFeedback hapticFeedBack = TextFieldSelectionState.this.getHapticFeedBack();
                    if (hapticFeedBack != null) {
                        hapticFeedBack.mo5541performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m5558getTextHandleMove5zf0vsI());
                    }
                    TextFieldSelectionState.this.getTextFieldState$foundation().placeCursorBeforeCharAt(m1446getOffsetForPosition3MmeM6k$default);
                    TextFieldSelectionState.this.setShowCursorHandle(true);
                    this.isLongPressSelectionOnly = false;
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Cursor);
                } else if (textFieldSelectionState.getTextFieldState$foundation().getVisualText().length() == 0) {
                } else {
                    int m1446getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m1446getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.getTextLayoutState$foundation(), j, false, 2, null);
                    long m1507updateSelectionSsLRf8$foundation$default = TextFieldSelectionState.m1507updateSelectionSsLRf8$foundation$default(TextFieldSelectionState.this, new TextFieldCharSequence(TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText(), TextRange.Companion.m7008getZerod9O1mEE(), null, null, null, null, 60, null), m1446getOffsetForPosition3MmeM6k$default2, m1446getOffsetForPosition3MmeM6k$default2, false, this.selectionAdjustmentMode, false, false, 96, null);
                    TextFieldSelectionState.this.getTextFieldState$foundation().m1466selectCharsIn5zctL8(m1507updateSelectionSsLRf8$foundation$default);
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                    this.dragBeginOffsetInText = TextRange.m7003getStartimpl(m1507updateSelectionSsLRf8$foundation$default);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String onStart_3MmeM6k$lambda$0(long j) {
            return "Touch.onDragStart after longPress at " + ((Object) Offset.m4535toStringimpl(j));
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onDrag-k-4lQ0M */
        public void mo1254onDragk4lQ0M(long j) {
            int intValue;
            int m1449getOffsetForPosition3MmeM6k;
            SelectionAdjustment selectionAdjustment;
            Handle handle;
            if (!TextFieldSelectionState.this.getEnabled() || TextFieldSelectionState.this.getTextLayoutState$foundation().getLayoutResult() == null || TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().length() == 0) {
                return;
            }
            long m4532plusMKHz9U = Offset.m4532plusMKHz9U(this.dragTotalDistance, j);
            this.dragTotalDistance = m4532plusMKHz9U;
            final long m4532plusMKHz9U2 = Offset.m4532plusMKHz9U(this.dragBeginPosition, m4532plusMKHz9U);
            TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TextFieldSelectionState.TextFieldTextDragObserver.onDrag_k_4lQ0M$lambda$0(m4532plusMKHz9U2);
                }
            });
            if (this.dragBeginOffsetInText < 0 && !TextFieldSelectionState.this.getTextLayoutState$foundation().m1450isPositionOnTextk4lQ0M(m4532plusMKHz9U2)) {
                intValue = TextLayoutState.m1446getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.getTextLayoutState$foundation(), this.dragBeginPosition, false, 2, null);
                m1449getOffsetForPosition3MmeM6k = TextLayoutState.m1446getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.getTextLayoutState$foundation(), m4532plusMKHz9U2, false, 2, null);
                if (intValue == m1449getOffsetForPosition3MmeM6k) {
                    selectionAdjustment = SelectionAdjustment.Companion.getNone();
                } else {
                    selectionAdjustment = this.selectionAdjustmentMode;
                }
            } else {
                Integer valueOf = Integer.valueOf(this.dragBeginOffsetInText);
                if (valueOf.intValue() < 0) {
                    valueOf = null;
                }
                intValue = valueOf != null ? valueOf.intValue() : TextFieldSelectionState.this.getTextLayoutState$foundation().m1449getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
                m1449getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.getTextLayoutState$foundation().m1449getOffsetForPosition3MmeM6k(m4532plusMKHz9U2, false);
                if (this.dragBeginOffsetInText < 0 && intValue == m1449getOffsetForPosition3MmeM6k) {
                    return;
                }
                selectionAdjustment = this.selectionAdjustmentMode;
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            }
            int i = intValue;
            int i2 = m1449getOffsetForPosition3MmeM6k;
            SelectionAdjustment selectionAdjustment2 = selectionAdjustment;
            long m1336getSelectiond9O1mEE = TextFieldSelectionState.this.getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE();
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long m1507updateSelectionSsLRf8$foundation$default = TextFieldSelectionState.m1507updateSelectionSsLRf8$foundation$default(textFieldSelectionState, textFieldSelectionState.getTextFieldState$foundation().getVisualText(), i, i2, false, selectionAdjustment2, false, false, 64, null);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6997getCollapsedimpl(m1507updateSelectionSsLRf8$foundation$default)) {
                this.dragBeginOffsetInText = TextRange.m7003getStartimpl(m1507updateSelectionSsLRf8$foundation$default);
            }
            if (TextRange.m7002getReversedimpl(m1507updateSelectionSsLRf8$foundation$default)) {
                m1507updateSelectionSsLRf8$foundation$default = TextFieldSelectionStateKt.m1517access$reverse5zctL8(m1507updateSelectionSsLRf8$foundation$default);
            }
            if (!TextRange.m6996equalsimpl0(m1507updateSelectionSsLRf8$foundation$default, m1336getSelectiond9O1mEE)) {
                if (TextRange.m7003getStartimpl(m1507updateSelectionSsLRf8$foundation$default) != TextRange.m7003getStartimpl(m1336getSelectiond9O1mEE) && TextRange.m6998getEndimpl(m1507updateSelectionSsLRf8$foundation$default) == TextRange.m6998getEndimpl(m1336getSelectiond9O1mEE)) {
                    handle = Handle.SelectionStart;
                } else if (TextRange.m7003getStartimpl(m1507updateSelectionSsLRf8$foundation$default) == TextRange.m7003getStartimpl(m1336getSelectiond9O1mEE) && TextRange.m6998getEndimpl(m1507updateSelectionSsLRf8$foundation$default) != TextRange.m6998getEndimpl(m1336getSelectiond9O1mEE)) {
                    handle = Handle.SelectionEnd;
                } else if ((TextRange.m7003getStartimpl(m1507updateSelectionSsLRf8$foundation$default) + TextRange.m6998getEndimpl(m1507updateSelectionSsLRf8$foundation$default)) / 2.0f > (TextRange.m7003getStartimpl(m1336getSelectiond9O1mEE) + TextRange.m6998getEndimpl(m1336getSelectiond9O1mEE)) / 2.0f) {
                    handle = Handle.SelectionEnd;
                } else {
                    handle = Handle.SelectionStart;
                }
                this.actingHandle = handle;
                this.isLongPressSelectionOnly = false;
            }
            if (TextRange.m6997getCollapsedimpl(m1336getSelectiond9O1mEE) || !TextRange.m6997getCollapsedimpl(m1507updateSelectionSsLRf8$foundation$default)) {
                TextFieldSelectionState.this.getTextFieldState$foundation().m1466selectCharsIn5zctL8(m1507updateSelectionSsLRf8$foundation$default);
            }
            TextFieldSelectionState.this.m1510updateHandleDraggingUv8p0NA(this.actingHandle, m4532plusMKHz9U2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final String onDrag_k_4lQ0M$lambda$0(long j) {
            return "Touch.onDrag at " + ((Object) Offset.m4535toStringimpl(j));
        }
    }

    public final void maybeSuggestSelectionRange() {
        PlatformSelectionBehaviors platformSelectionBehaviors = this.platformSelectionBehaviors;
        if (platformSelectionBehaviors == null) {
            return;
        }
        CharSequence text = this.textFieldState.getVisualText().getText();
        long m1336getSelectiond9O1mEE = this.textFieldState.getVisualText().m1336getSelectiond9O1mEE();
        if (text.length() <= 0 || TextRange.m6997getCollapsedimpl(m1336getSelectiond9O1mEE)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionState$maybeSuggestSelectionRange$1(platformSelectionBehaviors, text, m1336getSelectiond9O1mEE, this, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object detectSelectionHandleDragGestures(PointerInputScope pointerInputScope, final boolean z, Continuation<? super Unit> continuation) {
        TextFieldSelectionState$detectSelectionHandleDragGestures$1 textFieldSelectionState$detectSelectionHandleDragGestures$1;
        int i;
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
                    longRef3.element = Offset.Companion.m4542getUnspecifiedF1C5BW0();
                    final Ref.LongRef longRef4 = new Ref.LongRef();
                    longRef4.element = Offset.Companion.m4543getZeroF1C5BW0();
                    final Handle handle2 = z ? Handle.SelectionStart : Handle.SelectionEnd;
                    try {
                        try {
                            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$0(Ref.LongRef.this, this, z, handle2, longRef4, (Offset) obj2);
                                }
                            };
                            handle2 = handle2;
                            longRef3 = longRef3;
                            Function0 function0 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$1(Ref.LongRef.this, this, longRef4);
                                }
                            };
                            Function0 function02 = new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$2(Ref.LongRef.this, this, longRef4);
                                }
                            };
                            try {
                                Function2 function2 = new Function2() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$3(Ref.LongRef.this, this, handle2, longRef3, z, (PointerInputChange) obj2, (Offset) obj3);
                                    }
                                };
                                longRef4 = longRef4;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$0 = longRef3;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$1 = longRef4;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.L$2 = handle2;
                                textFieldSelectionState$detectSelectionHandleDragGestures$12.label = 1;
                                if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, function1, function0, function02, function2, textFieldSelectionState$detectSelectionHandleDragGestures$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                handle = handle2;
                                longRef = longRef3;
                                longRef2 = longRef4;
                            } catch (Throwable th) {
                                th = th;
                                longRef4 = longRef4;
                                handle = handle2;
                                longRef = longRef3;
                                longRef2 = longRef4;
                                TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$4(TextFieldSelectionState.this, handle);
                                    }
                                });
                                if (getDraggingHandle() == handle) {
                                    detectSelectionHandleDragGestures$onDragStop(longRef, this, longRef2);
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
                    handle = (Handle) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$2;
                    longRef2 = (Ref.LongRef) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$1;
                    longRef = (Ref.LongRef) textFieldSelectionState$detectSelectionHandleDragGestures$12.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$4(TextFieldSelectionState.this, handle);
                            }
                        });
                        if (getDraggingHandle() == handle) {
                        }
                        throw th;
                    }
                }
                TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$4(TextFieldSelectionState.this, handle);
                    }
                });
                if (getDraggingHandle() == handle) {
                    detectSelectionHandleDragGestures$onDragStop(longRef, this, longRef2);
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
        TextFieldSelectionStateKt.access$logDebug(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TextFieldSelectionState.detectSelectionHandleDragGestures$lambda$4(TextFieldSelectionState.this, handle);
            }
        });
        if (getDraggingHandle() == handle) {
        }
        return Unit.INSTANCE;
    }

    private static final void detectSelectionHandleDragGestures$onDragStop(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        if ((longRef.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            textFieldSelectionState.clearHandleDragging();
            longRef.element = Offset.Companion.m4542getUnspecifiedF1C5BW0();
            longRef2.element = Offset.Companion.m4543getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectSelectionHandleDragGestures$lambda$0(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, boolean z, Handle handle, Ref.LongRef longRef2, Offset offset) {
        longRef.element = SelectionHandlesKt.m1608getAdjustedCoordinatesk4lQ0M(textFieldSelectionState.m1501getHandlePositiontuRUvjQ(z));
        textFieldSelectionState.m1510updateHandleDraggingUv8p0NA(handle, longRef.element);
        longRef2.element = Offset.Companion.m4543getZeroF1C5BW0();
        textFieldSelectionState.previousRawDragOffset = -1;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectSelectionHandleDragGestures$lambda$1(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        detectSelectionHandleDragGestures$onDragStop(longRef, textFieldSelectionState, longRef2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectSelectionHandleDragGestures$lambda$2(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Ref.LongRef longRef2) {
        detectSelectionHandleDragGestures$onDragStop(longRef, textFieldSelectionState, longRef2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit detectSelectionHandleDragGestures$lambda$3(Ref.LongRef longRef, TextFieldSelectionState textFieldSelectionState, Handle handle, Ref.LongRef longRef2, boolean z, PointerInputChange pointerInputChange, Offset offset) {
        int m7003getStartimpl;
        int m6973getOffsetForPositionk4lQ0M;
        longRef.element = Offset.m4532plusMKHz9U(longRef.element, offset.m4537unboximpl());
        TextLayoutResult layoutResult = textFieldSelectionState.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Unit.INSTANCE;
        }
        textFieldSelectionState.m1510updateHandleDraggingUv8p0NA(handle, Offset.m4532plusMKHz9U(longRef2.element, longRef.element));
        if (z) {
            m7003getStartimpl = layoutResult.m6973getOffsetForPositionk4lQ0M(textFieldSelectionState.m1508getHandleDragPositionF1C5BW0());
        } else {
            m7003getStartimpl = TextRange.m7003getStartimpl(textFieldSelectionState.textFieldState.getVisualText().m1336getSelectiond9O1mEE());
        }
        int i = m7003getStartimpl;
        if (z) {
            m6973getOffsetForPositionk4lQ0M = TextRange.m6998getEndimpl(textFieldSelectionState.textFieldState.getVisualText().m1336getSelectiond9O1mEE());
        } else {
            m6973getOffsetForPositionk4lQ0M = layoutResult.m6973getOffsetForPositionk4lQ0M(textFieldSelectionState.m1508getHandleDragPositionF1C5BW0());
        }
        long m1336getSelectiond9O1mEE = textFieldSelectionState.textFieldState.getVisualText().m1336getSelectiond9O1mEE();
        long m1507updateSelectionSsLRf8$foundation$default = m1507updateSelectionSsLRf8$foundation$default(textFieldSelectionState, textFieldSelectionState.textFieldState.getVisualText(), i, m6973getOffsetForPositionk4lQ0M, z, SelectionAdjustment.Companion.getCharacterWithWordAccelerate(), false, false, 96, null);
        if (TextRange.m6997getCollapsedimpl(m1336getSelectiond9O1mEE) || !TextRange.m6997getCollapsedimpl(m1507updateSelectionSsLRf8$foundation$default)) {
            textFieldSelectionState.textFieldState.m1466selectCharsIn5zctL8(m1507updateSelectionSsLRf8$foundation$default);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final String detectSelectionHandleDragGestures$lambda$4(TextFieldSelectionState textFieldSelectionState, Handle handle) {
        return "Selection Handle drag cancelled for draggingHandle: " + textFieldSelectionState.getDraggingHandle() + " definedOn: " + handle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextChanges(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TextFieldCharSequence visualText;
                visualText = TextFieldSelectionState.this.textFieldState.getVisualText();
                return visualText;
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
        Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Rect derivedVisibleContentBounds$foundation;
                derivedVisibleContentBounds$foundation = TextFieldSelectionState.this.getDerivedVisibleContentBounds$foundation();
                return derivedVisibleContentBounds$foundation;
            }
        });
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            snapshotFlow = FlowKt.distinctUntilChangedBy(snapshotFlow, new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    boolean observeTextToolbarVisibility$lambda$1$0;
                    observeTextToolbarVisibility$lambda$1$0 = TextFieldSelectionState.observeTextToolbarVisibility$lambda$1$0((Rect) obj);
                    return Boolean.valueOf(observeTextToolbarVisibility$lambda$1$0);
                }
            });
        }
        Object collect = snapshotFlow.collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextToolbarVisibility$4
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Rect) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Rect rect, Continuation<? super Unit> continuation2) {
                Object showTextToolbar;
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                if (rect != null) {
                    showTextToolbar = textFieldSelectionState.showTextToolbar(rect, continuation2);
                    return showTextToolbar == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showTextToolbar : Unit.INSTANCE;
                }
                textFieldSelectionState.hideTextToolbar();
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final Rect getDerivedVisibleContentBounds$foundation() {
        return (Rect) this.derivedVisibleContentBounds$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Rect derivedVisibleContentBounds_delegate$lambda$0(TextFieldSelectionState textFieldSelectionState) {
        LayoutCoordinates textLayoutCoordinates;
        boolean m6997getCollapsedimpl = TextRange.m6997getCollapsedimpl(textFieldSelectionState.textFieldState.getVisualText().m1336getSelectiond9O1mEE());
        if ((!(m6997getCollapsedimpl && textFieldSelectionState.getTextToolbarState() == TextToolbarState.Cursor) && (m6997getCollapsedimpl || textFieldSelectionState.getTextToolbarState() != TextToolbarState.Selection)) || textFieldSelectionState.getDraggingHandle() != null || !textFieldSelectionState.isInTouchMode() || (textLayoutCoordinates = textFieldSelectionState.getTextLayoutCoordinates()) == null) {
            return null;
        }
        Rect visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates);
        Rect m4567Recttz77jQw = RectKt.m4567Recttz77jQw(textLayoutCoordinates.mo6227localToRootMKHz9U(visibleBounds.m4562getTopLeftF1C5BW0()), visibleBounds.m4560getSizeNHjbRc());
        Rect contentRect = textFieldSelectionState.getContentRect();
        if (contentRect.overlaps(m4567Recttz77jQw)) {
            return contentRect.intersect(m4567Recttz77jQw);
        }
        return null;
    }

    private final Rect getContentRect() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        if (textLayoutCoordinates != null) {
            TextFieldCharSequence visualText = this.textFieldState.getVisualText();
            if (TextRange.m6997getCollapsedimpl(visualText.m1336getSelectiond9O1mEE())) {
                Rect cursorRect = getCursorRect();
                return RectKt.m4567Recttz77jQw(textLayoutCoordinates.mo6227localToRootMKHz9U(cursorRect.m4562getTopLeftF1C5BW0()), cursorRect.m4560getSizeNHjbRc());
            }
            long mo6227localToRootMKHz9U = textLayoutCoordinates.mo6227localToRootMKHz9U(m1501getHandlePositiontuRUvjQ(true));
            long mo6227localToRootMKHz9U2 = textLayoutCoordinates.mo6227localToRootMKHz9U(m1501getHandlePositiontuRUvjQ(false));
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            if (layoutResult == null) {
                return Rect.Companion.getZero();
            }
            float intBitsToFloat = Float.intBitsToFloat((int) (textLayoutCoordinates.mo6227localToRootMKHz9U(Offset.m4519constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(layoutResult.getCursorRect(TextRange.m7003getStartimpl(visualText.m1336getSelectiond9O1mEE())).getTop()) & 4294967295L))) & 4294967295L));
            float intBitsToFloat2 = Float.intBitsToFloat((int) (textLayoutCoordinates.mo6227localToRootMKHz9U(Offset.m4519constructorimpl((Float.floatToRawIntBits(layoutResult.getCursorRect(TextRange.m6998getEndimpl(visualText.m1336getSelectiond9O1mEE())).getTop()) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32))) & 4294967295L));
            int i = (int) (mo6227localToRootMKHz9U >> 32);
            int i2 = (int) (mo6227localToRootMKHz9U2 >> 32);
            return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(intBitsToFloat, intBitsToFloat2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (mo6227localToRootMKHz9U & 4294967295L)), Float.intBitsToFloat((int) (mo6227localToRootMKHz9U2 & 4294967295L))));
        }
        androidx.compose.foundation.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("textLayoutCoordinates should not be null.");
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
        if (((r0 == null || (r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)) == null) ? false : androidx.compose.foundation.text.selection.SelectionManagerKt.m1635containsInclusiveUv8p0NA(r0, r4)) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TextFieldHandleState getSelectionHandleState$foundation(boolean z, boolean z2) {
        Rect visibleBounds;
        Handle handle = z ? Handle.SelectionStart : Handle.SelectionEnd;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextFieldHandleState.Companion.getHidden();
        }
        long m1336getSelectiond9O1mEE = this.textFieldState.getVisualText().m1336getSelectiond9O1mEE();
        if (TextRange.m6997getCollapsedimpl(m1336getSelectiond9O1mEE)) {
            return TextFieldHandleState.Companion.getHidden();
        }
        long m1501getHandlePositiontuRUvjQ = m1501getHandlePositiontuRUvjQ(z);
        if (getDirectDragGestureInitiator() == InputType.None) {
            if (getDraggingHandle() != handle) {
                LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            }
            if (this.textFieldState.getVisualText().shouldShowSelection()) {
                ResolvedTextDirection bidiRunDirection = layoutResult.getBidiRunDirection(z ? TextRange.m7003getStartimpl(m1336getSelectiond9O1mEE) : Math.max(TextRange.m6998getEndimpl(m1336getSelectiond9O1mEE) - 1, 0));
                boolean m7002getReversedimpl = TextRange.m7002getReversedimpl(m1336getSelectiond9O1mEE);
                if (z2) {
                    LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
                    if (textLayoutCoordinates2 != null && (visibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates2)) != null) {
                        m1501getHandlePositiontuRUvjQ = TextLayoutStateKt.m1453coerceIn3MmeM6k(m1501getHandlePositiontuRUvjQ, visibleBounds);
                    }
                } else {
                    m1501getHandlePositiontuRUvjQ = Offset.Companion.m4542getUnspecifiedF1C5BW0();
                }
                return new TextFieldHandleState(true, m1501getHandlePositiontuRUvjQ, TextLayoutHelperKt.getLineHeight(layoutResult, z ? TextRange.m7003getStartimpl(m1336getSelectiond9O1mEE) : TextRange.m6998getEndimpl(m1336getSelectiond9O1mEE)), bidiRunDirection, m7002getReversedimpl, null);
            }
            return TextFieldHandleState.Companion.getHidden();
        }
        return TextFieldHandleState.Companion.getHidden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ  reason: not valid java name */
    public final long m1501getHandlePositiontuRUvjQ(boolean z) {
        int m6998getEndimpl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.Companion.m4543getZeroF1C5BW0();
        }
        long m1336getSelectiond9O1mEE = this.textFieldState.getVisualText().m1336getSelectiond9O1mEE();
        if (z) {
            m6998getEndimpl = TextRange.m7003getStartimpl(m1336getSelectiond9O1mEE);
        } else {
            m6998getEndimpl = TextRange.m6998getEndimpl(m1336getSelectiond9O1mEE);
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, m6998getEndimpl, z, TextRange.m7002getReversedimpl(m1336getSelectiond9O1mEE));
    }

    /* renamed from: updateHandleDragging-Uv8p0NA  reason: not valid java name */
    public final void m1510updateHandleDraggingUv8p0NA(Handle handle, long j) {
        setDraggingHandle(handle);
        m1505setRawHandleDragPositionk4lQ0M(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        m1506setStartTextLayoutPositionInWindowk4lQ0M(m1500getCurrentTextLayoutPositionInWindowF1C5BW0());
    }

    public final void clearHandleDragging() {
        setDraggingHandle(null);
        m1505setRawHandleDragPositionk4lQ0M(Offset.Companion.m4542getUnspecifiedF1C5BW0());
        m1506setStartTextLayoutPositionInWindowk4lQ0M(Offset.Companion.m4542getUnspecifiedF1C5BW0());
    }

    public final boolean isCutAllowed() {
        return (TextRange.m6997getCollapsedimpl(getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE()) || !getEditable$foundation() || this.isPassword) ? false : true;
    }

    public final Object cut(Continuation<? super Unit> continuation) {
        Object clipEntry;
        AnnotatedString cutWithResult = cutWithResult();
        return (cutWithResult != null && (clipEntry = this.clipboard.setClipEntry(ClipboardUtils_androidKt.toClipEntry(cutWithResult), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? clipEntry : Unit.INSTANCE;
    }

    public final boolean isCopyAllowed() {
        return (TextRange.m6997getCollapsedimpl(getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE()) || this.isPassword) ? false : true;
    }

    public static /* synthetic */ Object copy$default(TextFieldSelectionState textFieldSelectionState, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionState.copy(z, continuation);
    }

    public final Object copy(boolean z, Continuation<? super Unit> continuation) {
        Object clipEntry;
        AnnotatedString copyWithResult$foundation = copyWithResult$foundation(z);
        return (copyWithResult$foundation != null && (clipEntry = this.clipboard.setClipEntry(ClipboardUtils_androidKt.toClipEntry(copyWithResult$foundation), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? clipEntry : Unit.INSTANCE;
    }

    public static /* synthetic */ AnnotatedString copyWithResult$foundation$default(TextFieldSelectionState textFieldSelectionState, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionState.copyWithResult$foundation(z);
    }

    public final Object updateClipboardEntry(Continuation<? super Unit> continuation) {
        Object update = this.clipboardPasteState.update(continuation);
        return update == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? update : Unit.INSTANCE;
    }

    public final boolean isPasteAllowed() {
        return getEditable$foundation();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r12 == r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
        if (pasteAsPlainText(r0) == r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b8, code lost:
        if (pasteAsPlainText(r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object paste(Continuation<? super Unit> continuation) {
        TextFieldSelectionState$paste$1 textFieldSelectionState$paste$1;
        int i;
        ReceiveContentConfiguration invoke;
        ClipEntry clipEntry;
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
                        textFieldSelectionState$paste$1.L$0 = invoke;
                        textFieldSelectionState$paste$1.label = 2;
                        obj = clipboard.getClipEntry(textFieldSelectionState$paste$1);
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
                    invoke = (ReceiveContentConfiguration) textFieldSelectionState$paste$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    ClipEntry clipEntry2 = (ClipEntry) obj;
                    if (clipEntry2 != null) {
                        TransferableContent onReceive = invoke.getReceiveContentListener().onReceive(new TransferableContent(clipEntry2, clipEntry2.getClipMetadata(), TransferableContent.Source.Companion.m363getClipboardkB6V9T0(), null, 8, null));
                        if (onReceive != null && (clipEntry = onReceive.getClipEntry()) != null && (readPlainText = TransferableContent_androidKt.readPlainText(clipEntry)) != null) {
                            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, readPlainText, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
                        }
                        return Unit.INSTANCE;
                    }
                    textFieldSelectionState$paste$1.L$0 = null;
                    textFieldSelectionState$paste$1.label = 3;
                }
            }
        }
        textFieldSelectionState$paste$1 = new TextFieldSelectionState$paste$1(this, continuation);
        Object obj2 = textFieldSelectionState$paste$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionState$paste$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r8 == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r8 == r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object pasteAsPlainText(Continuation<? super Unit> continuation) {
        TextFieldSelectionState$pasteAsPlainText$1 textFieldSelectionState$pasteAsPlainText$1;
        int i;
        ClipEntry clipEntry;
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
                    textFieldSelectionState$pasteAsPlainText$1.label = 1;
                    obj = clipboard.getClipEntry(textFieldSelectionState$pasteAsPlainText$1);
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        String str = (String) obj;
                        if (str != null) {
                            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, str, false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                clipEntry = (ClipEntry) obj;
                if (clipEntry != null) {
                    textFieldSelectionState$pasteAsPlainText$1.label = 2;
                    obj = ClipboardUtils_androidKt.readText(clipEntry, textFieldSelectionState$pasteAsPlainText$1);
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
        }
        return Unit.INSTANCE;
    }

    public final boolean canShowSelectAllMenuItem() {
        return TextRange.m6999getLengthimpl(this.textFieldState.getVisualText().m1336getSelectiond9O1mEE()) != this.textFieldState.getVisualText().length();
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    public final boolean canShowAutofillMenuItem() {
        return getEditable$foundation() && TextRange.m6997getCollapsedimpl(this.textFieldState.getVisualText().m1336getSelectiond9O1mEE());
    }

    public final void autofill() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showTextToolbar(Rect rect, Continuation<? super Unit> continuation) {
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.show();
        } else {
            TextToolbarHandler textToolbarHandler = this.textToolbarHandler;
            if (textToolbarHandler != null) {
                Object showTextToolbar = textToolbarHandler.showTextToolbar(this, rect, continuation);
                return showTextToolbar == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? showTextToolbar : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    public final void deselect() {
        if (!TextRange.m6997getCollapsedimpl(this.textFieldState.getVisualText().m1336getSelectiond9O1mEE())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.hide();
            return;
        }
        TextToolbarHandler textToolbarHandler = this.textToolbarHandler;
        if (textToolbarHandler != null) {
            textToolbarHandler.hideTextToolbar();
        }
    }

    /* renamed from: updateSelection-SsL-Rf8$foundation$default  reason: not valid java name */
    public static /* synthetic */ long m1507updateSelectionSsLRf8$foundation$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        if ((i3 & 64) != 0) {
            z3 = false;
        }
        return textFieldSelectionState.m1511updateSelectionSsLRf8$foundation(textFieldCharSequence, i, i2, z, selectionAdjustment, z2, z3);
    }

    /* renamed from: updateSelection-SsL-Rf8$foundation  reason: not valid java name */
    public final long m1511updateSelectionSsLRf8$foundation(TextFieldCharSequence textFieldCharSequence, int i, int i2, boolean z, SelectionAdjustment selectionAdjustment, boolean z2, boolean z3) {
        HapticFeedback hapticFeedback;
        TextRange m6991boximpl = TextRange.m6991boximpl(textFieldCharSequence.m1336getSelectiond9O1mEE());
        long m7007unboximpl = m6991boximpl.m7007unboximpl();
        if (z3 || (!z2 && TextRange.m6997getCollapsedimpl(m7007unboximpl))) {
            m6991boximpl = null;
        }
        long m1504getTextFieldSelectionqeG_v_k = m1504getTextFieldSelectionqeG_v_k(i, i2, m6991boximpl, z, selectionAdjustment);
        if (!TextRange.m6996equalsimpl0(m1504getTextFieldSelectionqeG_v_k, textFieldCharSequence.m1336getSelectiond9O1mEE())) {
            boolean z4 = TextRange.m7002getReversedimpl(m1504getTextFieldSelectionqeG_v_k) != TextRange.m7002getReversedimpl(textFieldCharSequence.m1336getSelectiond9O1mEE()) && TextRange.m6996equalsimpl0(TextRangeKt.TextRange(TextRange.m6998getEndimpl(m1504getTextFieldSelectionqeG_v_k), TextRange.m7003getStartimpl(m1504getTextFieldSelectionqeG_v_k)), textFieldCharSequence.m1336getSelectiond9O1mEE());
            if (isInTouchMode() && !z4 && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo5541performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m5558getTextHandleMove5zf0vsI());
            }
        }
        return m1504getTextFieldSelectionqeG_v_k;
    }

    /* renamed from: getTextFieldSelection-qeG_v_k  reason: not valid java name */
    private final long m1504getTextFieldSelectionqeG_v_k(int i, int i2, TextRange textRange, boolean z, SelectionAdjustment selectionAdjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.Companion.m7008getZerod9O1mEE();
        }
        if (textRange == null && Intrinsics.areEqual(selectionAdjustment, SelectionAdjustment.Companion.getCharacter())) {
            return TextRangeKt.TextRange(i, i2);
        }
        SelectionLayout m1611getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1611getTextFieldSelectionLayoutRcvTLA(layoutResult, i, i2, this.previousRawDragOffset, textRange != null ? textRange.m7007unboximpl() : TextRange.Companion.m7008getZerod9O1mEE(), textRange == null, z);
        if (textRange != null && !m1611getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return textRange.m7007unboximpl();
        }
        long m1602toTextRanged9O1mEE = selectionAdjustment.adjust(m1611getTextFieldSelectionLayoutRcvTLA).m1602toTextRanged9O1mEE();
        this.previousSelectionLayout = m1611getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = z ? i : i2;
        return m1602toTextRanged9O1mEE;
    }

    public final boolean canShowCutMenuItem() {
        return !TextRange.m6997getCollapsedimpl(getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE()) && getEditable$foundation() && !this.isPassword && ClipboardUtils_androidKt.isWriteSupported(this.clipboard);
    }

    public final AnnotatedString cutWithResult() {
        if (TextRange.m6997getCollapsedimpl(getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE()) || !getEditable$foundation() || this.isPassword) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(this.textFieldState.getVisualText()).toString(), null, 2, null);
        this.textFieldState.deleteSelectedText();
        return annotatedString;
    }

    public final boolean canShowCopyMenuItem() {
        return (TextRange.m6997getCollapsedimpl(getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE()) || this.isPassword || !ClipboardUtils_androidKt.isWriteSupported(this.clipboard)) ? false : true;
    }

    public final AnnotatedString copyWithResult$foundation(boolean z) {
        if (TextRange.m6997getCollapsedimpl(getTextFieldState$foundation().getVisualText().m1336getSelectiond9O1mEE()) || this.isPassword) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(this.textFieldState.getVisualText()).toString(), null, 2, null);
        if (z) {
            this.textFieldState.collapseSelectionToMax();
        }
        return annotatedString;
    }

    public final boolean canShowPasteMenuItem() {
        if (getEditable$foundation() && ClipboardUtils_androidKt.isReadSupported(this.clipboard)) {
            if (this.clipboardPasteState.getHasText()) {
                return true;
            }
            Function0<? extends ReceiveContentConfiguration> function0 = this.receiveContentConfiguration;
            if ((function0 != null ? function0.invoke() : null) != null && this.clipboardPasteState.getHasClip()) {
                return true;
            }
        }
        return false;
    }

    public final void onPasteEvent$foundation(AnnotatedString annotatedString) {
        if (getEditable$foundation()) {
            TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, annotatedString.getText(), false, TextFieldEditUndoBehavior.NeverMerge, false, 10, null);
        }
    }
}
