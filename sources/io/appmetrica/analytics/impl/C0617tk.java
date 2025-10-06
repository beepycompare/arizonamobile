package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreapi.internal.crypto.CryptoProvider;
import io.appmetrica.analytics.coreapi.internal.identifiers.PlatformIdentifiers;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.ActivationBarrier;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.FirstExecutionConditionService;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.SdkEnvironmentProvider;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.applicationstate.ApplicationStateProvider;
import io.appmetrica.analytics.coreapi.internal.servicecomponents.batteryinfo.ChargeTypeProvider;
import io.appmetrica.analytics.coreapi.internal.system.PermissionExtractor;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import io.appmetrica.analytics.modulesapi.internal.common.ModuleSelfReporter;
import io.appmetrica.analytics.modulesapi.internal.service.LocationServiceApi;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceNetworkContext;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
/* renamed from: io.appmetrica.analytics.impl.tk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0617tk implements ServiceContext {

    /* renamed from: a  reason: collision with root package name */
    public final ModuleServiceLifecycleController f1099a;
    public final C0460ne b = new C0460ne(getContext());
    public final C0760zd c = new C0760zd();
    public final Mk d = new Mk(getContext(), new Lk(new U1()));
    public final Ik e = new Ik(getContext(), Na.j().x(), C0729y7.a(getContext()).h());
    public final Y9 f = new Y9();
    public final O6 g = new O6();

    public C0617tk(ModuleServiceLifecycleController moduleServiceLifecycleController) {
        this.f1099a = moduleServiceLifecycleController;
    }

    public final C0460ne a() {
        return this.b;
    }

    public final C0760zd b() {
        return this.c;
    }

    public final Ik c() {
        return this.e;
    }

    public final Mk d() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ActivationBarrier getActivationBarrier() {
        return Na.F.B.getActivationBarrier();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ApplicationStateProvider getApplicationStateProvider() {
        return Na.F.k().b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ChargeTypeProvider getChargeTypeProvider() {
        C0294h3 c0294h3;
        Na na = Na.F;
        C0294h3 c0294h32 = na.e;
        if (c0294h32 == null) {
            synchronized (na) {
                c0294h3 = na.e;
                if (c0294h3 == null) {
                    c0294h3 = new C0294h3(na.d.a(), na.k().f877a);
                    na.e = c0294h3;
                }
            }
            return c0294h3;
        }
        return c0294h32;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final Context getContext() {
        return Na.F.f594a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final CryptoProvider getCryptoProvider() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final DataSendingRestrictionController getDataSendingRestrictionController() {
        return Na.F.g();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ExecutorProvider getExecutorProvider() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final FirstExecutionConditionService getFirstExecutionConditionService() {
        return Na.F.B.getFirstExecutionService();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final LocationServiceApi getLocationServiceApi() {
        return Na.F.l();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ModuleServiceLifecycleController getModuleServiceLifecycleController() {
        return this.f1099a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ServiceNetworkContext getNetworkContext() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final PermissionExtractor getPermissionExtractor() {
        return Na.F.i();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final PlatformIdentifiers getPlatformIdentifiers() {
        return Na.F.r();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final SdkEnvironmentProvider getSdkEnvironmentProvider() {
        return Na.F.u();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ModuleSelfReporter getSelfReporter() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ServiceStorageProvider getServiceStorageProvider() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ServiceWakeLock getServiceWakeLock() {
        return this.d;
    }
}
