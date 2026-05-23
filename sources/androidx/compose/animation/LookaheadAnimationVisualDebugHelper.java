package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.ArcAnimationSpec;
import androidx.compose.animation.core.ArcMode;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextPainterKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: LookaheadAnimationVisualDebugHelper.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b+J\u001f\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0013H\u0000¢\u0006\u0004\b/\u00100J\u0011\u00101\u001a\u00020&*\u000202H\u0000¢\u0006\u0002\b3J\u001b\u00104\u001a\u00020&*\u0002022\u0006\u00105\u001a\u00020!H\u0000¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u0001H\u0000¢\u0006\u0004\b:\u0010;J?\u0010<\u001a\u00020&*\u0002022\u0006\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010AH\u0000¢\u0006\u0004\bB\u0010CJ_\u0010D\u001a\u00020&*\u0002022\u0006\u0010=\u001a\u00020!2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\f2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u00012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010AH\u0000¢\u0006\u0004\bK\u0010LJC\u0010M\u001a\u00020&*\u0002022\u0006\u0010N\u001a\u00020!2\u0006\u0010>\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00012\u0006\u0010O\u001a\u00020P2\u0006\u0010@\u001a\u00020A2\u0006\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0004\bQ\u0010RJ;\u0010S\u001a\u00020&*\u0002022\u0006\u0010T\u001a\u00020!2\u0006\u0010>\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00012\u0006\u0010@\u001a\u00020A2\u0006\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0004\bU\u0010VJ\u0017\u0010W\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u0006H\u0002¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020\u0006H\u0002J5\u0010]\u001a\u00020&2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020I0_2\u0006\u0010`\u001a\u00020I2\u0006\u0010a\u001a\u00020I2\b\b\u0002\u0010b\u001a\u00020IH\u0000¢\u0006\u0002\bcR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001c\u0010\u0016\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010$¨\u0006d"}, d2 = {"Landroidx/compose/animation/LookaheadAnimationVisualDebugHelper;", "", "<init>", "()V", "reverseProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "restartProgress", "isProgressAnimationRunning", "", "sharedTransitionScopeOffset", "Landroidx/compose/ui/geometry/Offset;", "getSharedTransitionScopeOffset-F1C5BW0", "()J", "setSharedTransitionScopeOffset-k-4lQ0M", "(J)V", "J", "sharedTransitionScopeSize", "Landroidx/compose/ui/unit/IntSize;", "getSharedTransitionScopeSize-YbymL2g", "setSharedTransitionScopeSize-ozmzZPI", "debugOffset", "getDebugOffset-F1C5BW0", "setDebugOffset-k-4lQ0M", "debugPath", "Landroidx/compose/ui/graphics/Path;", "getDebugPath", "()Landroidx/compose/ui/graphics/Path;", "centerPath", "getCenterPath", "colors", "", "Landroidx/compose/ui/graphics/Color;", "getColors$annotations", "getColors", "()Ljava/util/List;", "onAttach", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onAttach$animation", "onDetach", "onDetach$animation", "updateDrawingCoordinates", "offsetInSharedTransitionScope", "sizeOfSharedTransitionScope", "updateDrawingCoordinates-CowoxoA$animation", "(JJ)V", "drawGlobalVisualizations", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawGlobalVisualizations$animation", "drawOverlay", "overlayColor", "drawOverlay-4WTKRHQ$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;J)V", "chooseColor", "key", "chooseColor-vNxB06k$animation", "(Ljava/lang/Object;)J", "drawInactiveVisualizations", "animationColor", "isShowKeyLabelEnabled", "strokeWidth", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "drawInactiveVisualizations-3IgeMak$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JZFLjava/lang/Object;Landroidx/compose/ui/text/TextMeasurer;)V", "drawLocalVisualizations", "targetOffset", "targetSize", "Landroidx/compose/ui/geometry/Size;", "currentRect", "Landroidx/compose/ui/geometry/Rect;", TtmlNode.CENTER, "drawLocalVisualizations-0XenJco$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JJJLandroidx/compose/ui/geometry/Rect;JZFLjava/lang/Object;Landroidx/compose/ui/text/TextMeasurer;)V", "drawMultipleMatchesElement", "multipleMatchesColor", "numMatches", "", "drawMultipleMatchesElement-sW7UJKQ$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JZLjava/lang/Object;ILandroidx/compose/ui/text/TextMeasurer;F)V", "drawUnmatchedElement", "unmatchedColor", "drawUnmatchedElement-3IgeMak$animation", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;JZLjava/lang/Object;Landroidx/compose/ui/text/TextMeasurer;F)V", "findPositionAlongPerimeter", "distanceTraveled", "findPositionAlongPerimeter-tuRUvjQ", "(F)J", "calculatePathCenter", "diamondWidth", "calculatePath", "spec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "current", TypedValues.AttributesType.S_TARGET, "initialVelocity", "calculatePath$animation", "animation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LookaheadAnimationVisualDebugHelper {
    public static final int $stable = 8;
    private boolean isProgressAnimationRunning;
    private final Animatable<Float, AnimationVector1D> reverseProgress = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private final Animatable<Float, AnimationVector1D> restartProgress = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
    private long sharedTransitionScopeOffset = Offset.Companion.m5119getZeroF1C5BW0();
    private long sharedTransitionScopeSize = IntSize.Companion.m8336getZeroYbymL2g();
    private long debugOffset = Offset.Companion.m5119getZeroF1C5BW0();
    private final Path debugPath = AndroidPath_androidKt.Path();
    private final Path centerPath = AndroidPath_androidKt.Path();
    private final List<Color> colors = CollectionsKt.listOf((Object[]) new Color[]{Color.m5338boximpl(ColorKt.Color(4293542709L)), Color.m5338boximpl(ColorKt.Color(4294086695L)), Color.m5338boximpl(ColorKt.Color(4291905755L)), Color.m5338boximpl(ColorKt.Color(4282549748L)), Color.m5338boximpl(ColorKt.Color(4282038458L))});

    public static /* synthetic */ void getColors$annotations() {
    }

    /* renamed from: getSharedTransitionScopeOffset-F1C5BW0  reason: not valid java name */
    public final long m129getSharedTransitionScopeOffsetF1C5BW0() {
        return this.sharedTransitionScopeOffset;
    }

    /* renamed from: setSharedTransitionScopeOffset-k-4lQ0M  reason: not valid java name */
    public final void m132setSharedTransitionScopeOffsetk4lQ0M(long j) {
        this.sharedTransitionScopeOffset = j;
    }

    /* renamed from: getSharedTransitionScopeSize-YbymL2g  reason: not valid java name */
    public final long m130getSharedTransitionScopeSizeYbymL2g() {
        return this.sharedTransitionScopeSize;
    }

    /* renamed from: setSharedTransitionScopeSize-ozmzZPI  reason: not valid java name */
    public final void m133setSharedTransitionScopeSizeozmzZPI(long j) {
        this.sharedTransitionScopeSize = j;
    }

    /* renamed from: getDebugOffset-F1C5BW0  reason: not valid java name */
    public final long m128getDebugOffsetF1C5BW0() {
        return this.debugOffset;
    }

    /* renamed from: setDebugOffset-k-4lQ0M  reason: not valid java name */
    public final void m131setDebugOffsetk4lQ0M(long j) {
        this.debugOffset = j;
    }

    public final Path getDebugPath() {
        return this.debugPath;
    }

    public final Path getCenterPath() {
        return this.centerPath;
    }

    public final List<Color> getColors() {
        return this.colors;
    }

    public final void onAttach$animation(CoroutineScope coroutineScope) {
        if (this.isProgressAnimationRunning) {
            return;
        }
        this.isProgressAnimationRunning = true;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LookaheadAnimationVisualDebugHelper$onAttach$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LookaheadAnimationVisualDebugHelper$onAttach$2(this, null), 3, null);
    }

    public final void onDetach$animation(CoroutineScope coroutineScope) {
        if (this.isProgressAnimationRunning) {
            this.isProgressAnimationRunning = false;
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new LookaheadAnimationVisualDebugHelper$onDetach$1(this, null), 3, null);
        }
    }

    /* renamed from: updateDrawingCoordinates-CowoxoA$animation  reason: not valid java name */
    public final void m134updateDrawingCoordinatesCowoxoA$animation(long j, long j2) {
        this.sharedTransitionScopeOffset = j;
        this.sharedTransitionScopeSize = j2;
    }

    public final void drawGlobalVisualizations$animation(ContentDrawScope contentDrawScope) {
        long j = this.sharedTransitionScopeSize;
        Brush m5299radialGradientP_VxKs$default = Brush.Companion.m5299radialGradientP_VxKs$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m5338boximpl(ColorKt.Color(4293542709L)), Color.m5338boximpl(ColorKt.Color(4282549748L)), Color.m5338boximpl(ColorKt.Color(4281641043L)), Color.m5338boximpl(ColorKt.Color(4294687748L)), Color.m5338boximpl(ColorKt.Color(4293542709L))}), m121findPositionAlongPerimetertuRUvjQ(((((int) (j >> 32)) * 2) + (((int) (j & 4294967295L)) * 2)) * this.restartProgress.getValue().floatValue()), 2000.0f, 0, 8, (Object) null);
        Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        Paint Paint = AndroidPaint_androidKt.Paint();
        m5299radialGradientP_VxKs$default.mo5293applyToPq9zytI(contentDrawScope.mo5922getSizeNHjbRc(), Paint, 1.0f);
        Paint.mo5228setStylek9PVt8s(PaintingStyle.Companion.m5630getStrokeTiuSbCo());
        Paint.setStrokeWidth((contentDrawScope.mo434toPx0680j_4(Dp.m8160constructorimpl(8.0f)) * this.reverseProgress.getValue().floatValue()) + contentDrawScope.mo434toPx0680j_4(Dp.m8160constructorimpl(4.0f)));
        canvas.save();
        canvas.translate(-Float.intBitsToFloat((int) (this.sharedTransitionScopeOffset >> 32)), -Float.intBitsToFloat((int) (this.sharedTransitionScopeOffset & 4294967295L)));
        long j2 = this.sharedTransitionScopeSize;
        canvas.drawRect(0.0f, 0.0f, (int) (j2 >> 32), (int) (j2 & 4294967295L), Paint);
        canvas.restore();
    }

    /* renamed from: drawOverlay-4WTKRHQ$animation  reason: not valid java name */
    public final void m126drawOverlay4WTKRHQ$animation(ContentDrawScope contentDrawScope, long j) {
        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope, j, 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    /* renamed from: chooseColor-vNxB06k$animation  reason: not valid java name */
    public final long m122chooseColorvNxB06k$animation(Object obj) {
        if (LookaheadAnimationVisualDebugHelperKt.access$getKeyToColor$p().contains(obj)) {
            V v = LookaheadAnimationVisualDebugHelperKt.access$getKeyToColor$p().get(obj);
            Intrinsics.checkNotNull(v);
            return ((Color) v).m5358unboximpl();
        }
        if (LookaheadAnimationVisualDebugHelperKt.access$getColorIndex$p() >= this.colors.size()) {
            LookaheadAnimationVisualDebugHelperKt.access$setColorIndex$p(0);
        }
        long m5358unboximpl = this.colors.get(LookaheadAnimationVisualDebugHelperKt.access$getColorIndex$p()).m5358unboximpl();
        LookaheadAnimationVisualDebugHelperKt.access$setColorIndex$p(LookaheadAnimationVisualDebugHelperKt.access$getColorIndex$p() + 1);
        LookaheadAnimationVisualDebugHelperKt.access$getKeyToColor$p().set(obj, Color.m5338boximpl(m5358unboximpl));
        return m5358unboximpl;
    }

    /* renamed from: drawInactiveVisualizations-3IgeMak$animation  reason: not valid java name */
    public final void m123drawInactiveVisualizations3IgeMak$animation(ContentDrawScope contentDrawScope, long j, boolean z, float f, Object obj, TextMeasurer textMeasurer) {
        float f2 = f * 2.0f;
        long j2 = j;
        if (Color.m5349equalsimpl0(j2, Color.Companion.m5384getUnspecified0d7_KjU())) {
            DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope, Color.Companion.m5385getWhite0d7_KjU(), 0L, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
            j2 = ColorKt.Color(4288323750L);
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, j2, 0L, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        if (!z || textMeasurer == null) {
            return;
        }
        TextPainterKt.m7594drawTextd8rzKo$default(contentDrawScope2, TextMeasurer.m7581measurewNUYSr0$default(textMeasurer, obj.toString(), new TextStyle(j2, TextUnitKt.getSp(18), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775164, (DefaultConstructorMarker) null), 0, false, 0, 0L, null, null, null, false, 1020, null), 0L, Offset.m5095constructorimpl((Float.floatToRawIntBits(10.0f) << 32) | (Float.floatToRawIntBits(10.0f) & 4294967295L)), 0.0f, null, null, null, 0, 250, null);
    }

    /* renamed from: drawLocalVisualizations-0XenJco$animation  reason: not valid java name */
    public final void m124drawLocalVisualizations0XenJco$animation(ContentDrawScope contentDrawScope, long j, long j2, long j3, Rect rect, long j4, boolean z, float f, Object obj, TextMeasurer textMeasurer) {
        ContentDrawScope contentDrawScope2;
        float f2;
        float f3;
        float intBitsToFloat;
        float intBitsToFloat2;
        Object obj2;
        long m122chooseColorvNxB06k$animation;
        ContentDrawScope contentDrawScope3;
        if (Color.m5349equalsimpl0(j, Color.Companion.m5383getTransparent0d7_KjU())) {
            return;
        }
        float f4 = f * 2.0f;
        if (Color.m5349equalsimpl0(j, Color.Companion.m5384getUnspecified0d7_KjU())) {
            contentDrawScope2 = contentDrawScope;
            DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, Color.Companion.m5385getWhite0d7_KjU(), 0L, 0L, 0.0f, new Stroke(f4, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
            int i = (int) (j2 >> 32);
            float intBitsToFloat3 = Float.intBitsToFloat(i) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() >> 32));
            int i2 = (int) (j2 & 4294967295L);
            float intBitsToFloat4 = Float.intBitsToFloat(i2) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() & 4294967295L));
            contentDrawScope2.getDrawContext().getTransform().translate(intBitsToFloat3, intBitsToFloat4);
            try {
                try {
                    f2 = intBitsToFloat4;
                    f3 = 0.5f;
                    try {
                        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, Color.Companion.m5385getWhite0d7_KjU(), 0L, j3, 0.0f, new Stroke(f4, 0.0f, 0, 0, null, 30, null), null, 0, 106, null);
                        contentDrawScope2.getDrawContext().getTransform().translate(-intBitsToFloat3, -f2);
                        intBitsToFloat = (Float.intBitsToFloat(i) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() >> 32))) - Float.intBitsToFloat((int) (this.debugOffset >> 32));
                        intBitsToFloat2 = (Float.intBitsToFloat(i2) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() & 4294967295L))) - Float.intBitsToFloat((int) (this.debugOffset & 4294967295L));
                        contentDrawScope2.getDrawContext().getTransform().translate(intBitsToFloat, intBitsToFloat2);
                        try {
                            float intBitsToFloat5 = Float.intBitsToFloat((int) (j3 >> 32)) * 0.5f;
                            float intBitsToFloat6 = Float.intBitsToFloat((int) (j3 & 4294967295L)) * 0.5f;
                            contentDrawScope2.getDrawContext().getTransform().translate(intBitsToFloat5, intBitsToFloat6);
                            DrawScope.m5912drawPathLG529CI$default(contentDrawScope2, this.debugPath, Color.Companion.m5385getWhite0d7_KjU(), 0.0f, new Stroke(f4, 0.0f, 0, 0, PathEffect.Companion.dashPathEffect$default(PathEffect.Companion, new float[]{20.0f, 10.0f}, 0.0f, 2, null), 14, null), null, 0, 52, null);
                            contentDrawScope2.getDrawContext().getTransform().translate(-intBitsToFloat5, -intBitsToFloat6);
                            contentDrawScope2.getDrawContext().getTransform().translate(-intBitsToFloat, -intBitsToFloat2);
                            calculatePathCenter(3.5f * f);
                            float intBitsToFloat7 = Float.intBitsToFloat((int) (j4 >> 32));
                            float intBitsToFloat8 = Float.intBitsToFloat((int) (j4 & 4294967295L));
                            contentDrawScope2.getDrawContext().getTransform().translate(intBitsToFloat7, intBitsToFloat8);
                            try {
                                DrawScope.m5912drawPathLG529CI$default(contentDrawScope2, this.centerPath, Color.Companion.m5385getWhite0d7_KjU(), 0.0f, null, null, 0, 60, null);
                                contentDrawScope2.getDrawContext().getTransform().translate(-intBitsToFloat7, -intBitsToFloat8);
                                obj2 = obj;
                                m122chooseColorvNxB06k$animation = m122chooseColorvNxB06k$animation(obj2);
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        th = th;
                        contentDrawScope2.getDrawContext().getTransform().translate(-intBitsToFloat3, -f2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    f2 = intBitsToFloat4;
                }
            } catch (Throwable th3) {
                th = th3;
                f2 = intBitsToFloat4;
            }
        } else {
            m122chooseColorvNxB06k$animation = j;
            f3 = 0.5f;
            obj2 = obj;
        }
        contentDrawScope2 = contentDrawScope;
        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, m122chooseColorvNxB06k$animation, 0L, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        int i3 = (int) (j2 >> 32);
        float intBitsToFloat9 = Float.intBitsToFloat(i3) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() >> 32));
        int i4 = (int) (j2 & 4294967295L);
        float intBitsToFloat10 = Float.intBitsToFloat(i4) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() & 4294967295L));
        contentDrawScope2.getDrawContext().getTransform().translate(intBitsToFloat9, intBitsToFloat10);
        try {
            try {
                DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, m122chooseColorvNxB06k$animation, 0L, j3, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 106, null);
                contentDrawScope2.getDrawContext().getTransform().translate(-intBitsToFloat9, -intBitsToFloat10);
                intBitsToFloat = (Float.intBitsToFloat(i3) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() >> 32))) - Float.intBitsToFloat((int) (this.debugOffset >> 32));
                intBitsToFloat2 = (Float.intBitsToFloat(i4) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() & 4294967295L))) - Float.intBitsToFloat((int) (this.debugOffset & 4294967295L));
                contentDrawScope2.getDrawContext().getTransform().translate(intBitsToFloat, intBitsToFloat2);
                try {
                    float intBitsToFloat11 = Float.intBitsToFloat((int) (j3 >> 32)) * f3;
                    float intBitsToFloat12 = Float.intBitsToFloat((int) (j3 & 4294967295L)) * f3;
                    contentDrawScope2.getDrawContext().getTransform().translate(intBitsToFloat11, intBitsToFloat12);
                    DrawScope.m5912drawPathLG529CI$default(contentDrawScope2, this.debugPath, m122chooseColorvNxB06k$animation, 0.0f, new Stroke(f, 0.0f, 0, 0, PathEffect.Companion.dashPathEffect$default(PathEffect.Companion, new float[]{20.0f, 10.0f}, 0.0f, 2, null), 14, null), null, 0, 52, null);
                    contentDrawScope2.getDrawContext().getTransform().translate(-intBitsToFloat11, -intBitsToFloat12);
                    contentDrawScope2.getDrawContext().getTransform().translate(-intBitsToFloat, -intBitsToFloat2);
                    calculatePathCenter(3.0f * f);
                    contentDrawScope2.getDrawContext().getTransform().translate(Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)));
                    try {
                        DrawScope.m5912drawPathLG529CI$default(contentDrawScope2, this.centerPath, m122chooseColorvNxB06k$animation, 0.0f, null, null, 0, 60, null);
                        if (!z || textMeasurer == null) {
                            return;
                        }
                        TextLayoutResult m7581measurewNUYSr0$default = TextMeasurer.m7581measurewNUYSr0$default(textMeasurer, obj2.toString(), new TextStyle(m122chooseColorvNxB06k$animation, TextUnitKt.getSp(18), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, Color.m5347copywmQWz5c$default(Color.Companion.m5385getWhite0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775164, (DefaultConstructorMarker) null), 0, false, 0, 0L, null, null, null, false, 1020, null);
                        TextPainterKt.m7594drawTextd8rzKo$default(contentDrawScope2, m7581measurewNUYSr0$default, 0L, Offset.m5095constructorimpl((Float.floatToRawIntBits(10.0f) << 32) | (Float.floatToRawIntBits(10.0f) & 4294967295L)), 0.0f, null, null, null, 0, 250, null);
                        intBitsToFloat = Float.intBitsToFloat(i3) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() >> 32));
                        intBitsToFloat2 = Float.intBitsToFloat(i4) - Float.intBitsToFloat((int) (rect.m5138getTopLeftF1C5BW0() & 4294967295L));
                        contentDrawScope2.getDrawContext().getTransform().translate(intBitsToFloat, intBitsToFloat2);
                        try {
                            try {
                                TextPainterKt.m7594drawTextd8rzKo$default(contentDrawScope2, m7581measurewNUYSr0$default, 0L, Offset.m5095constructorimpl((Float.floatToRawIntBits(10.0f) << 32) | (Float.floatToRawIntBits(10.0f) & 4294967295L)), 0.0f, null, null, null, 0, 250, null);
                            } catch (Throwable th4) {
                                th = th4;
                                contentDrawScope3 = contentDrawScope2;
                                contentDrawScope3.getDrawContext().getTransform().translate(-intBitsToFloat, -intBitsToFloat2);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th6) {
                th = th6;
                contentDrawScope3 = contentDrawScope2;
                contentDrawScope3.getDrawContext().getTransform().translate(-intBitsToFloat9, -intBitsToFloat10);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    /* renamed from: drawMultipleMatchesElement-sW7UJKQ$animation  reason: not valid java name */
    public final void m125drawMultipleMatchesElementsW7UJKQ$animation(ContentDrawScope contentDrawScope, long j, boolean z, Object obj, int i, TextMeasurer textMeasurer, float f) {
        String str;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, Color.Companion.m5385getWhite0d7_KjU(), 0L, 0L, 0.0f, new Stroke(f * 2.0f, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, j, 0L, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        if (z) {
            switch (i) {
                case 2:
                    str = "2️⃣";
                    break;
                case 3:
                    str = "3️⃣";
                    break;
                case 4:
                    str = "4️⃣";
                    break;
                case 5:
                    str = "5️⃣";
                    break;
                case 6:
                    str = "6️⃣";
                    break;
                case 7:
                    str = "7️⃣";
                    break;
                case 8:
                    str = "8️⃣";
                    break;
                case 9:
                    str = "9️⃣";
                    break;
                default:
                    str = "> 9️⃣";
                    break;
            }
            TextPainterKt.m7594drawTextd8rzKo$default(contentDrawScope2, TextMeasurer.m7581measurewNUYSr0$default(textMeasurer, obj + ": " + str + " matches", new TextStyle(Color.Companion.m5385getWhite0d7_KjU(), TextUnitKt.getSp(22), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, Color.m5347copywmQWz5c$default(j, 0.8f, 0.0f, 0.0f, 0.0f, 14, null), (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775160, (DefaultConstructorMarker) null), 0, false, 0, 0L, null, null, null, false, 1020, null), 0L, Offset.m5095constructorimpl((Float.floatToRawIntBits(10.0f) << 32) | (Float.floatToRawIntBits(10.0f) & 4294967295L)), 0.0f, null, null, null, 0, 250, null);
        }
    }

    /* renamed from: drawUnmatchedElement-3IgeMak$animation  reason: not valid java name */
    public final void m127drawUnmatchedElement3IgeMak$animation(ContentDrawScope contentDrawScope, long j, boolean z, Object obj, TextMeasurer textMeasurer, float f) {
        long j2;
        long j3;
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, Color.Companion.m5385getWhite0d7_KjU(), 0L, 0L, 0.0f, new Stroke(f * 2.0f, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        DrawScope.m5916drawRectnJ9OG0$default(contentDrawScope2, j, 0L, 0L, 0.0f, new Stroke(f, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
        float intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() & 4294967295L));
        int m5337getIntersectrtfAjoo = ClipOp.Companion.m5337getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope2.getDrawContext();
        long mo5843getSizeNHjbRc = drawContext.mo5843getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo5846clipRectN_I0leg(0.0f, 0.0f, intBitsToFloat, intBitsToFloat2, m5337getIntersectrtfAjoo);
            float intBitsToFloat3 = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() >> 32));
            float intBitsToFloat4 = Float.intBitsToFloat((int) (contentDrawScope2.mo5922getSizeNHjbRc() & 4294967295L));
            float f2 = -intBitsToFloat4;
            while (f2 < intBitsToFloat3) {
                try {
                    long j4 = mo5843getSizeNHjbRc;
                    float f3 = intBitsToFloat4;
                    j3 = j4;
                    try {
                        DrawScope.m5908drawLineNGM6Ib0$default(contentDrawScope2, Color.m5347copywmQWz5c$default(j, 0.3f, 0.0f, 0.0f, 0.0f, 14, null), Offset.m5095constructorimpl((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(intBitsToFloat4) & 4294967295L)), Offset.m5095constructorimpl((Float.floatToRawIntBits(f2 + intBitsToFloat4) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), f, 0, null, 0.0f, null, 0, 496, null);
                        f2 += 4.0f * f;
                        intBitsToFloat4 = f3;
                        mo5843getSizeNHjbRc = j3;
                    } catch (Throwable th) {
                        th = th;
                        j2 = j3;
                        drawContext.getCanvas().restore();
                        drawContext.mo5844setSizeuvyYCjk(j2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    j3 = mo5843getSizeNHjbRc;
                }
            }
            drawContext.getCanvas().restore();
            drawContext.mo5844setSizeuvyYCjk(mo5843getSizeNHjbRc);
            if (z) {
                TextPainterKt.m7594drawTextd8rzKo$default(contentDrawScope2, TextMeasurer.m7581measurewNUYSr0$default(textMeasurer, obj + ": 0️⃣ matches", new TextStyle(Color.Companion.m5385getWhite0d7_KjU(), TextUnitKt.getSp(22), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, Color.m5347copywmQWz5c$default(j, 0.8f, 0.0f, 0.0f, 0.0f, 14, null), (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16775160, (DefaultConstructorMarker) null), 0, false, 0, 0L, null, null, null, false, 1020, null), 0L, Offset.m5095constructorimpl((Float.floatToRawIntBits(10.0f) & 4294967295L) | (Float.floatToRawIntBits(10.0f) << 32)), 0.0f, null, null, null, 0, 250, null);
            }
        } catch (Throwable th3) {
            th = th3;
            j2 = mo5843getSizeNHjbRc;
        }
    }

    /* renamed from: findPositionAlongPerimeter-tuRUvjQ  reason: not valid java name */
    private final long m121findPositionAlongPerimetertuRUvjQ(float f) {
        float f2;
        long j = this.sharedTransitionScopeSize;
        float f3 = (int) (j >> 32);
        float f4 = (int) (j & 4294967295L);
        if (f <= f3) {
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L));
        } else if (f <= f3 + f4) {
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(f3) << 32) | (Float.floatToRawIntBits(f - f3) & 4294967295L));
        } else {
            float f5 = f3 * 2.0f;
            if (f <= f5 + f4) {
                return Offset.m5095constructorimpl((Float.floatToRawIntBits(f2 - f) << 32) | (Float.floatToRawIntBits(f4) & 4294967295L));
            }
            float f6 = ((f4 * 2.0f) + f5) - f;
            return Offset.m5095constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(f6) & 4294967295L));
        }
    }

    private final void calculatePathCenter(float f) {
        this.centerPath.rewind();
        Path path = this.centerPath;
        float f2 = -f;
        path.moveTo(0.0f, f2);
        path.lineTo(f, 0.0f);
        path.lineTo(0.0f, f);
        path.lineTo(f2, 0.0f);
        path.close();
    }

    public final void calculatePath$animation(FiniteAnimationSpec<Rect> finiteAnimationSpec, Rect rect, Rect rect2, Rect rect3) {
        long j;
        this.debugPath.rewind();
        if ((finiteAnimationSpec instanceof TweenSpec) || (finiteAnimationSpec instanceof SnapSpec) || ((finiteAnimationSpec instanceof ArcAnimationSpec) && ArcMode.m203equalsimpl0(((ArcAnimationSpec) finiteAnimationSpec).m199getMode9TMq4(), ArcMode.Companion.m209getArcLinear9TMq4()))) {
            this.debugPath.moveTo(Float.intBitsToFloat((int) (rect.m5133getCenterF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect.m5133getCenterF1C5BW0() & 4294967295L)));
            this.debugPath.lineTo(Float.intBitsToFloat((int) (rect2.m5133getCenterF1C5BW0() >> 32)), Float.intBitsToFloat((int) (rect2.m5133getCenterF1C5BW0() & 4294967295L)));
            this.debugPath.mo5240translatek4lQ0M(Offset.m5095constructorimpl(rect.m5133getCenterF1C5BW0() ^ (-9223372034707292160L)));
            this.debugOffset = Offset.m5107minusMKHz9U(rect2.m5133getCenterF1C5BW0(), rect.m5133getCenterF1C5BW0());
            return;
        }
        TargetBasedAnimation TargetBasedAnimation = AnimationKt.TargetBasedAnimation(finiteAnimationSpec, VectorConvertersKt.getVectorConverter(Rect.Companion), rect, rect2, rect3);
        long durationNanos = TargetBasedAnimation.getDurationNanos();
        Rect rect4 = (Rect) TargetBasedAnimation.getValueFromNanos(0L);
        int i = 0;
        while (true) {
            long m5133getCenterF1C5BW0 = ((Rect) TargetBasedAnimation.getValueFromNanos(durationNanos - (((float) durationNanos) * (i / 399.0f)))).m5133getCenterF1C5BW0();
            Path path = this.debugPath;
            if (i == 0) {
                j = -9223372034707292160L;
                path.moveTo(Float.intBitsToFloat((int) (m5133getCenterF1C5BW0 >> 32)), Float.intBitsToFloat((int) (m5133getCenterF1C5BW0 & 4294967295L)));
            } else {
                j = -9223372034707292160L;
                path.lineTo(Float.intBitsToFloat((int) (m5133getCenterF1C5BW0 >> 32)), Float.intBitsToFloat((int) (m5133getCenterF1C5BW0 & 4294967295L)));
            }
            if (i == 400) {
                this.debugPath.mo5240translatek4lQ0M(Offset.m5095constructorimpl(rect4.m5133getCenterF1C5BW0() ^ j));
                this.debugOffset = Offset.m5107minusMKHz9U(rect2.m5133getCenterF1C5BW0(), rect4.m5133getCenterF1C5BW0());
                return;
            }
            i++;
        }
    }

    public static /* synthetic */ void calculatePath$animation$default(LookaheadAnimationVisualDebugHelper lookaheadAnimationVisualDebugHelper, FiniteAnimationSpec finiteAnimationSpec, Rect rect, Rect rect2, Rect rect3, int i, Object obj) {
        if ((i & 8) != 0) {
            rect3 = RectKt.m5142Rect3MmeM6k(Offset.m5095constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(0.0f) & 4294967295L)), 0.0f);
        }
        lookaheadAnimationVisualDebugHelper.calculatePath$animation(finiteAnimationSpec, rect, rect2, rect3);
    }
}
