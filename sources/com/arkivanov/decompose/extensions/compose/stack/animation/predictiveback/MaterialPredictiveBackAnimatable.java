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
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaterialPredictiveBackAnimatable.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0003\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010'\u001a\u00020(*\u00020(2\u0006\u0010-\u001a\u00020\fH\u0003¢\u0006\u0002\u0010.J\u001c\u0010/\u001a\u00020\u0006*\u0002002\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J\u0014\u00103\u001a\u00020\u0006*\u0002002\u0006\u00104\u001a\u00020\u0006H\u0002J\u0016\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00108J\u000e\u00109\u001a\u000206H\u0096@¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u000206H\u0096@¢\u0006\u0002\u0010:R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0018\u0010\u0014R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR+\u0010!\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u0006<²\u0006\n\u0010=\u001a\u00020>X\u008a\u008e\u0002"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/MaterialPredictiveBackAnimatable;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "exitShape", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/jvm/functions/Function2;)V", "finishProgressAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "finishProgress", "getFinishProgress", "()F", "finishProgress$delegate", "Landroidx/compose/runtime/State;", "progressAnimatable", "getProgress", "progress$delegate", "<set-?>", "getEdge", "()Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "setEdge", "(Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;)V", "edge$delegate", "Landroidx/compose/runtime/MutableState;", "touchY", "getTouchY", "setTouchY", "(F)V", "touchY$delegate", "Landroidx/compose/runtime/MutableFloatState;", "exitModifier", "Landroidx/compose/ui/Modifier;", "getExitModifier", "()Landroidx/compose/ui/Modifier;", "enterModifier", "getEnterModifier", "shape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "exitOffsetX", "Landroidx/compose/ui/unit/Density;", "width", "scaleFactor", "exitOffsetY", "height", "animate", "", NotificationCompat.CATEGORY_EVENT, "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "extensions-compose_release", "size", "Landroidx/compose/ui/geometry/Size;"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        this.finishProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float finishProgress_delegate$lambda$0;
                finishProgress_delegate$lambda$0 = MaterialPredictiveBackAnimatable.finishProgress_delegate$lambda$0(MaterialPredictiveBackAnimatable.this);
                return Float.valueOf(finishProgress_delegate$lambda$0);
            }
        });
        this.progressAnimatable = AnimatableKt.Animatable$default(initialEvent.getProgress(), 0.0f, 2, null);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda2
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

    /* JADX INFO: Access modifiers changed from: private */
    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float progress_delegate$lambda$1(MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable) {
        return materialPredictiveBackAnimatable.progressAnimatable.getValue().floatValue();
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
        return ComposedModifierKt.composed$default(Modifier.Companion, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$exitModifier$1
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
                composer.startReplaceGroup(-1799646781);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1799646781, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable.<get-exitModifier>.<anonymous> (MaterialPredictiveBackAnimatable.kt:63)");
                }
                function2 = MaterialPredictiveBackAnimatable.this.exitShape;
                if (function2 == null) {
                    composer.startReplaceGroup(1694037005);
                    final MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable = MaterialPredictiveBackAnimatable.this;
                    exitModifier = LayoutCorners_androidKt.withLayoutCorners(composed, new Function4<Modifier, LayoutCorners, Composer, Integer, Modifier>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$exitModifier$1.1
                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, LayoutCorners layoutCorners, Composer composer2, Integer num) {
                            return invoke(modifier, layoutCorners, composer2, num.intValue());
                        }

                        public final Modifier invoke(Modifier withLayoutCorners, LayoutCorners corners, Composer composer2, int i2) {
                            float progress2;
                            Modifier exitModifier2;
                            Intrinsics.checkNotNullParameter(withLayoutCorners, "$this$withLayoutCorners");
                            Intrinsics.checkNotNullParameter(corners, "corners");
                            composer2.startReplaceGroup(873879669);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(873879669, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable.<get-exitModifier>.<anonymous>.<anonymous> (MaterialPredictiveBackAnimatable.kt:65)");
                            }
                            MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable2 = MaterialPredictiveBackAnimatable.this;
                            progress2 = materialPredictiveBackAnimatable2.getProgress();
                            exitModifier2 = materialPredictiveBackAnimatable2.exitModifier(withLayoutCorners, LayoutCornersKt.toShape(corners, progress2), composer2, i2 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceGroup();
                            return exitModifier2;
                        }
                    }, composer, i & 14);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(1694195539);
                    MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable2 = MaterialPredictiveBackAnimatable.this;
                    function22 = materialPredictiveBackAnimatable2.exitShape;
                    progress = MaterialPredictiveBackAnimatable.this.getProgress();
                    Float valueOf = Float.valueOf(progress);
                    edge = MaterialPredictiveBackAnimatable.this.getEdge();
                    exitModifier = materialPredictiveBackAnimatable2.exitModifier(composed, (Shape) function22.invoke(valueOf, edge), composer, i & 14);
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
        return DrawModifierKt.drawWithContent(Modifier.Companion, new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit _get_enterModifier_$lambda$2;
                _get_enterModifier_$lambda$2 = MaterialPredictiveBackAnimatable._get_enterModifier_$lambda$2(MaterialPredictiveBackAnimatable.this, (ContentDrawScope) obj);
                return _get_enterModifier_$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_enterModifier_$lambda$2(MaterialPredictiveBackAnimatable materialPredictiveBackAnimatable, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.drawContent();
        DrawScope.m5999drawRectnJ9OG0$default(drawWithContent, Color.m5423copywmQWz5c$default(Color.Companion.m5450getBlack0d7_KjU(), materialPredictiveBackAnimatable.getFinishProgress() * 0.25f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, WebSocketProtocol.PAYLOAD_SHORT, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier exitModifier(Modifier modifier, Shape shape, Composer composer, int i) {
        Modifier m5588graphicsLayerAp8cVGQ;
        composer.startReplaceGroup(1519216613);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1519216613, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable.exitModifier (MaterialPredictiveBackAnimatable.kt:80)");
        }
        composer.startReplaceGroup(75011103);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m5236boximpl(Size.Companion.m5257getZeroNHjbRc()), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        float progress = 1.0f - (getProgress() / 10.0f);
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        composer.startReplaceGroup(75016564);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.MaterialPredictiveBackAnimatable$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit exitModifier$lambda$7$lambda$6;
                    exitModifier$lambda$7$lambda$6 = MaterialPredictiveBackAnimatable.exitModifier$lambda$7$lambda$6(MutableState.this, (LayoutCoordinates) obj);
                    return exitModifier$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        m5588graphicsLayerAp8cVGQ = GraphicsLayerModifierKt.m5588graphicsLayerAp8cVGQ(OnPlacedModifierKt.onPlaced(modifier, (Function1) rememberedValue2), (r41 & 1) != 0 ? 1.0f : progress, (r41 & 2) != 0 ? 1.0f : progress, (r41 & 4) == 0 ? getFinishProgress() : 1.0f, (r41 & 8) != 0 ? 0.0f : exitOffsetX(density, Float.intBitsToFloat((int) (exitModifier$lambda$4(mutableState) >> 32)), progress), (r41 & 16) != 0 ? 0.0f : exitOffsetY(density, Float.intBitsToFloat((int) (exitModifier$lambda$4(mutableState) & 4294967295L))), (r41 & 32) != 0 ? 0.0f : 0.0f, (r41 & 64) != 0 ? 0.0f : 0.0f, (r41 & 128) != 0 ? 0.0f : 0.0f, (r41 & 256) == 0 ? 0.0f : 0.0f, (r41 & 512) != 0 ? 8.0f : 0.0f, (r41 & 1024) != 0 ? TransformOrigin.Companion.m5839getCenterSzJe1aQ() : 0L, (r41 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (r41 & 4096) != 0 ? false : true, (r41 & 8192) != 0 ? null : null, (r41 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (32768 & r41) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r41 & 65536) != 0 ? CompositingStrategy.Companion.m5515getAutoNrFUSI() : CompositingStrategy.Companion.m5517getOffscreenNrFUSI());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return m5588graphicsLayerAp8cVGQ;
    }

    private static final long exitModifier$lambda$4(MutableState<Size> mutableState) {
        return mutableState.getValue().m5253unboximpl();
    }

    private static final void exitModifier$lambda$5(MutableState<Size> mutableState, long j) {
        mutableState.setValue(Size.m5236boximpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit exitModifier$lambda$7$lambda$6(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        exitModifier$lambda$5(mutableState, IntSizeKt.m8441toSizeozmzZPI(it.mo6883getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    private final float exitOffsetX(Density density, float f, float f2) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f3 = f2 * f;
        int i = WhenMappings.$EnumSwitchMapping$0[getEdge().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return 0.0f;
                }
                throw new NoWhenBranchMatchedException();
            }
            return ((f3 - f) / 2.0f) + (density.mo464toPx0680j_4(Dp.m8258constructorimpl(8)) * getProgress());
        }
        return ((f - f3) / 2.0f) - (density.mo464toPx0680j_4(Dp.m8258constructorimpl(8)) * getProgress());
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

    private final float exitOffsetY(Density density, float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        return ((f / 20.0f) - density.mo464toPx0680j_4(Dp.m8258constructorimpl(8))) * ((getTouchY() - this.initialEvent.getTouchY()) / f) * RangesKt.coerceAtMost(getProgress() * 3.0f, 1.0f);
    }
}
