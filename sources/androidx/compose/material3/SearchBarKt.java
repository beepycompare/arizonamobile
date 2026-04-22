package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.BasicEdgeToEdgeDialog_androidKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.PredictiveBack;
import androidx.compose.material3.internal.PredictiveBackState;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: SearchBar.kt */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001a\\\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001ar\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0099\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0013\b\u0002\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00140\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b!\u0010\"\u001a\u0084\u0001\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020$2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b*\u0010+\u001a\u008e\u0001\u0010,\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\b-\u0010.\u001a7\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u0002012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u000204032\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0007¢\u0006\u0002\u00106\u001a\u0090\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010;\u001a\u00020(2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020(2\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bC\u0010D\u001a\u0086\u0002\u0010,\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u001e2\u0006\u0010;\u001a\u00020(2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010=\u001a\u00020(2\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010?\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0007¢\u0006\u0004\bE\u0010F\u001aÄ\u0001\u0010K\u001a\u00020\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0001¢\u0006\u0004\bV\u0010W\u001a \u0001\u0010X\u001a\u00020\u00012\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020N0M2\u0006\u0010O\u001a\u00020P2\u0014\u0010Q\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0014\u0010U\u001a\u0010\u0012\f\u0012\n\u0018\u00010Sj\u0004\u0018\u0001`T0R2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010Y\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010Z\u001ap\u0010[\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\b\\\u0010]\u001a\u0080\u0001\u0010^\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010_\u001a\u00020`2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u0006¢\u0006\u0002\b H\u0003¢\u0006\u0004\ba\u0010b\u001a\u000e\u0010c\u001a\u000204*\u0004\u0018\u00010dH\u0002\u001a#\u0010j\u001a\u00020\u00012\u0006\u0010A\u001a\u00020k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010m\u001a-\u0010n\u001a\u0002042\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010o\u001a\u0002042\u0006\u0010O\u001a\u000204H\u0002¢\u0006\u0002\u0010p\u001aG\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020r2\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010v\u001a\u00020w2\u0006\u0010o\u001a\u0002042\u0006\u0010x\u001a\u000204H\u0002¢\u0006\u0004\by\u0010z\u001aW\u0010{\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020r2\u000e\u0010U\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u000e\u0010Q\u001a\n\u0018\u00010Sj\u0004\u0018\u0001`T2\u0006\u0010|\u001a\u00020r2\u0006\u0010}\u001a\u00020r2\u0006\u0010x\u001a\u000204H\u0002¢\u0006\u0004\b~\u0010\u007f\"\u001e\u0010G\u001a\u00020(*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bH\u0010I\u001a\u0004\bG\u0010J\"\u001e\u0010e\u001a\u00020f*\u00020\u00038BX\u0082\u0004¢\u0006\f\u0012\u0004\bg\u0010I\u001a\u0004\bh\u0010i\"\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000f\u0010\u0082\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0083\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0084\u0001\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0085\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u001a\u0010\u0089\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u001a\u0010\u008c\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u008d\u0001\u0010\u0087\u0001\"\u000f\u0010\u008e\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u008f\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0090\u0001\u0010\u0087\u0001\"\u0012\u0010\u0091\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u001a\u0010\u0092\u0001\u001a\u00020\u000eX\u0080\u0004¢\u0006\r\n\u0003\u0010\u0088\u0001\u001a\u0006\b\u0093\u0001\u0010\u0087\u0001\"\u0012\u0010\u0094\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0095\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0096\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0097\u0001\u001a\u000204X\u0082T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0098\u0001\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0088\u0001\"\u000f\u0010\u0099\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u009a\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u009b\u0001\u001a\u00020rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u009e\u0001\u001a\u00030\u009d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u0002040 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010£\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010 \u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010¨\u0001\u001a\u00030©\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ª\u0001²\u0006\u000b\u0010«\u0001\u001a\u00020(X\u008a\u0084\u0002²\u0006\u000b\u0010¬\u0001\u001a\u00020(X\u008a\u0084\u0002²\u0006\f\u0010\u00ad\u0001\u001a\u00030®\u0001X\u008a\u0084\u0002"}, d2 = {"SearchBar", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/material3/SearchBarState;", "inputField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", "SearchBar-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/runtime/Composer;II)V", "TopSearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "scrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "TopSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/SearchBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "ExpandedFullScreenSearchBar", "collapsedShape", "properties", "Landroidx/compose/ui/window/DialogProperties;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ExpandedFullScreenSearchBar-_UtchM0", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function2;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ExpandedDockedSearchBar", "Landroidx/compose/ui/window/PopupProperties;", "ExpandedDockedSearchBar-qKj4JfE", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "expanded", "", "onExpandedChange", "SearchBar-Y92LkZI", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DockedSearchBar", "DockedSearchBar-EQC0FA8", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberSearchBarState", "initialValue", "Landroidx/compose/material3/SearchBarValue;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpecForCollapse", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarState;", SearchIntents.EXTRA_QUERY, "", "onQueryChange", "onSearch", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "onActiveChange", "enabled", "placeholder", "leadingIcon", "trailingIcon", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "isExpanded", "isExpanded$annotations", "(Landroidx/compose/material3/SearchBarState;)V", "(Landroidx/compose/material3/SearchBarState;)Z", "SearchBarImpl", "animationProgress", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finalBackProgress", "Landroidx/compose/runtime/MutableFloatState;", "firstBackEvent", "Landroidx/compose/runtime/MutableState;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;", "currentBackEvent", "SearchBarImpl-j1jLAyQ", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarLayout", "surface", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/MutableFloatState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DockedSearchBarLayout", "DockedSearchBarLayout-nbWgWpA", "(Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "FullScreenSearchBarLayout", "predictiveBackState", "Landroidx/compose/material3/internal/PredictiveBackState;", "FullScreenSearchBarLayout-EQC0FA8", "(Landroidx/compose/material3/SearchBarState;Landroidx/compose/material3/internal/PredictiveBackState;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "transform", "Landroidx/compose/material3/internal/BackEventProgress$InProgress;", "collapsedBounds", "Landroidx/compose/ui/unit/IntRect;", "getCollapsedBounds$annotations", "getCollapsedBounds", "(Landroidx/compose/material3/SearchBarState;)Landroidx/compose/ui/unit/IntRect;", "DetectClickFromInteractionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "onClick", "(Landroidx/compose/foundation/interaction/InteractionSource;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculatePredictiveBackMultiplier", "progress", "(Landroidx/activity/BackEventCompat;FF)F", "calculatePredictiveBackOffsetX", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "minMargin", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "predictiveBackMultiplier", "calculatePredictiveBackOffsetX-rOvwMX4", "(JILandroidx/activity/BackEventCompat;Landroidx/compose/ui/unit/LayoutDirection;FF)I", "calculatePredictiveBackOffsetY", "height", "maxOffsetY", "calculatePredictiveBackOffsetY-dzo92Q0", "(JILandroidx/activity/BackEventCompat;Landroidx/activity/BackEventCompat;IIF)I", "UnspecifiedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "LayoutIdInputField", "LayoutIdSurface", "LayoutIdSearchContent", "SearchBarAsTopBarPadding", "getSearchBarAsTopBarPadding", "()F", "F", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "DockedExpandedTableMinHeight", "getDockedExpandedTableMinHeight", "DockedExpandedTableMaxHeightScreenRatio", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarMaxWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "SearchBarIconOffsetX", "SearchBarPredictiveBackMinScale", "SearchBarPredictiveBackMinMargin", "SearchBarPredictiveBackMaxOffsetXRatio", "SearchBarPredictiveBackMaxOffsetY", "AnimationEnterDurationMillis", "AnimationExitDurationMillis", "AnimationDelayMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationExitEasing", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "AnimationExitFloatSpec", "AnimationPredictiveBackExitFloatSpec", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitSizeSpec", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "material3", "useFullScreenShape", "showContent", "backEvent", "Landroidx/compose/material3/internal/BackEventProgress;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBarKt {
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
    private static final float SearchBarPredictiveBackMinScale = 0.9f;
    private static final TextFieldColors UnspecifiedTextFieldColors = new TextFieldColors(Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), new TextSelectionColors(Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), null), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4808getUnspecified0d7_KjU(), null);
    private static final float SearchBarAsTopBarPadding = Dp.m7555constructorimpl(8.0f);
    private static final float SearchBarCornerRadius = Dp.m7555constructorimpl(SearchBarDefaults.INSTANCE.m2414getInputFieldHeightD9Ej5fM() / 2.0f);
    private static final float DockedExpandedTableMinHeight = Dp.m7555constructorimpl(240.0f);
    private static final float SearchBarMinWidth = Dp.m7555constructorimpl(360.0f);
    private static final float SearchBarMaxWidth = Dp.m7555constructorimpl(720.0f);
    private static final float SearchBarVerticalPadding = Dp.m7555constructorimpl(8.0f);
    private static final float SearchBarIconOffsetX = Dp.m7555constructorimpl(4.0f);
    private static final float SearchBarPredictiveBackMinMargin = Dp.m7555constructorimpl(8.0f);
    private static final float SearchBarPredictiveBackMaxOffsetY = Dp.m7555constructorimpl(24.0f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DetectClickFromInteractionSource$lambda$73(InteractionSource interactionSource, Function0 function0, int i, Composer composer, int i2) {
        DetectClickFromInteractionSource(interactionSource, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DockedSearchBarLayout_nbWgWpA$lambda$52(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function3 function3, int i, Composer composer, int i2) {
        m2423DockedSearchBarLayoutnbWgWpA(searchBarState, function2, modifier, shape, searchBarColors, f, f2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DockedSearchBar_EQC0FA8$lambda$25(Function2 function2, boolean z, Function1 function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2421DockedSearchBarEQC0FA8(function2, z, function1, modifier, shape, searchBarColors, f, f2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DockedSearchBar_eWTbjVg$lambda$29(String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m2422DockedSearchBareWTbjVg(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, shape, searchBarColors, f, f2, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$10(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2424ExpandedDockedSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f, f2, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$14(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, PopupProperties popupProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2424ExpandedDockedSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f, f2, popupProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$6(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function2 function22, DialogProperties dialogProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2425ExpandedFullScreenSearchBar_UtchM0(searchBarState, function2, modifier, shape, searchBarColors, f, f2, function22, dialogProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$9(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function2 function22, DialogProperties dialogProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2425ExpandedFullScreenSearchBar_UtchM0(searchBarState, function2, modifier, shape, searchBarColors, f, f2, function22, dialogProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$70(SearchBarState searchBarState, PredictiveBackState predictiveBackState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, Function3 function3, int i, Composer composer, int i2) {
        m2426FullScreenSearchBarLayoutEQC0FA8(searchBarState, predictiveBackState, function2, modifier, shape, searchBarColors, f, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SearchBarImpl_j1jLAyQ$lambda$39(Animatable animatable, MutableFloatState mutableFloatState, MutableState mutableState, MutableState mutableState2, Modifier modifier, Function2 function2, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m2430SearchBarImplj1jLAyQ(animatable, mutableFloatState, mutableState, mutableState2, modifier, function2, shape, searchBarColors, f, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SearchBarLayout$lambda$49(Animatable animatable, MutableFloatState mutableFloatState, MutableState mutableState, MutableState mutableState2, Modifier modifier, WindowInsets windowInsets, Function2 function2, Function2 function22, Function2 function23, int i, Composer composer, int i2) {
        SearchBarLayout(animatable, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function2, function22, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SearchBar_WuY5d9Q$lambda$28(String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        m2427SearchBarWuY5d9Q(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, shape, searchBarColors, f, f2, windowInsets, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SearchBar_Y92LkZI$lambda$22(Function2 function2, boolean z, Function1 function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2428SearchBarY92LkZI(function2, z, function1, modifier, shape, searchBarColors, f, f2, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SearchBar_nbWgWpA$lambda$2(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, int i, int i2, Composer composer, int i3) {
        m2429SearchBarnbWgWpA(searchBarState, function2, modifier, shape, searchBarColors, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopSearchBar_qKj4JfE$lambda$5(SearchBarState searchBarState, Function2 function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, SearchBarScrollBehavior searchBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m2431TopSearchBarqKj4JfE(searchBarState, function2, modifier, shape, searchBarColors, f, f2, windowInsets, searchBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void getCollapsedBounds$annotations(SearchBarState searchBarState) {
    }

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    private static /* synthetic */ void isExpanded$annotations(SearchBarState searchBarState) {
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e8  */
    /* renamed from: SearchBar-nbWgWpA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2429SearchBarnbWgWpA(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Modifier.Companion companion;
        Object obj2;
        SearchBarColors searchBarColors2;
        int i5;
        float f3;
        int i6;
        float f4;
        final Modifier modifier2;
        final Shape shape2;
        final SearchBarColors searchBarColors3;
        final float f5;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        SearchBarColors searchBarColors4;
        Shape shape3;
        float f7;
        float f8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1234122643);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp)234@11650L30,237@11767L38,233@11592L334:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = function2;
            i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                companion = modifier;
                i3 |= startRestartGroup.changed(companion) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        obj2 = shape;
                        if (startRestartGroup.changed(obj2)) {
                            i10 = 2048;
                            i3 |= i10;
                        }
                    } else {
                        obj2 = shape;
                    }
                    i10 = 1024;
                    i3 |= i10;
                } else {
                    obj2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        searchBarColors2 = searchBarColors;
                        if (startRestartGroup.changed(searchBarColors2)) {
                            i9 = 16384;
                            i3 |= i9;
                        }
                    } else {
                        searchBarColors2 = searchBarColors;
                    }
                    i9 = 8192;
                    i3 |= i9;
                } else {
                    searchBarColors2 = searchBarColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f3 = f;
                    i3 |= startRestartGroup.changed(f3) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        f4 = f2;
                        i3 |= startRestartGroup.changed(f4) ? 1048576 : 524288;
                        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "228@11389L15,229@11454L8");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                SearchBarColors searchBarColors5 = searchBarColors2;
                                i8 = i3;
                                searchBarColors4 = searchBarColors5;
                                float f9 = f3;
                                shape3 = obj2;
                                f7 = f9;
                                f8 = f4;
                                i7 = 0;
                            } else {
                                if (i4 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    obj2 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                }
                                if ((i2 & 16) != 0) {
                                    i7 = 0;
                                    searchBarColors2 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                                    i3 &= -57345;
                                } else {
                                    i7 = 0;
                                }
                                float m2416getTonalElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM() : f;
                                if (i6 != 0) {
                                    SearchBarColors searchBarColors6 = searchBarColors2;
                                    i8 = i3;
                                    searchBarColors4 = searchBarColors6;
                                    float f10 = m2416getTonalElevationD9Ej5fM;
                                    shape3 = obj2;
                                    f7 = f10;
                                    f8 = SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM();
                                } else {
                                    SearchBarColors searchBarColors7 = searchBarColors2;
                                    i8 = i3;
                                    searchBarColors4 = searchBarColors7;
                                    float f11 = m2416getTonalElevationD9Ej5fM;
                                    shape3 = obj2;
                                    f7 = f11;
                                    f8 = f2;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1234122643, i8, -1, "androidx.compose.material3.SearchBar (SearchBar.kt:232)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 580903377, "CC(remember):SearchBar.kt#9igjgp");
                            int i11 = (i8 & 14) == 4 ? 1 : i7;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (i11 != 0 || rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = new Function1() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj3) {
                                        return SearchBarKt.SearchBar_nbWgWpA$lambda$1$lambda$0(SearchBarState.this, (LayoutCoordinates) obj3);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue);
                            long m2408getContainerColor0d7_KjU = searchBarColors4.m2408getContainerColor0d7_KjU();
                            long m1902contentColorForek8zF_U = ColorSchemeKt.m1902contentColorForek8zF_U(searchBarColors4.m2408getContainerColor0d7_KjU(), startRestartGroup, i7);
                            int i12 = i8 >> 3;
                            float f12 = f7;
                            SurfaceKt.m2569SurfaceT9BRK9s(onGloballyPositioned, shape3, m2408getContainerColor0d7_KjU, m1902contentColorForek8zF_U, f12, f8, null, obj, startRestartGroup, ((i8 >> 6) & 112) | (i12 & 57344) | (i12 & 458752) | ((i8 << 18) & 29360128), 64);
                            startRestartGroup = startRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            searchBarColors3 = searchBarColors4;
                            modifier2 = companion;
                            shape2 = shape3;
                            f6 = f8;
                            f5 = f12;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = companion;
                            shape2 = obj2;
                            searchBarColors3 = searchBarColors2;
                            f5 = f;
                            f6 = f2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return SearchBarKt.SearchBar_nbWgWpA$lambda$2(SearchBarState.this, function2, modifier2, shape2, searchBarColors3, f5, f6, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    f4 = f2;
                    if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f3 = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                f4 = f2;
                if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            companion = modifier;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f3 = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            f4 = f2;
            if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = function2;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        companion = modifier;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f3 = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        f4 = f2;
        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SearchBar_nbWgWpA$lambda$1$lambda$0(SearchBarState searchBarState, LayoutCoordinates layoutCoordinates) {
        searchBarState.setCollapsedCoords(layoutCoordinates);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* renamed from: TopSearchBar-qKj4JfE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2431TopSearchBarqKj4JfE(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, SearchBarScrollBehavior searchBarScrollBehavior, Composer composer, final int i, final int i2) {
        SearchBarState searchBarState2;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function22;
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        int i4;
        float f3;
        int i5;
        float f4;
        final WindowInsets windowInsets2;
        int i6;
        final Modifier modifier2;
        final SearchBarScrollBehavior searchBarScrollBehavior2;
        Composer composer2;
        final float f5;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        int i7;
        int i8;
        WindowInsets windowInsets3;
        float f7;
        SearchBarColors searchBarColors3;
        float f8;
        Shape shape3;
        int i9;
        boolean z;
        int i10;
        Modifier modifier4;
        SearchBarScrollBehavior searchBarScrollBehavior3;
        Modifier.Companion companion;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(782822734);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopSearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,scrollBehavior)293@14798L586:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            searchBarState2 = searchBarState;
        } else {
            searchBarState2 = searchBarState;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(searchBarState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            function22 = function2;
        } else {
            function22 = function2;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
            }
        }
        int i14 = i2 & 4;
        if (i14 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 256 : 128;
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (startRestartGroup.changed(shape2)) {
                        i13 = 2048;
                        i3 |= i13;
                    }
                } else {
                    shape2 = shape;
                }
                i13 = 1024;
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    searchBarColors2 = searchBarColors;
                    if (startRestartGroup.changed(searchBarColors2)) {
                        i12 = 16384;
                        i3 |= i12;
                    }
                } else {
                    searchBarColors2 = searchBarColors;
                }
                i12 = 8192;
                i3 |= i12;
            } else {
                searchBarColors2 = searchBarColors;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f3 = f;
            } else {
                f3 = f;
                if ((196608 & i) == 0) {
                    i3 |= startRestartGroup.changed(f3) ? 131072 : 65536;
                }
            }
            i5 = i2 & 64;
            if (i5 == 0) {
                i3 |= 1572864;
            } else if ((1572864 & i) == 0) {
                f4 = f2;
                i3 |= startRestartGroup.changed(f4) ? 1048576 : 524288;
                if ((12582912 & i) == 0) {
                    if ((i2 & 128) == 0) {
                        windowInsets2 = windowInsets;
                        if (startRestartGroup.changed(windowInsets2)) {
                            i11 = 8388608;
                            i3 |= i11;
                        }
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i11 = 4194304;
                    i3 |= i11;
                } else {
                    windowInsets2 = windowInsets;
                }
                i6 = i2 & 256;
                if (i6 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= startRestartGroup.changed(searchBarScrollBehavior) ? 67108864 : 33554432;
                }
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "286@14477L15,287@14542L8,290@14723L12");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 128) != 0) {
                            i3 &= -29360129;
                        }
                        modifier4 = modifier;
                        i9 = i3;
                        searchBarColors3 = searchBarColors2;
                        f7 = f4;
                        f8 = f3;
                        z = false;
                        searchBarScrollBehavior3 = searchBarScrollBehavior;
                        shape3 = shape2;
                        i10 = 782822734;
                    } else {
                        Modifier.Companion companion2 = i14 != 0 ? Modifier.Companion : modifier;
                        if ((i2 & 8) != 0) {
                            shape2 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                            i3 &= -7169;
                        }
                        int i15 = i3;
                        Shape shape4 = shape2;
                        if ((i2 & 16) != 0) {
                            i8 = i6;
                            modifier3 = companion2;
                            i7 = 6;
                            i15 &= -57345;
                            searchBarColors2 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                        } else {
                            modifier3 = companion2;
                            i7 = 6;
                            i8 = i6;
                        }
                        if (i4 != 0) {
                            f3 = SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM();
                        }
                        float m2415getShadowElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM() : f2;
                        if ((i2 & 128) != 0) {
                            windowInsets3 = SearchBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, i7);
                            i15 &= -29360129;
                        } else {
                            windowInsets3 = windowInsets;
                        }
                        windowInsets2 = windowInsets3;
                        f7 = m2415getShadowElevationD9Ej5fM;
                        searchBarColors3 = searchBarColors2;
                        f8 = f3;
                        shape3 = shape4;
                        i9 = i15;
                        if (i8 != 0) {
                            searchBarScrollBehavior3 = null;
                            z = false;
                            i10 = 782822734;
                            modifier4 = modifier3;
                        } else {
                            z = false;
                            i10 = 782822734;
                            modifier4 = modifier3;
                            searchBarScrollBehavior3 = searchBarScrollBehavior;
                        }
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i10, i9, -1, "androidx.compose.material3.TopSearchBar (SearchBar.kt:292)");
                    }
                    if (searchBarScrollBehavior3 == null || (companion = searchBarScrollBehavior3.searchBarScrollBehavior(Modifier.Companion)) == null) {
                        companion = Modifier.Companion;
                    }
                    m2429SearchBarnbWgWpA(searchBarState2, function22, SizeKt.wrapContentWidth$default(SizeKt.fillMaxWidth$default(PaddingKt.m818padding3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(modifier4.then(companion), windowInsets2), SearchBarAsTopBarPadding), 0.0f, 1, null), null, z, 3, null), shape3, searchBarColors3, f8, f7, startRestartGroup, i9 & 4193406, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier4;
                    searchBarScrollBehavior2 = searchBarScrollBehavior3;
                    composer2 = startRestartGroup;
                    shape2 = shape3;
                    searchBarColors2 = searchBarColors3;
                    f5 = f8;
                    f6 = f7;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    searchBarScrollBehavior2 = searchBarScrollBehavior;
                    composer2 = startRestartGroup;
                    f5 = f3;
                    f6 = f2;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchBarKt.TopSearchBar_qKj4JfE$lambda$5(SearchBarState.this, function2, modifier2, shape2, searchBarColors2, f5, f6, windowInsets2, searchBarScrollBehavior2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            f4 = f2;
            if ((12582912 & i) == 0) {
            }
            i6 = i2 & 256;
            if (i6 != 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        i5 = i2 & 64;
        if (i5 == 0) {
        }
        f4 = f2;
        if ((12582912 & i) == 0) {
        }
        i6 = i2 & 256;
        if (i6 != 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fa  */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* renamed from: ExpandedFullScreenSearchBar-_UtchM0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2425ExpandedFullScreenSearchBar_UtchM0(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, Function2<? super Composer, ? super Integer, ? extends WindowInsets> function22, DialogProperties dialogProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int i4;
        float f3;
        int i5;
        float f4;
        Object obj5;
        int i6;
        final float f5;
        final DialogProperties dialogProperties2;
        final Modifier modifier2;
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        Composer composer2;
        final float f6;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function23;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape3;
        boolean z;
        Composer composer3;
        SearchBarKt$ExpandedFullScreenSearchBar$1 searchBarKt$ExpandedFullScreenSearchBar$1;
        final DialogProperties dialogProperties3;
        final float f7;
        final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function25;
        final SearchBarColors searchBarColors3;
        final Shape shape4;
        int i7;
        final Modifier modifier3;
        final float f8;
        Object obj6;
        int i8;
        Object obj7;
        Object obj8;
        int i9;
        Object obj9;
        Object obj10;
        int i10;
        Object obj11;
        Composer startRestartGroup = composer.startRestartGroup(-909632031);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpandedFullScreenSearchBar)N(state,inputField,modifier,collapsedShape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,properties,content)356@17952L24,359@18032L56,361@18129L1354,358@17982L1501:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            obj = function2;
        } else {
            Object obj12 = function2;
            obj = obj12;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(obj12) ? 32 : 16;
                obj = obj12;
            }
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    obj10 = shape;
                    if (startRestartGroup.changed(obj10)) {
                        i10 = 2048;
                        obj11 = obj10;
                        i3 |= i10;
                        obj3 = obj11;
                    }
                } else {
                    obj10 = shape;
                }
                i10 = 1024;
                obj11 = obj10;
                i3 |= i10;
                obj3 = obj11;
            } else {
                obj3 = shape;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    obj8 = searchBarColors;
                    if (startRestartGroup.changed(obj8)) {
                        i9 = 16384;
                        obj9 = obj8;
                        i3 |= i9;
                        obj4 = obj9;
                    }
                } else {
                    obj8 = searchBarColors;
                }
                i9 = 8192;
                obj9 = obj8;
                i3 |= i9;
                obj4 = obj9;
            } else {
                obj4 = searchBarColors;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                f3 = f;
                i3 |= startRestartGroup.changed(f3) ? 131072 : 65536;
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    f4 = f2;
                    i3 |= startRestartGroup.changed(f4) ? 1048576 : 524288;
                    if ((12582912 & i) != 0) {
                        if ((i2 & 128) == 0) {
                            obj6 = function22;
                            if (startRestartGroup.changedInstance(obj6)) {
                                i8 = 8388608;
                                obj7 = obj6;
                                i3 |= i8;
                                obj5 = obj7;
                            }
                        } else {
                            obj6 = function22;
                        }
                        i8 = 4194304;
                        obj7 = obj6;
                        i3 |= i8;
                        obj5 = obj7;
                    } else {
                        obj5 = function22;
                    }
                    i6 = i2 & 256;
                    if (i6 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changed(dialogProperties) ? 67108864 : 33554432;
                    }
                    if ((i2 & 512) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "346@17492L15,347@17557L8");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                i7 = i3;
                                z = true;
                                modifier3 = obj2;
                                shape4 = obj3;
                                searchBarColors3 = obj4;
                                f8 = f3;
                                function25 = obj5;
                                composer3 = startRestartGroup;
                                f7 = f4;
                                dialogProperties3 = dialogProperties;
                            } else {
                                Modifier.Companion companion = i11 != 0 ? Modifier.Companion : obj2;
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape3 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                } else {
                                    shape3 = obj3;
                                }
                                int i12 = i3;
                                if ((i2 & 16) != 0) {
                                    z = true;
                                    composer3 = startRestartGroup;
                                    i12 &= -57345;
                                    obj4 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                                } else {
                                    z = true;
                                    composer3 = startRestartGroup;
                                }
                                float m2416getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM() : f;
                                float m2415getShadowElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM() : f2;
                                if ((i2 & 128) != 0) {
                                    searchBarKt$ExpandedFullScreenSearchBar$1 = new Function2<Composer, Integer, WindowInsets>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedFullScreenSearchBar$1
                                        public final WindowInsets invoke(Composer composer4, int i13) {
                                            composer4.startReplaceGroup(-2028768625);
                                            ComposerKt.sourceInformation(composer4, "C350@17758L22:SearchBar.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2028768625, i13, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar.<anonymous> (SearchBar.kt:350)");
                                            }
                                            WindowInsets fullScreenWindowInsets = SearchBarDefaults.INSTANCE.getFullScreenWindowInsets(composer4, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            composer4.endReplaceGroup();
                                            return fullScreenWindowInsets;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ WindowInsets invoke(Composer composer4, Integer num) {
                                            return invoke(composer4, num.intValue());
                                        }
                                    };
                                    i12 &= -29360129;
                                } else {
                                    searchBarKt$ExpandedFullScreenSearchBar$1 = function22;
                                }
                                dialogProperties3 = i6 != 0 ? new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null) : dialogProperties;
                                f7 = m2415getShadowElevationD9Ej5fM;
                                function25 = searchBarKt$ExpandedFullScreenSearchBar$1;
                                searchBarColors3 = obj4;
                                shape4 = shape3;
                                i7 = i12;
                                modifier3 = companion;
                                f8 = m2416getTonalElevationD9Ej5fM;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-909632031, i7, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar (SearchBar.kt:353)");
                            }
                            if (!isExpanded(searchBarState)) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                endRestartGroup = composer3.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = obj;
                                    function24 = new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj13, Object obj14) {
                                            return SearchBarKt.ExpandedFullScreenSearchBar__UtchM0$lambda$6(SearchBarState.this, function26, modifier3, shape4, searchBarColors3, f8, f7, function25, dialogProperties3, function3, i, i2, (Composer) obj13, ((Integer) obj14).intValue());
                                        }
                                    };
                                    endRestartGroup.updateScope(function24);
                                    return;
                                }
                                return;
                            }
                            DialogProperties dialogProperties4 = dialogProperties3;
                            ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                            Object rememberedValue = composer3.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                                composer3.updateRememberedValue(rememberedValue);
                            }
                            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerStart(composer3, 2016970937, "CC(remember):SearchBar.kt#9igjgp");
                            boolean changedInstance = composer3.changedInstance(coroutineScope) | ((i7 & 14) == 4 ? z : false);
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return SearchBarKt.ExpandedFullScreenSearchBar__UtchM0$lambda$8$lambda$7(CoroutineScope.this, searchBarState);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            final Modifier modifier4 = modifier3;
                            final Shape shape5 = shape4;
                            final SearchBarColors searchBarColors4 = searchBarColors3;
                            final float f9 = f8;
                            final float f10 = f7;
                            final Function2<? super Composer, ? super Integer, ? extends WindowInsets> function27 = function25;
                            Composer composer4 = composer3;
                            BasicEdgeToEdgeDialog_androidKt.BasicEdgeToEdgeDialog(rememberedValue2, null, dialogProperties4, false, false, ComposableLambdaKt.rememberComposableLambda(625093617, z, new Function3<PredictiveBackState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedFullScreenSearchBar$4
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(PredictiveBackState predictiveBackState, Composer composer5, Integer num) {
                                    invoke(predictiveBackState, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(PredictiveBackState predictiveBackState, Composer composer5, int i13) {
                                    int i14;
                                    ComposerKt.sourceInformation(composer5, "CN(predictiveBackState)362@18183L29,366@18355L231,379@18814L14,363@18221L649,385@19020L33,385@18999L54,389@19286L7,390@19336L141,390@19302L175:SearchBar.kt#uh7d8r");
                                    if ((i13 & 6) == 0) {
                                        i14 = i13 | ((i13 & 8) == 0 ? composer5.changed(predictiveBackState) : composer5.changedInstance(predictiveBackState) ? 4 : 2);
                                    } else {
                                        i14 = i13;
                                    }
                                    if (!composer5.shouldExecute((i14 & 19) != 18, i14 & 1)) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(625093617, i14, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar.<anonymous> (SearchBar.kt:362)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composer5, -580453746, "CC(remember):SearchBar.kt#9igjgp");
                                    Object rememberedValue3 = composer5.rememberedValue();
                                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                        rememberedValue3 = new FocusRequester();
                                        composer5.updateRememberedValue(rememberedValue3);
                                    }
                                    final FocusRequester focusRequester = (FocusRequester) rememberedValue3;
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    int i15 = i14;
                                    SearchBarState searchBarState2 = SearchBarState.this;
                                    final Function2<Composer, Integer, Unit> function28 = function2;
                                    SearchBarKt.m2426FullScreenSearchBarLayoutEQC0FA8(searchBarState2, predictiveBackState, ComposableLambdaKt.rememberComposableLambda(-2142632188, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedFullScreenSearchBar$4.1
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer6, int i16) {
                                            ComposerKt.sourceInformation(composer6, "C367@18373L199:SearchBar.kt#uh7d8r");
                                            if (!composer6.shouldExecute((i16 & 3) != 2, i16 & 1)) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2142632188, i16, -1, "androidx.compose.material3.ExpandedFullScreenSearchBar.<anonymous>.<anonymous> (SearchBar.kt:367)");
                                            }
                                            Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(Modifier.Companion, FocusRequester.this);
                                            Function2<Composer, Integer, Unit> function29 = function28;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                                            ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer6, focusRequester2);
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                            ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                            if (!(composer6.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer6.startReusableNode();
                                            if (composer6.getInserting()) {
                                                composer6.createNode(constructor);
                                            } else {
                                                composer6.useNode();
                                            }
                                            Composer m4041constructorimpl = Updater.m4041constructorimpl(composer6);
                                            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer6, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 1606432749, "C371@18542L12:SearchBar.kt#uh7d8r");
                                            function29.invoke(composer6, 0);
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
                                    }, composer5, 54), modifier4, shape5, searchBarColors4, f9, f10, function27.invoke(composer5, 0), function3, composer5, ((i15 << 3) & 112) | RendererCapabilities.DECODER_SUPPORT_MASK);
                                    Unit unit = Unit.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer5, -580426958, "CC(remember):SearchBar.kt#9igjgp");
                                    Object rememberedValue4 = composer5.rememberedValue();
                                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                        rememberedValue4 = (Function2) new SearchBarKt$ExpandedFullScreenSearchBar$4$2$1(focusRequester, null);
                                        composer5.updateRememberedValue(rememberedValue4);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue4, composer5, 6);
                                    ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume = composer5.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) consume;
                                    SearchBarValue targetValue = SearchBarState.this.getTargetValue();
                                    ComposerKt.sourceInformationMarkerStart(composer5, -580416738, "CC(remember):SearchBar.kt#9igjgp");
                                    boolean changed = composer5.changed(SearchBarState.this) | composer5.changed(softwareKeyboardController);
                                    SearchBarState searchBarState3 = SearchBarState.this;
                                    Object rememberedValue5 = composer5.rememberedValue();
                                    if (changed || rememberedValue5 == Composer.Companion.getEmpty()) {
                                        rememberedValue5 = (Function2) new SearchBarKt$ExpandedFullScreenSearchBar$4$3$1(searchBarState3, softwareKeyboardController, null);
                                        composer5.updateRememberedValue(rememberedValue5);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                    EffectsKt.LaunchedEffect(targetValue, (Function2) rememberedValue5, composer5, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer4, ((i7 >> 18) & 896) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            dialogProperties2 = dialogProperties4;
                            composer2 = composer4;
                            searchBarColors2 = searchBarColors4;
                            f6 = f9;
                            f5 = f10;
                            function23 = function27;
                            shape2 = shape5;
                            modifier2 = modifier4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            f5 = f2;
                            dialogProperties2 = dialogProperties;
                            modifier2 = obj2;
                            shape2 = obj3;
                            searchBarColors2 = obj4;
                            composer2 = startRestartGroup;
                            f6 = f;
                            function23 = function22;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            function24 = new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj13, Object obj14) {
                                    return SearchBarKt.ExpandedFullScreenSearchBar__UtchM0$lambda$9(SearchBarState.this, function2, modifier2, shape2, searchBarColors2, f6, f5, function23, dialogProperties2, function3, i, i2, (Composer) obj13, ((Integer) obj14).intValue());
                                }
                            };
                            endRestartGroup.updateScope(function24);
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f4 = f2;
                if ((12582912 & i) != 0) {
                }
                i6 = i2 & 256;
                if (i6 == 0) {
                }
                if ((i2 & 512) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f3 = f;
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            f4 = f2;
            if ((12582912 & i) != 0) {
            }
            i6 = i2 & 256;
            if (i6 == 0) {
            }
            if ((i2 & 512) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        f3 = f;
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        f4 = f2;
        if ((12582912 & i) != 0) {
        }
        i6 = i2 & 256;
        if (i6 == 0) {
        }
        if ((i2 & 512) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpandedFullScreenSearchBar__UtchM0$lambda$8$lambda$7(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$ExpandedFullScreenSearchBar$3$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f6  */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* renamed from: ExpandedDockedSearchBar-qKj4JfE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2424ExpandedDockedSearchBarqKj4JfE(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, PopupProperties popupProperties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        Object obj;
        Object obj2;
        int i4;
        float f3;
        int i5;
        int i6;
        Object obj3;
        Object obj4;
        final PopupProperties popupProperties2;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        final float f4;
        final float f5;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Composer composer3;
        boolean z;
        int i7;
        final SearchBarColors searchBarColors3;
        final PopupProperties popupProperties3;
        boolean z2;
        final Shape shape3;
        final float f6;
        int i8;
        final Modifier modifier3;
        final float f7;
        Object obj5;
        int i9;
        Object obj6;
        Object obj7;
        int i10;
        Object obj8;
        Composer startRestartGroup = composer.startRestartGroup(-1121062437);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExpandedDockedSearchBar)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,properties,content)439@21817L380,450@22215L24,454@22329L47,456@22417L1212,452@22245L1384:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 256 : 128;
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    obj7 = shape;
                    if (startRestartGroup.changed(obj7)) {
                        i10 = 2048;
                        obj8 = obj7;
                        i3 |= i10;
                        obj = obj8;
                    }
                } else {
                    obj7 = shape;
                }
                i10 = 1024;
                obj8 = obj7;
                i3 |= i10;
                obj = obj8;
            } else {
                obj = shape;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    obj5 = searchBarColors;
                    if (startRestartGroup.changed(obj5)) {
                        i9 = 16384;
                        obj6 = obj5;
                        i3 |= i9;
                        obj2 = obj6;
                    }
                } else {
                    obj5 = searchBarColors;
                }
                i9 = 8192;
                obj6 = obj5;
                i3 |= i9;
                obj2 = obj6;
            } else {
                obj2 = searchBarColors;
            }
            i4 = i2 & 32;
            if (i4 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i) == 0) {
                f3 = f;
                i3 |= startRestartGroup.changed(f3) ? 131072 : 65536;
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    i3 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((12582912 & i) == 0) {
                        obj3 = popupProperties;
                        i3 |= startRestartGroup.changed(obj3) ? 8388608 : 4194304;
                        if ((i2 & 256) != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            obj4 = function3;
                            i3 |= startRestartGroup.changedInstance(obj4) ? 67108864 : 33554432;
                            if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "429@21409L11,430@21470L8");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    SearchBarColors searchBarColors4 = obj2;
                                    i8 = i3;
                                    modifier3 = companion;
                                    f7 = f3;
                                    composer3 = startRestartGroup;
                                    searchBarColors3 = searchBarColors4;
                                    shape3 = obj;
                                    z2 = true;
                                    popupProperties3 = obj3;
                                    f6 = f2;
                                } else {
                                    if (i11 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        obj = SearchBarDefaults.INSTANCE.getDockedShape(startRestartGroup, 6);
                                    }
                                    if ((i2 & 16) != 0) {
                                        z = true;
                                        i7 = i6;
                                        searchBarColors3 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                                        composer3 = startRestartGroup;
                                        i3 = (-57345) & i3;
                                    } else {
                                        composer3 = startRestartGroup;
                                        z = true;
                                        i7 = i6;
                                        searchBarColors3 = obj2;
                                    }
                                    float m2416getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM() : f;
                                    float m2415getShadowElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM() : f2;
                                    if (i7 != 0) {
                                        z2 = z;
                                        shape3 = obj;
                                        f6 = m2415getShadowElevationD9Ej5fM;
                                        popupProperties3 = new PopupProperties(true, false, false, false, 6, (DefaultConstructorMarker) null);
                                    } else {
                                        popupProperties3 = popupProperties;
                                        z2 = z;
                                        shape3 = obj;
                                        f6 = m2415getShadowElevationD9Ej5fM;
                                    }
                                    i8 = i3;
                                    modifier3 = companion;
                                    f7 = m2416getTonalElevationD9Ej5fM;
                                }
                                composer3.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1121062437, i8, -1, "androidx.compose.material3.ExpandedDockedSearchBar (SearchBar.kt:435)");
                                }
                                if (isExpanded(searchBarState)) {
                                    PopupProperties popupProperties4 = popupProperties3;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 695809367, "CC(remember):SearchBar.kt#9igjgp");
                                    int i12 = i8 & 14;
                                    boolean z3 = i12 == 4 ? z2 : false;
                                    Object rememberedValue = composer3.rememberedValue();
                                    if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = new PopupPositionProvider() { // from class: androidx.compose.material3.SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1
                                            @Override // androidx.compose.ui.window.PopupPositionProvider
                                            /* renamed from: calculatePosition-llwVHH4 */
                                            public long mo373calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
                                                IntRect collapsedBounds;
                                                collapsedBounds = SearchBarKt.getCollapsedBounds(SearchBarState.this);
                                                return collapsedBounds.m7712getTopLeftnOccac();
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue);
                                    }
                                    SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1 searchBarKt$ExpandedDockedSearchBar$positionProvider$1$1 = (SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1) rememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    SearchBarKt$ExpandedDockedSearchBar$positionProvider$1$1 searchBarKt$ExpandedDockedSearchBar$positionProvider$1$12 = searchBarKt$ExpandedDockedSearchBar$positionProvider$1$1;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 695825418, "CC(remember):SearchBar.kt#9igjgp");
                                    boolean changedInstance = composer3.changedInstance(coroutineScope) | (i12 == 4 ? z2 : false);
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                                        rememberedValue3 = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda24
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return SearchBarKt.ExpandedDockedSearchBar_qKj4JfE$lambda$13$lambda$12(CoroutineScope.this, searchBarState);
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    final Shape shape4 = shape3;
                                    final SearchBarColors searchBarColors5 = searchBarColors3;
                                    final float f8 = f7;
                                    final float f9 = f6;
                                    Modifier modifier4 = modifier3;
                                    Composer composer4 = composer3;
                                    AndroidPopup_androidKt.Popup(searchBarKt$ExpandedDockedSearchBar$positionProvider$1$12, rememberedValue3, popupProperties4, ComposableLambdaKt.rememberComposableLambda(-363177991, z2, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedDockedSearchBar$3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i13) {
                                            ComposerKt.sourceInformation(composer5, "C457@22448L29,461@22562L231,459@22487L529,479@23166L33,479@23145L54,483@23432L7,484@23482L141,484@23448L175:SearchBar.kt#uh7d8r");
                                            if (!composer5.shouldExecute((i13 & 3) != 2, i13 & 1)) {
                                                composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-363177991, i13, -1, "androidx.compose.material3.ExpandedDockedSearchBar.<anonymous> (SearchBar.kt:457)");
                                            }
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1121697354, "CC(remember):SearchBar.kt#9igjgp");
                                            Object rememberedValue4 = composer5.rememberedValue();
                                            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                                                rememberedValue4 = new FocusRequester();
                                                composer5.updateRememberedValue(rememberedValue4);
                                            }
                                            final FocusRequester focusRequester = (FocusRequester) rememberedValue4;
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            SearchBarState searchBarState2 = SearchBarState.this;
                                            final Function2<Composer, Integer, Unit> function23 = function2;
                                            SearchBarKt.m2423DockedSearchBarLayoutnbWgWpA(searchBarState2, ComposableLambdaKt.rememberComposableLambda(2123999554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$ExpandedDockedSearchBar$3.1
                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                    invoke(composer6, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer6, int i14) {
                                                    ComposerKt.sourceInformation(composer6, "C462@22580L199:SearchBar.kt#uh7d8r");
                                                    if (!composer6.shouldExecute((i14 & 3) != 2, i14 & 1)) {
                                                        composer6.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2123999554, i14, -1, "androidx.compose.material3.ExpandedDockedSearchBar.<anonymous>.<anonymous> (SearchBar.kt:462)");
                                                    }
                                                    Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(Modifier.Companion, FocusRequester.this);
                                                    Function2<Composer, Integer, Unit> function24 = function23;
                                                    ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                                                    ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer6, focusRequester2);
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                                    if (!(composer6.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer6.startReusableNode();
                                                    if (composer6.getInserting()) {
                                                        composer6.createNode(constructor);
                                                    } else {
                                                        composer6.useNode();
                                                    }
                                                    Composer m4041constructorimpl = Updater.m4041constructorimpl(composer6);
                                                    Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer6, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer6, 1558467823, "C466@22749L12:SearchBar.kt#uh7d8r");
                                                    function24.invoke(composer6, 0);
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
                                            }, composer5, 54), modifier3, shape4, searchBarColors5, f8, f9, function3, composer5, 48);
                                            Unit unit = Unit.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1121674374, "CC(remember):SearchBar.kt#9igjgp");
                                            Object rememberedValue5 = composer5.rememberedValue();
                                            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                                                rememberedValue5 = (Function2) new SearchBarKt$ExpandedDockedSearchBar$3$2$1(focusRequester, null);
                                                composer5.updateRememberedValue(rememberedValue5);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            EffectsKt.LaunchedEffect(unit, (Function2) rememberedValue5, composer5, 6);
                                            ComposerKt.sourceInformationMarkerStart(composer5, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume = composer5.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) consume;
                                            SearchBarValue targetValue = SearchBarState.this.getTargetValue();
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1121664154, "CC(remember):SearchBar.kt#9igjgp");
                                            boolean changed = composer5.changed(SearchBarState.this) | composer5.changed(softwareKeyboardController);
                                            SearchBarState searchBarState3 = SearchBarState.this;
                                            Object rememberedValue6 = composer5.rememberedValue();
                                            if (changed || rememberedValue6 == Composer.Companion.getEmpty()) {
                                                rememberedValue6 = (Function2) new SearchBarKt$ExpandedDockedSearchBar$3$3$1(searchBarState3, softwareKeyboardController, null);
                                                composer5.updateRememberedValue(rememberedValue6);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            EffectsKt.LaunchedEffect(targetValue, (Function2) rememberedValue6, composer5, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), composer4, ((i8 >> 15) & 896) | 3072, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier4;
                                    composer2 = composer4;
                                    shape2 = shape4;
                                    searchBarColors2 = searchBarColors5;
                                    popupProperties2 = popupProperties4;
                                    f4 = f8;
                                    f5 = f9;
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    endRestartGroup = composer3.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = obj4;
                                        final Modifier modifier5 = modifier3;
                                        function22 = new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda23
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj9, Object obj10) {
                                                return SearchBarKt.ExpandedDockedSearchBar_qKj4JfE$lambda$10(SearchBarState.this, function2, modifier5, shape3, searchBarColors3, f7, f6, popupProperties3, function32, i, i2, (Composer) obj9, ((Integer) obj10).intValue());
                                            }
                                        };
                                        endRestartGroup.updateScope(function22);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                popupProperties2 = popupProperties;
                                composer2 = startRestartGroup;
                                modifier2 = companion;
                                shape2 = obj;
                                searchBarColors2 = obj2;
                                f4 = f;
                                f5 = f2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                function22 = new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda25
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj9, Object obj10) {
                                        return SearchBarKt.ExpandedDockedSearchBar_qKj4JfE$lambda$14(SearchBarState.this, function2, modifier2, shape2, searchBarColors2, f4, f5, popupProperties2, function3, i, i2, (Composer) obj9, ((Integer) obj10).intValue());
                                    }
                                };
                                endRestartGroup.updateScope(function22);
                                return;
                            }
                            return;
                        }
                        obj4 = function3;
                        if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj3 = popupProperties;
                    if ((i2 & 256) != 0) {
                    }
                    obj4 = function3;
                    if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                obj3 = popupProperties;
                if ((i2 & 256) != 0) {
                }
                obj4 = function3;
                if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f3 = f;
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            obj3 = popupProperties;
            if ((i2 & 256) != 0) {
            }
            obj4 = function3;
            if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        if ((i & 3072) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        i4 = i2 & 32;
        if (i4 == 0) {
        }
        f3 = f;
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        obj3 = popupProperties;
        if ((i2 & 256) != 0) {
        }
        obj4 = function3;
        if (!startRestartGroup.shouldExecute((i3 & 38347923) == 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ExpandedDockedSearchBar_qKj4JfE$lambda$13$lambda$12(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$ExpandedDockedSearchBar$2$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /* renamed from: SearchBar-Y92LkZI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2428SearchBarY92LkZI(final Function2<? super Composer, ? super Integer, Unit> function2, boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        Modifier.Companion companion;
        Object obj2;
        Object obj3;
        int i4;
        float f3;
        int i5;
        WindowInsets windowInsets2;
        final boolean z2;
        Composer composer2;
        final float f4;
        final float f5;
        final WindowInsets windowInsets3;
        final Modifier modifier2;
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        Composer composer3;
        float f6;
        WindowInsets windowInsets4;
        float f7;
        SearchBarColors searchBarColors3;
        Shape shape4;
        int i6;
        Boolean bool;
        Shape shape5;
        String str;
        Composer composer4;
        int i7;
        MutableFloatState mutableFloatState;
        Animatable animatable;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1451547856);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBar)N(inputField,expanded,onExpandedChange,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)545@26468L24,546@26521L64,547@26614L43,548@26683L51,549@26762L51,551@26844L638,551@26819L663,567@27507L27,568@27581L1149,568@27539L1191,596@28736L458:SearchBar.kt#uh7d8r");
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
            obj = function1;
        } else {
            obj = function1;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
            }
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 2048 : 1024;
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    obj2 = shape;
                    if (startRestartGroup.changed(obj2)) {
                        i10 = 16384;
                        i3 |= i10;
                    }
                } else {
                    obj2 = shape;
                }
                i10 = 8192;
                i3 |= i10;
            } else {
                obj2 = shape;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj3 = searchBarColors;
                    if (startRestartGroup.changed(obj3)) {
                        i9 = 131072;
                        i3 |= i9;
                    }
                } else {
                    obj3 = searchBarColors;
                }
                i9 = 65536;
                i3 |= i9;
            } else {
                obj3 = searchBarColors;
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
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
                }
                if ((i & 100663296) == 0) {
                    if ((i2 & 256) == 0) {
                        windowInsets2 = windowInsets;
                        if (startRestartGroup.changed(windowInsets2)) {
                            i8 = 67108864;
                            i3 |= i8;
                        }
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i8 = 33554432;
                    i3 |= i8;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 512) != 0) {
                    i3 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "538@26130L15,539@26195L8,542@26376L12");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 256) != 0) {
                                i3 &= -234881025;
                            }
                            f7 = f2;
                            windowInsets4 = windowInsets2;
                            shape4 = obj2;
                            searchBarColors3 = obj3;
                            f6 = f3;
                            composer3 = startRestartGroup;
                            i6 = i3;
                        } else {
                            if (i11 != 0) {
                                companion = Modifier.Companion;
                            }
                            if ((i2 & 16) != 0) {
                                shape3 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                shape3 = obj2;
                            }
                            if ((i2 & 32) != 0) {
                                composer3 = startRestartGroup;
                                i3 &= -458753;
                                obj3 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                            } else {
                                composer3 = startRestartGroup;
                            }
                            float m2416getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM() : f;
                            float m2415getShadowElevationD9Ej5fM = i5 != 0 ? SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM() : f2;
                            if ((i2 & 256) != 0) {
                                windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                i3 &= -234881025;
                            }
                            f6 = m2416getTonalElevationD9Ej5fM;
                            windowInsets4 = windowInsets2;
                            f7 = m2415getShadowElevationD9Ej5fM;
                            searchBarColors3 = obj3;
                            shape4 = shape3;
                            i6 = i3;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1451547856, i6, -1, "androidx.compose.material3.SearchBar (SearchBar.kt:544)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composer3, 683737348, "CC(remember):Effects.kt#9igjgp");
                        Object rememberedValue = composer3.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer3);
                            composer3.updateRememberedValue(rememberedValue);
                        }
                        CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926861680, "CC(remember):SearchBar.kt#9igjgp");
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = AnimatableKt.Animatable$default(z ? 1.0f : 0.0f, 0.0f, 2, null);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        Animatable animatable2 = (Animatable) rememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926858725, "CC(remember):SearchBar.kt#9igjgp");
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        MutableFloatState mutableFloatState2 = (MutableFloatState) rememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926856509, "CC(remember):SearchBar.kt#9igjgp");
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer3.updateRememberedValue(rememberedValue4);
                        }
                        MutableState mutableState = (MutableState) rememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926853981, "CC(remember):SearchBar.kt#9igjgp");
                        Object rememberedValue5 = composer3.rememberedValue();
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                            composer3.updateRememberedValue(rememberedValue5);
                        }
                        MutableState mutableState2 = (MutableState) rememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Boolean valueOf = Boolean.valueOf(z);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926850770, "CC(remember):SearchBar.kt#9igjgp");
                        boolean changedInstance = composer3.changedInstance(animatable2) | ((i6 & 112) == 32);
                        SearchBarKt$SearchBar$3$1 rememberedValue6 = composer3.rememberedValue();
                        if (changedInstance || rememberedValue6 == Composer.Companion.getEmpty()) {
                            bool = valueOf;
                            shape5 = shape4;
                            str = "CC(remember):SearchBar.kt#9igjgp";
                            z2 = z;
                            rememberedValue6 = new SearchBarKt$SearchBar$3$1(animatable2, z2, mutableFloatState2, mutableState, mutableState2, null);
                            composer3.updateRememberedValue(rememberedValue6);
                        } else {
                            bool = valueOf;
                            shape5 = shape4;
                            str = "CC(remember):SearchBar.kt#9igjgp";
                            z2 = z;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        int i12 = (i6 >> 3) & 14;
                        EffectsKt.LaunchedEffect(bool, (Function2) rememberedValue6, composer3, i12);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926830165, str);
                        Object rememberedValue7 = composer3.rememberedValue();
                        if (rememberedValue7 == Composer.Companion.getEmpty()) {
                            rememberedValue7 = new MutatorMutex();
                            composer3.updateRememberedValue(rememberedValue7);
                        }
                        MutatorMutex mutatorMutex = (MutatorMutex) rememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -926826675, str);
                        boolean changedInstance2 = composer3.changedInstance(animatable2) | ((i6 & 896) == 256) | composer3.changedInstance(coroutineScope);
                        SearchBarKt$SearchBar$4$1 rememberedValue8 = composer3.rememberedValue();
                        if (changedInstance2 || rememberedValue8 == Composer.Companion.getEmpty()) {
                            composer4 = composer3;
                            i7 = i6;
                            mutableFloatState = mutableFloatState2;
                            animatable = animatable2;
                            rememberedValue8 = new SearchBarKt$SearchBar$4$1(mutatorMutex, mutableFloatState2, animatable2, obj, coroutineScope, mutableState, mutableState2, null);
                            composer4.updateRememberedValue(rememberedValue8);
                        } else {
                            Composer composer5 = composer3;
                            animatable = animatable2;
                            composer4 = composer5;
                            int i13 = i6;
                            mutableFloatState = mutableFloatState2;
                            i7 = i13;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer4);
                        BackHandler_androidKt.PredictiveBackHandler(z2, (Function2) rememberedValue8, composer4, i12, 0);
                        int i14 = i7 << 6;
                        SearchBarColors searchBarColors4 = searchBarColors3;
                        float f8 = f7;
                        composer2 = composer4;
                        Modifier modifier3 = companion;
                        float f9 = f6;
                        Shape shape6 = shape5;
                        m2430SearchBarImplj1jLAyQ(animatable, mutableFloatState, mutableState, mutableState2, modifier3, function2, shape6, searchBarColors4, f9, f8, windowInsets4, function3, composer2, Animatable.$stable | 3504 | ((i7 << 3) & 57344) | ((i7 << 15) & 458752) | (3670016 & i14) | (29360128 & i14) | (234881024 & i14) | (i14 & 1879048192), (i7 >> 24) & WebSocketProtocol.PAYLOAD_SHORT, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        shape2 = shape6;
                        searchBarColors2 = searchBarColors4;
                        f4 = f9;
                        f5 = f8;
                        windowInsets3 = windowInsets4;
                    } else {
                        z2 = z;
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        f4 = f;
                        f5 = f2;
                        windowInsets3 = windowInsets2;
                        modifier2 = companion;
                        shape2 = obj2;
                        searchBarColors2 = obj3;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda26
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                return SearchBarKt.SearchBar_Y92LkZI$lambda$22(Function2.this, z2, function1, modifier2, shape2, searchBarColors2, f4, f5, windowInsets3, function3, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f3 = f;
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
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
        if ((i & 100663296) == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0274  */
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
    /* JADX WARN: Removed duplicated region for block: B:99:0x0111  */
    /* renamed from: DockedSearchBar-EQC0FA8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2421DockedSearchBarEQC0FA8(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Shape shape, SearchBarColors searchBarColors, float f, float f2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        Object obj;
        int i4;
        float f3;
        int i5;
        float f4;
        int i6;
        Composer composer2;
        final SearchBarColors searchBarColors2;
        final Modifier modifier2;
        final float f5;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        Shape shape2;
        int i7;
        int i8;
        Composer composer3;
        int i9;
        SearchBarColors searchBarColors3;
        final SearchBarColors searchBarColors4;
        float f7;
        float f8;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-2008777812);
        ComposerKt.sourceInformation(startRestartGroup, "C(DockedSearchBar)N(inputField,expanded,onExpandedChange,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)661@31616L38,665@31811L696,658@31522L985,686@32545L27,686@32513L59:SearchBar.kt#uh7d8r");
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
        int i13 = i2 & 8;
        if (i13 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 2048 : 1024;
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    obj = shape;
                    if (startRestartGroup.changed(obj)) {
                        i12 = 16384;
                        i3 |= i12;
                    }
                } else {
                    obj = shape;
                }
                i12 = 8192;
                i3 |= i12;
            } else {
                obj = shape;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0 && startRestartGroup.changed(searchBarColors)) {
                    i11 = 131072;
                    i3 |= i11;
                }
                i11 = 65536;
                i3 |= i11;
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
                if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i6 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "652@31274L11,653@31335L8");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i6 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i6 &= -458753;
                        }
                        searchBarColors4 = searchBarColors;
                        f8 = f4;
                        f7 = f3;
                        i10 = i6;
                        composer3 = startRestartGroup;
                        i9 = 0;
                    } else {
                        if (i13 != 0) {
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
                            i9 = 0;
                            i8 = i5;
                            searchBarColors3 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                            composer3 = startRestartGroup;
                            i7 &= -458753;
                        } else {
                            i8 = i5;
                            composer3 = startRestartGroup;
                            i9 = 0;
                            searchBarColors3 = searchBarColors;
                        }
                        int i14 = i7;
                        float m2416getTonalElevationD9Ej5fM = i4 != 0 ? SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM() : f;
                        if (i8 != 0) {
                            f4 = SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM();
                        }
                        SearchBarColors searchBarColors5 = searchBarColors3;
                        obj = shape2;
                        searchBarColors4 = searchBarColors5;
                        f7 = m2416getTonalElevationD9Ej5fM;
                        f8 = f4;
                        i10 = i14;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2008777812, i10, -1, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:657)");
                    }
                    long m2408getContainerColor0d7_KjU = searchBarColors4.m2408getContainerColor0d7_KjU();
                    int i15 = i10;
                    long m1902contentColorForek8zF_U = ColorSchemeKt.m1902contentColorForek8zF_U(searchBarColors4.m2408getContainerColor0d7_KjU(), composer3, i9);
                    SearchBarColors searchBarColors6 = searchBarColors4;
                    int i16 = i15 >> 6;
                    Composer composer4 = composer3;
                    Shape shape3 = obj;
                    SurfaceKt.m2569SurfaceT9BRK9s(SizeKt.m869width3ABfNKs(ZIndexModifierKt.zIndex(companion, 1.0f), SearchBarMinWidth), shape3, m2408getContainerColor0d7_KjU, m1902contentColorForek8zF_U, f7, f8, null, ComposableLambdaKt.rememberComposableLambda(401953073, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                            invoke(composer5, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i17) {
                            EnterTransition enterTransition;
                            ExitTransition exitTransition;
                            ComposerKt.sourceInformation(composer5, "C666@31821L680:SearchBar.kt#uh7d8r");
                            if (!composer5.shouldExecute((i17 & 3) != 2, i17 & 1)) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(401953073, i17, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.kt:666)");
                            }
                            Function2<Composer, Integer, Unit> function22 = function2;
                            boolean z2 = z;
                            final SearchBarColors searchBarColors7 = searchBarColors4;
                            final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                            ComposerKt.sourceInformationMarkerStart(composer5, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer5, 0);
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
                            Composer m4041constructorimpl = Updater.m4041constructorimpl(composer5);
                            Updater.m4049setimpl(m4041constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer5, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                            ComposerKt.sourceInformationMarkerStart(composer5, -439279917, "C667@31842L12,673@32030L461,669@31868L623:SearchBar.kt#uh7d8r");
                            function22.invoke(composer5, 0);
                            enterTransition = SearchBarKt.DockedEnterTransition;
                            exitTransition = SearchBarKt.DockedExitTransition;
                            AnimatedVisibilityKt.AnimatedVisibility(ColumnScopeInstance.INSTANCE, z2, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.rememberComposableLambda(-1224554113, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$1$1$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, Integer num) {
                                    invoke(animatedVisibilityScope, composer6, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer6, int i18) {
                                    ComposerKt.sourceInformation(composer6, "C674@32076L26,678@32301L176:SearchBar.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1224554113, i18, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.kt:674)");
                                    }
                                    float m7555constructorimpl = Dp.m7555constructorimpl(SearchBar_androidKt.getWindowContainerHeight(composer6, 0) * 0.6666667f);
                                    Modifier m851heightInVpY3zN4 = SizeKt.m851heightInVpY3zN4(Modifier.Companion, ((Dp) RangesKt.coerceAtMost(Dp.m7553boximpl(SearchBarKt.getDockedExpandedTableMinHeight()), Dp.m7553boximpl(m7555constructorimpl))).m7569unboximpl(), m7555constructorimpl);
                                    SearchBarColors searchBarColors8 = SearchBarColors.this;
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    ComposerKt.sourceInformationMarkerStart(composer6, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer6, 0);
                                    ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer6.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer6, m851heightInVpY3zN4);
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer6, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                                    if (!(composer6.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer6.startReusableNode();
                                    if (composer6.getInserting()) {
                                        composer6.createNode(constructor2);
                                    } else {
                                        composer6.useNode();
                                    }
                                    Composer m4041constructorimpl2 = Updater.m4041constructorimpl(composer6);
                                    Updater.m4049setimpl(m4041constructorimpl2, columnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer6, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                                    ComposerKt.sourceInformationMarkerStart(composer6, -1564650142, "C679@32383L46,680@32450L9:SearchBar.kt#uh7d8r");
                                    DividerKt.m2039HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors8.m2409getDividerColor0d7_KjU(), composer6, 0, 3);
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
                            }
                        }
                    }, composer3, 54), composer4, ((i15 >> 9) & 112) | 12582912 | (57344 & i16) | (i16 & 458752), 64);
                    obj = shape3;
                    composer2 = composer4;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1995113209, "CC(remember):SearchBar.kt#9igjgp");
                    boolean z2 = (i15 & 896) == 256;
                    Object rememberedValue = composer2.rememberedValue();
                    if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchBarKt.DockedSearchBar_EQC0FA8$lambda$24$lambda$23(Function1.this);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BackHandler_androidKt.BackHandler(z, (Function0) rememberedValue, composer2, (i15 >> 3) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    searchBarColors2 = searchBarColors6;
                    modifier2 = companion;
                    f6 = f7;
                    f5 = f8;
                } else {
                    composer2 = startRestartGroup;
                    composer2.skipToGroupEnd();
                    searchBarColors2 = searchBarColors;
                    modifier2 = companion;
                    f5 = f4;
                    f6 = f;
                }
                final Shape shape4 = obj;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return SearchBarKt.DockedSearchBar_EQC0FA8$lambda$25(Function2.this, z, function1, modifier2, shape4, searchBarColors2, f6, f5, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
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
            if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i6 & 1)) {
            }
            final Shape shape42 = obj;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) == 0) {
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
        if (startRestartGroup.shouldExecute((38347923 & i3) != 38347922, i6 & 1)) {
        }
        final Shape shape422 = obj;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DockedSearchBar_EQC0FA8$lambda$24$lambda$23(Function1 function1) {
        function1.invoke(false);
        return Unit.INSTANCE;
    }

    public static final SearchBarState rememberSearchBarState(final SearchBarValue searchBarValue, final AnimationSpec<Float> animationSpec, final AnimationSpec<Float> animationSpec2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -546016819, "C(rememberSearchBarState)N(initialValue,animationSpecForExpand,animationSpecForCollapse)817@37213L7,818@37312L7,829@37663L208,820@37352L519:SearchBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            searchBarValue = SearchBarValue.Collapsed;
        }
        if ((i2 & 2) != 0) {
            animationSpec = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowSpatial, composer, 6);
        }
        if ((i2 & 4) != 0) {
            animationSpec2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-546016819, i, -1, "androidx.compose.material3.rememberSearchBarState (SearchBar.kt:819)");
        }
        Object[] objArr = {searchBarValue, animationSpec, animationSpec2};
        Saver<SearchBarState, ?> Saver = SearchBarState.Companion.Saver(animationSpec, animationSpec2);
        ComposerKt.sourceInformationMarkerStart(composer, -736131555, "CC(remember):SearchBar.kt#9igjgp");
        boolean changedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(searchBarValue.ordinal())) || (i & 6) == 4) | composer.changedInstance(animationSpec) | composer.changedInstance(animationSpec2);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchBarKt.rememberSearchBarState$lambda$27$lambda$26(SearchBarValue.this, animationSpec, animationSpec2);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SearchBarState searchBarState = (SearchBarState) RememberSaveableKt.m4213rememberSaveable(objArr, Saver, (Function0<? extends Object>) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final SearchBarState rememberSearchBarState$lambda$27$lambda$26(SearchBarValue searchBarValue, AnimationSpec animationSpec, AnimationSpec animationSpec2) {
        return new SearchBarState(searchBarValue, animationSpec, animationSpec2);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012d  */
    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(expression = "SearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    windowInsets = windowInsets,\n    content = content,\n)", imports = {}))
    /* renamed from: SearchBar-WuY5d9Q  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2427SearchBarWuY5d9Q(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
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
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        final float f3;
        final WindowInsets windowInsets2;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        Composer composer3;
        int i18;
        SearchBarColors searchBarColors3;
        float m2416getTonalElevationD9Ej5fM;
        WindowInsets windowInsets3;
        final MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final SearchBarColors searchBarColors4;
        float f5;
        WindowInsets windowInsets4;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        Shape shape4;
        Modifier modifier2;
        final boolean z5;
        int i19;
        int i20;
        int i21;
        Composer startRestartGroup = composer.startRestartGroup(1506988286);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBar)N(query,onQueryChange,onSearch,active,onActiveChange,modifier,enabled,placeholder,leadingIcon,trailingIcon,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,interactionSource,content)1968@93682L591,1967@93650L925:SearchBar.kt#uh7d8r");
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
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
                int i22 = 8192;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
                    i5 = i3 & 32;
                    if (i5 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj2 = modifier;
                    } else {
                        obj2 = modifier;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                        }
                    }
                    i6 = i3 & 64;
                    if (i6 == 0) {
                        i4 |= 1572864;
                        z3 = z2;
                    } else {
                        z3 = z2;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                        }
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        obj3 = function2;
                    } else {
                        obj3 = function2;
                        if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj3) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        obj4 = function22;
                    } else {
                        obj4 = function22;
                        if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj4) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i3 & 512;
                    if (i9 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i10 = i9;
                        i4 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        if ((i2 & 6) == 0) {
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
                        if (i12 != 0) {
                            i13 = i23 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            int i24 = i23;
                            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i24 |= startRestartGroup.changed(f) ? 256 : 128;
                            }
                            i13 = i24;
                        }
                        i14 = i3 & 8192;
                        if (i14 != 0) {
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
                                if (i16 == 0) {
                                    i15 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i17 = i14;
                                    i15 |= startRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
                                    if ((i3 & 65536) != 0) {
                                        i15 |= 1572864;
                                    } else if ((i2 & 1572864) == 0) {
                                        i15 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                                    }
                                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 599187) != 599186, i4 & 1)) {
                                        startRestartGroup.startDefaults();
                                        ComposerKt.sourceInformation(startRestartGroup, "1959@93276L15,1960@93341L8,1963@93522L12");
                                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
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
                                            function29 = function23;
                                            searchBarColors4 = searchBarColors;
                                            m2416getTonalElevationD9Ej5fM = f;
                                            f5 = f2;
                                            windowInsets4 = windowInsets;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            function27 = obj4;
                                            modifier2 = obj2;
                                            z5 = z3;
                                            function28 = obj3;
                                            composer3 = startRestartGroup;
                                            i19 = i15;
                                            shape4 = shape;
                                            i18 = i4;
                                        } else {
                                            Modifier.Companion companion = i5 != 0 ? Modifier.Companion : obj2;
                                            boolean z6 = i6 != 0 ? true : z3;
                                            Function2<? super Composer, ? super Integer, Unit> function210 = i7 != 0 ? null : obj3;
                                            if (i8 != 0) {
                                                obj4 = null;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function211 = i10 != 0 ? null : function23;
                                            if ((i3 & 1024) != 0) {
                                                i15 &= -15;
                                                shape3 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                            } else {
                                                shape3 = shape;
                                            }
                                            if ((i3 & 2048) != 0) {
                                                i18 = i4;
                                                composer3 = startRestartGroup;
                                                searchBarColors3 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, composer3, 3072, 7);
                                                i15 &= -113;
                                            } else {
                                                composer3 = startRestartGroup;
                                                i18 = i4;
                                                searchBarColors3 = searchBarColors;
                                            }
                                            m2416getTonalElevationD9Ej5fM = i12 != 0 ? SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM() : f;
                                            float m2415getShadowElevationD9Ej5fM = i17 != 0 ? SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM() : f2;
                                            if ((i3 & 16384) != 0) {
                                                windowInsets3 = SearchBarDefaults.INSTANCE.getWindowInsets(composer3, 6);
                                                i15 &= -57345;
                                            } else {
                                                windowInsets3 = windowInsets;
                                            }
                                            if (i16 != 0) {
                                                function27 = obj4;
                                                searchBarColors4 = searchBarColors3;
                                                f5 = m2415getShadowElevationD9Ej5fM;
                                                windowInsets4 = windowInsets3;
                                                mutableInteractionSource3 = null;
                                            } else {
                                                mutableInteractionSource3 = mutableInteractionSource;
                                                function27 = obj4;
                                                searchBarColors4 = searchBarColors3;
                                                f5 = m2415getShadowElevationD9Ej5fM;
                                                windowInsets4 = windowInsets3;
                                            }
                                            function28 = function210;
                                            function29 = function211;
                                            shape4 = shape3;
                                            modifier2 = companion;
                                            z5 = z6;
                                            i19 = i15;
                                        }
                                        composer3.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1506988286, i18, i19, "androidx.compose.material3.SearchBar (SearchBar.kt:1967)");
                                        }
                                        final String str2 = obj;
                                        ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1597173218, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$SearchBar$6
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i25) {
                                                ComposerKt.sourceInformation(composer4, "C1969@93714L549:SearchBar.kt#uh7d8r");
                                                if (!composer4.shouldExecute((i25 & 3) != 2, i25 & 1)) {
                                                    composer4.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1597173218, i25, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.kt:1969)");
                                                }
                                                SearchBarDefaults.INSTANCE.InputField(str2, function1, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z5, function28, function27, function29, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource3, composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer3, 54);
                                        int i25 = i18 >> 6;
                                        int i26 = 6 | (i25 & 112) | (i25 & 896) | (i25 & 7168);
                                        int i27 = i19 << 12;
                                        SearchBarColors searchBarColors5 = searchBarColors4;
                                        Composer composer4 = composer3;
                                        float f6 = m2416getTonalElevationD9Ej5fM;
                                        m2428SearchBarY92LkZI(rememberComposableLambda, z, function13, modifier2, shape4, searchBarColors5, f6, f5, windowInsets4, function3, composer4, i26 | (57344 & i27) | (458752 & i27) | (3670016 & i27) | (29360128 & i27) | (i27 & 234881024) | ((i19 << 9) & 1879048192), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        obj2 = modifier2;
                                        f3 = f6;
                                        windowInsets2 = windowInsets4;
                                        composer2 = composer4;
                                        searchBarColors2 = searchBarColors5;
                                        z4 = z5;
                                        function24 = function27;
                                        function26 = function29;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        f4 = f5;
                                        shape2 = shape4;
                                        function25 = function28;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        shape2 = shape;
                                        searchBarColors2 = searchBarColors;
                                        f3 = f;
                                        windowInsets2 = windowInsets;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        function24 = obj4;
                                        z4 = z3;
                                        function25 = obj3;
                                        composer2 = startRestartGroup;
                                        function26 = function23;
                                        f4 = f2;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj5, Object obj6) {
                                                return SearchBarKt.SearchBar_WuY5d9Q$lambda$28(str, function1, function12, z, function13, obj2, z4, function25, function24, function26, shape2, searchBarColors2, f3, f4, windowInsets2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i17 = i14;
                                if ((i3 & 65536) != 0) {
                                }
                                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 599187) != 599186, i4 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        i16 = i3 & 32768;
                        if (i16 == 0) {
                        }
                        i17 = i14;
                        if ((i3 & 65536) != 0) {
                        }
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 599187) != 599186, i4 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i10 = i9;
                    if ((i2 & 6) == 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    int i232 = i11;
                    i12 = i3 & 4096;
                    if (i12 != 0) {
                    }
                    i14 = i3 & 8192;
                    if (i14 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    i16 = i3 & 32768;
                    if (i16 == 0) {
                    }
                    i17 = i14;
                    if ((i3 & 65536) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 599187) != 599186, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i5 = i3 & 32;
                if (i5 == 0) {
                }
                i6 = i3 & 64;
                if (i6 == 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i3 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 6) == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i2322 = i11;
                i12 = i3 & 4096;
                if (i12 != 0) {
                }
                i14 = i3 & 8192;
                if (i14 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                i16 = i3 & 32768;
                if (i16 == 0) {
                }
                i17 = i14;
                if ((i3 & 65536) != 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 599187) != 599186, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            int i222 = 8192;
            if ((i3 & 16) != 0) {
            }
            i5 = i3 & 32;
            if (i5 == 0) {
            }
            i6 = i3 & 64;
            if (i6 == 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i3 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i23222 = i11;
            i12 = i3 & 4096;
            if (i12 != 0) {
            }
            i14 = i3 & 8192;
            if (i14 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i16 = i3 & 32768;
            if (i16 == 0) {
            }
            i17 = i14;
            if ((i3 & 65536) != 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 599187) != 599186, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 8) == 0) {
        }
        int i2222 = 8192;
        if ((i3 & 16) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i232222 = i11;
        i12 = i3 & 4096;
        if (i12 != 0) {
        }
        i14 = i3 & 8192;
        if (i14 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i16 = i3 & 32768;
        if (i16 == 0) {
        }
        i17 = i14;
        if ((i3 & 65536) != 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 599187) != 599186, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012d  */
    @Deprecated(message = "Use overload which takes inputField as a parameter", replaceWith = @ReplaceWith(expression = "DockedSearchBar(\n    inputField = {\n        SearchBarDefaults.InputField(\n            query = query,\n            onQueryChange = onQueryChange,\n            onSearch = onSearch,\n            expanded = active,\n            onExpandedChange = onActiveChange,\n            enabled = enabled,\n            placeholder = placeholder,\n            leadingIcon = leadingIcon,\n            trailingIcon = trailingIcon,\n            colors = colors.inputFieldColors,\n            interactionSource = interactionSource,\n        )\n    },\n    expanded = active,\n    onExpandedChange = onActiveChange,\n    modifier = modifier,\n    shape = shape,\n    colors = colors,\n    tonalElevation = tonalElevation,\n    shadowElevation = shadowElevation,\n    content = content,\n)", imports = {}))
    /* renamed from: DockedSearchBar-eWTbjVg  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2422DockedSearchBareWTbjVg(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
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
        int i18;
        final Shape shape2;
        final SearchBarColors searchBarColors2;
        final float f3;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        int i19;
        Shape shape3;
        boolean z5;
        Composer composer3;
        int i20;
        SearchBarColors searchBarColors3;
        int i21;
        float m2416getTonalElevationD9Ej5fM;
        final MutableInteractionSource mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        SearchBarColors searchBarColors4;
        float f5;
        Shape shape4;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final boolean z6;
        int i22;
        int i23;
        Composer startRestartGroup = composer.startRestartGroup(1929583712);
        ComposerKt.sourceInformation(startRestartGroup, "C(DockedSearchBar)N(query,onQueryChange,onSearch,active,onActiveChange,modifier,enabled,placeholder,leadingIcon,trailingIcon,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,interactionSource,content)2048@96829L591,2047@96791L894:SearchBar.kt#uh7d8r");
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
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
                    i5 = i3 & 32;
                    if (i5 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj2 = modifier;
                    } else {
                        obj2 = modifier;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                        }
                    }
                    i6 = i3 & 64;
                    if (i6 == 0) {
                        i4 |= 1572864;
                        z3 = z2;
                    } else {
                        z3 = z2;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                        }
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        obj3 = function2;
                    } else {
                        obj3 = function2;
                        if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj3) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        obj4 = function22;
                    } else {
                        obj4 = function22;
                        if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj4) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i3 & 512;
                    if (i9 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i10 = i9;
                        i4 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        if ((i2 & 6) == 0) {
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
                        if (i12 != 0) {
                            i13 = i24 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            int i25 = i24;
                            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i25 |= startRestartGroup.changed(f) ? 256 : 128;
                            }
                            i13 = i25;
                        }
                        i14 = i3 & 8192;
                        if (i14 != 0) {
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
                        if (i16 != 0) {
                            i17 = i15 | 24576;
                        } else {
                            i17 = i15;
                            if ((i2 & 24576) == 0) {
                                i17 |= startRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                                if ((i3 & 32768) == 0) {
                                    i17 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i18 = i16;
                                    i17 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i17 & 74899) != 74898, i4 & 1)) {
                                        startRestartGroup.startDefaults();
                                        ComposerKt.sourceInformation(startRestartGroup, "2040@96486L11,2041@96547L8");
                                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i3 & 1024) != 0) {
                                                i17 &= -15;
                                            }
                                            if ((i3 & 2048) != 0) {
                                                i17 &= -113;
                                            }
                                            function28 = function23;
                                            searchBarColors4 = searchBarColors;
                                            f5 = f2;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            function27 = obj4;
                                            z5 = true;
                                            modifier2 = obj2;
                                            z6 = z3;
                                            function29 = obj3;
                                            composer3 = startRestartGroup;
                                            i21 = i17;
                                            shape4 = shape;
                                            m2416getTonalElevationD9Ej5fM = f;
                                            i20 = i4;
                                        } else {
                                            Modifier.Companion companion = i5 != 0 ? Modifier.Companion : obj2;
                                            boolean z7 = i6 != 0 ? true : z3;
                                            Function2<? super Composer, ? super Integer, Unit> function210 = i7 != 0 ? null : obj3;
                                            if (i8 != 0) {
                                                obj4 = null;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function211 = i10 != 0 ? null : function23;
                                            if ((i3 & 1024) != 0) {
                                                i19 = i17 & (-15);
                                                shape3 = SearchBarDefaults.INSTANCE.getDockedShape(startRestartGroup, 6);
                                            } else {
                                                i19 = i17;
                                                shape3 = shape;
                                            }
                                            if ((i3 & 2048) != 0) {
                                                i20 = i4;
                                                composer3 = startRestartGroup;
                                                z5 = true;
                                                searchBarColors3 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, composer3, 3072, 7);
                                                i21 = i19 & (-113);
                                            } else {
                                                z5 = true;
                                                composer3 = startRestartGroup;
                                                i20 = i4;
                                                searchBarColors3 = searchBarColors;
                                                i21 = i19;
                                            }
                                            m2416getTonalElevationD9Ej5fM = i12 != 0 ? SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM() : f;
                                            float m2415getShadowElevationD9Ej5fM = i14 != 0 ? SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM() : f2;
                                            if (i18 != 0) {
                                                function27 = obj4;
                                                searchBarColors4 = searchBarColors3;
                                                f5 = m2415getShadowElevationD9Ej5fM;
                                                shape4 = shape3;
                                                mutableInteractionSource3 = null;
                                            } else {
                                                mutableInteractionSource3 = mutableInteractionSource;
                                                function27 = obj4;
                                                searchBarColors4 = searchBarColors3;
                                                f5 = m2415getShadowElevationD9Ej5fM;
                                                shape4 = shape3;
                                            }
                                            function28 = function211;
                                            modifier2 = companion;
                                            function29 = function210;
                                            z6 = z7;
                                        }
                                        composer3.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1929583712, i20, i21, "androidx.compose.material3.DockedSearchBar (SearchBar.kt:2047)");
                                        }
                                        final Function1<? super String, Unit> function14 = obj;
                                        final SearchBarColors searchBarColors5 = searchBarColors4;
                                        int i27 = i20 >> 6;
                                        int i28 = i21 << 12;
                                        Composer composer4 = composer3;
                                        float f6 = m2416getTonalElevationD9Ej5fM;
                                        m2421DockedSearchBarEQC0FA8(ComposableLambdaKt.rememberComposableLambda(-1275782414, z5, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBar$4
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i29) {
                                                ComposerKt.sourceInformation(composer5, "C2049@96861L549:SearchBar.kt#uh7d8r");
                                                if (!composer5.shouldExecute((i29 & 3) != 2, i29 & 1)) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1275782414, i29, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.kt:2049)");
                                                }
                                                SearchBarDefaults.INSTANCE.InputField(str, function14, function12, z, function13, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), z6, function29, function27, function28, SearchBarColors.this.getInputFieldColors(), mutableInteractionSource3, composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer3, 54), z, function13, modifier2, shape4, searchBarColors4, f6, f5, function3, composer4, (i27 & 7168) | (i27 & 112) | 6 | (i27 & 896) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (i28 & 29360128) | ((i21 << 9) & 234881024), 0);
                                        SearchBarColors searchBarColors6 = searchBarColors4;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        obj2 = modifier2;
                                        f3 = f5;
                                        composer2 = composer4;
                                        searchBarColors2 = searchBarColors6;
                                        z4 = z6;
                                        function24 = function27;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        shape2 = shape4;
                                        f4 = f6;
                                        function25 = function29;
                                        function26 = function28;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        shape2 = shape;
                                        searchBarColors2 = searchBarColors;
                                        f3 = f2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        function24 = obj4;
                                        z4 = z3;
                                        function25 = obj3;
                                        composer2 = startRestartGroup;
                                        function26 = function23;
                                        f4 = f;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj5, Object obj6) {
                                                return SearchBarKt.DockedSearchBar_eWTbjVg$lambda$29(str, function1, function12, z, function13, obj2, z4, function25, function24, function26, shape2, searchBarColors2, f4, f3, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i18 = i16;
                                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i17 & 74899) != 74898, i4 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                        }
                        if ((i3 & 32768) == 0) {
                        }
                        i18 = i16;
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i17 & 74899) != 74898, i4 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i10 = i9;
                    if ((i2 & 6) == 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    int i242 = i11;
                    i12 = i3 & 4096;
                    if (i12 != 0) {
                    }
                    i14 = i3 & 8192;
                    if (i14 != 0) {
                    }
                    i16 = i3 & 16384;
                    if (i16 != 0) {
                    }
                    if ((i3 & 32768) == 0) {
                    }
                    i18 = i16;
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i17 & 74899) != 74898, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i5 = i3 & 32;
                if (i5 == 0) {
                }
                i6 = i3 & 64;
                if (i6 == 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i3 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 6) == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i2422 = i11;
                i12 = i3 & 4096;
                if (i12 != 0) {
                }
                i14 = i3 & 8192;
                if (i14 != 0) {
                }
                i16 = i3 & 16384;
                if (i16 != 0) {
                }
                if ((i3 & 32768) == 0) {
                }
                i18 = i16;
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i17 & 74899) != 74898, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i3 & 16) != 0) {
            }
            i5 = i3 & 32;
            if (i5 == 0) {
            }
            i6 = i3 & 64;
            if (i6 == 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i3 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i24222 = i11;
            i12 = i3 & 4096;
            if (i12 != 0) {
            }
            i14 = i3 & 8192;
            if (i14 != 0) {
            }
            i16 = i3 & 16384;
            if (i16 != 0) {
            }
            if ((i3 & 32768) == 0) {
            }
            i18 = i16;
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i17 & 74899) != 74898, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i242222 = i11;
        i12 = i3 & 4096;
        if (i12 != 0) {
        }
        i14 = i3 & 8192;
        if (i14 != 0) {
        }
        i16 = i3 & 16384;
        if (i16 != 0) {
        }
        if ((i3 & 32768) == 0) {
        }
        i18 = i16;
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i17 & 74899) != 74898, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isExpanded(SearchBarState searchBarState) {
        return searchBarState.getCurrentValue() == SearchBarValue.Expanded;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    /* renamed from: SearchBarImpl-j1jLAyQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2430SearchBarImplj1jLAyQ(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState mutableFloatState, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Object obj2;
        Object obj3;
        int i6;
        int i7;
        int i8;
        int i9;
        Object obj4;
        int i10;
        final Shape shape2;
        final float f3;
        final WindowInsets windowInsets2;
        Composer composer2;
        final Modifier modifier2;
        final float f4;
        final SearchBarColors searchBarColors2;
        ScopeUpdateScope endRestartGroup;
        Object obj5;
        Modifier modifier3;
        int i11;
        SearchBarColors searchBarColors3;
        int i12;
        Object obj6;
        int i13;
        final float f5;
        int i14;
        final SearchBarColors searchBarColors4;
        final float f6;
        Shape shape3;
        Modifier modifier4;
        Modifier modifier5;
        GenericShape genericShape;
        ComposableLambda composableLambda;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(501752896);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBarImpl)N(animationProgress,finalBackProgress,firstBackEvent,currentBackEvent,modifier,inputField,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)2094@98568L7,2096@98628L15,2097@98695L15,2098@98741L101,2102@98875L666,2118@99580L333,2129@99938L99,2142@100370L362:SearchBar.kt#uh7d8r");
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
            obj = mutableState;
        } else {
            obj = mutableState;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i4 |= startRestartGroup.changed(obj) ? 256 : 128;
            }
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(mutableState2) ? 2048 : 1024;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                obj2 = modifier;
                i4 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
                if ((i3 & 32) != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
                }
                if ((i & 1572864) == 0) {
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : 524288;
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        obj3 = searchBarColors;
                        if (startRestartGroup.changed(obj3)) {
                            i16 = 8388608;
                            i4 |= i16;
                        }
                    } else {
                        obj3 = searchBarColors;
                    }
                    i16 = 4194304;
                    i4 |= i16;
                } else {
                    obj3 = searchBarColors;
                }
                i6 = i3 & 256;
                if (i6 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i7 = i6;
                    i4 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
                    i8 = i3 & 512;
                    if (i8 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i9 = i8;
                        i4 |= startRestartGroup.changed(f2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        if ((i2 & 6) == 0) {
                            if ((i3 & 1024) == 0) {
                                obj4 = windowInsets;
                                if (startRestartGroup.changed(obj4)) {
                                    i15 = 4;
                                    i10 = i2 | i15;
                                }
                            } else {
                                obj4 = windowInsets;
                            }
                            i15 = 2;
                            i10 = i2 | i15;
                        } else {
                            obj4 = windowInsets;
                            i10 = i2;
                        }
                        if ((i3 & 2048) != 0) {
                            i10 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i10 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
                        }
                        if (startRestartGroup.shouldExecute((306783379 & i4) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "2087@98224L15,2088@98289L8,2091@98470L12");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 1024) != 0) {
                                    i10 &= -15;
                                }
                                f6 = f;
                                i13 = i4;
                                searchBarColors4 = obj3;
                                modifier4 = obj2;
                                i14 = i10;
                                shape3 = shape;
                                obj6 = obj4;
                                f5 = f2;
                            } else {
                                Modifier.Companion companion = i5 != 0 ? Modifier.Companion : obj2;
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    obj5 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                } else {
                                    obj5 = shape;
                                }
                                int i17 = i4;
                                if ((i3 & 128) != 0) {
                                    modifier3 = companion;
                                    i11 = 6;
                                    searchBarColors3 = SearchBarDefaults.INSTANCE.m2411colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                                    i12 = i17 & (-29360129);
                                } else {
                                    modifier3 = companion;
                                    i11 = 6;
                                    searchBarColors3 = obj3;
                                    i12 = i17;
                                }
                                float m2416getTonalElevationD9Ej5fM = i7 != 0 ? SearchBarDefaults.INSTANCE.m2416getTonalElevationD9Ej5fM() : f;
                                float m2415getShadowElevationD9Ej5fM = i9 != 0 ? SearchBarDefaults.INSTANCE.m2415getShadowElevationD9Ej5fM() : f2;
                                if ((i3 & 1024) != 0) {
                                    i13 = i12;
                                    obj6 = SearchBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, i11);
                                    i14 = i10 & (-15);
                                    searchBarColors4 = searchBarColors3;
                                    f5 = m2415getShadowElevationD9Ej5fM;
                                    shape3 = obj5;
                                    f6 = m2416getTonalElevationD9Ej5fM;
                                } else {
                                    obj6 = windowInsets;
                                    i13 = i12;
                                    f5 = m2415getShadowElevationD9Ej5fM;
                                    i14 = i10;
                                    searchBarColors4 = searchBarColors3;
                                    f6 = m2416getTonalElevationD9Ej5fM;
                                    shape3 = obj5;
                                }
                                modifier4 = modifier3;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                modifier5 = modifier4;
                                ComposerKt.traceEventStart(501752896, i13, i14, "androidx.compose.material3.SearchBarImpl (SearchBar.kt:2093)");
                            } else {
                                modifier5 = modifier4;
                            }
                            WindowInsets windowInsets3 = obj6;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final Density density = (Density) consume;
                            Shape inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                            int i18 = i14;
                            Shape fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1148225381, "CC(remember):SearchBar.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$31$lambda$30(Animatable.this));
                                    }
                                });
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            State state = (State) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            boolean SearchBarImpl_j1jLAyQ$lambda$32 = SearchBarImpl_j1jLAyQ$lambda$32(state);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1148230234, "CC(remember):SearchBar.kt#9igjgp");
                            boolean changed = startRestartGroup.changed(SearchBarImpl_j1jLAyQ$lambda$32) | ((((3670016 & i13) ^ 1572864) > 1048576 && startRestartGroup.changed(shape3)) || (i13 & 1572864) == 1048576);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                                if (Intrinsics.areEqual(shape3, inputFieldShape)) {
                                    genericShape = new GenericShape(new Function3() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda11
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj7, Object obj8, Object obj9) {
                                            return SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$35$lambda$34(Density.this, animatable, (Path) obj7, (Size) obj8, (LayoutDirection) obj9);
                                        }
                                    });
                                } else {
                                    genericShape = SearchBarImpl_j1jLAyQ$lambda$32(state) ? fullScreenShape : shape3;
                                }
                                startRestartGroup.updateRememberedValue(genericShape);
                                rememberedValue2 = genericShape;
                            }
                            final Shape shape4 = (Shape) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1304392981, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$SearchBarImpl$surface$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i19) {
                                    ComposerKt.sourceInformation(composer3, "C2122@99720L38,2119@99594L309:SearchBar.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i19 & 3) != 2, i19 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1304392981, i19, -1, "androidx.compose.material3.SearchBarImpl.<anonymous> (SearchBar.kt:2119)");
                                    }
                                    SurfaceKt.m2569SurfaceT9BRK9s(null, Shape.this, searchBarColors4.m2408getContainerColor0d7_KjU(), ColorSchemeKt.m1902contentColorForek8zF_U(searchBarColors4.m2408getContainerColor0d7_KjU(), composer3, 0), f6, f5, null, ComposableSingletons$SearchBarKt.INSTANCE.getLambda$1165377840$material3(), composer3, 12582912, 65);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1148263683, "CC(remember):SearchBar.kt#9igjgp");
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda20
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$37$lambda$36(Animatable.this));
                                    }
                                });
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (SearchBarImpl_j1jLAyQ$lambda$38((State) rememberedValue3)) {
                                startRestartGroup.startReplaceGroup(1236615731);
                                ComposerKt.sourceInformation(startRestartGroup, "2134@100129L215");
                                composableLambda = ComposableLambdaKt.rememberComposableLambda(1831594093, true, new SearchBarKt$SearchBarImpl$wrappedContent$1(animatable, searchBarColors4, function3), startRestartGroup, 54);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(1236851485);
                                startRestartGroup.endReplaceGroup();
                                composableLambda = null;
                            }
                            Shape shape5 = shape3;
                            SearchBarColors searchBarColors5 = searchBarColors4;
                            float f7 = f5;
                            MutableState<BackEventCompat> mutableState3 = obj;
                            ComposableLambda composableLambda2 = composableLambda;
                            float f8 = f6;
                            Modifier modifier6 = modifier5;
                            SearchBarLayout(animatable, mutableFloatState, mutableState3, mutableState2, modifier6, windowInsets3, function2, rememberComposableLambda, composableLambda2, startRestartGroup, Animatable.$stable | 12582912 | (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | ((i18 << 15) & 458752) | ((i13 << 3) & 3670016));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            searchBarColors2 = searchBarColors5;
                            f3 = f8;
                            f4 = f7;
                            shape2 = shape5;
                            windowInsets2 = windowInsets3;
                            modifier2 = modifier6;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            shape2 = shape;
                            f3 = f;
                            windowInsets2 = windowInsets;
                            composer2 = startRestartGroup;
                            modifier2 = obj2;
                            f4 = f2;
                            searchBarColors2 = obj3;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda21
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj7, Object obj8) {
                                    return SearchBarKt.SearchBarImpl_j1jLAyQ$lambda$39(Animatable.this, mutableFloatState, mutableState, mutableState2, modifier2, function2, shape2, searchBarColors2, f3, f4, windowInsets2, function3, i, i2, i3, (Composer) obj7, ((Integer) obj8).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    if ((i2 & 6) == 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((306783379 & i4) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i6;
                i8 = i3 & 512;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i2 & 6) == 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                if (startRestartGroup.shouldExecute((306783379 & i4) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = modifier;
            if ((i3 & 32) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i6 = i3 & 256;
            if (i6 != 0) {
            }
            i7 = i6;
            i8 = i3 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 6) == 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            if (startRestartGroup.shouldExecute((306783379 & i4) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        obj2 = modifier;
        if ((i3 & 32) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i6 = i3 & 256;
        if (i6 != 0) {
        }
        i7 = i6;
        i8 = i3 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 6) == 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        if (startRestartGroup.shouldExecute((306783379 & i4) == 306783378 || (i10 & 19) != 18, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean SearchBarImpl_j1jLAyQ$lambda$31$lambda$30(Animatable animatable) {
        return ((Number) animatable.getValue()).floatValue() == 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SearchBarImpl_j1jLAyQ$lambda$35$lambda$34(Density density, Animatable animatable, Path path, Size size, LayoutDirection layoutDirection) {
        float mo405toPx0680j_4 = density.mo405toPx0680j_4(Dp.m7555constructorimpl(SearchBarCornerRadius * (1.0f - ((Number) animatable.getValue()).floatValue())));
        Path.addRoundRect$default(path, RoundRectKt.m4582RoundRectsniSvfs(androidx.compose.ui.geometry.SizeKt.m4617toRectuvyYCjk(size.m4601unboximpl()), CornerRadius.m4481constructorimpl((Float.floatToRawIntBits(mo405toPx0680j_4) << 32) | (Float.floatToRawIntBits(mo405toPx0680j_4) & 4294967295L))), null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean SearchBarImpl_j1jLAyQ$lambda$37$lambda$36(Animatable animatable) {
        return ((Number) animatable.getValue()).floatValue() > 0.0f;
    }

    private static final void SearchBarLayout(final Animatable<Float, AnimationVector1D> animatable, final MutableFloatState mutableFloatState, final MutableState<BackEventCompat> mutableState, final MutableState<BackEventCompat> mutableState2, final Modifier modifier, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i) {
        int i2;
        Object obj;
        Object obj2;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1217602934);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBarLayout)N(animationProgress,finalBackProgress,firstBackEvent,currentBackEvent,modifier,windowInsets,inputField,surface,content)2171@101429L34,2176@101591L120,2191@102227L5012,2172@101468L5771:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(animatable) : startRestartGroup.changedInstance(animatable) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(mutableFloatState) ? 32 : 16;
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
        if (!startRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1217602934, i2, -1, "androidx.compose.material3.SearchBarLayout (SearchBar.kt:2167)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1885337272, "CC(remember):SearchBar.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new MutableWindowInsets(null, 1, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier zIndex = ZIndexModifierKt.zIndex(modifier, 1.0f);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1885342542, "CC(remember):SearchBar.kt#9igjgp");
            boolean z = (458752 & i2) == 131072;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SearchBarKt.SearchBarLayout$lambda$42$lambda$41(MutableWindowInsets.this, windowInsets, (WindowInsets) obj3);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier consumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex, (Function1) rememberedValue2), windowInsets);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1885367786, "CC(remember):SearchBar.kt#9igjgp");
            boolean z2 = ((i2 & 14) == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(animatable))) | ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 896) == 256);
            SearchBarKt$SearchBarLayout$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                MutableState<BackEventCompat> mutableState3 = obj;
                i3 = i2;
                rememberedValue3 = new SearchBarKt$SearchBarLayout$2$1(animatable, mutableWindowInsets, obj2, mutableFloatState, mutableState3);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            } else {
                i3 = i2;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, consumeWindowInsets);
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
            Updater.m4049setimpl(m4041constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2058590599, "C2181@101796L85,2182@101894L119:SearchBar.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdSurface);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 329239585, "C2181@101870L9:SearchBar.kt#uh7d8r");
            function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 21) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdInputField);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4041constructorimpl3 = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 397275701, "C2183@101987L12:SearchBar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 18) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (function23 == null) {
                startRestartGroup.startReplaceGroup(2058820276);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(2058820277);
                ComposerKt.sourceInformation(startRestartGroup, "*2186@102068L127");
                Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.Companion, LayoutIdSearchContent);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4041constructorimpl4 = Updater.m4041constructorimpl(startRestartGroup);
                Updater.m4049setimpl(m4041constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4041constructorimpl4.getInserting() || !Intrinsics.areEqual(m4041constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m4041constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m4041constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m4049setimpl(m4041constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1819747385, "C2187@102168L9:SearchBar.kt#uh7d8r");
                function23.invoke(startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return SearchBarKt.SearchBarLayout$lambda$49(Animatable.this, mutableFloatState, mutableState, mutableState2, modifier, windowInsets, function2, function22, function23, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SearchBarLayout$lambda$42$lambda$41(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: DockedSearchBarLayout-nbWgWpA  reason: not valid java name */
    public static final void m2423DockedSearchBarLayoutnbWgWpA(final SearchBarState searchBarState, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Shape shape, final SearchBarColors searchBarColors, final float f, final float f2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Modifier modifier2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1402423467);
        ComposerKt.sourceInformation(startRestartGroup, "C(DockedSearchBarLayout)N(state,inputField,modifier,shape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,content)2324@107586L24,2325@107655L47,2325@107615L87,2330@107802L38,2334@107974L2233,2327@107708L2499:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            modifier2 = modifier;
            i2 |= startRestartGroup.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(shape) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(searchBarColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1402423467, i2, -1, "androidx.compose.material3.DockedSearchBarLayout (SearchBar.kt:2323)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean isExpanded = isExpanded(searchBarState);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -890765926, "CC(remember):SearchBar.kt#9igjgp");
            boolean changedInstance = ((i2 & 14) == 4) | startRestartGroup.changedInstance(coroutineScope);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchBarKt.DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(CoroutineScope.this, searchBarState);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BackHandler_androidKt.BackHandler(isExpanded, (Function0) rememberedValue2, startRestartGroup, 0, 0);
            int i3 = i2 >> 3;
            composer2 = startRestartGroup;
            SurfaceKt.m2569SurfaceT9BRK9s(WindowInsetsPadding_androidKt.imePadding(modifier2), shape, searchBarColors.m2408getContainerColor0d7_KjU(), ColorSchemeKt.m1902contentColorForek8zF_U(searchBarColors.m2408getContainerColor0d7_KjU(), startRestartGroup, 0), f, f2, null, ComposableLambdaKt.rememberComposableLambda(-956905210, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C2335@108012L26,2343@108320L195,2350@108545L1656,2339@108213L1988:SearchBar.kt#uh7d8r");
                    if (!composer3.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-956905210, i4, -1, "androidx.compose.material3.DockedSearchBarLayout.<anonymous> (SearchBar.kt:2335)");
                    }
                    float m7555constructorimpl = Dp.m7555constructorimpl(SearchBar_androidKt.getWindowContainerHeight(composer3, 0) * 0.6666667f);
                    float m7569unboximpl = ((Dp) RangesKt.coerceAtMost(Dp.m7553boximpl(SearchBarKt.getDockedExpandedTableMinHeight()), Dp.m7553boximpl(m7555constructorimpl))).m7569unboximpl();
                    final SearchBarColors searchBarColors2 = searchBarColors;
                    final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    List listOf = CollectionsKt.listOf((Object[]) new Function2[]{function2, ComposableLambdaKt.rememberComposableLambda(-1776541672, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i5) {
                            ComposerKt.sourceInformation(composer4, "C2344@108346L147:SearchBar.kt#uh7d8r");
                            if (!composer4.shouldExecute((i5 & 3) != 2, i5 & 1)) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1776541672, i5, -1, "androidx.compose.material3.DockedSearchBarLayout.<anonymous>.<anonymous> (SearchBar.kt:2344)");
                            }
                            SearchBarColors searchBarColors3 = SearchBarColors.this;
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            ComposerKt.sourceInformationMarkerStart(composer4, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer4, 0);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, Modifier.Companion);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer m4041constructorimpl = Updater.m4041constructorimpl(composer4);
                            Updater.m4049setimpl(m4041constructorimpl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer4, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                            ComposerKt.sourceInformationMarkerStart(composer4, 1313930401, "C2345@108383L46,2346@108458L9:SearchBar.kt#uh7d8r");
                            DividerKt.m2039HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors3.m2409getDividerColor0d7_KjU(), composer4, 0, 3);
                            function33.invoke(ColumnScopeInstance.INSTANCE, composer4, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54)});
                    ComposerKt.sourceInformationMarkerStart(composer3, -462885538, "CC(remember):SearchBar.kt#9igjgp");
                    boolean changed = composer3.changed(searchBarState) | composer3.changed(m7555constructorimpl) | composer3.changed(m7569unboximpl);
                    SearchBarState searchBarState2 = searchBarState;
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                        rememberedValue3 = (MultiContentMeasurePolicy) new SearchBarKt$DockedSearchBarLayout$2$2$1(searchBarState2, m7555constructorimpl, m7569unboximpl);
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1399185516, "CC(Layout)P(!1,2)168@6883L62,165@6769L182:Layout.kt#80mrfh");
                    Modifier.Companion companion = Modifier.Companion;
                    Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                    ComposerKt.sourceInformationMarkerStart(composer3, -290764973, "CC(remember):Layout.kt#9igjgp");
                    boolean changed2 = composer3.changed(multiContentMeasurePolicy);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue4 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, companion);
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
                    Updater.m4049setimpl(m4041constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    combineAsVirtualLayouts.invoke(composer3, 0);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, ((i2 >> 6) & 112) | 12582912 | (57344 & i3) | (i3 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.DockedSearchBarLayout_nbWgWpA$lambda$52(SearchBarState.this, function2, modifier3, shape, searchBarColors, f, f2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DockedSearchBarLayout_nbWgWpA$lambda$51$lambda$50(CoroutineScope coroutineScope, SearchBarState searchBarState) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarKt$DockedSearchBarLayout$1$1$1(searchBarState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: FullScreenSearchBarLayout-EQC0FA8  reason: not valid java name */
    public static final void m2426FullScreenSearchBarLayoutEQC0FA8(final SearchBarState searchBarState, final PredictiveBackState predictiveBackState, final Function2<? super Composer, ? super Integer, Unit> function2, final Modifier modifier, final Shape shape, final SearchBarColors searchBarColors, final float f, final float f2, final WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        State state;
        final MutableState mutableState;
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-740838201);
        ComposerKt.sourceInformation(startRestartGroup, "C(FullScreenSearchBarLayout)N(state,predictiveBackState,inputField,modifier,collapsedShape,colors,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,windowInsets,content)2399@110650L57,2401@110747L64,2410@111159L64,2419@111546L7,2420@111598L15,2422@111646L1042,2447@112954L34,2453@113205L120,2484@114348L4812,2450@113110L6050:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(searchBarState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? startRestartGroup.changed(predictiveBackState) : startRestartGroup.changedInstance(predictiveBackState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(searchBarColors) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= startRestartGroup.changed(windowInsets) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (!startRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-740838201, i2, -1, "androidx.compose.material3.FullScreenSearchBarLayout (SearchBar.kt:2398)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019074080, "CC(remember):SearchBar.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        BackEventProgress value;
                        value = PredictiveBackState.this.getValue();
                        return value;
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            State state2 = (State) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019077191, "CC(remember):SearchBar.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState2 = (MutableState) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$55 = FullScreenSearchBarLayout_EQC0FA8$lambda$55(state2);
            if (FullScreenSearchBarLayout_EQC0FA8$lambda$55 instanceof BackEventProgress.InProgress) {
                if (mutableState2.getValue() == null) {
                    mutableState2.setValue(FullScreenSearchBarLayout_EQC0FA8$lambda$55);
                }
            } else if (Intrinsics.areEqual(FullScreenSearchBarLayout_EQC0FA8$lambda$55, BackEventProgress.NotRunning.INSTANCE)) {
                mutableState2.setValue(null);
            } else if (!Intrinsics.areEqual(FullScreenSearchBarLayout_EQC0FA8$lambda$55, BackEventProgress.Completed.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019090375, "CC(remember):SearchBar.kt#9igjgp");
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                state = state2;
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            } else {
                state = state2;
            }
            MutableState mutableState3 = (MutableState) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$552 = FullScreenSearchBarLayout_EQC0FA8$lambda$55(state);
            if (FullScreenSearchBarLayout_EQC0FA8$lambda$552 instanceof BackEventProgress.InProgress) {
                mutableState3.setValue(FullScreenSearchBarLayout_EQC0FA8$lambda$552);
            } else if (Intrinsics.areEqual(FullScreenSearchBarLayout_EQC0FA8$lambda$552, BackEventProgress.NotRunning.INSTANCE)) {
                mutableState3.setValue(null);
            } else if (!Intrinsics.areEqual(FullScreenSearchBarLayout_EQC0FA8$lambda$552, BackEventProgress.Completed.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            int i5 = i2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density = (Density) consume;
            final Shape fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019106937, "CC(remember):SearchBar.kt#9igjgp");
            boolean changed = startRestartGroup.changed(density) | startRestartGroup.changed(fullScreenShape);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                mutableState = mutableState3;
                i3 = i5;
                i4 = 1;
                GenericShape genericShape = new GenericShape(new Function3() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(Shape.this, fullScreenShape, density, searchBarState, mutableState, (Path) obj, (Size) obj2, (LayoutDirection) obj3);
                    }
                });
                startRestartGroup.updateRememberedValue(genericShape);
                rememberedValue4 = genericShape;
            } else {
                mutableState = mutableState3;
                i3 = i5;
                i4 = 1;
            }
            GenericShape genericShape2 = (GenericShape) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019147785, "CC(remember):SearchBar.kt#9igjgp");
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new MutableWindowInsets(null, i4, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            WindowInsets m891onlybOOhFvg = WindowInsetsKt.m891onlybOOhFvg(mutableWindowInsets.getInsets(), WindowInsetsSides.m903plusgK_yJZ4(WindowInsetsSides.Companion.m913getHorizontalJoeWqyM(), WindowInsetsSides.Companion.m911getBottomJoeWqyM()));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019155903, "CC(remember):SearchBar.kt#9igjgp");
            int i6 = (i3 & 234881024) == 67108864 ? i4 : 0;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (i6 != 0 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(MutableWindowInsets.this, windowInsets, (WindowInsets) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier consumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(modifier, (Function1) rememberedValue6), windowInsets);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1019197171, "CC(remember):SearchBar.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(mutableState) | ((i3 & 14) == 4) | startRestartGroup.changed(mutableState2);
            SearchBarKt$FullScreenSearchBarLayout$2$1 rememberedValue7 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new SearchBarKt$FullScreenSearchBarLayout$2$1(mutableState, searchBarState, mutableWindowInsets, mutableState2);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, consumeWindowInsets);
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
            Updater.m4049setimpl(m4041constructorimpl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1312429125, "C2461@113581L17,2458@113410L297,2471@113910L38,2467@113721L372,2478@114193L17,2477@114107L223:SearchBar.kt#uh7d8r");
            Modifier padding = PaddingKt.padding(LayoutIdKt.layoutId(Modifier.Companion, LayoutIdInputField), WindowInsetsKt.asPaddingValues(WindowInsetsKt.m891onlybOOhFvg(m891onlybOOhFvg, WindowInsetsSides.Companion.m913getHorizontalJoeWqyM()), startRestartGroup, 0));
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), true);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, padding);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 714795213, "C2464@113681L12:SearchBar.kt#uh7d8r");
            int i7 = i3 >> 6;
            function2.invoke(startRestartGroup, Integer.valueOf(i7 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            SurfaceKt.m2569SurfaceT9BRK9s(LayoutIdKt.layoutId(Modifier.Companion, LayoutIdSurface), genericShape2, searchBarColors.m2408getContainerColor0d7_KjU(), ColorSchemeKt.m1902contentColorForek8zF_U(searchBarColors.m2408getContainerColor0d7_KjU(), startRestartGroup, 0), f, f2, null, ComposableSingletons$SearchBarKt.INSTANCE.m1944getLambda$1146652811$material3(), startRestartGroup, (57344 & i7) | 12582918 | (i7 & 458752), 64);
            composer2 = startRestartGroup;
            Modifier padding2 = PaddingKt.padding(LayoutIdKt.layoutId(Modifier.Companion, LayoutIdSearchContent), WindowInsetsKt.asPaddingValues(m891onlybOOhFvg, composer2, 0));
            ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, padding2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer m4041constructorimpl3 = Updater.m4041constructorimpl(composer2);
            Updater.m4049setimpl(m4041constructorimpl3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ComposerKt.sourceInformationMarkerStart(composer2, -1748770687, "C2480@114244L46,2481@114307L9:SearchBar.kt#uh7d8r");
            DividerKt.m2039HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors.m2409getDividerColor0d7_KjU(), composer2, 0, 3);
            function3.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(6 | ((i3 >> 24) & 112)));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.FullScreenSearchBarLayout_EQC0FA8$lambda$70(SearchBarState.this, predictiveBackState, function2, modifier, shape, searchBarColors, f, f2, windowInsets, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$62$lambda$61(Shape shape, Shape shape2, Density density, SearchBarState searchBarState, MutableState mutableState, Path path, Size size, LayoutDirection layoutDirection) {
        if (shape == RoundedCornerShapeKt.getCircleShape() && shape2 == RectangleShapeKt.getRectangleShape()) {
            float mo405toPx0680j_4 = density.mo405toPx0680j_4(Dp.m7555constructorimpl(SearchBarCornerRadius * Math.max(1.0f - searchBarState.getProgress(), transform((BackEventProgress.InProgress) mutableState.getValue()))));
            if (mo405toPx0680j_4 < 0.001d) {
                Path.addRect$default(path, androidx.compose.ui.geometry.SizeKt.m4617toRectuvyYCjk(size.m4601unboximpl()), null, 2, null);
            } else {
                Path.addRoundRect$default(path, RoundRectKt.m4582RoundRectsniSvfs(androidx.compose.ui.geometry.SizeKt.m4617toRectuvyYCjk(size.m4601unboximpl()), CornerRadius.m4481constructorimpl((Float.floatToRawIntBits(mo405toPx0680j_4) << 32) | (Float.floatToRawIntBits(mo405toPx0680j_4) & 4294967295L))), null, 2, null);
            }
        } else {
            if (searchBarState.getProgress() >= 0.5f) {
                shape = shape2;
            }
            OutlineKt.addOutline(path, shape.mo320createOutlinePq9zytI(size.m4601unboximpl(), layoutDirection, density));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FullScreenSearchBarLayout_EQC0FA8$lambda$65$lambda$64(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float transform(BackEventProgress.InProgress inProgress) {
        if (inProgress == null) {
            return 0.0f;
        }
        return PredictiveBack.INSTANCE.transform$material3(inProgress.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect getCollapsedBounds(SearchBarState searchBarState) {
        IntRect m7716IntRectVbeCjmY;
        LayoutCoordinates collapsedCoords = searchBarState.getCollapsedCoords();
        return (collapsedCoords == null || (m7716IntRectVbeCjmY = IntRectKt.m7716IntRectVbeCjmY(IntOffsetKt.m7700roundk4lQ0M(LayoutCoordinatesKt.positionInWindow(collapsedCoords)), collapsedCoords.mo6224getSizeYbymL2g())) == null) ? IntRect.Companion.getZero() : m7716IntRectVbeCjmY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DetectClickFromInteractionSource(final InteractionSource interactionSource, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-652650823);
        ComposerKt.sourceInformation(startRestartGroup, "C(DetectClickFromInteractionSource)N(interactionSource,onClick)2593@119695L148,2593@119661L182:SearchBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(interactionSource) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652650823, i2, -1, "androidx.compose.material3.DetectClickFromInteractionSource (SearchBar.kt:2592)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -132210195, "CC(remember):SearchBar.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = (i3 == 4) | ((i2 & 112) == 32);
            SearchBarKt$DetectClickFromInteractionSource$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SearchBarKt$DetectClickFromInteractionSource$1$1(interactionSource, function0, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            EffectsKt.LaunchedEffect(interactionSource, (Function2) rememberedValue, startRestartGroup, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarKt.DetectClickFromInteractionSource$lambda$73(InteractionSource.this, function0, i, (Composer) obj, ((Integer) obj2).intValue());
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
    public static final int m2436calculatePredictiveBackOffsetXrOvwMX4(long j, int i, BackEventCompat backEventCompat, LayoutDirection layoutDirection, float f, float f2) {
        if (backEventCompat == null || f2 == 0.0f) {
            return 0;
        }
        return MathKt.roundToInt(((Constraints.m7508getMaxWidthimpl(j) * SearchBarPredictiveBackMaxOffsetXRatio) - i) * (1.0f - f) * f2 * (backEventCompat.getSwipeEdge() == 0 ? 1 : -1) * (layoutDirection != LayoutDirection.Ltr ? -1 : 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculatePredictiveBackOffsetY-dzo92Q0  reason: not valid java name */
    public static final int m2437calculatePredictiveBackOffsetYdzo92Q0(long j, int i, BackEventCompat backEventCompat, BackEventCompat backEventCompat2, int i2, int i3, float f) {
        if (backEventCompat2 == null || backEventCompat == null || f == 0.0f) {
            return 0;
        }
        int min = Math.min(Math.max(0, ((Constraints.m7507getMaxHeightimpl(j) - i2) / 2) - i), i3);
        float touchY = backEventCompat.getTouchY() - backEventCompat2.getTouchY();
        float abs = Math.abs(touchY) / Constraints.m7507getMaxHeightimpl(j);
        return MathKt.roundToInt(MathHelpersKt.lerp(0, min, abs) * f * Math.signum(touchY));
    }

    static {
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

    public static final float getSearchBarAsTopBarPadding() {
        return SearchBarAsTopBarPadding;
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

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$32(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean SearchBarImpl_j1jLAyQ$lambda$38(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final BackEventProgress FullScreenSearchBarLayout_EQC0FA8$lambda$55(State<? extends BackEventProgress> state) {
        return state.getValue();
    }
}
