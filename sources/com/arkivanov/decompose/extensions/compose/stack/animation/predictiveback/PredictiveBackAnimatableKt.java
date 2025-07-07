package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.ui.Modifier;
import com.arkivanov.essenty.backhandler.BackEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0080\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u000526\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005H\u0007¨\u0006\u000e"}, d2 = {"predictiveBackAnimatable", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialBackEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "exitModifier", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/Modifier;", "enterModifier", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PredictiveBackAnimatableKt {
    public static final PredictiveBackAnimatable predictiveBackAnimatable(BackEvent initialBackEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Modifier> exitModifier, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Modifier> enterModifier) {
        Intrinsics.checkNotNullParameter(initialBackEvent, "initialBackEvent");
        Intrinsics.checkNotNullParameter(exitModifier, "exitModifier");
        Intrinsics.checkNotNullParameter(enterModifier, "enterModifier");
        return new DefaultPredictiveBackAnimatable(initialBackEvent, exitModifier, enterModifier);
    }
}
