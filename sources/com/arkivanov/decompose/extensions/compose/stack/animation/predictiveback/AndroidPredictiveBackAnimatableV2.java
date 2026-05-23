package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.util.MathHelpersKt;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: AndroidPredictiveBackAnimatableV2.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00128\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u00128\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010,\u001a\u00020)*\u00020)2\u0006\u0010.\u001a\u00020\fH\u0003¢\u0006\u0002\u0010/J\u0019\u0010(\u001a\u00020)*\u00020)2\u0006\u0010.\u001a\u00020\fH\u0003¢\u0006\u0002\u0010/J\u0014\u00100\u001a\u00020\u0006*\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\b\u00103\u001a\u00020\u0006H\u0002J\b\u00104\u001a\u00020\u0006H\u0002J\u0014\u00105\u001a\u00020\u0006*\u0002012\u0006\u00106\u001a\u00020\u0006H\u0002J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u000208H\u0096@¢\u0006\u0002\u0010<J\u000e\u0010=\u001a\u000208H\u0096@¢\u0006\u0002\u0010<R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0019\u0010\u0015R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR+\u0010\"\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010+¨\u0006>²\u0006\n\u0010?\u001a\u00020@X\u008a\u008e\u0002²\u0006\n\u0010?\u001a\u00020@X\u008a\u008e\u0002"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/AndroidPredictiveBackAnimatableV2;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "exitShape", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/graphics/Shape;", "enterShape", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "finishProgressAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finishProgress", "getFinishProgress", "()F", "finishProgress$delegate", "Landroidx/compose/runtime/State;", "progressAnimatable", "getProgress", "progress$delegate", "<set-?>", "getEdge", "()Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "setEdge", "(Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;)V", "edge$delegate", "Landroidx/compose/runtime/MutableState;", "touchY", "getTouchY", "setTouchY", "(F)V", "touchY$delegate", "Landroidx/compose/runtime/MutableFloatState;", "exitModifier", "Landroidx/compose/ui/Modifier;", "getExitModifier", "()Landroidx/compose/ui/Modifier;", "enterModifier", "getEnterModifier", "shape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "exitOffsetX", "Landroidx/compose/ui/unit/Density;", "width", "initialScaleFactor", "scaleFactor", "exitOffsetY", "height", "animate", "", NotificationCompat.CATEGORY_EVENT, "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "extensions-compose_release", "size", "Landroidx/compose/ui/geometry/Size;"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidPredictiveBackAnimatableV2 implements PredictiveBackAnimatable {
    public static final int $stable = 8;
    private final MutableState edge$delegate;
    private final Function2<Float, BackEvent.SwipeEdge, Shape> enterShape;
    private final Function2<Float, BackEvent.SwipeEdge, Shape> exitShape;
    private final State finishProgress$delegate;
    private final Animatable<Float, AnimationVector1D> finishProgressAnimatable;
    private final BackEvent initialEvent;
    private final State progress$delegate;
    private final Animatable<Float, AnimationVector1D> progressAnimatable;
    private final MutableFloatState touchY$delegate;

    /* compiled from: AndroidPredictiveBackAnimatableV2.kt */
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
    public AndroidPredictiveBackAnimatableV2(BackEvent initialEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function22) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(initialEvent, "initialEvent");
        this.initialEvent = initialEvent;
        this.exitShape = function2;
        this.enterShape = function22;
        this.finishProgressAnimatable = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float floatValue;
                floatValue = AndroidPredictiveBackAnimatableV2.this.finishProgressAnimatable.getValue().floatValue();
                return Float.valueOf(floatValue);
            }
        });
        this.progressAnimatable = AnimatableKt.Animatable$default(initialEvent.getProgress(), 0.0f, 2, null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float floatValue;
                floatValue = AndroidPredictiveBackAnimatableV2.this.progressAnimatable.getValue().floatValue();
                return Float.valueOf(floatValue);
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialEvent.getSwipeEdge(), null, 2, null);
        this.edge$delegate = mutableStateOf$default;
        this.touchY$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(initialEvent.getTouchY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getFinishProgress() {
        return ((Number) this.finishProgress$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BackEvent.SwipeEdge getEdge() {
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
        return ComposedModifierKt.composed$default(Modifier.Companion, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$exitModifier$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Function2 function2;
                Function2 function22;
                float progress;
                BackEvent.SwipeEdge edge;
                Modifier exitModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceGroup(1719796187);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1719796187, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2.<get-exitModifier>.<anonymous> (AndroidPredictiveBackAnimatableV2.kt:41)");
                }
                function2 = AndroidPredictiveBackAnimatableV2.this.exitShape;
                if (function2 == null) {
                    composer.startReplaceGroup(-1580688493);
                    final AndroidPredictiveBackAnimatableV2 androidPredictiveBackAnimatableV2 = AndroidPredictiveBackAnimatableV2.this;
                    exitModifier = LayoutCorners_androidKt.withLayoutCorners(composed, new Function4<Modifier, LayoutCorners, Composer, Integer, Modifier>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$exitModifier$1.1
                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, LayoutCorners layoutCorners, Composer composer2, Integer num) {
                            return invoke(modifier, layoutCorners, composer2, num.intValue());
                        }

                        public final Modifier invoke(Modifier withLayoutCorners, LayoutCorners corners, Composer composer2, int i2) {
                            float progress2;
                            Modifier exitModifier2;
                            Intrinsics.checkNotNullParameter(withLayoutCorners, "$this$withLayoutCorners");
                            Intrinsics.checkNotNullParameter(corners, "corners");
                            composer2.startReplaceGroup(-1706695667);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1706695667, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2.<get-exitModifier>.<anonymous>.<anonymous> (AndroidPredictiveBackAnimatableV2.kt:43)");
                            }
                            AndroidPredictiveBackAnimatableV2 androidPredictiveBackAnimatableV22 = AndroidPredictiveBackAnimatableV2.this;
                            progress2 = androidPredictiveBackAnimatableV22.getProgress();
                            exitModifier2 = androidPredictiveBackAnimatableV22.exitModifier(withLayoutCorners, LayoutCornersKt.toShape(corners, progress2), composer2, i2 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceGroup();
                            return exitModifier2;
                        }
                    }, composer, i & 14);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1580529959);
                    AndroidPredictiveBackAnimatableV2 androidPredictiveBackAnimatableV22 = AndroidPredictiveBackAnimatableV2.this;
                    function22 = androidPredictiveBackAnimatableV22.exitShape;
                    progress = AndroidPredictiveBackAnimatableV2.this.getProgress();
                    Float valueOf = Float.valueOf(progress);
                    edge = AndroidPredictiveBackAnimatableV2.this.getEdge();
                    exitModifier = androidPredictiveBackAnimatableV22.exitModifier(composed, (Shape) function22.invoke(valueOf, edge), composer, i & 14);
                    composer.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return exitModifier;
            }
        }, 1, null);
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Modifier getEnterModifier() {
        return ComposedModifierKt.composed$default(DrawModifierKt.drawWithContent(Modifier.Companion, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AndroidPredictiveBackAnimatableV2._get_enterModifier_$lambda$2(AndroidPredictiveBackAnimatableV2.this, (ContentDrawScope) obj);
            }
        }), null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$enterModifier$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                float progress;
                float finishProgress;
                Function2 function2;
                Function2 function22;
                BackEvent.SwipeEdge edge;
                Modifier enterModifier;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceGroup(-293236831);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-293236831, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2.<get-enterModifier>.<anonymous> (AndroidPredictiveBackAnimatableV2.kt:58)");
                }
                progress = AndroidPredictiveBackAnimatableV2.this.getProgress();
                finishProgress = AndroidPredictiveBackAnimatableV2.this.getFinishProgress();
                final float lerp = MathHelpersKt.lerp(progress, 0.0f, finishProgress);
                function2 = AndroidPredictiveBackAnimatableV2.this.enterShape;
                if (function2 == null) {
                    composer.startReplaceGroup(763110573);
                    final AndroidPredictiveBackAnimatableV2 androidPredictiveBackAnimatableV2 = AndroidPredictiveBackAnimatableV2.this;
                    enterModifier = LayoutCorners_androidKt.withLayoutCorners(composed, new Function4<Modifier, LayoutCorners, Composer, Integer, Modifier>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$enterModifier$2.1
                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, LayoutCorners layoutCorners, Composer composer2, Integer num) {
                            return invoke(modifier, layoutCorners, composer2, num.intValue());
                        }

                        public final Modifier invoke(Modifier withLayoutCorners, LayoutCorners corners, Composer composer2, int i2) {
                            Modifier enterModifier2;
                            Intrinsics.checkNotNullParameter(withLayoutCorners, "$this$withLayoutCorners");
                            Intrinsics.checkNotNullParameter(corners, "corners");
                            composer2.startReplaceGroup(1088007507);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1088007507, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2.<get-enterModifier>.<anonymous>.<anonymous> (AndroidPredictiveBackAnimatableV2.kt:61)");
                            }
                            enterModifier2 = AndroidPredictiveBackAnimatableV2.this.enterModifier(withLayoutCorners, LayoutCornersKt.toShape(corners, lerp), composer2, i2 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceGroup();
                            return enterModifier2;
                        }
                    }, composer, i & 14);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(763290714);
                    AndroidPredictiveBackAnimatableV2 androidPredictiveBackAnimatableV22 = AndroidPredictiveBackAnimatableV2.this;
                    function22 = androidPredictiveBackAnimatableV22.enterShape;
                    Float valueOf = Float.valueOf(lerp);
                    edge = AndroidPredictiveBackAnimatableV2.this.getEdge();
                    enterModifier = androidPredictiveBackAnimatableV22.enterModifier(composed, (Shape) function22.invoke(valueOf, edge), composer, i & 14);
                    composer.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return enterModifier;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _get_enterModifier_$lambda$2(AndroidPredictiveBackAnimatableV2 androidPredictiveBackAnimatableV2, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        DrawScope.m5916drawRectnJ9OG0$default(drawWithContent, Color.m5347copywmQWz5c$default(Color.Companion.m5374getBlack0d7_KjU(), (1.0f - androidPredictiveBackAnimatableV2.getFinishProgress()) * 0.25f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier enterModifier(Modifier modifier, Shape shape, Composer composer, int i) {
        composer.startReplaceGroup(1721348405);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1721348405, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2.enterModifier (AndroidPredictiveBackAnimatableV2.kt:69)");
        }
        composer.startReplaceGroup(44641111);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m5160boximpl(Size.Companion.m5181getZeroNHjbRc()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        float scaleFactor = scaleFactor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        composer.startReplaceGroup(44646380);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AndroidPredictiveBackAnimatableV2.enterModifier$lambda$7$lambda$6(MutableState.this, (LayoutCoordinates) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier m5513graphicsLayer_6ThJ44$default = GraphicsLayerModifierKt.m5513graphicsLayer_6ThJ44$default(OnPlacedModifierKt.onPlaced(modifier, (Function1) rememberedValue2), scaleFactor, scaleFactor, 0.0f, MathHelpersKt.lerp((-Float.intBitsToFloat((int) (enterModifier$lambda$4(mutableState) >> 32))) * 0.2f, 0.0f, getFinishProgress()), exitOffsetY(density, Float.intBitsToFloat((int) (enterModifier$lambda$4(mutableState) & 4294967295L))), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape, true, null, 0L, 0L, CompositingStrategy.Companion.m5439getOffscreenNrFUSI(), 0, null, 452580, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m5513graphicsLayer_6ThJ44$default;
    }

    private static final long enterModifier$lambda$4(MutableState<Size> mutableState) {
        return mutableState.getValue().m5177unboximpl();
    }

    private static final void enterModifier$lambda$5(MutableState<Size> mutableState, long j) {
        mutableState.setValue(Size.m5160boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit enterModifier$lambda$7$lambda$6(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        enterModifier$lambda$5(mutableState, IntSizeKt.m8343toSizeozmzZPI(it.mo6826getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier exitModifier(Modifier modifier, Shape shape, Composer composer, int i) {
        composer.startReplaceGroup(-13183107);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-13183107, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2.exitModifier (AndroidPredictiveBackAnimatableV2.kt:88)");
        }
        composer.startReplaceGroup(-1244383815);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m5160boximpl(Size.Companion.m5181getZeroNHjbRc()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        float scaleFactor = scaleFactor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        composer.startReplaceGroup(-1244378546);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AndroidPredictiveBackAnimatableV2.exitModifier$lambda$12$lambda$11(MutableState.this, (LayoutCoordinates) obj);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier m5513graphicsLayer_6ThJ44$default = GraphicsLayerModifierKt.m5513graphicsLayer_6ThJ44$default(OnPlacedModifierKt.onPlaced(modifier, (Function1) rememberedValue2), scaleFactor, scaleFactor, 1.0f - getFinishProgress(), exitOffsetX(density, Float.intBitsToFloat((int) (exitModifier$lambda$9(mutableState) >> 32))), exitOffsetY(density, Float.intBitsToFloat((int) (exitModifier$lambda$9(mutableState) & 4294967295L))), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape, true, null, 0L, 0L, CompositingStrategy.Companion.m5439getOffscreenNrFUSI(), 0, null, 452576, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m5513graphicsLayer_6ThJ44$default;
    }

    private static final void exitModifier$lambda$10(MutableState<Size> mutableState, long j) {
        mutableState.setValue(Size.m5160boximpl(j));
    }

    private static final long exitModifier$lambda$9(MutableState<Size> mutableState) {
        return mutableState.getValue().m5177unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit exitModifier$lambda$12$lambda$11(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        exitModifier$lambda$10(mutableState, IntSizeKt.m8343toSizeozmzZPI(it.mo6826getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    private final float exitOffsetX(Density density, float f) {
        float f2 = 0.0f;
        if (f == 0.0f) {
            return 0.0f;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[getEdge().ordinal()];
        if (i == 1) {
            f2 = ((f - (initialScaleFactor() * f)) / 2.0f) - (density.mo434toPx0680j_4(Dp.m8160constructorimpl(8.0f)) * getProgress());
        } else if (i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return MathHelpersKt.lerp(f2, f * 0.2f, getFinishProgress());
    }

    private final float initialScaleFactor() {
        return MathHelpersKt.lerp(1.0f, 0.9f, getProgress());
    }

    private final float scaleFactor() {
        return MathHelpersKt.lerp(initialScaleFactor(), 1.0f, getFinishProgress());
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
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AndroidPredictiveBackAnimatableV2$finish$2(this, this.progressAnimatable.getValue().floatValue(), RangesKt.coerceAtMost(this.progressAnimatable.getVelocity().floatValue(), 1.0f) / 1.0f, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
    public Object cancel(Continuation<? super Unit> continuation) {
        Object animateTo$default = Animatable.animateTo$default(this.progressAnimatable, Boxing.boxFloat(0.0f), null, null, null, continuation, 14, null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    private final float exitOffsetY(Density density, float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        return MathHelpersKt.lerp(((f / 20.0f) - density.mo434toPx0680j_4(Dp.m8160constructorimpl(8.0f))) * ((getTouchY() - this.initialEvent.getTouchY()) / f) * RangesKt.coerceAtMost(getProgress() * 3.0f, 1.0f), 0.0f, getFinishProgress());
    }
}
