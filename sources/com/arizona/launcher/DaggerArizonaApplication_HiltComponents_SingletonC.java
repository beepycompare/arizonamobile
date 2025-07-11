package com.arizona.launcher;

import android.app.Activity;
import android.app.Service;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.arizona.launcher.ArizonaApplication_HiltComponents;
import com.arizona.launcher.MainViewModel_HiltModules;
import com.arizona.launcher.data.database.ArizonaDatabase;
import com.arizona.launcher.data.database.NotificationHistoryDAO;
import com.arizona.launcher.data.repository.PreferencesRepository;
import com.arizona.launcher.data.repository.notifications.NotificationsRepository;
import com.arizona.launcher.data.repository.settings.SettingsRepository;
import com.arizona.launcher.data.rx.SchedulersFacade;
import com.arizona.launcher.di.ArizonaLauncherAPIModule;
import com.arizona.launcher.di.ArizonaLauncherAPIModule_ProvideNotificationsApiFactory;
import com.arizona.launcher.di.CoreAppModule_ProvideBuildConfigRepositoryFactory;
import com.arizona.launcher.di.CoreAppModule_ProvidesResourcesFactory;
import com.arizona.launcher.di.DatabaseModule;
import com.arizona.launcher.di.DatabaseModule_ProvideNotificationHistoryDAOFactory;
import com.arizona.launcher.di.DatabaseModule_ProvideRideDatabaseFactory;
import com.arizona.launcher.di.PreferencesModule;
import com.arizona.launcher.di.PreferencesModule_ProvideSharedPreferencesFactory;
import com.arizona.launcher.di.UpdateApiModule;
import com.arizona.launcher.ui.notifications.NotificationsViewModel;
import com.arizona.launcher.ui.notifications.NotificationsViewModel_HiltModules;
import com.arizona.launcher.ui.notifications.NotificationsViewModel_HiltModules_BindsModule_Binds_LazyMapKey;
import com.arizona.launcher.ui.notifications.NotificationsViewModel_HiltModules_KeyModule_Provide_LazyMapKey;
import com.arkivanov.decompose.ComponentContext;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.miami.game.core.api.network.NetworkDataSource;
import com.miami.game.core.api.network.di.NetworkApiModule_ProvideAppNetworkDataSourceFactory;
import com.miami.game.core.api.network.di.NetworkApiModule_ProvideGsonFactory;
import com.miami.game.core.api.network.di.NetworkApiModule_ProvideOkHttpClientFactory;
import com.miami.game.core.app.root.nav.main.MainComponent;
import com.miami.game.core.connection.resolver.data.AvailabilityService;
import com.miami.game.core.connection.resolver.data.ConnectionResolverImpl;
import com.miami.game.core.connection.resolver.data.ServersList;
import com.miami.game.core.downloader.DowndloaderModule;
import com.miami.game.core.downloader.DowndloaderModule_ProvideDownloaderFactory;
import com.miami.game.core.downloader.Downloader;
import com.miami.game.core.downloader.database.DownloaderInfoDatabase;
import com.miami.game.core.downloader.database.LauncherDBModule;
import com.miami.game.core.downloader.database.LauncherDBModule_ProvideDownloaderInfoDatabaseFactory;
import com.miami.game.core.downloader.sync.DowndloaderSyncModule;
import com.miami.game.core.downloader.sync.DowndloaderSyncModule_ProvideDownloaderFactory;
import com.miami.game.core.downloader.sync.data.DownloaderSyncRepository;
import com.miami.game.core.downloader.sync.data.api.DownloaderSyncApiRepository;
import com.miami.game.core.downloader.sync.data.store.DownloaderSyncDbRepository;
import com.miami.game.core.downloader.sync.domain.DownloaderSyncInteractor;
import com.miami.game.core.files.Files;
import com.miami.game.core.files.updater.domain.FilesUpdaterInteractor;
import com.miami.game.core.foreground.service.DownloadService;
import com.miami.game.core.foreground.service.DownloadService_MembersInjector;
import com.miami.game.core.local.repository.common.LocalRepository;
import com.miami.game.core.local.repository.di.LocalRepositoryModule_ProvideGsonFactory;
import com.miami.game.core.local.repository.di.LocalRepositoryModule_ProvideLocalRepositoryFactory;
import com.miami.game.core.news.data.NewsRepository;
import com.miami.game.core.news.data.api.NewsApiRepository;
import com.miami.game.core.news.data.store.NewsPrefRepository;
import com.miami.game.core.news.domain.NewsInteractor;
import com.miami.game.core.privacy.privacyInteractor;
import com.miami.game.core.server.ServersInteractor;
import com.miami.game.core.server.data.FavoriteServerDatabase;
import com.miami.game.core.server.di.FavoriteServerModule;
import com.miami.game.core.server.di.FavoriteServerModule_ProvideFavoriteServerDbFactory;
import com.miami.game.core.settings.SettingsInteractor;
import com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent;
import com.miami.game.feature.download.dialog.ui.error.map.ErrorDialogUiAssembler;
import com.miami.game.feature.download.screen.ui.DownloadScreenComponent;
import com.miami.game.feature.home.ui.HomeComponent;
import com.miami.game.feature.notifications.NotificationStateHolder;
import com.miami.game.feature.notifications.presentation.NotificationsComponent;
import com.miami.game.feature.select.server.ui.SelectServerComponent;
import com.miami.game.feature.settings.ui.SettingsComponent;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;
import java.util.Map;
import java.util.Set;
import okhttp3.OkHttpClient;
/* loaded from: classes3.dex */
public final class DaggerArizonaApplication_HiltComponents_SingletonC {
    private DaggerArizonaApplication_HiltComponents_SingletonC() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private ApplicationContextModule applicationContextModule;
        private ArizonaLauncherAPIModule arizonaLauncherAPIModule;
        private DatabaseModule databaseModule;
        private DowndloaderModule downdloaderModule;
        private DowndloaderSyncModule downdloaderSyncModule;
        private FavoriteServerModule favoriteServerModule;
        private LauncherDBModule launcherDBModule;
        private PreferencesModule preferencesModule;

        private Builder() {
        }

        public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
            this.applicationContextModule = (ApplicationContextModule) Preconditions.checkNotNull(applicationContextModule);
            return this;
        }

        public Builder arizonaLauncherAPIModule(ArizonaLauncherAPIModule arizonaLauncherAPIModule) {
            this.arizonaLauncherAPIModule = (ArizonaLauncherAPIModule) Preconditions.checkNotNull(arizonaLauncherAPIModule);
            return this;
        }

        public Builder databaseModule(DatabaseModule databaseModule) {
            this.databaseModule = (DatabaseModule) Preconditions.checkNotNull(databaseModule);
            return this;
        }

        public Builder downdloaderModule(DowndloaderModule downdloaderModule) {
            this.downdloaderModule = (DowndloaderModule) Preconditions.checkNotNull(downdloaderModule);
            return this;
        }

        public Builder downdloaderSyncModule(DowndloaderSyncModule downdloaderSyncModule) {
            this.downdloaderSyncModule = (DowndloaderSyncModule) Preconditions.checkNotNull(downdloaderSyncModule);
            return this;
        }

        public Builder favoriteServerModule(FavoriteServerModule favoriteServerModule) {
            this.favoriteServerModule = (FavoriteServerModule) Preconditions.checkNotNull(favoriteServerModule);
            return this;
        }

        public Builder launcherDBModule(LauncherDBModule launcherDBModule) {
            this.launcherDBModule = (LauncherDBModule) Preconditions.checkNotNull(launcherDBModule);
            return this;
        }

        public Builder preferencesModule(PreferencesModule preferencesModule) {
            this.preferencesModule = (PreferencesModule) Preconditions.checkNotNull(preferencesModule);
            return this;
        }

        @Deprecated
        public Builder updateApiModule(UpdateApiModule updateApiModule) {
            Preconditions.checkNotNull(updateApiModule);
            return this;
        }

        public ArizonaApplication_HiltComponents.SingletonC build() {
            Preconditions.checkBuilderRequirement(this.applicationContextModule, ApplicationContextModule.class);
            if (this.arizonaLauncherAPIModule == null) {
                this.arizonaLauncherAPIModule = new ArizonaLauncherAPIModule();
            }
            if (this.databaseModule == null) {
                this.databaseModule = new DatabaseModule();
            }
            if (this.downdloaderModule == null) {
                this.downdloaderModule = new DowndloaderModule();
            }
            if (this.downdloaderSyncModule == null) {
                this.downdloaderSyncModule = new DowndloaderSyncModule();
            }
            if (this.favoriteServerModule == null) {
                this.favoriteServerModule = new FavoriteServerModule();
            }
            if (this.launcherDBModule == null) {
                this.launcherDBModule = new LauncherDBModule();
            }
            if (this.preferencesModule == null) {
                this.preferencesModule = new PreferencesModule();
            }
            return new SingletonCImpl(this.applicationContextModule, this.arizonaLauncherAPIModule, this.databaseModule, this.downdloaderModule, this.downdloaderSyncModule, this.favoriteServerModule, this.launcherDBModule, this.preferencesModule);
        }
    }

    /* loaded from: classes3.dex */
    private static final class ActivityRetainedCBuilder implements ArizonaApplication_HiltComponents.ActivityRetainedC.Builder {
        private SavedStateHandleHolder savedStateHandleHolder;
        private final SingletonCImpl singletonCImpl;

        private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
            this.singletonCImpl = singletonCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
        public ActivityRetainedCBuilder savedStateHandleHolder(SavedStateHandleHolder savedStateHandleHolder) {
            this.savedStateHandleHolder = (SavedStateHandleHolder) Preconditions.checkNotNull(savedStateHandleHolder);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder
        public ArizonaApplication_HiltComponents.ActivityRetainedC build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandleHolder, SavedStateHandleHolder.class);
            return new ActivityRetainedCImpl(this.singletonCImpl, this.savedStateHandleHolder);
        }
    }

    /* loaded from: classes3.dex */
    private static final class ActivityCBuilder implements ArizonaApplication_HiltComponents.ActivityC.Builder {
        private Activity activity;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;

        private ActivityCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
        public ActivityCBuilder activity(Activity activity) {
            this.activity = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ActivityComponentBuilder
        public ArizonaApplication_HiltComponents.ActivityC build() {
            Preconditions.checkBuilderRequirement(this.activity, Activity.class);
            return new ActivityCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activity);
        }
    }

    /* loaded from: classes3.dex */
    private static final class FragmentCBuilder implements ArizonaApplication_HiltComponents.FragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Fragment fragment;
        private final SingletonCImpl singletonCImpl;

        private FragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.FragmentComponentBuilder
        public FragmentCBuilder fragment(Fragment fragment) {
            this.fragment = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.FragmentComponentBuilder
        public ArizonaApplication_HiltComponents.FragmentC build() {
            Preconditions.checkBuilderRequirement(this.fragment, Fragment.class);
            return new FragmentCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragment);
        }
    }

    /* loaded from: classes3.dex */
    private static final class ViewWithFragmentCBuilder implements ArizonaApplication_HiltComponents.ViewWithFragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private View view;

        private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCImpl = fragmentCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder
        public ViewWithFragmentCBuilder view(View view) {
            this.view = (View) Preconditions.checkNotNull(view);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder
        public ArizonaApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewWithFragmentCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl, this.view);
        }
    }

    /* loaded from: classes3.dex */
    private static final class ViewCBuilder implements ArizonaApplication_HiltComponents.ViewC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private View view;

        private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewComponentBuilder
        public ViewCBuilder view(View view) {
            this.view = (View) Preconditions.checkNotNull(view);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewComponentBuilder
        public ArizonaApplication_HiltComponents.ViewC build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ViewModelCBuilder implements ArizonaApplication_HiltComponents.ViewModelC.Builder {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private SavedStateHandle savedStateHandle;
        private final SingletonCImpl singletonCImpl;
        private ViewModelLifecycle viewModelLifecycle;

        private ViewModelCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(handle);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
            this.viewModelLifecycle = (ViewModelLifecycle) Preconditions.checkNotNull(viewModelLifecycle);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ViewModelComponentBuilder
        public ArizonaApplication_HiltComponents.ViewModelC build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            Preconditions.checkBuilderRequirement(this.viewModelLifecycle, ViewModelLifecycle.class);
            return new ViewModelCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.savedStateHandle, this.viewModelLifecycle);
        }
    }

    /* loaded from: classes3.dex */
    private static final class ServiceCBuilder implements ArizonaApplication_HiltComponents.ServiceC.Builder {
        private Service service;
        private final SingletonCImpl singletonCImpl;

        private ServiceCBuilder(SingletonCImpl singletonCImpl) {
            this.singletonCImpl = singletonCImpl;
        }

        @Override // dagger.hilt.android.internal.builders.ServiceComponentBuilder
        public ServiceCBuilder service(Service service) {
            this.service = (Service) Preconditions.checkNotNull(service);
            return this;
        }

        @Override // dagger.hilt.android.internal.builders.ServiceComponentBuilder
        public ArizonaApplication_HiltComponents.ServiceC build() {
            Preconditions.checkBuilderRequirement(this.service, Service.class);
            return new ServiceCImpl(this.singletonCImpl, this.service);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ViewWithFragmentCImpl extends ArizonaApplication_HiltComponents.ViewWithFragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

        ViewWithFragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, FragmentCImpl fragmentCImpl, View viewParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCImpl = fragmentCImpl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class FragmentCImpl extends ArizonaApplication_HiltComponents.FragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl = this;
        private final SingletonCImpl singletonCImpl;

        FragmentCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, Fragment fragmentParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }

        @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.FragmentEntryPoint
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return this.activityCImpl.getHiltInternalFactoryFactory();
        }

        @Override // dagger.hilt.android.internal.managers.ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
            return new ViewWithFragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ViewCImpl extends ArizonaApplication_HiltComponents.ViewC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewCImpl viewCImpl = this;

        ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, View viewParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ActivityCImpl extends ArizonaApplication_HiltComponents.ActivityC {
        private final ActivityCImpl activityCImpl = this;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        Provider<HomeComponent.Factory> factoryProvider;
        Provider<SelectServerComponent.Factory> factoryProvider2;
        Provider<SettingsComponent.Factory> factoryProvider3;
        Provider<CommonDialogComponent.Factory> factoryProvider4;
        Provider<ErrorDialogComponent.Factory> factoryProvider5;
        Provider<DownloadScreenComponent.Factory> factoryProvider6;
        Provider<NotificationsComponent.Factory> factoryProvider7;
        Provider<MainComponent.Factory> factoryProvider8;
        private final SingletonCImpl singletonCImpl;

        @Override // com.arizona.launcher.MainActivity_GeneratedInjector
        public void injectMainActivity(MainActivity mainActivity) {
        }

        ActivityCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            initialize(activityParam);
        }

        ErrorDialogUiAssembler errorDialogUiAssembler() {
            return new ErrorDialogUiAssembler(this.singletonCImpl.resources());
        }

        private void initialize(final Activity activityParam) {
            this.factoryProvider = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 1));
            this.factoryProvider2 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 2));
            this.factoryProvider3 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 3));
            this.factoryProvider4 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 4));
            this.factoryProvider5 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 5));
            this.factoryProvider6 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 6));
            this.factoryProvider7 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 7));
            this.factoryProvider8 = SingleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, 0));
        }

        @Override // com.arizona.launcher.MainEntrench_GeneratedInjector
        public void injectMainEntrench(MainEntrench mainEntrench) {
            injectMainEntrench2(mainEntrench);
        }

        @Override // com.arizona.launcher.UpdateActivity_GeneratedInjector
        public void injectUpdateActivity(UpdateActivity updateActivity) {
            injectUpdateActivity2(updateActivity);
        }

        @Override // dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories.ActivityEntryPoint
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl));
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
        public Map<Class<?>, Boolean> getViewModelKeys() {
            return LazyClassKeyMap.of(ImmutableMap.of(MainViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(MainViewModel_HiltModules.KeyModule.provide()), NotificationsViewModel_HiltModules_KeyModule_Provide_LazyMapKey.lazyClassKeyName, Boolean.valueOf(NotificationsViewModel_HiltModules.KeyModule.provide())));
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ActivityCreatorEntryPoint
        public ViewModelComponentBuilder getViewModelComponentBuilder() {
            return new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.FragmentComponentManager.FragmentComponentBuilderEntryPoint
        public FragmentComponentBuilder fragmentComponentBuilder() {
            return new FragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ViewComponentManager.ViewComponentBuilderEntryPoint
        public ViewComponentBuilder viewComponentBuilder() {
            return new ViewCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        private MainEntrench injectMainEntrench2(MainEntrench instance) {
            MainEntrench_MembersInjector.injectRootFactory(instance, this.factoryProvider8.get());
            MainEntrench_MembersInjector.injectNotificationStateHolder(instance, this.singletonCImpl.notificationStateHolderProvider.get());
            return instance;
        }

        private UpdateActivity injectUpdateActivity2(UpdateActivity instance2) {
            UpdateActivity_MembersInjector.injectRootFactory(instance2, this.factoryProvider6.get());
            return instance2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityCImpl activityCImpl;
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.activityCImpl = activityCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new MainComponent.Factory() { // from class: com.arizona.launcher.DaggerArizonaApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.1
                            @Override // com.miami.game.core.app.root.nav.main.MainComponent.Factory
                            public MainComponent invoke(ComponentContext componentContext) {
                                return new MainComponent(componentContext, SwitchingProvider.this.activityCImpl.factoryProvider.get(), SwitchingProvider.this.activityCImpl.factoryProvider2.get(), SwitchingProvider.this.activityCImpl.factoryProvider3.get(), SwitchingProvider.this.activityCImpl.factoryProvider4.get(), SwitchingProvider.this.activityCImpl.factoryProvider5.get(), SwitchingProvider.this.activityCImpl.factoryProvider6.get(), SwitchingProvider.this.activityCImpl.factoryProvider7.get());
                            }
                        };
                    case 1:
                        return (T) new HomeComponent.Factory() { // from class: com.arizona.launcher.DaggerArizonaApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.2
                            @Override // com.miami.game.feature.home.ui.HomeComponent.Factory
                            public HomeComponent invoke(ComponentContext componentContext2) {
                                return new HomeComponent(componentContext2, SwitchingProvider.this.singletonCImpl.privacyInteractorProvider.get(), SwitchingProvider.this.singletonCImpl.newsInteractorProvider.get(), CoreAppModule_ProvideBuildConfigRepositoryFactory.provideBuildConfigRepository(), SwitchingProvider.this.singletonCImpl.provideAppNetworkDataSourceProvider.get(), SwitchingProvider.this.singletonCImpl.serversInteractorProvider.get(), SwitchingProvider.this.singletonCImpl.settingsInteractorProvider.get(), SwitchingProvider.this.singletonCImpl.notificationStateHolderProvider.get());
                            }
                        };
                    case 2:
                        return (T) new SelectServerComponent.Factory() { // from class: com.arizona.launcher.DaggerArizonaApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.3
                            @Override // com.miami.game.feature.select.server.ui.SelectServerComponent.Factory
                            public SelectServerComponent invoke(ComponentContext componentContext3) {
                                return new SelectServerComponent(componentContext3, SwitchingProvider.this.singletonCImpl.serversInteractorProvider.get(), CoreAppModule_ProvideBuildConfigRepositoryFactory.provideBuildConfigRepository());
                            }
                        };
                    case 3:
                        return (T) new SettingsComponent.Factory() { // from class: com.arizona.launcher.DaggerArizonaApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.4
                            @Override // com.miami.game.feature.settings.ui.SettingsComponent.Factory
                            public SettingsComponent invoke(ComponentContext componentContext4) {
                                return new SettingsComponent(componentContext4, SwitchingProvider.this.singletonCImpl.filesUpdaterInteractorProvider.get(), CoreAppModule_ProvideBuildConfigRepositoryFactory.provideBuildConfigRepository(), SwitchingProvider.this.singletonCImpl.settingsInteractorProvider.get());
                            }
                        };
                    case 4:
                        return (T) new CommonDialogComponent.Factory() { // from class: com.arizona.launcher.DaggerArizonaApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.5
                            @Override // com.miami.game.feature.download.dialog.ui.common.CommonDialogComponent.Factory
                            public CommonDialogComponent invoke(ComponentContext componentContext5, String description) {
                                return new CommonDialogComponent(componentContext5, description, SwitchingProvider.this.singletonCImpl.resources(), CoreAppModule_ProvideBuildConfigRepositoryFactory.provideBuildConfigRepository(), SwitchingProvider.this.singletonCImpl.privacyInteractorProvider.get());
                            }
                        };
                    case 5:
                        return (T) new ErrorDialogComponent.Factory() { // from class: com.arizona.launcher.DaggerArizonaApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.6
                            @Override // com.miami.game.feature.download.dialog.ui.error.ErrorDialogComponent.Factory
                            public ErrorDialogComponent invoke(ComponentContext componentContext6, String errorMessage) {
                                return new ErrorDialogComponent(errorMessage, componentContext6, SwitchingProvider.this.activityCImpl.errorDialogUiAssembler(), SwitchingProvider.this.singletonCImpl.resources());
                            }
                        };
                    case 6:
                        return (T) new DownloadScreenComponent.Factory() { // from class: com.arizona.launcher.DaggerArizonaApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.7
                            @Override // com.miami.game.feature.download.screen.ui.DownloadScreenComponent.Factory
                            public DownloadScreenComponent invoke(ComponentContext componentContext7) {
                                return new DownloadScreenComponent(componentContext7, SwitchingProvider.this.singletonCImpl.filesUpdaterInteractorProvider.get(), CoreAppModule_ProvideBuildConfigRepositoryFactory.provideBuildConfigRepository(), SwitchingProvider.this.singletonCImpl.provideLocalRepositoryProvider.get());
                            }
                        };
                    case 7:
                        return (T) new NotificationsComponent.Factory() { // from class: com.arizona.launcher.DaggerArizonaApplication_HiltComponents_SingletonC.ActivityCImpl.SwitchingProvider.8
                            @Override // com.miami.game.feature.notifications.presentation.NotificationsComponent.Factory
                            public NotificationsComponent invoke(ComponentContext componentContext8) {
                                return new NotificationsComponent(componentContext8, CoreAppModule_ProvideBuildConfigRepositoryFactory.provideBuildConfigRepository(), SwitchingProvider.this.singletonCImpl.notificationStateHolderProvider.get());
                            }
                        };
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ViewModelCImpl extends ArizonaApplication_HiltComponents.ViewModelC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        Provider<MainViewModel> mainViewModelProvider;
        Provider<NotificationsViewModel> notificationsViewModelProvider;
        private final SingletonCImpl singletonCImpl;
        private final ViewModelCImpl viewModelCImpl = this;

        ViewModelCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam, ViewModelLifecycle viewModelLifecycleParam) {
            this.singletonCImpl = singletonCImpl;
            this.activityRetainedCImpl = activityRetainedCImpl;
            initialize(savedStateHandleParam, viewModelLifecycleParam);
        }

        NotificationsRepository notificationsRepository() {
            return new NotificationsRepository(ArizonaLauncherAPIModule_ProvideNotificationsApiFactory.provideNotificationsApi(this.singletonCImpl.arizonaLauncherAPIModule), this.singletonCImpl.provideNotificationHistoryDAOProvider.get());
        }

        private void initialize(final SavedStateHandle savedStateHandleParam, final ViewModelLifecycle viewModelLifecycleParam) {
            this.mainViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 0);
            this.notificationsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 1);
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
        public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
            return LazyClassKeyMap.of(ImmutableMap.of(MainViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, (Provider<NotificationsViewModel>) this.mainViewModelProvider, NotificationsViewModel_HiltModules_BindsModule_Binds_LazyMapKey.lazyClassKeyName, this.notificationsViewModelProvider));
        }

        @Override // dagger.hilt.android.internal.lifecycle.HiltViewModelFactory.ViewModelFactoriesEntryPoint
        public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
            return ImmutableMap.of();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;
            private final ViewModelCImpl viewModelCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, ViewModelCImpl viewModelCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.viewModelCImpl = viewModelCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                int i = this.id;
                if (i != 0) {
                    if (i == 1) {
                        return (T) new NotificationsViewModel(this.viewModelCImpl.notificationsRepository(), new SchedulersFacade());
                    }
                    throw new AssertionError(this.id);
                }
                return (T) new MainViewModel(this.singletonCImpl.settingsRepositoryProvider.get(), this.singletonCImpl.preferencesRepositoryProvider.get());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ActivityRetainedCImpl extends ArizonaApplication_HiltComponents.ActivityRetainedC {
        private final ActivityRetainedCImpl activityRetainedCImpl = this;
        Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;
        private final SingletonCImpl singletonCImpl;

        ActivityRetainedCImpl(SingletonCImpl singletonCImpl, SavedStateHandleHolder savedStateHandleHolderParam) {
            this.singletonCImpl = singletonCImpl;
            initialize(savedStateHandleHolderParam);
        }

        private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
            this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 0));
        }

        @Override // dagger.hilt.android.internal.managers.ActivityComponentManager.ActivityComponentBuilderEntryPoint
        public ActivityComponentBuilder activityComponentBuilder() {
            return new ActivityCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedLifecycleEntryPoint
        public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
            return this.provideActivityRetainedLifecycleProvider.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.activityRetainedCImpl = activityRetainedCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                if (this.id == 0) {
                    return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();
                }
                throw new AssertionError(this.id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ServiceCImpl extends ArizonaApplication_HiltComponents.ServiceC {
        private final ServiceCImpl serviceCImpl = this;
        private final SingletonCImpl singletonCImpl;

        @Override // com.arizona.launcher.UpdateService_GeneratedInjector
        public void injectUpdateService(UpdateService updateService) {
        }

        ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
            this.singletonCImpl = singletonCImpl;
        }

        @Override // com.miami.game.core.foreground.service.DownloadService_GeneratedInjector
        public void injectDownloadService(DownloadService arg0) {
            injectDownloadService2(arg0);
        }

        private DownloadService injectDownloadService2(DownloadService instance) {
            DownloadService_MembersInjector.injectFilesUpdaterInteractor(instance, this.singletonCImpl.filesUpdaterInteractorProvider.get());
            return instance;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class SingletonCImpl extends ArizonaApplication_HiltComponents.SingletonC {
        private final ApplicationContextModule applicationContextModule;
        private final ArizonaLauncherAPIModule arizonaLauncherAPIModule;
        Provider<AvailabilityService> availabilityServiceProvider;
        private final DatabaseModule databaseModule;
        private final DowndloaderModule downdloaderModule;
        private final DowndloaderSyncModule downdloaderSyncModule;
        Provider<DownloaderSyncDbRepository> downloaderSyncDbRepositoryProvider;
        Provider<DownloaderSyncInteractor> downloaderSyncInteractorProvider;
        private final FavoriteServerModule favoriteServerModule;
        Provider<FilesUpdaterInteractor> filesUpdaterInteractorProvider;
        private final LauncherDBModule launcherDBModule;
        Provider<NewsInteractor> newsInteractorProvider;
        Provider<NotificationStateHolder> notificationStateHolderProvider;
        private final PreferencesModule preferencesModule;
        Provider<PreferencesRepository> preferencesRepositoryProvider;
        Provider<privacyInteractor> privacyInteractorProvider;
        Provider<NetworkDataSource> provideAppNetworkDataSourceProvider;
        Provider<DownloaderInfoDatabase> provideDownloaderInfoDatabaseProvider;
        Provider<FavoriteServerDatabase> provideFavoriteServerDbProvider;
        Provider<Gson> provideGsonProvider;
        Provider<Gson> provideGsonProvider2;
        Provider<LocalRepository> provideLocalRepositoryProvider;
        Provider<NotificationHistoryDAO> provideNotificationHistoryDAOProvider;
        Provider<OkHttpClient> provideOkHttpClientProvider;
        Provider<ArizonaDatabase> provideRideDatabaseProvider;
        Provider<ServersInteractor> serversInteractorProvider;
        Provider<SettingsInteractor> settingsInteractorProvider;
        Provider<SettingsRepository> settingsRepositoryProvider;
        private final SingletonCImpl singletonCImpl = this;

        @Override // com.arizona.launcher.ArizonaApplication_GeneratedInjector
        public void injectArizonaApplication(ArizonaApplication arizonaApplication) {
        }

        SingletonCImpl(ApplicationContextModule applicationContextModuleParam, ArizonaLauncherAPIModule arizonaLauncherAPIModuleParam, DatabaseModule databaseModuleParam, DowndloaderModule downdloaderModuleParam, DowndloaderSyncModule downdloaderSyncModuleParam, FavoriteServerModule favoriteServerModuleParam, LauncherDBModule launcherDBModuleParam, PreferencesModule preferencesModuleParam) {
            this.applicationContextModule = applicationContextModuleParam;
            this.favoriteServerModule = favoriteServerModuleParam;
            this.downdloaderModule = downdloaderModuleParam;
            this.downdloaderSyncModule = downdloaderSyncModuleParam;
            this.launcherDBModule = launcherDBModuleParam;
            this.preferencesModule = preferencesModuleParam;
            this.arizonaLauncherAPIModule = arizonaLauncherAPIModuleParam;
            this.databaseModule = databaseModuleParam;
            initialize(applicationContextModuleParam, arizonaLauncherAPIModuleParam, databaseModuleParam, downdloaderModuleParam, downdloaderSyncModuleParam, favoriteServerModuleParam, launcherDBModuleParam, preferencesModuleParam);
        }

        ServersList serversList() {
            return new ServersList(CoreAppModule_ProvideBuildConfigRepositoryFactory.provideBuildConfigRepository());
        }

        ConnectionResolverImpl connectionResolverImpl() {
            return new ConnectionResolverImpl(this.availabilityServiceProvider.get(), serversList());
        }

        NewsApiRepository newsApiRepository() {
            return new NewsApiRepository(this.provideAppNetworkDataSourceProvider.get());
        }

        NewsPrefRepository newsPrefRepository() {
            return new NewsPrefRepository(this.provideLocalRepositoryProvider.get());
        }

        NewsRepository newsRepository() {
            return new NewsRepository(newsApiRepository(), newsPrefRepository());
        }

        Downloader downloader() {
            return DowndloaderModule_ProvideDownloaderFactory.provideDownloader(this.downdloaderModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        Files files() {
            return DowndloaderSyncModule_ProvideDownloaderFactory.provideDownloader(this.downdloaderSyncModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        DownloaderSyncApiRepository downloaderSyncApiRepository() {
            return new DownloaderSyncApiRepository(downloader(), connectionResolverImpl(), files());
        }

        DownloaderSyncRepository downloaderSyncRepository() {
            return new DownloaderSyncRepository(downloaderSyncApiRepository(), this.downloaderSyncDbRepositoryProvider.get());
        }

        Resources resources() {
            return CoreAppModule_ProvidesResourcesFactory.providesResources(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        SharedPreferences sharedPreferences() {
            return PreferencesModule_ProvideSharedPreferencesFactory.provideSharedPreferences(this.preferencesModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        private void initialize(final ApplicationContextModule applicationContextModuleParam, final ArizonaLauncherAPIModule arizonaLauncherAPIModuleParam, final DatabaseModule databaseModuleParam, final DowndloaderModule downdloaderModuleParam, final DowndloaderSyncModule downdloaderSyncModuleParam, final FavoriteServerModule favoriteServerModuleParam, final LauncherDBModule launcherDBModuleParam, final PreferencesModule preferencesModuleParam) {
            this.provideGsonProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 2));
            this.provideLocalRepositoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 1));
            this.privacyInteractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 0));
            this.availabilityServiceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 5));
            this.provideOkHttpClientProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 6));
            this.provideGsonProvider2 = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 7));
            this.provideAppNetworkDataSourceProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 4));
            this.newsInteractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 3));
            this.provideFavoriteServerDbProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 9));
            this.serversInteractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 8));
            this.settingsInteractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 10));
            this.notificationStateHolderProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 11));
            this.provideDownloaderInfoDatabaseProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 15));
            this.downloaderSyncDbRepositoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 14));
            this.downloaderSyncInteractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 13));
            this.filesUpdaterInteractorProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 12));
            this.settingsRepositoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 16));
            this.preferencesRepositoryProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 17));
            this.provideRideDatabaseProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 19));
            this.provideNotificationHistoryDAOProvider = DoubleCheck.provider((Provider) new SwitchingProvider(this.singletonCImpl, 18));
        }

        @Override // dagger.hilt.android.flags.FragmentGetContextFix.FragmentGetContextFixEntryPoint
        public Set<Boolean> getDisableFragmentGetContextFix() {
            return ImmutableSet.of();
        }

        @Override // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint
        public ActivityRetainedComponentBuilder retainedComponentBuilder() {
            return new ActivityRetainedCBuilder(this.singletonCImpl);
        }

        @Override // dagger.hilt.android.internal.managers.ServiceComponentManager.ServiceComponentBuilderEntryPoint
        public ServiceComponentBuilder serviceComponentBuilder() {
            return new ServiceCBuilder(this.singletonCImpl);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final int id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
                this.singletonCImpl = singletonCImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider, jakarta.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new privacyInteractor(this.singletonCImpl.provideLocalRepositoryProvider.get());
                    case 1:
                        return (T) LocalRepositoryModule_ProvideLocalRepositoryFactory.provideLocalRepository(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), this.singletonCImpl.provideGsonProvider.get());
                    case 2:
                        return (T) LocalRepositoryModule_ProvideGsonFactory.provideGson();
                    case 3:
                        return (T) new NewsInteractor(this.singletonCImpl.newsRepository());
                    case 4:
                        return (T) NetworkApiModule_ProvideAppNetworkDataSourceFactory.provideAppNetworkDataSource(this.singletonCImpl.connectionResolverImpl(), this.singletonCImpl.provideOkHttpClientProvider.get(), this.singletonCImpl.provideGsonProvider2.get());
                    case 5:
                        return (T) new AvailabilityService();
                    case 6:
                        return (T) NetworkApiModule_ProvideOkHttpClientFactory.provideOkHttpClient();
                    case 7:
                        return (T) NetworkApiModule_ProvideGsonFactory.provideGson();
                    case 8:
                        return (T) new ServersInteractor(CoreAppModule_ProvideBuildConfigRepositoryFactory.provideBuildConfigRepository(), this.singletonCImpl.provideAppNetworkDataSourceProvider.get(), this.singletonCImpl.provideLocalRepositoryProvider.get(), this.singletonCImpl.provideFavoriteServerDbProvider.get());
                    case 9:
                        return (T) FavoriteServerModule_ProvideFavoriteServerDbFactory.provideFavoriteServerDb(this.singletonCImpl.favoriteServerModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 10:
                        return (T) new SettingsInteractor(this.singletonCImpl.provideLocalRepositoryProvider.get());
                    case 11:
                        return (T) new NotificationStateHolder();
                    case 12:
                        return (T) new FilesUpdaterInteractor(this.singletonCImpl.downloaderSyncInteractorProvider.get());
                    case 13:
                        return (T) new DownloaderSyncInteractor(this.singletonCImpl.downloaderSyncRepository());
                    case 14:
                        return (T) new DownloaderSyncDbRepository(this.singletonCImpl.provideDownloaderInfoDatabaseProvider.get());
                    case 15:
                        return (T) LauncherDBModule_ProvideDownloaderInfoDatabaseFactory.provideDownloaderInfoDatabase(this.singletonCImpl.launcherDBModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 16:
                        return (T) new SettingsRepository(this.singletonCImpl.sharedPreferences());
                    case 17:
                        return (T) new PreferencesRepository(this.singletonCImpl.sharedPreferences());
                    case 18:
                        return (T) DatabaseModule_ProvideNotificationHistoryDAOFactory.provideNotificationHistoryDAO(this.singletonCImpl.databaseModule, this.singletonCImpl.provideRideDatabaseProvider.get());
                    case 19:
                        return (T) DatabaseModule_ProvideRideDatabaseFactory.provideRideDatabase(this.singletonCImpl.databaseModule, ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }
}
