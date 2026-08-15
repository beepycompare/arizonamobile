package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.ui.graphics.Shape;
import com.arkivanov.essenty.backhandler.BackEvent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidPredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005H\u0007\u001a\u0088\u0001\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005H\u0007\u001a\u0088\u0001\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00052:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005H\u0007¨\u0006\u0010"}, d2 = {"androidPredictiveBackAnimatable", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialBackEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "exitShape", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/graphics/Shape;", "enterShape", "androidPredictiveBackAnimatableV1", "androidPredictiveBackAnimatableV2", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidPredictiveBackAnimatableKt {
    public static /* synthetic */ PredictiveBackAnimatable androidPredictiveBackAnimatable$default(BackEvent backEvent, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = null;
        }
        return androidPredictiveBackAnimatable(backEvent, function2, function22);
    }

    @Deprecated(message = "Please use androidPredictiveBackAnimatableV1() or androidPredictiveBackAnimatableV2() functions", replaceWith = @ReplaceWith(expression = "androidPredictiveBackAnimatableV1(initialBackEvent, exitShape, enterShape)", imports = {"com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.androidPredictiveBackAnimatableV1"}))
    public static final PredictiveBackAnimatable androidPredictiveBackAnimatable(BackEvent initialBackEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function22) {
        Intrinsics.checkNotNullParameter(initialBackEvent, "initialBackEvent");
        return androidPredictiveBackAnimatableV1(initialBackEvent, function2, function22);
    }

    public static /* synthetic */ PredictiveBackAnimatable androidPredictiveBackAnimatableV1$default(BackEvent backEvent, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = null;
        }
        return androidPredictiveBackAnimatableV1(backEvent, function2, function22);
    }

    public static final PredictiveBackAnimatable androidPredictiveBackAnimatableV1(BackEvent initialBackEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function22) {
        Intrinsics.checkNotNullParameter(initialBackEvent, "initialBackEvent");
        return new AndroidPredictiveBackAnimatableV1(initialBackEvent, function2, function22);
    }

    public static /* synthetic */ PredictiveBackAnimatable androidPredictiveBackAnimatableV2$default(BackEvent backEvent, Function2 function2, Function2 function22, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = null;
        }
        return androidPredictiveBackAnimatableV2(backEvent, function2, function22);
    }

    public static final PredictiveBackAnimatable androidPredictiveBackAnimatableV2(BackEvent initialBackEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function22) {
        Intrinsics.checkNotNullParameter(initialBackEvent, "initialBackEvent");
        return new AndroidPredictiveBackAnimatableV2(initialBackEvent, function2, function22);
    }
}
