package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: NavigationDrawer.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a]\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0016\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0017\u001a=\u0010\u0018\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0019\u001ai\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b%\u0010&\u001aq\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b'\u0010(\u001ai\u0010)\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b*\u0010&\u001aq\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b+\u0010(\u001ai\u0010,\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b-\u0010&\u001a{\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00101\u001a\u0002022\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0001¢\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a$\u00109\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010:\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010;\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u0014\u0010<\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a\u0014\u0010>\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a.\u0010?\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010@\u001a\u008e\u0001\u0010A\u001a\u00020\t2\u0011\u0010B\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\u0006\u0010C\u001a\u00020\u00062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0015\b\u0002\u0010E\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010G\u001a\u00020\u001c2\b\b\u0002\u0010H\u001a\u00020I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0002\u0010L\u001a \u0010M\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\u0006\u0010P\u001a\u000207H\u0002\u001a;\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u00062\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010T\u001a\b\u0012\u0004\u0012\u0002070\u000b2\u0006\u0010U\u001a\u00020\u0012H\u0003¢\u0006\u0004\bV\u0010W\"\u000e\u0010X\u001a\u000207X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010[\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0016\u0010\\\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b]\u0010^\"\u0016\u0010_\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b`\u0010^\"\u0016\u0010a\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bb\u0010^\"\u0014\u0010c\u001a\b\u0012\u0004\u0012\u0002070dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u000207X\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"rememberDrawerState", "Landroidx/compose/material3/DrawerState;", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "ModalNavigationDrawer", "", "drawerContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "scrimColor", "Landroidx/compose/ui/graphics/Color;", FirebaseAnalytics.Param.CONTENT, "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "drawerContentColor", "drawerTonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet-Snr_uVM", "(Landroidx/compose/material3/DrawerState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleDrawerSheet", "DismissibleDrawerSheet-afqeVBk", "DismissibleDrawerSheet-Snr_uVM", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "DrawerSheet", "drawerPredictiveBackState", "Landroidx/compose/material3/DrawerPredictiveBackState;", "drawerOffset", "Landroidx/compose/material3/internal/FloatProducer;", "DrawerSheet-cm3T3N0", "(Landroidx/compose/material3/DrawerPredictiveBackState;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "horizontalScaleUp", "drawerWidth", "", "isRtl", "horizontalScaleDown", "predictiveBackDrawerContainer", "predictiveBackDrawerChild", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "calculatePredictiveBackScaleY", "DrawerPredictiveBackHandler", "(Landroidx/compose/material3/DrawerState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationDrawerItem", Constants.ScionAnalytics.PARAM_LABEL, "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "pos", "Scrim", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "F", "MinimumDrawerWidth", "PredictiveBackDrawerMaxScaleXDistanceGrow", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "AnchoredDraggableDefaultAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "material3", "anchorsInitialized", "minValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationDrawerKt {
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold = Dp.m7555constructorimpl(400.0f);
    private static final float MinimumDrawerWidth = Dp.m7555constructorimpl(240.0f);
    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.m7555constructorimpl(12.0f);
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.m7555constructorimpl(24.0f);
    private static final float PredictiveBackDrawerMaxScaleYDistance = Dp.m7555constructorimpl(48.0f);
    private static final TweenSpec<Float> AnchoredDraggableDefaultAnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static final Unit DismissibleDrawerSheet_Snr_uVM$lambda$46(DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2283DismissibleDrawerSheetSnr_uVM(drawerState, modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit DismissibleDrawerSheet_afqeVBk$lambda$45(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2284DismissibleDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit DismissibleNavigationDrawer$lambda$39(Function2 function2, Modifier modifier, DrawerState drawerState, boolean z, Function2 function22, int i, int i2, Composer composer, int i3) {
        DismissibleNavigationDrawer(function2, modifier, drawerState, z, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit DrawerPredictiveBackHandler$lambda$62(DrawerState drawerState, Function3 function3, int i, Composer composer, int i2) {
        DrawerPredictiveBackHandler(drawerState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final float DrawerSheet_cm3T3N0$lambda$51$lambda$50() {
        return 0.0f;
    }

    public static final Unit DrawerSheet_cm3T3N0$lambda$53(DrawerPredictiveBackState drawerPredictiveBackState, WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, FloatProducer floatProducer, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2285DrawerSheetcm3T3N0(drawerPredictiveBackState, windowInsets, modifier, shape, j, j2, f, floatProducer, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit ModalDrawerSheet_Snr_uVM$lambda$44(DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2286ModalDrawerSheetSnr_uVM(drawerState, modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit ModalDrawerSheet_afqeVBk$lambda$43(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2287ModalDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$25(Function2 function2, Modifier modifier, DrawerState drawerState, boolean z, long j, Function2 function22, int i, int i2, Composer composer, int i3) {
        m2288ModalNavigationDrawerFHprtrg(function2, modifier, drawerState, z, j, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit NavigationDrawerItem$lambda$65(Function2 function2, boolean z, Function0 function0, Modifier modifier, Function2 function22, Function2 function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationDrawerItem(function2, z, function0, modifier, function22, function23, shape, navigationDrawerItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit PermanentDrawerSheet_afqeVBk$lambda$49(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2289PermanentDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit PermanentNavigationDrawer$lambda$42(Function2 function2, Modifier modifier, Function2 function22, int i, int i2, Composer composer, int i3) {
        PermanentNavigationDrawer(function2, modifier, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit Scrim_Bx497Mc$lambda$72(boolean z, Function0 function0, Function0 function02, long j, int i, Composer composer, int i2) {
        m2290ScrimBx497Mc(z, function0, function02, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ float access$getDrawerVelocityThreshold$p() {
        return DrawerVelocityThreshold;
    }

    public static final boolean rememberDrawerState$lambda$1$lambda$0(DrawerValue drawerValue) {
        return true;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2098699222, "C(rememberDrawerState)N(initialValue,confirmStateChange)304@12444L8,306@12546L61,306@12482L125:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1784672962, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavigationDrawerKt.rememberDrawerState$lambda$1$lambda$0((DrawerValue) obj));
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            function1 = (Function1) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, i, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:305)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.Companion.Saver(function1);
        ComposerKt.sourceInformationMarkerStart(composer, -1784669645, "CC(remember):NavigationDrawer.kt#9igjgp");
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && composer.changed(drawerValue.ordinal())) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(function1)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object rememberedValue2 = composer.rememberedValue();
        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavigationDrawerKt.rememberDrawerState$lambda$3$lambda$2(DrawerValue.this, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m4213rememberSaveable(objArr, Saver, (Function0<? extends Object>) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return drawerState;
    }

    public static final DrawerState rememberDrawerState$lambda$3$lambda$2(DrawerValue drawerValue, Function1 function1) {
        return new DrawerState(drawerValue, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:274:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x058b  */
    /* JADX WARN: Removed duplicated region for block: B:480:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:493:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:495:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* renamed from: ModalNavigationDrawer-FHprtrg */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2288ModalNavigationDrawerFHprtrg(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, long j, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        DrawerState drawerState2;
        int i4;
        long j2;
        final boolean z2;
        final Modifier modifier2;
        final DrawerState drawerState3;
        final long j3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        boolean z3;
        long j4;
        boolean z4;
        final DrawerState drawerState4;
        boolean z5;
        boolean changed;
        Object rememberedValue;
        final DrawerState drawerState5;
        int currentCompositeKeyHash;
        Composer m4041constructorimpl;
        int currentCompositeKeyHash2;
        Composer m4041constructorimpl2;
        boolean changedInstance;
        Object rememberedValue2;
        boolean changed2;
        Object rememberedValue3;
        boolean z6;
        Object rememberedValue4;
        boolean changed3;
        Object rememberedValue5;
        boolean changed4;
        NavigationDrawerKt$ModalNavigationDrawer$2$6$1 rememberedValue6;
        int currentCompositeKeyHash3;
        Composer m4041constructorimpl3;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Composer startRestartGroup = composer.startRestartGroup(-1907430816);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalNavigationDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,scrimColor:c#ui.graphics.Color,content)339@13901L24,340@13951L33,341@14016L7,342@14054L34,343@14109L45,348@14357L7,349@14451L7,350@14543L7,352@14567L229,352@14556L240,359@14835L7,360@14870L3155:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    if (startRestartGroup.changed(drawerState2)) {
                        i5 = 256;
                        i3 |= i5;
                    }
                } else {
                    drawerState2 = drawerState;
                }
                i5 = 128;
                i3 |= i5;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(z) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    j2 = j;
                    i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j2)) ? 16384 : 8192;
                } else {
                    j2 = j;
                }
                if ((i2 & 32) != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
                }
                if (startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "334@13715L39,336@13832L10");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        companion = obj;
                        j4 = j2;
                        z3 = z;
                    } else {
                        companion = i6 != 0 ? Modifier.Companion : obj;
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerState2 = rememberDrawerState(DrawerValue.Closed, null, startRestartGroup, 6, 2);
                        }
                        z3 = i4 != 0 ? true : z;
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            j4 = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                        } else {
                            j4 = j2;
                        }
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1907430816, i3, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:338)");
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    Object rememberedValue7 = startRestartGroup.rememberedValue();
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        rememberedValue7 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Strings.Companion companion2 = Strings.Companion;
                    final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density = (Density) consume;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 910036834, "CC(remember):NavigationDrawer.kt#9igjgp");
                    Object rememberedValue8 = startRestartGroup.rememberedValue();
                    if (rememberedValue8 == Composer.Companion.getEmpty()) {
                        z4 = z3;
                        rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue8);
                    } else {
                        z4 = z3;
                    }
                    MutableState mutableState = (MutableState) rememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 910038605, "CC(remember):NavigationDrawer.kt#9igjgp");
                    boolean changed5 = startRestartGroup.changed(density);
                    Object rememberedValue9 = startRestartGroup.rememberedValue();
                    if (changed5 || rememberedValue9 == Composer.Companion.getEmpty()) {
                        rememberedValue9 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        startRestartGroup.updateRememberedValue(rememberedValue9);
                    }
                    final MutableFloatState mutableFloatState = rememberedValue9;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final FiniteAnimationSpec value = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
                    final FiniteAnimationSpec value2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
                    long j5 = j4;
                    final FiniteAnimationSpec value3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, startRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 910053445, "CC(remember):NavigationDrawer.kt#9igjgp");
                    int i7 = (i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                    if (i7 <= 256 || !startRestartGroup.changed(drawerState2)) {
                        drawerState4 = drawerState2;
                        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                            z5 = false;
                            changed = z5 | startRestartGroup.changed(density) | startRestartGroup.changedInstance(value2) | startRestartGroup.changedInstance(value3) | startRestartGroup.changedInstance(value);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(DrawerState.this, density, value2, value3, value);
                                    }
                                };
                                drawerState5 = drawerState4;
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            } else {
                                drawerState5 = drawerState4;
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final boolean z7 = z4;
                            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), drawerState5.getAnchoredDraggableState$material3(), consume2 != LayoutDirection.Rtl, Orientation.Horizontal, z7, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            Modifier modifier3 = companion;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, anchoredDraggable$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (!startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
                            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 101870438, "C370@15180L17,373@15274L183,378@15482L70,371@15206L389,384@15704L601,396@16337L452,407@16801L1218,381@15604L2415:NavigationDrawer.kt#uh7d8r");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (!startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor2);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
                            Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 343987054, "C370@15186L9:NavigationDrawer.kt#uh7d8r");
                            function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            boolean isOpen = drawerState5.isOpen();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                            changedInstance = ((i3 & 7168) != 2048) | ((i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(coroutineScope);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(z7, drawerState5, coroutineScope);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            Function0 function0 = rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                            changed2 = startRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        float calculateFraction;
                                        calculateFraction = NavigationDrawerKt.calculateFraction(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$8(mutableFloatState), r1, drawerState5.requireOffset$material3());
                                        return Float.valueOf(calculateFraction);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            m2290ScrimBx497Mc(isOpen, function0, (Function0) rememberedValue3, j5, startRestartGroup, (i3 >> 3) & 7168);
                            Modifier.Companion companion3 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                            z6 = (i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!z6 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(DrawerState.this, (Density) obj2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier offset = OffsetKt.offset(companion3, (Function1) rememberedValue4);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                            changed3 = startRestartGroup.changed(m3088getString2EP1pXo) | ((i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(coroutineScope);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changed3 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(m3088getString2EP1pXo, drawerState5, coroutineScope, (SemanticsPropertyReceiver) obj2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(offset, false, (Function1) rememberedValue5, 1, null);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081546376, "CC(remember):NavigationDrawer.kt#9igjgp");
                            changed4 = startRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
                            rememberedValue6 = startRestartGroup.rememberedValue();
                            if (!changed4 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = new NavigationDrawerKt$ModalNavigationDrawer$2$6$1(drawerState5, mutableState, mutableFloatState, 0.0f);
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i8 = i3 & 14;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                            int i9 = ((i8 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (!startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor3);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m4041constructorimpl3 = Updater.m4041constructorimpl(startRestartGroup);
                            Updater.m4049setimpl(m4041constructorimpl3, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                            function23 = function2;
                            function23.invoke(startRestartGroup, Integer.valueOf((i9 >> 6) & 14));
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            drawerState3 = drawerState5;
                            j3 = j5;
                            modifier2 = modifier3;
                            z2 = z7;
                        }
                    } else {
                        drawerState4 = drawerState2;
                    }
                    z5 = true;
                    changed = z5 | startRestartGroup.changed(density) | startRestartGroup.changedInstance(value2) | startRestartGroup.changedInstance(value3) | startRestartGroup.changedInstance(value);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    rememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(DrawerState.this, density, value2, value3, value);
                        }
                    };
                    drawerState5 = drawerState4;
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final boolean z72 = z4;
                    Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), drawerState5.getAnchoredDraggableState$material3(), consume22 != LayoutDirection.Rtl, Orientation.Horizontal, z72, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    Modifier modifier32 = companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, anchoredDraggable$default2);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4041constructorimpl.getInserting()) {
                    }
                    m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 101870438, "C370@15180L17,373@15274L183,378@15482L70,371@15206L389,384@15704L601,396@16337L452,407@16801L1218,381@15604L2415:NavigationDrawer.kt#uh7d8r");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                    Function0<ComposeUiNode> constructor22 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4041constructorimpl2.getInserting()) {
                    }
                    m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                    Updater.m4049setimpl(m4041constructorimpl2, materializeModifier22, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 343987054, "C370@15186L9:NavigationDrawer.kt#uh7d8r");
                    function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    boolean isOpen2 = drawerState5.isOpen();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                    changedInstance = ((i3 & 7168) != 2048) | ((i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(coroutineScope);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    rememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(z72, drawerState5, coroutineScope);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    Function0 function02 = rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                    changed2 = startRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            float calculateFraction;
                            calculateFraction = NavigationDrawerKt.calculateFraction(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$8(mutableFloatState), r1, drawerState5.requireOffset$material3());
                            return Float.valueOf(calculateFraction);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    m2290ScrimBx497Mc(isOpen2, function02, (Function0) rememberedValue3, j5, startRestartGroup, (i3 >> 3) & 7168);
                    Modifier.Companion companion32 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i7 <= 256) {
                    }
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!z6) {
                    }
                    rememberedValue4 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(DrawerState.this, (Density) obj2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier offset2 = OffsetKt.offset(companion32, (Function1) rememberedValue4);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                    changed3 = startRestartGroup.changed(m3088getString2EP1pXo) | ((i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(coroutineScope);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changed3) {
                    }
                    rememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(m3088getString2EP1pXo, drawerState5, coroutineScope, (SemanticsPropertyReceiver) obj2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier semantics$default2 = SemanticsModifierKt.semantics$default(offset2, false, (Function1) rememberedValue5, 1, null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2081546376, "CC(remember):NavigationDrawer.kt#9igjgp");
                    changed4 = startRestartGroup.changed(mutableFloatState) | ((i7 <= 256 && startRestartGroup.changed(drawerState5)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (!changed4) {
                    }
                    rememberedValue6 = new NavigationDrawerKt$ModalNavigationDrawer$2$6$1(drawerState5, mutableState, mutableFloatState, 0.0f);
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                    MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    int i82 = i3 & 14;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default2);
                    Function0<ComposeUiNode> constructor32 = ComposeUiNode.Companion.getConstructor();
                    int i92 = ((i82 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    m4041constructorimpl3 = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl3, measurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4041constructorimpl3.getInserting()) {
                    }
                    m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                    Updater.m4049setimpl(m4041constructorimpl3, materializeModifier32, ComposeUiNode.Companion.getSetModifier());
                    function23 = function2;
                    function23.invoke(startRestartGroup, Integer.valueOf((i92 >> 6) & 14));
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    drawerState3 = drawerState5;
                    j3 = j5;
                    modifier2 = modifier32;
                    z2 = z72;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    z2 = z;
                    modifier2 = obj;
                    drawerState3 = drawerState2;
                    j3 = j2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$25(Function2.this, modifier2, drawerState3, z2, j3, function22, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            if ((i & 24576) == 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (startRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final boolean ModalNavigationDrawer_FHprtrg$lambda$5(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final void ModalNavigationDrawer_FHprtrg$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final float ModalNavigationDrawer_FHprtrg$lambda$8(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$11$lambda$10(DrawerState drawerState, Density density, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        drawerState.setDensity$material3(density);
        drawerState.setOpenDrawerMotionSpec$material3(finiteAnimationSpec);
        drawerState.setCloseDrawerMotionSpec$material3(finiteAnimationSpec2);
        drawerState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$14$lambda$13(boolean z, DrawerState drawerState, CoroutineScope coroutineScope) {
        if (z && drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1(drawerState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    public static final IntOffset ModalNavigationDrawer_FHprtrg$lambda$24$lambda$19$lambda$18(DrawerState drawerState, Density density) {
        int i;
        float currentOffset = drawerState.getCurrentOffset();
        if (Float.isNaN(currentOffset)) {
            i = drawerState.isOpen() ? 0 : -density.mo399roundToPx0680j_4(DrawerDefaults.INSTANCE.m2048getMaximumDrawerWidthD9Ej5fM());
        } else {
            i = MathKt.roundToInt(currentOffset);
        }
        return IntOffset.m7674boximpl(IntOffset.m7677constructorimpl(i << 32));
    }

    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(DrawerState.this, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    public static final boolean ModalNavigationDrawer_FHprtrg$lambda$24$lambda$22$lambda$21$lambda$20(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1(drawerState, null), 3, null);
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:375:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DismissibleNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        final DrawerState drawerState2;
        int i4;
        boolean z2;
        final boolean z3;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier2;
        boolean z4;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        Object rememberedValue3;
        int currentCompositeKeyHash;
        Composer m4041constructorimpl;
        boolean z5;
        NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1 rememberedValue4;
        int currentCompositeKeyHash2;
        Composer m4041constructorimpl2;
        boolean changed2;
        Object rememberedValue5;
        int currentCompositeKeyHash3;
        Composer m4041constructorimpl3;
        int currentCompositeKeyHash4;
        Composer m4041constructorimpl4;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
        Composer startRestartGroup = composer.startRestartGroup(1150092038);
        ComposerKt.sourceInformation(startRestartGroup, "C(DismissibleNavigationDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,content)464@19353L34,465@19419L7,468@19586L7,469@19678L7,471@19702L155,471@19691L166,477@19875L24,478@19925L33,480@19997L7,481@20032L2189:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    if (startRestartGroup.changed(drawerState2)) {
                        i5 = 256;
                        i3 |= i5;
                    }
                } else {
                    drawerState2 = drawerState;
                }
                i5 = 128;
                i3 |= i5;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
                }
                if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "460@19204L39");
                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            companion = Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerState2 = rememberDrawerState(DrawerValue.Closed, null, startRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            modifier2 = companion;
                            z4 = true;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1150092038, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:463)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431863176, "CC(remember):NavigationDrawer.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            MutableState mutableState = (MutableState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Density density = (Density) consume;
                            final FiniteAnimationSpec value = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
                            final FiniteAnimationSpec value2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, startRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431874465, "CC(remember):NavigationDrawer.kt#9igjgp");
                            int i7 = (i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                            changed = ((i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changed(density) | startRestartGroup.changedInstance(value) | startRestartGroup.changedInstance(value2);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda21
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$30$lambda$29(DrawerState.this, density, value, value2);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Strings.Companion companion2 = Strings.Companion;
                            final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifier2, drawerState2.getAnchoredDraggableState$material3(), consume2 != LayoutDirection.Rtl, Orientation.Horizontal, z4, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, anchoredDraggable$default);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (!startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
                            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -901227702, "C508@20959L1256,489@20282L1933:NavigationDrawer.kt#uh7d8r");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1691618860, "CC(remember):NavigationDrawer.kt#9igjgp");
                            z5 = (i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!z5 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(drawerState2, mutableState);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (!startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor2);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
                            Updater.m4049setimpl(m4041constructorimpl2, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1778119236, "C492@20374L452,491@20330L570,506@20917L17:NavigationDrawer.kt#uh7d8r");
                            Modifier.Companion companion3 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2020850041, "CC(remember):NavigationDrawer.kt#9igjgp");
                            changed2 = startRestartGroup.changed(m3088getString2EP1pXo) | ((i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(coroutineScope);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda23
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(m3088getString2EP1pXo, drawerState2, coroutineScope, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue5, 1, null);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (!startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor3);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m4041constructorimpl3 = Updater.m4041constructorimpl(startRestartGroup);
                            Updater.m4049setimpl(m4041constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1897277909, "C504@20867L15:NavigationDrawer.kt#uh7d8r");
                            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (!startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor4);
                            } else {
                                startRestartGroup.useNode();
                            }
                            m4041constructorimpl4 = Updater.m4041constructorimpl(startRestartGroup);
                            Updater.m4049setimpl(m4041constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!m4041constructorimpl4.getInserting() || !Intrinsics.areEqual(m4041constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                m4041constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                m4041constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                            }
                            Updater.m4049setimpl(m4041constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -272067686, "C506@20923L9:NavigationDrawer.kt#uh7d8r");
                            function23 = function22;
                            function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            companion = modifier2;
                            z3 = z4;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                    }
                    modifier2 = companion;
                    z4 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431863176, "CC(remember):NavigationDrawer.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    }
                    MutableState mutableState2 = (MutableState) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density2 = (Density) consume3;
                    final FiniteAnimationSpec value3 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
                    final FiniteAnimationSpec value22 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, startRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1431874465, "CC(remember):NavigationDrawer.kt#9igjgp");
                    int i72 = (i3 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK;
                    changed = ((i72 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changed(density2) | startRestartGroup.changedInstance(value3) | startRestartGroup.changedInstance(value22);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$30$lambda$29(DrawerState.this, density2, value3, value22);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    }
                    final CoroutineScope coroutineScope2 = (CoroutineScope) rememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Strings.Companion companion22 = Strings.Companion;
                    final String m3088getString2EP1pXo2 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifier2, drawerState2.getAnchoredDraggableState$material3(), consume22 != LayoutDirection.Rtl, Orientation.Horizontal, z4, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, anchoredDraggable$default2);
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4041constructorimpl.getInserting()) {
                    }
                    m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash5);
                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -901227702, "C508@20959L1256,489@20282L1933:NavigationDrawer.kt#uh7d8r");
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1691618860, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i72 <= 256) {
                    }
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue4 = new NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1(drawerState2, mutableState2);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                    Function0<ComposeUiNode> constructor22 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl2, measurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4041constructorimpl2.getInserting()) {
                    }
                    m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                    Updater.m4049setimpl(m4041constructorimpl2, materializeModifier22, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1778119236, "C492@20374L452,491@20330L570,506@20917L17:NavigationDrawer.kt#uh7d8r");
                    Modifier.Companion companion32 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2020850041, "CC(remember):NavigationDrawer.kt#9igjgp");
                    changed2 = startRestartGroup.changed(m3088getString2EP1pXo2) | ((i72 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | startRestartGroup.changedInstance(coroutineScope2);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(m3088getString2EP1pXo2, drawerState2, coroutineScope2, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier semantics$default2 = SemanticsModifierKt.semantics$default(companion32, false, (Function1) rememberedValue5, 1, null);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy22 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default2);
                    Function0<ComposeUiNode> constructor32 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    m4041constructorimpl3 = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl3, maybeCachedBoxMeasurePolicy22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4041constructorimpl3.getInserting()) {
                    }
                    m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                    Updater.m4049setimpl(m4041constructorimpl3, materializeModifier32, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1897277909, "C504@20867L15:NavigationDrawer.kt#uh7d8r");
                    function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy32 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                    Function0<ComposeUiNode> constructor42 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (!startRestartGroup.getInserting()) {
                    }
                    m4041constructorimpl4 = Updater.m4041constructorimpl(startRestartGroup);
                    Updater.m4049setimpl(m4041constructorimpl4, maybeCachedBoxMeasurePolicy32, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl4, currentCompositionLocalMap42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4041constructorimpl4.getInserting()) {
                    }
                    m4041constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m4041constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash42);
                    Updater.m4049setimpl(m4041constructorimpl4, materializeModifier42, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -272067686, "C506@20923L9:NavigationDrawer.kt#uh7d8r");
                    function23 = function22;
                    function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    companion = modifier2;
                    z3 = z4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    z3 = z2;
                }
                final DrawerState drawerState3 = drawerState2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$39(Function2.this, modifier3, drawerState3, z3, function23, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            }
            final DrawerState drawerState32 = drawerState2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
        }
        final DrawerState drawerState322 = drawerState2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final boolean DismissibleNavigationDrawer$lambda$27(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final void DismissibleNavigationDrawer$lambda$28(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final Unit DismissibleNavigationDrawer$lambda$30$lambda$29(DrawerState drawerState, Density density, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2) {
        drawerState.setDensity$material3(density);
        drawerState.setOpenDrawerMotionSpec$material3(finiteAnimationSpec);
        drawerState.setCloseDrawerMotionSpec$material3(finiteAnimationSpec2);
        return Unit.INSTANCE;
    }

    public static final Unit DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NavigationDrawerKt.DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(DrawerState.this, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    public static final boolean DismissibleNavigationDrawer$lambda$38$lambda$36$lambda$33$lambda$32$lambda$31(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1(drawerState, null), 3, null);
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PermanentNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(89297160);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermanentNavigationDrawer)N(drawerContent,modifier,content)562@23211L85:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(function22) ? 256 : 128;
            }
            if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
                startRestartGroup.skipToGroupEnd();
                companion = obj;
            } else {
                companion = i4 != 0 ? Modifier.Companion : obj;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(89297160, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:561)");
                }
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
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
                Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
                Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -688649266, "C563@23249L15,564@23273L17:NavigationDrawer.kt#uh7d8r");
                function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, Modifier.Companion);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4041constructorimpl2 = Updater.m4041constructorimpl(startRestartGroup);
                Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1964035624, "C564@23279L9:NavigationDrawer.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
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
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier2 = companion;
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return NavigationDrawerKt.PermanentNavigationDrawer$lambda$42(Function2.this, modifier2, function22, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        if ((i2 & 4) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 147) == 146, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:269:? A[RETURN, SYNTHETIC] */
    /* renamed from: ModalDrawerSheet-afqeVBk */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2287ModalDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Object obj2;
        long j3;
        long j4;
        float f2;
        Object obj3;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape2;
        final long j5;
        final long j6;
        final float f3;
        final WindowInsets windowInsets2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        long j7;
        float f4;
        WindowInsets windowInsets3;
        int i4;
        Modifier modifier3;
        int i5;
        long j8;
        int i6;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1922633461);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)598@24971L343:NavigationDrawer.kt#uh7d8r");
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                obj2 = shape;
                if (startRestartGroup.changed(obj2)) {
                    i9 = 32;
                    i3 |= i9;
                }
            } else {
                obj2 = shape;
            }
            i9 = 16;
            i3 |= i9;
        } else {
            obj2 = shape;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i8 = 256;
                    i3 |= i8;
                }
            } else {
                j3 = j;
            }
            i8 = 128;
            i3 |= i8;
        } else {
            j3 = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i7 = 2048;
                    i3 |= i7;
                }
            } else {
                j4 = j2;
            }
            i7 = 1024;
            i3 |= i7;
        } else {
            j4 = j2;
        }
        int i11 = i2 & 16;
        if (i11 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj3 = windowInsets;
                    if (startRestartGroup.changed(obj3)) {
                        i6 = 131072;
                        i3 |= i6;
                    }
                } else {
                    obj3 = windowInsets;
                }
                i6 = 65536;
                i3 |= i6;
            } else {
                obj3 = windowInsets;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "591@24636L5,592@24692L19,593@24745L37,595@24900L12");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        shape3 = obj2;
                        j7 = j4;
                        f4 = f2;
                        windowInsets3 = obj3;
                        i5 = 6;
                        i4 = 1922633461;
                        modifier3 = obj;
                    } else {
                        Modifier.Companion companion = i10 != 0 ? Modifier.Companion : obj;
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            obj2 = DrawerDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            j3 = DrawerDefaults.INSTANCE.getModalContainerColor(startRestartGroup, 6);
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                        }
                        if (i11 != 0) {
                            f2 = DrawerDefaults.INSTANCE.m2049getModalDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            modifier3 = companion;
                            shape3 = obj2;
                            j7 = j4;
                            f4 = f2;
                            i5 = 6;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            j8 = j3;
                            i4 = 1922633461;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i4, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:597)");
                            }
                            int i12 = ((i3 >> 12) & 112) | i5;
                            int i13 = i3 << 6;
                            composer2 = startRestartGroup;
                            m2285DrawerSheetcm3T3N0(null, windowInsets3, modifier3, shape3, j8, j7, f4, null, function3, composer2, i12 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (i13 & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets2 = windowInsets3;
                            modifier2 = modifier3;
                            shape2 = shape3;
                            j5 = j8;
                            j6 = j7;
                            f3 = f4;
                        } else {
                            shape3 = obj2;
                            j7 = j4;
                            f4 = f2;
                            windowInsets3 = obj3;
                            i4 = 1922633461;
                            modifier3 = companion;
                            i5 = 6;
                        }
                    }
                    j8 = j3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i122 = ((i3 >> 12) & 112) | i5;
                    int i132 = i3 << 6;
                    composer2 = startRestartGroup;
                    m2285DrawerSheetcm3T3N0(null, windowInsets3, modifier3, shape3, j8, j7, f4, null, function3, composer2, i122 | (i132 & 896) | (i132 & 7168) | (57344 & i132) | (458752 & i132) | (3670016 & i132) | (i132 & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    windowInsets2 = windowInsets3;
                    modifier2 = modifier3;
                    shape2 = shape3;
                    j5 = j8;
                    j6 = j7;
                    f3 = f4;
                } else {
                    composer2 = startRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = obj;
                    shape2 = obj2;
                    j5 = j3;
                    j6 = j4;
                    f3 = f2;
                    windowInsets2 = obj3;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj4, Object obj5) {
                            return NavigationDrawerKt.ModalDrawerSheet_afqeVBk$lambda$43(Modifier.this, shape2, j5, j6, f3, windowInsets2, function3, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f2 = f;
        if ((196608 & i) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:285:? A[RETURN, SYNTHETIC] */
    /* renamed from: ModalDrawerSheet-Snr_uVM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2286ModalDrawerSheetSnr_uVM(final DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        Object obj;
        long j3;
        long j4;
        int i4;
        float f2;
        Object obj2;
        final Modifier modifier2;
        final Shape shape2;
        final long j5;
        final long j6;
        final float f3;
        final WindowInsets windowInsets2;
        ScopeUpdateScope endRestartGroup;
        int i5;
        WindowInsets windowInsets3;
        int i6;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1620540727);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalDrawerSheet)N(drawerState,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)642@27084L519,642@27043L560:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    obj = shape;
                    if (startRestartGroup.changed(obj)) {
                        i9 = 256;
                        i3 |= i9;
                    }
                } else {
                    obj = shape;
                }
                i9 = 128;
                i3 |= i9;
            } else {
                obj = shape;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i8 = 2048;
                        i3 |= i8;
                    }
                } else {
                    j3 = j;
                }
                i8 = 1024;
                i3 |= i8;
            } else {
                j3 = j;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i7 = 16384;
                        i3 |= i7;
                    }
                } else {
                    j4 = j2;
                }
                i7 = 8192;
                i3 |= i7;
            } else {
                j4 = j2;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        obj2 = windowInsets;
                        if (startRestartGroup.changed(obj2)) {
                            i6 = 1048576;
                            i3 |= i6;
                        }
                    } else {
                        obj2 = windowInsets;
                    }
                    i6 = 524288;
                    i3 |= i6;
                } else {
                    obj2 = windowInsets;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "635@26708L5,636@26764L19,637@26817L37,639@26972L12");
                        if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                companion = Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                obj = DrawerDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            }
                            if ((i2 & 8) != 0) {
                                j3 = DrawerDefaults.INSTANCE.getModalContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            }
                            if (i4 != 0) {
                                f2 = DrawerDefaults.INSTANCE.m2049getModalDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 64) != 0) {
                                modifier2 = companion;
                                shape2 = obj;
                                j5 = j3;
                                j6 = j4;
                                f3 = f2;
                                i5 = i3 & (-3670017);
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1620540727, i5, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:641)");
                                }
                                DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new NavigationDrawerKt$ModalDrawerSheet$2(windowInsets3, modifier2, shape2, j5, j6, f3, drawerState, function3), startRestartGroup, 54), startRestartGroup, (i5 & 14) | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                windowInsets2 = windowInsets3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                        }
                        modifier2 = companion;
                        shape2 = obj;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        i5 = i3;
                        windowInsets3 = obj2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new NavigationDrawerKt$ModalDrawerSheet$2(windowInsets3, modifier2, shape2, j5, j6, f3, drawerState, function3), startRestartGroup, 54), startRestartGroup, (i5 & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        windowInsets2 = windowInsets3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = companion;
                        shape2 = obj;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        windowInsets2 = obj2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$44(DrawerState.this, modifier2, shape2, j5, j6, f3, windowInsets2, function3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((1572864 & i) == 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        f2 = f;
        if ((1572864 & i) == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /* renamed from: DismissibleDrawerSheet-afqeVBk */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2284DismissibleDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Object obj2;
        long j3;
        long j4;
        int i4;
        float f2;
        Object obj3;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape2;
        final long j5;
        final long j6;
        final float f3;
        final WindowInsets windowInsets2;
        ScopeUpdateScope endRestartGroup;
        long j7;
        long j8;
        float f4;
        WindowInsets windowInsets3;
        Modifier modifier3;
        Shape shape3;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1496398234);
        ComposerKt.sourceInformation(startRestartGroup, "C(DismissibleDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)687@29311L343:NavigationDrawer.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i3 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj2 = shape;
            i3 |= startRestartGroup.changed(obj2) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    j3 = j;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        obj3 = windowInsets;
                        if (startRestartGroup.changed(obj3)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        obj3 = windowInsets;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    obj3 = windowInsets;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "681@29023L22,682@29079L37,684@29240L12");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            j7 = j3;
                            j8 = j4;
                            f4 = f2;
                            windowInsets3 = obj3;
                            i5 = -1496398234;
                            modifier3 = obj;
                            shape3 = obj2;
                        } else {
                            Modifier.Companion companion = i8 != 0 ? Modifier.Companion : obj;
                            if (i9 != 0) {
                                obj2 = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                j3 = DrawerDefaults.INSTANCE.getStandardContainerColor(startRestartGroup, 6);
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                f2 = DrawerDefaults.INSTANCE.m2047getDismissibleDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                shape3 = obj2;
                                j7 = j3;
                                j8 = j4;
                                f4 = f2;
                                modifier3 = companion;
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            } else {
                                j7 = j3;
                                j8 = j4;
                                f4 = f2;
                                windowInsets3 = obj3;
                                modifier3 = companion;
                                shape3 = obj2;
                            }
                            i5 = -1496398234;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:686)");
                        }
                        int i10 = i3 << 6;
                        composer2 = startRestartGroup;
                        m2285DrawerSheetcm3T3N0(null, windowInsets3, modifier3, shape3, j7, j8, f4, null, function3, composer2, ((i3 >> 12) & 112) | 6 | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (i10 & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = windowInsets3;
                        modifier2 = modifier3;
                        shape2 = shape3;
                        j5 = j7;
                        j6 = j8;
                        f3 = f4;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = obj;
                        shape2 = obj2;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        windowInsets2 = obj3;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                return NavigationDrawerKt.DismissibleDrawerSheet_afqeVBk$lambda$45(Modifier.this, shape2, j5, j6, f3, windowInsets2, function3, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = shape;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:273:? A[RETURN, SYNTHETIC] */
    /* renamed from: DismissibleDrawerSheet-Snr_uVM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2283DismissibleDrawerSheetSnr_uVM(final DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        Object obj;
        long j3;
        long j4;
        int i5;
        float f2;
        final WindowInsets windowInsets2;
        final Modifier modifier2;
        final Shape shape2;
        final long j5;
        final float f3;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i6;
        WindowInsets windowInsets3;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(496605370);
        ComposerKt.sourceInformation(startRestartGroup, "C(DismissibleDrawerSheet)N(drawerState,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)731@31451L519,731@31410L560:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = shape;
                i3 |= startRestartGroup.changed(obj) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i7 = 2048;
                            i3 |= i7;
                        }
                    } else {
                        j3 = j;
                    }
                    i7 = 1024;
                    i3 |= i7;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    j4 = j2;
                    i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? 16384 : 8192;
                } else {
                    j4 = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    if ((i & 1572864) == 0) {
                        i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(windowInsets)) ? 1048576 : 524288;
                    }
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "725@31122L22,726@31178L37,728@31339L12");
                            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i8 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i4 != 0) {
                                    obj = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 8) != 0) {
                                    j3 = DrawerDefaults.INSTANCE.getStandardContainerColor(startRestartGroup, 6);
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                    i3 &= -57345;
                                }
                                if (i5 != 0) {
                                    f2 = DrawerDefaults.INSTANCE.m2047getDismissibleDrawerElevationD9Ej5fM();
                                }
                                if ((i2 & 64) != 0) {
                                    modifier2 = companion;
                                    shape2 = obj;
                                    j5 = j3;
                                    f3 = f2;
                                    j6 = j4;
                                    i6 = i3 & (-3670017);
                                    windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(496605370, i6, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:730)");
                                    }
                                    DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new NavigationDrawerKt$DismissibleDrawerSheet$2(windowInsets3, modifier2, shape2, j5, j6, f3, drawerState, function3), startRestartGroup, 54), startRestartGroup, (i6 & 14) | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    windowInsets2 = windowInsets3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                            }
                            modifier2 = companion;
                            shape2 = obj;
                            j5 = j3;
                            f3 = f2;
                            j6 = j4;
                            i6 = i3;
                            windowInsets3 = windowInsets;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new NavigationDrawerKt$DismissibleDrawerSheet$2(windowInsets3, modifier2, shape2, j5, j6, f3, drawerState, function3), startRestartGroup, 54), startRestartGroup, (i6 & 14) | 48);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            windowInsets2 = windowInsets3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            windowInsets2 = windowInsets;
                            modifier2 = companion;
                            shape2 = obj;
                            j5 = j3;
                            f3 = f2;
                            j6 = j4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$46(DrawerState.this, modifier2, shape2, j5, j6, f3, windowInsets2, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f2 = f;
                if ((i & 1572864) == 0) {
                }
                if ((i2 & 128) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = shape;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            if ((i & 1572864) == 0) {
            }
            if ((i2 & 128) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj = shape;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        if ((i & 1572864) == 0) {
        }
        if ((i2 & 128) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:273:? A[RETURN, SYNTHETIC] */
    /* renamed from: PermanentDrawerSheet-afqeVBk */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2289PermanentDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        long j3;
        long j4;
        int i4;
        float f2;
        WindowInsets windowInsets2;
        Object obj2;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape2;
        final long j5;
        final long j6;
        final float f3;
        final WindowInsets windowInsets3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        long j7;
        float f4;
        long j8;
        WindowInsets windowInsets4;
        Shape shape3;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1877158612);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermanentDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)772@33449L33,776@33617L30,773@33487L384:NavigationDrawer.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = shape;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    j3 = j;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? 2048 : 1024;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        windowInsets2 = windowInsets;
                        if (startRestartGroup.changed(windowInsets2)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    obj2 = function3;
                    i3 |= startRestartGroup.changedInstance(obj2) ? 1048576 : 524288;
                    if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "766@33142L22,767@33198L37,769@33357L12");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = modifier;
                            j8 = j4;
                            f4 = f2;
                            windowInsets4 = windowInsets2;
                            i5 = 1877158612;
                            shape3 = obj;
                            j7 = j3;
                        } else {
                            companion = i8 != 0 ? Modifier.Companion : modifier;
                            Shape rectangleShape = i9 != 0 ? RectangleShapeKt.getRectangleShape() : obj;
                            if ((i2 & 4) != 0) {
                                j7 = DrawerDefaults.INSTANCE.getStandardContainerColor(startRestartGroup, 6);
                                i3 &= -897;
                            } else {
                                j7 = j3;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j7, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            float m2050getPermanentDrawerElevationD9Ej5fM = i4 != 0 ? DrawerDefaults.INSTANCE.m2050getPermanentDrawerElevationD9Ej5fM() : f2;
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                shape3 = rectangleShape;
                                f4 = m2050getPermanentDrawerElevationD9Ej5fM;
                                j8 = j4;
                                i5 = 1877158612;
                                windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            } else {
                                f4 = m2050getPermanentDrawerElevationD9Ej5fM;
                                j8 = j4;
                                windowInsets4 = windowInsets2;
                                shape3 = rectangleShape;
                                i5 = 1877158612;
                            }
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:771)");
                        }
                        Strings.Companion companion2 = Strings.Companion;
                        final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.navigation_menu), startRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 63182258, "CC(remember):NavigationDrawer.kt#9igjgp");
                        boolean changed = startRestartGroup.changed(m3088getString2EP1pXo);
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$48$lambda$47(m3088getString2EP1pXo, (SemanticsPropertyReceiver) obj3);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        int i10 = i3 << 6;
                        composer2 = startRestartGroup;
                        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = obj2;
                        long j9 = j7;
                        m2285DrawerSheetcm3T3N0(null, windowInsets4, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), shape3, j9, j8, f4, null, function32, composer2, ((i3 >> 12) & 112) | 6 | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (i10 & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        windowInsets3 = windowInsets4;
                        shape2 = shape3;
                        j5 = j9;
                        j6 = j8;
                        f3 = f4;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        shape2 = obj;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        windowInsets3 = windowInsets2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$49(Modifier.this, shape2, j5, j6, f3, windowInsets3, function3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                obj2 = function3;
                if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            obj2 = function3;
            if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = shape;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        obj2 = function3;
        if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final Unit PermanentDrawerSheet_afqeVBk$lambda$48$lambda$47(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:331:? A[RETURN, SYNTHETIC] */
    /* renamed from: DrawerSheet-cm3T3N0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2285DrawerSheetcm3T3N0(final DrawerPredictiveBackState drawerPredictiveBackState, final WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, FloatProducer floatProducer, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Modifier.Companion companion;
        int i5;
        Object obj2;
        long j3;
        long j4;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape2;
        final long j5;
        final long j6;
        final float f2;
        final FloatProducer floatProducer2;
        ScopeUpdateScope endRestartGroup;
        int i8;
        FloatProducer floatProducer3;
        float f3;
        long j7;
        int i9;
        Modifier.Companion companion2;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1560288494);
        ComposerKt.sourceInformation(startRestartGroup, "C(DrawerSheet)N(drawerPredictiveBackState,windowInsets,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,drawerOffset,content)797@34436L7,800@34593L7,826@35796L867,807@34858L1805:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(drawerPredictiveBackState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = windowInsets;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i3 |= startRestartGroup.changed(companion) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj2 = shape;
                    i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            j3 = j;
                            if (startRestartGroup.changed(j3)) {
                                i12 = 16384;
                                i3 |= i12;
                            }
                        } else {
                            j3 = j;
                        }
                        i12 = 8192;
                        i3 |= i12;
                    } else {
                        j3 = j;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            j4 = j2;
                            if (startRestartGroup.changed(j4)) {
                                i11 = 131072;
                                i3 |= i11;
                            }
                        } else {
                            j4 = j2;
                        }
                        i11 = 65536;
                        i3 |= i11;
                    } else {
                        j4 = j2;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(f) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            if ((16777216 & i) == 0 ? startRestartGroup.changed(floatProducer) : startRestartGroup.changedInstance(floatProducer)) {
                                i10 = 8388608;
                                i3 |= i10;
                            }
                        }
                        i10 = 4194304;
                        i3 |= i10;
                    }
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        i7 = i3;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "791@34129L22,792@34185L37,794@34330L20");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                i8 = (i2 & 16) != 0 ? i7 & (-57345) : i7;
                                if ((i2 & 32) != 0) {
                                    i8 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i8 &= -29360129;
                                }
                                f3 = f;
                                j7 = j3;
                                i9 = 12582912;
                                floatProducer3 = floatProducer;
                            } else {
                                if (i4 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if (i5 != 0) {
                                    obj2 = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i2 & 16) != 0) {
                                    j3 = DrawerDefaults.INSTANCE.getStandardContainerColor(startRestartGroup, 6);
                                    i8 = i7 & (-57345);
                                } else {
                                    i8 = i7;
                                }
                                if ((i2 & 32) != 0) {
                                    j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i8 >> 12) & 14);
                                    i8 &= -458753;
                                }
                                float m2050getPermanentDrawerElevationD9Ej5fM = i6 != 0 ? DrawerDefaults.INSTANCE.m2050getPermanentDrawerElevationD9Ej5fM() : f;
                                if ((i2 & 128) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 493671010, "CC(remember):NavigationDrawer.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                                            @Override // androidx.compose.material3.internal.FloatProducer
                                            public final float invoke() {
                                                return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$51$lambda$50();
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    floatProducer3 = (FloatProducer) rememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    i8 &= -29360129;
                                } else {
                                    floatProducer3 = floatProducer;
                                }
                                f3 = m2050getPermanentDrawerElevationD9Ej5fM;
                                j7 = j3;
                                i9 = 12582912;
                            }
                            long j8 = j4;
                            Shape shape3 = obj2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1560288494, i8, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:796)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final float m3548getContainerWidthD9Ej5fM = NavigationDrawerTokens.INSTANCE.m3548getContainerWidthD9Ej5fM();
                            final float mo405toPx0680j_4 = ((Density) consume).mo405toPx0680j_4(m3548getContainerWidthD9Ej5fM);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            boolean z = consume2 == LayoutDirection.Rtl;
                            if (drawerPredictiveBackState != null) {
                                companion2 = predictiveBackDrawerContainer(Modifier.Companion, drawerPredictiveBackState, z);
                            } else {
                                companion2 = Modifier.Companion;
                            }
                            Modifier modifier3 = companion;
                            final FloatProducer floatProducer4 = floatProducer3;
                            final WindowInsets windowInsets2 = obj;
                            final boolean z2 = z;
                            int i13 = i8 >> 6;
                            composer2 = startRestartGroup;
                            SurfaceKt.m2569SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(horizontalScaleUp(SizeKt.m868sizeInqDBjuR0$default(modifier3, MinimumDrawerWidth, 0.0f, m3548getContainerWidthD9Ej5fM, 0.0f, 10, null), floatProducer3, mo405toPx0680j_4, z).then(companion2), 0.0f, 1, null), shape3, j7, j8, f3, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-315420087, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i14) {
                                    Modifier.Companion companion3;
                                    float f4;
                                    Modifier horizontalScaleDown;
                                    ComposerKt.sourceInformation(composer3, "C831@36016L641:NavigationDrawer.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-315420087, i14, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:827)");
                                    }
                                    if (DrawerPredictiveBackState.this != null) {
                                        companion3 = NavigationDrawerKt.predictiveBackDrawerChild(Modifier.Companion, DrawerPredictiveBackState.this, z2);
                                    } else {
                                        companion3 = Modifier.Companion;
                                    }
                                    f4 = NavigationDrawerKt.MinimumDrawerWidth;
                                    horizontalScaleDown = NavigationDrawerKt.horizontalScaleDown(SizeKt.m868sizeInqDBjuR0$default(Modifier.Companion, f4, 0.0f, m3548getContainerWidthD9Ej5fM, 0.0f, 10, null), floatProducer4, mo405toPx0680j_4, z2);
                                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(horizontalScaleDown.then(companion3), windowInsets2);
                                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, windowInsetsPadding);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m4041constructorimpl = Updater.m4041constructorimpl(composer3);
                                    Updater.m4049setimpl(m4041constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                    function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), composer2, (i13 & 112) | i9 | (i13 & 896) | (i13 & 7168) | (i13 & 57344), 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            floatProducer2 = floatProducer3;
                            shape2 = shape3;
                            j5 = j7;
                            j6 = j8;
                            f2 = f3;
                            modifier2 = modifier3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = companion;
                            shape2 = obj2;
                            j5 = j3;
                            j6 = j4;
                            f2 = f;
                            floatProducer2 = floatProducer;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$53(DrawerPredictiveBackState.this, windowInsets, modifier2, shape2, j5, j6, f2, floatProducer2, function3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i7 = i3;
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj2 = shape;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i2 & 256) == 0) {
                }
                i7 = i3;
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            companion = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            obj2 = shape;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i2 & 256) == 0) {
            }
            i7 = i3;
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = windowInsets;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        companion = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        obj2 = shape;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i2 & 256) == 0) {
        }
        i7 = i3;
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i7 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final Modifier horizontalScaleUp(Modifier modifier, final FloatProducer floatProducer, final float f, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.horizontalScaleUp$lambda$54(FloatProducer.this, f, z, (GraphicsLayerScope) obj);
            }
        });
    }

    public static final Unit horizontalScaleUp$lambda$54(FloatProducer floatProducer, float f, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float invoke = floatProducer.invoke();
        graphicsLayerScope.setScaleX(invoke > 0.0f ? (invoke / f) + 1.0f : 1.0f);
        graphicsLayerScope.mo4973setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.5f));
        return Unit.INSTANCE;
    }

    public static final Modifier horizontalScaleDown(Modifier modifier, final FloatProducer floatProducer, final float f, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.horizontalScaleDown$lambda$55(FloatProducer.this, f, z, (GraphicsLayerScope) obj);
            }
        });
    }

    public static final Unit horizontalScaleDown$lambda$55(FloatProducer floatProducer, float f, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float invoke = floatProducer.invoke();
        graphicsLayerScope.setScaleX(invoke > 0.0f ? 1.0f / ((invoke / f) + 1.0f) : 1.0f);
        graphicsLayerScope.mo4973setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.0f));
        return Unit.INSTANCE;
    }

    private static final Modifier predictiveBackDrawerContainer(Modifier modifier, final DrawerPredictiveBackState drawerPredictiveBackState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.predictiveBackDrawerContainer$lambda$56(DrawerPredictiveBackState.this, z, (GraphicsLayerScope) obj);
            }
        });
    }

    public static final Unit predictiveBackDrawerContainer$lambda$56(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, drawerPredictiveBackState));
        graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, drawerPredictiveBackState));
        graphicsLayerScope.mo4973setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 1.0f : 0.0f, 0.5f));
        return Unit.INSTANCE;
    }

    public static final Modifier predictiveBackDrawerChild(Modifier modifier, final DrawerPredictiveBackState drawerPredictiveBackState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.predictiveBackDrawerChild$lambda$57(DrawerPredictiveBackState.this, z, (GraphicsLayerScope) obj);
            }
        });
    }

    public static final Unit predictiveBackDrawerChild$lambda$57(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float calculatePredictiveBackScaleX = calculatePredictiveBackScaleX(graphicsLayerScope, drawerPredictiveBackState);
        graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX == 0.0f ? 1.0f : calculatePredictiveBackScaleY(graphicsLayerScope, drawerPredictiveBackState) / calculatePredictiveBackScaleX);
        graphicsLayerScope.mo4973setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.0f));
        return Unit.INSTANCE;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float intBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.mo4966getSizeNHjbRc() >> 32));
        if (Float.isNaN(intBitsToFloat) || intBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return ((drawerPredictiveBackState.getScaleXDistance() * (drawerPredictiveBackState.getSwipeEdgeMatchesDrawer() ? 1 : -1)) / intBitsToFloat) + 1.0f;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float intBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.mo4966getSizeNHjbRc() & 4294967295L));
        if (Float.isNaN(intBitsToFloat) || intBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (drawerPredictiveBackState.getScaleYDistance() / intBitsToFloat);
    }

    public static final void DrawerPredictiveBackHandler(final DrawerState drawerState, final Function3<? super DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        DrawerPredictiveBackState drawerPredictiveBackState;
        int i3;
        String str;
        NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 navigationDrawerKt$DrawerPredictiveBackHandler$2$1;
        Composer startRestartGroup = composer.startRestartGroup(-383087355);
        ComposerKt.sourceInformation(startRestartGroup, "C(DrawerPredictiveBackHandler)N(drawerState,content)942@40202L40,943@40259L24,944@40321L7,948@40483L7,954@40796L1297,954@40744L1349,986@42136L99,986@42099L136,992@42241L34:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i4 = i2;
        if (!startRestartGroup.shouldExecute((i4 & 19) != 18, i4 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-383087355, i4, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.kt:941)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1220245293, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DrawerPredictiveBackState();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            DrawerPredictiveBackState drawerPredictiveBackState2 = (DrawerPredictiveBackState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean z = consume == LayoutDirection.Rtl;
            Ref.FloatRef floatRef = new Ref.FloatRef();
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Ref.FloatRef floatRef3 = new Ref.FloatRef();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume2;
            floatRef.element = density.mo405toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceGrow);
            floatRef2.element = density.mo405toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceShrink);
            floatRef3.element = density.mo405toPx0680j_4(PredictiveBackDrawerMaxScaleYDistance);
            boolean isOpen = drawerState.isOpen();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1220265558, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i5 = i4 & 14;
            boolean changed = startRestartGroup.changed(z) | startRestartGroup.changed(floatRef.element) | startRestartGroup.changed(floatRef2.element) | startRestartGroup.changed(floatRef3.element) | startRestartGroup.changedInstance(coroutineScope) | (i5 == 4);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                drawerPredictiveBackState = drawerPredictiveBackState2;
                i3 = i5;
                str = "CC(remember):NavigationDrawer.kt#9igjgp";
                navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(drawerPredictiveBackState, coroutineScope, drawerState, z, floatRef, floatRef2, floatRef3, null);
                startRestartGroup.updateRememberedValue(navigationDrawerKt$DrawerPredictiveBackHandler$2$1);
            } else {
                str = "CC(remember):NavigationDrawer.kt#9igjgp";
                drawerPredictiveBackState = drawerPredictiveBackState2;
                navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = rememberedValue3;
                i3 = i5;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BackHandler_androidKt.PredictiveBackHandler(isOpen, navigationDrawerKt$DrawerPredictiveBackHandler$2$1, startRestartGroup, 0, 0);
            Boolean valueOf = Boolean.valueOf(drawerState.isClosed());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1220307240, str);
            boolean z2 = i3 == 4;
            NavigationDrawerKt$DrawerPredictiveBackHandler$3$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new NavigationDrawerKt$DrawerPredictiveBackHandler$3$1(drawerState, drawerPredictiveBackState, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue4, startRestartGroup, 0);
            function3.invoke(drawerPredictiveBackState, startRestartGroup, Integer.valueOf((i4 & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DrawerPredictiveBackHandler$lambda$62(DrawerState.this, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:190:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:307:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationDrawerItem(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        Object obj3;
        Object obj4;
        int i7;
        Composer composer2;
        final NavigationDrawerItemColors navigationDrawerItemColors2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Shape shape2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape3;
        Modifier modifier3;
        boolean z2;
        boolean z3;
        NavigationDrawerItemColors navigationDrawerItemColors3;
        MutableInteractionSource mutableInteractionSource3;
        NavigationDrawerItemColors navigationDrawerItemColors4;
        Modifier modifier4;
        ?? r2;
        int i8;
        Object obj5;
        int i9;
        Object obj6;
        Composer startRestartGroup = composer.startRestartGroup(-583709666);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationDrawerItem)N(label,selected,onClick,modifier,icon,badge,shape,colors,interactionSource)1083@46164L19,1087@46341L24,1089@46426L885,1078@46032L1279:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj = modifier;
                i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj2 = function22;
                    i3 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        obj3 = function23;
                        i3 |= startRestartGroup.changedInstance(obj3) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                obj5 = shape;
                                if (startRestartGroup.changed(obj5)) {
                                    i9 = 1048576;
                                    obj6 = obj5;
                                    i3 |= i9;
                                    obj4 = obj6;
                                }
                            } else {
                                obj5 = shape;
                            }
                            i9 = 524288;
                            obj6 = obj5;
                            i3 |= i9;
                            obj4 = obj6;
                        } else {
                            obj4 = shape;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i2 & 128) == 0 && startRestartGroup.changed(navigationDrawerItemColors)) {
                                i8 = 8388608;
                                i3 |= i8;
                            }
                            i8 = 4194304;
                            i3 |= i8;
                        }
                        i7 = i2 & 256;
                        if (i7 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "1074@45880L5,1075@45957L8");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                r2 = 1;
                                modifier4 = obj;
                                function26 = obj3;
                                shape3 = obj4;
                                z3 = false;
                                navigationDrawerItemColors4 = navigationDrawerItemColors;
                            } else {
                                Modifier.Companion companion = i4 != 0 ? Modifier.Companion : obj;
                                Function2<? super Composer, ? super Integer, Unit> function27 = i5 != 0 ? null : obj2;
                                function26 = i6 != 0 ? null : obj3;
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                    shape3 = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), startRestartGroup, 6);
                                } else {
                                    shape3 = obj4;
                                }
                                int i10 = i3;
                                if ((i2 & 128) != 0) {
                                    modifier3 = companion;
                                    z3 = false;
                                    z2 = true;
                                    navigationDrawerItemColors3 = NavigationDrawerItemDefaults.INSTANCE.m2282colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 100663296, 255);
                                    startRestartGroup = startRestartGroup;
                                    i3 = i10 & (-29360129);
                                } else {
                                    modifier3 = companion;
                                    z2 = true;
                                    z3 = false;
                                    navigationDrawerItemColors3 = navigationDrawerItemColors;
                                    i3 = i10;
                                }
                                mutableInteractionSource3 = i7 != 0 ? null : mutableInteractionSource;
                                navigationDrawerItemColors4 = navigationDrawerItemColors3;
                                obj2 = function27;
                                modifier4 = modifier3;
                                r2 = z2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1077)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1695745713, "CC(remember):NavigationDrawer.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj7) {
                                        return NavigationDrawerKt.NavigationDrawerItem$lambda$64$lambda$63((SemanticsPropertyReceiver) obj7);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i11 = i3 >> 3;
                            final NavigationDrawerItemColors navigationDrawerItemColors5 = navigationDrawerItemColors4;
                            final Function2<? super Composer, ? super Integer, Unit> function28 = obj2;
                            final Function2<? super Composer, ? super Integer, Unit> function29 = function26;
                            Modifier modifier5 = modifier4;
                            Shape shape4 = shape3;
                            SurfaceKt.m2570Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m852heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z3, (Function1) rememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m3546getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape4, navigationDrawerItemColors4.containerColor(z, startRestartGroup, (i11 & 14) | ((i3 >> 18) & 112)).getValue().m4782unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i12) {
                                    ComposerKt.sourceInformation(composer3, "C1090@46436L869:NavigationDrawer.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i12 & 3) != 2, i12 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1173018444, i12, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:1090)");
                                    }
                                    Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(Modifier.Companion, Dp.m7555constructorimpl(16.0f), 0.0f, Dp.m7555constructorimpl(24.0f), 0.0f, 10, null);
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function210 = function28;
                                    NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors5;
                                    boolean z4 = z;
                                    Function2<Composer, Integer, Unit> function211 = function29;
                                    Function2<Composer, Integer, Unit> function212 = function2;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m822paddingqDBjuR0$default);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m4041constructorimpl = Updater.m4041constructorimpl(composer3);
                                    Updater.m4049setimpl(m4041constructorimpl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2013922645, "C1099@46835L203:NavigationDrawer.kt#uh7d8r");
                                    if (function210 != null) {
                                        composer3.startReplaceGroup(-2013920011);
                                        ComposerKt.sourceInformation(composer3, "1095@46642L19,1096@46684L78,1097@46779L29");
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(navigationDrawerItemColors6.iconColor(z4, composer3, 0).getValue().m4782unboximpl())), function210, composer3, ProvidedValue.$stable);
                                        SpacerKt.Spacer(SizeKt.m869width3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(12.0f)), composer3, 6);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(-2013707630);
                                        composer3.endReplaceGroup();
                                    }
                                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.Companion, 1.0f, false, 2, null);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, weight$default);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m4041constructorimpl2 = Updater.m4041constructorimpl(composer3);
                                    Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1767721817, "C1100@46902L19,1101@46944L80:NavigationDrawer.kt#uh7d8r");
                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(navigationDrawerItemColors6.textColor(z4, composer3, 0).getValue().m4782unboximpl())), function212, composer3, ProvidedValue.$stable);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (function211 != null) {
                                        composer3.startReplaceGroup(-2013454639);
                                        ComposerKt.sourceInformation(composer3, "1104@47088L29,1105@47158L20,1106@47201L80");
                                        SpacerKt.Spacer(SizeKt.m869width3ABfNKs(Modifier.Companion, Dp.m7555constructorimpl(12.0f)), composer3, 6);
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(navigationDrawerItemColors6.badgeColor(z4, composer3, 0).getValue().m4782unboximpl())), function211, composer3, ProvidedValue.$stable);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(-2013238414);
                                        composer3.endReplaceGroup();
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, (i11 & WebSocketProtocol.PAYLOAD_SHORT) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                            composer2 = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape2 = shape4;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            navigationDrawerItemColors2 = navigationDrawerItemColors5;
                            modifier2 = modifier5;
                            function24 = function28;
                            function25 = function26;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                            modifier2 = obj;
                            function24 = obj2;
                            function25 = obj3;
                            shape2 = obj4;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj7, Object obj8) {
                                    return NavigationDrawerKt.NavigationDrawerItem$lambda$65(Function2.this, z, function0, modifier2, function24, function25, shape2, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj7, ((Integer) obj8).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj3 = function23;
                    if ((1572864 & i) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & 256;
                    if (i7 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj2 = function22;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                obj3 = function23;
                if ((1572864 & i) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = modifier;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj2 = function22;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            obj3 = function23;
            if ((1572864 & i) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 != 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        obj = modifier;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj2 = function22;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        obj3 = function23;
        if ((1572864 & i) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 != 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final Unit NavigationDrawerItem$lambda$64$lambda$63(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m6793setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m6781getTabo7Vup1c());
        return Unit.INSTANCE;
    }

    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* renamed from: Scrim-Bx497Mc */
    private static final void m2290ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)N(open,onClose,fraction,color:c#ui.graphics.Color)1285@54138L30,1300@54636L39,1300@54585L90:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j) ? 2048 : 1024;
        }
        if (!startRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1284)");
            }
            Strings.Companion companion2 = Strings.Companion;
            final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.close_drawer), startRestartGroup, 0);
            if (z) {
                startRestartGroup.startReplaceGroup(598792893);
                ComposerKt.sourceInformation(startRestartGroup, "1288@54256L35,1289@54344L187");
                Modifier.Companion companion3 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1404790366, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i3 = i2 & 112;
                boolean z2 = i3 == 32;
                NavigationDrawerKt$Scrim$dismissDrawer$1$1 rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function0);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion3, function0, (PointerInputEventHandler) rememberedValue);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1404793334, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean changed = (i3 == 32) | startRestartGroup.changed(m3088getString2EP1pXo);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.Scrim_Bx497Mc$lambda$69$lambda$68(m3088getString2EP1pXo, function0, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                companion = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(599116967);
                startRestartGroup.endReplaceGroup();
                companion = Modifier.Companion;
            }
            Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(companion);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1404802530, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean z3 = ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.Scrim_Bx497Mc$lambda$71$lambda$70(j, function02, (DrawScope) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.Scrim_Bx497Mc$lambda$72(z, function0, function02, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit Scrim_Bx497Mc$lambda$69$lambda$68(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NavigationDrawerKt.Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(Function0.this));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    public static final boolean Scrim_Bx497Mc$lambda$69$lambda$68$lambda$67(Function0 function0) {
        function0.invoke();
        return true;
    }

    public static final Unit Scrim_Bx497Mc$lambda$71$lambda$70(long j, Function0 function0, DrawScope drawScope) {
        DrawScope.m5340drawRectnJ9OG0$default(drawScope, j, 0L, 0L, ((Number) function0.invoke()).floatValue(), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return PredictiveBackDrawerMaxScaleYDistance;
    }
}
