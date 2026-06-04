package com.miami.game.feature.select.server.ui;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001AB+\b\u0001\u0012\f\b\u0001\u0010\u0003\u001a\u00020\u0001:\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0002\b\u000b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0014\u0010\u001a\u001a\u00020\u00192\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!J\u0006\u0010$\u001a\u00020\u0019J\u0006\u0010%\u001a\u00020\u0019J\u0006\u0010&\u001a\u00020\u0019J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010)\u001a\u00020*X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010.X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0012\u00101\u001a\u000202X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u00104R\u0012\u00105\u001a\u000206X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u0012\u00109\u001a\u00020:X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0012\u0010=\u001a\u00020>X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010@Ê\u0001\f\bC\u0012\b\bD\u0012\u0004\b\u0003\u0010\u0000¨\u0006B"}, d2 = {"Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "componentContext", "Ldagger/assisted/Assisted;", "serversInteractor", "Lcom/miami/game/core/server/ServersInteractor;", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/core/server/ServersInteractor;Lcom/miami/game/core/build/config/BuildConfigRepository;)V", "Ldagger/assisted/AssistedInject;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/select/server/ui/model/SelectServerUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/select/server/ui/model/ServerUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "initVmState", "", "handleError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "observeServerState", "onSelect", "serverModel", "Lcom/miami/game/core/server/model/ServerModel;", "onBack", "onFavorite", "onFavoriteList", "onMobileList", "onDesktopList", "emitUiAction", "action", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "select-server", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002Ê\u0001\u0002\b\u0007¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/miami/game/feature/select/server/ui/SelectServerComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "select-server", "Ldagger/assisted/AssistedFactory;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
        } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(value, null, null, null, true, 0, false, 0, null, null, TypedValues.PositionType.TYPE_PERCENT_WIDTH, null)));
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
        } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(value, null, null, ServerStateCategory.Favorite, false, 0, false, 0, null, null, TypedValues.PositionType.TYPE_PERCENT_Y, null)));
        this.serversInteractor.filterFavoriteList();
    }

    public final void onMobileList() {
        SelectServerUiState value;
        MutableStateFlow<SelectServerUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(value, null, null, ServerStateCategory.Mobile, false, 0, false, 0, null, null, TypedValues.PositionType.TYPE_PERCENT_Y, null)));
        this.serversInteractor.filterMobileList();
    }

    public final void onDesktopList() {
        SelectServerUiState value;
        MutableStateFlow<SelectServerUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SelectServerUiState.copy$default(value, null, null, ServerStateCategory.Desktop, false, 0, false, 0, null, null, TypedValues.PositionType.TYPE_PERCENT_Y, null)));
        this.serversInteractor.filterDesktopList();
    }

    private final void emitUiAction(ServerUiAction serverUiAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new SelectServerComponent$emitUiAction$1(this, serverUiAction, null), 3, null);
    }
}
