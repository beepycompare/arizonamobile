package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a¦\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a¨\u0001\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a¦\u0001\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a°\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001e\u001a°\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001e\u001aÇ\u0001\u0010 \u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\"\u001a\u0091\u0001\u0010#\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001a\u008f\u0001\u0010#\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001a\u0091\u0001\u0010'\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001a\u008f\u0001\u0010'\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001a¸\u0001\u0010(\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b1\u00102\u001aÍ\u0001\u00103\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b4\u00105\u001a\u0091\u0001\u00106\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0003¢\u0006\u0004\b9\u0010:\u001a\u0091\u0001\u0010;\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0003¢\u0006\u0004\b<\u0010:\u001aN\u0010=\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,H\u0003¢\u0006\u0004\b>\u0010?\u001a9\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00108\u001a\u00020,H\u0003¢\u0006\u0004\bA\u0010B\u001a%\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001HE0D\"\u0004\b\u0000\u0010E2\b\u0010F\u001a\u0004\u0018\u0001HEH\u0003¢\u0006\u0002\u0010G\u001a&\u0010L\u001a\u0002002\b\b\u0002\u0010M\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\t2\b\b\u0002\u0010O\u001a\u00020\tH\u0002\"\u0018\u0010H\u001a\u00020\u000f*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K\"\u0010\u0010P\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Q\"\u000e\u0010R\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010W\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", ChipKt.LeadingIconLayoutId, ChipKt.TrailingIconLayoutId, "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ChipColors;", "elevation", "Landroidx/compose/material3/ChipElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedAssistChip", "FilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedFilterChip", "InputChip", "avatar", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ElevatedSuggestionChip", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "Landroidx/compose/ui/unit/Dp;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "AnimatingChipContent", "AnimatingChipContent-fe0OD_I", "leadingContent", "leadingContent-XO-JAsU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "trailingContent", "trailingContent-RPmYEkk", "(Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRetainedState", "Landroidx/compose/runtime/State;", ExifInterface.GPS_DIRECTION_TRUE, "targetValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "defaultSuggestionChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "HorizontalElementsPadding", "F", "AssistChipPadding", "FilterChipPadding", "SuggestionChipPadding", "LeadingIconLayoutId", "", "LabelLayoutId", "TrailingIconLayoutId", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    private static final float HorizontalElementsPadding;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding;
    private static final String TrailingIconLayoutId = "trailingIcon";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AnimatingChipContent_fe0OD_I$lambda$24(Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Function2 function24, long j2, long j3, float f, PaddingValues paddingValues, int i, Composer composer, int i2) {
        m1827AnimatingChipContentfe0OD_I(function2, textStyle, j, function22, function23, function24, j2, j3, f, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssistChip$lambda$0(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        AssistChip(function0, function2, modifier, z, function22, function23, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AssistChip$lambda$2(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        AssistChip(function0, function2, modifier, z, function22, function23, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ChipContent_fe0OD_I$lambda$23(Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Function2 function24, long j2, long j3, float f, PaddingValues paddingValues, int i, Composer composer, int i2) {
        m1829ChipContentfe0OD_I(function2, textStyle, j, function22, function23, function24, j2, j3, f, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Chip_nkUnTEs$lambda$18(Modifier modifier, Function0 function0, boolean z, Function2 function2, TextStyle textStyle, long j, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, float f, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m1828ChipnkUnTEs(modifier, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ElevatedAssistChip$lambda$3(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedAssistChip(function0, function2, modifier, z, function22, function23, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ElevatedAssistChip$lambda$5(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedAssistChip(function0, function2, modifier, z, function22, function23, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ElevatedFilterChip$lambda$7(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedFilterChip(z, function0, function2, modifier, z2, function22, function23, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ElevatedSuggestionChip$lambda$12(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        ElevatedSuggestionChip(function0, function2, modifier, z, function22, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ElevatedSuggestionChip$lambda$14(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        ElevatedSuggestionChip(function0, function2, modifier, z, function22, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit FilterChip$lambda$6(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        FilterChip(z, function0, function2, modifier, z2, function22, function23, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit InputChip$lambda$8(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function22, Function2 function23, Function2 function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        InputChip(z, function0, function2, modifier, z2, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelectableChip_u0RnIRE$lambda$22(boolean z, Modifier modifier, Function0 function0, boolean z2, Function2 function2, TextStyle textStyle, Function2 function22, Function2 function23, Function2 function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, float f, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m1830SelectableChipu0RnIRE(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SuggestionChip$lambda$11(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        SuggestionChip(function0, function2, modifier, z, function22, shape, chipColors, chipElevation, chipBorder, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SuggestionChip$lambda$9(Function0 function0, Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        SuggestionChip(function0, function2, modifier, z, function22, shape, chipColors, chipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AssistChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        Object obj2;
        int i5;
        boolean z2;
        int i6;
        Object obj3;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors3;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final BorderStroke borderStroke2;
        ScopeUpdateScope endRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape3;
        int i12;
        Modifier modifier3;
        int i13;
        int i14;
        ChipElevation chipElevation3;
        boolean z4;
        BorderStroke borderStroke3;
        int i15;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke4;
        int i16;
        Shape shape4;
        ChipElevation chipElevation4;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Modifier modifier4;
        int i17;
        int i18;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(1192083339);
        ComposerKt.sourceInformation(startRestartGroup, "C(AssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)151@7455L5,146@7287L542:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i20 = i3 & 4;
        if (i20 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i4 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i19 = 8388608;
                                i4 |= i19;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i19 = 4194304;
                        i4 |= i19;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changed(chipElevation)) {
                            i18 = 67108864;
                            i4 |= i18;
                        }
                        i18 = 33554432;
                        i4 |= i18;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0 && startRestartGroup.changed(borderStroke)) {
                            i17 = C.BUFFER_FLAG_LAST_SAMPLE;
                            i4 |= i17;
                        }
                        i17 = 268435456;
                        i4 |= i17;
                    }
                    i8 = i3 & 1024;
                    if (i8 == 0) {
                        i9 = i8;
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i9 = i8;
                        i10 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                    } else {
                        i9 = i8;
                        i10 = i2;
                    }
                    i11 = i4;
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "140@7003L5,141@7054L18,142@7125L21,143@7195L25");
                        int i21 = i10;
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            int i22 = (i3 & 64) != 0 ? i11 & (-3670017) : i11;
                            if ((i3 & 128) != 0) {
                                i22 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i22 &= -234881025;
                            }
                            if ((i3 & 512) != 0) {
                                i22 &= -1879048193;
                            }
                            function27 = function23;
                            shape4 = shape;
                            chipElevation4 = chipElevation;
                            borderStroke4 = borderStroke;
                            mutableInteractionSource3 = mutableInteractionSource;
                            i16 = i22;
                            i13 = 6;
                            modifier4 = obj2;
                            z4 = z2;
                            function26 = obj3;
                            i14 = i21;
                        } else {
                            Modifier.Companion companion = i20 != 0 ? Modifier.Companion : obj2;
                            boolean z5 = i5 == 0 ? z2 : true;
                            function26 = i6 != 0 ? null : obj3;
                            Function2<? super Composer, ? super Integer, Unit> function28 = i7 != 0 ? null : function23;
                            if ((i3 & 64) != 0) {
                                i12 = i11 & (-3670017);
                                shape3 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape3 = shape;
                                i12 = i11;
                            }
                            if ((i3 & 128) != 0) {
                                chipColors2 = AssistChipDefaults.INSTANCE.assistChipColors(startRestartGroup, 6);
                                i12 &= -29360129;
                            }
                            ChipColors chipColors4 = chipColors2;
                            int i23 = i12;
                            if ((i3 & 256) != 0) {
                                modifier3 = companion;
                                i14 = i21;
                                i13 = 6;
                                i23 &= -234881025;
                                chipElevation3 = AssistChipDefaults.INSTANCE.m1738assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            } else {
                                modifier3 = companion;
                                i13 = 6;
                                i14 = i21;
                                chipElevation3 = chipElevation;
                            }
                            if ((i3 & 512) != 0) {
                                z4 = z5;
                                borderStroke3 = AssistChipDefaults.INSTANCE.m1736assistChipBorderh1eTWw(z4, 0L, 0L, 0.0f, startRestartGroup, ((i23 >> 9) & 14) | 24576, 14);
                                i15 = i23 & (-1879048193);
                            } else {
                                z4 = z5;
                                borderStroke3 = borderStroke;
                                i15 = i23;
                            }
                            if (i9 != 0) {
                                borderStroke4 = borderStroke3;
                                i16 = i15;
                                shape4 = shape3;
                                chipElevation4 = chipElevation3;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                borderStroke4 = borderStroke3;
                                i16 = i15;
                                shape4 = shape3;
                                chipElevation4 = chipElevation3;
                            }
                            chipColors2 = chipColors4;
                            function27 = function28;
                            modifier4 = modifier3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1192083339, i16, i14, "androidx.compose.material3.AssistChip (Chip.kt:146)");
                        }
                        int i24 = ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896);
                        int i25 = i16 << 6;
                        int i26 = i16 >> 24;
                        boolean z6 = z4;
                        ChipColors chipColors5 = chipColors2;
                        m1828ChipnkUnTEs(modifier4, function0, z6, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i13), chipColors2.m1818labelColorvNxB06k$material3(z4), function26, function27, shape4, chipColors5, chipElevation4, borderStroke4, AssistChipDefaults.INSTANCE.m1741getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource3, startRestartGroup, i24 | (i25 & 7168) | (3670016 & i25) | (29360128 & i25) | (234881024 & i25) | (i25 & 1879048192), (i26 & 112) | (i26 & 14) | 3456 | ((i14 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = startRestartGroup;
                        modifier2 = modifier4;
                        z3 = z6;
                        function25 = function26;
                        function24 = function27;
                        shape2 = shape4;
                        chipColors3 = chipColors5;
                        chipElevation2 = chipElevation4;
                        borderStroke2 = borderStroke4;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        function24 = function23;
                        chipElevation2 = chipElevation;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z3 = z2;
                        composer2 = startRestartGroup;
                        shape2 = shape;
                        chipColors3 = chipColors2;
                        modifier2 = obj2;
                        function25 = obj3;
                        borderStroke2 = borderStroke;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                return ChipKt.AssistChip$lambda$0(Function0.this, function2, modifier2, z3, function25, function24, shape2, chipColors3, chipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj4, ((Integer) obj5).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                obj3 = function22;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i8 = i3 & 1024;
                if (i8 == 0) {
                }
                i11 = i4;
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj3 = function22;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & 1024;
            if (i8 == 0) {
            }
            i11 = i4;
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj3 = function22;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & 1024;
        if (i8 == 0) {
        }
        i11 = i4;
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "AssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void AssistChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        Object obj2;
        int i5;
        boolean z2;
        int i6;
        Object obj3;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Function2 function24;
        final Shape shape2;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        final ChipColors chipColors3;
        final Modifier modifier2;
        final Function2 function25;
        final ChipBorder chipBorder2;
        ScopeUpdateScope endRestartGroup;
        Function2 function26;
        Shape shape3;
        int i12;
        Modifier modifier3;
        int i13;
        Composer composer3;
        int i14;
        ChipElevation chipElevation3;
        ChipBorder chipBorder3;
        int i15;
        MutableInteractionSource mutableInteractionSource3;
        ChipElevation chipElevation4;
        Shape shape4;
        Function2 function27;
        Modifier modifier4;
        State<BorderStroke> borderStroke$material3;
        int i16;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(1930061919);
        ComposerKt.sourceInformation(startRestartGroup, "C(AssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)236@11549L5,231@11381L572:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i19 = i3 & 4;
        if (i19 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i4 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i18 = 8388608;
                                i4 |= i18;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i18 = 4194304;
                        i4 |= i18;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changed(chipElevation)) {
                            i17 = 67108864;
                            i4 |= i17;
                        }
                        i17 = 33554432;
                        i4 |= i17;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0 && startRestartGroup.changed(chipBorder)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            i4 |= i16;
                        }
                        i16 = 268435456;
                        i4 |= i16;
                    }
                    i8 = i3 & 1024;
                    if (i8 == 0) {
                        i9 = i8;
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i9 = i8;
                        i10 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                    } else {
                        i9 = i8;
                        i10 = i2;
                    }
                    i11 = i4;
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "225@11072L5,226@11123L18,227@11194L21,228@11262L18,229@11332L39");
                        int i20 = i10;
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            int i21 = (i3 & 64) != 0 ? i11 & (-3670017) : i11;
                            if ((i3 & 128) != 0) {
                                i21 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i21 &= -234881025;
                            }
                            if ((i3 & 512) != 0) {
                                i21 &= -1879048193;
                            }
                            function27 = function23;
                            shape4 = shape;
                            chipElevation4 = chipElevation;
                            chipBorder3 = chipBorder;
                            mutableInteractionSource3 = mutableInteractionSource;
                            i13 = 6;
                            modifier4 = obj2;
                            function26 = obj3;
                            i15 = i21;
                            i14 = i20;
                        } else {
                            Modifier.Companion companion = i19 != 0 ? Modifier.Companion : obj2;
                            boolean z4 = i5 == 0 ? z2 : true;
                            function26 = i6 != 0 ? null : obj3;
                            Function2 function28 = i7 != 0 ? null : function23;
                            if ((i3 & 64) != 0) {
                                i12 = i11 & (-3670017);
                                shape3 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape3 = shape;
                                i12 = i11;
                            }
                            if ((i3 & 128) != 0) {
                                chipColors2 = AssistChipDefaults.INSTANCE.assistChipColors(startRestartGroup, 6);
                                i12 &= -29360129;
                            }
                            ChipColors chipColors4 = chipColors2;
                            int i22 = i12;
                            if ((i3 & 256) != 0) {
                                composer3 = startRestartGroup;
                                modifier3 = companion;
                                i13 = 6;
                                i14 = i20;
                                i22 &= -234881025;
                                chipElevation3 = AssistChipDefaults.INSTANCE.m1738assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                            } else {
                                modifier3 = companion;
                                i13 = 6;
                                composer3 = startRestartGroup;
                                i14 = i20;
                                chipElevation3 = chipElevation;
                            }
                            if ((i3 & 512) != 0) {
                                startRestartGroup = composer3;
                                chipBorder3 = AssistChipDefaults.INSTANCE.m1735assistChipBorderd_3_b6Q(0L, 0L, 0.0f, startRestartGroup, 3072, 7);
                                i15 = i22 & (-1879048193);
                            } else {
                                startRestartGroup = composer3;
                                chipBorder3 = chipBorder;
                                i15 = i22;
                            }
                            if (i9 != 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -636337050, "CC(remember):Chip.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            chipElevation4 = chipElevation3;
                            shape4 = shape3;
                            z2 = z4;
                            chipColors2 = chipColors4;
                            function27 = function28;
                            modifier4 = modifier3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1930061919, i15, i14, "androidx.compose.material3.AssistChip (Chip.kt:231)");
                        }
                        TextStyle value = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i13);
                        BorderStroke borderStroke = null;
                        long m1818labelColorvNxB06k$material3 = chipColors2.m1818labelColorvNxB06k$material3(z2);
                        if (chipBorder3 == null) {
                            startRestartGroup.startReplaceGroup(1748832781);
                            startRestartGroup.endReplaceGroup();
                            borderStroke$material3 = null;
                        } else {
                            startRestartGroup.startReplaceGroup(-636322700);
                            ComposerKt.sourceInformation(startRestartGroup, "243@11781L21");
                            borderStroke$material3 = chipBorder3.borderStroke$material3(z2, startRestartGroup, ((i15 >> 9) & 14) | ((i15 >> 24) & 112));
                            startRestartGroup.endReplaceGroup();
                        }
                        if (borderStroke$material3 != null) {
                            borderStroke = borderStroke$material3.getValue();
                        }
                        int i23 = i15 << 6;
                        ChipColors chipColors5 = chipColors2;
                        composer2 = startRestartGroup;
                        boolean z5 = z2;
                        m1828ChipnkUnTEs(modifier4, function0, z5, obj, value, m1818labelColorvNxB06k$material3, function26, function27, shape4, chipColors5, chipElevation4, borderStroke, AssistChipDefaults.INSTANCE.m1741getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource3, composer2, ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896) | (i23 & 7168) | (3670016 & i23) | (29360128 & i23) | (234881024 & i23) | (i23 & 1879048192), ((i15 >> 24) & 14) | 3456 | ((i14 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipBorder2 = chipBorder3;
                        modifier2 = modifier4;
                        z3 = z5;
                        function25 = function26;
                        function24 = function27;
                        shape2 = shape4;
                        chipColors3 = chipColors5;
                        chipElevation2 = chipElevation4;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        function24 = function23;
                        shape2 = shape;
                        chipElevation2 = chipElevation;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z3 = z2;
                        chipColors3 = chipColors2;
                        modifier2 = obj2;
                        function25 = obj3;
                        chipBorder2 = chipBorder;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                return ChipKt.AssistChip$lambda$2(Function0.this, function2, modifier2, z3, function25, function24, shape2, chipColors3, chipElevation2, chipBorder2, mutableInteractionSource2, i, i2, i3, (Composer) obj4, ((Integer) obj5).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                obj3 = function22;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                i8 = i3 & 1024;
                if (i8 == 0) {
                }
                i11 = i4;
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj3 = function22;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & 1024;
            if (i8 == 0) {
            }
            i11 = i4;
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj3 = function22;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & 1024;
        if (i8 == 0) {
        }
        i11 = i4;
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i11 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedAssistChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        Object obj2;
        int i5;
        boolean z2;
        int i6;
        Object obj3;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors3;
        final Modifier modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final BorderStroke borderStroke2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        int i14;
        Modifier modifier3;
        int i15;
        int i16;
        ChipElevation chipElevation3;
        int i17;
        MutableInteractionSource mutableInteractionSource3;
        ChipElevation chipElevation4;
        BorderStroke borderStroke3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Modifier modifier4;
        Shape shape4;
        int i18;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(2028863105);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedAssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)310@15241L5,305@15073L542:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i20 = i3 & 4;
        if (i20 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i4 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i19 = 8388608;
                                i4 |= i19;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i19 = 4194304;
                        i4 |= i19;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changed(chipElevation)) {
                            i18 = 67108864;
                            i4 |= i18;
                        }
                        i18 = 33554432;
                        i4 |= i18;
                    }
                    i8 = i3 & 512;
                    if (i8 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i9 = i8;
                        i4 |= startRestartGroup.changed(borderStroke) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i11 = i10;
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        i13 = i4;
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "299@14813L5,300@14864L26,301@14943L29");
                            int i21 = i12;
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                int i22 = (i3 & 64) != 0 ? i13 & (-3670017) : i13;
                                if ((i3 & 128) != 0) {
                                    i22 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i22 &= -234881025;
                                }
                                function26 = function23;
                                shape4 = shape;
                                chipElevation4 = chipElevation;
                                borderStroke3 = borderStroke;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i15 = 6;
                                modifier4 = obj2;
                                i17 = i22;
                                i16 = i21;
                                function27 = obj3;
                            } else {
                                Modifier.Companion companion = i20 != 0 ? Modifier.Companion : obj2;
                                boolean z4 = i5 == 0 ? z2 : true;
                                Function2<? super Composer, ? super Integer, Unit> function28 = i6 != 0 ? null : obj3;
                                Function2<? super Composer, ? super Integer, Unit> function29 = i7 != 0 ? null : function23;
                                if ((i3 & 64) != 0) {
                                    i14 = i13 & (-3670017);
                                    shape3 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape;
                                    i14 = i13;
                                }
                                if ((i3 & 128) != 0) {
                                    chipColors2 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(startRestartGroup, 6);
                                    i14 &= -29360129;
                                }
                                ChipColors chipColors4 = chipColors2;
                                int i23 = i14;
                                if ((i3 & 256) != 0) {
                                    modifier3 = companion;
                                    i16 = i21;
                                    i15 = 6;
                                    chipElevation3 = AssistChipDefaults.INSTANCE.m1740elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    i17 = i23 & (-234881025);
                                } else {
                                    modifier3 = companion;
                                    i15 = 6;
                                    i16 = i21;
                                    chipElevation3 = chipElevation;
                                    i17 = i23;
                                }
                                BorderStroke borderStroke4 = i9 != 0 ? null : borderStroke;
                                if (i11 != 0) {
                                    chipElevation4 = chipElevation3;
                                    borderStroke3 = borderStroke4;
                                    z2 = z4;
                                    mutableInteractionSource3 = null;
                                    function27 = function28;
                                    chipColors2 = chipColors4;
                                    function26 = function29;
                                    shape4 = shape3;
                                    modifier4 = modifier3;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    chipElevation4 = chipElevation3;
                                    borderStroke3 = borderStroke4;
                                    function26 = function29;
                                    z2 = z4;
                                    function27 = function28;
                                    chipColors2 = chipColors4;
                                    modifier4 = modifier3;
                                    shape4 = shape3;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2028863105, i17, i16, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:305)");
                            }
                            int i24 = i17 << 6;
                            int i25 = i17 >> 24;
                            ChipColors chipColors5 = chipColors2;
                            boolean z5 = z2;
                            m1828ChipnkUnTEs(modifier4, function0, z5, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i15), chipColors2.m1818labelColorvNxB06k$material3(z2), function27, function26, shape4, chipColors5, chipElevation4, borderStroke3, AssistChipDefaults.INSTANCE.m1741getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource3, startRestartGroup, ((i17 >> 6) & 14) | ((i17 << 3) & 112) | ((i17 >> 3) & 896) | (i24 & 7168) | (3670016 & i24) | (29360128 & i24) | (234881024 & i24) | (i24 & 1879048192), (i25 & 112) | (i25 & 14) | 3456 | ((i16 << 12) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            modifier2 = modifier4;
                            z3 = z5;
                            function25 = function27;
                            function24 = function26;
                            shape2 = shape4;
                            chipColors3 = chipColors5;
                            chipElevation2 = chipElevation4;
                            borderStroke2 = borderStroke3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function23;
                            chipElevation2 = chipElevation;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z3 = z2;
                            composer2 = startRestartGroup;
                            shape2 = shape;
                            chipColors3 = chipColors2;
                            modifier2 = obj2;
                            function25 = obj3;
                            borderStroke2 = borderStroke;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj4, Object obj5) {
                                    return ChipKt.ElevatedAssistChip$lambda$3(Function0.this, function2, modifier2, z3, function25, function24, shape2, chipColors3, chipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj4, ((Integer) obj5).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    i13 = i4;
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function22;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i8 = i3 & 512;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & 1024;
                if (i10 != 0) {
                }
                i13 = i4;
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj3 = function22;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i8 = i3 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            i13 = i4;
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj3 = function22;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i8 = i3 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        i13 = i4;
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0110  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedAssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void ElevatedAssistChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Function2 function23, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        Object obj2;
        int i5;
        boolean z2;
        int i6;
        Object obj3;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        final Function2 function24;
        final ChipElevation chipElevation2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z3;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors3;
        final Modifier modifier2;
        final Function2 function25;
        final ChipBorder chipBorder2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        int i14;
        Modifier modifier3;
        int i15;
        int i16;
        ChipElevation chipElevation3;
        int i17;
        MutableInteractionSource mutableInteractionSource3;
        ChipElevation chipElevation4;
        ChipBorder chipBorder3;
        Function2 function26;
        Function2 function27;
        Shape shape4;
        Modifier modifier4;
        State<BorderStroke> borderStroke$material3;
        int i18;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(-759567147);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedAssistChip)N(onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)394@19326L5,389@19158L572:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i20 = i3 & 4;
        if (i20 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i4 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i4 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? 131072 : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(shape)) ? 1048576 : 524288;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i19 = 8388608;
                                i4 |= i19;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i19 = 4194304;
                        i4 |= i19;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changed(chipElevation)) {
                            i18 = 67108864;
                            i4 |= i18;
                        }
                        i18 = 33554432;
                        i4 |= i18;
                    }
                    i8 = i3 & 512;
                    if (i8 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i9 = i8;
                        i4 |= startRestartGroup.changed(chipBorder) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i11 = i10;
                            i12 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        i13 = i4;
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "383@18866L5,384@18917L26,385@18996L29,387@19109L39");
                            int i21 = i12;
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                int i22 = (i3 & 64) != 0 ? i13 & (-3670017) : i13;
                                if ((i3 & 128) != 0) {
                                    i22 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i22 &= -234881025;
                                }
                                function27 = function23;
                                shape4 = shape;
                                chipElevation4 = chipElevation;
                                chipBorder3 = chipBorder;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i15 = 6;
                                modifier4 = obj2;
                                i17 = i22;
                                i16 = i21;
                                function26 = obj3;
                            } else {
                                Modifier.Companion companion = i20 != 0 ? Modifier.Companion : obj2;
                                boolean z4 = i5 == 0 ? z2 : true;
                                Function2 function28 = i6 != 0 ? null : obj3;
                                Function2 function29 = i7 != 0 ? null : function23;
                                if ((i3 & 64) != 0) {
                                    i14 = i13 & (-3670017);
                                    shape3 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape;
                                    i14 = i13;
                                }
                                if ((i3 & 128) != 0) {
                                    chipColors2 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(startRestartGroup, 6);
                                    i14 &= -29360129;
                                }
                                ChipColors chipColors4 = chipColors2;
                                int i23 = i14;
                                if ((i3 & 256) != 0) {
                                    modifier3 = companion;
                                    i16 = i21;
                                    i15 = 6;
                                    chipElevation3 = AssistChipDefaults.INSTANCE.m1740elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    i17 = i23 & (-234881025);
                                } else {
                                    modifier3 = companion;
                                    i15 = 6;
                                    i16 = i21;
                                    chipElevation3 = chipElevation;
                                    i17 = i23;
                                }
                                ChipBorder chipBorder4 = i9 != 0 ? null : chipBorder;
                                if (i11 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 200442940, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    chipElevation4 = chipElevation3;
                                    chipBorder3 = chipBorder4;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    chipElevation4 = chipElevation3;
                                    chipBorder3 = chipBorder4;
                                }
                                z2 = z4;
                                function26 = function28;
                                chipColors2 = chipColors4;
                                function27 = function29;
                                shape4 = shape3;
                                modifier4 = modifier3;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-759567147, i17, i16, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:389)");
                            }
                            TextStyle value = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i15);
                            BorderStroke borderStroke = null;
                            long m1818labelColorvNxB06k$material3 = chipColors2.m1818labelColorvNxB06k$material3(z2);
                            float m1741getHeightD9Ej5fM = AssistChipDefaults.INSTANCE.m1741getHeightD9Ej5fM();
                            PaddingValues paddingValues = AssistChipPadding;
                            if (chipBorder3 == null) {
                                startRestartGroup.startReplaceGroup(1919297975);
                                startRestartGroup.endReplaceGroup();
                                borderStroke$material3 = null;
                            } else {
                                startRestartGroup.startReplaceGroup(200460170);
                                ComposerKt.sourceInformation(startRestartGroup, "403@19648L21");
                                borderStroke$material3 = chipBorder3.borderStroke$material3(z2, startRestartGroup, ((i17 >> 9) & 14) | ((i17 >> 24) & 112));
                                startRestartGroup.endReplaceGroup();
                            }
                            if (borderStroke$material3 != null) {
                                borderStroke = borderStroke$material3.getValue();
                            }
                            int i24 = i17 << 6;
                            ChipColors chipColors5 = chipColors2;
                            boolean z5 = z2;
                            m1828ChipnkUnTEs(modifier4, function0, z5, obj, value, m1818labelColorvNxB06k$material3, function26, function27, shape4, chipColors5, chipElevation4, borderStroke, m1741getHeightD9Ej5fM, paddingValues, mutableInteractionSource3, startRestartGroup, ((i17 >> 6) & 14) | ((i17 << 3) & 112) | ((i17 >> 3) & 896) | (i24 & 7168) | (3670016 & i24) | (29360128 & i24) | (234881024 & i24) | (i24 & 1879048192), ((i17 >> 24) & 14) | 3456 | ((i16 << 12) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipBorder2 = chipBorder3;
                            composer2 = startRestartGroup;
                            modifier2 = modifier4;
                            z3 = z5;
                            function25 = function26;
                            function24 = function27;
                            shape2 = shape4;
                            chipColors3 = chipColors5;
                            chipElevation2 = chipElevation4;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function23;
                            chipElevation2 = chipElevation;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z3 = z2;
                            composer2 = startRestartGroup;
                            shape2 = shape;
                            chipColors3 = chipColors2;
                            modifier2 = obj2;
                            function25 = obj3;
                            chipBorder2 = chipBorder;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj4, Object obj5) {
                                    return ChipKt.ElevatedAssistChip$lambda$5(Function0.this, function2, modifier2, z3, function25, function24, shape2, chipColors3, chipElevation2, chipBorder2, mutableInteractionSource2, i, i2, i3, (Composer) obj4, ((Integer) obj5).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    i13 = i4;
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function22;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i8 = i3 & 512;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & 1024;
                if (i10 != 0) {
                }
                i13 = i4;
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj3 = function22;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i8 = i3 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            i13 = i4;
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj3 = function22;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i8 = i3 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        i13 = i4;
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i12 & 3) != 2, i13 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilterChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        boolean z3;
        int i4;
        Object obj;
        Object obj2;
        Object obj3;
        int i5;
        boolean z4;
        int i6;
        int i7;
        Object obj4;
        Object obj5;
        Object obj6;
        int i8;
        int i9;
        int i10;
        Object obj7;
        int i11;
        int i12;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        final SelectableChipColors selectableChipColors2;
        final Modifier modifier2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Shape shape2;
        final boolean z5;
        final SelectableChipElevation selectableChipElevation2;
        ScopeUpdateScope endRestartGroup;
        int i13;
        Shape shape3;
        SelectableChipColors selectableChipColors3;
        Modifier modifier3;
        int i14;
        int i15;
        SelectableChipElevation selectableChipElevation3;
        int i16;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        SelectableChipElevation selectableChipElevation4;
        BorderStroke borderStroke4;
        boolean z6;
        int i17;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape shape4;
        SelectableChipColors selectableChipColors4;
        Modifier modifier4;
        int i18;
        int i19;
        int i20;
        int i21;
        Composer startRestartGroup = composer.startRestartGroup(-1385473344);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilterChip)N(selected,onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)480@23562L5,474@23355L555:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i4 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            obj = function0;
        } else {
            obj = function0;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            obj2 = function2;
        } else {
            obj2 = function2;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i4 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
            }
        }
        int i22 = i3 & 8;
        if (i22 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            obj3 = modifier;
            i4 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                z4 = z2;
                i4 |= startRestartGroup.changed(z4) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    obj4 = function23;
                } else {
                    obj4 = function23;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(obj4) ? 1048576 : 524288;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        obj5 = shape;
                        if (startRestartGroup.changed(obj5)) {
                            i21 = 8388608;
                            i4 |= i21;
                        }
                    } else {
                        obj5 = shape;
                    }
                    i21 = 4194304;
                    i4 |= i21;
                } else {
                    obj5 = shape;
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        obj6 = selectableChipColors;
                        if (startRestartGroup.changed(obj6)) {
                            i20 = 67108864;
                            i4 |= i20;
                        }
                    } else {
                        obj6 = selectableChipColors;
                    }
                    i20 = 33554432;
                    i4 |= i20;
                } else {
                    obj6 = selectableChipColors;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0 && startRestartGroup.changed(selectableChipElevation)) {
                        i19 = C.BUFFER_FLAG_LAST_SAMPLE;
                        i4 |= i19;
                    }
                    i19 = 268435456;
                    i4 |= i19;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0 && startRestartGroup.changed(borderStroke)) {
                        i18 = 4;
                        i8 = i2 | i18;
                    }
                    i18 = 2;
                    i8 = i2 | i18;
                } else {
                    i8 = i2;
                }
                i9 = i3 & 2048;
                if (i9 != 0) {
                    i10 = i9;
                    i11 = i8 | 48;
                    obj7 = mutableInteractionSource;
                } else {
                    if ((i2 & 48) == 0) {
                        i10 = i9;
                        obj7 = mutableInteractionSource;
                        i8 |= startRestartGroup.changed(obj7) ? 32 : 16;
                    } else {
                        i10 = i9;
                        obj7 = mutableInteractionSource;
                    }
                    i11 = i8;
                }
                i12 = i4;
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i11 & 19) != 18, i12 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "468@23041L5,469@23102L18,470@23183L21,471@23253L35");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        int i23 = (i3 & 128) != 0 ? i12 & (-29360129) : i12;
                        if ((i3 & 256) != 0) {
                            i23 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i23 &= -1879048193;
                        }
                        if ((i3 & 1024) != 0) {
                            i11 &= -15;
                        }
                        function26 = function22;
                        selectableChipElevation4 = selectableChipElevation;
                        borderStroke4 = borderStroke;
                        mutableInteractionSource3 = obj7;
                        function27 = obj4;
                        shape4 = obj5;
                        selectableChipColors4 = obj6;
                        modifier4 = obj3;
                        z6 = z4;
                        i16 = i23;
                        i14 = 6;
                        i17 = i11;
                    } else {
                        Modifier.Companion companion = i22 != 0 ? Modifier.Companion : obj3;
                        boolean z7 = i5 != 0 ? true : z4;
                        Function2<? super Composer, ? super Integer, Unit> function28 = i6 != 0 ? null : function22;
                        Function2<? super Composer, ? super Integer, Unit> function29 = i7 != 0 ? null : obj4;
                        if ((i3 & 128) != 0) {
                            i13 = i12 & (-29360129);
                            shape3 = FilterChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        } else {
                            i13 = i12;
                            shape3 = obj5;
                        }
                        if ((i3 & 256) != 0) {
                            i13 &= -234881025;
                            selectableChipColors3 = FilterChipDefaults.INSTANCE.filterChipColors(startRestartGroup, 6);
                        } else {
                            selectableChipColors3 = obj6;
                        }
                        int i24 = i13;
                        if ((i3 & 512) != 0) {
                            modifier3 = companion;
                            i14 = 6;
                            i15 = i10;
                            selectableChipElevation3 = FilterChipDefaults.INSTANCE.m2100filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            i16 = i24 & (-1879048193);
                        } else {
                            modifier3 = companion;
                            i14 = 6;
                            i15 = i10;
                            selectableChipElevation3 = selectableChipElevation;
                            i16 = i24;
                        }
                        if ((i3 & 1024) != 0) {
                            borderStroke3 = FilterChipDefaults.INSTANCE.m2098filterChipBorder_7El2pE(z7, z3, 0L, 0L, 0L, 0L, 0.0f, 0.0f, startRestartGroup, ((i16 >> 12) & 14) | 100663296 | ((i16 << 3) & 112), 252);
                            i11 &= -15;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i15 != 0) {
                            selectableChipElevation4 = selectableChipElevation3;
                            borderStroke4 = borderStroke3;
                            z6 = z7;
                            i17 = i11;
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            selectableChipElevation4 = selectableChipElevation3;
                            borderStroke4 = borderStroke3;
                            z6 = z7;
                            i17 = i11;
                        }
                        function26 = function28;
                        function27 = function29;
                        shape4 = shape3;
                        selectableChipColors4 = selectableChipColors3;
                        modifier4 = modifier3;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1385473344, i16, i17, "androidx.compose.material3.FilterChip (Chip.kt:474)");
                    }
                    int i25 = i16 << 3;
                    int i26 = i16 << 6;
                    int i27 = i16 >> 24;
                    m1830SelectableChipu0RnIRE(z, modifier4, obj, z6, obj2, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), function26, null, function27, shape4, selectableChipColors4, selectableChipElevation4, borderStroke4, FilterChipDefaults.INSTANCE.m2101getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource3, startRestartGroup, (i16 & 14) | 12582912 | ((i16 >> 6) & 112) | (i25 & 896) | ((i16 >> 3) & 7168) | (57344 & i26) | (i25 & 3670016) | (234881024 & i26) | (1879048192 & i26), (i27 & 112) | (i27 & 14) | 27648 | ((i17 << 6) & 896) | ((i17 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = startRestartGroup;
                    modifier2 = modifier4;
                    z5 = z6;
                    function24 = function26;
                    function25 = function27;
                    shape2 = shape4;
                    selectableChipColors2 = selectableChipColors4;
                    selectableChipElevation2 = selectableChipElevation4;
                    borderStroke2 = borderStroke4;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors2 = obj6;
                    modifier2 = obj3;
                    composer2 = startRestartGroup;
                    function24 = function22;
                    function25 = obj4;
                    shape2 = obj5;
                    z5 = z4;
                    selectableChipElevation2 = selectableChipElevation;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj8, Object obj9) {
                            return ChipKt.FilterChip$lambda$6(z, function0, function2, modifier2, z5, function24, function25, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj8, ((Integer) obj9).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z4 = z2;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            i9 = i3 & 2048;
            if (i9 != 0) {
            }
            i12 = i4;
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i11 & 19) != 18, i12 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj3 = modifier;
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        z4 = z2;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        i9 = i3 & 2048;
        if (i9 != 0) {
        }
        i12 = i4;
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i11 & 19) != 18, i12 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedFilterChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Object obj;
        Object obj2;
        Object obj3;
        int i5;
        boolean z3;
        int i6;
        int i7;
        Object obj4;
        Object obj5;
        Object obj6;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        final SelectableChipColors selectableChipColors2;
        final Modifier modifier2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Shape shape2;
        final boolean z4;
        final SelectableChipElevation selectableChipElevation2;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Shape shape3;
        SelectableChipColors selectableChipColors3;
        Modifier modifier3;
        int i16;
        int i17;
        SelectableChipElevation selectableChipElevation3;
        int i18;
        MutableInteractionSource mutableInteractionSource3;
        SelectableChipElevation selectableChipElevation4;
        BorderStroke borderStroke3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i19;
        Shape shape4;
        int i20;
        Modifier modifier4;
        boolean z5;
        int i21;
        int i22;
        int i23;
        Composer startRestartGroup = composer.startRestartGroup(1533553846);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedFilterChip)N(selected,onClick,label,modifier,enabled,leadingIcon,trailingIcon,shape,colors,elevation,border,interactionSource)562@27590L5,556@27383L555:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            obj = function0;
        } else {
            obj = function0;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            obj2 = function2;
        } else {
            obj2 = function2;
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i4 |= startRestartGroup.changedInstance(obj2) ? 256 : 128;
            }
        }
        int i24 = i3 & 8;
        if (i24 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            obj3 = modifier;
            i4 |= startRestartGroup.changed(obj3) ? 2048 : 1024;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                z3 = z2;
                i4 |= startRestartGroup.changed(z3) ? 16384 : 8192;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 131072 : 65536;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    obj4 = function23;
                } else {
                    obj4 = function23;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(obj4) ? 1048576 : 524288;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        obj5 = shape;
                        if (startRestartGroup.changed(obj5)) {
                            i23 = 8388608;
                            i4 |= i23;
                        }
                    } else {
                        obj5 = shape;
                    }
                    i23 = 4194304;
                    i4 |= i23;
                } else {
                    obj5 = shape;
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        obj6 = selectableChipColors;
                        if (startRestartGroup.changed(obj6)) {
                            i22 = 67108864;
                            i4 |= i22;
                        }
                    } else {
                        obj6 = selectableChipColors;
                    }
                    i22 = 33554432;
                    i4 |= i22;
                } else {
                    obj6 = selectableChipColors;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0 && startRestartGroup.changed(selectableChipElevation)) {
                        i21 = C.BUFFER_FLAG_LAST_SAMPLE;
                        i4 |= i21;
                    }
                    i21 = 268435456;
                    i4 |= i21;
                }
                i8 = i3 & 1024;
                if (i8 != 0) {
                    i10 = i2 | 6;
                    i9 = i8;
                } else if ((i2 & 6) == 0) {
                    i9 = i8;
                    i10 = i2 | (startRestartGroup.changed(borderStroke) ? 4 : 2);
                } else {
                    i9 = i8;
                    i10 = i2;
                }
                i11 = i3 & 2048;
                if (i11 != 0) {
                    i10 |= 48;
                    i12 = i11;
                } else if ((i2 & 48) == 0) {
                    i12 = i11;
                    i10 |= startRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
                } else {
                    i12 = i11;
                }
                i13 = i10;
                i14 = i4;
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
                    startRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(startRestartGroup, "550@27103L5,551@27164L26,552@27253L29");
                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                        startRestartGroup.skipToGroupEnd();
                        int i25 = (i3 & 128) != 0 ? i14 & (-29360129) : i14;
                        if ((i3 & 256) != 0) {
                            i25 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i25 &= -1879048193;
                        }
                        function26 = function22;
                        selectableChipElevation4 = selectableChipElevation;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource3 = mutableInteractionSource;
                        i16 = 6;
                        function27 = obj4;
                        shape4 = obj5;
                        selectableChipColors3 = obj6;
                        modifier4 = obj3;
                        i19 = 12582912;
                        i20 = 1533553846;
                        i18 = i25;
                        z5 = z3;
                        i17 = i13;
                    } else {
                        Modifier.Companion companion = i24 != 0 ? Modifier.Companion : obj3;
                        boolean z6 = i5 == 0 ? z3 : true;
                        Function2<? super Composer, ? super Integer, Unit> function28 = i6 != 0 ? null : function22;
                        Function2<? super Composer, ? super Integer, Unit> function29 = i7 != 0 ? null : obj4;
                        if ((i3 & 128) != 0) {
                            i15 = i14 & (-29360129);
                            shape3 = FilterChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        } else {
                            i15 = i14;
                            shape3 = obj5;
                        }
                        if ((i3 & 256) != 0) {
                            i15 &= -234881025;
                            selectableChipColors3 = FilterChipDefaults.INSTANCE.elevatedFilterChipColors(startRestartGroup, 6);
                        } else {
                            selectableChipColors3 = obj6;
                        }
                        int i26 = i15;
                        if ((i3 & 512) != 0) {
                            modifier3 = companion;
                            i17 = i13;
                            i16 = 6;
                            selectableChipElevation3 = FilterChipDefaults.INSTANCE.m2097elevatedFilterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            i18 = i26 & (-1879048193);
                        } else {
                            modifier3 = companion;
                            i16 = 6;
                            i17 = i13;
                            selectableChipElevation3 = selectableChipElevation;
                            i18 = i26;
                        }
                        BorderStroke borderStroke4 = i9 != 0 ? null : borderStroke;
                        if (i12 != 0) {
                            selectableChipElevation4 = selectableChipElevation3;
                            borderStroke3 = borderStroke4;
                            function26 = function28;
                            function27 = function29;
                            i19 = 12582912;
                            mutableInteractionSource3 = null;
                            i20 = 1533553846;
                            modifier4 = modifier3;
                            z5 = z6;
                            shape4 = shape3;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            selectableChipElevation4 = selectableChipElevation3;
                            borderStroke3 = borderStroke4;
                            function26 = function28;
                            function27 = function29;
                            i19 = 12582912;
                            shape4 = shape3;
                            i20 = 1533553846;
                            modifier4 = modifier3;
                            z5 = z6;
                        }
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i20, i18, i17, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:556)");
                    }
                    int i27 = i18 << 3;
                    int i28 = i18 << 6;
                    int i29 = i19 | (i18 & 14) | ((i18 >> 6) & 112) | (i27 & 896) | ((i18 >> 3) & 7168) | (57344 & i28) | (i27 & 3670016) | (234881024 & i28) | (1879048192 & i28);
                    int i30 = i18 >> 24;
                    m1830SelectableChipu0RnIRE(z, modifier4, obj, z5, obj2, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i16), function26, null, function27, shape4, selectableChipColors3, selectableChipElevation4, borderStroke3, FilterChipDefaults.INSTANCE.m2101getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource3, startRestartGroup, i29, (i30 & 112) | (i30 & 14) | 27648 | ((i17 << 6) & 896) | ((i17 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = startRestartGroup;
                    modifier2 = modifier4;
                    z4 = z5;
                    function24 = function26;
                    function25 = function27;
                    shape2 = shape4;
                    selectableChipColors2 = selectableChipColors3;
                    selectableChipElevation2 = selectableChipElevation4;
                    borderStroke2 = borderStroke3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    borderStroke2 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors2 = obj6;
                    modifier2 = obj3;
                    composer2 = startRestartGroup;
                    function24 = function22;
                    function25 = obj4;
                    shape2 = obj5;
                    z4 = z3;
                    selectableChipElevation2 = selectableChipElevation;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj7, Object obj8) {
                            return ChipKt.ElevatedFilterChip$lambda$7(z, function0, function2, modifier2, z4, function24, function25, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj7, ((Integer) obj8).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            z3 = z2;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            i8 = i3 & 1024;
            if (i8 != 0) {
            }
            i11 = i3 & 2048;
            if (i11 != 0) {
            }
            i13 = i10;
            i14 = i4;
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj3 = modifier;
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        z3 = z2;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        i8 = i3 & 1024;
        if (i8 != 0) {
        }
        i11 = i3 & 2048;
        if (i11 != 0) {
        }
        i13 = i10;
        i14 = i4;
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 19) != 18, i14 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:234:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InputChip(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        boolean z3;
        int i4;
        Object obj;
        int i5;
        int i6;
        int i7;
        final Object obj2;
        int i8;
        final Object obj3;
        int i9;
        Object obj4;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final Modifier modifier2;
        final boolean z4;
        final SelectableChipElevation selectableChipElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Shape shape2;
        final SelectableChipColors selectableChipColors2;
        ScopeUpdateScope endRestartGroup;
        Shape shape3;
        int i15;
        SelectableChipColors selectableChipColors3;
        Modifier modifier3;
        int i16;
        int i17;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        SelectableChipElevation selectableChipElevation4;
        BorderStroke borderStroke4;
        boolean z5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape shape4;
        SelectableChipColors selectableChipColors4;
        int i18;
        Modifier modifier4;
        boolean z6;
        int i19;
        int i20;
        int i21;
        int i22;
        Composer startRestartGroup = composer.startRestartGroup(-1975409271);
        ComposerKt.sourceInformation(startRestartGroup, "C(InputChip)N(selected,onClick,label,modifier,enabled,leadingIcon,avatar,trailingIcon,shape,colors,elevation,border,interactionSource)673@32653L5,667@32447L747:Chip.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i4 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i4 = i;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            obj = function0;
        } else {
            obj = function0;
            if ((i & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        if ((i3 & 4) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(modifier) ? 2048 : 1024;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        obj2 = function22;
                    } else {
                        obj2 = function22;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj2) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        obj3 = function23;
                    } else {
                        obj3 = function23;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj3) ? 1048576 : 524288;
                        }
                    }
                    i9 = i3 & 128;
                    if (i9 == 0) {
                        i4 |= 12582912;
                        obj4 = function24;
                    } else {
                        obj4 = function24;
                        if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changedInstance(obj4) ? 8388608 : 4194304;
                        }
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changed(shape)) {
                            i22 = 67108864;
                            i4 |= i22;
                        }
                        i22 = 33554432;
                        i4 |= i22;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0 && startRestartGroup.changed(selectableChipColors)) {
                            i21 = C.BUFFER_FLAG_LAST_SAMPLE;
                            i4 |= i21;
                        }
                        i21 = 268435456;
                        i4 |= i21;
                    }
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0 && startRestartGroup.changed(selectableChipElevation)) {
                            i20 = 4;
                            i10 = i2 | i20;
                        }
                        i20 = 2;
                        i10 = i2 | i20;
                    } else {
                        i10 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i3 & 2048) == 0 && startRestartGroup.changed(borderStroke)) {
                            i19 = 32;
                            i10 |= i19;
                        }
                        i19 = 16;
                        i10 |= i19;
                    }
                    int i23 = i10;
                    i11 = i3 & 4096;
                    if (i11 == 0) {
                        i12 = i11;
                        i13 = i23 | RendererCapabilities.DECODER_SUPPORT_MASK;
                    } else {
                        int i24 = i23;
                        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i24 |= startRestartGroup.changed(mutableInteractionSource) ? 256 : 128;
                        }
                        i12 = i11;
                        i13 = i24;
                    }
                    i14 = i4;
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 147) != 146, i14 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "640@31314L5,641@31374L17,642@31453L20,643@31521L34");
                        ComposableLambda composableLambda = null;
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            int i25 = (i3 & 256) != 0 ? i14 & (-234881025) : i14;
                            if ((i3 & 512) != 0) {
                                i25 &= -1879048193;
                            }
                            if ((i3 & 1024) != 0) {
                                i13 &= -15;
                            }
                            if ((i3 & 2048) != 0) {
                                i13 &= -113;
                            }
                            i18 = i25;
                            i16 = 6;
                            modifier4 = modifier;
                            z5 = z2;
                            shape4 = shape;
                            selectableChipColors4 = selectableChipColors;
                            selectableChipElevation4 = selectableChipElevation;
                            borderStroke4 = borderStroke;
                            mutableInteractionSource3 = mutableInteractionSource;
                            function26 = obj2;
                            function27 = obj4;
                        } else {
                            Modifier.Companion companion = i5 != 0 ? Modifier.Companion : modifier;
                            boolean z7 = i6 != 0 ? true : z2;
                            Function2<? super Composer, ? super Integer, Unit> function28 = i7 != 0 ? null : obj2;
                            Function2<? super Composer, ? super Integer, Unit> function29 = i8 != 0 ? null : obj3;
                            Function2<? super Composer, ? super Integer, Unit> function210 = i9 != 0 ? null : obj4;
                            if ((i3 & 256) != 0) {
                                i15 = i14 & (-234881025);
                                shape3 = InputChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape3 = shape;
                                i15 = i14;
                            }
                            if ((i3 & 512) != 0) {
                                i15 &= -1879048193;
                                selectableChipColors3 = InputChipDefaults.INSTANCE.inputChipColors(startRestartGroup, 6);
                            } else {
                                selectableChipColors3 = selectableChipColors;
                            }
                            int i26 = i15;
                            if ((i3 & 1024) != 0) {
                                modifier3 = companion;
                                i16 = 6;
                                i17 = i12;
                                selectableChipElevation3 = InputChipDefaults.INSTANCE.m2182inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                i13 &= -15;
                            } else {
                                modifier3 = companion;
                                i16 = 6;
                                i17 = i12;
                                selectableChipElevation3 = selectableChipElevation;
                            }
                            if ((i3 & 2048) != 0) {
                                borderStroke3 = InputChipDefaults.INSTANCE.m2180inputChipBorder_7El2pE(z7, z3, 0L, 0L, 0L, 0L, 0.0f, 0.0f, startRestartGroup, ((i26 >> 12) & 14) | 100663296 | ((i26 << 3) & 112), 252);
                                i13 &= -113;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i17 != 0) {
                                selectableChipElevation4 = selectableChipElevation3;
                                borderStroke4 = borderStroke3;
                                z5 = z7;
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                selectableChipElevation4 = selectableChipElevation3;
                                borderStroke4 = borderStroke3;
                                z5 = z7;
                            }
                            function26 = function28;
                            obj3 = function29;
                            function27 = function210;
                            shape4 = shape3;
                            selectableChipColors4 = selectableChipColors3;
                            i18 = i26;
                            modifier4 = modifier3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1975409271, i18, i13, "androidx.compose.material3.InputChip (Chip.kt:645)");
                        }
                        if (obj3 != null) {
                            startRestartGroup.startReplaceGroup(225175787);
                            ComposerKt.sourceInformation(startRestartGroup, "651@31963L5,653@32016L420");
                            z6 = true;
                            composableLambda = ComposableLambdaKt.rememberComposableLambda(-570452295, true, new ChipKt$InputChip$1(z5 ? 1.0f : InputChipTokens.INSTANCE.getDisabledAvatarOpacity(), ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), startRestartGroup, i16), obj3), startRestartGroup, 54);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            z6 = true;
                            startRestartGroup.startReplaceGroup(225773529);
                            startRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambda2 = composableLambda;
                        TextStyle value = TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i16);
                        float m2178getHeightD9Ej5fM = InputChipDefaults.INSTANCE.m2178getHeightD9Ej5fM();
                        boolean z8 = composableLambda2 != null ? z6 : false;
                        boolean z9 = function26 != null ? z6 : false;
                        if (function27 == null) {
                            z6 = false;
                        }
                        PaddingValues inputChipPadding = inputChipPadding(z8, z9, z6);
                        int i27 = (i18 & 14) | ((i18 >> 6) & 112);
                        int i28 = i18 << 3;
                        int i29 = i13 << 3;
                        m1830SelectableChipu0RnIRE(z, modifier4, obj, z5, function2, value, function26, composableLambda2, function27, shape4, selectableChipColors4, selectableChipElevation4, borderStroke4, m2178getHeightD9Ej5fM, inputChipPadding, mutableInteractionSource3, startRestartGroup, i27 | (i28 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i28) | (234881024 & i28) | (i28 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i29 & 112) | (i29 & 896) | ((i13 << 9) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = startRestartGroup;
                        modifier2 = modifier4;
                        z4 = z5;
                        obj2 = function26;
                        function25 = function27;
                        shape2 = shape4;
                        selectableChipColors2 = selectableChipColors4;
                        selectableChipElevation2 = selectableChipElevation4;
                        borderStroke2 = borderStroke4;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z4 = z2;
                        selectableChipElevation2 = selectableChipElevation;
                        borderStroke2 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                        composer2 = startRestartGroup;
                        function25 = obj4;
                        shape2 = shape;
                        selectableChipColors2 = selectableChipColors;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj5, Object obj6) {
                                return ChipKt.InputChip$lambda$8(z, function0, function2, modifier2, z4, obj2, obj3, function25, shape2, selectableChipColors2, selectableChipElevation2, borderStroke2, mutableInteractionSource2, i, i2, i3, (Composer) obj5, ((Integer) obj6).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i2 & 6) != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i232 = i10;
                i11 = i3 & 4096;
                if (i11 == 0) {
                }
                i14 = i4;
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 147) != 146, i14 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i2 & 6) != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i2322 = i10;
            i11 = i3 & 4096;
            if (i11 == 0) {
            }
            i14 = i4;
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 147) != 146, i14 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i23222 = i10;
        i11 = i3 & 4096;
        if (i11 == 0) {
        }
        i14 = i4;
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i13 & 147) != 146, i14 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SuggestionChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Object obj;
        final Object obj2;
        int i4;
        boolean z2;
        int i5;
        Object obj3;
        Object obj4;
        ChipColors chipColors2;
        int i6;
        Object obj5;
        int i7;
        int i8;
        int i9;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors3;
        final ChipElevation chipElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Shape shape3;
        ChipColors chipColors4;
        int i11;
        Modifier modifier2;
        int i12;
        boolean z4;
        BorderStroke borderStroke3;
        int i13;
        MutableInteractionSource mutableInteractionSource3;
        BorderStroke borderStroke4;
        int i14;
        Shape shape4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        ChipElevation chipElevation3;
        boolean z5;
        int i15;
        int i16;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(-252243183);
        ComposerKt.sourceInformation(startRestartGroup, "C(SuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)751@36361L5,746@36189L539:Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i19 = i2 & 4;
        if (i19 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i3 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj4 = shape;
                            if (startRestartGroup.changed(obj4)) {
                                i18 = 131072;
                                i3 |= i18;
                            }
                        } else {
                            obj4 = shape;
                        }
                        i18 = 65536;
                        i3 |= i18;
                    } else {
                        obj4 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i17 = 1048576;
                                i3 |= i17;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i17 = 524288;
                        i3 |= i17;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            obj5 = chipElevation;
                            if (startRestartGroup.changed(obj5)) {
                                i16 = 8388608;
                                i3 |= i16;
                            }
                        } else {
                            obj5 = chipElevation;
                        }
                        i16 = 4194304;
                        i3 |= i16;
                    } else {
                        i6 = 12582912;
                        obj5 = chipElevation;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & 256) == 0 && startRestartGroup.changed(borderStroke)) {
                            i15 = 67108864;
                            i3 |= i15;
                        }
                        i15 = 33554432;
                        i3 |= i15;
                    }
                    i7 = i2 & 512;
                    if (i7 == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i9 = i3;
                        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "740@35881L5,741@35936L22,742@36015L25,743@36093L29");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i9 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i9 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i9 &= -234881025;
                                }
                                borderStroke4 = borderStroke;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i12 = 6;
                                function24 = obj3;
                                shape4 = obj4;
                                chipElevation3 = obj5;
                                i14 = i9;
                                z5 = z2;
                            } else {
                                Modifier.Companion companion = i19 != 0 ? Modifier.Companion : obj2;
                                boolean z6 = i4 == 0 ? z2 : true;
                                Function2<? super Composer, ? super Integer, Unit> function25 = i5 != 0 ? null : obj3;
                                if ((i2 & 32) != 0) {
                                    i10 = i9 & (-458753);
                                    shape3 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    i10 = i9;
                                    shape3 = obj4;
                                }
                                if ((i2 & 64) != 0) {
                                    i10 &= -3670017;
                                    chipColors4 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(startRestartGroup, 6);
                                } else {
                                    chipColors4 = chipColors2;
                                }
                                int i20 = i10;
                                if ((i2 & 128) != 0) {
                                    i20 &= -29360129;
                                    i11 = 6;
                                    obj5 = SuggestionChipDefaults.INSTANCE.m2568suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                } else {
                                    i11 = 6;
                                }
                                if ((i2 & 256) != 0) {
                                    modifier2 = companion;
                                    i12 = i11;
                                    z4 = z6;
                                    borderStroke3 = SuggestionChipDefaults.INSTANCE.m2566suggestionChipBorderh1eTWw(z4, 0L, 0L, 0.0f, startRestartGroup, ((i20 >> 9) & 14) | 24576, 14);
                                    i13 = i20 & (-234881025);
                                } else {
                                    modifier2 = companion;
                                    i12 = i11;
                                    z4 = z6;
                                    borderStroke3 = borderStroke;
                                    i13 = i20;
                                }
                                if (i8 != 0) {
                                    borderStroke4 = borderStroke3;
                                    i14 = i13;
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    borderStroke4 = borderStroke3;
                                    i14 = i13;
                                }
                                shape4 = shape3;
                                chipColors2 = chipColors4;
                                function24 = function25;
                                obj2 = modifier2;
                                chipElevation3 = obj5;
                                z5 = z4;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-252243183, i14, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:746)");
                            }
                            int i21 = i14 << 6;
                            int i22 = ((i14 >> 6) & 14) | i6 | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i21 & 7168) | (i21 & 3670016);
                            int i23 = i14 << 9;
                            int i24 = i22 | (234881024 & i23) | (i23 & 1879048192);
                            int i25 = i14 >> 21;
                            ChipColors chipColors5 = chipColors2;
                            Function2<? super Composer, ? super Integer, Unit> function26 = obj;
                            Modifier modifier3 = obj2;
                            m1828ChipnkUnTEs(modifier3, function02, z5, function26, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1818labelColorvNxB06k$material3(z5), function24, null, shape4, chipColors5, chipElevation3, borderStroke4, SuggestionChipDefaults.INSTANCE.m2563getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, startRestartGroup, i24, (i25 & 112) | (i25 & 14) | 3456 | ((i14 >> 15) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            obj2 = modifier3;
                            z3 = z5;
                            function23 = function24;
                            shape2 = shape4;
                            chipColors3 = chipColors5;
                            chipElevation2 = chipElevation3;
                            borderStroke2 = borderStroke4;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z3 = z2;
                            function23 = obj3;
                            composer2 = startRestartGroup;
                            shape2 = obj4;
                            chipColors3 = chipColors2;
                            chipElevation2 = obj5;
                            borderStroke2 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj6, Object obj7) {
                                    return ChipKt.SuggestionChip$lambda$9(Function0.this, function2, obj2, z3, function23, shape2, chipColors3, chipElevation2, borderStroke2, mutableInteractionSource2, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    i9 = i3;
                    if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i7 = i2 & 512;
                if (i7 == 0) {
                }
                i8 = i7;
                i9 = i3;
                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj3 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i7 = i2 & 512;
            if (i7 == 0) {
            }
            i8 = i7;
            i9 = i3;
            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj3 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i7 = i2 & 512;
        if (i7 == 0) {
        }
        i8 = i7;
        i9 = i3;
        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0112  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "SuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void SuggestionChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function0 function02;
        int i3;
        Object obj;
        final Object obj2;
        int i4;
        boolean z2;
        int i5;
        Object obj3;
        Object obj4;
        Object obj5;
        int i6;
        Object obj6;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final boolean z3;
        final Function2 function23;
        final Shape shape2;
        final ChipColors chipColors2;
        final ChipElevation chipElevation2;
        final ChipBorder chipBorder2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        int i10;
        Shape shape3;
        ChipColors chipColors3;
        int i11;
        Composer composer3;
        ChipBorder chipBorder3;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        ChipColors chipColors4;
        BorderStroke borderStroke;
        int i12;
        ChipElevation chipElevation3;
        boolean z4;
        Function2 function24;
        State<BorderStroke> borderStroke$material3;
        int i13;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(270460261);
        ComposerKt.sourceInformation(startRestartGroup, "C(SuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)833@40281L5,828@40109L569:Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i17 = i2 & 4;
        if (i17 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i3 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj4 = shape;
                            if (startRestartGroup.changed(obj4)) {
                                i16 = 131072;
                                i3 |= i16;
                            }
                        } else {
                            obj4 = shape;
                        }
                        i16 = 65536;
                        i3 |= i16;
                    } else {
                        obj4 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj5 = chipColors;
                            if (startRestartGroup.changed(obj5)) {
                                i15 = 1048576;
                                i3 |= i15;
                            }
                        } else {
                            obj5 = chipColors;
                        }
                        i15 = 524288;
                        i3 |= i15;
                    } else {
                        obj5 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            obj6 = chipElevation;
                            if (startRestartGroup.changed(obj6)) {
                                i14 = 8388608;
                                i3 |= i14;
                            }
                        } else {
                            obj6 = chipElevation;
                        }
                        i14 = 4194304;
                        i3 |= i14;
                    } else {
                        i6 = 12582912;
                        obj6 = chipElevation;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & 256) == 0 && startRestartGroup.changed(chipBorder)) {
                            i13 = 67108864;
                            i3 |= i13;
                        }
                        i13 = 33554432;
                        i3 |= i13;
                    }
                    i7 = i2 & 512;
                    if (i7 == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i9 = i3;
                        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "822@39776L5,823@39831L22,824@39910L25,825@39986L22,826@40060L39");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i9 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i9 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i9 &= -234881025;
                                }
                                chipBorder3 = chipBorder;
                                mutableInteractionSource3 = mutableInteractionSource;
                                function24 = obj3;
                                shape4 = obj4;
                                chipColors4 = obj5;
                                borderStroke = null;
                                i11 = 6;
                                chipElevation3 = obj6;
                                i12 = i9;
                                z4 = z2;
                            } else {
                                Modifier.Companion companion = i17 != 0 ? Modifier.Companion : obj2;
                                boolean z5 = i4 == 0 ? z2 : true;
                                Function2 function25 = i5 != 0 ? null : obj3;
                                if ((i2 & 32) != 0) {
                                    i10 = i9 & (-458753);
                                    shape3 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    i10 = i9;
                                    shape3 = obj4;
                                }
                                if ((i2 & 64) != 0) {
                                    i10 &= -3670017;
                                    chipColors3 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(startRestartGroup, 6);
                                } else {
                                    chipColors3 = obj5;
                                }
                                int i18 = i10;
                                if ((i2 & 128) != 0) {
                                    composer3 = startRestartGroup;
                                    i18 &= -29360129;
                                    i11 = 6;
                                    obj6 = SuggestionChipDefaults.INSTANCE.m2568suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                                } else {
                                    i11 = 6;
                                    composer3 = startRestartGroup;
                                }
                                if ((i2 & 256) != 0) {
                                    startRestartGroup = composer3;
                                    chipBorder3 = SuggestionChipDefaults.INSTANCE.m2565suggestionChipBorderd_3_b6Q(0L, 0L, 0.0f, startRestartGroup, 3072, 7);
                                    i18 &= -234881025;
                                } else {
                                    startRestartGroup = composer3;
                                    chipBorder3 = chipBorder;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2080664820, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    obj2 = companion;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    obj2 = companion;
                                }
                                shape4 = shape3;
                                chipColors4 = chipColors3;
                                borderStroke = null;
                                i12 = i18;
                                chipElevation3 = obj6;
                                z4 = z5;
                                function24 = function25;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(270460261, i12, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:828)");
                            }
                            TextStyle value = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i11);
                            long m1818labelColorvNxB06k$material3 = chipColors4.m1818labelColorvNxB06k$material3(z4);
                            if (chipBorder3 == null) {
                                startRestartGroup.startReplaceGroup(-75666041);
                                startRestartGroup.endReplaceGroup();
                                borderStroke$material3 = borderStroke;
                            } else {
                                startRestartGroup.startReplaceGroup(-2080650822);
                                ComposerKt.sourceInformation(startRestartGroup, "840@40498L21");
                                borderStroke$material3 = chipBorder3.borderStroke$material3(z4, startRestartGroup, ((i12 >> 9) & 14) | ((i12 >> 21) & 112));
                                startRestartGroup.endReplaceGroup();
                            }
                            if (borderStroke$material3 != null) {
                                borderStroke = borderStroke$material3.getValue();
                            }
                            int i19 = i12 << 6;
                            int i20 = ((i12 >> 6) & 14) | i6 | ((i12 << 3) & 112) | ((i12 >> 3) & 896) | (i19 & 7168) | (i19 & 3670016);
                            int i21 = i12 << 9;
                            ChipColors chipColors5 = chipColors4;
                            composer2 = startRestartGroup;
                            Function2 function26 = obj;
                            Modifier modifier2 = obj2;
                            m1828ChipnkUnTEs(modifier2, function02, z4, function26, value, m1818labelColorvNxB06k$material3, function24, null, shape4, chipColors5, chipElevation3, borderStroke, SuggestionChipDefaults.INSTANCE.m2563getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, composer2, i20 | (234881024 & i21) | (i21 & 1879048192), ((i12 >> 21) & 14) | 3456 | ((i12 >> 15) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipBorder2 = chipBorder3;
                            obj2 = modifier2;
                            z3 = z4;
                            function23 = function24;
                            shape2 = shape4;
                            chipColors2 = chipColors5;
                            chipElevation2 = chipElevation3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            z3 = z2;
                            function23 = obj3;
                            shape2 = obj4;
                            chipColors2 = obj5;
                            chipElevation2 = obj6;
                            chipBorder2 = chipBorder;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj7, Object obj8) {
                                    return ChipKt.SuggestionChip$lambda$11(Function0.this, function2, obj2, z3, function23, shape2, chipColors2, chipElevation2, chipBorder2, mutableInteractionSource2, i, i2, (Composer) obj7, ((Integer) obj8).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    i9 = i3;
                    if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj3 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i7 = i2 & 512;
                if (i7 == 0) {
                }
                i8 = i7;
                i9 = i3;
                if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj3 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i7 = i2 & 512;
            if (i7 == 0) {
            }
            i8 = i7;
            i9 = i3;
            if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj3 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i7 = i2 & 512;
        if (i7 == 0) {
        }
        i8 = i7;
        i9 = i3;
        if (startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i9 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedSuggestionChip(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Object obj;
        final Object obj2;
        int i4;
        boolean z2;
        int i5;
        Object obj3;
        Object obj4;
        ChipColors chipColors2;
        int i6;
        Object obj5;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors3;
        final ChipElevation chipElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        int i12;
        Shape shape3;
        ChipColors chipColors4;
        int i13;
        BorderStroke borderStroke3;
        int i14;
        MutableInteractionSource mutableInteractionSource3;
        Shape shape4;
        Function2<? super Composer, ? super Integer, Unit> function24;
        ChipElevation chipElevation3;
        boolean z4;
        int i15;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-894435833);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedSuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)904@43788L5,899@43616L539:Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i18 = i2 & 4;
        if (i18 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i3 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj4 = shape;
                            if (startRestartGroup.changed(obj4)) {
                                i17 = 131072;
                                i3 |= i17;
                            }
                        } else {
                            obj4 = shape;
                        }
                        i17 = 65536;
                        i3 |= i17;
                    } else {
                        obj4 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i16 = 1048576;
                                i3 |= i16;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i16 = 524288;
                        i3 |= i16;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            obj5 = chipElevation;
                            if (startRestartGroup.changed(obj5)) {
                                i15 = 8388608;
                                i3 |= i15;
                            }
                        } else {
                            obj5 = chipElevation;
                        }
                        i15 = 4194304;
                        i3 |= i15;
                    } else {
                        i6 = 12582912;
                        obj5 = chipElevation;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i18;
                        i3 |= startRestartGroup.changed(borderStroke) ? 67108864 : 33554432;
                        i9 = i2 & 512;
                        if (i9 != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i10 = i9;
                            i3 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            i11 = i3;
                            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "893@43340L5,894@43395L30,895@43482L33");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 32) != 0) {
                                        i11 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i11 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i11 &= -29360129;
                                    }
                                    borderStroke3 = borderStroke;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    companion = obj2;
                                    function24 = obj3;
                                    shape4 = obj4;
                                    chipElevation3 = obj5;
                                    i14 = i11;
                                    i13 = 6;
                                    z4 = z2;
                                } else {
                                    companion = i8 != 0 ? Modifier.Companion : obj2;
                                    boolean z5 = i4 == 0 ? z2 : true;
                                    Function2<? super Composer, ? super Integer, Unit> function25 = i5 != 0 ? null : obj3;
                                    if ((i2 & 32) != 0) {
                                        i12 = i11 & (-458753);
                                        shape3 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    } else {
                                        i12 = i11;
                                        shape3 = obj4;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i12 &= -3670017;
                                        chipColors4 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(startRestartGroup, 6);
                                    } else {
                                        chipColors4 = chipColors2;
                                    }
                                    int i19 = i12;
                                    if ((i2 & 128) != 0) {
                                        i19 &= -29360129;
                                        i13 = 6;
                                        obj5 = SuggestionChipDefaults.INSTANCE.m2562elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    } else {
                                        i13 = 6;
                                    }
                                    int i20 = i19;
                                    borderStroke3 = i7 != 0 ? null : borderStroke;
                                    i14 = i20;
                                    mutableInteractionSource3 = i10 != 0 ? null : mutableInteractionSource;
                                    shape4 = shape3;
                                    chipColors2 = chipColors4;
                                    function24 = function25;
                                    chipElevation3 = obj5;
                                    z4 = z5;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-894435833, i14, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:899)");
                                }
                                int i21 = i14 << 6;
                                int i22 = ((i14 >> 6) & 14) | i6 | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i21 & 7168) | (i21 & 3670016);
                                int i23 = i14 << 9;
                                int i24 = i22 | (234881024 & i23) | (i23 & 1879048192);
                                int i25 = i14 >> 21;
                                ChipColors chipColors5 = chipColors2;
                                Function2<? super Composer, ? super Integer, Unit> function26 = obj;
                                Modifier modifier2 = companion;
                                m1828ChipnkUnTEs(modifier2, function02, z4, function26, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i13), chipColors2.m1818labelColorvNxB06k$material3(z4), function24, null, shape4, chipColors5, chipElevation3, borderStroke3, SuggestionChipDefaults.INSTANCE.m2563getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource3, startRestartGroup, i24, (i25 & 112) | (i25 & 14) | 3456 | ((i14 >> 15) & 57344));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                obj2 = modifier2;
                                z3 = z4;
                                function23 = function24;
                                shape2 = shape4;
                                chipColors3 = chipColors5;
                                chipElevation2 = chipElevation3;
                                borderStroke2 = borderStroke3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z3 = z2;
                                function23 = obj3;
                                composer2 = startRestartGroup;
                                shape2 = obj4;
                                chipColors3 = chipColors2;
                                chipElevation2 = obj5;
                                borderStroke2 = borderStroke;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj6, Object obj7) {
                                        return ChipKt.ElevatedSuggestionChip$lambda$12(Function0.this, function2, obj2, z3, function23, shape2, chipColors3, chipElevation2, borderStroke2, mutableInteractionSource2, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i10 = i9;
                        i11 = i3;
                        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i18;
                    i9 = i2 & 512;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i3;
                    if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i18;
                i9 = i2 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3;
                if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj3 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i18;
            i9 = i2 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3;
            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj3 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i18;
        i9 = i2 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3;
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedSuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void ElevatedSuggestionChip(final Function0 function0, final Function2 function2, Modifier modifier, boolean z, Function2 function22, Shape shape, ChipColors chipColors, ChipElevation chipElevation, ChipBorder chipBorder, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        Function0 function02;
        int i3;
        Object obj;
        final Object obj2;
        int i4;
        boolean z2;
        int i5;
        Object obj3;
        Object obj4;
        ChipColors chipColors2;
        int i6;
        Object obj5;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        final boolean z3;
        final Function2 function23;
        Composer composer2;
        final Shape shape2;
        final ChipColors chipColors3;
        final ChipElevation chipElevation2;
        final ChipBorder chipBorder2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        int i12;
        Shape shape3;
        ChipColors chipColors4;
        int i13;
        ChipBorder chipBorder3;
        MutableInteractionSource mutableInteractionSource3;
        Function2 function24;
        Shape shape4;
        BorderStroke borderStroke;
        int i14;
        ChipElevation chipElevation3;
        boolean z4;
        State<BorderStroke> borderStroke$material3;
        int i15;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(1306662363);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedSuggestionChip)N(onClick,label,modifier,enabled,icon,shape,colors,elevation,border,interactionSource)985@47676L5,980@47504L569:Chip.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            obj = function2;
        } else {
            obj = function2;
            if ((i & 48) == 0) {
                i3 |= startRestartGroup.changedInstance(obj) ? 32 : 16;
            }
        }
        int i18 = i2 & 4;
        if (i18 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj2 = modifier;
            i3 |= startRestartGroup.changed(obj2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj3 = function22;
                    i3 |= startRestartGroup.changedInstance(obj3) ? 16384 : 8192;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            obj4 = shape;
                            if (startRestartGroup.changed(obj4)) {
                                i17 = 131072;
                                i3 |= i17;
                            }
                        } else {
                            obj4 = shape;
                        }
                        i17 = 65536;
                        i3 |= i17;
                    } else {
                        obj4 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i16 = 1048576;
                                i3 |= i16;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i16 = 524288;
                        i3 |= i16;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            obj5 = chipElevation;
                            if (startRestartGroup.changed(obj5)) {
                                i15 = 8388608;
                                i3 |= i15;
                            }
                        } else {
                            obj5 = chipElevation;
                        }
                        i15 = 4194304;
                        i3 |= i15;
                    } else {
                        i6 = 12582912;
                        obj5 = chipElevation;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i18;
                        i3 |= startRestartGroup.changed(chipBorder) ? 67108864 : 33554432;
                        i9 = i2 & 512;
                        if (i9 != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i10 = i9;
                            i3 |= startRestartGroup.changed(mutableInteractionSource) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            i11 = i3;
                            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "974@47196L5,975@47251L30,976@47338L33,978@47455L39");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 32) != 0) {
                                        i11 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i11 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i11 &= -29360129;
                                    }
                                    chipBorder3 = chipBorder;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    companion = obj2;
                                    function24 = obj3;
                                    shape4 = obj4;
                                    borderStroke = null;
                                    i13 = 6;
                                    chipElevation3 = obj5;
                                    i14 = i11;
                                    z4 = z2;
                                } else {
                                    companion = i8 != 0 ? Modifier.Companion : obj2;
                                    boolean z5 = i4 == 0 ? z2 : true;
                                    Function2 function25 = i5 != 0 ? null : obj3;
                                    if ((i2 & 32) != 0) {
                                        i12 = i11 & (-458753);
                                        shape3 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    } else {
                                        i12 = i11;
                                        shape3 = obj4;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i12 &= -3670017;
                                        chipColors4 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(startRestartGroup, 6);
                                    } else {
                                        chipColors4 = chipColors2;
                                    }
                                    int i19 = i12;
                                    if ((i2 & 128) != 0) {
                                        i19 &= -29360129;
                                        i13 = 6;
                                        obj5 = SuggestionChipDefaults.INSTANCE.m2562elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    } else {
                                        i13 = 6;
                                    }
                                    chipBorder3 = i7 != 0 ? null : chipBorder;
                                    if (i10 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1572109794, "CC(remember):Chip.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    function24 = function25;
                                    shape4 = shape3;
                                    chipColors2 = chipColors4;
                                    borderStroke = null;
                                    i14 = i19;
                                    chipElevation3 = obj5;
                                    z4 = z5;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1306662363, i14, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:980)");
                                }
                                TextStyle value = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i13);
                                long m1818labelColorvNxB06k$material3 = chipColors2.m1818labelColorvNxB06k$material3(z4);
                                float m2563getHeightD9Ej5fM = SuggestionChipDefaults.INSTANCE.m2563getHeightD9Ej5fM();
                                PaddingValues paddingValues = SuggestionChipPadding;
                                if (chipBorder3 == null) {
                                    startRestartGroup.startReplaceGroup(1491294513);
                                    startRestartGroup.endReplaceGroup();
                                    borderStroke$material3 = borderStroke;
                                } else {
                                    startRestartGroup.startReplaceGroup(1572126928);
                                    ComposerKt.sourceInformation(startRestartGroup, "994@47991L21");
                                    borderStroke$material3 = chipBorder3.borderStroke$material3(z4, startRestartGroup, ((i14 >> 9) & 14) | ((i14 >> 21) & 112));
                                    startRestartGroup.endReplaceGroup();
                                }
                                BorderStroke value2 = borderStroke$material3 != null ? borderStroke$material3.getValue() : borderStroke;
                                int i20 = i14 << 6;
                                int i21 = ((i14 >> 6) & 14) | i6 | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i20 & 7168) | (i20 & 3670016);
                                int i22 = i14 << 9;
                                ChipColors chipColors5 = chipColors2;
                                Function2 function26 = obj;
                                Modifier modifier2 = companion;
                                m1828ChipnkUnTEs(modifier2, function02, z4, function26, value, m1818labelColorvNxB06k$material3, function24, null, shape4, chipColors5, chipElevation3, value2, m2563getHeightD9Ej5fM, paddingValues, mutableInteractionSource3, startRestartGroup, i21 | (234881024 & i22) | (i22 & 1879048192), ((i14 >> 21) & 14) | 3456 | ((i14 >> 15) & 57344));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                chipBorder2 = chipBorder3;
                                composer2 = startRestartGroup;
                                obj2 = modifier2;
                                z3 = z4;
                                function23 = function24;
                                shape2 = shape4;
                                chipColors3 = chipColors5;
                                chipElevation2 = chipElevation3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z3 = z2;
                                function23 = obj3;
                                composer2 = startRestartGroup;
                                shape2 = obj4;
                                chipColors3 = chipColors2;
                                chipElevation2 = obj5;
                                chipBorder2 = chipBorder;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj6, Object obj7) {
                                        return ChipKt.ElevatedSuggestionChip$lambda$14(Function0.this, function2, obj2, z3, function23, shape2, chipColors3, chipElevation2, chipBorder2, mutableInteractionSource2, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i10 = i9;
                        i11 = i3;
                        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i18;
                    i9 = i2 & 512;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i3;
                    if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj3 = function22;
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i & 12582912) != 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i18;
                i9 = i2 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3;
                if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj3 = function22;
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i & 12582912) != 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i18;
            i9 = i2 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3;
            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj3 = function22;
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i & 12582912) != 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i18;
        i9 = i2 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3;
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i11 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: Chip-nkUnTEs  reason: not valid java name */
    private static final void m1828ChipnkUnTEs(final Modifier modifier, final Function0<Unit> function0, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Shape shape, final ChipColors chipColors, final ChipElevation chipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Composer startRestartGroup = composer.startRestartGroup(892465622);
        ComposerKt.sourceInformation(startRestartGroup, "C(Chip)N(modifier,onClick,enabled,label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,trailingIcon,shape,colors,elevation,border,minHeight:c#ui.unit.Dp,paddingValues,interactionSource)1962@97212L22,1969@97509L478,1960@97138L849:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            obj = function2;
            i3 |= startRestartGroup.changedInstance(obj) ? 2048 : 1024;
        } else {
            obj = function2;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changed(textStyle) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(chipColors) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changed(chipElevation) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(borderStroke) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changed(paddingValues) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        }
        int i5 = i4;
        if (!startRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 9363) == 9362) ? false : true, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892465622, i3, i5, "androidx.compose.material3.Chip (Chip.kt:1957)");
            }
            if (mutableInteractionSource2 == null) {
                startRestartGroup.startReplaceGroup(1596346437);
                ComposerKt.sourceInformation(startRestartGroup, "1959@97094L39");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1333978275, "CC(remember):Chip.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
            } else {
                startRestartGroup.startReplaceGroup(-1333978926);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1333974516, "CC(remember):Chip.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ChipKt.Chip_nkUnTEs$lambda$17$lambda$16((SemanticsPropertyReceiver) obj2);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            State<Dp> state = null;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue2, 1, null);
            long m1808containerColorvNxB06k$material3 = chipColors.m1808containerColorvNxB06k$material3(z);
            if (chipElevation == null) {
                startRestartGroup.startReplaceGroup(1596621344);
            } else {
                startRestartGroup.startReplaceGroup(-1333969407);
                ComposerKt.sourceInformation(startRestartGroup, "1966@97371L43");
                state = chipElevation.shadowElevation$material3(z, mutableInteractionSource2, startRestartGroup, ((i3 >> 6) & 14) | ((i5 << 6) & 896));
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            int i6 = i3;
            final Function2<? super Composer, ? super Integer, Unit> function24 = obj;
            SurfaceKt.m2572Surfaceo_FOJdg(function0, semantics$default, z, shape, m1808containerColorvNxB06k$material3, 0L, 0.0f, state != null ? state.getValue().m7569unboximpl() : Dp.m7555constructorimpl(0.0f), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-70915349, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C1970@97519L462:Chip.kt#uh7d8r");
                    if (composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-70915349, i7, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1970)");
                        }
                        ChipKt.m1829ChipContentfe0OD_I(function24, textStyle, j, function22, null, function23, chipColors.m1819leadingIconContentColorvNxB06k$material3(z), chipColors.m1820trailingIconContentColorvNxB06k$material3(z), f, paddingValues, composer3, 24576);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composer2, 54), composer2, ((i6 >> 15) & 7168) | ((i6 >> 3) & 14) | (i6 & 896) | ((i5 << 21) & 234881024), 6, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ChipKt.Chip_nkUnTEs$lambda$18(Modifier.this, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit Chip_nkUnTEs$lambda$17$lambda$16(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m6793setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m6774getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* renamed from: SelectableChip-u0RnIRE  reason: not valid java name */
    private static final void m1830SelectableChipu0RnIRE(final boolean z, final Modifier modifier, final Function0<Unit> function0, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2;
        State<Dp> shadowElevation$material3;
        Composer startRestartGroup = composer.startRestartGroup(1786844928);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectableChip)N(selected,modifier,onClick,enabled,label,labelTextStyle,leadingIcon,avatar,trailingIcon,shape,colors,elevation,border,minHeight:c#ui.unit.Dp,paddingValues,interactionSource)2009@98774L24,2016@99083L670,2006@98671L1082:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= startRestartGroup.changed(textStyle) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(shape) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changed(selectableChipColors) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(selectableChipElevation) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changed(borderStroke) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changed(paddingValues) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i4 |= startRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        int i5 = i4;
        if (!startRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (74899 & i5) == 74898) ? false : true, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1786844928, i3, i5, "androidx.compose.material3.SelectableChip (Chip.kt:2003)");
            }
            if (mutableInteractionSource == null) {
                startRestartGroup.startReplaceGroup(73215547);
                ComposerKt.sourceInformation(startRestartGroup, "2005@98627L39");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -828922201, "CC(remember):Chip.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
            } else {
                startRestartGroup.startReplaceGroup(-828922852);
                startRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = mutableInteractionSource;
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -828917512, "CC(remember):Chip.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.SelectableChip_u0RnIRE$lambda$21$lambda$20((SemanticsPropertyReceiver) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i6 = i3;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, (Function1) rememberedValue2, 1, null);
            long m2465containerColorWaAFU9c$material3 = selectableChipColors.m2465containerColorWaAFU9c$material3(z2, z);
            if (selectableChipElevation == null) {
                startRestartGroup.startReplaceGroup(73531126);
                startRestartGroup.endReplaceGroup();
                shadowElevation$material3 = null;
            } else {
                startRestartGroup.startReplaceGroup(-828912021);
                ComposerKt.sourceInformation(startRestartGroup, "2013@98945L43");
                shadowElevation$material3 = selectableChipElevation.shadowElevation$material3(z2, mutableInteractionSource2, startRestartGroup, ((i6 >> 9) & 14) | ((i5 << 3) & 896));
                startRestartGroup.endReplaceGroup();
            }
            composer2 = startRestartGroup;
            SurfaceKt.m2570Surfaced85dljk(z, function0, semantics$default, z2, shape, m2465containerColorWaAFU9c$material3, 0L, 0.0f, shadowElevation$material3 != null ? shadowElevation$material3.getValue().m7569unboximpl() : Dp.m7555constructorimpl(0.0f), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-990050154, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C2019@99228L519:Chip.kt#uh7d8r");
                    if (composer3.shouldExecute((i7 & 3) != 2, i7 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-990050154, i7, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:2019)");
                        }
                        ChipKt.m1827AnimatingChipContentfe0OD_I(function2, textStyle, SelectableChipColors.this.m2467labelColorWaAFU9c$material3(z2, z), function22, function23, function24, SelectableChipColors.this.m2468leadingIconContentColorWaAFU9c$material3(z2, z), SelectableChipColors.this.m2469trailingIconContentColorWaAFU9c$material3(z2, z), f, paddingValues, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composer2, 54), composer2, (i6 & 14) | ((i6 >> 3) & 112) | (i6 & 7168) | ((i6 >> 15) & 57344) | ((i5 << 21) & 1879048192), 48, 192);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.SelectableChip_u0RnIRE$lambda$22(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit SelectableChip_u0RnIRE$lambda$21$lambda$20(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m6793setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m6776getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I  reason: not valid java name */
    public static final void m1829ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        long j4;
        Object obj;
        Object obj2;
        Object obj3;
        long j5;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(1105630840);
        ComposerKt.sourceInformation(startRestartGroup, "C(ChipContent)N(label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,avatar,trailingIcon,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,paddingValues)2056@100480L1721,2053@100353L1848:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            j4 = j;
            i2 |= startRestartGroup.changed(j4) ? 256 : 128;
        } else {
            j4 = j;
        }
        if ((i & 3072) == 0) {
            obj = function22;
            i2 |= startRestartGroup.changedInstance(obj) ? 2048 : 1024;
        } else {
            obj = function22;
        }
        if ((i & 24576) == 0) {
            obj2 = function23;
            i2 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
        } else {
            obj2 = function23;
        }
        if ((196608 & i) == 0) {
            obj3 = function24;
            i2 |= startRestartGroup.changedInstance(obj3) ? 131072 : 65536;
        } else {
            obj3 = function24;
        }
        if ((1572864 & i) == 0) {
            j5 = j2;
            i2 |= startRestartGroup.changed(j5) ? 1048576 : 524288;
        } else {
            j5 = j2;
        }
        if ((12582912 & i) == 0) {
            i3 = i2 | (startRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
        }
        if ((100663296 & i) == 0) {
            i3 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(paddingValues) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1105630840, i3, -1, "androidx.compose.material3.ChipContent (Chip.kt:2052)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function25 = obj;
            final Function2<? super Composer, ? super Integer, Unit> function26 = obj2;
            final Function2<? super Composer, ? super Integer, Unit> function27 = obj3;
            final long j6 = j5;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(j4)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.rememberComposableLambda(-2130105544, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    String str;
                    int i5;
                    Function2 m1835leadingContentXOJAsU;
                    float f2;
                    Function2 m1836trailingContentRPmYEkk;
                    ComposerKt.sourceInformation(composer2, "C2093@102146L38,2057@100490L1705:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2130105544, i4, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:2057)");
                    }
                    Modifier padding = PaddingKt.padding(SizeKt.m849defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, f, 1, null), paddingValues);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1668025758, "CC(remember):Chip.kt#9igjgp");
                    Object rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new ChipLayoutMeasurePolicy();
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    ChipLayoutMeasurePolicy chipLayoutMeasurePolicy = (ChipLayoutMeasurePolicy) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Function2<Composer, Integer, Unit> function28 = function26;
                    Function2<Composer, Integer, Unit> function29 = function25;
                    Function2<Composer, Integer, Unit> function210 = function27;
                    long j7 = j6;
                    Function2<Composer, Integer, Unit> function211 = function2;
                    long j8 = j3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, padding);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m4041constructorimpl = Updater.m4041constructorimpl(composer2);
                    Updater.m4049setimpl(m4041constructorimpl, chipLayoutMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -411001482, "C2073@101229L326:Chip.kt#uh7d8r");
                    if (function28 == null && function29 == null) {
                        composer2.startReplaceGroup(-410471693);
                        composer2.endReplaceGroup();
                        str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                        i5 = -692256719;
                    } else {
                        composer2.startReplaceGroup(-410987750);
                        ComposerKt.sourceInformation(composer2, "2061@100697L497");
                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "leadingIcon");
                        Alignment center = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, layoutId);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4041constructorimpl2 = Updater.m4041constructorimpl(composer2);
                        Updater.m4049setimpl(m4041constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1737582560, "C2066@100955L53:Chip.kt#uh7d8r");
                        str = "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh";
                        i5 = -692256719;
                        m1835leadingContentXOJAsU = ChipKt.m1835leadingContentXOJAsU(function28, function29, j7, composer2, 0);
                        if (m1835leadingContentXOJAsU != null) {
                            composer2.startReplaceGroup(-1737425918);
                            ComposerKt.sourceInformation(composer2, "2068@101099L16");
                            m1835leadingContentXOJAsU.invoke(composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-1737349038);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    }
                    Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, Constants.ScionAnalytics.PARAM_LABEL);
                    f2 = ChipKt.HorizontalElementsPadding;
                    Modifier m819paddingVpY3zN4 = PaddingKt.m819paddingVpY3zN4(layoutId2, f2, Dp.m7555constructorimpl(0.0f));
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m819paddingVpY3zN4);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, i5, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
                    Updater.m4049setimpl(m4041constructorimpl3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1437742697, "C2078@101527L7:Chip.kt#uh7d8r");
                    function211.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (function210 != null) {
                        composer2.startReplaceGroup(-410073157);
                        ComposerKt.sourceInformation(composer2, "2081@101620L464");
                        Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.Companion, "trailingIcon");
                        Alignment center2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, str);
                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, layoutId3);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1073567083, "C2085@101848L48:Chip.kt#uh7d8r");
                        m1836trailingContentRPmYEkk = ChipKt.m1836trailingContentRPmYEkk(function210, j8, composer2, 0);
                        if (m1836trailingContentRPmYEkk != null) {
                            composer2.startReplaceGroup(1073690090);
                            ComposerKt.sourceInformation(composer2, "2087@101988L17");
                            m1836trailingContentRPmYEkk.invoke(composer2, 0);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(1073767931);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-409588813);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final long j7 = j4;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return ChipKt.ChipContent_fe0OD_I$lambda$23(Function2.this, textStyle, j7, function22, function23, function24, j2, j3, f, paddingValues, i, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: AnimatingChipContent-fe0OD_I  reason: not valid java name */
    public static final void m1827AnimatingChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        long j4;
        Object obj;
        Object obj2;
        Object obj3;
        long j5;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-2070754602);
        ComposerKt.sourceInformation(startRestartGroup, "C(AnimatingChipContent)N(label,labelTextStyle,labelColor:c#ui.graphics.Color,leadingIcon,avatar,trailingIcon,leadingIconColor:c#ui.graphics.Color,trailingIconColor:c#ui.graphics.Color,minHeight:c#ui.unit.Dp,paddingValues)2118@102851L4086,2115@102724L4213:Chip.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            j4 = j;
            i2 |= startRestartGroup.changed(j4) ? 256 : 128;
        } else {
            j4 = j;
        }
        if ((i & 3072) == 0) {
            obj = function22;
            i2 |= startRestartGroup.changedInstance(obj) ? 2048 : 1024;
        } else {
            obj = function22;
        }
        if ((i & 24576) == 0) {
            obj2 = function23;
            i2 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
        } else {
            obj2 = function23;
        }
        if ((196608 & i) == 0) {
            obj3 = function24;
            i2 |= startRestartGroup.changedInstance(obj3) ? 131072 : 65536;
        } else {
            obj3 = function24;
        }
        if ((1572864 & i) == 0) {
            j5 = j2;
            i2 |= startRestartGroup.changed(j5) ? 1048576 : 524288;
        } else {
            j5 = j2;
        }
        if ((12582912 & i) == 0) {
            i3 = i2 | (startRestartGroup.changed(j3) ? 8388608 : 4194304);
        } else {
            i3 = i2;
        }
        if ((100663296 & i) == 0) {
            i3 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(paddingValues) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070754602, i3, -1, "androidx.compose.material3.AnimatingChipContent (Chip.kt:2114)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function25 = obj;
            final Function2<? super Composer, ? super Integer, Unit> function26 = obj2;
            final Function2<? super Composer, ? super Integer, Unit> function27 = obj3;
            final long j6 = j5;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(j4)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.rememberComposableLambda(-668234218, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    float f2;
                    ComposerKt.sourceInformation(composer2, "C2120@102988L14,2121@103063L14,2122@103137L16,2123@103216L16,2197@106882L38,2124@103241L3690:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i4 & 3) != 2, i4 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-668234218, i4, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous> (Chip.kt:2120)");
                    }
                    FiniteAnimationSpec value = MotionSchemeKt.value(MotionSchemeKeyTokens.SlowEffects, composer2, 6);
                    FiniteAnimationSpec value2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer2, 6);
                    FiniteAnimationSpec value3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composer2, 6);
                    FiniteAnimationSpec value4 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer2, 6);
                    Modifier padding = PaddingKt.padding(SizeKt.m849defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, f, 1, null), paddingValues);
                    ComposerKt.sourceInformationMarkerStart(composer2, 2072139932, "CC(remember):Chip.kt#9igjgp");
                    Object rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new ChipLayoutMeasurePolicy();
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    ChipLayoutMeasurePolicy chipLayoutMeasurePolicy = (ChipLayoutMeasurePolicy) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    final Function2<Composer, Integer, Unit> function28 = function26;
                    final Function2<Composer, Integer, Unit> function29 = function25;
                    final Function2<Composer, Integer, Unit> function210 = function27;
                    final long j7 = j6;
                    Function2<Composer, Integer, Unit> function211 = function2;
                    final long j8 = j3;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, padding);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m4041constructorimpl = Updater.m4041constructorimpl(composer2);
                    Updater.m4049setimpl(m4041constructorimpl, chipLayoutMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4041constructorimpl.getInserting() || !Intrinsics.areEqual(m4041constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4041constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4041constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m4049setimpl(m4041constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -564817408, "C2141@104124L826,2128@103442L1508,2158@104967L362,2179@106014L824,2168@105407L1431:Chip.kt#uh7d8r");
                    AnimatedVisibilityKt.AnimatedVisibility((function28 == null && function29 == null) ? false : true, LayoutIdKt.layoutId(Modifier.Companion, "leadingIcon"), EnterExitTransitionKt.expandHorizontally$default(value3, Alignment.Companion.getStart(), false, null, 12, null).plus(EnterExitTransitionKt.fadeIn$default(value, 0.0f, 2, null)), EnterExitTransitionKt.shrinkHorizontally$default(value4, Alignment.Companion.getStart(), false, null, 12, null).plus(EnterExitTransitionKt.fadeOut$default(value2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(687705959, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1$2$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i5) {
                            Function2 m1835leadingContentXOJAsU;
                            State rememberRetainedState;
                            ComposerKt.sourceInformation(composer3, "C2147@104553L53,2146@104488L144,2150@104654L278:Chip.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(687705959, i5, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous>.<anonymous>.<anonymous> (Chip.kt:2145)");
                            }
                            m1835leadingContentXOJAsU = ChipKt.m1835leadingContentXOJAsU(function28, function29, j7, composer3, 0);
                            rememberRetainedState = ChipKt.rememberRetainedState(m1835leadingContentXOJAsU, composer3, 0);
                            Alignment center = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, Modifier.Companion);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, -1538137033, "C:Chip.kt#uh7d8r");
                            Function2 function212 = (Function2) rememberRetainedState.getValue();
                            if (function212 == null) {
                                composer3.startReplaceGroup(-1538103400);
                            } else {
                                composer3.startReplaceGroup(-326710903);
                                ComposerKt.sourceInformation(composer3, "2154@104875L8");
                                function212.invoke(composer3, 0);
                            }
                            composer3.endReplaceGroup();
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
                    }, composer2, 54), composer2, 196656, 16);
                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, Constants.ScionAnalytics.PARAM_LABEL);
                    f2 = ChipKt.HorizontalElementsPadding;
                    Modifier m820paddingVpY3zN4$default = PaddingKt.m820paddingVpY3zN4$default(layoutId, f2, 0.0f, 2, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m820paddingVpY3zN4$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m4041constructorimpl2 = Updater.m4041constructorimpl(composer2);
                    Updater.m4049setimpl(m4041constructorimpl2, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4049setimpl(m4041constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4041constructorimpl2.getInserting() || !Intrinsics.areEqual(m4041constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m4041constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m4041constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m4049setimpl(m4041constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 75607137, "C2164@105301L7:Chip.kt#uh7d8r");
                    function211.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    AnimatedVisibilityKt.AnimatedVisibility(function210 != null, LayoutIdKt.layoutId(Modifier.Companion, "trailingIcon"), EnterExitTransitionKt.expandHorizontally$default(value3, Alignment.Companion.getEnd(), false, null, 12, null).plus(EnterExitTransitionKt.fadeIn$default(value, 0.0f, 2, null)), EnterExitTransitionKt.shrinkHorizontally$default(value4, Alignment.Companion.getEnd(), false, null, 12, null).plus(EnterExitTransitionKt.fadeOut$default(value2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(1905252304, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AnimatingChipContent$1$2$3
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i5) {
                            Function2 m1836trailingContentRPmYEkk;
                            State rememberRetainedState;
                            ComposerKt.sourceInformation(composer3, "C2185@106445L48,2184@106380L139,2188@106541L279:Chip.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1905252304, i5, -1, "androidx.compose.material3.AnimatingChipContent.<anonymous>.<anonymous>.<anonymous> (Chip.kt:2183)");
                            }
                            m1836trailingContentRPmYEkk = ChipKt.m1836trailingContentRPmYEkk(function210, j8, composer3, 0);
                            rememberRetainedState = ChipKt.rememberRetainedState(m1836trailingContentRPmYEkk, composer3, 0);
                            Alignment center = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer3, Modifier.Companion);
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor3);
                            } else {
                                composer3.useNode();
                            }
                            Composer m4041constructorimpl3 = Updater.m4041constructorimpl(composer3);
                            Updater.m4049setimpl(m4041constructorimpl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4049setimpl(m4041constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4041constructorimpl3.getInserting() || !Intrinsics.areEqual(m4041constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                m4041constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                m4041constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m4049setimpl(m4041constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -2101817907, "C:Chip.kt#uh7d8r");
                            Function2 function212 = (Function2) rememberRetainedState.getValue();
                            if (function212 == null) {
                                composer3.startReplaceGroup(-2101783313);
                            } else {
                                composer3.startReplaceGroup(-344894126);
                                ComposerKt.sourceInformation(composer3, "2192@106763L8");
                                function212.invoke(composer3, 0);
                            }
                            composer3.endReplaceGroup();
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
                    }, composer2, 54), composer2, 196656, 16);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final long j7 = j4;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ChipKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    return ChipKt.AnimatingChipContent_fe0OD_I$lambda$24(Function2.this, textStyle, j7, function22, function23, function24, j2, j3, f, paddingValues, i, (Composer) obj4, ((Integer) obj5).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: leadingContent-XO-JAsU  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m1835leadingContentXOJAsU(Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final long j, Composer composer, int i) {
        Function2 function23;
        ComposerKt.sourceInformationMarkerStart(composer, 1330309098, "C(leadingContent)N(avatar,leadingIcon,leadingIconColor:c#ui.graphics.Color):Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1330309098, i, -1, "androidx.compose.material3.leadingContent (Chip.kt:2212)");
        }
        if (function2 != null) {
            composer.startReplaceGroup(-1473203984);
            composer.endReplaceGroup();
            function23 = function2;
        } else if (function22 != null) {
            composer.startReplaceGroup(1575390813);
            ComposerKt.sourceInformation(composer, "2215@107394L183");
            composer.endReplaceGroup();
            function23 = ComposableLambdaKt.rememberComposableLambda(-237350650, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$leadingContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C2216@107412L151:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-237350650, i2, -1, "androidx.compose.material3.leadingContent.<anonymous> (Chip.kt:2216)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(j)), function22, composer2, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
        } else {
            composer.startReplaceGroup(1575618259);
            composer.endReplaceGroup();
            function23 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function23;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: trailingContent-RPmYEkk  reason: not valid java name */
    public static final Function2<Composer, Integer, Unit> m1836trailingContentRPmYEkk(final Function2<? super Composer, ? super Integer, Unit> function2, final long j, Composer composer, int i) {
        ComposableLambda composableLambda;
        ComposerKt.sourceInformationMarkerStart(composer, -165980551, "C(trailingContent)N(trailingIcon,trailingIconColor:c#ui.graphics.Color):Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-165980551, i, -1, "androidx.compose.material3.trailingContent (Chip.kt:2231)");
        }
        if (function2 != null) {
            composer.startReplaceGroup(-1219055576);
            ComposerKt.sourceInformation(composer, "2232@107914L165");
            composableLambda = ComposableLambdaKt.rememberComposableLambda(-566924201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$trailingContent$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    ComposerKt.sourceInformation(composer2, "C2233@107928L141:Chip.kt#uh7d8r");
                    if (!composer2.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-566924201, i2, -1, "androidx.compose.material3.trailingContent.<anonymous> (Chip.kt:2233)");
                    }
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4762boximpl(j)), function2, composer2, ProvidedValue.$stable);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1218863531);
            composer.endReplaceGroup();
            composableLambda = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return composableLambda;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> State<T> rememberRetainedState(T t, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -618198444, "C(rememberRetainedState)N(targetValue)2249@108434L40:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-618198444, i, -1, "androidx.compose.material3.rememberRetainedState (Chip.kt:2248)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1383214468, "CC(remember):Chip.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (t != null) {
            mutableState.setValue(t);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mutableState;
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme colorScheme) {
        ChipColors defaultSuggestionChipColorsCached$material3 = colorScheme.getDefaultSuggestionChipColorsCached$material3();
        if (defaultSuggestionChipColorsCached$material3 == null) {
            ChipColors chipColors = new ChipColors(Color.Companion.m4807getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.Companion.m4808getUnspecified0d7_KjU(), Color.Companion.m4807getTransparent0d7_KjU(), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m4771copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), SuggestionChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.Companion.m4808getUnspecified0d7_KjU(), null);
            colorScheme.setDefaultSuggestionChipColorsCached$material3(chipColors);
            return chipColors;
        }
        return defaultSuggestionChipColorsCached$material3;
    }

    static /* synthetic */ PaddingValues inputChipPadding$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return inputChipPadding(z, z2, z3);
    }

    private static final PaddingValues inputChipPadding(boolean z, boolean z2, boolean z3) {
        return PaddingKt.m815PaddingValuesa9UjIt4$default((z || !z2) ? Dp.m7555constructorimpl(4.0f) : Dp.m7555constructorimpl(8.0f), 0.0f, z3 ? Dp.m7555constructorimpl(8.0f) : Dp.m7555constructorimpl(4.0f), 0.0f, 10, null);
    }

    static {
        float m7555constructorimpl = Dp.m7555constructorimpl(8.0f);
        HorizontalElementsPadding = m7555constructorimpl;
        AssistChipPadding = PaddingKt.m813PaddingValuesYgX7TsA$default(m7555constructorimpl, 0.0f, 2, null);
        FilterChipPadding = PaddingKt.m813PaddingValuesYgX7TsA$default(m7555constructorimpl, 0.0f, 2, null);
        SuggestionChipPadding = PaddingKt.m813PaddingValuesYgX7TsA$default(m7555constructorimpl, 0.0f, 2, null);
    }
}
