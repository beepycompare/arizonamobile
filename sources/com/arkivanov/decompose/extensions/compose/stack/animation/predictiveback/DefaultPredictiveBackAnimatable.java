package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.core.app.NotificationCompat;
import com.arkivanov.essenty.backhandler.BackEvent;
import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DefaultPredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010#R>\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u001c¨\u0006%"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/DefaultPredictiveBackAnimatable;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialBackEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "getExitModifier", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/Modifier;", "getEnterModifier", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "progressAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "<set-?>", "swipeEdge", "getSwipeEdge", "()Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "setSwipeEdge", "(Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;)V", "swipeEdge$delegate", "Landroidx/compose/runtime/MutableState;", "exitModifier", "()Landroidx/compose/ui/Modifier;", "enterModifier", "animate", "", NotificationCompat.CATEGORY_EVENT, "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultPredictiveBackAnimatable implements PredictiveBackAnimatable {
    public static final int $stable = Animatable.$stable;
    private final Function2<Float, BackEvent.SwipeEdge, Modifier> getEnterModifier;
    private final Function2<Float, BackEvent.SwipeEdge, Modifier> getExitModifier;
    private final Animatable<Float, AnimationVector1D> progressAnimatable;
    private final MutableState swipeEdge$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultPredictiveBackAnimatable(BackEvent initialBackEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Modifier> getExitModifier, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Modifier> getEnterModifier) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(initialBackEvent, "initialBackEvent");
        Intrinsics.checkNotNullParameter(getExitModifier, "getExitModifier");
        Intrinsics.checkNotNullParameter(getEnterModifier, "getEnterModifier");
        this.getExitModifier = getExitModifier;
        this.getEnterModifier = getEnterModifier;
        this.progressAnimatable = AnimatableKt.Animatable$default(initialBackEvent.getProgress(), 0.0f, 2, null);
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialBackEvent.getSwipeEdge(), null, 2, null);
        this.swipeEdge$delegate = mutableStateOf$default;
    }

    private final BackEvent.SwipeEdge getSwipeEdge() {
        return (BackEvent.SwipeEdge) this.swipeEdge$delegate.getValue();
    }

    private final void setSwipeEdge(BackEvent.SwipeEdge swipeEdge) {
        this.swipeEdge$delegate.setValue(swipeEdge);
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Modifier getExitModifier() {
        return this.getExitModifier.invoke(this.progressAnimatable.getValue(), getSwipeEdge());
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Modifier getEnterModifier() {
        return this.getEnterModifier.invoke(this.progressAnimatable.getValue(), getSwipeEdge());
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object animate(BackEvent backEvent, Continuation<? super Unit> continuation) {
        setSwipeEdge(backEvent.getSwipeEdge());
        Object snapTo = this.progressAnimatable.snapTo(Boxing.boxFloat(backEvent.getProgress()), continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object finish(Continuation<? super Unit> continuation) {
        Object animateTo$default = Animatable.animateTo$default(this.progressAnimatable, Boxing.boxFloat(1.0f), null, null, null, continuation, 14, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object cancel(Continuation<? super Unit> continuation) {
        Object animateTo$default = Animatable.animateTo$default(this.progressAnimatable, Boxing.boxFloat(0.0f), null, null, null, continuation, 14, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }
}
