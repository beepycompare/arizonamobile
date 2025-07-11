package com.miami.game.feature.home.ui.compose;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.external.navigation.ui.ObserveExternalNavigationActionsKt;
import com.miami.game.core.ui.utils.extensions.FlowExtensionsKt;
import com.miami.game.feature.home.ui.HomeComponent;
import com.miami.game.feature.home.ui.model.HomeUiAction;
import com.miami.game.feature.home.ui.model.HomeUiState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: HomeScreen.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u001e\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000f\u001aÉ\u0001\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010!\u001aÉ\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010!\u001a\r\u0010#\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010$¨\u0006%²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"HomeRoute", "", "component", "Lcom/miami/game/feature/home/ui/HomeComponent;", "navigateToSettings", "Lkotlin/Function0;", "navigateToSelectServers", "navigateTooRepairGameSuccess", "navigateToDownloadDialog", "Lkotlin/Function1;", "", "navigateToDownloadScreen", "navigateToErrorDialog", "Lkotlin/Function2;", "navigateToNotification", "(Lcom/miami/game/feature/home/ui/HomeComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "HomeScreen", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "notificationState", "Landroidx/compose/runtime/State;", "", "onClickGame", "onClickServer", "onClickShop", "onClickNews", "onClickSocial", "onClickAccount", "onClickForum", "onClickSettings", "onClickSetup", "onClickNotifications", "onLongClickGame", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "HomeContent", "NewsItemUiPreview", "(Landroidx/compose/runtime/Composer;I)V", "home_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeContent$lambda$21(HomeUiState homeUiState, State state, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function1 function12, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, int i, int i2, Composer composer, int i3) {
        HomeContent(homeUiState, state, function0, function02, function03, function1, function12, function04, function05, function06, function07, function08, function09, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeRoute$lambda$14(HomeComponent homeComponent, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function0 function04, Function2 function2, Function0 function05, int i, Composer composer, int i2) {
        HomeRoute(homeComponent, function0, function02, function03, function1, function04, function2, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$16(HomeUiState homeUiState, State state, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function1 function12, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, int i, int i2, Composer composer, int i3) {
        HomeScreen(homeUiState, state, function0, function02, function03, function1, function12, function04, function05, function06, function07, function08, function09, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NewsItemUiPreview$lambda$22(int i, Composer composer, int i2) {
        NewsItemUiPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    public static final void HomeRoute(final HomeComponent component, final Function0<Unit> navigateToSettings, final Function0<Unit> navigateToSelectServers, final Function0<Unit> navigateTooRepairGameSuccess, final Function1<? super String, Unit> navigateToDownloadDialog, final Function0<Unit> navigateToDownloadScreen, final Function2<? super Function0<Unit>, ? super String, Unit> navigateToErrorDialog, final Function0<Unit> navigateToNotification, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Context context;
        String str;
        State state;
        int i3;
        final HomeComponent homeComponent;
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(navigateToSettings, "navigateToSettings");
        Intrinsics.checkNotNullParameter(navigateToSelectServers, "navigateToSelectServers");
        Intrinsics.checkNotNullParameter(navigateTooRepairGameSuccess, "navigateTooRepairGameSuccess");
        Intrinsics.checkNotNullParameter(navigateToDownloadDialog, "navigateToDownloadDialog");
        Intrinsics.checkNotNullParameter(navigateToDownloadScreen, "navigateToDownloadScreen");
        Intrinsics.checkNotNullParameter(navigateToErrorDialog, "navigateToErrorDialog");
        Intrinsics.checkNotNullParameter(navigateToNotification, "navigateToNotification");
        Composer startRestartGroup = composer.startRestartGroup(1774340913);
        ComposerKt.sourceInformation(startRestartGroup, "C(HomeRoute)P(!1,6,5,7)42@1841L7,43@1886L29,44@2010L17,45@2088L920,45@2051L957,64@3049L34,69@3197L22,70@3245L24,71@3293L34,72@3351L22,73@3399L24,74@3450L25,75@3500L23,76@3551L26,77@3602L23,78@3658L30,79@3716L26,66@3089L659:HomeScreen.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(component) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToSettings) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToSelectServers) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateTooRepairGameSuccess) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToDownloadDialog) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToDownloadScreen) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToErrorDialog) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(navigateToNotification) ? 8388608 : 4194304;
        }
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1774340913, i2, -1, "com.miami.game.feature.home.ui.compose.HomeRoute (HomeScreen.kt:41)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context2 = (Context) consume;
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State observeAsState = LiveDataAdapterKt.observeAsState(component.getNotificationStateHolder().getViewModel().getNotificationsUnViewed(), 0, startRestartGroup, 48);
            SharedEventFlow<HomeUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 39622537, "CC(remember):HomeScreen.kt#9igjgp");
            boolean changed = ((458752 & i2) == 131072) | ((i2 & 112) == 32) | ((i2 & 896) == 256) | ((57344 & i2) == 16384) | startRestartGroup.changed(collectAsStateWithLifecycle) | ((3670016 & i2) == 1048576) | startRestartGroup.changedInstance(component) | ((i2 & 7168) == 2048) | ((29360128 & i2) == 8388608) | startRestartGroup.changedInstance(context2);
            HomeScreenKt$HomeRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                context = context2;
                str = "CC(remember):HomeScreen.kt#9igjgp";
                state = collectAsStateWithLifecycle;
                i3 = 0;
                homeComponent = component;
                rememberedValue = new HomeScreenKt$HomeRoute$1$1(navigateToSettings, navigateToSelectServers, navigateToDownloadDialog, navigateToErrorDialog, component, navigateToDownloadScreen, navigateTooRepairGameSuccess, navigateToNotification, context, state, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                context = context2;
                str = "CC(remember):HomeScreen.kt#9igjgp";
                state = collectAsStateWithLifecycle;
                i3 = 0;
                homeComponent = component;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, composer2, 0, 6);
            ObserveExternalNavigationActionsKt.observeExternalNavigationActions(homeComponent.getExternalNavigationAction(), composer2, i3);
            HomeUiState HomeRoute$lambda$0 = HomeRoute$lambda$0(state);
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart(composer2, 39657127, str2);
            boolean changedInstance = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$2$1 rememberedValue2 = composer2.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new HomeScreenKt$HomeRoute$2$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composer2, 39658665, str2);
            boolean changedInstance2 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$3$1 rememberedValue3 = composer2.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new HomeScreenKt$HomeRoute$3$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function02 = (Function0) ((KFunction) rememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer2, 39660211, str2);
            boolean changedInstance3 = composer2.changedInstance(homeComponent) | composer2.changedInstance(context);
            Object rememberedValue4 = composer2.rememberedValue();
            if (changedInstance3 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HomeRoute$lambda$5$lambda$4;
                        HomeRoute$lambda$5$lambda$4 = HomeScreenKt.HomeRoute$lambda$5$lambda$4(HomeComponent.this, context);
                        return HomeRoute$lambda$5$lambda$4;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            Function0 function03 = rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 39662055, str2);
            boolean changedInstance4 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$5$1 rememberedValue5 = composer2.rememberedValue();
            if (changedInstance4 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new HomeScreenKt$HomeRoute$5$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function1 function1 = (Function1) ((KFunction) rememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composer2, 39663593, str2);
            boolean changedInstance5 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$6$1 rememberedValue6 = composer2.rememberedValue();
            if (changedInstance5 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new HomeScreenKt$HomeRoute$6$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function1 function12 = (Function1) ((KFunction) rememberedValue6);
            ComposerKt.sourceInformationMarkerStart(composer2, 39665226, str2);
            boolean changedInstance6 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$7$1 rememberedValue7 = composer2.rememberedValue();
            if (changedInstance6 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new HomeScreenKt$HomeRoute$7$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function04 = (Function0) ((KFunction) rememberedValue7);
            ComposerKt.sourceInformationMarkerStart(composer2, 39666824, str2);
            boolean changedInstance7 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$8$1 rememberedValue8 = composer2.rememberedValue();
            if (changedInstance7 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new HomeScreenKt$HomeRoute$8$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function05 = (Function0) ((KFunction) rememberedValue8);
            ComposerKt.sourceInformationMarkerStart(composer2, 39668459, str2);
            boolean changedInstance8 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$9$1 rememberedValue9 = composer2.rememberedValue();
            if (changedInstance8 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new HomeScreenKt$HomeRoute$9$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function06 = (Function0) ((KFunction) rememberedValue9);
            ComposerKt.sourceInformationMarkerStart(composer2, 39670088, str2);
            boolean changedInstance9 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$10$1 rememberedValue10 = composer2.rememberedValue();
            if (changedInstance9 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new HomeScreenKt$HomeRoute$10$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function07 = (Function0) ((KFunction) rememberedValue10);
            ComposerKt.sourceInformationMarkerStart(composer2, 39671887, str2);
            boolean changedInstance10 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$11$1 rememberedValue11 = composer2.rememberedValue();
            if (changedInstance10 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new HomeScreenKt$HomeRoute$11$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function08 = (Function0) ((KFunction) rememberedValue11);
            ComposerKt.sourceInformationMarkerStart(composer2, 39673739, str2);
            boolean changedInstance11 = composer2.changedInstance(homeComponent);
            HomeScreenKt$HomeRoute$12$1 rememberedValue12 = composer2.rememberedValue();
            if (changedInstance11 || rememberedValue12 == Composer.Companion.getEmpty()) {
                rememberedValue12 = new HomeScreenKt$HomeRoute$12$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            HomeScreen(HomeRoute$lambda$0, observeAsState, function0, function02, function03, function1, function12, function04, function05, function06, function07, function08, (Function0) ((KFunction) rememberedValue12), composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HomeRoute$lambda$14;
                    HomeRoute$lambda$14 = HomeScreenKt.HomeRoute$lambda$14(HomeComponent.this, navigateToSettings, navigateToSelectServers, navigateTooRepairGameSuccess, navigateToDownloadDialog, navigateToDownloadScreen, navigateToErrorDialog, navigateToNotification, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HomeRoute$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeRoute$lambda$5$lambda$4(HomeComponent homeComponent, Context context) {
        homeComponent.onClickShop(context);
        return Unit.INSTANCE;
    }

    public static final void HomeScreen(final HomeUiState uiState, final State<Integer> notificationState, final Function0<Unit> onClickGame, final Function0<Unit> onClickServer, final Function0<Unit> onClickShop, final Function1<? super String, Unit> onClickNews, final Function1<? super String, Unit> onClickSocial, final Function0<Unit> onClickAccount, final Function0<Unit> onClickForum, final Function0<Unit> onClickSettings, final Function0<Unit> onClickSetup, final Function0<Unit> onClickNotifications, final Function0<Unit> onLongClickGame, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Composer composer2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(notificationState, "notificationState");
        Intrinsics.checkNotNullParameter(onClickGame, "onClickGame");
        Intrinsics.checkNotNullParameter(onClickServer, "onClickServer");
        Intrinsics.checkNotNullParameter(onClickShop, "onClickShop");
        Intrinsics.checkNotNullParameter(onClickNews, "onClickNews");
        Intrinsics.checkNotNullParameter(onClickSocial, "onClickSocial");
        Intrinsics.checkNotNullParameter(onClickAccount, "onClickAccount");
        Intrinsics.checkNotNullParameter(onClickForum, "onClickForum");
        Intrinsics.checkNotNullParameter(onClickSettings, "onClickSettings");
        Intrinsics.checkNotNullParameter(onClickSetup, "onClickSetup");
        Intrinsics.checkNotNullParameter(onClickNotifications, "onClickNotifications");
        Intrinsics.checkNotNullParameter(onLongClickGame, "onLongClickGame");
        Composer startRestartGroup = composer.startRestartGroup(392307616);
        ComposerKt.sourceInformation(startRestartGroup, "C(HomeScreen)P(12!1,3,6,9,4,10!2,7,8)103@4305L713:HomeScreen.kt#dswm0d");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(notificationState) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickGame) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickServer) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickShop) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickNews) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickSocial) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickAccount) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickForum) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickSettings) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(onClickSetup) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickNotifications) ? 32 : 16;
        }
        int i6 = i4;
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 = i6 | (startRestartGroup.changedInstance(onLongClickGame) ? 256 : 128);
        } else {
            i5 = i6;
        }
        if (!startRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 147) == 146) ? false : true, i3 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(392307616, i3, i5, "com.miami.game.feature.home.ui.compose.HomeScreen (HomeScreen.kt:102)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1467974342, "C107@4381L37,109@4428L584:HomeScreen.kt#dswm0d");
            ImagesKt.BackgroundImage(uiState.getBackGroundId(), startRestartGroup, 0);
            composer2 = startRestartGroup;
            HomeContent(uiState, notificationState, onClickGame, onClickServer, onClickShop, onClickNews, onClickSocial, onClickAccount, onClickForum, onClickSettings, onClickSetup, onClickNotifications, onLongClickGame, composer2, 2147483646 & i3, i5 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HomeScreen$lambda$16;
                    HomeScreen$lambda$16 = HomeScreenKt.HomeScreen$lambda$16(HomeUiState.this, notificationState, onClickGame, onClickServer, onClickShop, onClickNews, onClickSocial, onClickAccount, onClickForum, onClickSettings, onClickSetup, onClickNotifications, onLongClickGame, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return HomeScreen$lambda$16;
                }
            });
        }
    }

    public static final void HomeContent(final HomeUiState uiState, final State<Integer> notificationState, final Function0<Unit> onClickGame, final Function0<Unit> onClickServer, final Function0<Unit> onClickShop, final Function1<? super String, Unit> onClickNews, final Function1<? super String, Unit> onClickSocial, final Function0<Unit> onClickAccount, final Function0<Unit> onClickForum, final Function0<Unit> onClickSettings, final Function0<Unit> onClickSetup, final Function0<Unit> onClickNotifications, final Function0<Unit> onLongClickGame, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Composer composer2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(notificationState, "notificationState");
        Intrinsics.checkNotNullParameter(onClickGame, "onClickGame");
        Intrinsics.checkNotNullParameter(onClickServer, "onClickServer");
        Intrinsics.checkNotNullParameter(onClickShop, "onClickShop");
        Intrinsics.checkNotNullParameter(onClickNews, "onClickNews");
        Intrinsics.checkNotNullParameter(onClickSocial, "onClickSocial");
        Intrinsics.checkNotNullParameter(onClickAccount, "onClickAccount");
        Intrinsics.checkNotNullParameter(onClickForum, "onClickForum");
        Intrinsics.checkNotNullParameter(onClickSettings, "onClickSettings");
        Intrinsics.checkNotNullParameter(onClickSetup, "onClickSetup");
        Intrinsics.checkNotNullParameter(onClickNotifications, "onClickNotifications");
        Intrinsics.checkNotNullParameter(onLongClickGame, "onLongClickGame");
        Composer startRestartGroup = composer.startRestartGroup(258468589);
        ComposerKt.sourceInformation(startRestartGroup, "C(HomeContent)P(12!1,3,6,9,4,10!2,7,8)144@5544L1307:HomeScreen.kt#dswm0d");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(uiState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i3;
        if ((i & 48) == 0) {
            i4 = i6 | (startRestartGroup.changed(notificationState) ? 32 : 16);
        } else {
            i4 = i6;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickGame) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickServer) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickShop) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickNews) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickSocial) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickAccount) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickForum) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickSettings) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i7 = i4;
        if ((i2 & 48) == 0) {
            i5 = i2 | (startRestartGroup.changedInstance(onClickNotifications) ? 32 : 16);
        } else {
            i5 = i2;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= startRestartGroup.changedInstance(onLongClickGame) ? 256 : 128;
        }
        int i8 = i5;
        if (!startRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (i8 & 145) == 144) ? false : true, i7 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258468589, i7, i8, "com.miami.game.feature.home.ui.compose.HomeContent (HomeScreen.kt:143)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl.getInserting() || !Intrinsics.areEqual(m3520constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3520constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3520constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3527setimpl(m3520constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -637544234, "C149@5655L523,164@6187L382,175@6579L266:HomeScreen.kt#dswm0d");
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m742paddingqDBjuR0$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getCenterStart()), Dp.m6684constructorimpl(32), 0.0f, 0.0f, Dp.m6684constructorimpl(16), 6, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl2 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl2.getInserting() || !Intrinsics.areEqual(m3520constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m3520constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m3520constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3527setimpl(m3520constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1749381735, "C154@5869L110,158@5992L104,162@6109L59:HomeScreen.kt#dswm0d");
            int i9 = i7 & 14;
            int i10 = i7 >> 15;
            SocialContentKt.SocialContent(uiState, onClickSocial, startRestartGroup, (i10 & 112) | i9);
            NewsContentKt.NewsContent(uiState, onClickNews, startRestartGroup, ((i7 >> 12) & 112) | i9);
            ShopContentKt.ShopContent(uiState.getXDonate(), uiState.isArizona(), onClickShop, startRestartGroup, (i7 >> 6) & 896);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier align = boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getTopEnd());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3520constructorimpl3 = Updater.m3520constructorimpl(startRestartGroup);
            Updater.m3527setimpl(m3520constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl3.getInserting() || !Intrinsics.areEqual(m3520constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m3520constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m3520constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3527setimpl(m3520constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1659112318, "C165@6239L320:HomeScreen.kt#dswm0d");
            MenuContentKt.MenuContent(uiState, notificationState, onClickAccount, onClickForum, onClickSettings, onClickNotifications, startRestartGroup, (i7 & WebSocketProtocol.PAYLOAD_SHORT) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | ((i8 << 12) & 458752));
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier align2 = boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomEnd());
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, align2);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer m3520constructorimpl4 = Updater.m3520constructorimpl(composer2);
            Updater.m3527setimpl(m3520constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m3527setimpl(m3520constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m3520constructorimpl4.getInserting() || !Intrinsics.areEqual(m3520constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m3520constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m3520constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3527setimpl(m3520constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 863299728, "C176@6634L201:HomeScreen.kt#dswm0d");
            int i11 = i7 >> 3;
            PlayContentKt.PlayContent(uiState, onClickGame, onClickServer, onLongClickGame, composer2, (i11 & 896) | i9 | (i11 & 112) | ((i8 << 3) & 7168));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HomeContent$lambda$21;
                    HomeContent$lambda$21 = HomeScreenKt.HomeContent$lambda$21(HomeUiState.this, notificationState, onClickGame, onClickServer, onClickShop, onClickNews, onClickSocial, onClickAccount, onClickForum, onClickSettings, onClickSetup, onClickNotifications, onLongClickGame, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return HomeContent$lambda$21;
                }
            });
        }
    }

    private static final void NewsItemUiPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1764360146);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewsItemUiPreview)192@7006L464:HomeScreen.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1764360146, i, -1, "com.miami.game.feature.home.ui.compose.NewsItemUiPreview (HomeScreen.kt:190)");
            }
            BoxKt.Box(PaddingKt.m738padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m6684constructorimpl(36)), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NewsItemUiPreview$lambda$22;
                    NewsItemUiPreview$lambda$22 = HomeScreenKt.NewsItemUiPreview$lambda$22(i, (Composer) obj, ((Integer) obj2).intValue());
                    return NewsItemUiPreview$lambda$22;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeUiState HomeRoute$lambda$0(State<HomeUiState> state) {
        return state.getValue();
    }
}
