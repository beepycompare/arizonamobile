package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.Ref;
import com.arkivanov.decompose.extensions.compose.stack.animation.EmptyStackAnimationKt;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationProvider;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationProviderKt;
import com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation;
import com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlayKt;
import com.arkivanov.decompose.router.stack.ChildStack;
import com.arkivanov.essenty.backhandler.BackCallback;
import com.arkivanov.essenty.backhandler.BackEvent;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PredictiveBackAnimation.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0002)*B\u0089\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004\u0012T\u0010\b\u001aP\u0012\u0004\u0012\u00020\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0014\u0010\u0015J^\u0010\u0016\u001a\u00020\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a22\u0010\u001b\u001a.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001c¢\u0006\u0002\b\u001eH\u0097\u0002¢\u0006\u0002\u0010\u001fJ;\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0012H\u0003¢\u0006\u0002\u0010$J1\u0010%\u001a\u0002H\u0003\"\u0004\b\u0002\u0010\u00032\u0006\u0010&\u001a\u00020\u00022\u0014\u0010'\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0003\u0012\u0004\u0012\u0002H\u00030\u001cH\u0003¢\u0006\u0002\u0010(R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\\\u0010\b\u001aP\u0012\u0004\u0012\u00020\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimation;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "animation", "selector", "Lkotlin/Function3;", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "Lcom/arkivanov/decompose/Child$Created;", "Lkotlin/ParameterName;", "name", "exitChild", "enterChild", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "onBack", "Lkotlin/Function0;", "", "<init>", "(Lcom/arkivanov/essenty/backhandler/BackHandler;Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "invoke", "stack", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "child", "Landroidx/compose/runtime/Composable;", "(Lcom/arkivanov/decompose/router/stack/ChildStack;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "rememberHandler", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimation$Handler;", "isGestureEnabled", "", "(Lcom/arkivanov/decompose/router/stack/ChildStack;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimation$Handler;", "rememberWithLatest", "key", "supplier", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "Item", "Handler", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PredictiveBackAnimation<C, T> implements StackAnimation<C, T> {
    private final StackAnimation<C, T> animation;
    private final BackHandler backHandler;
    private final Function0<Unit> onBack;
    private final Function3<BackEvent, Child.Created<? extends C, ? extends T>, Child.Created<? extends C, ? extends T>, PredictiveBackAnimatable> selector;

    /* JADX WARN: Multi-variable type inference failed */
    public PredictiveBackAnimation(BackHandler backHandler, StackAnimation<C, T> stackAnimation, Function3<? super BackEvent, ? super Child.Created<? extends C, ? extends T>, ? super Child.Created<? extends C, ? extends T>, ? extends PredictiveBackAnimatable> selector, Function0<Unit> onBack) {
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        this.backHandler = backHandler;
        this.animation = stackAnimation;
        this.selector = selector;
        this.onBack = onBack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [androidx.compose.runtime.Composer] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r8v10 */
    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
    public void invoke(ChildStack<? extends C, ? extends T> stack, Modifier modifier, Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> content, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceGroup(-1723560852);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1723560852, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation.invoke (PredictiveBackAnimation.kt:68)");
        }
        composer.startReplaceGroup(-1742009438);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new HashSet();
            composer.updateRememberedValue(rememberedValue);
        }
        final HashSet hashSet = (HashSet) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1742006241);
        boolean changedInstance = composer.changedInstance(hashSet);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = PredictiveBackAnimation.invoke$lambda$2$lambda$1(hashSet);
                    return Boolean.valueOf(invoke$lambda$2$lambda$1);
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        final Handler<C, T> rememberHandler = rememberHandler(stack, (Function0) rememberedValue2, composer, (i & 14) | ((i >> 3) & 896));
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(StackAnimationProviderKt.getLocalStackAnimationProvider());
        ComposerKt.sourceInformationMarkerEnd(composer);
        StackAnimationProvider stackAnimationProvider = (StackAnimationProvider) consume;
        StackAnimation<C, T> stackAnimation = this.animation;
        composer.startReplaceGroup(-1742002581);
        if (stackAnimation == null) {
            composer.startReplaceGroup(-1742002178);
            boolean changed = composer.changed(stackAnimationProvider);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = stackAnimationProvider.provide();
                composer.updateRememberedValue(rememberedValue3);
            }
            stackAnimation = rememberedValue3;
            composer.endReplaceGroup();
        }
        composer.endReplaceGroup();
        if (stackAnimation == null) {
            stackAnimation = EmptyStackAnimationKt.emptyStackAnimation();
        }
        composer.startReplaceGroup(-1741997953);
        boolean z = (((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(content)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256;
        Object rememberedValue4 = composer.rememberedValue();
        if (z || rememberedValue4 == Composer.Companion.getEmpty()) {
            rememberedValue4 = MovableContentKt.movableContentOf((Function3) ComposableLambdaKt.composableLambdaInstance(-1090273764, true, new PredictiveBackAnimation$invoke$childContent$1$1(content, hashSet)));
            composer.updateRememberedValue(rememberedValue4);
        }
        Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> function3 = rememberedValue4;
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m3520constructorimpl = Updater.m3520constructorimpl(composer);
        Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceGroup(1687044724);
        Iterator<T> it = rememberHandler.getItems().iterator();
        while (it.hasNext()) {
            Item item = (Item) it.next();
            composer.startMovableGroup(-214773885, Integer.valueOf(item.getKey()));
            stackAnimation.invoke(item.getStack(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(item.getModifier().invoke()), function3, composer, 0);
            composer.endMovableGroup();
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(1687054654);
        if (rememberHandler.getItems().size() > 1) {
            InputConsumingOverlayKt.InputConsumingOverlay(boxScopeInstance.matchParentSize(Modifier.Companion), composer, 0);
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (!stack.getBackStack().isEmpty()) {
            composer.startReplaceGroup(-1741966206);
            boolean changedInstance2 = composer.changedInstance(this) | composer.changedInstance(rememberHandler);
            Object rememberedValue5 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult invoke$lambda$8$lambda$7;
                        invoke$lambda$8$lambda$7 = PredictiveBackAnimation.invoke$lambda$8$lambda$7(PredictiveBackAnimation.this, rememberHandler, (DisposableEffectScope) obj);
                        return invoke$lambda$8$lambda$7;
                    }
                };
                composer.updateRememberedValue(rememberedValue5);
            }
            composer.endReplaceGroup();
            EffectsKt.DisposableEffect(rememberHandler, (Function1) rememberedValue5, (Composer) composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$2$lambda$1(HashSet hashSet) {
        return hashSet.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult invoke$lambda$8$lambda$7(final PredictiveBackAnimation predictiveBackAnimation, final Handler handler, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        predictiveBackAnimation.backHandler.register(handler);
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$invoke$lambda$8$lambda$7$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                BackHandler backHandler;
                backHandler = PredictiveBackAnimation.this.backHandler;
                backHandler.unregister(handler);
            }
        };
    }

    private final Handler<C, T> rememberHandler(final ChildStack<? extends C, ? extends T> childStack, final Function0<Boolean> function0, Composer composer, int i) {
        composer.startReplaceGroup(-974149690);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-974149690, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation.rememberHandler (PredictiveBackAnimation.kt:114)");
        }
        composer.startMovableGroup(1762026581, childStack);
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, -954367824, "CC(remember):Effects.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endMovableGroup();
        composer.startReplaceGroup(1762029485);
        boolean changedInstance = composer.changedInstance(childStack) | composer.changedInstance(coroutineScope) | ((((i & 112) ^ 48) > 32 && composer.changed(function0)) || (i & 48) == 32) | composer.changedInstance(this);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    PredictiveBackAnimation.Handler rememberHandler$lambda$11$lambda$10;
                    rememberHandler$lambda$11$lambda$10 = PredictiveBackAnimation.rememberHandler$lambda$11$lambda$10(ChildStack.this, coroutineScope, function0, this, (PredictiveBackAnimation.Handler) obj);
                    return rememberHandler$lambda$11$lambda$10;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Handler<C, T> handler = (Handler) rememberWithLatest(childStack, (Function1) rememberedValue2, composer, i & 910);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler rememberHandler$lambda$11$lambda$10(ChildStack childStack, CoroutineScope coroutineScope, Function0 function0, PredictiveBackAnimation predictiveBackAnimation, Handler handler) {
        int i;
        List<Item<C, T>> items;
        if (handler == null || (items = handler.getItems()) == null) {
            i = 0;
        } else {
            Iterator<T> it = items.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            i = ((Item) it.next()).getKey();
            while (it.hasNext()) {
                int key = ((Item) it.next()).getKey();
                if (i < key) {
                    i = key;
                }
            }
        }
        return new Handler(childStack, coroutineScope, function0, i, predictiveBackAnimation.selector, predictiveBackAnimation.onBack);
    }

    private final <T> T rememberWithLatest(Object obj, Function1<? super T, ? extends T> function1, Composer composer, int i) {
        composer.startReplaceGroup(1428286776);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1428286776, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation.rememberWithLatest (PredictiveBackAnimation.kt:130)");
        }
        composer.startReplaceGroup(722344803);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Ref(null);
            composer.updateRememberedValue(rememberedValue);
        }
        Ref ref = (Ref) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(722346190);
        boolean changed = composer.changed(obj);
        T t = (T) composer.rememberedValue();
        if (changed || t == Composer.Companion.getEmpty()) {
            t = function1.invoke((Object) ref.getValue());
            composer.updateRememberedValue(t);
        }
        composer.endReplaceGroup();
        ref.setValue(t);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PredictiveBackAnimation.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\n\b\u0002\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0003\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002B3\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JE\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimation$Item;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "stack", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "key", "", "modifier", "Lkotlin/Function0;", "Landroidx/compose/ui/Modifier;", "<init>", "(Lcom/arkivanov/decompose/router/stack/ChildStack;ILkotlin/jvm/functions/Function0;)V", "getStack", "()Lcom/arkivanov/decompose/router/stack/ChildStack;", "getKey", "()I", "getModifier", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Item<C, T> {
        private final int key;
        private final Function0<Modifier> modifier;
        private final ChildStack<C, T> stack;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Item copy$default(Item item, ChildStack childStack, int i, Function0 function0, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                childStack = item.stack;
            }
            if ((i2 & 2) != 0) {
                i = item.key;
            }
            if ((i2 & 4) != 0) {
                function0 = item.modifier;
            }
            return item.copy(childStack, i, function0);
        }

        public final ChildStack<C, T> component1() {
            return this.stack;
        }

        public final int component2() {
            return this.key;
        }

        public final Function0<Modifier> component3() {
            return this.modifier;
        }

        public final Item<C, T> copy(ChildStack<? extends C, ? extends T> stack, int i, Function0<? extends Modifier> modifier) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            return new Item<>(stack, i, modifier);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Item) {
                Item item = (Item) obj;
                return Intrinsics.areEqual(this.stack, item.stack) && this.key == item.key && Intrinsics.areEqual(this.modifier, item.modifier);
            }
            return false;
        }

        public int hashCode() {
            return (((this.stack.hashCode() * 31) + Integer.hashCode(this.key)) * 31) + this.modifier.hashCode();
        }

        public String toString() {
            return "Item(stack=" + this.stack + ", key=" + this.key + ", modifier=" + this.modifier + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Item(ChildStack<? extends C, ? extends T> stack, int i, Function0<? extends Modifier> modifier) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            this.stack = stack;
            this.key = i;
            this.modifier = modifier;
        }

        public final ChildStack<C, T> getStack() {
            return this.stack;
        }

        public final int getKey() {
            return this.key;
        }

        public /* synthetic */ Item(ChildStack childStack, int i, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(childStack, i, (i2 & 4) != 0 ? new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$Item$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Modifier.Companion companion;
                    companion = Modifier.Companion;
                    return companion;
                }
            } : function0);
        }

        public final Function0<Modifier> getModifier() {
            return this.modifier;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PredictiveBackAnimation.kt */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0004B\u009d\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012T\u0010\u000e\u001aP\u0012\u0004\u0012\u00020\u0010\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0010H\u0016J8\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0006\"\b\b\u0004\u0010\u0001*\u00020\u0002\"\b\b\u0005\u0010\u0003*\u00020\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010+\u001a\u00020\u0018H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\\\u0010\u000e\u001aP\u0012\u0004\u0012\u00020\u0010\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\nX\u0082\u0004¢\u0006\u0002\n\u0000RO\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u001d0\u001c2\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u001d0\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010%\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimation$Handler;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/essenty/backhandler/BackCallback;", "stack", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isGestureEnabled", "Lkotlin/Function0;", "", "key", "", "selector", "Lkotlin/Function3;", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "Lcom/arkivanov/decompose/Child$Created;", "Lkotlin/ParameterName;", "name", "exitChild", "enterChild", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "onBack", "", "<init>", "(Lcom/arkivanov/decompose/router/stack/ChildStack;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimation$Item;", FirebaseAnalytics.Param.ITEMS, "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "items$delegate", "Landroidx/compose/runtime/MutableState;", "animatable", "initialBackEvent", "onBackStarted", "backEvent", "onBackProgressed", "dropLast", "onBackCancelled", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Handler<C, T> extends BackCallback {
        private PredictiveBackAnimatable animatable;
        private BackEvent initialBackEvent;
        private final Function0<Boolean> isGestureEnabled;
        private final MutableState items$delegate;
        private final int key;
        private final Function0<Unit> onBack;
        private final CoroutineScope scope;
        private final Function3<BackEvent, Child.Created<? extends C, ? extends T>, Child.Created<? extends C, ? extends T>, PredictiveBackAnimatable> selector;
        private final ChildStack<C, T> stack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Handler(ChildStack<? extends C, ? extends T> stack, CoroutineScope scope, Function0<Boolean> isGestureEnabled, int i, Function3<? super BackEvent, ? super Child.Created<? extends C, ? extends T>, ? super Child.Created<? extends C, ? extends T>, ? extends PredictiveBackAnimatable> selector, Function0<Unit> onBack) {
            super(false, 0, 3, null);
            MutableState mutableStateOf$default;
            Intrinsics.checkNotNullParameter(stack, "stack");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(isGestureEnabled, "isGestureEnabled");
            Intrinsics.checkNotNullParameter(selector, "selector");
            Intrinsics.checkNotNullParameter(onBack, "onBack");
            this.stack = stack;
            this.scope = scope;
            this.isGestureEnabled = isGestureEnabled;
            this.key = i;
            this.selector = selector;
            this.onBack = onBack;
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.listOf(new Item(stack, i, null, 4, null)), null, 2, null);
            this.items$delegate = mutableStateOf$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setItems(List<? extends Item<? extends C, ? extends T>> list) {
            this.items$delegate.setValue(list);
        }

        public final List<Item<C, T>> getItems() {
            return (List) this.items$delegate.getValue();
        }

        @Override // com.arkivanov.essenty.backhandler.BackCallback
        public void onBackStarted(BackEvent backEvent) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            this.initialBackEvent = backEvent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.arkivanov.essenty.backhandler.BackCallback
        public void onBackProgressed(BackEvent backEvent) {
            Intrinsics.checkNotNullParameter(backEvent, "backEvent");
            BackEvent backEvent2 = this.initialBackEvent;
            if (backEvent2 != null && this.isGestureEnabled.invoke().booleanValue()) {
                final PredictiveBackAnimatable predictiveBackAnimatable = (PredictiveBackAnimatable) this.selector.invoke(backEvent2, this.stack.getActive(), CollectionsKt.last((List<? extends Object>) this.stack.getBackStack()));
                this.animatable = predictiveBackAnimatable;
                this.initialBackEvent = null;
                setItems(CollectionsKt.listOf((Object[]) new Item[]{new Item(dropLast(this.stack), this.key + 1, new PropertyReference0Impl(predictiveBackAnimatable) { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$Handler$onBackProgressed$1
                    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((PredictiveBackAnimatable) this.receiver).getEnterModifier();
                    }
                }), new Item(this.stack, this.key, new PropertyReference0Impl(predictiveBackAnimatable) { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimation$Handler$onBackProgressed$2
                    @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
                    public Object get() {
                        return ((PredictiveBackAnimatable) this.receiver).getExitModifier();
                    }
                })}));
            }
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PredictiveBackAnimation$Handler$onBackProgressed$3(this, backEvent, null), 3, null);
        }

        private final <C, T> ChildStack<C, T> dropLast(ChildStack<? extends C, ? extends T> childStack) {
            return new ChildStack<>((Child.Created) CollectionsKt.last((List<? extends Object>) childStack.getBackStack()), CollectionsKt.dropLast(childStack.getBackStack(), 1));
        }

        @Override // com.arkivanov.essenty.backhandler.BackCallback
        public void onBack() {
            if (this.animatable != null) {
                BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PredictiveBackAnimation$Handler$onBack$1(this, null), 3, null);
            } else {
                this.onBack.invoke();
            }
        }

        @Override // com.arkivanov.essenty.backhandler.BackCallback
        public void onBackCancelled() {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new PredictiveBackAnimation$Handler$onBackCancelled$1(this, null), 3, null);
        }
    }
}
