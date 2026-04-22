package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: SearchBar.kt */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020!0)2\b\b\u0002\u0010*\u001a\u00020%H\u0007¢\u0006\u0002\u0010+J-\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u000202H\u0007¢\u0006\u0004\b3\u00104Jõ\u0001\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020/2\b\b\u0002\u0010F\u001a\u00020/2\b\b\u0002\u0010G\u001a\u00020/2\b\b\u0002\u0010H\u001a\u00020/2\b\b\u0002\u0010I\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020/2\b\b\u0002\u0010K\u001a\u00020/2\b\b\u0002\u0010L\u001a\u00020/H\u0007¢\u0006\u0004\bM\u0010NJ\u008e\u0002\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\b\b\u0002\u0010[\u001a\u00020%2\b\b\u0002\u0010\\\u001a\u00020]2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010g2\b\b\u0002\u0010h\u001a\u00020i2\b\b\u0002\u0010j\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010mJ¢\u0002\u0010O\u001a\u00020P2\u0006\u0010n\u001a\u00020R2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0006\u0010o\u001a\u00020%2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\b\b\u0002\u0010[\u001a\u00020%2\b\b\u0002\u0010\\\u001a\u00020]2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010g2\b\b\u0002\u0010h\u001a\u00020i2\b\b\u0002\u0010j\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010qJÈ\u0001\u0010O\u001a\u00020P2\u0006\u0010r\u001a\u00020W2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0006\u0010o\u001a\u00020%2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010tJ#\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/H\u0007¢\u0006\u0004\bu\u0010vJ\u009b\u0001\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/H\u0007¢\u0006\u0004\bw\u0010xJ\u0087\u0001\u00101\u001a\u0002022\b\b\u0002\u0010y\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010z\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/H\u0007¢\u0006\u0004\b{\u0010|R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u0007R\u0013\u0010\u000e\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006}²\u0006\n\u0010~\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "<init>", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "ShadowElevation", "getShadowElevation-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "inputFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getInputFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "dockedShape", "getDockedShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "fullScreenWindowInsets", "getFullScreenWindowInsets", "enterAlwaysSearchBarScrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "reverseLayout", "(FFLkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarScrollBehavior;", "colors", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "focusedTextColor", "unfocusedTextColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "inputFieldColors-JVEmHcM", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "InputField", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "searchBarState", "Landroidx/compose/material3/SearchBarState;", "onSearch", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "placeholder", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "prefix", "suffix", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", RemoteConfigConstants.ResponseFieldKey.STATE, "expanded", "onExpandedChange", "(Landroidx/compose/foundation/text/input/TextFieldState;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", SearchIntents.EXTRA_QUERY, "onQueryChange", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "colors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "textColor", "placeholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3", "focused"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBarDefaults {
    public static final int $stable = 0;
    private static final float Elevation;
    public static final SearchBarDefaults INSTANCE = new SearchBarDefaults();
    private static final float InputFieldHeight;
    private static final float ShadowElevation;
    private static final float TonalElevation;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$20(SearchBarDefaults searchBarDefaults, TextFieldState textFieldState, SearchBarState searchBarState, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, InputTransformation inputTransformation, OutputTransformation outputTransformation, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        searchBarDefaults.InputField(textFieldState, searchBarState, function1, modifier, z, z2, textStyle, function2, function22, function23, function24, function25, inputTransformation, outputTransformation, scrollState, shape, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$33(SearchBarDefaults searchBarDefaults, TextFieldState textFieldState, Function1 function1, boolean z, Function1 function12, Modifier modifier, boolean z2, boolean z3, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, InputTransformation inputTransformation, OutputTransformation outputTransformation, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        searchBarDefaults.InputField(textFieldState, function1, z, function12, modifier, z2, z3, textStyle, function2, function22, function23, function24, function25, inputTransformation, outputTransformation, scrollState, shape, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$44(SearchBarDefaults searchBarDefaults, String str, Function1 function1, Function1 function12, boolean z, Function1 function13, Modifier modifier, boolean z2, Function2 function2, Function2 function22, Function2 function23, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        searchBarDefaults.InputField(str, function1, function12, z, function13, modifier, z2, function2, function22, function23, textFieldColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean enterAlwaysSearchBarScrollBehavior$lambda$1$lambda$0() {
        return true;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(expression = "TonalElevation", imports = {}))
    /* renamed from: getElevation-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m2410getElevationD9Ej5fM$annotations() {
    }

    private SearchBarDefaults() {
    }

    static {
        float m3359getLevel0D9Ej5fM = ElevationTokens.INSTANCE.m3359getLevel0D9Ej5fM();
        TonalElevation = m3359getLevel0D9Ej5fM;
        ShadowElevation = ElevationTokens.INSTANCE.m3359getLevel0D9Ej5fM();
        Elevation = m3359getLevel0D9Ej5fM;
        InputFieldHeight = SearchBarTokens.INSTANCE.m3705getContainerHeightD9Ej5fM();
    }

    /* renamed from: getTonalElevation-D9Ej5fM  reason: not valid java name */
    public final float m2416getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* renamed from: getShadowElevation-D9Ej5fM  reason: not valid java name */
    public final float m2415getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m2413getElevationD9Ej5fM() {
        return Elevation;
    }

    /* renamed from: getInputFieldHeight-D9Ej5fM  reason: not valid java name */
    public final float m2414getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    public final Shape getInputFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1770571533, "C(<get-inputFieldShape>)1039@46188L5:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1770571533, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.kt:1039)");
        }
        Shape value = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFullScreenShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2009956471, "C(<get-fullScreenShape>)1043@46362L5:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2009956471, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.kt:1043)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getDockedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1447354121, "C(<get-dockedShape>)1047@46512L5:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1447354121, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.kt:1047)");
        }
        Shape value = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1795925906, "C(<get-windowInsets>)1053@46670L29:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1795925906, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.kt:1053)");
        }
        WindowInsets m891onlybOOhFvg = WindowInsetsKt.m891onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, composer, 6), WindowInsetsSides.m903plusgK_yJZ4(WindowInsetsSides.Companion.m913getHorizontalJoeWqyM(), WindowInsetsSides.Companion.m917getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m891onlybOOhFvg;
    }

    public final WindowInsets getFullScreenWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1745169224, "C(<get-fullScreenWindowInsets>)1059@46961L11:SearchBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1745169224, i, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenWindowInsets> (SearchBar.kt:1059)");
        }
        WindowInsets safeDrawing = WindowInsets_androidKt.getSafeDrawing(WindowInsets.Companion, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return safeDrawing;
    }

    public final SearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior(float f, float f2, Function0<Boolean> function0, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, boolean z, Composer composer, int i, int i2) {
        Function0<Boolean> function02;
        ComposerKt.sourceInformationMarkerStart(composer, 1222500790, "C(enterAlwaysSearchBarScrollBehavior)N(initialOffset,initialOffsetLimit,canScroll,snapAnimationSpec,flingAnimationSpec,reverseLayout)1088@48597L8,1090@48770L7,1091@48835L26,1105@49345L375,1094@48944L776:SearchBar.kt#uh7d8r");
        float f3 = (i2 & 1) != 0 ? 0.0f : f;
        float f4 = (i2 & 2) != 0 ? -3.4028235E38f : f2;
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1997773186, "CC(remember):SearchBar.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(SearchBarDefaults.enterAlwaysSearchBarScrollBehavior$lambda$1$lambda$0());
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            function02 = (Function0) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        } else {
            function02 = function0;
        }
        FiniteAnimationSpec value = (i2 & 8) != 0 ? MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6) : animationSpec;
        DecayAnimationSpec<Float> rememberSplineBasedDecay = (i2 & 16) != 0 ? SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0) : decayAnimationSpec;
        boolean z2 = (i2 & 32) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1222500790, i, -1, "androidx.compose.material3.SearchBarDefaults.enterAlwaysSearchBarScrollBehavior (SearchBar.kt:1094)");
        }
        Object[] objArr = {value, rememberSplineBasedDecay, function02, Boolean.valueOf(z2)};
        Saver<EnterAlwaysSearchBarScrollBehavior, ?> Saver = EnterAlwaysSearchBarScrollBehavior.Companion.Saver(function02, value, rememberSplineBasedDecay);
        ComposerKt.sourceInformationMarkerStart(composer, -1997748883, "CC(remember):SearchBar.kt#9igjgp");
        boolean z3 = true;
        boolean z4 = ((((i & 14) ^ 6) > 4 && composer.changed(f3)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f4)) || (i & 48) == 32) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(function02)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
        if ((((458752 & i) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) <= 131072 || !composer.changed(z2)) && (i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 131072) {
            z3 = false;
        }
        boolean changedInstance = z4 | z3 | composer.changedInstance(value) | composer.changedInstance(rememberSplineBasedDecay);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            final float f5 = f3;
            final float f6 = f4;
            final Function0<Boolean> function03 = function02;
            final AnimationSpec<Float> animationSpec2 = value;
            final DecayAnimationSpec<Float> decayAnimationSpec2 = rememberSplineBasedDecay;
            final boolean z5 = z2;
            rememberedValue2 = new Function0() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SearchBarDefaults.enterAlwaysSearchBarScrollBehavior$lambda$3$lambda$2(f5, f6, function03, z5, animationSpec2, decayAnimationSpec2);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior = (EnterAlwaysSearchBarScrollBehavior) RememberSaveableKt.m4213rememberSaveable(objArr, Saver, (Function0<? extends Object>) rememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return enterAlwaysSearchBarScrollBehavior;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior$lambda$3$lambda$2(float f, float f2, Function0 function0, boolean z, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec) {
        return new EnterAlwaysSearchBarScrollBehavior(f, f2, function0, z, animationSpec, decayAnimationSpec);
    }

    /* renamed from: colors-Klgx-Pg  reason: not valid java name */
    public final SearchBarColors m2411colorsKlgxPg(long j, long j2, TextFieldColors textFieldColors, Composer composer, int i, int i2) {
        int i3;
        long j3;
        TextFieldColors textFieldColors2;
        ComposerKt.sourceInformationMarkerStart(composer, 701925149, "C(colors)N(containerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color,inputFieldColors)1128@50345L5,1129@50412L5,1131@50475L202:SearchBar.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer, 6) : j2;
        if ((i2 & 4) != 0) {
            j3 = value;
            i3 = i;
            textFieldColors2 = m2419inputFieldColorsJVEmHcM(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, j3, j3, j3, composer, 0, 0, (i & 14) | ((i << 3) & 112) | ((i << 6) & 896) | (i & 7168), 1048575);
        } else {
            i3 = i;
            j3 = value;
            textFieldColors2 = textFieldColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(701925149, i3, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:1137)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(j3, value2, textFieldColors2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarColors;
    }

    /* renamed from: inputFieldColors-JVEmHcM  reason: not valid java name */
    public final TextFieldColors m2419inputFieldColorsJVEmHcM(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -2000124979, "C(inputFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color,focusedPrefixColor:c#ui.graphics.Color,unfocusedPrefixColor:c#ui.graphics.Color,disabledPrefixColor:c#ui.graphics.Color,focusedSuffixColor:c#ui.graphics.Color,unfocusedSuffixColor:c#ui.graphics.Color,disabledSuffixColor:c#ui.graphics.Color,focusedContainerColor:c#ui.graphics.Color,unfocusedContainerColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color)1178@53452L5,1179@53526L5,1181@53621L5,1184@53777L5,1185@53856L7,1186@53939L5,1187@54022L5,1189@54130L5,1192@54306L5,1193@54391L5,1195@54501L5,1198@54679L5,1199@54765L5,1201@54867L5,1204@55036L5,1205@55120L5,1207@55215L5,1210@55384L5,1211@55468L5,1213@55563L5,1216@55727L5,1217@55806L5,1218@55884L5,1220@55942L1360:SearchBar.kt#uh7d8r");
        long value = (i4 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j;
        long value2 = (i4 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j2;
        long m4771copywmQWz5c$default = (i4 & 4) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i4 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j4;
        if ((i4 & 16) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i4 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j5;
        long value5 = (i4 & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j6;
        long m4771copywmQWz5c$default2 = (i4 & 128) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long value6 = (i4 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j8;
        long value7 = (i4 & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j9;
        long m4771copywmQWz5c$default3 = (i4 & 1024) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long value8 = (i4 & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j11;
        long value9 = (i4 & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j12;
        long m4771copywmQWz5c$default4 = (i4 & 8192) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long value10 = (i4 & 16384) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j14;
        long value11 = (32768 & i4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6) : j15;
        long m4771copywmQWz5c$default5 = (65536 & i4) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long value12 = (131072 & i4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j17;
        long value13 = (262144 & i4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6) : j18;
        long m4771copywmQWz5c$default6 = (524288 & i4) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long value14 = (1048576 & i4) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j20;
        long value15 = (2097152 & i4) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j21;
        long value16 = (i4 & 4194304) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j22;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2000124979, i, i2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1220)");
        }
        int i5 = i3 << 12;
        int i6 = i2 << 3;
        int i7 = i2 << 18;
        int i8 = i2 >> 24;
        TextFieldColors m2692colors0hiis_0 = TextFieldDefaults.INSTANCE.m2692colors0hiis_0(value, value2, m4771copywmQWz5c$default, 0L, value14, value15, value16, 0L, value3, 0L, textSelectionColors2, 0L, 0L, 0L, 0L, value4, value5, m4771copywmQWz5c$default2, 0L, value6, value7, m4771copywmQWz5c$default3, 0L, 0L, 0L, 0L, 0L, value8, value9, m4771copywmQWz5c$default4, 0L, 0L, 0L, 0L, 0L, value10, value11, m4771copywmQWz5c$default5, 0L, value12, value13, m4771copywmQWz5c$default6, 0L, composer, (i & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (i5 & 57344) | (i5 & 458752) | (i5 & 3670016) | ((i << 15) & 234881024), ((i >> 12) & 14) | (i & 458752) | (i & 3670016) | (i & 29360128) | ((i << 3) & 1879048192), ((i >> 27) & 14) | (i6 & 112) | (i7 & 29360128) | (i7 & 234881024) | (i7 & 1879048192), (33488896 & i6) | ((i2 << 6) & 1879048192), (i8 & 14) | 3072 | (i8 & 112), 1204058760, 2191);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2692colors0hiis_0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x01dd, code lost:
        if (r15.changed(r131) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0613, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L213;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05fe  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0637  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0877  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x087a  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0880  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0947  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x096d  */
    /* JADX WARN: Removed duplicated region for block: B:399:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
    /* JADX WARN: Type inference failed for: r1v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void InputField(final TextFieldState textFieldState, final SearchBarState searchBarState, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, InputTransformation inputTransformation, OutputTransformation outputTransformation, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        TextStyle textStyle2;
        int i7;
        Object obj2;
        int i8;
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
        int i20;
        int i21;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final ScrollState scrollState2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier2;
        final boolean z5;
        final boolean z6;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final InputTransformation inputTransformation2;
        final OutputTransformation outputTransformation2;
        ScopeUpdateScope endRestartGroup;
        boolean z7;
        TextStyle textStyle4;
        InputTransformation inputTransformation3;
        OutputTransformation outputTransformation3;
        ScrollState scrollState3;
        Shape shape3;
        TextFieldColors textFieldColors3;
        int i22;
        final TextFieldColors textFieldColors4;
        int i23;
        Modifier modifier3;
        boolean z8;
        TextStyle textStyle5;
        int i24;
        Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Shape shape4;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape5;
        boolean z9;
        final SearchBarState searchBarState2;
        Function1<KeyEvent, Boolean> function12;
        float f;
        boolean changed;
        Modifier modifier4;
        boolean changed2;
        Object rememberedValue;
        boolean z10;
        Object rememberedValue2;
        final TextFieldState textFieldState2;
        Modifier modifier5;
        TextFieldDefaults textFieldDefaults;
        SolidColor solidColor;
        ComposableLambda rememberComposableLambda;
        ComposableLambda rememberComposableLambda2;
        boolean changedInstance;
        Object rememberedValue3;
        final SearchBarState searchBarState3;
        boolean changed3;
        SearchBarDefaults$InputField$9$1 rememberedValue4;
        TextFieldState textFieldState3;
        State<Boolean> state;
        boolean isExpanded;
        boolean z11;
        boolean isExpanded2;
        boolean changed4;
        SearchBarDefaults$InputField$10$1 rememberedValue5;
        Composer startRestartGroup = composer.startRestartGroup(759286022);
        ComposerKt.sourceInformation(startRestartGroup, "C(InputField)N(textFieldState,searchBarState,onSearch,modifier,enabled,readOnly,textStyle,placeholder,leadingIcon,trailingIcon,prefix,suffix,inputTransformation,outputTransformation,scrollState,shape,colors,interactionSource)1323@62121L25,1324@62192L7,1325@62250L7,1327@62318L34,1328@62397L39,1336@62701L24,1342@62874L721,1360@63845L199,1365@64076L244,1377@64667L44,1402@65952L645,1383@64973L1643,1338@62735L3892,1421@66956L148,1421@66904L200,1428@67216L736,1428@67169L783,1446@68100L113,1446@68058L155:SearchBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(searchBarState) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i25 = i3 & 8;
        if (i25 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            i5 = i3 & 16;
            int i26 = 16384;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                z3 = z;
                i4 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    z4 = z2;
                } else {
                    z4 = z2;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                    }
                }
                if ((i & 1572864) == 0) {
                    textStyle2 = textStyle;
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(textStyle2)) ? 1048576 : 524288;
                } else {
                    textStyle2 = textStyle;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    obj2 = function2;
                } else {
                    Object obj3 = function2;
                    obj2 = obj3;
                    if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(obj3) ? 8388608 : 4194304;
                        obj2 = obj3;
                    }
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i9 = i8;
                    i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                    i10 = i3 & 512;
                    if (i10 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i11 = i10;
                        i4 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i12 = i3 & 1024;
                        if (i12 != 0) {
                            i14 = i2 | 6;
                            i13 = i12;
                        } else if ((i2 & 6) == 0) {
                            i13 = i12;
                            i14 = i2 | (startRestartGroup.changedInstance(function24) ? 4 : 2);
                        } else {
                            i13 = i12;
                            i14 = i2;
                        }
                        i15 = i3 & 2048;
                        if (i15 != 0) {
                            i14 |= 48;
                            i16 = i15;
                        } else if ((i2 & 48) == 0) {
                            i16 = i15;
                            i14 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
                        } else {
                            i16 = i15;
                        }
                        int i27 = i14;
                        i17 = i3 & 4096;
                        if (i17 != 0) {
                            i18 = i27 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else {
                            int i28 = i27;
                            if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                i28 |= startRestartGroup.changed(inputTransformation) ? 256 : 128;
                            }
                            i18 = i28;
                        }
                        i19 = i3 & 8192;
                        if (i19 != 0) {
                            i20 = i18 | 3072;
                        } else {
                            i20 = i18;
                            if ((i2 & 3072) == 0) {
                                i20 |= startRestartGroup.changed(outputTransformation) ? 2048 : 1024;
                                if ((i2 & 24576) == 0) {
                                    if ((i3 & 16384) != 0) {
                                    }
                                    i26 = 8192;
                                    i20 |= i26;
                                }
                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i20 |= ((i3 & 32768) == 0 && startRestartGroup.changed(shape)) ? 131072 : 65536;
                                }
                                if ((i2 & 1572864) == 0) {
                                    i20 |= ((i3 & 65536) == 0 && startRestartGroup.changed(textFieldColors)) ? 1048576 : 524288;
                                }
                                i21 = i3 & 131072;
                                if (i21 == 0) {
                                    i20 |= 12582912;
                                } else if ((i2 & 12582912) == 0) {
                                    i20 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                                }
                                if ((i3 & 262144) == 0) {
                                    i20 |= 100663296;
                                } else if ((i2 & 100663296) == 0) {
                                    i20 |= startRestartGroup.changed(this) ? 67108864 : 33554432;
                                }
                                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 38347923) != 38347922, i4 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "1298@60882L7,1306@61310L21,1307@61356L15,1308@61407L18");
                                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 64) != 0) {
                                            i4 &= -3670017;
                                        }
                                        if ((i3 & 16384) != 0) {
                                            i20 &= -57345;
                                        }
                                        if ((32768 & i3) != 0) {
                                            i20 &= -458753;
                                        }
                                        if ((i3 & 65536) != 0) {
                                            i20 &= -3670017;
                                        }
                                        function213 = function23;
                                        function215 = function25;
                                        inputTransformation3 = inputTransformation;
                                        outputTransformation3 = outputTransformation;
                                        scrollState3 = scrollState;
                                        shape4 = shape;
                                        modifier3 = obj;
                                        z8 = z3;
                                        z7 = z4;
                                        textStyle5 = textStyle2;
                                        function211 = obj2;
                                        i23 = i20;
                                        function212 = function22;
                                        function214 = function24;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        i24 = i4;
                                        textFieldColors4 = textFieldColors;
                                    } else {
                                        Modifier.Companion companion = i25 != 0 ? Modifier.Companion : obj;
                                        boolean z12 = i5 != 0 ? true : z3;
                                        z7 = i6 != 0 ? false : z4;
                                        if ((i3 & 64) != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            i4 &= -3670017;
                                            textStyle4 = (TextStyle) consume;
                                        } else {
                                            textStyle4 = textStyle2;
                                        }
                                        int i29 = i4;
                                        Function2<? super Composer, ? super Integer, Unit> function216 = i7 != 0 ? null : obj2;
                                        Function2<? super Composer, ? super Integer, Unit> function217 = i9 != 0 ? null : function22;
                                        Function2<? super Composer, ? super Integer, Unit> function218 = i11 != 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function219 = i13 != 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function220 = i16 != 0 ? null : function25;
                                        inputTransformation3 = i17 != 0 ? null : inputTransformation;
                                        outputTransformation3 = i19 != 0 ? null : outputTransformation;
                                        if ((i3 & 16384) != 0) {
                                            i20 &= -57345;
                                            scrollState3 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                        } else {
                                            scrollState3 = scrollState;
                                        }
                                        if ((32768 & i3) != 0) {
                                            i20 &= -458753;
                                            shape3 = getInputFieldShape(startRestartGroup, (i20 >> 24) & 14);
                                        } else {
                                            shape3 = shape;
                                        }
                                        int i30 = i20;
                                        if ((i3 & 65536) != 0) {
                                            textFieldColors3 = m2419inputFieldColorsJVEmHcM(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, (i30 >> 15) & 7168, 8388607);
                                            startRestartGroup = startRestartGroup;
                                            i22 = i30 & (-3670017);
                                        } else {
                                            textFieldColors3 = textFieldColors;
                                            i22 = i30;
                                        }
                                        textFieldColors4 = textFieldColors3;
                                        i23 = i22;
                                        modifier3 = companion;
                                        z8 = z12;
                                        textStyle5 = textStyle4;
                                        i24 = i29;
                                        function211 = function216;
                                        function212 = function217;
                                        function213 = function218;
                                        function214 = function219;
                                        function215 = function220;
                                        shape4 = shape3;
                                        mutableInteractionSource3 = i21 != 0 ? null : mutableInteractionSource;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(759286022, i24, i23, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1310)");
                                    }
                                    if (mutableInteractionSource3 == null) {
                                        startRestartGroup.startReplaceGroup(-1701839691);
                                        ComposerKt.sourceInformation(startRestartGroup, "1312@61585L39");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -470540051, "CC(remember):SearchBar.kt#9igjgp");
                                        Object rememberedValue6 = startRestartGroup.rememberedValue();
                                        if (rememberedValue6 == Composer.Companion.getEmpty()) {
                                            rememberedValue6 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue6);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = (MutableInteractionSource) rememberedValue6;
                                    } else {
                                        startRestartGroup.startReplaceGroup(-470540702);
                                        startRestartGroup.endReplaceGroup();
                                        mutableInteractionSource4 = mutableInteractionSource3;
                                    }
                                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                    Function2<? super Composer, ? super Integer, Unit> function221 = function211;
                                    final State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource5, startRestartGroup, 0);
                                    Function2<? super Composer, ? super Integer, Unit> function222 = function214;
                                    Function2<? super Composer, ? super Integer, Unit> function223 = function215;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final FocusManager focusManager = (FocusManager) consume2;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalInputModeManager());
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final boolean m5578equalsimpl0 = InputMode.m5578equalsimpl0(((InputModeManager) consume3).mo5584getInputModeaOaMEAU(), InputMode.Companion.m5583getTouchaOaMEAU());
                                    Strings.Companion companion2 = Strings.Companion;
                                    final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_search_bar_search), startRestartGroup, 0);
                                    Strings.Companion companion3 = Strings.Companion;
                                    int i31 = i23;
                                    final String m3088getString2EP1pXo2 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_suggestions_available), startRestartGroup, 0);
                                    long m7033getColor0d7_KjU = textStyle5.m7033getColor0d7_KjU();
                                    if (m7033getColor0d7_KjU != 16) {
                                        shape5 = shape4;
                                    } else {
                                        shape5 = shape4;
                                        m7033getColor0d7_KjU = textFieldColors4.m2679textColorXeAY9LY$material3(z8, false, InputField$lambda$5(collectIsFocusedAsState));
                                    }
                                    TextStyle merge = textStyle5.merge(new TextStyle(m7033getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
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
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -470498121, "CC(remember):SearchBar.kt#9igjgp");
                                    int i32 = i24 & 112;
                                    TextStyle textStyle6 = textStyle5;
                                    boolean changed5 = startRestartGroup.changed(m5578equalsimpl0) | (i32 == 32) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(focusManager);
                                    Object rememberedValue8 = startRestartGroup.rememberedValue();
                                    if (changed5) {
                                        z9 = z8;
                                    } else {
                                        z9 = z8;
                                        if (rememberedValue8 != Composer.Companion.getEmpty()) {
                                            function12 = rememberedValue8;
                                            searchBarState2 = searchBarState;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier onPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(modifier3, (Function1) function12);
                                            float searchBarMinWidth = SearchBarKt.getSearchBarMinWidth();
                                            f = SearchBarKt.SearchBarMaxWidth;
                                            Modifier m868sizeInqDBjuR0$default = SizeKt.m868sizeInqDBjuR0$default(onPreviewKeyEvent, searchBarMinWidth, InputFieldHeight, f, 0.0f, 8, null);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -470467571, "CC(remember):SearchBar.kt#9igjgp");
                                            changed = startRestartGroup.changed(m5578equalsimpl0) | startRestartGroup.changedInstance(coroutineScope) | (i32 != 32);
                                            Object rememberedValue9 = startRestartGroup.rememberedValue();
                                            if (changed) {
                                                modifier4 = modifier3;
                                            } else {
                                                modifier4 = modifier3;
                                            }
                                            rememberedValue9 = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda13
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Object invoke(Object obj4) {
                                                    return SearchBarDefaults.InputField$lambda$9$lambda$8(m5578equalsimpl0, coroutineScope, searchBarState2, (FocusState) obj4);
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue9);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(m868sizeInqDBjuR0$default, (Function1) rememberedValue9);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -470460134, "CC(remember):SearchBar.kt#9igjgp");
                                            changed2 = startRestartGroup.changed(m3088getString2EP1pXo) | (i32 != 32) | startRestartGroup.changed(m3088getString2EP1pXo2);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            if (!changed2 || rememberedValue == Composer.Companion.getEmpty()) {
                                                rememberedValue = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda14
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Object invoke(Object obj4) {
                                                        return SearchBarDefaults.InputField$lambda$11$lambda$10(m3088getString2EP1pXo, searchBarState2, m3088getString2EP1pXo2, (SemanticsPropertyReceiver) obj4);
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier semantics$default = SemanticsModifierKt.semantics$default(onFocusChanged, false, (Function1) rememberedValue, 1, null);
                                            TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                                            SolidColor solidColor2 = new SolidColor(textFieldColors4.m2629cursorColorvNxB06k$material3(false), null);
                                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.m7190getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -470441422, "CC(remember):SearchBar.kt#9igjgp");
                                            int i33 = i24 & 14;
                                            int i34 = i24;
                                            z10 = ((i24 & 896) != 256) | (i33 != 4);
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (!z10 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                                textFieldState2 = textFieldState;
                                                rememberedValue2 = new KeyboardActionHandler() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda1
                                                    @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                                                    public final void onKeyboardAction(Function0 function0) {
                                                        Function1.this.invoke(textFieldState2.getText().toString());
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            } else {
                                                textFieldState2 = textFieldState;
                                            }
                                            KeyboardActionHandler keyboardActionHandler = rememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                                            TextFieldLineLimits.SingleLine singleLine2 = TextFieldLineLimits.SingleLine.INSTANCE;
                                            if (function212 != null) {
                                                startRestartGroup.startReplaceGroup(-1698078028);
                                                startRestartGroup.endReplaceGroup();
                                                modifier5 = semantics$default;
                                                textFieldDefaults = textFieldDefaults2;
                                                solidColor = solidColor2;
                                                rememberComposableLambda = null;
                                            } else {
                                                startRestartGroup.startReplaceGroup(-1698078027);
                                                ComposerKt.sourceInformation(startRestartGroup, "*1392@65419L64");
                                                modifier5 = semantics$default;
                                                textFieldDefaults = textFieldDefaults2;
                                                solidColor = solidColor2;
                                                startRestartGroup.endReplaceGroup();
                                                rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(759038428, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$5$1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i35) {
                                                        float f2;
                                                        ComposerKt.sourceInformation(composer3, "C1392@65421L60:SearchBar.kt#uh7d8r");
                                                        if (composer3.shouldExecute((i35 & 3) != 2, i35 & 1)) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(759038428, i35, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous> (SearchBar.kt:1392)");
                                                            }
                                                            f2 = SearchBarKt.SearchBarIconOffsetX;
                                                            Modifier m778offsetVpY3zN4$default = OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, f2, 0.0f, 2, null);
                                                            Function2<Composer, Integer, Unit> function224 = function212;
                                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m778offsetVpY3zN4$default);
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
                                                            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer3, -1668617416, "C1392@65470L9:SearchBar.kt#uh7d8r");
                                                            function224.invoke(composer3, 0);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            composer3.endNode();
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }, startRestartGroup, 54);
                                            }
                                            if (function213 != null) {
                                                startRestartGroup.startReplaceGroup(-1697869615);
                                                startRestartGroup.endReplaceGroup();
                                                rememberComposableLambda2 = null;
                                            } else {
                                                startRestartGroup.startReplaceGroup(-1697869614);
                                                ComposerKt.sourceInformation(startRestartGroup, "*1396@65630L66");
                                                rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(55642171, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$6$1
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i35) {
                                                        float f2;
                                                        ComposerKt.sourceInformation(composer3, "C1396@65632L62:SearchBar.kt#uh7d8r");
                                                        if (!composer3.shouldExecute((i35 & 3) != 2, i35 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(55642171, i35, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous> (SearchBar.kt:1396)");
                                                        }
                                                        f2 = SearchBarKt.SearchBarIconOffsetX;
                                                        Modifier m778offsetVpY3zN4$default = OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-f2), 0.0f, 2, null);
                                                        Function2<Composer, Integer, Unit> function224 = function213;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m778offsetVpY3zN4$default);
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
                                                        Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1401072488, "C1396@65682L10:SearchBar.kt#uh7d8r");
                                                        function224.invoke(composer3, 0);
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
                                                }, startRestartGroup, 54);
                                                startRestartGroup.endReplaceGroup();
                                            }
                                            final Shape shape6 = shape5;
                                            final boolean z13 = z9;
                                            Shape shape7 = shape5;
                                            TextFieldColors textFieldColors5 = textFieldColors4;
                                            Composer composer3 = startRestartGroup;
                                            Function2<? super Composer, ? super Integer, Unit> function224 = function212;
                                            Function2<? super Composer, ? super Integer, Unit> function225 = function213;
                                            boolean z14 = z9;
                                            Modifier modifier6 = modifier4;
                                            OutputTransformation outputTransformation4 = outputTransformation3;
                                            TextFieldDefaults textFieldDefaults3 = textFieldDefaults;
                                            int i35 = i34 >> 6;
                                            boolean z15 = z7;
                                            InputTransformation inputTransformation4 = inputTransformation3;
                                            ScrollState scrollState4 = scrollState3;
                                            Modifier modifier7 = modifier5;
                                            BasicTextFieldKt.BasicTextField(textFieldState, modifier7, z14, z15, inputTransformation4, merge, keyboardOptions, keyboardActionHandler, singleLine, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, mutableInteractionSource6, solidColor, outputTransformation4, textFieldDefaults3.decorator(textFieldState2, z14, singleLine2, outputTransformation4, mutableInteractionSource5, null, null, function221, rememberComposableLambda, rememberComposableLambda2, function222, function223, null, false, textFieldColors5, TextFieldDefaults.m2682contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableLambdaKt.rememberComposableLambda(1500441906, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$7
                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i36) {
                                                    boolean InputField$lambda$5;
                                                    ComposerKt.sourceInformation(composer4, "C1411@66449L7,1404@66027L460,1413@66512L63:SearchBar.kt#uh7d8r");
                                                    if (!composer4.shouldExecute((i36 & 3) != 2, i36 & 1)) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1500441906, i36, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.kt:1403)");
                                                    }
                                                    TextFieldColors textFieldColors6 = TextFieldColors.this;
                                                    boolean z16 = z13;
                                                    InputField$lambda$5 = SearchBarDefaults.InputField$lambda$5(collectIsFocusedAsState);
                                                    BoxKt.Box(TextFieldImplKt.textFieldBackground(Modifier.Companion, new SearchBarKt$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(SingleValueAnimationKt.m134animateColorAsStateeuL9pac(textFieldColors6.m2627containerColorXeAY9LY$material3(z16, false, InputField$lambda$5), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer4, 6), null, null, composer4, 0, 12)) { // from class: androidx.compose.material3.SearchBarDefaults$InputField$7.1
                                                        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                                                        public Object get() {
                                                            return ((State) this.receiver).getValue();
                                                        }
                                                    }), shape6), composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, startRestartGroup, 54), composer3, i33 | RendererCapabilities.DECODER_SUPPORT_MASK | ((i34 >> 9) & 112) | (i31 & 7168) | (i34 & 29360128), (i31 & 14) | 14155776 | (i31 & 112) | ((i31 >> 6) & 57344), 12384), scrollState4, composer3, 102236160 | i33 | (i35 & 896) | (i35 & 7168) | (57344 & (i31 << 6)), ((i31 >> 3) & 896) | (i31 & 57344), 512);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -470368070, "CC(remember):SearchBar.kt#9igjgp");
                                            changedInstance = (i32 != 32) | composer3.changedInstance(coroutineScope);
                                            rememberedValue3 = composer3.rememberedValue();
                                            if (!changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                                                searchBarState3 = searchBarState;
                                                rememberedValue3 = new Function0() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda2
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return SearchBarDefaults.InputField$lambda$17$lambda$16(SearchBarState.this, coroutineScope);
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue3);
                                            } else {
                                                searchBarState3 = searchBarState;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            SearchBarKt.DetectClickFromInteractionSource(mutableInteractionSource5, (Function0) rememberedValue3, composer3, 0);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -470359162, "CC(remember):SearchBar.kt#9igjgp");
                                            changed3 = (i32 != 32) | (i33 != 4) | composer3.changed(collectIsFocusedAsState) | composer3.changedInstance(coroutineScope);
                                            rememberedValue4 = composer3.rememberedValue();
                                            if (!changed3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                                textFieldState3 = textFieldState;
                                                state = collectIsFocusedAsState;
                                                rememberedValue4 = new SearchBarDefaults$InputField$9$1(searchBarState3, textFieldState, coroutineScope, collectIsFocusedAsState, null);
                                                composer3.updateRememberedValue(rememberedValue4);
                                            } else {
                                                textFieldState3 = textFieldState;
                                                state = collectIsFocusedAsState;
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            EffectsKt.LaunchedEffect(searchBarState3, textFieldState3, (Function2) rememberedValue4, composer3, ((i34 >> 3) & 14) | ((i34 << 3) & 112));
                                            isExpanded = SearchBarKt.isExpanded(searchBarState3);
                                            z11 = isExpanded && InputField$lambda$5(state) && m5578equalsimpl0;
                                            isExpanded2 = SearchBarKt.isExpanded(searchBarState3);
                                            Boolean valueOf = Boolean.valueOf(isExpanded2);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -470331497, "CC(remember):SearchBar.kt#9igjgp");
                                            changed4 = composer3.changed(z11) | composer3.changedInstance(focusManager);
                                            rememberedValue5 = composer3.rememberedValue();
                                            if (!changed4 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                                rememberedValue5 = new SearchBarDefaults$InputField$10$1(z11, focusManager, null);
                                                composer3.updateRememberedValue(rememberedValue5);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue5, composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            z5 = z14;
                                            z6 = z15;
                                            scrollState2 = scrollState4;
                                            composer2 = composer3;
                                            textFieldColors2 = textFieldColors5;
                                            mutableInteractionSource2 = mutableInteractionSource3;
                                            modifier2 = modifier6;
                                            textStyle3 = textStyle6;
                                            function28 = function221;
                                            function26 = function224;
                                            function29 = function225;
                                            function27 = function223;
                                            shape2 = shape7;
                                            inputTransformation2 = inputTransformation4;
                                            outputTransformation2 = outputTransformation4;
                                            function210 = function222;
                                        }
                                    }
                                    searchBarState2 = searchBarState;
                                    Function1<KeyEvent, Boolean> function13 = new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$1$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                            return m2420invokeZmokQxo(keyEvent.m5917unboximpl());
                                        }

                                        /* renamed from: invoke-ZmokQxo  reason: not valid java name */
                                        public final Boolean m2420invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                            boolean isExpanded3;
                                            boolean isExpanded4;
                                            if (!m5578equalsimpl0) {
                                                isExpanded4 = SearchBarKt.isExpanded(searchBarState2);
                                                if (!isExpanded4 && Key.m5620equalsimpl0(KeyEvent_androidKt.m5928getKeyZmokQxo(keyEvent), Key.Companion.m5693getDirectionDownEK5gGoQ())) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(searchBarState2, null), 3, null);
                                                    return true;
                                                }
                                            }
                                            isExpanded3 = SearchBarKt.isExpanded(searchBarState2);
                                            if (isExpanded3 && Key.m5620equalsimpl0(KeyEvent_androidKt.m5928getKeyZmokQxo(keyEvent), Key.Companion.m5693getDirectionDownEK5gGoQ())) {
                                                focusManager.mo4416moveFocus3ESFkO8(FocusDirection.Companion.m4406getDowndhqQ8s());
                                                return true;
                                            }
                                            return false;
                                        }

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* compiled from: SearchBar.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material3.SearchBarDefaults$InputField$1$1$1", f = "SearchBar.kt", i = {}, l = {1346}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material3.SearchBarDefaults$InputField$1$1$1  reason: invalid class name */
                                        /* loaded from: classes.dex */
                                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ SearchBarState $searchBarState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(SearchBarState searchBarState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$searchBarState = searchBarState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$searchBarState, continuation);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    this.label = 1;
                                                    if (this.$searchBarState.animateToExpanded(this) == coroutine_suspended) {
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
                                    };
                                    startRestartGroup.updateRememberedValue(function13);
                                    function12 = function13;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Modifier onPreviewKeyEvent2 = KeyInputModifierKt.onPreviewKeyEvent(modifier3, (Function1) function12);
                                    float searchBarMinWidth2 = SearchBarKt.getSearchBarMinWidth();
                                    f = SearchBarKt.SearchBarMaxWidth;
                                    Modifier m868sizeInqDBjuR0$default2 = SizeKt.m868sizeInqDBjuR0$default(onPreviewKeyEvent2, searchBarMinWidth2, InputFieldHeight, f, 0.0f, 8, null);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -470467571, "CC(remember):SearchBar.kt#9igjgp");
                                    changed = startRestartGroup.changed(m5578equalsimpl0) | startRestartGroup.changedInstance(coroutineScope) | (i32 != 32);
                                    Object rememberedValue92 = startRestartGroup.rememberedValue();
                                    if (changed) {
                                    }
                                    rememberedValue92 = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda13
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj4) {
                                            return SearchBarDefaults.InputField$lambda$9$lambda$8(m5578equalsimpl0, coroutineScope, searchBarState2, (FocusState) obj4);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue92);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Modifier onFocusChanged2 = FocusChangedModifierKt.onFocusChanged(m868sizeInqDBjuR0$default2, (Function1) rememberedValue92);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -470460134, "CC(remember):SearchBar.kt#9igjgp");
                                    changed2 = startRestartGroup.changed(m3088getString2EP1pXo) | (i32 != 32) | startRestartGroup.changed(m3088getString2EP1pXo2);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!changed2) {
                                    }
                                    rememberedValue = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj4) {
                                            return SearchBarDefaults.InputField$lambda$11$lambda$10(m3088getString2EP1pXo, searchBarState2, m3088getString2EP1pXo2, (SemanticsPropertyReceiver) obj4);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Modifier semantics$default2 = SemanticsModifierKt.semantics$default(onFocusChanged2, false, (Function1) rememberedValue, 1, null);
                                    TextFieldLineLimits.SingleLine singleLine3 = TextFieldLineLimits.SingleLine.INSTANCE;
                                    SolidColor solidColor22 = new SolidColor(textFieldColors4.m2629cursorColorvNxB06k$material3(false), null);
                                    KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.m7190getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -470441422, "CC(remember):SearchBar.kt#9igjgp");
                                    int i332 = i24 & 14;
                                    int i342 = i24;
                                    z10 = ((i24 & 896) != 256) | (i332 != 4);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (z10) {
                                    }
                                    textFieldState2 = textFieldState;
                                    rememberedValue2 = new KeyboardActionHandler() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda1
                                        @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                                        public final void onKeyboardAction(Function0 function0) {
                                            Function1.this.invoke(textFieldState2.getText().toString());
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                    KeyboardActionHandler keyboardActionHandler2 = rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    TextFieldDefaults textFieldDefaults22 = TextFieldDefaults.INSTANCE;
                                    TextFieldLineLimits.SingleLine singleLine22 = TextFieldLineLimits.SingleLine.INSTANCE;
                                    if (function212 != null) {
                                    }
                                    if (function213 != null) {
                                    }
                                    final Shape shape62 = shape5;
                                    final boolean z132 = z9;
                                    Shape shape72 = shape5;
                                    TextFieldColors textFieldColors52 = textFieldColors4;
                                    Composer composer32 = startRestartGroup;
                                    Function2<? super Composer, ? super Integer, Unit> function2242 = function212;
                                    Function2<? super Composer, ? super Integer, Unit> function2252 = function213;
                                    boolean z142 = z9;
                                    Modifier modifier62 = modifier4;
                                    OutputTransformation outputTransformation42 = outputTransformation3;
                                    TextFieldDefaults textFieldDefaults32 = textFieldDefaults;
                                    int i352 = i342 >> 6;
                                    boolean z152 = z7;
                                    InputTransformation inputTransformation42 = inputTransformation3;
                                    ScrollState scrollState42 = scrollState3;
                                    Modifier modifier72 = modifier5;
                                    BasicTextFieldKt.BasicTextField(textFieldState, modifier72, z142, z152, inputTransformation42, merge, keyboardOptions2, keyboardActionHandler2, singleLine3, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, mutableInteractionSource6, solidColor, outputTransformation42, textFieldDefaults32.decorator(textFieldState2, z142, singleLine22, outputTransformation42, mutableInteractionSource5, null, null, function221, rememberComposableLambda, rememberComposableLambda2, function222, function223, null, false, textFieldColors52, TextFieldDefaults.m2682contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableLambdaKt.rememberComposableLambda(1500441906, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$7
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i36) {
                                            boolean InputField$lambda$5;
                                            ComposerKt.sourceInformation(composer4, "C1411@66449L7,1404@66027L460,1413@66512L63:SearchBar.kt#uh7d8r");
                                            if (!composer4.shouldExecute((i36 & 3) != 2, i36 & 1)) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1500441906, i36, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.kt:1403)");
                                            }
                                            TextFieldColors textFieldColors6 = TextFieldColors.this;
                                            boolean z16 = z132;
                                            InputField$lambda$5 = SearchBarDefaults.InputField$lambda$5(collectIsFocusedAsState);
                                            BoxKt.Box(TextFieldImplKt.textFieldBackground(Modifier.Companion, new SearchBarKt$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(SingleValueAnimationKt.m134animateColorAsStateeuL9pac(textFieldColors6.m2627containerColorXeAY9LY$material3(z16, false, InputField$lambda$5), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer4, 6), null, null, composer4, 0, 12)) { // from class: androidx.compose.material3.SearchBarDefaults$InputField$7.1
                                                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                                                public Object get() {
                                                    return ((State) this.receiver).getValue();
                                                }
                                            }), shape62), composer4, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, startRestartGroup, 54), composer32, i332 | RendererCapabilities.DECODER_SUPPORT_MASK | ((i342 >> 9) & 112) | (i31 & 7168) | (i342 & 29360128), (i31 & 14) | 14155776 | (i31 & 112) | ((i31 >> 6) & 57344), 12384), scrollState42, composer32, 102236160 | i332 | (i352 & 896) | (i352 & 7168) | (57344 & (i31 << 6)), ((i31 >> 3) & 896) | (i31 & 57344), 512);
                                    ComposerKt.sourceInformationMarkerStart(composer32, -470368070, "CC(remember):SearchBar.kt#9igjgp");
                                    changedInstance = (i32 != 32) | composer32.changedInstance(coroutineScope);
                                    rememberedValue3 = composer32.rememberedValue();
                                    if (changedInstance) {
                                    }
                                    searchBarState3 = searchBarState;
                                    rememberedValue3 = new Function0() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return SearchBarDefaults.InputField$lambda$17$lambda$16(SearchBarState.this, coroutineScope);
                                        }
                                    };
                                    composer32.updateRememberedValue(rememberedValue3);
                                    ComposerKt.sourceInformationMarkerEnd(composer32);
                                    SearchBarKt.DetectClickFromInteractionSource(mutableInteractionSource5, (Function0) rememberedValue3, composer32, 0);
                                    ComposerKt.sourceInformationMarkerStart(composer32, -470359162, "CC(remember):SearchBar.kt#9igjgp");
                                    changed3 = (i32 != 32) | (i332 != 4) | composer32.changed(collectIsFocusedAsState) | composer32.changedInstance(coroutineScope);
                                    rememberedValue4 = composer32.rememberedValue();
                                    if (changed3) {
                                    }
                                    textFieldState3 = textFieldState;
                                    state = collectIsFocusedAsState;
                                    rememberedValue4 = new SearchBarDefaults$InputField$9$1(searchBarState3, textFieldState, coroutineScope, collectIsFocusedAsState, null);
                                    composer32.updateRememberedValue(rememberedValue4);
                                    ComposerKt.sourceInformationMarkerEnd(composer32);
                                    EffectsKt.LaunchedEffect(searchBarState3, textFieldState3, (Function2) rememberedValue4, composer32, ((i342 >> 3) & 14) | ((i342 << 3) & 112));
                                    isExpanded = SearchBarKt.isExpanded(searchBarState3);
                                    if (isExpanded) {
                                    }
                                    isExpanded2 = SearchBarKt.isExpanded(searchBarState3);
                                    Boolean valueOf2 = Boolean.valueOf(isExpanded2);
                                    ComposerKt.sourceInformationMarkerStart(composer32, -470331497, "CC(remember):SearchBar.kt#9igjgp");
                                    changed4 = composer32.changed(z11) | composer32.changedInstance(focusManager);
                                    rememberedValue5 = composer32.rememberedValue();
                                    if (!changed4) {
                                    }
                                    rememberedValue5 = new SearchBarDefaults$InputField$10$1(z11, focusManager, null);
                                    composer32.updateRememberedValue(rememberedValue5);
                                    ComposerKt.sourceInformationMarkerEnd(composer32);
                                    EffectsKt.LaunchedEffect(valueOf2, (Function2) rememberedValue5, composer32, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    z5 = z142;
                                    z6 = z152;
                                    scrollState2 = scrollState42;
                                    composer2 = composer32;
                                    textFieldColors2 = textFieldColors52;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    modifier2 = modifier62;
                                    textStyle3 = textStyle6;
                                    function28 = function221;
                                    function26 = function2242;
                                    function29 = function2252;
                                    function27 = function223;
                                    shape2 = shape72;
                                    inputTransformation2 = inputTransformation42;
                                    outputTransformation2 = outputTransformation42;
                                    function210 = function222;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    function26 = function22;
                                    function27 = function25;
                                    scrollState2 = scrollState;
                                    shape2 = shape;
                                    textFieldColors2 = textFieldColors;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    modifier2 = obj;
                                    z5 = z3;
                                    z6 = z4;
                                    textStyle3 = textStyle2;
                                    function28 = obj2;
                                    composer2 = startRestartGroup;
                                    function29 = function23;
                                    function210 = function24;
                                    inputTransformation2 = inputTransformation;
                                    outputTransformation2 = outputTransformation;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj4, Object obj5) {
                                            return SearchBarDefaults.InputField$lambda$20(SearchBarDefaults.this, textFieldState, searchBarState, function1, modifier2, z5, z6, textStyle3, function28, function26, function29, function210, function27, inputTransformation2, outputTransformation2, scrollState2, shape2, textFieldColors2, mutableInteractionSource2, i, i2, i3, (Composer) obj4, ((Integer) obj5).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        if ((i2 & 1572864) == 0) {
                        }
                        i21 = i3 & 131072;
                        if (i21 == 0) {
                        }
                        if ((i3 & 262144) == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 38347923) != 38347922, i4 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i11 = i10;
                    i12 = i3 & 1024;
                    if (i12 != 0) {
                    }
                    i15 = i3 & 2048;
                    if (i15 != 0) {
                    }
                    int i272 = i14;
                    i17 = i3 & 4096;
                    if (i17 != 0) {
                    }
                    i19 = i3 & 8192;
                    if (i19 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    if ((i2 & 1572864) == 0) {
                    }
                    i21 = i3 & 131072;
                    if (i21 == 0) {
                    }
                    if ((i3 & 262144) == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 38347923) != 38347922, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i9 = i8;
                i10 = i3 & 512;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i3 & 1024;
                if (i12 != 0) {
                }
                i15 = i3 & 2048;
                if (i15 != 0) {
                }
                int i2722 = i14;
                i17 = i3 & 4096;
                if (i17 != 0) {
                }
                i19 = i3 & 8192;
                if (i19 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if ((i2 & 1572864) == 0) {
                }
                i21 = i3 & 131072;
                if (i21 == 0) {
                }
                if ((i3 & 262144) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 38347923) != 38347922, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i3 & 1024;
            if (i12 != 0) {
            }
            i15 = i3 & 2048;
            if (i15 != 0) {
            }
            int i27222 = i14;
            i17 = i3 & 4096;
            if (i17 != 0) {
            }
            i19 = i3 & 8192;
            if (i19 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            i21 = i3 & 131072;
            if (i21 == 0) {
            }
            if ((i3 & 262144) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 38347923) != 38347922, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i5 = i3 & 16;
        int i262 = 16384;
        if (i5 == 0) {
        }
        z3 = z;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3 & 512;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i3 & 1024;
        if (i12 != 0) {
        }
        i15 = i3 & 2048;
        if (i15 != 0) {
        }
        int i272222 = i14;
        i17 = i3 & 4096;
        if (i17 != 0) {
        }
        i19 = i3 & 8192;
        if (i19 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        i21 = i3 & 131072;
        if (i21 == 0) {
        }
        if ((i3 & 262144) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 38347923) != 38347922, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$9$lambda$8(boolean z, CoroutineScope coroutineScope, SearchBarState searchBarState, FocusState focusState) {
        if (focusState.isFocused() && z) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarDefaults$InputField$2$1$1(searchBarState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$11$lambda$10(String str, SearchBarState searchBarState, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        boolean isExpanded;
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        isExpanded = SearchBarKt.isExpanded(searchBarState);
        if (isExpanded) {
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$17$lambda$16(SearchBarState searchBarState, CoroutineScope coroutineScope) {
        boolean isExpanded;
        isExpanded = SearchBarKt.isExpanded(searchBarState);
        if (!isExpanded) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SearchBarDefaults$InputField$8$1$1(searchBarState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0859  */
    /* JADX WARN: Removed duplicated region for block: B:370:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /* JADX WARN: Type inference failed for: r13v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void InputField(final TextFieldState textFieldState, final Function1<? super String, Unit> function1, final boolean z, final Function1<? super Boolean, Unit> function12, Modifier modifier, boolean z2, boolean z3, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, InputTransformation inputTransformation, OutputTransformation outputTransformation, ScrollState scrollState, Shape shape, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        TextStyle textStyle2;
        int i7;
        Object obj;
        int i8;
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
        int i20;
        int i21;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final OutputTransformation outputTransformation2;
        final ScrollState scrollState2;
        final Shape shape2;
        final TextFieldColors textFieldColors2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z6;
        final boolean z7;
        final TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final InputTransformation inputTransformation2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        boolean z8;
        TextStyle textStyle4;
        InputTransformation inputTransformation3;
        ScrollState scrollState3;
        Shape shape3;
        TextFieldColors textFieldColors3;
        int i22;
        MutableInteractionSource mutableInteractionSource3;
        final TextFieldColors textFieldColors4;
        int i23;
        final boolean z9;
        TextStyle textStyle5;
        Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        OutputTransformation outputTransformation3;
        final Shape shape4;
        MutableInteractionSource mutableInteractionSource4;
        float f;
        MutableInteractionSource mutableInteractionSource5;
        TextFieldDefaults textFieldDefaults;
        Function2<? super Composer, ? super Integer, Unit> function216;
        ComposableLambda rememberComposableLambda;
        Function2<? super Composer, ? super Integer, Unit> function217;
        ComposableLambda rememberComposableLambda2;
        int i24;
        Composer startRestartGroup = composer.startRestartGroup(1994562483);
        ComposerKt.sourceInformation(startRestartGroup, "C(InputField)N(state,onSearch,expanded,onExpandedChange,modifier,enabled,readOnly,textStyle,placeholder,leadingIcon,trailingIcon,prefix,suffix,inputTransformation,outputTransformation,scrollState,shape,colors,interactionSource)1524@72733L25,1525@72794L29,1526@72869L7,1528@72908L34,1529@72987L39,1547@73662L44,1548@73738L227,1560@74312L35,1585@75579L645,1566@74609L1634,1537@73270L2984,1602@76341L320,1602@76316L345:SearchBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        int i25 = i3 & 16;
        if (i25 != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 16384 : 8192;
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z4 = z2;
            } else {
                z4 = z2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                }
            }
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
                z5 = z3;
            } else {
                z5 = z3;
                if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                }
            }
            if ((i & 12582912) != 0) {
                if ((i3 & 128) == 0) {
                    textStyle2 = textStyle;
                    if (startRestartGroup.changed(textStyle2)) {
                        i24 = 8388608;
                        i4 |= i24;
                    }
                } else {
                    textStyle2 = textStyle;
                }
                i24 = 4194304;
                i4 |= i24;
            } else {
                textStyle2 = textStyle;
            }
            i7 = i3 & 256;
            if (i7 == 0) {
                i4 |= 100663296;
                obj = function2;
            } else {
                Object obj2 = function2;
                obj = obj2;
                if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changedInstance(obj2) ? 67108864 : 33554432;
                    obj = obj2;
                }
            }
            i8 = i3 & 512;
            if (i8 == 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                i9 = i8;
                i4 |= startRestartGroup.changedInstance(function22) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                i10 = i3 & 1024;
                if (i10 != 0) {
                    i12 = i2 | 6;
                    i11 = i10;
                } else if ((i2 & 6) == 0) {
                    i11 = i10;
                    i12 = i2 | (startRestartGroup.changedInstance(function23) ? 4 : 2);
                } else {
                    i11 = i10;
                    i12 = i2;
                }
                i13 = i3 & 2048;
                if (i13 != 0) {
                    i12 |= 48;
                    i14 = i13;
                } else if ((i2 & 48) == 0) {
                    i14 = i13;
                    i12 |= startRestartGroup.changedInstance(function24) ? 32 : 16;
                } else {
                    i14 = i13;
                }
                int i26 = i12;
                i15 = i3 & 4096;
                if (i15 != 0) {
                    i16 = i26 | RendererCapabilities.DECODER_SUPPORT_MASK;
                } else {
                    int i27 = i26;
                    if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                        i27 |= startRestartGroup.changedInstance(function25) ? 256 : 128;
                    }
                    i16 = i27;
                }
                i17 = i3 & 8192;
                if (i17 != 0) {
                    i18 = i16 | 3072;
                } else {
                    int i28 = i16;
                    if ((i2 & 3072) == 0) {
                        i28 |= startRestartGroup.changed(inputTransformation) ? 2048 : 1024;
                    }
                    i18 = i28;
                }
                i19 = i3 & 16384;
                if (i19 != 0) {
                    i20 = i18 | 24576;
                } else {
                    i20 = i18;
                    if ((i2 & 24576) == 0) {
                        i20 |= startRestartGroup.changed(outputTransformation) ? 16384 : 8192;
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i20 |= ((i3 & 32768) == 0 && startRestartGroup.changed(scrollState)) ? 131072 : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            i20 |= ((i3 & 65536) == 0 && startRestartGroup.changed(shape)) ? 1048576 : 524288;
                        }
                        if ((i2 & 12582912) == 0) {
                            i20 |= ((i3 & 131072) == 0 && startRestartGroup.changed(textFieldColors)) ? 8388608 : 4194304;
                        }
                        i21 = i3 & 262144;
                        if (i21 == 0) {
                            i20 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i20 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i3 & 524288) == 0) {
                            i20 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i20 |= startRestartGroup.changed(this) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        }
                        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 306783379) != 306783378, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "1508@71949L7,1516@72377L21,1517@72423L15,1518@72474L18");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((32768 & i3) != 0) {
                                    i20 &= -458753;
                                }
                                if ((i3 & 65536) != 0) {
                                    i20 &= -3670017;
                                }
                                if ((i3 & 131072) != 0) {
                                    i20 &= -29360129;
                                }
                                companion = modifier;
                                function212 = function22;
                                function215 = function25;
                                inputTransformation3 = inputTransformation;
                                outputTransformation3 = outputTransformation;
                                scrollState3 = scrollState;
                                shape4 = shape;
                                textFieldColors4 = textFieldColors;
                                mutableInteractionSource3 = mutableInteractionSource;
                                z9 = z4;
                                z8 = z5;
                                textStyle5 = textStyle2;
                                function211 = obj;
                                i23 = i20;
                                function213 = function23;
                                function214 = function24;
                            } else {
                                companion = i25 != 0 ? Modifier.Companion : modifier;
                                boolean z10 = i5 != 0 ? true : z4;
                                z8 = i6 != 0 ? false : z5;
                                if ((i3 & 128) != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(TextKt.getLocalTextStyle());
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    i4 &= -29360129;
                                    textStyle4 = (TextStyle) consume;
                                } else {
                                    textStyle4 = textStyle2;
                                }
                                int i29 = i4;
                                Function2<? super Composer, ? super Integer, Unit> function218 = i7 != 0 ? null : obj;
                                Function2<? super Composer, ? super Integer, Unit> function219 = i9 != 0 ? null : function22;
                                Function2<? super Composer, ? super Integer, Unit> function220 = i11 != 0 ? null : function23;
                                Function2<? super Composer, ? super Integer, Unit> function221 = i14 != 0 ? null : function24;
                                Function2<? super Composer, ? super Integer, Unit> function222 = i15 != 0 ? null : function25;
                                inputTransformation3 = i17 != 0 ? null : inputTransformation;
                                OutputTransformation outputTransformation4 = i19 != 0 ? null : outputTransformation;
                                if ((32768 & i3) != 0) {
                                    i20 &= -458753;
                                    scrollState3 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                } else {
                                    scrollState3 = scrollState;
                                }
                                if ((i3 & 65536) != 0) {
                                    i20 &= -3670017;
                                    shape3 = getInputFieldShape(startRestartGroup, (i20 >> 27) & 14);
                                } else {
                                    shape3 = shape;
                                }
                                int i30 = i20;
                                if ((i3 & 131072) != 0) {
                                    textFieldColors3 = m2419inputFieldColorsJVEmHcM(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, (i30 >> 18) & 7168, 8388607);
                                    startRestartGroup = startRestartGroup;
                                    i22 = i30 & (-29360129);
                                } else {
                                    textFieldColors3 = textFieldColors;
                                    i22 = i30;
                                }
                                if (i21 != 0) {
                                    textFieldColors4 = textFieldColors3;
                                    i23 = i22;
                                    z9 = z10;
                                    textStyle5 = textStyle4;
                                    i4 = i29;
                                    function211 = function218;
                                    function212 = function219;
                                    function213 = function220;
                                    function214 = function221;
                                    function215 = function222;
                                    outputTransformation3 = outputTransformation4;
                                    shape4 = shape3;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    textFieldColors4 = textFieldColors3;
                                    i23 = i22;
                                    z9 = z10;
                                    textStyle5 = textStyle4;
                                    i4 = i29;
                                    function211 = function218;
                                    function212 = function219;
                                    function213 = function220;
                                    function214 = function221;
                                    function215 = function222;
                                    outputTransformation3 = outputTransformation4;
                                    shape4 = shape3;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1994562483, i4, i23, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1520)");
                            }
                            if (mutableInteractionSource3 == null) {
                                startRestartGroup.startReplaceGroup(-860559352);
                                ComposerKt.sourceInformation(startRestartGroup, "1522@72652L39");
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219166010, "CC(remember):SearchBar.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                            } else {
                                startRestartGroup.startReplaceGroup(1219165359);
                                startRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                            MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                            final boolean booleanValue = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource6, startRestartGroup, 0).getValue().booleanValue();
                            OutputTransformation outputTransformation5 = outputTransformation3;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219170544, "CC(remember):SearchBar.kt#9igjgp");
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            Function2<? super Composer, ? super Integer, Unit> function223 = function211;
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new FocusRequester();
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            FocusRequester focusRequester = (FocusRequester) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i31 = i23;
                            Function2<? super Composer, ? super Integer, Unit> function224 = function214;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            FocusManager focusManager = (FocusManager) consume2;
                            Strings.Companion companion2 = Strings.Companion;
                            final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_search_bar_search), startRestartGroup, 0);
                            Strings.Companion companion3 = Strings.Companion;
                            final String m3088getString2EP1pXo2 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_suggestions_available), startRestartGroup, 0);
                            long m7033getColor0d7_KjU = textStyle5.m7033getColor0d7_KjU();
                            if (m7033getColor0d7_KjU == 16) {
                                m7033getColor0d7_KjU = textFieldColors4.m2679textColorXeAY9LY$material3(z9, false, booleanValue);
                            }
                            TextStyle merge = textStyle5.merge(new TextStyle(m7033getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                            float searchBarMinWidth = SearchBarKt.getSearchBarMinWidth();
                            f = SearchBarKt.SearchBarMaxWidth;
                            Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(SizeKt.m868sizeInqDBjuR0$default(companion, searchBarMinWidth, InputFieldHeight, f, 0.0f, 8, null), focusRequester);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219198335, "CC(remember):SearchBar.kt#9igjgp");
                            TextStyle textStyle6 = textStyle5;
                            boolean z11 = (i4 & 7168) == 2048;
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (z11 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj3) {
                                        return SearchBarDefaults.InputField$lambda$25$lambda$24(Function1.this, (FocusState) obj3);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(focusRequester2, (Function1) rememberedValue3);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219200950, "CC(remember):SearchBar.kt#9igjgp");
                            int i32 = i4;
                            boolean changed = ((i4 & 896) == 256) | startRestartGroup.changed(m3088getString2EP1pXo) | startRestartGroup.changed(m3088getString2EP1pXo2);
                            Object rememberedValue4 = startRestartGroup.rememberedValue();
                            if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda10
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj3) {
                                        return SearchBarDefaults.InputField$lambda$27$lambda$26(m3088getString2EP1pXo, z, m3088getString2EP1pXo2, (SemanticsPropertyReceiver) obj3);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(onFocusChanged, false, (Function1) rememberedValue4, 1, null);
                            TextFieldLineLimits.SingleLine singleLine = TextFieldLineLimits.SingleLine.INSTANCE;
                            Function2<? super Composer, ? super Integer, Unit> function225 = function215;
                            SolidColor solidColor = new SolidColor(textFieldColors4.m2629cursorColorvNxB06k$material3(false), null);
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.m7190getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1219219126, "CC(remember):SearchBar.kt#9igjgp");
                            int i33 = i32 & 14;
                            boolean z12 = ((i32 & 112) == 32) | (i33 == 4);
                            Object rememberedValue5 = startRestartGroup.rememberedValue();
                            if (z12 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                mutableInteractionSource5 = mutableInteractionSource6;
                                rememberedValue5 = new KeyboardActionHandler() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda11
                                    @Override // androidx.compose.foundation.text.input.KeyboardActionHandler
                                    public final void onKeyboardAction(Function0 function0) {
                                        Function1.this.invoke(textFieldState.getText().toString());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            } else {
                                mutableInteractionSource5 = mutableInteractionSource6;
                            }
                            KeyboardActionHandler keyboardActionHandler = rememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            TextFieldDefaults textFieldDefaults2 = TextFieldDefaults.INSTANCE;
                            TextFieldLineLimits.SingleLine singleLine2 = TextFieldLineLimits.SingleLine.INSTANCE;
                            if (function212 == null) {
                                startRestartGroup.startReplaceGroup(-858226169);
                                startRestartGroup.endReplaceGroup();
                                textFieldDefaults = textFieldDefaults2;
                                function216 = function212;
                                rememberComposableLambda = null;
                            } else {
                                startRestartGroup.startReplaceGroup(-858226168);
                                ComposerKt.sourceInformation(startRestartGroup, "*1575@75046L64");
                                textFieldDefaults = textFieldDefaults2;
                                function216 = function212;
                                startRestartGroup.endReplaceGroup();
                                rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(314348414, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$15$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i34) {
                                        float f2;
                                        ComposerKt.sourceInformation(composer3, "C1575@75048L60:SearchBar.kt#uh7d8r");
                                        if (composer3.shouldExecute((i34 & 3) != 2, i34 & 1)) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(314348414, i34, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous> (SearchBar.kt:1575)");
                                            }
                                            f2 = SearchBarKt.SearchBarIconOffsetX;
                                            Modifier m778offsetVpY3zN4$default = OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, f2, 0.0f, 2, null);
                                            Function2<Composer, Integer, Unit> function226 = function212;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m778offsetVpY3zN4$default);
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
                                            Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1243105442, "C1575@75097L9:SearchBar.kt#uh7d8r");
                                            function226.invoke(composer3, 0);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endNode();
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, startRestartGroup, 54);
                            }
                            if (function213 == null) {
                                startRestartGroup.startReplaceGroup(-858017756);
                                startRestartGroup.endReplaceGroup();
                                function217 = function213;
                                rememberComposableLambda2 = null;
                            } else {
                                startRestartGroup.startReplaceGroup(-858017755);
                                ComposerKt.sourceInformation(startRestartGroup, "*1579@75257L66");
                                function217 = function213;
                                rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(581893311, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$16$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i34) {
                                        float f2;
                                        ComposerKt.sourceInformation(composer3, "C1579@75259L62:SearchBar.kt#uh7d8r");
                                        if (!composer3.shouldExecute((i34 & 3) != 2, i34 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(581893311, i34, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous> (SearchBar.kt:1579)");
                                        }
                                        f2 = SearchBarKt.SearchBarIconOffsetX;
                                        Modifier m778offsetVpY3zN4$default = OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-f2), 0.0f, 2, null);
                                        Function2<Composer, Integer, Unit> function226 = function213;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m778offsetVpY3zN4$default);
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
                                        Updater.m4049setimpl(m4041constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 213830624, "C1579@75309L10:SearchBar.kt#uh7d8r");
                                        function226.invoke(composer3, 0);
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
                                }, startRestartGroup, 54);
                                startRestartGroup.endReplaceGroup();
                            }
                            int i34 = i31 >> 3;
                            TextFieldColors textFieldColors5 = textFieldColors4;
                            Composer composer3 = startRestartGroup;
                            Function2<? super Composer, ? super Integer, Unit> function226 = function216;
                            Function2<? super Composer, ? super Integer, Unit> function227 = function217;
                            Shape shape5 = shape4;
                            TextFieldDefaults textFieldDefaults3 = textFieldDefaults;
                            ComposableLambda composableLambda = rememberComposableLambda2;
                            boolean z13 = z9;
                            TextFieldDecorator decorator = textFieldDefaults3.decorator(textFieldState, z13, singleLine2, outputTransformation5, mutableInteractionSource5, null, null, function223, rememberComposableLambda, composableLambda, function224, function225, null, false, textFieldColors5, TextFieldDefaults.m2682contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableLambdaKt.rememberComposableLambda(-1551441816, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$17
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i35) {
                                    ComposerKt.sourceInformation(composer4, "C1594@76076L7,1587@75654L460,1596@76139L63:SearchBar.kt#uh7d8r");
                                    if (!composer4.shouldExecute((i35 & 3) != 2, i35 & 1)) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1551441816, i35, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.kt:1586)");
                                    }
                                    BoxKt.Box(TextFieldImplKt.textFieldBackground(Modifier.Companion, new SearchBarKt$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(SingleValueAnimationKt.m134animateColorAsStateeuL9pac(TextFieldColors.this.m2627containerColorXeAY9LY$material3(z9, false, booleanValue), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer4, 6), null, null, composer4, 0, 12)) { // from class: androidx.compose.material3.SearchBarDefaults$InputField$17.1
                                        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                                        public Object get() {
                                            return ((State) this.receiver).getValue();
                                        }
                                    }), shape4), composer4, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), composer3, i33 | RendererCapabilities.DECODER_SUPPORT_MASK | ((i32 >> 12) & 112) | (i34 & 7168) | ((i32 >> 3) & 29360128), (i34 & 14) | 14155776 | (i34 & 112) | ((i31 >> 9) & 57344), 12384);
                            textFieldColors2 = textFieldColors5;
                            int i35 = i32 >> 9;
                            int i36 = i33 | 102236160 | (i35 & 896) | (i35 & 7168) | ((i31 << 3) & 57344);
                            int i37 = ((i31 >> 6) & 896) | (i34 & 57344);
                            boolean z14 = z8;
                            InputTransformation inputTransformation4 = inputTransformation3;
                            ScrollState scrollState4 = scrollState3;
                            BasicTextFieldKt.BasicTextField(textFieldState, semantics$default, z13, z14, inputTransformation4, merge, keyboardOptions, keyboardActionHandler, singleLine, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) null, mutableInteractionSource7, solidColor, outputTransformation5, decorator, scrollState4, composer3, i36, i37, 512);
                            boolean z15 = !z && booleanValue;
                            Boolean valueOf = Boolean.valueOf(z);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1219284339, "CC(remember):SearchBar.kt#9igjgp");
                            boolean changed2 = composer3.changed(z15) | composer3.changedInstance(focusManager);
                            SearchBarDefaults$InputField$18$1 rememberedValue6 = composer3.rememberedValue();
                            if (changed2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = new SearchBarDefaults$InputField$18$1(z15, focusManager, null);
                                composer3.updateRememberedValue(rememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue6, composer3, (i32 >> 6) & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z6 = z13;
                            z7 = z14;
                            outputTransformation2 = outputTransformation5;
                            scrollState2 = scrollState4;
                            composer2 = composer3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            modifier2 = companion;
                            textStyle3 = textStyle6;
                            function28 = function223;
                            function26 = function226;
                            function29 = function227;
                            function27 = function224;
                            function210 = function225;
                            shape2 = shape5;
                            inputTransformation2 = inputTransformation4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            function26 = function22;
                            function27 = function24;
                            outputTransformation2 = outputTransformation;
                            scrollState2 = scrollState;
                            shape2 = shape;
                            textFieldColors2 = textFieldColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z6 = z4;
                            z7 = z5;
                            textStyle3 = textStyle2;
                            function28 = obj;
                            composer2 = startRestartGroup;
                            function29 = function23;
                            function210 = function25;
                            inputTransformation2 = inputTransformation;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return SearchBarDefaults.InputField$lambda$33(SearchBarDefaults.this, textFieldState, function1, z, function12, modifier2, z6, z7, textStyle3, function28, function26, function29, function27, function210, inputTransformation2, outputTransformation2, scrollState2, shape2, textFieldColors2, mutableInteractionSource2, i, i2, i3, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                if ((i2 & 1572864) == 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i21 = i3 & 262144;
                if (i21 == 0) {
                }
                if ((i3 & 524288) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 306783379) != 306783378, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            i13 = i3 & 2048;
            if (i13 != 0) {
            }
            int i262 = i12;
            i15 = i3 & 4096;
            if (i15 != 0) {
            }
            i17 = i3 & 8192;
            if (i17 != 0) {
            }
            i19 = i3 & 16384;
            if (i19 != 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i21 = i3 & 262144;
            if (i21 == 0) {
            }
            if ((i3 & 524288) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 306783379) != 306783378, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i7 = i3 & 256;
        if (i7 == 0) {
        }
        i8 = i3 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        i13 = i3 & 2048;
        if (i13 != 0) {
        }
        int i2622 = i12;
        i15 = i3 & 4096;
        if (i15 != 0) {
        }
        i17 = i3 & 8192;
        if (i17 != 0) {
        }
        i19 = i3 & 16384;
        if (i19 != 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i21 = i3 & 262144;
        if (i21 == 0) {
        }
        if ((i3 & 524288) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i20 & 306783379) != 306783378, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$25$lambda$24(Function1 function1, FocusState focusState) {
        if (focusState.isFocused()) {
            function1.invoke(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$27$lambda$26(String str, boolean z, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        if (z) {
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /* JADX WARN: Type inference failed for: r5v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void InputField(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Object obj;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final TextFieldColors textFieldColors2;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Modifier modifier2;
        final boolean z3;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Composer composer3;
        TextFieldColors textFieldColors3;
        int i16;
        TextFieldColors textFieldColors4;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        Function2<? super Composer, ? super Integer, Unit> function29;
        MutableInteractionSource mutableInteractionSource4;
        float f;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(748018311);
        ComposerKt.sourceInformation(startRestartGroup, "C(InputField)N(query,onQueryChange,onSearch,expanded,onExpandedChange,modifier,enabled,placeholder,leadingIcon,trailingIcon,colors,interactionSource)1659@79407L25,1660@79468L29,1661@79543L7,1663@79582L34,1664@79661L39,1667@79753L7,1682@80316L44,1683@80392L227,1691@80722L7,1694@80976L19,1697@81105L1935,1671@79881L3170,1737@83138L320,1737@83113L345:SearchBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                obj = modifier;
            } else {
                Object obj2 = modifier;
                obj = obj2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                    obj = obj2;
                }
            }
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i4 |= startRestartGroup.changed(z2) ? 1048576 : 524288;
            }
            i7 = i3 & 128;
            if (i7 == 0) {
                i4 |= 12582912;
                function24 = function2;
            } else {
                Function2<? super Composer, ? super Integer, Unit> function210 = function2;
                function24 = function210;
                if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function210) ? 8388608 : 4194304;
                    function24 = function210;
                }
            }
            i8 = i3 & 256;
            if (i8 == 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i9 = i8;
                i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                i10 = i3 & 512;
                if (i10 != 0) {
                    i4 |= 805306368;
                } else if ((i & 805306368) == 0) {
                    i11 = i10;
                    i4 |= startRestartGroup.changedInstance(function23) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0 && startRestartGroup.changed(textFieldColors)) {
                            i17 = 4;
                            i12 = i2 | i17;
                        }
                        i17 = 2;
                        i12 = i2 | i17;
                    } else {
                        i12 = i2;
                    }
                    i13 = i3 & 2048;
                    if (i13 == 0) {
                        i12 |= 48;
                        i14 = i13;
                    } else {
                        i14 = i13;
                        if ((i2 & 48) == 0) {
                            i12 |= startRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
                        }
                    }
                    i15 = i12;
                    if ((i3 & 4096) == 0) {
                        i15 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                    } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                        i15 |= startRestartGroup.changed(this) ? 256 : 128;
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 147) != 146, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "1653@79148L18");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 1024) != 0) {
                                    i15 &= -15;
                                }
                                function28 = function22;
                                function29 = function23;
                                mutableInteractionSource3 = mutableInteractionSource;
                                composer3 = startRestartGroup;
                                companion = obj;
                                z4 = z2;
                                i16 = i15;
                                textFieldColors4 = textFieldColors;
                            } else {
                                companion = i5 != 0 ? Modifier.Companion : obj;
                                boolean z5 = i6 != 0 ? true : z2;
                                if (i7 != 0) {
                                    function24 = null;
                                }
                                function28 = i9 != 0 ? null : function22;
                                Function2<? super Composer, ? super Integer, Unit> function211 = i11 != 0 ? null : function23;
                                if ((i3 & 1024) != 0) {
                                    textFieldColors3 = m2419inputFieldColorsJVEmHcM(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, (i15 << 3) & 7168, 8388607);
                                    composer3 = startRestartGroup;
                                    i15 &= -15;
                                } else {
                                    composer3 = startRestartGroup;
                                    textFieldColors3 = textFieldColors;
                                }
                                boolean z6 = z5;
                                i16 = i15;
                                textFieldColors4 = textFieldColors3;
                                z4 = z6;
                                if (i14 != 0) {
                                    function29 = function211;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    function29 = function211;
                                }
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(748018311, i4, i16, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1655)");
                            }
                            if (mutableInteractionSource3 == null) {
                                composer3.startReplaceGroup(1923851092);
                                ComposerKt.sourceInformation(composer3, "1657@79326L39");
                                ComposerKt.sourceInformationMarkerStart(composer3, 1586080366, "CC(remember):SearchBar.kt#9igjgp");
                                Object rememberedValue = composer3.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer3.updateRememberedValue(rememberedValue);
                                }
                                mutableInteractionSource4 = (MutableInteractionSource) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(1586079715);
                                composer3.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            Modifier modifier3 = companion;
                            final boolean booleanValue = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, composer3, 0).getValue().booleanValue();
                            ComposerKt.sourceInformationMarkerStart(composer3, 1586084900, "CC(remember):SearchBar.kt#9igjgp");
                            Object rememberedValue2 = composer3.rememberedValue();
                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = new FocusRequester();
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            FocusRequester focusRequester = (FocusRequester) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            final Function2<? super Composer, ? super Integer, Unit> function212 = function29;
                            final Function2<? super Composer, ? super Integer, Unit> function213 = function24;
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = composer3.consume(CompositionLocalsKt.getLocalFocusManager());
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            FocusManager focusManager = (FocusManager) consume;
                            Strings.Companion companion2 = Strings.Companion;
                            final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_search_bar_search), composer3, 0);
                            Strings.Companion companion3 = Strings.Companion;
                            final String m3088getString2EP1pXo2 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(R.string.m3c_suggestions_available), composer3, 0);
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = composer3.consume(TextKt.getLocalTextStyle());
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            long m7033getColor0d7_KjU = ((TextStyle) consume2).m7033getColor0d7_KjU();
                            if (m7033getColor0d7_KjU == 16) {
                                m7033getColor0d7_KjU = textFieldColors4.m2679textColorXeAY9LY$material3(z4, false, booleanValue);
                            }
                            long j = m7033getColor0d7_KjU;
                            float searchBarMinWidth = SearchBarKt.getSearchBarMinWidth();
                            f = SearchBarKt.SearchBarMaxWidth;
                            Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(SizeKt.m868sizeInqDBjuR0$default(modifier3, searchBarMinWidth, InputFieldHeight, f, 0.0f, 8, null), focusRequester);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1586112051, "CC(remember):SearchBar.kt#9igjgp");
                            boolean z7 = (57344 & i4) == 16384;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (z7 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                rememberedValue3 = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj3) {
                                        return SearchBarDefaults.InputField$lambda$38$lambda$37(Function1.this, (FocusState) obj3);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(focusRequester2, (Function1) rememberedValue3);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1586114666, "CC(remember):SearchBar.kt#9igjgp");
                            final boolean z8 = z4;
                            boolean changed = ((i4 & 7168) == 2048) | composer3.changed(m3088getString2EP1pXo) | composer3.changed(m3088getString2EP1pXo2);
                            Object rememberedValue4 = composer3.rememberedValue();
                            if (changed || rememberedValue4 == Composer.Companion.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj3) {
                                        return SearchBarDefaults.InputField$lambda$40$lambda$39(m3088getString2EP1pXo, z, m3088getString2EP1pXo2, (SemanticsPropertyReceiver) obj3);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(onFocusChanged, false, (Function1) rememberedValue4, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume3 = composer3.consume(TextKt.getLocalTextStyle());
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            TextStyle merge = ((TextStyle) consume3).merge(new TextStyle(j, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                            SolidColor solidColor = new SolidColor(textFieldColors4.m2629cursorColorvNxB06k$material3(false), null);
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.m7190getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1586133146, "CC(remember):SearchBar.kt#9igjgp");
                            int i18 = i4 & 14;
                            boolean z9 = (i18 == 4) | ((i4 & 896) == 256);
                            Object rememberedValue5 = composer3.rememberedValue();
                            if (z9 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = new Function1() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj3) {
                                        return SearchBarDefaults.InputField$lambda$42$lambda$41(Function1.this, str, (KeyboardActionScope) obj3);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            int i19 = i4;
                            final TextFieldColors textFieldColors5 = textFieldColors4;
                            final Function2<? super Composer, ? super Integer, Unit> function214 = function28;
                            int i20 = i19 >> 9;
                            Composer composer4 = composer3;
                            BasicTextFieldKt.BasicTextField(str, function1, semantics$default, z8, false, merge, keyboardOptions, new KeyboardActions(null, null, null, null, rememberedValue5, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource5, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-813926844, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$23
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function215, Composer composer5, Integer num) {
                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function215, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function215, Composer composer5, int i21) {
                                    int i22;
                                    ComposableLambda rememberComposableLambda;
                                    ComposerKt.sourceInformation(composer5, "CN(innerTextField)1714@82051L15,1717@82234L765,1698@81163L1859:SearchBar.kt#uh7d8r");
                                    if ((i21 & 6) == 0) {
                                        i22 = i21 | (composer5.changedInstance(function215) ? 4 : 2);
                                    } else {
                                        i22 = i21;
                                    }
                                    if (!composer5.shouldExecute((i22 & 19) != 18, i22 & 1)) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-813926844, i22, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous> (SearchBar.kt:1698)");
                                    }
                                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                    String str2 = str;
                                    int i23 = i22;
                                    boolean z10 = z8;
                                    VisualTransformation none = VisualTransformation.Companion.getNone();
                                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                    Function2<Composer, Integer, Unit> function216 = function213;
                                    final Function2<Composer, Integer, Unit> function217 = function214;
                                    ComposableLambda composableLambda = null;
                                    if (function217 == null) {
                                        composer5.startReplaceGroup(1691265870);
                                        composer5.endReplaceGroup();
                                        rememberComposableLambda = null;
                                    } else {
                                        composer5.startReplaceGroup(1691265871);
                                        ComposerKt.sourceInformation(composer5, "*1708@81676L64");
                                        rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1718822048, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$23$1$1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer6, int i24) {
                                                float f2;
                                                ComposerKt.sourceInformation(composer6, "C1708@81678L60:SearchBar.kt#uh7d8r");
                                                if (composer6.shouldExecute((i24 & 3) != 2, i24 & 1)) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1718822048, i24, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.kt:1708)");
                                                    }
                                                    f2 = SearchBarKt.SearchBarIconOffsetX;
                                                    Modifier m778offsetVpY3zN4$default = OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, f2, 0.0f, 2, null);
                                                    Function2<Composer, Integer, Unit> function218 = function217;
                                                    ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer6, m778offsetVpY3zN4$default);
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
                                                    ComposerKt.sourceInformationMarkerStart(composer6, 1796932852, "C1708@81727L9:SearchBar.kt#uh7d8r");
                                                    function218.invoke(composer6, 0);
                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                    composer6.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer6.skipToGroupEnd();
                                            }
                                        }, composer5, 54);
                                        composer5.endReplaceGroup();
                                    }
                                    final Function2<Composer, Integer, Unit> function218 = function212;
                                    if (function218 == null) {
                                        composer5.startReplaceGroup(1691490155);
                                    } else {
                                        composer5.startReplaceGroup(1691490156);
                                        ComposerKt.sourceInformation(composer5, "*1712@81903L66");
                                        composableLambda = ComposableLambdaKt.rememberComposableLambda(-305306680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$23$2$1
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer6, int i24) {
                                                float f2;
                                                ComposerKt.sourceInformation(composer6, "C1712@81905L62:SearchBar.kt#uh7d8r");
                                                if (!composer6.shouldExecute((i24 & 3) != 2, i24 & 1)) {
                                                    composer6.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-305306680, i24, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.kt:1712)");
                                                }
                                                f2 = SearchBarKt.SearchBarIconOffsetX;
                                                Modifier m778offsetVpY3zN4$default = OffsetKt.m778offsetVpY3zN4$default(Modifier.Companion, Dp.m7555constructorimpl(-f2), 0.0f, 2, null);
                                                Function2<Composer, Integer, Unit> function219 = function218;
                                                ComposerKt.sourceInformationMarkerStart(composer6, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composer6, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer6, m778offsetVpY3zN4$default);
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
                                                ComposerKt.sourceInformationMarkerStart(composer6, 1336107703, "C1712@81955L10:SearchBar.kt#uh7d8r");
                                                function219.invoke(composer6, 0);
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
                                        }, composer5, 54);
                                    }
                                    composer5.endReplaceGroup();
                                    Shape inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(composer5, 6);
                                    TextFieldColors textFieldColors6 = textFieldColors5;
                                    PaddingValues m2682contentPaddingWithoutLabela9UjIt4$default = TextFieldDefaults.m2682contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                    final TextFieldColors textFieldColors7 = textFieldColors5;
                                    final boolean z11 = z8;
                                    final boolean z12 = booleanValue;
                                    textFieldDefaults.DecorationBox(str2, function215, z10, true, none, mutableInteractionSource6, false, null, function216, rememberComposableLambda, composableLambda, null, null, null, inputFieldShape, textFieldColors6, m2682contentPaddingWithoutLabela9UjIt4$default, ComposableLambdaKt.rememberComposableLambda(-1197464330, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBarDefaults$InputField$23.3
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer6, int i24) {
                                            ComposerKt.sourceInformation(composer6, "C1726@82767L7,1719@82317L492,1729@82927L15,1728@82838L135:SearchBar.kt#uh7d8r");
                                            if (!composer6.shouldExecute((i24 & 3) != 2, i24 & 1)) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1197464330, i24, -1, "androidx.compose.material3.SearchBarDefaults.InputField.<anonymous>.<anonymous> (SearchBar.kt:1718)");
                                            }
                                            BoxKt.Box(TextFieldImplKt.textFieldBackground(Modifier.Companion, new SearchBarKt$sam$androidx_compose_ui_graphics_ColorProducer$0(new PropertyReference0Impl(SingleValueAnimationKt.m134animateColorAsStateeuL9pac(TextFieldColors.this.m2627containerColorXeAY9LY$material3(z11, false, z12), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer6, 6), null, null, composer6, 0, 12)) { // from class: androidx.compose.material3.SearchBarDefaults.InputField.23.3.1
                                                @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                                                public Object get() {
                                                    return ((State) this.receiver).getValue();
                                                }
                                            }), SearchBarDefaults.INSTANCE.getInputFieldShape(composer6, 6)), composer6, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer5, 54), composer5, ((i23 << 3) & 112) | 27648, 113246208, 14528);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer4, i18 | 102236160 | (i19 & 112) | (i20 & 7168), (int) ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
                            composer2 = composer4;
                            boolean z10 = !z && booleanValue;
                            Boolean valueOf = Boolean.valueOf(z);
                            ComposerKt.sourceInformationMarkerStart(composer2, 1586202631, "CC(remember):SearchBar.kt#9igjgp");
                            boolean changed2 = composer2.changed(z10) | composer2.changedInstance(focusManager);
                            SearchBarDefaults$InputField$24$1 rememberedValue6 = composer2.rememberedValue();
                            if (changed2 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                rememberedValue6 = new SearchBarDefaults$InputField$24$1(z10, focusManager, null);
                                composer2.updateRememberedValue(rememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue6, composer2, i20 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z3 = z8;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            modifier2 = modifier3;
                            textFieldColors2 = textFieldColors5;
                            function27 = function213;
                            function25 = function28;
                            function26 = function212;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            function25 = function22;
                            function26 = function23;
                            textFieldColors2 = textFieldColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            function27 = function24;
                            modifier2 = obj;
                            z3 = z2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SearchBarDefaults$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return SearchBarDefaults.InputField$lambda$44(SearchBarDefaults.this, str, function1, function12, z, function13, modifier2, z3, function27, function25, function26, textFieldColors2, mutableInteractionSource2, i, i2, i3, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 147) != 146, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i11 = i10;
                if ((i2 & 6) != 0) {
                }
                i13 = i3 & 2048;
                if (i13 == 0) {
                }
                i15 = i12;
                if ((i3 & 4096) == 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 147) != 146, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i9 = i8;
            i10 = i3 & 512;
            if (i10 != 0) {
            }
            i11 = i10;
            if ((i2 & 6) != 0) {
            }
            i13 = i3 & 2048;
            if (i13 == 0) {
            }
            i15 = i12;
            if ((i3 & 4096) == 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 147) != 146, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) == 0) {
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
        i9 = i8;
        i10 = i3 & 512;
        if (i10 != 0) {
        }
        i11 = i10;
        if ((i2 & 6) != 0) {
        }
        i13 = i3 & 2048;
        if (i13 == 0) {
        }
        i15 = i12;
        if ((i3 & 4096) == 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i15 & 147) != 146, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$38$lambda$37(Function1 function1, FocusState focusState) {
        if (focusState.isFocused()) {
            function1.invoke(true);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$40$lambda$39(String str, boolean z, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        if (z) {
            SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputField$lambda$42$lambda$41(Function1 function1, String str, KeyboardActionScope keyboardActionScope) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: colors-dgg9oW8  reason: not valid java name */
    public final /* synthetic */ SearchBarColors m2412colorsdgg9oW8(long j, long j2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 891254734, "C(colors)N(containerColor:c#ui.graphics.Color,dividerColor:c#ui.graphics.Color)1750@83659L5,1751@83726L5,1757@83916L218:SearchBar.kt#uh7d8r");
        long value = (i2 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6) : j;
        long value2 = (i2 & 2) != 0 ? ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), composer, 6) : j2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(891254734, i, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:1753)");
        }
        int i3 = i << 3;
        long j3 = value;
        SearchBarColors searchBarColors = new SearchBarColors(j3, value2, m2419inputFieldColorsJVEmHcM(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, j3, j3, j3, composer, 0, 0, ((i << 6) & 896) | (i & 14) | (i3 & 112) | (i3 & 7168), 1048575), null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return searchBarColors;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: inputFieldColors-ITpI4ow  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2418inputFieldColorsITpI4ow(long j, long j2, long j3, long j4, TextSelectionColors textSelectionColors, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, -2048506052, "C(inputFieldColors)N(focusedTextColor:c#ui.graphics.Color,unfocusedTextColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,focusedPlaceholderColor:c#ui.graphics.Color,unfocusedPlaceholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1767@84342L5,1768@84416L5,1770@84511L5,1773@84667L5,1774@84746L7,1775@84829L5,1776@84912L5,1778@85020L5,1781@85196L5,1782@85281L5,1784@85391L5,1787@85569L5,1788@85655L5,1790@85757L5,1809@86804L5,1810@86885L5,1812@86981L5,1815@87155L5,1816@87236L5,1818@87332L5,1821@87501L5,1822@87577L5,1823@87652L5,1794@85884L1784:SearchBar.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j;
        long value2 = (i3 & 2) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j2;
        long m4771copywmQWz5c$default = (i3 & 4) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long value3 = (i3 & 8) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j4;
        if ((i3 & 16) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value4 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j5;
        long value5 = (i3 & 64) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j6;
        long m4771copywmQWz5c$default2 = (i3 & 128) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long value6 = (i3 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j8;
        long value7 = (i3 & 512) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j9;
        long m4771copywmQWz5c$default3 = (i3 & 1024) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long value8 = (i3 & 2048) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j11;
        long value9 = (i3 & 4096) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j12;
        long m4771copywmQWz5c$default4 = (i3 & 8192) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2048506052, i, i2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1794)");
        }
        long j14 = value3;
        long j15 = m4771copywmQWz5c$default;
        long j16 = value4;
        long j17 = value6;
        long j18 = value8;
        long j19 = m4771copywmQWz5c$default2;
        long j20 = m4771copywmQWz5c$default3;
        TextFieldColors m2419inputFieldColorsJVEmHcM = m2419inputFieldColorsJVEmHcM(value, value2, j15, j14, textSelectionColors2, j16, value5, j19, j17, value7, j20, j18, value9, m4771copywmQWz5c$default4, ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6), ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), composer, 6), composer, i & 2147483646, i2 & 8190, (i2 >> 3) & 7168, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2419inputFieldColorsJVEmHcM;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: inputFieldColors--u-KgnY  reason: not valid java name */
    public final /* synthetic */ TextFieldColors m2417inputFieldColorsuKgnY(long j, long j2, long j3, TextSelectionColors textSelectionColors, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i, int i2, int i3) {
        TextSelectionColors textSelectionColors2;
        ComposerKt.sourceInformationMarkerStart(composer, 1842555178, "C(inputFieldColors)N(textColor:c#ui.graphics.Color,disabledTextColor:c#ui.graphics.Color,cursorColor:c#ui.graphics.Color,selectionColors,focusedLeadingIconColor:c#ui.graphics.Color,unfocusedLeadingIconColor:c#ui.graphics.Color,disabledLeadingIconColor:c#ui.graphics.Color,focusedTrailingIconColor:c#ui.graphics.Color,unfocusedTrailingIconColor:c#ui.graphics.Color,disabledTrailingIconColor:c#ui.graphics.Color,placeholderColor:c#ui.graphics.Color,disabledPlaceholderColor:c#ui.graphics.Color)1829@87858L5,1831@87953L5,1834@88109L5,1835@88188L7,1836@88271L5,1837@88354L5,1839@88462L5,1842@88638L5,1843@88723L5,1845@88833L5,1848@89004L5,1850@89106L5,1854@89216L825:SearchBar.kt#uh7d8r");
        long value = (i3 & 1) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), composer, 6) : j;
        long m4771copywmQWz5c$default = (i3 & 2) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long value2 = (i3 & 4) != 0 ? ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), composer, 6) : j3;
        if ((i3 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
            ComposerKt.sourceInformationMarkerEnd(composer);
            textSelectionColors2 = (TextSelectionColors) consume;
        } else {
            textSelectionColors2 = textSelectionColors;
        }
        long value3 = (i3 & 16) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j4;
        long value4 = (i3 & 32) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), composer, 6) : j5;
        long m4771copywmQWz5c$default2 = (i3 & 64) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long value5 = (i3 & 128) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j7;
        long value6 = (i3 & 256) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), composer, 6) : j8;
        long m4771copywmQWz5c$default3 = (i3 & 512) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledTrailingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j9;
        long value7 = (i3 & 1024) != 0 ? ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), composer, 6) : j10;
        long m4771copywmQWz5c$default4 = (i3 & 2048) != 0 ? Color.m4771copywmQWz5c$default(ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getDisabledInputColor(), composer, 6), FilledTextFieldTokens.INSTANCE.getDisabledInputOpacity(), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1842555178, i, i2, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1854)");
        }
        int i4 = i << 3;
        int i5 = i2 << 3;
        int i6 = i2 << 6;
        long j12 = value;
        long j13 = value2;
        long j14 = value3;
        long j15 = value4;
        long j16 = m4771copywmQWz5c$default2;
        long j17 = value6;
        long j18 = value7;
        TextSelectionColors textSelectionColors3 = textSelectionColors2;
        long j19 = value5;
        long j20 = m4771copywmQWz5c$default3;
        TextFieldColors m2419inputFieldColorsJVEmHcM = m2419inputFieldColorsJVEmHcM(j12, j12, m4771copywmQWz5c$default, j13, textSelectionColors3, j14, j15, j16, j19, j17, j20, j18, j18, m4771copywmQWz5c$default4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, (i & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), ((i >> 27) & 14) | (i5 & 112) | (i6 & 896) | (i6 & 7168), i5 & 7168, 8372224);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return m2419inputFieldColorsJVEmHcM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean InputField$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
