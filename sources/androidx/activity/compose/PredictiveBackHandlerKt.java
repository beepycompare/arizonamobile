package androidx.activity.compose;

import androidx.activity.ActivityFlags;
import androidx.activity.BackEventCompat;
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
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
/* compiled from: PredictiveBackHandler.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aZ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032A\u0010\u0004\u001a=\b\u0001\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0001¢\u0006\u0002\b\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0005H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"PredictiveBackHandler", "", "enabled", "", "onBack", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Lkotlin/jvm/JvmSuppressWildcards;", "Lkotlin/ParameterName;", "name", "progress", "Lkotlin/coroutines/Continuation;", "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "activity-compose"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PredictiveBackHandlerKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PredictiveBackHandler$lambda$7(boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        PredictiveBackHandler(z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v33 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static final void PredictiveBackHandler(boolean z, final Function2<Flow<BackEventCompat>, ? super Continuation<Unit>, ? extends Object> function2, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        final boolean z3;
        Composer startRestartGroup = composer.startRestartGroup(-642000585);
        ComposerKt.sourceInformation(startRestartGroup, "C(PredictiveBackHandler)N(enabled,onBack)121@5572L7,130@5977L427,139@6422L24,140@6470L27,142@6524L196:PredictiveBackHandler.kt#q1dkbc");
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
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!startRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            startRestartGroup.skipToGroupEnd();
            z3 = z2;
        } else {
            z3 = i4 != 0 ? true : z2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-642000585, i3, -1, "androidx.activity.compose.PredictiveBackHandler (PredictiveBackHandler.kt:118)");
            }
            Object current = LocalNavigationEventDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, LocalNavigationEventDispatcherOwner.$stable);
            if (current != null) {
                startRestartGroup.startReplaceGroup(1512737723);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1512740606);
                ComposerKt.sourceInformation(startRestartGroup, "122@5629L7");
                current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            if (current == null) {
                throw new IllegalStateException("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.".toString());
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1512752162, "CC(remember):PredictiveBackHandler.kt#9igjgp");
            boolean changed = startRestartGroup.changed(current);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                NavigationEventDispatcherOwner navigationEventDispatcherOwner = current instanceof NavigationEventDispatcherOwner ? (NavigationEventDispatcherOwner) current : null;
                NavigationEventDispatcher navigationEventDispatcher = navigationEventDispatcherOwner != null ? navigationEventDispatcherOwner.getNavigationEventDispatcher() : null;
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = current instanceof OnBackPressedDispatcherOwner ? (OnBackPressedDispatcherOwner) current : null;
                rememberedValue = new BackHandlerDispatcherCompat(navigationEventDispatcher, onBackPressedDispatcherOwner != null ? onBackPressedDispatcherOwner.getOnBackPressedDispatcher() : null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final BackHandlerDispatcherCompat backHandlerDispatcherCompat = (BackHandlerDispatcherCompat) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long currentCompositeKeyHashCode = ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1512769435, "CC(remember):PredictiveBackHandler.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(backHandlerDispatcherCompat) | startRestartGroup.changed(currentCompositeKeyHashCode);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new ComposePredictiveBackHandler(coroutineScope, new PredictiveBackHandlerInfo(current, currentCompositeKeyHashCode));
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final ComposePredictiveBackHandler composePredictiveBackHandler = (ComposePredictiveBackHandler) rememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (ActivityFlags.isOnBackPressedLifecycleOrderMaintained) {
                startRestartGroup.startReplaceGroup(-348514256);
                ComposerKt.sourceInformation(startRestartGroup, "151@6907L34,151@6896L45,155@7167L117,155@7128L156,160@7332L114,160@7294L152");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1512781529, "CC(remember):PredictiveBackHandler.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(composePredictiveBackHandler) | startRestartGroup.changedInstance(function2);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PredictiveBackHandler$lambda$2$0;
                            PredictiveBackHandler$lambda$2$0 = PredictiveBackHandlerKt.PredictiveBackHandler$lambda$2$0(ComposePredictiveBackHandler.this, function2);
                            return PredictiveBackHandler$lambda$2$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                Boolean valueOf = Boolean.valueOf(z3);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1512789932, "CC(remember):PredictiveBackHandler.kt#9igjgp");
                int i5 = i3 & 14;
                boolean changedInstance2 = startRestartGroup.changedInstance(composePredictiveBackHandler) | (i5 == 4);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            LifecycleStopOrDisposeEffectResult PredictiveBackHandler$lambda$3$0;
                            PredictiveBackHandler$lambda$3$0 = PredictiveBackHandlerKt.PredictiveBackHandler$lambda$3$0(ComposePredictiveBackHandler.this, z3, (LifecycleStartStopEffectScope) obj);
                            return PredictiveBackHandler$lambda$3$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LifecycleEffectKt.LifecycleStartEffect(valueOf, composePredictiveBackHandler, null, rememberedValue5, startRestartGroup, i5, 4);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1512795209, "CC(remember):PredictiveBackHandler.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(backHandlerDispatcherCompat) | startRestartGroup.changedInstance(composePredictiveBackHandler);
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DisposableEffectResult PredictiveBackHandler$lambda$4$0;
                            PredictiveBackHandler$lambda$4$0 = PredictiveBackHandlerKt.PredictiveBackHandler$lambda$4$0(BackHandlerDispatcherCompat.this, composePredictiveBackHandler, (DisposableEffectScope) obj);
                            return PredictiveBackHandler$lambda$4$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.DisposableEffect(backHandlerDispatcherCompat, composePredictiveBackHandler, (Function1) rememberedValue6, startRestartGroup, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-347849492);
                ComposerKt.sourceInformation(startRestartGroup, "166@7580L98,166@7569L109,173@7907L120,173@7865L162");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1512803129, "CC(remember):PredictiveBackHandler.kt#9igjgp");
                boolean changedInstance4 = startRestartGroup.changedInstance(composePredictiveBackHandler) | ((i3 & 14) == 4) | startRestartGroup.changedInstance(function2);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue7 == Composer.Companion.getEmpty()) {
                    rememberedValue7 = new Function0() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PredictiveBackHandler$lambda$5$0;
                            PredictiveBackHandler$lambda$5$0 = PredictiveBackHandlerKt.PredictiveBackHandler$lambda$5$0(ComposePredictiveBackHandler.this, z3, function2);
                            return PredictiveBackHandler$lambda$5$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                EffectsKt.SideEffect((Function0) rememberedValue7, startRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1512813615, "CC(remember):PredictiveBackHandler.kt#9igjgp");
                boolean changedInstance5 = startRestartGroup.changedInstance(backHandlerDispatcherCompat) | startRestartGroup.changedInstance(composePredictiveBackHandler);
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (changedInstance5 || rememberedValue8 == Composer.Companion.getEmpty()) {
                    rememberedValue8 = new Function1() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            LifecycleStopOrDisposeEffectResult PredictiveBackHandler$lambda$6$0;
                            PredictiveBackHandler$lambda$6$0 = PredictiveBackHandlerKt.PredictiveBackHandler$lambda$6$0(BackHandlerDispatcherCompat.this, composePredictiveBackHandler, (LifecycleStartStopEffectScope) obj);
                            return PredictiveBackHandler$lambda$6$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LifecycleEffectKt.LifecycleStartEffect(backHandlerDispatcherCompat, composePredictiveBackHandler, null, rememberedValue8, startRestartGroup, 0, 4);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PredictiveBackHandlerKt.PredictiveBackHandler$lambda$7(z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PredictiveBackHandler$lambda$2$0(ComposePredictiveBackHandler composePredictiveBackHandler, Function2 function2) {
        composePredictiveBackHandler.setCurrentOnBack(function2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleStopOrDisposeEffectResult PredictiveBackHandler$lambda$3$0(final ComposePredictiveBackHandler composePredictiveBackHandler, boolean z, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope) {
        composePredictiveBackHandler.setBackEnabled(z);
        return new LifecycleStopOrDisposeEffectResult() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$lambda$3$0$$inlined$onStopOrDispose$1
            @Override // androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult
            public void runStopOrDisposeEffect() {
                LifecycleStartStopEffectScope lifecycleStartStopEffectScope2 = LifecycleStartStopEffectScope.this;
                composePredictiveBackHandler.setBackEnabled(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PredictiveBackHandler$lambda$4$0(final BackHandlerDispatcherCompat backHandlerDispatcherCompat, final ComposePredictiveBackHandler composePredictiveBackHandler, DisposableEffectScope disposableEffectScope) {
        backHandlerDispatcherCompat.addHandler(composePredictiveBackHandler);
        return new DisposableEffectResult() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$lambda$4$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                BackHandlerDispatcherCompat.this.removeHandler(composePredictiveBackHandler);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PredictiveBackHandler$lambda$5$0(ComposePredictiveBackHandler composePredictiveBackHandler, boolean z, Function2 function2) {
        composePredictiveBackHandler.setBackEnabled(z);
        composePredictiveBackHandler.setCurrentOnBack(function2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleStopOrDisposeEffectResult PredictiveBackHandler$lambda$6$0(final BackHandlerDispatcherCompat backHandlerDispatcherCompat, final ComposePredictiveBackHandler composePredictiveBackHandler, final LifecycleStartStopEffectScope lifecycleStartStopEffectScope) {
        backHandlerDispatcherCompat.addHandler(composePredictiveBackHandler);
        return new LifecycleStopOrDisposeEffectResult() { // from class: androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$lambda$6$0$$inlined$onStopOrDispose$1
            @Override // androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult
            public void runStopOrDisposeEffect() {
                LifecycleStartStopEffectScope lifecycleStartStopEffectScope2 = LifecycleStartStopEffectScope.this;
                backHandlerDispatcherCompat.removeHandler(composePredictiveBackHandler);
            }
        };
    }
}
