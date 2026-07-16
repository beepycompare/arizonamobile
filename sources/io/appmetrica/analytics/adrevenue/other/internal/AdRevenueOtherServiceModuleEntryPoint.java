package io.appmetrica.analytics.adrevenue.other.internal;

import android.os.Bundle;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.adrevenue.other.impl.j;
import io.appmetrica.analytics.adrevenue.other.impl.k;
import io.appmetrica.analytics.adrevenue.other.impl.l;
import io.appmetrica.analytics.adrevenue.other.impl.m;
import io.appmetrica.analytics.adrevenue.other.internal.ServiceSideAdRevenueOtherConfigWrapper;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.modulesapi.internal.service.ClientConfigProvider;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigUpdateListener;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/appmetrica/analytics/adrevenue/other/internal/AdRevenueOtherServiceModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleServiceEntryPoint;", "Lio/appmetrica/analytics/adrevenue/other/internal/ServiceSideAdRevenueOtherConfigWrapper;", "Lio/appmetrica/analytics/modulesapi/internal/service/ServiceContext;", "serviceContext", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleRemoteConfig;", "initialConfig", "", "initServiceSide", "", "f", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "g", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "getRemoteConfigExtensionConfiguration", "()Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "remoteConfigExtensionConfiguration", "Lio/appmetrica/analytics/modulesapi/internal/service/ClientConfigProvider;", CmcdData.STREAMING_FORMAT_HLS, "Lio/appmetrica/analytics/modulesapi/internal/service/ClientConfigProvider;", "getClientConfigProvider", "()Lio/appmetrica/analytics/modulesapi/internal/service/ClientConfigProvider;", "clientConfigProvider", "<init>", "()V", "ad-revenue-other_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class AdRevenueOtherServiceModuleEntryPoint extends ModuleServiceEntryPoint<ServiceSideAdRevenueOtherConfigWrapper> {

    /* renamed from: a  reason: collision with root package name */
    private j f250a;
    private final m b = new m();
    private final l c = new l(null, 1, null);
    private final k d = new k(null, 1, null);
    private final AdRevenueOtherServiceModuleEntryPoint$configUpdateListener$1 e = new RemoteConfigUpdateListener<ServiceSideAdRevenueOtherConfigWrapper>() { // from class: io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherServiceModuleEntryPoint$configUpdateListener$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigUpdateListener
        public void onRemoteConfigUpdated(ModuleRemoteConfig<ServiceSideAdRevenueOtherConfigWrapper> moduleRemoteConfig) {
            AdRevenueOtherServiceModuleEntryPoint adRevenueOtherServiceModuleEntryPoint = AdRevenueOtherServiceModuleEntryPoint.this;
            ServiceSideAdRevenueOtherConfigWrapper featuresConfig = moduleRemoteConfig.getFeaturesConfig();
            adRevenueOtherServiceModuleEntryPoint.f250a = featuresConfig != null ? featuresConfig.getConfig$ad_revenue_other_release() : null;
        }
    };
    private final String f = "ad-revenue-other";
    private final AdRevenueOtherServiceModuleEntryPoint$remoteConfigExtensionConfiguration$1 g = new RemoteConfigExtensionConfiguration<ServiceSideAdRevenueOtherConfigWrapper>() { // from class: io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherServiceModuleEntryPoint$remoteConfigExtensionConfiguration$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public Map<String, Integer> getBlocks() {
            return MapsKt.emptyMap();
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public List<String> getFeatures() {
            return CollectionsKt.listOf((Object[]) new String[]{"aro", "arois"});
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public JsonParser<ServiceSideAdRevenueOtherConfigWrapper> getJsonParser() {
            l lVar;
            lVar = AdRevenueOtherServiceModuleEntryPoint.this.c;
            return lVar;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public Converter<ServiceSideAdRevenueOtherConfigWrapper, byte[]> getProtobufConverter() {
            final AdRevenueOtherServiceModuleEntryPoint adRevenueOtherServiceModuleEntryPoint = AdRevenueOtherServiceModuleEntryPoint.this;
            return new Converter<ServiceSideAdRevenueOtherConfigWrapper, byte[]>() { // from class: io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherServiceModuleEntryPoint$remoteConfigExtensionConfiguration$1$getProtobufConverter$1
                @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
                public byte[] fromModel(ServiceSideAdRevenueOtherConfigWrapper serviceSideAdRevenueOtherConfigWrapper) {
                    k kVar;
                    kVar = AdRevenueOtherServiceModuleEntryPoint.this.d;
                    return MessageNano.toByteArray(kVar.f244a.fromModel(serviceSideAdRevenueOtherConfigWrapper.getConfig$ad_revenue_other_release()));
                }

                @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
                public ServiceSideAdRevenueOtherConfigWrapper toModel(byte[] bArr) {
                    k kVar;
                    ServiceSideAdRevenueOtherConfigWrapper.Companion companion = ServiceSideAdRevenueOtherConfigWrapper.Companion;
                    kVar = AdRevenueOtherServiceModuleEntryPoint.this.d;
                    return companion.toWrapper$ad_revenue_other_release(kVar.toModel(bArr));
                }
            };
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        /* renamed from: getRemoteConfigUpdateListener */
        public RemoteConfigUpdateListener<ServiceSideAdRevenueOtherConfigWrapper> getRemoteConfigUpdateListener2() {
            AdRevenueOtherServiceModuleEntryPoint$configUpdateListener$1 adRevenueOtherServiceModuleEntryPoint$configUpdateListener$1;
            adRevenueOtherServiceModuleEntryPoint$configUpdateListener$1 = AdRevenueOtherServiceModuleEntryPoint.this.e;
            return adRevenueOtherServiceModuleEntryPoint$configUpdateListener$1;
        }
    };
    private final AdRevenueOtherServiceModuleEntryPoint$clientConfigProvider$1 h = new ClientConfigProvider() { // from class: io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherServiceModuleEntryPoint$clientConfigProvider$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.ClientConfigProvider
        public Bundle getConfigBundleForClient() {
            m mVar;
            j jVar;
            mVar = AdRevenueOtherServiceModuleEntryPoint.this.b;
            jVar = AdRevenueOtherServiceModuleEntryPoint.this.f250a;
            mVar.getClass();
            if (jVar == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", jVar.f243a);
            bundle.putBoolean("include_source", jVar.b);
            return bundle;
        }
    };

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public ClientConfigProvider getClientConfigProvider() {
        return this.h;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public String getIdentifier() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public RemoteConfigExtensionConfiguration<ServiceSideAdRevenueOtherConfigWrapper> getRemoteConfigExtensionConfiguration() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public void initServiceSide(ServiceContext serviceContext, ModuleRemoteConfig<ServiceSideAdRevenueOtherConfigWrapper> moduleRemoteConfig) {
        ServiceSideAdRevenueOtherConfigWrapper featuresConfig = moduleRemoteConfig.getFeaturesConfig();
        this.f250a = featuresConfig != null ? featuresConfig.getConfig$ad_revenue_other_release() : null;
    }
}
