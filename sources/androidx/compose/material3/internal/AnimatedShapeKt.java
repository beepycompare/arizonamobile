package androidx.compose.material3.internal;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ShapeWithHorizontalCenterOptically;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
/* compiled from: AnimatedShape.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0004\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"rememberAnimatedShape", "Landroidx/compose/ui/graphics/Shape;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/material3/internal/AnimatedShapeState;", "(Landroidx/compose/material3/internal/AnimatedShapeState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "currentShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "(Landroidx/compose/foundation/shape/RoundedCornerShape;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedShapeKt {
    private static final Shape rememberAnimatedShape(final AnimatedShapeState animatedShapeState, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1383367813, "C(rememberAnimatedShape)N(state)90@3673L7,93@3721L1401:AnimatedShape.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1383367813, i, -1, "androidx.compose.material3.internal.rememberAnimatedShape (AnimatedShape.kt:89)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        animatedShapeState.setDensity(density);
        ComposerKt.sourceInformationMarkerStart(composer, 2023400020, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean changed = ((((i & 14) ^ 6) > 4 && composer.changed(animatedShapeState)) || (i & 6) == 4) | composer.changed(density);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new ShapeWithHorizontalCenterOptically() { // from class: androidx.compose.material3.internal.AnimatedShapeKt$rememberAnimatedShape$1$1
                private final MutableState clampedRange$delegate;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    MutableState mutableStateOf$default;
                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(RangesKt.rangeTo(0.0f, 1.0f), null, 2, null);
                    this.clampedRange$delegate = mutableStateOf$default;
                }

                public final ClosedFloatingPointRange<Float> getClampedRange() {
                    return (ClosedFloatingPointRange) this.clampedRange$delegate.getValue();
                }

                public final void setClampedRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
                    this.clampedRange$delegate.setValue(closedFloatingPointRange);
                }

                @Override // androidx.compose.material3.ShapeWithHorizontalCenterOptically
                public float offset() {
                    float floatValue = ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m2987topStartTmRCtEA$default(AnimatedShapeState.this, 0L, null, 3, null)), getClampedRange())).floatValue();
                    float floatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m2986topEndTmRCtEA$default(AnimatedShapeState.this, 0L, null, 3, null)), getClampedRange())).floatValue();
                    return (((floatValue + ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m2985bottomStartTmRCtEA$default(AnimatedShapeState.this, 0L, null, 3, null)), getClampedRange())).floatValue()) / 2.0f) - ((floatValue2 + ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m2984bottomEndTmRCtEA$default(AnimatedShapeState.this, 0L, null, 3, null)), getClampedRange())).floatValue()) / 2.0f)) * 0.11f;
                }

                @Override // androidx.compose.ui.graphics.Shape
                /* renamed from: createOutline-Pq9zytI */
                public Outline mo320createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density2) {
                    AnimatedShapeState.this.m2991setSizeuvyYCjk(j);
                    setClampedRange(RangesKt.rangeTo(0.0f, Float.intBitsToFloat((int) (4294967295L & j)) / 2.0f));
                    return RoundedCornerShapeKt.RoundedCornerShape(((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m2987topStartTmRCtEA$default(AnimatedShapeState.this, 0L, null, 3, null)), getClampedRange())).floatValue(), ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m2986topEndTmRCtEA$default(AnimatedShapeState.this, 0L, null, 3, null)), getClampedRange())).floatValue(), ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m2984bottomEndTmRCtEA$default(AnimatedShapeState.this, 0L, null, 3, null)), getClampedRange())).floatValue(), ((Number) RangesKt.coerceIn(Float.valueOf(AnimatedShapeState.m2985bottomStartTmRCtEA$default(AnimatedShapeState.this, 0L, null, 3, null)), getClampedRange())).floatValue()).mo320createOutlinePq9zytI(j, layoutDirection, density2);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        AnimatedShapeKt$rememberAnimatedShape$1$1 animatedShapeKt$rememberAnimatedShape$1$1 = (AnimatedShapeKt$rememberAnimatedShape$1$1) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return animatedShapeKt$rememberAnimatedShape$1$1;
    }

    public static final Shape rememberAnimatedShape(final RoundedCornerShape roundedCornerShape, FiniteAnimationSpec<Float> finiteAnimationSpec, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -288714613, "C(rememberAnimatedShape)N(currentShape,animationSpec)133@5294L90,135@5404L59,137@5480L33,137@5469L44,138@5549L177,138@5518L208,145@5739L28:AnimatedShape.kt#mqatfk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-288714613, i, -1, "androidx.compose.material3.internal.rememberAnimatedShape (AnimatedShape.kt:131)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1718136613, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean changed = composer.changed(finiteAnimationSpec);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new AnimatedShapeState(roundedCornerShape, finiteAnimationSpec);
            composer.updateRememberedValue(rememberedValue);
        }
        AnimatedShapeState animatedShapeState = (AnimatedShapeState) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1718140102, "CC(remember):AnimatedShape.kt#9igjgp");
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = ChannelKt.Channel$default(-1, null, null, 6, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        final Channel channel = (Channel) rememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1718142508, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean changedInstance = ((((i & 14) ^ 6) > 4 && composer.changed(roundedCornerShape)) || (i & 6) == 4) | composer.changedInstance(channel);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = new Function0() { // from class: androidx.compose.material3.internal.AnimatedShapeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AnimatedShapeKt.rememberAnimatedShape$lambda$4$lambda$3(Channel.this, roundedCornerShape);
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.SideEffect((Function0) rememberedValue3, composer, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 1718144860, "CC(remember):AnimatedShape.kt#9igjgp");
        boolean changedInstance2 = composer.changedInstance(channel) | composer.changed(animatedShapeState);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = (Function2) new AnimatedShapeKt$rememberAnimatedShape$3$1(channel, animatedShapeState, null);
            composer.updateRememberedValue(rememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(animatedShapeState, channel, (Function2) rememberedValue4, composer, 0);
        Shape rememberAnimatedShape = rememberAnimatedShape(animatedShapeState, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return rememberAnimatedShape;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rememberAnimatedShape$lambda$4$lambda$3(Channel channel, RoundedCornerShape roundedCornerShape) {
        channel.mo8396trySendJP2dKIU(roundedCornerShape);
        return Unit.INSTANCE;
    }
}
