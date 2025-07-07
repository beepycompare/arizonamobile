package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SimpleStackAnimation.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B1\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012 \u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0004\b\u000b\u0010\fJc\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001222\u0010\u0013\u001a.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0002\b\u0017H\u0015¢\u0006\u0002\u0010\u0018R(\u0010\u0007\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/SimpleStackAnimation;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation;", "disableInputDuringAnimation", "", "selector", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/Child$Created;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimator;", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "Child", "", "item", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation$AnimationItem;", "onFinished", "Lkotlin/Function0;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/ParameterName;", "name", "child", "Landroidx/compose/runtime/Composable;", "(Lcom/arkivanov/decompose/extensions/compose/stack/animation/AbstractStackAnimation$AnimationItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleStackAnimation<C, T> extends AbstractStackAnimation<C, T> {
    public static final int $stable = 0;
    private final Function1<Child.Created<? extends C, ? extends T>, StackAnimator> selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleStackAnimation(boolean z, Function1<? super Child.Created<? extends C, ? extends T>, ? extends StackAnimator> selector) {
        super(z);
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.selector = selector;
    }

    @Override // com.arkivanov.decompose.extensions.compose.stack.animation.AbstractStackAnimation
    protected void Child(final AbstractStackAnimation.AnimationItem<? extends C, ? extends T> item, Function0<Unit> onFinished, final Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> content, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceGroup(875477024);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(875477024, i, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.SimpleStackAnimation.Child (SimpleStackAnimation.kt:19)");
        }
        Object key = item.getChild().getKey();
        composer.startReplaceGroup(-1440145492);
        boolean changed = composer.changed(key);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            EmptyStackAnimator invoke = this.selector.invoke(item.getChild());
            if (invoke == null) {
                invoke = EmptyStackAnimator.INSTANCE;
            }
            rememberedValue = invoke;
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        ((StackAnimator) rememberedValue).invoke(item.getDirection(), item.isInitial(), onFinished, ComposableLambdaKt.rememberComposableLambda(1512668785, true, new Function3<Modifier, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.SimpleStackAnimation$Child$1
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
                        ComposerKt.traceEventStart(1512668785, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.animation.SimpleStackAnimation.Child.<anonymous> (SimpleStackAnimation.kt:27)");
                    }
                    Function3<Child.Created<? extends C, ? extends T>, Composer, Integer, Unit> function3 = content;
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
                    function3.invoke(animationItem.getChild(), composer2, 0);
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
