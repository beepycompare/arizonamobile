package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Slide.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\n\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002¨\u0006\u000b"}, d2 = {"slide", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "offsetXFactor", "Landroidx/compose/ui/Modifier;", "factor", "offsetYFactor", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlideKt {
    public static /* synthetic */ StackAnimator slide$default(FiniteAnimationSpec finiteAnimationSpec, Orientation orientation, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
        }
        if ((i & 2) != 0) {
            orientation = Orientation.Horizontal;
        }
        return slide(finiteAnimationSpec, orientation);
    }

    public static final StackAnimator slide(FiniteAnimationSpec<Float> animationSpec, final Orientation orientation) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return StackAnimatorKt.stackAnimator(animationSpec, ComposableLambdaKt.composableLambdaInstance(352394828, true, new Function5<Float, Direction, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.SlideKt$slide$1

            /* compiled from: Slide.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Orientation.values().length];
                    try {
                        iArr[Orientation.Horizontal.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Orientation.Vertical.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(Float f, Direction direction, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Unit> function3, Composer composer, Integer num) {
                invoke(f.floatValue(), direction, (Function3<? super Modifier, ? super Composer, ? super Integer, Unit>) function3, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f, Direction unused$var$, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> content, Composer composer, int i) {
                int i2;
                Modifier offsetXFactor;
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                Intrinsics.checkNotNullParameter(content, "content");
                if ((i & 6) == 0) {
                    i2 = (composer.changed(f) ? 4 : 2) | i;
                } else {
                    i2 = i;
                }
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i2 |= composer.changedInstance(content) ? 256 : 128;
                }
                if ((i2 & 1155) != 1154 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(352394828, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.slide.<anonymous> (Slide.kt:16)");
                    }
                    int i3 = WhenMappings.$EnumSwitchMapping$0[Orientation.this.ordinal()];
                    if (i3 == 1) {
                        offsetXFactor = SlideKt.offsetXFactor(Modifier.Companion, f);
                    } else if (i3 == 2) {
                        offsetXFactor = SlideKt.offsetYFactor(Modifier.Companion, f);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    content.invoke(offsetXFactor, composer, Integer.valueOf((i2 >> 3) & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier offsetXFactor(Modifier modifier, final float f) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.SlideKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                MeasureResult offsetXFactor$lambda$1;
                offsetXFactor$lambda$1 = SlideKt.offsetXFactor$lambda$1(f, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                return offsetXFactor$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult offsetXFactor$lambda$1(final float f, MeasureScope layout, Measurable measurable, Constraints constraints) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(constraints.m6643unboximpl());
        return MeasureScope.layout$default(layout, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.SlideKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit offsetXFactor$lambda$1$lambda$0;
                offsetXFactor$lambda$1$lambda$0 = SlideKt.offsetXFactor$lambda$1$lambda$0(Placeable.this, f, (Placeable.PlacementScope) obj);
                return offsetXFactor$lambda$1$lambda$0;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit offsetXFactor$lambda$1$lambda$0(Placeable placeable, float f, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(layout, placeable, (int) (placeable.getWidth() * f), 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier offsetYFactor(Modifier modifier, final float f) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.SlideKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                MeasureResult offsetYFactor$lambda$3;
                offsetYFactor$lambda$3 = SlideKt.offsetYFactor$lambda$3(f, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                return offsetYFactor$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult offsetYFactor$lambda$3(final float f, MeasureScope layout, Measurable measurable, Constraints constraints) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(constraints.m6643unboximpl());
        return MeasureScope.layout$default(layout, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.SlideKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit offsetYFactor$lambda$3$lambda$2;
                offsetYFactor$lambda$3$lambda$2 = SlideKt.offsetYFactor$lambda$3$lambda$2(Placeable.this, f, (Placeable.PlacementScope) obj);
                return offsetYFactor$lambda$3$lambda$2;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit offsetYFactor$lambda$3$lambda$2(Placeable placeable, float f, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, (int) (placeable.getHeight() * f), 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
