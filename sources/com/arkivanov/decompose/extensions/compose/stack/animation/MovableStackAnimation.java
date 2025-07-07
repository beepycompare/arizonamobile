package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MovableContentKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.extensions.compose.stack.animation.AbstractStackAnimation;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MovableStackAnimation.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004Bv\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012e\u0010\u0007\u001aa\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\b¢\u0006\u0004\b\u0011\u0010\u0012Jc\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u001822\u0010\u0019\u001a.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0002\b\u001bH\u0015¢\u0006\u0002\u0010\u001cRm\u0010\u0007\u001aa\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/MovableStackAnimation;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation;", "disableInputDuringAnimation", "", "selector", "Lkotlin/Function3;", "Lcom/arkivanov/decompose/Child$Created;", "Lkotlin/ParameterName;", "name", "child", "otherChild", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/Direction;", "direction", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "<init>", "(ZLkotlin/jvm/functions/Function3;)V", "Child", "", "item", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation$AnimationItem;", "onFinished", "Lkotlin/Function0;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation$AnimationItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MovableStackAnimation<C, T> extends AbstractStackAnimation<C, T> {
    public static final int $stable = 0;
    private final Function3<Child.Created<? extends C, ? extends T>, Child.Created<? extends C, ? extends T>, Direction, StackAnimator> selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MovableStackAnimation(boolean z, Function3<? super Child.Created<? extends C, ? extends T>, ? super Child.Created<? extends C, ? extends T>, ? super Direction, ? extends StackAnimator> selector) {
        super(z);
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.selector = selector;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.AbstractStackAnimation
    protected void Child(final AbstractStackAnimation.AnimationItem<? extends C, ? extends T> item, Function0<Unit> onFinished, Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> content, Composer composer, int i) {
        EmptyStackAnimator invoke;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceGroup(-1396755942);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1396755942, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.MovableStackAnimation.Child (MovableStackAnimation.kt:20)");
        }
        Object key = item.getChild().getKey();
        Child.Created<? extends C, ? extends T> otherChild = item.getOtherChild();
        Object key2 = otherChild != null ? otherChild.getKey() : null;
        Direction direction = item.getDirection();
        composer.startReplaceGroup(578509470);
        boolean changed = composer.changed(key) | composer.changed(key2) | composer.changed(direction);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (item.getOtherChild() == null) {
                invoke = EmptyStackAnimator.INSTANCE;
            } else {
                invoke = this.selector.invoke(item.getChild(), item.getOtherChild(), item.getDirection());
                if (invoke == null) {
                    invoke = EmptyStackAnimator.INSTANCE;
                }
            }
            rememberedValue = invoke;
            composer.updateRememberedValue(rememberedValue);
        }
        StackAnimator stackAnimator = (StackAnimator) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(578519893);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = MovableContentKt.movableContentOf(content);
            composer.updateRememberedValue(rememberedValue2);
        }
        final Function3 function3 = (Function3) rememberedValue2;
        composer.endReplaceGroup();
        stackAnimator.invoke(item.getDirection(), item.isInitial(), onFinished, ComposableLambdaKt.rememberComposableLambda(1059170347, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.MovableStackAnimation$Child$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer2, Integer num) {
                invoke(modifier, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Modifier modifier, Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                if ((i2 & 6) == 0) {
                    i2 |= composer2.changed(modifier) ? 4 : 2;
                }
                if ((i2 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1059170347, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.MovableStackAnimation.Child.<anonymous> (MovableStackAnimation.kt:37)");
                    }
                    Function3<Child.Created<? extends C, ? extends T>, Composer, Integer, Unit> function32 = function3;
                    AbstractStackAnimation.AnimationItem<C, T> animationItem = item;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3520constructorimpl = Updater.m3520constructorimpl(composer2);
                    Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    function32.invoke(animationItem.getChild(), composer2, 48);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }, composer, 54), composer, ((i << 3) & 896) | 3072);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}
