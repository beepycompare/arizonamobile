package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StackAnimator.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a~\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032a\u0010\u0005\u001a]\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012$\u0012\"\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0006¢\u0006\u0002\b\u000f¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0086\u0002¨\u0006\u0014"}, d2 = {"stackAnimator", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", TypedValues.AttributesType.S_FRAME, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "factor", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "direction", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "", "Landroidx/compose/runtime/Composable;", FirebaseAnalytics.Param.CONTENT, "(Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function5;)Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "plus", "other", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StackAnimatorKt {
    public static /* synthetic */ StackAnimator stackAnimator$default(FiniteAnimationSpec finiteAnimationSpec, Function5 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
        }
        return stackAnimator(finiteAnimationSpec, function5);
    }

    public static final StackAnimator stackAnimator(FiniteAnimationSpec<Float> animationSpec, Function5<? super Float, ? super Direction, ? super Function3<? super Modifier, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> frame) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(frame, "frame");
        return new DefaultStackAnimator(animationSpec, frame);
    }

    public static final StackAnimator plus(StackAnimator stackAnimator, StackAnimator other) {
        Intrinsics.checkNotNullParameter(stackAnimator, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return new PlusStackAnimator(stackAnimator, other);
    }
}
