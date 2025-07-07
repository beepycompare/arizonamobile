package androidx.compose.material3;

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
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a¨\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a»\u0001\u0010(\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010$H\u0003ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a\u0094\u0001\u00101\u001a\u00020\u00112\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a¨\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010%\u001a¦\u0001\u00107\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010'\u001a°\u0001\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010<\u001a\u0091\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010?\u001a\u008f\u0001\u0010=\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a°\u0001\u0010A\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010<\u001aÇ\u0001\u0010B\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020:2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010C\u001aÐ\u0001\u0010D\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\u0006\u0010)\u001a\u00020*2\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020:2\b\u0010\u001f\u001a\u0004\u0018\u00010;2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010$H\u0003ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u0091\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0002\u0010?\u001a\u008f\u0001\u0010G\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010@\u001a&\u0010H\u001a\u00020\u00012\b\b\u0002\u0010I\u001a\u00020\u00192\b\b\u0002\u0010J\u001a\u00020\u00192\b\b\u0002\u0010K\u001a\u00020\u0019H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"AssistChipPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "FilterChipPadding", "HorizontalElementsPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LabelLayoutId", "", "LeadingIconLayoutId", "SuggestionChipPadding", "TrailingIconLayoutId", "defaultSuggestionChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "AssistChip", "", "onClick", "Lkotlin/Function0;", "label", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", ChipKt.LeadingIconLayoutId, ChipKt.TrailingIconLayoutId, "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "elevation", "Landroidx/compose/material3/ChipElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "paddingValues", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "avatar", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "ElevatedAssistChip", "ElevatedFilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedSuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "InputChip", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SuggestionChip", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final PaddingValues AssistChipPadding;
    private static final PaddingValues FilterChipPadding;
    private static final float HorizontalElementsPadding;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding;
    private static final String TrailingIconLayoutId = "trailingIcon";

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
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
        Object obj4;
        Shape shape2;
        int i11;
        Object obj5;
        int i12;
        int i13;
        ChipElevation chipElevation2;
        boolean z3;
        BorderStroke borderStroke2;
        int i14;
        MutableInteractionSource mutableInteractionSource2;
        BorderStroke borderStroke3;
        int i15;
        Shape shape3;
        ChipElevation chipElevation3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Shape shape4;
        final ChipColors chipColors3;
        final ChipElevation chipElevation4;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(313450168);
        ComposerKt.sourceInformation(startRestartGroup, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)126@6277L5,127@6328L18,128@6399L21,129@6469L25,137@6729L5,132@6561L541:Chip.kt#uh7d8r");
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
                        if ((i3 & 512) == 0 && startRestartGroup.changed(borderStroke)) {
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
                    int i20 = i4;
                    if ((i4 & 306783379) != 306783378 && (i10 & 3) == 2 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        function26 = function23;
                        chipElevation4 = chipElevation;
                        mutableInteractionSource3 = mutableInteractionSource;
                        z4 = z2;
                        composer2 = startRestartGroup;
                        shape4 = shape;
                        chipColors3 = chipColors2;
                        modifier3 = obj2;
                        function25 = obj3;
                        borderStroke4 = borderStroke;
                    } else {
                        startRestartGroup.startDefaults();
                        int i21 = i10;
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i19 == 0 ? Modifier.Companion : obj2;
                            boolean z5 = i5 == 0 ? true : z2;
                            obj4 = i6 == 0 ? null : obj3;
                            Function2<? super Composer, ? super Integer, Unit> function27 = i7 == 0 ? null : function23;
                            if ((i3 & 64) == 0) {
                                i11 = i20 & (-3670017);
                                shape2 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape2 = shape;
                                i11 = i20;
                            }
                            if ((i3 & 128) != 0) {
                                chipColors2 = AssistChipDefaults.INSTANCE.assistChipColors(startRestartGroup, 6);
                                i11 &= -29360129;
                            }
                            ChipColors chipColors4 = chipColors2;
                            int i22 = i11;
                            if ((i3 & 256) == 0) {
                                obj5 = companion;
                                i13 = i21;
                                i12 = 6;
                                i22 &= -234881025;
                                chipElevation2 = AssistChipDefaults.INSTANCE.m1587assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            } else {
                                obj5 = companion;
                                i12 = 6;
                                i13 = i21;
                                chipElevation2 = chipElevation;
                            }
                            if ((i3 & 512) == 0) {
                                z3 = z5;
                                borderStroke2 = AssistChipDefaults.INSTANCE.m1585assistChipBorderh1eTWw(z3, 0L, 0L, 0.0f, startRestartGroup, ((i22 >> 9) & 14) | 24576, 14);
                                i14 = i22 & (-1879048193);
                            } else {
                                z3 = z5;
                                borderStroke2 = borderStroke;
                                i14 = i22;
                            }
                            if (i9 == 0) {
                                borderStroke3 = borderStroke2;
                                i15 = i14;
                                shape3 = shape2;
                                chipElevation3 = chipElevation2;
                                mutableInteractionSource2 = null;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                borderStroke3 = borderStroke2;
                                i15 = i14;
                                shape3 = shape2;
                                chipElevation3 = chipElevation2;
                            }
                            chipColors2 = chipColors4;
                            function24 = function27;
                            modifier2 = obj5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            int i23 = (i3 & 64) != 0 ? i20 & (-3670017) : i20;
                            if ((i3 & 128) != 0) {
                                i23 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i23 &= -234881025;
                            }
                            if ((i3 & 512) != 0) {
                                i23 &= -1879048193;
                            }
                            function24 = function23;
                            shape3 = shape;
                            chipElevation3 = chipElevation;
                            borderStroke3 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i15 = i23;
                            i12 = 6;
                            modifier2 = obj2;
                            z3 = z2;
                            obj4 = obj3;
                            i13 = i21;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(313450168, i15, i13, "androidx.compose.material3.AssistChip (Chip.kt:132)");
                        }
                        int i24 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896);
                        int i25 = i15 << 6;
                        int i26 = i15 >> 24;
                        boolean z6 = z3;
                        ChipColors chipColors5 = chipColors2;
                        m1677ChipnkUnTEs(modifier2, function0, z6, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), obj4, function24, shape3, chipColors5, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i24 | (i25 & 7168) | (3670016 & i25) | (29360128 & i25) | (234881024 & i25) | (i25 & 1879048192), (i26 & 112) | (i26 & 14) | 3456 | ((i13 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = startRestartGroup;
                        modifier3 = modifier2;
                        z4 = z6;
                        function25 = obj4;
                        function26 = function24;
                        shape4 = shape3;
                        chipColors3 = chipColors5;
                        chipElevation4 = chipElevation3;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AssistChip$1
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

                            public final void invoke(Composer composer3, int i27) {
                                ChipKt.AssistChip(function0, function2, modifier3, z4, function25, function26, shape4, chipColors3, chipElevation4, borderStroke4, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
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
                int i202 = i4;
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                int i212 = i10;
                if ((i & 1) != 0) {
                }
                if (i19 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & 128) != 0) {
                }
                ChipColors chipColors42 = chipColors2;
                int i222 = i11;
                if ((i3 & 256) == 0) {
                }
                if ((i3 & 512) == 0) {
                }
                if (i9 == 0) {
                }
                chipColors2 = chipColors42;
                function24 = function27;
                modifier2 = obj5;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i242 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896);
                int i252 = i15 << 6;
                int i262 = i15 >> 24;
                boolean z62 = z3;
                ChipColors chipColors52 = chipColors2;
                m1677ChipnkUnTEs(modifier2, function0, z62, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), obj4, function24, shape3, chipColors52, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i242 | (i252 & 7168) | (3670016 & i252) | (29360128 & i252) | (234881024 & i252) | (i252 & 1879048192), (i262 & 112) | (i262 & 14) | 3456 | ((i13 << 12) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier3 = modifier2;
                z4 = z62;
                function25 = obj4;
                function26 = function24;
                shape4 = shape3;
                chipColors3 = chipColors52;
                chipElevation4 = chipElevation3;
                borderStroke4 = borderStroke3;
                mutableInteractionSource3 = mutableInteractionSource2;
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
            int i2022 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            int i2122 = i10;
            if ((i & 1) != 0) {
            }
            if (i19 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & 128) != 0) {
            }
            ChipColors chipColors422 = chipColors2;
            int i2222 = i11;
            if ((i3 & 256) == 0) {
            }
            if ((i3 & 512) == 0) {
            }
            if (i9 == 0) {
            }
            chipColors2 = chipColors422;
            function24 = function27;
            modifier2 = obj5;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i2422 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896);
            int i2522 = i15 << 6;
            int i2622 = i15 >> 24;
            boolean z622 = z3;
            ChipColors chipColors522 = chipColors2;
            m1677ChipnkUnTEs(modifier2, function0, z622, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), obj4, function24, shape3, chipColors522, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i2422 | (i2522 & 7168) | (3670016 & i2522) | (29360128 & i2522) | (234881024 & i2522) | (i2522 & 1879048192), (i2622 & 112) | (i2622 & 14) | 3456 | ((i13 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier3 = modifier2;
            z4 = z622;
            function25 = obj4;
            function26 = function24;
            shape4 = shape3;
            chipColors3 = chipColors522;
            chipElevation4 = chipElevation3;
            borderStroke4 = borderStroke3;
            mutableInteractionSource3 = mutableInteractionSource2;
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
        int i20222 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        int i21222 = i10;
        if ((i & 1) != 0) {
        }
        if (i19 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & 128) != 0) {
        }
        ChipColors chipColors4222 = chipColors2;
        int i22222 = i11;
        if ((i3 & 256) == 0) {
        }
        if ((i3 & 512) == 0) {
        }
        if (i9 == 0) {
        }
        chipColors2 = chipColors4222;
        function24 = function27;
        modifier2 = obj5;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i24222 = ((i15 >> 6) & 14) | ((i15 << 3) & 112) | ((i15 >> 3) & 896);
        int i25222 = i15 << 6;
        int i26222 = i15 >> 24;
        boolean z6222 = z3;
        ChipColors chipColors5222 = chipColors2;
        m1677ChipnkUnTEs(modifier2, function0, z6222, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), obj4, function24, shape3, chipColors5222, chipElevation3, borderStroke3, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, i24222 | (i25222 & 7168) | (3670016 & i25222) | (29360128 & i25222) | (234881024 & i25222) | (i25222 & 1879048192), (i26222 & 112) | (i26222 & 14) | 3456 | ((i13 << 12) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier3 = modifier2;
        z4 = z6222;
        function25 = obj4;
        function26 = function24;
        shape4 = shape3;
        chipColors3 = chipColors5222;
        chipElevation4 = chipElevation3;
        borderStroke4 = borderStroke3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
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
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Object obj2;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        Object obj3;
        Shape shape2;
        int i11;
        Modifier modifier3;
        int i12;
        Composer composer2;
        int i13;
        ChipElevation chipElevation2;
        ChipBorder chipBorder2;
        int i14;
        MutableInteractionSource mutableInteractionSource2;
        ChipElevation chipElevation3;
        Shape shape3;
        Function2 function24;
        Modifier modifier4;
        Composer composer3;
        final ChipBorder chipBorder3;
        final Modifier modifier5;
        final boolean z3;
        final Function2 function25;
        final Function2 function26;
        final Shape shape4;
        final ChipColors chipColors3;
        final ChipElevation chipElevation4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i15;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-1932300596);
        ComposerKt.sourceInformation(startRestartGroup, "C(AssistChip)P(8,5,7,3,6,10,9,1,2)213@10395L5,214@10446L18,215@10517L21,216@10585L18,217@10655L39,224@10872L5,219@10704L571:Chip.kt#uh7d8r");
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
        int i18 = i3 & 4;
        if (i18 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 256 : 128;
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
                    obj2 = function22;
                    i4 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
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
                                i17 = 8388608;
                                i4 |= i17;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i17 = 4194304;
                        i4 |= i17;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i3 & 256) == 0 && startRestartGroup.changed(chipElevation)) {
                            i16 = 67108864;
                            i4 |= i16;
                        }
                        i16 = 33554432;
                        i4 |= i16;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & 512) == 0 && startRestartGroup.changed(chipBorder)) {
                            i15 = C.BUFFER_FLAG_LAST_SAMPLE;
                            i4 |= i15;
                        }
                        i15 = 268435456;
                        i4 |= i15;
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
                    int i19 = i4;
                    if ((i4 & 306783379) != 306783378 && (i10 & 3) == 2 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        function26 = function23;
                        chipElevation4 = chipElevation;
                        mutableInteractionSource3 = mutableInteractionSource;
                        composer3 = startRestartGroup;
                        z3 = z2;
                        shape4 = shape;
                        chipColors3 = chipColors2;
                        modifier5 = modifier2;
                        function25 = obj2;
                        chipBorder3 = chipBorder;
                    } else {
                        startRestartGroup.startDefaults();
                        int i20 = i10;
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i18 == 0 ? Modifier.Companion : modifier2;
                            boolean z4 = i5 == 0 ? true : z2;
                            obj3 = i6 == 0 ? null : obj2;
                            Function2 function27 = i7 == 0 ? null : function23;
                            if ((i3 & 64) == 0) {
                                i11 = i19 & (-3670017);
                                shape2 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape2 = shape;
                                i11 = i19;
                            }
                            if ((i3 & 128) != 0) {
                                chipColors2 = AssistChipDefaults.INSTANCE.assistChipColors(startRestartGroup, 6);
                                i11 &= -29360129;
                            }
                            ChipColors chipColors4 = chipColors2;
                            int i21 = i11;
                            if ((i3 & 256) == 0) {
                                composer2 = startRestartGroup;
                                modifier3 = companion;
                                i12 = 6;
                                i13 = i20;
                                i21 &= -234881025;
                                chipElevation2 = AssistChipDefaults.INSTANCE.m1587assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                            } else {
                                modifier3 = companion;
                                i12 = 6;
                                composer2 = startRestartGroup;
                                i13 = i20;
                                chipElevation2 = chipElevation;
                            }
                            if ((i3 & 512) == 0) {
                                startRestartGroup = composer2;
                                chipBorder2 = AssistChipDefaults.INSTANCE.m1584assistChipBorderd_3_b6Q(0L, 0L, 0.0f, startRestartGroup, 3072, 7);
                                i14 = i21 & (-1879048193);
                            } else {
                                startRestartGroup = composer2;
                                chipBorder2 = chipBorder;
                                i14 = i21;
                            }
                            if (i9 == 0) {
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 267303551, "CC(remember):Chip.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            chipElevation3 = chipElevation2;
                            shape3 = shape2;
                            z2 = z4;
                            chipColors2 = chipColors4;
                            function24 = function27;
                            modifier4 = modifier3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            int i22 = (i3 & 64) != 0 ? i19 & (-3670017) : i19;
                            if ((i3 & 128) != 0) {
                                i22 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i22 &= -234881025;
                            }
                            if ((i3 & 512) != 0) {
                                i22 &= -1879048193;
                            }
                            function24 = function23;
                            shape3 = shape;
                            chipElevation3 = chipElevation;
                            chipBorder2 = chipBorder;
                            mutableInteractionSource2 = mutableInteractionSource;
                            i12 = 6;
                            modifier4 = modifier2;
                            obj3 = obj2;
                            i14 = i22;
                            i13 = i20;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1932300596, i14, i13, "androidx.compose.material3.AssistChip (Chip.kt:219)");
                        }
                        TextStyle value = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
                        long m1668labelColorvNxB06k$material3_release = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
                        startRestartGroup.startReplaceGroup(267317901);
                        ComposerKt.sourceInformation(startRestartGroup, "231@11104L21");
                        State<BorderStroke> borderStroke$material3_release = chipBorder2 != null ? null : chipBorder2.borderStroke$material3_release(z2, startRestartGroup, ((i14 >> 9) & 14) | ((i14 >> 24) & 112));
                        startRestartGroup.endReplaceGroup();
                        int i23 = i14 << 6;
                        ChipColors chipColors5 = chipColors2;
                        composer3 = startRestartGroup;
                        boolean z5 = z2;
                        m1677ChipnkUnTEs(modifier4, function0, z5, obj, value, m1668labelColorvNxB06k$material3_release, obj3, function24, shape3, chipColors5, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, composer3, ((i14 >> 6) & 14) | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i23 & 7168) | (3670016 & i23) | (29360128 & i23) | (234881024 & i23) | (i23 & 1879048192), ((i14 >> 24) & 14) | 3456 | ((i13 << 12) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipBorder3 = chipBorder2;
                        modifier5 = modifier4;
                        z3 = z5;
                        function25 = obj3;
                        function26 = function24;
                        shape4 = shape3;
                        chipColors3 = chipColors5;
                        chipElevation4 = chipElevation3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$AssistChip$3
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

                            public final void invoke(Composer composer4, int i24) {
                                ChipKt.AssistChip(function0, function2, modifier5, z3, function25, function26, shape4, chipColors3, chipElevation4, chipBorder3, mutableInteractionSource3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                obj2 = function22;
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
                int i192 = i4;
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                int i202 = i10;
                if ((i & 1) != 0) {
                }
                if (i18 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & 128) != 0) {
                }
                ChipColors chipColors42 = chipColors2;
                int i212 = i11;
                if ((i3 & 256) == 0) {
                }
                if ((i3 & 512) == 0) {
                }
                if (i9 == 0) {
                }
                chipElevation3 = chipElevation2;
                shape3 = shape2;
                z2 = z4;
                chipColors2 = chipColors42;
                function24 = function27;
                modifier4 = modifier3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle value2 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
                long m1668labelColorvNxB06k$material3_release2 = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
                startRestartGroup.startReplaceGroup(267317901);
                ComposerKt.sourceInformation(startRestartGroup, "231@11104L21");
                if (chipBorder2 != null) {
                }
                startRestartGroup.endReplaceGroup();
                if (borderStroke$material3_release != null) {
                }
                int i232 = i14 << 6;
                ChipColors chipColors52 = chipColors2;
                composer3 = startRestartGroup;
                boolean z52 = z2;
                m1677ChipnkUnTEs(modifier4, function0, z52, obj, value2, m1668labelColorvNxB06k$material3_release2, obj3, function24, shape3, chipColors52, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, composer3, ((i14 >> 6) & 14) | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i232 & 7168) | (3670016 & i232) | (29360128 & i232) | (234881024 & i232) | (i232 & 1879048192), ((i14 >> 24) & 14) | 3456 | ((i13 << 12) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                chipBorder3 = chipBorder2;
                modifier5 = modifier4;
                z3 = z52;
                function25 = obj3;
                function26 = function24;
                shape4 = shape3;
                chipColors3 = chipColors52;
                chipElevation4 = chipElevation3;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj2 = function22;
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
            int i1922 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            int i2022 = i10;
            if ((i & 1) != 0) {
            }
            if (i18 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & 128) != 0) {
            }
            ChipColors chipColors422 = chipColors2;
            int i2122 = i11;
            if ((i3 & 256) == 0) {
            }
            if ((i3 & 512) == 0) {
            }
            if (i9 == 0) {
            }
            chipElevation3 = chipElevation2;
            shape3 = shape2;
            z2 = z4;
            chipColors2 = chipColors422;
            function24 = function27;
            modifier4 = modifier3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle value22 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
            long m1668labelColorvNxB06k$material3_release22 = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
            startRestartGroup.startReplaceGroup(267317901);
            ComposerKt.sourceInformation(startRestartGroup, "231@11104L21");
            if (chipBorder2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            if (borderStroke$material3_release != null) {
            }
            int i2322 = i14 << 6;
            ChipColors chipColors522 = chipColors2;
            composer3 = startRestartGroup;
            boolean z522 = z2;
            m1677ChipnkUnTEs(modifier4, function0, z522, obj, value22, m1668labelColorvNxB06k$material3_release22, obj3, function24, shape3, chipColors522, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, composer3, ((i14 >> 6) & 14) | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i2322 & 7168) | (3670016 & i2322) | (29360128 & i2322) | (234881024 & i2322) | (i2322 & 1879048192), ((i14 >> 24) & 14) | 3456 | ((i13 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            chipBorder3 = chipBorder2;
            modifier5 = modifier4;
            z3 = z522;
            function25 = obj3;
            function26 = function24;
            shape4 = shape3;
            chipColors3 = chipColors522;
            chipElevation4 = chipElevation3;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj2 = function22;
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
        int i19222 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        int i20222 = i10;
        if ((i & 1) != 0) {
        }
        if (i18 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & 128) != 0) {
        }
        ChipColors chipColors4222 = chipColors2;
        int i21222 = i11;
        if ((i3 & 256) == 0) {
        }
        if ((i3 & 512) == 0) {
        }
        if (i9 == 0) {
        }
        chipElevation3 = chipElevation2;
        shape3 = shape2;
        z2 = z4;
        chipColors2 = chipColors4222;
        function24 = function27;
        modifier4 = modifier3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle value222 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
        long m1668labelColorvNxB06k$material3_release222 = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
        startRestartGroup.startReplaceGroup(267317901);
        ComposerKt.sourceInformation(startRestartGroup, "231@11104L21");
        if (chipBorder2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        if (borderStroke$material3_release != null) {
        }
        int i23222 = i14 << 6;
        ChipColors chipColors5222 = chipColors2;
        composer3 = startRestartGroup;
        boolean z5222 = z2;
        m1677ChipnkUnTEs(modifier4, function0, z5222, obj, value222, m1668labelColorvNxB06k$material3_release222, obj3, function24, shape3, chipColors5222, chipElevation3, borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, composer3, ((i14 >> 6) & 14) | ((i14 << 3) & 112) | ((i14 >> 3) & 896) | (i23222 & 7168) | (3670016 & i23222) | (29360128 & i23222) | (234881024 & i23222) | (i23222 & 1879048192), ((i14 >> 24) & 14) | 3456 | ((i13 << 12) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        chipBorder3 = chipBorder2;
        modifier5 = modifier4;
        z3 = z5222;
        function25 = obj3;
        function26 = function24;
        shape4 = shape3;
        chipColors3 = chipColors5222;
        chipElevation4 = chipElevation3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
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
        Shape shape2;
        int i13;
        Object obj4;
        int i14;
        int i15;
        ChipElevation chipElevation2;
        int i16;
        MutableInteractionSource mutableInteractionSource2;
        ChipElevation chipElevation3;
        BorderStroke borderStroke2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Modifier modifier2;
        Shape shape3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape4;
        final ChipColors chipColors3;
        final ChipElevation chipElevation4;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(1594789934);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)289@14186L5,290@14237L26,291@14316L29,300@14613L5,295@14445L541:Chip.kt#uh7d8r");
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
                        int i20 = i4;
                        if ((i4 & 306783379) != 306783378 && (i12 & 3) == 2 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            function27 = function23;
                            chipElevation4 = chipElevation;
                            mutableInteractionSource3 = mutableInteractionSource;
                            z3 = z2;
                            composer2 = startRestartGroup;
                            shape4 = shape;
                            chipColors3 = chipColors2;
                            modifier3 = obj2;
                            function26 = obj3;
                            borderStroke3 = borderStroke;
                        } else {
                            startRestartGroup.startDefaults();
                            int i21 = i12;
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i19 != 0 ? Modifier.Companion : obj2;
                                boolean z4 = i5 != 0 ? true : z2;
                                Object obj5 = i6 != 0 ? null : obj3;
                                Function2<? super Composer, ? super Integer, Unit> function28 = i7 != 0 ? null : function23;
                                if ((i3 & 64) != 0) {
                                    i13 = i20 & (-3670017);
                                    shape2 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape2 = shape;
                                    i13 = i20;
                                }
                                if ((i3 & 128) != 0) {
                                    chipColors2 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(startRestartGroup, 6);
                                    i13 &= -29360129;
                                }
                                ChipColors chipColors4 = chipColors2;
                                int i22 = i13;
                                if ((i3 & 256) != 0) {
                                    obj4 = companion;
                                    i15 = i21;
                                    i14 = 6;
                                    chipElevation2 = AssistChipDefaults.INSTANCE.m1589elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    i16 = i22 & (-234881025);
                                } else {
                                    obj4 = companion;
                                    i14 = 6;
                                    i15 = i21;
                                    chipElevation2 = chipElevation;
                                    i16 = i22;
                                }
                                BorderStroke borderStroke4 = i9 != 0 ? null : borderStroke;
                                if (i11 != 0) {
                                    chipElevation3 = chipElevation2;
                                    borderStroke2 = borderStroke4;
                                    z2 = z4;
                                    mutableInteractionSource2 = null;
                                    function25 = obj5;
                                    chipColors2 = chipColors4;
                                    function24 = function28;
                                    shape3 = shape2;
                                    modifier2 = obj4;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    chipElevation3 = chipElevation2;
                                    borderStroke2 = borderStroke4;
                                    function24 = function28;
                                    z2 = z4;
                                    function25 = obj5;
                                    chipColors2 = chipColors4;
                                    modifier2 = obj4;
                                    shape3 = shape2;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                int i23 = (i3 & 64) != 0 ? i20 & (-3670017) : i20;
                                if ((i3 & 128) != 0) {
                                    i23 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i23 &= -234881025;
                                }
                                function24 = function23;
                                shape3 = shape;
                                chipElevation3 = chipElevation;
                                borderStroke2 = borderStroke;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i14 = 6;
                                modifier2 = obj2;
                                function25 = obj3;
                                i16 = i23;
                                i15 = i21;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1594789934, i16, i15, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:295)");
                            }
                            int i24 = i16 << 6;
                            int i25 = i16 >> 24;
                            ChipColors chipColors5 = chipColors2;
                            boolean z5 = z2;
                            m1677ChipnkUnTEs(modifier2, function0, z5, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), chipColors2.m1668labelColorvNxB06k$material3_release(z2), function25, function24, shape3, chipColors5, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i24 & 7168) | (3670016 & i24) | (29360128 & i24) | (234881024 & i24) | (i24 & 1879048192), (i25 & 112) | (i25 & 14) | 3456 | ((i15 << 12) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            z3 = z5;
                            function26 = function25;
                            function27 = function24;
                            shape4 = shape3;
                            chipColors3 = chipColors5;
                            chipElevation4 = chipElevation3;
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedAssistChip$1
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

                                public final void invoke(Composer composer3, int i26) {
                                    ChipKt.ElevatedAssistChip(function0, function2, modifier3, z3, function26, function27, shape4, chipColors3, chipElevation4, borderStroke3, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
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
                    int i202 = i4;
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    int i212 = i12;
                    if ((i & 1) != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    ChipColors chipColors42 = chipColors2;
                    int i222 = i13;
                    if ((i3 & 256) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i242 = i16 << 6;
                    int i252 = i16 >> 24;
                    ChipColors chipColors52 = chipColors2;
                    boolean z52 = z2;
                    m1677ChipnkUnTEs(modifier2, function0, z52, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), chipColors2.m1668labelColorvNxB06k$material3_release(z2), function25, function24, shape3, chipColors52, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i242 & 7168) | (3670016 & i242) | (29360128 & i242) | (234881024 & i242) | (i242 & 1879048192), (i252 & 112) | (i252 & 14) | 3456 | ((i15 << 12) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    z3 = z52;
                    function26 = function25;
                    function27 = function24;
                    shape4 = shape3;
                    chipColors3 = chipColors52;
                    chipElevation4 = chipElevation3;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource3 = mutableInteractionSource2;
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
                int i2022 = i4;
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                int i2122 = i12;
                if ((i & 1) != 0) {
                }
                if (i19 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                ChipColors chipColors422 = chipColors2;
                int i2222 = i13;
                if ((i3 & 256) != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i2422 = i16 << 6;
                int i2522 = i16 >> 24;
                ChipColors chipColors522 = chipColors2;
                boolean z522 = z2;
                m1677ChipnkUnTEs(modifier2, function0, z522, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), chipColors2.m1668labelColorvNxB06k$material3_release(z2), function25, function24, shape3, chipColors522, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i2422 & 7168) | (3670016 & i2422) | (29360128 & i2422) | (234881024 & i2422) | (i2422 & 1879048192), (i2522 & 112) | (i2522 & 14) | 3456 | ((i15 << 12) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier3 = modifier2;
                z3 = z522;
                function26 = function25;
                function27 = function24;
                shape4 = shape3;
                chipColors3 = chipColors522;
                chipElevation4 = chipElevation3;
                borderStroke3 = borderStroke2;
                mutableInteractionSource3 = mutableInteractionSource2;
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
            int i20222 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            int i21222 = i12;
            if ((i & 1) != 0) {
            }
            if (i19 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            ChipColors chipColors4222 = chipColors2;
            int i22222 = i13;
            if ((i3 & 256) != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i24222 = i16 << 6;
            int i25222 = i16 >> 24;
            ChipColors chipColors5222 = chipColors2;
            boolean z5222 = z2;
            m1677ChipnkUnTEs(modifier2, function0, z5222, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), chipColors2.m1668labelColorvNxB06k$material3_release(z2), function25, function24, shape3, chipColors5222, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i24222 & 7168) | (3670016 & i24222) | (29360128 & i24222) | (234881024 & i24222) | (i24222 & 1879048192), (i25222 & 112) | (i25222 & 14) | 3456 | ((i15 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier3 = modifier2;
            z3 = z5222;
            function26 = function25;
            function27 = function24;
            shape4 = shape3;
            chipColors3 = chipColors5222;
            chipElevation4 = chipElevation3;
            borderStroke3 = borderStroke2;
            mutableInteractionSource3 = mutableInteractionSource2;
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
        int i202222 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        int i212222 = i12;
        if ((i & 1) != 0) {
        }
        if (i19 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        ChipColors chipColors42222 = chipColors2;
        int i222222 = i13;
        if ((i3 & 256) != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i242222 = i16 << 6;
        int i252222 = i16 >> 24;
        ChipColors chipColors52222 = chipColors2;
        boolean z52222 = z2;
        m1677ChipnkUnTEs(modifier2, function0, z52222, obj, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), chipColors2.m1668labelColorvNxB06k$material3_release(z2), function25, function24, shape3, chipColors52222, chipElevation3, borderStroke2, AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM(), AssistChipPadding, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i242222 & 7168) | (3670016 & i242222) | (29360128 & i242222) | (234881024 & i242222) | (i242222 & 1879048192), (i252222 & 112) | (i252222 & 14) | 3456 | ((i15 << 12) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier3 = modifier2;
        z3 = z52222;
        function26 = function25;
        function27 = function24;
        shape4 = shape3;
        chipColors3 = chipColors52222;
        chipElevation4 = chipElevation3;
        borderStroke3 = borderStroke2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
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
        Modifier modifier2;
        int i5;
        boolean z2;
        int i6;
        Object obj2;
        int i7;
        ChipColors chipColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Shape shape2;
        int i13;
        Modifier modifier3;
        int i14;
        int i15;
        ChipElevation chipElevation2;
        int i16;
        MutableInteractionSource mutableInteractionSource2;
        ChipElevation chipElevation3;
        ChipBorder chipBorder2;
        Function2 function24;
        Function2 function25;
        Shape shape3;
        Modifier modifier4;
        State<BorderStroke> borderStroke$material3_release;
        final ChipBorder chipBorder3;
        Composer composer2;
        final Modifier modifier5;
        final boolean z3;
        final Function2 function26;
        final Function2 function27;
        final Shape shape4;
        final ChipColors chipColors3;
        final ChipElevation chipElevation4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i17;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(1295844802);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedAssistChip)P(8,5,7,3,6,10,9,1,2)375@18287L5,376@18338L26,377@18417L29,379@18530L39,386@18746L5,381@18578L571:Chip.kt#uh7d8r");
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
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 256 : 128;
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
                    obj2 = function22;
                    i4 |= startRestartGroup.changedInstance(obj2) ? 16384 : 8192;
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
                        int i20 = i4;
                        if ((i4 & 306783379) != 306783378 && (i12 & 3) == 2 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            function27 = function23;
                            chipElevation4 = chipElevation;
                            mutableInteractionSource3 = mutableInteractionSource;
                            z3 = z2;
                            composer2 = startRestartGroup;
                            shape4 = shape;
                            chipColors3 = chipColors2;
                            modifier5 = modifier2;
                            function26 = obj2;
                            chipBorder3 = chipBorder;
                        } else {
                            startRestartGroup.startDefaults();
                            int i21 = i12;
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i19 != 0 ? Modifier.Companion : modifier2;
                                boolean z4 = i5 != 0 ? true : z2;
                                Object obj3 = i6 != 0 ? null : obj2;
                                Function2 function28 = i7 != 0 ? null : function23;
                                if ((i3 & 64) != 0) {
                                    i13 = i20 & (-3670017);
                                    shape2 = AssistChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape2 = shape;
                                    i13 = i20;
                                }
                                if ((i3 & 128) != 0) {
                                    chipColors2 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(startRestartGroup, 6);
                                    i13 &= -29360129;
                                }
                                ChipColors chipColors4 = chipColors2;
                                int i22 = i13;
                                if ((i3 & 256) != 0) {
                                    modifier3 = companion;
                                    i15 = i21;
                                    i14 = 6;
                                    chipElevation2 = AssistChipDefaults.INSTANCE.m1589elevatedAssistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    i16 = i22 & (-234881025);
                                } else {
                                    modifier3 = companion;
                                    i14 = 6;
                                    i15 = i21;
                                    chipElevation2 = chipElevation;
                                    i16 = i22;
                                }
                                ChipBorder chipBorder4 = i9 != 0 ? null : chipBorder;
                                if (i11 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1551989929, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    chipElevation3 = chipElevation2;
                                    chipBorder2 = chipBorder4;
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    chipElevation3 = chipElevation2;
                                    chipBorder2 = chipBorder4;
                                }
                                z2 = z4;
                                function24 = obj3;
                                chipColors2 = chipColors4;
                                function25 = function28;
                                shape3 = shape2;
                                modifier4 = modifier3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                int i23 = (i3 & 64) != 0 ? i20 & (-3670017) : i20;
                                if ((i3 & 128) != 0) {
                                    i23 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i23 &= -234881025;
                                }
                                function25 = function23;
                                shape3 = shape;
                                chipElevation3 = chipElevation;
                                chipBorder2 = chipBorder;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i14 = 6;
                                modifier4 = modifier2;
                                function24 = obj2;
                                i16 = i23;
                                i15 = i21;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1295844802, i16, i15, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:381)");
                            }
                            TextStyle value = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14);
                            BorderStroke borderStroke = null;
                            long m1668labelColorvNxB06k$material3_release = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
                            float m1590getHeightD9Ej5fM = AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM();
                            PaddingValues paddingValues = AssistChipPadding;
                            startRestartGroup.startReplaceGroup(1552007127);
                            ComposerKt.sourceInformation(startRestartGroup, "395@19068L21");
                            borderStroke$material3_release = chipBorder2 == null ? null : chipBorder2.borderStroke$material3_release(z2, startRestartGroup, ((i16 >> 9) & 14) | ((i16 >> 24) & 112));
                            startRestartGroup.endReplaceGroup();
                            if (borderStroke$material3_release != null) {
                                borderStroke = borderStroke$material3_release.getValue();
                            }
                            int i24 = i16 << 6;
                            ChipColors chipColors5 = chipColors2;
                            boolean z5 = z2;
                            m1677ChipnkUnTEs(modifier4, function0, z5, obj, value, m1668labelColorvNxB06k$material3_release, function24, function25, shape3, chipColors5, chipElevation3, borderStroke, m1590getHeightD9Ej5fM, paddingValues, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i24 & 7168) | (3670016 & i24) | (29360128 & i24) | (234881024 & i24) | (i24 & 1879048192), ((i16 >> 24) & 14) | 3456 | ((i15 << 12) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipBorder3 = chipBorder2;
                            composer2 = startRestartGroup;
                            modifier5 = modifier4;
                            z3 = z5;
                            function26 = function24;
                            function27 = function25;
                            shape4 = shape3;
                            chipColors3 = chipColors5;
                            chipElevation4 = chipElevation3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedAssistChip$3
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

                                public final void invoke(Composer composer3, int i25) {
                                    ChipKt.ElevatedAssistChip(function0, function2, modifier5, z3, function26, function27, shape4, chipColors3, chipElevation4, chipBorder3, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
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
                    int i202 = i4;
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    int i212 = i12;
                    if ((i & 1) != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if ((i3 & 128) != 0) {
                    }
                    ChipColors chipColors42 = chipColors2;
                    int i222 = i13;
                    if ((i3 & 256) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    z2 = z4;
                    function24 = obj3;
                    chipColors2 = chipColors42;
                    function25 = function28;
                    shape3 = shape2;
                    modifier4 = modifier3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle value2 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14);
                    BorderStroke borderStroke2 = null;
                    long m1668labelColorvNxB06k$material3_release2 = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
                    float m1590getHeightD9Ej5fM2 = AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM();
                    PaddingValues paddingValues2 = AssistChipPadding;
                    startRestartGroup.startReplaceGroup(1552007127);
                    ComposerKt.sourceInformation(startRestartGroup, "395@19068L21");
                    if (chipBorder2 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    if (borderStroke$material3_release != null) {
                    }
                    int i242 = i16 << 6;
                    ChipColors chipColors52 = chipColors2;
                    boolean z52 = z2;
                    m1677ChipnkUnTEs(modifier4, function0, z52, obj, value2, m1668labelColorvNxB06k$material3_release2, function24, function25, shape3, chipColors52, chipElevation3, borderStroke2, m1590getHeightD9Ej5fM2, paddingValues2, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i242 & 7168) | (3670016 & i242) | (29360128 & i242) | (234881024 & i242) | (i242 & 1879048192), ((i16 >> 24) & 14) | 3456 | ((i15 << 12) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    chipBorder3 = chipBorder2;
                    composer2 = startRestartGroup;
                    modifier5 = modifier4;
                    z3 = z52;
                    function26 = function24;
                    function27 = function25;
                    shape4 = shape3;
                    chipColors3 = chipColors52;
                    chipElevation4 = chipElevation3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj2 = function22;
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
                int i2022 = i4;
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                int i2122 = i12;
                if ((i & 1) != 0) {
                }
                if (i19 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if ((i3 & 128) != 0) {
                }
                ChipColors chipColors422 = chipColors2;
                int i2222 = i13;
                if ((i3 & 256) != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
                z2 = z4;
                function24 = obj3;
                chipColors2 = chipColors422;
                function25 = function28;
                shape3 = shape2;
                modifier4 = modifier3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle value22 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14);
                BorderStroke borderStroke22 = null;
                long m1668labelColorvNxB06k$material3_release22 = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
                float m1590getHeightD9Ej5fM22 = AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM();
                PaddingValues paddingValues22 = AssistChipPadding;
                startRestartGroup.startReplaceGroup(1552007127);
                ComposerKt.sourceInformation(startRestartGroup, "395@19068L21");
                if (chipBorder2 == null) {
                }
                startRestartGroup.endReplaceGroup();
                if (borderStroke$material3_release != null) {
                }
                int i2422 = i16 << 6;
                ChipColors chipColors522 = chipColors2;
                boolean z522 = z2;
                m1677ChipnkUnTEs(modifier4, function0, z522, obj, value22, m1668labelColorvNxB06k$material3_release22, function24, function25, shape3, chipColors522, chipElevation3, borderStroke22, m1590getHeightD9Ej5fM22, paddingValues22, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i2422 & 7168) | (3670016 & i2422) | (29360128 & i2422) | (234881024 & i2422) | (i2422 & 1879048192), ((i16 >> 24) & 14) | 3456 | ((i15 << 12) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                chipBorder3 = chipBorder2;
                composer2 = startRestartGroup;
                modifier5 = modifier4;
                z3 = z522;
                function26 = function24;
                function27 = function25;
                shape4 = shape3;
                chipColors3 = chipColors522;
                chipElevation4 = chipElevation3;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            obj2 = function22;
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
            int i20222 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            int i21222 = i12;
            if ((i & 1) != 0) {
            }
            if (i19 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            ChipColors chipColors4222 = chipColors2;
            int i22222 = i13;
            if ((i3 & 256) != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
            }
            z2 = z4;
            function24 = obj3;
            chipColors2 = chipColors4222;
            function25 = function28;
            shape3 = shape2;
            modifier4 = modifier3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle value222 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14);
            BorderStroke borderStroke222 = null;
            long m1668labelColorvNxB06k$material3_release222 = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
            float m1590getHeightD9Ej5fM222 = AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM();
            PaddingValues paddingValues222 = AssistChipPadding;
            startRestartGroup.startReplaceGroup(1552007127);
            ComposerKt.sourceInformation(startRestartGroup, "395@19068L21");
            if (chipBorder2 == null) {
            }
            startRestartGroup.endReplaceGroup();
            if (borderStroke$material3_release != null) {
            }
            int i24222 = i16 << 6;
            ChipColors chipColors5222 = chipColors2;
            boolean z5222 = z2;
            m1677ChipnkUnTEs(modifier4, function0, z5222, obj, value222, m1668labelColorvNxB06k$material3_release222, function24, function25, shape3, chipColors5222, chipElevation3, borderStroke222, m1590getHeightD9Ej5fM222, paddingValues222, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i24222 & 7168) | (3670016 & i24222) | (29360128 & i24222) | (234881024 & i24222) | (i24222 & 1879048192), ((i16 >> 24) & 14) | 3456 | ((i15 << 12) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            chipBorder3 = chipBorder2;
            composer2 = startRestartGroup;
            modifier5 = modifier4;
            z3 = z5222;
            function26 = function24;
            function27 = function25;
            shape4 = shape3;
            chipColors3 = chipColors5222;
            chipElevation4 = chipElevation3;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        obj2 = function22;
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
        int i202222 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        int i212222 = i12;
        if ((i & 1) != 0) {
        }
        if (i19 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        ChipColors chipColors42222 = chipColors2;
        int i222222 = i13;
        if ((i3 & 256) != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
        z2 = z4;
        function24 = obj3;
        chipColors2 = chipColors42222;
        function25 = function28;
        shape3 = shape2;
        modifier4 = modifier3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle value2222 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14);
        BorderStroke borderStroke2222 = null;
        long m1668labelColorvNxB06k$material3_release2222 = chipColors2.m1668labelColorvNxB06k$material3_release(z2);
        float m1590getHeightD9Ej5fM2222 = AssistChipDefaults.INSTANCE.m1590getHeightD9Ej5fM();
        PaddingValues paddingValues2222 = AssistChipPadding;
        startRestartGroup.startReplaceGroup(1552007127);
        ComposerKt.sourceInformation(startRestartGroup, "395@19068L21");
        if (chipBorder2 == null) {
        }
        startRestartGroup.endReplaceGroup();
        if (borderStroke$material3_release != null) {
        }
        int i242222 = i16 << 6;
        ChipColors chipColors52222 = chipColors2;
        boolean z52222 = z2;
        m1677ChipnkUnTEs(modifier4, function0, z52222, obj, value2222, m1668labelColorvNxB06k$material3_release2222, function24, function25, shape3, chipColors52222, chipElevation3, borderStroke2222, m1590getHeightD9Ej5fM2222, paddingValues2222, mutableInteractionSource2, startRestartGroup, ((i16 >> 6) & 14) | ((i16 << 3) & 112) | ((i16 >> 3) & 896) | (i242222 & 7168) | (3670016 & i242222) | (29360128 & i242222) | (234881024 & i242222) | (i242222 & 1879048192), ((i16 >> 24) & 14) | 3456 | ((i15 << 12) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        chipBorder3 = chipBorder2;
        composer2 = startRestartGroup;
        modifier5 = modifier4;
        z3 = z52222;
        function26 = function24;
        function27 = function25;
        shape4 = shape3;
        chipColors3 = chipColors52222;
        chipElevation4 = chipElevation3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:202:? A[RETURN, SYNTHETIC] */
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
        Shape shape2;
        SelectableChipColors selectableChipColors2;
        Object obj8;
        int i13;
        int i14;
        SelectableChipElevation selectableChipElevation2;
        int i15;
        boolean z5;
        BorderStroke borderStroke2;
        MutableInteractionSource mutableInteractionSource2;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke3;
        boolean z6;
        int i16;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape3;
        SelectableChipColors selectableChipColors3;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape4;
        final SelectableChipColors selectableChipColors4;
        final SelectableChipElevation selectableChipElevation4;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer startRestartGroup = composer.startRestartGroup(-1711985619);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilterChip)P(9,8,5,7,3,6,11,10,1,2)462@22511L5,463@22572L18,464@22653L21,465@22723L35,474@23031L5,468@22824L554:Chip.kt#uh7d8r");
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
        int i21 = i3 & 8;
        if (i21 != 0) {
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
                            i20 = 8388608;
                            i4 |= i20;
                        }
                    } else {
                        obj5 = shape;
                    }
                    i20 = 4194304;
                    i4 |= i20;
                } else {
                    obj5 = shape;
                }
                if ((i & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        obj6 = selectableChipColors;
                        if (startRestartGroup.changed(obj6)) {
                            i19 = 67108864;
                            i4 |= i19;
                        }
                    } else {
                        obj6 = selectableChipColors;
                    }
                    i19 = 33554432;
                    i4 |= i19;
                } else {
                    obj6 = selectableChipColors;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & 512) == 0 && startRestartGroup.changed(selectableChipElevation)) {
                        i18 = C.BUFFER_FLAG_LAST_SAMPLE;
                        i4 |= i18;
                    }
                    i18 = 268435456;
                    i4 |= i18;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0 && startRestartGroup.changed(borderStroke)) {
                        i17 = 4;
                        i8 = i2 | i17;
                    }
                    i17 = 2;
                    i8 = i2 | i17;
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
                int i22 = i4;
                if ((i4 & 306783379) != 306783378 && (i11 & 19) == 18 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    borderStroke4 = borderStroke;
                    mutableInteractionSource3 = obj7;
                    selectableChipColors4 = obj6;
                    modifier3 = obj3;
                    composer2 = startRestartGroup;
                    function26 = function22;
                    function27 = obj4;
                    shape4 = obj5;
                    z7 = z4;
                    selectableChipElevation4 = selectableChipElevation;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i21 != 0 ? Modifier.Companion : obj3;
                        boolean z8 = i5 != 0 ? true : z4;
                        Function2<? super Composer, ? super Integer, Unit> function28 = i6 != 0 ? null : function22;
                        Object obj9 = i7 != 0 ? null : obj4;
                        if ((i3 & 128) != 0) {
                            i12 = i22 & (-29360129);
                            shape2 = FilterChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        } else {
                            i12 = i22;
                            shape2 = obj5;
                        }
                        if ((i3 & 256) != 0) {
                            i12 &= -234881025;
                            selectableChipColors2 = FilterChipDefaults.INSTANCE.filterChipColors(startRestartGroup, 6);
                        } else {
                            selectableChipColors2 = obj6;
                        }
                        int i23 = i12;
                        if ((i3 & 512) != 0) {
                            obj8 = companion;
                            i13 = 6;
                            i14 = i10;
                            selectableChipElevation2 = FilterChipDefaults.INSTANCE.m1916filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            i15 = i23 & (-1879048193);
                        } else {
                            obj8 = companion;
                            i13 = 6;
                            i14 = i10;
                            selectableChipElevation2 = selectableChipElevation;
                            i15 = i23;
                        }
                        if ((i3 & 1024) != 0) {
                            z5 = z8;
                            borderStroke2 = FilterChipDefaults.INSTANCE.m1914filterChipBorder_7El2pE(z5, z3, 0L, 0L, 0L, 0L, 0.0f, 0.0f, startRestartGroup, ((i15 >> 12) & 14) | 100663296 | ((i15 << 3) & 112), 252);
                            i11 &= -15;
                        } else {
                            z5 = z8;
                            borderStroke2 = borderStroke;
                        }
                        if (i14 != 0) {
                            selectableChipElevation3 = selectableChipElevation2;
                            borderStroke3 = borderStroke2;
                            z6 = z5;
                            i16 = i11;
                            mutableInteractionSource2 = null;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            selectableChipElevation3 = selectableChipElevation2;
                            borderStroke3 = borderStroke2;
                            z6 = z5;
                            i16 = i11;
                        }
                        function24 = function28;
                        function25 = obj9;
                        shape3 = shape2;
                        selectableChipColors3 = selectableChipColors2;
                        modifier2 = obj8;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        int i24 = (i3 & 128) != 0 ? i22 & (-29360129) : i22;
                        if ((i3 & 256) != 0) {
                            i24 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i24 &= -1879048193;
                        }
                        if ((i3 & 1024) != 0) {
                            i11 &= -15;
                        }
                        function24 = function22;
                        selectableChipElevation3 = selectableChipElevation;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource2 = obj7;
                        function25 = obj4;
                        shape3 = obj5;
                        selectableChipColors3 = obj6;
                        modifier2 = obj3;
                        z6 = z4;
                        i15 = i24;
                        i13 = 6;
                        i16 = i11;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1711985619, i15, i16, "androidx.compose.material3.FilterChip (Chip.kt:468)");
                    }
                    int i25 = i15 << 3;
                    int i26 = i15 << 6;
                    int i27 = i15 >> 24;
                    m1679SelectableChipu0RnIRE(z, modifier2, obj, z6, obj2, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i13), function24, null, function25, shape3, selectableChipColors3, selectableChipElevation3, borderStroke3, FilterChipDefaults.INSTANCE.m1917getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, (i15 & 14) | 12582912 | ((i15 >> 6) & 112) | (i25 & 896) | ((i15 >> 3) & 7168) | (57344 & i26) | (i25 & 3670016) | (234881024 & i26) | (1879048192 & i26), (i27 & 112) | (i27 & 14) | 27648 | ((i16 << 6) & 896) | ((i16 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    z7 = z6;
                    function26 = function24;
                    function27 = function25;
                    shape4 = shape3;
                    selectableChipColors4 = selectableChipColors3;
                    selectableChipElevation4 = selectableChipElevation3;
                    borderStroke4 = borderStroke3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$FilterChip$1
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

                        public final void invoke(Composer composer3, int i28) {
                            ChipKt.FilterChip(z, function0, function2, modifier3, z7, function26, function27, shape4, selectableChipColors4, selectableChipElevation4, borderStroke4, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
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
            int i222 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i21 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            int i232 = i12;
            if ((i3 & 512) != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if (i14 != 0) {
            }
            function24 = function28;
            function25 = obj9;
            shape3 = shape2;
            selectableChipColors3 = selectableChipColors2;
            modifier2 = obj8;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i252 = i15 << 3;
            int i262 = i15 << 6;
            int i272 = i15 >> 24;
            m1679SelectableChipu0RnIRE(z, modifier2, obj, z6, obj2, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i13), function24, null, function25, shape3, selectableChipColors3, selectableChipElevation3, borderStroke3, FilterChipDefaults.INSTANCE.m1917getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, (i15 & 14) | 12582912 | ((i15 >> 6) & 112) | (i252 & 896) | ((i15 >> 3) & 7168) | (57344 & i262) | (i252 & 3670016) | (234881024 & i262) | (1879048192 & i262), (i272 & 112) | (i272 & 14) | 27648 | ((i16 << 6) & 896) | ((i16 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier3 = modifier2;
            z7 = z6;
            function26 = function24;
            function27 = function25;
            shape4 = shape3;
            selectableChipColors4 = selectableChipColors3;
            selectableChipElevation4 = selectableChipElevation3;
            borderStroke4 = borderStroke3;
            mutableInteractionSource3 = mutableInteractionSource2;
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
        int i2222 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i21 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        int i2322 = i12;
        if ((i3 & 512) != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if (i14 != 0) {
        }
        function24 = function28;
        function25 = obj9;
        shape3 = shape2;
        selectableChipColors3 = selectableChipColors2;
        modifier2 = obj8;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2522 = i15 << 3;
        int i2622 = i15 << 6;
        int i2722 = i15 >> 24;
        m1679SelectableChipu0RnIRE(z, modifier2, obj, z6, obj2, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i13), function24, null, function25, shape3, selectableChipColors3, selectableChipElevation3, borderStroke3, FilterChipDefaults.INSTANCE.m1917getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, (i15 & 14) | 12582912 | ((i15 >> 6) & 112) | (i2522 & 896) | ((i15 >> 3) & 7168) | (57344 & i2622) | (i2522 & 3670016) | (234881024 & i2622) | (1879048192 & i2622), (i2722 & 112) | (i2722 & 14) | 27648 | ((i16 << 6) & 896) | ((i16 << 12) & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier3 = modifier2;
        z7 = z6;
        function26 = function24;
        function27 = function25;
        shape4 = shape3;
        selectableChipColors4 = selectableChipColors3;
        selectableChipElevation4 = selectableChipElevation3;
        borderStroke4 = borderStroke3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:196:? A[RETURN, SYNTHETIC] */
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
        Shape shape2;
        Object obj7;
        Object obj8;
        int i14;
        int i15;
        SelectableChipElevation selectableChipElevation2;
        int i16;
        MutableInteractionSource mutableInteractionSource2;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke2;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape3;
        int i17;
        boolean z4;
        int i18;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape4;
        final SelectableChipColors selectableChipColors2;
        final SelectableChipElevation selectableChipElevation4;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i19;
        int i20;
        int i21;
        Composer startRestartGroup = composer.startRestartGroup(-106647389);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedFilterChip)P(9,8,5,7,3,6,11,10,1,2)546@26622L5,547@26683L26,548@26772L29,558@27108L5,552@26901L554:Chip.kt#uh7d8r");
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
                int i23 = i10;
                int i24 = i4;
                if ((i4 & 306783379) != 306783378 && (i23 & 19) == 18 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    borderStroke3 = borderStroke;
                    mutableInteractionSource3 = mutableInteractionSource;
                    selectableChipColors2 = obj6;
                    modifier3 = obj3;
                    composer2 = startRestartGroup;
                    function26 = function22;
                    function27 = obj4;
                    shape4 = obj5;
                    z5 = z3;
                    selectableChipElevation4 = selectableChipElevation;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i22 != 0 ? Modifier.Companion : obj3;
                        boolean z6 = i5 != 0 ? true : z3;
                        Function2<? super Composer, ? super Integer, Unit> function28 = i6 != 0 ? null : function22;
                        Object obj9 = i7 != 0 ? null : obj4;
                        if ((i3 & 128) != 0) {
                            i13 = i24 & (-29360129);
                            shape2 = FilterChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        } else {
                            i13 = i24;
                            shape2 = obj5;
                        }
                        if ((i3 & 256) != 0) {
                            i13 &= -234881025;
                            obj7 = FilterChipDefaults.INSTANCE.elevatedFilterChipColors(startRestartGroup, 6);
                        } else {
                            obj7 = obj6;
                        }
                        int i25 = i13;
                        if ((i3 & 512) != 0) {
                            obj8 = companion;
                            i15 = i23;
                            i14 = 6;
                            selectableChipElevation2 = FilterChipDefaults.INSTANCE.m1913elevatedFilterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                            i16 = i25 & (-1879048193);
                        } else {
                            obj8 = companion;
                            i14 = 6;
                            i15 = i23;
                            selectableChipElevation2 = selectableChipElevation;
                            i16 = i25;
                        }
                        BorderStroke borderStroke4 = i9 != 0 ? null : borderStroke;
                        if (i12 != 0) {
                            selectableChipElevation3 = selectableChipElevation2;
                            borderStroke2 = borderStroke4;
                            function24 = function28;
                            function25 = obj9;
                            i17 = 12582912;
                            z4 = z6;
                            mutableInteractionSource2 = null;
                            i18 = -106647389;
                            modifier2 = obj8;
                            shape3 = shape2;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                            selectableChipElevation3 = selectableChipElevation2;
                            borderStroke2 = borderStroke4;
                            function24 = function28;
                            function25 = obj9;
                            shape3 = shape2;
                            i17 = 12582912;
                            z4 = z6;
                            i18 = -106647389;
                            modifier2 = obj8;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        int i26 = (i3 & 128) != 0 ? i24 & (-29360129) : i24;
                        if ((i3 & 256) != 0) {
                            i26 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i26 &= -1879048193;
                        }
                        function24 = function22;
                        selectableChipElevation3 = selectableChipElevation;
                        borderStroke2 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i14 = 6;
                        function25 = obj4;
                        shape3 = obj5;
                        obj7 = obj6;
                        modifier2 = obj3;
                        i17 = 12582912;
                        i18 = -106647389;
                        i16 = i26;
                        z4 = z3;
                        i15 = i23;
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i16, i15, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:552)");
                    }
                    int i27 = i16 << 3;
                    int i28 = i16 << 6;
                    int i29 = i17 | (i16 & 14) | ((i16 >> 6) & 112) | (i27 & 896) | ((i16 >> 3) & 7168) | (57344 & i28) | (i27 & 3670016) | (234881024 & i28) | (1879048192 & i28);
                    int i30 = i16 >> 24;
                    m1679SelectableChipu0RnIRE(z, modifier2, obj, z4, obj2, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), function24, null, function25, shape3, obj7, selectableChipElevation3, borderStroke2, FilterChipDefaults.INSTANCE.m1917getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i29, (i30 & 112) | (i30 & 14) | 27648 | ((i15 << 6) & 896) | ((i15 << 12) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    z5 = z4;
                    function26 = function24;
                    function27 = function25;
                    shape4 = shape3;
                    selectableChipColors2 = obj7;
                    selectableChipElevation4 = selectableChipElevation3;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedFilterChip$1
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

                        public final void invoke(Composer composer3, int i31) {
                            ChipKt.ElevatedFilterChip(z, function0, function2, modifier3, z5, function26, function27, shape4, selectableChipColors2, selectableChipElevation4, borderStroke3, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
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
            int i232 = i10;
            int i242 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i22 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 128) != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            int i252 = i13;
            if ((i3 & 512) != 0) {
            }
            if (i9 != 0) {
            }
            if (i12 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i272 = i16 << 3;
            int i282 = i16 << 6;
            int i292 = i17 | (i16 & 14) | ((i16 >> 6) & 112) | (i272 & 896) | ((i16 >> 3) & 7168) | (57344 & i282) | (i272 & 3670016) | (234881024 & i282) | (1879048192 & i282);
            int i302 = i16 >> 24;
            m1679SelectableChipu0RnIRE(z, modifier2, obj, z4, obj2, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), function24, null, function25, shape3, obj7, selectableChipElevation3, borderStroke2, FilterChipDefaults.INSTANCE.m1917getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i292, (i302 & 112) | (i302 & 14) | 27648 | ((i15 << 6) & 896) | ((i15 << 12) & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier3 = modifier2;
            z5 = z4;
            function26 = function24;
            function27 = function25;
            shape4 = shape3;
            selectableChipColors2 = obj7;
            selectableChipElevation4 = selectableChipElevation3;
            borderStroke3 = borderStroke2;
            mutableInteractionSource3 = mutableInteractionSource2;
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
        int i2322 = i10;
        int i2422 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i22 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 128) != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        int i2522 = i13;
        if ((i3 & 512) != 0) {
        }
        if (i9 != 0) {
        }
        if (i12 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2722 = i16 << 3;
        int i2822 = i16 << 6;
        int i2922 = i17 | (i16 & 14) | ((i16 >> 6) & 112) | (i2722 & 896) | ((i16 >> 3) & 7168) | (57344 & i2822) | (i2722 & 3670016) | (234881024 & i2822) | (1879048192 & i2822);
        int i3022 = i16 >> 24;
        m1679SelectableChipu0RnIRE(z, modifier2, obj, z4, obj2, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i14), function24, null, function25, shape3, obj7, selectableChipElevation3, borderStroke2, FilterChipDefaults.INSTANCE.m1917getHeightD9Ej5fM(), FilterChipPadding, mutableInteractionSource2, startRestartGroup, i2922, (i3022 & 112) | (i3022 & 14) | 27648 | ((i15 << 6) & 896) | ((i15 << 12) & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier3 = modifier2;
        z5 = z4;
        function26 = function24;
        function27 = function25;
        shape4 = shape3;
        selectableChipColors2 = obj7;
        selectableChipElevation4 = selectableChipElevation3;
        borderStroke3 = borderStroke2;
        mutableInteractionSource3 = mutableInteractionSource2;
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
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:232:? A[RETURN, SYNTHETIC] */
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
        boolean z4;
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
        Shape shape2;
        int i14;
        SelectableChipColors selectableChipColors2;
        int i15;
        int i16;
        SelectableChipElevation selectableChipElevation2;
        int i17;
        BorderStroke borderStroke2;
        MutableInteractionSource mutableInteractionSource2;
        SelectableChipElevation selectableChipElevation3;
        BorderStroke borderStroke3;
        boolean z5;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape3;
        SelectableChipColors selectableChipColors3;
        int i18;
        boolean z6;
        Composer composer2;
        final Modifier modifier2;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Shape shape4;
        final SelectableChipColors selectableChipColors4;
        final SelectableChipElevation selectableChipElevation4;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i19;
        int i20;
        int i21;
        int i22;
        Composer startRestartGroup = composer.startRestartGroup(1658928131);
        ComposerKt.sourceInformation(startRestartGroup, "C(InputChip)P(10,9,6,8,4,7!1,12,11,2,3)638@30882L5,639@30942L17,640@31021L20,641@31089L34,671@32220L5,665@32014L745:Chip.kt#uh7d8r");
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
                    z4 = z2;
                    i4 |= startRestartGroup.changed(z4) ? 16384 : 8192;
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
                    int i25 = i4;
                    if ((i4 & 306783379) == 306783378 || (i13 & 147) != 146 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        ComposableLambda composableLambda = null;
                        int i26 = i13;
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i5 == 0 ? Modifier.Companion : modifier;
                            boolean z8 = i6 == 0 ? true : z4;
                            Function2<? super Composer, ? super Integer, Unit> function28 = i7 == 0 ? null : obj2;
                            Function2<? super Composer, ? super Integer, Unit> function29 = i8 == 0 ? null : obj3;
                            Object obj5 = i9 == 0 ? null : obj4;
                            if ((i3 & 256) == 0) {
                                i14 = i25 & (-234881025);
                                shape2 = InputChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                            } else {
                                shape2 = shape;
                                i14 = i25;
                            }
                            if ((i3 & 512) == 0) {
                                i14 &= -1879048193;
                                selectableChipColors2 = InputChipDefaults.INSTANCE.inputChipColors(startRestartGroup, 6);
                            } else {
                                selectableChipColors2 = selectableChipColors;
                            }
                            int i27 = i14;
                            if ((i3 & 1024) == 0) {
                                modifier = companion;
                                i15 = 6;
                                i16 = i12;
                                selectableChipElevation2 = InputChipDefaults.INSTANCE.m1970inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                i17 = i26 & (-15);
                            } else {
                                modifier = companion;
                                i15 = 6;
                                i16 = i12;
                                selectableChipElevation2 = selectableChipElevation;
                                i17 = i26;
                            }
                            boolean z9 = z8;
                            if ((i3 & 2048) == 0) {
                                borderStroke2 = InputChipDefaults.INSTANCE.m1968inputChipBorder_7El2pE(z9, z3, 0L, 0L, 0L, 0L, 0.0f, 0.0f, startRestartGroup, ((i27 >> 12) & 14) | 100663296 | ((i27 << 3) & 112), 252);
                                i17 &= -113;
                            } else {
                                borderStroke2 = borderStroke;
                            }
                            if (i16 == 0) {
                                selectableChipElevation3 = selectableChipElevation2;
                                borderStroke3 = borderStroke2;
                                z5 = z9;
                                mutableInteractionSource2 = null;
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                                selectableChipElevation3 = selectableChipElevation2;
                                borderStroke3 = borderStroke2;
                                z5 = z9;
                            }
                            function25 = function28;
                            obj3 = function29;
                            function26 = obj5;
                            shape3 = shape2;
                            selectableChipColors3 = selectableChipColors2;
                            i18 = i27;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            int i28 = (i3 & 256) != 0 ? i25 & (-234881025) : i25;
                            if ((i3 & 512) != 0) {
                                i28 &= -1879048193;
                            }
                            if ((i3 & 1024) != 0) {
                                i26 &= -15;
                            }
                            if ((i3 & 2048) != 0) {
                                i26 &= -113;
                            }
                            i18 = i28;
                            i15 = 6;
                            shape3 = shape;
                            selectableChipColors3 = selectableChipColors;
                            selectableChipElevation3 = selectableChipElevation;
                            borderStroke3 = borderStroke;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z5 = z4;
                            function25 = obj2;
                            function26 = obj4;
                            i17 = i26;
                        }
                        Modifier modifier3 = modifier;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1658928131, i18, i17, "androidx.compose.material3.InputChip (Chip.kt:643)");
                        }
                        startRestartGroup.startReplaceGroup(417920884);
                        ComposerKt.sourceInformation(startRestartGroup, "649@31531L5,651@31584L419");
                        if (obj3 == null) {
                            final float f = z5 ? 1.0f : 0.38f;
                            final Shape value = ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), startRestartGroup, i15);
                            z6 = true;
                            composableLambda = ComposableLambdaKt.rememberComposableLambda(1154227507, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$1
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

                                public final void invoke(Composer composer3, int i29) {
                                    ComposerKt.sourceInformation(composer3, "C654@31685L180,652@31602L387:Chip.kt#uh7d8r");
                                    if ((i29 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1154227507, i29, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:652)");
                                        }
                                        Modifier.Companion companion2 = Modifier.Companion;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -724235578, "CC(remember):Chip.kt#9igjgp");
                                        boolean changed = composer3.changed(f) | composer3.changed(value);
                                        final float f2 = f;
                                        final Shape shape5 = value;
                                        Object rememberedValue = composer3.rememberedValue();
                                        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$1$1$1
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
                                                    graphicsLayerScope.setAlpha(f2);
                                                    graphicsLayerScope.setShape(shape5);
                                                    graphicsLayerScope.setClip(true);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) rememberedValue);
                                        Alignment center = Alignment.Companion.getCenter();
                                        Function2<Composer, Integer, Unit> function210 = obj3;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
                                        Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 1618257738, "C661@31963L8:Chip.kt#uh7d8r");
                                        function210.invoke(composer3, 0);
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
                        } else {
                            z6 = true;
                        }
                        ComposableLambda composableLambda2 = composableLambda;
                        startRestartGroup.endReplaceGroup();
                        TextStyle value2 = TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i15);
                        int i29 = (i18 & 14) | ((i18 >> 6) & 112);
                        int i30 = i18 << 3;
                        int i31 = i17 << 3;
                        m1679SelectableChipu0RnIRE(z, modifier3, obj, z5, function2, value2, function25, composableLambda2, function26, shape3, selectableChipColors3, selectableChipElevation3, borderStroke3, InputChipDefaults.INSTANCE.m1966getHeightD9Ej5fM(), inputChipPadding(composableLambda2 == null ? z6 : false, function25 == null ? z6 : false, function26 != null ? z6 : false), mutableInteractionSource2, startRestartGroup, i29 | (i30 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i30) | (234881024 & i30) | (i30 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i31 & 112) | (i31 & 896) | ((i17 << 9) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer2 = startRestartGroup;
                        modifier2 = modifier3;
                        z7 = z5;
                        obj2 = function25;
                        function27 = function26;
                        shape4 = shape3;
                        selectableChipColors4 = selectableChipColors3;
                        selectableChipElevation4 = selectableChipElevation3;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        selectableChipElevation4 = selectableChipElevation;
                        borderStroke4 = borderStroke;
                        mutableInteractionSource3 = mutableInteractionSource;
                        z7 = z4;
                        composer2 = startRestartGroup;
                        function27 = obj4;
                        modifier2 = modifier;
                        shape4 = shape;
                        selectableChipColors4 = selectableChipColors;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$InputChip$2
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

                            public final void invoke(Composer composer3, int i32) {
                                ChipKt.InputChip(z, function0, function2, modifier2, z7, obj2, obj3, function27, shape4, selectableChipColors4, selectableChipElevation4, borderStroke4, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                z4 = z2;
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
                int i252 = i4;
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                ComposableLambda composableLambda3 = null;
                int i262 = i13;
                if ((i & 1) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if ((i3 & 256) == 0) {
                }
                if ((i3 & 512) == 0) {
                }
                int i272 = i14;
                if ((i3 & 1024) == 0) {
                }
                boolean z92 = z8;
                if ((i3 & 2048) == 0) {
                }
                if (i16 == 0) {
                }
                function25 = function28;
                obj3 = function29;
                function26 = obj5;
                shape3 = shape2;
                selectableChipColors3 = selectableChipColors2;
                i18 = i272;
                Modifier modifier32 = modifier;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(417920884);
                ComposerKt.sourceInformation(startRestartGroup, "649@31531L5,651@31584L419");
                if (obj3 == null) {
                }
                ComposableLambda composableLambda22 = composableLambda3;
                startRestartGroup.endReplaceGroup();
                TextStyle value22 = TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i15);
                int i292 = (i18 & 14) | ((i18 >> 6) & 112);
                int i302 = i18 << 3;
                int i312 = i17 << 3;
                m1679SelectableChipu0RnIRE(z, modifier32, obj, z5, function2, value22, function25, composableLambda22, function26, shape3, selectableChipColors3, selectableChipElevation3, borderStroke3, InputChipDefaults.INSTANCE.m1966getHeightD9Ej5fM(), inputChipPadding(composableLambda22 == null ? z6 : false, function25 == null ? z6 : false, function26 != null ? z6 : false), mutableInteractionSource2, startRestartGroup, i292 | (i302 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i302) | (234881024 & i302) | (i302 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i312 & 112) | (i312 & 896) | ((i17 << 9) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier2 = modifier32;
                z7 = z5;
                obj2 = function25;
                function27 = function26;
                shape4 = shape3;
                selectableChipColors4 = selectableChipColors3;
                selectableChipElevation4 = selectableChipElevation3;
                borderStroke4 = borderStroke3;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z4 = z2;
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
            int i2522 = i4;
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            ComposableLambda composableLambda32 = null;
            int i2622 = i13;
            if ((i & 1) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if ((i3 & 256) == 0) {
            }
            if ((i3 & 512) == 0) {
            }
            int i2722 = i14;
            if ((i3 & 1024) == 0) {
            }
            boolean z922 = z8;
            if ((i3 & 2048) == 0) {
            }
            if (i16 == 0) {
            }
            function25 = function28;
            obj3 = function29;
            function26 = obj5;
            shape3 = shape2;
            selectableChipColors3 = selectableChipColors2;
            i18 = i2722;
            Modifier modifier322 = modifier;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(417920884);
            ComposerKt.sourceInformation(startRestartGroup, "649@31531L5,651@31584L419");
            if (obj3 == null) {
            }
            ComposableLambda composableLambda222 = composableLambda32;
            startRestartGroup.endReplaceGroup();
            TextStyle value222 = TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i15);
            int i2922 = (i18 & 14) | ((i18 >> 6) & 112);
            int i3022 = i18 << 3;
            int i3122 = i17 << 3;
            m1679SelectableChipu0RnIRE(z, modifier322, obj, z5, function2, value222, function25, composableLambda222, function26, shape3, selectableChipColors3, selectableChipElevation3, borderStroke3, InputChipDefaults.INSTANCE.m1966getHeightD9Ej5fM(), inputChipPadding(composableLambda222 == null ? z6 : false, function25 == null ? z6 : false, function26 != null ? z6 : false), mutableInteractionSource2, startRestartGroup, i2922 | (i3022 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i3022) | (234881024 & i3022) | (i3022 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i3122 & 112) | (i3122 & 896) | ((i17 << 9) & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier2 = modifier322;
            z7 = z5;
            obj2 = function25;
            function27 = function26;
            shape4 = shape3;
            selectableChipColors4 = selectableChipColors3;
            selectableChipElevation4 = selectableChipElevation3;
            borderStroke4 = borderStroke3;
            mutableInteractionSource3 = mutableInteractionSource2;
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
        z4 = z2;
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
        int i25222 = i4;
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        ComposableLambda composableLambda322 = null;
        int i26222 = i13;
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if ((i3 & 256) == 0) {
        }
        if ((i3 & 512) == 0) {
        }
        int i27222 = i14;
        if ((i3 & 1024) == 0) {
        }
        boolean z9222 = z8;
        if ((i3 & 2048) == 0) {
        }
        if (i16 == 0) {
        }
        function25 = function28;
        obj3 = function29;
        function26 = obj5;
        shape3 = shape2;
        selectableChipColors3 = selectableChipColors2;
        i18 = i27222;
        Modifier modifier3222 = modifier;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(417920884);
        ComposerKt.sourceInformation(startRestartGroup, "649@31531L5,651@31584L419");
        if (obj3 == null) {
        }
        ComposableLambda composableLambda2222 = composableLambda322;
        startRestartGroup.endReplaceGroup();
        TextStyle value2222 = TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i15);
        int i29222 = (i18 & 14) | ((i18 >> 6) & 112);
        int i30222 = i18 << 3;
        int i31222 = i17 << 3;
        m1679SelectableChipu0RnIRE(z, modifier3222, obj, z5, function2, value2222, function25, composableLambda2222, function26, shape3, selectableChipColors3, selectableChipElevation3, borderStroke3, InputChipDefaults.INSTANCE.m1966getHeightD9Ej5fM(), inputChipPadding(composableLambda2222 == null ? z6 : false, function25 == null ? z6 : false, function26 != null ? z6 : false), mutableInteractionSource2, startRestartGroup, i29222 | (i30222 & 896) | ((i18 >> 3) & 7168) | ((i18 << 6) & 57344) | (3670016 & i30222) | (234881024 & i30222) | (i30222 & 1879048192), ((i18 >> 27) & 14) | 3072 | (i31222 & 112) | (i31222 & 896) | ((i17 << 9) & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier2 = modifier3222;
        z7 = z5;
        obj2 = function25;
        function27 = function26;
        shape4 = shape3;
        selectableChipColors4 = selectableChipColors3;
        selectableChipElevation4 = selectableChipElevation3;
        borderStroke4 = borderStroke3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
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
        Object obj6;
        int i9;
        Shape shape2;
        ChipColors chipColors3;
        int i10;
        Modifier modifier2;
        int i11;
        boolean z3;
        BorderStroke borderStroke2;
        int i12;
        MutableInteractionSource mutableInteractionSource2;
        BorderStroke borderStroke3;
        int i13;
        Function2<? super Composer, ? super Integer, Unit> function23;
        ChipElevation chipElevation2;
        Shape shape3;
        boolean z4;
        Composer composer2;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Shape shape4;
        final ChipColors chipColors4;
        final ChipElevation chipElevation3;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-1700130831);
        ComposerKt.sourceInformation(startRestartGroup, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)740@35497L5,741@35552L22,742@35631L25,743@35709L29,751@35977L5,746@35805L538:Chip.kt#uh7d8r");
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
                    if ((i & 100663296) == 0) {
                        if ((i2 & 256) == 0 && startRestartGroup.changed(borderStroke)) {
                            i14 = 67108864;
                            i3 |= i14;
                        }
                        i14 = 33554432;
                        i3 |= i14;
                    }
                    i7 = i2 & 512;
                    if (i7 == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i8 = i7;
                        obj6 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(obj6) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        int i19 = i3;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i18 != 0 ? Modifier.Companion : obj2;
                                boolean z6 = i4 != 0 ? true : z2;
                                Object obj7 = i5 != 0 ? null : obj3;
                                if ((i2 & 32) != 0) {
                                    i9 = i19 & (-458753);
                                    shape2 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    i9 = i19;
                                    shape2 = obj4;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                    chipColors3 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(startRestartGroup, 6);
                                } else {
                                    chipColors3 = chipColors2;
                                }
                                int i20 = i9;
                                if ((i2 & 128) != 0) {
                                    i20 &= -29360129;
                                    i10 = 6;
                                    obj5 = SuggestionChipDefaults.INSTANCE.m2346suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                } else {
                                    i10 = 6;
                                }
                                if ((i2 & 256) != 0) {
                                    modifier2 = companion;
                                    i11 = i10;
                                    z3 = z6;
                                    borderStroke2 = SuggestionChipDefaults.INSTANCE.m2344suggestionChipBorderh1eTWw(z3, 0L, 0L, 0.0f, startRestartGroup, ((i20 >> 9) & 14) | 24576, 14);
                                    i12 = i20 & (-234881025);
                                } else {
                                    modifier2 = companion;
                                    i11 = i10;
                                    z3 = z6;
                                    borderStroke2 = borderStroke;
                                    i12 = i20;
                                }
                                if (i8 != 0) {
                                    borderStroke3 = borderStroke2;
                                    i13 = i12;
                                    chipColors2 = chipColors3;
                                    mutableInteractionSource2 = null;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    borderStroke3 = borderStroke2;
                                    i13 = i12;
                                    chipColors2 = chipColors3;
                                }
                                function23 = obj7;
                                obj2 = modifier2;
                                chipElevation2 = obj5;
                                shape3 = shape2;
                                z4 = z3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i19 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i19 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i19 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i19 &= -234881025;
                                }
                                borderStroke3 = borderStroke;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i11 = 6;
                                function23 = obj3;
                                shape3 = obj4;
                                chipElevation2 = obj5;
                                i13 = i19;
                                z4 = z2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1700130831, i13, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:746)");
                            }
                            int i21 = i13 << 6;
                            int i22 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i21 & 7168) | (i21 & 3670016);
                            int i23 = i13 << 9;
                            int i24 = i22 | (234881024 & i23) | (i23 & 1879048192);
                            int i25 = i13 >> 21;
                            ChipColors chipColors5 = chipColors2;
                            Function2<? super Composer, ? super Integer, Unit> function25 = obj;
                            Modifier modifier3 = obj2;
                            m1677ChipnkUnTEs(modifier3, function02, z4, function25, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i11), chipColors2.m1668labelColorvNxB06k$material3_release(z4), function23, null, shape3, chipColors5, chipElevation2, borderStroke3, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i24, (i25 & 112) | (i25 & 14) | 3456 | ((i13 >> 15) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            obj2 = modifier3;
                            z5 = z4;
                            function24 = function23;
                            shape4 = shape3;
                            chipColors4 = chipColors5;
                            chipElevation3 = chipElevation2;
                            borderStroke4 = borderStroke3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z5 = z2;
                            function24 = obj3;
                            composer2 = startRestartGroup;
                            shape4 = obj4;
                            chipColors4 = chipColors2;
                            chipElevation3 = obj5;
                            borderStroke4 = borderStroke;
                            mutableInteractionSource3 = obj6;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SuggestionChip$1
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

                                public final void invoke(Composer composer3, int i26) {
                                    ChipKt.SuggestionChip(function0, function2, obj2, z5, function24, shape4, chipColors4, chipElevation3, borderStroke4, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    obj6 = mutableInteractionSource;
                    int i192 = i3;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    int i202 = i9;
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    function23 = obj7;
                    obj2 = modifier2;
                    chipElevation2 = obj5;
                    shape3 = shape2;
                    z4 = z3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i212 = i13 << 6;
                    int i222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i212 & 7168) | (i212 & 3670016);
                    int i232 = i13 << 9;
                    int i242 = i222 | (234881024 & i232) | (i232 & 1879048192);
                    int i252 = i13 >> 21;
                    ChipColors chipColors52 = chipColors2;
                    Function2<? super Composer, ? super Integer, Unit> function252 = obj;
                    Modifier modifier32 = obj2;
                    m1677ChipnkUnTEs(modifier32, function02, z4, function252, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i11), chipColors2.m1668labelColorvNxB06k$material3_release(z4), function23, null, shape3, chipColors52, chipElevation2, borderStroke3, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i242, (i252 & 112) | (i252 & 14) | 3456 | ((i13 >> 15) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    obj2 = modifier32;
                    z5 = z4;
                    function24 = function23;
                    shape4 = shape3;
                    chipColors4 = chipColors52;
                    chipElevation3 = chipElevation2;
                    borderStroke4 = borderStroke3;
                    mutableInteractionSource3 = mutableInteractionSource2;
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
                obj6 = mutableInteractionSource;
                int i1922 = i3;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i18 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                int i2022 = i9;
                if ((i2 & 128) != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                if (i8 != 0) {
                }
                function23 = obj7;
                obj2 = modifier2;
                chipElevation2 = obj5;
                shape3 = shape2;
                z4 = z3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i2122 = i13 << 6;
                int i2222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i2122 & 7168) | (i2122 & 3670016);
                int i2322 = i13 << 9;
                int i2422 = i2222 | (234881024 & i2322) | (i2322 & 1879048192);
                int i2522 = i13 >> 21;
                ChipColors chipColors522 = chipColors2;
                Function2<? super Composer, ? super Integer, Unit> function2522 = obj;
                Modifier modifier322 = obj2;
                m1677ChipnkUnTEs(modifier322, function02, z4, function2522, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i11), chipColors2.m1668labelColorvNxB06k$material3_release(z4), function23, null, shape3, chipColors522, chipElevation2, borderStroke3, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i2422, (i2522 & 112) | (i2522 & 14) | 3456 | ((i13 >> 15) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                obj2 = modifier322;
                z5 = z4;
                function24 = function23;
                shape4 = shape3;
                chipColors4 = chipColors522;
                chipElevation3 = chipElevation2;
                borderStroke4 = borderStroke3;
                mutableInteractionSource3 = mutableInteractionSource2;
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
            obj6 = mutableInteractionSource;
            int i19222 = i3;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i18 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            int i20222 = i9;
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if (i8 != 0) {
            }
            function23 = obj7;
            obj2 = modifier2;
            chipElevation2 = obj5;
            shape3 = shape2;
            z4 = z3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i21222 = i13 << 6;
            int i22222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i21222 & 7168) | (i21222 & 3670016);
            int i23222 = i13 << 9;
            int i24222 = i22222 | (234881024 & i23222) | (i23222 & 1879048192);
            int i25222 = i13 >> 21;
            ChipColors chipColors5222 = chipColors2;
            Function2<? super Composer, ? super Integer, Unit> function25222 = obj;
            Modifier modifier3222 = obj2;
            m1677ChipnkUnTEs(modifier3222, function02, z4, function25222, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i11), chipColors2.m1668labelColorvNxB06k$material3_release(z4), function23, null, shape3, chipColors5222, chipElevation2, borderStroke3, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i24222, (i25222 & 112) | (i25222 & 14) | 3456 | ((i13 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            obj2 = modifier3222;
            z5 = z4;
            function24 = function23;
            shape4 = shape3;
            chipColors4 = chipColors5222;
            chipElevation3 = chipElevation2;
            borderStroke4 = borderStroke3;
            mutableInteractionSource3 = mutableInteractionSource2;
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
        obj6 = mutableInteractionSource;
        int i192222 = i3;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i18 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        int i202222 = i9;
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if (i8 != 0) {
        }
        function23 = obj7;
        obj2 = modifier2;
        chipElevation2 = obj5;
        shape3 = shape2;
        z4 = z3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i212222 = i13 << 6;
        int i222222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i212222 & 7168) | (i212222 & 3670016);
        int i232222 = i13 << 9;
        int i242222 = i222222 | (234881024 & i232222) | (i232222 & 1879048192);
        int i252222 = i13 >> 21;
        ChipColors chipColors52222 = chipColors2;
        Function2<? super Composer, ? super Integer, Unit> function252222 = obj;
        Modifier modifier32222 = obj2;
        m1677ChipnkUnTEs(modifier32222, function02, z4, function252222, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i11), chipColors2.m1668labelColorvNxB06k$material3_release(z4), function23, null, shape3, chipColors52222, chipElevation2, borderStroke3, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i242222, (i252222 & 112) | (i252222 & 14) | 3456 | ((i13 >> 15) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        obj2 = modifier32222;
        z5 = z4;
        function24 = function23;
        shape4 = shape3;
        chipColors4 = chipColors52222;
        chipElevation3 = chipElevation2;
        borderStroke4 = borderStroke3;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0308  */
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
        Object obj7;
        int i9;
        Shape shape2;
        ChipColors chipColors2;
        int i10;
        Composer composer2;
        ChipBorder chipBorder2;
        MutableInteractionSource mutableInteractionSource2;
        ChipColors chipColors3;
        Function2 function23;
        int i11;
        ChipElevation chipElevation2;
        boolean z3;
        Shape shape3;
        Composer composer3;
        final ChipBorder chipBorder3;
        final boolean z4;
        final Function2 function24;
        final Shape shape4;
        final ChipColors chipColors4;
        final ChipElevation chipElevation3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i12;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(170629701);
        ComposerKt.sourceInformation(startRestartGroup, "C(SuggestionChip)P(8,6,7,3,4,9,1,2)824@39441L5,825@39496L22,826@39575L25,827@39651L22,828@39725L39,835@39946L5,830@39774L568:Chip.kt#uh7d8r");
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
        int i16 = i2 & 4;
        if (i16 != 0) {
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
                                i15 = 131072;
                                i3 |= i15;
                            }
                        } else {
                            obj4 = shape;
                        }
                        i15 = 65536;
                        i3 |= i15;
                    } else {
                        obj4 = shape;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            obj5 = chipColors;
                            if (startRestartGroup.changed(obj5)) {
                                i14 = 1048576;
                                i3 |= i14;
                            }
                        } else {
                            obj5 = chipColors;
                        }
                        i14 = 524288;
                        i3 |= i14;
                    } else {
                        obj5 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            obj6 = chipElevation;
                            if (startRestartGroup.changed(obj6)) {
                                i13 = 8388608;
                                i3 |= i13;
                            }
                        } else {
                            obj6 = chipElevation;
                        }
                        i13 = 4194304;
                        i3 |= i13;
                    } else {
                        i6 = 12582912;
                        obj6 = chipElevation;
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & 256) == 0 && startRestartGroup.changed(chipBorder)) {
                            i12 = 67108864;
                            i3 |= i12;
                        }
                        i12 = 33554432;
                        i3 |= i12;
                    }
                    i7 = i2 & 512;
                    if (i7 == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i8 = i7;
                        obj7 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(obj7) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        int i17 = i3;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i16 != 0 ? Modifier.Companion : obj2;
                                boolean z5 = i4 != 0 ? true : z2;
                                Object obj8 = i5 != 0 ? null : obj3;
                                if ((i2 & 32) != 0) {
                                    i9 = i17 & (-458753);
                                    shape2 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    i9 = i17;
                                    shape2 = obj4;
                                }
                                if ((i2 & 64) != 0) {
                                    i9 &= -3670017;
                                    chipColors2 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(startRestartGroup, 6);
                                } else {
                                    chipColors2 = obj5;
                                }
                                int i18 = i9;
                                if ((i2 & 128) != 0) {
                                    composer2 = startRestartGroup;
                                    i18 &= -29360129;
                                    i10 = 6;
                                    obj6 = SuggestionChipDefaults.INSTANCE.m2346suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, 1572864, 63);
                                } else {
                                    i10 = 6;
                                    composer2 = startRestartGroup;
                                }
                                if ((i2 & 256) != 0) {
                                    startRestartGroup = composer2;
                                    chipBorder2 = SuggestionChipDefaults.INSTANCE.m2343suggestionChipBorderd_3_b6Q(0L, 0L, 0.0f, startRestartGroup, 3072, 7);
                                    i18 &= -234881025;
                                } else {
                                    startRestartGroup = composer2;
                                    chipBorder2 = chipBorder;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1248029210, "CC(remember):Chip.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.Companion.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    obj2 = companion;
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    obj2 = companion;
                                }
                                chipColors3 = chipColors2;
                                function23 = obj8;
                                i11 = i18;
                                chipElevation2 = obj6;
                                z3 = z5;
                                shape3 = shape2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i17 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    i17 &= -3670017;
                                }
                                if ((i2 & 128) != 0) {
                                    i17 &= -29360129;
                                }
                                if ((i2 & 256) != 0) {
                                    i17 &= -234881025;
                                }
                                chipBorder2 = chipBorder;
                                mutableInteractionSource2 = mutableInteractionSource;
                                function23 = obj3;
                                shape3 = obj4;
                                chipColors3 = obj5;
                                chipElevation2 = obj6;
                                i10 = 6;
                                z3 = z2;
                                i11 = i17;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(170629701, i11, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:830)");
                            }
                            TextStyle value = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i10);
                            long m1668labelColorvNxB06k$material3_release = chipColors3.m1668labelColorvNxB06k$material3_release(z3);
                            startRestartGroup.startReplaceGroup(1248043208);
                            ComposerKt.sourceInformation(startRestartGroup, "842@40163L21");
                            State<BorderStroke> borderStroke$material3_release = chipBorder2 == null ? null : chipBorder2.borderStroke$material3_release(z3, startRestartGroup, ((i11 >> 9) & 14) | ((i11 >> 21) & 112));
                            startRestartGroup.endReplaceGroup();
                            BorderStroke value2 = borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null;
                            int i19 = i11 << 6;
                            int i20 = ((i11 >> 6) & 14) | i6 | ((i11 << 3) & 112) | ((i11 >> 3) & 896) | (i19 & 7168) | (i19 & 3670016);
                            int i21 = i11 << 9;
                            ChipColors chipColors5 = chipColors3;
                            composer3 = startRestartGroup;
                            Function2 function25 = obj;
                            Modifier modifier2 = obj2;
                            m1677ChipnkUnTEs(modifier2, function02, z3, function25, value, m1668labelColorvNxB06k$material3_release, function23, null, shape3, chipColors5, chipElevation2, value2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, composer3, i20 | (234881024 & i21) | (i21 & 1879048192), ((i11 >> 21) & 14) | 3456 | ((i11 >> 15) & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipBorder3 = chipBorder2;
                            obj2 = modifier2;
                            z4 = z3;
                            function24 = function23;
                            shape4 = shape3;
                            chipColors4 = chipColors5;
                            chipElevation3 = chipElevation2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            z4 = z2;
                            composer3 = startRestartGroup;
                            function24 = obj3;
                            shape4 = obj4;
                            chipColors4 = obj5;
                            chipElevation3 = obj6;
                            chipBorder3 = chipBorder;
                            mutableInteractionSource3 = obj7;
                        }
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SuggestionChip$3
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

                                public final void invoke(Composer composer4, int i22) {
                                    ChipKt.SuggestionChip(function0, function2, obj2, z4, function24, shape4, chipColors4, chipElevation3, chipBorder3, mutableInteractionSource3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    obj7 = mutableInteractionSource;
                    int i172 = i3;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    int i182 = i9;
                    if ((i2 & 128) != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    chipColors3 = chipColors2;
                    function23 = obj8;
                    i11 = i182;
                    chipElevation2 = obj6;
                    z3 = z5;
                    shape3 = shape2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle value3 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i10);
                    long m1668labelColorvNxB06k$material3_release2 = chipColors3.m1668labelColorvNxB06k$material3_release(z3);
                    startRestartGroup.startReplaceGroup(1248043208);
                    ComposerKt.sourceInformation(startRestartGroup, "842@40163L21");
                    if (chipBorder2 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    if (borderStroke$material3_release != null) {
                    }
                    int i192 = i11 << 6;
                    int i202 = ((i11 >> 6) & 14) | i6 | ((i11 << 3) & 112) | ((i11 >> 3) & 896) | (i192 & 7168) | (i192 & 3670016);
                    int i212 = i11 << 9;
                    ChipColors chipColors52 = chipColors3;
                    composer3 = startRestartGroup;
                    Function2 function252 = obj;
                    Modifier modifier22 = obj2;
                    m1677ChipnkUnTEs(modifier22, function02, z3, function252, value3, m1668labelColorvNxB06k$material3_release2, function23, null, shape3, chipColors52, chipElevation2, value2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, composer3, i202 | (234881024 & i212) | (i212 & 1879048192), ((i11 >> 21) & 14) | 3456 | ((i11 >> 15) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    chipBorder3 = chipBorder2;
                    obj2 = modifier22;
                    z4 = z3;
                    function24 = function23;
                    shape4 = shape3;
                    chipColors4 = chipColors52;
                    chipElevation3 = chipElevation2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer3.endRestartGroup();
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
                obj7 = mutableInteractionSource;
                int i1722 = i3;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i16 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                int i1822 = i9;
                if ((i2 & 128) != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                if (i8 != 0) {
                }
                chipColors3 = chipColors2;
                function23 = obj8;
                i11 = i1822;
                chipElevation2 = obj6;
                z3 = z5;
                shape3 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle value32 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i10);
                long m1668labelColorvNxB06k$material3_release22 = chipColors3.m1668labelColorvNxB06k$material3_release(z3);
                startRestartGroup.startReplaceGroup(1248043208);
                ComposerKt.sourceInformation(startRestartGroup, "842@40163L21");
                if (chipBorder2 == null) {
                }
                startRestartGroup.endReplaceGroup();
                if (borderStroke$material3_release != null) {
                }
                int i1922 = i11 << 6;
                int i2022 = ((i11 >> 6) & 14) | i6 | ((i11 << 3) & 112) | ((i11 >> 3) & 896) | (i1922 & 7168) | (i1922 & 3670016);
                int i2122 = i11 << 9;
                ChipColors chipColors522 = chipColors3;
                composer3 = startRestartGroup;
                Function2 function2522 = obj;
                Modifier modifier222 = obj2;
                m1677ChipnkUnTEs(modifier222, function02, z3, function2522, value32, m1668labelColorvNxB06k$material3_release22, function23, null, shape3, chipColors522, chipElevation2, value2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, composer3, i2022 | (234881024 & i2122) | (i2122 & 1879048192), ((i11 >> 21) & 14) | 3456 | ((i11 >> 15) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                chipBorder3 = chipBorder2;
                obj2 = modifier222;
                z4 = z3;
                function24 = function23;
                shape4 = shape3;
                chipColors4 = chipColors522;
                chipElevation3 = chipElevation2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer3.endRestartGroup();
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
            obj7 = mutableInteractionSource;
            int i17222 = i3;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i16 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            int i18222 = i9;
            if ((i2 & 128) != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if (i8 != 0) {
            }
            chipColors3 = chipColors2;
            function23 = obj8;
            i11 = i18222;
            chipElevation2 = obj6;
            z3 = z5;
            shape3 = shape2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle value322 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i10);
            long m1668labelColorvNxB06k$material3_release222 = chipColors3.m1668labelColorvNxB06k$material3_release(z3);
            startRestartGroup.startReplaceGroup(1248043208);
            ComposerKt.sourceInformation(startRestartGroup, "842@40163L21");
            if (chipBorder2 == null) {
            }
            startRestartGroup.endReplaceGroup();
            if (borderStroke$material3_release != null) {
            }
            int i19222 = i11 << 6;
            int i20222 = ((i11 >> 6) & 14) | i6 | ((i11 << 3) & 112) | ((i11 >> 3) & 896) | (i19222 & 7168) | (i19222 & 3670016);
            int i21222 = i11 << 9;
            ChipColors chipColors5222 = chipColors3;
            composer3 = startRestartGroup;
            Function2 function25222 = obj;
            Modifier modifier2222 = obj2;
            m1677ChipnkUnTEs(modifier2222, function02, z3, function25222, value322, m1668labelColorvNxB06k$material3_release222, function23, null, shape3, chipColors5222, chipElevation2, value2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, composer3, i20222 | (234881024 & i21222) | (i21222 & 1879048192), ((i11 >> 21) & 14) | 3456 | ((i11 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            chipBorder3 = chipBorder2;
            obj2 = modifier2222;
            z4 = z3;
            function24 = function23;
            shape4 = shape3;
            chipColors4 = chipColors5222;
            chipElevation3 = chipElevation2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer3.endRestartGroup();
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
        obj7 = mutableInteractionSource;
        int i172222 = i3;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i16 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        int i182222 = i9;
        if ((i2 & 128) != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if (i8 != 0) {
        }
        chipColors3 = chipColors2;
        function23 = obj8;
        i11 = i182222;
        chipElevation2 = obj6;
        z3 = z5;
        shape3 = shape2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle value3222 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i10);
        long m1668labelColorvNxB06k$material3_release2222 = chipColors3.m1668labelColorvNxB06k$material3_release(z3);
        startRestartGroup.startReplaceGroup(1248043208);
        ComposerKt.sourceInformation(startRestartGroup, "842@40163L21");
        if (chipBorder2 == null) {
        }
        startRestartGroup.endReplaceGroup();
        if (borderStroke$material3_release != null) {
        }
        int i192222 = i11 << 6;
        int i202222 = ((i11 >> 6) & 14) | i6 | ((i11 << 3) & 112) | ((i11 >> 3) & 896) | (i192222 & 7168) | (i192222 & 3670016);
        int i212222 = i11 << 9;
        ChipColors chipColors52222 = chipColors3;
        composer3 = startRestartGroup;
        Function2 function252222 = obj;
        Modifier modifier22222 = obj2;
        m1677ChipnkUnTEs(modifier22222, function02, z3, function252222, value3222, m1668labelColorvNxB06k$material3_release2222, function23, null, shape3, chipColors52222, chipElevation2, value2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, composer3, i202222 | (234881024 & i212222) | (i212222 & 1879048192), ((i11 >> 21) & 14) | 3456 | ((i11 >> 15) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        chipBorder3 = chipBorder2;
        obj2 = modifier22222;
        z4 = z3;
        function24 = function23;
        shape4 = shape3;
        chipColors4 = chipColors52222;
        chipElevation3 = chipElevation2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
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
        Object obj6;
        Modifier.Companion companion;
        int i11;
        Shape shape2;
        ChipColors chipColors3;
        int i12;
        BorderStroke borderStroke2;
        int i13;
        MutableInteractionSource mutableInteractionSource2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        ChipElevation chipElevation2;
        boolean z3;
        Shape shape3;
        Composer composer2;
        final boolean z4;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final Shape shape4;
        final ChipColors chipColors4;
        final ChipElevation chipElevation3;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-818834969);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)897@43055L5,898@43110L30,899@43197L33,908@43503L5,903@43331L538:Chip.kt#uh7d8r");
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
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i15 = 1048576;
                                i3 |= i15;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i15 = 524288;
                        i3 |= i15;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            obj5 = chipElevation;
                            if (startRestartGroup.changed(obj5)) {
                                i14 = 8388608;
                                i3 |= i14;
                            }
                        } else {
                            obj5 = chipElevation;
                        }
                        i14 = 4194304;
                        i3 |= i14;
                    } else {
                        i6 = 12582912;
                        obj5 = chipElevation;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i17;
                        i3 |= startRestartGroup.changed(borderStroke) ? 67108864 : 33554432;
                        i9 = i2 & 512;
                        if (i9 != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i10 = i9;
                            obj6 = mutableInteractionSource;
                            i3 |= startRestartGroup.changed(obj6) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            int i18 = i3;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i8 == 0 ? Modifier.Companion : obj2;
                                    boolean z5 = i4 == 0 ? true : z2;
                                    Object obj7 = i5 == 0 ? null : obj3;
                                    if ((i2 & 32) == 0) {
                                        i11 = i18 & (-458753);
                                        shape2 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    } else {
                                        i11 = i18;
                                        shape2 = obj4;
                                    }
                                    if ((i2 & 64) == 0) {
                                        i11 &= -3670017;
                                        chipColors3 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(startRestartGroup, 6);
                                    } else {
                                        chipColors3 = chipColors2;
                                    }
                                    int i19 = i11;
                                    if ((i2 & 128) == 0) {
                                        i19 &= -29360129;
                                        i12 = 6;
                                        obj5 = SuggestionChipDefaults.INSTANCE.m2340elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    } else {
                                        i12 = 6;
                                    }
                                    int i20 = i19;
                                    borderStroke2 = i7 == 0 ? null : borderStroke;
                                    i13 = i20;
                                    if (i10 == 0) {
                                        chipColors2 = chipColors3;
                                        mutableInteractionSource2 = null;
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        chipColors2 = chipColors3;
                                    }
                                    function23 = obj7;
                                    chipElevation2 = obj5;
                                    z3 = z5;
                                    shape3 = shape2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 32) != 0) {
                                        i18 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i18 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i18 &= -29360129;
                                    }
                                    borderStroke2 = borderStroke;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    companion = obj2;
                                    function23 = obj3;
                                    shape3 = obj4;
                                    chipElevation2 = obj5;
                                    i13 = i18;
                                    i12 = 6;
                                    z3 = z2;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-818834969, i13, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:903)");
                                }
                                int i21 = i13 << 6;
                                int i22 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i21 & 7168) | (i21 & 3670016);
                                int i23 = i13 << 9;
                                int i24 = i22 | (234881024 & i23) | (i23 & 1879048192);
                                int i25 = i13 >> 21;
                                ChipColors chipColors5 = chipColors2;
                                Function2<? super Composer, ? super Integer, Unit> function25 = obj;
                                Modifier modifier2 = companion;
                                m1677ChipnkUnTEs(modifier2, function02, z3, function25, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), function23, null, shape3, chipColors5, chipElevation2, borderStroke2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i24, (i25 & 112) | (i25 & 14) | 3456 | ((i13 >> 15) & 57344));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                obj2 = modifier2;
                                z4 = z3;
                                function24 = function23;
                                shape4 = shape3;
                                chipColors4 = chipColors5;
                                chipElevation3 = chipElevation2;
                                borderStroke3 = borderStroke2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z4 = z2;
                                function24 = obj3;
                                composer2 = startRestartGroup;
                                shape4 = obj4;
                                chipColors4 = chipColors2;
                                chipElevation3 = obj5;
                                borderStroke3 = borderStroke;
                                mutableInteractionSource3 = obj6;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedSuggestionChip$1
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

                                    public final void invoke(Composer composer3, int i26) {
                                        ChipKt.ElevatedSuggestionChip(function0, function2, obj2, z4, function24, shape4, chipColors4, chipElevation3, borderStroke3, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i10 = i9;
                        obj6 = mutableInteractionSource;
                        int i182 = i3;
                        if ((i3 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        int i192 = i11;
                        if ((i2 & 128) == 0) {
                        }
                        int i202 = i192;
                        borderStroke2 = i7 == 0 ? null : borderStroke;
                        i13 = i202;
                        if (i10 == 0) {
                        }
                        function23 = obj7;
                        chipElevation2 = obj5;
                        z3 = z5;
                        shape3 = shape2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i212 = i13 << 6;
                        int i222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i212 & 7168) | (i212 & 3670016);
                        int i232 = i13 << 9;
                        int i242 = i222 | (234881024 & i232) | (i232 & 1879048192);
                        int i252 = i13 >> 21;
                        ChipColors chipColors52 = chipColors2;
                        Function2<? super Composer, ? super Integer, Unit> function252 = obj;
                        Modifier modifier22 = companion;
                        m1677ChipnkUnTEs(modifier22, function02, z3, function252, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), function23, null, shape3, chipColors52, chipElevation2, borderStroke2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i242, (i252 & 112) | (i252 & 14) | 3456 | ((i13 >> 15) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        obj2 = modifier22;
                        z4 = z3;
                        function24 = function23;
                        shape4 = shape3;
                        chipColors4 = chipColors52;
                        chipElevation3 = chipElevation2;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i17;
                    i9 = i2 & 512;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    obj6 = mutableInteractionSource;
                    int i1822 = i3;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if ((i2 & 32) == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    int i1922 = i11;
                    if ((i2 & 128) == 0) {
                    }
                    int i2022 = i1922;
                    borderStroke2 = i7 == 0 ? null : borderStroke;
                    i13 = i2022;
                    if (i10 == 0) {
                    }
                    function23 = obj7;
                    chipElevation2 = obj5;
                    z3 = z5;
                    shape3 = shape2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i2122 = i13 << 6;
                    int i2222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i2122 & 7168) | (i2122 & 3670016);
                    int i2322 = i13 << 9;
                    int i2422 = i2222 | (234881024 & i2322) | (i2322 & 1879048192);
                    int i2522 = i13 >> 21;
                    ChipColors chipColors522 = chipColors2;
                    Function2<? super Composer, ? super Integer, Unit> function2522 = obj;
                    Modifier modifier222 = companion;
                    m1677ChipnkUnTEs(modifier222, function02, z3, function2522, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), function23, null, shape3, chipColors522, chipElevation2, borderStroke2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i2422, (i2522 & 112) | (i2522 & 14) | 3456 | ((i13 >> 15) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    obj2 = modifier222;
                    z4 = z3;
                    function24 = function23;
                    shape4 = shape3;
                    chipColors4 = chipColors522;
                    chipElevation3 = chipElevation2;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource3 = mutableInteractionSource2;
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
                i8 = i17;
                i9 = i2 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                obj6 = mutableInteractionSource;
                int i18222 = i3;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                int i19222 = i11;
                if ((i2 & 128) == 0) {
                }
                int i20222 = i19222;
                borderStroke2 = i7 == 0 ? null : borderStroke;
                i13 = i20222;
                if (i10 == 0) {
                }
                function23 = obj7;
                chipElevation2 = obj5;
                z3 = z5;
                shape3 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i21222 = i13 << 6;
                int i22222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i21222 & 7168) | (i21222 & 3670016);
                int i23222 = i13 << 9;
                int i24222 = i22222 | (234881024 & i23222) | (i23222 & 1879048192);
                int i25222 = i13 >> 21;
                ChipColors chipColors5222 = chipColors2;
                Function2<? super Composer, ? super Integer, Unit> function25222 = obj;
                Modifier modifier2222 = companion;
                m1677ChipnkUnTEs(modifier2222, function02, z3, function25222, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), function23, null, shape3, chipColors5222, chipElevation2, borderStroke2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i24222, (i25222 & 112) | (i25222 & 14) | 3456 | ((i13 >> 15) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                obj2 = modifier2222;
                z4 = z3;
                function24 = function23;
                shape4 = shape3;
                chipColors4 = chipColors5222;
                chipElevation3 = chipElevation2;
                borderStroke3 = borderStroke2;
                mutableInteractionSource3 = mutableInteractionSource2;
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
            i8 = i17;
            i9 = i2 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            obj6 = mutableInteractionSource;
            int i182222 = i3;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            int i192222 = i11;
            if ((i2 & 128) == 0) {
            }
            int i202222 = i192222;
            borderStroke2 = i7 == 0 ? null : borderStroke;
            i13 = i202222;
            if (i10 == 0) {
            }
            function23 = obj7;
            chipElevation2 = obj5;
            z3 = z5;
            shape3 = shape2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i212222 = i13 << 6;
            int i222222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i212222 & 7168) | (i212222 & 3670016);
            int i232222 = i13 << 9;
            int i242222 = i222222 | (234881024 & i232222) | (i232222 & 1879048192);
            int i252222 = i13 >> 21;
            ChipColors chipColors52222 = chipColors2;
            Function2<? super Composer, ? super Integer, Unit> function252222 = obj;
            Modifier modifier22222 = companion;
            m1677ChipnkUnTEs(modifier22222, function02, z3, function252222, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), function23, null, shape3, chipColors52222, chipElevation2, borderStroke2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i242222, (i252222 & 112) | (i252222 & 14) | 3456 | ((i13 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            obj2 = modifier22222;
            z4 = z3;
            function24 = function23;
            shape4 = shape3;
            chipColors4 = chipColors52222;
            chipElevation3 = chipElevation2;
            borderStroke3 = borderStroke2;
            mutableInteractionSource3 = mutableInteractionSource2;
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
        i8 = i17;
        i9 = i2 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        obj6 = mutableInteractionSource;
        int i1822222 = i3;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        int i1922222 = i11;
        if ((i2 & 128) == 0) {
        }
        int i2022222 = i1922222;
        borderStroke2 = i7 == 0 ? null : borderStroke;
        i13 = i2022222;
        if (i10 == 0) {
        }
        function23 = obj7;
        chipElevation2 = obj5;
        z3 = z5;
        shape3 = shape2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2122222 = i13 << 6;
        int i2222222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i2122222 & 7168) | (i2122222 & 3670016);
        int i2322222 = i13 << 9;
        int i2422222 = i2222222 | (234881024 & i2322222) | (i2322222 & 1879048192);
        int i2522222 = i13 >> 21;
        ChipColors chipColors522222 = chipColors2;
        Function2<? super Composer, ? super Integer, Unit> function2522222 = obj;
        Modifier modifier222222 = companion;
        m1677ChipnkUnTEs(modifier222222, function02, z3, function2522222, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12), chipColors2.m1668labelColorvNxB06k$material3_release(z3), function23, null, shape3, chipColors522222, chipElevation2, borderStroke2, SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM(), SuggestionChipPadding, mutableInteractionSource2, startRestartGroup, i2422222, (i2522222 & 112) | (i2522222 & 14) | 3456 | ((i13 >> 15) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        obj2 = modifier222222;
        z4 = z3;
        function24 = function23;
        shape4 = shape3;
        chipColors4 = chipColors522222;
        chipElevation3 = chipElevation2;
        borderStroke3 = borderStroke2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:181:? A[RETURN, SYNTHETIC] */
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
        Object obj6;
        Modifier.Companion companion;
        int i11;
        Shape shape2;
        ChipColors chipColors3;
        int i12;
        ChipBorder chipBorder2;
        MutableInteractionSource mutableInteractionSource2;
        Function2 function23;
        int i13;
        ChipElevation chipElevation2;
        boolean z3;
        Shape shape3;
        final ChipBorder chipBorder3;
        Composer composer2;
        final boolean z4;
        final Function2 function24;
        final Shape shape4;
        final ChipColors chipColors4;
        final ChipElevation chipElevation3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(1668751803);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedSuggestionChip)P(8,6,7,3,4,9,1,2)980@46960L5,981@47015L30,982@47102L33,984@47219L39,991@47440L5,986@47268L568:Chip.kt#uh7d8r");
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
                            chipColors2 = chipColors;
                            if (startRestartGroup.changed(chipColors2)) {
                                i15 = 1048576;
                                i3 |= i15;
                            }
                        } else {
                            chipColors2 = chipColors;
                        }
                        i15 = 524288;
                        i3 |= i15;
                    } else {
                        chipColors2 = chipColors;
                    }
                    if ((i & 12582912) != 0) {
                        i6 = 12582912;
                        if ((i2 & 128) == 0) {
                            obj5 = chipElevation;
                            if (startRestartGroup.changed(obj5)) {
                                i14 = 8388608;
                                i3 |= i14;
                            }
                        } else {
                            obj5 = chipElevation;
                        }
                        i14 = 4194304;
                        i3 |= i14;
                    } else {
                        i6 = 12582912;
                        obj5 = chipElevation;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i17;
                        i3 |= startRestartGroup.changed(chipBorder) ? 67108864 : 33554432;
                        i9 = i2 & 512;
                        if (i9 != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i10 = i9;
                            obj6 = mutableInteractionSource;
                            i3 |= startRestartGroup.changed(obj6) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            int i18 = i3;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i8 == 0 ? Modifier.Companion : obj2;
                                    boolean z5 = i4 == 0 ? true : z2;
                                    Object obj7 = i5 == 0 ? null : obj3;
                                    if ((i2 & 32) == 0) {
                                        i11 = i18 & (-458753);
                                        shape2 = SuggestionChipDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                    } else {
                                        i11 = i18;
                                        shape2 = obj4;
                                    }
                                    if ((i2 & 64) == 0) {
                                        i11 &= -3670017;
                                        chipColors3 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(startRestartGroup, 6);
                                    } else {
                                        chipColors3 = chipColors2;
                                    }
                                    int i19 = i11;
                                    if ((i2 & 128) == 0) {
                                        i19 &= -29360129;
                                        i12 = 6;
                                        obj5 = SuggestionChipDefaults.INSTANCE.m2340elevatedSuggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 1572864, 63);
                                    } else {
                                        i12 = 6;
                                    }
                                    chipBorder2 = i7 == 0 ? null : chipBorder;
                                    if (i10 == 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2121795492, "CC(remember):Chip.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    chipColors2 = chipColors3;
                                    function23 = obj7;
                                    i13 = i19;
                                    chipElevation2 = obj5;
                                    z3 = z5;
                                    shape3 = shape2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 32) != 0) {
                                        i18 &= -458753;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i18 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i18 &= -29360129;
                                    }
                                    chipBorder2 = chipBorder;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    companion = obj2;
                                    function23 = obj3;
                                    shape3 = obj4;
                                    chipElevation2 = obj5;
                                    i12 = 6;
                                    z3 = z2;
                                    i13 = i18;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1668751803, i13, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:986)");
                                }
                                TextStyle value = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
                                long m1668labelColorvNxB06k$material3_release = chipColors2.m1668labelColorvNxB06k$material3_release(z3);
                                float m2341getHeightD9Ej5fM = SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM();
                                PaddingValues paddingValues = SuggestionChipPadding;
                                startRestartGroup.startReplaceGroup(2121812626);
                                ComposerKt.sourceInformation(startRestartGroup, "1000@47755L21");
                                State<BorderStroke> borderStroke$material3_release = chipBorder2 != null ? null : chipBorder2.borderStroke$material3_release(z3, startRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 21) & 112));
                                startRestartGroup.endReplaceGroup();
                                BorderStroke value2 = borderStroke$material3_release != null ? borderStroke$material3_release.getValue() : null;
                                int i20 = i13 << 6;
                                int i21 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i20 & 7168) | (i20 & 3670016);
                                int i22 = i13 << 9;
                                ChipColors chipColors5 = chipColors2;
                                Function2 function25 = obj;
                                Modifier modifier2 = companion;
                                m1677ChipnkUnTEs(modifier2, function02, z3, function25, value, m1668labelColorvNxB06k$material3_release, function23, null, shape3, chipColors5, chipElevation2, value2, m2341getHeightD9Ej5fM, paddingValues, mutableInteractionSource2, startRestartGroup, i21 | (234881024 & i22) | (i22 & 1879048192), ((i13 >> 21) & 14) | 3456 | ((i13 >> 15) & 57344));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                chipBorder3 = chipBorder2;
                                composer2 = startRestartGroup;
                                obj2 = modifier2;
                                z4 = z3;
                                function24 = function23;
                                shape4 = shape3;
                                chipColors4 = chipColors5;
                                chipElevation3 = chipElevation2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z4 = z2;
                                function24 = obj3;
                                composer2 = startRestartGroup;
                                shape4 = obj4;
                                chipColors4 = chipColors2;
                                chipElevation3 = obj5;
                                chipBorder3 = chipBorder;
                                mutableInteractionSource3 = obj6;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ElevatedSuggestionChip$3
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

                                    public final void invoke(Composer composer3, int i23) {
                                        ChipKt.ElevatedSuggestionChip(function0, function2, obj2, z4, function24, shape4, chipColors4, chipElevation3, chipBorder3, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i10 = i9;
                        obj6 = mutableInteractionSource;
                        int i182 = i3;
                        if ((i3 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if ((i2 & 32) == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        int i192 = i11;
                        if ((i2 & 128) == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        chipColors2 = chipColors3;
                        function23 = obj7;
                        i13 = i192;
                        chipElevation2 = obj5;
                        z3 = z5;
                        shape3 = shape2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        TextStyle value3 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
                        long m1668labelColorvNxB06k$material3_release2 = chipColors2.m1668labelColorvNxB06k$material3_release(z3);
                        float m2341getHeightD9Ej5fM2 = SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM();
                        PaddingValues paddingValues2 = SuggestionChipPadding;
                        startRestartGroup.startReplaceGroup(2121812626);
                        ComposerKt.sourceInformation(startRestartGroup, "1000@47755L21");
                        if (chipBorder2 != null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        if (borderStroke$material3_release != null) {
                        }
                        int i202 = i13 << 6;
                        int i212 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i202 & 7168) | (i202 & 3670016);
                        int i222 = i13 << 9;
                        ChipColors chipColors52 = chipColors2;
                        Function2 function252 = obj;
                        Modifier modifier22 = companion;
                        m1677ChipnkUnTEs(modifier22, function02, z3, function252, value3, m1668labelColorvNxB06k$material3_release2, function23, null, shape3, chipColors52, chipElevation2, value2, m2341getHeightD9Ej5fM2, paddingValues2, mutableInteractionSource2, startRestartGroup, i212 | (234881024 & i222) | (i222 & 1879048192), ((i13 >> 21) & 14) | 3456 | ((i13 >> 15) & 57344));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        chipBorder3 = chipBorder2;
                        composer2 = startRestartGroup;
                        obj2 = modifier22;
                        z4 = z3;
                        function24 = function23;
                        shape4 = shape3;
                        chipColors4 = chipColors52;
                        chipElevation3 = chipElevation2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i17;
                    i9 = i2 & 512;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    obj6 = mutableInteractionSource;
                    int i1822 = i3;
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if ((i2 & 32) == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    int i1922 = i11;
                    if ((i2 & 128) == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    chipColors2 = chipColors3;
                    function23 = obj7;
                    i13 = i1922;
                    chipElevation2 = obj5;
                    z3 = z5;
                    shape3 = shape2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    TextStyle value32 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
                    long m1668labelColorvNxB06k$material3_release22 = chipColors2.m1668labelColorvNxB06k$material3_release(z3);
                    float m2341getHeightD9Ej5fM22 = SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM();
                    PaddingValues paddingValues22 = SuggestionChipPadding;
                    startRestartGroup.startReplaceGroup(2121812626);
                    ComposerKt.sourceInformation(startRestartGroup, "1000@47755L21");
                    if (chipBorder2 != null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    if (borderStroke$material3_release != null) {
                    }
                    int i2022 = i13 << 6;
                    int i2122 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i2022 & 7168) | (i2022 & 3670016);
                    int i2222 = i13 << 9;
                    ChipColors chipColors522 = chipColors2;
                    Function2 function2522 = obj;
                    Modifier modifier222 = companion;
                    m1677ChipnkUnTEs(modifier222, function02, z3, function2522, value32, m1668labelColorvNxB06k$material3_release22, function23, null, shape3, chipColors522, chipElevation2, value2, m2341getHeightD9Ej5fM22, paddingValues22, mutableInteractionSource2, startRestartGroup, i2122 | (234881024 & i2222) | (i2222 & 1879048192), ((i13 >> 21) & 14) | 3456 | ((i13 >> 15) & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    chipBorder3 = chipBorder2;
                    composer2 = startRestartGroup;
                    obj2 = modifier222;
                    z4 = z3;
                    function24 = function23;
                    shape4 = shape3;
                    chipColors4 = chipColors522;
                    chipElevation3 = chipElevation2;
                    mutableInteractionSource3 = mutableInteractionSource2;
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
                i8 = i17;
                i9 = i2 & 512;
                if (i9 != 0) {
                }
                i10 = i9;
                obj6 = mutableInteractionSource;
                int i18222 = i3;
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                int i19222 = i11;
                if ((i2 & 128) == 0) {
                }
                if (i7 == 0) {
                }
                if (i10 == 0) {
                }
                chipColors2 = chipColors3;
                function23 = obj7;
                i13 = i19222;
                chipElevation2 = obj5;
                z3 = z5;
                shape3 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                TextStyle value322 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
                long m1668labelColorvNxB06k$material3_release222 = chipColors2.m1668labelColorvNxB06k$material3_release(z3);
                float m2341getHeightD9Ej5fM222 = SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM();
                PaddingValues paddingValues222 = SuggestionChipPadding;
                startRestartGroup.startReplaceGroup(2121812626);
                ComposerKt.sourceInformation(startRestartGroup, "1000@47755L21");
                if (chipBorder2 != null) {
                }
                startRestartGroup.endReplaceGroup();
                if (borderStroke$material3_release != null) {
                }
                int i20222 = i13 << 6;
                int i21222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i20222 & 7168) | (i20222 & 3670016);
                int i22222 = i13 << 9;
                ChipColors chipColors5222 = chipColors2;
                Function2 function25222 = obj;
                Modifier modifier2222 = companion;
                m1677ChipnkUnTEs(modifier2222, function02, z3, function25222, value322, m1668labelColorvNxB06k$material3_release222, function23, null, shape3, chipColors5222, chipElevation2, value2, m2341getHeightD9Ej5fM222, paddingValues222, mutableInteractionSource2, startRestartGroup, i21222 | (234881024 & i22222) | (i22222 & 1879048192), ((i13 >> 21) & 14) | 3456 | ((i13 >> 15) & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                chipBorder3 = chipBorder2;
                composer2 = startRestartGroup;
                obj2 = modifier2222;
                z4 = z3;
                function24 = function23;
                shape4 = shape3;
                chipColors4 = chipColors5222;
                chipElevation3 = chipElevation2;
                mutableInteractionSource3 = mutableInteractionSource2;
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
            i8 = i17;
            i9 = i2 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            obj6 = mutableInteractionSource;
            int i182222 = i3;
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            int i192222 = i11;
            if ((i2 & 128) == 0) {
            }
            if (i7 == 0) {
            }
            if (i10 == 0) {
            }
            chipColors2 = chipColors3;
            function23 = obj7;
            i13 = i192222;
            chipElevation2 = obj5;
            z3 = z5;
            shape3 = shape2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            TextStyle value3222 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
            long m1668labelColorvNxB06k$material3_release2222 = chipColors2.m1668labelColorvNxB06k$material3_release(z3);
            float m2341getHeightD9Ej5fM2222 = SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM();
            PaddingValues paddingValues2222 = SuggestionChipPadding;
            startRestartGroup.startReplaceGroup(2121812626);
            ComposerKt.sourceInformation(startRestartGroup, "1000@47755L21");
            if (chipBorder2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            if (borderStroke$material3_release != null) {
            }
            int i202222 = i13 << 6;
            int i212222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i202222 & 7168) | (i202222 & 3670016);
            int i222222 = i13 << 9;
            ChipColors chipColors52222 = chipColors2;
            Function2 function252222 = obj;
            Modifier modifier22222 = companion;
            m1677ChipnkUnTEs(modifier22222, function02, z3, function252222, value3222, m1668labelColorvNxB06k$material3_release2222, function23, null, shape3, chipColors52222, chipElevation2, value2, m2341getHeightD9Ej5fM2222, paddingValues2222, mutableInteractionSource2, startRestartGroup, i212222 | (234881024 & i222222) | (i222222 & 1879048192), ((i13 >> 21) & 14) | 3456 | ((i13 >> 15) & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            chipBorder3 = chipBorder2;
            composer2 = startRestartGroup;
            obj2 = modifier22222;
            z4 = z3;
            function24 = function23;
            shape4 = shape3;
            chipColors4 = chipColors52222;
            chipElevation3 = chipElevation2;
            mutableInteractionSource3 = mutableInteractionSource2;
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
        i8 = i17;
        i9 = i2 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        obj6 = mutableInteractionSource;
        int i1822222 = i3;
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        int i1922222 = i11;
        if ((i2 & 128) == 0) {
        }
        if (i7 == 0) {
        }
        if (i10 == 0) {
        }
        chipColors2 = chipColors3;
        function23 = obj7;
        i13 = i1922222;
        chipElevation2 = obj5;
        z3 = z5;
        shape3 = shape2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        TextStyle value32222 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), startRestartGroup, i12);
        long m1668labelColorvNxB06k$material3_release22222 = chipColors2.m1668labelColorvNxB06k$material3_release(z3);
        float m2341getHeightD9Ej5fM22222 = SuggestionChipDefaults.INSTANCE.m2341getHeightD9Ej5fM();
        PaddingValues paddingValues22222 = SuggestionChipPadding;
        startRestartGroup.startReplaceGroup(2121812626);
        ComposerKt.sourceInformation(startRestartGroup, "1000@47755L21");
        if (chipBorder2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        if (borderStroke$material3_release != null) {
        }
        int i2022222 = i13 << 6;
        int i2122222 = ((i13 >> 6) & 14) | i6 | ((i13 << 3) & 112) | ((i13 >> 3) & 896) | (i2022222 & 7168) | (i2022222 & 3670016);
        int i2222222 = i13 << 9;
        ChipColors chipColors522222 = chipColors2;
        Function2 function2522222 = obj;
        Modifier modifier222222 = companion;
        m1677ChipnkUnTEs(modifier222222, function02, z3, function2522222, value32222, m1668labelColorvNxB06k$material3_release22222, function23, null, shape3, chipColors522222, chipElevation2, value2, m2341getHeightD9Ej5fM22222, paddingValues22222, mutableInteractionSource2, startRestartGroup, i2122222 | (234881024 & i2222222) | (i2222222 & 1879048192), ((i13 >> 21) & 14) | 3456 | ((i13 >> 15) & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        chipBorder3 = chipBorder2;
        composer2 = startRestartGroup;
        obj2 = modifier222222;
        z4 = z3;
        function24 = function23;
        shape4 = shape3;
        chipColors4 = chipColors522222;
        chipElevation3 = chipElevation2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Chip-nkUnTEs  reason: not valid java name */
    public static final void m1677ChipnkUnTEs(final Modifier modifier, final Function0<Unit> function0, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Shape shape, final ChipColors chipColors, final ChipElevation chipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        Composer startRestartGroup = composer.startRestartGroup(1400504719);
        ComposerKt.sourceInformation(startRestartGroup, "C(Chip)P(10,11,3,5,7,6:c#ui.graphics.Color,8,14,13,1,2!1,9:c#ui.unit.Dp,12)1975@97230L477,1966@96860L847:Chip.kt#uh7d8r");
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
        if ((i3 & 306783379) != 306783378 || (i5 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1400504719, i3, i5, "androidx.compose.material3.Chip (Chip.kt:1963)");
            }
            startRestartGroup.startReplaceGroup(1985614987);
            ComposerKt.sourceInformation(startRestartGroup, "1965@96816L39");
            if (mutableInteractionSource2 == null) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1985615638, "CC(remember):Chip.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5911getButtono7Vup1c());
                }
            }, 1, null);
            long m1658containerColorvNxB06k$material3_release = chipColors.m1658containerColorvNxB06k$material3_release(z);
            startRestartGroup.startReplaceGroup(1985624506);
            ComposerKt.sourceInformation(startRestartGroup, "1972@97093L43");
            State<Dp> shadowElevation$material3_release = chipElevation != null ? chipElevation.shadowElevation$material3_release(z, mutableInteractionSource2, startRestartGroup, ((i3 >> 6) & 14) | ((i5 << 6) & 896)) : null;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            int i6 = i3;
            final Function2<? super Composer, ? super Integer, Unit> function24 = obj;
            SurfaceKt.m2350Surfaceo_FOJdg(function0, semantics$default, z, shape, m1658containerColorvNxB06k$material3_release, 0L, 0.0f, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().m6698unboximpl() : Dp.m6684constructorimpl(0), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-1985962652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$2
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

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C1976@97240L461:Chip.kt#uh7d8r");
                    if ((i7 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1985962652, i7, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1976)");
                        }
                        ChipKt.m1678ChipContentfe0OD_I(function24, textStyle, j, function22, null, function23, chipColors.m1669leadingIconContentColorvNxB06k$material3_release(z), chipColors.m1670trailingIconContentColorvNxB06k$material3_release(z), f, paddingValues, composer3, 24576);
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
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$Chip$3
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

                public final void invoke(Composer composer3, int i7) {
                    ChipKt.m1677ChipnkUnTEs(Modifier.this, function0, z, function2, textStyle, j, function22, function23, shape, chipColors, chipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SelectableChip-u0RnIRE  reason: not valid java name */
    public static final void m1679SelectableChipu0RnIRE(final boolean z, final Modifier modifier, final Function0<Unit> function0, final boolean z2, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Shape shape, final SelectableChipColors selectableChipColors, final SelectableChipElevation selectableChipElevation, final BorderStroke borderStroke, final float f, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(402951308);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectableChip)P(13,10,11,4,6,7,8!1,15,14,2,3!1,9:c#ui.unit.Dp,12)2023@98879L525,2013@98468L936:Chip.kt#uh7d8r");
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
        if ((i3 & 306783379) != 306783378 || (74899 & i5) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(402951308, i3, i5, "androidx.compose.material3.SelectableChip (Chip.kt:2009)");
            }
            startRestartGroup.startReplaceGroup(2072749057);
            ComposerKt.sourceInformation(startRestartGroup, "2011@98346L39");
            if (mutableInteractionSource == null) {
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2072749708, "CC(remember):Chip.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
            }
            startRestartGroup.endReplaceGroup();
            int i6 = i3;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5930setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m5913getCheckboxo7Vup1c());
                }
            }, 1, null);
            long m2263containerColorWaAFU9c$material3_release = selectableChipColors.m2263containerColorWaAFU9c$material3_release(z2, z);
            startRestartGroup.startReplaceGroup(2072762384);
            ComposerKt.sourceInformation(startRestartGroup, "2020@98742L43");
            State<Dp> shadowElevation$material3_release = selectableChipElevation != null ? selectableChipElevation.shadowElevation$material3_release(z2, mutableInteractionSource2, startRestartGroup, ((i6 >> 9) & 14) | ((i5 << 3) & 896)) : null;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            SurfaceKt.m2348Surfaced85dljk(z, function0, semantics$default, z2, shape, m2263containerColorWaAFU9c$material3_release, 0L, 0.0f, shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().m6698unboximpl() : Dp.m6684constructorimpl(0), borderStroke, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-577614814, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$2
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

                public final void invoke(Composer composer3, int i7) {
                    ComposerKt.sourceInformation(composer3, "C2024@98889L509:Chip.kt#uh7d8r");
                    if ((i7 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-577614814, i7, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:2024)");
                        }
                        ChipKt.m1678ChipContentfe0OD_I(function2, textStyle, SelectableChipColors.this.m2265labelColorWaAFU9c$material3_release(z2, z), function22, function23, function24, SelectableChipColors.this.m2266leadingIconContentColorWaAFU9c$material3_release(z2, z), SelectableChipColors.this.m2267trailingIconContentColorWaAFU9c$material3_release(z2, z), f, paddingValues, composer3, 0);
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
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$SelectableChip$3
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

                public final void invoke(Composer composer3, int i7) {
                    ChipKt.m1679SelectableChipu0RnIRE(z, modifier, function0, z2, function2, textStyle, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, f, paddingValues, mutableInteractionSource, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ChipContent-fe0OD_I  reason: not valid java name */
    public static final void m1678ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, long j, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final long j2, final long j3, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        long j4;
        Object obj;
        Object obj2;
        Object obj3;
        long j5;
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-782878228);
        ComposerKt.sourceInformation(startRestartGroup, "C(ChipContent)P(1,3,2:c#ui.graphics.Color,4!1,8,5:c#ui.graphics.Color,9:c#ui.graphics.Color,6:c#ui.unit.Dp)2055@99907L3519,2052@99781L3645:Chip.kt#uh7d8r");
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
        if ((i3 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782878228, i3, -1, "androidx.compose.material3.ChipContent (Chip.kt:2051)");
            }
            final Function2<? super Composer, ? super Integer, Unit> function25 = obj;
            final Function2<? super Composer, ? super Integer, Unit> function26 = obj2;
            final Function2<? super Composer, ? super Integer, Unit> function27 = obj3;
            final long j6 = j5;
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j4)), TextKt.getLocalTextStyle().provides(textStyle)}, ComposableLambdaKt.rememberComposableLambda(1748799148, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$1
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
                    float f2;
                    ComposerKt.sourceInformation(composer2, "C2056@99917L3503:Chip.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1748799148, i4, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:2056)");
                        }
                        Modifier padding = PaddingKt.padding(SizeKt.m770defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, f, 1, null), paddingValues);
                        AnonymousClass1 anonymousClass1 = new MeasurePolicy() { // from class: androidx.compose.material3.ChipKt$ChipContent$1.1
                            @Override // androidx.compose.ui.layout.MeasurePolicy
                            /* renamed from: measure-3p2s80s */
                            public final MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j7) {
                                Measurable measurable;
                                Measurable measurable2;
                                int size = list.size();
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= size) {
                                        measurable = null;
                                        break;
                                    }
                                    measurable = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "leadingIcon")) {
                                        break;
                                    }
                                    i5++;
                                }
                                Measurable measurable3 = measurable;
                                final Placeable mo5438measureBRTryo0 = measurable3 != null ? measurable3.mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j7, 0, 0, 0, 0, 10, null)) : null;
                                final int widthOrZero = TextFieldImplKt.widthOrZero(mo5438measureBRTryo0);
                                final int heightOrZero = TextFieldImplKt.heightOrZero(mo5438measureBRTryo0);
                                int size2 = list.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size2) {
                                        measurable2 = null;
                                        break;
                                    }
                                    measurable2 = list.get(i6);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "trailingIcon")) {
                                        break;
                                    }
                                    i6++;
                                }
                                Measurable measurable4 = measurable2;
                                Placeable mo5438measureBRTryo02 = measurable4 != null ? measurable4.mo5438measureBRTryo0(Constraints.m6627copyZbe2FdA$default(j7, 0, 0, 0, 0, 10, null)) : null;
                                int widthOrZero2 = TextFieldImplKt.widthOrZero(mo5438measureBRTryo02);
                                final int heightOrZero2 = TextFieldImplKt.heightOrZero(mo5438measureBRTryo02);
                                int size3 = list.size();
                                for (int i7 = 0; i7 < size3; i7++) {
                                    Measurable measurable5 = list.get(i7);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), Constants.ScionAnalytics.PARAM_LABEL)) {
                                        final Placeable mo5438measureBRTryo03 = measurable5.mo5438measureBRTryo0(ConstraintsKt.m6657offsetNN6EwU$default(j7, -(widthOrZero + widthOrZero2), 0, 2, null));
                                        final int max = Math.max(heightOrZero, Math.max(mo5438measureBRTryo03.getHeight(), heightOrZero2));
                                        final Placeable placeable = mo5438measureBRTryo02;
                                        return MeasureScope.layout$default(measureScope, mo5438measureBRTryo03.getWidth() + widthOrZero + widthOrZero2, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ChipKt.ChipContent.1.1.1
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
                                                Placeable.PlacementScope placementScope2;
                                                Placeable placeable2 = Placeable.this;
                                                if (placeable2 != null) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, Alignment.Companion.getCenterVertically().align(heightOrZero, max), 0.0f, 4, null);
                                                    placementScope2 = placementScope;
                                                } else {
                                                    placementScope2 = placementScope;
                                                }
                                                Placeable.PlacementScope.placeRelative$default(placementScope2, mo5438measureBRTryo03, widthOrZero, 0, 0.0f, 4, null);
                                                Placeable placeable3 = placeable;
                                                if (placeable3 != null) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable3, widthOrZero + mo5438measureBRTryo03.getWidth(), Alignment.Companion.getCenterVertically().align(heightOrZero2, max), 0.0f, 4, null);
                                                }
                                            }
                                        }, 4, null);
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        };
                        Function2<Composer, Integer, Unit> function28 = function26;
                        Function2<Composer, Integer, Unit> function29 = function25;
                        Function2<Composer, Integer, Unit> function210 = function27;
                        long j7 = j6;
                        Function2<Composer, Integer, Unit> function211 = function2;
                        long j8 = j3;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, padding);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
                        Updater.m3527setimpl(m3520constructorimpl, anonymousClass1, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -1433527257, "C2075@100797L325:Chip.kt#uh7d8r");
                        composer2.startReplaceGroup(-1293169671);
                        ComposerKt.sourceInformation(composer2, "2060@100124L638");
                        if (function28 != null || function29 != null) {
                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, "leadingIcon");
                            Alignment center = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, layoutId);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(composer2);
                            Updater.m3527setimpl(m3520constructorimpl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 832670363, "C:Chip.kt#uh7d8r");
                            if (function28 != null) {
                                composer2.startReplaceGroup(832680499);
                                ComposerKt.sourceInformation(composer2, "2065@100383L8");
                                function28.invoke(composer2, 0);
                                composer2.endReplaceGroup();
                            } else if (function29 != null) {
                                composer2.startReplaceGroup(832788565);
                                ComposerKt.sourceInformation(composer2, "2067@100486L198");
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j7)), function29, composer2, ProvidedValue.$stable);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(833040347);
                                composer2.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                        }
                        composer2.endReplaceGroup();
                        Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.Companion, Constants.ScionAnalytics.PARAM_LABEL);
                        f2 = ChipKt.HorizontalElementsPadding;
                        Modifier m739paddingVpY3zN4 = PaddingKt.m739paddingVpY3zN4(layoutId2, f2, Dp.m6684constructorimpl(0));
                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m739paddingVpY3zN4);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3520constructorimpl3 = Updater.m3520constructorimpl(composer2);
                        Updater.m3527setimpl(m3520constructorimpl3, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 833418517, "C2080@101095L7:Chip.kt#uh7d8r");
                        function211.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.startReplaceGroup(-1293135324);
                        ComposerKt.sourceInformation(composer2, "2083@101187L442");
                        if (function210 != null) {
                            Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.Companion, "trailingIcon");
                            Alignment center2 = Alignment.Companion.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, layoutId3);
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor4);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3520constructorimpl4 = Updater.m3520constructorimpl(composer2);
                            Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                            }
                            Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 833719744, "C2087@101393L188:Chip.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4068boximpl(j8)), function210, composer2, ProvidedValue.$stable);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final long j7 = j4;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ChipKt$ChipContent$2
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
                    ChipKt.m1678ChipContentfe0OD_I(function2, textStyle, j7, function22, function23, function24, j2, j3, f, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme colorScheme) {
        ChipColors defaultSuggestionChipColorsCached$material3_release = colorScheme.getDefaultSuggestionChipColorsCached$material3_release();
        if (defaultSuggestionChipColorsCached$material3_release == null) {
            ChipColors chipColors = new ChipColors(Color.Companion.m4113getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getLeadingIconColor()), Color.Companion.m4114getUnspecified0d7_KjU(), Color.Companion.m4113getTransparent0d7_KjU(), Color.m4077copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLabelTextColor()), SuggestionChipTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m4077copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SuggestionChipTokens.INSTANCE.getDisabledLeadingIconColor()), SuggestionChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.Companion.m4114getUnspecified0d7_KjU(), null);
            colorScheme.setDefaultSuggestionChipColorsCached$material3_release(chipColors);
            return chipColors;
        }
        return defaultSuggestionChipColorsCached$material3_release;
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
        return PaddingKt.m735PaddingValuesa9UjIt4$default(Dp.m6684constructorimpl((z || !z2) ? 4 : 8), 0.0f, Dp.m6684constructorimpl(z3 ? 8 : 4), 0.0f, 10, null);
    }

    static {
        float m6684constructorimpl = Dp.m6684constructorimpl(8);
        HorizontalElementsPadding = m6684constructorimpl;
        AssistChipPadding = PaddingKt.m733PaddingValuesYgX7TsA$default(m6684constructorimpl, 0.0f, 2, null);
        FilterChipPadding = PaddingKt.m733PaddingValuesYgX7TsA$default(m6684constructorimpl, 0.0f, 2, null);
        SuggestionChipPadding = PaddingKt.m733PaddingValuesYgX7TsA$default(m6684constructorimpl, 0.0f, 2, null);
    }
}
