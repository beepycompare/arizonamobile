package io.appmetrica.analytics.screenshot.internal;

import io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener;
import io.appmetrica.analytics.screenshot.impl.B;
import io.appmetrica.analytics.screenshot.impl.C0769d;
import io.appmetrica.analytics.screenshot.impl.C0773h;
import io.appmetrica.analytics.screenshot.impl.C0776k;
import io.appmetrica.analytics.screenshot.impl.C0777l;
import io.appmetrica.analytics.screenshot.impl.C0785u;
import io.appmetrica.analytics.screenshot.impl.C0786v;
import io.appmetrica.analytics.screenshot.impl.D;
import io.appmetrica.analytics.screenshot.impl.P;
import io.appmetrica.analytics.screenshot.impl.S;
import io.appmetrica.analytics.screenshot.impl.d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lio/appmetrica/analytics/screenshot/internal/ScreenshotClientModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/client/ModuleClientEntryPoint;", "Lio/appmetrica/analytics/screenshot/impl/B;", "Lio/appmetrica/analytics/modulesapi/internal/client/ClientContext;", "clientContext", "", "initClientSide", "onActivated", "", "e", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "f", "Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "getServiceConfigExtensionConfiguration", "()Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "serviceConfigExtensionConfiguration", "<init>", "()V", "screenshot_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class ScreenshotClientModuleEntryPoint extends ModuleClientEntryPoint<B> {

    /* renamed from: a  reason: collision with root package name */
    private C0776k f1316a;
    private S d;
    private final C0773h b = new C0773h();
    private final ScreenshotClientModuleEntryPoint$configUpdateListener$1 c = new ServiceConfigUpdateListener<B>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint$configUpdateListener$1
        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener
        public void onServiceConfigUpdated(ModuleServiceConfig<B> moduleServiceConfig) {
            C0776k c0776k;
            S s;
            S s2;
            C0776k c0776k2;
            ScreenshotClientModuleEntryPoint screenshotClientModuleEntryPoint = ScreenshotClientModuleEntryPoint.this;
            synchronized (screenshotClientModuleEntryPoint) {
                B featuresConfig = moduleServiceConfig.getFeaturesConfig();
                S s3 = null;
                if (featuresConfig != null) {
                    boolean b = featuresConfig.b();
                    D a2 = featuresConfig.a();
                    c0776k = new C0776k(b, a2 != null ? new C0777l(a2) : null);
                } else {
                    c0776k = null;
                }
                screenshotClientModuleEntryPoint.f1316a = c0776k;
                s = screenshotClientModuleEntryPoint.d;
                if (s != null) {
                    s2 = screenshotClientModuleEntryPoint.d;
                    if (s2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("screenshotCaptorsController");
                    } else {
                        s3 = s2;
                    }
                    c0776k2 = screenshotClientModuleEntryPoint.f1316a;
                    s3.a(c0776k2);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    };
    private final String e = "screenshot";
    private final ScreenshotClientModuleEntryPoint$serviceConfigExtensionConfiguration$1 f = new ServiceConfigExtensionConfiguration<B>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint$serviceConfigExtensionConfiguration$1
        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration
        public BundleToServiceConfigConverter<B> getBundleConverter() {
            C0773h c0773h;
            c0773h = ScreenshotClientModuleEntryPoint.this.b;
            return c0773h;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration
        public ServiceConfigUpdateListener<B> getServiceConfigUpdateListener() {
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
    public ServiceConfigExtensionConfiguration<B> getServiceConfigExtensionConfiguration() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void initClientSide(ClientContext clientContext) {
        synchronized (this) {
            C0786v c0786v = new C0786v(clientContext);
            this.d = new S(CollectionsKt.listOf((Object[]) new P[]{new C0769d(clientContext, c0786v), new d0(clientContext, c0786v), new C0785u(clientContext, c0786v)}));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void onActivated() {
        synchronized (this) {
            S s = this.d;
            if (s != null) {
                if (s == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("screenshotCaptorsController");
                    s = null;
                }
                C0776k c0776k = this.f1316a;
                for (P p : s.f1282a) {
                    p.a();
                }
                s.a(c0776k);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
