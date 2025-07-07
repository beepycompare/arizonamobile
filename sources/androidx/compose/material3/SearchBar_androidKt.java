package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.activity.BackEventCompat;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import okhttp3.internal.ws.WebSocketProtocol;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteView;
/* compiled from: SearchBar.android.kt */
@Metadata(d1 = {"\u0000¾\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0091\u0001\u0010,\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u0089\u0002\u0010,\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001a2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0006\u0010E\u001a\u0002022\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010G\u001a\u0002022\u0015\b\u0002\u0010H\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u0010I\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u0010J\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a\u009b\u0001\u0010O\u001a\u00020-2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\b\b\u0002\u0010P\u001a\u00020Q2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0007ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a\u0093\u0002\u0010O\u001a\u00020-2\u0006\u0010B\u001a\u00020\u001a2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020-042\u0006\u0010E\u001a\u0002022\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020-042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010G\u001a\u0002022\u0015\b\u0002\u0010H\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u0010I\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u0010J\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\b\b\u0002\u0010P\u001a\u00020Q2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0007ø\u0001\u0000¢\u0006\u0004\bT\u0010U\u001a»\u0001\u0010V\u001a\u00020-2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020Y0X2\u0006\u0010Z\u001a\u00020[2\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u000e\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\b\b\u0002\u00105\u001a\u0002062\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00152\b\b\u0002\u0010P\u001a\u00020Q2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020-04¢\u0006\u0002\b0¢\u0006\u0002\b?H\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a\u0094\u0001\u0010b\u001a\u00020-2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020Y0X2\u0006\u0010Z\u001a\u00020[2\u000e\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u000e\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0]2\u0006\u00105\u001a\u0002062\u0006\u0010P\u001a\u00020Q2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\u0011\u0010c\u001a\r\u0012\u0004\u0012\u00020-0/¢\u0006\u0002\b02\u0013\u0010=\u001a\u000f\u0012\u0004\u0012\u00020-\u0018\u00010/¢\u0006\u0002\b0H\u0003¢\u0006\u0002\u0010d\u001a\"\u0010e\u001a\u00020\u00072\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0007H\u0002\u001aD\u0010g\u001a\u00020\u00012\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00012\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010k\u001a\u00020l2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010m\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\bn\u0010o\u001aN\u0010p\u001a\u00020\u00012\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020\u00012\b\u0010_\u001a\u0004\u0018\u00010^2\b\u0010\\\u001a\u0004\u0018\u00010^2\u0006\u0010q\u001a\u00020\u00012\u0006\u0010r\u001a\u00020\u00012\u0006\u0010m\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017\"\u000e\u0010\u0019\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\u00020\u0015X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0018\u0012\u0004\b\u001e\u0010\u001f\"\u0010\u0010 \u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0010\u0010!\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0016\u0010\"\u001a\u00020\u0015X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b#\u0010\u0017\"\u000e\u0010$\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010%\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u0010\u0010&\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018\"\u000e\u0010'\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010(\u001a\u00020\u0015X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b)\u0010\u0017\"\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006u²\u0006\n\u0010v\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u0010w\u001a\u000202X\u008a\u0084\u0002"}, d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "AnimationPredictiveBackExitFloatSpec", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "DockedExpandedTableMaxHeightScreenRatio", "DockedExpandedTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedExpandedTableMinHeight", "()F", "F", "LayoutIdInputField", "", "LayoutIdSearchContent", "LayoutIdSurface", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMinScale", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "DockedSearchBar", "", "inputField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "shadowElevation", FirebaseAnalytics.Param.CONTENT, "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-EQC0FA8", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", SearchIntents.EXTRA_QUERY, "onQueryChange", "onSearch", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "onActiveChange", "enabled", "placeholder", "leadingIcon", "trailingIcon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-Y92LkZI", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", "progress", "calculatePredictiveBackOffsetX", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "material3_release", "useFullScreenShape", "showContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBar_androidKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final FiniteAnimationSpec<Float> AnimationPredictiveBackExitFloatSpec;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float DockedExpandedTableMaxHeightScreenRatio = 0.6666667f;
    private static final String LayoutIdInputField = "InputField";
    private static final String LayoutIdSearchContent = "Content";
    private static final String LayoutIdSurface = "Surface";
    private static final float SearchBarPredictiveBackMaxOffsetXRatio = 0.05f;
    private static final float SearchBarPredictiveBackMinMargin;
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final float SearchBarVerticalPadding;
    private static final TextFieldColors UnspecifiedTextFieldColors = new TextFieldColors(Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), new TextSelectionColors(Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), null), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4114getUnspecified0d7_KjU(), null);
    private static final float SearchBarCornerRadius = Dp.m6684constructorimpl(SearchBarDefaults.INSTANCE.m2222getInputFieldHeightD9Ej5fM() / 2);
    private static final float DockedExpandedTableMinHeight = Dp.m6684constructorimpl(240);
    private static final float SearchBarMinWidth = Dp.m6684constructorimpl((float) RouletteView.PREMIUM_ROULETTE_WIDTH);
    private static final float SearchBarMaxWidth = Dp.m6684constructorimpl(720);
    private static final float SearchBarIconOffsetX = Dp.m6684constructorimpl(4);
    private static final float SearchBarPredictiveBackMaxOffsetY = Dp.m6684constructorimpl(24);

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010c  */
    /* renamed from: SearchBar-Y92LkZI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2230SearchBarY92LkZI(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        int i4;
        Object obj2;
        Shape shape2;
        SearchBarColors searchBarColors2;
        int i5;
        float f3;
        int i6;
        float f4;
        WindowInsets windowInsets2;
        int i7;
        Shape shape3;
        int i8;
        int i9;
        SearchBarColors searchBarColors3;
        int i10;
        WindowInsets windowInsets3;
        Object obj3;
        SearchBarColors searchBarColors4;
        int i11;
        float f5;
        float f6;
        Shape shape4;
        Object rememberedValue;
        Animatable animatable;
        Object rememberedValue2;
        MutableFloatState mutableFloatState;
        Object rememberedValue3;
        Object rememberedValue4;
        int i12;
        boolean changedInstance;
        SearchBar_androidKt$SearchBar$1$1 rememberedValue5;
        Object obj4;
        Shape shape5;
        int i13;
        String str;
        MutableFloatState mutableFloatState2;
        Object rememberedValue6;
        boolean changedInstance2;
        SearchBar_androidKt$SearchBar$2$1 rememberedValue7;
        Animatable animatable2;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape6;
        final SearchBarColors searchBarColors5;
        final float f7;
        final float f8;
        final WindowInsets windowInsets4;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(1444649673);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp,9)171@8255L15,172@8320L8,175@8501L12,178@8596L64,179@8689L43,180@8758L51,181@8837L51,183@8919L638,183@8894L663,199@9582L27,200@9656L1062,200@9614L1104,226@10724L458:SearchBar.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(obj) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                obj2 = modifier;
                i3 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i16 = 16384;
                            i3 |= i16;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i16 = 8192;
                    i3 |= i16;
                } else {
                    shape2 = shape;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        searchBarColors2 = searchBarColors;
                        if (startRestartGroup.changed(searchBarColors2)) {
                            i15 = 131072;
                            i3 |= i15;
                        }
                    } else {
                        searchBarColors2 = searchBarColors;
                    }
                    i15 = 65536;
                    i3 |= i15;
                } else {
                    searchBarColors2 = searchBarColors;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    f3 = f;
                    i3 |= startRestartGroup.changed(f3) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                        f4 = f2;
                    } else {
                        f4 = f2;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(f4) ? 8388608 : 4194304;
                        }
                    }
                    if ((i & 100663296) != 0) {
                        if ((i2 & 256) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i14 = 67108864;
                                i3 |= i14;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i14 = 33554432;
                        i3 |= i14;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((i2 & 512) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        int i17 = i3;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i4 != 0 ? Modifier.Companion : obj2;
                                if ((i2 & 16) != 0) {
                                    int i18 = i17 & (-57345);
                                    shape3 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                    i7 = i18;
                                } else {
                                    i7 = i17;
                                    shape3 = shape2;
                                }
                                if ((i2 & 32) != 0) {
                                    i8 = -234881025;
                                    i9 = 6;
                                    searchBarColors3 = SearchBarDefaults.INSTANCE.m2220colorsdgg9oW8(0L, 0L, startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                                    i10 = i7 & (-458753);
                                } else {
                                    i8 = -234881025;
                                    i9 = 6;
                                    searchBarColors3 = searchBarColors2;
                                    i10 = i7;
                                }
                                float m2224getTonalElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m2224getTonalElevationD9Ej5fM() : f;
                                float m2223getShadowElevationD9Ej5fM = i6 != 0 ? SearchBarDefaults.INSTANCE.m2223getShadowElevationD9Ej5fM() : f4;
                                if ((i2 & 256) != 0) {
                                    i10 &= i8;
                                    obj3 = companion;
                                    windowInsets3 = SearchBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, i9);
                                } else {
                                    windowInsets3 = windowInsets;
                                    obj3 = companion;
                                }
                                searchBarColors4 = searchBarColors3;
                                i11 = i10;
                                f5 = m2224getTonalElevationD9Ej5fM;
                                f6 = m2223getShadowElevationD9Ej5fM;
                                shape4 = shape3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i17 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i17 &= -458753;
                                }
                                if ((i2 & 256) != 0) {
                                    i17 &= -234881025;
                                }
                                windowInsets3 = windowInsets2;
                                f6 = f4;
                                i11 = i17;
                                f5 = f3;
                                searchBarColors4 = searchBarColors2;
                                shape4 = shape2;
                                obj3 = obj2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1444649673, i11, -1, "androidx.compose.material3.SearchBar (SearchBar.android.kt:177)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626005896, "CC(remember):SearchBar.android.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = AnimatableKt.Animatable$default(z ? 1.0f : 0.0f, 0.0f, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            animatable = (Animatable) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626008851, "CC(remember):SearchBar.android.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            mutableFloatState = (MutableFloatState) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626011067, "CC(remember):SearchBar.android.kt#9igjgp");
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            MutableState mutableState = (MutableState) rememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626013595, "CC(remember):SearchBar.android.kt#9igjgp");
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            MutableState mutableState2 = (MutableState) rememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Boolean valueOf = Boolean.valueOf(z);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626016806, "CC(remember):SearchBar.android.kt#9igjgp");
                            i12 = i11;
                            changedInstance = startRestartGroup.changedInstance(animatable) | ((i12 & 112) == 32);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changedInstance || rememberedValue5 == Composer.Companion.getEmpty()) {
                                obj4 = obj3;
                                shape5 = shape4;
                                i13 = i12;
                                str = "CC(remember):SearchBar.android.kt#9igjgp";
                                mutableFloatState2 = mutableFloatState;
                                rememberedValue5 = new SearchBar_androidKt$SearchBar$1$1(animatable, z, mutableFloatState2, mutableState, mutableState2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            } else {
                                obj4 = obj3;
                                shape5 = shape4;
                                i13 = i12;
                                str = "CC(remember):SearchBar.android.kt#9igjgp";
                                mutableFloatState2 = mutableFloatState;
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i19 = (i13 >> 3) & 14;
                            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue5, startRestartGroup, i19);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626037411, str);
                            rememberedValue6 = startRestartGroup.rememberedValue();
                            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = new MutatorMutex();
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            MutatorMutex mutatorMutex = (MutatorMutex) rememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626040814, str);
                            changedInstance2 = startRestartGroup.changedInstance(animatable) | ((i13 & 896) == 256);
                            rememberedValue7 = startRestartGroup.rememberedValue();
                            if (!changedInstance2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                                animatable2 = animatable;
                                rememberedValue7 = new SearchBar_androidKt$SearchBar$2$1(mutatorMutex, mutableFloatState2, animatable2, function1, mutableState, mutableState2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue7);
                            } else {
                                animatable2 = animatable;
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            PredictiveBackHandlerKt.PredictiveBackHandler(z, (Function2) rememberedValue7, startRestartGroup, i19, 0);
                            int i20 = i13 << 6;
                            Modifier modifier3 = obj4;
                            Shape shape7 = shape5;
                            SearchBarColors searchBarColors6 = searchBarColors4;
                            float f9 = f5;
                            float f10 = f6;
                            WindowInsets windowInsets5 = windowInsets3;
                            m2231SearchBarImplj1jLAyQ(animatable2, mutableFloatState2, mutableState, mutableState2, modifier3, obj, shape7, searchBarColors6, f9, f10, windowInsets5, function3, startRestartGroup, Animatable.$stable | 3504 | ((i13 << 3) & 57344) | ((i13 << 15) & 458752) | (3670016 & i20) | (29360128 & i20) | (234881024 & i20) | (i20 & 1879048192), (i13 >> 24) & WebSocketProtocol.PAYLOAD_SHORT, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            modifier2 = modifier3;
                            shape6 = shape7;
                            searchBarColors5 = searchBarColors6;
                            f7 = f9;
                            f8 = f10;
                            windowInsets4 = windowInsets5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            SearchBarColors searchBarColors7 = searchBarColors2;
                            windowInsets4 = windowInsets2;
                            modifier2 = obj2;
                            searchBarColors5 = searchBarColors7;
                            shape6 = shape2;
                            composer2 = startRestartGroup;
                            f7 = f3;
                            f8 = f4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3
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

                                public final void invoke(Composer composer3, int i21) {
                                    SearchBar_androidKt.m2230SearchBarY92LkZI(function2, z, function1, modifier2, shape6, searchBarColors5, f7, f8, windowInsets4, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    int i172 = i3;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    searchBarColors4 = searchBarColors3;
                    i11 = i10;
                    f5 = m2224getTonalElevationD9Ej5fM;
                    f6 = m2223getShadowElevationD9Ej5fM;
                    shape4 = shape3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626005896, "CC(remember):SearchBar.android.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                    }
                    animatable = (Animatable) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626008851, "CC(remember):SearchBar.android.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    mutableFloatState = (MutableFloatState) rememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626011067, "CC(remember):SearchBar.android.kt#9igjgp");
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    }
                    MutableState mutableState3 = (MutableState) rememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626013595, "CC(remember):SearchBar.android.kt#9igjgp");
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    }
                    MutableState mutableState22 = (MutableState) rememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Boolean valueOf2 = Boolean.valueOf(z);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626016806, "CC(remember):SearchBar.android.kt#9igjgp");
                    i12 = i11;
                    changedInstance = startRestartGroup.changedInstance(animatable) | ((i12 & 112) == 32);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    obj4 = obj3;
                    shape5 = shape4;
                    i13 = i12;
                    str = "CC(remember):SearchBar.android.kt#9igjgp";
                    mutableFloatState2 = mutableFloatState;
                    rememberedValue5 = new SearchBar_androidKt$SearchBar$1$1(animatable, z, mutableFloatState2, mutableState3, mutableState22, null);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    int i192 = (i13 >> 3) & 14;
                    EffectsKt.LaunchedEffect(valueOf2, (Function2) rememberedValue5, startRestartGroup, i192);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626037411, str);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    }
                    MutatorMutex mutatorMutex2 = (MutatorMutex) rememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626040814, str);
                    changedInstance2 = startRestartGroup.changedInstance(animatable) | ((i13 & 896) == 256);
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (changedInstance2) {
                    }
                    animatable2 = animatable;
                    rememberedValue7 = new SearchBar_androidKt$SearchBar$2$1(mutatorMutex2, mutableFloatState2, animatable2, function1, mutableState3, mutableState22, null);
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    PredictiveBackHandlerKt.PredictiveBackHandler(z, (Function2) rememberedValue7, startRestartGroup, i192, 0);
                    int i202 = i13 << 6;
                    Modifier modifier32 = obj4;
                    Shape shape72 = shape5;
                    SearchBarColors searchBarColors62 = searchBarColors4;
                    float f92 = f5;
                    float f102 = f6;
                    WindowInsets windowInsets52 = windowInsets3;
                    m2231SearchBarImplj1jLAyQ(animatable2, mutableFloatState2, mutableState3, mutableState22, modifier32, obj, shape72, searchBarColors62, f92, f102, windowInsets52, function3, startRestartGroup, Animatable.$stable | 3504 | ((i13 << 3) & 57344) | ((i13 << 15) & 458752) | (3670016 & i202) | (29360128 & i202) | (234881024 & i202) | (i202 & 1879048192), (i13 >> 24) & WebSocketProtocol.PAYLOAD_SHORT, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    modifier2 = modifier32;
                    shape6 = shape72;
                    searchBarColors5 = searchBarColors62;
                    f7 = f92;
                    f8 = f102;
                    windowInsets4 = windowInsets52;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f3 = f;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                if ((i & 100663296) != 0) {
                }
                if ((i2 & 512) == 0) {
                }
                int i1722 = i3;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                searchBarColors4 = searchBarColors3;
                i11 = i10;
                f5 = m2224getTonalElevationD9Ej5fM;
                f6 = m2223getShadowElevationD9Ej5fM;
                shape4 = shape3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626005896, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                animatable = (Animatable) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626008851, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                }
                mutableFloatState = (MutableFloatState) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626011067, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                }
                MutableState mutableState32 = (MutableState) rememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626013595, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                }
                MutableState mutableState222 = (MutableState) rememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Boolean valueOf22 = Boolean.valueOf(z);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626016806, "CC(remember):SearchBar.android.kt#9igjgp");
                i12 = i11;
                changedInstance = startRestartGroup.changedInstance(animatable) | ((i12 & 112) == 32);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                obj4 = obj3;
                shape5 = shape4;
                i13 = i12;
                str = "CC(remember):SearchBar.android.kt#9igjgp";
                mutableFloatState2 = mutableFloatState;
                rememberedValue5 = new SearchBar_androidKt$SearchBar$1$1(animatable, z, mutableFloatState2, mutableState32, mutableState222, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                int i1922 = (i13 >> 3) & 14;
                EffectsKt.LaunchedEffect(valueOf22, (Function2) rememberedValue5, startRestartGroup, i1922);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626037411, str);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                }
                MutatorMutex mutatorMutex22 = (MutatorMutex) rememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626040814, str);
                changedInstance2 = startRestartGroup.changedInstance(animatable) | ((i13 & 896) == 256);
                rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance2) {
                }
                animatable2 = animatable;
                rememberedValue7 = new SearchBar_androidKt$SearchBar$2$1(mutatorMutex22, mutableFloatState2, animatable2, function1, mutableState32, mutableState222, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                PredictiveBackHandlerKt.PredictiveBackHandler(z, (Function2) rememberedValue7, startRestartGroup, i1922, 0);
                int i2022 = i13 << 6;
                Modifier modifier322 = obj4;
                Shape shape722 = shape5;
                SearchBarColors searchBarColors622 = searchBarColors4;
                float f922 = f5;
                float f1022 = f6;
                WindowInsets windowInsets522 = windowInsets3;
                m2231SearchBarImplj1jLAyQ(animatable2, mutableFloatState2, mutableState32, mutableState222, modifier322, obj, shape722, searchBarColors622, f922, f1022, windowInsets522, function3, startRestartGroup, Animatable.$stable | 3504 | ((i13 << 3) & 57344) | ((i13 << 15) & 458752) | (3670016 & i2022) | (29360128 & i2022) | (234881024 & i2022) | (i2022 & 1879048192), (i13 >> 24) & WebSocketProtocol.PAYLOAD_SHORT, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier2 = modifier322;
                shape6 = shape722;
                searchBarColors5 = searchBarColors622;
                f7 = f922;
                f8 = f1022;
                windowInsets4 = windowInsets522;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = modifier;
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            f3 = f;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            if ((i & 100663296) != 0) {
            }
            if ((i2 & 512) == 0) {
            }
            int i17222 = i3;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            searchBarColors4 = searchBarColors3;
            i11 = i10;
            f5 = m2224getTonalElevationD9Ej5fM;
            f6 = m2223getShadowElevationD9Ej5fM;
            shape4 = shape3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626005896, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            animatable = (Animatable) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626008851, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
            }
            mutableFloatState = (MutableFloatState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626011067, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
            }
            MutableState mutableState322 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626013595, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
            }
            MutableState mutableState2222 = (MutableState) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Boolean valueOf222 = Boolean.valueOf(z);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626016806, "CC(remember):SearchBar.android.kt#9igjgp");
            i12 = i11;
            changedInstance = startRestartGroup.changedInstance(animatable) | ((i12 & 112) == 32);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            obj4 = obj3;
            shape5 = shape4;
            i13 = i12;
            str = "CC(remember):SearchBar.android.kt#9igjgp";
            mutableFloatState2 = mutableFloatState;
            rememberedValue5 = new SearchBar_androidKt$SearchBar$1$1(animatable, z, mutableFloatState2, mutableState322, mutableState2222, null);
            startRestartGroup.updateRememberedValue(rememberedValue5);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i19222 = (i13 >> 3) & 14;
            EffectsKt.LaunchedEffect(valueOf222, (Function2) rememberedValue5, startRestartGroup, i19222);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626037411, str);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
            }
            MutatorMutex mutatorMutex222 = (MutatorMutex) rememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626040814, str);
            changedInstance2 = startRestartGroup.changedInstance(animatable) | ((i13 & 896) == 256);
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance2) {
            }
            animatable2 = animatable;
            rememberedValue7 = new SearchBar_androidKt$SearchBar$2$1(mutatorMutex222, mutableFloatState2, animatable2, function1, mutableState322, mutableState2222, null);
            startRestartGroup.updateRememberedValue(rememberedValue7);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            PredictiveBackHandlerKt.PredictiveBackHandler(z, (Function2) rememberedValue7, startRestartGroup, i19222, 0);
            int i20222 = i13 << 6;
            Modifier modifier3222 = obj4;
            Shape shape7222 = shape5;
            SearchBarColors searchBarColors6222 = searchBarColors4;
            float f9222 = f5;
            float f10222 = f6;
            WindowInsets windowInsets5222 = windowInsets3;
            m2231SearchBarImplj1jLAyQ(animatable2, mutableFloatState2, mutableState322, mutableState2222, modifier3222, obj, shape7222, searchBarColors6222, f9222, f10222, windowInsets5222, function3, startRestartGroup, Animatable.$stable | 3504 | ((i13 << 3) & 57344) | ((i13 << 15) & 458752) | (3670016 & i20222) | (29360128 & i20222) | (234881024 & i20222) | (i20222 & 1879048192), (i13 >> 24) & WebSocketProtocol.PAYLOAD_SHORT, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier2 = modifier3222;
            shape6 = shape7222;
            searchBarColors5 = searchBarColors6222;
            f7 = f9222;
            f8 = f10222;
            windowInsets4 = windowInsets5222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        obj2 = modifier;
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        f3 = f;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        if ((i & 100663296) != 0) {
        }
        if ((i2 & 512) == 0) {
        }
        int i172222 = i3;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        searchBarColors4 = searchBarColors3;
        i11 = i10;
        f5 = m2224getTonalElevationD9Ej5fM;
        f6 = m2223getShadowElevationD9Ej5fM;
        shape4 = shape3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626005896, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        animatable = (Animatable) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626008851, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
        }
        mutableFloatState = (MutableFloatState) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626011067, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
        }
        MutableState mutableState3222 = (MutableState) rememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626013595, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.Companion.getEmpty()) {
        }
        MutableState mutableState22222 = (MutableState) rememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Boolean valueOf2222 = Boolean.valueOf(z);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626016806, "CC(remember):SearchBar.android.kt#9igjgp");
        i12 = i11;
        changedInstance = startRestartGroup.changedInstance(animatable) | ((i12 & 112) == 32);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        obj4 = obj3;
        shape5 = shape4;
        i13 = i12;
        str = "CC(remember):SearchBar.android.kt#9igjgp";
        mutableFloatState2 = mutableFloatState;
        rememberedValue5 = new SearchBar_androidKt$SearchBar$1$1(animatable, z, mutableFloatState2, mutableState3222, mutableState22222, null);
        startRestartGroup.updateRememberedValue(rememberedValue5);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        int i192222 = (i13 >> 3) & 14;
        EffectsKt.LaunchedEffect(valueOf2222, (Function2) rememberedValue5, startRestartGroup, i192222);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626037411, str);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == Composer.Companion.getEmpty()) {
        }
        MutatorMutex mutatorMutex2222 = (MutatorMutex) rememberedValue6;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 626040814, str);
        changedInstance2 = startRestartGroup.changedInstance(animatable) | ((i13 & 896) == 256);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (changedInstance2) {
        }
        animatable2 = animatable;
        rememberedValue7 = new SearchBar_androidKt$SearchBar$2$1(mutatorMutex2222, mutableFloatState2, animatable2, function1, mutableState3222, mutableState22222, null);
        startRestartGroup.updateRememberedValue(rememberedValue7);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        PredictiveBackHandlerKt.PredictiveBackHandler(z, (Function2) rememberedValue7, startRestartGroup, i192222, 0);
        int i202222 = i13 << 6;
        Modifier modifier32222 = obj4;
        Shape shape72222 = shape5;
        SearchBarColors searchBarColors62222 = searchBarColors4;
        float f92222 = f5;
        float f102222 = f6;
        WindowInsets windowInsets52222 = windowInsets3;
        m2231SearchBarImplj1jLAyQ(animatable2, mutableFloatState2, mutableState3222, mutableState22222, modifier32222, obj, shape72222, searchBarColors62222, f92222, f102222, windowInsets52222, function3, startRestartGroup, Animatable.$stable | 3504 | ((i13 << 3) & 57344) | ((i13 << 15) & 458752) | (3670016 & i202222) | (29360128 & i202222) | (234881024 & i202222) | (i202222 & 1879048192), (i13 >> 24) & WebSocketProtocol.PAYLOAD_SHORT, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier2 = modifier32222;
        shape6 = shape72222;
        searchBarColors5 = searchBarColors62222;
        f7 = f92222;
        f8 = f102222;
        windowInsets4 = windowInsets52222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0110  */
    /* renamed from: DockedSearchBar-EQC0FA8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2227DockedSearchBarEQC0FA8(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        Object obj;
        Object obj2;
        int i4;
        float f3;
        int i5;
        float f4;
        int i6;
        Shape shape2;
        int i7;
        Composer composer2;
        int i8;
        SearchBarColors searchBarColors2;
        Object obj3;
        float f5;
        float f6;
        final SearchBarColors searchBarColors3;
        Composer composer3;
        boolean z2;
        Object rememberedValue;
        final SearchBarColors searchBarColors4;
        final Modifier modifier2;
        final Shape shape3;
        final float f7;
        final float f8;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1209217899);
        ComposerKt.sourceInformation(startRestartGroup, "C(DockedSearchBar)P(3,2,5,4,7!1,8:c#ui.unit.Dp,6:c#ui.unit.Dp)287@13410L11,288@13471L8,296@13752L38,300@13946L831,293@13658L1119,325@14815L27,325@14783L59:SearchBar.android.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 2048 : 1024;
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    obj = shape;
                    if (startRestartGroup.changed(obj)) {
                        i10 = 16384;
                        i3 |= i10;
                    }
                } else {
                    obj = shape;
                }
                i10 = 8192;
                i3 |= i10;
            } else {
                obj = shape;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj2 = searchBarColors;
                    if (startRestartGroup.changed(obj2)) {
                        i9 = 131072;
                        i3 |= i9;
                    }
                } else {
                    obj2 = searchBarColors;
                }
                i9 = 65536;
                i3 |= i9;
            } else {
                obj2 = searchBarColors;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else if ((1572864 & i) == 0) {
                f3 = f;
                i3 |= startRestartGroup.changed(f3) ? 1048576 : 524288;
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                    f4 = f2;
                } else {
                    f4 = f2;
                    if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(f4) ? 8388608 : 4194304;
                    }
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                }
                i6 = i3;
                if ((38347923 & i3) == 38347922 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            companion = Modifier.Companion;
                        }
                        if ((i2 & 16) != 0) {
                            shape2 = SearchBarDefaults.INSTANCE.getDockedShape(startRestartGroup, 6);
                            i7 = i6 & (-57345);
                        } else {
                            shape2 = obj;
                            i7 = i6;
                        }
                        if ((i2 & 32) != 0) {
                            i8 = i5;
                            searchBarColors2 = SearchBarDefaults.INSTANCE.m2220colorsdgg9oW8(0L, 0L, startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                            composer2 = startRestartGroup;
                            i6 = (-458753) & i7;
                        } else {
                            composer2 = startRestartGroup;
                            i8 = i5;
                            i6 = i7;
                            searchBarColors2 = obj2;
                        }
                        float m2224getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m2224getTonalElevationD9Ej5fM() : f;
                        if (i8 != 0) {
                            obj3 = shape2;
                            f6 = SearchBarDefaults.INSTANCE.m2223getShadowElevationD9Ej5fM();
                            f5 = m2224getTonalElevationD9Ej5fM;
                        } else {
                            obj3 = shape2;
                            f5 = m2224getTonalElevationD9Ej5fM;
                            f6 = f4;
                        }
                        searchBarColors3 = searchBarColors2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                        }
                        f6 = f4;
                        searchBarColors3 = obj2;
                        f5 = f3;
                        composer2 = startRestartGroup;
                        obj3 = obj;
                    }
                    int i12 = i6;
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1209217899, i12, -1, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:292)");
                    }
                    int i13 = i12 >> 6;
                    Composer composer4 = composer2;
                    SurfaceKt.m2347SurfaceT9BRK9s(SizeKt.m790width3ABfNKs(ZIndexModifierKt.zIndex(companion, 1.0f), SearchBarMinWidth), obj3, searchBarColors3.m2216getContainerColor0d7_KjU(), ColorSchemeKt.m1733contentColorForek8zF_U(searchBarColors3.m2216getContainerColor0d7_KjU(), composer2, 0), f5, f6, null, ComposableLambdaKt.rememberComposableLambda(878471280, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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

                        public final void invoke(Composer composer5, int i14) {
                            EnterTransition enterTransition;
                            ExitTransition exitTransition;
                            ComposerKt.sourceInformation(composer5, "C301@13956L815:SearchBar.android.kt#uh7d8r");
                            if ((i14 & 3) != 2 || !composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(878471280, i14, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:301)");
                                }
                                Function2<Composer, Integer, Unit> function22 = function2;
                                boolean z3 = z;
                                final SearchBarColors searchBarColors5 = searchBarColors3;
                                final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, 0);
                                ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, Modifier.Companion);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                                Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer5, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer5, 1812191551, "C302@13977L12,308@14165L596,304@14003L758:SearchBar.android.kt#uh7d8r");
                                function22.invoke(composer5, 0);
                                enterTransition = SearchBar_androidKt.DockedEnterTransition;
                                exitTransition = SearchBar_androidKt.DockedExitTransition;
                                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z3, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.rememberComposableLambda(-1743690306, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, Integer num) {
                                        invoke(animatedVisibilityScope, composer6, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, int i15) {
                                        ComposerKt.sourceInformation(composer6, "C*309@14221L7,311@14299L125,315@14477L76,317@14571L176:SearchBar.android.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1743690306, i15, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:309)");
                                        }
                                        ComposerKt.sourceInformationMarkerStart(composer6, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume = composer6.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        float m6684constructorimpl = Dp.m6684constructorimpl(((Configuration) consume).screenHeightDp);
                                        ComposerKt.sourceInformationMarkerStart(composer6, 1708554480, "CC(remember):SearchBar.android.kt#9igjgp");
                                        boolean changed = composer6.changed(m6684constructorimpl);
                                        Object rememberedValue2 = composer6.rememberedValue();
                                        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                            rememberedValue2 = Dp.m6682boximpl(Dp.m6684constructorimpl(m6684constructorimpl * 0.6666667f));
                                            composer6.updateRememberedValue(rememberedValue2);
                                        }
                                        float m6698unboximpl = ((Dp) rememberedValue2).m6698unboximpl();
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        ComposerKt.sourceInformationMarkerStart(composer6, 1708560127, "CC(remember):SearchBar.android.kt#9igjgp");
                                        boolean changed2 = composer6.changed(m6698unboximpl);
                                        Object rememberedValue3 = composer6.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                            rememberedValue3 = Dp.m6682boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6682boximpl(SearchBar_androidKt.getDockedExpandedTableMinHeight()), Dp.m6682boximpl(m6698unboximpl))).m6698unboximpl());
                                            composer6.updateRememberedValue(rememberedValue3);
                                        }
                                        float m6698unboximpl2 = ((Dp) rememberedValue3).m6698unboximpl();
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        Modifier m772heightInVpY3zN4 = SizeKt.m772heightInVpY3zN4(Modifier.Companion, m6698unboximpl2, m6698unboximpl);
                                        SearchBarColors searchBarColors6 = SearchBarColors.this;
                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                        ComposerKt.sourceInformationMarkerStart(composer6, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer6, 0);
                                        ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer6.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer6, m772heightInVpY3zN4);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer6.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer6.startReusableNode();
                                        if (composer6.getInserting()) {
                                            composer6.createNode(constructor2);
                                        } else {
                                            composer6.useNode();
                                        }
                                        Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer6);
                                        Updater.m3527setimpl(m3520constructorimpl2, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer6, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                        ComposerKt.sourceInformationMarkerStart(composer6, 697724229, "C318@14653L46,319@14720L9:SearchBar.android.kt#uh7d8r");
                                        DividerKt.m1876HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.m2217getDividerColor0d7_KjU(), composer6, 0, 3);
                                        function33.invoke(ColumnScopeInstance.INSTANCE, composer6, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        composer6.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer5, 54), composer5, 1600518, 18);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer5.skipToGroupEnd();
                        }
                    }, composer2, 54), composer4, ((i12 >> 9) & 112) | 12582912 | (i13 & 57344) | (i13 & 458752), 64);
                    composer3 = composer4;
                    ComposerKt.sourceInformationMarkerStart(composer3, -994322031, "CC(remember):SearchBar.android.kt#9igjgp");
                    z2 = (i12 & 896) == 256;
                    rememberedValue = composer3.rememberedValue();
                    if (!z2 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                function1.invoke(false);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    BackHandlerKt.BackHandler(z, (Function0) rememberedValue, composer3, (i12 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    searchBarColors4 = searchBarColors3;
                    modifier2 = companion;
                    shape3 = obj3;
                    f7 = f5;
                    f8 = f6;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    float f9 = f3;
                    composer3 = startRestartGroup;
                    modifier2 = companion;
                    f8 = f4;
                    f7 = f9;
                    shape3 = obj;
                    searchBarColors4 = obj2;
                }
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$3
                        /* JADX INFO: Access modifiers changed from: package-private */
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

                        public final void invoke(Composer composer5, int i14) {
                            SearchBar_androidKt.m2227DockedSearchBarEQC0FA8(function2, z, function1, modifier2, shape3, searchBarColors4, f7, f8, function3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f3 = f;
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            i6 = i3;
            if ((38347923 & i3) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i4 != 0) {
            }
            if (i8 != 0) {
            }
            searchBarColors3 = searchBarColors2;
            int i122 = i6;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i132 = i122 >> 6;
            Composer composer42 = composer2;
            SurfaceKt.m2347SurfaceT9BRK9s(SizeKt.m790width3ABfNKs(ZIndexModifierKt.zIndex(companion, 1.0f), SearchBarMinWidth), obj3, searchBarColors3.m2216getContainerColor0d7_KjU(), ColorSchemeKt.m1733contentColorForek8zF_U(searchBarColors3.m2216getContainerColor0d7_KjU(), composer2, 0), f5, f6, null, ComposableLambdaKt.rememberComposableLambda(878471280, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1
                /* JADX INFO: Access modifiers changed from: package-private */
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

                public final void invoke(Composer composer5, int i14) {
                    EnterTransition enterTransition;
                    ExitTransition exitTransition;
                    ComposerKt.sourceInformation(composer5, "C301@13956L815:SearchBar.android.kt#uh7d8r");
                    if ((i14 & 3) != 2 || !composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(878471280, i14, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:301)");
                        }
                        Function2<Composer, Integer, Unit> function22 = function2;
                        boolean z3 = z;
                        final SearchBarColors searchBarColors5 = searchBarColors3;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, 0);
                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, Modifier.Companion);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                        Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer5, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer5, 1812191551, "C302@13977L12,308@14165L596,304@14003L758:SearchBar.android.kt#uh7d8r");
                        function22.invoke(composer5, 0);
                        enterTransition = SearchBar_androidKt.DockedEnterTransition;
                        exitTransition = SearchBar_androidKt.DockedExitTransition;
                        AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z3, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.rememberComposableLambda(-1743690306, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, Integer num) {
                                invoke(animatedVisibilityScope, composer6, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, int i15) {
                                ComposerKt.sourceInformation(composer6, "C*309@14221L7,311@14299L125,315@14477L76,317@14571L176:SearchBar.android.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1743690306, i15, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:309)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composer6, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = composer6.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                float m6684constructorimpl = Dp.m6684constructorimpl(((Configuration) consume).screenHeightDp);
                                ComposerKt.sourceInformationMarkerStart(composer6, 1708554480, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changed = composer6.changed(m6684constructorimpl);
                                Object rememberedValue2 = composer6.rememberedValue();
                                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = Dp.m6682boximpl(Dp.m6684constructorimpl(m6684constructorimpl * 0.6666667f));
                                    composer6.updateRememberedValue(rememberedValue2);
                                }
                                float m6698unboximpl = ((Dp) rememberedValue2).m6698unboximpl();
                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                ComposerKt.sourceInformationMarkerStart(composer6, 1708560127, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changed2 = composer6.changed(m6698unboximpl);
                                Object rememberedValue3 = composer6.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = Dp.m6682boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6682boximpl(SearchBar_androidKt.getDockedExpandedTableMinHeight()), Dp.m6682boximpl(m6698unboximpl))).m6698unboximpl());
                                    composer6.updateRememberedValue(rememberedValue3);
                                }
                                float m6698unboximpl2 = ((Dp) rememberedValue3).m6698unboximpl();
                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                Modifier m772heightInVpY3zN4 = SizeKt.m772heightInVpY3zN4(Modifier.Companion, m6698unboximpl2, m6698unboximpl);
                                SearchBarColors searchBarColors6 = SearchBarColors.this;
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                ComposerKt.sourceInformationMarkerStart(composer6, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer6, 0);
                                ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer6.getCurrentCompositionLocalMap();
                                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer6, m772heightInVpY3zN4);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer6.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer6.startReusableNode();
                                if (composer6.getInserting()) {
                                    composer6.createNode(constructor2);
                                } else {
                                    composer6.useNode();
                                }
                                Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer6);
                                Updater.m3527setimpl(m3520constructorimpl2, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer6, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                ComposerKt.sourceInformationMarkerStart(composer6, 697724229, "C318@14653L46,319@14720L9:SearchBar.android.kt#uh7d8r");
                                DividerKt.m1876HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.m2217getDividerColor0d7_KjU(), composer6, 0, 3);
                                function33.invoke(ColumnScopeInstance.INSTANCE, composer6, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                composer6.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer5, 54), composer5, 1600518, 18);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        composer5.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        ComposerKt.sourceInformationMarkerEnd(composer5);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer5.skipToGroupEnd();
                }
            }, composer2, 54), composer42, ((i122 >> 9) & 112) | 12582912 | (i132 & 57344) | (i132 & 458752), 64);
            composer3 = composer42;
            ComposerKt.sourceInformationMarkerStart(composer3, -994322031, "CC(remember):SearchBar.android.kt#9igjgp");
            if ((i122 & 896) == 256) {
            }
            rememberedValue = composer3.rememberedValue();
            if (!z2) {
            }
            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    function1.invoke(false);
                }
            };
            composer3.updateRememberedValue(rememberedValue);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            BackHandlerKt.BackHandler(z, (Function0) rememberedValue, composer3, (i122 >> 3) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            searchBarColors4 = searchBarColors3;
            modifier2 = companion;
            shape3 = obj3;
            f7 = f5;
            f8 = f6;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        f3 = f;
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        i6 = i3;
        if ((38347923 & i3) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i4 != 0) {
        }
        if (i8 != 0) {
        }
        searchBarColors3 = searchBarColors2;
        int i1222 = i6;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1322 = i1222 >> 6;
        Composer composer422 = composer2;
        SurfaceKt.m2347SurfaceT9BRK9s(SizeKt.m790width3ABfNKs(ZIndexModifierKt.zIndex(companion, 1.0f), SearchBarMinWidth), obj3, searchBarColors3.m2216getContainerColor0d7_KjU(), ColorSchemeKt.m1733contentColorForek8zF_U(searchBarColors3.m2216getContainerColor0d7_KjU(), composer2, 0), f5, f6, null, ComposableLambdaKt.rememberComposableLambda(878471280, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1
            /* JADX INFO: Access modifiers changed from: package-private */
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

            public final void invoke(Composer composer5, int i14) {
                EnterTransition enterTransition;
                ExitTransition exitTransition;
                ComposerKt.sourceInformation(composer5, "C301@13956L815:SearchBar.android.kt#uh7d8r");
                if ((i14 & 3) != 2 || !composer5.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(878471280, i14, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:301)");
                    }
                    Function2<Composer, Integer, Unit> function22 = function2;
                    boolean z3 = z;
                    final SearchBarColors searchBarColors5 = searchBarColors3;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, 0);
                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, Modifier.Companion);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
                    Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer5, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer5, 1812191551, "C302@13977L12,308@14165L596,304@14003L758:SearchBar.android.kt#uh7d8r");
                    function22.invoke(composer5, 0);
                    enterTransition = SearchBar_androidKt.DockedEnterTransition;
                    exitTransition = SearchBar_androidKt.DockedExitTransition;
                    AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z3, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.rememberComposableLambda(-1743690306, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$1$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, Integer num) {
                            invoke(animatedVisibilityScope, composer6, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, int i15) {
                            ComposerKt.sourceInformation(composer6, "C*309@14221L7,311@14299L125,315@14477L76,317@14571L176:SearchBar.android.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1743690306, i15, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:309)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer6, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = composer6.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
                            ComposerKt.sourceInformationMarkerEnd(composer6);
                            float m6684constructorimpl = Dp.m6684constructorimpl(((Configuration) consume).screenHeightDp);
                            ComposerKt.sourceInformationMarkerStart(composer6, 1708554480, "CC(remember):SearchBar.android.kt#9igjgp");
                            boolean changed = composer6.changed(m6684constructorimpl);
                            Object rememberedValue2 = composer6.rememberedValue();
                            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = Dp.m6682boximpl(Dp.m6684constructorimpl(m6684constructorimpl * 0.6666667f));
                                composer6.updateRememberedValue(rememberedValue2);
                            }
                            float m6698unboximpl = ((Dp) rememberedValue2).m6698unboximpl();
                            ComposerKt.sourceInformationMarkerEnd(composer6);
                            ComposerKt.sourceInformationMarkerStart(composer6, 1708560127, "CC(remember):SearchBar.android.kt#9igjgp");
                            boolean changed2 = composer6.changed(m6698unboximpl);
                            Object rememberedValue3 = composer6.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = Dp.m6682boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6682boximpl(SearchBar_androidKt.getDockedExpandedTableMinHeight()), Dp.m6682boximpl(m6698unboximpl))).m6698unboximpl());
                                composer6.updateRememberedValue(rememberedValue3);
                            }
                            float m6698unboximpl2 = ((Dp) rememberedValue3).m6698unboximpl();
                            ComposerKt.sourceInformationMarkerEnd(composer6);
                            Modifier m772heightInVpY3zN4 = SizeKt.m772heightInVpY3zN4(Modifier.Companion, m6698unboximpl2, m6698unboximpl);
                            SearchBarColors searchBarColors6 = SearchBarColors.this;
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            ComposerKt.sourceInformationMarkerStart(composer6, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer6, 0);
                            ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer6.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer6, m772heightInVpY3zN4);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer6.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer6.startReusableNode();
                            if (composer6.getInserting()) {
                                composer6.createNode(constructor2);
                            } else {
                                composer6.useNode();
                            }
                            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer6);
                            Updater.m3527setimpl(m3520constructorimpl2, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer6, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                            ComposerKt.sourceInformationMarkerStart(composer6, 697724229, "C318@14653L46,319@14720L9:SearchBar.android.kt#uh7d8r");
                            DividerKt.m1876HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.m2217getDividerColor0d7_KjU(), composer6, 0, 3);
                            function33.invoke(ColumnScopeInstance.INSTANCE, composer6, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer6);
                            ComposerKt.sourceInformationMarkerEnd(composer6);
                            composer6.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer6);
                            ComposerKt.sourceInformationMarkerEnd(composer6);
                            ComposerKt.sourceInformationMarkerEnd(composer6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer5, 54), composer5, 1600518, 18);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer5.skipToGroupEnd();
            }
        }, composer2, 54), composer422, ((i1222 >> 9) & 112) | 12582912 | (i1322 & 57344) | (i1322 & 458752), 64);
        composer3 = composer422;
        ComposerKt.sourceInformationMarkerStart(composer3, -994322031, "CC(remember):SearchBar.android.kt#9igjgp");
        if ((i1222 & 896) == 256) {
        }
        rememberedValue = composer3.rememberedValue();
        if (!z2) {
        }
        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                function1.invoke(false);
            }
        };
        composer3.updateRememberedValue(rememberedValue);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        BackHandlerKt.BackHandler(z, (Function0) rememberedValue, composer3, (i1222 >> 3) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        searchBarColors4 = searchBarColors3;
        modifier2 = companion;
        shape3 = obj3;
        f7 = f5;
        f8 = f6;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c  */
    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(expression = "SearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    windowInsets = windowInsets,\n    content = content,\n)", imports = {}))
    /* renamed from: SearchBar-WuY5d9Q  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2229SearchBarWuY5d9Q(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        final Object obj2;
        int i6;
        boolean z3;
        int i7;
        Object obj3;
        int i8;
        Object obj4;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Shape shape2;
        Composer composer2;
        int i18;
        SearchBarColors searchBarColors2;
        WindowInsets windowInsets2;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final SearchBarColors searchBarColors3;
        float f3;
        float f4;
        WindowInsets windowInsets3;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape3;
        Modifier modifier2;
        final boolean z4;
        int i19;
        final float f5;
        final WindowInsets windowInsets4;
        Composer composer3;
        final SearchBarColors searchBarColors4;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final MutableInteractionSource mutableInteractionSource3;
        final float f6;
        final Shape shape4;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        ScopeUpdateScope endRestartGroup;
        int i20;
        int i21;
        Composer startRestartGroup = composer.startRestartGroup(1001512593);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)737@34012L15,738@34077L8,741@34258L12,746@34418L591,745@34386L925:SearchBar.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            obj = function1;
        } else {
            obj = function1;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
            int i22 = 8192;
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
                i5 = i3 & 32;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    obj2 = modifier;
                } else {
                    obj2 = modifier;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                    }
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                    z3 = z2;
                } else {
                    z3 = z2;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                    }
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    obj3 = function2;
                } else {
                    obj3 = function2;
                    if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(obj3) ? 8388608 : 4194304;
                    }
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                    i4 |= 100663296;
                    obj4 = function22;
                } else {
                    obj4 = function22;
                    if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(obj4) ? 67108864 : 33554432;
                    }
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i10 = i9;
                    i4 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0 && startRestartGroup.changed(shape)) {
                            i21 = 4;
                            i11 = i2 | i21;
                        }
                        i21 = 2;
                        i11 = i2 | i21;
                    } else {
                        i11 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i3 & 2048) == 0 && startRestartGroup.changed(searchBarColors)) {
                            i20 = 32;
                            i11 |= i20;
                        }
                        i20 = 16;
                        i11 |= i20;
                    }
                    int i23 = i11;
                    i12 = i3 & 4096;
                    if (i12 == 0) {
                        i13 = i23 | RendererCapabilities.DECODER_SUPPORT_MASK;
                    } else {
                        int i24 = i23;
                        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i24 |= startRestartGroup.changed(f) ? 256 : 128;
                        }
                        i13 = i24;
                    }
                    i14 = i3 & 8192;
                    if (i14 == 0) {
                        i15 = i13 | 3072;
                    } else {
                        i15 = i13;
                        if ((i2 & 3072) == 0) {
                            i15 |= startRestartGroup.changed(f2) ? 2048 : 1024;
                            if ((i2 & 24576) == 0) {
                                if ((i3 & 16384) == 0 && startRestartGroup.changed(windowInsets)) {
                                    i22 = 16384;
                                }
                                i15 |= i22;
                            }
                            i16 = i3 & 32768;
                            if (i16 != 0) {
                                i15 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i17 = i14;
                                i15 |= startRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
                                if ((i3 & 65536) == 0) {
                                    i15 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i15 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                                }
                                if ((i4 & 306783379) != 306783378 && (i15 & 599187) == 599186 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    shape4 = shape;
                                    searchBarColors4 = searchBarColors;
                                    f5 = f;
                                    windowInsets4 = windowInsets;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    function27 = obj4;
                                    z5 = z3;
                                    function29 = obj3;
                                    composer3 = startRestartGroup;
                                    function28 = function23;
                                    f6 = f2;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i5 == 0 ? Modifier.Companion : obj2;
                                        boolean z6 = i6 == 0 ? true : z3;
                                        Object obj5 = i7 == 0 ? null : obj3;
                                        if (i8 != 0) {
                                            obj4 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function210 = i10 == 0 ? null : function23;
                                        if ((i3 & 1024) == 0) {
                                            i15 &= -15;
                                            shape2 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                        } else {
                                            shape2 = shape;
                                        }
                                        if ((i3 & 2048) == 0) {
                                            composer2 = startRestartGroup;
                                            i18 = i4;
                                            searchBarColors2 = SearchBarDefaults.INSTANCE.m2220colorsdgg9oW8(0L, 0L, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                                            i15 &= -113;
                                        } else {
                                            composer2 = startRestartGroup;
                                            i18 = i4;
                                            searchBarColors2 = searchBarColors;
                                        }
                                        float m2224getTonalElevationD9Ej5fM = i12 == 0 ? SearchBarDefaults.INSTANCE.m2224getTonalElevationD9Ej5fM() : f;
                                        float m2223getShadowElevationD9Ej5fM = i17 == 0 ? SearchBarDefaults.INSTANCE.m2223getShadowElevationD9Ej5fM() : f2;
                                        if ((i3 & 16384) == 0) {
                                            windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composer2, 6);
                                            i15 &= -57345;
                                        } else {
                                            windowInsets2 = windowInsets;
                                        }
                                        if (i16 == 0) {
                                            function24 = obj4;
                                            searchBarColors3 = searchBarColors2;
                                            f3 = m2224getTonalElevationD9Ej5fM;
                                            f4 = m2223getShadowElevationD9Ej5fM;
                                            windowInsets3 = windowInsets2;
                                            mutableInteractionSource2 = null;
                                        } else {
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            function24 = obj4;
                                            searchBarColors3 = searchBarColors2;
                                            f3 = m2224getTonalElevationD9Ej5fM;
                                            f4 = m2223getShadowElevationD9Ej5fM;
                                            windowInsets3 = windowInsets2;
                                        }
                                        function25 = obj5;
                                        function26 = function210;
                                        shape3 = shape2;
                                        modifier2 = companion;
                                        z4 = z6;
                                        i19 = i15;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 1024) != 0) {
                                            i15 &= -15;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            i15 &= -113;
                                        }
                                        if ((i3 & 16384) != 0) {
                                            i15 &= -57345;
                                        }
                                        function26 = function23;
                                        searchBarColors3 = searchBarColors;
                                        f4 = f2;
                                        windowInsets3 = windowInsets;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        function24 = obj4;
                                        modifier2 = obj2;
                                        z4 = z3;
                                        function25 = obj3;
                                        composer2 = startRestartGroup;
                                        i19 = i15;
                                        shape3 = shape;
                                        f3 = f;
                                        i18 = i4;
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1001512593, i18, i19, "androidx.compose.material3.SearchBar (SearchBar.android.kt:745)");
                                    }
                                    final Function1<? super String, Unit> function14 = obj;
                                    ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1158111311, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
                                        /* JADX INFO: Access modifiers changed from: package-private */
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

                                        public final void invoke(Composer composer4, int i25) {
                                            ComposerKt.sourceInformation(composer4, "C747@34450L549:SearchBar.android.kt#uh7d8r");
                                            if ((i25 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1158111311, i25, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:747)");
                                                }
                                                SearchBarDefaults.INSTANCE.InputField(str, function14, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z4, function25, function24, function26, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }, composer2, 54);
                                    int i25 = i18 >> 6;
                                    int i26 = 6 | (i25 & 112) | (i25 & 896) | (i25 & 7168);
                                    int i27 = i19 << 12;
                                    Composer composer4 = composer2;
                                    SearchBarColors searchBarColors5 = searchBarColors3;
                                    m2230SearchBarY92LkZI(rememberComposableLambda, z, function13, modifier2, shape3, searchBarColors5, f3, f4, windowInsets3, function3, composer4, i26 | (57344 & i27) | (458752 & i27) | (3670016 & i27) | (29360128 & i27) | (i27 & 234881024) | ((i19 << 9) & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    obj2 = modifier2;
                                    f5 = f3;
                                    windowInsets4 = windowInsets3;
                                    composer3 = composer4;
                                    searchBarColors4 = searchBarColors5;
                                    z5 = z4;
                                    function27 = function24;
                                    function28 = function26;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    f6 = f4;
                                    shape4 = shape3;
                                    function29 = function25;
                                }
                                endRestartGroup = composer3.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$5
                                        /* JADX INFO: Access modifiers changed from: package-private */
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

                                        public final void invoke(Composer composer5, int i28) {
                                            SearchBar_androidKt.m2229SearchBarWuY5d9Q(str, function1, function12, z, function13, obj2, z5, function29, function27, function28, shape4, searchBarColors4, f5, f6, windowInsets4, mutableInteractionSource3, function3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i17 = i14;
                            if ((i3 & 65536) == 0) {
                            }
                            if ((i4 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i10 == 0) {
                            }
                            if ((i3 & 1024) == 0) {
                            }
                            if ((i3 & 2048) == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i17 == 0) {
                            }
                            if ((i3 & 16384) == 0) {
                            }
                            if (i16 == 0) {
                            }
                            function25 = obj5;
                            function26 = function210;
                            shape3 = shape2;
                            modifier2 = companion;
                            z4 = z6;
                            i19 = i15;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final Function1<? super String, Unit> function142 = obj;
                            ComposableLambda rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1158111311, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer42, Integer num) {
                                    invoke(composer42, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer42, int i252) {
                                    ComposerKt.sourceInformation(composer42, "C747@34450L549:SearchBar.android.kt#uh7d8r");
                                    if ((i252 & 3) != 2 || !composer42.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1158111311, i252, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:747)");
                                        }
                                        SearchBarDefaults.INSTANCE.InputField(str, function142, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z4, function25, function24, function26, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer42, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer42.skipToGroupEnd();
                                }
                            }, composer2, 54);
                            int i252 = i18 >> 6;
                            int i262 = 6 | (i252 & 112) | (i252 & 896) | (i252 & 7168);
                            int i272 = i19 << 12;
                            Composer composer42 = composer2;
                            SearchBarColors searchBarColors52 = searchBarColors3;
                            m2230SearchBarY92LkZI(rememberComposableLambda2, z, function13, modifier2, shape3, searchBarColors52, f3, f4, windowInsets3, function3, composer42, i262 | (57344 & i272) | (458752 & i272) | (3670016 & i272) | (29360128 & i272) | (i272 & 234881024) | ((i19 << 9) & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            obj2 = modifier2;
                            f5 = f3;
                            windowInsets4 = windowInsets3;
                            composer3 = composer42;
                            searchBarColors4 = searchBarColors52;
                            z5 = z4;
                            function27 = function24;
                            function28 = function26;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            f6 = f4;
                            shape4 = shape3;
                            function29 = function25;
                            endRestartGroup = composer3.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    i16 = i3 & 32768;
                    if (i16 != 0) {
                    }
                    i17 = i14;
                    if ((i3 & 65536) == 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if ((i3 & 1024) == 0) {
                    }
                    if ((i3 & 2048) == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if ((i3 & 16384) == 0) {
                    }
                    if (i16 == 0) {
                    }
                    function25 = obj5;
                    function26 = function210;
                    shape3 = shape2;
                    modifier2 = companion;
                    z4 = z6;
                    i19 = i15;
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function1<? super String, Unit> function1422 = obj;
                    ComposableLambda rememberComposableLambda22 = ComposableLambdaKt.rememberComposableLambda(-1158111311, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer422, Integer num) {
                            invoke(composer422, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer422, int i2522) {
                            ComposerKt.sourceInformation(composer422, "C747@34450L549:SearchBar.android.kt#uh7d8r");
                            if ((i2522 & 3) != 2 || !composer422.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1158111311, i2522, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:747)");
                                }
                                SearchBarDefaults.INSTANCE.InputField(str, function1422, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z4, function25, function24, function26, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer422, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer422.skipToGroupEnd();
                        }
                    }, composer2, 54);
                    int i2522 = i18 >> 6;
                    int i2622 = 6 | (i2522 & 112) | (i2522 & 896) | (i2522 & 7168);
                    int i2722 = i19 << 12;
                    Composer composer422 = composer2;
                    SearchBarColors searchBarColors522 = searchBarColors3;
                    m2230SearchBarY92LkZI(rememberComposableLambda22, z, function13, modifier2, shape3, searchBarColors522, f3, f4, windowInsets3, function3, composer422, i2622 | (57344 & i2722) | (458752 & i2722) | (3670016 & i2722) | (29360128 & i2722) | (i2722 & 234881024) | ((i19 << 9) & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    obj2 = modifier2;
                    f5 = f3;
                    windowInsets4 = windowInsets3;
                    composer3 = composer422;
                    searchBarColors4 = searchBarColors522;
                    z5 = z4;
                    function27 = function24;
                    function28 = function26;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    f6 = f4;
                    shape4 = shape3;
                    function29 = function25;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i10 = i9;
                if ((i2 & 6) != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i232 = i11;
                i12 = i3 & 4096;
                if (i12 == 0) {
                }
                i14 = i3 & 8192;
                if (i14 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                i16 = i3 & 32768;
                if (i16 != 0) {
                }
                i17 = i14;
                if ((i3 & 65536) == 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 != 0) {
                }
                if (i10 == 0) {
                }
                if ((i3 & 1024) == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                if (i12 == 0) {
                }
                if (i17 == 0) {
                }
                if ((i3 & 16384) == 0) {
                }
                if (i16 == 0) {
                }
                function25 = obj5;
                function26 = function210;
                shape3 = shape2;
                modifier2 = companion;
                z4 = z6;
                i19 = i15;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function1<? super String, Unit> function14222 = obj;
                ComposableLambda rememberComposableLambda222 = ComposableLambdaKt.rememberComposableLambda(-1158111311, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4222, Integer num) {
                        invoke(composer4222, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4222, int i25222) {
                        ComposerKt.sourceInformation(composer4222, "C747@34450L549:SearchBar.android.kt#uh7d8r");
                        if ((i25222 & 3) != 2 || !composer4222.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1158111311, i25222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:747)");
                            }
                            SearchBarDefaults.INSTANCE.InputField(str, function14222, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z4, function25, function24, function26, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer4222, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer4222.skipToGroupEnd();
                    }
                }, composer2, 54);
                int i25222 = i18 >> 6;
                int i26222 = 6 | (i25222 & 112) | (i25222 & 896) | (i25222 & 7168);
                int i27222 = i19 << 12;
                Composer composer4222 = composer2;
                SearchBarColors searchBarColors5222 = searchBarColors3;
                m2230SearchBarY92LkZI(rememberComposableLambda222, z, function13, modifier2, shape3, searchBarColors5222, f3, f4, windowInsets3, function3, composer4222, i26222 | (57344 & i27222) | (458752 & i27222) | (3670016 & i27222) | (29360128 & i27222) | (i27222 & 234881024) | ((i19 << 9) & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                obj2 = modifier2;
                f5 = f3;
                windowInsets4 = windowInsets3;
                composer3 = composer4222;
                searchBarColors4 = searchBarColors5222;
                z5 = z4;
                function27 = function24;
                function28 = function26;
                mutableInteractionSource3 = mutableInteractionSource2;
                f6 = f4;
                shape4 = shape3;
                function29 = function25;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i5 = i3 & 32;
            if (i5 != 0) {
            }
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i2 & 6) != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i2322 = i11;
            i12 = i3 & 4096;
            if (i12 == 0) {
            }
            i14 = i3 & 8192;
            if (i14 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i16 = i3 & 32768;
            if (i16 != 0) {
            }
            i17 = i14;
            if ((i3 & 65536) == 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 != 0) {
            }
            if (i10 == 0) {
            }
            if ((i3 & 1024) == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            if (i12 == 0) {
            }
            if (i17 == 0) {
            }
            if ((i3 & 16384) == 0) {
            }
            if (i16 == 0) {
            }
            function25 = obj5;
            function26 = function210;
            shape3 = shape2;
            modifier2 = companion;
            z4 = z6;
            i19 = i15;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function1<? super String, Unit> function142222 = obj;
            ComposableLambda rememberComposableLambda2222 = ComposableLambdaKt.rememberComposableLambda(-1158111311, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer42222, Integer num) {
                    invoke(composer42222, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer42222, int i252222) {
                    ComposerKt.sourceInformation(composer42222, "C747@34450L549:SearchBar.android.kt#uh7d8r");
                    if ((i252222 & 3) != 2 || !composer42222.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1158111311, i252222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:747)");
                        }
                        SearchBarDefaults.INSTANCE.InputField(str, function142222, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z4, function25, function24, function26, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer42222, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer42222.skipToGroupEnd();
                }
            }, composer2, 54);
            int i252222 = i18 >> 6;
            int i262222 = 6 | (i252222 & 112) | (i252222 & 896) | (i252222 & 7168);
            int i272222 = i19 << 12;
            Composer composer42222 = composer2;
            SearchBarColors searchBarColors52222 = searchBarColors3;
            m2230SearchBarY92LkZI(rememberComposableLambda2222, z, function13, modifier2, shape3, searchBarColors52222, f3, f4, windowInsets3, function3, composer42222, i262222 | (57344 & i272222) | (458752 & i272222) | (3670016 & i272222) | (29360128 & i272222) | (i272222 & 234881024) | ((i19 << 9) & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            obj2 = modifier2;
            f5 = f3;
            windowInsets4 = windowInsets3;
            composer3 = composer42222;
            searchBarColors4 = searchBarColors52222;
            z5 = z4;
            function27 = function24;
            function28 = function26;
            mutableInteractionSource3 = mutableInteractionSource2;
            f6 = f4;
            shape4 = shape3;
            function29 = function25;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        int i222 = 8192;
        if ((i3 & 16) == 0) {
        }
        i5 = i3 & 32;
        if (i5 != 0) {
        }
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i23222 = i11;
        i12 = i3 & 4096;
        if (i12 == 0) {
        }
        i14 = i3 & 8192;
        if (i14 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i16 = i3 & 32768;
        if (i16 != 0) {
        }
        i17 = i14;
        if ((i3 & 65536) == 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 != 0) {
        }
        if (i10 == 0) {
        }
        if ((i3 & 1024) == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        if (i12 == 0) {
        }
        if (i17 == 0) {
        }
        if ((i3 & 16384) == 0) {
        }
        if (i16 == 0) {
        }
        function25 = obj5;
        function26 = function210;
        shape3 = shape2;
        modifier2 = companion;
        z4 = z6;
        i19 = i15;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function1<? super String, Unit> function1422222 = obj;
        ComposableLambda rememberComposableLambda22222 = ComposableLambdaKt.rememberComposableLambda(-1158111311, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer422222, Integer num) {
                invoke(composer422222, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer422222, int i2522222) {
                ComposerKt.sourceInformation(composer422222, "C747@34450L549:SearchBar.android.kt#uh7d8r");
                if ((i2522222 & 3) != 2 || !composer422222.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1158111311, i2522222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:747)");
                    }
                    SearchBarDefaults.INSTANCE.InputField(str, function1422222, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z4, function25, function24, function26, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer422222, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer422222.skipToGroupEnd();
            }
        }, composer2, 54);
        int i2522222 = i18 >> 6;
        int i2622222 = 6 | (i2522222 & 112) | (i2522222 & 896) | (i2522222 & 7168);
        int i2722222 = i19 << 12;
        Composer composer422222 = composer2;
        SearchBarColors searchBarColors522222 = searchBarColors3;
        m2230SearchBarY92LkZI(rememberComposableLambda22222, z, function13, modifier2, shape3, searchBarColors522222, f3, f4, windowInsets3, function3, composer422222, i2622222 | (57344 & i2722222) | (458752 & i2722222) | (3670016 & i2722222) | (29360128 & i2722222) | (i2722222 & 234881024) | ((i19 << 9) & 1879048192), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        obj2 = modifier2;
        f5 = f3;
        windowInsets4 = windowInsets3;
        composer3 = composer422222;
        searchBarColors4 = searchBarColors522222;
        z5 = z4;
        function27 = function24;
        function28 = function26;
        mutableInteractionSource3 = mutableInteractionSource2;
        f6 = f4;
        shape4 = shape3;
        function29 = function25;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:237:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012c  */
    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(expression = "DockedSearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    content = content,\n)", imports = {}))
    /* renamed from: DockedSearchBar-eWTbjVg  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2228DockedSearchBareWTbjVg(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        Object obj;
        int i4;
        int i5;
        final Object obj2;
        int i6;
        boolean z3;
        int i7;
        Object obj3;
        int i8;
        Object obj4;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Shape shape2;
        boolean z4;
        Composer composer2;
        int i20;
        SearchBarColors searchBarColors2;
        int i21;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final SearchBarColors searchBarColors3;
        float f3;
        float f4;
        Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final boolean z5;
        final float f5;
        Composer composer3;
        final SearchBarColors searchBarColors4;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape4;
        final float f6;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        ScopeUpdateScope endRestartGroup;
        int i22;
        int i23;
        Composer startRestartGroup = composer.startRestartGroup(1299054533);
        ComposerKt.sourceInformation(startRestartGroup, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)818@37222L11,819@37283L8,826@37565L591,825@37527L894:SearchBar.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            obj = str;
        } else {
            obj = str;
            if ((i & 6) == 0) {
                i4 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
                i5 = i3 & 32;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    obj2 = modifier;
                } else {
                    obj2 = modifier;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                    }
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                    z3 = z2;
                } else {
                    z3 = z2;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                    }
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    obj3 = function2;
                } else {
                    obj3 = function2;
                    if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(obj3) ? 8388608 : 4194304;
                    }
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                    i4 |= 100663296;
                    obj4 = function22;
                } else {
                    obj4 = function22;
                    if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(obj4) ? 67108864 : 33554432;
                    }
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i10 = i9;
                    i4 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0 && startRestartGroup.changed(shape)) {
                            i23 = 4;
                            i11 = i2 | i23;
                        }
                        i23 = 2;
                        i11 = i2 | i23;
                    } else {
                        i11 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i3 & 2048) == 0 && startRestartGroup.changed(searchBarColors)) {
                            i22 = 32;
                            i11 |= i22;
                        }
                        i22 = 16;
                        i11 |= i22;
                    }
                    int i24 = i11;
                    i12 = i3 & 4096;
                    if (i12 == 0) {
                        i13 = i24 | RendererCapabilities.DECODER_SUPPORT_MASK;
                    } else {
                        int i25 = i24;
                        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i25 |= startRestartGroup.changed(f) ? 256 : 128;
                        }
                        i13 = i25;
                    }
                    i14 = i3 & 8192;
                    if (i14 == 0) {
                        i15 = i13 | 3072;
                    } else {
                        int i26 = i13;
                        if ((i2 & 3072) == 0) {
                            i15 = i26 | (startRestartGroup.changed(f2) ? 2048 : 1024);
                        } else {
                            i15 = i26;
                        }
                    }
                    i16 = i3 & 16384;
                    if (i16 == 0) {
                        i17 = i15 | 24576;
                    } else {
                        i17 = i15;
                        if ((i2 & 24576) == 0) {
                            i17 |= startRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                            if ((i3 & 32768) != 0) {
                                i17 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i18 = i16;
                                i17 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                                if ((i4 & 306783379) != 306783378 && (i17 & 74899) == 74898 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    shape4 = shape;
                                    searchBarColors4 = searchBarColors;
                                    f5 = f2;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    function27 = obj4;
                                    z6 = z3;
                                    function28 = obj3;
                                    composer3 = startRestartGroup;
                                    function29 = function23;
                                    f6 = f;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier.Companion companion = i5 == 0 ? Modifier.Companion : obj2;
                                        boolean z7 = i6 == 0 ? true : z3;
                                        Object obj5 = i7 == 0 ? null : obj3;
                                        if (i8 != 0) {
                                            obj4 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function210 = i10 == 0 ? null : function23;
                                        if ((i3 & 1024) == 0) {
                                            i19 = i17 & (-15);
                                            shape2 = SearchBarDefaults.INSTANCE.getDockedShape(startRestartGroup, 6);
                                        } else {
                                            i19 = i17;
                                            shape2 = shape;
                                        }
                                        if ((i3 & 2048) == 0) {
                                            z4 = true;
                                            composer2 = startRestartGroup;
                                            i20 = i4;
                                            searchBarColors2 = SearchBarDefaults.INSTANCE.m2220colorsdgg9oW8(0L, 0L, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                                            i21 = i19 & (-113);
                                        } else {
                                            z4 = true;
                                            composer2 = startRestartGroup;
                                            i20 = i4;
                                            searchBarColors2 = searchBarColors;
                                            i21 = i19;
                                        }
                                        float m2224getTonalElevationD9Ej5fM = i12 == 0 ? SearchBarDefaults.INSTANCE.m2224getTonalElevationD9Ej5fM() : f;
                                        float m2223getShadowElevationD9Ej5fM = i14 == 0 ? SearchBarDefaults.INSTANCE.m2223getShadowElevationD9Ej5fM() : f2;
                                        if (i18 == 0) {
                                            function24 = obj4;
                                            searchBarColors3 = searchBarColors2;
                                            f3 = m2224getTonalElevationD9Ej5fM;
                                            f4 = m2223getShadowElevationD9Ej5fM;
                                            shape3 = shape2;
                                            mutableInteractionSource2 = null;
                                        } else {
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            function24 = obj4;
                                            searchBarColors3 = searchBarColors2;
                                            f3 = m2224getTonalElevationD9Ej5fM;
                                            f4 = m2223getShadowElevationD9Ej5fM;
                                            shape3 = shape2;
                                        }
                                        function25 = function210;
                                        modifier2 = companion;
                                        function26 = obj5;
                                        z5 = z7;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 1024) != 0) {
                                            i17 &= -15;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            i17 &= -113;
                                        }
                                        function25 = function23;
                                        searchBarColors3 = searchBarColors;
                                        f4 = f2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        function24 = obj4;
                                        z4 = true;
                                        modifier2 = obj2;
                                        z5 = z3;
                                        function26 = obj3;
                                        composer2 = startRestartGroup;
                                        i21 = i17;
                                        shape3 = shape;
                                        f3 = f;
                                        i20 = i4;
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1299054533, i20, i21, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:825)");
                                    }
                                    final String str2 = obj;
                                    int i27 = i20 >> 6;
                                    int i28 = i21 << 12;
                                    Composer composer4 = composer2;
                                    SearchBarColors searchBarColors5 = searchBarColors3;
                                    m2227DockedSearchBarEQC0FA8(ComposableLambdaKt.rememberComposableLambda(-303118761, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4
                                        /* JADX INFO: Access modifiers changed from: package-private */
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

                                        public final void invoke(Composer composer5, int i29) {
                                            ComposerKt.sourceInformation(composer5, "C827@37597L549:SearchBar.android.kt#uh7d8r");
                                            if ((i29 & 3) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-303118761, i29, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:827)");
                                                }
                                                SearchBarDefaults.INSTANCE.InputField(str2, function1, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z5, function26, function24, function25, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }, composer2, 54), z, function13, modifier2, shape3, searchBarColors5, f3, f4, function3, composer4, (i27 & 7168) | (i27 & 112) | 6 | (i27 & 896) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (i28 & 29360128) | ((i21 << 9) & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    obj2 = modifier2;
                                    f5 = f4;
                                    composer3 = composer4;
                                    searchBarColors4 = searchBarColors5;
                                    z6 = z5;
                                    function27 = function24;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    shape4 = shape3;
                                    f6 = f3;
                                    function28 = function26;
                                    function29 = function25;
                                }
                                endRestartGroup = composer3.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$5
                                        /* JADX INFO: Access modifiers changed from: package-private */
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

                                        public final void invoke(Composer composer5, int i29) {
                                            SearchBar_androidKt.m2228DockedSearchBareWTbjVg(str, function1, function12, z, function13, obj2, z6, function28, function27, function29, shape4, searchBarColors4, f6, f5, mutableInteractionSource3, function3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i18 = i16;
                            if ((i4 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i10 == 0) {
                            }
                            if ((i3 & 1024) == 0) {
                            }
                            if ((i3 & 2048) == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            function25 = function210;
                            modifier2 = companion;
                            function26 = obj5;
                            z5 = z7;
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final String str22 = obj;
                            int i272 = i20 >> 6;
                            int i282 = i21 << 12;
                            Composer composer42 = composer2;
                            SearchBarColors searchBarColors52 = searchBarColors3;
                            m2227DockedSearchBarEQC0FA8(ComposableLambdaKt.rememberComposableLambda(-303118761, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4
                                /* JADX INFO: Access modifiers changed from: package-private */
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

                                public final void invoke(Composer composer5, int i29) {
                                    ComposerKt.sourceInformation(composer5, "C827@37597L549:SearchBar.android.kt#uh7d8r");
                                    if ((i29 & 3) != 2 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-303118761, i29, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:827)");
                                        }
                                        SearchBarDefaults.INSTANCE.InputField(str22, function1, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z5, function26, function24, function25, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer5.skipToGroupEnd();
                                }
                            }, composer2, 54), z, function13, modifier2, shape3, searchBarColors52, f3, f4, function3, composer42, (i272 & 7168) | (i272 & 112) | 6 | (i272 & 896) | (57344 & i282) | (458752 & i282) | (3670016 & i282) | (i282 & 29360128) | ((i21 << 9) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            obj2 = modifier2;
                            f5 = f4;
                            composer3 = composer42;
                            searchBarColors4 = searchBarColors52;
                            z6 = z5;
                            function27 = function24;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape4 = shape3;
                            f6 = f3;
                            function28 = function26;
                            function29 = function25;
                            endRestartGroup = composer3.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                    }
                    if ((i3 & 32768) != 0) {
                    }
                    i18 = i16;
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if ((i3 & 1024) == 0) {
                    }
                    if ((i3 & 2048) == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    function25 = function210;
                    modifier2 = companion;
                    function26 = obj5;
                    z5 = z7;
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final String str222 = obj;
                    int i2722 = i20 >> 6;
                    int i2822 = i21 << 12;
                    Composer composer422 = composer2;
                    SearchBarColors searchBarColors522 = searchBarColors3;
                    m2227DockedSearchBarEQC0FA8(ComposableLambdaKt.rememberComposableLambda(-303118761, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4
                        /* JADX INFO: Access modifiers changed from: package-private */
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

                        public final void invoke(Composer composer5, int i29) {
                            ComposerKt.sourceInformation(composer5, "C827@37597L549:SearchBar.android.kt#uh7d8r");
                            if ((i29 & 3) != 2 || !composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-303118761, i29, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:827)");
                                }
                                SearchBarDefaults.INSTANCE.InputField(str222, function1, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z5, function26, function24, function25, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer5.skipToGroupEnd();
                        }
                    }, composer2, 54), z, function13, modifier2, shape3, searchBarColors522, f3, f4, function3, composer422, (i2722 & 7168) | (i2722 & 112) | 6 | (i2722 & 896) | (57344 & i2822) | (458752 & i2822) | (3670016 & i2822) | (i2822 & 29360128) | ((i21 << 9) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    obj2 = modifier2;
                    f5 = f4;
                    composer3 = composer422;
                    searchBarColors4 = searchBarColors522;
                    z6 = z5;
                    function27 = function24;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape4 = shape3;
                    f6 = f3;
                    function28 = function26;
                    function29 = function25;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i10 = i9;
                if ((i2 & 6) != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i242 = i11;
                i12 = i3 & 4096;
                if (i12 == 0) {
                }
                i14 = i3 & 8192;
                if (i14 == 0) {
                }
                i16 = i3 & 16384;
                if (i16 == 0) {
                }
                if ((i3 & 32768) != 0) {
                }
                i18 = i16;
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 != 0) {
                }
                if (i10 == 0) {
                }
                if ((i3 & 1024) == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                if (i12 == 0) {
                }
                if (i14 == 0) {
                }
                if (i18 == 0) {
                }
                function25 = function210;
                modifier2 = companion;
                function26 = obj5;
                z5 = z7;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final String str2222 = obj;
                int i27222 = i20 >> 6;
                int i28222 = i21 << 12;
                Composer composer4222 = composer2;
                SearchBarColors searchBarColors5222 = searchBarColors3;
                m2227DockedSearchBarEQC0FA8(ComposableLambdaKt.rememberComposableLambda(-303118761, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4
                    /* JADX INFO: Access modifiers changed from: package-private */
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

                    public final void invoke(Composer composer5, int i29) {
                        ComposerKt.sourceInformation(composer5, "C827@37597L549:SearchBar.android.kt#uh7d8r");
                        if ((i29 & 3) != 2 || !composer5.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-303118761, i29, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:827)");
                            }
                            SearchBarDefaults.INSTANCE.InputField(str2222, function1, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z5, function26, function24, function25, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer5.skipToGroupEnd();
                    }
                }, composer2, 54), z, function13, modifier2, shape3, searchBarColors5222, f3, f4, function3, composer4222, (i27222 & 7168) | (i27222 & 112) | 6 | (i27222 & 896) | (57344 & i28222) | (458752 & i28222) | (3670016 & i28222) | (i28222 & 29360128) | ((i21 << 9) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                obj2 = modifier2;
                f5 = f4;
                composer3 = composer4222;
                searchBarColors4 = searchBarColors5222;
                z6 = z5;
                function27 = function24;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape4 = shape3;
                f6 = f3;
                function28 = function26;
                function29 = function25;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i5 = i3 & 32;
            if (i5 != 0) {
            }
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i2 & 6) != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i2422 = i11;
            i12 = i3 & 4096;
            if (i12 == 0) {
            }
            i14 = i3 & 8192;
            if (i14 == 0) {
            }
            i16 = i3 & 16384;
            if (i16 == 0) {
            }
            if ((i3 & 32768) != 0) {
            }
            i18 = i16;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 != 0) {
            }
            if (i10 == 0) {
            }
            if ((i3 & 1024) == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            if (i12 == 0) {
            }
            if (i14 == 0) {
            }
            if (i18 == 0) {
            }
            function25 = function210;
            modifier2 = companion;
            function26 = obj5;
            z5 = z7;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final String str22222 = obj;
            int i272222 = i20 >> 6;
            int i282222 = i21 << 12;
            Composer composer42222 = composer2;
            SearchBarColors searchBarColors52222 = searchBarColors3;
            m2227DockedSearchBarEQC0FA8(ComposableLambdaKt.rememberComposableLambda(-303118761, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4
                /* JADX INFO: Access modifiers changed from: package-private */
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

                public final void invoke(Composer composer5, int i29) {
                    ComposerKt.sourceInformation(composer5, "C827@37597L549:SearchBar.android.kt#uh7d8r");
                    if ((i29 & 3) != 2 || !composer5.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-303118761, i29, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:827)");
                        }
                        SearchBarDefaults.INSTANCE.InputField(str22222, function1, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z5, function26, function24, function25, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer5.skipToGroupEnd();
                }
            }, composer2, 54), z, function13, modifier2, shape3, searchBarColors52222, f3, f4, function3, composer42222, (i272222 & 7168) | (i272222 & 112) | 6 | (i272222 & 896) | (57344 & i282222) | (458752 & i282222) | (3670016 & i282222) | (i282222 & 29360128) | ((i21 << 9) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            obj2 = modifier2;
            f5 = f4;
            composer3 = composer42222;
            searchBarColors4 = searchBarColors52222;
            z6 = z5;
            function27 = function24;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape4 = shape3;
            f6 = f3;
            function28 = function26;
            function29 = function25;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i3 & 16) == 0) {
        }
        i5 = i3 & 32;
        if (i5 != 0) {
        }
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i24222 = i11;
        i12 = i3 & 4096;
        if (i12 == 0) {
        }
        i14 = i3 & 8192;
        if (i14 == 0) {
        }
        i16 = i3 & 16384;
        if (i16 == 0) {
        }
        if ((i3 & 32768) != 0) {
        }
        i18 = i16;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 != 0) {
        }
        if (i10 == 0) {
        }
        if ((i3 & 1024) == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        if (i12 == 0) {
        }
        if (i14 == 0) {
        }
        if (i18 == 0) {
        }
        function25 = function210;
        modifier2 = companion;
        function26 = obj5;
        z5 = z7;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final String str222222 = obj;
        int i2722222 = i20 >> 6;
        int i2822222 = i21 << 12;
        Composer composer422222 = composer2;
        SearchBarColors searchBarColors522222 = searchBarColors3;
        m2227DockedSearchBarEQC0FA8(ComposableLambdaKt.rememberComposableLambda(-303118761, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4
            /* JADX INFO: Access modifiers changed from: package-private */
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

            public final void invoke(Composer composer5, int i29) {
                ComposerKt.sourceInformation(composer5, "C827@37597L549:SearchBar.android.kt#uh7d8r");
                if ((i29 & 3) != 2 || !composer5.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-303118761, i29, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:827)");
                    }
                    SearchBarDefaults.INSTANCE.InputField(str222222, function1, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z5, function26, function24, function25, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource2, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer5.skipToGroupEnd();
            }
        }, composer2, 54), z, function13, modifier2, shape3, searchBarColors522222, f3, f4, function3, composer422222, (i2722222 & 7168) | (i2722222 & 112) | 6 | (i2722222 & 896) | (57344 & i2822222) | (458752 & i2822222) | (3670016 & i2822222) | (i2822222 & 29360128) | ((i21 << 9) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        obj2 = modifier2;
        f5 = f4;
        composer3 = composer422222;
        searchBarColors4 = searchBarColors522222;
        z6 = z5;
        function27 = function24;
        mutableInteractionSource3 = mutableInteractionSource2;
        shape4 = shape3;
        f6 = f3;
        function28 = function26;
        function29 = function25;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /* renamed from: SearchBarImpl-j1jLAyQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2231SearchBarImplj1jLAyQ(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState mutableFloatState, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        Object obj2;
        Object obj3;
        int i5;
        int i6;
        int i7;
        int i8;
        float f3;
        Object obj4;
        int i9;
        Object obj5;
        Object obj6;
        int i10;
        SearchBarColors searchBarColors2;
        int i11;
        Object obj7;
        int i12;
        final float f4;
        int i13;
        final Object obj8;
        final float f5;
        Shape shape2;
        Object obj9;
        Object obj10;
        Shape inputFieldShape;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        GenericShape genericShape;
        Object rememberedValue3;
        Composer composer2;
        final SearchBarColors searchBarColors3;
        final float f6;
        final float f7;
        final Shape shape3;
        final WindowInsets windowInsets2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-440333505);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBarImpl)P(!1,4,5,3,7,6,9!1,10:c#ui.unit.Dp,8:c#ui.unit.Dp,11)861@38824L15,862@38889L8,865@39070L12,868@39168L7,870@39228L15,871@39295L15,872@39341L101,876@39475L666,892@40180L333,903@40538L99,916@40970L362:SearchBar.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = ((i & 8) == 0 ? startRestartGroup.changed(animatable) : startRestartGroup.changedInstance(animatable) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(mutableFloatState) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(mutableState) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
            obj = mutableState2;
        } else {
            obj = mutableState2;
            if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            }
        }
        int i16 = i3 & 16;
        if (i16 != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            obj2 = modifier;
            i4 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
            if ((i3 & 32) == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i4 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
            }
            if ((i & 1572864) == 0) {
                i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : 524288;
            }
            if ((i & 12582912) != 0) {
                if ((i3 & 128) == 0) {
                    obj3 = searchBarColors;
                    if (startRestartGroup.changed(obj3)) {
                        i15 = 8388608;
                        i4 |= i15;
                    }
                } else {
                    obj3 = searchBarColors;
                }
                i15 = 4194304;
                i4 |= i15;
            } else {
                obj3 = searchBarColors;
            }
            i5 = i3 & 256;
            if (i5 == 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i6 = i5;
                i4 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
                i7 = i3 & 512;
                if (i7 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i8 = i7;
                    f3 = f2;
                    i4 |= startRestartGroup.changed(f3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0) {
                            obj4 = windowInsets;
                            if (startRestartGroup.changed(obj4)) {
                                i14 = 4;
                                i9 = i2 | i14;
                            }
                        } else {
                            obj4 = windowInsets;
                        }
                        i14 = 2;
                        i9 = i2 | i14;
                    } else {
                        obj4 = windowInsets;
                        i9 = i2;
                    }
                    if ((i3 & 2048) == 0) {
                        i9 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i9 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
                    }
                    if ((306783379 & i4) == 306783378 || (i9 & 19) != 18 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i16 == 0 ? Modifier.Companion : obj2;
                            if ((i3 & 64) == 0) {
                                i4 &= -3670017;
                                obj5 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                            } else {
                                obj5 = shape;
                            }
                            int i17 = i4;
                            if ((i3 & 128) == 0) {
                                obj6 = companion;
                                i10 = 6;
                                searchBarColors2 = SearchBarDefaults.INSTANCE.m2220colorsdgg9oW8(0L, 0L, startRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 3);
                                i11 = i17 & (-29360129);
                            } else {
                                obj6 = companion;
                                i10 = 6;
                                searchBarColors2 = obj3;
                                i11 = i17;
                            }
                            float m2224getTonalElevationD9Ej5fM = i6 == 0 ? SearchBarDefaults.INSTANCE.m2224getTonalElevationD9Ej5fM() : f;
                            float m2223getShadowElevationD9Ej5fM = i8 == 0 ? SearchBarDefaults.INSTANCE.m2223getShadowElevationD9Ej5fM() : f2;
                            if ((i3 & 1024) == 0) {
                                i12 = i11;
                                obj7 = SearchBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, i10);
                                i13 = i9 & (-15);
                                obj8 = searchBarColors2;
                                f4 = m2223getShadowElevationD9Ej5fM;
                                shape2 = obj5;
                                f5 = m2224getTonalElevationD9Ej5fM;
                            } else {
                                obj7 = windowInsets;
                                i12 = i11;
                                f4 = m2223getShadowElevationD9Ej5fM;
                                i13 = i9;
                                obj8 = searchBarColors2;
                                f5 = m2224getTonalElevationD9Ej5fM;
                                shape2 = obj5;
                            }
                            obj9 = obj6;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                            }
                            if ((i3 & 1024) != 0) {
                                i9 &= -15;
                            }
                            f5 = f;
                            obj7 = obj4;
                            i13 = i9;
                            f4 = f3;
                            obj8 = obj3;
                            obj9 = obj2;
                            i12 = i4;
                            shape2 = shape;
                        }
                        startRestartGroup.endDefaults();
                        Modifier modifier3 = obj9;
                        if (ComposerKt.isTraceInProgress()) {
                            obj10 = obj7;
                        } else {
                            obj10 = obj7;
                            ComposerKt.traceEventStart(-440333505, i12, i13, "androidx.compose.material3.SearchBarImpl (SearchBar.android.kt:867)");
                        }
                        int i18 = i13;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final Density density = (Density) consume;
                        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                        Shape fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567245043, "CC(remember):SearchBar.android.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$useFullScreenShape$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(animatable.getValue().floatValue() == 1.0f);
                                }
                            });
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        State state = (State) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        boolean SearchBarImpl_j1jLAyQ$lambda$9 = SearchBarImpl_j1jLAyQ$lambda$9(state);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567240190, "CC(remember):SearchBar.android.kt#9igjgp");
                        changed = startRestartGroup.changed(SearchBarImpl_j1jLAyQ$lambda$9) | ((((3670016 & i12) ^ 1572864) <= 1048576 && startRestartGroup.changed(shape2)) || (i12 & 1572864) == 1048576);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                            if (!Intrinsics.areEqual(shape2, inputFieldShape)) {
                                genericShape = new GenericShape(new Function3<Path, Size, LayoutDirection, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$animatedShape$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Path path, Size size, LayoutDirection layoutDirection) {
                                        m2236invoke12SF9DM(path, size.m3911unboximpl(), layoutDirection);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-12SF9DM  reason: not valid java name */
                                    public final void m2236invoke12SF9DM(Path path, long j, LayoutDirection layoutDirection) {
                                        float f8;
                                        Density density2 = Density.this;
                                        Animatable<Float, AnimationVector1D> animatable2 = animatable;
                                        f8 = SearchBar_androidKt.SearchBarCornerRadius;
                                        Path.addRoundRect$default(path, RoundRectKt.m3892RoundRectsniSvfs(androidx.compose.ui.geometry.SizeKt.m3927toRectuvyYCjk(j), CornerRadiusKt.CornerRadius$default(density2.mo389toPx0680j_4(Dp.m6684constructorimpl(f8 * (1 - animatable2.getValue().floatValue()))), 0.0f, 2, null)), null, 2, null);
                                    }
                                });
                            } else {
                                genericShape = SearchBarImpl_j1jLAyQ$lambda$9(state) ? fullScreenShape : shape2;
                            }
                            startRestartGroup.updateRememberedValue(genericShape);
                            rememberedValue2 = genericShape;
                        }
                        final Shape shape4 = (Shape) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-170534294, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$surface$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i19) {
                                ComposerKt.sourceInformation(composer3, "C896@40320L38,893@40194L309:SearchBar.android.kt#uh7d8r");
                                if ((i19 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-170534294, i19, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.android.kt:893)");
                                    }
                                    SurfaceKt.m2347SurfaceT9BRK9s(null, Shape.this, obj8.m2216getContainerColor0d7_KjU(), ColorSchemeKt.m1733contentColorForek8zF_U(obj8.m2216getContainerColor0d7_KjU(), composer3, 0), f5, f4, null, ComposableSingletons$SearchBar_androidKt.INSTANCE.m1782getLambda2$material3_release(), composer3, 12582912, 65);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, startRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567206741, "CC(remember):SearchBar.android.kt#9igjgp");
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$showContent$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(animatable.getValue().floatValue() > 0.0f);
                                }
                            });
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.startReplaceGroup(-1567201454);
                        ComposerKt.sourceInformation(startRestartGroup, "908@40729L215");
                        ComposableLambda rememberComposableLambda2 = !SearchBarImpl_j1jLAyQ$lambda$12((State) rememberedValue3) ? ComposableLambdaKt.rememberComposableLambda(147843820, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$wrappedContent$1
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

                            public final void invoke(Composer composer3, int i19) {
                                ComposerKt.sourceInformation(composer3, "C909@40777L35,909@40747L183:SearchBar.android.kt#uh7d8r");
                                if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(147843820, i19, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.android.kt:909)");
                                }
                                Modifier.Companion companion2 = Modifier.Companion;
                                ComposerKt.sourceInformationMarkerStart(composer3, -502962614, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changedInstance = composer3.changedInstance(animatable);
                                final Animatable<Float, AnimationVector1D> animatable2 = animatable;
                                Object rememberedValue4 = composer3.rememberedValue();
                                if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                                    rememberedValue4 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$wrappedContent$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                            invoke2(graphicsLayerScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                            graphicsLayerScope.setAlpha(animatable2.getValue().floatValue());
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) rememberedValue4);
                                SearchBarColors searchBarColors4 = obj8;
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer3, 0);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, graphicsLayer);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3520constructorimpl = Updater.m3520constructorimpl(composer3);
                                Updater.m3527setimpl(m3520constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                                ComposerKt.sourceInformationMarkerStart(composer3, 1608207601, "C910@40836L46,911@40903L9:SearchBar.android.kt#uh7d8r");
                                DividerKt.m1876HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors4.m2217getDividerColor0d7_KjU(), composer3, 0, 3);
                                function32.invoke(ColumnScopeInstance.INSTANCE, composer3, 6);
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
                        }, startRestartGroup, 54) : null;
                        startRestartGroup.endReplaceGroup();
                        Shape shape5 = shape2;
                        SearchBarColors searchBarColors4 = obj8;
                        float f8 = f4;
                        MutableState<BackEventCompat> mutableState3 = obj;
                        float f9 = f5;
                        WindowInsets windowInsets3 = obj10;
                        SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState3, modifier3, windowInsets3, function2, rememberComposableLambda, rememberComposableLambda2, startRestartGroup, Animatable.$stable | 12582912 | (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | ((i18 << 15) & 458752) | ((i12 << 3) & 3670016));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = startRestartGroup;
                        searchBarColors3 = searchBarColors4;
                        f6 = f9;
                        f7 = f8;
                        shape3 = shape5;
                        windowInsets2 = windowInsets3;
                        modifier2 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        f7 = f3;
                        searchBarColors3 = obj3;
                        windowInsets2 = obj4;
                        composer2 = startRestartGroup;
                        modifier2 = obj2;
                        shape3 = shape;
                        f6 = f;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$1
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

                            public final void invoke(Composer composer3, int i19) {
                                SearchBar_androidKt.m2231SearchBarImplj1jLAyQ(animatable, mutableFloatState, mutableState, mutableState2, modifier2, function2, shape3, searchBarColors3, f6, f7, windowInsets2, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                i8 = i7;
                f3 = f2;
                if ((i2 & 6) != 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                if ((306783379 & i4) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i16 == 0) {
                }
                if ((i3 & 64) == 0) {
                }
                int i172 = i4;
                if ((i3 & 128) == 0) {
                }
                if (i6 == 0) {
                }
                if (i8 == 0) {
                }
                if ((i3 & 1024) == 0) {
                }
                obj9 = obj6;
                startRestartGroup.endDefaults();
                Modifier modifier32 = obj9;
                if (ComposerKt.isTraceInProgress()) {
                }
                int i182 = i13;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Density density2 = (Density) consume2;
                inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                Shape fullScreenShape2 = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567245043, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                State state2 = (State) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                boolean SearchBarImpl_j1jLAyQ$lambda$92 = SearchBarImpl_j1jLAyQ$lambda$9(state2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567240190, "CC(remember):SearchBar.android.kt#9igjgp");
                changed = startRestartGroup.changed(SearchBarImpl_j1jLAyQ$lambda$92) | ((((3670016 & i12) ^ 1572864) <= 1048576 && startRestartGroup.changed(shape2)) || (i12 & 1572864) == 1048576);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                if (!Intrinsics.areEqual(shape2, inputFieldShape)) {
                }
                startRestartGroup.updateRememberedValue(genericShape);
                rememberedValue2 = genericShape;
                final Shape shape42 = (Shape) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposableLambda rememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-170534294, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$surface$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i19) {
                        ComposerKt.sourceInformation(composer3, "C896@40320L38,893@40194L309:SearchBar.android.kt#uh7d8r");
                        if ((i19 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-170534294, i19, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.android.kt:893)");
                            }
                            SurfaceKt.m2347SurfaceT9BRK9s(null, Shape.this, obj8.m2216getContainerColor0d7_KjU(), ColorSchemeKt.m1733contentColorForek8zF_U(obj8.m2216getContainerColor0d7_KjU(), composer3, 0), f5, f4, null, ComposableSingletons$SearchBar_androidKt.INSTANCE.m1782getLambda2$material3_release(), composer3, 12582912, 65);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, startRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567206741, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.startReplaceGroup(-1567201454);
                ComposerKt.sourceInformation(startRestartGroup, "908@40729L215");
                if (!SearchBarImpl_j1jLAyQ$lambda$12((State) rememberedValue3)) {
                }
                startRestartGroup.endReplaceGroup();
                Shape shape52 = shape2;
                SearchBarColors searchBarColors42 = obj8;
                float f82 = f4;
                MutableState<BackEventCompat> mutableState32 = obj;
                float f92 = f5;
                WindowInsets windowInsets32 = obj10;
                SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState32, modifier32, windowInsets32, function2, rememberComposableLambda3, rememberComposableLambda2, startRestartGroup, Animatable.$stable | 12582912 | (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | ((i182 << 15) & 458752) | ((i12 << 3) & 3670016));
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                searchBarColors3 = searchBarColors42;
                f6 = f92;
                f7 = f82;
                shape3 = shape52;
                windowInsets2 = windowInsets32;
                modifier2 = modifier32;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i5;
            i7 = i3 & 512;
            if (i7 != 0) {
            }
            i8 = i7;
            f3 = f2;
            if ((i2 & 6) != 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            if ((306783379 & i4) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i16 == 0) {
            }
            if ((i3 & 64) == 0) {
            }
            int i1722 = i4;
            if ((i3 & 128) == 0) {
            }
            if (i6 == 0) {
            }
            if (i8 == 0) {
            }
            if ((i3 & 1024) == 0) {
            }
            obj9 = obj6;
            startRestartGroup.endDefaults();
            Modifier modifier322 = obj9;
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1822 = i13;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density22 = (Density) consume22;
            inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
            Shape fullScreenShape22 = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567245043, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
            }
            State state22 = (State) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean SearchBarImpl_j1jLAyQ$lambda$922 = SearchBarImpl_j1jLAyQ$lambda$9(state22);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567240190, "CC(remember):SearchBar.android.kt#9igjgp");
            changed = startRestartGroup.changed(SearchBarImpl_j1jLAyQ$lambda$922) | ((((3670016 & i12) ^ 1572864) <= 1048576 && startRestartGroup.changed(shape2)) || (i12 & 1572864) == 1048576);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            if (!Intrinsics.areEqual(shape2, inputFieldShape)) {
            }
            startRestartGroup.updateRememberedValue(genericShape);
            rememberedValue2 = genericShape;
            final Shape shape422 = (Shape) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposableLambda rememberComposableLambda32 = ComposableLambdaKt.rememberComposableLambda(-170534294, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$surface$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i19) {
                    ComposerKt.sourceInformation(composer3, "C896@40320L38,893@40194L309:SearchBar.android.kt#uh7d8r");
                    if ((i19 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-170534294, i19, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.android.kt:893)");
                        }
                        SurfaceKt.m2347SurfaceT9BRK9s(null, Shape.this, obj8.m2216getContainerColor0d7_KjU(), ColorSchemeKt.m1733contentColorForek8zF_U(obj8.m2216getContainerColor0d7_KjU(), composer3, 0), f5, f4, null, ComposableSingletons$SearchBar_androidKt.INSTANCE.m1782getLambda2$material3_release(), composer3, 12582912, 65);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, startRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567206741, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-1567201454);
            ComposerKt.sourceInformation(startRestartGroup, "908@40729L215");
            if (!SearchBarImpl_j1jLAyQ$lambda$12((State) rememberedValue3)) {
            }
            startRestartGroup.endReplaceGroup();
            Shape shape522 = shape2;
            SearchBarColors searchBarColors422 = obj8;
            float f822 = f4;
            MutableState<BackEventCompat> mutableState322 = obj;
            float f922 = f5;
            WindowInsets windowInsets322 = obj10;
            SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState322, modifier322, windowInsets322, function2, rememberComposableLambda32, rememberComposableLambda2, startRestartGroup, Animatable.$stable | 12582912 | (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | ((i1822 << 15) & 458752) | ((i12 << 3) & 3670016));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            searchBarColors3 = searchBarColors422;
            f6 = f922;
            f7 = f822;
            shape3 = shape522;
            windowInsets2 = windowInsets322;
            modifier2 = modifier322;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = modifier;
        if ((i3 & 32) == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i5 = i3 & 256;
        if (i5 == 0) {
        }
        i6 = i5;
        i7 = i3 & 512;
        if (i7 != 0) {
        }
        i8 = i7;
        f3 = f2;
        if ((i2 & 6) != 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        if ((306783379 & i4) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i16 == 0) {
        }
        if ((i3 & 64) == 0) {
        }
        int i17222 = i4;
        if ((i3 & 128) == 0) {
        }
        if (i6 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i3 & 1024) == 0) {
        }
        obj9 = obj6;
        startRestartGroup.endDefaults();
        Modifier modifier3222 = obj9;
        if (ComposerKt.isTraceInProgress()) {
        }
        int i18222 = i13;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density222 = (Density) consume222;
        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
        Shape fullScreenShape222 = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567245043, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
        }
        State state222 = (State) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        boolean SearchBarImpl_j1jLAyQ$lambda$9222 = SearchBarImpl_j1jLAyQ$lambda$9(state222);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567240190, "CC(remember):SearchBar.android.kt#9igjgp");
        changed = startRestartGroup.changed(SearchBarImpl_j1jLAyQ$lambda$9222) | ((((3670016 & i12) ^ 1572864) <= 1048576 && startRestartGroup.changed(shape2)) || (i12 & 1572864) == 1048576);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        if (!Intrinsics.areEqual(shape2, inputFieldShape)) {
        }
        startRestartGroup.updateRememberedValue(genericShape);
        rememberedValue2 = genericShape;
        final Shape shape4222 = (Shape) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposableLambda rememberComposableLambda322 = ComposableLambdaKt.rememberComposableLambda(-170534294, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarImpl$surface$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i19) {
                ComposerKt.sourceInformation(composer3, "C896@40320L38,893@40194L309:SearchBar.android.kt#uh7d8r");
                if ((i19 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-170534294, i19, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.android.kt:893)");
                    }
                    SurfaceKt.m2347SurfaceT9BRK9s(null, Shape.this, obj8.m2216getContainerColor0d7_KjU(), ColorSchemeKt.m1733contentColorForek8zF_U(obj8.m2216getContainerColor0d7_KjU(), composer3, 0), f5, f4, null, ComposableSingletons$SearchBar_androidKt.INSTANCE.m1782getLambda2$material3_release(), composer3, 12582912, 65);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }, startRestartGroup, 54);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1567206741, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
        }
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.startReplaceGroup(-1567201454);
        ComposerKt.sourceInformation(startRestartGroup, "908@40729L215");
        if (!SearchBarImpl_j1jLAyQ$lambda$12((State) rememberedValue3)) {
        }
        startRestartGroup.endReplaceGroup();
        Shape shape5222 = shape2;
        SearchBarColors searchBarColors4222 = obj8;
        float f8222 = f4;
        MutableState<BackEventCompat> mutableState3222 = obj;
        float f9222 = f5;
        WindowInsets windowInsets3222 = obj10;
        SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState3222, modifier3222, windowInsets3222, function2, rememberComposableLambda322, rememberComposableLambda2, startRestartGroup, Animatable.$stable | 12582912 | (i12 & 14) | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | ((i18222 << 15) & 458752) | ((i12 << 3) & 3670016));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        searchBarColors3 = searchBarColors4222;
        f6 = f9222;
        f7 = f8222;
        shape3 = shape5222;
        windowInsets2 = windowInsets3222;
        modifier2 = modifier3222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SearchBarLayout(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState mutableFloatState, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, final Modifier modifier, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i) {
        int i2;
        final MutableFloatState mutableFloatState2;
        Object obj;
        Object obj2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(70029564);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBarLayout)P(!1,3,4,2,6,8,5,7)945@42029L34,950@42191L120,965@42827L5009,946@42068L5768:SearchBar.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(animatable) : startRestartGroup.changedInstance(animatable) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            mutableFloatState2 = mutableFloatState;
            i2 |= startRestartGroup.changed(mutableFloatState2) ? 32 : 16;
        } else {
            mutableFloatState2 = mutableFloatState;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = mutableState;
            i2 |= startRestartGroup.changed(obj) ? 256 : 128;
        } else {
            obj = mutableState;
        }
        if ((i & 3072) == 0) {
            obj2 = mutableState2;
            i2 |= startRestartGroup.changed(obj2) ? 2048 : 1024;
        } else {
            obj2 = mutableState2;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
        }
        if ((38347923 & i2) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70029564, i2, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.android.kt:941)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -660147884, "CC(remember):SearchBar.android.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MutableWindowInsets(null, 1, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier zIndex = ZIndexModifierKt.zIndex(modifier, 1.0f);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -660142614, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean z = (458752 & i2) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets2) {
                        invoke2(windowInsets2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(WindowInsets windowInsets2) {
                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier consumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex, (Function1) rememberedValue2), windowInsets);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -660117373, "CC(remember):SearchBar.android.kt#9igjgp");
            boolean z2 = ((i2 & 14) == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(animatable))) | ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 896) == 256);
            MeasurePolicy rememberedValue3 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                final MutableState<BackEventCompat> mutableState3 = obj;
                i3 = i2;
                final MutableState<BackEventCompat> mutableState4 = obj2;
                rememberedValue3 = new MeasurePolicy() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo42measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j) {
                        Measurable measurable;
                        final float calculatePredictiveBackMultiplier;
                        final Placeable placeable;
                        int i4;
                        int m6636getMaxHeightimpl;
                        MeasureScope measureScope2 = measureScope;
                        long j2 = j;
                        final float floatValue = animatable.getValue().floatValue();
                        int size = list.size();
                        int i5 = 0;
                        while (i5 < size) {
                            Measurable measurable2 = list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                                int size2 = list.size();
                                int i6 = 0;
                                while (i6 < size2) {
                                    Measurable measurable3 = list.get(i6);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Surface")) {
                                        int size3 = list.size();
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i7);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Content")) {
                                                break;
                                            }
                                            i7++;
                                        }
                                        Measurable measurable4 = measurable;
                                        final int top = mutableWindowInsets.getTop(measureScope2) + measureScope2.mo383roundToPx0680j_4(SearchBar_androidKt.getSearchBarVerticalPadding());
                                        int i8 = measureScope2.mo383roundToPx0680j_4(SearchBar_androidKt.getSearchBarVerticalPadding());
                                        int m6654constrainWidthK40F9xA = ConstraintsKt.m6654constrainWidthK40F9xA(j2, measurable2.maxIntrinsicWidth(Constraints.m6636getMaxHeightimpl(j2)));
                                        int m6653constrainHeightK40F9xA = ConstraintsKt.m6653constrainHeightK40F9xA(j2, measurable2.minIntrinsicHeight(Constraints.m6637getMaxWidthimpl(j2)));
                                        int roundToInt = MathKt.roundToInt(Constraints.m6637getMaxWidthimpl(j2) * 0.9f);
                                        int roundToInt2 = MathKt.roundToInt(Constraints.m6636getMaxHeightimpl(j2) * 0.9f);
                                        calculatePredictiveBackMultiplier = SearchBar_androidKt.calculatePredictiveBackMultiplier(mutableState4.getValue(), floatValue, mutableFloatState2.getFloatValue());
                                        int lerp = MathHelpersKt.lerp(m6654constrainWidthK40F9xA, roundToInt, calculatePredictiveBackMultiplier);
                                        int i9 = top + m6653constrainHeightK40F9xA;
                                        int lerp2 = MathHelpersKt.lerp(i9, roundToInt2, calculatePredictiveBackMultiplier);
                                        int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j2);
                                        int m6636getMaxHeightimpl2 = Constraints.m6636getMaxHeightimpl(j2);
                                        int lerp3 = MathHelpersKt.lerp(lerp, m6637getMaxWidthimpl, floatValue);
                                        final int lerp4 = MathHelpersKt.lerp(lerp2, m6636getMaxHeightimpl2, floatValue);
                                        final int lerp5 = MathHelpersKt.lerp(top, 0, floatValue);
                                        final int lerp6 = MathHelpersKt.lerp(0, i8, floatValue);
                                        final Placeable mo5438measureBRTryo0 = measurable2.mo5438measureBRTryo0(ConstraintsKt.Constraints(lerp3, m6637getMaxWidthimpl, m6653constrainHeightK40F9xA, m6653constrainHeightK40F9xA));
                                        int width = mo5438measureBRTryo0.getWidth();
                                        final Placeable mo5438measureBRTryo02 = measurable3.mo5438measureBRTryo0(Constraints.Companion.m6647fixedJhjzzOo(width, lerp4 - lerp5));
                                        if (measurable4 != null) {
                                            if (Constraints.m6632getHasBoundedHeightimpl(j)) {
                                                i4 = 0;
                                                m6636getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m6636getMaxHeightimpl(j) - (i9 + i8), 0);
                                            } else {
                                                i4 = 0;
                                                m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(j);
                                            }
                                            placeable = measurable4.mo5438measureBRTryo0(ConstraintsKt.Constraints(width, width, i4, m6636getMaxHeightimpl));
                                        } else {
                                            placeable = null;
                                        }
                                        final MutableState<BackEventCompat> mutableState5 = mutableState4;
                                        final MutableState<BackEventCompat> mutableState6 = mutableState3;
                                        return MeasureScope.layout$default(measureScope, width, lerp4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                invoke2(placementScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                float f;
                                                int m2234calculatePredictiveBackOffsetXrOvwMX4;
                                                float f2;
                                                int m2235calculatePredictiveBackOffsetYdzo92Q0;
                                                MeasureScope measureScope3 = MeasureScope.this;
                                                f = SearchBar_androidKt.SearchBarPredictiveBackMinMargin;
                                                int i10 = measureScope3.mo383roundToPx0680j_4(f);
                                                m2234calculatePredictiveBackOffsetXrOvwMX4 = SearchBar_androidKt.m2234calculatePredictiveBackOffsetXrOvwMX4(j, i10, mutableState5.getValue(), MeasureScope.this.getLayoutDirection(), floatValue, calculatePredictiveBackMultiplier);
                                                long j3 = j;
                                                BackEventCompat value = mutableState5.getValue();
                                                BackEventCompat value2 = mutableState6.getValue();
                                                int i11 = lerp4;
                                                MeasureScope measureScope4 = MeasureScope.this;
                                                f2 = SearchBar_androidKt.SearchBarPredictiveBackMaxOffsetY;
                                                m2235calculatePredictiveBackOffsetYdzo92Q0 = SearchBar_androidKt.m2235calculatePredictiveBackOffsetYdzo92Q0(j3, i10, value, value2, i11, measureScope4.mo383roundToPx0680j_4(f2), calculatePredictiveBackMultiplier);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo02, m2234calculatePredictiveBackOffsetXrOvwMX4, m2235calculatePredictiveBackOffsetYdzo92Q0 + lerp5, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo5438measureBRTryo0, m2234calculatePredictiveBackOffsetXrOvwMX4, m2235calculatePredictiveBackOffsetYdzo92Q0 + top, 0.0f, 4, null);
                                                Placeable placeable2 = placeable;
                                                if (placeable2 != null) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, m2234calculatePredictiveBackOffsetXrOvwMX4, m2235calculatePredictiveBackOffsetYdzo92Q0 + top + mo5438measureBRTryo0.getHeight() + lerp6, 0.0f, 4, null);
                                                }
                                            }
                                        }, 4, null);
                                    }
                                    i6++;
                                    measureScope2 = measureScope;
                                    j2 = j;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i5++;
                            measureScope2 = measureScope;
                            j2 = j;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            } else {
                i3 = i2;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, consumeWindowInsets);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m3527setimpl(m3520constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 36789781, "C955@42396L85,956@42494L119:SearchBar.android.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdSurface);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1442016074, "C955@42470L9:SearchBar.android.kt#uh7d8r");
            function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdInputField);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1442132231, "C957@42587L12:SearchBar.android.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 18) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.startReplaceGroup(-1107184481);
            ComposerKt.sourceInformation(startRestartGroup, "*960@42668L127");
            if (function23 != null) {
                Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdSearchContent);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3520constructorimpl4 = Updater.m3520constructorimpl(startRestartGroup);
                Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1302856683, "C961@42768L9:SearchBar.android.kt#uh7d8r");
                function23.invoke(startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarLayout$4
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

                public final void invoke(Composer composer2, int i4) {
                    SearchBar_androidKt.SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function2, function22, function23, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculatePredictiveBackMultiplier(BackEventCompat backEventCompat, float f, float f2) {
        if (backEventCompat == null) {
            return 0.0f;
        }
        if (Float.isNaN(f2)) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        return f / f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculatePredictiveBackOffsetX-rOvwMX4  reason: not valid java name */
    public static final int m2234calculatePredictiveBackOffsetXrOvwMX4(long j, int i, BackEventCompat backEventCompat, LayoutDirection layoutDirection, float f, float f2) {
        if (backEventCompat == null || f2 == 0.0f) {
            return 0;
        }
        return MathKt.roundToInt(((Constraints.m6637getMaxWidthimpl(j) * SearchBarPredictiveBackMaxOffsetXRatio) - i) * (1 - f) * f2 * (backEventCompat.getSwipeEdge() == 0 ? 1 : -1) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculatePredictiveBackOffsetY-dzo92Q0  reason: not valid java name */
    public static final int m2235calculatePredictiveBackOffsetYdzo92Q0(long j, int i, BackEventCompat backEventCompat, BackEventCompat backEventCompat2, int i2, int i3, float f) {
        if (backEventCompat2 == null || backEventCompat == null || f == 0.0f) {
            return 0;
        }
        int min = Math.min(Math.max(0, ((Constraints.m6636getMaxHeightimpl(j) - i2) / 2) - i), i3);
        float touchY = backEventCompat.getTouchY() - backEventCompat2.getTouchY();
        float abs = Math.abs(touchY) / Constraints.m6636getMaxHeightimpl(j);
        return MathKt.roundToInt(MathHelpersKt.lerp(0, min, abs) * f * Math.signum(touchY));
    }

    static {
        float f = 8;
        SearchBarVerticalPadding = Dp.m6684constructorimpl(f);
        SearchBarPredictiveBackMinMargin = Dp.m6684constructorimpl(f);
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tween = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tween;
        TweenSpec tween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tween2;
        AnimationPredictiveBackExitFloatSpec = AnimationSpecKt.tween$default(AnimationExitDurationMillis, 0, cubicBezierEasing, 2, null);
        TweenSpec tween3 = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tween3;
        TweenSpec tween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tween4, null, false, null, 14, null));
    }

    public static final float getDockedExpandedTableMinHeight() {
        return DockedExpandedTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$9(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$12(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
