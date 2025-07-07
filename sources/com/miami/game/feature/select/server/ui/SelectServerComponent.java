package com.miami.game.feature.select.server.ui;

import com.arkivanov.decompose.ComponentContext;
import com.arkivanov.decompose.ComponentContextFactory;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.decompose.utils.CoroutineFeature;
import com.miami.game.core.decompose.utils.CoroutineFeatureImpl;
import com.miami.game.core.decompose.utils.SharedEventFlow;
import com.miami.game.core.server.ServersInteractor;
import com.miami.game.core.server.model.ServerModel;
import com.miami.game.core.server.model.ServerStateCategory;
import com.miami.game.feature.select.server.ui.model.SelectServerUiState;
import com.miami.game.feature.select.server.ui.model.ServerUiAction;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;
/* compiled from: SelectServerComponent.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001?B#\b\u0001\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0014\u0010\u0018\u001a\u00020\u00172\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0017J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0017J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010'\u001a\u00020(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0018\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000200X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u000204X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0012\u00107\u001a\u000208X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0012\u0010;\u001a\u00020<X\u0096\u0005¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006@"}, d2 = {"Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "componentContext", "serversInteractor", "Lcom/miami/game/core/server/ServersInteractor;", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/core/server/ServersInteractor;Lcom/miami/game/core/build/config/BuildConfigRepository;)V", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/select/server/ui/model/ServerUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "initVmState", "", "handleError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "observeServerState", "onSelect", "serverModel", "Lcom/miami/game/core/server/model/ServerModel;", "onBack", "onFavorite", "onFavoriteList", "onMobileList", "onDesktopList", "emitUiAction", "action", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "select-server_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SelectServerComponent implements ComponentContext, CoroutineFeature {
    public static final int $stable = 8;
    private final /* synthetic */ ComponentContext $$delegate_0;
    private final /* synthetic */ CoroutineFeatureImpl $$delegate_1;
    private final BuildConfigRepository buildConfig;
    private final ServersInteractor serversInteractor;
    private final MutableStateFlow<SelectServerUiState> stateStore;
    private final SharedEventFlow<ServerUiAction> uiAction;
    private final StateFlow<SelectServerUiState> uiState;

    /* compiled from: SelectServerComponent.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006"}, d2 = {"Lcom/miami/game/feature/select/server/ui/SelectServerComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "select-server_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Factory {
        SelectServerComponent invoke(ComponentContext componentContext);
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
    public SelectServerComponent(@Assisted ComponentContext componentContext, ServersInteractor serversInteractor, BuildConfigRepository buildConfig) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(serversInteractor, "serversInteractor");
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        this.$$delegate_0 = componentContext;
        this.$$delegate_1 = new CoroutineFeatureImpl(componentContext);
        this.serversInteractor = serversInteractor;
        this.buildConfig = buildConfig;
        MutableStateFlow<SelectServerUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(SelectServerUiState.Companion.initial(buildConfig.isArizona()));
        this.stateStore = MutableStateFlow;
        this.uiState = FlowKt.stateIn(FlowKt.asStateFlow(MutableStateFlow), getScope(), SharingStarted.Companion.getEagerly(), SelectServerUiState.Companion.initial(buildConfig.isArizona()));
        initVmState();
        this.uiAction = new SharedEventFlow<>();
    }

    public final StateFlow<SelectServerUiState> getUiState() {
        return this.uiState;
    }

    public final SharedEventFlow<ServerUiAction> getUiAction() {
        return this.uiAction;
    }

    private final void initVmState() {
        Timber.Forest.d("initVmState", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new SelectServerComponent$initVmState$$inlined$launchSafe$default$1(null, this, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(Exception exc) {
        SelectServerUiState value;
        Timber.Forest.e(exc);
        MutableStateFlow<SelectServerUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(value, null, null, null, true, 0, false, 55, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeServerState() {
        FlowKt.launchIn(FlowKt.onEach(this.serversInteractor.getInteractorStateFlow(), new SelectServerComponent$observeServerState$1(this, null)), getScope());
    }

    public final void onSelect(ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(serverModel, "serverModel");
        this.serversInteractor.selectServer(serverModel);
        emitUiAction(ServerUiAction.NavigateToHome.INSTANCE);
    }

    public final void onBack() {
        emitUiAction(ServerUiAction.NavigateToHome.INSTANCE);
    }

    public final void onFavorite(ServerModel serverModel) {
        Intrinsics.checkNotNullParameter(serverModel, "serverModel");
        this.serversInteractor.favoriteServer(serverModel);
    }

    public final void onFavoriteList() {
        SelectServerUiState value;
        MutableStateFlow<SelectServerUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(value, null, null, ServerStateCategory.Favorite, false, 0, false, 59, null)));
        this.serversInteractor.filterFavoriteList();
    }

    public final void onMobileList() {
        SelectServerUiState value;
        MutableStateFlow<SelectServerUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(value, null, null, ServerStateCategory.Mobile, false, 0, false, 59, null)));
        this.serversInteractor.filterMobileList();
    }

    public final void onDesktopList() {
        SelectServerUiState value;
        MutableStateFlow<SelectServerUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(value, null, null, ServerStateCategory.Desktop, false, 0, false, 59, null)));
        this.serversInteractor.filterDesktopList();
    }

    private final void emitUiAction(ServerUiAction serverUiAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new SelectServerComponent$emitUiAction$1(this, serverUiAction, null), 3, null);
    }
}
