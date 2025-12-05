package io.appmetrica.analytics.screenshot.internal;

import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.modulesapi.internal.client.BundleToServiceConfigConverter;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint;
import io.appmetrica.analytics.modulesapi.internal.client.ModuleServiceConfig;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration;
import io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener;
import io.appmetrica.analytics.screenshot.impl.C0765h;
import io.appmetrica.analytics.screenshot.impl.C0769l;
import io.appmetrica.analytics.screenshot.impl.C0770m;
import io.appmetrica.analytics.screenshot.impl.C0779w;
import io.appmetrica.analytics.screenshot.impl.C0780x;
import io.appmetrica.analytics.screenshot.impl.D;
import io.appmetrica.analytics.screenshot.impl.F;
import io.appmetrica.analytics.screenshot.impl.I;
import io.appmetrica.analytics.screenshot.impl.InterfaceC0766i;
import io.appmetrica.analytics.screenshot.impl.T;
import io.appmetrica.analytics.screenshot.impl.V;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lio/appmetrica/analytics/screenshot/internal/ScreenshotClientModuleEntryPoint;", "Lio/appmetrica/analytics/modulesapi/internal/client/ModuleClientEntryPoint;", "Lio/appmetrica/analytics/screenshot/impl/D;", "Lio/appmetrica/analytics/modulesapi/internal/client/ClientContext;", "clientContext", "", "initClientSide", "onActivated", "", "e", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "identifier", "Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "f", "Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "getServiceConfigExtensionConfiguration", "()Lio/appmetrica/analytics/modulesapi/internal/client/ServiceConfigExtensionConfiguration;", "serviceConfigExtensionConfiguration", "<init>", "()V", "screenshot_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class ScreenshotClientModuleEntryPoint extends ModuleClientEntryPoint<D> {

    /* renamed from: a  reason: collision with root package name */
    private C0769l f1467a;
    private V d;
    private final C0765h b = new C0765h();
    private final ScreenshotClientModuleEntryPoint$configUpdateListener$1 c = new ServiceConfigUpdateListener<D>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint$configUpdateListener$1
        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigUpdateListener
        public void onServiceConfigUpdated(ModuleServiceConfig<D> moduleServiceConfig) {
            C0769l c0769l;
            V v;
            V v2;
            C0769l c0769l2;
            ScreenshotClientModuleEntryPoint screenshotClientModuleEntryPoint = ScreenshotClientModuleEntryPoint.this;
            synchronized (screenshotClientModuleEntryPoint) {
                D featuresConfig = moduleServiceConfig.getFeaturesConfig();
                V v3 = null;
                if (featuresConfig != null) {
                    boolean b = featuresConfig.b();
                    F a2 = featuresConfig.a();
                    c0769l = new C0769l(b, a2 != null ? new C0770m(a2) : null);
                } else {
                    c0769l = null;
                }
                screenshotClientModuleEntryPoint.f1467a = c0769l;
                v = screenshotClientModuleEntryPoint.d;
                if (v != null) {
                    v2 = screenshotClientModuleEntryPoint.d;
                    if (v2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("screenshotCaptorsController");
                    } else {
                        v3 = v2;
                    }
                    c0769l2 = screenshotClientModuleEntryPoint.f1467a;
                    v3.a(c0769l2);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    };
    private final String e = "screenshot";
    private final ScreenshotClientModuleEntryPoint$serviceConfigExtensionConfiguration$1 f = new ServiceConfigExtensionConfiguration<D>() { // from class: io.appmetrica.analytics.screenshot.internal.ScreenshotClientModuleEntryPoint$serviceConfigExtensionConfiguration$1
        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration
        public BundleToServiceConfigConverter<D> getBundleConverter() {
            C0765h c0765h;
            c0765h = ScreenshotClientModuleEntryPoint.this.b;
            return c0765h;
        }

        @Override // io.appmetrica.analytics.modulesapi.internal.client.ServiceConfigExtensionConfiguration
        public ServiceConfigUpdateListener<D> getServiceConfigUpdateListener() {
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
    public ServiceConfigExtensionConfiguration<D> getServiceConfigExtensionConfiguration() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void initClientSide(ClientContext clientContext) {
        InterfaceC0766i i;
        synchronized (this) {
            C0780x c0780x = new C0780x(clientContext);
            if (AndroidUtils.isApiAchieved(34)) {
                i = new C0779w(clientContext, c0780x);
            } else {
                i = new I(clientContext, c0780x);
            }
            this.d = new V(i);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.client.ModuleClientEntryPoint
    public void onActivated() {
        synchronized (this) {
            V v = this.d;
            if (v != null) {
                if (v == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("screenshotCaptorsController");
                    v = null;
                }
                C0769l c0769l = this.f1467a;
                for (T t : v.f1433a) {
                    t.a();
                }
                v.a(c0769l);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
