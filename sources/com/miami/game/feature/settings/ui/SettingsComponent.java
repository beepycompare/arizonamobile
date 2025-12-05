package com.miami.game.feature.settings.ui;

import android.net.Uri;
import androidx.core.app.FrameMetricsAggregator;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.text.ttml.TtmlNode;
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
import com.miami.game.core.external.navigation.model.ExternalNavigationAction;
import com.miami.game.core.files.updater.domain.FilesUpdaterInteractor;
import com.miami.game.core.settings.SettingState;
import com.miami.game.core.settings.SettingsInteractor;
import com.miami.game.core.ui.utils.extensions.ExtensionsBrowseKt;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionData;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder;
import com.miami.game.feature.download.dialog.ui.connection.SettingsData;
import com.miami.game.feature.settings.ui.model.SettingsUiAction;
import com.miami.game.feature.settings.ui.model.SettingsUiState;
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
/* compiled from: SettingsComponent.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001VB+\b\u0001\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\u0014\u0010\u001f\u001a\u00020\u001c2\n\u0010 \u001a\u00060!j\u0002`\"H\u0002J\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u001cH\u0002J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020\u001cJ\u0006\u00100\u001a\u00020\u001cJ\u0006\u00101\u001a\u00020\u001cJ\u0006\u00102\u001a\u00020\u001cJ\u0006\u00103\u001a\u00020\u001cJ\u0006\u00104\u001a\u00020\u001cJ\u0006\u00105\u001a\u00020\u001cJ\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0015H\u0002J\u0006\u00108\u001a\u00020\u001cJ\u0006\u00109\u001a\u00020\u001cJ\u0006\u0010:\u001a\u00020\u001cJ\u0006\u0010;\u001a\u00020\u001cJ\u0006\u0010<\u001a\u00020\u001cJ\u0010\u0010=\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0012\u0010>\u001a\u00020?X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00010CX\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0012\u0010F\u001a\u00020GX\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0012\u0010J\u001a\u00020KX\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0012\u0010N\u001a\u00020OX\u0096\u0005¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0012\u0010R\u001a\u00020SX\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u0010U¨\u0006W"}, d2 = {"Lcom/miami/game/feature/settings/ui/SettingsComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "componentContext", "filesUpdaterInteractor", "Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "settingsInteractor", "Lcom/miami/game/core/settings/SettingsInteractor;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;Lcom/miami/game/core/build/config/BuildConfigRepository;Lcom/miami/game/core/settings/SettingsInteractor;)V", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/settings/ui/model/SettingsUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "externalNavigationAction", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "getExternalNavigationAction", "initVmState", "", "observeLifecycle", "observeSettingsState", "handleError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onRepairGameClick", "onRepairGameStart", "onConnectGame", "connectionData", "Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "repairGame", "selectFontSize", TtmlNode.ATTR_TTS_FONT_SIZE, "", "selectPageSize", "pageSize", "", "onFullScreen", "onFps", "onChatTime", "onAmbientSounds", "onKeyBoard", "onStreamer", "onNotifications", "emitUiAction", "action", "onBugsReport", "onShareLogs", "onPrivacyPolicy", "onTech", "closeTech", "emitExternalNavigationAction", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "settings_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SettingsComponent implements ComponentContext, CoroutineFeature {
    public static final int $stable = 8;
    private final /* synthetic */ ComponentContext $$delegate_0;
    private final /* synthetic */ CoroutineFeatureImpl $$delegate_1;
    private final BuildConfigRepository buildConfig;
    private final SharedEventFlow<ExternalNavigationAction> externalNavigationAction;
    private final FilesUpdaterInteractor filesUpdaterInteractor;
    private final SettingsInteractor settingsInteractor;
    private final MutableStateFlow<SettingsUiState> stateStore;
    private final SharedEventFlow<SettingsUiAction> uiAction;
    private final StateFlow<SettingsUiState> uiState;

    /* compiled from: SettingsComponent.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/miami/game/feature/settings/ui/SettingsComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/settings/ui/SettingsComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "settings_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Factory {
        SettingsComponent invoke(ComponentContext componentContext);
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
    public SettingsComponent(@Assisted ComponentContext componentContext, FilesUpdaterInteractor filesUpdaterInteractor, BuildConfigRepository buildConfig, SettingsInteractor settingsInteractor) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(filesUpdaterInteractor, "filesUpdaterInteractor");
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        Intrinsics.checkNotNullParameter(settingsInteractor, "settingsInteractor");
        this.$$delegate_0 = componentContext;
        this.$$delegate_1 = new CoroutineFeatureImpl(componentContext);
        this.filesUpdaterInteractor = filesUpdaterInteractor;
        this.buildConfig = buildConfig;
        this.settingsInteractor = settingsInteractor;
        MutableStateFlow<SettingsUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(SettingsUiState.Companion.initial(buildConfig.isArizona(), buildConfig.isDebug(), String.valueOf(buildConfig.getVersionCode())));
        this.stateStore = MutableStateFlow;
        this.uiState = FlowKt.stateIn(FlowKt.asStateFlow(MutableStateFlow), getScope(), SharingStarted.Companion.getEagerly(), SettingsUiState.Companion.initial(buildConfig.isArizona(), buildConfig.isDebug(), String.valueOf(buildConfig.getVersionCode())));
        this.uiAction = new SharedEventFlow<>();
        this.externalNavigationAction = new SharedEventFlow<>();
        initVmState();
        observeSettingsState();
        observeLifecycle();
    }

    public final StateFlow<SettingsUiState> getUiState() {
        return this.uiState;
    }

    public final SharedEventFlow<SettingsUiAction> getUiAction() {
        return this.uiAction;
    }

    public final SharedEventFlow<ExternalNavigationAction> getExternalNavigationAction() {
        return this.externalNavigationAction;
    }

    private final void initVmState() {
        Timber.Forest.d("initVmState", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new SettingsComponent$initVmState$$inlined$launchSafe$default$1(null, this), 3, null);
    }

    private final void observeLifecycle() {
        getLifecycle().subscribe(new Lifecycle.Callbacks() { // from class: com.miami.game.feature.settings.ui.SettingsComponent$observeLifecycle$1
            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public /* bridge */ void onCreate() {
                Lifecycle.Callbacks.DefaultImpls.onCreate(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public /* bridge */ void onDestroy() {
                Lifecycle.Callbacks.DefaultImpls.onDestroy(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public /* bridge */ void onPause() {
                Lifecycle.Callbacks.DefaultImpls.onPause(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public /* bridge */ void onStart() {
                Lifecycle.Callbacks.DefaultImpls.onStart(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public /* bridge */ void onStop() {
                Lifecycle.Callbacks.DefaultImpls.onStop(this);
            }

            @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
            public void onResume() {
                SettingsInteractor settingsInteractor;
                settingsInteractor = SettingsComponent.this.settingsInteractor;
                settingsInteractor.getSettings();
            }
        });
    }

    private final void observeSettingsState() {
        FlowKt.launchIn(FlowKt.onEach(this.settingsInteractor.getInteractorStateFlow(), new SettingsComponent$observeSettingsState$1(this, null)), getScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(Exception exc) {
        Timber.Forest.e(exc);
    }

    public final void onRepairGameClick() {
        repairGame();
    }

    public final void onRepairGameStart() {
        this.filesUpdaterInteractor.onRepairGameClick();
    }

    public final void onConnectGame(ConnectionData connectionData) {
        SettingsUiState value;
        Intrinsics.checkNotNullParameter(connectionData, "connectionData");
        Timber.Forest.d("onConnectGame", new Object[0]);
        MutableStateFlow<SettingsUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SettingsUiState.copy$default(value, 0, null, null, null, false, null, false, null, 239, null)));
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, false, false, new com.miami.game.core.settings.ConnectionData(connectionData.getIp(), connectionData.getPort(), connectionData.getPassword()), FrameMetricsAggregator.EVERY_DURATION, null));
        ConnectionHolder.INSTANCE.setSettingsData(SettingsData.copy$default(ConnectionHolder.INSTANCE.getSettingsData(), 0, 0, false, false, false, false, false, false, connectionData.getIp(), connectionData.getPort(), connectionData.getPassword(), 255, null));
        ConnectionHolder.INSTANCE.getOnConnectTest().invoke();
    }

    private final void repairGame() {
        Timber.Forest.d("repairGame", new Object[0]);
        emitUiAction(SettingsUiAction.RepairGameDialog.INSTANCE);
    }

    public final void selectFontSize(float f) {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), f, 0, false, false, false, false, false, false, false, null, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, null));
    }

    public final void selectPageSize(int i) {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, i, false, false, false, false, false, false, false, null, 1021, null));
    }

    public final void onFullScreen() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, !this.stateStore.getValue().getSettingState().getFullScreen(), false, false, null, 959, null));
    }

    public final void onFps() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, !this.stateStore.getValue().getSettingState().getShowFps(), false, false, false, null, 991, null));
    }

    public final void onChatTime() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, !this.stateStore.getValue().getSettingState().getShowChatTime(), false, false, false, false, false, null, 1015, null));
    }

    public final void onAmbientSounds() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, !this.stateStore.getValue().getSettingState().getAmbientSounds(), false, false, false, false, null, 1007, null));
    }

    public final void onKeyBoard() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, !this.stateStore.getValue().getSettingState().getCustomKeyBoard(), false, false, false, false, false, false, null, 1019, null));
    }

    public final void onStreamer() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, !this.stateStore.getValue().getSettingState().getStreamerMode(), false, null, 895, null));
    }

    public final void onNotifications() {
        this.settingsInteractor.changeNotifications();
    }

    private final void emitUiAction(SettingsUiAction settingsUiAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new SettingsComponent$emitUiAction$1(this, settingsUiAction, null), 3, null);
    }

    public final void onBugsReport() {
        Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(this.uiState.getValue().getSupportLink());
        if (uriOrNull == null) {
            return;
        }
        emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
    }

    public final void onShareLogs() {
        ConnectionHolder.INSTANCE.getOnShareLogs().invoke();
    }

    public final void onPrivacyPolicy() {
        Uri uriOrNull = ExtensionsBrowseKt.toUriOrNull(this.uiState.getValue().getPrivacyPolicyLink());
        if (uriOrNull == null) {
            return;
        }
        emitExternalNavigationAction(new ExternalNavigationAction.OpenUri(uriOrNull));
    }

    public final void onTech() {
        SettingsUiState value;
        MutableStateFlow<SettingsUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SettingsUiState.copy$default(value, 0, null, null, null, true, null, false, null, 239, null)));
    }

    public final void closeTech() {
        SettingsUiState value;
        MutableStateFlow<SettingsUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SettingsUiState.copy$default(value, 0, null, null, null, false, null, false, null, 239, null)));
    }

    private final void emitExternalNavigationAction(ExternalNavigationAction externalNavigationAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new SettingsComponent$emitExternalNavigationAction$1(this, externalNavigationAction, null), 3, null);
    }
}
