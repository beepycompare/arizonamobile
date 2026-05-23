package androidx.compose.foundation.style;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.border.BorderLogic;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.text.modifiers.TextStyleProviderNode;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.shadow.DropShadowPainter;
import androidx.compose.ui.graphics.shadow.InnerShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
/* compiled from: StyleModifier.kt */
@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0019\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\"H\u0000¢\u0006\u0002\b?J\b\u0010@\u001a\u00020\"H\u0002J\b\u0010A\u001a\u00020\"H\u0002J#\u0010B\u001a\u00020C*\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\f\u0010K\u001a\u00020\u0010*\u00020\"H\u0002J\f\u0010L\u001a\u00020\u0010*\u00020\"H\u0002J\f\u0010X\u001a\u00020P*\u00020OH\u0002J#\u0010b\u001a\u00020a*\u00020c2\u0006\u0010d\u001a\u00020Z2\u0006\u0010e\u001a\u00020_H\u0002¢\u0006\u0004\bf\u0010gJ\f\u0010h\u001a\u00020P*\u00020cH\u0016J$\u0010p\u001a\u00020P*\u00020c2\u0006\u0010q\u001a\u00020=2\u0006\u0010e\u001a\u00020_2\u0006\u0010r\u001a\u00020kH\u0002J\u0016\u0010s\u001a\u00020P2\u0006\u0010t\u001a\u00020u2\u0006\u0010e\u001a\u00020_J\u0012\u0010p\u001a\u00020P*\u00020c2\u0006\u0010v\u001a\u00020\"J$\u0010{\u001a\u00020P*\u00020c2\u0006\u0010q\u001a\u00020=2\u0006\u0010e\u001a\u00020_2\u0006\u0010r\u001a\u00020kH\u0002J\u0016\u0010|\u001a\u00020P2\u0006\u0010t\u001a\u00020u2\u0006\u0010e\u001a\u00020_J\u0012\u0010{\u001a\u00020P*\u00020c2\u0006\u0010v\u001a\u00020\"J\u0080\u0001\u0010}\u001a\u00020P*\u00020c2\u0006\u0010e\u001a\u00020_2\u0006\u0010~\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u00102\u0007\u0010\u0080\u0001\u001a\u00020\u00102\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0085\u0001\u001a\u00030\u0082\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0087\u0001\u001a\u00030\u0082\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0012\u0010\u0090\u0001\u001a\u00020P2\t\b\u0002\u0010\u0091\u0001\u001a\u00020\u0010J\t\u0010\u0092\u0001\u001a\u00020PH\u0016J\u0007\u0010\u0099\u0001\u001a\u00020PJ'\u0010\u009f\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030¢\u00012\b\u0010£\u0001\u001a\u00030 \u0001H\u0016¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u0019\u0010¬\u0001\u001a\u0004\u0018\u00010\"2\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0003\b\u00ad\u0001J\u0011\u0010°\u0001\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0003\b±\u0001J\u0017\u0010²\u0001\u001a\u00020P2\u0006\u0010\u000b\u001a\u00020\"H\u0000¢\u0006\u0003\b³\u0001J\t\u0010´\u0001\u001a\u00020PH\u0002J\t\u0010µ\u0001\u001a\u00020PH\u0002J\t\u0010¶\u0001\u001a\u00020PH\u0016R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00148@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\f@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R-\u0010M\u001a\u0015\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P\u0018\u00010N¢\u0006\u0002\bQX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR%\u0010V\u001a\u0013\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0N¢\u0006\u0002\bQ8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bW\u0010SR\u0010\u0010Y\u001a\u00020ZX\u0082\u000e¢\u0006\u0004\n\u0002\u0010[R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010k\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010lR\u001a\u0010m\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010n\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010oR\u001a\u0010w\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010k\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010lR\u001a\u0010x\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010y\u0018\u00010jX\u0082\u000e¢\u0006\u0004\n\u0002\u0010zR\u0017\u0010\u008d\u0001\u001a\u00020u8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\"\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R+\u0010\u009a\u0001\u001a\u0003H\u009b\u0001\"\u0005\b\u0000\u0010\u009b\u0001*\n\u0012\u0005\u0012\u0003H\u009b\u00010\u009c\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R(\u0010¦\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0000\u0018\u00010§\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¯\u0001\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006·\u0001"}, d2 = {"Landroidx/compose/foundation/style/StyleOuterNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Landroidx/compose/foundation/text/modifiers/TextStyleProviderNode;", "styleState", "Landroidx/compose/foundation/style/StyleState;", "style", "Landroidx/compose/foundation/style/Style;", "<init>", "(Landroidx/compose/foundation/style/StyleState;Landroidx/compose/foundation/style/Style;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "innerNodeField", "Landroidx/compose/foundation/style/StyleInnerNode;", "getInnerNodeField$foundation", "()Landroidx/compose/foundation/style/StyleInnerNode;", "setInnerNodeField$foundation", "(Landroidx/compose/foundation/style/StyleInnerNode;)V", "value", "innerNode", "getInnerNode$foundation", "setInnerNode$foundation", "getStyle$foundation", "()Landroidx/compose/foundation/style/Style;", "setStyle$foundation", "(Landroidx/compose/foundation/style/Style;)V", "_resolved", "Landroidx/compose/foundation/style/ResolvedStyle;", "_bufferOrNull", "bufferNonNull", "getBufferNonNull", "()Landroidx/compose/foundation/style/ResolvedStyle;", "animations", "Landroidx/compose/foundation/style/StyleAnimations;", "getAnimations$foundation", "()Landroidx/compose/foundation/style/StyleAnimations;", "setAnimations$foundation", "(Landroidx/compose/foundation/style/StyleAnimations;)V", "borderLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "borderLayerProvider", "Lkotlin/Function0;", "borderLogic", "Landroidx/compose/foundation/border/BorderLogic;", "_state", "currentInteractionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", RemoteConfigConstants.ResponseFieldKey.STATE, "getState$foundation", "()Landroidx/compose/foundation/style/StyleState;", "setState$foundation", "(Landroidx/compose/foundation/style/StyleState;)V", "resolveAnimatedStyleFor", DownloaderServiceMarshaller.PARAMS_FLAGS, "", TtmlNode.RUBY_BASE, "resolveAnimatedStyleFor$foundation", "currentLayerStyle", "currentLayoutStyle", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "shouldPlaceRelativeToRight", "shouldPlaceRelativeToBottom", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "getLayerBlock$foundation", "()Lkotlin/jvm/functions/Function1;", "setLayerBlock$foundation", "(Lkotlin/jvm/functions/Function1;)V", "layerBlockNonNull", "getLayerBlockNonNull$foundation", "updateLayer", "lastSize", "Landroidx/compose/ui/geometry/Size;", "J", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastShape", "Landroidx/compose/ui/graphics/Shape;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "getOutline", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "size", "shape", "getOutline-12SF9DM", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/graphics/Outline;", "draw", "lastInnerShadow", "", "Landroidx/compose/ui/graphics/shadow/Shadow;", "[Landroidx/compose/ui/graphics/shadow/Shadow;", "cachedInnerShadowPainters", "Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "[Landroidx/compose/ui/graphics/shadow/InnerShadowPainter;", "drawInnerShadow", FirebaseAnalytics.Param.INDEX, "shadow", "reconcileInnerShadowCache", "shadowOrArray", "", "resolved", "lastDropShadow", "cachedDropShadowPainters", "Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "[Landroidx/compose/ui/graphics/shadow/DropShadowPainter;", "drawDropShadow", "reconcileDropShadowCache", "drawForShape", "hasBackground", "hasBorder", "hasForeground", "bgColor", "Landroidx/compose/ui/graphics/Color;", "bgBrush", "Landroidx/compose/ui/graphics/Brush;", "borderColor", "borderBrush", "foregroundColor", "foregroundBrush", "borderWidth", "", "drawForShape-9zt3ed4", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/ui/graphics/Shape;ZZZJLandroidx/compose/ui/graphics/Brush;JLandroidx/compose/ui/graphics/Brush;JLandroidx/compose/ui/graphics/Brush;F)V", "traverseKey", "getTraverseKey", "()Ljava/lang/Object;", "resolveStyleAndInvalidate", "initial", "onObservedReadsChanged", "sourceJob", "Lkotlinx/coroutines/Job;", "getSourceJob", "()Lkotlinx/coroutines/Job;", "setSourceJob", "(Lkotlinx/coroutines/Job;)V", "updateInteractionSources", "currentValue", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/CompositionLocal;", "getCurrentValue", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "computeInheritedTextStyle", "Landroidx/compose/ui/text/TextStyle;", TypedValues.CycleType.S_WAVE_PHASE, "Landroidx/compose/foundation/text/modifiers/StylePhase;", "fallback", "computeInheritedTextStyle-B-LjeIk", "(ILandroidx/compose/ui/text/TextStyle;)Landroidx/compose/ui/text/TextStyle;", "ancestorNodes", "Landroidx/collection/MutableObjectList;", "getAncestorNodes$foundation", "()Landroidx/collection/MutableObjectList;", "setAncestorNodes$foundation", "(Landroidx/collection/MutableObjectList;)V", "resolveInheritedStyle", "resolveInheritedStyle$foundation", "cachedInheritedStyle", "inheritedStyleDirty", "getCachedInheritedStyle", "getCachedInheritedStyle$foundation", "saveInheritedStyles", "saveInheritedStyles$foundation", "invalidateTextLayout", "invalidateTextDraw", "onDetach", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StyleOuterNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, CompositionLocalAccessorScope, TextStyleProviderNode {
    public static final int $stable = 8;
    private ResolvedStyle _bufferOrNull;
    private StyleState _state;
    private MutableObjectList<StyleOuterNode> ancestorNodes;
    private StyleAnimations animations;
    private GraphicsLayer borderLayer;
    private Function0<GraphicsLayer> borderLayerProvider;
    private DropShadowPainter[] cachedDropShadowPainters;
    private ResolvedStyle cachedInheritedStyle;
    private InnerShadowPainter[] cachedInnerShadowPainters;
    private InteractionSource currentInteractionSource;
    private boolean inheritedStyleDirty;
    private StyleInnerNode innerNodeField;
    private Shadow[] lastDropShadow;
    private Shadow[] lastInnerShadow;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private long lastSize;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Job sourceJob;
    private Style style;
    private ResolvedStyle _resolved = new ResolvedStyle();
    private final BorderLogic borderLogic = new BorderLogic();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final float drawForShape_9zt3ed4$lambda$0(float f) {
        return f;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public StyleOuterNode(MutableStyleState mutableStyleState, Style style) {
        this.style = style;
        this._state = mutableStyleState == null ? new MutableStyleState(null) : mutableStyleState;
        this.lastSize = Size.Companion.m5180getUnspecifiedNHjbRc();
    }

    public final StyleInnerNode getInnerNodeField$foundation() {
        return this.innerNodeField;
    }

    public final void setInnerNodeField$foundation(StyleInnerNode styleInnerNode) {
        this.innerNodeField = styleInnerNode;
    }

    public final StyleInnerNode getInnerNode$foundation() {
        StyleInnerNode styleInnerNode = this.innerNodeField;
        if (styleInnerNode != null) {
            return styleInnerNode;
        }
        throw new IllegalStateException("StyleOuterNode with no corresponding StyleInnerNode".toString());
    }

    public final void setInnerNode$foundation(StyleInnerNode styleInnerNode) {
        this.innerNodeField = styleInnerNode;
    }

    public final Style getStyle$foundation() {
        return this.style;
    }

    public final void setStyle$foundation(Style style) {
        this.style = style;
        resolveStyleAndInvalidate$default(this, false, 1, null);
    }

    private final ResolvedStyle getBufferNonNull() {
        if (this._bufferOrNull == null) {
            this._bufferOrNull = new ResolvedStyle();
        }
        ResolvedStyle resolvedStyle = this._bufferOrNull;
        Intrinsics.checkNotNull(resolvedStyle);
        return resolvedStyle;
    }

    public final StyleAnimations getAnimations$foundation() {
        return this.animations;
    }

    public final void setAnimations$foundation(StyleAnimations styleAnimations) {
        this.animations = styleAnimations;
    }

    public final StyleState getState$foundation() {
        return this._state;
    }

    public final void setState$foundation(StyleState styleState) {
        if (Intrinsics.areEqual(this._state, styleState)) {
            return;
        }
        this._state = styleState;
        resolveStyleAndInvalidate$default(this, false, 1, null);
        LayoutModifierNodeKt.invalidateLayer(getInnerNode$foundation());
    }

    public static /* synthetic */ ResolvedStyle resolveAnimatedStyleFor$foundation$default(StyleOuterNode styleOuterNode, int i, ResolvedStyle resolvedStyle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            resolvedStyle = styleOuterNode._resolved;
        }
        return styleOuterNode.resolveAnimatedStyleFor$foundation(i, resolvedStyle);
    }

    public final ResolvedStyle resolveAnimatedStyleFor$foundation(int i, ResolvedStyle resolvedStyle) {
        StyleAnimations styleAnimations = this.animations;
        return (styleAnimations == null || !styleAnimations.isNotEmpty()) ? resolvedStyle : styleAnimations.withAnimations(DelegatableNodeKt.requireDensity(this), resolvedStyle, this, i);
    }

    private final ResolvedStyle currentLayerStyle() {
        return resolveAnimatedStyleFor$foundation$default(this, 4, null, 2, null);
    }

    private final ResolvedStyle currentLayoutStyle() {
        return resolveAnimatedStyleFor$foundation$default(this, 8, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MeasureResult mo69measure3p2s80s(MeasureScope measureScope, Measurable measurable, final long j) {
        ResolvedStyle currentLayoutStyle = currentLayoutStyle();
        float externalPaddingStart$foundation = currentLayoutStyle.getExternalPaddingStart$foundation();
        float left$foundation = currentLayoutStyle.getLeft$foundation();
        if (!Float.isNaN(left$foundation)) {
            externalPaddingStart$foundation += left$foundation;
        }
        final float f = externalPaddingStart$foundation;
        float externalPaddingEnd$foundation = currentLayoutStyle.getExternalPaddingEnd$foundation();
        float right$foundation = currentLayoutStyle.getRight$foundation();
        if (!Float.isNaN(right$foundation)) {
            externalPaddingEnd$foundation += right$foundation;
        }
        final float f2 = externalPaddingEnd$foundation;
        float externalPaddingTop$foundation = currentLayoutStyle.getExternalPaddingTop$foundation();
        float top$foundation = currentLayoutStyle.getTop$foundation();
        if (!Float.isNaN(top$foundation)) {
            externalPaddingTop$foundation += top$foundation;
        }
        final float f3 = externalPaddingTop$foundation;
        float externalPaddingBottom$foundation = currentLayoutStyle.getExternalPaddingBottom$foundation();
        float bottom$foundation = currentLayoutStyle.getBottom$foundation();
        if (!Float.isNaN(bottom$foundation)) {
            externalPaddingBottom$foundation += bottom$foundation;
        }
        final float f4 = externalPaddingBottom$foundation;
        int round = Math.round(f + f2);
        int round2 = Math.round(f3 + f4);
        int m8115getMinWidthimpl = Constraints.m8115getMinWidthimpl(j) - round;
        if (m8115getMinWidthimpl < 0) {
            m8115getMinWidthimpl = 0;
        }
        int m8113getMaxWidthimpl = Constraints.m8113getMaxWidthimpl(j);
        if (m8113getMaxWidthimpl != Integer.MAX_VALUE && (m8113getMaxWidthimpl = m8113getMaxWidthimpl + round) < 0) {
            m8113getMaxWidthimpl = 0;
        }
        int m8114getMinHeightimpl = Constraints.m8114getMinHeightimpl(j) - round2;
        if (m8114getMinHeightimpl < 0) {
            m8114getMinHeightimpl = 0;
        }
        int m8112getMaxHeightimpl = Constraints.m8112getMaxHeightimpl(j);
        int i = (m8112getMaxHeightimpl == Integer.MAX_VALUE || (m8112getMaxHeightimpl = m8112getMaxHeightimpl + round2) >= 0) ? m8112getMaxHeightimpl : 0;
        float minWidth$foundation = currentLayoutStyle.getMinWidth$foundation();
        if (!Float.isNaN(minWidth$foundation)) {
            m8115getMinWidthimpl = Math.round(minWidth$foundation);
        }
        float maxWidth$foundation = currentLayoutStyle.getMaxWidth$foundation();
        if (!Float.isNaN(maxWidth$foundation)) {
            m8113getMaxWidthimpl = Math.round(maxWidth$foundation);
        }
        float minHeight$foundation = currentLayoutStyle.getMinHeight$foundation();
        if (!Float.isNaN(minHeight$foundation)) {
            m8114getMinHeightimpl = Math.round(minHeight$foundation);
        }
        float maxHeight$foundation = currentLayoutStyle.getMaxHeight$foundation();
        if (!Float.isNaN(maxHeight$foundation)) {
            i = Math.round(maxHeight$foundation);
        }
        if (!Float.isNaN(currentLayoutStyle.getWidth$foundation())) {
            m8115getMinWidthimpl = Math.round(currentLayoutStyle.getWidth$foundation());
        } else if (!Float.isNaN(currentLayoutStyle.getWidthFraction$foundation()) && Constraints.m8109getHasBoundedWidthimpl(j)) {
            int round3 = Math.round(m8113getMaxWidthimpl * currentLayoutStyle.getWidthFraction$foundation());
            if (round3 >= m8115getMinWidthimpl) {
                m8115getMinWidthimpl = round3;
            }
            if (m8115getMinWidthimpl > m8113getMaxWidthimpl) {
                m8115getMinWidthimpl = m8113getMaxWidthimpl;
            }
        } else {
            if (!Float.isNaN(currentLayoutStyle.getLeft$foundation()) && !Float.isNaN(currentLayoutStyle.getRight$foundation())) {
                m8115getMinWidthimpl = m8113getMaxWidthimpl;
            }
            if (Float.isNaN(currentLayoutStyle.getHeight$foundation())) {
                m8114getMinHeightimpl = Math.round(currentLayoutStyle.getHeight$foundation());
            } else if (!Float.isNaN(currentLayoutStyle.getHeightFraction$foundation()) && Constraints.m8108getHasBoundedHeightimpl(j)) {
                int round4 = Math.round(i * currentLayoutStyle.getHeightFraction$foundation());
                if (round4 >= m8114getMinHeightimpl) {
                    m8114getMinHeightimpl = round4;
                }
                if (m8114getMinHeightimpl > i) {
                    m8114getMinHeightimpl = i;
                }
            } else {
                if (!Float.isNaN(currentLayoutStyle.getTop$foundation()) && !Float.isNaN(currentLayoutStyle.getBottom$foundation())) {
                    m8114getMinHeightimpl = i;
                }
                final Placeable mo6818measureBRTryo0 = measurable.mo6818measureBRTryo0(ConstraintsKt.Constraints(m8115getMinWidthimpl, m8113getMaxWidthimpl, m8114getMinHeightimpl, i));
                return MeasureScope.layout$default(measureScope, mo6818measureBRTryo0.getWidth() + round, mo6818measureBRTryo0.getHeight() + round2, null, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StyleOuterNode.measure_3p2s80s$lambda$0(StyleOuterNode.this, j, mo6818measureBRTryo0, f2, f, f4, f3, (Placeable.PlacementScope) obj);
                    }
                }, 4, null);
            }
            i = m8114getMinHeightimpl;
            final Placeable mo6818measureBRTryo02 = measurable.mo6818measureBRTryo0(ConstraintsKt.Constraints(m8115getMinWidthimpl, m8113getMaxWidthimpl, m8114getMinHeightimpl, i));
            return MeasureScope.layout$default(measureScope, mo6818measureBRTryo02.getWidth() + round, mo6818measureBRTryo02.getHeight() + round2, null, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StyleOuterNode.measure_3p2s80s$lambda$0(StyleOuterNode.this, j, mo6818measureBRTryo02, f2, f, f4, f3, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        m8113getMaxWidthimpl = m8115getMinWidthimpl;
        if (Float.isNaN(currentLayoutStyle.getHeight$foundation())) {
        }
        i = m8114getMinHeightimpl;
        final Placeable mo6818measureBRTryo022 = measurable.mo6818measureBRTryo0(ConstraintsKt.Constraints(m8115getMinWidthimpl, m8113getMaxWidthimpl, m8114getMinHeightimpl, i));
        return MeasureScope.layout$default(measureScope, mo6818measureBRTryo022.getWidth() + round, mo6818measureBRTryo022.getHeight() + round2, null, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StyleOuterNode.measure_3p2s80s$lambda$0(StyleOuterNode.this, j, mo6818measureBRTryo022, f2, f, f4, f3, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$0(StyleOuterNode styleOuterNode, long j, Placeable placeable, float f, float f2, float f3, float f4, Placeable.PlacementScope placementScope) {
        int round;
        int round2;
        ResolvedStyle currentLayoutStyle = styleOuterNode.currentLayoutStyle();
        if (styleOuterNode.shouldPlaceRelativeToRight(currentLayoutStyle)) {
            round = (Constraints.m8113getMaxWidthimpl(j) - placeable.getWidth()) - Math.round(f);
        } else {
            round = Math.round(f2);
        }
        int i = round;
        if (styleOuterNode.shouldPlaceRelativeToBottom(currentLayoutStyle)) {
            round2 = (Constraints.m8112getMaxHeightimpl(j) - placeable.getHeight()) - Math.round(f3);
        } else {
            round2 = Math.round(f4);
        }
        int i2 = round2;
        if ((currentLayoutStyle.flags & 4) != 0) {
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, i, i2, 0.0f, styleOuterNode.getLayerBlockNonNull$foundation(), 4, (Object) null);
        } else {
            Placeable.PlacementScope.place$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    private final boolean shouldPlaceRelativeToRight(ResolvedStyle resolvedStyle) {
        return !Float.isNaN(resolvedStyle.getRight$foundation()) && Float.isNaN(resolvedStyle.getLeft$foundation());
    }

    private final boolean shouldPlaceRelativeToBottom(ResolvedStyle resolvedStyle) {
        return !Float.isNaN(resolvedStyle.getBottom$foundation()) && Float.isNaN(resolvedStyle.getTop$foundation());
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlock$foundation() {
        return this.layerBlock;
    }

    public final void setLayerBlock$foundation(Function1<? super GraphicsLayerScope, Unit> function1) {
        this.layerBlock = function1;
    }

    public final Function1<GraphicsLayerScope, Unit> getLayerBlockNonNull$foundation() {
        Function1 function1 = this.layerBlock;
        if (function1 == null) {
            Function1<GraphicsLayerScope, Unit> function12 = new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit _get_layerBlockNonNull_$lambda$0$0;
                    _get_layerBlockNonNull_$lambda$0$0 = StyleOuterNode._get_layerBlockNonNull_$lambda$0$0(StyleOuterNode.this, (GraphicsLayerScope) obj);
                    return _get_layerBlockNonNull_$lambda$0$0;
                }
            };
            this.layerBlock = function12;
            return function12;
        }
        return function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_layerBlockNonNull_$lambda$0$0(StyleOuterNode styleOuterNode, GraphicsLayerScope graphicsLayerScope) {
        styleOuterNode.updateLayer(graphicsLayerScope);
        return Unit.INSTANCE;
    }

    private final void updateLayer(GraphicsLayerScope graphicsLayerScope) {
        ResolvedStyle currentLayerStyle = currentLayerStyle();
        graphicsLayerScope.setAlpha(currentLayerStyle.getAlpha$foundation());
        graphicsLayerScope.setScaleX(currentLayerStyle.getScaleX$foundation());
        graphicsLayerScope.setScaleY(currentLayerStyle.getScaleY$foundation());
        graphicsLayerScope.setTranslationX(currentLayerStyle.getTranslationX$foundation());
        graphicsLayerScope.setTranslationY(currentLayerStyle.getTranslationY$foundation());
        graphicsLayerScope.setRotationX(currentLayerStyle.getRotationX$foundation());
        graphicsLayerScope.setRotationY(currentLayerStyle.getRotationY$foundation());
        graphicsLayerScope.setRotationZ(currentLayerStyle.getRotationZ$foundation());
        graphicsLayerScope.mo5549setTransformOrigin__ExYCQ(currentLayerStyle.m1427getTransformOriginSzJe1aQ$foundation());
        graphicsLayerScope.setClip(currentLayerStyle.getClip$foundation());
        graphicsLayerScope.setShape(currentLayerStyle.getShape$foundation());
    }

    /* renamed from: getOutline-12SF9DM  reason: not valid java name */
    private final Outline m1471getOutline12SF9DM(ContentDrawScope contentDrawScope, long j, Shape shape) {
        Outline mo344createOutlinePq9zytI;
        if (Size.m5168equalsimpl0(this.lastSize, j) && this.lastLayoutDirection == contentDrawScope.getLayoutDirection() && Intrinsics.areEqual(this.lastShape, shape)) {
            mo344createOutlinePq9zytI = this.lastOutline;
            Intrinsics.checkNotNull(mo344createOutlinePq9zytI);
        } else {
            mo344createOutlinePq9zytI = shape.mo344createOutlinePq9zytI(j, contentDrawScope.getLayoutDirection(), contentDrawScope);
        }
        this.lastOutline = mo344createOutlinePq9zytI;
        this.lastSize = j;
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
        return mo344createOutlinePq9zytI;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Shape shape;
        boolean z;
        Shape shape2;
        boolean z2;
        ResolvedStyle resolveAnimatedStyleFor$foundation$default = resolveAnimatedStyleFor$foundation$default(this, 2, null, 2, null);
        long m1413getBackgroundColor0d7_KjU$foundation = resolveAnimatedStyleFor$foundation$default.m1413getBackgroundColor0d7_KjU$foundation();
        Brush backgroundBrush$foundation = resolveAnimatedStyleFor$foundation$default.getBackgroundBrush$foundation();
        long m1420getForegroundColor0d7_KjU$foundation = resolveAnimatedStyleFor$foundation$default.m1420getForegroundColor0d7_KjU$foundation();
        Brush foregroundBrush$foundation = resolveAnimatedStyleFor$foundation$default.getForegroundBrush$foundation();
        long m1415getBorderColor0d7_KjU$foundation = resolveAnimatedStyleFor$foundation$default.m1415getBorderColor0d7_KjU$foundation();
        Brush borderBrush$foundation = resolveAnimatedStyleFor$foundation$default.getBorderBrush$foundation();
        float borderWidth$foundation = resolveAnimatedStyleFor$foundation$default.getBorderWidth$foundation();
        Shape shape$foundation = resolveAnimatedStyleFor$foundation$default.getShape$foundation();
        boolean z3 = true;
        if (borderWidth$foundation / 2.0f > 0.0f) {
            shape = shape$foundation;
            z = true;
        } else {
            shape = shape$foundation;
            z = false;
        }
        if (m1413getBackgroundColor0d7_KjU$foundation == 16 && backgroundBrush$foundation == null) {
            shape2 = shape;
            z2 = false;
        } else {
            shape2 = shape;
            z2 = true;
        }
        if (m1420getForegroundColor0d7_KjU$foundation == 16 && foregroundBrush$foundation == null) {
            z3 = false;
        }
        drawDropShadow(contentDrawScope, resolveAnimatedStyleFor$foundation$default);
        Shape shape3 = shape2;
        m1473drawForShape9zt3ed4(contentDrawScope, shape3, z2, z, z3, m1413getBackgroundColor0d7_KjU$foundation, backgroundBrush$foundation, m1415getBorderColor0d7_KjU$foundation, borderBrush$foundation, m1420getForegroundColor0d7_KjU$foundation, foregroundBrush$foundation, borderWidth$foundation);
        drawInnerShadow(contentDrawScope, resolveAnimatedStyleFor$foundation$default);
        this.lastShape = shape3;
    }

    private final void drawInnerShadow(ContentDrawScope contentDrawScope, int i, Shape shape, Shadow shadow) {
        Shadow[] shadowArr = this.lastInnerShadow;
        Shadow shadow2 = shadowArr != null ? (Shadow) ArraysKt.getOrNull(shadowArr, i) : null;
        InnerShadowPainter[] innerShadowPainterArr = this.cachedInnerShadowPainters;
        InnerShadowPainter innerShadowPainter = innerShadowPainterArr != null ? (InnerShadowPainter) ArraysKt.getOrNull(innerShadowPainterArr, i) : null;
        if (!Intrinsics.areEqual(shadow2, shadow) || innerShadowPainter == null) {
            innerShadowPainter = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createInnerShadowPainter(shape, shadow);
        }
        Shadow[] shadowArr2 = this.lastInnerShadow;
        if (shadowArr2 != null) {
            shadowArr2[i] = shadow;
        }
        InnerShadowPainter[] innerShadowPainterArr2 = this.cachedInnerShadowPainters;
        if (innerShadowPainterArr2 != null) {
            innerShadowPainterArr2[i] = innerShadowPainter;
        }
        Painter.m6047drawx_KDEd0$default(innerShadowPainter, contentDrawScope, contentDrawScope.mo5922getSizeNHjbRc(), 0.0f, null, 6, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r7 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reconcileInnerShadowCache(Object obj, Shape shape) {
        InnerShadowPainter[] innerShadowPainterArr;
        Shadow[] shadowArr = this.lastInnerShadow;
        InnerShadowPainter[] innerShadowPainterArr2 = this.cachedInnerShadowPainters;
        int length = obj instanceof Object[] ? ((Object[]) obj).length : 1;
        int i = 0;
        if (shadowArr == null || !Intrinsics.areEqual(this.lastShape, shape)) {
            Shadow[] shadowArr2 = new Shadow[length];
            for (int i2 = 0; i2 < length; i2++) {
                shadowArr2[i2] = null;
            }
            this.lastInnerShadow = shadowArr2;
            InnerShadowPainter[] innerShadowPainterArr3 = new InnerShadowPainter[length];
            while (i < length) {
                innerShadowPainterArr3[i] = null;
                i++;
            }
            this.cachedInnerShadowPainters = innerShadowPainterArr3;
        } else if (shadowArr.length != length) {
            Object[] copyOf = Arrays.copyOf(shadowArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.lastInnerShadow = (Shadow[]) copyOf;
            if (innerShadowPainterArr2 != null) {
                Object[] copyOf2 = Arrays.copyOf(innerShadowPainterArr2, length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
                innerShadowPainterArr = (InnerShadowPainter[]) copyOf2;
            }
            innerShadowPainterArr = new InnerShadowPainter[length];
            while (i < length) {
                innerShadowPainterArr[i] = null;
                i++;
            }
            this.cachedInnerShadowPainters = innerShadowPainterArr;
        }
    }

    public final void drawInnerShadow(ContentDrawScope contentDrawScope, ResolvedStyle resolvedStyle) {
        Object innerShadow$foundation = resolvedStyle.getInnerShadow$foundation();
        if (innerShadow$foundation == null) {
            return;
        }
        Shape shape$foundation = resolvedStyle.getShape$foundation();
        reconcileInnerShadowCache(innerShadow$foundation, shape$foundation);
        if (innerShadow$foundation instanceof Object[]) {
            Object[] objArr = (Object[]) innerShadow$foundation;
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Shadow) {
                    drawInnerShadow(contentDrawScope, i, shape$foundation, (Shadow) obj);
                }
            }
        } else if (innerShadow$foundation instanceof Shadow) {
            drawInnerShadow(contentDrawScope, 0, shape$foundation, (Shadow) innerShadow$foundation);
        }
    }

    private final void drawDropShadow(ContentDrawScope contentDrawScope, int i, Shape shape, Shadow shadow) {
        Shadow[] shadowArr = this.lastDropShadow;
        Shadow shadow2 = shadowArr != null ? (Shadow) ArraysKt.getOrNull(shadowArr, i) : null;
        DropShadowPainter[] dropShadowPainterArr = this.cachedDropShadowPainters;
        DropShadowPainter dropShadowPainter = dropShadowPainterArr != null ? (DropShadowPainter) ArraysKt.getOrNull(dropShadowPainterArr, i) : null;
        if (!Intrinsics.areEqual(shadow2, shadow) || dropShadowPainter == null) {
            dropShadowPainter = DelegatableNodeKt.requireGraphicsContext(this).getShadowContext().createDropShadowPainter(shape, shadow);
        }
        Shadow[] shadowArr2 = this.lastDropShadow;
        if (shadowArr2 != null) {
            shadowArr2[i] = shadow;
        }
        DropShadowPainter[] dropShadowPainterArr2 = this.cachedDropShadowPainters;
        if (dropShadowPainterArr2 != null) {
            dropShadowPainterArr2[i] = dropShadowPainter;
        }
        Painter.m6047drawx_KDEd0$default(dropShadowPainter, contentDrawScope, contentDrawScope.mo5922getSizeNHjbRc(), 0.0f, null, 6, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r7 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void reconcileDropShadowCache(Object obj, Shape shape) {
        DropShadowPainter[] dropShadowPainterArr;
        Shadow[] shadowArr = this.lastDropShadow;
        DropShadowPainter[] dropShadowPainterArr2 = this.cachedDropShadowPainters;
        int length = obj instanceof Object[] ? ((Object[]) obj).length : 1;
        int i = 0;
        if (shadowArr == null || !Intrinsics.areEqual(this.lastShape, shape)) {
            Shadow[] shadowArr2 = new Shadow[length];
            for (int i2 = 0; i2 < length; i2++) {
                shadowArr2[i2] = null;
            }
            this.lastDropShadow = shadowArr2;
            DropShadowPainter[] dropShadowPainterArr3 = new DropShadowPainter[length];
            while (i < length) {
                dropShadowPainterArr3[i] = null;
                i++;
            }
            this.cachedDropShadowPainters = dropShadowPainterArr3;
        } else if (shadowArr.length != length) {
            Object[] copyOf = Arrays.copyOf(shadowArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.lastDropShadow = (Shadow[]) copyOf;
            if (dropShadowPainterArr2 != null) {
                Object[] copyOf2 = Arrays.copyOf(dropShadowPainterArr2, length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
                dropShadowPainterArr = (DropShadowPainter[]) copyOf2;
            }
            dropShadowPainterArr = new DropShadowPainter[length];
            while (i < length) {
                dropShadowPainterArr[i] = null;
                i++;
            }
            this.cachedDropShadowPainters = dropShadowPainterArr;
        }
    }

    public final void drawDropShadow(ContentDrawScope contentDrawScope, ResolvedStyle resolvedStyle) {
        Object dropShadow$foundation = resolvedStyle.getDropShadow$foundation();
        if (dropShadow$foundation == null) {
            return;
        }
        Shape shape$foundation = resolvedStyle.getShape$foundation();
        reconcileDropShadowCache(dropShadow$foundation, shape$foundation);
        if (dropShadow$foundation instanceof Object[]) {
            Object[] objArr = (Object[]) dropShadow$foundation;
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Shadow) {
                    drawDropShadow(contentDrawScope, i, shape$foundation, (Shadow) obj);
                }
            }
        } else if (dropShadow$foundation instanceof Shadow) {
            drawDropShadow(contentDrawScope, 0, shape$foundation, (Shadow) dropShadow$foundation);
        }
    }

    /* renamed from: drawForShape-9zt3ed4  reason: not valid java name */
    public final void m1473drawForShape9zt3ed4(ContentDrawScope contentDrawScope, Shape shape, boolean z, boolean z2, boolean z3, long j, Brush brush, long j2, Brush brush2, long j3, Brush brush3, final float f) {
        Outline m1471getOutline12SF9DM = m1471getOutline12SF9DM(contentDrawScope, contentDrawScope.mo5922getSizeNHjbRc(), shape);
        if (z) {
            if (brush != null) {
                OutlineKt.m5619drawOutlinehn5TExg$default(contentDrawScope, m1471getOutline12SF9DM, brush, 0.0f, null, null, 0, 60, null);
            } else {
                OutlineKt.m5621drawOutlinewDX37Ww$default(contentDrawScope, m1471getOutline12SF9DM, j, 0.0f, null, null, 0, 60, null);
            }
        }
        contentDrawScope.drawContent();
        if (z3) {
            if (brush3 != null) {
                OutlineKt.m5619drawOutlinehn5TExg$default(contentDrawScope, m1471getOutline12SF9DM, brush3, 0.0f, null, null, 0, 60, null);
            } else {
                OutlineKt.m5621drawOutlinewDX37Ww$default(contentDrawScope, m1471getOutline12SF9DM, j3, 0.0f, null, null, 0, 60, null);
            }
        }
        if (z2) {
            SolidColor solidColor = brush2 == null ? new SolidColor(j2, null) : brush2;
            BorderLogic borderLogic = this.borderLogic;
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            Function0 function0 = new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(StyleOuterNode.drawForShape_9zt3ed4$lambda$0(f));
                }
            };
            Function0<GraphicsLayer> function02 = this.borderLayerProvider;
            if (function02 == null) {
                function02 = new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StyleOuterNode.drawForShape_9zt3ed4$lambda$1(StyleOuterNode.this);
                    }
                };
                this.borderLayerProvider = function02;
                Unit unit = Unit.INSTANCE;
            }
            BorderLogic.m379drawBorder2gY9BTk$foundation$default(borderLogic, contentDrawScope2, function0, solidColor, function02, m1471getOutline12SF9DM, 0L, 32, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final GraphicsLayer drawForShape_9zt3ed4$lambda$1(StyleOuterNode styleOuterNode) {
        GraphicsLayer graphicsLayer = styleOuterNode.borderLayer;
        if (graphicsLayer == null) {
            GraphicsLayer createGraphicsLayer = DelegatableNodeKt.requireGraphicsContext(styleOuterNode).createGraphicsLayer();
            styleOuterNode.borderLayer = createGraphicsLayer;
            return createGraphicsLayer;
        }
        return graphicsLayer;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return StyleModifierKt.OuterNodeKey;
    }

    public static /* synthetic */ void resolveStyleAndInvalidate$default(StyleOuterNode styleOuterNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        styleOuterNode.resolveStyleAndInvalidate(z);
    }

    public final void resolveStyleAndInvalidate(final boolean z) {
        if (isAttached()) {
            final ResolvedStyle resolvedStyle = z ? null : this._resolved;
            final ResolvedStyle bufferNonNull = z ? this._resolved : getBufferNonNull();
            final Density requireDensity = DelegatableNodeKt.requireDensity(this);
            bufferNonNull.clear$foundation();
            StyleAnimations styleAnimations = this.animations;
            if (styleAnimations != null) {
                styleAnimations.preResolve();
            }
            final Ref.IntRef intRef = new Ref.IntRef();
            ObserverModifierNodeKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StyleOuterNode.resolveStyleAndInvalidate$lambda$0(ResolvedStyle.this, this, requireDensity, resolvedStyle, intRef, z);
                }
            });
            int diff$foundation$default = intRef.element | (resolvedStyle != null ? ResolvedStyle.diff$foundation$default(resolvedStyle, bufferNonNull, 0, 2, null) : bufferNonNull.flags);
            if (!Intrinsics.areEqual(this._state.getInteractionSource$foundation(), this.currentInteractionSource)) {
                updateInteractionSources();
            }
            if (z) {
                return;
            }
            if ((diff$foundation$default & 1) != 0) {
                LayoutModifierNodeKt.invalidateMeasurement(getInnerNode$foundation());
            }
            if ((diff$foundation$default & 8) != 0) {
                LayoutModifierNodeKt.invalidateMeasurement(this);
            }
            if ((diff$foundation$default & 2) != 0) {
                LayoutModifierNodeKt.invalidateLayer(getInnerNode$foundation());
            }
            if ((diff$foundation$default & 4) != 0) {
                LayoutModifierNodeKt.updateLayerBlock(this, getLayerBlockNonNull$foundation());
            }
            if ((diff$foundation$default & 32) != 0) {
                invalidateTextLayout();
            }
            if ((diff$foundation$default & 64) != 0) {
                invalidateTextDraw();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit resolveStyleAndInvalidate$lambda$0(ResolvedStyle resolvedStyle, StyleOuterNode styleOuterNode, Density density, ResolvedStyle resolvedStyle2, Ref.IntRef intRef, boolean z) {
        resolvedStyle.resolve$foundation(styleOuterNode.style, styleOuterNode, density, false);
        styleOuterNode._resolved = resolvedStyle;
        styleOuterNode._bufferOrNull = resolvedStyle2;
        StyleAnimations styleAnimations = styleOuterNode.animations;
        intRef.element = styleAnimations != null ? styleAnimations.postResolve(styleOuterNode, density, !z) : 0;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        resolveStyleAndInvalidate$default(this, false, 1, null);
    }

    public final Job getSourceJob() {
        return this.sourceJob;
    }

    public final void setSourceJob(Job job) {
        this.sourceJob = job;
    }

    public final void updateInteractionSources() {
        Job launch$default;
        Job job = this.sourceJob;
        if (job != null) {
            Job.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        InteractionSource interactionSource$foundation = this._state.getInteractionSource$foundation();
        this.currentInteractionSource = interactionSource$foundation;
        if (interactionSource$foundation != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new StyleOuterNode$updateInteractionSources$1(this, interactionSource$foundation, null), 3, null);
            this.sourceJob = launch$default;
        }
    }

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    public <T> T getCurrentValue(CompositionLocal<T> compositionLocal) {
        return (T) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, compositionLocal);
    }

    @Override // androidx.compose.foundation.text.modifiers.TextStyleProviderNode
    /* renamed from: computeInheritedTextStyle-B-LjeIk  reason: not valid java name */
    public TextStyle mo1472computeInheritedTextStyleBLjeIk(int i, TextStyle textStyle) {
        TextStyle textStyle$foundation;
        ResolvedStyle resolveInheritedStyle$foundation = resolveInheritedStyle$foundation(StyleModifierKt.m1467access$toFlagsuwmK9pY(i));
        return (resolveInheritedStyle$foundation == null || (textStyle$foundation = resolveInheritedStyle$foundation.toTextStyle$foundation(textStyle)) == null) ? textStyle : textStyle$foundation;
    }

    public final MutableObjectList<StyleOuterNode> getAncestorNodes$foundation() {
        return this.ancestorNodes;
    }

    public final void setAncestorNodes$foundation(MutableObjectList<StyleOuterNode> mutableObjectList) {
        this.ancestorNodes = mutableObjectList;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>] */
    /* JADX WARN: Type inference failed for: r2v7, types: [T, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>, androidx.collection.MutableObjectList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ResolvedStyle resolveInheritedStyle$foundation(int i) {
        StyleOuterNode styleOuterNode;
        StyleOuterNode styleOuterNode2;
        StyleAnimations styleAnimations;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.ancestorNodes;
        if ((this._resolved.flags & 96) != 0 || ((styleAnimations = this.animations) != null && styleAnimations.isNotEmpty())) {
            MutableObjectList mutableObjectList = (MutableObjectList) objectRef.element;
            MutableObjectList mutableObjectList2 = mutableObjectList;
            if (mutableObjectList == null) {
                ?? mutableObjectList3 = new MutableObjectList(0, 1, null);
                objectRef.element = mutableObjectList3;
                this.ancestorNodes = mutableObjectList3;
                mutableObjectList2 = mutableObjectList3;
            }
            mutableObjectList2.add(this);
        }
        StyleOuterNode styleOuterNode3 = this;
        TraversableNodeKt.traverseAncestors(styleOuterNode3, StyleModifierKt.OuterNodeKey, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(StyleOuterNode.resolveInheritedStyle$lambda$1(Ref.ObjectRef.this, this, (TraversableNode) obj));
            }
        });
        ResolvedStyle cachedInheritedStyle$foundation = getCachedInheritedStyle$foundation();
        int i2 = cachedInheritedStyle$foundation != null ? -1 : -2;
        StyleAnimations styleAnimations2 = this.animations;
        boolean isNotEmpty = styleAnimations2 != null ? styleAnimations2.isNotEmpty() : false;
        int i3 = this._resolved.flags & 96;
        MutableObjectList mutableObjectList4 = (MutableObjectList) objectRef.element;
        if (mutableObjectList4 != null) {
            MutableObjectList mutableObjectList5 = mutableObjectList4;
            Object[] objArr = mutableObjectList5.content;
            int i4 = mutableObjectList5._size;
            for (int i5 = 0; i5 < i4; i5++) {
                StyleOuterNode styleOuterNode4 = (StyleOuterNode) objArr[i5];
                ResolvedStyle cachedInheritedStyle$foundation2 = styleOuterNode4.getCachedInheritedStyle$foundation();
                if (!isNotEmpty) {
                    StyleAnimations styleAnimations3 = styleOuterNode4.animations;
                    if (!(styleAnimations3 != null ? styleAnimations3.isNotEmpty() : false)) {
                        isNotEmpty = false;
                        i3 |= styleOuterNode4._resolved.flags & 96;
                        if (cachedInheritedStyle$foundation2 != null) {
                            cachedInheritedStyle$foundation = null;
                            i2 = -2;
                        } else if (cachedInheritedStyle$foundation == null) {
                            i2 = i5;
                            cachedInheritedStyle$foundation = cachedInheritedStyle$foundation2;
                        }
                    }
                }
                isNotEmpty = true;
                i3 |= styleOuterNode4._resolved.flags & 96;
                if (cachedInheritedStyle$foundation2 != null) {
                }
            }
        }
        if (i3 == 0) {
            return null;
        }
        if (cachedInheritedStyle$foundation == null || i2 >= 0 || isNotEmpty) {
            if (objectRef.element != 0 && i2 < -1) {
                i2 = ((MutableObjectList) objectRef.element).getSize() - 1;
            }
            while (-2 < i2) {
                if (i2 < 0) {
                    styleOuterNode2 = this;
                } else {
                    MutableObjectList mutableObjectList6 = (MutableObjectList) objectRef.element;
                    if (mutableObjectList6 == null) {
                        i2--;
                    } else {
                        styleOuterNode2 = (StyleOuterNode) mutableObjectList6.get(i2);
                    }
                }
                ResolvedStyle resolvedStyle = styleOuterNode2.cachedInheritedStyle;
                if (resolvedStyle == null) {
                    resolvedStyle = new ResolvedStyle();
                }
                if (cachedInheritedStyle$foundation != null) {
                    cachedInheritedStyle$foundation.copyInheritedStylesInto$foundation(resolvedStyle);
                }
                resolvedStyle.applyInheritableStyles$foundation(styleOuterNode2._resolved);
                styleOuterNode2.saveInheritedStyles$foundation(resolvedStyle);
                cachedInheritedStyle$foundation = resolvedStyle;
                i2--;
            }
            if (isNotEmpty) {
                ResolvedStyle resolvedStyle2 = new ResolvedStyle();
                if (cachedInheritedStyle$foundation != null) {
                    cachedInheritedStyle$foundation.copyInheritedStylesInto$foundation(resolvedStyle2);
                }
                MutableObjectList mutableObjectList7 = (MutableObjectList) objectRef.element;
                int size = mutableObjectList7 != null ? mutableObjectList7.getSize() : 0;
                Density requireDensity = DelegatableNodeKt.requireDensity(styleOuterNode3);
                for (int i6 = size - 1; -2 < i6; i6--) {
                    if (i6 < 0) {
                        styleOuterNode = this;
                    } else {
                        MutableObjectList mutableObjectList8 = (MutableObjectList) objectRef.element;
                        if (mutableObjectList8 != null) {
                            styleOuterNode = (StyleOuterNode) mutableObjectList8.get(i6);
                        }
                    }
                    StyleAnimations styleAnimations4 = styleOuterNode.animations;
                    if (styleAnimations4 != null) {
                        styleAnimations4.applyAnimationsTo(resolvedStyle2, requireDensity, styleOuterNode, i);
                    }
                }
                return resolvedStyle2;
            }
            return cachedInheritedStyle$foundation;
        }
        return cachedInheritedStyle$foundation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, androidx.collection.MutableObjectList<androidx.compose.foundation.style.StyleOuterNode>, androidx.collection.MutableObjectList] */
    public static final boolean resolveInheritedStyle$lambda$1(Ref.ObjectRef objectRef, StyleOuterNode styleOuterNode, TraversableNode traversableNode) {
        StyleAnimations styleAnimations;
        if (traversableNode instanceof StyleOuterNode) {
            StyleOuterNode styleOuterNode2 = (StyleOuterNode) traversableNode;
            if ((styleOuterNode2._resolved.flags & 96) != 0 || ((styleAnimations = styleOuterNode2.animations) != null && styleAnimations.isNotEmpty())) {
                MutableObjectList mutableObjectList = (MutableObjectList) objectRef.element;
                MutableObjectList mutableObjectList2 = mutableObjectList;
                if (mutableObjectList == null) {
                    ?? mutableObjectList3 = new MutableObjectList(0, 1, null);
                    objectRef.element = mutableObjectList3;
                    styleOuterNode.ancestorNodes = mutableObjectList3;
                    mutableObjectList2 = mutableObjectList3;
                }
                mutableObjectList2.add(traversableNode);
            }
            return true;
        }
        return true;
    }

    public final ResolvedStyle getCachedInheritedStyle$foundation() {
        if (this.inheritedStyleDirty) {
            return null;
        }
        return this.cachedInheritedStyle;
    }

    public final void saveInheritedStyles$foundation(ResolvedStyle resolvedStyle) {
        this.inheritedStyleDirty = false;
        this.cachedInheritedStyle = resolvedStyle;
    }

    private final void invalidateTextLayout() {
        this.inheritedStyleDirty = true;
        DelegatableNodeKt.invalidateMeasurementForSubtree(this);
    }

    private final void invalidateTextDraw() {
        this.inheritedStyleDirty = true;
        DelegatableNodeKt.invalidateDrawForSubtree(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        GraphicsLayer graphicsLayer = this.borderLayer;
        if (graphicsLayer != null) {
            DelegatableNodeKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
            this.borderLayer = null;
        }
        this.borderLayerProvider = null;
    }
}
