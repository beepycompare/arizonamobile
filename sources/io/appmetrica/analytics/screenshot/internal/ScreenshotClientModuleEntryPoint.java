package io.appmetrica.analytics.screenshot.internal;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener;
import io.appmetrica.analytics.screenshot.impl.B;
import io.appmetrica.analytics.screenshot.impl.C0785g;
import io.appmetrica.analytics.screenshot.impl.C0789k;
import io.appmetrica.analytics.screenshot.impl.C0797t;
import io.appmetrica.analytics.screenshot.impl.C0798u;
import io.appmetrica.analytics.screenshot.impl.D;
import io.appmetrica.analytics.screenshot.impl.InterfaceC0786h;
import io.appmetrica.analytics.screenshot.impl.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lio/appmetrica/analytics/screenshot/internal/ScreenshotClientModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/client/ModuleClientEntryPoint;", "Lio/appmetrica/analytics/screenshot/internal/ClientSideScreenshotConfigWrapper;", "Lio/appmetrica/analytics/modulesapi/internal/client/ClientContext;", "clientContext", "", "initClientSide", "onActivated", "", "e", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "f", "Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "getServiceConfigExtensionConfiguration", "()Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "serviceConfigExtensionConfiguration", "<init>", "()V", "screenshot_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class ScreenshotClientModuleEntryPoint extends ModuleClientEntryPoint<ClientSideScreenshotConfigWrapper> {

    /* renamed from: a  reason: collision with root package name */
    private C0789k f1466a;
    private D d;
    private final C0785g b = new C0785g();
    private final ScreenshotClientModuleEntryPoint$configUpdateListener$1 c = new ServiceConfigUpdateListener<ClientSideScreenshotConfigWrapper>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint$configUpdateListener$1
        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener
        public void onServiceConfigUpdated(ModuleServiceConfig<ClientSideScreenshotConfigWrapper> moduleServiceConfig) {
            D d;
            D d2;
            C0789k c0789k;
            ScreenshotClientModuleEntryPoint screenshotClientModuleEntryPoint = ScreenshotClientModuleEntryPoint.this;
            synchronized (screenshotClientModuleEntryPoint) {
                ClientSideScreenshotConfigWrapper featuresConfig = moduleServiceConfig.getFeaturesConfig();
                screenshotClientModuleEntryPoint.f1466a = featuresConfig != null ? featuresConfig.getConfig$screenshot_release() : null;
                d = screenshotClientModuleEntryPoint.d;
                if (d != null) {
                    d2 = screenshotClientModuleEntryPoint.d;
                    if (d2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("screenshotCaptorsController");
                        d2 = null;
                    }
                    c0789k = screenshotClientModuleEntryPoint.f1466a;
                    for (B b : d2.f1431a) {
                        b.a((c0789k == null || !Boolean.valueOf(c0789k.f1451a).booleanValue()) ? null : c0789k);
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    };
    private final String e = "screenshot";
    private final ScreenshotClientModuleEntryPoint$serviceConfigExtensionConfiguration$1 f = new ServiceConfigExtensionConfiguration<ClientSideScreenshotConfigWrapper>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint$serviceConfigExtensionConfiguration$1
        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration
        public BundleToServiceConfigConverter<ClientSideScreenshotConfigWrapper> getBundleConverter() {
            C0785g c0785g;
            c0785g = ScreenshotClientModuleEntryPoint.this.b;
            return c0785g;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration
        public ServiceConfigUpdateListener<ClientSideScreenshotConfigWrapper> getServiceConfigUpdateListener() {
            ScreenshotClientModuleEntryPoint$configUpdateListener$1 screenshotClientModuleEntryPoint$configUpdateListener$1;
            screenshotClientModuleEntryPoint$configUpdateListener$1 = ScreenshotClientModuleEntryPoint.this.c;
            return screenshotClientModuleEntryPoint$configUpdateListener$1;
        }
    };

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public String getIdentifier() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public ServiceConfigExtensionConfiguration<ClientSideScreenshotConfigWrapper> getServiceConfigExtensionConfiguration() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void initClientSide(ClientContext clientContext) {
        InterfaceC0786h vVar;
        synchronized (this) {
            C0798u c0798u = new C0798u(clientContext);
            if (AndroidUtils.isApiAchieved(34)) {
                vVar = new C0797t(clientContext, c0798u);
            } else {
                vVar = new v(clientContext, c0798u);
            }
            this.d = new D(vVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void onActivated() {
        synchronized (this) {
            D d = this.d;
            if (d != null) {
                C0789k c0789k = this.f1466a;
                for (B b : d.f1431a) {
                    b.a();
                }
                for (B b2 : d.f1431a) {
                    b2.a((c0789k == null || !Boolean.valueOf(c0789k.f1451a).booleanValue()) ? null : c0789k);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
