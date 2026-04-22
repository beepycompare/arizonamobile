package androidx.compose.foundation.text;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifier;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aú\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00020(H\u0002\u001a \u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0013H\u0000\u001a0\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002\u001a2\u00108\u001a\u00020\u0001*\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0080@¢\u0006\u0002\u0010=\u001a\u001d\u0010>\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010@\u001a\u0015\u0010A\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\u0010B\u001a \u0010C\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0002\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00072\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020GH\u0002¨\u0006H²\u0006\n\u0010I\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "textScrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/text/TextFieldScrollerPosition;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "previewKeyEventToDeselectOnBack", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "endInputSession", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "addContextMenuComponents", "textFieldSelectionManager", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation", "writeable"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CoreTextField$lambda$27(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3 function3, TextFieldScrollerPosition textFieldScrollerPosition, int i3, int i4, int i5, Composer composer, int i6) {
        CoreTextField(textFieldValue, function1, modifier, textStyle, visualTransformation, function12, mutableInteractionSource, brush, z, i, i2, imeOptions, keyboardActions, z2, z3, function3, textFieldScrollerPosition, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CoreTextFieldRootBox$lambda$1(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2 function2, int i, Composer composer, int i2) {
        CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelectionToolbarAndHandles$lambda$1(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Composer composer, int i2) {
        SelectionToolbarAndHandles(textFieldSelectionManager, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TextFieldCursorHandle$lambda$4(TextFieldSelectionManager textFieldSelectionManager, int i, Composer composer, int i2) {
        TextFieldCursorHandle(textFieldSelectionManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$0$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:266:0x0480, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L334;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0919, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:444:0x0a54, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L294;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:0x0b37, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L285;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x07ab  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x07e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x081c  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x082e  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0837  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x08a6  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x08ac  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x08ae  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x08c0  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0911  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x091c  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x094f  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0951  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x095e  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0991  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0993  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x09a4  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x09a6  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x09b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0a07 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:443:0x0a4c  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0a57  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0a7c  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0a7e  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0a85  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0a9a  */
    /* JADX WARN: Removed duplicated region for block: B:467:0x0ac5  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0ac8  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0af8  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0b2f  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x0b3a  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0b9f  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0c03  */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0c1a  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0c23  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0c73  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0c96  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0cbb  */
    /* JADX WARN: Removed duplicated region for block: B:509:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, TextFieldScrollerPosition textFieldScrollerPosition, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        Modifier.Companion companion;
        int i7;
        Object obj;
        int i8;
        int i9;
        Object obj2;
        int i10;
        Object obj3;
        int i11;
        SolidColor solidColor;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        final int i27;
        final KeyboardActions keyboardActions2;
        final boolean z4;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final TextFieldScrollerPosition textFieldScrollerPosition2;
        Composer composer2;
        final Brush brush2;
        final MutableInteractionSource mutableInteractionSource2;
        final Function1<? super TextLayoutResult, Unit> function13;
        final TextStyle textStyle2;
        final Modifier modifier2;
        final VisualTransformation visualTransformation2;
        final boolean z5;
        final int i28;
        final ImeOptions imeOptions2;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        MutableInteractionSource mutableInteractionSource3;
        ImeOptions imeOptions3;
        KeyboardActions keyboardActions3;
        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> lambda$559628295$foundation;
        TextFieldScrollerPosition textFieldScrollerPosition3;
        boolean z7;
        boolean z8;
        int i29;
        final Function1<? super TextLayoutResult, Unit> function14;
        boolean z9;
        VisualTransformation visualTransformation3;
        Modifier modifier3;
        ImeOptions imeOptions4;
        int i30;
        int i31;
        Brush brush3;
        MutableInteractionSource mutableInteractionSource4;
        Brush brush4;
        LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter;
        WindowInfo windowInfo;
        int i32;
        TextFieldScrollerPosition textFieldScrollerPosition4;
        TextFieldScrollerPosition textFieldScrollerPosition5;
        AnnotatedString annotatedString;
        TextStyle textStyle3;
        boolean z10;
        FontFamily.Resolver resolver;
        FocusManager focusManager;
        final LegacyTextFieldState legacyTextFieldState;
        boolean z11;
        boolean changedInstance;
        final TextFieldSelectionManager textFieldSelectionManager;
        final LegacyTextFieldState legacyTextFieldState2;
        boolean z12;
        final TextInputService textInputService;
        ImeOptions imeOptions5;
        final OffsetMapping offsetMapping;
        CoroutineScope coroutineScope;
        BringIntoViewRequester bringIntoViewRequester;
        VisualTransformation visualTransformation4;
        String str;
        boolean z13;
        final TextFieldSelectionManager textFieldSelectionManager2;
        boolean changed;
        boolean z14;
        boolean z15;
        boolean z16;
        CoreTextFieldKt$CoreTextField$5$1 rememberedValue;
        State state;
        boolean changedInstance2;
        Object rememberedValue2;
        boolean changedInstance3;
        Object rememberedValue3;
        FocusRequester focusRequester;
        boolean z17;
        final ImeOptions imeOptions6;
        boolean changedInstance4;
        final boolean z18;
        boolean changedInstance5;
        Object rememberedValue4;
        final TextFieldValue textFieldValue2;
        final WindowInfo windowInfo2;
        boolean changedInstance6;
        Object rememberedValue5;
        boolean z19;
        WindowInfo windowInfo3;
        final LegacyTextFieldState legacyTextFieldState3;
        boolean changedInstance7;
        Modifier modifier4;
        boolean changedInstance8;
        Object rememberedValue6;
        boolean changed2;
        int i33;
        boolean changedInstance9;
        Object rememberedValue7;
        final boolean z20;
        Modifier.Companion companion2;
        String str2;
        int i34;
        Composer startRestartGroup = composer.startRestartGroup(31062401);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextField)N(value,onValueChange,modifier,textStyle,visualTransformation,onTextLayout,interactionSource,cursorBrush,softWrap,maxLines,minLines,imeOptions,keyboardActions,enabled,readOnly,decorationBox,textScrollerPosition)213@12062L29,214@12132L58,215@12236L72,220@12366L7,221@12427L7,222@12495L7,223@12560L7,224@12605L7,225@12674L7,246@13516L277,258@14098L21,260@14144L453,289@14997L26,292@15090L24,293@15148L37,295@15205L51,301@15494L7,303@15589L7,304@15646L7,314@16020L206,327@16443L1514,362@18064L42,363@18132L971,363@18111L992,389@19173L28,390@19269L992,412@20352L177,421@20630L577,439@21278L1606,492@23496L48,492@23470L74,494@23579L503,494@23550L532,526@24756L987,545@25860L7,546@25917L7,550@26055L327,559@26411L35,587@27673L5409,587@27620L5462:CoreTextField.kt#423gt5");
        if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i35 = i5 & 4;
        if (i35 != 0) {
            i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i6 |= startRestartGroup.changed(companion) ? 256 : 128;
            i7 = i5 & 8;
            if (i7 == 0) {
                i6 |= 3072;
            } else if ((i3 & 3072) == 0) {
                obj = textStyle;
                i6 |= startRestartGroup.changed(obj) ? 2048 : 1024;
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    i6 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj2 = function12;
                    } else {
                        obj2 = function12;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i6 |= startRestartGroup.changedInstance(obj2) ? 131072 : 65536;
                        }
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                        obj3 = mutableInteractionSource;
                    } else {
                        obj3 = mutableInteractionSource;
                        if ((i3 & 1572864) == 0) {
                            i6 |= startRestartGroup.changed(obj3) ? 1048576 : 524288;
                        }
                    }
                    i11 = i5 & 128;
                    if (i11 == 0) {
                        i6 |= 12582912;
                        solidColor = brush;
                    } else {
                        solidColor = brush;
                        if ((i3 & 12582912) == 0) {
                            i6 |= startRestartGroup.changed(solidColor) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i5 & 256;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i13 = i12;
                        i6 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        i14 = i5 & 512;
                        if (i14 != 0) {
                            i6 |= 805306368;
                        } else if ((i3 & 805306368) == 0) {
                            i15 = i14;
                            i6 |= startRestartGroup.changed(i) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            i16 = i5 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            if ((i4 & 48) == 0) {
                                if ((i5 & 2048) == 0 && startRestartGroup.changed(imeOptions)) {
                                    i34 = 32;
                                    i18 |= i34;
                                }
                                i34 = 16;
                                i18 |= i34;
                            }
                            int i36 = i18;
                            i19 = i5 & 4096;
                            if (i19 == 0) {
                                i20 = i36 | RendererCapabilities.DECODER_SUPPORT_MASK;
                            } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i20 = i36 | (startRestartGroup.changed(keyboardActions) ? 256 : 128);
                            } else {
                                i20 = i36;
                            }
                            i21 = i5 & 8192;
                            if (i21 == 0) {
                                i22 = i20 | 3072;
                            } else {
                                int i37 = i20;
                                if ((i4 & 3072) == 0) {
                                    i22 = i37 | (startRestartGroup.changed(z2) ? 2048 : 1024);
                                } else {
                                    i22 = i37;
                                }
                            }
                            i23 = i5 & 16384;
                            if (i23 == 0) {
                                i24 = i22 | 24576;
                            } else {
                                i24 = i22;
                                if ((i4 & 24576) == 0) {
                                    i24 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                                    i25 = i5 & 32768;
                                    if (i25 != 0) {
                                        i24 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                        i24 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                                    }
                                    i26 = i5 & 65536;
                                    if (i26 != 0) {
                                        i24 |= 1572864;
                                    } else if ((i4 & 1572864) == 0) {
                                        i24 |= startRestartGroup.changed(textFieldScrollerPosition) ? 1048576 : 524288;
                                    }
                                    if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                                        startRestartGroup.startDefaults();
                                        ComposerKt.sourceInformation(startRestartGroup, "198@11387L2");
                                        if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i5 & 2048) != 0) {
                                                i24 &= -113;
                                            }
                                            MutableInteractionSource mutableInteractionSource5 = obj3;
                                            brush3 = solidColor;
                                            mutableInteractionSource4 = mutableInteractionSource5;
                                            visualTransformation3 = visualTransformation;
                                            i31 = i;
                                            i30 = i2;
                                            keyboardActions3 = keyboardActions;
                                            z7 = z2;
                                            z8 = z3;
                                            lambda$559628295$foundation = function3;
                                            textFieldScrollerPosition3 = textFieldScrollerPosition;
                                            function14 = obj2;
                                            modifier3 = companion;
                                            i29 = i24;
                                            z9 = z;
                                            imeOptions4 = imeOptions;
                                        } else {
                                            if (i35 != 0) {
                                                companion = Modifier.Companion;
                                            }
                                            if (i7 != 0) {
                                                obj = TextStyle.Companion.getDefault();
                                            }
                                            VisualTransformation none = i8 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                            if (i9 != 0) {
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213794269, "CC(remember):CoreTextField.kt#9igjgp");
                                                Object rememberedValue8 = startRestartGroup.rememberedValue();
                                                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                                                    rememberedValue8 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda17
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Object invoke(Object obj4) {
                                                            Unit CoreTextField$lambda$0$0;
                                                            CoreTextField$lambda$0$0 = CoreTextFieldKt.CoreTextField$lambda$0$0((TextLayoutResult) obj4);
                                                            return CoreTextField$lambda$0$0;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue8);
                                                }
                                                obj2 = (Function1) rememberedValue8;
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            }
                                            if (i10 != 0) {
                                                obj3 = null;
                                            }
                                            if (i11 != 0) {
                                                mutableInteractionSource3 = obj3;
                                                solidColor = new SolidColor(Color.Companion.m4808getUnspecified0d7_KjU(), null);
                                            } else {
                                                mutableInteractionSource3 = obj3;
                                            }
                                            boolean z21 = i13 != 0 ? true : z;
                                            int i38 = i15 != 0 ? Integer.MAX_VALUE : i;
                                            int i39 = i17 != 0 ? 1 : i2;
                                            if ((i5 & 2048) != 0) {
                                                imeOptions3 = ImeOptions.Companion.getDefault();
                                                i24 &= -113;
                                            } else {
                                                imeOptions3 = imeOptions;
                                            }
                                            keyboardActions3 = i19 != 0 ? KeyboardActions.Companion.getDefault() : keyboardActions;
                                            boolean z22 = i21 != 0 ? true : z2;
                                            boolean z23 = i23 != 0 ? false : z3;
                                            lambda$559628295$foundation = i25 != 0 ? ComposableSingletons$CoreTextFieldKt.INSTANCE.getLambda$559628295$foundation() : function3;
                                            textFieldScrollerPosition3 = i26 != 0 ? null : textFieldScrollerPosition;
                                            z7 = z22;
                                            z8 = z23;
                                            i29 = i24;
                                            function14 = obj2;
                                            z9 = z21;
                                            visualTransformation3 = none;
                                            modifier3 = companion;
                                            imeOptions4 = imeOptions3;
                                            i30 = i39;
                                            i31 = i38;
                                            brush3 = solidColor;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            brush4 = brush3;
                                            ComposerKt.traceEventStart(31062401, i6, i29, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:212)");
                                        } else {
                                            brush4 = brush3;
                                        }
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213772642, "CC(remember):CoreTextField.kt#9igjgp");
                                        Object rememberedValue9 = startRestartGroup.rememberedValue();
                                        if (rememberedValue9 == Composer.Companion.getEmpty()) {
                                            rememberedValue9 = new FocusRequester();
                                            startRestartGroup.updateRememberedValue(rememberedValue9);
                                        }
                                        final FocusRequester focusRequester2 = (FocusRequester) rememberedValue9;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213770373, "CC(remember):CoreTextField.kt#9igjgp");
                                        Object rememberedValue10 = startRestartGroup.rememberedValue();
                                        int i40 = i6;
                                        if (rememberedValue10 == Composer.Companion.getEmpty()) {
                                            rememberedValue10 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                                            startRestartGroup.updateRememberedValue(rememberedValue10);
                                        }
                                        LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter2 = (LegacyPlatformTextInputServiceAdapter) rememberedValue10;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213767031, "CC(remember):CoreTextField.kt#9igjgp");
                                        Object rememberedValue11 = startRestartGroup.rememberedValue();
                                        boolean z24 = z9;
                                        if (rememberedValue11 == Composer.Companion.getEmpty()) {
                                            rememberedValue11 = new TextInputService(legacyPlatformTextInputServiceAdapter2);
                                            startRestartGroup.updateRememberedValue(rememberedValue11);
                                        }
                                        final TextInputService textInputService2 = (TextInputService) rememberedValue11;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        TextStyle textStyle4 = obj;
                                        final int i41 = i30;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Density density = (Density) consume;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        FontFamily.Resolver resolver2 = (FontFamily.Resolver) consume2;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume3 = startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        long m1675getBackgroundColor0d7_KjU = ((TextSelectionColors) consume3).m1675getBackgroundColor0d7_KjU();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        FocusManager focusManager2 = (FocusManager) consume4;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        WindowInfo windowInfo4 = (WindowInfo) consume5;
                                        KeyboardActions keyboardActions4 = keyboardActions3;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) consume6;
                                        final Orientation orientation = (i31 == 1 && !z24 && imeOptions4.getSingleLine()) ? Orientation.Horizontal : Orientation.Vertical;
                                        Modifier modifier5 = modifier3;
                                        if (textFieldScrollerPosition3 != null) {
                                            legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter2;
                                            windowInfo = windowInfo4;
                                            i32 = i31;
                                            startRestartGroup.startReplaceGroup(-213745742);
                                            startRestartGroup.endReplaceGroup();
                                            textFieldScrollerPosition4 = textFieldScrollerPosition3;
                                        } else {
                                            startRestartGroup.startReplaceGroup(-213744626);
                                            ComposerKt.sourceInformation(startRestartGroup, "232@13005L70,232@12934L141");
                                            Object[] objArr = {orientation};
                                            legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter2;
                                            Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.Companion.getSaver();
                                            i32 = i31;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213742425, "CC(remember):CoreTextField.kt#9igjgp");
                                            boolean changed3 = startRestartGroup.changed(orientation.ordinal());
                                            Object rememberedValue12 = startRestartGroup.rememberedValue();
                                            if (changed3) {
                                                windowInfo = windowInfo4;
                                            } else {
                                                windowInfo = windowInfo4;
                                            }
                                            rememberedValue12 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    TextFieldScrollerPosition CoreTextField$lambda$4$0;
                                                    CoreTextField$lambda$4$0 = CoreTextFieldKt.CoreTextField$lambda$4$0(Orientation.this);
                                                    return CoreTextField$lambda$4$0;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue12);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            textFieldScrollerPosition4 = (TextFieldScrollerPosition) RememberSaveableKt.m4213rememberSaveable(objArr, saver, (Function0<? extends Object>) rememberedValue12, startRestartGroup, 0);
                                            startRestartGroup.endReplaceGroup();
                                        }
                                        if (textFieldScrollerPosition4.getOrientation() != orientation) {
                                            if (orientation == Orientation.Vertical) {
                                                str2 = "only single-line, non-wrap text fields can scroll horizontally";
                                            } else {
                                                str2 = "single-line, non-wrap text fields can only scroll horizontally";
                                            }
                                            throw new IllegalArgumentException("Mismatching scroller orientation; ".concat(str2));
                                        }
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213725866, "CC(remember):CoreTextField.kt#9igjgp");
                                        int i42 = i40 & 14;
                                        boolean z25 = (i42 == 4) | ((i40 & 57344) == 16384);
                                        TransformedText rememberedValue13 = startRestartGroup.rememberedValue();
                                        if (z25 || rememberedValue13 == Composer.Companion.getEmpty()) {
                                            TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                                            TextRange m7252getCompositionMzsxiRA = textFieldValue.m7252getCompositionMzsxiRA();
                                            if (m7252getCompositionMzsxiRA != null) {
                                                textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                                TransformedText m1261applyCompositionDecoration72CqOWE = TextFieldDelegate.Companion.m1261applyCompositionDecoration72CqOWE(m7252getCompositionMzsxiRA.m7007unboximpl(), filterWithValidation);
                                                if (m1261applyCompositionDecoration72CqOWE != null) {
                                                    rememberedValue13 = m1261applyCompositionDecoration72CqOWE;
                                                    startRestartGroup.updateRememberedValue(rememberedValue13);
                                                }
                                            } else {
                                                textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                            }
                                            rememberedValue13 = filterWithValidation;
                                            startRestartGroup.updateRememberedValue(rememberedValue13);
                                        } else {
                                            textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                        }
                                        TransformedText transformedText = (TransformedText) rememberedValue13;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        AnnotatedString text = transformedText.getText();
                                        final OffsetMapping offsetMapping2 = transformedText.getOffsetMapping();
                                        RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213705594, "CC(remember):CoreTextField.kt#9igjgp");
                                        boolean changed4 = startRestartGroup.changed(softwareKeyboardController);
                                        Object rememberedValue14 = startRestartGroup.rememberedValue();
                                        if (changed4 || rememberedValue14 == Composer.Companion.getEmpty()) {
                                            annotatedString = text;
                                            textStyle3 = textStyle4;
                                            z10 = z24;
                                            resolver = resolver2;
                                            rememberedValue14 = new LegacyTextFieldState(new TextDelegate(text, textStyle4, 0, 0, z24, 0, density, resolver2, null, 300, null), currentRecomposeScope, softwareKeyboardController);
                                            startRestartGroup.updateRememberedValue(rememberedValue14);
                                        } else {
                                            annotatedString = text;
                                            textStyle3 = textStyle4;
                                            z10 = z24;
                                            resolver = resolver2;
                                        }
                                        LegacyTextFieldState legacyTextFieldState4 = (LegacyTextFieldState) rememberedValue14;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        legacyTextFieldState4.m1226updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle3, z10, density, resolver, function1, keyboardActions4, focusManager2, m1675getBackgroundColor0d7_KjU);
                                        legacyTextFieldState4.getProcessor().reset(textFieldValue, legacyTextFieldState4.getInputSession());
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213678725, "CC(remember):CoreTextField.kt#9igjgp");
                                        Object rememberedValue15 = startRestartGroup.rememberedValue();
                                        if (rememberedValue15 == Composer.Companion.getEmpty()) {
                                            focusManager = focusManager2;
                                            rememberedValue15 = new UndoManager(0, 1, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue15);
                                        } else {
                                            focusManager = focusManager2;
                                        }
                                        UndoManager undoManager = (UndoManager) rememberedValue15;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                                        Object rememberedValue16 = startRestartGroup.rememberedValue();
                                        if (rememberedValue16 == Composer.Companion.getEmpty()) {
                                            rememberedValue16 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                            startRestartGroup.updateRememberedValue(rememberedValue16);
                                        }
                                        final CoroutineScope coroutineScope2 = (CoroutineScope) rememberedValue16;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213673882, "CC(remember):CoreTextField.kt#9igjgp");
                                        Object rememberedValue17 = startRestartGroup.rememberedValue();
                                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                        if (rememberedValue17 == Composer.Companion.getEmpty()) {
                                            rememberedValue17 = BringIntoViewRequesterKt.BringIntoViewRequester();
                                            startRestartGroup.updateRememberedValue(rememberedValue17);
                                        }
                                        final BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) rememberedValue17;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213672044, "CC(remember):CoreTextField.kt#9igjgp");
                                        Object rememberedValue18 = startRestartGroup.rememberedValue();
                                        if (rememberedValue18 == Composer.Companion.getEmpty()) {
                                            rememberedValue18 = new TextFieldSelectionManager(undoManager);
                                            startRestartGroup.updateRememberedValue(rememberedValue18);
                                        }
                                        final TextFieldSelectionManager textFieldSelectionManager3 = (TextFieldSelectionManager) rememberedValue18;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        textFieldSelectionManager3.setOffsetMapping$foundation(offsetMapping2);
                                        textFieldSelectionManager3.setVisualTransformation$foundation(visualTransformation3);
                                        textFieldSelectionManager3.setOnValueChange$foundation(legacyTextFieldState4.getOnValueChange());
                                        textFieldSelectionManager3.setState$foundation(legacyTextFieldState4);
                                        textFieldSelectionManager3.setValue$foundation(textFieldValue);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalClipboard());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        textFieldSelectionManager3.setClipboard$foundation((Clipboard) consume7);
                                        textFieldSelectionManager3.setCoroutineScope$foundation(coroutineScope2);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        textFieldSelectionManager3.setTextToolbar((TextToolbar) consume8);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        textFieldSelectionManager3.setHapticFeedBack((HapticFeedback) consume9);
                                        textFieldSelectionManager3.setFocusRequester(focusRequester2);
                                        textFieldSelectionManager3.setEditable(!z8);
                                        final boolean z26 = z7;
                                        textFieldSelectionManager3.setEnabled(z26);
                                        if (!ComposeFoundationFlags.isSmartSelectionEnabled) {
                                            startRestartGroup.startReplaceGroup(1951015297);
                                        } else {
                                            startRestartGroup.startReplaceGroup(1966756105);
                                            ComposerKt.sourceInformation(startRestartGroup, "311@15921L87");
                                            textFieldSelectionManager3.setPlatformSelectionBehaviors$foundation(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, textStyle3.getLocaleList(), startRestartGroup, 6));
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        legacyTextFieldState4.getHasFocus();
                                        new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                return CoreTextFieldKt.CoreTextField$lambda$10(TextFieldSelectionManager.this, (AnnotatedString) obj4);
                                            }
                                        };
                                        new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                AnnotatedString copyWithResult$foundation$default;
                                                copyWithResult$foundation$default = TextFieldSelectionManager.copyWithResult$foundation$default(TextFieldSelectionManager.this, false, 1, null);
                                                return copyWithResult$foundation$default;
                                            }
                                        };
                                        new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda5
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                AnnotatedString cutWithResult$foundation;
                                                cutWithResult$foundation = TextFieldSelectionManager.this.cutWithResult$foundation();
                                                return cutWithResult$foundation;
                                            }
                                        };
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1197772674, "CC(rememberClipboardEventsHandler)N(onPaste,onCopy,onCut,isEnabled):ClipboardEventsHandler.jvm.kt#423gt5");
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier.Companion companion3 = Modifier.Companion;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213630965, "CC(remember):CoreTextField.kt#9igjgp");
                                        int i43 = i29 & 7168;
                                        int i44 = i29;
                                        int i45 = i44 & 57344;
                                        boolean changedInstance10 = (i43 == 2048) | startRestartGroup.changedInstance(legacyTextFieldState4) | (i45 == 16384) | startRestartGroup.changedInstance(textInputService2) | (i42 == 4);
                                        int i46 = (i44 & 112) ^ 48;
                                        if (i46 <= 32 || !startRestartGroup.changed(imeOptions4)) {
                                            legacyTextFieldState = legacyTextFieldState4;
                                            if ((i44 & 48) != 32) {
                                                z11 = false;
                                                changedInstance = changedInstance10 | z11 | startRestartGroup.changedInstance(offsetMapping2) | startRestartGroup.changedInstance(coroutineScope2) | startRestartGroup.changedInstance(bringIntoViewRequester2) | startRestartGroup.changedInstance(textFieldSelectionManager3);
                                                Object rememberedValue19 = startRestartGroup.rememberedValue();
                                                if (changedInstance) {
                                                    textFieldSelectionManager = textFieldSelectionManager3;
                                                    if (rememberedValue19 != Composer.Companion.getEmpty()) {
                                                        visualTransformation4 = visualTransformation3;
                                                        coroutineScope = coroutineScope2;
                                                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                                        imeOptions5 = imeOptions4;
                                                        z12 = z8;
                                                        legacyTextFieldState2 = legacyTextFieldState;
                                                        z13 = z26;
                                                        textFieldSelectionManager2 = textFieldSelectionManager;
                                                        bringIntoViewRequester = bringIntoViewRequester2;
                                                        offsetMapping = offsetMapping2;
                                                        textInputService = textInputService2;
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        Modifier textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion3, z13, focusRequester2, mutableInteractionSource6, (Function1) rememberedValue19);
                                                        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z13 || z12) ? false : true), startRestartGroup, 0);
                                                        Unit unit = Unit.INSTANCE;
                                                        final boolean z27 = z13;
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213577460, "CC(remember):CoreTextField.kt#9igjgp");
                                                        changed = startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changedInstance(legacyTextFieldState2) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                        if (i46 > 32 || !startRestartGroup.changed(imeOptions5)) {
                                                            z14 = changed;
                                                            if ((i44 & 48) != 32) {
                                                                z15 = false;
                                                                z16 = z14 | z15;
                                                                rememberedValue = startRestartGroup.rememberedValue();
                                                                if (!z16 || rememberedValue == Composer.Companion.getEmpty()) {
                                                                    CoreTextFieldKt$CoreTextField$5$1 coreTextFieldKt$CoreTextField$5$1 = new CoreTextFieldKt$CoreTextField$5$1(legacyTextFieldState2, rememberUpdatedState, textInputService, textFieldSelectionManager2, imeOptions5, null);
                                                                    state = rememberUpdatedState;
                                                                    rememberedValue = coreTextFieldKt$CoreTextField$5$1;
                                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                                } else {
                                                                    state = rememberUpdatedState;
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                State state2 = state;
                                                                EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue, startRestartGroup, 6);
                                                                Modifier.Companion companion4 = Modifier.Companion;
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213545091, "CC(remember):CoreTextField.kt#9igjgp");
                                                                changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState2);
                                                                rememberedValue2 = startRestartGroup.rememberedValue();
                                                                if (!changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                                                    rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Object invoke(Object obj4) {
                                                                            Unit CoreTextField$lambda$16$0;
                                                                            CoreTextField$lambda$16$0 = CoreTextFieldKt.CoreTextField$lambda$16$0(LegacyTextFieldState.this, ((Boolean) obj4).booleanValue());
                                                                            return CoreTextField$lambda$16$0;
                                                                        }
                                                                    };
                                                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                Modifier updateSelectionTouchMode = SelectionGesturesKt.updateSelectionTouchMode(companion4, (Function1) rememberedValue2);
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213541055, "CC(remember):CoreTextField.kt#9igjgp");
                                                                changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState2) | (i45 != 16384) | (i43 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                                rememberedValue3 = startRestartGroup.rememberedValue();
                                                                if (!changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                                                    final OffsetMapping offsetMapping3 = offsetMapping;
                                                                    final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager2;
                                                                    final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState2;
                                                                    final boolean z28 = z12;
                                                                    rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Object invoke(Object obj4) {
                                                                            Unit CoreTextField$lambda$17$0;
                                                                            CoreTextField$lambda$17$0 = CoreTextFieldKt.CoreTextField$lambda$17$0(LegacyTextFieldState.this, focusRequester2, z28, z27, textFieldSelectionManager4, offsetMapping3, (Offset) obj4);
                                                                            return CoreTextField$lambda$17$0;
                                                                        }
                                                                    };
                                                                    focusRequester = focusRequester2;
                                                                    z17 = z27;
                                                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                                                } else {
                                                                    focusRequester = focusRequester2;
                                                                    z17 = z27;
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                Modifier tapPressTextFieldModifier = TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode, mutableInteractionSource6, z17, (Function1) rememberedValue3);
                                                                MouseSelectionObserver mouseSelectionObserver$foundation = textFieldSelectionManager2.getMouseSelectionObserver$foundation();
                                                                FocusRequester focusRequester3 = focusRequester;
                                                                TextDragObserver touchSelectionObserver$foundation = textFieldSelectionManager2.getTouchSelectionObserver$foundation();
                                                                imeOptions6 = imeOptions5;
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213507214, "CC(remember):CoreTextField.kt#9igjgp");
                                                                changedInstance4 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                                PointerInputEventHandler rememberedValue20 = startRestartGroup.rememberedValue();
                                                                if (changedInstance4) {
                                                                    z18 = z17;
                                                                } else {
                                                                    z18 = z17;
                                                                }
                                                                rememberedValue20 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1
                                                                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                                                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                                                        Object awaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, TextFieldSelectionManager.this.getMouseSelectionObserver$foundation(), TextFieldSelectionManager.this.getTouchSelectionObserver$foundation(), continuation);
                                                                        return awaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitSelectionGestures : Unit.INSTANCE;
                                                                    }
                                                                };
                                                                startRestartGroup.updateRememberedValue(rememberedValue20);
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(tapPressTextFieldModifier, mouseSelectionObserver$foundation, touchSelectionObserver$foundation, (PointerInputEventHandler) rememberedValue20), PointerIcon.Companion.getText(), false, 2, null);
                                                                Modifier.Companion companion5 = Modifier.Companion;
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213497918, "CC(remember):CoreTextField.kt#9igjgp");
                                                                changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState2) | (i42 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                                rememberedValue4 = startRestartGroup.rememberedValue();
                                                                if (!changedInstance5 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                                                    textFieldValue2 = textFieldValue;
                                                                    rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Object invoke(Object obj4) {
                                                                            Unit CoreTextField$lambda$19$0;
                                                                            CoreTextField$lambda$19$0 = CoreTextFieldKt.CoreTextField$lambda$19$0(LegacyTextFieldState.this, textFieldValue2, offsetMapping, (DrawScope) obj4);
                                                                            return CoreTextField$lambda$19$0;
                                                                        }
                                                                    };
                                                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                                                } else {
                                                                    textFieldValue2 = textFieldValue;
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                final Modifier drawBehind = DrawModifierKt.drawBehind(companion5, (Function1) rememberedValue4);
                                                                Modifier.Companion companion6 = Modifier.Companion;
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213476153, "CC(remember):CoreTextField.kt#9igjgp");
                                                                windowInfo2 = windowInfo;
                                                                changedInstance6 = (i43 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState2) | startRestartGroup.changed(windowInfo2) | startRestartGroup.changedInstance(textFieldSelectionManager2) | (i42 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                                rememberedValue5 = startRestartGroup.rememberedValue();
                                                                if (!changedInstance6 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                                                    final TextFieldValue textFieldValue3 = textFieldValue2;
                                                                    final OffsetMapping offsetMapping4 = offsetMapping;
                                                                    final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager2;
                                                                    final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState2;
                                                                    rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Object invoke(Object obj4) {
                                                                            Unit CoreTextField$lambda$20$0;
                                                                            CoreTextField$lambda$20$0 = CoreTextFieldKt.CoreTextField$lambda$20$0(LegacyTextFieldState.this, z18, windowInfo2, textFieldSelectionManager5, textFieldValue3, offsetMapping4, (LayoutCoordinates) obj4);
                                                                            return CoreTextField$lambda$20$0;
                                                                        }
                                                                    };
                                                                    z19 = z18;
                                                                    windowInfo3 = windowInfo2;
                                                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                                                } else {
                                                                    z19 = z18;
                                                                    windowInfo3 = windowInfo2;
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                final Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion6, (Function1) rememberedValue5);
                                                                final VisualTransformation visualTransformation5 = visualTransformation4;
                                                                boolean z29 = z19;
                                                                CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState2, z12, z29, visualTransformation5 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager2, imeOptions6, focusRequester3);
                                                                Brush brush5 = brush4;
                                                                final OffsetMapping offsetMapping5 = offsetMapping;
                                                                legacyTextFieldState3 = legacyTextFieldState2;
                                                                Modifier cursor = TextFieldCursorKt.cursor(Modifier.Companion, legacyTextFieldState3, textFieldValue, offsetMapping5, brush5, (z29 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState2.hasHighlight()) ? false : true);
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213406735, "CC(remember):CoreTextField.kt#9igjgp");
                                                                changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                                Object rememberedValue21 = startRestartGroup.rememberedValue();
                                                                if (changedInstance7) {
                                                                    modifier4 = cursor;
                                                                } else {
                                                                    modifier4 = cursor;
                                                                }
                                                                rememberedValue21 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda18
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj4) {
                                                                        DisposableEffectResult CoreTextField$lambda$21$0;
                                                                        CoreTextField$lambda$21$0 = CoreTextFieldKt.CoreTextField$lambda$21$0(TextFieldSelectionManager.this, (DisposableEffectScope) obj4);
                                                                        return CoreTextField$lambda$21$0;
                                                                    }
                                                                };
                                                                startRestartGroup.updateRememberedValue(rememberedValue21);
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                EffectsKt.DisposableEffect(textFieldSelectionManager2, (Function1) rememberedValue21, startRestartGroup, 0);
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213403624, "CC(remember):CoreTextField.kt#9igjgp");
                                                                changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changedInstance(textInputService) | (i42 != 4) | ((i46 <= 32 && startRestartGroup.changed(imeOptions6)) || (i44 & 48) == 32);
                                                                rememberedValue6 = startRestartGroup.rememberedValue();
                                                                if (!changedInstance8 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                                                    rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda19
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Object invoke(Object obj4) {
                                                                            DisposableEffectResult CoreTextField$lambda$22$0;
                                                                            CoreTextField$lambda$22$0 = CoreTextFieldKt.CoreTextField$lambda$22$0(LegacyTextFieldState.this, textInputService, textFieldValue, imeOptions6, (DisposableEffectScope) obj4);
                                                                            return CoreTextField$lambda$22$0;
                                                                        }
                                                                    };
                                                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                EffectsKt.DisposableEffect(imeOptions6, (Function1) rememberedValue6, startRestartGroup, (i44 >> 3) & 14);
                                                                int i47 = i32;
                                                                Modifier m1276textFieldKeyInput2WJ9YEU = TextFieldKeyInputKt.m1276textFieldKeyInput2WJ9YEU(Modifier.Companion, legacyTextFieldState3, textFieldSelectionManager2, textFieldValue, legacyTextFieldState3.getOnValueChange(), !z12, i47 != 1, offsetMapping5, undoManager, imeOptions6.m7200getImeActioneUduSuo());
                                                                final boolean z30 = KeyboardType.m7224equalsimpl0(imeOptions6.m7201getKeyboardTypePjHm6EE(), KeyboardType.Companion.m7243getPasswordPjHm6EE()) && !KeyboardType.m7224equalsimpl0(imeOptions6.m7201getKeyboardTypePjHm6EE(), KeyboardType.Companion.m7242getNumberPasswordPjHm6EE());
                                                                Modifier.Companion companion7 = Modifier.Companion;
                                                                boolean CoreTextField$lambda$14 = CoreTextField$lambda$14(state2);
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213365476, "CC(remember):CoreTextField.kt#9igjgp");
                                                                final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter3 = legacyPlatformTextInputServiceAdapter;
                                                                changed2 = startRestartGroup.changed(z30) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter3);
                                                                Object rememberedValue22 = startRestartGroup.rememberedValue();
                                                                if (changed2) {
                                                                    i33 = i47;
                                                                } else {
                                                                    i33 = i47;
                                                                }
                                                                rememberedValue22 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda20
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        Unit CoreTextField$lambda$23$0;
                                                                        CoreTextField$lambda$23$0 = CoreTextFieldKt.CoreTextField$lambda$23$0(z30, legacyPlatformTextInputServiceAdapter3);
                                                                        return CoreTextField$lambda$23$0;
                                                                    }
                                                                };
                                                                startRestartGroup.updateRememberedValue(rememberedValue22);
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                Modifier stylusHandwriting = StylusHandwritingKt.stylusHandwriting(companion7, CoreTextField$lambda$14, z30, (Function0) rememberedValue22);
                                                                String str3 = str;
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str3);
                                                                Object consume10 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightBrush());
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str3);
                                                                Object consume11 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightColor());
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                final Brush m1132resolveAutofillHighlightWkMShQ = AutofillHighlightKt.m1132resolveAutofillHighlightWkMShQ((Brush) consume10, ((Color) consume11).m4782unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                                                Modifier.Companion companion8 = Modifier.Companion;
                                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213324568, "CC(remember):CoreTextField.kt#9igjgp");
                                                                changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changed(m1132resolveAutofillHighlightWkMShQ);
                                                                rememberedValue7 = startRestartGroup.rememberedValue();
                                                                if (!changedInstance9 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                                                    rememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda21
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Object invoke(Object obj4) {
                                                                            Unit CoreTextField$lambda$24$0;
                                                                            CoreTextField$lambda$24$0 = CoreTextFieldKt.CoreTextField$lambda$24$0(LegacyTextFieldState.this, m1132resolveAutofillHighlightWkMShQ, (ContentDrawScope) obj4);
                                                                            return CoreTextField$lambda$24$0;
                                                                        }
                                                                    };
                                                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                final TextFieldScrollerPosition textFieldScrollerPosition6 = textFieldScrollerPosition5;
                                                                Modifier addContextMenuComponents = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(DrawModifierKt.drawWithContent(companion8, (Function1) rememberedValue7)), legacyPlatformTextInputServiceAdapter3, legacyTextFieldState3, textFieldSelectionManager2).then(stylusHandwriting).then(textFieldFocusModifier), legacyTextFieldState3, focusManager), legacyTextFieldState3, textFieldSelectionManager2).then(m1276textFieldKeyInput2WJ9YEU), textFieldScrollerPosition6, mutableInteractionSource6, z29, TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(startRestartGroup, 0)).then(pointerHoverIcon$default).then(coreTextFieldSemanticsModifier), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda22
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Object invoke(Object obj4) {
                                                                        return CoreTextFieldKt.CoreTextField$lambda$25(LegacyTextFieldState.this, (LayoutCoordinates) obj4);
                                                                    }
                                                                }), textFieldSelectionManager2, coroutineScope);
                                                                z20 = !z29 && legacyTextFieldState3.getHasFocus() && legacyTextFieldState3.isInTouchMode() && windowInfo3.isWindowFocused();
                                                                if (!z20) {
                                                                    companion2 = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.Companion, textFieldSelectionManager2);
                                                                } else {
                                                                    companion2 = Modifier.Companion;
                                                                }
                                                                final Modifier modifier6 = companion2;
                                                                final Modifier modifier7 = modifier4;
                                                                final int i48 = i33;
                                                                final TextStyle textStyle5 = textStyle3;
                                                                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager2;
                                                                final BringIntoViewRequester bringIntoViewRequester3 = bringIntoViewRequester;
                                                                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = lambda$559628295$foundation;
                                                                final boolean z31 = z12;
                                                                CoreTextFieldRootBox(addContextMenuComponents, textFieldSelectionManager6, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda23
                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public final Object invoke(Object obj4, Object obj5) {
                                                                        return CoreTextFieldKt.CoreTextField$lambda$26(Function3.this, legacyTextFieldState3, textStyle5, i41, i48, textFieldScrollerPosition6, textFieldValue, visualTransformation5, modifier7, drawBehind, onGloballyPositioned, modifier6, bringIntoViewRequester3, textFieldSelectionManager6, z20, z31, function14, offsetMapping5, density, (Composer) obj4, ((Integer) obj5).intValue());
                                                                    }
                                                                }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                                function32 = function33;
                                                                i27 = i41;
                                                                composer2 = startRestartGroup;
                                                                function13 = function14;
                                                                imeOptions2 = imeOptions6;
                                                                textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                                mutableInteractionSource2 = mutableInteractionSource6;
                                                                keyboardActions2 = keyboardActions4;
                                                                brush2 = brush5;
                                                                z6 = z29;
                                                                modifier2 = modifier5;
                                                                i28 = i33;
                                                                z5 = z10;
                                                                textStyle2 = textStyle3;
                                                                z4 = z12;
                                                                visualTransformation2 = visualTransformation5;
                                                            }
                                                        } else {
                                                            z14 = changed;
                                                        }
                                                        z15 = true;
                                                        z16 = z14 | z15;
                                                        rememberedValue = startRestartGroup.rememberedValue();
                                                        if (z16) {
                                                        }
                                                        CoreTextFieldKt$CoreTextField$5$1 coreTextFieldKt$CoreTextField$5$12 = new CoreTextFieldKt$CoreTextField$5$1(legacyTextFieldState2, rememberUpdatedState, textInputService, textFieldSelectionManager2, imeOptions5, null);
                                                        state = rememberUpdatedState;
                                                        rememberedValue = coreTextFieldKt$CoreTextField$5$12;
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        State state22 = state;
                                                        EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue, startRestartGroup, 6);
                                                        Modifier.Companion companion42 = Modifier.Companion;
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213545091, "CC(remember):CoreTextField.kt#9igjgp");
                                                        changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState2);
                                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                                        if (!changedInstance2) {
                                                        }
                                                        rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj4) {
                                                                Unit CoreTextField$lambda$16$0;
                                                                CoreTextField$lambda$16$0 = CoreTextFieldKt.CoreTextField$lambda$16$0(LegacyTextFieldState.this, ((Boolean) obj4).booleanValue());
                                                                return CoreTextField$lambda$16$0;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        Modifier updateSelectionTouchMode2 = SelectionGesturesKt.updateSelectionTouchMode(companion42, (Function1) rememberedValue2);
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213541055, "CC(remember):CoreTextField.kt#9igjgp");
                                                        changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState2) | (i45 != 16384) | (i43 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                        rememberedValue3 = startRestartGroup.rememberedValue();
                                                        if (changedInstance3) {
                                                        }
                                                        final OffsetMapping offsetMapping32 = offsetMapping;
                                                        final TextFieldSelectionManager textFieldSelectionManager42 = textFieldSelectionManager2;
                                                        final LegacyTextFieldState legacyTextFieldState52 = legacyTextFieldState2;
                                                        final boolean z282 = z12;
                                                        rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj4) {
                                                                Unit CoreTextField$lambda$17$0;
                                                                CoreTextField$lambda$17$0 = CoreTextFieldKt.CoreTextField$lambda$17$0(LegacyTextFieldState.this, focusRequester2, z282, z27, textFieldSelectionManager42, offsetMapping32, (Offset) obj4);
                                                                return CoreTextField$lambda$17$0;
                                                            }
                                                        };
                                                        focusRequester = focusRequester2;
                                                        z17 = z27;
                                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        Modifier tapPressTextFieldModifier2 = TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode2, mutableInteractionSource6, z17, (Function1) rememberedValue3);
                                                        MouseSelectionObserver mouseSelectionObserver$foundation2 = textFieldSelectionManager2.getMouseSelectionObserver$foundation();
                                                        FocusRequester focusRequester32 = focusRequester;
                                                        TextDragObserver touchSelectionObserver$foundation2 = textFieldSelectionManager2.getTouchSelectionObserver$foundation();
                                                        imeOptions6 = imeOptions5;
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213507214, "CC(remember):CoreTextField.kt#9igjgp");
                                                        changedInstance4 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                        PointerInputEventHandler rememberedValue202 = startRestartGroup.rememberedValue();
                                                        if (changedInstance4) {
                                                        }
                                                        rememberedValue202 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1
                                                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                                                Object awaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, TextFieldSelectionManager.this.getMouseSelectionObserver$foundation(), TextFieldSelectionManager.this.getTouchSelectionObserver$foundation(), continuation);
                                                                return awaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitSelectionGestures : Unit.INSTANCE;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue202);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        Modifier pointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(tapPressTextFieldModifier2, mouseSelectionObserver$foundation2, touchSelectionObserver$foundation2, (PointerInputEventHandler) rememberedValue202), PointerIcon.Companion.getText(), false, 2, null);
                                                        Modifier.Companion companion52 = Modifier.Companion;
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213497918, "CC(remember):CoreTextField.kt#9igjgp");
                                                        changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState2) | (i42 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                        rememberedValue4 = startRestartGroup.rememberedValue();
                                                        if (changedInstance5) {
                                                        }
                                                        textFieldValue2 = textFieldValue;
                                                        rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj4) {
                                                                Unit CoreTextField$lambda$19$0;
                                                                CoreTextField$lambda$19$0 = CoreTextFieldKt.CoreTextField$lambda$19$0(LegacyTextFieldState.this, textFieldValue2, offsetMapping, (DrawScope) obj4);
                                                                return CoreTextField$lambda$19$0;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        final Modifier drawBehind2 = DrawModifierKt.drawBehind(companion52, (Function1) rememberedValue4);
                                                        Modifier.Companion companion62 = Modifier.Companion;
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213476153, "CC(remember):CoreTextField.kt#9igjgp");
                                                        windowInfo2 = windowInfo;
                                                        changedInstance6 = (i43 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState2) | startRestartGroup.changed(windowInfo2) | startRestartGroup.changedInstance(textFieldSelectionManager2) | (i42 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                        rememberedValue5 = startRestartGroup.rememberedValue();
                                                        if (changedInstance6) {
                                                        }
                                                        final TextFieldValue textFieldValue32 = textFieldValue2;
                                                        final OffsetMapping offsetMapping42 = offsetMapping;
                                                        final TextFieldSelectionManager textFieldSelectionManager52 = textFieldSelectionManager2;
                                                        final LegacyTextFieldState legacyTextFieldState62 = legacyTextFieldState2;
                                                        rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj4) {
                                                                Unit CoreTextField$lambda$20$0;
                                                                CoreTextField$lambda$20$0 = CoreTextFieldKt.CoreTextField$lambda$20$0(LegacyTextFieldState.this, z18, windowInfo2, textFieldSelectionManager52, textFieldValue32, offsetMapping42, (LayoutCoordinates) obj4);
                                                                return CoreTextField$lambda$20$0;
                                                            }
                                                        };
                                                        z19 = z18;
                                                        windowInfo3 = windowInfo2;
                                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        final Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion62, (Function1) rememberedValue5);
                                                        final VisualTransformation visualTransformation52 = visualTransformation4;
                                                        boolean z292 = z19;
                                                        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier2 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState2, z12, z292, visualTransformation52 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager2, imeOptions6, focusRequester32);
                                                        Brush brush52 = brush4;
                                                        final OffsetMapping offsetMapping52 = offsetMapping;
                                                        legacyTextFieldState3 = legacyTextFieldState2;
                                                        Modifier cursor2 = TextFieldCursorKt.cursor(Modifier.Companion, legacyTextFieldState3, textFieldValue, offsetMapping52, brush52, (z292 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState2.hasHighlight()) ? false : true);
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213406735, "CC(remember):CoreTextField.kt#9igjgp");
                                                        changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                        Object rememberedValue212 = startRestartGroup.rememberedValue();
                                                        if (changedInstance7) {
                                                        }
                                                        rememberedValue212 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda18
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj4) {
                                                                DisposableEffectResult CoreTextField$lambda$21$0;
                                                                CoreTextField$lambda$21$0 = CoreTextFieldKt.CoreTextField$lambda$21$0(TextFieldSelectionManager.this, (DisposableEffectScope) obj4);
                                                                return CoreTextField$lambda$21$0;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue212);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        EffectsKt.DisposableEffect(textFieldSelectionManager2, (Function1) rememberedValue212, startRestartGroup, 0);
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213403624, "CC(remember):CoreTextField.kt#9igjgp");
                                                        changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changedInstance(textInputService) | (i42 != 4) | ((i46 <= 32 && startRestartGroup.changed(imeOptions6)) || (i44 & 48) == 32);
                                                        rememberedValue6 = startRestartGroup.rememberedValue();
                                                        if (!changedInstance8) {
                                                        }
                                                        rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda19
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj4) {
                                                                DisposableEffectResult CoreTextField$lambda$22$0;
                                                                CoreTextField$lambda$22$0 = CoreTextFieldKt.CoreTextField$lambda$22$0(LegacyTextFieldState.this, textInputService, textFieldValue, imeOptions6, (DisposableEffectScope) obj4);
                                                                return CoreTextField$lambda$22$0;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        EffectsKt.DisposableEffect(imeOptions6, (Function1) rememberedValue6, startRestartGroup, (i44 >> 3) & 14);
                                                        int i472 = i32;
                                                        Modifier m1276textFieldKeyInput2WJ9YEU2 = TextFieldKeyInputKt.m1276textFieldKeyInput2WJ9YEU(Modifier.Companion, legacyTextFieldState3, textFieldSelectionManager2, textFieldValue, legacyTextFieldState3.getOnValueChange(), !z12, i472 != 1, offsetMapping52, undoManager, imeOptions6.m7200getImeActioneUduSuo());
                                                        if (KeyboardType.m7224equalsimpl0(imeOptions6.m7201getKeyboardTypePjHm6EE(), KeyboardType.Companion.m7243getPasswordPjHm6EE())) {
                                                        }
                                                        Modifier.Companion companion72 = Modifier.Companion;
                                                        boolean CoreTextField$lambda$142 = CoreTextField$lambda$14(state22);
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213365476, "CC(remember):CoreTextField.kt#9igjgp");
                                                        final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter32 = legacyPlatformTextInputServiceAdapter;
                                                        changed2 = startRestartGroup.changed(z30) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter32);
                                                        Object rememberedValue222 = startRestartGroup.rememberedValue();
                                                        if (changed2) {
                                                        }
                                                        rememberedValue222 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda20
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                Unit CoreTextField$lambda$23$0;
                                                                CoreTextField$lambda$23$0 = CoreTextFieldKt.CoreTextField$lambda$23$0(z30, legacyPlatformTextInputServiceAdapter32);
                                                                return CoreTextField$lambda$23$0;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue222);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        Modifier stylusHandwriting2 = StylusHandwritingKt.stylusHandwriting(companion72, CoreTextField$lambda$142, z30, (Function0) rememberedValue222);
                                                        String str32 = str;
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str32);
                                                        Object consume102 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightBrush());
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str32);
                                                        Object consume112 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightColor());
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        final Brush m1132resolveAutofillHighlightWkMShQ2 = AutofillHighlightKt.m1132resolveAutofillHighlightWkMShQ((Brush) consume102, ((Color) consume112).m4782unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                                        Modifier.Companion companion82 = Modifier.Companion;
                                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213324568, "CC(remember):CoreTextField.kt#9igjgp");
                                                        changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changed(m1132resolveAutofillHighlightWkMShQ2);
                                                        rememberedValue7 = startRestartGroup.rememberedValue();
                                                        if (!changedInstance9) {
                                                        }
                                                        rememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda21
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj4) {
                                                                Unit CoreTextField$lambda$24$0;
                                                                CoreTextField$lambda$24$0 = CoreTextFieldKt.CoreTextField$lambda$24$0(LegacyTextFieldState.this, m1132resolveAutofillHighlightWkMShQ2, (ContentDrawScope) obj4);
                                                                return CoreTextField$lambda$24$0;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue7);
                                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                        final TextFieldScrollerPosition textFieldScrollerPosition62 = textFieldScrollerPosition5;
                                                        Modifier addContextMenuComponents2 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(DrawModifierKt.drawWithContent(companion82, (Function1) rememberedValue7)), legacyPlatformTextInputServiceAdapter32, legacyTextFieldState3, textFieldSelectionManager2).then(stylusHandwriting2).then(textFieldFocusModifier), legacyTextFieldState3, focusManager), legacyTextFieldState3, textFieldSelectionManager2).then(m1276textFieldKeyInput2WJ9YEU2), textFieldScrollerPosition62, mutableInteractionSource6, z292, TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(startRestartGroup, 0)).then(pointerHoverIcon$default2).then(coreTextFieldSemanticsModifier2), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda22
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Object invoke(Object obj4) {
                                                                return CoreTextFieldKt.CoreTextField$lambda$25(LegacyTextFieldState.this, (LayoutCoordinates) obj4);
                                                            }
                                                        }), textFieldSelectionManager2, coroutineScope);
                                                        if (z292) {
                                                        }
                                                        if (!z20) {
                                                        }
                                                        final Modifier modifier62 = companion2;
                                                        final Modifier modifier72 = modifier4;
                                                        final int i482 = i33;
                                                        final TextStyle textStyle52 = textStyle3;
                                                        final TextFieldSelectionManager textFieldSelectionManager62 = textFieldSelectionManager2;
                                                        final BringIntoViewRequester bringIntoViewRequester32 = bringIntoViewRequester;
                                                        final Function3 function332 = lambda$559628295$foundation;
                                                        final boolean z312 = z12;
                                                        CoreTextFieldRootBox(addContextMenuComponents2, textFieldSelectionManager62, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda23
                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Object invoke(Object obj4, Object obj5) {
                                                                return CoreTextFieldKt.CoreTextField$lambda$26(Function3.this, legacyTextFieldState3, textStyle52, i41, i482, textFieldScrollerPosition62, textFieldValue, visualTransformation52, modifier72, drawBehind2, onGloballyPositioned2, modifier62, bringIntoViewRequester32, textFieldSelectionManager62, z20, z312, function14, offsetMapping52, density, (Composer) obj4, ((Integer) obj5).intValue());
                                                            }
                                                        }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                        }
                                                        function32 = function332;
                                                        i27 = i41;
                                                        composer2 = startRestartGroup;
                                                        function13 = function14;
                                                        imeOptions2 = imeOptions6;
                                                        textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                        mutableInteractionSource2 = mutableInteractionSource6;
                                                        keyboardActions2 = keyboardActions4;
                                                        brush2 = brush52;
                                                        z6 = z292;
                                                        modifier2 = modifier5;
                                                        i28 = i33;
                                                        z5 = z10;
                                                        textStyle2 = textStyle3;
                                                        z4 = z12;
                                                        visualTransformation2 = visualTransformation52;
                                                    }
                                                } else {
                                                    textFieldSelectionManager = textFieldSelectionManager3;
                                                }
                                                final ImeOptions imeOptions7 = imeOptions4;
                                                final boolean z32 = z8;
                                                rememberedValue19 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        Unit CoreTextField$lambda$13$0;
                                                        CoreTextField$lambda$13$0 = CoreTextFieldKt.CoreTextField$lambda$13$0(LegacyTextFieldState.this, z26, z32, textInputService2, textFieldValue, imeOptions7, offsetMapping2, textFieldSelectionManager, coroutineScope2, bringIntoViewRequester2, (FocusState) obj4);
                                                        return CoreTextField$lambda$13$0;
                                                    }
                                                };
                                                legacyTextFieldState2 = legacyTextFieldState;
                                                z12 = z32;
                                                textInputService = textInputService2;
                                                imeOptions5 = imeOptions7;
                                                offsetMapping = offsetMapping2;
                                                coroutineScope = coroutineScope2;
                                                bringIntoViewRequester = bringIntoViewRequester2;
                                                visualTransformation4 = visualTransformation3;
                                                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                                z13 = z26;
                                                textFieldSelectionManager2 = textFieldSelectionManager;
                                                startRestartGroup.updateRememberedValue(rememberedValue19);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier textFieldFocusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion3, z13, focusRequester2, mutableInteractionSource6, (Function1) rememberedValue19);
                                                State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z13 || z12) ? false : true), startRestartGroup, 0);
                                                Unit unit2 = Unit.INSTANCE;
                                                final boolean z272 = z13;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213577460, "CC(remember):CoreTextField.kt#9igjgp");
                                                changed = startRestartGroup.changed(rememberUpdatedState2) | startRestartGroup.changedInstance(legacyTextFieldState2) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                if (i46 > 32) {
                                                }
                                                z14 = changed;
                                                if ((i44 & 48) != 32) {
                                                }
                                                z15 = true;
                                                z16 = z14 | z15;
                                                rememberedValue = startRestartGroup.rememberedValue();
                                                if (z16) {
                                                }
                                                CoreTextFieldKt$CoreTextField$5$1 coreTextFieldKt$CoreTextField$5$122 = new CoreTextFieldKt$CoreTextField$5$1(legacyTextFieldState2, rememberUpdatedState2, textInputService, textFieldSelectionManager2, imeOptions5, null);
                                                state = rememberUpdatedState2;
                                                rememberedValue = coreTextFieldKt$CoreTextField$5$122;
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                State state222 = state;
                                                EffectsKt.LaunchedEffect(unit2, (Function2) rememberedValue, startRestartGroup, 6);
                                                Modifier.Companion companion422 = Modifier.Companion;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213545091, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState2);
                                                rememberedValue2 = startRestartGroup.rememberedValue();
                                                if (!changedInstance2) {
                                                }
                                                rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        Unit CoreTextField$lambda$16$0;
                                                        CoreTextField$lambda$16$0 = CoreTextFieldKt.CoreTextField$lambda$16$0(LegacyTextFieldState.this, ((Boolean) obj4).booleanValue());
                                                        return CoreTextField$lambda$16$0;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier updateSelectionTouchMode22 = SelectionGesturesKt.updateSelectionTouchMode(companion422, (Function1) rememberedValue2);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213541055, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState2) | (i45 != 16384) | (i43 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                rememberedValue3 = startRestartGroup.rememberedValue();
                                                if (changedInstance3) {
                                                }
                                                final OffsetMapping offsetMapping322 = offsetMapping;
                                                final TextFieldSelectionManager textFieldSelectionManager422 = textFieldSelectionManager2;
                                                final LegacyTextFieldState legacyTextFieldState522 = legacyTextFieldState2;
                                                final boolean z2822 = z12;
                                                rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        Unit CoreTextField$lambda$17$0;
                                                        CoreTextField$lambda$17$0 = CoreTextFieldKt.CoreTextField$lambda$17$0(LegacyTextFieldState.this, focusRequester2, z2822, z272, textFieldSelectionManager422, offsetMapping322, (Offset) obj4);
                                                        return CoreTextField$lambda$17$0;
                                                    }
                                                };
                                                focusRequester = focusRequester2;
                                                z17 = z272;
                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier tapPressTextFieldModifier22 = TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode22, mutableInteractionSource6, z17, (Function1) rememberedValue3);
                                                MouseSelectionObserver mouseSelectionObserver$foundation22 = textFieldSelectionManager2.getMouseSelectionObserver$foundation();
                                                FocusRequester focusRequester322 = focusRequester;
                                                TextDragObserver touchSelectionObserver$foundation22 = textFieldSelectionManager2.getTouchSelectionObserver$foundation();
                                                imeOptions6 = imeOptions5;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213507214, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance4 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                PointerInputEventHandler rememberedValue2022 = startRestartGroup.rememberedValue();
                                                if (changedInstance4) {
                                                }
                                                rememberedValue2022 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1
                                                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                                        Object awaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, TextFieldSelectionManager.this.getMouseSelectionObserver$foundation(), TextFieldSelectionManager.this.getTouchSelectionObserver$foundation(), continuation);
                                                        return awaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitSelectionGestures : Unit.INSTANCE;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue2022);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier pointerHoverIcon$default22 = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(tapPressTextFieldModifier22, mouseSelectionObserver$foundation22, touchSelectionObserver$foundation22, (PointerInputEventHandler) rememberedValue2022), PointerIcon.Companion.getText(), false, 2, null);
                                                Modifier.Companion companion522 = Modifier.Companion;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213497918, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState2) | (i42 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                rememberedValue4 = startRestartGroup.rememberedValue();
                                                if (changedInstance5) {
                                                }
                                                textFieldValue2 = textFieldValue;
                                                rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        Unit CoreTextField$lambda$19$0;
                                                        CoreTextField$lambda$19$0 = CoreTextFieldKt.CoreTextField$lambda$19$0(LegacyTextFieldState.this, textFieldValue2, offsetMapping, (DrawScope) obj4);
                                                        return CoreTextField$lambda$19$0;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final Modifier drawBehind22 = DrawModifierKt.drawBehind(companion522, (Function1) rememberedValue4);
                                                Modifier.Companion companion622 = Modifier.Companion;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213476153, "CC(remember):CoreTextField.kt#9igjgp");
                                                windowInfo2 = windowInfo;
                                                changedInstance6 = (i43 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState2) | startRestartGroup.changed(windowInfo2) | startRestartGroup.changedInstance(textFieldSelectionManager2) | (i42 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                rememberedValue5 = startRestartGroup.rememberedValue();
                                                if (changedInstance6) {
                                                }
                                                final TextFieldValue textFieldValue322 = textFieldValue2;
                                                final OffsetMapping offsetMapping422 = offsetMapping;
                                                final TextFieldSelectionManager textFieldSelectionManager522 = textFieldSelectionManager2;
                                                final LegacyTextFieldState legacyTextFieldState622 = legacyTextFieldState2;
                                                rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        Unit CoreTextField$lambda$20$0;
                                                        CoreTextField$lambda$20$0 = CoreTextFieldKt.CoreTextField$lambda$20$0(LegacyTextFieldState.this, z18, windowInfo2, textFieldSelectionManager522, textFieldValue322, offsetMapping422, (LayoutCoordinates) obj4);
                                                        return CoreTextField$lambda$20$0;
                                                    }
                                                };
                                                z19 = z18;
                                                windowInfo3 = windowInfo2;
                                                startRestartGroup.updateRememberedValue(rememberedValue5);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion622, (Function1) rememberedValue5);
                                                final VisualTransformation visualTransformation522 = visualTransformation4;
                                                boolean z2922 = z19;
                                                CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier22 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState2, z12, z2922, visualTransformation522 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager2, imeOptions6, focusRequester322);
                                                Brush brush522 = brush4;
                                                final OffsetMapping offsetMapping522 = offsetMapping;
                                                legacyTextFieldState3 = legacyTextFieldState2;
                                                Modifier cursor22 = TextFieldCursorKt.cursor(Modifier.Companion, legacyTextFieldState3, textFieldValue, offsetMapping522, brush522, (z2922 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState2.hasHighlight()) ? false : true);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213406735, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                Object rememberedValue2122 = startRestartGroup.rememberedValue();
                                                if (changedInstance7) {
                                                }
                                                rememberedValue2122 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda18
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        DisposableEffectResult CoreTextField$lambda$21$0;
                                                        CoreTextField$lambda$21$0 = CoreTextFieldKt.CoreTextField$lambda$21$0(TextFieldSelectionManager.this, (DisposableEffectScope) obj4);
                                                        return CoreTextField$lambda$21$0;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue2122);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                EffectsKt.DisposableEffect(textFieldSelectionManager2, (Function1) rememberedValue2122, startRestartGroup, 0);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213403624, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changedInstance(textInputService) | (i42 != 4) | ((i46 <= 32 && startRestartGroup.changed(imeOptions6)) || (i44 & 48) == 32);
                                                rememberedValue6 = startRestartGroup.rememberedValue();
                                                if (!changedInstance8) {
                                                }
                                                rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda19
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        DisposableEffectResult CoreTextField$lambda$22$0;
                                                        CoreTextField$lambda$22$0 = CoreTextFieldKt.CoreTextField$lambda$22$0(LegacyTextFieldState.this, textInputService, textFieldValue, imeOptions6, (DisposableEffectScope) obj4);
                                                        return CoreTextField$lambda$22$0;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue6);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                EffectsKt.DisposableEffect(imeOptions6, (Function1) rememberedValue6, startRestartGroup, (i44 >> 3) & 14);
                                                int i4722 = i32;
                                                Modifier m1276textFieldKeyInput2WJ9YEU22 = TextFieldKeyInputKt.m1276textFieldKeyInput2WJ9YEU(Modifier.Companion, legacyTextFieldState3, textFieldSelectionManager2, textFieldValue, legacyTextFieldState3.getOnValueChange(), !z12, i4722 != 1, offsetMapping522, undoManager, imeOptions6.m7200getImeActioneUduSuo());
                                                if (KeyboardType.m7224equalsimpl0(imeOptions6.m7201getKeyboardTypePjHm6EE(), KeyboardType.Companion.m7243getPasswordPjHm6EE())) {
                                                }
                                                Modifier.Companion companion722 = Modifier.Companion;
                                                boolean CoreTextField$lambda$1422 = CoreTextField$lambda$14(state222);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213365476, "CC(remember):CoreTextField.kt#9igjgp");
                                                final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter322 = legacyPlatformTextInputServiceAdapter;
                                                changed2 = startRestartGroup.changed(z30) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter322);
                                                Object rememberedValue2222 = startRestartGroup.rememberedValue();
                                                if (changed2) {
                                                }
                                                rememberedValue2222 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda20
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        Unit CoreTextField$lambda$23$0;
                                                        CoreTextField$lambda$23$0 = CoreTextFieldKt.CoreTextField$lambda$23$0(z30, legacyPlatformTextInputServiceAdapter322);
                                                        return CoreTextField$lambda$23$0;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue2222);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier stylusHandwriting22 = StylusHandwritingKt.stylusHandwriting(companion722, CoreTextField$lambda$1422, z30, (Function0) rememberedValue2222);
                                                String str322 = str;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str322);
                                                Object consume1022 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightBrush());
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str322);
                                                Object consume1122 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightColor());
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final Brush m1132resolveAutofillHighlightWkMShQ22 = AutofillHighlightKt.m1132resolveAutofillHighlightWkMShQ((Brush) consume1022, ((Color) consume1122).m4782unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                                Modifier.Companion companion822 = Modifier.Companion;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213324568, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changed(m1132resolveAutofillHighlightWkMShQ22);
                                                rememberedValue7 = startRestartGroup.rememberedValue();
                                                if (!changedInstance9) {
                                                }
                                                rememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda21
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        Unit CoreTextField$lambda$24$0;
                                                        CoreTextField$lambda$24$0 = CoreTextFieldKt.CoreTextField$lambda$24$0(LegacyTextFieldState.this, m1132resolveAutofillHighlightWkMShQ22, (ContentDrawScope) obj4);
                                                        return CoreTextField$lambda$24$0;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue7);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final TextFieldScrollerPosition textFieldScrollerPosition622 = textFieldScrollerPosition5;
                                                Modifier addContextMenuComponents22 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(DrawModifierKt.drawWithContent(companion822, (Function1) rememberedValue7)), legacyPlatformTextInputServiceAdapter322, legacyTextFieldState3, textFieldSelectionManager2).then(stylusHandwriting22).then(textFieldFocusModifier2), legacyTextFieldState3, focusManager), legacyTextFieldState3, textFieldSelectionManager2).then(m1276textFieldKeyInput2WJ9YEU22), textFieldScrollerPosition622, mutableInteractionSource6, z2922, TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(startRestartGroup, 0)).then(pointerHoverIcon$default22).then(coreTextFieldSemanticsModifier22), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda22
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        return CoreTextFieldKt.CoreTextField$lambda$25(LegacyTextFieldState.this, (LayoutCoordinates) obj4);
                                                    }
                                                }), textFieldSelectionManager2, coroutineScope);
                                                if (z2922) {
                                                }
                                                if (!z20) {
                                                }
                                                final Modifier modifier622 = companion2;
                                                final Modifier modifier722 = modifier4;
                                                final int i4822 = i33;
                                                final TextStyle textStyle522 = textStyle3;
                                                final TextFieldSelectionManager textFieldSelectionManager622 = textFieldSelectionManager2;
                                                final BringIntoViewRequester bringIntoViewRequester322 = bringIntoViewRequester;
                                                final Function3 function3322 = lambda$559628295$foundation;
                                                final boolean z3122 = z12;
                                                CoreTextFieldRootBox(addContextMenuComponents22, textFieldSelectionManager622, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda23
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj4, Object obj5) {
                                                        return CoreTextFieldKt.CoreTextField$lambda$26(Function3.this, legacyTextFieldState3, textStyle522, i41, i4822, textFieldScrollerPosition622, textFieldValue, visualTransformation522, modifier722, drawBehind22, onGloballyPositioned22, modifier622, bringIntoViewRequester322, textFieldSelectionManager622, z20, z3122, function14, offsetMapping522, density, (Composer) obj4, ((Integer) obj5).intValue());
                                                    }
                                                }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                                function32 = function3322;
                                                i27 = i41;
                                                composer2 = startRestartGroup;
                                                function13 = function14;
                                                imeOptions2 = imeOptions6;
                                                textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                mutableInteractionSource2 = mutableInteractionSource6;
                                                keyboardActions2 = keyboardActions4;
                                                brush2 = brush522;
                                                z6 = z2922;
                                                modifier2 = modifier5;
                                                i28 = i33;
                                                z5 = z10;
                                                textStyle2 = textStyle3;
                                                z4 = z12;
                                                visualTransformation2 = visualTransformation522;
                                            }
                                        } else {
                                            legacyTextFieldState = legacyTextFieldState4;
                                        }
                                        z11 = true;
                                        changedInstance = changedInstance10 | z11 | startRestartGroup.changedInstance(offsetMapping2) | startRestartGroup.changedInstance(coroutineScope2) | startRestartGroup.changedInstance(bringIntoViewRequester2) | startRestartGroup.changedInstance(textFieldSelectionManager3);
                                        Object rememberedValue192 = startRestartGroup.rememberedValue();
                                        if (changedInstance) {
                                        }
                                        final ImeOptions imeOptions72 = imeOptions4;
                                        final boolean z322 = z8;
                                        rememberedValue192 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                Unit CoreTextField$lambda$13$0;
                                                CoreTextField$lambda$13$0 = CoreTextFieldKt.CoreTextField$lambda$13$0(LegacyTextFieldState.this, z26, z322, textInputService2, textFieldValue, imeOptions72, offsetMapping2, textFieldSelectionManager, coroutineScope2, bringIntoViewRequester2, (FocusState) obj4);
                                                return CoreTextField$lambda$13$0;
                                            }
                                        };
                                        legacyTextFieldState2 = legacyTextFieldState;
                                        z12 = z322;
                                        textInputService = textInputService2;
                                        imeOptions5 = imeOptions72;
                                        offsetMapping = offsetMapping2;
                                        coroutineScope = coroutineScope2;
                                        bringIntoViewRequester = bringIntoViewRequester2;
                                        visualTransformation4 = visualTransformation3;
                                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                        z13 = z26;
                                        textFieldSelectionManager2 = textFieldSelectionManager;
                                        startRestartGroup.updateRememberedValue(rememberedValue192);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier textFieldFocusModifier22 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion3, z13, focusRequester2, mutableInteractionSource6, (Function1) rememberedValue192);
                                        State rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z13 || z12) ? false : true), startRestartGroup, 0);
                                        Unit unit22 = Unit.INSTANCE;
                                        final boolean z2722 = z13;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213577460, "CC(remember):CoreTextField.kt#9igjgp");
                                        changed = startRestartGroup.changed(rememberUpdatedState22) | startRestartGroup.changedInstance(legacyTextFieldState2) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                        if (i46 > 32) {
                                        }
                                        z14 = changed;
                                        if ((i44 & 48) != 32) {
                                        }
                                        z15 = true;
                                        z16 = z14 | z15;
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (z16) {
                                        }
                                        CoreTextFieldKt$CoreTextField$5$1 coreTextFieldKt$CoreTextField$5$1222 = new CoreTextFieldKt$CoreTextField$5$1(legacyTextFieldState2, rememberUpdatedState22, textInputService, textFieldSelectionManager2, imeOptions5, null);
                                        state = rememberUpdatedState22;
                                        rememberedValue = coreTextFieldKt$CoreTextField$5$1222;
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        State state2222 = state;
                                        EffectsKt.LaunchedEffect(unit22, (Function2) rememberedValue, startRestartGroup, 6);
                                        Modifier.Companion companion4222 = Modifier.Companion;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213545091, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState2);
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (!changedInstance2) {
                                        }
                                        rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                Unit CoreTextField$lambda$16$0;
                                                CoreTextField$lambda$16$0 = CoreTextFieldKt.CoreTextField$lambda$16$0(LegacyTextFieldState.this, ((Boolean) obj4).booleanValue());
                                                return CoreTextField$lambda$16$0;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier updateSelectionTouchMode222 = SelectionGesturesKt.updateSelectionTouchMode(companion4222, (Function1) rememberedValue2);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213541055, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState2) | (i45 != 16384) | (i43 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                        rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (changedInstance3) {
                                        }
                                        final OffsetMapping offsetMapping3222 = offsetMapping;
                                        final TextFieldSelectionManager textFieldSelectionManager4222 = textFieldSelectionManager2;
                                        final LegacyTextFieldState legacyTextFieldState5222 = legacyTextFieldState2;
                                        final boolean z28222 = z12;
                                        rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                Unit CoreTextField$lambda$17$0;
                                                CoreTextField$lambda$17$0 = CoreTextFieldKt.CoreTextField$lambda$17$0(LegacyTextFieldState.this, focusRequester2, z28222, z2722, textFieldSelectionManager4222, offsetMapping3222, (Offset) obj4);
                                                return CoreTextField$lambda$17$0;
                                            }
                                        };
                                        focusRequester = focusRequester2;
                                        z17 = z2722;
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier tapPressTextFieldModifier222 = TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode222, mutableInteractionSource6, z17, (Function1) rememberedValue3);
                                        MouseSelectionObserver mouseSelectionObserver$foundation222 = textFieldSelectionManager2.getMouseSelectionObserver$foundation();
                                        FocusRequester focusRequester3222 = focusRequester;
                                        TextDragObserver touchSelectionObserver$foundation222 = textFieldSelectionManager2.getTouchSelectionObserver$foundation();
                                        imeOptions6 = imeOptions5;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213507214, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance4 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                                        PointerInputEventHandler rememberedValue20222 = startRestartGroup.rememberedValue();
                                        if (changedInstance4) {
                                        }
                                        rememberedValue20222 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$3$1
                                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                                Object awaitSelectionGestures = SelectionGesturesKt.awaitSelectionGestures(pointerInputScope, TextFieldSelectionManager.this.getMouseSelectionObserver$foundation(), TextFieldSelectionManager.this.getTouchSelectionObserver$foundation(), continuation);
                                                return awaitSelectionGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitSelectionGestures : Unit.INSTANCE;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue20222);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier pointerHoverIcon$default222 = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(tapPressTextFieldModifier222, mouseSelectionObserver$foundation222, touchSelectionObserver$foundation222, (PointerInputEventHandler) rememberedValue20222), PointerIcon.Companion.getText(), false, 2, null);
                                        Modifier.Companion companion5222 = Modifier.Companion;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213497918, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState2) | (i42 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                        rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (changedInstance5) {
                                        }
                                        textFieldValue2 = textFieldValue;
                                        rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                Unit CoreTextField$lambda$19$0;
                                                CoreTextField$lambda$19$0 = CoreTextFieldKt.CoreTextField$lambda$19$0(LegacyTextFieldState.this, textFieldValue2, offsetMapping, (DrawScope) obj4);
                                                return CoreTextField$lambda$19$0;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Modifier drawBehind222 = DrawModifierKt.drawBehind(companion5222, (Function1) rememberedValue4);
                                        Modifier.Companion companion6222 = Modifier.Companion;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213476153, "CC(remember):CoreTextField.kt#9igjgp");
                                        windowInfo2 = windowInfo;
                                        changedInstance6 = (i43 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState2) | startRestartGroup.changed(windowInfo2) | startRestartGroup.changedInstance(textFieldSelectionManager2) | (i42 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                        rememberedValue5 = startRestartGroup.rememberedValue();
                                        if (changedInstance6) {
                                        }
                                        final TextFieldValue textFieldValue3222 = textFieldValue2;
                                        final OffsetMapping offsetMapping4222 = offsetMapping;
                                        final TextFieldSelectionManager textFieldSelectionManager5222 = textFieldSelectionManager2;
                                        final LegacyTextFieldState legacyTextFieldState6222 = legacyTextFieldState2;
                                        rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                Unit CoreTextField$lambda$20$0;
                                                CoreTextField$lambda$20$0 = CoreTextFieldKt.CoreTextField$lambda$20$0(LegacyTextFieldState.this, z18, windowInfo2, textFieldSelectionManager5222, textFieldValue3222, offsetMapping4222, (LayoutCoordinates) obj4);
                                                return CoreTextField$lambda$20$0;
                                            }
                                        };
                                        z19 = z18;
                                        windowInfo3 = windowInfo2;
                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Modifier onGloballyPositioned222 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion6222, (Function1) rememberedValue5);
                                        final VisualTransformation visualTransformation5222 = visualTransformation4;
                                        boolean z29222 = z19;
                                        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier222 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState2, z12, z29222, visualTransformation5222 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager2, imeOptions6, focusRequester3222);
                                        Brush brush5222 = brush4;
                                        final OffsetMapping offsetMapping5222 = offsetMapping;
                                        legacyTextFieldState3 = legacyTextFieldState2;
                                        Modifier cursor222 = TextFieldCursorKt.cursor(Modifier.Companion, legacyTextFieldState3, textFieldValue, offsetMapping5222, brush5222, (z29222 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState2.hasHighlight()) ? false : true);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213406735, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                                        Object rememberedValue21222 = startRestartGroup.rememberedValue();
                                        if (changedInstance7) {
                                        }
                                        rememberedValue21222 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda18
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                DisposableEffectResult CoreTextField$lambda$21$0;
                                                CoreTextField$lambda$21$0 = CoreTextFieldKt.CoreTextField$lambda$21$0(TextFieldSelectionManager.this, (DisposableEffectScope) obj4);
                                                return CoreTextField$lambda$21$0;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue21222);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.DisposableEffect(textFieldSelectionManager2, (Function1) rememberedValue21222, startRestartGroup, 0);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213403624, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changedInstance(textInputService) | (i42 != 4) | ((i46 <= 32 && startRestartGroup.changed(imeOptions6)) || (i44 & 48) == 32);
                                        rememberedValue6 = startRestartGroup.rememberedValue();
                                        if (!changedInstance8) {
                                        }
                                        rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda19
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                DisposableEffectResult CoreTextField$lambda$22$0;
                                                CoreTextField$lambda$22$0 = CoreTextFieldKt.CoreTextField$lambda$22$0(LegacyTextFieldState.this, textInputService, textFieldValue, imeOptions6, (DisposableEffectScope) obj4);
                                                return CoreTextField$lambda$22$0;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.DisposableEffect(imeOptions6, (Function1) rememberedValue6, startRestartGroup, (i44 >> 3) & 14);
                                        int i47222 = i32;
                                        Modifier m1276textFieldKeyInput2WJ9YEU222 = TextFieldKeyInputKt.m1276textFieldKeyInput2WJ9YEU(Modifier.Companion, legacyTextFieldState3, textFieldSelectionManager2, textFieldValue, legacyTextFieldState3.getOnValueChange(), !z12, i47222 != 1, offsetMapping5222, undoManager, imeOptions6.m7200getImeActioneUduSuo());
                                        if (KeyboardType.m7224equalsimpl0(imeOptions6.m7201getKeyboardTypePjHm6EE(), KeyboardType.Companion.m7243getPasswordPjHm6EE())) {
                                        }
                                        Modifier.Companion companion7222 = Modifier.Companion;
                                        boolean CoreTextField$lambda$14222 = CoreTextField$lambda$14(state2222);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213365476, "CC(remember):CoreTextField.kt#9igjgp");
                                        final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter3222 = legacyPlatformTextInputServiceAdapter;
                                        changed2 = startRestartGroup.changed(z30) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter3222);
                                        Object rememberedValue22222 = startRestartGroup.rememberedValue();
                                        if (changed2) {
                                        }
                                        rememberedValue22222 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda20
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                Unit CoreTextField$lambda$23$0;
                                                CoreTextField$lambda$23$0 = CoreTextFieldKt.CoreTextField$lambda$23$0(z30, legacyPlatformTextInputServiceAdapter3222);
                                                return CoreTextField$lambda$23$0;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue22222);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier stylusHandwriting222 = StylusHandwritingKt.stylusHandwriting(companion7222, CoreTextField$lambda$14222, z30, (Function0) rememberedValue22222);
                                        String str3222 = str;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str3222);
                                        Object consume10222 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightBrush());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str3222);
                                        Object consume11222 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightColor());
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Brush m1132resolveAutofillHighlightWkMShQ222 = AutofillHighlightKt.m1132resolveAutofillHighlightWkMShQ((Brush) consume10222, ((Color) consume11222).m4782unboximpl(), AutofillHighlight_androidKt.autofillHighlightColor());
                                        Modifier.Companion companion8222 = Modifier.Companion;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213324568, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changed(m1132resolveAutofillHighlightWkMShQ222);
                                        rememberedValue7 = startRestartGroup.rememberedValue();
                                        if (!changedInstance9) {
                                        }
                                        rememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda21
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                Unit CoreTextField$lambda$24$0;
                                                CoreTextField$lambda$24$0 = CoreTextFieldKt.CoreTextField$lambda$24$0(LegacyTextFieldState.this, m1132resolveAutofillHighlightWkMShQ222, (ContentDrawScope) obj4);
                                                return CoreTextField$lambda$24$0;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue7);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final TextFieldScrollerPosition textFieldScrollerPosition6222 = textFieldScrollerPosition5;
                                        Modifier addContextMenuComponents222 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(DrawModifierKt.drawWithContent(companion8222, (Function1) rememberedValue7)), legacyPlatformTextInputServiceAdapter3222, legacyTextFieldState3, textFieldSelectionManager2).then(stylusHandwriting222).then(textFieldFocusModifier22), legacyTextFieldState3, focusManager), legacyTextFieldState3, textFieldSelectionManager2).then(m1276textFieldKeyInput2WJ9YEU222), textFieldScrollerPosition6222, mutableInteractionSource6, z29222, TextFieldScroll_androidKt.rememberTextFieldOverscrollEffect(startRestartGroup, 0)).then(pointerHoverIcon$default222).then(coreTextFieldSemanticsModifier222), new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda22
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj4) {
                                                return CoreTextFieldKt.CoreTextField$lambda$25(LegacyTextFieldState.this, (LayoutCoordinates) obj4);
                                            }
                                        }), textFieldSelectionManager2, coroutineScope);
                                        if (z29222) {
                                        }
                                        if (!z20) {
                                        }
                                        final Modifier modifier6222 = companion2;
                                        final Modifier modifier7222 = modifier4;
                                        final int i48222 = i33;
                                        final TextStyle textStyle5222 = textStyle3;
                                        final TextFieldSelectionManager textFieldSelectionManager6222 = textFieldSelectionManager2;
                                        final BringIntoViewRequester bringIntoViewRequester3222 = bringIntoViewRequester;
                                        final Function3 function33222 = lambda$559628295$foundation;
                                        final boolean z31222 = z12;
                                        CoreTextFieldRootBox(addContextMenuComponents222, textFieldSelectionManager6222, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda23
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj4, Object obj5) {
                                                return CoreTextFieldKt.CoreTextField$lambda$26(Function3.this, legacyTextFieldState3, textStyle5222, i41, i48222, textFieldScrollerPosition6222, textFieldValue, visualTransformation5222, modifier7222, drawBehind222, onGloballyPositioned222, modifier6222, bringIntoViewRequester3222, textFieldSelectionManager6222, z20, z31222, function14, offsetMapping5222, density, (Composer) obj4, ((Integer) obj5).intValue());
                                            }
                                        }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        function32 = function33222;
                                        i27 = i41;
                                        composer2 = startRestartGroup;
                                        function13 = function14;
                                        imeOptions2 = imeOptions6;
                                        textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                        mutableInteractionSource2 = mutableInteractionSource6;
                                        keyboardActions2 = keyboardActions4;
                                        brush2 = brush5222;
                                        z6 = z29222;
                                        modifier2 = modifier5;
                                        i28 = i33;
                                        z5 = z10;
                                        textStyle2 = textStyle3;
                                        z4 = z12;
                                        visualTransformation2 = visualTransformation5222;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        i27 = i2;
                                        keyboardActions2 = keyboardActions;
                                        z4 = z3;
                                        function32 = function3;
                                        textFieldScrollerPosition2 = textFieldScrollerPosition;
                                        composer2 = startRestartGroup;
                                        brush2 = solidColor;
                                        mutableInteractionSource2 = obj3;
                                        function13 = obj2;
                                        textStyle2 = obj;
                                        modifier2 = companion;
                                        visualTransformation2 = visualTransformation;
                                        z5 = z;
                                        i28 = i;
                                        imeOptions2 = imeOptions;
                                        z6 = z2;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj4, Object obj5) {
                                                return CoreTextFieldKt.CoreTextField$lambda$27(TextFieldValue.this, function1, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush2, z5, i28, i27, imeOptions2, keyboardActions2, z6, z4, function32, textFieldScrollerPosition2, i3, i4, i5, (Composer) obj4, ((Integer) obj5).intValue());
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i25 = i5 & 32768;
                            if (i25 != 0) {
                            }
                            i26 = i5 & 65536;
                            if (i26 != 0) {
                            }
                            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i15 = i14;
                        i16 = i5 & 1024;
                        if (i16 == 0) {
                        }
                        if ((i4 & 48) == 0) {
                        }
                        int i362 = i18;
                        i19 = i5 & 4096;
                        if (i19 == 0) {
                        }
                        i21 = i5 & 8192;
                        if (i21 == 0) {
                        }
                        i23 = i5 & 16384;
                        if (i23 == 0) {
                        }
                        i25 = i5 & 32768;
                        if (i25 != 0) {
                        }
                        i26 = i5 & 65536;
                        if (i26 != 0) {
                        }
                        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i13 = i12;
                    i14 = i5 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i5 & 1024;
                    if (i16 == 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    int i3622 = i18;
                    i19 = i5 & 4096;
                    if (i19 == 0) {
                    }
                    i21 = i5 & 8192;
                    if (i21 == 0) {
                    }
                    i23 = i5 & 16384;
                    if (i23 == 0) {
                    }
                    i25 = i5 & 32768;
                    if (i25 != 0) {
                    }
                    i26 = i5 & 65536;
                    if (i26 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i9 = i5 & 32;
                if (i9 == 0) {
                }
                i10 = i5 & 64;
                if (i10 == 0) {
                }
                i11 = i5 & 128;
                if (i11 == 0) {
                }
                i12 = i5 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i5 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i5 & 1024;
                if (i16 == 0) {
                }
                if ((i4 & 48) == 0) {
                }
                int i36222 = i18;
                i19 = i5 & 4096;
                if (i19 == 0) {
                }
                i21 = i5 & 8192;
                if (i21 == 0) {
                }
                i23 = i5 & 16384;
                if (i23 == 0) {
                }
                i25 = i5 & 32768;
                if (i25 != 0) {
                }
                i26 = i5 & 65536;
                if (i26 != 0) {
                }
                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = textStyle;
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            i9 = i5 & 32;
            if (i9 == 0) {
            }
            i10 = i5 & 64;
            if (i10 == 0) {
            }
            i11 = i5 & 128;
            if (i11 == 0) {
            }
            i12 = i5 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i5 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i5 & 1024;
            if (i16 == 0) {
            }
            if ((i4 & 48) == 0) {
            }
            int i362222 = i18;
            i19 = i5 & 4096;
            if (i19 == 0) {
            }
            i21 = i5 & 8192;
            if (i21 == 0) {
            }
            i23 = i5 & 16384;
            if (i23 == 0) {
            }
            i25 = i5 & 32768;
            if (i25 != 0) {
            }
            i26 = i5 & 65536;
            if (i26 != 0) {
            }
            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i7 = i5 & 8;
        if (i7 == 0) {
        }
        obj = textStyle;
        i8 = i5 & 16;
        if (i8 != 0) {
        }
        i9 = i5 & 32;
        if (i9 == 0) {
        }
        i10 = i5 & 64;
        if (i10 == 0) {
        }
        i11 = i5 & 128;
        if (i11 == 0) {
        }
        i12 = i5 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i5 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i5 & 1024;
        if (i16 == 0) {
        }
        if ((i4 & 48) == 0) {
        }
        int i3622222 = i18;
        i19 = i5 & 4096;
        if (i19 == 0) {
        }
        i21 = i5 & 8192;
        if (i21 == 0) {
        }
        i23 = i5 & 16384;
        if (i23 == 0) {
        }
        i25 = i5 & 32768;
        if (i25 != 0) {
        }
        i26 = i5 & 65536;
        if (i26 != 0) {
        }
        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i24 & 599187) != 599186, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldScrollerPosition CoreTextField$lambda$4$0(Orientation orientation) {
        return new TextFieldScrollerPosition(orientation, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CoreTextField$lambda$10(TextFieldSelectionManager textFieldSelectionManager, AnnotatedString annotatedString) {
        textFieldSelectionManager.paste$foundation(annotatedString);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$13$0(LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, FocusState focusState) {
        TextLayoutResultProxy layoutResult;
        if (legacyTextFieldState.getHasFocus() == focusState.isFocused()) {
            return Unit.INSTANCE;
        }
        legacyTextFieldState.setHasFocus(focusState.isFocused());
        if (legacyTextFieldState.getHasFocus() && z && !z2) {
            startInputSession(textInputService, legacyTextFieldState, textFieldValue, imeOptions, offsetMapping);
        } else {
            endInputSession(legacyTextFieldState);
        }
        if (focusState.isFocused() && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, textFieldValue, legacyTextFieldState, layoutResult, offsetMapping, null), 3, null);
        }
        if (!focusState.isFocused()) {
            TextFieldSelectionManager.m1655deselect_kEHs6E$foundation$default(textFieldSelectionManager, null, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$16$0(LegacyTextFieldState legacyTextFieldState, boolean z) {
        legacyTextFieldState.setInTouchMode(z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$17$0(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z, boolean z2, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping, Offset offset) {
        tapToFocus(legacyTextFieldState, focusRequester, !z);
        if (legacyTextFieldState.getHasFocus() && z2) {
            if (legacyTextFieldState.getHandleState() != HandleState.Selection) {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null) {
                    TextFieldDelegate.Companion.m1264setCursorOffsetULxng0E$foundation(offset.m4537unboximpl(), layoutResult, legacyTextFieldState.getProcessor(), offsetMapping, legacyTextFieldState.getOnValueChange());
                    if (legacyTextFieldState.getTextDelegate().getText().length() > 0) {
                        legacyTextFieldState.setHandleState(HandleState.Cursor);
                    }
                }
            } else {
                textFieldSelectionManager.m1659deselect_kEHs6E$foundation(offset);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$19$0(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping, DrawScope drawScope) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            TextFieldDelegate.Companion.m1262drawQ1vqE60$foundation(drawScope.getDrawContext().getCanvas(), textFieldValue, legacyTextFieldState.m1221getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState.m1218getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping, layoutResult.getValue(), legacyTextFieldState.getHighlightPaint(), legacyTextFieldState.m1220getSelectionBackgroundColor0d7_KjU());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$20$0(LegacyTextFieldState legacyTextFieldState, boolean z, WindowInfo windowInfo, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, OffsetMapping offsetMapping, LayoutCoordinates layoutCoordinates) {
        TextInputSession inputSession;
        legacyTextFieldState.setLayoutCoordinates(layoutCoordinates);
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
        }
        if (z) {
            if (legacyTextFieldState.getHandleState() == HandleState.Selection) {
                if (legacyTextFieldState.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                    textFieldSelectionManager.showSelectionToolbar$foundation();
                } else {
                    textFieldSelectionManager.hideSelectionToolbar$foundation();
                }
                legacyTextFieldState.setShowSelectionHandleStart(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                legacyTextFieldState.setShowSelectionHandleEnd(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                legacyTextFieldState.setShowCursorHandle(TextRange.m6997getCollapsedimpl(textFieldValue.m7253getSelectiond9O1mEE()));
            } else if (legacyTextFieldState.getHandleState() == HandleState.Cursor) {
                legacyTextFieldState.setShowCursorHandle(TextFieldSelectionManager_androidKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
            }
            notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
            TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
            if (layoutResult2 != null && (inputSession = legacyTextFieldState.getInputSession()) != null && legacyTextFieldState.getHasFocus()) {
                TextFieldDelegate.Companion.updateTextLayoutResult$foundation(inputSession, textFieldValue, offsetMapping, layoutResult2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult CoreTextField$lambda$22$0(LegacyTextFieldState legacyTextFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, DisposableEffectScope disposableEffectScope) {
        if (legacyTextFieldState.getHasFocus()) {
            legacyTextFieldState.setInputSession(TextFieldDelegate.Companion.restartInput$foundation(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        }
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$22$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$23$0(boolean z, LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter) {
        if (z) {
            legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$24$0(LegacyTextFieldState legacyTextFieldState, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (legacyTextFieldState.getAutofillHighlightOn() || legacyTextFieldState.getJustAutofilled()) {
            DrawScope.m5339drawRectAsUm42w$default(contentDrawScope, brush, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CoreTextField$lambda$25(LegacyTextFieldState legacyTextFieldState, LayoutCoordinates layoutCoordinates) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult != null) {
            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CoreTextField$lambda$26(Function3 function3, final LegacyTextFieldState legacyTextFieldState, final TextStyle textStyle, final int i, final int i2, final TextFieldScrollerPosition textFieldScrollerPosition, final TextFieldValue textFieldValue, final VisualTransformation visualTransformation, final Modifier modifier, final Modifier modifier2, final Modifier modifier3, final Modifier modifier4, final BringIntoViewRequester bringIntoViewRequester, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, final boolean z2, final Function1 function1, final OffsetMapping offsetMapping, final Density density, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C588@27697L5379,588@27683L5393:CoreTextField.kt#423gt5");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-814563849, i3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:588)");
            }
            function3.invoke(ComposableLambdaKt.rememberComposableLambda(-44346382, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CoreTextField$lambda$26$0;
                    CoreTextField$lambda$26$0 = CoreTextFieldKt.CoreTextField$lambda$26$0(LegacyTextFieldState.this, textStyle, i, i2, textFieldScrollerPosition, textFieldValue, visualTransformation, modifier, modifier2, modifier3, modifier4, bringIntoViewRequester, textFieldSelectionManager, z, z2, function1, offsetMapping, density, (Composer) obj, ((Integer) obj2).intValue());
                    return CoreTextField$lambda$26$0;
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$26$0(final LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, final int i2, TextFieldScrollerPosition textFieldScrollerPosition, final TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, final TextFieldSelectionManager textFieldSelectionManager, final boolean z, final boolean z2, final Function1 function1, final OffsetMapping offsetMapping, final Density density, Composer composer, int i3) {
        ComposerKt.sourceInformation(composer, "C602@28548L22,611@28935L4131,611@28899L4167:CoreTextField.kt#423gt5");
        if (!composer.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-44346382, i3, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:591)");
            }
            Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m852heightInVpY3zN4$default(Modifier.Companion, legacyTextFieldState.m1219getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle, i, i2);
            ComposerKt.sourceInformationMarkerStart(composer, 332827112, "CC(remember):CoreTextField.kt#9igjgp");
            boolean changedInstance = composer.changedInstance(legacyTextFieldState);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        TextLayoutResultProxy layoutResult;
                        layoutResult = LegacyTextFieldState.this.getLayoutResult();
                        return layoutResult;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SimpleLayoutKt.SimpleLayout(BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(heightInLines, textFieldScrollerPosition, textFieldValue, visualTransformation, (Function0) rememberedValue).then(modifier).then(modifier2), textStyle).then(modifier3).then(modifier4), bringIntoViewRequester), ComposableLambdaKt.rememberComposableLambda(1412697320, true, new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CoreTextField$lambda$26$0$1;
                    CoreTextField$lambda$26$0$1 = CoreTextFieldKt.CoreTextField$lambda$26$0$1(TextFieldSelectionManager.this, legacyTextFieldState, z, z2, function1, textFieldValue, offsetMapping, density, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return CoreTextField$lambda$26$0$1;
                }
            }, composer, 54), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e5, code lost:
        if (r16 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit CoreTextField$lambda$26$0$1(TextFieldSelectionManager textFieldSelectionManager, LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, Function1 function1, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Density density, int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C612@28953L3502,677@32473L359:CoreTextField.kt#423gt5");
        boolean z3 = true;
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412697320, i2, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:612)");
            }
            CoreTextFieldKt$CoreTextField$8$1$1$2 coreTextFieldKt$CoreTextField$8$1$1$2 = new CoreTextFieldKt$CoreTextField$8$1$1$2(legacyTextFieldState, function1, textFieldValue, offsetMapping, density, i);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, Modifier.Companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(composer);
            Updater.m4049setimpl(m4041constructorimpl, coreTextFieldKt$CoreTextField$8$1$1$2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1613409842, "C:CoreTextField.kt#423gt5");
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (legacyTextFieldState.getHandleState() != HandleState.None && legacyTextFieldState.getLayoutCoordinates() != null) {
                LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                Intrinsics.checkNotNull(layoutCoordinates);
                if (layoutCoordinates.isAttached()) {
                }
            }
            z3 = false;
            SelectionToolbarAndHandles(textFieldSelectionManager, z3, composer, 0);
            if (legacyTextFieldState.getHandleState() != HandleState.Cursor || z2 || !z) {
                composer.startReplaceGroup(-747377894);
            } else {
                composer.startReplaceGroup(-714666198);
                ComposerKt.sourceInformation(composer, "689@32994L40");
                TextFieldCursorHandle(textFieldSelectionManager, composer, 0);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2036174316);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextFieldRootBox)N(modifier,manager,content)702@33241L83:CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2036174316, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:701)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4045initimpl(m4041constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4047reconcileimpl(m4041constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1799443472, "C702@33289L33:CoreTextField.kt#423gt5");
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, startRestartGroup, (i2 >> 3) & WebSocketProtocol.PAYLOAD_SHORT);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.CoreTextFieldRootBox$lambda$1(Modifier.this, textFieldSelectionManager, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1196invokeZmokQxo(keyEvent.m5917unboximpl());
            }

            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m1196invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1199cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m1655deselect_kEHs6E$foundation$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    public static final void tapToFocus(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
        SoftwareKeyboardController keyboardController;
        if (!legacyTextFieldState.getHasFocus()) {
            FocusRequester.m4432requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        } else if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
        } else {
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.setInputSession(TextFieldDelegate.Companion.onFocus$foundation(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m7000getMaximpl(textFieldValue.m7253getSelectiond9O1mEE()));
        if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed);
        } else if (originalToTransformed != 0) {
            rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
        } else {
            rect = new Rect(0.0f, 0.0f, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null) & 4294967295L));
        }
        Object bringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    private static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles)N(manager,show):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1054)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(1530097388);
                ComposerKt.sourceInformation(startRestartGroup, "");
                LegacyTextFieldState state$foundation = textFieldSelectionManager.getState$foundation();
                TextLayoutResult textLayoutResult = null;
                if (state$foundation != null && (layoutResult = state$foundation.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state$foundation2 = textFieldSelectionManager.getState$foundation();
                    if (!(state$foundation2 != null ? state$foundation2.isLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    startRestartGroup.startReplaceGroup(1530097387);
                } else {
                    startRestartGroup.startReplaceGroup(1530097388);
                    ComposerKt.sourceInformation(startRestartGroup, "");
                    if (TextRange.m6997getCollapsedimpl(textFieldSelectionManager.getValue$foundation().m7253getSelectiond9O1mEE())) {
                        startRestartGroup.startReplaceGroup(2062097806);
                    } else {
                        startRestartGroup.startReplaceGroup(2109807302);
                        ComposerKt.sourceInformation(startRestartGroup, "");
                        int originalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation().originalToTransformed(TextRange.m7003getStartimpl(textFieldSelectionManager.getValue$foundation().m7253getSelectiond9O1mEE()));
                        int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation().originalToTransformed(TextRange.m6998getEndimpl(textFieldSelectionManager.getValue$foundation().m7253getSelectiond9O1mEE()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                        LegacyTextFieldState state$foundation3 = textFieldSelectionManager.getState$foundation();
                        if (state$foundation3 == null || !state$foundation3.getShowSelectionHandleStart()) {
                            startRestartGroup.startReplaceGroup(2062097806);
                        } else {
                            startRestartGroup.startReplaceGroup(2110225306);
                            ComposerKt.sourceInformation(startRestartGroup, "1070@48536L220");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, ((i2 << 6) & 896) | 6);
                        }
                        startRestartGroup.endReplaceGroup();
                        LegacyTextFieldState state$foundation4 = textFieldSelectionManager.getState$foundation();
                        if (state$foundation4 == null || !state$foundation4.getShowSelectionHandleEnd()) {
                            startRestartGroup.startReplaceGroup(2062097806);
                        } else {
                            startRestartGroup.startReplaceGroup(2110574459);
                            ComposerKt.sourceInformation(startRestartGroup, "1077@48888L219");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, ((i2 << 6) & 896) | 6);
                        }
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                    LegacyTextFieldState state$foundation5 = textFieldSelectionManager.getState$foundation();
                    if (state$foundation5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation()) {
                            state$foundation5.setShowFloatingToolbar(false);
                        }
                        if (state$foundation5.getHasFocus()) {
                            if (state$foundation5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1989076778);
                startRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CoreTextFieldKt.SelectionToolbarAndHandles$lambda$1(TextFieldSelectionManager.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        AnnotatedString transformedText$foundation;
        Composer startRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)N(manager):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1101)");
            }
            LegacyTextFieldState state$foundation = textFieldSelectionManager.getState$foundation();
            if (state$foundation == null || !state$foundation.getShowCursorHandle() || (transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation()) == null || transformedText$foundation.length() <= 0) {
                startRestartGroup.startReplaceGroup(2132946858);
            } else {
                startRestartGroup.startReplaceGroup(-2112351432);
                ComposerKt.sourceInformation(startRestartGroup, "1103@50051L50,1104@50164L7,1106@50224L12,1108@50309L645,1120@50986L385,1105@50181L1201");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1315066870, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changed = startRestartGroup.changed(textFieldSelectionManager);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final long m1661getCursorPositiontuRUvjQ$foundation = textFieldSelectionManager.m1661getCursorPositiontuRUvjQ$foundation((Density) consume);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1315061372, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed(m1661getCursorPositiontuRUvjQ$foundation);
                OffsetProvider rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0 */
                        public final long mo1144provideF1C5BW0() {
                            return m1661getCursorPositiontuRUvjQ$foundation;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier.Companion companion = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1315058019, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(textDragObserver) | startRestartGroup.changedInstance(textFieldSelectionManager);
                PointerInputEventHandler rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1

                        /* compiled from: CoreTextField.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1", f = "CoreTextField.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1  reason: invalid class name */
                        /* loaded from: classes.dex */
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ TextFieldSelectionManager $manager;
                            final /* synthetic */ TextDragObserver $observer;
                            final /* synthetic */ PointerInputScope $this_pointerInput;
                            private /* synthetic */ Object L$0;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$this_pointerInput = pointerInputScope;
                                this.$observer = textDragObserver;
                                this.$manager = textFieldSelectionManager;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$observer, this.$manager, continuation);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new C00121(this.$this_pointerInput, this.$observer, null), 1, null);
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_pointerInput, this.$manager, null), 1, null);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: CoreTextField.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1", f = "CoreTextField.kt", i = {}, l = {1114}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1  reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes.dex */
                            public static final class C00121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextDragObserver $observer;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00121(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation<? super C00121> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$observer = textDragObserver;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00121(this.$this_pointerInput, this.$observer, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(this.$this_pointerInput, this.$observer, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    } else {
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: CoreTextField.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2", f = "CoreTextField.kt", i = {}, l = {1117}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2  reason: invalid class name */
                            /* loaded from: classes.dex */
                            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextFieldSelectionManager $manager;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass2> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$manager = textFieldSelectionManager;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass2(this.$this_pointerInput, this.$manager, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        PointerInputScope pointerInputScope = this.$this_pointerInput;
                                        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
                                        this.label = 1;
                                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:112)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            */
                                        /*
                                            this = this;
                                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                            int r1 = r9.label
                                            r2 = 1
                                            if (r1 == 0) goto L17
                                            if (r1 != r2) goto Lf
                                            kotlin.ResultKt.throwOnFailure(r10)
                                            goto L34
                                        Lf:
                                            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                                            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                                            r9.<init>(r10)
                                            throw r9
                                        L17:
                                            kotlin.ResultKt.throwOnFailure(r10)
                                            androidx.compose.ui.input.pointer.PointerInputScope r1 = r9.$this_pointerInput
                                            androidx.compose.foundation.text.selection.TextFieldSelectionManager r10 = r9.$manager
                                            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0
                                            r5.<init>(r10)
                                            r6 = r9
                                            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                                            r9.label = r2
                                            r2 = 0
                                            r3 = 0
                                            r4 = 0
                                            r7 = 7
                                            r8 = 0
                                            java.lang.Object r9 = androidx.compose.foundation.gestures.TapGestureDetectorKt.detectTapGestures$default(r1, r2, r3, r4, r5, r6, r7, r8)
                                            if (r9 != r0) goto L34
                                            return r0
                                        L34:
                                            kotlin.Unit r9 = kotlin.Unit.INSTANCE
                                            return r9
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1.AnonymousClass1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                                    }

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    public static final Unit invokeSuspend$lambda$0(TextFieldSelectionManager textFieldSelectionManager, Offset offset) {
                                        textFieldSelectionManager.showSelectionToolbar$foundation();
                                        return Unit.INSTANCE;
                                    }
                                }
                            }

                            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, TextDragObserver.this, textFieldSelectionManager, null), continuation);
                                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) rememberedValue3);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1315036615, "CC(remember):CoreTextField.kt#9igjgp");
                    boolean changed3 = startRestartGroup.changed(m1661getCursorPositiontuRUvjQ$foundation);
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit TextFieldCursorHandle$lambda$3$0;
                                TextFieldCursorHandle$lambda$3$0 = CoreTextFieldKt.TextFieldCursorHandle$lambda$3$0(m1661getCursorPositiontuRUvjQ$foundation, (SemanticsPropertyReceiver) obj);
                                return TextFieldCursorHandle$lambda$3$0;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    AndroidCursorHandle_androidKt.m1130CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue4, 1, null), 0L, startRestartGroup, 0, 4);
                }
                startRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CoreTextFieldKt.TextFieldCursorHandle$lambda$4(TextFieldSelectionManager.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit TextFieldCursorHandle$lambda$3$0(long j, SemanticsPropertyReceiver semanticsPropertyReceiver) {
            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, j, SelectionHandleAnchor.Middle, true, null));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
            Snapshot.Companion companion = Snapshot.Companion;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                TextInputSession inputSession = legacyTextFieldState.getInputSession();
                if (inputSession == null) {
                    return;
                }
                LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    return;
                }
                TextFieldDelegate.Companion.notifyFocusedRect$foundation(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
                Unit unit = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            }
        }

        private static final Modifier addContextMenuComponents(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope) {
            return ComposeFoundationFlags.isNewContextMenuEnabled ? TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents(modifier, textFieldSelectionManager, coroutineScope) : modifier;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean CoreTextField$lambda$14(State<Boolean> state) {
            return state.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DisposableEffectResult CoreTextField$lambda$21$0(final TextFieldSelectionManager textFieldSelectionManager, DisposableEffectScope disposableEffectScope) {
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$21$0$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation();
                }
            };
        }
    }
