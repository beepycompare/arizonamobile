package com.miami.game.feature.download.screen.ui;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.ContextCompat;
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
import com.miami.game.core.files.updater.domain.FilesUpdaterInteractor;
import com.miami.game.core.foreground.service.DownloadService;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiStateHolder;
import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiAction;
import com.miami.game.feature.download.screen.ui.model.DownloadScreenUiState;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import timber.log.Timber;
/* compiled from: DownloadScreenComponent.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001NB+\b\u0001\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010'\u001a\u00020\u001cH\u0002J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u001cH\u0002J\u000e\u0010,\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u001cH\u0002J\u0014\u0010/\u001a\u00020\u001c2\n\u00100\u001a\u000601j\u0002`2H\u0002J\u0010\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u0017H\u0002J\u0006\u00105\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0012\u00106\u001a\u000207X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u00109R\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010;X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0012\u0010>\u001a\u00020?X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0012\u0010B\u001a\u00020CX\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0012\u0010F\u001a\u00020GX\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0012\u0010J\u001a\u00020KX\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "componentContext", "filesUpdaterInteractor", "Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;", "buildConfigRepository", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "localRepository", "Lcom/miami/game/core/local/repository/common/LocalRepository;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/core/files/updater/domain/FilesUpdaterInteractor;Lcom/miami/game/core/build/config/BuildConfigRepository;Lcom/miami/game/core/local/repository/common/LocalRepository;)V", "videoUri", "Landroid/net/Uri;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "uiAction", "Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "Lcom/miami/game/feature/download/screen/ui/model/DownloadScreenUiAction;", "getUiAction", "()Lcom/miami/game/core/decompose/utils/SharedEventFlow;", "onRetry", "Lkotlin/Function0;", "", "getOnRetry", "()Lkotlin/jvm/functions/Function0;", "setOnRetry", "(Lkotlin/jvm/functions/Function0;)V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "initVmState", "startService", "context", "Landroid/content/Context;", "observeExternal", "onStartDownloadGame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCancelDownloadGame", "handleError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "emitUiAction", "action", "onSoundClick", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DownloadScreenComponent implements ComponentContext, CoroutineFeature {
    public static final int $stable = 8;
    private final /* synthetic */ ComponentContext $$delegate_0;
    private final /* synthetic */ CoroutineFeatureImpl $$delegate_1;
    private final BuildConfigRepository buildConfigRepository;
    private String errorMessage;
    private final FilesUpdaterInteractor filesUpdaterInteractor;
    private final LocalRepository localRepository;
    private Function0<Unit> onRetry;
    private final MutableStateFlow<DownloadScreenUiState> stateStore;
    private final SharedEventFlow<DownloadScreenUiAction> uiAction;
    private final StateFlow<DownloadScreenUiState> uiState;
    private final Uri videoUri;

    /* compiled from: DownloadScreenComponent.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006"}, d2 = {"Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "download-screen_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Factory {
        DownloadScreenComponent invoke(ComponentContext componentContext);
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
    public DownloadScreenComponent(@Assisted ComponentContext componentContext, FilesUpdaterInteractor filesUpdaterInteractor, BuildConfigRepository buildConfigRepository, LocalRepository localRepository) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(filesUpdaterInteractor, "filesUpdaterInteractor");
        Intrinsics.checkNotNullParameter(buildConfigRepository, "buildConfigRepository");
        Intrinsics.checkNotNullParameter(localRepository, "localRepository");
        this.$$delegate_0 = componentContext;
        this.$$delegate_1 = new CoroutineFeatureImpl(componentContext);
        this.filesUpdaterInteractor = filesUpdaterInteractor;
        this.buildConfigRepository = buildConfigRepository;
        this.localRepository = localRepository;
        Uri parse = Uri.parse("asset:///downloading_video.webm");
        this.videoUri = parse;
        MutableStateFlow<DownloadScreenUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(DownloadScreenUiState.Companion.initial(parse, buildConfigRepository.isArizona()));
        this.stateStore = MutableStateFlow;
        this.uiState = FlowKt.stateIn(FlowKt.asStateFlow(MutableStateFlow), getScope(), SharingStarted.Companion.getEagerly(), DownloadScreenUiState.Companion.initial(parse, buildConfigRepository.isArizona()));
        this.uiAction = new SharedEventFlow<>();
        this.onRetry = new Function0() { // from class: com.miami.game.feature.download.screen.ui.DownloadScreenComponent$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        };
        this.errorMessage = "";
        initVmState();
    }

    public final StateFlow<DownloadScreenUiState> getUiState() {
        return this.uiState;
    }

    public final SharedEventFlow<DownloadScreenUiAction> getUiAction() {
        return this.uiAction;
    }

    public final Function0<Unit> getOnRetry() {
        return this.onRetry;
    }

    public final void setOnRetry(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onRetry = function0;
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
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new DownloadScreenComponent$initVmState$$inlined$launchSafe$default$1(null, this, this), 3, null);
    }

    public final void startService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ContextCompat.startForegroundService(context, DownloadService.Companion.newIntent(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void observeExternal() {
        FlowKt.launchIn(FlowKt.onEach(DownloadExternalUiStateHolder.INSTANCE.getState(), new DownloadScreenComponent$observeExternal$1(this, null)), getScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onStartDownloadGame(Continuation<? super Unit> continuation) {
        Timber.Forest.d("onClickDownloadGame", new Object[0]);
        Object downloadGame = this.filesUpdaterInteractor.downloadGame(continuation);
        return downloadGame == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? downloadGame : Unit.INSTANCE;
    }

    private final void onCancelDownloadGame() {
        Timber.Forest.d("onCancelDownloadGame", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new DownloadScreenComponent$onCancelDownloadGame$$inlined$launchSafe$default$1(null, this, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(Exception exc) {
        Exception exc2 = exc;
        Timber.Forest.e(exc2);
        Timber.Forest.e(exc2);
        this.onRetry = new Function0() { // from class: com.miami.game.feature.download.screen.ui.DownloadScreenComponent$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit handleError$lambda$4;
                handleError$lambda$4 = DownloadScreenComponent.handleError$lambda$4(DownloadScreenComponent.this);
                return handleError$lambda$4;
            }
        };
        this.errorMessage = "";
        emitUiAction(DownloadScreenUiAction.NoNetworkError.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleError$lambda$4(DownloadScreenComponent downloadScreenComponent) {
        downloadScreenComponent.initVmState();
        return Unit.INSTANCE;
    }

    private final void emitUiAction(DownloadScreenUiAction downloadScreenUiAction) {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new DownloadScreenComponent$emitUiAction$1(this, downloadScreenUiAction, null), 3, null);
    }

    public final void onSoundClick() {
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new DownloadScreenComponent$onSoundClick$1(this, !this.stateStore.getValue().getSoundOn(), null), 3, null);
    }
}
