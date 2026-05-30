package io.appmetrica.analytics.adrevenue.other.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.ads.AdSDKNotificationManager;
import io.appmetrica.analytics.adrevenue.other.impl.d;
import io.appmetrica.analytics.adrevenue.other.impl.e;
import io.appmetrica.analytics.adrevenue.other.impl.g;
import io.appmetrica.analytics.adrevenue.other.impl.h;
import io.appmetrica.analytics.adrevenue.other.impl.i;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;
import io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueCollector;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lio/appmetrica/analytics/adrevenue/other/internal/AdRevenueOtherClientModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/client/ModuleClientEntryPoint;", "Lio/appmetrica/analytics/adrevenue/other/internal/ClientSideAdRevenueOtherConfigWrapper;", "Lio/appmetrica/analytics/modulesapi/internal/client/ClientContext;", "clientContext", "", "initClientSide", "onActivated", "", "g", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", CmcdData.STREAMING_FORMAT_HLS, "Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "getServiceConfigExtensionConfiguration", "()Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "serviceConfigExtensionConfiguration", "Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/AdRevenueCollector;", CmcdData.OBJECT_TYPE_INIT_SEGMENT, "Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/AdRevenueCollector;", "getAdRevenueCollector", "()Lio/appmetrica/analytics/modulesapi/internal/client/adrevenue/AdRevenueCollector;", "adRevenueCollector", "<init>", "()V", "ad-revenue-other_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class AdRevenueOtherClientModuleEntryPoint extends ModuleClientEntryPoint<ClientSideAdRevenueOtherConfigWrapper> {

    /* renamed from: a  reason: collision with root package name */
    private ClientContext f244a;
    private e b;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final g d = new g();
    private final d e = new d();
    private final AdRevenueOtherClientModuleEntryPoint$configUpdateListener$1 f = new ServiceConfigUpdateListener<ClientSideAdRevenueOtherConfigWrapper>() { // from class: io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherClientModuleEntryPoint$configUpdateListener$1
        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener
        public void onServiceConfigUpdated(ModuleServiceConfig<ClientSideAdRevenueOtherConfigWrapper> moduleServiceConfig) {
            AdRevenueOtherClientModuleEntryPoint adRevenueOtherClientModuleEntryPoint = AdRevenueOtherClientModuleEntryPoint.this;
            synchronized (adRevenueOtherClientModuleEntryPoint) {
                ClientSideAdRevenueOtherConfigWrapper featuresConfig = moduleServiceConfig.getFeaturesConfig();
                adRevenueOtherClientModuleEntryPoint.b = featuresConfig != null ? featuresConfig.getConfig$ad_revenue_other_release() : null;
                Unit unit = Unit.INSTANCE;
            }
            AdRevenueOtherClientModuleEntryPoint.this.a();
        }
    };
    private final String g = "ad-revenue-other";
    private final AdRevenueOtherClientModuleEntryPoint$serviceConfigExtensionConfiguration$1 h = new ServiceConfigExtensionConfiguration<ClientSideAdRevenueOtherConfigWrapper>() { // from class: io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherClientModuleEntryPoint$serviceConfigExtensionConfiguration$1
        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration
        /* renamed from: getBundleConverter */
        public BundleToServiceConfigConverter<ClientSideAdRevenueOtherConfigWrapper> getBundleConverter2() {
            d dVar;
            dVar = AdRevenueOtherClientModuleEntryPoint.this.e;
            return dVar;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration
        /* renamed from: getServiceConfigUpdateListener */
        public ServiceConfigUpdateListener<ClientSideAdRevenueOtherConfigWrapper> getServiceConfigUpdateListener2() {
            AdRevenueOtherClientModuleEntryPoint$configUpdateListener$1 adRevenueOtherClientModuleEntryPoint$configUpdateListener$1;
            adRevenueOtherClientModuleEntryPoint$configUpdateListener$1 = AdRevenueOtherClientModuleEntryPoint.this.f;
            return adRevenueOtherClientModuleEntryPoint$configUpdateListener$1;
        }
    };
    private final AdRevenueOtherClientModuleEntryPoint$adRevenueCollector$1 i = new AdRevenueCollector() { // from class: io.appmetrica.analytics.adrevenue.other.internal.AdRevenueOtherClientModuleEntryPoint$adRevenueCollector$1
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
            if (r0.get() != false) goto L10;
         */
        @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean getEnabled() {
            e eVar;
            boolean z;
            AtomicBoolean atomicBoolean;
            AdRevenueOtherClientModuleEntryPoint adRevenueOtherClientModuleEntryPoint = AdRevenueOtherClientModuleEntryPoint.this;
            synchronized (adRevenueOtherClientModuleEntryPoint) {
                eVar = adRevenueOtherClientModuleEntryPoint.b;
                if (eVar != null) {
                    z = true;
                    if (eVar.b) {
                        atomicBoolean = adRevenueOtherClientModuleEntryPoint.c;
                    }
                }
                z = false;
            }
            return z;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueCollector
        public String getSourceIdentifier() {
            return "facebook";
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        synchronized (this) {
            ClientContext clientContext = this.f244a;
            if (clientContext == null) {
                return;
            }
            e eVar = this.b;
            boolean z = eVar != null && eVar.f237a;
            boolean detectClassExists = ReflectionUtils.detectClassExists("com.facebook.ads.AdSDKNotificationManager");
            if (z && detectClassExists) {
                g gVar = this.d;
                if (gVar.f239a == null) {
                    i iVar = new i(clientContext, new h());
                    AdSDKNotificationManager.addSDKNotificationListener(iVar);
                    gVar.f239a = iVar;
                }
                this.c.set(true);
            } else {
                g gVar2 = this.d;
                i iVar2 = gVar2.f239a;
                if (iVar2 != null) {
                    AdSDKNotificationManager.removeSDKNotificationListener(iVar2);
                }
                gVar2.f239a = null;
                this.c.set(false);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public AdRevenueCollector getAdRevenueCollector() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public String getIdentifier() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public ServiceConfigExtensionConfiguration<ClientSideAdRevenueOtherConfigWrapper> getServiceConfigExtensionConfiguration() {
        return this.h;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void initClientSide(ClientContext clientContext) {
        this.f244a = clientContext;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void onActivated() {
        a();
    }
}
