package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.GapComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0003H\u0080\u0004\u001a\"\u0010\u0005\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\bH\u0007\u001a\"\u0010\n\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007\u001a;\u0010\f\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH\u0007\u001a;\u0010\u0014\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH\u0007\u001a3\u0010\u0016\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a3\u0010 \u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020!0\u00072\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0004\b%\u0010&\u001a3\u0010'\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020!0\u00072\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0004\b)\u0010*\u001aQ\u0010+\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020$2#\b\u0002\u0010/\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000fH\u0007\u001aQ\u00100\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u00101\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020$2#\b\u0002\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00100\u000fH\u0007\u001aQ\u00103\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010,\u001a\u0002042\b\b\u0002\u0010.\u001a\u00020$2#\b\u0002\u00105\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002060\u000fH\u0007\u001aQ\u00108\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u0010,\u001a\u0002092\b\b\u0002\u0010.\u001a\u00020$2#\b\u0002\u0010:\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002060\u000fH\u0007\u001aQ\u0010<\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u00101\u001a\u0002042\b\b\u0002\u0010.\u001a\u00020$2#\b\u0002\u0010=\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002060\u000fH\u0007\u001aQ\u0010>\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\b\b\u0002\u00101\u001a\u0002092\b\b\u0002\u0010.\u001a\u00020$2#\b\u0002\u0010?\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002060\u000fH\u0007\u001a=\u0010@\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010A\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002060\u000fH\u0007\u001a=\u0010B\u001a\u00020\u00012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010C\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002060\u000fH\u0007\u001a=\u0010D\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010E\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002060\u000fH\u0007\u001a=\u0010F\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00072#\b\u0002\u0010G\u001a\u001d\u0012\u0013\u0012\u001106¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(;\u0012\u0004\u0012\u0002060\u000fH\u0007\u001a\f\u0010H\u001a\u00020-*\u000204H\u0002\u001a\f\u0010H\u001a\u00020-*\u000209H\u0002\u001a,\u0010I\u001a\u0004\u0018\u0001HJ\"\b\b\u0000\u0010J*\u00020\u0003*\u00020\u00012\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0LH\u0080\u0002¢\u0006\u0002\u0010M\u001a,\u0010I\u001a\u0004\u0018\u0001HJ\"\b\b\u0000\u0010J*\u00020\u0003*\u00020\u00042\f\u0010K\u001a\b\u0012\u0004\u0012\u0002HJ0LH\u0080\u0002¢\u0006\u0002\u0010N\u001aI\u0010O\u001a\u00020P*\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\u00042\b\b\u0002\u0010U\u001a\u00020$2\u000e\b\u0002\u0010V\u001a\b\u0012\u0004\u0012\u00020$0W2\u0006\u0010X\u001a\u00020YH\u0001¢\u0006\u0002\u0010Z\u001a\u001f\u0010[\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010S\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\\\u001a\u001f\u0010]\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010T\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010^\u001a/\u0010_\u001a\u00020`*\b\u0012\u0004\u0012\u00020R0Q2\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\u00042\u0006\u0010X\u001a\u00020YH\u0003¢\u0006\u0002\u0010a\"\u001a\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020d0cX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010e\u001a\b\u0012\u0004\u0012\u00020\b0fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010g\u001a\b\u0012\u0004\u0012\u00020!0fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00100fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j²\u0006\n\u0010k\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010l\u001a\u00020\u0004X\u008a\u008e\u0002"}, d2 = {"withEffect", "Landroidx/compose/animation/EnterTransition;", "effect", "Landroidx/compose/animation/TransitionEffect;", "Landroidx/compose/animation/ExitTransition;", "fadeIn", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "initialAlpha", "fadeOut", "targetAlpha", "slideIn", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "fullSize", "slideOut", "targetOffset", "scaleIn", "initialScale", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "scaleIn-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/EnterTransition;", "scaleOut", "targetScale", "scaleOut-L8ZKh-E", "(Landroidx/compose/animation/core/FiniteAnimationSpec;FJ)Landroidx/compose/animation/ExitTransition;", "unveilIn", "Landroidx/compose/ui/graphics/Color;", "initialColor", "matchParentSize", "", "unveilIn-bw27NRU", "(Landroidx/compose/animation/core/FiniteAnimationSpec;JZ)Landroidx/compose/animation/EnterTransition;", "veilOut", "targetColor", "veilOut-bw27NRU", "(Landroidx/compose/animation/core/FiniteAnimationSpec;JZ)Landroidx/compose/animation/ExitTransition;", "expandIn", "expandFrom", "Landroidx/compose/ui/Alignment;", "clip", "initialSize", "shrinkOut", "shrinkTowards", "targetSize", "expandHorizontally", "Landroidx/compose/ui/Alignment$Horizontal;", "initialWidth", "", "fullWidth", "expandVertically", "Landroidx/compose/ui/Alignment$Vertical;", "initialHeight", "fullHeight", "shrinkHorizontally", "targetWidth", "shrinkVertically", "targetHeight", "slideInHorizontally", "initialOffsetX", "slideInVertically", "initialOffsetY", "slideOutHorizontally", "targetOffsetX", "slideOutVertically", "targetOffsetY", "toAlignment", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroidx/compose/animation/TransitionEffectKey;", "(Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "(Landroidx/compose/animation/ExitTransition;Landroidx/compose/animation/TransitionEffectKey;)Landroidx/compose/animation/TransitionEffect;", "createModifier", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/EnterExitState;", "enter", "exit", "trackActiveEnterExit", "isEnabled", "Lkotlin/Function0;", Constants.ScionAnalytics.PARAM_LABEL, "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "trackActiveEnter", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterTransition;", "trackActiveExit", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/ExitTransition;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/ExitTransition;", "createGraphicsLayerBlock", "Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/GraphicsLayerBlockForEnterExit;", "TransformOriginVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/animation/core/AnimationVector2D;", "DefaultAlphaAndScaleSpring", "Landroidx/compose/animation/core/SpringSpec;", "DefaultColorAnimationSpec", "DefaultOffsetAnimationSpec", "DefaultSizeAnimationSpec", "animation", "activeEnter", "activeExit"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EnterExitTransitionKt {
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ AnimationVector2D invoke(TransformOrigin transformOrigin) {
            return m96invoke__ExYCQ(transformOrigin.m5760unboximpl());
        }

        /* renamed from: invoke-__ExYCQ  reason: not valid java name */
        public final AnimationVector2D m96invoke__ExYCQ(long j) {
            return new AnimationVector2D(TransformOrigin.m5756getPivotFractionXimpl(j), TransformOrigin.m5757getPivotFractionYimpl(j));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TransformOrigin invoke(AnimationVector2D animationVector2D) {
            return TransformOrigin.m5748boximpl(m97invokeLIALnN8(animationVector2D));
        }

        /* renamed from: invoke-LIALnN8  reason: not valid java name */
        public final long m97invokeLIALnN8(AnimationVector2D animationVector2D) {
            return TransformOriginKt.TransformOrigin(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<Color> DefaultColorAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m8279boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m8323boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);

    public static final EnterTransition withEffect(EnterTransition enterTransition, TransitionEffect transitionEffect) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, null, null, false, MapsKt.mapOf(TuplesKt.to(transitionEffect.getKey$animation(), transitionEffect)), 63, null));
    }

    public static final ExitTransition withEffect(ExitTransition exitTransition, TransitionEffect transitionEffect) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, null, null, false, MapsKt.mapOf(TuplesKt.to(transitionEffect.getKey$animation(), transitionEffect)), 63, null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    public static final EnterTransition fadeIn(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, null, false, null, WebSocketProtocol.PAYLOAD_SHORT, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    public static final ExitTransition fadeOut(FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, null, false, null, WebSocketProtocol.PAYLOAD_SHORT, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m8279boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideIn(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new EnterTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, null, false, null, GapComposerKt.nodeKey, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m8279boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOut(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Function1<? super IntSize, IntOffset> function1) {
        return new ExitTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, null, false, null, GapComposerKt.nodeKey, null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ EnterTransition m89scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m5761getCenterSzJe1aQ();
        }
        return m88scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleIn-L8ZKh-E  reason: not valid java name */
    public static final EnterTransition m88scaleInL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, null), null, false, null, 119, null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default  reason: not valid java name */
    public static /* synthetic */ ExitTransition m91scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.m5761getCenterSzJe1aQ();
        }
        return m90scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    /* renamed from: scaleOut-L8ZKh-E  reason: not valid java name */
    public static final ExitTransition m90scaleOutL8ZKhE(FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, null), null, false, null, 119, null));
    }

    /* renamed from: unveilIn-bw27NRU$default  reason: not valid java name */
    public static /* synthetic */ EnterTransition m93unveilInbw27NRU$default(FiniteAnimationSpec finiteAnimationSpec, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            j = Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return m92unveilInbw27NRU(finiteAnimationSpec, j, z);
    }

    /* renamed from: unveilIn-bw27NRU  reason: not valid java name */
    public static final EnterTransition m92unveilInbw27NRU(FiniteAnimationSpec<Color> finiteAnimationSpec, long j, boolean z) {
        return new EnterTransitionImpl(new TransitionData(null, null, null, null, new Veil(j, Color.m5347copywmQWz5c$default(j, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), finiteAnimationSpec, z, null), false, null, 111, null));
    }

    /* renamed from: veilOut-bw27NRU$default  reason: not valid java name */
    public static /* synthetic */ ExitTransition m95veilOutbw27NRU$default(FiniteAnimationSpec finiteAnimationSpec, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null);
        }
        if ((i & 2) != 0) {
            j = Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return m94veilOutbw27NRU(finiteAnimationSpec, j, z);
    }

    /* renamed from: veilOut-bw27NRU  reason: not valid java name */
    public static final ExitTransition m94veilOutbw27NRU(FiniteAnimationSpec<Color> finiteAnimationSpec, long j, boolean z) {
        return new ExitTransitionImpl(new TransitionData(null, null, null, null, new Veil(Color.m5347copywmQWz5c$default(j, 0.0f, 0.0f, 0.0f, 0.0f, 14, null), j, finiteAnimationSpec, z, null), false, null, 111, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m8323boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandIn$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m8323boximpl(m100invokemzRDjE0(intSize.m8335unboximpl()));
                }

                /* renamed from: invoke-mzRDjE0  reason: not valid java name */
                public final long m100invokemzRDjE0(long j) {
                    return IntSize.m8326constructorimpl(0L);
                }
            };
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    public static final EnterTransition expandIn(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), null, null, false, null, 123, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m8323boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                    return IntSize.m8323boximpl(m103invokemzRDjE0(intSize.m8335unboximpl()));
                }

                /* renamed from: invoke-mzRDjE0  reason: not valid java name */
                public final long m103invokemzRDjE0(long j) {
                    return IntSize.m8326constructorimpl(0L);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    public static final ExitTransition shrinkOut(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment alignment, boolean z, Function1<? super IntSize, IntSize> function1) {
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), null, null, false, null, 123, null));
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m8323boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final EnterTransition expandHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, final Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(horizontal), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m8323boximpl(m99invokemzRDjE0(intSize.m8335unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0  reason: not valid java name */
            public final long m99invokemzRDjE0(long j) {
                return IntSize.m8326constructorimpl((((int) (j & 4294967295L)) & 4294967295L) | (function1.invoke(Integer.valueOf((int) (j >> 32))).intValue() << 32));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m8323boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final EnterTransition expandVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, final Function1<? super Integer, Integer> function1) {
        return expandIn(finiteAnimationSpec, toAlignment(vertical), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m8323boximpl(m101invokemzRDjE0(intSize.m8335unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0  reason: not valid java name */
            public final long m101invokemzRDjE0(long j) {
                return IntSize.m8326constructorimpl((((int) (j >> 32)) << 32) | (function1.invoke(Integer.valueOf((int) (j & 4294967295L))).intValue() & 4294967295L));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m8323boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkHorizontally(finiteAnimationSpec, horizontal, z, function1);
    }

    public static final ExitTransition shrinkHorizontally(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Horizontal horizontal, boolean z, final Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(horizontal), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m8323boximpl(m102invokemzRDjE0(intSize.m8335unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0  reason: not valid java name */
            public final long m102invokemzRDjE0(long j) {
                return IntSize.m8326constructorimpl((((int) (j & 4294967295L)) & 4294967295L) | (function1.invoke(Integer.valueOf((int) (j >> 32))).intValue() << 32));
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment.Vertical vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.m8323boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
                public final Integer invoke(int i2) {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, vertical, z, function1);
    }

    public static final ExitTransition shrinkVertically(FiniteAnimationSpec<IntSize> finiteAnimationSpec, Alignment.Vertical vertical, boolean z, final Function1<? super Integer, Integer> function1) {
        return shrinkOut(finiteAnimationSpec, toAlignment(vertical), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntSize invoke(IntSize intSize) {
                return IntSize.m8323boximpl(m104invokemzRDjE0(intSize.m8335unboximpl()));
            }

            /* renamed from: invoke-mzRDjE0  reason: not valid java name */
            public final long m104invokemzRDjE0(long j) {
                return IntSize.m8326constructorimpl((((int) (j >> 32)) << 32) | (function1.invoke(Integer.valueOf((int) (j & 4294967295L))).intValue() & 4294967295L));
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m8279boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m8279boximpl(m105invokemHKZG7I(intSize.m8335unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I  reason: not valid java name */
            public final long m105invokemHKZG7I(long j) {
                return IntOffset.m8282constructorimpl(function1.invoke(Integer.valueOf((int) (j >> 32))).intValue() << 32);
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m8279boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    public static final EnterTransition slideInVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m8279boximpl(m106invokemHKZG7I(intSize.m8335unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I  reason: not valid java name */
            public final long m106invokemHKZG7I(long j) {
                return IntOffset.m8282constructorimpl(function1.invoke(Integer.valueOf((int) (j & 4294967295L))).intValue() & 4294967295L);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m8279boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutHorizontally(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m8279boximpl(m107invokemHKZG7I(intSize.m8335unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I  reason: not valid java name */
            public final long m107invokemHKZG7I(long j) {
                return IntOffset.m8282constructorimpl(function1.invoke(Integer.valueOf((int) (j >> 32))).intValue() << 32);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.m8279boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    public static final ExitTransition slideOutVertically(FiniteAnimationSpec<IntOffset> finiteAnimationSpec, final Function1<? super Integer, Integer> function1) {
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ IntOffset invoke(IntSize intSize) {
                return IntOffset.m8279boximpl(m108invokemHKZG7I(intSize.m8335unboximpl()));
            }

            /* renamed from: invoke-mHKZG7I  reason: not valid java name */
            public final long m108invokemHKZG7I(long j) {
                return IntOffset.m8282constructorimpl(function1.invoke(Integer.valueOf((int) (j & 4294967295L))).intValue() & 4294967295L);
            }
        });
    }

    private static final Alignment toAlignment(Alignment.Horizontal horizontal) {
        return Intrinsics.areEqual(horizontal, Alignment.Companion.getStart()) ? Alignment.Companion.getCenterStart() : Intrinsics.areEqual(horizontal, Alignment.Companion.getEnd()) ? Alignment.Companion.getCenterEnd() : Alignment.Companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment.Vertical vertical) {
        return Intrinsics.areEqual(vertical, Alignment.Companion.getTop()) ? Alignment.Companion.getTopCenter() : Intrinsics.areEqual(vertical, Alignment.Companion.getBottom()) ? Alignment.Companion.getBottomCenter() : Alignment.Companion.getCenter();
    }

    public static final <T extends TransitionEffect> T get(EnterTransition enterTransition, TransitionEffectKey<T> transitionEffectKey) {
        TransitionEffect transitionEffect = enterTransition.getData$animation().getEffectsMap().get(transitionEffectKey);
        if (transitionEffect instanceof TransitionEffect) {
            return (T) transitionEffect;
        }
        return null;
    }

    public static final <T extends TransitionEffect> T get(ExitTransition exitTransition, TransitionEffectKey<T> transitionEffectKey) {
        TransitionEffect transitionEffect = exitTransition.getData$animation().getEffectsMap().get(transitionEffectKey);
        if (transitionEffect instanceof TransitionEffect) {
            return (T) transitionEffect;
        }
        return null;
    }

    public static final Modifier createModifier(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, boolean z, Function0<Boolean> function0, String str, Composer composer, int i, int i2) {
        final Function0<Boolean> function02;
        EnterTransition enterTransition2;
        ExitTransition exitTransition2;
        Transition.DeferredAnimation deferredAnimation;
        Transition.DeferredAnimation deferredAnimation2;
        Transition.DeferredAnimation deferredAnimation3;
        ChangeSize changeSize;
        Rgb m5352getColorSpaceimpl;
        Transition<EnterExitState> transition2;
        Modifier.Companion companion;
        ComposerKt.sourceInformationMarkerStart(composer, -1899614022, "C(createModifier)N(enter,exit,trackActiveEnterExit,isEnabled,label)931@41627L8,985@43772L56,987@43944L38:EnterExitTransition.kt#xbi5r1");
        boolean z2 = true;
        boolean z3 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -167968766, "CC(remember):EnterExitTransition.kt#9igjgp");
            EnterExitTransitionKt$createModifier$1$1 rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function0<Boolean>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$1$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return true;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            function02 = (Function0) rememberedValue;
        } else {
            function02 = function0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1899614022, i, -1, "androidx.compose.animation.createModifier (EnterExitTransition.kt:933)");
        }
        if (z3) {
            composer.startReplaceGroup(-167965831);
            ComposerKt.sourceInformation(composer, "934@41718L31");
            EnterTransition trackActiveEnter = trackActiveEnter(transition, enterTransition, composer, i & WebSocketProtocol.PAYLOAD_SHORT);
            composer.endReplaceGroup();
            enterTransition2 = trackActiveEnter;
        } else {
            composer.startReplaceGroup(-167964673);
            composer.endReplaceGroup();
            enterTransition2 = enterTransition;
        }
        if (z3) {
            composer.startReplaceGroup(-167962954);
            ComposerKt.sourceInformation(composer, "935@41808L28");
            ExitTransition trackActiveExit = trackActiveExit(transition, exitTransition, composer, (i & 14) | ((i >> 3) & 112));
            composer.endReplaceGroup();
            exitTransition2 = trackActiveExit;
        } else {
            composer.startReplaceGroup(-167961890);
            composer.endReplaceGroup();
            exitTransition2 = exitTransition;
        }
        boolean z4 = (enterTransition2.getData$animation().getVeil() == null && exitTransition2.getData$animation().getVeil() == null) ? false : true;
        boolean z5 = (enterTransition2.getData$animation().getSlide() == null && exitTransition2.getData$animation().getSlide() == null) ? false : true;
        boolean z6 = (enterTransition2.getData$animation().getChangeSize() == null && exitTransition2.getData$animation().getChangeSize() == null) ? false : true;
        if (z5) {
            composer.startReplaceGroup(-911488127);
            ComposerKt.sourceInformation(composer, "944@42270L27,944@42219L79");
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            ComposerKt.sourceInformationMarkerStart(composer, -167948171, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = str + " slide";
                composer.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Transition.DeferredAnimation createDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) rememberedValue2, composer, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            composer.endReplaceGroup();
            deferredAnimation = createDeferredAnimation;
        } else {
            composer.startReplaceGroup(-911382324);
            composer.endReplaceGroup();
            deferredAnimation = null;
        }
        if (z6) {
            composer.startReplaceGroup(-911290533);
            ComposerKt.sourceInformation(composer, "950@42467L35,950@42418L85");
            TwoWayConverter<IntSize, AnimationVector2D> vectorConverter2 = VectorConvertersKt.getVectorConverter(IntSize.Companion);
            ComposerKt.sourceInformationMarkerStart(composer, -167941859, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = str + " shrink/expand";
                composer.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Transition.DeferredAnimation createDeferredAnimation2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) rememberedValue3, composer, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            composer.endReplaceGroup();
            deferredAnimation2 = createDeferredAnimation2;
        } else {
            composer.startReplaceGroup(-911179709);
            composer.endReplaceGroup();
            deferredAnimation2 = null;
        }
        if (z6) {
            composer.startReplaceGroup(-911106083);
            ComposerKt.sourceInformation(composer, "957@42686L48,955@42602L147");
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter3 = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            ComposerKt.sourceInformationMarkerStart(composer, -167934838, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = str + " InterruptionHandlingOffset";
                composer.updateRememberedValue(rememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Transition.DeferredAnimation createDeferredAnimation3 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter3, (String) rememberedValue4, composer, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            composer.endReplaceGroup();
            deferredAnimation3 = createDeferredAnimation3;
        } else {
            composer.startReplaceGroup(-910935677);
            composer.endReplaceGroup();
            deferredAnimation3 = null;
        }
        ChangeSize changeSize2 = enterTransition2.getData$animation().getChangeSize();
        final boolean z7 = ((changeSize2 == null || changeSize2.getClip()) && ((changeSize = exitTransition2.getData$animation().getChangeSize()) == null || changeSize.getClip()) && z6) ? false : true;
        Veil veil = enterTransition2.getData$animation().getVeil();
        if (veil == null || (m5352getColorSpaceimpl = Color.m5352getColorSpaceimpl(veil.m182getInitialColor0d7_KjU())) == null) {
            Veil veil2 = enterTransition2.getData$animation().getVeil();
            if (veil2 != null) {
                m5352getColorSpaceimpl = Color.m5352getColorSpaceimpl(veil2.m183getTargetColor0d7_KjU());
            } else {
                Veil veil3 = exitTransition2.getData$animation().getVeil();
                m5352getColorSpaceimpl = veil3 != null ? Color.m5352getColorSpaceimpl(veil3.m182getInitialColor0d7_KjU()) : null;
                if (m5352getColorSpaceimpl == null) {
                    Veil veil4 = exitTransition2.getData$animation().getVeil();
                    ColorSpace m5352getColorSpaceimpl2 = veil4 != null ? Color.m5352getColorSpaceimpl(veil4.m183getTargetColor0d7_KjU()) : null;
                    m5352getColorSpaceimpl = m5352getColorSpaceimpl2 == null ? ColorSpaces.INSTANCE.getSrgb() : m5352getColorSpaceimpl2;
                }
            }
        }
        if (z4) {
            composer.startReplaceGroup(-910409203);
            ComposerKt.sourceInformation(composer, "976@43437L26,974@43337L145");
            TwoWayConverter<Color, AnimationVector4D> invoke = ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(m5352getColorSpaceimpl);
            ComposerKt.sourceInformationMarkerStart(composer, -167910828, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = str + " veil";
                composer.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            transition2 = transition;
            VeilModifierElement veilModifierElement = new VeilModifierElement(transition2, androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition2, invoke, (String) rememberedValue5, composer, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0), enterTransition2, exitTransition2);
            composer.endReplaceGroup();
            companion = veilModifierElement;
        } else {
            transition2 = transition;
            composer.startReplaceGroup(-910130296);
            composer.endReplaceGroup();
            companion = Modifier.Companion;
        }
        Modifier.Companion companion2 = companion;
        Veil veil5 = enterTransition2.getData$animation().getVeil();
        boolean matchParentSize = (veil5 == null && (veil5 = exitTransition2.getData$animation().getVeil()) == null) ? false : veil5.getMatchParentSize();
        EnterTransition enterTransition3 = enterTransition2;
        ExitTransition exitTransition3 = exitTransition2;
        GraphicsLayerBlockForEnterExit createGraphicsLayerBlock = createGraphicsLayerBlock(transition2, enterTransition3, exitTransition3, str, composer, (i & 14) | ((i >> 6) & 7168));
        Modifier.Companion companion3 = matchParentSize ? companion2 : Modifier.Companion;
        Modifier.Companion companion4 = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart(composer, -167894592, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean changed = composer.changed(z7);
        if ((((57344 & i) ^ 24576) <= 16384 || !composer.changed(function02)) && (i & 24576) != 16384) {
            z2 = false;
        }
        boolean z8 = changed | z2;
        Object rememberedValue6 = composer.rememberedValue();
        if (z8 || rememberedValue6 == Composer.Companion.getEmpty()) {
            rememberedValue6 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createModifier$2$1
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
                    graphicsLayerScope.setClip(!z7 && function02.invoke().booleanValue());
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier then = companion3.then(GraphicsLayerModifierKt.graphicsLayer(companion4, (Function1) rememberedValue6)).then(new EnterExitTransitionElement(transition, deferredAnimation2, deferredAnimation3, deferredAnimation, enterTransition3, exitTransition3, function02, createGraphicsLayerBlock));
        if (matchParentSize) {
            companion2 = Modifier.Companion;
        }
        Modifier then2 = then.then(companion2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return then2;
    }

    public static final EnterTransition trackActiveEnter(Transition<EnterExitState> transition, EnterTransition enterTransition, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 21614502, "C(trackActiveEnter)N(enter)1009@44903L40:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21614502, i, -1, "androidx.compose.animation.trackActiveEnter (EnterExitTransition.kt:1004)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -703284114, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(enterTransition, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(enterTransition);
            } else {
                mutableState.setValue(EnterTransition.Companion.getNone());
            }
        } else if (transition.getTargetState() == EnterExitState.Visible) {
            mutableState.setValue(trackActiveEnter$lambda$1(mutableState).plus(enterTransition));
        }
        EnterTransition trackActiveEnter$lambda$1 = trackActiveEnter$lambda$1(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return trackActiveEnter$lambda$1;
    }

    private static final EnterTransition trackActiveEnter$lambda$1(MutableState<EnterTransition> mutableState) {
        return mutableState.getValue();
    }

    public static final ExitTransition trackActiveExit(Transition<EnterExitState> transition, ExitTransition exitTransition, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1363864804, "C(trackActiveExit)N(exit)1029@45884L39:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1363864804, i, -1, "androidx.compose.animation.trackActiveExit (EnterExitTransition.kt:1024)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -709035581, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(exitTransition, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (transition.getCurrentState() == transition.getTargetState() && transition.getCurrentState() == EnterExitState.Visible) {
            if (transition.isSeeking()) {
                mutableState.setValue(exitTransition);
            } else {
                mutableState.setValue(ExitTransition.Companion.getNone());
            }
        } else if (transition.getTargetState() != EnterExitState.Visible) {
            mutableState.setValue(trackActiveExit$lambda$1(mutableState).plus(exitTransition));
        }
        ExitTransition trackActiveExit$lambda$1 = trackActiveExit$lambda$1(mutableState);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return trackActiveExit$lambda$1;
    }

    private static final ExitTransition trackActiveExit$lambda$1(MutableState<ExitTransition> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0147, code lost:
        if (r3.changed(r1) == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0162, code lost:
        if (r3.changed(r2) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0181, code lost:
        if (r3.changed(r4) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0188, code lost:
        if ((r25 & 6) == 4) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x018a, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x018b, code lost:
        r0 = (r0 | r8) | r3.changedInstance(r12);
        r5 = r3.rememberedValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0195, code lost:
        if (r0 != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x019d, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x019f, code lost:
        r17 = r1;
        r18 = r2;
        r16 = r4;
        r19 = r12;
        r13 = new androidx.compose.animation.EnterExitTransitionKt$$ExternalSyntheticLambda0(r14, r15, r16, r17, r18, r19);
        r3.updateRememberedValue(r13);
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01b0, code lost:
        r5 = (androidx.compose.animation.GraphicsLayerBlockForEnterExit) r5;
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01b9, code lost:
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01bb, code lost:
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01be, code lost:
        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01c1, code lost:
        return r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final GraphicsLayerBlockForEnterExit createGraphicsLayerBlock(Transition<EnterExitState> transition, EnterTransition enterTransition, ExitTransition exitTransition, String str, Composer composer, int i) {
        final Transition.DeferredAnimation deferredAnimation;
        final Transition.DeferredAnimation deferredAnimation2;
        EnterTransition enterTransition2;
        boolean z;
        ExitTransition exitTransition2;
        boolean z2;
        Transition<EnterExitState> transition2;
        Composer composer2 = composer;
        ComposerKt.sourceInformationMarkerStart(composer2, 642253525, "C(createGraphicsLayerBlock)N(enter,exit,label)1084@47814L3043:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(642253525, i, -1, "androidx.compose.animation.createGraphicsLayerBlock (EnterExitTransition.kt:1052)");
        }
        boolean z3 = false;
        boolean z4 = (enterTransition.getData$animation().getFade() == null && exitTransition.getData$animation().getFade() == null) ? false : true;
        boolean z5 = (enterTransition.getData$animation().getScale() == null && exitTransition.getData$animation().getScale() == null) ? false : true;
        Transition.DeferredAnimation deferredAnimation3 = null;
        if (z4) {
            composer2.startReplaceGroup(-703879421);
            ComposerKt.sourceInformation(composer2, "1064@47248L27,1062@47144L146");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer2, -1269628144, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = str + " alpha";
                composer2.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Transition.DeferredAnimation createDeferredAnimation = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter, (String) rememberedValue, composer2, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            composer2 = composer2;
            composer2.endReplaceGroup();
            deferredAnimation = createDeferredAnimation;
        } else {
            composer2.startReplaceGroup(-703709976);
            composer2.endReplaceGroup();
            deferredAnimation = null;
        }
        if (z5) {
            composer2.startReplaceGroup(-703642333);
            ComposerKt.sourceInformation(composer2, "1072@47487L27,1070@47383L146");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composer2, -1269620496, "CC(remember):EnterExitTransition.kt#9igjgp");
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = str + " scale";
                composer2.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Transition.DeferredAnimation createDeferredAnimation2 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, vectorConverter2, (String) rememberedValue2, composer2, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            composer2.endReplaceGroup();
            deferredAnimation2 = createDeferredAnimation2;
        } else {
            composer2.startReplaceGroup(-703472888);
            composer2.endReplaceGroup();
            deferredAnimation2 = null;
        }
        if (z5) {
            composer2.startReplaceGroup(-703395232);
            ComposerKt.sourceInformation(composer2, "1078@47632L149");
            deferredAnimation3 = androidx.compose.animation.core.TransitionKt.createDeferredAnimation(transition, TransformOriginVectorConverter, "TransformOriginInterruptionHandling", composer2, (i & 14) | RendererCapabilities.DECODER_SUPPORT_MASK, 0);
            composer2.endReplaceGroup();
        } else {
            composer2.startReplaceGroup(-703222904);
            composer2.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -1269607016, "CC(remember):EnterExitTransition.kt#9igjgp");
        boolean changedInstance = composer2.changedInstance(deferredAnimation);
        if (((i & 112) ^ 48) > 32) {
            enterTransition2 = enterTransition;
        } else {
            enterTransition2 = enterTransition;
        }
        if ((i & 48) != 32) {
            z = false;
            boolean z6 = changedInstance | z;
            if (((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
                exitTransition2 = exitTransition;
            } else {
                exitTransition2 = exitTransition;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
                z2 = false;
                boolean changedInstance2 = z6 | z2 | composer2.changedInstance(deferredAnimation2);
                if (((i & 14) ^ 6) > 4) {
                    transition2 = transition;
                } else {
                    transition2 = transition;
                }
            }
            z2 = true;
            boolean changedInstance22 = z6 | z2 | composer2.changedInstance(deferredAnimation2);
            if (((i & 14) ^ 6) > 4) {
            }
        }
        z = true;
        boolean z62 = changedInstance | z;
        if (((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) <= 256) {
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) != 256) {
        }
        z2 = true;
        boolean changedInstance222 = z62 | z2 | composer2.changedInstance(deferredAnimation2);
        if (((i & 14) ^ 6) > 4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 createGraphicsLayerBlock$lambda$2$0(Transition.DeferredAnimation deferredAnimation, Transition.DeferredAnimation deferredAnimation2, Transition transition, final EnterTransition enterTransition, final ExitTransition exitTransition, Transition.DeferredAnimation deferredAnimation3) {
        final TransformOrigin m5748boximpl;
        final State animate = deferredAnimation != null ? deferredAnimation.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
                SpringSpec springSpec;
                SpringSpec springSpec2;
                FiniteAnimationSpec<Float> animationSpec;
                SpringSpec springSpec3;
                FiniteAnimationSpec<Float> animationSpec2;
                if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                    Fade fade = EnterTransition.this.getData$animation().getFade();
                    if (fade == null || (animationSpec2 = fade.getAnimationSpec()) == null) {
                        springSpec3 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        return springSpec3;
                    }
                    return animationSpec2;
                } else if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                    springSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec;
                } else {
                    Fade fade2 = exitTransition.getData$animation().getFade();
                    if (fade2 == null || (animationSpec = fade2.getAnimationSpec()) == null) {
                        springSpec2 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        return springSpec2;
                    }
                    return animationSpec;
                }
            }
        }, new Function1<EnterExitState, Float>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$alpha$2

            /* compiled from: EnterExitTransition.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(EnterExitState enterExitState) {
                int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                float f = 1.0f;
                if (i != 1) {
                    if (i == 2) {
                        Fade fade = EnterTransition.this.getData$animation().getFade();
                        if (fade != null) {
                            f = fade.getAlpha();
                        }
                    } else if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Fade fade2 = exitTransition.getData$animation().getFade();
                        if (fade2 != null) {
                            f = fade2.getAlpha();
                        }
                    }
                }
                return Float.valueOf(f);
            }
        }) : null;
        final State animate2 = deferredAnimation2 != null ? deferredAnimation2.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
                SpringSpec springSpec;
                SpringSpec springSpec2;
                FiniteAnimationSpec<Float> animationSpec;
                SpringSpec springSpec3;
                FiniteAnimationSpec<Float> animationSpec2;
                if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
                    Scale scale = EnterTransition.this.getData$animation().getScale();
                    if (scale == null || (animationSpec2 = scale.getAnimationSpec()) == null) {
                        springSpec3 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        return springSpec3;
                    }
                    return animationSpec2;
                } else if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
                    springSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                    return springSpec;
                } else {
                    Scale scale2 = exitTransition.getData$animation().getScale();
                    if (scale2 == null || (animationSpec = scale2.getAnimationSpec()) == null) {
                        springSpec2 = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
                        return springSpec2;
                    }
                    return animationSpec;
                }
            }
        }, new Function1<EnterExitState, Float>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$scale$2

            /* compiled from: EnterExitTransition.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(EnterExitState enterExitState) {
                int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                float f = 1.0f;
                if (i != 1) {
                    if (i == 2) {
                        Scale scale = EnterTransition.this.getData$animation().getScale();
                        if (scale != null) {
                            f = scale.getScale();
                        }
                    } else if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Scale scale2 = exitTransition.getData$animation().getScale();
                        if (scale2 != null) {
                            f = scale2.getScale();
                        }
                    }
                }
                return Float.valueOf(f);
            }
        }) : null;
        if (transition.getCurrentState() == EnterExitState.PreEnter) {
            Scale scale = enterTransition.getData$animation().getScale();
            if (scale != null || (scale = exitTransition.getData$animation().getScale()) != null) {
                m5748boximpl = TransformOrigin.m5748boximpl(scale.m143getTransformOriginSzJe1aQ());
            }
            m5748boximpl = null;
        } else {
            Scale scale2 = exitTransition.getData$animation().getScale();
            if (scale2 != null || (scale2 = enterTransition.getData$animation().getScale()) != null) {
                m5748boximpl = TransformOrigin.m5748boximpl(scale2.m143getTransformOriginSzJe1aQ());
            }
            m5748boximpl = null;
        }
        final State animate3 = deferredAnimation3 != null ? deferredAnimation3.animate(new Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<TransformOrigin>>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$1
            @Override // kotlin.jvm.functions.Function1
            public final FiniteAnimationSpec<TransformOrigin> invoke(Transition.Segment<EnterExitState> segment) {
                return AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            }
        }, new Function1<EnterExitState, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$transformOrigin$2

            /* compiled from: EnterExitTransition.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes.dex */
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[EnterExitState.values().length];
                    try {
                        iArr[EnterExitState.Visible.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[EnterExitState.PreEnter.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[EnterExitState.PostExit.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TransformOrigin invoke(EnterExitState enterExitState) {
                return TransformOrigin.m5748boximpl(m98invokeLIALnN8(enterExitState));
            }

            /* renamed from: invoke-LIALnN8  reason: not valid java name */
            public final long m98invokeLIALnN8(EnterExitState enterExitState) {
                TransformOrigin transformOrigin;
                long m143getTransformOriginSzJe1aQ;
                long m143getTransformOriginSzJe1aQ2;
                int i = WhenMappings.$EnumSwitchMapping$0[enterExitState.ordinal()];
                if (i != 1) {
                    transformOrigin = null;
                    if (i == 2) {
                        Scale scale3 = enterTransition.getData$animation().getScale();
                        if (scale3 != null) {
                            m143getTransformOriginSzJe1aQ = scale3.m143getTransformOriginSzJe1aQ();
                        } else {
                            Scale scale4 = exitTransition.getData$animation().getScale();
                            if (scale4 != null) {
                                m143getTransformOriginSzJe1aQ = scale4.m143getTransformOriginSzJe1aQ();
                            }
                        }
                        transformOrigin = TransformOrigin.m5748boximpl(m143getTransformOriginSzJe1aQ);
                    } else if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Scale scale5 = exitTransition.getData$animation().getScale();
                        if (scale5 != null) {
                            m143getTransformOriginSzJe1aQ2 = scale5.m143getTransformOriginSzJe1aQ();
                        } else {
                            Scale scale6 = enterTransition.getData$animation().getScale();
                            if (scale6 != null) {
                                m143getTransformOriginSzJe1aQ2 = scale6.m143getTransformOriginSzJe1aQ();
                            }
                        }
                        transformOrigin = TransformOrigin.m5748boximpl(m143getTransformOriginSzJe1aQ2);
                    }
                } else {
                    transformOrigin = TransformOrigin.this;
                }
                if (transformOrigin != null) {
                    return transformOrigin.m5760unboximpl();
                }
                return TransformOrigin.Companion.m5761getCenterSzJe1aQ();
            }
        }) : null;
        return new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.EnterExitTransitionKt$createGraphicsLayerBlock$1$1$block$1
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
                State<Float> state = animate;
                graphicsLayerScope.setAlpha(state != null ? state.getValue().floatValue() : 1.0f);
                State<Float> state2 = animate2;
                graphicsLayerScope.setScaleX(state2 != null ? state2.getValue().floatValue() : 1.0f);
                State<Float> state3 = animate2;
                graphicsLayerScope.setScaleY(state3 != null ? state3.getValue().floatValue() : 1.0f);
                State<TransformOrigin> state4 = animate3;
                graphicsLayerScope.mo5549setTransformOrigin__ExYCQ(state4 != null ? state4.getValue().m5760unboximpl() : TransformOrigin.Companion.m5761getCenterSzJe1aQ());
            }
        };
    }
}
