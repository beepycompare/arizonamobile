package io.appmetrica.analytics.screenshot.internal;

import android.os.Bundle;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreapi.internal.data.JsonParser;
import io.appmetrica.analytics.modulesapi.internal.service.ClientConfigProvider;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleRemoteConfig;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigUpdateListener;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.screenshot.impl.N;
import io.appmetrica.analytics.screenshot.impl.O;
import io.appmetrica.analytics.screenshot.impl.P;
import io.appmetrica.analytics.screenshot.impl.Q;
import io.appmetrica.analytics.screenshot.impl.S;
import io.appmetrica.analytics.screenshot.impl.T;
import io.appmetrica.analytics.screenshot.impl.U;
import io.appmetrica.analytics.screenshot.internal.ServiceSideScreenshotConfigWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005H\u0016R\u001a\u0010\u000e\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/appmetrica/analytics/screenshot/internal/ScreenshotServiceModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleServiceEntryPoint;", "Lio/appmetrica/analytics/screenshot/internal/ServiceSideScreenshotConfigWrapper;", "Lio/appmetrica/analytics/modulesapi/internal/service/ServiceContext;", "serviceContext", "Lio/appmetrica/analytics/modulesapi/internal/service/ModuleRemoteConfig;", "initialConfig", "", "initServiceSide", "", "f", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "g", "Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "getRemoteConfigExtensionConfiguration", "()Lio/appmetrica/analytics/modulesapi/internal/service/RemoteConfigExtensionConfiguration;", "remoteConfigExtensionConfiguration", "Lio/appmetrica/analytics/modulesapi/internal/service/ClientConfigProvider;", CmcdData.STREAMING_FORMAT_HLS, "Lio/appmetrica/analytics/modulesapi/internal/service/ClientConfigProvider;", "getClientConfigProvider", "()Lio/appmetrica/analytics/modulesapi/internal/service/ClientConfigProvider;", "clientConfigProvider", "<init>", "()V", "screenshot_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class ScreenshotServiceModuleEntryPoint extends ModuleServiceEntryPoint<ServiceSideScreenshotConfigWrapper> {

    /* renamed from: a  reason: collision with root package name */
    private P f1468a;
    private final T b = new T();
    private final S c = new S(null, 1, null);
    private final Q d = new Q(null, 1, null);
    private final ScreenshotServiceModuleEntryPoint$configUpdateListener$1 e = new RemoteConfigUpdateListener<ServiceSideScreenshotConfigWrapper>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint$configUpdateListener$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigUpdateListener
        public void onRemoteConfigUpdated(ModuleRemoteConfig<ServiceSideScreenshotConfigWrapper> moduleRemoteConfig) {
            ScreenshotServiceModuleEntryPoint screenshotServiceModuleEntryPoint = ScreenshotServiceModuleEntryPoint.this;
            ServiceSideScreenshotConfigWrapper featuresConfig = moduleRemoteConfig.getFeaturesConfig();
            screenshotServiceModuleEntryPoint.f1468a = featuresConfig != null ? featuresConfig.getConfig$screenshot_release() : null;
        }
    };
    private final String f = "screenshot";
    private final ScreenshotServiceModuleEntryPoint$remoteConfigExtensionConfiguration$1 g = new RemoteConfigExtensionConfiguration<ServiceSideScreenshotConfigWrapper>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint$remoteConfigExtensionConfiguration$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public Map<String, Integer> getBlocks() {
            return MapsKt.mapOf(TuplesKt.to("scr", 1));
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public List<String> getFeatures() {
            return CollectionsKt.listOf("scr");
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public JsonParser<ServiceSideScreenshotConfigWrapper> getJsonParser() {
            S s;
            s = ScreenshotServiceModuleEntryPoint.this.c;
            return s;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public Converter<ServiceSideScreenshotConfigWrapper, byte[]> getProtobufConverter() {
            final ScreenshotServiceModuleEntryPoint screenshotServiceModuleEntryPoint = ScreenshotServiceModuleEntryPoint.this;
            return new Converter<ServiceSideScreenshotConfigWrapper, byte[]>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint$remoteConfigExtensionConfiguration$1$getProtobufConverter$1
                @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
                public byte[] fromModel(ServiceSideScreenshotConfigWrapper serviceSideScreenshotConfigWrapper) {
                    Q q;
                    q = ScreenshotServiceModuleEntryPoint.this.d;
                    return MessageNano.toByteArray(q.f1441a.fromModel(serviceSideScreenshotConfigWrapper.getConfig$screenshot_release()));
                }

                @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
                public ServiceSideScreenshotConfigWrapper toModel(byte[] bArr) {
                    Q q;
                    ServiceSideScreenshotConfigWrapper.Companion companion = ServiceSideScreenshotConfigWrapper.Companion;
                    q = ScreenshotServiceModuleEntryPoint.this.d;
                    return companion.toWrapper$screenshot_release(q.toModel(bArr));
                }
            };
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigExtensionConfiguration
        public RemoteConfigUpdateListener<ServiceSideScreenshotConfigWrapper> getRemoteConfigUpdateListener() {
            ScreenshotServiceModuleEntryPoint$configUpdateListener$1 screenshotServiceModuleEntryPoint$configUpdateListener$1;
            screenshotServiceModuleEntryPoint$configUpdateListener$1 = ScreenshotServiceModuleEntryPoint.this.e;
            return screenshotServiceModuleEntryPoint$configUpdateListener$1;
        }
    };
    private final ScreenshotServiceModuleEntryPoint$clientConfigProvider$1 h = new ClientConfigProvider() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotServiceModuleEntryPoint$clientConfigProvider$1
        @Override // io.appmetrica.analytics.modulesapi.internal.service.ClientConfigProvider
        public Bundle getConfigBundleForClient() {
            T t;
            P p;
            t = ScreenshotServiceModuleEntryPoint.this.b;
            p = ScreenshotServiceModuleEntryPoint.this.f1468a;
            t.getClass();
            if (p == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", p.f1440a);
            N n = p.b;
            if (n != null) {
                bundle.putBoolean("api_captor_enabled", n.f1438a);
            }
            U u = p.c;
            if (u != null) {
                bundle.putBoolean("service_captor_enabled", u.f1443a);
                bundle.putLong("service_captor_delay_seconds", u.b);
            }
            O o = p.d;
            if (o != null) {
                bundle.putBoolean("content_observer_enabled", o.f1439a);
                bundle.putStringArrayList("content_observer_media_store_column_names", new ArrayList<>(o.b));
                bundle.putLong("content_observer_detect_window_seconds", o.c);
            }
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
    public RemoteConfigExtensionConfiguration<ServiceSideScreenshotConfigWrapper> getRemoteConfigExtensionConfiguration() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceEntryPoint
    public void initServiceSide(ServiceContext serviceContext, ModuleRemoteConfig<ServiceSideScreenshotConfigWrapper> moduleRemoteConfig) {
        ServiceSideScreenshotConfigWrapper featuresConfig = moduleRemoteConfig.getFeaturesConfig();
        this.f1468a = featuresConfig != null ? featuresConfig.getConfig$screenshot_release() : null;
    }
}
