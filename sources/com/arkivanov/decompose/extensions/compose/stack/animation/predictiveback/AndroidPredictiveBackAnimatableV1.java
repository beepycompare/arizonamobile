package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.MathHelpersKt;
import com.arkivanov.essenty.backhandler.BackEvent;
import com.facebook.widget.FacebookDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: AndroidPredictiveBackAnimatableV1.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0001\u0018\u0000 >2\u00020\u0001:\u0001>B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012:\b\u0002\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005\u0012:\b\u0002\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJI\u0010'\u001a\u00020(*\u00020(26\u0010-\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005H\u0003¢\u0006\u0002\u0010.JI\u0010+\u001a\u00020(*\u00020(26\u0010-\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005H\u0003¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00102J\u000e\u00103\u001a\u000200H\u0096@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u000200H\u0096@¢\u0006\u0002\u00104Jd\u00106\u001a\u0002002T\u00107\u001a+\u0012'\b\u0001\u0012#\b\u0001\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u0002000:\u0012\u0006\u0012\u0004\u0018\u00010;0\u0005¢\u0006\u0002\b<08\"#\b\u0001\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u0002000:\u0012\u0006\u0012\u0004\u0018\u00010;0\u0005¢\u0006\u0002\b<H\u0082@¢\u0006\u0002\u0010=J\f\u0010\u0013\u001a\u00020\u0006*\u00020\u0006H\u0002J\f\u0010\u0019\u001a\u00020\u0006*\u00020\u0006H\u0002R@\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\r\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u0015R+\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*¨\u0006?²\u0006\n\u0010@\u001a\u00020AX\u008a\u008e\u0002²\u0006\n\u0010@\u001a\u00020AX\u008a\u008e\u0002"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/AndroidPredictiveBackAnimatableV1;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "initialEvent", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "exitShape", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "edge", "Landroidx/compose/ui/graphics/Shape;", "enterShape", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "exitProgressAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "exitProgress", "getExitProgress", "()F", "exitProgress$delegate", "Landroidx/compose/runtime/State;", "enterProgressAnimatable", "enterProgress", "getEnterProgress", "enterProgress$delegate", "finishProgressAnimatable", "finishProgress", "getFinishProgress", "finishProgress$delegate", "<set-?>", "getEdge", "()Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;", "setEdge", "(Lcom/arkivanov/essenty/backhandler/BackEvent$SwipeEdge;)V", "edge$delegate", "Landroidx/compose/runtime/MutableState;", "exitModifier", "Landroidx/compose/ui/Modifier;", "getExitModifier", "()Landroidx/compose/ui/Modifier;", "enterModifier", "getEnterModifier", "layoutShape", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "animate", "", "event", "(Lcom/arkivanov/essenty/backhandler/BackEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", FacebookDialog.COMPLETION_GESTURE_CANCEL, "awaitAll", "actions", "", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "([Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "extensions-compose_release", "size", "Landroidx/compose/ui/unit/IntSize;"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidPredictiveBackAnimatableV1 implements PredictiveBackAnimatable {
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
    private static final Companion Companion = new Companion(null);
    public static final int $stable = (Animatable.$stable | Animatable.$stable) | Animatable.$stable;

    /* JADX INFO: Access modifiers changed from: private */
    public final float exitProgress(float f) {
        if (f < PROGRESS_THRESHOLD) {
            return f;
        }
        return 1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidPredictiveBackAnimatableV1(BackEvent initialEvent, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function22) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(initialEvent, "initialEvent");
        this.exitShape = function2;
        this.enterShape = function22;
        this.exitProgressAnimatable = AnimatableKt.Animatable$default(exitProgress(initialEvent.getProgress()), 0.0f, 2, null);
        this.exitProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float floatValue;
                floatValue = AndroidPredictiveBackAnimatableV1.this.exitProgressAnimatable.getValue().floatValue();
                return Float.valueOf(floatValue);
            }
        });
        this.enterProgressAnimatable = AnimatableKt.Animatable$default(enterProgress(initialEvent.getProgress()), 0.0f, 2, null);
        this.enterProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float floatValue;
                floatValue = AndroidPredictiveBackAnimatableV1.this.enterProgressAnimatable.getValue().floatValue();
                return Float.valueOf(floatValue);
            }
        });
        this.finishProgressAnimatable = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.finishProgress$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float floatValue;
                floatValue = AndroidPredictiveBackAnimatableV1.this.finishProgressAnimatable.getValue().floatValue();
                return Float.valueOf(floatValue);
            }
        });
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialEvent.getSwipeEdge(), null, 2, null);
        this.edge$delegate = mutableStateOf$default;
    }

    public /* synthetic */ AndroidPredictiveBackAnimatableV1(BackEvent backEvent, Function2 function2, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backEvent, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function22);
    }

    private final float getExitProgress() {
        return ((Number) this.exitProgress$delegate.getValue()).floatValue();
    }

    private final float getEnterProgress() {
        return ((Number) this.enterProgress$delegate.getValue()).floatValue();
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
        return ComposedModifierKt.composed$default(Modifier.Companion, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$exitModifier$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: AndroidPredictiveBackAnimatableV1.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$exitModifier$1$1  reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 implements Function4<Modifier, LayoutCorners, Composer, Integer, Modifier> {
                final /* synthetic */ AndroidPredictiveBackAnimatableV1 this$0;

                AnonymousClass1(AndroidPredictiveBackAnimatableV1 androidPredictiveBackAnimatableV1) {
                    this.this$0 = androidPredictiveBackAnimatableV1;
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, LayoutCorners layoutCorners, Composer composer, Integer num) {
                    return invoke(modifier, layoutCorners, composer, num.intValue());
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                public static final Shape invoke$lambda$1$lambda$0(LayoutCorners layoutCorners, float f, BackEvent.SwipeEdge swipeEdge) {
                    Intrinsics.checkNotNullParameter(swipeEdge, "<unused var>");
                    return LayoutCornersKt.toShape(layoutCorners, f);
                }

                public final Modifier invoke(Modifier withLayoutCorners, final LayoutCorners corners, Composer composer, int i) {
                    Modifier exitModifier;
                    Intrinsics.checkNotNullParameter(withLayoutCorners, "$this$withLayoutCorners");
                    Intrinsics.checkNotNullParameter(corners, "corners");
                    composer.startReplaceGroup(196734637);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(196734637, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.<get-exitModifier>.<anonymous>.<anonymous> (AndroidPredictiveBackAnimatableV1.kt:45)");
                    }
                    AndroidPredictiveBackAnimatableV1 androidPredictiveBackAnimatableV1 = this.this$0;
                    composer.startReplaceGroup(224505919);
                    boolean z = (((i & 112) ^ 48) > 32 && composer.changed(corners)) || (i & 48) == 32;
                    Object rememberedValue = composer.rememberedValue();
                    if (z || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: CONSTRUCTOR  (r1v3 'rememberedValue' java.lang.Object) = (r5v0 'corners' com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners A[DONT_INLINE]) call: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$exitModifier$1$1$$ExternalSyntheticLambda0.<init>(com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners):void type: CONSTRUCTOR in method: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$exitModifier$1.1.invoke(androidx.compose.ui.Modifier, com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$exitModifier$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                            	... 21 more
                            */
                        /*
                            this = this;
                            java.lang.String r0 = "$this$withLayoutCorners"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                            java.lang.String r0 = "corners"
                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                            r0 = 196734637(0xbb9eead, float:7.161853E-32)
                            r6.startReplaceGroup(r0)
                            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                            if (r1 == 0) goto L1c
                            r1 = -1
                            java.lang.String r2 = "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.<get-exitModifier>.<anonymous>.<anonymous> (AndroidPredictiveBackAnimatableV1.kt:45)"
                            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r1, r2)
                        L1c:
                            com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1 r3 = r3.this$0
                            r0 = 224505919(0xd61b03f, float:6.9545627E-31)
                            r6.startReplaceGroup(r0)
                            r0 = r7 & 112(0x70, float:1.57E-43)
                            r0 = r0 ^ 48
                            r1 = 32
                            if (r0 <= r1) goto L32
                            boolean r0 = r6.changed(r5)
                            if (r0 != 0) goto L36
                        L32:
                            r0 = r7 & 48
                            if (r0 != r1) goto L38
                        L36:
                            r0 = 1
                            goto L39
                        L38:
                            r0 = 0
                        L39:
                            java.lang.Object r1 = r6.rememberedValue()
                            if (r0 != 0) goto L47
                            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
                            java.lang.Object r0 = r0.getEmpty()
                            if (r1 != r0) goto L4f
                        L47:
                            com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$exitModifier$1$1$$ExternalSyntheticLambda0 r1 = new com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$exitModifier$1$1$$ExternalSyntheticLambda0
                            r1.<init>(r5)
                            r6.updateRememberedValue(r1)
                        L4f:
                            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                            r6.endReplaceGroup()
                            r5 = r7 & 14
                            int r7 = androidx.compose.animation.core.Animatable.$stable
                            int r0 = androidx.compose.animation.core.Animatable.$stable
                            r7 = r7 | r0
                            int r0 = androidx.compose.animation.core.Animatable.$stable
                            r7 = r7 | r0
                            int r7 = r7 << 6
                            r5 = r5 | r7
                            androidx.compose.ui.Modifier r3 = com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.access$exitModifier(r3, r4, r1, r6, r5)
                            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                            if (r4 == 0) goto L6e
                            androidx.compose.runtime.ComposerKt.traceEventEnd()
                        L6e:
                            r6.endReplaceGroup()
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$exitModifier$1.AnonymousClass1.invoke(androidx.compose.ui.Modifier, com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
                    }
                }

                public final Modifier invoke(Modifier composed, Composer composer, int i) {
                    Function2 function2;
                    Function2 function22;
                    Modifier exitModifier;
                    Intrinsics.checkNotNullParameter(composed, "$this$composed");
                    composer.startReplaceGroup(-671740805);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-671740805, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.<get-exitModifier>.<anonymous> (AndroidPredictiveBackAnimatableV1.kt:43)");
                    }
                    function2 = AndroidPredictiveBackAnimatableV1.this.exitShape;
                    if (function2 == null) {
                        composer.startReplaceGroup(988982976);
                        exitModifier = LayoutCorners_androidKt.withLayoutCorners(composed, new AnonymousClass1(AndroidPredictiveBackAnimatableV1.this), composer, i & 14);
                        composer.endReplaceGroup();
                    } else {
                        composer.startReplaceGroup(989158095);
                        AndroidPredictiveBackAnimatableV1 androidPredictiveBackAnimatableV1 = AndroidPredictiveBackAnimatableV1.this;
                        function22 = androidPredictiveBackAnimatableV1.exitShape;
                        exitModifier = androidPredictiveBackAnimatableV1.exitModifier(composed, function22, composer, (i & 14) | (((Animatable.$stable | Animatable.$stable) | Animatable.$stable) << 6));
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
            return ComposedModifierKt.composed$default(Modifier.Companion, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$enterModifier$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                    return invoke(modifier, composer, num.intValue());
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: AndroidPredictiveBackAnimatableV1.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$enterModifier$1$1  reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 implements Function4<Modifier, LayoutCorners, Composer, Integer, Modifier> {
                    final /* synthetic */ AndroidPredictiveBackAnimatableV1 this$0;

                    AnonymousClass1(AndroidPredictiveBackAnimatableV1 androidPredictiveBackAnimatableV1) {
                        this.this$0 = androidPredictiveBackAnimatableV1;
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, LayoutCorners layoutCorners, Composer composer, Integer num) {
                        return invoke(modifier, layoutCorners, composer, num.intValue());
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    public static final Shape invoke$lambda$1$lambda$0(LayoutCorners layoutCorners, float f, BackEvent.SwipeEdge swipeEdge) {
                        Intrinsics.checkNotNullParameter(swipeEdge, "<unused var>");
                        return LayoutCornersKt.toShape(layoutCorners, f);
                    }

                    public final Modifier invoke(Modifier withLayoutCorners, final LayoutCorners corners, Composer composer, int i) {
                        Modifier enterModifier;
                        Intrinsics.checkNotNullParameter(withLayoutCorners, "$this$withLayoutCorners");
                        Intrinsics.checkNotNullParameter(corners, "corners");
                        composer.startReplaceGroup(-1303529485);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1303529485, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.<get-enterModifier>.<anonymous>.<anonymous> (AndroidPredictiveBackAnimatableV1.kt:57)");
                        }
                        AndroidPredictiveBackAnimatableV1 androidPredictiveBackAnimatableV1 = this.this$0;
                        composer.startReplaceGroup(1524532429);
                        boolean z = (((i & 112) ^ 48) > 32 && composer.changed(corners)) || (i & 48) == 32;
                        Object rememberedValue = composer.rememberedValue();
                        if (z || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0049: CONSTRUCTOR  (r1v3 'rememberedValue' java.lang.Object) = (r5v0 'corners' com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners A[DONT_INLINE]) call: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$enterModifier$1$1$$ExternalSyntheticLambda0.<init>(com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners):void type: CONSTRUCTOR in method: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$enterModifier$1.1.invoke(androidx.compose.ui.Modifier, com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier, file: classes3.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$enterModifier$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                	... 21 more
                                */
                            /*
                                this = this;
                                java.lang.String r0 = "$this$withLayoutCorners"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                                java.lang.String r0 = "corners"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                                r0 = -1303529485(0xffffffffb24db7f3, float:-1.1974396E-8)
                                r6.startReplaceGroup(r0)
                                boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r1 == 0) goto L1c
                                r1 = -1
                                java.lang.String r2 = "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.<get-enterModifier>.<anonymous>.<anonymous> (AndroidPredictiveBackAnimatableV1.kt:57)"
                                androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r1, r2)
                            L1c:
                                com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1 r3 = r3.this$0
                                r0 = 1524532429(0x5ade84cd, float:3.13167304E16)
                                r6.startReplaceGroup(r0)
                                r0 = r7 & 112(0x70, float:1.57E-43)
                                r0 = r0 ^ 48
                                r1 = 32
                                if (r0 <= r1) goto L32
                                boolean r0 = r6.changed(r5)
                                if (r0 != 0) goto L36
                            L32:
                                r0 = r7 & 48
                                if (r0 != r1) goto L38
                            L36:
                                r0 = 1
                                goto L39
                            L38:
                                r0 = 0
                            L39:
                                java.lang.Object r1 = r6.rememberedValue()
                                if (r0 != 0) goto L47
                                androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
                                java.lang.Object r0 = r0.getEmpty()
                                if (r1 != r0) goto L4f
                            L47:
                                com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$enterModifier$1$1$$ExternalSyntheticLambda0 r1 = new com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$enterModifier$1$1$$ExternalSyntheticLambda0
                                r1.<init>(r5)
                                r6.updateRememberedValue(r1)
                            L4f:
                                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                                r6.endReplaceGroup()
                                r5 = r7 & 14
                                int r7 = androidx.compose.animation.core.Animatable.$stable
                                int r0 = androidx.compose.animation.core.Animatable.$stable
                                r7 = r7 | r0
                                int r0 = androidx.compose.animation.core.Animatable.$stable
                                r7 = r7 | r0
                                int r7 = r7 << 6
                                r5 = r5 | r7
                                androidx.compose.ui.Modifier r3 = com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.access$enterModifier(r3, r4, r1, r6, r5)
                                boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r4 == 0) goto L6e
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            L6e:
                                r6.endReplaceGroup()
                                return r3
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$enterModifier$1.AnonymousClass1.invoke(androidx.compose.ui.Modifier, com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.LayoutCorners, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
                        }
                    }

                    public final Modifier invoke(Modifier composed, Composer composer, int i) {
                        Function2 function2;
                        Function2 function22;
                        Modifier enterModifier;
                        Intrinsics.checkNotNullParameter(composed, "$this$composed");
                        composer.startReplaceGroup(1610193473);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1610193473, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.<get-enterModifier>.<anonymous> (AndroidPredictiveBackAnimatableV1.kt:55)");
                        }
                        function2 = AndroidPredictiveBackAnimatableV1.this.enterShape;
                        if (function2 == null) {
                            composer.startReplaceGroup(-1187310799);
                            enterModifier = LayoutCorners_androidKt.withLayoutCorners(composed, new AnonymousClass1(AndroidPredictiveBackAnimatableV1.this), composer, i & 14);
                            composer.endReplaceGroup();
                        } else {
                            composer.startReplaceGroup(-1187134657);
                            AndroidPredictiveBackAnimatableV1 androidPredictiveBackAnimatableV1 = AndroidPredictiveBackAnimatableV1.this;
                            function22 = androidPredictiveBackAnimatableV1.enterShape;
                            enterModifier = androidPredictiveBackAnimatableV1.enterModifier(composed, function22, composer, (i & 14) | (((Animatable.$stable | Animatable.$stable) | Animatable.$stable) << 6));
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

            /* JADX INFO: Access modifiers changed from: private */
            public final Modifier exitModifier(Modifier modifier, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2, Composer composer, int i) {
                composer.startReplaceGroup(1234344324);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1234344324, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.exitModifier (AndroidPredictiveBackAnimatableV1.kt:65)");
                }
                composer.startReplaceGroup(-733879619);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8323boximpl(IntSize.Companion.m8336getZeroYbymL2g()), null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                composer.endReplaceGroup();
                float exitProgress = 1.0f - (getExitProgress() * 0.1f);
                composer.startReplaceGroup(-733875290);
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidPredictiveBackAnimatableV1.exitModifier$lambda$7$lambda$6(MutableState.this, (LayoutCoordinates) obj);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier m5513graphicsLayer_6ThJ44$default = GraphicsLayerModifierKt.m5513graphicsLayer_6ThJ44$default(OnPlacedModifierKt.onPlaced(modifier, (Function1) rememberedValue2), exitProgress, exitProgress, 1.0f - getExitProgress(), ((int) (exitModifier$lambda$4(mutableState) >> 32)) * 0.5f * getExitProgress(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, function2.invoke(Float.valueOf(getExitProgress()), getEdge()), true, null, 0L, 0L, CompositingStrategy.Companion.m5439getOffscreenNrFUSI(), 0, null, 452592, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m5513graphicsLayer_6ThJ44$default;
            }

            private static final long exitModifier$lambda$4(MutableState<IntSize> mutableState) {
                return mutableState.getValue().m8335unboximpl();
            }

            private static final void exitModifier$lambda$5(MutableState<IntSize> mutableState, long j) {
                mutableState.setValue(IntSize.m8323boximpl(j));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static final Unit exitModifier$lambda$7$lambda$6(MutableState mutableState, LayoutCoordinates it) {
                Intrinsics.checkNotNullParameter(it, "it");
                exitModifier$lambda$5(mutableState, it.mo6826getSizeYbymL2g());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Modifier enterModifier(Modifier modifier, Function2<? super Float, ? super BackEvent.SwipeEdge, ? extends Shape> function2, Composer composer, int i) {
                composer.startReplaceGroup(738318140);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(738318140, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1.enterModifier (AndroidPredictiveBackAnimatableV1.kt:83)");
                }
                float lerp = MathHelpersKt.lerp(getEnterProgress(), 1.0f, getFinishProgress());
                composer.startReplaceGroup(-1308646823);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m8323boximpl(IntSize.Companion.m8336getZeroYbymL2g()), null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                composer.endReplaceGroup();
                float lerp2 = MathHelpersKt.lerp(MathHelpersKt.lerp(0.95f, 0.9f, getEnterProgress()), 1.0f, getFinishProgress());
                composer.startReplaceGroup(-1308639710);
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.AndroidPredictiveBackAnimatableV1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidPredictiveBackAnimatableV1.enterModifier$lambda$12$lambda$11(MutableState.this, (LayoutCoordinates) obj);
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceGroup();
                Modifier m5513graphicsLayer_6ThJ44$default = GraphicsLayerModifierKt.m5513graphicsLayer_6ThJ44$default(OnPlacedModifierKt.onPlaced(modifier, (Function1) rememberedValue2), lerp2, lerp2, lerp, MathHelpersKt.lerp((-((int) (enterModifier$lambda$9(mutableState) >> 32))) * 0.15f, 0.0f, lerp), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, function2.invoke(Float.valueOf(MathHelpersKt.lerp(getEnterProgress(), 0.0f, getFinishProgress())), getEdge()), true, null, 0L, 0L, CompositingStrategy.Companion.m5439getOffscreenNrFUSI(), 0, null, 452592, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return m5513graphicsLayer_6ThJ44$default;
            }

            private static final void enterModifier$lambda$10(MutableState<IntSize> mutableState, long j) {
                mutableState.setValue(IntSize.m8323boximpl(j));
            }

            private static final long enterModifier$lambda$9(MutableState<IntSize> mutableState) {
                return mutableState.getValue().m8335unboximpl();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static final Unit enterModifier$lambda$12$lambda$11(MutableState mutableState, LayoutCoordinates it) {
                Intrinsics.checkNotNullParameter(it, "it");
                enterModifier$lambda$10(mutableState, it.mo6826getSizeYbymL2g());
                return Unit.INSTANCE;
            }

            @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
            public Object animate(BackEvent backEvent, Continuation<? super Unit> continuation) {
                setEdge(backEvent.getSwipeEdge());
                Object awaitAll = awaitAll(new Function2[]{new AndroidPredictiveBackAnimatableV1$animate$2(this, backEvent, null), new AndroidPredictiveBackAnimatableV1$animate$3(this, backEvent, null)}, continuation);
                return awaitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitAll : Unit.INSTANCE;
            }

            @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
            public Object finish(Continuation<? super Unit> continuation) {
                Object awaitAll = awaitAll(new Function2[]{new AndroidPredictiveBackAnimatableV1$finish$2(this, null), new AndroidPredictiveBackAnimatableV1$finish$3(this, null)}, continuation);
                return awaitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitAll : Unit.INSTANCE;
            }

            @Override // com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimatable
            public Object cancel(Continuation<? super Unit> continuation) {
                Object awaitAll = awaitAll(new Function2[]{new AndroidPredictiveBackAnimatableV1$cancel$2(this, null), new AndroidPredictiveBackAnimatableV1$cancel$3(this, null)}, continuation);
                return awaitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitAll : Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Object awaitAll(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>[] function2Arr, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new AndroidPredictiveBackAnimatableV1$awaitAll$2(function2Arr, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final float enterProgress(float f) {
                if (f < PROGRESS_THRESHOLD) {
                    return 0.0f;
                }
                return MathHelpersKt.lerp(0.4f, 1.0f, (f - PROGRESS_THRESHOLD) / 0.95f);
            }

            /* compiled from: AndroidPredictiveBackAnimatableV1.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/AndroidPredictiveBackAnimatableV1$Companion;", "", "<init>", "()V", "PROGRESS_THRESHOLD", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes3.dex */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }
