package com.miami.game.core.external.navigation.ui;

import android.app.Activity;
import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.miami.game.core.external.navigation.ExternalNavigationActivityExtensionsKt;
import com.miami.game.core.external.navigation.NotActivityContextNonFatalException;
import com.miami.game.core.external.navigation.model.ExternalNavigationAction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import timber.log.Timber;
/* compiled from: ObserveExternalNavigationActions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0002\u0010\u0004\u001a1\u0010\u0005\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00010\bH\u0003¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00010\b\"\u0004\b\u0000\u0010\u0006X\u008a\u0084\u0002"}, d2 = {"observeExternalNavigationActions", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "(Lkotlinx/coroutines/flow/Flow;Landroidx/compose/runtime/Composer;I)V", "collectWithLifecycle", ExifInterface.GPS_DIRECTION_TRUE, "onEvent", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "external-navigation_release_web", "currentOnEvent"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ObserveExternalNavigationActionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit collectWithLifecycle$lambda$6(Flow flow, Function1 function1, int i, Composer composer, int i2) {
        collectWithLifecycle(flow, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeExternalNavigationActions$lambda$3(Flow flow, int i, Composer composer, int i2) {
        observeExternalNavigationActions(flow, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void observeExternalNavigationActions(final Flow<? extends ExternalNavigationAction> flow, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(1430888900);
        ComposerKt.sourceInformation(startRestartGroup, "C(observeExternalNavigationActions)24@1140L7,25@1178L1197,25@1157L1218:ObserveExternalNavigationActions.kt#sjckhk");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(flow) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1430888900, i2, -1, "com.miami.game.core.external.navigation.ui.observeExternalNavigationActions (ObserveExternalNavigationActions.kt:23)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Context context = (Context) consume;
            startRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ObserveExternalNavigationActions.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(context);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit observeExternalNavigationActions$lambda$2$lambda$1;
                        observeExternalNavigationActions$lambda$2$lambda$1 = ObserveExternalNavigationActionsKt.observeExternalNavigationActions$lambda$2$lambda$1(context, (ExternalNavigationAction) obj);
                        return observeExternalNavigationActions$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            collectWithLifecycle(flow, (Function1) rememberedValue, startRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit observeExternalNavigationActions$lambda$3;
                    observeExternalNavigationActions$lambda$3 = ObserveExternalNavigationActionsKt.observeExternalNavigationActions$lambda$3(Flow.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return observeExternalNavigationActions$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeExternalNavigationActions$lambda$2$lambda$1(Context context, ExternalNavigationAction event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            Timber.Forest.e(new NotActivityContextNonFatalException("Calling composable function from not activity context"));
        } else if (event instanceof ExternalNavigationAction.OpenUri) {
            ExternalNavigationActivityExtensionsKt.openUri(activity, ((ExternalNavigationAction.OpenUri) event).getUri());
        } else if (event instanceof ExternalNavigationAction.SendText) {
            String text = ((ExternalNavigationAction.SendText) event).getText();
            if (!StringsKt.isBlank(text)) {
                ExternalNavigationActivityExtensionsKt.sendText(activity, text);
            }
        } else if (event instanceof ExternalNavigationAction.ShareImageWithDescription) {
            ExternalNavigationAction.ShareImageWithDescription shareImageWithDescription = (ExternalNavigationAction.ShareImageWithDescription) event;
            ExternalNavigationActivityExtensionsKt.shareImageUri(activity, shareImageWithDescription.getFileUri(), shareImageWithDescription.getDescription());
        } else if (event instanceof ExternalNavigationAction.OpenDeepLink) {
            ExternalNavigationAction.OpenDeepLink openDeepLink = (ExternalNavigationAction.OpenDeepLink) event;
            ExternalNavigationActivityExtensionsKt.openDeeplink(activity, openDeepLink.getDeeplinkUri(), openDeepLink.getDefaultPackageName());
        } else if (!(event instanceof ExternalNavigationAction.DialPhoneNumber)) {
            throw new NoWhenBranchMatchedException();
        } else {
            ExternalNavigationActivityExtensionsKt.dialPhoneNumber(activity, ((ExternalNavigationAction.DialPhoneNumber) event).getPhone());
        }
        return Unit.INSTANCE;
    }

    private static final <T> void collectWithLifecycle(final Flow<? extends T> flow, final Function1<? super T, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(557583643);
        ComposerKt.sourceInformation(startRestartGroup, "C(collectWithLifecycle)62@2505L7,63@2539L29,64@2614L121,64@2573L162:ObserveExternalNavigationActions.kt#sjckhk");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(flow) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(557583643, i2, -1, "com.miami.game.core.external.navigation.ui.collectWithLifecycle (ObserveExternalNavigationActions.kt:61)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, startRestartGroup, (i2 >> 3) & 14);
            Lifecycle lifecycle = lifecycleOwner.getLifecycle();
            startRestartGroup.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ObserveExternalNavigationActions.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(lifecycleOwner) | startRestartGroup.changedInstance(flow) | startRestartGroup.changed(rememberUpdatedState);
            ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ObserveExternalNavigationActionsKt$collectWithLifecycle$1$1(lifecycleOwner, flow, rememberUpdatedState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(lifecycle, (Function2) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit collectWithLifecycle$lambda$6;
                    collectWithLifecycle$lambda$6 = ObserveExternalNavigationActionsKt.collectWithLifecycle$lambda$6(Flow.this, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return collectWithLifecycle$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Function1<T, Unit> collectWithLifecycle$lambda$4(State<? extends Function1<? super T, Unit>> state) {
        return (Function1) ((Function1<? super T, Unit>) state.getValue());
    }
}
