package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import java.util.concurrent.Executor;
import javax.inject.Provider;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class DaggerTransportRuntimeComponent {
    private DaggerTransportRuntimeComponent() {
    }

    public static TransportRuntimeComponent.Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Builder implements TransportRuntimeComponent.Builder {
        private Context setApplicationContext;

        private Builder() {
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public Builder setApplicationContext(Context context) {
            this.setApplicationContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public TransportRuntimeComponent build() {
            Preconditions.checkBuilderRequirement(this.setApplicationContext, Context.class);
            return new TransportRuntimeComponentImpl(this.setApplicationContext);
        }
    }

    /* loaded from: classes3.dex */
    private static final class TransportRuntimeComponentImpl extends TransportRuntimeComponent {
        private Provider<SchedulerConfig> configProvider;
        private Provider creationContextFactoryProvider;
        private Provider<DefaultScheduler> defaultSchedulerProvider;
        private Provider<Executor> executorProvider;
        private Provider metadataBackendRegistryProvider;
        private Provider<String> packageNameProvider;
        private Provider<SQLiteEventStore> sQLiteEventStoreProvider;
        private Provider schemaManagerProvider;
        private Provider<Context> setApplicationContextProvider;
        private final TransportRuntimeComponentImpl transportRuntimeComponentImpl;
        private Provider<TransportRuntime> transportRuntimeProvider;
        private Provider<Uploader> uploaderProvider;
        private Provider<WorkInitializer> workInitializerProvider;
        private Provider<WorkScheduler> workSchedulerProvider;

        private TransportRuntimeComponentImpl(Context context) {
            this.transportRuntimeComponentImpl = this;
            initialize(context);
        }

        private void initialize(Context context) {
            this.executorProvider = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
            Factory create = InstanceFactory.create(context);
            this.setApplicationContextProvider = create;
            CreationContextFactory_Factory create2 = CreationContextFactory_Factory.create(create, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
            this.creationContextFactoryProvider = create2;
            this.metadataBackendRegistryProvider = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.setApplicationContextProvider, create2));
            this.schemaManagerProvider = SchemaManager_Factory.create(this.setApplicationContextProvider, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
            this.packageNameProvider = DoubleCheck.provider(EventStoreModule_PackageNameFactory.create(this.setApplicationContextProvider));
            this.sQLiteEventStoreProvider = DoubleCheck.provider(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.schemaManagerProvider, this.packageNameProvider));
            SchedulingConfigModule_ConfigFactory create3 = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
            this.configProvider = create3;
            SchedulingModule_WorkSchedulerFactory create4 = SchedulingModule_WorkSchedulerFactory.create(this.setApplicationContextProvider, this.sQLiteEventStoreProvider, create3, TimeModule_UptimeClockFactory.create());
            this.workSchedulerProvider = create4;
            Provider<Executor> provider = this.executorProvider;
            Provider provider2 = this.metadataBackendRegistryProvider;
            Provider<SQLiteEventStore> provider3 = this.sQLiteEventStoreProvider;
            this.defaultSchedulerProvider = DefaultScheduler_Factory.create(provider, provider2, create4, provider3, provider3);
            Provider<Context> provider4 = this.setApplicationContextProvider;
            Provider provider5 = this.metadataBackendRegistryProvider;
            Provider<SQLiteEventStore> provider6 = this.sQLiteEventStoreProvider;
            this.uploaderProvider = Uploader_Factory.create(provider4, provider5, provider6, this.workSchedulerProvider, this.executorProvider, provider6, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.sQLiteEventStoreProvider);
            Provider<Executor> provider7 = this.executorProvider;
            Provider<SQLiteEventStore> provider8 = this.sQLiteEventStoreProvider;
            this.workInitializerProvider = WorkInitializer_Factory.create(provider7, provider8, this.workSchedulerProvider, provider8);
            this.transportRuntimeProvider = DoubleCheck.provider(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.defaultSchedulerProvider, this.uploaderProvider, this.workInitializerProvider));
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
        TransportRuntime getTransportRuntime() {
            return this.transportRuntimeProvider.get();
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
        EventStore getEventStore() {
            return this.sQLiteEventStoreProvider.get();
        }
    }
}
