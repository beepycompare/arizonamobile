package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.DragGestureDetectorCopyKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a³\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010\u0019\u001as\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\u001b\u001a}\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001aä\u0001\u0010\u001f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\b\b\u0003\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010&\u001a\u0098\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020$2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00132\b\b\u0002\u0010\"\u001a\u00020\u00132\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010'\u001a_\u0010(\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010)\u001a`\u0010*\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\t2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002\u001a\u0080\u0001\u0010-\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00172\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017H\u0003¢\u0006\u0002\u0010.\u001a(\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0002\u001a2\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0003\u0018\u000106*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0082@¢\u0006\u0004\b=\u0010>\u001a\u0010\u0010?\u001a\u0002022\u0006\u0010\f\u001a\u00020\rH\u0002\u001a0\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002\u001a?\u0010@\u001a\u00020F2\u0006\u0010G\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010H\u001a\u00020F2\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u0003H\u0002¢\u0006\u0004\bI\u0010J\u001a \u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0002\u001a\u001c\u0010O\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010P\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001c\u0010Q\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\f\u0010R\u001a\u00020S*\u00020\u0003H\u0002\u001a$\u0010T\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0003\u001a,\u0010U\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001a\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0003\u001aC\u0010d\u001a\u00020\u00162\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010e\u001aM\u0010f\u001a\u00020$2\b\b\u0002\u0010g\u001a\u00020\u00032\b\b\u0002\u0010h\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0007¢\u0006\u0002\u0010i\u001a\u001d\u0010j\u001a\u00020F2\u0006\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010m\u001a\u001b\u0010j\u001a\u00020F2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0001¢\u0006\u0002\u0010o\"\u0016\u0010V\u001a\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010Y\"\u0016\u0010[\u001a\u00020WX\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b\\\u0010Y\"\u0010\u0010]\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010^\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010a\u001a\u00020_X\u0082\u0004¢\u0006\u0004\n\u0002\u0010`\"\u0010\u0010b\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010c\u001a\u00020WX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u001e\u0010p\u001a\u00020\t*\u00020F8@X\u0081\u0004¢\u0006\f\u0012\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0014\u0010u\u001a\u00020vX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010x¨\u0006y"}, d2 = {"Slider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "thumb", "Landroidx/compose/material3/SliderState;", "Landroidx/compose/runtime/Composable;", "track", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", RemoteConfigConstants.ResponseFieldKey.STATE, "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "VerticalSlider", "reverseDirection", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "RangeSlider", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "startInteractionSource", "endInteractionSource", "startThumb", "Landroidx/compose/material3/RangeSliderState;", "endThumb", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "slideOnKeyEvents", "onValueChangeState", "onValueChangeFinishedState", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stepsToTickFractions", "scale", "a1", "b1", "x1", "a2", "b2", "Landroidx/compose/material3/SliderRange;", "isStart", "x", "scale-2geJ7wY", "(ZFFJFF)J", "calcFraction", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "pos", "sliderSemantics", "rangeSliderStartThumbSemantics", "rangeSliderEndThumbSemantics", "formatForSemantics", "", "sliderTapModifier", "rangeSliderPressDragModifier", "TrackHeight", "Landroidx/compose/ui/unit/Dp;", "getTrackHeight", "()F", "F", "ThumbWidth", "getThumbWidth", "ThumbHeight", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "VerticalThumbSize", "ThumbTrackGapSize", "TrackInsideCornerSize", "rememberSliderState", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SliderState;", "rememberRangeSliderState", "activeRangeStart", "activeRangeEnd", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RangeSliderState;", "SliderRange", TtmlNode.START, "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "isSpecified", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "CornerSizeAlignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "getCornerSizeAlignmentLine", "()Landroidx/compose/ui/layout/VerticalAlignmentLine;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SliderKt {
    private static final VerticalAlignmentLine CornerSizeAlignmentLine;
    private static final float ThumbHeight;
    private static final long ThumbSize;
    private static final float ThumbTrackGapSize;
    private static final float ThumbWidth;
    private static final float TrackHeight = SliderTokens.INSTANCE.m3728getInactiveTrackHeightD9Ej5fM();
    private static final float TrackInsideCornerSize;
    private static final long VerticalThumbSize;

    public static final Unit RangeSlider$lambda$13(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange2, int i, Function0 function0, SliderColors sliderColors, int i2, int i3, Composer composer, int i4) {
        RangeSlider(closedFloatingPointRange, function1, modifier, z, closedFloatingPointRange2, i, function0, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final Unit RangeSlider$lambda$19(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange2, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, int i2, int i3, int i4, Composer composer, int i5) {
        RangeSlider(closedFloatingPointRange, function1, modifier, z, closedFloatingPointRange2, function0, sliderColors, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    public static final Unit RangeSlider$lambda$23(RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, int i2, Composer composer, int i3) {
        RangeSlider(rangeSliderState, modifier, z, sliderColors, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit RangeSliderImpl$lambda$46(Modifier modifier, RangeSliderState rangeSliderState, boolean z, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3 function3, Function3 function32, Function3 function33, int i, Composer composer, int i2) {
        RangeSliderImpl(modifier, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit Slider$lambda$1(float f, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange, int i, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        Slider(f, function1, modifier, z, closedFloatingPointRange, i, function0, sliderColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final Unit Slider$lambda$4(float f, Function1 function1, Modifier modifier, boolean z, Function0 function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i, Function3 function3, Function3 function32, ClosedFloatingPointRange closedFloatingPointRange, int i2, int i3, int i4, Composer composer, int i5) {
        Slider(f, function1, modifier, z, function0, sliderColors, mutableInteractionSource, i, function3, function32, closedFloatingPointRange, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    public static final Unit Slider$lambda$7(SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        Slider(sliderState, modifier, z, sliderColors, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit SliderImpl$lambda$31(Modifier modifier, SliderState sliderState, boolean z, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, Composer composer, int i2) {
        SliderImpl(modifier, sliderState, z, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit VerticalSlider$lambda$10(SliderState sliderState, Modifier modifier, boolean z, boolean z2, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        VerticalSlider(sliderState, modifier, z, z2, sliderColors, mutableInteractionSource, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ float access$calcFraction(float f, float f2, float f3) {
        return calcFraction(f, f2, f3);
    }

    public static final /* synthetic */ float access$scale(float f, float f2, float f3, float f4, float f5) {
        return scale(f, f2, f3, f4, f5);
    }

    /* renamed from: access$scale-2geJ7wY */
    public static final /* synthetic */ long m2533access$scale2geJ7wY(boolean z, float f, float f2, long j, float f3, float f4) {
        return m2537scale2geJ7wY(z, f, f2, j, f3, f4);
    }

    public static final /* synthetic */ float access$snapValueToTick(float f, float[] fArr, float f2, float f3) {
        return snapValueToTick(f, fArr, f2, f3);
    }

    public static final /* synthetic */ float[] access$stepsToTickFractions(int i) {
        return stepsToTickFractions(i);
    }

    /* renamed from: isSpecified-If1S1O4$annotations */
    public static /* synthetic */ void m2536isSpecifiedIf1S1O4$annotations(long j) {
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:311:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        float f2;
        int i4;
        Function1<? super Float, Unit> function12;
        Modifier.Companion companion;
        int i5;
        boolean z2;
        Object obj;
        int i6;
        int i7;
        int i8;
        Object obj2;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final SliderColors sliderColors2;
        final Modifier modifier2;
        final boolean z3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final int i12;
        final Function0<Unit> function02;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope endRestartGroup;
        int i13;
        final SliderColors sliderColors3;
        final MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i14;
        Function0<Unit> function03;
        int i15;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,colors,interactionSource)201@9624L182,208@9824L122,192@9332L654:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            f2 = f;
        } else {
            f2 = f;
            if ((i2 & 6) == 0) {
                i4 = (startRestartGroup.changed(f2) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i2 & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i18 = i3 & 4;
        if (i18 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i4 |= startRestartGroup.changed(companion) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        obj = closedFloatingPointRange;
                        if (startRestartGroup.changed(obj)) {
                            i17 = 16384;
                            i4 |= i17;
                        }
                    } else {
                        obj = closedFloatingPointRange;
                    }
                    i17 = 8192;
                    i4 |= i17;
                } else {
                    obj = closedFloatingPointRange;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    i7 = i;
                    i4 |= startRestartGroup.changed(i7) ? 131072 : 65536;
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((1572864 & i2) == 0) {
                        obj2 = function0;
                        i4 |= startRestartGroup.changedInstance(obj2) ? 1048576 : 524288;
                        if ((i2 & 12582912) == 0) {
                            if ((i3 & 128) == 0 && startRestartGroup.changed(sliderColors)) {
                                i16 = 8388608;
                                i4 |= i16;
                            }
                            i16 = 4194304;
                            i4 |= i16;
                        }
                        i9 = i3 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i10 = i9;
                            i4 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            i11 = i4;
                            if (!startRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "189@9223L8,190@9283L39");
                                if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i18 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if (i5 != 0) {
                                        z2 = true;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i13 = i11 & (-57345);
                                        obj = RangesKt.rangeTo(0.0f, 1.0f);
                                    } else {
                                        i13 = i11;
                                    }
                                    if (i6 != 0) {
                                        i7 = 0;
                                    }
                                    if (i8 != 0) {
                                        obj2 = null;
                                    }
                                    if ((i3 & 128) != 0) {
                                        sliderColors3 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i13 = (-29360129) & i13;
                                    } else {
                                        sliderColors3 = sliderColors;
                                    }
                                    if (i10 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -890767796, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    modifier3 = companion;
                                    closedFloatingPointRange3 = obj;
                                    i14 = i7;
                                    function03 = obj2;
                                    i15 = -202044027;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    int i19 = (i3 & 16) != 0 ? i11 & (-57345) : i11;
                                    if ((i3 & 128) != 0) {
                                        i19 &= -29360129;
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    i13 = i19;
                                    modifier3 = companion;
                                    closedFloatingPointRange3 = obj;
                                    i14 = i7;
                                    function03 = obj2;
                                    i15 = -202044027;
                                    sliderColors3 = sliderColors;
                                }
                                final boolean z4 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i15, i13, -1, "androidx.compose.material3.Slider (Slider.kt:191)");
                                }
                                int i20 = i13 >> 6;
                                SliderColors sliderColors4 = sliderColors3;
                                composer2 = startRestartGroup;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                Slider(f2, function12, modifier3, z4, function03, sliderColors4, mutableInteractionSource4, i14, ComposableLambdaKt.rememberComposableLambda(308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                        invoke(sliderState, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "CN(it)202@9653L143:Slider.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(308249025, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:202)");
                                        }
                                        SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z4, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer3, Integer num) {
                                        invoke(sliderState, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SliderState sliderState, Composer composer3, int i21) {
                                        ComposerKt.sourceInformation(composer3, "CN(sliderState)209@9868L68:Slider.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1843234110, i21, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:209)");
                                        }
                                        SliderDefaults.INSTANCE.m2520Track4EFweAY(sliderState, (Modifier) null, z4, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer3, (i21 & 14) | 100663296, 242);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), closedFloatingPointRange3, composer2, (i13 & 14) | 905969664 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i20) | (458752 & i20) | (i20 & 3670016) | ((i13 << 6) & 29360128), (i13 >> 12) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                z3 = z4;
                                function02 = function03;
                                sliderColors2 = sliderColors4;
                                mutableInteractionSource2 = mutableInteractionSource4;
                                i12 = i14;
                                closedFloatingPointRange2 = closedFloatingPointRange3;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                sliderColors2 = sliderColors;
                                modifier2 = companion;
                                z3 = z2;
                                closedFloatingPointRange2 = obj;
                                i12 = i7;
                                function02 = obj2;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj3, Object obj4) {
                                        return SliderKt.Slider$lambda$1(f, function1, modifier2, z3, closedFloatingPointRange2, i12, function02, sliderColors2, mutableInteractionSource2, i2, i3, (Composer) obj3, ((Integer) obj4).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i10 = i9;
                        i11 = i4;
                        if (!startRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj2 = function0;
                    if ((i2 & 12582912) == 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i4;
                    if (!startRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i7 = i;
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                obj2 = function0;
                if ((i2 & 12582912) == 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i4;
                if (!startRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i;
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            obj2 = function0;
            if ((i2 & 12582912) == 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i4;
            if (!startRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i;
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        obj2 = function0;
        if ((i2 & 12582912) == 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i4;
        if (!startRestartGroup.shouldExecute((i4 & 38347923) == 38347922, i11 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:236:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:399:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier.Companion companion;
        int i6;
        final boolean z2;
        int i7;
        Object obj;
        final SliderColors sliderColors2;
        int i8;
        final Object obj2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final boolean z3;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        final MutableInteractionSource mutableInteractionSource2;
        final Function0<Unit> function02;
        final SliderColors sliderColors3;
        ScopeUpdateScope endRestartGroup;
        int i17;
        ComposableLambda rememberComposableLambda;
        int i18;
        ComposableLambda composableLambda;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i19;
        int i20;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35;
        MutableInteractionSource mutableInteractionSource3;
        int i21;
        int i22;
        Composer startRestartGroup = composer.startRestartGroup(985901935);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)N(value,onValueChange,modifier,enabled,onValueChangeFinished,colors,interactionSource,steps,thumb,track,valueRange)294@13990L92,299@14208L185:Slider.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i23 = i4 & 4;
        if (i23 != 0) {
            i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i5 |= startRestartGroup.changed(companion) ? 256 : 128;
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                z2 = z;
                i5 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    obj = function0;
                    i5 |= startRestartGroup.changedInstance(obj) ? 16384 : 8192;
                    if ((196608 & i2) != 0) {
                        if ((i4 & 32) == 0) {
                            sliderColors2 = sliderColors;
                            if (startRestartGroup.changed(sliderColors2)) {
                                i22 = 131072;
                                i5 |= i22;
                            }
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i22 = 65536;
                        i5 |= i22;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                        obj2 = mutableInteractionSource;
                    } else {
                        obj2 = mutableInteractionSource;
                        if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(obj2) ? 1048576 : 524288;
                        }
                    }
                    i9 = i4 & 128;
                    if (i9 == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i5 |= startRestartGroup.changed(i) ? 8388608 : 4194304;
                    }
                    i10 = i4 & 256;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i11 = i10;
                        i5 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                        i12 = i4 & 512;
                        if (i12 != 0) {
                            i5 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i13 = i12;
                            i5 |= startRestartGroup.changedInstance(function32) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                            if ((i3 & 6) != 0) {
                                if ((i4 & 1024) == 0 && startRestartGroup.changed(closedFloatingPointRange)) {
                                    i21 = 4;
                                    i14 = i3 | i21;
                                }
                                i21 = 2;
                                i14 = i3 | i21;
                            } else {
                                i14 = i3;
                            }
                            i15 = i5;
                            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "278@13393L8,279@13453L39,281@13581L158,288@13788L114");
                                if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & 32) != 0) {
                                        i15 &= -458753;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        i14 &= -15;
                                    }
                                    i16 = i;
                                    function35 = function32;
                                    closedFloatingPointRange3 = closedFloatingPointRange;
                                    i20 = i14;
                                    i19 = i15;
                                    rememberComposableLambda = function3;
                                } else {
                                    if (i23 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if (i6 != 0) {
                                        z2 = true;
                                    }
                                    if (i7 != 0) {
                                        obj = null;
                                    }
                                    if ((i4 & 32) != 0) {
                                        i17 = i15 & (-458753);
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    } else {
                                        i17 = i15;
                                    }
                                    if (i8 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1736002634, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        obj2 = (MutableInteractionSource) rememberedValue;
                                    }
                                    int i24 = i9 != 0 ? 0 : i;
                                    rememberComposableLambda = i11 != 0 ? ComposableLambdaKt.rememberComposableLambda(-1689130945, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$6
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer2, Integer num) {
                                            invoke(sliderState, composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SliderState sliderState, Composer composer2, int i25) {
                                            ComposerKt.sourceInformation(composer2, "CN(it)282@13606L127:Slider.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1689130945, i25, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:282)");
                                            }
                                            SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, startRestartGroup, 54) : function3;
                                    if (i13 != 0) {
                                        i18 = i24;
                                        composableLambda = ComposableLambdaKt.rememberComposableLambda(-294493388, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$7
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState, Composer composer2, Integer num) {
                                                invoke(sliderState, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState, Composer composer2, int i25) {
                                                ComposerKt.sourceInformation(composer2, "CN(sliderState)289@13828L68:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-294493388, i25, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:289)");
                                                }
                                                SliderDefaults.INSTANCE.m2520Track4EFweAY(sliderState, (Modifier) null, z2, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer2, (i25 & 14) | 100663296, 242);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54);
                                    } else {
                                        i18 = i24;
                                        composableLambda = function32;
                                    }
                                    if ((i4 & 1024) != 0) {
                                        closedFloatingPointRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                                        i14 &= -15;
                                    } else {
                                        closedFloatingPointRange3 = closedFloatingPointRange;
                                    }
                                    i19 = i17;
                                    i20 = i14;
                                    function35 = composableLambda;
                                    i16 = i18;
                                }
                                startRestartGroup.endDefaults();
                                Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function36 = rememberComposableLambda;
                                if (ComposerKt.isTraceInProgress()) {
                                    mutableInteractionSource3 = obj2;
                                    ComposerKt.traceEventStart(985901935, i19, i20, "androidx.compose.material3.Slider (Slider.kt:292)");
                                } else {
                                    mutableInteractionSource3 = obj2;
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1735985397, "CC(remember):Slider.kt#9igjgp");
                                boolean z4 = ((29360128 & i19) == 8388608) | ((((i20 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange3)) || (i20 & 6) == 4);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (z4 || rememberedValue2 == Composer.Companion.getEmpty()) {
                                    rememberedValue2 = new SliderState(f, i16, obj, closedFloatingPointRange3);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                SliderState sliderState = (SliderState) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                sliderState.setOnValueChangeFinished(obj);
                                sliderState.setOnValueChange(function1);
                                sliderState.setValue(f);
                                int i25 = i19 >> 9;
                                Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function37 = function35;
                                Slider(sliderState, companion, z2, null, mutableInteractionSource3, function36, function37, startRestartGroup, ((i19 >> 3) & 1008) | ((i19 >> 6) & 57344) | (458752 & i25) | (i25 & 3670016), 8);
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                closedFloatingPointRange2 = closedFloatingPointRange3;
                                function33 = function36;
                                z3 = z2;
                                function34 = function37;
                                mutableInteractionSource2 = mutableInteractionSource4;
                                sliderColors3 = sliderColors2;
                                function02 = obj;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i16 = i;
                                function33 = function3;
                                closedFloatingPointRange2 = closedFloatingPointRange;
                                z3 = z2;
                                function34 = function32;
                                mutableInteractionSource2 = obj2;
                                function02 = obj;
                                sliderColors3 = sliderColors2;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier2 = companion;
                                final int i26 = i16;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda11
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj3, Object obj4) {
                                        return SliderKt.Slider$lambda$4(f, function1, modifier2, z3, function02, sliderColors3, mutableInteractionSource2, i26, function33, function34, closedFloatingPointRange2, i2, i3, i4, (Composer) obj3, ((Integer) obj4).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i13 = i12;
                        if ((i3 & 6) != 0) {
                        }
                        i15 = i5;
                        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i11 = i10;
                    i12 = i4 & 512;
                    if (i12 != 0) {
                    }
                    i13 = i12;
                    if ((i3 & 6) != 0) {
                    }
                    i15 = i5;
                    if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj = function0;
                if ((196608 & i2) != 0) {
                }
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                i9 = i4 & 128;
                if (i9 == 0) {
                }
                i10 = i4 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i4 & 512;
                if (i12 != 0) {
                }
                i13 = i12;
                if ((i3 & 6) != 0) {
                }
                i15 = i5;
                if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            obj = function0;
            if ((196608 & i2) != 0) {
            }
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            i9 = i4 & 128;
            if (i9 == 0) {
            }
            i10 = i4 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i4 & 512;
            if (i12 != 0) {
            }
            i13 = i12;
            if ((i3 & 6) != 0) {
            }
            i15 = i5;
            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        z2 = z;
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        obj = function0;
        if ((196608 & i2) != 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        i9 = i4 & 128;
        if (i9 == 0) {
        }
        i10 = i4 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i4 & 512;
        if (i12 != 0) {
        }
        i13 = i12;
        if ((i3 & 6) != 0) {
        }
        i15 = i5;
        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i14 & 3) != 2, i15 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        SliderState sliderState2;
        int i3;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        int i5;
        final Object obj;
        int i6;
        ComposableLambda composableLambda;
        int i7;
        ComposableLambda composableLambda2;
        final Modifier modifier2;
        final boolean z3;
        final SliderColors sliderColors3;
        final MutableInteractionSource mutableInteractionSource2;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope endRestartGroup;
        boolean z4;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(409861960);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)N(state,modifier,enabled,colors,interactionSource,thumb,track)374@17399L189:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            sliderState2 = sliderState;
        } else {
            sliderState2 = sliderState;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(sliderState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i8 = 2048;
                            i3 |= i8;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i8 = 1024;
                    i3 |= i8;
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(obj) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        composableLambda = function3;
                        i3 |= startRestartGroup.changedInstance(composableLambda) ? 131072 : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((1572864 & i) == 0) {
                            composableLambda2 = function32;
                            i3 |= startRestartGroup.changedInstance(composableLambda2) ? 1048576 : 524288;
                            if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "359@16862L8,360@16922L39,361@17010L158,368@17217L114");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    z4 = z2;
                                    function34 = composableLambda;
                                    mutableInteractionSource3 = obj;
                                    modifier3 = modifier;
                                } else {
                                    Modifier.Companion companion = i9 != 0 ? Modifier.Companion : modifier;
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    }
                                    if (i5 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1259639953, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        obj = (MutableInteractionSource) rememberedValue;
                                    }
                                    if (i6 != 0) {
                                        composableLambda = ComposableLambdaKt.rememberComposableLambda(-2100927368, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$10
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState3, Composer composer2, Integer num) {
                                                invoke(sliderState3, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState3, Composer composer2, int i10) {
                                                ComposerKt.sourceInformation(composer2, "CN(it)362@17035L127:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2100927368, i10, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:362)");
                                                }
                                                SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54);
                                    }
                                    if (i7 != 0) {
                                        composableLambda2 = ComposableLambdaKt.rememberComposableLambda(-81224541, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$11
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState3, Composer composer2, Integer num) {
                                                invoke(sliderState3, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState3, Composer composer2, int i10) {
                                                ComposerKt.sourceInformation(composer2, "CN(sliderState)369@17257L68:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-81224541, i10, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:369)");
                                                }
                                                SliderDefaults.INSTANCE.m2520Track4EFweAY(sliderState3, (Modifier) null, z2, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer2, (i10 & 14) | 100663296, 242);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54);
                                    }
                                    z4 = z2;
                                    function34 = composableLambda;
                                    mutableInteractionSource3 = obj;
                                    modifier3 = companion;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(409861960, i3, -1, "androidx.compose.material3.Slider (Slider.kt:371)");
                                }
                                if (sliderState2.getSteps() < 0) {
                                    throw new IllegalArgumentException("steps should be >= 0".toString());
                                }
                                int i10 = i3 >> 3;
                                SliderImpl(modifier3, sliderState2, z4, mutableInteractionSource3, function34, composableLambda2, startRestartGroup, (i3 & 896) | (i10 & 14) | ((i3 << 3) & 112) | (i10 & 7168) | (57344 & i10) | (i10 & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                sliderColors3 = sliderColors2;
                                modifier2 = modifier3;
                                z3 = z4;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                function33 = function34;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                z3 = z2;
                                sliderColors3 = sliderColors2;
                                mutableInteractionSource2 = obj;
                                function33 = composableLambda;
                            }
                            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = composableLambda2;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda23
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return SliderKt.Slider$lambda$7(SliderState.this, modifier2, z3, sliderColors3, mutableInteractionSource2, function33, function35, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        composableLambda2 = function32;
                        if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        }
                        final Function3 function352 = composableLambda2;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    composableLambda = function3;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    composableLambda2 = function32;
                    if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                    }
                    final Function3 function3522 = composableLambda2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                obj = mutableInteractionSource;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                composableLambda = function3;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                composableLambda2 = function32;
                if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                final Function3 function35222 = composableLambda2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj = mutableInteractionSource;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            composableLambda = function3;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            composableLambda2 = function32;
            if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            final Function3 function352222 = composableLambda2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj = mutableInteractionSource;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        composableLambda = function3;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        composableLambda2 = function32;
        if (!startRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        final Function3 function3522222 = composableLambda2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:285:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void VerticalSlider(final SliderState sliderState, Modifier modifier, boolean z, boolean z2, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        final boolean z3;
        int i5;
        boolean z4;
        final SliderColors sliderColors2;
        int i6;
        final Object obj;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        final boolean z5;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        ScopeUpdateScope endRestartGroup;
        int i11;
        ComposableLambda rememberComposableLambda;
        ComposableLambda rememberComposableLambda2;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1841025790);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalSlider)N(state,modifier,enabled,reverseDirection,colors,interactionSource,thumb,track)444@20428L189:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z3 = z;
                i3 |= startRestartGroup.changed(z3) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    z4 = z2;
                    i3 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            sliderColors2 = sliderColors;
                            if (startRestartGroup.changed(sliderColors2)) {
                                i12 = 16384;
                                i3 |= i12;
                            }
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i12 = 8192;
                        i3 |= i12;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        obj = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(obj) ? 131072 : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        i8 = i2 & 128;
                        if (i8 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i9 = i8;
                            i3 |= startRestartGroup.changedInstance(function32) ? 8388608 : 4194304;
                            i10 = i3;
                            if (startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                function33 = function32;
                                z5 = z3;
                                function34 = function3;
                            } else {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "419@19613L8,420@19673L39,421@19761L255,430@20065L207");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        rememberComposableLambda = function3;
                                        i11 = i10 & (-57345);
                                        rememberComposableLambda2 = function32;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (sliderState.getSteps() >= 0) {
                                        }
                                    } else {
                                        rememberComposableLambda = function3;
                                        rememberComposableLambda2 = function32;
                                        i11 = i10;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        if (sliderState.getSteps() >= 0) {
                                        }
                                    }
                                } else {
                                    if (i13 != 0) {
                                        companion = Modifier.Companion;
                                    }
                                    if (i4 != 0) {
                                        z3 = true;
                                    }
                                    if (i5 != 0) {
                                        z4 = false;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i11 = i10 & (-57345);
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    } else {
                                        i11 = i10;
                                    }
                                    if (i6 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 300751721, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        obj = (MutableInteractionSource) rememberedValue;
                                    }
                                    rememberComposableLambda = i7 != 0 ? ComposableLambdaKt.rememberComposableLambda(1896624690, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$VerticalSlider$2
                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState2, Composer composer3, Integer num) {
                                            invoke(sliderState2, composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SliderState sliderState2, Composer composer3, int i14) {
                                            long j;
                                            ComposerKt.sourceInformation(composer3, "CN(sliderState)422@19801L209:Slider.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1896624690, i14, -1, "androidx.compose.material3.VerticalSlider.<anonymous> (Slider.kt:422)");
                                            }
                                            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
                                            MutableInteractionSource mutableInteractionSource2 = MutableInteractionSource.this;
                                            SliderColors sliderColors3 = sliderColors2;
                                            boolean z6 = z3;
                                            j = SliderKt.VerticalThumbSize;
                                            sliderDefaults.m2518ThumbHwbPF3A$material3(mutableInteractionSource2, sliderState2, null, sliderColors3, z6, j, composer3, ((i14 << 3) & 112) | 1769472, 4);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, startRestartGroup, 54) : function3;
                                    if (i9 != 0) {
                                        rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1702448035, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$VerticalSlider$3
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(SliderState sliderState2, Composer composer3, Integer num) {
                                                invoke(sliderState2, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState2, Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "CN(sliderState)431@20105L161:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1702448035, i14, -1, "androidx.compose.material3.VerticalSlider.<anonymous> (Slider.kt:431)");
                                                }
                                                SliderDefaults.INSTANCE.m2522TrackmnvyFg4$material3(sliderState2, Dp.Companion.m7575getUnspecifiedD9Ej5fM(), (Modifier) null, z3, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer3, (i14 & 14) | 805306416, 484);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54);
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1841025790, i11, -1, "androidx.compose.material3.VerticalSlider (Slider.kt:438)");
                                        }
                                        if (sliderState.getSteps() >= 0) {
                                            throw new IllegalArgumentException("steps should be >= 0".toString());
                                        }
                                        sliderState.setOrientation$material3(Orientation.Vertical);
                                        sliderState.setReverseVerticalDirection$material3(z4);
                                        int i14 = i11 >> 6;
                                        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = rememberComposableLambda2;
                                        SliderImpl(companion, sliderState, z3, obj, rememberComposableLambda, function35, startRestartGroup, (i14 & 458752) | ((i11 >> 3) & 14) | ((i11 << 3) & 112) | (i11 & 896) | (i14 & 7168) | (57344 & i14));
                                        composer2 = startRestartGroup;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        z5 = z3;
                                        function34 = rememberComposableLambda;
                                        function33 = function35;
                                    }
                                    rememberComposableLambda2 = function32;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    if (sliderState.getSteps() >= 0) {
                                    }
                                }
                            }
                            final Modifier modifier2 = companion;
                            final boolean z6 = z4;
                            final SliderColors sliderColors3 = sliderColors2;
                            final MutableInteractionSource mutableInteractionSource2 = obj;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj2, Object obj3) {
                                        return SliderKt.VerticalSlider$lambda$10(SliderState.this, modifier2, z5, z6, sliderColors3, mutableInteractionSource2, function34, function33, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i9 = i8;
                        i10 = i3;
                        if (startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
                        }
                        final Modifier modifier22 = companion;
                        final boolean z62 = z4;
                        final SliderColors sliderColors32 = sliderColors2;
                        final MutableInteractionSource mutableInteractionSource22 = obj;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    obj = mutableInteractionSource;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                    }
                    i9 = i8;
                    i10 = i3;
                    if (startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
                    }
                    final Modifier modifier222 = companion;
                    final boolean z622 = z4;
                    final SliderColors sliderColors322 = sliderColors2;
                    final MutableInteractionSource mutableInteractionSource222 = obj;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z4 = z2;
                if ((i & 24576) != 0) {
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                obj = mutableInteractionSource;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i3;
                if (startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
                }
                final Modifier modifier2222 = companion;
                final boolean z6222 = z4;
                final SliderColors sliderColors3222 = sliderColors2;
                final MutableInteractionSource mutableInteractionSource2222 = obj;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            z4 = z2;
            if ((i & 24576) != 0) {
            }
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            obj = mutableInteractionSource;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            i8 = i2 & 128;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i3;
            if (startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
            }
            final Modifier modifier22222 = companion;
            final boolean z62222 = z4;
            final SliderColors sliderColors32222 = sliderColors2;
            final MutableInteractionSource mutableInteractionSource22222 = obj;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        companion = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z3 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        z4 = z2;
        if ((i & 24576) != 0) {
        }
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        obj = mutableInteractionSource;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        i8 = i2 & 128;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i3;
        if (startRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i10 & 1)) {
        }
        final Modifier modifier222222 = companion;
        final boolean z622222 = z4;
        final SliderColors sliderColors322222 = sliderColors2;
        final MutableInteractionSource mutableInteractionSource222222 = obj;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:287:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, Function0<Unit> function0, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i4;
        Function1<? super ClosedFloatingPointRange<Float>, Unit> function12;
        Object obj;
        int i5;
        boolean z2;
        Object obj2;
        int i6;
        int i7;
        int i8;
        Object obj3;
        int i9;
        Composer composer2;
        final SliderColors sliderColors2;
        final Modifier modifier2;
        final boolean z3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        final int i10;
        final Function0<Unit> function02;
        ScopeUpdateScope endRestartGroup;
        int i11;
        final SliderColors sliderColors3;
        final boolean z4;
        int i12;
        Function0<Unit> function03;
        int i13;
        Modifier modifier3;
        int i14;
        ClosedFloatingPointRange<Float> closedFloatingPointRange5;
        int i15;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,colors)499@23112L39,500@23209L39,512@23627L187,519@23835L185,526@24038L200,502@23254L991:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
            closedFloatingPointRange3 = closedFloatingPointRange;
        } else {
            closedFloatingPointRange3 = closedFloatingPointRange;
            if ((i2 & 6) == 0) {
                i4 = (startRestartGroup.changed(closedFloatingPointRange3) ? 4 : 2) | i2;
            } else {
                i4 = i2;
            }
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i2 & 48) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i17 = i3 & 4;
        if (i17 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i4 |= startRestartGroup.changed(obj) ? 256 : 128;
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                z2 = z;
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        obj2 = closedFloatingPointRange2;
                        if (startRestartGroup.changed(obj2)) {
                            i16 = 16384;
                            i4 |= i16;
                        }
                    } else {
                        obj2 = closedFloatingPointRange2;
                    }
                    i16 = 8192;
                    i4 |= i16;
                } else {
                    obj2 = closedFloatingPointRange2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i2) == 0) {
                    i7 = i;
                    i4 |= startRestartGroup.changed(i7) ? 131072 : 65536;
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((1572864 & i2) == 0) {
                        obj3 = function0;
                        i4 |= startRestartGroup.changedInstance(obj3) ? 1048576 : 524288;
                        if ((i2 & 12582912) == 0) {
                            if ((i3 & 128) == 0 && startRestartGroup.changed(sliderColors)) {
                                i15 = 8388608;
                                i4 |= i15;
                            }
                            i15 = 4194304;
                            i4 |= i15;
                        }
                        i9 = i4;
                        if (startRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "497@23039L8");
                            if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                i14 = (i3 & 16) != 0 ? i9 & (-57345) : i9;
                                if ((i3 & 128) != 0) {
                                    i14 &= -29360129;
                                }
                                z4 = z2;
                                i12 = i7;
                                function03 = obj3;
                                i13 = -743091416;
                                modifier3 = obj;
                                closedFloatingPointRange5 = obj2;
                                sliderColors3 = sliderColors;
                            } else {
                                Modifier.Companion companion = i17 != 0 ? Modifier.Companion : obj;
                                if (i5 != 0) {
                                    z2 = true;
                                }
                                if ((i3 & 16) != 0) {
                                    i11 = i9 & (-57345);
                                    obj2 = RangesKt.rangeTo(0.0f, 1.0f);
                                } else {
                                    i11 = i9;
                                }
                                if (i6 != 0) {
                                    i7 = 0;
                                }
                                if (i8 != 0) {
                                    obj3 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    sliderColors3 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    z4 = z2;
                                    i12 = i7;
                                    function03 = obj3;
                                    modifier3 = companion;
                                    i14 = (-29360129) & i11;
                                    closedFloatingPointRange5 = obj2;
                                    i13 = -743091416;
                                } else {
                                    sliderColors3 = sliderColors;
                                    z4 = z2;
                                    i12 = i7;
                                    function03 = obj3;
                                    i13 = -743091416;
                                    modifier3 = companion;
                                    i14 = i11;
                                    closedFloatingPointRange5 = obj2;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i13, i14, -1, "androidx.compose.material3.RangeSlider (Slider.kt:498)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1146263569, "CC(remember):Slider.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1146260465, "CC(remember):Slider.kt#9igjgp");
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            final MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) rememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            composer2 = startRestartGroup;
                            RangeSlider(closedFloatingPointRange3, function12, modifier3, z4, closedFloatingPointRange5, function03, null, mutableInteractionSource, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(-811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i18) {
                                    ComposerKt.sourceInformation(composer3, "CN(it)513@23656L148:Slider.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-811582901, i18, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:513)");
                                    }
                                    SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z4, 0L, composer3, 196614, 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i18) {
                                    ComposerKt.sourceInformation(composer3, "CN(it)520@23864L146:Slider.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1832060001, i18, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:520)");
                                    }
                                    SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z4, 0L, composer3, 196614, 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer3, Integer num) {
                                    invoke(rangeSliderState, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer3, int i18) {
                                    ComposerKt.sourceInformation(composer3, "CN(rangeSliderState)527@24087L141:Slider.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(377064480, i18, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:527)");
                                    }
                                    SliderDefaults.INSTANCE.m2519Track4EFweAY(rangeSliderState, (Modifier) null, z4, sliderColors3, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer3, (i18 & 14) | 100663296, 242);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), i12, composer2, (i14 & 14) | 918552576 | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | ((i14 >> 3) & 458752), ((i14 >> 9) & 896) | 54, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sliderColors2 = sliderColors3;
                            modifier2 = modifier3;
                            z3 = z4;
                            closedFloatingPointRange4 = closedFloatingPointRange5;
                            function02 = function03;
                            i10 = i12;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            sliderColors2 = sliderColors;
                            modifier2 = obj;
                            z3 = z2;
                            closedFloatingPointRange4 = obj2;
                            i10 = i7;
                            function02 = obj3;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj4, Object obj5) {
                                    return SliderKt.RangeSlider$lambda$13(ClosedFloatingPointRange.this, function1, modifier2, z3, closedFloatingPointRange4, i10, function02, sliderColors2, i2, i3, (Composer) obj4, ((Integer) obj5).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    obj3 = function0;
                    if ((i2 & 12582912) == 0) {
                    }
                    i9 = i4;
                    if (startRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i;
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                obj3 = function0;
                if ((i2 & 12582912) == 0) {
                }
                i9 = i4;
                if (startRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i;
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            obj3 = function0;
            if ((i2 & 12582912) == 0) {
            }
            i9 = i4;
            if (startRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        obj = modifier;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        z2 = z;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i;
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        obj3 = function0;
        if ((i2 & 12582912) == 0) {
        }
        i9 = i4;
        if (startRestartGroup.shouldExecute((i4 & 4793491) != 4793490, i9 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:280:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:485:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:487:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, int i, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Object obj;
        int i6;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i7;
        Object obj2;
        final SliderColors sliderColors2;
        int i8;
        Object obj3;
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
        final boolean z2;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        int i20;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        final SliderColors sliderColors3;
        final Function0<Unit> function02;
        final MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36;
        ScopeUpdateScope endRestartGroup;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource5;
        final MutableInteractionSource mutableInteractionSource6;
        Object obj4;
        Object obj5;
        boolean z4;
        ComposableLambda composableLambda;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37;
        ComposableLambda composableLambda2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function38;
        ComposableLambda composableLambda3;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function39;
        int i21;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function310;
        int i22;
        Object obj6;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function311;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function312;
        int i23;
        Composer startRestartGroup = composer.startRestartGroup(1924256162);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)N(value,onValueChange,modifier,enabled,valueRange,onValueChangeFinished,colors,startInteractionSource,endInteractionSource,startThumb,endThumb,track,steps)626@28935L238,637@29257L44,641@29394L292:Slider.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(closedFloatingPointRange) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i24 = i4 & 4;
        if (i24 != 0) {
            i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i5 |= startRestartGroup.changed(obj) ? 256 : 128;
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i5 |= startRestartGroup.changed(z) ? 2048 : 1024;
                if ((i2 & 24576) == 0) {
                    if ((i4 & 16) == 0) {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        if (startRestartGroup.changed(closedFloatingPointRange3)) {
                            i23 = 16384;
                            i5 |= i23;
                        }
                    } else {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                    }
                    i23 = 8192;
                    i5 |= i23;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    obj2 = function0;
                } else {
                    obj2 = function0;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i5 |= startRestartGroup.changedInstance(obj2) ? 131072 : 65536;
                    }
                }
                if ((i2 & 1572864) == 0) {
                    sliderColors2 = sliderColors;
                    i5 |= ((i4 & 64) == 0 && startRestartGroup.changed(sliderColors2)) ? 1048576 : 524288;
                } else {
                    sliderColors2 = sliderColors;
                }
                i8 = i4 & 128;
                if (i8 != 0) {
                    i5 |= 12582912;
                    obj3 = mutableInteractionSource;
                } else {
                    obj3 = mutableInteractionSource;
                    if ((i2 & 12582912) == 0) {
                        i5 |= startRestartGroup.changed(obj3) ? 8388608 : 4194304;
                    }
                }
                i9 = i4 & 256;
                if (i9 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i10 = i9;
                    i5 |= startRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                    i11 = i4 & 512;
                    if (i11 == 0) {
                        i5 |= 805306368;
                    } else if ((i2 & 805306368) == 0) {
                        i12 = i11;
                        i5 |= startRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i13 = i4 & 1024;
                        if (i13 != 0) {
                            i15 = i3 | 6;
                            i14 = i13;
                        } else if ((i3 & 6) == 0) {
                            i14 = i13;
                            i15 = i3 | (startRestartGroup.changedInstance(function32) ? 4 : 2);
                        } else {
                            i14 = i13;
                            i15 = i3;
                        }
                        i16 = i4 & 2048;
                        if (i16 != 0) {
                            i15 |= 48;
                            i17 = i16;
                        } else if ((i3 & 48) == 0) {
                            i17 = i16;
                            i15 |= startRestartGroup.changedInstance(function33) ? 32 : 16;
                        } else {
                            i17 = i16;
                        }
                        i18 = i15;
                        i19 = i4 & 4096;
                        if (i19 != 0) {
                            i18 |= RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i18 |= startRestartGroup.changed(i) ? 256 : 128;
                            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "599@27997L8,600@28062L39,601@28156L39,602@28254L163,609@28474L161,616@28689L176");
                                if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & 16) != 0) {
                                        i5 &= -57345;
                                    }
                                    if ((i4 & 64) != 0) {
                                        i5 &= -3670017;
                                    }
                                    z3 = z;
                                    function39 = function3;
                                    function310 = function33;
                                    i21 = i;
                                    obj6 = closedFloatingPointRange3;
                                    i22 = i5;
                                    mutableInteractionSource5 = obj3;
                                    mutableInteractionSource6 = mutableInteractionSource2;
                                    function311 = function32;
                                } else {
                                    Modifier.Companion companion = i24 != 0 ? Modifier.Companion : obj;
                                    z3 = i6 != 0 ? true : z;
                                    if ((i4 & 16) != 0) {
                                        closedFloatingPointRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                                        i5 &= -57345;
                                    }
                                    if (i7 != 0) {
                                        obj2 = null;
                                    }
                                    if ((i4 & 64) != 0) {
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i5 &= -3670017;
                                    }
                                    if (i8 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1920718807, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.Companion.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        mutableInteractionSource5 = (MutableInteractionSource) rememberedValue;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    } else {
                                        mutableInteractionSource5 = obj3;
                                    }
                                    if (i10 != 0) {
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1920715799, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                            rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        mutableInteractionSource6 = (MutableInteractionSource) rememberedValue2;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    } else {
                                        mutableInteractionSource6 = mutableInteractionSource2;
                                    }
                                    if (i12 != 0) {
                                        obj4 = companion;
                                        obj5 = closedFloatingPointRange3;
                                        z4 = true;
                                        composableLambda = ComposableLambdaKt.rememberComposableLambda(-743960051, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$7
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer2, Integer num) {
                                                invoke(rangeSliderState, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i25) {
                                                ComposerKt.sourceInformation(composer2, "CN(it)603@28279L132:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-743960051, i25, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:603)");
                                                }
                                                SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54);
                                    } else {
                                        obj4 = companion;
                                        obj5 = closedFloatingPointRange3;
                                        z4 = true;
                                        composableLambda = function3;
                                    }
                                    if (i14 != 0) {
                                        function37 = composableLambda;
                                        composableLambda2 = ComposableLambdaKt.rememberComposableLambda(1306751174, z4, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$8
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer2, Integer num) {
                                                invoke(rangeSliderState, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i25) {
                                                ComposerKt.sourceInformation(composer2, "CN(it)610@28499L130:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1306751174, i25, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:610)");
                                                }
                                                SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z3, 0L, composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54);
                                    } else {
                                        function37 = composableLambda;
                                        composableLambda2 = function32;
                                    }
                                    if (i17 != 0) {
                                        function38 = composableLambda2;
                                        composableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1234185578, z4, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$9
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState, Composer composer2, Integer num) {
                                                invoke(rangeSliderState, composer2, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i25) {
                                                ComposerKt.sourceInformation(composer2, "CN(rangeSliderState)617@28734L125:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1234185578, i25, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:617)");
                                                }
                                                SliderDefaults.INSTANCE.m2519Track4EFweAY(rangeSliderState, (Modifier) null, z3, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer2, (i25 & 14) | 100663296, 242);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54);
                                    } else {
                                        function38 = composableLambda2;
                                        composableLambda3 = function33;
                                    }
                                    obj = obj4;
                                    function39 = function37;
                                    if (i19 != 0) {
                                        function310 = composableLambda3;
                                        i22 = i5;
                                        i21 = 0;
                                    } else {
                                        i21 = i;
                                        function310 = composableLambda3;
                                        i22 = i5;
                                    }
                                    obj6 = obj5;
                                    function311 = function38;
                                }
                                startRestartGroup.endDefaults();
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function313 = function39;
                                if (ComposerKt.isTraceInProgress()) {
                                    function312 = function311;
                                    ComposerKt.traceEventStart(1924256162, i22, i18, "androidx.compose.material3.RangeSlider (Slider.kt:624)");
                                } else {
                                    function312 = function311;
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1920690672, "CC(remember):Slider.kt#9igjgp");
                                int i25 = i18;
                                boolean z5 = ((((57344 & i22) ^ 24576) > 16384 && startRestartGroup.changed(obj6)) || (i22 & 24576) == 16384) | ((i18 & 896) == 256);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (z5 || rememberedValue3 == Composer.Companion.getEmpty()) {
                                    int i26 = i21;
                                    rememberedValue3 = new RangeSliderState(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), i26, obj2, obj6);
                                    i20 = i26;
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                } else {
                                    i20 = i21;
                                }
                                RangeSliderState rangeSliderState = (RangeSliderState) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                rangeSliderState.setOnValueChangeFinished(obj2);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1920680562, "CC(remember):Slider.kt#9igjgp");
                                boolean z6 = (i22 & 112) == 32;
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (z6 || rememberedValue4 == Composer.Companion.getEmpty()) {
                                    rememberedValue4 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda16
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj7) {
                                            return SliderKt.RangeSlider$lambda$18$lambda$17(Function1.this, (SliderRange) obj7);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                rangeSliderState.setOnValueChange$material3((Function1) rememberedValue4);
                                rangeSliderState.setActiveRangeStart(closedFloatingPointRange.getStart().floatValue());
                                rangeSliderState.setActiveRangeEnd(closedFloatingPointRange.getEndInclusive().floatValue());
                                int i27 = i22 >> 9;
                                int i28 = ((i22 >> 3) & 1008) | (57344 & i27) | (458752 & i27) | (i27 & 3670016);
                                int i29 = i25 << 21;
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function314 = function310;
                                RangeSlider(rangeSliderState, obj, z3, null, mutableInteractionSource5, mutableInteractionSource6, function313, function312, function314, startRestartGroup, i28 | (29360128 & i29) | (i29 & 234881024), 8);
                                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function315 = function312;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource5;
                                function34 = function313;
                                z2 = z3;
                                mutableInteractionSource3 = mutableInteractionSource7;
                                sliderColors3 = sliderColors2;
                                mutableInteractionSource4 = mutableInteractionSource6;
                                function36 = function314;
                                function02 = obj2;
                                function35 = function315;
                                closedFloatingPointRange4 = obj6;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z2 = z;
                                function34 = function3;
                                i20 = i;
                                closedFloatingPointRange4 = closedFloatingPointRange3;
                                sliderColors3 = sliderColors2;
                                function02 = obj2;
                                mutableInteractionSource3 = obj3;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                function35 = function32;
                                function36 = function33;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier2 = obj;
                                final int i30 = i20;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj7, Object obj8) {
                                        return SliderKt.RangeSlider$lambda$19(ClosedFloatingPointRange.this, function1, modifier2, z2, closedFloatingPointRange4, function02, sliderColors3, mutableInteractionSource3, mutableInteractionSource4, function34, function35, function36, i30, i2, i3, i4, (Composer) obj7, ((Integer) obj8).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i12 = i11;
                    i13 = i4 & 1024;
                    if (i13 != 0) {
                    }
                    i16 = i4 & 2048;
                    if (i16 != 0) {
                    }
                    i18 = i15;
                    i19 = i4 & 4096;
                    if (i19 != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i10 = i9;
                i11 = i4 & 512;
                if (i11 == 0) {
                }
                i12 = i11;
                i13 = i4 & 1024;
                if (i13 != 0) {
                }
                i16 = i4 & 2048;
                if (i16 != 0) {
                }
                i18 = i15;
                i19 = i4 & 4096;
                if (i19 != 0) {
                }
                if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i2 & 24576) == 0) {
            }
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            i8 = i4 & 128;
            if (i8 != 0) {
            }
            i9 = i4 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i4 & 512;
            if (i11 == 0) {
            }
            i12 = i11;
            i13 = i4 & 1024;
            if (i13 != 0) {
            }
            i16 = i4 & 2048;
            if (i16 != 0) {
            }
            i18 = i15;
            i19 = i4 & 4096;
            if (i19 != 0) {
            }
            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        obj = modifier;
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        i8 = i4 & 128;
        if (i8 != 0) {
        }
        i9 = i4 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i4 & 512;
        if (i11 == 0) {
        }
        i12 = i11;
        i13 = i4 & 1024;
        if (i13 != 0) {
        }
        i16 = i4 & 2048;
        if (i16 != 0) {
        }
        i18 = i15;
        i19 = i4 & 4096;
        if (i19 != 0) {
        }
        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i18 & 147) != 146, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final Unit RangeSlider$lambda$18$lambda$17(Function1 function1, SliderRange sliderRange) {
        function1.invoke(RangesKt.rangeTo(SliderRange.m2545getStartimpl(sliderRange.m2548unboximpl()), SliderRange.m2544getEndInclusiveimpl(sliderRange.m2548unboximpl())));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:190:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:327:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i, final int i2) {
        RangeSliderState rangeSliderState2;
        int i3;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        int i5;
        Object obj;
        int i6;
        final Object obj2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Modifier modifier2;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        final boolean z3;
        final SliderColors sliderColors3;
        final MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36;
        ScopeUpdateScope endRestartGroup;
        final MutableInteractionSource mutableInteractionSource5;
        ComposableLambda composableLambda;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource6;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function38;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-781154979);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)N(state,modifier,enabled,colors,startInteractionSource,endInteractionSource,startThumb,endThumb,track)729@33295L296:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            rangeSliderState2 = rangeSliderState;
        } else {
            rangeSliderState2 = rangeSliderState;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(rangeSliderState2) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    obj = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(obj) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        obj2 = mutableInteractionSource2;
                        i3 |= startRestartGroup.changed(obj2) ? 131072 : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        i8 = i2 & 128;
                        if (i8 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i9 = i8;
                            i3 |= startRestartGroup.changedInstance(function32) ? 8388608 : 4194304;
                            i10 = i2 & 256;
                            if (i10 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i11 = i10;
                                i3 |= startRestartGroup.changedInstance(function33) ? 67108864 : 33554432;
                                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "702@32359L8,703@32424L39,704@32518L39,705@32616L163,712@32836L161,719@33051L176");
                                    if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i2 & 8) != 0) {
                                            i3 &= -7169;
                                        }
                                        modifier3 = modifier;
                                        function37 = function3;
                                        function38 = function32;
                                        composableLambda = function33;
                                        mutableInteractionSource6 = obj;
                                    } else {
                                        Modifier.Companion companion = i13 != 0 ? Modifier.Companion : modifier;
                                        if (i4 != 0) {
                                            z2 = true;
                                        }
                                        if ((i2 & 8) != 0) {
                                            i3 &= -7169;
                                            sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        }
                                        if (i5 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 929350180, "CC(remember):Slider.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            mutableInteractionSource5 = (MutableInteractionSource) rememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            mutableInteractionSource5 = obj;
                                        }
                                        if (i6 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 929353188, "CC(remember):Slider.kt#9igjgp");
                                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                                rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            obj2 = (MutableInteractionSource) rememberedValue2;
                                        }
                                        ComposableLambda rememberComposableLambda = i7 != 0 ? ComposableLambdaKt.rememberComposableLambda(1597255314, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$14
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                invoke(rangeSliderState3, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "CN(it)706@32641L132:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1597255314, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:706)");
                                                }
                                                SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54) : function3;
                                        ComposableLambda rememberComposableLambda2 = i9 != 0 ? ComposableLambdaKt.rememberComposableLambda(1348023737, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$15
                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                invoke(rangeSliderState3, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                ComposerKt.sourceInformation(composer3, "CN(it)713@32861L130:Slider.kt#uh7d8r");
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1348023737, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:713)");
                                                }
                                                SliderDefaults.INSTANCE.m2517Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54) : function32;
                                        if (i11 != 0) {
                                            modifier3 = companion;
                                            composableLambda = ComposableLambdaKt.rememberComposableLambda(-453269015, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$16
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(RangeSliderState rangeSliderState3, Composer composer3, Integer num) {
                                                    invoke(rangeSliderState3, composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(RangeSliderState rangeSliderState3, Composer composer3, int i14) {
                                                    ComposerKt.sourceInformation(composer3, "CN(rangeSliderState)720@33096L125:Slider.kt#uh7d8r");
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-453269015, i14, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:720)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2519Track4EFweAY(rangeSliderState3, (Modifier) null, z2, sliderColors2, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer3, (i14 & 14) | 100663296, 242);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, startRestartGroup, 54);
                                        } else {
                                            composableLambda = function33;
                                            modifier3 = companion;
                                        }
                                        mutableInteractionSource6 = mutableInteractionSource5;
                                        function37 = rememberComposableLambda;
                                        function38 = rememberComposableLambda2;
                                    }
                                    MutableInteractionSource mutableInteractionSource7 = obj2;
                                    boolean z4 = z2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-781154979, i3, -1, "androidx.compose.material3.RangeSlider (Slider.kt:726)");
                                    }
                                    if (rangeSliderState2.getSteps() < 0) {
                                        throw new IllegalArgumentException("steps should be >= 0".toString());
                                    }
                                    int i14 = i3 >> 3;
                                    composer2 = startRestartGroup;
                                    RangeSliderImpl(modifier3, rangeSliderState2, z4, mutableInteractionSource6, mutableInteractionSource7, function37, function38, composableLambda, composer2, (i3 & 896) | (i14 & 14) | ((i3 << 3) & 112) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 29360128));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    sliderColors3 = sliderColors2;
                                    modifier2 = modifier3;
                                    z3 = z4;
                                    mutableInteractionSource3 = mutableInteractionSource6;
                                    mutableInteractionSource4 = mutableInteractionSource7;
                                    function35 = function37;
                                    function34 = function38;
                                    function36 = composableLambda;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    function34 = function32;
                                    z3 = z2;
                                    sliderColors3 = sliderColors2;
                                    mutableInteractionSource3 = obj;
                                    mutableInteractionSource4 = obj2;
                                    function35 = function3;
                                    function36 = function33;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda22
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj3, Object obj4) {
                                            return SliderKt.RangeSlider$lambda$23(RangeSliderState.this, modifier2, z3, sliderColors3, mutableInteractionSource3, mutableInteractionSource4, function35, function34, function36, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i11 = i10;
                            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i9 = i8;
                        i10 = i2 & 256;
                        if (i10 == 0) {
                        }
                        i11 = i10;
                        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    obj2 = mutableInteractionSource2;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                    }
                    i9 = i8;
                    i10 = i2 & 256;
                    if (i10 == 0) {
                    }
                    i11 = i10;
                    if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj = mutableInteractionSource;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                obj2 = mutableInteractionSource2;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 == 0) {
                }
                i11 = i10;
                if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            obj = mutableInteractionSource;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            obj2 = mutableInteractionSource2;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            i8 = i2 & 128;
            if (i8 != 0) {
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 == 0) {
            }
            i11 = i10;
            if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        obj = mutableInteractionSource;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        obj2 = mutableInteractionSource2;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        i8 = i2 & 128;
        if (i8 != 0) {
        }
        i9 = i8;
        i10 = i2 & 256;
        if (i10 == 0) {
        }
        i11 = i10;
        if (startRestartGroup.shouldExecute((i3 & 38347923) != 38347922, i3 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final void SliderImpl(final Modifier modifier, final SliderState sliderState, final boolean z, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i) {
        int i2;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        MutableInteractionSource mutableInteractionSource2;
        Modifier wrapContentWidth$default;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34 = function32;
        Composer startRestartGroup = composer.startRestartGroup(898172835);
        ComposerKt.sourceInformation(startRestartGroup, "C(SliderImpl)N(modifier,state,enabled,interactionSource,thumb,track)751@33925L7,762@34446L28,806@36026L3110,773@34814L4322:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(sliderState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function34) ? 131072 : 65536;
        }
        if (!startRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            function33 = function3;
            mutableInteractionSource2 = mutableInteractionSource;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(898172835, i2, -1, "androidx.compose.material3.SliderImpl (Slider.kt:750)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            sliderState.setRtl$material3(consume == LayoutDirection.Rtl);
            boolean z2 = (sliderState.getOrientation$material3() == Orientation.Horizontal && sliderState.isRtl$material3()) || (sliderState.getOrientation$material3() == Orientation.Vertical && sliderState.getReverseVerticalDirection$material3());
            Modifier sliderTapModifier = sliderTapModifier(Modifier.Companion, sliderState, mutableInteractionSource, z);
            Modifier.Companion companion = Modifier.Companion;
            Orientation orientation$material3 = sliderState.getOrientation$material3();
            boolean z3 = z2;
            boolean isDragging = sliderState.isDragging();
            Modifier.Companion companion2 = companion;
            SliderState sliderState2 = sliderState;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -144304801, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(sliderState);
            SliderKt$SliderImpl$drag$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SliderKt$SliderImpl$drag$1$1(sliderState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i3 = i2;
            Modifier draggable$default = DraggableKt.draggable$default(companion2, sliderState2, orientation$material3, z, mutableInteractionSource, isDragging, null, (Function3) rememberedValue, z3, 32, null);
            mutableInteractionSource2 = mutableInteractionSource;
            if (sliderState.getOrientation$material3() == Orientation.Vertical) {
                wrapContentWidth$default = SizeKt.wrapContentHeight$default(LayoutIdKt.layoutId(Modifier.Companion, SliderComponents.THUMB), null, false, 3, null);
            } else {
                wrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, SliderComponents.THUMB), null, false, 3, null);
            }
            Modifier then = slideOnKeyEvents(FocusableKt.focusable(sliderSemantics(SizeKt.m860requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), sliderState.getOrientation$material3() == Orientation.Vertical ? TrackHeight : ThumbWidth, sliderState.getOrientation$material3() == Orientation.Vertical ? ThumbWidth : TrackHeight, 0.0f, 0.0f, 12, null), sliderState, z), z, mutableInteractionSource2), z, sliderState.getSteps(), sliderState.getValueRange(), sliderState.getValue(), z3, sliderState.getOnValueChange(), sliderState.getOnValueChangeFinished()).then(sliderTapModifier).then(draggable$default);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -144251159, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(sliderState);
            SliderKt$SliderImpl$2$1 rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new SliderKt$SliderImpl$2$1(sliderState);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1885666906, "C777@34924L129,775@34844L268,784@35125L74:Slider.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1878837019, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(sliderState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.SliderImpl$lambda$29$lambda$26$lambda$25(SliderState.this, (IntSize) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(wrapContentWidth$default, (Function1) rememberedValue3);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, onSizeChanged);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -294052009, "C782@35086L12:Slider.kt#uh7d8r");
            int i4 = (i3 >> 3) & 14;
            function33 = function3;
            function33.invoke(sliderState, startRestartGroup, Integer.valueOf(((i3 >> 9) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, SliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -836287744, "C784@35185L12:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(sliderState, startRestartGroup, Integer.valueOf(((i3 >> 12) & 112) | i4));
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35 = function34;
            final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function36 = function33;
            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.SliderImpl$lambda$31(Modifier.this, sliderState, z, mutableInteractionSource3, function36, function35, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit SliderImpl$lambda$29$lambda$26$lambda$25(SliderState sliderState, IntSize intSize) {
        sliderState.setThumbWidth$material3((int) (intSize.m7730unboximpl() >> 32));
        sliderState.setThumbHeight$material3((int) (intSize.m7730unboximpl() & 4294967295L));
        return Unit.INSTANCE;
    }

    private static final Modifier slideOnKeyEvents(Modifier modifier, final boolean z, final int i, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final float f, final boolean z2, final Function1<? super Float, Unit> function1, final Function0<Unit> function0) {
        if (i < 0) {
            throw new IllegalArgumentException("steps should be >= 0".toString());
        }
        return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.SliderKt$slideOnKeyEvents$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m2538invokeZmokQxo(keyEvent.m5917unboximpl());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke-ZmokQxo  reason: not valid java name */
            public final Boolean m2538invokeZmokQxo(android.view.KeyEvent keyEvent) {
                int i2;
                boolean z3 = false;
                if (z && function1 != null) {
                    int m5929getTypeZmokQxo = KeyEvent_androidKt.m5929getTypeZmokQxo(keyEvent);
                    if (KeyEventType.m5921equalsimpl0(m5929getTypeZmokQxo, KeyEventType.Companion.m5925getKeyDownCS__XNY())) {
                        float abs = Math.abs(closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue());
                        int i3 = i;
                        float f2 = abs / (i3 > 0 ? i3 + 1 : 100);
                        int i4 = z2 ? -1 : 1;
                        long m5928getKeyZmokQxo = KeyEvent_androidKt.m5928getKeyZmokQxo(keyEvent);
                        if (Key.m5620equalsimpl0(m5928getKeyZmokQxo, Key.Companion.m5698getDirectionUpEK5gGoQ())) {
                            function1.invoke(RangesKt.coerceIn(Float.valueOf(f + (i4 * f2)), closedFloatingPointRange));
                        } else if (Key.m5620equalsimpl0(m5928getKeyZmokQxo, Key.Companion.m5693getDirectionDownEK5gGoQ())) {
                            function1.invoke(RangesKt.coerceIn(Float.valueOf(f - (i4 * f2)), closedFloatingPointRange));
                        } else if (Key.m5620equalsimpl0(m5928getKeyZmokQxo, Key.Companion.m5697getDirectionRightEK5gGoQ())) {
                            function1.invoke(RangesKt.coerceIn(Float.valueOf(f + (i4 * f2)), closedFloatingPointRange));
                        } else if (Key.m5620equalsimpl0(m5928getKeyZmokQxo, Key.Companion.m5696getDirectionLeftEK5gGoQ())) {
                            function1.invoke(RangesKt.coerceIn(Float.valueOf(f - (i4 * f2)), closedFloatingPointRange));
                        } else if (Key.m5620equalsimpl0(m5928getKeyZmokQxo, Key.Companion.m5772getMoveHomeEK5gGoQ())) {
                            function1.invoke(closedFloatingPointRange.getStart());
                        } else if (Key.m5620equalsimpl0(m5928getKeyZmokQxo, Key.Companion.m5771getMoveEndEK5gGoQ())) {
                            function1.invoke(closedFloatingPointRange.getEndInclusive());
                        } else if (Key.m5620equalsimpl0(m5928getKeyZmokQxo, Key.Companion.m5809getPageUpEK5gGoQ())) {
                            function1.invoke(RangesKt.coerceIn(Float.valueOf(f - (RangesKt.coerceIn(i2 / 10, 1, 10) * f2)), closedFloatingPointRange));
                        } else {
                            if (Key.m5620equalsimpl0(m5928getKeyZmokQxo, Key.Companion.m5808getPageDownEK5gGoQ())) {
                                function1.invoke(RangesKt.coerceIn(Float.valueOf(f + (RangesKt.coerceIn(i2 / 10, 1, 10) * f2)), closedFloatingPointRange));
                            }
                            return Boolean.valueOf(z3);
                        }
                        z3 = true;
                        return Boolean.valueOf(z3);
                    }
                    if (KeyEventType.m5921equalsimpl0(m5929getTypeZmokQxo, KeyEventType.Companion.m5926getKeyUpCS__XNY())) {
                        long m5928getKeyZmokQxo2 = KeyEvent_androidKt.m5928getKeyZmokQxo(keyEvent);
                        if (Key.m5620equalsimpl0(m5928getKeyZmokQxo2, Key.Companion.m5698getDirectionUpEK5gGoQ()) || Key.m5620equalsimpl0(m5928getKeyZmokQxo2, Key.Companion.m5693getDirectionDownEK5gGoQ()) || Key.m5620equalsimpl0(m5928getKeyZmokQxo2, Key.Companion.m5697getDirectionRightEK5gGoQ()) || Key.m5620equalsimpl0(m5928getKeyZmokQxo2, Key.Companion.m5696getDirectionLeftEK5gGoQ()) || Key.m5620equalsimpl0(m5928getKeyZmokQxo2, Key.Companion.m5772getMoveHomeEK5gGoQ()) || Key.m5620equalsimpl0(m5928getKeyZmokQxo2, Key.Companion.m5771getMoveEndEK5gGoQ()) || Key.m5620equalsimpl0(m5928getKeyZmokQxo2, Key.Companion.m5809getPageUpEK5gGoQ()) || Key.m5620equalsimpl0(m5928getKeyZmokQxo2, Key.Companion.m5808getPageDownEK5gGoQ())) {
                            Function0<Unit> function02 = function0;
                            if (function02 != null) {
                                function02.invoke();
                            }
                            z3 = true;
                        }
                    }
                    return Boolean.valueOf(z3);
                }
                return false;
            }
        });
    }

    private static final void RangeSliderImpl(final Modifier modifier, final RangeSliderState rangeSliderState, final boolean z, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i) {
        Modifier modifier2;
        int i2;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35 = function33;
        Composer startRestartGroup = composer.startRestartGroup(-287468326);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSliderImpl)N(modifier,state,enabled,startInteractionSource,endInteractionSource,startThumb,endThumb,track)971@42967L7,981@43221L35,982@43289L33,1025@45118L3284,984@43328L5074:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i2 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(rangeSliderState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function35) ? 8388608 : 4194304;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            function34 = function32;
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-287468326, i2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:970)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            rangeSliderState.setRtl$material3(consume == LayoutDirection.Rtl);
            Modifier rangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.Companion, rangeSliderState, mutableInteractionSource, mutableInteractionSource2, z);
            Strings.Companion companion = Strings.Companion;
            final String m3088getString2EP1pXo = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.range_start), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.Companion;
            final String m3088getString2EP1pXo2 = Strings_androidKt.m3088getString2EP1pXo(Strings.m3009constructorimpl(androidx.compose.ui.R.string.range_end), startRestartGroup, 0);
            Modifier then = SizeKt.m860requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, null).then(rangeSliderPressDragModifier);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1379067122, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(rangeSliderState);
            SliderKt$RangeSliderImpl$2$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SliderKt$RangeSliderImpl$2$1(rangeSliderState);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            int i3 = i2;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1046432705, "C990@43545L171,995@43849L100,986@43358L723,1006@44279L167,1011@44577L98,1002@44094L709,1018@44816L79:Slider.kt#uh7d8r");
            Modifier wrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.STARTTHUMB), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1905911374, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(rangeSliderState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$34$lambda$33(RangeSliderState.this, (IntSize) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier rangeSliderStartThumbSemantics = rangeSliderStartThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(wrapContentWidth$default, (Function1) rememberedValue2), rangeSliderState, z);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1905921031, "CC(remember):Slider.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m3088getString2EP1pXo);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$36$lambda$35(m3088getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier focusable = FocusableKt.focusable(SemanticsModifierKt.semantics(rangeSliderStartThumbSemantics, true, (Function1) rememberedValue3), z, mutableInteractionSource);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, focusable);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 239610549, "C1000@44050L17:Slider.kt#uh7d8r");
            int i4 = (i3 >> 3) & 14;
            function3.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i3 >> 12) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier wrapContentWidth$default2 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.ENDTHUMB), null, false, 3, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1905934858, "CC(remember):Slider.kt#9igjgp");
            boolean changedInstance3 = startRestartGroup.changedInstance(rangeSliderState);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$39$lambda$38(RangeSliderState.this, (IntSize) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier rangeSliderEndThumbSemantics = rangeSliderEndThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(wrapContentWidth$default2, (Function1) rememberedValue4), rangeSliderState, z);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1905944325, "CC(remember):Slider.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(m3088getString2EP1pXo2);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$44$lambda$41$lambda$40(m3088getString2EP1pXo2, (SemanticsPropertyReceiver) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier focusable2 = FocusableKt.focusable(SemanticsModifierKt.semantics(rangeSliderEndThumbSemantics, true, (Function1) rememberedValue5), z, mutableInteractionSource2);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, focusable2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 85810862, "C1016@44774L15:Slider.kt#uh7d8r");
            function34 = function32;
            function34.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i3 >> 15) & 112) | i4));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.Companion, RangeSliderComponents.TRACK);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, layoutId);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -979172334, "C1018@44881L12:Slider.kt#uh7d8r");
            function35 = function33;
            function35.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i3 >> 18) & 112) | i4));
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36 = function34;
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.RangeSliderImpl$lambda$46(Modifier.this, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function36, function35, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit RangeSliderImpl$lambda$44$lambda$34$lambda$33(RangeSliderState rangeSliderState, IntSize intSize) {
        rangeSliderState.setStartThumbWidth$material3((int) (intSize.m7730unboximpl() >> 32));
        rangeSliderState.setStartThumbHeight$material3((int) (intSize.m7730unboximpl() & 4294967295L));
        return Unit.INSTANCE;
    }

    public static final Unit RangeSliderImpl$lambda$44$lambda$36$lambda$35(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    public static final Unit RangeSliderImpl$lambda$44$lambda$39$lambda$38(RangeSliderState rangeSliderState, IntSize intSize) {
        rangeSliderState.setEndThumbWidth$material3((int) (intSize.m7730unboximpl() >> 32));
        rangeSliderState.setEndThumbHeight$material3((int) (intSize.m7730unboximpl() & 4294967295L));
        return Unit.INSTANCE;
    }

    public static final Unit RangeSliderImpl$lambda$44$lambda$41$lambda$40(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0064 A[RETURN] */
    /* renamed from: awaitSlop-8vUncbI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2534awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        int i2;
        Ref.FloatRef floatRef;
        PointerInputChange pointerInputChange;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            if ((sliderKt$awaitSlop$1.label & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label -= Integer.MIN_VALUE;
                SliderKt$awaitSlop$1 sliderKt$awaitSlop$12 = sliderKt$awaitSlop$1;
                Object obj = sliderKt$awaitSlop$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = sliderKt$awaitSlop$12.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    Function2 function2 = new Function2() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return SliderKt.awaitSlop_8vUncbI$lambda$49(Ref.FloatRef.this, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                        }
                    };
                    sliderKt$awaitSlop$12.L$0 = floatRef2;
                    sliderKt$awaitSlop$12.label = 1;
                    Object m2995awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m2995awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$12);
                    if (m2995awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = m2995awaitHorizontalPointerSlopOrCancellationgDDlDlE;
                    floatRef = floatRef2;
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    floatRef = (Ref.FloatRef) sliderKt$awaitSlop$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange == null) {
                    return TuplesKt.to(pointerInputChange, Boxing.boxFloat(floatRef.element));
                }
                return null;
            }
        }
        sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$122 = sliderKt$awaitSlop$1;
        Object obj2 = sliderKt$awaitSlop$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = sliderKt$awaitSlop$122.label;
        if (i2 != 0) {
        }
        pointerInputChange = (PointerInputChange) obj2;
        if (pointerInputChange == null) {
        }
    }

    public static final Unit awaitSlop_8vUncbI$lambda$49(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f) {
        pointerInputChange.consume();
        floatRef.element = f;
        return Unit.INSTANCE;
    }

    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i2 = i + 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = i3 / (i + 1);
        }
        return fArr;
    }

    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* renamed from: scale-2geJ7wY */
    public static final long m2537scale2geJ7wY(boolean z, float f, float f2, long j, float f3, float f4) {
        float scale = scale(f, f2, SliderRange.m2545getStartimpl(j), f3, f4);
        float scale2 = scale(f, f2, SliderRange.m2544getEndInclusiveimpl(j), f3, f4);
        if (z) {
            return SliderRange(RangesKt.coerceAtMost(scale, scale2), scale2);
        }
        return SliderRange(scale, RangesKt.coerceAtLeast(scale2, scale));
    }

    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return RangesKt.coerceIn(f4 == 0.0f ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    private static final Modifier sliderSemantics(Modifier modifier, final SliderState sliderState, final boolean z) {
        Modifier increaseHorizontalSemanticsBounds;
        Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.sliderSemantics$lambda$52(z, sliderState, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null);
        if (sliderState.getOrientation$material3() == Orientation.Vertical) {
            increaseHorizontalSemanticsBounds = AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds();
        } else {
            increaseHorizontalSemanticsBounds = AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds();
        }
        return ProgressSemanticsKt.progressSemantics(semantics$default.then(increaseHorizontalSemanticsBounds), sliderState.getValue(), RangesKt.rangeTo(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue()), sliderState.getSteps());
    }

    public static final Unit sliderSemantics$lambda$52(boolean z, final SliderState sliderState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(sliderState.getValue()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.sliderSemantics$lambda$52$lambda$51(SliderState.this, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    public static final boolean sliderSemantics$lambda$52$lambda$51(SliderState sliderState, float f) {
        int steps;
        float coerceIn = RangesKt.coerceIn(f, sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue());
        if (sliderState.getSteps() > 0 && (steps = sliderState.getSteps() + 1) >= 0) {
            float f2 = coerceIn;
            float f3 = f2;
            int i = 0;
            while (true) {
                float lerp = MathHelpersKt.lerp(sliderState.getValueRange().getStart().floatValue(), sliderState.getValueRange().getEndInclusive().floatValue(), i / (sliderState.getSteps() + 1));
                float f4 = lerp - coerceIn;
                if (Math.abs(f4) <= f2) {
                    f2 = Math.abs(f4);
                    f3 = lerp;
                }
                if (i == steps) {
                    break;
                }
                i++;
            }
            coerceIn = f3;
        }
        if (coerceIn == sliderState.getValue()) {
            return false;
        }
        if (coerceIn != sliderState.getValue()) {
            if (sliderState.getOnValueChange() != null) {
                Function1<Float, Unit> onValueChange = sliderState.getOnValueChange();
                if (onValueChange != null) {
                    onValueChange.invoke(Float.valueOf(coerceIn));
                }
            } else {
                sliderState.setValue(coerceIn);
            }
        }
        Function0<Unit> onValueChangeFinished = sliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(rangeSliderState.getValueRange().getStart().floatValue(), rangeSliderState.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.rangeSliderStartThumbSemantics$lambda$55(z, rangeSliderState, rangeTo, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeStart(), rangeTo, rangeSliderState.getStartSteps$material3());
    }

    public static final Unit rangeSliderStartThumbSemantics$lambda$55(boolean z, final RangeSliderState rangeSliderState, final ClosedFloatingPointRange closedFloatingPointRange, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(rangeSliderState.getActiveRangeStart()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.rangeSliderStartThumbSemantics$lambda$55$lambda$54(ClosedFloatingPointRange.this, rangeSliderState, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    public static final boolean rangeSliderStartThumbSemantics$lambda$55$lambda$54(ClosedFloatingPointRange closedFloatingPointRange, RangeSliderState rangeSliderState, float f) {
        int startSteps$material3;
        float coerceIn = RangesKt.coerceIn(f, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        if (rangeSliderState.getStartSteps$material3() > 0 && (startSteps$material3 = rangeSliderState.getStartSteps$material3() + 1) >= 0) {
            float f2 = coerceIn;
            float f3 = f2;
            int i = 0;
            while (true) {
                float lerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i / (rangeSliderState.getStartSteps$material3() + 1));
                float f4 = lerp - coerceIn;
                if (Math.abs(f4) <= f2) {
                    f2 = Math.abs(f4);
                    f3 = lerp;
                }
                if (i == startSteps$material3) {
                    break;
                }
                i++;
            }
            coerceIn = f3;
        }
        if (coerceIn == rangeSliderState.getActiveRangeStart()) {
            return false;
        }
        long SliderRange = SliderRange(coerceIn, rangeSliderState.getActiveRangeEnd());
        if (!SliderRange.m2543equalsimpl0(SliderRange, SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd()))) {
            if (rangeSliderState.getOnValueChange$material3() != null) {
                Function1<SliderRange, Unit> onValueChange$material3 = rangeSliderState.getOnValueChange$material3();
                if (onValueChange$material3 != null) {
                    onValueChange$material3.invoke(SliderRange.m2540boximpl(SliderRange));
                }
            } else {
                rangeSliderState.setActiveRangeStart(SliderRange.m2545getStartimpl(SliderRange));
                rangeSliderState.setActiveRangeEnd(SliderRange.m2544getEndInclusiveimpl(SliderRange));
            }
        }
        Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange<Float> rangeTo = RangesKt.rangeTo(rangeSliderState.getActiveRangeStart(), rangeSliderState.getValueRange().getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.rangeSliderEndThumbSemantics$lambda$58(z, rangeSliderState, rangeTo, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeEnd(), rangeTo, rangeSliderState.getEndSteps$material3());
    }

    public static final Unit rangeSliderEndThumbSemantics$lambda$58(boolean z, final RangeSliderState rangeSliderState, final ClosedFloatingPointRange closedFloatingPointRange, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, formatForSemantics(rangeSliderState.getActiveRangeEnd()));
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.rangeSliderEndThumbSemantics$lambda$58$lambda$57(ClosedFloatingPointRange.this, rangeSliderState, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    public static final boolean rangeSliderEndThumbSemantics$lambda$58$lambda$57(ClosedFloatingPointRange closedFloatingPointRange, RangeSliderState rangeSliderState, float f) {
        int endSteps$material3;
        float coerceIn = RangesKt.coerceIn(f, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        if (rangeSliderState.getEndSteps$material3() > 0 && (endSteps$material3 = rangeSliderState.getEndSteps$material3() + 1) >= 0) {
            float f2 = coerceIn;
            float f3 = f2;
            int i = 0;
            while (true) {
                float lerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i / (rangeSliderState.getEndSteps$material3() + 1));
                float f4 = lerp - coerceIn;
                if (Math.abs(f4) <= f2) {
                    f2 = Math.abs(f4);
                    f3 = lerp;
                }
                if (i == endSteps$material3) {
                    break;
                }
                i++;
            }
            coerceIn = f3;
        }
        if (coerceIn == rangeSliderState.getActiveRangeEnd()) {
            return false;
        }
        long SliderRange = SliderRange(rangeSliderState.getActiveRangeStart(), coerceIn);
        if (!SliderRange.m2543equalsimpl0(SliderRange, SliderRange(rangeSliderState.getActiveRangeStart(), rangeSliderState.getActiveRangeEnd()))) {
            if (rangeSliderState.getOnValueChange$material3() != null) {
                Function1<SliderRange, Unit> onValueChange$material3 = rangeSliderState.getOnValueChange$material3();
                if (onValueChange$material3 != null) {
                    onValueChange$material3.invoke(SliderRange.m2540boximpl(SliderRange));
                }
            } else {
                rangeSliderState.setActiveRangeStart(SliderRange.m2545getStartimpl(SliderRange));
                rangeSliderState.setActiveRangeEnd(SliderRange.m2544getEndInclusiveimpl(SliderRange));
            }
        }
        Function0<Unit> onValueChangeFinished = rangeSliderState.getOnValueChangeFinished();
        if (onValueChangeFinished != null) {
            onValueChangeFinished.invoke();
        }
        return true;
    }

    private static final String formatForSemantics(float f) {
        return String.valueOf(MathKt.roundToInt(f * 100.0f) / 100.0f);
    }

    private static final Modifier sliderTapModifier(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, sliderState, mutableInteractionSource, new SliderKt$sliderTapModifier$1(sliderState)) : modifier;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, final RangeSliderState rangeSliderState, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, boolean z) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, new PointerInputEventHandler() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1

            /* compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {2437}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1  reason: invalid class name */
            /* loaded from: classes.dex */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ RangeSliderState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(PointerInputScope pointerInputScope, RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = rangeSliderState;
                    this.$rangeSliderLogic = rangeSliderLogic;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, this.$rangeSliderLogic, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: Slider.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2}, l = {2438, 2450, 2473}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", NotificationCompat.CATEGORY_EVENT, "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
                /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1  reason: invalid class name and collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C00201 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    final /* synthetic */ RangeSliderState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00201(RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, CoroutineScope coroutineScope, Continuation<? super C00201> continuation) {
                        super(2, continuation);
                        this.$state = rangeSliderState;
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$$this$coroutineScope = coroutineScope;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00201 c00201 = new C00201(this.$state, this.$rangeSliderLogic, this.$$this$coroutineScope, continuation);
                        c00201.L$0 = obj;
                        return c00201;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00201) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x018a  */
                    /* JADX WARN: Removed duplicated region for block: B:59:0x0194 A[Catch: all -> 0x0026, CancellationException -> 0x01a6, TryCatch #0 {all -> 0x0026, blocks: (B:8:0x001f, B:57:0x018c, B:59:0x0194, B:60:0x019c, B:63:0x01a6, B:53:0x0164), top: B:69:0x000f }] */
                    /* JADX WARN: Removed duplicated region for block: B:60:0x019c A[Catch: all -> 0x0026, CancellationException -> 0x01a6, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:8:0x001f, B:57:0x018c, B:59:0x0194, B:60:0x019c, B:63:0x01a6, B:53:0x0164), top: B:69:0x000f }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        Object awaitFirstDown$default;
                        AwaitPointerEventScope awaitPointerEventScope;
                        PointerInputChange pointerInputChange;
                        char c;
                        Object m2534awaitSlop8vUncbI;
                        Ref.FloatRef floatRef;
                        DragInteraction.Start start;
                        final Ref.BooleanRef booleanRef;
                        Pair pair;
                        Ref.BooleanRef booleanRef2;
                        DragInteraction.Start start2;
                        Object m474horizontalDragjO51t88;
                        DragInteraction.Cancel cancel;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        try {
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                                this.L$0 = awaitPointerEventScope2;
                                this.label = 1;
                                awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                                if (awaitFirstDown$default != coroutine_suspended) {
                                    awaitPointerEventScope = awaitPointerEventScope2;
                                }
                                return coroutine_suspended;
                            } else if (i != 1) {
                                if (i != 2) {
                                    if (i == 3) {
                                        booleanRef2 = (Ref.BooleanRef) this.L$1;
                                        start2 = (DragInteraction.Start) this.L$0;
                                        try {
                                            ResultKt.throwOnFailure(obj);
                                            m474horizontalDragjO51t88 = obj;
                                            if (!((Boolean) m474horizontalDragjO51t88).booleanValue()) {
                                                cancel = new DragInteraction.Stop(start2);
                                            } else {
                                                cancel = new DragInteraction.Cancel(start2);
                                            }
                                        } catch (CancellationException unused) {
                                            cancel = new DragInteraction.Cancel(start2);
                                            this.$state.setDragging$material3(false);
                                            this.$state.getGestureEndAction$material3().invoke(Boxing.boxBoolean(booleanRef2.element));
                                            BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                            return Unit.INSTANCE;
                                        }
                                        this.$state.setDragging$material3(false);
                                        this.$state.getGestureEndAction$material3().invoke(Boxing.boxBoolean(booleanRef2.element));
                                        BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                        return Unit.INSTANCE;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                booleanRef = (Ref.BooleanRef) this.L$4;
                                start = (DragInteraction.Start) this.L$2;
                                pointerInputChange = (PointerInputChange) this.L$1;
                                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                c = ' ';
                                floatRef = (Ref.FloatRef) this.L$3;
                                m2534awaitSlop8vUncbI = obj;
                                pair = (Pair) m2534awaitSlop8vUncbI;
                                if (pair != null) {
                                    RangeSliderState rangeSliderState = this.$state;
                                    float m2998pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m2998pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.m6088getTypeT8wyACA());
                                    if (Math.abs(rangeSliderState.getRawOffsetEnd$material3() - floatRef.element) < m2998pointerSlopE8SPZFQ && Math.abs(rangeSliderState.getRawOffsetStart$material3() - floatRef.element) < m2998pointerSlopE8SPZFQ) {
                                        float floatValue = ((Number) pair.getSecond()).floatValue();
                                        booleanRef.element = !rangeSliderState.isRtl$material3() ? floatValue >= 0.0f : floatValue < 0.0f;
                                        floatRef.element += Float.intBitsToFloat((int) (PointerEventKt.positionChange((PointerInputChange) pair.getFirst()) >> c));
                                    }
                                }
                                this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                                try {
                                    this.$state.setDragging$material3(true);
                                    long m6083getIdJ3iCeTQ = pointerInputChange.m6083getIdJ3iCeTQ();
                                    final RangeSliderState rangeSliderState2 = this.$state;
                                    this.L$0 = start;
                                    this.L$1 = booleanRef;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.label = 3;
                                    m474horizontalDragjO51t88 = DragGestureDetectorKt.m474horizontalDragjO51t88(awaitPointerEventScope, m6083getIdJ3iCeTQ, 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0183: INVOKE  (r3v1 'm474horizontalDragjO51t88' java.lang.Object) = 
                                          (r11v3 'awaitPointerEventScope' androidx.compose.ui.input.pointer.AwaitPointerEventScope)
                                          (r4v6 'm6083getIdJ3iCeTQ' long)
                                          (wrap: kotlin.jvm.functions.Function1 : 0x0171: CONSTRUCTOR  (r10v4 kotlin.jvm.functions.Function1 A[REMOVE]) = 
                                          (r8v1 'rangeSliderState2' androidx.compose.material3.RangeSliderState A[DONT_INLINE])
                                          (r2v6 'booleanRef' kotlin.jvm.internal.Ref$BooleanRef A[DONT_INLINE])
                                         call: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0.<init>(androidx.compose.material3.RangeSliderState, kotlin.jvm.internal.Ref$BooleanRef):void type: CONSTRUCTOR)
                                          (r17v0 'this' androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1 A[IMMUTABLE_TYPE, THIS])
                                         type: STATIC call: androidx.compose.foundation.gestures.DragGestureDetectorKt.horizontalDrag-jO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object in method: androidx.compose.material3.SliderKt.rangeSliderPressDragModifier.1.1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:156)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:133)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:302)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                        	... 39 more
                                        */
                                    /*
                                        Method dump skipped, instructions count: 477
                                        To view this dump add '--comments-level debug' option
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1.AnonymousClass1.C00201.invokeSuspend(java.lang.Object):java.lang.Object");
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                public static final Unit invokeSuspend$lambda$1(RangeSliderState rangeSliderState, Ref.BooleanRef booleanRef, PointerInputChange pointerInputChange) {
                                    float intBitsToFloat = Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) >> 32));
                                    boolean z = booleanRef.element;
                                    if (rangeSliderState.isRtl$material3()) {
                                        intBitsToFloat = -intBitsToFloat;
                                    }
                                    rangeSliderState.onDrag$material3(z, intBitsToFloat);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: Slider.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", i = {}, l = {2493}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2  reason: invalid class name */
                                /* loaded from: classes.dex */
                                public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ Ref.BooleanRef $draggingStart;
                                    final /* synthetic */ DragInteraction $finishInteraction;
                                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                                        super(2, continuation);
                                        this.$rangeSliderLogic = rangeSliderLogic;
                                        this.$draggingStart = booleanRef;
                                        this.$finishInteraction = dragInteraction;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
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
                                            this.label = 1;
                                            if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, this) == coroutine_suspended) {
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

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    PointerInputScope pointerInputScope = this.$this_pointerInput;
                                    RangeSliderState rangeSliderState = this.$state;
                                    RangeSliderLogic rangeSliderLogic = this.$rangeSliderLogic;
                                    this.label = 1;
                                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, new C00201(rangeSliderState, rangeSliderLogic, (CoroutineScope) this.L$0, null), this) == coroutine_suspended) {
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

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, RangeSliderState.this, new RangeSliderLogic(RangeSliderState.this, mutableInteractionSource, mutableInteractionSource2), null), continuation);
                            return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
                        }
                    }) : modifier;
                }

                static {
                    float m3726getHandleWidthD9Ej5fM = SliderTokens.INSTANCE.m3726getHandleWidthD9Ej5fM();
                    ThumbWidth = m3726getHandleWidthD9Ej5fM;
                    float m3725getHandleHeightD9Ej5fM = SliderTokens.INSTANCE.m3725getHandleHeightD9Ej5fM();
                    ThumbHeight = m3725getHandleHeightD9Ej5fM;
                    ThumbSize = DpKt.m7577DpSizeYgX7TsA(m3726getHandleWidthD9Ej5fM, m3725getHandleHeightD9Ej5fM);
                    VerticalThumbSize = DpKt.m7577DpSizeYgX7TsA(m3725getHandleHeightD9Ej5fM, m3726getHandleWidthD9Ej5fM);
                    ThumbTrackGapSize = SliderTokens.INSTANCE.m3718getActiveHandleLeadingSpaceD9Ej5fM();
                    TrackInsideCornerSize = Dp.m7555constructorimpl(2.0f);
                    CornerSizeAlignmentLine = new VerticalAlignmentLine(SliderKt$CornerSizeAlignmentLine$1.INSTANCE);
                }

                public static final float getTrackHeight() {
                    return TrackHeight;
                }

                public static final float getThumbWidth() {
                    return ThumbWidth;
                }

                public static final SliderState rememberSliderState(final float f, final int i, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, int i2, int i3) {
                    ComposerKt.sourceInformationMarkerStart(composer, 1193499219, "C(rememberSliderState)N(value,steps,onValueChangeFinished,valueRange)2912@125235L188,2912@125156L267:Slider.kt#uh7d8r");
                    if ((i3 & 1) != 0) {
                        f = 0.0f;
                    }
                    if ((i3 & 2) != 0) {
                        i = 0;
                    }
                    if ((i3 & 4) != 0) {
                        function0 = null;
                    }
                    if ((i3 & 8) != 0) {
                        closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1193499219, i2, -1, "androidx.compose.material3.rememberSliderState (Slider.kt:2911)");
                    }
                    Object[] objArr = new Object[0];
                    Saver<SliderState, ?> Saver = SliderState.Companion.Saver(function0, closedFloatingPointRange);
                    ComposerKt.sourceInformationMarkerStart(composer, 196492495, "CC(remember):Slider.kt#9igjgp");
                    boolean z = true;
                    boolean z2 = ((((i2 & 14) ^ 6) > 4 && composer.changed(f)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(function0)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256);
                    if ((((i2 & 7168) ^ 3072) <= 2048 || !composer.changed(closedFloatingPointRange)) && (i2 & 3072) != 2048) {
                        z = false;
                    }
                    boolean z3 = z2 | z;
                    Object rememberedValue = composer.rememberedValue();
                    if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function0() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SliderKt.rememberSliderState$lambda$60$lambda$59(f, i, function0, closedFloatingPointRange);
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    SliderState sliderState = (SliderState) RememberSaveableKt.m4213rememberSaveable(objArr, Saver, (Function0<? extends Object>) rememberedValue, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return sliderState;
                }

                public static final SliderState rememberSliderState$lambda$60$lambda$59(float f, int i, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange) {
                    return new SliderState(f, i, function0, closedFloatingPointRange);
                }

                public static final RangeSliderState rememberRangeSliderState(float f, float f2, int i, Function0<Unit> function0, ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, int i2, int i3) {
                    ComposerKt.sourceInformationMarkerStart(composer, 756708139, "C(rememberRangeSliderState)N(activeRangeStart,activeRangeEnd,steps,onValueChangeFinished,valueRange)3126@135179L260,3126@135095L344:Slider.kt#uh7d8r");
                    final float f3 = (i3 & 1) != 0 ? 0.0f : f;
                    final float f4 = (i3 & 2) != 0 ? 1.0f : f2;
                    final int i4 = (i3 & 4) != 0 ? 0 : i;
                    final Function0<Unit> function02 = (i3 & 8) != 0 ? null : function0;
                    final ClosedFloatingPointRange<Float> rangeTo = (i3 & 16) != 0 ? RangesKt.rangeTo(0.0f, 1.0f) : closedFloatingPointRange;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(756708139, i2, -1, "androidx.compose.material3.rememberRangeSliderState (Slider.kt:3125)");
                    }
                    Object[] objArr = new Object[0];
                    Saver<RangeSliderState, ?> Saver = RangeSliderState.Companion.Saver(function02, rangeTo);
                    ComposerKt.sourceInformationMarkerStart(composer, 1347061551, "CC(remember):Slider.kt#9igjgp");
                    boolean z = true;
                    boolean z2 = ((((i2 & 14) ^ 6) > 4 && composer.changed(f3)) || (i2 & 6) == 4) | ((((i2 & 112) ^ 48) > 32 && composer.changed(f4)) || (i2 & 48) == 32) | ((((i2 & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(i4)) || (i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | ((((i2 & 7168) ^ 3072) > 2048 && composer.changed(function02)) || (i2 & 3072) == 2048);
                    if ((((57344 & i2) ^ 24576) <= 16384 || !composer.changed(rangeTo)) && (i2 & 24576) != 16384) {
                        z = false;
                    }
                    boolean z3 = z2 | z;
                    Object rememberedValue = composer.rememberedValue();
                    if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
                        Function0 function03 = new Function0() { // from class: androidx.compose.material3.SliderKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SliderKt.rememberRangeSliderState$lambda$62$lambda$61(f3, f4, i4, function02, rangeTo);
                            }
                        };
                        composer.updateRememberedValue(function03);
                        rememberedValue = function03;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    RangeSliderState rangeSliderState = (RangeSliderState) RememberSaveableKt.m4213rememberSaveable(objArr, Saver, (Function0<? extends Object>) rememberedValue, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return rangeSliderState;
                }

                public static final RangeSliderState rememberRangeSliderState$lambda$62$lambda$61(float f, float f2, int i, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange) {
                    return new RangeSliderState(f, f2, i, function0, closedFloatingPointRange);
                }

                public static final long SliderRange(float f, float f2) {
                    if ((!Float.isNaN(f) || !Float.isNaN(f2)) && f > f2) {
                        throw new IllegalArgumentException(("start(" + f + ") must be <= endInclusive(" + f2 + ')').toString());
                    }
                    return SliderRange.m2541constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
                }

                public static final long SliderRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
                    float floatValue = closedFloatingPointRange.getStart().floatValue();
                    float floatValue2 = closedFloatingPointRange.getEndInclusive().floatValue();
                    if ((!Float.isNaN(floatValue) || !Float.isNaN(floatValue2)) && floatValue > floatValue2) {
                        throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + floatValue + ") must be <= ClosedFloatingPoint.endInclusive(" + floatValue2 + ')').toString());
                    }
                    return SliderRange.m2541constructorimpl((Float.floatToRawIntBits(floatValue) << 32) | (Float.floatToRawIntBits(floatValue2) & 4294967295L));
                }

                /* renamed from: isSpecified-If1S1O4 */
                public static final boolean m2535isSpecifiedIf1S1O4(long j) {
                    return j != SliderRange.Companion.m2550getUnspecifiedFYbKRX4();
                }

                public static final VerticalAlignmentLine getCornerSizeAlignmentLine() {
                    return CornerSizeAlignmentLine;
                }

                public static final float snapValueToTick(float f, float[] fArr, float f2, float f3) {
                    Float valueOf;
                    if (fArr.length == 0) {
                        valueOf = null;
                    } else {
                        float f4 = fArr[0];
                        int lastIndex = ArraysKt.getLastIndex(fArr);
                        if (lastIndex != 0) {
                            float abs = Math.abs(MathHelpersKt.lerp(f2, f3, f4) - f);
                            int i = 1;
                            if (1 <= lastIndex) {
                                while (true) {
                                    float f5 = fArr[i];
                                    float abs2 = Math.abs(MathHelpersKt.lerp(f2, f3, f5) - f);
                                    if (Float.compare(abs, abs2) > 0) {
                                        f4 = f5;
                                        abs = abs2;
                                    }
                                    if (i == lastIndex) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                            valueOf = Float.valueOf(f4);
                        } else {
                            valueOf = Float.valueOf(f4);
                        }
                    }
                    return valueOf != null ? MathHelpersKt.lerp(f2, f3, valueOf.floatValue()) : f;
                }
            }
