package io.appmetrica.analytics.idsync.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.idsync.internal.model.IdSyncConfig;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceContext;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final ServiceContext f465a;
    public final IHandlerExecutor c;
    public final p d;
    public volatile IdSyncConfig e;
    public volatile boolean f;
    public final long b = TimeUnit.MINUTES.toMillis(1);
    public final f g = new f(this);

    public h(ServiceContext serviceContext) {
        this.f465a = serviceContext;
        this.c = serviceContext.getExecutorProvider().getModuleExecutor();
        this.d = new p(serviceContext, new B(serviceContext.getServiceStorageProvider().modulePreferences("id-sync")));
    }

    public static boolean a(IdSyncConfig idSyncConfig) {
        idSyncConfig.getEnabled();
        return idSyncConfig.getEnabled() && !idSyncConfig.getRequests().isEmpty();
    }

    public final synchronized void b(IdSyncConfig idSyncConfig) {
        if (!Intrinsics.areEqual(this.e, idSyncConfig)) {
            this.e = idSyncConfig;
            if (a(idSyncConfig) && !this.f) {
                this.f465a.getActivationBarrier().subscribe(idSyncConfig.getLaunchDelay(), this.c, new g(this));
                this.f = true;
            } else if (!a(idSyncConfig) && this.f) {
                this.f = false;
                IHandlerExecutor iHandlerExecutor = this.c;
                f fVar = this.g;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncRunnable");
                    fVar = null;
                }
                iHandlerExecutor.remove(fVar);
            }
        }
    }
}
