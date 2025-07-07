package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.ui.graphics.Shape;
import com.arkivanov.essenty.backhandler.BackEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MaterialPredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005H\u0007¨\u0006\r"}, d2 = {"materialPredictiveBackAnimatable", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialBackEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "shape", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/graphics/Shape;", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MaterialPredictiveBackAnimatableKt {
    public static /* synthetic */ PredictiveBackAnimatable materialPredictiveBackAnimatable$default(BackEvent backEvent, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        return materialPredictiveBackAnimatable(backEvent, function2);
    }

    public static final PredictiveBackAnimatable materialPredictiveBackAnimatable(BackEvent initialBackEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2) {
        Intrinsics.checkNotNullParameter(initialBackEvent, "initialBackEvent");
        return new MaterialPredictiveBackAnimatable(initialBackEvent, function2);
    }
}
