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
/* renamed from: io.appmetrica.analytics.impl.hk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0314hk implements ServiceContext {

    /* renamed from: a  reason: collision with root package name */
    public final ModuleServiceLifecycleController f869a;
    public final C0258fe b = new C0258fe(getContext());
    public final C0580sd c = new C0580sd();
    public final Ak d = new Ak(getContext(), new C0762zk(new S1()));
    public final C0687wk e = new C0687wk(getContext(), Ga.j().x(), C0549r7.a(getContext()).h());
    public final R9 f = new R9();
    public final I6 g = new I6();

    public C0314hk(ModuleServiceLifecycleController moduleServiceLifecycleController) {
        this.f869a = moduleServiceLifecycleController;
    }

    public final C0258fe a() {
        return this.b;
    }

    public final C0580sd b() {
        return this.c;
    }

    public final C0687wk c() {
        return this.e;
    }

    public final Ak d() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ActivationBarrier getActivationBarrier() {
        return Ga.F.B.getActivationBarrier();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ApplicationStateProvider getApplicationStateProvider() {
        return Ga.F.k().b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ChargeTypeProvider getChargeTypeProvider() {
        C0222e3 c0222e3;
        Ga ga = Ga.F;
        C0222e3 c0222e32 = ga.e;
        if (c0222e32 == null) {
            synchronized (ga) {
                c0222e3 = ga.e;
                if (c0222e3 == null) {
                    c0222e3 = new C0222e3(ga.d.a(), ga.k().f720a);
                    ga.e = c0222e3;
                }
            }
            return c0222e3;
        }
        return c0222e32;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final Context getContext() {
        return Ga.F.f444a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final CryptoProvider getCryptoProvider() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final DataSendingRestrictionController getDataSendingRestrictionController() {
        return Ga.F.g();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ExecutorProvider getExecutorProvider() {
        return this.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final FirstExecutionConditionService getFirstExecutionConditionService() {
        return Ga.F.B.getFirstExecutionService();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final LocationServiceApi getLocationServiceApi() {
        return Ga.F.l();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ModuleServiceLifecycleController getModuleServiceLifecycleController() {
        return this.f869a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final ServiceNetworkContext getNetworkContext() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final PermissionExtractor getPermissionExtractor() {
        return Ga.F.i();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final PlatformIdentifiers getPlatformIdentifiers() {
        return Ga.F.r();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceContext
    public final SdkEnvironmentProvider getSdkEnvironmentProvider() {
        return Ga.F.u();
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
