package androidx.compose.foundation.text;

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
import androidx.compose.foundation.text.selection.OffsetProvider;
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
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
@Metadata(d1 = {"\u0000¢\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aú\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010*\u001a\u001d\u0010+\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010-\u001a\u0015\u0010.\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\u0010/\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u000202H\u0002\u001a \u00103\u001a\u00020\u00012\u0006\u00101\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00104\u001a\u000205H\u0002\u001a0\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0006\u00101\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00104\u001a\u000205H\u0002\u001a \u00109\u001a\u00020\u00012\u0006\u00101\u001a\u0002022\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0013H\u0000\u001a2\u0010=\u001a\u00020\u0001*\u00020>2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\r2\u0006\u00104\u001a\u000205H\u0080@¢\u0006\u0002\u0010B\u001a\u001c\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u00101\u001a\u0002022\u0006\u0010'\u001a\u00020(H\u0002¨\u0006D²\u0006\n\u0010E\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "textScrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/text/TextFieldScrollerPosition;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "endInputSession", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/text/LegacyTextFieldState;", "notifyFocusedRect", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewKeyEventToDeselectOnBack", "foundation_release", "writeable"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CoreTextFieldKt {
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0467, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L318;
     */
    /* JADX WARN: Code restructure failed: missing block: B:435:0x0a00, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L281;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x061c  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0711  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x07b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x07e7  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0851  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x087d  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0885  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0897  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x08fb  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x08fd  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x090a  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0940  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0942  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0953  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0955  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0962  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x09b3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:434:0x09f8  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0a03  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x0a2b  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0a2d  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0a33  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0a47  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0a76  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0a79  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0aa9  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0ae0  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0b2f  */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0b88  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0b9f  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0ba8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:491:0x0bf6  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0c19  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0c3e  */
    /* JADX WARN: Removed duplicated region for block: B:498:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, TextFieldScrollerPosition textFieldScrollerPosition, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        Modifier.Companion companion;
        int i8;
        Object obj;
        int i9;
        int i10;
        CoreTextFieldKt$CoreTextField$1 coreTextFieldKt$CoreTextField$1;
        int i11;
        Object obj2;
        int i12;
        SolidColor solidColor;
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
        int i27;
        final int i28;
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
        final int i29;
        final ImeOptions imeOptions2;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        MutableInteractionSource mutableInteractionSource3;
        ImeOptions imeOptions3;
        KeyboardActions keyboardActions3;
        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m1060getLambda1$foundation_release;
        TextFieldScrollerPosition textFieldScrollerPosition3;
        boolean z7;
        boolean z8;
        int i30;
        final Function1<? super TextLayoutResult, Unit> function14;
        boolean z9;
        VisualTransformation visualTransformation3;
        Modifier modifier3;
        ImeOptions imeOptions4;
        int i31;
        int i32;
        Brush brush3;
        MutableInteractionSource mutableInteractionSource4;
        LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter;
        TextFieldScrollerPosition textFieldScrollerPosition4;
        WindowInfo windowInfo;
        int i33;
        TransformedText transformedText;
        AnnotatedString annotatedString;
        TextStyle textStyle3;
        boolean z10;
        FontFamily.Resolver resolver;
        LegacyTextFieldState legacyTextFieldState;
        Object rememberedValue;
        FocusManager focusManager;
        Object rememberedValue2;
        Object rememberedValue3;
        Object rememberedValue4;
        int i34;
        int i35;
        final LegacyTextFieldState legacyTextFieldState2;
        boolean z11;
        boolean changedInstance;
        final LegacyTextFieldState legacyTextFieldState3;
        boolean z12;
        TextInputService textInputService;
        ImeOptions imeOptions5;
        final OffsetMapping offsetMapping;
        final TextFieldSelectionManager textFieldSelectionManager;
        BringIntoViewRequester bringIntoViewRequester;
        VisualTransformation visualTransformation4;
        String str;
        boolean z13;
        Function1 function15;
        ImeOptions imeOptions6;
        boolean z14;
        boolean z15;
        State state;
        final TextInputService textInputService2;
        ImeOptions imeOptions7;
        CoreTextFieldKt$CoreTextField$2$1 coreTextFieldKt$CoreTextField$2$1;
        final ImeOptions imeOptions8;
        boolean changedInstance2;
        Object rememberedValue5;
        boolean changedInstance3;
        FocusRequester focusRequester;
        boolean z16;
        Function1 function16;
        final boolean z17;
        boolean changedInstance4;
        final TextFieldValue textFieldValue2;
        Function1 function17;
        final WindowInfo windowInfo2;
        boolean changedInstance5;
        Object rememberedValue6;
        boolean z18;
        WindowInfo windowInfo3;
        final LegacyTextFieldState legacyTextFieldState4;
        boolean changedInstance6;
        Modifier modifier4;
        boolean changedInstance7;
        Object rememberedValue7;
        final boolean z19;
        boolean changed;
        Object rememberedValue8;
        boolean changedInstance8;
        Object rememberedValue9;
        final boolean z20;
        Modifier.Companion companion2;
        String str2;
        int i36;
        Composer startRestartGroup = composer.startRestartGroup(-244533042);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextField)P(15,10,8,14,16,9,4!1,12,6,7,3,5,2,11)205@11555L29,206@11625L58,207@11729L72,212@11859L7,213@11920L7,214@11988L7,215@12053L7,216@12098L7,217@12167L7,238@13009L277,250@13591L21,252@13637L451,281@14487L26,284@14580L24,285@14638L37,287@14695L51,293@14984L7,295@15079L7,296@15136L7,307@15466L1513,342@17086L42,343@17154L970,343@17133L991,369@18194L28,370@18290L991,399@19571L576,417@20218L1605,470@22434L48,470@22408L74,472@22517L502,472@22488L531,504@23693L987,521@24743L7,523@24812L151,554@26109L5402,554@26056L5455:CoreTextField.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i7 = i5 & 4;
            if (i7 == 0) {
                i6 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i6 |= startRestartGroup.changed(companion) ? 256 : 128;
                i8 = i5 & 8;
                if (i8 != 0) {
                    i6 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    obj = textStyle;
                    i6 |= startRestartGroup.changed(obj) ? 2048 : 1024;
                    i9 = i5 & 16;
                    if (i9 == 0) {
                        i6 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i6 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                        i10 = i5 & 32;
                        if (i10 != 0) {
                            i6 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            coreTextFieldKt$CoreTextField$1 = function12;
                        } else {
                            coreTextFieldKt$CoreTextField$1 = function12;
                            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i6 |= startRestartGroup.changedInstance(coreTextFieldKt$CoreTextField$1) ? 131072 : 65536;
                            }
                        }
                        i11 = i5 & 64;
                        if (i11 != 0) {
                            i6 |= 1572864;
                            obj2 = mutableInteractionSource;
                        } else {
                            obj2 = mutableInteractionSource;
                            if ((i3 & 1572864) == 0) {
                                i6 |= startRestartGroup.changed(obj2) ? 1048576 : 524288;
                            }
                        }
                        i12 = i5 & 128;
                        if (i12 != 0) {
                            i6 |= 12582912;
                            solidColor = brush;
                        } else {
                            solidColor = brush;
                            if ((i3 & 12582912) == 0) {
                                i6 |= startRestartGroup.changed(solidColor) ? 8388608 : 4194304;
                            }
                        }
                        i13 = i5 & 256;
                        if (i13 != 0) {
                            i6 |= 100663296;
                        } else if ((i3 & 100663296) == 0) {
                            i14 = i13;
                            i6 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                            i15 = i5 & 512;
                            if (i15 == 0) {
                                i6 |= 805306368;
                            } else if ((i3 & 805306368) == 0) {
                                i16 = i15;
                                i6 |= startRestartGroup.changed(i) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                i17 = i5 & 1024;
                                if (i17 != 0) {
                                    i19 = i4 | 6;
                                    i18 = i17;
                                } else if ((i4 & 6) == 0) {
                                    i18 = i17;
                                    i19 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                                } else {
                                    i18 = i17;
                                    i19 = i4;
                                }
                                if ((i4 & 48) == 0) {
                                    if ((i5 & 2048) == 0 && startRestartGroup.changed(imeOptions)) {
                                        i36 = 32;
                                        i19 |= i36;
                                    }
                                    i36 = 16;
                                    i19 |= i36;
                                }
                                int i37 = i19;
                                i20 = i5 & 4096;
                                if (i20 != 0) {
                                    i21 = i37 | RendererCapabilities.DECODER_SUPPORT_MASK;
                                } else if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                    i21 = i37 | (startRestartGroup.changed(keyboardActions) ? 256 : 128);
                                } else {
                                    i21 = i37;
                                }
                                i22 = i5 & 8192;
                                if (i22 != 0) {
                                    i23 = i21 | 3072;
                                } else {
                                    int i38 = i21;
                                    if ((i4 & 3072) == 0) {
                                        i23 = i38 | (startRestartGroup.changed(z2) ? 2048 : 1024);
                                    } else {
                                        i23 = i38;
                                    }
                                }
                                i24 = i5 & 16384;
                                if (i24 != 0) {
                                    i25 = i23 | 24576;
                                } else {
                                    i25 = i23;
                                    if ((i4 & 24576) == 0) {
                                        i25 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                                        i26 = i5 & 32768;
                                        if (i26 == 0) {
                                            i25 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                            i25 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                                        }
                                        i27 = i5 & 65536;
                                        if (i27 == 0) {
                                            i25 |= 1572864;
                                        } else if ((i4 & 1572864) == 0) {
                                            i25 |= startRestartGroup.changed(textFieldScrollerPosition) ? 1048576 : 524288;
                                        }
                                        if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 599187) != 599186, i6 & 1)) {
                                            startRestartGroup.startDefaults();
                                            ComposerKt.sourceInformation(startRestartGroup, "");
                                            if ((i3 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                                if (i7 != 0) {
                                                    companion = Modifier.Companion;
                                                }
                                                if (i8 != 0) {
                                                    obj = TextStyle.Companion.getDefault();
                                                }
                                                VisualTransformation none = i9 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                                if (i10 != 0) {
                                                    coreTextFieldKt$CoreTextField$1 = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1
                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                        public final void invoke2(TextLayoutResult textLayoutResult) {
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                                            invoke2(textLayoutResult);
                                                            return Unit.INSTANCE;
                                                        }
                                                    };
                                                }
                                                if (i11 != 0) {
                                                    obj2 = null;
                                                }
                                                if (i12 != 0) {
                                                    mutableInteractionSource3 = obj2;
                                                    solidColor = new SolidColor(Color.Companion.m4114getUnspecified0d7_KjU(), null);
                                                } else {
                                                    mutableInteractionSource3 = obj2;
                                                }
                                                boolean z21 = i14 != 0 ? true : z;
                                                int i39 = i16 != 0 ? Integer.MAX_VALUE : i;
                                                int i40 = i18 != 0 ? 1 : i2;
                                                if ((i5 & 2048) != 0) {
                                                    imeOptions3 = ImeOptions.Companion.getDefault();
                                                    i25 &= -113;
                                                } else {
                                                    imeOptions3 = imeOptions;
                                                }
                                                keyboardActions3 = i20 != 0 ? KeyboardActions.Companion.getDefault() : keyboardActions;
                                                boolean z22 = i22 != 0 ? true : z2;
                                                boolean z23 = i24 != 0 ? false : z3;
                                                m1060getLambda1$foundation_release = i26 != 0 ? ComposableSingletons$CoreTextFieldKt.INSTANCE.m1060getLambda1$foundation_release() : function3;
                                                textFieldScrollerPosition3 = i27 != 0 ? null : textFieldScrollerPosition;
                                                z7 = z22;
                                                z8 = z23;
                                                i30 = i25;
                                                function14 = coreTextFieldKt$CoreTextField$1;
                                                z9 = z21;
                                                visualTransformation3 = none;
                                                modifier3 = companion;
                                                imeOptions4 = imeOptions3;
                                                i31 = i40;
                                                i32 = i39;
                                                brush3 = solidColor;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i5 & 2048) != 0) {
                                                    i25 &= -113;
                                                }
                                                MutableInteractionSource mutableInteractionSource5 = obj2;
                                                brush3 = solidColor;
                                                mutableInteractionSource4 = mutableInteractionSource5;
                                                visualTransformation3 = visualTransformation;
                                                i32 = i;
                                                i31 = i2;
                                                keyboardActions3 = keyboardActions;
                                                z7 = z2;
                                                z8 = z3;
                                                m1060getLambda1$foundation_release = function3;
                                                textFieldScrollerPosition3 = textFieldScrollerPosition;
                                                function14 = coreTextFieldKt$CoreTextField$1;
                                                modifier3 = companion;
                                                i30 = i25;
                                                z9 = z;
                                                imeOptions4 = imeOptions;
                                            }
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-244533042, i6, i30, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:204)");
                                            }
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705381372, "CC(remember):CoreTextField.kt#9igjgp");
                                            Object rememberedValue10 = startRestartGroup.rememberedValue();
                                            int i41 = i6;
                                            if (rememberedValue10 == Composer.Companion.getEmpty()) {
                                                rememberedValue10 = new FocusRequester();
                                                startRestartGroup.updateRememberedValue(rememberedValue10);
                                            }
                                            final FocusRequester focusRequester2 = (FocusRequester) rememberedValue10;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705379103, "CC(remember):CoreTextField.kt#9igjgp");
                                            Object rememberedValue11 = startRestartGroup.rememberedValue();
                                            Brush brush4 = brush3;
                                            if (rememberedValue11 == Composer.Companion.getEmpty()) {
                                                rememberedValue11 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                                                startRestartGroup.updateRememberedValue(rememberedValue11);
                                            }
                                            LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter2 = (LegacyPlatformTextInputServiceAdapter) rememberedValue11;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705375761, "CC(remember):CoreTextField.kt#9igjgp");
                                            Object rememberedValue12 = startRestartGroup.rememberedValue();
                                            boolean z24 = z9;
                                            if (rememberedValue12 == Composer.Companion.getEmpty()) {
                                                rememberedValue12 = new TextInputService(legacyPlatformTextInputServiceAdapter2);
                                                startRestartGroup.updateRememberedValue(rememberedValue12);
                                            }
                                            final TextInputService textInputService3 = (TextInputService) rememberedValue12;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            TextStyle textStyle4 = obj;
                                            final int i42 = i31;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Density density = (Density) consume;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            FontFamily.Resolver resolver2 = (FontFamily.Resolver) consume2;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume3 = startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            long m1533getBackgroundColor0d7_KjU = ((TextSelectionColors) consume3).m1533getBackgroundColor0d7_KjU();
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
                                            final Orientation orientation = (i32 == 1 && !z24 && imeOptions4.getSingleLine()) ? Orientation.Horizontal : Orientation.Vertical;
                                            Modifier modifier5 = modifier3;
                                            if (textFieldScrollerPosition3 != null) {
                                                legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter2;
                                                startRestartGroup.startReplaceGroup(-1705354472);
                                                startRestartGroup.endReplaceGroup();
                                                textFieldScrollerPosition4 = textFieldScrollerPosition3;
                                            } else {
                                                startRestartGroup.startReplaceGroup(-1705353356);
                                                ComposerKt.sourceInformation(startRestartGroup, "224@12498L70,224@12427L141");
                                                Object[] objArr = {orientation};
                                                Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.Companion.getSaver();
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705351155, "CC(remember):CoreTextField.kt#9igjgp");
                                                boolean changed2 = startRestartGroup.changed(orientation);
                                                Object rememberedValue13 = startRestartGroup.rememberedValue();
                                                if (changed2) {
                                                    legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter2;
                                                } else {
                                                    legacyPlatformTextInputServiceAdapter = legacyPlatformTextInputServiceAdapter2;
                                                }
                                                rememberedValue13 = (Function0) new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final TextFieldScrollerPosition invoke() {
                                                        return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue13);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                textFieldScrollerPosition4 = (TextFieldScrollerPosition) RememberSaveableKt.m3635rememberSaveable(objArr, saver, (String) null, (Function0<? extends Object>) rememberedValue13, startRestartGroup, 0, 4);
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
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705334596, "CC(remember):CoreTextField.kt#9igjgp");
                                            int i43 = i41 & 14;
                                            int i44 = i41 & 57344;
                                            final TextFieldScrollerPosition textFieldScrollerPosition5 = textFieldScrollerPosition4;
                                            boolean z25 = (i43 == 4) | (i44 == 16384);
                                            TransformedText rememberedValue14 = startRestartGroup.rememberedValue();
                                            if (z25 || rememberedValue14 == Composer.Companion.getEmpty()) {
                                                TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation3, textFieldValue.getAnnotatedString());
                                                TextRange m6395getCompositionMzsxiRA = textFieldValue.m6395getCompositionMzsxiRA();
                                                if (m6395getCompositionMzsxiRA != null) {
                                                    i33 = i32;
                                                    windowInfo = windowInfo4;
                                                    TransformedText m1154applyCompositionDecoration72CqOWE = TextFieldDelegate.Companion.m1154applyCompositionDecoration72CqOWE(m6395getCompositionMzsxiRA.m6151unboximpl(), filterWithValidation);
                                                    if (m1154applyCompositionDecoration72CqOWE != null) {
                                                        rememberedValue14 = m1154applyCompositionDecoration72CqOWE;
                                                        startRestartGroup.updateRememberedValue(rememberedValue14);
                                                    }
                                                } else {
                                                    windowInfo = windowInfo4;
                                                    i33 = i32;
                                                }
                                                rememberedValue14 = filterWithValidation;
                                                startRestartGroup.updateRememberedValue(rememberedValue14);
                                            } else {
                                                windowInfo = windowInfo4;
                                                i33 = i32;
                                            }
                                            TransformedText transformedText2 = (TransformedText) rememberedValue14;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            AnnotatedString text = transformedText2.getText();
                                            final OffsetMapping offsetMapping2 = transformedText2.getOffsetMapping();
                                            RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705314326, "CC(remember):CoreTextField.kt#9igjgp");
                                            boolean changed3 = startRestartGroup.changed(softwareKeyboardController);
                                            Object rememberedValue15 = startRestartGroup.rememberedValue();
                                            if (changed3) {
                                                transformedText = transformedText2;
                                            } else {
                                                transformedText = transformedText2;
                                                if (rememberedValue15 != Composer.Companion.getEmpty()) {
                                                    annotatedString = text;
                                                    z10 = z24;
                                                    textStyle3 = textStyle4;
                                                    resolver = resolver2;
                                                    legacyTextFieldState = (LegacyTextFieldState) rememberedValue15;
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    final Density density2 = density;
                                                    legacyTextFieldState.m1091updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle3, z10, density2, resolver, function1, keyboardActions4, focusManager2, m1533getBackgroundColor0d7_KjU);
                                                    legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705287551, "CC(remember):CoreTextField.kt#9igjgp");
                                                    rememberedValue = startRestartGroup.rememberedValue();
                                                    if (rememberedValue != Composer.Companion.getEmpty()) {
                                                        focusManager = focusManager2;
                                                        rememberedValue = new UndoManager(0, 1, null);
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    } else {
                                                        focusManager = focusManager2;
                                                    }
                                                    UndoManager undoManager = (UndoManager) rememberedValue;
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
                                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                                        rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                                    }
                                                    final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705282708, "CC(remember):CoreTextField.kt#9igjgp");
                                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                                        rememberedValue3 = BringIntoViewRequesterKt.BringIntoViewRequester();
                                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                                    }
                                                    final BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) rememberedValue3;
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705280870, "CC(remember):CoreTextField.kt#9igjgp");
                                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                                        rememberedValue4 = new TextFieldSelectionManager(undoManager);
                                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                                    }
                                                    final TextFieldSelectionManager textFieldSelectionManager2 = (TextFieldSelectionManager) rememberedValue4;
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textFieldSelectionManager2.setOffsetMapping$foundation_release(offsetMapping2);
                                                    textFieldSelectionManager2.setVisualTransformation$foundation_release(visualTransformation3);
                                                    textFieldSelectionManager2.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
                                                    textFieldSelectionManager2.setState$foundation_release(legacyTextFieldState);
                                                    textFieldSelectionManager2.setValue$foundation_release(textFieldValue);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                    Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalClipboard());
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textFieldSelectionManager2.setClipboard$foundation_release((Clipboard) consume7);
                                                    textFieldSelectionManager2.setCoroutineScope$foundation_release(coroutineScope);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                    Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textFieldSelectionManager2.setTextToolbar((TextToolbar) consume8);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                    Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textFieldSelectionManager2.setHapticFeedBack((HapticFeedback) consume9);
                                                    textFieldSelectionManager2.setFocusRequester(focusRequester2);
                                                    textFieldSelectionManager2.setEditable(!z8);
                                                    final boolean z26 = z7;
                                                    textFieldSelectionManager2.setEnabled(z26);
                                                    Modifier.Companion companion3 = Modifier.Companion;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705254736, "CC(remember):CoreTextField.kt#9igjgp");
                                                    int i45 = i30 & 7168;
                                                    int i46 = i30 & 57344;
                                                    i34 = i30;
                                                    boolean changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | (i45 != 2048) | (i46 != 16384) | startRestartGroup.changedInstance(textInputService3) | (i43 != 4);
                                                    i35 = (i34 & 112) ^ 48;
                                                    if (i35 > 32 || !startRestartGroup.changed(imeOptions4)) {
                                                        legacyTextFieldState2 = legacyTextFieldState;
                                                        if ((i34 & 48) != 32) {
                                                            z11 = false;
                                                            changedInstance = changedInstance9 | z11 | startRestartGroup.changedInstance(offsetMapping2) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(bringIntoViewRequester2) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                            Object rememberedValue16 = startRestartGroup.rememberedValue();
                                                            if (!changedInstance || rememberedValue16 == Composer.Companion.getEmpty()) {
                                                                final ImeOptions imeOptions9 = imeOptions4;
                                                                final boolean z27 = z8;
                                                                Function1 function18 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                                                        invoke2(focusState);
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                    public final void invoke2(FocusState focusState) {
                                                                        TextLayoutResultProxy layoutResult;
                                                                        if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                                                            return;
                                                                        }
                                                                        LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                                                                        if (!LegacyTextFieldState.this.getHasFocus() || !z26 || z27) {
                                                                            CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                                                                        } else {
                                                                            CoreTextFieldKt.startInputSession(textInputService3, LegacyTextFieldState.this, textFieldValue, imeOptions9, offsetMapping2);
                                                                        }
                                                                        if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester2, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping2, null), 3, null);
                                                                        }
                                                                        if (focusState.isFocused()) {
                                                                            return;
                                                                        }
                                                                        TextFieldSelectionManager.m1519deselect_kEHs6E$foundation_release$default(textFieldSelectionManager2, null, 1, null);
                                                                    }
                                                                };
                                                                legacyTextFieldState3 = legacyTextFieldState2;
                                                                z12 = z27;
                                                                textInputService = textInputService3;
                                                                imeOptions5 = imeOptions9;
                                                                offsetMapping = offsetMapping2;
                                                                textFieldSelectionManager = textFieldSelectionManager2;
                                                                bringIntoViewRequester = bringIntoViewRequester2;
                                                                visualTransformation4 = visualTransformation3;
                                                                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                                                z13 = z26;
                                                                function15 = function18;
                                                                startRestartGroup.updateRememberedValue(function15);
                                                            } else {
                                                                textInputService = textInputService3;
                                                                visualTransformation4 = visualTransformation3;
                                                                offsetMapping = offsetMapping2;
                                                                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                                                imeOptions5 = imeOptions4;
                                                                z12 = z8;
                                                                z13 = z26;
                                                                textFieldSelectionManager = textFieldSelectionManager2;
                                                                function15 = rememberedValue16;
                                                                bringIntoViewRequester = bringIntoViewRequester2;
                                                                legacyTextFieldState3 = legacyTextFieldState2;
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            Modifier textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion3, z13, focusRequester2, mutableInteractionSource6, function15);
                                                            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z13 || z12) ? false : true), startRestartGroup, 0);
                                                            Unit unit = Unit.INSTANCE;
                                                            final boolean z28 = z13;
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705201263, "CC(remember):CoreTextField.kt#9igjgp");
                                                            boolean changed4 = startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                                            TextInputService textInputService4 = textInputService;
                                                            if (i35 > 32 || !startRestartGroup.changed(imeOptions5)) {
                                                                imeOptions6 = imeOptions5;
                                                                if ((i34 & 48) != 32) {
                                                                    z14 = false;
                                                                    z15 = z14 | changed4;
                                                                    Object rememberedValue17 = startRestartGroup.rememberedValue();
                                                                    if (!z15 || rememberedValue17 == Composer.Companion.getEmpty()) {
                                                                        ImeOptions imeOptions10 = imeOptions6;
                                                                        state = rememberUpdatedState;
                                                                        textInputService2 = textInputService4;
                                                                        imeOptions7 = imeOptions10;
                                                                        coreTextFieldKt$CoreTextField$2$1 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState3, rememberUpdatedState, textInputService4, textFieldSelectionManager, imeOptions10, null);
                                                                        startRestartGroup.updateRememberedValue(coreTextFieldKt$CoreTextField$2$1);
                                                                    } else {
                                                                        textInputService2 = textInputService4;
                                                                        state = rememberUpdatedState;
                                                                        coreTextFieldKt$CoreTextField$2$1 = rememberedValue17;
                                                                        imeOptions7 = imeOptions6;
                                                                    }
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    imeOptions8 = imeOptions7;
                                                                    EffectsKt.LaunchedEffect(unit, coreTextFieldKt$CoreTextField$2$1, startRestartGroup, 6);
                                                                    Modifier.Companion companion4 = Modifier.Companion;
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705168925, "CC(remember):CoreTextField.kt#9igjgp");
                                                                    changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState3);
                                                                    rememberedValue5 = startRestartGroup.rememberedValue();
                                                                    if (!changedInstance2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                                                        rememberedValue5 = (Function1) new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                                                invoke(bool.booleanValue());
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            public final void invoke(boolean z29) {
                                                                                LegacyTextFieldState.this.setInTouchMode(z29);
                                                                            }
                                                                        };
                                                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                                                    }
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    Modifier updateSelectionTouchMode = SelectionGesturesKt.updateSelectionTouchMode(companion4, (Function1) rememberedValue5);
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705164890, "CC(remember):CoreTextField.kt#9igjgp");
                                                                    changedInstance3 = (i46 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState3) | (i45 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                                                    Object rememberedValue18 = startRestartGroup.rememberedValue();
                                                                    if (!changedInstance3 || rememberedValue18 == Composer.Companion.getEmpty()) {
                                                                        final OffsetMapping offsetMapping3 = offsetMapping;
                                                                        final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState3;
                                                                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager;
                                                                        final boolean z29 = z12;
                                                                        focusRequester = focusRequester2;
                                                                        z16 = z28;
                                                                        function16 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                                                m1061invokek4lQ0M(offset.m3847unboximpl());
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                                                                            public final void m1061invokek4lQ0M(long j) {
                                                                                CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z29);
                                                                                if (LegacyTextFieldState.this.getHasFocus() && z28) {
                                                                                    if (LegacyTextFieldState.this.getHandleState() != HandleState.Selection) {
                                                                                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                                        if (layoutResult != null) {
                                                                                            LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                                                            TextFieldDelegate.Companion.m1157setCursorOffsetULxng0E$foundation_release(j, layoutResult, legacyTextFieldState6.getProcessor(), offsetMapping3, legacyTextFieldState6.getOnValueChange());
                                                                                            if (legacyTextFieldState6.getTextDelegate().getText().length() > 0) {
                                                                                                legacyTextFieldState6.setHandleState(HandleState.Cursor);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    textFieldSelectionManager3.m1522deselect_kEHs6E$foundation_release(Offset.m3826boximpl(j));
                                                                                }
                                                                            }
                                                                        };
                                                                        startRestartGroup.updateRememberedValue(function16);
                                                                    } else {
                                                                        focusRequester = focusRequester2;
                                                                        function16 = rememberedValue18;
                                                                        z16 = z28;
                                                                    }
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    FocusRequester focusRequester3 = focusRequester;
                                                                    z17 = z16;
                                                                    State state2 = state;
                                                                    Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode, mutableInteractionSource6, z16, function16), textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), textFieldSelectionManager.getTouchSelectionObserver$foundation_release()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                                                    Modifier.Companion companion5 = Modifier.Companion;
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705124313, "CC(remember):CoreTextField.kt#9igjgp");
                                                                    changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState3) | (i43 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                                    Object rememberedValue19 = startRestartGroup.rememberedValue();
                                                                    if (!changedInstance4 || rememberedValue19 == Composer.Companion.getEmpty()) {
                                                                        textFieldValue2 = textFieldValue;
                                                                        function17 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                                                invoke2(drawScope);
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                            public final void invoke2(DrawScope drawScope) {
                                                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                                if (layoutResult != null) {
                                                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                                                    LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                                                    OffsetMapping offsetMapping4 = offsetMapping;
                                                                                    TextFieldDelegate.Companion.m1155drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue3, legacyTextFieldState6.m1086getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState6.m1083getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping4, layoutResult.getValue(), legacyTextFieldState6.getHighlightPaint(), legacyTextFieldState6.m1085getSelectionBackgroundColor0d7_KjU());
                                                                                }
                                                                            }
                                                                        };
                                                                        startRestartGroup.updateRememberedValue(function17);
                                                                    } else {
                                                                        function17 = rememberedValue19;
                                                                        textFieldValue2 = textFieldValue;
                                                                    }
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    final Modifier drawBehind = DrawModifierKt.drawBehind(companion5, function17);
                                                                    Modifier.Companion companion6 = Modifier.Companion;
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705102580, "CC(remember):CoreTextField.kt#9igjgp");
                                                                    windowInfo2 = windowInfo;
                                                                    changedInstance5 = (i45 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changed(windowInfo2) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i43 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                                    rememberedValue6 = startRestartGroup.rememberedValue();
                                                                    if (!changedInstance5 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                                                        final OffsetMapping offsetMapping4 = offsetMapping;
                                                                        final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState3;
                                                                        final TextFieldValue textFieldValue3 = textFieldValue2;
                                                                        final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager;
                                                                        z18 = z17;
                                                                        windowInfo3 = windowInfo2;
                                                                        rememberedValue6 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                                                invoke2(layoutCoordinates);
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                                                LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                                if (layoutResult != null) {
                                                                                    layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                                                }
                                                                                if (z17) {
                                                                                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                                                        if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo2.isWindowFocused()) {
                                                                                            textFieldSelectionManager4.showSelectionToolbar$foundation_release();
                                                                                        } else {
                                                                                            textFieldSelectionManager4.hideSelectionToolbar$foundation_release();
                                                                                        }
                                                                                        LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager4, true));
                                                                                        LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager4, false));
                                                                                        LegacyTextFieldState.this.setShowCursorHandle(TextRange.m6141getCollapsedimpl(textFieldValue3.m6396getSelectiond9O1mEE()));
                                                                                    } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                                                        LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager4, true));
                                                                                    }
                                                                                    CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue3, offsetMapping4);
                                                                                    TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                                                                    if (layoutResult2 != null) {
                                                                                        LegacyTextFieldState legacyTextFieldState7 = LegacyTextFieldState.this;
                                                                                        TextFieldValue textFieldValue4 = textFieldValue3;
                                                                                        OffsetMapping offsetMapping5 = offsetMapping4;
                                                                                        TextInputSession inputSession = legacyTextFieldState7.getInputSession();
                                                                                        if (inputSession == null || !legacyTextFieldState7.getHasFocus()) {
                                                                                            return;
                                                                                        }
                                                                                        TextFieldDelegate.Companion.updateTextLayoutResult$foundation_release(inputSession, textFieldValue4, offsetMapping5, layoutResult2);
                                                                                    }
                                                                                }
                                                                            }
                                                                        };
                                                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                                                    } else {
                                                                        z18 = z17;
                                                                        windowInfo3 = windowInfo2;
                                                                    }
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    final Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion6, (Function1) rememberedValue6);
                                                                    final VisualTransformation visualTransformation5 = visualTransformation4;
                                                                    CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState3, z12, z18, visualTransformation5 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager, imeOptions8, focusRequester3);
                                                                    final OffsetMapping offsetMapping5 = offsetMapping;
                                                                    legacyTextFieldState4 = legacyTextFieldState3;
                                                                    Modifier cursor = TextFieldCursorKt.cursor(Modifier.Companion, legacyTextFieldState4, textFieldValue, offsetMapping5, brush4, (z18 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState3.hasHighlight()) ? false : true);
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705033225, "CC(remember):CoreTextField.kt#9igjgp");
                                                                    changedInstance6 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                                                    Object rememberedValue20 = startRestartGroup.rememberedValue();
                                                                    if (changedInstance6) {
                                                                        modifier4 = cursor;
                                                                    } else {
                                                                        modifier4 = cursor;
                                                                    }
                                                                    rememberedValue20 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                            final TextFieldSelectionManager textFieldSelectionManager5 = TextFieldSelectionManager.this;
                                                                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                                                public void dispose() {
                                                                                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                                                                }
                                                                            };
                                                                        }
                                                                    };
                                                                    startRestartGroup.updateRememberedValue(rememberedValue20);
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1) rememberedValue20, startRestartGroup, 0);
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705030115, "CC(remember):CoreTextField.kt#9igjgp");
                                                                    changedInstance7 = ((i35 <= 32 && startRestartGroup.changed(imeOptions8)) || (i34 & 48) == 32) | startRestartGroup.changedInstance(legacyTextFieldState4) | startRestartGroup.changedInstance(textInputService2) | (i43 != 4);
                                                                    rememberedValue7 = startRestartGroup.rememberedValue();
                                                                    if (!changedInstance7 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                                                        rememberedValue7 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                                if (LegacyTextFieldState.this.getHasFocus()) {
                                                                                    LegacyTextFieldState.this.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(textInputService2, textFieldValue, LegacyTextFieldState.this.getProcessor(), imeOptions8, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                                                                }
                                                                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                                                    public void dispose() {
                                                                                    }
                                                                                };
                                                                            }
                                                                        };
                                                                        startRestartGroup.updateRememberedValue(rememberedValue7);
                                                                    }
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    EffectsKt.DisposableEffect(imeOptions8, (Function1) rememberedValue7, startRestartGroup, (i34 >> 3) & 14);
                                                                    final int i47 = i33;
                                                                    Modifier m1164textFieldKeyInput2WJ9YEU = TextFieldKeyInputKt.m1164textFieldKeyInput2WJ9YEU(Modifier.Companion, legacyTextFieldState4, textFieldSelectionManager, textFieldValue, legacyTextFieldState4.getOnValueChange(), !z12, i47 != 1, offsetMapping5, undoManager, imeOptions8.m6343getImeActioneUduSuo());
                                                                    z19 = KeyboardType.m6367equalsimpl0(imeOptions8.m6344getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6386getPasswordPjHm6EE()) && !KeyboardType.m6367equalsimpl0(imeOptions8.m6344getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6385getNumberPasswordPjHm6EE());
                                                                    Modifier.Companion companion7 = Modifier.Companion;
                                                                    boolean CoreTextField$lambda$11 = CoreTextField$lambda$11(state2);
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1704991998, "CC(remember):CoreTextField.kt#9igjgp");
                                                                    final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter3 = legacyPlatformTextInputServiceAdapter;
                                                                    changed = startRestartGroup.changed(z19) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter3);
                                                                    rememberedValue8 = startRestartGroup.rememberedValue();
                                                                    if (!changed || rememberedValue8 == Composer.Companion.getEmpty()) {
                                                                        rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
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
                                                                                if (z19) {
                                                                                    legacyPlatformTextInputServiceAdapter3.startStylusHandwriting();
                                                                                }
                                                                            }
                                                                        };
                                                                        startRestartGroup.updateRememberedValue(rememberedValue8);
                                                                    }
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    Modifier stylusHandwriting = StylusHandwritingKt.stylusHandwriting(companion7, CoreTextField$lambda$11, z19, (Function0) rememberedValue8);
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
                                                                    Object consume10 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightColor());
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    final long m4088unboximpl = ((Color) consume10).m4088unboximpl();
                                                                    Modifier.Companion companion8 = Modifier.Companion;
                                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1704957026, "CC(remember):CoreTextField.kt#9igjgp");
                                                                    changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState4) | startRestartGroup.changed(m4088unboximpl);
                                                                    rememberedValue9 = startRestartGroup.rememberedValue();
                                                                    if (!changedInstance8 || rememberedValue9 == Composer.Companion.getEmpty()) {
                                                                        rememberedValue9 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawDecorationModifier$1$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                                                invoke2(drawScope);
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                            public final void invoke2(DrawScope drawScope) {
                                                                                if (LegacyTextFieldState.this.getAutofillHighlightOn() || LegacyTextFieldState.this.getJustAutofilled()) {
                                                                                    DrawScope.m4634drawRectnJ9OG0$default(drawScope, m4088unboximpl, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
                                                                                }
                                                                            }
                                                                        };
                                                                        startRestartGroup.updateRememberedValue(rememberedValue9);
                                                                    }
                                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                                    Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(DrawModifierKt.drawBehind(companion8, (Function1) rememberedValue9)), legacyPlatformTextInputServiceAdapter3, legacyTextFieldState4, textFieldSelectionManager).then(stylusHandwriting).then(textFieldFocusModifier), legacyTextFieldState4, focusManager), legacyTextFieldState4, textFieldSelectionManager).then(m1164textFieldKeyInput2WJ9YEU), textFieldScrollerPosition5, mutableInteractionSource6, z18).then(pointerHoverIcon$default).then(coreTextFieldSemanticsModifier), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                                            invoke2(layoutCoordinates);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                            if (layoutResult == null) {
                                                                                return;
                                                                            }
                                                                            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                                        }
                                                                    });
                                                                    z20 = !z18 && legacyTextFieldState4.getHasFocus() && legacyTextFieldState4.isInTouchMode() && windowInfo3.isWindowFocused();
                                                                    if (!z20) {
                                                                        companion2 = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.Companion, textFieldSelectionManager);
                                                                    } else {
                                                                        companion2 = Modifier.Companion;
                                                                    }
                                                                    final Modifier modifier6 = modifier4;
                                                                    boolean z30 = z18;
                                                                    final BringIntoViewRequester bringIntoViewRequester3 = bringIntoViewRequester;
                                                                    final boolean z31 = z12;
                                                                    final TextStyle textStyle5 = textStyle3;
                                                                    final Modifier modifier7 = companion2;
                                                                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = m1060getLambda1$foundation_release;
                                                                    CoreTextFieldRootBox(onGloballyPositioned2, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-492537660, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(2);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                                            invoke(composer3, num.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(Composer composer3, int i48) {
                                                                            ComposerKt.sourceInformation(composer3, "C555@26133L5372,555@26119L5386:CoreTextField.kt#423gt5");
                                                                            if (!composer3.shouldExecute((i48 & 3) != 2, i48 & 1)) {
                                                                                composer3.skipToGroupEnd();
                                                                                return;
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-492537660, i48, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:555)");
                                                                            }
                                                                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function34 = function33;
                                                                            final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState4;
                                                                            final TextStyle textStyle6 = textStyle5;
                                                                            final int i49 = i42;
                                                                            final int i50 = i47;
                                                                            final TextFieldScrollerPosition textFieldScrollerPosition6 = textFieldScrollerPosition5;
                                                                            final TextFieldValue textFieldValue4 = textFieldValue;
                                                                            final VisualTransformation visualTransformation6 = visualTransformation5;
                                                                            final Modifier modifier8 = modifier6;
                                                                            final Modifier modifier9 = drawBehind;
                                                                            final Modifier modifier10 = onGloballyPositioned;
                                                                            final Modifier modifier11 = modifier7;
                                                                            final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester3;
                                                                            final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                                            final boolean z32 = z20;
                                                                            final boolean z33 = z31;
                                                                            final Function1<TextLayoutResult, Unit> function19 = function14;
                                                                            final OffsetMapping offsetMapping6 = offsetMapping5;
                                                                            final Density density3 = density2;
                                                                            function34.invoke(ComposableLambdaKt.rememberComposableLambda(-1835647873, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                                {
                                                                                    super(2);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                                    invoke(composer4, num.intValue());
                                                                                    return Unit.INSTANCE;
                                                                                }

                                                                                public final void invoke(Composer composer4, int i51) {
                                                                                    ComposerKt.sourceInformation(composer4, "C569@26984L22,578@27371L4124,578@27335L4160:CoreTextField.kt#423gt5");
                                                                                    if (composer4.shouldExecute((i51 & 3) != 2, i51 & 1)) {
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(-1835647873, i51, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:558)");
                                                                                        }
                                                                                        Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m773heightInVpY3zN4$default(Modifier.Companion, LegacyTextFieldState.this.m1084getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i49, i50);
                                                                                        TextFieldScrollerPosition textFieldScrollerPosition7 = textFieldScrollerPosition6;
                                                                                        TextFieldValue textFieldValue5 = textFieldValue4;
                                                                                        VisualTransformation visualTransformation7 = visualTransformation6;
                                                                                        ComposerKt.sourceInformationMarkerStart(composer4, 713003803, "CC(remember):CoreTextField.kt#9igjgp");
                                                                                        boolean changedInstance10 = composer4.changedInstance(LegacyTextFieldState.this);
                                                                                        final LegacyTextFieldState legacyTextFieldState8 = LegacyTextFieldState.this;
                                                                                        Object rememberedValue21 = composer4.rememberedValue();
                                                                                        if (changedInstance10 || rememberedValue21 == Composer.Companion.getEmpty()) {
                                                                                            rememberedValue21 = (Function0) new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final TextLayoutResultProxy invoke() {
                                                                                                    return LegacyTextFieldState.this.getLayoutResult();
                                                                                                }
                                                                                            };
                                                                                            composer4.updateRememberedValue(rememberedValue21);
                                                                                        }
                                                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                                        Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(heightInLines, textFieldScrollerPosition7, textFieldValue5, visualTransformation7, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester4);
                                                                                        final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager5;
                                                                                        final LegacyTextFieldState legacyTextFieldState9 = LegacyTextFieldState.this;
                                                                                        final boolean z34 = z32;
                                                                                        final boolean z35 = z33;
                                                                                        final Function1<TextLayoutResult, Unit> function110 = function19;
                                                                                        final TextFieldValue textFieldValue6 = textFieldValue4;
                                                                                        final OffsetMapping offsetMapping7 = offsetMapping6;
                                                                                        final Density density4 = density3;
                                                                                        final int i52 = i50;
                                                                                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.rememberComposableLambda(-1172467467, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                                            {
                                                                                                super(2);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function2
                                                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                                                invoke(composer5, num.intValue());
                                                                                                return Unit.INSTANCE;
                                                                                            }

                                                                                            /* JADX WARN: Code restructure failed: missing block: B:30:0x00fa, code lost:
                                                                                                if (r3 != false) goto L27;
                                                                                             */
                                                                                            /*
                                                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                                                            */
                                                                                            public final void invoke(Composer composer5, int i53) {
                                                                                                ComposerKt.sourceInformation(composer5, "C579@27389L3496,644@30903L358:CoreTextField.kt#423gt5");
                                                                                                boolean z36 = true;
                                                                                                if (!composer5.shouldExecute((i53 & 3) != 2, i53 & 1)) {
                                                                                                    composer5.skipToGroupEnd();
                                                                                                    return;
                                                                                                }
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventStart(-1172467467, i53, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:579)");
                                                                                                }
                                                                                                final LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState9;
                                                                                                final Function1<TextLayoutResult, Unit> function111 = function110;
                                                                                                final TextFieldValue textFieldValue7 = textFieldValue6;
                                                                                                final OffsetMapping offsetMapping8 = offsetMapping7;
                                                                                                final Density density5 = density4;
                                                                                                final int i54 = i52;
                                                                                                MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                                                    /* renamed from: measure-3p2s80s */
                                                                                                    public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                                                                        Snapshot.Companion companion9 = Snapshot.Companion;
                                                                                                        LegacyTextFieldState legacyTextFieldState11 = LegacyTextFieldState.this;
                                                                                                        Snapshot currentThreadSnapshot = companion9.getCurrentThreadSnapshot();
                                                                                                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                                                        Snapshot makeCurrentNonObservable = companion9.makeCurrentNonObservable(currentThreadSnapshot);
                                                                                                        try {
                                                                                                            TextLayoutResultProxy layoutResult = legacyTextFieldState11.getLayoutResult();
                                                                                                            TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                                            Triple<Integer, Integer, TextLayoutResult> m1156layout_EkL_Y$foundation_release = TextFieldDelegate.Companion.m1156layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                                                            int intValue = m1156layout_EkL_Y$foundation_release.component1().intValue();
                                                                                                            int intValue2 = m1156layout_EkL_Y$foundation_release.component2().intValue();
                                                                                                            TextLayoutResult component3 = m1156layout_EkL_Y$foundation_release.component3();
                                                                                                            if (!Intrinsics.areEqual(value, component3)) {
                                                                                                                LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                                                function111.invoke(component3);
                                                                                                                CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue7, offsetMapping8);
                                                                                                            }
                                                                                                            LegacyTextFieldState.this.m1088setMinHeightForSingleLineField0680j_4(density5.mo386toDpu2uoSUM(i54 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                                                            return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                                                }

                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                                                    invoke2(placementScope);
                                                                                                                    return Unit.INSTANCE;
                                                                                                                }
                                                                                                            });
                                                                                                        } finally {
                                                                                                            companion9.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                                                                        }
                                                                                                    }

                                                                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                                                    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i55) {
                                                                                                        LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                                                        return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                                                    }
                                                                                                };
                                                                                                ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, Modifier.Companion);
                                                                                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                                                                ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                                                                    ComposablesKt.invalidApplier();
                                                                                                }
                                                                                                composer5.startReusableNode();
                                                                                                if (composer5.getInserting()) {
                                                                                                    composer5.createNode(constructor);
                                                                                                } else {
                                                                                                    composer5.useNode();
                                                                                                }
                                                                                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                                                                                Updater.m3527setimpl(m3520constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                                                }
                                                                                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                                                                ComposerKt.sourceInformationMarkerStart(composer5, -1679992992, "C:CoreTextField.kt#423gt5");
                                                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                                composer5.endNode();
                                                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                                TextFieldSelectionManager textFieldSelectionManager7 = TextFieldSelectionManager.this;
                                                                                                if (legacyTextFieldState9.getHandleState() != HandleState.None && legacyTextFieldState9.getLayoutCoordinates() != null) {
                                                                                                    LayoutCoordinates layoutCoordinates = legacyTextFieldState9.getLayoutCoordinates();
                                                                                                    Intrinsics.checkNotNull(layoutCoordinates);
                                                                                                    if (layoutCoordinates.isAttached()) {
                                                                                                    }
                                                                                                }
                                                                                                z36 = false;
                                                                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager7, z36, composer5, 0);
                                                                                                if (legacyTextFieldState9.getHandleState() == HandleState.Cursor && !z35 && z34) {
                                                                                                    composer5.startReplaceGroup(-7167858);
                                                                                                    ComposerKt.sourceInformation(composer5, "656@31423L40");
                                                                                                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                                                    composer5.endReplaceGroup();
                                                                                                } else {
                                                                                                    composer5.startReplaceGroup(-7090978);
                                                                                                    composer5.endReplaceGroup();
                                                                                                }
                                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                                    ComposerKt.traceEventEnd();
                                                                                                }
                                                                                            }
                                                                                        }, composer4, 54), composer4, 48, 0);
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    composer4.skipToGroupEnd();
                                                                                }
                                                                            }, composer3, 54), composer3, 6);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                    }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                    function32 = function33;
                                                                    i28 = i42;
                                                                    composer2 = startRestartGroup;
                                                                    function13 = function14;
                                                                    imeOptions2 = imeOptions8;
                                                                    textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                                    mutableInteractionSource2 = mutableInteractionSource6;
                                                                    brush2 = brush4;
                                                                    z6 = z30;
                                                                    keyboardActions2 = keyboardActions4;
                                                                    modifier2 = modifier5;
                                                                    i29 = i47;
                                                                    z4 = z12;
                                                                    z5 = z10;
                                                                    textStyle2 = textStyle3;
                                                                    visualTransformation2 = visualTransformation5;
                                                                }
                                                            } else {
                                                                imeOptions6 = imeOptions5;
                                                            }
                                                            z14 = true;
                                                            z15 = z14 | changed4;
                                                            Object rememberedValue172 = startRestartGroup.rememberedValue();
                                                            if (z15) {
                                                            }
                                                            ImeOptions imeOptions102 = imeOptions6;
                                                            state = rememberUpdatedState;
                                                            textInputService2 = textInputService4;
                                                            imeOptions7 = imeOptions102;
                                                            coreTextFieldKt$CoreTextField$2$1 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState3, rememberUpdatedState, textInputService4, textFieldSelectionManager, imeOptions102, null);
                                                            startRestartGroup.updateRememberedValue(coreTextFieldKt$CoreTextField$2$1);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            imeOptions8 = imeOptions7;
                                                            EffectsKt.LaunchedEffect(unit, coreTextFieldKt$CoreTextField$2$1, startRestartGroup, 6);
                                                            Modifier.Companion companion42 = Modifier.Companion;
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705168925, "CC(remember):CoreTextField.kt#9igjgp");
                                                            changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState3);
                                                            rememberedValue5 = startRestartGroup.rememberedValue();
                                                            if (!changedInstance2) {
                                                            }
                                                            rememberedValue5 = (Function1) new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                                    invoke(bool.booleanValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(boolean z292) {
                                                                    LegacyTextFieldState.this.setInTouchMode(z292);
                                                                }
                                                            };
                                                            startRestartGroup.updateRememberedValue(rememberedValue5);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            Modifier updateSelectionTouchMode2 = SelectionGesturesKt.updateSelectionTouchMode(companion42, (Function1) rememberedValue5);
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705164890, "CC(remember):CoreTextField.kt#9igjgp");
                                                            changedInstance3 = (i46 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState3) | (i45 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                                            Object rememberedValue182 = startRestartGroup.rememberedValue();
                                                            if (changedInstance3) {
                                                            }
                                                            final OffsetMapping offsetMapping32 = offsetMapping;
                                                            final LegacyTextFieldState legacyTextFieldState52 = legacyTextFieldState3;
                                                            final TextFieldSelectionManager textFieldSelectionManager32 = textFieldSelectionManager;
                                                            final boolean z292 = z12;
                                                            focusRequester = focusRequester2;
                                                            z16 = z28;
                                                            function16 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                                    m1061invokek4lQ0M(offset.m3847unboximpl());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                                                                public final void m1061invokek4lQ0M(long j) {
                                                                    CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z292);
                                                                    if (LegacyTextFieldState.this.getHasFocus() && z28) {
                                                                        if (LegacyTextFieldState.this.getHandleState() != HandleState.Selection) {
                                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                            if (layoutResult != null) {
                                                                                LegacyTextFieldState legacyTextFieldState62 = LegacyTextFieldState.this;
                                                                                TextFieldDelegate.Companion.m1157setCursorOffsetULxng0E$foundation_release(j, layoutResult, legacyTextFieldState62.getProcessor(), offsetMapping32, legacyTextFieldState62.getOnValueChange());
                                                                                if (legacyTextFieldState62.getTextDelegate().getText().length() > 0) {
                                                                                    legacyTextFieldState62.setHandleState(HandleState.Cursor);
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        textFieldSelectionManager32.m1522deselect_kEHs6E$foundation_release(Offset.m3826boximpl(j));
                                                                    }
                                                                }
                                                            };
                                                            startRestartGroup.updateRememberedValue(function16);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            FocusRequester focusRequester32 = focusRequester;
                                                            z17 = z16;
                                                            State state22 = state;
                                                            Modifier pointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode2, mutableInteractionSource6, z16, function16), textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), textFieldSelectionManager.getTouchSelectionObserver$foundation_release()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                                            Modifier.Companion companion52 = Modifier.Companion;
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705124313, "CC(remember):CoreTextField.kt#9igjgp");
                                                            changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState3) | (i43 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                            Object rememberedValue192 = startRestartGroup.rememberedValue();
                                                            if (changedInstance4) {
                                                            }
                                                            textFieldValue2 = textFieldValue;
                                                            function17 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                                    invoke2(drawScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                public final void invoke2(DrawScope drawScope) {
                                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                    if (layoutResult != null) {
                                                                        TextFieldValue textFieldValue32 = textFieldValue2;
                                                                        LegacyTextFieldState legacyTextFieldState62 = LegacyTextFieldState.this;
                                                                        OffsetMapping offsetMapping42 = offsetMapping;
                                                                        TextFieldDelegate.Companion.m1155drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue32, legacyTextFieldState62.m1086getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState62.m1083getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping42, layoutResult.getValue(), legacyTextFieldState62.getHighlightPaint(), legacyTextFieldState62.m1085getSelectionBackgroundColor0d7_KjU());
                                                                    }
                                                                }
                                                            };
                                                            startRestartGroup.updateRememberedValue(function17);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            final Modifier drawBehind2 = DrawModifierKt.drawBehind(companion52, function17);
                                                            Modifier.Companion companion62 = Modifier.Companion;
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705102580, "CC(remember):CoreTextField.kt#9igjgp");
                                                            windowInfo2 = windowInfo;
                                                            changedInstance5 = (i45 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changed(windowInfo2) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i43 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                            rememberedValue6 = startRestartGroup.rememberedValue();
                                                            if (changedInstance5) {
                                                            }
                                                            final OffsetMapping offsetMapping42 = offsetMapping;
                                                            final LegacyTextFieldState legacyTextFieldState62 = legacyTextFieldState3;
                                                            final TextFieldValue textFieldValue32 = textFieldValue2;
                                                            final TextFieldSelectionManager textFieldSelectionManager42 = textFieldSelectionManager;
                                                            z18 = z17;
                                                            windowInfo3 = windowInfo2;
                                                            rememberedValue6 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                                    invoke2(layoutCoordinates);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                                    LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                    if (layoutResult != null) {
                                                                        layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                                    }
                                                                    if (z17) {
                                                                        if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                                            if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo2.isWindowFocused()) {
                                                                                textFieldSelectionManager42.showSelectionToolbar$foundation_release();
                                                                            } else {
                                                                                textFieldSelectionManager42.hideSelectionToolbar$foundation_release();
                                                                            }
                                                                            LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager42, true));
                                                                            LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager42, false));
                                                                            LegacyTextFieldState.this.setShowCursorHandle(TextRange.m6141getCollapsedimpl(textFieldValue32.m6396getSelectiond9O1mEE()));
                                                                        } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                                            LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager42, true));
                                                                        }
                                                                        CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue32, offsetMapping42);
                                                                        TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                                                        if (layoutResult2 != null) {
                                                                            LegacyTextFieldState legacyTextFieldState7 = LegacyTextFieldState.this;
                                                                            TextFieldValue textFieldValue4 = textFieldValue32;
                                                                            OffsetMapping offsetMapping52 = offsetMapping42;
                                                                            TextInputSession inputSession = legacyTextFieldState7.getInputSession();
                                                                            if (inputSession == null || !legacyTextFieldState7.getHasFocus()) {
                                                                                return;
                                                                            }
                                                                            TextFieldDelegate.Companion.updateTextLayoutResult$foundation_release(inputSession, textFieldValue4, offsetMapping52, layoutResult2);
                                                                        }
                                                                    }
                                                                }
                                                            };
                                                            startRestartGroup.updateRememberedValue(rememberedValue6);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            final Modifier onGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion62, (Function1) rememberedValue6);
                                                            final VisualTransformation visualTransformation52 = visualTransformation4;
                                                            CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier2 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState3, z12, z18, visualTransformation52 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager, imeOptions8, focusRequester32);
                                                            final OffsetMapping offsetMapping52 = offsetMapping;
                                                            legacyTextFieldState4 = legacyTextFieldState3;
                                                            Modifier cursor2 = TextFieldCursorKt.cursor(Modifier.Companion, legacyTextFieldState4, textFieldValue, offsetMapping52, brush4, (z18 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState3.hasHighlight()) ? false : true);
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705033225, "CC(remember):CoreTextField.kt#9igjgp");
                                                            changedInstance6 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                                            Object rememberedValue202 = startRestartGroup.rememberedValue();
                                                            if (changedInstance6) {
                                                            }
                                                            rememberedValue202 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                    final TextFieldSelectionManager textFieldSelectionManager5 = TextFieldSelectionManager.this;
                                                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                                        public void dispose() {
                                                                            TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                                                        }
                                                                    };
                                                                }
                                                            };
                                                            startRestartGroup.updateRememberedValue(rememberedValue202);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1) rememberedValue202, startRestartGroup, 0);
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705030115, "CC(remember):CoreTextField.kt#9igjgp");
                                                            changedInstance7 = ((i35 <= 32 && startRestartGroup.changed(imeOptions8)) || (i34 & 48) == 32) | startRestartGroup.changedInstance(legacyTextFieldState4) | startRestartGroup.changedInstance(textInputService2) | (i43 != 4);
                                                            rememberedValue7 = startRestartGroup.rememberedValue();
                                                            if (!changedInstance7) {
                                                            }
                                                            rememberedValue7 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                    if (LegacyTextFieldState.this.getHasFocus()) {
                                                                        LegacyTextFieldState.this.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(textInputService2, textFieldValue, LegacyTextFieldState.this.getProcessor(), imeOptions8, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                                                    }
                                                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                                        public void dispose() {
                                                                        }
                                                                    };
                                                                }
                                                            };
                                                            startRestartGroup.updateRememberedValue(rememberedValue7);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            EffectsKt.DisposableEffect(imeOptions8, (Function1) rememberedValue7, startRestartGroup, (i34 >> 3) & 14);
                                                            final int i472 = i33;
                                                            Modifier m1164textFieldKeyInput2WJ9YEU2 = TextFieldKeyInputKt.m1164textFieldKeyInput2WJ9YEU(Modifier.Companion, legacyTextFieldState4, textFieldSelectionManager, textFieldValue, legacyTextFieldState4.getOnValueChange(), !z12, i472 != 1, offsetMapping52, undoManager, imeOptions8.m6343getImeActioneUduSuo());
                                                            if (KeyboardType.m6367equalsimpl0(imeOptions8.m6344getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6386getPasswordPjHm6EE())) {
                                                            }
                                                            Modifier.Companion companion72 = Modifier.Companion;
                                                            boolean CoreTextField$lambda$112 = CoreTextField$lambda$11(state22);
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1704991998, "CC(remember):CoreTextField.kt#9igjgp");
                                                            final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter32 = legacyPlatformTextInputServiceAdapter;
                                                            changed = startRestartGroup.changed(z19) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter32);
                                                            rememberedValue8 = startRestartGroup.rememberedValue();
                                                            if (!changed) {
                                                            }
                                                            rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
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
                                                                    if (z19) {
                                                                        legacyPlatformTextInputServiceAdapter32.startStylusHandwriting();
                                                                    }
                                                                }
                                                            };
                                                            startRestartGroup.updateRememberedValue(rememberedValue8);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            Modifier stylusHandwriting2 = StylusHandwritingKt.stylusHandwriting(companion72, CoreTextField$lambda$112, z19, (Function0) rememberedValue8);
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
                                                            Object consume102 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightColor());
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            final long m4088unboximpl2 = ((Color) consume102).m4088unboximpl();
                                                            Modifier.Companion companion82 = Modifier.Companion;
                                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1704957026, "CC(remember):CoreTextField.kt#9igjgp");
                                                            changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState4) | startRestartGroup.changed(m4088unboximpl2);
                                                            rememberedValue9 = startRestartGroup.rememberedValue();
                                                            if (!changedInstance8) {
                                                            }
                                                            rememberedValue9 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawDecorationModifier$1$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                                    invoke2(drawScope);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                public final void invoke2(DrawScope drawScope) {
                                                                    if (LegacyTextFieldState.this.getAutofillHighlightOn() || LegacyTextFieldState.this.getJustAutofilled()) {
                                                                        DrawScope.m4634drawRectnJ9OG0$default(drawScope, m4088unboximpl2, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
                                                                    }
                                                                }
                                                            };
                                                            startRestartGroup.updateRememberedValue(rememberedValue9);
                                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                            Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(DrawModifierKt.drawBehind(companion82, (Function1) rememberedValue9)), legacyPlatformTextInputServiceAdapter32, legacyTextFieldState4, textFieldSelectionManager).then(stylusHandwriting2).then(textFieldFocusModifier), legacyTextFieldState4, focusManager), legacyTextFieldState4, textFieldSelectionManager).then(m1164textFieldKeyInput2WJ9YEU2), textFieldScrollerPosition5, mutableInteractionSource6, z18).then(pointerHoverIcon$default2).then(coreTextFieldSemanticsModifier2), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                                    invoke2(layoutCoordinates);
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                    if (layoutResult == null) {
                                                                        return;
                                                                    }
                                                                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                                }
                                                            });
                                                            if (z18) {
                                                            }
                                                            if (!z20) {
                                                            }
                                                            final Modifier modifier62 = modifier4;
                                                            boolean z302 = z18;
                                                            final BringIntoViewRequester bringIntoViewRequester32 = bringIntoViewRequester;
                                                            final boolean z312 = z12;
                                                            final TextStyle textStyle52 = textStyle3;
                                                            final Modifier modifier72 = companion2;
                                                            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function332 = m1060getLambda1$foundation_release;
                                                            CoreTextFieldRootBox(onGloballyPositioned22, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-492537660, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(2);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                                    invoke(composer3, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer composer3, int i48) {
                                                                    ComposerKt.sourceInformation(composer3, "C555@26133L5372,555@26119L5386:CoreTextField.kt#423gt5");
                                                                    if (!composer3.shouldExecute((i48 & 3) != 2, i48 & 1)) {
                                                                        composer3.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-492537660, i48, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:555)");
                                                                    }
                                                                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function34 = function332;
                                                                    final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState4;
                                                                    final TextStyle textStyle6 = textStyle52;
                                                                    final int i49 = i42;
                                                                    final int i50 = i472;
                                                                    final TextFieldScrollerPosition textFieldScrollerPosition6 = textFieldScrollerPosition5;
                                                                    final TextFieldValue textFieldValue4 = textFieldValue;
                                                                    final VisualTransformation visualTransformation6 = visualTransformation52;
                                                                    final Modifier modifier8 = modifier62;
                                                                    final Modifier modifier9 = drawBehind2;
                                                                    final Modifier modifier10 = onGloballyPositioned3;
                                                                    final Modifier modifier11 = modifier72;
                                                                    final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester32;
                                                                    final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                                    final boolean z32 = z20;
                                                                    final boolean z33 = z312;
                                                                    final Function1<? super TextLayoutResult, Unit> function19 = function14;
                                                                    final OffsetMapping offsetMapping6 = offsetMapping52;
                                                                    final Density density3 = density2;
                                                                    function34.invoke(ComposableLambdaKt.rememberComposableLambda(-1835647873, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(2);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                            invoke(composer4, num.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(Composer composer4, int i51) {
                                                                            ComposerKt.sourceInformation(composer4, "C569@26984L22,578@27371L4124,578@27335L4160:CoreTextField.kt#423gt5");
                                                                            if (composer4.shouldExecute((i51 & 3) != 2, i51 & 1)) {
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-1835647873, i51, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:558)");
                                                                                }
                                                                                Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m773heightInVpY3zN4$default(Modifier.Companion, LegacyTextFieldState.this.m1084getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i49, i50);
                                                                                TextFieldScrollerPosition textFieldScrollerPosition7 = textFieldScrollerPosition6;
                                                                                TextFieldValue textFieldValue5 = textFieldValue4;
                                                                                VisualTransformation visualTransformation7 = visualTransformation6;
                                                                                ComposerKt.sourceInformationMarkerStart(composer4, 713003803, "CC(remember):CoreTextField.kt#9igjgp");
                                                                                boolean changedInstance10 = composer4.changedInstance(LegacyTextFieldState.this);
                                                                                final LegacyTextFieldState legacyTextFieldState8 = LegacyTextFieldState.this;
                                                                                Object rememberedValue21 = composer4.rememberedValue();
                                                                                if (changedInstance10 || rememberedValue21 == Composer.Companion.getEmpty()) {
                                                                                    rememberedValue21 = (Function0) new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                                                        {
                                                                                            super(0);
                                                                                        }

                                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                                        @Override // kotlin.jvm.functions.Function0
                                                                                        public final TextLayoutResultProxy invoke() {
                                                                                            return LegacyTextFieldState.this.getLayoutResult();
                                                                                        }
                                                                                    };
                                                                                    composer4.updateRememberedValue(rememberedValue21);
                                                                                }
                                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                                Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(heightInLines, textFieldScrollerPosition7, textFieldValue5, visualTransformation7, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester4);
                                                                                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager5;
                                                                                final LegacyTextFieldState legacyTextFieldState9 = LegacyTextFieldState.this;
                                                                                final boolean z34 = z32;
                                                                                final boolean z35 = z33;
                                                                                final Function1<? super TextLayoutResult, Unit> function110 = function19;
                                                                                final TextFieldValue textFieldValue6 = textFieldValue4;
                                                                                final OffsetMapping offsetMapping7 = offsetMapping6;
                                                                                final Density density4 = density3;
                                                                                final int i52 = i50;
                                                                                SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.rememberComposableLambda(-1172467467, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                                    {
                                                                                        super(2);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function2
                                                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                                        invoke(composer5, num.intValue());
                                                                                        return Unit.INSTANCE;
                                                                                    }

                                                                                    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fa, code lost:
                                                                                        if (r3 != false) goto L27;
                                                                                     */
                                                                                    /*
                                                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                                                    */
                                                                                    public final void invoke(Composer composer5, int i53) {
                                                                                        ComposerKt.sourceInformation(composer5, "C579@27389L3496,644@30903L358:CoreTextField.kt#423gt5");
                                                                                        boolean z36 = true;
                                                                                        if (!composer5.shouldExecute((i53 & 3) != 2, i53 & 1)) {
                                                                                            composer5.skipToGroupEnd();
                                                                                            return;
                                                                                        }
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventStart(-1172467467, i53, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:579)");
                                                                                        }
                                                                                        final LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState9;
                                                                                        final Function1<? super TextLayoutResult, Unit> function111 = function110;
                                                                                        final TextFieldValue textFieldValue7 = textFieldValue6;
                                                                                        final OffsetMapping offsetMapping8 = offsetMapping7;
                                                                                        final Density density5 = density4;
                                                                                        final int i54 = i52;
                                                                                        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                                            @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                                            /* renamed from: measure-3p2s80s */
                                                                                            public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                                                                Snapshot.Companion companion9 = Snapshot.Companion;
                                                                                                LegacyTextFieldState legacyTextFieldState11 = LegacyTextFieldState.this;
                                                                                                Snapshot currentThreadSnapshot = companion9.getCurrentThreadSnapshot();
                                                                                                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                                                Snapshot makeCurrentNonObservable = companion9.makeCurrentNonObservable(currentThreadSnapshot);
                                                                                                try {
                                                                                                    TextLayoutResultProxy layoutResult = legacyTextFieldState11.getLayoutResult();
                                                                                                    TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                                    Triple<Integer, Integer, TextLayoutResult> m1156layout_EkL_Y$foundation_release = TextFieldDelegate.Companion.m1156layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                                                    int intValue = m1156layout_EkL_Y$foundation_release.component1().intValue();
                                                                                                    int intValue2 = m1156layout_EkL_Y$foundation_release.component2().intValue();
                                                                                                    TextLayoutResult component3 = m1156layout_EkL_Y$foundation_release.component3();
                                                                                                    if (!Intrinsics.areEqual(value, component3)) {
                                                                                                        LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                                        function111.invoke(component3);
                                                                                                        CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue7, offsetMapping8);
                                                                                                    }
                                                                                                    LegacyTextFieldState.this.m1088setMinHeightForSingleLineField0680j_4(density5.mo386toDpu2uoSUM(i54 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                                                    return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                                            invoke2(placementScope);
                                                                                                            return Unit.INSTANCE;
                                                                                                        }
                                                                                                    });
                                                                                                } finally {
                                                                                                    companion9.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                                                                }
                                                                                            }

                                                                                            @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                                            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i55) {
                                                                                                LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                                                return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                                            }
                                                                                        };
                                                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, Modifier.Companion);
                                                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                                                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                                                            ComposablesKt.invalidApplier();
                                                                                        }
                                                                                        composer5.startReusableNode();
                                                                                        if (composer5.getInserting()) {
                                                                                            composer5.createNode(constructor);
                                                                                        } else {
                                                                                            composer5.useNode();
                                                                                        }
                                                                                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                                                                        Updater.m3527setimpl(m3520constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                                        }
                                                                                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1679992992, "C:CoreTextField.kt#423gt5");
                                                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                        composer5.endNode();
                                                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                        TextFieldSelectionManager textFieldSelectionManager7 = TextFieldSelectionManager.this;
                                                                                        if (legacyTextFieldState9.getHandleState() != HandleState.None && legacyTextFieldState9.getLayoutCoordinates() != null) {
                                                                                            LayoutCoordinates layoutCoordinates = legacyTextFieldState9.getLayoutCoordinates();
                                                                                            Intrinsics.checkNotNull(layoutCoordinates);
                                                                                            if (layoutCoordinates.isAttached()) {
                                                                                            }
                                                                                        }
                                                                                        z36 = false;
                                                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager7, z36, composer5, 0);
                                                                                        if (legacyTextFieldState9.getHandleState() == HandleState.Cursor && !z35 && z34) {
                                                                                            composer5.startReplaceGroup(-7167858);
                                                                                            ComposerKt.sourceInformation(composer5, "656@31423L40");
                                                                                            CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                                            composer5.endReplaceGroup();
                                                                                        } else {
                                                                                            composer5.startReplaceGroup(-7090978);
                                                                                            composer5.endReplaceGroup();
                                                                                        }
                                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                                            ComposerKt.traceEventEnd();
                                                                                        }
                                                                                    }
                                                                                }, composer4, 54), composer4, 48, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            composer4.skipToGroupEnd();
                                                                        }
                                                                    }, composer3, 54), composer3, 6);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                            }
                                                            function32 = function332;
                                                            i28 = i42;
                                                            composer2 = startRestartGroup;
                                                            function13 = function14;
                                                            imeOptions2 = imeOptions8;
                                                            textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                            mutableInteractionSource2 = mutableInteractionSource6;
                                                            brush2 = brush4;
                                                            z6 = z302;
                                                            keyboardActions2 = keyboardActions4;
                                                            modifier2 = modifier5;
                                                            i29 = i472;
                                                            z4 = z12;
                                                            z5 = z10;
                                                            textStyle2 = textStyle3;
                                                            visualTransformation2 = visualTransformation52;
                                                        }
                                                    } else {
                                                        legacyTextFieldState2 = legacyTextFieldState;
                                                    }
                                                    z11 = true;
                                                    changedInstance = changedInstance9 | z11 | startRestartGroup.changedInstance(offsetMapping2) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(bringIntoViewRequester2) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                                                    Object rememberedValue162 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance) {
                                                    }
                                                    final ImeOptions imeOptions92 = imeOptions4;
                                                    final boolean z272 = z8;
                                                    Function1 function182 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                                            invoke2(focusState);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                        public final void invoke2(FocusState focusState) {
                                                            TextLayoutResultProxy layoutResult;
                                                            if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                                                return;
                                                            }
                                                            LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                                                            if (!LegacyTextFieldState.this.getHasFocus() || !z26 || z272) {
                                                                CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                                                            } else {
                                                                CoreTextFieldKt.startInputSession(textInputService3, LegacyTextFieldState.this, textFieldValue, imeOptions92, offsetMapping2);
                                                            }
                                                            if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester2, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping2, null), 3, null);
                                                            }
                                                            if (focusState.isFocused()) {
                                                                return;
                                                            }
                                                            TextFieldSelectionManager.m1519deselect_kEHs6E$foundation_release$default(textFieldSelectionManager2, null, 1, null);
                                                        }
                                                    };
                                                    legacyTextFieldState3 = legacyTextFieldState2;
                                                    z12 = z272;
                                                    textInputService = textInputService3;
                                                    imeOptions5 = imeOptions92;
                                                    offsetMapping = offsetMapping2;
                                                    textFieldSelectionManager = textFieldSelectionManager2;
                                                    bringIntoViewRequester = bringIntoViewRequester2;
                                                    visualTransformation4 = visualTransformation3;
                                                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                                    z13 = z26;
                                                    function15 = function182;
                                                    startRestartGroup.updateRememberedValue(function15);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    Modifier textFieldFocusModifier2 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion3, z13, focusRequester2, mutableInteractionSource6, function15);
                                                    State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z13 || z12) ? false : true), startRestartGroup, 0);
                                                    Unit unit2 = Unit.INSTANCE;
                                                    final boolean z282 = z13;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705201263, "CC(remember):CoreTextField.kt#9igjgp");
                                                    boolean changed42 = startRestartGroup.changed(rememberUpdatedState2) | startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                                    TextInputService textInputService42 = textInputService;
                                                    if (i35 > 32) {
                                                    }
                                                    imeOptions6 = imeOptions5;
                                                    if ((i34 & 48) != 32) {
                                                    }
                                                    z14 = true;
                                                    z15 = z14 | changed42;
                                                    Object rememberedValue1722 = startRestartGroup.rememberedValue();
                                                    if (z15) {
                                                    }
                                                    ImeOptions imeOptions1022 = imeOptions6;
                                                    state = rememberUpdatedState2;
                                                    textInputService2 = textInputService42;
                                                    imeOptions7 = imeOptions1022;
                                                    coreTextFieldKt$CoreTextField$2$1 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState3, rememberUpdatedState2, textInputService42, textFieldSelectionManager, imeOptions1022, null);
                                                    startRestartGroup.updateRememberedValue(coreTextFieldKt$CoreTextField$2$1);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    imeOptions8 = imeOptions7;
                                                    EffectsKt.LaunchedEffect(unit2, coreTextFieldKt$CoreTextField$2$1, startRestartGroup, 6);
                                                    Modifier.Companion companion422 = Modifier.Companion;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705168925, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState3);
                                                    rememberedValue5 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance2) {
                                                    }
                                                    rememberedValue5 = (Function1) new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                            invoke(bool.booleanValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(boolean z2922) {
                                                            LegacyTextFieldState.this.setInTouchMode(z2922);
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    Modifier updateSelectionTouchMode22 = SelectionGesturesKt.updateSelectionTouchMode(companion422, (Function1) rememberedValue5);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705164890, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance3 = (i46 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState3) | (i45 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                                    Object rememberedValue1822 = startRestartGroup.rememberedValue();
                                                    if (changedInstance3) {
                                                    }
                                                    final OffsetMapping offsetMapping322 = offsetMapping;
                                                    final LegacyTextFieldState legacyTextFieldState522 = legacyTextFieldState3;
                                                    final TextFieldSelectionManager textFieldSelectionManager322 = textFieldSelectionManager;
                                                    final boolean z2922 = z12;
                                                    focusRequester = focusRequester2;
                                                    z16 = z282;
                                                    function16 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                            m1061invokek4lQ0M(offset.m3847unboximpl());
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                                                        public final void m1061invokek4lQ0M(long j) {
                                                            CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z2922);
                                                            if (LegacyTextFieldState.this.getHasFocus() && z282) {
                                                                if (LegacyTextFieldState.this.getHandleState() != HandleState.Selection) {
                                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                    if (layoutResult != null) {
                                                                        LegacyTextFieldState legacyTextFieldState622 = LegacyTextFieldState.this;
                                                                        TextFieldDelegate.Companion.m1157setCursorOffsetULxng0E$foundation_release(j, layoutResult, legacyTextFieldState622.getProcessor(), offsetMapping322, legacyTextFieldState622.getOnValueChange());
                                                                        if (legacyTextFieldState622.getTextDelegate().getText().length() > 0) {
                                                                            legacyTextFieldState622.setHandleState(HandleState.Cursor);
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                textFieldSelectionManager322.m1522deselect_kEHs6E$foundation_release(Offset.m3826boximpl(j));
                                                            }
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(function16);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    FocusRequester focusRequester322 = focusRequester;
                                                    z17 = z16;
                                                    State state222 = state;
                                                    Modifier pointerHoverIcon$default22 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode22, mutableInteractionSource6, z16, function16), textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), textFieldSelectionManager.getTouchSelectionObserver$foundation_release()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                                    Modifier.Companion companion522 = Modifier.Companion;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705124313, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState3) | (i43 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                    Object rememberedValue1922 = startRestartGroup.rememberedValue();
                                                    if (changedInstance4) {
                                                    }
                                                    textFieldValue2 = textFieldValue;
                                                    function17 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                            invoke2(drawScope);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                        public final void invoke2(DrawScope drawScope) {
                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                            if (layoutResult != null) {
                                                                TextFieldValue textFieldValue322 = textFieldValue2;
                                                                LegacyTextFieldState legacyTextFieldState622 = LegacyTextFieldState.this;
                                                                OffsetMapping offsetMapping422 = offsetMapping;
                                                                TextFieldDelegate.Companion.m1155drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue322, legacyTextFieldState622.m1086getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState622.m1083getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping422, layoutResult.getValue(), legacyTextFieldState622.getHighlightPaint(), legacyTextFieldState622.m1085getSelectionBackgroundColor0d7_KjU());
                                                            }
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(function17);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    final Modifier drawBehind22 = DrawModifierKt.drawBehind(companion522, function17);
                                                    Modifier.Companion companion622 = Modifier.Companion;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705102580, "CC(remember):CoreTextField.kt#9igjgp");
                                                    windowInfo2 = windowInfo;
                                                    changedInstance5 = (i45 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changed(windowInfo2) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i43 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                    rememberedValue6 = startRestartGroup.rememberedValue();
                                                    if (changedInstance5) {
                                                    }
                                                    final OffsetMapping offsetMapping422 = offsetMapping;
                                                    final LegacyTextFieldState legacyTextFieldState622 = legacyTextFieldState3;
                                                    final TextFieldValue textFieldValue322 = textFieldValue2;
                                                    final TextFieldSelectionManager textFieldSelectionManager422 = textFieldSelectionManager;
                                                    z18 = z17;
                                                    windowInfo3 = windowInfo2;
                                                    rememberedValue6 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                            invoke2(layoutCoordinates);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                            LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                            if (layoutResult != null) {
                                                                layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                            }
                                                            if (z17) {
                                                                if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                                    if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo2.isWindowFocused()) {
                                                                        textFieldSelectionManager422.showSelectionToolbar$foundation_release();
                                                                    } else {
                                                                        textFieldSelectionManager422.hideSelectionToolbar$foundation_release();
                                                                    }
                                                                    LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager422, true));
                                                                    LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager422, false));
                                                                    LegacyTextFieldState.this.setShowCursorHandle(TextRange.m6141getCollapsedimpl(textFieldValue322.m6396getSelectiond9O1mEE()));
                                                                } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                                    LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager422, true));
                                                                }
                                                                CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue322, offsetMapping422);
                                                                TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                                                if (layoutResult2 != null) {
                                                                    LegacyTextFieldState legacyTextFieldState7 = LegacyTextFieldState.this;
                                                                    TextFieldValue textFieldValue4 = textFieldValue322;
                                                                    OffsetMapping offsetMapping522 = offsetMapping422;
                                                                    TextInputSession inputSession = legacyTextFieldState7.getInputSession();
                                                                    if (inputSession == null || !legacyTextFieldState7.getHasFocus()) {
                                                                        return;
                                                                    }
                                                                    TextFieldDelegate.Companion.updateTextLayoutResult$foundation_release(inputSession, textFieldValue4, offsetMapping522, layoutResult2);
                                                                }
                                                            }
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    final Modifier onGloballyPositioned32 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion622, (Function1) rememberedValue6);
                                                    final VisualTransformation visualTransformation522 = visualTransformation4;
                                                    CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier22 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState3, z12, z18, visualTransformation522 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager, imeOptions8, focusRequester322);
                                                    final OffsetMapping offsetMapping522 = offsetMapping;
                                                    legacyTextFieldState4 = legacyTextFieldState3;
                                                    Modifier cursor22 = TextFieldCursorKt.cursor(Modifier.Companion, legacyTextFieldState4, textFieldValue, offsetMapping522, brush4, (z18 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState3.hasHighlight()) ? false : true);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705033225, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance6 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                                    Object rememberedValue2022 = startRestartGroup.rememberedValue();
                                                    if (changedInstance6) {
                                                    }
                                                    rememberedValue2022 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                            final TextFieldSelectionManager textFieldSelectionManager5 = TextFieldSelectionManager.this;
                                                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                                public void dispose() {
                                                                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                                                }
                                                            };
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue2022);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1) rememberedValue2022, startRestartGroup, 0);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705030115, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance7 = ((i35 <= 32 && startRestartGroup.changed(imeOptions8)) || (i34 & 48) == 32) | startRestartGroup.changedInstance(legacyTextFieldState4) | startRestartGroup.changedInstance(textInputService2) | (i43 != 4);
                                                    rememberedValue7 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance7) {
                                                    }
                                                    rememberedValue7 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                            if (LegacyTextFieldState.this.getHasFocus()) {
                                                                LegacyTextFieldState.this.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(textInputService2, textFieldValue, LegacyTextFieldState.this.getProcessor(), imeOptions8, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                                            }
                                                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                                public void dispose() {
                                                                }
                                                            };
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue7);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    EffectsKt.DisposableEffect(imeOptions8, (Function1) rememberedValue7, startRestartGroup, (i34 >> 3) & 14);
                                                    final int i4722 = i33;
                                                    Modifier m1164textFieldKeyInput2WJ9YEU22 = TextFieldKeyInputKt.m1164textFieldKeyInput2WJ9YEU(Modifier.Companion, legacyTextFieldState4, textFieldSelectionManager, textFieldValue, legacyTextFieldState4.getOnValueChange(), !z12, i4722 != 1, offsetMapping522, undoManager, imeOptions8.m6343getImeActioneUduSuo());
                                                    if (KeyboardType.m6367equalsimpl0(imeOptions8.m6344getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6386getPasswordPjHm6EE())) {
                                                    }
                                                    Modifier.Companion companion722 = Modifier.Companion;
                                                    boolean CoreTextField$lambda$1122 = CoreTextField$lambda$11(state222);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1704991998, "CC(remember):CoreTextField.kt#9igjgp");
                                                    final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter322 = legacyPlatformTextInputServiceAdapter;
                                                    changed = startRestartGroup.changed(z19) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter322);
                                                    rememberedValue8 = startRestartGroup.rememberedValue();
                                                    if (!changed) {
                                                    }
                                                    rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
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
                                                            if (z19) {
                                                                legacyPlatformTextInputServiceAdapter322.startStylusHandwriting();
                                                            }
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue8);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    Modifier stylusHandwriting22 = StylusHandwritingKt.stylusHandwriting(companion722, CoreTextField$lambda$1122, z19, (Function0) rememberedValue8);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
                                                    Object consume1022 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightColor());
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    final long m4088unboximpl22 = ((Color) consume1022).m4088unboximpl();
                                                    Modifier.Companion companion822 = Modifier.Companion;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1704957026, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState4) | startRestartGroup.changed(m4088unboximpl22);
                                                    rememberedValue9 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance8) {
                                                    }
                                                    rememberedValue9 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawDecorationModifier$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                            invoke2(drawScope);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                        public final void invoke2(DrawScope drawScope) {
                                                            if (LegacyTextFieldState.this.getAutofillHighlightOn() || LegacyTextFieldState.this.getJustAutofilled()) {
                                                                DrawScope.m4634drawRectnJ9OG0$default(drawScope, m4088unboximpl22, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
                                                            }
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue9);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    Modifier onGloballyPositioned222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(DrawModifierKt.drawBehind(companion822, (Function1) rememberedValue9)), legacyPlatformTextInputServiceAdapter322, legacyTextFieldState4, textFieldSelectionManager).then(stylusHandwriting22).then(textFieldFocusModifier2), legacyTextFieldState4, focusManager), legacyTextFieldState4, textFieldSelectionManager).then(m1164textFieldKeyInput2WJ9YEU22), textFieldScrollerPosition5, mutableInteractionSource6, z18).then(pointerHoverIcon$default22).then(coreTextFieldSemanticsModifier22), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                            invoke2(layoutCoordinates);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                            if (layoutResult == null) {
                                                                return;
                                                            }
                                                            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                        }
                                                    });
                                                    if (z18) {
                                                    }
                                                    if (!z20) {
                                                    }
                                                    final Modifier modifier622 = modifier4;
                                                    boolean z3022 = z18;
                                                    final BringIntoViewRequester bringIntoViewRequester322 = bringIntoViewRequester;
                                                    final boolean z3122 = z12;
                                                    final TextStyle textStyle522 = textStyle3;
                                                    final Modifier modifier722 = companion2;
                                                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3322 = m1060getLambda1$foundation_release;
                                                    CoreTextFieldRootBox(onGloballyPositioned222, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-492537660, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i48) {
                                                            ComposerKt.sourceInformation(composer3, "C555@26133L5372,555@26119L5386:CoreTextField.kt#423gt5");
                                                            if (!composer3.shouldExecute((i48 & 3) != 2, i48 & 1)) {
                                                                composer3.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-492537660, i48, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:555)");
                                                            }
                                                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function34 = function3322;
                                                            final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState4;
                                                            final TextStyle textStyle6 = textStyle522;
                                                            final int i49 = i42;
                                                            final int i50 = i4722;
                                                            final TextFieldScrollerPosition textFieldScrollerPosition6 = textFieldScrollerPosition5;
                                                            final TextFieldValue textFieldValue4 = textFieldValue;
                                                            final VisualTransformation visualTransformation6 = visualTransformation522;
                                                            final Modifier modifier8 = modifier622;
                                                            final Modifier modifier9 = drawBehind22;
                                                            final Modifier modifier10 = onGloballyPositioned32;
                                                            final Modifier modifier11 = modifier722;
                                                            final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester322;
                                                            final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                            final boolean z32 = z20;
                                                            final boolean z33 = z3122;
                                                            final Function1<? super TextLayoutResult, Unit> function19 = function14;
                                                            final OffsetMapping offsetMapping6 = offsetMapping522;
                                                            final Density density3 = density2;
                                                            function34.invoke(ComposableLambdaKt.rememberComposableLambda(-1835647873, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(2);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                    invoke(composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer composer4, int i51) {
                                                                    ComposerKt.sourceInformation(composer4, "C569@26984L22,578@27371L4124,578@27335L4160:CoreTextField.kt#423gt5");
                                                                    if (composer4.shouldExecute((i51 & 3) != 2, i51 & 1)) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1835647873, i51, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:558)");
                                                                        }
                                                                        Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m773heightInVpY3zN4$default(Modifier.Companion, LegacyTextFieldState.this.m1084getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i49, i50);
                                                                        TextFieldScrollerPosition textFieldScrollerPosition7 = textFieldScrollerPosition6;
                                                                        TextFieldValue textFieldValue5 = textFieldValue4;
                                                                        VisualTransformation visualTransformation7 = visualTransformation6;
                                                                        ComposerKt.sourceInformationMarkerStart(composer4, 713003803, "CC(remember):CoreTextField.kt#9igjgp");
                                                                        boolean changedInstance10 = composer4.changedInstance(LegacyTextFieldState.this);
                                                                        final LegacyTextFieldState legacyTextFieldState8 = LegacyTextFieldState.this;
                                                                        Object rememberedValue21 = composer4.rememberedValue();
                                                                        if (changedInstance10 || rememberedValue21 == Composer.Companion.getEmpty()) {
                                                                            rememberedValue21 = (Function0) new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                                {
                                                                                    super(0);
                                                                                }

                                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                public final TextLayoutResultProxy invoke() {
                                                                                    return LegacyTextFieldState.this.getLayoutResult();
                                                                                }
                                                                            };
                                                                            composer4.updateRememberedValue(rememberedValue21);
                                                                        }
                                                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                        Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(heightInLines, textFieldScrollerPosition7, textFieldValue5, visualTransformation7, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester4);
                                                                        final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager5;
                                                                        final LegacyTextFieldState legacyTextFieldState9 = LegacyTextFieldState.this;
                                                                        final boolean z34 = z32;
                                                                        final boolean z35 = z33;
                                                                        final Function1<? super TextLayoutResult, Unit> function110 = function19;
                                                                        final TextFieldValue textFieldValue6 = textFieldValue4;
                                                                        final OffsetMapping offsetMapping7 = offsetMapping6;
                                                                        final Density density4 = density3;
                                                                        final int i52 = i50;
                                                                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.rememberComposableLambda(-1172467467, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                                invoke(composer5, num.intValue());
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            /* JADX WARN: Code restructure failed: missing block: B:30:0x00fa, code lost:
                                                                                if (r3 != false) goto L27;
                                                                             */
                                                                            /*
                                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                                            */
                                                                            public final void invoke(Composer composer5, int i53) {
                                                                                ComposerKt.sourceInformation(composer5, "C579@27389L3496,644@30903L358:CoreTextField.kt#423gt5");
                                                                                boolean z36 = true;
                                                                                if (!composer5.shouldExecute((i53 & 3) != 2, i53 & 1)) {
                                                                                    composer5.skipToGroupEnd();
                                                                                    return;
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(-1172467467, i53, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:579)");
                                                                                }
                                                                                final LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState9;
                                                                                final Function1<? super TextLayoutResult, Unit> function111 = function110;
                                                                                final TextFieldValue textFieldValue7 = textFieldValue6;
                                                                                final OffsetMapping offsetMapping8 = offsetMapping7;
                                                                                final Density density5 = density4;
                                                                                final int i54 = i52;
                                                                                MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                                    /* renamed from: measure-3p2s80s */
                                                                                    public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                                                        Snapshot.Companion companion9 = Snapshot.Companion;
                                                                                        LegacyTextFieldState legacyTextFieldState11 = LegacyTextFieldState.this;
                                                                                        Snapshot currentThreadSnapshot = companion9.getCurrentThreadSnapshot();
                                                                                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                                        Snapshot makeCurrentNonObservable = companion9.makeCurrentNonObservable(currentThreadSnapshot);
                                                                                        try {
                                                                                            TextLayoutResultProxy layoutResult = legacyTextFieldState11.getLayoutResult();
                                                                                            TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                            Triple<Integer, Integer, TextLayoutResult> m1156layout_EkL_Y$foundation_release = TextFieldDelegate.Companion.m1156layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                                            int intValue = m1156layout_EkL_Y$foundation_release.component1().intValue();
                                                                                            int intValue2 = m1156layout_EkL_Y$foundation_release.component2().intValue();
                                                                                            TextLayoutResult component3 = m1156layout_EkL_Y$foundation_release.component3();
                                                                                            if (!Intrinsics.areEqual(value, component3)) {
                                                                                                LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                                function111.invoke(component3);
                                                                                                CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue7, offsetMapping8);
                                                                                            }
                                                                                            LegacyTextFieldState.this.m1088setMinHeightForSingleLineField0680j_4(density5.mo386toDpu2uoSUM(i54 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                                            return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                                    invoke2(placementScope);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                        } finally {
                                                                                            companion9.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                                                        }
                                                                                    }

                                                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                                    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i55) {
                                                                                        LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                                        return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                                    }
                                                                                };
                                                                                ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, Modifier.Companion);
                                                                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                                                ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                                                    ComposablesKt.invalidApplier();
                                                                                }
                                                                                composer5.startReusableNode();
                                                                                if (composer5.getInserting()) {
                                                                                    composer5.createNode(constructor);
                                                                                } else {
                                                                                    composer5.useNode();
                                                                                }
                                                                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                                                                Updater.m3527setimpl(m3520constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                                }
                                                                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                                                ComposerKt.sourceInformationMarkerStart(composer5, -1679992992, "C:CoreTextField.kt#423gt5");
                                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                composer5.endNode();
                                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                                TextFieldSelectionManager textFieldSelectionManager7 = TextFieldSelectionManager.this;
                                                                                if (legacyTextFieldState9.getHandleState() != HandleState.None && legacyTextFieldState9.getLayoutCoordinates() != null) {
                                                                                    LayoutCoordinates layoutCoordinates = legacyTextFieldState9.getLayoutCoordinates();
                                                                                    Intrinsics.checkNotNull(layoutCoordinates);
                                                                                    if (layoutCoordinates.isAttached()) {
                                                                                    }
                                                                                }
                                                                                z36 = false;
                                                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager7, z36, composer5, 0);
                                                                                if (legacyTextFieldState9.getHandleState() == HandleState.Cursor && !z35 && z34) {
                                                                                    composer5.startReplaceGroup(-7167858);
                                                                                    ComposerKt.sourceInformation(composer5, "656@31423L40");
                                                                                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                                    composer5.endReplaceGroup();
                                                                                } else {
                                                                                    composer5.startReplaceGroup(-7090978);
                                                                                    composer5.endReplaceGroup();
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                        }, composer4, 54), composer4, 48, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }, composer3, 54), composer3, 6);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                    function32 = function3322;
                                                    i28 = i42;
                                                    composer2 = startRestartGroup;
                                                    function13 = function14;
                                                    imeOptions2 = imeOptions8;
                                                    textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                    mutableInteractionSource2 = mutableInteractionSource6;
                                                    brush2 = brush4;
                                                    z6 = z3022;
                                                    keyboardActions2 = keyboardActions4;
                                                    modifier2 = modifier5;
                                                    i29 = i4722;
                                                    z4 = z12;
                                                    z5 = z10;
                                                    textStyle2 = textStyle3;
                                                    visualTransformation2 = visualTransformation522;
                                                }
                                            }
                                            TextDelegate textDelegate = new TextDelegate(text, textStyle4, 0, 0, z24, 0, density, resolver2, null, 300, null);
                                            annotatedString = text;
                                            textStyle3 = textStyle4;
                                            z10 = z24;
                                            density = density;
                                            resolver = resolver2;
                                            rememberedValue15 = new LegacyTextFieldState(textDelegate, currentRecomposeScope, softwareKeyboardController);
                                            startRestartGroup.updateRememberedValue(rememberedValue15);
                                            legacyTextFieldState = (LegacyTextFieldState) rememberedValue15;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final Density density22 = density;
                                            legacyTextFieldState.m1091updatefnh65Uc(textFieldValue.getAnnotatedString(), annotatedString, textStyle3, z10, density22, resolver, function1, keyboardActions4, focusManager2, m1533getBackgroundColor0d7_KjU);
                                            legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705287551, "CC(remember):CoreTextField.kt#9igjgp");
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue != Composer.Companion.getEmpty()) {
                                            }
                                            UndoManager undoManager2 = (UndoManager) rememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            UndoManager.snapshotIfNeeded$default(undoManager2, textFieldValue, 0L, 2, null);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)558@25470L68:Effects.kt#9igjgp");
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -954203484, "CC(remember):Effects.kt#9igjgp");
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                            }
                                            final CoroutineScope coroutineScope2 = (CoroutineScope) rememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705282708, "CC(remember):CoreTextField.kt#9igjgp");
                                            rememberedValue3 = startRestartGroup.rememberedValue();
                                            MutableInteractionSource mutableInteractionSource62 = mutableInteractionSource4;
                                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                            }
                                            final BringIntoViewRequester bringIntoViewRequester22 = (BringIntoViewRequester) rememberedValue3;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705280870, "CC(remember):CoreTextField.kt#9igjgp");
                                            rememberedValue4 = startRestartGroup.rememberedValue();
                                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                            }
                                            final TextFieldSelectionManager textFieldSelectionManager22 = (TextFieldSelectionManager) rememberedValue4;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            textFieldSelectionManager22.setOffsetMapping$foundation_release(offsetMapping2);
                                            textFieldSelectionManager22.setVisualTransformation$foundation_release(visualTransformation3);
                                            textFieldSelectionManager22.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
                                            textFieldSelectionManager22.setState$foundation_release(legacyTextFieldState);
                                            textFieldSelectionManager22.setValue$foundation_release(textFieldValue);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume72 = startRestartGroup.consume(CompositionLocalsKt.getLocalClipboard());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            textFieldSelectionManager22.setClipboard$foundation_release((Clipboard) consume72);
                                            textFieldSelectionManager22.setCoroutineScope$foundation_release(coroutineScope2);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume82 = startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            textFieldSelectionManager22.setTextToolbar((TextToolbar) consume82);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume92 = startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            textFieldSelectionManager22.setHapticFeedBack((HapticFeedback) consume92);
                                            textFieldSelectionManager22.setFocusRequester(focusRequester2);
                                            textFieldSelectionManager22.setEditable(!z8);
                                            final boolean z262 = z7;
                                            textFieldSelectionManager22.setEnabled(z262);
                                            Modifier.Companion companion32 = Modifier.Companion;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705254736, "CC(remember):CoreTextField.kt#9igjgp");
                                            int i452 = i30 & 7168;
                                            int i462 = i30 & 57344;
                                            i34 = i30;
                                            boolean changedInstance92 = startRestartGroup.changedInstance(legacyTextFieldState) | (i452 != 2048) | (i462 != 16384) | startRestartGroup.changedInstance(textInputService3) | (i43 != 4);
                                            i35 = (i34 & 112) ^ 48;
                                            if (i35 > 32) {
                                            }
                                            legacyTextFieldState2 = legacyTextFieldState;
                                            if ((i34 & 48) != 32) {
                                            }
                                            z11 = true;
                                            changedInstance = changedInstance92 | z11 | startRestartGroup.changedInstance(offsetMapping2) | startRestartGroup.changedInstance(coroutineScope2) | startRestartGroup.changedInstance(bringIntoViewRequester22) | startRestartGroup.changedInstance(textFieldSelectionManager22);
                                            Object rememberedValue1622 = startRestartGroup.rememberedValue();
                                            if (!changedInstance) {
                                            }
                                            final ImeOptions imeOptions922 = imeOptions4;
                                            final boolean z2722 = z8;
                                            Function1 function1822 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                                    invoke2(focusState);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(FocusState focusState) {
                                                    TextLayoutResultProxy layoutResult;
                                                    if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                                        return;
                                                    }
                                                    LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                                                    if (!LegacyTextFieldState.this.getHasFocus() || !z262 || z2722) {
                                                        CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                                                    } else {
                                                        CoreTextFieldKt.startInputSession(textInputService3, LegacyTextFieldState.this, textFieldValue, imeOptions922, offsetMapping2);
                                                    }
                                                    if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester22, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping2, null), 3, null);
                                                    }
                                                    if (focusState.isFocused()) {
                                                        return;
                                                    }
                                                    TextFieldSelectionManager.m1519deselect_kEHs6E$foundation_release$default(textFieldSelectionManager22, null, 1, null);
                                                }
                                            };
                                            legacyTextFieldState3 = legacyTextFieldState2;
                                            z12 = z2722;
                                            textInputService = textInputService3;
                                            imeOptions5 = imeOptions922;
                                            offsetMapping = offsetMapping2;
                                            textFieldSelectionManager = textFieldSelectionManager22;
                                            bringIntoViewRequester = bringIntoViewRequester22;
                                            visualTransformation4 = visualTransformation3;
                                            str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                            z13 = z262;
                                            function15 = function1822;
                                            startRestartGroup.updateRememberedValue(function15);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier textFieldFocusModifier22 = TextFieldGestureModifiersKt.textFieldFocusModifier(companion32, z13, focusRequester2, mutableInteractionSource62, function15);
                                            State rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z13 || z12) ? false : true), startRestartGroup, 0);
                                            Unit unit22 = Unit.INSTANCE;
                                            final boolean z2822 = z13;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705201263, "CC(remember):CoreTextField.kt#9igjgp");
                                            boolean changed422 = startRestartGroup.changed(rememberUpdatedState22) | startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            TextInputService textInputService422 = textInputService;
                                            if (i35 > 32) {
                                            }
                                            imeOptions6 = imeOptions5;
                                            if ((i34 & 48) != 32) {
                                            }
                                            z14 = true;
                                            z15 = z14 | changed422;
                                            Object rememberedValue17222 = startRestartGroup.rememberedValue();
                                            if (z15) {
                                            }
                                            ImeOptions imeOptions10222 = imeOptions6;
                                            state = rememberUpdatedState22;
                                            textInputService2 = textInputService422;
                                            imeOptions7 = imeOptions10222;
                                            coreTextFieldKt$CoreTextField$2$1 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState3, rememberUpdatedState22, textInputService422, textFieldSelectionManager, imeOptions10222, null);
                                            startRestartGroup.updateRememberedValue(coreTextFieldKt$CoreTextField$2$1);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            imeOptions8 = imeOptions7;
                                            EffectsKt.LaunchedEffect(unit22, coreTextFieldKt$CoreTextField$2$1, startRestartGroup, 6);
                                            Modifier.Companion companion4222 = Modifier.Companion;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705168925, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState3);
                                            rememberedValue5 = startRestartGroup.rememberedValue();
                                            if (!changedInstance2) {
                                            }
                                            rememberedValue5 = (Function1) new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                    invoke(bool.booleanValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(boolean z29222) {
                                                    LegacyTextFieldState.this.setInTouchMode(z29222);
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue5);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier updateSelectionTouchMode222 = SelectionGesturesKt.updateSelectionTouchMode(companion4222, (Function1) rememberedValue5);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705164890, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance3 = (i462 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState3) | (i452 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            Object rememberedValue18222 = startRestartGroup.rememberedValue();
                                            if (changedInstance3) {
                                            }
                                            final OffsetMapping offsetMapping3222 = offsetMapping;
                                            final LegacyTextFieldState legacyTextFieldState5222 = legacyTextFieldState3;
                                            final TextFieldSelectionManager textFieldSelectionManager3222 = textFieldSelectionManager;
                                            final boolean z29222 = z12;
                                            focusRequester = focusRequester2;
                                            z16 = z2822;
                                            function16 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                    m1061invokek4lQ0M(offset.m3847unboximpl());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                                                public final void m1061invokek4lQ0M(long j) {
                                                    CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z29222);
                                                    if (LegacyTextFieldState.this.getHasFocus() && z2822) {
                                                        if (LegacyTextFieldState.this.getHandleState() != HandleState.Selection) {
                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                            if (layoutResult != null) {
                                                                LegacyTextFieldState legacyTextFieldState6222 = LegacyTextFieldState.this;
                                                                TextFieldDelegate.Companion.m1157setCursorOffsetULxng0E$foundation_release(j, layoutResult, legacyTextFieldState6222.getProcessor(), offsetMapping3222, legacyTextFieldState6222.getOnValueChange());
                                                                if (legacyTextFieldState6222.getTextDelegate().getText().length() > 0) {
                                                                    legacyTextFieldState6222.setHandleState(HandleState.Cursor);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        textFieldSelectionManager3222.m1522deselect_kEHs6E$foundation_release(Offset.m3826boximpl(j));
                                                    }
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(function16);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            FocusRequester focusRequester3222 = focusRequester;
                                            z17 = z16;
                                            State state2222 = state;
                                            Modifier pointerHoverIcon$default222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode222, mutableInteractionSource62, z16, function16), textFieldSelectionManager.getMouseSelectionObserver$foundation_release(), textFieldSelectionManager.getTouchSelectionObserver$foundation_release()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                            Modifier.Companion companion5222 = Modifier.Companion;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705124313, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState3) | (i43 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                            Object rememberedValue19222 = startRestartGroup.rememberedValue();
                                            if (changedInstance4) {
                                            }
                                            textFieldValue2 = textFieldValue;
                                            function17 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                    invoke2(drawScope);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(DrawScope drawScope) {
                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult != null) {
                                                        TextFieldValue textFieldValue3222 = textFieldValue2;
                                                        LegacyTextFieldState legacyTextFieldState6222 = LegacyTextFieldState.this;
                                                        OffsetMapping offsetMapping4222 = offsetMapping;
                                                        TextFieldDelegate.Companion.m1155drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue3222, legacyTextFieldState6222.m1086getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState6222.m1083getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping4222, layoutResult.getValue(), legacyTextFieldState6222.getHighlightPaint(), legacyTextFieldState6222.m1085getSelectionBackgroundColor0d7_KjU());
                                                    }
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(function17);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final Modifier drawBehind222 = DrawModifierKt.drawBehind(companion5222, function17);
                                            Modifier.Companion companion6222 = Modifier.Companion;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705102580, "CC(remember):CoreTextField.kt#9igjgp");
                                            windowInfo2 = windowInfo;
                                            changedInstance5 = (i452 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState3) | startRestartGroup.changed(windowInfo2) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i43 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                            rememberedValue6 = startRestartGroup.rememberedValue();
                                            if (changedInstance5) {
                                            }
                                            final OffsetMapping offsetMapping4222 = offsetMapping;
                                            final LegacyTextFieldState legacyTextFieldState6222 = legacyTextFieldState3;
                                            final TextFieldValue textFieldValue3222 = textFieldValue2;
                                            final TextFieldSelectionManager textFieldSelectionManager4222 = textFieldSelectionManager;
                                            z18 = z17;
                                            windowInfo3 = windowInfo2;
                                            rememberedValue6 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                    invoke2(layoutCoordinates);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                    LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult != null) {
                                                        layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                    }
                                                    if (z17) {
                                                        if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                            if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo2.isWindowFocused()) {
                                                                textFieldSelectionManager4222.showSelectionToolbar$foundation_release();
                                                            } else {
                                                                textFieldSelectionManager4222.hideSelectionToolbar$foundation_release();
                                                            }
                                                            LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager4222, true));
                                                            LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager4222, false));
                                                            LegacyTextFieldState.this.setShowCursorHandle(TextRange.m6141getCollapsedimpl(textFieldValue3222.m6396getSelectiond9O1mEE()));
                                                        } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                            LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager4222, true));
                                                        }
                                                        CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue3222, offsetMapping4222);
                                                        TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                                        if (layoutResult2 != null) {
                                                            LegacyTextFieldState legacyTextFieldState7 = LegacyTextFieldState.this;
                                                            TextFieldValue textFieldValue4 = textFieldValue3222;
                                                            OffsetMapping offsetMapping5222 = offsetMapping4222;
                                                            TextInputSession inputSession = legacyTextFieldState7.getInputSession();
                                                            if (inputSession == null || !legacyTextFieldState7.getHasFocus()) {
                                                                return;
                                                            }
                                                            TextFieldDelegate.Companion.updateTextLayoutResult$foundation_release(inputSession, textFieldValue4, offsetMapping5222, layoutResult2);
                                                        }
                                                    }
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue6);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final Modifier onGloballyPositioned322 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion6222, (Function1) rememberedValue6);
                                            final VisualTransformation visualTransformation5222 = visualTransformation4;
                                            CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier222 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState3, z12, z18, visualTransformation5222 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager, imeOptions8, focusRequester3222);
                                            final OffsetMapping offsetMapping5222 = offsetMapping;
                                            legacyTextFieldState4 = legacyTextFieldState3;
                                            Modifier cursor222 = TextFieldCursorKt.cursor(Modifier.Companion, legacyTextFieldState4, textFieldValue, offsetMapping5222, brush4, (z18 || z12 || !windowInfo3.isWindowFocused() || legacyTextFieldState3.hasHighlight()) ? false : true);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705033225, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance6 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                            Object rememberedValue20222 = startRestartGroup.rememberedValue();
                                            if (changedInstance6) {
                                            }
                                            rememberedValue20222 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                    final TextFieldSelectionManager textFieldSelectionManager5 = TextFieldSelectionManager.this;
                                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                        public void dispose() {
                                                            TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                                        }
                                                    };
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue20222);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1) rememberedValue20222, startRestartGroup, 0);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1705030115, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance7 = ((i35 <= 32 && startRestartGroup.changed(imeOptions8)) || (i34 & 48) == 32) | startRestartGroup.changedInstance(legacyTextFieldState4) | startRestartGroup.changedInstance(textInputService2) | (i43 != 4);
                                            rememberedValue7 = startRestartGroup.rememberedValue();
                                            if (!changedInstance7) {
                                            }
                                            rememberedValue7 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                    if (LegacyTextFieldState.this.getHasFocus()) {
                                                        LegacyTextFieldState.this.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(textInputService2, textFieldValue, LegacyTextFieldState.this.getProcessor(), imeOptions8, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                                    }
                                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                        public void dispose() {
                                                        }
                                                    };
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue7);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            EffectsKt.DisposableEffect(imeOptions8, (Function1) rememberedValue7, startRestartGroup, (i34 >> 3) & 14);
                                            final int i47222 = i33;
                                            Modifier m1164textFieldKeyInput2WJ9YEU222 = TextFieldKeyInputKt.m1164textFieldKeyInput2WJ9YEU(Modifier.Companion, legacyTextFieldState4, textFieldSelectionManager, textFieldValue, legacyTextFieldState4.getOnValueChange(), !z12, i47222 != 1, offsetMapping5222, undoManager2, imeOptions8.m6343getImeActioneUduSuo());
                                            if (KeyboardType.m6367equalsimpl0(imeOptions8.m6344getKeyboardTypePjHm6EE(), KeyboardType.Companion.m6386getPasswordPjHm6EE())) {
                                            }
                                            Modifier.Companion companion7222 = Modifier.Companion;
                                            boolean CoreTextField$lambda$11222 = CoreTextField$lambda$11(state2222);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1704991998, "CC(remember):CoreTextField.kt#9igjgp");
                                            final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter3222 = legacyPlatformTextInputServiceAdapter;
                                            changed = startRestartGroup.changed(z19) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter3222);
                                            rememberedValue8 = startRestartGroup.rememberedValue();
                                            if (!changed) {
                                            }
                                            rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
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
                                                    if (z19) {
                                                        legacyPlatformTextInputServiceAdapter3222.startStylusHandwriting();
                                                    }
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue8);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier stylusHandwriting222 = StylusHandwritingKt.stylusHandwriting(companion7222, CoreTextField$lambda$11222, z19, (Function0) rememberedValue8);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
                                            Object consume10222 = startRestartGroup.consume(AutofillHighlightKt.getLocalAutofillHighlightColor());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final long m4088unboximpl222 = ((Color) consume10222).m4088unboximpl();
                                            Modifier.Companion companion8222 = Modifier.Companion;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1704957026, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState4) | startRestartGroup.changed(m4088unboximpl222);
                                            rememberedValue9 = startRestartGroup.rememberedValue();
                                            if (!changedInstance8) {
                                            }
                                            rememberedValue9 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawDecorationModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                    invoke2(drawScope);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(DrawScope drawScope) {
                                                    if (LegacyTextFieldState.this.getAutofillHighlightOn() || LegacyTextFieldState.this.getJustAutofilled()) {
                                                        DrawScope.m4634drawRectnJ9OG0$default(drawScope, m4088unboximpl222, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
                                                    }
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue9);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier onGloballyPositioned2222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier5.then(DrawModifierKt.drawBehind(companion8222, (Function1) rememberedValue9)), legacyPlatformTextInputServiceAdapter3222, legacyTextFieldState4, textFieldSelectionManager).then(stylusHandwriting222).then(textFieldFocusModifier22), legacyTextFieldState4, focusManager), legacyTextFieldState4, textFieldSelectionManager).then(m1164textFieldKeyInput2WJ9YEU222), textFieldScrollerPosition5, mutableInteractionSource62, z18).then(pointerHoverIcon$default222).then(coreTextFieldSemanticsModifier222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                    invoke2(layoutCoordinates);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult == null) {
                                                        return;
                                                    }
                                                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                }
                                            });
                                            if (z18) {
                                            }
                                            if (!z20) {
                                            }
                                            final Modifier modifier6222 = modifier4;
                                            boolean z30222 = z18;
                                            final BringIntoViewRequester bringIntoViewRequester3222 = bringIntoViewRequester;
                                            final boolean z31222 = z12;
                                            final TextStyle textStyle5222 = textStyle3;
                                            final Modifier modifier7222 = companion2;
                                            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33222 = m1060getLambda1$foundation_release;
                                            CoreTextFieldRootBox(onGloballyPositioned2222, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-492537660, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i48) {
                                                    ComposerKt.sourceInformation(composer3, "C555@26133L5372,555@26119L5386:CoreTextField.kt#423gt5");
                                                    if (!composer3.shouldExecute((i48 & 3) != 2, i48 & 1)) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-492537660, i48, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:555)");
                                                    }
                                                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function34 = function33222;
                                                    final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState4;
                                                    final TextStyle textStyle6 = textStyle5222;
                                                    final int i49 = i42;
                                                    final int i50 = i47222;
                                                    final TextFieldScrollerPosition textFieldScrollerPosition6 = textFieldScrollerPosition5;
                                                    final TextFieldValue textFieldValue4 = textFieldValue;
                                                    final VisualTransformation visualTransformation6 = visualTransformation5222;
                                                    final Modifier modifier8 = modifier6222;
                                                    final Modifier modifier9 = drawBehind222;
                                                    final Modifier modifier10 = onGloballyPositioned322;
                                                    final Modifier modifier11 = modifier7222;
                                                    final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester3222;
                                                    final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                    final boolean z32 = z20;
                                                    final boolean z33 = z31222;
                                                    final Function1<? super TextLayoutResult, Unit> function19 = function14;
                                                    final OffsetMapping offsetMapping6 = offsetMapping5222;
                                                    final Density density3 = density22;
                                                    function34.invoke(ComposableLambdaKt.rememberComposableLambda(-1835647873, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                            invoke(composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i51) {
                                                            ComposerKt.sourceInformation(composer4, "C569@26984L22,578@27371L4124,578@27335L4160:CoreTextField.kt#423gt5");
                                                            if (composer4.shouldExecute((i51 & 3) != 2, i51 & 1)) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-1835647873, i51, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:558)");
                                                                }
                                                                Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m773heightInVpY3zN4$default(Modifier.Companion, LegacyTextFieldState.this.m1084getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i49, i50);
                                                                TextFieldScrollerPosition textFieldScrollerPosition7 = textFieldScrollerPosition6;
                                                                TextFieldValue textFieldValue5 = textFieldValue4;
                                                                VisualTransformation visualTransformation7 = visualTransformation6;
                                                                ComposerKt.sourceInformationMarkerStart(composer4, 713003803, "CC(remember):CoreTextField.kt#9igjgp");
                                                                boolean changedInstance10 = composer4.changedInstance(LegacyTextFieldState.this);
                                                                final LegacyTextFieldState legacyTextFieldState8 = LegacyTextFieldState.this;
                                                                Object rememberedValue21 = composer4.rememberedValue();
                                                                if (changedInstance10 || rememberedValue21 == Composer.Companion.getEmpty()) {
                                                                    rememberedValue21 = (Function0) new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final TextLayoutResultProxy invoke() {
                                                                            return LegacyTextFieldState.this.getLayoutResult();
                                                                        }
                                                                    };
                                                                    composer4.updateRememberedValue(rememberedValue21);
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                Modifier bringIntoViewRequester5 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScroll_androidKt.textFieldScroll(heightInLines, textFieldScrollerPosition7, textFieldValue5, visualTransformation7, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester4);
                                                                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager5;
                                                                final LegacyTextFieldState legacyTextFieldState9 = LegacyTextFieldState.this;
                                                                final boolean z34 = z32;
                                                                final boolean z35 = z33;
                                                                final Function1<? super TextLayoutResult, Unit> function110 = function19;
                                                                final TextFieldValue textFieldValue6 = textFieldValue4;
                                                                final OffsetMapping offsetMapping7 = offsetMapping6;
                                                                final Density density4 = density3;
                                                                final int i52 = i50;
                                                                SimpleLayoutKt.SimpleLayout(bringIntoViewRequester5, ComposableLambdaKt.rememberComposableLambda(-1172467467, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                        invoke(composer5, num.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    /* JADX WARN: Code restructure failed: missing block: B:30:0x00fa, code lost:
                                                                        if (r3 != false) goto L27;
                                                                     */
                                                                    /*
                                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                                    */
                                                                    public final void invoke(Composer composer5, int i53) {
                                                                        ComposerKt.sourceInformation(composer5, "C579@27389L3496,644@30903L358:CoreTextField.kt#423gt5");
                                                                        boolean z36 = true;
                                                                        if (!composer5.shouldExecute((i53 & 3) != 2, i53 & 1)) {
                                                                            composer5.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-1172467467, i53, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:579)");
                                                                        }
                                                                        final LegacyTextFieldState legacyTextFieldState10 = legacyTextFieldState9;
                                                                        final Function1<? super TextLayoutResult, Unit> function111 = function110;
                                                                        final TextFieldValue textFieldValue7 = textFieldValue6;
                                                                        final OffsetMapping offsetMapping8 = offsetMapping7;
                                                                        final Density density5 = density4;
                                                                        final int i54 = i52;
                                                                        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                            @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                            /* renamed from: measure-3p2s80s */
                                                                            public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                                                                Snapshot.Companion companion9 = Snapshot.Companion;
                                                                                LegacyTextFieldState legacyTextFieldState11 = LegacyTextFieldState.this;
                                                                                Snapshot currentThreadSnapshot = companion9.getCurrentThreadSnapshot();
                                                                                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                                Snapshot makeCurrentNonObservable = companion9.makeCurrentNonObservable(currentThreadSnapshot);
                                                                                try {
                                                                                    TextLayoutResultProxy layoutResult = legacyTextFieldState11.getLayoutResult();
                                                                                    TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                    Triple<Integer, Integer, TextLayoutResult> m1156layout_EkL_Y$foundation_release = TextFieldDelegate.Companion.m1156layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                                                                                    int intValue = m1156layout_EkL_Y$foundation_release.component1().intValue();
                                                                                    int intValue2 = m1156layout_EkL_Y$foundation_release.component2().intValue();
                                                                                    TextLayoutResult component3 = m1156layout_EkL_Y$foundation_release.component3();
                                                                                    if (!Intrinsics.areEqual(value, component3)) {
                                                                                        LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                        function111.invoke(component3);
                                                                                        CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue7, offsetMapping8);
                                                                                    }
                                                                                    LegacyTextFieldState.this.m1088setMinHeightForSingleLineField0680j_4(density5.mo386toDpu2uoSUM(i54 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                                    return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                            invoke2(placementScope);
                                                                                            return Unit.INSTANCE;
                                                                                        }
                                                                                    });
                                                                                } finally {
                                                                                    companion9.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                                                }
                                                                            }

                                                                            @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i55) {
                                                                                LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                                return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                            }
                                                                        };
                                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, Modifier.Companion);
                                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                                            ComposablesKt.invalidApplier();
                                                                        }
                                                                        composer5.startReusableNode();
                                                                        if (composer5.getInserting()) {
                                                                            composer5.createNode(constructor);
                                                                        } else {
                                                                            composer5.useNode();
                                                                        }
                                                                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer5);
                                                                        Updater.m3527setimpl(m3520constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                        }
                                                                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1679992992, "C:CoreTextField.kt#423gt5");
                                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                        composer5.endNode();
                                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                        TextFieldSelectionManager textFieldSelectionManager7 = TextFieldSelectionManager.this;
                                                                        if (legacyTextFieldState9.getHandleState() != HandleState.None && legacyTextFieldState9.getLayoutCoordinates() != null) {
                                                                            LayoutCoordinates layoutCoordinates = legacyTextFieldState9.getLayoutCoordinates();
                                                                            Intrinsics.checkNotNull(layoutCoordinates);
                                                                            if (layoutCoordinates.isAttached()) {
                                                                            }
                                                                        }
                                                                        z36 = false;
                                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager7, z36, composer5, 0);
                                                                        if (legacyTextFieldState9.getHandleState() == HandleState.Cursor && !z35 && z34) {
                                                                            composer5.startReplaceGroup(-7167858);
                                                                            ComposerKt.sourceInformation(composer5, "656@31423L40");
                                                                            CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                            composer5.endReplaceGroup();
                                                                        } else {
                                                                            composer5.startReplaceGroup(-7090978);
                                                                            composer5.endReplaceGroup();
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }, composer4, 54), composer4, 48, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }, composer3, 54), composer3, 6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, startRestartGroup, 54), startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            function32 = function33222;
                                            i28 = i42;
                                            composer2 = startRestartGroup;
                                            function13 = function14;
                                            imeOptions2 = imeOptions8;
                                            textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                            mutableInteractionSource2 = mutableInteractionSource62;
                                            brush2 = brush4;
                                            z6 = z30222;
                                            keyboardActions2 = keyboardActions4;
                                            modifier2 = modifier5;
                                            i29 = i47222;
                                            z4 = z12;
                                            z5 = z10;
                                            textStyle2 = textStyle3;
                                            visualTransformation2 = visualTransformation5222;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            i28 = i2;
                                            keyboardActions2 = keyboardActions;
                                            z4 = z3;
                                            function32 = function3;
                                            textFieldScrollerPosition2 = textFieldScrollerPosition;
                                            composer2 = startRestartGroup;
                                            brush2 = solidColor;
                                            mutableInteractionSource2 = obj2;
                                            function13 = coreTextFieldKt$CoreTextField$1;
                                            textStyle2 = obj;
                                            modifier2 = companion;
                                            visualTransformation2 = visualTransformation;
                                            z5 = z;
                                            i29 = i;
                                            imeOptions2 = imeOptions;
                                            z6 = z2;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i48) {
                                                    CoreTextFieldKt.CoreTextField(TextFieldValue.this, function1, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush2, z5, i29, i28, imeOptions2, keyboardActions2, z6, z4, function32, textFieldScrollerPosition2, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i26 = i5 & 32768;
                                if (i26 == 0) {
                                }
                                i27 = i5 & 65536;
                                if (i27 == 0) {
                                }
                                if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 599187) != 599186, i6 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i16 = i15;
                            i17 = i5 & 1024;
                            if (i17 != 0) {
                            }
                            if ((i4 & 48) == 0) {
                            }
                            int i372 = i19;
                            i20 = i5 & 4096;
                            if (i20 != 0) {
                            }
                            i22 = i5 & 8192;
                            if (i22 != 0) {
                            }
                            i24 = i5 & 16384;
                            if (i24 != 0) {
                            }
                            i26 = i5 & 32768;
                            if (i26 == 0) {
                            }
                            i27 = i5 & 65536;
                            if (i27 == 0) {
                            }
                            if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 599187) != 599186, i6 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i14 = i13;
                        i15 = i5 & 512;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        i17 = i5 & 1024;
                        if (i17 != 0) {
                        }
                        if ((i4 & 48) == 0) {
                        }
                        int i3722 = i19;
                        i20 = i5 & 4096;
                        if (i20 != 0) {
                        }
                        i22 = i5 & 8192;
                        if (i22 != 0) {
                        }
                        i24 = i5 & 16384;
                        if (i24 != 0) {
                        }
                        i26 = i5 & 32768;
                        if (i26 == 0) {
                        }
                        i27 = i5 & 65536;
                        if (i27 == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 599187) != 599186, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i5 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i5 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i5 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i5 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i5 & 512;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    i17 = i5 & 1024;
                    if (i17 != 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    int i37222 = i19;
                    i20 = i5 & 4096;
                    if (i20 != 0) {
                    }
                    i22 = i5 & 8192;
                    if (i22 != 0) {
                    }
                    i24 = i5 & 16384;
                    if (i24 != 0) {
                    }
                    i26 = i5 & 32768;
                    if (i26 == 0) {
                    }
                    i27 = i5 & 65536;
                    if (i27 == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 599187) != 599186, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj = textStyle;
                i9 = i5 & 16;
                if (i9 == 0) {
                }
                i10 = i5 & 32;
                if (i10 != 0) {
                }
                i11 = i5 & 64;
                if (i11 != 0) {
                }
                i12 = i5 & 128;
                if (i12 != 0) {
                }
                i13 = i5 & 256;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i5 & 512;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i5 & 1024;
                if (i17 != 0) {
                }
                if ((i4 & 48) == 0) {
                }
                int i372222 = i19;
                i20 = i5 & 4096;
                if (i20 != 0) {
                }
                i22 = i5 & 8192;
                if (i22 != 0) {
                }
                i24 = i5 & 16384;
                if (i24 != 0) {
                }
                i26 = i5 & 32768;
                if (i26 == 0) {
                }
                i27 = i5 & 65536;
                if (i27 == 0) {
                }
                if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 599187) != 599186, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            companion = modifier;
            i8 = i5 & 8;
            if (i8 != 0) {
            }
            obj = textStyle;
            i9 = i5 & 16;
            if (i9 == 0) {
            }
            i10 = i5 & 32;
            if (i10 != 0) {
            }
            i11 = i5 & 64;
            if (i11 != 0) {
            }
            i12 = i5 & 128;
            if (i12 != 0) {
            }
            i13 = i5 & 256;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i5 & 512;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i5 & 1024;
            if (i17 != 0) {
            }
            if ((i4 & 48) == 0) {
            }
            int i3722222 = i19;
            i20 = i5 & 4096;
            if (i20 != 0) {
            }
            i22 = i5 & 8192;
            if (i22 != 0) {
            }
            i24 = i5 & 16384;
            if (i24 != 0) {
            }
            i26 = i5 & 32768;
            if (i26 == 0) {
            }
            i27 = i5 & 65536;
            if (i27 == 0) {
            }
            if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 599187) != 599186, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i7 = i5 & 4;
        if (i7 == 0) {
        }
        companion = modifier;
        i8 = i5 & 8;
        if (i8 != 0) {
        }
        obj = textStyle;
        i9 = i5 & 16;
        if (i9 == 0) {
        }
        i10 = i5 & 32;
        if (i10 != 0) {
        }
        i11 = i5 & 64;
        if (i11 != 0) {
        }
        i12 = i5 & 128;
        if (i12 != 0) {
        }
        i13 = i5 & 256;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i5 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i5 & 1024;
        if (i17 != 0) {
        }
        if ((i4 & 48) == 0) {
        }
        int i37222222 = i19;
        i20 = i5 & 4096;
        if (i20 != 0) {
        }
        i22 = i5 & 8192;
        if (i22 != 0) {
        }
        i24 = i5 & 16384;
        if (i24 != 0) {
        }
        i26 = i5 & 32768;
        if (i26 == 0) {
        }
        i27 = i5 & 65536;
        if (i27 == 0) {
        }
        if (!startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (i25 & 599187) != 599186, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-20551815);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextFieldRootBox)P(2,1)669@31669L83:CoreTextField.kt#423gt5");
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
                ComposerKt.traceEventStart(-20551815, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:668)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1189059391, "C669@31717L33:CoreTextField.kt#423gt5");
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CoreTextFieldKt.CoreTextFieldRootBox(Modifier.this, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m1063invokeZmokQxo(keyEvent.m5158unboximpl());
            }

            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m1063invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z;
                if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1065cancelsTextSelectionZmokQxo(keyEvent)) {
                    z = true;
                    TextFieldSelectionManager.m1519deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
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
            FocusRequester.m3748requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        } else if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
        } else {
            keyboardController.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.setInputSession(TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession(null);
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        Rect rect;
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m6144getMaximpl(textFieldValue.m6396getSelectiond9O1mEE()));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
        int i2;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if (startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1018)");
            }
            if (z) {
                startRestartGroup.startReplaceGroup(-1290924834);
                ComposerKt.sourceInformation(startRestartGroup, "");
                LegacyTextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
                TextLayoutResult textLayoutResult = null;
                if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
                    if (!(state$foundation_release2 != null ? state$foundation_release2.isLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    startRestartGroup.startReplaceGroup(-1290601288);
                } else {
                    startRestartGroup.startReplaceGroup(-1290601287);
                    ComposerKt.sourceInformation(startRestartGroup, "");
                    if (!TextRange.m6141getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE())) {
                        startRestartGroup.startReplaceGroup(-1685230508);
                        ComposerKt.sourceInformation(startRestartGroup, "");
                        int originalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m6147getStartimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE()));
                        int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m6142getEndimpl(textFieldSelectionManager.getValue$foundation_release().m6396getSelectiond9O1mEE()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                        LegacyTextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
                        if (state$foundation_release3 != null && state$foundation_release3.getShowSelectionHandleStart()) {
                            startRestartGroup.startReplaceGroup(-1684812473);
                            ComposerKt.sourceInformation(startRestartGroup, "1034@46819L219");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, ((i2 << 6) & 896) | 6);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1684548198);
                            startRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
                        if (state$foundation_release4 != null && state$foundation_release4.getShowSelectionHandleEnd()) {
                            startRestartGroup.startReplaceGroup(-1684464312);
                            ComposerKt.sourceInformation(startRestartGroup, "1041@47170L218");
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, ((i2 << 6) & 896) | 6);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1684200998);
                            startRestartGroup.endReplaceGroup();
                        }
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-1684179174);
                        startRestartGroup.endReplaceGroup();
                    }
                    LegacyTextFieldState state$foundation_release5 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                            state$foundation_release5.setShowFloatingToolbar(false);
                        }
                        if (state$foundation_release5.getHasFocus()) {
                            if (state$foundation_release5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation_release();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(651160447);
                startRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CoreTextFieldKt.SelectionToolbarAndHandles(TextFieldSelectionManager.this, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        AnnotatedString transformedText$foundation_release;
        Composer startRestartGroup = composer.startRestartGroup(-1436003720);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle):CoreTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1065)");
            }
            LegacyTextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
            if (state$foundation_release != null && state$foundation_release.getShowCursorHandle() && (transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release()) != null && transformedText$foundation_release.length() > 0) {
                startRestartGroup.startReplaceGroup(-289940723);
                ComposerKt.sourceInformation(startRestartGroup, "1067@48332L50,1068@48445L7,1070@48505L12,1072@48590L645,1084@49267L385,1069@48462L1200");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -424995434, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changed = startRestartGroup.changed(textFieldSelectionManager);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final long m1524getCursorPositiontuRUvjQ$foundation_release = textFieldSelectionManager.m1524getCursorPositiontuRUvjQ$foundation_release((Density) consume);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -424989936, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed(m1524getCursorPositiontuRUvjQ$foundation_release);
                OffsetProvider rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0 */
                        public final long mo1042provideF1C5BW0() {
                            return m1524getCursorPositiontuRUvjQ$foundation_release;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier.Companion companion = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -424986583, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(textDragObserver) | startRestartGroup.changedInstance(textFieldSelectionManager);
                PointerInputEventHandler rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1

                        /* compiled from: CoreTextField.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1", f = "CoreTextField.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new C00191(this.$this_pointerInput, this.$observer, null), 1, null);
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_pointerInput, this.$manager, null), 1, null);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: CoreTextField.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1", f = "CoreTextField.kt", i = {}, l = {1078}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1  reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes.dex */
                            public static final class C00191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ TextDragObserver $observer;
                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00191(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation<? super C00191> continuation) {
                                    super(2, continuation);
                                    this.$this_pointerInput = pointerInputScope;
                                    this.$observer = textDragObserver;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00191(this.$this_pointerInput, this.$observer, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2", f = "CoreTextField.kt", i = {}, l = {1081}, m = "invokeSuspend", n = {}, s = {})
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
                                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle.2.1.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                m1062invokek4lQ0M(offset.m3847unboximpl());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                                            public final void m1062invokek4lQ0M(long j) {
                                                TextFieldSelectionManager.this.showSelectionToolbar$foundation_release();
                                            }
                                        }, this, 7, null) == coroutine_suspended) {
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
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -424965179, "CC(remember):CoreTextField.kt#9igjgp");
                boolean changed3 = startRestartGroup.changed(m1524getCursorPositiontuRUvjQ$foundation_release);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, m1524getCursorPositiontuRUvjQ$foundation_release, SelectionHandleAnchor.Middle, true, null));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidCursorHandle_androidKt.m1035CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue4, 1, null), 0L, startRestartGroup, 0, 4);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-288632802);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
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
            TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
            Unit unit = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
