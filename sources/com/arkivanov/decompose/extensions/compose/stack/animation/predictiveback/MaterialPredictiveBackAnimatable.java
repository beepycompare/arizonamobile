package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import com.arkivanov.essenty.backhandler.BackEvent;
import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialPredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010-\u001a\u00020.*\u00020/2\u0006\u00100\u001a\u00020\fH\u0002J\u0016\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020.H\u0096@¢\u0006\u0002\u00105J\u000e\u00106\u001a\u00020.H\u0096@¢\u0006\u0002\u00105R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010!\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u00067"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/MaterialPredictiveBackAnimatable;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "exitShape", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/jvm/functions/Function2;)V", "finishProgressAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finishProgress", "getFinishProgress", "()F", "finishProgress$delegate", "Landroidx/compose/runtime/State;", "progressAnimatable", "getProgress", "progress$delegate", "<set-?>", "getEdge", "()Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "setEdge", "(Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;)V", "edge$delegate", "Landroidx/compose/runtime/MutableState;", "touchY", "getTouchY", "setTouchY", "(F)V", "touchY$delegate", "Landroidx/compose/runtime/MutableFloatState;", "exitModifier", "Landroidx/compose/ui/Modifier;", "getExitModifier", "()Landroidx/compose/ui/Modifier;", "enterModifier", "getEnterModifier", "setupExitGraphicLayer", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layoutShape", "animate", NotificationCompat.CATEGORY_EVENT, "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MaterialPredictiveBackAnimatable implements PredictiveBackAnimatable {
    private final MutableState edge$delegate;
    private final Function2<Float, BackEvent.SwipeEdge, Shape> exitShape;
    private final State finishProgress$delegate;
    private final Animatable<Float, AnimationVector1D> finishProgressAnimatable;
    private final BackEvent initialEvent;
    private final State progress$delegate;
    private final Animatable<Float, AnimationVector1D> progressAnimatable;
    private final MutableFloatState touchY$delegate;

    /* compiled from: MaterialPredictiveBackAnimatable.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackEvent.SwipeEdge.values().length];
            try {
                iArr[BackEvent.SwipeEdge.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BackEvent.SwipeEdge.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BackEvent.SwipeEdge.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MaterialPredictiveBackAnimatable(BackEvent initialEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(initialEvent, "initialEvent");
        this.initialEvent = initialEvent;
        this.exitShape = function2;
        this.finishProgressAnimatable = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
        this.finishProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float finishProgress_delegate$lambda$0;
                finishProgress_delegate$lambda$0 = MaterialPredictiveBackAnimatable.finishProgress_delegate$lambda$0(MaterialPredictiveBackAnimatable.this);
                return Float.valueOf(finishProgress_delegate$lambda$0);
            }
        });
        this.progressAnimatable = AnimatableKt.Animatable$default(initialEvent.getProgress(), 0.0f, 2, null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float progress_delegate$lambda$1;
                progress_delegate$lambda$1 = MaterialPredictiveBackAnimatable.progress_delegate$lambda$1(MaterialPredictiveBackAnimatable.this);
                return Float.valueOf(progress_delegate$lambda$1);
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialEvent.getSwipeEdge(), null, 2, null);
        this.edge$delegate = mutableStateOf$default;
        this.touchY$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(initialEvent.getTouchY());
    }

    public /* synthetic */ MaterialPredictiveBackAnimatable(BackEvent backEvent, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backEvent, (i & 2) != 0 ? null : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float finishProgress_delegate$lambda$0(MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable) {
        return materialPredictiveBackAnimatable.finishProgressAnimatable.getValue().floatValue();
    }

    private final float getFinishProgress() {
        return ((Number) this.finishProgress$delegate.getValue()).floatValue();
    }

    private final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float progress_delegate$lambda$1(MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable) {
        return materialPredictiveBackAnimatable.progressAnimatable.getValue().floatValue();
    }

    private final BackEvent.SwipeEdge getEdge() {
        return (BackEvent.SwipeEdge) this.edge$delegate.getValue();
    }

    private final void setEdge(BackEvent.SwipeEdge swipeEdge) {
        this.edge$delegate.setValue(swipeEdge);
    }

    private final float getTouchY() {
        return this.touchY$delegate.getFloatValue();
    }

    private final void setTouchY(float f) {
        this.touchY$delegate.setFloatValue(f);
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Modifier getExitModifier() {
        if (this.exitShape == null) {
            return LayoutCorners_androidKt.withLayoutCorners(Modifier.Companion, new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Modifier _get_exitModifier_$lambda$3;
                    _get_exitModifier_$lambda$3 = MaterialPredictiveBackAnimatable._get_exitModifier_$lambda$3(MaterialPredictiveBackAnimatable.this, (Modifier) obj, (LayoutCorners) obj2);
                    return _get_exitModifier_$lambda$3;
                }
            });
        }
        return GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_exitModifier_$lambda$4;
                _get_exitModifier_$lambda$4 = MaterialPredictiveBackAnimatable._get_exitModifier_$lambda$4(MaterialPredictiveBackAnimatable.this, (GraphicsLayerScope) obj);
                return _get_exitModifier_$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier _get_exitModifier_$lambda$3(final MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable, Modifier withLayoutCorners, final LayoutCorners corners) {
        Intrinsics.checkNotNullParameter(withLayoutCorners, "$this$withLayoutCorners");
        Intrinsics.checkNotNullParameter(corners, "corners");
        return GraphicsLayerModifierKt.graphicsLayer(withLayoutCorners, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_exitModifier_$lambda$3$lambda$2;
                _get_exitModifier_$lambda$3$lambda$2 = MaterialPredictiveBackAnimatable._get_exitModifier_$lambda$3$lambda$2(MaterialPredictiveBackAnimatable.this, corners, (GraphicsLayerScope) obj);
                return _get_exitModifier_$lambda$3$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_exitModifier_$lambda$3$lambda$2(MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable, LayoutCorners layoutCorners, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        materialPredictiveBackAnimatable.setupExitGraphicLayer(graphicsLayer, LayoutCornersKt.toShape(layoutCorners, materialPredictiveBackAnimatable.getProgress()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_exitModifier_$lambda$4(MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        materialPredictiveBackAnimatable.setupExitGraphicLayer(graphicsLayer, materialPredictiveBackAnimatable.exitShape.invoke(Float.valueOf(materialPredictiveBackAnimatable.getProgress()), materialPredictiveBackAnimatable.getEdge()));
        return Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Modifier getEnterModifier() {
        return DrawModifierKt.drawWithContent(Modifier.Companion, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_enterModifier_$lambda$5;
                _get_enterModifier_$lambda$5 = MaterialPredictiveBackAnimatable._get_enterModifier_$lambda$5(MaterialPredictiveBackAnimatable.this, (ContentDrawScope) obj);
                return _get_enterModifier_$lambda$5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_enterModifier_$lambda$5(MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        DrawScope.m4634drawRectnJ9OG0$default(drawWithContent, Color.m4077copywmQWz5c$default(Color.Companion.m4104getBlack0d7_KjU(), materialPredictiveBackAnimatable.getFinishProgress() * 0.25f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        return Unit.INSTANCE;
    }

    private final void setupExitGraphicLayer(GraphicsLayerScope graphicsLayerScope, Shape shape) {
        float f;
        int i = WhenMappings.$EnumSwitchMapping$0[getEdge().ordinal()];
        float f2 = 0.0f;
        if (i == 1) {
            f = 1.0f;
        } else if (i == 2) {
            f = 0.0f;
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            f = 0.5f;
        }
        graphicsLayerScope.mo4271setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(f, 0.5f));
        float progress = 1.0f - (getProgress() / 10.0f);
        graphicsLayerScope.setScaleX(progress);
        graphicsLayerScope.setScaleY(progress);
        int i2 = WhenMappings.$EnumSwitchMapping$0[getEdge().ordinal()];
        if (i2 == 1) {
            f2 = -graphicsLayerScope.mo389toPx0680j_4(Dp.m6684constructorimpl(8));
        } else if (i2 == 2) {
            f2 = graphicsLayerScope.mo389toPx0680j_4(Dp.m6684constructorimpl(8));
        } else if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        graphicsLayerScope.setTranslationX(f2 * getProgress());
        graphicsLayerScope.setTranslationY(((Size.m3903getHeightimpl(graphicsLayerScope.mo4265getSizeNHjbRc()) / 20.0f) - graphicsLayerScope.mo389toPx0680j_4(Dp.m6684constructorimpl(8))) * ((getTouchY() - this.initialEvent.getTouchY()) / Size.m3903getHeightimpl(graphicsLayerScope.mo4265getSizeNHjbRc())) * RangesKt.coerceAtMost(getProgress() * 3.0f, 1.0f));
        graphicsLayerScope.setAlpha(getFinishProgress());
        graphicsLayerScope.setShape(shape);
        graphicsLayerScope.setClip(true);
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object animate(BackEvent backEvent, Continuation<? super Unit> continuation) {
        setEdge(backEvent.getSwipeEdge());
        setTouchY(backEvent.getTouchY());
        Object animateTo$default = Animatable.animateTo$default(this.progressAnimatable, Boxing.boxFloat(backEvent.getProgress()), null, null, null, continuation, 14, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object finish(Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new MaterialPredictiveBackAnimatable$finish$2(this, this.progressAnimatable.getValue().floatValue(), RangesKt.coerceAtMost(this.progressAnimatable.getVelocity().floatValue(), 1.0f) / 1.0f, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object cancel(Continuation<? super Unit> continuation) {
        Object animateTo$default = Animatable.animateTo$default(this.progressAnimatable, Boxing.boxFloat(0.0f), null, null, null, continuation, 14, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }
}
