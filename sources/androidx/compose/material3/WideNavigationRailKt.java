package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchorsConfig;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.NavigationRailHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
/* compiled from: WideNavigationRail.kt */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001as\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001am\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\u0017\u001a\u009d\u0001\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b \u0010!\u001a\u0089\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010'\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\b\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0004\b.\u0010/\u001aÖ\u0001\u00100\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0006\u00106\u001a\u00020721\u00108\u001a-\b\u0001\u0012\u0013\u0012\u001104¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010=\u0012\u0006\u0012\u0004\u0018\u00010>092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020@2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u001d2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\bC\u0010D\u001a\u001c\u0010E\u001a\u000204*\u00020F2\u0006\u0010G\u001a\u0002042\u0006\u0010H\u001a\u00020\u0015H\u0002\u001a\u0014\u0010I\u001a\u000204*\u00020F2\u0006\u0010G\u001a\u000204H\u0002\u001a=\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2\u001c\u0010M\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010=\u0012\u0006\u0012\u0004\u0018\u00010>0N2\u0006\u0010O\u001a\u00020\u0015H\u0003¢\u0006\u0004\bP\u0010Q\"\u0016\u0010R\u001a\u00020\u001dX\u0080\u0004¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010T\"\u0010\u0010V\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010W\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010X\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010Y\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010Z\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010[\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010\\\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010]\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010^\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010_\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010`\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u0010\u0010a\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U\"\u000e\u0010b\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010c\u001a\u00020dX\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020g0fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010i\"\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020k0fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010i¨\u0006m²\u0006\n\u0010n\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010q\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010r\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010s\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010u\u001a\u000204X\u008a\u0084\u0002²\u0006\n\u0010v\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"WideNavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/material3/WideNavigationRailState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", WideNavigationRailKt.HeaderLayoutIdTag, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WideNavigationRailLayout", "isModal", "", "expanded", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ModalWideNavigationRail", "hideOnCollapse", "collapsedShape", "expandedShape", "expandedHeaderTopPadding", "Landroidx/compose/ui/unit/Dp;", "expandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRail-k3FuEkE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "WideNavigationRailItem", "selected", "onClick", "icon", Constants.ScionAnalytics.PARAM_LABEL, "railExpanded", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "WideNavigationRailItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ModalWideNavigationRailContent", "isStandaloneModal", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "settleToDismiss", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "velocity", "Lkotlin/coroutines/Continuation;", "", "railState", "Landroidx/compose/material3/ModalWideNavigationRailState;", "openModalRailMaxWidth", "gesturesEnabled", "ModalWideNavigationRailContent-pU6N4AM", "(ZZLandroidx/compose/animation/core/Animatable;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ModalWideNavigationRailState;Landroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;FLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "swipeEdgeMatchesRail", "calculatePredictiveBackScaleY", "Scrim", "color", "Landroidx/compose/ui/graphics/Color;", "onDismissRequest", "Lkotlin/Function1;", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "WNRItemNoLabelIndicatorPadding", "getWNRItemNoLabelIndicatorPadding", "()F", "F", "ItemHorizontalPadding", "WNRVerticalPadding", "WNRHeaderPadding", "CollapsedRailWidth", "ExpandedRailMinWidth", "ExpandedRailMaxWidth", "TopIconItemMinHeight", "ItemTopIconIndicatorVerticalPadding", "ItemTopIconIndicatorHorizontalPadding", "ItemStartIconIndicatorVerticalPadding", "PredictiveBackMaxScaleXDistance", "PredictiveBackMaxScaleYDistance", "PredictiveBackPivotFractionY", "HeaderLayoutIdTag", "", "LocalWideNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/WideNavigationRailOverride;", "getLocalWideNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalModalWideNavigationRailOverride", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "getLocalModalWideNavigationRailOverride", "material3", "currentWidth", "", "actualMaxExpandedWidth", "minWidth", "widthFullRange", "itemVerticalSpacedBy", "itemMinHeight", "alpha", "dismiss"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WideNavigationRailKt {
    private static final String HeaderLayoutIdTag = "header";
    private static final float PredictiveBackPivotFractionY = 0.5f;
    private static final float WNRItemNoLabelIndicatorPadding = Dp.m7555constructorimpl(Dp.m7555constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m3575getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m3558getIconSizeD9Ej5fM()) / 2.0f);
    private static final float ItemHorizontalPadding = Dp.m7555constructorimpl(20.0f);
    private static final float WNRVerticalPadding = NavigationRailCollapsedTokens.INSTANCE.m3563getTopSpaceD9Ej5fM();
    private static final float WNRHeaderPadding = NavigationRailBaselineItemTokens.INSTANCE.m3557getHeaderSpaceMinimumD9Ej5fM();
    private static final float CollapsedRailWidth = NavigationRailCollapsedTokens.INSTANCE.m3560getContainerWidthD9Ej5fM();
    private static final float ExpandedRailMinWidth = NavigationRailExpandedTokens.INSTANCE.m3566getContainerWidthMinimumD9Ej5fM();
    private static final float ExpandedRailMaxWidth = NavigationRailExpandedTokens.INSTANCE.m3565getContainerWidthMaximumD9Ej5fM();
    private static final float TopIconItemMinHeight = NavigationRailBaselineItemTokens.INSTANCE.m3555getContainerHeightD9Ej5fM();
    private static final float ItemTopIconIndicatorVerticalPadding = Dp.m7555constructorimpl(Dp.m7555constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m3574getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m3558getIconSizeD9Ej5fM()) / 2.0f);
    private static final float ItemTopIconIndicatorHorizontalPadding = Dp.m7555constructorimpl(Dp.m7555constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m3575getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m3558getIconSizeD9Ej5fM()) / 2.0f);
    private static final float ItemStartIconIndicatorVerticalPadding = Dp.m7555constructorimpl(Dp.m7555constructorimpl(NavigationRailHorizontalItemTokens.INSTANCE.m3569getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m3558getIconSizeD9Ej5fM()) / 2.0f);
    private static final float PredictiveBackMaxScaleXDistance = Dp.m7555constructorimpl(24.0f);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m7555constructorimpl(48.0f);
    private static final ProvidableCompositionLocal<WideNavigationRailOverride> LocalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            WideNavigationRailOverride wideNavigationRailOverride;
            wideNavigationRailOverride = DefaultWideNavigationRailOverride.INSTANCE;
            return wideNavigationRailOverride;
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> LocalModalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ModalWideNavigationRailOverride modalWideNavigationRailOverride;
            modalWideNavigationRailOverride = DefaultModalWideNavigationRailOverride.INSTANCE;
            return modalWideNavigationRailOverride;
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$25(boolean z, boolean z2, Animatable animatable, RailPredictiveBackState railPredictiveBackState, Function2 function2, Modifier modifier, ModalWideNavigationRailState modalWideNavigationRailState, WideNavigationRailColors wideNavigationRailColors, Shape shape, float f, Function2 function22, WindowInsets windowInsets, boolean z3, Arrangement.Vertical vertical, Function2 function23, int i, int i2, Composer composer, int i3) {
        m2952ModalWideNavigationRailContentpU6N4AM(z, z2, animatable, railPredictiveBackState, function2, modifier, modalWideNavigationRailState, wideNavigationRailColors, shape, f, function22, windowInsets, z3, vertical, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRail_k3FuEkE$lambda$14(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2 function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, Function2 function22, int i, int i2, int i3, Composer composer, int i4) {
        m2951ModalWideNavigationRailk3FuEkE(modifier, wideNavigationRailState, z, shape, shape2, wideNavigationRailColors, function2, f, windowInsets, vertical, modalWideNavigationRailProperties, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Scrim_3J_VO9M$lambda$37(long j, Function1 function1, boolean z, int i, Composer composer, int i2) {
        m2953Scrim3JVO9M(j, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WideNavigationRail$lambda$1(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, Function2 function22, int i, int i2, Composer composer, int i3) {
        WideNavigationRail(modifier, wideNavigationRailState, shape, wideNavigationRailColors, function2, windowInsets, vertical, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WideNavigationRailItem_pli_t6k$lambda$16(boolean z, Function0 function0, Function2 function2, Function2 function22, boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m2954WideNavigationRailItemplit6k(z, function0, function2, function22, z2, modifier, z3, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit WideNavigationRailLayout$lambda$12(Modifier modifier, boolean z, boolean z2, WideNavigationRailColors wideNavigationRailColors, Shape shape, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, Function2 function22, int i, Composer composer, int i2) {
        WideNavigationRailLayout(modifier, z, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WideNavigationRail(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape2;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final WindowInsets windowInsets2;
        final Arrangement.Vertical vertical2;
        final WideNavigationRailState wideNavigationRailState2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        WideNavigationRailState wideNavigationRailState3;
        WideNavigationRailState wideNavigationRailState4;
        Arrangement.Vertical arrangement;
        Shape shape3;
        WideNavigationRailColors wideNavigationRailColors3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        WindowInsets windowInsets3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(164193188);
        ComposerKt.sourceInformation(startRestartGroup, "C(WideNavigationRail)N(modifier,state,shape,colors,header,windowInsets,arrangement,content)170@8485L7,*181@8852L20:WideNavigationRail.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
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
                if ((i & 64) == 0 ? startRestartGroup.changed(wideNavigationRailState) : startRestartGroup.changedInstance(wideNavigationRailState)) {
                    i8 = 32;
                    i3 |= i8;
                }
            }
            i8 = 16;
            i3 |= i8;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                obj2 = shape;
                if (startRestartGroup.changed(obj2)) {
                    i7 = 256;
                    i3 |= i7;
                }
            } else {
                obj2 = shape;
            }
            i7 = 128;
            i3 |= i7;
        } else {
            obj2 = shape;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                obj3 = wideNavigationRailColors;
                if (startRestartGroup.changed(obj3)) {
                    i6 = 2048;
                    i3 |= i6;
                }
            } else {
                obj3 = wideNavigationRailColors;
            }
            i6 = 1024;
            i3 |= i6;
        } else {
            obj3 = wideNavigationRailColors;
        }
        int i10 = i2 & 16;
        if (i10 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            obj4 = function2;
            i3 |= startRestartGroup.changedInstance(obj4) ? 16384 : 8192;
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj5 = windowInsets;
                    if (startRestartGroup.changed(obj5)) {
                        i5 = 131072;
                        i3 |= i5;
                    }
                } else {
                    obj5 = windowInsets;
                }
                i5 = 65536;
                i3 |= i5;
            } else {
                obj5 = windowInsets;
            }
            if ((1572864 & i) != 0) {
                if ((i2 & 64) == 0) {
                    obj6 = vertical;
                    if (startRestartGroup.changed(obj6)) {
                        i4 = 1048576;
                        i3 |= i4;
                    }
                } else {
                    obj6 = vertical;
                }
                i4 = 524288;
                i3 |= i4;
            } else {
                obj6 = vertical;
            }
            if ((i2 & 128) == 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                obj7 = function22;
                i3 |= startRestartGroup.changedInstance(obj7) ? 8388608 : 4194304;
                if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "162@8039L33,163@8120L5,164@8193L8,166@8309L12");
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
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                        wideNavigationRailState4 = wideNavigationRailState;
                        companion = obj;
                    } else {
                        companion = i9 != 0 ? Modifier.Companion : obj;
                        if ((i2 & 2) != 0) {
                            wideNavigationRailState3 = WideNavigationRailStateKt.rememberWideNavigationRailState(null, startRestartGroup, 0, 1);
                            i3 &= -113;
                        } else {
                            wideNavigationRailState3 = wideNavigationRailState;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            obj2 = WideNavigationRailDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            obj3 = WideNavigationRailDefaults.INSTANCE.colors(startRestartGroup, 6);
                        }
                        if (i10 != 0) {
                            obj4 = null;
                        }
                        if ((i2 & 32) != 0) {
                            obj5 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            i3 &= -458753;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            wideNavigationRailState4 = wideNavigationRailState3;
                            arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                            shape3 = obj2;
                            wideNavigationRailColors3 = obj3;
                            function24 = obj4;
                            windowInsets3 = obj5;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(164193188, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:169)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(LocalWideNavigationRailOverride);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier modifier3 = companion;
                            ((WideNavigationRailOverride) consume).WideNavigationRail(new WideNavigationRailOverrideScope(modifier3, wideNavigationRailState4, shape3, wideNavigationRailColors3, function24, windowInsets3, arrangement, obj7), startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            modifier2 = modifier3;
                            wideNavigationRailState2 = wideNavigationRailState4;
                            shape2 = shape3;
                            wideNavigationRailColors2 = wideNavigationRailColors3;
                            function23 = function24;
                            windowInsets2 = windowInsets3;
                            vertical2 = arrangement;
                        } else {
                            wideNavigationRailState4 = wideNavigationRailState3;
                        }
                    }
                    shape3 = obj2;
                    wideNavigationRailColors3 = obj3;
                    function24 = obj4;
                    windowInsets3 = obj5;
                    arrangement = obj6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(LocalWideNavigationRailOverride);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier modifier32 = companion;
                    ((WideNavigationRailOverride) consume2).WideNavigationRail(new WideNavigationRailOverrideScope(modifier32, wideNavigationRailState4, shape3, wideNavigationRailColors3, function24, windowInsets3, arrangement, obj7), startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    modifier2 = modifier32;
                    wideNavigationRailState2 = wideNavigationRailState4;
                    shape2 = shape3;
                    wideNavigationRailColors2 = wideNavigationRailColors3;
                    function23 = function24;
                    windowInsets2 = windowInsets3;
                    vertical2 = arrangement;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier2 = obj;
                    shape2 = obj2;
                    wideNavigationRailColors2 = obj3;
                    function23 = obj4;
                    windowInsets2 = obj5;
                    vertical2 = obj6;
                    wideNavigationRailState2 = wideNavigationRailState;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            return WideNavigationRailKt.WideNavigationRail$lambda$1(Modifier.this, wideNavigationRailState2, shape2, wideNavigationRailColors2, function23, windowInsets2, vertical2, function22, i, i2, (Composer) obj8, ((Integer) obj9).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            obj7 = function22;
            if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj4 = function2;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        obj7 = function22;
        if (startRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WideNavigationRailLayout(final Modifier modifier, final boolean z, final boolean z2, final WideNavigationRailColors wideNavigationRailColors, final Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, final Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        WideNavigationRailColors wideNavigationRailColors2;
        float m7569unboximpl;
        float m7555constructorimpl;
        Composer startRestartGroup = composer.startRestartGroup(-1004308036);
        ComposerKt.sourceInformation(startRestartGroup, "C(WideNavigationRailLayout)N(modifier,isModal,expanded,colors,shape,header,windowInsets,arrangement,content)219@9930L33,220@9998L33,222@10107L7,229@10373L11,230@10448L11,232@10488L195,237@10718L195,242@10954L170,247@11158L154,257@11558L8819,252@11318L9059:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            i2 |= startRestartGroup.changed(wideNavigationRailColors2) ? 2048 : 1024;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= startRestartGroup.changed(vertical) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
        }
        if (!startRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1004308036, i2, -1, "androidx.compose.material3.WideNavigationRailLayout (WideNavigationRail.kt:218)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1227630237, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableIntState mutableIntState = (MutableIntState) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1227632413, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableIntState mutableIntState2 = (MutableIntState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (!Dp.m7560equalsimpl0(((Dp) consume).m7569unboximpl(), Dp.Companion.m7575getUnspecifiedD9Ej5fM())) {
                startRestartGroup.startReplaceGroup(-597931134);
                ComposerKt.sourceInformation(startRestartGroup, "225@10219L7");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                m7569unboximpl = ((Dp) consume2).m7569unboximpl();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-597966102);
                startRestartGroup.endReplaceGroup();
                m7569unboximpl = Dp.m7555constructorimpl(0.0f);
            }
            float f = m7569unboximpl;
            FiniteAnimationSpec value = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, startRestartGroup, 6);
            FiniteAnimationSpec value2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, startRestartGroup, 6);
            State<Dp> m161animateDpAsStateAjpBEmI = AnimateAsStateKt.m161animateDpAsStateAjpBEmI(!z2 ? CollapsedRailWidth : ExpandedRailMinWidth, !z ? value : value2, null, null, startRestartGroup, 0, 12);
            float f2 = !z2 ? CollapsedRailWidth : ExpandedRailMaxWidth;
            if (!z) {
                value2 = value;
            }
            State<Dp> m161animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m161animateDpAsStateAjpBEmI(f2, value2, null, null, startRestartGroup, 0, 12);
            if (!z2) {
                m7555constructorimpl = NavigationRailCollapsedTokens.INSTANCE.m3561getItemVerticalSpaceD9Ej5fM();
            } else {
                m7555constructorimpl = Dp.m7555constructorimpl(0.0f);
            }
            FiniteAnimationSpec finiteAnimationSpec = value;
            State<Dp> m161animateDpAsStateAjpBEmI3 = AnimateAsStateKt.m161animateDpAsStateAjpBEmI(m7555constructorimpl, finiteAnimationSpec, null, null, startRestartGroup, 0, 12);
            int i3 = i2;
            SurfaceKt.m2569SurfaceT9BRK9s(modifier, shape, !z ? wideNavigationRailColors2.m2943getContainerColor0d7_KjU() : wideNavigationRailColors2.m2945getModalContainerColor0d7_KjU(), !z ? wideNavigationRailColors2.m2944getContentColor0d7_KjU() : wideNavigationRailColors2.m2946getModalContentColor0d7_KjU(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1489314345, true, new WideNavigationRailKt$WideNavigationRailLayout$1(windowInsets, function2, z2, m161animateDpAsStateAjpBEmI, f, AnimateAsStateKt.m161animateDpAsStateAjpBEmI(!z2 ? TopIconItemMinHeight : f, finiteAnimationSpec, null, null, startRestartGroup, 0, 12), m161animateDpAsStateAjpBEmI2, mutableIntState2, mutableIntState, vertical, m161animateDpAsStateAjpBEmI3, function22), startRestartGroup, 54), startRestartGroup, (i3 & 14) | 12582912 | ((i3 >> 9) & 112), 112);
            startRestartGroup = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailLayout$lambda$12(Modifier.this, z, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, function22, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WideNavigationRailLayout$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WideNavigationRailLayout$lambda$6(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0116  */
    /* renamed from: ModalWideNavigationRail-k3FuEkE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2951ModalWideNavigationRailk3FuEkE(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2<? super Composer, ? super Integer, Unit> function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2, final int i3) {
        Object obj;
        int i4;
        boolean z2;
        Object obj2;
        Object obj3;
        int i5;
        Object obj4;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        final WindowInsets windowInsets2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final Modifier modifier2;
        final float f3;
        final boolean z3;
        final Shape shape3;
        final Shape shape4;
        final WideNavigationRailState wideNavigationRailState2;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Arrangement.Vertical vertical2;
        final ModalWideNavigationRailProperties modalWideNavigationRailProperties2;
        ScopeUpdateScope endRestartGroup;
        WideNavigationRailState wideNavigationRailState3;
        Shape shape5;
        Shape shape6;
        WideNavigationRailColors wideNavigationRailColors3;
        WindowInsets windowInsets3;
        Arrangement.Vertical vertical3;
        ModalWideNavigationRailProperties modalWideNavigationRailProperties3;
        Modifier modifier3;
        Shape shape7;
        WideNavigationRailState wideNavigationRailState4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        float f4;
        WindowInsets windowInsets4;
        Arrangement.Vertical vertical4;
        boolean z4;
        Shape shape8;
        WideNavigationRailColors wideNavigationRailColors4;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-38559147);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalWideNavigationRail)N(modifier,state,hideOnCollapse,collapsedShape,expandedShape,colors,header,expandedHeaderTopPadding:c#ui.unit.Dp,windowInsets,arrangement,expandedProperties,content)493@24484L7,*493@24501L25:WideNavigationRail.kt#uh7d8r");
        int i16 = i3 & 1;
        if (i16 != 0) {
            i4 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i4 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i3 & 2) == 0) {
                if ((i & 64) == 0 ? startRestartGroup.changed(wideNavigationRailState) : startRestartGroup.changedInstance(wideNavigationRailState)) {
                    i15 = 32;
                    i4 |= i15;
                }
            }
            i15 = 16;
            i4 |= i15;
        }
        int i17 = i3 & 4;
        if (i17 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            z2 = z;
            i4 |= startRestartGroup.changed(z2) ? 256 : 128;
            if ((i & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    obj2 = shape;
                    if (startRestartGroup.changed(obj2)) {
                        i14 = 2048;
                        i4 |= i14;
                    }
                } else {
                    obj2 = shape;
                }
                i14 = 1024;
                i4 |= i14;
            } else {
                obj2 = shape;
            }
            if ((i & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    obj3 = shape2;
                    if (startRestartGroup.changed(obj3)) {
                        i13 = 16384;
                        i4 |= i13;
                    }
                } else {
                    obj3 = shape2;
                }
                i13 = 8192;
                i4 |= i13;
            } else {
                obj3 = shape2;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(wideNavigationRailColors)) ? 131072 : 65536;
            }
            i5 = i3 & 64;
            if (i5 == 0) {
                i4 |= 1572864;
                obj4 = function2;
            } else {
                obj4 = function2;
                if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(obj4) ? 1048576 : 524288;
                }
            }
            i6 = i3 & 128;
            if (i6 == 0) {
                i4 |= 12582912;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
            }
            if ((i & 100663296) == 0) {
                if ((i3 & 256) == 0 && startRestartGroup.changed(windowInsets)) {
                    i12 = 67108864;
                    i4 |= i12;
                }
                i12 = 33554432;
                i4 |= i12;
            }
            if ((i & 805306368) == 0) {
                if ((i3 & 512) == 0 && startRestartGroup.changed(vertical)) {
                    i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                    i4 |= i11;
                }
                i11 = 268435456;
                i4 |= i11;
            }
            i7 = i3 & 1024;
            if (i7 == 0) {
                i9 = i2 | 6;
                i8 = i7;
            } else if ((i2 & 6) == 0) {
                i8 = i7;
                i9 = i2 | (startRestartGroup.changed(modalWideNavigationRailProperties) ? 4 : 2);
            } else {
                i8 = i7;
                i9 = i2;
            }
            if ((i3 & 2048) == 0) {
                i9 |= 48;
            } else if ((i2 & 48) == 0) {
                i9 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
            }
            i10 = i9;
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
                startRestartGroup.startDefaults();
                ComposerKt.sourceInformation(startRestartGroup, "465@23180L33,467@23307L19,468@23382L18,469@23468L8,472@23625L12");
                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                    startRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                    }
                    if ((i3 & 256) != 0) {
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i4 &= -1879048193;
                    }
                    wideNavigationRailState4 = wideNavigationRailState;
                    wideNavigationRailColors4 = wideNavigationRailColors;
                    windowInsets4 = windowInsets;
                    vertical4 = vertical;
                    modalWideNavigationRailProperties3 = modalWideNavigationRailProperties;
                    function24 = obj4;
                    modifier3 = obj;
                    f4 = f2;
                    z4 = z2;
                    shape7 = obj2;
                    shape8 = obj3;
                } else {
                    Modifier.Companion companion = i16 != 0 ? Modifier.Companion : obj;
                    if ((i3 & 2) != 0) {
                        wideNavigationRailState3 = WideNavigationRailStateKt.rememberWideNavigationRailState(null, startRestartGroup, 0, 1);
                        i4 &= -113;
                    } else {
                        wideNavigationRailState3 = wideNavigationRailState;
                    }
                    if (i17 != 0) {
                        z2 = false;
                    }
                    if ((i3 & 8) != 0) {
                        shape5 = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(startRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        shape5 = obj2;
                    }
                    if ((i3 & 16) != 0) {
                        shape6 = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(startRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        shape6 = obj3;
                    }
                    if ((i3 & 32) != 0) {
                        wideNavigationRailColors3 = WideNavigationRailDefaults.INSTANCE.colors(startRestartGroup, 6);
                        i4 &= -458753;
                    } else {
                        wideNavigationRailColors3 = wideNavigationRailColors;
                    }
                    if (i5 != 0) {
                        obj4 = null;
                    }
                    float m7555constructorimpl = i6 != 0 ? Dp.m7555constructorimpl(0.0f) : f2;
                    if ((i3 & 256) != 0) {
                        windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        windowInsets3 = windowInsets;
                    }
                    if ((i3 & 512) != 0) {
                        vertical3 = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i4 &= -1879048193;
                    } else {
                        vertical3 = vertical;
                    }
                    if (i8 != 0) {
                        modifier3 = companion;
                        shape7 = shape5;
                        wideNavigationRailState4 = wideNavigationRailState3;
                        function24 = obj4;
                        f4 = m7555constructorimpl;
                        windowInsets4 = windowInsets3;
                        vertical4 = vertical3;
                        modalWideNavigationRailProperties3 = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                    } else {
                        modalWideNavigationRailProperties3 = modalWideNavigationRailProperties;
                        modifier3 = companion;
                        shape7 = shape5;
                        wideNavigationRailState4 = wideNavigationRailState3;
                        function24 = obj4;
                        f4 = m7555constructorimpl;
                        windowInsets4 = windowInsets3;
                        vertical4 = vertical3;
                    }
                    z4 = z2;
                    shape8 = shape6;
                    wideNavigationRailColors4 = wideNavigationRailColors3;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-38559147, i4, i10, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:477)");
                }
                ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope = new ModalWideNavigationRailOverrideScope(modifier3, wideNavigationRailState4, z4, shape7, shape8, wideNavigationRailColors4, function24, f4, windowInsets4, vertical4, modalWideNavigationRailProperties3, function22, null);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(LocalModalWideNavigationRailOverride);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ((ModalWideNavigationRailOverride) consume).ModalWideNavigationRail(modalWideNavigationRailOverrideScope, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = startRestartGroup;
                modifier2 = modifier3;
                wideNavigationRailState2 = wideNavigationRailState4;
                z3 = z4;
                shape3 = shape7;
                shape4 = shape8;
                wideNavigationRailColors2 = wideNavigationRailColors4;
                function23 = function24;
                f3 = f4;
                windowInsets2 = windowInsets4;
                vertical2 = vertical4;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties3;
            } else {
                startRestartGroup.skipToGroupEnd();
                windowInsets2 = windowInsets;
                composer2 = startRestartGroup;
                function23 = obj4;
                modifier2 = obj;
                f3 = f2;
                z3 = z2;
                shape3 = obj2;
                shape4 = obj3;
                wideNavigationRailState2 = wideNavigationRailState;
                wideNavigationRailColors2 = wideNavigationRailColors;
                vertical2 = vertical;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj5, Object obj6) {
                        return WideNavigationRailKt.ModalWideNavigationRail_k3FuEkE$lambda$14(Modifier.this, wideNavigationRailState2, z3, shape3, shape4, wideNavigationRailColors2, function23, f3, windowInsets2, vertical2, modalWideNavigationRailProperties2, function22, i, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                    }
                });
                return;
            }
            return;
        }
        z2 = z;
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i5 = i3 & 64;
        if (i5 == 0) {
        }
        i6 = i3 & 128;
        if (i6 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i7 = i3 & 1024;
        if (i7 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        i10 = i9;
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0108  */
    /* renamed from: WideNavigationRailItem-pli-t6k  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2954WideNavigationRailItemplit6k(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        boolean z4;
        int i4;
        Function0<Unit> function02;
        Object obj;
        Object obj2;
        int i5;
        Modifier.Companion companion;
        int i6;
        boolean z5;
        int i7;
        Object obj3;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final Modifier modifier2;
        final boolean z6;
        final int i11;
        final NavigationItemColors navigationItemColors2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        int i12;
        int i13;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1894733304);
        ComposerKt.sourceInformation(startRestartGroup, "C(WideNavigationRailItem)N(selected,onClick,icon,label,railExpanded,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)696@33504L5,698@33677L5,699@33767L5,692@33324L1318:WideNavigationRail.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            z4 = z;
        } else {
            z4 = z;
            if ((i2 & 6) == 0) {
                i4 = (startRestartGroup.changed(z4) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i2 & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = function2;
            i4 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                obj2 = function22;
                i4 |= startRestartGroup.changedInstance(obj2) ? 2048 : 1024;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                }
                i5 = i3 & 32;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    companion = modifier;
                    i4 |= startRestartGroup.changed(companion) ? 131072 : 65536;
                    i6 = i3 & 64;
                    if (i6 == 0) {
                        i4 |= 1572864;
                    } else if ((1572864 & i2) == 0) {
                        z5 = z3;
                        i4 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                        if ((12582912 & i2) == 0) {
                            if ((i3 & 128) == 0) {
                                i7 = i;
                                if (startRestartGroup.changed(i7)) {
                                    i15 = 8388608;
                                    i4 |= i15;
                                }
                            } else {
                                i7 = i;
                            }
                            i15 = 4194304;
                            i4 |= i15;
                        } else {
                            i7 = i;
                        }
                        if ((100663296 & i2) == 0) {
                            if ((i3 & 256) == 0) {
                                obj3 = navigationItemColors;
                                if (startRestartGroup.changed(obj3)) {
                                    i14 = 67108864;
                                    i4 |= i14;
                                }
                            } else {
                                obj3 = navigationItemColors;
                            }
                            i14 = 33554432;
                            i4 |= i14;
                        } else {
                            obj3 = navigationItemColors;
                        }
                        i8 = i3 & 512;
                        if (i8 != 0) {
                            i4 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i9 = i8;
                            i4 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            i10 = i4;
                            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i10 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "686@33127L8");
                                if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if (i6 != 0) {
                                        z5 = true;
                                    }
                                    if ((i3 & 128) != 0) {
                                        i12 = i10 & (-29360129);
                                        i7 = WideNavigationRailItemDefaults.INSTANCE.m2950iconPositionFors8pcRp0(z2);
                                    } else {
                                        i12 = i10;
                                    }
                                    if ((i3 & 256) != 0) {
                                        i12 &= -234881025;
                                        obj3 = WideNavigationRailItemDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    }
                                    i13 = i12;
                                    if (i9 != 0) {
                                        mutableInteractionSource3 = null;
                                        Modifier modifier3 = companion;
                                        boolean z7 = z5;
                                        int i16 = i7;
                                        NavigationItemColors navigationItemColors3 = obj3;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1894733304, i13, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:688)");
                                        }
                                        if (mutableInteractionSource3 != null) {
                                            startRestartGroup.startReplaceGroup(-1539072909);
                                            ComposerKt.sourceInformation(startRestartGroup, "690@33279L39");
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 227447151, "CC(remember):WideNavigationRail.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            startRestartGroup.endReplaceGroup();
                                            mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                                        } else {
                                            startRestartGroup.startReplaceGroup(227446500);
                                            startRestartGroup.endReplaceGroup();
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                        }
                                        int i17 = i13 << 3;
                                        composer2 = startRestartGroup;
                                        NavigationItemKt.m2311AnimatedNavigationItemDQd_Gtc(z4, function02, obj, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), startRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m3575getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), startRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), startRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m3576getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m3570getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m3572getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors3, modifier3, z7, obj2, i16, mutableInteractionSource4, composer2, (i13 & 14) | 918577152 | (i13 & 112) | (i13 & 896), ((i13 >> 9) & 458752) | 28086 | (3670016 & i17) | (i17 & 29360128) | ((i13 << 15) & 234881024) | ((i13 << 6) & 1879048192), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        navigationItemColors2 = navigationItemColors3;
                                        modifier2 = modifier3;
                                        z6 = z7;
                                        i11 = i16;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    i13 = (i3 & 128) != 0 ? i10 & (-29360129) : i10;
                                    if ((i3 & 256) != 0) {
                                        i13 &= -234881025;
                                    }
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                Modifier modifier32 = companion;
                                boolean z72 = z5;
                                int i162 = i7;
                                NavigationItemColors navigationItemColors32 = obj3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (mutableInteractionSource3 != null) {
                                }
                                int i172 = i13 << 3;
                                composer2 = startRestartGroup;
                                NavigationItemKt.m2311AnimatedNavigationItemDQd_Gtc(z4, function02, obj, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), startRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m3575getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), startRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), startRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m3576getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m3570getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m3572getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors32, modifier32, z72, obj2, i162, mutableInteractionSource4, composer2, (i13 & 14) | 918577152 | (i13 & 112) | (i13 & 896), ((i13 >> 9) & 458752) | 28086 | (3670016 & i172) | (i172 & 29360128) | ((i13 << 15) & 234881024) | ((i13 << 6) & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                mutableInteractionSource2 = mutableInteractionSource3;
                                navigationItemColors2 = navigationItemColors32;
                                modifier2 = modifier32;
                                z6 = z72;
                                i11 = i162;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = companion;
                                z6 = z5;
                                i11 = i7;
                                navigationItemColors2 = obj3;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj4, Object obj5) {
                                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$16(z, function0, function2, function22, z2, modifier2, z6, i11, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj4, ((Integer) obj5).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i9 = i8;
                        i10 = i4;
                        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i10 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z5 = z3;
                    if ((12582912 & i2) == 0) {
                    }
                    if ((100663296 & i2) == 0) {
                    }
                    i8 = i3 & 512;
                    if (i8 != 0) {
                    }
                    i9 = i8;
                    i10 = i4;
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i10 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                companion = modifier;
                i6 = i3 & 64;
                if (i6 == 0) {
                }
                z5 = z3;
                if ((12582912 & i2) == 0) {
                }
                if ((100663296 & i2) == 0) {
                }
                i8 = i3 & 512;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i4;
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i10 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj2 = function22;
            if ((i3 & 16) != 0) {
            }
            i5 = i3 & 32;
            if (i5 != 0) {
            }
            companion = modifier;
            i6 = i3 & 64;
            if (i6 == 0) {
            }
            z5 = z3;
            if ((12582912 & i2) == 0) {
            }
            if ((100663296 & i2) == 0) {
            }
            i8 = i3 & 512;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i4;
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i10 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = function2;
        if ((i3 & 8) == 0) {
        }
        obj2 = function22;
        if ((i3 & 16) != 0) {
        }
        i5 = i3 & 32;
        if (i5 != 0) {
        }
        companion = modifier;
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        z5 = z3;
        if ((12582912 & i2) == 0) {
        }
        if ((100663296 & i2) == 0) {
        }
        i8 = i3 & 512;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i4;
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378, i10 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* renamed from: ModalWideNavigationRailContent-pU6N4AM  reason: not valid java name */
    public static final void m2952ModalWideNavigationRailContentpU6N4AM(final boolean z, final boolean z2, final Animatable<Float, AnimationVector1D> animatable, final RailPredictiveBackState railPredictiveBackState, final Function2<? super Float, ? super Continuation<? super Unit>, ? extends Object> function2, final Modifier modifier, final ModalWideNavigationRailState modalWideNavigationRailState, final WideNavigationRailColors wideNavigationRailColors, final Shape shape, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, final WindowInsets windowInsets, final boolean z3, final Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i, final int i2) {
        int i3;
        WideNavigationRailColors wideNavigationRailColors2;
        int i4;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1593438005);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalWideNavigationRailContent)N(expanded,isStandaloneModal,predictiveBackProgress,predictiveBackState,settleToDismiss,modifier,railState,colors,shape,openModalRailMaxWidth:c#ui.unit.Dp,header,windowInsets,gesturesEnabled,arrangement,content)989@47315L7,990@47370L55,1000@47710L29,1001@47771L904,1020@48768L649,1041@49760L23,1043@49810L1311,992@47431L3690:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= (i & 512) == 0 ? startRestartGroup.changed(animatable) : startRestartGroup.changedInstance(animatable) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(railPredictiveBackState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(modalWideNavigationRailState) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            i3 |= startRestartGroup.changed(wideNavigationRailColors2) ? 8388608 : 4194304;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(f) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function22) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(windowInsets) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changed(vertical) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        int i5 = i4;
        if (!startRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 9363) == 9362) ? false : true, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1593438005, i3, i5, "androidx.compose.material3.ModalWideNavigationRailContent (WideNavigationRail.kt:988)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final boolean z4 = consume == LayoutDirection.Rtl;
            Strings.Companion companion = Strings.Companion;
            final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_wide_navigation_rail_pane_title), startRestartGroup, 0);
            long m2945getModalContainerColor0d7_KjU = wideNavigationRailColors2.m2945getModalContainerColor0d7_KjU();
            long m2946getModalContentColor0d7_KjU = wideNavigationRailColors2.m2946getModalContentColor0d7_KjU();
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m871widthInVpY3zN4$default(modifier, 0.0f, f, 1, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009435560, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m3088getString2EP1pXo);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$18$lambda$17(m3088getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(fillMaxHeight$default, false, (Function1) rememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009438387, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean changedInstance = ((i3 & 896) == 256 || ((i3 & 512) != 0 && startRestartGroup.changedInstance(animatable))) | startRestartGroup.changedInstance(modalWideNavigationRailState) | ((i3 & 7168) == 2048) | startRestartGroup.changed(z4);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$20$lambda$19(Animatable.this, modalWideNavigationRailState, railPredictiveBackState, z4, (GraphicsLayerScope) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(semantics$default, (Function1) rememberedValue2);
            AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState$material3 = modalWideNavigationRailState.getAnchoredDraggableState$material3();
            Orientation orientation = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009470036, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean changed2 = ((i3 & 112) == 32) | startRestartGroup.changed(z4) | startRestartGroup.changedInstance(modalWideNavigationRailState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22(z2, z4, modalWideNavigationRailState, (IntSize) obj, (Constraints) obj2);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier draggableAnchors = AnchoredDraggableKt.draggableAnchors(graphicsLayer, anchoredDraggableState$material3, orientation, (Function2) rememberedValue3);
            DraggableState draggableState$material3 = modalWideNavigationRailState.getAnchoredDraggableState$material3().getDraggableState$material3();
            Orientation orientation2 = Orientation.Horizontal;
            boolean isAnimationRunning = modalWideNavigationRailState.getAnchoredDraggableState$material3().isAnimationRunning();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009501154, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(function2);
            WideNavigationRailKt$ModalWideNavigationRailContent$4$1 rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new WideNavigationRailKt$ModalWideNavigationRailContent$4$1(function2, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            SurfaceKt.m2569SurfaceT9BRK9s(DraggableKt.draggable$default(draggableAnchors, draggableState$material3, orientation2, z3, null, isAnimationRunning, null, rememberedValue4, false, 168, null), shape, m2945getModalContainerColor0d7_KjU, m2946getModalContentColor0d7_KjU, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1043835354, true, new WideNavigationRailKt$ModalWideNavigationRailContent$5(animatable, railPredictiveBackState, z4, z, wideNavigationRailColors2, shape, function22, windowInsets, vertical, function23), composer2, 54), composer2, ((i3 >> 21) & 112) | 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$25(z, z2, animatable, railPredictiveBackState, function2, modifier, modalWideNavigationRailState, wideNavigationRailColors, shape, f, function22, windowInsets, z3, vertical, function23, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$18$lambda$17(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$20$lambda$19(Animatable animatable, ModalWideNavigationRailState modalWideNavigationRailState, RailPredictiveBackState railPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float floatValue = ((Number) animatable.getValue()).floatValue();
        if (floatValue <= 0.0f) {
            return Unit.INSTANCE;
        }
        float currentOffset = modalWideNavigationRailState.getCurrentOffset();
        float intBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.mo4966getSizeNHjbRc() >> 32));
        if (!Float.isNaN(currentOffset) && !Float.isNaN(intBitsToFloat) && intBitsToFloat != 0.0f) {
            graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, floatValue, railPredictiveBackState.getSwipeEdgeMatchesRail()));
            graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, floatValue));
            graphicsLayerScope.mo4973setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 1.0f : 0.0f, 0.5f));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Pair ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22(boolean z, boolean z2, ModalWideNavigationRailState modalWideNavigationRailState, IntSize intSize, Constraints constraints) {
        final float m7730unboximpl = (int) (intSize.m7730unboximpl() >> 32);
        if (!z) {
            m7730unboximpl = 0.0f;
        } else if (!z2) {
            m7730unboximpl = -m7730unboximpl;
        }
        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22$lambda$21(m7730unboximpl, r2, (DraggableAnchorsConfig) obj);
            }
        }), modalWideNavigationRailState.getTargetValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$23$lambda$22$lambda$21(float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(WideNavigationRailValue.Collapsed, f);
        draggableAnchorsConfig.at(WideNavigationRailValue.Expanded, f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f, boolean z) {
        float intBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.mo4966getSizeNHjbRc() >> 32));
        if (Float.isNaN(intBitsToFloat) || intBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return (((z ? 1.0f : -1.0f) * MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo405toPx0680j_4(PredictiveBackMaxScaleXDistance), intBitsToFloat), f)) / intBitsToFloat) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f) {
        float intBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.mo4966getSizeNHjbRc() & 4294967295L));
        if (Float.isNaN(intBitsToFloat) || intBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo405toPx0680j_4(PredictiveBackMaxScaleYDistance), intBitsToFloat), f) / intBitsToFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M  reason: not valid java name */
    public static final void m2953Scrim3JVO9M(final long j, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(144695261);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible):WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if (startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(144695261, i2, -1, "androidx.compose.material3.Scrim (WideNavigationRail.kt:1102)");
            }
            if (j != 16) {
                startRestartGroup.startReplaceGroup(-1530482291);
                ComposerKt.sourceInformation(startRestartGroup, "1108@52256L7,1105@52025L253,1110@52302L34,1111@52366L28,1125@52948L79,1125@52894L133,1129@53061L35,1129@53037L59");
                int i3 = i2;
                final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, startRestartGroup, 6), 0.0f, null, null, startRestartGroup, 0, 28);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1613206495, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Strings.Companion companion2 = Strings.Companion;
                final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_wide_navigation_rail_close_rail), startRestartGroup, 0);
                if (z) {
                    startRestartGroup.startReplaceGroup(-1530047423);
                    ComposerKt.sourceInformation(startRestartGroup, "1114@52509L40,1115@52606L219");
                    Modifier.Companion companion3 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1613213125, "CC(remember):WideNavigationRail.kt#9igjgp");
                    WideNavigationRailKt$Scrim$dismissModalRail$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new WideNavigationRailKt$Scrim$dismissModalRail$1$1(mutableState);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion3, function1, (PointerInputEventHandler) rememberedValue2);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1613216408, "CC(remember):WideNavigationRail.kt#9igjgp");
                    boolean changed = startRestartGroup.changed(m3088getString2EP1pXo);
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return WideNavigationRailKt.Scrim_3J_VO9M$lambda$33$lambda$32(m3088getString2EP1pXo, mutableState, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    companion = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue3);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1529667363);
                    startRestartGroup.endReplaceGroup();
                    companion = Modifier.Companion;
                }
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(companion);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1613227212, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean changed2 = ((i3 & 14) == 4) | startRestartGroup.changed(animateFloatAsState);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WideNavigationRailKt.Scrim_3J_VO9M$lambda$35$lambda$34(j, animateFloatAsState, (DrawScope) obj);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                CanvasKt.Canvas(then, (Function1) rememberedValue4, startRestartGroup, 0);
                Boolean valueOf = Boolean.valueOf(Scrim_3J_VO9M$lambda$28(mutableState));
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1613230784, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(function1);
                WideNavigationRailKt$Scrim$2$1 rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new WideNavigationRailKt$Scrim$2$1(function1, mutableState, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue5, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1529413659);
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
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.Scrim_3J_VO9M$lambda$37(j, function1, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_3J_VO9M$lambda$28(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Scrim_3J_VO9M$lambda$29(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Scrim_3J_VO9M$lambda$33$lambda$32(String str, final MutableState mutableState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(WideNavigationRailKt.Scrim_3J_VO9M$lambda$33$lambda$32$lambda$31(MutableState.this));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean Scrim_3J_VO9M$lambda$33$lambda$32$lambda$31(MutableState mutableState) {
        Scrim_3J_VO9M$lambda$29(mutableState, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Scrim_3J_VO9M$lambda$35$lambda$34(long j, State state, DrawScope drawScope) {
        DrawScope.m5340drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(Scrim_3J_VO9M$lambda$26(state), 0.0f, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final float getWNRItemNoLabelIndicatorPadding() {
        return WNRItemNoLabelIndicatorPadding;
    }

    public static final ProvidableCompositionLocal<WideNavigationRailOverride> getLocalWideNavigationRailOverride() {
        return LocalWideNavigationRailOverride;
    }

    public static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> getLocalModalWideNavigationRailOverride() {
        return LocalModalWideNavigationRailOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$8(State<Dp> state) {
        return state.getValue().m7569unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$9(State<Dp> state) {
        return state.getValue().m7569unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$10(State<Dp> state) {
        return state.getValue().m7569unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$11(State<Dp> state) {
        return state.getValue().m7569unboximpl();
    }

    private static final float Scrim_3J_VO9M$lambda$26(State<Float> state) {
        return state.getValue().floatValue();
    }
}
