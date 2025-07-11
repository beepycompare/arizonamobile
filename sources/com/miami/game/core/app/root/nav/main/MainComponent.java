package com.miami.game.core.app.root.nav.main;

import com.arkivanov.decompose.ComponentContext;
import com.arkivanov.decompose.ComponentContextFactory;
import com.arkivanov.decompose.GenericComponentContext;
import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.stack.ChildStack;
import com.arkivanov.decompose.router.stack.ChildStackFactoryKt;
import com.arkivanov.decompose.router.stack.StackNavigation;
import com.arkivanov.decompose.router.stack.StackNavigationKt;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.backhandler.BackHandlerOwner;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.StateKeeper;
import com.miami.game.core.app.root.nav.main.MainComponent;
import com.miami.game.core.decompose.utils.CoroutineFeature;
import com.miami.game.core.decompose.utils.CoroutineFeatureImpl;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.connection.ConnectionHolder;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.download.screen.ui.model.DownloadExternalUiStateHolder;
import com.miami.game.feature.home.ui.HomeComponent;
import com.miami.game.feature.notifications.presentation.NotificationsComponent;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import com.miami.game.feature.settings.ui.SettingsComponent;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import timber.log.Timber;
/* compiled from: MainComponent.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005UVWXYBK\b\u0001\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u0018\u0010(\u001a\u00020&2\u0006\u0010!\u001a\u00020$2\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u0006\u0010)\u001a\u00020\u001fJ\u0006\u0010*\u001a\u00020\u001fJ\u0006\u0010+\u001a\u00020\u001fJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020\u001fJ\u0006\u00100\u001a\u00020\u001fJ\u0014\u00101\u001a\u00020\u001f2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001f03J\u0006\u00104\u001a\u00020\u001fJ\u001c\u00105\u001a\u00020\u001f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f032\u0006\u00107\u001a\u00020.J\u0006\u00108\u001a\u00020\u001fJ\u0006\u00109\u001a\u00020\u001fJ\u0006\u0010:\u001a\u00020\u001fJ\u0006\u0010;\u001a\u00020\u001fJ\u0006\u0010<\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0018\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010%\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020&0\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0012\u0010=\u001a\u00020>X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0018\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00010BX\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0012\u0010E\u001a\u00020FX\u0096\u0005¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0012\u0010I\u001a\u00020JX\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0012\u0010M\u001a\u00020NX\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0012\u0010Q\u001a\u00020RX\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u0010T¨\u0006Z"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent;", "Lcom/arkivanov/decompose/ComponentContext;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "Lcom/arkivanov/essenty/backhandler/BackHandlerOwner;", "componentContext", "homeFactory", "Lcom/miami/game/feature/home/ui/HomeComponent$Factory;", "selectServerFactory", "Lcom/miami/game/feature/select/server/ui/SelectServerComponent$Factory;", "settingsFactory", "Lcom/miami/game/feature/settings/ui/SettingsComponent$Factory;", "commonDialogFactory", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent$Factory;", "errorDialogFactory", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent$Factory;", "downloadScreenFactory", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;", "notificationsFactory", "Lcom/miami/game/feature/notifications/presentation/NotificationsComponent$Factory;", "<init>", "(Lcom/arkivanov/decompose/ComponentContext;Lcom/miami/game/feature/home/ui/HomeComponent$Factory;Lcom/miami/game/feature/select/server/ui/SelectServerComponent$Factory;Lcom/miami/game/feature/settings/ui/SettingsComponent$Factory;Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent$Factory;Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent$Factory;Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent$Factory;Lcom/miami/game/feature/notifications/presentation/NotificationsComponent$Factory;)V", "nav", "Lcom/arkivanov/decompose/router/stack/StackNavigation;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;", "stack", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child;", "getStack", "()Lcom/arkivanov/decompose/value/Value;", "observeExternal", "", "child", "config", "ctx", "navDialog", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "stackDialog", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "getStackDialog", "childDialog", "navigateToHome", "navigateToSelectServers", "navigateToSettings", "navigateToDownloadDialog", "updateSize", "", "navigateToRepairGameSuccessDialog", "navigateToRepairGameErrorDialog", "navigateToRepairGameDialog", "onClick", "Lkotlin/Function0;", "navigateToRepairGameHome", "navigateToErrorDialog", "onRetry", "errorMessage", "navigateBack", "navigateBackDialog", "navigateToDownloadScreen", "retry", "navigateToNotificaionsScreen", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "getBackHandler", "()Lcom/arkivanov/essenty/backhandler/BackHandler;", "componentContextFactory", "Lcom/arkivanov/decompose/ComponentContextFactory;", "getComponentContextFactory", "()Lcom/arkivanov/decompose/ComponentContextFactory;", "instanceKeeper", "Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "getInstanceKeeper", "()Lcom/arkivanov/essenty/instancekeeper/InstanceKeeper;", "lifecycle", "Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "getLifecycle", "()Lcom/arkivanov/essenty/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "stateKeeper", "Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "getStateKeeper", "()Lcom/arkivanov/essenty/statekeeper/StateKeeper;", "Factory", "Child", "Config", "DialogChild", "DialogConfig", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MainComponent implements ComponentContext, CoroutineFeature, BackHandlerOwner {
    public static final int $stable = 8;
    private final /* synthetic */ ComponentContext $$delegate_0;
    private final /* synthetic */ CoroutineFeatureImpl $$delegate_1;
    private final CommonDialogComponent.Factory commonDialogFactory;
    private final DownloadScreenComponent.Factory downloadScreenFactory;
    private final ErrorDialogComponent.Factory errorDialogFactory;
    private final HomeComponent.Factory homeFactory;
    private final StackNavigation<Config> nav;
    private final StackNavigation<DialogConfig> navDialog;
    private final NotificationsComponent.Factory notificationsFactory;
    private final SelectServerComponent.Factory selectServerFactory;
    private final SettingsComponent.Factory settingsFactory;
    private final Value<ChildStack<?, Child>> stack;
    private final Value<ChildStack<?, DialogChild>> stackDialog;

    /* compiled from: MainComponent.kt */
    @AssistedFactory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Factory;", "", "invoke", "Lcom/miami/game/core/app/root/nav/main/MainComponent;", "componentContext", "Lcom/arkivanov/decompose/ComponentContext;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Factory {
        MainComponent invoke(ComponentContext componentContext);
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
    public MainComponent(@Assisted ComponentContext componentContext, HomeComponent.Factory homeFactory, SelectServerComponent.Factory selectServerFactory, SettingsComponent.Factory settingsFactory, CommonDialogComponent.Factory commonDialogFactory, ErrorDialogComponent.Factory errorDialogFactory, DownloadScreenComponent.Factory downloadScreenFactory, NotificationsComponent.Factory notificationsFactory) {
        Intrinsics.checkNotNullParameter(componentContext, "componentContext");
        Intrinsics.checkNotNullParameter(homeFactory, "homeFactory");
        Intrinsics.checkNotNullParameter(selectServerFactory, "selectServerFactory");
        Intrinsics.checkNotNullParameter(settingsFactory, "settingsFactory");
        Intrinsics.checkNotNullParameter(commonDialogFactory, "commonDialogFactory");
        Intrinsics.checkNotNullParameter(errorDialogFactory, "errorDialogFactory");
        Intrinsics.checkNotNullParameter(downloadScreenFactory, "downloadScreenFactory");
        Intrinsics.checkNotNullParameter(notificationsFactory, "notificationsFactory");
        this.$$delegate_0 = componentContext;
        this.$$delegate_1 = new CoroutineFeatureImpl(componentContext);
        this.homeFactory = homeFactory;
        this.selectServerFactory = selectServerFactory;
        this.settingsFactory = settingsFactory;
        this.commonDialogFactory = commonDialogFactory;
        this.errorDialogFactory = errorDialogFactory;
        this.downloadScreenFactory = downloadScreenFactory;
        this.notificationsFactory = notificationsFactory;
        StackNavigation<Config> StackNavigation = StackNavigationKt.StackNavigation();
        this.nav = StackNavigation;
        MainComponent mainComponent = this;
        this.stack = ChildStackFactoryKt.childStack$default((GenericComponentContext) mainComponent, (NavigationSource) StackNavigation, (KSerializer) Config.Companion.serializer(), (Object) Config.Home.INSTANCE, "DefaultChildStackRoot", false, (Function2) new MainComponent$stack$1(this), 16, (Object) null);
        observeExternal();
        StackNavigation<DialogConfig> StackNavigation2 = StackNavigationKt.StackNavigation();
        this.navDialog = StackNavigation2;
        this.stackDialog = ChildStackFactoryKt.childStack$default((GenericComponentContext) mainComponent, (NavigationSource) StackNavigation2, (KSerializer) DialogConfig.Companion.serializer(), (Object) DialogConfig.EMPTY.INSTANCE, "DefaultChildStackDialog", false, (Function2) new MainComponent$stackDialog$1(this), 16, (Object) null);
    }

    public final Value<ChildStack<?, Child>> getStack() {
        return this.stack;
    }

    private final void observeExternal() {
        FlowKt.launchIn(FlowKt.onEach(MainExternalUiStateHolder.INSTANCE.getState(), new MainComponent$observeExternal$1(this, null)), getScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Child child(Config config, ComponentContext componentContext) {
        if (config instanceof Config.Home) {
            return new Child.Home(this.homeFactory.invoke(componentContext));
        }
        if (Intrinsics.areEqual(config, Config.SelectServer.INSTANCE)) {
            return new Child.SelectServer(this.selectServerFactory.invoke(componentContext));
        }
        if (Intrinsics.areEqual(config, Config.Settings.INSTANCE)) {
            return new Child.Settings(this.settingsFactory.invoke(componentContext));
        }
        if (Intrinsics.areEqual(config, Config.DownloadScreen.INSTANCE)) {
            return new Child.DownloadScreen(this.downloadScreenFactory.invoke(componentContext));
        }
        if (Intrinsics.areEqual(config, Config.NotificationScreen.INSTANCE)) {
            return new Child.Notification(this.notificationsFactory.invoke(componentContext));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Value<ChildStack<?, DialogChild>> getStackDialog() {
        return this.stackDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogChild childDialog(DialogConfig dialogConfig, ComponentContext componentContext) {
        if (dialogConfig instanceof DialogConfig.EMPTY) {
            return DialogChild.EMPTY.INSTANCE;
        }
        if (dialogConfig instanceof DialogConfig.DownloadCache) {
            return new DialogChild.DownloadCache(this.commonDialogFactory.invoke(componentContext, ((DialogConfig.DownloadCache) dialogConfig).getDescription()));
        }
        if (dialogConfig instanceof DialogConfig.RepairGameSuccess) {
            return new DialogChild.RepairGameSuccess(this.commonDialogFactory.invoke(componentContext, ""));
        }
        if (dialogConfig instanceof DialogConfig.RepairGameError) {
            return new DialogChild.RepairGameError(this.commonDialogFactory.invoke(componentContext, ""));
        }
        if (dialogConfig instanceof DialogConfig.ErrorNoNetwork) {
            return new DialogChild.ErrorNoNetwork(this.errorDialogFactory.invoke(componentContext, ((DialogConfig.ErrorNoNetwork) dialogConfig).getErrorMessage()));
        }
        if (dialogConfig instanceof DialogConfig.RepairGameDialog) {
            return new DialogChild.RepairGameDialog(this.errorDialogFactory.invoke(componentContext, ""));
        }
        if (dialogConfig instanceof DialogConfig.ActivityError) {
            return new DialogChild.ErrorActivity(this.errorDialogFactory.invoke(componentContext, ""));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void navigateToHome() {
        final Config[] configArr = {Config.Home.INSTANCE};
        this.nav.navigate(new Function1<List<? extends Config>, List<? extends Config>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToHome$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.Config> invoke(List<? extends MainComponent.Config> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(configArr);
            }
        }, new Function2<List<? extends Config>, List<? extends Config>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToHome$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateToSelectServers() {
        final Config.SelectServer selectServer = Config.SelectServer.INSTANCE;
        this.nav.navigate(new Function1<List<? extends Config>, List<? extends Config>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToSelectServers$$inlined$pushNew$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.Config> invoke(List<? extends MainComponent.Config> stack) {
                Intrinsics.checkNotNullParameter(stack, "stack");
                return Intrinsics.areEqual(CollectionsKt.last((List<? extends Object>) stack), selectServer) ? stack : CollectionsKt.plus((Collection<? extends Object>) stack, selectServer);
            }
        }, new Function2<List<? extends Config>, List<? extends Config>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToSelectServers$$inlined$pushNew$default$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.Config> newStack, List<? extends MainComponent.Config> oldStack) {
                Intrinsics.checkNotNullParameter(newStack, "newStack");
                Intrinsics.checkNotNullParameter(oldStack, "oldStack");
                newStack.size();
                oldStack.size();
            }
        });
    }

    public final void navigateToSettings() {
        final Config.Settings settings = Config.Settings.INSTANCE;
        this.nav.navigate(new Function1<List<? extends Config>, List<? extends Config>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToSettings$$inlined$pushNew$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.Config> invoke(List<? extends MainComponent.Config> stack) {
                Intrinsics.checkNotNullParameter(stack, "stack");
                return Intrinsics.areEqual(CollectionsKt.last((List<? extends Object>) stack), settings) ? stack : CollectionsKt.plus((Collection<? extends Object>) stack, settings);
            }
        }, new Function2<List<? extends Config>, List<? extends Config>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToSettings$$inlined$pushNew$default$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.Config> newStack, List<? extends MainComponent.Config> oldStack) {
                Intrinsics.checkNotNullParameter(newStack, "newStack");
                Intrinsics.checkNotNullParameter(oldStack, "oldStack");
                newStack.size();
                oldStack.size();
            }
        });
    }

    public final void navigateToDownloadDialog(String updateSize) {
        Intrinsics.checkNotNullParameter(updateSize, "updateSize");
        final DialogConfig[] dialogConfigArr = {new DialogConfig.DownloadCache(updateSize)};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToDownloadDialog$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToDownloadDialog$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateToRepairGameSuccessDialog() {
        final DialogConfig[] dialogConfigArr = {DialogConfig.RepairGameSuccess.INSTANCE};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameSuccessDialog$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameSuccessDialog$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateToRepairGameErrorDialog() {
        final DialogConfig[] dialogConfigArr = {DialogConfig.RepairGameError.INSTANCE};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameErrorDialog$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameErrorDialog$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateToRepairGameDialog(Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Timber.Forest.d("repairGame", new Object[0]);
        ErrorDialogComponent.Companion.setOnRetry(onClick);
        final DialogConfig[] dialogConfigArr = {DialogConfig.RepairGameDialog.INSTANCE};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameDialog$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameDialog$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateToRepairGameHome() {
        ConnectionHolder.INSTANCE.getOnCheckGame().invoke();
        final DialogConfig[] dialogConfigArr = {DialogConfig.EMPTY.INSTANCE};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameHome$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameHome$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
        final Config[] configArr = {Config.Home.INSTANCE};
        this.nav.navigate(new Function1<List<? extends Config>, List<? extends Config>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameHome$$inlined$replaceAll$default$3
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.Config> invoke(List<? extends MainComponent.Config> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(configArr);
            }
        }, new Function2<List<? extends Config>, List<? extends Config>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToRepairGameHome$$inlined$replaceAll$default$4
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateToErrorDialog(Function0<Unit> onRetry, String errorMessage) {
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        ErrorDialogComponent.Companion.setOnRetry(onRetry);
        final DialogConfig[] dialogConfigArr = {new DialogConfig.ErrorNoNetwork(errorMessage)};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToErrorDialog$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToErrorDialog$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateBack() {
        this.nav.navigate(new Function1<List<? extends Config>, List<? extends Config>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateBack$$inlined$pop$default$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.Config> invoke(List<? extends MainComponent.Config> stack) {
                List<MainComponent.Config> dropLast;
                Intrinsics.checkNotNullParameter(stack, "stack");
                List list = stack.size() > 1 ? stack : null;
                return (list == null || (dropLast = CollectionsKt.dropLast(list, 1)) == null) ? stack : dropLast;
            }
        }, new Function2<List<? extends Config>, List<? extends Config>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateBack$$inlined$pop$default$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.Config> newStack, List<? extends MainComponent.Config> oldStack) {
                Intrinsics.checkNotNullParameter(newStack, "newStack");
                Intrinsics.checkNotNullParameter(oldStack, "oldStack");
                newStack.size();
                oldStack.size();
            }
        });
    }

    public final void navigateBackDialog() {
        final DialogConfig[] dialogConfigArr = {DialogConfig.EMPTY.INSTANCE};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateBackDialog$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateBackDialog$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateToDownloadScreen() {
        final DialogConfig[] dialogConfigArr = {DialogConfig.EMPTY.INSTANCE};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToDownloadScreen$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToDownloadScreen$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
        DownloadExternalUiStateHolder.INSTANCE.getOnStartDownload().invoke();
    }

    public final void retry() {
        final DialogConfig[] dialogConfigArr = {DialogConfig.EMPTY.INSTANCE};
        this.navDialog.navigate(new Function1<List<? extends DialogConfig>, List<? extends DialogConfig>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$retry$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.DialogConfig> invoke(List<? extends MainComponent.DialogConfig> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(dialogConfigArr);
            }
        }, new Function2<List<? extends DialogConfig>, List<? extends DialogConfig>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$retry$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.DialogConfig> list, List<? extends MainComponent.DialogConfig> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    public final void navigateToNotificaionsScreen() {
        final Config[] configArr = {Config.NotificationScreen.INSTANCE};
        this.nav.navigate(new Function1<List<? extends Config>, List<? extends Config>>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToNotificaionsScreen$$inlined$replaceAll$default$1
            @Override // kotlin.jvm.functions.Function1
            public final List<MainComponent.Config> invoke(List<? extends MainComponent.Config> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return ArraysKt.toList(configArr);
            }
        }, new Function2<List<? extends Config>, List<? extends Config>, Unit>() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$navigateToNotificaionsScreen$$inlined$replaceAll$default$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                Intrinsics.checkNotNullParameter(list, "<unused var>");
                Intrinsics.checkNotNullParameter(list2, "<unused var>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MainComponent.Config> list, List<? extends MainComponent.Config> list2) {
                invoke2(list, list2);
                return Unit.INSTANCE;
            }
        });
    }

    /* compiled from: MainComponent.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Child;", "", "Home", "SelectServer", "DownloadScreen", "Settings", "Notification", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$DownloadScreen;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$Home;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$Notification;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$SelectServer;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$Settings;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Child {

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$Home;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child;", "component", "Lcom/miami/game/feature/home/ui/HomeComponent;", "<init>", "(Lcom/miami/game/feature/home/ui/HomeComponent;)V", "getComponent", "()Lcom/miami/game/feature/home/ui/HomeComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Home implements Child {
            public static final int $stable = HomeComponent.$stable;
            private final HomeComponent component;

            public Home(HomeComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final HomeComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$SelectServer;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child;", "component", "Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "<init>", "(Lcom/miami/game/feature/select/server/ui/SelectServerComponent;)V", "getComponent", "()Lcom/miami/game/feature/select/server/ui/SelectServerComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class SelectServer implements Child {
            public static final int $stable = SelectServerComponent.$stable;
            private final SelectServerComponent component;

            public SelectServer(SelectServerComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final SelectServerComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$DownloadScreen;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child;", "component", "Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;", "<init>", "(Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;)V", "getComponent", "()Lcom/miami/game/feature/download/screen/ui/DownloadScreenComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class DownloadScreen implements Child {
            public static final int $stable = DownloadScreenComponent.$stable;
            private final DownloadScreenComponent component;

            public DownloadScreen(DownloadScreenComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final DownloadScreenComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$Settings;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child;", "component", "Lcom/miami/game/feature/settings/ui/SettingsComponent;", "<init>", "(Lcom/miami/game/feature/settings/ui/SettingsComponent;)V", "getComponent", "()Lcom/miami/game/feature/settings/ui/SettingsComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Settings implements Child {
            public static final int $stable = SettingsComponent.$stable;
            private final SettingsComponent component;

            public Settings(SettingsComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final SettingsComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Child$Notification;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Child;", "component", "Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;", "<init>", "(Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;)V", "getComponent", "()Lcom/miami/game/feature/notifications/presentation/NotificationsComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Notification implements Child {
            public static final int $stable = NotificationsComponent.$stable;
            private final NotificationsComponent component;

            public Notification(NotificationsComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final NotificationsComponent getComponent() {
                return this.component;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainComponent.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bs\u0018\u0000 \u00072\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;", "", "Home", "SelectServer", "Settings", "DownloadScreen", "NotificationScreen", "Companion", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$DownloadScreen;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$Home;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$NotificationScreen;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$SelectServer;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$Settings;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: classes4.dex */
    public interface Config {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<Config> serializer() {
                return new SealedClassSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config", Reflection.getOrCreateKotlinClass(Config.class), new KClass[]{Reflection.getOrCreateKotlinClass(DownloadScreen.class), Reflection.getOrCreateKotlinClass(Home.class), Reflection.getOrCreateKotlinClass(NotificationScreen.class), Reflection.getOrCreateKotlinClass(SelectServer.class), Reflection.getOrCreateKotlinClass(Settings.class)}, new KSerializer[]{new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.DownloadScreen", DownloadScreen.INSTANCE, new Annotation[0]), new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.Home", Home.INSTANCE, new Annotation[0]), new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.NotificationScreen", NotificationScreen.INSTANCE, new Annotation[0]), new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.SelectServer", SelectServer.INSTANCE, new Annotation[0]), new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.Settings", Settings.INSTANCE, new Annotation[0])}, new Annotation[0]);
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$Home;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class Home implements Config {
            public static final Home INSTANCE = new Home();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$Config$Home$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.Config.Home._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Home) {
                    Home home = (Home) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 913663081;
            }

            public String toString() {
                return "Home";
            }

            private Home() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.Home", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Home> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$SelectServer;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class SelectServer implements Config {
            public static final SelectServer INSTANCE = new SelectServer();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$Config$SelectServer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.Config.SelectServer._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SelectServer) {
                    SelectServer selectServer = (SelectServer) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1004869399;
            }

            public String toString() {
                return "SelectServer";
            }

            private SelectServer() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.SelectServer", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<SelectServer> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$Settings;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class Settings implements Config {
            public static final Settings INSTANCE = new Settings();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$Config$Settings$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.Config.Settings._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Settings) {
                    Settings settings = (Settings) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -309307731;
            }

            public String toString() {
                return "Settings";
            }

            private Settings() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.Settings", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Settings> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$DownloadScreen;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class DownloadScreen implements Config {
            public static final DownloadScreen INSTANCE = new DownloadScreen();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$Config$DownloadScreen$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.Config.DownloadScreen._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof DownloadScreen) {
                    DownloadScreen downloadScreen = (DownloadScreen) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1014171106;
            }

            public String toString() {
                return "DownloadScreen";
            }

            private DownloadScreen() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.DownloadScreen", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<DownloadScreen> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$Config$NotificationScreen;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$Config;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class NotificationScreen implements Config {
            public static final NotificationScreen INSTANCE = new NotificationScreen();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$Config$NotificationScreen$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.Config.NotificationScreen._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof NotificationScreen) {
                    NotificationScreen notificationScreen = (NotificationScreen) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 347410241;
            }

            public String toString() {
                return "NotificationScreen";
            }

            private NotificationScreen() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.Config.NotificationScreen", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<NotificationScreen> serializer() {
                return get$cachedSerializer();
            }
        }
    }

    /* compiled from: MainComponent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "", "EMPTY", "DownloadCache", "RepairGameSuccess", "RepairGameError", "ErrorNoNetwork", "ErrorActivity", "RepairGameDialog", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$DownloadCache;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$EMPTY;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$ErrorActivity;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$ErrorNoNetwork;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$RepairGameDialog;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$RepairGameError;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$RepairGameSuccess;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface DialogChild {

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$EMPTY;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class EMPTY implements DialogChild {
            public static final int $stable = 0;
            public static final EMPTY INSTANCE = new EMPTY();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof EMPTY) {
                    EMPTY empty = (EMPTY) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1046078159;
            }

            public String toString() {
                return "EMPTY";
            }

            private EMPTY() {
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$DownloadCache;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "<init>", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;)V", "getComponent", "()Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class DownloadCache implements DialogChild {
            public static final int $stable = CommonDialogComponent.$stable;
            private final CommonDialogComponent component;

            public DownloadCache(CommonDialogComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final CommonDialogComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$RepairGameSuccess;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "<init>", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;)V", "getComponent", "()Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class RepairGameSuccess implements DialogChild {
            public static final int $stable = CommonDialogComponent.$stable;
            private final CommonDialogComponent component;

            public RepairGameSuccess(CommonDialogComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final CommonDialogComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$RepairGameError;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "component", "Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "<init>", "(Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;)V", "getComponent", "()Lcom/miami/game/feature/download/dialog/ui/common/CommonDialogComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class RepairGameError implements DialogChild {
            public static final int $stable = CommonDialogComponent.$stable;
            private final CommonDialogComponent component;

            public RepairGameError(CommonDialogComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final CommonDialogComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$ErrorNoNetwork;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "<init>", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;)V", "getComponent", "()Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class ErrorNoNetwork implements DialogChild {
            public static final int $stable = ErrorDialogComponent.$stable;
            private final ErrorDialogComponent component;

            public ErrorNoNetwork(ErrorDialogComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final ErrorDialogComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$ErrorActivity;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "<init>", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;)V", "getComponent", "()Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class ErrorActivity implements DialogChild {
            public static final int $stable = ErrorDialogComponent.$stable;
            private final ErrorDialogComponent component;

            public ErrorActivity(ErrorDialogComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final ErrorDialogComponent getComponent() {
                return this.component;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild$RepairGameDialog;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogChild;", "component", "Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "<init>", "(Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;)V", "getComponent", "()Lcom/miami/game/feature/download/dialog/ui/error/ErrorDialogComponent;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class RepairGameDialog implements DialogChild {
            public static final int $stable = ErrorDialogComponent.$stable;
            private final ErrorDialogComponent component;

            public RepairGameDialog(ErrorDialogComponent component) {
                Intrinsics.checkNotNullParameter(component, "component");
                this.component = component;
            }

            public final ErrorDialogComponent getComponent() {
                return this.component;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainComponent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bs\u0018\u0000 \t2\u00020\u0001:\b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "", "EMPTY", "DownloadCache", "RepairGameSuccess", "RepairGameError", "ActivityError", "RepairGameDialog", "ErrorNoNetwork", "Companion", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$ActivityError;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$DownloadCache;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$EMPTY;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$ErrorNoNetwork;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$RepairGameDialog;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$RepairGameError;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$RepairGameSuccess;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: classes4.dex */
    public interface DialogConfig {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<DialogConfig> serializer() {
                return new SealedClassSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig", Reflection.getOrCreateKotlinClass(DialogConfig.class), new KClass[]{Reflection.getOrCreateKotlinClass(ActivityError.class), Reflection.getOrCreateKotlinClass(DownloadCache.class), Reflection.getOrCreateKotlinClass(EMPTY.class), Reflection.getOrCreateKotlinClass(ErrorNoNetwork.class), Reflection.getOrCreateKotlinClass(RepairGameDialog.class), Reflection.getOrCreateKotlinClass(RepairGameError.class), Reflection.getOrCreateKotlinClass(RepairGameSuccess.class)}, new KSerializer[]{new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.ActivityError", ActivityError.INSTANCE, new Annotation[0]), MainComponent$DialogConfig$DownloadCache$$serializer.INSTANCE, new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.EMPTY", EMPTY.INSTANCE, new Annotation[0]), MainComponent$DialogConfig$ErrorNoNetwork$$serializer.INSTANCE, new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.RepairGameDialog", RepairGameDialog.INSTANCE, new Annotation[0]), new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.RepairGameError", RepairGameError.INSTANCE, new Annotation[0]), new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.RepairGameSuccess", RepairGameSuccess.INSTANCE, new Annotation[0])}, new Annotation[0]);
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$EMPTY;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class EMPTY implements DialogConfig {
            public static final EMPTY INSTANCE = new EMPTY();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$DialogConfig$EMPTY$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.DialogConfig.EMPTY._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof EMPTY) {
                    EMPTY empty = (EMPTY) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 2016049899;
            }

            public String toString() {
                return "EMPTY";
            }

            private EMPTY() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.EMPTY", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<EMPTY> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$DownloadCache;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "description", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDescription", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_root_release_web", "$serializer", "Companion", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class DownloadCache implements DialogConfig {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String description;

            public static /* synthetic */ DownloadCache copy$default(DownloadCache downloadCache, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = downloadCache.description;
                }
                return downloadCache.copy(str);
            }

            public final String component1() {
                return this.description;
            }

            public final DownloadCache copy(String description) {
                Intrinsics.checkNotNullParameter(description, "description");
                return new DownloadCache(description);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof DownloadCache) && Intrinsics.areEqual(this.description, ((DownloadCache) obj).description);
            }

            public int hashCode() {
                return this.description.hashCode();
            }

            public String toString() {
                return "DownloadCache(description=" + this.description + ")";
            }

            /* compiled from: MainComponent.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$DownloadCache$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$DownloadCache;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
            /* loaded from: classes4.dex */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<DownloadCache> serializer() {
                    return MainComponent$DialogConfig$DownloadCache$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ DownloadCache(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, MainComponent$DialogConfig$DownloadCache$$serializer.INSTANCE.getDescriptor());
                }
                this.description = str;
            }

            public DownloadCache(String description) {
                Intrinsics.checkNotNullParameter(description, "description");
                this.description = description;
            }

            public final String getDescription() {
                return this.description;
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$RepairGameSuccess;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class RepairGameSuccess implements DialogConfig {
            public static final RepairGameSuccess INSTANCE = new RepairGameSuccess();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$DialogConfig$RepairGameSuccess$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.DialogConfig.RepairGameSuccess._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RepairGameSuccess) {
                    RepairGameSuccess repairGameSuccess = (RepairGameSuccess) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 536696450;
            }

            public String toString() {
                return "RepairGameSuccess";
            }

            private RepairGameSuccess() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.RepairGameSuccess", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<RepairGameSuccess> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$RepairGameError;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class RepairGameError implements DialogConfig {
            public static final RepairGameError INSTANCE = new RepairGameError();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$DialogConfig$RepairGameError$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.DialogConfig.RepairGameError._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RepairGameError) {
                    RepairGameError repairGameError = (RepairGameError) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 818838599;
            }

            public String toString() {
                return "RepairGameError";
            }

            private RepairGameError() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.RepairGameError", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<RepairGameError> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$ActivityError;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class ActivityError implements DialogConfig {
            public static final ActivityError INSTANCE = new ActivityError();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$DialogConfig$ActivityError$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.DialogConfig.ActivityError._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ActivityError) {
                    ActivityError activityError = (ActivityError) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -2127233065;
            }

            public String toString() {
                return "ActivityError";
            }

            private ActivityError() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.ActivityError", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<ActivityError> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\f\u001a\u00020\rHÖ\u0001¨\u0006\u000e"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$RepairGameDialog;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class RepairGameDialog implements DialogConfig {
            public static final RepairGameDialog INSTANCE = new RepairGameDialog();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.miami.game.core.app.root.nav.main.MainComponent$DialogConfig$RepairGameDialog$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = MainComponent.DialogConfig.RepairGameDialog._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
            public static final int $stable = 8;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof RepairGameDialog) {
                    RepairGameDialog repairGameDialog = (RepairGameDialog) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -423257367;
            }

            public String toString() {
                return "RepairGameDialog";
            }

            private RepairGameDialog() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return new ObjectSerializer("com.miami.game.core.app.root.nav.main.MainComponent.DialogConfig.RepairGameDialog", INSTANCE, new Annotation[0]);
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<RepairGameDialog> serializer() {
                return get$cachedSerializer();
            }
        }

        /* compiled from: MainComponent.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$ErrorNoNetwork;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig;", "errorMessage", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_root_release_web", "$serializer", "Companion", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
        @Serializable
        /* loaded from: classes4.dex */
        public static final class ErrorNoNetwork implements DialogConfig {
            public static final int $stable = 0;
            public static final Companion Companion = new Companion(null);
            private final String errorMessage;

            public static /* synthetic */ ErrorNoNetwork copy$default(ErrorNoNetwork errorNoNetwork, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = errorNoNetwork.errorMessage;
                }
                return errorNoNetwork.copy(str);
            }

            public final String component1() {
                return this.errorMessage;
            }

            public final ErrorNoNetwork copy(String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                return new ErrorNoNetwork(errorMessage);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ErrorNoNetwork) && Intrinsics.areEqual(this.errorMessage, ((ErrorNoNetwork) obj).errorMessage);
            }

            public int hashCode() {
                return this.errorMessage.hashCode();
            }

            public String toString() {
                return "ErrorNoNetwork(errorMessage=" + this.errorMessage + ")";
            }

            /* compiled from: MainComponent.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$ErrorNoNetwork$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/miami/game/core/app/root/nav/main/MainComponent$DialogConfig$ErrorNoNetwork;", "app-root_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
            /* loaded from: classes4.dex */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<ErrorNoNetwork> serializer() {
                    return MainComponent$DialogConfig$ErrorNoNetwork$$serializer.INSTANCE;
                }
            }

            public /* synthetic */ ErrorNoNetwork(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, MainComponent$DialogConfig$ErrorNoNetwork$$serializer.INSTANCE.getDescriptor());
                }
                this.errorMessage = str;
            }

            public ErrorNoNetwork(String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                this.errorMessage = errorMessage;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }
        }
    }
}
