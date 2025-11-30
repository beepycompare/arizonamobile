package io.appmetrica.analytics.billing.internal;

import io.appmetrica.analytics.billing.impl.A;
import io.appmetrica.analytics.billing.impl.B;
import io.appmetrica.analytics.billing.impl.m;
import io.appmetrica.analytics.billing.impl.p;
import io.appmetrica.analytics.billing.impl.q;
import io.appmetrica.analytics.billing.internal.config.RemoteBillingConfig;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigUpdateListener;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lio/appmetrica/analytics/billing/internal/BillingServiceModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleServiceEntryPoint;", "Lio/appmetrica/analytics/billing/internal/config/RemoteBillingConfig;", "Lio/appmetrica/analytics/modulesapi/internal/service/ServiceContext;", "serviceContext", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleRemoteConfig;", "initialConfig", "", "initServiceSide", "", "e", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "f", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "getRemoteConfigExtensionConfiguration", "()Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "remoteConfigExtensionConfiguration", "<init>", "()V", "billing_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes3.dex */
public final class BillingServiceModuleEntryPoint extends ModuleServiceEntryPoint<RemoteBillingConfig> {

    /* renamed from: a  reason: collision with root package name */
    private m f231a;
    private final q b = new q(null, null, 3, null);
    private final p c = new p(null, 1, null);
    private final BillingServiceModuleEntryPoint$configUpdateListener$1 d = new RemoteConfigUpdateListener<RemoteBillingConfig>() { // from class: io.appmetrica.analytics.billing.internal.BillingServiceModuleEntryPoint$configUpdateListener$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigUpdateListener
        public void onRemoteConfigUpdated(ModuleRemoteConfig<RemoteBillingConfig> moduleRemoteConfig) {
            m mVar;
            mVar = BillingServiceModuleEntryPoint.this.f231a;
            if (mVar != null) {
                RemoteBillingConfig featuresConfig = moduleRemoteConfig.getFeaturesConfig();
                mVar.a(featuresConfig != null ? new B(featuresConfig.getEnabled(), new A(featuresConfig.getConfig())) : null);
            }
        }
    };
    private final String e = "billing";
    private final BillingServiceModuleEntryPoint$remoteConfigExtensionConfiguration$1 f = new RemoteConfigExtensionConfiguration<RemoteBillingConfig>() { // from class: io.appmetrica.analytics.billing.internal.BillingServiceModuleEntryPoint$remoteConfigExtensionConfiguration$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public Map<String, Integer> getBlocks() {
            return MapsKt.mapOf(TuplesKt.to("aic", 1));
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public List<String> getFeatures() {
            return CollectionsKt.emptyList();
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public JsonParser<RemoteBillingConfig> getJsonParser() {
            q qVar;
            qVar = BillingServiceModuleEntryPoint.this.b;
            return qVar;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public Converter<RemoteBillingConfig, byte[]> getProtobufConverter() {
            p pVar;
            pVar = BillingServiceModuleEntryPoint.this.c;
            return pVar;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public RemoteConfigUpdateListener<RemoteBillingConfig> getRemoteConfigUpdateListener() {
            BillingServiceModuleEntryPoint$configUpdateListener$1 billingServiceModuleEntryPoint$configUpdateListener$1;
            billingServiceModuleEntryPoint$configUpdateListener$1 = BillingServiceModuleEntryPoint.this.d;
            return billingServiceModuleEntryPoint$configUpdateListener$1;
        }
    };

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public String getIdentifier() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public RemoteConfigExtensionConfiguration<RemoteBillingConfig> getRemoteConfigExtensionConfiguration() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public void initServiceSide(ServiceContext serviceContext, ModuleRemoteConfig<RemoteBillingConfig> moduleRemoteConfig) {
        RemoteBillingConfig featuresConfig = moduleRemoteConfig.getFeaturesConfig();
        m mVar = new m(serviceContext, featuresConfig != null ? new B(featuresConfig.getEnabled(), new A(featuresConfig.getConfig())) : null);
        serviceContext.getServiceModuleReporterComponentLifecycle().subscribe(mVar);
        this.f231a = mVar;
    }
}
