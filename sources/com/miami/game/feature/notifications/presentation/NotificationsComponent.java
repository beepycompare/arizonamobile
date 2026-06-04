package com.miami.game.feature.notifications.presentation;

import com.arkivanov.decompose.ComponentContext;
import com.arkivanov.decompose.ComponentContextFactory;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.miami.game.core.build.config.BuildConfigRepository;
import com.miami.game.core.decompose.utils.CoroutineFeature;
import com.miami.game.core.decompose.utils.CoroutineFeatureImpl;
import com.miami.game.feature.notifications.NotificationStateHolder;
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
/* compiled from: Component.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00013B+\b\u0001\u0012\f\b\u0001\u0010\u0003\u001a\u00020\u0001:\u0002\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0002\b\u000b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u0017\u001a\u00020\u00162\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u001b\u001a\u00020\u001cX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020$X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0012\u0010'\u001a\u00020(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000200X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u00102Ê\u0001\f\b5\u0012\b\b6\u0012\u0004\b\u0003\u0010\u0000¨\u00064"}, d2 = {"Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "componentContext", "Ldagger/assisted/Assisted;", "buildConfig", "Lcom/miami/game/core/build/config/BuildConfigRepository;", "holder", "Lcom/miami/game/feature/notifications/NotificationStateHolder;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/core/build/config/BuildConfigRepository;Lcom/miami/game/feature/notifications/NotificationStateHolder;)V", "Ldagger/assisted/AssistedInject;", "getHolder", "()Lcom/miami/game/feature/notifications/NotificationStateHolder;", "stateStore", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/miami/game/feature/notifications/presentation/NotificationsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "initVmState", "", "handleError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "notifications", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NotificationsComponent implements ComponentContext, CoroutineFeature {
    public static final int $stable = 8;
    private final /* synthetic */ ComponentContext $$delegate_0;
    private final /* synthetic */ CoroutineFeatureImpl $$delegate_1;
    private final BuildConfigRepository buildConfig;
    private final NotificationStateHolder holder;
    private final MutableStateFlow<NotificationsUiState> stateStore;
    private final StateFlow<NotificationsUiState> uiState;

    /* compiled from: Component.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002Ê\u0001\u0002\b\u0007¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/miami/game/feature/notifications/presentation/NotificationsComponent$Factory;", "", "invoke", "Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "notifications", "Ldagger/assisted/AssistedFactory;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Factory {
        NotificationsComponent invoke(ComponentContext componentContext);
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
    public NotificationsComponent(@Assisted ComponentContext componentContext, BuildConfigRepository buildConfig, NotificationStateHolder holder) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(buildConfig, "buildConfig");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.$$delegate_0 = componentContext;
        this.$$delegate_1 = new CoroutineFeatureImpl(componentContext);
        this.buildConfig = buildConfig;
        this.holder = holder;
        MutableStateFlow<NotificationsUiState> MutableStateFlow = StateFlowKt.MutableStateFlow(NotificationsUiState.Companion.initial(buildConfig.isArizona()));
        this.stateStore = MutableStateFlow;
        this.uiState = FlowKt.stateIn(FlowKt.asStateFlow(MutableStateFlow), getScope(), SharingStarted.Companion.getEagerly(), NotificationsUiState.Companion.initial(buildConfig.isArizona()));
        initVmState();
    }

    public final NotificationStateHolder getHolder() {
        return this.holder;
    }

    public final StateFlow<NotificationsUiState> getUiState() {
        return this.uiState;
    }

    private final void initVmState() {
        Timber.Forest.d("initVmState", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new NotificationsComponent$initVmState$$inlined$launchSafe$default$1(null, this, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(Exception exc) {
        Timber.Forest.e(exc);
    }
}
