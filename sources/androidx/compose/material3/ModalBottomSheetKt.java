package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* compiled from: ModalBottomSheet.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aË\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aÁ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0007¢\u0006\u0004\b\u001f\u0010 \u001aú\u0001\u0010!\u001a\u00020\u0001*\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\u001a2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\t2\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00142\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00160\u0003¢\u0006\u0002\b\u00142\u001c\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u001cH\u0001¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020%*\u0002012\u0006\u00102\u001a\u00020%H\u0002\u001a\u0014\u00103\u001a\u00020%*\u0002012\u0006\u00102\u001a\u00020%H\u0002\u001a-\u00104\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\u000b2\u0014\b\u0002\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u000b0\u001aH\u0007¢\u0006\u0002\u00108\u001a5\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0003¢\u0006\u0004\b=\u0010>\"\u0010\u0010?\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0004\n\u0002\u0010D¨\u0006E²\u0006\n\u0010F\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "sheetMaxWidth", "Landroidx/compose/ui/unit/Dp;", "sheetGesturesEnabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "properties", "Landroidx/compose/material3/ModalBottomSheetProperties;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-YbuCTN8", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheet-dYc4hso", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FLandroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ModalBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetContent", "Landroidx/compose/foundation/layout/BoxScope;", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "animateToDismiss", "settleToDismiss", "Lkotlin/ParameterName;", "name", "velocity", "ModalBottomSheetContent-7---e2Q", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/animation/core/Animatable;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;FZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "calculatePredictiveBackScaleY", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "Scrim", "color", "visible", "dismissEnabled", "Scrim-KTwxG1Y", "(JLkotlin/jvm/functions/Function0;ZZLandroidx/compose/runtime/Composer;I)V", "PredictiveBackMaxScaleXDistance", "F", "PredictiveBackMaxScaleYDistance", "PredictiveBackChildTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "material3", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ModalBottomSheetKt {
    private static final float PredictiveBackMaxScaleXDistance = Dp.m7555constructorimpl(48.0f);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m7555constructorimpl(24.0f);
    private static final long PredictiveBackChildTransformOrigin = TransformOriginKt.TransformOrigin(0.5f, 0.0f);

    /* compiled from: ModalBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$24(BoxScope boxScope, Animatable animatable, CoroutineScope coroutineScope, Function0 function0, Function1 function1, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, Function2 function2, Function2 function22, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m2252ModalBottomSheetContent7e2Q(boxScope, animatable, coroutineScope, function0, function1, modifier, sheetState, f, z, shape, j, j2, f2, function2, function22, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$13(Function0 function0, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, long j3, Function2 function2, Function2 function22, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m2250ModalBottomSheetYbuCTN8(function0, modifier, sheetState, f, z, shape, j, j2, f2, j3, function2, function22, modalBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_dYc4hso$lambda$14(Function0 function0, Modifier modifier, SheetState sheetState, float f, Shape shape, long j, long j2, float f2, long j3, Function2 function2, Function2 function22, ModalBottomSheetProperties modalBottomSheetProperties, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m2251ModalBottomSheetdYc4hso(function0, modifier, sheetState, f, shape, j, j2, f2, j3, function2, function22, modalBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Scrim_KTwxG1Y$lambda$34(long j, Function0 function0, boolean z, boolean z2, int i, Composer composer, int i2) {
        m2253ScrimKTwxG1Y(j, function0, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean rememberModalBottomSheetState$lambda$26$lambda$25(SheetValue sheetValue) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:322:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* renamed from: ModalBottomSheet-YbuCTN8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2250ModalBottomSheetYbuCTN8(final Function0<Unit> function0, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, long j3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function22, ModalBottomSheetProperties modalBottomSheetProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier.Companion companion;
        final SheetState sheetState2;
        int i5;
        float f3;
        int i6;
        boolean z2;
        Shape shape2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer composer2;
        final long j4;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function23;
        final ModalBottomSheetProperties modalBottomSheetProperties2;
        final float f4;
        final boolean z3;
        final Modifier modifier2;
        final SheetState sheetState3;
        final Shape shape3;
        final long j5;
        final float f5;
        final long j6;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        long j7;
        long j8;
        long j9;
        ModalBottomSheetKt$ModalBottomSheet$1 modalBottomSheetKt$ModalBottomSheet$1;
        float f6;
        ModalBottomSheetProperties modalBottomSheetProperties3;
        Function2<? super Composer, ? super Integer, ? extends WindowInsets> function25;
        float f7;
        long j10;
        boolean z4;
        Modifier modifier3;
        Shape shape4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        long j11;
        long j12;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1904798512);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,contentWindowInsets,properties,content)140@7306L7,141@7400L7,142@7491L7,144@7515L174,144@7504L185,149@7706L24,150@7770L327,161@8151L149,167@8335L42,172@8504L708,184@9277L883,169@8383L1777:ModalBottomSheet.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i16 = i3 & 2;
        if (i16 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    sheetState2 = sheetState;
                    if (startRestartGroup.changed(sheetState2)) {
                        i15 = 256;
                        i4 |= i15;
                    }
                } else {
                    sheetState2 = sheetState;
                }
                i15 = 128;
                i4 |= i15;
            } else {
                sheetState2 = sheetState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                f3 = f;
                i4 |= startRestartGroup.changed(f3) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    z2 = z;
                    i4 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        shape2 = shape;
                        i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(shape2)) ? 131072 : 65536;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        i7 = i4 | (((i3 & 128) == 0 && startRestartGroup.changed(j2)) ? 8388608 : 4194304);
                    } else {
                        i7 = i4;
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i7 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i7 |= startRestartGroup.changed(f2) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        i7 |= ((i3 & 512) == 0 && startRestartGroup.changed(j3)) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    }
                    i9 = i3 & 1024;
                    if (i9 == 0) {
                        i11 = i2 | 6;
                        i10 = i9;
                    } else if ((i2 & 6) == 0) {
                        i10 = i9;
                        i11 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
                    } else {
                        i10 = i9;
                        i11 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i3 & 2048) == 0 && startRestartGroup.changedInstance(function22)) {
                            i14 = 32;
                            i11 |= i14;
                        }
                        i14 = 16;
                        i11 |= i14;
                    }
                    int i17 = i11;
                    i12 = i3 & 4096;
                    if (i12 == 0) {
                        i13 = i17 | RendererCapabilities.DECODER_SUPPORT_MASK;
                    } else {
                        int i18 = i17;
                        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i18 |= startRestartGroup.changed(modalBottomSheetProperties) ? 256 : 128;
                        }
                        i13 = i18;
                    }
                    if ((i3 & 8192) == 0) {
                        i13 |= 3072;
                    } else if ((i2 & 3072) == 0) {
                        i13 |= startRestartGroup.changedInstance(function3) ? 2048 : 1024;
                        if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i13 & 1171) != 1170, i7 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "125@6423L31,128@6596L13,129@6659L14,130@6701L31,132@6809L10");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i7 &= -897;
                                }
                                if ((i3 & 32) != 0) {
                                    i7 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i7 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i7 &= -29360129;
                                }
                                if ((i3 & 512) != 0) {
                                    i7 &= -1879048193;
                                }
                                if ((i3 & 2048) != 0) {
                                    i13 &= -113;
                                }
                                j10 = j;
                                j11 = j2;
                                f7 = f2;
                                j12 = j3;
                                function26 = function2;
                                function25 = function22;
                                modalBottomSheetProperties3 = modalBottomSheetProperties;
                                f6 = f3;
                                z4 = z2;
                                modifier3 = companion;
                                shape4 = shape2;
                            } else {
                                if (i16 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 4) != 0) {
                                    i7 &= -897;
                                    sheetState2 = rememberModalBottomSheetState(false, null, startRestartGroup, 0, 3);
                                }
                                float m1749getSheetMaxWidthD9Ej5fM = i5 != 0 ? BottomSheetDefaults.INSTANCE.m1749getSheetMaxWidthD9Ej5fM() : f3;
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 32) != 0) {
                                    i7 &= -458753;
                                    shape2 = BottomSheetDefaults.INSTANCE.getExpandedShape(startRestartGroup, 6);
                                }
                                if ((i3 & 64) != 0) {
                                    j7 = BottomSheetDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                    i7 &= -3670017;
                                } else {
                                    j7 = j;
                                }
                                if ((i3 & 128) != 0) {
                                    j8 = ColorSchemeKt.m1902contentColorForek8zF_U(j7, startRestartGroup, (i7 >> 18) & 14);
                                    i7 &= -29360129;
                                } else {
                                    j8 = j2;
                                }
                                float m7555constructorimpl = i8 != 0 ? Dp.m7555constructorimpl(0.0f) : f2;
                                if ((i3 & 512) != 0) {
                                    j9 = BottomSheetDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                    i7 &= -1879048193;
                                } else {
                                    j9 = j3;
                                }
                                Function2<Composer, Integer, Unit> lambda$1121996006$material3 = i10 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1121996006$material3() : function2;
                                if ((i3 & 2048) != 0) {
                                    modalBottomSheetKt$ModalBottomSheet$1 = new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$1
                                        public final WindowInsets invoke(Composer composer3, int i19) {
                                            composer3.startReplaceGroup(-511854661);
                                            ComposerKt.sourceInformation(composer3, "C134@6983L12:ModalBottomSheet.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-511854661, i19, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:134)");
                                            }
                                            WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceGroup();
                                            return windowInsets;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer3, Integer num) {
                                            return invoke(composer3, num.intValue());
                                        }
                                    };
                                    i13 &= -113;
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$1 = function22;
                                }
                                int i19 = i13;
                                if (i12 != 0) {
                                    f6 = m1749getSheetMaxWidthD9Ej5fM;
                                    modalBottomSheetProperties3 = new ModalBottomSheetProperties(false, false, 3, (DefaultConstructorMarker) null);
                                    function25 = modalBottomSheetKt$ModalBottomSheet$1;
                                    f7 = m7555constructorimpl;
                                    j10 = j7;
                                    z4 = z2;
                                    modifier3 = companion;
                                    shape4 = shape2;
                                    function26 = lambda$1121996006$material3;
                                    j11 = j8;
                                    j12 = j9;
                                    i13 = i19;
                                } else {
                                    f6 = m1749getSheetMaxWidthD9Ej5fM;
                                    modalBottomSheetProperties3 = modalBottomSheetProperties;
                                    function25 = modalBottomSheetKt$ModalBottomSheet$1;
                                    f7 = m7555constructorimpl;
                                    j10 = j7;
                                    z4 = z2;
                                    modifier3 = companion;
                                    shape4 = shape2;
                                    function26 = lambda$1121996006$material3;
                                    j11 = j8;
                                    j12 = j9;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1904798512, i7, i13, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:137)");
                            }
                            final FiniteAnimationSpec value = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
                            final FiniteAnimationSpec value2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
                            final FiniteAnimationSpec value3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, startRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 855342110, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            int i20 = (i7 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                            boolean changedInstance = ((i20 > 256 && startRestartGroup.changed(sheetState2)) || (i7 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(value2) | startRestartGroup.changedInstance(value3) | startRestartGroup.changedInstance(value);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$1$lambda$0(SheetState.this, value2, value3, value);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 855350423, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            int i21 = i7 & 14;
                            boolean changedInstance2 = ((i20 > 256 && startRestartGroup.changed(sheetState2)) || (i7 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(coroutineScope) | (i21 == 4);
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$lambda$3(SheetState.this, coroutineScope, function0);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            Function0 function02 = rememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 855362437, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean changedInstance3 = startRestartGroup.changedInstance(coroutineScope) | ((i20 > 256 && startRestartGroup.changed(sheetState2)) || (i7 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | (i21 == 4);
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (changedInstance3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7$lambda$6(CoroutineScope.this, sheetState2, function0, ((Float) obj).floatValue());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            Function1 function1 = rememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 855368218, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            final Animatable animatable = (Animatable) rememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 855374292, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean changedInstance4 = (i21 == 4) | ((i20 > 256 && startRestartGroup.changed(sheetState2)) || (i7 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(animatable);
                            Object rememberedValue6 = startRestartGroup.rememberedValue();
                            if (changedInstance4 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$11$lambda$10(SheetState.this, coroutineScope, animatable, function0);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ModalBottomSheet_androidKt.m2256ModalBottomSheetDialogsW7UJKQ((Function0) rememberedValue6, j11, modalBottomSheetProperties3, animatable, ComposableLambdaKt.rememberComposableLambda(1010026864, true, new ModalBottomSheetKt$ModalBottomSheet$4(j12, function02, sheetState2, modalBottomSheetProperties3, animatable, coroutineScope, function1, modifier3, f6, z4, shape4, j10, j11, f7, function26, function25, function3), startRestartGroup, 54), startRestartGroup, (i13 & 896) | ((i7 >> 18) & 112) | 24576 | (Animatable.$stable << 9));
                            composer2 = startRestartGroup;
                            if (sheetState2.getHasExpandedState()) {
                                composer2.startReplaceGroup(748459762);
                                ComposerKt.sourceInformation(composer2, "212@10235L21,212@10208L48");
                                ComposerKt.sourceInformationMarkerStart(composer2, 855428997, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                boolean z5 = (i20 > 256 && composer2.changed(sheetState2)) || (i7 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                                ModalBottomSheetKt$ModalBottomSheet$5$1 rememberedValue7 = composer2.rememberedValue();
                                if (z5 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                    rememberedValue7 = new ModalBottomSheetKt$ModalBottomSheet$5$1(sheetState2, null);
                                    composer2.updateRememberedValue(rememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                EffectsKt.LaunchedEffect(sheetState2, (Function2) rememberedValue7, composer2, (i7 >> 6) & 14);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(748521266);
                                composer2.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sheetState3 = sheetState2;
                            j6 = j12;
                            modalBottomSheetProperties2 = modalBottomSheetProperties3;
                            modifier2 = modifier3;
                            f4 = f6;
                            z3 = z4;
                            shape3 = shape4;
                            j4 = j10;
                            j5 = j11;
                            f5 = f7;
                            function24 = function26;
                            function23 = function25;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            j4 = j;
                            function23 = function22;
                            modalBottomSheetProperties2 = modalBottomSheetProperties;
                            f4 = f3;
                            z3 = z2;
                            modifier2 = companion;
                            sheetState3 = sheetState2;
                            shape3 = shape2;
                            j5 = j2;
                            f5 = f2;
                            j6 = j3;
                            function24 = function2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$13(Function0.this, modifier2, sheetState3, f4, z3, shape3, j4, j5, f5, j6, function24, function23, modalBottomSheetProperties2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i13 & 1171) != 1170, i7 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z2 = z;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i9 = i3 & 1024;
                if (i9 == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i172 = i11;
                i12 = i3 & 4096;
                if (i12 == 0) {
                }
                if ((i3 & 8192) == 0) {
                }
                if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i13 & 1171) != 1170, i7 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f3 = f;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z2 = z;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i9 = i3 & 1024;
            if (i9 == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i1722 = i11;
            i12 = i3 & 4096;
            if (i12 == 0) {
            }
            if ((i3 & 8192) == 0) {
            }
            if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i13 & 1171) != 1170, i7 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        f3 = f;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z2 = z;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i9 = i3 & 1024;
        if (i9 == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i17222 = i11;
        i12 = i3 & 4096;
        if (i12 == 0) {
        }
        if ((i3 & 8192) == 0) {
        }
        if (startRestartGroup.shouldExecute((i7 & 306783379) == 306783378 || (i13 & 1171) != 1170, i7 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$1$lambda$0(SheetState sheetState, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        sheetState.setShowMotionSpec$material3(finiteAnimationSpec);
        sheetState.setHideMotionSpec$material3(finiteAnimationSpec2);
        sheetState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3(final SheetState sheetState, CoroutineScope coroutineScope, final Function0 function0) {
        Job launch$default;
        if (sheetState.getAnchoredDraggableState$material3().getConfirmValueChange$material3().invoke(SheetValue.Hidden).booleanValue()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$animateToDismiss$1$1$1(sheetState, null), 3, null);
            launch$default.invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(SheetState.this, function0, (Throwable) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$4$lambda$3$lambda$2(SheetState sheetState, Function0 function0, Throwable th) {
        if (!sheetState.isVisible()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6(CoroutineScope coroutineScope, final SheetState sheetState, final Function0 function0, float f) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$settleToDismiss$1$1$1(sheetState, f, null), 3, null);
        launch$default.invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(SheetState.this, function0, (Throwable) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$7$lambda$6$lambda$5(SheetState sheetState, Function0 function0, Throwable th) {
        if (!sheetState.isVisible()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10(SheetState sheetState, CoroutineScope coroutineScope, Animatable animatable, final Function0 function0) {
        Job launch$default;
        if (sheetState.getCurrentValue() != SheetValue.Expanded || !sheetState.getHasPartiallyExpandedState()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$3(sheetState, null), 3, null);
            launch$default.invokeOnCompletion(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetKt.ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(Function0.this, (Throwable) obj);
                }
            });
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$1(animatable, null), 3, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ModalBottomSheetKt$ModalBottomSheet$3$1$2(sheetState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheet_YbuCTN8$lambda$11$lambda$10$lambda$9(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for Binary compatibility. Use overload with sheetGesturesEnabled param.")
    /* renamed from: ModalBottomSheet-dYc4hso  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2251ModalBottomSheetdYc4hso(final Function0 function0, Modifier modifier, SheetState sheetState, float f, Shape shape, long j, long j2, float f2, long j3, Function2 function2, Function2 function22, ModalBottomSheetProperties modalBottomSheetProperties, final Function3 function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier.Companion companion;
        Object obj;
        int i5;
        Object obj2;
        long j4;
        long j5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final float f3;
        ModalBottomSheetProperties modalBottomSheetProperties2;
        final Shape shape2;
        final long j6;
        final SheetState sheetState2;
        final long j7;
        final float f4;
        long j8;
        final Function2 function23;
        final Function2 function24;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        long j9;
        long j10;
        ModalBottomSheetKt$ModalBottomSheet$7 modalBottomSheetKt$ModalBottomSheet$7;
        Function2 function25;
        Shape shape4;
        Modifier modifier2;
        float f5;
        Function2 function26;
        SheetState sheetState3;
        long j11;
        float f6;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(953901324);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalBottomSheet)N(onDismissRequest,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,scrimColor:c#ui.graphics.Color,dragHandle,contentWindowInsets,properties,content)237@11249L525:ModalBottomSheet.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i16 = i3 & 2;
        if (i16 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i3 & 4) == 0) {
                    obj = sheetState;
                    if (startRestartGroup.changed(obj)) {
                        i15 = 256;
                        i4 |= i15;
                    }
                } else {
                    obj = sheetState;
                }
                i15 = 128;
                i4 |= i15;
            } else {
                obj = sheetState;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(f) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        obj2 = shape;
                        if (startRestartGroup.changed(obj2)) {
                            i14 = 16384;
                            i4 |= i14;
                        }
                    } else {
                        obj2 = shape;
                    }
                    i14 = 8192;
                    i4 |= i14;
                } else {
                    obj2 = shape;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    j4 = j;
                    i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(j4)) ? 131072 : 65536;
                } else {
                    j4 = j;
                }
                if ((i & 1572864) == 0) {
                    j5 = j2;
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j5)) ? 1048576 : 524288;
                } else {
                    j5 = j2;
                }
                i6 = i3 & 128;
                if (i6 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                if ((i & 100663296) == 0) {
                    i4 |= ((i3 & 256) == 0 && startRestartGroup.changed(j3)) ? 67108864 : 33554432;
                }
                i7 = i3 & 512;
                if (i7 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i8 = i7;
                    i4 |= startRestartGroup.changedInstance(function2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0 && startRestartGroup.changedInstance(function22)) {
                            i13 = 4;
                            i9 = i2 | i13;
                        }
                        i13 = 2;
                        i9 = i2 | i13;
                    } else {
                        i9 = i2;
                    }
                    i10 = i3 & 2048;
                    if (i10 == 0) {
                        i9 |= 48;
                        i11 = i10;
                    } else if ((i2 & 48) == 0) {
                        i11 = i10;
                        i9 |= startRestartGroup.changed(modalBottomSheetProperties) ? 32 : 16;
                    } else {
                        i11 = i10;
                    }
                    i12 = i9;
                    if ((i3 & 4096) == 0) {
                        i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                    } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                        i12 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 147) != 146, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "225@10576L31,227@10707L13,228@10770L14,229@10812L31,231@10920L10");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                if ((i3 & 1024) != 0) {
                                    i12 &= -15;
                                }
                                function26 = function2;
                                function25 = function22;
                                modalBottomSheetProperties2 = modalBottomSheetProperties;
                                shape4 = obj2;
                                modifier2 = companion;
                                sheetState3 = obj;
                                j11 = j5;
                                f5 = f;
                                f6 = f2;
                                j8 = j3;
                            } else {
                                if (i16 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                    obj = rememberModalBottomSheetState(false, null, startRestartGroup, 0, 3);
                                }
                                float m1749getSheetMaxWidthD9Ej5fM = i5 != 0 ? BottomSheetDefaults.INSTANCE.m1749getSheetMaxWidthD9Ej5fM() : f;
                                if ((i3 & 16) != 0) {
                                    shape3 = BottomSheetDefaults.INSTANCE.getExpandedShape(startRestartGroup, 6);
                                    i4 &= -57345;
                                } else {
                                    shape3 = obj2;
                                }
                                if ((i3 & 32) != 0) {
                                    j9 = BottomSheetDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                    i4 &= -458753;
                                } else {
                                    j9 = j4;
                                }
                                if ((i3 & 64) != 0) {
                                    j5 = ColorSchemeKt.m1902contentColorForek8zF_U(j9, startRestartGroup, (i4 >> 15) & 14);
                                    i4 &= -3670017;
                                }
                                float m7555constructorimpl = i6 != 0 ? Dp.m7555constructorimpl(0.0f) : f2;
                                if ((i3 & 256) != 0) {
                                    j10 = BottomSheetDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                    i4 = (-234881025) & i4;
                                } else {
                                    j10 = j3;
                                }
                                Function2<Composer, Integer, Unit> m1939getLambda$655173438$material3 = i8 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.m1939getLambda$655173438$material3() : function2;
                                if ((i3 & 1024) != 0) {
                                    modalBottomSheetKt$ModalBottomSheet$7 = new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheet$7
                                        public final WindowInsets invoke(Composer composer3, int i17) {
                                            composer3.startReplaceGroup(69134487);
                                            ComposerKt.sourceInformation(composer3, "C233@11094L12:ModalBottomSheet.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(69134487, i17, -1, "androidx.compose.material3.ModalBottomSheet.<anonymous> (ModalBottomSheet.kt:233)");
                                            }
                                            WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceGroup();
                                            return windowInsets;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer3, Integer num) {
                                            return invoke(composer3, num.intValue());
                                        }
                                    };
                                    i12 &= -15;
                                } else {
                                    modalBottomSheetKt$ModalBottomSheet$7 = function22;
                                }
                                modalBottomSheetProperties2 = i11 != 0 ? ModalBottomSheetDefaults.INSTANCE.getProperties() : modalBottomSheetProperties;
                                function25 = modalBottomSheetKt$ModalBottomSheet$7;
                                j4 = j9;
                                shape4 = shape3;
                                modifier2 = companion;
                                float f7 = m7555constructorimpl;
                                f5 = m1749getSheetMaxWidthD9Ej5fM;
                                function26 = m1939getLambda$655173438$material3;
                                sheetState3 = obj;
                                j11 = j5;
                                j8 = j10;
                                f6 = f7;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(953901324, i4, i12, "androidx.compose.material3.ModalBottomSheet (ModalBottomSheet.kt:237)");
                            }
                            int i17 = i4 << 3;
                            int i18 = i12 << 3;
                            composer2 = startRestartGroup;
                            m2250ModalBottomSheetYbuCTN8(function0, modifier2, sheetState3, f5, true, shape4, j4, j11, f6, j8, function26, function25, modalBottomSheetProperties2, function3, composer2, (i4 & 14) | 24576 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i17 & 458752) | (i17 & 3670016) | (i17 & 29360128) | (i17 & 234881024) | (i17 & 1879048192), ((i4 >> 27) & 14) | (i18 & 112) | (i18 & 896) | (i18 & 7168), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            long j12 = j11;
                            companion = modifier2;
                            shape2 = shape4;
                            j7 = j12;
                            sheetState2 = sheetState3;
                            f3 = f5;
                            j6 = j4;
                            f4 = f6;
                            function23 = function26;
                            function24 = function25;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            f3 = f;
                            modalBottomSheetProperties2 = modalBottomSheetProperties;
                            shape2 = obj2;
                            j6 = j4;
                            sheetState2 = obj;
                            j7 = j5;
                            f4 = f2;
                            j8 = j3;
                            function23 = function2;
                            function24 = function22;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final ModalBottomSheetProperties modalBottomSheetProperties3 = modalBottomSheetProperties2;
                            final Modifier modifier3 = companion;
                            final long j13 = j8;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return ModalBottomSheetKt.ModalBottomSheet_dYc4hso$lambda$14(Function0.this, modifier3, sheetState2, f3, shape2, j6, j7, f4, j13, function23, function24, modalBottomSheetProperties3, function3, i, i2, i3, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 147) != 146, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i7;
                if ((i2 & 6) != 0) {
                }
                i10 = i3 & 2048;
                if (i10 == 0) {
                }
                i12 = i9;
                if ((i3 & 4096) == 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 147) != 146, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i & 24576) == 0) {
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i6 = i3 & 128;
            if (i6 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i7 = i3 & 512;
            if (i7 != 0) {
            }
            i8 = i7;
            if ((i2 & 6) != 0) {
            }
            i10 = i3 & 2048;
            if (i10 == 0) {
            }
            i12 = i9;
            if ((i3 & 4096) == 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 147) != 146, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i6 = i3 & 128;
        if (i6 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i7 = i3 & 512;
        if (i7 != 0) {
        }
        i8 = i7;
        if ((i2 & 6) != 0) {
        }
        i10 = i3 & 2048;
        if (i10 == 0) {
        }
        i12 = i9;
        if ((i3 & 4096) == 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 147) != 146, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:322:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0109  */
    /* renamed from: ModalBottomSheetContent-7---e2Q  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2252ModalBottomSheetContent7e2Q(final BoxScope boxScope, final Animatable<Float, AnimationVector1D> animatable, final CoroutineScope coroutineScope, final Function0<Unit> function0, final Function1<? super Float, Unit> function1, Modifier modifier, SheetState sheetState, float f, boolean z, Shape shape, long j, long j2, float f2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function22, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Modifier.Companion companion;
        final SheetState sheetState2;
        int i6;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        float f3;
        int i12;
        int i13;
        final float f4;
        final Shape shape2;
        final float f5;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final SheetState sheetState3;
        final Modifier modifier2;
        final boolean z3;
        Composer composer2;
        final long j3;
        final long j4;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function24;
        ScopeUpdateScope endRestartGroup;
        int i14;
        Shape shape3;
        long j5;
        long j6;
        Function2<Composer, Integer, Unit> lambda$1716959002$material3;
        Shape shape4;
        long j7;
        ModalBottomSheetKt$ModalBottomSheetContent$1 modalBottomSheetKt$ModalBottomSheetContent$1;
        Modifier modifier3;
        int i15;
        float f6;
        float f7;
        Shape shape5;
        float f8;
        long j8;
        Modifier.Companion companion2;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-37400432);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalBottomSheetContent)N(predictiveBackProgress,scope,animateToDismiss,settleToDismiss,modifier,sheetState,sheetMaxWidth:c#ui.unit.Dp,sheetGesturesEnabled,shape,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,dragHandle,contentWindowInsets,content)273@12729L48,294@13641L1602,331@15615L23,333@15685L112,338@15930L612,358@17107L4293,275@12783L8617:ModalBottomSheet.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i3) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= (i & 64) == 0 ? startRestartGroup.changed(animatable) : startRestartGroup.changedInstance(animatable) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(coroutineScope) ? 256 : 128;
            if ((i3 & 4) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                obj = function0;
                i4 |= startRestartGroup.changedInstance(obj) ? 2048 : 1024;
                int i18 = 8192;
                if ((i3 & 8) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
                }
                i5 = i3 & 16;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    companion = modifier;
                } else {
                    companion = modifier;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changed(companion) ? 131072 : 65536;
                    }
                }
                if ((i & 1572864) == 0) {
                    sheetState2 = sheetState;
                    i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(sheetState2)) ? 1048576 : 524288;
                } else {
                    sheetState2 = sheetState;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 100663296;
                    z2 = z;
                } else {
                    z2 = z;
                    if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                    }
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & 256) == 0 && startRestartGroup.changed(shape)) {
                        i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                        i4 |= i17;
                    }
                    i17 = 268435456;
                    i4 |= i17;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 512) == 0) {
                        i8 = i4;
                        if (startRestartGroup.changed(j)) {
                            i16 = 4;
                            i9 = i2 | i16;
                        }
                    } else {
                        i8 = i4;
                    }
                    i16 = 2;
                    i9 = i2 | i16;
                } else {
                    i8 = i4;
                    i9 = i2;
                }
                if ((i2 & 48) == 0) {
                    i10 = i8;
                    i9 |= ((i3 & 1024) == 0 && startRestartGroup.changed(j2)) ? 32 : 16;
                } else {
                    i10 = i8;
                }
                int i19 = i9;
                i11 = i3 & 2048;
                if (i11 != 0) {
                    i19 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    f3 = f2;
                    i19 |= startRestartGroup.changed(f3) ? 256 : 128;
                    i12 = i3 & 4096;
                    if (i12 == 0) {
                        i13 = i19 | 3072;
                    } else {
                        int i20 = i19;
                        if ((i2 & 3072) == 0) {
                            i13 = i20 | (startRestartGroup.changedInstance(function2) ? 2048 : 1024);
                        } else {
                            i13 = i20;
                        }
                    }
                    if ((i2 & 24576) == 0) {
                        if ((i3 & 8192) == 0 && startRestartGroup.changedInstance(function22)) {
                            i18 = 16384;
                        }
                        i13 |= i18;
                    }
                    if ((i3 & 16384) == 0) {
                        i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i13 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                        if (startRestartGroup.shouldExecute((i10 & 306783379) == 306783378 || (i13 & 74899) != 74898, i10 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "262@12100L31,265@12273L13,266@12336L14,267@12378L31");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                int i21 = (i3 & 32) != 0 ? i10 & (-3670017) : i10;
                                if ((i3 & 256) != 0) {
                                    i21 &= -1879048193;
                                }
                                if ((i3 & 512) != 0) {
                                    i13 &= -15;
                                }
                                if ((i3 & 1024) != 0) {
                                    i13 &= -113;
                                }
                                if ((i3 & 8192) != 0) {
                                    i13 &= -57345;
                                }
                                j7 = j;
                                j6 = j2;
                                lambda$1716959002$material3 = function2;
                                modalBottomSheetKt$ModalBottomSheetContent$1 = function22;
                                i14 = i21;
                                modifier3 = companion;
                                i15 = i13;
                                f7 = f;
                                f6 = f3;
                                shape4 = shape;
                            } else {
                                if (i5 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i3 & 32) != 0) {
                                    i14 = i10 & (-3670017);
                                    sheetState2 = rememberModalBottomSheetState(false, null, startRestartGroup, 0, 3);
                                } else {
                                    i14 = i10;
                                }
                                float m1749getSheetMaxWidthD9Ej5fM = i6 != 0 ? BottomSheetDefaults.INSTANCE.m1749getSheetMaxWidthD9Ej5fM() : f;
                                if (i7 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 256) != 0) {
                                    shape3 = BottomSheetDefaults.INSTANCE.getExpandedShape(startRestartGroup, 6);
                                    i14 &= -1879048193;
                                } else {
                                    shape3 = shape;
                                }
                                if ((i3 & 512) != 0) {
                                    i13 &= -15;
                                    j5 = BottomSheetDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                } else {
                                    j5 = j;
                                }
                                if ((i3 & 1024) != 0) {
                                    j6 = ColorSchemeKt.m1902contentColorForek8zF_U(j5, startRestartGroup, i13 & 14);
                                    i13 &= -113;
                                } else {
                                    j6 = j2;
                                }
                                float m1747getElevationD9Ej5fM = i11 != 0 ? BottomSheetDefaults.INSTANCE.m1747getElevationD9Ej5fM() : f2;
                                lambda$1716959002$material3 = i12 != 0 ? ComposableSingletons$ModalBottomSheetKt.INSTANCE.getLambda$1716959002$material3() : function2;
                                float f9 = m1749getSheetMaxWidthD9Ej5fM;
                                if ((i3 & 8192) != 0) {
                                    i13 &= -57345;
                                    shape4 = shape3;
                                    j7 = j5;
                                    modalBottomSheetKt$ModalBottomSheetContent$1 = new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.ModalBottomSheetKt$ModalBottomSheetContent$1
                                        public final WindowInsets invoke(Composer composer3, int i22) {
                                            composer3.startReplaceGroup(1023699493);
                                            ComposerKt.sourceInformation(composer3, "C270@12629L12:ModalBottomSheet.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1023699493, i22, -1, "androidx.compose.material3.ModalBottomSheetContent.<anonymous> (ModalBottomSheet.kt:270)");
                                            }
                                            WindowInsets windowInsets = BottomSheetDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer3.endReplaceGroup();
                                            return windowInsets;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer3, Integer num) {
                                            return invoke(composer3, num.intValue());
                                        }
                                    };
                                } else {
                                    shape4 = shape3;
                                    j7 = j5;
                                    modalBottomSheetKt$ModalBottomSheetContent$1 = function22;
                                }
                                modifier3 = companion;
                                i15 = i13;
                                f6 = m1747getElevationD9Ej5fM;
                                f7 = f9;
                            }
                            startRestartGroup.endDefaults();
                            Function2<? super Composer, ? super Integer, ? extends WindowInsets> function25 = modalBottomSheetKt$ModalBottomSheetContent$1;
                            if (ComposerKt.isTraceInProgress()) {
                                shape5 = shape4;
                                ComposerKt.traceEventStart(-37400432, i14, i15, "androidx.compose.material3.ModalBottomSheetContent (ModalBottomSheet.kt:272)");
                            } else {
                                shape5 = shape4;
                            }
                            Strings.Companion companion3 = Strings.Companion;
                            final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_bottom_sheet_pane_title), startRestartGroup, 0);
                            Modifier modifier4 = modifier3;
                            int i22 = i15;
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m871widthInVpY3zN4$default(boxScope.align(modifier3, Alignment.Companion.getTopCenter()), 0.0f, f7, 1, null), 0.0f, 1, null);
                            if (z2) {
                                startRestartGroup.startReplaceGroup(-1582035383);
                                ComposerKt.sourceInformation(startRestartGroup, "284@13098L373");
                                Modifier.Companion companion4 = Modifier.Companion;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1582034107, "CC(remember):ModalBottomSheet.kt#9igjgp");
                                f8 = f7;
                                boolean z4 = (((3670016 & i14) ^ 1572864) > 1048576 && startRestartGroup.changed(sheetState2)) || (i14 & 1572864) == 1048576;
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState2, Orientation.Vertical, function1);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                j8 = j7;
                                companion2 = NestedScrollModifierKt.nestedScroll$default(companion4, (NestedScrollConnection) rememberedValue, null, 2, null);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                f8 = f7;
                                j8 = j7;
                                startRestartGroup.startReplaceGroup(-1582020872);
                                startRestartGroup.endReplaceGroup();
                                companion2 = Modifier.Companion;
                            }
                            Modifier then = fillMaxWidth$default.then(companion2);
                            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3 = sheetState2.getAnchoredDraggableState$material3();
                            Orientation orientation = Orientation.Vertical;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1582015502, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            int i23 = (3670016 & i14) ^ 1572864;
                            boolean z5 = (i23 > 1048576 && startRestartGroup.changed(sheetState2)) || (i14 & 1572864) == 1048576;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (z5 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17(SheetState.this, (IntSize) obj2, (Constraints) obj3);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier draggableAnchors = AnchoredDraggableKt.draggableAnchors(then, anchoredDraggableState$material3, orientation, (Function2) rememberedValue2);
                            DraggableState draggableState$material3 = sheetState2.getAnchoredDraggableState$material3().getDraggableState$material3();
                            Orientation orientation2 = Orientation.Vertical;
                            boolean z6 = z2 && sheetState2.isVisible();
                            boolean isAnimationRunning = sheetState2.getAnchoredDraggableState$material3().isAnimationRunning();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1581953913, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean z7 = (57344 & i14) == 16384;
                            ModalBottomSheetKt$ModalBottomSheetContent$4$1 rememberedValue3 = startRestartGroup.rememberedValue();
                            if (z7 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new ModalBottomSheetKt$ModalBottomSheetContent$4$1(function1, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier draggable$default = DraggableKt.draggable$default(draggableAnchors, draggableState$material3, orientation2, z6, null, isAnimationRunning, null, (Function3) rememberedValue3, false, 168, null);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1581951584, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean changed = startRestartGroup.changed(m3088getString2EP1pXo);
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$21$lambda$20(m3088getString2EP1pXo, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier consumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(SemanticsModifierKt.semantics$default(draggable$default, false, (Function1) rememberedValue4, 1, null), WindowInsetsKt.WindowInsets$default(0, RangesKt.coerceAtLeast((int) sheetState2.getOffset$material3(), 0), 0, 0, 13, null));
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1581943244, "CC(remember):ModalBottomSheet.kt#9igjgp");
                            boolean z8 = ((i23 > 1048576 && startRestartGroup.changed(sheetState2)) || (i14 & 1572864) == 1048576) | ((i14 & 112) == 32 || ((i14 & 64) != 0 && startRestartGroup.changedInstance(animatable)));
                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                            if (z8 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$23$lambda$22(SheetState.this, animatable, (GraphicsLayerScope) obj2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            SheetState sheetState4 = sheetState2;
                            boolean z9 = z2;
                            Function2<? super Composer, ? super Integer, Unit> function26 = lambda$1716959002$material3;
                            int i24 = i22 << 6;
                            int i25 = ((i14 >> 24) & 112) | 12582912 | (i24 & 896) | (i24 & 7168) | (i24 & 57344);
                            Shape shape6 = shape5;
                            long j9 = j6;
                            SurfaceKt.m2569SurfaceT9BRK9s(BottomSheetScaffoldKt.verticalScaleUp(GraphicsLayerModifierKt.graphicsLayer(consumeWindowInsets, (Function1) rememberedValue5), sheetState2), shape6, j8, j9, f6, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(728743275, true, new ModalBottomSheetKt$ModalBottomSheetContent$7(function25, animatable, sheetState4, function26, function3, obj, coroutineScope, z9), startRestartGroup, 54), startRestartGroup, i25, 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z9;
                            sheetState3 = sheetState4;
                            function23 = function26;
                            shape2 = shape6;
                            f5 = f6;
                            composer2 = startRestartGroup;
                            modifier2 = modifier4;
                            f4 = f8;
                            function24 = function25;
                            j4 = j9;
                            j3 = j8;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            f4 = f;
                            shape2 = shape;
                            f5 = f2;
                            function23 = function2;
                            sheetState3 = sheetState2;
                            modifier2 = companion;
                            z3 = z2;
                            composer2 = startRestartGroup;
                            j3 = j;
                            j4 = j2;
                            function24 = function22;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$24(BoxScope.this, animatable, coroutineScope, function0, function1, modifier2, sheetState3, f4, z3, shape2, j3, j4, f5, function23, function24, function3, i, i2, i3, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i10 & 306783379) == 306783378 || (i13 & 74899) != 74898, i10 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f3 = f2;
                i12 = i3 & 4096;
                if (i12 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i3 & 16384) == 0) {
                }
                if (startRestartGroup.shouldExecute((i10 & 306783379) == 306783378 || (i13 & 74899) != 74898, i10 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = function0;
            int i182 = 8192;
            if ((i3 & 8) != 0) {
            }
            i5 = i3 & 16;
            if (i5 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i192 = i9;
            i11 = i3 & 2048;
            if (i11 != 0) {
            }
            f3 = f2;
            i12 = i3 & 4096;
            if (i12 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i3 & 16384) == 0) {
            }
            if (startRestartGroup.shouldExecute((i10 & 306783379) == 306783378 || (i13 & 74899) != 74898, i10 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        obj = function0;
        int i1822 = 8192;
        if ((i3 & 8) != 0) {
        }
        i5 = i3 & 16;
        if (i5 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i1922 = i9;
        i11 = i3 & 2048;
        if (i11 != 0) {
        }
        f3 = f2;
        i12 = i3 & 4096;
        if (i12 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i3 & 16384) == 0) {
        }
        if (startRestartGroup.shouldExecute((i10 & 306783379) == 306783378 || (i13 & 74899) != 74898, i10 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Pair ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17(final SheetState sheetState, final IntSize intSize, Constraints constraints) {
        SheetValue sheetValue;
        final float m7507getMaxHeightimpl = Constraints.m7507getMaxHeightimpl(constraints.m7514unboximpl());
        DraggableAnchors DraggableAnchors = AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModalBottomSheetKt.ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(m7507getMaxHeightimpl, intSize, sheetState, (DraggableAnchorsConfig) obj);
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[sheetState.getAnchoredDraggableState$material3().getTargetValue().ordinal()];
        if (i == 1) {
            sheetValue = SheetValue.Hidden;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            sheetValue = DraggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        } else if (DraggableAnchors.hasAnchorFor(SheetValue.PartiallyExpanded)) {
            sheetValue = SheetValue.PartiallyExpanded;
        } else {
            sheetValue = DraggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.Hidden;
        }
        return TuplesKt.to(DraggableAnchors, sheetValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$18$lambda$17$lambda$16(float f, IntSize intSize, SheetState sheetState, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(SheetValue.Hidden, f);
        if (((int) (intSize.m7730unboximpl() & 4294967295L)) > f / 2.0f && !sheetState.getSkipPartiallyExpanded$material3()) {
            draggableAnchorsConfig.at(SheetValue.PartiallyExpanded, f / 2.0f);
        }
        if (((int) (intSize.m7730unboximpl() & 4294967295L)) != 0) {
            draggableAnchorsConfig.at(SheetValue.Expanded, Math.max(0.0f, f - ((int) (intSize.m7730unboximpl() & 4294967295L))));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$21$lambda$20(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 0.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalBottomSheetContent_7___e2Q$lambda$23$lambda$22(SheetState sheetState, Animatable animatable, GraphicsLayerScope graphicsLayerScope) {
        float offset = sheetState.getAnchoredDraggableState$material3().getOffset();
        float intBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.mo4966getSizeNHjbRc() & 4294967295L));
        if (!Float.isNaN(offset) && !Float.isNaN(intBitsToFloat) && intBitsToFloat != 0.0f) {
            float floatValue = ((Number) animatable.getValue()).floatValue();
            graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, floatValue));
            graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, floatValue));
            graphicsLayerScope.mo4973setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.5f, (offset + intBitsToFloat) / intBitsToFloat));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f) {
        float intBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.mo4966getSizeNHjbRc() >> 32));
        if (Float.isNaN(intBitsToFloat) || intBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo405toPx0680j_4(PredictiveBackMaxScaleXDistance), intBitsToFloat), f) / intBitsToFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f) {
        float intBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.mo4966getSizeNHjbRc() & 4294967295L));
        if (Float.isNaN(intBitsToFloat) || intBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo405toPx0680j_4(PredictiveBackMaxScaleYDistance), intBitsToFloat), f) / intBitsToFloat);
    }

    public static final SheetState rememberModalBottomSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -778250030, "C(rememberModalBottomSheetState)N(skipPartiallyExpanded,confirmValueChange)500@23719L8,502@23737L160:ModalBottomSheet.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -573963974, "CC(remember):ModalBottomSheet.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(ModalBottomSheetKt.rememberModalBottomSheetState$lambda$26$lambda$25((SheetValue) obj));
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-778250030, i, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.kt:502)");
        }
        SheetState m2478rememberSheetStateAGcomas = SheetDefaultsKt.m2478rememberSheetStateAGcomas(z2, function12, SheetValue.Hidden, false, 0.0f, 0.0f, composer, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | (i & 112), 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2478rememberSheetStateAGcomas;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [int] */
    /* renamed from: Scrim-KTwxG1Y  reason: not valid java name */
    public static final void m2253ScrimKTwxG1Y(final long j, final Function0<Unit> function0, final boolean z, final boolean z2, Composer composer, final int i) {
        int i2;
        ?? r14;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-391613911);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible,dismissEnabled):ModalBottomSheet.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if (startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-391613911, i2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.kt:514)");
            }
            if (j != 16) {
                startRestartGroup.startReplaceGroup(-1438582326);
                ComposerKt.sourceInformation(startRestartGroup, "520@24316L7,518@24171L167,522@24364L29,537@24994L79,537@24944L129");
                int i3 = i2;
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, startRestartGroup, 6), 0.0f, null, null, startRestartGroup, 0, 28);
                Strings.Companion companion2 = Strings.Companion;
                final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.close_sheet), startRestartGroup, 0);
                if (z2) {
                    startRestartGroup.startReplaceGroup(-1438283579);
                    ComposerKt.sourceInformation(startRestartGroup, "525@24511L44,526@24612L263");
                    Modifier.Companion companion3 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1616173205, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    int i4 = i3 & 112;
                    boolean z3 = i4 == 32;
                    ModalBottomSheetKt$Scrim$dismissSheet$1$1 rememberedValue = startRestartGroup.rememberedValue();
                    if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new ModalBottomSheetKt$Scrim$dismissSheet$1$1(function0);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion3, function0, (PointerInputEventHandler) rememberedValue);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1616176656, "CC(remember):ModalBottomSheet.kt#9igjgp");
                    boolean changed = startRestartGroup.changed(m3088getString2EP1pXo) | (i4 == 32);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$31$lambda$30(m3088getString2EP1pXo, function0, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    r14 = 1;
                    companion = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                    startRestartGroup.endReplaceGroup();
                } else {
                    r14 = 1;
                    startRestartGroup.startReplaceGroup(-1437857391);
                    startRestartGroup.endReplaceGroup();
                    companion = Modifier.Companion;
                }
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, r14, null).then(companion);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1616188696, "CC(remember):ModalBottomSheet.kt#9igjgp");
                boolean changed2 = startRestartGroup.changed(animateFloatAsState) | ((i3 & 14) == 4 ? r14 : false);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$33$lambda$32(j, animateFloatAsState, (DrawScope) obj);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1437676103);
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
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$34(j, function0, z, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Scrim_KTwxG1Y$lambda$31$lambda$30(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 1.0f);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ModalBottomSheetKt.Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(Function0.this));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean Scrim_KTwxG1Y$lambda$31$lambda$30$lambda$29(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Scrim_KTwxG1Y$lambda$33$lambda$32(long j, State state, DrawScope drawScope) {
        DrawScope.m5340drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(Scrim_KTwxG1Y$lambda$27(state), 0.0f, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    private static final float Scrim_KTwxG1Y$lambda$27(State<Float> state) {
        return state.getValue().floatValue();
    }
}
