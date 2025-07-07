package com.arkivanov.decompose.extensions.compose.stack;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderKt;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.UtilsKt;
import com.arkivanov.decompose.extensions.compose.SubscribeAsStateKt;
import com.arkivanov.decompose.extensions.compose.stack.animation.EmptyStackAnimationKt;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationProvider;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationProviderKt;
import com.arkivanov.decompose.router.stack.ChildStack;
import com.arkivanov.decompose.value.Value;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: Children.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008b\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\n22\u0010\u000b\u001a.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0091\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00060\u00132\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\n22\u0010\u000b\u001a.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0001*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0003¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Children", "", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "stack", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "modifier", "Landroidx/compose/ui/Modifier;", "animation", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Lcom/arkivanov/decompose/Child$Created;", "Lkotlin/ParameterName;", "name", "child", "Landroidx/compose/runtime/Composable;", "(Lcom/arkivanov/decompose/router/stack/ChildStack;Landroidx/compose/ui/Modifier;Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Lcom/arkivanov/decompose/value/Value;", "(Lcom/arkivanov/decompose/value/Value;Landroidx/compose/ui/Modifier;Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getKeys", "", "", "retainStates", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "currentKeys", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Ljava/util/Set;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildrenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$0(ChildStack childStack, Modifier modifier, StackAnimation stackAnimation, Function3 function3, int i, int i2, Composer composer, int i3) {
        Children(childStack, modifier, stackAnimation, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Children$lambda$1(Value value, Modifier modifier, StackAnimation stackAnimation, Function3 function3, int i, int i2, Composer composer, int i3) {
        Children(value, modifier, stackAnimation, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit retainStates$lambda$8(SaveableStateHolder saveableStateHolder, Set set, int i, Composer composer, int i2) {
        retainStates(saveableStateHolder, set, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final <C, T> void Children(final ChildStack<? extends C, ? extends T> stack, Modifier modifier, StackAnimation<C, T> stackAnimation, final Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        StackAnimation<C, T> stackAnimation2;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(100558968);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(stack) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= (i & 512) == 0 ? startRestartGroup.changed(stackAnimation) : startRestartGroup.changedInstance(stackAnimation) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(content) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                stackAnimation = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(100558968, i3, -1, "com.arkivanov.decompose.extensions.compose.stack.Children (Children.kt:23)");
            }
            final SaveableStateHolder rememberSaveableStateHolder = SaveableStateHolderKt.rememberSaveableStateHolder(startRestartGroup, 0);
            retainStates(rememberSaveableStateHolder, getKeys(stack), startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(StackAnimationProviderKt.getLocalStackAnimationProvider());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            StackAnimationProvider stackAnimationProvider = (StackAnimationProvider) consume;
            startRestartGroup.startReplaceGroup(1543419138);
            if (stackAnimation == null) {
                startRestartGroup.startReplaceGroup(1543419541);
                boolean changed = startRestartGroup.changed(stackAnimationProvider);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = stackAnimationProvider.provide();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                stackAnimation2 = (StackAnimation) rememberedValue;
                startRestartGroup.endReplaceGroup();
            } else {
                stackAnimation2 = stackAnimation;
            }
            startRestartGroup.endReplaceGroup();
            if (stackAnimation2 == null) {
                stackAnimation2 = EmptyStackAnimationKt.emptyStackAnimation();
            }
            stackAnimation2.invoke(stack, modifier3, ComposableLambdaKt.rememberComposableLambda(-1548770973, true, new Function3<Child.Created<? extends C, ? extends T>, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.stack.ChildrenKt$Children$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Object obj, Composer composer2, Integer num) {
                    invoke((Child.Created) obj, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final Child.Created<? extends C, ? extends T> child, Composer composer2, int i6) {
                    Intrinsics.checkNotNullParameter(child, "child");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1548770973, i6, -1, "com.arkivanov.decompose.extensions.compose.stack.Children.<anonymous> (Children.kt:32)");
                    }
                    SaveableStateHolder saveableStateHolder = SaveableStateHolder.this;
                    String keyHashString = UtilsKt.keyHashString(child);
                    final Function3<Child.Created<? extends C, ? extends T>, Composer, Integer, Unit> function3 = content;
                    saveableStateHolder.SaveableStateProvider(keyHashString, ComposableLambdaKt.rememberComposableLambda(-433908510, true, new Function2<Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.stack.ChildrenKt$Children$1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i7) {
                            if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-433908510, i7, -1, "com.arkivanov.decompose.extensions.compose.stack.Children.<anonymous>.<anonymous> (Children.kt:33)");
                            }
                            function3.invoke(child, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i3 & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | (i3 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        }
        final StackAnimation<C, T> stackAnimation3 = stackAnimation;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.ChildrenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Children$lambda$0;
                    Children$lambda$0 = ChildrenKt.Children$lambda$0(ChildStack.this, modifier2, stackAnimation3, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return Children$lambda$0;
                }
            });
        }
    }

    public static final <C, T> void Children(final Value<? extends ChildStack<? extends C, ? extends T>> stack, Modifier modifier, StackAnimation<C, T> stackAnimation, final Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        final StackAnimation<C, T> stackAnimation2;
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(669199561);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(stack) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= (i & 512) == 0 ? startRestartGroup.changed(stackAnimation) : startRestartGroup.changedInstance(stackAnimation) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(content) ? 2048 : 1024;
        }
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            Modifier.Companion companion = i4 != 0 ? Modifier.Companion : modifier;
            StackAnimation<C, T> stackAnimation3 = i5 != 0 ? null : stackAnimation;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(669199561, i3, -1, "com.arkivanov.decompose.extensions.compose.stack.Children (Children.kt:44)");
            }
            int i6 = i3 & 8176;
            StackAnimation<C, T> stackAnimation4 = stackAnimation3;
            Modifier modifier3 = companion;
            Children((ChildStack) SubscribeAsStateKt.subscribeAsState(stack, null, startRestartGroup, i3 & 14, 1).getValue(), modifier3, stackAnimation4, content, startRestartGroup, i6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            stackAnimation2 = stackAnimation4;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            stackAnimation2 = stackAnimation;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.ChildrenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Children$lambda$1;
                    Children$lambda$1 = ChildrenKt.Children$lambda$1(Value.this, modifier2, stackAnimation2, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return Children$lambda$1;
                }
            });
        }
    }

    private static final Set<String> getKeys(ChildStack<?, ?> childStack) {
        HashSet hashSet = new HashSet();
        for (Child child : childStack.getItems()) {
            hashSet.add(UtilsKt.keyHashString(child));
        }
        return hashSet;
    }

    private static final void retainStates(final SaveableStateHolder saveableStateHolder, final Set<String> set, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-290867539);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(saveableStateHolder) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(set) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-290867539, i2, -1, "com.arkivanov.decompose.extensions.compose.stack.retainStates (Children.kt:59)");
            }
            startRestartGroup.startReplaceGroup(647264842);
            boolean changed = startRestartGroup.changed(saveableStateHolder);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Keys(set);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final Keys keys = (Keys) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(647267484);
            boolean changedInstance = startRestartGroup.changedInstance(keys) | startRestartGroup.changedInstance(set) | startRestartGroup.changedInstance(saveableStateHolder);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.stack.ChildrenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult retainStates$lambda$7$lambda$6;
                        retainStates$lambda$7$lambda$6 = ChildrenKt.retainStates$lambda$7$lambda$6(Keys.this, set, saveableStateHolder, (DisposableEffectScope) obj);
                        return retainStates$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(saveableStateHolder, set, (Function1) rememberedValue2, startRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.stack.ChildrenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit retainStates$lambda$8;
                    retainStates$lambda$8 = ChildrenKt.retainStates$lambda$8(SaveableStateHolder.this, set, i, (Composer) obj, ((Integer) obj2).intValue());
                    return retainStates$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult retainStates$lambda$7$lambda$6(Keys keys, Set set, SaveableStateHolder saveableStateHolder, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        for (Object obj : keys.getSet()) {
            if (!CollectionsKt.contains(set, obj)) {
                saveableStateHolder.removeState(obj);
            }
        }
        keys.setSet(set);
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.stack.ChildrenKt$retainStates$lambda$7$lambda$6$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }
}
