package com.miami.game.feature.settings.ui;

import android.net.Uri;
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
import com.miami.game.core.settings.game_test.GameTestScriptPreferences;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;
/* compiled from: SettingsComponent.kt */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001gB3\b\u0001\u0012\f\b\u0001\u0010\u0003\u001a\u00020\u0001:\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u001a\u0002\b\r¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0014\u0010!\u001a\u00020\u001e2\n\u0010\"\u001a\u00060#j\u0002`$H\u0002J\u0006\u0010%\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020\u001eJ\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001eJ\u0006\u0010+\u001a\u00020\u001eJ\u000e\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020\u001eJ\u000e\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000202J\u0006\u00105\u001a\u00020\u001eJ\u0006\u00106\u001a\u00020\u001eJ\u000e\u00107\u001a\u00020\u001e2\u0006\u00104\u001a\u000202J\b\u00108\u001a\u00020\u001eH\u0002J\u000e\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020\u001eJ\u0006\u0010@\u001a\u00020\u001eJ\u0006\u0010A\u001a\u00020\u001eJ\u0006\u0010B\u001a\u00020\u001eJ\u0006\u0010C\u001a\u00020\u001eJ\u0006\u0010D\u001a\u00020\u001eJ\u0006\u0010E\u001a\u00020\u001eJ\u0010\u0010F\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u0017H\u0002J\u0006\u0010H\u001a\u00020\u001eJ\u0006\u0010I\u001a\u00020\u001eJ\u0006\u0010J\u001a\u00020\u001eJ\u0006\u0010K\u001a\u00020\u001eJ\u0006\u0010L\u001a\u00020\u001eJ\u0006\u0010M\u001a\u00020\u001eJ\u0010\u0010N\u001a\u00020\u001e2\u0006\u0010G\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0012\u0010O\u001a\u00020PX\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0018\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010TX\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0012\u0010W\u001a\u00020XX\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0012\u0010[\u001a\u00020\\X\u0096\u0005¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0012\u0010_\u001a\u00020`X\u0096\u0005¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0012\u0010c\u001a\u00020dX\u0096\u0005¢\u0006\u0006\u001a\u0004\be\u0010fÊ\u0001\f\bi\u0012\b\bj\u0012\u0004\b\u0003\u0010\u0000¨\u0006h"}, d2 = {"Lcom/miami/game/feature/settings/ui/SettingsComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "componentContext", "Ldagger/assisted/Assisted;", "filesUpdaterInteractor", "Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "settingsInteractor", "Lcom/miami/game/core/settings/SettingsInteractor;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;Lcom/miami/game/core/build/config/BuildConfigRepository;Lcom/miami/game/core/settings/SettingsInteractor;)V", "Ldagger/assisted/AssistedInject;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/settings/ui/model/SettingsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/settings/ui/model/SettingsUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "externalNavigationAction", "Lcom/miami/game/core/external/navigation/model/ExternalNavigationAction;", "getExternalNavigationAction", "initVmState", "", "observeLifecycle", "observeSettingsState", "handleError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onRepairGameClick", "onRepairGameStart", "onConnectGame", "connectionData", "Lcom/miami/game/feature/download/dialog/ui/connection/ConnectionData;", "onDebugAutoConnectTestServer", "onDebugAutoRunTestScript", "onImportGameTestScript", "uri", "Landroid/net/Uri;", "onUseBundledGameTestScript", "onSelectImportedGameTestScript", "fileName", "", "onUpdateGameTestScreenshotPullPath", "path", "onDebugScreenshotButton", "onDebugLogShareButton", "onUpdateGameTestScreenshotDeviceDir", "repairGame", "selectFontSize", TtmlNode.ATTR_TTS_FONT_SIZE, "", "selectPageSize", "pageSize", "", "onFullScreen", "onFps", "onChatTime", "onAmbientSounds", "onKeyBoard", "onStreamer", "onNotifications", "emitUiAction", "action", "onBugsReport", "onShareLogs", "onLongShareLogs", "onPrivacyPolicy", "onTech", "closeTech", "emitExternalNavigationAction", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "settings", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002Ê\u0001\u0002\b\u0007¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/miami/game/feature/settings/ui/SettingsComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/settings/ui/SettingsComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "settings", "Ldagger/assisted/AssistedFactory;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
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
        MutableStateFlow<SettingsUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(SettingsUiState.Companion.initial(buildConfig.isArizona(), buildConfig.isDebug(), String.valueOf(buildConfig.getVersionCode()), settingsInteractor.isTablet()));
        this.stateStore = MutableStateFlow;
        this.uiState = FlowKt.stateIn(FlowKt.asStateFlow(MutableStateFlow), getScope(), SharingStarted.Companion.getEagerly(), SettingsUiState.Companion.initial(buildConfig.isArizona(), buildConfig.isDebug(), String.valueOf(buildConfig.getVersionCode()), settingsInteractor.isTablet()));
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
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new SettingsComponent$initVmState$$inlined$launchSafe$default$1(null, this, this), 3, null);
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
        } while (!mutableStateFlow.compareAndSet(value, SettingsUiState.copy$default(value, 0, null, null, null, false, null, false, null, false, 0, null, null, 4079, null)));
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, false, false, false, false, false, null, null, null, null, false, false, null, new com.miami.game.core.settings.ConnectionData(connectionData.getIp(), connectionData.getPort(), connectionData.getPassword()), 524287, null));
        ConnectionHolder.INSTANCE.setSettingsData(SettingsData.copy$default(ConnectionHolder.INSTANCE.getSettingsData(), 0, 0.0f, false, false, false, false, false, false, connectionData.getIp(), connectionData.getPort(), connectionData.getPassword(), 255, null));
        ConnectionHolder.INSTANCE.getOnConnectTest().invoke();
    }

    public final void onDebugAutoConnectTestServer() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, false, false, !this.stateStore.getValue().getSettingState().getDebugAutoConnectTestServer(), false, false, null, null, null, null, false, false, null, null, 1048063, null));
    }

    public final void onDebugAutoRunTestScript() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, false, false, false, !this.stateStore.getValue().getSettingState().getDebugAutoRunTestScript(), false, null, null, null, null, false, false, null, null, 1047551, null));
    }

    public final void onImportGameTestScript(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.settingsInteractor.importGameTestScript(uri);
    }

    public final void onUseBundledGameTestScript() {
        this.settingsInteractor.useBundledGameTestScript();
    }

    public final void onSelectImportedGameTestScript(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        this.settingsInteractor.selectImportedGameTestScript(fileName);
    }

    public final void onUpdateGameTestScreenshotPullPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        String obj = StringsKt.trim((CharSequence) path).toString();
        if (StringsKt.isBlank(obj)) {
            obj = GameTestScriptPreferences.DEFAULT_SCREENSHOT_PULL_PATH;
        }
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, false, false, false, false, false, null, null, null, obj, false, false, null, null, 1015807, null));
    }

    public final void onDebugScreenshotButton() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, false, false, false, false, false, null, null, null, null, !this.stateStore.getValue().getSettingState().getDebugGameTestScreenshotButtonEnabled(), false, null, null, 983039, null));
    }

    public final void onDebugLogShareButton() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, false, false, false, false, false, null, null, null, null, false, !this.stateStore.getValue().getSettingState().getDebugGameTestLogShareButtonEnabled(), null, null, 917503, null));
    }

    public final void onUpdateGameTestScreenshotDeviceDir(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, false, false, false, false, false, null, null, null, null, false, false, StringsKt.trim((CharSequence) path).toString(), null, 786431, null));
    }

    private final void repairGame() {
        Timber.Forest.d("repairGame", new Object[0]);
        emitUiAction(SettingsUiAction.RepairGameDialog.INSTANCE);
    }

    public final void selectFontSize(float f) {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), f, 0, false, false, false, false, false, false, false, false, false, false, null, null, null, null, false, false, null, null, 1048574, null));
    }

    public final void selectPageSize(int i) {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, i, false, false, false, false, false, false, false, false, false, false, null, null, null, null, false, false, null, null, 1048573, null));
    }

    public final void onFullScreen() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, !this.stateStore.getValue().getSettingState().getFullScreen(), false, false, false, false, false, null, null, null, null, false, false, null, null, 1048511, null));
    }

    public final void onFps() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, !this.stateStore.getValue().getSettingState().getShowFps(), false, false, false, false, false, false, null, null, null, null, false, false, null, null, 1048543, null));
    }

    public final void onChatTime() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, !this.stateStore.getValue().getSettingState().getShowChatTime(), false, false, false, false, false, false, false, false, null, null, null, null, false, false, null, null, 1048567, null));
    }

    public final void onAmbientSounds() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, !this.stateStore.getValue().getSettingState().getAmbientSounds(), false, false, false, false, false, false, false, null, null, null, null, false, false, null, null, 1048559, null));
    }

    public final void onKeyBoard() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, !this.stateStore.getValue().getSettingState().getCustomKeyBoard(), false, false, false, false, false, false, false, false, false, null, null, null, null, false, false, null, null, 1048571, null));
    }

    public final void onStreamer() {
        this.settingsInteractor.saveSettings(SettingState.copy$default(this.stateStore.getValue().getSettingState(), 0.0f, 0, false, false, false, false, false, !this.stateStore.getValue().getSettingState().getStreamerMode(), false, false, false, false, null, null, null, null, false, false, null, null, 1048447, null));
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

    public final void onLongShareLogs() {
        this.settingsInteractor.saveLogFile();
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
        } while (!mutableStateFlow.compareAndSet(value, SettingsUiState.copy$default(value, 0, null, null, null, true, null, false, null, false, 0, null, null, 4079, null)));
    }

    public final void closeTech() {
        SettingsUiState value;
        MutableStateFlow<SettingsUiState> mutableStateFlow = this.stateStore;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, SettingsUiState.copy$default(value, 0, null, null, null, false, null, false, null, false, 0, null, null, 4079, null)));
    }

    private final void emitExternalNavigationAction(ExternalNavigationAction externalNavigationAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new SettingsComponent$emitExternalNavigationAction$1(this, externalNavigationAction, null), 3, null);
    }
}
