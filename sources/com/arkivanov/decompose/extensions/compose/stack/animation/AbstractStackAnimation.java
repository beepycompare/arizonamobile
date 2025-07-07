package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.extensions.compose.stack.animation.AbstractStackAnimation;
import com.arkivanov.decompose.extensions.compose.utils.InputConsumingOverlayKt;
import com.arkivanov.decompose.router.stack.ChildStack;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: AbstractStackAnimation.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\b!\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001)B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJc\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e22\u0010\u000f\u001a.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0015H%¢\u0006\u0002\u0010\u0016J^\u0010\u0017\u001a\u00020\n2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b22\u0010\u000f\u001a.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0015H\u0097\u0002¢\u0006\u0002\u0010\u001cJJ\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00192\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0019H\u0002J/\u0010%\u001a\u00020\u0006\"\b\b\u0002\u0010\u0001*\u00020\u0002*\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0001\u0012\u0002\b\u00030'0&2\u0006\u0010(\u001a\u00020\u0002H\u0082\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u00020\"*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006*²\u0006*\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0019\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0002X\u008a\u008e\u0002²\u00066\u0010,\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\f0\u001e\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0002X\u008a\u008e\u0002²\u00068\u0010-\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\f\u0018\u00010\u001e\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0002X\u008a\u008e\u0002"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;", "disableInputDuringAnimation", "", "<init>", "(Z)V", "Child", "", "item", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation$AnimationItem;", "onFinished", "Lkotlin/Function0;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Lcom/arkivanov/decompose/Child$Created;", "Lkotlin/ParameterName;", "name", "child", "Landroidx/compose/runtime/Composable;", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation$AnimationItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "invoke", "stack", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/arkivanov/decompose/router/stack/ChildStack;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "getAnimationItems", "", "newStack", "oldStack", "size", "", "getSize", "(Lcom/arkivanov/decompose/router/stack/ChildStack;)I", "contains", "", "Lcom/arkivanov/decompose/Child;", "key", "AnimationItem", "extensions-compose_release", "currentStack", FirebaseAnalytics.Param.ITEMS, "nextItems"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractStackAnimation<C, T> implements StackAnimation<C, T> {
    public static final int $stable = 0;
    private final boolean disableInputDuringAnimation;

    protected abstract void Child(AnimationItem<? extends C, ? extends T> animationItem, Function0<Unit> function0, Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i);

    public AbstractStackAnimation(boolean z) {
        this.disableInputDuringAnimation = z;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation
    public void invoke(ChildStack<? extends C, ? extends T> stack, Modifier modifier, Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> content = function3;
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceGroup(-43866100);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-43866100, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.AbstractStackAnimation.invoke (AbstractStackAnimation.kt:29)");
        }
        composer.startReplaceGroup(-1701205311);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(stack, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1701203465);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getAnimationItems(invoke$lambda$1(mutableState), null), null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1701198848);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == Composer.Companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        final MutableState mutableState3 = (MutableState) rememberedValue3;
        composer.endReplaceGroup();
        if (!Intrinsics.areEqual(stack.getActive().getKey(), invoke$lambda$1(mutableState).getActive().getKey()) || !Intrinsics.areEqual(stack.getActive().getInstance(), invoke$lambda$1(mutableState).getActive().getInstance())) {
            ChildStack<? extends C, ? extends T> invoke$lambda$1 = invoke$lambda$1(mutableState);
            mutableState.setValue(stack);
            Map<Object, AnimationItem<C, T>> animationItems = getAnimationItems(invoke$lambda$1(mutableState), invoke$lambda$1);
            if (invoke$lambda$4(mutableState2).size() == 1) {
                mutableState2.setValue(animationItems);
            } else {
                mutableState3.setValue(animationItems);
            }
        }
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
        composer.startReplaceGroup(619201461);
        for (Map.Entry entry : invoke$lambda$4(mutableState2).entrySet()) {
            final Object key = entry.getKey();
            final AnimationItem<? extends C, ? extends T> animationItem = (AnimationItem) entry.getValue();
            composer.startMovableGroup(800472477, key);
            composer.startReplaceGroup(800475536);
            boolean changedInstance = composer.changedInstance(animationItem) | composer.changedInstance(key);
            Object rememberedValue4 = composer.rememberedValue();
            if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.AbstractStackAnimation$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$16$lambda$15$lambda$10$lambda$9;
                        invoke$lambda$16$lambda$15$lambda$10$lambda$9 = AbstractStackAnimation.invoke$lambda$16$lambda$15$lambda$10$lambda$9(AbstractStackAnimation.AnimationItem.this, key, mutableState2);
                        return invoke$lambda$16$lambda$15$lambda$10$lambda$9;
                    }
                };
                composer.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceGroup();
            Child(animationItem, (Function0) rememberedValue4, content, composer, i & 8064);
            if (DirectionKt.isExit(animationItem.getDirection())) {
                Unit unit = Unit.INSTANCE;
                composer.startReplaceGroup(800489518);
                Object rememberedValue5 = composer.rememberedValue();
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.AbstractStackAnimation$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DisposableEffectResult invoke$lambda$16$lambda$15$lambda$14$lambda$13;
                            invoke$lambda$16$lambda$15$lambda$14$lambda$13 = AbstractStackAnimation.invoke$lambda$16$lambda$15$lambda$14$lambda$13(MutableState.this, mutableState2, (DisposableEffectScope) obj);
                            return invoke$lambda$16$lambda$15$lambda$14$lambda$13;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue5);
                }
                composer.endReplaceGroup();
                EffectsKt.DisposableEffect(unit, (Function1) rememberedValue5, composer, 54);
            }
            composer.endMovableGroup();
            content = function3;
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(619233416);
        if (this.disableInputDuringAnimation && (invoke$lambda$4(mutableState2).size() > 1 || invoke$lambda$7(mutableState3) != null)) {
            InputConsumingOverlayKt.InputConsumingOverlay(boxScopeInstance.matchParentSize(Modifier.Companion), composer, 0);
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    private static final <C, T> ChildStack<C, T> invoke$lambda$1(MutableState<ChildStack<C, T>> mutableState) {
        return mutableState.getValue();
    }

    private static final <C, T> Map<Object, AnimationItem<C, T>> invoke$lambda$4(MutableState<Map<Object, AnimationItem<C, T>>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <C, T> Map<Object, AnimationItem<C, T>> invoke$lambda$7(MutableState<Map<Object, AnimationItem<C, T>>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$16$lambda$15$lambda$10$lambda$9(AnimationItem animationItem, Object obj, MutableState mutableState) {
        if (DirectionKt.isExit(animationItem.getDirection())) {
            mutableState.setValue(MapsKt.minus(invoke$lambda$4(mutableState), obj));
        } else {
            mutableState.setValue(MapsKt.plus(invoke$lambda$4(mutableState), TuplesKt.to(obj, AnimationItem.copy$default(animationItem, null, null, false, null, 7, null))));
        }
        return Unit.INSTANCE;
    }

    private final Map<Object, AnimationItem<C, T>> getAnimationItems(ChildStack<? extends C, ? extends T> childStack, ChildStack<? extends C, ? extends T> childStack2) {
        List listOf;
        if (childStack2 == null || Intrinsics.areEqual(childStack.getActive().getKey(), childStack2.getActive().getKey())) {
            listOf = CollectionsKt.listOf(new AnimationItem(childStack.getActive(), Direction.ENTER_FRONT, true, null, 8, null));
        } else if (getSize(childStack) < getSize(childStack2) && contains(childStack2.getBackStack(), childStack.getActive().getKey())) {
            listOf = CollectionsKt.listOf((Object[]) new AnimationItem[]{new AnimationItem(childStack.getActive(), Direction.ENTER_BACK, false, childStack2.getActive(), 4, null), new AnimationItem(childStack2.getActive(), Direction.EXIT_FRONT, false, childStack.getActive(), 4, null)});
        } else {
            listOf = CollectionsKt.listOf((Object[]) new AnimationItem[]{new AnimationItem(childStack2.getActive(), Direction.EXIT_BACK, false, childStack.getActive(), 4, null), new AnimationItem(childStack.getActive(), Direction.ENTER_FRONT, false, childStack2.getActive(), 4, null)});
        }
        List list = listOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (T t : list) {
            linkedHashMap.put(((AnimationItem) t).getChild().getKey(), t);
        }
        return linkedHashMap;
    }

    private final int getSize(ChildStack<?, ?> childStack) {
        return childStack.getItems().size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractStackAnimation.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0084\b\u0018\u0000*\n\b\u0002\u0010\u0001 \u0001*\u00020\u0002*\n\b\u0003\u0010\u0003 \u0001*\u00020\u00022\u00020\u0002BE\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0005HÆ\u0003JW\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation$AnimationItem;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "child", "Lcom/arkivanov/decompose/Child$Created;", "direction", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "isInitial", "", "otherChild", "<init>", "(Lcom/arkivanov/decompose/Child$Created;Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;ZLcom/arkivanov/decompose/Child$Created;)V", "getChild", "()Lcom/arkivanov/decompose/Child$Created;", "getDirection", "()Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "()Z", "getOtherChild", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class AnimationItem<C, T> {
        private final Child.Created<C, T> child;
        private final Direction direction;
        private final boolean isInitial;
        private final Child.Created<C, T> otherChild;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimationItem copy$default(AnimationItem animationItem, Child.Created created, Direction direction, boolean z, Child.Created created2, int i, Object obj) {
            if ((i & 1) != 0) {
                created = animationItem.child;
            }
            if ((i & 2) != 0) {
                direction = animationItem.direction;
            }
            if ((i & 4) != 0) {
                z = animationItem.isInitial;
            }
            if ((i & 8) != 0) {
                created2 = animationItem.otherChild;
            }
            return animationItem.copy(created, direction, z, created2);
        }

        public final Child.Created<C, T> component1() {
            return this.child;
        }

        public final Direction component2() {
            return this.direction;
        }

        public final boolean component3() {
            return this.isInitial;
        }

        public final Child.Created<C, T> component4() {
            return this.otherChild;
        }

        public final AnimationItem<C, T> copy(Child.Created<? extends C, ? extends T> child, Direction direction, boolean z, Child.Created<? extends C, ? extends T> created) {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(direction, "direction");
            return new AnimationItem<>(child, direction, z, created);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AnimationItem) {
                AnimationItem animationItem = (AnimationItem) obj;
                return Intrinsics.areEqual(this.child, animationItem.child) && this.direction == animationItem.direction && this.isInitial == animationItem.isInitial && Intrinsics.areEqual(this.otherChild, animationItem.otherChild);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.child.hashCode() * 31) + this.direction.hashCode()) * 31) + Boolean.hashCode(this.isInitial)) * 31;
            Child.Created<C, T> created = this.otherChild;
            return hashCode + (created == null ? 0 : created.hashCode());
        }

        public String toString() {
            return "AnimationItem(child=" + this.child + ", direction=" + this.direction + ", isInitial=" + this.isInitial + ", otherChild=" + this.otherChild + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnimationItem(Child.Created<? extends C, ? extends T> child, Direction direction, boolean z, Child.Created<? extends C, ? extends T> created) {
            Intrinsics.checkNotNullParameter(child, "child");
            Intrinsics.checkNotNullParameter(direction, "direction");
            this.child = child;
            this.direction = direction;
            this.isInitial = z;
            this.otherChild = created;
        }

        public /* synthetic */ AnimationItem(Child.Created created, Direction direction, boolean z, Child.Created created2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(created, direction, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : created2);
        }

        public final Child.Created<C, T> getChild() {
            return this.child;
        }

        public final Direction getDirection() {
            return this.direction;
        }

        public final boolean isInitial() {
            return this.isInitial;
        }

        public final Child.Created<C, T> getOtherChild() {
            return this.otherChild;
        }
    }

    private final <C> boolean contains(Iterable<? extends Child<? extends C, ?>> iterable, Object obj) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        for (Child<? extends C, ?> child : iterable) {
            if (Intrinsics.areEqual(child.getKey(), obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult invoke$lambda$16$lambda$15$lambda$14$lambda$13(final MutableState mutableState, final MutableState mutableState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.AbstractStackAnimation$invoke$lambda$16$lambda$15$lambda$14$lambda$13$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Map invoke$lambda$7;
                invoke$lambda$7 = AbstractStackAnimation.invoke$lambda$7(MutableState.this);
                if (invoke$lambda$7 != null) {
                    mutableState2.setValue(invoke$lambda$7);
                }
                MutableState.this.setValue(null);
            }
        };
    }
}
