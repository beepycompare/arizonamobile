package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.app.NotificationCompat;
import com.arkivanov.essenty.backhandler.BackEvent;
import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidPredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u0000 @2\u00020\u0001:\u0001@B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJD\u0010-\u001a\u00020.*\u00020/26\u00100\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005H\u0002JD\u00101\u001a\u00020.*\u00020/26\u00100\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005H\u0002J\u0016\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020.H\u0096@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u00020.H\u0096@¢\u0006\u0002\u00106Jd\u00108\u001a\u00020.2T\u00109\u001a+\u0012'\b\u0001\u0012#\b\u0001\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0<\u0012\u0006\u0012\u0004\u0018\u00010=0\u0005¢\u0006\u0002\b>0:\"#\b\u0001\u0012\u0004\u0012\u00020;\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0<\u0012\u0006\u0012\u0004\u0018\u00010=0\u0005¢\u0006\u0002\b>H\u0082@¢\u0006\u0002\u0010?J\f\u0010\u0013\u001a\u00020\u0006*\u00020\u0006H\u0002J\f\u0010\u0019\u001a\u00020\u0006*\u00020\u0006H\u0002R@\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u0015R+\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u0006A"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/AndroidPredictiveBackAnimatable;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "exitShape", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/graphics/Shape;", "enterShape", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "exitProgressAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "exitProgress", "getExitProgress", "()F", "exitProgress$delegate", "Landroidx/compose/runtime/State;", "enterProgressAnimatable", "enterProgress", "getEnterProgress", "enterProgress$delegate", "finishProgressAnimatable", "finishProgress", "getFinishProgress", "finishProgress$delegate", "<set-?>", "getEdge", "()Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "setEdge", "(Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;)V", "edge$delegate", "Landroidx/compose/runtime/MutableState;", "exitModifier", "Landroidx/compose/ui/Modifier;", "getExitModifier", "()Landroidx/compose/ui/Modifier;", "enterModifier", "getEnterModifier", "setupExitGraphicLayer", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layoutShape", "setupEnterGraphicLayer", "animate", NotificationCompat.CATEGORY_EVENT, "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "awaitAll", "actions", "", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "([Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidPredictiveBackAnimatable implements PredictiveBackAnimatable {
    private static final Companion Companion = new Companion(null);
    private static final float PROGRESS_THRESHOLD = 0.05f;
    private final MutableState edge$delegate;
    private final State enterProgress$delegate;
    private final Animatable<Float, AnimationVector1D> enterProgressAnimatable;
    private final Function2<Float, BackEvent.SwipeEdge, Shape> enterShape;
    private final State exitProgress$delegate;
    private final Animatable<Float, AnimationVector1D> exitProgressAnimatable;
    private final Function2<Float, BackEvent.SwipeEdge, Shape> exitShape;
    private final State finishProgress$delegate;
    private final Animatable<Float, AnimationVector1D> finishProgressAnimatable;

    /* JADX INFO: Access modifiers changed from: private */
    public final float exitProgress(float f) {
        if (f < PROGRESS_THRESHOLD) {
            return f;
        }
        return 1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidPredictiveBackAnimatable(BackEvent initialEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function22) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(initialEvent, "initialEvent");
        this.exitShape = function2;
        this.enterShape = function22;
        this.exitProgressAnimatable = AnimatableKt.Animatable$default(exitProgress(initialEvent.getProgress()), 0.0f, 2, null);
        this.exitProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float exitProgress_delegate$lambda$0;
                exitProgress_delegate$lambda$0 = AndroidPredictiveBackAnimatable.exitProgress_delegate$lambda$0(AndroidPredictiveBackAnimatable.this);
                return Float.valueOf(exitProgress_delegate$lambda$0);
            }
        });
        this.enterProgressAnimatable = AnimatableKt.Animatable$default(enterProgress(initialEvent.getProgress()), 0.0f, 2, null);
        this.enterProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float enterProgress_delegate$lambda$1;
                enterProgress_delegate$lambda$1 = AndroidPredictiveBackAnimatable.enterProgress_delegate$lambda$1(AndroidPredictiveBackAnimatable.this);
                return Float.valueOf(enterProgress_delegate$lambda$1);
            }
        });
        this.finishProgressAnimatable = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float finishProgress_delegate$lambda$2;
                finishProgress_delegate$lambda$2 = AndroidPredictiveBackAnimatable.finishProgress_delegate$lambda$2(AndroidPredictiveBackAnimatable.this);
                return Float.valueOf(finishProgress_delegate$lambda$2);
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialEvent.getSwipeEdge(), null, 2, null);
        this.edge$delegate = mutableStateOf$default;
    }

    public /* synthetic */ AndroidPredictiveBackAnimatable(BackEvent backEvent, Function2 function2, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backEvent, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float exitProgress_delegate$lambda$0(AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable) {
        return androidPredictiveBackAnimatable.exitProgressAnimatable.getValue().floatValue();
    }

    private final float getExitProgress() {
        return ((Number) this.exitProgress$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float enterProgress_delegate$lambda$1(AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable) {
        return androidPredictiveBackAnimatable.enterProgressAnimatable.getValue().floatValue();
    }

    private final float getEnterProgress() {
        return ((Number) this.enterProgress$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float finishProgress_delegate$lambda$2(AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable) {
        return androidPredictiveBackAnimatable.finishProgressAnimatable.getValue().floatValue();
    }

    private final float getFinishProgress() {
        return ((Number) this.finishProgress$delegate.getValue()).floatValue();
    }

    private final BackEvent.SwipeEdge getEdge() {
        return (BackEvent.SwipeEdge) this.edge$delegate.getValue();
    }

    private final void setEdge(BackEvent.SwipeEdge swipeEdge) {
        this.edge$delegate.setValue(swipeEdge);
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Modifier getExitModifier() {
        if (this.exitShape == null) {
            return LayoutCorners_androidKt.withLayoutCorners(Modifier.Companion, new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Modifier _get_exitModifier_$lambda$5;
                    _get_exitModifier_$lambda$5 = AndroidPredictiveBackAnimatable._get_exitModifier_$lambda$5(AndroidPredictiveBackAnimatable.this, (Modifier) obj, (LayoutCorners) obj2);
                    return _get_exitModifier_$lambda$5;
                }
            });
        }
        return GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_exitModifier_$lambda$6;
                _get_exitModifier_$lambda$6 = AndroidPredictiveBackAnimatable._get_exitModifier_$lambda$6(AndroidPredictiveBackAnimatable.this, (GraphicsLayerScope) obj);
                return _get_exitModifier_$lambda$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier _get_exitModifier_$lambda$5(final AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable, Modifier withLayoutCorners, final LayoutCorners corners) {
        Intrinsics.checkNotNullParameter(withLayoutCorners, "$this$withLayoutCorners");
        Intrinsics.checkNotNullParameter(corners, "corners");
        return GraphicsLayerModifierKt.graphicsLayer(withLayoutCorners, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_exitModifier_$lambda$5$lambda$4;
                _get_exitModifier_$lambda$5$lambda$4 = AndroidPredictiveBackAnimatable._get_exitModifier_$lambda$5$lambda$4(AndroidPredictiveBackAnimatable.this, corners, (GraphicsLayerScope) obj);
                return _get_exitModifier_$lambda$5$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_exitModifier_$lambda$5$lambda$4(AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable, final LayoutCorners layoutCorners, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        androidPredictiveBackAnimatable.setupExitGraphicLayer(graphicsLayer, new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Shape _get_exitModifier_$lambda$5$lambda$4$lambda$3;
                _get_exitModifier_$lambda$5$lambda$4$lambda$3 = AndroidPredictiveBackAnimatable._get_exitModifier_$lambda$5$lambda$4$lambda$3(LayoutCorners.this, ((Float) obj).floatValue(), (BackEvent.SwipeEdge) obj2);
                return _get_exitModifier_$lambda$5$lambda$4$lambda$3;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape _get_exitModifier_$lambda$5$lambda$4$lambda$3(LayoutCorners layoutCorners, float f, BackEvent.SwipeEdge swipeEdge) {
        Intrinsics.checkNotNullParameter(swipeEdge, "<unused var>");
        return LayoutCornersKt.toShape(layoutCorners, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_exitModifier_$lambda$6(AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        androidPredictiveBackAnimatable.setupExitGraphicLayer(graphicsLayer, androidPredictiveBackAnimatable.exitShape);
        return Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Modifier getEnterModifier() {
        if (this.enterShape == null) {
            return LayoutCorners_androidKt.withLayoutCorners(Modifier.Companion, new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Modifier _get_enterModifier_$lambda$9;
                    _get_enterModifier_$lambda$9 = AndroidPredictiveBackAnimatable._get_enterModifier_$lambda$9(AndroidPredictiveBackAnimatable.this, (Modifier) obj, (LayoutCorners) obj2);
                    return _get_enterModifier_$lambda$9;
                }
            });
        }
        return GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_enterModifier_$lambda$10;
                _get_enterModifier_$lambda$10 = AndroidPredictiveBackAnimatable._get_enterModifier_$lambda$10(AndroidPredictiveBackAnimatable.this, (GraphicsLayerScope) obj);
                return _get_enterModifier_$lambda$10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier _get_enterModifier_$lambda$9(final AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable, Modifier withLayoutCorners, final LayoutCorners corners) {
        Intrinsics.checkNotNullParameter(withLayoutCorners, "$this$withLayoutCorners");
        Intrinsics.checkNotNullParameter(corners, "corners");
        return GraphicsLayerModifierKt.graphicsLayer(withLayoutCorners, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_enterModifier_$lambda$9$lambda$8;
                _get_enterModifier_$lambda$9$lambda$8 = AndroidPredictiveBackAnimatable._get_enterModifier_$lambda$9$lambda$8(AndroidPredictiveBackAnimatable.this, corners, (GraphicsLayerScope) obj);
                return _get_enterModifier_$lambda$9$lambda$8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_enterModifier_$lambda$9$lambda$8(AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable, final LayoutCorners layoutCorners, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        androidPredictiveBackAnimatable.setupEnterGraphicLayer(graphicsLayer, new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatable$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Shape _get_enterModifier_$lambda$9$lambda$8$lambda$7;
                _get_enterModifier_$lambda$9$lambda$8$lambda$7 = AndroidPredictiveBackAnimatable._get_enterModifier_$lambda$9$lambda$8$lambda$7(LayoutCorners.this, ((Float) obj).floatValue(), (BackEvent.SwipeEdge) obj2);
                return _get_enterModifier_$lambda$9$lambda$8$lambda$7;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape _get_enterModifier_$lambda$9$lambda$8$lambda$7(LayoutCorners layoutCorners, float f, BackEvent.SwipeEdge swipeEdge) {
        Intrinsics.checkNotNullParameter(swipeEdge, "<unused var>");
        return LayoutCornersKt.toShape(layoutCorners, 1.0f - f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_enterModifier_$lambda$10(AndroidPredictiveBackAnimatable androidPredictiveBackAnimatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        androidPredictiveBackAnimatable.setupEnterGraphicLayer(graphicsLayer, androidPredictiveBackAnimatable.enterShape);
        return Unit.INSTANCE;
    }

    private final void setupExitGraphicLayer(GraphicsLayerScope graphicsLayerScope, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2) {
        graphicsLayerScope.setAlpha(1.0f - getExitProgress());
        graphicsLayerScope.setScaleX(1.0f - (getExitProgress() * 0.1f));
        graphicsLayerScope.setScaleY(graphicsLayerScope.getScaleX());
        graphicsLayerScope.setTranslationX(Size.m3906getWidthimpl(graphicsLayerScope.mo4265getSizeNHjbRc()) * 0.5f * getExitProgress());
        graphicsLayerScope.setShape(function2.invoke(Float.valueOf(getExitProgress()), getEdge()));
        graphicsLayerScope.setClip(true);
    }

    private final void setupEnterGraphicLayer(GraphicsLayerScope graphicsLayerScope, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2) {
        float lerp = MathHelpersKt.lerp(getEnterProgress(), 1.0f, getFinishProgress());
        graphicsLayerScope.setAlpha(lerp);
        graphicsLayerScope.setScaleX(MathHelpersKt.lerp(MathHelpersKt.lerp(0.95f, 0.9f, getEnterProgress()), 1.0f, getFinishProgress()));
        graphicsLayerScope.setScaleY(graphicsLayerScope.getScaleX());
        graphicsLayerScope.setTranslationX(MathHelpersKt.lerp((-Size.m3906getWidthimpl(graphicsLayerScope.mo4265getSizeNHjbRc())) * 0.15f, 0.0f, lerp));
        graphicsLayerScope.setShape(function2.invoke(Float.valueOf(getFinishProgress()), getEdge()));
        graphicsLayerScope.setClip(true);
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object animate(BackEvent backEvent, Continuation<? super Unit> continuation) {
        setEdge(backEvent.getSwipeEdge());
        Object awaitAll = awaitAll(new Function2[]{new AndroidPredictiveBackAnimatable$animate$2(this, backEvent, null), new AndroidPredictiveBackAnimatable$animate$3(this, backEvent, null)}, continuation);
        return awaitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitAll : Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object finish(Continuation<? super Unit> continuation) {
        Object awaitAll = awaitAll(new Function2[]{new AndroidPredictiveBackAnimatable$finish$2(this, null), new AndroidPredictiveBackAnimatable$finish$3(this, null)}, continuation);
        return awaitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitAll : Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object cancel(Continuation<? super Unit> continuation) {
        Object awaitAll = awaitAll(new Function2[]{new AndroidPredictiveBackAnimatable$cancel$2(this, null), new AndroidPredictiveBackAnimatable$cancel$3(this, null)}, continuation);
        return awaitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitAll : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitAll(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>[] function2Arr, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AndroidPredictiveBackAnimatable$awaitAll$2(function2Arr, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float enterProgress(float f) {
        if (f < PROGRESS_THRESHOLD) {
            return 0.0f;
        }
        return MathHelpersKt.lerp(0.4f, 1.0f, (f - PROGRESS_THRESHOLD) / 0.95f);
    }

    /* compiled from: AndroidPredictiveBackAnimatable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/AndroidPredictiveBackAnimatable$Companion;", "", "<init>", "()V", "PROGRESS_THRESHOLD", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
