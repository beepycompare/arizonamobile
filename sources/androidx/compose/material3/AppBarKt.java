package androidx.compose.material3;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.AppBarLargeFlexibleTokens;
import androidx.compose.material3.tokens.AppBarLargeTokens;
import androidx.compose.material3.tokens.AppBarMediumFlexibleTokens;
import androidx.compose.material3.tokens.AppBarMediumTokens;
import androidx.compose.material3.tokens.AppBarSmallTokens;
import androidx.compose.material3.tokens.AppBarTokens;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000ä\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u007f\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u008b\u0001\u0010\u0017\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0016\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u007f\u0010\u001e\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0095\u0001\u0010\u001e\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b \u0010!\u001a¶\u0001\u0010\"\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b#\u0010$\u001a\u007f\u0010%\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0095\u0001\u0010%\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b&\u0010!\u001a¶\u0001\u0010'\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b(\u0010$\u001aà\u0001\u0010)\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062*\b\u0002\u0010\u0019\u001a$\u0012\u0013\u0012\u00110*¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\b\u00042\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001e\b\u0002\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b.\u0010/\u001a\u0080\u0001\u00100\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b8\u00109\u001a\u008c\u0001\u00100\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:H\u0007¢\u0006\u0004\b;\u0010<\u001ai\u00100\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b>\u0010?\u001au\u00100\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00142\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b@\u0010A\u001a\u007f\u0010B\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0004\bE\u0010F\u001ay\u0010G\u001a\u00020\u00012\u0006\u0010H\u001a\u00020\u00142\u0006\u0010C\u001a\u00020D2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u0002072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010:2\u001c\u0010=\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000bH\u0003¢\u0006\u0004\bI\u0010J\u001a+\u0010K\u001a\u00020L2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020N2\b\b\u0002\u0010P\u001a\u00020NH\u0007¢\u0006\u0002\u0010Q\u001a+\u0010R\u001a\u00020S2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020N2\b\b\u0002\u0010P\u001a\u00020NH\u0007¢\u0006\u0002\u0010T\u001a \u0010U\u001a\u00020S2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NH\u0007\u001a>\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020S2\u0006\u0010Y\u001a\u00020N2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010[2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010]H\u0082@¢\u0006\u0002\u0010^\u001a¬\u0001\u0010f\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\u0006\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\bj\u0010k\u001aô\u0001\u0010)\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0006\u0010s\u001a\u00020\u00142\u0011\u0010t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010u\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\u0013\u0010v\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010w\u001a\u00020h2\u0006\u0010\u001a\u001a\u00020\u001b2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u000b2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\bx\u0010y\u001a\u0016\u0010~\u001a\u00020\u0006*\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u001aá\u0001\u0010\u007f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u0002032\u0007\u0010\u0083\u0001\u001a\u0002032\u0007\u0010\u0084\u0001\u001a\u0002032\u0007\u0010\u0085\u0001\u001a\u0002032\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010g\u001a\u00020h2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00042\u0006\u0010i\u001a\u00020h2\r\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020N0\u00032\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0007\u0010s\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020*2\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0007\u0010\u008b\u0001\u001a\u00020\u0014H\u0003¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a@\u0010\u008e\u0001\u001a\u00020W2\u0006\u0010X\u001a\u00020L2\u0006\u0010Y\u001a\u00020N2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010[2\u000e\u0010\\\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010]H\u0082@¢\u0006\u0003\u0010\u008f\u0001\u001a\u0016\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020*0\u0091\u0001H\u0003¢\u0006\u0003\u0010\u0092\u0001\"\u0010\u0010_\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0016\u0010a\u001a\u00020\u0014X\u0080\u0004¢\u0006\n\n\u0002\u0010`\u001a\u0004\bb\u0010c\"\u0010\u0010d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010e\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\" \u0010l\u001a\b\u0012\u0004\u0012\u00020n0mX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bo\u0010p\u001a\u0004\bq\u0010r\" \u0010z\u001a\b\u0012\u0004\u0012\u00020{0mX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b|\u0010p\u001a\u0004\b}\u0010r\"\u0018\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0011\u0010\u0097\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u0098\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u0099\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0011\u0010\u009a\u0001\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`¨\u0006\u009b\u0001²\u0006\u000b\u0010\u009c\u0001\u001a\u00020*X\u008a\u0084\u0002"}, d2 = {"TopAppBar", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "navigationIcon", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "colors", "Landroidx/compose/material3/TopAppBarColors;", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "expandedHeight", "Landroidx/compose/ui/unit/Dp;", "TopAppBar-GHTll3U", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "CenterAlignedTopAppBar", "CenterAlignedTopAppBar-GHTll3U", "subtitle", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "TopAppBar-cJHQLPU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumTopAppBar", "collapsedHeight", "MediumTopAppBar-oKE7A98", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "MediumFlexibleTopAppBar", "MediumFlexibleTopAppBar-eXZ4JBQ", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LargeTopAppBar", "LargeTopAppBar-oKE7A98", "LargeFlexibleTopAppBar", "LargeFlexibleTopAppBar-eXZ4JBQ", "TwoRowsTopAppBar", "", "Lkotlin/ParameterName;", "name", "expanded", "TwoRowsTopAppBar-eXZ4JBQ", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Alignment$Horizontal;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "BottomAppBar", "floatingActionButton", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", FirebaseAnalytics.Param.CONTENT, "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlexibleBottomAppBar", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "FlexibleBottomAppBar-wBhsO_E", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/Arrangement$Horizontal;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarLayout", "containerHeight", "BottomAppBarLayout-t5fmz9U", "(FLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "rememberBottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "BottomAppBarState", "settleAppBarBottom", "Landroidx/compose/ui/unit/Velocity;", RemoteConfigConstants.ResponseFieldKey.STATE, "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BottomAppBarHorizontalPadding", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "subtitleTextStyle", "SingleRowTopAppBar-wn8IZOc", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LocalSingleRowTopAppBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/SingleRowTopAppBarOverride;", "getLocalSingleRowTopAppBarOverride$annotations", "()V", "getLocalSingleRowTopAppBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "titleBottomPadding", "smallTitle", "smallTitleTextStyle", "smallSubtitle", "smallSubtitleTextStyle", "TwoRowsTopAppBar-pJA5dT0", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "LocalTwoRowsTopAppBarOverride", "Landroidx/compose/material3/TwoRowsTopAppBarOverride;", "getLocalTwoRowsTopAppBarOverride$annotations", "getLocalTwoRowsTopAppBarOverride", "adjustHeightOffsetLimit", "TopAppBarLayout", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "navigationIconContentColor", "titleContentColor", "subtitleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "hideTitleSemantics", "height", "TopAppBarLayout-lyUyIHI", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/internal/FloatProducer;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;II)V", "settleAppBar", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rememberTouchExplorationService", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "MediumTitleBottomPadding", "LargeTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "material3", "touchExplorationServiceEnabled"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final ProvidableCompositionLocal<SingleRowTopAppBarOverride> LocalSingleRowTopAppBarOverride;
    private static final ProvidableCompositionLocal<TwoRowsTopAppBarOverride> LocalTwoRowsTopAppBarOverride;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BottomAppBarLayout_t5fmz9U$lambda$24(float f, Arrangement.Horizontal horizontal, Modifier modifier, long j, long j2, float f2, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Function3 function3, int i, int i2, Composer composer, int i3) {
        m1721BottomAppBarLayoutt5fmz9U(f, horizontal, modifier, j, j2, f2, paddingValues, windowInsets, bottomAppBarScrollBehavior, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BottomAppBar_1oL4kX8$lambda$14(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m1717BottomAppBar1oL4kX8(modifier, j, j2, f, paddingValues, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BottomAppBar_Snr_uVM$lambda$12(Function3 function3, Modifier modifier, Function2 function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, int i, int i2, Composer composer, int i3) {
        m1718BottomAppBarSnr_uVM(function3, modifier, function2, j, j2, f, paddingValues, windowInsets, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BottomAppBar_e_3WI5M$lambda$15(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Function3 function3, int i, int i2, Composer composer, int i3) {
        m1719BottomAppBare3WI5M(modifier, j, j2, f, paddingValues, windowInsets, bottomAppBarScrollBehavior, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BottomAppBar_qhFBPw4$lambda$13(Function3 function3, Modifier modifier, Function2 function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m1720BottomAppBarqhFBPw4(function3, modifier, function2, j, j2, f, paddingValues, windowInsets, bottomAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CenterAlignedTopAppBar$lambda$2(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        CenterAlignedTopAppBar(function2, modifier, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit CenterAlignedTopAppBar_GHTll3U$lambda$3(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, float f, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m1722CenterAlignedTopAppBarGHTll3U(function2, modifier, function22, function3, f, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FlexibleBottomAppBar_wBhsO_E$lambda$16(Modifier modifier, long j, long j2, PaddingValues paddingValues, Arrangement.Horizontal horizontal, float f, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Function3 function3, int i, int i2, Composer composer, int i3) {
        m1723FlexibleBottomAppBarwBhsO_E(modifier, j, j2, paddingValues, horizontal, f, windowInsets, bottomAppBarScrollBehavior, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LargeFlexibleTopAppBar_eXZ4JBQ$lambda$10(Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function3 function3, Alignment.Horizontal horizontal, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m1724LargeFlexibleTopAppBareXZ4JBQ(function2, modifier, function22, function23, function3, horizontal, f, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LargeTopAppBar$lambda$8(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        LargeTopAppBar(function2, modifier, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LargeTopAppBar_oKE7A98$lambda$9(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m1725LargeTopAppBaroKE7A98(function2, modifier, function22, function3, f, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MediumFlexibleTopAppBar_eXZ4JBQ$lambda$7(Function2 function2, Modifier modifier, Function2 function22, Function2 function23, Function3 function3, Alignment.Horizontal horizontal, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m1726MediumFlexibleTopAppBareXZ4JBQ(function2, modifier, function22, function23, function3, horizontal, f, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MediumTopAppBar$lambda$5(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        MediumTopAppBar(function2, modifier, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MediumTopAppBar_oKE7A98$lambda$6(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m1727MediumTopAppBaroKE7A98(function2, modifier, function22, function3, f, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SingleRowTopAppBar_wn8IZOc$lambda$32(Modifier modifier, Function2 function2, TextStyle textStyle, Function2 function22, TextStyle textStyle2, Alignment.Horizontal horizontal, Function2 function23, Function3 function3, float f, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m1728SingleRowTopAppBarwn8IZOc(modifier, function2, textStyle, function22, textStyle2, horizontal, function23, function3, f, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopAppBar$lambda$0(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        TopAppBar(function2, modifier, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopAppBarLayout_lyUyIHI$lambda$53(Modifier modifier, FloatProducer floatProducer, long j, long j2, long j3, long j4, Function2 function2, TextStyle textStyle, Function2 function22, TextStyle textStyle2, Function0 function0, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, int i, boolean z, Function2 function23, Function2 function24, float f, int i2, int i3, Composer composer, int i4) {
        m1731TopAppBarLayoutlyUyIHI(modifier, floatProducer, j, j2, j3, j4, function2, textStyle, function22, textStyle2, function0, vertical, horizontal, i, z, function23, function24, f, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopAppBar_GHTll3U$lambda$1(Function2 function2, Modifier modifier, Function2 function22, Function3 function3, float f, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m1729TopAppBarGHTll3U(function2, modifier, function22, function3, f, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopAppBar_cJHQLPU$lambda$4(Function2 function2, Function2 function22, Modifier modifier, Function2 function23, Function3 function3, Alignment.Horizontal horizontal, float f, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, Composer composer, int i3) {
        m1730TopAppBarcJHQLPU(function2, function22, modifier, function23, function3, horizontal, f, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TwoRowsTopAppBar_eXZ4JBQ$lambda$11(Function3 function3, Modifier modifier, Function3 function32, Function2 function2, Function3 function33, Alignment.Horizontal horizontal, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m1732TwoRowsTopAppBareXZ4JBQ(function3, modifier, function32, function2, function33, horizontal, f, f2, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TwoRowsTopAppBar_pJA5dT0$lambda$35(Modifier modifier, Function2 function2, TextStyle textStyle, float f, Function2 function22, TextStyle textStyle2, Function2 function23, TextStyle textStyle3, Function2 function24, TextStyle textStyle4, Alignment.Horizontal horizontal, Function2 function25, Function3 function3, float f2, float f3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, int i2, int i3, Composer composer, int i4) {
        m1733TwoRowsTopAppBarpJA5dT0(modifier, function2, textStyle, f, function22, textStyle2, function23, textStyle3, function24, textStyle4, horizontal, function25, function3, f2, f3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalSingleRowTopAppBarOverride$annotations() {
    }

    public static /* synthetic */ void getLocalTwoRowsTopAppBarOverride$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of TopAppBar with expandedHeight parameter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void TopAppBar(final Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2 function23;
        int i3;
        Object obj;
        int i4;
        Function2<Composer, Integer, Unit> function24;
        int i5;
        Function3<RowScope, Composer, Integer, Unit> function32;
        Object obj2;
        Object obj3;
        int i6;
        Object obj4;
        Composer composer2;
        final Modifier modifier2;
        final Function2 function25;
        final Function3 function33;
        final WindowInsets windowInsets2;
        final TopAppBarColors topAppBarColors2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3 function34;
        WindowInsets windowInsets3;
        Modifier modifier3;
        Function2 function26;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1788762628);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)N(title,modifier,navigationIcon,actions,windowInsets,colors,scrollBehavior)168@8176L307:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            obj2 = windowInsets;
                            if (startRestartGroup.changed(obj2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            obj2 = windowInsets;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        obj2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj3 = topAppBarColors;
                            if (startRestartGroup.changed(obj3)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            obj3 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        obj3 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        obj4 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "164@8034L12,165@8096L17");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                topAppBarColors3 = obj3;
                                topAppBarScrollBehavior3 = obj4;
                                i7 = 1788762628;
                                function34 = function32;
                                windowInsets3 = obj2;
                                modifier3 = obj;
                                function26 = function24;
                            } else {
                                Modifier.Companion companion = i10 != 0 ? Modifier.Companion : obj;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.m1935getLambda$944449303$material3();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$917296843$material3();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    obj2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    obj3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    windowInsets3 = obj2;
                                    topAppBarColors3 = obj3;
                                    function26 = function24;
                                    function34 = function32;
                                    modifier3 = companion;
                                } else {
                                    topAppBarColors3 = obj3;
                                    topAppBarScrollBehavior3 = obj4;
                                    function34 = function32;
                                    windowInsets3 = obj2;
                                    modifier3 = companion;
                                    function26 = function24;
                                }
                                i7 = 1788762628;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:168)");
                            }
                            int i11 = i3 << 3;
                            composer2 = startRestartGroup;
                            m1729TopAppBarGHTll3U(function23, modifier3, function26, function34, TopAppBarDefaults.INSTANCE.m2924getTopAppBarExpandedHeightD9Ej5fM(), windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11) | (3670016 & i11) | (i11 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            function25 = function26;
                            function33 = function34;
                            windowInsets2 = windowInsets3;
                            topAppBarColors2 = topAppBarColors3;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = obj;
                            function25 = function24;
                            function33 = function32;
                            windowInsets2 = obj2;
                            topAppBarColors2 = obj3;
                            topAppBarScrollBehavior2 = obj4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda28
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return AppBarKt.TopAppBar$lambda$0(Function2.this, modifier2, function25, function33, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj4 = topAppBarScrollBehavior;
                    if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                obj4 = topAppBarScrollBehavior;
                if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            obj4 = topAppBarScrollBehavior;
            if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        obj4 = topAppBarScrollBehavior;
        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* renamed from: TopAppBar-GHTll3U  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1729TopAppBarGHTll3U(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, float f, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Object obj;
        int i4;
        Function2<Composer, Integer, Unit> function24;
        int i5;
        Function3<RowScope, Composer, Integer, Unit> function32;
        int i6;
        float f2;
        Object obj2;
        Object obj3;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final float f3;
        final WindowInsets windowInsets2;
        final TopAppBarColors topAppBarColors2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        int i10;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        float f4;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1784421840);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)N(title,modifier,navigationIcon,actions,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)228@11268L5,225@11143L667:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        f2 = f;
                        i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                        if ((196608 & i) == 0) {
                            if ((i2 & 32) == 0) {
                                obj2 = windowInsets;
                                if (startRestartGroup.changed(obj2)) {
                                    i12 = 131072;
                                    i3 |= i12;
                                }
                            } else {
                                obj2 = windowInsets;
                            }
                            i12 = 65536;
                            i3 |= i12;
                        } else {
                            obj2 = windowInsets;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                obj3 = topAppBarColors;
                                if (startRestartGroup.changed(obj3)) {
                                    i11 = 1048576;
                                    i3 |= i11;
                                }
                            } else {
                                obj3 = topAppBarColors;
                            }
                            i11 = 524288;
                            i3 |= i11;
                        } else {
                            obj3 = topAppBarColors;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i8 = i7;
                            i3 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 8388608 : 4194304;
                            i9 = i3;
                            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "221@11001L12,222@11063L17");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    int i14 = (i2 & 32) != 0 ? i9 & (-458753) : i9;
                                    if ((i2 & 64) != 0) {
                                        i14 &= -3670017;
                                    }
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                    modifier3 = obj;
                                    function26 = function24;
                                    function34 = function32;
                                    windowInsets3 = obj2;
                                    topAppBarColors3 = obj3;
                                    i10 = i14;
                                    f4 = f2;
                                } else {
                                    Modifier.Companion companion = i13 != 0 ? Modifier.Companion : obj;
                                    if (i4 != 0) {
                                        function24 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$657782987$material3();
                                    }
                                    if (i5 != 0) {
                                        function32 = ComposableSingletons$AppBarKt.INSTANCE.m1919getLambda$1270442071$material3();
                                    }
                                    if (i6 != 0) {
                                        f2 = TopAppBarDefaults.INSTANCE.m2924getTopAppBarExpandedHeightD9Ej5fM();
                                    }
                                    if ((i2 & 32) != 0) {
                                        i10 = i9 & (-458753);
                                        obj2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    } else {
                                        i10 = i9;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i10 &= -3670017;
                                        obj3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                    }
                                    if (i8 != 0) {
                                        modifier3 = companion;
                                        topAppBarScrollBehavior3 = null;
                                    } else {
                                        topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                        modifier3 = companion;
                                    }
                                    function26 = function24;
                                    function34 = function32;
                                    f4 = f2;
                                    windowInsets3 = obj2;
                                    topAppBarColors3 = obj3;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1784421840, i10, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:225)");
                                }
                                int i15 = i10 << 12;
                                composer2 = startRestartGroup;
                                m1728SingleRowTopAppBarwn8IZOc(modifier3, function23, TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), startRestartGroup, 6), null, TextStyle.Companion.getDefault(), Alignment.Companion.getStart(), function26, function34, (Dp.m7560equalsimpl0(f4, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(f4, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2924getTopAppBarExpandedHeightD9Ej5fM() : f4, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, ((i10 >> 3) & 14) | 224256 | ((i10 << 3) & 112) | (3670016 & i15) | (29360128 & i15) | (i15 & 1879048192), (i10 >> 18) & WebSocketProtocol.PAYLOAD_SHORT, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f3 = f4;
                                modifier2 = modifier3;
                                function25 = function26;
                                function33 = function34;
                                windowInsets2 = windowInsets3;
                                topAppBarColors2 = topAppBarColors3;
                                topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = obj;
                                function25 = function24;
                                function33 = function32;
                                f3 = f2;
                                windowInsets2 = obj2;
                                topAppBarColors2 = obj3;
                                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj4, Object obj5) {
                                        return AppBarKt.TopAppBar_GHTll3U$lambda$1(Function2.this, modifier2, function25, function33, f3, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i8 = i7;
                        i9 = i3;
                        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    f2 = f;
                    if ((196608 & i) == 0) {
                    }
                    if ((1572864 & i) == 0) {
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    i9 = i3;
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function32 = function3;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                f2 = f;
                if ((196608 & i) == 0) {
                }
                if ((1572864 & i) == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i3;
                if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i3;
            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3;
        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of CenterAlignedTopAppBar with expandedHeight parameter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void CenterAlignedTopAppBar(final Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2 function23;
        int i3;
        Object obj;
        int i4;
        Function2<Composer, Integer, Unit> function24;
        int i5;
        Function3<RowScope, Composer, Integer, Unit> function32;
        Object obj2;
        Object obj3;
        int i6;
        Object obj4;
        Composer composer2;
        final Modifier modifier2;
        final Function2 function25;
        final Function3 function33;
        final WindowInsets windowInsets2;
        final TopAppBarColors topAppBarColors2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3 function34;
        WindowInsets windowInsets3;
        Modifier modifier3;
        Function2 function26;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(603182999);
        ComposerKt.sourceInformation(startRestartGroup, "C(CenterAlignedTopAppBar)N(title,modifier,navigationIcon,actions,windowInsets,colors,scrollBehavior)291@14250L320:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            obj2 = windowInsets;
                            if (startRestartGroup.changed(obj2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            obj2 = windowInsets;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        obj2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj3 = topAppBarColors;
                            if (startRestartGroup.changed(obj3)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            obj3 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        obj3 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        obj4 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "287@14108L12,288@14170L17");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                topAppBarColors3 = obj3;
                                topAppBarScrollBehavior3 = obj4;
                                i7 = 603182999;
                                function34 = function32;
                                windowInsets3 = obj2;
                                modifier3 = obj;
                                function26 = function24;
                            } else {
                                Modifier.Companion companion = i10 != 0 ? Modifier.Companion : obj;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1866429650$material3();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m1929getLambda$541682128$material3();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    obj2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    obj3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    windowInsets3 = obj2;
                                    topAppBarColors3 = obj3;
                                    function26 = function24;
                                    function34 = function32;
                                    modifier3 = companion;
                                } else {
                                    topAppBarColors3 = obj3;
                                    topAppBarScrollBehavior3 = obj4;
                                    function34 = function32;
                                    windowInsets3 = obj2;
                                    modifier3 = companion;
                                    function26 = function24;
                                }
                                i7 = 603182999;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:291)");
                            }
                            int i11 = i3 << 3;
                            composer2 = startRestartGroup;
                            m1722CenterAlignedTopAppBarGHTll3U(function23, modifier3, function26, function34, TopAppBarDefaults.INSTANCE.m2924getTopAppBarExpandedHeightD9Ej5fM(), windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (458752 & i11) | (3670016 & i11) | (i11 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            function25 = function26;
                            function33 = function34;
                            windowInsets2 = windowInsets3;
                            topAppBarColors2 = topAppBarColors3;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = obj;
                            function25 = function24;
                            function33 = function32;
                            windowInsets2 = obj2;
                            topAppBarColors2 = obj3;
                            topAppBarScrollBehavior2 = obj4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return AppBarKt.CenterAlignedTopAppBar$lambda$2(Function2.this, modifier2, function25, function33, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj4 = topAppBarScrollBehavior;
                    if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                obj4 = topAppBarScrollBehavior;
                if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            obj4 = topAppBarScrollBehavior;
            if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        obj4 = topAppBarScrollBehavior;
        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* renamed from: CenterAlignedTopAppBar-GHTll3U  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1722CenterAlignedTopAppBarGHTll3U(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, float f, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Object obj;
        int i4;
        Function2<Composer, Integer, Unit> function24;
        int i5;
        Function3<RowScope, Composer, Integer, Unit> function32;
        int i6;
        float f2;
        Object obj2;
        Object obj3;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final float f3;
        final WindowInsets windowInsets2;
        final TopAppBarColors topAppBarColors2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        int i10;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        float f4;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-302230691);
        ComposerKt.sourceInformation(startRestartGroup, "C(CenterAlignedTopAppBar)N(title,modifier,navigationIcon,actions,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)352@17429L5,349@17304L680:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        f2 = f;
                        i3 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                        if ((196608 & i) == 0) {
                            if ((i2 & 32) == 0) {
                                obj2 = windowInsets;
                                if (startRestartGroup.changed(obj2)) {
                                    i12 = 131072;
                                    i3 |= i12;
                                }
                            } else {
                                obj2 = windowInsets;
                            }
                            i12 = 65536;
                            i3 |= i12;
                        } else {
                            obj2 = windowInsets;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                obj3 = topAppBarColors;
                                if (startRestartGroup.changed(obj3)) {
                                    i11 = 1048576;
                                    i3 |= i11;
                                }
                            } else {
                                obj3 = topAppBarColors;
                            }
                            i11 = 524288;
                            i3 |= i11;
                        } else {
                            obj3 = topAppBarColors;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i8 = i7;
                            i3 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 8388608 : 4194304;
                            i9 = i3;
                            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "345@17162L12,346@17224L17");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    int i14 = (i2 & 32) != 0 ? i9 & (-458753) : i9;
                                    if ((i2 & 64) != 0) {
                                        i14 &= -3670017;
                                    }
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                    modifier3 = obj;
                                    function26 = function24;
                                    function34 = function32;
                                    windowInsets3 = obj2;
                                    topAppBarColors3 = obj3;
                                    i10 = i14;
                                    f4 = f2;
                                } else {
                                    Modifier.Companion companion = i13 != 0 ? Modifier.Companion : obj;
                                    if (i4 != 0) {
                                        function24 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$575301698$material3();
                                    }
                                    if (i5 != 0) {
                                        function32 = ComposableSingletons$AppBarKt.INSTANCE.m1930getLambda$643931612$material3();
                                    }
                                    if (i6 != 0) {
                                        f2 = TopAppBarDefaults.INSTANCE.m2924getTopAppBarExpandedHeightD9Ej5fM();
                                    }
                                    if ((i2 & 32) != 0) {
                                        i10 = i9 & (-458753);
                                        obj2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    } else {
                                        i10 = i9;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i10 &= -3670017;
                                        obj3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                    }
                                    if (i8 != 0) {
                                        modifier3 = companion;
                                        topAppBarScrollBehavior3 = null;
                                    } else {
                                        topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                        modifier3 = companion;
                                    }
                                    function26 = function24;
                                    function34 = function32;
                                    f4 = f2;
                                    windowInsets3 = obj2;
                                    topAppBarColors3 = obj3;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-302230691, i10, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:349)");
                                }
                                int i15 = i10 << 12;
                                composer2 = startRestartGroup;
                                m1728SingleRowTopAppBarwn8IZOc(modifier3, function23, TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), startRestartGroup, 6), null, TextStyle.Companion.getDefault(), Alignment.Companion.getCenterHorizontally(), function26, function34, (Dp.m7560equalsimpl0(f4, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(f4, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2924getTopAppBarExpandedHeightD9Ej5fM() : f4, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, ((i10 >> 3) & 14) | 224256 | ((i10 << 3) & 112) | (3670016 & i15) | (29360128 & i15) | (i15 & 1879048192), (i10 >> 18) & WebSocketProtocol.PAYLOAD_SHORT, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f3 = f4;
                                modifier2 = modifier3;
                                function25 = function26;
                                function33 = function34;
                                windowInsets2 = windowInsets3;
                                topAppBarColors2 = topAppBarColors3;
                                topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = obj;
                                function25 = function24;
                                function33 = function32;
                                f3 = f2;
                                windowInsets2 = obj2;
                                topAppBarColors2 = obj3;
                                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda21
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj4, Object obj5) {
                                        return AppBarKt.CenterAlignedTopAppBar_GHTll3U$lambda$3(Function2.this, modifier2, function25, function33, f3, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i8 = i7;
                        i9 = i3;
                        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    f2 = f;
                    if ((196608 & i) == 0) {
                    }
                    if ((1572864 & i) == 0) {
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    i9 = i3;
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function32 = function3;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                f2 = f;
                if ((196608 & i) == 0) {
                }
                if ((1572864 & i) == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i3;
                if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((1572864 & i) == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i3;
            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((1572864 & i) == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i3;
        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i9 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0111  */
    /* renamed from: TopAppBar-cJHQLPU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1730TopAppBarcJHQLPU(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Alignment.Horizontal horizontal, float f, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i3;
        Object obj;
        int i4;
        Modifier.Companion companion;
        int i5;
        Function2<Composer, Integer, Unit> function25;
        int i6;
        Function3<RowScope, Composer, Integer, Unit> function32;
        int i7;
        Object obj2;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final WindowInsets windowInsets2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final Alignment.Horizontal horizontal2;
        final float f2;
        final TopAppBarColors topAppBarColors2;
        ScopeUpdateScope endRestartGroup;
        float m2924getTopAppBarExpandedHeightD9Ej5fM;
        WindowInsets windowInsets3;
        int i12;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        WindowInsets windowInsets4;
        Function2<? super Composer, ? super Integer, Unit> function27;
        TopAppBarColors topAppBarColors4;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        Alignment.Horizontal horizontal3;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(1954772493);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)N(title,subtitle,modifier,navigationIcon,actions,titleHorizontalAlignment,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)386@18726L5,388@18821L5,383@18601L699:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function24 = function2;
        } else {
            function24 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function24) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = function22;
            i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
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
                    function25 = function23;
                    i3 |= startRestartGroup.changedInstance(function25) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        function32 = function3;
                        i3 |= startRestartGroup.changedInstance(function32) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i) == 0) {
                            obj2 = horizontal;
                            i3 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                            i8 = i2 & 64;
                            if (i8 == 0) {
                                i3 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                i3 |= startRestartGroup.changed(f) ? 1048576 : 524288;
                            }
                            if ((i & 12582912) == 0) {
                                if ((i2 & 128) == 0 && startRestartGroup.changed(windowInsets)) {
                                    i14 = 8388608;
                                    i3 |= i14;
                                }
                                i14 = 4194304;
                                i3 |= i14;
                            }
                            if ((i & 100663296) == 0) {
                                if ((i2 & 256) == 0 && startRestartGroup.changed(topAppBarColors)) {
                                    i13 = 67108864;
                                    i3 |= i13;
                                }
                                i13 = 33554432;
                                i3 |= i13;
                            }
                            i9 = i2 & 512;
                            if (i9 == 0) {
                                i3 |= 805306368;
                            } else if ((i & 805306368) == 0) {
                                i10 = i9;
                                i3 |= startRestartGroup.changed(topAppBarScrollBehavior) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                i11 = i3;
                                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i11 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "379@18459L12,380@18521L17");
                                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        int i15 = (i2 & 128) != 0 ? i11 & (-29360129) : i11;
                                        if ((i2 & 256) != 0) {
                                            i15 &= -234881025;
                                        }
                                        windowInsets4 = windowInsets;
                                        topAppBarColors4 = topAppBarColors;
                                        topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                        i12 = i15;
                                        function27 = function25;
                                        function34 = function32;
                                        horizontal3 = obj2;
                                        m2924getTopAppBarExpandedHeightD9Ej5fM = f;
                                    } else {
                                        if (i4 != 0) {
                                            companion = Modifier.Companion;
                                        }
                                        if (i5 != 0) {
                                            function25 = ComposableSingletons$AppBarKt.INSTANCE.m1917getLambda$1168245838$material3();
                                        }
                                        if (i6 != 0) {
                                            function32 = ComposableSingletons$AppBarKt.INSTANCE.m1921getLambda$1401945836$material3();
                                        }
                                        if (i7 != 0) {
                                            obj2 = Alignment.Companion.getStart();
                                        }
                                        m2924getTopAppBarExpandedHeightD9Ej5fM = i8 != 0 ? TopAppBarDefaults.INSTANCE.m2924getTopAppBarExpandedHeightD9Ej5fM() : f;
                                        if ((i2 & 128) != 0) {
                                            windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                            i12 = i11 & (-29360129);
                                        } else {
                                            windowInsets3 = windowInsets;
                                            i12 = i11;
                                        }
                                        if ((i2 & 256) != 0) {
                                            topAppBarColors3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                            i12 &= -234881025;
                                        } else {
                                            topAppBarColors3 = topAppBarColors;
                                        }
                                        if (i10 != 0) {
                                            windowInsets4 = windowInsets3;
                                            function27 = function25;
                                            topAppBarColors4 = topAppBarColors3;
                                            function34 = function32;
                                            topAppBarScrollBehavior3 = null;
                                        } else {
                                            topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                            windowInsets4 = windowInsets3;
                                            function27 = function25;
                                            topAppBarColors4 = topAppBarColors3;
                                            function34 = function32;
                                        }
                                        horizontal3 = obj2;
                                    }
                                    Modifier modifier3 = companion;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1954772493, i12, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:383)");
                                    }
                                    int i16 = i12 << 6;
                                    int i17 = i12 << 9;
                                    composer2 = startRestartGroup;
                                    m1728SingleRowTopAppBarwn8IZOc(modifier3, function24, TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), startRestartGroup, 6), obj, TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getSubtitleFont(), startRestartGroup, 6), horizontal3, function27, function34, (Dp.m7560equalsimpl0(m2924getTopAppBarExpandedHeightD9Ej5fM, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(m2924getTopAppBarExpandedHeightD9Ej5fM, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2924getTopAppBarExpandedHeightD9Ej5fM() : m2924getTopAppBarExpandedHeightD9Ej5fM, windowInsets4, topAppBarColors4, topAppBarScrollBehavior3, composer2, ((i12 >> 6) & 14) | ((i12 << 3) & 112) | (i16 & 7168) | (458752 & i12) | (3670016 & i17) | (i17 & 29360128) | (i16 & 1879048192), (i12 >> 24) & WebSocketProtocol.PAYLOAD_SHORT, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f2 = m2924getTopAppBarExpandedHeightD9Ej5fM;
                                    modifier2 = modifier3;
                                    horizontal2 = horizontal3;
                                    function26 = function27;
                                    function33 = function34;
                                    windowInsets2 = windowInsets4;
                                    topAppBarColors2 = topAppBarColors4;
                                    topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    windowInsets2 = windowInsets;
                                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                    modifier2 = companion;
                                    function26 = function25;
                                    function33 = function32;
                                    horizontal2 = obj2;
                                    f2 = f;
                                    topAppBarColors2 = topAppBarColors;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda7
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj3, Object obj4) {
                                            return AppBarKt.TopAppBar_cJHQLPU$lambda$4(Function2.this, function22, modifier2, function26, function33, horizontal2, f2, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i10 = i9;
                            i11 = i3;
                            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i11 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        obj2 = horizontal;
                        i8 = i2 & 64;
                        if (i8 == 0) {
                        }
                        if ((i & 12582912) == 0) {
                        }
                        if ((i & 100663296) == 0) {
                        }
                        i9 = i2 & 512;
                        if (i9 == 0) {
                        }
                        i10 = i9;
                        i11 = i3;
                        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i11 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    function32 = function3;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    obj2 = horizontal;
                    i8 = i2 & 64;
                    if (i8 == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    i9 = i2 & 512;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    i11 = i3;
                    if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i11 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function25 = function23;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function32 = function3;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                obj2 = horizontal;
                i8 = i2 & 64;
                if (i8 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i9 = i2 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i3;
                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i11 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            companion = modifier;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function25 = function23;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function32 = function3;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            obj2 = horizontal;
            i8 = i2 & 64;
            if (i8 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i9 = i2 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i3;
            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i11 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = function22;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        companion = modifier;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function25 = function23;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function32 = function3;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        obj2 = horizontal;
        i8 = i2 & 64;
        if (i8 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i9 = i2 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i3;
        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i11 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of MediumTopAppBar with collapsedHeight and expandedHeight parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void MediumTopAppBar(final Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2 function23;
        int i3;
        Object obj;
        int i4;
        Function2<Composer, Integer, Unit> function24;
        int i5;
        Function3<RowScope, Composer, Integer, Unit> function32;
        Object obj2;
        Object obj3;
        int i6;
        Object obj4;
        Composer composer2;
        final Modifier modifier2;
        final Function2 function25;
        final Function3 function33;
        final WindowInsets windowInsets2;
        final TopAppBarColors topAppBarColors2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        int i7;
        Function3 function34;
        Modifier modifier3;
        WindowInsets windowInsets3;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-319217319);
        ComposerKt.sourceInformation(startRestartGroup, "C(MediumTopAppBar)N(title,modifier,navigationIcon,actions,windowInsets,colors,scrollBehavior)451@21910L389:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            obj2 = windowInsets;
                            if (startRestartGroup.changed(obj2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            obj2 = windowInsets;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        obj2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj3 = topAppBarColors;
                            if (startRestartGroup.changed(obj3)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            obj3 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        obj3 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        obj4 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "447@21768L12,448@21830L17");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                topAppBarColors3 = obj3;
                                topAppBarScrollBehavior3 = obj4;
                                i7 = -319217319;
                                function34 = function32;
                                windowInsets3 = obj2;
                                modifier3 = obj;
                            } else {
                                Modifier.Companion companion = i10 != 0 ? Modifier.Companion : obj;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1152131198$material3();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m1922getLambda$1707954976$material3();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    obj2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    obj3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    topAppBarColors3 = obj3;
                                } else {
                                    topAppBarColors3 = obj3;
                                    topAppBarScrollBehavior3 = obj4;
                                }
                                i7 = -319217319;
                                function34 = function32;
                                modifier3 = companion;
                                windowInsets3 = obj2;
                            }
                            Function2 function26 = function24;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:451)");
                            }
                            int i11 = i3 << 6;
                            composer2 = startRestartGroup;
                            m1727MediumTopAppBaroKE7A98(function23, modifier3, function26, function34, TopAppBarDefaults.INSTANCE.m2920getMediumAppBarCollapsedHeightD9Ej5fM(), TopAppBarDefaults.INSTANCE.m2921getMediumAppBarExpandedHeightD9Ej5fM(), windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, (3670016 & i11) | (i3 & 14) | 221184 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (29360128 & i11) | (i11 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            function25 = function26;
                            function33 = function34;
                            windowInsets2 = windowInsets3;
                            topAppBarColors2 = topAppBarColors3;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = obj;
                            function25 = function24;
                            function33 = function32;
                            windowInsets2 = obj2;
                            topAppBarColors2 = obj3;
                            topAppBarScrollBehavior2 = obj4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda33
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return AppBarKt.MediumTopAppBar$lambda$5(Function2.this, modifier2, function25, function33, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj4 = topAppBarScrollBehavior;
                    if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                obj4 = topAppBarScrollBehavior;
                if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            obj4 = topAppBarScrollBehavior;
            if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        obj4 = topAppBarScrollBehavior;
        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* renamed from: MediumTopAppBar-oKE7A98  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1727MediumTopAppBaroKE7A98(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Modifier.Companion companion;
        int i4;
        Function2<Composer, Integer, Unit> function24;
        int i5;
        Function3<RowScope, Composer, Integer, Unit> function32;
        int i6;
        float f3;
        int i7;
        float f4;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final WindowInsets windowInsets2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final float f5;
        final float f6;
        final TopAppBarColors topAppBarColors2;
        ScopeUpdateScope endRestartGroup;
        WindowInsets windowInsets3;
        int i11;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        WindowInsets windowInsets4;
        TopAppBarColors topAppBarColors4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        float f7;
        Modifier modifier3;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1378129383);
        ComposerKt.sourceInformation(startRestartGroup, "C(MediumTopAppBar)N(title,modifier,navigationIcon,actions,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)521@25897L5,522@25962L5,518@25773L1142:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        f3 = f;
                        i3 |= startRestartGroup.changed(f3) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i) == 0) {
                            f4 = f2;
                            i3 |= startRestartGroup.changed(f4) ? 131072 : 65536;
                            if ((i & 1572864) == 0) {
                                i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(windowInsets)) ? 1048576 : 524288;
                            }
                            if ((i & 12582912) == 0) {
                                if ((i2 & 128) == 0 && startRestartGroup.changed(topAppBarColors)) {
                                    i13 = 8388608;
                                    i3 |= i13;
                                }
                                i13 = 4194304;
                                i3 |= i13;
                            }
                            i8 = i2 & 256;
                            if (i8 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i9 = i8;
                                i3 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 67108864 : 33554432;
                                i10 = i3;
                                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "514@25631L12,515@25693L17");
                                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                        if (i14 != 0) {
                                            companion = Modifier.Companion;
                                        }
                                        if (i4 != 0) {
                                            function24 = ComposableSingletons$AppBarKt.INSTANCE.m1927getLambda$229000834$material3();
                                        }
                                        if (i5 != 0) {
                                            function32 = ComposableSingletons$AppBarKt.INSTANCE.m1920getLambda$1276513184$material3();
                                        }
                                        if (i6 != 0) {
                                            f3 = TopAppBarDefaults.INSTANCE.m2920getMediumAppBarCollapsedHeightD9Ej5fM();
                                        }
                                        if (i7 != 0) {
                                            f4 = TopAppBarDefaults.INSTANCE.m2921getMediumAppBarExpandedHeightD9Ej5fM();
                                        }
                                        if ((i2 & 64) != 0) {
                                            windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                            i11 = i10 & (-3670017);
                                        } else {
                                            windowInsets3 = windowInsets;
                                            i11 = i10;
                                        }
                                        if ((i2 & 128) != 0) {
                                            topAppBarColors3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                            i11 &= -29360129;
                                        } else {
                                            topAppBarColors3 = topAppBarColors;
                                        }
                                        if (i9 != 0) {
                                            windowInsets4 = windowInsets3;
                                            topAppBarColors4 = topAppBarColors3;
                                            function26 = function24;
                                            topAppBarScrollBehavior3 = null;
                                        } else {
                                            topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                            windowInsets4 = windowInsets3;
                                            topAppBarColors4 = topAppBarColors3;
                                            function26 = function24;
                                        }
                                        function34 = function32;
                                        f7 = f3;
                                        modifier3 = companion;
                                        i12 = i11;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        int i15 = (i2 & 64) != 0 ? i10 & (-3670017) : i10;
                                        if ((i2 & 128) != 0) {
                                            i15 &= -29360129;
                                        }
                                        Modifier modifier4 = companion;
                                        i12 = i15;
                                        f7 = f3;
                                        modifier3 = modifier4;
                                        windowInsets4 = windowInsets;
                                        topAppBarColors4 = topAppBarColors;
                                        topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                        function26 = function24;
                                        function34 = function32;
                                    }
                                    float f8 = f4;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1378129383, i12, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:518)");
                                    }
                                    int i16 = i12 >> 3;
                                    composer2 = startRestartGroup;
                                    m1733TwoRowsTopAppBarpJA5dT0(modifier3, function23, TypographyKt.getValue(AppBarMediumTokens.INSTANCE.getTitleFont(), startRestartGroup, 6), MediumTitleBottomPadding, function2, TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), startRestartGroup, 6), null, TextStyle.Companion.getDefault(), null, TextStyle.Companion.getDefault(), Alignment.Companion.getStart(), function26, function34, (Dp.m7560equalsimpl0(f7, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(f7, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2920getMediumAppBarCollapsedHeightD9Ej5fM() : f7, (Dp.m7560equalsimpl0(f8, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(f8, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2921getMediumAppBarExpandedHeightD9Ej5fM() : f8, windowInsets4, topAppBarColors4, topAppBarScrollBehavior3, composer2, (i16 & 14) | 920128512 | ((i12 << 3) & 112) | ((i12 << 12) & 57344), 6 | (i16 & 112) | (i16 & 896) | (458752 & i16) | (3670016 & i16) | (29360128 & i16), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f5 = f7;
                                    f6 = f8;
                                    modifier2 = modifier3;
                                    function25 = function26;
                                    function33 = function34;
                                    windowInsets2 = windowInsets4;
                                    topAppBarColors2 = topAppBarColors4;
                                    topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    windowInsets2 = windowInsets;
                                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                    modifier2 = companion;
                                    function25 = function24;
                                    function33 = function32;
                                    f5 = f3;
                                    f6 = f4;
                                    topAppBarColors2 = topAppBarColors;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda8
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AppBarKt.MediumTopAppBar_oKE7A98$lambda$6(Function2.this, modifier2, function25, function33, f5, f6, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i9 = i8;
                            i10 = i3;
                            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        f4 = f2;
                        if ((i & 1572864) == 0) {
                        }
                        if ((i & 12582912) == 0) {
                        }
                        i8 = i2 & 256;
                        if (i8 == 0) {
                        }
                        i9 = i8;
                        i10 = i3;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    f3 = f;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    f4 = f2;
                    if ((i & 1572864) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    i10 = i3;
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                f3 = f;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                f4 = f2;
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3;
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            f3 = f;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            f4 = f2;
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3;
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        f3 = f;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        f4 = f2;
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3;
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    /* renamed from: MediumFlexibleTopAppBar-eXZ4JBQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1726MediumFlexibleTopAppBareXZ4JBQ(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Alignment.Horizontal horizontal, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        Object obj4;
        int i8;
        int i9;
        float f3;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final Alignment.Horizontal horizontal2;
        final TopAppBarColors topAppBarColors2;
        final float f4;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        final float f5;
        final WindowInsets windowInsets2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        float m2920getMediumAppBarCollapsedHeightD9Ej5fM;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        Alignment.Horizontal horizontal3;
        WindowInsets windowInsets4;
        TopAppBarColors topAppBarColors4;
        Modifier modifier3;
        float m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM;
        float f6;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-1895470263);
        ComposerKt.sourceInformation(startRestartGroup, "C(MediumFlexibleTopAppBar)N(title,modifier,subtitle,navigationIcon,actions,titleHorizontalAlignment,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)616@30967L5,617@31032L5,621@31225L5,623@31336L5,613@30835L1421:AppBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i16 = i3 & 2;
        if (i16 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = function22;
                i4 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj3 = function23;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        obj4 = function3;
                        i4 |= startRestartGroup.changedInstance(obj4) ? 16384 : 8192;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changed(horizontal) ? 131072 : 65536;
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(f) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i3 & 128) == 0) {
                                f3 = f2;
                                if (startRestartGroup.changed(f3)) {
                                    i15 = 8388608;
                                    i4 |= i15;
                                }
                            } else {
                                f3 = f2;
                            }
                            i15 = 4194304;
                            i4 |= i15;
                        } else {
                            f3 = f2;
                        }
                        if ((i & 100663296) == 0) {
                            if ((i3 & 256) == 0 && startRestartGroup.changed(windowInsets)) {
                                i14 = 67108864;
                                i4 |= i14;
                            }
                            i14 = 33554432;
                            i4 |= i14;
                        }
                        if ((i & 805306368) == 0) {
                            if ((i3 & 512) == 0 && startRestartGroup.changed(topAppBarColors)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                                i4 |= i13;
                            }
                            i13 = 268435456;
                            i4 |= i13;
                        }
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i11 = i10;
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changed(topAppBarScrollBehavior) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "609@30693L12,610@30755L17");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                }
                                horizontal3 = horizontal;
                                windowInsets4 = windowInsets;
                                topAppBarColors4 = topAppBarColors;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                function26 = obj3;
                                function33 = obj4;
                                m2920getMediumAppBarCollapsedHeightD9Ej5fM = f;
                                modifier3 = obj;
                            } else {
                                Modifier.Companion companion = i16 != 0 ? Modifier.Companion : obj;
                                if (i5 != 0) {
                                    obj2 = null;
                                }
                                Function2<Composer, Integer, Unit> m1924getLambda$185842620$material3 = i6 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1924getLambda$185842620$material3() : obj3;
                                Function3<RowScope, Composer, Integer, Unit> lambda$1113419554$material3 = i7 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$1113419554$material3() : obj4;
                                Alignment.Horizontal start = i8 != 0 ? Alignment.Companion.getStart() : horizontal;
                                m2920getMediumAppBarCollapsedHeightD9Ej5fM = i9 != 0 ? TopAppBarDefaults.INSTANCE.m2920getMediumAppBarCollapsedHeightD9Ej5fM() : f;
                                if ((i3 & 128) != 0) {
                                    if (obj2 != null) {
                                        f3 = TopAppBarDefaults.INSTANCE.m2922getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
                                    } else {
                                        f3 = TopAppBarDefaults.INSTANCE.m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
                                    }
                                    i4 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    windowInsets3 = windowInsets;
                                }
                                if ((i3 & 512) != 0) {
                                    topAppBarColors3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                    i4 &= -1879048193;
                                } else {
                                    topAppBarColors3 = topAppBarColors;
                                }
                                topAppBarScrollBehavior3 = i11 != 0 ? null : topAppBarScrollBehavior;
                                function26 = m1924getLambda$185842620$material3;
                                function33 = lambda$1113419554$material3;
                                horizontal3 = start;
                                windowInsets4 = windowInsets3;
                                topAppBarColors4 = topAppBarColors3;
                                modifier3 = companion;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1895470263, i4, i12, "androidx.compose.material3.MediumFlexibleTopAppBar (AppBar.kt:613)");
                            }
                            TextStyle value = TypographyKt.getValue(AppBarMediumFlexibleTokens.INSTANCE.getTitleFont(), startRestartGroup, 6);
                            TextStyle value2 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), startRestartGroup, 6);
                            float f7 = MediumTitleBottomPadding;
                            Function2<Composer, Integer, Unit> m1934getLambda$790317886$material3 = obj2 == null ? ComposableSingletons$AppBarKt.INSTANCE.m1934getLambda$790317886$material3() : obj2;
                            TextStyle value3 = TypographyKt.getValue(AppBarMediumFlexibleTokens.INSTANCE.getSubtitleFont(), startRestartGroup, 6);
                            Function2<Composer, Integer, Unit> m1925getLambda$1926007989$material3 = obj2 == null ? ComposableSingletons$AppBarKt.INSTANCE.m1925getLambda$1926007989$material3() : obj2;
                            TextStyle value4 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getSubtitleFont(), startRestartGroup, 6);
                            float m2920getMediumAppBarCollapsedHeightD9Ej5fM2 = (Dp.m7560equalsimpl0(m2920getMediumAppBarCollapsedHeightD9Ej5fM, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(m2920getMediumAppBarCollapsedHeightD9Ej5fM, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2920getMediumAppBarCollapsedHeightD9Ej5fM() : m2920getMediumAppBarCollapsedHeightD9Ej5fM;
                            if (Dp.m7560equalsimpl0(f3, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(f3, Dp.Companion.m7574getInfinityD9Ej5fM())) {
                                if (obj2 != null) {
                                    m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM = TopAppBarDefaults.INSTANCE.m2922getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
                                } else {
                                    m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM = TopAppBarDefaults.INSTANCE.m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
                                }
                                f6 = m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM;
                            } else {
                                f6 = f3;
                            }
                            int i17 = i4 >> 6;
                            int i18 = ((i4 >> 15) & 14) | (i17 & 112) | (i17 & 896);
                            int i19 = i4 >> 9;
                            composer2 = startRestartGroup;
                            m1733TwoRowsTopAppBarpJA5dT0(modifier3, function2, value, f7, function2, value2, m1934getLambda$790317886$material3, value3, m1925getLambda$1926007989$material3, value4, horizontal3, function26, function33, m2920getMediumAppBarCollapsedHeightD9Ej5fM2, f6, windowInsets4, topAppBarColors4, topAppBarScrollBehavior3, composer2, ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112) | ((i4 << 12) & 57344), i18 | (458752 & i19) | (i19 & 3670016) | ((i12 << 21) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f4 = f3;
                            function24 = obj2;
                            f5 = m2920getMediumAppBarCollapsedHeightD9Ej5fM;
                            modifier2 = modifier3;
                            horizontal2 = horizontal3;
                            function25 = function26;
                            function32 = function33;
                            windowInsets2 = windowInsets4;
                            topAppBarColors2 = topAppBarColors4;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal2 = horizontal;
                            topAppBarColors2 = topAppBarColors;
                            f4 = f3;
                            modifier2 = obj;
                            function24 = obj2;
                            function25 = obj3;
                            function32 = obj4;
                            f5 = f;
                            windowInsets2 = windowInsets;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda36
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return AppBarKt.MediumFlexibleTopAppBar_eXZ4JBQ$lambda$7(Function2.this, modifier2, function24, function25, function32, horizontal2, f5, f4, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj4 = function3;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if ((i & 805306368) == 0) {
                    }
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function23;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                obj4 = function3;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i10 = i3 & 1024;
                if (i10 != 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = function22;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            obj3 = function23;
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            obj4 = function3;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        obj2 = function22;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        obj3 = function23;
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        obj4 = function3;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of LargeTopAppBar with collapsedHeight and expandedHeight parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LargeTopAppBar(final Function2 function2, Modifier modifier, Function2 function22, Function3 function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2 function23;
        int i3;
        Object obj;
        int i4;
        Function2<Composer, Integer, Unit> function24;
        int i5;
        Function3<RowScope, Composer, Integer, Unit> function32;
        Object obj2;
        Object obj3;
        int i6;
        Object obj4;
        Composer composer2;
        final Modifier modifier2;
        final Function2 function25;
        final Function3 function33;
        final WindowInsets windowInsets2;
        final TopAppBarColors topAppBarColors2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        int i7;
        Function3 function34;
        Modifier modifier3;
        WindowInsets windowInsets3;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-330927229);
        ComposerKt.sourceInformation(startRestartGroup, "C(LargeTopAppBar)N(title,modifier,navigationIcon,actions,windowInsets,colors,scrollBehavior)696@34858L386:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            obj2 = windowInsets;
                            if (startRestartGroup.changed(obj2)) {
                                i9 = 16384;
                                i3 |= i9;
                            }
                        } else {
                            obj2 = windowInsets;
                        }
                        i9 = 8192;
                        i3 |= i9;
                    } else {
                        obj2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj3 = topAppBarColors;
                            if (startRestartGroup.changed(obj3)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            obj3 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        obj3 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        obj4 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(obj4) ? 1048576 : 524288;
                        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "692@34716L12,693@34778L17");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                topAppBarColors3 = obj3;
                                topAppBarScrollBehavior3 = obj4;
                                i7 = -330927229;
                                function34 = function32;
                                windowInsets3 = obj2;
                                modifier3 = obj;
                            } else {
                                Modifier.Companion companion = i10 != 0 ? Modifier.Companion : obj;
                                if (i4 != 0) {
                                    function24 = ComposableSingletons$AppBarKt.INSTANCE.m1932getLambda$699106370$material3();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1702484764$material3();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    obj2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    obj3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    topAppBarScrollBehavior3 = null;
                                    topAppBarColors3 = obj3;
                                } else {
                                    topAppBarColors3 = obj3;
                                    topAppBarScrollBehavior3 = obj4;
                                }
                                i7 = -330927229;
                                function34 = function32;
                                modifier3 = companion;
                                windowInsets3 = obj2;
                            }
                            Function2 function26 = function24;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i7, i3, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:696)");
                            }
                            int i11 = i3 << 6;
                            composer2 = startRestartGroup;
                            m1725LargeTopAppBaroKE7A98(function23, modifier3, function26, function34, TopAppBarDefaults.INSTANCE.m2916getLargeAppBarCollapsedHeightD9Ej5fM(), TopAppBarDefaults.INSTANCE.m2917getLargeAppBarExpandedHeightD9Ej5fM(), windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, composer2, (3670016 & i11) | (i3 & 14) | 221184 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (29360128 & i11) | (i11 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            function25 = function26;
                            function33 = function34;
                            windowInsets2 = windowInsets3;
                            topAppBarColors2 = topAppBarColors3;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = obj;
                            function25 = function24;
                            function33 = function32;
                            windowInsets2 = obj2;
                            topAppBarColors2 = obj3;
                            topAppBarScrollBehavior2 = obj4;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return AppBarKt.LargeTopAppBar$lambda$8(Function2.this, modifier2, function25, function33, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj4 = topAppBarScrollBehavior;
                    if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                obj4 = topAppBarScrollBehavior;
                if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            obj4 = topAppBarScrollBehavior;
            if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        obj4 = topAppBarScrollBehavior;
        if (startRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fd  */
    /* renamed from: LargeTopAppBar-oKE7A98  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1725LargeTopAppBaroKE7A98(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i3;
        Modifier.Companion companion;
        int i4;
        Function2<Composer, Integer, Unit> function24;
        int i5;
        Function3<RowScope, Composer, Integer, Unit> function32;
        int i6;
        float f3;
        int i7;
        float f4;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final WindowInsets windowInsets2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        final float f5;
        final float f6;
        final TopAppBarColors topAppBarColors2;
        ScopeUpdateScope endRestartGroup;
        WindowInsets windowInsets3;
        int i11;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        WindowInsets windowInsets4;
        TopAppBarColors topAppBarColors4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        float f7;
        Modifier modifier3;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1406602045);
        ComposerKt.sourceInformation(startRestartGroup, "C(LargeTopAppBar)N(title,modifier,navigationIcon,actions,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)765@38799L5,766@38864L5,763@38705L1138:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function23 = function2;
        } else {
            function23 = function2;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function23) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function24 = function22;
                i3 |= startRestartGroup.changedInstance(function24) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? 2048 : 1024;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        f3 = f;
                        i3 |= startRestartGroup.changed(f3) ? 16384 : 8192;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((196608 & i) == 0) {
                            f4 = f2;
                            i3 |= startRestartGroup.changed(f4) ? 131072 : 65536;
                            if ((i & 1572864) == 0) {
                                i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(windowInsets)) ? 1048576 : 524288;
                            }
                            if ((i & 12582912) == 0) {
                                if ((i2 & 128) == 0 && startRestartGroup.changed(topAppBarColors)) {
                                    i13 = 8388608;
                                    i3 |= i13;
                                }
                                i13 = 4194304;
                                i3 |= i13;
                            }
                            i8 = i2 & 256;
                            if (i8 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i9 = i8;
                                i3 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 67108864 : 33554432;
                                i10 = i3;
                                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "759@38563L12,760@38625L17");
                                    if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                        if (i14 != 0) {
                                            companion = Modifier.Companion;
                                        }
                                        if (i4 != 0) {
                                            function24 = ComposableSingletons$AppBarKt.INSTANCE.m1918getLambda$1230986050$material3();
                                        }
                                        if (i5 != 0) {
                                            function32 = ComposableSingletons$AppBarKt.INSTANCE.getLambda$1921811868$material3();
                                        }
                                        if (i6 != 0) {
                                            f3 = TopAppBarDefaults.INSTANCE.m2916getLargeAppBarCollapsedHeightD9Ej5fM();
                                        }
                                        if (i7 != 0) {
                                            f4 = TopAppBarDefaults.INSTANCE.m2917getLargeAppBarExpandedHeightD9Ej5fM();
                                        }
                                        if ((i2 & 64) != 0) {
                                            windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                            i11 = i10 & (-3670017);
                                        } else {
                                            windowInsets3 = windowInsets;
                                            i11 = i10;
                                        }
                                        if ((i2 & 128) != 0) {
                                            topAppBarColors3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                            i11 &= -29360129;
                                        } else {
                                            topAppBarColors3 = topAppBarColors;
                                        }
                                        if (i9 != 0) {
                                            windowInsets4 = windowInsets3;
                                            topAppBarColors4 = topAppBarColors3;
                                            function26 = function24;
                                            topAppBarScrollBehavior3 = null;
                                        } else {
                                            topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                            windowInsets4 = windowInsets3;
                                            topAppBarColors4 = topAppBarColors3;
                                            function26 = function24;
                                        }
                                        function34 = function32;
                                        f7 = f3;
                                        modifier3 = companion;
                                        i12 = i11;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        int i15 = (i2 & 64) != 0 ? i10 & (-3670017) : i10;
                                        if ((i2 & 128) != 0) {
                                            i15 &= -29360129;
                                        }
                                        Modifier modifier4 = companion;
                                        i12 = i15;
                                        f7 = f3;
                                        modifier3 = modifier4;
                                        windowInsets4 = windowInsets;
                                        topAppBarColors4 = topAppBarColors;
                                        topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                        function26 = function24;
                                        function34 = function32;
                                    }
                                    float f8 = f4;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1406602045, i12, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:763)");
                                    }
                                    int i16 = i12 >> 3;
                                    composer2 = startRestartGroup;
                                    m1733TwoRowsTopAppBarpJA5dT0(modifier3, function23, TypographyKt.getValue(AppBarLargeTokens.INSTANCE.getTitleFont(), startRestartGroup, 6), LargeTitleBottomPadding, function2, TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), startRestartGroup, 6), null, TextStyle.Companion.getDefault(), null, TextStyle.Companion.getDefault(), Alignment.Companion.getStart(), function26, function34, (Dp.m7560equalsimpl0(f7, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(f7, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2916getLargeAppBarCollapsedHeightD9Ej5fM() : f7, (Dp.m7560equalsimpl0(f8, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(f8, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2917getLargeAppBarExpandedHeightD9Ej5fM() : f8, windowInsets4, topAppBarColors4, topAppBarScrollBehavior3, composer2, (i16 & 14) | 920128512 | ((i12 << 3) & 112) | ((i12 << 12) & 57344), 6 | (i16 & 112) | (i16 & 896) | (458752 & i16) | (3670016 & i16) | (29360128 & i16), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f5 = f7;
                                    f6 = f8;
                                    modifier2 = modifier3;
                                    function25 = function26;
                                    function33 = function34;
                                    windowInsets2 = windowInsets4;
                                    topAppBarColors2 = topAppBarColors4;
                                    topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    windowInsets2 = windowInsets;
                                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                    modifier2 = companion;
                                    function25 = function24;
                                    function33 = function32;
                                    f5 = f3;
                                    f6 = f4;
                                    topAppBarColors2 = topAppBarColors;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AppBarKt.LargeTopAppBar_oKE7A98$lambda$9(Function2.this, modifier2, function25, function33, f5, f6, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i9 = i8;
                            i10 = i3;
                            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        f4 = f2;
                        if ((i & 1572864) == 0) {
                        }
                        if ((i & 12582912) == 0) {
                        }
                        i8 = i2 & 256;
                        if (i8 == 0) {
                        }
                        i9 = i8;
                        i10 = i3;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    f3 = f;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    f4 = f2;
                    if ((i & 1572864) == 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    i10 = i3;
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                f3 = f;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                f4 = f2;
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3;
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function24 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            f3 = f;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            f4 = f2;
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3;
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function24 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        f3 = f;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        f4 = f2;
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3;
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i10 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:218:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    /* renamed from: LargeFlexibleTopAppBar-eXZ4JBQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1724LargeFlexibleTopAppBareXZ4JBQ(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Alignment.Horizontal horizontal, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        Object obj2;
        int i6;
        Object obj3;
        int i7;
        Object obj4;
        int i8;
        int i9;
        float f3;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final Alignment.Horizontal horizontal2;
        final TopAppBarColors topAppBarColors2;
        final float f4;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        final float f5;
        final WindowInsets windowInsets2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        float m2916getLargeAppBarCollapsedHeightD9Ej5fM;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        Alignment.Horizontal horizontal3;
        WindowInsets windowInsets4;
        TopAppBarColors topAppBarColors4;
        Modifier modifier3;
        float m2919getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM;
        float f6;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(1104319839);
        ComposerKt.sourceInformation(startRestartGroup, "C(LargeFlexibleTopAppBar)N(title,modifier,subtitle,navigationIcon,actions,titleHorizontalAlignment,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)860@43856L5,861@43921L5,866@44141L5,868@44252L5,858@43754L1415:AppBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i16 = i3 & 2;
        if (i16 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = function22;
                i4 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj3 = function23;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        obj4 = function3;
                        i4 |= startRestartGroup.changedInstance(obj4) ? 16384 : 8192;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changed(horizontal) ? 131072 : 65536;
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(f) ? 1048576 : 524288;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i3 & 128) == 0) {
                                f3 = f2;
                                if (startRestartGroup.changed(f3)) {
                                    i15 = 8388608;
                                    i4 |= i15;
                                }
                            } else {
                                f3 = f2;
                            }
                            i15 = 4194304;
                            i4 |= i15;
                        } else {
                            f3 = f2;
                        }
                        if ((i & 100663296) == 0) {
                            if ((i3 & 256) == 0 && startRestartGroup.changed(windowInsets)) {
                                i14 = 67108864;
                                i4 |= i14;
                            }
                            i14 = 33554432;
                            i4 |= i14;
                        }
                        if ((i & 805306368) == 0) {
                            if ((i3 & 512) == 0 && startRestartGroup.changed(topAppBarColors)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                                i4 |= i13;
                            }
                            i13 = 268435456;
                            i4 |= i13;
                        }
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i11 = i10;
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changed(topAppBarScrollBehavior) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "854@43612L12,855@43674L17");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                if ((i3 & 512) != 0) {
                                    i4 &= -1879048193;
                                }
                                horizontal3 = horizontal;
                                windowInsets4 = windowInsets;
                                topAppBarColors4 = topAppBarColors;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                function26 = obj3;
                                function33 = obj4;
                                m2916getLargeAppBarCollapsedHeightD9Ej5fM = f;
                                modifier3 = obj;
                            } else {
                                Modifier.Companion companion = i16 != 0 ? Modifier.Companion : obj;
                                if (i5 != 0) {
                                    obj2 = null;
                                }
                                Function2<Composer, Integer, Unit> m1933getLambda$780193532$material3 = i6 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1933getLambda$780193532$material3() : obj3;
                                Function3<RowScope, Composer, Integer, Unit> m1923getLambda$1846660506$material3 = i7 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1923getLambda$1846660506$material3() : obj4;
                                Alignment.Horizontal start = i8 != 0 ? Alignment.Companion.getStart() : horizontal;
                                m2916getLargeAppBarCollapsedHeightD9Ej5fM = i9 != 0 ? TopAppBarDefaults.INSTANCE.m2916getLargeAppBarCollapsedHeightD9Ej5fM() : f;
                                if ((i3 & 128) != 0) {
                                    if (obj2 != null) {
                                        f3 = TopAppBarDefaults.INSTANCE.m2918getLargeFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
                                    } else {
                                        f3 = TopAppBarDefaults.INSTANCE.m2919getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
                                    }
                                    i4 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    windowInsets3 = windowInsets;
                                }
                                if ((i3 & 512) != 0) {
                                    topAppBarColors3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                    i4 &= -1879048193;
                                } else {
                                    topAppBarColors3 = topAppBarColors;
                                }
                                topAppBarScrollBehavior3 = i11 != 0 ? null : topAppBarScrollBehavior;
                                function26 = m1933getLambda$780193532$material3;
                                function33 = m1923getLambda$1846660506$material3;
                                horizontal3 = start;
                                windowInsets4 = windowInsets3;
                                topAppBarColors4 = topAppBarColors3;
                                modifier3 = companion;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1104319839, i4, i12, "androidx.compose.material3.LargeFlexibleTopAppBar (AppBar.kt:858)");
                            }
                            TextStyle value = TypographyKt.getValue(AppBarLargeFlexibleTokens.INSTANCE.getTitleFont(), startRestartGroup, 6);
                            TextStyle value2 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), startRestartGroup, 6);
                            float f7 = LargeTitleBottomPadding;
                            Function2<Composer, Integer, Unit> m1931getLambda$661145402$material3 = obj2 == null ? ComposableSingletons$AppBarKt.INSTANCE.m1931getLambda$661145402$material3() : obj2;
                            TextStyle value3 = TypographyKt.getValue(AppBarLargeFlexibleTokens.INSTANCE.getSubtitleFont(), startRestartGroup, 6);
                            Function2<Composer, Integer, Unit> m1916getLambda$1113422563$material3 = obj2 == null ? ComposableSingletons$AppBarKt.INSTANCE.m1916getLambda$1113422563$material3() : obj2;
                            TextStyle value4 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getSubtitleFont(), startRestartGroup, 6);
                            float m2916getLargeAppBarCollapsedHeightD9Ej5fM2 = (Dp.m7560equalsimpl0(m2916getLargeAppBarCollapsedHeightD9Ej5fM, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(m2916getLargeAppBarCollapsedHeightD9Ej5fM, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2916getLargeAppBarCollapsedHeightD9Ej5fM() : m2916getLargeAppBarCollapsedHeightD9Ej5fM;
                            if (Dp.m7560equalsimpl0(f3, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(f3, Dp.Companion.m7574getInfinityD9Ej5fM())) {
                                if (obj2 != null) {
                                    m2919getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM = TopAppBarDefaults.INSTANCE.m2918getLargeFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
                                } else {
                                    m2919getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM = TopAppBarDefaults.INSTANCE.m2919getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
                                }
                                f6 = m2919getLargeFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM;
                            } else {
                                f6 = f3;
                            }
                            int i17 = i4 >> 6;
                            int i18 = ((i4 >> 15) & 14) | (i17 & 112) | (i17 & 896);
                            int i19 = i4 >> 9;
                            composer2 = startRestartGroup;
                            m1733TwoRowsTopAppBarpJA5dT0(modifier3, function2, value, f7, function2, value2, m1931getLambda$661145402$material3, value3, m1916getLambda$1113422563$material3, value4, horizontal3, function26, function33, m2916getLargeAppBarCollapsedHeightD9Ej5fM2, f6, windowInsets4, topAppBarColors4, topAppBarScrollBehavior3, composer2, ((i4 >> 3) & 14) | 3072 | ((i4 << 3) & 112) | ((i4 << 12) & 57344), i18 | (458752 & i19) | (i19 & 3670016) | ((i12 << 21) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f4 = f3;
                            function24 = obj2;
                            f5 = m2916getLargeAppBarCollapsedHeightD9Ej5fM;
                            modifier2 = modifier3;
                            horizontal2 = horizontal3;
                            function25 = function26;
                            function32 = function33;
                            windowInsets2 = windowInsets4;
                            topAppBarColors2 = topAppBarColors4;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal2 = horizontal;
                            topAppBarColors2 = topAppBarColors;
                            f4 = f3;
                            modifier2 = obj;
                            function24 = obj2;
                            function25 = obj3;
                            function32 = obj4;
                            f5 = f;
                            windowInsets2 = windowInsets;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return AppBarKt.LargeFlexibleTopAppBar_eXZ4JBQ$lambda$10(Function2.this, modifier2, function24, function25, function32, horizontal2, f5, f4, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj4 = function3;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if ((i & 805306368) == 0) {
                    }
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function23;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                obj4 = function3;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i10 = i3 & 1024;
                if (i10 != 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = function22;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            obj3 = function23;
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            obj4 = function3;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        obj2 = function22;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        obj3 = function23;
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        obj4 = function3;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0112  */
    /* renamed from: TwoRowsTopAppBar-eXZ4JBQ  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1732TwoRowsTopAppBareXZ4JBQ(final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function32, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33, Alignment.Horizontal horizontal, float f, float f2, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        int i5;
        final Object obj2;
        int i6;
        Object obj3;
        int i7;
        Object obj4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Composer composer2;
        final Alignment.Horizontal horizontal2;
        final float f3;
        final TopAppBarColors topAppBarColors2;
        final Modifier modifier2;
        final Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function35;
        final float f4;
        final WindowInsets windowInsets2;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        float m7575getUnspecifiedD9Ej5fM;
        float m7575getUnspecifiedD9Ej5fM2;
        WindowInsets windowInsets3;
        int i15;
        TopAppBarColors topAppBarColors3;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        TopAppBarColors topAppBarColors4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function36;
        Alignment.Horizontal horizontal3;
        WindowInsets windowInsets4;
        Modifier modifier3;
        int i16;
        float m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM;
        float f5;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(1672878784);
        ComposerKt.sourceInformation(startRestartGroup, "C(TwoRowsTopAppBar)N(title,modifier,subtitle,navigationIcon,actions,titleHorizontalAlignment,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)965@49886L5,966@49951L5,971@50176L5,973@50300L5,964@49807L15,968@50014L16,970@50080L26,972@50207L27,963@49773L1578:AppBar.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i19 = i3 & 2;
        if (i19 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj2 = function32;
                i4 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj3 = function2;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 2048 : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        obj4 = function33;
                        i4 |= startRestartGroup.changedInstance(obj4) ? 16384 : 8192;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changed(horizontal) ? 131072 : 65536;
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(f) ? 1048576 : 524288;
                        }
                        i10 = i3 & 128;
                        if (i10 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
                        }
                        if ((i & 100663296) == 0) {
                            if ((i3 & 256) == 0 && startRestartGroup.changed(windowInsets)) {
                                i18 = 67108864;
                                i4 |= i18;
                            }
                            i18 = 33554432;
                            i4 |= i18;
                        }
                        if ((i & 805306368) == 0) {
                            if ((i3 & 512) == 0 && startRestartGroup.changed(topAppBarColors)) {
                                i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                                i4 |= i17;
                            }
                            i17 = 268435456;
                            i4 |= i17;
                        }
                        i11 = i3 & 1024;
                        if (i11 != 0) {
                            i12 = i11;
                            i13 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i12 = i11;
                            i13 = i2 | (startRestartGroup.changed(topAppBarScrollBehavior) ? 4 : 2);
                        } else {
                            i12 = i11;
                            i13 = i2;
                        }
                        i14 = i4;
                        if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 3) != 2, i14 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "959@49631L12,960@49693L17");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                i16 = (i3 & 256) != 0 ? i14 & (-234881025) : i14;
                                if ((i3 & 512) != 0) {
                                    i16 &= -1879048193;
                                }
                                horizontal3 = horizontal;
                                m7575getUnspecifiedD9Ej5fM2 = f2;
                                windowInsets4 = windowInsets;
                                topAppBarColors4 = topAppBarColors;
                                topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                function23 = obj3;
                                function36 = obj4;
                                m7575getUnspecifiedD9Ej5fM = f;
                                modifier3 = obj;
                            } else {
                                Modifier.Companion companion = i19 != 0 ? Modifier.Companion : obj;
                                if (i5 != 0) {
                                    obj2 = null;
                                }
                                Function2<Composer, Integer, Unit> lambda$1767216677$material3 = i6 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.getLambda$1767216677$material3() : obj3;
                                Function3<RowScope, Composer, Integer, Unit> m1928getLambda$470693625$material3 = i7 != 0 ? ComposableSingletons$AppBarKt.INSTANCE.m1928getLambda$470693625$material3() : obj4;
                                Alignment.Horizontal start = i8 != 0 ? Alignment.Companion.getStart() : horizontal;
                                m7575getUnspecifiedD9Ej5fM = i9 != 0 ? Dp.Companion.m7575getUnspecifiedD9Ej5fM() : f;
                                m7575getUnspecifiedD9Ej5fM2 = i10 != 0 ? Dp.Companion.m7575getUnspecifiedD9Ej5fM() : f2;
                                if ((i3 & 256) != 0) {
                                    windowInsets3 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    i15 = i14 & (-234881025);
                                } else {
                                    windowInsets3 = windowInsets;
                                    i15 = i14;
                                }
                                if ((i3 & 512) != 0) {
                                    topAppBarColors3 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                    i15 &= -1879048193;
                                } else {
                                    topAppBarColors3 = topAppBarColors;
                                }
                                if (i12 != 0) {
                                    topAppBarColors4 = topAppBarColors3;
                                    function23 = lambda$1767216677$material3;
                                    function36 = m1928getLambda$470693625$material3;
                                    horizontal3 = start;
                                    windowInsets4 = windowInsets3;
                                    topAppBarScrollBehavior3 = null;
                                } else {
                                    topAppBarScrollBehavior3 = topAppBarScrollBehavior;
                                    topAppBarColors4 = topAppBarColors3;
                                    function23 = lambda$1767216677$material3;
                                    function36 = m1928getLambda$470693625$material3;
                                    horizontal3 = start;
                                    windowInsets4 = windowInsets3;
                                }
                                modifier3 = companion;
                                i16 = i15;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1672878784, i16, i13, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:962)");
                            }
                            TextStyle value = TypographyKt.getValue(AppBarMediumFlexibleTokens.INSTANCE.getTitleFont(), startRestartGroup, 6);
                            TextStyle value2 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getTitleFont(), startRestartGroup, 6);
                            float m7555constructorimpl = Dp.m7555constructorimpl(0.0f);
                            TextStyle value3 = TypographyKt.getValue(AppBarMediumFlexibleTokens.INSTANCE.getSubtitleFont(), startRestartGroup, 6);
                            TextStyle value4 = TypographyKt.getValue(AppBarSmallTokens.INSTANCE.getSubtitleFont(), startRestartGroup, 6);
                            float m2920getMediumAppBarCollapsedHeightD9Ej5fM = (Dp.m7560equalsimpl0(m7575getUnspecifiedD9Ej5fM, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(m7575getUnspecifiedD9Ej5fM, Dp.Companion.m7574getInfinityD9Ej5fM())) ? TopAppBarDefaults.INSTANCE.m2920getMediumAppBarCollapsedHeightD9Ej5fM() : m7575getUnspecifiedD9Ej5fM;
                            if (Dp.m7560equalsimpl0(m7575getUnspecifiedD9Ej5fM2, Dp.Companion.m7575getUnspecifiedD9Ej5fM()) || Dp.m7560equalsimpl0(m7575getUnspecifiedD9Ej5fM2, Dp.Companion.m7574getInfinityD9Ej5fM())) {
                                if (obj2 != null) {
                                    m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM = TopAppBarDefaults.INSTANCE.m2922getMediumFlexibleAppBarWithSubtitleExpandedHeightD9Ej5fM();
                                } else {
                                    m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM = TopAppBarDefaults.INSTANCE.m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM();
                                }
                                f5 = m2923getMediumFlexibleAppBarWithoutSubtitleExpandedHeightD9Ej5fM;
                            } else {
                                f5 = m7575getUnspecifiedD9Ej5fM2;
                            }
                            int i20 = i16 >> 6;
                            int i21 = i16 >> 9;
                            composer2 = startRestartGroup;
                            m1733TwoRowsTopAppBarpJA5dT0(modifier3, ComposableLambdaKt.rememberComposableLambda(-1674885936, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i22) {
                                    ComposerKt.sourceInformation(composer3, "C964@49809L11:AppBar.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i22 & 3) != 2, i22 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1674885936, i22, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:964)");
                                    }
                                    function3.invoke(true, composer3, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), value, m7555constructorimpl, ComposableLambdaKt.rememberComposableLambda(1295408045, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i22) {
                                    ComposerKt.sourceInformation(composer3, "C968@50016L12:AppBar.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i22 & 3) != 2, i22 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1295408045, i22, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:968)");
                                    }
                                    function3.invoke(false, composer3, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), value2, ComposableLambdaKt.rememberComposableLambda(1843948267, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i22) {
                                    ComposerKt.sourceInformation(composer3, "C:AppBar.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i22 & 3) != 2, i22 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1843948267, i22, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:970)");
                                    }
                                    Function3<Boolean, Composer, Integer, Unit> function37 = obj2;
                                    if (function37 == null) {
                                        composer3.startReplaceGroup(431118634);
                                    } else {
                                        composer3.startReplaceGroup(-1787208265);
                                        ComposerKt.sourceInformation(composer3, "970@50092L12");
                                        function37.invoke(true, composer3, 6);
                                    }
                                    composer3.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), value3, ComposableLambdaKt.rememberComposableLambda(-1902478807, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i22) {
                                    ComposerKt.sourceInformation(composer3, "C:AppBar.kt#uh7d8r");
                                    if (!composer3.shouldExecute((i22 & 3) != 2, i22 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1902478807, i22, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:972)");
                                    }
                                    Function3<Boolean, Composer, Integer, Unit> function37 = obj2;
                                    if (function37 == null) {
                                        composer3.startReplaceGroup(-357689013);
                                    } else {
                                        composer3.startReplaceGroup(1373934966);
                                        ComposerKt.sourceInformation(composer3, "972@50219L13");
                                        function37.invoke(false, composer3, 6);
                                    }
                                    composer3.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), value4, horizontal3, function23, function36, m2920getMediumAppBarCollapsedHeightD9Ej5fM, f5, windowInsets4, topAppBarColors4, topAppBarScrollBehavior3, composer2, ((i16 >> 3) & 14) | 102263856, (i21 & 3670016) | ((i16 >> 15) & 14) | (i20 & 112) | (i20 & 896) | (458752 & i21) | ((i13 << 21) & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function34 = obj2;
                            f4 = m7575getUnspecifiedD9Ej5fM;
                            f3 = m7575getUnspecifiedD9Ej5fM2;
                            modifier2 = modifier3;
                            horizontal2 = horizontal3;
                            function22 = function23;
                            function35 = function36;
                            windowInsets2 = windowInsets4;
                            topAppBarColors2 = topAppBarColors4;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            horizontal2 = horizontal;
                            f3 = f2;
                            topAppBarColors2 = topAppBarColors;
                            modifier2 = obj;
                            function34 = obj2;
                            function22 = obj3;
                            function35 = obj4;
                            f4 = f;
                            windowInsets2 = windowInsets;
                            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj5, Object obj6) {
                                    return AppBarKt.TwoRowsTopAppBar_eXZ4JBQ$lambda$11(Function3.this, modifier2, function34, function22, function35, horizontal2, f4, f3, windowInsets2, topAppBarColors2, topAppBarScrollBehavior2, i, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj4 = function33;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    i10 = i3 & 128;
                    if (i10 != 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if ((i & 805306368) == 0) {
                    }
                    i11 = i3 & 1024;
                    if (i11 != 0) {
                    }
                    i14 = i4;
                    if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 3) != 2, i14 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function2;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                obj4 = function33;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                i10 = i3 & 128;
                if (i10 != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i11 = i3 & 1024;
                if (i11 != 0) {
                }
                i14 = i4;
                if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 3) != 2, i14 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = function32;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            obj3 = function2;
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            obj4 = function33;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            i10 = i3 & 128;
            if (i10 != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i11 = i3 & 1024;
            if (i11 != 0) {
            }
            i14 = i4;
            if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 3) != 2, i14 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        obj2 = function32;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        obj3 = function2;
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        obj4 = function33;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        i10 = i3 & 128;
        if (i10 != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i11 = i3 & 1024;
        if (i11 != 0) {
        }
        i14 = i4;
        if (startRestartGroup.shouldExecute((i14 & 306783379) == 306783378 || (i13 & 3) != 2, i14 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010b  */
    /* renamed from: BottomAppBar-Snr_uVM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1718BottomAppBarSnr_uVM(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, Composer composer, final int i, final int i2) {
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        int i3;
        Modifier.Companion companion;
        int i4;
        Object obj;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        Composer composer2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final long j5;
        final long j6;
        final float f3;
        final PaddingValues paddingValues2;
        final WindowInsets windowInsets2;
        ScopeUpdateScope endRestartGroup;
        WindowInsets windowInsets3;
        PaddingValues paddingValues3;
        Modifier modifier3;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-2144093983);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)N(actions,modifier,floatingActionButton,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets)1044@53613L356:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function32 = function3;
        } else {
            function32 = function3;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function32) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = function2;
                i3 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i9 = 2048;
                            i3 |= i9;
                        }
                    } else {
                        j3 = j;
                    }
                    i9 = 1024;
                    i3 |= i9;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i8 = 16384;
                            i3 |= i8;
                        }
                    } else {
                        j4 = j2;
                    }
                    i8 = 8192;
                    i3 |= i8;
                } else {
                    j4 = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(windowInsets)) {
                            i7 = 8388608;
                            i3 |= i7;
                        }
                        i7 = 4194304;
                        i3 |= i7;
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "1038@53323L14,1039@53365L31,1042@53591L12");
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
                            paddingValues3 = paddingValues;
                            windowInsets3 = windowInsets;
                        } else {
                            if (i10 != 0) {
                                companion = Modifier.Companion;
                            }
                            if (i4 != 0) {
                                obj = null;
                            }
                            if ((i2 & 8) != 0) {
                                j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            }
                            if (i5 != 0) {
                                f2 = BottomAppBarDefaults.INSTANCE.m1744getContainerElevationD9Ej5fM();
                            }
                            PaddingValues contentPadding = i6 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                                paddingValues3 = contentPadding;
                                modifier3 = companion;
                                windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                long j7 = j3;
                                long j8 = j4;
                                float f4 = f2;
                                Function2<? super Composer, ? super Integer, Unit> function23 = obj;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2144093983, i3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1044)");
                                }
                                composer2 = startRestartGroup;
                                m1720BottomAppBarqhFBPw4(function32, modifier3, function23, j7, j8, f4, paddingValues3, windowInsets3, null, composer2, (i3 & 14) | 100663296 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                function22 = function23;
                                j5 = j7;
                                j6 = j8;
                                f3 = f4;
                                paddingValues2 = paddingValues3;
                                windowInsets2 = windowInsets3;
                            } else {
                                windowInsets3 = windowInsets;
                                paddingValues3 = contentPadding;
                            }
                        }
                        modifier3 = companion;
                        long j72 = j3;
                        long j82 = j4;
                        float f42 = f2;
                        Function2<? super Composer, ? super Integer, Unit> function232 = obj;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        m1720BottomAppBarqhFBPw4(function32, modifier3, function232, j72, j82, f42, paddingValues3, windowInsets3, null, composer2, (i3 & 14) | 100663296 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier3;
                        function22 = function232;
                        j5 = j72;
                        j6 = j82;
                        f3 = f42;
                        paddingValues2 = paddingValues3;
                        windowInsets2 = windowInsets3;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = companion;
                        function22 = obj;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        paddingValues2 = paddingValues;
                        windowInsets2 = windowInsets;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                return AppBarKt.BottomAppBar_Snr_uVM$lambda$12(Function3.this, modifier2, function22, j5, j6, f3, paddingValues2, windowInsets2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                f2 = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj = function2;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj = function2;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* renamed from: BottomAppBar-qhFBPw4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1720BottomAppBarqhFBPw4(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        final Object obj;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        int i8;
        Composer composer2;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final long j5;
        final long j6;
        final float f3;
        final PaddingValues paddingValues2;
        final WindowInsets windowInsets2;
        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        WindowInsets windowInsets3;
        BottomAppBarScrollBehavior bottomAppBarScrollBehavior3;
        float f4;
        PaddingValues paddingValues3;
        WindowInsets windowInsets4;
        int i9;
        Modifier modifier3;
        long j7;
        int i10;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(272234465);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)N(actions,modifier,floatingActionButton,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets,scrollBehavior)1118@57288L540,1110@57001L827:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj = function2;
                i3 |= startRestartGroup.changedInstance(obj) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i13 = 2048;
                            i3 |= i13;
                        }
                    } else {
                        j3 = j;
                    }
                    i13 = 1024;
                    i3 |= i13;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i12 = 16384;
                            i3 |= i12;
                        }
                    } else {
                        j4 = j2;
                    }
                    i12 = 8192;
                    i3 |= i12;
                } else {
                    j4 = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(windowInsets)) {
                            i11 = 8388608;
                            i3 |= i11;
                        }
                        i11 = 4194304;
                        i3 |= i11;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(bottomAppBarScrollBehavior) ? 67108864 : 33554432;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "1103@56655L14,1104@56697L31,1107@56923L12");
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
                                modifier3 = modifier;
                                paddingValues3 = paddingValues;
                                windowInsets4 = windowInsets;
                                bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior;
                                f4 = f2;
                                i10 = 12582912;
                                i9 = 272234465;
                                j7 = j3;
                            } else {
                                Modifier.Companion companion = i14 != 0 ? Modifier.Companion : modifier;
                                if (i4 != 0) {
                                    obj = null;
                                }
                                if ((i2 & 8) != 0) {
                                    j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                    i3 &= -57345;
                                }
                                float m1744getContainerElevationD9Ej5fM = i5 != 0 ? BottomAppBarDefaults.INSTANCE.m1744getContainerElevationD9Ej5fM() : f2;
                                PaddingValues contentPadding = i6 != 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if ((i2 & 128) != 0) {
                                    windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    windowInsets3 = windowInsets;
                                }
                                bottomAppBarScrollBehavior3 = i8 == 0 ? bottomAppBarScrollBehavior : null;
                                f4 = m1744getContainerElevationD9Ej5fM;
                                paddingValues3 = contentPadding;
                                windowInsets4 = windowInsets3;
                                i9 = 272234465;
                                modifier3 = companion;
                                j7 = j3;
                                i10 = 12582912;
                            }
                            long j8 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1110)");
                            }
                            int i15 = i3 >> 6;
                            composer2 = startRestartGroup;
                            m1719BottomAppBare3WI5M(modifier3, j7, j8, f4, paddingValues3, windowInsets4, bottomAppBarScrollBehavior3, ComposableLambdaKt.rememberComposableLambda(-1943077286, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer3, Integer num) {
                                    invoke(rowScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope rowScope, Composer composer3, int i16) {
                                    int i17;
                                    float f5;
                                    float f6;
                                    ComposerKt.sourceInformation(composer3, "C1119@57298L204:AppBar.kt#uh7d8r");
                                    if ((i16 & 6) == 0) {
                                        i17 = i16 | (composer3.changed(rowScope) ? 4 : 2);
                                    } else {
                                        i17 = i16;
                                    }
                                    if (!composer3.shouldExecute((i17 & 19) != 18, i17 & 1)) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1943077286, i17, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:1119)");
                                    }
                                    Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, null);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer3, 54);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, weight$default);
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
                                    function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    if (obj != null) {
                                        composer3.startReplaceGroup(1354051795);
                                        ComposerKt.sourceInformation(composer3, "1126@57559L253");
                                        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, null);
                                        f5 = AppBarKt.FABVerticalPadding;
                                        f6 = AppBarKt.FABHorizontalPadding;
                                        Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f5, f6, 0.0f, 9, null);
                                        Alignment topStart = Alignment.Companion.getTopStart();
                                        Function2<Composer, Integer, Unit> function23 = obj;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m822paddingqDBjuR0$default);
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
                                        ComposerKt.sourceInformationMarkerStart(composer3, 1457541364, "C1131@57776L22:AppBar.kt#uh7d8r");
                                        function23.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceGroup();
                                    } else {
                                        composer3.startReplaceGroup(1354317992);
                                        composer3.endReplaceGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), composer2, i10 | ((i3 >> 3) & 14) | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (i15 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function22 = obj;
                            modifier2 = modifier3;
                            j5 = j7;
                            j6 = j8;
                            f3 = f4;
                            paddingValues2 = paddingValues3;
                            windowInsets2 = windowInsets4;
                            bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = modifier;
                            function22 = obj;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            paddingValues2 = paddingValues;
                            windowInsets2 = windowInsets;
                            bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    return AppBarKt.BottomAppBar_qhFBPw4$lambda$13(Function3.this, modifier2, function22, j5, j6, f3, paddingValues2, windowInsets2, bottomAppBarScrollBehavior2, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                f2 = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj = function2;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        obj = function2;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /* renamed from: BottomAppBar-1oL4kX8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1717BottomAppBar1oL4kX8(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Object obj;
        int i3;
        long j3;
        long j4;
        float f2;
        int i4;
        Object obj2;
        Object obj3;
        Composer composer2;
        final Modifier modifier2;
        final long j5;
        final long j6;
        final float f3;
        final PaddingValues paddingValues2;
        final WindowInsets windowInsets2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        int i5;
        float f4;
        PaddingValues paddingValues3;
        WindowInsets windowInsets3;
        int i6;
        long j7;
        long j8;
        int i7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(107726720);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets,content)1173@59794L303:AppBar.kt#uh7d8r");
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
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i9 = 32;
                    i3 |= i9;
                }
            } else {
                j3 = j;
            }
            i9 = 16;
            i3 |= i9;
        } else {
            j3 = j;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i8 = 256;
                    i3 |= i8;
                }
            } else {
                j4 = j2;
            }
            i8 = 128;
            i3 |= i8;
        } else {
            j4 = j2;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                obj2 = paddingValues;
                i3 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        obj3 = windowInsets;
                        if (startRestartGroup.changed(obj3)) {
                            i7 = 131072;
                            i3 |= i7;
                        }
                    } else {
                        obj3 = windowInsets;
                    }
                    i7 = 65536;
                    i3 |= i7;
                } else {
                    obj3 = windowInsets;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                    if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "1166@59458L14,1167@59500L31,1170@59726L12");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            paddingValues3 = obj2;
                            windowInsets3 = obj3;
                            i5 = 1572864;
                            i6 = 107726720;
                            j7 = j3;
                            j8 = j4;
                            f4 = f2;
                            modifier3 = obj;
                        } else {
                            Modifier.Companion companion = i10 != 0 ? Modifier.Companion : obj;
                            if ((i2 & 2) != 0) {
                                j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                            }
                            if (i11 != 0) {
                                f2 = BottomAppBarDefaults.INSTANCE.m1744getContainerElevationD9Ej5fM();
                            }
                            if (i4 != 0) {
                                obj2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                float f5 = f2;
                                modifier3 = companion;
                                i5 = 1572864;
                                f4 = f5;
                                windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                j8 = j4;
                                paddingValues3 = obj2;
                                i6 = 107726720;
                                j7 = j3;
                            } else {
                                float f6 = f2;
                                modifier3 = companion;
                                i5 = 1572864;
                                f4 = f6;
                                paddingValues3 = obj2;
                                windowInsets3 = obj3;
                                i6 = 107726720;
                                j7 = j3;
                                j8 = j4;
                            }
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1173)");
                        }
                        composer2 = startRestartGroup;
                        m1719BottomAppBare3WI5M(modifier3, j7, j8, f4, paddingValues3, windowInsets3, null, function3, composer2, i5 | (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & (i3 << 3)), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j5 = j7;
                        j6 = j8;
                        f3 = f4;
                        paddingValues2 = paddingValues3;
                        windowInsets2 = windowInsets3;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = obj;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        paddingValues2 = obj2;
                        windowInsets2 = obj3;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                return AppBarKt.BottomAppBar_1oL4kX8$lambda$14(Modifier.this, j5, j6, f3, paddingValues2, windowInsets2, function3, i, i2, (Composer) obj4, ((Integer) obj5).intValue());
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
            obj2 = paddingValues;
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
        f2 = f;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        obj2 = paddingValues;
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

    /* JADX WARN: Removed duplicated region for block: B:130:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:140:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010f  */
    /* renamed from: BottomAppBar-e-3WI5M  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1719BottomAppBare3WI5M(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier.Companion companion;
        int i3;
        long j3;
        long j4;
        float f2;
        int i4;
        Object obj;
        Object obj2;
        int i5;
        Composer composer2;
        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior2;
        final Modifier modifier2;
        final long j5;
        final long j6;
        final float f3;
        final PaddingValues paddingValues2;
        final WindowInsets windowInsets2;
        ScopeUpdateScope endRestartGroup;
        BottomAppBarScrollBehavior bottomAppBarScrollBehavior3;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1562683362);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets,scrollBehavior,content)1227@62600L432:AppBar.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            companion = modifier;
        } else if ((i & 6) == 0) {
            companion = modifier;
            i3 = (startRestartGroup.changed(companion) ? 4 : 2) | i;
        } else {
            companion = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i8 = 32;
                    i3 |= i8;
                }
            } else {
                j3 = j;
            }
            i8 = 16;
            i3 |= i8;
        } else {
            j3 = j;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i7 = 256;
                    i3 |= i7;
                }
            } else {
                j4 = j2;
            }
            i7 = 128;
            i3 |= i7;
        } else {
            j4 = j2;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                obj = paddingValues;
                i3 |= startRestartGroup.changed(obj) ? 16384 : 8192;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        obj2 = windowInsets;
                        if (startRestartGroup.changed(obj2)) {
                            i6 = 131072;
                            i3 |= i6;
                        }
                    } else {
                        obj2 = windowInsets;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    obj2 = windowInsets;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changed(bottomAppBarScrollBehavior) ? 1048576 : 524288;
                }
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                    if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "1219@62208L14,1220@62250L31,1223@62476L12");
                        if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.Companion;
                            }
                            if ((i2 & 2) != 0) {
                                j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                            }
                            if (i10 != 0) {
                                f2 = BottomAppBarDefaults.INSTANCE.m1744getContainerElevationD9Ej5fM();
                            }
                            if (i4 != 0) {
                                obj = BottomAppBarDefaults.INSTANCE.getContentPadding();
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                                obj2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                bottomAppBarScrollBehavior3 = null;
                                long j7 = j3;
                                long j8 = j4;
                                float f4 = f2;
                                PaddingValues paddingValues3 = obj;
                                WindowInsets windowInsets3 = obj2;
                                Modifier modifier3 = companion;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1562683362, i3, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:1226)");
                                }
                                int i11 = i3 << 6;
                                composer2 = startRestartGroup;
                                m1721BottomAppBarLayoutt5fmz9U(BottomAppBarTokens.INSTANCE.m3149getContainerHeightD9Ej5fM(), Arrangement.INSTANCE.getStart(), modifier3, j7, j8, f4, paddingValues3, windowInsets3, bottomAppBarScrollBehavior3, function3, composer2, (i11 & 896) | 54 | (i11 & 7168) | (57344 & i11) | (458752 & i11) | (3670016 & i11) | (29360128 & i11) | (234881024 & i11) | (i11 & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                j5 = j7;
                                j6 = j8;
                                f3 = f4;
                                paddingValues2 = paddingValues3;
                                windowInsets2 = windowInsets3;
                                bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                        }
                        bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior;
                        long j72 = j3;
                        long j82 = j4;
                        float f42 = f2;
                        PaddingValues paddingValues32 = obj;
                        WindowInsets windowInsets32 = obj2;
                        Modifier modifier32 = companion;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i112 = i3 << 6;
                        composer2 = startRestartGroup;
                        m1721BottomAppBarLayoutt5fmz9U(BottomAppBarTokens.INSTANCE.m3149getContainerHeightD9Ej5fM(), Arrangement.INSTANCE.getStart(), modifier32, j72, j82, f42, paddingValues32, windowInsets32, bottomAppBarScrollBehavior3, function3, composer2, (i112 & 896) | 54 | (i112 & 7168) | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & 1879048192), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier32;
                        j5 = j72;
                        j6 = j82;
                        f3 = f42;
                        paddingValues2 = paddingValues32;
                        windowInsets2 = windowInsets32;
                        bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior3;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                        modifier2 = companion;
                        j5 = j3;
                        j6 = j4;
                        f3 = f2;
                        paddingValues2 = obj;
                        windowInsets2 = obj2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                return AppBarKt.BottomAppBar_e_3WI5M$lambda$15(Modifier.this, j5, j6, f3, paddingValues2, windowInsets2, bottomAppBarScrollBehavior2, function3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            obj = paddingValues;
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        f2 = f;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        obj = paddingValues;
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* renamed from: FlexibleBottomAppBar-wBhsO_E  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1723FlexibleBottomAppBarwBhsO_E(Modifier modifier, long j, long j2, PaddingValues paddingValues, Arrangement.Horizontal horizontal, float f, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier.Companion companion;
        int i3;
        long j3;
        long j4;
        Object obj;
        int i4;
        Object obj2;
        int i5;
        int i6;
        int i7;
        Composer composer2;
        final WindowInsets windowInsets2;
        final Modifier modifier2;
        final long j5;
        final long j6;
        final PaddingValues paddingValues2;
        final Arrangement.Horizontal horizontal2;
        final float f2;
        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior2;
        ScopeUpdateScope endRestartGroup;
        float m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3;
        WindowInsets windowInsets3;
        BottomAppBarScrollBehavior bottomAppBarScrollBehavior3;
        WindowInsets windowInsets4;
        long j7;
        long j8;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1717957447);
        ComposerKt.sourceInformation(startRestartGroup, "C(FlexibleBottomAppBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,contentPadding,horizontalArrangement,expandedHeight:c#ui.unit.Dp,windowInsets,scrollBehavior,content)1298@66503L646:AppBar.kt#uh7d8r");
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
            companion = modifier;
        } else if ((i & 6) == 0) {
            companion = modifier;
            i3 = (startRestartGroup.changed(companion) ? 4 : 2) | i;
        } else {
            companion = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i9 = 32;
                    i3 |= i9;
                }
            } else {
                j3 = j;
            }
            i9 = 16;
            i3 |= i9;
        } else {
            j3 = j;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i8 = 256;
                    i3 |= i8;
                }
            } else {
                j4 = j2;
            }
            i8 = 128;
            i3 |= i8;
        } else {
            j4 = j2;
        }
        int i11 = i2 & 8;
        if (i11 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            obj = paddingValues;
            i3 |= startRestartGroup.changed(obj) ? 2048 : 1024;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                obj2 = horizontal;
                i3 |= startRestartGroup.changed(obj2) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changed(f) ? 131072 : 65536;
                }
                if ((i & 1572864) == 0) {
                    i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(windowInsets)) ? 1048576 : 524288;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i7 = i6;
                    i3 |= startRestartGroup.changed(bottomAppBarScrollBehavior) ? 8388608 : 4194304;
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "1288@65983L14,1289@66025L31,1294@66379L12");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 2) != 0) {
                                    i3 &= -113;
                                }
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3 = f;
                                windowInsets4 = windowInsets;
                                bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior;
                            } else {
                                if (i10 != 0) {
                                    companion = Modifier.Companion;
                                }
                                if ((i2 & 2) != 0) {
                                    j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                    i3 &= -113;
                                }
                                if ((i2 & 4) != 0) {
                                    j4 = ColorSchemeKt.m1902contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                                    i3 &= -897;
                                }
                                if (i11 != 0) {
                                    obj = BottomAppBarDefaults.INSTANCE.getFlexibleContentPadding$material3();
                                }
                                if (i4 != 0) {
                                    obj2 = BottomAppBarDefaults.INSTANCE.getFlexibleHorizontalArrangement$material3();
                                }
                                m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3 = i5 != 0 ? BottomAppBarDefaults.INSTANCE.m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3() : f;
                                if ((i2 & 64) != 0) {
                                    windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    windowInsets3 = windowInsets;
                                }
                                if (i7 != 0) {
                                    windowInsets4 = windowInsets3;
                                    j7 = j3;
                                    j8 = j4;
                                    bottomAppBarScrollBehavior3 = null;
                                    PaddingValues paddingValues3 = obj;
                                    Arrangement.Horizontal horizontal3 = obj2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1717957447, i3, -1, "androidx.compose.material3.FlexibleBottomAppBar (AppBar.kt:1297)");
                                    }
                                    int i12 = i3 << 6;
                                    int i13 = i3 << 3;
                                    composer2 = startRestartGroup;
                                    Modifier modifier3 = companion;
                                    m1721BottomAppBarLayoutt5fmz9U(((Float.floatToRawIntBits(m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3) & Integer.MAX_VALUE) < 2139095040 || Float.isNaN(m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3) || Dp.m7554compareTo0680j_4(m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3, Dp.m7555constructorimpl(0.0f)) <= 0) ? BottomAppBarDefaults.INSTANCE.m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3() : m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3, horizontal3, modifier3, j7, j8, AppBarTokens.INSTANCE.m3120getContainerElevationD9Ej5fM(), paddingValues3, windowInsets4, bottomAppBarScrollBehavior3, function3, composer2, ((i3 >> 9) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i12 & 896) | (i12 & 7168) | (i12 & 57344) | (3670016 & (i3 << 9)) | (29360128 & i13) | (234881024 & i13) | (i13 & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f2 = m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3;
                                    horizontal2 = horizontal3;
                                    modifier2 = modifier3;
                                    j5 = j7;
                                    j6 = j8;
                                    paddingValues2 = paddingValues3;
                                    windowInsets2 = windowInsets4;
                                    bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior3;
                                } else {
                                    bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior;
                                    windowInsets4 = windowInsets3;
                                }
                            }
                            j7 = j3;
                            j8 = j4;
                            PaddingValues paddingValues32 = obj;
                            Arrangement.Horizontal horizontal32 = obj2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i122 = i3 << 6;
                            int i132 = i3 << 3;
                            composer2 = startRestartGroup;
                            Modifier modifier32 = companion;
                            m1721BottomAppBarLayoutt5fmz9U(((Float.floatToRawIntBits(m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3) & Integer.MAX_VALUE) < 2139095040 || Float.isNaN(m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3) || Dp.m7554compareTo0680j_4(m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3, Dp.m7555constructorimpl(0.0f)) <= 0) ? BottomAppBarDefaults.INSTANCE.m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3() : m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3, horizontal32, modifier32, j7, j8, AppBarTokens.INSTANCE.m3120getContainerElevationD9Ej5fM(), paddingValues32, windowInsets4, bottomAppBarScrollBehavior3, function3, composer2, ((i3 >> 9) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (i122 & 896) | (i122 & 7168) | (i122 & 57344) | (3670016 & (i3 << 9)) | (29360128 & i132) | (234881024 & i132) | (i132 & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f2 = m1745getFlexibleBottomAppBarHeightD9Ej5fM$material3;
                            horizontal2 = horizontal32;
                            modifier2 = modifier32;
                            j5 = j7;
                            j6 = j8;
                            paddingValues2 = paddingValues32;
                            windowInsets2 = windowInsets4;
                            bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            windowInsets2 = windowInsets;
                            modifier2 = companion;
                            j5 = j3;
                            j6 = j4;
                            paddingValues2 = obj;
                            horizontal2 = obj2;
                            f2 = f;
                            bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj3, Object obj4) {
                                    return AppBarKt.FlexibleBottomAppBar_wBhsO_E$lambda$16(Modifier.this, j5, j6, paddingValues2, horizontal2, f2, windowInsets2, bottomAppBarScrollBehavior2, function3, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i6;
                if ((i2 & 256) == 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj2 = horizontal;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i6 = i2 & 128;
            if (i6 != 0) {
            }
            i7 = i6;
            if ((i2 & 256) == 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = paddingValues;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        obj2 = horizontal;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i6 = i2 & 128;
        if (i6 != 0) {
        }
        i7 = i6;
        if ((i2 & 256) == 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x01a3, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0117  */
    /* renamed from: BottomAppBarLayout-t5fmz9U  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1721BottomAppBarLayoutt5fmz9U(final float f, final Arrangement.Horizontal horizontal, Modifier modifier, final long j, final long j2, final float f2, final PaddingValues paddingValues, final WindowInsets windowInsets, final BottomAppBarScrollBehavior bottomAppBarScrollBehavior, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        final Arrangement.Horizontal horizontal2;
        long j3;
        long j4;
        float f3;
        Object obj;
        Composer composer2;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i4;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        Composer startRestartGroup = composer.startRestartGroup(-141162176);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBarLayout)N(containerHeight:c#ui.unit.Dp,horizontalArrangement,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,contentPadding,windowInsets,scrollBehavior,content)1331@67632L33,1363@69116L5,1366@69187L620,1379@69857L350,1358@68849L1358:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            horizontal2 = horizontal;
        } else {
            horizontal2 = horizontal;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changed(horizontal2) ? 32 : 16;
            }
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
                j3 = j;
            } else {
                j3 = j;
                if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(j3) ? 2048 : 1024;
                }
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
                j4 = j2;
            } else {
                j4 = j2;
                if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changed(j4) ? 16384 : 8192;
                }
            }
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                f3 = f2;
            } else {
                f3 = f2;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changed(f3) ? 131072 : 65536;
                }
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changed(paddingValues) ? 1048576 : 524288;
                if ((i2 & 128) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    obj = windowInsets;
                    i3 |= startRestartGroup.changed(obj) ? 8388608 : 4194304;
                    if ((i2 & 256) == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changed(bottomAppBarScrollBehavior) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if (startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                            } else {
                                Modifier.Companion companion3 = i5 != 0 ? Modifier.Companion : modifier;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-141162176, i3, -1, "androidx.compose.material3.BottomAppBarLayout (AppBar.kt:1330)");
                                }
                                final BottomAppBarScrollBehavior bottomAppBarScrollBehavior2 = !BottomAppBarLayout_t5fmz9U$lambda$17(rememberTouchExplorationService(startRestartGroup, 0)) ? bottomAppBarScrollBehavior : null;
                                if (bottomAppBarScrollBehavior2 != null && !bottomAppBarScrollBehavior2.isPinned()) {
                                    startRestartGroup.startReplaceGroup(-588583503);
                                    ComposerKt.sourceInformation(startRestartGroup, "1339@68112L105,1339@68089L128,1342@68251L308");
                                    Modifier.Companion companion4 = Modifier.Companion;
                                    Orientation orientation = Orientation.Vertical;
                                    i4 = i3;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1782133129, "CC(remember):AppBar.kt#9igjgp");
                                    boolean changed = startRestartGroup.changed(bottomAppBarScrollBehavior2);
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (changed) {
                                        companion2 = companion4;
                                    } else {
                                        companion2 = companion4;
                                    }
                                    rememberedValue = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj2) {
                                            return AppBarKt.BottomAppBarLayout_t5fmz9U$lambda$19$lambda$18(BottomAppBarScrollBehavior.this, ((Float) obj2).floatValue());
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue, startRestartGroup, 0);
                                    Modifier.Companion companion5 = companion2;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1782137780, "CC(remember):AppBar.kt#9igjgp");
                                    boolean changed2 = startRestartGroup.changed(bottomAppBarScrollBehavior2);
                                    AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                        rememberedValue2 = new AppBarKt$BottomAppBarLayout$appBarDragModifier$2$1(bottomAppBarScrollBehavior2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    companion = DraggableKt.draggable$default(companion5, rememberDraggableState, orientation, false, null, false, null, (Function3) rememberedValue2, false, TsExtractor.TS_PACKET_SIZE, null);
                                    startRestartGroup.endReplaceGroup();
                                } else {
                                    i4 = i3;
                                    startRestartGroup.startReplaceGroup(-587975934);
                                    startRestartGroup.endReplaceGroup();
                                    companion = Modifier.Companion;
                                }
                                Shape value = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1782168044, "CC(remember):AppBar.kt#9igjgp");
                                boolean changed3 = startRestartGroup.changed(bottomAppBarScrollBehavior2);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                    rememberedValue3 = new Function3() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function3
                                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                            return AppBarKt.BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22(BottomAppBarScrollBehavior.this, (MeasureScope) obj2, (Measurable) obj3, (Constraints) obj4);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Modifier modifier3 = companion3;
                                final WindowInsets windowInsets2 = obj;
                                int i6 = i4 >> 3;
                                composer2 = startRestartGroup;
                                long j5 = j3;
                                SurfaceKt.m2569SurfaceT9BRK9s(LayoutModifierKt.layout(companion3, (Function3) rememberedValue3).then(companion), value, j5, j4, f3, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1054101083, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBarLayout$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i7) {
                                        ComposerKt.sourceInformation(composer3, "C1380@69867L334:AppBar.kt#uh7d8r");
                                        if (!composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                                            composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1054101083, i7, -1, "androidx.compose.material3.BottomAppBarLayout.<anonymous> (AppBar.kt:1380)");
                                        }
                                        Modifier padding = PaddingKt.padding(SizeKt.m850height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), WindowInsets.this), f), paddingValues);
                                        Arrangement.Horizontal horizontal3 = horizontal2;
                                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal3, centerVertically, composer3, 48);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, padding);
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
                                        function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), composer2, (i6 & 896) | 12582912 | (i6 & 7168) | (i6 & 57344), 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return AppBarKt.BottomAppBarLayout_t5fmz9U$lambda$24(f, horizontal, modifier2, j, j2, f2, paddingValues, windowInsets, bottomAppBarScrollBehavior, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i2 & 512) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj = windowInsets;
                if ((i2 & 256) == 0) {
                }
                if ((i2 & 512) != 0) {
                }
                if (startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i2 & 128) != 0) {
            }
            obj = windowInsets;
            if ((i2 & 256) == 0) {
            }
            if ((i2 & 512) != 0) {
            }
            if (startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i2 & 128) != 0) {
        }
        obj = windowInsets;
        if ((i2 & 256) == 0) {
        }
        if ((i2 & 512) != 0) {
        }
        if (startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BottomAppBarLayout_t5fmz9U$lambda$19$lambda$18(BottomAppBarScrollBehavior bottomAppBarScrollBehavior, float f) {
        BottomAppBarState state = bottomAppBarScrollBehavior.getState();
        state.setHeightOffset(state.getHeightOffset() - f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final MeasureResult BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22(BottomAppBarScrollBehavior bottomAppBarScrollBehavior, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        BottomAppBarState state;
        BottomAppBarState state2;
        final Placeable mo6216measureBRTryo0 = measurable.mo6216measureBRTryo0(constraints.m7514unboximpl());
        if (bottomAppBarScrollBehavior != null && (state2 = bottomAppBarScrollBehavior.getState()) != null) {
            state2.setHeightOffsetLimit(-mo6216measureBRTryo0.getHeight());
        }
        return MeasureScope.layout$default(measureScope, mo6216measureBRTryo0.getWidth(), MathKt.roundToInt(RangesKt.coerceAtLeast(mo6216measureBRTryo0.getHeight() + ((bottomAppBarScrollBehavior == null || (state = bottomAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getHeightOffset()), 0.0f)), null, new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppBarKt.BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22$lambda$21(Placeable.this, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BottomAppBarLayout_t5fmz9U$lambda$23$lambda$22$lambda$21(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final TopAppBarState rememberTopAppBarState(final float f, final float f2, final float f3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1801969826, "C(rememberTopAppBarState)N(initialHeightOffsetLimit,initialHeightOffset,initialContentOffset)1858@91732L99,1858@91685L146:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801969826, i, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1857)");
        }
        Object[] objArr = new Object[0];
        Saver<TopAppBarState, ?> saver = TopAppBarState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, 821190565, "CC(remember):AppBar.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(f)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f2)) || (i & 48) == 32);
        if ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changed(f3)) && (i & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBarKt.rememberTopAppBarState$lambda$26$lambda$25(f, f2, f3);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.m4213rememberSaveable(objArr, saver, (Function0<? extends Object>) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return topAppBarState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final TopAppBarState rememberTopAppBarState$lambda$26$lambda$25(float f, float f2, float f3) {
        return new TopAppBarState(f, f2, f3);
    }

    public static final BottomAppBarState rememberBottomAppBarState(final float f, final float f2, final float f3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1420874240, "C(rememberBottomAppBarState)N(initialHeightOffsetLimit,initialHeightOffset,initialContentOffset)2235@107287L102,2235@107237L152:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1420874240, i, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:2234)");
        }
        Object[] objArr = new Object[0];
        Saver<BottomAppBarState, ?> saver = BottomAppBarState.Companion.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, -339446298, "CC(remember):AppBar.kt#9igjgp");
        boolean z = true;
        boolean z2 = ((((i & 14) ^ 6) > 4 && composer.changed(f)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f2)) || (i & 48) == 32);
        if ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256 || !composer.changed(f3)) && (i & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    BottomAppBarState BottomAppBarState;
                    BottomAppBarState = AppBarKt.BottomAppBarState(f, f2, f3);
                    return BottomAppBarState;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        BottomAppBarState bottomAppBarState = (BottomAppBarState) RememberSaveableKt.m4213rememberSaveable(objArr, saver, (Function0<? extends Object>) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return bottomAppBarState;
    }

    public static final BottomAppBarState BottomAppBarState(float f, float f2, float f3) {
        return new BottomAppBarStateImpl(f, f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ad, code lost:
        if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r5, r23, false, r6, r7, 2, null) == r2) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object settleAppBarBottom(BottomAppBarState bottomAppBarState, float f, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        AppBarKt$settleAppBarBottom$1 appBarKt$settleAppBarBottom$1;
        AppBarKt$settleAppBarBottom$1 appBarKt$settleAppBarBottom$12;
        Object coroutine_suspended;
        int i;
        final Ref.FloatRef floatRef;
        AnimationSpec<Float> animationSpec2;
        AnimationSpec<Float> animationSpec3;
        AnimationState AnimationState$default;
        Float boxFloat;
        Function1 function1;
        Ref.FloatRef floatRef2;
        final BottomAppBarState bottomAppBarState2 = bottomAppBarState;
        if (continuation instanceof AppBarKt$settleAppBarBottom$1) {
            appBarKt$settleAppBarBottom$1 = (AppBarKt$settleAppBarBottom$1) continuation;
            if ((appBarKt$settleAppBarBottom$1.label & Integer.MIN_VALUE) != 0) {
                appBarKt$settleAppBarBottom$1.label -= Integer.MIN_VALUE;
                appBarKt$settleAppBarBottom$12 = appBarKt$settleAppBarBottom$1;
                Object obj = appBarKt$settleAppBarBottom$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appBarKt$settleAppBarBottom$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (bottomAppBarState2.getCollapsedFraction() < 0.01f || bottomAppBarState2.getCollapsedFraction() == 1.0f) {
                        return Velocity.m7784boximpl(Velocity.Companion.m7804getZero9UxMQ8M());
                    }
                    floatRef = new Ref.FloatRef();
                    floatRef.element = f;
                    if (decayAnimationSpec == null || Math.abs(f) <= 1.0f) {
                        animationSpec2 = animationSpec;
                    } else {
                        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                        AnimationState AnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
                        Function1 function12 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda23
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return AppBarKt.settleAppBarBottom$lambda$29(Ref.FloatRef.this, bottomAppBarState2, floatRef, (AnimationScope) obj2);
                            }
                        };
                        appBarKt$settleAppBarBottom$12.L$0 = bottomAppBarState2;
                        animationSpec2 = animationSpec;
                        appBarKt$settleAppBarBottom$12.L$1 = animationSpec2;
                        appBarKt$settleAppBarBottom$12.L$2 = floatRef;
                        appBarKt$settleAppBarBottom$12.label = 1;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        floatRef2 = (Ref.FloatRef) appBarKt$settleAppBarBottom$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        floatRef = floatRef2;
                        return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                    floatRef = (Ref.FloatRef) appBarKt$settleAppBarBottom$12.L$2;
                    animationSpec2 = (AnimationSpec) appBarKt$settleAppBarBottom$12.L$1;
                    bottomAppBarState2 = (BottomAppBarState) appBarKt$settleAppBarBottom$12.L$0;
                }
                animationSpec3 = animationSpec2;
                if (animationSpec3 != null && bottomAppBarState2.getHeightOffset() < 0.0f && bottomAppBarState2.getHeightOffset() > bottomAppBarState2.getHeightOffsetLimit()) {
                    AnimationState$default = AnimationStateKt.AnimationState$default(bottomAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                    boxFloat = Boxing.boxFloat(bottomAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : bottomAppBarState2.getHeightOffsetLimit());
                    function1 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return AppBarKt.settleAppBarBottom$lambda$30(BottomAppBarState.this, (AnimationScope) obj2);
                        }
                    };
                    appBarKt$settleAppBarBottom$12.L$0 = floatRef;
                    appBarKt$settleAppBarBottom$12.L$1 = null;
                    appBarKt$settleAppBarBottom$12.L$2 = null;
                    appBarKt$settleAppBarBottom$12.label = 2;
                    if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBarBottom$12, 4, null) != coroutine_suspended) {
                        floatRef2 = floatRef;
                        floatRef = floatRef2;
                    }
                    return coroutine_suspended;
                }
                return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
            }
        }
        appBarKt$settleAppBarBottom$1 = new AppBarKt$settleAppBarBottom$1(continuation);
        appBarKt$settleAppBarBottom$12 = appBarKt$settleAppBarBottom$1;
        Object obj2 = appBarKt$settleAppBarBottom$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appBarKt$settleAppBarBottom$12.label;
        if (i != 0) {
        }
        animationSpec3 = animationSpec2;
        if (animationSpec3 != null) {
            AnimationState$default = AnimationStateKt.AnimationState$default(bottomAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
            boxFloat = Boxing.boxFloat(bottomAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : bottomAppBarState2.getHeightOffsetLimit());
            function1 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj22) {
                    return AppBarKt.settleAppBarBottom$lambda$30(BottomAppBarState.this, (AnimationScope) obj22);
                }
            };
            appBarKt$settleAppBarBottom$12.L$0 = floatRef;
            appBarKt$settleAppBarBottom$12.L$1 = null;
            appBarKt$settleAppBarBottom$12.L$2 = null;
            appBarKt$settleAppBarBottom$12.label = 2;
            if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBarBottom$12, 4, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settleAppBarBottom$lambda$29(Ref.FloatRef floatRef, BottomAppBarState bottomAppBarState, Ref.FloatRef floatRef2, AnimationScope animationScope) {
        float floatValue = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
        float heightOffset = bottomAppBarState.getHeightOffset();
        bottomAppBarState.setHeightOffset(heightOffset + floatValue);
        float abs = Math.abs(heightOffset - bottomAppBarState.getHeightOffset());
        floatRef.element = ((Number) animationScope.getValue()).floatValue();
        floatRef2.element = ((Number) animationScope.getVelocity()).floatValue();
        if (Math.abs(floatValue - abs) > 0.5f) {
            animationScope.cancelAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settleAppBarBottom$lambda$30(BottomAppBarState bottomAppBarState, AnimationScope animationScope) {
        bottomAppBarState.setHeightOffset(((Number) animationScope.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0105  */
    /* renamed from: SingleRowTopAppBar-wn8IZOc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1728SingleRowTopAppBarwn8IZOc(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final TextStyle textStyle2, final Alignment.Horizontal horizontal, final Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final float f, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2, final int i3) {
        Object obj;
        int i4;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        float f2;
        Object obj7;
        int i5;
        int i6;
        Modifier.Companion companion;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-2033800111);
        ComposerKt.sourceInformation(startRestartGroup, "C(SingleRowTopAppBar)N(modifier,title,titleTextStyle,subtitle,subtitleTextStyle,titleHorizontalAlignment,navigationIcon,actions,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)2500@117679L7,*2500@117696L20:AppBar.kt#uh7d8r");
        int i7 = i3 & 1;
        if (i7 != 0) {
            i4 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i4 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            obj2 = function2;
            i4 |= startRestartGroup.changedInstance(obj2) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                obj3 = textStyle;
                i4 |= startRestartGroup.changed(obj3) ? 256 : 128;
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    obj4 = function22;
                    i4 |= startRestartGroup.changedInstance(obj4) ? 2048 : 1024;
                    if ((i3 & 16) == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        obj5 = textStyle2;
                        i4 |= startRestartGroup.changed(obj5) ? 16384 : 8192;
                        if ((i3 & 32) != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            obj6 = horizontal;
                            i4 |= startRestartGroup.changed(obj6) ? 131072 : 65536;
                            if ((i3 & 64) == 0) {
                                i4 |= 1572864;
                            } else if ((i & 1572864) == 0) {
                                i4 |= startRestartGroup.changedInstance(function23) ? 1048576 : 524288;
                            }
                            if ((i3 & 128) == 0) {
                                i4 |= 12582912;
                            } else if ((i & 12582912) == 0) {
                                i4 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                                if ((i3 & 256) != 0) {
                                    i4 |= 100663296;
                                } else if ((i & 100663296) == 0) {
                                    f2 = f;
                                    i4 |= startRestartGroup.changed(f2) ? 67108864 : 33554432;
                                    if ((i3 & 512) == 0) {
                                        i4 |= 805306368;
                                    } else if ((i & 805306368) == 0) {
                                        obj7 = windowInsets;
                                        i4 |= startRestartGroup.changed(obj7) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                        if ((i3 & 1024) != 0) {
                                            i5 = i2 | 6;
                                        } else if ((i2 & 6) == 0) {
                                            i5 = i2 | (startRestartGroup.changed(topAppBarColors) ? 4 : 2);
                                        } else {
                                            i5 = i2;
                                        }
                                        if ((i3 & 2048) != 0) {
                                            i5 |= 48;
                                        } else if ((i2 & 48) == 0) {
                                            i5 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 32 : 16;
                                        }
                                        i6 = i5;
                                        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
                                            startRestartGroup.skipToGroupEnd();
                                            companion = obj;
                                        } else {
                                            companion = i7 != 0 ? Modifier.Companion : obj;
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2033800111, i4, i6, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:2484)");
                                            }
                                            SingleRowTopAppBarOverrideScope singleRowTopAppBarOverrideScope = new SingleRowTopAppBarOverrideScope(companion, obj2, obj3, obj4, obj5, obj6, function23, function3, f2, obj7, topAppBarColors, topAppBarScrollBehavior, null);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(LocalSingleRowTopAppBarOverride);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            ((SingleRowTopAppBarOverride) consume).SingleRowTopAppBar(singleRowTopAppBarOverrideScope, startRestartGroup, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup != null) {
                                            final Modifier modifier2 = companion;
                                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda13
                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(Object obj8, Object obj9) {
                                                    return AppBarKt.SingleRowTopAppBar_wn8IZOc$lambda$32(Modifier.this, function2, textStyle, function22, textStyle2, horizontal, function23, function3, f, windowInsets, topAppBarColors, topAppBarScrollBehavior, i, i2, i3, (Composer) obj8, ((Integer) obj9).intValue());
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                    obj7 = windowInsets;
                                    if ((i3 & 1024) != 0) {
                                    }
                                    if ((i3 & 2048) != 0) {
                                    }
                                    i6 = i5;
                                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
                                    }
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                    }
                                }
                                f2 = f;
                                if ((i3 & 512) == 0) {
                                }
                                obj7 = windowInsets;
                                if ((i3 & 1024) != 0) {
                                }
                                if ((i3 & 2048) != 0) {
                                }
                                i6 = i5;
                                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                            if ((i3 & 256) != 0) {
                            }
                            f2 = f;
                            if ((i3 & 512) == 0) {
                            }
                            obj7 = windowInsets;
                            if ((i3 & 1024) != 0) {
                            }
                            if ((i3 & 2048) != 0) {
                            }
                            i6 = i5;
                            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        obj6 = horizontal;
                        if ((i3 & 64) == 0) {
                        }
                        if ((i3 & 128) == 0) {
                        }
                        if ((i3 & 256) != 0) {
                        }
                        f2 = f;
                        if ((i3 & 512) == 0) {
                        }
                        obj7 = windowInsets;
                        if ((i3 & 1024) != 0) {
                        }
                        if ((i3 & 2048) != 0) {
                        }
                        i6 = i5;
                        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    obj5 = textStyle2;
                    if ((i3 & 32) != 0) {
                    }
                    obj6 = horizontal;
                    if ((i3 & 64) == 0) {
                    }
                    if ((i3 & 128) == 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    f2 = f;
                    if ((i3 & 512) == 0) {
                    }
                    obj7 = windowInsets;
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    i6 = i5;
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj4 = function22;
                if ((i3 & 16) == 0) {
                }
                obj5 = textStyle2;
                if ((i3 & 32) != 0) {
                }
                obj6 = horizontal;
                if ((i3 & 64) == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) != 0) {
                }
                f2 = f;
                if ((i3 & 512) == 0) {
                }
                obj7 = windowInsets;
                if ((i3 & 1024) != 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                i6 = i5;
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            obj3 = textStyle;
            if ((i3 & 8) != 0) {
            }
            obj4 = function22;
            if ((i3 & 16) == 0) {
            }
            obj5 = textStyle2;
            if ((i3 & 32) != 0) {
            }
            obj6 = horizontal;
            if ((i3 & 64) == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) != 0) {
            }
            f2 = f;
            if ((i3 & 512) == 0) {
            }
            obj7 = windowInsets;
            if ((i3 & 1024) != 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            i6 = i5;
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = function2;
        if ((i3 & 4) == 0) {
        }
        obj3 = textStyle;
        if ((i3 & 8) != 0) {
        }
        obj4 = function22;
        if ((i3 & 16) == 0) {
        }
        obj5 = textStyle2;
        if ((i3 & 32) != 0) {
        }
        obj6 = horizontal;
        if ((i3 & 64) == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) != 0) {
        }
        f2 = f;
        if ((i3 & 512) == 0) {
        }
        obj7 = windowInsets;
        if ((i3 & 1024) != 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        i6 = i5;
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i6 & 19) != 18, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final ProvidableCompositionLocal<SingleRowTopAppBarOverride> getLocalSingleRowTopAppBarOverride() {
        return LocalSingleRowTopAppBarOverride;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0113  */
    /* renamed from: TwoRowsTopAppBar-pJA5dT0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1733TwoRowsTopAppBarpJA5dT0(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, final TextStyle textStyle2, final Function2<? super Composer, ? super Integer, Unit> function23, final TextStyle textStyle3, final Function2<? super Composer, ? super Integer, Unit> function24, final TextStyle textStyle4, final Alignment.Horizontal horizontal, final Function2<? super Composer, ? super Integer, Unit> function25, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final float f2, final float f3, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2, final int i3) {
        Object obj;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Object obj2;
        float f4;
        Object obj3;
        Object obj4;
        Object obj5;
        int i5;
        float f5;
        int i6;
        int i7;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1092180406);
        ComposerKt.sourceInformation(startRestartGroup, "C(TwoRowsTopAppBar)N(modifier,title,titleTextStyle,titleBottomPadding:c#ui.unit.Dp,smallTitle,smallTitleTextStyle,subtitle,subtitleTextStyle,smallSubtitle,smallSubtitleTextStyle,titleHorizontalAlignment,navigationIcon,actions,collapsedHeight:c#ui.unit.Dp,expandedHeight:c#ui.unit.Dp,windowInsets,colors,scrollBehavior)2722@127583L7,*2722@127600L18:AppBar.kt#uh7d8r");
        int i8 = i3 & 1;
        if (i8 != 0) {
            i4 = i | 6;
            obj = modifier;
        } else if ((i & 6) == 0) {
            obj = modifier;
            i4 = (startRestartGroup.changed(obj) ? 4 : 2) | i;
        } else {
            obj = modifier;
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function26 = function2;
        } else {
            function26 = function2;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = textStyle;
            i4 |= startRestartGroup.changed(obj2) ? 256 : 128;
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                f4 = f;
                i4 |= startRestartGroup.changed(f4) ? 2048 : 1024;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    if ((i3 & 32) == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj4 = textStyle2;
                    } else {
                        obj4 = textStyle2;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changed(obj4) ? 131072 : 65536;
                        }
                    }
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                        obj5 = function23;
                    } else {
                        obj5 = function23;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj5) ? 1048576 : 524288;
                        }
                    }
                    if ((i3 & 128) == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changed(textStyle3) ? 8388608 : 4194304;
                        if ((i3 & 256) != 0) {
                            i4 |= 100663296;
                        } else if ((100663296 & i) == 0) {
                            i4 |= startRestartGroup.changedInstance(function24) ? 67108864 : 33554432;
                            if ((i3 & 512) == 0) {
                                i4 |= 805306368;
                            } else if ((805306368 & i) == 0) {
                                i4 |= startRestartGroup.changed(textStyle4) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                                if ((i3 & 1024) != 0) {
                                    i5 = i2 | 6;
                                } else if ((i2 & 6) == 0) {
                                    i5 = i2 | (startRestartGroup.changed(horizontal) ? 4 : 2);
                                } else {
                                    i5 = i2;
                                }
                                if ((i3 & 2048) != 0) {
                                    i5 |= 48;
                                } else if ((i2 & 48) == 0) {
                                    i5 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
                                }
                                int i9 = i5;
                                if ((i3 & 4096) != 0) {
                                    i9 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                                } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                                    i9 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
                                    if ((i3 & 8192) == 0) {
                                        i9 |= 3072;
                                    } else if ((i2 & 3072) == 0) {
                                        i9 |= startRestartGroup.changed(f2) ? 2048 : 1024;
                                        if ((i3 & 16384) != 0) {
                                            i9 |= 24576;
                                        } else if ((i2 & 24576) == 0) {
                                            f5 = f3;
                                            i9 |= startRestartGroup.changed(f5) ? 16384 : 8192;
                                            if ((i3 & 32768) == 0) {
                                                i6 = i9 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                            } else {
                                                int i10 = i9;
                                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                                    i6 = i10 | (startRestartGroup.changed(windowInsets) ? 131072 : 65536);
                                                } else {
                                                    i6 = i10;
                                                }
                                            }
                                            if ((i3 & 65536) == 0) {
                                                i6 |= 1572864;
                                            } else if ((i2 & 1572864) == 0) {
                                                i6 |= startRestartGroup.changed(topAppBarColors) ? 1048576 : 524288;
                                            }
                                            if ((i3 & 131072) == 0) {
                                                i6 |= 12582912;
                                            } else if ((i2 & 12582912) == 0) {
                                                i6 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 8388608 : 4194304;
                                            }
                                            i7 = i6;
                                            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
                                                startRestartGroup.skipToGroupEnd();
                                                modifier2 = obj;
                                            } else {
                                                Modifier.Companion companion = i8 != 0 ? Modifier.Companion : obj;
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1092180406, i4, i7, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:2700)");
                                                }
                                                TwoRowsTopAppBarOverrideScope twoRowsTopAppBarOverrideScope = new TwoRowsTopAppBarOverrideScope(companion, function26, obj2, f4, obj3, obj4, obj5, textStyle3, function24, textStyle4, horizontal, function25, function3, f2, f5, windowInsets, topAppBarColors, topAppBarScrollBehavior, null);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(LocalTwoRowsTopAppBarOverride);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                ((TwoRowsTopAppBarOverride) consume).TwoRowsTopAppBar(twoRowsTopAppBarOverrideScope, startRestartGroup, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                modifier2 = companion;
                                            }
                                            endRestartGroup = startRestartGroup.endRestartGroup();
                                            if (endRestartGroup == null) {
                                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda29
                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(Object obj6, Object obj7) {
                                                        return AppBarKt.TwoRowsTopAppBar_pJA5dT0$lambda$35(Modifier.this, function2, textStyle, f, function22, textStyle2, function23, textStyle3, function24, textStyle4, horizontal, function25, function3, f2, f3, windowInsets, topAppBarColors, topAppBarScrollBehavior, i, i2, i3, (Composer) obj6, ((Integer) obj7).intValue());
                                                    }
                                                });
                                                return;
                                            }
                                            return;
                                        }
                                        f5 = f3;
                                        if ((i3 & 32768) == 0) {
                                        }
                                        if ((i3 & 65536) == 0) {
                                        }
                                        if ((i3 & 131072) == 0) {
                                        }
                                        i7 = i6;
                                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
                                        }
                                        endRestartGroup = startRestartGroup.endRestartGroup();
                                        if (endRestartGroup == null) {
                                        }
                                    }
                                    if ((i3 & 16384) != 0) {
                                    }
                                    f5 = f3;
                                    if ((i3 & 32768) == 0) {
                                    }
                                    if ((i3 & 65536) == 0) {
                                    }
                                    if ((i3 & 131072) == 0) {
                                    }
                                    i7 = i6;
                                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
                                    }
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup == null) {
                                    }
                                }
                                if ((i3 & 8192) == 0) {
                                }
                                if ((i3 & 16384) != 0) {
                                }
                                f5 = f3;
                                if ((i3 & 32768) == 0) {
                                }
                                if ((i3 & 65536) == 0) {
                                }
                                if ((i3 & 131072) == 0) {
                                }
                                i7 = i6;
                                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            if ((i3 & 1024) != 0) {
                            }
                            if ((i3 & 2048) != 0) {
                            }
                            int i92 = i5;
                            if ((i3 & 4096) != 0) {
                            }
                            if ((i3 & 8192) == 0) {
                            }
                            if ((i3 & 16384) != 0) {
                            }
                            f5 = f3;
                            if ((i3 & 32768) == 0) {
                            }
                            if ((i3 & 65536) == 0) {
                            }
                            if ((i3 & 131072) == 0) {
                            }
                            i7 = i6;
                            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        if ((i3 & 512) == 0) {
                        }
                        if ((i3 & 1024) != 0) {
                        }
                        if ((i3 & 2048) != 0) {
                        }
                        int i922 = i5;
                        if ((i3 & 4096) != 0) {
                        }
                        if ((i3 & 8192) == 0) {
                        }
                        if ((i3 & 16384) != 0) {
                        }
                        f5 = f3;
                        if ((i3 & 32768) == 0) {
                        }
                        if ((i3 & 65536) == 0) {
                        }
                        if ((i3 & 131072) == 0) {
                        }
                        i7 = i6;
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if ((i3 & 512) == 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    int i9222 = i5;
                    if ((i3 & 4096) != 0) {
                    }
                    if ((i3 & 8192) == 0) {
                    }
                    if ((i3 & 16384) != 0) {
                    }
                    f5 = f3;
                    if ((i3 & 32768) == 0) {
                    }
                    if ((i3 & 65536) == 0) {
                    }
                    if ((i3 & 131072) == 0) {
                    }
                    i7 = i6;
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = function22;
                if ((i3 & 32) == 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if ((i3 & 512) == 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                int i92222 = i5;
                if ((i3 & 4096) != 0) {
                }
                if ((i3 & 8192) == 0) {
                }
                if ((i3 & 16384) != 0) {
                }
                f5 = f3;
                if ((i3 & 32768) == 0) {
                }
                if ((i3 & 65536) == 0) {
                }
                if ((i3 & 131072) == 0) {
                }
                i7 = i6;
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f4 = f;
            if ((i3 & 16) != 0) {
            }
            obj3 = function22;
            if ((i3 & 32) == 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if ((i3 & 512) == 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            int i922222 = i5;
            if ((i3 & 4096) != 0) {
            }
            if ((i3 & 8192) == 0) {
            }
            if ((i3 & 16384) != 0) {
            }
            f5 = f3;
            if ((i3 & 32768) == 0) {
            }
            if ((i3 & 65536) == 0) {
            }
            if ((i3 & 131072) == 0) {
            }
            i7 = i6;
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = textStyle;
        if ((i3 & 8) == 0) {
        }
        f4 = f;
        if ((i3 & 16) != 0) {
        }
        obj3 = function22;
        if ((i3 & 32) == 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if ((i3 & 512) == 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        int i9222222 = i5;
        if ((i3 & 4096) != 0) {
        }
        if ((i3 & 8192) == 0) {
        }
        if ((i3 & 16384) != 0) {
        }
        f5 = f3;
        if ((i3 & 32768) == 0) {
        }
        if ((i3 & 65536) == 0) {
        }
        if ((i3 & 131072) == 0) {
        }
        i7 = i6;
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (4793491 & i7) != 4793490, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final ProvidableCompositionLocal<TwoRowsTopAppBarOverride> getLocalTwoRowsTopAppBarOverride() {
        return LocalTwoRowsTopAppBarOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier adjustHeightOffsetLimit(Modifier modifier, TopAppBarScrollBehavior topAppBarScrollBehavior) {
        final TopAppBarState state;
        Modifier onSizeChanged;
        return (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null || (onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifier, new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppBarKt.adjustHeightOffsetLimit$lambda$38$lambda$37(TopAppBarState.this, (IntSize) obj);
            }
        })) == null) ? modifier : onSizeChanged;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit adjustHeightOffsetLimit$lambda$38$lambda$37(TopAppBarState topAppBarState, IntSize intSize) {
        topAppBarState.setHeightOffsetLimit(-(((int) (intSize.m7730unboximpl() & 4294967295L)) - topAppBarState.getHeightOffset()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TopAppBarLayout-lyUyIHI  reason: not valid java name */
    public static final void m1731TopAppBarLayoutlyUyIHI(final Modifier modifier, final FloatProducer floatProducer, final long j, final long j2, final long j3, final long j4, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final TextStyle textStyle2, final Function0<Float> function0, final Arrangement.Vertical vertical, Alignment.Horizontal horizontal, final int i, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final float f, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        Alignment.Horizontal horizontal2;
        Composer composer2;
        int i7;
        String str;
        int i8;
        int i9;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function25;
        String str2;
        String str3;
        Modifier.Companion companion;
        boolean z2;
        String str4;
        String str5;
        Modifier.Companion companion2;
        Composer startRestartGroup = composer.startRestartGroup(126395868);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBarLayout)N(modifier,scrolledOffset,navigationIconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,subtitleContentColor:c#ui.graphics.Color,actionIconContentColor:c#ui.graphics.Color,title,titleTextStyle,subtitle,subtitleTextStyle,titleAlpha,titleVerticalArrangement,titleHorizontalAlignment,titleBottomPadding,hideTitleSemantics,navigationIcon,actions,height:c#ui.unit.Dp)3053@144004L469,2995@141484L2996:AppBar.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= (i2 & 64) == 0 ? startRestartGroup.changed(floatProducer) : startRestartGroup.changedInstance(floatProducer) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i5 = i4 | (startRestartGroup.changed(j2) ? 2048 : 1024);
        } else {
            i5 = i4;
        }
        if ((i2 & 24576) == 0) {
            i5 |= startRestartGroup.changed(j3) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= startRestartGroup.changed(j4) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i5 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i5 |= startRestartGroup.changed(textStyle) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i5 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i5 |= startRestartGroup.changed(textStyle2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i11 = i5;
        if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changed(vertical) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= startRestartGroup.changed(horizontal) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= startRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i6 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function24) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i6 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if (!startRestartGroup.shouldExecute(((i11 & 306783379) == 306783378 && (4793491 & i6) == 4793490) ? false : true, i11 & 1)) {
            horizontal2 = horizontal;
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(126395868, i11, i6, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2994)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1207447665, "CC(remember):AppBar.kt#9igjgp");
            int i12 = i6 & 896;
            boolean z3 = ((i11 & 112) == 32 || ((i11 & 64) != 0 && startRestartGroup.changed(floatProducer))) | ((i6 & 112) == 32) | (i12 == 256) | ((i6 & 7168) == 2048) | ((29360128 & i6) == 8388608);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                i7 = i12;
                str = "CC(remember):AppBar.kt#9igjgp";
                i8 = i6;
                i9 = i11;
                i10 = 0;
                function25 = function23;
                rememberedValue = new TopAppBarMeasurePolicy(floatProducer, vertical, horizontal, i, f, null);
                horizontal2 = horizontal;
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                function25 = function23;
                str = "CC(remember):AppBar.kt#9igjgp";
                i8 = i6;
                i7 = i12;
                i9 = i11;
                i10 = 0;
                horizontal2 = horizontal;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            TopAppBarMeasurePolicy topAppBarMeasurePolicy = (TopAppBarMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i10);
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
            Composer m4041constructorimpl = Updater.m4041constructorimpl(startRestartGroup);
            Updater.m4049setimpl(m4041constructorimpl, topAppBarMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1360991215, "C2997@141514L281,3044@143662L265:AppBar.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "navigationIcon");
            float f2 = TopAppBarHorizontalPadding;
            Modifier m822paddingqDBjuR0$default = PaddingKt.m822paddingqDBjuR0$default(layoutId, f2, 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m822paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1301830080, "C2998@141617L164:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(j)), function25, startRestartGroup, ProvidedValue.$stable | ((i8 >> 12) & 112));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (function22 != null) {
                startRestartGroup.startReplaceGroup(-1360720648);
                ComposerKt.sourceInformation(startRestartGroup, "3012@142259L24,3004@141848L997");
                Modifier m820paddingVpY3zN4$default = PaddingKt.m820paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "title"), f2, 0.0f, 2, null);
                if (z) {
                    startRestartGroup.startReplaceGroup(510303260);
                    ComposerKt.sourceInformation(startRestartGroup, "3009@142137L2");
                    Modifier.Companion companion3 = Modifier.Companion;
                    str5 = str;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 510303911, str5);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit unit;
                                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    companion2 = SemanticsModifierKt.clearAndSetSemantics(companion3, (Function1) rememberedValue2);
                    startRestartGroup.endReplaceGroup();
                } else {
                    str5 = str;
                    startRestartGroup.startReplaceGroup(510305197);
                    startRestartGroup.endReplaceGroup();
                    companion2 = Modifier.Companion;
                }
                Modifier then = m820paddingVpY3zN4$default.then(companion2);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 510307837, str5);
                z2 = (i8 & 14) == 4;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AppBarKt.TopAppBarLayout_lyUyIHI$lambda$51$lambda$43$lambda$42(Function0.this, (GraphicsLayerScope) obj);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(then, (Function1) rememberedValue3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), horizontal2, startRestartGroup, (i7 >> 3) & 112);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, graphicsLayer);
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
                Updater.m4049setimpl(m4041constructorimpl3, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -190335683, "C3015@142393L202,3020@142616L211:AppBar.kt#uh7d8r");
                int i13 = i9 >> 18;
                int i14 = i9 >> 12;
                ProvideContentColorTextStyleKt.m3007ProvideContentColorTextStyle3JVO9M(j2, textStyle, function2, startRestartGroup, ((i9 >> 9) & 14) | (i13 & 112) | (i14 & 896));
                composer2 = startRestartGroup;
                str2 = "C72@3468L9:Box.kt#2w3rfo";
                str3 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                ProvideContentColorTextStyleKt.m3007ProvideContentColorTextStyle3JVO9M(j3, textStyle2, function22, composer2, (i14 & 14) | ((i9 >> 24) & 112) | (i13 & 896));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
            } else {
                str2 = "C72@3468L9:Box.kt#2w3rfo";
                composer2 = startRestartGroup;
                String str6 = str;
                str3 = "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo";
                composer2.startReplaceGroup(-1359701523);
                ComposerKt.sourceInformation(composer2, "3035@143350L24,3027@142942L693");
                Modifier m820paddingVpY3zN4$default2 = PaddingKt.m820paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "title"), f2, 0.0f, 2, null);
                if (z) {
                    composer2.startReplaceGroup(510338172);
                    ComposerKt.sourceInformation(composer2, "3032@143228L2");
                    Modifier.Companion companion4 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart(composer2, 510338823, str6);
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit unit;
                                SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    companion = SemanticsModifierKt.clearAndSetSemantics(companion4, (Function1) rememberedValue4);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(510340109);
                    composer2.endReplaceGroup();
                    companion = Modifier.Companion;
                }
                Modifier then2 = m820paddingVpY3zN4$default2.then(companion);
                ComposerKt.sourceInformationMarkerStart(composer2, 510342749, str6);
                z2 = (i8 & 14) == 4;
                Object rememberedValue5 = composer2.rememberedValue();
                if (z2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AppBarKt.TopAppBarLayout_lyUyIHI$lambda$51$lambda$48$lambda$47(Function0.this, (GraphicsLayerScope) obj);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier graphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(then2, (Function1) rememberedValue5);
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str3);
                MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                str4 = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str4);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, graphicsLayer2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                Composer m4041constructorimpl4 = Updater.m4041constructorimpl(composer2);
                Updater.m4049setimpl(m4041constructorimpl4, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4049setimpl(m4041constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4041constructorimpl4.getInserting() || !Intrinsics.areEqual(m4041constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m4041constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m4041constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m4049setimpl(m4041constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, str2);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -314975490, "C3037@143415L202:AppBar.kt#uh7d8r");
                ProvideContentColorTextStyleKt.m3007ProvideContentColorTextStyle3JVO9M(j2, textStyle, function2, composer2, ((i9 >> 9) & 14) | ((i9 >> 18) & 112) | ((i9 >> 12) & 896));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            }
            Modifier m822paddingqDBjuR0$default2 = PaddingKt.m822paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.Companion, "actionIcons"), 0.0f, 0.0f, f2, 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, str3);
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str4);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(composer2, m822paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            Composer m4041constructorimpl5 = Updater.m4041constructorimpl(composer2);
            Updater.m4049setimpl(m4041constructorimpl5, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4049setimpl(m4041constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4041constructorimpl5.getInserting() || !Intrinsics.areEqual(m4041constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m4041constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m4041constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m4049setimpl(m4041constructorimpl5, materializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, str2);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1525354718, "C3045@143760L153:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(j4)), function24, composer2, ProvidedValue.$stable | ((i8 >> 15) & 112));
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
            final Alignment.Horizontal horizontal3 = horizontal2;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarKt.TopAppBarLayout_lyUyIHI$lambda$53(Modifier.this, floatProducer, j, j2, j3, j4, function2, textStyle, function22, textStyle2, function0, vertical, horizontal3, i, z, function23, function24, f, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$43$lambda$42(Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TopAppBarLayout_lyUyIHI$lambda$51$lambda$48$lambda$47(Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ad, code lost:
        if (androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r5, r23, false, r6, r7, 2, null) == r2) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object settleAppBar(TopAppBarState topAppBarState, float f, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        AppBarKt$settleAppBar$1 appBarKt$settleAppBar$1;
        AppBarKt$settleAppBar$1 appBarKt$settleAppBar$12;
        Object coroutine_suspended;
        int i;
        final Ref.FloatRef floatRef;
        AnimationSpec<Float> animationSpec2;
        AnimationSpec<Float> animationSpec3;
        AnimationState AnimationState$default;
        Float boxFloat;
        Function1 function1;
        Ref.FloatRef floatRef2;
        final TopAppBarState topAppBarState2 = topAppBarState;
        if (continuation instanceof AppBarKt$settleAppBar$1) {
            appBarKt$settleAppBar$1 = (AppBarKt$settleAppBar$1) continuation;
            if ((appBarKt$settleAppBar$1.label & Integer.MIN_VALUE) != 0) {
                appBarKt$settleAppBar$1.label -= Integer.MIN_VALUE;
                appBarKt$settleAppBar$12 = appBarKt$settleAppBar$1;
                Object obj = appBarKt$settleAppBar$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appBarKt$settleAppBar$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (topAppBarState2.getCollapsedFraction() < 0.01f || topAppBarState2.getCollapsedFraction() == 1.0f) {
                        return Velocity.m7784boximpl(Velocity.Companion.m7804getZero9UxMQ8M());
                    }
                    floatRef = new Ref.FloatRef();
                    floatRef.element = f;
                    if (decayAnimationSpec == null || Math.abs(f) <= 1.0f) {
                        animationSpec2 = animationSpec;
                    } else {
                        final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                        AnimationState AnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
                        Function1 function12 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return AppBarKt.settleAppBar$lambda$54(Ref.FloatRef.this, topAppBarState2, floatRef, (AnimationScope) obj2);
                            }
                        };
                        appBarKt$settleAppBar$12.L$0 = topAppBarState2;
                        animationSpec2 = animationSpec;
                        appBarKt$settleAppBar$12.L$1 = animationSpec2;
                        appBarKt$settleAppBar$12.L$2 = floatRef;
                        appBarKt$settleAppBar$12.label = 1;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        floatRef2 = (Ref.FloatRef) appBarKt$settleAppBar$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        floatRef = floatRef2;
                        return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                    floatRef = (Ref.FloatRef) appBarKt$settleAppBar$12.L$2;
                    animationSpec2 = (AnimationSpec) appBarKt$settleAppBar$12.L$1;
                    topAppBarState2 = (TopAppBarState) appBarKt$settleAppBar$12.L$0;
                }
                animationSpec3 = animationSpec2;
                if (animationSpec3 != null && topAppBarState2.getHeightOffset() < 0.0f && topAppBarState2.getHeightOffset() > topAppBarState2.getHeightOffsetLimit()) {
                    AnimationState$default = AnimationStateKt.AnimationState$default(topAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                    boxFloat = Boxing.boxFloat(topAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : topAppBarState2.getHeightOffsetLimit());
                    function1 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return AppBarKt.settleAppBar$lambda$55(TopAppBarState.this, (AnimationScope) obj2);
                        }
                    };
                    appBarKt$settleAppBar$12.L$0 = floatRef;
                    appBarKt$settleAppBar$12.L$1 = null;
                    appBarKt$settleAppBar$12.L$2 = null;
                    appBarKt$settleAppBar$12.label = 2;
                    if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBar$12, 4, null) != coroutine_suspended) {
                        floatRef2 = floatRef;
                        floatRef = floatRef2;
                    }
                    return coroutine_suspended;
                }
                return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
            }
        }
        appBarKt$settleAppBar$1 = new AppBarKt$settleAppBar$1(continuation);
        appBarKt$settleAppBar$12 = appBarKt$settleAppBar$1;
        Object obj2 = appBarKt$settleAppBar$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appBarKt$settleAppBar$12.label;
        if (i != 0) {
        }
        animationSpec3 = animationSpec2;
        if (animationSpec3 != null) {
            AnimationState$default = AnimationStateKt.AnimationState$default(topAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
            boxFloat = Boxing.boxFloat(topAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : topAppBarState2.getHeightOffsetLimit());
            function1 = new Function1() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj22) {
                    return AppBarKt.settleAppBar$lambda$55(TopAppBarState.this, (AnimationScope) obj22);
                }
            };
            appBarKt$settleAppBar$12.L$0 = floatRef;
            appBarKt$settleAppBar$12.L$1 = null;
            appBarKt$settleAppBar$12.L$2 = null;
            appBarKt$settleAppBar$12.label = 2;
            if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBar$12, 4, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        return Velocity.m7784boximpl(VelocityKt.Velocity(0.0f, floatRef.element));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settleAppBar$lambda$54(Ref.FloatRef floatRef, TopAppBarState topAppBarState, Ref.FloatRef floatRef2, AnimationScope animationScope) {
        float floatValue = ((Number) animationScope.getValue()).floatValue() - floatRef.element;
        float heightOffset = topAppBarState.getHeightOffset();
        topAppBarState.setHeightOffset(heightOffset + floatValue);
        float abs = Math.abs(heightOffset - topAppBarState.getHeightOffset());
        floatRef.element = ((Number) animationScope.getValue()).floatValue();
        floatRef2.element = ((Number) animationScope.getVelocity()).floatValue();
        if (Math.abs(floatValue - abs) > 0.5f) {
            animationScope.cancelAnimation();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit settleAppBar$lambda$55(TopAppBarState topAppBarState, AnimationScope animationScope) {
        topAppBarState.setHeightOffset(((Number) animationScope.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    private static final State<Boolean> rememberTouchExplorationService(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1660719518, "C(rememberTouchExplorationService)3498@163258L171:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1660719518, i, -1, "androidx.compose.material3.rememberTouchExplorationService (AppBar.kt:3498)");
        }
        State<Boolean> rememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(true, false, false, composer, 438, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rememberAccessibilityServiceState;
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    private static final boolean BottomAppBarLayout_t5fmz9U$lambda$17(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    static {
        float m7555constructorimpl = Dp.m7555constructorimpl(Dp.m7555constructorimpl(16.0f) - Dp.m7555constructorimpl(12.0f));
        BottomAppBarHorizontalPadding = m7555constructorimpl;
        float m7555constructorimpl2 = Dp.m7555constructorimpl(Dp.m7555constructorimpl(16.0f) - Dp.m7555constructorimpl(12.0f));
        BottomAppBarVerticalPadding = m7555constructorimpl2;
        FABHorizontalPadding = Dp.m7555constructorimpl(Dp.m7555constructorimpl(16.0f) - m7555constructorimpl);
        FABVerticalPadding = Dp.m7555constructorimpl(Dp.m7555constructorimpl(12.0f) - m7555constructorimpl2);
        LocalSingleRowTopAppBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SingleRowTopAppBarOverride singleRowTopAppBarOverride;
                singleRowTopAppBarOverride = DefaultSingleRowTopAppBarOverride.INSTANCE;
                return singleRowTopAppBarOverride;
            }
        }, 1, null);
        LocalTwoRowsTopAppBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TwoRowsTopAppBarOverride twoRowsTopAppBarOverride;
                twoRowsTopAppBarOverride = DefaultTwoRowsTopAppBarOverride.INSTANCE;
                return twoRowsTopAppBarOverride;
            }
        }, 1, null);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = Dp.m7555constructorimpl(24.0f);
        LargeTitleBottomPadding = Dp.m7555constructorimpl(28.0f);
        float m7555constructorimpl3 = Dp.m7555constructorimpl(4.0f);
        TopAppBarHorizontalPadding = m7555constructorimpl3;
        TopAppBarTitleInset = Dp.m7555constructorimpl(Dp.m7555constructorimpl(16.0f) - m7555constructorimpl3);
    }
}
