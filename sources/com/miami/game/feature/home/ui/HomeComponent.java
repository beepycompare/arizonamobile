package com.miami.game.feature.home.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.arkivanov.decompose.ComponentContext;
import com.arkivanov.decompose.ComponentContextFactory;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.miami.game.core.api.model.response.HwVersion;
import com.miami.game.core.api.network.NetworkDataSource;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.decompose.utils.CoroutineFeature;
import com.miami.game.core.decompose.utils.CoroutineFeatureImpl;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.external.navigation.model.ExternalNavigationAction;
import com.miami.game.core.news.domain.NewsInteractor;
import com.miami.game.core.privacy.privacyInteractor;
import com.miami.game.core.server.ServersInteractor;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.settings.SettingsInteractor;
import com.miami.game.core.ui.utils.extensions.ExtensionsBrowseKt;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder;
import com.miami.game.feature.home.ui.model.HomeExternalUiStateHolder;
import com.miami.game.feature.home.ui.model.HomeUiAction;
import com.miami.game.feature.home.ui.model.HomeUiState;
import com.miami.game.feature.notifications.NotificationStateHolder;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import io.appmetrica.analytics.AppMetrica;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;
/* compiled from: HomeComponent.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001gBK\b\u0001\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\b\u00100\u001a\u00020'H\u0002J\u000e\u00101\u001a\u00020'H\u0082@¢\u0006\u0002\u00102J\b\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u00020'H\u0002J\b\u00106\u001a\u00020'H\u0002J\b\u00107\u001a\u00020'H\u0002J\u0006\u00108\u001a\u00020'J\u0006\u00109\u001a\u00020'J\u0006\u0010:\u001a\u00020'J\u000e\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020+J\u0006\u0010@\u001a\u00020'J\u000e\u0010A\u001a\u00020'2\u0006\u0010?\u001a\u00020+J\u0006\u0010B\u001a\u00020'J\u0006\u0010C\u001a\u00020'J\u0006\u0010D\u001a\u00020'J\u0006\u0010E\u001a\u00020'J\b\u0010F\u001a\u00020'H\u0002J\b\u0010G\u001a\u00020'H\u0002J\u0014\u0010H\u001a\u00020'2\n\u0010I\u001a\u00060Jj\u0002`KH\u0002J\u0010\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020\u001fH\u0002J\u0010\u0010N\u001a\u00020'2\u0006\u0010M\u001a\u00020#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0012\u0010O\u001a\u00020PX\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0018\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010TX\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0012\u0010W\u001a\u00020XX\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0012\u0010[\u001a\u00020\\X\u0096\u0005¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0012\u0010_\u001a\u00020`X\u0096\u0005¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0012\u0010c\u001a\u00020dX\u0096\u0005¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006h"}, d2 = {"Lcom/miami/game/feature/home/ui/HomeComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "componentContext", "privacyInteractor", "Lcom/miami/game/core/privacy/privacyInteractor;", "newsInteractor", "Lcom/miami/game/core/news/domain/NewsInteractor;", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "api", "Lcom/miami/game/core/api/network/NetworkDataSource;", "serversInteractor", "Lcom/miami/game/core/server/ServersInteractor;", "settingsInteractor", "Lcom/miami/game/core/settings/SettingsInteractor;", "notificationStateHolder", "Lcom/miami/game/feature/notifications/NotificationStateHolder;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/core/privacy/privacyInteractor;Lcom/miami/game/core/news/domain/NewsInteractor;Lcom/miami/game/core/build/config/BuildConfigRepository;Lcom/miami/game/core/api/network/NetworkDataSource;Lcom/miami/game/core/server/ServersInteractor;Lcom/miami/game/core/settings/SettingsInteractor;Lcom/miami/game/feature/notifications/NotificationStateHolder;)V", "getNotificationStateHolder", "()Lcom/miami/game/feature/notifications/NotificationStateHolder;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/home/ui/model/HomeUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/home/ui/model/HomeUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "externalNavigationAction", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "getExternalNavigationAction", "onRetry", "Lkotlin/Function0;", "", "getOnRetry", "()Lkotlin/jvm/functions/Function0;", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "initVmState", "checkHwVersion", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeHw", "prepareNews", "observeExternal", "observeSettings", "observerServersState", "onClickGame", "onLongClickGame", "onClickServer", "onClickShop", "context", "Landroid/content/Context;", "onClickNews", "url", "onClickNotification", "onClickSocial", "onClickAccount", "onClickForum", "onClickSettings", "onClickSetup", "onStartDownloadGame", "onCancelDownloadGame", "handleError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "emitUiAction", "action", "emitExternalNavigationAction", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "home_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HomeComponent implements ComponentContext, CoroutineFeature {
    public static final int $stable = 8;
    private final /* synthetic */ ComponentContext $$delegate_0;
    private final /* synthetic */ CoroutineFeatureImpl $$delegate_1;
    private final NetworkDataSource api;
    private final BuildConfigRepository buildConfig;
    private String errorMessage;
    private final SharedEventFlow<ExternalNavigationAction> externalNavigationAction;
    private final NewsInteractor newsInteractor;
    private final NotificationStateHolder notificationStateHolder;
    private final Function0<Unit> onRetry;
    private final privacyInteractor privacyInteractor;
    private final ServersInteractor serversInteractor;
    private final SettingsInteractor settingsInteractor;
    private final MutableStateFlow<HomeUiState> stateStore;
    private final SharedEventFlow<HomeUiAction> uiAction;
    private final StateFlow<HomeUiState> uiState;

    /* compiled from: HomeComponent.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006"}, d2 = {"Lcom/miami/game/feature/home/ui/HomeComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/home/ui/HomeComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "home_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Factory {
        HomeComponent invoke(ComponentContext componentContext);
    }

    @Override // com.arkivanov.essenty.backhandler.BackHandlerOwner
    public BackHandler getBackHandler() {
        return this.$$delegate_0.getBackHandler();
    }

    @Override // com.arkivanov.decompose.ComponentContextFactoryOwner
    public ComponentContextFactory<ComponentContext> getComponentContextFactory() {
        return this.$$delegate_0.getComponentContextFactory();
    }

    @Override // com.arkivanov.essenty.instancekeeper.InstanceKeeperOwner
    public InstanceKeeper getInstanceKeeper() {
        return this.$$delegate_0.getInstanceKeeper();
    }

    @Override // com.arkivanov.essenty.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.$$delegate_0.getLifecycle();
    }

    @Override // com.miami.game.core.decompose.utils.CoroutineFeature
    public CoroutineScope getScope() {
        return this.$$delegate_1.getScope();
    }

    @Override // com.arkivanov.essenty.statekeeper.StateKeeperOwner
    public StateKeeper getStateKeeper() {
        return this.$$delegate_0.getStateKeeper();
    }

    @AssistedInject
    public HomeComponent(@Assisted ComponentContext componentContext, privacyInteractor privacyInteractor, NewsInteractor newsInteractor, BuildConfigRepository buildConfig, NetworkDataSource api, ServersInteractor serversInteractor, SettingsInteractor settingsInteractor, NotificationStateHolder notificationStateHolder) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(privacyInteractor, "privacyInteractor");
        Intrinsics.checkNotNullParameter(newsInteractor, "newsInteractor");
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(serversInteractor, "serversInteractor");
        Intrinsics.checkNotNullParameter(settingsInteractor, "settingsInteractor");
        Intrinsics.checkNotNullParameter(notificationStateHolder, "notificationStateHolder");
        this.$$delegate_0 = componentContext;
        this.$$delegate_1 = new CoroutineFeatureImpl(componentContext);
        this.privacyInteractor = privacyInteractor;
        this.newsInteractor = newsInteractor;
        this.buildConfig = buildConfig;
        this.api = api;
        this.serversInteractor = serversInteractor;
        this.settingsInteractor = settingsInteractor;
        this.notificationStateHolder = notificationStateHolder;
        MutableStateFlow<HomeUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(HomeUiState.Companion.initial(buildConfig.isArizona(), buildConfig.isHw()));
        this.stateStore = MutableStateFlow;
        this.uiState = FlowKt.stateIn(FlowKt.asStateFlow(MutableStateFlow), getScope(), SharingStarted.Companion.getEagerly(), HomeUiState.Companion.initial(buildConfig.isArizona(), buildConfig.isHw()));
        this.uiAction = new SharedEventFlow<>();
        this.externalNavigationAction = new SharedEventFlow<>();
        this.onRetry = new Function0() { // from class: com.miami.game.feature.home.ui.HomeComponent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit onRetry$lambda$0;
                onRetry$lambda$0 = HomeComponent.onRetry$lambda$0(HomeComponent.this);
                return onRetry$lambda$0;
            }
        };
        this.errorMessage = "";
        initVmState();
        observeHw();
        observeExternal();
        observerServersState();
        prepareNews();
        observeSettings();
    }

    public final NotificationStateHolder getNotificationStateHolder() {
        return this.notificationStateHolder;
    }

    public final StateFlow<HomeUiState> getUiState() {
        return this.uiState;
    }

    public final SharedEventFlow<HomeUiAction> getUiAction() {
        return this.uiAction;
    }

    public final SharedEventFlow<ExternalNavigationAction> getExternalNavigationAction() {
        return this.externalNavigationAction;
    }

    public final Function0<Unit> getOnRetry() {
        return this.onRetry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRetry$lambda$0(HomeComponent homeComponent) {
        homeComponent.serversInteractor.retry();
        homeComponent.newsInteractor.retry();
        homeComponent.initVmState();
        return Unit.INSTANCE;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMessage = str;
    }

    private final void initVmState() {
        Timber.Forest.d("initVmState", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new HomeComponent$initVmState$$inlined$launchSafe$default$1(null, this, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r6 == r1) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.miami.game.feature.home.ui.HomeComponent$checkHwVersion$2(r5, null), r0) == r1) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object checkHwVersion(Continuation<? super Unit> continuation) {
        HomeComponent$checkHwVersion$1 homeComponent$checkHwVersion$1;
        Object obj;
        int i;
        if (continuation instanceof HomeComponent$checkHwVersion$1) {
            homeComponent$checkHwVersion$1 = (HomeComponent$checkHwVersion$1) continuation;
            if ((homeComponent$checkHwVersion$1.label & Integer.MIN_VALUE) != 0) {
                homeComponent$checkHwVersion$1.label -= Integer.MIN_VALUE;
                obj = homeComponent$checkHwVersion$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = homeComponent$checkHwVersion$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NetworkDataSource networkDataSource = this.api;
                    homeComponent$checkHwVersion$1.label = 1;
                    obj = networkDataSource.getHwVersion(homeComponent$checkHwVersion$1);
                } else if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                if (this.buildConfig.getVersionCode() <= ((HwVersion) obj).getAllowVersion()) {
                    return Unit.INSTANCE;
                }
                homeComponent$checkHwVersion$1.label = 2;
            }
        }
        homeComponent$checkHwVersion$1 = new HomeComponent$checkHwVersion$1(this, continuation);
        obj = homeComponent$checkHwVersion$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = homeComponent$checkHwVersion$1.label;
        if (i != 0) {
        }
        if (this.buildConfig.getVersionCode() <= ((HwVersion) obj).getAllowVersion()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeHw() {
        Log.d("test", "checkHwVersion: " + this.buildConfig.isHw());
        if (this.buildConfig.isHw()) {
            BuildersKt__Builders_commonKt.launch$default(getScope(), Dispatchers.getIO(), null, new HomeComponent$observeHw$1(this, null), 2, null);
        }
    }

    private final void prepareNews() {
        FlowKt.launchIn(FlowKt.onEach(this.newsInteractor.getInteractorStateFlow(), new HomeComponent$prepareNews$1(this, null)), getScope());
    }

    private final void observeExternal() {
        FlowKt.launchIn(FlowKt.onEach(HomeExternalUiStateHolder.INSTANCE.getHomeState(), new HomeComponent$observeExternal$1(this, null)), getScope());
    }

    private final void observeSettings() {
        FlowKt.launchIn(FlowKt.onEach(this.settingsInteractor.getInteractorStateFlow(), new HomeComponent$observeSettings$1(null)), getScope());
    }

    private final void observerServersState() {
        FlowKt.launchIn(FlowKt.onEach(this.serversInteractor.getInteractorStateFlow(), new HomeComponent$observerServersState$1(this, null)), getScope());
    }

    public final void onClickGame() {
        Timber.Forest.d("onClickGame", new Object[0]);
        if (this.uiState.getValue().isCheckingFiles()) {
            return;
        }
        if (this.uiState.getValue().isUpdateNeeded()) {
            emitUiAction(new HomeUiAction.NavigateToDownloadDialog(this.stateStore.getValue().getUpdateSize()));
        } else if (this.uiState.getValue().isGameReady()) {
            if (this.uiState.getValue().getCurrentServer() == null) {
                emitUiAction(HomeUiAction.NavigateToSelectServers.INSTANCE);
            }
            ServerModel currentServer = this.uiState.getValue().getCurrentServer();
            if (currentServer != null) {
                this.serversInteractor.favoriteServerStartGame(currentServer);
                ConnectionHolder connectionHolder = ConnectionHolder.INSTANCE;
                Integer number = currentServer.getNumber();
                int intValue = number != null ? number.intValue() : 0;
                String ip = currentServer.getIp();
                if (ip == null) {
                    ip = "";
                }
                connectionHolder.setSelectedServer(new com.miami.game.feature.download.dialog.ui.connection.ServerModel(intValue, ip, String.valueOf(currentServer.getPort()), String.valueOf(currentServer.getPassword()), currentServer.isMobile()));
                ConnectionHolder.INSTANCE.getOnStartGame().invoke();
            }
        }
    }

    public final void onLongClickGame() {
        Timber.Forest.d("onClickGame", new Object[0]);
        if (this.uiState.getValue().isCheckingFiles()) {
            return;
        }
        if (this.buildConfig.isDebug() || this.buildConfig.isStaging()) {
            if (this.uiState.getValue().getCurrentServer() == null) {
                emitUiAction(HomeUiAction.NavigateToSelectServers.INSTANCE);
            }
            ServerModel currentServer = this.uiState.getValue().getCurrentServer();
            if (currentServer != null) {
                this.serversInteractor.favoriteServerStartGame(currentServer);
                ConnectionHolder connectionHolder = ConnectionHolder.INSTANCE;
                Integer number = currentServer.getNumber();
                int intValue = number != null ? number.intValue() : 0;
                String ip = currentServer.getIp();
                if (ip == null) {
                    ip = "";
                }
                connectionHolder.setSelectedServer(new com.miami.game.feature.download.dialog.ui.connection.ServerModel(intValue, ip, String.valueOf(currentServer.getPort()), String.valueOf(currentServer.getPassword()), currentServer.isMobile()));
                ConnectionHolder.INSTANCE.getOnStartGame().invoke();
            }
        }
    }

    public final void onClickServer() {
        Timber.Forest.d("onClickServer", new Object[0]);
        emitUiAction(HomeUiAction.NavigateToSelectServers.INSTANCE);
    }

    public final void onClickShop(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.uiState.getValue().isShopAllowed()) {
            Timber.Forest.d("onClickShop", new Object[0]);
            Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(this.uiState.getValue().getShopLink());
            if (uriOrNull == null) {
                return;
            }
            AppMetrica.reportEvent("click_shop", MapsKt.mapOf(TuplesKt.to("xdonate", Integer.valueOf(this.uiState.getValue().getXDonate()))));
            Bundle bundle = new Bundle();
            bundle.putString("xdonate", String.valueOf(this.uiState.getValue().getXDonate()));
            FirebaseAnalytics.getInstance(context).logEvent("click_shop", bundle);
            emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
            return;
        }
        emitUiAction(HomeUiAction.NotifyHwIsNotAllowed.INSTANCE);
    }

    public final void onClickNews(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Timber.Forest.d("onClickNews url:" + url, new Object[0]);
        Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(url);
        if (uriOrNull == null) {
            return;
        }
        emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
    }

    public final void onClickNotification() {
        this.notificationStateHolder.getViewModel().viewAllNotifications();
        Timber.Forest.d("onClickNotifications", new Object[0]);
        emitUiAction(HomeUiAction.NavigateToNotification.INSTANCE);
    }

    public final void onClickSocial(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Timber.Forest.d("onClickSocial url:" + url, new Object[0]);
        Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(url);
        if (uriOrNull == null) {
            return;
        }
        emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
    }

    public final void onClickAccount() {
        Timber.Forest.d("onClickAccount", new Object[0]);
        Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(this.uiState.getValue().getWebsiteLink());
        if (uriOrNull == null) {
            return;
        }
        emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
    }

    public final void onClickForum() {
        Timber.Forest.d("onClickForum", new Object[0]);
        Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(this.uiState.getValue().getForumLink());
        if (uriOrNull == null) {
            return;
        }
        emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
    }

    public final void onClickSettings() {
        Timber.Forest.d("onClickSettings", new Object[0]);
        emitUiAction(HomeUiAction.NavigateToSettings.INSTANCE);
    }

    public final void onClickSetup() {
        Timber.Forest.d("onClickSetup", new Object[0]);
        emitUiAction(HomeUiAction.NavigateToSettings.INSTANCE);
    }

    private final void onStartDownloadGame() {
        Timber.Forest.d("onClickDownloadGame", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new HomeComponent$onStartDownloadGame$$inlined$launchSafe$default$1(null, this), 3, null);
    }

    private final void onCancelDownloadGame() {
        Timber.Forest.d("onCancelDownloadGame", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new HomeComponent$onCancelDownloadGame$$inlined$launchSafe$default$1(null, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(Exception exc) {
        Timber.Forest.e(exc);
        emitUiAction(HomeUiAction.NavigateToErrorDialog.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitUiAction(HomeUiAction homeUiAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new HomeComponent$emitUiAction$1(this, homeUiAction, null), 3, null);
    }

    private final void emitExternalNavigationAction(ExternalNavigationAction externalNavigationAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new HomeComponent$emitExternalNavigationAction$1(this, externalNavigationAction, null), 3, null);
    }
}
