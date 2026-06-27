package com.miami.game.feature.home.ui.compose;

import android.content.Context;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.design.system.component.background.Main_backgroundKt;
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
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u001e\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010\u000f\u001aé\u0001\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001b\f\b&\u0012\b\b'\u0012\u0004\b\u0003\u0010\u0004b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010%\u001aé\u0001\u0010(\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0001b\f\b&\u0012\b\b'\u0012\u0004\b\u0003\u0010\u0004b\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010%\u001aC\u0010)\u001a\u00020\u0001H\u0003b\"\b+\u0012\b\b,\u0012\u0004\b\u0003\u0010@\u0012\t\b-\u0012\u0005\b\u0003\u0010Ð\u0005\u0012\t\b.\u0012\u0005\b\u0003\u0010À\fb\u0002\b\u0010b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0002\u0010*¨\u0006/²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u0084\u0002"}, d2 = {"HomeRoute", "", "component", "Lcom/miami/game/feature/home/ui/HomeComponent;", "navigateToSettings", "Lkotlin/Function0;", "navigateToSelectServers", "navigateTooRepairGameSuccess", "navigateToDownloadDialog", "Lkotlin/Function1;", "", "navigateToDownloadScreen", "navigateToErrorDialog", "Lkotlin/Function2;", "navigateToNotification", "(Lcom/miami/game/feature/home/ui/HomeComponent;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/runtime/ComposableTarget;", "applier", "androidx.compose.ui.UiComposable", "HomeScreen", "uiState", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "notificationState", "Landroidx/compose/runtime/State;", "", "onClickGame", "onClickServer", "onClickShop", "onClickNews", "onClickSocial", "onClickAccount", "onClickForum", "onClickSettings", "onClickSetup", "onClickNotifications", "onLongClickGame", "(Lcom/miami/game/feature/home/ui/model/HomeUiState;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Landroidx/annotation/VisibleForTesting;", "otherwise", "HomeContent", "NewsItemUiPreview", "(Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/tooling/preview/Preview;", "uiMode", "heightDp", "widthDp", "home", "alpha", ""}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeScreenKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HomeContent$lambda$1(HomeUiState homeUiState, State state, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function1 function12, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, int i, int i2, Composer composer, int i3) {
        HomeContent(homeUiState, state, function0, function02, function03, function1, function12, function04, function05, function06, function07, function08, function09, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HomeRoute$lambda$13(HomeComponent homeComponent, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function0 function04, Function2 function2, Function0 function05, int i, Composer composer, int i2) {
        HomeRoute(homeComponent, function0, function02, function03, function1, function04, function2, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit HomeScreen$lambda$1(HomeUiState homeUiState, State state, Function0 function0, Function0 function02, Function0 function03, Function1 function1, Function1 function12, Function0 function04, Function0 function05, Function0 function06, Function0 function07, Function0 function08, Function0 function09, int i, int i2, Composer composer, int i3) {
        HomeScreen(homeUiState, state, function0, function02, function03, function1, function12, function04, function05, function06, function07, function08, function09, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit NewsItemUiPreview$lambda$0(int i, Composer composer, int i2) {
        NewsItemUiPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v16 */
    public static final void HomeRoute(final HomeComponent component, final Function0<Unit> navigateToSettings, final Function0<Unit> navigateToSelectServers, final Function0<Unit> navigateTooRepairGameSuccess, final Function1<? super String, Unit> navigateToDownloadDialog, final Function0<Unit> navigateToDownloadScreen, final Function2<? super Function0<Unit>, ? super String, Unit> navigateToErrorDialog, final Function0<Unit> navigateToNotification, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final Context context;
        int i3;
        String str;
        int i4;
        State state;
        int i5;
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
        ComposerKt.sourceInformation(startRestartGroup, "C(HomeRoute)N(component,navigateToSettings,navigateToSelectServers,navigateTooRepairGameSuccess,navigateToDownloadDialog,navigateToDownloadScreen,navigateToErrorDialog,navigateToNotification)48@2178L7,49@2223L29,50@2347L17,51@2425L1169,51@2388L1206,77@3635L34,82@3783L22,83@3831L24,84@3879L34,85@3937L22,86@3985L24,87@4036L25,88@4086L23,89@4137L26,90@4188L23,91@4244L30,92@4302L26,79@3675L659:HomeScreen.kt#dswm0d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? startRestartGroup.changed(component) : startRestartGroup.changedInstance(component) ? 4 : 2) | i;
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
        int i6 = 1;
        if (!startRestartGroup.shouldExecute((4793491 & i2) != 4793490, i2 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1774340913, i2, -1, "com.miami.game.feature.home.ui.compose.HomeRoute (HomeScreen.kt:47)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context2 = (Context) consume;
            State collectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(component.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, startRestartGroup, 0, 7);
            State observeAsState = LiveDataAdapterKt.observeAsState(component.getNotificationStateHolder().getViewModel().getNotificationsUnViewed(), 0, startRestartGroup, 48);
            SharedEventFlow<HomeUiAction> uiAction = component.getUiAction();
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 39622402, "CC(remember):HomeScreen.kt#9igjgp");
            boolean changed = ((i2 & 112) == 32) | ((i2 & 896) == 256) | ((57344 & i2) == 16384) | startRestartGroup.changed(collectAsStateWithLifecycle) | ((3670016 & i2) == 1048576);
            int i7 = i2 & 14;
            boolean changedInstance = changed | (i7 == 4 || ((i2 & 8) != 0 && startRestartGroup.changedInstance(component))) | ((i2 & 458752) == 131072) | ((i2 & 7168) == 2048) | ((29360128 & i2) == 8388608) | startRestartGroup.changedInstance(context2);
            HomeScreenKt$HomeRoute$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                context = context2;
                i3 = i7;
                str = "CC(remember):HomeScreen.kt#9igjgp";
                i4 = i2;
                state = collectAsStateWithLifecycle;
                i5 = 0;
                homeComponent = component;
                rememberedValue = new HomeScreenKt$HomeRoute$1$1(navigateToSettings, navigateToSelectServers, navigateToDownloadDialog, navigateToErrorDialog, component, navigateToDownloadScreen, navigateTooRepairGameSuccess, navigateToNotification, context, state, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                i3 = i7;
                i4 = i2;
                str = "CC(remember):HomeScreen.kt#9igjgp";
                state = collectAsStateWithLifecycle;
                i5 = 0;
                context = context2;
                homeComponent = component;
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            FlowExtensionsKt.collectInLaunchedEffectWithLifecycle(uiAction, objArr, null, null, (Function3) rememberedValue, composer2, 0, 6);
            ObserveExternalNavigationActionsKt.observeExternalNavigationActions(homeComponent.getExternalNavigationAction(), composer2, i5);
            HomeUiState HomeRoute$lambda$0 = HomeRoute$lambda$0(state);
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart(composer2, 39664711, str2);
            int i8 = i3;
            int i9 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$2$1 rememberedValue2 = composer2.rememberedValue();
            if (i9 != 0 || rememberedValue2 == Composer.Companion.getEmpty()) {
                rememberedValue2 = new HomeScreenKt$HomeRoute$2$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function0 = (Function0) ((KFunction) rememberedValue2);
            ComposerKt.sourceInformationMarkerStart(composer2, 39666249, str2);
            int i10 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$3$1 rememberedValue3 = composer2.rememberedValue();
            if (i10 != 0 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new HomeScreenKt$HomeRoute$3$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function02 = (Function0) ((KFunction) rememberedValue3);
            ComposerKt.sourceInformationMarkerStart(composer2, 39667795, str2);
            int changedInstance2 = composer2.changedInstance(context) | ((i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5);
            Object rememberedValue4 = composer2.rememberedValue();
            if (changedInstance2 != 0 || rememberedValue4 == Composer.Companion.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit HomeRoute$lambda$4$0;
                        HomeRoute$lambda$4$0 = HomeScreenKt.HomeRoute$lambda$4$0(HomeComponent.this, context);
                        return HomeRoute$lambda$4$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            Function0 function03 = rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 39669639, str2);
            int i11 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$5$1 rememberedValue5 = composer2.rememberedValue();
            if (i11 != 0 || rememberedValue5 == Composer.Companion.getEmpty()) {
                rememberedValue5 = new HomeScreenKt$HomeRoute$5$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function1 function1 = (Function1) ((KFunction) rememberedValue5);
            ComposerKt.sourceInformationMarkerStart(composer2, 39671177, str2);
            int i12 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$6$1 rememberedValue6 = composer2.rememberedValue();
            if (i12 != 0 || rememberedValue6 == Composer.Companion.getEmpty()) {
                rememberedValue6 = new HomeScreenKt$HomeRoute$6$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function1 function12 = (Function1) ((KFunction) rememberedValue6);
            ComposerKt.sourceInformationMarkerStart(composer2, 39672810, str2);
            int i13 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$7$1 rememberedValue7 = composer2.rememberedValue();
            if (i13 != 0 || rememberedValue7 == Composer.Companion.getEmpty()) {
                rememberedValue7 = new HomeScreenKt$HomeRoute$7$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function04 = (Function0) ((KFunction) rememberedValue7);
            ComposerKt.sourceInformationMarkerStart(composer2, 39674408, str2);
            int i14 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$8$1 rememberedValue8 = composer2.rememberedValue();
            if (i14 != 0 || rememberedValue8 == Composer.Companion.getEmpty()) {
                rememberedValue8 = new HomeScreenKt$HomeRoute$8$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function05 = (Function0) ((KFunction) rememberedValue8);
            ComposerKt.sourceInformationMarkerStart(composer2, 39676043, str2);
            int i15 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$9$1 rememberedValue9 = composer2.rememberedValue();
            if (i15 != 0 || rememberedValue9 == Composer.Companion.getEmpty()) {
                rememberedValue9 = new HomeScreenKt$HomeRoute$9$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function06 = (Function0) ((KFunction) rememberedValue9);
            ComposerKt.sourceInformationMarkerStart(composer2, 39677672, str2);
            int i16 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$10$1 rememberedValue10 = composer2.rememberedValue();
            if (i16 != 0 || rememberedValue10 == Composer.Companion.getEmpty()) {
                rememberedValue10 = new HomeScreenKt$HomeRoute$10$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function07 = (Function0) ((KFunction) rememberedValue10);
            ComposerKt.sourceInformationMarkerStart(composer2, 39679471, str2);
            int i17 = (i8 == 4 || ((i4 & 8) != 0 && composer2.changedInstance(homeComponent))) ? 1 : i5;
            HomeScreenKt$HomeRoute$11$1 rememberedValue11 = composer2.rememberedValue();
            if (i17 != 0 || rememberedValue11 == Composer.Companion.getEmpty()) {
                rememberedValue11 = new HomeScreenKt$HomeRoute$11$1(homeComponent);
                composer2.updateRememberedValue(rememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Function0 function08 = (Function0) ((KFunction) rememberedValue11);
            ComposerKt.sourceInformationMarkerStart(composer2, 39681323, str2);
            if (i8 != 4 && ((i4 & 8) == 0 || !composer2.changedInstance(homeComponent))) {
                i6 = i5;
            }
            HomeScreenKt$HomeRoute$12$1 rememberedValue12 = composer2.rememberedValue();
            if (i6 != 0 || rememberedValue12 == Composer.Companion.getEmpty()) {
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.HomeRoute$lambda$13(HomeComponent.this, navigateToSettings, navigateToSelectServers, navigateTooRepairGameSuccess, navigateToDownloadDialog, navigateToDownloadScreen, navigateToErrorDialog, navigateToNotification, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeRoute$lambda$4$0(HomeComponent homeComponent, Context context) {
        homeComponent.onClickShop(context);
        return Unit.INSTANCE;
    }

    public static final void HomeScreen(final HomeUiState uiState, final State<Integer> notificationState, final Function0<Unit> onClickGame, final Function0<Unit> onClickServer, final Function0<Unit> onClickShop, final Function1<? super String, Unit> onClickNews, final Function1<? super String, Unit> onClickSocial, final Function0<Unit> onClickAccount, final Function0<Unit> onClickForum, final Function0<Unit> onClickSettings, final Function0<Unit> onClickSetup, final Function0<Unit> onClickNotifications, final Function0<Unit> onLongClickGame, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
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
        ComposerKt.sourceInformation(startRestartGroup, "C(HomeScreen)N(uiState,notificationState,onClickGame,onClickServer,onClickShop,onClickNews,onClickSocial,onClickAccount,onClickForum,onClickSettings,onClickSetup,onClickNotifications,onLongClickGame)116@4891L2286:HomeScreen.kt#dswm0d");
        if ((i & 6) == 0) {
            i3 = i | (startRestartGroup.changed(uiState) ? 4 : 2);
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
            i3 |= startRestartGroup.changedInstance(onClickForum) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((805306368 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickSettings) ? 536870912 : 268435456;
        }
        int i5 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(onClickSetup) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(onClickNotifications) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(onLongClickGame) ? 256 : 128;
        }
        int i6 = i4;
        if (!startRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i6 & 147) == 146) ? false : true, i5 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(392307616, i5, i6, "com.miami.game.feature.home.ui.compose.HomeScreen (HomeScreen.kt:115)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1468743855, "C142@5717L166,152@5982L584,167@6588L259,178@6957L22,179@7003L72,175@6856L315:HomeScreen.kt#dswm0d");
            Main_backgroundKt.BackgroundImage(uiState.getBackGroundId(), false, uiState.getImageBitmap(), uiState.getFile(), uiState.getVersion(), startRestartGroup, 48);
            boolean z = (uiState.getFile() == null && uiState.getImageBitmap() == null) ? false : true;
            HomeContent(uiState, notificationState, onClickGame, onClickServer, onClickShop, onClickNews, onClickSocial, onClickAccount, onClickForum, onClickSettings, onClickSetup, onClickNotifications, onLongClickGame, startRestartGroup, 2147483646 & i5, i6 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED);
            final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 0.0f : 1.0f, AnimationSpecKt.tween$default(500, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, "bg_alpha", null, startRestartGroup, 3072, 20);
            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2030792900, "CC(remember):HomeScreen.kt#9igjgp");
            boolean changed = startRestartGroup.changed(animateFloatAsState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HomeScreen$lambda$0$1$0;
                        HomeScreen$lambda$0$1$0 = HomeScreenKt.HomeScreen$lambda$0$1$0(State.this, (GraphicsLayerScope) obj);
                        return HomeScreen$lambda$0$1$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            composer2 = startRestartGroup;
            ImageKt.Image(PainterResources_androidKt.painterResource(uiState.getBackGroundId(), startRestartGroup, 0), (String) null, GraphicsLayerModifierKt.graphicsLayer(fillMaxSize$default2, (Function1) rememberedValue), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, composer2, Painter.$stable | 24624, 104);
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.HomeScreen$lambda$1(HomeUiState.this, notificationState, onClickGame, onClickServer, onClickShop, onClickNews, onClickSocial, onClickAccount, onClickForum, onClickSettings, onClickSetup, onClickNotifications, onLongClickGame, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HomeScreen$lambda$0$1$0(State state, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setAlpha(HomeScreen$lambda$0$0(state));
        return Unit.INSTANCE;
    }

    public static final void HomeContent(final HomeUiState uiState, final State<Integer> notificationState, final Function0<Unit> onClickGame, final Function0<Unit> onClickServer, final Function0<Unit> onClickShop, final Function1<? super String, Unit> onClickNews, final Function1<? super String, Unit> onClickSocial, final Function0<Unit> onClickAccount, final Function0<Unit> onClickForum, final Function0<Unit> onClickSettings, final Function0<Unit> onClickSetup, final Function0<Unit> onClickNotifications, final Function0<Unit> onLongClickGame, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
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
        ComposerKt.sourceInformation(startRestartGroup, "C(HomeContent)N(uiState,notificationState,onClickGame,onClickServer,onClickShop,onClickNews,onClickSocial,onClickAccount,onClickForum,onClickSettings,onClickSetup,onClickNotifications,onLongClickGame)205@7703L1307:HomeScreen.kt#dswm0d");
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
            i3 |= startRestartGroup.changedInstance(onClickForum) ? 67108864 : GroupFlagsKt.HasAuxSlotFlag;
        }
        if ((805306368 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(onClickSettings) ? 536870912 : 268435456;
        }
        int i5 = i3;
        if ((i2 & 48) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(onClickNotifications) ? 32 : 16);
        } else {
            i4 = i2;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= startRestartGroup.changedInstance(onLongClickGame) ? 256 : 128;
        }
        int i6 = i4;
        if (!startRestartGroup.shouldExecute(((306783379 & i5) == 306783378 && (i6 & 145) == 144) ? false : true, i5 & 1)) {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258468589, i5, i6, "com.miami.game.feature.home.ui.compose.HomeContent (HomeScreen.kt:204)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl, Integer.valueOf(hashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -637544234, "C210@7814L523,225@8346L382,236@8738L266:HomeScreen.kt#dswm0d");
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m1054paddingqDBjuR0$default(boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getCenterStart()), Dp.m8160constructorimpl(32.0f), 0.0f, 0.0f, Dp.m8160constructorimpl(16.0f), 6, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), startRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl2 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl2, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl2, Integer.valueOf(hashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1749381735, "C215@8028L110,219@8151L104,223@8268L59:HomeScreen.kt#dswm0d");
            int i7 = i5 & 14;
            int i8 = i5 >> 15;
            SocialContentKt.SocialContent(uiState, onClickSocial, startRestartGroup, (i8 & 112) | i7);
            NewsContentKt.NewsContent(uiState, onClickNews, startRestartGroup, ((i5 >> 12) & 112) | i7);
            ShopContentKt.ShopContent(uiState.getXDonate(), uiState.isArizona(), onClickShop, startRestartGroup, (i5 >> 6) & 896);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier align = boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getTopEnd());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4467constructorimpl3 = Updater.m4467constructorimpl(startRestartGroup);
            Updater.m4475setimpl(m4467constructorimpl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl3, Integer.valueOf(hashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1659112318, "C226@8398L320:HomeScreen.kt#dswm0d");
            MenuContentKt.MenuContent(uiState, notificationState, onClickAccount, onClickForum, onClickSettings, onClickNotifications, startRestartGroup, (i5 & WebSocketProtocol.PAYLOAD_SHORT) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | ((i6 << 12) & 458752));
            composer2 = startRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier align2 = boxScopeInstance.align(Modifier.Companion, Alignment.Companion.getBottomEnd());
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int hashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, align2);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer m4467constructorimpl4 = Updater.m4467constructorimpl(composer2);
            Updater.m4475setimpl(m4467constructorimpl4, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4475setimpl(m4467constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.m4475setimpl(m4467constructorimpl4, Integer.valueOf(hashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.m4473reconcileimpl(m4467constructorimpl4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.m4475setimpl(m4467constructorimpl4, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 863299728, "C237@8793L201:HomeScreen.kt#dswm0d");
            int i9 = i5 >> 3;
            PlayContentKt.PlayContent(uiState, onClickGame, onClickServer, onLongClickGame, composer2, (i9 & 896) | i7 | (i9 & 112) | ((i6 << 3) & 7168));
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
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.HomeContent$lambda$1(HomeUiState.this, notificationState, onClickGame, onClickServer, onClickShop, onClickNews, onClickSocial, onClickAccount, onClickForum, onClickSettings, onClickSetup, onClickNotifications, onLongClickGame, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void NewsItemUiPreview(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(1764360146);
        ComposerKt.sourceInformation(startRestartGroup, "C(NewsItemUiPreview)253@9165L464:HomeScreen.kt#dswm0d");
        if (!startRestartGroup.shouldExecute(i != 0, i & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1764360146, i, -1, "com.miami.game.feature.home.ui.compose.NewsItemUiPreview (HomeScreen.kt:251)");
            }
            BoxKt.Box(PaddingKt.m1050padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null), Dp.m8160constructorimpl(36.0f)), startRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.miami.game.feature.home.ui.compose.HomeScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HomeScreenKt.NewsItemUiPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HomeUiState HomeRoute$lambda$0(State<HomeUiState> state) {
        return state.getValue();
    }

    private static final float HomeScreen$lambda$0$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
