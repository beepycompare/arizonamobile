package androidx.compose.material3.internal;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u000b¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/material3/internal/InputPhase;", "invoke", "(Landroidx/compose/animation/core/Transition$Segment;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/FiniteAnimationSpec;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 extends Lambda implements Function3<Transition.Segment<InputPhase>, Composer, Integer, FiniteAnimationSpec<Float>> {
    public static final TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1 INSTANCE = new TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1();

    public TextFieldImplKt$TextFieldTransitionScope$placeholderOpacity$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, Integer num) {
        return invoke(segment, composer, num.intValue());
    }

    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<InputPhase> segment, Composer composer, int i) {
        TweenSpec tween;
        composer.startReplaceGroup(-1154662212);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1154662212, i, -1, "androidx.compose.material3.internal.TextFieldTransitionScope.<anonymous> (TextFieldImpl.kt:367)");
        }
        if (segment.isTransitioningTo(InputPhase.Focused, InputPhase.UnfocusedEmpty)) {
            tween = AnimationSpecKt.tween$default(67, 0, EasingKt.getLinearEasing(), 2, null);
        } else if (segment.isTransitioningTo(InputPhase.UnfocusedEmpty, InputPhase.Focused) || segment.isTransitioningTo(InputPhase.UnfocusedNotEmpty, InputPhase.UnfocusedEmpty)) {
            tween = AnimationSpecKt.tween(83, 67, EasingKt.getLinearEasing());
        } else {
            tween = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tween;
    }
}
