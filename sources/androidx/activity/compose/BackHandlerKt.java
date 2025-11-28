package androidx.activity.compose;

import androidx.activity.ActivityFlags;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
/* compiled from: BackHandler.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "activity-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BackHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackHandler$lambda$8(boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        BackHandler(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    public static final void BackHandler(boolean z, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        final boolean z3;
        Composer startRestartGroup = composer.startRestartGroup(-361453782);
        ComposerKt.sourceInformation(startRestartGroup, "C(BackHandler)N(enabled,onBack)107@4975L7,108@5056L7,116@5463L422,125@5910L27,127@5964L115:BackHandler.kt#q1dkbc");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = (startRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            z3 = z2;
        } else {
            boolean z4 = i4 != 0 ? true : z2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-361453782, i3, -1, "androidx.activity.compose.BackHandler (BackHandler.kt:106)");
            }
            NavigationEventDispatcherOwner current = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, LocalNavigationEventDispatcherOwner.$stable);
            OnBackPressedDispatcherOwner current2 = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, 6);
            OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = current == null ? current2 : current;
            if (onBackPressedDispatcherOwner == null) {
                throw new IllegalArgumentException("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.".toString());
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 535286992, "CC(remember):BackHandler.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BackHandlerDispatcherCompat(current != null ? current.getNavigationEventDispatcher() : null, current2 != null ? current2.getOnBackPressedDispatcher() : null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final BackHandlerDispatcherCompat backHandlerDispatcherCompat = (BackHandlerDispatcherCompat) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean z5 = z4;
            long currentCompositeKeyHashCode = ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 535302717, "CC(remember):BackHandler.kt#9igjgp");
            boolean changed = startRestartGroup.changed(backHandlerDispatcherCompat) | startRestartGroup.changed(currentCompositeKeyHashCode);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new ComposeBackHandler(new BackHandlerInfo(onBackPressedDispatcherOwner, currentCompositeKeyHashCode));
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final ComposeBackHandler composeBackHandler = (ComposeBackHandler) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
                startRestartGroup.startReplaceGroup(-585289004);
                ComposerKt.sourceInformation(startRestartGroup, "133@6266L43,133@6255L54,137@6535L117,137@6496L156,142@6700L114,142@6662L152");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 535312309, "CC(remember):BackHandler.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(composeBackHandler) | ((i3 & 112) == 32);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit BackHandler$lambda$3$0;
                            BackHandler$lambda$3$0 = BackHandlerKt.BackHandler$lambda$3$0(ComposeBackHandler.this, function0);
                            return BackHandler$lambda$3$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
                Boolean valueOf = Boolean.valueOf(z5);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 535320991, "CC(remember):BackHandler.kt#9igjgp");
                int i5 = i3 & 14;
                boolean changedInstance2 = startRestartGroup.changedInstance(composeBackHandler) | (i5 == 4);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    z3 = z5;
                    rememberedValue4 = new Function1() { // from class: androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            LifecycleStopOrDisposeEffectResult BackHandler$lambda$4$0;
                            BackHandler$lambda$4$0 = BackHandlerKt.BackHandler$lambda$4$0(ComposeBackHandler.this, z3, (LifecycleStartStopEffectScope) obj);
                            return BackHandler$lambda$4$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                } else {
                    z3 = z5;
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LifecycleEffectKt.LifecycleStartEffect(valueOf, composeBackHandler, null, (Function1) rememberedValue4, startRestartGroup, i5, 4);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 535326268, "CC(remember):BackHandler.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(backHandlerDispatcherCompat) | startRestartGroup.changedInstance(composeBackHandler);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DisposableEffectResult BackHandler$lambda$5$0;
                            BackHandler$lambda$5$0 = BackHandlerKt.BackHandler$lambda$5$0(BackHandlerDispatcherCompat.this, composeBackHandler, (DisposableEffectScope) obj);
                            return BackHandler$lambda$5$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.DisposableEffect(backHandlerDispatcherCompat, composeBackHandler, (Function1) rememberedValue5, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                z3 = z5;
                startRestartGroup.startReplaceGroup(-584615312);
                ComposerKt.sourceInformation(startRestartGroup, "148@6948L107,148@6937L118,155@7284L120,155@7242L162");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 535334197, "CC(remember):BackHandler.kt#9igjgp");
                boolean changedInstance4 = startRestartGroup.changedInstance(composeBackHandler) | ((i3 & 14) == 4) | ((i3 & 112) == 32);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit BackHandler$lambda$6$0;
                            BackHandler$lambda$6$0 = BackHandlerKt.BackHandler$lambda$6$0(ComposeBackHandler.this, z3, function0);
                            return BackHandler$lambda$6$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.SideEffect((Function0) rememberedValue6, startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 535344962, "CC(remember):BackHandler.kt#9igjgp");
                boolean changedInstance5 = startRestartGroup.changedInstance(backHandlerDispatcherCompat) | startRestartGroup.changedInstance(composeBackHandler);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance5 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            LifecycleStopOrDisposeEffectResult BackHandler$lambda$7$0;
                            BackHandler$lambda$7$0 = BackHandlerKt.BackHandler$lambda$7$0(BackHandlerDispatcherCompat.this, composeBackHandler, (LifecycleStartStopEffectScope) obj);
                            return BackHandler$lambda$7$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LifecycleEffectKt.LifecycleStartEffect(backHandlerDispatcherCompat, composeBackHandler, null, rememberedValue7, startRestartGroup, 0, 4);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackHandler$lambda$8;
                    BackHandler$lambda$8 = BackHandlerKt.BackHandler$lambda$8(z3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return BackHandler$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackHandler$lambda$3$0(ComposeBackHandler composeBackHandler, Function0 function0) {
        composeBackHandler.setCurrentOnBackCompleted(function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleStopOrDisposeEffectResult BackHandler$lambda$4$0(final ComposeBackHandler composeBackHandler, boolean z, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope) {
        composeBackHandler.setBackEnabled(z);
        return new LifecycleStopOrDisposeEffectResult() { // from class: androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1
            @Override // androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult
            public void runStopOrDisposeEffect() {
                LifecycleStartStopEffectScope lifecycleStartStopEffectScope2 = LifecycleStartStopEffectScope.this;
                composeBackHandler.setBackEnabled(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BackHandler$lambda$5$0(final BackHandlerDispatcherCompat backHandlerDispatcherCompat, final ComposeBackHandler composeBackHandler, DisposableEffectScope disposableEffectScope) {
        backHandlerDispatcherCompat.addHandler(composeBackHandler);
        return new DisposableEffectResult() { // from class: androidx.activity.compose.BackHandlerKt$BackHandler$lambda$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                BackHandlerDispatcherCompat.this.removeHandler(composeBackHandler);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackHandler$lambda$6$0(ComposeBackHandler composeBackHandler, boolean z, Function0 function0) {
        composeBackHandler.setBackEnabled(z);
        composeBackHandler.setCurrentOnBackCompleted(function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleStopOrDisposeEffectResult BackHandler$lambda$7$0(final BackHandlerDispatcherCompat backHandlerDispatcherCompat, final ComposeBackHandler composeBackHandler, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope) {
        backHandlerDispatcherCompat.addHandler(composeBackHandler);
        return new LifecycleStopOrDisposeEffectResult() { // from class: androidx.activity.compose.BackHandlerKt$BackHandler$lambda$7$0$$inlined$onStopOrDispose$1
            @Override // androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult
            public void runStopOrDisposeEffect() {
                LifecycleStartStopEffectScope lifecycleStartStopEffectScope2 = LifecycleStartStopEffectScope.this;
                backHandlerDispatcherCompat.removeHandler(composeBackHandler);
            }
        };
    }
}
